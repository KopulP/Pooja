package gov.state.nextgen.access.business.entities;

import javax.persistence.Embeddable;

import gov.state.nextgen.access.management.constants.FwConstants;

@Embeddable
public class AppInHouBillsPrimaryKey  implements java.io.Serializable, IPrimaryKey {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String app_num = FwConstants.EMPTY_STRING;
	private String seq_num = FwConstants.EMPTY_STRING;
	private String indv_seq_num = FwConstants.EMPTY_STRING;
	private String src_app_ind = FwConstants.EMPTY_STRING;
	private String bill_type = FwConstants.EMPTY_STRING;

	/**
	 *
	 */
	public AppInHouBillsPrimaryKey() {
	}

	/**
	 * @return the app_num
	 */
	public String getApp_num() {
		return app_num;
	}

	/**
	 * @param app_num
	 *            the app_num to set
	 */
	public void setApp_num(final String app_num) {
		this.app_num = app_num;
	}

	/**
	 * @return the seq_num
	 */
	public String getSeq_num() {
		return seq_num;
	}

	/**
	 * @param seq_num
	 *            the seq_num to set
	 */
	public void setSeq_num(final String seq_num) {
		this.seq_num = seq_num;
	}

	/**
	 * @return the indv_seq_num
	 */
	public String getIndv_seq_num() {
		return indv_seq_num;
	}

	/**
	 * @param indv_seq_num
	 *            the indv_seq_num to set
	 */
	public void setIndv_seq_num(final String indv_seq_num) {
		this.indv_seq_num = indv_seq_num;
	}

	/**
	 * @return the src_app_ind
	 */
	public String getSrc_app_ind() {
		return src_app_ind;
	}

	/**
	 * @param src_app_ind
	 *            the src_app_ind to set
	 */
	public void setSrc_app_ind(final String src_app_ind) {
		this.src_app_ind = src_app_ind;
	}

	/**
	 * @return the bill_type
	 */
	public String getBill_type() {
		return bill_type;
	}

	/**
	 * @param bill_type
	 *            the bill_type to set
	 */
	public void setBill_type(final String bill_type) {
		this.bill_type = bill_type;
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
		result = (prime * result) + ((app_num == null) ? 0 : app_num.hashCode());
		result = (prime * result) + ((bill_type == null) ? 0 : bill_type.hashCode());
		result = (prime * result) + ((indv_seq_num == null) ? 0 : indv_seq_num.hashCode());
		result = (prime * result) + ((seq_num == null) ? 0 : seq_num.hashCode());
		result = (prime * result) + ((src_app_ind == null) ? 0 : src_app_ind.hashCode());
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
		if (!(obj instanceof AppInHouBillsPrimaryKey)) {
			return false;
		}
		final AppInHouBillsPrimaryKey other = (AppInHouBillsPrimaryKey) obj;
		if (app_num == null) {
			if (other.app_num != null) {
				return false;
			}
		} else if (!app_num.equals(other.app_num)) {
			return false;
		}
		if (bill_type == null) {
			if (other.bill_type != null) {
				return false;
			}
		} else if (!bill_type.equals(other.bill_type)) {
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
		if (src_app_ind == null) {
			if (other.src_app_ind != null) {
				return false;
			}
		} else if (!src_app_ind.equals(other.src_app_ind)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("AppInHouBillsPrimaryKey [app_num=");
		builder.append(app_num);
		builder.append(", seq_num=");
		builder.append(seq_num);
		builder.append(", indv_seq_num=");
		builder.append(indv_seq_num);
		builder.append(", src_app_ind=");
		builder.append(src_app_ind);
		builder.append(", bill_type=");
		builder.append(bill_type);
		builder.append("]");
		return builder.toString();
	}

	public String inspectPrimaryKey() {
		final StringBuilder builder = new StringBuilder();
		builder.append("APP_IN_HOU_BILLS: app_num=");
		builder.append(app_num);
		builder.append("seq_num=");
		builder.append(seq_num);
		builder.append("indv_seq_num=");
		builder.append(indv_seq_num);
		builder.append("src_app_ind=");
		builder.append(src_app_ind);
		builder.append("bill_type=");
		builder.append(bill_type);
		return builder.toString();

	}

}
