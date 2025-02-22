/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.model.objecttype.operationeel.basis;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import nl.bzk.brp.model.basis.AbstractDynamischObjectType;
import nl.bzk.brp.model.groep.operationeel.actueel.BetrokkenheidOuderlijkGezagGroepModel;
import nl.bzk.brp.model.groep.operationeel.actueel.BetrokkenheidOuderschapGroepModel;
import nl.bzk.brp.model.objecttype.logisch.basis.BetrokkenheidBasis;
import nl.bzk.brp.model.objecttype.operationeel.PersoonModel;
import nl.bzk.brp.model.objecttype.operationeel.RelatieModel;
import nl.bzk.brp.model.objecttype.operationeel.statisch.SoortBetrokkenheid;
import nl.bzk.brp.model.objecttype.operationeel.statisch.StatusHistorie;

/**
 * Implementatie voor objecttype betrokkenheid.
 */
@MappedSuperclass
@Access(AccessType.FIELD)
@SuppressWarnings("serial")
public abstract class AbstractBetrokkenheidModel extends AbstractDynamischObjectType implements BetrokkenheidBasis {

    @Id
    @SequenceGenerator(name = "BETROKKENHEID", sequenceName = "Kern.seq_Betr")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BETROKKENHEID")
    private Long id;

    @Column(name = "rol")
    @NotNull
    private SoortBetrokkenheid rol;

    @ManyToOne
    @JoinColumn(name = "relatie")
    @NotNull
    private RelatieModel relatie;

    @OneToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
    @JoinColumn(name = "betrokkene")
    @NotNull
    private PersoonModel betrokkene;

    @Embedded
    private BetrokkenheidOuderlijkGezagGroepModel betrokkenheidOuderlijkGezag;

    @Embedded
    private BetrokkenheidOuderschapGroepModel betrokkenheidOuderschap;

    @Column(name = "OuderlijkgezagstatusHis")
    @Enumerated(value = EnumType.STRING)
    @NotNull
    private StatusHistorie ouderlijkGezagStatusHistorie;

    @Column(name = "OuderStatusHis")
    @Enumerated(value = EnumType.STRING)
    @NotNull
    private StatusHistorie ouderStatusHistorie;


    /**
     * Copy constructor. Om een model object te construeren uit een web object.
     *
     * @param betr Object type dat gekopieerd dient te worden.
     * @param pers Betrokkene
     * @param relatie Relatie
     */
    protected AbstractBetrokkenheidModel(final BetrokkenheidBasis betr, final PersoonModel pers,
        final RelatieModel relatie)
    {
        super(betr);
        rol = betr.getRol();
        initLegeStatusHistorie();
        if (betr.getBetrokkenheidOuderlijkGezag() != null) {
            betrokkenheidOuderlijkGezag = new BetrokkenheidOuderlijkGezagGroepModel(betr.getBetrokkenheidOuderlijkGezag());
            ouderlijkGezagStatusHistorie = StatusHistorie.A;
        }
        if (betr.getBetrokkenheidOuderschap() != null) {
            betrokkenheidOuderschap = new BetrokkenheidOuderschapGroepModel(betr.getBetrokkenheidOuderschap());
            ouderStatusHistorie = StatusHistorie.A;
        }
        betrokkene = pers;
        this.relatie = relatie;
    }

    /**
     * default cons.
     */
    protected AbstractBetrokkenheidModel() {
        initLegeStatusHistorie();
    }

    /**
     * initieer alle sttaushistories op waarde X.
     */
    private void initLegeStatusHistorie() {
        ouderlijkGezagStatusHistorie = StatusHistorie.X;
        ouderStatusHistorie = StatusHistorie.X;
    }

    public Long getId() {
        return id;
    }

    @Override
    public SoortBetrokkenheid getRol() {
        return rol;
    }

    @Override
    public RelatieModel getRelatie() {
        return relatie;
    }

    @Override
    public PersoonModel getBetrokkene() {
        return betrokkene;
    }

    @Override
    public BetrokkenheidOuderlijkGezagGroepModel getBetrokkenheidOuderlijkGezag() {
        return betrokkenheidOuderlijkGezag;
    }

    @Override
    public BetrokkenheidOuderschapGroepModel getBetrokkenheidOuderschap() {
        return betrokkenheidOuderschap;
    }

    protected void setRol(final SoortBetrokkenheid rol) {
        this.rol = rol;
    }

    protected void setRelatie(final RelatieModel relatie) {
        this.relatie = relatie;
    }

    protected void setBetrokkene(final PersoonModel betrokkene) {
        this.betrokkene = betrokkene;
    }

    protected void setBetrokkenheidOuderlijkGezag(final BetrokkenheidOuderlijkGezagGroepModel betrokkenheidOuderlijkGezag) {
        this.betrokkenheidOuderlijkGezag = betrokkenheidOuderlijkGezag;
    }

    protected void setBetrokkenheidOuderschap(final BetrokkenheidOuderschapGroepModel betrokkenheidOuderschap) {
        this.betrokkenheidOuderschap = betrokkenheidOuderschap;
    }

    public StatusHistorie getOuderlijkGezagStatusHistorie() {
        return ouderlijkGezagStatusHistorie;
    }

    public StatusHistorie getOuderStatusHistorie() {
        return ouderStatusHistorie;
    }
}
