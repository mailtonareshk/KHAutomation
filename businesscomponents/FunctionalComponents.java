package businesscomponents;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;

import supportlibraries.*;
import uimap.*;
import webdriverhelper.Finder;
import webdriverhelper.WebElementVerificationUtils;
import allocator.Allocator;
import autoitx4java.AutoItX;

import com.cognizant.framework.FrameworkException;
import com.cognizant.framework.Status;
import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.jacob.com.LibraryLoader;
import com.thoughtworks.selenium.Selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;

/**
 * Functional Components class
 * 
 * @author Cognizant
 */
public class FunctionalComponents extends ReusableLibrary {
	/**
	 * Constructor to initialize the component library
	 * 
	 *            The {@link ScriptHelper} object passed from the
	 *            {@link DriverScript}
	 */
	public static int count = 0;
	//public static String barCode = "";
	String urlName = dataTable.getData("General_Data", "URLS");
	VerificationComponents components = new VerificationComponents(scriptHelper);
	WebElementVerificationUtils utils = new WebElementVerificationUtils(scriptHelper);
	HashMap<String, String> hm = components.getHashmap();
	public static HashMap<String, String> hashmap = new HashMap<String, String>();
	public static String mbizImageName;
	public static double InvoiceshippingPrice=0.0;
	public static String category = "";
	public static String mainWindow = "";
	@SuppressWarnings("deprecation")
	Selenium selenium; 
	public static String b2bUser = "";
	public static String packageName = "";
	//public static String[] productNameSplits;
	
	

	public enum URL {
		ApplicationUrl1, ApplicationUrl2, ApplicationUrl3, ApplicationUrl4, ApplicationUrl5, ApplicationUrl6, ApplicationUrl7, ApplicationUrl8, ApplicationUrl9, ApplicationUrl10, ApplicationUrl11, ApplicationUrl12, ApplicationUrl13, ApplicationUrl14,ApplicationUrl15,ApplicationUrl16,ApplicationUrl17,ApplicationUrl18,ApplicationUrl19,ApplicationUrl20,ApplicationUrl21,ApplicationUrl22,ApplicationUrl23,ApplicationUrl24,ApplicationUrl25;
	}

	public FunctionalComponents(ScriptHelper scriptHelper) {
		super(scriptHelper);

	}

	/** This Function is used to load the URL
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 */
	
	public void invokeApplication() throws InterruptedException, AWTException {
		String newApplicationUrl="";
		switch (URL.valueOf(urlName)) {

		case ApplicationUrl1:
             
			if(Allocator.environment.equals("Preprod"))
			{
    		driver.get(properties.getProperty("ApplicationUrl1"));
			/*selenium= new WebDriverBackedSelenium(driver,properties.getProperty("ApplicationUrl1"));
			selenium.open(properties.getProperty("ApplicationUrl1"));
			selenium.click("xpath=//div[@id='sortinglist']/dl[@class='dropdown']");*/
			//selenium.click("xpath=//div[@id='sortinglist']/dl[@class='dropdown']//li/a[*/text()='"+subscriptionType+"']");*/

			}
			
			else if(Allocator.environment.equals("Test"))
			{
			newApplicationUrl = properties.getProperty("ApplicationUrl1");
			newApplicationUrl=newApplicationUrl.replace("telenorpreprod","telenortest");
			driver.get(newApplicationUrl);
			}
            report.updateTestLog(
					"Invoke Application",
					"Invoke the application under test @ "
							+ properties.getProperty("ApplicationUrl1"),
					Status.DONE);
            waitForPageLoaded(driver);			
			windowMaximize();
			break;

		case ApplicationUrl2:
		     
			if(Allocator.environment.equals("Preprod"))
			{
			driver.get(properties.getProperty("ApplicationUrl2"));
			}
			
			else if(Allocator.environment.equals("Test"))
			{
			newApplicationUrl = properties.getProperty("ApplicationUrl2");
			newApplicationUrl=newApplicationUrl.replace("telenorpreprod","telenortest");
			driver.get(newApplicationUrl);
			}

			report.updateTestLog(
					"Invoke Application",
					"Invoke the application under test @ "
							+ properties.getProperty("ApplicationUrl2"),
					Status.DONE);
			waitForPageLoaded(driver);			
			windowMaximize();			
			
			break;

		case ApplicationUrl3:

			if(Allocator.environment.equals("Preprod"))
			{
			driver.get(properties.getProperty("ApplicationUrl3"));
			}
			
			else if(Allocator.environment.equals("Test"))
			{
			newApplicationUrl = properties.getProperty("ApplicationUrl3");
			newApplicationUrl=newApplicationUrl.replace("telenorpreprod","telenortest");
			driver.get(newApplicationUrl);
			}
			report.updateTestLog(
					"Invoke Application",
					"Invoke the application under test @ "
							+ properties.getProperty("ApplicationUrl3"),
					Status.DONE);
			waitForPageLoaded(driver);			
			windowMaximize();
			break;

		case ApplicationUrl4:

			if(Allocator.environment.equals("Preprod"))
			{
			driver.get(properties.getProperty("ApplicationUrl4"));
			}
			
			else if(Allocator.environment.equals("Test"))
			{
			newApplicationUrl = properties.getProperty("ApplicationUrl4");
			newApplicationUrl=newApplicationUrl.replace("telenorpreprod","telenortest");
			driver.get(newApplicationUrl);
			}
			report.updateTestLog(
					"Invoke Application",
					"Invoke the application under test @ "
							+ properties.getProperty("ApplicationUrl4"),
					Status.DONE);
			waitForPageLoaded(driver);			
			windowMaximize();
			break;

		case ApplicationUrl5:
			
			if(Allocator.environment.equals("Preprod"))
			{
			driver.get(properties.getProperty("ApplicationUrl5"));
			}
			
			else if(Allocator.environment.equals("Test"))
			{
			newApplicationUrl = properties.getProperty("ApplicationUrl5");
			newApplicationUrl=newApplicationUrl.replace("mbizadminpreprod","mbizadmintest");
			driver.get(newApplicationUrl);
			}
			report.updateTestLog(
					"Invoke Application",
					"Invoke the application under test @ "
							+ properties.getProperty("ApplicationUrl5"),
					Status.DONE);
			waitForPageLoaded(driver);			
			windowMaximize();
			break;
			
			
		  case ApplicationUrl6:

			  if(Allocator.environment.equals("Preprod"))
				{
				driver.get(properties.getProperty("ApplicationUrl6"));
				}
				
			  else if(Allocator.environment.equals("Test"))
				{
				newApplicationUrl = properties.getProperty("ApplicationUrl6");
				newApplicationUrl=newApplicationUrl.replace("simbapreprod","simbatest");
				driver.get(newApplicationUrl);
				}
			report.updateTestLog(
					"Invoke Application",
					"Invoke the application under test @ "
							+ properties.getProperty("ApplicationUrl6"),
					Status.DONE);
			waitForPageLoaded(driver);			
			windowMaximize();
			break;

		case ApplicationUrl7:
            
			if(Allocator.environment.equals("Preprod"))
			{
			driver.get(properties.getProperty("ApplicationUrl7"));
			}
			
			else if(Allocator.environment.equals("Test"))
			{
			newApplicationUrl = properties.getProperty("ApplicationUrl7");
			newApplicationUrl=newApplicationUrl.replace("statuspreprod","statustest");
			driver.get(newApplicationUrl);
			}
			report.updateTestLog(
					"Invoke Application",
					"Invoke the application under test @ "
							+ properties.getProperty("ApplicationUrl7"),
					Status.DONE);
			
			waitForPageLoaded(driver);			
			windowMaximize();
		
			break;

		case ApplicationUrl8:

			if(Allocator.environment.equals("Preprod"))
			{
			driver.get(properties.getProperty("ApplicationUrl8"));
			}
			
			else if(Allocator.environment.equals("Test"))
			{
			newApplicationUrl = properties.getProperty("ApplicationUrl8");
			newApplicationUrl=newApplicationUrl.replace("djuicepreprod","djuicetest");
			driver.get(newApplicationUrl);
			}
			report.updateTestLog(
					"Invoke Application",
					"Invoke the application under test @ "
							+ properties.getProperty("ApplicationUrl8"),
					Status.DONE);
			waitForPageLoaded(driver);			
			windowMaximize();
			break;

		case ApplicationUrl9:

			if(Allocator.environment.equals("Preprod"))
			{
			driver.get(properties.getProperty("ApplicationUrl9"));
			}
			
			else if(Allocator.environment.equals("Test"))
			{
			newApplicationUrl = properties.getProperty("ApplicationUrl9");
			newApplicationUrl=newApplicationUrl.replace("djuicepreprod","djuicetest");
			driver.get(newApplicationUrl);
			}
			report.updateTestLog(
					"Invoke Application",
					"Invoke the application under test @ "
							+ properties.getProperty("ApplicationUrl9"),
					Status.DONE);
			waitForPageLoaded(driver);			
			windowMaximize();
			break;

		case ApplicationUrl10:

			if(Allocator.environment.equals("Preprod"))
			{
			driver.get(properties.getProperty("ApplicationUrl10"));
			}
			
			else if(Allocator.environment.equals("Test"))
			{
			newApplicationUrl = properties.getProperty("ApplicationUrl10");
			newApplicationUrl=newApplicationUrl.replace("nordialogpreprod","nordialogtest");
			driver.get(newApplicationUrl);
			}
			report.updateTestLog(
					"Invoke Application",
					"Invoke the application under test @ "
							+ properties.getProperty("ApplicationUrl10"),
					Status.DONE);
			waitForPageLoaded(driver);			
			windowMaximize();
			break;

		case ApplicationUrl11:

			if(Allocator.environment.equals("Preprod"))
			{
			driver.get(properties.getProperty("ApplicationUrl11"));
			}
			
			else if(Allocator.environment.equals("Test"))
			{
			newApplicationUrl = properties.getProperty("ApplicationUrl11");
			newApplicationUrl=newApplicationUrl.replace("telenorpreprod","telenortest");
			driver.get(newApplicationUrl);
			}
			report.updateTestLog(
					"Invoke Application",
					"Invoke the application under test @ "
							+ properties.getProperty("ApplicationUrl11"),
					Status.DONE);
			waitForPageLoaded(driver);			
			windowMaximize();
			break;
			
		case ApplicationUrl12:

			driver.get(properties.getProperty("ApplicationUrl12"));
			report.updateTestLog(
					"Invoke Application",
					"Invoke the application under test @ "
							+ properties.getProperty("ApplicationUrl12"),
					Status.DONE);
			waitForPageLoaded(driver);			
			windowMaximize();
			break;	
		
		case ApplicationUrl13:
			
			if(Allocator.environment.equals("Preprod"))
			{
			driver.get(properties.getProperty("ApplicationUrl13"));
			}
			
			else if(Allocator.environment.equals("Test"))
			{
			newApplicationUrl = properties.getProperty("ApplicationUrl13");
			newApplicationUrl=newApplicationUrl.replace("mbizadminpreprod","mbizadmintest");
			driver.get(newApplicationUrl);
			}
			report.updateTestLog(
					"Invoke Application",
					"Invoke the application under test @ "
							+ properties.getProperty("ApplicationUrl13"),
					Status.DONE);
			waitForPageLoaded(driver);			
			windowMaximize();
			break;
			
		case ApplicationUrl14:

			driver.get(properties.getProperty("ApplicationUrl14"));
			report.updateTestLog(
					"Invoke Application",
					"Invoke the application under test @ "
							+ properties.getProperty("ApplicationUrl14"),
					Status.DONE);
			waitForPageLoaded(driver);			
			windowMaximize();
			break;
			
		case ApplicationUrl15:

			driver.get(properties.getProperty("ApplicationUrl15"));
			report.updateTestLog(
					"Invoke Application",
					"Invoke the application under test @ "
							+ properties.getProperty("ApplicationUrl15"),
					Status.DONE);
			waitForPageLoaded(driver);			
			windowMaximize();
			break;
		case ApplicationUrl16:

			driver.get(properties.getProperty("ApplicationUrl16"));
			report.updateTestLog(
					"Invoke Application",
					"Invoke the application under test @ "
							+ properties.getProperty("ApplicationUrl16"),
					Status.DONE);
			waitForPageLoaded(driver);			
			windowMaximize();
			break;
		case ApplicationUrl17:

			driver.get(properties.getProperty("ApplicationUrl17"));
			report.updateTestLog(
					"Invoke Application",
					"Invoke the application under test @ "
							+ properties.getProperty("ApplicationUrl17"),
					Status.DONE);
			waitForPageLoaded(driver);			
			windowMaximize();
			break;
		case ApplicationUrl18:

			driver.get(properties.getProperty("ApplicationUrl18"));
			report.updateTestLog(
					"Invoke Application",
					"Invoke the application under test @ "
							+ properties.getProperty("ApplicationUrl18"),
					Status.DONE);
			waitForPageLoaded(driver);			
			windowMaximize();
			break;
		case ApplicationUrl19:

			driver.get(properties.getProperty("ApplicationUrl19"));
			report.updateTestLog(
					"Invoke Application",
					"Invoke the application under test @ "
							+ properties.getProperty("ApplicationUrl19"),
					Status.DONE);
			waitForPageLoaded(driver);			
			windowMaximize();
			break;
		case ApplicationUrl20:

			driver.get(properties.getProperty("ApplicationUrl20"));
			report.updateTestLog(
					"Invoke Application",
					"Invoke the application under test @ "
							+ properties.getProperty("ApplicationUrl20"),
					Status.DONE);
			waitForPageLoaded(driver);			
			windowMaximize();
			break;
		case ApplicationUrl21:

			driver.get(properties.getProperty("ApplicationUrl21"));
			report.updateTestLog(
					"Invoke Application",
					"Invoke the application under test @ "
							+ properties.getProperty("ApplicationUrl21"),
					Status.DONE);
			waitForPageLoaded(driver);			
			windowMaximize();
			break;
		case ApplicationUrl22:

			driver.get(properties.getProperty("ApplicationUrl22"));
			report.updateTestLog(
					"Invoke Application",
					"Invoke the application under test @ "
							+ properties.getProperty("ApplicationUrl22"),
					Status.DONE);
			waitForPageLoaded(driver);			
			windowMaximize();
			break;
	case ApplicationUrl23:

		driver.get(properties.getProperty("ApplicationUrl23"));
		report.updateTestLog(
				"Invoke Application",
				"Invoke the application under test @ "
						+ properties.getProperty("ApplicationUrl23"),
				Status.DONE);
		waitForPageLoaded(driver);			
		windowMaximize();
		break;
		
	case ApplicationUrl24:

		driver.get(properties.getProperty("ApplicationUrl24"));
		report.updateTestLog(
				"Invoke Application",
				"Invoke the application under test @ "
						+ properties.getProperty("ApplicationUrl24"),
				Status.DONE);
		waitForPageLoaded(driver);			
		windowMaximize();
		break;
		
   case ApplicationUrl25:

	driver.get(properties.getProperty("ApplicationUrl25"));
	report.updateTestLog(
			"Invoke Application",
			"Invoke the application under test @ "
					+ properties.getProperty("ApplicationUrl25"),
			Status.DONE);
	waitForPageLoaded(driver);			
	windowMaximize();
	break;
	}
	}
	
	/**
	 * This Function is used to check status of orders in HAPI
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public void hapiOrderCheck1() throws AWTException, InterruptedException,ParserConfigurationException, SAXException, IOException {
		Finder locator = new Finder();
		waitForPageLoaded(driver);

		WebElement hapiMenu = driver.findElement(locator.findBy("buttons_btnHapiAX"));
		WebElement hapiSubMenu = driver.findElement(locator.findBy("buttons_btnHapiOrderRequests"));

		Actions builder = new Actions(driver);
		builder.moveToElement(hapiMenu).click().moveToElement(hapiSubMenu).click().build().perform();
		waitForPageLoaded(driver);

		try {
			Actions builder1 = new Actions(driver);
			builder1.moveToElement(
				driver.findElement(locator.findBy("buttons_btnHapiAX")))
				.moveToElement(
							driver.findElement(locator
									.findBy("buttons_btnHapiOrderRequests"))).build()
					.perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//utils.verifyAndClickButton("buttons_btnHapiHapi", "Happi");
	
		waitForPageLoaded(driver);
		utils.verifyAndEnterValueInTextBox("textboxes_txtHapiOrderSearchAX",hm.get("orderNumber"),"OrderNumber");
		
		//driver.findElement(locator.findBy("textboxes_txtHapiOrderSearch")).sendKeys(hm.get("orderNumber"));
		//driver.findElement(locator.findBy("buttons_btnHapiOrderSearch")).click();
		utils.verifyAndClickButton("buttons_btnHapiOrderSearchAX", "Find Orders");
		fluentwait(locator.findBy("images_imgAjaxLoadHapi"));
		waitForPageLoaded(driver);
		//Thread.sleep(2500L);
		Thread.sleep(20000L);
		boolean hapiOrderStatus = driver.findElement(locator.findBy("textboxes_txtHapiOrderStatusAX")).getText().trim().equals(dataTable.getData("General_Data", "OrderNumberStatus").trim());

		if (hapiOrderStatus)
			report.updateTestLog("Order validation - Hapi AX","Order validation is successful ", Status.PASS);
		else
			report.updateTestLog("Order validation - Hapi AX","Order validation is not successful", Status.FAIL);

	}
	
	
	public void paymentTypeCheck() throws AWTException, InterruptedException,ParserConfigurationException, SAXException, IOException {
		Finder locator = new Finder();
		waitForPageLoaded(driver);
		
		//utils.verifyAndEnterValueInTextBox("textboxes_txtHapiOrderSearchAX",hm.get("orderNumber"),"OrderNumber");
		
     	//utils.verifyAndClickButton("buttons_btnHapiOrderSearchAX", "Find Orders");
		
		//fluentwait(locator.findBy("images_imgAjaxLoadHapi"));
		//waitForPageLoaded(driver);
		
		//Thread.sleep(20000L);

        boolean ShowHapiOrderStatus = false;
		
        ShowHapiOrderStatus = driver.findElement(locator.findBy("links_lnkHapiOrderAX")).isDisplayed();
		
		if(ShowHapiOrderStatus)
			report.updateTestLog("Order in Happi "," Placed order with link is Displayed",Status.PASS);
		
		else
			report.updateTestLog("Order in Happi ","Placed order is not Displayed",Status.FAIL);
		
		
		utils.verifyAndClickLink("links_lnkHapiOrderAX", "Order Detail link");
		
		
		
		boolean paymentTypeStatus = driver.findElement(locator.findBy("textboxes_txtHapiPaymentTypeAX")).getText().trim().equals(dataTable.getData("General_Data", "PaymentType").trim());

		if (paymentTypeStatus)
			report.updateTestLog("PaymentType validation sent to Hapi AX","PaymentType validation is successful ", Status.PASS);
		else
			report.updateTestLog("PaymentType validation sent to Hapi AX","PaymentType validation is not successful", Status.FAIL);

	}
	
	
	
	public void windowMaximize() throws AWTException
  	{
  	Robot rob = new Robot();
    rob.keyPress(KeyEvent.VK_WINDOWS);
    rob.keyPress(KeyEvent.VK_UP);
    rob.keyRelease(KeyEvent.VK_WINDOWS);
    rob.keyRelease(KeyEvent.VK_UP);
  	}

	/** This function is used for login into the application
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */

	public void login() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		//Finder locator = new Finder();
		String userName = dataTable.getData("General_Data", "Username");
		String password = dataTable.getData("General_Data", "Password");
		//String splitpayment = dataTable.getData("General_Data", "Splitpayment");

		if (urlName.equals("ApplicationUrl5")||urlName.equals("ApplicationUrl13")||urlName.equals("ApplicationUrl24")){
			
			//driver.findElement(locator.findBy("login_username")).sendKeys(userName);
			utils.verifyAndEnterValueInTextBox("login_username",dataTable.getData("General_Data", "Username"),"User Name");
			//driver.findElement(locator.findBy("login_signin")).click();
			utils.verifyAndClickButton("login_signin", "Login");
			waitForPageLoaded(driver);
			//driver.findElement(locator.findBy("login_password")).sendKeys(password);
			utils.verifyAndEnterValueInTextBox("login_password",dataTable.getData("General_Data", "Password"),"Password");
			//driver.findElement(locator.findBy("login_signin")).click();
			utils.verifyAndClickButton("login_signin", "Login");
			waitForPageLoaded(driver);
		}

		if (urlName.equals("ApplicationUrl7")||urlName.equals("ApplicationUrl25")) {
			driver.findElement(SignOnPage.txtUsername2).sendKeys(userName);
			driver.findElement(SignOnPage.txtPassword2).sendKeys(password);
			driver.findElement(SignOnPage.btnLogin2).click();
			waitForPageLoaded(driver);
		}

		if (urlName.equals("ApplicationUrl10")) {
			driver.findElement(SignOnPage.txtTelephoneNumber)
					.sendKeys(userName);
			driver.findElement(SignOnPage.btnLogin3).click();
			Thread.sleep(5000);
			driver.findElement(SignOnPage.txtPassword3).sendKeys(password);
			driver.findElement(SignOnPage.btnLogin4).click();
			waitForPageLoaded(driver);
		}
		
		if (urlName.equals("ApplicationUrl14")||urlName.equals("ApplicationUrl20")) {
			driver.findElement(SignOnPage.txtUsername4).sendKeys(userName);
			driver.findElement(SignOnPage.txtPassword4).sendKeys(password);
			driver.findElement(SignOnPage.btnLogin5).click();
			waitForPageLoaded(driver);
		}
		if (urlName.equals("ApplicationUrl15")||urlName.equals("ApplicationUrl16")||urlName.equals("ApplicationUrl17")||urlName.equals("ApplicationUrl18")||urlName.equals("ApplicationUrl19")) {
			driver.findElement(SignOnPage.txtUsername5).clear();
			driver.findElement(SignOnPage.txtUsername5).sendKeys(userName);
			driver.findElement(SignOnPage.txtPassword5).clear();
			driver.findElement(SignOnPage.txtPassword5).sendKeys(password);
			driver.findElement(SignOnPage.btnLogin6).click();
			waitForPageLoaded(driver);
		}
		//if (urlName.equals("ApplicationUrl22")) {
			//driver.findElement(SignOnPage.txtUsername5).clear();
			//driver.findElement(SignOnPage.txtUsername5).sendKeys(userName);
			//driver.findElement(SignOnPage.txtPassword5).clear();
			//driver.findElement(SignOnPage.txtPassword5).sendKeys(password);
			//driver.findElement(SignOnPage.txtSplitPayment).clear();
			//driver.findElement(SignOnPage.txtSplitPayment).sendKeys(splitpayment);
			//driver.findElement(SignOnPage.btnLogin6).click();
			//waitForPageLoaded(driver);
		//}
		//report.updateTestLog("Login", "Enter login credentials: "
			//	+ "Username = " + userName + ", " + "Password = " + password,
			//	Status.DONE);
	}
	
	
	/** This function is used for login into the application
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */

	public void loginSplitpayment() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		//Finder locator = new Finder();
		String userName = dataTable.getData("General_Data", "Username");
		String password = dataTable.getData("General_Data", "Password");
		String splitpayment = dataTable.getData("General_Data", "Splitpayment");
		String email = dataTable.getData("General_Data", "Email");
		if (urlName.equals("ApplicationUrl22")||urlName.equals("ApplicationUrl23")) {
			driver.findElement(SignOnPage.txtUsername5).clear();
			driver.findElement(SignOnPage.txtUsername5).sendKeys(userName);
			driver.findElement(SignOnPage.txtPassword5).clear();
			driver.findElement(SignOnPage.txtPassword5).sendKeys(password);
			driver.findElement(SignOnPage.txtSplitPayment).clear();
			driver.findElement(SignOnPage.txtSplitPayment).sendKeys(splitpayment);
			driver.findElement(SignOnPage.txtEmail).clear();
			driver.findElement(SignOnPage.txtEmail).sendKeys(email);
			driver.findElement(SignOnPage.btnLogin6).click();
			waitForPageLoaded(driver);
		}
		report.updateTestLog("Login", "Enter login credentials: "
				+ "Username = " + userName + ", " + "Password = " + password,
				Status.DONE);
	}
	
	
	/** This function is used for login into the application
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */

	public void loginOrderApproval() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		//Finder locator = new Finder();
	
		String userName = dataTable.getData("General_Data", "Username");
		String password = dataTable.getData("General_Data", "Password");
		String userName1 = dataTable.getData("General_Data", "Username1");
		String password1 = dataTable.getData("General_Data", "Password1");
				
		if (urlName.equals("ApplicationUrl10")) {
			
			driver.findElement(SignOnPage.txtTelephoneNumber).sendKeys(userName);
	        driver.findElement(SignOnPage.btnLogin3).click();
	        Thread.sleep(5000);
	        //WebDriver driver2 = new FirefoxDriver();
	        //String url="https://statuspreprod.kjedehuset.no";
	        //((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", url);
	        //WebDriver driver2 = new FirefoxDriver();
	        //Goto guru99 site
	        
	        // Open new tab 
	        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
	        
	        //Go to URL  
	        driver.get("https://statuspreprod.kjedehuset.no");
			waitForPageLoaded(driver);
			driver.findElement(SignOnPage.txtUsername2).sendKeys(userName1);
			driver.findElement(SignOnPage.txtPassword2).sendKeys(password1);
			driver.findElement(SignOnPage.btnLogin2).click();
			waitForPageLoaded(driver);
			
			utils.verifyAndClickLink("links_lnkOtp", "OTP Page");
			//waitForPageLoaded(driver);
			utils.verifyAndEnterValueInTextBox("textboxes_txtOTPUser", dataTable.getData("General_Data", "OTPUser"), "OTPUser Name");
			utils.verifyAndClickButton("buttons_btnSearchOTPUser", "SearchOTPUser");
			waitForPageLoaded(driver);
			utils.verifyAndClickButton("buttons_btnOTPText", "OTP Password Text");
			waitForPageLoaded(driver);
			Thread.sleep(5000);
			Finder locator = new Finder();
			String otpNo = driver.findElement(locator.findBy("buttons_btnOTPText")).getText();
			hashmap.put("otpNo", otpNo );
			System.out.println(otpNo);
			
			// Close new tab
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
			
			// Switch first tab    
			driver.switchTo().defaultContent();
			driver.findElement(SignOnPage.txtPassword3).sendKeys(otpNo);
	    	driver.findElement(SignOnPage.btnLogin4).click();
	    	waitForPageLoaded(driver);
			
		}
		report.updateTestLog("Login", "Enter login credentials: "
				+ "Username = " + userName + ", " + "Password = " + hashmap.get("otpNo"),
				Status.DONE);
	}
	
	
	/** This function will click on the accessory tab available in the front end shop 	
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
		
	public void clickOnAccessoryTab() throws InterruptedException, ParserConfigurationException, SAXException, IOException{
		waitForPageLoaded(driver);
		 //driver.findElement(locator.findBy("buttons_btnAccesoryTab")).click();
		 utils.verifyAndClickButton("buttons_btnAccesoryTab", "Accesories");	 
		 waitForPageLoaded(driver);
	}	
	
	/** This function will select the product available in the front end shop  
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	

	public void productSelect() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		waitForPageLoaded(driver);
		 Finder locator =new Finder();
		
		String productName1 = "";
		String productName2 = "";
		List<WebElement> element = driver.findElements(locator.findBy("textboxes_txtSubscriptionList")); 
			int counter=1;
			for(WebElement mobileList:element)
			{
			 if(mobileList.isDisplayed())
			 { 
			  productName1 = driver.findElement(findByDynXpath(locator.findBy("images_imgMobile"),String.valueOf(counter))).getAttribute("alt");
			  driver.findElement(findByDynXpath(locator.findBy("buttons_btnSelectProduct"),String.valueOf(counter))).click();
			  waitForPageLoaded(driver);
			  productName2 = driver.findElement(locator.findBy("images_imgPDPMobile")).getAttribute("alt");	 
			  break;				 
			 }			 
			 counter++;			 
			}				

		if (productName1.equals(productName2)) {
			report.updateTestLog(
					"Select Product",
					"Click on 'Select' button available in the product grid for a Mobile Phone",
					Status.DONE);
		}
	}
	
	
	public void mobileBroadbandSelect() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		waitForPageLoaded(driver);
		 Finder locator =new Finder();
		
		String productName1 = "";
	
		List<WebElement> element = driver.findElements(locator.findBy("textboxes_txtSubscriptionList")); 
			int counter=1;
			for(WebElement mobileList:element)
			{
			 if(mobileList.isDisplayed())
			 { 
			  productName1 = driver.findElement(findByDynXpath(locator.findBy("images_imgMobile"),String.valueOf(counter))).getAttribute("alt");
			  driver.findElement(findByDynXpath(locator.findBy("buttons_btnSelectProduct"),String.valueOf(counter))).click();
			  waitForPageLoaded(driver);
		 			  break;				 
			 }			 
			 counter++;			 
			}				

		if (productName1.equals(productName1)) {
			report.updateTestLog(
					"Select Product",
					"Click on 'Select' button available in the product grid for a Mobile Phone",
					Status.DONE);
		}
	}
	
	/** This function will select the product package available in the front end shop  
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	

	public void productPackageSelect() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		waitForPageLoaded(driver);
		 Finder locator =new Finder();
		 driver.findElement(locator.findBy("links_lnkHomePage")).click();
		 waitForPageLoaded(driver);
	
		boolean ShowSavePackageStatus = false;
			
			ShowSavePackageStatus = driver.findElement(By.xpath("//div[@id='content']//div[@class='fp-productlist']//h2//a[@href='/Mobil/"+dataTable.getData("General_data","ProductPackageName")+"']")).isDisplayed();
			
			if(ShowSavePackageStatus)
				report.updateTestLog("Show Product Package in Home Page "," Product Package is Displayed in Home Page",Status.PASS);
			else
				report.updateTestLog("Show Product Package in Home Page  ","Product Package not Displayed in Home Page",Status.FAIL);
			
			//String totalPrice1 = driver.findElement(locator.findBy("textboxes_txtTotalPrice")).getText();
			try
			{
				driver.findElement(By.xpath("//div[@id='content']//div[@class='fp-productlist']//h2//a[@href='/Mobil/"+dataTable.getData("General_data","ProductPackageName")+"']")).click();
			report.updateTestLog("ProductPackageSelect", "Sucessfully selected ProductPackage", Status.DONE);
			}
			catch(Exception e)
			{
			throw new FrameworkException("ProductPackageSelect ","Error in selecting ProductPackage");
			}
	}
	
	/** This function selects subscription from the list box available in front end shop  
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	public void selectSubscription()
			throws InterruptedException, AWTException, ParserConfigurationException, SAXException, IOException{
		
		waitForPageLoaded(driver);
	    Finder locator =new Finder();
		
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,450)", "");
		
		String subscriptionType =dataTable.getData("General_Data", "SubscriptionName");
		//driver.findElement(locator.findBy("listboxes_lstSelectSubScription")).click();
			
		utils.verifyAndClickButton("listboxes_lstSelectSubScription", "SubscriptionList");
		driver.findElement(findByDynXpath(locator.findBy("listboxes_lstSelectSubScriptionType"),subscriptionType)).click();
		
		report.updateTestLog("Selecting the Product Subscription ",
				"Sucessfully selected product with "+subscriptionType+"subscription",
				Status.DONE);
		
	}

        
	/** This function will add the product to the basket   
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * 
	 */
	
	public void clickOnAddToBasket() throws ParserConfigurationException, SAXException, IOException {
		//driver.findElement(locator.findBy("buttons_btnAddToBasket")).click();
		utils.verifyAndClickButton("buttons_btnAddToBasket", "Add To Basket");
		waitForPageLoaded(driver);
		report.updateTestLog("Click on Add To Basket Button:",
				"Sucessfully clicked on Add to Basket button", Status.DONE);
		// New accessories page skip added
		
		try
		{
		//driver.findElement(locator.findBy("buttons_btnDeliveryPayment")).click();
		utils.verifyAndClickButton("buttons_btnSkip", "Skipped Accessories Addition");
		waitForPageLoaded(driver);
		report.updateTestLog("Click on Skip Button:", "Sucessfully clicked on Skip button", Status.DONE);
		}
		catch(Exception e)
		{
		throw new FrameworkException("Click Skip button ","New Accessories page not displayed for this Product");
		}
		//utils.verifyAndClickButton("buttons_btnSkip", "Skipped Accessories Addition");
		//report.updateTestLog("Click on Skip Button:","Sucessfully clicked on Skip button", Status.DONE);
		//waitForPageLoaded(driver);
		
	}
	
	public void clickOnAddToBasket1() throws ParserConfigurationException, SAXException, IOException {
		//driver.findElement(locator.findBy("buttons_btnAddToBasket")).click();
		utils.verifyAndClickButton("buttons_btnAddToBasket", "Add To Basket");
		waitForPageLoaded(driver);
		report.updateTestLog("Click on Add To Basket Button:",
				"Sucessfully clicked on Add to Basket button", Status.DONE);
		// New accessories page skip added
	
		
	}
	public void clickOnAddToBasketWithNewAccessories() throws ParserConfigurationException, SAXException, IOException {
		//driver.findElement(locator.findBy("buttons_btnAddToBasket")).click();
		utils.verifyAndClickButton("buttons_btnAddToBasket", "Add To Basket");
		waitForPageLoaded(driver);
		report.updateTestLog("Click on Add To Basket Button:",
				"Sucessfully clicked on Add to Basket button", Status.DONE);
		// New accessories page skip added
		
		try
		{
		//driver.findElement(locator.findBy("buttons_btnDeliveryPayment")).click();
		utils.verifyAndCheckCheckbox("checkboxes_chkAccessories1", "Selecting Accessories From NewAccessoriesPage ");
		utils.verifyAndCheckCheckbox("checkboxes_chkAccessories2", "Selecting Accessories From NewAccessoriesPage ");
		utils.verifyAndCheckCheckbox("checkboxes_chkAccessories3", "Selecting Accessories From NewAccessoriesPage ");
		report.updateTestLog("Click on Velg tilbehør check box", "Successfully selected Accessories From NewAccessoriesPage",
					Status.DONE);
			}
			catch(Exception e)
			{
			throw new FrameworkException("Selecting Accessories From NewAccessoriesPage","Error in selecting Accessories From NewAccessoriesPage");	
			}
		
		try
		{
		utils.verifyAndClickButton("buttons_btnAddToCart", "Accessories Added from NewAccessoriesPage");
		waitForPageLoaded(driver);
		report.updateTestLog("Click on AddToCart Button:", "Sucessfully clicked on AddToCart button", Status.DONE);
		}
		catch(Exception e)
		{
		throw new FrameworkException("Click AddToCart button ","New Accessories page not displayed for this Product");
		}
		//utils.verifyAndClickButton("buttons_btnSkip", "Skipped Accessories Addition");
		//report.updateTestLog("Click on Skip Button:","Sucessfully clicked on Skip button", Status.DONE);
		//waitForPageLoaded(driver);
		
	}
	
	public void clickOnAddToBasketForAccessories() throws ParserConfigurationException, SAXException, IOException {
		//driver.findElement(locator.findBy("buttons_btnAddToBasket")).click();
		utils.verifyAndClickButton("buttons_btnAddToBasket", "Add To Basket");
		waitForPageLoaded(driver);
		report.updateTestLog("Click on Add To Basket Button:",
				"Sucessfully clicked on Add to Basket button", Status.DONE);
		
	}
	
	/** This function will Create Product Package
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	public void createProductPackage() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		Finder locator =new Finder();
		boolean ShowSavePackageStatus = false;
		
		ShowSavePackageStatus = driver.findElement(locator.findBy("links_lnkShowSavePackage")).isDisplayed();
		
		if(ShowSavePackageStatus)
			report.updateTestLog("Show Product Package "," Show Product Package link is Displayed",Status.PASS);
		else
			report.updateTestLog("Show Product Package ","Show Product Package link is not Displayed",Status.FAIL);
		
		//String totalPrice1 = driver.findElement(locator.findBy("textboxes_txtTotalPrice")).getText();
		utils.verifyAndClickLink("links_lnkShowSavePackage", "ShowSavePackage");
		//waitForPageLoaded(driver);
		utils.verifyAndEnterValueInTextBox("textboxes_txtProductPackageName", dataTable.getData("General_Data", "ProductPackageName"), "ProductPackageName");
		utils.verifyAndEnterValueInTextBox("textboxes_txtProductPackageUsp", dataTable.getData("General_Data", "ProductPackageUsp"), "ProductPackageUsp");
		utils.verifyAndEnterValueInTextBox("textboxes_txtProductPackageDescription", dataTable.getData("General_Data", "ProductPackageDescription"), "ProductPackageDescription");
		//driver.findElement(locator.findBy("links_lnkRefresh")).click();
		utils.verifyAndClickButton("buttons_btnSaveAsPackage", "SaveAsPackage");
		//waitForPageLoaded(driver);
		
				
		try{
			boolean ErrMsg = driver.findElement(locator.findBy("textboxes_txtPakageError")).getText().equals(dataTable.getData("General_Data", "ErrorMsg"));
			if(ErrMsg)
				report.updateTestLog("Create Product Pakage", "Successfully Added New Product Pakage",Status.PASS);else
					report.updateTestLog("Create  Product Pakage", "Product Pakage Creation is Unsuccessfull",Status.FAIL);
			
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	/** This function will Edit Product Package and  25% discounted Price
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	public void editProductPackage() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		Finder locator =new Finder();
		double actualPrice1 = 0.0;
		double actualPrice2 = 0.0;
		double actualPrice3 = 0.0;
		double actualPrice4 = 0.0;
		float discountedPrice1;
		float discountedPrice2;
		float discountedPrice3;
		float discountedPrice4;
		boolean SavedPackageStatus = false;
				driver.findElement(locator.findBy("links_lnkProductPackage")).click();
	  	waitForPageLoaded(driver);
	  	
		try
		{
			
			SavedPackageStatus = driver.findElement(By.xpath("//div[@id='content']//table//tbody//tr//td//a[contains(text(),'"+dataTable.getData("General_data","ProductPackageName")+"')]")).isDisplayed();
			
			if(SavedPackageStatus)
			
				report.updateTestLog("Show Product Package "," Created Product Package Displayed in Product Package Page",Status.PASS);else
				report.updateTestLog("Show Product Package ","Created Product Package is not Displayed in Product Package Page",Status.FAIL);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		try
		{
			driver.findElement(By.xpath("//div[@id='content']//table//tbody//tr//td//a[contains(text(),'"+dataTable.getData("General_data","ProductPackageName")+"')]")).click();
			waitForPageLoaded(driver);
			
			utils.verifyAndEnterValueInTextBox("textboxes_txtEditProductPackageName", dataTable.getData("General_Data", "EditProductPackageName"), "EditProductPackageName");
			utils.verifyAndEnterValueInTextBox("textboxes_txtEditProductPackageUsp", dataTable.getData("General_Data", "ProductPackageUsp"), "ProductPackageUsp");
			utils.verifyAndEnterValueInTextBox("textboxes_txtEditProductPackageDescription", dataTable.getData("General_Data", "ProductPackageDescription"), "ProductPackageDescription");
			utils.verifyAndClickButton("buttons_btnSaveEditPackage", "SaveEditedPackage");
			
			report.updateTestLog("Edit Product Package", "Successfully Edited the Product Package",Status.PASS);
	   		
		}
		catch(Exception e)
		{
		throw new FrameworkException("Edit Product Package","Error in Editing the Product Package");	
		}
	
	
		try
		{
			waitForPageLoaded(driver);
			actualPrice1 = Double.parseDouble(driver.findElement(locator.findBy("textboxes_txtOriginalPrice1")).getText().replaceAll(",", ".").replaceAll("-", ""));
			actualPrice2 = Double.parseDouble(driver.findElement(locator.findBy("textboxes_txtOriginalPrice2")).getText().replaceAll(",", ".").replaceAll("-", ""));
			actualPrice3 = Double.parseDouble(driver.findElement(locator.findBy("textboxes_txtOriginalPrice3")).getText().replaceAll(",", ".").replaceAll("-", ""));
			actualPrice4 = Double.parseDouble(driver.findElement(locator.findBy("textboxes_txtOriginalPrice4")).getText().replaceAll(",", ".").replaceAll("-", ""));
			System.out.println(actualPrice1);
			//String actualPrice1 =  driver.findElement(locator.findBy("textboxes_txtOriginalPrice1")).getText().replaceAll(",", ".").replaceAll("-", "");
			//double d = Double.parseDouble (actualPrice1) ;
			discountedPrice1 = (float) (actualPrice1*75/100);
			discountedPrice2 = (float) (actualPrice2*75/100);
			discountedPrice3 = (float) (actualPrice3*75/100);
			discountedPrice4 = (float) (actualPrice4*75/100);
			System.out.println(discountedPrice1);
			String discprice1 = Double.toString(discountedPrice1);
			String discprice2 = Double.toString(discountedPrice2);
			String discprice3 = Double.toString(discountedPrice3);
			String discprice4 = Double.toString(discountedPrice4);
			System.out.println(discprice1);
			 //utils.verifyAndEnterValueInTextBox("textboxes_txtAgentName",agentname,"AgentName");
			driver.findElement(locator.findBy("textboxes_txtDiscountedPrice1")).clear();
			driver.findElement(locator.findBy("textboxes_txtDiscountedPrice1")).sendKeys(discprice1);
			//driver.findElement(By.xpath("//div[@id='content']//table//tbody//tr//td//a[contains(text(),'"+dataTable.getData("General_data","ProductPackageName")+"')]")).click();
			utils.verifyAndClickButton("buttons_btnUpdateDiscountedPrice1", "UpdateDiscountedPriceProduct1");
			waitForPageLoaded(driver);
			driver.findElement(locator.findBy("textboxes_txtDiscountedPrice2")).clear();
			driver.findElement(locator.findBy("textboxes_txtDiscountedPrice2")).sendKeys(discprice2);
			//driver.findElement(By.xpath("//div[@id='content']//table//tbody//tr//td//a[contains(text(),'"+dataTable.getData("General_data","ProductPackageName")+"')]")).click();
			utils.verifyAndClickButton("buttons_btnUpdateDiscountedPrice2", "UpdateDiscountedPriceProduct2");
			waitForPageLoaded(driver);
			driver.findElement(locator.findBy("textboxes_txtDiscountedPrice3")).clear();
			driver.findElement(locator.findBy("textboxes_txtDiscountedPrice3")).sendKeys(discprice3);
			//driver.findElement(By.xpath("//div[@id='content']//table//tbody//tr//td//a[contains(text(),'"+dataTable.getData("General_data","ProductPackageName")+"')]")).click();
			utils.verifyAndClickButton("buttons_btnUpdateDiscountedPrice3", "UpdateDiscountedPriceProduct3");
			waitForPageLoaded(driver);
			driver.findElement(locator.findBy("textboxes_txtDiscountedPrice4")).clear();
			driver.findElement(locator.findBy("textboxes_txtDiscountedPrice4")).sendKeys(discprice4);
			utils.verifyAndClickButton("buttons_btnUpdateDiscountedPrice1", "UpdateDiscountedPriceProduct4");
			//utils.verifyAndCheckCheckbox("textboxes_txtCheckShowOnFrontpage", "ShowOnFrontpage");
			//driver.findElement(By.xpath("//div[@id='content']//table//tbody//tr//td//a[contains(text(),'"+dataTable.getData("General_data","ProductPackageName")+"')]")).click();
							
			//utils.verifyAndClickButton("buttons_btnSaveEditPackage", "SaveEditedPackage");
			
		    report.updateTestLog("Edit Product Package Price", "Successfully Edited the Product Package with 25% Discounted Price ",Status.PASS);
		   		
			}
			catch(Exception e)
			{
			throw new FrameworkException("Edit Product Package Price","Error in Editing the Product Package Price");	
			}
		
	}
	
	
	/** This function will Edit Product Count to a MAX 1000
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	public void editProductCount() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		Finder locator =new Finder();
		
		try
		{
						
			 //utils.verifyAndEnterValueInTextBox("textboxes_txtAgentName",agentname,"AgentName");
			driver.findElement(locator.findBy("textboxes_txtUpdateQuantity1")).clear();
			utils.verifyAndEnterValueInTextBox("textboxes_txtUpdateQuantity1", dataTable.getData("General_Data", "Quantity1"), "Quantity1");
			//driver.findElement(locator.findBy("textboxes_txtUpdateQuantity1")).sendKeys(dataTable.getData("General_Data", "Quantity1"));
			//driver.findElement(By.xpath("//div[@id='content']//table//tbody//tr//td//a[contains(text(),'"+dataTable.getData("General_data","ProductPackageName")+"')]")).click();
			utils.verifyAndClickButton("buttons_btnUpdateQuantity1", "UpdateQuantityForProduct1");
			
			waitForPageLoaded(driver);
			driver.findElement(locator.findBy("textboxes_txtUpdateQuantity2")).clear();
			utils.verifyAndEnterValueInTextBox("textboxes_txtUpdateQuantity2", dataTable.getData("General_Data", "Quantity2"), "Quantity2");
			//driver.findElement(locator.findBy("textboxes_txtUpdateQuantity2")).sendKeys(dataTable.getData("General_Data", "Quantity2"));
			//driver.findElement(By.xpath("//div[@id='content']//table//tbody//tr//td//a[contains(text(),'"+dataTable.getData("General_data","ProductPackageName")+"')]")).click();
			utils.verifyAndClickButton("buttons_btnUpdateQuantity2", "UpdateQuantityForProduct2");
			
			waitForPageLoaded(driver);
			driver.findElement(locator.findBy("textboxes_txtUpdateQuantity3")).clear();
			utils.verifyAndEnterValueInTextBox("textboxes_txtUpdateQuantity3", dataTable.getData("General_Data", "Quantity3"), "Quantity3");
			//driver.findElement(locator.findBy("textboxes_txtUpdateQuantity3")).sendKeys(dataTable.getData("General_Data", "Quantity3"));
			//driver.findElement(By.xpath("//div[@id='content']//table//tbody//tr//td//a[contains(text(),'"+dataTable.getData("General_data","ProductPackageName")+"')]")).click();
			utils.verifyAndClickButton("buttons_btnUpdateQuantity3", "UpdateQuantityForProduct3");
			
			waitForPageLoaded(driver);
			
			driver.findElement(locator.findBy("textboxes_txtUpdateQuantity4")).clear();
			utils.verifyAndEnterValueInTextBox("textboxes_txtUpdateQuantity4", dataTable.getData("General_Data", "Quantity4"), "Quantity4");
			//driver.findElement(locator.findBy("textboxes_txtUpdateQuantity4")).sendKeys(dataTable.getData("General_Data", "Quantity4"));
			//driver.findElement(By.xpath("//div[@id='content']//table//tbody//tr//td//a[contains(text(),'"+dataTable.getData("General_data","ProductPackageName")+"')]")).click();
			utils.verifyAndClickButton("buttons_btnUpdateQuantity4", "UpdateQuantityForProduct4");
		    
			
			report.updateTestLog("Editing the Product Count", "Successfully Edited the Product Count to 1000 ",Status.PASS);
			
			
		   		
			}
			catch(Exception e)
			{
			throw new FrameworkException("Editing the Product Count","Error in Editing the Product Count");	
			}
		
	}
	
	/** This function will Enable the Product Package to show in Front end
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	public void enableProductPackage() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		Finder locator =new Finder();
	
		boolean SavedPackageStatus = false;
				driver.findElement(locator.findBy("links_lnkProductPackage")).click();
	  	waitForPageLoaded(driver);
	  	
		try
		{
			
			SavedPackageStatus = driver.findElement(By.xpath("//div[@id='content']//table//tbody//tr//td//a[contains(text(),'"+dataTable.getData("General_data","ProductPackageName")+"')]")).isDisplayed();
			
			if(SavedPackageStatus)
			
				report.updateTestLog("Show Product Package "," Created Product Package Displayed in Product Package Page",Status.PASS);else
				report.updateTestLog("Show Product Package ","Created Product Package is not Displayed in Product Package Page",Status.FAIL);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		try
		{
			//driver.findElement(By.xpath("//div[@id='content']//table//tbody//tr//td//a[contains(text(),'"+dataTable.getData("General_data","ProductPackageName")+"')]")).click();
			waitForPageLoaded(driver);
			utils.verifyAndCheckCheckbox("checkboxes_chkShowOnFrontpage", "ShowOnFrontpage");
			waitForPageLoaded(driver);
			utils.verifyAndClickButton("buttons_btnSaveEnabledProductPackage", "SaveEnabledProductPackage");
			
			report.updateTestLog("Enable Product Package", "Successfully Enabled the Product Package to show in Front end",Status.PASS);
	   		
		}
		catch(Exception e)
		{
		throw new FrameworkException("Enable Product Package","Error in Enabling the Product Package to show in Front end");	
		}
	}
	
	/** This function will Enable the Product Package to show in Front end
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	public void deleteProductPackage() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		Finder locator =new Finder();
	
		boolean SavedPackageStatus = false;
				driver.findElement(locator.findBy("links_lnkProductPackage")).click();
	  	waitForPageLoaded(driver);
	  	
		try
		{
			
			SavedPackageStatus = driver.findElement(By.xpath("//div[@id='content']//table//tbody//tr//td//a[contains(text(),'"+dataTable.getData("General_data","ProductPackageName")+"')]")).isDisplayed();
			
			if(SavedPackageStatus)
			
				report.updateTestLog("Show Product Package "," Created Product Package Displayed in Product Package Page",Status.PASS);else
				report.updateTestLog("Show Product Package ","Created Product Package is not Displayed in Product Package Page",Status.FAIL);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		try
		{
			//driver.findElement(By.xpath("//div[@id='content']//table//tbody//tr//td//a[contains(text(),'"+dataTable.getData("General_data","ProductPackageName")+"')]")).click();
			waitForPageLoaded(driver);
			utils.verifyAndCheckCheckbox("checkboxes_chkdeletepakage", "Deletepakage");
			waitForPageLoaded(driver);
			utils.verifyAndClickButton("buttons_btnSaveEnabledProductPackage", "SaveDeletedProductPackage");
			
			report.updateTestLog("Delete Product Package", "Successfully Deleted the Product Package ",Status.PASS);
	   		
		}
		catch(Exception e)
		{
		throw new FrameworkException("Delete Product Package","Error in Deleting the Product Package ");	
		}
	}
	
	/** This function will update the cart with specified quantity
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	public void updateMyCartDetails() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		Finder locator =new Finder();
		String totalPrice1 = driver.findElement(locator.findBy("textboxes_txtTotalPrice")).getText();
		driver.findElement(locator.findBy("textboxes_txtQuantity")).clear();
		//driver.findElement(locator.findBy("textboxes_txtQuantity")).sendKeys(dataTable.getData("General_Data", "Quantity"));
		utils.verifyAndEnterValueInTextBox("textboxes_txtQuantity", dataTable.getData("General_Data", "Quantity"), "Quantity");
		//driver.findElement(locator.findBy("links_lnkRefresh")).click();
		utils.verifyAndClickLink("links_lnkRefresh", "Refresh");
		waitForPageLoaded(driver);
		String totalPrice2 = driver.findElement(locator.findBy("textboxes_txtTotalPrice")).getText();
		if (!totalPrice1.equals(totalPrice2)) {
			report.updateTestLog("Update Mycart Details:",
					"Sucessfully updated the price", Status.DONE);
		}
		driver.findElement(locator.findBy("textboxes_txtQuantity")).clear();
		//driver.findElement(locator.findBy("textboxes_txtQuantity")).sendKeys(dataTable.getData("General_Data","Quantity2"));
		utils.verifyAndEnterValueInTextBox("textboxes_txtQuantity", dataTable.getData("General_Data", "Quantity2"), "Quantity");
		//driver.findElement(locator.findBy("links_lnkRefresh")).click();
		utils.verifyAndClickLink("links_lnkRefresh", "Refresh");
		waitForPageLoaded(driver);

		
	}

	/** This function will click on the check out button available in the front end shop
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * 	
	 */
	
	public void clickOnCheckOut() throws ParserConfigurationException, SAXException, IOException {
		//driver.findElement(locator.findBy("buttons_btnCheckOut")).click();
		utils.verifyAndClickButton("buttons_btnCheckOut", "CheckOut");
		waitForPageLoaded(driver);
		report.updateTestLog("Click on Checkout Button:",
				"Sucessfully clicked on Checkout button", Status.DONE);
		
		
	}

	/** This function will provide the billing informations for products without subscription to the billing details page of the front end shop
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	public void billingInformationWithoutSubscription()
			throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		waitForPageLoaded(driver);
		/*driver.findElement(locator.findBy("textboxes_txtFirstName")).sendKeys(dataTable.getData("BillingInformations_Data","FirstName"));
		driver.findElement(locator.findBy("textboxes_txtLastName")).sendKeys(dataTable.getData("BillingInformations_Data","LastName"));
		driver.findElement(locator.findBy("textboxes_txtEmail")).sendKeys(dataTable.getData("BillingInformations_Data", "Email"));
		driver.findElement(locator.findBy("textboxes_txtAddress")).sendKeys(dataTable.getData("BillingInformations_Data", "Address"));
		driver.findElement(locator.findBy("textboxes_txtPostalCode")).sendKeys(dataTable.getData("BillingInformations_Data","PostalCode"));
		driver.findElement(locator.findBy("textboxes_txtPostalPlace")).sendKeys(dataTable.getData("BillingInformations_Data", "City"));
		driver.findElement(locator.findBy("buttons_btnDeliveryPayment")).click();*/		
		utils.verifyAndEnterValueInTextBox("textboxes_txtFirstName",dataTable.getData("BillingInformations_Data","FirstName"),"FirstName");
		utils.verifyAndEnterValueInTextBox("textboxes_txtLastName",dataTable.getData("BillingInformations_Data","LastName"),"LastName");
		utils.verifyAndEnterValueInTextBox("textboxes_txtEmail",dataTable.getData("BillingInformations_Data","Email"),"Email");
		utils.verifyAndEnterValueInTextBox("textboxes_txtAddress",dataTable.getData("BillingInformations_Data","Address"),"Address");
		utils.verifyAndEnterValueInTextBox("textboxes_txtPostalCode",dataTable.getData("BillingInformations_Data","PostalCode"),"Postal Code");
		utils.verifyAndEnterValueInTextBox("textboxes_txtPostalPlace",dataTable.getData("BillingInformations_Data","City"),"City");
		utils.verifyAndClickButton("buttons_btnDeliveryPayment","Delivery Payment");		
		waitForPageLoaded(driver);
		
		report.updateTestLog(
				"Your Information Page",
				"Provide necessary information and click For Delivery and Payment",
				Status.DONE);
	}


	/** This function will provide the billing informations for products with subscription to the billing details page of the front end shop
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	public void billingInformationWithSubscription()
			throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		waitForPageLoaded(driver);
		Finder locator =new Finder();
		driver.findElement(locator.findBy("textboxes_txtFirstName")).clear();
		driver.findElement(locator.findBy("textboxes_txtLastName")).clear();
		driver.findElement(locator.findBy("textboxes_txtEmail")).clear();
		/*driver.findElement(locator.findBy("textboxes_txtidentityNumber")).clear();
		driver.findElement(locator.findBy("textboxes_txtFirstName")).sendKeys(dataTable.getData("BillingInformations_Data","FirstName"));
		driver.findElement(locator.findBy("textboxes_txtLastName")).sendKeys(dataTable.getData("BillingInformations_Data","LastName"));
		driver.findElement(locator.findBy("textboxes_txtEmail")).sendKeys(dataTable.getData("BillingInformations_Data", "Email"));
		driver.findElement(locator.findBy("textboxes_txtidentityNumber")).sendKeys(dataTable.getData("BillingInformations_Data","IdentityNumber"));*/
		
		utils.verifyAndEnterValueInTextBox("textboxes_txtFirstName",dataTable.getData("BillingInformations_Data","FirstName"),"FirstName");
		utils.verifyAndEnterValueInTextBox("textboxes_txtLastName",dataTable.getData("BillingInformations_Data","LastName"),"LastName");
		utils.verifyAndEnterValueInTextBox("textboxes_txtEmail",dataTable.getData("BillingInformations_Data","Email"),"Email");
		utils.verifyAndEnterValueInTextBox("textboxes_txtidentityNumber",dataTable.getData("BillingInformations_Data","IdentityNumber"),"Identity Nummber");		
		
		if(urlName.equals("ApplicationUrl6"))
		{
			driver.findElement(locator.findBy("textboxes_txtSimbaConsentPhone")).clear();
			//driver.findElement(locator.findBy("textboxes_txtSimbaConsentPhone")).sendKeys(dataTable.getData("BillingInformations_Data", "ConsentPhoneNumber"));
			utils.verifyAndEnterValueInTextBox("textboxes_txtSimbaConsentPhone",dataTable.getData("BillingInformations_Data", "ConsentPhoneNumber"),"Consent Phone Number");
		}

		if (!(dataTable.getData("BillingInformations_Data", "PhoneNumber1").isEmpty())) {
					
			List<WebElement> element =driver.findElements(locator.findBy("checkboxes_chkKeepSameNumber"));
			int counter=1;
			for(WebElement numberSelect:element)
			{
		    numberSelect.click();
			driver.findElement(findByDynXpath(locator.findBy("textboxes_txtPhoneNumber"),String.valueOf(counter))).sendKeys(dataTable.getData("BillingInformations_Data","PhoneNumber"+counter));
			counter++;
			
			}
		}
		 else {
			List<WebElement> element =driver.findElements(locator.findBy("checkboxes_chkNewNumber"));
						
			for(WebElement numberSelect:element)
			{
		    numberSelect.click();
			Thread.sleep(20000L);
			}
		}
		/*driver.findElement(locator.findBy("buttons_btnDeliveryPayment")).click();
		driver.findElement(locator.findBy("links_lnkFake")).click();
		Thread.sleep(5000);*/
		utils.verifyAndClickButton("buttons_btnDeliveryPayment","Delivery Payment");
		waitForPageLoaded(driver);
		report.updateTestLog(
				"Your Information Page",
				"Provide necessary information and click For Delivery and Payment",
				Status.DONE);
	}

   /** This function will select the mode of payment as invoice from the shipping details page of the front end shop 
 * @throws IOException 
 * @throws SAXException 
 * @throws ParserConfigurationException 
    * 	
    */
	
	public void selectPaymentMethodInvoice() throws ParserConfigurationException, SAXException, IOException {
	
		try
		{
		waitForPageLoaded(driver);
		//driver.findElement(locator.findBy("checkboxes_chkInvoice")).click();
		utils.verifyAndCheckCheckbox("checkboxes_chkInvoice", "Invoice");
		report.updateTestLog("Click on Invoice Radio Button", "Successfully selected invoice radio button",
				Status.DONE);
		}
		catch(Exception e)
		{
		throw new FrameworkException("Click on Invoice Radio Button","Error in selecting invoice radio button");	
		}
	}
	
	/** This function will click on the confirm booking button available in the front end shop
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * 
	 */
	
	public void clickOnConformBooking() throws ParserConfigurationException, SAXException, IOException {
		
		Finder locator = new Finder();
		if(urlName.equals("ApplicationUrl22")||urlName.equals("ApplicationUrl23"))
		{
			driver.findElement(locator.findBy("textboxes_txtFakturareferanse")).clear();
			//driver.findElement(locator.findBy("textboxes_txtSimbaConsentPhone")).sendKeys(dataTable.getData("BillingInformations_Data", "ConsentPhoneNumber"));
			utils.verifyAndEnterValueInTextBox("textboxes_txtFakturareferanse",dataTable.getData("General_Data", "FakturaReferanse"),"FakturaReferanse");
		}
		
		
		try
		{
		//driver.findElement(locator.findBy("buttons_btnDeliveryPayment")).click();
		utils.verifyAndClickButton("buttons_btnDeliveryPayment", "Delivery Payment");
		waitForPageLoaded(driver);
		report.updateTestLog("Confirm Booking", "Click On Confirm Booking",
				Status.DONE);
		}
		catch(Exception e)
		{
		throw new FrameworkException("Click confirm booking button ","Unable to click on confirm booking button");
		}
	}

	/** This function will click on finish order button to complete the order in front end shop
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	public void clickOnFinishOrder() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		
		Finder locator = new Finder();
		//driver.findElement(locator.findBy("checkboxes_chkTermsConditions")).click();
		
		utils.verifyAndCheckCheckbox("checkboxes_chkTermsConditions","Terms Conditions");
		waitForPageLoaded(driver);
		//driver.findElement(locator.findBy("buttons_btnDeliveryPayment")).click();
		utils.verifyAndClickButton("buttons_btnDeliveryPayment", "Delivery Payment");
		waitForPageLoaded(driver);
		report.updateTestLog("Finish Order", "Click On Finish Order Button",
				Status.DONE);
		try{
			boolean ErrMsg = driver.findElement(locator.findBy("textboxes_txtTelenorkontantPurchaseError")).getText().equals(dataTable.getData("General_Data", "ErrorMsg"));
			if(ErrMsg)
				report.updateTestLog("Telenor Kontant Order Limit Check","Test is successful and error message is shown as expected",Status.PASS);else
					report.updateTestLog("Telenor Kontant Order Limit Check","Test is unsuccessful and error message is not shown as expected",Status.FAIL);
			
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		}
	
	
   public void clickOnFinishOrderApproval() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		
		Finder locator = new Finder();
		waitForPageLoaded(driver);
		//driver.findElement(locator.findBy("checkboxes_chkTermsConditions")).click();
		utils.verifyAndClickButton("buttons_btnOrderApprover", "B2BApproverList");
		utils.verifyAndClickButton("links_lnkOrderApprover","B2BApproverList");
		utils.verifyAndCheckCheckbox("checkboxes_chkTermsConditions","Terms Conditions");
		waitForPageLoaded(driver);
		//driver.findElement(locator.findBy("buttons_btnDeliveryPayment")).click();
		utils.verifyAndClickButton("buttons_btnDeliveryPayment", "Delivery Payment");
		waitForPageLoaded(driver);
		report.updateTestLog("Finish Order", "Click On Finish Order Button",
				Status.DONE);
		try{
			boolean ErrMsg = driver.findElement(locator.findBy("textboxes_txtTelenorkontantPurchaseError")).getText().equals(dataTable.getData("General_Data", "ErrorMsg"));
			if(ErrMsg)
				report.updateTestLog("Telenor Kontant Order Limit Check","Test is successful and error message is shown as expected",Status.PASS);else
					report.updateTestLog("Telenor Kontant Order Limit Check","Test is unsuccessful and error message is not shown as expected",Status.FAIL);
			
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		}
	
	/** This function will select the approver from the dropdown
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public void selectApprover() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		
		try
		{
			//driver.findElement(locator.findBy("textboxes_txtB2BApproverSelect")).click();
			utils.verifyAndClickButton("textboxes_txtB2BApproverSelect","ApproverSelect");
			Thread.sleep(2000L);
			//driver.findElement(locator.findBy("buttons_btnB2bApproverSelect")).click();
			utils.verifyAndClickLink("buttons_btnB2bApproverSelect","B2BApproverList");
			Thread.sleep(2000L);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	/** This function will select new delivery address from the dropdown
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public void selectDeliveryAddress() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		
		//driver.findElement(locator.findBy("textboxes_txtB2BDeliveryAddressSelect")).click();
		utils.verifyAndClickButton("textboxes_txtB2BDeliveryAddressSelect","DeliveryAddressSelect");
		Thread.sleep(2000L);
		//driver.findElement(locator.findBy("buttons_btnB2bDeliveryAddressSelect")).click();
		utils.verifyAndClickButton("buttons_btnB2bDeliveryAddressSelect","DeleveryAddress");
		Thread.sleep(2000L);
		/*driver.findElement(locator.findBy("textboxes_txtB2BDeliveryAddresskontakt")).sendKeys(dataTable.getData("General_Data", "Levertilkontakt"));
		driver.findElement(locator.findBy("textboxes_txtB2BDeliveryAddressSelskap")).sendKeys(dataTable.getData("General_Data", "Selskap"));
		driver.findElement(locator.findBy("textboxes_txtB2BDeliveryAddressAdresse")).sendKeys(dataTable.getData("General_Data", "Adresse"));
		driver.findElement(locator.findBy("textboxes_txtB2BDeliveryAddressAdresse2")).sendKeys(dataTable.getData("General_Data", "Adresse2"));
		driver.findElement(locator.findBy("textboxes_txtB2BDeliveryAddressPostnummer")).sendKeys(dataTable.getData("General_Data", "Postnummer"));
		driver.findElement(locator.findBy("textboxes_txtB2BDeliveryAddressPoststed")).sendKeys(dataTable.getData("General_Data", "Poststed"));*/
		
		utils.verifyAndEnterValueInTextBox("textboxes_txtB2BDeliveryAddresskontakt",dataTable.getData("General_Data", "Levertilkontakt"),"Levertilkontakt");
		utils.verifyAndEnterValueInTextBox("textboxes_txtB2BDeliveryAddressSelskap",dataTable.getData("General_Data", "Selskap"),"Selskap");
		utils.verifyAndEnterValueInTextBox("textboxes_txtB2BDeliveryAddressAdresse",dataTable.getData("General_Data", "Adresse"),"Address");
		utils.verifyAndEnterValueInTextBox("textboxes_txtB2BDeliveryAddressAdresse2",dataTable.getData("General_Data", "Adresse2"),"Second Address");
		utils.verifyAndEnterValueInTextBox("textboxes_txtB2BDeliveryAddressPostnummer",dataTable.getData("General_Data", "Postnummer"),"PostNumber");
		utils.verifyAndEnterValueInTextBox("textboxes_txtB2BDeliveryAddressPoststed",dataTable.getData("General_Data", "Poststed"),"Poststed");	
	 }

	/** This function will provide the payment details to the payment page available in front end shop
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	public void paymentDetails() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		waitForPageLoaded(driver);
		Finder locator =new Finder();
		Select select1 = new Select(driver.findElement(By.id("ctl00_BodyContentPlaceHolder_PaymentControl_ddCardType")));
		select1.selectByIndex(1);
		Thread.sleep(2000L);
		//driver.findElement(locator.findBy("textboxes_txtCardHolderName")).sendKeys(dataTable.getData("CreditCardDetials_Data","CardHolderName"));
		utils.verifyAndEnterValueInTextBox("textboxes_txtCardHolderName",dataTable.getData("CreditCardDetials_Data", "CardHolderName"),"CardHolderName");	
		Thread.sleep(2000L);
		driver.findElement(locator.findBy("textboxes_txtCreditCardNumber")).clear();
		//driver.findElement(locator.findBy("textboxes_txtCreditCardNumber")).sendKeys(dataTable.getData("CreditCardDetials_Data","CreditCardNO"));
		utils.verifyAndEnterValueInTextBox("textboxes_txtCreditCardNumber",dataTable.getData("CreditCardDetials_Data", "CreditCardNO"),"CreditCardNO");
		Select select2 = new Select(driver.findElement(locator.findBy("comboboxes_cmbExpiryMonth")));
		select2.selectByIndex(4);
		Select select3 = new Select(driver.findElement(locator.findBy("comboboxes_cmbExpiryYear")));
		select3.selectByIndex(1);
		//driver.findElement(locator.findBy("textboxes_txtCVCCode")).sendKeys(dataTable.getData("CreditCardDetials_Data", "CVCCode"));
		utils.verifyAndEnterValueInTextBox("textboxes_txtCVCCode",dataTable.getData("CreditCardDetials_Data", "CVCCode"),"CVCCode");
		//driver.findElement(locator.findBy("buttons_btnCompletePayment")).click();
		utils.verifyAndClickButton("buttons_btnCompletePayment","Complete Payment");
		waitForPageLoaded(driver);
			
		//driver.findElement(locator.findBy("buttons_btnContinue")).click();
		utils.verifyAndClickButton("buttons_btnContinue","Continue");
		waitForPageLoaded(driver);
		report.updateTestLog("Input Payment Details","Input Payment Details and Click on Complete Payment",Status.DONE);
	}

	/** This function will provide the payment details to the payment page available in front end shop
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	public void paymentDetailsFailed() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		waitForPageLoaded(driver);
		Finder locator =new Finder();
		Select select1 = new Select(driver.findElement(By.id("ctl00_BodyContentPlaceHolder_PaymentControl_ddCardType")));
		select1.selectByIndex(1);
		Thread.sleep(2000L);
		String orderNo = driver.findElement(By.id("paymentreference")).getText();
		String[] splits = orderNo.split(":");
	    hashmap.put("orderNumber", splits[1].trim());
		//driver.findElement(locator.findBy("textboxes_txtCardHolderName")).sendKeys(dataTable.getData("CreditCardDetials_Data","CardHolderName"));
		utils.verifyAndEnterValueInTextBox("textboxes_txtCardHolderName",dataTable.getData("CreditCardDetials_Data", "CardHolderName"),"CardHolderName");	
		Thread.sleep(2000L);
		driver.findElement(locator.findBy("textboxes_txtCreditCardNumber")).clear();
		//driver.findElement(locator.findBy("textboxes_txtCreditCardNumber")).sendKeys(dataTable.getData("CreditCardDetials_Data","CreditCardNO"));
		utils.verifyAndEnterValueInTextBox("textboxes_txtCreditCardNumber",dataTable.getData("CreditCardDetials_Data", "CreditCardNO"),"CreditCardNO");
		Select select2 = new Select(driver.findElement(locator.findBy("comboboxes_cmbExpiryMonth")));
		select2.selectByIndex(4);
		Select select3 = new Select(driver.findElement(locator.findBy("comboboxes_cmbExpiryYear")));
		select3.selectByIndex(1);
		//driver.findElement(locator.findBy("textboxes_txtCVCCode")).sendKeys(dataTable.getData("CreditCardDetials_Data", "CVCCode"));
		utils.verifyAndEnterValueInTextBox("textboxes_txtCVCCode",dataTable.getData("CreditCardDetials_Data", "CVCCode"),"CVCCode");
		//driver.findElement(locator.findBy("buttons_btnCompletePayment")).click();
		utils.verifyAndClickButton("buttons_btnCompletePayment","Complete Payment");
		waitForPageLoaded(driver);
		Select select4 = new Select(driver.findElement(By.id("ddStatus")));
		select4.selectByIndex(1);
		String index = "";
		index = dataTable.getData("General_Data", "Index");
		int a = Integer.parseInt(index);
		Select select5 = new Select(driver.findElement(By.id("ddErrorCode")));
		select5.selectByIndex(a);
		
		//if(dataTable.getData("General_Data", "Index4")!=null) {
			//   select5.selectByIndex(4);
		    //  }
		//driver.findElement(locator.findBy("buttons_btnContinue")).click();
		utils.verifyAndClickButton("buttons_btnContinue","Continue");
		waitForPageLoaded(driver);
		report.updateTestLog("Input Payment Details","Input Payment Details and Failed Transaction is Created"+ splits[1] +" Order number in Payex ",Status.DONE);
	}

	/** This function will provide the payment details to the payment page available in front end shop
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	public void paymentDetailsDeclined() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		waitForPageLoaded(driver);
		Finder locator =new Finder();
		Select select1 = new Select(driver.findElement(By.id("ctl00_BodyContentPlaceHolder_PaymentControl_ddCardType")));
		select1.selectByIndex(1);
		Thread.sleep(2000L);
		String orderNo = driver.findElement(By.id("paymentreference")).getText();
		String[] splits = orderNo.split(":");
	    hashmap.put("orderNumber", splits[1].trim());
		//driver.findElement(locator.findBy("textboxes_txtCardHolderName")).sendKeys(dataTable.getData("CreditCardDetials_Data","CardHolderName"));
		utils.verifyAndEnterValueInTextBox("textboxes_txtCardHolderName",dataTable.getData("CreditCardDetials_Data", "CardHolderName"),"CardHolderName");	
		Thread.sleep(2000L);
		driver.findElement(locator.findBy("textboxes_txtCreditCardNumber")).clear();
		//driver.findElement(locator.findBy("textboxes_txtCreditCardNumber")).sendKeys(dataTable.getData("CreditCardDetials_Data","CreditCardNO"));
		utils.verifyAndEnterValueInTextBox("textboxes_txtCreditCardNumber",dataTable.getData("CreditCardDetials_Data", "CreditCardNO"),"CreditCardNO");
		Select select2 = new Select(driver.findElement(locator.findBy("comboboxes_cmbExpiryMonth")));
		select2.selectByIndex(4);
		Select select3 = new Select(driver.findElement(locator.findBy("comboboxes_cmbExpiryYear")));
		select3.selectByIndex(1);
		//driver.findElement(locator.findBy("textboxes_txtCVCCode")).sendKeys(dataTable.getData("CreditCardDetials_Data", "CVCCode"));
		utils.verifyAndEnterValueInTextBox("textboxes_txtCVCCode",dataTable.getData("CreditCardDetials_Data", "CVCCode"),"CVCCode");
		//driver.findElement(locator.findBy("buttons_btnCompletePayment")).click();
		utils.verifyAndClickButton("buttons_btnCompletePayment","Complete Payment");
		waitForPageLoaded(driver);
		Select select4 = new Select(driver.findElement(By.id("ddStatus")));
		select4.selectByIndex(2);
		
		//driver.findElement(locator.findBy("buttons_btnContinue")).click();
		utils.verifyAndClickButton("buttons_btnContinue","Continue");
		waitForPageLoaded(driver);
		report.updateTestLog("Input Payment Details","Input Payment Details and Declined Transaction is Created for "+ splits[1] +" Order number in Payex ",Status.DONE);
	}

   /** This function will search the particular order number in WebAdmin 
    * 	
    * @throws InterruptedException
 * @throws IOException 
 * @throws SAXException 
 * @throws ParserConfigurationException 
    */
	
	public void searchOrderNumber() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		Thread.sleep(5000);
		//driver.findElement(locator.findBy("links_lnkOrderSearch")).click();
		utils.verifyAndClickLink("links_lnkOrderSearch", "Search Orders");		
		Thread.sleep(5000);
		//driver.findElement(locator.findBy("textboxes_txtOrderNumberId")).sendKeys(hm.get("orderNumber"));
		utils.verifyAndEnterValueInTextBox("textboxes_txtOrderNumberId",hm.get("orderNumber"),"OrderNumber");
		//driver.findElement(locator.findBy("buttons_btnSearch")).click();
		utils.verifyAndClickButton("buttons_btnSearch","Search");
	}

	/** This function will process the order in Ihelp   
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
		
	public void processOrder() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		Thread.sleep(5000L);
		Finder locator =new Finder();
		//driver.findElement(locator.findBy("links_lnkCheckOrderStatus")).click();
		utils.verifyAndClickLink("links_lnkCheckOrderStatus","OrderStatus");
		
		Thread.sleep(5000L);
		String orderStatus = "";
		boolean fakestatus = false;

		for (int var = 0; var <= 6; var++) {
			orderStatus = driver.findElement(locator.findBy("textboxes_txtIHelpOrderStatus")).getText();
			int status = Integer.parseInt(orderStatus);
			
			if((urlName.equals("ApplicationUrl1") || urlName.equals("ApplicationUrl3") || urlName.equals("ApplicationUrl4") || urlName.equals("ApplicationUrl9")) && (!dataTable.getData("General_Data","SubscriptionName").equals("Uten Abonnement")||!dataTable.getData("General_Data","SubscriptionName").isEmpty()))
			{
				if(status== 4)
				{
					utils.verifyAndClickLink("links_lnkBack","Back");
				    Thread.sleep(5000L);
				    utils.verifyAndEnterValueInTextBox("textboxes_txtInvoiceNo",hm.get("orderNumber"), "OrderNumber");
				    utils.verifyAndEnterValueInTextBox("textboxes_txtIMEINo", dataTable.getData("General_Data", "IMEINumber"), "IMEINumber");
				}				
			}
			
			if (status != 6) {
				//driver.findElement(locator.findBy("links_lnkBack")).click();
				utils.verifyAndClickLink("links_lnkBack","Back");
				waitForPageLoaded(driver);
				try {fakestatus = driver.findElement(locator.findBy("textboxes_txtFakeOrder")).isDisplayed();

					if (fakestatus) 
						{
						Thread.sleep(10000L);	
						//driver.findElement(locator.findBy("textboxes_txtFakeOrder")).click();
						utils.verifyAndClickLink("textboxes_txtFakeOrder", "FakeOrder");
						Thread.sleep(5000L);
						}
				} catch (Exception e) {

				}
				//driver.findElement(locator.findBy("textboxes_txtProcessOrder")).click();
				utils.verifyAndClickLink("textboxes_txtProcessOrder","ProcessOrder");
				waitForPageLoaded(driver);
				//driver.findElement(locator.findBy("links_lnkCheckOrderStatus")).click();
				utils.verifyAndClickLink("links_lnkCheckOrderStatus", "OrderStatus");
				waitForPageLoaded(driver);
				orderStatus = driver.findElement(locator.findBy("textboxes_txtIHelpOrderStatus")).getText();
				int PreOrderstatus = Integer.parseInt(orderStatus);
				
				if(PreOrderstatus==5)
					{
					//driver.findElement(locator.findBy("links_lnkBack")).click();
					 utils.verifyAndClickLink("links_lnkBack","Back");
						waitForPageLoaded(driver);
						//driver.findElement(locator.findBy("links_lnkCheckOrderData")).click();
						utils.verifyAndClickLink("links_lnkCheckOrderData","OrderData");
						waitForPageLoaded(driver);
						boolean txtPreSaleOrderStatus = driver.findElement(locator.findBy("textboxes_txtPreSaleOrderStatus")).isDisplayed();
						if(txtPreSaleOrderStatus)
							report.updateTestLog("PreSales Order processing", "Order not processed and error message through as expected", Status.PASS); else
						    report.updateTestLog("PreSales Order processing", "Order processed and System not working as expected", Status.FAIL);
						break;
					}
				}
			if(urlName.equals("ApplicationUrl6"))
			{
				if (status == 1) 
				{
				//driver.findElement(locator.findBy("links_lnkBack")).click();
				utils.verifyAndClickLink("links_lnkBack","Back");
			    waitForPageLoaded(driver);
			    //driver.findElement(locator.findBy("textboxes_txtProcessOrder")).click();
			    utils.verifyAndClickLink("textboxes_txtProcessOrder","ProcessOrder");
			    waitForPageLoaded(driver);
			    
			    String simbaNoConsentMsgActual = driver.findElement(locator.findBy("textboxes_txtSimbaNoConsentMsg")).getText().trim();
			    String simbaNoConsentMsgExpected = dataTable.getData("General_Data","Error Msg 1")+ hm.get("orderNumber") +dataTable.getData("General_Data","Error Msg 2") ;
			    simbaNoConsentMsgActual.replaceAll(" ", "");
			    simbaNoConsentMsgExpected.trim().replaceAll(" ", "");
			    
			    if (simbaNoConsentMsgActual.equals(simbaNoConsentMsgExpected))
			    	report.updateTestLog("SIMBA order with NO Consent", "Order not processed and error message through as expected", Status.PASS); else
			    	report.updateTestLog("SIMBA order with NO Consent", "Order processed and System not working as expected", Status.FAIL);
			    
				}
			}
		}
		
		if((urlName.equals("ApplicationUrl1") || urlName.equals("ApplicationUrl3") || urlName.equals("ApplicationUrl4")) && (!dataTable.getData("General_Data","SubscriptionName").equals("Uten Abonnement")||!dataTable.getData("General_Data","SubscriptionName").isEmpty()))
		{
			//driver.findElement(locator.findBy("links_lnkCheckIMEStatus")).click();
			utils.verifyAndClickLink("links_lnkCheckIMEStatus","IME Status");
    		waitForPageLoaded(driver);
			boolean imeRegistered = driver.findElement(locator.findBy("links_lnkIMEStatus")).getText().equalsIgnoreCase("ok");
			
			if(imeRegistered)
				report.updateTestLog("'IMEI Registration Verifiaction","IMEI Successfully Registered",
						Status.PASS);
			else
				report.updateTestLog("'IMEI Registration Verifiaction","IMEI is not registered successfully",
						Status.FAIL);
				
		}
			
	}
	
	/** This function will process the order in Ihelp until Status = 4
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	public void processOrderStatusFour() throws InterruptedException, ParserConfigurationException, SAXException, IOException 
	{
		Thread.sleep(5000L);
		utils.verifyAndClickLink("textboxes_txtProcessOrder","ProcessOrder");
		waitForPageLoaded(driver);
		
	}
	/** This function will makes the order to appear in WebAdmin
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	public void clickOrderToAppearInWebAdmin() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		waitForPageLoaded(driver);
		//driver.findElement(locator.findBy("links_lnkOrderSearch")).click();
		utils.verifyAndClickLink("links_lnkOrderSearch", "Order Search");
		waitForPageLoaded(driver);
		//driver.findElement(locator.findBy("textboxes_txtIHelpOrderToAppear")).click();
		utils.verifyAndClickLink("textboxes_txtIHelpOrderToAppear", "OrderShow");
		waitForPageLoaded(driver);
	}
	
	/** This function will makes the Dashboard verification in WebAdmin
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	public void dashboardInWebAdmin() throws InterruptedException, AWTException, ParserConfigurationException, SAXException, IOException {
		
		waitForPageLoaded(driver);
		Finder locator =new Finder();
		driver.manage().window().maximize();
		fluentwait(locator.findBy("images_imgAjaxLoad"));
    	String exceldashboardinformation =dataTable.getData("General_Data", "NewdashboardInformation");
		Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String timestampString = formatter.format(now);
        String dashboardinformation=exceldashboardinformation+timestampString; 
        
			 
	    try
	    {
	    driver.findElement(locator.findBy("links_lnkMbizMenu")).click();
	    waitForPageLoaded(driver);
	    }
	    catch(Exception e)
	    {
	   	e.printStackTrace();
	    }
	    driver.findElement(locator.findBy("textboxes_txtDashboardInformation")).clear();
	    utils.verifyAndEnterValueInTextBox("textboxes_txtDashboardInformation",dashboardinformation,"DashboardInformation");
	    utils.verifyAndClickButton("textboxes_txtDashboardSave", "Save");
		waitForPageLoaded(driver);
		String createddashboard = driver.findElement(locator.findBy("textboxes_txtDashboardInformation")).getText();
		if(createddashboard.trim().equals(createddashboard.trim()))
		report.updateTestLog("mBiz Dashboard Information","Successfully Updated mBiz Dashboard", Status.PASS); 
		else
		report.updateTestLog("mBiz Dashboard Information","Not able to Update mBiz Dashboard", Status.FAIL);
	
	
		
	}

	
	/** This function will create the agent in WebAdmin
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	public void createAgent() throws InterruptedException, AWTException, ParserConfigurationException, SAXException, IOException {
		
		waitForPageLoaded(driver);
		Finder locator =new Finder();
		driver.manage().window().maximize();
		fluentwait(locator.findBy("images_imgAjaxLoad"));
    	String excelagentname =dataTable.getData("General_Data", "NewAgentName");
		Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String timestampString = formatter.format(now);
        String agentname=excelagentname+timestampString; 
        
		Actions builder1 = new Actions(driver);
        builder1.moveToElement(driver.findElement(locator.findBy("links_lnkAgentMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkCreateAgent"))).click().perform();
	    waitForPageLoaded(driver);
	 
	    try
	    {
	    Actions builder2 = new Actions(driver);
        builder2.moveToElement(driver.findElement(locator.findBy("links_lnkAgentMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkCreateAgent"))).click().perform();
	    waitForPageLoaded(driver);
	    }
	    catch(Exception e)
	    {
	   	e.printStackTrace();
	    }
	    //driver.findElement(locator.findBy("textboxes_txtAgentName")).sendKeys(agentname);
	    utils.verifyAndEnterValueInTextBox("textboxes_txtAgentName",agentname,"AgentName");
	    //driver.findElement(locator.findBy("textboxes_txtAgentSave")).click();
	    utils.verifyAndClickButton("textboxes_txtAgentSave", "Save");
		waitForPageLoaded(driver);
		
		String createdAgent = driver.findElement(locator.findBy("textboxes_txtCreatedAgent")).getText();
		
		if(agentname.trim().equals(createdAgent.trim()))
		report.updateTestLog("Create Agent","Successfully created agent in mBiz", Status.PASS); 
		else
		report.updateTestLog("Create Agent","Not able to create agent in mBiz", Status.FAIL);
	
		EditAgentDetails(agentname);
		
	}

	/** This function will edit the Agent details in WebAdmin
	 * 
	 * @param agentTitle
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
		
	public void EditAgentDetails(String agentTitle) throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		
		Finder locator =new Finder();
		Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String timestampString = formatter.format(now);
		String excelNewAgentname =dataTable.getData("General_Data", "EditAgentName");
		String deliveryCost =dataTable.getData("General_data","DeliveryCost");
		String newAgentName =excelNewAgentname+timestampString; 
		//driver.findElement(locator.findBy("textboxes_txtEditAgent")).click();
		utils.verifyAndClickButton("textboxes_txtEditAgent", "EditAgent");
		waitForPageLoaded(driver);
		driver.findElement(locator.findBy("textboxes_txtAgentName")).clear();
		//driver.findElement(locator.findBy("textboxes_txtAgentName")).sendKeys(newAgentName);
		utils.verifyAndEnterValueInTextBox("textboxes_txtAgentName", newAgentName, "AgentName");
		//driver.findElement(locator.findBy("textboxes_txtAgentSave")).click();
		utils.verifyAndClickButton("textboxes_txtAgentSave", "Save");
		waitForPageLoaded(driver);
		//driver.findElement(locator.findBy("textboxes_txtEditRange")).click();
		utils.verifyAndClickButton("textboxes_txtEditRange", "EditRange");
		waitForPageLoaded(driver);
				
		for(int var=0;var<=1;var++)
		{
		//driver.findElement(locator.findBy("buttons_btnProceed")).click();
		utils.verifyAndClickButton("buttons_btnProceed", "Proceed");	
		waitForPageLoaded(driver);
		}
		fluentwait(locator.findBy("images_imgUtvalgIconLoader"));
		Select select1 = new Select(driver.findElement(By.id("SearchParameters_ClassProductType_Value")));
	    select1.selectByVisibleText("Batteries/Chargers");
		Thread.sleep(2000L);
		Select select2 = new Select(driver.findElement(By.id("SearchParameters_Producer_Value")));
		select2.selectByVisibleText("BOSE");
		Thread.sleep(5000L);
		//driver.findElement(locator.findBy("textboxes_txtSearch")).click();
		utils.verifyAndClickButton("textboxes_txtSearch","Search");
		fluentwait(locator.findBy("images_imgUtvalgIconLoader"));
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,250)", "");
		
		WebElement sourceElelment  = driver.findElement(locator.findBy("textboxes_txtSourceElement"));
		WebElement targetElement=driver.findElement(locator.findBy("textboxes_txtTargetElement"));
		dragandDropFiles(sourceElelment,targetElement);
		jsx.executeScript("window.scrollBy(0,150)", "");
		//driver.findElement(locator.findBy("buttons_btnProceed")).click();
		utils.verifyAndClickButton("buttons_btnProceed","Proceed");
		waitForPageLoaded(driver);
		//driver.findElement(locator.findBy("textboxes_txtAgentSave")).click();
		utils.verifyAndClickButton("textboxes_txtAgentSave","Save");
        waitForPageLoaded(driver);
        //driver.findElement(locator.findBy("buttons_btnLeveringMeToOrder")).click();
        utils.verifyAndClickButton("buttons_btnLeveringMeToOrder","LeveringMeToOrder");
    	waitForPageLoaded(driver);
		//driver.findElement(locator.findBy("checkboxes_chkServicePack")).click(); 
    	utils.verifyAndCheckCheckbox("checkboxes_chkServicePack","Service Pack");
		Thread.sleep(3000);
		//driver.findElement(locator.findBy("textboxes_txtDeliveryPrice")).sendKeys(deliveryCost);
		utils.verifyAndEnterValueInTextBox("textboxes_txtDeliveryPrice", deliveryCost, "Delivery Price");
		//driver.findElement(locator.findBy("buttons_btnSaveChanges")).click();
		utils.verifyAndClickButton("buttons_btnSaveChanges","Save");
		waitForPageLoaded(driver);
		//driver.findElement(locator.findBy("textboxes_txtEditAgentSubscription")).click();
		utils.verifyAndClickButton("textboxes_txtEditAgentSubscription","EditAgentSubscription");
		waitForPageLoaded(driver);
		WebElement sourceElelmentAbbonment  = driver.findElement(locator.findBy("textboxes_txtSourceElement7"));
		WebElement TargetElelmentAbbonment = driver.findElement(locator.findBy("textboxes_txtTargetElement7"));
		dragandDropFiles(sourceElelmentAbbonment,TargetElelmentAbbonment);
		jsx.executeScript("window.scrollBy(0,150)", "");
		//driver.findElement(locator.findBy("buttons_btnProceed")).click();
		utils.verifyAndClickButton("buttons_btnProceed","Proceed");
		waitForPageLoaded(driver);
		//driver.findElement(locator.findBy("buttons_btnSaveChanges")).click();
		utils.verifyAndClickButton("buttons_btnSaveChanges","Save");
		waitForPageLoaded(driver);
		//driver.findElement(locator.findBy("textboxes_txtEditAgent")).click();
		utils.verifyAndClickButton("textboxes_txtEditAgent","EditAgent");
		waitForPageLoaded(driver);
		boolean agentName = driver.findElement(locator.findBy("textboxes_txtAgentName")).getAttribute("value").equals(newAgentName);
		//driver.findElement(locator.findBy("textboxes_txtAgentSave")).click();
		utils.verifyAndClickButton("textboxes_txtAgentSave","Save");
		waitForPageLoaded(driver);
		//driver.findElement(locator.findBy("textboxes_txtEditRange")).click();
		utils.verifyAndClickButton("textboxes_txtEditRange","EditRange");
		waitForPageLoaded(driver);
		for(int var=0;var<=1;var++)
		{
		//driver.findElement(locator.findBy("buttons_btnProceed")).click();
		utils.verifyAndClickButton("buttons_btnProceed","Proceed");	
		waitForPageLoaded(driver);
		}
       	fluentwait(locator.findBy("images_imgUtvalgIconLoader"));
		boolean rangeStatus = driver.findElement(locator.findBy("images_imgTargetImageDisplay")).isDisplayed();
		//driver.findElement(locator.findBy("buttons_btnProceed")).click();
		utils.verifyAndClickButton("buttons_btnProceed","Proceed");
		waitForPageLoaded(driver);
		//driver.findElement(locator.findBy("textboxes_txtAgentSave")).click();
		utils.verifyAndClickButton("textboxes_txtAgentSave","Save");
        waitForPageLoaded(driver);
        //driver.findElement(locator.findBy("buttons_btnLeveringMeToOrder")).click();
        utils.verifyAndClickButton("buttons_btnLeveringMeToOrder","LeveringMeToOrder");
		waitForPageLoaded(driver);
		boolean servicePackSelected = driver.findElement(locator.findBy("checkboxes_chkServicePack")).isSelected(); 
	    Thread.sleep(3000);
		String deliveryPrice =driver.findElement(locator.findBy("textboxes_txtDeliveryPrice")).getAttribute("value");
	    String[] splits =	deliveryPrice.split(",");		
		boolean deliveryPriceStatus =splits[0].equals(deliveryCost);
		//driver.findElement(locator.findBy("buttons_btnSaveChanges")).click(); 
		utils.verifyAndClickButton("buttons_btnSaveChanges","Save");
		waitForPageLoaded(driver);
		//driver.findElement(locator.findBy("textboxes_txtEditAgentSubscription")).click();
		utils.verifyAndClickButton("textboxes_txtEditAgentSubscription","Edit Subscription");
		waitForPageLoaded(driver);
		Boolean subscriptionStatus = driver.findElement(locator.findBy("textboxes_txtTargetElement7")).isDisplayed();
		
		if(agentName && servicePackSelected && deliveryPriceStatus && rangeStatus && subscriptionStatus)
		report.updateTestLog("Agent Details Updation","Successfully edited Agent Name, Sortiment, Delivery Methods & agent Subscription in mBiz", Status.PASS);	else
		report.updateTestLog("Agent Details Updation","Not able to  edit Agent Name, Sortiment Delivery Methods & agent Subscription in mBiz", Status.FAIL);	
		
	}
		
	/** This function will create the Pricing in WebAdmin 
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */

	public void createPricing() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		 
		 Finder locator =new Finder();
         fluentwait(locator.findBy("images_imgAjaxLoad"));
         //fluentwait(locator.findBy("images_imgFailedAjaxLoad"));
         Date now = new Date();
         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
         String timestampString = formatter.format(now);
         String excelname1 =dataTable.getData("General_Data", "Name1");
         String excelname2 =dataTable.getData("General_Data", "Name2");
         String name = excelname1+timestampString;
         String newName= excelname2+timestampString;      
     
         Actions builder1 = new Actions(driver);
         builder1.moveToElement(driver.findElement(locator.findBy("links_lnkPricingMenu"))).moveToElement(driver.findElement(TelenorMobileWithoutSubscription.lnkPricingSubMenu)).click().perform();
	     waitForPageLoaded(driver);
	  	    
	     try
	     {
	     Actions builder2 = new Actions(driver);
         builder2.moveToElement(driver.findElement(locator.findBy("links_lnkPricingMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkPricingSubMenu"))).click().perform();
	     waitForPageLoaded(driver);
	     }
	     catch(Exception e)
	     {
	     e.printStackTrace();
	     }
         Select select1 = new Select(driver.findElement(By.id("agentId")));
		 select1.selectByVisibleText("Telenor");
		 Thread.sleep(5000L);
		 Select select2 = new Select(driver.findElement(By.id("distributorId")));
		 select2.selectByVisibleText("Telenor Norge AS");
		 Thread.sleep(5000L);
		 Select select3 = new Select(driver.findElement(By.id("salesPointId")));
		 select3.selectByVisibleText("djuice");
		 //driver.findElement(locator.findBy("textboxes_txtName3")).sendKeys(name);
		 utils.verifyAndEnterValueInTextBox("textboxes_txtName3",name, "Name");
         Select select4 = new Select(driver.findElement(By.id("PriceCalculationType")));
		 select4.selectByVisibleText("Kostpris");
		 Thread.sleep(5000L);
		 //driver.findElement(locator.findBy("textboxes_txtPercentage")).sendKeys(dataTable.getData("General_Data", "Value1"));
		 utils.verifyAndEnterValueInTextBox("textboxes_txtPercentage", dataTable.getData("General_Data", "Value1"), "Percentage");
		 Select select5 = new Select(driver.findElement(By.id("RoundTypeId")));
		 select5.selectByVisibleText("Ingen avrunding");
		 JavascriptExecutor jsx = (JavascriptExecutor)driver;
		 jsx.executeScript("window.scrollBy(0,450)", "");
		 Thread.sleep(4000L);
		 //driver.findElement(locator.findBy("textboxes_txtAgentSave")).click();
		 utils.verifyAndClickButton("textboxes_txtAgentSave", "Save");
		 waitForPageLoaded(driver);
		 //driver.findElement(locator.findBy("links_lnkPricing")).click();
		 utils.verifyAndClickLink("links_lnkPricing","Pricing");
         waitForPageLoaded(driver);
         //driver.findElement(locator.findBy("textboxes_txtButtik")).sendKeys(name);
         utils.verifyAndEnterValueInTextBox("textboxes_txtButtik",name,"Butikk");
         //driver.findElement(locator.findBy("buttons_btnSearch2")).click();
         utils.verifyAndClickButton("buttons_btnSearch2", "Search");
         waitForPageLoaded(driver);
         boolean title =  driver.findElement(locator.findBy("textboxes_txtProductText")).getText().equals(name);
         //driver.findElement(locator.findBy("textboxes_txtEditLastProduct")).click();
         utils.verifyAndClickButton("textboxes_txtEditLastProduct", "Edit Product");
         waitForPageLoaded(driver);
         driver.findElement(locator.findBy("textboxes_txtName3")).clear();
         //driver.findElement(locator.findBy("textboxes_txtName3")).sendKeys(newName);
         utils.verifyAndEnterValueInTextBox("textboxes_txtName3",newName,"Name");
		 Select select6 = new Select(driver.findElement(By.id("PriceCalculationType")));
		 select6.selectByVisibleText("Kostpris");
		 Thread.sleep(5000L);
		
		 driver.findElement(locator.findBy("textboxes_txtPercentage")).clear();
		 //driver.findElement(locator.findBy("textboxes_txtPercentage")).sendKeys(dataTable.getData("General_Data", "Value2"));
		 utils.verifyAndEnterValueInTextBox("textboxes_txtPercentage",dataTable.getData("General_Data", "Value2"),"Percentage");
		 Select select7 = new Select(driver.findElement(By.id("RoundTypeId")));
		 select7.selectByVisibleText("Ingen avrunding");
		 //driver.findElement(locator.findBy("textboxes_txtAgentSave")).click();
		 utils.verifyAndClickButton("textboxes_txtAgentSave", "Save");
		 waitForPageLoaded(driver);
		 //driver.findElement(locator.findBy("links_lnkPricing")).click();
		 utils.verifyAndClickLink("links_lnkPricing","Pricing");
         waitForPageLoaded(driver);
         //driver.findElement(locator.findBy("textboxes_txtButtik")).sendKeys(newName);
         utils.verifyAndEnterValueInTextBox("textboxes_txtButtik",newName,"Butikk");
         //driver.findElement(locator.findBy("buttons_btnSearch2")).click();
         utils.verifyAndClickButton("buttons_btnSearch2", "Search");
         waitForPageLoaded(driver);
         //driver.findElement(locator.findBy("textboxes_txtEditLastProduct")).click();
         utils.verifyAndClickButton("textboxes_txtEditLastProduct", "Edit Product");
         waitForPageLoaded(driver);
     
         String percentage = driver.findElement(locator.findBy("textboxes_txtPercentage")).getAttribute("value");
         String[] split =percentage.split(",");
         boolean nameStatus =driver.findElement(locator.findBy("textboxes_txtName3")).getAttribute("value").equals(newName);
         boolean percentageStatus =split[0].equals(dataTable.getData("General_Data", "Value2"));

        if(title) 	
         report.updateTestLog("Create New Pricing","New Pricing is successfully created in mBiz ", Status.PASS);
        
        else
        report.updateTestLog("Create New Pricing","New Pricing is not created in mBiz ", Status.FAIL);

        if(nameStatus && percentageStatus )
         report.updateTestLog("Pricing Updation","Price updation is done successfully in mBiz", Status.PASS);

         else
         report.updateTestLog("Pricing Updation","Price updation is not done in mBiz", Status.FAIL);
	}
	
	/** This function will search for the product based on the input given in WebAdmin  
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */

	public void clickOnProductAndSearch() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		Thread.sleep(10000L);
		//driver.findElement(locator.findBy("links_lnkProduct")).click();
		utils.verifyAndClickLink("links_lnkProduct","Product");
		Thread.sleep(5000);
		//driver.findElement(locator.findBy("textboxes_txtProductSearch")).sendKeys(dataTable.getData("General_Data", "SearchInput"));
		utils.verifyAndEnterValueInTextBox("textboxes_txtProductSearch",dataTable.getData("General_Data", "SearchInput"),"Search");
		//driver.findElement(locator.findBy("textboxes_txtSearch")).click();
		utils.verifyAndClickButton("textboxes_txtSearch", "Search");
		Thread.sleep(10000L);
		}
	
	/** This function selects the store from the Nordialog site    
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */

	public void selectStoreDropdown() throws InterruptedException, AWTException, ParserConfigurationException, SAXException, IOException {
		waitForPageLoaded(driver);
		Thread.sleep(3000L);
		//driver.findElement(locator.findBy("textboxes_txtStoreSelect")).click();
		utils.verifyAndClickButton("textboxes_txtStoreSelect", "Select Store");
		Thread.sleep(3000);
		//driver.findElement(locator.findBy("links_lnkLogicaStore")).click();
		utils.verifyAndClickLink("links_lnkLogicaStore","Sunnhordland Kraftlag AS (original)");
		Thread.sleep(5000);
		waitForPageLoaded(driver);
		try{
			/*driver.findElement(locator.findBy("links_lnkNettbutikk")).click();
			utils.verifyAndClickLink("links_lnkNettbutikk","Butikk");
			waitForPageLoaded(driver);*/
			utils.verifyAndClickLink("links_lnkMobileTab","Mobile Tab");
			waitForPageLoaded(driver);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void selectStore() throws InterruptedException, AWTException, ParserConfigurationException, SAXException, IOException {
		waitForPageLoaded(driver);
		Thread.sleep(3000L);
		//driver.findElement(locator.findBy("textboxes_txtStoreSelect")).click();
		utils.verifyAndClickButton("textboxes_txtStoreSelect", "Select Store");
		Thread.sleep(3000);
		//driver.findElement(locator.findBy("links_lnkLogicaStore")).click();
		utils.verifyAndClickLink("links_lnkStore","13-Gruppen AS");
		Thread.sleep(5000);
		waitForPageLoaded(driver);
		try{
			/*driver.findElement(locator.findBy("links_lnkNettbutikk")).click();
			utils.verifyAndClickLink("links_lnkNettbutikk","Butikk");
			waitForPageLoaded(driver);*/
			utils.verifyAndClickLink("links_lnkMobileTab","Mobile Tab");
			waitForPageLoaded(driver);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void selectStoreOrderapproval() throws InterruptedException, AWTException, ParserConfigurationException, SAXException, IOException {
		waitForPageLoaded(driver);
		Thread.sleep(3000L);
		//driver.findElement(locator.findBy("textboxes_txtStoreSelect")).click();
		//utils.verifyAndClickButton("textboxes_txtStoreSelect", "Select Store");
		Thread.sleep(3000);
		//driver.findElement(locator.findBy("links_lnkLogicaStore")).click();
		//utils.verifyAndClickLink("links_lnkLogicaStore","Sunnhordland Kraftlag AS (original)");
		Thread.sleep(5000);
		waitForPageLoaded(driver);
		try{
			/*driver.findElement(locator.findBy("links_lnkNettbutikk")).click();
			utils.verifyAndClickLink("links_lnkNettbutikk","Butikk");
			waitForPageLoaded(driver);*/
			utils.verifyAndClickLink("links_lnkMobileTab","Mobile Tab");
			waitForPageLoaded(driver);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void selectStoreSplitpayment() throws InterruptedException, AWTException, ParserConfigurationException, SAXException, IOException {
		waitForPageLoaded(driver);
		Thread.sleep(3000L);
		//driver.findElement(locator.findBy("textboxes_txtStoreSelect")).click();
		utils.verifyAndClickButton("textboxes_txtStoreSelect", "Select Store");
		Thread.sleep(3000);
		//driver.findElement(locator.findBy("links_lnkLogicaStore")).click();
		utils.verifyAndClickLink("links_lnkSelectStoreSplitpayment","Anticimex A/S");
		Thread.sleep(5000);
		waitForPageLoaded(driver);
		try{
			/*driver.findElement(locator.findBy("links_lnkNettbutikk")).click();
			utils.verifyAndClickLink("links_lnkNettbutikk","Butikk");
			waitForPageLoaded(driver);*/
			utils.verifyAndClickLink("links_lnkMobileTab","Mobile Tab");
			waitForPageLoaded(driver);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void selectStoreSplitpaymentOrderApproval() throws InterruptedException, AWTException, ParserConfigurationException, SAXException, IOException {
		waitForPageLoaded(driver);
		Thread.sleep(3000L);
		//driver.findElement(locator.findBy("textboxes_txtStoreSelect")).click();
		utils.verifyAndClickButton("textboxes_txtStoreSelect", "Select Store");
		Thread.sleep(3000);
		//driver.findElement(locator.findBy("links_lnkLogicaStore")).click();
		utils.verifyAndClickLink("links_lnkSelectStoreSplitpaymentOrderApproval","Cowi AS");
		Thread.sleep(5000);
		waitForPageLoaded(driver);
		try{
			/*driver.findElement(locator.findBy("links_lnkNettbutikk")).click();
			utils.verifyAndClickLink("links_lnkNettbutikk","Butikk");
			waitForPageLoaded(driver);*/
			utils.verifyAndClickLink("links_lnkMobileTab","Mobile Tab");
			waitForPageLoaded(driver);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void selectMobileTab() throws InterruptedException, AWTException, ParserConfigurationException, SAXException, IOException {
		waitForPageLoaded(driver);
		Thread.sleep(3000L);
		
		try{
			/*driver.findElement(locator.findBy("links_lnkNettbutikk")).click();
			utils.verifyAndClickLink("links_lnkNettbutikk","Butikk");
			waitForPageLoaded(driver);*/
			utils.verifyAndClickLink("links_lnkMobileTab","Mobile Tab");
			waitForPageLoaded(driver);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	/** This function selects the subscriber name from the drop down list available in front end shop 
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */

	public void selectSubscriberNameDropdown() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		
		Thread.sleep(10000L);
		//driver.findElement(locator.findBy("textboxes_txtSubscriberSelection")).click();
		utils.verifyAndClickButton("textboxes_txtSubscriberSelection", "Subscriber Dropdown");

		Thread.sleep(5000L);
		if(driver.getCurrentUrl().endsWith("userinfook=true"))
		{
			//driver.findElement(locator.findBy("links_lnkSubscriberSharedUser")).click();
			utils.verifyAndClickLink("links_lnkSubscriberSharedUser","Subscriber Shared User");
			Thread.sleep(5000L);
		} 
		else
		{
			//driver.findElement(locator.findBy("links_lnkSubscriber")).click();
			utils.verifyAndClickLink("links_lnkSubscriber","Subscriber");

			Thread.sleep(5000L);
		}
		/*//driver.findElement(locator.findBy("checkboxes_chkAddSubscriptionB2B")).click();
		utils.verifyAndCheckCheckbox("checkboxes_chkAddSubscriptionB2B","Add Subscription");
		//driver.findElement(locator.findBy("checkboxes_chkBBAddSubscriptionB2B")).click();
		utils.verifyAndCheckCheckbox("checkboxes_chkBBAddSubscriptionB2B","Add Subscription");
		//driver.findElement(locator.findBy("buttons_btnSave")).click();
*/		utils.verifyAndClickButton("buttons_btnSave", "Save");		
		Thread.sleep(10000L);
		//driver.findElement(locator.findBy("buttons_btnDeliveryPayment2")).click();
		utils.verifyAndClickButton("buttons_btnDeliveryPayment2", "Delivery Payment");		
		waitForPageLoaded(driver);
	}
	
	/** This function selects the subscriber name from the drop down list available in front end shop 
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */

	public void selectSubscriberNameDropdown1() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		
		Thread.sleep(10000L);
		//driver.findElement(locator.findBy("textboxes_txtSubscriberSelection")).click();
		utils.verifyAndClickButton("textboxes_txtSubscriberSelection", "Subscriber Dropdown");

		Thread.sleep(5000L);
		if(driver.getCurrentUrl().endsWith("userinfook=true"))
		{
			//driver.findElement(locator.findBy("links_lnkSubscriberSharedUser")).click();
			utils.verifyAndClickLink("links_lnkSubscriberSharedUser","Subscriber Shared User");
			Thread.sleep(5000L);
		} 
		else
		{
			//driver.findElement(locator.findBy("links_lnkSubscriber")).click();
			utils.verifyAndClickLink("links_lnkSubscriberSharedUser","Subscriber");

			Thread.sleep(5000L);
		}
		/*//driver.findElement(locator.findBy("checkboxes_chkAddSubscriptionB2B")).click();
		utils.verifyAndCheckCheckbox("checkboxes_chkAddSubscriptionB2B","Add Subscription");
		//driver.findElement(locator.findBy("checkboxes_chkBBAddSubscriptionB2B")).click();
		utils.verifyAndCheckCheckbox("checkboxes_chkBBAddSubscriptionB2B","Add Subscription");
		//driver.findElement(locator.findBy("buttons_btnSave")).click();
*/		utils.verifyAndClickButton("buttons_btnSave", "Save");		
		Thread.sleep(10000L);
		//driver.findElement(locator.findBy("buttons_btnDeliveryPayment2")).click();
		utils.verifyAndClickButton("buttons_btnDeliveryPayment2", "Delivery Payment");		
		waitForPageLoaded(driver);
	}
	
	/** This function will select the delivery and payment modes from the front end shop 
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	public void deliveryAndPayments() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		
		waitForPageLoaded(driver);
		Finder locator =new Finder();
		
		//driver.findElement(locator.findBy("buttons_btnleveringsadresse")).click();
		utils.verifyAndEnterValueInTextBox("textboxes_txtDeresreferanse",dataTable.getData("General_data", "YourRefrence"),"Your Reference");
		utils.verifyAndEnterValueInTextBox("textboxes_txtKundensavdeling",dataTable.getData("General_data", "CustomerRefrence"),"Customer Reference");
		utils.verifyAndClickButton("buttons_btnleveringsadresse", "Levering Address");	

		Thread.sleep(500L);
		if(!driver.findElement(locator.findBy("textboxes_txtSharedUser")).getText().trim().equals("Fellesbruker"))
		{
			utils.verifyAndClickButton("textboxes_txtDeliveryAddressDropText", "Delivery Address");	
		    Thread.sleep(500L);
		}
		else
		{
			utils.verifyAndClickButton("textboxes_txtDeliveryAddressSharedUser", "Shared Delivery Address");
			Thread.sleep(500L);
		}
		/*try
		{
			//driver.findElement(locator.findBy("textboxes_txtDeliveryAddressDropText")).click();
			utils.verifyAndClickButton("textboxes_txtDeliveryAddressDropText", "Delivery Address");	
			Thread.sleep(500L);
		}
		catch(Exception e){
			//driver.findElement(locator.findBy("textboxes_txtDeliveryAddressSharedUser")).click();
			utils.verifyAndClickButton("textboxes_txtDeliveryAddressSharedUser", "Shared Delivery Address");	
			Thread.sleep(500L);
		}*/
		
		utils.verifyAndCheckCheckbox("checkboxes_chkShipping","Shipping");
		Thread.sleep(1000L);
		//driver.findElement(locator.findBy("checkboxes_chkBilling")).click();
		utils.verifyAndCheckCheckbox("checkboxes_chkBilling","Billing");
		InvoiceshippingPrice = Double.parseDouble(driver.findElement(locator.findBy("textboxes_txtInvoicePrice")).getText().replaceAll(",-","."));
		Thread.sleep(5000L);
		
		//driver.findElement(locator.findBy("buttons_btnfaktureringsadresse")).click();
		utils.verifyAndClickButton("buttons_btnfaktureringsadresse", "Fakturerings Address");	
		Thread.sleep(500L);
		
		if(!driver.findElement(locator.findBy("textboxes_txtSharedUser")).getText().trim().equals("Fellesbruker"))
		{
			utils.verifyAndClickButton("textboxes_txtBillingAddressDropText", "Billing Address");	
		    Thread.sleep(500L);
		}
		else
		{
			utils.verifyAndClickButton("textboxes_txtBillingAddressSharedUser", "Shared User Billing Address");
			Thread.sleep(500L);
		}
		/*try
		{
			//driver.findElement(locator.findBy("textboxes_txtBillingAddressDropText")).click();
			utils.verifyAndClickLink("textboxes_txtBillingAddressDropText","Billing Address");
			
			Thread.sleep(500L);
		}
		catch(Exception e){
			//driver.findElement(locator.findBy("textboxes_txtBillingAddressSharedUser")).click();
			utils.verifyAndClickLink("textboxes_txtBillingAddressSharedUser","Shared User Billing Address");
			Thread.sleep(500L);
		}*/
	  }

	
public void deliveryAndPaymentsOrderApproval() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		
		waitForPageLoaded(driver);
		Finder locator =new Finder();
		
		//driver.findElement(locator.findBy("buttons_btnleveringsadresse")).click();
		utils.verifyAndEnterValueInTextBox("textboxes_txtDeresreferanse",dataTable.getData("General_data", "YourRefrence"),"Your Reference");
		utils.verifyAndEnterValueInTextBox("textboxes_txtKundensavdeling",dataTable.getData("General_data", "CustomerRefrence"),"Customer Reference");
		utils.verifyAndClickButton("buttons_btnleveringsadresse", "Levering Address");	

		Thread.sleep(500L);
		if(!driver.findElement(locator.findBy("textboxes_txtSharedUser")).getText().trim().equals("Fellesbruker"))
		{
			utils.verifyAndClickButton("textboxes_txtDeliveryAddressDropText1", "Delivery Address");	
		    Thread.sleep(500L);
		}
		else
		{
			utils.verifyAndClickButton("textboxes_txtDeliveryAddressSharedUser", "Shared Delivery Address");
			Thread.sleep(500L);
		}
		/*try
		{
			//driver.findElement(locator.findBy("textboxes_txtDeliveryAddressDropText")).click();
			utils.verifyAndClickButton("textboxes_txtDeliveryAddressDropText", "Delivery Address");	
			Thread.sleep(500L);
		}
		catch(Exception e){
			//driver.findElement(locator.findBy("textboxes_txtDeliveryAddressSharedUser")).click();
			utils.verifyAndClickButton("textboxes_txtDeliveryAddressSharedUser", "Shared Delivery Address");	
			Thread.sleep(500L);
		}*/
		
		utils.verifyAndCheckCheckbox("checkboxes_chkShipping","Shipping");
		Thread.sleep(1000L);
		//driver.findElement(locator.findBy("checkboxes_chkBilling")).click();
		utils.verifyAndCheckCheckbox("checkboxes_chkBilling","Billing");
		InvoiceshippingPrice = Double.parseDouble(driver.findElement(locator.findBy("textboxes_txtInvoicePrice")).getText().replaceAll(",-","."));
		Thread.sleep(5000L);
		
		//driver.findElement(locator.findBy("buttons_btnfaktureringsadresse")).click();
		utils.verifyAndClickButton("buttons_btnfaktureringsadresse", "Fakturerings Address");	
		Thread.sleep(500L);
		
		if(!driver.findElement(locator.findBy("textboxes_txtSharedUser")).getText().trim().equals("Fellesbruker"))
		{
			utils.verifyAndClickButton("textboxes_txtBillingAddressSharedUser", "Billing Address");	
		    Thread.sleep(500L);
		}
		else
		{
			utils.verifyAndClickButton("textboxes_txtBillingAddressSharedUser", "Shared User Billing Address");
			Thread.sleep(500L);
		}
		/*try
		{
			//driver.findElement(locator.findBy("textboxes_txtBillingAddressDropText")).click();
			utils.verifyAndClickLink("textboxes_txtBillingAddressDropText","Billing Address");
			
			Thread.sleep(500L);
		}
		catch(Exception e){
			//driver.findElement(locator.findBy("textboxes_txtBillingAddressSharedUser")).click();
			utils.verifyAndClickLink("textboxes_txtBillingAddressSharedUser","Shared User Billing Address");
			Thread.sleep(500L);
		}*/
	  }



public void deliveryAndPaymentsSplitpayment() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
	
	waitForPageLoaded(driver);
	Finder locator =new Finder();
	
	//driver.findElement(locator.findBy("buttons_btnleveringsadresse")).click();
	utils.verifyAndEnterValueInTextBox("textboxes_txtInitialer",dataTable.getData("General_data", "YourRefrence"),"Your Reference");
	utils.verifyAndEnterValueInTextBox("textboxes_txtKundensavdeling",dataTable.getData("General_data", "CustomerRefrence"),"Customer Reference");
	//utils.verifyAndClickButton("buttons_btnleveringsadresse0", "Levering Address Focus");
	//Thread.sleep(4000L);
	//utils.verifyAndClickButton("buttons_btnleveringsadresse1", "Levering Address");
	//Thread.sleep(4000L);
	utils.verifyAndClickButton("buttons_btnOrderApprover", "B2BApproverList");
	utils.verifyAndClickButton("links_lnkOrderApprover","B2BApproverList");
	utils.verifyAndEnterValueInTextBox("textboxes_txtInitialer1",dataTable.getData("General_data", "Navn + initialer"),"Navn + initialer");
	utils.verifyAndEnterValueInTextBox("textboxes_txtMobilnummer",dataTable.getData("General_data", "Navn+Mobilnummer"),"Navn+Mobilnummer");
	
	
	utils.verifyAndCheckCheckbox("checkboxes_chkShipping","Shipping");
	Thread.sleep(1000L);
	//driver.findElement(locator.findBy("checkboxes_chkBilling")).click();
	utils.verifyAndCheckCheckbox("checkboxes_chkBilling","Billing");
	InvoiceshippingPrice = Double.parseDouble(driver.findElement(locator.findBy("textboxes_txtInvoicePrice")).getText().replaceAll(",-","."));
	Thread.sleep(5000L);
	
	//driver.findElement(locator.findBy("buttons_btnfaktureringsadresse")).click();
	utils.verifyAndClickButton("buttons_btnfaktureringsadresse", "Fakturerings Address");	
	Thread.sleep(500L);
	
	if(!driver.findElement(locator.findBy("textboxes_txtSharedUser")).getText().trim().equals("Fellesbruker"))
	{
		utils.verifyAndClickButton("textboxes_txtBillingAddressSharedUser", "Billing Address");	
	    Thread.sleep(500L);
	}
	else
	{
		utils.verifyAndClickButton("textboxes_txtBillingAddressSharedUser", "Shared User Billing Address");
		Thread.sleep(500L);
	}
	
  }
	/** This function used to select the accessory from the front end shop
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	public void accessoriesSelection() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		
		//driver.findElement(locator.findBy("textboxes_lnkaccessoriesTab")).click();
		utils.verifyAndClickButton("textboxes_lnkaccessoriesTab", "Accessories Tab");	
		Thread.sleep(4000L);
		//driver.findElement(locator.findBy("buttons_btnSelectAcessories")).click();
		utils.verifyAndClickButton("buttons_btnSelectAcessories", "Select Acessories");	
		Thread.sleep(8000L);
		}

	/** This function will click on the order number present in the WebAdmin 
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	public void clickOnOrderNumber() throws InterruptedException, AWTException, ParserConfigurationException, SAXException, IOException {
		waitForPageLoaded(driver);
		Finder locator =new Finder();
		fluentwait(locator.findBy("images_imgAjaxLoad"));
        //fluentwait(locator.findBy("images_imgFailedAjaxLoad"));
		
		if (hm.get("orderNumber")!= null) 
		{
			//driver.findElement(locator.findBy("textboxes_txtSearchOrder")).sendKeys(hm.get("orderNumber"));
			utils.verifyAndEnterValueInTextBox("textboxes_txtSearchOrder",hm.get("orderNumber"),"Search");
			
			//driver.findElement(locator.findBy("buttons_btnFindOrders")).click();
			utils.verifyAndClickButton("buttons_btnFindOrders", "Find Orders");	
			fluentwait(locator.findBy("images_imgAjaxLoad"));
			//driver.findElement(locator.findBy("links_lnkOrderNumber")).click();
			utils.verifyAndClickLink("links_lnkOrderNumber","Order Number");
			hm.put("orderNumber", null);
			report.updateTestLog("ClicknOnOrderNumber","Sucessfully Clicked on Order Number", Status.DONE);
		} 
		else 
		{
		report.updateTestLog("ClicknOnOrderNumber","Order Number is not been generated Unable to click Order Number",Status.DONE);
		}
	}

	/** This function used to log out from Ihelp application
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	public void logout() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		Thread.sleep(4000);
		//windowMaximize();
		if(urlName.equals("ApplicationUrl7")||urlName.equals("ApplicationUrl25"))
		{	
		driver.findElement(MasterPage.lnkLogOut).click();
		waitForPageLoaded(driver);
		report.updateTestLog("Logout", "Click the sign-off link", Status.DONE);
		}
		
		else
			if(urlName.equals("ApplicationUrl14")||urlName.equals("ApplicationUrl20"))
			{	
				driver.findElement(MasterPage.lnkLogOutHapi).click();
				waitForPageLoaded(driver);
				report.updateTestLog("Log Off", "Click the sign-off link", Status.DONE);
			}
		else	
		{
			 driver.findElement(MasterPage.lnkLogut).click();
			 waitForPageLoaded(driver);
			 report.updateTestLog("Logout", "Click the Log Out link", Status.DONE);
		}
	}

	/** This function will wait for the page to load 
	 * 
	 * @param driver
	 */

	public void waitForPageLoaded(WebDriver driver) {

		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState").equals("complete");
			}
		};

		Wait<WebDriver> wait = new WebDriverWait(driver, 60);
		try {
			wait.until(expectation);
		} catch (Throwable error) {
			report.updateTestLog("Page Load",
					"Timeout waiting for Page Load Request to complete.",
					Status.WARNING);
		}
	}

	/** This function used to select the tablets from the front end shop 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * 
	 */
	
	public void selectTablets() throws ParserConfigurationException, SAXException, IOException {
		
		//VerificationComponents.IsmultiProductSelected=true;
		//waitForPageLoaded(driver);
		//driver.findElement(locator.findBy("links_lnkShopMore")).click();
		//utils.verifyAndClickLink("links_lnkShopMore", "Shop More");	
		//waitForPageLoaded(driver);
		//driver.findElement(locator.findBy("links_lnkTablets")).click();
		utils.verifyAndClickLink("links_lnkTablets", "Tablets");	
		waitForPageLoaded(driver);
	}
	
	/** This function used to select the Broadband from the front end shop 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * 
	 */
	
	public void selectBroadband() throws ParserConfigurationException, SAXException, IOException {
		
		//VerificationComponents.IsmultiProductSelected=true;
		//waitForPageLoaded(driver);
		//driver.findElement(locator.findBy("links_lnkShopMore")).click();
		//utils.verifyAndClickLink("links_lnkShopMore", "Shop More");	
		//waitForPageLoaded(driver);
		//driver.findElement(locator.findBy("links_lnkTablets")).click();
		utils.verifyAndClickLink("links_lnkBroadband", "Broadband");	
		waitForPageLoaded(driver);
	}
	
	/** This function will do the task of updating local product job in Ihelp
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	public void updateLocalProductsJob() throws InterruptedException, ParserConfigurationException, SAXException, IOException
	{
	waitForPageLoaded(driver);
	Finder locator =new Finder();
	//driver.findElement(locator.findBy("links_lnkTaskTab")).click();
	utils.verifyAndClickLink("links_lnkTaskTab", "Task Tab");	
	waitForPageLoaded(driver);
	
	int counter = 1;
 	List <WebElement> TaskNo = driver.findElements(locator.findBy("textboxes_txtTaskNumber"));
 	for (WebElement Tasks:TaskNo)
 		{
	 		if(Tasks.getText().trim().contains(dataTable.getData("General_Data", "Task")))
	 		break;
	 		counter++;
 	    }
 	 driver.findElement(By.xpath("//div[@id='content']//table["+counter+"][@class='taskListGroup']//tbody//tr[2]//td//input[@value='Kjør nå']")).click();
 	 waitForPageLoaded(driver);
 	
	//waitForPageLoaded(driver);
	//driver.findElement(locator.findBy("links_lnkStatus")).click();
 	
 	Thread.sleep(25000);
	utils.verifyAndClickLink("links_lnkStatus", "Status");	
	Thread.sleep(15000);
	boolean taskStatus= driver.findElement(locator.findBy("links_lnkTaskStatus")).isDisplayed();

	if(taskStatus)
	report.updateTestLog("Task Run Status","FetchAllSalespoints task is running Successfully",Status.PASS);
	else
	report.updateTestLog("Task Run Status","FetchAllSalespoints task did not run Successfully",Status.FAIL);
	}

	/** This function will provide external orders displayed in WebAdmin   
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * 
	 */
	
	public void searchExternalOrders() throws ParserConfigurationException, SAXException, IOException
	{
	waitForPageLoaded(driver);
	Finder locator =new Finder();
	//driver.findElement(locator.findBy("links_lnkOrderSearch")).click();
	utils.verifyAndClickLink("links_lnkOrderSearch", "Search");	
	waitForPageLoaded(driver);
	//driver.findElement(locator.findBy("textboxes_txtFromDate")).sendKeys(dataTable.getData("General_Data","FromDate"));
	utils.verifyAndEnterValueInTextBox("textboxes_txtFromDate",dataTable.getData("General_Data","FromDate"),"From Date");
	//driver.findElement(locator.findBy("textboxes_txtToDate")).sendKeys(dataTable.getData("General_Data","ToDate"));
	utils.verifyAndEnterValueInTextBox("textboxes_txtToDate",dataTable.getData("General_Data","ToDate"),"To Date");
	//driver.findElement(locator.findBy("links_lnkbutton")).click();
	utils.verifyAndClickLink("links_lnkbutton", "Button");	
	waitForPageLoaded(driver);
	List<WebElement> element =driver.findElements(locator.findBy("links_lnkOrderList"));

	if(element.size()>=1)
	report.updateTestLog("Search External Orders","All the external orders are Shown",Status.PASS);
	
    else
	report.updateTestLog("Search External Orders","External orders are not shown",Status.FAIL);
   }

   /** This function will do CNET Search in WebAdmin
    * 	
    * @throws InterruptedException
 * @throws AWTException 
 * @throws IOException 
 * @throws SAXException 
 * @throws ParserConfigurationException 
    */
	
	public void cnetSearch() throws InterruptedException, AWTException, ParserConfigurationException, SAXException, IOException
	{
	//waitForPageLoaded(driver);
	//windowMaximize();
	Finder locator =new Finder();
	fluentwait(locator.findBy("images_imgAjaxLoad"));
	//fluentwait(locator.findBy("images_imgFailedAjaxLoad"));
	
		
	Actions builder = new Actions(driver);
	builder.moveToElement(driver.findElement(locator.findBy("links_lnkProductMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkAddProduct"))).click().perform();
	waitForPageLoaded(driver);
	
	Actions builder2 = new Actions(driver);
	builder2.moveToElement(driver.findElement(locator.findBy("links_lnkProductMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkAddProduct"))).click().perform();
	waitForPageLoaded(driver);
	//driver.findElement(locator.findBy("links_lnkLightBox")).click();
	utils.verifyAndClickLink("links_lnkLightBox", "Light Box");	

	
	fluentwait(locator.findBy("images_imgJqueryLoad"));
	String parentWindow =driver.getWindowHandle();
	switchtoNewWindow(parentWindow);
	//driver.findElement(locator.findBy("textboxes_txtCNETBox")).sendKeys(dataTable.getData("General_data","CNET"));
	utils.verifyAndEnterValueInTextBox("textboxes_txtCNETBox",dataTable.getData("General_data","CNET"),"CNET");
	//driver.findElement(locator.findBy("links_lnkCNETSearch")).click();
	utils.verifyAndClickLink("links_lnkCNETSearch", "Search");	
	fluentwait(locator.findBy("textboxes_txtCNETList"));
	boolean htcStatus =driver.findElement(locator.findBy("textboxes_txtCNETList")).getText().contains("HTC");

	if(htcStatus)
	report.updateTestLog("CNET Search","Search items related to 'htc' is displayed",Status.PASS);
	
    else
	report.updateTestLog("CNET Search","Search items related to 'htc' are not displayed",Status.FAIL);
	
	driver.findElement(locator.findBy("buttons_btnClose")).click();
	Thread.sleep(4000L);
	switchBacktoOldWindow(parentWindow);
}
	/** This function will add new local product for WebAdmin
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
  	
	public void addNewLocalProduct() throws InterruptedException, AWTException, ParserConfigurationException, SAXException, IOException
	{
	Finder locator =new Finder();
	fluentwait(locator.findBy("images_imgAjaxLoad"));
	String excelTitle= dataTable.getData("General_data","Title");
	Date now = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    String timestampString = formatter.format(now);
    String title =excelTitle+timestampString; 
    
	Actions builder = new Actions(driver);
	builder.moveToElement(driver.findElement(locator.findBy("links_lnkProductMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkAddProduct"))).click().perform();
	waitForPageLoaded(driver);
	
	try
	{
	Actions builder2 = new Actions(driver);
	builder2.moveToElement(driver.findElement(locator.findBy("links_lnkProductMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkAddProduct"))).click().perform();
	waitForPageLoaded(driver);
	}
	
	catch(Exception e)
	{
	e.printStackTrace();
	}
	//driver.findElement(locator.findBy("textboxes_txtTitle")).sendKeys(title); 
	utils.verifyAndEnterValueInTextBox("textboxes_txtTitle",title,"Title");
	//driver.findElement(locator.findBy("textboxes_txtDescription")).sendKeys(dataTable.getData("General_data","Description")); 
	utils.verifyAndEnterValueInTextBox("textboxes_txtDescription",dataTable.getData("General_data","Description"),"Description");
	//driver.findElement(locator.findBy("textboxes_txtModelName")).sendKeys(dataTable.getData("General_data","ModelName"));
	utils.verifyAndEnterValueInTextBox("textboxes_txtModelName",dataTable.getData("General_data","ModelName"),"Model Name");

	Select dropdown1 = new Select(driver.findElement(By.id("ProductType_Value")));
	dropdown1.selectByVisibleText(dataTable.getData("General_data","ProductCategory"));  
	Select dropdown2 = new Select(driver.findElement(By.id("Producer_Value")));
	dropdown2.selectByVisibleText(dataTable.getData("General_data","Manufacturer"));
    Select dropdown3 = new Select(driver.findElement(By.id("Supplier_Value")));
	dropdown3.selectByVisibleText(dataTable.getData("General_data","Supplier"));  

	//driver.findElement(locator.findBy("textboxes_txtCostPrice")).sendKeys(dataTable.getData("General_data","CostPrice")); 
	utils.verifyAndEnterValueInTextBox("textboxes_txtCostPrice",dataTable.getData("General_data","CostPrice"),"Cost Price");
	//driver.findElement(locator.findBy("textboxes_txtSupplierProductId")).sendKeys(dataTable.getData("General_data","SupplierProductId"));
	utils.verifyAndEnterValueInTextBox("textboxes_txtSupplierProductId",dataTable.getData("General_data","SupplierProductId"),"Supplier ID");
	//driver.findElement(locator.findBy("textboxes_txtProducerProductId")).sendKeys(dataTable.getData("General_data","ProducerProductId"));
	utils.verifyAndEnterValueInTextBox("textboxes_txtProducerProductId",dataTable.getData("General_data","ProducerProductId"),"Product ID");
	//driver.findElement(locator.findBy("textboxes_txtProducerProductUrl")).sendKeys(dataTable.getData("General_data","ProducerProductUrl"));
	utils.verifyAndEnterValueInTextBox("textboxes_txtProducerProductUrl",dataTable.getData("General_data","ProducerProductUrl"),"Product URL");
	//driver.findElement(locator.findBy("textboxes_txtMessageToHermesText")).sendKeys(dataTable.getData("General_data","MessageToHermesText"));
	utils.verifyAndEnterValueInTextBox("textboxes_txtMessageToHermesText",dataTable.getData("General_data","MessageToHermesText"),"Hermes Text");
	//driver.findElement(locator.findBy("links_lnkNext")).click();
	utils.verifyAndClickLink("links_lnkNext", "Next");	
	waitForPageLoaded(driver);

	Select dropdown4 = new Select(driver.findElement(By.id("attributeId")));
	dropdown4.selectByVisibleText(dataTable.getData("General_data","Properties1"));

	//driver.findElement(locator.findBy("textboxes_txtSetValue")).sendKeys(dataTable.getData("General_Data","SetValue1"));
	utils.verifyAndEnterValueInTextBox("textboxes_txtSetValue",dataTable.getData("General_data","SetValue1"),"SetValue");

	Select dropdown5 = new Select(driver.findElement(By.id("measurementId")));
	dropdown5.selectByVisibleText(dataTable.getData("General_data","MeasurementUnit1"));
	

	JavascriptExecutor jsx = (JavascriptExecutor)driver;
	jsx.executeScript("window.scrollBy(0,450)", "");

	//driver.findElement(locator.findBy("links_lnkNext")).click();  
	utils.verifyAndClickLink("links_lnkNext", "Next");	
	waitForPageLoaded(driver);

	Select dropdown6 = new Select(driver.findElement(By.id("attributeId")));
	dropdown6.selectByVisibleText(dataTable.getData("General_data","Properties2"));

	//driver.findElement(locator.findBy("textboxes_txtSetValue")).sendKeys(dataTable.getData("General_Data","SetValue2"));  
	utils.verifyAndEnterValueInTextBox("textboxes_txtSetValue",dataTable.getData("General_Data","SetValue2"),"Set Value");

	Select dropdown7 = new Select(driver.findElement(By.id("measurementId")));
	dropdown7.selectByVisibleText(dataTable.getData("General_data","MeasurementUnit2"));

	jsx.executeScript("window.scrollBy(0,450)", "");
	
	//driver.findElement(locator.findBy("links_lnkNext")).click(); 
	utils.verifyAndClickLink("links_lnkNext", "Next");	
	waitForPageLoaded(driver);

	Select dropdown8 = new Select(driver.findElement(By.id("ColorId")));
	dropdown8.selectByVisibleText(dataTable.getData("General_data","ColorId"));

	//driver.findElement(locator.findBy("textboxes_txtYoutubeLink")).sendKeys(dataTable.getData("General_data","YoutubeLink")); 
	utils.verifyAndEnterValueInTextBox("textboxes_txtYoutubeLink",dataTable.getData("General_data","YoutubeLink"),"YouTubeLink");
	//driver.findElement(locator.findBy("textboxes_txtFlashLink")).sendKeys(dataTable.getData("General_data","FlashLink")); 
	utils.verifyAndEnterValueInTextBox("textboxes_txtFlashLink",dataTable.getData("General_data","FlashLink"),"FlashLink");
	//driver.findElement(locator.findBy("textboxes_txtFlashWidth")).sendKeys(dataTable.getData("General_data","FlashWidth"))
	utils.verifyAndEnterValueInTextBox("textboxes_txtFlashWidth",dataTable.getData("General_data","FlashWidth"),"FlashWidth");  
	//driver.findElement(locator.findBy("textboxes_txtFlashHeight")).sendKeys(dataTable.getData("General_data","FlashHeight"));
	utils.verifyAndEnterValueInTextBox("textboxes_txtFlashHeight",dataTable.getData("General_data","FlashHeight"),"FlashHeight");  
	//driver.findElement(locator.findBy("links_lnkNext")).click();  
	utils.verifyAndClickLink("links_lnkNext", "Next");	
	waitForPageLoaded(driver);
	//driver.findElement(locator.findBy("textboxes_txtwizardSave")).click(); 
	utils.verifyAndClickButton("textboxes_txtwizardSave", "Save");	
	waitForPageLoaded(driver);
	boolean newProduct = driver.findElement(locator.findBy("textboxes_txtTitle2")).getText().contains(title);

	if(newProduct)
	report.updateTestLog("New Local Product","New product  added to Incoming product list successfully",Status.PASS);
	
	else
	report.updateTestLog("New Local Product","New product  not added to Incoming product list successfully",Status.FAIL);
    }

    /** This function will create user in WebAdmin 
     * 	
     * @throws InterruptedException
     * @throws IOException 
     * @throws SAXException 
     * @throws ParserConfigurationException 
     * @throws AWTException 
     */
	
	public void createUser() throws InterruptedException, ParserConfigurationException, SAXException, IOException
	{
	
	Finder locator =new Finder();
	fluentwait(locator.findBy("images_imgAjaxLoad"));
	//fluentwait(locator.findBy("images_imgFailedAjaxLoad"));
	
	String excelUser = dataTable.getData("General_data","UsrName");
	String excelLastName =dataTable.getData("General_data","LastName");
    Date now = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    String timestampString = formatter.format(now);
    String user =excelUser+timestampString; 
    String lastName=excelLastName+timestampString; 
	
	Actions builder = new Actions(driver);
	builder.moveToElement(driver.findElement(locator.findBy("links_lnkUserMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkUserSubMenu"))).click().perform();
	waitForPageLoaded(driver);
	
	try
	{
	Actions builder2 = new Actions(driver);
	builder2.moveToElement(driver.findElement(locator.findBy("links_lnkUserMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkUserSubMenu"))).click().perform();
	waitForPageLoaded(driver);
	}

	catch(Exception e)
	{
	e.printStackTrace();
	}
	//driver.findElement(locator.findBy("textboxes_txtUserName")).sendKeys(user); 
	utils.verifyAndEnterValueInTextBox("textboxes_txtUserName",user,"User Name"); 
	//driver.findElement(locator.findBy("textboxes_txtFirstName2")).sendKeys(dataTable.getData("General_data","FirstName"));
	utils.verifyAndEnterValueInTextBox("textboxes_txtFirstName2",dataTable.getData("General_data","FirstName"),"First Name"); 
	//driver.findElement(locator.findBy("textboxes_txtLastName2")).sendKeys(lastName);
	utils.verifyAndEnterValueInTextBox("textboxes_txtLastName2",lastName,"Last Name"); 
	//driver.findElement(locator.findBy("textboxes_txtEmail2")).sendKeys(dataTable.getData("General_data","Email"));
	utils.verifyAndEnterValueInTextBox("textboxes_txtEmail2",dataTable.getData("General_data","Email"),"Email"); 
	//driver.findElement(locator.findBy("textboxes_txtMobileNumber2")).sendKeys(dataTable.getData("General_data","MobileNumber"));
	utils.verifyAndEnterValueInTextBox("textboxes_txtMobileNumber2",dataTable.getData("General_data","MobileNumber"),"Mobile Number"); 
	//driver.findElement(locator.findBy("links_lnkNext")).click();
	utils.verifyAndClickLink("links_lnkNext", "Next");
	waitForPageLoaded(driver);
	//driver.findElement(locator.findBy("links_lnkNext")).click(); 
	utils.verifyAndClickLink("links_lnkNext", "Next");
	waitForPageLoaded(driver);
	
	Select dropdown1 = new Select(driver.findElement(By.id("roleTemplate")));
	dropdown1.selectByVisibleText(dataTable.getData("General_data","TemplateRights"));  
	//driver.findElement(locator.findBy("links_lnkAdministrator")).click();
	utils.verifyAndClickLink("links_lnkAdministrator","Administrator");
	//driver.findElement(locator.findBy("links_lnkNext")).click();
	utils.verifyAndClickLink("links_lnkNext", "Next");
	waitForPageLoaded(driver);
	//driver.findElement(locator.findBy("textboxes_txtwizardSave")).click();
	utils.verifyAndClickButton("textboxes_txtwizardSave", "Save");
	waitForPageLoaded(driver);
	//driver.findElement(locator.findBy("textboxes_txtButtik")).sendKeys(lastName);
	utils.verifyAndEnterValueInTextBox("textboxes_txtButtik",lastName,"Buttik");
	//driver.findElement(locator.findBy("links_lnkSearch")).click();
	utils.verifyAndClickLink("links_lnkSearch", "Search");
	waitForPageLoaded(driver);

	boolean userCreated= driver.findElement(locator.findBy("textboxes_txtProductList")).getText().equals(dataTable.getData("General_data","FirstName")+" "+lastName);

	if(userCreated)
	report.updateTestLog("User Creation","Successfully created new user",Status.PASS);
		 
	else
	report.updateTestLog("User Creation","New user is not created successfully",Status.FAIL);
    }
	
	/** This function will update the Campaign Attribute for WebAdmin 
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws AWTException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */

	public void updateStoreCampaignAttribute() throws InterruptedException, IOException, AWTException, ParserConfigurationException, SAXException
	{
	
	Finder locator =new Finder();
	fluentwait(locator.findBy("images_imgAjaxLoad"));
	//fluentwait(locator.findBy("images_imgFailedAjaxLoad"));
		
	Actions builder = new Actions(driver);
	builder.moveToElement(driver.findElement(locator.findBy("links_lnkButikkMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkButikkSubMenu"))).click().perform();
	waitForPageLoaded(driver);
	
	try
	{
	//driver.findElement(locator.findBy("links_lnkButikkMenu")).click();
	utils.verifyAndClickLink("links_lnkButikkMenu","Butikk Menu");
    waitForPageLoaded(driver);
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}
	//driver.findElement(locator.findBy("textboxes_txtButtik")).sendKeys("Telenor Nettbutikk Privat");
	utils.verifyAndEnterValueInTextBox("textboxes_txtButtik","Telenor Nettbutikk Privat","Buttik"); 
	//driver.findElement(locator.findBy("links_lnkSearch")).click();
	utils.verifyAndClickLink("links_lnkSearch", "Search");
	waitForPageLoaded(driver);
	//driver.findElement(locator.findBy("links_lnkShopVismer")).click();
	utils.verifyAndClickLink("links_lnkShopVismer", "Vismer");
	Thread.sleep(3000L);
	//driver.findElement(locator.findBy("buttons_btnEditStore")).click();
	utils.verifyAndClickButton("buttons_btnEditStore","Edit Store");
	waitForPageLoaded(driver);
	/*driver.findElement(locator.findBy("buttons_btnProceed")).click();
	utils.verifyAndClickButton("buttons_btnProceed","Proceed");
	waitForPageLoaded(driver);*/
	driver.findElement(locator.findBy("textboxes_txtServiceUrl")).clear();
	//driver.findElement(locator.findBy("textboxes_txtServiceUrl")).sendKeys(dataTable.getData("General_data","ServiceUrl"));
	utils.verifyAndEnterValueInTextBox("textboxes_txtServiceUrl",dataTable.getData("General_data","ServiceUrl"),"Service URL"); 
	
	for(int var=0;var<=5;var++)
	{
	//driver.findElement(locator.findBy("buttons_btnProceed")).click();
	utils.verifyAndClickButton("buttons_btnProceed","Proceed");
	waitForPageLoaded(driver);
	}
	//driver.findElement(locator.findBy("links_lnkCreateButikkAdmin")).click();
	utils.verifyAndClickLink("links_lnkCreateButikkAdmin","CreateButtikAdmin");
	String parentWindow2 =driver.getWindowHandle();
	switchtoNewWindow(parentWindow2);
	Thread.sleep(500L);
	
	Random randomGenerator = new Random();
    int randomInt = randomGenerator.nextInt(10000);
    int randomInt2 = randomGenerator.nextInt(100000000);
   
    String firstname = dataTable.getData("General_Data", "FirstName")+randomInt;
    
    //driver.findElement(locator.findBy("textboxes_txtFirstName2")).sendKeys(firstname);
    utils.verifyAndEnterValueInTextBox("textboxes_txtFirstName2",firstname,"First Name"); 
    //driver.findElement(locator.findBy("textboxes_txtLastName2")).sendKeys(dataTable.getData("General_Data", "LastName"));
    utils.verifyAndEnterValueInTextBox("textboxes_txtLastName2",dataTable.getData("General_Data", "LastName"),"Last Name"); 
    //driver.findElement(locator.findBy("textboxes_txtMobileNumber2")).sendKeys(Integer.toString(randomInt2));
    utils.verifyAndEnterValueInTextBox("textboxes_txtMobileNumber2",Integer.toString(randomInt2),"Mobile Number"); 
    //driver.findElement(locator.findBy("textboxes_txtEmail2")).sendKeys(dataTable.getData("General_Data", "Email"));
    utils.verifyAndEnterValueInTextBox("textboxes_txtEmail2",dataTable.getData("General_Data","Email"),"Email"); 
    //driver.findElement(locator.findBy("buttons_btnSave2")).click();
    utils.verifyAndClickButton("buttons_btnSave2","Save");
	waitForPageLoaded(driver);
	switchBacktoOldWindow(parentWindow2);
	
	//driver.findElement(locator.findBy("buttons_btnSaveChanges")).click();
	utils.verifyAndClickButton("buttons_btnSaveChanges","Save");
	waitForPageLoaded(driver);
	//driver.findElement(locator.findBy("buttons_btnEditStore2")).click();
	utils.verifyAndClickButton("buttons_btnEditStore2","Edit Store");
	waitForPageLoaded(driver);
	//driver.findElement(locator.findBy("links_lnkProperties")).click();
	utils.verifyAndClickLink("links_lnkProperties","Properties");
	waitForPageLoaded(driver);
	
	boolean serviceUrlCheck = driver.findElement(locator.findBy("textboxes_txtServiceUrl")).getAttribute("value").equals(dataTable.getData("General_data","ServiceUrl"));
	Thread.sleep(500L);
	//driver.findElement(locator.findBy("links_lnkRoller")).click();
	utils.verifyAndClickLink("links_lnkRoller","Roller");
	waitForPageLoaded(driver);
	boolean	 UserCheck = driver.findElement(findByDynXpath(locator.findBy("textboxes_txtAdminUserCheck"),firstname)).isDisplayed();
    
    if(serviceUrlCheck && UserCheck)
     report.updateTestLog("Store Updation","Successfully updated the store",Status.PASS);
    
    else
    report.updateTestLog("Store Updation","Unable to update the store",Status.FAIL);
    
    WebElement elementToShowMenu2 = driver.findElement(locator.findBy("links_lnkButikkMenu"));
	elementToShowMenu2.click();
	waitForPageLoaded(driver);
	//driver.findElement(locator.findBy("textboxes_txtButtik")).sendKeys("Telenor Nettbutikk Privat");
	utils.verifyAndEnterValueInTextBox("textboxes_txtButtik","Telenor Nettbutikk Privat","Buttik"); 
	//driver.findElement(locator.findBy("links_lnkSearch")).click();
	utils.verifyAndClickLink("links_lnkSearch","Search");
	waitForPageLoaded(driver);
	//driver.findElement(locator.findBy("links_lnkShopVismer")).click();
	utils.verifyAndClickLink("links_lnkShopVismer","Vismer");
	Thread.sleep(3000L);
	//driver.findElement(locator.findBy("links_lnkCampaginAttribute")).click();
	utils.verifyAndClickLink("links_lnkCampaginAttribute","CampaginAttribute");
	waitForPageLoaded(driver);
	//driver.findElement(locator.findBy("links_lnkCampaign")).click();
	utils.verifyAndClickLink("links_lnkCampaign","Campagin");
	fluentwait(locator.findBy("images_imgJqueryLoad"));
	
	String parentWindow =driver.getWindowHandle();
	switchtoNewWindow(parentWindow);
	WebElement element =driver.findElement(locator.findBy("links_lnkBrowse"));
	Thread.sleep(10000L);
	//((JavascriptExecutor)driver).executeScript("arguments[0].style.visibility = 'visible'; arguments[0].style.height = '1px'; arguments[0].style.width = '1px'; arguments[0].style.opacity = 1",element);
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", element);
	Thread.sleep(10000L);
	
	File file = new File("C:\\Users\\admin\\workspace\\Demo\\JacobDll", "jacob-1.17-x86.dll"); //path to the jacob dll  
	System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath()); 
	AutoItX x = new AutoItX();
	
	String widowTitle = "File Upload";
    x.winWait(widowTitle, "File &name:",10);
    x.send("C:\\Users\\admin\\workspace\\Demo\\bomb1.png");
   // x.ControlSetText(widowTitle, "", "[CLASS:Edit; INSTANCE:1]", "C:/Murali/Test1.png");
    x.controlClick(widowTitle, "", "[CLASS:Button; INSTANCE:1]");
    x.winWaitClose(widowTitle, "File &name:", 10);
	Thread.sleep(10000L);
	//driver.findElement(locator.findBy("buttons_btnImageUpload")).click();  
	utils.verifyAndClickButton("buttons_btnImageUpload","Upload Image");
    waitForPageLoaded(driver);
    switchBacktoOldWindow(parentWindow);
    //driver.findElement(locator.findBy("buttons_btnProceed")).click();
    utils.verifyAndClickButton("buttons_btnProceed","Proceed");
	waitForPageLoaded(driver);
	
 	List<WebElement> element2 = driver.findElements(locator.findBy("textboxes_txtPhoneName"));
	  int counter =1;
	  for(WebElement mobileText: element2)
	  {
		  if(mobileText.getText().equals(dataTable.getData("General_data","MobileName")))
		  {
		  WebElement mobiles = driver.findElement(findByDynXpath(locator.findBy("checkboxes_chkCampaign"),String.valueOf(counter))); 
		  Actions builder2 = new Actions(driver);    
		  builder2.moveToElement(mobiles).perform(); 
		  Thread.sleep(3000L);
		  driver.findElement(findByDynXpath(locator.findBy("checkboxes_chkCampaign"),String.valueOf(counter))).click();
		  Thread.sleep(4000L);
		  break;		  
		  }
		  else
		  {
		  counter++;
		  }
	   }
	JavascriptExecutor jsx = (JavascriptExecutor)driver;
	jsx.executeScript("window.scrollBy(0,450)", "");
	//driver.findElement(locator.findBy("buttons_btnSaveChanges")).click();
	utils.verifyAndClickButton("buttons_btnSaveChanges","Save");
	waitForPageLoaded(driver);
	//driver.findElement(locator.findBy("textboxes_txtButtik")).sendKeys("Telenor Nettbutikk Privat");
	utils.verifyAndEnterValueInTextBox("textboxes_txtButtik","Telenor Nettbutikk Privat","Buttik"); 
	
	//driver.findElement(locator.findBy("links_lnkSearch")).click();
	utils.verifyAndClickLink("links_lnkSearch","Search");
	waitForPageLoaded(driver);
	//driver.findElement(locator.findBy("links_lnkShopVismer")).click();
	utils.verifyAndClickLink("links_lnkShopVismer","Vismer");
	Thread.sleep(3000L);
	//driver.findElement(locator.findBy("buttons_btnUpdateStore")).click();
	utils.verifyAndClickButton("buttons_btnUpdateStore","Update");
	waitForPageLoaded(driver);
	//driver.findElement(locator.findBy("links_lnkButikk"));
	utils.verifyAndClickLink("links_lnkButikk","Butikk");
	waitForPageLoaded(driver);
	//driver.findElement(locator.findBy("textboxes_txtButtik")).sendKeys("Telenor Nettbutikk Privat");
	 utils.verifyAndEnterValueInTextBox("textboxes_txtButtik","Telenor Nettbutikk Privat","Butikk"); 
	//driver.findElement(locator.findBy("links_lnkSearch")).click();
	 utils.verifyAndClickLink("links_lnkSearch","Search");
	waitForPageLoaded(driver);
	//driver.findElement(locator.findBy("links_lnkShopVismer")).click();
	 utils.verifyAndClickLink("links_lnkShopVismer","Vismer");
	Thread.sleep(3000L);
	//driver.findElement(locator.findBy("links_lnkCampaginAttribute")).click();
	 utils.verifyAndClickLink("links_lnkCampaginAttribute","CampaginAttribute");
	waitForPageLoaded(driver);
	Thread.sleep(300000L);	
	//driver.findElement(locator.findBy("links_lnkCampaign")).click();
	 utils.verifyAndClickLink("links_lnkCampaign","Campagin");
	fluentwait(locator.findBy("images_imgJqueryLoad"));
	String parentWindow3 =driver.getWindowHandle();
	switchtoNewWindow(parentWindow3);
	Thread.sleep(6000L);
	mbizImageName= getImageNameFromUrl(driver.findElement(locator.findBy("images_imgCampaginImage")).getAttribute("src"));
	waitForPageLoaded(driver);
	}
	
	/** This function is used to obtain the image name from the Image URL of the Campaign Attribute 
	 * 
	 * @param imageUrl
	 * @return
	 */
	
	public String getImageNameFromUrl(String imageUrl)
	{
		String imageName="";
		
		if(imageUrl.indexOf('?')>0)
			imageName=imageUrl.substring(imageUrl.lastIndexOf('/'),imageUrl.indexOf('?'));
		else
			imageName=imageUrl.substring(imageUrl.lastIndexOf('/'));
		
		return imageName;	
	}
	
	/** This function will compare the Campaign attribute image of WebAdmin with front end shop    
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	 
	public void frontEndStoreValidation() throws ParserConfigurationException, SAXException, IOException 
	{
	Finder locator =new Finder();
	waitForPageLoaded(driver);
	String frontEndImageName= getImageNameFromUrl(driver.findElement(locator.findBy("images_imgBombStoreVaidate")).getAttribute("src"));
	if(mbizImageName.trim().equals(frontEndImageName.trim()))
		report.updateTestLog(
				"Campaign Image Verification",
				"Campaign Image is added to the front end shop",
				Status.PASS);
	else
		report.updateTestLog(
				"Campaign Image Verification",
				"Campaign Image is not added to the front end shop",
				Status.FAIL);			
	}
	
	
	/** This function will create and update customer details in WebAdmin
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	public void updateCustomers() throws InterruptedException, AWTException, ParserConfigurationException, SAXException, IOException 
	{
		
		Finder locator =new Finder();
		fluentwait(locator.findBy("images_imgAjaxLoad"));
		//fluentwait(locator.findBy("images_imgFailedAjaxLoad"));
		
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(locator.findBy("links_lnkCustomer"))).moveToElement(driver.findElement(locator.findBy("links_lnkCustomerSubMenu"))).click().perform();
		waitForPageLoaded(driver);
         
		try
		{
		Actions builder2 = new Actions(driver);
		builder2.moveToElement(driver.findElement(locator.findBy("links_lnkCustomer"))).click().perform();
		waitForPageLoaded(driver);
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		//driver.findElement(locator.findBy("links_lnkEditCustomer")).click();
		 utils.verifyAndClickLink("links_lnkEditCustomer","Edit Customer");
		waitForPageLoaded(driver);
		//driver.findElement(locator.findBy("links_lnkCustomerSpecific")).click();
		 utils.verifyAndClickLink("links_lnkCustomerSpecific","CustomerSpecific");
		waitForPageLoaded(driver);
	
		try
		{
		driver.findElement(locator.findBy("checkboxes_chkDescriptionselected1"));
		}
		catch(Exception e)
		{
			//driver.findElement(locator.findBy("checkboxes_chkDescription1")).click();
			utils.verifyAndCheckCheckbox("checkboxes_chkDescription1","Description");
		}
		driver.findElement(locator.findBy("textboxes_txtField1Descrption")).clear();
		//driver.findElement(locator.findBy("textboxes_txtField1Descrption")).sendKeys(dataTable.getData("General_data","Description1"));
		 utils.verifyAndEnterValueInTextBox("textboxes_txtField1Descrption",dataTable.getData("General_data","Description1"),"Description"); 
		
		try
		{
		driver.findElement(locator.findBy("checkboxes_chkDescriptionselected2"));
		}
    	catch(Exception e)
		{
    	//driver.findElement(locator.findBy("checkboxes_chkDescription2")).click();
    	utils.verifyAndCheckCheckbox("checkboxes_chkDescription2","Description");
		}
		driver.findElement(locator.findBy("textboxes_txtField2Description")).clear();
		//driver.findElement(locator.findBy("textboxes_txtField2Description")).sendKeys(dataTable.getData("General_data","Description2"));
		 utils.verifyAndEnterValueInTextBox("textboxes_txtField2Description",dataTable.getData("General_data","Description2"),"Description"); 
		//driver.findElement(locator.findBy("buttons_btnSaveChanges")).click();
		 utils.verifyAndClickButton("buttons_btnSaveChanges","Save");
		waitForPageLoaded(driver);
		//driver.findElement(locator.findBy("buttons_btnEditCustomer")).click();
		utils.verifyAndClickButton("buttons_btnEditCustomer","Edit Customer");
		waitForPageLoaded(driver);
		//driver.findElement(locator.findBy("links_lnkCustomerSpecific")).click();
		utils.verifyAndClickLink("links_lnkCustomerSpecific","Customer Specific");
		
		waitForPageLoaded(driver);
	    boolean descriptionCheck1 =	driver.findElement(locator.findBy("textboxes_txtField1Descrption")).getAttribute("value").equals(dataTable.getData("General_data","Description1"));
		boolean chkBox1 = driver.findElement(locator.findBy("checkboxes_chkDescription1")).isSelected();
		boolean descriptionCheck2 =driver.findElement(locator.findBy("textboxes_txtField2Description")).getAttribute("value").equals(dataTable.getData("General_data","Description2"));
		boolean chkBox2	= driver.findElement(locator.findBy("checkboxes_chkDescription2")).isSelected();
		
		if(descriptionCheck1 && chkBox1 && descriptionCheck2 && chkBox2)
			report.updateTestLog(
					"Edit Cutomer Details",
					"Successfully Saved the customer details",
					Status.PASS);
		
		else
			report.updateTestLog(
					"Edit Cutomer Details",
					"Failed in saving customer details  ",
					Status.FAIL);
	}
     
	/** This function will add category to the WebAdmin 
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	public void addingCategories() throws InterruptedException, AWTException, ParserConfigurationException, SAXException, IOException
	{
	
	 Finder locator =new Finder();
      fluentwait(locator.findBy("images_imgAjaxLoad"));
      //fluentwait(locator.findBy("images_imgFailedAjaxLoad"));
      Thread.sleep(10000L);
	  
	  String excelCategory =dataTable.getData("General_data","Category");
      Random randomGenerator = new Random();
      int randomInt = randomGenerator.nextInt(10000);
      category=excelCategory+randomInt;
     
            
      Actions builder1 = new Actions(driver);
      builder1.moveToElement(driver.findElement(locator.findBy("links_lnkAdminMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkAdminSubMenu"))).click().perform();
      waitForPageLoaded(driver);       
             
      try
      {
      Actions builder2 = new Actions(driver);
      builder2.moveToElement(driver.findElement(locator.findBy("links_lnkAdminMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkAdminSubMenu"))).click().perform();;
      waitForPageLoaded(driver);
      }
      catch(Exception e)
      {
      e.printStackTrace();
      }
      //driver.findElement(locator.findBy("buttons_btnLevel3")).click();
      utils.verifyAndClickButton("buttons_btnLevel3","Level3");
	  Thread.sleep(3000);
	  //driver.findElement(locator.findBy("textboxes_txtNewCategory")).sendKeys(category);
	  utils.verifyAndEnterValueInTextBox("textboxes_txtNewCategory",category,"Category"); 
	  WebElement element = driver.findElement(locator.findBy("textboxes_txtSubmitCategory")); 
	  elementClick(element);  
	  Thread.sleep(3000L);
	  boolean successMessage = driver.findElement(locator.findBy("textboxes_txtupdateMessage")).isDisplayed();
	  //driver.findElement(locator.findBy("links_lnkbuttonRelease")).click(); 
	  utils.verifyAndClickLink("links_lnkbuttonRelease","Release");
	  waitForPageLoaded(driver); 
	  fluentwait(locator.findBy("images_imgAjaxLoad"));
	  //fluentwait(locator.findBy("images_imgFailedAjaxLoad"));
	  Thread.sleep(5000L);
	 
	  
	  Actions builder3 = new Actions(driver);
	  builder3.moveToElement(driver.findElement(locator.findBy("links_lnkProductMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkProductCatalog"))).click().perform();
	  waitForPageLoaded(driver);
	 
	  try
	  {
	  Actions builder4 = new Actions(driver);
	  builder4.moveToElement(driver.findElement(locator.findBy("links_lnkProductMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkProductCatalog"))).click().perform();
	  waitForPageLoaded(driver);
	  }
	  
	  catch(Exception e)
	  {
	   e.printStackTrace();  
	  }
	  
	  //driver.findElement(locator.findBy("textboxes_txtProductSearch")).sendKeys(dataTable.getData("General_data","MobileName"));
	  utils.verifyAndEnterValueInTextBox("textboxes_txtProductSearch",dataTable.getData("General_data","MobileName"),"Mobile Name"); 
	  //driver.findElement(locator.findBy("textboxes_txtSearch")).click();
	  utils.verifyAndClickButton("textboxes_txtSearch","Search");
	  
	  //fluentwait(locator.findBy("images_imgIconLoader"));
	  //driver.findElement(locator.findBy("buttons_btnEditMobile")).click();
	  utils.verifyAndClickButton("buttons_btnEditMobile","Edit Mobile");
	  waitForPageLoaded(driver);
	  //driver.findElement(locator.findBy("links_lnkCustomerSpecific")).click();
	  utils.verifyAndClickLink("links_lnkViewCategories","Categoriesr");
	  waitForPageLoaded(driver);
	  Thread.sleep(3000L);
	  utils.verifyAndCheckCheckbox("checkboxes_chkLevel3","Checkbox");
	  //naresh WebElement element2  = driver.findElement(locator.findBy("checkboxes_chkLevel3"));
	  //elementClick(element2); 
	   JavascriptExecutor jsx = (JavascriptExecutor)driver;
	   jsx.executeScript("window.scrollBy(0,450)", "");
	   jsx.executeScript("window.scrollBy(0,450)", "");
	   jsx.executeScript("window.scrollBy(0,450)", "");
	   jsx.executeScript("window.scrollBy(0,450)", "");
	   utils.verifyAndClickButton("buttons_btnSaveChanges","Save");
	  //naresh WebElement element3  = driver.findElement(locator.findBy("buttons_btnSaveChanges"));
	  //elementClick(element3); 
	  waitForPageLoaded(driver);
	  //driver.findElement(locator.findBy("links_lnkbuttonRelease")).click(); 
	  utils.verifyAndClickLink("links_lnkbuttonRelease","Release");
	  waitForPageLoaded(driver); 
	  fluentwait(locator.findBy("images_imgAjaxLoad"));
	  //fluentwait(locator.findBy("images_imgFailedAjaxLoad"));
	  Thread.sleep(5000L);
	  
	  Actions builder5 = new Actions(driver);
	  builder5.moveToElement(driver.findElement(locator.findBy("links_lnkButikkMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkButikkSubMenu"))).click().perform();
	  waitForPageLoaded(driver);
	  
	  
	  try
	   {
	    //driver.findElement(locator.findBy("links_lnkButikkMenu")).click();
		utils.verifyAndClickLink("links_lnkButikkMenu","ButikkMenu");
	   waitForPageLoaded(driver);
	   }
	  
	  catch(Exception e)
	   {
	   e.printStackTrace();
	   }
	  //driver.findElement(locator.findBy("textboxes_txtButtik")).sendKeys(dataTable.getData("General_data","ShopName"));
	  utils.verifyAndEnterValueInTextBox("textboxes_txtButtik", dataTable.getData("General_data","ShopName"), "ShopName");
	  //driver.findElement(locator.findBy("links_lnkSearch")).click();
	  utils.verifyAndClickLink("links_lnkSearch","Search");
	  waitForPageLoaded(driver);
	  //driver.findElement(locator.findBy("links_lnkShopVismer")).click();
	  utils.verifyAndClickLink("links_lnkShopVismer","Vismer");
	   Thread.sleep(3000L);
	   //driver.findElement(locator.findBy("buttons_btnViewCategories")).click();
	   utils.verifyAndClickButton("buttons_btnViewCategories","View Categories");
	   waitForPageLoaded(driver);
	   
	   WebElement element4  = driver.findElement(locator.findBy("links_lnkSelectAllChkBox"));
	   elementClick(element4); 
	   Thread.sleep(2000L);
       
	 
	   jsx.executeScript("window.scrollBy(0,450)", "");
	   
	   WebElement element5  = driver.findElement(locator.findBy("buttons_btnSaveChanges"));
	   elementClick(element5); 
	   waitForPageLoaded(driver);
	   //driver.findElement(locator.findBy("textboxes_txtButtik")).sendKeys(dataTable.getData("General_data","ShopName"));
	   utils.verifyAndEnterValueInTextBox("textboxes_txtButtik", dataTable.getData("General_data","ShopName"), "ShopName");
	   //driver.findElement(locator.findBy("links_lnkSearch")).click();
	   utils.verifyAndClickLink("links_lnkSearch","Search");
	   waitForPageLoaded(driver);
	   //driver.findElement(locator.findBy("links_lnkShopVismer")).click();
	   utils.verifyAndClickLink("links_lnkShopVismer","Vismer");
	   Thread.sleep(3000L);
	   //driver.findElement(locator.findBy("buttons_btnUpdateStore")).click();
	   utils.verifyAndClickButton("buttons_btnUpdateStore","Update Store");
	   waitForPageLoaded(driver);
	   boolean updateStoreSucess = driver.findElement(locator.findBy("textboxes_txtSuccessMessage")).getText().equals("Oppdatering vellykket.");
	   //driver.findElement(locator.findBy("links_lnkbuttonRelease")).click(); 
	   utils.verifyAndClickLink("links_lnkbuttonRelease","Release");
	   waitForPageLoaded(driver); 
	   fluentwait(locator.findBy("images_imgAjaxLoad"));
	   //fluentwait(locator.findBy("images_imgFailedAjaxLoad"));
	   
	   Thread.sleep(5000L);
	   
	   Actions builder6 = new Actions(driver);
	   builder6.moveToElement(driver.findElement(locator.findBy("links_lnkAdminMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkAdminSubMenu2"))).click().perform();
	   waitForPageLoaded(driver);
	 
	   try
	   {
	   Actions builder7 = new Actions(driver);
	   builder7.moveToElement(driver.findElement(locator.findBy("links_lnkAdminMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkAdminSubMenu2"))).click().perform();
	   waitForPageLoaded(driver);
	   }
	   catch(Exception e)
	   {
	   e.printStackTrace();
	   }
	   //driver.findElement(locator.findBy("buttons_btnCompletePush")).click();
	   utils.verifyAndClickButton("buttons_btnTransferProductsOnly","Complete Product Push");
	  waitForPageLoaded(driver);
	 
	  if(successMessage)
	   report.updateTestLog(
					"Adding New Category",
					"Successfully added new category",
					Status.PASS);
	  else
		  report.updateTestLog(
					"Adding New Category",
					"Unable to add new category",
					Status.FAIL);
	  if(updateStoreSucess)
		  report.updateTestLog(
					"Store Update",
					"Successfully Updated Store",
					Status.PASS);
	  
	  else
		  report.updateTestLog(
					"Store Update",
					"Unable to update the store",
					Status.FAIL);
	}
	
	public void frontEndStoreLevelValidation() throws InterruptedException, ParserConfigurationException, SAXException, IOException 
	{
	waitForPageLoaded(driver);
	Finder locator =new Finder();
	boolean categoryStatus = false;
	
	Thread.sleep(20000);
	driver.navigate().refresh();
	
	try
	{ 
		categoryStatus =  driver.findElement(findByDynXpath(locator.findBy("links_lnkLevel3Item"),category)).isDisplayed();
	}
	catch (Exception e){
		
		 driver.navigate().refresh();
		 waitForPageLoaded(driver);
		 categoryStatus =  driver.findElement(findByDynXpath(locator.findBy("links_lnkLevel3Item"),category)).isDisplayed();
		 
	}
	
	if(categoryStatus)
	   {
		String level3Item = driver.findElement(findByDynXpath(locator.findBy("links_lnkLevel3Item"),category)).getText();
		String[] splits = level3Item.split("\\(1\\)");
		
		if(splits[0].equals(category))
	
	    report.updateTestLog("Category Verification","Newly added category appears in front end shop",Status.PASS);
		else
		report.updateTestLog("Category Verification","Newly added category does not appear in front end shop",Status.FAIL);
	   }
	}
			
	
	
  /** This function will update supplier details in WebAdmin
   * 	
   * @throws InterruptedException
 * @throws AWTException 
 * @throws IOException 
 * @throws SAXException 
 * @throws ParserConfigurationException 
   */

	public void updateSupplier() throws InterruptedException, AWTException, ParserConfigurationException, SAXException, IOException
	{

	 Finder locator =new Finder();
	 fluentwait(locator.findBy("images_imgAjaxLoad")); 
	 //fluentwait(locator.findBy("images_imgFailedAjaxLoad")); 
	 String excelName = dataTable.getData("General_data","Name");
	 Date now = new Date();
	 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
     String timestampString = formatter.format(now);
     String name=excelName+timestampString; 
	 
	 Actions builder1 = new Actions(driver);
	 builder1.moveToElement(driver.findElement(locator.findBy("links_lnkSupplierMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkSupplierSubMenu"))).click().perform();
	 waitForPageLoaded(driver);
	 
	 try
	 {
	 Actions builder2 = new Actions(driver);
	 builder2.moveToElement(driver.findElement(locator.findBy("links_lnkSupplierMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkSupplierSubMenu"))).click().perform();
	 waitForPageLoaded(driver);
	 }
	 catch(Exception e)	 
	 {
	 e.printStackTrace();
	 }
	 //driver.findElement(locator.findBy("textboxes_txtName")).sendKeys(name);
	 utils.verifyAndEnterValueInTextBox("textboxes_txtName",name,"Name");
	 //driver.findElement(locator.findBy("textboxes_txtPostCode")).sendKeys(dataTable.getData("General_data","PostNumber"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtPostCode",dataTable.getData("General_data","PostNumber"),"PostNumber");
	 //driver.findElement(locator.findBy("textboxes_txtDescription2")).sendKeys(dataTable.getData("General_data","Description"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtDescription2",dataTable.getData("General_data","Description"),"Description");
	 //driver.findElement(locator.findBy("buttons_btnProceed")).click(); 
	 utils.verifyAndClickButton("buttons_btnProceed","Proceed");
	 waitForPageLoaded(driver);
	 
	 boolean deliverycheckbox =driver.findElement(locator.findBy("checkboxes_chkServicePack")).isSelected(); 
	 if(!deliverycheckbox)
	 {
	  //driver.findElement(locator.findBy("checkboxes_chkServicePack")).click();
	  utils.verifyAndCheckCheckbox("checkboxes_chkServicePack","ServicePack");
	 }
	 driver.findElement(locator.findBy("textboxes_txtDeliveryPrice")).clear();
	 //driver.findElement(locator.findBy("textboxes_txtDeliveryPrice")).sendKeys(dataTable.getData("General_data","DeliveryCost1"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtDeliveryPrice",dataTable.getData("General_data","DeliveryCost1"),"Delivery Price");
	 
	 Thread.sleep(3000L);
	 //driver.findElement(locator.findBy("buttons_btnSaveChanges")).click();
	 utils.verifyAndClickButton("buttons_btnSaveChanges","Save");
	 waitForPageLoaded(driver); 
	 //driver.findElement(locator.findBy("links_lnkPageMenu")).click();
	 //utils.verifyAndClickLink("links_lnkPageMenu","Page Menu");
	 waitForPageLoaded(driver); 
	 Thread.sleep(3000L);
     boolean isSupplierCreated =driver.findElement(locator.findBy("textboxes_txtSupplierName")).getText().equals(name);
	 
	 if(isSupplierCreated)
	  report.updateTestLog(
					"Supplier Creation",
					"Successfully created supplier in mbiz",
					Status.PASS);
		else
			report.updateTestLog(
					"Supplier Creation",
					"Error in creating the supplier for mbiz ",
	  			Status.FAIL);
	
	 JavascriptExecutor jsx = (JavascriptExecutor)driver;
	 jsx.executeScript("window.scrollBy(0,450)", "");
	 //driver.findElement(locator.findBy("buttons_btnEditSupplier")).submit();
	 utils.verifyAndClickButton("buttons_btnEditSupplier","Edit Supplier");
	 waitForPageLoaded(driver); 
	 //driver.findElement(locator.findBy("links_lnkDeliveryMethod")).click();
	 utils.verifyAndClickLink("links_lnkDeliveryMethod","Delivery Method");
	 waitForPageLoaded(driver); 
	 driver.findElement(locator.findBy("textboxes_txtDeliveryPrice")).clear();
	 //driver.findElement(locator.findBy("textboxes_txtDeliveryPrice")).sendKeys(dataTable.getData("General_data","DeliveryCost2"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtDeliveryPrice",dataTable.getData("General_data","DeliveryCost2"),"Delivery Price");
	 //driver.findElement(locator.findBy("buttons_btnSaveChanges")).click()
	 utils.verifyAndClickButton("buttons_btnSaveChanges","Save"); 
	 waitForPageLoaded(driver); 
	 //driver.findElement(locator.findBy("links_lnkPageMenu")).click();
	 //utils.verifyAndClickLink("links_lnkPageMenu","Page Menu");
	 waitForPageLoaded(driver); 
	 String deliveryCost = driver.findElement(locator.findBy("textboxes_txtDeliveryCost")).getText();
	 String output = CharMatcher.is(',').or(CharMatcher.DIGIT).retainFrom(deliveryCost);
	 String[] splits = output.split(",");
			 
		if(splits[0].equals(dataTable.getData("General_data","DeliveryCost2")))
			report.updateTestLog(
					"Delivey Cost Updation",
					"Delivery cost successfully updated for the Supplier",
					Status.PASS);
		else
			report.updateTestLog(
					"Delivey Cost Updation",
					"Delivery cost is not updated for the Supplier",
	  			Status.FAIL);
	}

	/** This function will check for the karantene Orders in Ihelp
	 * 
	 * @throws InterruptedException
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public void karanteneOrders() throws InterruptedException, ParserConfigurationException, SAXException, IOException
	{
		waitForPageLoaded(driver);
		Finder locator =new Finder();
		//driver.findElement(locator.findBy("links_lnkStatus")).click();
		utils.verifyAndClickLink("links_lnkStatus","Status");
		waitForPageLoaded(driver);
		fluentwait(locator.findBy("images_imgAjaxLoader")); 
		boolean karanteneStatus	=false;
		karanteneStatus=driver.findElement(locator.findBy("textboxes_txtKaranteneNumber")).getText().equals("0");
	
		if(karanteneStatus)
        	 report.updateTestLog(
 					"Karantene Orders",
 					"There are no quarantined orders",
 					Status.PASS);
         else
 			report.updateTestLog(
 					"Karantene Orders",
 					"There are quarantined orders",
	  			Status.FAIL);
	}
	
	/** This function will create new Forhandler for WebAdmin
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	public void createNewForhandler() throws InterruptedException, AWTException, ParserConfigurationException, SAXException, IOException 
	{
	 //waitForPageLoaded(driver);
	 //windowMaximize();
	 Finder locator =new Finder(); 
	 fluentwait(locator.findBy("images_imgAjaxLoad"));
	 //fluentwait(locator.findBy("images_imgFailedAjaxLoad"));
	 String excelCompanyName = dataTable.getData("General_data","CompanyName");
	 String excelCompanyMarket=  dataTable.getData("General_data","CompanyMarketName");
	 String excelNavisionId= dataTable.getData("General_data","NavisionCompanyId");
	 Date now = new Date();
     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
     String timestampString = formatter.format(now);
     String companyName=excelCompanyName+timestampString; 
     String companyMarket =excelCompanyMarket+timestampString; 
     Random randomGenerator = new Random();
     int randomInt = randomGenerator.nextInt(10000);
     String NavisionCompanyId=excelNavisionId+randomInt;
     
	 Actions builder1 = new Actions(driver);
	 builder1.moveToElement(driver.findElement(locator.findBy("links_lnkAgentMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkAgentSubMenu"))).click().perform();
	 waitForPageLoaded(driver);
	 try
	 {
	 //driver.findElement(locator.findBy("links_lnkAgentMenu")).click();
	 utils.verifyAndClickLink("links_lnkAgentMenu","Agent Menu");
	 waitForPageLoaded(driver);
	 }
	 catch(Exception e)
	 {
	 e.printStackTrace();
	 }
	 //driver.findElement(locator.findBy("buttons_btnSeeAgent")).click();
	 utils.verifyAndClickButton("buttons_btnSeeAgent","See Agent");
	 waitForPageLoaded(driver);
	 //driver.findElement(locator.findBy("buttons_btnForHandler")).click();
	 utils.verifyAndClickButton("buttons_btnForHandler","ForHandler");
	 waitForPageLoaded(driver);
	 utils.verifyAndClickButton("buttons_btnForhandlerStatus","Forhandler Status");
	 //driver.findElement(locator.findBy("textboxes_txtCompanyName")).sendKeys(companyName);
	 utils.verifyAndEnterValueInTextBox("textboxes_txtCompanyName",companyName,"Company Name");
	 //driver.findElement(locator.findBy("textboxes_txtCompanyMarketName")).sendKeys(companyMarket);
	 utils.verifyAndEnterValueInTextBox("textboxes_txtCompanyMarketName",companyMarket,"Company Market");
	 //driver.findElement(locator.findBy("textboxes_txtOrganizationNumber")).sendKeys(dataTable.getData("General_data","OrganizationNumber"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtOrganizationNumber",dataTable.getData("General_data","OrganizationNumber"),"Organization Number");
	 //driver.findElement(locator.findBy("textboxes_txtAddressLine1")).sendKeys(dataTable.getData("General_data","AddressLine1"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtAddressLine1",dataTable.getData("General_data","AddressLine1"),"AddressLine1");
	 //driver.findElement(locator.findBy("textboxes_txtAddressPostalCodeNumber")).sendKeys(dataTable.getData("General_data","AddressPostalCodeNumber"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtAddressPostalCodeNumber",dataTable.getData("General_data","AddressPostalCodeNumber"),"Postal Code");
	 //driver.findElement(locator.findBy("textboxes_txtAddressPostalCodeName")).sendKeys(dataTable.getData("General_data","AddressPostalCodeName"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtAddressPostalCodeName",dataTable.getData("General_data","AddressPostalCodeName"),"PostalCode Name");
	 //driver.findElement(locator.findBy("textboxes_txtPhoneNumber2")).sendKeys(dataTable.getData("General_data","PhoneNumber2"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtPhoneNumber2",dataTable.getData("General_data","PhoneNumber2"),"Postal Number");
	 //driver.findElement(locator.findBy("textboxes_txtFaxNumber")).sendKeys(dataTable.getData("General_data","FaxNumber"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtFaxNumber",dataTable.getData("General_data","FaxNumber"),"FaxNumber");
	 //driver.findElement(locator.findBy("textboxes_txtMainPhoneNumber")).sendKeys(dataTable.getData("General_data","MainPhoneNumber"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtMainPhoneNumber",dataTable.getData("General_data","MainPhoneNumber"),"MainPhoneNumber");
	 //driver.findElement(locator.findBy("textboxes_txtChiefExecutiveOfficer")).sendKeys(dataTable.getData("General_data","ChiefExecutiveOfficer"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtChiefExecutiveOfficer",dataTable.getData("General_data","ChiefExecutiveOfficer"),"ChiefExecutiveOfficer");
	 //driver.findElement(locator.findBy("textboxes_txtBankAccountNumber")).sendKeys(dataTable.getData("General_data","BankAccountNumber"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtBankAccountNumber",dataTable.getData("General_data","BankAccountNumber"),"BankAccountNumber");
	 //driver.findElement(locator.findBy("buttons_btnProceed")).click();
	 utils.verifyAndClickButton("buttons_btnProceed","Proceed");
	 
	 waitForPageLoaded(driver);
	 
	 //driver.findElement(locator.findBy("textboxes_txtNavisionCompanyId")).sendKeys(NavisionCompanyId);
	 utils.verifyAndEnterValueInTextBox("textboxes_txtNavisionCompanyId",NavisionCompanyId,"NavisionCompanyId");
	 //driver.findElement(locator.findBy("textboxes_txtKhBillingCustomerId")).click();
	 utils.verifyAndClickLink("textboxes_txtKhBillingCustomerId","KhBillingCustomerId");
	  //driver.findElement(locator.findBy("textboxes_txtKhBillingCustomerId")).sendKeys(dataTable.getData("General_data","KhBillingCustomerId"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtKhBillingCustomerId",dataTable.getData("General_data","KhBillingCustomerId"),"KhBillingCustomerId");
	 //driver.findElement(locator.findBy("textboxes_txtCrmId")).sendKeys(dataTable.getData("General_data","CrmId"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtCrmId",dataTable.getData("General_data","CrmId"),"CrmId");
	 //driver.findElement(locator.findBy("textboxes_txtTelecomputingCompanyId")).sendKeys(dataTable.getData("General_data","TelecomputingCompanyId"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtTelecomputingCompanyId",dataTable.getData("General_data","TelecomputingCompanyId"),"TelecomputingCompanyId");
	 //driver.findElement(locator.findBy("textboxes_txtPaymentAccountNumber")).sendKeys(dataTable.getData("General_data","PaymentAccountNumber"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtPaymentAccountNumber",dataTable.getData("General_data","PaymentAccountNumber"),"PaymentAccountNumber");
	 //driver.findElement(locator.findBy("textboxes_txtPaymentEncryptionKey")).sendKeys(dataTable.getData("General_data","PaymentEncryptionKey"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtPaymentEncryptionKey",dataTable.getData("General_data","PaymentEncryptionKey"),"PaymentEncryptionKey");
	 //driver.findElement(locator.findBy("textboxes_txtTelenorNettforhandlerDealerId")).sendKeys(dataTable.getData("General_data","TelenorNettforhandlerDealerId"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtTelenorNettforhandlerDealerId",dataTable.getData("General_data","TelenorNettforhandlerDealerId"),"TelenorNettforhandlerDealerId");
	 //driver.findElement(locator.findBy("textboxes_txtTelenorNettforhandlerDealerIdLocalStore")).sendKeys(dataTable.getData("General_data","TelenorNettforhandlerDealerLocalId"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtTelenorNettforhandlerDealerIdLocalStore",dataTable.getData("General_data","TelenorNettforhandlerDealerLocalId"),"TelenorNettforhandlerDealerLocalId");
	 //driver.findElement(locator.findBy("textboxes_txtCreditScore")).sendKeys(dataTable.getData("General_data","CreditScore"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtCreditScore",dataTable.getData("General_data","CreditScore"),"Credit Score");
	 //driver.findElement(locator.findBy("textboxes_txtTurnover")).sendKeys(dataTable.getData("General_data","Turnover"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtTurnover",dataTable.getData("General_data","Turnover"),"Turnover");
	 //driver.findElement(locator.findBy("textboxes_txtProfitBeforeTax")).sendKeys(dataTable.getData("General_data","ProfitBeforeTax"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtProfitBeforeTax",dataTable.getData("General_data","ProfitBeforeTax"),"ProfitBeforeTax");
	 //driver.findElement(locator.findBy("textboxes_txtLiquidityRatio")).sendKeys(dataTable.getData("General_data","LiquidityRatio"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtLiquidityRatio",dataTable.getData("General_data","LiquidityRatio"),"LiquidityRatio");
	 //driver.findElement(locator.findBy("textboxes_txtEquity")).sendKeys(dataTable.getData("General_data","Equity"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtEquity",dataTable.getData("General_data","Equity"),"Equity");
	 //driver.findElement(locator.findBy("textboxes_txtResultRatio")).sendKeys(dataTable.getData("General_data","ResultRatio"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtResultRatio",dataTable.getData("General_data","ResultRatio"),"ResultRatio");
	 //driver.findElement(locator.findBy("textboxes_txtCreditCheckPerformedBy")).sendKeys(dataTable.getData("General_data","CreditCheckPerformedBy"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtCreditCheckPerformedBy",dataTable.getData("General_data","CreditCheckPerformedBy"),"CreditCheckPerformedBy");
	 //driver.findElement(locator.findBy("textboxes_txtCreditLimitLimit")).sendKeys(dataTable.getData("General_data","CreditLimitLimit"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtCreditLimitLimit",dataTable.getData("General_data","CreditLimitLimit"),"CreditLimitLimit");
	
	 Select dropdown1 = new Select(driver.findElement(By.id("InvoiceDays")));
	 dropdown1.selectByIndex(2);
	
	 for(int i=0;i<3;i++)
	 {
	 Thread.sleep(3000L); 
	 //driver.findElement(locator.findBy("buttons_btnProceed")).click(); 
	 utils.verifyAndClickButton("buttons_btnProceed","Proceed");
	 waitForPageLoaded(driver);
	 }
	 
	 /*driver.findElement(locator.findBy("textboxes_txtCompanyMarketName")).sendKeys(companyMarket);
	 driver.findElement(locator.findBy("textboxes_txtShopAddressLine1")).sendKeys(dataTable.getData("General_data","ShopAddressLine1"));
	 driver.findElement(locator.findBy("textboxes_txtShopAddressPostalCodeNumber")).sendKeys(dataTable.getData("General_data","ShopAddressPostalCodeNumber"));
	 driver.findElement(locator.findBy("textboxes_txtShopAddressPostalCodeName")).sendKeys(dataTable.getData("General_data","ShopAddressPostalCodeName"));
	 driver.findElement(locator.findBy("textboxes_txtGeoLocation")).sendKeys(dataTable.getData("General_data","GeoLocation"));
	 driver.findElement(locator.findBy("textboxes_txtAbout")).sendKeys(dataTable.getData("General_data","About"));
	 driver.findElement(locator.findBy("buttons_btnSaveChanges")).click();*/
	 
	 utils.verifyAndEnterValueInTextBox("textboxes_txtCompanyMarketName",companyMarket,"company Market");
	 utils.verifyAndEnterValueInTextBox("textboxes_txtShopAddressLine1",dataTable.getData("General_data","ShopAddressLine1"),"ShopAddressLine");
	 utils.verifyAndEnterValueInTextBox("textboxes_txtShopAddressPostalCodeNumber",dataTable.getData("General_data","ShopAddressPostalCodeNumber"),"ShopAddressPostalCode");
	 utils.verifyAndEnterValueInTextBox("textboxes_txtShopAddressPostalCodeName",dataTable.getData("General_data","ShopAddressPostalCodeName"),"ShopAddressPostalCodeName");
	 utils.verifyAndEnterValueInTextBox("textboxes_txtGeoLocation",dataTable.getData("General_data","GeoLocation"),"GeoLocation");
	 utils.verifyAndEnterValueInTextBox("textboxes_txtAbout",dataTable.getData("General_data","About"),"About");
	 utils.verifyAndClickButton("buttons_btnSaveChanges","Save");
	 
	 waitForPageLoaded(driver);
	 //driver.findElement(locator.findBy("links_lnkAgent")).click(); 
	 utils.verifyAndClickLink("links_lnkAgent","Agent");
	 waitForPageLoaded(driver);
	 //driver.findElement(locator.findBy("buttons_btnSeeAgent")).click(); 
	 utils.verifyAndClickButton("buttons_btnSeeAgent","See Agent");
	 waitForPageLoaded(driver);
	 boolean forhandlerStatus = driver.findElement(locator.findBy("textboxes_txtDistributor")).getText().equals(companyName); 
	
	 if(forhandlerStatus)
		 report.updateTestLog(
					"Distrubutor Creation",
					"New distributor is created for the corresponding Agent successfully",
					Status.PASS);
      else
			report.updateTestLog(
					"Distrubutor Creation",
					"New distributor is not created for the corresponding agent",
	  			Status.FAIL);
	}
	
	
	/** This function will create new Forhandler for WebAdmin
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	public void quickCreateWebshop() throws InterruptedException, AWTException, ParserConfigurationException, SAXException, IOException 
	{
	 //waitForPageLoaded(driver);
	 //windowMaximize();
	 Finder locator =new Finder(); 	   
	 Actions builder1 = new Actions(driver);
	 builder1.moveToElement(driver.findElement(locator.findBy("links_lnkButikkMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkButikkSubMenu2"))).click().perform();
	 waitForPageLoaded(driver);
	 try
	 {
	 //driver.findElement(locator.findBy("links_lnkAgentMenu")).click();
	 utils.verifyAndClickLink("links_lnkButikkMenu","Buttik Menu");
	 waitForPageLoaded(driver);
	 }
	 catch(Exception e)
	 {
	 e.printStackTrace();
	 }
	 Select dropdown1 = new Select(driver.findElement(By.id("AxDistributors")));
	 dropdown1.selectByVisibleText(dataTable.getData("General_data","ChooseReseller"));
	 
	 utils.verifyAndClickButton("buttons_btnFetchUsers","FetchUsers");
	 
	 Thread.sleep(15000L);
	 
	 Select dropdown2 = new Select(driver.findElement(By.id("ownerUsername")));
	 dropdown2.selectByVisibleText(dataTable.getData("General_data","Shopkeeper"));
	 
	 Select dropdown3 = new Select(driver.findElement(By.id("responsibleUsername")));
	 dropdown3.selectByVisibleText(dataTable.getData("General_data","StoreManager"));
	 
	 utils.verifyAndEnterValueInTextBox("textboxes_txtCustomerOrgnumber",dataTable.getData("General_data","CustomerOrgnumber"),"CustomerOrgnumber");
     
	 utils.verifyAndClickButton("buttons_btnCreater","btnCreate");
	 
	 Thread.sleep(15000L);
	 		
	 boolean shopStatus = driver.findElement(locator.findBy("textboxes_txtWordDisplay2")).getText().equals(dataTable.getData("General_data","WordDisplay")); 
	
	 if(shopStatus)
		 report.updateTestLog(
					"Quick Create AX B2B Shop Creation",
					"New Shop is created successfully using Quick Create AX B2B Shop",
					Status.PASS);
      else
			report.updateTestLog(
					"Quick Create AX B2B Shop Creation",
					"New Shop is not created successfull using Quick Create AX B2B Shop ",
	  			Status.FAIL);
	 
	 	 
	}
	
	/** This function will update the product catalog available in WebAdmin 
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	public void updateProductCatalog() throws InterruptedException, AWTException, ParserConfigurationException, SAXException, IOException 
	{
	 
	 Finder locator =new Finder();
	 fluentwait(locator.findBy("images_imgAjaxLoad")); 
	 //fluentwait(locator.findBy("images_imgFailedAjaxLoad")); 	
	 
	 Actions builder1 = new Actions(driver);
	 builder1.moveToElement(driver.findElement(locator.findBy("links_lnkProductMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkProductCatalog"))).click().perform();
	 waitForPageLoaded(driver);
	 try
	 {
	 Actions builder2 = new Actions(driver);
	 builder2.moveToElement(driver.findElement(locator.findBy("links_lnkProductMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkProductCatalog"))).click().perform();
	 waitForPageLoaded(driver);
	 }
	 catch(Exception e)
	 {
	 e.printStackTrace();
	 }
	 fluentwait(locator.findBy("images_imgIconLoader")); 	
	 //driver.findElement(locator.findBy("buttons_btnEditProduct")).click();
	 utils.verifyAndClickButton("buttons_btnEditProduct","Edit Product");
	 waitForPageLoaded(driver);
	 driver.findElement(locator.findBy("textboxes_txtProducerProductId")).clear();
	 driver.findElement(locator.findBy("textboxes_txtProducerURL")).clear();
	 //driver.findElement(locator.findBy("textboxes_txtProducerProductId")).sendKeys(dataTable.getData("General_data","ProducerProductId"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtProducerProductId",dataTable.getData("General_data","ProducerProductId"),"ProducerProductId");
	 //driver.findElement(locator.findBy("textboxes_txtProducerURL")).sendKeys(dataTable.getData("General_data","ProducerURL"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtProducerURL",dataTable.getData("General_data","ProducerURL"),"ProducerURL");
	 JavascriptExecutor jsx = (JavascriptExecutor)driver;
	
	 for(int var1=0;var1<3;var1++)
	 {
	 jsx.executeScript("window.scrollBy(0,450)", "");	 
	 //driver.findElement(locator.findBy("buttons_btnProceed")).click(); 
	 utils.verifyAndClickButton("buttons_btnProceed","Proceed");
	 waitForPageLoaded(driver);
	 }
	 driver.findElement(locator.findBy("textboxes_txtProductTitle")).clear();
	 driver.findElement(locator.findBy("textboxes_txtUniqueSelling")).clear();
	 driver.findElement(locator.findBy("textboxes_txtFactText")).clear();
	 /*driver.findElement(locator.findBy("textboxes_txtProductTitle")).sendKeys(dataTable.getData("General_data","ProductTitle"));
	 driver.findElement(locator.findBy("textboxes_txtUniqueSelling")).sendKeys(dataTable.getData("General_data","UniqueSellingPoint"));
	 driver.findElement(locator.findBy("textboxes_txtFactText")).sendKeys(dataTable.getData("General_data","FactText"));*/
	 
	 Date now = new Date();
	 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	 String timestampString = formatter.format(now);
	 String UniqueSellingPoint = dataTable.getData("General_data","UniqueSellingPoint")+timestampString;
	 utils.verifyAndEnterValueInTextBox("textboxes_txtProductTitle",dataTable.getData("General_data","ProductTitle"),"ProductTitle");
	 utils.verifyAndEnterValueInTextBox("textboxes_txtUniqueSelling",UniqueSellingPoint,"UniqueSellingPoint");
	 utils.verifyAndEnterValueInTextBox("textboxes_txtFactText",dataTable.getData("General_data","FactText"),"FactText");
	 
	 for(int var2=0;var2<3;var2++)
	 {
		 jsx.executeScript("window.scrollBy(0,450)", "");	 
		 utils.verifyAndClickButton("buttons_btnProceed","Proceed");
		 waitForPageLoaded(driver);
	 }
	 
	 //driver.findElement(locator.findBy("checkboxes_chkVoice")).click(); 
	 utils.verifyAndCheckCheckbox("checkboxes_chkVoice", "Voice"); 
	
	 utils.verifyAndCheckCheckbox("checkboxes_chkIPhoneVoice", "IPhoneVoice"); 
	 utils.verifyAndCheckCheckbox("checkboxes_chkAvailableSubscriptions", "Subscription Type"); 
	 //driver.findElement(locator.findBy("buttons_btnProceed")).click();
	 utils.verifyAndClickButton("buttons_btnProceed","Proceed");
	 waitForPageLoaded(driver);
	 //driver.findElement(locator.findBy("buttons_btnSaveChanges")).click(); 
	 utils.verifyAndClickButton("buttons_btnSaveChanges","Save");
	 waitForPageLoaded(driver);
	 //driver.findElement(locator.findBy("links_lnkProductCat")).click();
	 utils.verifyAndClickLink("links_lnkProductCat","Product Catalog");
	 waitForPageLoaded(driver);
	 fluentwait(locator.findBy("images_imgIconLoader")); 	 
	 //driver.findElement(locator.findBy("buttons_btnEditProduct")).click();
	 utils.verifyAndClickButton("buttons_btnEditProduct","Edit Product");
	 waitForPageLoaded(driver);
	 boolean producerProductId = driver.findElement(locator.findBy("textboxes_txtProducerProductId")).getAttribute("value").equals(dataTable.getData("General_data","ProducerProductId"));
     boolean producerURL = driver.findElement(locator.findBy("textboxes_txtProducerURL")).getAttribute("value").equals(dataTable.getData("General_data","ProducerURL"));;
     //driver.findElement(locator.findBy("links_lnkProdukttekster")).click();
     utils.verifyAndClickLink("links_lnkProdukttekster","Produkttekster");
	 waitForPageLoaded(driver);
	 boolean  productTitle = driver.findElement(locator.findBy("textboxes_txtProductTitle")).getAttribute("value").equals(dataTable.getData("General_data","ProductTitle"));
	 boolean  uniqueSelling = driver.findElement(locator.findBy("textboxes_txtUniqueSelling")).getAttribute("value").equals(UniqueSellingPoint);
	 boolean  factText = driver.findElement(locator.findBy("textboxes_txtFactText")).getAttribute("value").equals(dataTable.getData("General_data","FactText"));;
	 //driver.findElement(locator.findBy("links_lnkAbonnementstyper")).click();
	 utils.verifyAndClickLink("links_lnkAbonnementstyper","Abonnementstyper");
	 waitForPageLoaded(driver);
	 boolean chkStatus1 = driver.findElement(locator.findBy("checkboxes_chkVoice")).isSelected();
	 boolean chkStatus2 = driver.findElement(locator.findBy("checkboxes_chkIPhoneVoice")).isSelected();
	  
	 if(producerProductId && producerURL && productTitle && uniqueSelling && factText && chkStatus1 && chkStatus2)
		 report.updateTestLog(
					"Product Catalog Edit",
					"Products in product catalog are successfully edited",
					Status.PASS);
      else
			report.updateTestLog(
					"Product Catalog Edit",
					"Products in product catalog are not successfully edited",
	  			Status.FAIL);
	}
	
	/** This function will create new Utvalg for WebAdmin
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	public void newUtvalgCreation() throws InterruptedException, AWTException, ParserConfigurationException, SAXException, IOException {

		Finder locator =new Finder();
		fluentwait(locator.findBy("images_imgAjaxLoad"));
		//fluentwait(locator.findBy("images_imgFailedAjaxLoad"));
		String excelTitle = dataTable.getData("General_data", "Title");
		String excelNewTitle = dataTable.getData("General_data", "NewTitle");
		Date now = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String timestampString = formatter.format(now);
		String title = excelTitle + timestampString;
		String newTitle = excelNewTitle + timestampString;
		
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(driver.findElement(locator.findBy("links_lnkUtvalgMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkUtvalgSubMenu1"))).click().perform();
		waitForPageLoaded(driver);
		
		
		
		try
		{
		//driver.findElement(locator.findBy("links_lnkUtvalgMenu")).click();
		utils.verifyAndClickLink("links_lnkUtvalgMenu","UtvalgMenu");
		waitForPageLoaded(driver);
		}
        catch(Exception e)
        {
       	e.printStackTrace();
        }
		
		/* Start Utvalg Wizard - Edit Utvalg */

		//driver.findElement(locator.findBy("buttons_btnEditUtvalg")).click();
		 utils.verifyAndClickButton("buttons_btnEditUtvalg","Edit Utvalg");
		waitForPageLoaded(driver);
		driver.findElement(locator.findBy("textboxes_txtName3")).clear();
		driver.findElement(locator.findBy("textboxes_txtDescription1")).clear();
		//driver.findElement(locator.findBy("textboxes_txtName3")).sendKeys(title);
		utils.verifyAndEnterValueInTextBox("textboxes_txtName3", title, "Name");
		//driver.findElement(locator.findBy("textboxes_txtDescription1")).sendKeys(dataTable.getData("General_data", "Description"));
		utils.verifyAndEnterValueInTextBox("textboxes_txtDescription1", dataTable.getData("General_data", "Description"), "Description");
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,200)", "");
		//driver.findElement(locator.findBy("buttons_btnSaveChanges")).click();
		utils.verifyAndClickButton("buttons_btnSaveChanges","Save");
    	waitForPageLoaded(driver);

		/* End Utvalg Wizard - Edit Utvalg */
    	//driver.findElement(locator.findBy("links_lnkUtvalg")).click();
    	utils.verifyAndClickLink("links_lnkUtvalg","Utvalg");
		waitForPageLoaded(driver);
		//driver.findElement(locator.findBy("buttons_btnEditUtvalg")).click();
		utils.verifyAndClickButton("buttons_btnEditUtvalg","Edit Utvalg");
		waitForPageLoaded(driver);
		boolean name = driver.findElement(locator.findBy("textboxes_txtName3")).getAttribute("value").equals(title);
		boolean description = driver.findElement(locator.findBy("textboxes_txtDescription1")).getAttribute("value").equals(dataTable.getData("General_data", "Description"));
		jsx.executeScript("window.scrollBy(0,350)", "");
		//driver.findElement(locator.findBy("buttons_btnSaveChanges")).click();
		utils.verifyAndClickButton("buttons_btnSaveChanges","Save");
		waitForPageLoaded(driver);

		/* Start Utvalg Wizard - Create Utvalg */
		//driver.findElement(locator.findBy("links_lnkUtvalg")).click();
		utils.verifyAndClickLink("links_lnkUtvalg","Utvalg");
		waitForPageLoaded(driver);
		//driver.findElement(locator.findBy("links_lnkCreateNewUtvalg")).click();
		utils.verifyAndClickLink("links_lnkCreateNewUtvalg","New Utvalg");
		waitForPageLoaded(driver);
		//driver.findElement(locator.findBy("textboxes_txtName3")).sendKeys(newTitle);
		utils.verifyAndEnterValueInTextBox("textboxes_txtName3", newTitle, "Name");
		//driver.findElement(locator.findBy("textboxes_txtDescription1")).sendKeys(dataTable.getData("General_data", "Description"));
		utils.verifyAndEnterValueInTextBox("textboxes_txtDescription1", dataTable.getData("General_data", "Description"), "Description");

		for (int var1 = 0; var1 < 2; var1++)
		{
		//driver.findElement(locator.findBy("buttons_btnProceed2")).click();
		utils.verifyAndClickButton("buttons_btnProceed2","Proceed");	
		waitForPageLoaded(driver);
		}
		Select dropdown1 = new Select(driver.findElement(By.id("productTypeId")));
		dropdown1.selectByVisibleText("Nettbrett");
		//driver.findElement(locator.findBy("buttons_btnUtvalgSearch")).click();
		utils.verifyAndClickButton("buttons_btnUtvalgSearch","Utvalg Search");	
		Thread.sleep(15000L);
		Thread.sleep(20000L);
		jsx.executeScript("window.scrollBy(0,150)", "");
		WebElement sourceElement = driver.findElement(locator.findBy("images_imgSourceUtvalImage"));
		WebElement targetElement = driver.findElement(locator.findBy("textboxes_txtTargetElement"));
		dragandDropFiles(sourceElement, targetElement);
		//driver.findElement(locator.findBy("buttons_btnProceed")).click();
		utils.verifyAndClickButton("buttons_btnProceed","Proceed");	

    	waitForPageLoaded(driver);
    	//driver.findElement(locator.findBy("buttons_btnSaveChanges")).click();
    	utils.verifyAndClickButton("buttons_btnSaveChanges","Save");	
		waitForPageLoaded(driver);

		/* End Utvalg Wizard - Create Utvalg */
		//driver.findElement(locator.findBy("links_lnkUtvalg")).click();
		utils.verifyAndClickLink("links_lnkUtvalg","Utvalg");	
		waitForPageLoaded(driver);
		//driver.findElement(locator.findBy("textboxes_txtButtik")).sendKeys(newTitle);
		utils.verifyAndEnterValueInTextBox("textboxes_txtButtik", newTitle, "Butikk");
		//driver.findElement(locator.findBy("links_lnkSearch")).click();
		utils.verifyAndClickLink("links_lnkSearch","Search");	
		waitForPageLoaded(driver);
		boolean utvalgStatus = driver.findElement(locator.findBy("textboxes_txtUtvalgTitle")).getText().equals(newTitle);

		if (name && description)
		report.updateTestLog("Utvalg Updation","Successfully Updated 'Utvalg' in mBiz",Status.PASS);

		else
		report.updateTestLog("Utvalg Updation","Not Updated 'Utvalg' in mBiz",Status.FAIL);

		if (utvalgStatus)
		report.updateTestLog("New Utvalg Creation","Successfully created a new 'Utvalg' in mBiz",Status.PASS);

		else
		report.updateTestLog("New Utvalg Creation","A new Utvalg is not creted in mBiz",Status.FAIL);

	}


   /* public void newSubscriptionCreation() 
	{
	 waitForPageLoaded(driver);
                Actions builder1 = new Actions(driver);
             builder1.moveToElement(driver.findElement(TelenorMobileWithoutSubscription.lnkUtvalgMenu)).moveToElement(driver.findElement(TelenorMobileWithoutSubscription.lnkUtvalgSubMenu)).click().perform();
	 waitForPageLoaded(driver);
driver.findElement(TelenorMobileWithoutSubscription.lnkUtvalgMenu).click();
waitForPageLoaded(driver);
driver.findElement(TelenorMobileWithoutSubscription.btnProceed).click(); 
 waitForPageLoaded(driver);
driver.findElement(TelenorMobileWithoutSubscription.).sendKeys(); 		 
driver.findElement(TelenorMobileWithoutSubscription.).sendKeys();  
driver.findElement(TelenorMobileWithoutSubscription.).sendKeys();  
driver.findElement(TelenorMobileWithoutSubscription.).sendKeys(); 
driver.findElement(TelenorMobileWithoutSubscription.btnProceed).click(); 
 waitForPageLoaded(driver);

driver.findElement(TelenorMobileWithoutSubscription.).sendKeys(); 		 
driver.findElement(TelenorMobileWithoutSubscription.).sendKeys();  
driver.findElement(TelenorMobileWithoutSubscription.).sendKeys();  
driver.findElement(TelenorMobileWithoutSubscription.).sendKeys(); 

driver.findElement(TelenorMobileWithoutSubscription.btnSaveChanges).click(); 
		 waitForPageLoaded(driver); 


driver.findElement(TelenorMobileWithoutSubscription.).click(); 
waitForPageLoaded(driver); 
driver.findElement(TelenorMobileWithoutSubscription.).click(); 
waitForPageLoaded(driver); 

driver.findElement(TelenorMobileWithoutSubscription.btnProceed).click(); 
 waitForPageLoaded(driver);

boolean =driver.findElement(TelenorMobileWithoutSubscription.).getAttribute("value").equals(dataTable.getData("General_data","Description"));	 
boolean =driver.findElement(TelenorMobileWithoutSubscription.).getAttribute("value").equals(dataTable.getData("General_data","Description"));
boolean =driver.findElement(TelenorMobileWithoutSubscription.).getAttribute("value").equals(dataTable.getData("General_data","Description"));
boolean =driver.findElement(TelenorMobileWithoutSubscription.).getAttribute("value").equals(dataTable.getData("General_data","Description")); 


driver.findElement(TelenorMobileWithoutSubscription.btnProceed).click(); 
 waitForPageLoaded(driver);

boolean =driver.findElement(TelenorMobileWithoutSubscription.).getAttribute("value").equals(dataTable.getData("General_data","Description"));	 
boolean =driver.findElement(TelenorMobileWithoutSubscription.).getAttribute("value").equals(dataTable.getData("General_data","Description"));
boolean =driver.findElement(TelenorMobileWithoutSubscription.).getAttribute("value").equals(dataTable.getData("General_data","Description"));
boolean =driver.findElement(TelenorMobileWithoutSubscription.).getAttribute("value").equals(dataTable.getData("General_data","Description")); 


                Actions builder2 = new Actions(driver);
             builder2.moveToElement(driver.findElement(TelenorMobileWithoutSubscription.lnkUtvalgMenu)).moveToElement(driver.findElement(TelenorMobileWithoutSubscription.lnkUtvalgSubMenu)).click().perform();
	 waitForPageLoaded(driver);

driver.findElement(TelenorMobileWithoutSubscription.btnProceed).click(); 
 waitForPageLoaded(driver);

driver.findElement(TelenorMobileWithoutSubscription.).sendKeys(); 		 
driver.findElement(TelenorMobileWithoutSubscription.).sendKeys();  
driver.findElement(TelenorMobileWithoutSubscription.).sendKeys();  
driver.findElement(TelenorMobileWithoutSubscription.).sendKeys(); 
driver.findElement(TelenorMobileWithoutSubscription.btnProceed).click(); 
 waitForPageLoaded(driver);
}*/

	/**This function will create new store for WebAdmin
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	public void createNewStore() throws InterruptedException, AWTException, ParserConfigurationException, SAXException, IOException 
	{
	
	Finder locator =new Finder();
	 fluentwait(locator.findBy("images_imgAjaxLoad"));
	 //fluentwait(locator.findBy("images_imgFailedAjaxLoad"));
	 String excelName=dataTable.getData("General_data","Name");
	 Date now = new Date();
     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
     String timestampString = formatter.format(now);
	 String storeName=excelName+timestampString;
	 
	 Actions builder1 = new Actions(driver);
	 builder1.moveToElement(driver.findElement(locator.findBy("links_lnkForHandlerMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkForHandlerSubMenu"))).click().perform();
	 waitForPageLoaded(driver);
	 
	 try
	 {
	 Actions builder2 = new Actions(driver);
	 builder2.moveToElement(driver.findElement(locator.findBy("links_lnkForHandlerMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkForHandlerSubMenu"))).click().perform();
	 waitForPageLoaded(driver);
	 }
	 catch(Exception e)
	 {
	 e.printStackTrace(); 
	 }
	 utils.verifyAndEnterValueInTextBox("textboxes_txtButtik", dataTable.getData("General_data","SearchInput"), "Search");
	 utils.verifyAndClickLink("links_lnkSearch","Search");	
	 waitForPageLoaded(driver);
	 utils.verifyAndClickButton("buttons_btnSeeForHandler","Forhandler");	
	 waitForPageLoaded(driver);
	 utils.verifyAndClickButton("buttons_btnCreateStore","Create Store");
	 waitForPageLoaded(driver);
	 utils.verifyAndClickLink("links_lnkStoreStep1","StoreStep1");	
	 waitForPageLoaded(driver);
	 utils.verifyAndClickLink("links_lnkFindCustomer","CustomerSearch");	
	 fluentwait(locator.findBy("images_imgJqueryLoad"));
	 String parentWindow =driver.getWindowHandle();
	 switchtoNewWindow(parentWindow);
	 utils.verifyAndEnterValueInTextBox("textboxes_txtOrganizationNo", dataTable.getData("General_data","OrganizationNumber"), "Organization Number");
	 utils.verifyAndClickButton("buttons_btnPopUpWindowSearch","PopUpWindow");
	 fluentwait(locator.findBy("images_imgJqueryLoad"));
	 utils.verifyAndClickButton("buttons_btnOk","Ok");
	 fluentwait(locator.findBy("images_imgJqueryLoad"));
     switchBacktoOldWindow(parentWindow);
     
     utils.verifyAndClickButton("buttons_btnProceed","Proceed");
	 waitForPageLoaded(driver);
	 utils.verifyAndEnterValueInTextBox("textboxes_txtAgentName",storeName, "Agent Name");
	 utils.verifyAndCheckCheckbox("checkboxes_chkStoreStatus","StoreStatus");
	 
	 utils.verifyAndEnterValueInTextBox("textboxes_txtShopNavisionId",dataTable.getData("General_data","ShopNavisionId"), "Shop NavisionId");
	 utils.verifyAndEnterValueInTextBox("textboxes_txtShopAXId",dataTable.getData("General_data","ShopAXId"), "Shop AXId");
	 Select select = new Select(driver.findElement(By.id("StoreOption")));
	 select.selectByIndex(3);
	 utils.verifyAndEnterValueInTextBox("textboxes_txtServiceUrl", dataTable.getData("General_data","ServiceUrl"), "ServiceUrl");
	 
	 Select select1 = new Select(driver.findElement(By.id("StoreInvoiceInformationInvoiceInvoiceDays")));
	 select1.selectByIndex(2);
	 utils.verifyAndEnterValueInTextBox("textboxes_txtInvoiceHeader", dataTable.getData("General_data","InvoiceHeader"), "InvoiceHeader");
	 utils.verifyAndEnterValueInTextBox("textboxes_txtInvoiceText", dataTable.getData("General_data","InvoiceText"), "Invoice Text");
	 utils.verifyAndClickButton("buttons_btnProceed","Proceed");
	 waitForPageLoaded(driver);
	 
	 utils.verifyAndCheckCheckbox("checkboxes_chkAllFakturaadresserERP","Allow Faktura address");
	/* WebElement sourceElement  = driver.findElement(locator.findBy("textboxes_txtSourceElement2"));
	 WebElement targetElement=driver.findElement(locator.findBy("textboxes_txtTargetElement2"));
	 dragandDropFiles(sourceElement,targetElement);*/
	 utils.verifyAndClickButton("buttons_btnProceed2","Proceed");
	 waitForPageLoaded(driver);

	 utils.verifyAndCheckCheckbox("checkboxes_chkAllLeveringsadresserERP","Allow Leverings address");
	 Thread.sleep(500L);
	/* WebElement sourceElement2  = driver.findElement(locator.findBy("textboxes_txtSourceElementLeveringsadresser"));
	 WebElement targetElement2=driver.findElement(locator.findBy("textboxes_txtTargetElement2"));
	 dragandDropFiles(sourceElement2,targetElement2);*/
	 JavascriptExecutor jsx1 = (JavascriptExecutor)driver;
	 jsx1.executeScript("window.scrollBy(0,100)", "");
	 Thread.sleep(500L);
	 utils.verifyAndClickButton("buttons_btnProceed2","Proceed");
	 waitForPageLoaded(driver);
	 
	 WebElement sourceElement3  = driver.findElement(locator.findBy("textboxes_txtSourceElement2"));
	 WebElement targetElement3=driver.findElement(locator.findBy("textboxes_txtTargetElement2"));
	 dragandDropFiles(sourceElement3,targetElement3);
	 utils.verifyAndClickButton("buttons_btnProceed","Proceed");
	 waitForPageLoaded(driver);

	 utils.verifyAndCheckCheckbox("checkboxes_chkItemSelector","ItemSelector");
	 //driver.findElement(locator.findBy("textboxes_txtPriceValue")).sendKeys(dataTable.getData("General_data","PriceValue"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtPriceValue", dataTable.getData("General_data","PriceValue"), "PriceValue");
	 for(int var=0;var<=1;var++)
	 {
	 //driver.findElement(locator.findBy("buttons_btnProceed")).click();
	 utils.verifyAndClickButton("buttons_btnProceed2","Proceed");
	 waitForPageLoaded(driver);
	 }
	 Select select2 = new Select(driver.findElement(By.id("StoreOwner_PersonId")));
	 select2.selectByIndex(1);
	 Select select3 = new Select(driver.findElement(By.id("StoreResponsible_PersonId")));
	 select3.selectByIndex(1);
	 Select select4 = new Select(driver.findElement(By.id("AskYourSalesManResponsible_PersonId")));
	 select4.selectByIndex(1);
	 
	 JavascriptExecutor jsx = (JavascriptExecutor)driver;
	 jsx.executeScript("window.scrollBy(0,450)", "");
	 //driver.findElement(locator.findBy("buttons_btnSaveChanges")).click(); 
	 utils.verifyAndClickButton("buttons_btnSaveChanges","Save");
	 waitForPageLoaded(driver); 
	 //driver.findElement(locator.findBy("links_lnkStoreStep3")).click(); 
	 utils.verifyAndClickLink("links_lnkStoreStep3","StoreStep3");
	 waitForPageLoaded(driver); 
	 WebElement sourceElement4  = driver.findElement(locator.findBy("textboxes_txtSourceElement3"));
	 WebElement targetElement4  = driver.findElement(locator.findBy("textboxes_txtTargetElement3"));
	 dragandDropFiles(sourceElement4,targetElement4);
	 //driver.findElement(locator.findBy("buttons_btnProceed")).click();
	 utils.verifyAndClickButton("buttons_btnProceed","Proceed");
	 waitForPageLoaded(driver);
	 jsx.executeScript("window.scrollBy(0,450)", "");
	 //driver.findElement(locator.findBy("buttons_btnSaveChanges")).click();
	 utils.verifyAndClickButton("buttons_btnSaveChanges","Save");
	 waitForPageLoaded(driver); 
	 
	 /*utils.verifyAndClickLink("links_lnkStoreStep4","StoreStep4");
	 waitForPageLoaded(driver); 
	 
	 WebElement sourceElement5 = driver.findElement(locator.findBy("textboxes_txtSourceElement4"));
	 WebElement targetElement5=driver.findElement(locator.findBy("textboxes_txtTargetElement4"));
	 dragandDropFiles(sourceElement5,targetElement5);
	 jsx.executeScript("window.scrollBy(0,450)", "");
	 
	 for(int var2=0;var2<=2;var2++)
	 {
	 //driver.findElement(locator.findBy("buttons_btnProceed")).click();
	  utils.verifyAndClickButton("buttons_btnProceed","Proceed");
	  waitForPageLoaded(driver);
	 }
	 jsx.executeScript("window.scrollBy(0,450)", "");
	 //driver.findElement(locator.findBy("buttons_btnSaveChanges")).click(); 
	 utils.verifyAndClickButton("buttons_btnSaveChanges","Save");
	 waitForPageLoaded(driver); 
	 //driver.findElement(locator.findBy("links_lnkStoreStep5")).click(); 
	 utils.verifyAndClickLink("links_lnkStoreStep5","StoreStep5");
	 waitForPageLoaded(driver); 
	 //driver.findElement(locator.findBy("textboxes_txtName3")).sendKeys(dataTable.getData("General_data","Title"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtName3", dataTable.getData("General_data","Title"), "Title");
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 //driver.findElement(locator.findBy("checkboxes_chkBillingAddress")).click();
	 utils.verifyAndCheckCheckbox("checkboxes_chkBillingAddress","BillingAddress");
	 driver.findElement(locator.findBy("textboxes_txtCreditLimit")).clear();
	 //driver.findElement(locator.findBy("textboxes_txtCreditLimit")).sendKeys(dataTable.getData("General_data","CreditLimit"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtCreditLimit", dataTable.getData("General_data","CreditLimit"), "CreditLimit");
	 
	 for(int PaymentModeCounter=0;PaymentModeCounter<3;PaymentModeCounter++)
	 {
	  boolean selected =driver.findElement(locator.findBy("checkboxes_chkPaymentMode")).isSelected();
	  
	  if(selected)
	   break;
	  
	   else
	   //driver.findElement(locator.findBy("checkboxes_chkPaymentMode")).click();  
	  utils.verifyAndCheckCheckbox("checkboxes_chkPaymentMode","PaymentMode");
 	 }
	  
	 //driver.findElement(locator.findBy("buttons_btnProceed")).click();
	 utils.verifyAndClickButton("buttons_btnProceed","Proceed");
	 waitForPageLoaded(driver);
	 jsx.executeScript("window.scrollBy(0,450)", "");
	    	 
	 WebElement sourceElement6  = driver.findElement(locator.findBy("textboxes_txtSourceElement6"));
	 WebElement targetElement6=driver.findElement(locator.findBy("textboxes_txtTargetElement6"));
	 dragandDropFiles(sourceElement6,targetElement6); 
	 //driver.findElement(locator.findBy("buttons_btnProceed")).click();
	 utils.verifyAndClickButton("buttons_btnProceed","Proceed");
	 waitForPageLoaded(driver);
	 jsx.executeScript("window.scrollBy(0,450)", "");
	 
	 WebElement sourceElement7  = driver.findElement(locator.findBy("textboxes_txtSourceElementLeveringsadresser"));
	 WebElement targetElement7=driver.findElement(locator.findBy("textboxes_txtTargetElement2"));
	 dragandDropFiles(sourceElement7,targetElement7);
	 //driver.findElement(locator.findBy("buttons_btnProceed")).click();
	 utils.verifyAndClickButton("buttons_btnProceed","Proceed");
	 waitForPageLoaded(driver);
	
	 jsx.executeScript("window.scrollBy(0,450)", "");
	 WebElement sourceElement8  = driver.findElement(locator.findBy("textboxes_txtSourceElement2"));
	 WebElement targetElement8=driver.findElement(locator.findBy("textboxes_txtTargetElement2"));
	 dragandDropFiles(sourceElement8,targetElement8);
	 
	 for(int var1=0;var1<=2;var1++)
	 {
	 //driver.findElement(locator.findBy("buttons_btnProceed")).click();
	 utils.verifyAndClickButton("buttons_btnProceed","Proceed"); 
	 waitForPageLoaded(driver);
	 }
	 //driver.findElement(locator.findBy("buttons_btnSaveChanges")).click(); 
	 utils.verifyAndClickButton("buttons_btnSaveChanges","Save");
	 waitForPageLoaded(driver); 
	 //driver.findElement(locator.findBy("links_lnkButikk")).click();*/
	 
	 utils.verifyAndClickLink("links_lnkButikk","Buttik");
	 waitForPageLoaded(driver); 
	 utils.verifyAndEnterValueInTextBox("textboxes_txtButtik",storeName, "Store Name");
	 utils.verifyAndClickLink("links_lnkSearch","Search");
	 waitForPageLoaded(driver);
	 boolean storeStatus = driver.findElement(locator.findBy("links_lnkStoreName")).getText().equals(storeName);
	 
	 if(storeStatus)
		 report.updateTestLog(
					"New Store Creation",
					"Successfully created new store in mBiz",
					Status.PASS);
     else
			report.updateTestLog(
					"New Store Creation",
					"Unable to create new store in mBiz",
	  			Status.FAIL); 
	 
	}
	
	
	/**This function will Push Product to the Catalog
	 * 
	 * @throws InterruptedException
	 * @throws AWTException 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
		 	
	public void productCatalogPush() throws InterruptedException, AWTException, ParserConfigurationException, SAXException, IOException 
	{
	  Finder locator =new Finder();	
	  fluentwait(locator.findBy("images_imgAjaxLoad"));
	  //fluentwait(locator.findBy("images_imgFailedAjaxLoad"));
	  Actions builder1 = new Actions(driver);
	  builder1.moveToElement(driver.findElement(locator.findBy("links_lnkProductMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkProductCatalog"))).click().perform();
	  waitForPageLoaded(driver);
	
	  try
	  {
	  Actions builder2 = new Actions(driver);
	  builder2.moveToElement(driver.findElement(locator.findBy("links_lnkProductMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkProductCatalog"))).click().perform();
	  waitForPageLoaded(driver);
	  }
	 
	  catch(Exception e)
	  {
	  e.printStackTrace();
	  }
	  fluentwait(locator.findBy("images_imgIconLoader"));
	  //driver.findElement(locator.findBy("textboxes_txtProductSearch")).sendKeys(dataTable.getData("General_data","ProductName"));
	  utils.verifyAndEnterValueInTextBox("textboxes_txtProductSearch",dataTable.getData("General_data","ProductName"),"ProductName");
	  //driver.findElement(locator.findBy("textboxes_txtSearch")).click(); 
	  utils.verifyAndClickLink("textboxes_txtSearch","Search");
	  fluentwait(locator.findBy("images_imgIconLoader"));
	  //driver.findElement(locator.findBy("buttons_btnEditProduct")).click();
	  utils.verifyAndClickButton("buttons_btnEditProduct","EditProduct");
	  waitForPageLoaded(driver);
	  //driver.findElement(locator.findBy("links_lnkViewCategories")).click(); 
	  utils.verifyAndClickLink("links_lnkViewCategories","ViewCategories");
	  waitForPageLoaded(driver);
	  boolean chkboxselected=driver.findElement(locator.findBy("checkboxes_chkLevel1")).isSelected();
	  
	  if(chkboxselected)
	  {
	   //driver.findElement(locator.findBy("checkboxes_chkLevel1")).click();
	   utils.verifyAndCheckCheckbox("checkboxes_chkLevel1","Level1");
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   //driver.findElement(locator.findBy("checkboxes_chkLevel1MobiltBreradBand")).click();
	   utils.verifyAndCheckCheckbox("checkboxes_chkLevel1MobiltBreradBand","Level1MobiltBreradBand");
	  }
	   //driver.findElement(locator.findBy("buttons_btnSaveChanges")).click();
	  utils.verifyAndClickButton("buttons_btnSaveChanges","Save");
	  waitForPageLoaded(driver); 
	  //driver.findElement(locator.findBy("links_lnkbuttonRelease")).click(); 
	  utils.verifyAndClickLink("links_lnkbuttonRelease","Release");
	  waitForPageLoaded(driver); 
	  fluentwait(locator.findBy("images_imgAjaxLoad"));
	  //fluentwait(locator.findBy("images_imgFailedAjaxLoad"));
	  Thread.sleep(5000L);
	  
	  Actions builder4 = new Actions(driver);
	  builder4.moveToElement(driver.findElement(locator.findBy("links_lnkAdminMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkTextProductPreferences"))).click().perform();
	  waitForPageLoaded(driver);
	  
	  /*WebElement targetElement =driver.findElement(TelenorMobileWithoutSubscription.lnkAdminMenu);
	  JavascriptExecutor js = (JavascriptExecutor) driver;  
	  String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";  
	  js.executeScript(mouseOverScript, targetElement);  
	  driver.findElement(TelenorMobileWithoutSubscription.lnkAdminSubMenu2).click();*/
	    
	  try
	  {
	  Actions builder5 = new Actions(driver);
	  builder5.moveToElement(driver.findElement(locator.findBy("links_lnkAdminMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkAdminSubMenu2"))).click().perform();
	  waitForPageLoaded(driver);
	  }	  

	  catch(Exception e)
	  {
	  e.printStackTrace();
	  }
	  //driver.findElement(locator.findBy("buttons_btnTransferProducts")).click();
	  utils.verifyAndClickButton("buttons_btnTransferProducts","Transfer Products");
	  waitForPageLoaded(driver);
	}
	
	public void storeB2BPush() throws InterruptedException, AWTException, ParserConfigurationException, SAXException, IOException 
	{
	 //waitForPageLoaded(driver);
	 //windowMaximize();
	 //Thread.sleep(15000L);
	 Finder locator =new Finder();		
	 fluentwait(locator.findBy("images_imgAjaxLoad"));
	 //fluentwait(locator.findBy("images_imgFailedAjaxLoad"));
	 
	 Date now = new Date();
     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
     String timestampString = formatter.format(now);
	 String ProductUSP = dataTable.getData("General_data","ProductUSP") + timestampString;
	 String ProductDescription = dataTable.getData("General_data","ProductDescription") + timestampString;
     
	 utils.verifyAndClickLink("links_lnkButikkMenu","Butikk Menu");
	 waitForPageLoaded(driver);
	 //driver.findElement(locator.findBy("textboxes_txtButtik")).sendKeys(dataTable.getData("General_data","ShopName"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtButtik",dataTable.getData("General_data","ShopName"),"ShopName");
	 //driver.findElement(locator.findBy("links_lnkSearch")).click();
	 utils.verifyAndClickLink("links_lnkSearch","Search");
	 waitForPageLoaded(driver);
	 //driver.findElement(locator.findBy("links_lnkShopVismer")).click(); 
	 utils.verifyAndClickLink("links_lnkShopVismer","Vismer");
     Thread.sleep(3000L);
	 //driver.findElement(locator.findBy("buttons_btnProductOverride")).click(); 
     utils.verifyAndClickButton("buttons_btnProductOverride","ProductOverride");
	 waitForPageLoaded(driver);
	 //driver.findElement(locator.findBy("textboxes_txtProductSearch2")).sendKeys(dataTable.getData("General_data","ProductName"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtProductSearch2",dataTable.getData("General_data","ProductName"),"ProductName");
	 //driver.findElement(locator.findBy("links_lnksearchbutton")).click();
	 utils.verifyAndClickLink("links_lnksearchbutton","Search");
	 Thread.sleep(25000L);
	 JavascriptExecutor jsx = (JavascriptExecutor)driver;
	 jsx.executeScript("window.scrollBy(0,450)", "");
	 //driver.findElement(locator.findBy("links_lnkTextProductPreferences")).click();
	 utils.verifyAndClickLink("links_lnkTextProductPreferences","TextProductPreferences");
	 Thread.sleep(25000L);
	 String parentWindow =driver.getWindowHandle();
	 switchtoNewWindow(parentWindow);
	 // driver.findElement(locator.findBy("textboxes_txtProductUSP")).sendKeys(dataTable.getData("General_data","ProductUSP"));
	 //driver.findElement(locator.findBy("textboxes_txtProductUSP")).clear();
	 //driver.findElement(locator.findBy("textboxes_txtProductDescription")).clear();
	 utils.verifyAndEnterValueInTextBox("textboxes_txtProductUSP",ProductUSP,"Product USP");
	 //driver.findElement(locator.findBy("textboxes_txtProductDescription")).sendKeys(dataTable.getData("General_data","ProductDescription"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtProductDescription",ProductDescription,"Product Description");
	 //driver.findElement(locator.findBy("buttons_btnUpdater")).click();
	 JavascriptExecutor javx = (JavascriptExecutor)driver;
	 javx.executeScript("window.scrollBy(0,450)", "");
	 utils.verifyAndClickButton("buttons_btnUpdater","Update");
	 Thread.sleep(10000L);
	 switchBacktoOldWindow(parentWindow);
	 //driver.findElement(locator.findBy("links_lnkTelenorPrivate")).click();
	 utils.verifyAndClickLink("links_lnkB2bShop","B2bShopUpdate");
	 waitForPageLoaded(driver);
	 //driver.findElement(locator.findBy("buttons_btnUpdaterButikk")).click();
	 utils.verifyAndClickButton("buttons_btnUpdaterButikk","Update Butikk");	 
	 waitForPageLoaded(driver);
     
	 boolean updateUSP = driver.findElement(locator.findBy("textboxes_txtSuccessMessage")).isDisplayed();
	 
	 if(updateUSP)
	 report.updateTestLog(
					"USP and Product Description Updation ",
					"Successfully updated USP and product description in mBiz",
					Status.PASS);
      else
			report.updateTestLog(
					"USP and Product Description Updation ",
					"Unable to update USP and product description in mBiz",
					Status.FAIL);
	}
	
	public void catalogExport() throws InterruptedException, AWTException, ParserConfigurationException, SAXException, IOException 
	{
	 //waitForPageLoaded(driver);
	 //windowMaximize();
	 //Thread.sleep(15000L);
	 Finder locator =new Finder();		
	 fluentwait(locator.findBy("images_imgAjaxLoad"));
	 //fluentwait(locator.findBy("images_imgFailedAjaxLoad"));
	 
	 //Date now = new Date();
     //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
     //String timestampString = formatter.format(now);
	 //String ProductUSP = dataTable.getData("General_data","ProductUSP") + timestampString;
	// String ProductDescription = dataTable.getData("General_data","ProductDescription") + timestampString;
     
	 utils.verifyAndClickLink("links_lnkButikkMenu","Butikk Menu");
	 waitForPageLoaded(driver);
	 //driver.findElement(locator.findBy("textboxes_txtButtik")).sendKeys(dataTable.getData("General_data","ShopName"));
	 utils.verifyAndEnterValueInTextBox("textboxes_txtButtik",dataTable.getData("General_data","ShopName"),"ShopName");
	 //driver.findElement(locator.findBy("links_lnkSearch")).click();
	 utils.verifyAndClickLink("links_lnkSearch","Search");
	 waitForPageLoaded(driver);
	 
	 utils.verifyAndClickButton("buttons_btnSeeButtik","SeeButtik");
	
	 //utils.verifyAndClickLink("links_lnkShopVismer","Vismer");
     Thread.sleep(3000L);
	 //driver.findElement(locator.findBy("buttons_btnProductOverride")).click(); 
     utils.verifyAndClickButton("buttons_btnKatalogeksport","Katalogeksport");
	 waitForPageLoaded(driver);
	 
	    
	 boolean catalogeksportSelected = driver.findElement(locator.findBy("checkboxes_chkKatalogeksport")).isSelected();
	 
	 if(catalogeksportSelected)
	 report.updateTestLog(
					"Katalogeksport is Enabled for the Shop ",
					"Successfully checked the Katalogeksport option in mBiz",
					Status.PASS);
      else
			report.updateTestLog(
					"Katalogeksport is not enabled for the Shop ",
					"Unable to check the Katalogeksport option in mBiz",
					Status.FAIL);
	 
	 utils.verifyAndClickButton("buttons_btnKatlogexportSave","KatlogexportSave");
	 utils.verifyAndClickButton("buttons_btnGeneratekatalog","GenerateKatalog");
	 
     boolean GenerateKatalog = driver.findElement(locator.findBy("textboxes_txtSuccessMessage1")).isDisplayed();
	 
	 if(GenerateKatalog)
	 report.updateTestLog(
					"GenerateKatalog ",
					"Successfully Generated the Katalog in mBiz",
					Status.PASS);
      else
			report.updateTestLog(
					"GenerateKatalog ",
					"Unable to Generate the Katalog in mBiz",
					Status.FAIL);
	}
	
	public void shopValidationproductCatalogPush() throws InterruptedException, ParserConfigurationException, SAXException, IOException
	{
		 waitForPageLoaded(driver);
		 //driver.findElement(locator.findBy("links_lnkMobiltBredbånd")).click();
		 utils.verifyAndClickLink("links_lnkMobiltBredbånd","MobiltBredbånd");
		 waitForPageLoaded(driver);
		 boolean productDisplayStatus = driver.findElement(By.xpath("//div[@id='productrow']//div[@class='product-item']//a//span[contains(text(),'"+dataTable.getData("General_data","ProductName")+"')]")).isDisplayed();
		 
		 if(productDisplayStatus)
			 report.updateTestLog(
						"Check Product Displayed in Mobilit Bredbånd",
						"Successfully displayed product in Mobilt Bredbånd section of shop",
						Status.PASS);
	     else
				report.updateTestLog(
						"Check Product Displayed in Mobilit Bredbånd",
						"Not displayed product in Mobilt Bredbånd section of shop",
		  			Status.FAIL); 
		
	}
	
	public void shopValidationUSP() throws InterruptedException, ParserConfigurationException, SAXException, IOException
	{
	  waitForPageLoaded(driver);
	  Finder locator =new Finder();		
	  List<WebElement> element = driver.findElements(locator.findBy("textboxes_txtMobileList"));
	  int counter =1;
	  for(WebElement mobileText: element)
	  {
		  if(mobileText.getText().equals(dataTable.getData("General_data", "ProductName")))
		  {
		  WebElement mobiles =driver.findElement(findByDynXpath(locator.findBy("buttons_btnSelectCorrectProduct"),String.valueOf(counter)));
		  mobiles.click();
		  waitForPageLoaded(driver);
           break;		  
		  }
		  else
		  {
		  counter++;
		  }
	  }
	 boolean uspCheck= driver.findElement(locator.findBy("textboxes_txtTelenorProductUSP")).getText().contains(dataTable.getData("General_data","ProductUSP"));
	 boolean productDescriptionCheck= driver.findElement(locator.findBy("textboxes_txtTelenorProductDescription")).getText().contains(dataTable.getData("General_data","ProductDescription"));
	 
	 if(uspCheck)
		 report.updateTestLog(
					"USP Validation",
					"Successfully displayed updated USP in shop front end",
					Status.PASS);
      else
			report.updateTestLog(
					"USP Validation",
					"Unable to display updated USP in shop front end",
	  			Status.FAIL); 
	 
	  if(productDescriptionCheck)
		 report.updateTestLog(
					"Product Description Validation",
					"Successfully displayed  updated product description in shop front end",
					Status.PASS);
       else
			report.updateTestLog(
					"Product Description Validation",
					"Unable to display updated product description in shop front end",
	  			Status.FAIL); 
 
	}
	
	
	public void switchtoNewWindow(String oldHandler) throws InterruptedException {
			
			String popupHandle;
    		Set<String> s = driver.getWindowHandles();
			Iterator<String> ite = s.iterator();
			while (ite.hasNext()) {
				popupHandle = ite.next().toString();
				if (!popupHandle.contains(oldHandler)) {
					driver.switchTo().window(popupHandle);
					
				}
			}
		}
	
	public void switchBacktoOldWindow(String oldHandler)throws InterruptedException {
	
		driver.switchTo().window(oldHandler);
		Thread.sleep(2000);		
		driver.manage().window().maximize();
		}

	public void dragandDropFiles(WebElement sourceItem,WebElement destinationItem) throws InterruptedException {
		Actions action;
		Action act;
		action = new Actions(driver);
		action.clickAndHold(sourceItem).perform();		
		Thread.sleep(3000);		
		act = action.moveToElement(destinationItem).release().build(); 
		act.perform();			
		Thread.sleep(5000);						
		}
	
	public By findByDynXpath(By locatorName, String object) {
		By by=null;
		String locator =locatorName.toString();
		String xpathRemoved = locator.replaceAll("By.xpath: ","");
		String dynamicAdd =xpathRemoved.replaceAll("@1@",object);
		by= By.xpath(dynamicAdd);
		return by;
	}
	
	/*
 	public void barCodeGenerator() throws InterruptedException, AWTException
 	{
	driver.findElement(TelenorMobileWithoutSubscription.txtBarCodeInput).sendKeys(dataTable.getData("General_data","BarCode"));
	Thread.sleep(5000L);
	driver.findElement(TelenorMobileWithoutSubscription.btnBarCodeCalculate).click();
	waitForPageLoaded(driver);
	Thread.sleep(5000L);
	barCode = driver.findElement(TelenorMobileWithoutSubscription.txtBarCodeResult).getAttribute("value");
	}*/
	  	
	public void removeProducts() throws InterruptedException, ParserConfigurationException, SAXException, IOException{	
		     waitForPageLoaded(driver);
		     Finder locator =new Finder();		
	  		 List<WebElement> element = driver.findElements(locator.findBy("buttons_btnExistingProducts"));
	  		 int counter =element.size();
	  		 if(element.size()>0)
	  		 {
	  		 
	  		 for(@SuppressWarnings("unused") WebElement existingProducts: element)
	  		 {
	  		   driver.findElement(findByDynXpath(locator.findBy("buttons_btnRemoveProducts"),String.valueOf(counter))).click();
	  		   waitForPageLoaded(driver);
			   Thread.sleep(3000L);
			   counter--;
	  		 }
	  		
	  		 }
	  	}
	
	public void fluentwait(final By element)
	{
  		
  		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
  		       .withTimeout(40, TimeUnit.SECONDS)
  		       .pollingEvery(5, TimeUnit.SECONDS)
  		       .ignoring(NoSuchElementException.class);

	  		   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
	  		     public WebElement apply(WebDriver driver) {
	  		       return driver.findElement(element);
	  		     }
	  		   });
		}
	  	
	  		  	
		/** This Function is used to navigate to incoming product list in mBiz
		 * 
		 * @throws InterruptedException
		 * @throws IOException 
		 * @throws SAXException 
		 * @throws ParserConfigurationException 
		 */
	  	
	  	public void approveExistingProduct() throws InterruptedException, ParserConfigurationException, SAXException, IOException{
	  		
	  		 waitForPageLoaded(driver);
	  		 Finder locator =new Finder();		
	  		//driver.findElement(locator.findBy("buttons_btnApproveExistingProduct")).click();
	  		
	  		JavascriptExecutor jsx = (JavascriptExecutor)driver;
			jsx.executeScript("window.scrollBy(0,250)", "");
			
	  		utils.verifyAndClickButton("buttons_btnApproveExistingProduct","ApproveExistingProduct");
	  		waitForPageLoaded(driver);
	  		//fluentwait(locator.findBy("images_imgIconLoader"));
	  		//Thread.sleep(300L);
	  		String approvedProductExpected = driver.findElement(locator.findBy("textboxes_txtCreatedAgent")).getText();
	  		//driver.findElement(locator.findBy("buttons_btnProceed2")).click();
	  		utils.verifyAndClickButton("buttons_btnProceed2","Proceed");
	  		waitForPageLoaded(driver);
	  		//driver.findElement(locator.findBy("checkboxes_chkApproveProductLevel1")).click();
	  		utils.verifyAndCheckCheckbox("checkboxes_chkApproveProductLevel1","ApproveProductLevel1");
	  		Thread.sleep(1000L);
	  		//driver.findElement(locator.findBy("checkboxes_chkApproveProductLevel2")).click();
	  		utils.verifyAndCheckCheckbox("checkboxes_chkApproveProductLevel2","ApproveProductLevel2");
	  		
	  		for(int var1=0;var1<2;var1++)
	  		{
	  			//driver.findElement(locator.findBy("buttons_btnApproveIncomingProductClickNxt")).click();
	  			utils.verifyAndClickButton("buttons_btnApproveIncomingProductClickNxt","ApproveIncomingProductClickNxt");

		  		waitForPageLoaded(driver);
		  		//driver.findElement(locator.findBy("buttons_btnApproveIncomingProductWizardSave")).click();
		  		utils.verifyAndClickButton("buttons_btnApproveIncomingProductWizardSave","Save");
		  		waitForPageLoaded(driver);
	  		}
	  		
	  		Actions builder3 = new Actions(driver);
		  	builder3.moveToElement(driver.findElement(locator.findBy("links_lnkProductMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkProductCatalog"))).click().perform();
		  	waitForPageLoaded(driver);
		  	 
		  	try
		  	{
		  	  Actions builder4 = new Actions(driver);
		  	  builder4.moveToElement(driver.findElement(locator.findBy("links_lnkProductMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkProductCatalog"))).click().perform();
		  	  waitForPageLoaded(driver);
		  	}
		  	  
		  	  catch(Exception e)
		  	{
		  	   e.printStackTrace();  
		  	}
		  	
		  	waitForPageLoaded(driver); 
		  	//driver.findElement(locator.findBy("textboxes_txtProductSearch")).sendKeys(dataTable.getData("General_data","MobileName"));
		  	utils.verifyAndEnterValueInTextBox("textboxes_txtProductSearch", dataTable.getData("General_data","MobileName"), "MobileName");
		  	//driver.findElement(locator.findBy("textboxes_txtSearch")).click();
		  	utils.verifyAndClickLink("textboxes_txtSearch","Search");
		  	  
		  	String approvedProductActual = driver.findElement(locator.findBy("textboxes_txtProductCatalogFirst")).getText();  
		  	
		  	if(approvedProductExpected.trim().equals(approvedProductActual.trim()))
		  		report.updateTestLog("Approve Incoming product", "Approval of Incoming product successful",Status.PASS); else
		  		report.updateTestLog("Approve Incoming product", "Approval of Incoming product unsuccessful",Status.FAIL);
		  	
	  	}
	  	
	  
	  	/** This Function is used for New Product Approval in Incoming product
		 * 
		 * @throws InterruptedException
	  	 * @throws IOException 
	  	 * @throws SAXException 
	  	 * @throws ParserConfigurationException 
		 */
	  	
	  	public void approveNewProduct() throws InterruptedException, ParserConfigurationException, SAXException, IOException{
	  		waitForPageLoaded(driver);
	  		Finder locator =new Finder();		
	  		//driver.findElement(locator.findBy("buttons_btnApproveIncomingProduct")).click();
	  		utils.verifyAndClickButton("buttons_btnApproveIncomingProduct","Approve");
	  		waitForPageLoaded(driver);
	  		//Thread.sleep(10000L);
	  		//driver.findElement(locator.findBy("buttons_btnApproveIncomingProductClickNxt")).click();
	  		utils.verifyAndClickButton("buttons_btnApproveIncomingProductClickNxt","Approve");
	  		waitForPageLoaded(driver);
	  		// click Level 1, Level 2 values in Visningskategorier tab
	  		//driver.findElement(locator.findBy("checkboxes_chkApproveProductLevel1")).click();
	  		utils.verifyAndCheckCheckbox("checkboxes_chkApproveProductLevel1","ApproveProductLevel1");
	  		Thread.sleep(1000L);
	  		//driver.findElement(locator.findBy("checkboxes_chkApproveProductLevel2")).click();
	  		utils.verifyAndCheckCheckbox("checkboxes_chkApproveProductLevel2","ApproveProductLevel2");
	  		
	  		for(int var1=0;var1<2;var1++)
	  		{
	  			//driver.findElement(locator.findBy("buttons_btnApproveIncomingProductClickNxt")).click();
	  			utils.verifyAndClickButton("buttons_btnApproveIncomingProductClickNxt","Approve");
		  		waitForPageLoaded(driver);
		  		//driver.findElement(locator.findBy("buttons_btnApproveIncomingProductWizardSave")).click();
		  		utils.verifyAndClickButton("buttons_btnApproveIncomingProductWizardSave","Save");
		  		waitForPageLoaded(driver);
	  		}
	  		//driver.findElement(locator.findBy("buttons_btnEditSalesProduct")).click();
	  		utils.verifyAndClickButton("buttons_btnEditSalesProduct","EditSalesProduct");
	  		waitForPageLoaded(driver);
	  		
	  		String productVariantExpected = driver.findElement(locator.findBy("links_lnkProductVariantUtvalg")).getText();
	  			  		
	  		String manufacturer = dataTable.getData("General_data","Manufacturer");
	  		String modelName = dataTable.getData("General_data","ModelName");
	  		String colorId = dataTable.getData("General_data","ColorId");
	  		
	  		String productVariantActual = manufacturer+' '+modelName+' '+colorId;

	  		if(productVariantExpected.trim().equals(productVariantActual.trim()))
	  			report.updateTestLog("Approve Local product", "Approval of new Local product successful",Status.PASS); else
	  			report.updateTestLog("Approve Local product", "Approval of new Local product unsuccessful",Status.FAIL);	
	  	}
	  	
	  	
	  	public void clickOnHandleMer() throws ParserConfigurationException, SAXException, IOException
	  	{
	  		VerificationComponents.IsmultiProductSelected=true;
	    	waitForPageLoaded(driver);
	    	//driver.findElement(locator.findBy("links_lnkHandleMer")).click();
	    	utils.verifyAndClickLink("links_lnkHandleMer","HandleMer");
	    	waitForPageLoaded(driver);
	    	try
	    	{
	    	//driver.findElement(locator.findBy("links_lnkNettbutikk")).click();
	    	utils.verifyAndClickLink("links_lnkNettbutikk","Nettbutikk");
	    	waitForPageLoaded(driver);
	    	}
	    	catch (Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    	
	  	}
	  	/** This Function is used for checking AX integration with B2B stores in mBiz
	  	 * @throws IOException 
	  	 * @throws SAXException 
	  	 * @throws ParserConfigurationException 
		 * 
		 * @throws InterruptedException
		 */
	  	public void axIntegrationCheck() throws AWTException, ParserConfigurationException, SAXException, IOException, InterruptedException
	  	{
	  		//waitForPageLoaded(driver);
	  		//windowMaximize();
	  		Finder locator =new Finder();
	  		
	  		fluentwait(locator.findBy("images_imgAjaxLoad"));
	  		//fluentwait(locator.findBy("images_imgFailedAjaxLoad"));
	  			
	  		Actions builder = new Actions(driver);
	  		builder.moveToElement(driver.findElement(locator.findBy("links_lnkButikkMenu"))).click().perform();
	  		waitForPageLoaded(driver);
	  		
	  		try
	  		{
	  		utils.verifyAndClickLink("links_lnkButikkMenu","Butikk Menu");
	  	    waitForPageLoaded(driver);
	  		}
	  		catch(Exception e)
	  		{
	  		e.printStackTrace();
	  		}
	  		
	  			//driver.findElement(locator.findBy("textboxes_txtButtik")).sendKeys(dataTable.getData("General_Data", "Store"));
		  	    utils.verifyAndEnterValueInTextBox("textboxes_txtButtik", dataTable.getData("General_data","Store"), "Search");
	  			//driver.findElement(locator.findBy("links_lnkSearch")).click();
		  	    utils.verifyAndClickLink("links_lnkSearch","Search");
		  		waitForPageLoaded(driver);
		  		//driver.findElement(locator.findBy("links_lnkShopVismer")).click();
		  		utils.verifyAndClickLink("links_lnkShopVismer","Vismer");
		  		Thread.sleep(3000L);		  		
		  		//driver.findElement(locator.findBy("buttons_btnEditStore")).click();
		  		utils.verifyAndClickButton("buttons_btnEditStore","Edit Store");
		  		waitForPageLoaded(driver);
		  		//driver.findElement(locator.findBy("links_lnkProperties")).click();
		  		utils.verifyAndClickLink("links_lnkProperties","Properties");
		  		waitForPageLoaded(driver);
		  		JavascriptExecutor jsx = (JavascriptExecutor)driver;
				jsx.executeScript("window.scrollBy(0,450)", "");
		  		String ShopNavisionId = driver.findElement(locator.findBy("textboxes_txtShopNavisionId")).getAttribute("value");
		  		
		  		String ShopAXId = driver.findElement(locator.findBy("textboxes_txtShopAXId")).getAttribute("value");
		  		
		  		if(ShopNavisionId.trim().equals((dataTable.getData("General_Data", "NavisionStoreID")))&&ShopAXId.trim().equals((dataTable.getData("General_Data", "AXStoreID"))) )
		  		{
		  			utils.verifyAndClickLink("links_lnkShopCancelWizard","ShopCancelWizard");
			  		waitForPageLoaded(driver);
			  		utils.verifyAndEnterValueInTextBox("textboxes_txtButtik", dataTable.getData("General_data","Store"), "Search");
			  	    utils.verifyAndClickLink("links_lnkSearch","Search");
			  		waitForPageLoaded(driver);
			  		utils.verifyAndClickLink("links_lnkShopVismer","Vismer");
			  		Thread.sleep(3000L);
		  		}
		  		else
		  		{
		  			driver.findElement(locator.findBy("textboxes_txtShopNavisionId")).clear();
		  			//driver.findElement(locator.findBy("textboxes_txtShopNavisionId")).sendKeys(dataTable.getData("General_Data", "NavisionStoreID"));
		  		    utils.verifyAndEnterValueInTextBox("textboxes_txtShopNavisionId", dataTable.getData("General_data","NavisionStoreID"), "Navision ID");
		  			//driver.findElement(locator.findBy("buttons_btnSaveChanges")).click();
		  		    driver.findElement(locator.findBy("textboxes_txtShopAXId")).clear();
		  		    utils.verifyAndEnterValueInTextBox("textboxes_txtShopAXId", dataTable.getData("General_data","AXStoreID"), "AX ID");
		  		    utils.verifyAndClickButton("buttons_btnSaveChanges","Save");
			  		waitForPageLoaded(driver);
			  		//driver.findElement(locator.findBy("buttons_btnUpdaterButikk")).click();
			  		utils.verifyAndClickButton("buttons_btnUpdaterButikk","Update Butikk");
			  		waitForPageLoaded(driver);
			  		boolean updateStoreSuccess = driver.findElement(locator.findBy("textboxes_txtSuccessMessage")).getText().equals("Oppdatering vellykket.");
			  		
			  		if (updateStoreSuccess)
						report.updateTestLog("Update Store", "AXId and NavisionId Updation to Store was successful",Status.PASS); else
					  	report.updateTestLog("Update Store", "AXId and NavisionId Updation to Store was unsuccessful",Status.FAIL);
			  		
		  		}
		  		
		  				  		
		  		utils.verifyAndClickButton("buttons_btnAXIntegrationButikk","AXIntegrationButikk");
		  		waitForPageLoaded(driver);
		  		//driver.findElement(locator.findBy("buttons_btnNavisionIntegration")).click();
		  		utils.verifyAndClickButton("buttons_btnAXIntegration","AXIntegration");
		  		waitForPageLoaded(driver);
	  		
	  		boolean updateNavIntSuccess = driver.findElement(locator.findBy("textboxes_txtSuccessMessage")).getText().equals("Oppdatering vellykket.");
	  		
	  		if (updateNavIntSuccess)
				report.updateTestLog("AX-integrasjon", "AX-integrasjon is successful",Status.PASS); else
			  	report.updateTestLog("AX-integrasjon", "AX-integrasjon is unsuccessful",Status.FAIL);	
}
	  	
	  	/** This Function is used for checking Navision integration with B2B stores in mBiz
	  	 * @throws IOException 
	  	 * @throws SAXException 
	  	 * @throws ParserConfigurationException 
		 * 
		 * @throws InterruptedException
		 */
	  	public void navisionIntegrationCheck() throws AWTException, ParserConfigurationException, SAXException, IOException, InterruptedException
	  	{
	  		//waitForPageLoaded(driver);
	  		//windowMaximize();
	  		Finder locator =new Finder();
	  		
	  		fluentwait(locator.findBy("images_imgAjaxLoad"));
	  		//fluentwait(locator.findBy("images_imgFailedAjaxLoad"));
	  			
	  		Actions builder = new Actions(driver);
	  		builder.moveToElement(driver.findElement(locator.findBy("links_lnkButikkMenu"))).click().perform();
	  		waitForPageLoaded(driver);
	  		
	  		try
	  		{
	  		utils.verifyAndClickLink("links_lnkButikkMenu","Butikk Menu");
	  	    waitForPageLoaded(driver);
	  		}
	  		catch(Exception e)
	  		{
	  		e.printStackTrace();
	  		}
	  		
	  			//driver.findElement(locator.findBy("textboxes_txtButtik")).sendKeys(dataTable.getData("General_Data", "Store"));
		  	    utils.verifyAndEnterValueInTextBox("textboxes_txtButtik", dataTable.getData("General_data","Store"), "Search");
	  			//driver.findElement(locator.findBy("links_lnkSearch")).click();
		  	    utils.verifyAndClickLink("links_lnkSearch","Search");
		  		waitForPageLoaded(driver);
		  		//driver.findElement(locator.findBy("links_lnkShopVismer")).click();
		  		utils.verifyAndClickLink("links_lnkShopVismer","Vismer");
		  		Thread.sleep(3000L);		  		
		  		//driver.findElement(locator.findBy("buttons_btnEditStore")).click();
		  		utils.verifyAndClickButton("buttons_btnEditStore","Edit Store");
		  		waitForPageLoaded(driver);
		  		//driver.findElement(locator.findBy("links_lnkProperties")).click();
		  		utils.verifyAndClickLink("links_lnkProperties","Properties");
		  		waitForPageLoaded(driver);
		  		JavascriptExecutor jsx = (JavascriptExecutor)driver;
				jsx.executeScript("window.scrollBy(0,450)", "");
		  		String ShopNavisionId = driver.findElement(locator.findBy("textboxes_txtShopNavisionId")).getAttribute("value");
		  		
		  		if(ShopNavisionId.trim().equals((dataTable.getData("General_Data", "NavisionStoreID"))))
		  		{
		  			utils.verifyAndClickLink("links_lnkShopCancelWizard","ShopCancelWizard");
			  		waitForPageLoaded(driver);
			  		utils.verifyAndEnterValueInTextBox("textboxes_txtButtik", dataTable.getData("General_data","Store"), "Search");
			  	    utils.verifyAndClickLink("links_lnkSearch","Search");
			  		waitForPageLoaded(driver);
			  		utils.verifyAndClickLink("links_lnkShopVismer","Vismer");
			  		Thread.sleep(3000L);
		  		}
		  		else
		  		{
		  			driver.findElement(locator.findBy("textboxes_txtShopNavisionId")).clear();
		  			//driver.findElement(locator.findBy("textboxes_txtShopNavisionId")).sendKeys(dataTable.getData("General_Data", "NavisionStoreID"));
		  		    utils.verifyAndEnterValueInTextBox("textboxes_txtShopNavisionId", dataTable.getData("General_data","NavisionStoreID"), "Navision ID");
		  			//driver.findElement(locator.findBy("buttons_btnSaveChanges")).click();
		  		    utils.verifyAndClickButton("buttons_btnSaveChanges","Save");
			  		waitForPageLoaded(driver);
			  		//driver.findElement(locator.findBy("buttons_btnUpdaterButikk")).click();
			  		utils.verifyAndClickButton("buttons_btnUpdaterButikk","Update Butikk");
			  		waitForPageLoaded(driver);
			  		boolean updateStoreSuccess = driver.findElement(locator.findBy("textboxes_txtSuccessMessage")).getText().equals("Oppdatering vellykket.");
			  		
			  		if (updateStoreSuccess)
						report.updateTestLog("Update Store", "NavisionId Updation to Store was successful",Status.PASS); else
					  	report.updateTestLog("Update Store", "NavisionId Updation to Store was unsuccessful",Status.FAIL);
			  		
		  		}
		  		
		  				  		
		  		utils.verifyAndClickButton("buttons_btnNavisionIntegrationButikk","NavisionIntegrationButikk");
		  		waitForPageLoaded(driver);
		  		//driver.findElement(locator.findBy("buttons_btnNavisionIntegration")).click();
		  		utils.verifyAndClickButton("buttons_btnNavisionIntegration","NavisionIntegration");
		  		waitForPageLoaded(driver);
	  		
	  		boolean updateNavIntSuccess = driver.findElement(locator.findBy("textboxes_txtSuccessMessage")).getText().equals("Oppdatering vellykket.");
	  		
	  		if (updateNavIntSuccess)
				report.updateTestLog("Navision-integrasjon", "Navision-integrasjon is successful",Status.PASS); else
			  	report.updateTestLog("Navision-integrasjon", "Navision-integrasjon is unsuccessful",Status.FAIL);	
}
	  	
	  
	  	/** This Function is used to return orders in webshop
		 * 
		 * @throws InterruptedException
	  	 * @throws IOException 
	  	 * @throws SAXException 
	  	 * @throws ParserConfigurationException 
		 */
	  	public void returnOrder() throws InterruptedException, ParserConfigurationException, SAXException, IOException
	  	{
	  		Finder locator =new Finder();	
	  		//driver.findElement(locator.findBy("links_lnkBack")).click();
	  		utils.verifyAndClickLink("links_lnkBack","Back");
		    waitForPageLoaded(driver);
		    //driver.findElement(locator.findBy("buttons_btnReturnOrder")).click();
		    utils.verifyAndClickButton("buttons_btnReturnOrder","ReturnOrder");
	  		waitForPageLoaded(driver);
	  		//driver.findElement(locator.findBy("textboxes_txtProcessOrder")).click();
	  		utils.verifyAndClickLink("textboxes_txtProcessOrder","Process Order");
	  		waitForPageLoaded(driver);
	  		//driver.findElement(locator.findBy("links_lnkCheckOrderStatus")).click();
	  		utils.verifyAndClickLink("links_lnkCheckOrderStatus","Order Status");
			Thread.sleep(5000L);
			String OrderStatusActual = driver.findElement(locator.findBy("textboxes_txtIHelpOrderStatus")).getText();
			String OrderStatusExpected = dataTable.getData("General_Data", "ReturnOrderStatus");
			if (OrderStatusActual.trim().equals(OrderStatusExpected.trim()))
			report.updateTestLog("Return Order", "Order return successful",Status.PASS); else
		  	report.updateTestLog("Return Order", "Order return unsuccessful",Status.FAIL);	
	  	}
	  	

		/** This Function is used to select level 2 items in webshop
		 * 
		 * @throws InterruptedException
		 * @throws IOException 
		 * @throws SAXException 
		 * @throws ParserConfigurationException 
		 */
	  	
	  	public void level2Select() throws InterruptedException, ParserConfigurationException, SAXException, IOException{
	  		//driver.findElement(locator.findBy("buttons_btnSelectLevel2HTC")).click();
	  		
	  		utils.verifyAndClickButton("buttons_btnSelectLevel2HTC","SelectLevel2");
	  		Thread.sleep(1000L);
	  	}
	  	

		/** This Function is used to validate PreSale product in mBiz and update if necessary
		 * @throws IOException 
		 * @throws SAXException 
		 * @throws ParserConfigurationException 
		 * 
		 * @throws InterruptedException
		 */
	  	public void preSalesProductCheck() throws AWTException, ParserConfigurationException, SAXException, IOException
	  	{
	  	  waitForPageLoaded(driver);
	  	  Finder locator =new Finder();
	  	  fluentwait(locator.findBy("images_imgAjaxLoad"));
	      //fluentwait(locator.findBy("images_imgFailedAjaxLoad"));
	  	  Actions builder3 = new Actions(driver);
	  	  builder3.moveToElement(driver.findElement(locator.findBy("links_lnkProductMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkProductCatalog"))).click().perform();
	  	  waitForPageLoaded(driver);
	  	 
	  	  try
	  	  {
	  	  Actions builder4 = new Actions(driver);
	  	  builder4.moveToElement(driver.findElement(locator.findBy("links_lnkProductMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkProductCatalog"))).click().perform();
	  	  waitForPageLoaded(driver);
	  	  }
	  	  
	  	  catch(Exception e)
	  	  {
	  	   e.printStackTrace();  
	  	  }
	  	  
	  	//driver.findElement(locator.findBy("textboxes_txtProductSearch")).sendKeys(dataTable.getData("General_data","MobileName"));
	  	 utils.verifyAndEnterValueInTextBox("textboxes_txtProductSearch", dataTable.getData("General_data","MobileName"), "Mobile Name");
	  	//driver.findElement(locator.findBy("textboxes_txtSearch")).click();
	  	utils.verifyAndClickLink("textboxes_txtSearch","Search");
	  	fluentwait(locator.findBy("images_imgIconLoader"));
	  	//driver.findElement(locator.findBy("links_lnkSalesProductLink")).click();
	  	utils.verifyAndClickLink("links_lnkSalesProductLink","Sales Product Link");
	  	  
	  	  int counter = 1;
	  	  List <WebElement> salesProductsNo = driver.findElements(locator.findBy("textboxes_txtSalesProductCount"));
	  	  for (WebElement Products:salesProductsNo)
	  	  {
	  		 if(Products.getText().trim().equals(dataTable.getData("General_Data", "NavisionId")))
	  		 break;
	  		 counter++;
	  	  }
	  	  driver.findElement(By.xpath("//div[@class='productconnection-list']//div[@class='container']//h5["+counter+"]//a")).click();
	  	  waitForPageLoaded(driver);
	  	  //driver.findElement(locator.findBy("buttons_btnEditSalesProduct")).click();
	  	 utils.verifyAndClickButton("buttons_btnEditSalesProduct","EditSalesProduct");
	  	  waitForPageLoaded(driver);
	  	  
		  JavascriptExecutor jsx = (JavascriptExecutor)driver;
		  jsx.executeScript("window.scrollBy(0,450)", "");
	  	  boolean preSaleProductStatus = driver.findElement(locator.findBy("checkboxes_chkPresaleProduct")).isSelected();
	  	  
	  	  if (!preSaleProductStatus)
	  	  {
	  		  //driver.findElement(locator.findBy("checkboxes_chkPresaleProduct")).click();
	  		  utils.verifyAndCheckCheckbox("checkboxes_chkPresaleProduct","PresaleProduct");
	  		   waitForPageLoaded(driver);
	  		  //driver.findElement(locator.findBy("buttons_btnApproveIncomingProductClickNxt")).click();
	  		  utils.verifyAndClickButton("buttons_btnApproveIncomingProductClickNxt","ApproveIncomingProduct");
	  		   waitForPageLoaded(driver);
	  		  //driver.findElement(locator.findBy("buttons_btnApproveIncomingProductWizardSave")).click();
	  		  utils.verifyAndClickButton("buttons_btnApproveIncomingProductWizardSave","Save");
		  	  waitForPageLoaded(driver);
		  	  
		  	   WebElement adminMenu = driver.findElement(locator.findBy("links_lnkAdminMenu"));
		 	   WebElement adminSubMenu = driver.findElement(locator.findBy("links_lnkAdminSubMenu2"));
		 	   
		 	   Actions builder6 = new Actions(driver);
		 	   builder6.moveToElement(adminMenu).build().perform();
		 	   Actions builder5 = new Actions(driver);
		 	   builder5.moveToElement(adminSubMenu).click().build().perform();
		 	   waitForPageLoaded(driver);
		 	 
		 	   try
		 	   {
		 	   Actions builder4 = new Actions(driver);
		 	   builder4.moveToElement(driver.findElement(locator.findBy("links_lnkAdminMenu"))).moveToElement(driver.findElement(locator.findBy("links_lnkAdminSubMenu2"))).click().perform();
		 	   waitForPageLoaded(driver);
		 	   }
		 	   catch(Exception e)
		 	   {
		 	   e.printStackTrace();
		 	   }
		 	   //driver.findElement(locator.findBy("buttons_btnCompletePush")).click();
		 	   utils.verifyAndClickButton("buttons_btnTransferProductsOnly","Product Push");
		 	   waitForPageLoaded(driver);
	  	  } 
	  	  
	  	}
	  	public void elementClick(WebElement element)
	  	{
	  		Capabilities cp = ((RemoteWebDriver)  
	  			  driver).getCapabilities();
	  			                   if (cp.getBrowserName().equals("chrome")) {
	  			                       try {
	  			                           ((JavascriptExecutor) driver).executeScript(
	  			                                   "arguments[0].scrollIntoView(true);",  
	  			                                   element);
	  			                          element.click();    
	  			                       } catch (Exception e) {

	  			                       }
	  			                        }
	  			                   
	  			                   else
	  			                   {
	  			                	 element.click();      
	  			                   }
	  	}
	  	
	  	/** This Function is used to validate purchase limit of mobile
		 * 
		 * @throws InterruptedException
	  	 * @throws IOException 
	  	 * @throws SAXException 
	  	 * @throws ParserConfigurationException 
		 */
	  	public void checkPurchaseLimit() throws InterruptedException, ParserConfigurationException, SAXException, IOException
	  	{
	  		Finder locator =new Finder();
	  		for (int i=0;i<5;i++)
	  		{
	  			//driver.findElement(locator.findBy("links_lnkProductName")).click();
	  			utils.verifyAndClickLink("links_lnkProductName","Product Name");
	  			waitForPageLoaded(driver);
	  			clickOnAddToBasket();
	  			if(i==4)
	  			{
	  				boolean Error1 = driver.findElement(locator.findBy("textboxes_txtProductLimitError1")).getText().trim().equals(dataTable.getData("General_Data", "ErrorMsg1").trim());
	  				boolean Error2 = driver.findElement(locator.findBy("textboxes_txtProductLimitError2")).getText().trim().equals(dataTable.getData("General_Data", "ErrorMsg2").trim());
	  				
	  				if(Error1&&Error2)
	  					report.updateTestLog("Purchase Mobile Limit check", "Only five mobiles allowed per checkout and error message is as expected",Status.PASS); else
	  					report.updateTestLog("Purchase Mobile Limit check", "Only five mobiles allowed per checkout and error message is not as expected",Status.FAIL);
	  			}
	  		}
	  		//driver.findElement(locator.findBy("links_lnkCart")).click();
	  		utils.verifyAndClickLink("links_lnkCart","Cart");
  			waitForPageLoaded(driver);
  			for(int j=0;j<11;j++)
  			{
  				//driver.findElement(locator.findBy("links_lnkaccessories")).click();
  				utils.verifyAndClickLink("links_lnkaccessories","Accessories");
	  			Thread.sleep(500L);
	  			//driver.findElement(locator.findBy("buttons_btnSelectAcessoryCart")).click();
	  			utils.verifyAndClickButton("buttons_btnSelectAcessoryCart","SelectAcessoryCart");
	  			waitForPageLoaded(driver);
	  			if(j==10)
	  			{
	  				boolean Error1 = driver.findElement(locator.findBy("textboxes_txtAccessoryLimitError1")).getText().trim().equals(dataTable.getData("General_Data", "ErrorMsg3").trim());
	  				boolean Error2 = driver.findElement(locator.findBy("textboxes_txtAccessoryLimitError2")).getText().trim().equals(dataTable.getData("General_Data", "ErrorMsg4").trim());
	  				if(Error1&&Error2)
	  					report.updateTestLog("Purchase Accessory Limit check", "Only ten Accessories allowed per checkout and error message is as expected",Status.PASS); else
	  					report.updateTestLog("Purchase Accessory Limit check", "Only ten Accessories allowed per checkout and error message is not as expected",Status.FAIL);
	  			}
  			}
	  	}
	  	
	  	
	  	/** This Function is used by shared user login to place orders in store
		 * 
		 * @throws InterruptedException
	  	 * @throws IOException 
	  	 * @throws SAXException 
	  	 * @throws ParserConfigurationException 
		 */
	  	public void sharedLoginStore() throws InterruptedException, ParserConfigurationException, SAXException, IOException
	  	{
	  		Finder locator =new Finder();
	  		fluentwait(locator.findBy("images_imgAjaxLoad"));
	  		//fluentwait(locator.findBy("images_imgFailedAjaxLoad"));
	  		waitForPageLoaded(driver);
	  		Thread.sleep(1000L);
	  		
	  		Actions builder = new Actions(driver);
	  		builder.moveToElement(driver.findElement(locator.findBy("links_lnkButikkMenu"))).click().perform();
	  		waitForPageLoaded(driver);
	  		
	  		try
	  		{
	  		//driver.findElement(locator.findBy("links_lnkButikkMenu")).click();
	  		utils.verifyAndClickLink("links_lnkButikkMenu", "Butikk Menu");
	  	    waitForPageLoaded(driver);
	  		}
	  		catch(Exception e)
	  		{
	  		e.printStackTrace();
	  		}
	  		
	  		//driver.findElement(locator.findBy("textboxes_txtButtik")).sendKeys("Logica");
	  		 utils.verifyAndEnterValueInTextBox("textboxes_txtButtik","Sunnhordland","Butikk");
	  		//driver.findElement(locator.findBy("links_lnkSearch")).click();
	  		utils.verifyAndClickLink("links_lnkSearch", "Search");
	  		waitForPageLoaded(driver);
	  		//driver.findElement(locator.findBy("links_lnkShopVismer")).click();
	  		utils.verifyAndClickLink("links_lnkShopVismer", "Vismer");
	  		Thread.sleep(3000L);
	  		//driver.findElement(locator.findBy("buttons_btnEditStore")).click();
	  		utils.verifyAndClickButton("buttons_btnEditStore","EditStore");
	  		waitForPageLoaded(driver);
	  		//driver.findElement(locator.findBy("links_lnkProperties")).click();
	  		utils.verifyAndClickLink("links_lnkProperties", "Properties");
	  		waitForPageLoaded(driver);
	  		JavascriptExecutor jsx = (JavascriptExecutor)driver;
			jsx.executeScript("window.scrollBy(0,150)", "");
			//driver.findElement(locator.findBy("buttons_btnB2bNyLogin")).click();
			//utils.verifyAndClickButton("buttons_btnB2bNyLogin","Login");
			Thread.sleep(500L);
			String mBizURL = driver.findElement(locator.findBy("links_lnkSharedUserLogin")).getText();		
	  		if(mBizURL.startsWith(properties.getProperty("ApplicationUrl10")))
	  		{
	  			//utils.verifyAndClickLink("links_lnkSharedUserLogin", "SharedUserLogin");
	  			//Thread.sleep(2500L);
	  			driver.get(mBizURL);
		  		waitForPageLoaded(driver);
	  		}
	  		else
	  		{
		  		String launchURL = mBizURL.replace("webos2swb044.web.no.tconet.net:9060", "nordialogpreprod.kjedehuset.no");
		  		driver.get(launchURL);
		  		driver.get(mBizURL);
		  		waitForPageLoaded(driver);
	  		}
	  	}
	  	
	  	/** This Function is used for shared user login to place orders in store
		 * 
		 * @throws InterruptedException
	  	 * @throws IOException 
	  	 * @throws SAXException 
	  	 * @throws ParserConfigurationException 
		 */
	  	public void sharedUserPersonalia() throws InterruptedException, ParserConfigurationException, SAXException, IOException
	  	{
	  		waitForPageLoaded(driver);
	  		//driver.findElement(locator.findBy("textboxes_txtSharedUserFornavn")).sendKeys(dataTable.getData("General_Data", "Fornavn"));
	  		 utils.verifyAndEnterValueInTextBox("textboxes_txtSharedUserFornavn",dataTable.getData("General_Data", "Fornavn"),"Fornavn");
	  		//driver.findElement(locator.findBy("textboxes_txtSharedUserEtternavn")).sendKeys(dataTable.getData("General_Data", "Etternavn"));
	  		 utils.verifyAndEnterValueInTextBox("textboxes_txtSharedUserEtternavn",dataTable.getData("General_Data", "Etternavn"),"Etternavn");
	  		//driver.findElement(locator.findBy("textboxes_txtSharedUserEpost")).sendKeys(dataTable.getData("General_Data", "Email"));
	  		 utils.verifyAndEnterValueInTextBox("textboxes_txtSharedUserEpost",dataTable.getData("General_Data", "Email"),"Email");
	  		//driver.findElement(locator.findBy("buttons_btnContinueCheckout")).click();
	  		utils.verifyAndClickButton("buttons_btnContinueCheckout","Continue Checkout");
	  		waitForPageLoaded(driver);
	  	}
	  	
	  	/** This Function is used for Product Synonym functionality  store
		 * 
		 * @throws InterruptedException
	  	 * @throws IOException 
	  	 * @throws SAXException 
	  	 * @throws ParserConfigurationException 
		 */
	  	public void createCategorySynonym() throws InterruptedException, ParserConfigurationException, SAXException, IOException
	  	{
	  		Finder locator =new Finder();
	  		fluentwait(locator.findBy("images_imgAjaxLoad"));
	        //fluentwait(locator.findBy("images_imgFailedAjaxLoad"));
	        Thread.sleep(10000L);
	  	  
	  	    String excelCategory =dataTable.getData("General_data","Category");
	        Random randomGenerator = new Random();
	        int randomInt = randomGenerator.nextInt(10000);
	        category=excelCategory+randomInt;
	  		
	  		Actions builder = new Actions(driver);
	  		builder.moveToElement(driver.findElement(locator.findBy("links_lnkButikkMenu"))).click().perform();
	  		waitForPageLoaded(driver);
	  		
	  		try
	  		{
	  		driver.findElement(locator.findBy("links_lnkButikkMenu")).click();
	  		//utils.verifyAndClickLink("links_lnkButikkMenu", "Butikk Menu");
		  	waitForPageLoaded(driver);
	  		}
	  		catch(Exception e)
	  		{
	  		}
	  		
	  		//driver.findElement(locator.findBy("textboxes_txtButtik")).sendKeys("Logica");
	  		utils.verifyAndEnterValueInTextBox("textboxes_txtButtik","Sunnhordland","Butikk");
	  		//driver.findElement(locator.findBy("links_lnkSearch")).click();
	  		utils.verifyAndClickLink("links_lnkSearch", "Search");
	  		waitForPageLoaded(driver);
	  		//driver.findElement(locator.findBy("links_lnkShopVismer")).click();
	  		utils.verifyAndClickLink("links_lnkShopVismer", "Vismer");
            Thread.sleep(3000L);  
	  		//driver.findElement(locator.findBy("buttons_btnEditSynonym")).click();
	  		utils.verifyAndClickButton("buttons_btnEditSynonym", "EditSynonym");
	  		waitForPageLoaded(driver);
	  		
	  		List<WebElement> MobBrands = driver.findElements(locator.findBy("links_lnkMobileBrands"));
	  		int counter = 1;
	  		
	  		for(WebElement element:MobBrands)
	  		{
	  			String test = element.getText().trim();
	  			if(test.equals(dataTable.getData("General_Data", "MobileModel")))
	  			{
	  				WebElement Alias =driver.findElement(findByDynXpath(locator.findBy("textboxes_txtSynonymLevel2"),String.valueOf(counter)));
	  				Alias.clear();
	  				Alias.sendKeys(category);
	  		  		//driver.findElement(locator.findBy("textboxes_txtSynonymLevel2")).sendKeys(category);
	  		  		//utils.verifyAndEnterValueInTextBox("textboxes_txtSynonymLevel2",category,"SynonymLevel2");
	  		  		JavascriptExecutor jsx = (JavascriptExecutor)driver;
	  				jsx.executeScript("window.scrollBy(0,450)", "");
	  			}
	  			counter++;
	  		}
	  		
	  		
			//driver.findElement(locator.findBy("buttons_btnSaveChanges")).click();	
			utils.verifyAndClickButton("buttons_btnSaveChanges","Save");	  		
	  		Thread.sleep(1000L);
	  		//driver.findElement(locator.findBy("textboxes_txtButtik")).sendKeys("Logica");
	  		utils.verifyAndEnterValueInTextBox("textboxes_txtButtik","Sunnhordland","Butikk");
	  		//driver.findElement(locator.findBy("links_lnkSearch")).click();
	  		utils.verifyAndClickLink("links_lnkSearch", "Search");
	  		waitForPageLoaded(driver);
	  		//driver.findElement(locator.findBy("links_lnkShopVismer")).click();
	  		utils.verifyAndClickLink("links_lnkShopVismer", "Vismer");
            Thread.sleep(3000L);  
	  		//driver.findElement(locator.findBy("buttons_btnUpdaterButikk")).click();
            utils.verifyAndClickButton("buttons_btnUpdaterButikk", "Update Butikk");
	  		waitForPageLoaded(driver);
	  		
	  		boolean updateStoreSuccess = driver.findElement(locator.findBy("textboxes_txtSuccessMessage")).getText().equals("Oppdatering vellykket.");
	  		
	  		if (updateStoreSuccess)
				report.updateTestLog("Product Synonym for Store", "Product synonym created successful",Status.PASS); else
			  	report.updateTestLog("Product Synonym for Store", "Product synonym not created successful",Status.FAIL);
	  		
	  	}
	  	
	  	/** This Function is used for Product search in B2B  store
		 * 
		 * @throws InterruptedException
	  	 * @throws IOException 
	  	 * @throws SAXException 
	  	 * @throws ParserConfigurationException 
		 */
	  	public void searchB2B() throws InterruptedException, ParserConfigurationException, SAXException, IOException
	  	{
	  		Finder locator =new Finder();
	  		//driver.findElement(locator.findBy("textboxes_txtB2BSearchInput")).sendKeys(category);
	  		utils.verifyAndEnterValueInTextBox("textboxes_txtB2BSearchInput",category,"Butikk");
	  		//driver.findElement(locator.findBy("textboxes_txtB2BSearchClick")).click();
	  		utils.verifyAndClickLink("textboxes_txtB2BSearchClick", "Search");
	  		waitForPageLoaded(driver);
	  		
	  		int counter = 1;
		  	  List <WebElement> searchProductsNo = driver.findElements(locator.findBy("textboxes_txtB2BSearchProdCount"));
		  	  for (WebElement Products:searchProductsNo)
		  	  {
		  		 if(Products.getText().trim().startsWith(dataTable.getData("General_Data", "MobileModel")))
		  		 counter++;
		  	  }
		  	  if((counter-1)==searchProductsNo.size())
		  		report.updateTestLog("Product Synonym search in Store", "Product synonym search successful",Status.PASS); else
				report.updateTestLog("Product Synonym search in Store", "Product synonym search not successful",Status.FAIL);
	  	}
	  	
	  	/** This Function is used for select a mobile based on input in datatable
		 * 
		 * @throws InterruptedException
	  	 * @throws IOException 
	  	 * @throws SAXException 
	  	 * @throws ParserConfigurationException 
		 */
	  	
	  	public void selectMobile() throws InterruptedException, ParserConfigurationException, SAXException, IOException
	  	{
	  		Finder locator =new Finder();
	  		List<WebElement> element = driver.findElements(locator.findBy("textboxes_txtMobileList"));
		  	  int counter =1;
		  	  for(WebElement mobileText: element)
		  	  {
		  		  if(mobileText.getText().trim().equals(dataTable.getData("General_data", "MobileName").trim()))
		  		  {
			  		  WebElement mobiles =driver.findElement(findByDynXpath(locator.findBy("buttons_btnSelectCorrectProduct"),String.valueOf(counter)));
			  		  mobiles.click();
			  		  waitForPageLoaded(driver);
			          break;		  
		  		  }
		  		  else
		  		  {
		  			  counter++;
		  		  }
		  	  }
	  	}
	  	
	  	/** This Function is used for checking cost price in shop
		 * 
		 * @throws InterruptedException
	  	 * @throws IOException 
	  	 * @throws SAXException 
	  	 * @throws ParserConfigurationException 
		 */
	  	public void checkCostPurchaseLimit() throws InterruptedException, ParserConfigurationException, SAXException, IOException
	  	{
	  		Finder locator =new Finder();
	  		for (int i=0;i<5;i++)
	  		{
	  			try
	  			{
	  				boolean Error1 = driver.findElement(locator.findBy("textboxes_txtProductLimitError1")).getText().trim().equals(dataTable.getData("General_Data", "ErrorMsg1").trim());
	  				boolean Error5 = driver.findElement(locator.findBy("textboxes_txtProductLimitError2")).getText().trim().equals(dataTable.getData("General_Data", "ErrorMsg5").trim());
	  				if(Error1&&Error5)
	  				{
	  					report.updateTestLog("Purchase Mobile Cost Limit check", "Mobile Cost Limit check is successful and error message is as expected",Status.PASS); 
	  					break;
	  				}else
	  					report.updateTestLog("Purchase Mobile Cost Limit check", "Mobile Cost Limit check is unsuccessful and error message is not as expected",Status.FAIL);
	  				
	  			}
	  			catch(Exception e)
	  			{
	  				e.printStackTrace();
	  			}
	  			utils.verifyAndClickLink("links_lnkProductName","Product Name");
	  			waitForPageLoaded(driver);
	  			clickOnAddToBasket();
	  		}
	  	}
	  	
	  	
	  	public void orderApprovalLevel1() throws ParserConfigurationException, SAXException, IOException, InterruptedException
	  	{
	  		Finder locator =new Finder();
	  		
	  		utils.verifyAndClickLink("links_lnkApproveorder" , "Approve Order");
	  		waitForPageLoaded(driver);
	  		utils.verifyAndClickLink("links_lnkListOrderNo" , "Select Order For Approval");					
	  		String orderNo = hm.get("orderNumber");
	  		//String[] splits = orderNo.split("A");
	  		//hashmap.put("orderNumber", splits[0].trim());
	  		//System.out.println(splits[0]);
            boolean orderApproval = driver.findElement(locator.findBy("links_lnkListOrderNo1")).getText().equals(orderNo );
	  		
	  		if (!orderApproval)
	  			//utils.verifyAndClickButton("buttons_btnHapiHapi", "Happi");
	  			
	  			report.updateTestLog("Created Order Not displayed", "In Order Approval page",Status.FAIL);
	  		else
	  			driver.findElement(locator.findBy("textboxes_txtApproveorder")).sendKeys(dataTable.getData("General_Data", "Comments"));
  			    utils.verifyAndClickButton("buttons_btnApproveorder" , "Approve Order");
			    report.updateTestLog("Created Order is displayed" , "In Order Approval page and Approved successfully",Status.PASS);	
	  		
	  	}
			
	  	public void orderRejectionLevel1() throws ParserConfigurationException, SAXException, IOException, InterruptedException
	  	{
	  		Finder locator =new Finder();
	  		
	  		utils.verifyAndClickLink("links_lnkApproveorder" , "Reject Order");
	  		waitForPageLoaded(driver);
	  		utils.verifyAndClickLink("links_lnkListOrderNo" , "Select Order For Rejection");					
	  		String orderNo = hm.get("orderNumber");
            boolean orderApproval = driver.findElement(locator.findBy("links_lnkListOrderNo1")).getText().equals(orderNo);
	  		
	  		if (!orderApproval)
	  			//utils.verifyAndClickButton("buttons_btnHapiHapi", "Happi");
	  			
	  			report.updateTestLog("Created Order Not displayed", "In Order Approval page",Status.FAIL);
	  		else
	  			driver.findElement(locator.findBy("textboxes_txtApproveorder")).sendKeys(dataTable.getData("General_Data", "Comments"));
  			    utils.verifyAndClickButton("buttons_btnRejectorder" , "Reject Order");
			    report.updateTestLog("Created Order is displayed" , "In Order Approval page and Rejected successfully",Status.PASS);	
	  		
	  	}
			
	  	
	  	public void createB2BUsersSetUpAdminRole() throws ParserConfigurationException, SAXException, IOException, InterruptedException
	  	{
	  		Finder locator =new Finder();
	  		Random randomGenerator = new Random();
	  		int randomInt2 = randomGenerator.nextInt(100000);
	  	    driver.findElement(locator.findBy("links_lnkAnsatte")).click();
	  		waitForPageLoaded(driver);
	  		
	  		driver.findElement(locator.findBy("links_lnkCreateUser")).click();
	  		waitForPageLoaded(driver);
	  		
	  		driver.findElement(locator.findBy("textboxes_txtUserFirstName")).sendKeys(dataTable.getData("General_Data", "FirstName")+randomInt2);
	  		driver.findElement(locator.findBy("textboxes_txtUserLastName")).sendKeys(dataTable.getData("General_Data", "LastName"));
	  		driver.findElement(locator.findBy("textboxes_txtUserDOB")).sendKeys(dataTable.getData("General_Data", "DOB"));
	  		driver.findElement(locator.findBy("textboxes_txtUserTelephoneNo")).sendKeys(dataTable.getData("General_Data", "PhoneNo")+randomInt2);
	  		driver.findElement(locator.findBy("textboxes_txtUserEPost")).sendKeys(dataTable.getData("General_Data", "Email"));
			driver.findElement(locator.findBy("textboxes_txtSaveUser")).click();
			
			b2bUser = dataTable.getData("General_Data","FirstName")+randomInt2+" "+dataTable.getData("General_Data", "LastName");
	  		
			List<WebElement> usersList = driver.findElements(locator.findBy("links_lnkListUsersName"));
			int counter =1;
					
			for(WebElement element:usersList)
			{			
				if(element.getText().trim().equals(b2bUser.trim()))
						{
							Thread.sleep(1000L);
							/*WebElement noOfUsers =driver.findElement(findByDynXpath(locator.findBy("checkboxes_chkB2BUsers"),String.valueOf(counter)));
							//JavascriptExecutor jsx = (JavascriptExecutor)driver;
							//jsx.executeScript("window.scrollBy(0,350)", "");
							JavascriptExecutor executor = (JavascriptExecutor)driver;
							executor.executeScript("arguments[0].click();",noOfUsers);*/
							driver.findElement(findByDynXpath(locator.findBy("checkboxes_chkB2BUsers"), String.valueOf(counter))).click();
							break;
						}
			      counter++;		
			}
			
			Thread.sleep(10000L);
			driver.findElement(locator.findBy("listboxes_lstSelectUserPreferences")).click();
			Thread.sleep(4000L);
			driver.findElement(locator.findBy("textboxes_txtUsersAdminRights")).click();
			Thread.sleep(5000L);
			Alert alert = driver.switchTo().alert();
			alert.accept();
			waitForPageLoaded(driver);
					
	  	}
	  	
	  	public void createB2BUsersSetUpBrukerRole() throws ParserConfigurationException, SAXException, IOException, InterruptedException
	  	{
	  		Finder locator =new Finder();
	  		Random randomGenerator = new Random();
	  		int randomInt2 = randomGenerator.nextInt(100000);
	  	    driver.findElement(locator.findBy("links_lnkAnsatte")).click();
	  		waitForPageLoaded(driver);
	  		
	  		driver.findElement(locator.findBy("links_lnkCreateUser")).click();
	  		waitForPageLoaded(driver);
	  		
	  		driver.findElement(locator.findBy("textboxes_txtUserFirstName")).sendKeys(dataTable.getData("General_Data", "FirstName")+randomInt2);
	  		driver.findElement(locator.findBy("textboxes_txtUserLastName")).sendKeys(dataTable.getData("General_Data", "LastName"));
	  		driver.findElement(locator.findBy("textboxes_txtUserDOB")).sendKeys(dataTable.getData("General_Data", "DOB"));
	  		driver.findElement(locator.findBy("textboxes_txtUserTelephoneNo")).sendKeys(dataTable.getData("General_Data", "PhoneNo")+randomInt2);
	  		driver.findElement(locator.findBy("textboxes_txtUserEPost")).sendKeys(dataTable.getData("General_Data", "Email"));
			driver.findElement(locator.findBy("textboxes_txtSaveUser")).click();
			
			b2bUser = dataTable.getData("General_Data","FirstName")+randomInt2+" "+dataTable.getData("General_Data", "LastName");
	  		
			List<WebElement> usersList = driver.findElements(locator.findBy("links_lnkListUsersName"));
			int counter =1;
					
			for(WebElement element:usersList)
			{			
				if(element.getText().trim().equals(b2bUser.trim()))
						{
							Thread.sleep(1000L);
							/*WebElement noOfUsers =driver.findElement(findByDynXpath(locator.findBy("checkboxes_chkB2BUsers"),String.valueOf(counter)));
							//JavascriptExecutor jsx = (JavascriptExecutor)driver;
							//jsx.executeScript("window.scrollBy(0,350)", "");
							JavascriptExecutor executor = (JavascriptExecutor)driver;
							executor.executeScript("arguments[0].click();",noOfUsers);*/
							driver.findElement(findByDynXpath(locator.findBy("checkboxes_chkB2BUsers"), String.valueOf(counter))).click();
							break;
						}
			      counter++;		
			}
			
			Thread.sleep(10000L);
			driver.findElement(locator.findBy("listboxes_lstSelectUserPreferences")).click();
			Thread.sleep(4000L);
			driver.findElement(locator.findBy("textboxes_txtUsersBrukerRights")).click();
			Thread.sleep(5000L);
			Alert alert = driver.switchTo().alert();
			alert.accept();
			waitForPageLoaded(driver);
					
	  	}
	  	
	  	public void createB2BUsersSetUpBowseOnlyRole() throws ParserConfigurationException, SAXException, IOException, InterruptedException
	  	{
	  		Finder locator =new Finder();
	  		Random randomGenerator = new Random();
	  		int randomInt2 = randomGenerator.nextInt(100000);
	  	    driver.findElement(locator.findBy("links_lnkAnsatte")).click();
	  		waitForPageLoaded(driver);
	  		
	  		driver.findElement(locator.findBy("links_lnkCreateUser")).click();
	  		waitForPageLoaded(driver);
	  		
	  		driver.findElement(locator.findBy("textboxes_txtUserFirstName")).sendKeys(dataTable.getData("General_Data", "FirstName")+randomInt2);
	  		driver.findElement(locator.findBy("textboxes_txtUserLastName")).sendKeys(dataTable.getData("General_Data", "LastName"));
	  		driver.findElement(locator.findBy("textboxes_txtUserDOB")).sendKeys(dataTable.getData("General_Data", "DOB"));
	  		driver.findElement(locator.findBy("textboxes_txtUserTelephoneNo")).sendKeys(dataTable.getData("General_Data", "PhoneNo")+randomInt2);
	  		driver.findElement(locator.findBy("textboxes_txtUserEPost")).sendKeys(dataTable.getData("General_Data", "Email"));
			driver.findElement(locator.findBy("textboxes_txtSaveUser")).click();
			
			b2bUser = dataTable.getData("General_Data","FirstName")+randomInt2+" "+dataTable.getData("General_Data", "LastName");
	  		
			List<WebElement> usersList = driver.findElements(locator.findBy("links_lnkListUsersName"));
			int counter =1;
					
			for(WebElement element:usersList)
			{			
				if(element.getText().trim().equals(b2bUser.trim()))
						{
							Thread.sleep(1000L);
							/*WebElement noOfUsers =driver.findElement(findByDynXpath(locator.findBy("checkboxes_chkB2BUsers"),String.valueOf(counter)));
							//JavascriptExecutor jsx = (JavascriptExecutor)driver;
							//jsx.executeScript("window.scrollBy(0,350)", "");
							JavascriptExecutor executor = (JavascriptExecutor)driver;
							executor.executeScript("arguments[0].click();",noOfUsers);*/
							driver.findElement(findByDynXpath(locator.findBy("checkboxes_chkB2BUsers"), String.valueOf(counter))).click();
							break;
						}
			      counter++;		
			}
			
			Thread.sleep(10000L);
			driver.findElement(locator.findBy("listboxes_lstSelectUserPreferences")).click();
			Thread.sleep(4000L);
			driver.findElement(locator.findBy("textboxes_txtUsersFellesBrukerRights")).click();
			Thread.sleep(5000L);
			Alert alert = driver.switchTo().alert();
			alert.accept();
			waitForPageLoaded(driver);
					
	  	}
	  	
	  	public void createB2BUsersSetUpAnsattRole() throws ParserConfigurationException, SAXException, IOException, InterruptedException
	  	{
	  		Finder locator =new Finder();
	  		Random randomGenerator = new Random();
	  		int randomInt2 = randomGenerator.nextInt(100000);
	  	    driver.findElement(locator.findBy("links_lnkAnsatte")).click();
	  		waitForPageLoaded(driver);
	  		
	  		driver.findElement(locator.findBy("links_lnkCreateUser")).click();
	  		waitForPageLoaded(driver);
	  		
	  		driver.findElement(locator.findBy("textboxes_txtUserFirstName")).sendKeys(dataTable.getData("General_Data", "FirstName")+randomInt2);
	  		driver.findElement(locator.findBy("textboxes_txtUserLastName")).sendKeys(dataTable.getData("General_Data", "LastName"));
	  		driver.findElement(locator.findBy("textboxes_txtUserDOB")).sendKeys(dataTable.getData("General_Data", "DOB"));
	  		driver.findElement(locator.findBy("textboxes_txtUserTelephoneNo")).sendKeys(dataTable.getData("General_Data", "PhoneNo")+randomInt2);
	  		driver.findElement(locator.findBy("textboxes_txtUserEPost")).sendKeys(dataTable.getData("General_Data", "Email"));
			driver.findElement(locator.findBy("textboxes_txtSaveUser")).click();
			
			b2bUser = dataTable.getData("General_Data","FirstName")+randomInt2+" "+dataTable.getData("General_Data", "LastName");
	  		
			List<WebElement> usersList = driver.findElements(locator.findBy("links_lnkListUsersName"));
			int counter =1;
					
			for(WebElement element:usersList)
			{			
				if(element.getText().trim().equals(b2bUser.trim()))
						{
							Thread.sleep(1000L);
							/*WebElement noOfUsers =driver.findElement(findByDynXpath(locator.findBy("checkboxes_chkB2BUsers"),String.valueOf(counter)));
							//JavascriptExecutor jsx = (JavascriptExecutor)driver;
							//jsx.executeScript("window.scrollBy(0,350)", "");
							JavascriptExecutor executor = (JavascriptExecutor)driver;
							executor.executeScript("arguments[0].click();",noOfUsers);*/
							driver.findElement(findByDynXpath(locator.findBy("checkboxes_chkB2BUsers"), String.valueOf(counter))).click();
							break;
						}
			      counter++;		
			}
			
			Thread.sleep(10000L);
			driver.findElement(locator.findBy("listboxes_lstSelectUserPreferences")).click();
			Thread.sleep(4000L);
			driver.findElement(locator.findBy("textboxes_txtUsersAnsattRights")).click();
			Thread.sleep(5000L);
			Alert alert = driver.switchTo().alert();
			alert.accept();
			waitForPageLoaded(driver);
					
	  	}
	  	public void b2BUsersSetUpOrderAprroval() throws ParserConfigurationException, SAXException, IOException, InterruptedException
	  	{
	  		Finder locator =new Finder();
	  		List<WebElement> usersList = driver.findElements(locator.findBy("links_lnkListUsersName"));
			int counter =1;
			
			for(WebElement element:usersList)
			{
				if(element.getText().trim().equals(b2bUser.trim()))
						{
					 WebElement usersCheck =driver.findElement(findByDynXpath(locator.findBy("checkboxes_chkB2BUsers"),String.valueOf(counter)));
					 usersCheck.click();
					 Thread.sleep(4000L);
			  		 break;	
				}
			       counter++;		
			}
			
			
			driver.findElement(locator.findBy("listboxes_lstSelectChangePermissions")).click();
			Thread.sleep(4000L);
			driver.findElement(locator.findBy("textboxes_txtUsersOrderAuthorize")).click();
			Thread.sleep(3000L);
			Alert alert = driver.switchTo().alert();
			alert.accept();
			waitForPageLoaded(driver);
					
	  	}
	  	
		public void b2BUsersSetUpOrderAprrovalLeve2() throws ParserConfigurationException, SAXException, IOException, InterruptedException
	  	{
	  		Finder locator =new Finder();
	  		List<WebElement> usersList = driver.findElements(locator.findBy("links_lnkListUsersName"));
			int counter =1;
			
			for(WebElement element:usersList)
			{
				if(element.getText().trim().equals(b2bUser.trim()))
						{
					 WebElement usersCheck =driver.findElement(findByDynXpath(locator.findBy("checkboxes_chkB2BUsers"),String.valueOf(counter)));
					 usersCheck.click();
					 Thread.sleep(4000L);
			  		 break;	
				}
			       counter++;		
			}
			
			
			driver.findElement(locator.findBy("listboxes_lstSelectChangePermissions")).click();
			Thread.sleep(4000L);
			driver.findElement(locator.findBy("textboxes_txtUsersOrderAuthorizeLevel2")).click();
			Thread.sleep(3000L);
			Alert alert = driver.switchTo().alert();
			alert.accept();
			waitForPageLoaded(driver);
					
	  	}
}
