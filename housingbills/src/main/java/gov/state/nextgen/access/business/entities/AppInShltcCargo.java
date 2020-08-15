package gov.state.nextgen.access.business.entities;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "APP_IN_SHLTC")
public class AppInShltcCargo implements java.io.Serializable {

	@EmbeddedId
	private AppInShltcPrimaryKey appInShltcPrimaryKey;
	
	
	@Transient
	boolean isDirty = false;
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

}
