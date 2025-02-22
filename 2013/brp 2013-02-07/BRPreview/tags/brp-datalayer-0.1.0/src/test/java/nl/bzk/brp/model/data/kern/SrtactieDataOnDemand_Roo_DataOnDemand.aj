// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import nl.bzk.brp.model.data.kern.Categoriesrtactie;
import nl.bzk.brp.model.data.kern.CategoriesrtactieDataOnDemand;
import nl.bzk.brp.model.data.kern.Srtactie;
import nl.bzk.brp.model.data.kern.SrtactieDataOnDemand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect SrtactieDataOnDemand_Roo_DataOnDemand {
    
    declare @type: SrtactieDataOnDemand: @Component;
    
    private Random SrtactieDataOnDemand.rnd = new SecureRandom();
    
    private List<Srtactie> SrtactieDataOnDemand.data;
    
    @Autowired
    private CategoriesrtactieDataOnDemand SrtactieDataOnDemand.categoriesrtactieDataOnDemand;
    
    public Srtactie SrtactieDataOnDemand.getNewTransientSrtactie(int index) {
        Srtactie obj = new Srtactie();
        setCategoriesrtactie(obj, index);
        setNaam(obj, index);
        return obj;
    }
    
    public void SrtactieDataOnDemand.setCategoriesrtactie(Srtactie obj, int index) {
        Categoriesrtactie categoriesrtactie = categoriesrtactieDataOnDemand.getRandomCategoriesrtactie();
        obj.setCategoriesrtactie(categoriesrtactie);
    }
    
    public void SrtactieDataOnDemand.setNaam(Srtactie obj, int index) {
        String naam = "naam_" + index;
        if (naam.length() > 40) {
            naam = new Random().nextInt(10) + naam.substring(1, 40);
        }
        obj.setNaam(naam);
    }
    
    public Srtactie SrtactieDataOnDemand.getSpecificSrtactie(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Srtactie obj = data.get(index);
        Integer id = obj.getId();
        return Srtactie.findSrtactie(id);
    }
    
    public Srtactie SrtactieDataOnDemand.getRandomSrtactie() {
        init();
        Srtactie obj = data.get(rnd.nextInt(data.size()));
        Integer id = obj.getId();
        return Srtactie.findSrtactie(id);
    }
    
    public boolean SrtactieDataOnDemand.modifySrtactie(Srtactie obj) {
        return false;
    }
    
    public void SrtactieDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = Srtactie.findSrtactieEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Srtactie' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Srtactie>();
        for (int i = 0; i < 10; i++) {
            Srtactie obj = getNewTransientSrtactie(i);
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
