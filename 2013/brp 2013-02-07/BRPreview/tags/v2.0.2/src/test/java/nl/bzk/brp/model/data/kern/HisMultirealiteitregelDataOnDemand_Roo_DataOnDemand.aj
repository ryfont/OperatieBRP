// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

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
import nl.bzk.brp.model.data.kern.Actie;
import nl.bzk.brp.model.data.kern.ActieDataOnDemand;
import nl.bzk.brp.model.data.kern.HisMultirealiteitregel;
import nl.bzk.brp.model.data.kern.HisMultirealiteitregelDataOnDemand;
import nl.bzk.brp.model.data.kern.Multirealiteitregel;
import nl.bzk.brp.model.data.kern.MultirealiteitregelDataOnDemand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect HisMultirealiteitregelDataOnDemand_Roo_DataOnDemand {
    
    declare @type: HisMultirealiteitregelDataOnDemand: @Component;
    
    private Random HisMultirealiteitregelDataOnDemand.rnd = new SecureRandom();
    
    private List<HisMultirealiteitregel> HisMultirealiteitregelDataOnDemand.data;
    
    @Autowired
    private ActieDataOnDemand HisMultirealiteitregelDataOnDemand.actieDataOnDemand;
    
    @Autowired
    private MultirealiteitregelDataOnDemand HisMultirealiteitregelDataOnDemand.multirealiteitregelDataOnDemand;
    
    public HisMultirealiteitregel HisMultirealiteitregelDataOnDemand.getNewTransientHisMultirealiteitregel(int index) {
        HisMultirealiteitregel obj = new HisMultirealiteitregel();
        setActieinh(obj, index);
        setActieverval(obj, index);
        setMultirealiteitregel(obj, index);
        setTsreg(obj, index);
        setTsverval(obj, index);
        return obj;
    }
    
    public void HisMultirealiteitregelDataOnDemand.setActieinh(HisMultirealiteitregel obj, int index) {
        Actie actieinh = actieDataOnDemand.getRandomActie();
        obj.setActieinh(actieinh);
    }
    
    public void HisMultirealiteitregelDataOnDemand.setActieverval(HisMultirealiteitregel obj, int index) {
        Actie actieverval = actieDataOnDemand.getRandomActie();
        obj.setActieverval(actieverval);
    }
    
    public void HisMultirealiteitregelDataOnDemand.setMultirealiteitregel(HisMultirealiteitregel obj, int index) {
        Multirealiteitregel multirealiteitregel = multirealiteitregelDataOnDemand.getRandomMultirealiteitregel();
        obj.setMultirealiteitregel(multirealiteitregel);
    }
    
    public void HisMultirealiteitregelDataOnDemand.setTsreg(HisMultirealiteitregel obj, int index) {
        Date tsreg = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setTsreg(tsreg);
    }
    
    public void HisMultirealiteitregelDataOnDemand.setTsverval(HisMultirealiteitregel obj, int index) {
        Date tsverval = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setTsverval(tsverval);
    }
    
    public HisMultirealiteitregel HisMultirealiteitregelDataOnDemand.getSpecificHisMultirealiteitregel(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        HisMultirealiteitregel obj = data.get(index);
        Long id = obj.getId();
        return HisMultirealiteitregel.findHisMultirealiteitregel(id);
    }
    
    public HisMultirealiteitregel HisMultirealiteitregelDataOnDemand.getRandomHisMultirealiteitregel() {
        init();
        HisMultirealiteitregel obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return HisMultirealiteitregel.findHisMultirealiteitregel(id);
    }
    
    public boolean HisMultirealiteitregelDataOnDemand.modifyHisMultirealiteitregel(HisMultirealiteitregel obj) {
        return false;
    }
    
    public void HisMultirealiteitregelDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = HisMultirealiteitregel.findHisMultirealiteitregelEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'HisMultirealiteitregel' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<HisMultirealiteitregel>();
        for (int i = 0; i < 10; i++) {
            HisMultirealiteitregel obj = getNewTransientHisMultirealiteitregel(i);
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
