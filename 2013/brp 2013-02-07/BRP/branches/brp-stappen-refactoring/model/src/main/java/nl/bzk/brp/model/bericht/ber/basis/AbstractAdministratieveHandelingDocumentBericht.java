/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.bericht.ber.basis;

import nl.bzk.brp.model.basis.AbstractObjectTypeBericht;
import nl.bzk.brp.model.bericht.kern.AdministratieveHandelingBericht;
import nl.bzk.brp.model.bericht.kern.DocumentBericht;
import nl.bzk.brp.model.logisch.ber.AdministratieveHandelingDocument;
import nl.bzk.brp.model.logisch.ber.basis.AdministratieveHandelingDocumentBasis;


/**
 * De vastlegging van de in de Administratieve handeling gebruikte Documenten.
 *
 * Om een administratieve handeling te kunnen verantwoorden, kent de BRP een mechanisme waarin Acties via een
 * koppeltabel worden verantwoord door Documenten. Hierbij is het wenselijk dat eventuele nieuwe documenten kunnen
 * worden gescand. Om deze reden is er een vehikel nodig om de (technische) id's van de Documenten terug te leveren, op
 * het niveau van het bericht c.q. de Administratieve handeling, in plaats van het niveau waarin het is vastgelegd,
 * zijnde de Actie. Hierbij zijn de koppelingen tussen Administratieve handeling enerzijds, en Document anderzijds,
 * afleidbaar uit de (wel geadministreerde) koppeltabel tussen Actie en Document.
 *
 *
 *
 * Generator: nl.bzk.brp.generatoren.java.BerichtModelGenerator.
 * Metaregister versie: 1.6.0.
 * Generator versie: 1.0-SNAPSHOT.
 * Generator gebouwd op: 2013-01-15 12:43:16.
 * Gegenereerd op: Tue Jan 15 12:53:48 CET 2013.
 */
public abstract class AbstractAdministratieveHandelingDocumentBericht extends AbstractObjectTypeBericht implements
        AdministratieveHandelingDocumentBasis
{

    private AdministratieveHandelingBericht administratieveHandeling;
    private DocumentBericht                 document;

    /**
     * {@inheritDoc}
     */
    @Override
    public AdministratieveHandelingBericht getAdministratieveHandeling() {
        return administratieveHandeling;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DocumentBericht getDocument() {
        return document;
    }

    /**
     * Zet Administratieve handeling van Administratieve handeling \ Document.
     *
     * @param administratieveHandeling Administratieve handeling.
     */
    public void setAdministratieveHandeling(final AdministratieveHandelingBericht administratieveHandeling) {
        this.administratieveHandeling = administratieveHandeling;
    }

    /**
     * Zet Document van Administratieve handeling \ Document.
     *
     * @param document Document.
     */
    public void setDocument(final DocumentBericht document) {
        this.document = document;
    }

}
