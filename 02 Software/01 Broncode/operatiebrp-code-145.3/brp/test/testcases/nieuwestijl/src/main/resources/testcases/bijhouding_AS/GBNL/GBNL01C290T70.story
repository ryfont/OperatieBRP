Meta:
@status                 Klaar
@usecase                UCS-BY.0.AS

Narrative: R1732 Ouder mag geen kinderen hebben met identieke personalia

Scenario: De ingeschreven kinderen verschillen van Datum geboorte
          LT: GBNL01C290T70

Given alle personen zijn verwijderd

!-- Vulling van de OUWKIG
Given enkel initiele vulling uit bestand /LO3PL-AS/LO3PL-GBNL/GBNL01C290T70-001.xls

!-- Geboorte van de sibling
When voer een bijhouding uit GBNL01C290T70a.xml namens partij 'Gemeente BRP 1'
Then heeft het antwoordbericht verwerking Geslaagd

!-- Geboorte van het kind
When voer een bijhouding uit GBNL01C290T70b.xml namens partij 'Gemeente BRP 1'

Then heeft het antwoordbericht verwerking Geslaagd
Then is het antwoordbericht gelijk aan /testcases/bijhouding_AS/GBNL/expected/GBNL01C290T70.xml voor expressie //brp:bhg_afsRegistreerGeboorte_R