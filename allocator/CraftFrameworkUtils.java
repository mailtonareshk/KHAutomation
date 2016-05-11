/*
 * Class helps setting configuration parameters to parse through config.xml file
 * @author - Cognizant Automation Team
 * Sep 2012
 *  
 */
package allocator;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class CraftFrameworkUtils {

	/** Entire configuration information about the project will be available in this map */
	private static Map<String,String> allConfig=null;
	
	/** The logger. */
	//private static Logger logger = Logger.getLogger(CraftFrameworkUtils.class);
	
	/**
	 * Instantiates a new SarfFrameworkUtils.
	 *
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public CraftFrameworkUtils() throws ParserConfigurationException, SAXException, IOException {
		
		allConfig=CraftFrameworkUtils.getConfig();
	}	
	
	/**
	 * Gets the configuration parameters from config XML.
	 *
	 * @return the configuration
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static Map<String,String> getConfig() throws ParserConfigurationException, SAXException, IOException {

		//logger.debug("In getConfig method");
		String value="";
		String kee="";
		Map<String,String> map=new LinkedHashMap<String,String>();
		
			String dir=System.getProperty("user.dir");
			dir=dir+File.separatorChar+"config"+File.separatorChar+"config.xml";
			File file = new File(dir);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			NodeList nodeList = doc.getElementsByTagName("CraftConfig");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					NodeList nodeLst = element.getElementsByTagName("*");
					for(int j=0;j < nodeLst.getLength(); j++) {
						kee=nodeLst.item(j).getNodeName().trim();
						try {
								if(nodeLst.item(j).getChildNodes().getLength()>0){
									value=nodeLst.item(j).getChildNodes().item(0).getNodeValue().trim();
								}else{
									value="";
								}								
						} catch(DOMException e) {
							//logger.error(" Error getting configuration parameters: \n", e);
							value="";
						}
						map.put(kee,value);
						//logger.debug("Key - "+kee+"; "+"Value - "+value);
					}				
				}
			}
		return map;
	}
	
	/**
	 * Gets the configuration Map containing all configuration parameters in key/value pairs.
	 *
	 * @return the configuration map with all configuration parameters in key/value pairs.
	 */
	public static Map<String,String> getConfigMap() {
		return allConfig;		
	}

}

