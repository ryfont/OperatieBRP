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
import nl.bzk.brp.model.data.kern.HisErkenningongeborenvrucht;
import nl.bzk.brp.model.data.kern.Relatie;
import org.springframework.format.annotation.DateTimeFormat;

privileged aspect HisErkenningongeborenvrucht_Roo_DbManaged {
    
    @ManyToOne
    @JoinColumn(name = "actieverval", referencedColumnName = "id")
    private Actie HisErkenningongeborenvrucht.actieverval;
    
    @ManyToOne
    @JoinColumn(name = "actieinh", referencedColumnName = "id")
    private Actie HisErkenningongeborenvrucht.actieinh;
    
    @ManyToOne
    @JoinColumn(name = "relatie", referencedColumnName = "id")
    private Relatie HisErkenningongeborenvrucht.relatie;
    
    @Column(name = "tsreg", columnDefinition = "timestamp", unique = true)
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date HisErkenningongeborenvrucht.tsreg;
    
    @Column(name = "tsverval", columnDefinition = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date HisErkenningongeborenvrucht.tsverval;
    
    @Column(name = "daterkenningongeborenvrucht", columnDefinition = "int4")
    @NotNull
    private Integer HisErkenningongeborenvrucht.daterkenningongeborenvrucht;
    
    public Actie HisErkenningongeborenvrucht.getActieverval() {
        return actieverval;
    }
    
    public void HisErkenningongeborenvrucht.setActieverval(Actie actieverval) {
        this.actieverval = actieverval;
    }
    
    public Actie HisErkenningongeborenvrucht.getActieinh() {
        return actieinh;
    }
    
    public void HisErkenningongeborenvrucht.setActieinh(Actie actieinh) {
        this.actieinh = actieinh;
    }
    
    public Relatie HisErkenningongeborenvrucht.getRelatie() {
        return relatie;
    }
    
    public void HisErkenningongeborenvrucht.setRelatie(Relatie relatie) {
        this.relatie = relatie;
    }
    
    public Date HisErkenningongeborenvrucht.getTsreg() {
        return tsreg;
    }
    
    public void HisErkenningongeborenvrucht.setTsreg(Date tsreg) {
        this.tsreg = tsreg;
    }
    
    public Date HisErkenningongeborenvrucht.getTsverval() {
        return tsverval;
    }
    
    public void HisErkenningongeborenvrucht.setTsverval(Date tsverval) {
        this.tsverval = tsverval;
    }
    
    public Integer HisErkenningongeborenvrucht.getDaterkenningongeborenvrucht() {
        return daterkenningongeborenvrucht;
    }
    
    public void HisErkenningongeborenvrucht.setDaterkenningongeborenvrucht(Integer daterkenningongeborenvrucht) {
        this.daterkenningongeborenvrucht = daterkenningongeborenvrucht;
    }
    
}
