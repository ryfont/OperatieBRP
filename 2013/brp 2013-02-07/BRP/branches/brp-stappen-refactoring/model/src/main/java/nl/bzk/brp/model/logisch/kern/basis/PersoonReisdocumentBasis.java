/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.logisch.kern.basis;

import nl.bzk.brp.model.algemeen.stamgegeven.kern.SoortNederlandsReisdocument;
import nl.bzk.brp.model.basis.ObjectType;
import nl.bzk.brp.model.logisch.kern.Persoon;
import nl.bzk.brp.model.logisch.kern.PersoonReisdocumentStandaardGroep;


/**
 * Document dat vereist is voor het reizen naar het buitenland.
 *
 * 1. De opname van deze gegevens is noodzakelijk tot uitfasering LO 3.7 en/of ingebruikname ORRA.
 * RvdP 5 september 2011
 * 2. De modellering rondom autoriteit van afgifte kent vele opties, zoals ��n codetabel (waarin alle mogelijke codes
 * staan zoals benoemd in de LO3.x tabel), maar ook het splitsen in een 'typering' van autoriteit, en dan afhankelijk
 * van de 'type' of een verwijzing naar gemeente, provincie of land, of bijvoorbeeld verschillende verwijzingen naar de
 * autoriteit a-la 'provincie van autoriteit afgifte commissaris' en 'gemeente van autoriteit afgifte burgermeester' en
 * 'gemeente van autoriteit van afgifte college B&W'.
 * De keuze is uiteindelijk op de middelste gevallen op basis van de volgende overwegingen:
 * - bij beheer van de landentabel of gemeentetabel (partijentabel) moet het niet noodzakelijk zijn om ook (extra)
 * beheer te doen op de stamgegevens rondom autoriteit: hierdoor viel de optie '��n codetabel' af.
 * - de verschillende attributen moeten een relatief eenvoudige naam hebben, en de definitie moet hierbij goed
 * aansluiten. De derde optie - met een verwijzing naar gemeenten voor verschillende typen autoriteiten [namelijk bij
 * o.a. commandant Maurechausse, Burgermeester �n Burgermeester-en-Wethouders) - is minder begrijpelijk en valt door dit
 * criterium af.
 * RvdP 2 oktober 2012.
 *
 *
 *
 * Generator: nl.bzk.brp.generatoren.java.LogischModelGenerator.
 * Generator versie: 1.0-SNAPSHOT.
 * Metaregister versie: 1.6.0.
 * Gegenereerd op: Tue Jan 15 12:53:52 CET 2013.
 */
public interface PersoonReisdocumentBasis extends ObjectType {

    /**
     * Retourneert Persoon van Persoon \ Reisdocument.
     *
     * @return Persoon.
     */
    Persoon getPersoon();

    /**
     * Retourneert Soort van Persoon \ Reisdocument.
     *
     * @return Soort.
     */
    SoortNederlandsReisdocument getSoort();

    /**
     * Retourneert Standaard van Persoon \ Reisdocument.
     *
     * @return Standaard.
     */
    PersoonReisdocumentStandaardGroep getStandaard();

}
