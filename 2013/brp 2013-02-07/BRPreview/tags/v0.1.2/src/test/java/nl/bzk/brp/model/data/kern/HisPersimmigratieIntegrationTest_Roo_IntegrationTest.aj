// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import java.util.List;
import nl.bzk.brp.model.data.kern.HisPersimmigratie;
import nl.bzk.brp.model.data.kern.HisPersimmigratieDataOnDemand;
import nl.bzk.brp.model.data.kern.HisPersimmigratieIntegrationTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect HisPersimmigratieIntegrationTest_Roo_IntegrationTest {
    
    declare @type: HisPersimmigratieIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: HisPersimmigratieIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: HisPersimmigratieIntegrationTest: @Transactional;
    
    @Autowired
    private HisPersimmigratieDataOnDemand HisPersimmigratieIntegrationTest.dod;
    
    @Test
    public void HisPersimmigratieIntegrationTest.testCountHisPersimmigraties() {
        Assert.assertNotNull("Data on demand for 'HisPersimmigratie' failed to initialize correctly", dod.getRandomHisPersimmigratie());
        long count = HisPersimmigratie.countHisPersimmigraties();
        Assert.assertTrue("Counter for 'HisPersimmigratie' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void HisPersimmigratieIntegrationTest.testFindHisPersimmigratie() {
        HisPersimmigratie obj = dod.getRandomHisPersimmigratie();
        Assert.assertNotNull("Data on demand for 'HisPersimmigratie' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'HisPersimmigratie' failed to provide an identifier", id);
        obj = HisPersimmigratie.findHisPersimmigratie(id);
        Assert.assertNotNull("Find method for 'HisPersimmigratie' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'HisPersimmigratie' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void HisPersimmigratieIntegrationTest.testFindAllHisPersimmigraties() {
        Assert.assertNotNull("Data on demand for 'HisPersimmigratie' failed to initialize correctly", dod.getRandomHisPersimmigratie());
        long count = HisPersimmigratie.countHisPersimmigraties();
        Assert.assertTrue("Too expensive to perform a find all test for 'HisPersimmigratie', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<HisPersimmigratie> result = HisPersimmigratie.findAllHisPersimmigraties();
        Assert.assertNotNull("Find all method for 'HisPersimmigratie' illegally returned null", result);
        Assert.assertTrue("Find all method for 'HisPersimmigratie' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void HisPersimmigratieIntegrationTest.testFindHisPersimmigratieEntries() {
        Assert.assertNotNull("Data on demand for 'HisPersimmigratie' failed to initialize correctly", dod.getRandomHisPersimmigratie());
        long count = HisPersimmigratie.countHisPersimmigraties();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<HisPersimmigratie> result = HisPersimmigratie.findHisPersimmigratieEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'HisPersimmigratie' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'HisPersimmigratie' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void HisPersimmigratieIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'HisPersimmigratie' failed to initialize correctly", dod.getRandomHisPersimmigratie());
        HisPersimmigratie obj = dod.getNewTransientHisPersimmigratie(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'HisPersimmigratie' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'HisPersimmigratie' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'HisPersimmigratie' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void HisPersimmigratieIntegrationTest.testRemove() {
        HisPersimmigratie obj = dod.getRandomHisPersimmigratie();
        Assert.assertNotNull("Data on demand for 'HisPersimmigratie' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'HisPersimmigratie' failed to provide an identifier", id);
        obj = HisPersimmigratie.findHisPersimmigratie(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'HisPersimmigratie' with identifier '" + id + "'", HisPersimmigratie.findHisPersimmigratie(id));
    }
    
}
