// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import java.util.List;
import nl.bzk.brp.model.data.kern.Actie;
import nl.bzk.brp.model.data.kern.ActieDataOnDemand;
import nl.bzk.brp.model.data.kern.ActieIntegrationTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect ActieIntegrationTest_Roo_IntegrationTest {
    
    declare @type: ActieIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: ActieIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: ActieIntegrationTest: @Transactional;
    
    @Autowired
    private ActieDataOnDemand ActieIntegrationTest.dod;
    
    @Test
    public void ActieIntegrationTest.testCountActies() {
        Assert.assertNotNull("Data on demand for 'Actie' failed to initialize correctly", dod.getRandomActie());
        long count = Actie.countActies();
        Assert.assertTrue("Counter for 'Actie' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void ActieIntegrationTest.testFindActie() {
        Actie obj = dod.getRandomActie();
        Assert.assertNotNull("Data on demand for 'Actie' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Actie' failed to provide an identifier", id);
        obj = Actie.findActie(id);
        Assert.assertNotNull("Find method for 'Actie' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Actie' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void ActieIntegrationTest.testFindAllActies() {
        Assert.assertNotNull("Data on demand for 'Actie' failed to initialize correctly", dod.getRandomActie());
        long count = Actie.countActies();
        Assert.assertTrue("Too expensive to perform a find all test for 'Actie', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Actie> result = Actie.findAllActies();
        Assert.assertNotNull("Find all method for 'Actie' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Actie' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void ActieIntegrationTest.testFindActieEntries() {
        Assert.assertNotNull("Data on demand for 'Actie' failed to initialize correctly", dod.getRandomActie());
        long count = Actie.countActies();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Actie> result = Actie.findActieEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Actie' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Actie' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void ActieIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'Actie' failed to initialize correctly", dod.getRandomActie());
        Actie obj = dod.getNewTransientActie(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Actie' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Actie' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'Actie' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void ActieIntegrationTest.testRemove() {
        Actie obj = dod.getRandomActie();
        Assert.assertNotNull("Data on demand for 'Actie' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Actie' failed to provide an identifier", id);
        obj = Actie.findActie(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'Actie' with identifier '" + id + "'", Actie.findActie(id));
    }
    
}
