Meta:
@status                 Klaar
@regels                 R1929
@usecase                UCS-BY.0.VA

Narrative: R1929 Persoon wiens adres het betreft moet zelf ouder zijn als aangever meerderjarig kind is

Scenario:   R1929 De adreshouder is een ouder van een minderjarig kind. Qua leeftijd lager dan 18 jaar en geen HGP
            LT: VZIG01C30T20

Given alle personen zijn verwijderd
Given enkel initiele vulling uit bestand /LO3PL-VA/LO3PL-VZIG/VZIG01C30T20-001.xls

And de database is aangepast met: update kern.his_persgeboorte set datgeboorte=to_number(to_char(current_date - interval '17 years','YYYYMMDD'),'9999999999.99') where pers in (select id from kern.pers where voornamen='Marianne');

When voer een bijhouding uit VZIG01C30T20.xml namens partij 'Gemeente BRP 1'

Then heeft het antwoordbericht verwerking Foutief
Then is het antwoordbericht gelijk aan /testcases/bijhouding_VA/VZIG/expected/VZIG01C30T20.xml voor expressie //brp:bhg_vbaRegistreerVerhuizing_R
