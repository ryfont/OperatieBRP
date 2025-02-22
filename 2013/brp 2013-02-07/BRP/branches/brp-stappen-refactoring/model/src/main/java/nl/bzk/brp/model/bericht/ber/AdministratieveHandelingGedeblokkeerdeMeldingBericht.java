/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.bericht.ber;

import nl.bzk.brp.model.bericht.ber.basis.AbstractAdministratieveHandelingGedeblokkeerdeMeldingBericht;
import nl.bzk.brp.model.logisch.ber.AdministratieveHandelingGedeblokkeerdeMelding;


/**
 * Het door middel van een bericht deblokkeren of gedeblokkkerd hebben van een (deblokkeerbare) fout.
 * <p/>
 * Een bijhoudingsbericht kan aanleiding zijn tot een of meer deblokkeerbare fouten. Een deblokkeerbare fout kan worden
 * gedeblokkeerd door in een bijhoudingsbericht expliciet de (deblokkeerbare) fout te de-blokkeren. Een gedeblokkeerde
 * fout wordt twee keer gekoppeld aan een bericht: enerzijds door een koppeling tussen het inkomende bijhoudingsbericht
 * en de deblokkage; anderzijds door het uitgaand bericht waarin wordt medegedeeld welke deblokkeringen zijn verwerkt.
 * <p/>
 * <p/>
 * <p/>
 * Generator: nl.bzk.brp.generatoren.java.BerichtModelGenerator.
 * Metaregister versie: 1.4.6.
 * Generator versie: 1.0-SNAPSHOT.
 * Generator gebouwd op: 2012-12-18 10:50:13.
 * Gegenereerd op: Tue Dec 18 10:54:27 CET 2012.
 */
public class AdministratieveHandelingGedeblokkeerdeMeldingBericht extends
    AbstractAdministratieveHandelingGedeblokkeerdeMeldingBericht implements
    AdministratieveHandelingGedeblokkeerdeMelding, Comparable<AdministratieveHandelingGedeblokkeerdeMeldingBericht>
{

    @Override
    public int compareTo(final AdministratieveHandelingGedeblokkeerdeMeldingBericht that) {
        // TODO: meer in details (als this.overrule of this..regel of this..regleCode is ook null
        if (null == that || null == that.getGedeblokkeerdeMelding()
            || null == that.getGedeblokkeerdeMelding().getRegel()
            || null == that.getGedeblokkeerdeMelding().getRegel().getCode())
        {
            return -1;
        } else {
            if (null == getGedeblokkeerdeMelding() || null == getGedeblokkeerdeMelding().getRegel()
                || null == getGedeblokkeerdeMelding().getRegel().getCode())
            {
                return -1;
            } else {
                return getGedeblokkeerdeMelding().getRegel().getCode().
                    compareTo(that.getGedeblokkeerdeMelding().getRegel().getCode());
            }
        }
    }

}
