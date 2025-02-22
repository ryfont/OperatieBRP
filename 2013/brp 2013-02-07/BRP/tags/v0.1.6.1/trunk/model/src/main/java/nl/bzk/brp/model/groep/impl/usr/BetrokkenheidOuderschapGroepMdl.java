/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.groep.impl.usr;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

import nl.bzk.brp.model.groep.impl.gen.AbstractBetrokkenheidOuderschapGroepMdl;
import nl.bzk.brp.model.groep.interfaces.usr.BetrokkenheidOuderschapGroep;
import org.hibernate.annotations.Formula;

/**
 *
 */
@Embeddable
@Access(AccessType.FIELD)
@SuppressWarnings("serial")
public class BetrokkenheidOuderschapGroepMdl extends AbstractBetrokkenheidOuderschapGroepMdl
    implements BetrokkenheidOuderschapGroep
{
    @Formula("(select hbo.dataanvgel from kern.his_betrouder hbo where hbo.betr = id)")
    private Integer datumAanvangOuderschap;

    /**
     * Geef aan wanneer de ouderschap begint.
     * @return de datum
     */
    public Integer getDatumAanvangOuderschap() {
        return datumAanvangOuderschap;
    }

    protected void setDatumAanvangOuderschap(final Integer datumAanvangOuderschap) {
        this.datumAanvangOuderschap = datumAanvangOuderschap;
    }
}
