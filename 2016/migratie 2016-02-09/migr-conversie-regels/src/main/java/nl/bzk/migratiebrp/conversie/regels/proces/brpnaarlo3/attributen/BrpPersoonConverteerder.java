/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.migratiebrp.conversie.regels.proces.brpnaarlo3.attributen;

import javax.inject.Inject;
import nl.bzk.migratiebrp.conversie.model.Requirement;
import nl.bzk.migratiebrp.conversie.model.Requirements;
import nl.bzk.migratiebrp.conversie.model.brp.attribuut.BrpGemeenteCode;
import nl.bzk.migratiebrp.conversie.model.brp.attribuut.BrpLandOfGebiedCode;
import nl.bzk.migratiebrp.conversie.model.brp.attribuut.BrpString;
import nl.bzk.migratiebrp.conversie.model.brp.groep.BrpGeboorteInhoud;
import nl.bzk.migratiebrp.conversie.model.brp.groep.BrpGeslachtsaanduidingInhoud;
import nl.bzk.migratiebrp.conversie.model.brp.groep.BrpGroepInhoud;
import nl.bzk.migratiebrp.conversie.model.brp.groep.BrpIdentificatienummersInhoud;
import nl.bzk.migratiebrp.conversie.model.brp.groep.BrpNaamgebruikInhoud;
import nl.bzk.migratiebrp.conversie.model.brp.groep.BrpNummerverwijzingInhoud;
import nl.bzk.migratiebrp.conversie.model.brp.groep.BrpSamengesteldeNaamInhoud;
import nl.bzk.migratiebrp.conversie.model.lo3.categorie.Lo3PersoonInhoud;
import nl.bzk.migratiebrp.conversie.regels.proces.brpnaarlo3.attributen.BrpAttribuutConverteerder.Lo3GemeenteLand;
import nl.bzk.migratiebrp.util.common.logging.Logger;
import nl.bzk.migratiebrp.util.common.logging.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Persoon converteerder.
 */
@Component
public final class BrpPersoonConverteerder extends AbstractBrpCategorieConverteerder<Lo3PersoonInhoud> {
    private static final Logger LOG = LoggerFactory.getLogger();

    @Inject
    private GeboorteConverteerder geboorteConverteerder;
    @Inject
    private NaamgebruikConverteerder naamgebruikConverteerder;
    @Inject
    private SamengesteldeNaamConverteerder samengesteldeNaamConverteerder;
    @Inject
    private IdentificatienumersConverteerder identificatienumersConverteerder;
    @Inject
    private GeslachtsaanduidingConverteerder geslachtsaanduidingConverteerder;
    @Inject
    private NummerverwijzingConverteerder nummerverwijzingConverteerder;

    /*
     * (non-Javadoc)
     * 
     * @see
     * nl.bzk.migratiebrp.conversie.regels.proces.brpnaarlo3.attributen.AbstractBrpCategorieConverteerder#getLogger()
     */
    @Override
    protected Logger getLogger() {
        return LOG;
    }

    @Override
    protected <T extends BrpGroepInhoud> BrpGroepConverteerder<T, Lo3PersoonInhoud> bepaalConverteerder(final T inhoud) {
        final BrpGroepConverteerder<T, Lo3PersoonInhoud> result;
        if (inhoud instanceof BrpGeboorteInhoud) {
            result = (BrpGroepConverteerder<T, Lo3PersoonInhoud>) geboorteConverteerder;
        } else if (inhoud instanceof BrpNaamgebruikInhoud) {
            result = (BrpGroepConverteerder<T, Lo3PersoonInhoud>) naamgebruikConverteerder;
        } else if (inhoud instanceof BrpSamengesteldeNaamInhoud) {
            result = (BrpGroepConverteerder<T, Lo3PersoonInhoud>) samengesteldeNaamConverteerder;
        } else if (inhoud instanceof BrpIdentificatienummersInhoud) {
            result = (BrpGroepConverteerder<T, Lo3PersoonInhoud>) identificatienumersConverteerder;
        } else if (inhoud instanceof BrpGeslachtsaanduidingInhoud) {
            result = (BrpGroepConverteerder<T, Lo3PersoonInhoud>) geslachtsaanduidingConverteerder;
        } else if (inhoud instanceof BrpNummerverwijzingInhoud) {
            result = (BrpGroepConverteerder<T, Lo3PersoonInhoud>) nummerverwijzingConverteerder;
        } else {
            throw new IllegalArgumentException("BrpPersoonConverteerder bevat geen Groep converteerder voor: " + inhoud);
        }

        return result;
    }

    /**
     * Converteerder die weet hoe een Lo3PersoonInhoud rij gemaakt moet worden.
     *
     * @param <T>
     *            brp groep inhoud type
     */
    public abstract static class AbstractPersoonConverteerder<T extends BrpGroepInhoud> extends BrpGroepConverteerder<T, Lo3PersoonInhoud> {

        @Override
        public final Lo3PersoonInhoud maakNieuweInhoud() {
            return new Lo3PersoonInhoud(null, null, null, null, null, null, null, null, null, null, null, null, null);
        }
    }

    /**
     * Converteerder die weet hoe een BrpGeboorteInhoud omgezet moeten worden naar Lo3PersoonInhoud.
     */
    @Component
    @Requirement({Requirements.CAP001, Requirements.CAP001_BL01, Requirements.CAP001_BL02 })
    public static final class GeboorteConverteerder extends AbstractPersoonConverteerder<BrpGeboorteInhoud> {
        private static final Logger LOG = LoggerFactory.getLogger();

        @Inject
        private BrpAttribuutConverteerder converteerder;

        /*
         * (non-Javadoc)
         * 
         * @see nl.bzk.migratiebrp.conversie.regels.proces.brpnaarlo3.attributen.BrpGroepConverteerder#getLogger()
         */
        @Override
        protected Logger getLogger() {
            return LOG;
        }

        @Override
        public Lo3PersoonInhoud vulInhoud(final Lo3PersoonInhoud lo3Inhoud, final BrpGeboorteInhoud brpInhoud, final BrpGeboorteInhoud brpVorigeInhoud) {
            final Lo3PersoonInhoud.Builder builder = new Lo3PersoonInhoud.Builder(lo3Inhoud);

            if (brpInhoud == null) {
                builder.setGeboortedatum(null);
                builder.setGeboorteGemeenteCode(null);
                builder.setGeboorteLandCode(null);
            } else {
                final BrpGemeenteCode gemeenteCode = brpInhoud.getGemeenteCode();
                final BrpString buitenlandsePlaatsGeboorte = brpInhoud.getBuitenlandsePlaatsGeboorte();
                final BrpString buitenlandseRegioGeboorte = brpInhoud.getBuitenlandseRegioGeboorte();
                final BrpLandOfGebiedCode landCode = brpInhoud.getLandOfGebiedCode();
                final BrpString omschrijvingGeboortelocatie = brpInhoud.getOmschrijvingGeboortelocatie();

                final Lo3GemeenteLand locatie =
                        converteerder.converteerLocatie(
                            gemeenteCode,
                            buitenlandsePlaatsGeboorte,
                            buitenlandseRegioGeboorte,
                            landCode,
                            omschrijvingGeboortelocatie);

                builder.setGeboortedatum(converteerder.converteerDatum(brpInhoud.getGeboortedatum()));
                builder.setGeboorteGemeenteCode(locatie.getGemeenteCode());
                builder.setGeboorteLandCode(locatie.getLandCode());
            }
            return builder.build();
        }
    }

    /**
     * Converteerder die weet hoe een BrpNaamgebruikInhoud omgezet moeten worden naar Lo3PersoonInhoud.
     */
    @Component
    public static final class NaamgebruikConverteerder extends AbstractPersoonConverteerder<BrpNaamgebruikInhoud> {
        private static final Logger LOG = LoggerFactory.getLogger();

        @Inject
        private BrpAttribuutConverteerder converteerder;

        /*
         * (non-Javadoc)
         * 
         * @see nl.bzk.migratiebrp.conversie.regels.proces.brpnaarlo3.attributen.BrpGroepConverteerder#getLogger()
         */
        @Override
        protected Logger getLogger() {
            return LOG;
        }

        @Override
        public Lo3PersoonInhoud vulInhoud(
            final Lo3PersoonInhoud lo3Inhoud,
            final BrpNaamgebruikInhoud brpInhoud,
            final BrpNaamgebruikInhoud brpVorigeInhoud)
        {
            final Lo3PersoonInhoud.Builder builder = new Lo3PersoonInhoud.Builder(lo3Inhoud);

            if (brpInhoud == null) {
                builder.setAanduidingNaamgebruikCode(null);
            } else {
                builder.setAanduidingNaamgebruikCode(converteerder.converteerAanduidingNaamgebruik(brpInhoud.getNaamgebruikCode()));
            }
            return builder.build();
        }

    }

    /**
     * Converteerder die weet hoe een BrpSamengesteldeNaamInhoud omgezet moeten worden naar Lo3PersoonInhoud.
     */
    @Component
    @Requirement({Requirements.CEL0210_BL01, Requirements.CEL0240, Requirements.CEL0240_BL01 })
    public static final class SamengesteldeNaamConverteerder extends AbstractPersoonConverteerder<BrpSamengesteldeNaamInhoud> {
        private static final Logger LOG = LoggerFactory.getLogger();

        @Inject
        private BrpAttribuutConverteerder converteerder;

        /*
         * (non-Javadoc)
         * 
         * @see nl.bzk.migratiebrp.conversie.regels.proces.brpnaarlo3.attributen.BrpGroepConverteerder#getLogger()
         */
        @Override
        protected Logger getLogger() {
            return LOG;
        }

        @Override
        public Lo3PersoonInhoud vulInhoud(
            final Lo3PersoonInhoud lo3Inhoud,
            final BrpSamengesteldeNaamInhoud brpInhoud,
            final BrpSamengesteldeNaamInhoud brpVorigeInhoud)
        {
            final Lo3PersoonInhoud.Builder builder = new Lo3PersoonInhoud.Builder(lo3Inhoud);

            if (brpInhoud == null) {
                builder.setAdellijkeTitelPredikaatCode(null);
                builder.setVoornamen(null);
                builder.setVoorvoegselGeslachtsnaam(null);
                builder.setGeslachtsnaam(null);
            } else {
                builder.setAdellijkeTitelPredikaatCode(converteerder.converteerAdellijkeTitelPredikaatCode(
                    brpInhoud.getAdellijkeTitelCode(),
                    brpInhoud.getPredicaatCode()));
                builder.setVoornamen(converteerder.converteerString(brpInhoud.getVoornamen()));
                builder.setVoorvoegselGeslachtsnaam(converteerder.converteerVoorvoegsel(brpInhoud.getVoorvoegsel(), brpInhoud.getScheidingsteken()));
                builder.setGeslachtsnaam(converteerder.converteerString(brpInhoud.getGeslachtsnaamstam()));
            }
            return builder.build();
        }
    }

    /**
     * Converteerder die weet hoe een BrpIdentificatienummersInhoud omgezet moeten worden naar Lo3PersoonInhoud.
     */
    @Component
    @Requirement({Requirements.CGR01, Requirements.CGR01_BL01 })
    public static final class IdentificatienumersConverteerder extends AbstractPersoonConverteerder<BrpIdentificatienummersInhoud> {
        private static final Logger LOG = LoggerFactory.getLogger();

        @Inject
        private BrpAttribuutConverteerder converteerder;

        /*
         * (non-Javadoc)
         * 
         * @see nl.bzk.migratiebrp.conversie.regels.proces.brpnaarlo3.attributen.BrpGroepConverteerder#getLogger()
         */
        @Override
        protected Logger getLogger() {
            return LOG;
        }

        @Override
        public Lo3PersoonInhoud vulInhoud(
            final Lo3PersoonInhoud lo3Inhoud,
            final BrpIdentificatienummersInhoud brpInhoud,
            final BrpIdentificatienummersInhoud brpVorigeInhoud)
        {
            final Lo3PersoonInhoud.Builder builder = new Lo3PersoonInhoud.Builder(lo3Inhoud);

            if (brpInhoud == null) {
                builder.setaNummer(null);
                builder.setBurgerservicenummer(null);
            } else {
                builder.setaNummer(converteerder.converteerAdministratieNummer(brpInhoud.getAdministratienummer()));
                builder.setBurgerservicenummer(converteerder.converteerBurgerservicenummer(brpInhoud.getBurgerservicenummer()));
            }
            return builder.build();
        }

    }

    /**
     * Converteerder die weet hoe een BrpGeslachtsaanduidingInhoud omgezet moeten worden naar Lo3PersoonInhoud.
     */
    @Component
    public static final class GeslachtsaanduidingConverteerder extends AbstractPersoonConverteerder<BrpGeslachtsaanduidingInhoud> {
        private static final Logger LOG = LoggerFactory.getLogger();

        @Inject
        private BrpAttribuutConverteerder converteerder;

        /*
         * (non-Javadoc)
         * 
         * @see nl.bzk.migratiebrp.conversie.regels.proces.brpnaarlo3.attributen.BrpGroepConverteerder#getLogger()
         */
        @Override
        protected Logger getLogger() {
            return LOG;
        }

        @Override
        public Lo3PersoonInhoud vulInhoud(
            final Lo3PersoonInhoud lo3Inhoud,
            final BrpGeslachtsaanduidingInhoud brpInhoud,
            final BrpGeslachtsaanduidingInhoud brpVorigeInhoud)
        {
            final Lo3PersoonInhoud.Builder builder = new Lo3PersoonInhoud.Builder(lo3Inhoud);

            if (brpInhoud == null) {
                builder.setGeslachtsaanduiding(null);
            } else {
                builder.setGeslachtsaanduiding(converteerder.converteerGeslachtsaanduiding(brpInhoud.getGeslachtsaanduidingCode()));
            }
            return builder.build();
        }

    }

    /**
     * Converteerder die weet hoe een BrpNummerverwijzingInhoud omgezet moeten worden naar Lo3PersoonInhoud.
     */
    @Component
    public static final class NummerverwijzingConverteerder extends AbstractPersoonConverteerder<BrpNummerverwijzingInhoud> {
        private static final Logger LOG = LoggerFactory.getLogger();

        @Inject
        private BrpAttribuutConverteerder converteerder;

        /*
         * (non-Javadoc)
         * 
         * @see nl.bzk.migratiebrp.conversie.regels.proces.brpnaarlo3.attributen.BrpGroepConverteerder#getLogger()
         */
        @Override
        protected Logger getLogger() {
            return LOG;
        }

        @Override
        public Lo3PersoonInhoud vulInhoud(
            final Lo3PersoonInhoud lo3Inhoud,
            final BrpNummerverwijzingInhoud brpInhoud,
            final BrpNummerverwijzingInhoud brpVorigeInhoud)
        {
            final Lo3PersoonInhoud.Builder builder = new Lo3PersoonInhoud.Builder(lo3Inhoud);

            if (brpInhoud == null) {
                builder.setVolgendANummer(null);
                builder.setVorigANummer(null);
            } else {
                builder.setVolgendANummer(converteerder.converteerAdministratieNummer(brpInhoud.getVolgendeAdministratienummer()));
                builder.setVorigANummer(converteerder.converteerAdministratieNummer(brpInhoud.getVorigeAdministratienummer()));
            }
            return builder.build();
        }

    }

}
