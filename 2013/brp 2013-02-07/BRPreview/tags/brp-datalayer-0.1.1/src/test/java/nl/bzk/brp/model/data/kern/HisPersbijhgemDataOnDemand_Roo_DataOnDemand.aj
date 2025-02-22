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
import nl.bzk.brp.model.data.kern.HisPersbijhgem;
import nl.bzk.brp.model.data.kern.HisPersbijhgemDataOnDemand;
import nl.bzk.brp.model.data.kern.Partij;
import nl.bzk.brp.model.data.kern.PartijDataOnDemand;
import nl.bzk.brp.model.data.kern.Pers;
import nl.bzk.brp.model.data.kern.PersDataOnDemand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect HisPersbijhgemDataOnDemand_Roo_DataOnDemand {
    
    declare @type: HisPersbijhgemDataOnDemand: @Component;
    
    private Random HisPersbijhgemDataOnDemand.rnd = new SecureRandom();
    
    private List<HisPersbijhgem> HisPersbijhgemDataOnDemand.data;
    
    @Autowired
    private ActieDataOnDemand HisPersbijhgemDataOnDemand.actieDataOnDemand;
    
    @Autowired
    private PartijDataOnDemand HisPersbijhgemDataOnDemand.partijDataOnDemand;
    
    @Autowired
    private PersDataOnDemand HisPersbijhgemDataOnDemand.persDataOnDemand;
    
    public HisPersbijhgem HisPersbijhgemDataOnDemand.getNewTransientHisPersbijhgem(int index) {
        HisPersbijhgem obj = new HisPersbijhgem();
        setActieaanpgel(obj, index);
        setActieinh(obj, index);
        setActieverval(obj, index);
        setBijhgem(obj, index);
        setDataanvgel(obj, index);
        setDateindegel(obj, index);
        setDatinschringem(obj, index);
        setIndonverwdocaanw(obj, index);
        setPers(obj, index);
        setTsreg(obj, index);
        setTsverval(obj, index);
        return obj;
    }
    
    public void HisPersbijhgemDataOnDemand.setActieaanpgel(HisPersbijhgem obj, int index) {
        Actie actieaanpgel = actieDataOnDemand.getRandomActie();
        obj.setActieaanpgel(actieaanpgel);
    }
    
    public void HisPersbijhgemDataOnDemand.setActieinh(HisPersbijhgem obj, int index) {
        Actie actieinh = actieDataOnDemand.getRandomActie();
        obj.setActieinh(actieinh);
    }
    
    public void HisPersbijhgemDataOnDemand.setActieverval(HisPersbijhgem obj, int index) {
        Actie actieverval = actieDataOnDemand.getRandomActie();
        obj.setActieverval(actieverval);
    }
    
    public void HisPersbijhgemDataOnDemand.setBijhgem(HisPersbijhgem obj, int index) {
        Partij bijhgem = partijDataOnDemand.getRandomPartij();
        obj.setBijhgem(bijhgem);
    }
    
    public void HisPersbijhgemDataOnDemand.setDataanvgel(HisPersbijhgem obj, int index) {
        BigDecimal dataanvgel = BigDecimal.valueOf(index);
        obj.setDataanvgel(dataanvgel);
    }
    
    public void HisPersbijhgemDataOnDemand.setDateindegel(HisPersbijhgem obj, int index) {
        BigDecimal dateindegel = BigDecimal.valueOf(index);
        obj.setDateindegel(dateindegel);
    }
    
    public void HisPersbijhgemDataOnDemand.setDatinschringem(HisPersbijhgem obj, int index) {
        BigDecimal datinschringem = BigDecimal.valueOf(index);
        obj.setDatinschringem(datinschringem);
    }
    
    public void HisPersbijhgemDataOnDemand.setIndonverwdocaanw(HisPersbijhgem obj, int index) {
        Boolean indonverwdocaanw = true;
        obj.setIndonverwdocaanw(indonverwdocaanw);
    }
    
    public void HisPersbijhgemDataOnDemand.setPers(HisPersbijhgem obj, int index) {
        Pers pers = persDataOnDemand.getRandomPers();
        obj.setPers(pers);
    }
    
    public void HisPersbijhgemDataOnDemand.setTsreg(HisPersbijhgem obj, int index) {
        Date tsreg = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setTsreg(tsreg);
    }
    
    public void HisPersbijhgemDataOnDemand.setTsverval(HisPersbijhgem obj, int index) {
        Date tsverval = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setTsverval(tsverval);
    }
    
    public HisPersbijhgem HisPersbijhgemDataOnDemand.getSpecificHisPersbijhgem(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        HisPersbijhgem obj = data.get(index);
        Long id = obj.getId();
        return HisPersbijhgem.findHisPersbijhgem(id);
    }
    
    public HisPersbijhgem HisPersbijhgemDataOnDemand.getRandomHisPersbijhgem() {
        init();
        HisPersbijhgem obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return HisPersbijhgem.findHisPersbijhgem(id);
    }
    
    public boolean HisPersbijhgemDataOnDemand.modifyHisPersbijhgem(HisPersbijhgem obj) {
        return false;
    }
    
    public void HisPersbijhgemDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = HisPersbijhgem.findHisPersbijhgemEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'HisPersbijhgem' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<HisPersbijhgem>();
        for (int i = 0; i < 10; i++) {
            HisPersbijhgem obj = getNewTransientHisPersbijhgem(i);
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
