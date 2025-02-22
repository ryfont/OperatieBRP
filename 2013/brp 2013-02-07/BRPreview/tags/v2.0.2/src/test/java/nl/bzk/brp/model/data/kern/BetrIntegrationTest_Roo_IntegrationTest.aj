// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import java.util.List;
import nl.bzk.brp.model.data.kern.Betr;
import nl.bzk.brp.model.data.kern.BetrDataOnDemand;
import nl.bzk.brp.model.data.kern.BetrIntegrationTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect BetrIntegrationTest_Roo_IntegrationTest {
    
    declare @type: BetrIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: BetrIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: BetrIntegrationTest: @Transactional;
    
    @Autowired
    private BetrDataOnDemand BetrIntegrationTest.dod;
    
    @Test
    public void BetrIntegrationTest.testCountBetrs() {
        Assert.assertNotNull("Data on demand for 'Betr' failed to initialize correctly", dod.getRandomBetr());
        long count = Betr.countBetrs();
        Assert.assertTrue("Counter for 'Betr' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void BetrIntegrationTest.testFindBetr() {
        Betr obj = dod.getRandomBetr();
        Assert.assertNotNull("Data on demand for 'Betr' failed to initialize correctly", obj);
        Integer id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Betr' failed to provide an identifier", id);
        obj = Betr.findBetr(id);
        Assert.assertNotNull("Find method for 'Betr' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Betr' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void BetrIntegrationTest.testFindAllBetrs() {
        Assert.assertNotNull("Data on demand for 'Betr' failed to initialize correctly", dod.getRandomBetr());
        long count = Betr.countBetrs();
        Assert.assertTrue("Too expensive to perform a find all test for 'Betr', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Betr> result = Betr.findAllBetrs();
        Assert.assertNotNull("Find all method for 'Betr' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Betr' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void BetrIntegrationTest.testFindBetrEntries() {
        Assert.assertNotNull("Data on demand for 'Betr' failed to initialize correctly", dod.getRandomBetr());
        long count = Betr.countBetrs();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Betr> result = Betr.findBetrEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Betr' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Betr' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void BetrIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'Betr' failed to initialize correctly", dod.getRandomBetr());
        Betr obj = dod.getNewTransientBetr(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Betr' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Betr' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'Betr' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void BetrIntegrationTest.testRemove() {
        Betr obj = dod.getRandomBetr();
        Assert.assertNotNull("Data on demand for 'Betr' failed to initialize correctly", obj);
        Integer id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Betr' failed to provide an identifier", id);
        obj = Betr.findBetr(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'Betr' with identifier '" + id + "'", Betr.findBetr(id));
    }
    
}
