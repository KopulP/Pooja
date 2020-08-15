/*
 * 
 */
package gov.state.nextgen.access.business.validations;

import java.util.List;

import gov.state.nextgen.access.business.entities.FwTransaction;

/**
 * Interface for Rules Manager
 *
 * @author Architecture Team Creation Date Oct 26, 2005 Modified By: Modified
 *         on: PCR#
 */
public interface IRules {

	String RULE_ID = "RULE_ID";
	String CPNT_ID = "CPNT_ID";
	String SUB_CPNT_ID = "SUB_CPNT_ID";
	String COND_IND = "COND_IND";
	String CLS_NAM = "CLS_NAM";
	String MTHD_NAM = "MTHD_NAM";

	/**
	 * updates(removes)the componentIDs List after applying rules logic (removes
	 * zero or more component ids)
	 */
	public void runRulesForComponents(List aComponentIDs, FwTransaction aTxnBean);
}
