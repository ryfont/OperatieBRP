/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.bevraging.domein;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


/**
 * Deze class vertegenwoordigt een Land.
 */
@Entity
@Table(name = "Plaats", schema = "Kern")
@Access(AccessType.FIELD)
public class Plaats implements Serializable {

    @Id
    private Long    id;
    @Column(name = "Naam")
    private String  naam;
    @Column(name = "DatAanvGel")
    private Integer geldigVanaf;
    @Column(name = "DatEindeGel")
    private Integer geldigTot;

    /**
     * No-arg constructor voor JPA.
     */
    protected Plaats() {
    }

    /**
     * Constructor voor programmatische instantiatie, met parameter voor verplichte properties.
     *
     * @param naam De naam van het land.
     */
    public Plaats(final String naam) {
        this.naam = naam;
    }

    public Long getId() {
        return id;
    }

    public Integer getGeldigTot() {
        return geldigTot;
    }

    public void setGeldigTot(final Integer geldigTot) {
        this.geldigTot = geldigTot;
    }

    public Integer getGeldigVanaf() {
        return geldigVanaf;
    }

    public void setGeldigVanaf(final Integer geldigVanaf) {
        this.geldigVanaf = geldigVanaf;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(final String naam) {
        this.naam = naam;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("id", id).append("naam", naam)
                .toString();
    }
}
