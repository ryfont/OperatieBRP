// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.lev;

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
import nl.bzk.brp.model.data.autaut.Authenticatiemiddel;
import nl.bzk.brp.model.data.autaut.AuthenticatiemiddelDataOnDemand;
import nl.bzk.brp.model.data.lev.Abonnement;
import nl.bzk.brp.model.data.lev.AbonnementDataOnDemand;
import nl.bzk.brp.model.data.lev.Lev;
import nl.bzk.brp.model.data.lev.LevDataOnDemand;
import nl.bzk.brp.model.data.lev.Srtlev;
import nl.bzk.brp.model.data.lev.SrtlevDataOnDemand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect LevDataOnDemand_Roo_DataOnDemand {
    
    declare @type: LevDataOnDemand: @Component;
    
    private Random LevDataOnDemand.rnd = new SecureRandom();
    
    private List<Lev> LevDataOnDemand.data;
    
    @Autowired
    private AbonnementDataOnDemand LevDataOnDemand.abonnementDataOnDemand;
    
    @Autowired
    private AuthenticatiemiddelDataOnDemand LevDataOnDemand.authenticatiemiddelDataOnDemand;
    
    @Autowired
    private SrtlevDataOnDemand LevDataOnDemand.srtlevDataOnDemand;
    
    public Lev LevDataOnDemand.getNewTransientLev(int index) {
        Lev obj = new Lev();
        setAbonnement(obj, index);
        setAuthenticatiemiddel(obj, index);
        setSrt(obj, index);
        setTsbesch(obj, index);
        setTsklaarzettenlev(obj, index);
        return obj;
    }
    
    public void LevDataOnDemand.setAbonnement(Lev obj, int index) {
        Abonnement abonnement = abonnementDataOnDemand.getRandomAbonnement();
        obj.setAbonnement(abonnement);
    }
    
    public void LevDataOnDemand.setAuthenticatiemiddel(Lev obj, int index) {
        Authenticatiemiddel authenticatiemiddel = authenticatiemiddelDataOnDemand.getRandomAuthenticatiemiddel();
        obj.setAuthenticatiemiddel(authenticatiemiddel);
    }
    
    public void LevDataOnDemand.setSrt(Lev obj, int index) {
        Srtlev srt = srtlevDataOnDemand.getRandomSrtlev();
        obj.setSrt(srt);
    }
    
    public void LevDataOnDemand.setTsbesch(Lev obj, int index) {
        Date tsbesch = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setTsbesch(tsbesch);
    }
    
    public void LevDataOnDemand.setTsklaarzettenlev(Lev obj, int index) {
        Date tsklaarzettenlev = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setTsklaarzettenlev(tsklaarzettenlev);
    }
    
    public Lev LevDataOnDemand.getSpecificLev(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Lev obj = data.get(index);
        Long id = obj.getId();
        return Lev.findLev(id);
    }
    
    public Lev LevDataOnDemand.getRandomLev() {
        init();
        Lev obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return Lev.findLev(id);
    }
    
    public boolean LevDataOnDemand.modifyLev(Lev obj) {
        return false;
    }
    
    public void LevDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = Lev.findLevEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Lev' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Lev>();
        for (int i = 0; i < 10; i++) {
            Lev obj = getNewTransientLev(i);
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
