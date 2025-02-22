insert into voisc.lo3_mailbox(id, instantietype, instantiecode, mailboxnr, mailboxpwd)
select nextval('voisc.lo3_mailbox_id_sequence'), 'A' as instantietype, a.nr as instantiecode, concat(a.nr,'0') as mailboxnr, 'password' as mailboxpwd
from (select 990085 as nr) AS a
where not exists (select id from voisc.lo3_mailbox where instantiecode = a.nr);