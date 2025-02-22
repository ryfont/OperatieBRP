/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nl.bzk.brp.model.validatie.Melding;

/**
 * Deze klasse stelt een antwoord bericht voor met alle elementen die terug gecommuniceerd worden via de webservice. Het
 * bevat eventuele meldingen (fouten, waarschuwingen etc.) die zijn opgetreden tijdens de verwerking van het bericht.
 */
public abstract class AbstractAntwoordBericht {

    private final List<Melding> meldingen;

    /**
     * Standaard constructor die een lege lijst van meldingen initialiseert.
     */
    public AbstractAntwoordBericht() {
        this(null);
    }

    /**
     * Standaard constructor die de lijst van meldingen initialiseert naar de meldingen in de opgegeven lijst.
     * @param meldingen de meldingen die in het antwoord bericht opgenomen dienen te worden.
     */
    public AbstractAntwoordBericht(final List<Melding> meldingen) {
        if (meldingen == null || meldingen.isEmpty()) {
            this.meldingen = null;
        } else {
            this.meldingen = new ArrayList<Melding>(meldingen);
        }
    }

    /**
     * Retourneert een (onaanpasbare) lijst van de opgetreden meldingen.
     * @return een (onaanpasbare) lijst van de opgetreden meldingen.
     */
    public List<Melding> getMeldingen() {
        List<Melding> resultaat;
        if (meldingen == null) {
            resultaat = null;
        } else {
            resultaat = Collections.unmodifiableList(meldingen);
        }
        return resultaat;
    }
}
