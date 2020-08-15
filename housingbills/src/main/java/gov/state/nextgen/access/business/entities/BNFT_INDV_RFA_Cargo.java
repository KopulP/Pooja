/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This java bean contains the entities for the given table
 *
 * @author Architecture Team
 * Creation Date Wed Aug 10 08:55:12 CDT 2005 Modified By: Modified on: PCR#
 */
public class BNFT_INDV_RFA_Cargo extends AbstractCargo implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.BNFT_INDV_RFA";

	boolean isDirty = false;
	private java.lang.String bnft_pin_num;
	private java.lang.String bnft_rfa_num;
	private java.lang.String app_stat_ind;
	private java.lang.String cnty_num;
	private java.lang.String fst_nam;
	private java.lang.String last_nam;
	private java.lang.String mid_init;
	private java.lang.String rfa_dt;
	private java.lang.String rfa_file_dt;
	private java.lang.String sfx_nam;
	private java.lang.String updt_dt;

	/**
	 * Returns the package name.
	 *
	 * Creation Date Wed Aug 10 08:55:12 CDT 2005
	 * @return gov.state.nextgen.access.business.entities.BNFT_INDV_RFA_Cargo
	 */
	public String getPackage() {
		return PACKAGE;
	}

	/**
	 * Returns the primary key values of a cargo
	 *
	 * Creation Date Wed Aug 10 08:55:12 CDT 2005
	 * @return java.lang.String
	 */

	@Override
	public IPrimaryKey getPrimaryKey() {
		final BNFT_INDV_RFA_PrimaryKey key = new BNFT_INDV_RFA_PrimaryKey();
		key.setBnft_pin_num(getBnft_pin_num());
		key.setBnft_rfa_num(getBnft_rfa_num());
		return key;
	}

	/**
	 * Inspects Cargo values for debug.
	 *
	 * Creation Date Wed Aug 10 08:55:12 CDT 2005
	 * @return java.lang.String
	 */
	@Override
	public String inspectCargo() {
		return "BNFT_INDV_RFA: " + "bnft_pin_num=" + bnft_pin_num + "," + "bnft_rfa_num=" + bnft_rfa_num + "," + "app_stat_ind=" + app_stat_ind + ","
				+ "cnty_num=" + cnty_num + "," + "fst_nam=" + fst_nam + "," + "last_nam=" + last_nam + "," + "mid_init=" + mid_init + "," + "rfa_dt="
				+ rfa_dt + "," + "rfa_file_dt=" + rfa_file_dt + "," + "sfx_nam=" + sfx_nam + "," + "updt_dt=" + updt_dt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((app_stat_ind == null) ? 0 : app_stat_ind.trim().hashCode());
		result = (prime * result) + ((bnft_pin_num == null) ? 0 : bnft_pin_num.trim().hashCode());
		result = (prime * result) + ((bnft_rfa_num == null) ? 0 : bnft_rfa_num.trim().hashCode());
		result = (prime * result) + ((cnty_num == null) ? 0 : cnty_num.trim().hashCode());
		result = (prime * result) + ((fst_nam == null) ? 0 : fst_nam.trim().hashCode());
		result = (prime * result) + ((last_nam == null) ? 0 : last_nam.trim().hashCode());
		result = (prime * result) + ((mid_init == null) ? 0 : mid_init.trim().hashCode());
		result = (prime * result) + ((rfa_dt == null) ? 0 : rfa_dt.trim().hashCode());
		result = (prime * result) + ((rfa_file_dt == null) ? 0 : rfa_file_dt.trim().hashCode());
		result = (prime * result) + ((sfx_nam == null) ? 0 : sfx_nam.trim().hashCode());
		result = (prime * result) + ((updt_dt == null) ? 0 : updt_dt.trim().hashCode());
		return result;
	}

	/**
	 * Returns the bnft_pin_num.
	 *
	 * Creation Date Wed Aug 10 08:55:12 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getBnft_pin_num() {
		return bnft_pin_num;
	}

	/**
	 * Sets the bnft_pin_num.
	 *
	 * Creation Date Wed Aug 10 08:55:12 CDT 2005
	 * @param bnft_pin_num
	 *            The bnft_pin_num to set
	 */

	public void setBnft_pin_num(final java.lang.String bnft_pin_num) {
		this.bnft_pin_num = bnft_pin_num;
	}

	/**
	 * Returns the bnft_rfa_num.
	 *
	 * Creation Date Wed Aug 10 08:55:12 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getBnft_rfa_num() {
		return bnft_rfa_num;
	}

	/**
	 * Sets the bnft_rfa_num.
	 *
	 * Creation Date Wed Aug 10 08:55:12 CDT 2005
	 * @param bnft_rfa_num
	 *            The bnft_rfa_num to set
	 */

	public void setBnft_rfa_num(final java.lang.String bnft_rfa_num) {
		this.bnft_rfa_num = bnft_rfa_num;
	}

	/**
	 * Returns the app_stat_ind.
	 *
	 * Creation Date Wed Aug 10 08:55:12 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getApp_stat_ind() {
		return app_stat_ind;
	}

	/**
	 * Sets the app_stat_ind.
	 *
	 * Creation Date Wed Aug 10 08:55:12 CDT 2005
	 * @param app_stat_ind
	 *            The app_stat_ind to set
	 */

	public void setApp_stat_ind(final java.lang.String app_stat_ind) {
		this.app_stat_ind = app_stat_ind;
	}

	/**
	 * Returns the cnty_num.
	 *
	 * Creation Date Wed Aug 10 08:55:12 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getCnty_num() {
		return cnty_num;
	}

	/**
	 * Sets the cnty_num.
	 *
	 * Creation Date Wed Aug 10 08:55:12 CDT 2005
	 * @param cnty_num
	 *            The cnty_num to set
	 */

	public void setCnty_num(final java.lang.String cnty_num) {
		this.cnty_num = cnty_num;
	}

	/**
	 * Returns the fst_nam.
	 *
	 * Creation Date Wed Aug 10 08:55:12 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getFst_nam() {
		return fst_nam;
	}

	/**
	 * Sets the fst_nam.
	 *
	 * Creation Date Wed Aug 10 08:55:12 CDT 2005
	 * @param fst_nam
	 *            The fst_nam to set
	 */

	public void setFst_nam(final java.lang.String fst_nam) {
		this.fst_nam = fst_nam;
	}

	/**
	 * Returns the last_nam.
	 *
	 * Creation Date Wed Aug 10 08:55:12 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getLast_nam() {
		return last_nam;
	}

	/**
	 * Sets the last_nam.
	 *
	 * Creation Date Wed Aug 10 08:55:12 CDT 2005
	 * @param last_nam
	 *            The last_nam to set
	 */

	public void setLast_nam(final java.lang.String last_nam) {
		this.last_nam = last_nam;
	}

	/**
	 * Returns the mid_init.
	 *
	 * Creation Date Wed Aug 10 08:55:12 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getMid_init() {
		return mid_init;
	}

	/**
	 * Sets the mid_init.
	 *
	 * Creation Date Wed Aug 10 08:55:12 CDT 2005
	 * @param mid_init
	 *            The mid_init to set
	 */

	public void setMid_init(final java.lang.String mid_init) {
		this.mid_init = mid_init;
	}

	/**
	 * Returns the rfa_dt.
	 *
	 * Creation Date Wed Aug 10 08:55:12 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getRfa_dt() {
		return rfa_dt;
	}

	/**
	 * Sets the rfa_dt.
	 *
	 * Creation Date Wed Aug 10 08:55:12 CDT 2005
	 * @param rfa_dt
	 *            The rfa_dt to set
	 */

	public void setRfa_dt(final java.lang.String rfa_dt) {
		this.rfa_dt = rfa_dt;
	}

	/**
	 * Returns the rfa_file_dt.
	 *
	 * Creation Date Wed Aug 10 08:55:12 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getRfa_file_dt() {
		return rfa_file_dt;
	}

	/**
	 * Sets the rfa_file_dt.
	 *
	 * Creation Date Wed Aug 10 08:55:12 CDT 2005
	 * @param rfa_file_dt
	 *            The rfa_file_dt to set
	 */

	public void setRfa_file_dt(final java.lang.String rfa_file_dt) {
		this.rfa_file_dt = rfa_file_dt;
	}

	/**
	 * Returns the sfx_nam.
	 *
	 * Creation Date Wed Aug 10 08:55:12 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getSfx_nam() {
		return sfx_nam;
	}

	/**
	 * Sets the sfx_nam.
	 *
	 * Creation Date Wed Aug 10 08:55:12 CDT 2005
	 * @param sfx_nam
	 *            The sfx_nam to set
	 */

	public void setSfx_nam(final java.lang.String sfx_nam) {
		this.sfx_nam = sfx_nam;
	}

	/**
	 * Returns the updt_dt.
	 *
	 * Creation Date Wed Aug 10 08:55:12 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getUpdt_dt() {
		return updt_dt;
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
		final BNFT_INDV_RFA_Cargo other = (BNFT_INDV_RFA_Cargo) obj;
		if (app_stat_ind == null) {
			if (other.app_stat_ind != null) {
				return false;
			}
		} else if (!app_stat_ind.equals(other.app_stat_ind)) {
			return false;
		}
		if (bnft_pin_num == null) {
			if (other.bnft_pin_num != null) {
				return false;
			}
		} else if (!bnft_pin_num.equals(other.bnft_pin_num)) {
			return false;
		}
		if (bnft_rfa_num == null) {
			if (other.bnft_rfa_num != null) {
				return false;
			}
		} else if (!bnft_rfa_num.equals(other.bnft_rfa_num)) {
			return false;
		}
		if (cnty_num == null) {
			if (other.cnty_num != null) {
				return false;
			}
		} else if (!cnty_num.equals(other.cnty_num)) {
			return false;
		}
		if (fst_nam == null) {
			if (other.fst_nam != null) {
				return false;
			}
		} else if (!fst_nam.equals(other.fst_nam)) {
			return false;
		}
		if (last_nam == null) {
			if (other.last_nam != null) {
				return false;
			}
		} else if (!last_nam.equals(other.last_nam)) {
			return false;
		}
		if (mid_init == null) {
			if (other.mid_init != null) {
				return false;
			}
		} else if (!mid_init.equals(other.mid_init)) {
			return false;
		}
		if (rfa_dt == null) {
			if (other.rfa_dt != null) {
				return false;
			}
		} else if (!rfa_dt.equals(other.rfa_dt)) {
			return false;
		}
		if (rfa_file_dt == null) {
			if (other.rfa_file_dt != null) {
				return false;
			}
		} else if (!rfa_file_dt.equals(other.rfa_file_dt)) {
			return false;
		}
		if (sfx_nam == null) {
			if (other.sfx_nam != null) {
				return false;
			}
		} else if (!sfx_nam.equals(other.sfx_nam)) {
			return false;
		}
		if (updt_dt == null) {
			if (other.updt_dt != null) {
				return false;
			}
		} else if (!updt_dt.equals(other.updt_dt)) {
			return false;
		}
		return true;
	}

	/**
	 * Sets the updt_dt.
	 *
	 * Creation Date Wed Aug 10 08:55:12 CDT 2005
	 * @param updt_dt
	 *            The updt_dt to set
	 */

	public void setUpdt_dt(final java.lang.String updt_dt) {
		this.updt_dt = updt_dt;
	}

}