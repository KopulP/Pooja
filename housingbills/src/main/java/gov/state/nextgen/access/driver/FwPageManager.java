package gov.state.nextgen.access.driver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gov.state.nextgen.access.exceptions.FwException;
import gov.state.nextgen.access.exceptions.FwExceptionManager;
import gov.state.nextgen.access.factories.FwServiceFactory;
import gov.state.nextgen.access.management.configuration.IConfiguration;
import gov.state.nextgen.access.management.constants.FwConstants;
import gov.state.nextgen.access.management.logging.ILog;
import gov.state.nextgen.access.management.references.IReferenceConstants;
import gov.state.nextgen.access.persistence.management.IData;

/**
 * Page Manager .
 *
 * @author Narasimham Konakanchi
 * Creation Date Apr 29, 2004 Modified By: Anand B (sql calls refactored to
 *           call SQLManager) Modified on: PCR#
 */

public class FwPageManager implements IPage {
	
	/** The Constant RSN_CD. */
	private static final String RSN_CD = "RSN_CD";
	
	/** The Constant CAT_CD. */
	private static final String CAT_CD = "CAT_CD";
	
	/** The Constant CATEGORY. */
	private static final String CATEGORY = "CATEGORY";
	
	/** The Constant SUB_RSN_CD. */
	private static final String SUB_RSN_CD = "SUB_RSN_CD";
	
	/** The Constant SUBST_RSN_CD. */
	private static final String SUBST_RSN_CD = "SUBST_RSN_CD";
	
	/** The Constant ACTN_IND. */
	private static final String ACTN_IND = "ACTN_IND";
	
	/** The Constant ACTION. */
	private static final String ACTION = "ACTION";
	
	/** The Constant FRAMEWORK_04. */
	private static final String FRAMEWORK_04 = "framework-04";
	
	/** The Constant FRAMEWORK_02. */
	private static final String FRAMEWORK_02 = "framework-02";
	
	/** The Constant HIST_FLG. */
	private static final String HIST_FLG = "HIST_FLG";
	
	/** The Constant MSG_TYP. */
	private static final String MSG_TYP = "MSG_TYP";
	
	/** The Constant HYPEN. */
	private static final String HYPEN = "_";
	
	/** The Constant VFCN_RSN_CD. */
	private static final String VFCN_RSN_CD = "VFCN_RSN_CD";
	
	/** The Constant FRAMEWORK_03. */
	private static final String FRAMEWORK_03 = "framework-03";
	
	/** The Constant PAGE_ID. */
	private static final String PAGE_ID = "PAGE_ID";
	
	/** The Constant PROG_PCT. */
	private static final String PROG_PCT = "PROG_PCT";
	
	/** The Constant HELP_PAGE_URL_ADR. */
	private static final String HELP_PAGE_URL_ADR = "HELP_PAGE_URL_ADR";
	
	/** The Constant PAGE_DSC. */
	private static final String PAGE_DSC = "PAGE_DSC";
	
	/** The Constant PAGE_URL_ADR. */
	private static final String PAGE_URL_ADR = "PAGE_URL_ADR";
	
	/** The Constant FRAMEWORK_01. */
	private static final String FRAMEWORK_01 = "framework-01";
	
	/** The Constant MSG_DSC. */
	private static final String MSG_DSC = "MSG_DSC";
	
	/** The Constant MSG_ID. */
	private static final String MSG_ID = "MSG_ID";
	
	/** The Constant SVR_CD. */
	private static final String SVR_CD = "SVR_CD";
	
	/** The Constant TXT_DSC. */
	private static final String TXT_DSC = "TXT_DSC";
	
	/** The Constant TXT_ID. */
	private static final String TXT_ID = "TXT_ID";
	
	/** The Constant LANG_CD. */
	private static final String LANG_CD = "LANG_CD";
	
	/** The Constant CMT_TXT. */
	private static final String CMT_TXT = "CMT_TXT";
	
	/** The Constant pageMgr. */
	private static final FwPageManager pageMgr = new FwPageManager();
	
	/** The page map. */
	private static Map pageMap;
	
	/** The configuration. */
	IConfiguration configuration = (IConfiguration) FwServiceFactory
			.getInstance().create(IConfiguration.class);
	
	/** The data manager. */
	private IData dataManager = null;
	
	private static final String FRAMEWORK_07 = "framework-07";
	
	/**
	 * Constructor for FwPageManager.
	 */
	private FwPageManager() {
		dataManager = (IData) FwServiceFactory.getInstance()
				.create(IData.class);
		pageMap = new HashMap();
	}

	/** The logger. */
	private ILog logger = null;

	/**
	 * Log.
	 *
	 * @param level the level
	 * @param message the message
	 */
	protected void log(final int level, final String message) {
		if (logger == null) {
			logger = (ILog) FwServiceFactory.getInstance().create(ILog.class);
		}
		logger.log(this.getClass(), level, message);
	}

	/**
	 * Singleton method create Instance for Page Manager class. Creation date:
	 * (04/29/2004 11:15:00 AM)
	 *
	 * @return the i page
	 */
	public static IPage createInstance() {

		// METHOD DOES NOT NEED TO BE SYNCHRONIZED AS INSTANCE IS OBTAINED
		// STATICALLY IN CLASS DECLARATION
		// DO NOT MODIFY CODE TO MAKE METHOD SYNCHRONIZED OR USE DOUBLE-LOCKING
		// AS DOUBLE-LOCKING IS NOT THREAD-SAFE CURRENTLY
		return pageMgr;
	}

	/**
	 * getData extracts data from t0656 and t0657 and loads all the data to the
	 * map . This method helps the preload servlet load all the data to the
	 * application cache to the static map of FwPageManager class Creation date:
	 * (04/29/2004 03:15:00 PM)
	 *
	 * @return the page details
	 */
	@Override
	public void getPageDetails() {

		try {
			final Map criteria = new HashMap();
			criteria.put(FwConstants.SQL_IND, FRAMEWORK_01);
			final List result = dataManager.execute(FwConstants.SQL, criteria);
			final Map mapDataMap = new HashMap();
			Map dataMap = null;
			Map row = null;
			for (int i = 0, size = result.size(); i < size; i++) {
				dataMap = new HashMap();
				row = (Map) result.get(i);
				dataMap.put(FwConstants.URL, row.get(PAGE_URL_ADR));
				dataMap.put(FwConstants.PAGE_DSC, row.get(PAGE_DSC));
				dataMap.put(FwConstants.HELP_PAGE, row.get(HELP_PAGE_URL_ADR));
				dataMap.put(FwConstants.PERCENTAGE, row.get(PROG_PCT));
				mapDataMap.put(row.get(PAGE_ID), dataMap);
			}
			pageMap.put(FwConstants.PAGE_DETAILS, mapDataMap);
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("getPageDetails");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	/**
	 * getDisplayTextMap creats an element map to be put in adatamap for
	 * specific pageID Creation date: (04/29/2004 03:15:00 PM).
	 *
	 * @return the display text map
	 */
	@Override
	public void getDisplayTextMap() {

		try {
			final Map criteria1 = new HashMap();
			criteria1.put(FwConstants.SQL_IND, FRAMEWORK_02);
			final List result1 = dataManager
					.execute(FwConstants.SQL, criteria1);
			final Map returnMap = new HashMap();
			Map dataMap = null;
			Map row = null;
			String langCD = null;
			for (int i = 0, size = result1.size(); i < size; i++) {
				dataMap = new HashMap();
				row = (Map) result1.get(i);
				dataMap.put(FwConstants.CMT_TXT, row.get(CMT_TXT));
				langCD = row.get(LANG_CD).toString().trim();
				dataMap.put(langCD, row.get(TXT_DSC));
				returnMap.put(
						row.get(TXT_ID).toString().trim()
						+ langCD.toUpperCase(), dataMap);
			}
			final Map criteria2 = new HashMap();
			criteria2.put(FwConstants.SQL_IND, FRAMEWORK_03);
			final List result2 = dataManager
					.execute(FwConstants.SQL, criteria2);
			final Map<String,String> messageMap = new HashMap<>();
			final StringBuilder sbf1 = new StringBuilder();
			final StringBuilder sbf2 = new StringBuilder();
			for (int j = 0, size = result2.size(); j < size; j++) {
				sbf1.delete(0, sbf1.length());
				sbf2.delete(0, sbf2.length());
				row = (Map) result2.get(j);
				sbf1.append(row.get(VFCN_RSN_CD)).append(HYPEN)
				.append(row.get(MSG_TYP));
				sbf2.append(row.get(TXT_ID)).append(HYPEN)
				.append(row.get(HIST_FLG));
				messageMap.put(sbf1.toString(), sbf2.toString());
			}
			pageMap.put(FwConstants.BNFT_MSG, messageMap);
			pageMap.put(FwConstants.DISPLAY_TEXT, returnMap);
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("getDisplayTextMap");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}

	}
	
	public boolean isDisplayTextLoaded() {
		if(pageMap == null) {
			return false;
		} else if(pageMap.containsKey(FwConstants.BNFT_MSG) && pageMap.containsKey(FwConstants.DISPLAY_TEXT)) {
				Map<String, String> messageMap =  (Map<String, String>) pageMap.get(FwConstants.BNFT_MSG);
				Map returnMap = (Map) pageMap.get(FwConstants.DISPLAY_TEXT);
				
				if(null  == messageMap || null  == returnMap) {
					return false;
				} else  if (messageMap.isEmpty() || returnMap.isEmpty()) {
					return false;
				} else {
					return true;
				}
		}
		return false;
	}

	/**
	 * getURL returns the String for the specific page ID Creation date:
	 * (05/04/2004 03:15:00 PM).
	 *
	 * @param page_id the page_id
	 * @return the url
	 */
	@Override
	public String getURL(final String page_id) {
		final Map details = (Map) pageMap.get(FwConstants.PAGE_DETAILS);
		final Map data = (Map) details.get(page_id);
		return (String) data.get(FwConstants.URL);
	}

	/**
	 * getProgress returns the String of Progress for the specific page ID
	 * Creation date: (07/02/2004 03:15:00 PM).
	 *
	 * @param page_id the page_id
	 * @return the progress
	 */
	@Override
	public String getProgress(final String page_id) {
		final Map details = (Map) pageMap.get(FwConstants.PAGE_DETAILS);
		final Map data = (Map) details.get(page_id);
		return (String) data.get(FwConstants.PERCENTAGE);
	}

	/**
	 * getDisplayText returns the String for the specific TXT_ID Creation date:
	 * (05/26/2004 04:22:00 PM).
	 *
	 * @param textID the text id
	 * @param language_indicator the language_indicator
	 * @return the display text
	 */
	@Override
	public String getDisplayText(final int textID,
			final String language_indicator) {

		String language = (null == language_indicator || "null".equalsIgnoreCase(language_indicator.trim()) || "".equals(language_indicator.trim())) ? FwConstants.ENGLISH : language_indicator;
		Map innerMap = null;
		final Map data = (Map) pageMap.get(FwConstants.DISPLAY_TEXT);

		final String chkValue = textID + language;
		if ((data != null) && data.containsKey(chkValue)) {
			innerMap = (Map) data.get(chkValue);
			return (String) innerMap.get(language.toUpperCase());
		} else {
			// added by sudharsan to remove the exception throw and hanle it
			// using a std message.
			return (" <B> <font color ='red'>Error:</font></b> The Data for the text ID  "
					+ textID + " " + "is not available");

		}

	}

	/**
	 * getMessageHistory returns the String for the specific message type
	 * Creation date: (07/05/2005 01:55:00 PM).
	 *
	 * @param vfcnRsnCd the vfcn rsn cd
	 * @param msgType the msg type
	 * @return the message history
	 */
	@Override
	public String getMessageHistory(final String vfcnRsnCd, final String msgType) {
		final Map data = (Map) pageMap.get(FwConstants.BNFT_MSG);
		final String chkValue = vfcnRsnCd + HYPEN + msgType.trim();
		if (data.containsKey(chkValue)) {
			final String messageCode = (String) data.get(chkValue);
			return messageCode.substring(messageCode.indexOf(HYPEN) + 1);
		} else {
			log(ILog.INFO,
					"FwPageManager.getMessageHistory() - Raising FwException manually on a condition");
			final FwException fe = new FwException(
					"The Data for the message type requested is not available");
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("getMessageHistory");
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			fe.setExceptionText("The Data for the message type requested is not available");
			throw fe;
		}

	}

	/**
	 * getMessageText returns the String for the specific message type Creation
	 * date: (07/05/2005 01:55:00 PM).
	 *
	 * @param vfcnRsnCd the vfcn rsn cd
	 * @param msgType the msg type
	 * @return the message code
	 */
	@Override
	public String getMessageCode(final String vfcnRsnCd, final String msgType) {
		final Map data = (Map) pageMap.get(FwConstants.BNFT_MSG);
		final String chkValue = vfcnRsnCd + HYPEN + msgType.trim();
		if (data.containsKey(chkValue)) {
			final String messageCode = (String) data.get(chkValue);
			return messageCode.substring(0, messageCode.indexOf(HYPEN));
		} else {
			log(ILog.INFO,
					"FwPageManager.getMessageCode() - Raising FwException manually on a condition");
			final FwException fe = new FwException(
					"The Data for the message type requested is not available");
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("getMessageCode");
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			fe.setExceptionText("The Data for the message type requested is not available");
			throw fe;
		}
	}

	/**
	 * getAllData returns the map of all data Creation date: (04/29/2004
	 * 03:15:00 PM).
	 *
	 * @return the all data
	 */
	@Override
	public Map getAllData() {
		return pageMap;

	}

	/**
	 * loadMessageTable loads the data from the table MSG_DTL to the Application
	 * Cache Reads values from a config file and returns a column name for
	 * description Create date : (05/28/2004 10:00:12 AM).
	 */
	@Override
	public void loadMessageTable() {

		try {
			final Map criteria = new HashMap();
			criteria.put(FwConstants.SQL_IND, FRAMEWORK_04);
			final List result = dataManager.execute(FwConstants.SQL, criteria);
			final Map mapMsgTable = new HashMap();
			Map dataMap = null;
			Map row = null;
			for (int i = 0, size = result.size(); i < size; i++) {
				dataMap = new HashMap();
				row = (Map) result.get(i);
				dataMap.put(IReferenceConstants.SVR_ID, row.get(SVR_CD));
				dataMap.put(IReferenceConstants.MSG_DSC, row.get(MSG_DSC));
				mapMsgTable.put(
						row.get(MSG_ID).toString().trim()
						+ row.get(LANG_CD).toString().trim()
						.toUpperCase(), dataMap);
			}
			pageMap.put(FwConstants.MESSAGES, mapMsgTable);
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("loadMessageTable");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	/**
	 * Gets all the messages for the Application Map includes the column name as
	 * the key and the filter for the column as the value Creation Date :
	 * (05/28/2004 10:00:12 AM).
	 *
	 * @return the messages
	 */
	@Override
	public Map getMessages() {

		return (HashMap) pageMap.get(FwConstants.MESSAGES);

	}

	/* (non-Javadoc)
	 * @see gov.state.nextgen.framework.driver.IPage#getMessageByCode(java.lang.String, java.lang.String)
	 */
	@Override
	public String[] getMessageByCode(final String code, final String language) {

		final Map allMsg = getMessages();
		final String[] retStr = new String[2];
		final Map specificMsg = (Map) allMsg.get(code.trim() + language.trim());
		if (specificMsg != null) {
			retStr[0] = specificMsg.get(IReferenceConstants.SVR_ID).toString();
			retStr[1] = specificMsg.get(IReferenceConstants.MSG_DSC).toString();
		}
		return retStr;
	}

	/**
	 * getSuppressReasonCodesMap populates reason codes from table
	 * 'DUP_RSN_SPRS' into pageMap Creation date: (12/10/2007 03:15:00 PM).
	 *
	 * @return the suppress reason codes map
	 */
	@Override
	public void getSuppressReasonCodesMap() {

		try {
			final Map criteria = new HashMap();
			criteria.put(FwConstants.SQL_IND, "framework-05");
			final List result = dataManager.execute(FwConstants.SQL, criteria);
			final Map returnMap = new HashMap();
			Map dataMap = null;
			Map row = null;
			for (int i = 0,size=result.size(); i < size; i++) {
				dataMap = new HashMap();
				row = (Map) result.get(i);
				dataMap.put(ACTION, row.get(ACTN_IND));
				dataMap.put(SUBST_RSN_CD, row.get(SUB_RSN_CD));
				dataMap.put(CATEGORY, row.get(CAT_CD));
				returnMap.put(row.get(RSN_CD), dataMap);
			}
			pageMap.put(FwConstants.SUPPRESS_REASON_CODES, returnMap);

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("getDisplayTextMap");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}

	}
	
	@Override
	public boolean isSuppressReasonCodesMap() {
		if(pageMap == null) {
			return false;
		} else if(pageMap.containsKey(FwConstants.SUPPRESS_REASON_CODES)) {
				Map<String, String> returnMap =  (Map<String, String>) pageMap.get(FwConstants.SUPPRESS_REASON_CODES);
				
				if(null  == returnMap) {
					return false;
				} else  if (returnMap.isEmpty()) {
					return false;
				} else {
					return true;
				}
		}
		return false;
	}


	public String getAnnouncements(String language) {
		String announcementMsg = null;
		final Map criteria = new HashMap();
		criteria.put(FwConstants.SQL_IND, FRAMEWORK_07);
		final List result = dataManager.execute(FwConstants.SQL, criteria);
		Map dataMap = null;
		Map row = null;
		for (int i = 0, size = result.size(); i < size;) {
			dataMap = new HashMap();
			row = (Map) result.get(i);
			if ("EN".equals(language)) {
				announcementMsg = (String) row.get("MESSAGE_EN");
			} else if ("ES".equals(language)) {
				announcementMsg = (String) row.get("MESSAGE_ES");
			}
			break;
		}
		return (announcementMsg == null) ? FwConstants.EMPTY_STRING
				: announcementMsg;
	}
}
