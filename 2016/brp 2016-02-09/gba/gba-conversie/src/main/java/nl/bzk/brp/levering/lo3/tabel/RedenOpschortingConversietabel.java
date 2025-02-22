/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.levering.lo3.tabel;

import java.util.List;
import java.util.Map.Entry;

import nl.bzk.brp.model.algemeen.stamgegeven.conv.ConversieRedenOpschorting;
import nl.bzk.migratiebrp.conversie.model.brp.attribuut.BrpNadereBijhoudingsaardCode;
import nl.bzk.migratiebrp.conversie.model.domein.conversietabel.ConversieMapEntry;
import nl.bzk.migratiebrp.conversie.model.domein.conversietabel.dynamisch.AbstractRedenOpschortingConversietabel;
import nl.bzk.migratiebrp.conversie.model.lo3.codes.Lo3RedenOpschortingBijhoudingCodeEnum;
import nl.bzk.migratiebrp.conversie.model.lo3.element.Lo3RedenOpschortingBijhoudingCode;

/**
 * Deze conversietabel map een Lo3RedenOpschortingBijhoudingCode op de corresponderen BrpRedenOpschortingBijhoudingCode
 * vice versa.
 */
public final class RedenOpschortingConversietabel extends AbstractRedenOpschortingConversietabel {

    /**
     * Maakt een RedenOpschortingConversietabel object.
     *
     * @param list de lijst met waarden uit de conversietabel.
     */
    public RedenOpschortingConversietabel(final List<ConversieRedenOpschorting> list) {
        super(new Converter().converteer(list));
    }

    /**
     * Converteer de lijst van {@link ConversieRedenOpschorting} naar een conversie map van de LO3 waarde
     * {@link Lo3RedenOpschortingBijhoudingCode} en de BRP waarde {@link BrpNadereBijhoudingsaardCode}.
     */
    private static final class Converter extends
            AbstractLijstConverter<ConversieRedenOpschorting, Lo3RedenOpschortingBijhoudingCode, BrpNadereBijhoudingsaardCode>
    {
        @Override
        protected void toevoegenStatischeVertalingen(final List<Entry<Lo3RedenOpschortingBijhoudingCode, BrpNadereBijhoudingsaardCode>> resultaat) {
            resultaat.add(new ConversieMapEntry<>(Lo3RedenOpschortingBijhoudingCodeEnum.EMIGRATIE.asElement(), (BrpNadereBijhoudingsaardCode) null));
            resultaat.add(new ConversieMapEntry<>(Lo3RedenOpschortingBijhoudingCodeEnum.RNI.asElement(), (BrpNadereBijhoudingsaardCode) null));
        }

        @Override
        protected Lo3RedenOpschortingBijhoudingCode maakLo3Waarde(final ConversieRedenOpschorting redenOpschorting) {
            return new Lo3RedenOpschortingBijhoudingCode(redenOpschorting.getRubriek6720OmschrijvingRedenOpschortingBijhouding().getWaarde());
        }

        @Override
        protected BrpNadereBijhoudingsaardCode maakBrpWaarde(final ConversieRedenOpschorting redenOpschorting) {
            return new BrpNadereBijhoudingsaardCode(redenOpschorting.getNadereBijhoudingsaard().getCode());
        }
    }
}
