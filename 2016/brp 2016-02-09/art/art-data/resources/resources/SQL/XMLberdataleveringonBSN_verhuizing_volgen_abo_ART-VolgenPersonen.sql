SELECT DISTINCT
  b.id,
  b.ontvangendepartij,
  b.abonnement,
  b.data
FROM
  ber.ber b
  join ber.berpers on b.id = berpers.ber

WHERE
	--b.id moet groter zijn dan het b.id van het laatste request met referentienummer
	b.id > (select max(id) 
		from ber.ber 
		where ber.referentienr = '${DataSource Values#referentienr_id}')
	AND berpers.pers = persoon_id_voor_bsn(${DataSource Values#|objectid.burgerservicenummer_ipv1|})
	AND b.abonnement = ${DataSource Values#abonnement_id}
	-- srt 23 betreft een leverbericht
	AND b.srt = 23
ORDER BY b.id DESC limit 1
