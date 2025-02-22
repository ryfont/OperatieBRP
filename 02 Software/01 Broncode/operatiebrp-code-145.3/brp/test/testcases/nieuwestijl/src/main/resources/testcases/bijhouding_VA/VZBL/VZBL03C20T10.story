Meta:
@status                 Klaar
@regels                 R1664
@usecase                UCS-BY.0.VA

Narrative: R1664 Registratie verhuizing buitenland naar niet bestaand land

Scenario:   Landgebied migratie verwijst niet naar bestaand stamgegeven
            LT: VZBL03C20T10

Given alle personen zijn verwijderd
Given enkel initiele vulling uit bestand /LO3PL-VA/LO3PL-VZBL/VZBL-001.xls

When voer een bijhouding uit VZBL03C20T10.xml namens partij 'Gemeente BRP 1'

Then heeft het antwoordbericht verwerking Foutief

Then is het antwoordbericht gelijk aan /testcases/bijhouding_VA/VZBL/expected/VZBL03C20T10.xml voor expressie //brp:bhg_vbaRegistreerVerhuizing_R
