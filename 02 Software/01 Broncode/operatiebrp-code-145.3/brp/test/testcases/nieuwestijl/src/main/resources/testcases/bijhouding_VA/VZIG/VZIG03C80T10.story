Meta:
@status                 Klaar
@usecase                UCS-BY.0.VA

Narrative: R1274 Datum moet een geldige kalenderdatum zijn

Scenario:  Datum is 29-02-2016 (schrikkeljaar)
           LT: VZIG03C80T10

Given alle personen zijn verwijderd
Given enkel initiele vulling uit bestand /LO3PL-VA/LO3PL-VZIG/VZIG03C80T10-001.xls

When voer een bijhouding uit VZIG03C80T10.xml namens partij 'Gemeente BRP 1'

Then heeft het antwoordbericht verwerking Geslaagd
Then is het antwoordbericht gelijk aan /testcases/bijhouding_VA/VZIG/expected/VZIG03C80T10.xml voor expressie //brp:bhg_vbaRegistreerVerhuizing_R

Then in kern heeft SELECT COUNT(id) FROM kern.admhnd de volgende gegevens:
| veld                      | waarde |
| count                     | 2      |