--defect 529318 - Pharmacy Table and Pharmacy Screen not allowing 6 character VA station id to support MBM station ids

ALTER TABLE erx.pharmacy MODIFY (va_station_id VARCHAR2(10));