package gov.state.nextgen.access.business.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "RMB_RQST")
public class RmbRqstCargo implements Serializable{

	
	@Transient
	boolean isDirty = false;
	
	@EmbeddedId
	private RmbRqstPrimaryKey rmbRqstPrimaryKey;
	
	private String adr_chg_stat_ind;
	private String app_typ;
	private String aset_xfer_stat_ind;
	private String authorized_rep_stat_ind;

	private String bury_aset_add_ind;
	private String bury_aset_stat_ind;
	private String case_num;
	private String dpnd_care_stat_ind;

	private String dabl_stat_ind;
	private String drug_feln_stat_ind;
	private String due_dt;
	private String ecf_stat_cd;
	private String empl_stat_ind;
	private String help_othr_stat_ind;
	private String hshl_chg_stat_ind;
	private String hous_bill_stat_ind;
	private String irwe_stat_ind;
	private String iknd_incm_stat_ind;
	private String li_aset_add_ind;
	private String li_aset_stat_ind;
	private String lqd_aset_add_ind;
	private String lqd_aset_stat_ind;
	private String mapp_stat_ind;
	private String med_bills_stat_ind;
	private String med_cvrg_stat_ind;
	private String othr_incm_stat_ind;
	private String pdf_lang_cd;
	private String prsn_add_stat_ind;
	private String prsn_move_stat_ind;
	private String prsn_prop_stat_ind;
	private String preg_chg_stat_ind;
	private String real_aset_add_ind;
	private String real_aset_stat_ind;
	private String rcnt_acdt_stat_ind;
	private String room_brd_stat_ind;
	private String schl_enrl_stat_ind;
	private String self_empl_stat_ind;
	private String stat_cd;
	private String sbmt_tms;
	private String sprt_oblg_stat_ind;
	private String trb_cmdy_stat_ind;
	private String updt_dt;
	private String util_bill_stat_ind;
	private String veh_aset_add_ind;
	private String veh_aset_stat_ind;
	private String past_cvrg_stat_ind;
	private String fee_rqr_ind;
	private String cla_due_dt;
	// EDSP Starts
	private String parole_violation_stat_ind;
	private String head_of_household_stat_ind;
	private String person_moved_in_stat_ind;

	// EDSP AI RMB
	private String health_insurance_chg_stat_ind;
	private String liquid_asset_cash_stat_ind;
	private String liquid_asset_bank_acc_stat_ind;
	private String liquid_asset_other_stat_ind;

	private String medicare_assist_req_stat_ind;

	private String current_past_pndg_stat_ind;

	private String snap_shelter_standard_exp_ind;
	private String app_start_dt;
	private String app_end_dt;

	private String child_care_stat_ind;
	private String child_obligation_stat_ind;
	private String med_bill_stat_ind;
	private String tax_claim_dependant_ind;
	private String tax_deduct_stat_ind;
	private String before_tax_deduction_ind;

	// For Other Bills Question

	private String primaryIndvScore;
	
	private String mailAddrAddInd;
	private String mailAddrChgInd;  

	/**
	 * @return the child_care_stat_ind
	 */

	/**
	 * @return the child_obligation_stat_ind
	 */
	public String getChild_obligation_stat_ind() {
		return child_obligation_stat_ind;
	}

	/**
	 * @return the tax_claim_dependant_ind
	 */
	public String getTax_claim_dependant_ind() {
		return tax_claim_dependant_ind;
	}

	/**
	 * @param tax_claim_dependant_ind the tax_claim_dependant_ind to set
	 */
	public void setTax_claim_dependant_ind(final String tax_claim_dependant_ind) {
		this.tax_claim_dependant_ind = tax_claim_dependant_ind;
	}

	/**
	 * @return the med_bill_stat_ind
	 */
	public String getMed_bill_stat_ind() {
		return med_bill_stat_ind;
	}

	/**
	 * @param med_bill_stat_ind the med_bill_stat_ind to set
	 */
	public void setMed_bill_stat_ind(final String med_bill_stat_ind) {
		this.med_bill_stat_ind = med_bill_stat_ind;
	}

	/**
	 * @param child_obligation_stat_ind the child_obligation_stat_ind to set
	 */
	public void setChild_obligation_stat_ind(final String child_obligation_stat_ind) {
		this.child_obligation_stat_ind = child_obligation_stat_ind;
	}

	/**
	 * @return the child_care_stat_ind
	 */
	public String getChild_care_stat_ind() {
		return child_care_stat_ind;
	}

	/**
	 * @param child_care_stat_ind the child_care_stat_ind to set
	 */
	public void setChild_care_stat_ind(final String child_care_stat_ind) {
		this.child_care_stat_ind = child_care_stat_ind;
	}

	/**
	 * @return the child_Care_stat_ind
	 */

	public String getPerson_moved_in_stat_ind() {
		return person_moved_in_stat_ind;
	}

	public void setPerson_moved_in_stat_ind(final String person_moved_in_stat_ind) {
		this.person_moved_in_stat_ind = person_moved_in_stat_ind;
	}

	public String getApp_start_dt() {
		return app_start_dt;
	}

	public void setApp_start_dt(final String app_start_dt) {
		this.app_start_dt = app_start_dt;
	}

	public String getApp_end_dt() {
		return app_end_dt;
	}

	public void setApp_end_dt(final String app_end_dt) {
		this.app_end_dt = app_end_dt;
	}

	public String getSnap_shelter_standard_exp_ind() {
		return snap_shelter_standard_exp_ind;
	}

	public void setSnap_shelter_standard_exp_ind(final String snap_shelter_standard_exp_ind) {
		this.snap_shelter_standard_exp_ind = snap_shelter_standard_exp_ind;
	}

	public String getAuthorized_rep_stat_ind() {
		return authorized_rep_stat_ind;
	}

	public void setAuthorized_rep_stat_ind(final String authorized_rep_stat_ind) {
		this.authorized_rep_stat_ind = authorized_rep_stat_ind;
	}

	public String getCurrent_past_pndg_stat_ind() {
		return current_past_pndg_stat_ind;
	}

	public void setCurrent_past_pndg_stat_ind(final String current_past_pndg_stat_ind) {
		this.current_past_pndg_stat_ind = current_past_pndg_stat_ind;
	}

	public String getMedicare_assist_req_stat_ind() {
		return medicare_assist_req_stat_ind;
	}

	public void setMedicare_assist_req_stat_ind(final String medicare_assist_req_stat_ind) {
		this.medicare_assist_req_stat_ind = medicare_assist_req_stat_ind;
	}

	public String getLiquid_asset_other_stat_ind() {
		return liquid_asset_other_stat_ind;
	}

	public void setLiquid_asset_other_stat_ind(final String liquid_asset_other_stat_ind) {
		this.liquid_asset_other_stat_ind = liquid_asset_other_stat_ind;
	}

	public String getLiquid_asset_bank_acc_stat_ind() {
		return liquid_asset_bank_acc_stat_ind;
	}

	public void setLiquid_asset_bank_acc_stat_ind(final String liquid_asset_bank_acc_stat_ind) {
		this.liquid_asset_bank_acc_stat_ind = liquid_asset_bank_acc_stat_ind;
	}

	public String getLiquid_asset_cash_stat_ind() {
		return liquid_asset_cash_stat_ind;
	}

	public void setLiquid_asset_cash_stat_ind(final String liquid_asset_cash_stat_ind) {
		this.liquid_asset_cash_stat_ind = liquid_asset_cash_stat_ind;
	}

	/**
	 * @return Returns the health_insurance_change_stat_ind.
	 */
	public String getHealth_insurance_chg_stat_ind() {
		return health_insurance_chg_stat_ind;
	}

	/**
	 * @param health_insurance_chg_stat_ind
	 *            The health_insurance_chg_stat_ind to set.
	 */
	public void setHealth_insurance_chg_stat_ind(final String health_insurance_chg_stat_ind) {
		this.health_insurance_chg_stat_ind = health_insurance_chg_stat_ind;
	}

	/**
	 * @return Returns the parole_violation_stat_ind.
	 */
	public String getParole_violation_stat_ind() {
		return parole_violation_stat_ind;
	}

	/**
	 * @param parole_violation_stat_ind
	 *            The parole_violation_stat_ind to set.
	 */
	public void setParole_violation_stat_ind(final String parole_violation_stat_ind) {
		this.parole_violation_stat_ind = parole_violation_stat_ind;
	}

	/**
	 * @return Returns the head_of_household_stat_ind.
	 */
	public String getHead_of_household_stat_ind() {
		return head_of_household_stat_ind;
	}

	/**
	 * @param head_of_household_stat_ind
	 *            The head_of_household_stat_ind to set.
	 */
	public void setHead_of_household_stat_ind(final String head_of_household_stat_ind) {
		this.head_of_household_stat_ind = head_of_household_stat_ind;
	}

	// EDSP Ends

	/**
	 * @return Returns the fee_rqr_ind.
	 */
	public String getFee_rqr_ind() {
		return fee_rqr_ind;
	}

	/**
	 * @param fee_rqr_ind
	 *            The fee_rqr_ind to set.
	 */
	public void setFee_rqr_ind(final String fee_rqr_ind) {
		this.fee_rqr_ind = fee_rqr_ind;
	}

	/**
	 * @return Returns the past_cvrg_stat_ind.
	 */
	public String getPast_cvrg_stat_ind() {
		return past_cvrg_stat_ind;
	}

	/**
	 * @param past_cvrg_stat_ind
	 *            The past_cvrg_stat_ind to set.
	 */
	public void setPast_cvrg_stat_ind(final String past_cvrg_stat_ind) {
		this.past_cvrg_stat_ind = past_cvrg_stat_ind;
	}

	

	/**
	 * returns the adr_chg_stat_ind value.
	 */
	public String getAdr_chg_stat_ind() {
		return adr_chg_stat_ind;
	}

	/**
	 * returns the app_typ value.
	 */
	public String getApp_typ() {
		return app_typ;
	}

	/**
	 * returns the aset_xfer_stat_ind value.
	 */
	public String getAset_xfer_stat_ind() {
		return aset_xfer_stat_ind;
	}

	/**
	 * returns the bury_aset_add_ind value.
	 */
	public String getBury_aset_add_ind() {
		return bury_aset_add_ind;
	}

	/**
	 * returns the bury_aset_stat_ind value.
	 */
	public String getBury_aset_stat_ind() {
		return bury_aset_stat_ind;
	}

	/**
	 * returns the case_num value.
	 */
	public String getCase_num() {
		return case_num;
	}

	/**
	 * returns the dpnd_care_stat_ind value.
	 */
	public String getDpnd_care_stat_ind() {
		return dpnd_care_stat_ind;
	}

	/**
	 * returns the dabl_stat_ind value.
	 */
	public String getDabl_stat_ind() {
		return dabl_stat_ind;
	}

	/**
	 * returns the drug_feln_stat_ind value.
	 */
	public String getDrug_feln_stat_ind() {
		return drug_feln_stat_ind;
	}

	/**
	 * returns the due_dt value.
	 */
	public String getDue_dt() {
		return due_dt;
	}

	/**
	 * returns the ecf_stat_cd value.
	 */
	public String getEcf_stat_cd() {
		return ecf_stat_cd;
	}

	/**
	 * returns the empl_stat_ind value.
	 */
	public String getEmpl_stat_ind() {
		return empl_stat_ind;
	}

	/**
	 * returns the help_othr_stat_ind value.
	 */
	public String getHelp_othr_stat_ind() {
		return help_othr_stat_ind;
	}

	/**
	 * returns the hshl_chg_stat_ind value.
	 */
	public String getHshl_chg_stat_ind() {
		return hshl_chg_stat_ind;
	}

	/**
	 * returns the hous_bill_stat_ind value.
	 */
	public String getHous_bill_stat_ind() {
		return hous_bill_stat_ind;
	}

	/**
	 * returns the irwe_stat_ind value.
	 */
	public String getIrwe_stat_ind() {
		return irwe_stat_ind;
	}

	/**
	 * returns the iknd_incm_stat_ind value.
	 */
	public String getIknd_incm_stat_ind() {
		return iknd_incm_stat_ind;
	}

	/**
	 * returns the li_aset_add_ind value.
	 */
	public String getLi_aset_add_ind() {
		return li_aset_add_ind;
	}

	/**
	 * returns the li_aset_stat_ind value.
	 */
	public String getLi_aset_stat_ind() {
		return li_aset_stat_ind;
	}

	/**
	 * returns the lqd_aset_add_ind value.
	 */
	public String getLqd_aset_add_ind() {
		return lqd_aset_add_ind;
	}

	/**
	 * returns the lqd_aset_stat_ind value.
	 */
	public String getLqd_aset_stat_ind() {
		return lqd_aset_stat_ind;
	}

	/**
	 * returns the mapp_stat_ind value.
	 */
	public String getMapp_stat_ind() {
		return mapp_stat_ind;
	}

	/**
	 * returns the med_bills_stat_ind value.
	 */
	public String getMed_bills_stat_ind() {
		return med_bills_stat_ind;
	}

	/**
	 * returns the med_cvrg_stat_ind value.
	 */
	public String getMed_cvrg_stat_ind() {
		return med_cvrg_stat_ind;
	}

	/**
	 * returns the othr_incm_stat_ind value.
	 */
	public String getOthr_incm_stat_ind() {
		return othr_incm_stat_ind;
	}

	/**
	 * returns the pdf_lang_cd value.
	 */
	public String getPdf_lang_cd() {
		return pdf_lang_cd;
	}

	/**
	 * returns the prsn_add_stat_ind value.
	 */
	public String getPrsn_add_stat_ind() {
		return prsn_add_stat_ind;
	}

	/**
	 * returns the prsn_move_stat_ind value.
	 */
	public String getPrsn_move_stat_ind() {
		return prsn_move_stat_ind;
	}

	/**
	 * returns the prsn_prop_stat_ind value.
	 */
	public String getPrsn_prop_stat_ind() {
		return prsn_prop_stat_ind;
	}

	/**
	 * returns the preg_chg_stat_ind value.
	 */
	public String getPreg_chg_stat_ind() {
		return preg_chg_stat_ind;
	}

	/**
	 * returns the real_aset_add_ind value.
	 */
	public String getReal_aset_add_ind() {
		return real_aset_add_ind;
	}

	/**
	 * returns the real_aset_stat_ind value.
	 */
	public String getReal_aset_stat_ind() {
		return real_aset_stat_ind;
	}

	/**
	 * returns the rcnt_acdt_stat_ind value.
	 */
	public String getRcnt_acdt_stat_ind() {
		return rcnt_acdt_stat_ind;
	}

	/**
	 * returns the room_brd_stat_ind value.
	 */
	public String getRoom_brd_stat_ind() {
		return room_brd_stat_ind;
	}

	/**
	 * returns the schl_enrl_stat_ind value.
	 */
	public String getSchl_enrl_stat_ind() {
		return schl_enrl_stat_ind;
	}

	/**
	 * returns the self_empl_stat_ind value.
	 */
	public String getSelf_empl_stat_ind() {
		return self_empl_stat_ind;
	}

	/**
	 * returns the stat_cd value.
	 */
	public String getStat_cd() {
		return stat_cd;
	}

	/**
	 * returns the sbmt_tms value.
	 */
	public String getSbmt_tms() {
		return sbmt_tms;
	}

	/**
	 * returns the sprt_oblg_stat_ind value.
	 */
	public String getSprt_oblg_stat_ind() {
		return sprt_oblg_stat_ind;
	}

	/**
	 * returns the trb_cmdy_stat_ind value.
	 */
	public String getTrb_cmdy_stat_ind() {
		return trb_cmdy_stat_ind;
	}

	/**
	 * returns the updt_dt value.
	 */
	public String getUpdt_dt() {
		return updt_dt;
	}

	/**
	 * returns the util_bill_stat_ind value.
	 */
	public String getUtil_bill_stat_ind() {
		return util_bill_stat_ind;
	}

	/**
	 * returns the veh_aset_add_ind value.
	 */
	public String getVeh_aset_add_ind() {
		return veh_aset_add_ind;
	}

	/**
	 * returns the veh_aset_stat_ind value.
	 */
	public String getVeh_aset_stat_ind() {
		return veh_aset_stat_ind;
	}

	

	/**
	 * sets the adr_chg_stat_ind value.
	 */
	public void setAdr_chg_stat_ind(final String adr_chg_stat_ind) {
		this.adr_chg_stat_ind = adr_chg_stat_ind;
	}

	/**
	 * sets the app_typ value.
	 */
	public void setApp_typ(final String app_typ) {
		this.app_typ = app_typ;
	}

	/**
	 * sets the aset_xfer_stat_ind value.
	 */
	public void setAset_xfer_stat_ind(final String aset_xfer_stat_ind) {
		this.aset_xfer_stat_ind = aset_xfer_stat_ind;
	}

	/**
	 * sets the bury_aset_add_ind value.
	 */
	public void setBury_aset_add_ind(final String bury_aset_add_ind) {
		this.bury_aset_add_ind = bury_aset_add_ind;
	}

	/**
	 * sets the bury_aset_stat_ind value.
	 */
	public void setBury_aset_stat_ind(final String bury_aset_stat_ind) {
		this.bury_aset_stat_ind = bury_aset_stat_ind;
	}

	/**
	 * sets the case_num value.
	 */
	public void setCase_num(final String case_num) {
		this.case_num = case_num;
	}

	/**
	 * sets the dpnd_care_stat_ind value.
	 */
	public void setDpnd_care_stat_ind(final String dpnd_care_stat_ind) {
		this.dpnd_care_stat_ind = dpnd_care_stat_ind;
	}

	/**
	 * sets the dabl_stat_ind value.
	 */
	public void setDabl_stat_ind(final String dabl_stat_ind) {
		this.dabl_stat_ind = dabl_stat_ind;
	}

	/**
	 * sets the drug_feln_stat_ind value.
	 */
	public void setDrug_feln_stat_ind(final String drug_feln_stat_ind) {
		this.drug_feln_stat_ind = drug_feln_stat_ind;
	}

	/**
	 * sets the due_dt value.
	 */
	public void setDue_dt(final String due_dt) {
		this.due_dt = due_dt;
	}

	/**
	 * sets the ecf_stat_cd value.
	 */
	public void setEcf_stat_cd(final String ecf_stat_cd) {
		this.ecf_stat_cd = ecf_stat_cd;
	}

	/**
	 * sets the empl_stat_ind value.
	 */
	public void setEmpl_stat_ind(final String empl_stat_ind) {
		this.empl_stat_ind = empl_stat_ind;
	}

	/**
	 * sets the help_othr_stat_ind value.
	 */
	public void setHelp_othr_stat_ind(final String help_othr_stat_ind) {
		this.help_othr_stat_ind = help_othr_stat_ind;
	}

	/**
	 * sets the hshl_chg_stat_ind value.
	 */
	public void setHshl_chg_stat_ind(final String hshl_chg_stat_ind) {
		this.hshl_chg_stat_ind = hshl_chg_stat_ind;
	}

	/**
	 * sets the hous_bill_stat_ind value.
	 */
	public void setHous_bill_stat_ind(final String hous_bill_stat_ind) {
		this.hous_bill_stat_ind = hous_bill_stat_ind;
	}

	/**
	 * sets the irwe_stat_ind value.
	 */
	public void setIrwe_stat_ind(final String irwe_stat_ind) {
		this.irwe_stat_ind = irwe_stat_ind;
	}

	/**
	 * sets the iknd_incm_stat_ind value.
	 */
	public void setIknd_incm_stat_ind(final String iknd_incm_stat_ind) {
		this.iknd_incm_stat_ind = iknd_incm_stat_ind;
	}

	/**
	 * sets the li_aset_add_ind value.
	 */
	public void setLi_aset_add_ind(final String li_aset_add_ind) {
		this.li_aset_add_ind = li_aset_add_ind;
	}

	/**
	 * sets the li_aset_stat_ind value.
	 */
	public void setLi_aset_stat_ind(final String li_aset_stat_ind) {
		this.li_aset_stat_ind = li_aset_stat_ind;
	}

	/**
	 * sets the lqd_aset_add_ind value.
	 */
	public void setLqd_aset_add_ind(final String lqd_aset_add_ind) {
		this.lqd_aset_add_ind = lqd_aset_add_ind;
	}

	/**
	 * sets the lqd_aset_stat_ind value.
	 */
	public void setLqd_aset_stat_ind(final String lqd_aset_stat_ind) {
		this.lqd_aset_stat_ind = lqd_aset_stat_ind;
	}

	/**
	 * sets the mapp_stat_ind value.
	 */
	public void setMapp_stat_ind(final String mapp_stat_ind) {
		this.mapp_stat_ind = mapp_stat_ind;
	}

	/**
	 * sets the med_bills_stat_ind value.
	 */
	public void setMed_bills_stat_ind(final String med_bills_stat_ind) {
		this.med_bills_stat_ind = med_bills_stat_ind;
	}

	/**
	 * sets the med_cvrg_stat_ind value.
	 */
	public void setMed_cvrg_stat_ind(final String med_cvrg_stat_ind) {
		this.med_cvrg_stat_ind = med_cvrg_stat_ind;
	}

	/**
	 * sets the othr_incm_stat_ind value.
	 */
	public void setOthr_incm_stat_ind(final String othr_incm_stat_ind) {
		this.othr_incm_stat_ind = othr_incm_stat_ind;
	}

	/**
	 * sets the pdf_lang_cd value.
	 */
	public void setPdf_lang_cd(final String pdf_lang_cd) {
		this.pdf_lang_cd = pdf_lang_cd;
	}

	/**
	 * sets the prsn_add_stat_ind value.
	 */
	public void setPrsn_add_stat_ind(final String prsn_add_stat_ind) {
		this.prsn_add_stat_ind = prsn_add_stat_ind;
	}

	/**
	 * sets the prsn_move_stat_ind value.
	 */
	public void setPrsn_move_stat_ind(final String prsn_move_stat_ind) {
		this.prsn_move_stat_ind = prsn_move_stat_ind;
	}

	/**
	 * sets the prsn_prop_stat_ind value.
	 */
	public void setPrsn_prop_stat_ind(final String prsn_prop_stat_ind) {
		this.prsn_prop_stat_ind = prsn_prop_stat_ind;
	}

	/**
	 * sets the preg_chg_stat_ind value.
	 */
	public void setPreg_chg_stat_ind(final String preg_chg_stat_ind) {
		this.preg_chg_stat_ind = preg_chg_stat_ind;
	}

	/**
	 * sets the real_aset_add_ind value.
	 */
	public void setReal_aset_add_ind(final String real_aset_add_ind) {
		this.real_aset_add_ind = real_aset_add_ind;
	}

	/**
	 * sets the real_aset_stat_ind value.
	 */
	public void setReal_aset_stat_ind(final String real_aset_stat_ind) {
		this.real_aset_stat_ind = real_aset_stat_ind;
	}

	/**
	 * sets the rcnt_acdt_stat_ind value.
	 */
	public void setRcnt_acdt_stat_ind(final String rcnt_acdt_stat_ind) {
		this.rcnt_acdt_stat_ind = rcnt_acdt_stat_ind;
	}

	/**
	 * sets the room_brd_stat_ind value.
	 */
	public void setRoom_brd_stat_ind(final String room_brd_stat_ind) {
		this.room_brd_stat_ind = room_brd_stat_ind;
	}

	/**
	 * sets the schl_enrl_stat_ind value.
	 */
	public void setSchl_enrl_stat_ind(final String schl_enrl_stat_ind) {
		this.schl_enrl_stat_ind = schl_enrl_stat_ind;
	}

	/**
	 * sets the self_empl_stat_ind value.
	 */
	public void setSelf_empl_stat_ind(final String self_empl_stat_ind) {
		this.self_empl_stat_ind = self_empl_stat_ind;
	}

	/**
	 * sets the stat_cd value.
	 */
	public void setStat_cd(final String stat_cd) {
		this.stat_cd = stat_cd;
	}

	/**
	 * sets the sbmt_tms value.
	 */
	public void setSbmt_tms(final String sbmt_tms) {
		this.sbmt_tms = sbmt_tms;
	}

	/**
	 * sets the sprt_oblg_stat_ind value.
	 */
	public void setSprt_oblg_stat_ind(final String sprt_oblg_stat_ind) {
		this.sprt_oblg_stat_ind = sprt_oblg_stat_ind;
	}

	/**
	 * sets the trb_cmdy_stat_ind value.
	 */
	public void setTrb_cmdy_stat_ind(final String trb_cmdy_stat_ind) {
		this.trb_cmdy_stat_ind = trb_cmdy_stat_ind;
	}

	/**
	 * sets the updt_dt value.
	 */
	public void setUpdt_dt(final String updt_dt) {
		this.updt_dt = updt_dt;
	}

	/**
	 * sets the util_bill_stat_ind value.
	 */
	public void setUtil_bill_stat_ind(final String util_bill_stat_ind) {
		this.util_bill_stat_ind = util_bill_stat_ind;
	}

	/**
	 * sets the veh_aset_add_ind value.
	 */
	public void setVeh_aset_add_ind(final String veh_aset_add_ind) {
		this.veh_aset_add_ind = veh_aset_add_ind;
	}

	/**
	 * sets the veh_aset_stat_ind value.
	 */
	public void setVeh_aset_stat_ind(final String veh_aset_stat_ind) {
		this.veh_aset_stat_ind = veh_aset_stat_ind;
	}

	/**
	 * returns the PrimaryKey object.
	 */
	

	/**
	 * @return the mailAddrAddInd
	 */
	public String getMailAddrAddInd() {
		return mailAddrAddInd;
	}

	/**
	 * @param mailAddrAddInd the mailAddrAddInd to set
	 */
	public void setMailAddrAddInd(String mailAddrAddInd) {
		this.mailAddrAddInd = mailAddrAddInd;
	}

	/**
	 * @return the mailAddrChgInd
	 */
	public String getMailAddrChgInd() {
		return mailAddrChgInd;
	}

	/**
	 * @param mailAddrChgInd the mailAddrChgInd to set
	 */
	public void setMailAddrChgInd(String mailAddrChgInd) {
		this.mailAddrChgInd = mailAddrChgInd;
	}
	
}
