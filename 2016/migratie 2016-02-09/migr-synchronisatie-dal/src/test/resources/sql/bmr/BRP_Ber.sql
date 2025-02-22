/* Main aanroepscript welke alle subscripts aanroept*/

/* Loggen versie */
SELECT version();

/* Bij iedere fout stoppen */
\set ON_ERROR_STOP

-- Forceer psql op UTF-8 lezen, onafhankelijk van client instellingen (.sql bestanden zijn UTF-8)
\encoding UTF-8

\set AUTOCOMMIT OFF
START TRANSACTION;

--------------------------------------------------------------------------------
-- Database instellingen controles:
DO $$
DECLARE
   l_var TEXT;
BEGIN
SHOW timezone INTO l_var;
IF l_var <> 'UTC' THEN
   RAISE EXCEPTION 'Database timezone moet UTC zijn.';
END IF;

SHOW SERVER_ENCODING INTO l_var;
IF l_var <> 'UTF8' THEN
   RAISE EXCEPTION 'Database encoding moet UTF-8 zijn.';
END IF;

SHOW LC_CTYPE INTO l_var;
IF NOT l_var LIKE '%UTF-8' THEN
   RAISE EXCEPTION 'Database LC_CTYPE moet UTF-8 zijn.';
END IF;

SHOW LC_COLLATE INTO l_var;
IF NOT l_var LIKE '%UTF-8' THEN
   RAISE EXCEPTION 'Database LC_COLLATE moet UTF-8 zijn.';
END IF;

END;
$$;

--------------------------------------------------------------------------------
-- Aanroep subscripts:
\echo PostgreSQL - Bericht Structuur DDL
\i Ber/Bericht_BRP_structuur.sql

\echo PostgreSQL - Bericht Indexen DDL
\i Ber/Bericht_BRP_indexen.sql

\echo PostgreSQL - Bericht Statische Stamgegevens
\i Ber/Bericht_BRP_statische_stamgegevens.sql

\echo PostgreSQL - Bericht Structuur Aanvullend
\i Ber/Bericht_BRP_structuur_aanvullend.sql

\echo PostgreSQL - Bericht Rechten
\i Ber/Bericht_BRP_rechten.sql

\echo PostgreSQL - Bericht Custom changes
\i Ber/Bericht_BRP_custom_changes.sql


COMMIT;

\echo Alle scripts uitgevoerd.
\echo
\echo Aantal verwachte tabellen per schema
\echo Ber: 11
\echo
\echo Controle query:
select schemaname, count(*) from pg_catalog.pg_tables where schemaname in ('ber') group by schemaname order by schemaname;
\echo 'select schemaname, count(*) from pg_catalog.pg_tables where schemaname in (''ber'') group by schemaname order by schemaname;'
