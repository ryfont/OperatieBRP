/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.bericht.kern.basis;

import nl.bzk.brp.model.algemeen.stamgegeven.kern.SoortRelatie;
import nl.bzk.brp.model.bericht.kern.HuwelijkGeregistreerdPartnerschapBericht;
import nl.bzk.brp.model.logisch.kern.basis.GeregistreerdPartnerschapBasis;


/**
 * Het (aangaan van het en be�indigen van het) geregistreerd partnerschap zoals beschreven in Titel 5A van het
 * Burgerlijk Wetboek Boek 1.
 *
 * Zie voor verdere toelichting de definitie en toelichting bij Huwelijk/Geregistreerd partnerschap, en bij Relatie.
 *
 *
 *
 */
public abstract class AbstractGeregistreerdPartnerschapBericht extends HuwelijkGeregistreerdPartnerschapBericht
        implements GeregistreerdPartnerschapBasis
{

    /**
     * Constructor die het discriminator attribuut zet of doorgeeft.
     *
     */
    public AbstractGeregistreerdPartnerschapBericht() {
        super(SoortRelatie.GEREGISTREERD_PARTNERSCHAP);
    }

}
