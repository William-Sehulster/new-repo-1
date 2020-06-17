DROP TABLE PDI.R_STEP_TYPE
;

CREATE TABLE PDI.R_STEP_TYPE
(
  ID_STEP_TYPE INTEGER
, CODE VARCHAR2(255)
, DESCRIPTION VARCHAR2(255)
, HELPTEXT VARCHAR2(255)
, PRIMARY KEY (ID_STEP_TYPE)
)
;

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (1,'Delete','Delete','Delete data in a database table based upon keys');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (2,'SyslogMessage','Send message to Syslog','Send message to Syslog server');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (3,'WriteToLog','Write to log','Write data to log');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (4,'TextFileOutput','Text file output','Write rows to a text file.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (5,'MultiwayMergeJoin','Multiway Merge Join','Multiway Merge Join');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (6,'LDAPOutput','LDAP Output','Perform Insert, upsert, update, add or delete operations on records based on their DN (Distinguished  Name).');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (7,'AccessInput','Microsoft Access Input','Read data from a Microsoft Access file');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (8,'JoinRows','Join Rows (cartesian product)','The output of this step is the cartesian product of the input streams.'||chr(13)||'The number of rows is the multiplication of the number of rows in the input streams.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (9,'JsonInput','JSON Input','Extract relevant portions out of JSON structures (file or incoming field) and output rows');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (10,'TableOutput','Table output','Write information to a database table');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (11,'MySQLBulkLoader','MySQL Bulk Loader','MySQL bulk loader step, loading data over a named pipe (not available on MS Windows)');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (12,'SingleThreader','Single Threader','Executes a transformation snippet in a single thread.  You need a standard mapping or a transformation with an Injector step where data from the parent transformation will arive in blocks.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (13,'HL7Input','HL7 Input','Reads and parses HL7 messages and outputs a series of values from the messages');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (14,'RandomCCNumberGenerator','Generate random credit card numbers','Generate random valide (luhn check) credit card numbers');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (15,'RegexEval','Regex Evaluation','Regular expression Evaluation'||chr(13)||'This step uses a regular expression to evaluate a field. It can also extract new fields out of an existing field with capturing groups.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (16,'HadoopEnterPlugin','MapReduce Input','Enter a Hadoop Mapper or Reducer transformation');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (17,'PaloDimOutput','Palo Dim Output','Writes data to defined Palo Dimension');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (18,'S3FileOutputPlugin','S3 File Output','Create files in an S3 location');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (19,'ColumnExists','Check if a column exists','Check if a column exists in a table on a specified connection.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (20,'IfNull','If field value is null','Sets a field value to a constant if it is null.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (21,'FileLocked','Check if file is locked','Check if a file is locked by another process');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (22,'SocketWriter','Socket writer','Socket writer.  A socket server that can send rows of data to a socket reader.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (23,'ExcelInput','Microsoft Excel Input','Read data from Excel and OpenOffice Workbooks (XLS, XLSX, ODS).');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (24,'TeraFast','Teradata Fastload Bulk Loader','The Teradata Fastload Bulk loader');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (25,'DataGrid','Data Grid','Enter rows of static data in a grid, usually for testing, reference or demo purpose');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (26,'DetectLastRow','Identify last row in a stream','Last row will be marked');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (27,'TypeExitEdi2XmlStep','Edi to XML','Converts Edi text to generic XML');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (28,'SortRows','Sort rows','Sort rows based upon field values (ascending or descending)');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (29,'FieldsChangeSequence','Add value fields changing sequence','Add sequence depending of fields value change.'||chr(13)||'Each time value of at least one field change, PDI will reset sequence. ');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (30,'RowsFromResult','Get rows from result','This allows you to read rows from a previous entry in a job.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (31,'JobExecutor','Job Executor','This step executes a Pentaho Data Integration job, sets parameters and passes rows.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (32,'BlockUntilStepsFinish','Block this step until steps finish','Block this step until selected steps finish.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (33,'AutoDoc','Automatic Documentation Output','This step automatically generates documentation based on input in the form of a list of transformations and jobs');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (34,'SFTPPut','SFTP Put','Upload a file or a stream file to remote host via SFTP');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (35,'ProcessFiles','Process files','Process one file per row (copy or move or delete).'||chr(13)||'This step only accept filename in input.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (36,'RuleAccumulator','Rules Accumulator','Rules Accumulator Step');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (37,'DimensionLookup','Dimension lookup/update','Update a slowly changing dimension in a data warehouse.'||chr(13)||'Alternatively, look up information in this dimension.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (38,'TypeExitGoogleAnalyticsInputStep','Google Analytics','Fetches data from google analytics account');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (39,'PaloCellInput','Palo Cell Input','Reads data from a defined Palo Cube ');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (40,'Append','Append streams','Append 2 streams in an ordered way');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (41,'ZipFile','Zip file','Zip a file.'||chr(13)||'Filename will be extracted from incoming stream.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (42,'HBaseRowDecoder','HBase Row Decoder','Decodes an incoming key and HBase result object according to a mapping ');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (43,'StringCut','Strings cut','Strings cut (substring).');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (44,'MergeRows','Merge Rows (diff)','Merge two streams of rows, sorted on a certain key.  The two streams are compared and the equals, changed, deleted and new rows are flagged.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (45,'Validator','Data Validator','Validates passing data based on a set of rules');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (46,'SSTableOutput','SSTable Output','Writes to a filesystem directory as a Cassandra SSTable');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (47,'MemoryGroupBy','Memory Group by','Builds aggregates in a group by fashion.'||chr(13)||'This step doesn''t require sorted input.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (48,'SystemInfo','Get System Info','Get information from the system like system date, arguments, etc.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (49,'Denormaliser','Row denormaliser','Denormalises rows by looking up key-value pairs and by assigning them to new fields in the output rows.'||chr(13)||'This method aggregates and needs the input rows to be sorted on the grouping fields');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (50,'ExcelOutput','Microsoft Excel Output','Stores records into an Excel (XLS) document with formatting information.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (51,'Delay','Delay row','Output each input row after a delay');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (52,'OlapInput','OLAP Input','Execute and retrieve data using an MDX query against any XML/A OLAP datasource using olap4j');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (53,'NullIf','Null if...','Sets a field value to null if it is equal to a constant value');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (54,'SalesforceInput','Salesforce Input','Extract data from Salesforce');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (55,'CallEndpointStep','Call endpoint','Call an endpoint of the BA Server.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (56,'HBaseOutput','HBase Output','Writes data to an HBase table according to a mapping');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (57,'SocketReader','Socket reader','Socket reader.  A socket client that connects to a server (Socket Writer step).');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (58,'CombinationLookup','Combination lookup/update','Update a junk dimension in a data warehouse.'||chr(13)||'Alternatively, look up information in this dimension.'||chr(13)||'The primary key of a junk dimension are all the fields.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (59,'FilesToResult','Set files in result','This step allows you to set filenames in the result of this transformation.'||chr(13)||'Subsequent job entries can then use this information.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (60,'GPBulkLoader','Greenplum Bulk Loader','Greenplum Bulk Loader');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (61,'VerticaBulkLoader','Vertica Bulk Loader','Bulk load data into a Vertica database table');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (62,'SalesforceDelete','Salesforce Delete','Delete records in Salesforce module.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (63,'HTTP','HTTP Client','Call a web service over HTTP by supplying a base URL by allowing parameters to be set dynamically');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (64,'XSDValidator','XSD Validator','Validate XML source (files or streams) against XML Schema Definition.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (65,'SetValueConstant','Set field value to a constant','Set value of a field to a constant');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (66,'ScriptValueMod','Modified Java Script Value','This is a modified plugin for the Scripting Values with improved interface and performance.'||chr(13)||'Written '||chr(38)||' donated to open source by Martin Lange, Proconis : http://www.proconis.de');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (67,'CassandraInput','Cassandra Input','Reads data from a Cassandra table');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (68,'SwitchCase','Switch / Case','Switch a row to a certain target step based on the case value in a field.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (69,'DBLookup','Database lookup','Look up values in a database using field values');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (70,'FuzzyMatch','Fuzzy match','Finding approximate matches to a string using matching algorithms.'||chr(13)||'Read a field from a main stream and output approximative value from lookup stream.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (71,'TeraDataBulkLoader','Teradata TPT Bulk Loader','Teradata TPT bulkloader, using tbuild command');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (72,'TextFileInput','Text file input','Read data from a text file in several formats.'||chr(13)||'This data can then be passed on to the next step(s)...');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (73,'SalesforceInsert','Salesforce Insert','Insert records in Salesforce module.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (74,'CouchDbInput','CouchDb Input','Reads from a Couch DB view');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (75,'ShapeFileReader','ESRI Shapefile Reader','Reads shape file data from an ESRI shape file and linked DBF file');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (76,'RssInput','RSS Input','Read RSS feeds');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (77,'Unique','Unique rows','Remove double rows and leave only unique occurrences.'||chr(13)||'This works only on a sorted input.'||chr(13)||'If the input is not sorted, only double consecutive rows are handled correctly.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (78,'InfobrightOutput','Infobright Loader','Load data to an Infobright database table');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (79,'UserDefinedJavaClass','User Defined Java Class','This step allows you to program a step using Java code');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (80,'OraBulkLoader','Oracle Bulk Loader','Use Oracle Bulk Loader to load data');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (81,'StepsMetrics','Output steps metrics','Return metrics for one or several steps');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (82,'AvroInput','Avro Input','Reads data from an Avro file');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (83,'GetTableNames','Get table names','Get table names from database connection and send them to the next step');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (84,'SetSessionVariableStep','Set session variables','Set session variables in the current user session.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (85,'MappingInput','Mapping input specification','Specify the input interface of a mapping');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (86,'Abort','Abort','Abort a transformation');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (87,'PropertyOutput','Properties Output','Write data to properties file');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (88,'JsonOutput','JSON Output','Create JSON block and output it in a field or a file.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (89,'TableExists','Table exists','Check if a table exists on a specified connection');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (90,'DetectEmptyStream','Detect empty stream','This step will output one empty row if input stream is empty'||chr(13)||'(ie when input stream does not contain any row)');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (91,'GPLoad','Greenplum Load','Greenplum Load');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (92,'PaloDimInput','Palo Dim Input','Reads data from a defined Palo Dimension');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (93,'Normaliser','Row Normaliser','De-normalised information can be normalised using this step type.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (94,'SelectValues','Select values','Select or remove fields in a row.'||chr(13)||'Optionally, set the field meta-data: type, length and precision.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (95,'XMLInputStream','XML Input Stream (StAX)','This step is capable of processing very large and complex XML files very fast.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (96,'Flattener','Row flattener','Flattens consecutive rows based on the order in which they appear in the input stream');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (97,'InsertUpdate','Insert / Update','Update or insert rows in a database based upon keys.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (98,'MondrianInput','Mondrian Input','Execute and retrieve data using an MDX query against a Pentaho Analyses OLAP server (Mondrian)');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (99,'SQLFileOutput','SQL File Output','Output SQL INSERT statements to file');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (100,'ReplaceString','Replace in string','Replace all occurences a word in a string with another word.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (101,'CubeInput','De-serialize from file','Read rows of data from a data cube.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (102,'WebServiceLookup','Web Services Lookup','Look up information using web services (WSDL)');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (103,'TableCompare','Table Compare','Compares 2 tables and gives back a list of differences');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (104,'MailValidator','Mail Validator','Check if an email address is valid.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (105,'OpenERPObjectOutputImport','OpenERP Object Output','Writes data into OpenERP objects using the object import procedure');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (106,'RowGenerator','Generate Rows','Generate a number of empty or equal rows.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (107,'DBJoin','Database join','Execute a database query using stream values as parameters');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (108,'RuleExecutor','Rules Executor','Rules Executor Step');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (109,'MergeJoin','Merge Join','Joins two streams on a given key and outputs a joined set. The input streams must be sorted on the join key');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (110,'OpenERPObjectInput','OpenERP Object Input','Reads data from OpenERP objects');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (111,'SalesforceUpdate','Salesforce Update','Update records in Salesforce module.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (112,'GetVariable','Get Variables','Determine the values of certain (environment or Kettle) variables and put them in field values.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (113,'XMLJoin','XML Join','Joins a stream of XML-Tags into a target XML string');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (114,'DBProc','Call DB Procedure','Get back information by calling a database procedure.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (115,'RssOutput','RSS Output','Read RSS stream.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (116,'S3CSVINPUT','S3 CSV Input','Is capable of reading CSV data stored on Amazon S3 in parallel');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (117,'SimpleMapping','Simple Mapping (sub-transformation)','Run a mapping (sub-transformation), use MappingInput and MappingOutput to specify the fields interface.  This is the simplified version only allowing one input and one output data set.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (118,'OpenERPObjectDelete','OpenERP Object Delete','Deletes OpenERP objects');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (119,'LDAPInput','LDAP Input','Read data from LDAP host');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (120,'XBaseInput','XBase input','Reads records from an XBase type of database file (DBF)');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (121,'CheckSum','Add a checksum','Add a checksum column for each input row');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (122,'MetaInject','ETL Metadata Injection','This step allows you to inject metadata into an existing transformation prior to execution.  This allows for the creation of dynamic and highly flexible data integration solutions.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (123,'ParallelGzipCsvInput','GZIP CSV Input','Parallel GZIP CSV file input reader');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (124,'SortedMerge','Sorted Merge','Sorted Merge');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (125,'ChangeFileEncoding','Change file encoding','Change file encoding and create a new file');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (126,'LoadFileInput','Load file content in memory','Load file content in memory');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (127,'Janino','User Defined Java Expression','Calculate the result of a Java Expression using Janino');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (128,'getXMLData','Get data from XML','Get data from XML file by using XPath.'||chr(13)||' This step also allows you to parse XML defined in a previous field.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (129,'LDIFInput','LDIF Input','Read data from LDIF files');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (130,'PGBulkLoader','PostgreSQL Bulk Loader','PostgreSQL Bulk Loader');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (131,'CubeOutput','Serialize to file','Write rows of data to a data cube');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (132,'SymmetricCryptoTrans','Symmetric Cryptography','Encrypt or decrypt a string using symmetric encryption.'||chr(13)||'Available algorithms are DES, AES, TripleDES.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (133,'AddXML','Add XML','Encode several fields into an XML fragment');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (134,'TableInput','Table input','Read information from a database table.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (135,'SASInput','SAS Input','This step reads files in sas7bdat (SAS) native format');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (136,'AccessOutput','Microsoft Access Output','Stores records into an MS-Access database table.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (137,'ElasticSearchBulk','ElasticSearch Bulk Insert','Performs bulk inserts into ElasticSearch');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (138,'GetFileNames','Get File Names','Get file names from the operating system and send them to the next step.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (139,'StringOperations','String operations','Apply certain operations like trimming, padding and others to string value.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (140,'SetVariable','Set Variables','Set environment variables based on a single input row.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (141,'RandomValue','Generate random value','Generate random value');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (142,'MongoDbOutput','MongoDB Output','Writes to a Mongo DB collection');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (143,'GetSessionVariableStep','Get session variables','Get session variables from the current user session.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (144,'FieldSplitter','Split Fields','When you want to split a single field into more then one, use this step type.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (145,'BlockingStep','Blocking Step','This step blocks until all incoming rows have been processed.  Subsequent steps only recieve the last input row to this step.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (146,'CsvInput','CSV file input','Simple CSV file input');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (147,'HBaseInput','HBase Input','Reads data from a HBase table according to a mapping ');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (148,'FieldMetadataAnnotation','Annotate Stream','Add more details to describe data for published models used by the Streamlined Data Refinery.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (149,'PropertyInput','Property Input','Read data (key, value) from properties files.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (150,'SynchronizeAfterMerge','Synchronize after merge','This step perform insert/update/delete in one go based on the value of a field. ');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (151,'Dummy','Dummy (do nothing)','This step type doesn''t do anything.'||chr(13)||'It''s useful however when testing things or in certain situations where you want to split streams.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (152,'StreamLookup','Stream lookup','Look up values coming from another stream in the transformation.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (153,'PGPEncryptStream','PGP Encrypt stream','Encrypt data stream with PGP');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (154,'GetFilesRowsCount','Get Files Rows Count','Returns rows count for text files.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (155,'SetValueField','Set field value','Set value of a field with another value field');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (156,'PGPDecryptStream','PGP Decrypt stream','Decrypt data stream with PGP');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (157,'HadoopFileOutputPlugin','Hadoop File Output','Create files in an HDFS location ');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (158,'Mapping','Mapping (sub-transformation)','Run a mapping (sub-transformation), use MappingInput and MappingOutput to specify the fields interface');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (159,'DynamicSQLRow','Dynamic SQL row','Execute dynamic SQL statement build in a previous field');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (160,'Update','Update','Update data in a database table based upon keys');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (161,'UniqueRowsByHashSet','Unique rows (HashSet)','Remove double rows and leave only unique occurrences by using a HashSet.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (162,'Formula','Formula','Calculate a formula using Pentaho''s libformula');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (163,'HadoopFileInputPlugin','Hadoop File Input','Process files from an HDFS location');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (164,'WebServiceAvailable','Check if webservice is available','Check if a webservice is available');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (165,'CreateSharedDimensions','Shared Dimension','Create shared dimensions for use with Streamlined Data Refinery.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (166,'ExecProcess','Execute a process','Execute a process and return the result');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (167,'Injector','Injector','Injector step to allow to inject rows into the transformation through the java API');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (168,'SampleRows','Sample rows','Filter rows based on the line number.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (169,'DummyStep','Example Step','This is a plugin example step');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (170,'GetSlaveSequence','Get ID from slave server','Retrieves unique IDs in blocks from a slave server.  The referenced sequence needs to be configured on the slave server in the XML configuration file.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (171,'FileExists','File exists','Check if a file exists');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (172,'MappingOutput','Mapping output specification','Specify the output interface of a mapping');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (173,'Script','Script','Calculate values by scripting in Ruby, Python, Groovy, JavaScript, ... (JSR-223)');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (174,'GroupBy','Group by','Builds aggregates in a group by fashion.'||chr(13)||'This works only on a sorted input.'||chr(13)||'If the input is not sorted, only double consecutive rows are handled correctly.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (175,'GetRepositoryNames','Get repository names','Lists detailed information about transformations and/or jobs in a repository');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (176,'PaloCellOutput','Palo Cell Output','Writes data to a defined Palo Cube');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (177,'ClosureGenerator','Closure Generator','This step allows you to generates a closure table using parent-child relationships.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (178,'Sequence','Add sequence','Get the next value from an sequence');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (179,'FilterRows','Filter rows','Filter rows using simple equations');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (180,'VectorWiseBulkLoader','Ingres VectorWise Bulk Loader','This step interfaces with the Ingres VectorWise Bulk Loader "COPY TABLE" command.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (181,'ConcatFields','Concat Fields','Concat fields together into a new field (similar to the Text File Output step)');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (182,'TypeExitExcelWriterStep','Microsoft Excel Writer','Writes or appends data to an Excel file');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (183,'OldTextFileInput','Old Text file input','Read data from a text file in several formats.'||chr(13)||'This data can then be passed on to the next step(s)...');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (184,'AnalyticQuery','Analytic Query','Execute analytic queries over a sorted dataset (LEAD/LAG/FIRST/LAST)');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (185,'FixedInput','Fixed file input','Fixed file input');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (186,'SapInput','SAP Input','Read data from SAP ERP, optionally with parameters');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (187,'PrioritizeStreams','Prioritize streams','Prioritize streams in an order way.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (188,'CassandraOutput','Cassandra Output','Writes to a Cassandra table');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (189,'ValueMapper','Value Mapper','Maps values of a certain field from one value to another');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (190,'Constant','Add constants','Add one or more constants to the input rows');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (191,'ExecSQLRow','Execute row SQL script','Execute SQL script extracted from a field'||chr(13)||'created in a previous step.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (192,'JavaFilter','Java Filter','Filter rows using java code');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (193,'HadoopExitPlugin','MapReduce Output','Exit a Hadoop Mapper or Reducer transformation ');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (194,'XMLOutput','XML Output','Write data to an XML file');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (195,'ReservoirSampling','Reservoir Sampling','[Transform] Samples a fixed number of rows from the incoming stream');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (196,'RowsToResult','Copy rows to result','Use this step to write rows to the executing job.'||chr(13)||'The information will then be passed to the next entry in this job.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (197,'SalesforceUpsert','Salesforce Upsert','Insert or update records in Salesforce module.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (198,'ExecSQL','Execute SQL script','Execute an SQL script, optionally parameterized using input rows');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (199,'MonetDBAgileMart','MonetDB Agile Mart','Load data into MonetDB for Agile BI use cases');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (200,'Rest','REST Client','Consume RESTfull services.'||chr(13)||'REpresentational State Transfer (REST) is a key design idiom that embraces a stateless client-server'||chr(13)||'architecture in which the web services are viewed as resources and can be identified by their URLs');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (201,'LucidDBStreamingLoader','LucidDB Streaming Loader','Load data into LucidDB by using Remote Rows UDX.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (202,'TransExecutor','Transformation Executor','This step executes a Pentaho Data Integration transformation, sets parameters and passes rows.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (203,'Calculator','Calculator','Create new fields by performing simple calculations');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (204,'StepMetastructure','Metadata structure of stream','This is a step to read the metadata of the incoming stream.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (205,'SplitFieldToRows3','Split field to rows','Splits a single string field by delimiter and creates a new row for each split term');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (206,'MongoDbInput','MongoDB Input','Reads from a Mongo DB collection');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (207,'FilesFromResult','Get files from result','This step allows you to read filenames used or generated in a previous entry in a job.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (208,'YamlInput','Yaml Input ','Read YAML source (file or stream) parse them and convert them to rows and writes these to one or more output. ');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (209,'UnivariateStats','Univariate Statistics','This step computes some simple stats based on a single input field');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (210,'SSH','Run SSH commands','Run SSH commands and returns result.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (211,'MailInput','Email messages input','Read POP3/IMAP server and retrieve messages');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (212,'XSLT','XSL Transformation','Make an XSL Transformation');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (213,'CloneRow','Clone row','Clone a row as many times as needed');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (214,'HTTPPOST','HTTP Post','Call a web service request over HTTP by supplying a base URL by allowing parameters to be set dynamically');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (215,'TableAgileMart','Table Agile Mart','Load data into a table for Agile BI use cases');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (216,'GetSubFolders','Get SubFolder names','Read a parent folder and return all subfolders');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (217,'CreditCardValidator','Credit card validator','The Credit card validator step will help you tell:'||chr(13)||'(1) if a credit card number is valid (uses LUHN10 (MOD-10) algorithm)'||chr(13)||'(2) which credit card vendor handles that number'||chr(13)||'(VISA, MasterCard, Diners Club, EnRoute, American Express (AMEX),...)');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (218,'NumberRange','Number range','Create ranges based on numeric field');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (219,'Mail','Mail','Send eMail.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (220,'MonetDBBulkLoader','MonetDB Bulk Loader','Load data into MonetDB by using their bulk load command in streaming mode.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (221,'SecretKeyGenerator','Secret key generator','Generate secret key for algorithms such as DES, AES, TripleDES.');

INSERT INTO PDI.R_STEP_TYPE(ID_STEP_TYPE, CODE, DESCRIPTION, HELPTEXT) VALUES (222,'PentahoReportingOutput','Pentaho Reporting Output','Executes an existing report (PRPT)');
