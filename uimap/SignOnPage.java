package uimap;

import org.openqa.selenium.By;

/**
 * UI Map for SignOnPage 
 */
public class SignOnPage
{
	// Text boxes
	public static final By txtUsername = By.xpath("//form//p[1]//input[@id='username']");
	public static final By txtPassword = By.xpath("//form//p[2]//input[@id='password']");
	public static final By txtUsername2 = By.xpath("//form[@id='form1']//div//input[@id='txtUser']");
	public static final By txtPassword2 = By.xpath("//form[@id='form1']//div//input[@id='txtPass']");
	public static final By txtTelephoneNumber = By.xpath("//div[@id='phoneLogin']//div[@id='enterPhoneNumber']//input[@id='PhoneNumberBox']");
	public static final By txtPassword3 = By.xpath("//div[@id='phoneLogin']//div[@id='enterTemporaryPassword']//input[@id='TemporaryPasswordBox']");
	public static final By txtUsername4 = By.xpath("//div[@class='form-group']//input[@id='Username']");
	public static final By txtPassword4 = By.xpath("//form[@method='post']//div[2]//input[@id='Password']");
	public static final By txtUsername5 = By.xpath("//div[@class='centered']//input[@id='Username']");
	public static final By txtPassword5 = By.xpath("//div[@class='centered']//input[@id='Password']");
	public static final By txtSplitPayment = By.xpath("//div[@class='centered']//input[@id='SplitPaymentAmount']");
	public static final By txtEmail= By.xpath("//div[@class='centered']//input[@id='EmailId']");
	// Buttons
	public static final By btnLogin = By.xpath("//div[@class='content']//div[@id='content']//form//input[@type='submit']");
	public static final By btnLogin2 = By.xpath("//form[@id='form1']//div//input[@id='btnLogin']");
	public static final By btnLogin3 = By.xpath("//div[@id='phoneLogin']//div[@id='enterPhoneNumber']//input[@id='sendSmsButton']");
	public static final By btnLogin4 = By.xpath("//div[@id='phoneLogin']//div[@id='enterTemporaryPassword']//input[@id='PhoneLoginButton']");
	public static final By btnLogin5 = By.xpath("//form[@method='post']//button[@type='submit']");
	public static final By btnLogin6 = By.xpath("//div[@class='centered']//input[@type='submit']");

}