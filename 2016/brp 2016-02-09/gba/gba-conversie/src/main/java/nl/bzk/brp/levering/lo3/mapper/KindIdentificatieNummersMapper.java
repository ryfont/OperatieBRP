/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.levering.lo3.mapper;

import nl.bzk.brp.model.algemeen.stamgegeven.kern.ElementEnum;
import org.springframework.stereotype.Component;

/**
 * Mapt de identificatienummers (voor een kind).
 */
@Component
public final class KindIdentificatieNummersMapper extends AbstractIdentificatieNummersMapper {

    /**
     * Constructor.
     */
    public KindIdentificatieNummersMapper() {
        super(ElementEnum.GERELATEERDEKIND_PERSOON_IDENTIFICATIENUMMERS_DATUMAANVANGGELDIGHEID,
              ElementEnum.GERELATEERDEKIND_PERSOON_IDENTIFICATIENUMMERS_DATUMEINDEGELDIGHEID,
              ElementEnum.GERELATEERDEKIND_PERSOON_IDENTIFICATIENUMMERS_TIJDSTIPREGISTRATIE,
              ElementEnum.GERELATEERDEKIND_PERSOON_IDENTIFICATIENUMMERS_TIJDSTIPVERVAL,
              ElementEnum.GERELATEERDEKIND_PERSOON_IDENTIFICATIENUMMERS_ADMINISTRATIENUMMER,
              ElementEnum.GERELATEERDEKIND_PERSOON_IDENTIFICATIENUMMERS_BURGERSERVICENUMMER);
    }
}
