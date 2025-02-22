/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.operationeel.kern;

import javax.persistence.Entity;
import javax.persistence.Table;

import nl.bzk.brp.model.algemeen.stamgegeven.kern.Rechtsgrond;
import nl.bzk.brp.model.logisch.kern.ActieBron;
import nl.bzk.brp.model.operationeel.kern.basis.AbstractActieBronModel;


/**
 * De Verantwoording van een Actie door een bron, hetzij een Document hetzij een Rechtsgrond.
 *
 * Een BRP Actie wordt verantwoord door nul, ��n of meer Documenten en nul, ��n of meer Rechtsgronden. Elke combinatie
 * van de Actie enerzijds en een bron (een Document of een Rechtsgrond) anderzijds, wordt vastgelegd.
 *
 * 1. De ontleningstoelicting is gemodelleerd als eigenschap van de BRP Actie. Voordeel hiervan is dat de beperking tot
 * ��n toelichting per Actie eenvoudig is af te dwingen. Het nadeel is dat voor het begrijpen van de Actie er zowel naar
 * de ontleningstoelichting moet worden gekeken, als naar de Verantwoording. Dit maakt echter dat het begrip van
 * "Verantwoording" iets wordt versimpeld: een verantwoording betreft altijd of een Document, of een Rechtsgrond.
 * RvdP 24-9-2012
 * 2. De naam is een tijdje 'verantwoording' geweest. Het is echter niet meer dan een koppeltabel tussen een actie
 * enerzijds, en een document of rechtsgrond anderzijds. Een generalisatie van document en rechtsgrond zou 'bron' zijn.
 * Passend in het BMR toegepaste patroon is dan om de koppeltabel - die actie enerzijds en bron anderzijds koppelt - dan
 * de naam Actie/Bron te noemen. Hiervoor is uiteindelijk gekozen.
 * RvdP 26 november 2012, aangepast 29 november.
 *
 *
 *
 */
@Entity
@Table(schema = "Kern", name = "ActieBron")
public class ActieBronModel extends AbstractActieBronModel implements ActieBron {

    /**
     * Standaard constructor (t.b.v. Hibernate/JPA).
     *
     */
    protected ActieBronModel() {
        super();
    }

    /**
     * Standaard constructor die direct alle identificerende attributen instantieert of doorgeeft.
     *
     * @param actie actie van Actie/Bron.
     * @param document document van Actie/Bron.
     * @param rechtsgrond rechtsgrond van Actie/Bron.
     */
    public ActieBronModel(final ActieModel actie, final DocumentModel document, final Rechtsgrond rechtsgrond) {
        super(actie, document, rechtsgrond);
    }

    /**
     * Copy constructor om vanuit het bericht model een instantie van het operationeel model te maken.
     *
     * @param actieBron Te kopieren object type.
     * @param actie Bijbehorende Actie.
     * @param document Bijbehorende Document.
     */
    public ActieBronModel(final ActieBron actieBron, final ActieModel actie, final DocumentModel document) {
        super(actieBron, actie, document);
    }

}
