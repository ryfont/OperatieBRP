/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.copy.model.dashboard;

import java.util.ArrayList;
import java.util.List;


/**
 * Adrescorrectie notificatie voor dashboard.
 */
public class AdresCorrectieBerichtRequest extends nl.bzk.copy.model.dashboard.AbstractBerichtRequest {

    private Persoon persoon;

    private List<nl.bzk.copy.model.dashboard.Adres> adressen = new ArrayList<nl.bzk.copy.model.dashboard.Adres>();

    public Persoon getPersoon() {
        return persoon;
    }

    public void setPersoon(final Persoon persoon) {
        this.persoon = persoon;
    }

    public List<nl.bzk.copy.model.dashboard.Adres> getAdressen() {
        return adressen;
    }

    public void setAdressen(final List<Adres> adressen) {
        this.adressen = adressen;
    }

}
