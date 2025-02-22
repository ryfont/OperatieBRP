Meta:
@auteur                 jozon
@status                 Klaar
@regels                 R2299
@sleutelwoorden         AUAH01C100T40, Geslaagd, Logging
@usecase                BY.1.AA

Narrative: R2299 De bijhoudingsautorisatie is geldig

Scenario: 1. DB init
          preconditie

Given de database is aangepast met: update autaut.his_bijhautorisatie set dateinde = to_number((to_char(now() + interval '1 day', 'YYYYMMDD')), '99999999') where naam = 'Huwelijk'

Scenario: 2. De bijhoudingsautorisatie is wel geldig(datum op dateinde)
          LT: AUAH01C100T40
Given alle personen zijn verwijderd
Given enkel initiele vulling uit bestand /LO3PL-AUAH/AUAH01C100T30-sandy.xls
Given enkel initiele vulling uit bestand /LO3PL-AUAH/AUAH01C100T30-danny.xls

When voer een bijhouding uit AUAH01C100T40.xml namens partij 'Gemeente BRP 1'

Then komt de tekst 'Autorisatie faalt voor regel: R2106' NIET voor in de logging
Then komt de tekst 'Autorisatie faalt voor regel: R2115' NIET voor in de logging
Then komt de tekst 'Autorisatie faalt voor regel: R2246' NIET voor in de logging
Then komt de tekst 'Autorisatie faalt voor regel: R2247' NIET voor in de logging
Then komt de tekst 'Autorisatie faalt voor regel: R2248' NIET voor in de logging
Then komt de tekst 'Autorisatie faalt voor regel: R2268' NIET voor in de logging
Then komt de tekst 'Autorisatie faalt voor regel: R2269' NIET voor in de logging
Then komt de tekst 'Autorisatie faalt voor regel: R2270' NIET voor in de logging
Then komt de tekst 'Autorisatie faalt voor regel: R2271' NIET voor in de logging
Then komt de tekst 'Autorisatie faalt voor regel: R2299' NIET voor in de logging
Then komt de tekst 'Autorisatie faalt voor regel: R2250' NIET voor in de logging
Then komt de tekst 'Autorisatie faalt voor regel: R2251' NIET voor in de logging
Then komt de tekst 'Autorisatie faalt voor regel: R2252' NIET voor in de logging


Then heeft het antwoordbericht verwerking Geslaagd
Then is het antwoordbericht gelijk aan /testcases/bijhouding/AUAH/expected/AUAH01C100T40.xml voor expressie //brp:bhg_hgpRegistreerHuwelijkGeregistreerdPartnerschap_R

Then is in de database de persoon met bsn 770415817 wel als PARTNER betrokken bij een HUWELIJK
Then is in de database de persoon met bsn 547827593 wel als PARTNER betrokken bij een HUWELIJK

Then lees persoon met anummer 1804232481 uit database en vergelijk met expected AUAH01C100T40-persoon1.xml
Then lees persoon met anummer 6401325345 uit database en vergelijk met expected AUAH01C100T40-persoon2.xml

Scenario: 3. DB reset
          postconditie
Given de database is aangepast met: update autaut.his_bijhautorisatie set dateinde = null where naam = 'Huwelijk'

