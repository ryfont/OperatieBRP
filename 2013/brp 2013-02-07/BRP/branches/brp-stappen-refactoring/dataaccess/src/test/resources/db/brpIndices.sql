CREATE INDEX His_Authenticatiemiddel_ActieInh ON AutAut.His_Authenticatiemiddel (ActieInh);
CREATE INDEX His_Authenticatiemiddel_ActieVerval ON AutAut.His_Authenticatiemiddel (ActieVerval);
CREATE INDEX His_Autorisatiebesluit_ActieInh ON AutAut.His_Autorisatiebesluit (ActieInh);
CREATE INDEX His_Autorisatiebesluit_ActieVerval ON AutAut.His_Autorisatiebesluit (ActieVerval);
CREATE INDEX His_AutorisatiebesluitBijhau_ActieInh ON AutAut.His_AutorisatiebesluitBijhau (ActieInh);
CREATE INDEX His_AutorisatiebesluitBijhau_ActieVerval ON AutAut.His_AutorisatiebesluitBijhau (ActieVerval);
CREATE INDEX His_Bijhautorisatie_ActieInh ON AutAut.His_Bijhautorisatie (ActieInh);
CREATE INDEX His_Bijhautorisatie_ActieVerval ON AutAut.His_Bijhautorisatie (ActieVerval);
CREATE INDEX His_Bijhsituatie_ActieInh ON AutAut.His_Bijhsituatie (ActieInh);
CREATE INDEX His_Bijhsituatie_ActieVerval ON AutAut.His_Bijhsituatie (ActieVerval);
CREATE INDEX His_Doelbinding_ActieInh ON AutAut.His_Doelbinding (ActieInh);
CREATE INDEX His_Doelbinding_ActieVerval ON AutAut.His_Doelbinding (ActieVerval);
CREATE INDEX His_Doelbinding_ActieAanpGel ON AutAut.His_Doelbinding (ActieAanpGel);
CREATE INDEX His_Uitgeslotene_ActieInh ON AutAut.His_Uitgeslotene (ActieInh);
CREATE INDEX His_Uitgeslotene_ActieVerval ON AutAut.His_Uitgeslotene (ActieVerval);
CREATE INDEX His_Regelsituatie_ActieInh ON BRM.His_Regelsituatie (ActieInh);
CREATE INDEX His_Regelsituatie_ActieVerval ON BRM.His_Regelsituatie (ActieVerval);
CREATE INDEX His_Partij_ActieInh ON Kern.His_Partij (ActieInh);
CREATE INDEX His_Partij_ActieVerval ON Kern.His_Partij (ActieVerval);
CREATE INDEX His_PartijGem_ActieInh ON Kern.His_PartijGem (ActieInh);
CREATE INDEX His_PartijGem_ActieVerval ON Kern.His_PartijGem (ActieVerval);
CREATE INDEX His_Abonnement_ActieInh ON Lev.His_Abonnement (ActieInh);
CREATE INDEX His_Abonnement_ActieVerval ON Lev.His_Abonnement (ActieVerval);
CREATE INDEX His_AbonnementSrtBer_ActieInh ON Lev.His_AbonnementSrtBer (ActieInh);
CREATE INDEX His_AbonnementSrtBer_ActieVerval ON Lev.His_AbonnementSrtBer (ActieVerval);
CREATE INDEX Lev_GebaseerdOp ON Lev.Lev (GebaseerdOp);
CREATE INDEX LevCommunicatie_UitgaandBer ON Lev.LevCommunicatie (UitgaandBer);
CREATE INDEX LevPers_Pers ON Lev.LevPers (Pers);
CREATE INDEX Ber_AntwoordOp ON Ber.Ber (AntwoordOp);
CREATE INDEX BerActie_Ber ON Ber.BerActie (Ber);
CREATE INDEX BerActie_Actie ON Ber.BerActie (Actie);
CREATE INDEX BerBijgehoudenPers_Ber ON Ber.BerBijgehoudenPers (Ber);
CREATE INDEX BerBijgehoudenPers_Pers ON Ber.BerBijgehoudenPers (Pers);
CREATE INDEX BerMelding_Ber ON Ber.BerMelding (Ber);
CREATE INDEX BerMelding_Melding ON Ber.BerMelding (Melding);
CREATE INDEX BerOverrule_Ber ON Ber.BerOverrule (Ber);
CREATE INDEX BerOverrule_Overrule ON Ber.BerOverrule (Overrule);
--CREATE INDEX Actie_AdministratieveHnd ON Kern.Actie (AdministratieveHnd);
CREATE INDEX Betr_Relatie ON Kern.Betr (Relatie);
CREATE INDEX Betr_Pers ON Kern.Betr (Pers);
-- CREATE INDEX Bron_Actie ON Kern.Bron (Actie);
-- CREATE INDEX Bron_Doc ON Kern.Bron (Doc);
CREATE INDEX GegevenInOnderzoek_Onderzoek ON Kern.GegevenInOnderzoek (Onderzoek);
CREATE INDEX MultiRealiteitRegel_GeldigVoor ON Kern.MultiRealiteitRegel (GeldigVoor);
CREATE INDEX MultiRealiteitRegel_Pers ON Kern.MultiRealiteitRegel (Pers);
CREATE INDEX MultiRealiteitRegel_MultiRealiteitPers ON Kern.MultiRealiteitRegel (MultiRealiteitPers);
CREATE INDEX MultiRealiteitRegel_Relatie ON Kern.MultiRealiteitRegel (Relatie);
CREATE INDEX MultiRealiteitRegel_Betr ON Kern.MultiRealiteitRegel (Betr);
CREATE INDEX Pers_VorigePers ON Kern.Pers (VorigePers);
CREATE INDEX Pers_VolgendePers ON Kern.Pers (VolgendePers);
CREATE INDEX PersAdres_Pers ON Kern.PersAdres (Pers);
CREATE INDEX PersGeslnaamcomp_Pers ON Kern.PersGeslnaamcomp (Pers);
CREATE INDEX PersIndicatie_Pers ON Kern.PersIndicatie (Pers);
CREATE INDEX PersNation_Pers ON Kern.PersNation (Pers);
CREATE INDEX PersOnderzoek_Pers ON Kern.PersOnderzoek (Pers);
CREATE INDEX PersOnderzoek_Onderzoek ON Kern.PersOnderzoek (Onderzoek);
CREATE INDEX PersReisdoc_Pers ON Kern.PersReisdoc (Pers);
CREATE INDEX PersVerificatie_Geverifieerde ON Kern.PersVerificatie (Geverifieerde);
CREATE INDEX PersVoornaam_Pers ON Kern.PersVoornaam (Pers);
CREATE INDEX Regelverantwoording_Actie ON Kern.Regelverantwoording (Actie);
--CREATE INDEX Verantwoording_Actie ON Kern.Verantwoording (Actie);
--CREATE INDEX Verantwoording_Doc ON Kern.Verantwoording (Doc);
CREATE INDEX His_OuderOuderlijkGezag_Betr ON Kern.His_OuderOuderlijkGezag (Betr);
CREATE INDEX His_OuderOuderlijkGezag_ActieInh ON Kern.His_OuderOuderlijkGezag (ActieInh);
CREATE INDEX His_OuderOuderlijkGezag_ActieVerval ON Kern.His_OuderOuderlijkGezag (ActieVerval);
CREATE INDEX His_OuderOuderlijkGezag_ActieAanpGel ON Kern.His_OuderOuderlijkGezag (ActieAanpGel);
CREATE INDEX His_OuderOuderschap_Betr ON Kern.His_OuderOuderschap (Betr);
CREATE INDEX His_OuderOuderschap_ActieInh ON Kern.His_OuderOuderschap (ActieInh);
CREATE INDEX His_OuderOuderschap_ActieVerval ON Kern.His_OuderOuderschap (ActieVerval);
CREATE INDEX His_OuderOuderschap_ActieAanpGel ON Kern.His_OuderOuderschap (ActieAanpGel);
CREATE INDEX His_Doc_Doc ON Kern.His_Doc (Doc);
CREATE INDEX His_Doc_ActieInh ON Kern.His_Doc (ActieInh);
CREATE INDEX His_Doc_ActieVerval ON Kern.His_Doc (ActieVerval);
CREATE INDEX His_MultiRealiteitRegel_MultiRealiteitRegel ON Kern.His_MultiRealiteitRegel (MultiRealiteitRegel);
CREATE INDEX His_MultiRealiteitRegel_ActieInh ON Kern.His_MultiRealiteitRegel (ActieInh);
CREATE INDEX His_MultiRealiteitRegel_ActieVerval ON Kern.His_MultiRealiteitRegel (ActieVerval);
CREATE INDEX His_Onderzoek_Onderzoek ON Kern.His_Onderzoek (Onderzoek);
CREATE INDEX His_Onderzoek_ActieInh ON Kern.His_Onderzoek (ActieInh);
CREATE INDEX His_Onderzoek_ActieVerval ON Kern.His_Onderzoek (ActieVerval);
CREATE INDEX His_PersAanschr_Pers ON Kern.His_PersAanschr (Pers);
CREATE INDEX His_PersAanschr_ActieInh ON Kern.His_PersAanschr (ActieInh);
CREATE INDEX His_PersAanschr_ActieVerval ON Kern.His_PersAanschr (ActieVerval);
CREATE INDEX His_PersAanschr_ActieAanpGel ON Kern.His_PersAanschr (ActieAanpGel);
CREATE INDEX His_PersBijhgem_Pers ON Kern.His_PersBijhgem (Pers);
CREATE INDEX His_PersBijhgem_ActieInh ON Kern.His_PersBijhgem (ActieInh);
CREATE INDEX His_PersBijhgem_ActieVerval ON Kern.His_PersBijhgem (ActieVerval);
CREATE INDEX His_PersBijhgem_ActieAanpGel ON Kern.His_PersBijhgem (ActieAanpGel);
CREATE INDEX His_PersBijhaard_Pers ON Kern.His_PersBijhaard (Pers);
CREATE INDEX His_PersBijhaard_ActieInh ON Kern.His_PersBijhaard (ActieInh);
CREATE INDEX His_PersBijhaard_ActieVerval ON Kern.His_PersBijhaard (ActieVerval);
CREATE INDEX His_PersBijhaard_ActieAanpGel ON Kern.His_PersBijhaard (ActieAanpGel);
CREATE INDEX His_PersEUVerkiezingen_Pers ON Kern.His_PersEUVerkiezingen (Pers);
CREATE INDEX His_PersEUVerkiezingen_ActieInh ON Kern.His_PersEUVerkiezingen (ActieInh);
CREATE INDEX His_PersEUVerkiezingen_ActieVerval ON Kern.His_PersEUVerkiezingen (ActieVerval);
CREATE INDEX His_PersGeboorte_Pers ON Kern.His_PersGeboorte (Pers);
CREATE INDEX His_PersGeboorte_ActieInh ON Kern.His_PersGeboorte (ActieInh);
CREATE INDEX His_PersGeboorte_ActieVerval ON Kern.His_PersGeboorte (ActieVerval);
CREATE INDEX His_PersGeslachtsaand_Pers ON Kern.His_PersGeslachtsaand (Pers);
CREATE INDEX His_PersGeslachtsaand_ActieInh ON Kern.His_PersGeslachtsaand (ActieInh);
CREATE INDEX His_PersGeslachtsaand_ActieVerval ON Kern.His_PersGeslachtsaand (ActieVerval);
CREATE INDEX His_PersGeslachtsaand_ActieAanpGel ON Kern.His_PersGeslachtsaand (ActieAanpGel);
CREATE INDEX His_PersIDs_Pers ON Kern.His_PersIDs (Pers);
CREATE INDEX His_PersIDs_ActieInh ON Kern.His_PersIDs (ActieInh);
CREATE INDEX His_PersIDs_ActieVerval ON Kern.His_PersIDs (ActieVerval);
CREATE INDEX His_PersIDs_ActieAanpGel ON Kern.His_PersIDs (ActieAanpGel);
CREATE INDEX His_PersImmigratie_Pers ON Kern.His_PersImmigratie (Pers);
CREATE INDEX His_PersImmigratie_ActieInh ON Kern.His_PersImmigratie (ActieInh);
CREATE INDEX His_PersImmigratie_ActieVerval ON Kern.His_PersImmigratie (ActieVerval);
CREATE INDEX His_PersImmigratie_ActieAanpGel ON Kern.His_PersImmigratie (ActieAanpGel);
CREATE INDEX His_PersInschr_Pers ON Kern.His_PersInschr (Pers);
CREATE INDEX His_PersInschr_ActieInh ON Kern.His_PersInschr (ActieInh);
CREATE INDEX His_PersInschr_ActieVerval ON Kern.His_PersInschr (ActieVerval);
CREATE INDEX His_PersInschr_VorigePers ON Kern.His_PersInschr (VorigePers);
CREATE INDEX His_PersInschr_VolgendePers ON Kern.His_PersInschr (VolgendePers);
CREATE INDEX His_PersOpschorting_Pers ON Kern.His_PersOpschorting (Pers);
CREATE INDEX His_PersOpschorting_ActieInh ON Kern.His_PersOpschorting (ActieInh);
CREATE INDEX His_PersOpschorting_ActieVerval ON Kern.His_PersOpschorting (ActieVerval);
CREATE INDEX His_PersOpschorting_ActieAanpGel ON Kern.His_PersOpschorting (ActieAanpGel);
CREATE INDEX His_PersOverlijden_Pers ON Kern.His_PersOverlijden (Pers);
CREATE INDEX His_PersOverlijden_ActieInh ON Kern.His_PersOverlijden (ActieInh);
CREATE INDEX His_PersOverlijden_ActieVerval ON Kern.His_PersOverlijden (ActieVerval);
CREATE INDEX His_PersPK_Pers ON Kern.His_PersPK (Pers);
CREATE INDEX His_PersPK_ActieInh ON Kern.His_PersPK (ActieInh);
CREATE INDEX His_PersPK_ActieVerval ON Kern.His_PersPK (ActieVerval);
CREATE INDEX His_PersSamengesteldeNaam_Pers ON Kern.His_PersSamengesteldeNaam (Pers);
CREATE INDEX His_PersSamengesteldeNaam_ActieInh ON Kern.His_PersSamengesteldeNaam (ActieInh);
CREATE INDEX His_PersSamengesteldeNaam_ActieVerval ON Kern.His_PersSamengesteldeNaam (ActieVerval);
CREATE INDEX His_PersSamengesteldeNaam_ActieAanpGel ON Kern.His_PersSamengesteldeNaam (ActieAanpGel);
CREATE INDEX His_PersUitslNLKiesr_Pers ON Kern.His_PersUitslNLKiesr (Pers);
CREATE INDEX His_PersUitslNLKiesr_ActieInh ON Kern.His_PersUitslNLKiesr (ActieInh);
CREATE INDEX His_PersUitslNLKiesr_ActieVerval ON Kern.His_PersUitslNLKiesr (ActieVerval);
CREATE INDEX His_PersVerblijfsr_Pers ON Kern.His_PersVerblijfsr (Pers);
CREATE INDEX His_PersVerblijfsr_ActieInh ON Kern.His_PersVerblijfsr (ActieInh);
CREATE INDEX His_PersVerblijfsr_ActieVerval ON Kern.His_PersVerblijfsr (ActieVerval);
CREATE INDEX His_PersVerblijfsr_ActieAanpGel ON Kern.His_PersVerblijfsr (ActieAanpGel);
CREATE INDEX His_PersAdres_PersAdres ON Kern.His_PersAdres (PersAdres);
CREATE INDEX His_PersAdres_ActieInh ON Kern.His_PersAdres (ActieInh);
CREATE INDEX His_PersAdres_ActieVerval ON Kern.His_PersAdres (ActieVerval);
CREATE INDEX His_PersAdres_ActieAanpGel ON Kern.His_PersAdres (ActieAanpGel);
CREATE INDEX His_PersGeslnaamcomp_PersGeslnaamcomp ON Kern.His_PersGeslnaamcomp (PersGeslnaamcomp);
CREATE INDEX His_PersGeslnaamcomp_ActieInh ON Kern.His_PersGeslnaamcomp (ActieInh);
CREATE INDEX His_PersGeslnaamcomp_ActieVerval ON Kern.His_PersGeslnaamcomp (ActieVerval);
CREATE INDEX His_PersGeslnaamcomp_ActieAanpGel ON Kern.His_PersGeslnaamcomp (ActieAanpGel);
CREATE INDEX His_PersIndicatie_PersIndicatie ON Kern.His_PersIndicatie (PersIndicatie);
CREATE INDEX His_PersIndicatie_ActieInh ON Kern.His_PersIndicatie (ActieInh);
CREATE INDEX His_PersIndicatie_ActieVerval ON Kern.His_PersIndicatie (ActieVerval);
CREATE INDEX His_PersIndicatie_ActieAanpGel ON Kern.His_PersIndicatie (ActieAanpGel);
CREATE INDEX His_PersNation_PersNation ON Kern.His_PersNation (PersNation);
CREATE INDEX His_PersNation_ActieInh ON Kern.His_PersNation (ActieInh);
CREATE INDEX His_PersNation_ActieVerval ON Kern.His_PersNation (ActieVerval);
CREATE INDEX His_PersNation_ActieAanpGel ON Kern.His_PersNation (ActieAanpGel);
CREATE INDEX His_PersReisdoc_PersReisdoc ON Kern.His_PersReisdoc (PersReisdoc);
CREATE INDEX His_PersReisdoc_ActieInh ON Kern.His_PersReisdoc (ActieInh);
CREATE INDEX His_PersReisdoc_ActieVerval ON Kern.His_PersReisdoc (ActieVerval);
CREATE INDEX His_PersVerificatie_PersVerificatie ON Kern.His_PersVerificatie (PersVerificatie);
CREATE INDEX His_PersVerificatie_ActieInh ON Kern.His_PersVerificatie (ActieInh);
CREATE INDEX His_PersVerificatie_ActieVerval ON Kern.His_PersVerificatie (ActieVerval);
CREATE INDEX His_PersVoornaam_PersVoornaam ON Kern.His_PersVoornaam (PersVoornaam);
CREATE INDEX His_PersVoornaam_ActieInh ON Kern.His_PersVoornaam (ActieInh);
CREATE INDEX His_PersVoornaam_ActieVerval ON Kern.His_PersVoornaam (ActieVerval);
CREATE INDEX His_PersVoornaam_ActieAanpGel ON Kern.His_PersVoornaam (ActieAanpGel);
