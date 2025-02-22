// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import java.util.List;
import nl.bzk.brp.model.data.kern.HisPersgeboorte;
import nl.bzk.brp.model.data.kern.HisPersgeboorteDataOnDemand;
import nl.bzk.brp.model.data.kern.HisPersgeboorteIntegrationTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect HisPersgeboorteIntegrationTest_Roo_IntegrationTest {
    
    declare @type: HisPersgeboorteIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: HisPersgeboorteIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: HisPersgeboorteIntegrationTest: @Transactional;
    
    @Autowired
    private HisPersgeboorteDataOnDemand HisPersgeboorteIntegrationTest.dod;
    
    @Test
    public void HisPersgeboorteIntegrationTest.testCountHisPersgeboortes() {
        Assert.assertNotNull("Data on demand for 'HisPersgeboorte' failed to initialize correctly", dod.getRandomHisPersgeboorte());
        long count = HisPersgeboorte.countHisPersgeboortes();
        Assert.assertTrue("Counter for 'HisPersgeboorte' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void HisPersgeboorteIntegrationTest.testFindHisPersgeboorte() {
        HisPersgeboorte obj = dod.getRandomHisPersgeboorte();
        Assert.assertNotNull("Data on demand for 'HisPersgeboorte' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'HisPersgeboorte' failed to provide an identifier", id);
        obj = HisPersgeboorte.findHisPersgeboorte(id);
        Assert.assertNotNull("Find method for 'HisPersgeboorte' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'HisPersgeboorte' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void HisPersgeboorteIntegrationTest.testFindAllHisPersgeboortes() {
        Assert.assertNotNull("Data on demand for 'HisPersgeboorte' failed to initialize correctly", dod.getRandomHisPersgeboorte());
        long count = HisPersgeboorte.countHisPersgeboortes();
        Assert.assertTrue("Too expensive to perform a find all test for 'HisPersgeboorte', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<HisPersgeboorte> result = HisPersgeboorte.findAllHisPersgeboortes();
        Assert.assertNotNull("Find all method for 'HisPersgeboorte' illegally returned null", result);
        Assert.assertTrue("Find all method for 'HisPersgeboorte' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void HisPersgeboorteIntegrationTest.testFindHisPersgeboorteEntries() {
        Assert.assertNotNull("Data on demand for 'HisPersgeboorte' failed to initialize correctly", dod.getRandomHisPersgeboorte());
        long count = HisPersgeboorte.countHisPersgeboortes();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<HisPersgeboorte> result = HisPersgeboorte.findHisPersgeboorteEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'HisPersgeboorte' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'HisPersgeboorte' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void HisPersgeboorteIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'HisPersgeboorte' failed to initialize correctly", dod.getRandomHisPersgeboorte());
        HisPersgeboorte obj = dod.getNewTransientHisPersgeboorte(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'HisPersgeboorte' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'HisPersgeboorte' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'HisPersgeboorte' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void HisPersgeboorteIntegrationTest.testRemove() {
        HisPersgeboorte obj = dod.getRandomHisPersgeboorte();
        Assert.assertNotNull("Data on demand for 'HisPersgeboorte' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'HisPersgeboorte' failed to provide an identifier", id);
        obj = HisPersgeboorte.findHisPersgeboorte(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'HisPersgeboorte' with identifier '" + id + "'", HisPersgeboorte.findHisPersgeboorte(id));
    }
    
}
