/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.logisch.kern;


/**
 * De naam zoals die ontstaat door samenvoegen van alle exemplaren van Voornaam en van Geslachtsnaamcomponent van een Persoon.
 * <p/>
 * De Samengestelde naam is vrijwel altijd via een algoritme af te leiden uit de exemplaren van Voornaam en Geslachtsnaamcomponent van een Persoon. In
 * uitzonderingssituaties is dat niet mogelijk.
 * <p/>
 * De groep Samengestelde naam bevat de naam zoals die is opgebouwd uit de naamgegevens uit de groepen voornaam en geslachtsnaamcomponent. Deze
 * samengestelde gegevens hoeven bij het bijhouden van de groepen voornaam en geslachtsnaamcomponent niet door de voor de bijhouding verantwoordelijke
 * partij te worden ingevoerd. De centrale voorzieningen stellen de gegevens uit de groep samengestelde naam op dat moment samen op basis van de groepen
 * voornaam en geslachtsnaamcomponent volgens het onderstaande voorschrift:
 * <p/>
 * � Voornamen � de naam zoals opgenomen in de voornaam met volgnummer ��n, gevolgd de naam zoals opgenomen in de actuele groep voornaam met volgnummer
 * twee, enzovoort. De voornamen worden gescheiden door een spatie. Merk op dat de BRP is voorbereid op het opnemen van voornamen als 'Jan Peter' of
 * 'Aberto di Maria' of 'Wonder op aarde' als ��n enkele voornaam; in de BRP is het namelijk niet nodig (om conform LO 3.x) de verschillende worden aan
 * elkaar te plakken met een koppelteken.
 * <p/>
 * � Predikaat � het predikaat dat door de persoon gevoerd wordt voor diens voornaam. Dit komt overeen met het predikaat van de eerste
 * geslachtsnaamcomponent. Indien voor een persoon meerdere predikaten van toepassing is, het predikaar dat voor de voornamen geplaatst mag worden.
 * <p/>
 * � Adelijke titel � de adelijke titel zoals opgenomen in geslachtsnaamcomponent met volgnummer gelijk aan '1';
 * <p/>
 * � Voorvoegsel � het voorvoegsel zoals opgenomen in de geslachtsnaamcomponent met volgnummer gelijk aan '1';
 * <p/>
 * � Scheidingsteken � het scheidingsteken zoals opgenomen in de geslachtsnaamcomponent met volgnummer '1';
 * <p/>
 * � Geslachtsnaam � bestaande uit de samenvoeging van alle geslachtsnaamcomponenten, inclusief predikaten die niet voor de voornamen worden geplaatst. Ook
 * eventuele adellijke titels die niet voor de gehele geslachtsnaam wordt geplaatst, worden hierin opgenomen.
 * <p/>
 * Verplicht aanwezig bij persoon
 * <p/>
 * Historie: beide vormen van historie, aangezien de samengestelde naam ook kan wijzigen ZONDER dat er sprake is van terugwerkende kracht (met andere
 * woorden: 'vanaf vandaag heet ik...' ipv 'en deze moet met terugwerkende kracht gelden vanaf de geboorte'). RvdP 9 jan 2012
 */
public interface PersoonSamengesteldeNaamGroep extends PersoonSamengesteldeNaamGroepBasis {

}
