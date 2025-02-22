/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.tooling.apitest.service.beheer;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;

/**
 * Spring configuratie voor de beheer applicatie.
 */
@ComponentScan({
        "nl.bzk.brp.beheer.service",
        "nl.bzk.brp.tooling.apitest.service.beheer"
})
@Lazy
public class BeheerConfiguratie {


}
