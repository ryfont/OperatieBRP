/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.copy.dataaccess.repository.jpa.historie;

import nl.bzk.copy.dataaccess.repository.jpa.historie.AbstractGroepFormeleHistorieRepository;
import nl.bzk.copy.model.groep.operationeel.historisch.PersoonInschrijvingHisModel;
import nl.bzk.copy.model.objecttype.operationeel.PersoonModel;
import org.springframework.stereotype.Repository;

/**
 * JPA repository voor de tabel His_PersIds.
 */
@Repository("persoonInschrijvingHistorieRepository")
public class PersoonInschrijvingHistorieRepository
        extends AbstractGroepFormeleHistorieRepository<PersoonModel, PersoonInschrijvingHisModel>
{

    @Override
    protected PersoonInschrijvingHisModel maakNieuwHistorieRecord(final PersoonModel objectType) {
        return new PersoonInschrijvingHisModel(objectType.getInschrijving(), objectType);
    }

    @Override
    protected String padNaarALaagEntiteitInCLaagEntiteit() {
        return "persoon";
    }

    @Override
    protected Class<PersoonInschrijvingHisModel> getCLaagDomainClass() {
        return PersoonInschrijvingHisModel.class;
    }
}
