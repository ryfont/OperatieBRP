// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import java.util.List;
import nl.bzk.brp.model.data.kern.Srtpartij;
import nl.bzk.brp.model.data.kern.SrtpartijDataOnDemand;
import nl.bzk.brp.model.data.kern.SrtpartijIntegrationTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect SrtpartijIntegrationTest_Roo_IntegrationTest {
    
    declare @type: SrtpartijIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: SrtpartijIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: SrtpartijIntegrationTest: @Transactional;
    
    @Autowired
    private SrtpartijDataOnDemand SrtpartijIntegrationTest.dod;
    
    @Test
    public void SrtpartijIntegrationTest.testCountSrtpartijs() {
        Assert.assertNotNull("Data on demand for 'Srtpartij' failed to initialize correctly", dod.getRandomSrtpartij());
        long count = Srtpartij.countSrtpartijs();
        Assert.assertTrue("Counter for 'Srtpartij' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void SrtpartijIntegrationTest.testFindSrtpartij() {
        Srtpartij obj = dod.getRandomSrtpartij();
        Assert.assertNotNull("Data on demand for 'Srtpartij' failed to initialize correctly", obj);
        Integer id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Srtpartij' failed to provide an identifier", id);
        obj = Srtpartij.findSrtpartij(id);
        Assert.assertNotNull("Find method for 'Srtpartij' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Srtpartij' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void SrtpartijIntegrationTest.testFindAllSrtpartijs() {
        Assert.assertNotNull("Data on demand for 'Srtpartij' failed to initialize correctly", dod.getRandomSrtpartij());
        long count = Srtpartij.countSrtpartijs();
        Assert.assertTrue("Too expensive to perform a find all test for 'Srtpartij', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Srtpartij> result = Srtpartij.findAllSrtpartijs();
        Assert.assertNotNull("Find all method for 'Srtpartij' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Srtpartij' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void SrtpartijIntegrationTest.testFindSrtpartijEntries() {
        Assert.assertNotNull("Data on demand for 'Srtpartij' failed to initialize correctly", dod.getRandomSrtpartij());
        long count = Srtpartij.countSrtpartijs();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Srtpartij> result = Srtpartij.findSrtpartijEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Srtpartij' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Srtpartij' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void SrtpartijIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'Srtpartij' failed to initialize correctly", dod.getRandomSrtpartij());
        Srtpartij obj = dod.getNewTransientSrtpartij(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Srtpartij' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Srtpartij' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'Srtpartij' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void SrtpartijIntegrationTest.testRemove() {
        Srtpartij obj = dod.getRandomSrtpartij();
        Assert.assertNotNull("Data on demand for 'Srtpartij' failed to initialize correctly", obj);
        Integer id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Srtpartij' failed to provide an identifier", id);
        obj = Srtpartij.findSrtpartij(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'Srtpartij' with identifier '" + id + "'", Srtpartij.findSrtpartij(id));
    }
    
}
