/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.toegangsbewaking.test.model;

// Generated 23-sep-2011 15:40:39 by Hibernate Tools 3.4.0.CR1

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
@Table(name = "hispersgeslnaamcomp", schema = "kern", uniqueConstraints = @UniqueConstraint(columnNames = {
        "persgeslnaamcomp", "dataanvgel", "dattijdreg" }))
public class Hispersgeslnaamcomp implements java.io.Serializable {

    private long             id;
    private Brpactie         brpactieByBrpactiebegin;
    private Predikaat        predikaat;
    private Persgeslnaamcomp persgeslnaamcomp;
    private Adellijketitel   adellijketitel;
    private Brpactie         brpactieByBrpactiebeingeld;
    private Brpactie         brpactieByBrpactieeinde;
    private Integer          dataanvgel;
    private Integer          dateindegel;
    private Date             dattijdreg;
    private Date             dattijdverval;
    private String           voorvoegsel;
    private String           scheidingsteken;
    private String           naam;

    public Hispersgeslnaamcomp() {
    }

    public Hispersgeslnaamcomp(long id, String naam) {
        this.id = id;
        this.naam = naam;
    }

    public Hispersgeslnaamcomp(long id, Brpactie brpactieByBrpactiebegin, Predikaat predikaat,
            Persgeslnaamcomp persgeslnaamcomp, Adellijketitel adellijketitel, Brpactie brpactieByBrpactiebeingeld,
            Brpactie brpactieByBrpactieeinde, Integer dataanvgel, Integer dateindegel, Date dattijdreg,
            Date dattijdverval, String voorvoegsel, String scheidingsteken, String naam)
    {
        this.id = id;
        this.brpactieByBrpactiebegin = brpactieByBrpactiebegin;
        this.predikaat = predikaat;
        this.persgeslnaamcomp = persgeslnaamcomp;
        this.adellijketitel = adellijketitel;
        this.brpactieByBrpactiebeingeld = brpactieByBrpactiebeingeld;
        this.brpactieByBrpactieeinde = brpactieByBrpactieeinde;
        this.dataanvgel = dataanvgel;
        this.dateindegel = dateindegel;
        this.dattijdreg = dattijdreg;
        this.dattijdverval = dattijdverval;
        this.voorvoegsel = voorvoegsel;
        this.scheidingsteken = scheidingsteken;
        this.naam = naam;
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
    @JoinColumn(name = "brpactiebegin")
    public Brpactie getBrpactieByBrpactiebegin() {
        return this.brpactieByBrpactiebegin;
    }

    public void setBrpactieByBrpactiebegin(Brpactie brpactieByBrpactiebegin) {
        this.brpactieByBrpactiebegin = brpactieByBrpactiebegin;
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
    @JoinColumn(name = "brpactiebeingeld")
    public Brpactie getBrpactieByBrpactiebeingeld() {
        return this.brpactieByBrpactiebeingeld;
    }

    public void setBrpactieByBrpactiebeingeld(Brpactie brpactieByBrpactiebeingeld) {
        this.brpactieByBrpactiebeingeld = brpactieByBrpactiebeingeld;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brpactieeinde")
    public Brpactie getBrpactieByBrpactieeinde() {
        return this.brpactieByBrpactieeinde;
    }

    public void setBrpactieByBrpactieeinde(Brpactie brpactieByBrpactieeinde) {
        this.brpactieByBrpactieeinde = brpactieByBrpactieeinde;
    }

    @Column(name = "dataanvgel", precision = 8, scale = 0)
    public Integer getDataanvgel() {
        return this.dataanvgel;
    }

    public void setDataanvgel(Integer dataanvgel) {
        this.dataanvgel = dataanvgel;
    }

    @Column(name = "dateindegel", precision = 8, scale = 0)
    public Integer getDateindegel() {
        return this.dateindegel;
    }

    public void setDateindegel(Integer dateindegel) {
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

}
