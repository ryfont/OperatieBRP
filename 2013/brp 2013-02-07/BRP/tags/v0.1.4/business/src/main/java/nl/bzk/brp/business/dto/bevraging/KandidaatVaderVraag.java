/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.business.dto.bevraging;

/**
 *
 * Vraag voor opvragen van de personen die op hetzelfde adres wonen en hun onderlinge relaties.
 *
 */
public class KandidaatVaderVraag extends AbstractVraag {

    private Integer geboortedatumKind;

    public Integer getGeboortedatumKind() {
        return geboortedatumKind;
    }

    public void setGeboortedatumKind(final Integer geboortedatumKind) {
        this.geboortedatumKind = geboortedatumKind;
    }

}
