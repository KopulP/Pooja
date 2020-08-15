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
public class BNFT_INDV_CASE_PrimaryKey implements java.io.Serializable, IPrimaryKey {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public BNFT_INDV_CASE_PrimaryKey() {
	}

	private java.lang.String bnft_pin_num;

	private java.lang.String bnft_case_num;

	private java.lang.String cat_cd;

	/**
	 * Inspects primary key values for debug.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @return java.lang.String
	 */
	@Override
	public String inspectPrimaryKey() {
		return "BNFT_INDV_CASE: " + "bnft_pin_num=" + bnft_pin_num + "," + "bnft_case_num=" + bnft_case_num + "cat_cd=" + cat_cd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((bnft_case_num == null) ? 0 : bnft_case_num.trim().hashCode());
		result = (prime * result) + ((bnft_pin_num == null) ? 0 : bnft_pin_num.trim().hashCode());
		result = (prime * result) + ((cat_cd == null) ? 0 : cat_cd.trim().hashCode());
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

	public java.lang.String getCat_cd() {
		return cat_cd;
	}

	public void setCat_cd(final java.lang.String cat_cd) {
		this.cat_cd = cat_cd;
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
		final BNFT_INDV_CASE_PrimaryKey other = (BNFT_INDV_CASE_PrimaryKey) obj;
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
		return true;
	}

}