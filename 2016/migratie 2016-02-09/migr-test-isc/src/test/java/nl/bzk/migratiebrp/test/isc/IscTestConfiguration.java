/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.migratiebrp.test.isc;

import nl.bzk.migratiebrp.test.dal.TestCasusFactory;
import nl.bzk.migratiebrp.test.dal.runner.TestConfiguratie;
import nl.bzk.migratiebrp.test.dal.runner.TestRunner;
import nl.bzk.migratiebrp.util.common.logging.Logger;
import nl.bzk.migratiebrp.util.common.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ISC Configuratie.
 */
@RunWith(TestRunner.class)
public abstract class IscTestConfiguration extends TestConfiguratie {

    private static final Logger LOG = LoggerFactory.getLogger();

    /*
     * (non-Javadoc)
     * 
     * @see nl.bzk.migratiebrp.test.dal.runner.TestConfiguratie#getCasusFactory()
     */
    @Override
    public TestCasusFactory getCasusFactory() {
        LOG.info("Starting JBoss waiter");
        final ConfigurableApplicationContext jbossWaiter = new ClassPathXmlApplicationContext("classpath:jboss-waiter.xml");
        jbossWaiter.close();

        LOG.info("Starting application context");
        final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("classpath:test-beans.xml");

        context.registerShutdownHook();
        LOG.info("Returning new test casus factory...");
        return new ProcessenTestCasusFactory(context.getBean(EnvironmentImpl.class));

    }
}
