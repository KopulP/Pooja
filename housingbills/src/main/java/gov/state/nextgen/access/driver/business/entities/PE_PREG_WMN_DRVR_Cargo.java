/*
 * 
 */
package gov.state.nextgen.access.driver.business.entities;

import java.util.HashMap;
import java.util.Map;

import gov.state.nextgen.access.business.entities.AbstractCargo;
import gov.state.nextgen.access.business.entities.IPrimaryKey;
import gov.state.nextgen.access.management.util.FWUtils;
import gov.state.nextgen.access.management.util.FwDataCriteria;

/**
 * This java bean contains the entities of PE_PREG_WMN_DRVR
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date Thu Jul 26 15:19:25 CDT 2007 Modified By: Modified on: PCR#
 */
@SuppressWarnings("serial")
public class PE_PREG_WMN_DRVR_Cargo extends AbstractCargo implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	boolean isDirty = false;
	private String app_num;
	private String appwr_stat_ind;
	private String apwci_stat_ind;
	private String apwcs_stat_ind;
	private String apwid_stat_ind;
	private String apwii_stat_ind;
	private String apwps_stat_ind;
	FwDataCriteria[] dataCriteria;
	FwDataCriteria[] whereCriteria;

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
	 * returns the appwr_stat_ind value.
	 */
	public String getAppwr_stat_ind() {
		return appwr_stat_ind;
	}

	/**
	 * sets the appwr_stat_ind value.
	 */
	public void setAppwr_stat_ind(final String appwr_stat_ind) {
		this.appwr_stat_ind = appwr_stat_ind;
	}

	/**
	 * returns the apwci_stat_ind value.
	 */
	public String getApwci_stat_ind() {
		return apwci_stat_ind;
	}

	/**
	 * sets the apwci_stat_ind value.
	 */
	public void setApwci_stat_ind(final String apwci_stat_ind) {
		this.apwci_stat_ind = apwci_stat_ind;
	}

	/**
	 * returns the apwcs_stat_ind value.
	 */
	public String getApwcs_stat_ind() {
		return apwcs_stat_ind;
	}

	/**
	 * sets the apwcs_stat_ind value.
	 */
	public void setApwcs_stat_ind(final String apwcs_stat_ind) {
		this.apwcs_stat_ind = apwcs_stat_ind;
	}

	/**
	 * returns the apwid_stat_ind value.
	 */
	public String getApwid_stat_ind() {
		return apwid_stat_ind;
	}

	/**
	 * sets the apwid_stat_ind value.
	 */
	public void setApwid_stat_ind(final String apwid_stat_ind) {
		this.apwid_stat_ind = apwid_stat_ind;
	}

	/**
	 * returns the apwii_stat_ind value.
	 */
	public String getApwii_stat_ind() {
		return apwii_stat_ind;
	}

	/**
	 * sets the apwii_stat_ind value.
	 */
	public void setApwii_stat_ind(final String apwii_stat_ind) {
		this.apwii_stat_ind = apwii_stat_ind;
	}

	/**
	 * returns the apwps_stat_ind value.
	 */
	public String getApwps_stat_ind() {
		return apwps_stat_ind;
	}

	/**
	 * sets the apwps_stat_ind value.
	 */
	public void setApwps_stat_ind(final String apwps_stat_ind) {
		this.apwps_stat_ind = apwps_stat_ind;
	}

	/**
	 * returns the string value of cargo.
	 */
	@Override
	public String inspectCargo() {
		return new StringBuilder().append("PE_PREG_WMN_DRVR: ").append("app_num=").append(app_num).append("appwr_stat_ind=").append(appwr_stat_ind)
				.append("apwci_stat_ind=").append(apwci_stat_ind).append("apwcs_stat_ind=").append(apwcs_stat_ind).append("apwid_stat_ind=")
				.append(apwid_stat_ind).append("apwii_stat_ind=").append(apwii_stat_ind).append("apwps_stat_ind=").append(apwps_stat_ind).toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((app_num == null) ? 0 : app_num.trim().hashCode());
		result = (prime * result) + ((appwr_stat_ind == null) ? 0 : appwr_stat_ind.trim().hashCode());
		result = (prime * result) + ((apwci_stat_ind == null) ? 0 : apwci_stat_ind.trim().hashCode());
		result = (prime * result) + ((apwcs_stat_ind == null) ? 0 : apwcs_stat_ind.trim().hashCode());
		result = (prime * result) + ((apwid_stat_ind == null) ? 0 : apwid_stat_ind.trim().hashCode());
		result = (prime * result) + ((apwii_stat_ind == null) ? 0 : apwii_stat_ind.trim().hashCode());
		result = (prime * result) + ((apwps_stat_ind == null) ? 0 : apwps_stat_ind.trim().hashCode());
		return result;
	}

	/**
	 * returns the PrimaryKey object.
	 */
	@Override
	public IPrimaryKey getPrimaryKey() {
		final PE_PREG_WMN_DRVR_PrimaryKey key = new PE_PREG_WMN_DRVR_PrimaryKey();
		key.setApp_num(getApp_num());
		return key;
	}

	/**
	 * compares the given cargo with this cargo and returns the changed
	 * attribute-value Map.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map compareAttributes(final PE_PREG_WMN_DRVR_Cargo aCargo) {
		final Map changedAttributeValue = new HashMap();
		if (!((aCargo.getApp_num() == null) && (app_num == null)) && !((aCargo.getApp_num() != null) && aCargo.getApp_num().equals(app_num))) {
			changedAttributeValue.put("app_num", aCargo.getApp_num());
		}
		if (!((aCargo.getAppwr_stat_ind() == null) && (appwr_stat_ind == null))
				&& !((aCargo.getAppwr_stat_ind() != null) && aCargo.getAppwr_stat_ind().equals(appwr_stat_ind))) {
			changedAttributeValue.put("appwr_stat_ind", aCargo.getAppwr_stat_ind());
		}
		if (!((aCargo.getApwci_stat_ind() == null) && (apwci_stat_ind == null))
				&& !((aCargo.getApwci_stat_ind() != null) && aCargo.getApwci_stat_ind().equals(apwci_stat_ind))) {
			changedAttributeValue.put("apwci_stat_ind", aCargo.getApwci_stat_ind());
		}
		if (!((aCargo.getApwcs_stat_ind() == null) && (apwcs_stat_ind == null))
				&& !((aCargo.getApwcs_stat_ind() != null) && aCargo.getApwcs_stat_ind().equals(apwcs_stat_ind))) {
			changedAttributeValue.put("apwcs_stat_ind", aCargo.getApwcs_stat_ind());
		}
		if (!((aCargo.getApwid_stat_ind() == null) && (apwid_stat_ind == null))
				&& !((aCargo.getApwid_stat_ind() != null) && aCargo.getApwid_stat_ind().equals(apwid_stat_ind))) {
			changedAttributeValue.put("apwid_stat_ind", aCargo.getApwid_stat_ind());
		}
		if (!((aCargo.getApwii_stat_ind() == null) && (apwii_stat_ind == null))
				&& !((aCargo.getApwii_stat_ind() != null) && aCargo.getApwii_stat_ind().equals(apwii_stat_ind))) {
			changedAttributeValue.put("apwii_stat_ind", aCargo.getApwii_stat_ind());
		}
		if (!((aCargo.getApwps_stat_ind() == null) && (apwps_stat_ind == null))
				&& !((aCargo.getApwps_stat_ind() != null) && aCargo.getApwps_stat_ind().equals(apwps_stat_ind))) {
			changedAttributeValue.put("apwps_stat_ind", aCargo.getApwps_stat_ind());
		}
		return changedAttributeValue;
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
		final PE_PREG_WMN_DRVR_Cargo other = (PE_PREG_WMN_DRVR_Cargo) obj;
		if (app_num == null) {
			if (other.app_num != null) {
				return false;
			}
		} else if (!app_num.equals(other.app_num)) {
			return false;
		}
		if (appwr_stat_ind == null) {
			if (other.appwr_stat_ind != null) {
				return false;
			}
		} else if (!appwr_stat_ind.equals(other.appwr_stat_ind)) {
			return false;
		}
		if (apwci_stat_ind == null) {
			if (other.apwci_stat_ind != null) {
				return false;
			}
		} else if (!apwci_stat_ind.equals(other.apwci_stat_ind)) {
			return false;
		}
		if (apwcs_stat_ind == null) {
			if (other.apwcs_stat_ind != null) {
				return false;
			}
		} else if (!apwcs_stat_ind.equals(other.apwcs_stat_ind)) {
			return false;
		}
		if (apwid_stat_ind == null) {
			if (other.apwid_stat_ind != null) {
				return false;
			}
		} else if (!apwid_stat_ind.equals(other.apwid_stat_ind)) {
			return false;
		}
		if (apwii_stat_ind == null) {
			if (other.apwii_stat_ind != null) {
				return false;
			}
		} else if (!apwii_stat_ind.equals(other.apwii_stat_ind)) {
			return false;
		}
		if (apwps_stat_ind == null) {
			if (other.apwps_stat_ind != null) {
				return false;
			}
		} else if (!apwps_stat_ind.equals(other.apwps_stat_ind)) {
			return false;
		}
		return true;
	}
}