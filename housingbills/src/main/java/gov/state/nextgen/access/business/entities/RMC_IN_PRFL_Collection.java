/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This class acts as a wrapper for one or many cargos of RMC_IN_PRFL
 * 
 * @author CodeGenerator - Architecture Team
 * Creation Date Thu Oct 11 16:06:37 CDT 2007 Modified By: Modified on: PCR#
 */
public class RMC_IN_PRFL_Collection extends AbstractCollection {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.impl.RMC_IN_PRFL";

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
	public void addCargo(final RMC_IN_PRFL_Cargo aNewCargo) {
		add(aNewCargo);
	}

	/**
	 * Sets cargo array into collection.
	 */
	public void setResults(final RMC_IN_PRFL_Cargo[] cbArray) {
		clear();
		for (int i = 0; i < cbArray.length; i++) {
			add(cbArray[i]);
		}
	}

	/**
	 * Sets cargo into collection at the given index.
	 */
	public void setCargo(final int idx, final RMC_IN_PRFL_Cargo aCargo) {
		set(idx, aCargo);
	}

	/**
	 * returns all the values in the Collection as Cargo Array.
	 */
	public RMC_IN_PRFL_Cargo[] getResults() {
		final RMC_IN_PRFL_Cargo[] cbArray = new RMC_IN_PRFL_Cargo[size()];
		toArray(cbArray);
		return cbArray;
	}

	/**
	 * returns a cargo from the Collection for the given index.
	 */
	public RMC_IN_PRFL_Cargo getCargo(final int idx) {
		return (RMC_IN_PRFL_Cargo) get(idx);
	}

	/**
	 * This one for clone Results.
	 */
	public RMC_IN_PRFL_Cargo[] cloneResults() {
		final RMC_IN_PRFL_Cargo[] rescargo = new RMC_IN_PRFL_Cargo[size()];
		for (int i = 0; i < size(); i++) {
			final RMC_IN_PRFL_Cargo cargo = getCargo(i);
			rescargo[i] = new RMC_IN_PRFL_Cargo();
			rescargo[i].setApp_num(cargo.getApp_num());
			rescargo[i].setIndv_seq_num(cargo.getIndv_seq_num());
			rescargo[i].setAcdt_resp(cargo.getAcdt_resp());
			rescargo[i].setAdpt_asst_resp(cargo.getAdpt_asst_resp());
			rescargo[i].setAlmy_rcv_resp(cargo.getAlmy_rcv_resp());
			rescargo[i].setBnft_anty_resp(cargo.getBnft_anty_resp());
			rescargo[i].setBnft_chl_sprt_resp(cargo.getBnft_chl_sprt_resp());
			rescargo[i].setBnft_chrt_resp(cargo.getBnft_chrt_resp());
			rescargo[i].setBnft_dabl_resp(cargo.getBnft_dabl_resp());
			rescargo[i].setBnft_divnd_resp(cargo.getBnft_divnd_resp());
			rescargo[i].setBnft_est_trst_resp(cargo.getBnft_est_trst_resp());
			rescargo[i].setBnft_rr_resp(cargo.getBnft_rr_resp());
			rescargo[i].setBnft_uempl_resp(cargo.getBnft_uempl_resp());
			rescargo[i].setBnft_vet_resp(cargo.getBnft_vet_resp());
			rescargo[i].setChld_sprt_pay_resp(cargo.getChld_sprt_pay_resp());
			rescargo[i].setDabl_resp(cargo.getDabl_resp());
			rescargo[i].setDpnd_care_resp(cargo.getDpnd_care_resp());
			rescargo[i].setDrug_feln_resp(cargo.getDrug_feln_resp());
			rescargo[i].setEduc_aid_resp(cargo.getEduc_aid_resp());
			rescargo[i].setEmpl_resp(cargo.getEmpl_resp());
			rescargo[i].setFset_sctn_resp(cargo.getFset_sctn_resp());
			rescargo[i].setFstr_care_resp(cargo.getFstr_care_resp());
			rescargo[i].setGen_rlf_resp(cargo.getGen_rlf_resp());
			rescargo[i].setHc_cvrg_resp(cargo.getHc_cvrg_resp());
			rescargo[i].setIncm_int_resp(cargo.getIncm_int_resp());
			rescargo[i].setIndv_fma_rqst_ind(cargo.getIndv_fma_rqst_ind());
			rescargo[i].setIndv_fpw_rqst_ind(cargo.getIndv_fpw_rqst_ind());
			rescargo[i].setIndv_fs_rqst_ind(cargo.getIndv_fs_rqst_ind());
			rescargo[i].setIrwe_resp(cargo.getIrwe_resp());
			rescargo[i].setJob_iknd_resp(cargo.getJob_iknd_resp());
			rescargo[i].setKinship_care_resp(cargo.getKinship_care_resp());
			rescargo[i].setMed_exp_resp(cargo.getMed_exp_resp());
			rescargo[i].setMil_allot_resp(cargo.getMil_allot_resp());
			rescargo[i].setMony_othr_resp(cargo.getMony_othr_resp());
			rescargo[i].setNatl_rfge_resp(cargo.getNatl_rfge_resp());
			rescargo[i].setNeed_ind_resp(cargo.getNeed_ind_resp());
			rescargo[i].setOn_strk_sw(cargo.getOn_strk_sw());
			rescargo[i].setOp_aoda_tmt_rcv_sw(cargo.getOp_aoda_tmt_rcv_sw());
			rescargo[i].setOthr_incm_resp(cargo.getOthr_incm_resp());
			rescargo[i].setOthr_src_resp(cargo.getOthr_src_resp());
			rescargo[i].setOwn_aset_resp(cargo.getOwn_aset_resp());
			rescargo[i].setPay_hous_bill_resp(cargo.getPay_hous_bill_resp());
			rescargo[i].setPay_rmr_brd_resp(cargo.getPay_rmr_brd_resp());
			rescargo[i].setPnsn_retr_resp(cargo.getPnsn_retr_resp());
			rescargo[i].setPreg_resp(cargo.getPreg_resp());
			rescargo[i].setProp_sold_resp(cargo.getProp_sold_resp());
			rescargo[i].setPub_asst_resp(cargo.getPub_asst_resp());
			rescargo[i].setRcv_fs_oth_st_resp(cargo.getRcv_fs_oth_st_resp());
			rescargo[i].setRcv_hous_asst_resp(cargo.getRcv_hous_asst_resp());
			rescargo[i].setRcv_medcr_resp(cargo.getRcv_medcr_resp());
			rescargo[i].setRcv_ss_resp(cargo.getRcv_ss_resp());
			rescargo[i].setRcv_ssi_ltr_resp(cargo.getRcv_ssi_ltr_resp());
			rescargo[i].setRcv_ssi_sw(cargo.getRcv_ssi_sw());
			rescargo[i].setRmr_brd_incm_resp(cargo.getRmr_brd_incm_resp());
			rescargo[i].setSelf_empl_resp(cargo.getSelf_empl_resp());
			rescargo[i].setSsi_dcond_resp(cargo.getSsi_dcond_resp());
			rescargo[i].setSsi_1619b_rcv_sw(cargo.getSsi_1619b_rcv_sw());
			rescargo[i].setSu_ases_resp(cargo.getSu_ases_resp());
			rescargo[i].setSu_cst_coal_resp(cargo.getSu_cst_coal_resp());
			rescargo[i].setSu_cst_elec_resp(cargo.getSu_cst_elec_resp());
			rescargo[i].setSu_cst_fuel_resp(cargo.getSu_cst_fuel_resp());
			rescargo[i].setSu_cst_gas_resp(cargo.getSu_cst_gas_resp());
			rescargo[i].setSu_cst_home_resp(cargo.getSu_cst_home_resp());
			rescargo[i].setSu_cst_istl_resp(cargo.getSu_cst_istl_resp());
			rescargo[i].setSu_cst_lpgas_resp(cargo.getSu_cst_lpgas_resp());
			rescargo[i].setSu_cst_mbl_resp(cargo.getSu_cst_mbl_resp());
			rescargo[i].setSu_cst_mtge_resp(cargo.getSu_cst_mtge_resp());
			rescargo[i].setSu_cst_othr_resp(cargo.getSu_cst_othr_resp());
			rescargo[i].setSu_cst_phn_resp(cargo.getSu_cst_phn_resp());
			rescargo[i].setSu_cst_rent_resp(cargo.getSu_cst_rent_resp());
			rescargo[i].setSu_cst_swr_resp(cargo.getSu_cst_swr_resp());
			rescargo[i].setSu_cst_tax_resp(cargo.getSu_cst_tax_resp());
			rescargo[i].setSu_cst_trsh_resp(cargo.getSu_cst_trsh_resp());
			rescargo[i].setSu_cst_wood_resp(cargo.getSu_cst_wood_resp());
			rescargo[i].setSu_cst_wtr_resp(cargo.getSu_cst_wtr_resp());
			rescargo[i].setSu_cst_wwt_resp(cargo.getSu_cst_wwt_resp());
			rescargo[i].setTrb_cpta_resp(cargo.getTrb_cpta_resp());
			rescargo[i].setTrb_tanf_resp(cargo.getTrb_tanf_resp());
			rescargo[i].setUpdt_dt(cargo.getUpdt_dt());
			rescargo[i].setUtil_exp_resp(cargo.getUtil_exp_resp());
			rescargo[i].setWheap_resp(cargo.getWheap_resp());
			rescargo[i].setWork_comp_resp(cargo.getWork_comp_resp());
			rescargo[i].setYehoc_resp(cargo.getYehoc_resp());
			rescargo[i].setResettl_inc_resp(cargo.getResettl_inc_resp());
			rescargo[i].setNone_resp(cargo.getNone_resp());
			rescargo[i].setLand_cont_resp(cargo.getLand_cont_resp());
			rescargo[i].setRefused_job_lst_30_resp(cargo.getRefused_job_lst_30_resp());
			rescargo[i].setChild_support_arr_resp(cargo.getChild_support_arr_resp());
			rescargo[i].setUnocc_home_exp_resp(cargo.getUnocc_home_exp_resp());
			rescargo[i].setTribal_food_dist_resp(cargo.getTribal_food_dist_resp());
			rescargo[i].setChild_adult_care_resp(cargo.getChild_adult_care_resp());
			rescargo[i].setMi_heating_cred_resp(cargo.getMi_heating_cred_resp());
			rescargo[i].setMortg_guar_ins_resp(cargo.getMortg_guar_ins_resp());
			rescargo[i].setCoop_condo_fee_resp(cargo.getCoop_condo_fee_resp());
			rescargo[i].setOther_resp(cargo.getOther_resp());
			rescargo[i].setWater_well_resp(cargo.getWater_well_resp());
			rescargo[i].setCooking_fuel_resp(cargo.getCooking_fuel_resp());
			rescargo[i].setWater_well_maint_resp(cargo.getWater_well_maint_resp());
			rescargo[i].setHeating_resp(cargo.getHeating_resp());
			rescargo[i].setCooling_resp(cargo.getCooling_resp());
			rescargo[i].setSeptic_sewer_resp(cargo.getSeptic_sewer_resp());
			rescargo[i].setHome_equity_resp(cargo.getHome_equity_resp());
			rescargo[i].setSecond_mortgag_resp(cargo.getSecond_mortgag_resp());
			rescargo[i].setOthr_incm_rentl_resp(cargo.getOthr_incm_rentl_resp());
			// EDSP starts
			rescargo[i].setHead_of_household_resp(cargo.getHead_of_household_resp());
			// EDSP
			// EDSP:Starts
			rescargo[i].setMedical_service_resp(cargo.getMedical_service_resp());
			rescargo[i].setEmergency_medical_service_resp(cargo.getEmergency_medical_service_resp());
			rescargo[i].setParole_violation_resp(cargo.getParole_violation_resp());
			rescargo[i].setCurrent_past_job_resp(cargo.getCurrent_past_job_resp());
			rescargo[i].setMoved_into_home_response(cargo.getMoved_into_home_response());
			rescargo[i].setMoved_out_of_home_resp(cargo.getMoved_out_of_home_resp());
			rescargo[i].setParole_violation_resp(cargo.getParole_violation_resp());
			rescargo[i].setRoom_board_resp(cargo.getRoom_board_resp());
			rescargo[i].setOther_asset_transfer_resp(cargo.getOther_asset_transfer_resp());
			rescargo[i].setOther_asset_burial_resp(cargo.getOther_asset_burial_resp());

			// EDSP CP - Liquid Asset Type
			rescargo[i].setLiquid_aset_disable_blind_resp(cargo.getLiquid_aset_disable_blind_resp());
			rescargo[i].setLiquid_asset_ira_resp(cargo.getLiquid_asset_ira_resp());
			rescargo[i].setLiquid_asset_irs_retirmnt_resp(cargo.getLiquid_asset_irs_retirmnt_resp());
			rescargo[i].setLiquid_asset_savings_acc_resp(cargo.getLiquid_asset_savings_acc_resp());
			rescargo[i].setLiquid_asset_pension_plan_resp(cargo.getLiquid_asset_pension_plan_resp());
			rescargo[i].setLiquid_asset_promissory_resp(cargo.getLiquid_asset_promissory_resp());
			rescargo[i].setLiquid_asset_retirement_resp(cargo.getLiquid_asset_retirement_resp());
			rescargo[i].setLiquid_asset_stocks_bonds_resp(cargo.getLiquid_asset_stocks_bonds_resp());
			rescargo[i].setLiquid_asset_trust_fund_resp(cargo.getLiquid_asset_trust_fund_resp());
			rescargo[i].setLiquid_asset_other_response(cargo.getLiquid_asset_other_response());
			// EDSP CP Ends - Liquid Asset Type
			rescargo[i].setLiquid_asset_other_type_resp(cargo.getLiquid_asset_other_type_resp());

			// EDSP starts - life insurance type
			rescargo[i].setLife_ins_asset_whole_life_resp(cargo.getLife_ins_asset_whole_life_resp());
			rescargo[i].setLife_insurance_asset_term_resp(cargo.getLife_insurance_asset_term_resp());
			rescargo[i].setLife_ins_asest_group_life_resp(cargo.getLife_ins_asest_group_life_resp());
			rescargo[i].setLife_ins_asset_group_term_resp(cargo.getLife_ins_asset_group_term_resp());
			rescargo[i].setLife_ins_asset_universal_resp(cargo.getLife_ins_asset_universal_resp());
			rescargo[i].setLife_insurance_other_resp(cargo.getLife_insurance_other_resp());
			rescargo[i].setOther_aset_life_insurance_resp(cargo.getOther_aset_life_insurance_resp());
			// EDSP ends - life insurance type

			// EDSP starts - Real property type
			rescargo[i].setReal_asset_land_resp(cargo.getReal_asset_land_resp());
			rescargo[i].setReal_asset_mobile_home_resp(cargo.getReal_asset_mobile_home_resp());
			rescargo[i].setReal_asset_other_resp(cargo.getReal_asset_other_resp());
			rescargo[i].setReal_asset_life_estate_resp(cargo.getReal_asset_life_estate_resp());
			rescargo[i].setReal_asset_house_resp(cargo.getReal_asset_house_resp());
			rescargo[i].setReal_asset_unoccupy_home_resp(cargo.getReal_asset_unoccupy_home_resp());
			rescargo[i].setReal_asset_home_resp(cargo.getReal_asset_home_resp());
			// EDSP ends - Real property type
			rescargo[i].setUtility_standard_resp(cargo.getUtility_standard_resp());
			rescargo[i].setTanf_ind(cargo.getTanf_ind());

			// EDSP:Ends
			rescargo[i].setRowAction(cargo.getRowAction());
			
			rescargo[i].setIndv_wic_rqst_ind(cargo.getIndv_wic_rqst_ind());
			rescargo[i].setIndv_tanf_rqst_ind(cargo.getIndv_tanf_rqst_ind());
			rescargo[i].setIndv_cc_rqst_ind(cargo.getIndv_cc_rqst_ind());
			rescargo[i].setHospital_stay_resp(cargo.getHospital_stay_resp());
			rescargo[i].setChild_care_resp(cargo.getChild_care_resp());
			rescargo[i].setChild_obligation_resp(cargo.getChild_obligation_resp());
			rescargo[i].setMedical_bills_resp(cargo.getMedical_bills_resp());
			
			// Rmc-MedicalBills Type
			rescargo[i].setMedtyp_dental(cargo.getMedtyp_dental());
			rescargo[i].setMedtyp_attendant_care(cargo.getMedtyp_attendant_care());
			rescargo[i].setMedtyp_doctor(cargo.getMedtyp_doctor());
			rescargo[i].setMedtyp_med_equip(cargo.getMedtyp_med_equip());
			rescargo[i].setMedtyp_hosp_bills(cargo.getMedtyp_hosp_bills());
			rescargo[i].setMedtyp_insur_premium(cargo.getMedtyp_insur_premium());
			rescargo[i].setMedtyp_rx_cost(cargo.getMedtyp_rx_cost());
			rescargo[i].setMedtyp_trans_med(cargo.getMedtyp_trans_med());
			rescargo[i].setMedtyp_other(cargo.getMedtyp_other());
			rescargo[i].setHospice_resp(cargo.getHospice_resp());
			rescargo[i].setOutstate_bnft_resp(cargo.getOutstate_bnft_resp());
			rescargo[i].setUnpaid_medbill(cargo.getUnpaid_medbill());
			rescargo[i].setVeh_aset_unlic_resp(cargo.getVeh_aset_unlic_resp());
			rescargo[i].setVeh_aset_arpl_resp(cargo.getVeh_aset_arpl_resp());
			rescargo[i].setVehicle_asset_camper_resp(cargo.getVehicle_asset_camper_resp());
			rescargo[i].setVehicle_asset_auto_resp(cargo.getVehicle_asset_auto_resp());
			rescargo[i].setVeh_aset_fmeq_resp(cargo.getVeh_aset_fmeq_resp());
			rescargo[i].setVehicle_asset_boat_resp(cargo.getVehicle_asset_boat_resp());
			rescargo[i].setVehicle_asset_motorcycle_resp(cargo.getVehicle_asset_motorcycle_resp());
			rescargo[i].setVeh_aset_nm_b_resp(cargo.getVeh_aset_nm_b_resp());
			rescargo[i].setVehicle_asset_recreation_resp(cargo.getVehicle_asset_recreation_resp());
			rescargo[i].setVeh_aset_trlr_resp(cargo.getVeh_aset_trlr_resp());
			rescargo[i].setVeh_aset_trk_resp(cargo.getVeh_aset_trk_resp());
			rescargo[i].setVeh_aset_unlic_resp(cargo.getVeh_aset_unlic_resp());
			rescargo[i].setVeh_aset_van_resp(cargo.getVeh_aset_van_resp());
			rescargo[i].setReal_asset_rental_resp(cargo.getReal_asset_rental_resp());
			rescargo[i].setReal_aset_vac_resp(cargo.getReal_aset_vac_resp());
			rescargo[i].setReal_aset_apt_resp(cargo.getReal_aset_apt_resp());
			rescargo[i].setReal_aset_con_resp(cargo.getReal_aset_con_resp());
			rescargo[i].setReal_aset_dup_resp(cargo.getReal_aset_dup_resp());
			rescargo[i].setReal_aset_frm_resp(cargo.getReal_aset_frm_resp());
			rescargo[i].setSpecial_need_resp(cargo.getSpecial_need_resp());
			rescargo[i].setFoster_care_resp(cargo.getFoster_care_resp());
			rescargo[i].setFormer_foster_resp(cargo.getFormer_foster_resp());
			rescargo[i].setChild_protective_resp(cargo.getChild_protective_resp());
			rescargo[i].setLiving_prog_resp(cargo.getLiving_prog_resp());
			rescargo[i].setGrand_parent_resp(cargo.getGrand_parent_resp());
			rescargo[i].setDrug_felonies_resp(cargo.getDrug_felonies_resp());
			rescargo[i].setSnap_tanf_disc_resp(cargo.getSnap_tanf_disc_resp());
			rescargo[i].setAvoid_prosc_resp(cargo.getAvoid_prosc_resp());
			rescargo[i].setViolating_parole_resp(cargo.getViolating_parole_resp());
			rescargo[i].setConvic_false_info_resp(cargo.getConvic_false_info_resp());
			rescargo[i].setVoluntarily_quit_job_resp(cargo.getVoluntarily_quit_job_resp());
			rescargo[i].setTrading_snap_resp(cargo.getTrading_snap_resp());
			rescargo[i].setBuy_sell_snap_resp(cargo.getBuy_sell_snap_resp());
			rescargo[i].setTrade_snap_gun_resp(cargo.getTrade_snap_gun_resp());
			rescargo[i].setPrev_ssi_resp(cargo.getPrev_ssi_resp());
			rescargo[i].setHome_community_resp(cargo.getHome_community_resp());
			rescargo[i].setTribal_health_resp(cargo.getTribal_health_resp());
			rescargo[i].setTribal_eligibility_resp(cargo.getTribal_eligibility_resp());
			rescargo[i].setDomestic_violence_resp(cargo.getDomestic_violence_resp());
			rescargo[i].setTanf_eppic_resp(cargo.getTanf_eppic_resp());
			rescargo[i].setEmergency_medical_resp(cargo.getEmergency_medical_resp());
			rescargo[i].setMedtyp_hsa_contrib(cargo.getMedtyp_hsa_contrib());
			
			rescargo[i].setPers_prop_bus_eqpt(cargo.getPers_prop_bus_eqpt());
			rescargo[i].setPers_prop_cemetary_lot(cargo.getPers_prop_cemetary_lot());
			rescargo[i].setPers_prop_livestock(cargo.getPers_prop_livestock());
			rescargo[i].setPers_prop_saf_depst_box(cargo.getPers_prop_saf_depst_box());
			rescargo[i].setPers_prop_oth_val(cargo.getPers_prop_oth_val());
			
			
			rescargo[i].setAble_to_conceive_resp(cargo.getAble_to_conceive_resp());
			rescargo[i].setUnderweight_birth_resp(cargo.getUnderweight_birth_resp());
			rescargo[i].setPreg_add_stat_sw(cargo.getPreg_add_stat_sw());
			rescargo[i].setPreg_chg_stat_sw(cargo.getPreg_chg_stat_sw());
			rescargo[i].setPrsn_info_stat_sw(cargo.getPrsn_info_stat_sw());
			rescargo[i].setRlt_chg_stat_sw(cargo.getRlt_chg_stat_sw());
			
			rescargo[i].setSu_cst_ins_resp(cargo.getSu_cst_ins_resp());
			rescargo[i].setOther_housing_bill_resp(cargo.getOther_housing_bill_resp());
			rescargo[i].setDisaster_repair_resp(cargo.getDisaster_repair_resp());
			rescargo[i].setHousing_bill_others_resp(cargo.getHousing_bill_others_resp());
			rescargo[i].setPrevent_eviction_resp(cargo.getPrevent_eviction_resp());
			rescargo[i].setOthr_incm_trbl_resp(cargo.getOthr_incm_trbl_resp());
			rescargo[i].setCareTaker_resp(cargo.getCareTaker_resp());
			rescargo[i].setLost_health_ins_ind(cargo.getLost_health_ins_ind());
			rescargo[i].setTax_claim_dependant_resp(cargo.getTax_claim_dependant_resp());
			 //NextGen  NG-6481 Phase 3 updates to ACA Streamline changes   Start
			rescargo[i].setBefore_tax_deduction_resp(cargo.getBefore_tax_deduction_resp());
			rescargo[i].setBtd_med_ins(cargo.getBtd_med_ins());
			rescargo[i].setBtd_dent_ins(cargo.getBtd_dent_ins());
			rescargo[i].setBtd_vis_care_ins(cargo.getBtd_vis_care_ins());
			rescargo[i].setBtd_flex_acc(cargo.getBtd_flex_acc());
			rescargo[i].setBtd_def_comp(cargo.getBtd_def_comp());
			rescargo[i].setBtd_pre_tax_ins(cargo.getBtd_pre_tax_ins());
			rescargo[i].setBtd_other(cargo.getBtd_other());
			rescargo[i].setTax_deduct_resp(cargo.getTax_deduct_resp());
			//NextGen NG-6481 Phase 3 updates to ACA Streamline changes  end
			rescargo[i].setHlth_ins_resp(cargo.getHlth_ins_resp());
			rescargo[i].setOthr_hlth_ins_resp(cargo.getOthr_hlth_ins_resp());
			//wp sync
			rescargo[i].setTanfDiscResp(cargo.getTanfDiscResp());
			//wp sync end
			//add and change indicators
			rescargo[i].setRoom_brd_chg_ind(cargo.getRoom_brd_chg_ind());
			rescargo[i].setDabl_stat_ind(cargo.getDabl_stat_ind());
			rescargo[i].setPreg_add_stat_ind(cargo.getPreg_add_stat_ind());
			rescargo[i].setPreg_chg_ind(cargo.getPreg_chg_ind());
			rescargo[i].setIrwe_chg_ind(cargo.getIrwe_chg_ind());
			rescargo[i].setEi_chg_ind(cargo.getEi_chg_ind());
			rescargo[i].setSelf_empl_chg_ind(cargo.getSelf_empl_chg_ind());
			rescargo[i].setOthr_incm_chg_ind(cargo.getOthr_incm_chg_ind());
			rescargo[i].setEmpl_chg_ind(cargo.getEmpl_chg_ind());
			rescargo[i].setVeh_aset_add_ind(cargo.getVeh_aset_add_ind());
			rescargo[i].setVeh_aset_chg_ind(cargo.getVeh_aset_chg_ind());
			rescargo[i].setReal_aset_add_ind(cargo.getReal_aset_add_ind());
			rescargo[i].setReal_aset_chg_ind(cargo.getReal_aset_chg_ind());
			rescargo[i].setBury_aset_add_ind(cargo.getBury_aset_add_ind());
			rescargo[i].setBury_aset_chg_ind(cargo.getBury_aset_chg_ind());
			rescargo[i].setLiquid_asset_add_ind(cargo.getLiquid_asset_add_ind());
			rescargo[i].setLiquid_asset_bank_acc_chg_ind(cargo.getLiquid_asset_bank_acc_chg_ind());
			rescargo[i].setLiquid_asset_cash_chg_ind(cargo.getLiquid_asset_cash_chg_ind());
			rescargo[i].setLiquid_asset_chg_ind(cargo.getLiquid_asset_chg_ind());
			rescargo[i].setLiquid_asset_other_chg_ind(cargo.getLiquid_asset_other_chg_ind());
			rescargo[i].setLife_ins_aset_add_ind(cargo.getLife_ins_aset_add_ind());
			rescargo[i].setLife_ins_aset_chg_ind(cargo.getLife_ins_aset_chg_ind());
			rescargo[i].setAset_xfer_chg_ind(cargo.getAset_xfer_chg_ind());
			rescargo[i].setDpnd_care_chg_ind(cargo.getDpnd_care_chg_ind());
			rescargo[i].setHealth_insurance_chg_ind(cargo.getHealth_insurance_chg_ind());
			rescargo[i].setChild_support_payment_chg_ind(cargo.getChild_support_payment_chg_ind());
			rescargo[i].setSnap_shelter_standard_exp_ind(cargo.getSnap_shelter_standard_exp_ind());
			rescargo[i].setHous_bill_chg_ind(cargo.getHous_bill_chg_ind());
			rescargo[i].setAdd_chg_ind(cargo.getAdd_chg_ind());
			rescargo[i].setPerson_moved_in_stat_ind(cargo.getPerson_moved_in_stat_ind());
			rescargo[i].setPerson_moved_out_stat_ind(cargo.getPerson_moved_out_stat_ind());
			rescargo[i].setHospice_chg_ind(cargo.getHospice_chg_ind());
			rescargo[i].setMedicare_chg_ind(cargo.getMedicare_chg_ind());
			rescargo[i].setNcp_chg_ind(cargo.getNcp_chg_ind());
			rescargo[i].setThird_party_chg_ind(cargo.getThird_party_chg_ind());
			rescargo[i].setHospital_abd_chg_ind(cargo.getHospital_abd_chg_ind());
			rescargo[i].setPublic_law_abd_chg_ind(cargo.getPublic_law_abd_chg_ind());
			rescargo[i].setLiving_argmt_chg_ind(cargo.getLiving_argmt_chg_ind());
			rescargo[i].setOther_program_chg_ind(cargo.getOther_program_chg_ind());
			rescargo[i].setMagi_expense_chg_ind(cargo.getMagi_expense_chg_ind());
			rescargo[i].setTax_info_ind(cargo.getTax_info_ind());
			rescargo[i].setTax_dep_outside_resp(cargo.getTax_dep_outside_resp());
			rescargo[i].setMedicare_part_a(cargo.getMedicare_part_a());
			rescargo[i].setMedicare_part_b(cargo.getMedicare_part_b());
			rescargo[i].setMedicare_part_c(cargo.getMedicare_part_c());
			rescargo[i].setMedicare_part_d(cargo.getMedicare_part_d());
			rescargo[i].setCssp_provider_payment(cargo.getCssp_provider_payment());
			rescargo[i].setAnimals_to_assist_disabled(cargo.getAnimals_to_assist_disabled());
			rescargo[i].setFuneral_death_expense(cargo.getFuneral_death_expense());
			rescargo[i].setBlind_work_expense(cargo.getBlind_work_expense());
			rescargo[i].setImpairment_work_expense(cargo.getImpairment_work_expense());
			rescargo[i].setOth_ind_gambl_pmnts(cargo.getOth_ind_gambl_pmnts());
			rescargo[i].setIncome_from_resource(cargo.getIncome_from_resource());
			rescargo[i].setIndian_gambling_payments(cargo.getIndian_gambling_payments());
			rescargo[i].setInheritance(cargo.getInheritance());
			rescargo[i].setInsuance_benefits(cargo.getInsuance_benefits());
			rescargo[i].setLoan_received(cargo.getLoan_received());
			rescargo[i].setLoan_repayment_income(cargo.getLoan_repayment_income());
			rescargo[i].setManaged_income(cargo.getManaged_income());
			rescargo[i].setMatch_grant(cargo.getMatch_grant());
			rescargo[i].setMontgomery_gi_bill(cargo.getMontgomery_gi_bill());
			rescargo[i].setOut_of_state_public(cargo.getOut_of_state_public());
			rescargo[i].setRefunds_from_dch(cargo.getRefunds_from_dch());
			rescargo[i].setRestitutions_settlements(cargo.getRestitutions_settlements());
			rescargo[i].setSenior_companion(cargo.getSenior_companion());
			rescargo[i].setSeverance_pay(cargo.getSeverance_pay());
			rescargo[i].setStrike_benefits(cargo.getStrike_benefits());
			rescargo[i].setTrade_readjustment(cargo.getTrade_readjustment());
			rescargo[i].setUniform_relocation(cargo.getUniform_relocation());
			rescargo[i].setUnion_funds(cargo.getUnion_funds());
			rescargo[i].setVendor_excluded(cargo.getVendor_excluded());
			rescargo[i].setVictim_restitution(cargo.getVictim_restitution());
			rescargo[i].setVolunteer_payment(cargo.getVolunteer_payment());
			rescargo[i].setVolunteer_payment_titlei(cargo.getVolunteer_payment_titlei());
			rescargo[i].setWia_training_and_allowance(cargo.getWia_training_and_allowance());
			rescargo[i].setIncluded_unearned_income(cargo.getIncluded_unearned_income());
			rescargo[i].setTanf_max_au_allotment(cargo.getTanf_max_au_allotment());
			rescargo[i].setTanf_max_grg_allotment(cargo.getTanf_max_grg_allotment());
			rescargo[i].setCharitable_donation(cargo.getCharitable_donation());
			rescargo[i].setChild_nutrition_payments(cargo.getChild_nutrition_payments());
			rescargo[i].setBlack_lung_benefits(cargo.getBlack_lung_benefits());
			rescargo[i].setChild_support_court(cargo.getChild_support_court());
			rescargo[i].setChild_support_gap_payment(cargo.getChild_support_gap_payment());
			rescargo[i].setCivil_service(cargo.getCivil_service());
			rescargo[i].setDeferred_compensation_plans(cargo.getDeferred_compensation_plans());
			rescargo[i].setDisability_insurance(cargo.getDisability_insurance());
			rescargo[i].setExcluded_unearned_income(cargo.getExcluded_unearned_income());
			rescargo[i].setFema_payment_disaster(cargo.getFema_payment_disaster());
			rescargo[i].setFema_payment_non_disaster(cargo.getFema_payment_non_disaster());
			rescargo[i].setHealth_savings_account(cargo.getHealth_savings_account());
			rescargo[i].setIn_kind_support(cargo.getIn_kind_support());
			rescargo[i].setFoster_grandparent_program(cargo.getFoster_grandparent_program());
			rescargo[i].setDisaster_unemployment(cargo.getDisaster_unemployment());
			rescargo[i].setDividends(cargo.getDividends());
			rescargo[i].setCharitable_donation_federal(cargo.getCharitable_donation_federal());
			rescargo[i].setBonds(cargo.getBonds());
			rescargo[i].setDividend(cargo.getDividend());
			rescargo[i].setHealth_reimbursement_account(cargo.getHealth_reimbursement_account());
			rescargo[i].setIndividual_development_account(cargo.getIndividual_development_account());
			rescargo[i].setUniform_gifts_to_minors(cargo.getUniform_gifts_to_minors());
			rescargo[i].setInheritance_income(cargo.getInheritance_income());
			rescargo[i].setPersonal_info(cargo.getPersonal_info());
			rescargo[i].setPatient_fund(cargo.getPatient_fund());
			
			rescargo[i].setDisaster_assistance(cargo.getDisaster_assistance());
			rescargo[i].setNon_business_equipment(cargo.getNon_business_equipment());
			rescargo[i].setHousehold_goods(cargo.getHousehold_goods());
			rescargo[i].setOther_non_countable(cargo.getOther_non_countable());
			rescargo[i].setOut_st_bnft_chg_ind(cargo.getOut_st_bnft_chg_ind());
			rescargo[i].setSchl_enrl_chg_ind(cargo.getSchl_enrl_chg_ind());
			rescargo[i].setMrtl_stat_chg_ind(cargo.getMrtl_stat_chg_ind());
			rescargo[i].setNur_hme_chg_ind(cargo.getNur_hme_chg_ind());
			rescargo[i].setBfr_tax_chg_ind(cargo.getBfr_tax_chg_ind());
			rescargo[i].setInc_tax_chg_ind(cargo.getInc_tax_chg_ind());
			rescargo[i].setThrd_prty_chg_ind(cargo.getThrd_prty_chg_ind());
			rescargo[i].setDeath_benefit_state_federal(cargo.getDeath_benefit_state_federal());
			rescargo[i].setSocial_security_survivor(cargo.getSocial_security_survivor());
			rescargo[i].setVendor_payments(cargo.getVendor_payments());
			//rescargo[i].setAlias_name_change_resp(cargo.getAlias_name_change_resp());
			rescargo[i].setCitizenship_chg_ind(cargo.getCitizenship_chg_ind());
			rescargo[i].setDemographics_chg_ind(cargo.getDemographics_chg_ind());
			rescargo[i].setAlias_name_change_resp(cargo.getAlias_name_change_resp());
			rescargo[i].setAlien_chg_ind(cargo.getAlien_chg_ind());
			rescargo[i].setUtil_bill_chg_Ind(cargo.getUtil_bill_chg_Ind());
			rescargo[i].setCitizenship_info(cargo.getCitizenship_info());
			rescargo[i].setIndv_prgm_chg_ind(cargo.getIndv_prgm_chg_ind());
			rescargo[i].setEmpl_hlth_ins_resp(cargo.getEmpl_hlth_ins_resp());
			rescargo[i].setAvd_prsctn_fstf(cargo.getAvd_prsctn_fstf());
			rescargo[i].setCntrl_subs_resp(cargo.getCntrl_subs_resp());
			rescargo[i].setHeat_cool_src(cargo.getHeat_cool_src());
			rescargo[i].setMed_type_katie_beckett(cargo.getMed_type_katie_beckett());
			///
			rescargo[i].setUser(cargo.getUser());
			rescargo[i].setDirty(cargo.isDirty());
		}
		return rescargo;
	}

	/**
	 * Set the cargo array object to the collection.
	 */
	@Override
	public void setGenericResults(final Object obj) {
		if (obj instanceof RMC_IN_PRFL_Cargo[]) {
			final RMC_IN_PRFL_Cargo[] cbArray = (RMC_IN_PRFL_Cargo[]) obj;
			setResults(cbArray);
		}
	}
}