/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.migratiebrp.synchronisatie.dal.service.impl.mapper;

import nl.bzk.algemeenbrp.dal.domein.brp.entity.PersoonIndicatieHistorie;
import nl.bzk.algemeenbrp.dal.domein.brp.enums.Element;
import nl.bzk.migratiebrp.conversie.model.brp.attribuut.BrpBoolean;
import nl.bzk.migratiebrp.conversie.model.brp.groep.BrpOnderCurateleIndicatieInhoud;
import nl.bzk.migratiebrp.synchronisatie.dal.service.impl.mapper.strategie.BrpOnderzoekMapper;
import org.springframework.stereotype.Component;

/**
 * Map onder curatele indicatie van het BRP database model naar het BRP conversie model.
 */
@Component
public final class BrpOnderCurateleIndicatieMapper extends AbstractBrpMapper<PersoonIndicatieHistorie, BrpOnderCurateleIndicatieInhoud> {

    @Override
    protected BrpOnderCurateleIndicatieInhoud mapInhoud(final PersoonIndicatieHistorie historie, final BrpOnderzoekMapper brpOnderzoekMapper) {
        final BrpBoolean indicatie =
                BrpBoolean.wrap(historie.getWaarde(), brpOnderzoekMapper.bepaalOnderzoek(historie, Element.PERSOON_INDICATIE_ONDERCURATELE_WAARDE, true));

        return new BrpOnderCurateleIndicatieInhoud(indicatie, null, null);
    }
}
