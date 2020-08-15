package gov.state.nextgen.access.business.entities;

import javax.persistence.Embeddable;

@Embeddable
public class CpAppAuthRepPrimaryKey implements java.io.Serializable, IPrimaryKey {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String app_num;
	private String rep_code;
	private String src_app_ind;
	private String seq_num;

	public String getSeq_num() {
		return seq_num;
	}

	public void setSeq_num(final String seq_num) {
		this.seq_num = seq_num;
	}

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
	 * returns the src_app_ind value.
	 */
	public String getSrc_app_ind() {
		return src_app_ind;
	}

	/**
	 * @return the rep_code
	 */
	public String getRep_code() {
		return rep_code;
	}

	/**
	 * @param rep_code
	 *            the rep_code to set
	 */
	public void setRep_code(final String rep_code) {
		this.rep_code = rep_code;
	}

	/**
	 * sets the src_app_ind value.
	 */
	public void setSrc_app_ind(final String src_app_ind) {
		this.src_app_ind = src_app_ind;
	}

	/**
	 * returns the string value of cargo.
	 */
	@Override
	public String inspectPrimaryKey() {
		return new StringBuilder().append("CP_APP_AUTH_REP: ").append("app_num=").append(app_num).append("rep_code=").append(rep_code)
				.append("src_app_ind=").append(src_app_ind).toString();
	}

	}
