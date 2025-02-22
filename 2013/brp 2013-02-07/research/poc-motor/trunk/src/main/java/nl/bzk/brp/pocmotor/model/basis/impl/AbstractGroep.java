/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.pocmotor.model.basis.impl;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import nl.bzk.brp.pocmotor.model.basis.Groep;
import nl.bzk.brp.pocmotor.model.basis.OnderzoekBaar;
@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class AbstractGroep implements Groep, OnderzoekBaar, Serializable {

    @Transient
    private boolean inOnderzoek;

    @Override
    public boolean isInOnderzoek() {
        return inOnderzoek;
    }
}
