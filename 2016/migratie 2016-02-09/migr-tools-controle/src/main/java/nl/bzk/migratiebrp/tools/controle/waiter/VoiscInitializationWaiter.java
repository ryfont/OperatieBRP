/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.migratiebrp.tools.controle.waiter;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import nl.bzk.migratiebrp.util.common.logging.Logger;
import nl.bzk.migratiebrp.util.common.logging.LoggerFactory;
import nl.bzk.migratiebrp.util.common.operatie.Herhaal;
import nl.bzk.migratiebrp.util.common.operatie.HerhaalException;

/**
 * Bean om te kunnen wachten totdat de VOISC installatie is geinitialiseerd.
 *
 */
public final class VoiscInitializationWaiter {

    private static final Logger LOG = LoggerFactory.getLogger();

    private VoiscInitializationWaiter() {
        // Niet instantieerbaar
    }

    /**
     * Run waiter.
     *
     * @param args
     *            arguments
     */
    public static void main(final String[] args) {

        // Controleer Voisc gestart
        try {
            final String server = PropertyUtil.getProperty("voisc.server");
            VoiscInitializationWaiter.controleerVoiscGestart(server);
        } catch (final HerhaalException e) {
            throw new RuntimeException(e);
        }
    }

    private static void controleerVoiscGestart(final String server) throws HerhaalException {

        LOG.info("Controle op initialisatie Voisc gestart: " + server);

        final Herhaal herhaling = new Herhaal(10000, 30, Herhaal.Strategie.REGELMATIG);
        herhaling.herhaal(new Runnable() {
            @Override
            public void run() {
                try {
                    final JMXConnector connector = JMXConnectorFactory.connect(new JMXServiceURL(server));
                    final MBeanServerConnection connection = connector.getMBeanServerConnection();

                    connection.getMBeanInfo(new ObjectName("nl.bzk.migratiebrp.voisc:name=VOISC"));
                    connection.getMBeanInfo(new ObjectName("net.sf.ehcache:type=Cache,CacheManager=VoiscCacheManager,name=mailboxenOpInstantiecode"));
                } catch (final Exception e) {
                    LOG.info("Voisc niet gestart: " + e);
                    throw new RuntimeException("Voisc niet gestart.");
                }
            }
        });
        LOG.info("Voisc gestart");
    }
}
