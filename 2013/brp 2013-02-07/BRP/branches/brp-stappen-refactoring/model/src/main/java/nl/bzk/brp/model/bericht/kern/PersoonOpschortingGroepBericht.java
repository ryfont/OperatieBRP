/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.bericht.kern;

import nl.bzk.brp.model.bericht.kern.basis.AbstractPersoonOpschortingGroepBericht;
import nl.bzk.brp.model.logisch.kern.PersoonOpschortingGroep;


/**
 * 1. Vorm van historie: een reden opschorting wordt normaliter met terugwerkende kracht vastgelegd. Conform
 * bijhoudingsverantwoordelijkheid heeft de materi�le tijdslijn (dus) betekenis. In tegenstelling tot
 * bijhoudingsverantwoordelijkheid is de business case voor het expliciet vastleggen van de datum ingang van een reden
 * opschorting wat minder hard: wellicht zou de BRP ook toe kunnen met alleen de formele tijdslijn. Echter, er zijn
 * allerlei regels rondom datum ingang van opschorting, zoals rondom overlijden, �n dit gegeven wordt al van oudsher
 * vastgelegd in LO 3.x. Om die reden is het gegeven gehandhaaft.
 *
 *
 *
 * Generator: nl.bzk.brp.generatoren.java.BerichtModelGenerator.
 * Metaregister versie: 1.1.8.
 * Generator versie: 1.0-SNAPSHOT.
 * Generator gebouwd op: 2012-11-27 12:02:51.
 * Gegenereerd op: Tue Nov 27 13:50:44 CET 2012.
 */
public class PersoonOpschortingGroepBericht extends AbstractPersoonOpschortingGroepBericht implements
        PersoonOpschortingGroep
{

}
