/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.groep.interfaces.gen;

import nl.bzk.brp.model.attribuuttype.Datum;
import nl.bzk.brp.model.attribuuttype.Versienummer;
import nl.bzk.brp.model.basis.Groep;
import nl.bzk.brp.model.objecttype.interfaces.gen.PersoonBasis;

/**
 * Interface voor groep persoon inschrijving.
 */
public interface PersoonInschrijvingGroepBasis extends Groep {

    /**
     * Retourneert versie nummer.
     * @return Versie nummer.
     */
    Versienummer getVersienummer();

    /**
     * Retourneert vorige persoon.
     * @return Persoon.
     */
    PersoonBasis getVorigePersoon();

    /**
     * Retourneert volgende persoon.
     * @return Persoon.
     */
    PersoonBasis getVolgendePersoon();

    /**
     * Retourneert datum inschrijving.
     * @return Datum.
     */
    Datum getDatumInschrijving();
}
