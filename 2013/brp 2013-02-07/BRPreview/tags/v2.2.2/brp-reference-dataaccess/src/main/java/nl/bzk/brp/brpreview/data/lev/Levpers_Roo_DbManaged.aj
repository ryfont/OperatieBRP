// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.brpreview.data.lev;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import nl.bzk.brp.brpreview.data.kern.Pers;
import nl.bzk.brp.brpreview.data.lev.Lev;
import nl.bzk.brp.brpreview.data.lev.Levpers;

privileged aspect Levpers_Roo_DbManaged {
    
    @ManyToOne
    @JoinColumn(name = "pers", referencedColumnName = "id", nullable = false)
    private Pers Levpers.pers;
    
    @ManyToOne
    @JoinColumn(name = "lev", referencedColumnName = "id", nullable = false)
    private Lev Levpers.lev;
    
    public Pers Levpers.getPers() {
        return pers;
    }
    
    public void Levpers.setPers(Pers pers) {
        this.pers = pers;
    }
    
    public Lev Levpers.getLev() {
        return lev;
    }
    
    public void Levpers.setLev(Lev lev) {
        this.lev = lev;
    }
    
}
