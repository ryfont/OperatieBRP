/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.basis;

/**
 * Interface voor historie entiteiten die een materiele historie patroon volgen.
 */
public interface MaterieleHistorieEntiteit {

    /**
     * Retourneert een wrapper met alle materiele historie velden.
     * @return Materiele historie wrapper.
     */
    MaterieleHistorie getMaterieleHistorie();

    /**
     * Kopieer de materiele historie entiteit.
     *
     * @return de kopie
     */
    MaterieleHistorieEntiteit kopieer();
}
