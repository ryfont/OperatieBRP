/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.bericht.kern;

import javax.annotation.Generated;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.SoortAdministratieveHandeling;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.SoortAdministratieveHandelingAttribuut;

/**
 * Deze OT:"Administratieve handeling" doet een bestaand OT:"Geregistreerd partnerschap" vervallen, bijv. na doorhaling
 * van de akte of een andere aanleiding.
 *
 *
 *
 */
@Generated(value = "nl.bzk.brp.generatoren.java.BerichtModelGenerator")
public abstract class AbstractHandelingOngedaanmakingGeregistreerdPartnerschapBericht extends AdministratieveHandelingBericht {

    /**
     * Default constructor instantieert met de juiste SoortAdministratieveHandeling.
     *
     */
    public AbstractHandelingOngedaanmakingGeregistreerdPartnerschapBericht() {
        super(new SoortAdministratieveHandelingAttribuut(SoortAdministratieveHandeling.ONGEDAANMAKING_GEREGISTREERD_PARTNERSCHAP));
    }

}
