/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.objecttype.operationeel.statisch;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import nl.bzk.brp.model.attribuuttype.NaamEnumeratiewaarde;
import nl.bzk.brp.model.attribuuttype.PredikaatCode;
import nl.bzk.brp.model.basis.AbstractStatischObjectType;


/**
 * Wrapper voor de predikaten.
 *
 */
@Entity
@Table(schema = "Kern", name = "Predikaat")
@Access(AccessType.FIELD)
public class Predikaat extends AbstractStatischObjectType {

    /* predikaat objecten hebben een id, code, mannelijke en vrouwelijke aanschrijftitel */
    @Id
    private Short id;

    @Embedded
    @AttributeOverride(name = "waarde", column = @Column(name = "code"))
    private PredikaatCode    code;

    @Embedded
    @AttributeOverride(name = "waarde", column = @Column(name = "naamMannelijk"))
    private NaamEnumeratiewaarde naamMannelijk;

    @Embedded
    @AttributeOverride(name = "waarde", column = @Column(name = "naamVrouwelijk"))
    private NaamEnumeratiewaarde naamVrouwelijk;

    public Short getId() {
        return id;
    }

    public PredikaatCode getCode() {
        return code;
    }

    public void setCode(final PredikaatCode code) {
        this.code = code;
    }

    public NaamEnumeratiewaarde getNaamMannelijk() {
        return naamMannelijk;
    }

    public void setNaamMannelijk(final NaamEnumeratiewaarde naamMannelijk) {
        this.naamMannelijk = naamMannelijk;
    }

    public NaamEnumeratiewaarde getNaamVrouwelijk() {
        return naamVrouwelijk;
    }

    public void setNaamVrouwelijk(final NaamEnumeratiewaarde naamVrouwelijk) {
        this.naamVrouwelijk = naamVrouwelijk;
    }
}
