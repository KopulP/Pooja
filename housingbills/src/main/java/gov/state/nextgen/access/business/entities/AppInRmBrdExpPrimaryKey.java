package gov.state.nextgen.access.business.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AppInRmBrdExpPrimaryKey implements Serializable, IPrimaryKey {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String app_num;
	private String payr_indv_seq_num;
	private String seq_num;
	private String src_app_ind;

	/**
	 * returns the app_num value.
	 */
	public String getApp_num() {
		return app_num;
	}

	/**
	 * returns the payr_indv_seq_num value.
	 */
	public String getPayr_indv_seq_num() {
		return payr_indv_seq_num;
	}

	/**
	 * returns the seq_num value.
	 */
	public String getSeq_num() {
		return seq_num;
	}

	/**
	 * returns the src_app_ind value.
	 */
	public String getSrc_app_ind() {
		return src_app_ind;
	}

	/**
	 * sets the app_num value.
	 */
	public void setApp_num(final String app_num) {
		this.app_num = app_num;
	}

	/**
	 * sets the payr_indv_seq_num value.
	 */
	public void setPayr_indv_seq_num(final String payr_indv_seq_num) {
		this.payr_indv_seq_num = payr_indv_seq_num;
	}

	/**
	 * sets the seq_num value.
	 */
	public void setSeq_num(final String seq_num) {
		this.seq_num = seq_num;
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
		return new StringBuilder().append("APP_IN_RM_BRD_EXP: ").append("app_num=").append(app_num).append("payr_indv_seq_num=")
				.append(payr_indv_seq_num).append("seq_num=").append(seq_num).append("src_app_ind=").append(src_app_ind).toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((app_num == null) ? 0 : app_num.trim().hashCode());
		result = (prime * result) + ((payr_indv_seq_num == null) ? 0 : payr_indv_seq_num.trim().hashCode());
		result = (prime * result) + ((seq_num == null) ? 0 : seq_num.trim().hashCode());
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
		final AppInRmBrdExpPrimaryKey other = (AppInRmBrdExpPrimaryKey) obj;
		if (app_num == null) {
			if (other.app_num != null) {
				return false;
			}
		} else if (!app_num.equals(other.app_num)) {
			return false;
		}
		if (payr_indv_seq_num == null) {
			if (other.payr_indv_seq_num != null) {
				return false;
			}
		} else if (!payr_indv_seq_num.equals(other.payr_indv_seq_num)) {
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