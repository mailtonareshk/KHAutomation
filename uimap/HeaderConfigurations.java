package uimap;

import org.openqa.selenium.By;

/**
 * UI Map for HeaderConfigurationPage 
 */

public class HeaderConfigurations {
	
	// links
	public static final By lnkProductMenu = By.xpath("//div[contains(@id,'mainmenu')]/nav/ul/li[1]/a");
	public static final By lnkProductCatalog = By.xpath("//div[contains(@id,'mainmenu')]/nav/ul/li[1]/ul/li[5]/a");

	// Text boxes	
	public static final By txtSearchBox = By.xpath("//div[@id='show-search']//input[@id='SearchText']");
		
	// Buttons
	public static final By btnSearch = By.xpath("//div[@id='show-search']//input[@name='Search']");	
	public static final By btnProductEdit= By.xpath("//div[@class='form']/form[1]/input[@class='standardbutton']");	
	public static final By btnProductText= By.xpath("//div[@class='wizard-steps']/ul/li[4]/p/a[@class='showchangewarning']");
	
	// Combo boxes
	public static final By cmbLevel1 = By.xpath("//div[@id='tagSelect']/ul[1]/li/input[@class='topLevel']");
	public static final By cmbLevel2 = By.xpath("//div[@id='tagSelect']/ul[@id='secondLevel']/li/input[@class='secondLevel']");
	public static final By cmbLevel3 = By.xpath("//div[@id='tagSelect']/ul[@id='thirdLevel']/li/input[@class='thirdLevel']");
	
	
}
