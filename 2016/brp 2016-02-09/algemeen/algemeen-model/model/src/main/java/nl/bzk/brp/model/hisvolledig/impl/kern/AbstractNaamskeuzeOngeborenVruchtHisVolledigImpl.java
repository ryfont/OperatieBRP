/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.hisvolledig.impl.kern;

import javax.annotation.Generated;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.MappedSuperclass;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.ElementEnum;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.SoortRelatie;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.SoortRelatieAttribuut;
import nl.bzk.brp.model.basis.ElementIdentificeerbaar;
import nl.bzk.brp.model.hisvolledig.kern.NaamskeuzeOngeborenVruchtHisVolledigBasis;

/**
 * HisVolledig klasse voor Naamskeuze ongeboren vrucht.
 *
 */
@Access(value = AccessType.FIELD)
@Generated(value = "nl.bzk.brp.generatoren.java.HisVolledigModelGenerator")
@MappedSuperclass
public abstract class AbstractNaamskeuzeOngeborenVruchtHisVolledigImpl extends RelatieHisVolledigImpl implements
        NaamskeuzeOngeborenVruchtHisVolledigBasis, ElementIdentificeerbaar
{

    /**
     * Standaard constructor die direct alle identificerende attributen instantieert of doorgeeft.
     *
     */
    public AbstractNaamskeuzeOngeborenVruchtHisVolledigImpl() {
        super(new SoortRelatieAttribuut(SoortRelatie.NAAMSKEUZE_ONGEBOREN_VRUCHT));
    }

    /**
     * Retourneert het Element behorende bij dit objecttype.
     *
     * @return Element enum instantie behorende bij dit objecttype.
     */
    public final ElementEnum getElementIdentificatie() {
        return ElementEnum.NAAMSKEUZEONGEBORENVRUCHT;
    }

}
