// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.brm;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import nl.bzk.brp.model.data.brm.Regeleffect;
import nl.bzk.brp.model.data.brm.RegeleffectDataOnDemand;
import org.springframework.stereotype.Component;

privileged aspect RegeleffectDataOnDemand_Roo_DataOnDemand {
    
    declare @type: RegeleffectDataOnDemand: @Component;
    
    private Random RegeleffectDataOnDemand.rnd = new SecureRandom();
    
    private List<Regeleffect> RegeleffectDataOnDemand.data;
    
    public Regeleffect RegeleffectDataOnDemand.getNewTransientRegeleffect(int index) {
        Regeleffect obj = new Regeleffect();
        setDataanvgel(obj, index);
        setDateindegel(obj, index);
        setNaam(obj, index);
        setOms(obj, index);
        return obj;
    }
    
    public void RegeleffectDataOnDemand.setDataanvgel(Regeleffect obj, int index) {
        BigDecimal dataanvgel = BigDecimal.valueOf(index);
        obj.setDataanvgel(dataanvgel);
    }
    
    public void RegeleffectDataOnDemand.setDateindegel(Regeleffect obj, int index) {
        BigDecimal dateindegel = BigDecimal.valueOf(index);
        obj.setDateindegel(dateindegel);
    }
    
    public void RegeleffectDataOnDemand.setNaam(Regeleffect obj, int index) {
        String naam = "naam_" + index;
        if (naam.length() > 40) {
            naam = new Random().nextInt(10) + naam.substring(1, 40);
        }
        obj.setNaam(naam);
    }
    
    public void RegeleffectDataOnDemand.setOms(Regeleffect obj, int index) {
        String oms = "oms_" + index;
        if (oms.length() > 250) {
            oms = new Random().nextInt(10) + oms.substring(1, 250);
        }
        obj.setOms(oms);
    }
    
    public Regeleffect RegeleffectDataOnDemand.getSpecificRegeleffect(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Regeleffect obj = data.get(index);
        Short id = obj.getId();
        return Regeleffect.findRegeleffect(id);
    }
    
    public Regeleffect RegeleffectDataOnDemand.getRandomRegeleffect() {
        init();
        Regeleffect obj = data.get(rnd.nextInt(data.size()));
        Short id = obj.getId();
        return Regeleffect.findRegeleffect(id);
    }
    
    public boolean RegeleffectDataOnDemand.modifyRegeleffect(Regeleffect obj) {
        return false;
    }
    
    public void RegeleffectDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = Regeleffect.findRegeleffectEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Regeleffect' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Regeleffect>();
        for (int i = 0; i < 10; i++) {
            Regeleffect obj = getNewTransientRegeleffect(i);
            try {
                obj.persist();
            } catch (ConstraintViolationException e) {
                StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getConstraintDescriptor()).append(":").append(cv.getMessage()).append("=").append(cv.getInvalidValue()).append("]");
                }
                throw new RuntimeException(msg.toString(), e);
            }
            obj.flush();
            data.add(obj);
        }
    }
    
}
