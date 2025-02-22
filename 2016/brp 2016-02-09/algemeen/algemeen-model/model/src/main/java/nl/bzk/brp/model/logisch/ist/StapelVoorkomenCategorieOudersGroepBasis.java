/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.logisch.ist;

import javax.annotation.Generated;
import nl.bzk.brp.model.algemeen.attribuuttype.kern.DatumEvtDeelsOnbekendAttribuut;
import nl.bzk.brp.model.basis.Groep;

/**
 *
 *
 */
@Generated(value = "nl.bzk.brp.generatoren.java.LogischModelGenerator")
public interface StapelVoorkomenCategorieOudersGroepBasis extends Groep {

    /**
     * Retourneert Rubriek 6210 Datum ingang familierechtelijke betrekking van Categorie ouders.
     *
     * @return Rubriek 6210 Datum ingang familierechtelijke betrekking.
     */
    DatumEvtDeelsOnbekendAttribuut getRubriek6210DatumIngangFamilierechtelijkeBetrekking();

}
