/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.moderniseringgba.migratie.conversie.proces.brpnaarlo3.groep;

import nl.moderniseringgba.migratie.conversie.model.brp.groep.AbstractBrpGroepInhoud;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Deze class representeert het ouderlijk gezag van ouder 2.
 * 
 * Deze class is immutable en threadsafe.
 */
public final class BrpOuder2GezagInhoud extends AbstractBrpGroepInhoud {
    private final Boolean ouderHeeftGezag;

    /**
     * Maakt een BrpOuder1GezagInhoud object.
     * 
     * @param ouderHeeftGezag
     *            true als de ouder gezag heeft, false indien geen gezag, null indien onbekend
     */
    public BrpOuder2GezagInhoud(final Boolean ouderHeeftGezag) {
        this.ouderHeeftGezag = ouderHeeftGezag;
    }

    @Override
    public boolean isLeeg() {
        return ouderHeeftGezag == null;
    }

    public Boolean getOuderHeeftGezag() {
        return ouderHeeftGezag;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BrpOuder2GezagInhoud)) {
            return false;
        }
        final BrpOuder2GezagInhoud castOther = (BrpOuder2GezagInhoud) other;
        return new EqualsBuilder().append(ouderHeeftGezag, castOther.ouderHeeftGezag).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(ouderHeeftGezag).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString())
                .append("ouderHeeftGezag", ouderHeeftGezag).toString();
    }
}
