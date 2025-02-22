/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.hisvolledig.predikaatview.kern;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import nl.bzk.brp.model.algemeen.attribuuttype.ber.MeldingtekstAttribuut;
import nl.bzk.brp.model.algemeen.attribuuttype.kern.DatumTijdAttribuut;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.ElementEnum;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.RegelAttribuut;
import nl.bzk.brp.model.basis.ElementIdentificeerbaar;
import nl.bzk.brp.model.basis.HistorieEntiteit;
import nl.bzk.brp.model.hisvolledig.kern.GedeblokkeerdeMeldingHisVolledig;
import nl.bzk.brp.model.hisvolledig.kern.GedeblokkeerdeMeldingHisVolledigBasis;
import nl.bzk.brp.model.hisvolledig.predikaatview.AbstractHisVolledigPredikaatView;
import org.apache.commons.collections.Predicate;

/**
 * Predikaat view voor Gedeblokkeerde melding.
 *
 */
@Generated(value = "nl.bzk.brp.generatoren.java.HisVolledigPredikaatViewModelGenerator")
public abstract class AbstractGedeblokkeerdeMeldingHisVolledigView extends AbstractHisVolledigPredikaatView implements
        GedeblokkeerdeMeldingHisVolledigBasis, ElementIdentificeerbaar
{

    protected final GedeblokkeerdeMeldingHisVolledig gedeblokkeerdeMelding;
    private DatumTijdAttribuut peilmomentVoorAltijdTonenGroepen;

    /**
     * Constructor die alle klasse variabelen initialiseert, behalve peilmoment.
     *
     * @param gedeblokkeerdeMeldingHisVolledig gedeblokkeerdeMelding
     * @param predikaat predikaat
     */
    public AbstractGedeblokkeerdeMeldingHisVolledigView(final GedeblokkeerdeMeldingHisVolledig gedeblokkeerdeMeldingHisVolledig, final Predicate predikaat)
    {
        this(gedeblokkeerdeMeldingHisVolledig, predikaat, null);

    }

    /**
     * Constructor die alle klasse variabelen initialiseert.
     *
     * @param gedeblokkeerdeMeldingHisVolledig gedeblokkeerdeMelding
     * @param predikaat predikaat
     * @param peilmomentVoorAltijdTonenGroepen peilmomentVoorAltijdTonenGroepen
     */
    public AbstractGedeblokkeerdeMeldingHisVolledigView(
        final GedeblokkeerdeMeldingHisVolledig gedeblokkeerdeMeldingHisVolledig,
        final Predicate predikaat,
        final DatumTijdAttribuut peilmomentVoorAltijdTonenGroepen)
    {
        super(predikaat);
        this.gedeblokkeerdeMelding = gedeblokkeerdeMeldingHisVolledig;
        this.peilmomentVoorAltijdTonenGroepen = peilmomentVoorAltijdTonenGroepen;

    }

    /**
     * Geeft de peilmomentVoorAltijdTonenGroepen terug.
     *
     * @return de peilmomentVoorAltijdTonenGroepen
     */
    public final DatumTijdAttribuut getPeilmomentVoorAltijdTonenGroepen() {
        return peilmomentVoorAltijdTonenGroepen;
    }

    /**
     * Zet de waarde van het veld peilmomentVoorAltijdTonenGroepen.
     *
     * @param peilmomentVoorAltijdTonenGroepen
     */
    public final void setPeilmomentVoorAltijdTonenGroepen(final DatumTijdAttribuut peilmomentVoorAltijdTonenGroepen) {
        this.peilmomentVoorAltijdTonenGroepen = peilmomentVoorAltijdTonenGroepen;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Long getID() {
        return gedeblokkeerdeMelding.getID();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final RegelAttribuut getRegel() {
        return gedeblokkeerdeMelding.getRegel();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final MeldingtekstAttribuut getMelding() {
        return gedeblokkeerdeMelding.getMelding();

    }

    /**
     *
     *
     * @return Retourneert alle historie records van alle groepen.
     */
    public Set<HistorieEntiteit> getAlleHistorieRecords() {
        final Set<HistorieEntiteit> resultaat = new HashSet<>();
        return resultaat;
    }

    /**
     * Retourneert het Element behorende bij dit objecttype.
     *
     * @return Element enum instantie behorende bij dit objecttype.
     */
    public final ElementEnum getElementIdentificatie() {
        return ElementEnum.GEDEBLOKKEERDEMELDING;
    }

}
