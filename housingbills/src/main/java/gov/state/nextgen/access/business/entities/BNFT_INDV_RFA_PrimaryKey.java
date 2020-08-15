/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This java bean contains the primary keys for the given table
 *
 * @author Architecture Team
 * Creation Date Wed Aug 10 08:55:17 CDT 2005 Modified By: Modified on: PCR#
 */
public class BNFT_INDV_RFA_PrimaryKey implements java.io.Serializable, IPrimaryKey {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public BNFT_INDV_RFA_PrimaryKey() {
	}

	private java.lang.String bnft_pin_num;

	private java.lang.String bnft_rfa_num;

	/**
	 * Inspects primary key values for debug.
	 *
	 * Creation Date Wed Aug 10 08:55:17 CDT 2005
	 * @return java.lang.String
	 */
	@Override
	public String inspectPrimaryKey() {
		return "BNFT_INDV_RFA: " + "bnft_pin_num=" + bnft_pin_num + "," + "bnft_rfa_num=" + bnft_rfa_num;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((bnft_pin_num == null) ? 0 : bnft_pin_num.trim().hashCode());
		result = (prime * result) + ((bnft_rfa_num == null) ? 0 : bnft_rfa_num.trim().hashCode());
		return result;
	}

	/**
	 * Returns the bnft_pin_num.
	 *
	 * Creation Date Wed Aug 10 08:55:17 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getBnft_pin_num() {
		return bnft_pin_num;
	}

	/**
	 * Sets the bnft_pin_num.
	 *
	 * Creation Date Wed Aug 10 08:55:17 CDT 2005
	 * @param bnft_pin_num
	 *            The bnft_pin_num to set
	 */

	public void setBnft_pin_num(final java.lang.String bnft_pin_num) {
		this.bnft_pin_num = bnft_pin_num;
	}

	/**
	 * Returns the bnft_rfa_num.
	 *
	 * Creation Date Wed Aug 10 08:55:17 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getBnft_rfa_num() {
		return bnft_rfa_num;
	}

	/**
	 * Sets the bnft_rfa_num.
	 *
	 * Creation Date Wed Aug 10 08:55:17 CDT 2005
	 * @param bnft_rfa_num
	 *            The bnft_rfa_num to set
	 */

	public void setBnft_rfa_num(final java.lang.String bnft_rfa_num) {
		this.bnft_rfa_num = bnft_rfa_num;
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
		final BNFT_INDV_RFA_PrimaryKey other = (BNFT_INDV_RFA_PrimaryKey) obj;
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
		return true;
	}

}