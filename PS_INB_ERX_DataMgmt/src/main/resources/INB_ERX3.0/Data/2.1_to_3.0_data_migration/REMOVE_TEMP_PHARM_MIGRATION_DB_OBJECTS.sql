--remove_temp_pharm_migration_db_objects.sql
--run this after the pharmacy migration service/app is removed from WebLogic.  The pharmacy_migration table is no longer needed.
--the two migration service related entries in the app_configuration table are no longer needed.

DELETE FROM erx.app_configuration WHERE key =  'INB_V3_WS_URI';
DELETE FROM erx.app_configuration WHERE key =  'INB_V2_WS_URI';

COMMIT;

DROP TABLE erx.pharmacy_migration;