select distinct 
  p1.bsn bsn, 
  pa1.srt srt,
  pa1.rdnwijz rdnwijz,
  pa1.aangadresh aangadresh,
  pa1.dataanvadresh dataanvadresh,
  pa1.adresseerbaarobject adresseerbaarobject,
  pa1.identcodenraand identcodenraand,
  coalesce(pa1.gem),
  coalesce(pa1.nor),
  pa1.afgekortenor afgekortenor,
  pa1.gemdeel gemdeel,
  coalesce(pa1.huisnr) huisnr,
  coalesce(pa1.huisletter) huisletter,
  coalesce(pa1.huisnrtoevoeging) huisnrtoevoeging,
  coalesce(pa1.postcode) postcode,
  pa1.wpl wpl,
  pa1.loctovadres loctovadres,
  pa1.locoms locoms,
  pa1.bladresregel1 bladresregel1,
  pa1.bladresregel2 bladresregel2,
  pa1.bladresregel3 bladresregel3,
  pa1.bladresregel4 bladresregel4,
  pa1.bladresregel5 bladresregel5,
  pa1.bladresregel6 bladresregel6,
  pa1.land land,
  pa1.datvertrekuitnederland datvertrekuitnederland,
  pa1.persadresstatushis persadresstatushis,
  pa1.id id,
  pa1.pers pers 
from  
  kern.pers p1, 
  kern.pers p2,
  kern.persadres pa1 FULL outer join kern.persadres pa2 on ( 
  pa1.huisnrtoevoeging = pa2.huisnrtoevoeging or 
  pa1.nor = pa2.nor or 
  pa1.huisnr = pa2.huisnr or 
  pa1.postcode = pa2.postcode or
  pa1.huisletter = pa2.huisletter )  
where 
  pa2.pers = p2.id and 
  pa1.pers = p1.id and 
  (pa1.huisnr = ${DataSource Values#huisnummer_zvb0} and 
  pa1.gem = ${DataSource Values#gemeenteCode_zvb0} and
  pa1.nor = ${DataSource Values#naamOpenbareRuimte_zvb0} and 
  pa1.huisletter =${DataSource Values#huisletter_zvb0} and
  pa1.huisnrtoevoeging = ${DataSource Values#huisnrtoevoeging_zvb0} and
  pa1.postcode = ${DataSource Values#postcode_zvb0})
order by pa1.id;