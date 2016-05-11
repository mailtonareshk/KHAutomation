package uimap;

import org.openqa.selenium.By;

/**
 * UI Map for MasterPage 
 */
public class MasterPage
{
	// Links
	public static final By lnkLogOff = By.xpath("//div[@class='user']//div[@class='right']//a");
	public static final By lnkLogOut = By.xpath("//div[@id='header']//a[@id='Body_LogOut']");
	//public static final By lnkLogOutHapi = By.xpath("//div[@class='container']//div[8]//a[contains(text(),'Log out')]");
	public static final By lnkLogOutHapi = By.xpath("//div[@class='container']//div[@class='pull-right']//a[contains(text(),'Log out')]");
	public static final By lnkRegister = By.linkText("REGISTER");
	public static final By lnkLogut =By.xpath("//div[@class='user']//ul//li//a[contains(text(),'Logg ut')]");
}