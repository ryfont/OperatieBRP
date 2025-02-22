/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.groep.logisch.basis;

import nl.bzk.brp.model.attribuuttype.Geslachtsnaamcomponent;
import nl.bzk.brp.model.attribuuttype.JaNee;
import nl.bzk.brp.model.attribuuttype.Scheidingsteken;
import nl.bzk.brp.model.attribuuttype.Voornaam;
import nl.bzk.brp.model.attribuuttype.Voorvoegsel;
import nl.bzk.brp.model.basis.Groep;
import nl.bzk.brp.model.objecttype.operationeel.statisch.AdellijkeTitel;
import nl.bzk.brp.model.objecttype.operationeel.statisch.Predikaat;
import nl.bzk.brp.model.objecttype.operationeel.statisch.WijzeGebruikGeslachtsnaam;

/**
 * .
 */

public interface PersoonAanschrijvingGroepBasis extends Groep {
    /**
     * .
     * @return naam
     */
    WijzeGebruikGeslachtsnaam   getGebruikGeslachtsnaam();
    /**
     * .
     * @return indAanschrijvenMetAdellijkeTitel
     */
    JaNee                   getIndAanschrijvenMetAdellijkeTitel();
    /**
     * .
     * @return indAanschrijvingAlgorthmischAfgeleid
     */
    JaNee                   getIndAanschrijvingAlgorthmischAfgeleid();
    /**
     * .
     * @return indAanschrijvingAlgorthmischAfgeleid
     */
    Predikaat getPredikaat();

    /**
     * Deze staat niet in de database pers !!
     * @return
     */
    //    AdellijkeTitel          getAdellijkeTitel();

    /**
     * .
     * @return voornamen
     */
    Voornaam                getVoornamen();
    /**
     * .
     * @return voorvoegsel
     */
    Voorvoegsel             getVoorvoegsel();
    /**
     * .
     * @return scheidingsteken
     */
    Scheidingsteken getScheidingsteken();
    /**
     * .
     * @return geslachtsnaam
     */
    Geslachtsnaamcomponent getGeslachtsnaam();

    /**
     * .
     * @return adellijkeTitel
     */
    AdellijkeTitel getAdellijkeTitel();

    // technisch
    // AttribuutType<Integer>  getStatus();
}
