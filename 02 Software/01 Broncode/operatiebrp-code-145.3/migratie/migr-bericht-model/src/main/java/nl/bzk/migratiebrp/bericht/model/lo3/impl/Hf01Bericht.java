/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.migratiebrp.bericht.model.lo3.impl;

import java.io.Serializable;
import nl.bzk.migratiebrp.bericht.model.lo3.AbstractCategorieGebaseerdParsedLo3Bericht;
import nl.bzk.migratiebrp.bericht.model.lo3.Lo3Bericht;
import nl.bzk.migratiebrp.bericht.model.lo3.Lo3EindBericht;
import nl.bzk.migratiebrp.bericht.model.lo3.Lo3Header;
import nl.bzk.migratiebrp.bericht.model.lo3.Lo3HeaderVeld;
import nl.bzk.migratiebrp.bericht.model.lo3.syntax.Lo3SyntaxControle;

/**
 * Hf01: Fout: ad hoc vraag niet te beantwoorden.
 */
public final class Hf01Bericht extends AbstractCategorieGebaseerdParsedLo3Bericht implements Lo3Bericht, Lo3EindBericht, Serializable {
    private static final long serialVersionUID = 1L;

    private static final Lo3Header HEADER = new Lo3Header(Lo3HeaderVeld.RANDOM_KEY, Lo3HeaderVeld.BERICHTNUMMER, Lo3HeaderVeld.FOUTREDEN,
            Lo3HeaderVeld.GEMEENTE, Lo3HeaderVeld.A_NUMMER, Lo3HeaderVeld.AANTAL, Lo3HeaderVeld.GEVRAAGDE_RUBRIEKEN);

    /**
     * Constructor.
     */
    public Hf01Bericht() {
        super(HEADER, Lo3SyntaxControle.STANDAARD, "Hf01", null);
    }

}
