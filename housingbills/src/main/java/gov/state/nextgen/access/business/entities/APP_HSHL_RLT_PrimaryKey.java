/*
 * 
 */
package gov.state.nextgen.access.business.entities;

import java.io.Serializable;

/**
 * This java bean contains the primary keys for the table APP_HSHL_RLT
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date Jun 3 17:14:45 EDT 2009 Modified By: Modified on: PCR#
 */
public class APP_HSHL_RLT_PrimaryKey implements Serializable, IPrimaryKey {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String app_num;
	private String ref_indv_seq_num;
	private String src_indv_seq_num;
	private String src_app_ind;

	/**
	 * returns the app_num value.
	 */
	public String getApp_num() {
		return app_num;
	}

	/**
	 * returns the ref_indv_seq_num value.
	 */
	public String getRef_indv_seq_num() {
		return ref_indv_seq_num;
	}

	/**
	 * returns the src_indv_seq_num value.
	 */
	public String getSrc_indv_seq_num() {
		return src_indv_seq_num;
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
	 * sets the ref_indv_seq_num value.
	 */
	public void setRef_indv_seq_num(final String ref_indv_seq_num) {
		this.ref_indv_seq_num = ref_indv_seq_num;
	}

	/**
	 * sets the src_indv_seq_num value.
	 */
	public void setSrc_indv_seq_num(final String src_indv_seq_num) {
		this.src_indv_seq_num = src_indv_seq_num;
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
		return new StringBuilder().append("APP_HSHL_RLT: ").append("app_num=").append(app_num).append("ref_indv_seq_num=").append(ref_indv_seq_num)
				.append("src_indv_seq_num=").append(src_indv_seq_num).append("src_app_ind=").append(src_app_ind).toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((app_num == null) ? 0 : app_num.trim().hashCode());
		result = (prime * result) + ((ref_indv_seq_num == null) ? 0 : ref_indv_seq_num.trim().hashCode());
		result = (prime * result) + ((src_app_ind == null) ? 0 : src_app_ind.trim().hashCode());
		result = (prime * result) + ((src_indv_seq_num == null) ? 0 : src_indv_seq_num.trim().hashCode());
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
		final APP_HSHL_RLT_PrimaryKey other = (APP_HSHL_RLT_PrimaryKey) obj;
		if (app_num == null) {
			if (other.app_num != null) {
				return false;
			}
		} else if (!app_num.equals(other.app_num)) {
			return false;
		}
		if (ref_indv_seq_num == null) {
			if (other.ref_indv_seq_num != null) {
				return false;
			}
		} else if (!ref_indv_seq_num.equals(other.ref_indv_seq_num)) {
			return false;
		}
		if (src_app_ind == null) {
			if (other.src_app_ind != null) {
				return false;
			}
		} else if (!src_app_ind.equals(other.src_app_ind)) {
			return false;
		}
		if (src_indv_seq_num == null) {
			if (other.src_indv_seq_num != null) {
				return false;
			}
		} else if (!src_indv_seq_num.equals(other.src_indv_seq_num)) {
			return false;
		}
		return true;
	}
}
