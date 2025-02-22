/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.domain.kern;

// Generated 12-sep-2012 11:17:43 by Hibernate Tools 3.2.4.GA



/**
 * HisPersnation generated by hbm2java
 */
public class HisPersnation extends His {

    private Actie              actieByActieaanpgel;
    private Rdnverliesnlnation rdnverliesnlnation;
    private Persnation         persnation;
    private Rdnverknlnation    rdnverknlnation;
    public HisPersnation() {
    }

    public HisPersnation(final Persnation persnation) {
        this.persnation = persnation;
        this.rdnverliesnlnation = persnation.getRdnverliesnlnation();
        this.rdnverknlnation = persnation.getRdnverknlnation();
    }

    public Actie getActieByActieaanpgel() {
        return this.actieByActieaanpgel;
    }

    public void setActieByActieaanpgel(final Actie actieByActieaanpgel) {
        this.actieByActieaanpgel = actieByActieaanpgel;
    }

    public Rdnverliesnlnation getRdnverliesnlnation() {
        return this.rdnverliesnlnation;
    }

    public void setRdnverliesnlnation(final Rdnverliesnlnation rdnverliesnlnation) {
        this.rdnverliesnlnation = rdnverliesnlnation;
    }

    public Persnation getPersnation() {
        return this.persnation;
    }

    public void setPersnation(final Persnation persnation) {
        this.persnation = persnation;
    }

    public Rdnverknlnation getRdnverknlnation() {
        return this.rdnverknlnation;
    }

    public void setRdnverknlnation(final Rdnverknlnation rdnverknlnation) {
        this.rdnverknlnation = rdnverknlnation;
    }

}
