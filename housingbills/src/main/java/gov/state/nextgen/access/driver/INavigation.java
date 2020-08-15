/*
 * Created on Jun 16, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package gov.state.nextgen.access.driver;

import gov.state.nextgen.access.business.entities.FwTransaction;
import gov.state.nextgen.access.exceptions.FwException;

/**
 * Enter the description of the class
 *
 * @author addepup
 * Creation Date Jun 16, 2004 Modified By: Modified on: PCR#
 */
public interface INavigation {

	/**
	 * @param responseMap
	 * @return Map
	 */
	public void navigate(FwTransaction txnBean) throws FwException;

	public void determineResponse(String currentPageId, int[] driverArray, FwTransaction txnBean);

	public void invokeClass(String className, String methodName, FwTransaction txnBean);
}
