--As per the latest NCIt code list released in October 2019, the NCIt Description for the NCIt Code 'C16358' should be updated.
--Change: NCIT Code - C16358; NCIT Definition - An individual's weight in kilograms divided by the square of the height in meters. 
--Current: NCIT Code - C16358; NCIT Definition - A general indicator of the body fat an individual is carrying based upon the ratio of weight to height.

UPDATE erx.NCPDP_CODE set NCIT_DEFINITION = 'An individual''s weight in kilograms divided by the square of the height in meters.'
WHERE NCIT_CODE = 'C16358';

COMMIT;