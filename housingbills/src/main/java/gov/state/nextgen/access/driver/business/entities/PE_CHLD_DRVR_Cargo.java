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
 * This java bean contains the entities of PE_CHLD_DRVR
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date Thu Jul 26 15:18:54 CDT 2007 Modified By: Modified on: PCR#
 */
@SuppressWarnings("serial")
public class PE_CHLD_DRVR_Cargo extends AbstractCargo implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	boolean isDirty = false;
	private String app_num;
	private String apcci_stat_ind;
	private String apccs_stat_ind;
	private String apchr_stat_ind;
	private String apcid_stat_ind;
	private String apcii_stat_ind;
	private String apcps_stat_ind;
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
	 * returns the apcci_stat_ind value.
	 */
	public String getApcci_stat_ind() {
		return apcci_stat_ind;
	}

	/**
	 * sets the apcci_stat_ind value.
	 */
	public void setApcci_stat_ind(final String apcci_stat_ind) {
		this.apcci_stat_ind = apcci_stat_ind;
	}

	/**
	 * returns the apccs_stat_ind value.
	 */
	public String getApccs_stat_ind() {
		return apccs_stat_ind;
	}

	/**
	 * sets the apccs_stat_ind value.
	 */
	public void setApccs_stat_ind(final String apccs_stat_ind) {
		this.apccs_stat_ind = apccs_stat_ind;
	}

	/**
	 * returns the apchr_stat_ind value.
	 */
	public String getApchr_stat_ind() {
		return apchr_stat_ind;
	}

	/**
	 * sets the apchr_stat_ind value.
	 */
	public void setApchr_stat_ind(final String apchr_stat_ind) {
		this.apchr_stat_ind = apchr_stat_ind;
	}

	/**
	 * returns the apcid_stat_ind value.
	 */
	public String getApcid_stat_ind() {
		return apcid_stat_ind;
	}

	/**
	 * sets the apcid_stat_ind value.
	 */
	public void setApcid_stat_ind(final String apcid_stat_ind) {
		this.apcid_stat_ind = apcid_stat_ind;
	}

	/**
	 * returns the apcii_stat_ind value.
	 */
	public String getApcii_stat_ind() {
		return apcii_stat_ind;
	}

	/**
	 * sets the apcii_stat_ind value.
	 */
	public void setApcii_stat_ind(final String apcii_stat_ind) {
		this.apcii_stat_ind = apcii_stat_ind;
	}

	/**
	 * returns the apcps_stat_ind value.
	 */
	public String getApcps_stat_ind() {
		return apcps_stat_ind;
	}

	/**
	 * sets the apcps_stat_ind value.
	 */
	public void setApcps_stat_ind(final String apcps_stat_ind) {
		this.apcps_stat_ind = apcps_stat_ind;
	}

	/**
	 * returns the string value of cargo.
	 */
	@Override
	public String inspectCargo() {
		return new StringBuilder().append("PE_CHLD_DRVR: ").append("app_num=").append(app_num).append("apcci_stat_ind=").append(apcci_stat_ind)
				.append("apccs_stat_ind=").append(apccs_stat_ind).append("apchr_stat_ind=").append(apchr_stat_ind).append("apcid_stat_ind=")
				.append(apcid_stat_ind).append("apcii_stat_ind=").append(apcii_stat_ind).append("apcps_stat_ind=").append(apcps_stat_ind).toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((apcci_stat_ind == null) ? 0 : apcci_stat_ind.trim().hashCode());
		result = (prime * result) + ((apccs_stat_ind == null) ? 0 : apccs_stat_ind.trim().hashCode());
		result = (prime * result) + ((apchr_stat_ind == null) ? 0 : apchr_stat_ind.trim().hashCode());
		result = (prime * result) + ((apcid_stat_ind == null) ? 0 : apcid_stat_ind.trim().hashCode());
		result = (prime * result) + ((apcii_stat_ind == null) ? 0 : apcii_stat_ind.trim().hashCode());
		result = (prime * result) + ((apcps_stat_ind == null) ? 0 : apcps_stat_ind.trim().hashCode());
		result = (prime * result) + ((app_num == null) ? 0 : app_num.trim().hashCode());
		return result;
	}

	/**
	 * returns the PrimaryKey object.
	 */
	@Override
	public IPrimaryKey getPrimaryKey() {
		final PE_CHLD_DRVR_PrimaryKey key = new PE_CHLD_DRVR_PrimaryKey();
		key.setApp_num(getApp_num());
		return key;
	}

	/**
	 * compares the given cargo with this cargo and returns the changed
	 * attribute-value Map.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map compareAttributes(final PE_CHLD_DRVR_Cargo aCargo) {
		final Map changedAttributeValue = new HashMap();
		if (!((aCargo.getApp_num() == null) && (app_num == null)) && !((aCargo.getApp_num() != null) && aCargo.getApp_num().equals(app_num))) {
			changedAttributeValue.put("app_num", aCargo.getApp_num());
		}
		if (!((aCargo.getApcci_stat_ind() == null) && (apcci_stat_ind == null))
				&& !((aCargo.getApcci_stat_ind() != null) && aCargo.getApcci_stat_ind().equals(apcci_stat_ind))) {
			changedAttributeValue.put("apcci_stat_ind", aCargo.getApcci_stat_ind());
		}
		if (!((aCargo.getApccs_stat_ind() == null) && (apccs_stat_ind == null))
				&& !((aCargo.getApccs_stat_ind() != null) && aCargo.getApccs_stat_ind().equals(apccs_stat_ind))) {
			changedAttributeValue.put("apccs_stat_ind", aCargo.getApccs_stat_ind());
		}
		if (!((aCargo.getApchr_stat_ind() == null) && (apchr_stat_ind == null))
				&& !((aCargo.getApchr_stat_ind() != null) && aCargo.getApchr_stat_ind().equals(apchr_stat_ind))) {
			changedAttributeValue.put("apchr_stat_ind", aCargo.getApchr_stat_ind());
		}
		if (!((aCargo.getApcid_stat_ind() == null) && (apcid_stat_ind == null))
				&& !((aCargo.getApcid_stat_ind() != null) && aCargo.getApcid_stat_ind().equals(apcid_stat_ind))) {
			changedAttributeValue.put("apcid_stat_ind", aCargo.getApcid_stat_ind());
		}
		if (!((aCargo.getApcii_stat_ind() == null) && (apcii_stat_ind == null))
				&& !((aCargo.getApcii_stat_ind() != null) && aCargo.getApcii_stat_ind().equals(apcii_stat_ind))) {
			changedAttributeValue.put("apcii_stat_ind", aCargo.getApcii_stat_ind());
		}
		if (!((aCargo.getApcps_stat_ind() == null) && (apcps_stat_ind == null))
				&& !((aCargo.getApcps_stat_ind() != null) && aCargo.getApcps_stat_ind().equals(apcps_stat_ind))) {
			changedAttributeValue.put("apcps_stat_ind", aCargo.getApcps_stat_ind());
		}
		return changedAttributeValue;
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
		final PE_CHLD_DRVR_Cargo other = (PE_CHLD_DRVR_Cargo) obj;
		if (apcci_stat_ind == null) {
			if (other.apcci_stat_ind != null) {
				return false;
			}
		} else if (!apcci_stat_ind.equals(other.apcci_stat_ind)) {
			return false;
		}
		if (apccs_stat_ind == null) {
			if (other.apccs_stat_ind != null) {
				return false;
			}
		} else if (!apccs_stat_ind.equals(other.apccs_stat_ind)) {
			return false;
		}
		if (apchr_stat_ind == null) {
			if (other.apchr_stat_ind != null) {
				return false;
			}
		} else if (!apchr_stat_ind.equals(other.apchr_stat_ind)) {
			return false;
		}
		if (apcid_stat_ind == null) {
			if (other.apcid_stat_ind != null) {
				return false;
			}
		} else if (!apcid_stat_ind.equals(other.apcid_stat_ind)) {
			return false;
		}
		if (apcii_stat_ind == null) {
			if (other.apcii_stat_ind != null) {
				return false;
			}
		} else if (!apcii_stat_ind.equals(other.apcii_stat_ind)) {
			return false;
		}
		if (apcps_stat_ind == null) {
			if (other.apcps_stat_ind != null) {
				return false;
			}
		} else if (!apcps_stat_ind.equals(other.apcps_stat_ind)) {
			return false;
		}
		if (app_num == null) {
			if (other.app_num != null) {
				return false;
			}
		} else if (!app_num.equals(other.app_num)) {
			return false;
		}
		return true;
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