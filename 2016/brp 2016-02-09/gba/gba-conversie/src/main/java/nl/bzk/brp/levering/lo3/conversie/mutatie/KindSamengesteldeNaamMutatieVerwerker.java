/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.levering.lo3.conversie.mutatie;

import nl.bzk.brp.levering.lo3.mapper.KindSamengesteldeNaamMapper;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.ElementEnum;
import nl.bzk.brp.model.operationeel.kern.HisPersoonSamengesteldeNaamModel;
import nl.bzk.migratiebrp.conversie.model.brp.groep.BrpSamengesteldeNaamInhoud;
import nl.bzk.migratiebrp.conversie.model.lo3.categorie.Lo3KindInhoud;
import nl.bzk.migratiebrp.conversie.regels.proces.brpnaarlo3.attributen.BrpKindConverteerder.SamengesteldeNaamConverteerder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Verwerkt mutaties in kind/samengestelde naam.
 */
@Component
public final class KindSamengesteldeNaamMutatieVerwerker
        extends AbstractMaterieelMutatieVerwerker<Lo3KindInhoud, BrpSamengesteldeNaamInhoud, HisPersoonSamengesteldeNaamModel>
{
    /**
     * Constructor.
     *
     * @param mapper
     *            mapper
     * @param converteerder
     *            converteerder
     */
    @Autowired
    protected KindSamengesteldeNaamMutatieVerwerker(final KindSamengesteldeNaamMapper mapper, final SamengesteldeNaamConverteerder converteerder) {
        super(mapper, converteerder, ElementEnum.GERELATEERDEKIND_PERSOON_SAMENGESTELDENAAM);
    }

}
