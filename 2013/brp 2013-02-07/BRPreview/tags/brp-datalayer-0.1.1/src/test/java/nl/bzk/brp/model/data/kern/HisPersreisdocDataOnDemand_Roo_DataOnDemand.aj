// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import java.math.BigDecimal;
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
import nl.bzk.brp.model.data.kern.Autvanafgiftereisdoc;
import nl.bzk.brp.model.data.kern.AutvanafgiftereisdocDataOnDemand;
import nl.bzk.brp.model.data.kern.HisPersreisdoc;
import nl.bzk.brp.model.data.kern.HisPersreisdocDataOnDemand;
import nl.bzk.brp.model.data.kern.Persreisdoc;
import nl.bzk.brp.model.data.kern.PersreisdocDataOnDemand;
import nl.bzk.brp.model.data.kern.Rdnvervallenreisdoc;
import nl.bzk.brp.model.data.kern.RdnvervallenreisdocDataOnDemand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect HisPersreisdocDataOnDemand_Roo_DataOnDemand {
    
    declare @type: HisPersreisdocDataOnDemand: @Component;
    
    private Random HisPersreisdocDataOnDemand.rnd = new SecureRandom();
    
    private List<HisPersreisdoc> HisPersreisdocDataOnDemand.data;
    
    @Autowired
    private ActieDataOnDemand HisPersreisdocDataOnDemand.actieDataOnDemand;
    
    @Autowired
    private AutvanafgiftereisdocDataOnDemand HisPersreisdocDataOnDemand.autvanafgiftereisdocDataOnDemand;
    
    @Autowired
    private PersreisdocDataOnDemand HisPersreisdocDataOnDemand.persreisdocDataOnDemand;
    
    @Autowired
    private RdnvervallenreisdocDataOnDemand HisPersreisdocDataOnDemand.rdnvervallenreisdocDataOnDemand;
    
    public HisPersreisdoc HisPersreisdocDataOnDemand.getNewTransientHisPersreisdoc(int index) {
        HisPersreisdoc obj = new HisPersreisdoc();
        setActieinh(obj, index);
        setActieverval(obj, index);
        setAutvanafgifte(obj, index);
        setDatinhingvermissing(obj, index);
        setDatuitgifte(obj, index);
        setDatvoorzeeindegel(obj, index);
        setLengtehouder(obj, index);
        setNr(obj, index);
        setPersreisdoc(obj, index);
        setRdnvervallen(obj, index);
        setTsreg(obj, index);
        setTsverval(obj, index);
        return obj;
    }
    
    public void HisPersreisdocDataOnDemand.setActieinh(HisPersreisdoc obj, int index) {
        Actie actieinh = actieDataOnDemand.getRandomActie();
        obj.setActieinh(actieinh);
    }
    
    public void HisPersreisdocDataOnDemand.setActieverval(HisPersreisdoc obj, int index) {
        Actie actieverval = actieDataOnDemand.getRandomActie();
        obj.setActieverval(actieverval);
    }
    
    public void HisPersreisdocDataOnDemand.setAutvanafgifte(HisPersreisdoc obj, int index) {
        Autvanafgiftereisdoc autvanafgifte = autvanafgiftereisdocDataOnDemand.getRandomAutvanafgiftereisdoc();
        obj.setAutvanafgifte(autvanafgifte);
    }
    
    public void HisPersreisdocDataOnDemand.setDatinhingvermissing(HisPersreisdoc obj, int index) {
        BigDecimal datinhingvermissing = BigDecimal.valueOf(index);
        obj.setDatinhingvermissing(datinhingvermissing);
    }
    
    public void HisPersreisdocDataOnDemand.setDatuitgifte(HisPersreisdoc obj, int index) {
        BigDecimal datuitgifte = BigDecimal.valueOf(index);
        obj.setDatuitgifte(datuitgifte);
    }
    
    public void HisPersreisdocDataOnDemand.setDatvoorzeeindegel(HisPersreisdoc obj, int index) {
        BigDecimal datvoorzeeindegel = BigDecimal.valueOf(index);
        obj.setDatvoorzeeindegel(datvoorzeeindegel);
    }
    
    public void HisPersreisdocDataOnDemand.setLengtehouder(HisPersreisdoc obj, int index) {
        BigDecimal lengtehouder = BigDecimal.valueOf(index);
        obj.setLengtehouder(lengtehouder);
    }
    
    public void HisPersreisdocDataOnDemand.setNr(HisPersreisdoc obj, int index) {
        String nr = "nr_" + index;
        if (nr.length() > 9) {
            nr = nr.substring(0, 9);
        }
        obj.setNr(nr);
    }
    
    public void HisPersreisdocDataOnDemand.setPersreisdoc(HisPersreisdoc obj, int index) {
        Persreisdoc persreisdoc = persreisdocDataOnDemand.getRandomPersreisdoc();
        obj.setPersreisdoc(persreisdoc);
    }
    
    public void HisPersreisdocDataOnDemand.setRdnvervallen(HisPersreisdoc obj, int index) {
        Rdnvervallenreisdoc rdnvervallen = rdnvervallenreisdocDataOnDemand.getRandomRdnvervallenreisdoc();
        obj.setRdnvervallen(rdnvervallen);
    }
    
    public void HisPersreisdocDataOnDemand.setTsreg(HisPersreisdoc obj, int index) {
        Date tsreg = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setTsreg(tsreg);
    }
    
    public void HisPersreisdocDataOnDemand.setTsverval(HisPersreisdoc obj, int index) {
        Date tsverval = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setTsverval(tsverval);
    }
    
    public HisPersreisdoc HisPersreisdocDataOnDemand.getSpecificHisPersreisdoc(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        HisPersreisdoc obj = data.get(index);
        Long id = obj.getId();
        return HisPersreisdoc.findHisPersreisdoc(id);
    }
    
    public HisPersreisdoc HisPersreisdocDataOnDemand.getRandomHisPersreisdoc() {
        init();
        HisPersreisdoc obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return HisPersreisdoc.findHisPersreisdoc(id);
    }
    
    public boolean HisPersreisdocDataOnDemand.modifyHisPersreisdoc(HisPersreisdoc obj) {
        return false;
    }
    
    public void HisPersreisdocDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = HisPersreisdoc.findHisPersreisdocEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'HisPersreisdoc' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<HisPersreisdoc>();
        for (int i = 0; i < 10; i++) {
            HisPersreisdoc obj = getNewTransientHisPersreisdoc(i);
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
