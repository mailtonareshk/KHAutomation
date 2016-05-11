package supportlibraries;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.WebClient;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.opera.core.systems.OperaDriver;
import com.opera.core.systems.OperaProfile;

import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.remote.*;
import com.cognizant.framework.FrameworkException;
import com.cognizant.framework.Settings;


/**
 * Factory class for creating the {@link WebDriver} object as required
 * @author Cognizant
 */
public class WebDriverFactory
{
	private static Properties properties;
	
	private WebDriverFactory()
	{
		// To prevent external instantiation of this class
	}
	
	
	/**
	 * Function to return the appropriate {@link WebDriver} object based on the parameters passed
	 * @param browser The {@link Browser} to be used for the test execution
	 * @return The corresponding {@link WebDriver} object
	 */
	@SuppressWarnings("deprecation")
	public static WebDriver getDriver(Browser browser)
	{
		WebDriver driver = null;
		properties = Settings.getInstance();
		Boolean proxyRequired =
				Boolean.parseBoolean(properties.getProperty("ProxyRequired"));
		
		switch(browser) {
		case Chrome:
			// Takes the system proxy settings automatically
			
			
			/*DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
			chromeCapabilities.setCapability("requireWindowFocus", true);
			chromeCapabilities.setCapability(CapabilityType.ENABLE_PERSISTENT_HOVERING, true);*/
			
			System.setProperty("webdriver.chrome.driver",
					properties.getProperty("ChromeDriverPath"));

			driver = new ChromeDriver();
			break;
			
		case Firefox:
			// Takes the system proxy settings automatically
			//DesiredCapabilities firefoxCapabilities = DesiredCapabilities.firefox();
			//firefoxCapabilities.setCapability("requireWindowFocus", true);
			//firefoxCapabilities.setCapability(CapabilityType.ENABLE_PERSISTENT_HOVERING, true);
			driver = new FirefoxDriver();
			break;
			
		case HtmlUnit:
			// NTLM authentication for proxy supported
			
			if (proxyRequired) {
				driver = new HtmlUnitDriver() {
				@Override
				protected WebClient modifyWebClient(WebClient client) {
					DefaultCredentialsProvider credentialsProvider = new DefaultCredentialsProvider();
					credentialsProvider.addNTLMCredentials(properties.getProperty("Username"),
															properties.getProperty("Password"),
															properties.getProperty("ProxyHost"),
															Integer.parseInt(properties.getProperty("ProxyPort")),
															"", properties.getProperty("Domain"));
					client.setCredentialsProvider(credentialsProvider);
					return client;
					}
				};
				
				((HtmlUnitDriver) driver).setProxy(properties.getProperty("ProxyHost"),
											Integer.parseInt(properties.getProperty("ProxyPort")));
			} else {
				driver = new HtmlUnitDriver();
			}
			
			break;
			
		//case InternetExplorer:
			// Takes the system proxy settings automatically
	        // DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		      //ieCapabilities.setCapability("requireWindowFocus", true);
		      //ieCapabilities.setCapability(CapabilityType.ENABLE_PERSISTENT_HOVERING, true);
		      //properties = Settings.getInstance();
			 // System.setProperty("webdriver.ie.driver",properties.getProperty("InternetExplorerDriverPath"));
              //driver = new InternetExplorerDriver(ieCapabilities);
			 // break;
			
			  
		case InternetExplorer:
			//To manage cookies and settings
			properties = Settings.getInstance();
			System.setProperty("webdriver.ie.driver",properties.getProperty("InternetExplorerDriverPath"));
			driver = new InternetExplorerDriver();
			driver.manage().deleteAllCookies();
			driver.quit(); 
            System.setProperty("webdriver.ie.driver",properties.getProperty("InternetExplorerDriverPath")); 
            DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,false);
			ieCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			ieCapabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,false);
			driver = new InternetExplorerDriver();
			//*/
			break; 

	   case Opera:
			// NTLM authentication for proxy not supported
			
			if (proxyRequired) {
				DesiredCapabilities desiredCapabilities = getProxyCapabilities();
				driver = new OperaDriver(desiredCapabilities); 
				
			} else {
			 DesiredCapabilities operaCapabilities = DesiredCapabilities.opera();
			 OperaProfile profile = new OperaProfile("C:\\Users\\343719\\AppData\\Roaming\\Opera\\Opera"); 
			 operaCapabilities.setJavascriptEnabled(true);
			 operaCapabilities.setCapability("opera.profile", profile);
			 operaCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			 driver = new OperaDriver(operaCapabilities);
			}
			
			break;
			
		case Safari:
			// Note that usage of SafariDriver requires lot of prior configuration
			// Refer http://code.google.com/p/selenium/wiki/SafariDriver for details
			
			// NTLM authentication for proxy not supported
			
			if (proxyRequired) {
				DesiredCapabilities desiredCapabilities = getProxyCapabilities();
				driver = new SafariDriver(desiredCapabilities);
			} else {
				driver = new SafariDriver();
			}
			break;
			
		default:
			throw new FrameworkException("Unhandled browser!");
		}
		
		return driver;
	}
	
	/**
	 * Function to return the appropriate {@link WebDriver} object based on the parameters passed
	 * @param browser The {@link Browser} to be used for the test execution
	 * @param remoteUrl The URL of the remote machine to be used for the test execution
	 * @return The corresponding {@link WebDriver} object
	 */
	public static WebDriver getDriver(Browser browser, String remoteUrl)
	{
		return getDriver(browser, null, null, remoteUrl);
	}
	
	/**
	 * Function to return the appropriate {@link WebDriver} object based on the parameters passed
	 * @param browser The {@link Browser} to be used for the test execution
	 * @param browserVersion The browser version to be used for the test execution
	 * @param platform The {@link Platform} to be used for the test execution
	 * @param remoteUrl The URL of the remote machine to be used for the test execution
	 * @return The corresponding {@link WebDriver} object
	 */
	public static WebDriver getDriver(Browser browser, String browserVersion,
												Platform platform, String remoteUrl)
	{
		// For running RemoteWebDriver tests in Chrome and IE:
		// The ChromeDriver and IEDriver executables needs to be in the PATH of the remote machine
		// To set the executable path manually, use:
		// java -Dwebdriver.chrome.driver=/path/to/driver -jar selenium-server-standalone.jar
		// java -Dwebdriver.ie.driver=/path/to/driver -jar selenium-server-standalone.jar
		
		properties = Settings.getInstance();
		Boolean proxyRequired =
				Boolean.parseBoolean(properties.getProperty("ProxyRequired"));
		
		DesiredCapabilities desiredCapabilities = null;
		if (proxyRequired) {
			desiredCapabilities = getProxyCapabilities();
		} else {
			desiredCapabilities = new DesiredCapabilities();
		}
		
		desiredCapabilities.setBrowserName(browser.getValue());
		
		if (browserVersion != null) {
			desiredCapabilities.setVersion(browserVersion);
		}
		if (platform != null) {
			desiredCapabilities.setPlatform(platform);
		}
		
		desiredCapabilities.setJavascriptEnabled(true);	// Pre-requisite for remote execution
		
		URL url;
		try {
			url = new URL(remoteUrl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new FrameworkException("The specified remote URL is malformed");
		}
		
		return new RemoteWebDriver(url, desiredCapabilities);
	}
	
	private static DesiredCapabilities getProxyCapabilities()
	{
		
        Proxy proxy = new Proxy();
		proxy.setProxyType(ProxyType.MANUAL);
		
		properties = Settings.getInstance();
		String proxyUrl = properties.getProperty("ProxyHost") + ":" +
									properties.getProperty("ProxyPort");
		
		proxy.setHttpProxy(proxyUrl);
		proxy.setFtpProxy(proxyUrl);
		proxy.setSslProxy(proxyUrl);
		//proxy.setHttpsProxy(proxyUrl);
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(CapabilityType.PROXY, proxy);
		
		return desiredCapabilities;
	}
}