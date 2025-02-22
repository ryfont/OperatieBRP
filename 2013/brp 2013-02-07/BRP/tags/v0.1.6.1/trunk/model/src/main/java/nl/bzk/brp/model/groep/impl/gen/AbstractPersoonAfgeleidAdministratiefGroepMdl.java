/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.groep.impl.gen;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import nl.bzk.brp.model.attribuuttype.DatumTijd;
import nl.bzk.brp.model.attribuuttype.JaNee;
import nl.bzk.brp.model.basis.AbstractGroep;
import nl.bzk.brp.model.groep.interfaces.gen.PersoonAfgeleidAdministratiefGroepBasis;
import nl.bzk.brp.model.objecttype.statisch.StatusHistorie;
import org.hibernate.annotations.Type;


/**
 * .
 *
 */
@MappedSuperclass
@Access(AccessType.FIELD)
@SuppressWarnings("serial")
public abstract class AbstractPersoonAfgeleidAdministratiefGroepMdl extends AbstractGroep implements
        PersoonAfgeleidAdministratiefGroepBasis
{

    @Column(name = "indgegevensinonderzoek")
    @Type(type = "JaNee")
    private JaNee          indGegevensInOnderzoek;

    @Embedded
    @AttributeOverride(name = "waarde", column = @Column(name = "tijdstipLaatsteWijz"))
    private DatumTijd      tijdstipLaatsteWijziging;

    @Transient
    private StatusHistorie statusHistorie;

    @Override
    public JaNee getIndGegevensInOnderzoek() {
        return indGegevensInOnderzoek;
    }

    @Override
    public DatumTijd getTijdstipLaatsteWijziging() {
        return tijdstipLaatsteWijziging;
    }

    @Override
    public StatusHistorie getStatusHistorie() {
        return statusHistorie;
    }
}
