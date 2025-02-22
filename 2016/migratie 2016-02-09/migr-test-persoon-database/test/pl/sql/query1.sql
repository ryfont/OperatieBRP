--PL en gerelateerden
select pers.anr, pers.voornamen, pers.voorvoegsel, pers.geslnaam, pers.id as pers_id, srtpers.naam, betr.id as betr_id, srtbetr.naam, relatie.id as relatie_id, srtrelatie.naam
from kern.pers as pers
left outer join kern.betr as betr on betr.pers = pers.id
left outer join kern.srtpers on srtpers.id = pers.srt
left outer join kern.srtbetr on srtbetr.id = betr.rol
left outer join kern.relatie on relatie.id = betr.relatie
left outer join kern.srtrelatie on relatie.srt = srtrelatie.id
left outer join kern.multirealiteitregel on multirealiteitregel.geldigvoor = pers.id and multirealiteitregel.relatie = relatie.id
order by relatie.id, pers.id;
