package gov.state.nextgen.access.business.entities;

import javax.persistence.Embeddable;

@Embeddable
public class CpAppEsgginPrimaryKey implements java.io.Serializable, IPrimaryKey {

	
	private static final long serialVersionUID = 1L;
	private String app_num;
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
		return new StringBuilder().append("CP_APP_ESGIN: ").append("app_num=").append(app_num).append("seq_num=").append(seq_num)
				.append("src_app_ind=").append(src_app_ind).toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((app_num == null) ? 0 : app_num.trim().hashCode());
		result = (prime * result) + ((seq_num == null) ? 0 : seq_num.trim().hashCode());
		result = (prime * result) + ((src_app_ind == null) ? 0 : src_app_ind.trim().hashCode());
		result = (prime * result) + ((src_app_ind == null) ? 0 : src_app_ind.trim().hashCode());
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
		final CpAppEsgginPrimaryKey other = (CpAppEsgginPrimaryKey) obj;
		if (app_num == null) {
			if (other.app_num != null) {
				return false;
			}
		} else if (!app_num.equals(other.app_num)) {
			return false;
		}
		if (seq_num == null) {
			if (other.seq_num != null) {
				return false;
			}
		} else if (!seq_num.equals(other.seq_num)) {
			return false;
		}
		if (src_app_ind == null) {
			if (other.src_app_ind != null) {
				return false;
			}
		} else if (!src_app_ind.equals(other.src_app_ind)) {
			return false;
		}
		return true;
	}

}
