/*
 * Class StringUtils validates the string for null and empty values
 * @author - Cognizant Automation Team
 * Sep 2012
 *  
 */
package webdriverhelper;

/**
 * StringUtils : validates the string for null and empty values.
 */
public class StringUtils {
	
	/** The Constant TRUE. */
	public final static String URL_STATUS_TRUE = "true";
	
	/**
	 * Method : isNull validates for null.
	 *
	 * @param str the str
	 * @return : boolean flag
	 */
	public static boolean isNull(String str){
		boolean flag = false;
		if(str==null){
			return true;
		}
		return flag;
	}
	
	/**
	 * Method : isEmpty validates for empty value.
	 *
	 * @param str : str carries the string data type
	 * @return : boolean flag
	 */
	public static boolean isEmpty(String str){
		boolean flag = false;		
		if(str != null && str.isEmpty()){
	         return true;
		}
		 return flag;
	}	

}
