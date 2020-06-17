-- Add new column to Pharmacy table to enable/disable E&E check for Patient Match
ALTER TABLE ERX.PHARMACY ADD EANDE_CHECK VARCHAR2(1 BYTE)    DEFAULT 'Y' NOT NULL;