SELECT COUNT(*) AS aantal
FROM initvul.initvullingresult_protocollering
WHERE activiteit_id=(SELECT activiteit_id FROM public.activiteit WHERE activiteit_type=101 AND activiteit_subtype=1211)
AND pers_id=(SELECT id FROM kern.pers WHERE anr='9607472929')
AND bijhouding_opschort_reden = 'E'
AND toeganglevsautorisatie_id=(SELECT id FROM autaut.toeganglevsautorisatie WHERE levsautorisatie=(SELECT id FROM autaut.levsautorisatie WHERE naam='510248' AND datingang='20040101' AND dateinde='20050102'))
AND toeganglevsautorisatie_count=1
AND start_dt='2005-01-01 12:00:00.0'
AND laatste_actie_dt='2005-01-01 12:00:00.0'
AND conversie_resultaat='TE_VERZENDEN'
AND foutmelding IS NULL;