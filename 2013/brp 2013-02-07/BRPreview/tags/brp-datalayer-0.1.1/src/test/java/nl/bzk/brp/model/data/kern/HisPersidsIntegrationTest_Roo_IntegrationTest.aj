// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import java.util.List;
import nl.bzk.brp.model.data.kern.HisPersids;
import nl.bzk.brp.model.data.kern.HisPersidsDataOnDemand;
import nl.bzk.brp.model.data.kern.HisPersidsIntegrationTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect HisPersidsIntegrationTest_Roo_IntegrationTest {
    
    declare @type: HisPersidsIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: HisPersidsIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: HisPersidsIntegrationTest: @Transactional;
    
    @Autowired
    private HisPersidsDataOnDemand HisPersidsIntegrationTest.dod;
    
    @Test
    public void HisPersidsIntegrationTest.testCountHisPersidses() {
        Assert.assertNotNull("Data on demand for 'HisPersids' failed to initialize correctly", dod.getRandomHisPersids());
        long count = HisPersids.countHisPersidses();
        Assert.assertTrue("Counter for 'HisPersids' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void HisPersidsIntegrationTest.testFindHisPersids() {
        HisPersids obj = dod.getRandomHisPersids();
        Assert.assertNotNull("Data on demand for 'HisPersids' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'HisPersids' failed to provide an identifier", id);
        obj = HisPersids.findHisPersids(id);
        Assert.assertNotNull("Find method for 'HisPersids' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'HisPersids' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void HisPersidsIntegrationTest.testFindAllHisPersidses() {
        Assert.assertNotNull("Data on demand for 'HisPersids' failed to initialize correctly", dod.getRandomHisPersids());
        long count = HisPersids.countHisPersidses();
        Assert.assertTrue("Too expensive to perform a find all test for 'HisPersids', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<HisPersids> result = HisPersids.findAllHisPersidses();
        Assert.assertNotNull("Find all method for 'HisPersids' illegally returned null", result);
        Assert.assertTrue("Find all method for 'HisPersids' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void HisPersidsIntegrationTest.testFindHisPersidsEntries() {
        Assert.assertNotNull("Data on demand for 'HisPersids' failed to initialize correctly", dod.getRandomHisPersids());
        long count = HisPersids.countHisPersidses();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<HisPersids> result = HisPersids.findHisPersidsEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'HisPersids' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'HisPersids' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void HisPersidsIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'HisPersids' failed to initialize correctly", dod.getRandomHisPersids());
        HisPersids obj = dod.getNewTransientHisPersids(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'HisPersids' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'HisPersids' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'HisPersids' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void HisPersidsIntegrationTest.testRemove() {
        HisPersids obj = dod.getRandomHisPersids();
        Assert.assertNotNull("Data on demand for 'HisPersids' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'HisPersids' failed to provide an identifier", id);
        obj = HisPersids.findHisPersids(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'HisPersids' with identifier '" + id + "'", HisPersids.findHisPersids(id));
    }
    
}
