Meta:
@status                 Klaar
@usecase                BY.1.MP

Narrative:
Scenario 4 Bijhoudingsituatie = 'GBA'

Scenario: Scenario 4 Bijhoudingsituatie = 'GBA', Marie niet overleden
          LT: MBHP06C10T10



Given alle personen zijn verwijderd
Given enkel initiele vulling uit bestand /LO3PL-MBHP/MBHP06C10T10-Marie.xls

When voer een bijhouding uit MBHP06C10T10.xml namens partij 'Gemeente BRP 1'

Then is het antwoordbericht gelijk aan /testcases/bijhouding/MBHP/expected/MBHP06C10T10.xml voor expressie //brp:bhg_hgpRegistreerHuwelijkGeregistreerdPartnerschap_R

Then controleer tijdstip laatste wijziging in bijhoudingsplan voor bijgehouden personen
