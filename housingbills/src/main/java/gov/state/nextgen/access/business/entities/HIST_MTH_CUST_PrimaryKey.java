/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This java bean contains the primary keys for the given table
 *
 * @author Architecture Team
 * Creation Date Wed Aug 31 19:08:06 CDT 2005 Modified By: Modified on: PCR#
 */
public class HIST_MTH_CUST_PrimaryKey implements java.io.Serializable, IPrimaryKey {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public HIST_MTH_CUST_PrimaryKey() {
	}

	private java.lang.String cat_cd;

	private java.lang.String scat_seq_num;

	/**
	 * Inspects primary key values for debug.
	 *
	 * Creation Date Wed Aug 31 19:08:06 CDT 2005
	 * @return java.lang.String
	 */
	@Override
	public String inspectPrimaryKey() {
		return "HIST_MTH_CUST: " + "cat_cd=" + cat_cd + "," + "scat_seq_num=" + scat_seq_num;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((cat_cd == null) ? 0 : cat_cd.trim().hashCode());
		result = (prime * result) + ((scat_seq_num == null) ? 0 : scat_seq_num.trim().hashCode());
		return result;
	}

	/**
	 * Returns the cat_cd.
	 *
	 * Creation Date Wed Aug 31 19:08:06 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getCat_cd() {
		return cat_cd;
	}

	/**
	 * Sets the cat_cd.
	 *
	 * Creation Date Wed Aug 31 19:08:06 CDT 2005
	 * @param cat_cd
	 *            The cat_cd to set
	 */

	public void setCat_cd(final java.lang.String cat_cd) {
		this.cat_cd = cat_cd;
	}

	/**
	 * Returns the scat_cd.
	 *
	 * Creation Date Wed Aug 31 19:08:06 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getScat_seq_num() {
		return scat_seq_num;
	}

	/**
	 * Sets the scat_seq_num.
	 *
	 * Creation Date Wed Aug 31 19:08:06 CDT 2005
	 * @param scat_seq_num
	 *            The scat_seq_num to set
	 */

	public void setScat_seq_num(final java.lang.String scat_seq_num) {
		this.scat_seq_num = scat_seq_num;
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
		final HIST_MTH_CUST_PrimaryKey other = (HIST_MTH_CUST_PrimaryKey) obj;
		if (cat_cd == null) {
			if (other.cat_cd != null) {
				return false;
			}
		} else if (!cat_cd.equals(other.cat_cd)) {
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