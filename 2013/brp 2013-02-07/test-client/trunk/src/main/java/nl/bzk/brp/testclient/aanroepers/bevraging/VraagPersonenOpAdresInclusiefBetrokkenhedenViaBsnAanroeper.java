/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testclient.aanroepers.bevraging;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import nl.bprbzk.brp._0001.Applicatienaam;
import nl.bprbzk.brp._0001.BevragingPersonenOpAdresInclusiefBetrokkenheden;
import nl.bprbzk.brp._0001.Burgerservicenummer;
import nl.bprbzk.brp._0001.GroepBerichtStuurgegevens;
import nl.bprbzk.brp._0001.GroepBerichtVraagBasis;
import nl.bprbzk.brp._0001.GroepBerichtZoekcriteria;
import nl.bprbzk.brp._0001.ObjectFactory;
import nl.bprbzk.brp._0001.Organisatienaam;
import nl.bprbzk.brp._0001.Sleutelwaardetekst;
import nl.bzk.brp.testclient.TestClient;
import nl.bzk.brp.testclient.misc.Bericht;
import nl.bzk.brp.testclient.misc.Eigenschappen;
import nl.bzk.brp.testclient.soapcommands.bevraging.PersonenOpAdresCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * De Class VraagPersonenOpAdresInclusiefBetrokkenhedenViaBsnAanroeper.
 */
public class VraagPersonenOpAdresInclusiefBetrokkenhedenViaBsnAanroeper extends BevragingAanroeper {

    private static final Logger LOG                 = LoggerFactory.getLogger(VraagPersonenOpAdresInclusiefBetrokkenhedenViaBsnAanroeper.class);

    // NB: Let op dat je bij het toeveogen van parameters, deze ook toevoegt in getParameterList()

    public static final String  PARAMETER_BSN    = "BSN";
    private static final String BSN              = "100000344";
    private static final String ORGANISATIE      = "364";
    private static final String APPLICATIE       = "Testclient";
    private static final String REFERENTIENUMMER = "12345";

    /**
     * Instantieert een nieuwe vraag personen op adres inclusief betrokkenheden via bsn aanroeper.
     *
     * @param eigenschappen de eigenschappen
     * @param parameterMap de parameter map
     * @throws Exception de exception
     */
    public VraagPersonenOpAdresInclusiefBetrokkenhedenViaBsnAanroeper(final Eigenschappen eigenschappen,
            final Map<String, String> parameterMap) throws Exception
    {
        super(eigenschappen, parameterMap);
    }

    /*
     * (non-Javadoc)
     *
     * @see nl.bzk.brp.testclient.aanroepers.AbstractAanroeper#fire()
     */
    @Override
    public void fire() {
        BevragingPersonenOpAdresInclusiefBetrokkenheden vraag = creeerBevragingPersonenOpAdresInclusiefBetrokkenheden();
        PersonenOpAdresCommand command =
            new PersonenOpAdresCommand(vraag);
        Long duur = roepAan(command);
        TestClient.statistieken.bijwerkenNaBericht(Bericht.BERICHT.VRAAG_PERSONEN_ADRES_VIA_BSN,
                getStatus(), duur);
    }

    /**
     * Creeer bevraging personen op adres inclusief betrokkenheden.
     *
     * @return de bevraging personen op adres inclusief betrokkenheden
     */
    private BevragingPersonenOpAdresInclusiefBetrokkenheden creeerBevragingPersonenOpAdresInclusiefBetrokkenheden() {
        ObjectFactory objectFactory = new ObjectFactory();
        BevragingPersonenOpAdresInclusiefBetrokkenheden bevraging =
            new BevragingPersonenOpAdresInclusiefBetrokkenheden();

        // Stuurgegevens-element
        List<GroepBerichtStuurgegevens> groepBerichtStuurgegevensList = bevraging.getStuurgegevens();
        GroepBerichtStuurgegevens groepBerichtStuurgegevens = new GroepBerichtStuurgegevens();

        Organisatienaam organisatienaam = new Organisatienaam();
        organisatienaam.setValue(ORGANISATIE);
        groepBerichtStuurgegevens.setOrganisatie(organisatienaam);

        Applicatienaam applicatienaam = new Applicatienaam();
        applicatienaam.setValue(APPLICATIE);
        groepBerichtStuurgegevens.setApplicatie(applicatienaam);

        Sleutelwaardetekst sleutelwaardetekst = new Sleutelwaardetekst();
        sleutelwaardetekst.setValue(REFERENTIENUMMER);
        groepBerichtStuurgegevens.setReferentienummer(sleutelwaardetekst);

        groepBerichtStuurgegevensList.add(groepBerichtStuurgegevens);

        // Vraag-element
        GroepBerichtVraagBasis groepBerichtVraagBasis = new GroepBerichtVraagBasis();

        // Zoekcriteria
        GroepBerichtZoekcriteria groepBerichtZoekcriteria = new GroepBerichtZoekcriteria();
        JAXBElement<GroepBerichtZoekcriteria> jaxbGroepBerichtZoekcriteria =
            objectFactory.createGroepBerichtVraagBasisZoekcriteria(groepBerichtZoekcriteria);
        groepBerichtVraagBasis.setZoekcriteria(jaxbGroepBerichtZoekcriteria);
        bevraging.setVraag(groepBerichtVraagBasis);

        // Vullen van zoekcriteria
        Burgerservicenummer burgerservicenummer = new Burgerservicenummer();
        burgerservicenummer.setValue(getValueFromValueMap(PARAMETER_BSN, BSN));
        JAXBElement<Burgerservicenummer> jaxbBurgerservicenummer =
            objectFactory.createGroepBerichtZoekcriteriaBurgerservicenummer(burgerservicenummer);
        groepBerichtZoekcriteria.setBurgerservicenummer(jaxbBurgerservicenummer);

        return bevraging;
    }

    /*
     * (non-Javadoc)
     *
     * @see nl.bzk.brp.testclient.aanroepers.AbstractAanroeper#getParameterList()
     */
    @Override
    protected List<String> getParameterList() {
        return Arrays.asList(new String[] { PARAMETER_BSN });
    }
}
