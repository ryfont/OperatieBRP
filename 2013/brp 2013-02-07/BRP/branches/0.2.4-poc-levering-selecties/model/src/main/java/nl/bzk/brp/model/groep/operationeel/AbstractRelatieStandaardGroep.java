/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.groep.operationeel;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonProperty;
import nl.bzk.brp.model.attribuuttype.BuitenlandsePlaats;
import nl.bzk.brp.model.attribuuttype.BuitenlandseRegio;
import nl.bzk.brp.model.attribuuttype.Datum;
import nl.bzk.brp.model.attribuuttype.Omschrijving;
import nl.bzk.brp.model.basis.AbstractGroep;
import nl.bzk.brp.model.groep.logisch.basis.RelatieStandaardGroepBasis;
import nl.bzk.brp.model.objecttype.operationeel.statisch.Land;
import nl.bzk.brp.model.objecttype.operationeel.statisch.Partij;
import nl.bzk.brp.model.objecttype.operationeel.statisch.Plaats;
import nl.bzk.brp.model.objecttype.operationeel.statisch.RedenBeeindigingRelatie;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


/**
 *
 */
@MappedSuperclass
@Access(AccessType.FIELD)
@SuppressWarnings("serial")
public abstract class AbstractRelatieStandaardGroep extends AbstractGroep implements RelatieStandaardGroepBasis {

    @Embedded
    @AttributeOverride(name = "waarde", column = @Column(name = "dataanv"))
    @JsonProperty
    private Datum                   datumAanvang;

    @Embedded
    @AttributeOverride(name = "waarde", column = @Column(name = "dateinde"))
    @JsonProperty
    private Datum                   datumEinde;

    @ManyToOne
    @JoinColumn(name = "landaanv")
    @Fetch(FetchMode.JOIN)
    @JsonProperty
    private Land                    landAanvang;

    @ManyToOne
    @JoinColumn(name = "landeinde")
    @Fetch(FetchMode.JOIN)
    @JsonProperty
    private Land                    landEinde;

    @ManyToOne
    @JoinColumn(name = "gemaanv")
    @Fetch(FetchMode.JOIN)
    @JsonProperty
    private Partij                  gemeenteAanvang;

    @ManyToOne
    @JoinColumn(name = "gemeinde")
    @Fetch(FetchMode.JOIN)
    @JsonProperty
    private Partij                  gemeenteEinde;

    @ManyToOne
    @JoinColumn(name = "rdneinde")
    @Fetch(FetchMode.JOIN)
    @JsonProperty
    private RedenBeeindigingRelatie redenBeeindigingRelatie;

    @Embedded
    @AttributeOverride(name = "waarde", column = @Column(name = "omslocaanv"))
    @JsonProperty
    private Omschrijving            omschrijvingLocatieAanvang;

    @Embedded
    @AttributeOverride(name = "waarde", column = @Column(name = "omsloceinde"))
    @JsonProperty
    private Omschrijving            omschrijvingLocatieEinde;

    @ManyToOne
    @JoinColumn(name = "wplaanv")
    @Fetch(FetchMode.JOIN)
    @JsonProperty
    private Plaats                  woonPlaatsAanvang;

    @ManyToOne
    @JoinColumn(name = "wpleinde")
    @Fetch(FetchMode.JOIN)
    @JsonProperty
    private Plaats                  woonPlaatsEinde;

    @Embedded
    @AttributeOverride(name = "waarde", column = @Column(name = "blplaatsaanv"))
    @JsonProperty
    private BuitenlandsePlaats      buitenlandsePlaatsAanvang;

    @Embedded
    @AttributeOverride(name = "waarde", column = @Column(name = "blplaatseinde"))
    @JsonProperty
    private BuitenlandsePlaats      buitenlandsePlaatsEinde;

    @Embedded
    @AttributeOverride(name = "waarde", column = @Column(name = "blregioaanv"))
    @JsonProperty
    private BuitenlandseRegio       buitenlandseRegioAanvang;

    @Embedded
    @AttributeOverride(name = "waarde", column = @Column(name = "blregioeinde"))
    @JsonProperty
    private BuitenlandseRegio       buitenlandseRegioEinde;

    /**
     * Default constructor tbv hibernate.
     */
    protected AbstractRelatieStandaardGroep() {

    }

    /**
     * .
     *
     * @param relatieStandaardGroepBasis RelatieStandaardGroepBasis
     */
    public AbstractRelatieStandaardGroep(final RelatieStandaardGroepBasis relatieStandaardGroepBasis) {
        // Mischien via bean copy i.p.v met de hand copieren?
        datumAanvang = relatieStandaardGroepBasis.getDatumAanvang();
        datumEinde = relatieStandaardGroepBasis.getDatumEinde();
        landAanvang = relatieStandaardGroepBasis.getLandAanvang();
        landEinde = relatieStandaardGroepBasis.getLandEinde();
        gemeenteAanvang = relatieStandaardGroepBasis.getGemeenteAanvang();
        gemeenteEinde = relatieStandaardGroepBasis.getGemeenteEinde();
        redenBeeindigingRelatie = relatieStandaardGroepBasis.getRedenBeeindigingRelatie();
        omschrijvingLocatieAanvang = relatieStandaardGroepBasis.getOmschrijvingLocatieAanvang();
        omschrijvingLocatieEinde = relatieStandaardGroepBasis.getOmschrijvingLocatieEinde();
        woonPlaatsAanvang = relatieStandaardGroepBasis.getWoonPlaatsAanvang();
        woonPlaatsEinde = relatieStandaardGroepBasis.getWoonPlaatsEinde();
        buitenlandsePlaatsAanvang = relatieStandaardGroepBasis.getBuitenlandsePlaatsAanvang();
        buitenlandsePlaatsEinde = relatieStandaardGroepBasis.getBuitenlandsePlaatsEinde();
        buitenlandseRegioAanvang = relatieStandaardGroepBasis.getBuitenlandseRegioAanvang();
        buitenlandseRegioEinde = relatieStandaardGroepBasis.getBuitenlandseRegioEinde();
    }

    @Override
    public Datum getDatumAanvang() {
        return datumAanvang;
    }

    @Override
    public Datum getDatumEinde() {
        return datumEinde;
    }

    @Override
    public Land getLandAanvang() {
        return landAanvang;
    }

    @Override
    public Land getLandEinde() {
        return landEinde;
    }

    @Override
    public Partij getGemeenteAanvang() {
        return gemeenteAanvang;
    }

    @Override
    public Partij getGemeenteEinde() {
        return gemeenteEinde;
    }

    @Override
    public RedenBeeindigingRelatie getRedenBeeindigingRelatie() {
        return redenBeeindigingRelatie;
    }

    @Override
    public Omschrijving getOmschrijvingLocatieAanvang() {
        return omschrijvingLocatieAanvang;
    }

    @Override
    public Omschrijving getOmschrijvingLocatieEinde() {
        return omschrijvingLocatieEinde;
    }

    @Override
    public Plaats getWoonPlaatsAanvang() {
        return woonPlaatsAanvang;
    }

    @Override
    public Plaats getWoonPlaatsEinde() {
        return woonPlaatsEinde;
    }

    @Override
    public BuitenlandsePlaats getBuitenlandsePlaatsAanvang() {
        return buitenlandsePlaatsAanvang;
    }

    @Override
    public BuitenlandsePlaats getBuitenlandsePlaatsEinde() {
        return buitenlandsePlaatsEinde;
    }

    @Override
    public BuitenlandseRegio getBuitenlandseRegioAanvang() {
        return buitenlandseRegioAanvang;
    }

    @Override
    public BuitenlandseRegio getBuitenlandseRegioEinde() {
        return buitenlandseRegioEinde;
    }

    // Setters zijn aangemaakt voor Jibx.

    protected void setDatumAanvang(final Datum datumAanvang) {
        this.datumAanvang = datumAanvang;
    }

    protected void setDatumEinde(final Datum datumEinde) {
        this.datumEinde = datumEinde;
    }

    protected void setLandAanvang(final Land landAanvang) {
        this.landAanvang = landAanvang;
    }

    protected void setLandEinde(final Land landEinde) {
        this.landEinde = landEinde;
    }

    protected void setGemeenteAanvang(final Partij gemeenteAanvang) {
        this.gemeenteAanvang = gemeenteAanvang;
    }

    protected void setGemeenteEinde(final Partij gemeenteEinde) {
        this.gemeenteEinde = gemeenteEinde;
    }

    protected void setRedenBeeindigingRelatie(final RedenBeeindigingRelatie redenBeeindigingRelatie) {
        this.redenBeeindigingRelatie = redenBeeindigingRelatie;
    }

    protected void setOmschrijvingLocatieAanvang(final Omschrijving omschrijvingLocatieAanvang) {
        this.omschrijvingLocatieAanvang = omschrijvingLocatieAanvang;
    }

    protected void setOmschrijvingLocatieEinde(final Omschrijving omschrijvingLocatieEinde) {
        this.omschrijvingLocatieEinde = omschrijvingLocatieEinde;
    }

    protected void setWoonPlaatsAanvang(final Plaats woonPlaatsAanvang) {
        this.woonPlaatsAanvang = woonPlaatsAanvang;
    }

    protected void setWoonPlaatsEinde(final Plaats woonPlaatsEinde) {
        this.woonPlaatsEinde = woonPlaatsEinde;
    }

    protected void setBuitenlandsePlaatsAanvang(final BuitenlandsePlaats buitenlandsePlaatsAanvang) {
        this.buitenlandsePlaatsAanvang = buitenlandsePlaatsAanvang;
    }

    protected void setBuitenlandsePlaatsEinde(final BuitenlandsePlaats buitenlandsePlaatsEinde) {
        this.buitenlandsePlaatsEinde = buitenlandsePlaatsEinde;
    }

    protected void setBuitenlandseRegioAanvang(final BuitenlandseRegio buitenlandseRegioAanvang) {
        this.buitenlandseRegioAanvang = buitenlandseRegioAanvang;
    }

    protected void setBuitenlandseRegioEinde(final BuitenlandseRegio buitenlandseRegioEinde) {
        this.buitenlandseRegioEinde = buitenlandseRegioEinde;
    }
}
