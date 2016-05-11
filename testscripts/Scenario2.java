package testscripts;

import org.testng.annotations.Test;

import com.cognizant.framework.IterationOptions;

import supportlibraries.DriverScript;
import supportlibraries.SeleniumTestParameters;


public class Scenario2
{
	/**
	 * Test for book flight tickets and verify booking
	 */
	@Test
	public void runTC4()
	{
		SeleniumTestParameters testParameters =
				new SeleniumTestParameters(this.getClass().getSimpleName(), "TC4");
		testParameters.setIterationMode(IterationOptions.RunOneIterationOnly);
		//testParameters.setBrowser(Browser.InternetExplorer);
		
		DriverScript driverScript = new DriverScript(testParameters);
		driverScript.driveTestExecution();
	}
}