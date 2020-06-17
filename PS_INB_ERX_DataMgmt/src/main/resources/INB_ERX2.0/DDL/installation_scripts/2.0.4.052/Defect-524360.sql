create table erx.pharm_temp as (select * from erx.pharmacy);

alter table erx.pharmacy modify(visn NULL);

update erx.pharmacy set visn = null;

alter table erx.pharmacy modify(visn NUMBER);

update erx.pharmacy b set visn =
(select visn from erx.pharm_temp a 
where a.pharmacy_id = b.pharmacy_id);

commit;

alter table erx.pharmacy modify(visn NOT NULL);

drop table erx.pharm_temp;

alter table erx.pharmacy modify(pharmacy_fax_number VARCHAR2(25));

alter table erx.pharmacy modify(pharmacy_phone_number VARCHAR2(25));