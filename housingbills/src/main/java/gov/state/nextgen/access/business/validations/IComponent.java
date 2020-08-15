/*
 * 
 */
package gov.state.nextgen.access.business.validations;

import java.util.List;

import gov.state.nextgen.access.business.entities.FwTransaction;

/**
 * Interface for Component Manager
 *
 * @author Architecture Team Creation Date Oct 26, 2005 Modified By: Modified
 *         on: PCR#
 */
public interface IComponent {

	String PAGE_ID = "PAGE_ID";
	String CPNT_ID = "CPNT_ID";
	String MA_IND = "MA_IND";
	String FPW_IND = "FPW_IND";
	String FS_IND = "FS_IND";
	String FS_RR_IND = "FS_RR_IND";
	String MA_EBD_IND = "MA_EBD_IND";
	String CTS_IND = "CTS_IND";
	String SC_IND = "SC_IND";
	String SER_IND = "SER_IND";
	String CC_IND = "CC_IND";
	String TANF_IND = "TANF_IND";
	String COOLING_ASSISTANCE_IND = "COOLING_ASSISTANCE_IND";
	String CRISIS_ASSISTANCE_IND = "CRISIS_ASSISTANCE_IND";
	String FUEL_ASSISTANCE_IND = "FUEL_ASSISTANCE_IND";
	String NO_SNAP_IND = "NO_SNAP_IND";
	String WIC_RQST_IND = "WIC_RQST_IND";
	String LIHEAP_RQST_IND = "LIHEAP_RQST_IND";
	String MAGI_RQST_IND = "MAGI_RQST_IND";
	String PEACH_RQST_IND = "PEACH_RQST_IND";

	/**
	 * returns a list if componentIds for the given pagId
	 *
	 * @param aPageID
	 * @param aTxnBean
	 *
	 */
	public void getComponents(String aPageID, FwTransaction aTxnBean);
	
	/**
	 * returns a list if componentIds for the given pagId
	 *
	 * @param aPageID
	 * @param aTxnBean
	 *
	 */
	public List getComponentsList(final String aPageID, final FwTransaction aTxnBean);

}
