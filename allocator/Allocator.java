package allocator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.openqa.selenium.Platform;
import supportlibraries.*;
import com.cognizant.framework.ExcelDataAccess;
import com.cognizant.framework.FrameworkParameters;
import com.cognizant.framework.ReportSettings;
import com.cognizant.framework.ReportTheme;
import com.cognizant.framework.ReportThemeFactory;
import com.cognizant.framework.Settings;
import com.cognizant.framework.TimeStamp;
import com.cognizant.framework.Util;
import com.cognizant.framework.ReportThemeFactory.Theme;
import com.cognizant.framework.IterationOptions;

/**
 * Class to manage the batch execution of test scripts within the framework
 * 
 * @author Cognizant
 */
    public class Allocator {
	private static List<SeleniumTestParameters> testInstancesToRun;
	private static SeleniumReport report;
	private static Properties properties;
	private static FrameworkParameters frameworkParameters = FrameworkParameters
			.getInstance();
	private static Date overallStartTime, overallEndTime;
	private static ReportSettings reportSettings;
	private static String timeStamp;
	private static String reportPath;
	public static String environment;

	private Allocator() {
		// To prevent external instantiation of this class
	}

	public static void main(String[] args) throws FileNotFoundException {
		setRelativePath();
		initializeTestBatch();
		initializeSummaryReport();
		setupErrorLog();
		driveBatchExecution();
		wrapUp();
	}

	private static void setRelativePath() {
		String relativePath = new File(System.getProperty("user.dir")).getAbsolutePath();
		
		if (relativePath.contains("allocator")) {
			relativePath = new File(System.getProperty("user.dir")).getParent();
		}
		frameworkParameters.setRelativePath(relativePath);
	}

	private static void initializeTestBatch() {
		overallStartTime = Util.getCurrentTime();
		properties = Settings.getInstance();
		testInstancesToRun = getRunInfo(properties
				.getProperty("RunConfiguration"));
	}

	private static List<SeleniumTestParameters> getRunInfo(String sheetName) {
		ExcelDataAccess runManagerAccess = new ExcelDataAccess(
				frameworkParameters.getRelativePath(), "Run Manager");
		runManagerAccess.setDatasheetName(sheetName);
		int nTestInstances = runManagerAccess.getLastRowNum();
		List<SeleniumTestParameters> testInstancesToRun = new ArrayList<SeleniumTestParameters>();

		for (int currentTestInstance = 1; currentTestInstance <= nTestInstances; currentTestInstance++) {
			String executeFlag = runManagerAccess.getValue(currentTestInstance,
					"Execute");

			if (executeFlag.equalsIgnoreCase("Yes")) {
				String currentScenario = runManagerAccess.getValue(currentTestInstance, "TestScenario");
				String currentTestcase = runManagerAccess.getValue(currentTestInstance, "TestCase");
				SeleniumTestParameters testParameters = new SeleniumTestParameters(currentScenario, currentTestcase);
				testParameters.setCurrentTestDescription(runManagerAccess.getValue(currentTestInstance, "Description"));
				String iterationMode = runManagerAccess.getValue(currentTestInstance, "IterationMode");
				if (!iterationMode.equals("")) 
				{ 
					testParameters.setIterationMode(IterationOptions.valueOf(iterationMode));
				} 
				else 
				{
					testParameters.setIterationMode(IterationOptions.RunAllIterations);
				}

				String startIteration = runManagerAccess.getValue(currentTestInstance, "StartIteration");
				if (!startIteration.equals("")) {
					testParameters.setStartIteration(Integer
							.parseInt(startIteration));
				}
				String endIteration = runManagerAccess.getValue(currentTestInstance, "EndIteration");
				if (!endIteration.equals("")) {
					testParameters.setEndIteration(Integer
							.parseInt(endIteration));
				}

				String browser = runManagerAccess.getValue(currentTestInstance,"Browser");

				if (!browser.equals("")) {
					testParameters.setBrowser(Browser.valueOf(browser));

				}
				if(properties.getProperty("DefaultBrowser")!=null) {
					testParameters.setBrowser(Browser.valueOf(properties
							.getProperty("DefaultBrowser")));
				}
				/*String browserVersion = runManagerAccess.getValue(currentTestInstance, "BrowserVersion");
				if (!browserVersion.equals("")) {
					testParameters.setBrowserVersion(browserVersion);
				}
				String platform = runManagerAccess.getValue(
						currentTestInstance, "Platform");
				if (!platform.equals("")) {
					testParameters.setPlatform(Platform.valueOf(platform));
				}*/
				    if(Platform.valueOf(properties.getProperty("DefaultPlatform"))!=null){
					testParameters.setPlatform(Platform.valueOf(properties
							.getProperty("DefaultPlatform")));
					
					
					environment = runManagerAccess.getValue(currentTestInstance, "TestEnvironment");
					if(!environment.equals("")) {
					 testParameters.setTestEnvironment(TestEnvironment.valueOf(environment));						
					}
				}

				testInstancesToRun.add(testParameters);
			}
		}

		return testInstancesToRun;
	}

	private static void initializeSummaryReport() {
		frameworkParameters.setRunConfiguration(properties
				.getProperty("RunConfiguration"));
		timeStamp = TimeStamp.getInstance();

		initializeReportSettings();
		ReportTheme reportTheme = ReportThemeFactory.getReportsTheme(Theme
				.valueOf(properties.getProperty("ReportsTheme")));

		report = new SeleniumReport(reportSettings, reportTheme);

		report.initialize();
		report.initializeResultSummary();
		createResultSummaryHeader();
	}

	private static void initializeReportSettings() {
		reportPath = frameworkParameters.getRelativePath()
				+ Util.getFileSeparator() + "Results" + Util.getFileSeparator()
				+ timeStamp;
		reportSettings = new ReportSettings(reportPath, "");

		reportSettings.setDateFormatString(properties
				.getProperty("DateFormatString"));
		reportSettings.setProjectName(properties.getProperty("ProjectName"));
		reportSettings.generateExcelReports = Boolean.parseBoolean(properties
				.getProperty("ExcelReport"));
		reportSettings.generateHtmlReports = Boolean.parseBoolean(properties
				.getProperty("HtmlReport"));
		reportSettings.linkTestLogsToSummary = true;
	}

	private static void createResultSummaryHeader() {
		report.addResultSummaryHeading(reportSettings.getProjectName() + " - "
				+ " Automation Execution Result Summary");
		report.addResultSummarySubHeading(
				"Date & Time",
				": "
						+ Util.getCurrentFormattedTime(properties
								.getProperty("DateFormatString")), "OnError",
				": " + properties.getProperty("OnError"));
		report.addResultSummarySubHeading("Run Configuration", ": "
				+ properties.getProperty("RunConfiguration"), "No. of threads",
				": " + properties.getProperty("NumberOfThreads"));

		report.addResultSummaryTableHeadings();
	}

	private static void setupErrorLog() throws FileNotFoundException {
		String errorLogFile = reportPath + Util.getFileSeparator()
				+ "ErrorLog.txt";
		System.setErr(new PrintStream(new FileOutputStream(errorLogFile)));
	}

	private static void driveBatchExecution() {
		int nThreads = Integer.parseInt(properties
				.getProperty("NumberOfThreads"));
		ExecutorService parallelExecutor = Executors
				.newFixedThreadPool(nThreads);

		for (int currentTestInstance = 0; currentTestInstance < testInstancesToRun
				.size(); currentTestInstance++) {
			ParallelRunner testRunner = new ParallelRunner(
					testInstancesToRun.get(currentTestInstance), report);
			parallelExecutor.execute(testRunner);

			if (frameworkParameters.getStopExecution()) {
				break;
			}
		}

		parallelExecutor.shutdown();
		while (!parallelExecutor.isTerminated()) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void wrapUp() {
		overallEndTime = Util.getCurrentTime();
		closeSummaryReport();

		if (reportSettings.generateHtmlReports) {
			try {
				Runtime.getRuntime().exec(
						"RunDLL32.EXE shell32.dll,ShellExec_RunDLL "
								+ reportPath + "\\HTML Results\\Summary.Html");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (reportSettings.generateExcelReports) {
			try {
				Runtime.getRuntime().exec(
						"RunDLL32.EXE shell32.dll,ShellExec_RunDLL "
								+ reportPath + "\\Excel Results\\Summary.xls");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void closeSummaryReport() {
		String totalExecutionTime = Util.getTimeDifference(overallStartTime,
				overallEndTime);
		report.addResultSummaryFooter(totalExecutionTime);
	}
}