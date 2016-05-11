/*
 * Class contains utility methods for radio groups/buttons.
 * @author - Cognizant Automation Team
 * Sep 2012
 *  
 */
package webdriverhelper;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;
import com.cognizant.framework.Status;
import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;

public class RadioGroupUtils extends ReusableLibrary{

	
	/** The logger. */
	//private Logger logger = Logger.getLogger(RadioGroupUtils.class);

	

	
	
	/**
	 * Instantiates a new RadioGroupUtils.
	 *
	 * @param webDriver - The WebDriver instance.
	 * @param detailedReport - The DetailedReport instance.
	 * @param logText
	 * @throws ParserConfigurationException
	 * @throws SAXException 
	 * @throws IOException
	 */
	public RadioGroupUtils(ScriptHelper scriptHelper) {
		super(scriptHelper);    	
			}	

	/**
	 * Verifies and selects the required radio button with value from test data (locator values i.e. XPath got from UI mappings file).
	 *
	 * @param strIdentifier - the locator/XPath of radio group. 
	 * @param labelValue - the label value of radio button to be selected from radio group. 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public void verifyAndSelectRadioGroup(String strIdentifier,String labelValue) throws ParserConfigurationException, SAXException, IOException {
		//logger.info(logText+" Started verifyAndSelectRadioGroup");
		boolean clicked = false;
		List<WebElement> radioItems;
		Finder locator = new Finder();

		try {
			radioItems=driver.findElements(locator.findBy(strIdentifier));
			for(WebElement element:radioItems) {
				if (element.getText().equalsIgnoreCase(labelValue)) {
					element.click();
					report.updateTestLog("Should click on  <b>"+labelValue+"</b>  RadioButton.", "<b>"+labelValue+"</b> RadioButton Clicked.",Status.PASS);
					clicked=true;
					break;
				}								
			}
			if(!clicked) {
				report.updateTestLog("Error in clicking the radio button:"+ labelValue+".",labelValue+" not found in the list.",Status.FAIL);
				}
		} catch(Exception e) {		
			report.updateTestLog("Error in clicking the radio button:"+ labelValue+".",e.getClass().getName(),Status.FAIL);
			//ExceptionHandlerUtils.exceptionLogger(objWebDriver, objDetailedReport, logText +" customListboxSelection Error: \n", e);
			//objDetailedReport.writeLog(Status.FAIL,"Error in clicking the radio button:"+ lableValue+".",e.getClass().getName(), objWebDriver);
		}
		//logger.info(logText+" Ended verifyAndSelectRadioGroup");
	}

	/**
	 * Verifies and selects the required radio button with value from test data (locator values i.e. XPath not got from UI mappings file the XPath is passed).
	 *
	 * @param strIdentifier - the locator/XPath of radio group. 
	 * @param labelValue - the label value of radio button to be selected from radio group. 
	 */
	public void verifyAndSelectRadioGroupNoUIMap(String strIdentifier,String labelValue) {
		//logger.info(logText+" Started verifyAndSelectRadioGroupNoUIMap");
		boolean clicked = false;
		List<WebElement> radioItems;

		try {
			radioItems=driver.findElements(By.xpath(strIdentifier));
			for(WebElement element:radioItems) {
				if (element.getAttribute("value").equalsIgnoreCase(labelValue)) {
					element.click();
					report.updateTestLog("Should click on  <b>"+labelValue+"</b>  RadioButton.", "<b>"+labelValue+"</b> RadioButton Clicked.",Status.PASS);
					clicked=true;
					break;
				}								
			}
			if(!clicked) {
				report.updateTestLog("Error in clicking the radio button:"+ labelValue+".",labelValue+" not found in the list.",Status.FAIL);
			}
		} catch(Exception e) {		
			report.updateTestLog("Error in clicking the radio button:"+ labelValue+".",e.getClass().getName(),Status.FAIL);
			}	
		//logger.info(logText+" Ended verifyAndSelectRadioGroupNoUIMap");
	}

	/**
	 * Verify and selects a radio button.
	 *
	 * @param strIdentifier - the XPath for the radio button.
	 * @param value - the test data value for the radio button yes/no.
	 * @param strRadioButtonName - the label of radio button. 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public void verifyAndSelectRadioButton(String strIdentifier,String value,String strRadioButtonName) throws ParserConfigurationException, SAXException, IOException{
		//logger.info(logText+" Started verifyAndSelectRadioButton with strIdentifier, strRadioButtonName and value");
		WebElement element;
		Finder locator = new Finder();

		try {
			if(value.trim().toLowerCase().equals("yes")) {
				element =driver.findElement(locator.findBy(strIdentifier));
				element.click();
				report.updateTestLog("Should click on <b>" + strRadioButtonName
						+ "</b> radio button.", "<b>" + "radio button clicked.", Status.PASS);
				}
		} catch(NoSuchElementException nse) {
			report.updateTestLog("Error is selecting radio button", nse.getClass().getName(),Status.FAIL);
		} catch(Exception e) {
			report.updateTestLog("Error is selecting radio button", e.getClass().getName(),Status.FAIL);
		}
		//logger.info(logText+" Ended verifyAndSelectRadioButton with strIdentifier, strRadioButtonName and value");
	}

	/**
	 * Verify and selects a radio button.
	 *
	 * @param strIdentifier - the XPath for the radio button.
	 * @param strRadioButtonName - the label of radio button.
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public void verifyAndSelectRadioButton(String strIdentifier,String strRadioButtonName) throws ParserConfigurationException, SAXException, IOException{
		//logger.info(logText+" Started verifyAndSelectRadioButton with strIdentifier and strRadioButtonName");
		WebElement element;
		Finder locator = new Finder();

		try {			
			element =driver.findElement(locator.findBy(strIdentifier));
			element.click();	
			report.updateTestLog("Should click on <b>" + strRadioButtonName
					+ "</b> radio button.", "<b>" + "radio button clicked.", Status.PASS);			
		} catch(NoSuchElementException nse) {
			report.updateTestLog("Error is selecting radio button", nse.getClass().getName(),Status.FAIL);
		} catch(Exception e) {
			report.updateTestLog("Error is selecting radio button", e.getClass().getName(),Status.FAIL);
		}
		//logger.info(logText+" Ended verifyAndSelectRadioButton with strIdentifier and strRadioButtonName");
	}

}
