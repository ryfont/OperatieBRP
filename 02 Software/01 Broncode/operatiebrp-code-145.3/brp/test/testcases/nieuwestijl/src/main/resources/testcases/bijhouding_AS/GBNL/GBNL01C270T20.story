Meta:
@status                 Klaar
@usecase                UCS-BY.0.AS

Narrative: R2523 Ouder mag geen kinderen hebben met identieke burgerservicenummers en of administratienummers

Scenario:   NOUWKIG heeft op Datum aanvang geldigheid reeds een kind (Pseudo) met hetzelfde Persoon.Burgerservicenummer en Persoon.Administratienummer
            LT: GBNL01C270T20

Given alle personen zijn verwijderd
Given enkel initiele vulling uit bestand /LO3PL-AS/LO3PL-GBNL/GBNL01C270T20-001.xls
Given enkel initiele vulling uit bestand /LO3PL-AS/LO3PL-GBNL/GBNL01C270T20-002.xls

When voer een bijhouding uit GBNL01C270T20.xml namens partij 'Gemeente BRP 1'

Then heeft het antwoordbericht verwerking Foutief
Then is het antwoordbericht gelijk aan /testcases/bijhouding_AS/GBNL/expected/GBNL01C270T20.xml voor expressie //brp:bhg_afsRegistreerGeboorte_R