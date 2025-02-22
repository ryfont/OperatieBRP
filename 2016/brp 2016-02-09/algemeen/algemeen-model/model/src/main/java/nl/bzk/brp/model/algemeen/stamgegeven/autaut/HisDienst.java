/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.algemeen.stamgegeven.autaut;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;
import nl.bzk.brp.model.algemeen.attribuuttype.kern.DatumAttribuut;
import nl.bzk.brp.model.algemeen.attribuuttype.kern.JaAttribuut;
import nl.bzk.brp.model.basis.BestaansperiodeFormeelImplicietMaterieelAutaut;
import nl.bzk.brp.model.basis.ModelIdentificeerbaar;
import nl.bzk.brp.model.operationeel.kern.ActieModel;

/**
 *
 *
 */
@Entity
@Table(schema = "AutAut", name = "His_Dienst")
@Access(value = AccessType.FIELD)
public class HisDienst extends AbstractHisDienst implements ModelIdentificeerbaar<Integer>, BestaansperiodeFormeelImplicietMaterieelAutaut {

    /**
     * Default lege constructor t.b.v. Hibernate / JPA
     *
     */
    protected HisDienst() {
        super();
    }

    /**
     * Constructor voor het initialiseren van alle attributen.
     *
     * @param dienst dienst van HisDienst
     * @param datumIngang datumIngang van HisDienst
     * @param datumEinde datumEinde van HisDienst
     * @param indicatieGeblokkeerd indicatieGeblokkeerd van HisDienst
     * @param actieInhoud Verantwoording inhoud; de verantwoording die leidt tot dit nieuwe record.
     */
    public HisDienst(
        final Dienst dienst,
        final DatumAttribuut datumIngang,
        final DatumAttribuut datumEinde,
        final JaAttribuut indicatieGeblokkeerd,
        final ActieModel actieInhoud)
    {
        super(dienst, datumIngang, datumEinde, indicatieGeblokkeerd, actieInhoud);
    }

    /**
     * Copy Constructor die op basis van een C/D-laag klasse een C/D-laag klasse construeert.
     *
     * @param kopie backrefence instantie.
     */
    public HisDienst(final AbstractHisDienst kopie) {
        super(kopie);
    }

}
