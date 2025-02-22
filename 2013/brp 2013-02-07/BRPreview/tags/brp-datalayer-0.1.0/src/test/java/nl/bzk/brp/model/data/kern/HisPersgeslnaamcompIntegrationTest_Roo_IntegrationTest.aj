// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import java.util.List;
import nl.bzk.brp.model.data.kern.HisPersgeslnaamcomp;
import nl.bzk.brp.model.data.kern.HisPersgeslnaamcompDataOnDemand;
import nl.bzk.brp.model.data.kern.HisPersgeslnaamcompIntegrationTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect HisPersgeslnaamcompIntegrationTest_Roo_IntegrationTest {
    
    declare @type: HisPersgeslnaamcompIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: HisPersgeslnaamcompIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: HisPersgeslnaamcompIntegrationTest: @Transactional;
    
    @Autowired
    private HisPersgeslnaamcompDataOnDemand HisPersgeslnaamcompIntegrationTest.dod;
    
    @Test
    public void HisPersgeslnaamcompIntegrationTest.testCountHisPersgeslnaamcomps() {
        Assert.assertNotNull("Data on demand for 'HisPersgeslnaamcomp' failed to initialize correctly", dod.getRandomHisPersgeslnaamcomp());
        long count = HisPersgeslnaamcomp.countHisPersgeslnaamcomps();
        Assert.assertTrue("Counter for 'HisPersgeslnaamcomp' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void HisPersgeslnaamcompIntegrationTest.testFindHisPersgeslnaamcomp() {
        HisPersgeslnaamcomp obj = dod.getRandomHisPersgeslnaamcomp();
        Assert.assertNotNull("Data on demand for 'HisPersgeslnaamcomp' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'HisPersgeslnaamcomp' failed to provide an identifier", id);
        obj = HisPersgeslnaamcomp.findHisPersgeslnaamcomp(id);
        Assert.assertNotNull("Find method for 'HisPersgeslnaamcomp' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'HisPersgeslnaamcomp' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void HisPersgeslnaamcompIntegrationTest.testFindAllHisPersgeslnaamcomps() {
        Assert.assertNotNull("Data on demand for 'HisPersgeslnaamcomp' failed to initialize correctly", dod.getRandomHisPersgeslnaamcomp());
        long count = HisPersgeslnaamcomp.countHisPersgeslnaamcomps();
        Assert.assertTrue("Too expensive to perform a find all test for 'HisPersgeslnaamcomp', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<HisPersgeslnaamcomp> result = HisPersgeslnaamcomp.findAllHisPersgeslnaamcomps();
        Assert.assertNotNull("Find all method for 'HisPersgeslnaamcomp' illegally returned null", result);
        Assert.assertTrue("Find all method for 'HisPersgeslnaamcomp' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void HisPersgeslnaamcompIntegrationTest.testFindHisPersgeslnaamcompEntries() {
        Assert.assertNotNull("Data on demand for 'HisPersgeslnaamcomp' failed to initialize correctly", dod.getRandomHisPersgeslnaamcomp());
        long count = HisPersgeslnaamcomp.countHisPersgeslnaamcomps();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<HisPersgeslnaamcomp> result = HisPersgeslnaamcomp.findHisPersgeslnaamcompEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'HisPersgeslnaamcomp' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'HisPersgeslnaamcomp' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void HisPersgeslnaamcompIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'HisPersgeslnaamcomp' failed to initialize correctly", dod.getRandomHisPersgeslnaamcomp());
        HisPersgeslnaamcomp obj = dod.getNewTransientHisPersgeslnaamcomp(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'HisPersgeslnaamcomp' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'HisPersgeslnaamcomp' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'HisPersgeslnaamcomp' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void HisPersgeslnaamcompIntegrationTest.testRemove() {
        HisPersgeslnaamcomp obj = dod.getRandomHisPersgeslnaamcomp();
        Assert.assertNotNull("Data on demand for 'HisPersgeslnaamcomp' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'HisPersgeslnaamcomp' failed to provide an identifier", id);
        obj = HisPersgeslnaamcomp.findHisPersgeslnaamcomp(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'HisPersgeslnaamcomp' with identifier '" + id + "'", HisPersgeslnaamcomp.findHisPersgeslnaamcomp(id));
    }
    
}
