/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.expressietaal.symbols.solvers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Generated;
import nl.bzk.brp.expressietaal.Expressie;
import nl.bzk.brp.expressietaal.expressies.literals.DateTimeLiteralExpressie;
import nl.bzk.brp.expressietaal.expressies.literals.NullValue;
import nl.bzk.brp.model.basis.Attribuut;
import nl.bzk.brp.model.basis.BrpObject;
import nl.bzk.brp.model.hisvolledig.kern.PersoonVerificatieHisVolledig;
import nl.bzk.brp.model.logisch.kern.PersoonVerificatieHisMoment;

/**
 * Getter voor groepattribuut 'datum_tijd_verval' in objecttype 'HisPersoonVerificatie'.
 *
 */
@Generated(value = "nl.bzk.brp.generatoren.java.SymbolTableGenerator")
public class PersoonverificatieDatumTijdVervalGetter implements AttributeGetter {

    /**
     * {@inheritDoc}
     */
    @Override
    public final Expressie getAttribuutWaarde(final BrpObject brpObject) {
        Expressie resultaat = NullValue.getInstance();
        final Attribuut attribuut = getAttribuut(brpObject);
        if (attribuut != null) {
            resultaat = new DateTimeLiteralExpressie(attribuut.getWaarde());
        }
        return resultaat;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Attribuut getAttribuut(final BrpObject brpObject) {
        Attribuut resultaat = null;
        if (brpObject instanceof PersoonVerificatieHisVolledig) {
            final PersoonVerificatieHisVolledig v = (PersoonVerificatieHisVolledig) brpObject;
            if (v.getPersoonVerificatieHistorie() != null && v.getPersoonVerificatieHistorie().getActueleRecord() != null) {
                resultaat = v.getPersoonVerificatieHistorie().getActueleRecord().getDatumTijdVerval();
            }
        } else if (brpObject instanceof PersoonVerificatieHisMoment) {
            final PersoonVerificatieHisMoment v = (PersoonVerificatieHisMoment) brpObject;
            if (v.getStandaard() != null) {
                resultaat = v.getStandaard().getDatumTijdVerval();
            }
        }
        return resultaat;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final List<Attribuut> getHistorischeAttributen(final BrpObject brpObject) {
        final List<Attribuut> attributen = new ArrayList<Attribuut>();
        if (brpObject instanceof PersoonVerificatieHisVolledig) {
            final PersoonVerificatieHisVolledig p = (PersoonVerificatieHisVolledig) brpObject;
            final Iterator<nl.bzk.brp.model.operationeel.kern.HisPersoonVerificatieModel> iterator =
                    p.getPersoonVerificatieHistorie().getHistorie().iterator();
            while (iterator.hasNext()) {
                attributen.add(iterator.next().getDatumTijdVerval());
            }
        }
        return attributen;
    }

}
