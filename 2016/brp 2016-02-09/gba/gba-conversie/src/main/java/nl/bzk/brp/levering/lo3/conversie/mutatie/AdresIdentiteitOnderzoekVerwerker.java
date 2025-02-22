/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.levering.lo3.conversie.mutatie;

import nl.bzk.brp.model.algemeen.stamgegeven.kern.ElementEnum;
import nl.bzk.migratiebrp.conversie.model.lo3.categorie.Lo3VerblijfplaatsInhoud;
import org.springframework.stereotype.Component;

/**
 * Verwerk onderzoeken op de a-laag (identiteit groep) van adres.
 */
@Component
public class AdresIdentiteitOnderzoekVerwerker extends AbstractIdentiteitOnderzoekVerwerker<Lo3VerblijfplaatsInhoud> {

    /**
     * Default constructor.
     */
    public AdresIdentiteitOnderzoekVerwerker() {
        super(ElementEnum.PERSOON_ADRES_IDENTITEIT);
    }

}
