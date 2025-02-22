/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.moderniseringgba.isc.esb.message.sync;

import nl.moderniseringgba.isc.esb.message.Bericht;
import nl.moderniseringgba.isc.esb.message.BerichtInhoudException;

import org.w3c.dom.Document;

/**
 * Sync Bericht.
 */
public interface SyncBericht extends Bericht {

    /**
     * Parse van een sync bericht.
     * 
     * @param document
     *            Sync bericht
     * 
     * @throws BerichtInhoudException
     *             bericht inhoud fout
     */
    void parse(Document document) throws BerichtInhoudException;

}
