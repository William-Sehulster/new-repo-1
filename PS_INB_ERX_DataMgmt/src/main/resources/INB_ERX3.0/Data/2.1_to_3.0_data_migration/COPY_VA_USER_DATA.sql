--CREATES or UPDATES Production users for IOC sites
--PROMPTs for database link name e.g.(ERXD2_DBLINK.AAC.VA.GOV)
accept dblink char prompt 'Enter source database link name: '

DROP TABLE erx.va_user_tmp;

CREATE TABLE erx.va_user_tmp AS SELECT * from erx.va_user@&dblink
WHERE va_userid not in (
'VHADUBALBRIC',
'VHADUBBLOUNB',
'VHADUBBROOKS4',
'VHADUBBRYAND',
'VHADUBCHRISK',
'VHADUBCLARKD2',
'VHADUBCLARKV2',
'VHADUBCOLLIS',
'VHADUBCOUNJ',
'VHADUBDUNNM',
'VHADUBEILANK',
'VHADUBHARVIB',
'VHADUBHOWARM3',
'VHADUBKAVURK',
'VHADUBLOWERS',
'VHADUBLUDWIC1',
'VHADUBMCNEEJ',
'VHADUBPROCTM',
'VHADUBPUTKOA',
'VHADUBTHIGPJ',
'VHADUBWALKEV16',
'VHABOSLEAVID',
'VHACMDLAICOQ',
'VHADURBUTTS',
'VHAHAMWANDLJ',
'VHAISADIODAL',
'VHAISARAVIKS',
'VHAISBBAYLIR',
'VHAISLSEBURC',
'VHAISPCHALLP',
'VHAISPTRIOG',
'VHAPBMCOULTD',
'VHAPBMGUERTC',
'VHAPBMLEESD',
'VHAINDNAVILC0',
'VHAINDPRYORT0',
'VHAFAVACOSTM',
'VHAFAVALLBRC',
'VHAFAVALLREC1',
'VHAFAVBARNEL',
'VHAFAVBOLTOH',
'VHAFAVBONDW',
'VHAFAVBYRDK',
'VHAFAVCHAPMA',
'VHAFAVCHILLK',
'VHAFAVCLARKM12',
'VHAFAVCOATEK',
'VHAFAVCOLEJ',
'VHAFAVCORBIN',
'VHAFAVCOSTNM',
'VHAFAVCROCKK5',
'VHAFAVDANIER',
'VHAFAVDANIET',
'VHAFAVDUNCAJ',
'VHAFAVFELKIA',
'VHAFAVGLIDEB',
'VHAFAVGRANTM',
'VHAFAVGRAYJE',
'VHAFAVHANNAK',
'VHAFAVHARPEB',
'VHAFAVHODGEB',
'VHAFAVJEANL',
'VHAFAVJOHNSR',
'VHAFAVKARLSK',
'VHAFAVKENNAS',
'VHAFAVLACKEB',
'VHAFAVLAWREA',
'VHAFAVLOGET',
'VHAFAVMILLWM',
'VHAFAVMONTGC2',
'VHAFAVNEWCOW',
'VHAFAVNEWCOW',
'VHAFAVNICHOP',
'VHAFAVOGLER',
'VHAFAVOLIVEM',
'VHAFAVPHELAS',
'VHAFAVPIELM',
'VHAFAVRABONH',
'VHAFAVRUNNEK',
'VHAFAVRUSHAM',
'VHAFAVSCHRAK',
'VHAFAVSCHUSS',
'VHAFAVSEATOV',
'VHAFAVSEDLAJ',
'VHAFAVSHEILE',
'VHAFAVSMITHT16',
'VHAFAVSONNIJ',
'VHAFAVSTARKJ1',
'VHAFAVSTEIND2',
'VHAFAVTEBBEC',
'VHAFAVTIDYMC',
'VHAFAVWAGESJ',
'VHAFAVWAGNEE',
'VHAFAVWALKEM',
'VHAFAVWALTET',
'VHAFAVWAYMAJ',
'VHAFAVWELLSL',
'VHAFAVWHITEM1',
'VHAFAVWILESR',
'VHAFAVWOOTOM');

--merging all users excluding the previoulsy merged IOC sites Indianapolis, Fayettville (ARK.) and MbM Dublin. Also PBM, HPS and Maintenance team.

MERGE INTO erx.va_user target
USING (SELECT
va_userid,
first_name,
last_name,
is_pharm_mgr,
is_pbm_admn,
is_pharm_tech,
is_system_admn,
updated_date,
created_date,
updated_by,
created_by
FROM erx.va_user_tmp) s
ON (target.va_userid = s.va_userid)
WHEN MATCHED THEN
	UPDATE SET
target.first_name = s.first_name,
target.last_name = s.last_name,
target.is_pharm_mgr = s.is_pharm_mgr,
target.is_pbm_admn = s.is_pbm_admn,
target.is_pharm_user = s.is_pharm_tech,
target.is_system_admn = s.is_system_admn,
target.updated_date = s.updated_date,
target.created_date = s.created_date,
target.updated_by = s.updated_by,
target.created_by = s.created_by,
target.is_enabled = 'Y',
target.va_station_ids = 'All'
WHEN NOT MATCHED THEN
INSERT
(va_userid,
first_name,
last_name,
is_pharm_mgr,
is_pbm_admn,
is_pharm_user,
is_system_admn,
updated_date,
created_date,
updated_by,
created_by,
is_enabled,
va_station_ids)
VALUES (
s.va_userid,
s.first_name,
s.last_name,
s.is_pharm_mgr,
s.is_pbm_admn,
s.is_pharm_tech,
s.is_system_admn,
s.updated_date,
s.created_date,
s.updated_by,
s.created_by,
'Y',
'All');

--Alexandria VAMC 502
UPDATE erx.va_user 
SET va_station_ids = '502'
WHERE va_userid IN(
'VHAALNCARPEM',
'VHAALNFREEMK1',
'VHAALNOBRIED',
'VHAALXGUEDRC',
'VHAALXHURSEA',
'VHAALXWYATTM');

--Anchorage VAMC 463
UPDATE erx.va_user 
SET va_station_ids = '463'
WHERE va_userid IN(
'VHAANCBALANM',
'VHAANCBANKSX',
'VHAANCBRIDGJ',
'VHAANCCARDKV',
'VHAANCDALEMI',
'VHAANCELLIOL',
'VHAANCEMBURE',
'VHAANCHANSES',
'VHAANCHJELDM',
'VHAANCHOLDEJ',
'VHAANCISABEJ',
'VHAANCJENSEB',
'VHAANCMADDOS',
'VHAANCMAT',
'VHAANCMCMILR',
'VHAANCOMANDM',
'VHAANCPHIFEA',
'VHAANCPOWELM',
'VHAANCWALLR',
'VHAANCWALLR1',
'VHAANCWALLRO',
'VHAANCWANEKJ',
'VHAANCWRIGHR');

--BRONX VAMC 526
UPDATE erx.va_user 
SET va_station_ids = '526'
WHERE va_userid IN(
'VHABRXANDERR2',
'VHABRXHOW',
'VHABRXLEIBFE');

--Central Alabama 619GF
UPDATE erx.va_user 
SET va_station_ids = '619GF'
WHERE va_userid IN(
'VHACAVBEASLT',
'VHACAVBUSHP',
'VHACAVCLARKL3',
'VHACAVCOLEMK2',
'VHACAVJOHNSF2',
'VHACAVJOHNSL',
'VHACAVMARTIK',
'VHACAVMILLSD',
'VHACAVMONDAD',
'VHACAVNEIGHL',
'VHACAVNICHOD',
'VHACAVROBINA',
'VHACAVROBINM17',
'VHACAVROPERB');

--CHEYENNE 442
UPDATE erx.va_user 
SET va_station_ids = '442'
WHERE va_userid IN(
'VHACHYLEWISC',
'VHACHYLYONSD');

--Chillicothe 538
UPDATE erx.va_user 
SET va_station_ids = '538'
WHERE va_userid IN(
'VHACLLHAASC',
'VHACLLTAYLOT');

--Marion 610
UPDATE erx.va_user 
SET va_station_ids = '610'
WHERE va_userid IN(
'VHADANADAIRK',
'VHADANBAYSM',
'VHADANBURKD',
'VHADANBURKEM2',
'VHADANCANCIM1',
'VHADANCHANTA1',
'VHADANCOFFIL',
'VHADANCOPELV',
'VHADANDELOND1',
'VHADANFITZGR2',
'VHADANHAYNEJ',
'VHADANHOAGLA1',
'VHADANKUBERR',
'VHADANLAUERD',
'VHADANLORICB1',
'VHADANLUCHTH',
'VHADANMCBETB',
'VHADANMCMASS',
'VHADANMOHAMR',
'VHADANNORTOC1',
'VHADANPATELA1',
'VHADANPATTEC1',
'VHADANPOLSOK',
'VHADANRAYAMA1',
'VHADANRAYMOK1',
'VHADANRICEK1',
'VHADANSIEGMD',
'VHADANTHOMAA',
'VHADANTHORPM',
'VHADANTIPTOJ',
'VHADANWORLEK');

--El Paso 756
UPDATE erx.va_user 
SET va_station_ids = '756'
WHERE va_userid IN(
'VHAELPAYOKOE');

--Additional Fayetteville, Arkansas 564
UPDATE erx.va_user 
SET va_station_ids = '564'
WHERE va_userid IN(
'VHAFAVBORKOM',
'VHAFAVCOXM10');

--Fresno 570
UPDATE erx.va_user 
SET va_station_ids = '570'
WHERE va_userid IN(
'VHAFREBASTIK',
'VHAFRELAMBEC',
'VHAFRENGUYED15',
'VHAFREYANGN');

--Grand Island 636A4, 636A5
UPDATE erx.va_user 
SET va_station_ids = '636A4,636A5'
WHERE va_userid IN(
'VHAGRIMCINTJ');

--Honolulu 459
UPDATE erx.va_user 
SET va_station_ids = '459'
WHERE va_userid IN(
'VHAHONWATSOG');

--Jackson 586
UPDATE erx.va_user 
SET va_station_ids = '586'
WHERE va_userid IN(
'VHAJACCOXAMA8',
'VHAJACDAYLA8',
'VHAJACHENDRK',
'VHAJACJONESA3',
'VHAJACLUCKEB',
'VHAJACMARTIJ1',
'VHAJACMCKINJ',
'VHAJACMILLEJ1',
'VHAJACTHOMPC1');

--Lincoln 636A5, 636A4
UPDATE erx.va_user 
SET va_station_ids = '636A5,636A4,636'
WHERE va_userid IN(
'VHALINBARTHC',
'VHALINKRATZK ');

--Manchester 608
UPDATE erx.va_user 
SET va_station_ids = '608'
WHERE va_userid IN(
'VHAMANHILLC',
'VHAMANJAWL',
'VHAMANKELLEM',
'VHAMANLENTOG',
'VHAMANMARTIM',
'VHAMANMORRIH',
'VHAMANPOTTEF',
'VHAMANRENZEE',
'VHAMANSHERMD',
'VHAMANVARMAP');

--Muskogee 623
UPDATE erx.va_user 
SET va_station_ids = '623'
WHERE va_userid IN(
'VHAMUSRICHTM');

--Martinsburg 613
UPDATE erx.va_user 
SET va_station_ids = '613'
WHERE va_userid IN(
'VHAMWVJORDAA',
'VHAMWVTURNBR');

--Fort Wayne 610A4
UPDATE erx.va_user 
SET va_station_ids = '610A4'
WHERE va_userid IN(
'VHANINKRONBM',
'VHANINNUENB');

--Dallas, Bonham, Ft. Worth 549, 549A4, 549BY
UPDATE erx.va_user 
SET va_station_ids = '549,549A4,549BY'
WHERE va_userid IN(
'VHANTXCHENFR',
'VHANTXDESAIA',
'VHANTXELLAMC',
'VHANTXMONICR');

--Omaha 636
UPDATE erx.va_user 
SET va_station_ids = '636'
WHERE va_userid IN(
'VHAOMACONIGJ');

--Palo Alto 640
UPDATE erx.va_user 
SET va_station_ids = '640'
WHERE va_userid IN(
'VHAPALKLAHOD',
'VHAPALLOREGI',
'VHAPALPARKHE',
'VHAPALSONGE');

--Prescott 649
UPDATE erx.va_user 
SET va_station_ids = '649'
WHERE va_userid IN(
'VHAPREBORUCA',
'VHAPREMANNK');

--Reno 654
UPDATE erx.va_user 
SET va_station_ids = '654'
WHERE va_userid IN(
'VHARENPATCHG',
'VHARENROSSN');

--Sioux Falls 438
UPDATE erx.va_user 
SET va_station_ids = '438'
WHERE va_userid IN(
'VHASUXMETZGJ',
'VHASUXSCHROK');

--Syracuse Albany 528A7 528A8
UPDATE erx.va_user 
SET va_station_ids = '528A7,528A8'
WHERE va_userid IN(
'VHASYRBARBUJ',
'VHASYRGUNTHP',
'VHASYRHEATOM',
'VHASYRMANLEJ');

--Nashville 626
UPDATE erx.va_user 
SET va_station_ids = '626'
WHERE va_userid IN(
'VHATVHCASSIR',
'VHATVHCLAUSS',
'VHATVHHOFFMT',
'VHATVHINGRAT',
'VHATVHMORGAK1',
'VHATVHPHILLM',
'VHATVHROYALA',
'VHATVHSAFARM',
'VHATVHSHACKD');

--Wichita 589A7
UPDATE erx.va_user 
SET va_station_ids = '589A7'
WHERE va_userid IN(
'VHAWICALEXAH',
'VHAWICCURTID',
'VHAWICDOANS',
'VHAWICFLETEM',
'VHAWICHOODR',
'VHAWICJONESA3',
'VHAWICLEGGR');

--West Palm Beach 548
UPDATE erx.va_user 
SET va_station_ids = '548'
WHERE va_userid IN(
'VHAWPBALVARM',
'VHAWPBANTOUM',
'VHAWPBBECKEN',
'VHAWPBBERRIJ1',
'VHAWPBCARROM1',
'VHAWPBCHAT',
'VHAWPBCLARKT1',
'VHAWPBFORBEH',
'VHAWPBFULTOM',
'VHAWPBGRIFFC2',
'VHAWPBHARVER',
'VHAWPBHEYMAJ',
'VHAWPBKEMPLJ',
'VHAWPBORTIZM1',
'VHAWPBPARELC',
'VHAWPBPATELN5',
'VHAWPBPEREZA2',
'VHAWPBRAUCHR',
'VHAWPBRHEEP',
'VHAWPBRIVERL1',
'VHAWPBSTEWAL',
'VHAWPBVALENJ2',
'VHAWPBVAZQUL');

--WallaWalla 687
UPDATE erx.va_user 
SET va_station_ids = '687'
WHERE va_userid IN(
'VHAWWWWALTEA');

--Phoenix 644
UPDATE erx.va_user 
SET va_station_ids = '644'
WHERE va_userid IN(
'VHAPHOROBERR',
'VHAPHORIVASS',
'VHAPHOMELDRM');

COMMIT;

DROP TABLE erx.va_user_tmp;