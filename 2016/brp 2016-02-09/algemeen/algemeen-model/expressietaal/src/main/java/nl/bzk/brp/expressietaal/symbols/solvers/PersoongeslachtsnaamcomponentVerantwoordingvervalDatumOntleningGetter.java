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
import nl.bzk.brp.expressietaal.expressies.literals.DatumLiteralExpressie;
import nl.bzk.brp.expressietaal.expressies.literals.NullValue;
import nl.bzk.brp.model.basis.Attribuut;
import nl.bzk.brp.model.basis.BrpObject;
import nl.bzk.brp.model.hisvolledig.kern.PersoonGeslachtsnaamcomponentHisVolledig;
import nl.bzk.brp.model.logisch.kern.PersoonGeslachtsnaamcomponentHisMoment;

/**
 * Getter voor groepattribuut 'verantwoordingVerval.datum_ontlening' in objecttype 'Actie'.
 *
 */
@Generated(value = "nl.bzk.brp.generatoren.java.SymbolTableGenerator")
public class PersoongeslachtsnaamcomponentVerantwoordingvervalDatumOntleningGetter implements AttributeGetter {

    /**
     * {@inheritDoc}
     */
    @Override
    public final Expressie getAttribuutWaarde(final BrpObject brpObject) {
        final Attribuut attribuut = getAttribuut(brpObject);
        Expressie resultaat = NullValue.getInstance();
        if (attribuut != null) {
            resultaat = new DatumLiteralExpressie(getAttribuut(brpObject).getWaarde());
        }
        return resultaat;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Attribuut getAttribuut(final BrpObject brpObject) {
        Attribuut resultaat = null;
        if (brpObject instanceof PersoonGeslachtsnaamcomponentHisMoment) {
            final PersoonGeslachtsnaamcomponentHisMoment v = (PersoonGeslachtsnaamcomponentHisMoment) brpObject;
            if (v.getStandaard() != null && v.getStandaard().getVerantwoordingVerval() != null) {
                resultaat = v.getStandaard().getVerantwoordingVerval().getDatumOntlening();
            }
        } else if (brpObject instanceof PersoonGeslachtsnaamcomponentHisVolledig) {
            final PersoonGeslachtsnaamcomponentHisVolledig v = (PersoonGeslachtsnaamcomponentHisVolledig) brpObject;
            if (v.getPersoonGeslachtsnaamcomponentHistorie() != null
                && v.getPersoonGeslachtsnaamcomponentHistorie().getActueleRecord() != null
                && v.getPersoonGeslachtsnaamcomponentHistorie().getActueleRecord().getVerantwoordingVerval() != null)
            {
                resultaat = v.getPersoonGeslachtsnaamcomponentHistorie().getActueleRecord().getVerantwoordingVerval().getDatumOntlening();
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
        if (brpObject instanceof PersoonGeslachtsnaamcomponentHisVolledig) {
            final PersoonGeslachtsnaamcomponentHisVolledig p = (PersoonGeslachtsnaamcomponentHisVolledig) brpObject;
            final Iterator<nl.bzk.brp.model.operationeel.kern.HisPersoonGeslachtsnaamcomponentModel> iterator =
                    p.getPersoonGeslachtsnaamcomponentHistorie().getHistorie().iterator();
            while (iterator.hasNext()) {
                final nl.bzk.brp.model.operationeel.kern.HisPersoonGeslachtsnaamcomponentModel hisModel = iterator.next();
                if (hisModel.getVerantwoordingVerval() != null) {
                    attributen.add(hisModel.getVerantwoordingVerval().getDatumOntlening());
                }
            }
        }
        return attributen;
    }

}
