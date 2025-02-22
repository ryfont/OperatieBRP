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
import nl.bzk.brp.model.data.kern.Actie;
import nl.bzk.brp.model.data.kern.ActieDataOnDemand;
import nl.bzk.brp.model.data.kern.Bron;
import nl.bzk.brp.model.data.kern.BronDataOnDemand;
import nl.bzk.brp.model.data.kern.Doc;
import nl.bzk.brp.model.data.kern.DocDataOnDemand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect BronDataOnDemand_Roo_DataOnDemand {
    
    declare @type: BronDataOnDemand: @Component;
    
    private Random BronDataOnDemand.rnd = new SecureRandom();
    
    private List<Bron> BronDataOnDemand.data;
    
    @Autowired
    private ActieDataOnDemand BronDataOnDemand.actieDataOnDemand;
    
    @Autowired
    private DocDataOnDemand BronDataOnDemand.docDataOnDemand;
    
    public Bron BronDataOnDemand.getNewTransientBron(int index) {
        Bron obj = new Bron();
        setActie(obj, index);
        setDoc(obj, index);
        return obj;
    }
    
    public void BronDataOnDemand.setActie(Bron obj, int index) {
        Actie actie = actieDataOnDemand.getRandomActie();
        obj.setActie(actie);
    }
    
    public void BronDataOnDemand.setDoc(Bron obj, int index) {
        Doc doc = docDataOnDemand.getRandomDoc();
        obj.setDoc(doc);
    }
    
    public Bron BronDataOnDemand.getSpecificBron(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Bron obj = data.get(index);
        Long id = obj.getId();
        return Bron.findBron(id);
    }
    
    public Bron BronDataOnDemand.getRandomBron() {
        init();
        Bron obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return Bron.findBron(id);
    }
    
    public boolean BronDataOnDemand.modifyBron(Bron obj) {
        return false;
    }
    
    public void BronDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = Bron.findBronEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Bron' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Bron>();
        for (int i = 0; i < 10; i++) {
            Bron obj = getNewTransientBron(i);
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
