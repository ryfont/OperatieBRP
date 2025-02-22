/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.bmr.metamodel;

/**
 * Een indicatie of een modelelement behoort tot het (logisch) gegevensmodel (M), de gegevensset(S), of beide(B).
 */
public enum InSetOfModel {
    /**
     * (Logisch) model.
     */
    S,
    /**
     * Gegevensset.
     */
    M,
    /**
     * Beide.
     */
    B;

}
