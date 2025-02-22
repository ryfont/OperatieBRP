/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.moderniseringgba.isc.uc307;

import java.util.HashMap;
import java.util.Map;

import nl.moderniseringgba.isc.esb.message.brp.impl.NotificatieVerzoekBericht;
import nl.moderniseringgba.isc.jbpm.spring.SpringAction;
import nl.moderniseringgba.migratie.logging.Logger;
import nl.moderniseringgba.migratie.logging.LoggerFactory;

import org.springframework.stereotype.Component;

/**
 * Maakt een BRP NotificatieVerzoek bericht.
 * 
 */
@Component("uc307MaakNotificatieVerzoekBerichtAction")
public class MaakNotificatieVerzoekBerichtAction implements SpringAction {

    private static final Logger LOG = LoggerFactory.getLogger();

    @Override
    public final Map<String, Object> execute(final Map<String, Object> parameters) {
        LOG.info("execute(parameters={})", parameters);

        final NotificatieVerzoekBericht notificatieVerzoekBericht = new NotificatieVerzoekBericht();

        // TODO: toevoegen identificerende gegevens...
        notificatieVerzoekBericht
                .setNotificatie("Fout bij het uitlezen van PL, terwijl deze wel in BRP is gevonden.");

        final Map<String, Object> result = new HashMap<String, Object>();
        result.put("notificatieVerzoekBericht", notificatieVerzoekBericht);

        return result;
    }

}
