/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.business.dashboard;

import java.util.List;

import nl.bzk.brp.business.dto.BerichtContext;
import nl.bzk.brp.business.dto.BerichtResultaat;
import nl.bzk.brp.business.dto.bijhouding.BijhoudingsBericht;
import nl.bzk.brp.business.handlers.AbstractBerichtVerwerkingsStap;


/**
 * Verwerkingstap die voor elk bijhoudingsbericht een notificatie stuurt naar de dashboard applicatie.
 */
public class DashboardNotificatieStap extends AbstractBerichtVerwerkingsStap<BijhoudingsBericht, BerichtResultaat> {

    private List<AbstractDashboardNotificator<?, ?>> notificators;

    private boolean                                  actief;

    @Override
    public boolean voerVerwerkingsStapUitVoorBericht(final BijhoudingsBericht bericht, final BerichtContext context,
            final BerichtResultaat resultaat)
    {
        return true;
    }

    @Override
    public void naVerwerkingsStapVoorBericht(final BijhoudingsBericht bericht, final BerichtContext context,
            final BerichtResultaat resultaat)
    {
        if (actief) {
            for (AbstractDashboardNotificator<?, ?> notificator : notificators) {
                if (notificator.kanVerwerken(bericht)) {
                    notificator.notificeerDashboard(bericht, context, resultaat);
                    break;
                }
            }
        }
    }

    public void setNotificators(final List<AbstractDashboardNotificator<?, ?>> notificators) {
        this.notificators = notificators;
    }

    public void setActief(final boolean waarde) {
        actief = waarde;
    }

}
