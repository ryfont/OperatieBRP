/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;
// Generated 12-sep-2012 11:17:43 by Hibernate Tools 3.2.4.GA



/**
 * HisPersaanschr generated by hbm2java
 */
public class HisPersaanschr extends HisMaterieel {


     private Predikaat predikaat;
     private Pers pers;
     private Wijzegebruikgeslnaam wijzegebruikgeslnaam;
     private Adellijketitel adellijketitel;
     private Boolean indaanschrmetadellijketitels;
     private boolean indaanschralgoritmischafgele;
     private String voornamenaanschr;
     private String voorvoegselaanschr;
     private String scheidingstekenaanschr;
     private String geslnaamaanschr;

    public HisPersaanschr() {
    }

    public HisPersaanschr(final Pers pers) {
        this.pers = pers;
        geslnaamaanschr = pers.getGeslnaamaanschr();
        indaanschralgoritmischafgele = pers.getIndaanschralgoritmischafgele();
        predikaat = pers.getPredikaatByPredikaat();
        wijzegebruikgeslnaam = pers.getWijzegebruikgeslnaam();
        indaanschrmetadellijketitels = pers.getIndaanschrmetadellijketitels();
        voornamenaanschr = pers.getVoornamenaanschr();
        voorvoegselaanschr = pers.getVoorvoegselaanschr();
        scheidingstekenaanschr = pers.getScheidingstekenaanschr();
    }

    public Predikaat getPredikaat() {
        return this.predikaat;
    }

    public void setPredikaat(final Predikaat predikaat) {
        this.predikaat = predikaat;
    }
    public Pers getPers() {
        return this.pers;
    }

    public void setPers(final Pers pers) {
        this.pers = pers;
    }
    public Wijzegebruikgeslnaam getWijzegebruikgeslnaam() {
        return this.wijzegebruikgeslnaam;
    }

    public void setWijzegebruikgeslnaam(final Wijzegebruikgeslnaam wijzegebruikgeslnaam) {
        this.wijzegebruikgeslnaam = wijzegebruikgeslnaam;
    }
    public Adellijketitel getAdellijketitel() {
        return this.adellijketitel;
    }

    public void setAdellijketitel(final Adellijketitel adellijketitel) {
        this.adellijketitel = adellijketitel;
    }
    public Boolean getIndaanschrmetadellijketitels() {
        return this.indaanschrmetadellijketitels;
    }

    public void setIndaanschrmetadellijketitels(final Boolean indaanschrmetadellijketitels) {
        this.indaanschrmetadellijketitels = indaanschrmetadellijketitels;
    }
    public boolean isIndaanschralgoritmischafgele() {
        return this.indaanschralgoritmischafgele;
    }

    public void setIndaanschralgoritmischafgele(final boolean indaanschralgoritmischafgele) {
        this.indaanschralgoritmischafgele = indaanschralgoritmischafgele;
    }
    public String getVoornamenaanschr() {
        return this.voornamenaanschr;
    }

    public void setVoornamenaanschr(final String voornamenaanschr) {
        this.voornamenaanschr = voornamenaanschr;
    }
    public String getVoorvoegselaanschr() {
        return this.voorvoegselaanschr;
    }

    public void setVoorvoegselaanschr(final String voorvoegselaanschr) {
        this.voorvoegselaanschr = voorvoegselaanschr;
    }
    public String getScheidingstekenaanschr() {
        return this.scheidingstekenaanschr;
    }

    public void setScheidingstekenaanschr(final String scheidingstekenaanschr) {
        this.scheidingstekenaanschr = scheidingstekenaanschr;
    }
    public String getGeslnaamaanschr() {
        return this.geslnaamaanschr;
    }

    public void setGeslnaamaanschr(final String geslnaamaanschr) {
        this.geslnaamaanschr = geslnaamaanschr;
    }




}


