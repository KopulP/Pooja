/*
 * 
 */
package gov.state.nextgen.access.business.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * This java bean contains the entities of OTHR_RSN
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date Jun 10 14:50:42 EDT 2009 Modified By: Modified on: PCR#
 */

public class APP_IN_SHLTC_Cargo extends AbstractCargo implements java.io.Serializable, IHistoryType6 {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.impl.APP_IN_SHLTC";

	boolean isDirty = false;
	private String app_num;
	private String indv_seq_num;
	private String seq_num;
	private String src_app_ind;
	private String chg_eff_dt;
	private String rec_cplt_ind;
	private String shlt_oblg_amt;
	private String shlt_oblg_ind;
	private String shlt_typ;
	private String pay_freq;
	private String Other_Housing_paymts;
	// EDSP CP Starts - Housing Bills - Shelter Expense
	private String someone_else_rent_pay_ind;
	private String not_living_reason_cd;
	private String intend_to_return_ind;
	private String someone_else_living_ind;
	private String housing_bill_ind;

	public String getHousing_bill_ind() {
		return housing_bill_ind;
	}

	public void setHousing_bill_ind(final String housing_bill_ind) {
		this.housing_bill_ind = housing_bill_ind;
	}

	/**
	 * returns the someone_else_living_ind value.
	 */
	public String getSomeone_else_living_ind() {
		return someone_else_living_ind;
	}

	/**
	 * sets the someone_else_living_ind value.
	 */
	public void setSomeone_else_living_ind(final String someone_else_living_ind) {
		this.someone_else_living_ind = someone_else_living_ind;
	}

	/**
	 * returns the intend_to_return_ind value.
	 */
	public String getIntend_to_return_ind() {
		return intend_to_return_ind;
	}

	/**
	 * sets the intend_to_return_ind value.
	 */
	public void setIntend_to_return_ind(final String intend_to_return_ind) {
		this.intend_to_return_ind = intend_to_return_ind;
	}

	/**
	 * returns the not_living_reason_cd value.
	 */
	public String getNot_living_reason_cd() {
		return not_living_reason_cd;
	}

	/**
	 * sets the not_living_reason_cd value.
	 */
	public void setNot_living_reason_cd(final String not_living_reason_cd) {
		this.not_living_reason_cd = not_living_reason_cd;
	}

	/**
	 * returns the someone_else_rent_pay_ind value.
	 */
	public String getSomeone_else_rent_pay_ind() {
		return someone_else_rent_pay_ind;
	}

	/**
	 * sets the someone_else_rent_pay_ind value.
	 */
	public void setSomeone_else_rent_pay_ind(final String someone_else_rent_pay_ind) {
		this.someone_else_rent_pay_ind = someone_else_rent_pay_ind;
	}

	// EDSP CP ends - Housing Bills
	/**
	 * returns the app_num value.
	 */
	public String getApp_num() {
		return app_num;
	}

	/**
	 * returns the indv_seq_num value.
	 */
	public String getIndv_seq_num() {
		return indv_seq_num;
	}

	/**
	 * returns the seq_num value.
	 */
	@Override
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
	 * returns the chg_eff_dt value.
	 */
	public String getChg_eff_dt() {
		return chg_eff_dt;
	}

	/**
	 * returns the rec_cplt_ind value.
	 */
	public String getRec_cplt_ind() {
		return rec_cplt_ind;
	}

	/**
	 * returns the shlt_oblg_amt value.
	 */
	public String getShlt_oblg_amt() {
		return displayFormatter.getNumberFormat(shlt_oblg_amt);
	}

	/**
	 * returns the shlt_oblg_ind value.
	 */
	public String getShlt_oblg_ind() {
		return shlt_oblg_ind;
	}

	/**
	 * returns the shlt_typ value.
	 */
	public String getShlt_typ() {
		return shlt_typ;
	}

	/**
	 * returns the pay_freq value.
	 */
	public String getPay_freq() {
		return pay_freq;
	}

	/**
	 * returns the othr_housing_paymt value.
	 */
	public String getOther_Housing_paymts() {
		return Other_Housing_paymts;
	}

	/**
	 * sets the app_num value.
	 */
	public void setApp_num(final String app_num) {
		this.app_num = app_num;
	}

	/**
	 * sets the indv_seq_num value.
	 */
	public void setIndv_seq_num(final String indv_seq_num) {
		this.indv_seq_num = indv_seq_num;
	}

	/**
	 * sets the seq_num value.
	 */
	@Override
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
	 * sets the chg_eff_dt value.
	 */
	public void setChg_eff_dt(final String chg_eff_dt) {
		this.chg_eff_dt = chg_eff_dt;
	}

	/**
	 * sets the rec_cplt_ind value.
	 */
	public void setRec_cplt_ind(final String rec_cplt_ind) {
		this.rec_cplt_ind = rec_cplt_ind;
	}

	/**
	 * sets the shlt_oblg_amt value.
	 */
	public void setShlt_oblg_amt(final String shlt_oblg_amt) {
		this.shlt_oblg_amt = shlt_oblg_amt;
	}

	/**
	 * sets the shlt_oblg_ind value.
	 */
	public void setShlt_oblg_ind(final String shlt_oblg_ind) {
		this.shlt_oblg_ind = shlt_oblg_ind;
	}

	/**
	 * sets the shlt_typ value.
	 */
	public void setShlt_typ(final String shlt_typ) {
		this.shlt_typ = shlt_typ;
	}

	/**
	 * sets the pay_freq value.
	 */
	public void setPay_freq(final String pay_freq) {
		this.pay_freq = pay_freq;
	}

	/**
	 * sets the othr_housing_paymt value.
	 */
	public void setOther_Housing_paymts(final String Other_Housing_paymts) {
		this.Other_Housing_paymts = Other_Housing_paymts;
	}

	/**
	 * returns the PrimaryKey object.
	 */
	@Override
	public IPrimaryKey getPrimaryKey() {
		final AppInShltcPrimaryKey key = new AppInShltcPrimaryKey();
		key.setApp_num(getApp_num());
		key.setIndv_seq_num(getIndv_seq_num());
		key.setSeq_num(getSeq_num());
		key.setSrc_app_ind(getSrc_app_ind());

		return key;
	}

	/**
	 * returns the PACKAGE name.
	 */
	public String getPackage() {
		return PACKAGE;
	}

	/**
	 * returns the string value of cargo.
	 */
	@Override
	public String inspectCargo() {
		return new StringBuilder().append("APP_IN_SHLTC: ").append("app_num=").append(app_num).append("indv_seq_num=").append(indv_seq_num)
				.append("seq_num=").append(seq_num).append("src_app_ind=").append(src_app_ind).append("chg_eff_dt=").append(chg_eff_dt)
				.append("rec_cplt_ind=").append(rec_cplt_ind).append("shlt_oblg_amt=").append(shlt_oblg_amt).append("shlt_oblg_ind=")
				.append(shlt_oblg_ind).append("shlt_typ=").append(shlt_typ).append("pay_freq=").append(pay_freq).append("othr_housing_paymt=")
				.append(Other_Housing_paymts).toString();
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
		result = (prime * result) + ((Other_Housing_paymts == null) ? 0 : Other_Housing_paymts.trim().hashCode());
		result = (prime * result) + ((app_num == null) ? 0 : app_num.trim().hashCode());
		result = (prime * result) + ((chg_eff_dt == null) ? 0 : chg_eff_dt.trim().hashCode());
		result = (prime * result) + ((housing_bill_ind == null) ? 0 : housing_bill_ind.trim().hashCode());
		result = (prime * result) + ((indv_seq_num == null) ? 0 : indv_seq_num.trim().hashCode());
		result = (prime * result) + ((intend_to_return_ind == null) ? 0 : intend_to_return_ind.trim().hashCode());
		result = (prime * result) + ((not_living_reason_cd == null) ? 0 : not_living_reason_cd.trim().hashCode());
		result = (prime * result) + ((pay_freq == null) ? 0 : pay_freq.trim().hashCode());
		result = (prime * result) + ((rec_cplt_ind == null) ? 0 : rec_cplt_ind.trim().hashCode());
		result = (prime * result) + ((seq_num == null) ? 0 : seq_num.trim().hashCode());
		result = (prime * result) + ((shlt_oblg_amt == null) ? 0 : shlt_oblg_amt.trim().hashCode());
		result = (prime * result) + ((shlt_oblg_ind == null) ? 0 : shlt_oblg_ind.trim().hashCode());
		result = (prime * result) + ((shlt_typ == null) ? 0 : shlt_typ.trim().hashCode());
		result = (prime * result) + ((someone_else_living_ind == null) ? 0 : someone_else_living_ind.trim().hashCode());
		result = (prime * result) + ((someone_else_rent_pay_ind == null) ? 0 : someone_else_rent_pay_ind.trim().hashCode());
		result = (prime * result) + ((src_app_ind == null) ? 0 : src_app_ind.trim().hashCode());
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
		final APP_IN_SHLTC_Cargo other = (APP_IN_SHLTC_Cargo) obj;
		if (Other_Housing_paymts == null) {
			if (other.Other_Housing_paymts != null) {
				return false;
			}
		} else if (!Other_Housing_paymts.equals(other.Other_Housing_paymts)) {
			return false;
		}
		if (app_num == null) {
			if (other.app_num != null) {
				return false;
			}
		} else if (!app_num.equals(other.app_num)) {
			return false;
		}
		if (chg_eff_dt == null) {
			if (other.chg_eff_dt != null) {
				return false;
			}
		} else if (!chg_eff_dt.equals(other.chg_eff_dt)) {
			return false;
		}
		if (housing_bill_ind == null) {
			if (other.housing_bill_ind != null) {
				return false;
			}
		} else if (!housing_bill_ind.equals(other.housing_bill_ind)) {
			return false;
		}
		if (indv_seq_num == null) {
			if (other.indv_seq_num != null) {
				return false;
			}
		} else if (!indv_seq_num.equals(other.indv_seq_num)) {
			return false;
		}
		if (intend_to_return_ind == null) {
			if (other.intend_to_return_ind != null) {
				return false;
			}
		} else if (!intend_to_return_ind.equals(other.intend_to_return_ind)) {
			return false;
		}
		if (not_living_reason_cd == null) {
			if (other.not_living_reason_cd != null) {
				return false;
			}
		} else if (!not_living_reason_cd.equals(other.not_living_reason_cd)) {
			return false;
		}
		if (pay_freq == null) {
			if (other.pay_freq != null) {
				return false;
			}
		} else if (!pay_freq.equals(other.pay_freq)) {
			return false;
		}
		if (rec_cplt_ind == null) {
			if (other.rec_cplt_ind != null) {
				return false;
			}
		} else if (!rec_cplt_ind.equals(other.rec_cplt_ind)) {
			return false;
		}
		if (seq_num == null) {
			if (other.seq_num != null) {
				return false;
			}
		} else if (!seq_num.equals(other.seq_num)) {
			return false;
		}
		if (shlt_oblg_amt == null) {
			if (other.shlt_oblg_amt != null) {
				return false;
			}
		} else if (!shlt_oblg_amt.equals(other.shlt_oblg_amt)) {
			return false;
		}
		if (shlt_oblg_ind == null) {
			if (other.shlt_oblg_ind != null) {
				return false;
			}
		} else if (!shlt_oblg_ind.equals(other.shlt_oblg_ind)) {
			return false;
		}
		if (shlt_typ == null) {
			if (other.shlt_typ != null) {
				return false;
			}
		} else if (!shlt_typ.equals(other.shlt_typ)) {
			return false;
		}
		if (someone_else_living_ind == null) {
			if (other.someone_else_living_ind != null) {
				return false;
			}
		} else if (!someone_else_living_ind.equals(other.someone_else_living_ind)) {
			return false;
		}
		if (someone_else_rent_pay_ind == null) {
			if (other.someone_else_rent_pay_ind != null) {
				return false;
			}
		} else if (!someone_else_rent_pay_ind.equals(other.someone_else_rent_pay_ind)) {
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

	/**
	 * compares the given cargo with this cargo and returns the changed
	 * attribute-value Map.
	 */
	public Map compareAttributes(final APP_IN_SHLTC_Cargo aCargo) {
		final Map changedAttributeValue = new HashMap();
		if (!((aCargo.getApp_num() == null) && (app_num == null)) && !((aCargo.getApp_num() != null) && aCargo.getApp_num().equals(app_num))) {
			changedAttributeValue.put("app_num", aCargo.getApp_num());
		}
		if (!((aCargo.getIndv_seq_num() == null) && (indv_seq_num == null))
				&& !((aCargo.getIndv_seq_num() != null) && aCargo.getIndv_seq_num().equals(indv_seq_num))) {
			changedAttributeValue.put("indv_seq_num", aCargo.getIndv_seq_num());
		}
		if (!((aCargo.getSeq_num() == null) && (seq_num == null)) && !((aCargo.getSeq_num() != null) && aCargo.getSeq_num().equals(seq_num))) {
			changedAttributeValue.put("seq_num", aCargo.getSeq_num());
		}
		if (!((aCargo.getSrc_app_ind() == null) && (src_app_ind == null))
				&& !((aCargo.getSrc_app_ind() != null) && aCargo.getSrc_app_ind().equals(src_app_ind))) {
			changedAttributeValue.put("src_app_ind", aCargo.getSrc_app_ind());
		}
		if (!((aCargo.getChg_eff_dt() == null) && (chg_eff_dt == null))
				&& !((aCargo.getChg_eff_dt() != null) && aCargo.getChg_eff_dt().equals(chg_eff_dt))) {
			changedAttributeValue.put("chg_eff_dt", aCargo.getChg_eff_dt());
		}
		if (!((aCargo.getRec_cplt_ind() == null) && (rec_cplt_ind == null))
				&& !((aCargo.getRec_cplt_ind() != null) && aCargo.getRec_cplt_ind().equals(rec_cplt_ind))) {
			changedAttributeValue.put("rec_cplt_ind", aCargo.getRec_cplt_ind());
		}
		if (!((aCargo.getShlt_oblg_amt() == null) && (shlt_oblg_amt == null))
				&& !((aCargo.getShlt_oblg_amt() != null) && aCargo.getShlt_oblg_amt().equals(getShlt_oblg_amt()))) {
			changedAttributeValue.put("shlt_oblg_amt", aCargo.getShlt_oblg_amt());
		}
		if (!((aCargo.getShlt_oblg_ind() == null) && (shlt_oblg_ind == null))
				&& !((aCargo.getShlt_oblg_ind() != null) && aCargo.getShlt_oblg_ind().equals(shlt_oblg_ind))) {
			changedAttributeValue.put("shlt_oblg_ind", aCargo.getShlt_oblg_ind());
		}
		if (!((aCargo.getShlt_typ() == null) && (shlt_typ == null)) && !((aCargo.getShlt_typ() != null) && aCargo.getShlt_typ().equals(shlt_typ))) {
			changedAttributeValue.put("shlt_typ", aCargo.getShlt_typ());
		}
		return changedAttributeValue;
	}

}