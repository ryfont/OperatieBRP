/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.business.definities.impl.afstamming;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import nl.bzk.brp.constanten.BrpConstanten;
import nl.bzk.brp.dataaccess.repository.PersoonRepository;
import nl.bzk.brp.dataaccess.repository.RelatieRepository;
import nl.bzk.brp.dataaccess.selectie.RelatieSelectieFilter;
import nl.bzk.brp.model.attribuuttype.Datum;
import nl.bzk.brp.model.objecttype.operationeel.BetrokkenheidModel;
import nl.bzk.brp.model.objecttype.operationeel.PersoonModel;
import nl.bzk.brp.model.objecttype.operationeel.statisch.Geslachtsaanduiding;
import nl.bzk.brp.model.objecttype.operationeel.statisch.SoortBetrokkenheid;
import nl.bzk.brp.model.objecttype.operationeel.statisch.SoortRelatie;
import nl.bzk.brp.util.DatumUtil;
import org.springframework.stereotype.Component;


/**
 * Implementatie van kandidaatVader.
 *
 */
@Component("kandidaatVader")
public class KandidaatVaderImpl implements KandidaatVader {

    private static final int  NL_DAGEN     = 306;
    private static final int  NIET_NL_DAGE = 365;

    @Inject
    private PersoonRepository persoonRepository;

    @Inject
    private RelatieRepository relatieRepository;

    @Override
    public List<PersoonModel> bepaalKandidatenVader(final PersoonModel moeder, final Datum geboorteDatumKind) {
        List<PersoonModel> kandidatenVader = new ArrayList<PersoonModel>();
        // zoek in de relaties, welke persone hebben een 'huwelijk' relatie met de moeder, rekening houdend
        // met het geslacht van de partner (== man) en dat de relatie geldig is op het moment van de
        // peilDatum (aka. geboorteDatumKind).

        RelatieSelectieFilter filter = new RelatieSelectieFilter();
        filter.setSoortRelaties(SoortRelatie.HUWELIJK);
        filter.setSoortBetrokkenheden(SoortBetrokkenheid.PARTNER);
        filter.setUitGeslachtsaanduidingen(Geslachtsaanduiding.MAN);

        List<BetrokkenheidModel> kandidaten = relatieRepository.haalOpBetrokkenhedenVanPersoon(moeder, filter);
        for (BetrokkenheidModel kandidaatVader : kandidaten) {
            if (kandidaatVader.getRelatie().getGegevens().getRedenBeeindigingRelatie() != null
                && kandidaatVader.getRelatie().getGegevens().getRedenBeeindigingRelatie().getCode().getWaarde()
                        .equals(BrpConstanten.REDEN_BEEINDIGING_RELATIE_OVERLIJDEN_CODE.getWaarde()))
            {
                // BRPUC50110 2. De moeder was gehuwd met de man echter dit huwelijk is ontbonden vanwege het
                // overlijden van de
                // man terwijl het kind is geboren binnen 306 dagen na het overlijden van de man (m.a.w.: verschil
                // tussen datum geboorte en datum overlijden is maximaal 306 dagen)

                // 2. De 306 dagen termijn geldt alleen als in de BRP kan worden vastgesteld dat de man de
                // Nederlandse nationaliteit had op datum overlijden, in alle andere gevallen zoals geen Nederlandse
                // nationaliteit, man is Niet-ingeschrevene of datum overlijden (gedeeltelijk) onbekend - moet 365
                // dagen worden genomen.

                // TODO onbekende datum nog niet in scope
                Datum huwelijkEinde = kandidaatVader.getRelatie().getGegevens().getDatumEinde();

                Datum periodeGeboorte;
                if (kandidaatVader.getBetrokkene().heeftActueleNederlandseNationaliteit()) {
                    periodeGeboorte = DatumUtil.voegToeDatum(geboorteDatumKind, Calendar.DATE, -NL_DAGEN);
                } else {
                    periodeGeboorte = DatumUtil.voegToeDatum(geboorteDatumKind, Calendar.DATE, -NIET_NL_DAGE);
                }

                if (DatumUtil.isGeldigOp(periodeGeboorte, geboorteDatumKind, huwelijkEinde)) {
                    kandidatenVader.add(persoonRepository.haalPersoonOpMetAdresViaBetrokkenheid(kandidaatVader));
                }
            }
        }

        if (kandidatenVader.size() == 0) {
            // BRPUC50110 3. De moeder is op de geboortedatum van het kind gehuwd met de man en er is geen andere
            // man die aan voorwaarde 2 voldoet.
            for (BetrokkenheidModel kandidaatVader : kandidaten) {
                Datum huwelijkAanvang = kandidaatVader.getRelatie().getGegevens().getDatumAanvang();
                Datum huwelijkEinde = kandidaatVader.getRelatie().getGegevens().getDatumEinde();

                if (DatumUtil.isGeldigOp(huwelijkAanvang, huwelijkEinde, geboorteDatumKind)) {
                    kandidatenVader.add(persoonRepository.haalPersoonOpMetAdresViaBetrokkenheid(kandidaatVader));
                }
            }
        }

        return kandidatenVader;
    }
}
