Meta:
@auteur                 fuman
@status                 Klaar
@usecase                BY.1.MP

Narrative:
Scenario 1 Hoofdscenario tbv AGNL

Scenario: BZVU-personen NIET gevuld EN persoon komt er NIET in voor
          LT: MBHP08C10T10



Given alle personen zijn verwijderd
Given enkel initiele vulling uit bestand /LO3PL-MBHP/MBHP01C10T10-Libby.xls

When voer een bijhouding uit MBHP08C10T10.xml namens partij 'Gemeente BRP 1'

Then is het antwoordbericht gelijk aan /testcases/bijhouding/MBHP/expected/MBHP08C10T10.xml voor expressie //brp:bhg_hgpRegistreerHuwelijkGeregistreerdPartnerschap_R

Then staat er 1 notificatiebericht voor bijhouders op de queue

Then controleer tijdstip laatste wijziging in bijhoudingsplan voor bijgehouden personen
