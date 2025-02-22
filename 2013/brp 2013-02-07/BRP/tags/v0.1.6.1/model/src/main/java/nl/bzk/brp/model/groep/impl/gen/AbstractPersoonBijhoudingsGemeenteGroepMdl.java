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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import nl.bzk.brp.model.attribuuttype.Datum;
import nl.bzk.brp.model.attribuuttype.JaNee;
import nl.bzk.brp.model.basis.AbstractGroep;
import nl.bzk.brp.model.groep.interfaces.gen.PersoonBijhoudingsGemeenteGroepBasis;
import nl.bzk.brp.model.objecttype.statisch.Partij;
import nl.bzk.brp.model.objecttype.statisch.StatusHistorie;
import org.hibernate.annotations.Type;


/**
 * Implementatie voor groep persoon bijhoudingsgemeente.
 */
@MappedSuperclass
@Access(AccessType.FIELD)
@SuppressWarnings("serial")
public abstract class AbstractPersoonBijhoudingsGemeenteGroepMdl extends AbstractGroep implements
        PersoonBijhoudingsGemeenteGroepBasis
{

    @ManyToOne
    @JoinColumn(name = "bijhgem")
    private Partij         bijhoudingsGemeente;

    @Column(name = "indonverwdocaanw")
    @Type(type = "JaNee")
    private JaNee          indOnverwerktDocumentAanwezig;

    @Embedded
    @AttributeOverride(name = "waarde", column = @Column(name = "datinschringem"))
    private Datum          datumInschrijvingInGemeente;

    @Transient
    private StatusHistorie statusHistorie;

    @Override
    public Partij getBijhoudingsGemeente() {
        return bijhoudingsGemeente;
    }

    @Override
    public JaNee getIndOnverwerktDocumentAanwezig() {
        return indOnverwerktDocumentAanwezig;
    }

    @Override
    public Datum getDatumInschrijvingInGemeente() {
        return datumInschrijvingInGemeente;
    }

    @Override
    public StatusHistorie getStatusHistorie() {
        return statusHistorie;
    }
}
