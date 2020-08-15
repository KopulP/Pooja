package gov.state.nextgen.access.business.entities;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "APP_IN_MEDCR")
public class AppInMedcrCargo  implements java.io.Serializable{

	@EmbeddedId
	private AppInMedcrPrimaryKey appInMedcrPrimaryKey;
	
	@Transient
	boolean isDirty = false;
	private String hlth_ins_care_ind;
	private String hlth_ins_care_num;
	private String parta_beg_dt;
	private String parta_prem_amt;
	private String parta_prem_ind;
	private String parta_prem_payr_cd;
	private String partb_beg_dt;
	private String partb_prem_amt;
	private String partb_prem_ind;
	private String partb_prem_payr_cd;
	private String rec_cplt_ind;
	private String retr_resp;
	private String parta_ettl_resp;
	private String partb_ettl_resp;
	private String railroad_retirement_num;
	// EDSP CP ADDED
	private String medicare_claim_num;
	private String parta_end_dt;
	private String partb_end_dt;
	private String partd_ettl_resp;
	private String partd_beg_dt;
	private String partd_end_dt;
	private String partd_prem_amt;
	private String src_app_ind;
	private String partd_prem_payr_cd;
	private String partd_prem_ind;
	private String chg_dt;
	private String adapt_record_id;
	
	
	public String getAdapt_record_id() {
		return adapt_record_id;
	}

	public void setAdapt_record_id(String adapt_record_id) {
		this.adapt_record_id = adapt_record_id;
	}

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
	 * @return the partd_prem_ind
	 */
	public String getPartd_prem_ind() {
		return partd_prem_ind;
	}

	/**
	 * @param partd_prem_ind
	 *            the partd_prem_ind to set
	 */
	public void setPartd_prem_ind(final String partd_prem_ind) {
		this.partd_prem_ind = partd_prem_ind;
	}

	/**
	 * @return the medicare_claim_num
	 */
	public String getMedicare_claim_num() {
		return medicare_claim_num;
	}

	/**
	 * @param medicare_claim_num
	 *            the medicare_claim_num to set
	 */
	public void setMedicare_claim_num(final String medicare_claim_num) {
		this.medicare_claim_num = medicare_claim_num;
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
	 * @return the parta_end_dt
	 */
	public String getParta_end_dt() {
		return parta_end_dt;
	}

	/**
	 * @param parta_end_dt
	 *            the parta_end_dt to set
	 */
	public void setParta_end_dt(final String parta_end_dt) {
		this.parta_end_dt = parta_end_dt;
	}

	/**
	 * @return the partb_end_dt
	 */
	public String getPartb_end_dt() {
		return partb_end_dt;
	}

	/**
	 * @param partb_end_dt
	 *            the partb_end_dt to set
	 */
	public void setPartb_end_dt(final String partb_end_dt) {
		this.partb_end_dt = partb_end_dt;
	}

	/**
	 * @return the partd_ettl_resp
	 */
	public String getPartd_ettl_resp() {
		return partd_ettl_resp;
	}

	/**
	 * @param partd_ettl_resp
	 *            the partd_ettl_resp to set
	 */
	public void setPartd_ettl_resp(final String partd_ettl_resp) {
		this.partd_ettl_resp = partd_ettl_resp;
	}

	/**
	 * @return the partd_beg_dt
	 */
	public String getPartd_beg_dt() {
		return partd_beg_dt;
	}

	/**
	 * @param partd_beg_dt
	 *            the partd_beg_dt to set
	 */
	public void setPartd_beg_dt(final String partd_beg_dt) {
		this.partd_beg_dt = partd_beg_dt;
	}

	/**
	 * @return the partd_end_dt
	 */
	public String getPartd_end_dt() {
		return partd_end_dt;
	}

	/**
	 * @param partd_end_dt
	 *            the partd_end_dt to set
	 */
	public void setPartd_end_dt(final String partd_end_dt) {
		this.partd_end_dt = partd_end_dt;
	}


	/**
	 * @param partd_prem_amt
	 *            the partd_prem_amt to set
	 */
	public void setPartd_prem_amt(final String partd_prem_amt) {
		this.partd_prem_amt = partd_prem_amt;
	}

	/**
	 * @return the partd_prem_payr_cd
	 */
	public String getPartd_prem_payr_cd() {
		return partd_prem_payr_cd;
	}

	/**
	 * @param partd_prem_payr_cd
	 *            the partd_prem_payr_cd to set
	 */
	public void setPartd_prem_payr_cd(final String partd_prem_payr_cd) {
		this.partd_prem_payr_cd = partd_prem_payr_cd;
	}


	/**
	 * returns the hlth_ins_care_ind value.
	 */
	public String getHlth_ins_care_ind() {
		return hlth_ins_care_ind;
	}

	/**
	 * sets the hlth_ins_care_ind value.
	 */
	public void setHlth_ins_care_ind(final String hlth_ins_care_ind) {
		this.hlth_ins_care_ind = hlth_ins_care_ind;
	}

	/**
	 * returns the hlth_ins_care_num value.
	 */
	public String getHlth_ins_care_num() {
		return hlth_ins_care_num;
	}

	/**
	 * sets the hlth_ins_care_num value.
	 */
	public void setHlth_ins_care_num(final String hlth_ins_care_num) {
		this.hlth_ins_care_num = hlth_ins_care_num;
	}

	/**
	 * returns the parta_beg_dt value.
	 */
	public String getParta_beg_dt() {
		return parta_beg_dt;
	}

	/**
	 * sets the parta_beg_dt value.
	 */
	public void setParta_beg_dt(final String parta_beg_dt) {
		this.parta_beg_dt = parta_beg_dt;
	}

	

	/**
	 * sets the parta_prem_amt value.
	 */
	public void setParta_prem_amt(final String parta_prem_amt) {
		this.parta_prem_amt = parta_prem_amt;
	}

	/**
	 * returns the parta_prem_ind value.
	 */
	public String getParta_prem_ind() {
		return parta_prem_ind;
	}

	/**
	 * sets the parta_prem_ind value.
	 */
	public void setParta_prem_ind(final String parta_prem_ind) {
		this.parta_prem_ind = parta_prem_ind;
	}

	/**
	 * returns the parta_prem_payr_cd value.
	 */
	public String getParta_prem_payr_cd() {
		return parta_prem_payr_cd;
	}

	/**
	 * sets the parta_prem_payr_cd value.
	 */
	public void setParta_prem_payr_cd(final String parta_prem_payr_cd) {
		this.parta_prem_payr_cd = parta_prem_payr_cd;
	}

	/**
	 * returns the partb_beg_dt value.
	 */
	public String getPartb_beg_dt() {
		return partb_beg_dt;
	}

	/**
	 * sets the partb_beg_dt value.
	 */
	public void setPartb_beg_dt(final String partb_beg_dt) {
		this.partb_beg_dt = partb_beg_dt;
	}

	

	/**
	 * sets the partb_prem_amt value.
	 */
	public void setPartb_prem_amt(final String partb_prem_amt) {
		this.partb_prem_amt = partb_prem_amt;
	}

	/**
	 * returns the partb_prem_ind value.
	 */
	public String getPartb_prem_ind() {
		return partb_prem_ind;
	}

	/**
	 * sets the partb_prem_ind value.
	 */
	public void setPartb_prem_ind(final String partb_prem_ind) {
		this.partb_prem_ind = partb_prem_ind;
	}

	/**
	 * returns the partb_prem_payr_cd value.
	 */
	public String getPartb_prem_payr_cd() {
		return partb_prem_payr_cd;
	}

	/**
	 * sets the partb_prem_payr_cd value.
	 */
	public void setPartb_prem_payr_cd(final String partb_prem_payr_cd) {
		this.partb_prem_payr_cd = partb_prem_payr_cd;
	}

	/**
	 * returns the rec_cplt_ind value.
	 */
	public String getRec_cplt_ind() {
		return rec_cplt_ind;
	}

	/**
	 * sets the rec_cplt_ind value.
	 */
	public void setRec_cplt_ind(final String rec_cplt_ind) {
		this.rec_cplt_ind = rec_cplt_ind;
	}

	/**
	 * returns the retr_resp value.
	 */
	public String getRetr_resp() {
		return retr_resp;
	}

	/**
	 * sets the retr_resp value.
	 */
	public void setRetr_resp(final String retr_resp) {
		this.retr_resp = retr_resp;
	}

	/**
	 * returns the parta_ettl_resp value.
	 */
	public String getParta_ettl_resp() {
		return parta_ettl_resp;
	}

	/**
	 * sets the parta_ettl_resp value.
	 */
	public void setParta_ettl_resp(final String parta_ettl_resp) {
		this.parta_ettl_resp = parta_ettl_resp;
	}

	/**
	 * returns the partb_ettl_resp value.
	 */
	public String getPartb_ettl_resp() {
		return partb_ettl_resp;
	}

	/**
	 * sets the partb_ettl_resp value.
	 */
	public void setPartb_ettl_resp(final String partb_ettl_resp) {
		this.partb_ettl_resp = partb_ettl_resp;
	}

	/**
	 * returns the Railroad_retirement_no value.
	 */
	public String getRailroad_retirement_num() {
		return railroad_retirement_num;
	}

	/**
	 * sets the Railroad_retirement_no value.
	 */
	public void setRailroad_retirement_num(final String railroad_retirement_num) {
		this.railroad_retirement_num = railroad_retirement_num;
	}

	
}
