Meta:
@status                 Klaar
@sleutelwoorden         geefDetailsPersoon
@auteur                 dihoe

Narrative:
Bevraging, geef details persoon - bijhouding

Scenario: 1.

Given bijhoudingautorisatie uit /bijhoudingsautorisaties/Gemeente_Tiel.txt
Given bijhoudingsverzoek voor partij 'Gemeente Tiel'

Given de personen 826933129,526521673,839271177 zijn verwijderd
Given de standaardpersoon Sandy met bsn 839271177 en anr 4718796562 zonder extra gebeurtenissen

And verzoek van bericht bhg_bvgGeefDetailsPersoon
And testdata uit bestand geef_details_persoon_01.yml
And extra waardes:
| SLEUTEL                                 | WAARDE    |
| stuurgegevens.zendendePartij            | 028101    |
| zoekcriteriaPersoon.burgerservicenummer | 839271177 |

When het bericht wordt verstuurd
Then heeft het antwoordbericht verwerking Geslaagd
And hebben in het antwoordbericht de attributen in de groepen de volgende waardes:
| groep                | attribuut           | verwachteWaardes                |
| identificatienummers | burgerservicenummer | 839271177, 826933129, 526521673 |
