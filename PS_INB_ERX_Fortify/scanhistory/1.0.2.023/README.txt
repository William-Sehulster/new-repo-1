https://wiki.mobilehealth.va.gov/display/OISSWA/How+to+resolve+scanning+issues+reported+by+Fortify

20 - 12022 Warning are being thrown related to this Wiki entry:

12022  The class [. . .] could not be found on the classpath, but it was found in the jar provided by HPE Fortify. . . Set the Java version explicitly, if not set, and modify the classpath supplied to Fortify to include the jar files indicated.  If Fortify pulled in the correct version of the jar files then this can be considered not an issue but a readme file must be included explaining they are the correct versions. 

Details of warnings and why this should not be considered any issue based on the Wiki guidance above follows...

All 20 warnings are identical to the warning listed below:

The class "org.apache.log4j.Logger" could not be found on the classpath, but it was found in the jar provided by HPE Fortify in "C:\Data\HP_Fortify\Fortify_SCA_and_Apps_16.20\Core\default_jars\log4j-1.2.17.jar" as a convenience. To ensure consistent translation behavior add the jar that contains "org.apache.log4j.Logger" to the classpath given to the translation step. Refer to the documentation about default jars in the SCA User Guide for more information.

The 1.2.17 log4j jars are on the build classpath.  The use of the 1.2.17 jars provided by HPE Fortify are the correct version therefore the warnings should not be considered an issue. 