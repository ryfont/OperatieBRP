Meta:
@status                 Klaar
@sleutelwoorden         Geslaagd
@usecase                UCS-BY.HG

Narrative:
Predicaat gevuld Adelijke titel niet gevuld

Scenario:   Personen Libby Thatcher (Ingeschrevene-Ingezetene, Niet NL Nat) en Piet Jansen (Ingeschrevene-Ingezetene, NL Nat) gaan trouwen, predicaat gevuld
            LT: VHNL02C680T10

Given alle personen zijn verwijderd
Given enkel initiele vulling uit bestand /LO3PL/VHNL02C680T10-Libby.xls
Given enkel initiele vulling uit bestand /LO3PL/VHNL02C680T10-Piet.xls

When voer een bijhouding uit VHNL02C680T10.xml namens partij 'Gemeente BRP 1'

Then heeft het antwoordbericht verwerking Geslaagd
Then is het antwoordbericht gelijk aan /testcases/bijhouding/VHNL/expected/VHNL02C680T10.xml voor expressie //brp:bhg_hgpRegistreerHuwelijkGeregistreerdPartnerschap_R

Then is in de database de persoon met bsn 690020041 wel als PARTNER betrokken bij een HUWELIJK
Then is in de database de persoon met bsn 373230217 wel als PARTNER betrokken bij een HUWELIJK

Then lees persoon met anummer 8240349473 uit database en vergelijk met expected VHNL02C680T10-persoon1.xml
Then lees persoon met anummer 9543058721 uit database en vergelijk met expected VHNL02C680T10-persoon2.xml






