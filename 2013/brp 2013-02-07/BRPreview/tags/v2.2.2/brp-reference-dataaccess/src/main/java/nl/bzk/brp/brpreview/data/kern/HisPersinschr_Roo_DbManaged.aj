// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.brpreview.data.kern;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import nl.bzk.brp.brpreview.data.kern.Actie;
import nl.bzk.brp.brpreview.data.kern.HisPersinschr;
import nl.bzk.brp.brpreview.data.kern.Pers;
import org.springframework.format.annotation.DateTimeFormat;

privileged aspect HisPersinschr_Roo_DbManaged {
    
    @ManyToOne
    @JoinColumn(name = "actieinh", referencedColumnName = "id")
    private Actie HisPersinschr.actieinh;
    
    @ManyToOne
    @JoinColumn(name = "actieverval", referencedColumnName = "id")
    private Actie HisPersinschr.actieverval;
    
    @ManyToOne
    @JoinColumn(name = "pers", referencedColumnName = "id")
    private Pers HisPersinschr.pers;
    
    @ManyToOne
    @JoinColumn(name = "vorigepers", referencedColumnName = "id")
    private Pers HisPersinschr.vorigepers;
    
    @ManyToOne
    @JoinColumn(name = "volgendepers", referencedColumnName = "id")
    private Pers HisPersinschr.volgendepers;
    
    @Column(name = "tsreg", columnDefinition = "timestamp", unique = true)
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date HisPersinschr.tsreg;
    
    @Column(name = "tsverval", columnDefinition = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date HisPersinschr.tsverval;
    
    @Column(name = "datinschr", columnDefinition = "int4")
    @NotNull
    private Integer HisPersinschr.datinschr;
    
    @Column(name = "versienr", columnDefinition = "int8")
    @NotNull
    private Long HisPersinschr.versienr;
    
    public Actie HisPersinschr.getActieinh() {
        return actieinh;
    }
    
    public void HisPersinschr.setActieinh(Actie actieinh) {
        this.actieinh = actieinh;
    }
    
    public Actie HisPersinschr.getActieverval() {
        return actieverval;
    }
    
    public void HisPersinschr.setActieverval(Actie actieverval) {
        this.actieverval = actieverval;
    }
    
    public Pers HisPersinschr.getPers() {
        return pers;
    }
    
    public void HisPersinschr.setPers(Pers pers) {
        this.pers = pers;
    }
    
    public Pers HisPersinschr.getVorigepers() {
        return vorigepers;
    }
    
    public void HisPersinschr.setVorigepers(Pers vorigepers) {
        this.vorigepers = vorigepers;
    }
    
    public Pers HisPersinschr.getVolgendepers() {
        return volgendepers;
    }
    
    public void HisPersinschr.setVolgendepers(Pers volgendepers) {
        this.volgendepers = volgendepers;
    }
    
    public Date HisPersinschr.getTsreg() {
        return tsreg;
    }
    
    public void HisPersinschr.setTsreg(Date tsreg) {
        this.tsreg = tsreg;
    }
    
    public Date HisPersinschr.getTsverval() {
        return tsverval;
    }
    
    public void HisPersinschr.setTsverval(Date tsverval) {
        this.tsverval = tsverval;
    }
    
    public Integer HisPersinschr.getDatinschr() {
        return datinschr;
    }
    
    public void HisPersinschr.setDatinschr(Integer datinschr) {
        this.datinschr = datinschr;
    }
    
    public Long HisPersinschr.getVersienr() {
        return versienr;
    }
    
    public void HisPersinschr.setVersienr(Long versienr) {
        this.versienr = versienr;
    }
    
}
