/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.migratiebrp.isc.jbpm.uc301;

import java.util.Map;
import nl.bzk.algemeenbrp.util.common.logging.Logger;
import nl.bzk.algemeenbrp.util.common.logging.LoggerFactory;
import nl.bzk.migratiebrp.bericht.model.sync.generated.StatusType;
import nl.bzk.migratiebrp.bericht.model.sync.impl.LeesUitBrpAntwoordBericht;
import nl.bzk.migratiebrp.isc.jbpm.common.berichten.BerichtenDao;
import nl.bzk.migratiebrp.isc.jbpm.common.spring.SpringDecision;
import org.springframework.stereotype.Component;

/**
 * Controleer query response.
 */
@Component("uc301ControleerLeesUitBrpAntwoordDecision")
public final class ControleerLeesUitBrpAntwoordDecision implements SpringDecision {

    private static final Logger LOG = LoggerFactory.getLogger();

    private final BerichtenDao berichtenDao;

    /**
     * Constructor.
     * @param berichtenDao berichten dao
     */
    protected ControleerLeesUitBrpAntwoordDecision(final BerichtenDao berichtenDao) {
        this.berichtenDao = berichtenDao;
    }

    @Override
    public String execute(final Map<String, Object> parameters) {
        LOG.info("execute(parameters={})", parameters);

        final LeesUitBrpAntwoordBericht leesuitBrpAntwoord =
                parameters == null ? null : (LeesUitBrpAntwoordBericht) berichtenDao.leesBericht((Long) parameters.get("leesUitBrpAntwoordBericht"));

        return leesuitBrpAntwoord != null && leesuitBrpAntwoord.getStatus() == StatusType.OK ? null : "8b-2. Fout";
    }

}
