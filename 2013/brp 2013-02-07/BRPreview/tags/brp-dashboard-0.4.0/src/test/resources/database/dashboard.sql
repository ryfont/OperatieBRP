DROP SCHEMA IF EXISTS dashboard CASCADE;

CREATE SCHEMA dashboard;
CREATE SEQUENCE dashboard.seq_berichten;

CREATE TABLE dashboard.berichten
(
  id Bigint NOT NULL,
  partij varchar(120),
  bericht varchar(1024),
  berichtdetails varchar(1024),
  aantalmeldingen integer,
  tsverzonden timestamp,
  bzm varchar(60),
  soortactie varchar(60),
  indprevalidatie boolean,
  tsreg timestamp DEFAULT now(),
  CONSTRAINT bpreviewconstraint PRIMARY KEY (id)
);
CREATE INDEX berichten_tsverzonden ON dashboard.berichten (tsverzonden);

CREATE TABLE dashboard.bericht_bsn
(
  id Bigint NOT NULL,
  bericht Bigint NOT NULL,
  bsn integer NOT NULL,
  CONSTRAINT bericht_bsn_pk PRIMARY KEY (id)
);
CREATE INDEX bsn_index ON dashboard.bericht_bsn (bsn);

ALTER TABLE dashboard.bericht_bsn ADD FOREIGN KEY (bericht) REFERENCES dashboard.berichten;

COMMIT;
