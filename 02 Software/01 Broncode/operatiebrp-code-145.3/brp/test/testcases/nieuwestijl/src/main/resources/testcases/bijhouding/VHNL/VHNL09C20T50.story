Meta:
@status                 Klaar
@usecase                UCS-BY.HG

Narrative:
Datumformaten. d mmmm yyyy als formaat voor de geboortedatum

Scenario:   Datumformaten. d mmmm yyyy als formaat voor de geboortedatum
            LT: VHNL09C20T50

Given alle personen zijn verwijderd
Given enkel initiele vulling uit bestand /LO3PL/Libby.xls

When voer een bijhouding uit VHNL09C20T50.xml namens partij 'Gemeente BRP 1'

Then is het foutief antwoordbericht gelijk aan /testcases/bijhouding/VHNL/expected/VHNL09C20T50.txt

Then is in de database de persoon met bsn 422531881 niet als PARTNER betrokken bij een HUWELIJK