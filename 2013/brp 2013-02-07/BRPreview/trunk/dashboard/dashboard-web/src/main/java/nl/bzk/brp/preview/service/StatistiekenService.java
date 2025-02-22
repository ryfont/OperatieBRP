/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.preview.service;

import java.util.Calendar;
import java.util.Map;

import nl.bzk.brp.preview.model.BerichtStatistiek;
import nl.bzk.brp.preview.model.Berichtsoort;


/**
 * De Interface StatistiekenService.
 */
public interface StatistiekenService {

    /**
     * Haalt een statistiek op vanaf een bepaald moment.
     *
     * @param vanaf de vanaf
     * @return statistiek
     */
    Map<Berichtsoort, BerichtStatistiek> getStatistiek(Calendar vanaf);

}
