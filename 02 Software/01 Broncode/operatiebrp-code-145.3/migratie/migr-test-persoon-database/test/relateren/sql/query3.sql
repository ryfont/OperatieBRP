--MR Relatie
select multirealiteitregel.id as MR_ID, multirealiteitregel.geldigvoor, pers.anr, pers.voornamen, pers.voorvoegsel, pers.geslnaam, srtmultirealiteitregel.naam, multirealiteitregel.relatie, srtrelatie.naam
from kern.multirealiteitregel
join kern.relatie on multirealiteitregel.relatie = relatie.id
join kern.srtrelatie on srtrelatie.id = relatie.srt
join kern.pers on pers.id = multirealiteitregel.geldigvoor
join kern.srtmultirealiteitregel on multirealiteitregel.srt = srtmultirealiteitregel.id;
