/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.bericht.ber;

import javax.annotation.Generated;
import nl.bzk.brp.model.basis.BrpObject;
import nl.bzk.brp.model.bericht.kern.AdministratieveHandelingBericht;
import nl.bzk.brp.model.bericht.kern.PersoonBericht;
import nl.bzk.brp.model.logisch.ber.AdministratieveHandelingBijgehoudenPersoonBasis;

/**
 * De bijhouding van gegevens over een persoon door middel van een administratieve handeling.
 *
 * Bijhoudingen gebeuren doordat een administratieve handeling wordt verwerkt dat tot wijzigingen leid van
 * persoonsgegevens. Daar waar een administratieve handeling leidt tot een aanpassing van het veld datumtijdstip laatste
 * wijziging van die persoon, is er sprake van een "Administratieve handeling\Bijgehouden persoon". Meer informatie is
 * te vinden bij de beschrijving van de verwerkingsregel voor datumtijd laatste wijziging. Kort gezegd komt het neer op:
 * - 0e graads: dit zijn wijzigingen in het desbetreffende record van de tabel Kern.Pers zelf. - 1e graads: dit zijn
 * wijzigingen in een record van een tabel die verwijst naar ‘het desbetreffende record van de tabel Kern.Pers’. - 2e
 * graads: dit zijn wijzigingen in een record van een tabel… o … die verwijst naar ‘een record van een tabel die
 * verwijst naar het desbetreffende record van de tabel Kern.Pers’ o … of waarnaar wordt verwezen door ‘een record van
 * een tabel die verwijst naar het desbetreffende record van de tabel Kern.Pers’.
 *
 *
 *
 */
@Generated(value = "nl.bzk.brp.generatoren.java.BerichtModelGenerator")
public abstract class AbstractAdministratieveHandelingBijgehoudenPersoonBericht implements BrpObject, AdministratieveHandelingBijgehoudenPersoonBasis {

    private AdministratieveHandelingBericht administratieveHandeling;
    private PersoonBericht persoon;

    /**
     * Retourneert Administratieve handeling van Administratieve handeling \ Bijgehouden persoon.
     *
     * @return Administratieve handeling.
     */
    public AdministratieveHandelingBericht getAdministratieveHandeling() {
        return administratieveHandeling;
    }

    /**
     * Retourneert Persoon van Administratieve handeling \ Bijgehouden persoon.
     *
     * @return Persoon.
     */
    public PersoonBericht getPersoon() {
        return persoon;
    }

    /**
     * Zet Administratieve handeling van Administratieve handeling \ Bijgehouden persoon.
     *
     * @param administratieveHandeling Administratieve handeling.
     */
    public void setAdministratieveHandeling(final AdministratieveHandelingBericht administratieveHandeling) {
        this.administratieveHandeling = administratieveHandeling;
    }

    /**
     * Zet Persoon van Administratieve handeling \ Bijgehouden persoon.
     *
     * @param persoon Persoon.
     */
    public void setPersoon(final PersoonBericht persoon) {
        this.persoon = persoon;
    }

}
