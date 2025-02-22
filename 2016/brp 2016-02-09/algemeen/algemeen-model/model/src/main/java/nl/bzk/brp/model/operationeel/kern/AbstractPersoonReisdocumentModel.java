/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.operationeel.kern;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AssociationOverride;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.SoortNederlandsReisdocumentAttribuut;
import nl.bzk.brp.model.basis.AbstractDynamischObject;
import nl.bzk.brp.model.basis.Attribuut;
import nl.bzk.brp.model.basis.Groep;
import nl.bzk.brp.model.basis.ModelIdentificeerbaar;
import nl.bzk.brp.model.logisch.kern.PersoonReisdocument;
import nl.bzk.brp.model.logisch.kern.PersoonReisdocumentBasis;

/**
 * Document dat vereist is voor het reizen naar het buitenland.
 *
 * In geval van bijschrijving van een kind in het reisdocument van de ouder is er geen sprake van een uitreiking aan het
 * kind maar van het opnemen van de gegevens van het kind in het reisdocument. Er is dan in deze terminologie wel sprake
 * van een nieuw persoon/reisdocument, waarbij het reisdocument het reisdocument is van de ouder.
 *
 * 1. Nederlandse identiteitskaarten mogen ook reisdocumenten genoemd worden. Hierover is afstemming geweest met beleid
 * en wet. Toelichting:
 *
 * Recentelijk is de Paspoortwet aangepast. Aanleiding voor het aanpassen van de Paspoortwet was de grote druk van een
 * aantal burgers (en hun advocaten) om een ID-document te verkrijgen waarmee je kunt reizen mogelijk te maken maar dan
 * ZONDER vingerafdrukken. Dat kon al in bijvoorbeeld Duitsland maar wij waren wat strenger in de leer.
 *
 * De wijziging betekent niet dat je met de Nederlandse identiteitskaart niet meer kunt reizen. Dat bepaalt namelijk
 * onze Paspoortwet niet maar de afspraken die landen onderling maken over het overschrijden van grenzen en met welke
 * documenten dat is toegestaan (voorbeeld daarvan is het ongetwijfeld bekende 'Schengenverdrag').
 *
 * De Paspoortwet spreekt nu over paspoorten en reisdocumenten naast Nederlandse identiteitskaart (NIK).
 *
 * Met de beleidsmakers en wetgevers van BZK is eerder gesproken over de vraag of een NIK nu wel of niet nog in de BRP
 * moet worden geregistreerd nu het niet meer in de Paspoortwet als reisdocument wordt aangemerkt. De conclusie is: wél
 * registreren in de BRP.
 *
 * Argument: Op grond van, artikel 2, lid 2, dat de NIK gelijk wordt gesteld met een reisdocument, het commentaar in de
 * nota naar aanleiding van het verslag voor wijziging paspoortwet en dat in de Wet BRP voor de omschrijving van het
 * begrip reisdocument wordt verwezen naar de paspoortwet kan ook de NIK worden verstaan als reisdocument.
 *
 * -Paspoortwet artikel 2, lid 2:- Identiteitskaart van het Europese deel van Nederland is de Nederlandse
 * identiteitskaart. Hetgeen bij of krachtens deze wet is bepaald ten aanzien van reisdocumenten is van overeenkomstige
 * toepassing op de Nederlandse identiteitskaart, tenzij anders is bepaald.
 *
 * -Memorie van Toelichting Paspoortwet:- Doel van de wijziging Bij brief van 19 mei 2011 is aan de Tweede Kamer
 * medegedeeld dat de Paspoortwet zal worden gewijzigd in verband met het besluit om de Nederlandse identiteitskaart
 * daarin niet meer de formele status van reisdocument toe te kennen2 . De Europese verordening3 waarin onder andere is
 * voorgeschreven dat paspoorten en andere reisdocumenten twee vingerafdrukken van de houder moeten bevatten, is dan
 * niet meer op de Nederlandse identiteitskaart van toepassing. Dit is tot nog toe wel het geval, omdat de Nederlandse
 * identiteitskaart in de huidige Paspoortwet is aangemerkt als een formeel reisdocument.4 Door deze wettelijke status
 * in de Paspoortwet te schrappen, geldt de bovenbedoelde Europese verordening niet meer voor de Nederlandse
 * identiteitskaart en ontstaat dezelfde situatie die in de overgrote meerderheid van de EU-lidstaten geldt ten opzichte
 * van hun nationale identiteitskaart. Hierdoor kan het opnemen van vingerafdrukken in de Nederlandse identiteitskaart
 * worden beëindigd. Het kabinet kiest er voor om wel de gedigitaliseerde foto (de gezichtsopname) in de Nederlandse
 * identiteitskaart te handhaven. Deze zal worden opgeslagen in een contactloze chip in de identiteitskaart. Dat biedt
 * onder meer de mogelijkheid om bij de controle van de Nederlandse identiteitskaart de foto uit te vergroten en zo
 * beter te kunnen vergelijken met de persoon die het document gebruikt. De specificaties van de Europese Unie die
 * gelden voor paspoorten en reisdocumenten zullen hiervoor worden gevolgd zowel wat betreft de chip als de
 * gezichtsopname.
 *
 *
 * 2. De opname van deze gegevens is noodzakelijk tot ingebruikname ORRA (Online Raadpleegbare Reisdocumenten
 * Administratie).
 *
 * 3. De modellering rondom autoriteit van afgifte kent vele opties, zoals één codetabel (waarin alle mogelijke codes
 * staan zoals benoemd in de LO3.x tabel), maar ook het splitsen in een 'typering' van autoriteit, en dan afhankelijk
 * van de 'type' of een verwijzing naar gemeente, provincie of land, of bijvoorbeeld verschillende verwijzingen naar de
 * autoriteit a-la 'provincie van autoriteit afgifte commissaris' en 'gemeente van autoriteit afgifte burgermeester' en
 * 'gemeente van autoriteit van afgifte college B&W'. De keuze is uiteindelijk op de middelste gevallen op basis van de
 * volgende overwegingen: - bij beheer van de landentabel of gemeentetabel (partijentabel) moet het niet noodzakelijk
 * zijn om ook (extra) beheer te doen op de stamgegevens rondom autoriteit: hierdoor viel de optie 'één codetabel' af. -
 * de verschillende attributen moeten een relatief eenvoudige naam hebben, en de definitie moet hierbij goed aansluiten.
 * De derde optie - met een verwijzing naar gemeenten voor verschillende typen autoriteiten [namelijk bij o.a.
 * commandant Maurechausse, Burgermeester én Burgermeester-en-Wethouders) - is minder begrijpelijk en valt door dit
 * criterium af.
 *
 * 4. In juni 2013 is persoon/reisdocument ernstig herontworpen: verduidelijkingen en verbeteringen die in de
 * modellering waren toegebracht (zoals het veld "datum uitgifte" ook zo te definiëren dat het ook daadwerkelijk werd
 * aangepast als eenzelfde document voor een tweede keer werd uitgegeven) werden teruggedraaid. Reden hiervoor:
 * wijzigingen tov de LO3.x versie kunnen de suggestie wekken dat er 'iets' wordt gedaan dat het uitstel van de ORRA zou
 * opvangen. Dat is echter niet het geval. Tevens wordt het als onwenselijk gezien om de ABS te confronteren met
 * gewijzigde betekenissen van velden wetende dat een echte aanpassing (ikv ORRA) nog op komst zal zijn. Om deze redenen
 * is de LO3.x modellering zo getrouw mogelijk weerspiegeld. Wel is in toelichting of definitie getracht de huidige
 * LO3.x praktijk te beschrijven.
 *
 *
 *
 */
@Access(value = AccessType.FIELD)
@Generated(value = "nl.bzk.brp.generatoren.java.OperationeelModelGenerator")
@MappedSuperclass
public abstract class AbstractPersoonReisdocumentModel extends AbstractDynamischObject implements PersoonReisdocumentBasis, ModelIdentificeerbaar<Integer>
{

    @Transient
    @JsonProperty
    private Integer iD;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Pers")
    private PersoonModel persoon;

    @Embedded
    @AssociationOverride(name = SoortNederlandsReisdocumentAttribuut.WAARDE_VELD_NAAM, joinColumns = @JoinColumn(name = "Srt"))
    @JsonProperty
    private SoortNederlandsReisdocumentAttribuut soort;

    @Embedded
    @JsonProperty
    private PersoonReisdocumentStandaardGroepModel standaard;

    /**
     * Default lege constructor t.b.v. Hibernate / JPA
     *
     */
    protected AbstractPersoonReisdocumentModel() {
    }

    /**
     * Standaard constructor die direct alle identificerende attributen instantieert of doorgeeft.
     *
     * @param persoon persoon van Persoon \ Reisdocument.
     * @param soort soort van Persoon \ Reisdocument.
     */
    public AbstractPersoonReisdocumentModel(final PersoonModel persoon, final SoortNederlandsReisdocumentAttribuut soort) {
        this();
        this.persoon = persoon;
        this.soort = soort;

    }

    /**
     * Copy constructor om vanuit het bericht model een instantie van het operationeel model te maken.
     *
     * @param persoonReisdocument Te kopieren object type.
     * @param persoon Bijbehorende Persoon.
     */
    public AbstractPersoonReisdocumentModel(final PersoonReisdocument persoonReisdocument, final PersoonModel persoon) {
        this();
        this.persoon = persoon;
        this.soort = persoonReisdocument.getSoort();
        if (persoonReisdocument.getStandaard() != null) {
            this.standaard = new PersoonReisdocumentStandaardGroepModel(persoonReisdocument.getStandaard());
        }

    }

    /**
     * Retourneert ID van Persoon \ Reisdocument.
     *
     * @return ID.
     */
    @Id
    @SequenceGenerator(name = "PERSOONREISDOCUMENT", sequenceName = "Kern.seq_PersReisdoc")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "PERSOONREISDOCUMENT")
    @Access(value = AccessType.PROPERTY)
    public Integer getID() {
        return iD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersoonModel getPersoon() {
        return persoon;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SoortNederlandsReisdocumentAttribuut getSoort() {
        return soort;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersoonReisdocumentStandaardGroepModel getStandaard() {
        return standaard;
    }

    /**
     * Setter is verplicht voor JPA, omdat de Id annotatie op de getter zit. We maken de functie private voor de
     * zekerheid.
     *
     * @param id Id
     */
    private void setID(final Integer id) {
        this.iD = id;
    }

    /**
     * Zet Standaard van Persoon \ Reisdocument.
     *
     * @param standaard Standaard.
     */
    public void setStandaard(final PersoonReisdocumentStandaardGroepModel standaard) {
        this.standaard = standaard;
    }

    /**
     * Geeft alle groepen van de object met uitzondering van groepen die null zijn.
     *
     * @return Lijst met groepen.
     */
    public List<Groep> getGroepen() {
        final List<Groep> groepen = new ArrayList<>();
        if (standaard != null) {
            groepen.add(standaard);
        }
        return groepen;
    }

    /**
     * Geeft alle attributen van de groep met uitzondering van attributen die null zijn.
     *
     * @return Lijst met attributen van het object.
     */
    public List<Attribuut> getAttributen() {
        final List<Attribuut> attributen = new ArrayList<>();
        if (soort != null) {
            attributen.add(soort);
        }
        return attributen;
    }

}
