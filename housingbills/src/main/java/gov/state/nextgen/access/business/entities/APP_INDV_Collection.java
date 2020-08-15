/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This class acts as a wrapper for one or many cargos of APP_INDV
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date Jun 2 20:06:07 EDT 2009 Modified By: Modified on: PCR#
 */
public class APP_INDV_Collection extends AbstractCollection {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.impl.APP_INDV";

	/**
	 * returns the PACKAGE name.
	 */
	@Override
	public String getPACKAGE() {
		return PACKAGE;
	}

	/**
	 * Adds the given cargo to the collection.
	 */
	public void addCargo(final AppIndvCargo aNewCargo) {
		add(aNewCargo);
	}

	/**
	 * Sets cargo array into collection.
	 */
	public void setResults(final AppIndvCargo[] cbArray) {
		clear();
		for (int i = 0; i < cbArray.length; i++) {
			add(cbArray[i]);
		}
	}

	/**
	 * Sets cargo into collection at the given index.
	 */
	public void setCargo(final int idx, final AppIndvCargo aCargo) {
		set(idx, aCargo);
	}

	/**
	 * returns all the values in the Collection as Cargo Array.
	 */
	public AppIndvCargo[] getResults() {
		final AppIndvCargo[] cbArray = new AppIndvCargo[size()];
		toArray(cbArray);
		return cbArray;
	}

	/**
	 * returns a cargo from the Collection for the given index.
	 */
	public AppIndvCargo getCargo(final int idx) {
		return (AppIndvCargo) get(idx);
	}

	/**
	 * This one for clone Results.
	 */
	public AppIndvCargo[] cloneResults() {
		final AppIndvCargo[] rescargo = new AppIndvCargo[size()];
		for (int i = 0; i < size(); i++) {
			final AppIndvCargo cargo = getCargo(i);
			rescargo[i] = new AppIndvCargo();
			rescargo[i].setEcp_id(cargo.getEcp_id());
			rescargo[i].setAln_sponser_sw(cargo.getAln_sponser_sw());
			rescargo[i].setBrth_dt(cargo.getBrth_dt());
			rescargo[i].setFst_nam(cargo.getFst_nam());
			rescargo[i].setIntn_res_resp(cargo.getIntn_res_resp());
			rescargo[i].setLang_cd(cargo.getLang_cd());
			rescargo[i].setLast_nam(cargo.getLast_nam());
			rescargo[i].setLive_arng_typ(cargo.getLive_arng_typ());
			rescargo[i].setMid_init(cargo.getMid_init());
			rescargo[i].setMig_farm_wrkr_sw(cargo.getMig_farm_wrkr_sw());
			rescargo[i].setMrtl_stat_cd(cargo.getMrtl_stat_cd());
			rescargo[i].setPreg_resp(cargo.getPreg_resp());
			rescargo[i].setPrim_prsn_sw(cargo.getPrim_prsn_sw());
			rescargo[i].setRec_cplt_ind(cargo.getRec_cplt_ind());
			rescargo[i].setRes_wi_sw(cargo.getRes_wi_sw());
			rescargo[i].setRlvn_ind(cargo.getRlvn_ind());
			rescargo[i].setSex_ind(cargo.getSex_ind());
			rescargo[i].setSs_num_app_dt(cargo.getSs_num_app_dt());
			rescargo[i].setSsn_num(cargo.getSsn_num());
			rescargo[i].setUs_ctzn_sw(cargo.getUs_ctzn_sw());
			rescargo[i].setAi_ind(cargo.getAi_ind());
			rescargo[i].setAsia_ind(cargo.getAsia_ind());
			rescargo[i].setBlk_ind(cargo.getBlk_ind());
			rescargo[i].setHspc_ind(cargo.getHspc_ind());
			rescargo[i].setPac_isl_ind(cargo.getPac_isl_ind());
			rescargo[i].setWht_ind(cargo.getWht_ind());
			rescargo[i].setChld_out_home_resp(cargo.getChld_out_home_resp());
			rescargo[i].setChld_trb_mbr_resp(cargo.getChld_trb_mbr_resp());
			rescargo[i].setTrb_mbr_resp(cargo.getTrb_mbr_resp());
			rescargo[i].setNon_hspc_ind(cargo.getNon_hspc_ind());
			rescargo[i].setDt_leave_facty(cargo.getDt_leave_facty());
			rescargo[i].setVet_resp(cargo.getVet_resp());
			rescargo[i].setVet_act_duty_resp(cargo.getVet_act_duty_resp());
			rescargo[i].setSps_deceased_vet_resp(cargo.getSps_deceased_vet_resp());
			rescargo[i].setChld_deceased_vet_resp(cargo.getChld_deceased_vet_resp());
			rescargo[i].setDisable_vet_resp(cargo.getDisable_vet_resp());
			rescargo[i].setJob_commitment_resp(cargo.getJob_commitment_resp());
			rescargo[i].setChld_pa_act_duty_resp(cargo.getChld_pa_act_duty_resp());

			// EDSP CP starts: fields added
			rescargo[i].setPlace_of_birth_cd(cargo.getPlace_of_birth_cd());
			rescargo[i].setRes_va_sw(cargo.getRes_va_sw());
			rescargo[i].setSrc_app_ind(cargo.getSrc_app_ind());
			rescargo[i].setTribe_cd(cargo.getTribe_cd());
			rescargo[i].setAlien_num(cargo.getAlien_num());
			rescargo[i].setAlien_status_cd(cargo.getAlien_status_cd());
			rescargo[i].setDt_entry_into_us(cargo.getDt_entry_into_us());
			rescargo[i].setLeft_home_dt(cargo.getLeft_home_dt());
			rescargo[i].setExp_back_at_home_dt(cargo.getExp_back_at_home_dt());
			rescargo[i].setAbsence_reason_cd(cargo.getAbsence_reason_cd());
			rescargo[i].setSuffix_name(cargo.getSuffix_name());
			rescargo[i].setPeople_in_home_ct(cargo.getPeople_in_home_ct());
			rescargo[i].setLeft_home_reason_cd(cargo.getLeft_home_reason_cd());

			// EDSP CP ends: fields added
			// AFB Changes Starts
			rescargo[i].setLang_oth_dsc(cargo.getLang_oth_dsc());
			rescargo[i].setReq_interp_ind(cargo.getReq_interp_ind());
			rescargo[i].setComm_asst_sl_interp_ind(cargo.getComm_asst_sl_interp_ind());
			rescargo[i].setComm_asst_fl_interp_ind(cargo.getComm_asst_fl_interp_ind());
			rescargo[i].setComm_asst_tty_ind(cargo.getComm_asst_tty_ind());
			rescargo[i].setComm_asst_lg_print_ind(cargo.getComm_asst_lg_print_ind());
			rescargo[i].setComm_asst_sl_interp_ind(cargo.getComm_asst_sl_interp_ind());
			rescargo[i].setComm_asst_email_ind(cargo.getComm_asst_email_ind());
			rescargo[i].setComm_asst_none_ind(cargo.getComm_asst_none_ind());
			rescargo[i].setTax_joint_file_ind(cargo.getTax_joint_file_ind());
			rescargo[i].setTax_dp_outside_home_ind(cargo.getTax_dp_outside_home_ind());
			rescargo[i].setLive_at_same_addr_ind(cargo.getLive_at_same_addr_ind());
			rescargo[i].setAlias_ind(cargo.getAlias_ind());
			rescargo[i].setAlias_fst_nam(cargo.getAlias_fst_nam());
			rescargo[i].setAlias_last_nam(cargo.getAlias_last_nam());
			rescargo[i].setAlias_mid_init(cargo.getAlias_mid_init());
			rescargo[i].setAlias_suffix_name(cargo.getAlias_suffix_name());
			rescargo[i].setSsn_info_ack_ind(cargo.getSsn_info_ack_ind());
			rescargo[i].setHspc_dsc_cd(cargo.getHspc_dsc_cd());
			rescargo[i].setRace_oth_asian_ind(cargo.getRace_oth_asian_ind());
			rescargo[i].setRace_samoan_ind(cargo.getRace_samoan_ind());
			rescargo[i].setRace_filipino_ind(cargo.getRace_filipino_ind());
			rescargo[i].setRace_chinese_ind(cargo.getRace_chinese_ind());
			rescargo[i].setRace_vie_ind(cargo.getRace_vie_ind());
			rescargo[i].setRace_korean_ind(cargo.getRace_korean_ind());
			rescargo[i].setRace_guam_ind(cargo.getRace_guam_ind());
			rescargo[i].setRace_nhpi_ind(cargo.getRace_nhpi_ind());
			rescargo[i].setRace_oth_ind(cargo.getRace_oth_ind());
			rescargo[i].setRace_japanese_ind(cargo.getRace_japanese_ind());
			rescargo[i].setRace_memb_fed_rec_trb_ind(cargo.getRace_memb_fed_rec_trb_ind());
			rescargo[i].setTribe_name(cargo.getTribe_name());
			rescargo[i].setIf_out_arrangement(cargo.getIf_out_arrangement());
			rescargo[i].setComm_asst_baille_ind(cargo.getComm_asst_baille_ind());
			rescargo[i].setComm_asst_vedrel_ind(cargo.getComm_asst_vedrel_ind());
			rescargo[i].setInter_oth_dsc(cargo.getInter_oth_dsc());
			rescargo[i].setIsBreastCancerDiagnosed(cargo.getIsBreastCancerDiagnosed());
			rescargo[i].setDateOfDiagnosis(cargo.getDateOfDiagnosis());
			rescargo[i].setCc_ind(cargo.getCc_ind());
			rescargo[i].setWic_ind(cargo.getWic_ind());
			rescargo[i].setBlnd_dabl_ind(cargo.getBlnd_dabl_ind());
			rescargo[i].setAlien_doc_cd(cargo.getAlien_doc_cd());
			rescargo[i].setRes_ga_ind(cargo.getRes_ga_ind());
			rescargo[i].setDisabled_resp(cargo.getDisabled_resp());

			// AFB Changes End

			rescargo[i].setRowAction(cargo.getRowAction());
			rescargo[i].setUser(cargo.getUser());
			rescargo[i].setDirty(cargo.isDirty());

			//RTE VERF IND

			rescargo[i].setSsn_vrfn_fed_hub_ind(cargo.getSsn_vrfn_fed_hub_ind());
			rescargo[i].setUs_ctzn_fed_hub_ind(cargo.getUs_ctzn_fed_hub_ind());
			rescargo[i].setDob_fed_hub_ind(cargo.getDob_fed_hub_ind());
			rescargo[i].setUnearned_inc_fed_hub_ind(cargo.getUnearned_inc_fed_hub_ind());
			rescargo[i].setUnearned_inc_dol_ind(cargo.getUnearned_inc_dol_ind());
			rescargo[i].setEarned_inc_dol_ind(cargo.getEarned_inc_dol_ind());
			rescargo[i].setEarned_inc_wrk_num_ind(cargo.getEarned_inc_wrk_num_ind());
			rescargo[i].setTax_filing_status(cargo.getTax_filing_status());
			rescargo[i].setBst_cncr_ecp_id(cargo.getBst_cncr_ecp_id());
			
			rescargo[i].setRace_persian_ind(cargo.getRace_persian_ind());
			rescargo[i].setRace_eastasian_ind(cargo.getRace_eastasian_ind());
			rescargo[i].setRace_unknown_ind(cargo.getRace_unknown_ind());
			rescargo[i].setVld_immgrtn_sts(cargo.getVld_immgrtn_sts());
			rescargo[i].setChg_dt(cargo.getChg_dt());
			rescargo[i].setWic_clnc_cnty(cargo.getWic_clnc_cnty());
			rescargo[i].setWic_clnc_cd(cargo.getWic_clnc_cd());
			rescargo[i].setTax_flr_otsd_ind(cargo.getTax_flr_otsd_ind());
			rescargo[i].setIs_wic_clnc_info_new(cargo.getIs_wic_clnc_info_new());
		}
		return rescargo;
	}

	/**
	 * Set the cargo array object to the collection.
	 */
	@Override
	public void setGenericResults(final Object obj) {
		if (obj instanceof AppIndvCargo[]) {
			final AppIndvCargo[] cbArray = (AppIndvCargo[]) obj;
			setResults(cbArray);
		}
	}

	public AppIndvCargo getResult(final int idx) {
		return (AppIndvCargo) get(idx);
	}
}