package testscripts;

import org.testng.annotations.Test;

import com.cognizant.framework.IterationOptions;

import supportlibraries.Browser;
import supportlibraries.DriverScript;
import supportlibraries.SeleniumTestParameters;


public class Scenario1
{
	/**
	 * Test for login with valid user credentials
	 */
	@Test
	public void runTC1()
	{
		SeleniumTestParameters testParameters =
				new SeleniumTestParameters(this.getClass().getSimpleName(), "TC1");
		testParameters.setIterationMode(IterationOptions.RunOneIterationOnly);
		testParameters.setBrowser(Browser.HtmlUnit);
		
		DriverScript driverScript = new DriverScript(testParameters);
		driverScript.driveTestExecution();
	}
	
	/**
	 * Test for login with invalid user credentials
	 */
	@Test
	public void runTC2()
	{
		SeleniumTestParameters testParameters =
				new SeleniumTestParameters(this.getClass().getSimpleName(), "TC2");
		testParameters.setBrowser(Browser.Chrome);
		
		DriverScript driverScript = new DriverScript(testParameters);
		driverScript.driveTestExecution();
	}
	
	/**
	 * Test for register new user and login using the registered user
	 */
	@Test
	public void runTC3()
	{
		SeleniumTestParameters testParameters =
				new SeleniumTestParameters(this.getClass().getSimpleName(), "TC3");
		
		DriverScript driverScript = new DriverScript(testParameters);
		driverScript.driveTestExecution();
	}
}