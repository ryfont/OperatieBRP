SELECT h.* FROM autaut.levsautorisatie l
JOIN autaut.his_levsautorisatie h ON l.id = h.levsautorisatie
WHERE l.naam = 'Automatisch testscript 00C01T030 - Leveringsautorisatie gewijzigd' AND tsverval IS NULL AND h.tsreg IN (
    SELECT h.tsverval FROM autaut.levsautorisatie l
    JOIN autaut.his_levsautorisatie h ON l.id = h.levsautorisatie
    WHERE l.naam = 'Automatisch testscript 00C01T030 - Leveringsautorisatie gewijzigd' AND tsverval IS NOT NULL)