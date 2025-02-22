/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.dataaccess.repository;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import junit.framework.Assert;
import nl.bzk.brp.dataaccess.AbstractRepositoryTestCase;
import nl.bzk.brp.dataaccess.exceptie.ObjectReedsBestaandExceptie;
import nl.bzk.brp.model.attribuuttype.Datum;
import nl.bzk.brp.model.attribuuttype.DatumTijd;
import nl.bzk.brp.model.attribuuttype.Nationaliteitcode;
import nl.bzk.brp.model.groep.bericht.PersoonNationaliteitStandaardGroepBericht;
import nl.bzk.brp.model.groep.operationeel.historisch.PersoonNationaliteitHisModel;
import nl.bzk.brp.model.objecttype.bericht.ActieBericht;
import nl.bzk.brp.model.objecttype.bericht.PersoonNationaliteitBericht;
import nl.bzk.brp.model.objecttype.operationeel.ActieModel;
import nl.bzk.brp.model.objecttype.operationeel.PersoonModel;
import nl.bzk.brp.model.objecttype.operationeel.PersoonNationaliteitModel;
import nl.bzk.brp.model.objecttype.operationeel.statisch.Partij;
import nl.bzk.brp.model.objecttype.operationeel.statisch.SoortActie;
import nl.bzk.brp.model.objecttype.operationeel.statisch.StatusHistorie;
import org.junit.Test;


public class PersoonNationaliteitRepositoryTest extends AbstractRepositoryTestCase {

    @Inject
    private ActieRepository actieRepository;

    @Inject
    private PersoonNationaliteitRepository persoonNationaliteitRepository;

    @Inject
    private ReferentieDataRepository referentieDataRepository;

    @PersistenceContext(unitName = "nl.bzk.brp")
    private EntityManager   em;


    private PersoonNationaliteitModel maakNationalRecord(final Short nationaliteitcode) {
        PersoonNationaliteitBericht persoonNationaliteitBericht = new PersoonNationaliteitBericht();
        persoonNationaliteitBericht.setNationaliteit(referentieDataRepository.vindNationaliteitOpCode(
                    new Nationaliteitcode(nationaliteitcode)));
        persoonNationaliteitBericht.setGegevens(new PersoonNationaliteitStandaardGroepBericht());
        return new PersoonNationaliteitModel(persoonNationaliteitBericht, null);
    }

    private ActieModel maakActie() {
        ActieBericht actieBericht = new ActieBericht();
        actieBericht.setTijdstipRegistratie(new DatumTijd(new Timestamp(System.currentTimeMillis() - 1)));
        actieBericht.setSoort(SoortActie.REGISTRATIE_NATIONALITEIT);
        actieBericht.setPartij(em.find(Partij.class, (short) 4));

        ActieModel actie = new ActieModel(actieBericht);


        return actieRepository.save(actie);
    }


    @Test
    public void testVoegNationaliteit() {
        final ActieModel actie = maakActie();
        final PersoonModel bestaandePersoon = em.find(PersoonModel.class, 2);
        Assert.assertNotNull(bestaandePersoon);

        TypedQuery<PersoonNationaliteitHisModel> query = em.createQuery(
                "SELECT hisNat FROM PersoonNationaliteitHisModel hisnat WHERE "
                + " hisnat.persoonNationaliteit.persoon.id = :id"
                + " ORDER by historie.datumAanvangGeldigheid", PersoonNationaliteitHisModel.class)
                .setParameter("id", bestaandePersoon.getId());

        // de begin status is dat de database WEL een A-Laag heeft, maar geen historie.
        List<PersoonNationaliteitHisModel> hisnats = query.getResultList();
        int beginAantalNatHistorie = hisnats.size();
        Assert.assertEquals(1, bestaandePersoon.getNationaliteiten().size());
        Assert.assertEquals(0, beginAantalNatHistorie);

        PersoonModel nieuwPersoon =  persoonNationaliteitRepository.voegNationaliteit(bestaandePersoon,
                maakNationalRecord((short) 339), actie,
                new Datum(20120216));
        Assert.assertNotNull(nieuwPersoon);
        Assert.assertEquals(2, nieuwPersoon.getNationaliteiten().size());

        // check hoeveel in de historie staan, verwachting is 1, was geen historie, heeft nu 1 his (bij de nieuwe nat).
        hisnats = query.getResultList();
        Assert.assertEquals(beginAantalNatHistorie + 1, hisnats.size());

        // registreer nu een derde Nationaliteit
        nieuwPersoon =  persoonNationaliteitRepository.voegNationaliteit(bestaandePersoon,
                maakNationalRecord((short) 27), actie,
                new Datum(20120416));

        // check hoeveel in de historie staan
        hisnats = query.getResultList();

        Assert.assertEquals(beginAantalNatHistorie + 2, hisnats.size());
        Assert.assertEquals(new Integer(20120216), hisnats.get(beginAantalNatHistorie + 0).getDatumAanvangGeldigheid().getWaarde());
        Assert.assertEquals(null, hisnats.get(beginAantalNatHistorie + 0).getDatumEindeGeldigheid());
        Assert.assertEquals(new Integer(20120416), hisnats.get(beginAantalNatHistorie + 1).getDatumAanvangGeldigheid().getWaarde());
        Assert.assertEquals(null, hisnats.get(beginAantalNatHistorie + 1).getDatumEindeGeldigheid());

        Assert.assertEquals(3, nieuwPersoon.getNationaliteiten().size());
        for (PersoonNationaliteitModel nat : nieuwPersoon.getNationaliteiten()) {
            Assert.assertEquals(StatusHistorie.A.getCode(), nat.getStatusHistorie().getCode());
        }

        // de volgende test is er nog niet (wijzig of beeindigen van nationaliteit).
        // correctie is nog niet van toepassing en beeindigen is nog buiten scope

    }

    @Test (expected = ObjectReedsBestaandExceptie.class)
    public void testVoegNationaliteitDieAlInBezitIs() {
        final ActieModel actie = maakActie();
        final PersoonModel bestaandePersoon = em.find(PersoonModel.class, 2);
        Assert.assertNotNull(bestaandePersoon);
        Assert.assertEquals(1, bestaandePersoon.getNationaliteiten().size());

        PersoonModel nieuwPersoon =  persoonNationaliteitRepository.voegNationaliteit(bestaandePersoon,
                maakNationalRecord(bestaandePersoon.getNationaliteiten().iterator().next()
                    .getNationaliteit().getNationaliteitcode().getWaarde()), actie,
                    new Datum(20120216));
    }


    // Persoon Nationliteit wijzigen is buitenscope en is nog niet geimplementeerd in de nieuwe repository.
    // De vraag is wat er mag gebeuren met wijzigen.
//    @Test
//    public void testWijzigingNationaliteit() {
//        PersoonNationaliteitModel persoonNation = maakHuidigRecordMetHistorie(maakPersoonNationaliteit(), 20110101);
//        ActieModel actie = maakActie();
//        // 1 Historie record aanwezig:
//        List<PersoonNationaliteitHisModel> huidigeHistorie =
//            em.createQuery("Select x from PersoonNationaliteitHisModel x", PersoonNationaliteitHisModel.class)
//                    .getResultList();
//        Assert.assertFalse(huidigeHistorie.isEmpty());
//        Assert.assertEquals(1, huidigeHistorie.size());
//        // Wijzig huidige nationaliteit en persisteer huidigeHistorie
//        Long nieuwNatId = (huidigeHistorie.get(0).getPersoonNationaliteit().getNationaliteit().getNationaliteitId()
//                + 1 % 4);
//        ReflectionTestUtils.setField(persoonNation, "nationaliteit", em.find(Nationaliteit.class, nieuwNatId));
//
//        PersoonNationaliteitModel nieuwPersoonNation = persoonNationaliteitRepository.save(persoonNation);
//        persoonNationaliteitHistorieRepository.persisteerHistorie(nieuwPersoonNation, actie, new Datum(20120101), null);
//        // Check C/D laag
//        List<PersoonNationaliteitHisModel> nieuweHistorie =
//            em.createQuery("Select x from PersoonNationaliteitHisModel x", PersoonNationaliteitHisModel.class).getResultList();
//        Assert.assertFalse(nieuweHistorie.isEmpty());
//        // 1 oude record, en 1 nieuwe record
//        Assert.assertEquals(3, nieuweHistorie.size());
//        boolean eindeGeldigHeidIsGezet = false;
//        boolean recordIsVervallen = false;
//        boolean nieuwRecordIsGemaakt = false;
//        for (PersoonNationaliteitHisModel hisPersoonNationaliteit : nieuweHistorie) {
//            if (hisPersoonNationaliteit.getDatumEindeGeldigheid() != null
//                && hisPersoonNationaliteit.getDatumEindeGeldigheid().getWaarde() == 20120101)
//            {
//                eindeGeldigHeidIsGezet = true;
//                Assert.assertEquals(hisPersoonNationaliteit.getActieAanpassingGeldigheid().getId(), actie.getId());
//            }
//
//            if (hisPersoonNationaliteit.getDatumTijdVerval() != null) {
//                recordIsVervallen = true;
//                Assert.assertEquals(hisPersoonNationaliteit.getActieVerval().getId(), actie.getId());
//            }
//
//            if (hisPersoonNationaliteit.getDatumEindeGeldigheid() == null
//                && hisPersoonNationaliteit.getDatumTijdVerval() == null)
//            {
//                nieuwRecordIsGemaakt = true;
//                Assert.assertEquals(hisPersoonNationaliteit.getActieInhoud().getId(), actie.getId());
//            }
//        }
//        Assert.assertTrue(eindeGeldigHeidIsGezet);
//        Assert.assertTrue(recordIsVervallen);
//        Assert.assertTrue(nieuwRecordIsGemaakt);
//    }
//
//    @Ignore
//    @Test
//    //TODO test klopt niet, check met Roel hoe historie werkt.
//    public void testTerugWerkendeKrachtMutatie() {
//        ActieModel actie1 = maakActie();
//        PersoonNationaliteitModel persoonNation = maakHuidigRecordMetHistorie(maakPersoonNationaliteit(), 20110101);
//        // Wijzig huidige nationaliteit en persisteer historie
//        ReflectionTestUtils.setField(persoonNation, "nationaliteit", em.find(Nationaliteit.class, 4L));
//
//        PersoonNationaliteitModel nieuwPersoonNation = persoonNationaliteitRepository.save(persoonNation);
//        persoonNationaliteitHistorieRepository
//                .persisteerHistorie(nieuwPersoonNation, actie1, new Datum(20120101), null);
//
//        // Check C/D laag
//        List<PersoonNationaliteitHisModel> nieuweHistorie1 =
//            em.createQuery("Select x from PersoonNationaliteitHisModel x", PersoonNationaliteitHisModel.class).getResultList();
//        Assert.assertFalse(nieuweHistorie1.isEmpty());
//        Assert.assertEquals(3, nieuweHistorie1.size());
//        int aantalDLaagRecords1 = 0;
//        int aantalCLaagRecords1 = 0;
//        for (PersoonNationaliteitHisModel hisPersoonNationaliteit : nieuweHistorie1) {
//            if (hisPersoonNationaliteit.getDatumTijdVerval() != null) {
//                aantalDLaagRecords1++;
//                Assert.assertEquals(hisPersoonNationaliteit.getActieVerval().getId(), actie1.getId());
//            } else {
//                aantalCLaagRecords1++;
//                if (hisPersoonNationaliteit.getDatumEindeGeldigheid() == null
//                    && hisPersoonNationaliteit.getDatumTijdVerval() == null)
//                {
//                    Assert.assertEquals(hisPersoonNationaliteit.getActieInhoud().getId(), actie1.getId());
//                } else {
//                    Assert.assertEquals(hisPersoonNationaliteit.getActieAanpassingGeldigheid().getId(), actie1.getId());
//                }
//            }
//        }
//        Assert.assertEquals(1, aantalDLaagRecords1);
//        Assert.assertEquals(2, aantalCLaagRecords1);
//
//        // Doe een terugwerkende kracht mutatie
//        PersoonNationaliteitModel persoonNationaliteit = maakPersoonNationaliteit();
//        ReflectionTestUtils.setField(persoonNationaliteit, "nationaliteit", em.find(Nationaliteit.class, 3L));
//
//        persoonNationaliteit = persoonNationaliteitRepository.save(persoonNationaliteit);
//
//        ActieModel actie2 = maakActie();
//        persoonNationaliteitHistorieRepository.persisteerHistorie(persoonNationaliteit, actie2, new Datum(20110201),
//                new Datum(20110301));
//
//        // Check C/D laag
//        List<PersoonNationaliteitHisModel> nieuweHistorie2 =
//            em.createQuery("Select x from PersoonNationaliteitHisModel x", PersoonNationaliteitHisModel.class).getResultList();
//        Assert.assertFalse(nieuweHistorie2.isEmpty());
//        Assert.assertEquals(6, nieuweHistorie2.size());
//        int aantalDLaagRecords2 = 0;
//        int aantalCLaagRecords2 = 0;
//        for (PersoonNationaliteitHisModel hisPersoonNationaliteit : nieuweHistorie2) {
//            if (hisPersoonNationaliteit.getDatumTijdVerval() != null) {
//                aantalDLaagRecords2++;
//                if (!hisPersoonNationaliteit.getActieVerval().getId().equals(actie1.getId())) {
//                    Assert.assertEquals(hisPersoonNationaliteit.getActieVerval().getId(), actie2.getId());
//                }
//            } else {
//                aantalCLaagRecords2++;
//                if (hisPersoonNationaliteit.getDatumEindeGeldigheid() == null
//                    && hisPersoonNationaliteit.getDatumTijdVerval() == null)
//                {
//                    if (!hisPersoonNationaliteit.getActieInhoud().getId().equals(actie1.getId())) {
//                        Assert.assertEquals(hisPersoonNationaliteit.getActieInhoud().getId(), actie2.getId());
//                    }
//                } else {
//                    if (hisPersoonNationaliteit.getActieAanpassingGeldigheid() != null) {
//                        if (!hisPersoonNationaliteit.getActieAanpassingGeldigheid().getId().equals(actie1.getId())) {
//                            Assert.assertEquals(hisPersoonNationaliteit.getActieAanpassingGeldigheid().getId(),
//                                    actie2.getId());
//                        }
//                    } else {
//                        // Dit is dus het C laag record wat overeenkomt met de terugwerkende kwacht mutatie.
//                        Assert.assertEquals(hisPersoonNationaliteit.getActieInhoud().getId(), actie2.getId());
//                    }
//                }
//            }
//        }
//        Assert.assertEquals(2, aantalDLaagRecords2);
//        Assert.assertEquals(4, aantalCLaagRecords2);
//
//    }
//
//    private PersoonNationaliteitModel maakHuidigRecordMetHistorie(final PersoonNationaliteitModel persoonNationaliteit,
//            final Integer datumAanvangGeldigheid)
//    {
//        PersoonNationaliteitModel persoonNation = persoonNationaliteitRepository.save(persoonNationaliteit);
//        ActieModel actie = maakActie();
//        persoonNationaliteitHistorieRepository.persisteerHistorie(persoonNation, actie, new Datum(
//                datumAanvangGeldigheid), null);
//        return persoonNation;
//    }

//    private PersoonNationaliteitModel maakPersoonNationaliteit() {
//        PersoonBericht persoonBericht = new PersoonBericht();
//
//        PersoonNationaliteitBericht persoonNationaliteitBericht = new PersoonNationaliteitBericht();
//        persoonNationaliteitBericht.setNationaliteit(em.find(Nationaliteit.class, 2L));
//        persoonNationaliteitBericht.setPersoon(persoonBericht);
//        persoonNationaliteitBericht.setGegevens(new PersoonNationaliteitStandaardGroepBericht());
//
//        final PersoonNationaliteitModel persoonNationaliteit =
//            new PersoonNationaliteitModel(persoonNationaliteitBericht, em.find(PersoonModel.class, 1L));
//        return persoonNationaliteit;
//    }
//
}
