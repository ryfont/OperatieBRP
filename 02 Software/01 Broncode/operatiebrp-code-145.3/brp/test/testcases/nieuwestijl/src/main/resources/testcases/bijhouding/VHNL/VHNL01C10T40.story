Meta:
@status                 Klaar
@usecase                UCS-BY.HG

Narrative: R1861 H/GP mag alleen door betrokken gemeente worden geregistreerd

Scenario:   Huwelijk wordt door de voortzettende gemeente van de "Relatie.Gemeente aanvang" geregistreerd
            LT: VHNL01C10T40

Given alle personen zijn verwijderd
Given enkel initiele vulling uit bestand /LO3PL/VHNL01C10T40-001.xls
Given enkel initiele vulling uit bestand /LO3PL/VHNL01C10T40-002.xls

When voer een bijhouding uit VHNL01C10T40.xml namens partij 'Gemeente BRP 1'

Then heeft het antwoordbericht verwerking Geslaagd
Then is het antwoordbericht gelijk aan /testcases/bijhouding/VHNL/expected/VHNL01C10T40.xml voor expressie //brp:bhg_hgpRegistreerHuwelijkGeregistreerdPartnerschap_R
