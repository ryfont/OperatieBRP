/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.web;

import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import nl.bzk.brp.binding.BRPBericht;
import nl.bzk.brp.binding.BerichtResultaat;
import nl.bzk.brp.binding.Melding;
import nl.bzk.brp.business.dto.BerichtContext;
import nl.bzk.brp.business.service.AuthenticatieService;
import nl.bzk.brp.business.service.BerichtVerwerker;
import nl.bzk.brp.model.gedeeld.Partij;
import nl.bzk.brp.model.operationeel.aut.PersistentAuthenticatieMiddel;
import nl.bzk.brp.web.interceptor.ArchiveringBericht;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.ws.security.WSSecurityEngineResult;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.util.ReflectionTestUtils;

/** Unit Test class voor het testen van de methodes in de {@link AbstractWebService} class. */
public abstract class AbstractWebServiceTest<T extends BRPBericht> {

    private static final PhaseInterceptorChain INTERCEPTOR_CHAIN = new PhaseInterceptorChain(new TreeSet<Phase>());

    @Mock
    private Message                 message;
    @Mock
    private WebServiceContext       wsContext;
    @Mock
    private AuthenticatieService    authenticatieService;
    @Mock
    private BerichtVerwerker        berichtVerwerker;

    private AbstractWebService<T>   webService;
    private T                       bericht;

    /**
     * Retourneert een nieuwe (reeds geconfigureerde) instantie van de webservice die getest moet worden.
     *
     * @return een nieuwe (reeds geconfigureerde) instantie van de webservice die getest moet worden.
     */
    protected abstract AbstractWebService<T> getNieuweWebServiceVoorTest();

    /**
     * Retourneert de class van het bericht dat door de webservice verwerkt wordt.
     *
     * @return de class van het bericht dat door de webservice verwerkt wordt.
     */
    protected abstract Class<T> getNieuwBerichtClassVoorTest();

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);

        setBericht(Mockito.mock(getNieuwBerichtClassVoorTest()));
        initWebService(getNieuweWebServiceVoorTest());
        initBerichtArchiveringIds(true);
        initBericht(true);
        initBerichtVerwerker(new ArrayList<Melding>());
        initWSContext(true, true);
        initAuthenticatieService(1);
    }

    /**
     * Initialiseert de webservice zelf door de normaliter geinjecteerde velden te zetten.
     *
     * @param ws de webservice die getest moet worden.
     */
    protected void initWebService(final AbstractWebService<T> ws) {
        this.setWebService(ws);

        ReflectionTestUtils.setField(ws, "authenticatieService", getAuthenticatieService());
        ReflectionTestUtils.setField(ws, "wsContext", getWsContext());
    }

    /**
     * Initialiseert de CXF Message mock en zet daarin de berichtarchiverings ids, afhankelijk van opgegeven parameter.
     *
     * @param heeftArchiveringIds bepaalt of de archivering ids <code>null</code> zijn of niet.
     */
    protected void initBerichtArchiveringIds(final boolean heeftArchiveringIds) {
        ThreadLocal<Message> messages =
            (ThreadLocal<Message>) ReflectionTestUtils.getField(INTERCEPTOR_CHAIN, "CURRENT_MESSAGE");
        messages.set(getMessage());
        Exchange exchange = Mockito.mock(Exchange.class);
        Mockito.when(getMessage().getExchange()).thenReturn(exchange);

        Long inId = null;
        Long uitId = null;
        if (heeftArchiveringIds) {
            inId = 1L;
            uitId = 2L;
        }
        Mockito.when(exchange.get(ArchiveringBericht.BERICHT_ARCHIVERING_IN_ID)).thenReturn(inId);
        Mockito.when(exchange.get(ArchiveringBericht.BERICHT_ARCHIVERING_UIT_ID)).thenReturn(uitId);
    }

    /**
     * Initialiseert de mock van het bericht door de partij id van het bericht te configureren op basis van parameter.
     *
     * @param heeftPartijId bepaalt of er een geldige partij id wordt geretourneerd of <code>null</code>.
     */
    protected void initBericht(final boolean heeftPartijId) {
        Integer partijId = null;
        if (heeftPartijId) {
            partijId = 3;
        }

        Mockito.when(getBericht().getPartijId()).thenReturn(partijId);
    }

    /**
     * Initialiseert de mock van de berichtenverwerker service en zet de meldingen die in het te retourneren resultaat
     * moeten zitten.
     *
     * @param meldingen de meldingen die door de berichtverwerker geretourneerd dienen te worden.
     */
    protected void initBerichtVerwerker(final List<Melding> meldingen) {
        Mockito.doAnswer(new Answer<Void>() {
            @Override
            public Void answer(final InvocationOnMock invocationOnMock) throws Throwable {
                Object[] args = invocationOnMock.getArguments();
                ((BerichtResultaat) args[2]).voegMeldingenToe(meldingen);
                return null;
            }
        }).when(getBerichtVerwerker()).verwerkBericht(Mockito.any(BRPBericht.class), Mockito.any(BerichtContext.class),
                Mockito.any(BerichtResultaat.class));
    }

    /**
     * Initialiseert de WSContext mock en conditioneert deze op basis van de opgegeven parameters om al dan niet een
     * signature en/of certificaat te retourneren.
     *
     * @param heeftSignatureResult bepaalt of er een geldige signature wordt geretourneerd of <code>null</code>.
     * @param heeftCertificaat bepaalt of er een geldig certificaat wordt geretourneerd of <code>null</code>.
     */
    protected void initWSContext(final boolean heeftSignatureResult, final boolean heeftCertificaat) {
        MessageContext messageContext = Mockito.mock(MessageContext.class);
        WSSecurityEngineResult wsSecurityEngineResult = null;
        X509Certificate certificaat = null;

        if (heeftSignatureResult) {
            wsSecurityEngineResult = Mockito.mock(WSSecurityEngineResult.class);
        }
        if (heeftCertificaat) {
            certificaat = Mockito.mock(X509Certificate.class);
        }

        Mockito.when(getWsContext().getMessageContext()).thenReturn(messageContext);
        Mockito.when(messageContext.get(WSS4JInInterceptor.SIGNATURE_RESULT)).thenReturn(wsSecurityEngineResult);
        if (heeftSignatureResult) {
            Mockito.when(wsSecurityEngineResult.get(WSSecurityEngineResult.TAG_X509_CERTIFICATE))
                   .thenReturn(certificaat);
        }
    }

    /**
     * Initialiseert de mock van de authenticatie service en zorgt er voor dat de mock het opgegeven aantal
     * authenticatiemiddelen retourneert.
     *
     * @param aantalAuthenticatieMiddelen het aantal authenticatiemiddelen dat geretourneerd dient te worden.
     */
    protected void initAuthenticatieService(final int aantalAuthenticatieMiddelen) {
        List<PersistentAuthenticatieMiddel> authenticatieMiddelen = new ArrayList<PersistentAuthenticatieMiddel>();
        for (int i = 0; i < aantalAuthenticatieMiddelen; i++) {
            PersistentAuthenticatieMiddel authenticatieMiddel = new PersistentAuthenticatieMiddel();
            ReflectionTestUtils.setField(authenticatieMiddel, "partij", new Partij());
            ReflectionTestUtils.setField(authenticatieMiddel, "id", 2);
            authenticatieMiddelen.add(authenticatieMiddel);
        }

        Mockito.when(
            getAuthenticatieService()
                .haalAuthenticatieMiddelenOp(Mockito.anyInt(), (X509Certificate) Mockito.notNull()))
               .thenReturn(authenticatieMiddelen);
    }

    protected Message getMessage() {
        return message;
    }

    protected void setMessage(final Message message) {
        this.message = message;
    }

    protected WebServiceContext getWsContext() {
        return wsContext;
    }

    protected void setWsContext(final WebServiceContext wsContext) {
        this.wsContext = wsContext;
    }

    protected AuthenticatieService getAuthenticatieService() {
        return authenticatieService;
    }

    protected void setAuthenticatieService(final AuthenticatieService authenticatieService) {
        this.authenticatieService = authenticatieService;
    }

    protected BerichtVerwerker getBerichtVerwerker() {
        return berichtVerwerker;
    }

    protected void setBerichtVerwerker(final BerichtVerwerker berichtVerwerker) {
        this.berichtVerwerker = berichtVerwerker;
    }

    protected AbstractWebService<T> getWebService() {
        return webService;
    }

    protected void setWebService(final AbstractWebService<T> webService) {
        this.webService = webService;
    }

    protected T getBericht() {
        return bericht;
    }

    protected void setBericht(final T bericht) {
        this.bericht = bericht;
    }
}
