Meta:
@status                 Klaar
@usecase                UCS-BY.0.AS

Narrative: R1691 Kind moet Nederlandse nationaliteit hebben als een ouder ook de Nederlandse nationaliteit heeft

Scenario: Kind heeft niet de NL nationaliteit. Geen ouder heeft de NL nationaliteit.
          LT: GBNL01C40T30

Given alle personen zijn verwijderd
Given enkel initiele vulling uit bestand /LO3PL-AS/LO3PL-GBNL/GBNL01C40T30-001.xls
Given enkel initiele vulling uit bestand /LO3PL-AS/LO3PL-GBNL/GBNL01C40T30-002.xls

When voer een bijhouding uit GBNL01C40T30.xml namens partij 'Gemeente BRP 1'

Then heeft het antwoordbericht verwerking Geslaagd
Then is het antwoordbericht gelijk aan /testcases/bijhouding_AS/GBNL/expected/GBNL01C40T30.xml voor expressie //brp:bhg_afsRegistreerGeboorte_R
