/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.bericht.kern;

import nl.bzk.brp.model.bericht.kern.basis.AbstractPersoonGeslachtsaanduidingGroepBericht;
import nl.bzk.brp.model.logisch.kern.PersoonGeslachtsaanduidingGroep;


/**
 * Gegevens over het geslacht van een Persoon.
 *
 * Verplicht aanwezig bij persoon
 *
 * Beide vormen van historie: geslacht(saanduiding) kan in de werkelijkheid veranderen, dus materieel bovenop de formele
 * historie.
 *
 *
 *
 */
public class PersoonGeslachtsaanduidingGroepBericht extends AbstractPersoonGeslachtsaanduidingGroepBericht implements
        PersoonGeslachtsaanduidingGroep
{

}
