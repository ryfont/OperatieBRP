/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.logisch;

import java.util.Set;

import javax.validation.Valid;

import nl.bzk.brp.model.RootObject;
import nl.bzk.brp.model.logisch.groep.PersoonGeboorte;
import nl.bzk.brp.model.logisch.groep.PersoonGeslachtsAanduiding;
import nl.bzk.brp.model.logisch.groep.PersoonIdentificatienummers;
import nl.bzk.brp.model.logisch.groep.PersoonIdentiteit;


/**
 * Persoon.
 *
 */
public class Persoon implements RootObject {

    private PersoonIdentiteit           identiteit = new PersoonIdentiteit();

    @Valid
    private PersoonIdentificatienummers identificatienummers;

    @Valid
    private Set<PersoonAdres>           adressen;

    private PersoonGeboorte             persoonGeboorte;

    private String                      geslachtsNaam;

    private String                      voornamen;

    private PersoonGeslachtsAanduiding  persoonGeslachtsAanduiding;

    /**
     * Geeft de id terug.
     *
     * @return null wanneer de persoon geen PersoonIdentiteit heeft
     */
    public Long getId() {
        if (identiteit != null) {
            return identiteit.getId();
        }
        return null;
    }

    /**
     * Maak een PersoonIdentiteit en set de id.
     *
     * @param id PersoonIdentiteit id
     */
    public void setId(final Long id) {
        if (identiteit == null) {
            identiteit = new PersoonIdentiteit();
        }
        identiteit.setId(id);
    }

    public PersoonIdentiteit getIdentiteit() {
        return identiteit;
    }

    public void setIdentiteit(final PersoonIdentiteit identiteit) {
        this.identiteit = identiteit;
    }

    public PersoonIdentificatienummers getIdentificatienummers() {
        return identificatienummers;
    }

    public void setIdentificatienummers(final PersoonIdentificatienummers identificatienummers) {
        this.identificatienummers = identificatienummers;
    }

    public Set<PersoonAdres> getAdressen() {
        return adressen;
    }

    public void setAdressen(final Set<PersoonAdres> adressen) {
        this.adressen = adressen;
    }

    public PersoonGeboorte getPersoonGeboorte() {
        return persoonGeboorte;
    }

    public void setPersoonGeboorte(final PersoonGeboorte persoonGeboorte) {
        this.persoonGeboorte = persoonGeboorte;
    }

    public String getGeslachtsNaam() {
        return geslachtsNaam;
    }

    public void setGeslachtsNaam(final String geslachtsNaam) {
        this.geslachtsNaam = geslachtsNaam;
    }

    public String getVoornamen() {
        return voornamen;
    }

    public void setVoornamen(final String voornamen) {
        this.voornamen = voornamen;
    }

    public PersoonGeslachtsAanduiding getPersoonGeslachtsAanduiding() {
        return persoonGeslachtsAanduiding;
    }

    public void setPersoonGeslachtsAanduiding(final PersoonGeslachtsAanduiding persoonGeslachtsAanduiding) {
        this.persoonGeslachtsAanduiding = persoonGeslachtsAanduiding;
    }
}
