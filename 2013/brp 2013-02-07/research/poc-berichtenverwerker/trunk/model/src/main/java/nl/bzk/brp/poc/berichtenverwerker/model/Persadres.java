/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.poc.berichtenverwerker.model;

// Generated 10-aug-2011 15:03:15 by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Persadres generated by hbm2java
 */
@Entity
@Table(name = "persadres", schema = "kern")
public class Persadres implements java.io.Serializable {

    private long                     id;
    private Land                     land;
    private Rdnwijzadres             rdnwijzadres;
    private Pers                     pers;
    private Gem                      gem;
    private Aangadresh               aangadresh;
    private Plaats                   plaats;
    private Functieadres             functieadres;
    private Actie                    actie;
    private BigDecimal               dataanvadresh;
    private String                   adresseerbaarobject;
    private String                   identcodenraand;
    private String                   nor;
    private String                   afgekortenor;
    private String                   gemdeel;
    private BigDecimal               huisnr;
    private String                   huisletter;
    private String                   huisnrtoevoeging;
    private String                   postcode;
    private String                   loctovadres;
    private String                   locoms;
    private String                   bladresregel1;
    private String                   bladresregel2;
    private String                   bladresregel3;
    private String                   bladresregel4;
    private String                   bladresregel5;
    private String                   bladresregel6;
    private BigDecimal               datvertrekuitnederland;
    private BigDecimal               dataanvgel;
    private Date                     dattijdreg;
    private Set<Hispersadresadresh>  hispersadresadreshs   = new HashSet<Hispersadresadresh>(0);
    private Set<Hispersadresnladres> hispersadresnladreses = new HashSet<Hispersadresnladres>(0);
    private Set<Hispersadresbladres> hispersadresbladreses = new HashSet<Hispersadresbladres>(0);

    public Persadres() {
    }

    public Persadres(long id, Land land, Rdnwijzadres rdnwijzadres, Pers pers, Gem gem, Functieadres functieadres,
            BigDecimal dataanvadresh, BigDecimal datvertrekuitnederland) {
        this.id = id;
        this.land = land;
        this.rdnwijzadres = rdnwijzadres;
        this.pers = pers;
        this.gem = gem;
        this.functieadres = functieadres;
        this.dataanvadresh = dataanvadresh;
        this.datvertrekuitnederland = datvertrekuitnederland;
    }

    public Persadres(long id, Land land, Rdnwijzadres rdnwijzadres, Pers pers, Gem gem, Aangadresh aangadresh,
            Plaats plaats, Functieadres functieadres, Actie actie, BigDecimal dataanvadresh,
            String adresseerbaarobject, String identcodenraand, String nor, String afgekortenor, String gemdeel,
            BigDecimal huisnr, String huisletter, String huisnrtoevoeging, String postcode, String loctovadres,
            String locoms, String bladresregel1, String bladresregel2, String bladresregel3, String bladresregel4,
            String bladresregel5, String bladresregel6, BigDecimal datvertrekuitnederland, BigDecimal dataanvgel,
            Date dattijdreg, Set<Hispersadresadresh> hispersadresadreshs,
            Set<Hispersadresnladres> hispersadresnladreses, Set<Hispersadresbladres> hispersadresbladreses) {
        this.id = id;
        this.land = land;
        this.rdnwijzadres = rdnwijzadres;
        this.pers = pers;
        this.gem = gem;
        this.aangadresh = aangadresh;
        this.plaats = plaats;
        this.functieadres = functieadres;
        this.actie = actie;
        this.dataanvadresh = dataanvadresh;
        this.adresseerbaarobject = adresseerbaarobject;
        this.identcodenraand = identcodenraand;
        this.nor = nor;
        this.afgekortenor = afgekortenor;
        this.gemdeel = gemdeel;
        this.huisnr = huisnr;
        this.huisletter = huisletter;
        this.huisnrtoevoeging = huisnrtoevoeging;
        this.postcode = postcode;
        this.loctovadres = loctovadres;
        this.locoms = locoms;
        this.bladresregel1 = bladresregel1;
        this.bladresregel2 = bladresregel2;
        this.bladresregel3 = bladresregel3;
        this.bladresregel4 = bladresregel4;
        this.bladresregel5 = bladresregel5;
        this.bladresregel6 = bladresregel6;
        this.datvertrekuitnederland = datvertrekuitnederland;
        this.dataanvgel = dataanvgel;
        this.dattijdreg = dattijdreg;
        this.hispersadresadreshs = hispersadresadreshs;
        this.hispersadresnladreses = hispersadresnladreses;
        this.hispersadresbladreses = hispersadresbladreses;
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
    @JoinColumn(name = "land", nullable = false)
    public Land getLand() {
        return this.land;
    }

    public void setLand(Land land) {
        this.land = land;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rdnwijz", nullable = false)
    public Rdnwijzadres getRdnwijzadres() {
        return this.rdnwijzadres;
    }

    public void setRdnwijzadres(Rdnwijzadres rdnwijzadres) {
        this.rdnwijzadres = rdnwijzadres;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pers", nullable = false)
    public Pers getPers() {
        return this.pers;
    }

    public void setPers(Pers pers) {
        this.pers = pers;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gem", nullable = false)
    public Gem getGem() {
        return this.gem;
    }

    public void setGem(Gem gem) {
        this.gem = gem;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aangadresh")
    public Aangadresh getAangadresh() {
        return this.aangadresh;
    }

    public void setAangadresh(Aangadresh aangadresh) {
        this.aangadresh = aangadresh;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wpl")
    public Plaats getPlaats() {
        return this.plaats;
    }

    public void setPlaats(Plaats plaats) {
        this.plaats = plaats;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "functie", nullable = false)
    public Functieadres getFunctieadres() {
        return this.functieadres;
    }

    public void setFunctieadres(Functieadres functieadres) {
        this.functieadres = functieadres;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actiebegin")
    public Actie getActie() {
        return this.actie;
    }

    public void setActie(Actie actie) {
        this.actie = actie;
    }

    @Column(name = "dataanvadresh", nullable = false, precision = 8)
    public BigDecimal getDataanvadresh() {
        return this.dataanvadresh;
    }

    public void setDataanvadresh(BigDecimal dataanvadresh) {
        this.dataanvadresh = dataanvadresh;
    }

    @Column(name = "adresseerbaarobject", length = 16)
    public String getAdresseerbaarobject() {
        return this.adresseerbaarobject;
    }

    public void setAdresseerbaarobject(String adresseerbaarobject) {
        this.adresseerbaarobject = adresseerbaarobject;
    }

    @Column(name = "identcodenraand", length = 16)
    public String getIdentcodenraand() {
        return this.identcodenraand;
    }

    public void setIdentcodenraand(String identcodenraand) {
        this.identcodenraand = identcodenraand;
    }

    @Column(name = "nor", length = 80)
    public String getNor() {
        return this.nor;
    }

    public void setNor(String nor) {
        this.nor = nor;
    }

    @Column(name = "afgekortenor", length = 24)
    public String getAfgekortenor() {
        return this.afgekortenor;
    }

    public void setAfgekortenor(String afgekortenor) {
        this.afgekortenor = afgekortenor;
    }

    @Column(name = "gemdeel", length = 24)
    public String getGemdeel() {
        return this.gemdeel;
    }

    public void setGemdeel(String gemdeel) {
        this.gemdeel = gemdeel;
    }

    @Column(name = "huisnr", precision = 5)
    public BigDecimal getHuisnr() {
        return this.huisnr;
    }

    public void setHuisnr(BigDecimal huisnr) {
        this.huisnr = huisnr;
    }

    @Column(name = "huisletter", length = 1)
    public String getHuisletter() {
        return this.huisletter;
    }

    public void setHuisletter(String huisletter) {
        this.huisletter = huisletter;
    }

    @Column(name = "huisnrtoevoeging", length = 4)
    public String getHuisnrtoevoeging() {
        return this.huisnrtoevoeging;
    }

    public void setHuisnrtoevoeging(String huisnrtoevoeging) {
        this.huisnrtoevoeging = huisnrtoevoeging;
    }

    @Column(name = "postcode", length = 6)
    public String getPostcode() {
        return this.postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Column(name = "loctovadres", length = 2)
    public String getLoctovadres() {
        return this.loctovadres;
    }

    public void setLoctovadres(String loctovadres) {
        this.loctovadres = loctovadres;
    }

    @Column(name = "locoms", length = 80)
    public String getLocoms() {
        return this.locoms;
    }

    public void setLocoms(String locoms) {
        this.locoms = locoms;
    }

    @Column(name = "bladresregel1", length = 80)
    public String getBladresregel1() {
        return this.bladresregel1;
    }

    public void setBladresregel1(String bladresregel1) {
        this.bladresregel1 = bladresregel1;
    }

    @Column(name = "bladresregel2", length = 80)
    public String getBladresregel2() {
        return this.bladresregel2;
    }

    public void setBladresregel2(String bladresregel2) {
        this.bladresregel2 = bladresregel2;
    }

    @Column(name = "bladresregel3", length = 80)
    public String getBladresregel3() {
        return this.bladresregel3;
    }

    public void setBladresregel3(String bladresregel3) {
        this.bladresregel3 = bladresregel3;
    }

    @Column(name = "bladresregel4", length = 80)
    public String getBladresregel4() {
        return this.bladresregel4;
    }

    public void setBladresregel4(String bladresregel4) {
        this.bladresregel4 = bladresregel4;
    }

    @Column(name = "bladresregel5", length = 80)
    public String getBladresregel5() {
        return this.bladresregel5;
    }

    public void setBladresregel5(String bladresregel5) {
        this.bladresregel5 = bladresregel5;
    }

    @Column(name = "bladresregel6", length = 80)
    public String getBladresregel6() {
        return this.bladresregel6;
    }

    public void setBladresregel6(String bladresregel6) {
        this.bladresregel6 = bladresregel6;
    }

    @Column(name = "datvertrekuitnederland", nullable = false, precision = 8)
    public BigDecimal getDatvertrekuitnederland() {
        return this.datvertrekuitnederland;
    }

    public void setDatvertrekuitnederland(BigDecimal datvertrekuitnederland) {
        this.datvertrekuitnederland = datvertrekuitnederland;
    }

    @Column(name = "dataanvgel", precision = 8)
    public BigDecimal getDataanvgel() {
        return this.dataanvgel;
    }

    public void setDataanvgel(BigDecimal dataanvgel) {
        this.dataanvgel = dataanvgel;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dattijdreg", length = 29)
    public Date getDattijdreg() {
        return this.dattijdreg;
    }

    public void setDattijdreg(Date dattijdreg) {
        this.dattijdreg = dattijdreg;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persadres")
    public Set<Hispersadresadresh> getHispersadresadreshs() {
        return this.hispersadresadreshs;
    }

    public void setHispersadresadreshs(Set<Hispersadresadresh> hispersadresadreshs) {
        this.hispersadresadreshs = hispersadresadreshs;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persadres")
    public Set<Hispersadresnladres> getHispersadresnladreses() {
        return this.hispersadresnladreses;
    }

    public void setHispersadresnladreses(Set<Hispersadresnladres> hispersadresnladreses) {
        this.hispersadresnladreses = hispersadresnladreses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persadres")
    public Set<Hispersadresbladres> getHispersadresbladreses() {
        return this.hispersadresbladreses;
    }

    public void setHispersadresbladreses(Set<Hispersadresbladres> hispersadresbladreses) {
        this.hispersadresbladreses = hispersadresbladreses;
    }

}
