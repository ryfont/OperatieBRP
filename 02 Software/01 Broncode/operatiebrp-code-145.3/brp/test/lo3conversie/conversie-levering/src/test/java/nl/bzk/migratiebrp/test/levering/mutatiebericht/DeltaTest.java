/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.migratiebrp.test.levering.mutatiebericht;

import java.io.File;
import java.io.FilenameFilter;
import nl.bzk.migratiebrp.test.common.util.Filters.DirectoryFilters;
import nl.bzk.migratiebrp.test.dal.TestSkipper;

public class DeltaTest extends LeveringMutatieberichtTestConfiguratie {

    @Override
    public boolean useMemoryDS() {
        return true;
    }

    @Override
    public File getInputFolder() {
        return new File("./delta/");
    }

    @Override
    public FilenameFilter getThemaFilter() {
        return DirectoryFilters.notEndsWith("NO TEST");
    }

    @Override
    public FilenameFilter getCasusFilter() {
        return DirectoryFilters.notEndsWith("NO TEST");
    }

    @Override
    public TestSkipper getTestSkipper() {
        return TestSkipper.regressie();
    }
}
