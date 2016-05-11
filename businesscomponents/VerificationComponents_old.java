package businesscomponents;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;
import org.openqa.selenium.interactions.Actions;

import com.cognizant.framework.Status;
import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import supportlibraries.ReusableLibrary;
import supportlibraries.ScriptHelper;
import uimap.TelenorMobileWithoutSubscription;
import webdriverhelper.Finder;
import webdriverhelper.WebElementVerificationUtils;

/**
 * Verification Components class
 * 
 * @author Cognizant
 */
public class VerificationComponents_old extends ReusableLibrary {
	/**
	 * Constructor to initialize the component library
	 * 
	 * @param scriptHelper
	 *            The {@link ScriptHelper} object passed from the
	 *            {@link DriverScript}
	 */
	
	String urlName = dataTable.getData("General_Data", "URLS");
	boolean productDetailsExists = false;
	public static String subsciptionName ="";
	public static HashMap<String, String> hashmap = new HashMap<String, String>();
	public static String[] mobilePrices = new String[3];
	public static String[] mobileName = new String[3];
	public static int Incrementer = 0;
	public static double parsedShippingPrice = 0.0;
	public static String servicepack = "";
	public static String creditdetails = "";
	public static String[] mobileNumberSplits;
	public static double parsedPayingCost = 0.0;
	public static String totalAddress ="";
	public static int dummy=0;
	public static boolean IsmultiProductSelected=false; 
	public static boolean flagUrl=false;
	public static String billAddress = "";
	public static String shipAddress = "";
	public static double payingPrice=0.0;
	public static String mainWindow = "";
	WebElementVerificationUtils utils = new WebElementVerificationUtils(scriptHelper);
	
	public VerificationComponents_old(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	/*
	 * public void verifyLoginValidUser() throws InterruptedException {
	 * Thread.sleep(5000); driver.manage().window().maximize();
	 * if(isElementPresent(MasterPage.lnkLogOff)) {
	 * report.updateTestLog("Verify Login", "Login succeeded for valid user",
	 * Status.PASS); } else { frameworkParameters.setStopExecution(true); throw
	 * new FrameworkException("Verify Login", "Login failed for valid user"); }
	 * } private boolean isElementPresent(By by) { try { driver.findElement(by);
	 * return true; } catch (NoSuchElementException e) { return false; } }
	 */

	/*
	 * public void verifyLoginInvalidUser() {
	 * if(!isElementPresent(MasterPage.lnkLogOff)) {
	 * report.updateTestLog("Verify Login", "Login failed for invalid user",
	 * Status.PASS); } else { report.updateTestLog("Verify Login",
	 * "Login succeeded for invalid user", Status.FAIL); } }
	 */

	/*
	 * public void verifyRegistration() { String userName =
	 * dataTable.getData("General_Data", "Username");
	 * 
	 * if(isTextPresent("^[\\s\\S]*Dear " +
	 * dataTable.getExpectedResult("FirstName") + " " +
	 * dataTable.getExpectedResult("LastName") + "[\\s\\S]*$")) {
	 * report.updateTestLog("Verify Registration", "User " + userName +
	 * " registered successfully", Status.PASS); } else { throw new
	 * FrameworkException("Verify Registration", "User " + userName +
	 * " registration failed"); } }
	 */

	/*
	 * private boolean isTextPresent(String textPattern) {
	 * if(driver.findElement(
	 * By.cssSelector("BODY")).getText().matches(textPattern)) { return true; }
	 * else { return false; } }
	 */

	

	public void verifyProductsSubscriptionList()
			throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		waitForPageLoaded(driver);
		Finder locator =new Finder();
		
		List<WebElement> element = driver.findElements(locator.findBy("links_lnkWithoutSubscription"));
		String subscriptionName = dataTable.getData("General_Data","SubscriptionName");
		int count2 = 0;
		for (WebElement list : element) {
			if (list.getText().replace("m/", "")
					.equalsIgnoreCase(subscriptionName)) {
				count2++;
				if (count2 > 1) {
					report.updateTestLog(
							"Verify Products  Subscription Type",
							"Products corresponding to the "
									+ subscriptionName
									+ "subscription are sucessfully displayed in the webshop",
							Status.PASS);
					break;
				}
			}
		}
		dummy++;
	}

	public void verifyPDPDetailsOfProducts() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		waitForPageLoaded(driver);
		Finder locator =new Finder();
		boolean imageExists = driver.findElement(locator.findBy("images_imgPDPMobile")).isDisplayed();
		boolean mobileColor = false;
		boolean subscriptionStatus = false;
		boolean bomImage =false;
		int count = 0;
		List<WebElement> element = driver.findElements(locator.findBy("links_lnkMobileColor"));
		int colorCast = element.size();
		boolean mobileColorStatus = StatusDisplay(element, colorCast, count);

		if (mobileColorStatus) {
			mobileColor = true;
		}
		boolean mobilePrice = driver.findElement(locator.findBy("textboxes_txtMobilePrice")).isDisplayed();
        
		if (!urlName.equals("ApplicationUrl11") && !dataTable.getData("General_Data","SubscriptionName").isEmpty()) {
			subscriptionStatus = driver.findElement(locator.findBy("textboxes_txtWithoutSubscription")).getText().equals(dataTable.getData("General_Data","SubscriptionName"));
              /* try
               {
		      bomImage = driver.findElement(TelenorMobileWithoutSubscription.imgBomb).isDisplayed();
		       }
               catch(Exception e)
               {
              e.printStackTrace(); 
               }*/
		}
		List<WebElement> element2 = driver.findElements(TelenorMobileWithoutSubscription.lnkTabs);
		boolean tabsPresent = false;
		int counter1 = 0;

		try {
			String tabs = "";
			for (WebElement tabsCount : element2) {
				counter1++;
				tabs = dataTable.getData("General_Data", "Tab" + counter1);
				
				if(!tabsCount.getAttribute("style").equals("display: none;"))
				{
				if (tabsCount.getText().equals(tabs)) {
					tabsPresent = true;
				} else {
					tabsPresent = false;
					break;
				}
			}
			}
		} catch (Exception e) {

		}
		String mobileTitle = driver.findElement(locator.findBy("links_lnkMobileName")).getText();
		
		boolean breadcrumb = driver.findElement(locator.findBy("links_lnkBreadCrumb")).isDisplayed();
		String breadCrumbMobile = driver.findElement(locator.findBy("links_lnkBreadCrumb")).getText();
			
		
		validateElementsStatus(imageExists, "Mobile Image Verification",
				"Mobile Image is displayed", "Mobile Image is not displayed");
		validateElementsStatus(mobileColor, "Mobile Color Verification",
				"Mobile Color is Displayed", "Mobile Color is not Displayed");
		validateElementsStatus(mobilePrice, "Mobile Price Verification",
				"Mobile Price is Displayed", "Mobile Price is Displayed");
		validateElementsStatus(tabsPresent, "Tabs Verification",
				"All Tabs are Displayed in PDP Details Page",
				"All Tabs are Not Displayed in PDP Details Page");
		validateElementsStatus(breadcrumb, "Bread Crumb Verification",
				"Bread Crumb is Displayed Properly in PDP Details Page",
				"Bread Crumb is not Displayed in PDP Details Page");
		
		
		if(bomImage)
			report.updateTestLog("Bomb Image Verification",
					"This product contains bomb image", Status.PASS);
		else
			report.updateTestLog("Bomb Image Verification",
					"This product doesn't contain bomb image", Status.WARNING);
			

		if (!urlName.equals("ApplicationUrl11") && !dataTable.getData("General_Data","SubscriptionName").equalsIgnoreCase("No"))
		{
			validateElementsStatus(subscriptionStatus,
					"Subscription Name Verification",
					"Subscription Name is Displayed",
					"Subscription Name is not Displayed");
		}
		
		if (driver.getCurrentUrl().startsWith(properties.getProperty("ApplicationUrl10")))
		{
			flagUrl =true;
		}
             
		else
		{
		 flagUrl =false;
		}
		
          if(IsmultiProductSelected)
      		Incrementer=Incrementer+1;
      		else
      			Incrementer=0;
    
          if(!dataTable.getData("General_Data","SubscriptionName").isEmpty())
		pdpDetailsValidation(Incrementer);
        
		//reset the flag once its done
        mobileName[Incrementer] = mobileTitle;
        boolean mobileNameStatus = Arrays.asList(mobileName).contains(breadCrumbMobile);
        
        validateElementsStatus(mobileNameStatus, "Mobile Name Verification",
				"Mobile Name is Displayed Properly in PDP Details Page",
				"Mobile Name is Not Displayed Properly in PDP Details Page");
        
        IsmultiProductSelected=false;
	}

	public void verifyMyCartProductsDetails() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		waitForPageLoaded(driver);
		Finder locator =new Finder();
		boolean productPriceExists = false;
		boolean totalPrice = false;
		int counter = 0;
		boolean shippingPriceExists = driver.findElement(locator.findBy("textboxes_txtShippingPrice")).isDisplayed();
		boolean payingPriceExists = driver.findElement(locator.findBy("textboxes_txtPayingPrice")).isDisplayed();
		List<WebElement> element1 = driver.findElements(locator.findBy("images_imgMyCartMobile"));
		List<WebElement> element2 = driver.findElements(locator.findBy("links_lnkProductName"));
		int imageCounter = element1.size();
		int productNameCouner = element2.size();
		boolean productImageExists = StatusDisplay(element1, imageCounter,
				counter);
		boolean productNameExists = StatusDisplay(element2, productNameCouner,
				counter);

		if (urlName.equals("ApplicationUrl1")
				|| urlName.equals("ApplicationUrl2")
				|| urlName.equals("ApplicationUrl3")
				|| urlName.equals("ApplicationUrl4")
				|| urlName.equals("ApplicationUrl9")||urlName.equals("ApplicationUrl11")||urlName.equals("ApplicationUrl6")) {
			List<WebElement> element3 = driver.findElements(locator.findBy("textboxes_txtProductPrice"));
			int productPriceCouner = element3.size();
			productPriceExists = StatusDisplay(element3, productPriceCouner,
					counter);

			validateElementsStatus(
					productImageExists,
					"Product Image Verification",
					"Product Image is displayed Successfully in myCart product details page",
					"Product Image is not displayed Successfully in myCart product details page");
			validateElementsStatus(
					productNameExists,
					"Product Name Verification",
					"Product Name is displayed Successfully in myCart product details page",
					"Product Name is not displayed Successfully in myCart product details page");
			validateElementsStatus(
					productPriceExists,
					"Product Price Verification",
					"Product Price is displayed Successfully in myCart product details page",
					"Product Price is not displayed Successfully in myCart product details page");
			validateElementsStatus(
					shippingPriceExists,
					"Shipping Price Verification",
					"Shipping Price is displayed Successfully in myCart product details page",
					"Shipping Price is not displayed Successfully in myCart product details page");
			validateElementsStatus(
					payingPriceExists,
					"Paying Price Verification",
					"Paying Price is displayed Successfully in myCart product details page",
					"Paying Price is not displayed Successfully in myCart product details page");

		}

		if (driver.getCurrentUrl().startsWith(properties.getProperty("ApplicationUrl10"))) {
			
			boolean quantityExists = false;
			
			List<WebElement> element3 = driver.findElements(locator.findBy("textboxes_txtProductPrice2"));
			List<WebElement> element4 = driver.findElements(locator.findBy("textboxes_txtTotalPrice"));
			List<WebElement> element5 = driver.findElements(locator.findBy("textboxes_txtQuantity"));
			int productPriceCounter = element3.size();
			int totalPriceCounter = element4.size();
			int quantityCounter = element5.size();
			productPriceExists = StatusDisplay(element3, productPriceCounter,
					counter);
			totalPrice = StatusDisplay(element4, totalPriceCounter, counter);

			for (WebElement quantity : element5) {
				String quantityValue = quantity.getAttribute("value");
				if (!quantityValue.isEmpty()) {
					counter++;
				}

				else {
					counter = 0;
				}
			}

			if (quantityCounter == counter) {
				quantityExists = true;
				counter = 0;
			}

			validateElementsStatus(
					productImageExists,
					"Product Image Verification",
					"Product Image is displayed Successfully in myCart product details page",
					"Product Image is not displayed Successfully in myCart product details page");
			validateElementsStatus(
					productNameExists,
					"Product Name Verification",
					"Product Name is displayed Successfully in myCart product details page",
					"Product Name is not displayed Successfully in myCart product details page");
			validateElementsStatus(
					productPriceExists,
					"Product Price Verification",
					"Product Price is displayed Successfully in myCart product details page",
					"Product Price is not displayed Successfully in myCart product details page");
			validateElementsStatus(
					shippingPriceExists,
					"Shipping Price Verification",
					"Shipping Price is displayed Successfully in myCart product details page",
					"Shipping Price is not displayed Successfully in myCart product details page");
			validateElementsStatus(
					payingPriceExists,
					"Paying Price Verification",
					"Paying Price is displayed Successfully in myCart product details page",
					"Paying Price is not displayed Successfully in myCart product details page");
			validateElementsStatus(
					totalPrice,
					"Total Price Verification",
					"Total Price is displayed Successfully in myCart product details page",
					"Total Price is not displayed Successfully in myCart product details page");
			validateElementsStatus(
					quantityExists,
					"Product Quantity Verification",
					"Product Quantity is displayed Successfully in myCart product details page",
					"Product Quantity is not displayed Successfully in myCart product details page");

		}
		myCartProductsDetailsValidations();
	}

	public void verifyShippingAndBillingValidation()
			throws InterruptedException, ParserConfigurationException, SAXException, IOException {

		waitForPageLoaded(driver);
		Finder locator =new Finder();
		double shippingPrice =0.0;
		boolean shippingRadioButton=driver.findElement(locator.findBy("buttons_btnRadio1")).isSelected();
		boolean paymentRadiobutton=driver.findElement(locator.findBy("buttons_btnRadio2")).isSelected();

		
		if(!urlName.equals("ApplicationUrl9"))
		//shippingPrice = Double.parseDouble(driver.findElement(locator.fidBy("textboxes_txtShippingcharges")).getText().replaceAll(",", ".").replaceAll("-", ".").replaceAll(".-", "."));
		shippingPrice= Double.parseDouble(CharMatcher.is('.').or(CharMatcher.DIGIT).retainFrom(driver.findElement(locator.findBy("textboxes_txtShippingcharges")).getText()));
		
		else
		//shippingPrice = Double.parseDouble(driver.findElement(locator.findBy("textboxes_txtDjuiceShippingPrice")).getText().replaceAll(",-", "."));
		shippingPrice= Double.parseDouble(CharMatcher.is('.').or(CharMatcher.DIGIT).retainFrom(driver.findElement(locator.findBy("textboxes_txtDjuiceShippingPrice")).getText()));
		
		servicepack = driver.findElement(locator.findBy("textboxes_txtServicePack")).getText();
		creditdetails = driver.findElement(locator.findBy("textboxes_txtCreditDetails")).getText();
		String customerName = driver.findElement(locator.findBy("textboxes_txtNameDetails")).getText();
		String email = driver.findElement(locator.findBy("textboxes_txtEmailDetails")).getText();
		String postalAddress = driver.findElement(locator.findBy("textboxes_txtPostalAddress3")).getText();
		String postalCity =  driver.findElement(locator.findBy("textboxes_txtPostalCity")).getText();
		
		totalAddress =customerName + postalAddress + postalCity;
		String address = customerName + email;
		
		StringBuilder value = new StringBuilder(6);
		value.append(dataTable.getData("BillingInformations_Data", "FirstName"));
		value.append(" ");
		value.append(dataTable.getData("BillingInformations_Data", "LastName"));
		value.append(dataTable.getData("BillingInformations_Data", "Email"));

		validateElementsStatus(shippingRadioButton,
				"Shipping Radio Button Verification",
				"Successfully selected shipping radio button",
				"Not selected Shipping radio button");
		validateElementsStatus(paymentRadiobutton,
				"Payment Radio Button Verification",
				"Successfully selected payment radio button",
				"Not selected Payment radio buttonuccessfully in myCart product details page");

		if (parsedShippingPrice == shippingPrice) {
			report.updateTestLog("Shipping Price Validation",
					"Shipping Price is sucessfully validated", Status.PASS);
		}

		else {
			report.updateTestLog("Shipping Price Validation",
					"Shipping Price is not sucessfully validated", Status.FAIL);
		}

		if (address.replaceAll("\n", "").trim()
				.toUpperCase().equals(value.toString().trim().toUpperCase())) {
			report.updateTestLog("Address details Validation",
					"Address details are sucessfully validated", Status.PASS);
		}

		else {
			report.updateTestLog("Address details Validation",
					"Address details are not sucessfully validated",
					Status.FAIL);
		}
	}

	public void verifyConfirmOrderDetails() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		waitForPageLoaded(driver);
		Finder locator =new Finder();
		boolean productSubscriptionStatus = false;
		boolean priceStatus = false;
		double totalPrice = 0.0;
		double bannerTotalProductPrice = 0.0;
		double bannerShippingPrice =0.0;
		int counter1 = 0;
		//int counter = 0;
		double total = 0.0;
		double totalbanner = 0.0;
		double parsedProductPrice = 0.0;
		List<WebElement> bannerProductPrice=null;
		String mobileNo ="";
		String name ="";
		String email ="";
		String billingPaymentDetails ="";
		String address ="";
		
		boolean termsConditions = driver.findElement(locator.findBy("checkboxes_chkTermsConditions")).isDisplayed();
		List<WebElement> element1 = driver.findElements(locator.findBy("images_imgConfirmOrderMobile"));
		int productimagecounter = element1.size();
		boolean productImageExists = StatusDisplay(element1,productimagecounter, counter1);
		List<WebElement> element2 = driver.findElements(locator.findBy("textboxes_txtProductName"));
		int productCount=element2.size();
	

		if(!driver.getCurrentUrl().startsWith(properties.getProperty("ApplicationUrl10")) && !subsciptionName.equals("Uten abonnement") && subsciptionName!="")
		{
			bannerShippingPrice = Double.parseDouble(driver.findElement(locator.findBy("textboxes_txtBannerShippingPrice")).getText().replaceAll(",",".").replaceAll("-", ""));
			mobileNo= driver.findElement(locator.findBy("textboxes_txtMobileNumber")).getText().trim();
			bannerProductPrice = driver.findElements(locator.findBy("textboxes_txtBannerProductPrice"));
			name = driver.findElement(locator.findBy("textboxes_txtNameDetails")).getText();
			email = driver.findElement(locator.findBy("textboxes_txtEmailDetails")).getText();
			billingPaymentDetails = driver.findElement(locator.findBy("textboxes_txtBillingPaymentDetails")).getText().replaceAll(" ", "");
			
			address = name + email;
			String billingPayment = servicepack + creditdetails;
			StringBuilder values = new StringBuilder(5);
			values.append(dataTable.getData("BillingInformations_Data", "FirstName"));
			values.append(" ");
			values.append(dataTable.getData("BillingInformations_Data", "LastName"));
			values.append(dataTable.getData("BillingInformations_Data", "Email"));

			StringBuilder value = new StringBuilder(7);
			value.append(mobileName[0]);
			value.append(" ");
			value.append("med");
			value.append(" ");
			value.append(subsciptionName);
			
			if(productCount==1)
			productSubscriptionStatus =ProductSubscriptionStatus(element2,value);
			
			else if(productCount>1)
			{
				StringBuilder thirdValue = new StringBuilder(7);
				thirdValue.append(mobileName[1]);
				thirdValue.append(" ");
				thirdValue.append("med");
				thirdValue.append(" ");
				thirdValue.append(dataTable.getData("General_Data","SubscriptionName"));
		        productSubscriptionStatus = ProductSubscriptionStatus(element2,value,thirdValue);
			}
					
			if (address.replaceAll("\n", "").trim()
					.toUpperCase().equals(values.toString().trim().toUpperCase()))
				report.updateTestLog("Address details Validation",
						"Address details are sucessfully validated", Status.PASS);
			
			else
				report.updateTestLog("Verify Address Details",
						"Address Details are not successfully validated", Status.FAIL);

			if (billingPaymentDetails.replaceAll("\n","").replaceAll(" ","").trim().equals(billingPayment.replaceAll("\n","").replaceAll(" ","").trim()))
				report.updateTestLog("Verify Billing and Payment Details",
						"Billing and Payment Details are successfully validated",
						Status.PASS);

			else
				report.updateTestLog(
						"Verify Billing and Payment Details",
						"Billing and Payment Details are not successfully validated",
						Status.FAIL);
		}
		
	
		else if(driver.getCurrentUrl().startsWith(properties.getProperty("ApplicationUrl10")))
		{
			String output ="";
			creditdetails = driver.findElement(locator.findBy("textboxes_txtInvoice")).getText().trim();
			payingPrice = Double.parseDouble(driver.findElement(locator.findBy("textboxes_txtPayingPrice2")).getText().replaceAll(",",".").replaceAll("-",""));
			//payingPrice = Double.parseDouble( CharMatcher.is(',').or(CharMatcher.DIGIT).retainFrom(driver.findElement(locator.findBy("textboxes_txtPayingPrice2")).getText()));	
			bannerShippingPrice = Double.parseDouble(driver.findElement(locator.findBy("textboxes_txtBannerShippingPrice1")).getText().replaceAll(",",".").replaceAll("-",""));
			//bannerShippingPrice = Double.parseDouble( CharMatcher.is(',').or(CharMatcher.DIGIT).retainFrom(driver.findElement(locator.findBy("textboxes_txtBannerShippingPrice1")).getText()));
			
			if(!subsciptionName.equals("Uten abonnement") && !dataTable.getData("General_Data","SubscriptionName").equalsIgnoreCase("No"))
			{
			output = driver.findElement(locator.findBy("textboxes_txtNordialogNumber")).getText().trim();
			mobileNo = CharMatcher.is(':').or(CharMatcher.DIGIT).retainFrom(output);
			
			StringBuilder secondValue = new StringBuilder(9);
			secondValue.append(mobileName[0]);
			secondValue.append(" ");
			secondValue.append("med");
			secondValue.append(" ");
			secondValue.append(subsciptionName);
			secondValue.append(" ");
			secondValue.append("(Uten binding)");
			productSubscriptionStatus =ProductSubscriptionStatus(element2,secondValue);
			mobileNumberSplits = mobileNo.split(":");  
     		}
			
			else
			{
				StringBuilder Value = new StringBuilder(3);
				Value.append(mobileName[0]);
				productSubscriptionStatus =ProductSubscriptionStatus(element2,Value);
			}
			bannerProductPrice = driver.findElements(locator.findBy("textboxes_txtBannerProductPrice1"));
			
			billAddress = driver.findElement(locator.findBy("textboxes_txtBillingDetails")).getText().replaceAll("Fakturareferanse:","").trim();
			shipAddress =driver.findElement(locator.findBy("textboxes_txtDeliveryDetails")).getText().replaceAll("Leveringsreferanse:","" ).trim();
		}
          if(!driver.getCurrentUrl().startsWith(properties.getProperty("ApplicationUrl10")))
         mobileNumberSplits = mobileNo.split(":");
                  
  	double shippingPrice = Double.parseDouble(driver.findElement(locator.findBy("textboxes_txtShippingPrice2")).getText().replaceAll(",",".").replaceAll("-", ""));
		
	if (urlName.equals("ApplicationUrl11") || (subsciptionName.equals("Uten abonnement") && !driver.getCurrentUrl().startsWith(properties.getProperty("ApplicationUrl10"))))
		{
			bannerShippingPrice = Double.parseDouble(driver.findElement(locator.findBy("textboxes_txtBannerShippingPrice")).getText().replaceAll(",",".").replaceAll("-",""));
			bannerProductPrice = driver.findElements(locator.findBy("textboxes_txtBannerProductPrice"));
			name = driver.findElement(locator.findBy("textboxes_txtNameDetails")).getText();
			email = driver.findElement(locator.findBy("textboxes_txtEmailDetails")).getText();
			billingPaymentDetails = driver.findElement(locator.findBy("textboxes_txtBillingPaymentDetails")).getText().replaceAll(" ", "");
			
			address = name + email;
			String billingPayment = servicepack + creditdetails;
			StringBuilder values = new StringBuilder(5);
			values.append(dataTable.getData("BillingInformations_Data", "FirstName"));
			values.append(" ");
			values.append(dataTable.getData("BillingInformations_Data", "LastName"));
			values.append(dataTable.getData("BillingInformations_Data", "Email"));

			productSubscriptionStatus =ProductSubscriptionStatus(element2,null);
				
			if (address.replaceAll("\n", "").trim()
					.toUpperCase().equals(values.toString().trim().toUpperCase()))
				report.updateTestLog("Address details Validation",
						"Address details are sucessfully validated", Status.PASS);
			
			else
				report.updateTestLog("Verify Address Details",
						"Address Details are not successfully validated", Status.FAIL);

			if (billingPaymentDetails.replaceAll("\n","").replaceAll(" ","").trim().equals(billingPayment.replaceAll("\n","").replaceAll(" ","").trim()))
				report.updateTestLog("Verify Billing and Payment Details",
						"Billing and Payment Details are successfully validated",
						Status.PASS);

			else
				report.updateTestLog(
						"Verify Billing and Payment Details",
						"Billing and Payment Details are not successfully validated",
						Status.FAIL);
				
		}
	
		for (WebElement element : bannerProductPrice) {
			String price = element.getText();

			if (Arrays.asList(mobilePrices).contains(price)) {
				priceStatus = true;
				//counter++;
				if(!urlName.equals("ApplicationUrl11"))
				parsedProductPrice = Double.parseDouble(price.replaceAll(",",".").replaceAll("-",""));
				
				else
				parsedProductPrice = Double.parseDouble(price.replaceAll(",",".").replaceAll("-",""));
				
				totalbanner += parsedProductPrice;
				
			} else {
				priceStatus = false;
				
				//counter=0;
				break;
				
			}
			
		}
			bannerTotalProductPrice = bannerTotalProductPrice + totalbanner
				+ shippingPrice;
			
			//counter=0;

		if (urlName.equals("ApplicationUrl1")
				|| urlName.equals("ApplicationUrl2")
				|| urlName.equals("ApplicationUrl3")
				|| urlName.equals("ApplicationUrl4")
				|| urlName.equals("ApplicationUrl9") || urlName.equals("ApplicationUrl11") || urlName.equals("ApplicationUrl7")|| urlName.equals("ApplicationUrl6")) {
			List<WebElement> element4 = driver.findElements(locator.findBy("textboxes_txtPrice"));

			for (WebElement productPrice : element4) {
				String price = productPrice.getText();

				if (Arrays.asList(mobilePrices).contains(price)) {
					priceStatus = true;
					//counter++;
					if(!urlName.equals("ApplicationUrl11"))
					parsedProductPrice = Double.parseDouble(price.replaceAll(",",".").replaceAll("-",""));
					else
						parsedProductPrice = Double.parseDouble(price.replaceAll(",",".").replaceAll("-",""));	
					total += parsedProductPrice;
				} else {
					priceStatus = false;
					break;
				}
			}
			totalPrice = totalPrice + total + shippingPrice;

		}

		else if (driver.getCurrentUrl().startsWith(properties.getProperty("ApplicationUrl10"))) {
			List<WebElement> element5 = driver.findElements(locator.findBy("textboxes_txtPrice2"));
			
			
			for (WebElement productPrice : element5) {
				String price = productPrice.getText();

				if (Arrays.asList(mobilePrices).contains(price)) {
					priceStatus = true;
					//counter++;
					parsedProductPrice = Double.parseDouble(price.replaceAll(",", ".").replaceAll("-", ""));
					total += parsedProductPrice;
				} else {
					priceStatus = false;
					break;
				}
			}
			totalPrice = totalPrice + total + shippingPrice;
		}

		verifyElementsStatus(productImageExists,
				"Product Image Verification",
				"Mobile Image is displayed Successfuly",
				"Mobile Image is not displayed Successfuly");
		validateElementsStatus(productSubscriptionStatus,
				"Product Name Verification",
				"Product Name is displayed Successfuly",
				"Product Name is not displayed Successfuly");
		validateElementsStatus(priceStatus, "Product Price Verification",
				"Product Price is Successfuly validated",
				"Product Price is not Successfuly validated");
		validateElementsStatus(termsConditions,
				"Terms and Condition Verification",
				"Terms and Conditions Successfuly displayed",
				"Terms Condition are not Successfuly displayed");

		if(!driver.getCurrentUrl().startsWith(properties.getProperty("ApplicationUrl10")))
		{
		if (shippingPrice == parsedShippingPrice)
			report.updateTestLog(
					"Verify Shipping Price",
					"Shipping Price in Order Details Page is Correctly displayed",
					Status.PASS);

		else
			report.updateTestLog(
					"Verify Shipping Price",
					"Shipping Price in Order Details page is not Correctly displayed",
					Status.FAIL);

		if (bannerShippingPrice == parsedShippingPrice)
			report.updateTestLog(
					"Verify Shipping Price in Banner",
					"Shipping Price in Order Details page banner is Correctly displayed",
					Status.PASS);

		else
			report.updateTestLog(
					"Verify Shipping Price in  Banner",
					"Shipping Price in Order Details page  banner is not Correctly displayed",
					Status.FAIL);

		if (totalPrice == parsedPayingCost)
			report.updateTestLog(
					"Verify Total Product Price  ",
					"Total Product Price in order details page are successfully validated",
					Status.PASS);

		else
			report.updateTestLog(
					"Verify Total Product Price  ",
					"Total Product Price in order details page are not successfully validated",
					Status.FAIL);

		if (bannerTotalProductPrice == parsedPayingCost)
			report.updateTestLog(
					"Verify Total Product Price in Banner  ",
					"Total Product Price in banner of order details page are successfully validated",
					Status.PASS);

		else
			report.updateTestLog(
					"Verify Total Product Price in Banner ",
					"Total Product Price in banner of order details page are not successfully validated",
					Status.FAIL);
		}
		
		
		else
		{
			if (shippingPrice == FunctionalComponents_old.InvoiceshippingPrice)
				report.updateTestLog(
						"Verify Shipping Price",
						"Shipping Price in Order Details Page is Correctly displayed",
						Status.PASS);

			else
				report.updateTestLog(
						"Verify Shipping Price",
						"Shipping Price in Order Details page is not Correctly displayed",
						Status.FAIL);

			if (bannerShippingPrice == FunctionalComponents_old.InvoiceshippingPrice)
				report.updateTestLog(
						"Verify Shipping Price in Banner",
						"Shipping Price in Order Details page banner is Correctly displayed",
						Status.PASS);

			else
				report.updateTestLog(
						"Verify Shipping Price in  Banner",
						"Shipping Price in Order Details page  banner is not Correctly displayed",
						Status.FAIL);

			if (Math.round(totalPrice*100.0)/100.0 == payingPrice)
				report.updateTestLog(
						"Verify Total Product Price  ",
						"Total Product Price in order details page are successfully validated",
						Status.PASS);

			else
				report.updateTestLog(
						"Verify Total Product Price  ",
						"Total Product Price in order details page are not successfully validated",
						Status.FAIL);

			if (Math.round(bannerTotalProductPrice*100.0)/100.0  == payingPrice)
				report.updateTestLog(
						"Verify Total Product Price in Banner  ",
						"Total Product Price in banner of order details page are successfully validated",
						Status.PASS);

			else
				report.updateTestLog(
						"Verify Total Product Price in Banner ",
						"Total Product Price in banner of order details page are not successfully validated",
						Status.FAIL);
		}
	}

	public void verifyCompleteOrderDetails() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		waitForPageLoaded(driver);
		Finder locator =new Finder();
		boolean orderStatus = driver.findElement(locator.findBy("textboxes_txtOrderStatus")).getText().contains(dataTable.getData("General_Data", "OrderStatus"));
		boolean orderNumber = false;
		boolean billingDetailsStatus = false;
		boolean shippingDetails = false;
		int counter = 0;
		String orderNo = driver.findElement(locator.findBy("textboxes_txtOrderId")).getText();
		hashmap.put("orderNumber", orderNo);

		if (orderNo != null) {
			orderNumber = true;
		}
		List<WebElement> billingStatus = driver.findElements(locator.findBy("textboxes_txtBillingAddress"));
		int billingStatusCounter = billingStatus.size();
		billingDetailsStatus = StatusDisplay(billingStatus,billingStatusCounter, counter);
		List<WebElement> shippingDetailsStatus = driver.findElements(locator.findBy("textboxes_txtShippingDetails"));
		int shippingDetailsStatusCounter = shippingDetailsStatus.size();
		shippingDetails = StatusDisplay(shippingDetailsStatus,shippingDetailsStatusCounter, counter);
		

		if (orderStatus && orderNumber && billingDetailsStatus
				&& shippingDetails) {
			report.updateTestLog(
					"Verify Complete  Order Details ",
					"Confirm Order Page is displayed with Order Number "+orderNo+" and other details ",
					Status.PASS);
		}

		else {
			report.updateTestLog(
					"Verify Complete  Order Details ",
					"Confirm Order Page is not displayed with Order Number and other details ",
					Status.FAIL);
		}
		
		if(urlName.equals("ApplicationUrl6")){
			
			switchBacktoOldWindow(mainWindow);
			Thread.sleep(500L);
			driver.findElement(locator.findBy("buttons_btnSimbaReceipt")).click();
	  		waitForPageLoaded(driver);
	  		Thread.sleep(5000L);
	  		driver.switchTo().frame(1);
	  		boolean ReceiptFrameCheck = driver.findElement(locator.findBy("textboxes_txtReceiptFrame")).isDisplayed();
	  		driver.switchTo().defaultContent();
	  		driver.findElement(locator.findBy("buttons_btnSimbaServiceOrderInfo")).click();
	  		waitForPageLoaded(driver);
	  		boolean ReceiptFrameServiceCheck = driver.findElement(locator.findBy("textboxes_txtServiceReceiptFrame")).isDisplayed();
	  		
	  		if(ReceiptFrameCheck && ReceiptFrameServiceCheck)
	  		
	  			report.updateTestLog(
						"SIMBA PAD Receipts Check",
						"All receipts are successfully validated",
						Status.PASS);

			else
				report.updateTestLog(
						"SIMBA PAD Receipts Check",
						"Receipts are not successfully validated",
						Status.FAIL);
	  		
		}
	}
	
	public void clickLaunchSimba() throws InterruptedException, ParserConfigurationException, SAXException, IOException
  	{
  		waitForPageLoaded(driver);
  		Finder locator =new Finder();
  		driver.switchTo().frame(0);
  		driver.findElement(locator.findBy("links_lnkLaunchSimba")).click();
  		mainWindow =driver.getWindowHandle();
  		switchtoNewWindow(mainWindow);
  		waitForPageLoaded(driver);
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
	
	public void verifyOrderNumberDisplayedDashBoard()
			throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		waitForPageLoaded(driver);
		Finder locator =new Finder();
		//Thread.sleep(20000L);
		fluentwait(locator.findBy("images_imgAjaxLoad"));
		//fluentwait(locator.findBy("images_imgFailedAjaxLoad"));
		boolean orderNumberDispalayStatus = driver.findElement(locator.findBy("links_lnkOrderNumber")).getText().contains(hashmap.get("orderNumber"));

		if (orderNumberDispalayStatus) {
			report.updateTestLog("Order Number Display", "The Order number "
					+ hashmap.get("orderNumber") + "is available in MBiz",
					Status.PASS);
		} else {
			report.updateTestLog("Order Number Display", "The Order number "
					+ hashmap.get("orderNumber") + "is  not available in MBiz",
					Status.FAIL);
		}
	}

	public void verifyOrderStatus() throws InterruptedException {
		try {
			waitForPageLoaded(driver);
			Thread.sleep(10000L);
			Finder locator =new Finder();
			boolean orderStatus = driver.findElement(locator.findBy("textboxes_txtAdminOrderStatus")).getText().equals(dataTable.getData("General_Data","OrderNumberStatus"));
			List<WebElement> element1 = driver.findElements(locator.findBy("textboxes_txtMobileName"));
			getTextForListAndCompare(element1, mobileName[0],
					"Mobile Name Verification",
					"Mobile Name is displayed properly in MBiz",
					"Mobile Name is not displayed properly in MBiz");
			
			
			if(!subsciptionName.equals("Uten abonnement") && !dataTable.getData("General_Data","SubscriptionName").equalsIgnoreCase("No"))
			{
			List<WebElement> element3 = driver.findElements(locator.findBy("textboxes_txtMobileNo"));
			List<WebElement> element2 = driver.findElements(locator.findBy("textboxes_txtSubscriptionType"));
			
			if(!flagUrl)
			getTextForListAndCompare(element2, subsciptionName,
					"Subscription Name Verification",
					"Subscription Name is displayed properly in MBiz",
					"Subscription Name is not displayed properly in MBiz");
			
			else
			{
				for(WebElement subscription: element2)
				{
					String subscriptionTitle =subscription.getText().replaceAll(" ","");
					StringBuilder subscriptionAppend = new StringBuilder(2);
					
					String subcriptionRemoved = subsciptionName.replaceAll(" ","");
					subscriptionAppend.append(subcriptionRemoved);
					subscriptionAppend.append("(Utenbinding)");
					
					
				if(subscriptionTitle.trim().equals(subscriptionAppend.toString().trim()))
					report.updateTestLog("Subscription Name Verification",
							"Subscription Name is displayed properly in MBiz",
							Status.PASS);
				else 
				report.updateTestLog("Subscription Name Verification",
							"Subscription Name is not displayed properly in MBiz",
							Status.FAIL);
     			}
		   	}
			
			for (WebElement mobileNumber : element3) {
				 String mobileSplit = "";
				 int counter=0;
				for(int i=1;i<=mobileNumberSplits.length;i++)
				{
				 if(!mobileNumberSplits[i].isEmpty())
				 {	 
				 mobileSplit =mobileNumberSplits[i].replaceAll(" ","").trim();
				 break;
				 }
				 counter++;
				}
				if(mobileNumberSplits[counter+1].indexOf(":")>0)
					mobileSplit=mobileNumberSplits[counter+1].split(":")[0].trim();
				if(mobileNumber.getText().replaceAll(" ","").trim().equals(mobileSplit))
					report.updateTestLog("Verify Mobile Number",
							"The Mobile Number verification successsful",
							Status.PASS);
				else 
				report.updateTestLog("Verify Mobile Number",
							"The Mobile Number verification not successsful",
							Status.FAIL);
				 
				
			}
			}
			String TotalProductCost = driver.findElement(locator.findBy("textboxes_txtTotalProductCost")).getText();
			String output = CharMatcher.is(',').or(CharMatcher.DIGIT).retainFrom(TotalProductCost);
			double parsedTotalProductCost =Double.parseDouble(output.replaceAll(",","."));
                 
			if(!flagUrl)
			{
			
			if(parsedTotalProductCost==parsedPayingCost)
				report.updateTestLog(
						"Verify Total Product Cost ",
						"The Total Product Price is successfuly validated on dashboard",
						Status.PASS);
			else
				report.updateTestLog(
						"Verify Total Product Cost",
						"The Total Product Price is not successfuly validated on dashboard",
						Status.FAIL);
			
			validateElementsStatus(orderStatus,
					"Order Status Verification",
					"Order is shown as 'Order is OK' on dashboard","Order is not shown as 'Order is OK' on dashboard");
			}
			
			else
			{
				double  vatPrice =0.0;
				double totalProductPrice = 0.0;
			    vatPrice = Math.round(payingPrice*25)/100.0;
			    totalProductPrice = vatPrice +payingPrice;
			    
				if(parsedTotalProductCost==Math.round(totalProductPrice * 100.0) / 100.0)
					report.updateTestLog(
							"Verify Total Product Cost ",
							"The Total Product Price is successfuly validated on dashboard",
							Status.PASS);
				else
					report.updateTestLog(
							"Verify Total Product Cost",
							"The Total Product Price is not successfuly validated on dashboard",
							Status.FAIL);
				
				validateElementsStatus(orderStatus,
						"Order Status Verification",
						"Order is shown as 'Order is OK' on dashboard","Order is not shown as 'Order is OK' on dashboard");	
			}
		    addressInformationValidation();
			paymentInformationValidation();
					
		} catch (Exception e) {
			report.updateTestLog("Error", ":'" + e + "'", Status.FAIL);
		}
	}

	public void verifyAgentCreation() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		Finder locator =new Finder();
		driver.findElement(locator.findBy("textboxes_txtEditAgent")).click();
		Thread.sleep(5000);
		boolean agentName = driver.findElement(locator.findBy("textboxes_txtAgentName")).getAttribute("value").equals(dataTable.getData("General_Data", "AgentName"));

		if (agentName) {
			report.updateTestLog("Verification of Agent Creation",
					"Sucessfully Created Agent", Status.PASS);
		}

		else {
			report.updateTestLog("Verification of Agent Creation",
					"Errorin  Creating Agent", Status.FAIL);
		}
	}

	public void verifyProductsList() throws ParserConfigurationException, SAXException, IOException {
		Finder locator =new Finder();
		List<WebElement> element = driver.findElements(locator.findBy("textboxes_txtProductList"));
		int sizeelement = element.size();
		int counter = 0;
		for (WebElement productlist : element) {
			if (productlist.getText().startsWith("HTC")) {
				counter++;
			}
		}

		if (counter == sizeelement) {
			report.updateTestLog("Verification of Product List",
					"Search Items Related to HTC are dispalyed in the Page",
					Status.PASS);
		}

		else {
			report.updateTestLog(
					"Verification of Product List",
					"Search Items Related to HTC are not dispalyed in the Page",
					Status.FAIL);
		}
	}

	public void verifyDropdownDisplayStatus() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		Finder locator =new Finder();
		boolean listboxStatus = driver.findElement(locator.findBy("comboboxes_cmdListBox")).isDisplayed();

		if (listboxStatus) {
			report.updateTestLog(
					"Verify DropDown Display Status",
					"An additional dropdown with subscription duration is shown next to existing 'Select a Subscription' & 'Recommended First' dropdowns",
					Status.PASS);
		}

		else {
			report.updateTestLog(
					"Verify DropDown Display Status",
					"An additional dropdown with subscription duration is not shown next to existing 'Select a Subscription' & 'Recommended First' dropdowns",
					Status.FAIL);
		}
	}

	public void verifyAccessoriesList() throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		Finder locator =new Finder();
		driver.findElement(locator.findBy("links_lnkaccessories")).click();
		Thread.sleep(4000L);
		List<WebElement> element = driver.findElements(locator.findBy("textboxes_txtAccessoriesList"));
		int size = element.size();

		if (size >= 1) {
			report.updateTestLog(
					"Verify Accessories List",
					"Clicked on 'Anbefalt tilbehør til din nye telefon' link and sucessfully displayed the accessories Lists concerned to the Mobile",
					Status.PASS);
		}

		else {
			report.updateTestLog(
					"Verify Accessories List",
					"Clicked on 'Anbefalt tilbehør til din nye telefon' link but unable to find the accessories Lists concerned to the Mobile",
					Status.FAIL);
		}
	}

	public boolean StatusDisplay(List<WebElement> element, int elementCounter,int normalCounter)
	{
		for (WebElement productDetails : element) {
			boolean productDetailsStatus = productDetails.isDisplayed();

			if (productDetailsStatus) {
				normalCounter++;
			}

			else {
				normalCounter = 0;
			}
		}

		if (normalCounter == elementCounter) {
			productDetailsExists = true;
			normalCounter = 0;
		}
		return productDetailsExists;
	}

	public HashMap<String, String> getHashmap() {
		return hashmap;
	}

	public void setHashmap(HashMap<String, String> hashmap) {
		this.hashmap = hashmap;
	}

	public void waitForPageLoaded(WebDriver driver) {

		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState").equals("complete");
			}
		};
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		try {
			wait.until(expectation);
		} catch (Throwable error) {
			report.updateTestLog("Page Load",
					"Timeout waiting for Page Load Request to complete.",
					Status.FAIL);
		}
	}

	public void pdpDetailsValidation(int incrementer) throws InterruptedException, ParserConfigurationException, SAXException, IOException {
		
		boolean subsciptionNameStatus =false;
		boolean mobilePriceStatus =false;
		boolean subscriptionSelected =false;
		String totalMobilePrice ="";
		String manedSPris ="";
		boolean minutesPrisStatus =false;
		boolean dataRatePrisStatus =false;
		boolean smsandmms = false;
		boolean totalMobilePriceStatus =false;
		boolean mannedSPrisStatus =false;
		boolean utenBindingStatus =false;
		Finder locator =new Finder();
		
		
		if (!urlName.equals("ApplicationUrl11") && !dataTable.getData("General_Data","SubscriptionName").equalsIgnoreCase("No"))
		{
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,150)", "");
		driver.findElement(locator.findBy("links_lnkAbonnementTab")).click();
		Thread.sleep(5000);
		subsciptionName = driver.findElement(locator.findBy("textboxes_txtWithoutSubscription")).getText();
	   }
		
		String mobilePrice1 = driver.findElement(locator.findBy("textboxes_txtMobilePrice")).getText();
		mobilePrices[incrementer] = mobilePrice1;
		
		if(driver.getCurrentUrl().startsWith(properties.getProperty("ApplicationUrl10")) && !dataTable.getData("General_Data","SubscriptionName").equalsIgnoreCase("No"))
		{
		Select DropdownList = new Select(driver.findElement(locator.findBy("listboxes_lstSelectUtenBinding")));
		String className1 ="selectablerow ChosenSubscription  selected";
		String className2 ="selectablerow ChosenSubscription hiddenSubscription selected";
		List <WebElement> subscriptionCount = driver.findElements(locator.findBy("textboxes_txtSubscriptionCount"));
		int subscriptionparsed = subscriptionCount.size();
		
		WebElement firstSelectedOption = DropdownList.getFirstSelectedOption();
		String selectBoxOption = firstSelectedOption.getText();
		utenBindingStatus = driver.findElement(locator.findBy("textboxes_txtUtenbind1")).getText().equals(selectBoxOption);
		
		switch(subscriptionparsed){
		case 1:
			subsciptionNameStatus= driver.findElement(findByDynXpath(locator.findBy("textboxes_txtNordialogSubscriptionName"), className1)).getText().contains(subsciptionName);
			mobilePriceStatus = driver.findElement(findByDynXpath(locator.findBy("textboxes_txtNordialogMobilePrice"), className1)).getText().contains(mobilePrice1);
			subscriptionSelected = driver.findElement(findByDynXpath(locator.findBy("checkboxes_chkNordialogSubscription"), className1)).isSelected();
			break;
		
		default:
			subsciptionNameStatus= driver.findElement(findByDynXpath(locator.findBy("textboxes_txtNordialogSubscriptionName"), className2)).getText().contains(subsciptionName);
			mobilePriceStatus = driver.findElement(findByDynXpath(locator.findBy("textboxes_txtNordialogMobilePrice"), className2)).getText().contains(mobilePrice1);
			subscriptionSelected = driver.findElement(findByDynXpath(locator.findBy("checkboxes_chkNordialogSubscription"), className2)).isSelected();
			break;
		}
        
	}
			
		if(!subsciptionName.equals("Uten abonnement") && !urlName.equals("ApplicationUrl11") && !driver.getCurrentUrl().startsWith(properties.getProperty("ApplicationUrl10"))) 
		{
			String getSmsMms = "";	
			String sms = "";
			String mms ="";
			String className1 ="selectablerow ChosenSubscription  selected";
			String className2 ="selectablerow ChosenSubscription hiddenSubscription selected";
			String minutesPris="",dataRatePris ="";
		
			List <WebElement> subscriptionCount = driver.findElements(locator.findBy("textboxes_txtSubscriptionCount"));
			int subscriptionparsed = subscriptionCount.size();
			switch(subscriptionparsed){
			case 1:
	
			subsciptionNameStatus = driver.findElement(findByDynXpath(locator.findBy("textboxes_txtSubscriptionName"),className1)).getText().contains(subsciptionName);
			mobilePriceStatus = driver.findElement(findByDynXpath(locator.findBy("textboxes_txtMobilePrice2"),className1)).getText().contains(mobilePrice1);
			subscriptionSelected = driver.findElement(findByDynXpath(locator.findBy("checkboxes_chkSubscription"),className1)).isSelected();
			totalMobilePrice= CharMatcher.is('.').or(CharMatcher.DIGIT).retainFrom(driver.findElement(findByDynXpath(locator.findBy("textboxes_txtTotalMobilePrice"),className1)).getText());
			manedSPris= driver.findElement(findByDynXpath(locator.findBy("textboxes_txtMannedSPris"),className1)).getText().replace("\n", "").replaceAll(" ", "");
			minutesPris = driver.findElement(findByDynXpath(locator.findBy("textboxes_txtMinutesPris"),className1)).getText();
			minutesPrisStatus= driver.findElement(locator.findBy("textboxes_txtMinutesPris2")).getText().contains(minutesPris);
			dataRatePris = driver.findElement(findByDynXpath(locator.findBy("textboxes_txtDataRatePris"),className1)).getText();
			dataRatePrisStatus = driver.findElement(locator.findBy("textboxes_txtDataRatePris2")).getText().contains(dataRatePris);
			
			break;
			
			
			default:
				
				subsciptionNameStatus = driver.findElement(findByDynXpath(locator.findBy("textboxes_txtSubscriptionName"),className2)).getText().contains(subsciptionName);
				mobilePriceStatus = driver.findElement(findByDynXpath(locator.findBy("textboxes_txtMobilePrice2"),className2)).getText().contains(mobilePrice1);
				subscriptionSelected = driver.findElement(findByDynXpath(locator.findBy("checkboxes_chkSubscription"),className2)).isSelected();
				totalMobilePrice= CharMatcher.is('.').or(CharMatcher.DIGIT).retainFrom(driver.findElement(findByDynXpath(locator.findBy("textboxes_txtTotalMobilePrice"),className2)).getText());
				manedSPris= driver.findElement(findByDynXpath(locator.findBy("textboxes_txtMannedSPris"),className2)).getText().replace("\n", "").replaceAll(" ", "");
				minutesPris = driver.findElement(findByDynXpath(locator.findBy("textboxes_txtMinutesPris"),className2)).getText();
				minutesPrisStatus= driver.findElement(locator.findBy("textboxes_txtMinutesPris2")).getText().contains(minutesPris);
				dataRatePris = driver.findElement(findByDynXpath(locator.findBy("textboxes_txtDataRatePris"),className2)).getText();
				dataRatePrisStatus = driver.findElement(locator.findBy("textboxes_txtDataRatePris2")).getText().contains(dataRatePris);
				
				break;
			}
		
		if(!urlName.equals("ApplicationUrl4") && !urlName.equals("ApplicationUrl3"))
		{
			if(subscriptionparsed>=1)
			{
				getSmsMms = driver.findElement(findByDynXpath(locator.findBy("textboxes_txtSmsMms"),className1)).getText();
			}
			
			else
			{
				getSmsMms = driver.findElement(findByDynXpath(locator.findBy("textboxes_txtSmsMms"),className2)).getText();	
			}
				
		  sms = driver.findElement(locator.findBy("textboxes_txtSMS")).getText();
		  mms = driver.findElement(locator.findBy("textboxes_txtMMS")).getText();
		}
		
       if(!urlName.equals("ApplicationUrl9") && !urlName.equals("ApplicationUrl4") && !urlName.equals("ApplicationUrl3") )
       { 
    	String[] splits = getSmsMms.split("/");  
		if (splits[0].equals(sms) && splits[1].equals(mms)) 
			smsandmms = true;
       }
           
       else if(!urlName.equals("ApplicationUrl4") && !urlName.equals("ApplicationUrl3") )
       {
        String[] splits2 =getSmsMms.split("og");   
        String replacesms = sms.replaceAll("inkl.","");
     
        if(splits2[0].trim().equals(replacesms.trim()) && splits2[1].trim().equals(mms.trim()))
	    smsandmms =true;
		}
		}
		
		
		else if(!urlName.equals("ApplicationUrl11") && !driver.getCurrentUrl().startsWith(properties.getProperty("ApplicationUrl10")))
		{
			subsciptionNameStatus = driver.findElement(locator.findBy("textboxes_txtWithoutSubscriptionName")).getText().contains(subsciptionName);
			mobilePriceStatus = driver.findElement(locator.findBy("textboxes_txtMobilePriceWithoutSubscription")).getText().contains(mobilePrice1);
			subscriptionSelected = driver.findElement(locator.findBy("checkboxes_chkWithoutSubscription")).isSelected();
			totalMobilePrice= CharMatcher.is('.').or(CharMatcher.DIGIT).retainFrom(driver.findElement(locator.findBy("textboxes_txtTotalMobilePriceWithoutSubscription")).getText()) ;
			manedSPris= driver.findElement(locator.findBy("textboxes_txtMannedSPrisWithoutSubscription")).getText().replace("\n", "").replaceAll(" ", "");
   		}
		
		if (!urlName.equals("ApplicationUrl11"))
		 {
			
			if(!driver.getCurrentUrl().startsWith(properties.getProperty("ApplicationUrl10")))
			{
		//totalMobilePriceStatus = driver.findElement(locator.findBy("textboxes_txtTotalMobilePrice2")).getText().contains(totalMobilePrice);
		totalMobilePriceStatus=CharMatcher.is('.').or(CharMatcher.DIGIT).retainFrom(driver.findElement(locator.findBy("textboxes_txtTotalMobilePrice2")).getText()).contains(totalMobilePrice);
		mannedSPrisStatus = driver.findElement(locator.findBy("textboxes_txtMannedSPris2")).getText().trim().replace("Månedspris:", "").replaceAll(" ", "").contains(manedSPris);
		}
		
		if(driver.getCurrentUrl().startsWith(properties.getProperty("ApplicationUrl10")) && !dataTable.getData("General_Data","SubscriptionName").equalsIgnoreCase("No"))
		 {
		 validateElementsStatus(subsciptionNameStatus,
					"Subscription Name Comparision",
					"Subscription Name Comparision Successful",
					"Subscription Name Comparision is not Successful");
			
		validateElementsStatus(mobilePriceStatus, "Mobile Price Comparision",
				"Mobile Price Comparision Successful",
				"Mobile Price Comparision not Successful");
		
		validateElementsStatus(subscriptionSelected,
				"Exact Subscription is Checked",
				"Correct Subscription is  Checked",
				"Correct Subscription is not Checked");
		
		validateElementsStatus(utenBindingStatus,
				"Uten Binding Verification",
				"Uten binding Comparision Successfull",
				"Uten binding Comparision is not Successfull");		
		 }
		
		 else if(!dataTable.getData("General_Data","SubscriptionName").equalsIgnoreCase("No"))
		 {
			 
		validateElementsStatus(totalMobilePriceStatus,
				"Total Mobile Price Comparision",
				"Total Mobile Comparision Successful",
				"Total Mobile Comparision not Successful");
			
		validateElementsStatus(mannedSPrisStatus, "Manned Price Comparision",
				"Manned Price Comparision Successful",
				"Manned Price Comparision not Successful");
		 }
		
		 }
		
		if(!subsciptionName.equals("Uten abonnement") &&  !urlName.equals("ApplicationUrl11") && !driver.getCurrentUrl().startsWith(properties.getProperty("ApplicationUrl10")))
				{
		validateElementsStatus(minutesPrisStatus, "Minutes Price Comparision",
				"Minutes Price Comparision Successful",
				"Minutes Price Comparision not Successful");
		verifyElementsStatus(dataRatePrisStatus, "Data Rate Comparision",
				"Data Rate Comparision Successful",
				"Data Rate Comparision not Successful");
		if(!urlName.equals("ApplicationUrl4") && !urlName.equals("ApplicationUrl3") )
			verifyElementsStatus(smsandmms, "SMS and MMS Comparision",
				"SMS and MMS Comparision Successful",
				"SMS and MMS Comparision not Successful");
		}
	
	}

	public void verifyHomePageValidations() throws AWTException, ParserConfigurationException, SAXException, IOException {

		waitForPageLoaded(driver);
		//windowMaximize();
		boolean textDisplayStatus =false;
		Finder locator =new Finder();
		
		if(!urlName.equals("ApplicationUrl9") && !driver.getCurrentUrl().startsWith(properties.getProperty("ApplicationUrl10")))
		{	
			textDisplayStatus = driver.findElement(locator.findBy("textboxes_txtDisplayText")).isDisplayed();
			
			if (textDisplayStatus)
				report.updateTestLog("Home Page text Validation",
						"Nettbutikk text is successfully displayed in the home page", Status.PASS);
			else
				report.updateTestLog("Home Page text Validation",
						"Nettbutikk text is not displayed in the home page", Status.FAIL);
		}
		
		if(driver.getCurrentUrl().startsWith(properties.getProperty("ApplicationUrl10")))
		{
			try{
				String shareduserstatus = driver.findElement(locator.findBy("textboxes_txtSharedUser")).getText();
				if(shareduserstatus.trim().equals(dataTable.getData("General_Data", "SharedUser").trim()))
				utils.verifyAndClickLink("links_lnkMobileTab","Mobile Tab");
				waitForPageLoaded(driver);
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
		
		List<WebElement> element = driver.findElements(locator.findBy("links_lnkHomeTabs"));
		int counter1 = 0;
		int counter2 = 0;
		boolean tabsPresent=false;
		boolean dropDown2Status=false;
		
		String tabs ="";
		boolean dropDown1Status =false;
		String productCount = driver.findElement(locator.findBy("textboxes_txtProductTotalCount")).getText();
		boolean productCountStatus = driver.findElement(locator.findBy("textboxes_txtProductResultCount")).getText().equals(productCount);
		boolean wordDisplayStatus =driver.findElement(locator.findBy("textboxes_txtWordDisplay")).isDisplayed();
		
		if(!urlName.equals("ApplicationUrl11"))
		{
		dropDown1Status = driver.findElement(locator.findBy("comboboxes_cmdHomePageListBox1")).isDisplayed();
		dropDown2Status = driver.findElement(locator.findBy("comboboxes_cmdHomePageListBox2")).isDisplayed();
		}

		for (WebElement Tabs : element) {
			counter1++;
			tabs = dataTable.getData("General_Data", "MainTab"+counter1);
			System.out.println("The value of Textis"+Tabs.getText());
			if (tabs != null && Tabs.getText().equalsIgnoreCase(tabs)) {
				counter2++;
				if(urlName.equals("ApplicationUrl9"))
				{
					if (counter2==2) 
					tabsPresent = true;
				}
				else
				{
					tabsPresent = true;	
				}
			}
		}

		
		if(tabsPresent)
			report.updateTestLog("Home Page Tabs Validation",
					"Tabs are successfully displayed in the home page", Status.PASS);
		else
			report.updateTestLog("Home Page Text Validation",
					"Tabs are not successfully displayed in the home page", Status.FAIL);
		if(productCountStatus)
			report.updateTestLog("Home Page product count Validation",
					"Number of products displayed are successfully displayed in the home page", Status.PASS);
		else
			report.updateTestLog("Home Page product count Validation",
					"Number of products displayed are not successfully displayed in the home page", Status.FAIL);
		
		
		if(wordDisplayStatus)
			report.updateTestLog("Home Page product Count section text Validation",
					"Products count section text is successfully displayed in the home page", Status.PASS);
		else
			report.updateTestLog("Home Page product Count section text Validation",
					"Products count section text are not successfully displayed in the home page", Status.FAIL);
		
		if(!urlName.equals("ApplicationUrl11"))
		{
		if(dropDown1Status && dropDown2Status) 
			report.updateTestLog("Home Page Dropdown Validation",
					"Home Page contains subscription selection and other dropdowns", Status.PASS);
		else
			report.updateTestLog("Home Page Dropdown Validation",
					"Home Page does not contains subscription selection and other dropdowns", Status.FAIL);
		}
		
	}

	public void myCartProductsDetailsValidations() throws ParserConfigurationException, SAXException, IOException {
		
		List<WebElement> element2 = driver.findElements(TelenorMobileWithoutSubscription.lnkProductName);
		int productCount = element2.size();
		List<WebElement> element3 =null; 
		boolean productSubscriptionStatus = false;
		boolean priceStatus = false;
		double total = 0.0;
		double totalPrice = 0.0;
		double parsedProductPrice = 0.0;
		Finder locator =new Finder();
				
		if(urlName.equals("ApplicationUrl11"))
				{
			 parsedPayingCost = Double.parseDouble(driver.findElement(locator.findBy("textboxes_txtPayingPrice")).getText().replaceAll(",", ".").replaceAll("-",""));
				}
		else
		{
		parsedPayingCost = Double.parseDouble(driver.findElement(locator.findBy("textboxes_txtPayingPrice")).getText().replaceAll(",", ".").replaceAll("-", ""));
		}
	
		parsedShippingPrice = Double.parseDouble(driver.findElement(locator.findBy("textboxes_txtShippingPrice")).getText().replaceAll(",", ".").replaceAll("-",""));
		

		if(!subsciptionName.equals("Uten abonnement") && !driver.getCurrentUrl().startsWith(properties.getProperty("ApplicationUrl10")))
		{
			if(urlName.equals("ApplicationUrl11"))
			{
			element3=driver.findElements(locator.findBy("textboxes_txtProductPrice3"));	
			}
			else
			{	
			element3=driver.findElements(locator.findBy("textboxes_txtProductPrice"));
			}
			StringBuilder value = new StringBuilder(8);
			value.append(mobileName[0]);
			value.append(" ");
			value.append("med");
			value.append(" ");
			value.append(subsciptionName);
			
			if(urlName.equals("ApplicationUrl11"))
			{
			List<WebElement> element = driver.findElements(locator.findBy("links_lnkAcessoriesName"));	
			productSubscriptionStatus =ProductSubscriptionStatus(element,value);	
			}
            
			else if(productCount==1)
			{	
			productSubscriptionStatus =ProductSubscriptionStatus(element2,value);
			}
			
			else if(productCount>1)
			{
		      StringBuilder thirdValue = new StringBuilder(8);
      		  thirdValue.append(mobileName[1]);
      		  thirdValue.append(" ");
      		  thirdValue.append("med");
      		  thirdValue.append(" ");
      		  thirdValue.append(dataTable.getData("General_Data","SubscriptionName"));
	          productSubscriptionStatus = ProductSubscriptionStatus(element2,value,thirdValue);
      	     }
     	   	
        	validateElementsStatus(productSubscriptionStatus,
					"Product with Subscription Name Verification",
					"Product contains mobile name with subscription",
					"Product doesn't contains  mobile name with subscription");
		}
	          else if(driver.getCurrentUrl().startsWith(properties.getProperty("ApplicationUrl10")))
	          {
	        	  List<WebElement> element = driver.findElements(locator.findBy("links_lnkNordilogProductName"));
	           	  element3=driver.findElements(locator.findBy("textboxes_txtProductPrice2"));
	           	             	   
	        	  StringBuilder secondValue = new StringBuilder(8);
	        	  secondValue.append(mobileName[0]);
	        	  secondValue.append(" ");
	         	  secondValue.append("med");
	        	  secondValue.append(" ");
	        	  secondValue.append(subsciptionName);
	        	  secondValue.append(" ");
	        	  secondValue.append("(Uten binding)");
	  			  productSubscriptionStatus = ProductSubscriptionStatus(element,secondValue);
	           	 
	        	  if(Incrementer>=1)
	        	  {
	        		  if(productSubscriptionStatus)
	        		  {  
	        		  StringBuilder thirdValue = new StringBuilder(8);
	        		  thirdValue.append(mobileName[0]);
	        		  thirdValue.append(" ");
	        		  thirdValue.append("med");
	        		  thirdValue.append(" ");
	        		  thirdValue.append(dataTable.getData("General_Data","SubscriptionName"));
		        	  thirdValue.append(" ");
		        	  thirdValue.append("(Uten binding)");
	        		  productSubscriptionStatus = ProductSubscriptionStatus(element,thirdValue);
	        	     }
	        	  }
	        	 validateElementsStatus(productSubscriptionStatus,
	  					"Product with Subscription Name Verification",
	  					"Product contains mobile name with subscription",
	  					"Product  doesn't contains mobile name with subscription");
	        	  }
				else
		    {
			element3=driver.findElements(locator.findBy("textboxes_txtProductPrice"));
			productSubscriptionStatus =ProductSubscriptionStatus(element2,null);
						
			validateElementsStatus(productSubscriptionStatus,
					"Product without subscription name Verification",
					"Product contains mobile name without subscription",
					"Product doesn't contains mobile name without subscription ");
		}
	
		for (WebElement productPrice : element3) {
			String price = productPrice.getText();
            		    
			if (Arrays.asList(mobilePrices).contains(price)) {
				priceStatus = true;
				//counter++;
				if(!urlName.equals("ApplicationUrl11")) {
				parsedProductPrice = Double.parseDouble(price.replaceAll(",",".").replaceAll("-",""));
				}
			
				else
				{
					parsedProductPrice = Double.parseDouble(price.replaceAll(",",".").replaceAll("-",""));
				}
				total += parsedProductPrice;
			} else {
				priceStatus = false;
				break;
			}
		}
		totalPrice = totalPrice + total + parsedShippingPrice;
        			
		validateElementsStatus(priceStatus, "Mobile Price Comparision",
				"Correct Mobile Price is displayed",
				"Correct Mobile Price is not displayed");

		if (Math.round(totalPrice*100.0)/100.0 == parsedPayingCost) 
			report.updateTestLog("Total Mobile Price Validation",
					"Total Price of Mobile is Correct", Status.PASS);
		else
			report.updateTestLog("Total Mobile Price Validation",
					"Total Price of Mobile is not Correct", Status.FAIL);
		
	}

	public void verifyBillingInformationValidations() throws ParserConfigurationException, SAXException, IOException {
		waitForPageLoaded(driver);
		String[] header = new String[8];
		double parsedPayingPrice =0.0;
		Finder locator =new Finder();
		String heading1 = driver.findElement(locator.findBy("textboxes_txtBillingHeading1")).getText();
		String heading2 = driver.findElement(locator.findBy("textboxes_txtBillingHeading2")).getText();
		String heading3 = driver.findElement(locator.findBy("textboxes_txtBillingHeading3")).getText();
		
		String heading4="",heading5="",heading6="";
		
		if(subsciptionName.equals("Uten abonnement") ||urlName.equals("ApplicationUrl11") )
		{
			heading4 = driver.findElement(locator.findBy("textboxes_txtBillingHeading5")).getText();
			heading5 = driver.findElement(locator.findBy("textboxes_txtBillingHeading6")).getText();
			heading6 = driver.findElement(locator.findBy("textboxes_txtBillingHeading7")).getText();
		}
		
		else
		{
		heading4 = driver.findElement(locator.findBy("textboxes_txtBillingHeading4")).getText();
		
		}
		StringBuilder value = new StringBuilder(8);
		List<WebElement> element2 = driver.findElements(locator.findBy("links_lnkProductSubscription"));
		
		int productCount = element2.size();
		List<WebElement> element3 = driver.findElements(locator.findBy("textboxes_txtMobileCost"));
		double parsedShippingCost = Double.parseDouble(driver.findElement(locator.findBy("textboxes_txtShippingCost")).getText().replaceAll(",", ".").replaceAll("-",""));
		
		if(!urlName.equals("ApplicationUrl11"))
		parsedPayingPrice = Double.parseDouble(driver.findElement(locator.findBy("textboxes_txtTotalCost")).getText().replaceAll(",",".").replaceAll("-",""));
		
		else
		 parsedPayingPrice = Double.parseDouble(driver.findElement(locator.findBy("textboxes_txtTotalCost")).getText().replaceAll(",", ".").replaceAll("-", ""));
		
		boolean shippingCost = false;
		//int counter = 0;
		double total = 0.0;
		double parsedProductPrice = 0.0;
		boolean productSubscriptionStatus = false;
		boolean priceStatus = false;
		double totalPrice = 0.0;
		value.append(mobileName[0]);
		value.append(" ");
		value.append("med");
		value.append(" ");
		value.append(subsciptionName);

		if (parsedShippingCost == parsedShippingPrice) {
			shippingCost = true;
		} else {
			shippingCost = false;
		}
              
		if(!subsciptionName.equals("Uten abonnement") && !urlName.equals("ApplicationUrl11"))
		{
			if(productCount==1)
		 {	
		for (WebElement productsubscription : element2) {

			if (productsubscription.getText().replaceAll("\n", "").trim()
					.toUpperCase()
					.equals(value.toString().trim().toUpperCase())) {
				productSubscriptionStatus = true;
			} else {
				productSubscriptionStatus = false;
				break;
			}
		}
		}
			else if(productCount>1)
    	     {
    		  StringBuilder thirdValue = new StringBuilder(8);
    		  thirdValue.append(mobileName[1]);
    		  thirdValue.append(" ");
    		  thirdValue.append("med");
    		  thirdValue.append(" ");
    		  thirdValue.append(dataTable.getData("General_Data","SubscriptionName"));
	          productSubscriptionStatus = ProductSubscriptionStatus(element2,value,thirdValue);
    	     }
   	  
		
		if(productSubscriptionStatus)
			report.updateTestLog("Product Name Validation in Billing page",
					"Product contains mobile with subscription name", Status.PASS);
		else 
		report.updateTestLog("Product Name Validation in Billing Page",
					"Product doesn't contains mobile with subscription name", Status.FAIL);
		}
		

		for (WebElement productPrice : element3) {
			String price = productPrice.getText();

			if (Arrays.asList(mobilePrices).contains(price)) {
				priceStatus = true;
				//counter++;
				if(!urlName.equals("ApplicationUrl11"))
				parsedProductPrice = Double.parseDouble(price.replaceAll(",",".").replaceAll("-",""));
				else
					parsedProductPrice = Double.parseDouble(price.replaceAll(",",".").replaceAll("-",""));
				
				total += parsedProductPrice;
			} else {
				priceStatus = false;
				break;
			}
		}
		totalPrice = totalPrice + total + parsedShippingCost;
                 
		if(!subsciptionName.equals("Uten abonnement"))
		{
		for (int var = 1; var <= 4; var++) {
			header[var] = dataTable.getData("BillingInformations_Data",
					"Header" + var);
		}
		}
		else
		{
			for (int var = 1; var <= 6; var++) {
				header[var] = dataTable.getData("BillingInformations_Data",
						"Header" + var);
		}
		}
		if (header[1].equals(heading1))
			report.updateTestLog("Billing Details Page Validation",
					"First name text is correctly displayed", Status.PASS);
		
		else 
			report.updateTestLog("Billing Details Page Validation",
					"First name text is not Correctly displayed", Status.FAIL);
				
		if(header[2].equals(heading2))
			report.updateTestLog("Billing Details Page Validation",
					"Last name text is correctly displayed", Status.PASS);
		else 
			report.updateTestLog("Billing Details Page Validation",
					"Last name text is  not correctly displayed", Status.FAIL);
		
		if(header[3].equals(heading3))
		  report.updateTestLog("Billing Details Page Validation",
					"Email text is correctly Displayed", Status.PASS);
		else 
		report.updateTestLog("Billing Details Page Validation",
					"Email text is not correctly Displaye", Status.FAIL);
		
		if(header[4].equals(heading4))
			 report.updateTestLog("Billing Details Page Validation",
						"National identity number text or Address text is correctly displayed", Status.PASS);
			else 
			report.updateTestLog("Billing Details Page Validation",
						"National identity number text or Address text is not correctly displayed", Status.FAIL);
		 
		 
				
			
			if(subsciptionName.equals("Uten abonnement") && urlName.equals("ApplicationUrl11"))
			{
				if(header[5].equals(heading5))
					 report.updateTestLog("Billing Details Page Validation",
								"Postal city text is correctly displayed", Status.PASS);
					else 
					report.updateTestLog("Billing Details Page Validation",
								"Postal city text is not correctly displayed", Status.FAIL);
				
				if(header[6].equals(heading6))
					 report.updateTestLog("Billing Details Page Validation",
								"Postal code text is correctly displayed", Status.PASS);
					else 
					report.updateTestLog("Billing Details Page Validation",
								"Postal code text is not correctly displayed", Status.FAIL);
				 
			}

			if(priceStatus)
				report.updateTestLog("Billing Details Page Validation",
						"Product price is correctly displayed", Status.PASS);
			else 
			report.updateTestLog("Billing Details Page Validation",
						"Product price is not correctly displayed", Status.FAIL);
						
			
			if(shippingCost)
				report.updateTestLog("Billing Details Page Validation",
						"Shipping cost is correctly displayed", Status.PASS);
			else 
			report.updateTestLog("Billing Details Page Validation",
						"Shipping cost is not correctly displayed", Status.FAIL);
           
			
			if(totalPrice == parsedPayingPrice) 
				report.updateTestLog("Billing Details Page Validation",
						"Total price is correctly displayed", Status.PASS);
			else 
				report.updateTestLog("Billing Details Page Validation",
							"Total price is not correctly displayed", Status.FAIL);
			
			
			
	}

	public void validateElementsStatus(boolean elementStatus,String reportMessage, String passMessage, String failMessage) {
		if (elementStatus)
			report.updateTestLog(reportMessage, passMessage, Status.PASS);
		else
			report.updateTestLog(reportMessage, failMessage, Status.FAIL);

	}
	
	public void verifyElementsStatus(boolean elementStatus,String reportMessage, String passMessage, String failMessage) {
		if (elementStatus)
			report.updateTestLog(reportMessage, passMessage, Status.WARNING);
		else
			report.updateTestLog(reportMessage, failMessage, Status.WARNING);

	}

	public void getTextForListAndCompare(List<WebElement> element,String compareItem, String reportMessage, String passMessage,String failMessage) {
		if(!compareItem.equals("Uten abonnement"))
		{
		for (WebElement elementList : element) {
			if (elementList.getText().equals(compareItem))
				report.updateTestLog(reportMessage, passMessage, Status.PASS);

			else
				report.updateTestLog(reportMessage, failMessage, Status.FAIL);

		}
		}

	}
	
	public void addressInformationValidation() throws InterruptedException, ParserConfigurationException, SAXException, IOException
	{
		Finder locator =new Finder();
		driver.findElement(locator.findBy("links_lnkAddressInformationTab")).click();
		 Thread.sleep(3000);
		 String TotalDeliveryAddress = "";
		 String TotalBillingAddress = "";
		
		
		String billingName = driver.findElement(locator.findBy("textboxes_txtName1")).getText();
		String billingAddress = driver.findElement(locator.findBy("textboxes_txtAddress1")).getText();
		String billingPostCode = driver.findElement(locator.findBy("textboxes_txtPostalCode1")).getText();
		String billingCity =driver.findElement(locator.findBy("textboxes_txtPostalAddress1")).getText();
		
		
		
		String  deliveryName = driver.findElement(locator.findBy("textboxes_txtName2")).getText();
		String deliveryAddress = driver.findElement(locator.findBy("textboxes_txtAddress2")).getText();
		String deliveryPostCode = driver.findElement(locator.findBy("textboxes_txtPostalCode2")).getText();
		String deliveryCity =driver.findElement(locator.findBy("textboxes_txtPostalAddress2")).getText();
		
		   
		  if(!flagUrl)
		  {
				TotalBillingAddress=billingName+billingAddress+billingPostCode+billingCity;
    		    TotalDeliveryAddress=deliveryName+deliveryAddress+deliveryPostCode+deliveryCity;

			  if(TotalBillingAddress.replaceAll(" ","").trim().equals(totalAddress.replaceAll(" ","").trim()))
		 report.updateTestLog("Billing Details Validation",
					"All the values are Correctly Displayed", Status.PASS);
		else
			report.updateTestLog("Billing Details Validation",
					"All the values are Not Correctly Displayed", Status.FAIL);
		
		
		if(TotalDeliveryAddress.replaceAll(" ","").trim().equals(totalAddress.replaceAll(" ","").trim()))
			 report.updateTestLog("Delivery Details Validation",
						"All the values are Correctly Displayed", Status.PASS);
			else
				report.updateTestLog("Delivery Details Validation",
						"All the values are Not Correctly Displayed", Status.FAIL);
		  }
		  
		  else
		  {
			  String billingFirm = driver.findElement(locator.findBy("textboxes_txtbiilingfirm")).getText();
			  String deliveryFirm = driver.findElement(locator.findBy("textboxes_txtdeliveryfirm")).getText();
			  
			  TotalBillingAddress = billingFirm+billingAddress+billingPostCode+billingCity;
			  String totalBillingAddress = TotalBillingAddress.replaceAll(" ","").trim();
			  
			  TotalDeliveryAddress = deliveryFirm+deliveryAddress+deliveryPostCode+deliveryCity;
			  String totalShippingAddress = TotalDeliveryAddress.replaceAll(" ", "").trim();
			  
			 String test1= billAddress.replaceAll("\n","");
			 String billedAddress =test1.replaceAll(" ","").trim();
			  
			 String test2 =shipAddress.replaceAll("\n","");
			 String shippingAddress = test2.replaceAll(" ","").trim();
			  
			  if(totalBillingAddress.equals(billedAddress))
					 report.updateTestLog("Billing Details Validation",
								"All the values are Correctly Displayed", Status.PASS);
					else
						report.updateTestLog("Billing Details Validation",
								"All the values are Not Correctly Displayed", Status.FAIL);
					
					
					if(totalShippingAddress.equals(shippingAddress))
						 report.updateTestLog("Delivery Details Validation",
									"All the values are Correctly Displayed", Status.PASS);
						else
							report.updateTestLog("Delivery Details Validation",
									"All the values are Not Correctly Displayed", Status.FAIL);
			  }
		}
	
	
	public void paymentInformationValidation() throws InterruptedException, ParserConfigurationException, SAXException, IOException
	{
		Finder locator =new Finder();
		driver.findElement(locator.findBy("links_lnkPaymentInformationTab")).click();
		Thread.sleep(3000);
		String paymentMethod = driver.findElement(locator.findBy("textboxes_txtPaymentMethod")).getText();
		String[] paymentsplited =new String[3];
	    paymentsplited = creditdetails.split("/");
		 
		 if(paymentsplited[0].replaceAll(" ","").trim().equals(paymentMethod)||paymentsplited[1].replaceAll(" ","").trim().equals(paymentMethod))
			 report.updateTestLog("Payment Details Validation",
						"Payment Details are successfuly validated",Status.PASS);
			else
				report.updateTestLog("Payment Details Validation",
						"Payment Details are not successfuly vlaidated", Status.FAIL);
		 
		 		 		 		 
		 String invoiceNumber = driver.findElement(locator.findBy("textboxes_txtInvoiceNumber")).getText();
		 String invoiceStatus = driver.findElement(locator.findBy("textboxes_txtInvoiceStatus")).getText().trim();
		 
		 if(invoiceNumber!=null)
			 report.updateTestLog("Invoice Number Validation",
						"Invoice Number is successfuly generated",Status.PASS);	 
		 else
			 report.updateTestLog("Invoice Number Validation",
						"Invoice Number is not successfuly generated",Status.FAIL);	 
		 
		 
		 if(!flagUrl)
		 {	 
		 if(invoiceStatus.equals("Betaling utført"))
			 report.updateTestLog("Invoice Status Validation","Invoice Status is successfuly validated",Status.PASS);
		 else
		 	{
			 if(invoiceStatus.equals("Betaling ikke utført"))
				 report.updateTestLog("Invoice Status Validation","Invoice Status is successfuly validated",Status.PASS);else
				 {
					 if(invoiceStatus.equals("Betaling kreditert"))
						 report.updateTestLog("Invoice Status Validation","Invoice Status is successfuly validated",Status.PASS); else
						 report.updateTestLog("Invoice Status Validation","Invoice Status not successfuly validated",Status.FAIL);
				 }	 
		 	}
		 }
		 
	}
	
	
	public void verifyProductDetails() throws InterruptedException, ParserConfigurationException, SAXException, IOException
	{
	waitForPageLoaded(driver);
	Thread.sleep(5000);
	Finder locator =new Finder();
	
	driver.findElement(locator.findBy("links_lnkButikkMenu")).click();
	waitForPageLoaded(driver);
	driver.findElement(locator.findBy("textboxes_txtButtik")).sendKeys("Telenor");
	driver.findElement(locator.findBy("links_lnkSearch")).click();
	waitForPageLoaded(driver);
	driver.findElement(locator.findBy("links_lnkAssortment")).click();
	waitForPageLoaded(driver);
	driver.findElement(locator.findBy("links_lnkAlleProdukter")).click();
    Thread.sleep(5000);
    driver.findElement(locator.findBy("links_lnksearchbutton")).click();
	Thread.sleep(8000);
	List<WebElement> element1 = driver.findElements(locator.findBy("images_imgProductImage"));
	List<WebElement> element2 = driver.findElements(locator.findBy("textboxes_txtAttributes2"));
	List<WebElement> element3 = driver.findElements(locator.findBy("textboxes_txtSupplierLabel"));
    List<WebElement> element4 = driver.findElements(locator.findBy("textboxes_txtAttributes1"));

    if(element1.size()>=1 && element2.size()>=1 && element3.size()>=1 && element4.size()>=1 )
	report.updateTestLog("Product List Validation",
			"List of products with cost,inventory and supplier are displayed",Status.PASS);	
    
    else
    	report.updateTestLog("Product List Validation",
    			"List of products with cost,inventory and supplier are not displayed",Status.FAIL);	
   }
	
	public void verifyTaskStatusOk() throws InterruptedException, ParserConfigurationException, SAXException, IOException
	{
	waitForPageLoaded(driver);
	Finder locator =new Finder();
	driver.findElement(locator.findBy("links_lnkStatus")).click();
	//Thread.sleep(15000);
	try
	{
		fluentwait(locator.findBy("images_imgAjaxLoad"));
	}
	catch(Exception e){
		e.printStackTrace();
	}
	List<WebElement> numberOfTasks= driver.findElements(locator.findBy("textboxes_txtAllTasks"));
	List<WebElement> numberOfTasksOk= driver.findElements(locator.findBy("textboxes_txtStatusOk"));
	
	if(numberOfTasks.size()==numberOfTasksOk.size())
	report.updateTestLog("Task Status Ok","All task status shown OK",Status.PASS);
	
	else
	report.updateTestLog("Task Status Ok","All task status are not shown Ok",Status.FAIL);
	
	}
	
	
	public boolean ProductSubscriptionStatus(List<WebElement> element1,StringBuilder value) 
	{
		boolean SubscriptionStatus=false;
		
		if(urlName.equals("ApplicationUrl11") || subsciptionName.equals("Uten abonnement") || dataTable.getData("General_Data","SubscriptionName").equalsIgnoreCase("No") || subsciptionName.isEmpty() )
		{
			for (WebElement productsubscription : element1) {

				if (Arrays.asList(mobileName).contains(productsubscription.getText().trim())) {
					SubscriptionStatus = true;
				}
				
				else if (productsubscription.getText().replaceAll("\n", "").trim()
						.toUpperCase()
						.equals(value.toString().trim().toUpperCase())) {
					SubscriptionStatus = true;
			    	}
				else {
					SubscriptionStatus = false;
					break;
				}
		}
		}
			
			else
			{
		     for (WebElement productsubscription : element1) {
     		
		    	 if (productsubscription.getText().replaceAll("\n", "").trim().toUpperCase().contains(value.toString().trim().toUpperCase())|| Arrays.asList(mobileName).contains(productsubscription.getText().trim()))
     		        SubscriptionStatus = true;
     		/*if (Arrays.asList(mobileName).contains(productsubscription.getText().trim())) {
				SubscriptionStatus = true;
			}*/
    		else {
			SubscriptionStatus = false;
			break;
		}
	 }
			}
			
				     
				     
     
	 return SubscriptionStatus;
	}
	
	
	public boolean ProductSubscriptionStatus(List<WebElement> element1,StringBuilder value1,StringBuilder value2) 
	{
		boolean SubscriptionStatus=false;
		for (WebElement productsubscription : element1) {
     		
		   if (productsubscription.getText().replaceAll("\n", "").trim().toUpperCase().contains(value1.toString().trim().toUpperCase()))
     		        SubscriptionStatus = true;
     		/*if (Arrays.asList(mobileName).contains(productsubscription.getText().trim())) {
				SubscriptionStatus = true;
			}*/
		   
		   else if((productsubscription.getText().replaceAll("\n", "").trim().toUpperCase().contains(value2.toString().trim().toUpperCase())))
				   SubscriptionStatus = true;
    	
				   else {
			SubscriptionStatus = false;
			break;
		}
	 
			}
	 
	 return SubscriptionStatus;
	}
	
	
	public void verifyPaymentDetailsValidation() throws InterruptedException, ParserConfigurationException, SAXException, IOException
	{
		waitForPageLoaded(driver);
		Finder locator =new Finder();
		
		String productprice =driver.findElement(locator.findBy("textboxes_txtPaymentDetailsPrice")).getText();	
		String productpricetrimmed=productprice.replaceAll(" ","");
		double parsedProductPrice = Double.parseDouble(productpricetrimmed);
		
		if(parsedProductPrice==parsedPayingCost)
		{
			report.updateTestLog("Product Price Validation in Payment Page ","Correct product price is displayed ",Status.PASS);
		}
		else
		{
			report.updateTestLog("Product Price Validation in Payment Page ","Correct product price is displayed ",Status.FAIL);	
		}
		
	}
	
	public void fluentwait(final By element)
	{
  		
  		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
  		       .withTimeout(120, TimeUnit.SECONDS)
  		       .pollingEvery(5, TimeUnit.SECONDS)
  		       .ignoring(NoSuchElementException.class);

  		   WebElement foo = wait.until(new Function<WebDriver, WebElement>() 
  				   {
		  		     public WebElement apply(WebDriver driver) 
		  		     {
		  		       return driver.findElement(element);
		  		     }
  				   }
  		   );
	}
	
	
	public By findByDynXpath(By locatorName, String object) {
		By by=null;
		String locator =locatorName.toString();
		String xpathRemoved = locator.replaceAll("By.xpath: ","");
		String dynamicAdd =xpathRemoved.replaceAll("@1@",object);
		by= By.xpath(dynamicAdd);
		return by;
	}
	
	public void windowMaximize() throws AWTException
  	{
  	Robot rob = new Robot();
    rob.keyPress(KeyEvent.VK_WINDOWS);
    rob.keyPress(KeyEvent.VK_UP);
    rob.keyRelease(KeyEvent.VK_WINDOWS);
    rob.keyRelease(KeyEvent.VK_UP);
  	}
	
	/** This Function is used to check status of orders in HAPI
	 * 
	 * @throws InterruptedException
  	 * @throws IOException 
  	 * @throws SAXException 
  	 * @throws ParserConfigurationException 
	 */
	public void hapiOrderCheck() throws AWTException, InterruptedException, ParserConfigurationException, SAXException, IOException
  	{
		Finder locator = new Finder();
		waitForPageLoaded(driver);
		
		WebElement hapiMenu = driver.findElement(locator.findBy("buttons_btnHapiHapi"));
	 	WebElement hapiSubMenu = driver.findElement(locator.findBy("buttons_btnHapiOrders"));
	 	
	 	Actions builder = new Actions(driver);
	 	builder.moveToElement(hapiMenu).click().moveToElement(hapiSubMenu).click().build().perform();
	 	waitForPageLoaded(driver);
	 	
	 	try
	 	{
	 		Actions builder1 = new Actions(driver);
		 	builder1.moveToElement(driver.findElement(locator.findBy("buttons_btnHapiHapi"))).moveToElement(driver.findElement(locator.findBy("buttons_btnHapiOrders"))).build().perform();
	 	}
	 	catch(Exception e)
	  	{
	  	   e.printStackTrace();  
	  	}
	 	waitForPageLoaded(driver);
	 	
	 	driver.findElement(locator.findBy("textboxes_txtHapiOrderSearch")).sendKeys(hashmap.get("orderNumber"));
		driver.findElement(locator.findBy("buttons_btnHapiOrderSearch")).click();
		fluentwait(locator.findBy("images_imgAjaxLoadHapi"));	
		Thread.sleep(2500L);
		boolean hapiOrderStatus = driver.findElement(locator.findBy("textboxes_txtHapiOrderStatus")).getText().trim().equals(dataTable.getData("General_Data", "OrderNumberStatus").trim());
		
		if(hapiOrderStatus)
		report.updateTestLog("Order validation - Hapi","Order validation is successful ",Status.PASS);
		else
		report.updateTestLog("Order validation - Hapi","Order validation is not successful",Status.FAIL);	
		
  	}
	
	/** This Function is used to check Navision status of orders in HAPI
	 * 
	 * @throws InterruptedException
  	 * @throws IOException 
  	 * @throws SAXException 
  	 * @throws ParserConfigurationException 
	 */
	public void hapiNavisonOrderCheck() throws AWTException, InterruptedException, ParserConfigurationException, SAXException, IOException
  	{
		waitForPageLoaded(driver);
		
		Finder locator = new Finder();
		WebElement hapiNavMenu = driver.findElement(locator.findBy("buttons_btnNavisionHapi"));
	 	WebElement hapiNavSubMenu1 = driver.findElement(locator.findBy("buttons_btnHapiNavB2COrders"));
	 	
	 	Actions builder = new Actions(driver);
	 	builder.moveToElement(hapiNavMenu).click().moveToElement(hapiNavSubMenu1).click().build().perform();
	 	waitForPageLoaded(driver);
	 	
	 	try
	 	{
	 		Actions builder1 = new Actions(driver);
		 	builder1.moveToElement(driver.findElement(locator.findBy("buttons_btnNavisionHapi"))).moveToElement(driver.findElement(locator.findBy("buttons_btnHapiNavB2COrders"))).build().perform();
	 	}
	 	catch(Exception e)
	  	{
	  	   e.printStackTrace();  
	  	}
	 	waitForPageLoaded(driver);
	 	
	 	driver.findElement(locator.findBy("textboxes_txtHapiOrderSearch")).sendKeys(hashmap.get("orderNumber"));
		driver.findElement(locator.findBy("buttons_btnHapiNavOrderSearch")).click();
		fluentwait(locator.findBy("images_imgAjaxLoadHapi"));
		Thread.sleep(2500L);
		
		boolean hapiNavOrderid = driver.findElement(locator.findBy("textboxes_txtHapiNavOrderid")).getText().trim().equals(hashmap.get("orderNumber"));
		boolean hapiNavHapiBillToName = driver.findElement(locator.findBy("textboxes_txtHapiBillToName")).getText().trim().equals(dataTable.getData("BillingInformations_Data", "FirstName")+" "+dataTable.getData("BillingInformations_Data", "LastName"));
		boolean hapiNavHapiShipToName = driver.findElement(locator.findBy("textboxes_txtHapiShipToName")).getText().trim().equals(dataTable.getData("BillingInformations_Data", "FirstName")+" "+dataTable.getData("BillingInformations_Data", "LastName"));
		
		if(hapiNavOrderid && hapiNavHapiBillToName && hapiNavHapiShipToName)
		report.updateTestLog("Order validation - Hapi","Order validation is successful ",Status.PASS);
		else
		report.updateTestLog("Order validation - Hapi","Order validation is not successful",Status.FAIL);	
		
  	}
	
	/** This Function is used for cancel orders in mBiz
	 * 
	 * @throws InterruptedException
  	 * @throws IOException 
  	 * @throws SAXException 
  	 * @throws ParserConfigurationException 
	 */
	public void cancelOrder() throws AWTException, InterruptedException, ParserConfigurationException, SAXException, IOException
  	{
		Finder locator = new Finder();
		utils.verifyAndClickButton("buttons_btnCancelOrder", "Cancel Order");
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		boolean InternstatusCancel = driver.findElement(locator.findBy("buttons_btnCancelOrder")).isDisplayed();
		utils.verifyAndClickButton("buttons_btnCancelOrder", "Cancel Order");
		alert.accept();
		Thread.sleep(1000L);
		waitForPageLoaded(driver);
		boolean InternstatusOK = driver.findElement(locator.findBy("textboxes_txtInternstatus")).getText().trim().equals(dataTable.getData("General_Data", "Internstatus").trim());
		
		if(InternstatusCancel && InternstatusOK)
			report.updateTestLog("Cancel Order","Order cancellation successful",Status.PASS);
			else
			report.updateTestLog("Cancel Order","Order cancellation unsuccessful",Status.FAIL);	
  	}
	
	public void useExistingMobileNumber() throws AWTException, InterruptedException, ParserConfigurationException, SAXException, IOException
  	{
		Finder locator = new Finder();
		String parentWindow =driver.getWindowHandle();
		
		switchtoNewWindow(parentWindow);
		waitForPageLoaded(driver);
		utils.verifyAndClickButton("buttons_btnSameMobNoCancel", "Cancel");
		Thread.sleep(500L);
		switchBacktoOldWindow(parentWindow);
		
		boolean ErrorMsg = driver.findElement(locator.findBy("textboxes_txtUseExistingMobileError")).getText().trim().equals(dataTable.getData("General_Data", "ErrorMsg").trim());
		if(ErrorMsg)
		utils.verifyAndClickButton("buttons_btnDeliveryPayment","Delivery Payment");
		waitForPageLoaded(driver);
		Thread.sleep(500L);
		
		switchtoNewWindow(parentWindow);
		Thread.sleep(500L);
		utils.verifyAndClickButton("buttons_btnSameMobNoProceed", "Proceed");
		waitForPageLoaded(driver);
		Thread.sleep(500L);
		switchBacktoOldWindow(parentWindow);
		
		boolean shippingRadioButton=driver.findElement(locator.findBy("buttons_btnRadio1")).isSelected();
		
		if(ErrorMsg && shippingRadioButton)
			report.updateTestLog("Checkout and use existing Number","Order processing successful",Status.PASS);
			else
			report.updateTestLog("Checkout and use existing Number","Order processing unsuccessful",Status.FAIL);	
  	}
	
	
	public void verifyAdminRightsB2BUsers() throws AWTException, InterruptedException, ParserConfigurationException, SAXException, IOException
  	{
		Finder locator = new Finder();
		List<WebElement> usersList = driver.findElements(locator.findBy("links_lnkListUsersName"));
		int counter =1;
			
		for(WebElement element:usersList)
		{
			
			String test = element.getText().trim();
			if(test.equals(FunctionalComponents_old.b2bUser.trim()))
					{
					 boolean uersRolesCheck =driver.findElement(findByDynXpath(locator.findBy("textboxes_txtUsersRole"),String.valueOf(counter))).getText().trim().equals(dataTable.getData("General_Data", "Roles"));
					 if(uersRolesCheck)
					 report.updateTestLog("B2B Users Roles Selection Verification","Sucessfully provided Administrator Access",Status.PASS);
					 else
				     report.updateTestLog("B2B Users Roles Selection Verification","Error in providing Administrator Access",Status.FAIL);	 
					 break;
					} 
			  counter++;
		}
  	}
	
	public void verifyOrderApprovalB2BUsers() throws AWTException, InterruptedException, ParserConfigurationException, SAXException, IOException
  	{
	Finder locator = new Finder();
	List<WebElement> usersList = driver.findElements(locator.findBy("links_lnkListUsersName"));
	int counter =1;
	
	for(WebElement element:usersList)
	{
		if(element.getText().trim().equals(FunctionalComponents_old.b2bUser.trim()))
				{
					 boolean uersRolesCheck =driver.findElement(findByDynXpath(locator.findBy("textboxes_txtUsersRights"),String.valueOf(counter))).getText().trim().equals(dataTable.getData("General_Data", "OrderApproval"));
					 if(uersRolesCheck)
					 report.updateTestLog("B2B Users Roles Selection Verification","Sucessfully provided Approver Access",Status.PASS);
					 else
				     report.updateTestLog("B2B Users Roles Selection Verification","Error in providing Approver Access",Status.FAIL);	 
					 break;	
				}
	       counter++;		
	}
	
	
}
}


