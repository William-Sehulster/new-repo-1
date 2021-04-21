SET DEFINE OFF

DROP TABLE ERX.UCUM_CODE;

CREATE TABLE ERX.UCUM_CODE ( CODE VARCHAR2(26),
DESCRIPTION VARCHAR2(128));

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('UCUM_CODE', 'Description of the Unit 
(using UCUM descriptions where they exist)');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('10.L/min', '10 liter per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('10.L/(min.m2)', '10 liter per minute per square meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('10.uN.s/(cm5.m2)', '10 micronewton second per centimeter to the fifth power per square meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('10*4/uL', '10 thousand per microliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('10*8', '100 million ');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('24.h', '24 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{absorbance}', 'absorbance');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{activity}', 'activity');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[AU]', 'allergy unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{AHF''U}', 'American Hospital Formulary unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('A', 'ampere');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('A/m', 'ampere per meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[arb''U]', 'arbitrary unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[arb''U]/mL', 'arbitrary unit per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{ARU}', 'aspirin response unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('atm', 'atmosphere');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ag/{cell}', 'attogram per cell');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('bar', 'bar');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('Bq', 'Becquerel');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[beth''U]', 'Bethesda unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('10*9/L', 'billion per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('10*9/uL', 'billion per microliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('10*9/mL', 'billion per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{binding_index}', 'binding index');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[bdsk''U]', 'Bodansky unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{CAG_repeats}', 'CAG trinucleotide repeats');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('cal', 'calorie');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{cells}', 'cells');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{cells}/[HPF]', 'cells per high power field');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{cells}/uL', 'cells per microliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('cg', 'centigram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('cL', 'centiliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('cm', 'centimeter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('cm[Hg]', 'centimeter of mercury');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('cm[H2O]', 'centimeter of water');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('cm[H2O]/L/s', 'centimeter of water per liter per second');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('cm[H2O]/s/m', 'centimeter of water per second per meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('cP', 'centipoise');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('cSt', 'centistoke');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{delta_OD}', 'change in (delta) optical density');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{clock_time}', 'clock time e.g 12:30PM');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[CFU]', 'colony forming unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[CFU]/L', 'colony forming unit per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[CFU]/mL', 'colony forming unit per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{CAE''U}', 'complement activity enzyme unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{CH100''U}', 'complement CH100 unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{copies}', 'copies');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{copies}/ug', 'copies per microgram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{copies}/mL', 'copies per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{count}', 'count');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{CPM}', 'counts per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{CPM}/10*3{cell}', 'counts per minute per thousand cells');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[cin_i]', 'cubic inch (international)');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('m3/s', 'cubic meter per second');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('d', 'day');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('dB', 'decibel');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('dg', 'decigram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('dL', 'deciliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('dm', 'decimeter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('deg', 'degree (plane angle)');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('Cel', 'degree Celsius');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[degF]', 'degree Fahrenheit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('K', 'degree Kelvin');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('K/W', 'degree Kelvin per Watt');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('deg/s', 'degree per second');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('daL/min', 'dekaliter per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('daL/min/m2', 'dekaliter per minute per square meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{dilution}', 'dilution');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[dr_av]', 'dram  (US and British)');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[drp]', 'drop (1/12 milliliter)');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('dyn.s/cm', 'dyne second per centimeter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('dyn.s/(cm.m2)', 'dyne second per centimeter per square meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{Ehrlich''U}', 'Ehrlich unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{Ehrlich''U}/100.g', 'Ehrlich unit per 100 gram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{Ehrlich''U}/(2.h)', 'Ehrlich unit per 2 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{Ehrlich''U}/d', 'Ehrlich unit per day');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{Ehrlich''U}/dL', 'Ehrlich unit per deciliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{EIA_index}', 'EIA index');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{EIA_titer}', 'EIA titer');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{EIA''U}', 'EIA unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{EIA''U}/U', 'EIA unit per enzyme unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{EV}', 'EIA value');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('eV', 'electron Volt');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{ELISA''U}', 'ELISA unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('U', 'enzyme unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('U/10', 'enzyme unit per 10');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('U/10*10', 'enzyme unit per 10 billion');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('U/10*10{cells}', 'enzyme unit per 10 billion cells');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('U/(10.g){feces}', 'enzyme unit per 10 gram of feces');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('U/(12.h)', 'enzyme unit per 12 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('U/(2.h)', 'enzyme unit per 2 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('U/(24.h)', 'enzyme unit per 24 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('U/10*9', 'enzyme unit per billion');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('U/d', 'enzyme unit per day');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('U/dL', 'enzyme unit per deciliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('U/g', 'enzyme unit per gram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('U/g{creat}', 'enzyme unit per gram of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('U/g{Hb}', 'enzyme unit per gram of hemoglobin');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('U/g{protein}', 'enzyme unit per gram of protein');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('U/h', 'enzyme unit per hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('U/kg{Hb}', 'enzyme unit per kilogram of hemoglobin');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('U/L', 'enzyme unit per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('U{25Cel}/L', 'enzyme unit per liter at 25 deg Celsius ');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('U{37Cel}/L', 'enzyme unit per liter at 37 deg Celsius');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('U/mL', 'enzyme unit per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('U/mL{RBCs}', 'enzyme unit per milliliter of red blood cells');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('U/mmol{creat}', 'enzyme unit per millimole of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('U/10*6', 'enzyme unit per million');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('U/min', 'enzyme unit per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('U/s', 'enzyme unit per second');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('U/10*12', 'enzyme unit per trillion');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('U/10*12{RBCs}', 'enzyme unit per trillion red blood cells');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('eq', 'equivalent');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('eq/L', 'equivalent per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('eq/umol', 'equivalent per micromole');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('eq/mL', 'equivalent per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('eq/mmol', 'equivalent per millimole');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('erg', 'erg');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('F', 'Farad');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('fg', 'femtogram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('fL', 'femtoliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('fm', 'femtometer');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('fmol', 'femtomole');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('fmol/g', 'femtomole per gram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('fmol/L', 'femtomole per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('fmol/mg', 'femtomole per milligram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('fmol/mg{cyt_prot}', 'femtomole per milligram of cytosol protein');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('fmol/mg{prot}', 'femtomole per milligram of protein');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('fmol/mL', 'femtomole per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[foz_us]', 'fluid ounce (US)');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{FIU}', 'fluorescent intensity unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[ft_i]', 'foot (international)');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{fraction}', 'fraction');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[Ch]', 'French (catheter gauge) ');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{GAA_repeats}', 'GAA trinucleotide repeats');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[gal_us]', 'gallon (US)');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{genomes}/mL', 'genomes per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{Globules}/[HPF]', 'globules (drops)  per high power field');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g', 'gram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g.m', 'gram meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g.m/{beat}', 'gram meter per heart beat ');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g{creat}', 'gram of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g{Hb}', 'gram of hemoglobin');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g{total_nit}', 'gram of total nitrogen');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g{total_prot}', 'gram of total protein');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g{wet_tissue}', 'gram of wet tissue');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/kg/(8.h)', 'gram per  kilogram per 8 hour ');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/(100.g)', 'gram per 100 gram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/(12.h)', 'gram per 12 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/(24.h)', 'gram per 24 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/(3.d)', 'gram per 3 days');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/(4.h)', 'gram per 4 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/(48.h)', 'gram per 48 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/(5.h)', 'gram per 5 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/(6.h)', 'gram per 6 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/(72.h)', 'gram per 72 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/(8.h){shift}', 'gram per 8 hour shift');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/cm3', 'gram per cubic centimeter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/d', 'gram per day');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/dL', 'gram per deciliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/g', 'gram per gram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/g{creat}', 'gram per gram of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/g{globulin}', 'gram per gram of globulin');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/g{tissue}', 'gram per gram of tissue');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/h', 'gram per hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/h/m2', 'gram per hour per square meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/kg ', 'gram per kilogram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/kg/(8.h){shift}', 'gram per kilogram per 8 hour shift');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/kg/d', 'gram per kilogram per day');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/kg/h', 'gram per kilogram per hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/kg/min', 'gram per kilogram per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/L', 'gram per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/mg', 'gram per milligram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/mL', 'gram per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/mmol', 'gram per millimole');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/min', 'gram per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/mol{creat}', 'gram per mole of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/{specimen}', 'gram per specimen');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/m2', 'gram per square meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/{total_output}', 'gram per total output');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('g/{total_weight}', 'gram per total weight');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('Gy', 'Gray');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{beats}/min', 'heart beats per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('H', 'Henry');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('Hz', 'Hertz');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[HPF]', 'high power field');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('h', 'hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[APL''U]/mL', 'IgA anticardiolipin unit per milliliter**');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[APL''U]', 'IgA anticardiolipin unit**');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{APS''U}', 'IgA antiphosphatidylserine unit ');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[GPL''U]/mL', 'IgG anticardiolipin unit per milliliter**');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[GPL''U]', 'IgG anticardiolipin unit**');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{GPS''U}', 'IgG antiphosphatidylserine unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[MPL''U]/mL', 'IgM anticardiolipin unit per milliliter**');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[MPL''U]', 'IgM anticardiolipin unit**');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{MPS''U}', 'IgM antiphosphatidylserine unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{MPS''U}/mL', 'IgM antiphosphatidylserine unit per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{ImmuneComplex''U}', 'immune complex unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{ISR}', 'immune status ratio');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{IFA_index}', 'immunofluorescence assay index');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{IFA_titer}', 'Immunofluorescence assay titer');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[in_i]', 'inch (international)');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[in_i''H2O]', 'inch (international) of water');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{index_val}', 'index value');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{HA_titer}', 'influenza hemagglutination titer');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{INR}', 'international normalized ratio');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[IU]', 'international unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[IU]/(2.h)', 'international unit per 2 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[IU]/(24.h)', 'international unit per 24 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[IU]/10*9{RBCs}', 'international unit per billion red blood cells');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[IU]/d', 'international unit per day');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[IU]/dL', 'international unit per deciliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[IU]/g', 'international unit per gram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[IU]/g{Hb}', 'international unit per gram of hemoglobin');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[IU]/h', 'international unit per hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[IU]/kg', 'international unit per kilogram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[IU]/kg/d', 'international unit per kilogram per day');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[IU]/L', 'international unit per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[IU]/L{37Cel}', 'international unit per liter at 37 degrees Celsius');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[IU]/mg{creat}', 'international unit per milligram of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[IU]/mL', 'international unit per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[IU]/min', 'international unit per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('J', 'joule');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('J/L', 'joule per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{JDF''U}', 'Juvenile Diabetes Foundation unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{JDF''U}/L', 'Juvenile Diabetes Foundation unit per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{KCT''U}', 'kaolin clotting time');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('kat', 'katal');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('kat/kg', 'katal per kilogram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('kat/L', 'katal per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('kU', 'kilo enzyme unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('kU/g', 'kilo enzyme unit per gram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('kU/L', 'kilo enzyme unit per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('kU/L{class}', 'kilo enzyme unit per liter class');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('kU/mL', 'kilo enzyme unit per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('k[IU]/L', 'kilo international unit per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('k[IU]/mL', 'kilo international unit per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('kcal', 'kilocalorie');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('kcal/d', 'kilocalorie per day');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('kcal/h', 'kilocalorie per hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('kcal/kg/(24.h)', 'kilocalorie per kilogram per 24 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('kcal/[oz_av]', 'kilocalorie per ounce (US & British)');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('kg', 'kilogram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('kg.m/s', 'kilogram meter per second');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('kg/m3', 'kilogram per cubic meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('kg/h', 'kilogram per hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('kg/L', 'kilogram per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('kg/min', 'kilogram per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('kg/mol', 'kilogram per mole');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('kg/s', 'kilogram per second');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('kg/(s.m2)', 'kilogram per second per square meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('kg/m2', 'kilogram per square meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('kL', 'kiloliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('km', 'kilometer');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('kPa', 'kilopascal');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ks', 'kilosecond');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[ka''U]', 'King Armstrong unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{KRONU''U}/mL', 'Kronus unit per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[knk''U]', 'Kunkel unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('L', 'liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('L/(24.h)', 'liter per 24 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('L/(8.h)', 'liter per 8 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('L/d', 'liter per day');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('L/h', 'liter per hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('L/kg', 'liter per kilogram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('L/L', 'liter per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('L/min', 'liter per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('L/(min.m2)', 'liter per minute per square meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('L/s', 'liter per second');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('L/s/s2', 'liter per second per square second');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{Log_copies}/mL', 'log (base 10) copies per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{Log_IU}', 'log (base 10) international unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{Log_IU}/mL', 'log (base 10) international unit per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{Log}', 'log base 10');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[LPF]', 'low power field');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('lm', 'lumen');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('lm.m2', 'lumen square meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{Lyme_index_value}', 'Lyme index value');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[mclg''U]', 'Maclagan unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('Ms', 'megasecond');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('m', 'meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('m/s', 'meter per second');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('m/s2', 'meter per square second');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('t', 'metric ton');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('uU/g', 'micro enzyme unit per gram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('uU/L', 'micro enzyme unit per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('uU/mL', 'micro enzyme unit per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('u[IU]', 'micro international unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('u[IU]/mL', 'micro international unit per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ueq', 'microequivalent');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ueq/L', 'microequivalent per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ueq/mL', 'microequivalent per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug', 'microgram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/g{feces}', 'microgram  per gram of feces');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug{FEU}/mL', 'microgram fibrinogen equivalent unit per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/(100.g)', 'microgram per 100 gram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/(24.h)', 'microgram per 24 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/(8.h)', 'microgram per 8 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/m3', 'microgram per cubic meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/d', 'microgram per day');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/dL', 'microgram per deciliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/dL{RBCs}', 'microgram per deciliter of red blood cells');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/g', 'microgram per gram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/g{creat}', 'microgram per gram of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/g{dry_tissue}', 'microgram per gram of dry tissue');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/g{dry_wt}', 'microgram per gram of dry weight');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/g{hair}', 'microgram per gram of hair');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/g{Hb}', 'microgram per gram of hemoglobin');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/g{tissue}', 'microgram per gram of tissue');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/h', 'microgram per hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/kg', 'microgram per kilogram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/kg/(8.h)', 'microgram per kilogram per 8 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/kg/d', 'microgram per kilogram per day');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/kg/h', 'microgram per kilogram per hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/kg/min', 'microgram per kilogram per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/L', 'microgram per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/L{RBCs}', 'microgram per liter of red blood cells');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/L/(24.h)', 'microgram per liter per 24 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/mg', 'microgram per milligram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/mg{creat}', 'microgram per milligram of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/mL', 'microgram per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/mL{class}', 'microgram per milliliter class');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/mL{eqv}', 'microgram per milliliter equivalent');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/mmol', 'microgram per millimole');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/mmol{creat}', 'microgram per millimole of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/min', 'microgram per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/ng', 'microgram per nanogram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/{specimen}', 'microgram per specimen');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/[sft_i]', 'microgram per square foot (international)');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ug/m2', 'microgram per square meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('u[IU]/L', 'microinternational unit per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ukat', 'microkatal');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('uL', 'microliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('uL/(2.h)', 'microliter per 2 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('uL/h', 'microliter per hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('um', 'micrometer');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol', 'micromole');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol{BCE}/mol', 'micromole bone collagen equivalent per mole');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/(2.h)', 'micromole per 2 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/(24.h)', 'micromole per 24 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/(8.h)', 'micromole per 8 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/d', 'micromole per day');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/dL', 'micromole per deciliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/dL{GF}', 'micromole per deciliter of glomerular filtrate');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/g', 'micromole per gram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/g{creat}', 'micromole per gram of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/g{Hb}', 'micromole per gram of hemoglobin');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/h', 'micromole per hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/kg', 'micromole per kilogram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/kg{feces}', 'micromole per kilogram of feces');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/L', 'micromole per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/L{RBCs}', 'micromole per liter of red blood cells');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/L/h', 'micromole per liter per hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/umol', 'micromole per micromole');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/umol{creat}', 'micromole per micromole of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/mg', 'micromole per milligram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/mg{creat}', 'micromole per milligram of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/mL', 'micromole per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/mL/min', 'micromole per milliliter per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/mmol', 'micromole per millimole');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/mmol{creat}', 'micromole per millimole of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/min', 'micromole per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/min/g', 'micromole per minute per gram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/min/g{mucosa}', 'micromole per minute per gram of mucosa');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/min/g{prot}', 'micromole per minute per gram of protein');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/min/L', 'micromole per minute per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/mol', 'micromole per mole');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/mol{creat}', 'micromole per mole of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('umol/mol{Hb}', 'micromole per mole of hemoglobin');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('um/s', 'microns per second');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('uOhm', 'microOhm');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('us', 'microsecond');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('uV', 'microvolt');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[mi_i]', 'mile (international)');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mU/g', 'milli  enzyme unit per gram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mU/mL', 'milli  enzyme unit per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mU/mL/min', 'milli  enzyme unit per milliliter per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mU/mmol{creat}', 'milli  enzyme unit per millimole of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mU/mmol{RBCs}', 'milli  enzyme unit per millimole of red blood cells');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('m[IU]/mL', 'milli  international unit per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mU/g{Hb}', 'milli enzyme unit per gram of hemoglobin');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mU/g{prot}', 'milli enzyme unit per gram of protein');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mU/L', 'milli enzyme unit per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mU/mg', 'milli enzyme unit per milligram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mU/mg{creat}', 'milli enzyme unit per milligram of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('m[IU]/L', 'milli international unit per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mA', 'milliampere');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mbar', 'millibar');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mbar/L/s', 'millibar per liter per second');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mbar.s/L', 'millibar second per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('meq', 'milliequivalent');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('meq/(2.h)', 'milliequivalent per 2 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('meq/(24.h)', 'milliequivalent per 24 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('meq/(8.h)', 'milliequivalent per 8 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('meq/d', 'milliequivalent per day');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('meq/dL', 'milliequivalent per deciliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('meq/g', 'milliequivalent per gram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('meq/g{creat}', 'milliequivalent per gram of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('meq/h', 'milliequivalent per hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('meq/kg', 'milliequivalent per kilogram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('meq/kg/h', 'milliequivalent per kilogram per hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('meq/L', 'milliequivalent per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('meq/mL', 'milliequivalent per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('meq/min', 'milliequivalent per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('meq/{specimen}', 'milliequivalent per specimen');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('meq/m2', 'milliequivalent per square meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('meq/{total_volume}', 'milliequivalent per total volume');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg', 'milligram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg{FEU}/L', 'milligram fibrinogen equivalent unit per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/(10.h)', 'milligram per 10 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/(12.h)', 'milligram per 12 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/(2.h)', 'milligram per 2 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/(24.h)', 'milligram per 24 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/(6.h)', 'milligram per 6 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/(72.h)', 'milligram per 72 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/(8.h)', 'milligram per 8 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/{collection}', 'milligram per collection');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/m3', 'milligram per cubic meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/d', 'milligram per day');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/d/{1.73_m2}', 'milligram per day per 1.73 square meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/dL', 'milligram per deciliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/dL{RBCs}', 'milligram per deciliter of red blood cells');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/g', 'milligram per gram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/g{creat}', 'milligram per gram of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/g{dry_tissue}', 'milligram per gram of dry tissue');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/g{feces}', 'milligram per gram of feces');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/g{tissue}', 'milligram per gram of tissue');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/g{wet_tissue}', 'milligram per gram of wet tissue');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/h', 'milligram per hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/kg', 'milligram per kilogram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/kg/(8.h)', 'milligram per kilogram per 8 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/kg/d', 'milligram per kilogram per day');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/kg/h', 'milligram per kilogram per hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/kg/min', 'milligram per kilogram per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/L', 'milligram per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/L{RBCs}', 'milligram per liter of red blood cells');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/mg', 'milligram per milligram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/mg{creat}', 'milligram per milligram of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/mL', 'milligram per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/mmol', 'milligram per millimole');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/mmol{creat}', 'milligram per millimole of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/min', 'milligram per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/{specimen}', 'milligram per specimen');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/m2', 'milligram per square meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/{total_output}', 'milligram per total output');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/{total_volume}', 'milligram per total volume');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mg/wk', 'milligram per week');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL', 'milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL{fetal_RBCs}', 'milliliter of fetal red blood cells');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL/(10.h)', 'milliliter per 10 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL/(12.h)', 'milliliter per 12 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL/(2.h)', 'milliliter per 2 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL/(24.h)', 'milliliter per 24 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL/(4.h)', 'milliliter per 4 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL/(5.h)', 'milliliter per 5 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL/(6.h)', 'milliliter per 6 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL/(72.h)', 'milliliter per 72 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL/(8.h)', 'milliliter per 8 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL/(8.h)/kg', 'milliliter per 8 hour per kilogram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL/cm[H2O]', 'milliliter per centimeter of water');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL/d', 'milliliter per day');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL/dL', 'milliliter per deciliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL/{beat}', 'milliliter per heart beat');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL/{beat}/m2', 'milliliter per heart beat per  square meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL/h', 'milliliter per hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL/kg', 'milliliter per kilogram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL/kg/(8.h)', 'milliliter per kilogram per 8 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL/kg/d', 'milliliter per kilogram per day');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL/kg/h', 'milliliter per kilogram per hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL/kg/min', 'milliliter per kilogram per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL/mbar', 'milliliter per millibar');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL/mm', 'milliliter per millimeter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL/min', 'milliliter per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL/min/{1.73_m2}', 'milliliter per minute per 1.73 square meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL/min/m2', 'milliliter per minute per square meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL/s', 'milliliter per second');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL/[sin_i]', 'milliliter per square inch (international)');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mL/m2', 'milliliter per square meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mm', 'millimeter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mm[Hg]', 'millimeter of mercury');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mm[H2O]', 'millimeter of water');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mm/h', 'millimeter per hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mm/min', 'millimeter per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol', 'millimole');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/(12.h)', 'millimole per 12 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/(2.h)', 'millimole per 2 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/(24.h)', 'millimole per 24 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/(5.h)', 'millimole per 5 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/(6.h)', 'millimole per 6 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/(8.h)', 'millimole per 8 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/d', 'millimole per day');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/dL', 'millimole per deciliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/{ejaculate}', 'millimole per ejaculate');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/g', 'millimole per gram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/g{creat}', 'millimole per gram of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/h', 'millimole per hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/h/mg{Hb}', 'millimole per hour per milligram of hemoglobin');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/h/mg{prot}', 'millimole per hour per milligram of protein');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/kg', 'millimole per kilogram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/kg/(8.h)', 'millimole per kilogram per 8 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/kg/d', 'millimole per kilogram per day');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/kg/h', 'millimole per kilogram per hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/kg/min', 'millimole per kilogram per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/L', 'millimole per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/L{RBCs}', 'millimole per liter of red blood cells');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/mmol', 'millimole per millimole');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/mmol{urea}', 'millimole per millimole of urea');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/mmol{creat}', 'millimole per millmole of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/min', 'millimole per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/mol', 'millimole per mole');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/mol{creat}', 'millimole per mole of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/s/L', 'millimole per second per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/{specimen}', 'millimole per specimen');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/m2', 'millimole per square meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mmol/{total_vol}', 'millimole per total volume');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('10*6', 'million');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('10*6.[CFU]/L', 'million colony forming unit per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('10*6.[IU]', 'million international unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('10*6/(24.h)', 'million per 24 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('10*6/kg', 'million per kilogram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('10*6/L', 'million per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('10*6/uL', 'million per microliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('10*6/mL', 'million per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mosm', 'milliosmole');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mosm/kg', 'milliosmole per kilogram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mosm/L', 'milliosmole per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mPa', 'millipascal');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mPa.s', 'millipascal second');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ms', 'millisecond');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mV', 'millivolt');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{minidrop}/min', 'minidrop per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{minidrop}/s', 'minidrop per second');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('min', 'minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mol', 'mole');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mol/m3', 'mole per cubic meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mol/kg', 'mole per kilogram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mol/kg/s', 'mole per kilogram per second');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mol/L', 'mole per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mol/mL', 'mole per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mol/mol', 'mole per mole');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mol/s', 'mole per second');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{#}/{platelet}', 'molecule per platelet');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mo', 'month');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{mm/dd/yyyy}', 'month-day-year');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{M.o.M}', 'multiple of the median');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{mutation}', 'mutation');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nU/mL', 'nanoenzyme unit per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nU/{RBC}', 'nanoenzyme unit per red blood cell');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ng', 'nanogram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ng{FEU}/mL', 'nanogram fibrinogen equivalent unit per milliliter ');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ng/(24.h)', 'nanogram per 24 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ng/(8.h)', 'nanogram per 8 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ng/d', 'nanogram per day');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ng/dL', 'nanogram per deciliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ng/U', 'nanogram per enzyme unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ng/g', 'nanogram per gram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ng/g{creat}', 'nanogram per gram of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ng/h', 'nanogram per hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ng/kg', 'nanogram per kilogram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ng/kg/(8.h)', 'nanogram per kilogram per 8 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ng/kg/h', 'nanogram per kilogram per hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ng/kg/min', 'nanogram per kilogram per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ng/L', 'nanogram per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ng/mg', 'nanogram per milligram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ng/mg{creat}', 'nanogram per milligram of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ng/mg{prot}', 'nanogram per milligram of protein');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ng/mg/h', 'nanogram per milligram per hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ng/mL{RBCs}', 'nanogram per milliliter of red blood cells');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ng/mL/h', 'nanogram per milliliter per hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ng/10*6', 'nanogram per million');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ng/10*6{RBCs}', 'nanogram per million red blood cells');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ng/mL', 'nanogram per millliiter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ng/min', 'nanogram per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ng/s', 'nanogram per second');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ng/m2', 'nanogram per square meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nkat', 'nanokatal');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nL', 'nanoliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nm', 'nanometer');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nm/s/L', 'nanometer per second per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol', 'nanomole');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol{BCE}', 'nanomole bone collagen equivalent');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol{BCE}/L', 'nanomole bone collagen equivalent per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/mmol{creat}', 'nanomole bone collagen equivalent per millimole of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/mg{prot}', 'nanomole of 1/2 cystine per milligram of protein');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol{ATP}', 'nanomole of ATP ');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/(24.h)', 'nanomole per 24 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/d', 'nanomole per day');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/dL', 'nanomole per deciliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/dL{GF}', 'nanomole per deciliter of glomerular filtrate');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/g', 'nanomole per gram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/g{creat}', 'nanomole per gram of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/g{dry_wt}', 'nanomole per gram of dry weight');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/h/L', 'nanomole per hour per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/h/mg{prot}', 'nanomole per hour per milligram of protein');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/L', 'nanomole per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/L{RBCs}', 'nanomole per liter of red blood cells');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/L/mmol{creat}', 'nanomole per liter per millimole of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/m/mg{prot}', 'nanomole per meter per milligram of protein');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/umol{creat}', 'nanomole per micromole  of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/mg', 'nanomole per milligram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/mg{creat}', 'nanomole per milligram of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/mg{prot}', 'nanomole per milligram of protein');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/mg{prot}/h', 'nanomole per milligram of protein per hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/mg/h', 'nanomole per milligram per hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/mL', 'nanomole per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/mL/h', 'nanomole per milliliter per hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/mL/min', 'nanomole per milliliter per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/mmol', 'nanomole per millimole');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/mmol{creat}', 'nanomole per millimole of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/min', 'nanomole per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/min/mg{Hb}', 'nanomole per minute per milligram of hemoglobin');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/min/mg{prot}', 'nanomole per minute per milligram of protein');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/min/mL', 'nanomole per minute per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/min/10*6{cells}', 'nanomole per minute per million cells');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/mol', 'nanomole per mole');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/nmol', 'nanomole per nanomole');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/s', 'nanomole per second');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('nmol/s/L', 'nanomole per second per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ns', 'nanosecond');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('N', 'Newton');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('N.cm', 'Newton centimeter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('N.s', 'Newton second');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{#}', 'number');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{#}/[HPF]', 'number per high power field');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{#}/L', 'number per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{#}/[LPF]', 'number per low power field');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{#}/uL', 'number per microliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{#}/mL', 'number per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{#}/min', 'number per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('Ohm', 'Ohm');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('Ohm.m', 'Ohm meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('10*5', 'one hundred thousand');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{OD_unit}', 'optical density unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('osm', 'osmole');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('osm/kg', 'osmole per kilogram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('osm/L', 'osmole per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[oz_av]', 'ounce (US and British)');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{Pan_Bio''U}', 'panbio unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[ppb]', 'part per billion');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[ppm]', 'part per million');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[ppm]{v/v}', 'part per million in volume per volume');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[ppth]', 'part per thousand');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[pptr]', 'part per trillion');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('Pa', 'Pascal');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/10*10', 'per 10 billion  ');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/10*4{RBCs}', 'per 10 thousand red blood cells');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/100', 'per 100');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/100{cells}', 'per 100 cells');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/100{neutrophils}', 'per 100 neutrophils');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/100{spermatozoa}', 'per 100 spermatozoa');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/100{WBCs}', 'per 100 white blood cells');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/[arb''U]', 'per arbitrary unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/10*9', 'per billion');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/cm[H2O]', 'per centimeter of water');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/m3', 'per cubic meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/d', 'per day');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/dL', 'per deciliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/{entity}', 'per entity');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/U', 'per enzyme unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/g', 'per gram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/g{creat}', 'per gram of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/g{Hb}', 'per gram of hemoglobin');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/g{tot_nit}', 'per gram of total nitrogen');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/g{tot_prot}', 'per gram of total protein');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/g{wet_tis}', 'per gram of wet tissue');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/[HPF]', 'per high power field');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/h', 'per hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/[IU]', 'per international unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/kg', 'per kilogram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/kg{body_wt}', 'per kilogram of body weight');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/L', 'per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/[LPF]', 'per low power field');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/uL', 'per microliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/mg', 'per milligram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/mL', 'per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/mm', 'per millimeter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/mmol{creat}', 'per millimole of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/10*6', 'per million');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/min', 'per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/mo', 'per month');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/{OIF}', 'per oil immersion field');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/s', 'per second');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/m2', 'per square meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/10*3', 'per thousand');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/10*3{RBCs}', 'per thousand red blood cells');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/10*12', 'per trillion ');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/10*12{RBCs}', 'per trillion red blood cells');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/(12.h)', 'per twelve hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/wk', 'per week');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('/a', 'per year');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%', 'percent');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{loss_AChR}', 'percent  loss of acetylcholine receptor');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{penetration}', 'percent  penetration');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{abnormal}', 'percent abnormal');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{activity}', 'percent activity');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{aggregation}', 'percent aggregation');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{at_60_min}', 'percent at 60 minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{basal_activity}', 'percent basal activity');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{binding}', 'percent binding');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{blockade}', 'percent blockade');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{blocked}', 'percent blocked');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{bound}', 'percent bound');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{breakdown}', 'percent breakdown');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{vol}', 'percent by volume');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{deficient}', 'percent deficient');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{dose}', 'percent dose');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{excretion}', 'percent excretion');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{Hb}', 'percent hemoglobin');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{hemolysis}', 'percent hemolysis');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{index}', 'percent index');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{inhibition}', 'percent inhibition');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{loss}', 'percent loss');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{lysis}', 'percent lysis');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{normal}', 'percent normal');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{pooled_plasma}', 'percent normal pooled plasma');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{bacteria}', 'percent of bacteria');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{baseline}', 'percent of baseline');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{cells}', 'percent of cells');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{RBCs}', 'percent of red blood cells');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{WBCs}', 'percent of white blood cells');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{positive}', 'percent positive');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{reactive}', 'percent reactive');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{recovery}', 'percent recovery');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{reference}', 'percent reference');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{residual}', 'percent residual');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{saturation}', 'percent saturation');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{total}', 'percent total');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{uptake}', 'percent uptake');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{viable}', 'percent viable');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{percentile}', 'percentile');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[pH]', 'pH');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{phenotype}', 'phenotype');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pA', 'picoampere');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pg', 'picogram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pg/{cell}', 'picogram per cell');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pg/dL', 'picogram per deciliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pg/L', 'picogram per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pg/mg', 'picogram per milligram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pg/mg{creat}', 'picogram per milligram of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pg/mL', 'picogram per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pg/mm', 'picogram per millimeter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pg/{RBC}', 'picogram per red blood cell');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pkat', 'picokatal');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pL', 'picoliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pm', 'picometer');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pmol', 'picomole');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pmol/(24.h)', 'picomole per 24 hour');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pmol/d', 'picomole per day');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pmol/dL', 'picomole per deciliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pmol/g', 'picomole per gram');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pmol/h/mg{prot}', 'picomole per hour per milligram of protein');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pmol/h/mL', 'picomole per hour per milliliter ');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pmol/L', 'picomole per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pmol/umol', 'picomole per micromole');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pmol/umol{creat}', 'picomole per micromole of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pmol/mg{prot}', 'picomole per milligram of protein');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pmol/mL', 'picomole per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pmol/mmol{creat}', 'picomole per millimole of creatinine');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pmol/min', 'picomole per minute');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pmol/min/mg{prot}', 'picomole per minute per milligram of protein');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pmol/{RBC}', 'picomole per red blood cell');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('ps', 'picosecond');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('pT', 'picotesla');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[pt_us]', 'pint (US)');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[lb_av]', 'pound (US and British)');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[psi]', 'pound per square inch');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[qt_us]', 'quart (US)');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{ratio}', 'ratio');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{RBC}/uL', 'red blood cell per microliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('%{relative}', 'relative percent');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{rel_saturation}', 'relative saturation');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{Rubella_virus}', 'rubella virus');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{saturation}', 'saturation');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('s', 'second');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('s/{control}', 'second per control');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{shift}', 'shift');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('S', 'Siemens');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('Sv', 'Sievert');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{s_co_ratio}', 'signal to cutoff ratio');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{spermatozoa}/mL', 'spermatozoa per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('cm2', 'square centimeter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('cm2/s', 'square centimeter per second');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('dm2/s2', 'square decimeter per square second');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[sft_i]', 'square foot (international)');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[sin_i]', 'square inch (international)');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('m2', 'square meter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('m2/s', 'square meter per second');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('mm2', 'square millimeter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[syd_i]', 'square yard (international)');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{STDV}', 'standard deviation');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[tbs_us]', 'tablespoon (US)');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[tsp_us]', 'teaspoon (US)');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('T', 'Tesla');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('10*3', 'thousand');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('10*3{copies}/mL', 'thousand copies per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('10*3/L', 'thousand per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('10*3/uL', 'thousand per microliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('10*3/mL', 'thousand per milliliter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('10*3{RBCs}', 'thousand red blood cells');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{TSI_index}', 'thyroid-stimulating immunoglobulin index');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{titer}', 'titer');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[todd''U]', 'Todd unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('Torr', 'Torr 
');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('10*12/L', 'trillion per liter');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[oz_tr]', 'Troy ounce');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[tb''U]', 'tuberculin unit');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('V', 'volt');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('Wb', 'Weber');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('wk', 'week');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('{WBCs}', 'white blood cells');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('[yd_i]', 'yard (international)');

INSERT INTO ERX.UCUM_CODE (CODE, DESCRIPTION) 
VALUES ('a', 'year');

COMMIT;
/

GRANT SELECT ON ERX.UCUM_CODE to ERX_READ_ROLE;
GRANT SELECT ON ERX.UCUM_CODE to ERX_UPDATE_ROLE;
GRANT SELECT ON ERX.UCUM_CODE to ERX_READ_DEIDENT_ROLE;
/

create public synonym ucum_code for erx.ucum_code;
/

-- Import Data into table ERX.UCUM_CODE  Task successful.
