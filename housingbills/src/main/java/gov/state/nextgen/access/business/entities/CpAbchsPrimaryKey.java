package gov.state.nextgen.access.business.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CpAbchsPrimaryKey  implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public CpAbchsPrimaryKey() {
	}

	private java.lang.String app_num;

	private java.lang.String indv_seq_num;

	private java.lang.String seq_num;


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
