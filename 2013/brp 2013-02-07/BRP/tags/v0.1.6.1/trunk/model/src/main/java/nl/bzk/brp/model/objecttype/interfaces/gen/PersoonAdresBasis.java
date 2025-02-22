/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.objecttype.interfaces.gen;

import nl.bzk.brp.model.basis.ObjectType;
import nl.bzk.brp.model.groep.interfaces.usr.PersoonAdresStandaardGroep;
import nl.bzk.brp.model.objecttype.interfaces.usr.Persoon;

/**
 * Persoonadres.
 *
 */
public interface PersoonAdresBasis extends ObjectType  {

    /**
     * Retourneert de Persoon waar deze voornaam toebehoort.
     * @return De persoon.
     */
    Persoon getPersoon();

    /**
     * Retourneert standaard groep van objecttype persoonAdres.
     * @return Standaard groep.
     */
    PersoonAdresStandaardGroep getGegevens();
}
