/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.objecttype.logisch.basis;

import nl.bzk.brp.model.attribuuttype.Datum;
import nl.bzk.brp.model.attribuuttype.DatumTijd;
import nl.bzk.brp.model.attribuuttype.OntleningsToelichting;
import nl.bzk.brp.model.basis.ObjectType;
import nl.bzk.brp.model.objecttype.logisch.Verdrag;
import nl.bzk.brp.model.objecttype.operationeel.statisch.Partij;
import nl.bzk.brp.model.objecttype.operationeel.statisch.SoortActie;

/**
 * Interface voor objecttype actie.
 */
public interface ActieBasis extends ObjectType {

    /**
     * Retourneert de partij die de actie heeft uitgevoerd.
     * @return Partij verantwoordelijk voor de actie.
     */
    Partij getPartij();

    /**
     * Retourneert het verdrag waaronder de actie mocht plaatsvinden.
     * @return Her verdrag.
     */
    Verdrag getVerdrag();

    /**
     * Retourneert tijdstip ontlening van de actie.
     * @return Tijdstip ontlening.
     */
    DatumTijd getTijdstipOntlening();

    /**
     * Retourneert tijdstip registratie van de actie.
     * @return Tijdstip registratie.
     */
    DatumTijd getTijdstipRegistratie();

    /**
     * Retourneert soort actie.
     * @return Actie soort.
     */
    SoortActie getSoort();

    /**
     * Retourneert datum aanvang geldigheid van de actie inhoud.
     * @return Datum aanvang geldigheid.
     */
    Datum getDatumAanvangGeldigheid();

    /**
     * Retourneert datum einde geldigheid van de actie.
     * @return Datum einde geldigheid.
     */
    Datum getDatumEindeGeldigheid();

    /**
     * Retourneert toelichting ontlening op de actie.
     * @return Toelichting ontlening.
     */
    OntleningsToelichting getOntleningsToelichting();
}
