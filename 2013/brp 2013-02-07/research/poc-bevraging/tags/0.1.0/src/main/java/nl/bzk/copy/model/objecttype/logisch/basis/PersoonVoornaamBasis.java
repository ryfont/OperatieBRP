/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.copy.model.objecttype.logisch.basis;

import nl.bzk.copy.model.attribuuttype.Volgnummer;
import nl.bzk.copy.model.basis.ObjectType;
import nl.bzk.copy.model.groep.logisch.PersoonVoornaamStandaardGroep;
import nl.bzk.copy.model.objecttype.logisch.Persoon;

/**
 * Interface voor objecttype voornaam.
 */
public interface PersoonVoornaamBasis extends ObjectType {

    /**
     * Retourneert de Persoon waar deze voornaam toebehoort.
     *
     * @return De persoon.
     */
    Persoon getPersoon();

    /**
     * Retourneert volgnummer van voornaam.
     *
     * @return Volgnummer voornaam.
     */
    Volgnummer getVolgnummer();

    /**
     * Retourneert standaard groep van objecttype voornaam.
     *
     * @return Standaard groep.
     */
    PersoonVoornaamStandaardGroep getGegevens();
}
