ALTER TABLE ERX.INBOUND_NCPDP_MSG ADD CONSTRAINT IB_NCPDP_MSG_ERX_STATUS_FK2 FOREIGN KEY ( MESSAGE_STATUS ) REFERENCES ERX.ERX_STATUS ( CODE ) NOT DEFERRABLE ;
