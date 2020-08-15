/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This java bean contains the entities for the given table
 *
 * @author Architecture Team
 * Creation Date Wed Jul 20 16:08:52 CDT 2005 Modified By: Modified on: PCR#
 */
public class BNFT_INDV_CASE_Cargo extends AbstractCargo implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.BNFT_INDV_CASE";

	boolean isDirty = false;
	private java.lang.String bnft_pin_num;
	private java.lang.String bnft_case_num;
	private java.lang.String indv_acs_lvl_cd;
	private java.lang.String updt_dt;
	private java.lang.String vld_live_arng_flg;
	private java.lang.String case_mode_cd;
	private java.lang.String case_stat_ind;
	private java.lang.String file_dt;
	private java.lang.String prim_prsn_sw;
	private java.lang.String cat_cd;

	public java.lang.String getCat_cd() {
		return cat_cd;
	}

	public void setCat_cd(final java.lang.String cat_cd) {
		this.cat_cd = cat_cd;
	}

	/**
	 * Returns the package name.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return gov.state.nextgen.access.business.entities.BNFT_INDV_CASE_Cargo
	 */
	public String getPackage() {
		return PACKAGE;
	}

	/**
	 * Returns the primary key values of a cargo
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	@Override
	public IPrimaryKey getPrimaryKey() {
		final BNFT_INDV_CASE_PrimaryKey key = new BNFT_INDV_CASE_PrimaryKey();
		key.setBnft_pin_num(getBnft_pin_num());
		key.setBnft_case_num(getBnft_case_num());
		key.setCat_cd(getCat_cd());
		return key;
	}

	/**
	 * Inspects Cargo values for debug.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */
	@Override
	public String inspectCargo() {
		return "BNFT_INDV_CASE: " + "bnft_pin_num=" + bnft_pin_num + "," + "bnft_case_num=" + bnft_case_num + "," + "indv_acs_lvl_cd="
				+ indv_acs_lvl_cd + "," + "updt_dt=" + updt_dt + "," + "vld_live_arng_flg=" + vld_live_arng_flg + "," + "case_mode_cd="
				+ case_mode_cd + "," + "case_stat_ind=" + case_stat_ind + "," + "file_dt=" + file_dt + "," + "prim_prsn_sw	char=" + prim_prsn_sw
				+ "cat_cd=" + cat_cd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((bnft_case_num == null) ? 0 : bnft_case_num.trim().hashCode());
		result = (prime * result) + ((bnft_pin_num == null) ? 0 : bnft_pin_num.trim().hashCode());
		result = (prime * result) + ((case_mode_cd == null) ? 0 : case_mode_cd.trim().hashCode());
		result = (prime * result) + ((case_stat_ind == null) ? 0 : case_stat_ind.trim().hashCode());
		result = (prime * result) + ((cat_cd == null) ? 0 : cat_cd.trim().hashCode());
		result = (prime * result) + ((file_dt == null) ? 0 : file_dt.trim().hashCode());
		result = (prime * result) + ((indv_acs_lvl_cd == null) ? 0 : indv_acs_lvl_cd.trim().hashCode());
		result = (prime * result) + ((prim_prsn_sw == null) ? 0 : prim_prsn_sw.trim().hashCode());
		result = (prime * result) + ((updt_dt == null) ? 0 : updt_dt.trim().hashCode());
		result = (prime * result) + ((vld_live_arng_flg == null) ? 0 : vld_live_arng_flg.trim().hashCode());
		return result;
	}

	/**
	 * Returns the bnft_pin_num.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getBnft_pin_num() {
		return bnft_pin_num;
	}

	/**
	 * Sets the bnft_pin_num.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param bnft_pin_num
	 *            The bnft_pin_num to set
	 */

	public void setBnft_pin_num(final java.lang.String bnft_pin_num) {
		this.bnft_pin_num = bnft_pin_num;
	}

	/**
	 * Returns the bnft_case_num.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getBnft_case_num() {
		return bnft_case_num;
	}

	/**
	 * Sets the bnft_case_num.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param bnft_case_num
	 *            The bnft_case_num to set
	 */

	public void setBnft_case_num(final java.lang.String bnft_case_num) {
		this.bnft_case_num = bnft_case_num;
	}

	/**
	 * Returns the indv_acs_lvl_cd.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getIndv_acs_lvl_cd() {
		return indv_acs_lvl_cd;
	}

	/**
	 * Sets the indv_acs_lvl_cd.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param indv_acs_lvl_cd
	 *            The indv_acs_lvl_cd to set
	 */

	public void setIndv_acs_lvl_cd(final java.lang.String indv_acs_lvl_cd) {
		this.indv_acs_lvl_cd = indv_acs_lvl_cd;
	}

	/**
	 * Returns the updt_dt.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getUpdt_dt() {
		return updt_dt;
	}

	/**
	 * Sets the updt_dt.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param updt_dt
	 *            The updt_dt to set
	 */

	public void setUpdt_dt(final java.lang.String updt_dt) {
		this.updt_dt = updt_dt;
	}

	/**
	 * Returns the vld_live_arng_flg.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getVld_live_arng_flg() {
		return vld_live_arng_flg;
	}

	/**
	 * Sets the vld_live_arng_flg.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param vld_live_arng_flg
	 *            The vld_live_arng_flg to set
	 */

	public void setVld_live_arng_flg(final java.lang.String vld_live_arng_flg) {
		this.vld_live_arng_flg = vld_live_arng_flg;
	}

	/**
	 * Returns the case_mode_cd.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getCase_mode_cd() {
		return case_mode_cd;
	}

	/**
	 * Sets the case_mode_cd.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param case_mode_cd
	 *            The case_mode_cd to set
	 */

	public void setCase_mode_cd(final java.lang.String case_mode_cd) {
		this.case_mode_cd = case_mode_cd;
	}

	/**
	 * Returns the case_stat_ind.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getCase_stat_ind() {
		return case_stat_ind;
	}

	/**
	 * Sets the case_stat_ind.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param case_stat_ind
	 *            The case_stat_ind to set
	 */

	public void setCase_stat_ind(final java.lang.String case_stat_ind) {
		this.case_stat_ind = case_stat_ind;
	}

	/**
	 * Returns the file_dt.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getFile_dt() {
		return file_dt;
	}

	/**
	 * Sets the file_dt.
	 *
	 * Creation Date Wed Jul 20 16:08:52 CDT 2005
	 * @param file_dt
	 *            The file_dt to set
	 */

	public void setFile_dt(final java.lang.String file_dt) {
		this.file_dt = file_dt;
	}

	/**
	 * @return
	 */
	public java.lang.String getPrim_prsn_sw() {
		return prim_prsn_sw;
	}

	/**
	 * @param string
	 */
	public void setPrim_prsn_sw(final java.lang.String string) {
		prim_prsn_sw = string;
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
		final BNFT_INDV_CASE_Cargo other = (BNFT_INDV_CASE_Cargo) obj;
		if (bnft_case_num == null) {
			if (other.bnft_case_num != null) {
				return false;
			}
		} else if (!bnft_case_num.equals(other.bnft_case_num)) {
			return false;
		}
		if (bnft_pin_num == null) {
			if (other.bnft_pin_num != null) {
				return false;
			}
		} else if (!bnft_pin_num.equals(other.bnft_pin_num)) {
			return false;
		}
		if (case_mode_cd == null) {
			if (other.case_mode_cd != null) {
				return false;
			}
		} else if (!case_mode_cd.equals(other.case_mode_cd)) {
			return false;
		}
		if (case_stat_ind == null) {
			if (other.case_stat_ind != null) {
				return false;
			}
		} else if (!case_stat_ind.equals(other.case_stat_ind)) {
			return false;
		}
		if (cat_cd == null) {
			if (other.cat_cd != null) {
				return false;
			}
		} else if (!cat_cd.equals(other.cat_cd)) {
			return false;
		}
		if (file_dt == null) {
			if (other.file_dt != null) {
				return false;
			}
		} else if (!file_dt.equals(other.file_dt)) {
			return false;
		}
		if (indv_acs_lvl_cd == null) {
			if (other.indv_acs_lvl_cd != null) {
				return false;
			}
		} else if (!indv_acs_lvl_cd.equals(other.indv_acs_lvl_cd)) {
			return false;
		}
		if (prim_prsn_sw == null) {
			if (other.prim_prsn_sw != null) {
				return false;
			}
		} else if (!prim_prsn_sw.equals(other.prim_prsn_sw)) {
			return false;
		}
		if (updt_dt == null) {
			if (other.updt_dt != null) {
				return false;
			}
		} else if (!updt_dt.equals(other.updt_dt)) {
			return false;
		}
		if (vld_live_arng_flg == null) {
			if (other.vld_live_arng_flg != null) {
				return false;
			}
		} else if (!vld_live_arng_flg.equals(other.vld_live_arng_flg)) {
			return false;
		}
		return true;
	}

}