/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.levering.verzending;

import javax.jws.WebParam;
import nl.bzk.brp.koppelvlak.synchronisatie.FiatteringNotificeerBijhoudingsplan;
import nl.bzk.brp.koppelvlak.synchronisatie.SynchronisatieVerwerkPersoon;
import nl.bzk.brp.levering.berichtverwerking.service.LvgSynchronisatieVerwerking;
import nl.bzk.brp.logging.Logger;
import nl.bzk.brp.logging.LoggerFactory;

/**
 * Deze klasse biedt toegang tot de webservice(s) van de afnemers.
 */
@javax.jws.WebService(
    serviceName = "BrpBerichtVerwerkingService",
    portName = "lvgSynchronisatieVerwerking",
    targetNamespace = "http://www.bzk.nl/brp/levering/berichtverwerking/service",
    wsdlLocation = "wsdl/brp-berichtverwerking.wsdl",
    endpointInterface = "nl.bzk.brp.levering.berichtverwerking.service.LvgSynchronisatieVerwerking")

public class LvgSynchronisatieVerwerkingImpl implements LvgSynchronisatieVerwerking {

    private static final Logger LOG = LoggerFactory.getLogger();

    private int aantalOntvangenBerichten;

    @Override
    public void verwerkBijhoudingsplan(@WebParam(partName = "fiaVerwerkNotificatiePersoon", name = "bhg_fiaNotificeerBijhoudingsplan",
        targetNamespace = "http://www.bzk.nl/brp/brp0200") final FiatteringNotificeerBijhoudingsplan fiaVerwerkNotificatiePersoon)
    {
        LOG.info("Executing operation notificatie");
        LOG.info("Verwerken notificatie: {}", fiaVerwerkNotificatiePersoon);
        aantalOntvangenBerichten++;
    }

    @Override
    public final void verwerkPersoon(
        @WebParam(partName = "synVerwerkMutatiePersoon", name = "lvg_synVerwerkPersoon",
            targetNamespace = "http://www.bzk.nl/brp/brp0200") final SynchronisatieVerwerkPersoon synchronisatieVerwerkPersoon)
    {
        LOG.info("Executing operation kennisgeving");
        LOG.info("Verwerken kennisgeving: {}", synchronisatieVerwerkPersoon);
        aantalOntvangenBerichten++;
    }

    public final int getAantalOntvangenBerichten() {
        return aantalOntvangenBerichten;
    }

}
