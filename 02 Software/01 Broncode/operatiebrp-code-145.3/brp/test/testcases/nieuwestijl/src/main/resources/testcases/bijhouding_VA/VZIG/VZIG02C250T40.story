Meta:
@status                 Klaar
@usecase                UCS-BY.0.VA

Narrative: R2255 Gemeente verordening moet verwijzen naar een geldig stamgegeven

Scenario: 1. DB init
          preconditie

Given de database is aangepast met: update kern.partij set dateinde = to_number((to_char(now() - interval '1 day', 'YYYYMMDD')),'99999999') where naam = 'Gemeente BRP 2'
And de database is aangepast met: update kern.his_partij set dateinde = to_number((to_char(now() - interval '1 day', 'YYYYMMDD')),'99999999') where naam = 'Gemeente BRP 2'
Given maak bijhouding caches leeg

Scenario: 2. Adres.Datum aanvang adreshouding op Gemeente.dateindegelgel
            LT: VZIG02C250T40

Given alle personen zijn verwijderd
Given enkel initiele vulling uit bestand /LO3PL-VA/LO3PL-VZIG/VZIG-001.xls

When voer een bijhouding uit VZIG02C250T40.xml namens partij 'Gemeente BRP 1'

Then heeft het antwoordbericht verwerking Foutief
Then is het antwoordbericht gelijk aan /testcases/bijhouding_VA/VZIG/expected/VZIG02C250T40.xml voor expressie //brp:bhg_vbaRegistreerVerhuizing_R

Then in kern heeft SELECT COUNT(id) FROM kern.admhnd de volgende gegevens:
| veld                      | waarde |
| count                     | 1      |

Scenario: 3. DB reset
          postconditie
Given de database is aangepast met: update kern.partij set dateinde = null where naam = 'Gemeente BRP 2'
Given de database is aangepast met: update kern.his_partij set dateinde = null where naam = 'Gemeente BRP 2'
Given maak bijhouding caches leeg
