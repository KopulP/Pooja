package gov.state.nextgen.access.business.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Cp_App_In_Deduction")
public class CpAppInDeductionCargo  implements Serializable{

	
	@Transient
	boolean isDirty = false;
	
	@EmbeddedId
	private CpAppInDeductionPrimaryKey cpAppInDeductionPrimaryKey;
	
	private String ecp_id;
	private String src_app_ind;
	private String exp_typ;

	private String exp_amt;
	private String rec_cplt_ind;
	private String exp_end_date;
	private String court_order_pay_chld_sup_ind;
	private String court_order_pay_amt;
	private String chld_sup_payee_nam;
	private String loopingInd;
	private String pay_freq_cd;
	private String chg_dt;
	
	/**
     * @return the chg_dt
     */
    public String getChg_dt() {
        return chg_dt;
    }

    /**
     * @param chg_dt the chg_dt to set
     */
    public void setChg_dt(String chg_dt) {
        this.chg_dt = chg_dt;
    }

	/**
	 * @return the ecp_id
	 */
	public String getEcp_id() {
		return ecp_id;
	}

	/**
	 * @param ecp_id the ecp_id to set
	 */
	public void setEcp_id(final String ecp_id) {
		this.ecp_id = ecp_id;
	}

	
	public boolean isDirty() {
		return isDirty;
	}

	
	public void setDirty(final boolean isDirty) {
		this.isDirty = isDirty;
	}

	public String getCourt_order_pay_chld_sup_ind() {
		return court_order_pay_chld_sup_ind;
	}

	public void setCourt_order_pay_chld_sup_ind(final String court_order_pay_chld_sup_ind) {
		this.court_order_pay_chld_sup_ind = court_order_pay_chld_sup_ind;
	}

	public String getCourt_order_pay_amt() {
		return court_order_pay_amt;
	}

	public void setCourt_order_pay_amt(final String court_order_pay_amt) {
		this.court_order_pay_amt = court_order_pay_amt;
	}

	public String getChld_sup_payee_nam() {
		return chld_sup_payee_nam;
	}

	public void setChld_sup_payee_nam(final String chld_sup_payee_nam) {
		this.chld_sup_payee_nam = chld_sup_payee_nam;
	}

	public String getExp_end_date() {
		return exp_end_date;
	}

	public void setExp_end_date(final String exp_end_date) {
		this.exp_end_date = exp_end_date;
	}

	
	/**
	 * returns the src_app_ind value.
	 */
	public String getSrc_app_ind() {
		return src_app_ind;
	}

	/**
	 * returns the exp_typ value.
	 */
	public String getExp_typ() {
		return exp_typ;
	}

	

	/**
	 * returns the rec_cplt_ind value.
	 */
	public String getRec_cplt_ind() {
		return rec_cplt_ind;
	}

	
	/**
	 * sets the src_app_ind value.
	 */
	public void setSrc_app_ind(final String src_app_ind) {
		this.src_app_ind = src_app_ind;
	}

	/**
	 * sets the exp_typ value.
	 */
	public void setExp_typ(final String exp_typ) {
		this.exp_typ = exp_typ;
	}

	/**
	 * sets the exp_amt value.
	 */
	public void setExp_amt(final String exp_amt) {
		this.exp_amt = exp_amt;
	}

	/**
	 * sets the rec_cplt_ind value.
	 */
	public void setRec_cplt_ind(final String rec_cplt_ind) {
		this.rec_cplt_ind = rec_cplt_ind;
	}

	/**
	 * @return the loopingInd
	 */
	public String getLoopingInd() {
		return loopingInd;
	}

	/**
	 * @param loopingInd
	 *            the loopingInd to set
	 */
	public void setLoopingInd(final String loopingInd) {
		this.loopingInd = loopingInd;
	}

	/**
	 * @return the pay_freq_cd
	 */
	public String getPay_freq_cd() {
		return pay_freq_cd;
	}

	}
