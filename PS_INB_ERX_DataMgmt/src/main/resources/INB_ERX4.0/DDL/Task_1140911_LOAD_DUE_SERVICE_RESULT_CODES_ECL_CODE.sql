--Inserts the new Due Service Results Codes for 2017071

DELETE FROM ERX.ECL_CODE WHERE CODE_TYPE = 'DUE_SERVICE_RESULT_CODE';

INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DUE_SERVICE_RESULT_CODE','4A','Prescribed With Acknowledgments - Physician is prescribing this medication with knowledge of the potential conflict.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DUE_SERVICE_RESULT_CODE','3C','Discontinued Drug - Cognitive service involving the pharmacist''s review of drug therapy that results in the removal of a medication from the therapeutic regimen.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DUE_SERVICE_RESULT_CODE','1C','Filled, With Different Dose - Cognitive service whereby the pharmacist reviews and evaluates a therapeutic issue (alert) and fills the prescription with a different dose than was originally prescribed.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DUE_SERVICE_RESULT_CODE','3E','Therapy Changed - Code indicating a cognitive service. The pharmacist reviews and evaluates a therapeutic issue (alert), recommends a more appropriate product or regimen then dispenses the alternative after consultation with the prescriber.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DUE_SERVICE_RESULT_CODE','3M','Compliance Aid Provided - Cognitive service whereby the pharmacist supplies a product that assists the patient in complying with instructions for taking medications.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DUE_SERVICE_RESULT_CODE','1E','Filled, With Different Drug - Cognitive service whereby the pharmacist reviews and evaluates a therapeutic issue (alert) and fills the prescription with a different drug than was originally prescribed.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DUE_SERVICE_RESULT_CODE','2A','Prescription Not Filled - Code indicating a cognitive service. The pharmacist reviews and evaluates a therapeutic issue (alert) and determines that the prescription should not be filled as written.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DUE_SERVICE_RESULT_CODE','1B','Filled Prescription As Is - Cognitive service whereby the pharmacist reviews and evaluates a therapeutic issue (alert) and determines the alert is not relevant for that prescription for that patient and fills the prescription as originally written.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DUE_SERVICE_RESULT_CODE','3A','Recommendation Accepted - Code indicating a cognitive service. The pharmacist reviews and evaluates a therapeutic issue (alert), recommends a more appropriate product or regimen then dispenses the alternative after consultation with the prescriber.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DUE_SERVICE_RESULT_CODE','3D','Regimen Changed - Code indicating a cognitive service. The pharmacist reviews and evaluates a therapeutic issue (alert), recommends a more appropriate regimen then dispenses the recommended medication(s) after consultation with the prescriber.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DUE_SERVICE_RESULT_CODE','1H','Brand-to-Generic Change - Action whereby a pharmacist dispenses the generic formulation of an originally prescribed branded product. Allowed, often mandated, unless the prescriber indicates ''Do Not Substitute'' on the prescription.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DUE_SERVICE_RESULT_CODE','3B','Recommendation Not Accepted - Code indicating a cognitive service. The pharmacist reviews and evaluates a therapeutic issue (alert), recommends a more appropriate product or regimen but the prescriber does not concur.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DUE_SERVICE_RESULT_CODE','3J','Patient Referral - Code indicating the referral of a patient to another health care provider following evaluation by the pharmacist.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DUE_SERVICE_RESULT_CODE','1F','Filled, With Different Quantity - Cognitive service whereby the pharmacist reviews and evaluates a therapeutic issue (alert) and fills the prescription with a different quantity than was originally prescribed.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DUE_SERVICE_RESULT_CODE','1K','Filled with Different Dosage Form - Cognitive service whereby the pharmacist reviews and evaluates a therapeutic issue (alert) and fills the prescription with a different dosage form than was originally prescribed.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DUE_SERVICE_RESULT_CODE','3H','Follow-Up/Report - Code indicating that additional follow through by the pharmacist is required.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DUE_SERVICE_RESULT_CODE','1D','Filled, With Different Directions - Cognitive service whereby the pharmacist reviews and evaluates a therapeutic issue (alert) and fills the prescription with different directions than were originally prescribed.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DUE_SERVICE_RESULT_CODE','2B','Not Filled, Directions Clarified - Cognitive service whereby the pharmacist reviews and evaluates a therapeutic issue (alert), consults with the prescriber or using professional judgment, does not fill the prescription and counsels the patient as to the prescriber''s instructions.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DUE_SERVICE_RESULT_CODE','3G','Drug Therapy Unchanged - Cognitive service whereby the pharmacist reviews and evaluates a therapeutic issue (alert), consults with the prescriber or uses professional judgment and subsequently fills the prescription as originally written.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DUE_SERVICE_RESULT_CODE','3N','Medication Administered - Cognitive service whereby the pharmacist performs a patient care activity by personally administering the medication.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DUE_SERVICE_RESULT_CODE','1A','Filled As Is, False Positive - Cognitive service whereby the pharmacist reviews and evaluates a therapeutic issue (alert) and determines the alert is incorrect for that prescription for that patient and fills the prescription as originally written.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DUE_SERVICE_RESULT_CODE','00','Not Specified');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DUE_SERVICE_RESULT_CODE','3F','Therapy Changed - cost increased acknowledged - Code indicating a cognitive service. The pharmacist reviews and evaluates a therapeutic issue (alert), recommends a more appropriate product or regimen acknowledging that a cost increase will be incurred, then dispenses the alternative after consultation with the prescriber.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DUE_SERVICE_RESULT_CODE','3K','Instructions Understood - Indicator used to convey that the patient affirmed understanding of the instructions provided by the pharmacist regarding the use and handling of the medication dispensed.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DUE_SERVICE_RESULT_CODE','1J','Rx-to-OTC Change - Code indicating a cognitive service. The pharmacist reviews and evaluates a therapeutic issue (alert) fills the prescription with an over-the-counter product in lieu of the originally prescribed prescription-only product.');
INSERT INTO ERX.ECL_CODE (CODE_TYPE, CODE, DEFINITION) values ('DUE_SERVICE_RESULT_CODE','1G','Filled, With Prescriber Approval Cognitive service whereby the pharmacist reviews and evaluates a therapeutic issue (alert) and fills the prescription after consulting with or obtaining approval from the prescriber.');

COMMIT;
