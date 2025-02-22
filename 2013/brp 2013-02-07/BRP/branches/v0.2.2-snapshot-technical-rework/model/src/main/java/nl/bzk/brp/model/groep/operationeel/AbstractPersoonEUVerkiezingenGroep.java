/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.groep.operationeel;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

import nl.bzk.brp.model.attribuuttype.Datum;
import nl.bzk.brp.model.attribuuttype.JaNee;
import nl.bzk.brp.model.basis.AbstractGroep;
import nl.bzk.brp.model.groep.logisch.basis.PersoonEuVerkiezingenGroepBasis;
import org.hibernate.annotations.Type;


/**
 * Implementatie voor groep persoon EU Verkiezingen.
 */
@MappedSuperclass
@Access(AccessType.FIELD)
@SuppressWarnings("serial")
public abstract class AbstractPersoonEUVerkiezingenGroep extends AbstractGroep implements
        PersoonEuVerkiezingenGroepBasis
{
    @Column(name = "inddeelneuverkiezingen")
    @Type(type = "JaNee")
    private JaNee indicatieDeelnameEUVerkiezingen;

    @Embedded
    @AttributeOverride(name = "waarde", column = @Column(name = "dataanlaanpdeelneuverkiezing"))
    private Datum datumAanleidingAanpassingDeelnameEUVerkiezing;

    @Embedded
    @AttributeOverride(name = "waarde", column = @Column(name = "dateindeuitsleukiesr"))
    private Datum datumEindeUitsluitingEUKiesrecht;

    /**
     * Copy constructor voor groep.
     *
     * @param groep De te kopieren groep.
     */
    protected AbstractPersoonEUVerkiezingenGroep(final PersoonEuVerkiezingenGroepBasis groep) {
        super(groep);
        indicatieDeelnameEUVerkiezingen = groep.getIndicatieDeelnameEUVerkiezingen();
        datumAanleidingAanpassingDeelnameEUVerkiezing = groep.getDatumAanleidingAanpassingDeelnameEUVerkiezing();
        datumEindeUitsluitingEUKiesrecht = groep.getDatumEindeUitsluitingEUKiesrecht();
    }

    /**
     * Default constructor tbv hibernate.
     */
    protected AbstractPersoonEUVerkiezingenGroep() {
        super();
    }

    @Override
    public JaNee getIndicatieDeelnameEUVerkiezingen() {
        return indicatieDeelnameEUVerkiezingen;
    }

    @Override
    public Datum getDatumAanleidingAanpassingDeelnameEUVerkiezing() {
        return datumAanleidingAanpassingDeelnameEUVerkiezing;
    }

    @Override
    public Datum getDatumEindeUitsluitingEUKiesrecht() {
        return datumEindeUitsluitingEUKiesrecht;
    }
}
