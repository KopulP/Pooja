package gov.state.nextgen.access.business.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CP_ABCHS")
public class CpAbchsCargo implements Serializable{

	
	@EmbeddedId
	private CpAbchsPrimaryKey cpAbchs;
	
	@Transient
	boolean isDirty = false;

	private String prvd_org_nam;
	private String prvd_addr_line1;
	private String prvd_addr_line2;
	private String prvd_addr_city;
	private String prvd_addr_state_cd;
	private String prvd_addr_zip;
	private String prvd_phone_num;
	private String dpnd_care_exp_rsn_cd;
	private String dependent_care_exp_start_dt;
	private String dependent_care_exp_end_dt;
	private String ecp_id;
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
	public String getDependent_care_exp_end_dt() {
		return dependent_care_exp_end_dt;
	}

	public void setDependent_care_exp_end_dt(final String dependent_care_exp_end_dt) {
		this.dependent_care_exp_end_dt = dependent_care_exp_end_dt;
	}

	private String pay_freq;
	private String dpnd_care_exp_amt;
	private String paid_in_seq_num;
	private String rec_cplt_ind;

	private String src_app_ind;
	private String loopingInd;
	private String addrZip4;

	public String getLoopingInd() {
		return loopingInd;
	}

	public void setLoopingInd(final String loopingInd) {
		this.loopingInd = loopingInd;
	}

	/**
	 * @return the src_app_ind
	 */
	public String getSrc_app_ind() {
		return src_app_ind;
	}

	/**
	 * @param src_app_ind the src_app_ind to set
	 */
	public void setSrc_app_ind(final String src_app_ind) {
		this.src_app_ind = src_app_ind;
	}

	/**
	 * @return the rec_cplt_ind
	 */
	public String getRec_cplt_ind() {
		return rec_cplt_ind;
	}

	/**
	 * @param rec_cplt_ind
	 *            the rec_cplt_ind to set
	 */
	public void setRec_cplt_ind(final String rec_cplt_ind) {
		this.rec_cplt_ind = rec_cplt_ind;
	}

	/**
	 * @return the isDirty
	 */
	public boolean isDirty() {
		return isDirty;
	}

	/**
	 * @return the paid_in_seq_num
	 */
	public String getPaid_in_seq_num() {
		return paid_in_seq_num;
	}

	/**
	 * @param paid_in_seq_num
	 *            the paid_in_seq_num to set
	 */
	public void setPaid_in_seq_num(final String paid_in_seq_num) {
		this.paid_in_seq_num = paid_in_seq_num;
	}

	/**
	 * @param isDirty
	 *            the isDirty to set
	 */
	public void setDirty(final boolean isDirty) {
		this.isDirty = isDirty;
	}


	/**
	 * @return the addrZip4
	 */
	public String getAddrZip4() {
		return addrZip4;
	}

	/**
	 * @param addrZip4 the addrZip4 to set
	 */
	public void setAddrZip4(String addrZip4) {
		this.addrZip4 = addrZip4;
	}

	public CpAbchsPrimaryKey getCpAbchs() {
		return cpAbchs;
	}

	public void setCpAbchs(CpAbchsPrimaryKey cpAbchs) {
		this.cpAbchs = cpAbchs;
	}

	public String getPrvd_org_nam() {
		return prvd_org_nam;
	}

	public void setPrvd_org_nam(String prvd_org_nam) {
		this.prvd_org_nam = prvd_org_nam;
	}

	public String getPrvd_addr_line1() {
		return prvd_addr_line1;
	}

	public void setPrvd_addr_line1(String prvd_addr_line1) {
		this.prvd_addr_line1 = prvd_addr_line1;
	}

	public String getPrvd_addr_line2() {
		return prvd_addr_line2;
	}

	public void setPrvd_addr_line2(String prvd_addr_line2) {
		this.prvd_addr_line2 = prvd_addr_line2;
	}

	public String getPrvd_addr_city() {
		return prvd_addr_city;
	}

	public void setPrvd_addr_city(String prvd_addr_city) {
		this.prvd_addr_city = prvd_addr_city;
	}

	public String getPrvd_addr_state_cd() {
		return prvd_addr_state_cd;
	}

	public void setPrvd_addr_state_cd(String prvd_addr_state_cd) {
		this.prvd_addr_state_cd = prvd_addr_state_cd;
	}

	public String getPrvd_addr_zip() {
		return prvd_addr_zip;
	}

	public void setPrvd_addr_zip(String prvd_addr_zip) {
		this.prvd_addr_zip = prvd_addr_zip;
	}

	public String getPrvd_phone_num() {
		return prvd_phone_num;
	}

	public void setPrvd_phone_num(String prvd_phone_num) {
		this.prvd_phone_num = prvd_phone_num;
	}

	public String getDpnd_care_exp_rsn_cd() {
		return dpnd_care_exp_rsn_cd;
	}

	public void setDpnd_care_exp_rsn_cd(String dpnd_care_exp_rsn_cd) {
		this.dpnd_care_exp_rsn_cd = dpnd_care_exp_rsn_cd;
	}

	public String getDependent_care_exp_start_dt() {
		return dependent_care_exp_start_dt;
	}

	public void setDependent_care_exp_start_dt(String dependent_care_exp_start_dt) {
		this.dependent_care_exp_start_dt = dependent_care_exp_start_dt;
	}

	public String getEcp_id() {
		return ecp_id;
	}

	public void setEcp_id(String ecp_id) {
		this.ecp_id = ecp_id;
	}

	public String getPay_freq() {
		return pay_freq;
	}

	public void setPay_freq(String pay_freq) {
		this.pay_freq = pay_freq;
	}

	public String getDpnd_care_exp_amt() {
		return dpnd_care_exp_amt;
	}

	public void setDpnd_care_exp_amt(String dpnd_care_exp_amt) {
		this.dpnd_care_exp_amt = dpnd_care_exp_amt;
	}

	}
