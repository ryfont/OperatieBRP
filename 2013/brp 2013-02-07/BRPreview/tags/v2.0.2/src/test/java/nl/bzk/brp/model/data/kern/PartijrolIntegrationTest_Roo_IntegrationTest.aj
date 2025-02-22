// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import java.util.List;
import nl.bzk.brp.model.data.kern.Partijrol;
import nl.bzk.brp.model.data.kern.PartijrolDataOnDemand;
import nl.bzk.brp.model.data.kern.PartijrolIntegrationTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect PartijrolIntegrationTest_Roo_IntegrationTest {
    
    declare @type: PartijrolIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: PartijrolIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: PartijrolIntegrationTest: @Transactional;
    
    @Autowired
    private PartijrolDataOnDemand PartijrolIntegrationTest.dod;
    
    @Test
    public void PartijrolIntegrationTest.testCountPartijrols() {
        Assert.assertNotNull("Data on demand for 'Partijrol' failed to initialize correctly", dod.getRandomPartijrol());
        long count = Partijrol.countPartijrols();
        Assert.assertTrue("Counter for 'Partijrol' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void PartijrolIntegrationTest.testFindPartijrol() {
        Partijrol obj = dod.getRandomPartijrol();
        Assert.assertNotNull("Data on demand for 'Partijrol' failed to initialize correctly", obj);
        Integer id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Partijrol' failed to provide an identifier", id);
        obj = Partijrol.findPartijrol(id);
        Assert.assertNotNull("Find method for 'Partijrol' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Partijrol' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void PartijrolIntegrationTest.testFindAllPartijrols() {
        Assert.assertNotNull("Data on demand for 'Partijrol' failed to initialize correctly", dod.getRandomPartijrol());
        long count = Partijrol.countPartijrols();
        Assert.assertTrue("Too expensive to perform a find all test for 'Partijrol', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Partijrol> result = Partijrol.findAllPartijrols();
        Assert.assertNotNull("Find all method for 'Partijrol' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Partijrol' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void PartijrolIntegrationTest.testFindPartijrolEntries() {
        Assert.assertNotNull("Data on demand for 'Partijrol' failed to initialize correctly", dod.getRandomPartijrol());
        long count = Partijrol.countPartijrols();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Partijrol> result = Partijrol.findPartijrolEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Partijrol' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Partijrol' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void PartijrolIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'Partijrol' failed to initialize correctly", dod.getRandomPartijrol());
        Partijrol obj = dod.getNewTransientPartijrol(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Partijrol' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Partijrol' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'Partijrol' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void PartijrolIntegrationTest.testRemove() {
        Partijrol obj = dod.getRandomPartijrol();
        Assert.assertNotNull("Data on demand for 'Partijrol' failed to initialize correctly", obj);
        Integer id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Partijrol' failed to provide an identifier", id);
        obj = Partijrol.findPartijrol(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'Partijrol' with identifier '" + id + "'", Partijrol.findPartijrol(id));
    }
    
}
