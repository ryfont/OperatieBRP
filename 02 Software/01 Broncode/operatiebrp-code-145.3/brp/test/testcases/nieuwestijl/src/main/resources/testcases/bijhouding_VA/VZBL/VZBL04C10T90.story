Meta:
@status                 Klaar
@usecase                UCS-BY.0.VA

Narrative: Registratie verhuizing buitenland

Scenario:   Verwerking Hoofdactie Registratie migratie. Reden wijziging Ambtshalve en landgebied 0000 onbekend.
            LT: VZBL04C10T90

Given alle personen zijn verwijderd
Given enkel initiele vulling uit bestand /LO3PL-VA/LO3PL-VZBL/VZBL04C10T90.xls

When voer een bijhouding uit VZBL04C10T90.xml namens partij 'Gemeente BRP 1'

Then heeft het antwoordbericht verwerking Geslaagd

Then is het antwoordbericht gelijk aan /testcases/bijhouding_VA/VZBL/expected/VZBL04C10T90.xml voor expressie //brp:bhg_vbaRegistreerVerhuizing_R

Then in kern heeft SELECT COUNT(id) FROM kern.admhnd de volgende gegevens:
| veld                      | waarde |
| count                     | 2      |

!-- Controleer betrokken personen zijn gemarkeerd als bijgehouden
Then in kern heeft select sainh.naam as actieInhoud, saav.naam as actieVerval, p.bsn, sa.naam as AdmhndNaam, hpaf.sorteervolgorde
                   from kern.his_persafgeleidadministrati hpaf
                   join kern.actie ainh on ainh.id = hpaf.actieinh
                   left join kern.actie av on av.id = hpaf.actieverval
                   left join kern.srtactie sainh on ainh.srt = sainh.id
                   left join kern.srtactie saav on av.srt = saav.id
                   left join kern.pers p on hpaf.pers = p.id
                   left join kern.admhnd a on hpaf.admhnd = a.id
                   left join kern.srtadmhnd sa on a.srt = sa.id
                   where sainh.naam ='Registratie migratie'
                   order by p.bsn de volgende gegevens:
| veld                      | waarde                                        |
| actieinhoud               | Registratie migratie                          |
| actieverval               | NULL                                          |
| bsn                       | 203832073                                     |
| admhndnaam                | Verhuizing naar buitenland                    |
| sorteervolgorde           | 1                                             |

!-- Controleer Persoon.Migratie
Then in kern heeft select srtmigratie,
                          dataanvgel,
                          rdnwijzmigratie,
                          landgebiedmigratie
                          from kern.his_persmigratie
 de volgende gegevens:
| veld                      | waarde                             |
| srtmigratie               | 2                                  |
| dataanvgel                | 20170101                           |
| rdnwijzmigratie           | 2                                  |
| landgebiedmigratie        | 255                                |

!-- Controleer Persoon.Migratie
Then in kern heeft select sm.naam as soortMigratie,
                          pm.dataanvgel as dataanvgel,
                          rwv.naam as redenWijzigenMigratie,
                          lg.naam as Land
                          from kern.his_persmigratie pm
                          join kern.rdnwijzverblijf rwv on pm.rdnwijzmigratie=rwv.id
                          join kern.srtmigratie sm on pm.srtmigratie=sm.id
                          join kern.landgebied lg on pm.landgebiedmigratie=lg.id
			  where landgebiedmigratie in (select id from kern.landgebied where naam='Onbekend')
 de volgende gegevens:
| veld                      | waarde                             |
| soortMigratie             | Emigratie                          |
| dataanvgel                | 20170101                           |
| redenWijzigenMigratie     | Ambtshalve                         |
| Land                      | Onbekend                           |

!-- Controleer Persoon.Deelname EU verkiezingen
Then in kern heeft select count(*)
                   from   kern.his_persdeelneuverkiezingen
		   where  tsverval in (select tsreg from kern.his_persmigratie)
		   and    actieverval in (select actieinh from kern.his_persmigratie)
                   and    pers in (select id from kern.pers where voornamen='Anne')
de volgende gegevens:
| veld  | waarde |
| count | 1      |

!-- Controleer Persoon.Bijhouding dat nadere bijhaard 5 is ("Vertrokken onbekend waarheen")
Then in kern heeft select count(*)
                   from   kern.his_persbijhouding
                   where  bijhaard=2
                   and    naderebijhaard=5
                   and    bijhpartij=3
                   and    dataanvgel in (select dataanvgel from kern.his_persmigratie)
                   and    actieinh in (select actieinh from kern.his_persmigratie)
de volgende gegevens:
| veld  | waarde |
| count | 1      |


!-- Controleer Persoon.Bijhouding dat nadere bijhaard V ("Vertrokken onbekend waarheen") is
Then in kern heeft select count(*)
                   from   kern.his_persbijhouding
                   where  bijhaard in (select id from kern.bijhaard where code='N')
                   and    naderebijhaard in (select id from kern.naderebijhaard where code='V')
                   and    bijhpartij in (select id from kern.partij where naam='Minister')
                   and    dataanvgel in (select dataanvgel from kern.his_persmigratie)
                   and    actieinh in (select actieinh from kern.his_persmigratie)
de volgende gegevens:
| veld  | waarde |
| count | 1      |

!-- Controleer Persoon Adres.Standaard
Then in kern heeft select count(*) from kern.his_persadres
                   where  dateindegel in (select dataanvgel from kern.his_persmigratie)
                   and    actieaanpgel in (select actieinh from kern.his_persmigratie)
de volgende gegevens:
| veld  | waarde |
| count | 1      |
