// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import nl.bzk.brp.model.data.kern.Actie;
import nl.bzk.brp.model.data.kern.Betr;
import nl.bzk.brp.model.data.kern.HisBetrouderschap;
import org.springframework.format.annotation.DateTimeFormat;

privileged aspect HisBetrouderschap_Roo_DbManaged {
    
    @ManyToOne
    @JoinColumn(name = "actieinh", referencedColumnName = "id")
    private Actie HisBetrouderschap.actieinh;
    
    @ManyToOne
    @JoinColumn(name = "actieverval", referencedColumnName = "id")
    private Actie HisBetrouderschap.actieverval;
    
    @ManyToOne
    @JoinColumn(name = "actieaanpgel", referencedColumnName = "id")
    private Actie HisBetrouderschap.actieaanpgel;
    
    @ManyToOne
    @JoinColumn(name = "betr", referencedColumnName = "id")
    private Betr HisBetrouderschap.betr;
    
    @Column(name = "dataanvgel", columnDefinition = "int4", unique = true)
    private Integer HisBetrouderschap.dataanvgel;
    
    @Column(name = "dateindegel", columnDefinition = "int4")
    private Integer HisBetrouderschap.dateindegel;
    
    @Column(name = "tsreg", columnDefinition = "timestamp", unique = true)
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date HisBetrouderschap.tsreg;
    
    @Column(name = "tsverval", columnDefinition = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date HisBetrouderschap.tsverval;
    
    @Column(name = "indouder", columnDefinition = "bool")
    @NotNull
    private boolean HisBetrouderschap.indouder;
    
    public Actie HisBetrouderschap.getActieinh() {
        return actieinh;
    }
    
    public void HisBetrouderschap.setActieinh(Actie actieinh) {
        this.actieinh = actieinh;
    }
    
    public Actie HisBetrouderschap.getActieverval() {
        return actieverval;
    }
    
    public void HisBetrouderschap.setActieverval(Actie actieverval) {
        this.actieverval = actieverval;
    }
    
    public Actie HisBetrouderschap.getActieaanpgel() {
        return actieaanpgel;
    }
    
    public void HisBetrouderschap.setActieaanpgel(Actie actieaanpgel) {
        this.actieaanpgel = actieaanpgel;
    }
    
    public Betr HisBetrouderschap.getBetr() {
        return betr;
    }
    
    public void HisBetrouderschap.setBetr(Betr betr) {
        this.betr = betr;
    }
    
    public Integer HisBetrouderschap.getDataanvgel() {
        return dataanvgel;
    }
    
    public void HisBetrouderschap.setDataanvgel(Integer dataanvgel) {
        this.dataanvgel = dataanvgel;
    }
    
    public Integer HisBetrouderschap.getDateindegel() {
        return dateindegel;
    }
    
    public void HisBetrouderschap.setDateindegel(Integer dateindegel) {
        this.dateindegel = dateindegel;
    }
    
    public Date HisBetrouderschap.getTsreg() {
        return tsreg;
    }
    
    public void HisBetrouderschap.setTsreg(Date tsreg) {
        this.tsreg = tsreg;
    }
    
    public Date HisBetrouderschap.getTsverval() {
        return tsverval;
    }
    
    public void HisBetrouderschap.setTsverval(Date tsverval) {
        this.tsverval = tsverval;
    }
    
    public boolean HisBetrouderschap.isIndouder() {
        return indouder;
    }
    
    public void HisBetrouderschap.setIndouder(boolean indouder) {
        this.indouder = indouder;
    }
    
}
