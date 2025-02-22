/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.moderniseringgba.isc.uc302;

import java.util.Map;

import nl.moderniseringgba.isc.esb.message.brp.generated.StatusType;
import nl.moderniseringgba.isc.esb.message.brp.impl.MvVerhuizingAntwoordBericht;
import nl.moderniseringgba.isc.jbpm.spring.SpringDecision;
import nl.moderniseringgba.migratie.logging.Logger;
import nl.moderniseringgba.migratie.logging.LoggerFactory;

import org.springframework.stereotype.Component;

/**
 * Controleer verhuis antwoord.
 */
@Component("uc302ControleerMvVerhuisAntwoordDecision")
public final class ControleerMvVerhuisAntwoordDecision implements SpringDecision {

    private static final Logger LOG = LoggerFactory.getLogger();

    private static final String FOUT = "12c. Fout";

    @Override
    public String execute(final Map<String, Object> parameters) {
        LOG.info("execute(parameters={})", parameters);

        final MvVerhuizingAntwoordBericht verhuisAntwoord =
                (MvVerhuizingAntwoordBericht) parameters.get("mvVerhuisAntwoordBericht");

        return verhuisAntwoord.getStatus() == StatusType.OK ? null : FOUT;
    }
}
