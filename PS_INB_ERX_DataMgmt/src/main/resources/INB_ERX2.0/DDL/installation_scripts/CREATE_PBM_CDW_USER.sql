DROP USER PBM_CDW_USER CASCADE;

CREATE USER PBM_CDW_USER
  IDENTIFIED BY &pwd
  DEFAULT TABLESPACE ERX_DATA
  TEMPORARY TABLESPACE TEMP
  PROFILE PBM_CDW_PROFILE
  ACCOUNT UNLOCK;
  -- 2 Roles for PBM_CDW_USER 
  GRANT CONNECT TO PBM_CDW_USER;
  GRANT ERX_READ_ROLE TO PBM_CDW_USER;
  ALTER USER PBM_CDW_USER DEFAULT ROLE ALL;
