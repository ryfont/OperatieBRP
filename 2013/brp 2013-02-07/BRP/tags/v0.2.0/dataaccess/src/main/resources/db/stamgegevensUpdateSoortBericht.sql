-- RvdP Versie: 3 september 2012.
-- RvdP: Soort Bericht wordt voorlopig NIET (geheel)in het BMR beheerd.
-- Om die reden vind hier een 'patch' plaats:
-- Verwijder alle soorten berichten, en vul de gewenste waarden:
delete from Ber.SrtBer ;
INSERT INTO Ber.SrtBer (ID, Naam) VALUES (1, 'Migratie Verhuizing Bijhouding');
INSERT INTO Ber.SrtBer (ID, Naam) VALUES (2, 'Migratie Verhuizing BijhoudingAntwoord');
INSERT INTO Ber.SrtBer (ID, Naam) VALUES (3, 'Migratie CorrectieAdresBinnenNL Bijhouding');
INSERT INTO Ber.SrtBer (ID, Naam) VALUES (4, 'Migratie CorrectieAdresBinnenNL BijhoudingAntwoord');
INSERT INTO Ber.SrtBer (ID, Naam) VALUES (5, 'Afstamming InschrijvingAangifteGeboorte Bijhouding');
INSERT INTO Ber.SrtBer (ID, Naam) VALUES (6, 'Afstamming InschrijvingAangifteGeboorte BijhoudingAntwoord');
INSERT INTO Ber.SrtBer (ID, Naam) VALUES (7, 'HuwelijkPartnerschap RegistratieHuwelijk Bijhouding');
INSERT INTO Ber.SrtBer (ID, Naam) VALUES (8, 'HuwelijkPartnerschap RegistratieHuwelijk BijhoudingAntwoord');
INSERT INTO Ber.SrtBer (ID, Naam) VALUES (9, 'HuwelijkPartnerschap RegistratiePartnerschap Bijhouding');
INSERT INTO Ber.SrtBer (ID, Naam) VALUES (10, 'HuwelijkPartnerschap RegistratiePartnerschap BijhoudingAntwoord');
INSERT INTO Ber.SrtBer (ID, Naam) VALUES (11, 'VraagDetailsPersoonHuwelijkPartnerschap Bevragen');
INSERT INTO Ber.SrtBer (ID, Naam) VALUES (12, 'VraagDetailsPersoonHuwelijkPartnerschap BevragenAntwoord');
INSERT INTO Ber.SrtBer (ID, Naam) VALUES (13, 'Vraag PersonenOpAdresInclusiefBetrokkenheden Bevragen');
INSERT INTO Ber.SrtBer (ID, Naam) VALUES (14, 'Vraag PersonenOpAdresInclusiefBetrokkenheden BevragenAntwoord');
INSERT INTO Ber.SrtBer (ID, Naam) VALUES (15, 'Vraag KandidaatVader Bevragen');
INSERT INTO Ber.SrtBer (ID, Naam) VALUES (16, 'Vraag KandidaatVader BevragenAntwoord');
-- NB: Naamgeving is een punt-van-aandacht:
-- er zit verschillende informatie in de naam (module [migratie, afstamming, ..., vraag], soort (bijhouding, bevragen), richting (..., ...Antwoord)
-- Best denkbaar om deze expliciet uit te modelleren.
