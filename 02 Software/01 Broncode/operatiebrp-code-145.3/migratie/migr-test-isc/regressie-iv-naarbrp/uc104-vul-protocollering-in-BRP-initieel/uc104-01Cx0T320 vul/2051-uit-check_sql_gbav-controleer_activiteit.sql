SELECT COUNT(*) AS aantal_activiteit
FROM public.activiteit 
WHERE activiteit_type='101'
AND activiteit_subtype='1226'
AND start_dt='2013-01-01 12:00:00.0'
AND laatste_actie_dt='2013-01-01 12:00:00.0'
AND communicatie_partner='510001';