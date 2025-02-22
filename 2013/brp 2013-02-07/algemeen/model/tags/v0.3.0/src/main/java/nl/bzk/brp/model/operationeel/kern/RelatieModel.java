/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.operationeel.kern;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import nl.bzk.brp.model.algemeen.stamgegeven.kern.SoortRelatie;
import nl.bzk.brp.model.logisch.kern.Relatie;
import nl.bzk.brp.model.operationeel.kern.basis.AbstractRelatieModel;


/**
 * De Relatie tussen personen.
 *
 * Een Relatie tussen twee of meer Personen is als aparte object opgenomen. Het relatie-object beschrijft om wat voor
 * soort relatie het gaat, en waar en wanneer deze begonnen en/of be�indigd is. Het koppelen van een Persoon aan een
 * Relatie gebeurt via een object van het type Betrokkenheid.
 *
 * 1. Naast de nu onderkende relatievormen (Huwelijk, geregistreerd partnerschap en familierechtelijkebetrekking) is er
 * lange tijd sprake geweest van nog een aantal binaire relatievormen: erkenning ongeboren vrucht, ontkenning ouderschap
 * en naamskeuze ongeboren vrucht. Deze relatievormen zijn in een laat stadium alsnog geschrapt uit de gegevensset.
 * De gekozen constructie van o.a. Relatie is echter nog steeds gebaseerd op mogelijke toevoegingen.
 * De keuze om NIET terug te komen op de constructie is gebaseerd op enerzijds het late stadium waarin het schrappen van
 * de verschillende relatievormen is doorgevoerd, en anderzijds de mogelijkheid om in de toekomst eventuele nieuwe
 * (binaire) relatievormen eenvoudig te kunnen toevoegen.
 * RvdP, 5 augustus 2011
 *
 *
 *
 */
@Table(schema = "Kern", name = "Relatie")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Srt", discriminatorType = DiscriminatorType.INTEGER)
@Entity
public abstract class RelatieModel extends AbstractRelatieModel implements Relatie {

    /**
     * Standaard constructor (t.b.v. Hibernate/JPA).
     *
     */
    protected RelatieModel() {
        super();
    }

    /**
     * Standaard constructor die direct alle identificerende attributen instantieert of doorgeeft.
     *
     * @param soort soort van Relatie.
     */
    public RelatieModel(final SoortRelatie soort) {
        super(soort);
    }

    /**
     * Copy constructor om vanuit het bericht model een instantie van het operationeel model te maken.
     *
     * @param relatie Te kopieren object type.
     */
    public RelatieModel(final Relatie relatie) {
        super(relatie);
    }

}
