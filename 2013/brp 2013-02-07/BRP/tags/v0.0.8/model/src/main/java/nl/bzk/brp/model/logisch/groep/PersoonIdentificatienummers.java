/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.logisch.groep;

import nl.bzk.brp.model.validatie.MeldingCode;
import nl.bzk.brp.model.validatie.constraint.Anummer;
import nl.bzk.brp.model.validatie.constraint.Bsn;
import nl.bzk.brp.model.validatie.constraint.NietLeeg;


/**
 * Persoon.Identificatienummers.
 *
 */
public class PersoonIdentificatienummers {

    @Bsn
    @NietLeeg(code = MeldingCode.BRAL0012)
    // TODO: juiste code om duidelijk aan te geven dat bsn verplicht is moet nog ingevuld worden.
    private String burgerservicenummer;

    @Anummer
    private String administratienummer;

    public String getBurgerservicenummer() {
        return burgerservicenummer;
    }

    public void setBurgerservicenummer(final String burgerservicenummer) {
        this.burgerservicenummer = burgerservicenummer;
    }

    public String getAdministratienummer() {
        return administratienummer;
    }

    public void setAdministratienummer(final String administratienummer) {
        this.administratienummer = administratienummer;
    }
}
