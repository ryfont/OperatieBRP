Meta:
@status                 Klaar
@usecase                UCS-BY.0.AS

Narrative: R1707 Nationaliteit moet verwijzen naar geldig stamgegeven

Scenario: 1. DB init
          preconditie


Given de database is aangepast met: update kern.nation set dateindegel = '20170101', dataanvgel = '20160102' where code = '0453'
Given maak bijhouding caches leeg


Scenario: 2. peildatum is eerder dan DAG van stamgegeven.
          LT: GBNL01C80T40

Given alle personen zijn verwijderd
Given enkel initiele vulling uit bestand /LO3PL-AS/LO3PL-GBNL/GBNL01C80-001.xls
Given enkel initiele vulling uit bestand /LO3PL-AS/LO3PL-GBNL/GBNL01C80-002.xls



When voer een bijhouding uit GBNL01C80T40.xml namens partij 'Gemeente BRP 1'

Then heeft het antwoordbericht verwerking Foutief
Then is het antwoordbericht gelijk aan /testcases/bijhouding_AS/GBNL/expected/GBNL01C80T40.xml voor expressie //brp:bhg_afsRegistreerGeboorte_R

Scenario: 3. DB reset
          postconditie
Given de database is aangepast met: update kern.nation set dateindegel = '20030204', dataanvgel = '20060603' where code = '0453'
Given maak bijhouding caches leeg