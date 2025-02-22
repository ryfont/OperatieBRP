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
import nl.bzk.brp.model.hisvolledig.autaut.PersoonAfnemerindicatieHisVolledig;
import nl.bzk.brp.model.logisch.autaut.PersoonAfnemerindicatieHisMoment;

/**
 * Getter voor groepattribuut 'datum_tijd_verval' in objecttype 'HisPersoonAfnemerindicatie'.
 *
 */
@Generated(value = "nl.bzk.brp.generatoren.java.SymbolTableGenerator")
public class PersoonafnemerindicatieDatumTijdVervalGetter implements AttributeGetter {

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
        if (brpObject instanceof PersoonAfnemerindicatieHisVolledig) {
            final PersoonAfnemerindicatieHisVolledig v = (PersoonAfnemerindicatieHisVolledig) brpObject;
            if (v.getPersoonAfnemerindicatieHistorie() != null && v.getPersoonAfnemerindicatieHistorie().getActueleRecord() != null) {
                resultaat = v.getPersoonAfnemerindicatieHistorie().getActueleRecord().getDatumTijdVerval();
            }
        } else if (brpObject instanceof PersoonAfnemerindicatieHisMoment) {
            final PersoonAfnemerindicatieHisMoment v = (PersoonAfnemerindicatieHisMoment) brpObject;
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
        if (brpObject instanceof PersoonAfnemerindicatieHisVolledig) {
            final PersoonAfnemerindicatieHisVolledig p = (PersoonAfnemerindicatieHisVolledig) brpObject;
            final Iterator<nl.bzk.brp.model.operationeel.autaut.HisPersoonAfnemerindicatieModel> iterator =
                    p.getPersoonAfnemerindicatieHistorie().getHistorie().iterator();
            while (iterator.hasNext()) {
                attributen.add(iterator.next().getDatumTijdVerval());
            }
        }
        return attributen;
    }

}
