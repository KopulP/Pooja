/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This java bean contains the entities for the given table
 *
 * @author Architecture Team
 * Creation Date Wed Aug 31 19:08:02 CDT 2005 Modified By: Modified on: PCR#
 */
public class HIST_MTH_CUST_Cargo extends AbstractCargo implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.HIST_MTH_CUST";

	boolean isDirty = false;
	private java.lang.String cat_cd;
	private java.lang.String scat_seq_num;
	private java.lang.String mth_count;
	private java.lang.String pymt_beg_dt;
	private java.lang.String pymt_end_dt;

	/**
	 * Returns the package name.
	 *
	 * Creation Date Wed Aug 31 19:08:02 CDT 2005
	 * @return gov.state.nextgen.access.business.entities.HIST_MTH_CUST_Cargo
	 */
	public String getPackage() {
		return PACKAGE;
	}

	/**
	 * Returns the primary key values of a cargo
	 *
	 * Creation Date Wed Aug 31 19:08:02 CDT 2005
	 * @return java.lang.String
	 */

	@Override
	public IPrimaryKey getPrimaryKey() {
		final HIST_MTH_CUST_PrimaryKey key = new HIST_MTH_CUST_PrimaryKey();
		key.setCat_cd(getCat_cd());
		key.setScat_seq_num(getScat_seq_num());
		return key;
	}

	/**
	 * Inspects Cargo values for debug.
	 *
	 * Creation Date Wed Aug 31 19:08:02 CDT 2005
	 * @return java.lang.String
	 */
	@Override
	public String inspectCargo() {
		return "HIST_MTH_CUST: " + "cat_cd=" + cat_cd + "," + "scat_seq_num=" + scat_seq_num + "," + "mth_count=" + mth_count + "," + "pymt_beg_dt="
				+ pymt_beg_dt + "," + "pymt_end_dt=" + pymt_end_dt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((cat_cd == null) ? 0 : cat_cd.trim().hashCode());
		result = (prime * result) + ((mth_count == null) ? 0 : mth_count.trim().hashCode());
		result = (prime * result) + ((pymt_beg_dt == null) ? 0 : pymt_beg_dt.trim().hashCode());
		result = (prime * result) + ((pymt_end_dt == null) ? 0 : pymt_end_dt.trim().hashCode());
		result = (prime * result) + ((scat_seq_num == null) ? 0 : scat_seq_num.trim().hashCode());
		return result;
	}

	/**
	 * Returns the cat_cd.
	 *
	 * Creation Date Wed Aug 31 19:08:02 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getCat_cd() {
		return cat_cd;
	}

	/**
	 * Sets the cat_cd.
	 *
	 * Creation Date Wed Aug 31 19:08:02 CDT 2005
	 * @param cat_cd
	 *            The cat_cd to set
	 */

	public void setCat_cd(final java.lang.String cat_cd) {
		this.cat_cd = cat_cd;
	}

	/**
	 * Returns the scat_seq_num.
	 *
	 * Creation Date Wed Aug 31 19:08:02 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getScat_seq_num() {
		return scat_seq_num;
	}

	/**
	 * Sets the scat_seq_num.
	 *
	 * Creation Date Wed Aug 31 19:08:02 CDT 2005
	 * @param scat_seq_num
	 *            The scat_seq_num to set
	 */

	public void setScat_seq_num(final java.lang.String scat_seq_num) {
		this.scat_seq_num = scat_seq_num;
	}

	/**
	 * Returns the mth_count.
	 *
	 * Creation Date Wed Aug 31 19:08:02 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getMth_count() {
		return mth_count;
	}

	/**
	 * Sets the mth_count.
	 *
	 * Creation Date Wed Aug 31 19:08:02 CDT 2005
	 * @param mth_count
	 *            The mth_count to set
	 */

	public void setMth_count(final java.lang.String mth_count) {
		this.mth_count = mth_count;
	}

	/**
	 * Returns the pymt_beg_dt.
	 *
	 * Creation Date Wed Aug 31 19:08:02 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getPymt_beg_dt() {
		return pymt_beg_dt;
	}

	/**
	 * Sets the pymt_beg_dt.
	 *
	 * Creation Date Wed Aug 31 19:08:02 CDT 2005
	 * @param pymt_beg_dt
	 *            The pymt_beg_dt to set
	 */

	public void setPymt_beg_dt(final java.lang.String pymt_beg_dt) {
		this.pymt_beg_dt = pymt_beg_dt;
	}

	/**
	 * @return
	 */
	public java.lang.String getPymt_end_dt() {
		return pymt_end_dt;
	}

	/**
	 * @param string
	 */
	public void setPymt_end_dt(final java.lang.String string) {
		pymt_end_dt = string;
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
		final HIST_MTH_CUST_Cargo other = (HIST_MTH_CUST_Cargo) obj;
		if (cat_cd == null) {
			if (other.cat_cd != null) {
				return false;
			}
		} else if (!cat_cd.equals(other.cat_cd)) {
			return false;
		}
		if (mth_count == null) {
			if (other.mth_count != null) {
				return false;
			}
		} else if (!mth_count.equals(other.mth_count)) {
			return false;
		}
		if (pymt_beg_dt == null) {
			if (other.pymt_beg_dt != null) {
				return false;
			}
		} else if (!pymt_beg_dt.equals(other.pymt_beg_dt)) {
			return false;
		}
		if (pymt_end_dt == null) {
			if (other.pymt_end_dt != null) {
				return false;
			}
		} else if (!pymt_end_dt.equals(other.pymt_end_dt)) {
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