/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This java bean contains the primary keys for the table BNFT_INDV
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date Fri May 23 11:30:48 CDT 2008 Modified By: Modified on: PCR#
 */
public class BNFT_INDV_PrimaryKey implements java.io.Serializable, IPrimaryKey {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String bnft_pin_num;

	/**
	 * returns the bnft_pin_num value.
	 */
	public String getBnft_pin_num() {
		return bnft_pin_num;
	}

	/**
	 * sets the bnft_pin_num value.
	 */
	public void setBnft_pin_num(final String bnft_pin_num) {
		this.bnft_pin_num = bnft_pin_num;
	}

	/**
	 * returns the string value of cargo.
	 */
	@Override
	public String inspectPrimaryKey() {
		return new StringBuilder().append("BNFT_INDV: ").append("bnft_pin_num=").append(bnft_pin_num).toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((bnft_pin_num == null) ? 0 : bnft_pin_num.trim().hashCode());
		return result;
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
		final BNFT_INDV_PrimaryKey other = (BNFT_INDV_PrimaryKey) obj;
		if (bnft_pin_num == null) {
			if (other.bnft_pin_num != null) {
				return false;
			}
		} else if (!bnft_pin_num.equals(other.bnft_pin_num)) {
			return false;
		}
		return true;
	}

}