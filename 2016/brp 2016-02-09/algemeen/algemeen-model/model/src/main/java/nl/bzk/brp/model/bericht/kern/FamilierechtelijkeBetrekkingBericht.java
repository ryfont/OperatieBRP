/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.bericht.kern;

import java.util.HashSet;
import java.util.Set;
import nl.bzk.brp.model.logisch.kern.FamilierechtelijkeBetrekking;


/**
 * De familierechtelijke betrekking tussen het Kind enerzijds, en zijn/haar ouders anderzijds.
 * <p/>
 * De familierechtelijke betrekking "is" van het Kind. Adoptie, erkenning, dan wel het terugdraaien van een adoptie of erkenning heeft g��n invloed op de
 * familierechtelijke betrekking zelf: het blijft ��n en dezelfde Relatie.
 */
public final class FamilierechtelijkeBetrekkingBericht extends AbstractFamilierechtelijkeBetrekkingBericht implements
    FamilierechtelijkeBetrekking
{

    /**
     * Constructor die het discriminator attribuut zet of doorgeeft.
     */
    public FamilierechtelijkeBetrekkingBericht() {
        super();
    }

    /**
     * Haal de ouder betrokkenheden van de familie rechterlijk betrekking op.
     *
     * @return set met ouder betrokkenheden
     */
    public Set<OuderBericht> getOuderBetrokkenheden() {
        final Set<OuderBericht> ouderBetr = new HashSet<OuderBericht>();
        if (getBetrokkenheden() != null) {
            for (BetrokkenheidBericht betrokkenheidBericht : getBetrokkenheden()) {
                if (betrokkenheidBericht instanceof OuderBericht) {
                    ouderBetr.add((OuderBericht) betrokkenheidBericht);
                }
            }
        }
        return ouderBetr;
    }

    /**
     * Haal de kind betrokkenheid van de familie rechterlijk betrekking op.
     *
     * @return de kind betrokkenheid
     */
    public KindBericht getKindBetrokkenheid() {
        if (getBetrokkenheden() != null) {
            for (BetrokkenheidBericht betrokkenheidBericht : getBetrokkenheden()) {
                if (betrokkenheidBericht instanceof KindBericht) {
                    return (KindBericht) betrokkenheidBericht;
                }
            }
        }
        return null;
    }

}
