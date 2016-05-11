/*
 * Class contains utility methods to help verify all components
 * @author - Cognizant Automation Team
 * Sep 2012
 *  
 */
package webdriverhelper;


import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;
import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;
import webdriverhelper.Finder;
import com.cognizant.framework.FrameworkException;
import com.cognizant.framework.Status;


public class ComponentVerificationUtils extends ReusableLibrary{

	/** The logger. */
	//private Logger logger = Logger.getLogger(ComponentVerificationUtils.class);

	/**
	 * logText holds the information of ip address and test case id
	 */
	
	/**
	 * Instantiates a new ComponentVerificationUtils.
	 *
	 * @param webDriver - The WebDriver instance.
	 * @param detailedReport - The DetailedReport instance.
	 * @param logText
	 * @throws ParserConfigurationException
	 * @throws SAXException 
	 * @throws IOExceptio.
	 */
	public ComponentVerificationUtils(String logText,ScriptHelper scriptHelper)
	{
		super(scriptHelper);    
		
	}	

	/**
	 * Asserts whether actual data contains the expected.
	 *
	 * @param label - the label of the element to be asserted.
	 * @param expected - the expected value.
	 * @param actual - the actual value.
	 */
	public void verifyValueContains(String label,String expected,String actual) {
		//logger.info(logText+" Started verifyValueContains");
		if(actual.trim().contains(expected.trim())) {
			//logger.info(logText+" PASS  "+expected );
			report.updateTestLog(label+" : "+ expected,label+" : "+ expected ,Status.PASS);
			} else {
			//logger.info(logText+" FAIL  "+actual );
				report.updateTestLog(label+" : "+ expected,label+" : "+ expected ,Status.FAIL);
			}
		//logger.info(logText+" Ended verifyValueContains");
	}

	/**
	 * Asserts whether actual data is not equal to the expected.
	 *
	 * @param label - the label of the element to be asserted.
	 * @param expected - the expected value.
	 * @param actual - the actual value.
	 */
	public void verifyNotEquals(String label,String expected,String actual) {
		//logger.info(logText+" Started verifyNotEquals");
		if(!actual.contains(expected)) {
			//logger.info(logText+" PASS  "+expected );
			report.updateTestLog(label+" : "+ expected,label+" : "+ expected ,Status.PASS);
			
		} else {
			//logger.info(logText+" FAIL  "+actual );
			report.updateTestLog(label+" : "+ expected,label+" : "+ expected ,Status.FAIL);
		}
		//logger.info(logText+" ended verifyNotEquals");
	}

	

	/**
	 * Assert element present.
	 *
	 * @param xPath - the XPath of the element to be asserted.
	 * @param elementName -the element name.
	 * @return true, if successful.
	 */
	public boolean verifyElementPresent(String xPath, String elementName){
		//logger.info(logText+" Started verifyElementPresent");
		boolean visibility = false;
		try {
			if(driver.findElement(By.xpath(xPath)).isDisplayed())	{
				visibility = true;
				report.updateTestLog("<b>"+elementName+" </b> should be present","<b>"+elementName+"</b> is present",Status.PASS);
			}
		} catch (Exception e) {
			report.updateTestLog("<b>"+elementName+" </b> should be present","<b>"+elementName+"</b> is not present",Status.PASS);
			return visibility;
		}
		//logger.info(logText+" ending verifyElementPresent");
		return visibility;
	}

	/**
	 * Assert element not present.
	 *
	 * @param xPath - the XPath of the element to be asserted.
	 * @param elementName - the element name.
	 * @return true, if successful.
	 */
	public boolean verifyElementNotPresent(String xPath, String elementName){
		//logger.info(logText+" Started verifyElementNotPresent");
		boolean visibility = true;
		try {
			if(driver.findElement(By.xpath(xPath)).isDisplayed()) {
				visibility = false;
				report.updateTestLog("<b>"+elementName+" </b> should be not be present","<b>"+elementName+"</b> is present",Status.FAIL);
			}
			
		} catch (Exception e) {
			report.updateTestLog("<b>"+elementName+" </b> should be not be present","<b>"+elementName+"</b> is present",Status.PASS);
			//objDetailedReport.writeLog(Status.PASS,"<b>"+elementName+" </b> should not be present","<b>"+elementName+"</b> Not present ", objWebDriver);
			return visibility;
		}
		//logger.info(logText+" ended verifyElementNotPresent");
		return visibility;
	}	

	/**
	 * Assert tab visibility.
	 *
	 * @param uiElement - the locator of the tab to be asserted.
	 * @param tabName - the tab name.
	 * @return true, if successful.
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * @throws WCMSUserDefinedException 
	 */
	public boolean assertTabVisibility(String uiElement, String tabName) throws ParserConfigurationException, SAXException, IOException{
		//logger.info(logText+" Started assertTabVisibility");
		boolean visibility = false;
		Finder locator = new Finder();;
		try {
			if(driver.findElement(locator.findBy(uiElement)).isDisplayed()) {
				visibility = true;
				report.updateTestLog("<b>" +tabName+" </b> Should be visible","<b>" +tabName+" </b> is visible",Status.PASS);
				
			}
		} catch (Exception e) {
			
			report.updateTestLog("<b>" +tabName+" </b> Should be visible","<b>" +tabName+" </b> is not visible",Status.FAIL);
			//objDetailedReport.writeLog(Status.FAIL,"<b>" +tabName+" </b> Should be visible","<b>" +tabName+" </b> is not visible", objWebDriver);
			return visibility;
		}
		//logger.info(logText+" ended assertTabVisibility");
		return visibility;
	}	

	/**
	 * Process image compares two images by pixel and returns a boolean value.
	 *
	 * @param source - the source image.
	 * @param target - the target image.
	 * @return true, if successful.
	 */
	/*public boolean processImage(String source,String target) {  
		//logger.info(logText+" Started processImage");
		boolean status = false;
		String file1 = source;
		String file2 = target; 
		Image image1, image2;
		PixelGrabber grab1, grab2;
		int[] data1 = null; 
		int[] data2 = null; 
		int width, height;

		image1 = Toolkit.getDefaultToolkit().getImage(file1);  
		image2 = Toolkit.getDefaultToolkit().getImage(file2);  
		try {  
			grab1 =new PixelGrabber(image1, 0, 0, -1, -1, false);  
			grab2 =new PixelGrabber(image2, 0, 0, -1, -1, false);  

			if (grab1.grabPixels()) {  
				width = grab1.getWidth();  
				height = grab1.getHeight();  
				data1 = new int[width * height];  
				data1 = (int[]) grab1.getPixels();  
			}  			 
			if (grab2.grabPixels()) {  
				width = grab2.getWidth();  
				height = grab2.getHeight();  
				data2 = new int[width * height];  
				data2 = (int[]) grab2.getPixels();  
			}  
			status =  java.util.Arrays.equals(data1, data2);  
		} catch (InterruptedException ie) {  
			ExceptionHandlerUtils.exceptionLogger(objWebDriver, objDetailedReport, logText +" Error in comparing image: \n", ie);
		} catch (Exception e) {  
			ExceptionHandlerUtils.exceptionLogger(objWebDriver, objDetailedReport, logText +" Error in comparing image: \n", e);		
		}
		logger.info(logText+" ending processImage");
		return status;  
	}*/

	/**
	 * validates the Xpath.
	 *
	 * @param xpath - the XPath of the element to be validated.
	 * @param itemName - the name of the element to be validated.
	 * @param item - the item.
	 * @param value - the value.
	 */
	public void validations(String xpath,String itemName,String item,String value) {
		//logger.info(logText+" started validations");
		String actual = driver.findElement(By.xpath(xpath)).getText();
		if(actual.trim().toLowerCase().equalsIgnoreCase(value.trim().toLowerCase())) {
			report.updateTestLog("<b>"+item+"</b> of  <b>"+itemName+"</b> Should be <b>"+value+"<b>.","<b>"+item+"</b> of <b>"+itemName+"</b> is <b>"+value+"<b>.",Status.PASS);
		} else {
			report.updateTestLog("<b>"+item+"</b> of  <b>"+itemName+"</b> Should be <b>"+value+"<b>.","<b>"+item+"</b> of <b>"+itemName+"</b> is <b>"+actual+"<b>.",Status.FAIL);
			
		}
		//logger.info(logText+" ended validations");
	}

	/**
	 * Takes snapshot of only the image element.
	 *
	 * @param locator - the locator of image element.
	 * @throws AWTException
	 * @throws IOException
	 */
	/*public void captureElement(String locator) throws AWTException, IOException {
		logger.info(logText+" started captureElement");
		WebElement element;
		Locatable locElement;
		Coordinates cor;
		Point pt;
		Dimension dim;
		int x, y, X, Y;
		int yOffset= 65;
		Rectangle screenRect;
		BufferedImage capture;
		String elementFileName;

		count++;
		element = driver.findElement(By.xpath(locator));
		locElement = (Locatable) element;
		cor = locElement.getCoordinates();
		pt=cor.getLocationOnScreen();
		dim = element.getSize();
		x = pt.x;
		y= pt.y;
		X = dim.getWidth();
		Y = dim.getHeight();
		//logger.info(logText+" X: "+X+" ,Y: "+Y+" , x: "+x+" ,y: "+y);	        
		screenRect = new Rectangle(x,y+yOffset,X,Y);
		capture = new Robot().createScreenCapture(screenRect);
		elementFileName = "Element" + "_"+ ReportUtils.dateNow() + "_" + ReportUtils.timeNow()+count+ ".jpeg";
		elementFileName = elementFileName.replace(":", "-");
		ImageIO.write(capture, "jpeg", new File (System.getProperty("user.dir")+"\\Test Results\\ADOBE_WCMS_Testcases"+File.separator+elementFileName));	
		//logger.info(logText+" ended captureElement");
	}	
*/
	/**
	 * Clears text from the text box field in a page.
	 *
	 * @param locator - the locator of text box to be cleared.
	 * @param textBoxValue - the text box value.
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public void clearTextBoxVerification(String locator,String textBoxValue) throws ParserConfigurationException, SAXException, IOException {
		//logger.info(logText+" Started clearTextBoxVerification");
		Finder finder = new Finder();
		try {
			WebElement element=driver.findElement(finder.findBy(locator));
			element.sendKeys(textBoxValue);
			element.clear();
			if(element.getText().equals("")) {
				report.updateTestLog("The Values in the Text Box is: "," Cleared.",Status.PASS);
			} else {
				report.updateTestLog("The Values in the Text Box is: "," Not Cleared.",Status.FAIL);
				}
		} catch(Exception e) {
			e.printStackTrace();
				}
		//logger.info(logText+" ended clearTextBoxVerification");
	}

	/**
	 * Calculates the width of the text box.
	 *
	 * @param locator - the locator of text box for which width to be calculated.
	 * @return The width of the text box.
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public int textboxWidthCalculation(String locator) throws ParserConfigurationException, SAXException, IOException {      
		//logger.info(logText+" Started textboxWidthCalculation");
		int width = 0;
		Finder finder = new Finder();
		try {
			width=driver.findElement(finder.findBy(locator)).getSize().getWidth();
		} catch(Exception e) {
			throw new FrameworkException("Error in textboxWidthCalculation method:","TextBox Width not found");
			//ExceptionHandlerUtils.exceptionLogger(objWebDriver, objDetailedReport, logText +" Error in textboxWidthCalculation method: \n", e);
		}
		//logger.info(logText+" ended textboxWidthCalculation");
		return width;
	}

	/**
	 * Calculates the height of the text box.
	 *
	 * @param locator - the locator of text box for which height to be calculated.
	 * @return The height of the text box.
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public int textboxHeightCalculation(String locator) throws ParserConfigurationException, SAXException, IOException {      
		//logger.info(logText+" Started textboxHeightCalculation");
		int height = 0;
		Finder finder = new Finder();
		try	{
			height=driver.findElement(finder.findBy(locator)).getSize().getHeight();
		} catch(Exception e) {
			throw new FrameworkException("Error in textboxHeightCalculation method:","TextBox Height not found");
			//ExceptionHandlerUtils.exceptionLogger(objWebDriver, objDetailedReport, logText +" Error in textboxHeightCalculation method: \n", e);
		}
		//logger.info(logText+" ended textboxHeightCalculation");
		return height;
	}	

	/**
	 * Verifies whether the list box is empty or having values.
	 *
	 * @param strXpath - the XPath of the list box to be verified.
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * @throws InterruptedException
	 */
	public void listboxVerification(String strXpath) throws ParserConfigurationException, SAXException, IOException {
		//logger.info(logText+" Started listboxVerification");
		Finder finder = new Finder();
		try {
			
			driver.findElement(finder.findBy(strXpath)).click();
			List<WebElement> items=driver.findElements((finder.findBy(strXpath)));
			for(WebElement elemet:items) {
				if (elemet.getText().equals(null)) {
					report.updateTestLog("The List Box is Empty.","No Values in the ListBox.",Status.FAIL);
				break;
				} else {
					report.updateTestLog("The List Box is not Empty.","ListBox contains the values.",Status.PASS);				
				}
			}
		} catch(Exception e) {
			throw new FrameworkException("Error in listboxVerification method:","List Box Verifiaction Failed");
			}
		//logger.info(logText+" ended listboxVerification");
	}          

	/**
	 * To select a value/item from List box.
	 *
	 * @param xpath - the XPath of the list box.
	 * @param itemName - the list box value/item name.
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public  void listBoxSelection(String xpath,String itemName) throws ParserConfigurationException, SAXException, IOException {
		//logger.info(logText+" Started listBoxSelection");
		Finder finder = new Finder();
		try {
			WebElement select1 = driver.findElement(finder.findBy(xpath));
			List<WebElement> options1 = select1.findElements(By.tagName("option"));
			for (WebElement option : options1) {
				if(itemName.equals(option.getText()))
					option.click();
			}
		} catch(Exception e) {
			throw new FrameworkException("Error in listboxVerification method:","List Box Verifiaction Failed");
			//ExceptionHandlerUtils.exceptionLogger(objWebDriver, objDetailedReport, logText +" Error in listBoxSelection method: \n", e);
		}   	
		//logger.info(logText+" ended listBoxSelection");
	}       

	
	
}
