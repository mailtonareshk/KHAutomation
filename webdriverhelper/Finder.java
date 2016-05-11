/*
 * Class to find the locators by XPATH/CSS/Class/Name/ID from the UI mapping XML file as of now only XPATH is used in this application
 * @author - Cognizant Automation Team
 * Sep 2012
 */
package webdriverhelper;


import org.openqa.selenium.By;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import allocator.CraftFrameworkUtils;

import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;



/**
 * Class to find the locators by XPATH/CSS/Class/Name/ID from the UI mapping XML file as of now only XPATH is used in this application.
 */
public class Finder{

	/** The logger. */
	//private Logger logger = Logger.getLogger(LocatorFinder.class);

	/** The result file. */
	private String resFile=null;

	/** The input xml file name. */
	private File fXmlFile = null;

	/** The DocumentBuilderFactory variable for parsing. */
	private DocumentBuilderFactory dbFactory= null;

	/** The DocumentBuilder variable. */
	private DocumentBuilder dBuilder=null;

	/** The Document variable. */
	private Document doc=null;

	/** The Node variable. */
	private Node rootNode=null;

	/** The NodeList variable. */
	private NodeList listOfElements1=null;

	/**
	 * Instantiates a new LocatorFinder.
	 *
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	
		public  Finder() throws ParserConfigurationException, SAXException, IOException{
		
		CraftFrameworkUtils utils = new CraftFrameworkUtils();
		resFile= System.getProperty("user.dir")+File.separatorChar+utils.getConfigMap().get("UIMapFileDir")+File.separatorChar+utils.getConfigMap().get("UIMapFile");
		
		fXmlFile = new File(resFile);
		dbFactory = DocumentBuilderFactory.newInstance();
		dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(fXmlFile);
		rootNode = doc.getDocumentElement();
		listOfElements1 = rootNode.getChildNodes();		
	}

	/**
	 * Get locator from UI mappings XML file.
	 *
	 * @param sValue - the locator name. Eg. login_username where login is the node and username is child.
	 * @return The locator from UI mappings XML file.
	 */
	public final String getLocatorFromXml(String sValue) {
		//logger.info("Started getLocatorFromXml");
		String componentName = null;
		String objectName = null;
		String findValue = null;
		String locator = null;
		//String findBy ="";
		Element nodes;
		Node maintNode,subChildNode,childCurrentNode; 
		StringTokenizer st =  new StringTokenizer(sValue,"_");

		while(st.hasMoreElements()){
			componentName = (String) st.nextElement();
			//logger.debug("Component Name: "+componentName);
			objectName = (String) st.nextElement();
			//logger.debug("Object Name: "+objectName);
		}		
		for (int i=0; i<listOfElements1.getLength();i++) {			
			maintNode = listOfElements1.item(i);
			if(maintNode.getNodeName().equalsIgnoreCase(componentName)) {
				subChildNode = maintNode;
				NodeList listOfElements2 =  subChildNode.getChildNodes();
				for(int k=0;k<listOfElements2.getLength();k++) {
					childCurrentNode = listOfElements2.item(k);
					if(childCurrentNode.getNodeName().equalsIgnoreCase(objectName)) {
						nodes = (Element) childCurrentNode;
						/*if(!nodes.getAttribute("findby").isEmpty()) { 
								findBy = nodes.getAttribute("findby");
							}*/
						findValue= nodes.getAttribute("findby");
						switch(findValue) {

						case "tag": locator = nodes.getAttribute("tag"); break;

						case "text": locator = nodes.getAttribute("text");  break;

						case "Class": locator = nodes.getAttribute("Class"); break;

						case "Id": locator = nodes.getAttribute("Id"); 	break;

						case "name": locator = nodes.getAttribute("name"); break;

						case "iexpath": locator = nodes.getAttribute("iexpath"); break;  

						case "css": locator = nodes.getAttribute("css"); break;

						case "Xpath": locator = nodes.getAttribute("Xpath"); break; 
						}
					}
				}
			}
		}
		if (locator==""){
			//logger.error("Locator - "+sValue+" not found in UI mappings file!!!");			
		}
		//logger.info("Ended getLocatorFromXml");
		return locator;	
	}

	/**
	 * Get the locator type(XPATH/CSS/Class/Name/ID/TagName) from UI mapping XML file.
	 *
	 * @param sValue - the locator name. Eg. login_username where login is the node and username is child.
	 * @return the locator type from UI mappings XML file.
	 */
	public final String getLocatorTypeFromXml(String sValue) {
		//logger.info("Started getLocatorTypeFromXml");
		String locatorType = null;
		String componentName = null;
		String objectName = null;
		StringTokenizer st =  new StringTokenizer(sValue,"_");
		Node maintNode,subChildNode,childcurrentNode;
		Element nodes;
		NodeList listOfElements;

		while(st.hasMoreElements()) {
			componentName = (String) st.nextElement();
			objectName = (String) st.nextElement();
		}
		for (int i=0; i<listOfElements1.getLength();i++){			
			maintNode = listOfElements1.item(i);
			if(maintNode.getNodeName().equalsIgnoreCase(componentName)) {
				subChildNode = maintNode;
				listOfElements =  subChildNode.getChildNodes();
				for(int k=0;k<listOfElements.getLength();k++) {
					childcurrentNode = listOfElements.item(k);
					if(childcurrentNode.getNodeName().equalsIgnoreCase(objectName)) {
						//logger.debug("NodeName:: "+childcurrentNode.getNodeName());
						nodes = (Element) childcurrentNode;
						if(!nodes.getAttribute("findby").isEmpty()) { 
							locatorType= nodes.getAttribute("findby");
						}
					}
				}
			}
		}
		//logger.info("Ended getLocatorTypeFromXml");
		return locatorType;
	}

	/**
	 * Finds locator and locator type from UI mapping XML file. 
	 *
	 * @param locatorname - the locator name. Eg. login_username where login is the node and username is child.
	 * @return the By
	 */
	public final By findBy(String locatorName) {
		//logger.info("Started findBy");
		By by=null;
		String locator=getLocatorFromXml(locatorName);
		String locaorType=getLocatorTypeFromXml(locatorName).trim().toLowerCase();

		switch (locaorType) {

		case "xpath": 
			by= By.xpath(locator);
			break;

		case "css": 
			by= By.cssSelector(locator);
			break;

		case "id": 
			by= By.id(locator);
			break;

		case "name": 
			by= By.name(locator);
			break;

		case "class": 
			by= By.className(locator);
			break;
		}
		//logger.info("Ended findBy");
		return by;
	}

	/**
	 * Finds locator and locator type from UI mapping XML file for Dynamic Xpath with one value. 
	 *
	 * @param locatorname - the locator name. Eg. login_username where login is the node and username is child.
	 * @return the By
	 */
	public By findByDynXpath(String locatorName, String object) {
		//logger.info("Started findByDynXpath with locatorName and Object");
		By by=null;
		String locator=getLocatorFromXml(locatorName).replaceAll("@1@", object);
		by= By.xpath(locator);
		//logger.info("Ended findByDynXpath  with locatorName and Object");
		return by;
	}

	/**
	 * Finds locator and locator type from UI mapping XML file for Dynamic Xpath with one an array of values. 
	 *
	 * @param locatorname - the locator name. Eg. login_username where login is the node and username is child.
	 * @return the By
	 */
	public By findByDynXpath(String locatorName, String[] object) {
		//logger.info("Started findByDynXpath with locatorName and Object array");
		By by=null;
		String locator=getLocatorFromXml(locatorName);
		int i=1;
		for(String value : object)
		{
			locator = locator.replaceAll("@"+i+"@", value);
			i++ ;
		}

		by= By.xpath(locator);
		//logger.info("Ended findByDynXpath with locatorName and Object array");
		return by;
	}
/**
 * get the locator based on locatorName and Object array
 * @param locatorName
 * @param object
 * @return string containing the locator
 */
	public String getLocator(String locatorName, String[] object) {
		//logger.info("Started getLocator with locatorName and Object array");
		//By by=null;
		String locator=getLocatorFromXml(locatorName);
		int i=1;
		for(String value : object)
		{
			locator = locator.replaceAll("@"+i+"@", value);
			i++ ;
		}
		//logger.info("Ended getLocator with locatorName and Object array");
		//by= By.xpath(locator);
		return locator;
	}
	/**
	 * get the locator based on locatorName and Object
	 * @param locatorName
	 * @param object
	 * @return string containing the locator
	 */
	public String getLocator(String locatorName, String object) {
		//logger.info("Started getLocator with locatorName and Object");
		//By by=null;
		String locator=getLocatorFromXml(locatorName);
		locator = locator.replaceAll("@1@", object);
		//logger.info("Ended getLocator with locatorName and Object");
		return locator;
	}

}
