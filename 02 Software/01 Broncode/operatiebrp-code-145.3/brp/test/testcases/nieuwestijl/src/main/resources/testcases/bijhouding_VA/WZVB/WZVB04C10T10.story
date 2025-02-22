Meta:
@status                 Klaar
@usecase                UCS-BY.0.VA

Narrative: Verwerking Hoofdactie Registratie verblijfsrecht

Scenario: Registratie verblijfsrecht van ingezetene waarbij er nog geen verblijfsrecht is geregistreerd
          LT: WZVB04C10T10

Given alle personen zijn verwijderd
Given enkel initiele vulling uit bestand /LO3PL-VA/LO3PL-WZVB/WZVB04C10T10-001.xls

When voer een bijhouding uit WZVB04C10T10.xml namens partij 'Gemeente BRP 1'

Then heeft het antwoordbericht verwerking Geslaagd
Then is het antwoordbericht gelijk aan /testcases/bijhouding_VA/WZVB/expected/WZVB04C10T10.xml voor expressie //brp:bhg_vbaRegistreerVerblijfsrecht_R

!-- Controleer verantwoordingsgegevens van de ActieBron
Then in kern heeft select count(1),ab.doc
                   from kern.actiebron ab join kern.actie ainh on ainh.id = ab.actie left join kern.srtactie sainh on ainh.srt = sainh.id
                   where sainh.naam in ('Registratie verblijfsrecht') group by ab.doc de volgende gegevens:
| veld                      | waarde |
| count                     | 1      |

!-- Controleer persoon is bijgehouden in Afgeleid administratief
Then in kern heeft select sainh.naam as actieInhoud, saav.naam as actieVerval, p.bsn, sa.naam as AdmhndNaam, hpaf.sorteervolgorde
                   from kern.his_persafgeleidadministrati hpaf
                   join kern.actie ainh on ainh.id = hpaf.actieinh
                   left join kern.actie av on av.id = hpaf.actieverval
                   left join kern.srtactie sainh on ainh.srt = sainh.id
                   left join kern.srtactie saav on av.srt = saav.id
                   left join kern.pers p on hpaf.pers = p.id
                   left join kern.admhnd a on hpaf.admhnd = a.id
                   left join kern.srtadmhnd sa on a.srt = sa.id
                   where sainh.naam ='Registratie verblijfsrecht'
                   order by p.bsn de volgende gegevens:
| veld                      | waarde                                        |
| actieinhoud               | Registratie verblijfsrecht                    |
| actieverval               | NULL                                          |
| bsn                       | 176407881                                     |
| admhndnaam                | Wijziging verblijfsrecht                      |
| sorteervolgorde           | 1                                             |

!-- Controleer registratie van verblijfsrecht
Then in kern heeft select sainh.naam as actieInhoud, saav.naam as actieVerval, p.bsn, hpvb.aandverblijfsr, hpvb.dataanvverblijfsr, hpvb.datmededelingverblijfsr, hpvb.datvoorzeindeverblijfsr
                   from kern.his_persverblijfsr hpvb
                   join kern.actie ainh on ainh.id = hpvb.actieinh
                   left join kern.actie av on av.id = hpvb.actieverval
                   left join kern.srtactie sainh on ainh.srt = sainh.id
                   left join kern.srtactie saav on av.srt = saav.id
                   left join kern.pers p on hpvb.pers = p.id de volgende gegevens:
| veld                      | waarde                                        |
| actieinhoud               | Registratie verblijfsrecht                    |
| actieverval               | NULL                                          |
| bsn                       | 176407881                                     |
| aandverblijfsr            | 33                                            |
| dataanvverblijfsr         | 20160101                                      |
| datmededelingverblijfsr   | 20160102                                      |
| datvoorzeindeverblijfsr   | 20170101                                      |