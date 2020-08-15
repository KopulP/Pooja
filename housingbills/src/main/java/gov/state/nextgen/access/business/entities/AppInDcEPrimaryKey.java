/*
 * 
 */
package gov.state.nextgen.access.business.entities;

import javax.persistence.Embeddable;

/**
 * This java bean contains the primary keys for the given table
 *
 * @author Architecture Team
 * Creation Date Mon Jan 23 13:28:44 CST 2006 Modified By: Modified on: PCR#
 */
@Embeddable
public class AppInDcEPrimaryKey  implements java.io.Serializable,IPrimaryKey {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public AppInDcEPrimaryKey() {
	}

	private java.lang.String app_num;

	private java.lang.String indv_seq_num;

	private java.lang.String seq_num;

	/**
	 * Inspects primary key values for debug.
	 *
	 * Creation Date Mon Jan 23 13:28:44 CST 2006
	 * @return java.lang.String
	 */
	@Override
	public String inspectPrimaryKey() {
		return "APP_IN_DC_E: " + "app_num=" + app_num + "," + "indv_seq_num=" + indv_seq_num + "," + "seq_num=" + seq_num;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((app_num == null) ? 0 : app_num.trim().hashCode());
		result = (prime * result) + ((indv_seq_num == null) ? 0 : indv_seq_num.trim().hashCode());
		result = (prime * result) + ((seq_num == null) ? 0 : seq_num.trim().hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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
		final AppInDcEPrimaryKey other = (AppInDcEPrimaryKey) obj;
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
		if (seq_num == null) {
			if (other.seq_num != null) {
				return false;
			}
		} else if (!seq_num.equals(other.seq_num)) {
			return false;
		}
		return true;
	}

	/**
	 * Returns the app_num.
	 *
	 * Creation Date Mon Jan 23 13:28:44 CST 2006
	 * @return java.lang.String
	 */

	public java.lang.String getApp_num() {
		return app_num;
	}

	/**
	 * Sets the app_num.
	 *
	 * Creation Date Mon Jan 23 13:28:44 CST 2006
	 * @param app_num
	 *            The app_num to set
	 */

	public void setApp_num(final java.lang.String app_num) {
		this.app_num = app_num;
	}

	/**
	 * Returns the indv_seq_num.
	 *
	 * Creation Date Mon Jan 23 13:28:44 CST 2006
	 * @return java.lang.String
	 */

	public java.lang.String getIndv_seq_num() {
		return indv_seq_num;
	}

	/**
	 * Sets the indv_seq_num.
	 *
	 * Creation Date Mon Jan 23 13:28:44 CST 2006
	 * @param indv_seq_num
	 *            The indv_seq_num to set
	 */

	public void setIndv_seq_num(final java.lang.String indv_seq_num) {
		this.indv_seq_num = indv_seq_num;
	}

	/**
	 * Returns the seq_num.
	 *
	 * Creation Date Mon Jan 23 13:28:44 CST 2006
	 * @return java.lang.String
	 */

	public java.lang.String getSeq_num() {
		return seq_num;
	}

	/**
	 * Sets the seq_num.
	 *
	 * Creation Date Mon Jan 23 13:28:44 CST 2006
	 * @param seq_num
	 *            The seq_num to set
	 */

	public void setSeq_num(final java.lang.String seq_num) {
		this.seq_num = seq_num;
	}
}