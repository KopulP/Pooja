/*
 * 
 */
package gov.state.nextgen.access.driver.business.entities;

import gov.state.nextgen.access.business.entities.IPrimaryKey;

/**
 * This java bean contains the primary keys for the table PE_PREG_WMN_DRVR
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date Thu Jul 26 15:19:25 CDT 2007 Modified By: Modified on: PCR#
 */
public class PE_PREG_WMN_DRVR_PrimaryKey implements java.io.Serializable, IPrimaryKey {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String app_num;

	/**
	 * returns the app_num value.
	 */
	public String getApp_num() {
		return app_num;
	}

	/**
	 * sets the app_num value.
	 */
	public void setApp_num(final String app_num) {
		this.app_num = app_num;
	}

	/**
	 * returns the string value of cargo.
	 */
	@Override
	public String inspectPrimaryKey() {
		return new StringBuilder().append("PE_PREG_WMN_DRVR: ").append("app_num=").append(app_num).toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((app_num == null) ? 0 : app_num.trim().hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final PE_PREG_WMN_DRVR_PrimaryKey other = (PE_PREG_WMN_DRVR_PrimaryKey) obj;
		if (app_num == null) {
			if (other.app_num != null) {
				return false;
			}
		} else if (!app_num.equals(other.app_num)) {
			return false;
		}
		return true;
	}

}