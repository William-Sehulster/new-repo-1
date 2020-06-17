--PROMPTs for database link name e.g.(ERXD2_DBLINK.AAC.VA.GOV)
accept dblink char prompt 'Enter source database link name: '

--check the current values
select sequence_name, last_number from all_sequences
where sequence_owner = 'ERX';

--increase the current users_id_seq value
DECLARE
seqowner VARCHAR2(30) := 'ERX';
seqname VARCHAR2(30) := 'USERS_ID_SEQ';
newvalue NUMBER := 500;
ln NUMBER;
ib NUMBER;
BEGIN
SELECT last_number, increment_by
INTO ln, ib
FROM all_sequences@&dblink
WHERE sequence_owner = upper(seqowner)
AND sequence_name = upper(seqname);
EXECUTE IMMEDIATE 'ALTER SEQUENCE ' || seqowner || '.' || seqname ||' INCREMENT BY ' || (newvalue);
EXECUTE IMMEDIATE 'SELECT ' || seqowner || '.' || seqname ||'.NEXTVAL FROM DUAL' INTO ln;
EXECUTE IMMEDIATE 'ALTER SEQUENCE ' || seqowner || '.' || seqname || ' INCREMENT BY ' || ib;
END;
/

--increase the current pharmacy_id_seq value
DECLARE
seqowner VARCHAR2(30) := 'ERX';
seqname VARCHAR2(30) := 'PHARMACY_ID_SEQ';
newvalue NUMBER := 100;
ln NUMBER;
ib NUMBER;
BEGIN
SELECT last_number, increment_by
INTO ln, ib
FROM all_sequences@&dblink
WHERE sequence_owner = upper(seqowner)
AND sequence_name = upper(seqname);
EXECUTE IMMEDIATE 'ALTER SEQUENCE ' || seqowner || '.' || seqname ||' INCREMENT BY ' || (newvalue);
EXECUTE IMMEDIATE 'SELECT ' || seqowner || '.' || seqname ||'.NEXTVAL FROM DUAL' INTO ln;
EXECUTE IMMEDIATE 'ALTER SEQUENCE ' || seqowner || '.' || seqname || ' INCREMENT BY ' || ib;
END;
/

--increase the current ob_ncpdp_msg_id_seq value
DECLARE
seqowner VARCHAR2(30) := 'ERX';
seqname VARCHAR2(30) := 'OB_NCPDP_MSG_ID_SEQ';
newvalue NUMBER := 200000;
ln NUMBER;
ib NUMBER;
BEGIN
SELECT last_number, increment_by
INTO ln, ib
FROM all_sequences@&dblink
WHERE sequence_owner = upper(seqowner)
AND sequence_name = upper(seqname);
EXECUTE IMMEDIATE 'ALTER SEQUENCE ' || seqowner || '.' || seqname ||' INCREMENT BY ' || (newvalue);
EXECUTE IMMEDIATE 'SELECT ' || seqowner || '.' || seqname ||'.NEXTVAL FROM DUAL' INTO ln;
EXECUTE IMMEDIATE 'ALTER SEQUENCE ' || seqowner || '.' || seqname || ' INCREMENT BY ' || ib;
END;
/

--increase the current ib_ncpdp_msg_id_seq value
DECLARE
seqowner VARCHAR2(30) := 'ERX';
seqname VARCHAR2(30) := 'IB_NCPDP_MSG_ID_SEQ';
newvalue NUMBER := 200000;
ln NUMBER;
ib NUMBER;
BEGIN
SELECT last_number, increment_by
INTO ln, ib
FROM all_sequences@&dblink
WHERE sequence_owner = upper(seqowner)
AND sequence_name = upper(seqname);
EXECUTE IMMEDIATE 'ALTER SEQUENCE ' || seqowner || '.' || seqname ||' INCREMENT BY ' || (newvalue);
EXECUTE IMMEDIATE 'SELECT ' || seqowner || '.' || seqname ||'.NEXTVAL FROM DUAL' INTO ln;
EXECUTE IMMEDIATE 'ALTER SEQUENCE ' || seqowner || '.' || seqname || ' INCREMENT BY ' || ib;
END;
/

--check the values
select sequence_name, last_number from all_sequences
where sequence_owner = 'ERX';