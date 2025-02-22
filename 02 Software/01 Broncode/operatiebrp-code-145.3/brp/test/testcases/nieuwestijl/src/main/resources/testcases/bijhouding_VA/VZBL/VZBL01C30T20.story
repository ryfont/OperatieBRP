Meta:
@status                 Klaar
@regels                 R2369
@usecase                UCS-BY.0.VA

Narrative: R2369 Emigrant moet moet minderjarig zijn of onder curatele staan indien aangever gezaghouder is

Scenario:   R2369 Aangever is geen gezaghouder en emigrant is niet minderjarig of onder curatele
            LT: VZBL01C30T20

Given alle personen zijn verwijderd
Given enkel initiele vulling uit bestand /LO3PL-VA/LO3PL-VZBL/VZBL01C30T20.xls

And de database is aangepast met: update kern.his_persgeboorte set datgeboorte=to_number(to_char(current_date - interval '16 years','YYYYMMDD'),'9999999999.99') where pers in (select id from kern.pers where voornamen='Anne');

When voer een bijhouding uit VZBL01C30T20.xml namens partij 'Gemeente BRP 1'

Then heeft het antwoordbericht verwerking Geslaagd

Then is het antwoordbericht gelijk aan /testcases/bijhouding_VA/VZBL/expected/VZBL01C30T20.xml voor expressie //brp:bhg_vbaRegistreerVerhuizing_R

Then staat er 0 notificatiebericht voor bijhouders op de queue