/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.business.regels.impl.gegevenset.definitieregels;

import java.util.List;
import nl.bzk.brp.model.algemeen.attribuuttype.kern.DatumAttribuut;
import nl.bzk.brp.model.algemeen.attribuuttype.kern.DatumEvtDeelsOnbekendAttribuut;
import nl.bzk.brp.model.algemeen.attribuuttype.kern.DatumTijdAttribuut;
import nl.bzk.brp.model.algemeen.attribuuttype.kern.NaamEnumeratiewaardeAttribuut;
import nl.bzk.brp.model.algemeen.attribuuttype.kern.NationaliteitcodeAttribuut;
import nl.bzk.brp.model.algemeen.attribuuttype.kern.RedenEindeRelatieCodeAttribuut;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.Geslachtsaanduiding;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.Nationaliteit;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.RedenEindeRelatieAttribuut;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.SoortActie;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.SoortActieAttribuut;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.SoortAdministratieveHandeling;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.SoortAdministratieveHandelingAttribuut;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.SoortPersoon;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.SoortPersoonAttribuut;
import nl.bzk.brp.model.algemeen.stamgegeven.kern.SoortRelatie;
import nl.bzk.brp.model.bericht.kern.RelatieStandaardGroepBericht;
import nl.bzk.brp.model.hisvolledig.impl.kern.FamilierechtelijkeBetrekkingHisVolledigImpl;
import nl.bzk.brp.model.hisvolledig.impl.kern.HuwelijkGeregistreerdPartnerschapHisVolledigImpl;
import nl.bzk.brp.model.hisvolledig.impl.kern.KindHisVolledigImpl;
import nl.bzk.brp.model.hisvolledig.impl.kern.PartnerHisVolledigImpl;
import nl.bzk.brp.model.hisvolledig.impl.kern.PersoonHisVolledigImpl;
import nl.bzk.brp.model.hisvolledig.impl.kern.PersoonNationaliteitHisVolledigImpl;
import nl.bzk.brp.model.hisvolledig.momentview.kern.PersoonView;
import nl.bzk.brp.model.operationeel.kern.ActieModel;
import nl.bzk.brp.model.operationeel.kern.AdministratieveHandelingModel;
import nl.bzk.brp.model.operationeel.kern.HisRelatieModel;
import nl.bzk.brp.util.StatischeObjecttypeBuilder;
import nl.bzk.brp.util.hisvolledig.kern.FamilierechtelijkeBetrekkingHisVolledigImplBuilder;
import nl.bzk.brp.util.hisvolledig.kern.GeregistreerdPartnerschapHisVolledigImplBuilder;
import nl.bzk.brp.util.hisvolledig.kern.HuwelijkHisVolledigImplBuilder;
import nl.bzk.brp.util.hisvolledig.kern.PartnerHisVolledigImplBuilder;
import nl.bzk.brp.util.hisvolledig.kern.PersoonHisVolledigImplBuilder;
import nl.bzk.brp.util.hisvolledig.kern.PersoonNationaliteitHisVolledigImplBuilder;
import org.junit.Assert;
import org.junit.Test;


public class BRBY0002Test {

    private final BRBY0002 brby0002 = new BRBY0002();

    @Test
    public final void testVraagOpKandidaatVaderNietGevonden() {
        final List<Integer> kandidaten =
                brby0002.bepaalKandidatenVader(
                        new PersoonView(new PersoonHisVolledigImpl(
                                new SoortPersoonAttribuut(SoortPersoon.INGESCHREVENE))),
                        new DatumEvtDeelsOnbekendAttribuut(20120101));

        Assert.assertEquals(0, kandidaten.size());
    }

    @Test
    public final void testVraagOpKandidaatVaderZonderOverledenVaderNietNL() {
        final PersoonView moeder = bouwMoeder(20101231, null, "2", Geslachtsaanduiding.MAN);

        final List<Integer> kandidaten = brby0002.bepaalKandidatenVader(moeder,
                                                                        new DatumEvtDeelsOnbekendAttribuut(20120101));

        Assert.assertEquals(1, kandidaten.size());
    }

    @Test
    public final void testVraagOpKandidaatVaderZonderOverledenVaderKindGeborenBuitenPeriodeHuwelijk() {
        final PersoonView moeder = bouwMoeder(20101231, null, "2", Geslachtsaanduiding.MAN);

        final List<Integer> kandidaten = brby0002.bepaalKandidatenVader(moeder,
                                                                        new DatumEvtDeelsOnbekendAttribuut(20090101));

        Assert.assertEquals(0, kandidaten.size());
    }

    @Test
    public final void testVraagOpKandidaatVaderMetOverledenVaderNietNL() {
        final PersoonView moeder = bouwMoeder(20101231, 20110101, "2", Geslachtsaanduiding.MAN);

        final List<Integer> kandidaten = brby0002.bepaalKandidatenVader(moeder,
                                                                        new DatumEvtDeelsOnbekendAttribuut(20120101));

        Assert.assertEquals(1, kandidaten.size());
    }


    @Test
    public final void testVraagOpKandidaatVaderMetOverledenVaderNietNLBuitenPeriode() {
        final PersoonView moeder = bouwMoeder(20101231, 20101231, "2", Geslachtsaanduiding.MAN);

        final List<Integer> kandidaten =
                brby0002.bepaalKandidatenVader(moeder,
                                               new DatumEvtDeelsOnbekendAttribuut(20120101));

        Assert.assertEquals(0, kandidaten.size());
    }

    @Test
    public final void testVraagOpKandidaatVaderMetOverledenVaderNL() {
        final PersoonView moeder = bouwMoeder(20101231, 20110301, NationaliteitcodeAttribuut.NL_NATIONALITEIT_CODE_STRING,
                                              Geslachtsaanduiding.MAN);

        final List<Integer> kandidaten = brby0002.bepaalKandidatenVader(moeder,
                                                                        new DatumEvtDeelsOnbekendAttribuut(20120101));

        Assert.assertEquals(1, kandidaten.size());
    }

    @Test
    public final void testVraagOpKandidaatVaderMetOverledenVaderNLMaarGeslachtIsVrouw() {
        final PersoonView moeder = bouwMoeder(20101231, 20110301, NationaliteitcodeAttribuut.NL_NATIONALITEIT_CODE_STRING,
                                              Geslachtsaanduiding.VROUW);

        final List<Integer> kandidaten = brby0002.bepaalKandidatenVader(moeder,
                                                                        new DatumEvtDeelsOnbekendAttribuut(20120101));

        Assert.assertEquals(0, kandidaten.size());
    }

    @Test
    public final void testVraagOpKandidaatVaderMetOverledenVaderNLBuitenPeriode() {
        final PersoonView moeder = bouwMoeder(20101231, 20110228, NationaliteitcodeAttribuut.NL_NATIONALITEIT_CODE_STRING,
                                              Geslachtsaanduiding.MAN);

        final List<Integer> kandidaten = brby0002.bepaalKandidatenVader(moeder,
                                                                        new DatumEvtDeelsOnbekendAttribuut(20120101));

        Assert.assertEquals(0, kandidaten.size());
    }

    @Test
    public final void testVraagOpKandidaatVaderMetHuwelijkNaGeboorte() {
        final PersoonView moeder =
                bouwMoeder(20101231, 20110228, NationaliteitcodeAttribuut.NL_NATIONALITEIT_CODE_STRING, Geslachtsaanduiding.MAN);

        final List<Integer> kandidaten = brby0002.bepaalKandidatenVader(moeder,
                                                                        new DatumEvtDeelsOnbekendAttribuut(20100101));

        Assert.assertEquals(0, kandidaten.size());
    }

    @Test
    public final void testVraagOpKandidaatVaderMetHuwelijkNaGeboorteEnVoorGeboorte() {
        final PersoonView moeder =
                bouwMoeder(20050505, 20111111, NationaliteitcodeAttribuut.NL_NATIONALITEIT_CODE_STRING, Geslachtsaanduiding.MAN);

        final List<Integer> kandidaten = brby0002.bepaalKandidatenVader(moeder,
                                                                        new DatumEvtDeelsOnbekendAttribuut(20110505));

        Assert.assertEquals(1, kandidaten.size());
    }

    @Test
    public final void testVraagOpKandidaatVaderMoederHeeftGeregistreerdPartnerschap() {
        final PersoonHisVolledigImpl moeder = new PersoonHisVolledigImplBuilder(SoortPersoon.INGESCHREVENE)
                .nieuwGeslachtsaanduidingRecord(19800101, null, 19800101).geslachtsaanduiding(
                        Geslachtsaanduiding.VROUW).eindeRecord().build();

        final PersoonHisVolledigImpl vader = bouwVader(NationaliteitcodeAttribuut.NL_NATIONALITEIT_CODE_STRING,
                                                       Geslachtsaanduiding.MAN);
        bouwHuwelijkGeregistreerdPartnerschap(SoortRelatie.GEREGISTREERD_PARTNERSCHAP, 20101231, 20110101,
                                              moeder, vader,
                                              RedenEindeRelatieCodeAttribuut.REDEN_EINDE_RELATIE_OVERLIJDEN_CODE_STRING);

        final List<Integer> kandidaten =
                brby0002.bepaalKandidatenVader(new PersoonView(moeder), new DatumEvtDeelsOnbekendAttribuut(20110505));

        Assert.assertEquals(0, kandidaten.size());
    }

    @Test
    public final void testVraagOpKandidaatVaderRedenGeenOverlijden() {
        final PersoonHisVolledigImpl moeder = new PersoonHisVolledigImplBuilder(SoortPersoon.INGESCHREVENE)
                .nieuwGeslachtsaanduidingRecord(19800101, null, 19800101).geslachtsaanduiding(
                        Geslachtsaanduiding.VROUW).eindeRecord().build();

        final PersoonHisVolledigImpl vader = bouwVader(NationaliteitcodeAttribuut.NL_NATIONALITEIT_CODE_STRING,
                Geslachtsaanduiding.MAN);
        bouwHuwelijkGeregistreerdPartnerschap(SoortRelatie.HUWELIJK, 20101231, 20110101,
                moeder, vader, RedenEindeRelatieCodeAttribuut.REDEN_EINDE_RELATIE_ECHTSCHEIDING_CODE_STRING);

        final List<Integer> kandidaten =
                brby0002.bepaalKandidatenVader(new PersoonView(moeder), new DatumEvtDeelsOnbekendAttribuut(20110505));

        Assert.assertEquals(0, kandidaten.size());
    }

    private PersoonView bouwMoeder(final Integer huwelijkDatumAanvang1, final Integer overlijdingsDatum1,
                                              final String nationaliteitCodeVader1,
                                              final Geslachtsaanduiding geslachtsaanduiding)
    {
        final PersoonHisVolledigImpl vader = bouwVader(nationaliteitCodeVader1, geslachtsaanduiding);

        final PersoonHisVolledigImpl moeder = new PersoonHisVolledigImplBuilder(SoortPersoon.INGESCHREVENE)
                .nieuwGeslachtsaanduidingRecord(19800101, null, 19800101).geslachtsaanduiding(
                        Geslachtsaanduiding.VROUW).eindeRecord().build();

        bouwHuwelijkGeregistreerdPartnerschap(SoortRelatie.HUWELIJK,
                                              huwelijkDatumAanvang1, overlijdingsDatum1, moeder, vader,
                                              RedenEindeRelatieCodeAttribuut.REDEN_EINDE_RELATIE_OVERLIJDEN_CODE_STRING);

        voegKindBetrokkenheidToe(moeder);

        return new PersoonView(moeder);
    }

    private void voegKindBetrokkenheidToe(final PersoonHisVolledigImpl moeder) {
        final FamilierechtelijkeBetrekkingHisVolledigImpl fam =
                new FamilierechtelijkeBetrekkingHisVolledigImplBuilder().build();
        moeder.getBetrokkenheden().add(new KindHisVolledigImpl(fam, moeder));
    }

    private PersoonHisVolledigImpl bouwVader(final String nationaliteitCodeVader, final Geslachtsaanduiding geslacht) {
        final PersoonHisVolledigImpl vader =
                new PersoonHisVolledigImplBuilder(SoortPersoon.INGESCHREVENE)
                        .nieuwGeslachtsaanduidingRecord(19800101, null, 19800101).geslachtsaanduiding(
                        geslacht).eindeRecord().build();

        final Nationaliteit nationaliteitWillekeurig = new Nationaliteit(
                new NationaliteitcodeAttribuut(Short.valueOf(nationaliteitCodeVader)),
                new NaamEnumeratiewaardeAttribuut("nationaliteit"),
                new DatumEvtDeelsOnbekendAttribuut(19601231),
                null);
        final PersoonNationaliteitHisVolledigImpl nationaliteit = new PersoonNationaliteitHisVolledigImplBuilder(vader,
                nationaliteitWillekeurig)
                .nieuwStandaardRecord(DatumAttribuut.vandaag().getWaarde(), null, DatumAttribuut.vandaag().getWaarde())
                .eindeRecord().build();

        vader.getNationaliteiten().add(nationaliteit);

        return vader;
    }

    private void bouwHuwelijkGeregistreerdPartnerschap(final SoortRelatie soortRelatie,
                                                       final Integer huwelijkDatumAanvang,
                                                       final Integer overlijdingsDatum,
                                                       final PersoonHisVolledigImpl moeder,
                                                       final PersoonHisVolledigImpl vader,
                                                       final String redenEinde)
    {
        HuwelijkGeregistreerdPartnerschapHisVolledigImpl relatie;

        if (SoortRelatie.HUWELIJK == soortRelatie) {
            relatie = new HuwelijkHisVolledigImplBuilder().build();
        } else if (SoortRelatie.GEREGISTREERD_PARTNERSCHAP == soortRelatie) {
            relatie = new GeregistreerdPartnerschapHisVolledigImplBuilder().build();
        } else {
            throw new IllegalArgumentException("Soort relatie moet huwelijk of GP zijn.");
        }

        final RelatieStandaardGroepBericht standaard = new RelatieStandaardGroepBericht();
        standaard.setDatumAanvang(new DatumEvtDeelsOnbekendAttribuut(huwelijkDatumAanvang));
        if (overlijdingsDatum != null) {
            standaard.setDatumEinde(new DatumEvtDeelsOnbekendAttribuut(overlijdingsDatum));
            final RedenEindeRelatieAttribuut redenEindeRelatie = StatischeObjecttypeBuilder.bouwRedenEindeRelatie(
                    redenEinde, "omschrijving reden.");

            standaard.setRedenEinde(redenEindeRelatie);
        }

        final HisRelatieModel hisRelatieModel = new HisRelatieModel(relatie, standaard, maakActieHuwelijk(20101231, soortRelatie));

        relatie.getRelatieHistorie().voegToe(hisRelatieModel);

        final PartnerHisVolledigImpl partnerVrouw = new PartnerHisVolledigImplBuilder(relatie, moeder).build();
        final PartnerHisVolledigImpl partnerMan = new PartnerHisVolledigImplBuilder(relatie, vader).build();

        relatie.getBetrokkenheden().add(partnerVrouw);
        relatie.getBetrokkenheden().add(partnerMan);

        moeder.getBetrokkenheden().add(partnerVrouw);
    }


    /**
     * Creeert een standaard actie voor registratie geboorte.
     *
     * @return het actie model
     */
    private ActieModel maakActieHuwelijk(final Integer datumAanvang, final SoortRelatie soortRelatie) {

        final SoortAdministratieveHandeling soortAdministratieveHandeling;
        switch (soortRelatie) {
            case HUWELIJK:
                soortAdministratieveHandeling = SoortAdministratieveHandeling.VOLTREKKING_HUWELIJK_IN_NEDERLAND;
                break;
            case GEREGISTREERD_PARTNERSCHAP:
                soortAdministratieveHandeling = SoortAdministratieveHandeling.AANGAAN_GEREGISTREERD_PARTNERSCHAP_IN_NEDERLAND;
                break;
            default:
                soortAdministratieveHandeling = SoortAdministratieveHandeling.VOLTREKKING_HUWELIJK_IN_NEDERLAND;
                break;
        }

        return new ActieModel(new SoortActieAttribuut(SoortActie.REGISTRATIE_HUWELIJK_GEREGISTREERD_PARTNERSCHAP),
                new AdministratieveHandelingModel(
                        new SoortAdministratieveHandelingAttribuut(soortAdministratieveHandeling), null, null, null),
                null, new DatumEvtDeelsOnbekendAttribuut(datumAanvang), null, DatumTijdAttribuut.nu(), null);
    }
}
