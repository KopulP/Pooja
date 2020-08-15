/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This java bean contains the primary keys for the given table
 *
 * @author Architecture Team
 * Creation Date Thu Jul 07 14:01:55 CDT 2005 Modified By: Modified on: PCR#
 */
public class INDV_ELG_PrimaryKey implements java.io.Serializable, IPrimaryKey {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public INDV_ELG_PrimaryKey() {
	}

	private java.lang.String bnft_pin_num;

	private java.lang.String bnft_case_num;

	private java.lang.String cat_cd;

	private java.lang.String scat_cd;

	private java.lang.String scat_seq_num;

	private java.lang.String cur_elg_ind;

	private java.lang.String pymt_beg_dt;

	/**
	 * Inspects primary key values for debug.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @return java.lang.String
	 */
	@Override
	public String inspectPrimaryKey() {
		return "INDV_ELG: " + "bnft_pin_num=" + bnft_pin_num + "," + "bnft_case_num=" + bnft_case_num + "," + "cat_cd=" + cat_cd + "," + "scat_cd="
				+ scat_cd + "," + "scat_seq_num=" + scat_seq_num + "," + "cur_elg_ind=" + cur_elg_ind + "," + "pymt_beg_dt=" + pymt_beg_dt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((bnft_case_num == null) ? 0 : bnft_case_num.trim().hashCode());
		result = (prime * result) + ((bnft_pin_num == null) ? 0 : bnft_pin_num.trim().hashCode());
		result = (prime * result) + ((cat_cd == null) ? 0 : cat_cd.trim().hashCode());
		result = (prime * result) + ((cur_elg_ind == null) ? 0 : cur_elg_ind.trim().hashCode());
		result = (prime * result) + ((pymt_beg_dt == null) ? 0 : pymt_beg_dt.trim().hashCode());
		result = (prime * result) + ((scat_cd == null) ? 0 : scat_cd.trim().hashCode());
		result = (prime * result) + ((scat_seq_num == null) ? 0 : scat_seq_num.trim().hashCode());
		return result;
	}

	/**
	 * Returns the bnft_pin_num.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getBnft_pin_num() {
		return bnft_pin_num;
	}

	/**
	 * Sets the bnft_pin_num.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @param bnft_pin_num
	 *            The bnft_pin_num to set
	 */

	public void setBnft_pin_num(final java.lang.String bnft_pin_num) {
		this.bnft_pin_num = bnft_pin_num;
	}

	/**
	 * Returns the bnft_case_num.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getBnft_case_num() {
		return bnft_case_num;
	}

	/**
	 * Sets the bnft_case_num.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @param bnft_case_num
	 *            The bnft_case_num to set
	 */

	public void setBnft_case_num(final java.lang.String bnft_case_num) {
		this.bnft_case_num = bnft_case_num;
	}

	/**
	 * Returns the cat_cd.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getCat_cd() {
		return cat_cd;
	}

	/**
	 * Sets the cat_cd.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @param cat_cd
	 *            The cat_cd to set
	 */

	public void setCat_cd(final java.lang.String cat_cd) {
		this.cat_cd = cat_cd;
	}

	/**
	 * Returns the scat_cd.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getScat_cd() {
		return scat_cd;
	}

	/**
	 * Sets the scat_cd.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @param scat_cd
	 *            The scat_cd to set
	 */

	public void setScat_cd(final java.lang.String scat_cd) {
		this.scat_cd = scat_cd;
	}

	/**
	 * Returns the scat_seq_num.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getScat_seq_num() {
		return scat_seq_num;
	}

	/**
	 * Sets the scat_seq_num.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @param scat_seq_num
	 *            The scat_seq_num to set
	 */

	public void setScat_seq_num(final java.lang.String scat_seq_num) {
		this.scat_seq_num = scat_seq_num;
	}

	/**
	 * Returns the cur_elg_ind.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getCur_elg_ind() {
		return cur_elg_ind;
	}

	/**
	 * Sets the cur_elg_ind.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @param cur_elg_ind
	 *            The cur_elg_ind to set
	 */

	public void setCur_elg_ind(final java.lang.String cur_elg_ind) {
		this.cur_elg_ind = cur_elg_ind;
	}

	/**
	 * Returns the pymt_beg_dt.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getPymt_beg_dt() {
		return pymt_beg_dt;
	}

	/**
	 * Sets the pymt_beg_dt.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @param pymt_beg_dt
	 *            The pymt_beg_dt to set
	 */

	public void setPymt_beg_dt(final java.lang.String pymt_beg_dt) {
		this.pymt_beg_dt = pymt_beg_dt;
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
		final INDV_ELG_PrimaryKey other = (INDV_ELG_PrimaryKey) obj;
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
		if (cat_cd == null) {
			if (other.cat_cd != null) {
				return false;
			}
		} else if (!cat_cd.equals(other.cat_cd)) {
			return false;
		}
		if (cur_elg_ind == null) {
			if (other.cur_elg_ind != null) {
				return false;
			}
		} else if (!cur_elg_ind.equals(other.cur_elg_ind)) {
			return false;
		}
		if (pymt_beg_dt == null) {
			if (other.pymt_beg_dt != null) {
				return false;
			}
		} else if (!pymt_beg_dt.equals(other.pymt_beg_dt)) {
			return false;
		}
		if (scat_cd == null) {
			if (other.scat_cd != null) {
				return false;
			}
		} else if (!scat_cd.equals(other.scat_cd)) {
			return false;
		}
		if (scat_seq_num == null) {
			if (other.scat_seq_num != null) {
				return false;
			}
		} else if (!scat_seq_num.equals(other.scat_seq_num)) {
			return false;
		}
		return true;
	}

}