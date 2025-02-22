/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.hisvolledig.predikaatview.kern;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.Generated;
import nl.bzk.brp.model.FormeleHistorieSet;
import nl.bzk.brp.model.FormeleHistorieSetImpl;
import nl.bzk.brp.model.algemeen.attribuuttype.kern.DatumTijdAttribuut;
import nl.bzk.brp.model.hisvolledig.kern.PersoonIndicatieSignaleringMetBetrekkingTotVerstrekkenReisdocumentHisVolledig;
import nl.bzk.brp.model.hisvolledig.kern.PersoonIndicatieSignaleringMetBetrekkingTotVerstrekkenReisdocumentHisVolledigBasis;
import nl.bzk.brp.model.hisvolledig.predikaat.AltijdTonenGroepPredikaat;
import nl.bzk.brp.model.hisvolledig.predikaatview.FormeleHistorieEntiteitComparator;
import nl.bzk.brp.model.hisvolledig.predikaatview.HisVolledigPredikaatViewUtil;
import nl.bzk.brp.model.operationeel.kern.HisPersoonIndicatieSignaleringMetBetrekkingTotVerstrekkenReisdocumentModel;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

/**
 * Subtype klasse voor indicatie Signalering met betrekking tot verstrekken reisdocument?
 *
 */
@Generated(value = "nl.bzk.brp.generatoren.java.HisVolledigPredikaatViewModelGenerator")
public abstract class AbstractPersoonIndicatieSignaleringMetBetrekkingTotVerstrekkenReisdocumentHisVolledigView extends
        PersoonIndicatieHisVolledigView<HisPersoonIndicatieSignaleringMetBetrekkingTotVerstrekkenReisdocumentModel> implements
        PersoonIndicatieSignaleringMetBetrekkingTotVerstrekkenReisdocumentHisVolledigBasis
{

    /**
     * Constructor met predikaat en peilmoment.
     *
     * @param persoonIndicatieHisVolledig wrapped indicatie
     * @param predikaat predikaat
     * @param peilmomentVoorAltijdTonenGroepen peilmoment voor altijd tonen groepen
     */
    public AbstractPersoonIndicatieSignaleringMetBetrekkingTotVerstrekkenReisdocumentHisVolledigView(
        final PersoonIndicatieSignaleringMetBetrekkingTotVerstrekkenReisdocumentHisVolledig persoonIndicatieHisVolledig,
        final Predicate predikaat,
        final DatumTijdAttribuut peilmomentVoorAltijdTonenGroepen)
    {
        super(persoonIndicatieHisVolledig, predikaat, peilmomentVoorAltijdTonenGroepen);
    }

    /**
     * Constructor met predikaat.
     *
     * @param persoonIndicatieHisVolledig wrapped indicatie
     * @param predikaat predikaat
     */
    public AbstractPersoonIndicatieSignaleringMetBetrekkingTotVerstrekkenReisdocumentHisVolledigView(
        final PersoonIndicatieSignaleringMetBetrekkingTotVerstrekkenReisdocumentHisVolledig persoonIndicatieHisVolledig,
        final Predicate predikaat)
    {
        super(persoonIndicatieHisVolledig, predikaat);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final FormeleHistorieSet<HisPersoonIndicatieSignaleringMetBetrekkingTotVerstrekkenReisdocumentModel> getPersoonIndicatieHistorie() {
        final Set<HisPersoonIndicatieSignaleringMetBetrekkingTotVerstrekkenReisdocumentModel> historie =
                new HashSet<HisPersoonIndicatieSignaleringMetBetrekkingTotVerstrekkenReisdocumentModel>(
                    getPersoonIndicatie().getPersoonIndicatieHistorie().getHistorie());
        final Set<HisPersoonIndicatieSignaleringMetBetrekkingTotVerstrekkenReisdocumentModel> teTonenHistorie =
                new HashSet<HisPersoonIndicatieSignaleringMetBetrekkingTotVerstrekkenReisdocumentModel>();
        teTonenHistorie.addAll(historie);

        CollectionUtils.filter(teTonenHistorie, getPredikaat());
        if (HisVolledigPredikaatViewUtil.isAltijdTonenGroep(HisPersoonIndicatieSignaleringMetBetrekkingTotVerstrekkenReisdocumentModel.class)
            && teTonenHistorie.isEmpty()
            && getPeilmomentVoorAltijdTonenGroepen() != null)
        {
            CollectionUtils.select(historie, AltijdTonenGroepPredikaat.bekendOp(getPeilmomentVoorAltijdTonenGroepen()), teTonenHistorie);
        }
        final Set<HisPersoonIndicatieSignaleringMetBetrekkingTotVerstrekkenReisdocumentModel> gesorteerdeHistorie =
                new TreeSet<HisPersoonIndicatieSignaleringMetBetrekkingTotVerstrekkenReisdocumentModel>(
                    new FormeleHistorieEntiteitComparator<HisPersoonIndicatieSignaleringMetBetrekkingTotVerstrekkenReisdocumentModel>());
        gesorteerdeHistorie.addAll(teTonenHistorie);

        return new FormeleHistorieSetImpl<HisPersoonIndicatieSignaleringMetBetrekkingTotVerstrekkenReisdocumentModel>(gesorteerdeHistorie);

    }

}
