CREATE OR REPLACE TRIGGER ERX.PHARMACY_TRG 
    BEFORE INSERT OR UPDATE ON ERX.PHARMACY 
    FOR EACH ROW 
BEGIN 
IF UPDATING THEN
  :NEW.UPDATED_DATE := SYSDATE;
ELSE
  :NEW.CREATED_DATE := SYSDATE;
   IF :NEW.PHARMACY_ID IS NULL THEN
   :NEW.PHARMACY_ID := PHARMACY_ID_SEQ.NEXTVAL;
   END IF;
END IF;
END; 
/


