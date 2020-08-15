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
public class BNFT_CASE_ADR_PrimaryKey implements java.io.Serializable, IPrimaryKey {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public BNFT_CASE_ADR_PrimaryKey() {
	}

	private java.lang.String bnft_case_num;

	private java.lang.String adr_typ;

	/**
	 * Inspects primary key values for debug.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @return java.lang.String
	 */
	@Override
	public String inspectPrimaryKey() {
		return "BNFT_CASE_ADR: " + "bnft_case_num=" + bnft_case_num + "," + "adr_typ=" + adr_typ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((adr_typ == null) ? 0 : adr_typ.trim().hashCode());
		result = (prime * result) + ((bnft_case_num == null) ? 0 : bnft_case_num.trim().hashCode());
		return result;
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
	 * Returns the adr_typ.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getAdr_typ() {
		return adr_typ;
	}

	/**
	 * Sets the adr_typ.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @param adr_typ
	 *            The adr_typ to set
	 */

	public void setAdr_typ(final java.lang.String adr_typ) {
		this.adr_typ = adr_typ;
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
		final BNFT_CASE_ADR_PrimaryKey other = (BNFT_CASE_ADR_PrimaryKey) obj;
		if (adr_typ == null) {
			if (other.adr_typ != null) {
				return false;
			}
		} else if (!adr_typ.equals(other.adr_typ)) {
			return false;
		}
		if (bnft_case_num == null) {
			if (other.bnft_case_num != null) {
				return false;
			}
		} else if (!bnft_case_num.equals(other.bnft_case_num)) {
			return false;
		}
		return true;
	}

}