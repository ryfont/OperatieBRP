/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.bevraging.ws.service.interceptor.helper;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.Level;

import javax.inject.Inject;

import nl.bzk.brp.bevraging.business.service.ArchiveringService;
import nl.bzk.brp.bevraging.domein.ber.Richting;


/**
 * Specifieke logger ten behoeve van het archiveren/loggen van berichten. Deze logger schrijft de te loggen berichten
 * weg via de archiveringsservice (zie {@link ArchiveringService}.
 */
public class ArchiveringServiceLogger extends Logger {

    @Inject
    private ArchiveringService archiveringService;

    /**
     * Standaard constructor die de logger initialiseert en een lokale handler zet die naar de archivering service
     * logt.
     * @param richting De richting van de berichten die deze logger logt.
     */
    public ArchiveringServiceLogger(final Richting richting) {
        super("uitgaandeArchiveringServiceLogger", null);

        setUseParentHandlers(false);
        //De standaard log level voor een handler is Level.ALL, dus moet de logger zelf ook op deze level worden geinitialiseerd.
        setLevel(Level.ALL);
        addHandler(new Handler() {

            @Override
            public void publish(final LogRecord record) {
                archiveringService.archiveer(record.getMessage(), richting);
            }

            @Override
            public void flush() {
                // Do Nothing
            }

            @Override
            public void close() {
                // Do Nothing
            }

        });
    }
}
