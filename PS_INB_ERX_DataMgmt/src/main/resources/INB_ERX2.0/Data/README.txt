1) These scripts load the erx tables with an initial set of data required for system operation

2) There should be a script created for each environment as the configuration data stored
in the erx.app_configuration table varies from environment to environment.

3) Run the LOAD_ALL_TABLE-XXX.sql script for the targeted environment. ie.,DEV1, DEV2, SQA1, STAG, PREP or PROD