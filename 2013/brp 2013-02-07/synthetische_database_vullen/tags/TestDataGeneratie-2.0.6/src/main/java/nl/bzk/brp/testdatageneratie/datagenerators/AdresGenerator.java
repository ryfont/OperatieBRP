/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.testdatageneratie.datagenerators;

import java.util.Random;

import nl.bzk.brp.testdatageneratie.BronnenRepo;
import nl.bzk.brp.testdatageneratie.MetaRepo;
import nl.bzk.brp.testdatageneratie.RandomService;
import nl.bzk.brp.testdatageneratie.domain.bronnen.AdresHuisletter;
import nl.bzk.brp.testdatageneratie.domain.bronnen.AdresHuisnummer;
import nl.bzk.brp.testdatageneratie.domain.bronnen.AdresHuisnummertoevoeging;
import nl.bzk.brp.testdatageneratie.domain.bronnen.AdresNor;
import nl.bzk.brp.testdatageneratie.domain.bronnen.AdresPostcode;
import nl.bzk.brp.testdatageneratie.domain.bronnen.GemeenteDeel;
import nl.bzk.brp.testdatageneratie.domain.kern.Partij;
import nl.bzk.brp.testdatageneratie.domain.kern.Plaats;


public class AdresGenerator {

    public Random random;

    public AdresGenerator(final long seed) {
        random = new Random(seed);
    }

    public Partij getGemeente() {
        return RandomService.getPartijByBijhgem(random);
    }

    public String getGemDeel() {
        final GemeenteDeel gemeentedeel = BronnenRepo.getBron(GemeenteDeel.class, random);
        return gemeentedeel.getGemeenteDeel();
    }

    public String getAdresseerbaarobject() {
        return (random.nextInt(9000) + 1000) + "0100000" + (random.nextInt(90000) + 10000);
    }

    public String getIdentcodenraand() {
        return "" + (random.nextInt(90000000) + 10000000);
    }

    public String getAdresNor() {
        if (RandomService.isFractie(1481)) {
            return null;
        } else {
            AdresNor adresNor = BronnenRepo.getBron(AdresNor.class, random);
            return adresNor.getWaarde();
        }
    }

    public Integer getAdresHuisnummer() {
        AdresHuisnummer adresHuisnummer = BronnenRepo.getBron(AdresHuisnummer.class, random);
        return adresHuisnummer.getWaarde();
    }

    public String getAdresHuisletter() {
        if (RandomService.isFractie(14)) {
            AdresHuisletter adresHuisletter = BronnenRepo.getBron(AdresHuisletter.class, random);
            return adresHuisletter.getWaarde();
        } else {
            return null;
        }
    }

    public String getAdresHuisnummertoevoeging() {
        if (RandomService.isFractie(23)) {
            AdresHuisnummertoevoeging adresHuisnummertoevoeging = BronnenRepo.getBron(AdresHuisnummertoevoeging.class, random);
            return adresHuisnummertoevoeging.getWaarde();
        } else {
            return null;
        }
    }

    public String getAdresPostcode() {
        if (RandomService.isFractie(40)) {
            return null;
        } else {
            AdresPostcode adresPostcode = BronnenRepo.getBron(AdresPostcode.class, random);
            return adresPostcode.getWaarde();
        }
    }

    public Plaats getPlaats() {
        return MetaRepo.getByIndex(Plaats.class, random);
    }

}
