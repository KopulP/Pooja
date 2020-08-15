package gov.state.nextgen.access.business.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class CpAppInIncomeTaxDedPrimaryKey implements Serializable, IPrimaryKey{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String app_num;
	private String indv_seq_num;
	private String src_app_ind;
	private String seq_num;

	/**
	 *returns the app_num value.
	 */
	public String getApp_num() {
		return app_num;
	}

	/**
	 *returns the indv_seq_num value.
	 */
	public String getIndv_seq_num() {
		return indv_seq_num;
	}

	/**
	 *returns the src_app_ind value.
	 */
	public String getSrc_app_ind() {
		return src_app_ind;
	}

	/**
	 *sets the app_num value.
	 */
	public void setApp_num(final String app_num) {
		this.app_num = app_num;
	}

	/**
	 *sets the indv_seq_num value.
	 */
	public void setIndv_seq_num(final String indv_seq_num) {
		this.indv_seq_num = indv_seq_num;
	}

	/**
	 *sets the src_app_ind value.
	 */
	public void setSrc_app_ind(final String src_app_ind) {
		this.src_app_ind = src_app_ind;
	}

	public String getSeq_num() {
		return seq_num;
	}

	public void setSeq_num(String seq_num) {
		this.seq_num = seq_num;
	}

	/**
	 *returns the string value of cargo.
	 */
	@Override
	public String inspectPrimaryKey() {
		return new StringBuilder().append("CP_APP_IN_INCOME_TAX_DED: ").append("app_num=").append(app_num).append("indv_seq_num=")
				.append(indv_seq_num).append("src_app_ind=").append(src_app_ind).append("seq_num=").append(seq_num).toString();
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = (31 * hash) + (null == app_num ? 0 : app_num.trim().hashCode());
		hash = (31 * hash) + (null == indv_seq_num ? 0 : indv_seq_num.trim().hashCode());
		hash = (31 * hash) + (null == src_app_ind ? 0 : src_app_ind.trim().hashCode());
		hash = (31 * hash) + (null == seq_num ? 0 : seq_num.trim().hashCode());

		return hash;
	}
}
