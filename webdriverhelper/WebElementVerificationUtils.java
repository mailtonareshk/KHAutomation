/*
 * Class contains utility methods to verify WebElements.
 * @author - Cognizant Automation Team
 * Sep 2012
 *  
 */
package webdriverhelper;

import java.io.IOException;
import java.util.NoSuchElementException;
import javax.xml.parsers.ParserConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.xml.sax.SAXException;
import com.cognizant.framework.Status;
import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;


public class WebElementVerificationUtils extends ReusableLibrary {
	private WebDriverHelper util; 

	/** The logger. */
	//private Logger logger = Logger.getLogger(WebElementVerificationUtils.class);

		
	/**
	 * Instantiates a new WebElementVerificationUtils.
	 *
	 * @param webDriver - The WebDriver instance.
	 * @param detailedReport - The DetailedReport instance.
	 * @param logText
	 * @throws ParserConfigurationException 
	 * @throws SAXException
	 * @throws IOException
	 */	
	public WebElementVerificationUtils(ScriptHelper scriptHelper)
	{
	     super(scriptHelper);		
		 util =new WebDriverHelper(scriptHelper);
		}	
	

	/**
	 * Enters and verifies the value entered in the TextBox.
	 *
	 * @param strFieldIdentifier - the XPath of the TextBox WebElement.
	 * @param strValue - the text value to be entered.
	 * @param strFieldName - the name/label of the TextBox to be verified.
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public void verifyAndEnterValueInTextBox(String strFieldIdentifier,String strValue,String strFieldName) throws ParserConfigurationException, SAXException, IOException {
		//logger.info(logText+" Started verifyAndEnterValueInTextBox");
		String data="";
		WebElement element;
		Finder locator  = new Finder();

		try {
			element =driver.findElement(locator.findBy(strFieldIdentifier));
				if (StringUtils.isNull(strValue) || StringUtils.isEmpty(strValue)) {
				report.updateTestLog("Input Data for " +strFieldName+" text box is empty/blank. ","Test data not provided in the test data sheet." , Status.DONE);
			} else {
				if (element.isDisplayed() == true){
					element.clear();
					//data = element.getAttribute("value");
					//data= element.getText();
					//element.isEnabled();

					//((JavascriptExecutor)driver).executeScript("arguments[0].value = arguments[1]", element, strValue);
					element.sendKeys(strValue);
					//data= element.getText();
					data = element.getAttribute("value");
					if(null != data)
						data = data.trim();

					if (StringUtils.isNull(data) || StringUtils.isEmpty(data)) {
						report.updateTestLog("Value should be entered in <b>" + strFieldName
								+ "</b> text box.", "<b>"+ strValue
								+ "</b> value not entered in the text box.", Status.FAIL);
					} else {
						report.updateTestLog("Value should be entered in <b>" + strFieldName
								+ "</b> text box.", "<b>" + strValue
								+ "</b> value entered in text box.", Status.PASS);
					}
				} else {
					report.updateTestLog("<b>" + strFieldName
							+ "</b> text box not found.", "<b>Change the element name of " + strFieldName
							+ "</b> text box. ", Status.FAIL);
				}
			}
		} catch(NoSuchElementException nse) {
			report.updateTestLog("Error in verifyAndEnterValueInTextBox method","", Status.FAIL);
		} catch(Exception e) {
			report.updateTestLog("Error in verifyAndEnterValueInTextBox method","", Status.FAIL);
		}
		//logger.info(logText+" Ended verifyAndEnterValueInTextBox");
	}

	/**
	 * Clicks and verifies whether the button has been clicked.
	 *
	 * @param strButton - the XPath of the button WebElement to be clicked.
	 * @param strButtonName - the name/label of the button to be clicked.
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public void verifyAndClickButton(String strButton, String strButtonName) throws ParserConfigurationException, SAXException, IOException {
		//logger.info(logText+" Started verifyAndClickButton");
		WebElement element;
		Finder locator  = new Finder();
		try {

			element =driver.findElement(locator.findBy(strButton));
			//Scroll into view for webelement before click action
			//ScrollIntoElement(locator.findBy(strButton));	
			element.click();
			report.updateTestLog("Should click <b>" + strButtonName
					+ "</b> button.", "<b>" + strButtonName + "</b> button clicked.", Status.PASS);
		} catch(NoSuchElementException nse) {
			report.updateTestLog("Error in clicking the button:"+ strButton ,"", Status.WARNING);
		} catch(Exception e) {
		 report.updateTestLog("Error in clicking the button:"+ strButton ,"", Status.FAIL);
		}
		//logger.info(logText+" Ended verifyAndClickButton");
	}

	/**
	 * Clicks and verifies whether the button has been clicked (locator values i.e. XPath not got from UI mappings file the XPath is passed).
	 *
	 * @param strButton - the XPath of the button WebElement to be clicked.
	 * @param strButtonName - the name/label of the button to be clicked.
	 */
	public void verifyAndClickButtonNoUIMap(String strButton, String strButtonName){

		WebElement element;
		//logger.info(logText+" Started verifyAndClickButtonNoUIMap");
		try {
			element =driver.findElement(By.xpath(strButton));
			ScrollIntoElement(strButton);
			element.click();
			report.updateTestLog("Should click <b>" + strButtonName
					+ "</b> button.", "<b>" + strButtonName + "</b> button clicked.", Status.PASS);
		} catch(NoSuchElementException nse) {
			report.updateTestLog("Error in clicking the button:"+ strButton ,"", Status.FAIL);
		} catch(Exception e) {
			report.updateTestLog("Error in clicking the button:"+ strButton ,"", Status.FAIL);
		}
		//logger.info(logText+" Ended verifyAndClickButtonNoUIMap");
	}

	/**
	 * Clicks and verifies whether the tab has been clicked.
	 *
	 * @param strTab - the XPath of the tab WebElement to be clicked.
	 * @param strTabName - the name/label of the tab to be clicked.
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public void verifyAndClickTab(String strTab, String strTabName) throws ParserConfigurationException, SAXException, IOException{

		WebElement element;
		Finder locator =  new Finder();
		//logger.info(logText+" Started verifyAndClickTab");
		try {
			element =driver.findElement(locator.findBy(strTab));
						element.click();
			report.updateTestLog("Should click <b>" + strTabName
					+ "</b> tab.", "<b>" + strTabName + "</b> tab clicked.", Status.PASS);
		} catch(NoSuchElementException nse) {
			report.updateTestLog("Error in clicking the tab:"+ strTab ,"", Status.FAIL);
		} catch(Exception e) {
			report.updateTestLog("Error in clicking the tab:"+ strTab ,"", Status.FAIL);
		}
		//logger.info(logText+" Ended verifyAndClickTab");
	}

	/**
	 * Clicks and verifies whether the link has been clicked.
	 *
	 * @param strLinkIdentifier - the XPath of the link WebElement to be clicked.
	 * @param strLinkName - the label/name of the link to be clicked.
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public void verifyAndClickLink(String strLinkIdentifier, String strLinkName) throws ParserConfigurationException, SAXException, IOException {	

		WebElement element;
		Finder locator =  new Finder();
		//logger.info(logText+" Started verifyAndClickLink");
		try {
			element =driver.findElement(locator.findBy(strLinkIdentifier));
			element.click();
			report.updateTestLog("Should click <b>" + strLinkName+ "</b> link.", "<b>" + strLinkName+ "</b> link clicked.", Status.PASS);
		} catch(NoSuchElementException nse) {
			report.updateTestLog("Error in clicking the link:"+ strLinkIdentifier ,"", Status.WARNING);
		} catch(Exception e) {
			report.updateTestLog("Error in clicking the link:"+ strLinkIdentifier ,"", Status.WARNING);
		}
		//logger.info(logText+" Ended verifyAndClickLink");
	}

	/**
	 * Clicks and verifies whether the link has been clicked (locator values i.e. XPath not got from UI mappings file the XPath is passed).
	 *
	 * @param strLinkIdentifier - the XPath of the link WebElement to be clicked.
	 * @param strLinkName - the label/name of the link to be clicked.
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public void verifyAndClickLinkNoUIMap(String strLinkIdentifier, String strLinkName) throws ParserConfigurationException, SAXException, IOException {	

		WebElement element;
    	//logger.info(logText+" Started verifyAndClickLinkNoUIMap");
		try {
			element =driver.findElement(By.xpath(strLinkIdentifier));
			ScrollIntoElement(strLinkIdentifier);
			element.click();
			report.updateTestLog("Should click <b>" + strLinkName
					+"</b> Link.","<b>" + strLinkName+ "</b> link clicked. ", Status.PASS);
		} catch(NoSuchElementException nse) {
			report.updateTestLog("Error in clicking the link:"+ strLinkIdentifier ,"", Status.FAIL);
		} catch(Exception e) {
			report.updateTestLog("Error in clicking the link:"+ strLinkIdentifier ,"", Status.FAIL);
		}
		//logger.info(logText+" Ended verifyAndClickLinkNoUIMap");
	}

	/**
	 * Checks and verifies the CheckBox.
	 *
	 * @param strButton - the XPath of the CheckBox WebElement to be clicked.
	 * @param aliasName - the name/label of the CheckBox to be clicked.
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public void verifyAndCheckCheckbox(String strButton,String aliasName) throws ParserConfigurationException, SAXException, IOException {

		WebElement element;
		boolean isChecked=false;
		Finder locator =  new Finder();
		//logger.info(logText+" Started verifyAndCheckCheckbox with two params");
		try {			
			element =driver.findElement(locator.findBy(strButton));
			isChecked = element.isSelected();
			if(!isChecked) {
				element.click();
			}
			//element.click();			
			report.updateTestLog("Should check <b>" + aliasName
					+ "</b> checkBox.", "<b>" + aliasName
					+ "</b> checkBox checked it on.", Status.PASS);
		} catch(NoSuchElementException nse) {
			nse.printStackTrace();
			//report.updateTestLog("Error is checking <b>"+aliasName+"</b> check box", "", Status.FAIL);
		} catch(Exception e) {
			e.printStackTrace();
			//report.updateTestLog("Error is checking <b>"+aliasName+"</b> check box", "", Status.FAIL);
		}
		//logger.info(logText+" Ended verifyAndCheckCheckbox with two params");
	}

	/**
	 * Checks and verifies the CheckBox depending on the test data value.
	 *
	 * @param strButton - the XPath of the CheckBox WebElement to be clicked.
	 * @param value - the test data value.
	 * @param aliasName - the name/label of the CheckBox to be clicked.
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public void verifyAndCheckCheckbox(String strButton,String value,String aliasName) throws ParserConfigurationException, SAXException, IOException {

		boolean isChecked=false;
		WebElement element;
		Finder locator =  new Finder();
		//logger.info(logText+" Started verifyAndCheckCheckbox with three params");
		try {
			element =driver.findElement(locator.findBy(strButton));
			isChecked = element.isSelected();
			if(isChecked) {
				element.click();
			}
			if(value.toLowerCase().trim().contains("yes")) {
				element.click();
				report.updateTestLog("Should Check <b>" + aliasName
						+ "</b> CheckBox.", " <b>" + aliasName
						+ "</b> CheckBox checked it on . ", Status.PASS);
			}
		} catch(NoSuchElementException nse) {
			report.updateTestLog("Error is selecting <b>"+aliasName+"</b> check box", "", Status.FAIL);
		} catch(Exception e) {
			report.updateTestLog("Error is selecting <b>"+aliasName+"</b> check box", "", Status.FAIL);
		}
		//logger.info(logText+" Ended verifyAndCheckCheckbox with three params");
	}

	/**
	 * Checks if WebElement is present on page.
	 *
	 * @param locator - the locator of the WebElement to be checked.
	 * @return true, if is element present.
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public boolean isElementPresent(String locator) throws ParserConfigurationException, SAXException, IOException {

		boolean elePresent=false;
		Finder locatr =  new Finder();
		//logger.info(logText+" Started isElementPresent");
		try {
			driver.findElement(locatr.findBy(locator));
			elePresent=true;		      
		} catch (NoSuchElementException nse) {
			//logger.error(logText+"  Error in finding element: \n", nse);		    	
		} catch (StaleElementReferenceException sre) {
			//logger.error(logText+"  Error in finding element: \n", sre);		    	
		}
		//logger.info(logText+" Ended isElementPresent");
		return elePresent;
	} 

	/**
	 * Checks if WebElement is present on page (locator values i.e. XPath not got from UI mappings file the XPath is passed).
	 *
	 * @param locator - the locator of the WebElement to be checked.
	 * @return true, if is element present.
	 */
	public boolean isElementPresentNoUIMap(String locator) {
		//logger.info(logText+" Started isElementPresentNoUIMap");
		boolean elePresent = false;
		

		try {
			driver.findElement(By.xpath(locator));
			elePresent=true;		    	
		} catch (NoSuchElementException nse) {
			//logger.error(logText+"  Error in finding element: \n",nse);		    	
		} catch (StaleElementReferenceException sre) {
			//logger.error(logText+"  Error in finding element: \n",sre);		    	
		}
		catch(Exception e)
		{
			//logger.error(logText+"  Exception in finding element: \n",e);	
		}
		//logger.info(logText+" Ended isElementPresentNoUIMap");
		return elePresent;
	} 

	/**
	 * Checks if is WebElement visible on the page.
	 *
	 * @param locator - the locator of the WebElement to be checked for visibility.
	 * @return true, if is element visible.
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public boolean isElementVisible(String locator) throws ParserConfigurationException, SAXException, IOException {
		//logger.info(logText+" Started isElementVisible");
		boolean isVisible = false;
		Finder locatr =  new Finder();

		try {
			isVisible = driver.findElement(locatr.findBy(locator)).isDisplayed();
			if(isVisible) {
				isVisible = true;
			}
		} catch (NoSuchElementException nse) {
			//logger.error(logText+"  Error in finding visiblity of element: \n",nse);			    	
		} catch (StaleElementReferenceException sre) {
			//logger.error(logText+"  Error in finding visiblity of element: \n",sre);		    	
		} catch (Exception e) {
			//logger.error(logText+"  Error in finding visiblity of element: \n",e);			    
		}
		//logger.info(logText+" Ended isElementVisible");
		return isVisible;
	} 

	/**
	 * Checks if is WebElement visible on the page (locator values i.e. XPath not got from UI mappings file the XPath is passed).
	 *
	 * @param locator - the locator of the WebElement to be checked for visibility.
	 * @return true, if is element visible.
	 */
	public boolean isElementVisibleNoUIMap(String locator) {

		boolean isVisible = false;
		//logger.info(logText+" Started isElementVisibleNoUIMap");
		try {
			isVisible = driver.findElement(By.xpath(locator)).isDisplayed();
			if(isVisible){
				isVisible = true;
			}	
		} catch (NoSuchElementException nse) {
			//logger.error(logText+"  Error in finding visiblity of element: \n",nse);		    	
		} catch (StaleElementReferenceException sre) {
			//logger.error(logText+"  Error in finding visiblity of element: \n",sre);		    	
		} catch (Exception e) {
			//logger.error(logText+"  Error in finding visiblity of element: \n",e);			    
		}
		//logger.info(logText+" Ended isElementVisibleNoUIMap");
		return isVisible;
	} 

	/**
	 * Checks if is WebElement enabled on the page.
	 *
	 * @param locator - the locator of the WebElement to be enabled.
	 * @return true, if is element enabled.
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public boolean isElementEnabled(String locator) throws ParserConfigurationException, SAXException, IOException {

		boolean isVisible = false;
		WebElement element;	
		Finder locatr =  new Finder();
		//logger.info(logText+" Started isElementEnabled");
		try {
			element = driver.findElement(locatr.findBy(locator));
			if(element.isDisplayed() && element.isEnabled()){
				isVisible = true;
			}			 
		} catch (NoSuchElementException nse) {
			//logger.error(logText+"  Error in finding whether the element is enabled: \n",nse);
		} catch (StaleElementReferenceException sre) {
			//logger.error(logText+"  Error in finding whether the element is enabled: \n",sre);			    	
		} 
		//logger.info(logText+" Ended isElementEnabled");
		return isVisible;
	} 

	/**
	 * Checks if is WebElement enabled on the page (locator values i.e. XPath not got from UI mappings file the XPath is passed).
	 *
	 * @param locator - the locator of the WebElement to be enabled.
	 * @return true, if is element enabled.
	 */
	public boolean isElementEnabledNoUIMap(String locator) {
		//logger.info(logText+" Started isElementEnabledNoUIMap");
		boolean isVisible = false;
		WebElement element;
		

		try {
			element = driver.findElement(By.xpath(locator));
			if(element.isDisplayed() && element.isEnabled()) {
				isVisible = true;
			}	
		} catch (NoSuchElementException nse) {
			//logger.error(logText+"  Error in finding whether the element is enabled: \n",nse);			
		} catch (StaleElementReferenceException sre) {
			//logger.error(logText+"  Error in finding whether the element is enabled: \n",sre);			   
		}
		//logger.info(logText+" Ended isElementEnabledNoUIMap");
		return isVisible;
	} 

	/**
	 * Verifies whether that Tab is visible on the page.
	 *
	 * @param uiElement - the XPath of the tab WebElement to be verified.
	 * @param tabName - the name/label of the tab to be verified.
	 * @return true, if successful.
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public boolean verifyTabVisibility(String uiElement, String tabName) throws ParserConfigurationException, SAXException, IOException{

		boolean visibility = false;	
		Finder locatr =  new Finder();
		//logger.info(logText+" Started verifyTabVisibility");
		try {
			if(driver.findElement(locatr.findBy(uiElement)).isDisplayed()) {
				visibility = true;
				report.updateTestLog(tabName+" Should be visible.",tabName+" is visible.", Status.PASS);
			}			
		} catch (NoSuchElementException nse) {
			//logger.error(logText+"  Tab not visible: \n", nse);
			//report.updateTestLog(Status.FAIL,tabName+" Should be visible.",tabName+" is not visible.", objWebDriver);
			return visibility;
		} catch (Exception e) {
			//logger.error(logText+"  Tab not visible: \n", e);
			//report.updateTestLog(Status.FAIL,tabName+" Should be visible.",tabName+" is not visible.", objWebDriver);
			return visibility;
		}		
		//logger.info(logText+" Ended verifyTabVisibility");
		return visibility;
	}	

	/**
	 * Enters and verifies the value entered in the TextArea.
	 *
	 * @param uiElement - the XPath of the TextArea WebElement.
	 * @param testData - the test data to be entered in TextArea.
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public void verifyAndEnterValueInTextArea(String uiElement, String testData) throws ParserConfigurationException, SAXException, IOException {
		//logger.info(logText+" Started verifyAndEnterValueInTextArea");
		WebElement textArea;
		Finder locatr =  new Finder();

		textArea = driver.findElement(locatr.findBy(uiElement));
		if (textArea.isEnabled() && textArea.isDisplayed()) {
			textArea.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			textArea.sendKeys(testData);
			report.updateTestLog("Should enter data in Text Area.","Entered Data "+testData+" in Text Area.", Status.PASS);
		} else	{
			report.updateTestLog("Should enter data in Text Area.","Failed to enter data "+testData+" in Text Area.", Status.FAIL);
		}
		//logger.info(logText+" Ended verifyAndEnterValueInTextArea");
	}

	/**
	 * Enters and verifies the value entered in the TextArea with label name of the TextArea for better reporting.
	 *
	 * @param uiElement - the XPath of the TextArea WebElement.
	 * @param testData - the test data to be entered in TextArea.
	 * @param fieldName - the name/label of the TextArea to be verified.
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public void verifyAndEnterValueInTextArea(String uiElement, String testData, String fieldName) throws ParserConfigurationException, SAXException, IOException {
		//logger.info(logText+" Started verifyAndEnterValueInTextArea");
		WebElement textArea;
		Finder locatr =  new Finder();

		textArea = driver.findElement(locatr.findBy(uiElement));
		
		if (textArea.isEnabled() && textArea.isDisplayed()) {
			textArea.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			textArea.sendKeys(testData);
			report.updateTestLog("Should enter data in "+fieldName+" (Text Area).","Entered Data :"+testData+", in Text Area.", Status.PASS);
		} else {
			report.updateTestLog("Should enter data in "+fieldName+" (Text Area).","Failed to enter data :"+testData+", in Text Area.", Status.FAIL);
		}
		//logger.info(logText+" Ended verifyAndEnterValueInTextArea");
	}

	/**
	 * Verify and enter value in text box java script executor.
	 *
	 * @param strFieldIdentifier the str field identifier
	 * @param strValue the str value
	 * @param strFieldName the str field name
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public void verifyAndEnterValueInTextBoxJSE(String strFieldIdentifier, String strValue,String strFieldName) throws ParserConfigurationException, SAXException, IOException {

		String data="";
		WebElement element;
		Finder locatr =  new Finder();
		//logger.info(logText+" Started verifyAndEnterValueInTextBoxJSE");
		try {
			element =driver.findElement(locatr.findBy(strFieldIdentifier));
			if (strValue.equals("")||strValue.equals(null)) {
				report.updateTestLog("Input Data for " +strFieldName+" text box is empty/blank. ","Test data not provided in the test data sheet." , Status.DONE);
			} else {
				if (element.isDisplayed() == true){
					element.clear();
					((JavascriptExecutor)driver).executeScript("arguments[0].value = arguments[1]",element,strValue );
					data = element.getAttribute("value");
					data = data.trim();
					if (data.equalsIgnoreCase(strValue.trim())) {
						report.updateTestLog("Value should be entered in <b>" + strFieldName
								+ "</b> text box.", "<b>" + strValue
								+ "</b> value entered in text box.", Status.PASS);
					} else {
						report.updateTestLog("Value should be entered in <b>" + strFieldName
								+ "</b> text box.", "<b>"+ strValue
								+ "</b> value not entered in the text box.", Status.FAIL);						
					}
				} else {
					report.updateTestLog("<b>" + strFieldName
							+ "</b> text box not found.", "<b>Change the element name of " + strFieldName
							+ "</b> text box. ", Status.FAIL);
				}
			}
		} catch(NoSuchElementException nse) {
			report.updateTestLog("Error in verifyAndEnterValueInTextBox method","" , Status.FAIL);
		} catch(Exception e) {
			report.updateTestLog("Error in verifyAndEnterValueInTextBox method","" , Status.FAIL);
		}
		//logger.info(logText+" Ended verifyAndEnterValueInTextBoxJSE");
	}
	/**
	 * Verify whether element exists and then clicks on the element using JQuery
	 *
	 * @param strButton - the UI name of the WebElement to be clicked.
	 * @param strButtonName - the name/label of the button to be clicked.
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public void clickElementusingJquery(String strButton, String strButtonName) throws ParserConfigurationException, SAXException, IOException {
		//logger.info(logText+" Started clickElementusingJquery");
		WebElement element;		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Finder locatr =  new Finder();
		try {

			element =driver.findElement(locatr.findBy(strButton));			
			String strID=element.getAttribute("id");
			String jqueryScript="$(document).ready(function(){ $('#"+strID+"').click();});";
			js.executeScript(jqueryScript);
			report.updateTestLog("Should click on button using Jquery <b>" + strButtonName
					+ "</b> button.", "<b>" + strButtonName + "</b> button clicked.", Status.PASS);
		} catch(NoSuchElementException nse) {
			report.updateTestLog("Error in clicking the button using Jquery:"+ strButton ,"", Status.FAIL);
		} catch(Exception e) {
			report.updateTestLog("Error in clicking the button using Jquery:"+ strButton ,"", Status.FAIL);
		}
		//logger.info(logText+" Ended clickElementusingJquery");
	}
	/**
	 * Verify whether element exists and then clicks on the element using JQuery
	 *
	 * @param strButton - the xpath WebElement to be clicked.
	 * @param strButtonName - the name/label of the button to be clicked.
	 */
	public void clickElementusingJqueryNoUIMap(String strButton, String strButtonName) {
		//logger.info(logText+" Started clickElementusingJqueryNoUIMap");
		WebElement element;		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		try {

			element =driver.findElement(By.xpath(strButton));			
			String strID=element.getAttribute("id");
			String jqueryScript="$(document).ready(function(){ $('#"+strID+"').click();});";
			js.executeScript(jqueryScript);
			report.updateTestLog("Should click on button using Jquery <b>" + strButtonName
					+ "</b> button.", "<b>" + strButtonName + "</b> button clicked.", Status.PASS);
		} catch(NoSuchElementException nse) {
			
			report.updateTestLog("Error in clicking the button using Jquery:"+ strButton ,"", Status.FAIL);
		} catch(Exception e) {
			report.updateTestLog("Error in clicking the button using Jquery:"+ strButton ,"", Status.FAIL);
		}
		//logger.info(logText+" Ended clickElementusingJqueryNoUIMap");
	}
	/**
	 * Scroll into view for a weblement. This is used to avoid element is not clickable at this point error on chrome.
	 *
	 * @param strLocator - the Xpath of the webelement
	 */
	public void ScrollIntoElement(String strLocator) {
		//logger.info(logText+" Started ScrollIntoElement");
		WebElement element=null;
		String browserType=getBrowserName();		
		if (browserType.contains("chrome")){
			JavascriptExecutor js = (JavascriptExecutor)driver;
			try {

				element =driver.findElement(By.xpath(strLocator));	
				//String runscript="arguments[0].scrollIntoView();";
				String Script="window.scrollTo(0,"+element.getLocation().y+")";

				Actions act= new Actions(driver);
				act.moveToElement(element).build().perform();
				//act.moveToElement(element, 0,element.getLocation().y).build().perform();	
				//								
				//wait here for a sec mandatory

				Thread.sleep(1000);
				//				js.executeScript(runscript,element);
				js.executeScript(Script);
				Thread.sleep(500); //wait here for a sec mandatory
				//logger.info(logText+" Scrolling into view for the webelement"+strLocator);
			} catch(NoSuchElementException nse) {
							
			} catch(Exception e) {			
			
			}
		}
		//logger.info(logText+" Ended ScrollIntoElement");
	}
	/**
	 * Gets the browser type [Chrome|firefox|IE]
	 *
	 * @ReturnValue - Browser type
	 */
	public String getBrowserName() {
		//logger.info(logText+" Started getBrowserName");
		Capabilities capa= ((RemoteWebDriver)driver).getCapabilities();
		//logger.info(logText+" Ended getBrowserName");
		return capa.getBrowserName();		
	}
}
