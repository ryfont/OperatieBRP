/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.levering.lo3.conversie.mutatie;

import nl.bzk.brp.levering.lo3.mapper.OuderIdentificatieNummersMapper;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.ElementEnum;
import nl.bzk.brp.model.operationeel.kern.HisPersoonIdentificatienummersModel;
import nl.bzk.migratiebrp.conversie.model.brp.groep.BrpIdentificatienummersInhoud;
import nl.bzk.migratiebrp.conversie.model.lo3.categorie.Lo3OuderInhoud;
import nl.bzk.migratiebrp.conversie.regels.proces.brpnaarlo3.attributen.BrpOuderConverteerder.IdentificatienumersConverteerder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Verwerkt mutaties in ouder/identificatienummers.
 */
@Component
public final class OuderIdentificatienummersMutatieVerwerker
        extends AbstractMaterieelMutatieVerwerker<Lo3OuderInhoud, BrpIdentificatienummersInhoud, HisPersoonIdentificatienummersModel>
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
    protected OuderIdentificatienummersMutatieVerwerker(
        final OuderIdentificatieNummersMapper mapper,
        final IdentificatienumersConverteerder converteerder)
    {
        super(mapper, converteerder, ElementEnum.GERELATEERDEOUDER_PERSOON_IDENTIFICATIENUMMERS);
    }

}
