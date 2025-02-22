/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.migratiebrp.tools.controle.waiter;

/**
 * Controle of de BEHEER is gestart.
 */
public final class BeheerInitializationWaiter extends AbstractInitializationWaiter {

    private BeheerInitializationWaiter() {
        super(new InitializationConfig("BEHEER").withSystemConfig());
    }

    /**
     * Run waiter.
     * @param args arguments
     */
    public static void main(final String[] args) {
        new BeheerInitializationWaiter().check();
    }

}
