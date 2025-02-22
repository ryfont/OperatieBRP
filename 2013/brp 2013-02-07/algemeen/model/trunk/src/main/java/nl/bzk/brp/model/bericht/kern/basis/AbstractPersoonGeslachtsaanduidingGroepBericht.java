/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.bericht.kern.basis;

import nl.bzk.brp.model.algemeen.stamgegeven.kern.Geslachtsaanduiding;
import nl.bzk.brp.model.basis.AbstractGroepBericht;
import nl.bzk.brp.model.logisch.kern.basis.PersoonGeslachtsaanduidingGroepBasis;


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
public abstract class AbstractPersoonGeslachtsaanduidingGroepBericht extends AbstractGroepBericht implements
        PersoonGeslachtsaanduidingGroepBasis
{

    private Geslachtsaanduiding geslachtsaanduiding;

    /**
     * {@inheritDoc}
     */
    @Override
    public Geslachtsaanduiding getGeslachtsaanduiding() {
        return geslachtsaanduiding;
    }

    /**
     * Zet Geslachtsaanduiding van Geslachtsaanduiding.
     *
     * @param geslachtsaanduiding Geslachtsaanduiding.
     */
    public void setGeslachtsaanduiding(final Geslachtsaanduiding geslachtsaanduiding) {
        this.geslachtsaanduiding = geslachtsaanduiding;
    }

}
