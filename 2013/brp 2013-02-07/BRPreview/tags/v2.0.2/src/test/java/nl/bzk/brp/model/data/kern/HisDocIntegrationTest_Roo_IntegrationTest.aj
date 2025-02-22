// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import java.util.List;
import nl.bzk.brp.model.data.kern.HisDoc;
import nl.bzk.brp.model.data.kern.HisDocDataOnDemand;
import nl.bzk.brp.model.data.kern.HisDocIntegrationTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect HisDocIntegrationTest_Roo_IntegrationTest {
    
    declare @type: HisDocIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: HisDocIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: HisDocIntegrationTest: @Transactional;
    
    @Autowired
    private HisDocDataOnDemand HisDocIntegrationTest.dod;
    
    @Test
    public void HisDocIntegrationTest.testCountHisDocs() {
        Assert.assertNotNull("Data on demand for 'HisDoc' failed to initialize correctly", dod.getRandomHisDoc());
        long count = HisDoc.countHisDocs();
        Assert.assertTrue("Counter for 'HisDoc' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void HisDocIntegrationTest.testFindHisDoc() {
        HisDoc obj = dod.getRandomHisDoc();
        Assert.assertNotNull("Data on demand for 'HisDoc' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'HisDoc' failed to provide an identifier", id);
        obj = HisDoc.findHisDoc(id);
        Assert.assertNotNull("Find method for 'HisDoc' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'HisDoc' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void HisDocIntegrationTest.testFindAllHisDocs() {
        Assert.assertNotNull("Data on demand for 'HisDoc' failed to initialize correctly", dod.getRandomHisDoc());
        long count = HisDoc.countHisDocs();
        Assert.assertTrue("Too expensive to perform a find all test for 'HisDoc', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<HisDoc> result = HisDoc.findAllHisDocs();
        Assert.assertNotNull("Find all method for 'HisDoc' illegally returned null", result);
        Assert.assertTrue("Find all method for 'HisDoc' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void HisDocIntegrationTest.testFindHisDocEntries() {
        Assert.assertNotNull("Data on demand for 'HisDoc' failed to initialize correctly", dod.getRandomHisDoc());
        long count = HisDoc.countHisDocs();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<HisDoc> result = HisDoc.findHisDocEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'HisDoc' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'HisDoc' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void HisDocIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'HisDoc' failed to initialize correctly", dod.getRandomHisDoc());
        HisDoc obj = dod.getNewTransientHisDoc(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'HisDoc' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'HisDoc' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'HisDoc' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void HisDocIntegrationTest.testRemove() {
        HisDoc obj = dod.getRandomHisDoc();
        Assert.assertNotNull("Data on demand for 'HisDoc' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'HisDoc' failed to provide an identifier", id);
        obj = HisDoc.findHisDoc(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'HisDoc' with identifier '" + id + "'", HisDoc.findHisDoc(id));
    }
    
}
