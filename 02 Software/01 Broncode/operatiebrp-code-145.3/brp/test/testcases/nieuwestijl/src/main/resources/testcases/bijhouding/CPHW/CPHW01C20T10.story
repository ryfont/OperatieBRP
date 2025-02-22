Meta:
@status                 Klaar
@usecase                UCS-BY.HG

Narrative: R2521 Alle acties moeten betrekking hebben op dezelfde gerelateerde persoon

Scenario: 1. DB init
          preconditie

Given de database is aangepast met: insert into kern.rechtsgrond
                                    (
                                        "code",
					"oms",
					"indleidttotstrijdigheid",
				        "dataanvgel"
				    )
				    select '111',
				           'Omschrijving rechtsgrond',
					    true,
					    to_number((to_char(now() - interval '1 day', 'YYYYMMDD')), '99999999')
				    where not exists
				    (
					select id
					from   kern.rechtsgrond
				        where  code='111'
				    )

Given maak bijhouding caches leeg

Scenario:   2. Een actie heeft betrekking op een ander persoon
            LT: CPHW01C20T10

Given alle personen zijn verwijderd

!-- Vulling van de partners
Given enkel initiele vulling uit bestand /LO3PL-CPHW/CPHW01C20T10-001.xls
Given enkel initiele vulling uit bestand /LO3PL-CPHW/CPHW01C20T10-002.xls
Given enkel initiele vulling uit bestand /LO3PL-CPHW/CPHW01C20T10-003.xls
Given enkel initiele vulling uit bestand /LO3PL-CPHW/CPHW01C20T10-004.xls

Then heeft $PERSOON_BSN$ de waarde van de volgende query: select bsn from kern.pers where voornamen='Libby'
Then heeft $PARTNER_BSN$ de waarde van de volgende query: select bsn from kern.pers where voornamen='Piet'

Then heeft $PERSOON2_BSN$ de waarde van de volgende query: select bsn from kern.pers where voornamen='LibbyTwee'
Then heeft $PARTNER2_BSN$ de waarde van de volgende query: select bsn from kern.pers where voornamen='PietTwee'

!-- Voltrekking van een huwelijk
When voer een bijhouding uit CPHW01C20T10a.xml namens partij 'Gemeente BRP 1'
Then heeft het antwoordbericht verwerking Geslaagd

Given pas laatste relatie van soort 1 aan tussen persoon 729562761 en persoon 183702633 met relatie id 30010002 en betrokkenheid id 30010001
Given pas laatste relatie van soort 1 aan tussen persoon 183702633 en persoon 729562761 met relatie id 30010001 en betrokkenheid id 30010002
And de database is aangepast met: update kern.his_relatie set id = 9999 where id = (select hr.id from kern.his_relatie hr join kern.relatie r on r.id = hr.relatie where r.srt = 1 and hr.dataanv = 20160329)

!-- Voorkomensleutel voor identificatienummers
And de database is aangepast met: update kern.his_persids set id = 9998 where pers in (select id from kern.pers where voornamen='Piet')

Then heeft $RELATIE_ID$ de waarde van de volgende query: select r.id from kern.betr b join kern.relatie r on r.id = b.relatie join kern.pers p on b.pers = p.id where p.voornamen='Libby' and r.srt=1
Then heeft $BETROKKENHEID_PERS_ID$ de waarde van de volgende query: select b.id from kern.betr b join kern.relatie r on r.id = b.relatie join kern.pers p on b.pers = p.id where p.voornamen='Libby' and r.srt=1
Then heeft $BETROKKENHEID_PARTNER_ID$ de waarde van de volgende query: select b.id from kern.betr b join kern.relatie r on r.id = b.relatie join kern.pers p on b.pers = p.id where p.voornamen='Piet' and r.srt=1

Then is in de database de persoon met bsn 729562761 wel als PARTNER betrokken bij een HUWELIJK
Then is in de database de persoon met bsn 183702633 wel als PARTNER betrokken bij een HUWELIJK

!-- Voltrekking van een ander huwelijk
When voer een bijhouding uit CPHW01C20T10b.xml namens partij 'Gemeente BRP 1'
Then heeft het antwoordbericht verwerking Geslaagd

Given pas laatste relatie van soort 1 aan tussen persoon 426588137 en persoon 861886409 met relatie id 30010004 en betrokkenheid id 30010003
Given pas laatste relatie van soort 1 aan tussen persoon 861886409 en persoon 426588137 met relatie id 30010003 en betrokkenheid id 30010004
And de database is aangepast met: update kern.his_relatie set id = 8888 where id = (select hr.id from kern.his_relatie hr join kern.relatie r on r.id = hr.relatie where r.srt = 1 and hr.dataanv = 20160330)

!-- Voorkomensleutel voor identificatienummers
And de database is aangepast met: update kern.his_persids set id = 8887 where pers in (select id from kern.pers where voornamen='PietTwee')

Then heeft $RELATIE2_ID$ de waarde van de volgende query: select r.id from kern.betr b join kern.relatie r on r.id = b.relatie join kern.pers p on b.pers = p.id where p.voornamen='LibbyTwee' and r.srt=1
Then heeft $BETROKKENHEID2_PERS_ID$ de waarde van de volgende query: select b.id from kern.betr b join kern.relatie r on r.id = b.relatie join kern.pers p on b.pers = p.id where p.voornamen='LibbyTwee' and r.srt=1
Then heeft $BETROKKENHEID2_PARTNER_ID$ de waarde van de volgende query: select b.id from kern.betr b join kern.relatie r on r.id = b.relatie join kern.pers p on b.pers = p.id where p.voornamen='PietTwee' and r.srt=1

Then is in de database de persoon met bsn 426588137 wel als PARTNER betrokken bij een HUWELIJK
Then is in de database de persoon met bsn 861886409 wel als PARTNER betrokken bij een HUWELIJK

!-- Correctie partnergegevens bij verschillende huwelijken
When voer een bijhouding uit CPHW01C20T10c.xml namens partij 'Gemeente BRP 1'
Then heeft het antwoordbericht verwerking Foutief
Then is het antwoordbericht gelijk aan /testcases/bijhouding/CPHW/expected/CPHW01C20T10.xml voor expressie //brp:bhg_hgpCorrigeerHuwelijkGeregistreerdPartnerschap_R

Scenario: 3. DB reset
             postconditie

Given de database is aangepast met: delete from kern.actiebron where rechtsgrond in (select id from kern.rechtsgrond where code='111')
Given de database is aangepast met: delete from kern.rechtsgrond where code='111'

Given maak bijhouding caches leeg