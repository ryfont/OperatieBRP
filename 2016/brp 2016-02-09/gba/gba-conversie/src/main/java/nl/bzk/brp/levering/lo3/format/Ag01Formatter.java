/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.levering.lo3.format;

import org.springframework.stereotype.Component;

/**
 * Uitgaand Ag01 bericht: vul bericht na plaatsen afnemersindicatie.
 */
@Component
public final class Ag01Formatter extends AbstractAgFormatter {

    @Override
    protected String getBerichtType() {
        return "Ag01";
    }
}
