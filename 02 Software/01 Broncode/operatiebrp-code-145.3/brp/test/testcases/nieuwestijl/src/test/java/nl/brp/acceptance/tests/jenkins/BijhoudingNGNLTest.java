/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.brp.acceptance.tests.jenkins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import nl.bzk.brp.funqmachine.AcceptanceTest;

/**
 * Regressie tests voor GBA Nietigverklaring Huwelijk NL.
 */
@AcceptanceTest
public class BijhoudingNGNLTest extends AbstractVoerKlaarStoriesUit {
    @Override
    public List<String> includeFilter() {
        return new ArrayList<String>(Arrays.asList("**/testcases/bijhouding/NGNL/**/*.story"));
    }

}
