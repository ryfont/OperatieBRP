Meta:
@status             Klaar
@usecase            BV.0.GD
@sleutelwoorden     Bevraging GeefDetailsPersoon
@regels             R2224
@regelversie        6

Narrative:
Indien in het bericht

Bericht.Historievorm de waarde "Geen" heeft

dan worden alleen de gegevens die Geldig (R2129) waren op Bericht.Peilmoment materieel resultaat
zoals in het systeem bekend op Bericht.Peilmoment formeel resultaat geleverd.

Indien één of beide peilmomenten leeg zijn (of niet voorkomen in het bericht) dan wordt 'Systeemdatum' (R2016) als peilmoment(en) gebruikt.

Indien er sprake is van Datum (deels) onbekend (R1273) dan moet de R1283 - Vergelijken (partiële) datums uitgevoerd worden.

Scenario:   1. GeefDetailsPersoon service met historie vorm 'Geen'
            LT: R2224_LT01
            Historievorm: Geen
            peilmomentMaterieelResultaat: Leeg
            peilmomentFormeelResultaat: Leeg
            Verwacht resultaat: Enkel de voorkomens die geldig zijn op de systeemdatum zijn aanwezig in het antwoord bericht.

!-- | WOONPLAATS    | DAG      | DEG      |                                   |
!-- | Utrecht       | 19760401 | 20100101 |                                   |
!-- | 's-Gravenhage | 20100101 | 20150101 |                                   |
!-- | Uithoorn      | 20150101 | NULL     | <-- Huidig adres want DEG is NULL |

Given leveringsautorisatie uit autorisatie/Geen_pop.bep_levering_op_basis_van_afnemerindicatie
Given persoonsbeelden uit specials:specials/Anne_met_Historie_xls
!-- Bevraging persoonsgegevens met historievorm 'Geen'
Given verzoek geef details persoon:
|key|value
|leveringsautorisatieNaam|'Geen pop.bep. levering op basis van afnemerindicatie'
|zendendePartijNaam|'Gemeente Utrecht'
|bsn|590984809
|historievorm|Geen

Then heeft het antwoordbericht verwerking Geslaagd

!-- Enkel de actuele voorkomens worden geleverd, attributen voor historische voorkomens niet aanwezig
!-- Dus geen datumEindeGeldigheid, actieAanpassingGeldigheid actieVerval, tijdstipVerval
Then is er voor xpath //brp:datumEindeGeldigheid geen node aanwezig in het antwoord bericht
Then is er voor xpath //brp:actieAanpassingGeldigheid geen node aanwezig in het antwoord bericht
Then is er voor xpath //brp:actieVerval geen node aanwezig in het antwoord bericht
Then is er voor xpath //brp:tijdstipVerval geen node aanwezig in het antwoord bericht

Then is het antwoordbericht gelijk aan expected_R2224/01.xml voor expressie //brp:lvg_bvgGeefDetailsPersoon_R

Scenario:   2. GeefDetailsPersoon service met historie vorm Geen en peilmomentMaterieelResultaat gevuld
            LT: R2224_LT02
            Historievorm: Geen
            peilmomentMaterieelResultaat: 2010-01-01
            peilmomentFormeelResultaat: Leeg (dus enkel voorkomens geldig op systeemdatum)
            Verwacht resultaat:
            - Alle voorkomens waarvoor geldt dat (DAG <= 2010-01-01 EN DEG > 2010-01-01)
                    EN
              (tijdstipregistratie < systeemdatum EN tijdstip verval = leeg)

!-- | WOONPLAATS    | DAG      | DEG      |                                   |
!-- | Utrecht       | 19760401 | 20100101 |                                   |
!-- | 's-Gravenhage | 20100101 | 20150101 |                                   |
!-- | Uithoorn      | 20150101 | NULL     | <-- Huidig adres want DEG is NULL |

Given leveringsautorisatie uit autorisatie/Geen_pop.bep_levering_op_basis_van_afnemerindicatie
Given persoonsbeelden uit specials:specials/Anne_met_Historie_xls
!-- Bevraging persoonsgegevens met historievorm Geen en peilmomentMaterieelResultaat gevuld
Given verzoek geef details persoon:
|key|value
|leveringsautorisatieNaam|'Geen pop.bep. levering op basis van afnemerindicatie'
|zendendePartijNaam|'Gemeente Utrecht'
|bsn|590984809
|historievorm|Geen
|peilmomentMaterieelResultaat|2010-01-01

Then heeft het antwoordbericht verwerking Geslaagd

!-- 1 groep adres, want adres voor Utrecht is beeindigd per 2010-01-01, adres voor Den Haag is ingegaan per 2010-01-01
Then heeft het antwoordbericht 1 groep 'adres'
Then heeft in het antwoordbericht 'woonplaatsnaam' in 'adres' de waarde ''s-Gravenhage'

!-- Geboorte kind1 geregistreerd op 2010-01-01, Geboorte kind2 op 2015-01-01
Then heeft het antwoordbericht 3 groepen 'kind'

!-- Bij 1ste kind zijn alle 'normale' groepen aanwezig
Then is er voor xpath (//brp:kind)[2]/brp:persoon/brp:identificatienummers een node aanwezig in het antwoord bericht
Then is er voor xpath (//brp:kind)[2]/brp:persoon/brp:samengesteldeNaam een node aanwezig in het antwoord bericht
Then is er voor xpath (//brp:kind)[2]/brp:persoon/brp:geboorte een node aanwezig in het antwoord bericht

!-- Bij 2de kind zijn slechts groepen met historiepatroon 'geen' aanwezig
Then is er voor xpath (//brp:kind)[3]/brp:persoon/brp:geboorte een node aanwezig in het antwoord bericht
Then is er voor xpath (//brp:kind)[3]/brp:persoon/brp:identificatienummers geen node aanwezig in het antwoord bericht
Then is er voor xpath (//brp:kind)[3]/brp:persoon/brp:samengesteldeNaam geen node aanwezig in het antwoord bericht

!-- Huwelijk ingegaan op 2010-01-01, ontbonden op 2015-01-01
Then heeft het antwoordbericht 2 groep 'partner'

!-- Onderzoek geldig op formele historie as, maar wijst naar een actueel gegeven, die niet voorkomt in het bericht en wordt daarom niet getoond
Then is er voor xpath //brp:onderzoek geen node aanwezig in het antwoord bericht

Then is het antwoordbericht gelijk aan expected_R2224/02.xml voor expressie //brp:lvg_bvgGeefDetailsPersoon_R

Scenario: 3.    Historievorm = Geen, Peilmoment materieel resultaat is datum x (2016-01-01), Peilmoment Formeel resultaat is datum y (2016-01-01)
                LT: R2224_LT03
                Verwacht resultaat:
                - Den Haag in bericht
                Uitwerking:
                - Uithoorn sinds 2016-01-02
                - Den Haag sinds 2016-01-01 (naamOpenbareRuimte = Spui)
                - Utrecht sinds  2015-21-31
                - Oosterhout sinds 2010

Given leveringsautorisatie uit autorisatie/geen_pop_bep_levering_op_basis_van_doelbinding_Haarlem

Given persoonsbeelden uit specials:specials/Anne_Bakker_xls

Given tijdstip laatste wijziging GBA systematiek op de persoon :
|bsn|tsLaatsteWijzigingGbaSystematiek
|595891305|'1900-12-31 T23:59:00Z'

Given verzoek geef details persoon:
|key|value
|leveringsautorisatieNaam|'Geen pop.bep. levering op basis van doelbinding Haarlem'
|zendendePartijNaam|'Gemeente Haarlem'
|bsn|595891305
|historievorm|Geen
|peilmomentMaterieelResultaat|'2016-01-01'
|peilmomentFormeelResultaat|2016-01-01T23:59:56.223Z

Then heeft het antwoordbericht verwerking Geslaagd

Then heeft het antwoordbericht 1 groepen 'adres'

Then is er voor xpath //brp:naamOpenbareRuimte[text()='Spui'] een node aanwezig in het antwoord bericht

Then is het antwoordbericht gelijk aan expected_R2224/03.xml voor expressie //brp:lvg_bvgGeefDetailsPersoon_R

Scenario: 4.    Historievorm = Geen, Peilmoment materieel resultaat is datum x (2015-12-31), Peilmoment Formeel resultaat is datum y (2015-12-31)
                LT: R2224_LT04
                Verwacht resultaat:
                - Utrecht in bericht
                Uitwerking:
                - Uithoorn sinds 2016-01-02
                - Den Haag sinds 2016-01-01
                - Utrecht sinds  2015-21-31
                - Oosterhout sinds 2010

Given leveringsautorisatie uit autorisatie/geen_pop_bep_levering_op_basis_van_doelbinding_Haarlem

Given persoonsbeelden uit specials:specials/Anne_Bakker_xls

Given tijdstip laatste wijziging GBA systematiek op de persoon :
|bsn|tsLaatsteWijzigingGbaSystematiek
|595891305|'1900-12-31 T23:59:00Z'

Given verzoek geef details persoon:
|key|value
|leveringsautorisatieNaam|'Geen pop.bep. levering op basis van doelbinding Haarlem'
|zendendePartijNaam|'Gemeente Haarlem'
|bsn|595891305
|historievorm|Geen
|peilmomentMaterieelResultaat|'2015-12-31'
|peilmomentFormeelResultaat|2015-12-31T23:59:56.223Z

Then heeft het antwoordbericht verwerking Geslaagd

!-- R2225_LT01
Then heeft het antwoordbericht 1 groepen 'adres'

Then is er voor xpath //brp:woonplaatsnaam[text()='Utrecht'] een node aanwezig in het antwoord bericht

Then is het antwoordbericht gelijk aan expected_R2224/04.xml voor expressie //brp:lvg_bvgGeefDetailsPersoon_R

Scenario:   5. GeefDetailsPersoon service met historie vorm Geen en peilmomentMaterieelResultaat gevuld  / peilmomentFormeelResultaat  = LEEG, PL bevat deels onbekende datum
            LT: R2224_LT05, R2550_LT02
            Historievorm: Geen
            peilmomentMaterieelResultaat: 2016-01-31
            peilmomentFormeelResultaat: Leeg
            Verwacht resultaat:
            - Bartoklaan en Spui in het bericht
!-- Geldig voorkomens van adres op peilmoment materieel resultaat 2016-01-31
!-- Adres 4: Bertram 157,   Datum aanvang geldigheid = 2016-02-00
!-- Adres 3: Spui 43,       datum aanvang geldigheid = 2016-01-00   datum einde geldigheid = 2016-02-00
!-- Adres 2: Neude 11,      Datum aanvang geldigheid = 2016-00-00   Datum einde geldigheid = 2016-01-00
!-- Adres 1: Bartoklaan 11, Datum aanvang geldigheid = 2010-12-31   Datum einde geldigheid = 2016-00-00


Given leveringsautorisatie uit autorisatie/Geen_pop.bep_levering_op_basis_van_afnemerindicatie, autorisatie/GeefDetailsPersoon_AfnemerIndicaties_Afnemer
Given persoonsbeelden uit specials:specials/Anne_met_Historie_gedeeltelijk_onb_dat_xls
Given verzoek geef details persoon:
|key|value
|leveringsautorisatieNaam|'geefDetailsPersoon'
|zendendePartijNaam|'Gemeente Utrecht'
|bsn|986096969
|historievorm|Geen
|peilmomentMaterieelResultaat|2016-01-31

Then heeft het antwoordbericht verwerking Geslaagd

Then heeft het antwoordbericht 2 groep 'adres'
Then is er voor xpath //brp:naamOpenbareRuimte[text()='Spui'] een node aanwezig in het antwoord bericht
Then is er voor xpath //brp:naamOpenbareRuimte[text()='Bartoklaan'] een node aanwezig in het antwoord bericht

Then is het antwoordbericht gelijk aan expected_R2224/05.xml voor expressie //brp:lvg_bvgGeefDetailsPersoon_R
!-- R2550 Actieverval is leeg, dus niet in bericht
Then is er voor xpath //brp:actieVerval geen node aanwezig in het antwoord bericht

Scenario:   6. GeefDetailsPersoon service met historie vorm Geen en peilmomentMaterieelResultaat gevuld  / peilmomentFormeelResultaat  = LEEG, PL bevat deels onbekende datum
            LT: R2224_LT06, R2550_LT02
            Historievorm: Geen
            peilmomentMaterieelResultaat: 2016-02-01
            peilmomentFormeelResultaat: Leeg
            Verwacht resultaat:
            - Spui en Bertram in het bericht
!-- Geldig voorkomens van adres op peilmoment materieel resultaat 2016-02-01
!-- Adres 4: Bertram 157,   Datum aanvang geldigheid = 2016-02-00
!-- Adres 3: Spui 43,       datum aanvang geldigheid = 2016-01-00   datum einde geldigheid = 2016-02-00
!-- Adres 2: Neude 11,      Datum aanvang geldigheid = 2016-00-00   Datum einde geldigheid = 2016-01-00
!-- Adres 1: Bartoklaan 11, Datum aanvang geldigheid = 2010-12-31   Datum einde geldigheid = 2016-00-00

Given leveringsautorisatie uit autorisatie/Geen_pop.bep_levering_op_basis_van_afnemerindicatie, autorisatie/GeefDetailsPersoon_AfnemerIndicaties_Afnemer
Given persoonsbeelden uit specials:specials/Anne_met_Historie_gedeeltelijk_onb_dat_xls
Given verzoek geef details persoon:
|key|value
|leveringsautorisatieNaam|'geefDetailsPersoon'
|zendendePartijNaam|'Gemeente Utrecht'
|bsn|986096969
|historievorm|Geen
|peilmomentMaterieelResultaat|2016-02-01

Then heeft het antwoordbericht verwerking Geslaagd

Then heeft het antwoordbericht 3 groep 'adres'
Then is er voor xpath //brp:naamOpenbareRuimte[text()='Spui'] een node aanwezig in het antwoord bericht
Then is er voor xpath //brp:naamOpenbareRuimte[text()='Bertram'] een node aanwezig in het antwoord bericht
Then is er voor xpath //brp:naamOpenbareRuimte[text()='Bartoklaan'] een node aanwezig in het antwoord bericht

Then is het antwoordbericht gelijk aan expected_R2224/06.xml voor expressie //brp:lvg_bvgGeefDetailsPersoon_R
!-- R2550 Actieverval is leeg, dus niet in bericht
Then is er voor xpath //brp:actieVerval geen node aanwezig in het antwoord bericht

Scenario:   7. GeefDetailsPersoon service met historie vorm Geen, PL bevat geheel onbekende datum
            LT: R2224_LT07
            Historievorm: Geen
            peilmomentMaterieelResultaat: 2005-01-01
            peilmomentFormeelResultaat: Leeg
            Verwacht resultaat: Enkel de actuele voorkomens bij de persoon worden geleverd.

Given leveringsautorisatie uit autorisatie/Geen_pop.bep_levering_op_basis_van_afnemerindicatie
Given persoonsbeelden uit oranje:DELTAVERS11/DELTAVERS11C10T110_xls

Given verzoek geef details persoon:
|key|value
|leveringsautorisatieNaam|'Geen pop.bep. levering op basis van afnemerindicatie'
|zendendePartijNaam|'Gemeente Utrecht'
|bsn|950878601
|historievorm|Geen
|peilmomentMaterieelResultaat|2005-01-01

Then heeft het antwoordbericht verwerking Geslaagd

!-- R2224_LT07 Voorkomens met onbekende datum aanvang geldigheid worden niet gefilterd door historie filter
Then is er voor xpath //brp:derdeHeeftGezag/brp:datumAanvangGeldigheid[text()='0000'] een node aanwezig in het antwoord bericht

!-- R2224_LT07 Voorkomens met onbekende datum einde geldigheid worden niet gefilterd door historie filter
Then is er voor xpath //brp:ouderlijkGezag/brp:datumEindeGeldigheid[text()='0000'] een node aanwezig in het antwoord bericht

Then is het antwoordbericht gelijk aan expected_R2224/07.xml voor expressie //brp:lvg_bvgGeefDetailsPersoon_R

Scenario: 8.   Historievorm = Geen, Peilmoment materieel resultaat is Leeg, Peilmoment formeel resultaat VANDAAG
                LT: R2224_LT08
            Historievorm: Geen
            peilmomentMaterieelResultaat: LEEG
            peilmomentFormeelResultaat: VANDAAG
            Verwacht resultaat: Datum aanvang huwelijk is 2016-05-10, tijdstip registratie is huwelijk < peilmomentFormeelResultaat en tijdstip verval = leeg dus in bericht

Given leveringsautorisatie uit autorisatie/geen_pop_bep_levering_op_basis_van_doelbinding_Haarlem

Given persoonsbeelden uit BIJHOUDING:VHNL04C10T10/Personen_Libby_Thatcher_(Ingeschrevene-I/dbstate003

Given verzoek geef details persoon:
|key|value
|leveringsautorisatieNaam|'Geen pop.bep. levering op basis van doelbinding Haarlem'
|zendendePartijNaam|'Gemeente Haarlem'
|bsn|422531881
|historievorm|Geen
|peilmomentFormeelResultaat|VANDAAG

Then heeft het antwoordbericht verwerking Geslaagd

Then is er voor xpath //brp:huwelijk een node aanwezig in het antwoord bericht

Then is het antwoordbericht gelijk aan expected_R2224/08.xml voor expressie //brp:lvg_bvgGeefDetailsPersoon_R

Scenario: 9.   Historievorm = GEEN, Peilmoment materieel resultaat is Leeg, Peilmoment formeel resultaat 2016-10-16T23:59:59.223Z
                LT: R2224_LT09
            Historievorm: Geen
            peilmomentFormeelResultaat: 2016-10-16T23:59:59.223Z
            Verwacht resultaat:
            - Datum aanvang huwelijk is 2016-05-10,
            - tijdstip registratie van het huwelijk ligt na het peilmomentformeelresultaat dus NIET in bericht (2016-12-01)

Given leveringsautorisatie uit autorisatie/geen_pop_bep_levering_op_basis_van_doelbinding_Haarlem

Given persoonsbeelden uit BIJHOUDING:VHNL04C10T10/Personen_Libby_Thatcher_(Ingeschrevene-I/dbstate003

Given tijdstip laatste wijziging GBA systematiek op de persoon :
|bsn|tsLaatsteWijzigingGbaSystematiek
|422531881|'2014-12-31 T23:59:00Z'

Given tijdstip laatste wijziging GBA systematiek op de persoon :
|bsn|tsLaatsteWijzigingGbaSystematiek
|159247913|'2014-12-31 T23:59:00Z'

Given verzoek geef details persoon:
|key|value
|leveringsautorisatieNaam|'Geen pop.bep. levering op basis van doelbinding Haarlem'
|zendendePartijNaam|'Gemeente Haarlem'
|bsn|422531881
|historievorm|Geen
|peilmomentFormeelResultaat|2016-10-16T23:59:59.223Z

Then heeft het antwoordbericht verwerking Geslaagd

Then is er voor xpath //brp:huwelijk geen node aanwezig in het antwoord bericht

Then is het antwoordbericht gelijk aan expected_R2224/09.xml voor expressie //brp:lvg_bvgGeefDetailsPersoon_R

Scenario: 10. Historievorm = GEEN, onderzoek niet aanwezig in resultaat bericht, want verwijst naar historisch voorkomen
              Verwacht resultaat:
              Onderzoek niet in bericht want verwijst naar historische voorkomen van adres
              Omdat historie vorm = geen is het voorkomen van het adres niet aanwezig en daarom het onderzoek ook niet

Given leveringsautorisatie uit autorisatie/Geen_pop.bep_levering_op_basis_van_afnemerindicatie
Given persoonsbeelden uit specials:MaakBericht/R2224_ElisaBeth_Vervallen_onderzoek_xls
!-- Bevraging persoonsgegevens met historievorm 'Geen'
Given verzoek geef details persoon:
|key|value
|leveringsautorisatieNaam|'Geen pop.bep. levering op basis van afnemerindicatie'
|zendendePartijNaam|'Gemeente Utrecht'
|bsn|270433417
|historievorm|Geen

Then heeft het antwoordbericht verwerking Geslaagd

!-- Geen onderzoek, want onderzoek verwijst naar historisch voorkomen van adres welke niet in het bericht is opgenomen
Then is er voor xpath //brp:onderzoek geen node aanwezig in het antwoord bericht

Scenario: 10A. Historievorm = Leeg (MaterieelFormeel) en formeel peilmoment ligt voor aanvang van het onderzoek
               Verwacht resultaat:
               Onderzoek niet in bericht, omdat het peilmoment FormeelResultaat voor de ts reg van het onderzoek ligt.

Given leveringsautorisatie uit autorisatie/Geen_pop.bep_levering_op_basis_van_afnemerindicatie
Given persoonsbeelden uit specials:MaakBericht/R2224_ElisaBeth_Vervallen_onderzoek_xls

Given tijdstip laatste wijziging GBA systematiek op de persoon :
|bsn|tsLaatsteWijzigingGbaSystematiek
|270433417|'2010-12-31 T23:59:00Z'

Given verzoek geef details persoon:
|key|value
|leveringsautorisatieNaam|'Geen pop.bep. levering op basis van afnemerindicatie'
|zendendePartijNaam|'Gemeente Utrecht'
|bsn|270433417
|historievorm|MaterieelFormeel
|peilmomentMaterieelResultaat|2011-06-16
|peilmomentFormeelResultaat|2011-06-16T23:59:59.223Z


Then heeft het antwoordbericht verwerking Geslaagd

!-- Geen onderzoek want peilmoment formeel resultaat ligt voor tsreg van het onderzoek
Then is er voor xpath //brp:onderzoek geen node aanwezig in het antwoord bericht


Scenario:   11. GeefDetailsPersoon service met historie vorm Geen en peilmomentMaterieelResultaat gevuld  / peilmomentFormeelResultaat  = LEEG, PL bevat een vervallen nationaliteit
            Historievorm: Geen
            peilmomentMaterieelResultaat: 2012-02-01
            peilmomentFormeelResultaat: Leeg
            Verwacht resultaat:
            Jan_vervallen_nationaliteit heeft een actuele nederlandse nationaliteit
            en een vervallen belgische nationaliteit welke in 2011-09-09 vervalt.
            Verwacht resultaat:
            Nederlandse nationaliteit getoond in bericht
            Belgische nationaliteit niet opgenomen in het bericht.

Given leveringsautorisatie uit autorisatie/Geen_pop.bep_levering_op_basis_van_afnemerindicatie, autorisatie/GeefDetailsPersoon_AfnemerIndicaties_Afnemer
Given persoonsbeelden uit specials:specials/Jan_vervallen_nationaliteit_xls

Given verzoek geef details persoon:
|key|value
|leveringsautorisatieNaam|'geefDetailsPersoon'
|zendendePartijNaam|'Gemeente Utrecht'
|bsn|798834377
|historievorm|Geen
|peilmomentMaterieelResultaat|2012-02-01

Then heeft het antwoordbericht verwerking Geslaagd

