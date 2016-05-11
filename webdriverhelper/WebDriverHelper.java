/*
 * Class contains methods to help web driver instance and other utility methods
 * @author - Cognizant Automation Team
 * Sep 2012
 */
package webdriverhelper;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Set;
import javax.xml.parsers.ParserConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.xml.sax.SAXException;

import com.cognizant.framework.Status;

import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;

public class WebDriverHelper extends ReusableLibrary {

		
	/**
	 * Instantiates a new WebDriverHelper.
	 * @param webDriver
	 * @param detailedReport
	 * @param logText
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public WebDriverHelper(ScriptHelper scriptHelper) {
		super(scriptHelper);    	
		
	}	
	

	/**
	 * Method helps to wait for time passed.
	 *
	 * @param time - time.
	 */
	public void wait(int time) {
		//logger.info(logText+" Started wait method");
		int minute,second,times,seconds,minutes,myseconds,myminute,mysecond,myminutes;

		Calendar calendar = new GregorianCalendar();
		minute = calendar.get(Calendar.MINUTE);
		second = calendar.get(Calendar.SECOND);
		minutes = minute * 60;
		seconds = minutes + second;
		times = seconds + time;
		myseconds = 0;
		while (times != myseconds) {
			Calendar calendars = new GregorianCalendar();
			myminute = calendars.get(Calendar.MINUTE);
			mysecond = calendars.get(Calendar.SECOND);
			myminutes = myminute * 60;
			myseconds = myminutes + mysecond;
		}
		//logger.info(logText+" Ended wait method");
	}

	/**
	 * Gets the current method name being executed.
	 *
	 * @return the current method name being executed.
	 */
	public String currentMethodName() {
		//logger.info(logText+" Started current method name");
		//String classNameMethodName = this.getClass().getName()+"."+ new Exception().getStackTrace()[0].getMethodName();
		String classNameMethodName = this.getClass().getName()+".";
		//logger.info(logText+" Ended current method name");
		return classNameMethodName;
	}
	
	/**
	 * Helps to focus on the current window.
	 */
	public void windowFocus() {
		
		((JavascriptExecutor) driver).executeScript("window.focus();");
		driver.manage().window().maximize();
	}

	/**
	 * Helps to focus on the current window using window Co-Ordinates.
	 * @throws InterruptedException 
	 */
	public void corWindowFocus() throws InterruptedException {
		//logger.info(logText+" Started focusing window");
		((JavascriptExecutor) driver).executeScript("window.focus();");
	     driver.manage().window().maximize();
		((JavascriptExecutor) driver).executeScript("window.focus();");
		driver.manage().window().maximize();		
		Point targetPosition = new Point(0, 0);
		driver.manage().window().setPosition(targetPosition);
		String w = "return screen.availWidth";
		String h = "return screen.availHeight";
		int width = ((Long)((JavascriptExecutor)driver).executeScript(w)).intValue();
		int height = ((Long)((JavascriptExecutor)driver).executeScript(h)).intValue();
		Dimension targetSize = new Dimension(width, height);
		driver.manage().window().setSize(targetSize);
		//Thread.sleep(10000);		//Waits for control to switch to either top window/ iframe before maximising. 
		//logger.info(logText+" Ended focusing window");
	}

	/**
	 * Method executes implicit wait.
	 */
	/*public void implWait() {
		//logger.info(logText+" Started waiting for 60 seconds");
		//try	{
		driver.manage().timeouts().implicitlyWait(Integer.valueOf(configMap.get("ImplicitWaitinSeconds")), TimeUnit.SECONDS);  
		/*	} catch(Exception e) {
			ExceptionHandlerUtils.exceptionLogger(objWebDriver, objDetailedReport, logText +" Error in implWait method: \n", e);
		}*/
		//logger.info(logText+" Ended waiting for 60 seconds");
	//}*/

	/**
	 * Switches the control to old window.
	 *
	 * @param oldHandler - the old window handle.
	 * @throws InterruptedException
	 */
	public void switchBacktoOldWindow(String oldHandler)throws InterruptedException {
		//logger.info(logText+" Started switching back to old window");
		driver.switchTo().window(oldHandler);
		Thread.sleep(2000);		//Waits for control to switch to either top window/ iframe before maximising. 
		driver.manage().window().maximize();
		//logger.info(logText+" Ended switching back to old window");
	}

	/**
	 * Switches control to new window.
	 *
	 * @param oldHandler - the old window handle.
	 * @throws InterruptedException 
	 */
	public void switchtoNewWindow(String oldHandler) throws InterruptedException {
		//logger.info(logText+" Started switching to new window");
		String popupHandle;

		Set<String> s = driver.getWindowHandles();
		Iterator<String> ite = s.iterator();
		while (ite.hasNext()) {
			popupHandle = ite.next().toString();
			if (!popupHandle.contains(oldHandler)) {
				driver.switchTo().window(popupHandle);
				windowFocus();
			}
		}
		//logger.info(logText+" Ended switching to new window");
	}

	/**
	 * Opens a new window.
	 *
	 * @param url - the URL to be opened.
	 * @throws InterruptedException the interrupted exception.
	 */
	public void openNewwindow(String url) throws InterruptedException {
		//logger.info(logText+" Started Opening new window");
		String oldHandler;

		oldHandler=driver.getWindowHandle();
		((JavascriptExecutor)driver).executeScript("window.open()");    
		Thread.sleep(10000);		//Waits to open a new window so that control can switch to newly opned window
		switchtoNewWindow(oldHandler);
		driver.navigate().to(url);
		driver.manage().window().maximize();
		//logger.info(logText+" Ended Opening new window");
	}

	/**
	 * Clicks web element.
	 *
	 * @param strLinkIdentifier - the XPath of the web element to be clicked.
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public void click(String strLinkIdentifier) throws ParserConfigurationException, SAXException, IOException {	
		//logger.info(logText+" Started click operation");
		WebElement element;
		Finder locator = new Finder(); 

		try {
			element =driver.findElement(locator.findBy(strLinkIdentifier));
			element.click();			
			report.updateTestLog("Should click <b>" + strLinkIdentifier
					+ "</b> web element.", "<b>" + strLinkIdentifier+ "</b> web element clicked.",Status.PASS);
		} catch(NoSuchElementException nse) {
			report.updateTestLog("Error in clicking the web element:"+ strLinkIdentifier ,nse.getClass().getName(),Status.FAIL);
		} catch(Exception e) {
			report.updateTestLog("Error in clicking the web element:"+ strLinkIdentifier ,e.getClass().getName(),Status.FAIL);
		}
		//logger.info(logText+" Ended click operation");
	}

	/**
	 * Custom click uses javascript executor to click on web element.
	 *
	 * @param itemLocator - the XPath of the web element to be clicked.
	 */
	public void customClick(String itemLocator) {
		//logger.info(logText+" Started customClick operation based on locator");
		WebElement element;

		try {		
			element = driver.findElement(By.xpath(itemLocator));  
			((JavascriptExecutor)driver).executeScript("var evt = document.createEvent('MouseEvents');" +
					"evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" +
					"arguments[0].dispatchEvent(evt);", element);
			report.updateTestLog("Should click web element.","Web element clicked.", Status.PASS);
		} catch(NoSuchElementException nse) {			
			report.updateTestLog("Error in clicking the web element.",nse.getClass().getName(),Status.FAIL);
		} catch(Exception e) {			
			report.updateTestLog("Error in clicking the web element.",e.getClass().getName(), Status.FAIL);
		}	
		//logger.info(logText+" Ended customClick operation based on locator");
	}
	/**
	 * Custom click uses javascript executor to click on web element (locator values i.e. XPath not got from UI mappings file the XPath is passed).
	 *
	 * @param WebElement - web element to be clicked.
	 */
	public void customClick(WebElement element) {
		//logger.info(logText+" Started customClick operation based on web element");

		try {		
			((JavascriptExecutor)driver).executeScript("var evt = document.createEvent('MouseEvents');" +
					"evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" +
					"arguments[0].dispatchEvent(evt);", element);			
			report.updateTestLog("Should click web element.", "Web element clicked.", Status.PASS);
		} catch(NoSuchElementException nse) {			
			report.updateTestLog("Error in clicking the web element.",nse.getClass().getName(), Status.FAIL);
		} catch(Exception e) {			
			report.updateTestLog("Error in clicking the web element.",e.getClass().getName(), Status.FAIL);
		}
		//logger.info(logText+" Ended customClick operation based on web element");
	}
	/**
	 * Custom click uses javascript executor to click on web element (locator values i.e. XPath not got from UI mappings file the XPath is passed).
	 *
	 * @param itemLocator - the locator/XPath of the web element to be clicked.
	 */
	public void customClickNoUIMap(String itemLocator) {
		//logger.info(logText+" Started customClickNoUIMap ");
		WebElement element;

		try {		
			element = driver.findElement(By.xpath(itemLocator));  			
			((JavascriptExecutor)driver).executeScript("var evt = document.createEvent('MouseEvents');" +
					"evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" +
					"arguments[0].dispatchEvent(evt);", element);			
			report.updateTestLog("Should click web element.", "Web element clicked.", Status.PASS);
		} catch(NoSuchElementException nse) {			
			report.updateTestLog("Error in clicking the web element.",nse.getClass().getName(), Status.FAIL);
		} catch(Exception e) {			
			
			report.updateTestLog("Error in clicking the web element.",e.getClass().getName(), Status.FAIL);
		}
		//logger.info(logText+" Ended customClickNoUIMap ");
	}

	/**
	 * Custom click uses javascript executor to click on web element.
	 *
	 * @param itemLocator - the XPath of the web element to be clicked.
	 * @param label - the label of the web element to be clicked.
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public void customClickJSE(String itemLocator,String label) throws ParserConfigurationException, SAXException, IOException {

		WebElement element;
		Finder locator = new Finder(); 
		//logger.info(logText+" Started customClickJSE using java script executor");
		try {		
			element = driver.findElement(locator.findBy(itemLocator));  
			((JavascriptExecutor)driver).executeScript("var evt = document.createEvent('MouseEvents');" +
					"evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" +
					"arguments[0].dispatchEvent(evt);", element);	
			report.updateTestLog("Should click <b>"+label+"</b> element.", "<b>"+label+"</b> element clicked.", Status.PASS);	
		} catch(NoSuchElementException nse) {			
			report.updateTestLog("Error in clicking the <b>"+label+"</b> element.",nse.getClass().getName(), Status.FAIL);
		} catch(Exception e) {			
			report.updateTestLog("Error in clicking the <b>"+label+"</b> element.",e.getClass().getName(), Status.FAIL);
		}
		//logger.info(logText+" Ended customClick using java script executor");
	}

	/**
	 * Custom click uses javascript executor to click on web element (locator values i.e. XPath not got from UI mappings file the XPath is passed).
	 *
	 * @param itemLocator - the XPath of the web element to be clicked.
	 * @param label - the label of the web element to be clicked.
	 */
	public void customClickNoUIMapJSE(String itemLocator, String label) {
		//logger.info(logText+" Started customClickNoUIMap using java script executor");
		this.customClickNoUIMapJSEb(itemLocator, label);
		//logger.info(logText+" Ended customClickNoUIMap using java script executor");
		//		WebElement element;
		//		
		//		try {
		//			element = objWebDriver.findElement(By.xpath(itemLocator));  
		//			((JavascriptExecutor)objWebDriver).executeScript("var evt = document.createEvent('MouseEvents');" +
		//					"evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" +
		//					"arguments[0].dispatchEvent(evt);", element);	
		//			report.updateTestLog(Status.PASS, "Should click <b>"+label+"</b> element.", "<b>"+label+"</b> element clicked.", objWebDriver);	
		//		} catch(NoSuchElementException nse) {			
		//			ExceptionHandlerUtils.exceptionLogger(objWebDriver, objDetailedReport, logText +" Error in customClickNoUIMapJSE method: \n", nse);
		//			report.updateTestLog(Status.FAIL,"Error in clicking the <b>"+label+"</b> element.",nse.getClass().getName(), objWebDriver);
		//		} catch(Exception e) {			
		//			ExceptionHandlerUtils.exceptionLogger(objWebDriver, objDetailedReport, logText +" Error in customClickNoUIMapJSE method: \n", e);
		//			report.updateTestLog(Status.FAIL,"Error in clicking the <b>"+label+"</b> element.",e.getClass().getName(), objWebDriver);
		//		}
	}
	/**
	 * 
	 * @param itemLocator
	 * @param itemLocator - the XPath of the web element to be clicked.
	 * @param label - the label of the web element to be clicked.
	 * @return true or false
	 */
	public boolean customClickNoUIMapJSEb(String itemLocator, String label) {
		//logger.info(logText+" Started customClickNoUIMapJSEb using java script executor");
		WebElement element;

		try {
			element = driver.findElement(By.xpath(itemLocator));  
			((JavascriptExecutor)driver).executeScript("var evt = document.createEvent('MouseEvents');" +
					"evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" +
					"arguments[0].dispatchEvent(evt);", element);	
			report.updateTestLog("Should click <b>"+label+"</b> element.", "<b>"+label+"</b> element clicked.", Status.PASS);
			return true;
		} catch(NoSuchElementException nse) {			
			
			report.updateTestLog("Error in clicking the <b>"+label+"</b> element.",nse.getClass().getName(), Status.FAIL);
			return false;
		} catch(Exception e) {			
			report.updateTestLog("Error in clicking the <b>"+label+"</b> element.",e.getClass().getName(), Status.FAIL);
			return false;

		}

	}
	/**
	 * Custom double click uses javascript executor to double click on web element.
	 *
	 * @param element - web element to be double clicked.
	 */
	public void customDoubleClick(WebElement element) {
		//logger.info(logText+" Started customDoubleClick based on web element");
		try {

			((JavascriptExecutor)driver).executeScript("var evt = document.createEvent('MouseEvents');" +
					"evt.initMouseEvent('dblclick',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" +
					"arguments[0].dispatchEvent(evt);", element);
			report.updateTestLog("Should double click web element.", "Web element double clicked.", Status.PASS);	
		} catch(NoSuchElementException nse) {			
			
			report.updateTestLog("Error in double clicking the web element.",nse.getClass().getName(), Status.FAIL);
		} catch(Exception e) {			
			report.updateTestLog("Error in double clicking the web element.",e.getClass().getName(), Status.FAIL);
		}
		//logger.info(logText+" Ended customDoubleClick based on web element");
	}

	/**
	 * Custom double click uses javascript executor to double click on web element.
	 *
	 * @param itemLocator - the locator/XPath of the web element to be double clicked.
	 */
	public void customDoubleClick(String itemLocator) {
		//logger.info(logText+" Started customDoubleClick based on locator");
		WebElement element;

		try {
			element = driver.findElement(By.xpath(itemLocator));        
			((JavascriptExecutor)driver).executeScript("var evt = document.createEvent('MouseEvents');" +
					"evt.initMouseEvent('dblclick',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" +
					"arguments[0].dispatchEvent(evt);", element);
			report.updateTestLog("Should double click web element.", "Web element double clicked.", Status.PASS);	
		} catch(NoSuchElementException nse) {			
			report.updateTestLog("Error in double clicking the web element.",nse.getClass().getName(), Status.FAIL);
		} catch(Exception e) {			
	    report.updateTestLog("Error in double clicking the web element.",e.getClass().getName(), Status.FAIL);
		}
		//logger.info(logText+" Ended customDoubleClick based on locator");
	}

	/**
	 * Custom right click uses javascript executor to right click on web element.
	 *
	 * @param itemLocator - the locator/XPath of the web element to be right clicked.
	 */
	public void customRightClick(String itemLocator) {

		WebElement element;
		//logger.info(logText+" Started customRightClick based on locator");
		try {
			element = driver.findElement(By.xpath(itemLocator));        
			((JavascriptExecutor)driver).executeScript("var evt = document.createEvent('MouseEvents');" +
					"evt.initMouseEvent('contextmenu',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" +
					"arguments[0].dispatchEvent(evt);", element);
			report.updateTestLog("Should right click web element.", "Web element right clicked.", Status.PASS);	
		} catch(NoSuchElementException nse) {			
			
			//report.updateTestLog(Status.FAIL,"Error in right clicking the web element.",nse.getClass().getName(), objWebDriver);
		} catch(Exception e) {			
			report.updateTestLog("Error in right clicking the web element.",e.getClass().getName(), Status.FAIL);
		}
		//logger.info(logText+" Ended customRightClick based on locator");
	}

	/**
	 * Double click a web element using action builder.
	 *
	 * @param locator - the locator of the web element to be double clicked.
	 */
	public void doubleClick(String locator) {
		//logger.info(logText+" Started doubleClick based on locator");
		WebElement element;
		Actions hold;

		element = driver.findElement(By.xpath(locator));
		hold = new Actions(driver);
		hold.doubleClick(element).perform();
		report.updateTestLog("Should double click web element.", "Web element double clicked.", Status.PASS);	
		//logger.info(logText+" Ended doubleClick based on locator");
	}

	/**
	 * Mouse click uses action builder to click on a web element.
	 *
	 * @param locator - the locator of the web element to be clicked.
	 * @param element - the element name / label.
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public void mouseClick(String locator, String element) throws ParserConfigurationException, SAXException, IOException {
		//logger.info(logText+" Started mouseClick based on locator and element");
		//try {
		Actions builder;
		WebElement newButton;
		Action clk;
		Finder locatr = new Finder();
		builder= new Actions(driver);
		newButton = driver.findElement(locatr.findBy(locator));
		clk = builder.moveToElement(newButton,5,5).click().build();
		clk.perform();
		report.updateTestLog("Should click  <b>" + element
				+ "</b> . ", "  <b>" + element+ "</b> clicked. ", Status.PASS);
		}
	

	/**
	 * clicks directly a web element.
	 *
	 * @param element - the web element.
	 * @param label - the web element name /label.
	 */
	public void clickElement(WebElement element, String label){
		//logger.info(logText+" Started clicking on element");
		//	try{
		Actions builder;
		Action clk;

		builder= new Actions(driver);
		clk = builder.moveToElement(element,5,5).click().build();
		clk.perform();
		report.updateTestLog("Should click <b>" + label
				+ "</b>.","<b>"+label+"</b> clicked.", Status.PASS);
		/*	}catch(Exception e){
			ExceptionHandlerUtils.exceptionLogger(objWebDriver, objDetailedReport, logText +" Error in mouseClick method: \n", e);
			report.updateTestLog(Status.FAIL,"Error in clicking the "+ label,e.getClass().getName(), objWebDriver);
		}*/
		//logger.info(logText+" Ended clicking on element");
	}	

	/**
	 *Method uses mouse action to click on a web element.
	 *
	 * @param locator - the locator of the web element.
	 */
	public void clickUsingMouseAction(String locator) {
		//logger.info(logText+" Started click using mouse action");
		Mouse mouse;
		Locatable locElement;
		Coordinates cor;

		mouse = ((HasInputDevices)driver).getMouse();
		locElement = (Locatable)driver.findElement(By.xpath(locator));
		cor= locElement.getCoordinates();
		mouse.mouseMove(cor);
		mouse.mouseDown(cor);
		mouse.mouseUp(cor);				
		report.updateTestLog("Should click web element.", "Web element clicked.", Status.PASS);		
		//logger.info(logText+" Ended click using mouse action");
	}

	/**
	 * Click Show How is meant for identifying which click is appropriate for debugging/ for a corner case where consistency with click is not attained
	 * @param locator
	 * @return return true when element is not getting displayed 
	 */
	public boolean clickSomeHowNoUIMap(String locator)
	{
		//logger.info(logText+" Started clickSomeHowNoUIMap");
		WebElement element =driver.findElement(By.xpath(locator));

		if(element.isDisplayed())
		{
			//logger.info(logText+" Peforming WebElement Click for " +locator );
			element.click();
		}
		else
			return true;

		if(element.isDisplayed())
		{
			//logger.info(logText+" Peforming Click Element using action script for " +locator );
			clickElement(element, locator);
		}
		else
			return true;

		if(element.isDisplayed())
		{
			//logger.info(logText+" Peforming custom Click using Java Script for " +locator );
			customClick(element);
		}
		else
			return true;

		if(element.isDisplayed())
		{
			//logger.info(logText+" Peforming click using mouse action by mousedown and mouseup for " +locator );
			clickUsingMouseAction(locator);
		}
		else
			return true;

		if(element.isDisplayed())
		{
			//logger.info(logText+" Peforming double Click for " +locator );
			doubleClick(locator);
		}
		else{
			return true;
		}
		//logger.info(logText+" Ended clickSomeHowNoUIMap");
		return false;
	}	
}
