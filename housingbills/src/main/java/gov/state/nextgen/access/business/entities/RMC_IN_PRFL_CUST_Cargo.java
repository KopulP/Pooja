/*
 * 
 */
package gov.state.nextgen.access.business.entities;

import gov.state.nextgen.access.management.util.FWUtils;
import gov.state.nextgen.access.management.util.FwDataCriteria;

/**
 * This java bean contains the entities of APP_IN_PRFL
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date Tue Oct 24 09:28:08 CDT 2006 Modified By: Modified on: PCR#
 */
public class RMC_IN_PRFL_CUST_Cargo extends AbstractCargo implements java.io.Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.access.business.customEntities.RMC_IN_PRFL_CUST";
	FwDataCriteria[] dataCriteria;
	FwDataCriteria[] whereCriteria;

	/**
	 * Returns the package name.
	 *
	 * Creation Date Thu Aug 2 3:35:04 CST 2007
	 * @return
	 *         gov.state.nextgen.access.business.customEntities.RMC_IN_PRFL_CUST_Cargo
	 */
	public String getPackage() {
		return PACKAGE;
	}

	/**
	 * returns the PrimaryKey object.
	 */
	@Override
	public IPrimaryKey getPrimaryKey() {
		return null;
	}

	/**
	 * returns the string value of cargo.
	 */
	@Override
	public String inspectCargo() {
		return new StringBuilder().append("RMC_IN_PRFL_CUST: ").append("dataCriteria=").append(dataCriteria).append("whereCriteria=")
				.append(whereCriteria).toString();
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public FwDataCriteria[] getDataCriteria() {
		return dataCriteria;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public FwDataCriteria[] getWhereCriteria() {
		return whereCriteria;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public void setDataCriteria(final FwDataCriteria[] criterias) {
		dataCriteria = FWUtils.arrayCopy(criterias);
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public void setWhereCriteria(final FwDataCriteria[] criterias) {
		whereCriteria = FWUtils.arrayCopy(criterias);
	}

}