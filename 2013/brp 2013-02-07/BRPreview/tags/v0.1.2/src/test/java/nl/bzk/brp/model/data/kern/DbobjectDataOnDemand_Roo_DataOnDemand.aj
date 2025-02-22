// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import nl.bzk.brp.model.data.kern.Dbobject;
import nl.bzk.brp.model.data.kern.DbobjectDataOnDemand;
import nl.bzk.brp.model.data.kern.Srtdbobject;
import nl.bzk.brp.model.data.kern.SrtdbobjectDataOnDemand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect DbobjectDataOnDemand_Roo_DataOnDemand {
    
    declare @type: DbobjectDataOnDemand: @Component;
    
    private Random DbobjectDataOnDemand.rnd = new SecureRandom();
    
    private List<Dbobject> DbobjectDataOnDemand.data;
    
    @Autowired
    private SrtdbobjectDataOnDemand DbobjectDataOnDemand.srtdbobjectDataOnDemand;
    
    public Dbobject DbobjectDataOnDemand.getNewTransientDbobject(int index) {
        Dbobject obj = new Dbobject();
        setDataanvgel(obj, index);
        setDateindegel(obj, index);
        setJavaidentifier(obj, index);
        setNaam(obj, index);
        setOuder(obj, index);
        setSrt(obj, index);
        return obj;
    }
    
    public void DbobjectDataOnDemand.setDataanvgel(Dbobject obj, int index) {
        BigDecimal dataanvgel = BigDecimal.valueOf(index);
        obj.setDataanvgel(dataanvgel);
    }
    
    public void DbobjectDataOnDemand.setDateindegel(Dbobject obj, int index) {
        BigDecimal dateindegel = BigDecimal.valueOf(index);
        obj.setDateindegel(dateindegel);
    }
    
    public void DbobjectDataOnDemand.setJavaidentifier(Dbobject obj, int index) {
        String javaidentifier = "javaidentifier_" + index;
        if (javaidentifier.length() > 80) {
            javaidentifier = javaidentifier.substring(0, 80);
        }
        obj.setJavaidentifier(javaidentifier);
    }
    
    public void DbobjectDataOnDemand.setNaam(Dbobject obj, int index) {
        String naam = "naam_" + index;
        if (naam.length() > 40) {
            naam = naam.substring(0, 40);
        }
        obj.setNaam(naam);
    }
    
    public void DbobjectDataOnDemand.setOuder(Dbobject obj, int index) {
        Dbobject ouder = obj;
        obj.setOuder(ouder);
    }
    
    public void DbobjectDataOnDemand.setSrt(Dbobject obj, int index) {
        Srtdbobject srt = srtdbobjectDataOnDemand.getRandomSrtdbobject();
        obj.setSrt(srt);
    }
    
    public Dbobject DbobjectDataOnDemand.getSpecificDbobject(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Dbobject obj = data.get(index);
        Integer id = obj.getId();
        return Dbobject.findDbobject(id);
    }
    
    public Dbobject DbobjectDataOnDemand.getRandomDbobject() {
        init();
        Dbobject obj = data.get(rnd.nextInt(data.size()));
        Integer id = obj.getId();
        return Dbobject.findDbobject(id);
    }
    
    public boolean DbobjectDataOnDemand.modifyDbobject(Dbobject obj) {
        return false;
    }
    
    public void DbobjectDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = Dbobject.findDbobjectEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Dbobject' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Dbobject>();
        for (int i = 0; i < 10; i++) {
            Dbobject obj = getNewTransientDbobject(i);
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
