// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package nl.bzk.brp.model.data.kern;

import java.util.List;
import nl.bzk.brp.model.data.kern.Multirealiteitregel;
import nl.bzk.brp.model.data.kern.MultirealiteitregelDataOnDemand;
import nl.bzk.brp.model.data.kern.MultirealiteitregelIntegrationTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect MultirealiteitregelIntegrationTest_Roo_IntegrationTest {
    
    declare @type: MultirealiteitregelIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: MultirealiteitregelIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: MultirealiteitregelIntegrationTest: @Transactional;
    
    @Autowired
    private MultirealiteitregelDataOnDemand MultirealiteitregelIntegrationTest.dod;
    
    @Test
    public void MultirealiteitregelIntegrationTest.testCountMultirealiteitregels() {
        Assert.assertNotNull("Data on demand for 'Multirealiteitregel' failed to initialize correctly", dod.getRandomMultirealiteitregel());
        long count = Multirealiteitregel.countMultirealiteitregels();
        Assert.assertTrue("Counter for 'Multirealiteitregel' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void MultirealiteitregelIntegrationTest.testFindMultirealiteitregel() {
        Multirealiteitregel obj = dod.getRandomMultirealiteitregel();
        Assert.assertNotNull("Data on demand for 'Multirealiteitregel' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Multirealiteitregel' failed to provide an identifier", id);
        obj = Multirealiteitregel.findMultirealiteitregel(id);
        Assert.assertNotNull("Find method for 'Multirealiteitregel' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Multirealiteitregel' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void MultirealiteitregelIntegrationTest.testFindAllMultirealiteitregels() {
        Assert.assertNotNull("Data on demand for 'Multirealiteitregel' failed to initialize correctly", dod.getRandomMultirealiteitregel());
        long count = Multirealiteitregel.countMultirealiteitregels();
        Assert.assertTrue("Too expensive to perform a find all test for 'Multirealiteitregel', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Multirealiteitregel> result = Multirealiteitregel.findAllMultirealiteitregels();
        Assert.assertNotNull("Find all method for 'Multirealiteitregel' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Multirealiteitregel' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void MultirealiteitregelIntegrationTest.testFindMultirealiteitregelEntries() {
        Assert.assertNotNull("Data on demand for 'Multirealiteitregel' failed to initialize correctly", dod.getRandomMultirealiteitregel());
        long count = Multirealiteitregel.countMultirealiteitregels();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Multirealiteitregel> result = Multirealiteitregel.findMultirealiteitregelEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Multirealiteitregel' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Multirealiteitregel' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void MultirealiteitregelIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'Multirealiteitregel' failed to initialize correctly", dod.getRandomMultirealiteitregel());
        Multirealiteitregel obj = dod.getNewTransientMultirealiteitregel(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Multirealiteitregel' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Multirealiteitregel' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'Multirealiteitregel' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void MultirealiteitregelIntegrationTest.testRemove() {
        Multirealiteitregel obj = dod.getRandomMultirealiteitregel();
        Assert.assertNotNull("Data on demand for 'Multirealiteitregel' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Multirealiteitregel' failed to provide an identifier", id);
        obj = Multirealiteitregel.findMultirealiteitregel(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'Multirealiteitregel' with identifier '" + id + "'", Multirealiteitregel.findMultirealiteitregel(id));
    }
    
}
