/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.poc.berichtenverwerker.model;

// Generated 10-aug-2011 15:03:15 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;


/**
 * Hispersgeslnaamcomp generated by hbm2java
 */
@Entity
@Table(name = "hispersgeslnaamcomp", schema = "kern",
       uniqueConstraints = @UniqueConstraint(columnNames = { "persgeslnaamcomp", "dataanvgel", "dattijdverval" }))
public class Hispersgeslnaamcomp implements java.io.Serializable {

    private long             id;
    private Actie            actieByActieeinde;
    private Predikaat        predikaat;
    private Persgeslnaamcomp persgeslnaamcomp;
    private Adellijketitel   adellijketitel;
    private Actie            actieByActiebegin;
    private BigDecimal       dataanvgel;
    private BigDecimal       dateindegel;
    private Date             dattijdreg;
    private Date             dattijdverval;
    private String           voorvoegsel;
    private String           scheidingsteken;
    private String           naam;
    private Integer          actiebeingeld;

    public Hispersgeslnaamcomp() {
    }

    public Hispersgeslnaamcomp(long id, String naam) {
        this.id = id;
        this.naam = naam;
    }

    public Hispersgeslnaamcomp(long id, Actie actieByActieeinde, Predikaat predikaat,
            Persgeslnaamcomp persgeslnaamcomp, Adellijketitel adellijketitel, Actie actieByActiebegin,
            BigDecimal dataanvgel, BigDecimal dateindegel, Date dattijdreg, Date dattijdverval, String voorvoegsel,
            String scheidingsteken, String naam, Integer actiebeingeld) {
        this.id = id;
        this.actieByActieeinde = actieByActieeinde;
        this.predikaat = predikaat;
        this.persgeslnaamcomp = persgeslnaamcomp;
        this.adellijketitel = adellijketitel;
        this.actieByActiebegin = actieByActiebegin;
        this.dataanvgel = dataanvgel;
        this.dateindegel = dateindegel;
        this.dattijdreg = dattijdreg;
        this.dattijdverval = dattijdverval;
        this.voorvoegsel = voorvoegsel;
        this.scheidingsteken = scheidingsteken;
        this.naam = naam;
        this.actiebeingeld = actiebeingeld;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actieeinde")
    public Actie getActieByActieeinde() {
        return this.actieByActieeinde;
    }

    public void setActieByActieeinde(Actie actieByActieeinde) {
        this.actieByActieeinde = actieByActieeinde;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "predikaat")
    public Predikaat getPredikaat() {
        return this.predikaat;
    }

    public void setPredikaat(Predikaat predikaat) {
        this.predikaat = predikaat;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persgeslnaamcomp")
    public Persgeslnaamcomp getPersgeslnaamcomp() {
        return this.persgeslnaamcomp;
    }

    public void setPersgeslnaamcomp(Persgeslnaamcomp persgeslnaamcomp) {
        this.persgeslnaamcomp = persgeslnaamcomp;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adellijketitel")
    public Adellijketitel getAdellijketitel() {
        return this.adellijketitel;
    }

    public void setAdellijketitel(Adellijketitel adellijketitel) {
        this.adellijketitel = adellijketitel;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actiebegin")
    public Actie getActieByActiebegin() {
        return this.actieByActiebegin;
    }

    public void setActieByActiebegin(Actie actieByActiebegin) {
        this.actieByActiebegin = actieByActiebegin;
    }

    @Column(name = "dataanvgel", precision = 8)
    public BigDecimal getDataanvgel() {
        return this.dataanvgel;
    }

    public void setDataanvgel(BigDecimal dataanvgel) {
        this.dataanvgel = dataanvgel;
    }

    @Column(name = "dateindegel", precision = 8)
    public BigDecimal getDateindegel() {
        return this.dateindegel;
    }

    public void setDateindegel(BigDecimal dateindegel) {
        this.dateindegel = dateindegel;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dattijdreg", length = 29)
    public Date getDattijdreg() {
        return this.dattijdreg;
    }

    public void setDattijdreg(Date dattijdreg) {
        this.dattijdreg = dattijdreg;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dattijdverval", length = 29)
    public Date getDattijdverval() {
        return this.dattijdverval;
    }

    public void setDattijdverval(Date dattijdverval) {
        this.dattijdverval = dattijdverval;
    }

    @Column(name = "voorvoegsel", length = 10)
    public String getVoorvoegsel() {
        return this.voorvoegsel;
    }

    public void setVoorvoegsel(String voorvoegsel) {
        this.voorvoegsel = voorvoegsel;
    }

    @Column(name = "scheidingsteken", length = 1)
    public String getScheidingsteken() {
        return this.scheidingsteken;
    }

    public void setScheidingsteken(String scheidingsteken) {
        this.scheidingsteken = scheidingsteken;
    }

    @Column(name = "naam", nullable = false, length = 200)
    public String getNaam() {
        return this.naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    @Column(name = "actiebeingeld")
    public Integer getActiebeingeld() {
        return this.actiebeingeld;
    }

    public void setActiebeingeld(Integer actiebeingeld) {
        this.actiebeingeld = actiebeingeld;
    }

}
