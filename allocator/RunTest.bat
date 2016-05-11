@ECHO OFF

SET TESTSETNAME=%~1
SET TIMESTAMP=%~2
SET CURRENTSCENARIO=%~3
SET CURRENTTESTCASE=%~4
SET CURRENTTESTDESC=%~5
SET ITERATIONMODE=%~6
SET STARTITERATION=%~7
SET ENDITERATION=%~8
SET BROWSER=%~9
SHIFT
SHIFT
SHIFT
SHIFT
SHIFT
SHIFT
SHIFT
SHIFT
SHIFT
SET BROWSERVERSION=%~1
SET PLATFORM=%~2

@ECHO ON

D:
cd "D:\naresh\KH Automation Bckup\KHWorkspace\Kjedehuset\uimap"
java -cp ".;.\supportlibraries\Framework_Core.jar;.\supportlibraries\Framework_DataTable.jar;.\supportlibraries\Framework_Reporting.jar;.\supportlibraries\Framework_Utilities.jar;D:\naresh\KH Automation Bckup\KHWorkspace\Kjedehuset\supportlibraries\poi-3.8-20120326.jar;D:\naresh\KH Automation Bckup\workspace\Mymattel\src\selenium-server-standalone32.jar" allocator.Allocator "%TESTSETNAME%" %TIMESTAMP% "%CURRENTSCENARIO%" "%CURRENTTESTCASE%" "%CURRENTTESTDESC%" %ITERATIONMODE% %STARTITERATION% %ENDITERATION% %BROWSER% %BROWSERVERSION% %PLATFORM%