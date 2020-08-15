/*
 * 
 */
package gov.state.nextgen.access.driver;

import java.util.Map;

/**
 * Page Manager Interface.
 *
 * @author Narasimham Konakanchi
 * Creation Date Apr 29, 2004 Modified By: Modified on: PCR#
 */
public interface IPage {

	/**
	 * Gets the data from the databae T0656 and T0657 tables and loads the data
	 * to the Map Creation date: (04/29/2004 11:00:00 AM)
	 */
	public void getPageDetails();

	/**
	 * getURL returns the String for the specific page ID Creation date:
	 * (05/04/2004 03:15:00 PM)
	 */
	public String getURL(String page_id);

	/**
	 * getProgress returns the String for the specific page ID Creation date:
	 * (07/02/2004 03:15:00 PM)
	 */
	public String getProgress(String page_id);

	/**
	 * getDisplayText returns the String for the specific TXT_ID Creation date:
	 * (05/26/2004 04:22:00 PM)
	 */
	public String getDisplayText(int textID, String language_indicator);

	/**
	 * getURL returns the String for the specific page ID Creation date:
	 * (05/04/2004 03:15:00 PM)
	 */
	public void getDisplayTextMap();

	/**
	 * loadMessageTable loads all the messages to the Application cache Creation
	 * date: (05/04/2004 03:15:00 PM)
	 */
	public void loadMessageTable();

	/**
	 * Gets all the messages for the Application Map includes the column name as
	 * the key and the filter for the column as the value Creation Date :
	 * (05/28/2004 10:00:12 AM)
	 */
	public Map getMessages();

	/**
	 * getDataForPageid returns the whole page map Creation date: (04/29/2004
	 * 03:15:00 PM)
	 */
	public Map getAllData();

	/**
	 * getDataForPageid returns the whole page map Creation date: (06/21/2004
	 * 03:15:00 PM)
	 */
	public String[] getMessageByCode(String code, String language);

	/**
	 * getMessageHistory returns the String for the specific message type
	 * Creation date: (07/05/2005 05:15:00 PM)
	 */
	public String getMessageHistory(String vfcnRsnCd, String msgType);

	/**
	 * getMessageText returns the String for the specific message type Creation
	 * date: (07/05/2005 05:15:00 PM)
	 */
	public String getMessageCode(String vfcnRsnCd, String msgType);

	/**
	 * Caches reason codes from 'DUP_RSN_SPRS' table Creation date: (12/17/2004
	 * 03:15:00 PM)
	 */
	public void getSuppressReasonCodesMap();
	
	public String getAnnouncements(String language);

	public boolean isDisplayTextLoaded();

	public boolean isSuppressReasonCodesMap();

}
