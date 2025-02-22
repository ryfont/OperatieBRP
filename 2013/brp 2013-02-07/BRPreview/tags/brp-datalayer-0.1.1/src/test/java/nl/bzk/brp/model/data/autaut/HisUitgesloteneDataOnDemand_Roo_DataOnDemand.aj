// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.autaut;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import nl.bzk.brp.model.data.autaut.HisUitgeslotene;
import nl.bzk.brp.model.data.autaut.HisUitgesloteneDataOnDemand;
import nl.bzk.brp.model.data.autaut.Uitgeslotene;
import nl.bzk.brp.model.data.autaut.UitgesloteneDataOnDemand;
import nl.bzk.brp.model.data.kern.Actie;
import nl.bzk.brp.model.data.kern.ActieDataOnDemand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect HisUitgesloteneDataOnDemand_Roo_DataOnDemand {
    
    declare @type: HisUitgesloteneDataOnDemand: @Component;
    
    private Random HisUitgesloteneDataOnDemand.rnd = new SecureRandom();
    
    private List<HisUitgeslotene> HisUitgesloteneDataOnDemand.data;
    
    @Autowired
    private ActieDataOnDemand HisUitgesloteneDataOnDemand.actieDataOnDemand;
    
    @Autowired
    private UitgesloteneDataOnDemand HisUitgesloteneDataOnDemand.uitgesloteneDataOnDemand;
    
    public HisUitgeslotene HisUitgesloteneDataOnDemand.getNewTransientHisUitgeslotene(int index) {
        HisUitgeslotene obj = new HisUitgeslotene();
        setActieinh(obj, index);
        setActieverval(obj, index);
        setTsreg(obj, index);
        setTsverval(obj, index);
        setUitgeslotene(obj, index);
        return obj;
    }
    
    public void HisUitgesloteneDataOnDemand.setActieinh(HisUitgeslotene obj, int index) {
        Actie actieinh = actieDataOnDemand.getRandomActie();
        obj.setActieinh(actieinh);
    }
    
    public void HisUitgesloteneDataOnDemand.setActieverval(HisUitgeslotene obj, int index) {
        Actie actieverval = actieDataOnDemand.getRandomActie();
        obj.setActieverval(actieverval);
    }
    
    public void HisUitgesloteneDataOnDemand.setTsreg(HisUitgeslotene obj, int index) {
        Date tsreg = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setTsreg(tsreg);
    }
    
    public void HisUitgesloteneDataOnDemand.setTsverval(HisUitgeslotene obj, int index) {
        Date tsverval = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setTsverval(tsverval);
    }
    
    public void HisUitgesloteneDataOnDemand.setUitgeslotene(HisUitgeslotene obj, int index) {
        Uitgeslotene uitgeslotene = uitgesloteneDataOnDemand.getRandomUitgeslotene();
        obj.setUitgeslotene(uitgeslotene);
    }
    
    public HisUitgeslotene HisUitgesloteneDataOnDemand.getSpecificHisUitgeslotene(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        HisUitgeslotene obj = data.get(index);
        Long id = obj.getId();
        return HisUitgeslotene.findHisUitgeslotene(id);
    }
    
    public HisUitgeslotene HisUitgesloteneDataOnDemand.getRandomHisUitgeslotene() {
        init();
        HisUitgeslotene obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return HisUitgeslotene.findHisUitgeslotene(id);
    }
    
    public boolean HisUitgesloteneDataOnDemand.modifyHisUitgeslotene(HisUitgeslotene obj) {
        return false;
    }
    
    public void HisUitgesloteneDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = HisUitgeslotene.findHisUitgesloteneEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'HisUitgeslotene' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<HisUitgeslotene>();
        for (int i = 0; i < 10; i++) {
            HisUitgeslotene obj = getNewTransientHisUitgeslotene(i);
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
