Meta:
@status                 Klaar
@usecase                UCS-BY.HG


Narrative: Waarschuwing indien de gerelateerde gegevens van een persoon wijzigen en deze persoon voorkomt als een pseudo-persoon op de persoonslijst van een ander.

Scenario:   1. DB init scenario om uitgangssituatie te zetten
            preconditie

Given alle personen zijn verwijderd

Scenario: 2. Ontbinding van een huwelijk tussen 2 ingeschrevenen + ontrelateren en daarna en daarna een huwelijk met een geslachtsnaamwijziging
          preconditie

Given enkel initiele vulling uit bestand /LO3PL/VHNL01C410T70-001.xls
Given enkel initiele vulling uit bestand /LO3PL/VHNL01C410T70-002.xls
Given enkel initiele vulling uit bestand /LO3PL/VHNL01C410T70-003.xls

When voer een bijhouding uit VHNL01C410T70a.xml namens partij 'Gemeente BRP 1'

Then heeft het antwoordbericht verwerking Geslaagd
Then is het antwoordbericht gelijk aan /testcases/bijhouding/VHNL/expected/VHNL01C410T70a.xml voor expressie //brp:bhg_hgpRegistreerHuwelijkGeregistreerdPartnerschap_R

Given pas laatste relatie van soort 1 aan tussen persoon 834553673 en persoon 729889993 met relatie id 30010001 en betrokkenheid id 30010001

Then is in de database de persoon met bsn 834553673 wel als PARTNER betrokken bij een HUWELIJK
Then is in de database de persoon met bsn 729889993 wel als PARTNER betrokken bij een HUWELIJK

Given de database is aangepast met: delete from autaut.his_bijhouderfiatuitz where id =99999
And de database is aangepast met: delete from autaut.bijhouderfiatuitz where id =99999
And de database is aangepast met: insert into autaut.bijhouderfiatuitz (id,bijhouder, datingang, dateinde, bijhouderbijhvoorstel, srtdoc, srtadmhnd, indblok) values (99999, (select id from kern.partijrol where partij = (select id from kern.partij where naam = 'Gemeente BRP 3') and rol=2), null , null , (select id from kern.partijrol where partij = (select id from kern.partij where naam = 'Gemeente BRP 1') and rol=2), null, null, null)
And de database is aangepast met: insert into autaut.his_bijhouderfiatuitz (id, bijhouderfiatuitz, tsreg, tsverval, datingang, dateinde, bijhouderbijhvoorstel, srtdoc, srtadmhnd, indblok) values(99999, 99999, now() at time zone 'UTC', null, 19990101, null, (select id from kern.partijrol where partij = (select id from kern.partij where naam = 'Gemeente BRP 1') and rol=2), null, null, null)

When voer een bijhouding uit VHNL01C410T70b.xml namens partij 'Gemeente BRP 1'

Then heeft het antwoordbericht verwerking Geslaagd
Then is het antwoordbericht gelijk aan /testcases/bijhouding/VHNL/expected/VHNL01C410T70b.xml voor expressie //brp:bhg_hgpRegistreerHuwelijkGeregistreerdPartnerschap_R

Then in kern heeft select count(1) from kern.his_betr hr join kern.actie ainh on ainh.id = hr.actieinh LEFT join kern.actie av on av.id = hr.actieverval where ainh.srt in (58) and av.srt is NULL de volgende gegevens:
| veld                      | waarde |
| count                     | 4      |

Then in kern heeft select count(1) from kern.his_betr hr join kern.actie ainh on ainh.id = hr.actieinh LEFT join kern.actie av on av.id = hr.actieverval where ainh.srt in (32) and av.srt in (58) de volgende gegevens:
| veld                      | waarde |
| count                     | 2      |

Scenario: 3. Hertrouwen van dezelfde personen inclusief geslachtsnaamwijziging
          LT: VHNL01C410T70

When voer een bijhouding uit VHNL01C410T70c.xml namens partij 'Gemeente BRP 1'

Then heeft het antwoordbericht verwerking Geslaagd
Then is het antwoordbericht gelijk aan /testcases/bijhouding/VHNL/expected/VHNL01C410T70c.xml voor expressie //brp:bhg_hgpRegistreerHuwelijkGeregistreerdPartnerschap_R


Scenario: 4. DB reset scenario om de aangepaste data weer terug te zetten
          postconditie

Given de database is aangepast met: delete from autaut.his_bijhouderfiatuitz where id =99999
And de database is aangepast met: delete from autaut.bijhouderfiatuitz where id =99999