/*
 * 
 */
package gov.state.nextgen.access.driver;

/**
 * Driver Manager Interface.
 *
 * @author Narasimham Konakanchi
 * Creation Date Apr 16, 2004 Modified By: Anand B. Mehthods added for AFB
 *           Driver. Modified on: 11/30/2005 PCR#
 */
public interface IDriver {

	int DRIVER_INDEX_NOT_REQUIRED = 0;
	int DRIVER_INDEX_REQUIRED = 1;
	int DRIVER_INDEX_VISIT_AGAIN = 2;
	int DRIVER_INDEX_PENDING = 3;
	int DRIVER_INDEX_COMPLETE = 4;
	int DRIVER_INDEX_ADD_NEW = 5;

	String DRIVER_STATUS_NOT_REQUIRED = "N";
	String DRIVER_STATUS_REQUIRED = "R";
	String DRIVER_STATUS_VISIT_AGAIN = "V";
	String DRIVER_STATUS_PENDING = "P";
	String DRIVER_STATUS_COMPLETE = "C";
	String DRIVER_STATUS_ADD_NEW = "A";

	public int[] loadDefaultDriver(String driverId);

	/**
	 * updates the driver to set the required indicator for the given pageId
	 */
	public void makeRequired(String driverId, String pageId, int[] driver);

	/**
	 * updates the driver and driver table to set the required indicator for the
	 * given pageId
	 */
	public void makeRequired(String driverId, String pageId, int[] driver, String appNum);

	/**
	 * updates the driver to remove the required indicator for the given pageId
	 */
	public void makeNotRequired(String driverId, String pageId, int[] driver);

	/**
	 * updates the driver and driver table to remove the required indicator for
	 * the given pageId
	 */
	public void makeNotRequired(String driverId, String pageId, int[] driver, String appNum);

	/**
	 * updates the driver to set the complete indicator for the given pageId
	 */
	public void makeComplete(String driverId, String pageId, int[] driver);

	/**
	 * updates the driver and driver table to set the complete indicator for the
	 * given pageId
	 */
	public void makeComplete(String driverId, String pageId, int[] driver, String appNum);

	/**
	 * updates the driver to set the required indicator for the given pageId's
	 */
	public void makeRequired(String driverId, String[] pageIds, int[] driver);

	/**
	 * updates the driver and driver table to set the required indicator for the
	 * given pageId's
	 */
	public void makeRequired(String driverId, String[] pageIds, int[] driver, String appNum);

	/**
	 * updates the driver to remove the required indicator for the given
	 * pageId's
	 */
	public void makeNotRequired(String driverId, String[] pageIds, int[] driver);

	/**
	 * updates the driver and driver table to remove the required indicator for
	 * the given pageId's
	 */
	public void makeNotRequired(String driverId, String[] pageIds, int[] driver, String appNum);

	/**
	 * updates the driver to set the complete indicator for the given pageId's
	 */
	public void makeComplete(String driverId, String[] pageIds, int[] driver);

	/**
	 * updates the driver and driver table to set the complete indicator for the
	 * given pageId's
	 */
	public void makeComplete(String driverId, String[] pageIds, int[] driver, String appNum);

	/**
	 * updates the driver to set the addNew indicator for the given pageId
	 */
	public void makeAddNew(String driverId, String pageId, int[] driver);

	/**
	 * updates the driver and driver table to set the addNew indicator for the
	 * given pageId
	 */
	public void makeAddNew(String driverId, String pageId, int[] driver, String appNum);

	/**
	 * updates the driver to set the AddNew indicator for the given pageId's
	 */
	public void makeAddNew(String driverId, String[] pageIds, int[] driver);

	/**
	 * updates the driver and driver table to set the AddNew indicator for the
	 * given pageId's
	 */
	public void makeAddNew(String driverId, String[] pageIds, int[] driver, String appNum);

	/**
	 * updates the driver to set the not_required indicator for the given
	 * pageId's
	 */
	public void makeAbsoluteNotRequired(String driverId, String[] pageIds, int[] driver);

	/**
	 * updates the driver and driver table to set the not_required indicator for
	 * the given pageId's
	 */
	public void makeAbsoluteNotRequired(String driverId, String[] pageIds, int[] driver, String appNum);

	/**
	 * updates the driver and driver table to set the not_required indicator for
	 * the given pageId
	 */
	public void makeAbsoluteNotRequired(String driverId, String pageId, int[] driver, String appNum);

	/**
	 * updates the driver and driver table to set the not_required indicator for
	 * the given pageId
	 */
	public void makeAbsoluteNotRequired(String driverId, String pageId, int[] driver);

	public String getStatus(String driverId, String pageId, int[] driver);

	public int getAFBStatus(String driverId, String pageId, int[] driver);

	public int getAPWStatus(String driverId, String pageId, int[] driver);

	public int getAPCStatus(String driverId, String pageId, int[] driver);

	public int getAHNStatus(String driverId, String pageId, int[] driver);

	public void reassessDriver(String driverId, String currentPageId, int[] driver);

	public int[] createDefaultDriver(String driverId, String appNumber);

	public int[] loadDriver(String driverId, String aAppNum);

	public String getPageId(String driverId, int index);

}
