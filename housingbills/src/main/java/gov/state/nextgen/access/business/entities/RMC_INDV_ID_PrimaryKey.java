/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This java bean contains the primary keys for the table RMC_INDV_ID
 *
 * @author Architecture Team
 * Creation Date Tue Jun 06 22:08:16 CDT 2006 Modified By: Modified on: PCR#
 */
public class RMC_INDV_ID_PrimaryKey implements java.io.Serializable, IPrimaryKey {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String app_num;
	private String indv_seq_num;
	private String pin_num;

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
	 * returns the indv_seq_num value.
	 */
	public String getIndv_seq_num() {
		return indv_seq_num;
	}

	/**
	 * sets the indv_seq_num value.
	 */
	public void setIndv_seq_num(final String indv_seq_num) {
		this.indv_seq_num = indv_seq_num;
	}

	/**
	 * returns the pin_num value.
	 */
	public String getPin_num() {
		return pin_num;
	}

	/**
	 * sets the pin_num value.
	 */
	public void setPin_num(final String pin_num) {
		this.pin_num = pin_num;
	}

	/**
	 * returns the string value of cargo.
	 */
	@Override
	public String inspectPrimaryKey() {
		return new StringBuilder().append("RMC_INDV_ID: ").append("app_num=").append(app_num).append("indv_seq_num=").append(indv_seq_num)
				.append("pin_num=").append(pin_num).toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((app_num == null) ? 0 : app_num.trim().hashCode());
		result = (prime * result) + ((indv_seq_num == null) ? 0 : indv_seq_num.trim().hashCode());
		result = (prime * result) + ((pin_num == null) ? 0 : pin_num.trim().hashCode());
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
		final RMC_INDV_ID_PrimaryKey other = (RMC_INDV_ID_PrimaryKey) obj;
		if (app_num == null) {
			if (other.app_num != null) {
				return false;
			}
		} else if (!app_num.equals(other.app_num)) {
			return false;
		}
		if (indv_seq_num == null) {
			if (other.indv_seq_num != null) {
				return false;
			}
		} else if (!indv_seq_num.equals(other.indv_seq_num)) {
			return false;
		}
		if (pin_num == null) {
			if (other.pin_num != null) {
				return false;
			}
		} else if (!pin_num.equals(other.pin_num)) {
			return false;
		}
		return true;
	}

}