/*
 * 
 */
package gov.state.nextgen.access.driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import gov.state.nextgen.access.driver.business.entities.AFB_DRVR_Cargo;
import gov.state.nextgen.access.driver.business.entities.AFB_DRVR_Collection;
import gov.state.nextgen.access.driver.business.entities.PE_CHLD_DRVR_Cargo;
import gov.state.nextgen.access.driver.business.entities.PE_CHLD_DRVR_Collection;
import gov.state.nextgen.access.driver.business.entities.PE_PREG_WMN_DRVR_Cargo;
import gov.state.nextgen.access.driver.business.entities.PE_PREG_WMN_DRVR_Collection;
import gov.state.nextgen.access.driver.business.entities.RMC_DRVR_Cargo;
import gov.state.nextgen.access.driver.business.entities.RMC_DRVR_Collection;
import gov.state.nextgen.access.exceptions.FwException;
import gov.state.nextgen.access.exceptions.FwExceptionManager;
import gov.state.nextgen.access.factories.FwServiceFactory;
import gov.state.nextgen.access.management.configuration.IConfiguration;
import gov.state.nextgen.access.management.constants.FwConstants;
import gov.state.nextgen.access.management.logging.ILog;
import gov.state.nextgen.access.management.util.FwDataCriteria;
import gov.state.nextgen.access.persistence.database.connection.FwConnectionManager;
import gov.state.nextgen.access.persistence.database.connection.IConnection;
import gov.state.nextgen.access.persistence.management.IData;

/**
 * Driver Manager Class (Singleton class) has methods to access the data from
 * the page table and has methods to determine the response page in the
 * application based on business rules. This class is called by the session
 * controller to determine the next page.
 *
 * @author Deloitte Consulting.
 */
public class DriverManager implements IDriver, IFwDriver {

	// singleton instance
	private static final DriverManager singleton = new DriverManager();
	private static Map masterDriverMap = null;
	private static Map defaultDriverMap = null;
	private static Map arrayIndexPageIdMap = null;
	private static Map pageIdArrayIndexMap = null;
	private static Map pageIdPageActionMap = null;
	private static Map pageActionPageIdMap = null;
	private static Map businessDriverMap = null;
	private static Map businessDriverPageIdStatusMap = null;
	private IData data;
	private String afbDriverSQL = null;
	private String rmcDriverSQL = null;
	private String rmbDriverSQL = null;
	private String apwDriverSQL = null;
	private String apcDriverSQL = null;
	private String ahnDriverSQL = null;
	private AFB_DRVR_Cargo afbDriverCargo = null;
	private RMC_DRVR_Cargo rmcDriverCargo = null;
	private PE_PREG_WMN_DRVR_Cargo apwDriverCargo = null;
	private PE_CHLD_DRVR_Cargo apcDriverCargo = null;
	private ILog logger = null;

	protected void log(final int level, final String message) {
		if (logger == null) {
			logger = (ILog) FwServiceFactory.getInstance().create(ILog.class);
		}
		logger.log(this.getClass(), level, message);
	}

	/**
	 * Constructor for DriverManager.
	 */
	private DriverManager() {

	}

	/**
	 * Singleton method create Instance for Driver Manager class.
	 */
	public static IDriver getInstance() {
		// METHOD DOES NOT NEED TO BE SYNCHRONIZED AS INSTANCE IS OBTAINED
		// STATICALLY
		// IN CLASS DECLARATION
		// DO NOT MODIFY CODE TO MAKE METHOD SYNCHRONIZED OR USE DOUBLE-LOCKING
		// AS DOUBLE-LOCKING IS NOT THREAD-SAFE CURRENTLY
		return singleton;
	}

	/**
	 * Called By the Preload Servlet.
	 */
	@Override
	public void initializeDriverMaps() {
		try {
			defaultDriverMap = new HashMap();
			arrayIndexPageIdMap = new HashMap();
			pageIdArrayIndexMap = new HashMap();
			pageIdPageActionMap = new HashMap();
			pageActionPageIdMap = new HashMap();
			businessDriverMap = new HashMap();
			businessDriverPageIdStatusMap = new HashMap();

			final IConfiguration configuration = (IConfiguration) FwServiceFactory.getInstance().create(IConfiguration.class);
			masterDriverMap = configuration.getDriverConfiguration();
			// Initialize the Rest of the Maps required by the Driver Manager to
			// process request from the JSP pages.
			final Set keyset = masterDriverMap.keySet();
			final Iterator keysetIter = keyset.iterator();
			while (keysetIter.hasNext()) {
				// Get the Business Driver Key.
				final String driver_key = (String) keysetIter.next();
				// Get hold of the DriverMap.
				final Map temp_driver_map = (HashMap) masterDriverMap.get(driver_key);
				// Call a method to process.
				processMapping(driver_key, temp_driver_map);
			}

			data = (IData) FwServiceFactory.getInstance().create(IData.class);
			final String schema = configuration.getEnvironmentProperty(IConnection.DB_SCHEMA);

			afbDriverSQL = "SELECT * FROM " + schema + ".CP_AFB_DRVR WHERE APP_NUM = ?";
			rmcDriverSQL = "SELECT * FROM " + schema + ".CP_RMC_DRVR WHERE APP_NUM = ?";
			rmbDriverSQL = "SELECT * FROM " + schema + ".CP_RMC_DRVR WHERE APP_NUM = ?";
			apwDriverSQL = "SELECT * FROM " + schema + ".PE_PREG_WMN_DRVR WHERE APP_NUM = ?";
			apcDriverSQL = "SELECT * FROM " + schema + ".PE_CHLD_DRVR WHERE APP_NUM = ?";
			ahnDriverSQL = "SELECT * FROM " + schema + ".NEHNA_APP_DRVR WHERE APP_NUM = ?";
			initializeAFBDriverCargo();
			initializeRMCDriverCargo();
			initializeRMBDriverCargo();
			initializeAPWDriverCargo();
			initializeAPCDriverCargo();
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("initializeDriverMaps");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	/**
	 * Private Method to Only Iterate through an Array List.
	 *
	 * @param driverId
	 * @param temp_driver_map
	 */
	private void processMapping(final String driverId, final Map temp_driver_map) {
		try {
			// Get the Business Driver
			final String businessDriverValue = (String) temp_driver_map.get(FwConstants.BUSINESSDRIVER);
			// Note : If the BusinessDriver is N map the Values to the
			// Stored Maps in Memory.
			if (businessDriverValue.equals("N")) {
				final ArrayList pageActionPageIdArrayList = new ArrayList();
				// Get the Array List
				final ArrayList dataList_array = (ArrayList) temp_driver_map.get(FwConstants.DATALIST);
				// Array List Consists of Maps in the Order of Entry.
				// Iterate through the List to Create new Maps of Array List for
				// Processing.
				final int size = dataList_array.size();
				final int[] driver_map_array_list = new int[size];
				final Map arrayIndexPageIdInnerMap = new HashMap();
				final Map pageIdArrayIndexInnerMap = new HashMap();
				final Map pageIdPageActionInnerMap = new HashMap();
				for (int i = 0; i < size; i++) {
					final Map pageMap = (Map) dataList_array.get(i);
					// Processed Sequentially.
					driver_map_array_list[i] = getConvertedInt((String) pageMap.get(FwConstants.INIT_STATUS));

					arrayIndexPageIdInnerMap.put(String.valueOf(i), pageMap.get(FwConstants.id));

					pageIdArrayIndexInnerMap.put(pageMap.get(FwConstants.id), new FwDriverMapIndex(i));

					pageIdPageActionInnerMap.put(pageMap.get(FwConstants.id), pageMap.get(FwConstants.PAGEACTION));

					// Since the PageAction might be repeated.
					// Create a ArrayList and put in the Map with key
					// As the Counter in iteration.
					final Map _tempPageActionPageIdMap = new HashMap();
					_tempPageActionPageIdMap.put(pageMap.get(FwConstants.PAGEACTION), pageMap.get(FwConstants.id));
					pageActionPageIdArrayList.add(_tempPageActionPageIdMap);
				}
				defaultDriverMap.put(driverId, driver_map_array_list);
				arrayIndexPageIdMap.put(driverId, arrayIndexPageIdInnerMap);
				pageIdArrayIndexMap.put(driverId, pageIdArrayIndexInnerMap);
				pageIdPageActionMap.put(driverId, pageIdPageActionInnerMap);
				pageActionPageIdMap.put(driverId, pageActionPageIdArrayList);
			} else if (businessDriverValue.equals("Y")) {
				// Load the Business Drivers into Map.
				final ArrayList pageIdArrayList = new ArrayList();
				final Map pageIdStatusInnerMap = new HashMap();
				// Get the Array List
				final ArrayList dataList_array = (ArrayList) temp_driver_map.get(FwConstants.DATALIST);
				// Array List Consists of Maps in the Order of Entry.
				// Iterate through the List to create Business Driver.
				final int size = dataList_array.size();
				for (int i = 0; i < size; i++) {
					final Map pageMap = (Map) dataList_array.get(i);
					// Processed Sequentially.
					pageIdArrayList.add(pageMap.get(FwConstants.id));
					pageIdStatusInnerMap.put(pageMap.get(FwConstants.id), pageMap.get(FwConstants.INIT_STATUS));
				}
				businessDriverMap.put(driverId, pageIdArrayList);
				businessDriverPageIdStatusMap.put(driverId, pageIdStatusInnerMap);
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("processMapping");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}

	}

	/**
	 * Driver Status
	 *
	 * @param temp_val
	 * @return int
	 */
	private int getConvertedInt(final String temp_val) {
		int val = IDriver.DRIVER_INDEX_NOT_REQUIRED;
		if (temp_val.equals(IDriver.DRIVER_STATUS_NOT_REQUIRED)) {
			val = IDriver.DRIVER_INDEX_NOT_REQUIRED;
		} else if (temp_val.equals(IDriver.DRIVER_STATUS_REQUIRED)) {
			val = IDriver.DRIVER_INDEX_REQUIRED;
		} else if (temp_val.equals(IDriver.DRIVER_STATUS_VISIT_AGAIN)) {
			val = IDriver.DRIVER_INDEX_VISIT_AGAIN;
		} else if (temp_val.equals(IDriver.DRIVER_STATUS_PENDING)) {
			val = IDriver.DRIVER_INDEX_PENDING;
		} else if (temp_val.equals(IDriver.DRIVER_STATUS_COMPLETE)) {
			val = IDriver.DRIVER_INDEX_COMPLETE;
		} else if (temp_val.equals(IDriver.DRIVER_STATUS_ADD_NEW)) {
			val = IDriver.DRIVER_INDEX_ADD_NEW;
		}
		return val;
	}

	/**
	 * Driver Status
	 *
	 * @param temp_val
	 * @return String
	 */
	private String getConvertedStatus(final int temp_val) {
		String status = "";
		if (temp_val == IDriver.DRIVER_INDEX_NOT_REQUIRED) {
			status = IDriver.DRIVER_STATUS_NOT_REQUIRED;
		} else if (temp_val == IDriver.DRIVER_INDEX_REQUIRED) {
			status = IDriver.DRIVER_STATUS_REQUIRED;
		} else if (temp_val == IDriver.DRIVER_INDEX_VISIT_AGAIN) {
			status = IDriver.DRIVER_STATUS_VISIT_AGAIN;
		} else if (temp_val == IDriver.DRIVER_INDEX_PENDING) {
			status = IDriver.DRIVER_STATUS_PENDING;
		} else if (temp_val == IDriver.DRIVER_INDEX_COMPLETE) {
			status = IDriver.DRIVER_STATUS_COMPLETE;
		} else if (temp_val == IDriver.DRIVER_INDEX_ADD_NEW) {
			status = IDriver.DRIVER_STATUS_ADD_NEW;
		}
		return status;
	}

	/**
	 * Loads default driver
	 *
	 * @param driverId
	 * @return int[]
	 */
	@Override
	public int[] loadDefaultDriver(final String driverId) {
		try {
			final int[] driverArrayCache = (int[]) defaultDriverMap.get(driverId);
			final int[] driverArray = new int[driverArrayCache.length];
			for (int i = 0; i < driverArray.length; i++) {
				driverArray[i] = driverArrayCache[i];
			}
			return driverArray;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("loadDefaultDriver");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	/**
	 * Load driver from AFB_DRIVER and RMC_DRVR table
	 *
	 * @param driverId
	 * @param aAppNum
	 * @return int[]
	 */
	@Override
	public int[] loadDriver(final String driverId, final String aAppNum) {

		int[] intReturnAry = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;

		try {
			final IConnection con = FwConnectionManager.getInstance();
			conn = con.getConnection();
			if (driverId.equals(FwConstants.AFB_DRIVER)) {
				pstmt = conn.prepareStatement(afbDriverSQL);
			} else if (driverId.equals(FwConstants.RMC_DRIVER)) {
				pstmt = conn.prepareStatement(rmcDriverSQL);
			} else if (driverId.equals(FwConstants.APW_DRIVER)) {
				pstmt = conn.prepareStatement(apwDriverSQL);
			} else if (driverId.equals(FwConstants.APC_DRIVER)) {
				pstmt = conn.prepareStatement(apcDriverSQL);
			} else if (driverId.equals(FwConstants.AHN_DRIVER)) {
				pstmt = conn.prepareStatement(ahnDriverSQL);
			} else if (driverId.equals(FwConstants.RMB_DRIVER)) {
				pstmt = conn.prepareStatement(rmbDriverSQL);
			}

			pstmt.setLong(1, Long.parseLong(aAppNum));
			if(null!=pstmt)
			{
				rs = pstmt.executeQuery();
			}
			String colName = null;
			if (rs == null) {
				intReturnAry = loadDefaultDriver(driverId);
			} else if (rs.next()) {
				final ResultSetMetaData rsm = rs.getMetaData();
				final int columnCount = rsm.getColumnCount();
				log(ILog.INFO, "columnCount: " + columnCount);
				intReturnAry = new int[columnCount - 1];
				// Get page id index map for driver
				final Map driverPageIdIndexArray = getDriverPageIdArray(driverId);
				log(ILog.INFO, "driverPageIdIndexArray" + driverPageIdIndexArray.size());
				for (int i = 1; i < columnCount; i++) {
					colName = rsm.getColumnName(i + 1).substring(0, 5);
					log(ILog.INFO, "colName: " + colName);
					intReturnAry[getIndexForPageId(driverPageIdIndexArray, colName)] = rs.getInt(i + 1);
					log(ILog.INFO, "colNameSame: " + colName);
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("loadDriver");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (final java.sql.SQLException sqle) {
				final FwException fe = new FwException(sqle);
				fe.setClassID(this.getClass().getName());
				fe.setMethodID("loadDriver");
				fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(sqle));
				fe.setExceptionText(String.valueOf(sqle));
				fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
				throw fe;
			}
		}
		return intReturnAry;
	}

	/**
	 * Get Driver Page Id array
	 *
	 * @param driverId
	 * @return Map
	 */
	private Map getDriverPageIdArray(final String driverId) {
		return (Map) pageIdArrayIndexMap.get(driverId);
	}

	/**
	 * Get index for Page Id
	 *
	 * @param driverPageIdArrayIndexMap
	 * @param pageId
	 * @return int
	 */
	private int getIndexForPageId(final Map driverPageIdArrayIndexMap, final String pageId) {
		try {
			final FwDriverMapIndex index = (FwDriverMapIndex) driverPageIdArrayIndexMap.get(pageId);
			if (index != null) {
				return index.getIndex();
			} else {
				return -1;
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("getIndexForPageId");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	/**
	 * Make Required
	 *
	 * @see IDriver#makeRequired(String, String, int[])
	 * @param driverId
	 * @param pageId
	 * @param driver
	 */
	@Override
	public void makeRequired(final String driverId, final String pageId, final int[] driver) {
		makeRequired(driverId, pageId, driver, null); // for screener app. pass
		// the null as app_num
	}

	/**
	 * Make Required
	 *
	 * @see IDriver#makeRequired(String, String, int[], String)
	 * @param driverId
	 * @param pageId
	 * @param driver
	 * @param appNum
	 */
	@Override
	public void makeRequired(final String driverId, final String pageId, final int[] driver, final String appNum) {
		try {
			final Map pageIdArrayIndex = lookUpThePageIdArrayIndexMap(driverId);
			final int index = lookUpforIndexPosition(pageId, pageIdArrayIndex);
			// Look up for the Status in Driver.
			// and Assign the New Value.
			driver[index] = processMakeRequired(driver[index]);

			if (driverId.equals(FwConstants.AFB_DRIVER) || driverId.equals(FwConstants.RMC_DRIVER) || driverId.equals(FwConstants.APW_DRIVER)
					|| driverId.equals(FwConstants.APC_DRIVER) || driverId.equals(FwConstants.AHN_DRIVER)) {
				updateDriverTable(pageId, driver[index], appNum, driverId);
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("makeRequired");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	/**
	 * Process Make Required
	 *
	 * @param driverStatus
	 * @return int
	 */
	private int processMakeRequired(final int driverStatus) {
		switch (driverStatus) {
		case IDriver.DRIVER_INDEX_NOT_REQUIRED:
			return IDriver.DRIVER_INDEX_REQUIRED;
		case IDriver.DRIVER_INDEX_REQUIRED:
			return IDriver.DRIVER_INDEX_REQUIRED;
		case IDriver.DRIVER_INDEX_VISIT_AGAIN:
			return IDriver.DRIVER_INDEX_VISIT_AGAIN;
		case IDriver.DRIVER_INDEX_PENDING:
			return IDriver.DRIVER_INDEX_REQUIRED;
		case IDriver.DRIVER_INDEX_COMPLETE:
			return IDriver.DRIVER_INDEX_VISIT_AGAIN;
		case IDriver.DRIVER_INDEX_ADD_NEW:
			return IDriver.DRIVER_INDEX_VISIT_AGAIN;
		default:
			return IDriver.DRIVER_INDEX_NOT_REQUIRED;
		}
	}

	/**
	 * Make Not Required
	 *
	 * @param driverId
	 * @param pageId
	 * @param driver
	 */
	@Override
	public void makeNotRequired(final String driverId, final String pageId, final int[] driver) {
		makeNotRequired(driverId, pageId, driver, null);
	}

	/**
	 * Make Not Required
	 *
	 * @see IDriver#makeNotRequired(String, String, int[], String)
	 * @param driverId
	 * @param pageId
	 * @param driver
	 * @param appNum
	 */
	@Override
	public void makeNotRequired(final String driverId, final String pageId, final int[] driver, final String appNum) {
		try {
			final Map pageIdArrayIndex = lookUpThePageIdArrayIndexMap(driverId);
			final int index = lookUpforIndexPosition(pageId, pageIdArrayIndex);
			// Look up for the Status in Driver.
			// and Assign the New Value.
			driver[index] = processMakeNotRequired(driver[index]);

			if (driverId.equals(FwConstants.AFB_DRIVER) || driverId.equals(FwConstants.RMC_DRIVER) || driverId.equals(FwConstants.APW_DRIVER)
					|| driverId.equals(FwConstants.APC_DRIVER) || driverId.equals(FwConstants.AHN_DRIVER)) {
				updateDriverTable(pageId, driver[index], appNum, driverId);
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("makeNotRequired");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}

	}

	/**
	 * Process Make Not Required
	 *
	 * @param driverStatus
	 * @return int
	 */
	private int processMakeNotRequired(final int driverStatus) {
		switch (driverStatus) {
		case IDriver.DRIVER_INDEX_NOT_REQUIRED:
			return IDriver.DRIVER_INDEX_NOT_REQUIRED;
		case IDriver.DRIVER_INDEX_REQUIRED:
			return IDriver.DRIVER_INDEX_NOT_REQUIRED;
		case IDriver.DRIVER_INDEX_VISIT_AGAIN:
			return IDriver.DRIVER_INDEX_COMPLETE;
		case IDriver.DRIVER_INDEX_PENDING:
			return IDriver.DRIVER_INDEX_NOT_REQUIRED;
		case IDriver.DRIVER_INDEX_COMPLETE:
			return IDriver.DRIVER_INDEX_COMPLETE;
		case IDriver.DRIVER_INDEX_ADD_NEW:
			return IDriver.DRIVER_INDEX_COMPLETE;
		default:
			return IDriver.DRIVER_INDEX_NOT_REQUIRED;
		}
	}

	/**
	 * Make Complete
	 *
	 * @see IDriver#makeComplete(String, String, int[])
	 * @param driverId
	 * @param pageId
	 * @param driver
	 */
	@Override
	public void makeComplete(final String driverId, final String pageId, final int[] driver) {
		makeComplete(driverId, pageId, driver, null);
	}

	/**
	 * Make Complete
	 *
	 * @see IDriver#makeComplete(String, String, int[], String)
	 * @param driverId
	 * @param pageId
	 * @param driver
	 * @param appNum
	 */
	@Override
	public void makeComplete(final String driverId, final String pageId, final int[] driver, final String appNum) {
		try {
			final Map pageIdArrayIndex = lookUpThePageIdArrayIndexMap(driverId);
			final int index = lookUpforIndexPosition(pageId, pageIdArrayIndex);
			// Look up for the Status in Driver.
			// and Assign the New Value.
			driver[index] = processMakeComplete(driver[index]);

			if (driverId.equals(FwConstants.AFB_DRIVER) || driverId.equals(FwConstants.RMC_DRIVER) || driverId.equals(FwConstants.APW_DRIVER)
					|| driverId.equals(FwConstants.APC_DRIVER) || driverId.equals(FwConstants.AHN_DRIVER)) {
				updateDriverTable(pageId, driver[index], appNum, driverId);
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("makeComplete");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	/**
	 * Process Make Complete
	 *
	 * @param driverStatus
	 * @return int
	 */
	private int processMakeComplete(final int driverStatus) {
		switch (driverStatus) {
		case IDriver.DRIVER_INDEX_NOT_REQUIRED:
			return IDriver.DRIVER_INDEX_COMPLETE;
		case IDriver.DRIVER_INDEX_REQUIRED:
			return IDriver.DRIVER_INDEX_COMPLETE;
		case IDriver.DRIVER_INDEX_VISIT_AGAIN:
			return IDriver.DRIVER_INDEX_COMPLETE;
		case IDriver.DRIVER_INDEX_PENDING:
			return IDriver.DRIVER_INDEX_COMPLETE;
		case IDriver.DRIVER_INDEX_COMPLETE:
			return IDriver.DRIVER_INDEX_COMPLETE;
		case IDriver.DRIVER_INDEX_ADD_NEW:
			return IDriver.DRIVER_INDEX_COMPLETE;
		default:
			return IDriver.DRIVER_INDEX_NOT_REQUIRED;
		}
	}

	/**
	 * Load driver
	 *
	 * @param newBusinessDriverId
	 * @param defaultDriverId
	 * @param driver
	 * @return int[]
	 */
	public int[] loadBusinessDriver(final String newBusinessDriverId, final String defaultDriverId, final int[] driver) {
		try {

			final Map _tempPageIdArrayIndex = (HashMap) pageIdArrayIndexMap.get(defaultDriverId);
			final ArrayList _businessDriverPageArray = (ArrayList) businessDriverMap.get(newBusinessDriverId);
			final Map _tempBusinessDriverPageIdStatusMap = (HashMap) businessDriverPageIdStatusMap.get(newBusinessDriverId);
			// Iterate through the ArrayList to get the PageId.
			final int size = _businessDriverPageArray.size();
			for (int i = 0; i < size; i++) {
				final String pageId = (String) _businessDriverPageArray.get(i);
				// For Each pageId Get the index from the Map available in Cache
				final int index = Integer.parseInt((String) _tempPageIdArrayIndex.get(pageId));
				// For the index position in the driver Array, change the status
				// to the Status in the Business driver as Required.
				driver[index] = getConvertedInt((String) _tempBusinessDriverPageIdStatusMap.get(pageId));
			}
			return driver;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("loadBusinessDriver");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	/**
	 * Get driver status
	 *
	 * @param driverId
	 * @param pageId
	 * @param driver
	 */
	@Override
	public String getStatus(final String driverId, final String pageId, final int[] driver) {
		return getConvertedStatus(driver[getIndexForPageId(driverId, pageId)]);
	}

	/**
	 * Get APW driver status
	 *
	 * @param driverId
	 * @param pageId
	 * @param driver
	 */
	@Override
	public int getAPWStatus(final String driverId, final String pageId, final int[] driver) {
		return driver[getIndexForPageId(driverId, pageId)];
	}

	/**
	 * Get APC driver status
	 *
	 * @param driverId
	 * @param pageId
	 * @param driver
	 */
	@Override
	public int getAPCStatus(final String driverId, final String pageId, final int[] driver) {
		return driver[getIndexForPageId(driverId, pageId)];
	}

	/**
	 * Get AFB driver status
	 *
	 * @param driverId
	 * @param pageId
	 * @param driver
	 */
	@Override
	public int getAFBStatus(final String driverId, final String pageId, final int[] driver) {
		return driver[getIndexForPageId(driverId, pageId)];
	}

	/**
	 * Get NEHNA driver status
	 *
	 * @param driverId
	 * @param pageId
	 * @param driver
	 */
	@Override
	public int getAHNStatus(final String driverId, final String pageId, final int[] driver) {
		return driver[getIndexForPageId(driverId, pageId)];
	}

	/**
	 * Get Index for Page Id
	 *
	 * @param driverId
	 * @param pageId
	 * @return int
	 */
	@Override
	public int getIndexForPageId(final String driverId, final String pageId) {
		try {
			final Map _tempPageIdArrayIndex = (Map) pageIdArrayIndexMap.get(driverId);
			final FwDriverMapIndex index = (FwDriverMapIndex) _tempPageIdArrayIndex.get(pageId);
			if (index != null) {
				return index.getIndex();
			} else {
				return -1;
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("getIndexForPageId");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	/**
	 * Make Required
	 *
	 * @see IDriver#makeRequired(String, String[], int[])
	 * @param driverId
	 * @param pageIds
	 * @param driver
	 */
	@Override
	public void makeRequired(final String driverId, final String[] pageIds, final int[] driver) {
		makeRequired(driverId, pageIds, driver, null);
	}

	/**
	 * Make Required
	 *
	 * @see IDriver#makeRequired(String, String[], int[], String)
	 * @param driverId
	 * @param pageIds
	 * @param driver
	 * @param appNum
	 */
	@Override
	public void makeRequired(final String driverId, final String[] pageIds, final int[] driver, final String appNum) {
		try {
			final Map pageIdArrayIndex = lookUpThePageIdArrayIndexMap(driverId);
			final int pageIdsSize = pageIds.length;
			final int[] pageidDriverStatusArray = new int[pageIdsSize];
			for (int i = 0; i < pageIdsSize; i++) {
				final int index = lookUpforIndexPosition(pageIds[i], pageIdArrayIndex);
				// Look up for the Status in Driver and Assign the New Value.
				pageidDriverStatusArray[i] = driver[index] = processMakeRequired(driver[index]);
			}
			if (driverId.equals(FwConstants.AFB_DRIVER) || driverId.equals(FwConstants.RMC_DRIVER) || driverId.equals(FwConstants.APW_DRIVER)
					|| driverId.equals(FwConstants.APC_DRIVER) || driverId.equals(FwConstants.AHN_DRIVER)) {
				updateDriverTable(pageIds, pageidDriverStatusArray, appNum, driverId);
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("makeRequired");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}

	}

	/**
	 * Make Not Required
	 *
	 * @see IDriver#makeNotRequired(String, String[], int[])
	 * @param driverId
	 * @param pageIds
	 * @param driver
	 */
	@Override
	public void makeNotRequired(final String driverId, final String[] pageIds, final int[] driver) {
		makeNotRequired(driverId, pageIds, driver, null);
	}

	/**
	 * Make Not Required
	 *
	 * @see IDriver#makeNotRequired(String, String[], int[])
	 * @param driverId
	 * @param pageIds
	 * @param driver
	 * @param appNum
	 */
	@Override
	public void makeNotRequired(final String driverId, final String[] pageIds, final int[] driver, final String appNum) {
		try {
			final Map pageIdArrayIndex = lookUpThePageIdArrayIndexMap(driverId);
			final int pageIdsSize = pageIds.length;
			final int[] pageidDriverStatusArray = new int[pageIdsSize];
			for (int i = 0; i < pageIdsSize; i++) {
				final int index = lookUpforIndexPosition(pageIds[i], pageIdArrayIndex);
				// Look up for the Status in Driver and Assign the New Value.
				pageidDriverStatusArray[i] = driver[index] = processMakeNotRequired(driver[index]);
			}
			if (driverId.equals(FwConstants.AFB_DRIVER) || driverId.equals(FwConstants.RMC_DRIVER) || driverId.equals(FwConstants.APW_DRIVER)
					|| driverId.equals(FwConstants.APC_DRIVER) || driverId.equals(FwConstants.AHN_DRIVER)) {
				updateDriverTable(pageIds, pageidDriverStatusArray, appNum, driverId);
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("makeNotRequired");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}

	}

	/**
	 * Make Complete
	 *
	 * @see IDriver#makeComplete(String, String[], int[])
	 * @param driverId
	 * @param pageIds
	 * @param driver
	 */
	@Override
	public void makeComplete(final String driverId, final String[] pageIds, final int[] driver) {
		makeComplete(driverId, pageIds, driver, null);
	}

	/**
	 * Make Complete
	 *
	 * @see IDriver#makeComplete(String, String[], int[], String)
	 * @param driverId
	 * @param pageIds
	 * @param driver
	 * @param appNum
	 */
	@Override
	public void makeComplete(final String driverId, final String[] pageIds, final int[] driver, final String appNum) {
		try {
			final Map pageIdArrayIndex = lookUpThePageIdArrayIndexMap(driverId);
			final int pageIdsSize = pageIds.length;
			final int[] pageidDriverStatusArray = new int[pageIdsSize];

			for (int i = 0; i < pageIdsSize; i++) {
				final int index = lookUpforIndexPosition(pageIds[i], pageIdArrayIndex);
				// Look up for the Status in Driver and Assign the New Value.
				pageidDriverStatusArray[i] = driver[index] = processMakeComplete(driver[index]);

			}
			if (driverId.equals(FwConstants.AFB_DRIVER) || driverId.equals(FwConstants.RMC_DRIVER) || driverId.equals(FwConstants.APW_DRIVER)
					|| driverId.equals(FwConstants.APC_DRIVER) || driverId.equals(FwConstants.AHN_DRIVER)) {
				updateDriverTable(pageIds, pageidDriverStatusArray, appNum, driverId);
			}

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("makeComplete");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	/**
	 * Make Absolute Not Required
	 *
	 * @see IDriver#makeAbsoluteNotRequired(String, String[], int[])
	 * @param driverId
	 * @param pageIds
	 * @param driver
	 */
	@Override
	public void makeAbsoluteNotRequired(final String driverId, final String[] pageIds, final int[] driver) {
		makeAbsoluteNotRequired(driverId, pageIds, driver, null);
	}

	/**
	 * Make Absolute Not Required
	 *
	 * @see IDriver#makeAbsoluteNotRequired(String, String[], int[], String)
	 * @param driverId
	 * @param pageIds
	 * @param driver
	 * @param appNum
	 */
	@Override
	public void makeAbsoluteNotRequired(final String driverId, final String[] pageIds, final int[] driver, final String appNum) {
		try {
			final Map pageIdArrayIndex = lookUpThePageIdArrayIndexMap(driverId);
			final int pageIdsSize = pageIds.length;
			final int[] pageidDriverStatusArray = new int[pageIdsSize];
			for (int i = 0; i < pageIdsSize; i++) {
				final int index = lookUpforIndexPosition(pageIds[i], pageIdArrayIndex);
				// set to not required value
				pageidDriverStatusArray[i] = driver[index] = IDriver.DRIVER_INDEX_NOT_REQUIRED;
			}
			if (driverId.equals(FwConstants.AFB_DRIVER) || driverId.equals(FwConstants.RMC_DRIVER) || driverId.equals(FwConstants.APW_DRIVER)
					|| driverId.equals(FwConstants.APC_DRIVER) || driverId.equals(FwConstants.AHN_DRIVER)) {
				updateDriverTable(pageIds, pageidDriverStatusArray, appNum, driverId);
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("makeAbsoluteNotRequired");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	/**
	 * Make Absolute Not Required
	 *
	 * @see IDriver#makeAbsoluteNotRequired(String, String, int[], String)
	 * @param driverId
	 * @param pageIds
	 * @param driver
	 * @param appNum
	 */
	@Override
	public void makeAbsoluteNotRequired(final String driverId, final String pageId, final int[] driver, final String appNum) {
		try {
			final Map pageIdArrayIndex = lookUpThePageIdArrayIndexMap(driverId);
			final int index = lookUpforIndexPosition(pageId, pageIdArrayIndex);
			// set to not required value
			driver[index] = IDriver.DRIVER_INDEX_NOT_REQUIRED;
			if (driverId.equals(FwConstants.AFB_DRIVER) || driverId.equals(FwConstants.RMC_DRIVER) || driverId.equals(FwConstants.APW_DRIVER)
					|| driverId.equals(FwConstants.APC_DRIVER) || driverId.equals(FwConstants.AHN_DRIVER)) {
				updateDriverTable(pageId, driver[index], appNum, driverId);
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("makeNotRequired");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	/**
	 * Make Absolute Not Required
	 *
	 * @see IDriver#makeAbsoluteNotRequired(String, String, int[])
	 * @param driverId
	 * @param pageId
	 * @param driver
	 */
	@Override
	public void makeAbsoluteNotRequired(final String driverId, final String pageId, final int[] driver) {
		makeAbsoluteNotRequired(driverId, pageId, driver, null);
	}

	/**
	 * Look up the page Id Array
	 *
	 * @param driverId
	 * @return Map
	 */
	private Map lookUpThePageIdArrayIndexMap(final String driverId) {
		try {
			Map pageIdArrayIndex = new HashMap();
			if (pageIdArrayIndexMap.containsKey(driverId)) {
				pageIdArrayIndex = (HashMap) pageIdArrayIndexMap.get(driverId);
			}
			return pageIdArrayIndex;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("lookUpThePageIdArrayIndexMap");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}

	}

	/**
	 * Look up for Index position
	 *
	 * @param pageId
	 * @param pageIdArrayIndex
	 * @return int
	 */
	private int lookUpforIndexPosition(final String pageId, final Map pageIdArrayIndex) {
		try {
			final FwDriverMapIndex index = (FwDriverMapIndex) pageIdArrayIndex.get(pageId);
			if (index != null) {
				return index.getIndex();
			} else {
				return 0;
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("lookUpforIndexPosition");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	/**
	 * Get Page Action and Page Id map
	 *
	 * @param driverId
	 * @param index
	 * @return Map
	 */
	public Map getPageActionPageIdMap(final String driverId, final int index) {
		try {
			if (pageActionPageIdMap.containsKey(driverId)) {
				final ArrayList list = (ArrayList) pageActionPageIdMap.get(driverId);
				pageActionPageIdMap = (HashMap) list.get(index);
			}
			return pageActionPageIdMap;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("getPageActionPageIdMap");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	/**
	 * Get Page Action
	 *
	 * @param driverId
	 * @param pageId
	 * @return String
	 */
	@Override
	public String getPageAction(final String driverId, final String pageId) {
		String pageAction = null;
		if (pageIdPageActionMap.containsKey(driverId)) {
			final Map tempMap = (HashMap) pageIdPageActionMap.get(driverId);
			pageAction = (String) tempMap.get(String.valueOf(pageId));
		}
		return pageAction;
	}

	/**
	 * Get Page Id
	 *
	 * @param driverId
	 * @param index
	 * @return String
	 */
	@Override
	public String getPageId(final String driverId, final int index) {
		String pageId = null;
		if (arrayIndexPageIdMap.containsKey(driverId)) {
			final Map tempMap = (HashMap) arrayIndexPageIdMap.get(driverId);
			pageId = (String) tempMap.get(String.valueOf(index));
		}
		return pageId;
	}

	/**
	 * Reassess driver
	 *
	 * @param driverId
	 * @param currentPageId
	 * @param driver
	 *
	 *            Changed by the EDSP CP team (@author VKhenat) for picking up
	 *            the correct sequence of pages.
	 */
	@Override
	public void reassessDriver(final String driverId, final String currentPageId, final int[] driver) {
		try {
			final int index = getIndexForPageId(driverId, currentPageId);
			// Start at array index of the current page
			// Go to the next array index and change the
			// Value to the one that is Default.
			final int lengthOfArray = driver.length;
			for (int i = index + 1; i < lengthOfArray; i++) {
				if (driver[i] != IDriver.DRIVER_INDEX_NOT_REQUIRED) {
					driver[i] = IDriver.DRIVER_INDEX_REQUIRED;
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("reassessDriver");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}

	}

	/**
	 * Updates the data in driver table
	 *
	 * @param aPageid
	 * @param aStatus
	 * @param aAppNum
	 * @param driverId
	 */
	private void updateDriverTable(final String aPageid, final int aStatus, final String aAppNum, final String driverId) {
		try {
			updateDriverTable(new String[] { aPageid }, new int[] { aStatus }, aAppNum, driverId);
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("updateDriverTable");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	/**
	 * Updates the data in driver table
	 *
	 * @param aPageid
	 * @param aStatus
	 * @param aAppNum
	 * @param driverId
	 */
	private void updateDriverTable(final String[] aPageid, final int[] aStatus, final String aAppNum, final String driverId) {

		try {
			final String pageIdExt = "_STAT_IND";
			final FwDataCriteria[] dataCriteriaArray = new FwDataCriteria[aPageid.length];
			final int dataCriteriaLength = dataCriteriaArray.length;
			for (int i = 0; i < dataCriteriaLength; i++) {
				dataCriteriaArray[i] = new FwDataCriteria();
				dataCriteriaArray[i].setColumn_name(aPageid[i] + pageIdExt);
				dataCriteriaArray[i].setColumn_value(String.valueOf(aStatus[i]));
				dataCriteriaArray[i].setData_type(FwConstants.SHORT);
			}
			final FwDataCriteria[] whereCriteriaArray = new FwDataCriteria[1];
			whereCriteriaArray[0] = new FwDataCriteria();
			whereCriteriaArray[0].setColumn_name("APP_NUM");
			whereCriteriaArray[0].setColumn_value(aAppNum);
			whereCriteriaArray[0].setData_type(FwConstants.LONG);
			if (driverId.equals(FwConstants.AFB_DRIVER)) {
				final AFB_DRVR_Cargo cargo = new AFB_DRVR_Cargo();
				cargo.setDataCriteria(dataCriteriaArray);
				cargo.setWhereCriteria(whereCriteriaArray);
				final AFB_DRVR_Collection collec = new AFB_DRVR_Collection();
				collec.addCargo(cargo);
				collec.persist(FwConstants.DAO, "updateAFBDriverTable");
			} else if (driverId.equals(FwConstants.RMC_DRIVER)) {
				final RMC_DRVR_Cargo cargo = new RMC_DRVR_Cargo();
				cargo.setDataCriteria(dataCriteriaArray);
				cargo.setWhereCriteria(whereCriteriaArray);
				final RMC_DRVR_Collection collec = new RMC_DRVR_Collection();
				collec.addCargo(cargo);
				collec.persist(FwConstants.DAO, "updateRMCDriverTable");
			} else if (driverId.equals(FwConstants.APW_DRIVER)) {
				// Update the cargo and collection with the exact name
				final PE_PREG_WMN_DRVR_Cargo cargo = new PE_PREG_WMN_DRVR_Cargo();
				cargo.setDataCriteria(dataCriteriaArray);
				cargo.setWhereCriteria(whereCriteriaArray);
				final PE_PREG_WMN_DRVR_Collection collec = new PE_PREG_WMN_DRVR_Collection();
				collec.addCargo(cargo);
				collec.persist(FwConstants.DAO, "updateAPWDriverTable");
			} else if (driverId.equals(FwConstants.APC_DRIVER)) {
				// Update the cargo and collection with the exact name
				final PE_CHLD_DRVR_Cargo cargo = new PE_CHLD_DRVR_Cargo();
				cargo.setDataCriteria(dataCriteriaArray);
				cargo.setWhereCriteria(whereCriteriaArray);
				final PE_CHLD_DRVR_Collection collec = new PE_CHLD_DRVR_Collection();
				collec.addCargo(cargo);
				collec.persist(FwConstants.DAO, "updateAPCDriverTable");
			} 
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("updateDriverTable");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	/**
	 * Make Add New
	 *
	 * @see gov.state.nextgen.framework.driver.IDriver#makeAddNew(java.lang.String,
	 *      java.lang.String, int[])
	 * @param driverId
	 * @param pageId
	 * @param driver
	 */
	@Override
	public void makeAddNew(final String driverId, final String pageId, final int[] driver) {
		makeAddNew(driverId, pageId, driver, null);
	}

	/**
	 * Make Add New
	 *
	 * @see gov.state.nextgen.framework.driver.IDriver#makeAddNew(java.lang.String,
	 *      java.lang.String, int[], java.lang.String)
	 * @param driverId
	 * @param pageId
	 * @param driver
	 * @param appNum
	 */
	@Override
	public void makeAddNew(final String driverId, final String pageId, final int[] driver, final String appNum) {
		try {

			final Map pageIdArrayIndex = lookUpThePageIdArrayIndexMap(driverId);
			final int index = lookUpforIndexPosition(pageId, pageIdArrayIndex);
			// Look up for the Status in Driver.
			// and Assign the New Value.
			driver[index] = processMakeAddNew(driver[index]);

			if (driverId.equals(FwConstants.AFB_DRIVER) || driverId.equals(FwConstants.RMC_DRIVER) || driverId.equals(FwConstants.APW_DRIVER)
					|| driverId.equals(FwConstants.APC_DRIVER)) {
				updateDriverTable(pageId, driver[index], appNum, driverId);
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("makeAddNew");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}

	}

	/**
	 * Make Add New
	 *
	 * @see gov.state.nextgen.framework.driver.IDriver#makeAddNew(java.lang.String,
	 *      java.lang.String[], int[])
	 * @param driverId
	 * @param pageIds
	 * @param driver
	 */
	@Override
	public void makeAddNew(final String driverId, final String[] pageIds, final int[] driver) {
		makeAddNew(driverId, pageIds, driver, null);
	}

	/**
	 * Make Add New
	 *
	 * @see gov.state.nextgen.framework.driver.IDriver#makeAddNew(java.lang.String,
	 *      java.lang.String[], int[], java.lang.String)
	 * @param driverId
	 * @param pageIds
	 * @param driver
	 * @param appNum
	 */
	@Override
	public void makeAddNew(final String driverId, final String[] pageIds, final int[] driver, final String appNum) {
		try {
			final Map pageIdArrayIndex = lookUpThePageIdArrayIndexMap(driverId);
			final int pageIdsSize = pageIds.length;
			for (int i = 0; i < pageIdsSize; i++) {
				final int index = lookUpforIndexPosition(pageIds[i], pageIdArrayIndex);
				// Look up for the Status in Driver.
				// and Assign the New Value.
				driver[index] = processMakeAddNew(driver[index]);
				if (driverId.equals(FwConstants.AFB_DRIVER) || driverId.equals(FwConstants.RMC_DRIVER) || driverId.equals(FwConstants.APW_DRIVER)
						|| driverId.equals(FwConstants.APC_DRIVER)) {
					updateDriverTable(pageIds[i], driver[index], appNum, driverId);
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("makeAddNew");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}

	}

	/**
	 * Returns the new status for the existing status
	 *
	 * @param driverStatus
	 * @return int
	 */
	private int processMakeAddNew(final int driverStatus) {

		switch (driverStatus) {
		case IDriver.DRIVER_INDEX_NOT_REQUIRED:
			return IDriver.DRIVER_INDEX_REQUIRED;
		case IDriver.DRIVER_INDEX_REQUIRED:
			return IDriver.DRIVER_INDEX_REQUIRED;
		case IDriver.DRIVER_INDEX_VISIT_AGAIN:
			return IDriver.DRIVER_INDEX_VISIT_AGAIN;
		case IDriver.DRIVER_INDEX_COMPLETE:
			return IDriver.DRIVER_INDEX_ADD_NEW;
		case IDriver.DRIVER_INDEX_ADD_NEW:
			return IDriver.DRIVER_INDEX_ADD_NEW;
		default:
			return IDriver.DRIVER_INDEX_NOT_REQUIRED;
		}
	}

	/**
	 * Creates default driver
	 *
	 * @param driverId
	 * @param appNumber
	 * @return int[]
	 */
	@Override
	public int[] createDefaultDriver(final String driverId, final String appNumber) {
		int[] newDriver = null;
		try {
			final int[] tempDriver = (int[]) defaultDriverMap.get(driverId);
			newDriver = new int[tempDriver.length];
			// Use System.arrayCopy to copy array
			System.arraycopy(tempDriver, 0, newDriver, 0, newDriver.length);
			if (driverId.equals(FwConstants.AFB_DRIVER)) {
				final AFB_DRVR_Collection coll = new AFB_DRVR_Collection();
				final AFB_DRVR_Cargo cargo = createNewAFBDriverCargo();
				// Set the case number to the cargo
				cargo.setApp_num(appNumber);
				cargo.setRowAction(FwConstants.ROWACTION_INSERT);
				coll.addCargo(cargo);
				coll.persist(FwConstants.DAO);
			} else if (driverId.equals(FwConstants.RMC_DRIVER) || driverId.equals(FwConstants.RMB_DRIVER)) {
				final RMC_DRVR_Collection coll = new RMC_DRVR_Collection();
				final RMC_DRVR_Cargo cargo = createNewRMCDriverCargo();
				// set the case number to the cargo
				cargo.setApp_num(appNumber);
				cargo.setRowAction(FwConstants.ROWACTION_INSERT);
				coll.addCargo(cargo);
				coll.persist(FwConstants.DAO);

			} else if (driverId.equals(FwConstants.APP_PW_DRIVER)) {
				final PE_PREG_WMN_DRVR_Collection coll = new PE_PREG_WMN_DRVR_Collection();
				final PE_PREG_WMN_DRVR_Cargo cargo = createNewAPWDriverCargo();
				// set the case number to the cargo
				cargo.setApp_num(appNumber);
				cargo.setRowAction(FwConstants.ROWACTION_INSERT);
				coll.addCargo(cargo);
				coll.persist(FwConstants.DAO);
			} else if (driverId.equals(FwConstants.APP_CH_DRIVER)) {
				final PE_CHLD_DRVR_Collection coll = new PE_CHLD_DRVR_Collection();
				final PE_CHLD_DRVR_Cargo cargo = createNewAPCDriverCargo();
				// set the case number to the cargo
				cargo.setApp_num(appNumber);
				cargo.setRowAction(FwConstants.ROWACTION_INSERT);
				coll.addCargo(cargo);
				coll.persist(FwConstants.DAO);
			} 
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("createDefaultDriver");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}

		return newDriver;
	}

	/**
	 * Creates new AFB driver
	 *
	 * @return AFB_DRVR_Cargo
	 */
	private AFB_DRVR_Cargo createNewAFBDriverCargo() {
		final AFB_DRVR_Cargo cargo = new AFB_DRVR_Cargo();
		cargo.setAbapd_stat_ind(afbDriverCargo.getAbapd_stat_ind());
		cargo.setAbbnr_stat_ind(afbDriverCargo.getAbbnr_stat_ind());
		cargo.setAbdcd_stat_ind(afbDriverCargo.getAbdcd_stat_ind());
		cargo.setAbedt_stat_ind(afbDriverCargo.getAbedt_stat_ind());
		cargo.setAbiki_stat_ind(afbDriverCargo.getAbiki_stat_ind());
		cargo.setAbefd_stat_ind(afbDriverCargo.getAbefd_stat_ind());
		cargo.setAbesm_stat_ind(afbDriverCargo.getAbesm_stat_ind());
		cargo.setAbfas_stat_ind(afbDriverCargo.getAbfas_stat_ind());
		cargo.setAbheq_stat_ind(afbDriverCargo.getAbheq_stat_ind());
		cargo.setAbhes_stat_ind(afbDriverCargo.getAbhes_stat_ind());
		cargo.setAbhhq_stat_ind(afbDriverCargo.getAbhhq_stat_ind());
		cargo.setAbcfn_stat_ind(afbDriverCargo.getAbcfn_stat_ind());
		cargo.setAbofs_stat_ind(afbDriverCargo.getAbofs_stat_ind());
		cargo.setAbhhr_stat_ind(afbDriverCargo.getAbhhr_stat_ind());
		cargo.setAbhis_stat_ind(afbDriverCargo.getAbhis_stat_ind());
		cargo.setAbhmd_stat_ind(afbDriverCargo.getAbhmd_stat_ind());
		cargo.setAbshs_stat_ind(afbDriverCargo.getAbshs_stat_ind());
		cargo.setAbspd_stat_ind(afbDriverCargo.getAbspd_stat_ind());
		cargo.setAbhel_stat_ind(afbDriverCargo.getAbhel_stat_ind());
		cargo.setAbpng_stat_ind(afbDriverCargo.getAbpng_stat_ind());
		cargo.setAbhng_stat_ind(afbDriverCargo.getAbhng_stat_ind());
		cargo.setAbped_stat_ind(afbDriverCargo.getAbped_stat_ind());
		cargo.setAbedr_stat_ind(afbDriverCargo.getAbedr_stat_ind());
		cargo.setAbphd_stat_ind(afbDriverCargo.getAbphd_stat_ind());
		cargo.setAbhdr_stat_ind(afbDriverCargo.getAbhdr_stat_ind());
		cargo.setAbdfg_stat_ind(afbDriverCargo.getAbdfg_stat_ind());
		cargo.setAbfur_stat_ind(afbDriverCargo.getAbfur_stat_ind());
		cargo.setAbpth_stat_ind(afbDriverCargo.getAbpth_stat_ind());
		cargo.setAbsss_stat_ind(afbDriverCargo.getAbsss_stat_ind());
		cargo.setAbstd_stat_ind(afbDriverCargo.getAbstd_stat_ind());
		cargo.setAbuad_stat_ind(afbDriverCargo.getAbuad_stat_ind());
		cargo.setAbhms_stat_ind(afbDriverCargo.getAbhms_stat_ind());
		cargo.setAbjiq_stat_ind(afbDriverCargo.getAbjiq_stat_ind());
		cargo.setAbjis_stat_ind(afbDriverCargo.getAbjis_stat_ind());
		cargo.setAbmed_stat_ind(afbDriverCargo.getAbmed_stat_ind());
		cargo.setAbnsd_stat_ind(afbDriverCargo.getAbnsd_stat_ind());
		cargo.setAbnso_stat_ind(afbDriverCargo.getAbnso_stat_ind());
		cargo.setAboeq_stat_ind(afbDriverCargo.getAboeq_stat_ind());
		cargo.setAboiq_stat_ind(afbDriverCargo.getAboiq_stat_ind());
		cargo.setAbois_stat_ind(afbDriverCargo.getAbois_stat_ind());
		cargo.setAbpps_stat_ind(afbDriverCargo.getAbpps_stat_ind());
		cargo.setAbpri_stat_ind(afbDriverCargo.getAbpri_stat_ind());
		cargo.setAbpsq_stat_ind(afbDriverCargo.getAbpsq_stat_ind());
		cargo.setAbrgi_stat_ind(afbDriverCargo.getAbrgi_stat_ind());
		cargo.setAbrgs_stat_ind(afbDriverCargo.getAbrgs_stat_ind());
		cargo.setAbrlv_stat_ind(afbDriverCargo.getAbrlv_stat_ind());
		cargo.setAbscd_stat_ind(afbDriverCargo.getAbscd_stat_ind());
		cargo.setAbsct_stat_ind(afbDriverCargo.getAbsct_stat_ind());
		cargo.setAbsed_stat_ind(afbDriverCargo.getAbsed_stat_ind());
		cargo.setAbsen_stat_ind(afbDriverCargo.getAbsen_stat_ind());
		cargo.setAbucd_stat_ind(afbDriverCargo.getAbucd_stat_ind());
		cargo.setAbuct_stat_ind(afbDriverCargo.getAbuct_stat_ind());
		cargo.setAbuid_stat_ind(afbDriverCargo.getAbuid_stat_ind());
		cargo.setAbuit_stat_ind(afbDriverCargo.getAbuit_stat_ind());
		cargo.setAbprg_stat_ind(afbDriverCargo.getAbprg_stat_ind());
		cargo.setAbbad_stat_ind(afbDriverCargo.getAbbad_stat_ind());
		cargo.setAbbat_stat_ind(afbDriverCargo.getAbbat_stat_ind());
		cargo.setAbdis_stat_ind(afbDriverCargo.getAbdis_stat_ind());
		cargo.setAbhcd_stat_ind(afbDriverCargo.getAbhcd_stat_ind());
		cargo.setAbind_stat_ind(afbDriverCargo.getAbind_stat_ind());
		cargo.setAblad_stat_ind(afbDriverCargo.getAblad_stat_ind());
		cargo.setAblaq_stat_ind(afbDriverCargo.getAblaq_stat_ind());
		cargo.setAblas_stat_ind(afbDriverCargo.getAblas_stat_ind());
		cargo.setAblat_stat_ind(afbDriverCargo.getAblat_stat_ind());
		cargo.setAblid_stat_ind(afbDriverCargo.getAblid_stat_ind());
		cargo.setAblit_stat_ind(afbDriverCargo.getAblit_stat_ind());
		cargo.setAboaq_stat_ind(afbDriverCargo.getAboaq_stat_ind());
		cargo.setAboas_stat_ind(afbDriverCargo.getAboas_stat_ind());
		cargo.setAbppd_stat_ind(afbDriverCargo.getAbppd_stat_ind());
		cargo.setAbrpd_stat_ind(afbDriverCargo.getAbrpd_stat_ind());
		cargo.setAbrpt_stat_ind(afbDriverCargo.getAbrpt_stat_ind());
		cargo.setAbvad_stat_ind(afbDriverCargo.getAbvad_stat_ind());
		cargo.setAbvat_stat_ind(afbDriverCargo.getAbvat_stat_ind());
		cargo.setAbcon_stat_ind(afbDriverCargo.getAbcon_stat_ind());
		cargo.setAbhwa_stat_ind(afbDriverCargo.getAbhwa_stat_ind());
		cargo.setAbhca_stat_ind(afbDriverCargo.getAbhca_stat_ind());
		cargo.setAbmet_stat_ind(afbDriverCargo.getAbmet_stat_ind());
		cargo.setAbmbd_stat_ind(afbDriverCargo.getAbmbd_stat_ind());
		cargo.setAbmah_stat_ind(afbDriverCargo.getAbmah_stat_ind());
		// Start of VaCMS - Added for Deduction
		cargo.setAbdty_stat_ind(afbDriverCargo.getAbdty_stat_ind());
		cargo.setAbddt_stat_ind(afbDriverCargo.getAbddt_stat_ind());
		cargo.setAbdsm_stat_ind(afbDriverCargo.getAbdsm_stat_ind());
		// End of VaCMS - Added for Deduction
		// EDSP CP drug felony,current pending assistance,child past health
		// insurance
		cargo.setAbdfe_stat_ind(afbDriverCargo.getAbdfe_stat_ind());
		cargo.setAbcpa_stat_ind(afbDriverCargo.getAbcpa_stat_ind());
		cargo.setAbcph_stat_ind(afbDriverCargo.getAbcph_stat_ind());
		// EDSP CP drug felony,current pending assistance,child past health
		// insurance
		// EDSP CP Crisis Assistance, Cooling assistance, Fuel assistance
		cargo.setAbcra_stat_ind(afbDriverCargo.getAbcra_stat_ind());
		cargo.setAbeca_stat_ind(afbDriverCargo.getAbeca_stat_ind());
		cargo.setAbefa_stat_ind(afbDriverCargo.getAbefa_stat_ind());
		// EDSP CP Crisis Assistance, Cooling assistance, Fuel assistance
		// EDSP CP Shelter expense
		cargo.setAbshe_stat_ind(afbDriverCargo.getAbshe_stat_ind());
		// EDSP CP Shelter expense
		// EDSP CP SNAP Standard/Actual expense
		cargo.setAbsae_stat_ind(afbDriverCargo.getAbsae_stat_ind());
		// EDSP CP SNAP Standard/Actual expense
		// EDSP CP Work related expenses and Authorized representative
		cargo.setAbwre_stat_ind(afbDriverCargo.getAbwre_stat_ind());
		cargo.setAbaur_stat_ind(afbDriverCargo.getAbaur_stat_ind());
		cargo.setAbavd_stat_ind(afbDriverCargo.getAbavd_stat_ind());
		cargo.setAbhdn_stat_ind(afbDriverCargo.getAbhdn_stat_ind());
		cargo.setAbdoc_stat_ind(afbDriverCargo.getAbdoc_stat_ind());
		cargo.setAbobq_stat_ind(afbDriverCargo.getAbobq_stat_ind());
		cargo.setAbmdp_stat_ind(afbDriverCargo.getAbmdp_stat_ind());
		cargo.setAbhlt_stat_ind(afbDriverCargo.getAbhlt_stat_ind());
		cargo.setAbhsy_stat_ind(afbDriverCargo.getAbhsy_stat_ind());
		cargo.setAblhi_stat_ind(afbDriverCargo.getAblhi_stat_ind());
		cargo.setAbhsc_stat_ind(afbDriverCargo.getAbhsc_stat_ind());
		cargo.setAbnhm_stat_ind(afbDriverCargo.getAbnhm_stat_ind());
		cargo.setAbobs_stat_ind(afbDriverCargo.getAbobs_stat_ind());
		cargo.setAbipi_stat_ind(afbDriverCargo.getAbipi_stat_ind());
		cargo.setAbipq_stat_ind(afbDriverCargo.getAbipq_stat_ind());
		cargo.setAbcrc_stat_ind(afbDriverCargo.getAbcrc_stat_ind());
		cargo.setAbhip_stat_ind(afbDriverCargo.getAbhip_stat_ind());
		cargo.setAbort_stat_ind(afbDriverCargo.getAbort_stat_ind());
		cargo.setAbord_stat_ind(afbDriverCargo.getAbord_stat_ind());
		cargo.setAbpas_stat_ind(afbDriverCargo.getAbpas_stat_ind());
		cargo.setAbtax_stat_ind(afbDriverCargo.getAbtax_stat_ind());
		cargo.setAbitd_stat_ind(afbDriverCargo.getAbitd_stat_ind());
		cargo.setAbbtx_stat_ind(afbDriverCargo.getAbbtx_stat_ind());
		cargo.setAbbtd_stat_ind(afbDriverCargo.getAbbtd_stat_ind());
		cargo.setAbehi_stat_ind(afbDriverCargo.getAbehi_stat_ind());
		cargo.setAbhin_stat_ind(afbDriverCargo.getAbhin_stat_ind());
		cargo.setAbohi_stat_ind(afbDriverCargo.getAbohi_stat_ind());
		cargo.setAbtxr_stat_ind(afbDriverCargo.getAbtxr_stat_ind());
		cargo.setAbtxi_stat_ind(afbDriverCargo.getAbtxi_stat_ind());

		return cargo;
	}

	/**
	 * Creates new RMC driver
	 *
	 * @return RMC_DRVR_Cargo
	 */
	private RMC_DRVR_Cargo createNewRMCDriverCargo() {

		final RMC_DRVR_Cargo cargo = new RMC_DRVR_Cargo();
		cargo.setArcat_stat_ind(rmcDriverCargo.getArcat_stat_ind());
		cargo.setArhis_stat_ind(rmcDriverCargo.getArhis_stat_ind());
		cargo.setArpgq_stat_ind(rmcDriverCargo.getArpgq_stat_ind());
		cargo.setArpiq_stat_ind(rmcDriverCargo.getArpiq_stat_ind());
		cargo.setArpcs_stat_ind(rmcDriverCargo.getArpcs_stat_ind());
		cargo.setAracd_stat_ind(rmcDriverCargo.getAracd_stat_ind());
		cargo.setAravd_stat_ind(rmcDriverCargo.getAravd_stat_ind());
		cargo.setArhod_stat_ind(rmcDriverCargo.getArhod_stat_ind());
		cargo.setArhmo_stat_ind(rmcDriverCargo.getArhmo_stat_ind());
		cargo.setArhde_stat_ind(rmcDriverCargo.getArhde_stat_ind());
		cargo.setArhma_stat_ind(rmcDriverCargo.getArhma_stat_ind());
		cargo.setHshmo_stat_ind(rmcDriverCargo.getHshmo_stat_ind());
		cargo.setHsher_stat_ind(rmcDriverCargo.getHsher_stat_ind());
		cargo.setHscso_stat_ind(rmcDriverCargo.getHscso_stat_ind());
		cargo.setArhmi_stat_ind(rmcDriverCargo.getArhmi_stat_ind());
		cargo.setArhrl_stat_ind(rmcDriverCargo.getArhrl_stat_ind());
		cargo.setArplr_stat_ind(rmcDriverCargo.getArplr_stat_ind());
		cargo.setArapa_stat_ind(rmcDriverCargo.getArapa_stat_ind());
		cargo.setArhpg_stat_ind(rmcDriverCargo.getArhpg_stat_ind());
		cargo.setArhmd_stat_ind(rmcDriverCargo.getArhmd_stat_ind());
		cargo.setArhap_stat_ind(rmcDriverCargo.getArhap_stat_ind());
		cargo.setArdgp_stat_ind(rmcDriverCargo.getArdgp_stat_ind());
		cargo.setArhdd_stat_ind(rmcDriverCargo.getArhdd_stat_ind());
		cargo.setArhpd_stat_ind(rmcDriverCargo.getArhpd_stat_ind());
		cargo.setArdfd_stat_ind(rmcDriverCargo.getArdfd_stat_ind());
		cargo.setArhcs_stat_ind(rmcDriverCargo.getArhcs_stat_ind());
		cargo.setArhca_stat_ind(rmcDriverCargo.getArhca_stat_ind());
		cargo.setArobq_stat_ind(rmcDriverCargo.getArobq_stat_ind());
		cargo.setArobi_stat_ind(rmcDriverCargo.getArobi_stat_ind());
		cargo.setArobc_stat_ind(rmcDriverCargo.getArobc_stat_ind());
		cargo.setArhse_stat_ind(rmcDriverCargo.getArhse_stat_ind());
		cargo.setArhcd_stat_ind(rmcDriverCargo.getArhcd_stat_ind());
		cargo.setArpcd_stat_ind(rmcDriverCargo.getArpcd_stat_ind());
		cargo.setArmap_stat_ind(rmcDriverCargo.getArmap_stat_ind());
		cargo.setArobs_stat_ind(rmcDriverCargo.getArobs_stat_ind());
		cargo.setAragq_stat_ind(rmcDriverCargo.getAragq_stat_ind());
		cargo.setAraiq_stat_ind(rmcDriverCargo.getAraiq_stat_ind());
		cargo.setAracs_stat_ind(rmcDriverCargo.getAracs_stat_ind());
		cargo.setArlat_stat_ind(rmcDriverCargo.getArlat_stat_ind());
		cargo.setArlad_stat_ind(rmcDriverCargo.getArlad_stat_ind());
		cargo.setArvat_stat_ind(rmcDriverCargo.getArvat_stat_ind());
		cargo.setArvad_stat_ind(rmcDriverCargo.getArvad_stat_ind());
		cargo.setArrpt_stat_ind(rmcDriverCargo.getArrpt_stat_ind());
		cargo.setArrpd_stat_ind(rmcDriverCargo.getArrpd_stat_ind());
		cargo.setArppd_stat_ind(rmcDriverCargo.getArppd_stat_ind());
		cargo.setArbat_stat_ind(rmcDriverCargo.getArbat_stat_ind());
		cargo.setArbad_stat_ind(rmcDriverCargo.getArbad_stat_ind());
		cargo.setArlit_stat_ind(rmcDriverCargo.getArlit_stat_ind());
		cargo.setArlid_stat_ind(rmcDriverCargo.getArlid_stat_ind());
		cargo.setArasm_stat_ind(rmcDriverCargo.getArasm_stat_ind());
		cargo.setArjgq_stat_ind(rmcDriverCargo.getArjgq_stat_ind());
		cargo.setArjse_stat_ind(rmcDriverCargo.getArjse_stat_ind());
		cargo.setArjid_stat_ind(rmcDriverCargo.getArjid_stat_ind());
		cargo.setArehi_stat_ind(rmcDriverCargo.getArehi_stat_ind());
		cargo.setArjsd_stat_ind(rmcDriverCargo.getArjsd_stat_ind());
		cargo.setArjis_stat_ind(rmcDriverCargo.getArjis_stat_ind());
		cargo.setAroiq_stat_ind(rmcDriverCargo.getAroiq_stat_ind());
		cargo.setAruii_stat_ind(rmcDriverCargo.getAruii_stat_ind());
		cargo.setAruit_stat_ind(rmcDriverCargo.getAruit_stat_ind());
		cargo.setAruid_stat_ind(rmcDriverCargo.getAruid_stat_ind());
		cargo.setArrbi_stat_ind(rmcDriverCargo.getArrbi_stat_ind());
		cargo.setAruis_stat_ind(rmcDriverCargo.getAruis_stat_ind());
		cargo.setArxgq_stat_ind(rmcDriverCargo.getArxgq_stat_ind());
		cargo.setArxiq_stat_ind(rmcDriverCargo.getArxiq_stat_ind());
		cargo.setArxhu_stat_ind(rmcDriverCargo.getArxhu_stat_ind());
		cargo.setArxhi_stat_ind(rmcDriverCargo.getArxhi_stat_ind());
		cargo.setArxhd_stat_ind(rmcDriverCargo.getArxhd_stat_ind());
		cargo.setArxud_stat_ind(rmcDriverCargo.getArxud_stat_ind());
		cargo.setArrbe_stat_ind(rmcDriverCargo.getArrbe_stat_ind());
		cargo.setArdcd_stat_ind(rmcDriverCargo.getArdcd_stat_ind());
		cargo.setArsod_stat_ind(rmcDriverCargo.getArsod_stat_ind());
		cargo.setAriwe_stat_ind(rmcDriverCargo.getAriwe_stat_ind());
		cargo.setArmbd_stat_ind(rmcDriverCargo.getArmbd_stat_ind());
		cargo.setArxhs_stat_ind(rmcDriverCargo.getArxhs_stat_ind());
		cargo.setArper_stat_ind(rmcDriverCargo.getArper_stat_ind());
		cargo.setArfas_stat_ind(rmcDriverCargo.getArfas_stat_ind());
		cargo.setArprs_stat_ind(rmcDriverCargo.getArprs_stat_ind());
		cargo.setArtky_stat_ind(rmcDriverCargo.getArtky_stat_ind());
		cargo.setArhoh_stat_ind(rmcDriverCargo.getArhoh_stat_ind());
		cargo.setAroaq_stat_ind(rmcDriverCargo.getAroaq_stat_ind());
		cargo.setAroac_stat_ind(rmcDriverCargo.getAroac_stat_ind());
		cargo.setAroas_stat_ind(rmcDriverCargo.getAroas_stat_ind());
		cargo.setArsum_stat_ind(rmcDriverCargo.getArsum_stat_ind());
		cargo.setArhmx_stat_ind(rmcDriverCargo.getArhmx_stat_ind());
		cargo.setArmed_stat_ind(rmcDriverCargo.getArmed_stat_ind());
		cargo.setArhps_stat_ind(rmcDriverCargo.getArhps_stat_ind());
		cargo.setArhos_stat_ind(rmcDriverCargo.getArhos_stat_ind());
		cargo.setArnur_stat_ind(rmcDriverCargo.getArnur_stat_ind());
		cargo.setArofs_stat_ind(rmcDriverCargo.getArofs_stat_ind());
		cargo.setArort_stat_ind(rmcDriverCargo.getArort_stat_ind());
		cargo.setArord_stat_ind(rmcDriverCargo.getArord_stat_ind());
		cargo.setAriki_stat_ind(rmcDriverCargo.getAriki_stat_ind());
		cargo.setArhbt_stat_ind(rmcDriverCargo.getArhbt_stat_ind());
		cargo.setArbbq_stat_ind(rmcDriverCargo.getArbbq_stat_ind());
		cargo.setArccc_stat_ind(rmcDriverCargo.getArccc_stat_ind());
		cargo.setArcsc_stat_ind(rmcDriverCargo.getArcsc_stat_ind());
		cargo.setArmbb_stat_ind(rmcDriverCargo.getArmbb_stat_ind());
		cargo.setArbbs_stat_ind(rmcDriverCargo.getArbbs_stat_ind());
		cargo.setArcta_stat_ind(rmcDriverCargo.getArcta_stat_ind());
		cargo.setArcon_stat_ind(rmcDriverCargo.getArcon_stat_ind());
		cargo.setArafp_stat_ind(rmcDriverCargo.getArafp_stat_ind());
		cargo.setArmaa_stat_ind(rmcDriverCargo.getArmaa_stat_ind());
		cargo.setAripi_stat_ind(rmcDriverCargo.getAripi_stat_ind());
		cargo.setArdoc_stat_ind(rmcDriverCargo.getArdoc_stat_ind());
		cargo.setArarp_stat_ind(rmcDriverCargo.getArarp_stat_ind());
		cargo.setArfin_stat_ind(rmcDriverCargo.getArfin_stat_ind());
		cargo.setAridp_stat_ind(rmcDriverCargo.getAridp_stat_ind());
		cargo.setArbus_stat_ind(rmcDriverCargo.getArbus_stat_ind());
		cargo.setArhpa_stat_ind(rmcDriverCargo.getArhpa_stat_ind());
		cargo.setArlhi_stat_ind(rmcDriverCargo.getArlhi_stat_ind());
		cargo.setArbtt_stat_ind(rmcDriverCargo.getArbtt_stat_ind());
		cargo.setArbtd_stat_ind(rmcDriverCargo.getArbtd_stat_ind());
		cargo.setAritd_stat_ind(rmcDriverCargo.getAritd_stat_ind());
		cargo.setArhin_stat_ind(rmcDriverCargo.getArhin_stat_ind());
		cargo.setArohi_stat_ind(rmcDriverCargo.getArohi_stat_ind());
		cargo.setArtax_stat_ind(rmcDriverCargo.getArtax_stat_ind());
		cargo.setArpre_stat_ind(rmcDriverCargo.getArpre_stat_ind());
		cargo.setArrld_stat_ind(rmcDriverCargo.getArrld_stat_ind());
		cargo.setArcfn_stat_ind(rmcDriverCargo.getArcfn_stat_ind());

		return cargo;
	}

	/**
	 * Creates new APW driver
	 *
	 * @return PE_PREG_WMN_DRVR_Cargo
	 */
	private PE_PREG_WMN_DRVR_Cargo createNewAPWDriverCargo() {
		final PE_PREG_WMN_DRVR_Cargo cargo = new PE_PREG_WMN_DRVR_Cargo();
		cargo.setApwii_stat_ind(apwDriverCargo.getApwii_stat_ind());
		cargo.setApwci_stat_ind(apwDriverCargo.getApwci_stat_ind());
		cargo.setApwid_stat_ind(apwDriverCargo.getApwid_stat_ind());
		cargo.setApwps_stat_ind(apwDriverCargo.getApwps_stat_ind());
		cargo.setApwcs_stat_ind(apwDriverCargo.getApwcs_stat_ind());
		cargo.setAppwr_stat_ind(apwDriverCargo.getAppwr_stat_ind());

		return cargo;
	}

	/**
	 * Creates new APC driver
	 *
	 * @return PE_CHLD_DRVR_Cargo
	 */
	private PE_CHLD_DRVR_Cargo createNewAPCDriverCargo() {
		final PE_CHLD_DRVR_Cargo cargo = new PE_CHLD_DRVR_Cargo();
		cargo.setApcii_stat_ind(apcDriverCargo.getApcii_stat_ind());
		cargo.setApcci_stat_ind(apcDriverCargo.getApcci_stat_ind());
		cargo.setApcid_stat_ind(apcDriverCargo.getApcid_stat_ind());
		cargo.setApcps_stat_ind(apcDriverCargo.getApcps_stat_ind());
		cargo.setApccs_stat_ind(apcDriverCargo.getApccs_stat_ind());
		cargo.setApchr_stat_ind(apcDriverCargo.getApchr_stat_ind());

		return cargo;
	}


	/**
	 * Initializes AFB driver
	 */
	private void initializeAFBDriverCargo() {
		try {

			afbDriverCargo = new AFB_DRVR_Cargo();
			final int[] newDriver = (int[]) defaultDriverMap.get(FwConstants.AFB_DRIVER);
			final Map pageIdArrayIndex = lookUpThePageIdArrayIndexMap(FwConstants.AFB_DRIVER);
			afbDriverCargo.setAbapd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABAPD")))]));
			afbDriverCargo.setAbavd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABAVD")))]));
			afbDriverCargo.setAbbnr_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABBNR")))]));
			afbDriverCargo.setAbdcd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABDCD")))]));
			afbDriverCargo.setAbedt_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABEDT")))]));
			afbDriverCargo.setAbiki_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABIKI")))]));
			afbDriverCargo.setAbefd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABEFD")))]));
			afbDriverCargo.setAbesm_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABESM")))]));
			afbDriverCargo.setAbfas_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABFAS")))]));
			afbDriverCargo.setAbhdn_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABHDN")))]));
			afbDriverCargo.setAbdoc_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABDOC")))]));
			afbDriverCargo.setAbobq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABOBQ")))]));
			afbDriverCargo.setAbmdp_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABMDP")))]));
			afbDriverCargo.setAbhlt_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABHLT")))]));
			afbDriverCargo.setAbhsy_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABHSY")))]));
			afbDriverCargo.setAblhi_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABLHI")))]));
			afbDriverCargo.setAbhsc_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABHSC")))]));
			afbDriverCargo.setAbnhm_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABNHM")))]));
			afbDriverCargo.setAbobs_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABOBS")))]));
			afbDriverCargo.setAbheq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABHEQ")))]));
			afbDriverCargo.setAbhes_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABHES")))]));
			afbDriverCargo.setAbhhq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABHHQ")))]));
			afbDriverCargo.setAbcfn_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABCFN")))]));
			afbDriverCargo.setAbiki_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABIKI")))]));
			afbDriverCargo.setAbhhr_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABHHR")))]));
			afbDriverCargo.setAbhis_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABHIS")))]));
			afbDriverCargo.setAbhmd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABHMD")))]));
			afbDriverCargo.setAbshs_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABSHS")))]));
			afbDriverCargo.setAbspd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABSPD")))]));
			afbDriverCargo.setAbhel_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABHEL")))]));
			afbDriverCargo.setAbpng_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABPNG")))]));
			afbDriverCargo.setAbhng_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABHNG")))]));
			afbDriverCargo.setAbped_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABPED")))]));
			afbDriverCargo.setAbedr_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABEDR")))]));
			afbDriverCargo.setAbphd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABPHD")))]));
			afbDriverCargo.setAbhdr_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABHDR")))]));
			afbDriverCargo.setAbdfg_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABDFG")))]));
			afbDriverCargo.setAbfur_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABFUR")))]));
			afbDriverCargo.setAbpth_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABPTH")))]));
			afbDriverCargo.setAbsss_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABSSS")))]));
			afbDriverCargo.setAbstd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABSTD")))]));
			afbDriverCargo.setAbuad_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABUAD")))]));
			afbDriverCargo.setAbhms_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABHMS")))]));
			afbDriverCargo.setAbjiq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABJIQ")))]));
			afbDriverCargo.setAbjis_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABJIS")))]));
			afbDriverCargo.setAbmed_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABMED")))]));
			afbDriverCargo.setAbnsd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABNSD")))]));
			afbDriverCargo.setAbnso_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABNSO")))]));
			afbDriverCargo.setAboeq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABOEQ")))]));
			afbDriverCargo.setAboiq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABOIQ")))]));
			afbDriverCargo.setAbois_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABOIS")))]));
			afbDriverCargo.setAbpas_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABPAS")))]));
			afbDriverCargo.setAbpps_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABPPS")))]));
			afbDriverCargo.setAbpri_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABPRI")))]));
			afbDriverCargo.setAbpsq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABPSQ")))]));
			afbDriverCargo.setAbrgi_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABRGI")))]));
			afbDriverCargo.setAbrgs_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABRGS")))]));
			afbDriverCargo.setAbrlv_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABRLV")))]));
			afbDriverCargo.setAbscd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABSCD")))]));
			afbDriverCargo.setAbsct_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABSCT")))]));
			afbDriverCargo.setAbsed_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABSED")))]));
			afbDriverCargo.setAbsen_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABSEN")))]));
			afbDriverCargo.setAbucd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABUCD")))]));
			afbDriverCargo.setAbuct_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABUCT")))]));
			afbDriverCargo.setAbuid_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABUID")))]));
			afbDriverCargo.setAbuit_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABUIT")))]));
			afbDriverCargo.setAbprg_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABPRG")))]));
			afbDriverCargo.setAbbad_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABBAD")))]));
			afbDriverCargo.setAbbat_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABBAT")))]));
			afbDriverCargo.setAbdis_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABDIS")))]));
			afbDriverCargo.setAbhcd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABHCD")))]));
			afbDriverCargo.setAbind_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABIND")))]));
			afbDriverCargo.setAblad_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABLAD")))]));
			afbDriverCargo.setAblaq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABLAQ")))]));
			afbDriverCargo.setAblas_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABLAS")))]));
			afbDriverCargo.setAblat_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABLAT")))]));
			afbDriverCargo.setAblid_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABLID")))]));
			afbDriverCargo.setAblit_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABLIT")))]));
			afbDriverCargo.setAboaq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABOAQ")))]));
			afbDriverCargo.setAboas_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABOAS")))]));
			afbDriverCargo.setAbppd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABPPD")))]));
			afbDriverCargo.setAbrpd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABRPD")))]));
			afbDriverCargo.setAbrpt_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABRPT")))]));
			afbDriverCargo.setAbvad_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABVAD")))]));
			afbDriverCargo.setAbvat_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABVAT")))]));

			afbDriverCargo.setAbcon_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABCON")))]));

			afbDriverCargo.setAbhwa_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABHWA")))]));
			afbDriverCargo.setAbhca_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABHCA")))]));
			afbDriverCargo.setAbmet_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABMET")))]));
			afbDriverCargo.setAbmbd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABMBD")))]));
			afbDriverCargo.setAbmah_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABMAH")))]));

			// Start of VaCMS - Added for Deduction
			afbDriverCargo.setAbdty_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABDTY")))]));

			afbDriverCargo.setAbddt_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABDDT")))]));

			afbDriverCargo.setAbdsm_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABDSM")))]));
			// End of VaCMS - Added for Deduction

			// EDSP CP start Drug felony,current past pending assistance, child
			// past health insurance
			afbDriverCargo.setAbdsm_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABDFE")))]));
			afbDriverCargo.setAbcpa_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABCPA")))]));
			afbDriverCargo.setAbcph_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABCPH")))]));
			// EDSP CP end drug felony
			// EDSP CP start Crisis assistance, Cooling assistance, Fuel
			// assistance
			afbDriverCargo.setAbcra_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABCRA")))]));
			afbDriverCargo.setAbeca_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABECA")))]));
			afbDriverCargo.setAbefa_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABEFA")))]));
			afbDriverCargo.setAbsta_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABSTA")))]));
			afbDriverCargo.setAbshe_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABSHE")))]));
			// EDSP CP start Crisis assistance, Cooling assistance, Fuel
			// assistance, Shelter cost
			// EDSP CP SNAP Standard/Actual expense
			afbDriverCargo.setAbsae_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABSAE")))]));
			// EDSP CP end
			afbDriverCargo.setAbwre_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABWRE")))]));
			afbDriverCargo.setAbaur_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABAUR")))]));
			afbDriverCargo.setAbchs_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABCHS")))]));
			afbDriverCargo.setAbipi_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABIPI")))]));
			afbDriverCargo.setAbipq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABIPQ")))]));
			afbDriverCargo.setAbcrc_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABCRC")))]));
			afbDriverCargo.setAbhip_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABHIP")))]));
			afbDriverCargo.setAbort_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABORT")))]));
			afbDriverCargo.setAbord_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABORD")))]));
			afbDriverCargo.setAbtax_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABTAX")))]));
			afbDriverCargo.setAbitd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABITD")))]));
			afbDriverCargo.setAbbtx_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABBTX")))]));
			afbDriverCargo.setAbbtd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABBTD")))]));
			afbDriverCargo.setAbehi_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABEHI")))]));
			afbDriverCargo.setAbhin_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABHIN")))]));
			afbDriverCargo.setAbohi_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABOHI")))]));
			afbDriverCargo.setAbtxr_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABTXR")))]));
			afbDriverCargo.setAbtxi_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABTXI")))]));
			afbDriverCargo.setAbbcn_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABBCN")))]));
			afbDriverCargo.setAbhbq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABHBQ")))]));
			afbDriverCargo.setAbhbd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ABHBD")))]));

			return;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("initializeAFBDriverCargo");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	/**
	 * Initializes RMC driver
	 */
	private void initializeRMCDriverCargo() {
		try {

			rmcDriverCargo = new RMC_DRVR_Cargo();
			final int[] newDriver = (int[]) defaultDriverMap.get(FwConstants.RMC_DRIVER);
			Map pageIdArrayIndex = lookUpThePageIdArrayIndexMap(FwConstants.RMC_DRIVER);
			// Justin EDSP March 3rd 2012
			// Create anonymous subclass of Map and override "get"
			// to return a String representation of the integer zero
			// instead of null if the key is not found.
			final Map safePageIdArrayIndex = new HashMap() {
				/**
				 *
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public Object get(final Object key) {
					final Object o = super.get(key);
					if (o == null) {
						log(ILog.INFO, ">>>>>> initializeRMCDriverCargo >>>>  'Zero' substituted for null for key " + key);
					}
					return o != null ? o : "0";
				}
			};
			safePageIdArrayIndex.putAll(pageIdArrayIndex);
			pageIdArrayIndex = safePageIdArrayIndex;
			log(ILog.INFO, ">>>>>> initializeRMCDriverCargo >>>>  missing pageID's will be initialized to zero  instead of null ::  "
					+ pageIdArrayIndex.get("MissingPageID"));
			rmcDriverCargo.setArcat_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARCAT")))]));
			rmcDriverCargo.setArhis_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHIS")))]));
			rmcDriverCargo.setArpgq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARPGQ")))]));
			rmcDriverCargo.setArpiq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARPIQ")))]));
			rmcDriverCargo.setArpcs_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARPCS")))]));
			rmcDriverCargo.setAracd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARACD")))]));
			rmcDriverCargo.setAravd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARAVD")))]));
			rmcDriverCargo.setArhod_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHOD")))]));
			rmcDriverCargo.setArhmo_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHMO")))]));
			rmcDriverCargo.setArhde_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHDE")))]));
			rmcDriverCargo.setArhma_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHMA")))]));
			rmcDriverCargo.setHshmo_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("HSHMO")))]));
			rmcDriverCargo.setHsher_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("HSHER")))]));
			rmcDriverCargo.setHscso_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("HSCSO")))]));
			rmcDriverCargo.setArhmi_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHMI")))]));
			rmcDriverCargo.setArhrl_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHRL")))]));
			rmcDriverCargo.setArapa_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARAPA")))]));
			rmcDriverCargo.setArplr_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARPLR")))]));
			rmcDriverCargo.setArhpg_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHPG")))]));
			rmcDriverCargo.setArhmd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHMD")))]));
			rmcDriverCargo.setArhap_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHAP")))]));
			rmcDriverCargo.setArdgp_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARDGP")))]));
			rmcDriverCargo.setArhdd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHDD")))]));
			rmcDriverCargo.setArhpd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHPD")))]));
			rmcDriverCargo.setArdfd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARDFD")))]));
			rmcDriverCargo.setArhcs_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHCS")))]));
			rmcDriverCargo.setArhca_stat_ind(String.valueOf("0"));
			rmcDriverCargo.setArobq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("AROBQ")))]));
			rmcDriverCargo.setArobi_stat_ind("0");
			rmcDriverCargo.setArobc_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("AROBC")))]));
			rmcDriverCargo.setArhse_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHSE")))]));
			rmcDriverCargo.setArhcd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHCD")))]));
			rmcDriverCargo.setArpcd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("0")))]));
			rmcDriverCargo.setArmap_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARMAP")))]));
			rmcDriverCargo.setArobs_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("AROBS")))]));
			rmcDriverCargo.setAragq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARAGQ")))]));
			rmcDriverCargo.setAraiq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARAIQ")))]));
			rmcDriverCargo.setAracs_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARACS")))]));
			rmcDriverCargo.setArlat_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARLAT")))]));
			rmcDriverCargo.setArlad_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARLAD")))]));
			rmcDriverCargo.setArvat_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARVAT")))]));
			rmcDriverCargo.setArvad_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARVAD")))]));
			rmcDriverCargo.setArrpt_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARRPT")))]));
			rmcDriverCargo.setArrpd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARRPD")))]));
			rmcDriverCargo.setArppd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARPPD")))]));
			rmcDriverCargo.setArbat_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARBAT")))]));
			rmcDriverCargo.setArbad_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARBAD")))]));
			rmcDriverCargo.setArlit_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARLIT")))]));
			rmcDriverCargo.setArlid_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARLID")))]));
			rmcDriverCargo.setArasm_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARASM")))]));
			rmcDriverCargo.setArjgq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARJGQ")))]));
			rmcDriverCargo.setArjse_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARJSE")))]));
			rmcDriverCargo.setArjid_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARJID")))]));
			rmcDriverCargo.setArehi_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("AREHI")))]));
			rmcDriverCargo.setArjsd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARJSD")))]));
			rmcDriverCargo.setArjis_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARJIS")))]));
			rmcDriverCargo.setAroiq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("AROIQ")))]));
			rmcDriverCargo.setAruii_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARUII")))]));
			rmcDriverCargo.setAruit_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARUIT")))]));
			rmcDriverCargo.setAruid_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARUID")))]));
			rmcDriverCargo.setArrbi_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARRBI")))]));
			rmcDriverCargo.setAruis_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARUIS")))]));
			rmcDriverCargo.setArxgq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARXGQ")))]));
			rmcDriverCargo.setArxiq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARXIQ")))]));
			rmcDriverCargo.setArxhu_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARXHU")))]));
			rmcDriverCargo.setArxhi_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARXHI")))]));
			rmcDriverCargo.setArxhd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARXHD")))]));
			rmcDriverCargo.setArxud_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARXUD")))]));
			rmcDriverCargo.setArrbe_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARRBE")))]));
			rmcDriverCargo.setArdcd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARDCD")))]));
			rmcDriverCargo.setArsod_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARSOD")))]));
			rmcDriverCargo.setAriwe_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARIWE")))]));
			rmcDriverCargo.setArmbd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARMBD")))]));
			rmcDriverCargo.setArxhs_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARXHS")))]));
			rmcDriverCargo.setArper_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARPER")))]));
			rmcDriverCargo.setArfas_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARFAS")))]));
			rmcDriverCargo.setArprs_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARPRS")))]));
			rmcDriverCargo.setArtky_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARTKY")))]));
			rmcDriverCargo.setArhoh_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHOH")))]));
			rmcDriverCargo.setAroaq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("AROAQ")))]));
			rmcDriverCargo.setAroac_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("AROAC")))]));
			rmcDriverCargo.setAroas_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("AROAS")))]));
			rmcDriverCargo.setArxfr_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARXFR")))]));
			rmcDriverCargo.setArxfr_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARXFR")))]));
			rmcDriverCargo.setArsum_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARSUM")))]));
			rmcDriverCargo.setArhmx_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHMX")))]));
			rmcDriverCargo.setArmed_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARMED")))]));
			rmcDriverCargo.setArhps_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHPS")))]));
			rmcDriverCargo.setArhos_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHOS")))]));
			rmcDriverCargo.setArnur_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARNUR")))]));
			rmcDriverCargo.setArofs_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("AROFS")))]));
			rmcDriverCargo.setArort_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARORT")))]));
			rmcDriverCargo.setArord_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARORD")))]));
			rmcDriverCargo.setAriki_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARIKI")))]));
			rmcDriverCargo.setArhbt_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHBT")))]));
			rmcDriverCargo.setArbbq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARBBQ")))]));
			rmcDriverCargo.setArccc_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARCCC")))]));
			rmcDriverCargo.setArcsc_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARCSC")))]));
			rmcDriverCargo.setArmbb_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARMBB")))]));
			rmcDriverCargo.setArbbs_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARBBS")))]));
			rmcDriverCargo.setArcta_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARCTA")))]));
			rmcDriverCargo.setArcon_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARCON")))]));
			rmcDriverCargo.setArafp_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARAFP")))]));
			rmcDriverCargo.setArmaa_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARMAA")))]));
			rmcDriverCargo.setAripi_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARIPI")))]));
			rmcDriverCargo.setArdoc_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARDOC")))]));
			rmcDriverCargo.setArarp_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARARP")))]));
			rmcDriverCargo.setArfin_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARFIN")))]));
			rmcDriverCargo.setAridp_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARIDP")))]));
			rmcDriverCargo.setArbus_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARBUS")))]));
			rmcDriverCargo.setArhpa_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHPA")))]));
			rmcDriverCargo.setArlhi_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARLHI")))]));
			rmcDriverCargo.setAritd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARITD")))]));
			rmcDriverCargo.setArbtt_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARBTT")))]));
			rmcDriverCargo.setArbtd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARBTD")))]));
			rmcDriverCargo.setArhin_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHIN")))]));
			rmcDriverCargo.setArohi_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("AROHI")))]));
			rmcDriverCargo.setArtax_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARTAX")))]));
			rmcDriverCargo.setArpre_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARPRE")))]));
			rmcDriverCargo.setArrld_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARRLD")))]));
			rmcDriverCargo.setArcfn_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARCFN")))]));
			rmcDriverCargo.setArbcn_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARBCN")))]));

			return;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("initializeRMCDriverCargo");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	/**
	 * Initializes RMC driver
	 */
	private void initializeRMBDriverCargo() {
		try {

			rmcDriverCargo = new RMC_DRVR_Cargo();
			final int[] newDriver = (int[]) defaultDriverMap.get(FwConstants.RMC_DRIVER);
			Map pageIdArrayIndex = lookUpThePageIdArrayIndexMap(FwConstants.RMC_DRIVER);
			// Justin EDSP March 3rd 2012
			// Create anonymous subclass of Map and override "get"
			// to return a String representation of the integer zero
			// instead of null if the key is not found.
			final Map safePageIdArrayIndex = new HashMap() {
				/**
				 *
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public Object get(final Object key) {
					final Object o = super.get(key);
					if (o == null) {
						log(ILog.INFO, ">>>>>> initializeRMCDriverCargo >>>>  'Zero' substituted for null for key " + key);
					}
					return o != null ? o : "0";
				}
			};
			safePageIdArrayIndex.putAll(pageIdArrayIndex);
			pageIdArrayIndex = safePageIdArrayIndex;
			log(ILog.INFO, ">>>>>> initializeRMCDriverCargo >>>>  missing pageID's will be initialized to zero  instead of null ::  "
					+ pageIdArrayIndex.get("MissingPageID"));
			rmcDriverCargo.setArcat_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARCAT")))]));
			rmcDriverCargo.setArhis_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHIS")))]));
			rmcDriverCargo.setArpgq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARPGQ")))]));
			rmcDriverCargo.setArpiq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARPIQ")))]));
			rmcDriverCargo.setArpcs_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARPCS")))]));
			rmcDriverCargo.setAracd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARACD")))]));
			rmcDriverCargo.setAravd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARAVD")))]));
			rmcDriverCargo.setArhod_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHOD")))]));
			rmcDriverCargo.setArhmo_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHMO")))]));
			rmcDriverCargo.setArhde_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHDE")))]));
			rmcDriverCargo.setArhma_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHMA")))]));
			rmcDriverCargo.setHshmo_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("HSHMO")))]));
			rmcDriverCargo.setHsher_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("HSHER")))]));
			rmcDriverCargo.setHscso_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("HSCSO")))]));
			rmcDriverCargo.setArhmi_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHMI")))]));
			rmcDriverCargo.setArhrl_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHRL")))]));
			rmcDriverCargo.setArapa_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARAPA")))]));
			rmcDriverCargo.setArplr_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARPLR")))]));
			rmcDriverCargo.setArhpg_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHPG")))]));
			rmcDriverCargo.setArhmd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHMD")))]));
			rmcDriverCargo.setArhap_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHAP")))]));
			rmcDriverCargo.setArdgp_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARDGP")))]));
			rmcDriverCargo.setArhdd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHDD")))]));
			rmcDriverCargo.setArhpd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHPD")))]));
			rmcDriverCargo.setArdfd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARDFD")))]));
			rmcDriverCargo.setArhcs_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHCS")))]));
			rmcDriverCargo.setArhca_stat_ind(String.valueOf("0"));
			rmcDriverCargo.setArobq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("AROBQ")))]));
			rmcDriverCargo.setArobi_stat_ind("0");
			rmcDriverCargo.setArobc_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("AROBC")))]));
			rmcDriverCargo.setArhse_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHSE")))]));
			rmcDriverCargo.setArhcd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHCD")))]));
			rmcDriverCargo.setArpcd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("0")))]));
			rmcDriverCargo.setArmap_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARMAP")))]));
			rmcDriverCargo.setArobs_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("AROBS")))]));
			rmcDriverCargo.setAragq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARAGQ")))]));
			rmcDriverCargo.setAraiq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARAIQ")))]));
			rmcDriverCargo.setAracs_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARACS")))]));
			rmcDriverCargo.setArlat_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARLAT")))]));
			rmcDriverCargo.setArlad_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARLAD")))]));
			rmcDriverCargo.setArvat_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARVAT")))]));
			rmcDriverCargo.setArvad_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARVAD")))]));
			rmcDriverCargo.setArrpt_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARRPT")))]));
			rmcDriverCargo.setArrpd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARRPD")))]));
			rmcDriverCargo.setArppd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARPPD")))]));
			rmcDriverCargo.setArbat_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARBAT")))]));
			rmcDriverCargo.setArbad_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARBAD")))]));
			rmcDriverCargo.setArlit_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARLIT")))]));
			rmcDriverCargo.setArlid_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARLID")))]));
			rmcDriverCargo.setArasm_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARASM")))]));
			rmcDriverCargo.setArjgq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARJGQ")))]));
			rmcDriverCargo.setArjse_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARJSE")))]));
			rmcDriverCargo.setArjid_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARJID")))]));
			rmcDriverCargo.setArehi_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("AREHI")))]));
			rmcDriverCargo.setArjsd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARJSD")))]));
			rmcDriverCargo.setArjis_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARJIS")))]));
			rmcDriverCargo.setAroiq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("AROIQ")))]));
			rmcDriverCargo.setAruii_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARUII")))]));
			rmcDriverCargo.setAruit_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARUIT")))]));
			rmcDriverCargo.setAruid_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARUID")))]));
			rmcDriverCargo.setArrbi_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARRBI")))]));
			rmcDriverCargo.setAruis_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARUIS")))]));
			rmcDriverCargo.setArxgq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARXGQ")))]));
			rmcDriverCargo.setArxiq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARXIQ")))]));
			rmcDriverCargo.setArxhu_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARXHU")))]));
			rmcDriverCargo.setArxhi_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARXHI")))]));
			rmcDriverCargo.setArxhd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARXHD")))]));
			rmcDriverCargo.setArxud_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARXUD")))]));
			rmcDriverCargo.setArrbe_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARRBE")))]));
			rmcDriverCargo.setArdcd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARDCD")))]));
			rmcDriverCargo.setArsod_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARSOD")))]));
			rmcDriverCargo.setAriwe_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARIWE")))]));
			rmcDriverCargo.setArmbd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARMBD")))]));
			rmcDriverCargo.setArxhs_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARXHS")))]));
			rmcDriverCargo.setArper_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARPER")))]));
			rmcDriverCargo.setArfas_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARFAS")))]));
			rmcDriverCargo.setArprs_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARPRS")))]));
			rmcDriverCargo.setArtky_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARTKY")))]));
			rmcDriverCargo.setArhoh_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHOH")))]));
			rmcDriverCargo.setAroaq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("AROAQ")))]));
			rmcDriverCargo.setAroac_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("AROAC")))]));
			rmcDriverCargo.setAroas_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("AROAS")))]));
			rmcDriverCargo.setArxfr_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARXFR")))]));
			rmcDriverCargo.setArxfr_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARXFR")))]));
			rmcDriverCargo.setArsum_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARSUM")))]));
			rmcDriverCargo.setArhmx_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHMX")))]));
			rmcDriverCargo.setArmed_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARMED")))]));
			rmcDriverCargo.setArhps_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHPS")))]));
			rmcDriverCargo.setArhos_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHOS")))]));
			rmcDriverCargo.setArnur_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARNUR")))]));
			rmcDriverCargo.setArofs_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("AROFS")))]));
			rmcDriverCargo.setArort_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARORT")))]));
			rmcDriverCargo.setArord_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARORD")))]));
			rmcDriverCargo.setAriki_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARIKI")))]));
			rmcDriverCargo.setArhbt_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHBT")))]));
			rmcDriverCargo.setArbbq_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARBBQ")))]));
			rmcDriverCargo.setArccc_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARCCC")))]));
			rmcDriverCargo.setArcsc_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARCSC")))]));
			rmcDriverCargo.setArmbb_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARMBB")))]));
			rmcDriverCargo.setArbbs_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARBBS")))]));
			rmcDriverCargo.setArcta_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARCTA")))]));
			rmcDriverCargo.setArcon_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARCON")))]));
			rmcDriverCargo.setArafp_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARAFP")))]));
			rmcDriverCargo.setArmaa_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARMAA")))]));
			rmcDriverCargo.setAripi_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARIPI")))]));
			rmcDriverCargo.setArdoc_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARDOC")))]));
			rmcDriverCargo.setArarp_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARARP")))]));
			rmcDriverCargo.setArfin_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARFIN")))]));
			rmcDriverCargo.setAridp_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARIDP")))]));
			rmcDriverCargo.setArbus_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARBUS")))]));
			rmcDriverCargo.setArhpa_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHPA")))]));
			rmcDriverCargo.setArlhi_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARLHI")))]));
			rmcDriverCargo.setAritd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARITD")))]));
			rmcDriverCargo.setArbtt_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARBTT")))]));
			rmcDriverCargo.setArbtd_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARBTD")))]));
			rmcDriverCargo.setArhin_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARHIN")))]));
			rmcDriverCargo.setArohi_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("AROHI")))]));
			rmcDriverCargo.setArtax_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARTAX")))]));
			rmcDriverCargo.setArpre_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARPRE")))]));
			rmcDriverCargo.setArrld_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARRLD")))]));
			rmcDriverCargo.setArcfn_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARCFN")))]));
			rmcDriverCargo.setArbcn_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("ARBCN")))]));
			return;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("initializeRMCDriverCargo");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	/**
	 * Initializes APW driver
	 */
	private void initializeAPWDriverCargo() {
		try {

			apwDriverCargo = new PE_PREG_WMN_DRVR_Cargo();
			final int[] newDriver = (int[]) defaultDriverMap.get(FwConstants.APP_PW_DRIVER);
			final Map pageIdArrayIndex = lookUpThePageIdArrayIndexMap(FwConstants.APP_PW_DRIVER);
			apwDriverCargo.setApwii_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("APWII")))]));
			apwDriverCargo.setApwci_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("APWCI")))]));
			apwDriverCargo.setApwid_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("APWID")))]));
			apwDriverCargo.setApwps_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("APWPS")))]));
			apwDriverCargo.setApwcs_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("APWCS")))]));
			apwDriverCargo.setAppwr_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("APPWR")))]));

			return;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("initializeAPWDriverCargo");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	/**
	 * Initializes APC driver
	 */
	private void initializeAPCDriverCargo() {
		try {

			apcDriverCargo = new PE_CHLD_DRVR_Cargo();
			final int[] newDriver = (int[]) defaultDriverMap.get(FwConstants.APP_CH_DRIVER);
			final Map pageIdArrayIndex = lookUpThePageIdArrayIndexMap(FwConstants.APP_CH_DRIVER);
			apcDriverCargo.setApcii_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("APCII")))]));
			apcDriverCargo.setApcci_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("APCCI")))]));
			apcDriverCargo.setApcid_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("APCID")))]));
			apcDriverCargo.setApcps_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("APCPS")))]));
			apcDriverCargo.setApccs_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("APCCS")))]));
			apcDriverCargo.setApchr_stat_ind(String.valueOf(newDriver[Integer.parseInt(String.valueOf(pageIdArrayIndex.get("APCHR")))]));

			return;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("initializeAPCDriverCargo");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

}