/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.bijhouding.business.regels.actie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import nl.bzk.brp.bijhouding.business.regels.impl.gegevenset.ouder.ouderlijkgezag.BRBY2013;
import nl.bzk.brp.bijhouding.business.regels.impl.gegevenset.ouder.ouderlijkgezag.BRBY2016;
import nl.bzk.brp.bijhouding.business.regels.impl.gegevenset.ouder.ouderlijkgezag.BRBY2017;
import nl.bzk.brp.bijhouding.business.regels.impl.gegevenset.ouder.ouderlijkgezag.BRBY2018;
import nl.bzk.brp.bijhouding.business.regels.impl.gegevenset.persoon.gezagderde.BRBY2015;
import nl.bzk.brp.bijhouding.business.regels.impl.gegevenset.persoon.gezagderde.BRBY2019;
import nl.bzk.brp.business.regels.NaActieRegel;
import nl.bzk.brp.business.regels.VoorActieRegel;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.SoortAdministratieveHandeling;
import org.springframework.stereotype.Component;

/**
 * Implementatie van ActieRegelManager.
 */
@Component
public class RegistratieGezagActieRegelManager extends AbstractActieRegelManager {

    @Override
    public List<Class<? extends VoorActieRegel>> getVoorActieRegels(final SoortAdministratieveHandeling soortAdministratieveHandeling) {

        final List<Class<? extends VoorActieRegel>> regels = new ArrayList<>();

        regels.addAll(ALGEMENE_VOOR_ACTIE_REGELS);

        regels.addAll(Arrays.asList(BRBY2013.class, BRBY2015.class, BRBY2016.class));

        return regels;
    }

    @Override
    public List<Class<? extends NaActieRegel>> getNaActieRegels(final SoortAdministratieveHandeling soortAdministratieveHandeling) {

        final List<Class<? extends NaActieRegel>> regels = new ArrayList<>();

        regels.addAll(ALGEMENE_NA_ACTIE_REGELS);

        regels.addAll(Arrays.asList(BRBY2017.class, BRBY2018.class, BRBY2019.class));

        return regels;
    }

}
