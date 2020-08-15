/*
 * 
 */
package gov.state.nextgen.access.business.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * This java bean contains the entities of RMC_IN_PRFL
 * 
 * @author CodeGenerator - Architecture Team
 * Creation Date Thu Oct 11 16:06:37 CDT 2007 Modified By: Modified on: PCR#
 */
/**
 * @author pyavagal
 *
 */
public class RMC_IN_PRFL_Cargo extends AbstractCargo implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	boolean isDirty = false;
	private String app_num;
	private String indv_seq_num;
	private String acdt_resp;
	private String adpt_asst_resp;
	private String almy_rcv_resp;
	private String bnft_anty_resp;
	private String bnft_chl_sprt_resp;
	private String bnft_chrt_resp;
	private String bnft_dabl_resp;
	private String bnft_divnd_resp;
	private String bnft_est_trst_resp;
	private String bnft_rr_resp;
	private String bnft_uempl_resp;
	private String bnft_vet_resp;
	private String chld_sprt_pay_resp;
	private String dabl_resp;
	private String dpnd_care_resp;
	private String drug_feln_resp;
	private String educ_aid_resp;
	private String empl_resp;
	private String fset_sctn_resp;
	private String fstr_care_resp;
	private String gen_rlf_resp;
	private String hc_cvrg_resp;
	private String incm_int_resp;
	
	private String irwe_resp;
	private String job_iknd_resp;
	private String kinship_care_resp;
	private String med_exp_resp;
	private String mil_allot_resp;
	private String mony_othr_resp;
	private String natl_rfge_resp;
	private String need_ind_resp;
	private String on_strk_sw;
	private String op_aoda_tmt_rcv_sw;
	private String othr_incm_resp;
	private String othr_src_resp;
	private String own_aset_resp;
	private String pay_hous_bill_resp;
	private String pay_rmr_brd_resp;
	private String pnsn_retr_resp;
	private String preg_resp;
	private String prop_sold_resp;
	private String pub_asst_resp;
	private String rcv_fs_oth_st_resp;
	private String rcv_hous_asst_resp;
	private String rcv_medcr_resp;
	private String rcv_ss_resp;
	private String rcv_ssi_ltr_resp;
	private String rcv_ssi_sw;
	private String rmr_brd_incm_resp;
	private String self_empl_resp;
	private String ssi_dcond_resp;
	private String ssi_1619b_rcv_sw;
	private String su_ases_resp;
	private String su_cst_coal_resp;
	private String su_cst_elec_resp;
	private String su_cst_fuel_resp;
	private String su_cst_gas_resp;
	private String su_cst_home_resp;
	private String su_cst_istl_resp;
	private String su_cst_lpgas_resp;
	private String su_cst_mbl_resp;
	private String su_cst_mtge_resp;
	private String su_cst_othr_resp;
	private String su_cst_phn_resp;
	private String su_cst_rent_resp;
	private String su_cst_swr_resp;
	private String su_cst_tax_resp;
	private String su_cst_trsh_resp;
	private String su_cst_wood_resp;
	private String su_cst_wtr_resp;
	private String su_cst_wwt_resp;
	private String trb_cpta_resp;
	private String trb_tanf_resp;
	private String updt_dt;
	private String util_exp_resp;
	private String wheap_resp;
	private String work_comp_resp;
	private String yehoc_resp;
	private String resettl_inc_resp;
	private String none_resp;
	private String land_cont_resp;
	private String refused_job_lst_30_resp;
	private String child_support_arr_resp;
	private String unocc_home_exp_resp;
	private String tribal_food_dist_resp;
	private String child_adult_care_resp;
	private String mi_heating_cred_resp;
	private String mortg_guar_ins_resp;
	private String coop_condo_fee_resp;
	private String other_resp;
	private String water_well_resp;
	private String cooking_fuel_resp;
	private String water_well_maint_resp;
	private String heating_resp;
	private String cooling_resp;
	private String septic_sewer_resp;
	private String home_equity_resp;
	private String second_mortgag_resp;
	private String othr_incm_rentl_resp;
	private String cp_wlst_resp;
	private String indv_cla_ind;
	private String past_hc_cvrg_resp;
	// private String othr_aset_xfr_resp;
	private String trb_cmdy_resp;
	private String bury_aset_c_resp;
	private String bury_aset_ibt_resp;
	private String bury_aset_ins_resp;
	private String bury_aset_mas_resp;
	private String bury_aset_oth_resp;
	private String bury_aset_plt_resp;
	private String bury_aset_rbt_resp;
	private String bury_aset_v_resp;
	private String li_aset_g_l_resp;
	private String li_aset_g_t_resp;
	private String li_aset_trm_resp;
	private String li_aset_unv_resp;
	private String li_aset_w_l_resp;
	private String lqd_aset_c_a_resp;
	// private String lqd_aset_cash_resp;
	private String lqd_aset_eb_a_resp;
	private String lqd_aset_h_s_resp;
	private String lqd_aset_ira_resp;
	private String lqd_aset_k_p_resp;
	private String lqd_aset_m_o_resp;
	private String lqd_aset_mm_a_resp;
	private String lqd_aset_o_t_resp;
	private String lqd_aset_othr_resp;
	private String lqd_aset_s_a_resp;
	private String lqd_aset_s_c_resp;
	private String lqd_aset_st_b_resp;
	private String lqd_aset_tr_f_resp;
	private String lqd_aset_us_b_resp;
	private String other_asset_burial_resp;
	private String other_aset_life_insurance_resp;
	private String other_asset_personal_prop_resp;
	private String other_asset_real_property_resp;
	private String other_asset_vehicle_resp;
	private String real_aset_apt_resp;
	private String real_aset_com_resp;
	private String real_aset_con_resp;
	private String real_aset_dup_resp;
	private String real_aset_frm_resp;
	private String real_aset_hse_resp;
	private String real_aset_lnd_resp;
	private String real_aset_m_h_resp;
	private String real_aset_oth_resp;

	private String veh_aset_auto_resp;
	private String veh_aset_boat_resp;
	private String veh_aset_camp_resp;
	private String veh_aset_mcyc_resp;
	private String veh_aset_anml_resp;
	private String veh_aset_arpl_resp;
	private String veh_aset_bus_resp;
	private String veh_aset_fimp_resp;
	private String veh_aset_fmeq_resp;
	private String veh_aset_ftrc_resp;
	private String veh_aset_ftrl_resp;
	private String veh_aset_lskd_resp;

	private String veh_aset_mped_resp;
	private String veh_aset_nm_b_resp;
	private String veh_aset_othr_resp;
	private String veh_aset_rv_resp;
	private String veh_aset_s_mb_resp;
	private String veh_aset_trk_resp;
	private String veh_aset_trlr_resp;
	private String veh_aset_van_resp;
	private String bnft_mapp_resp;
	private String school_enrollment_resp;
	private String hospital_stay_resp;
	// EDSP Starts
	private String head_of_household_resp;
	// EDSP-CP mods BEGIN
	private String medical_service_resp;
	private String emergency_medical_service_resp;
	private String parole_violation_resp;
	private String room_board_resp;
	private String current_past_job_resp;

	private String moved_into_home_response;
	private String moved_out_of_home_resp;
	// EDSP _RMB
	private String liquid_asset_bank_acc_resp; // Financial Account - Not used
												// by Liquid Asset Type
	private String other_asset_transfer_resp;

	// EDSP CP - Liquid Asset Type
	private String liquid_aset_disable_blind_resp;// annuity
	private String liquid_asset_ira_resp;// IRA
	private String liquid_asset_irs_retirmnt_resp;// IRS Approved Retirement
													// Account
	private String liquid_asset_savings_acc_resp;// IRS Approved College Savings
													// Plan
	private String liquid_asset_pension_plan_resp;// Pension Plans
	private String liquid_asset_promissory_resp;// Promissory note/Deeds of
												// trust
	private String liquid_asset_retirement_resp;// Retirement Account
	private String liquid_asset_stocks_bonds_resp;// Stocks/Bonds/Mutual funds
	
	private String liquid_asset_trust_fund_resp;// Trust Fund
	private String liquid_asset_other_response;// Other
	// EDSP CP Ends - Liquid Asset Type
	private String liquid_asset_other_type_resp;
	private String liquid_asset_cash_resp;

	private String indv_wic_rqst_ind;
	private String indv_tanf_rqst_ind;
	private String indv_cc_rqst_ind;
	private String indv_fma_rqst_ind;
	private String indv_fs_rqst_ind;
	private String indv_fpw_rqst_ind;
	
	
	private String tanf_ind;
	


	// EDSP starts - life insurance type
	private String life_ins_asset_whole_life_resp; // whole life
	private String life_insurance_asset_term_resp;// - asset term
	private String life_ins_asest_group_life_resp;// - group life
	private String life_ins_asset_group_term_resp;// - group term
	private String life_ins_asset_universal_resp;// - asset universal
	private String life_insurance_other_resp;// - Other

	// EDSP ends - life insurance type

	// EDSP Starts - Real Property type
	private String real_asset_land_resp;
	private String real_asset_mobile_home_resp;
	private String real_asset_other_resp;
	private String real_asset_life_estate_resp;
	private String real_asset_house_resp;
	private String real_asset_unoccupy_home_resp;
	private String real_asset_home_resp;

	// EDSP Ends - Real Property Type

	// vehicle
	private String vehicle_asset_auto_resp;
	private String vehicle_asset_boat_resp;
	private String vehicle_asset_motorcycle_resp;
	private String vehicle_asset_other_resp;
	private String vehicle_asset_recreation_resp;
	private String vehicle_asset_animal_drwn_resp;
	private String vehicle_asset_tractor_resp;
	private String vehicle_asset_golf_cart_resp;
	private String vehicle_asset_nmot_camper_resp;
	private String vehicle_asset_camper_resp;

	// vehicle ends
	// EDSP RMB other income
	private String training_allowance_resp;
	private String inheritance_resp;
	private String student_financial_aid_resp;
	private String food_clothing_util_rent_resp;
	private String cash_gifts_resp;
	private String loan_resp;
	private String benefit_black_lung_resp;
	private String lottery_prize_winning_resp;
	private String insurance_settlement_resp;
	private String othr_social_security_bnft_resp;
	private String benefits_on_strike_resp;
	private String work_related_expense_resp;
	// Medical types

	private String med_type_prosthetic_resp;
	private String med_type_atndnt_meal_resp;
	private String med_type_animal_resp;
	private String med_type_maintain_attndnt_resp;
	private String med_type_inhome_resp;
	private String med_type_special_equip_resp;
	private String med_type_eyeglasses_resp;
	private String med_type_insurance_resp;
	private String med_type_bills_resp;
	private String med_type_supplies_resp;
	private String med_type_nursing_resp;
	private String med_type_katie_beckett;
	private String med_type_other_resp;
	private String med_type_out_patient_resp;
	private String med_type_psychotherapy_resp;
	private String med_type_prescribed_drug_resp;
	private String med_type_transportation_resp;
	private String utility_standard_resp;
	private String other_incm_contrib_resp;

	// EDSP RMB other income ends
	
	
	// Other Bill
	
	private String child_care_resp;
	private String child_obligation_resp;
	private String medical_bills_resp;
	
	// Rmc-Medical Types
	private String medtyp_dental;
	private String medtyp_attendant_care;
	private String medtyp_doctor;
	private String medtyp_med_equip;
	private String medtyp_hosp_bills;
	private String medtyp_insur_premium;
	private String medtyp_rx_cost;
	private String medtyp_trans_med;
	private String medtyp_other;
	private String hospice_resp;
	private String outstate_bnft_resp;
	private String unpaid_medbill;
	private String veh_aset_unlic_resp;
	private String real_asset_rental_resp;
	private String real_aset_vac_resp;
	private String special_need_resp;
	private String foster_care_resp;
	private String former_foster_resp;
	private String child_protective_resp;
	private String living_prog_resp;
	private String grand_parent_resp;
	private String drug_felonies_resp;
	private String snap_tanf_disc_resp;
	private String avoid_prosc_resp;
	private String violating_parole_resp;
	private String convic_false_info_resp;
	private String voluntarily_quit_job_resp;
	private String trading_snap_resp;
	private String buy_sell_snap_resp;
	private String trade_snap_gun_resp;
	private String prev_ssi_resp;
	private String home_community_resp;
	private String tribal_health_resp;
	private String tribal_eligibility_resp;
	private String domestic_violence_resp;
	private String tanf_eppic_resp;
	private String emergency_medical_resp;

	private String adoptAssistance;
	private String adoptionPayments;
	private String agentOrangePayments;
	private String alimony;
	private String capitalGains;
	private String deathBenefits;
	private String disabilityIncome;
	private String disasterRelief;
	private String educationalAssistance;
	private String energyAssistance;
	private String farmAllotment;
	private String fosterCarePayments;
	private String generalAssistance;
	private String interestDividendPayments;
	private String iRADistribution;
	private String lotteryWinnings;
	private String lumpSum;
	private String militaryAllotment;
	private String moneyFromAnotherPerson;
	private String netRentalRoyalty;
	private String otherIncome;
	private String paymentsFromAnnuity;
	private String paymentsMadeOnYourBehalf;
	private String pensionOrRetirement;
	private String railroadRetirement;
	private String refugeeCash;
	private String relativeCareSubsidy;
	private String rentalIncome;
	private String tANFPayments;
	private String unemploymentCompensation;
	private String workStudyStateFederal;
	private String workersCompensation;

	private String medtyp_hsa_contrib;
	
	private String pers_prop_bus_eqpt;//PERS_PROP_BUS_EQPT
	private String pers_prop_cemetary_lot;//PERS_PROP_CEMETARY_LOT
	private String pers_prop_livestock;//PERS_PROP_LIVESTOCK
	private String pers_prop_saf_depst_box;//PERS_PROP_SAF_DEPST_BOX
	private String pers_prop_oth_val;//PERS_PROP_OTH_VAL

	// Added by Srividhya 16Mar15 for RMC 5 pregnancy info changes
	private String able_to_conceive_resp; //ABLE_TO_CONCEIVE_RESP  
	private String underweight_birth_resp; //UNDERWEIGHT_BIRTH_RESP 
	private String preg_add_stat_sw; //PREG_ADD_STAT_SW
	private String preg_chg_stat_sw; //PREG_CHG_STAT_SW 
	private String prsn_info_stat_sw;
	private String rlt_chg_stat_sw;
	
	private String prevent_eviction_resp;
	private String disaster_repair_resp;
	private String other_housing_bill_resp;
	private String su_cst_ins_resp;
	
	private String careTaker_resp;
	private String othr_incm_trbl_resp;
	private String lost_health_ins_ind;
	private String tax_claim_dependant_resp;
	
	//NextGen  NG-6481 Phase 3 updates to ACA Streamline changes : Start
	private String before_tax_deduction_resp;
	private String btd_med_ins;
	private String btd_dent_ins;
	private String btd_vis_care_ins;
	private String btd_flex_acc;
	private String btd_def_comp;
	private String btd_pre_tax_ins;
	private String btd_other;
	private String tax_deduct_resp;
	//NextGen  NG-6481 Phase 3 updates to ACA Streamline changes : End
	private String hlth_ins_resp;
	private String othr_hlth_ins_resp;
	
	//WP SYNC
	private String tanfDiscResp;
	
	//add and change indicators
	
	private String room_brd_chg_ind;
	private String dabl_stat_ind;
	private String preg_add_stat_ind;
	private String preg_chg_ind;
	private String irwe_chg_ind;
	private String ei_chg_ind;
	private String self_empl_chg_ind;
	private String othr_incm_chg_ind;
	private String empl_chg_ind;
	private String veh_aset_add_ind;
	private String veh_aset_chg_ind;
	private String real_aset_add_ind;
	private String real_aset_chg_ind;
	private String bury_aset_add_ind;
	private String bury_aset_chg_ind;
	private String liquid_asset_add_ind;
	private String liquid_asset_bank_acc_chg_ind;
	private String liquid_asset_cash_chg_ind;
	private String liquid_asset_chg_ind;
	private String liquid_asset_other_chg_ind;
	private String life_ins_aset_add_ind;
	private String life_ins_aset_chg_ind;
	private String aset_xfer_chg_ind;
	private String dpnd_care_chg_ind;
	private String health_insurance_chg_ind;
	private String child_support_payment_chg_ind;
	private String snap_shelter_standard_exp_ind;
	private String hous_bill_chg_ind;
	private String add_chg_ind;
	private String person_moved_in_stat_ind;
	private String person_moved_out_stat_ind;
	private String hospice_chg_ind;
	private String medicare_chg_ind;
	private String ncp_chg_ind;
	private String third_party_chg_ind;
	private String hospital_abd_chg_ind;
	private String public_law_abd_chg_ind;
	private String living_argmt_chg_ind;
	private String other_program_chg_ind;
	private String magi_expense_chg_ind;
	private String tax_info_ind;
	private String tax_dep_outside_resp;
	// Adding Medical Bill Type Columns
		private String medicare_part_a;
		private String medicare_part_b;
		private String medicare_part_c;
		private String medicare_part_d;
		private String cssp_provider_payment;
		private String animals_to_assist_disabled;
		private String funeral_death_expense;
		private String blind_work_expense;
		private String impairment_work_expense;
		
	//American Indian income "IGP"
	private String oth_ind_gambl_pmnts;
	
	// Adding to Other Income Type Page.
		private String income_from_resource;
		private String indian_gambling_payments;
		private String inheritance;
		private String insuance_benefits;
		private String loan_received;
		private String loan_repayment_income;
		private String managed_income;
		private String match_grant;
		private String montgomery_gi_bill;
		private String out_of_state_public;
		private String refunds_from_dch;
		private String restitutions_settlements;
		private String senior_companion;
		private String severance_pay;
		private String strike_benefits;
		private String trade_readjustment;
		private String uniform_relocation;                        
		private String union_funds;                               
		private String vendor_excluded;                          
		private String victim_restitution;                       
		private String volunteer_payment;                         
		private String volunteer_payment_titlei;                  
		private String wia_training_and_allowance;               
		private String included_unearned_income;                  
		private String tanf_max_au_allotment;                     
		private String tanf_max_grg_allotment;                    
		private String charitable_donation;                       
		private String child_nutrition_payments;                  
		private String black_lung_benefits;                       
		private String child_support_court;                       
		private String child_support_gap_payment;
		private String civil_service;                            
		private String deferred_compensation_plans;              
		private String disability_insurance;                      
		private String excluded_unearned_income;                  
		private String fema_payment_disaster;                     
		private String fema_payment_non_disaster;                 
		private String health_savings_account;
		private String in_kind_support;                           
		private String foster_grandparent_program;                
		private String disaster_unemployment;                    
		private String dividends;                                
		private String charitable_donation_federal;
		
		
		// Liquid Resource Additional fields	
		private String bonds;
		private String dividend;
		private String health_reimbursement_account;
		private String individual_development_account;
		private String uniform_gifts_to_minors;
		private String personal_info;
		
		private String patient_fund;
		
		private String disaster_assistance;
		private String non_business_equipment;
		private String household_goods;
		private String other_non_countable;
		
		private String out_st_bnft_chg_ind;
		private String schl_enrl_chg_ind;
		private String mrtl_stat_chg_ind;
		private String nur_hme_chg_ind;
		private String bfr_tax_chg_ind;
		private String inc_tax_chg_ind;
		private String thrd_prty_chg_ind;
		
		private String death_benefit_state_federal;
		private String social_security_survivor;
		private String vendor_payments;
		private String citizenship_chg_ind;
		private String demographics_chg_ind;
		private String alias_name_change_resp;
		private String alien_chg_ind;
		private String util_bill_chg_Ind;
		private String citizenship_info;		
		private String indv_prgm_chg_ind;
		private String empl_hlth_ins_resp;
		private String avd_prsctn_fstf;
		private String cntrl_subs_resp;
		
		
		private String heat_cool_src;
		
		
		
		
		/**
         * @return the med_type_katie_beckett
         */
        public String getMed_type_katie_beckett() {
            return med_type_katie_beckett;
        }

        /**
         * @param med_type_katie_beckett the med_type_katie_beckett to set
         */
        public void setMed_type_katie_beckett(String med_type_katie_beckett) {
            this.med_type_katie_beckett = med_type_katie_beckett;
        }

        public String getDeath_benefit_state_federal() {
			return death_benefit_state_federal;
		}

	public void setDeath_benefit_state_federal(final String death_benefit_state_federal) {
			this.death_benefit_state_federal = death_benefit_state_federal;
		}

		public String getSocial_security_survivor() {
			return social_security_survivor;
		}

	public void setSocial_security_survivor(final String social_security_survivor) {
			this.social_security_survivor = social_security_survivor;
		}

		public String getVendor_payments() {
			return vendor_payments;
		}

	public void setVendor_payments(final String vendor_payments) {
			this.vendor_payments = vendor_payments;
		}

		/**
		 * @return the bfr_tax_chg_ind
		 */
		public String getBfr_tax_chg_ind() {
			return bfr_tax_chg_ind;
		}

		/**
		 * @param bfr_tax_chg_ind the bfr_tax_chg_ind to set
		 */
	public void setBfr_tax_chg_ind(final String bfr_tax_chg_ind) {
			this.bfr_tax_chg_ind = bfr_tax_chg_ind;
		}

		/**
		 * @return the inc_tax_chg_ind
		 */
		public String getInc_tax_chg_ind() {
			return inc_tax_chg_ind;
		}

		/**
		 * @param inc_tax_chg_ind the inc_tax_chg_ind to set
		 */
	public void setInc_tax_chg_ind(final String inc_tax_chg_ind) {
			this.inc_tax_chg_ind = inc_tax_chg_ind;
		}

		/**
		 * @return the nur_hme_chg_ind
		 */
		public String getNur_hme_chg_ind() {
			return nur_hme_chg_ind;
		}

		/**
		 * @param nur_hme_chg_ind the nur_hme_chg_ind to set
		 */
	public void setNur_hme_chg_ind(final String nur_hme_chg_ind) {
			this.nur_hme_chg_ind = nur_hme_chg_ind;
		}

		public String getDisaster_assistance() {
			return disaster_assistance;
		}

	public void setDisaster_assistance(final String disaster_assistance) {
			this.disaster_assistance = disaster_assistance;
		}

		public String getNon_business_equipment() {
			return non_business_equipment;
		}

	public void setNon_business_equipment(final String non_business_equipment) {
			this.non_business_equipment = non_business_equipment;
		}

		public String getHousehold_goods() {
			return household_goods;
		}

	public void setHousehold_goods(final String household_goods) {
			this.household_goods = household_goods;
		}

		public String getOther_non_countable() {
			return other_non_countable;
		}

	public void setOther_non_countable(final String other_non_countable) {
			this.other_non_countable = other_non_countable;
		}
	
		public String getPatient_fund() {
			return patient_fund;
		}

	public void setPatient_fund(final String patient_fund) {
			this.patient_fund = patient_fund;
		}

		/**
		 * @return the personal_info
		 */
		public String getPersonal_info() {
			return personal_info;
		}

		/**
		 * @param personal_info the personal_info to set
		 */
	public void setPersonal_info(final String personal_info) {
			this.personal_info = personal_info;
		}

		//Income Type New Addition
		private String inheritance_income;
		
		public String getInheritance_income() {
			return inheritance_income;
		}

	public void setInheritance_income(final String inheritance_income) {
			this.inheritance_income = inheritance_income;
		}

		public String getBonds() {
			return bonds;
		}

	public void setBonds(final String bonds) {
			this.bonds = bonds;
		}

		public String getDividend() {
			return dividend;
		}

	public void setDividend(final String dividend) {
			this.dividend = dividend;
		}

		public String getHealth_reimbursement_account() {
			return health_reimbursement_account;
		}

	public void setHealth_reimbursement_account(final String health_reimbursement_account) {
			this.health_reimbursement_account = health_reimbursement_account;
		}

		public String getIndividual_development_account() {
			return individual_development_account;
		}

	public void setIndividual_development_account(final String individual_development_account) {
			this.individual_development_account = individual_development_account;
		}

		public String getUniform_gifts_to_minors() {
			return uniform_gifts_to_minors;
		}

	public void setUniform_gifts_to_minors(final String uniform_gifts_to_minors) {
			this.uniform_gifts_to_minors = uniform_gifts_to_minors;
		}

		
		
		
		
	public String getMedicare_part_a() {
		return medicare_part_a;
	}

	public String getIncome_from_resource() {
		return income_from_resource;
	}

	public void setIncome_from_resource(final String income_from_resource) {
		this.income_from_resource = income_from_resource;
	}

	public String getIndian_gambling_payments() {
		return indian_gambling_payments;
	}

	public void setIndian_gambling_payments(final String indian_gambling_payments) {
		this.indian_gambling_payments = indian_gambling_payments;
	}

	public String getInheritance() {
		return inheritance;
	}

	public void setInheritance(final String inheritance) {
		this.inheritance = inheritance;
	}

	public String getInsuance_benefits() {
		return insuance_benefits;
	}

	public void setInsuance_benefits(final String insuance_benefits) {
		this.insuance_benefits = insuance_benefits;
	}

	public String getLoan_received() {
		return loan_received;
	}

	public void setLoan_received(final String loan_received) {
		this.loan_received = loan_received;
	}

	public String getLoan_repayment_income() {
		return loan_repayment_income;
	}

	public void setLoan_repayment_income(final String loan_repayment_income) {
		this.loan_repayment_income = loan_repayment_income;
	}

	public String getManaged_income() {
		return managed_income;
	}

	public void setManaged_income(final String managed_income) {
		this.managed_income = managed_income;
	}

	public String getMatch_grant() {
		return match_grant;
	}

	public void setMatch_grant(final String match_grant) {
		this.match_grant = match_grant;
	}

	public String getMontgomery_gi_bill() {
		return montgomery_gi_bill;
	}

	public void setMontgomery_gi_bill(final String montgomery_gi_bill) {
		this.montgomery_gi_bill = montgomery_gi_bill;
	}

	public String getOut_of_state_public() {
		return out_of_state_public;
	}

	public void setOut_of_state_public(final String out_of_state_public) {
		this.out_of_state_public = out_of_state_public;
	}

	public String getRefunds_from_dch() {
		return refunds_from_dch;
	}

	public void setRefunds_from_dch(final String refunds_from_dch) {
		this.refunds_from_dch = refunds_from_dch;
	}

	public String getRestitutions_settlements() {
		return restitutions_settlements;
	}

	public void setRestitutions_settlements(final String restitutions_settlements) {
		this.restitutions_settlements = restitutions_settlements;
	}

	public String getSenior_companion() {
		return senior_companion;
	}

	public void setSenior_companion(final String senior_companion) {
		this.senior_companion = senior_companion;
	}

	public String getSeverance_pay() {
		return severance_pay;
	}

	public void setSeverance_pay(final String severance_pay) {
		this.severance_pay = severance_pay;
	}

	public String getStrike_benefits() {
		return strike_benefits;
	}

	public void setStrike_benefits(final String strike_benefits) {
		this.strike_benefits = strike_benefits;
	}

	public String getTrade_readjustment() {
		return trade_readjustment;
	}

	public void setTrade_readjustment(final String trade_readjustment) {
		this.trade_readjustment = trade_readjustment;
	}

	public String getUniform_relocation() {
		return uniform_relocation;
	}

	public void setUniform_relocation(final String uniform_relocation) {
		this.uniform_relocation = uniform_relocation;
	}

	public String getUnion_funds() {
		return union_funds;
	}

	public void setUnion_funds(final String union_funds) {
		this.union_funds = union_funds;
	}

	public String getVendor_excluded() {
		return vendor_excluded;
	}

	public void setVendor_excluded(final String vendor_excluded) {
		this.vendor_excluded = vendor_excluded;
	}

	public String getVictim_restitution() {
		return victim_restitution;
	}

	public void setVictim_restitution(final String victim_restitution) {
		this.victim_restitution = victim_restitution;
	}

	public String getVolunteer_payment() {
		return volunteer_payment;
	}

	public void setVolunteer_payment(final String volunteer_payment) {
		this.volunteer_payment = volunteer_payment;
	}

	public String getVolunteer_payment_titlei() {
		return volunteer_payment_titlei;
	}

	public void setVolunteer_payment_titlei(final String volunteer_payment_titlei) {
		this.volunteer_payment_titlei = volunteer_payment_titlei;
	}

	public String getWia_training_and_allowance() {
		return wia_training_and_allowance;
	}

	public void setWia_training_and_allowance(final String wia_training_and_allowance) {
		this.wia_training_and_allowance = wia_training_and_allowance;
	}

	public String getIncluded_unearned_income() {
		return included_unearned_income;
	}

	public void setIncluded_unearned_income(final String included_unearned_income) {
		this.included_unearned_income = included_unearned_income;
	}

	public String getTanf_max_au_allotment() {
		return tanf_max_au_allotment;
	}

	public void setTanf_max_au_allotment(final String tanf_max_au_allotment) {
		this.tanf_max_au_allotment = tanf_max_au_allotment;
	}

	public String getTanf_max_grg_allotment() {
		return tanf_max_grg_allotment;
	}

	public void setTanf_max_grg_allotment(final String tanf_max_grg_allotment) {
		this.tanf_max_grg_allotment = tanf_max_grg_allotment;
	}

	public String getCharitable_donation() {
		return charitable_donation;
	}

	public void setCharitable_donation(final String charitable_donation) {
		this.charitable_donation = charitable_donation;
	}

	public String getChild_nutrition_payments() {
		return child_nutrition_payments;
	}

	public void setChild_nutrition_payments(final String child_nutrition_payments) {
		this.child_nutrition_payments = child_nutrition_payments;
	}

	public String getBlack_lung_benefits() {
		return black_lung_benefits;
	}

	public void setBlack_lung_benefits(final String black_lung_benefits) {
		this.black_lung_benefits = black_lung_benefits;
	}

	public String getChild_support_court() {
		return child_support_court;
	}

	public void setChild_support_court(final String child_support_court) {
		this.child_support_court = child_support_court;
	}

	public String getChild_support_gap_payment() {
		return child_support_gap_payment;
	}

	public void setChild_support_gap_payment(final String child_support_gap_payment) {
		this.child_support_gap_payment = child_support_gap_payment;
	}

	public String getCivil_service() {
		return civil_service;
	}

	public void setCivil_service(final String civil_service) {
		this.civil_service = civil_service;
	}

	public String getDeferred_compensation_plans() {
		return deferred_compensation_plans;
	}

	public void setDeferred_compensation_plans(final String deferred_compensation_plans) {
		this.deferred_compensation_plans = deferred_compensation_plans;
	}

	public String getDisability_insurance() {
		return disability_insurance;
	}

	public void setDisability_insurance(final String disability_insurance) {
		this.disability_insurance = disability_insurance;
	}

	public String getExcluded_unearned_income() {
		return excluded_unearned_income;
	}

	public void setExcluded_unearned_income(final String excluded_unearned_income) {
		this.excluded_unearned_income = excluded_unearned_income;
	}

	public String getFema_payment_disaster() {
		return fema_payment_disaster;
	}

	public void setFema_payment_disaster(final String fema_payment_disaster) {
		this.fema_payment_disaster = fema_payment_disaster;
	}

	public String getFema_payment_non_disaster() {
		return fema_payment_non_disaster;
	}

	public void setFema_payment_non_disaster(final String fema_payment_non_disaster) {
		this.fema_payment_non_disaster = fema_payment_non_disaster;
	}

	public String getHealth_savings_account() {
		return health_savings_account;
	}

	public void setHealth_savings_account(final String health_savings_account) {
		this.health_savings_account = health_savings_account;
	}

	public String getIn_kind_support() {
		return in_kind_support;
	}

	public void setIn_kind_support(final String in_kind_support) {
		this.in_kind_support = in_kind_support;
	}

	public String getFoster_grandparent_program() {
		return foster_grandparent_program;
	}

	public void setFoster_grandparent_program(final String foster_grandparent_program) {
		this.foster_grandparent_program = foster_grandparent_program;
	}

	public String getDisaster_unemployment() {
		return disaster_unemployment;
	}

	public void setDisaster_unemployment(final String disaster_unemployment) {
		this.disaster_unemployment = disaster_unemployment;
	}

	public String getDividends() {
		return dividends;
	}

	public void setDividends(final String dividends) {
		this.dividends = dividends;
	}

	public String getCharitable_donation_federal() {
		return charitable_donation_federal;
	}

	public void setCharitable_donation_federal(final String charitable_donation_federal) {
		this.charitable_donation_federal = charitable_donation_federal;
	}

	public void setMedicare_part_a(final String medicare_part_a) {
		this.medicare_part_a = medicare_part_a;
	}

	public String getMedicare_part_b() {
		return medicare_part_b;
	}

	public void setMedicare_part_b(final String medicare_part_b) {
		this.medicare_part_b = medicare_part_b;
	}

	public String getMedicare_part_c() {
		return medicare_part_c;
	}

	public void setMedicare_part_c(final String medicare_part_c) {
		this.medicare_part_c = medicare_part_c;
	}

	public String getMedicare_part_d() {
		return medicare_part_d;
	}

	public void setMedicare_part_d(final String medicare_part_d) {
		this.medicare_part_d = medicare_part_d;
	}

	public String getCssp_provider_payment() {
		return cssp_provider_payment;
	}

	public void setCssp_provider_payment(final String cssp_provider_payment) {
		this.cssp_provider_payment = cssp_provider_payment;
	}

	public String getAnimals_to_assist_disabled() {
		return animals_to_assist_disabled;
	}

	public void setAnimals_to_assist_disabled(final String animals_to_assist_disabled) {
		this.animals_to_assist_disabled = animals_to_assist_disabled;
	}

	public String getFuneral_death_expense() {
		return funeral_death_expense;
	}

	public void setFuneral_death_expense(final String funeral_death_expense) {
		this.funeral_death_expense = funeral_death_expense;
	}

	public String getBlind_work_expense() {
		return blind_work_expense;
	}

	public void setBlind_work_expense(final String blind_work_expense) {
		this.blind_work_expense = blind_work_expense;
	}

	public String getImpairment_work_expense() {
		return impairment_work_expense;
	}

	public void setImpairment_work_expense(final String impairment_work_expense) {
		this.impairment_work_expense = impairment_work_expense;
	}

	
	/**
	 * @return the othr_hlth_ins_resp
	 */
	public String getOthr_hlth_ins_resp() {
		return othr_hlth_ins_resp;
	}

	/**
	 * @param othr_hlth_ins_resp the othr_hlth_ins_resp to set
	 */
	public void setOthr_hlth_ins_resp(final String othr_hlth_ins_resp) {
		this.othr_hlth_ins_resp = othr_hlth_ins_resp;
	}

	/**
	 * @return the tax_claim_dependant_resp
	 */
	public String getTax_claim_dependant_resp() {
		return tax_claim_dependant_resp;
	}

	/**
	 * @return the hlth_ins_resp
	 */
	public String getHlth_ins_resp() {
		return hlth_ins_resp;
	}

	/**
	 * @param hlth_ins_resp the hlth_ins_resp to set
	 */
	public void setHlth_ins_resp(final String hlth_ins_resp) {
		this.hlth_ins_resp = hlth_ins_resp;
	}

	/**
	 * @param tax_claim_dependant_resp the tax_claim_dependant_resp to set
	 */
	public void setTax_claim_dependant_resp(final String tax_claim_dependant_resp) {
		this.tax_claim_dependant_resp = tax_claim_dependant_resp;
	}

	public String getOthr_incm_trbl_resp() {
		return othr_incm_trbl_resp;
	}

	/**
	 * @return the lost_health_ins_ind
	 */
	public String getLost_health_ins_ind() {
		return lost_health_ins_ind;
	}

	/**
	 * @param lost_health_ins_ind the lost_health_ins_ind to set
	 */
	public void setLost_health_ins_ind(final String lost_health_ins_ind) {
		this.lost_health_ins_ind = lost_health_ins_ind;
	}

	public void setOthr_incm_trbl_resp(final String othr_incm_trbl_resp) {
		this.othr_incm_trbl_resp = othr_incm_trbl_resp;
	}

	public String getCareTaker_resp() {
		return careTaker_resp;
	}

	public void setCareTaker_resp(final String careTaker_resp) {
		this.careTaker_resp = careTaker_resp;
	}

	public String getPrevent_eviction_resp() {
		return prevent_eviction_resp;
	}

	public void setPrevent_eviction_resp(final String prevent_eviction_resp) {
		this.prevent_eviction_resp = prevent_eviction_resp;
	}

	public String getDisaster_repair_resp() {
		return disaster_repair_resp;
	}

	public void setDisaster_repair_resp(final String disaster_repair_resp) {
		this.disaster_repair_resp = disaster_repair_resp;
	}

	public String getOther_housing_bill_resp() {
		return other_housing_bill_resp;
	}

	public void setOther_housing_bill_resp(final String other_housing_bill_resp) {
		this.other_housing_bill_resp = other_housing_bill_resp;
	}

	public String getSu_cst_ins_resp() {
		return su_cst_ins_resp;
	}

	public void setSu_cst_ins_resp(final String su_cst_ins_resp) {
		this.su_cst_ins_resp = su_cst_ins_resp;
	}

	/**
	 * @return the rlt_chg_stat_sw
	 */
	public String getRlt_chg_stat_sw() {
		return rlt_chg_stat_sw;
	}

	/**
	 * @param rlt_chg_stat_sw the rlt_chg_stat_sw to set
	 */
	public void setRlt_chg_stat_sw(final String rlt_chg_stat_sw) {
		this.rlt_chg_stat_sw = rlt_chg_stat_sw;
	}

	public String getAble_to_conceive_resp() {
		return able_to_conceive_resp;
	}

	/**
	 * @return the prsn_info_stat_sw
	 */
	public String getPrsn_info_stat_sw() {
		return prsn_info_stat_sw;
	}

	/**
	 * @param prsn_info_stat_sw the prsn_info_stat_sw to set
	 */
	public void setPrsn_info_stat_sw(final String prsn_info_stat_sw) {
		this.prsn_info_stat_sw = prsn_info_stat_sw;
	}

	public void setAble_to_conceive_resp(final String able_to_conceive_resp) {
		this.able_to_conceive_resp = able_to_conceive_resp;
	}

	public String getUnderweight_birth_resp() {
		return underweight_birth_resp;
	}

	public void setUnderweight_birth_resp(final String underweight_birth_resp) {
		this.underweight_birth_resp = underweight_birth_resp;
	}
	
	public String getPreg_add_stat_sw() {
		return preg_add_stat_sw;
	}

	public void setPreg_add_stat_sw(final String preg_add_stat_sw) {
		this.preg_add_stat_sw = preg_add_stat_sw;
	}

	public String getPreg_chg_stat_sw() {
		return preg_chg_stat_sw;
	}

	public void setPreg_chg_stat_sw(final String preg_chg_stat_sw) {
		this.preg_chg_stat_sw = preg_chg_stat_sw;
	}
	// End of addition by Srividhya 16Mar15 for RMC5 pregnancy changes
	
	public String getPers_prop_bus_eqpt() {
		return pers_prop_bus_eqpt;
	}

	public void setPers_prop_bus_eqpt(final String pers_prop_bus_eqpt) {
		this.pers_prop_bus_eqpt = pers_prop_bus_eqpt;
	}

	public String getPers_prop_cemetary_lot() {
		return pers_prop_cemetary_lot;
	}

	public void setPers_prop_cemetary_lot(final String pers_prop_cemetary_lot) {
		this.pers_prop_cemetary_lot = pers_prop_cemetary_lot;
	}

	public String getPers_prop_livestock() {
		return pers_prop_livestock;
	}

	public void setPers_prop_livestock(final String pers_prop_livestock) {
		this.pers_prop_livestock = pers_prop_livestock;
	}

	public String getPers_prop_saf_depst_box() {
		return pers_prop_saf_depst_box;
	}

	public void setPers_prop_saf_depst_box(final String pers_prop_saf_depst_box) {
		this.pers_prop_saf_depst_box = pers_prop_saf_depst_box;
	}

	public String getPers_prop_oth_val() {
		return pers_prop_oth_val;
	}

	public void setPers_prop_oth_val(final String pers_prop_oth_val) {
		this.pers_prop_oth_val = pers_prop_oth_val;
	}

	/**
	 * @return the medtyp_hsa_contrib
	 */
	public String getMedtyp_hsa_contrib() {
		return medtyp_hsa_contrib;
	}

	/**
	 * @param medtyp_hsa_contrib the medtyp_hsa_contrib to set
	 */
	public void setMedtyp_hsa_contrib(final String medtyp_hsa_contrib) {
		this.medtyp_hsa_contrib = medtyp_hsa_contrib;
	}

	/**
	 * @return the special_need_resp
	 */
	public String getSpecial_need_resp() {
		return special_need_resp;
	}

	/**
	 * @param special_need_resp the special_need_resp to set
	 */
	public void setSpecial_need_resp(final String special_need_resp) {
		this.special_need_resp = special_need_resp;
	}

	/**
	 * @return the foster_care_resp
	 */
	public String getFoster_care_resp() {
		return foster_care_resp;
	}

	/**
	 * @param foster_care_resp the foster_care_resp to set
	 */
	public void setFoster_care_resp(final String foster_care_resp) {
		this.foster_care_resp = foster_care_resp;
	}

	/**
	 * @return the former_foster_resp
	 */
	public String getFormer_foster_resp() {
		return former_foster_resp;
	}

	/**
	 * @param former_foster_resp the former_foster_resp to set
	 */
	public void setFormer_foster_resp(final String former_foster_resp) {
		this.former_foster_resp = former_foster_resp;
	}

	/**
	 * @return the child_protective_resp
	 */
	public String getChild_protective_resp() {
		return child_protective_resp;
	}

	/**
	 * @param child_protective_resp the child_protective_resp to set
	 */
	public void setChild_protective_resp(final String child_protective_resp) {
		this.child_protective_resp = child_protective_resp;
	}

	/**
	 * @return the living_prog_resp
	 */
	public String getLiving_prog_resp() {
		return living_prog_resp;
	}

	/**
	 * @param living_prog_resp the living_prog_resp to set
	 */
	public void setLiving_prog_resp(final String living_prog_resp) {
		this.living_prog_resp = living_prog_resp;
	}

	/**
	 * @return the grand_parent_resp
	 */
	public String getGrand_parent_resp() {
		return grand_parent_resp;
	}

	/**
	 * @param grand_parent_resp the grand_parent_resp to set
	 */
	public void setGrand_parent_resp(final String grand_parent_resp) {
		this.grand_parent_resp = grand_parent_resp;
	}

	/**
	 * @return the drug_felonies_resp
	 */
	public String getDrug_felonies_resp() {
		return drug_felonies_resp;
	}

	/**
	 * @param drug_felonies_resp the drug_felonies_resp to set
	 */
	public void setDrug_felonies_resp(final String drug_felonies_resp) {
		this.drug_felonies_resp = drug_felonies_resp;
	}

	/**
	 * @return the snap_tanf_disc_resp
	 */
	public String getSnap_tanf_disc_resp() {
		return snap_tanf_disc_resp;
	}

	/**
	 * @param snap_tanf_disc_resp the snap_tanf_disc_resp to set
	 */
	public void setSnap_tanf_disc_resp(final String snap_tanf_disc_resp) {
		this.snap_tanf_disc_resp = snap_tanf_disc_resp;
	}

	/**
	 * @return the avoid_prosc_resp
	 */
	public String getAvoid_prosc_resp() {
		return avoid_prosc_resp;
	}

	/**
	 * @param avoid_prosc_resp the avoid_prosc_resp to set
	 */
	public void setAvoid_prosc_resp(final String avoid_prosc_resp) {
		this.avoid_prosc_resp = avoid_prosc_resp;
	}

	/**
	 * @return the violating_parole_resp
	 */
	public String getViolating_parole_resp() {
		return violating_parole_resp;
	}

	/**
	 * @param violating_parole_resp the violating_parole_resp to set
	 */
	public void setViolating_parole_resp(final String violating_parole_resp) {
		this.violating_parole_resp = violating_parole_resp;
	}

	/**
	 * @return the convic_false_info_resp
	 */
	public String getConvic_false_info_resp() {
		return convic_false_info_resp;
	}

	/**
	 * @param convic_false_info_resp the convic_false_info_resp to set
	 */
	public void setConvic_false_info_resp(final String convic_false_info_resp) {
		this.convic_false_info_resp = convic_false_info_resp;
	}

	/**
	 * @return the voluntarily_quit_job_resp
	 */
	public String getVoluntarily_quit_job_resp() {
		return voluntarily_quit_job_resp;
	}

	/**
	 * @param voluntarily_quit_job_resp the voluntarily_quit_job_resp to set
	 */
	public void setVoluntarily_quit_job_resp(final String voluntarily_quit_job_resp) {
		this.voluntarily_quit_job_resp = voluntarily_quit_job_resp;
	}

	/**
	 * @return the trading_snap_resp
	 */
	public String getTrading_snap_resp() {
		return trading_snap_resp;
	}

	/**
	 * @param trading_snap_resp the trading_snap_resp to set
	 */
	public void setTrading_snap_resp(final String trading_snap_resp) {
		this.trading_snap_resp = trading_snap_resp;
	}

	/**
	 * @return the buy_sell_snap_resp
	 */
	public String getBuy_sell_snap_resp() {
		return buy_sell_snap_resp;
	}

	/**
	 * @param buy_sell_snap_resp the buy_sell_snap_resp to set
	 */
	public void setBuy_sell_snap_resp(final String buy_sell_snap_resp) {
		this.buy_sell_snap_resp = buy_sell_snap_resp;
	}

	/**
	 * @return the trade_snap_gun_resp
	 */
	public String getTrade_snap_gun_resp() {
		return trade_snap_gun_resp;
	}

	/**
	 * @param trade_snap_gun_resp the trade_snap_gun_resp to set
	 */
	public void setTrade_snap_gun_resp(final String trade_snap_gun_resp) {
		this.trade_snap_gun_resp = trade_snap_gun_resp;
	}

	/**
	 * @return the prev_ssi_resp
	 */
	public String getPrev_ssi_resp() {
		return prev_ssi_resp;
	}

	/**
	 * @param prev_ssi_resp the prev_ssi_resp to set
	 */
	public void setPrev_ssi_resp(final String prev_ssi_resp) {
		this.prev_ssi_resp = prev_ssi_resp;
	}

	/**
	 * @return the home_community_resp
	 */
	public String getHome_community_resp() {
		return home_community_resp;
	}

	/**
	 * @param home_community_resp the home_community_resp to set
	 */
	public void setHome_community_resp(final String home_community_resp) {
		this.home_community_resp = home_community_resp;
	}

	/**
	 * @return the tribal_health_resp
	 */
	public String getTribal_health_resp() {
		return tribal_health_resp;
	}

	/**
	 * @param tribal_health_resp the tribal_health_resp to set
	 */
	public void setTribal_health_resp(final String tribal_health_resp) {
		this.tribal_health_resp = tribal_health_resp;
	}

	/**
	 * @return the tribal_eligibility_resp
	 */
	public String getTribal_eligibility_resp() {
		return tribal_eligibility_resp;
	}

	/**
	 * @param tribal_eligibility_resp the tribal_eligibility_resp to set
	 */
	public void setTribal_eligibility_resp(final String tribal_eligibility_resp) {
		this.tribal_eligibility_resp = tribal_eligibility_resp;
	}

	/**
	 * @return the domestic_violence_resp
	 */
	public String getDomestic_violence_resp() {
		return domestic_violence_resp;
	}

	/**
	 * @param domestic_violence_resp the domestic_violence_resp to set
	 */
	public void setDomestic_violence_resp(final String domestic_violence_resp) {
		this.domestic_violence_resp = domestic_violence_resp;
	}

	/**
	 * @return the tanf_eppic_resp
	 */
	public String getTanf_eppic_resp() {
		return tanf_eppic_resp;
	}

	/**
	 * @param tanf_eppic_resp the tanf_eppic_resp to set
	 */
	public void setTanf_eppic_resp(final String tanf_eppic_resp) {
		this.tanf_eppic_resp = tanf_eppic_resp;
	}

	/**
	 * @return the emergency_medical_resp
	 */
	public String getEmergency_medical_resp() {
		return emergency_medical_resp;
	}

	/**
	 * @param emergency_medical_resp the emergency_medical_resp to set
	 */
	public void setEmergency_medical_resp(final String emergency_medical_resp) {
		this.emergency_medical_resp = emergency_medical_resp;
	}
	
	/**
	 * @return the outstate_bnft_resp
	 */
	public String getOutstate_bnft_resp() {
		return outstate_bnft_resp;
	}

	/**
	 * @param outstate_bnft_resp the outstate_bnft_resp to set
	 */
	public void setOutstate_bnft_resp(final String outstate_bnft_resp) {
		this.outstate_bnft_resp = outstate_bnft_resp;
	}

	/**
	 * @return the hospice_resp
	 */
	public String getHospice_resp() {
		return hospice_resp;
	}

	/**
	 * @param hospice_resp the hospice_resp to set
	 */
	public void setHospice_resp(final String hospice_resp) {
		this.hospice_resp = hospice_resp;
	}

	/**
	 * @return the medtyp_dental
	 */
	public String getMedtyp_dental() {
		return medtyp_dental;
	}

	/**
	 * @param medtyp_dental the medtyp_dental to set
	 */
	public void setMedtyp_dental(final String medtyp_dental) {
		this.medtyp_dental = medtyp_dental;
	}

	/**
	 * @return the medtyp_attendant_care
	 */
	public String getMedtyp_attendant_care() {
		return medtyp_attendant_care;
	}

	/**
	 * @param medtyp_attendant_care the medtyp_attendant_care to set
	 */
	public void setMedtyp_attendant_care(final String medtyp_attendant_care) {
		this.medtyp_attendant_care = medtyp_attendant_care;
	}

	/**
	 * @return the medtyp_doctor
	 */
	public String getMedtyp_doctor() {
		return medtyp_doctor;
	}

	/**
	 * @param medtyp_doctor the medtyp_doctor to set
	 */
	public void setMedtyp_doctor(final String medtyp_doctor) {
		this.medtyp_doctor = medtyp_doctor;
	}

	/**
	 * @return the medtyp_med_equip
	 */
	public String getMedtyp_med_equip() {
		return medtyp_med_equip;
	}

	/**
	 * @param medtyp_med_equip the medtyp_med_equip to set
	 */
	public void setMedtyp_med_equip(final String medtyp_med_equip) {
		this.medtyp_med_equip = medtyp_med_equip;
	}

	/**
	 * @return the medtyp_hosp_bills
	 */
	public String getMedtyp_hosp_bills() {
		return medtyp_hosp_bills;
	}

	/**
	 * @param medtyp_hosp_bills the medtyp_hosp_bills to set
	 */
	public void setMedtyp_hosp_bills(final String medtyp_hosp_bills) {
		this.medtyp_hosp_bills = medtyp_hosp_bills;
	}

	/**
	 * @return the medtyp_insur_premium
	 */
	public String getMedtyp_insur_premium() {
		return medtyp_insur_premium;
	}

	/**
	 * @param medtyp_insur_premium the medtyp_insur_premium to set
	 */
	public void setMedtyp_insur_premium(final String medtyp_insur_premium) {
		this.medtyp_insur_premium = medtyp_insur_premium;
	}

	/**
	 * @return the medtyp_rx_cost
	 */
	public String getMedtyp_rx_cost() {
		return medtyp_rx_cost;
	}

	/**
	 * @param medtyp_rx_cost the medtyp_rx_cost to set
	 */
	public void setMedtyp_rx_cost(final String medtyp_rx_cost) {
		this.medtyp_rx_cost = medtyp_rx_cost;
	}

	/**
	 * @return the medtyp_trans_med
	 */
	public String getMedtyp_trans_med() {
		return medtyp_trans_med;
	}

	/**
	 * @param medtyp_trans_med the medtyp_trans_med to set
	 */
	public void setMedtyp_trans_med(final String medtyp_trans_med) {
		this.medtyp_trans_med = medtyp_trans_med;
	}

	/**
	 * @return the medtyp_other
	 */
	public String getMedtyp_other() {
		return medtyp_other;
	}

	/**
	 * @param medtyp_other the medtyp_other to set
	 */
	public void setMedtyp_other(final String medtyp_other) {
		this.medtyp_other = medtyp_other;
	}
	
	

	/**
	 * @return the medical_bills
	 */


	/**
	 * @return the medical_bills_resp
	 */
	public String getMedical_bills_resp() {
		return medical_bills_resp;
	}

	/**
	 * @param medical_bills_resp the medical_bills_resp to set
	 */
	public void setMedical_bills_resp(final String medical_bills_resp) {
		this.medical_bills_resp = medical_bills_resp;
	}

	/**
	 * @return the child_obligation_resp
	 */
	public String getChild_obligation_resp() {
		return child_obligation_resp;
	}

	/**
	 * @param child_obligation_resp the child_obligation_resp to set
	 */
	public void setChild_obligation_resp(final String child_obligation_resp) {
		this.child_obligation_resp = child_obligation_resp;
	}

	/**
	 * @return the child_care_resp
	 */
	public String getChild_care_resp() {
		return child_care_resp;
	}

	/**
	 * @param child_care_resp the child_care_resp to set
	 */
	public void setChild_care_resp(final String child_care_resp) {
		this.child_care_resp = child_care_resp;
	}

	public String getTanf_ind() {
		return tanf_ind;
	}

	public void setTanf_ind(final String tanf_ind) {
		this.tanf_ind = tanf_ind;
	}

	private String housing_bill_others_resp;

	public String getUtility_standard_resp() {
		return utility_standard_resp;
	}

	public void setUtility_standard_resp(final String utility_standard_resp) {
		this.utility_standard_resp = utility_standard_resp;
	}

	public String getWork_related_expense_resp() {
		return work_related_expense_resp;
	}

	public void setWork_related_expense_resp(final String work_related_expense_resp) {
		this.work_related_expense_resp = work_related_expense_resp;
	}

	private String utility_bills_oil_resp;

	public String getUtility_bills_oil_resp() {
		return utility_bills_oil_resp;
	}

	public void setUtility_bills_oil_resp(final String utility_bills_oil_resp) {
		this.utility_bills_oil_resp = utility_bills_oil_resp;
	}

	public String getHousing_bill_others_resp() {
		return housing_bill_others_resp;
	}

	public void setHousing_bill_others_resp(final String housing_bill_others_resp) {
		this.housing_bill_others_resp = housing_bill_others_resp;
	}

	// EDSP edns
	public String getVehicle_asset_camper_resp() {
		return vehicle_asset_camper_resp;
	}

	public void setVehicle_asset_camper_resp(final String vehicle_asset_camper_resp) {
		this.vehicle_asset_camper_resp = vehicle_asset_camper_resp;
	}

	public String getBenefits_on_strike_resp() {
		return benefits_on_strike_resp;
	}

	public void setBenefits_on_strike_resp(final String benefits_on_strike_resp) {
		this.benefits_on_strike_resp = benefits_on_strike_resp;
	}

	public String getOthr_social_security_bnft_resp() {
		return othr_social_security_bnft_resp;
	}

	public void setOthr_social_security_bnft_resp(final String othr_social_security_bnft_resp) {
		this.othr_social_security_bnft_resp = othr_social_security_bnft_resp;
	}

	public String getInsurance_settlement_resp() {
		return insurance_settlement_resp;
	}

	public void setInsurance_settlement_resp(final String insurance_settlement_resp) {
		this.insurance_settlement_resp = insurance_settlement_resp;
	}

	public String getLottery_prize_winning_resp() {
		return lottery_prize_winning_resp;
	}

	public void setLottery_prize_winning_resp(final String lottery_prize_winning_resp) {
		this.lottery_prize_winning_resp = lottery_prize_winning_resp;
	}

	public String getBenefit_black_lung_resp() {
		return benefit_black_lung_resp;
	}

	public void setBenefit_black_lung_resp(final String benefit_black_lung_resp) {
		this.benefit_black_lung_resp = benefit_black_lung_resp;
	}

	public String getLoan_resp() {
		return loan_resp;
	}

	public void setLoan_resp(final String loan_resp) {
		this.loan_resp = loan_resp;
	}

	public String getCash_gifts_resp() {
		return cash_gifts_resp;
	}

	public void setCash_gifts_resp(final String cash_gifts_resp) {
		this.cash_gifts_resp = cash_gifts_resp;
	}

	public String getFood_clothing_util_rent_resp() {
		return food_clothing_util_rent_resp;
	}

	public void setFood_clothing_util_rent_resp(final String food_clothing_util_rent_resp) {
		this.food_clothing_util_rent_resp = food_clothing_util_rent_resp;
	}

	public String getStudent_financial_aid_resp() {
		return student_financial_aid_resp;
	}

	public void setStudent_financial_aid_resp(final String student_financial_aid_resp) {
		this.student_financial_aid_resp = student_financial_aid_resp;
	}

	public String getInheritance_resp() {
		return inheritance_resp;
	}

	public void setInheritance_resp(final String inheritance_resp) {
		this.inheritance_resp = inheritance_resp;
	}

	public String getTraining_allowance_resp() {
		return training_allowance_resp;
	}

	public void setTraining_allowance_resp(final String training_allowance_resp) {
		this.training_allowance_resp = training_allowance_resp;
	}

	/**
	 * @return the vehicle_asset_auto_resp
	 */
	public String getVehicle_asset_auto_resp() {
		return vehicle_asset_auto_resp;
	}

	/**
	 * @return the vehicle_asset_boat_resp
	 */
	public String getVehicle_asset_boat_resp() {
		return vehicle_asset_boat_resp;
	}

	/**
	 * @return the vehicle_asset_motorcycle_resp
	 */
	public String getVehicle_asset_motorcycle_resp() {
		return vehicle_asset_motorcycle_resp;
	}

	/**
	 * @return the vehicle_asset_other_resp
	 */
	public String getVehicle_asset_other_resp() {
		return vehicle_asset_other_resp;
	}

	public String getMed_type_prosthetic_resp() {
		return med_type_prosthetic_resp;
	}

	public void setMed_type_prosthetic_resp(final String med_type_prosthetic_resp) {
		this.med_type_prosthetic_resp = med_type_prosthetic_resp;
	}

	public String getMed_type_atndnt_meal_resp() {
		return med_type_atndnt_meal_resp;
	}

	public void setMed_type_atndnt_meal_resp(final String med_type_atndnt_meal_resp) {
		this.med_type_atndnt_meal_resp = med_type_atndnt_meal_resp;
	}

	public String getMed_type_animal_resp() {
		return med_type_animal_resp;
	}

	public void setMed_type_animal_resp(final String med_type_animal_resp) {
		this.med_type_animal_resp = med_type_animal_resp;
	}

	public String getMed_type_maintain_attndnt_resp() {
		return med_type_maintain_attndnt_resp;
	}

	public void setMed_type_maintain_attndnt_resp(final String med_type_maintain_attndnt_resp) {
		this.med_type_maintain_attndnt_resp = med_type_maintain_attndnt_resp;
	}

	public String getMed_type_inhome_resp() {
		return med_type_inhome_resp;
	}

	public void setMed_type_inhome_resp(final String med_type_inhome_resp) {
		this.med_type_inhome_resp = med_type_inhome_resp;
	}

	public String getMed_type_special_equip_resp() {
		return med_type_special_equip_resp;
	}

	public void setMed_type_special_equip_resp(final String med_type_special_equip_resp) {
		this.med_type_special_equip_resp = med_type_special_equip_resp;
	}

	public String getMed_type_eyeglasses_resp() {
		return med_type_eyeglasses_resp;
	}

	public void setMed_type_eyeglasses_resp(final String med_type_eyeglasses_resp) {
		this.med_type_eyeglasses_resp = med_type_eyeglasses_resp;
	}

	public String getMed_type_insurance_resp() {
		return med_type_insurance_resp;
	}

	public void setMed_type_insurance_resp(final String med_type_insurance_resp) {
		this.med_type_insurance_resp = med_type_insurance_resp;
	}

	public String getMed_type_bills_resp() {
		return med_type_bills_resp;
	}

	public void setMed_type_bills_resp(final String med_type_bills_resp) {
		this.med_type_bills_resp = med_type_bills_resp;
	}

	public String getMed_type_supplies_resp() {
		return med_type_supplies_resp;
	}

	public void setMed_type_supplies_resp(final String med_type_supplies_resp) {
		this.med_type_supplies_resp = med_type_supplies_resp;
	}

	public String getMed_type_nursing_resp() {
		return med_type_nursing_resp;
	}

	public void setMed_type_nursing_resp(final String med_type_nursing_resp) {
		this.med_type_nursing_resp = med_type_nursing_resp;
	}

	public String getMed_type_other_resp() {
		return med_type_other_resp;
	}

	public void setMed_type_other_resp(final String med_type_other_resp) {
		this.med_type_other_resp = med_type_other_resp;
	}

	public String getMed_type_out_patient_resp() {
		return med_type_out_patient_resp;
	}

	public void setMed_type_out_patient_resp(final String med_type_out_patient_resp) {
		this.med_type_out_patient_resp = med_type_out_patient_resp;
	}

	public String getMed_type_psychotherapy_resp() {
		return med_type_psychotherapy_resp;
	}

	public void setMed_type_psychotherapy_resp(final String med_type_psychotherapy_resp) {
		this.med_type_psychotherapy_resp = med_type_psychotherapy_resp;
	}

	public String getMed_type_prescribed_drug_resp() {
		return med_type_prescribed_drug_resp;
	}

	public void setMed_type_prescribed_drug_resp(final String med_type_prescribed_drug_resp) {
		this.med_type_prescribed_drug_resp = med_type_prescribed_drug_resp;
	}

	public String getMed_type_transportation_resp() {
		return med_type_transportation_resp;
	}

	public void setMed_type_transportation_resp(final String med_type_transportation_resp) {
		this.med_type_transportation_resp = med_type_transportation_resp;
	}

	/**
	 * @return the vehicle_asset_recreation_resp
	 */
	public String getVehicle_asset_recreation_resp() {
		return vehicle_asset_recreation_resp;
	}

	/**
	 * @return the vehicle_asset_animal_drwn_resp
	 */
	public String getVehicle_asset_animal_drwn_resp() {
		return vehicle_asset_animal_drwn_resp;
	}

	/**
	 * @return the vehicle_asset_tractor_resp
	 */
	public String getVehicle_asset_tractor_resp() {
		return vehicle_asset_tractor_resp;
	}

	/**
	 * @return the vehicle_asset_golf_cart_resp
	 */
	public String getVehicle_asset_golf_cart_resp() {
		return vehicle_asset_golf_cart_resp;
	}

	/**
	 * @return the vehicle_asset_nmot_camper_resp
	 */
	public String getVehicle_asset_nmot_camper_resp() {
		return vehicle_asset_nmot_camper_resp;
	}

	/**
	 * @param vehicle_asset_auto_resp
	 *            the vehicle_asset_auto_resp to set
	 */
	public void setVehicle_asset_auto_resp(final String vehicle_asset_auto_resp) {
		this.vehicle_asset_auto_resp = vehicle_asset_auto_resp;
	}

	/**
	 * @param vehicle_asset_boat_resp
	 *            the vehicle_asset_boat_resp to set
	 */
	public void setVehicle_asset_boat_resp(final String vehicle_asset_boat_resp) {
		this.vehicle_asset_boat_resp = vehicle_asset_boat_resp;
	}

	/**
	 * @param vehicle_asset_motorcycle_resp
	 *            the vehicle_asset_motorcycle_resp to set
	 */
	public void setVehicle_asset_motorcycle_resp(final String vehicle_asset_motorcycle_resp) {
		this.vehicle_asset_motorcycle_resp = vehicle_asset_motorcycle_resp;
	}

	/**
	 * @param vehicle_asset_other_resp
	 *            the vehicle_asset_other_resp to set
	 */
	public void setVehicle_asset_other_resp(final String vehicle_asset_other_resp) {
		this.vehicle_asset_other_resp = vehicle_asset_other_resp;
	}

	/**
	 * @param vehicle_asset_recreation_resp
	 *            the vehicle_asset_recreation_resp to set
	 */
	public void setVehicle_asset_recreation_resp(final String vehicle_asset_recreation_resp) {
		this.vehicle_asset_recreation_resp = vehicle_asset_recreation_resp;
	}

	/**
	 * @param vehicle_asset_animal_drwn_resp
	 *            the vehicle_asset_animal_drwn_resp to set
	 */
	public void setVehicle_asset_animal_drwn_resp(final String vehicle_asset_animal_drwn_resp) {
		this.vehicle_asset_animal_drwn_resp = vehicle_asset_animal_drwn_resp;
	}

	/**
	 * @param vehicle_asset_tractor_resp
	 *            the vehicle_asset_tractor_resp to set
	 */
	public void setVehicle_asset_tractor_resp(final String vehicle_asset_tractor_resp) {
		this.vehicle_asset_tractor_resp = vehicle_asset_tractor_resp;
	}

	/**
	 * @param vehicle_asset_golf_cart_resp
	 *            the vehicle_asset_golf_cart_resp to set
	 */
	public void setVehicle_asset_golf_cart_resp(final String vehicle_asset_golf_cart_resp) {
		this.vehicle_asset_golf_cart_resp = vehicle_asset_golf_cart_resp;
	}

	/**
	 * @param vehicle_asset_nmot_camper_resp
	 *            the vehicle_asset_nmot_camper_resp to set
	 */
	public void setVehicle_asset_nmot_camper_resp(final String vehicle_asset_nmot_camper_resp) {
		this.vehicle_asset_nmot_camper_resp = vehicle_asset_nmot_camper_resp;
	}

	/**
	 * returns the othr_aset_bur_resp value.
	 */
	public String getOther_asset_burial_resp() {
		return other_asset_burial_resp;
	}

	/**
	 * returns the othr_aset_l_i_resp value.
	 */
	public String getOther_aset_life_insurance_resp() {
		return other_aset_life_insurance_resp;
	}

	/**
	 * returns the othr_aset_p_p_resp value.
	 */
	public String getOther_asset_personal_prop_resp() {
		return other_asset_personal_prop_resp;
	}

	/**
	 * returns the othr_aset_r_p_resp value.
	 */
	public String getOther_asset_real_property_resp() {
		return other_asset_real_property_resp;
	}

	/**
	 * returns the othr_aset_veh_resp value.
	 */
	public String getOther_asset_vehicle_resp() {
		return other_asset_vehicle_resp;
	}

	/**
	 * sets the othr_aset_bur_resp value.
	 */
	public void setOther_asset_burial_resp(final String other_asset_burial_resp) {
		this.other_asset_burial_resp = other_asset_burial_resp;
	}

	/**
	 * sets the othr_aset_l_i_resp value.
	 */
	public void setOther_aset_life_insurance_resp(final String other_aset_life_insurance_resp) {
		this.other_aset_life_insurance_resp = other_aset_life_insurance_resp;
	}

	/**
	 * sets the othr_aset_p_p_resp value.
	 */
	public void setOther_asset_personal_prop_resp(final String other_asset_personal_prop_resp) {
		this.other_asset_personal_prop_resp = other_asset_personal_prop_resp;
	}

	/**
	 * sets the othr_aset_r_p_resp value.
	 */
	public void setOther_asset_real_property_resp(final String other_asset_real_property_resp) {
		this.other_asset_real_property_resp = other_asset_real_property_resp;
	}

	/**
	 * sets the othr_aset_veh_resp value.
	 */
	public void setOther_asset_vehicle_resp(final String other_asset_vehicle_resp) {
		this.other_asset_vehicle_resp = other_asset_vehicle_resp;
	}

	public String getLiquid_asset_bank_acc_resp() {
		return liquid_asset_bank_acc_resp;
	}

	public String getReal_asset_land_resp() {
		return real_asset_land_resp;
	}

	public void setReal_asset_land_resp(final String real_asset_land_resp) {
		this.real_asset_land_resp = real_asset_land_resp;
	}

	public String getReal_asset_mobile_home_resp() {
		return real_asset_mobile_home_resp;
	}

	public void setReal_asset_mobile_home_resp(final String real_asset_mobile_home_resp) {
		this.real_asset_mobile_home_resp = real_asset_mobile_home_resp;
	}

	public String getReal_asset_other_resp() {
		return real_asset_other_resp;
	}

	public void setReal_asset_other_resp(final String real_asset_other_resp) {
		this.real_asset_other_resp = real_asset_other_resp;
	}

	public String getReal_asset_life_estate_resp() {
		return real_asset_life_estate_resp;
	}

	public void setReal_asset_life_estate_resp(final String real_asset_life_estate_resp) {
		this.real_asset_life_estate_resp = real_asset_life_estate_resp;
	}

	public String getReal_asset_house_resp() {
		return real_asset_house_resp;
	}

	public void setReal_asset_house_resp(final String real_asset_house_resp) {
		this.real_asset_house_resp = real_asset_house_resp;
	}

	public String getReal_asset_unoccupy_home_resp() {
		return real_asset_unoccupy_home_resp;
	}

	public void setReal_asset_unoccupy_home_resp(final String real_asset_unoccupy_home_resp) {
		this.real_asset_unoccupy_home_resp = real_asset_unoccupy_home_resp;
	}

	public String getReal_asset_home_resp() {
		return real_asset_home_resp;
	}

	public void setReal_asset_home_resp(final String real_asset_home_resp) {
		this.real_asset_home_resp = real_asset_home_resp;
	}

	public String getLife_ins_asset_whole_life_resp() {
		return life_ins_asset_whole_life_resp;
	}

	public void setLife_ins_asset_whole_life_resp(final String life_ins_asset_whole_life_resp) {
		this.life_ins_asset_whole_life_resp = life_ins_asset_whole_life_resp;
	}

	public String getLife_insurance_asset_term_resp() {
		return life_insurance_asset_term_resp;
	}

	public void setLife_insurance_asset_term_resp(final String life_insurance_asset_term_resp) {
		this.life_insurance_asset_term_resp = life_insurance_asset_term_resp;
	}

	public String getLife_ins_asest_group_life_resp() {
		return life_ins_asest_group_life_resp;
	}

	public void setLife_ins_asest_group_life_resp(final String life_ins_asest_group_life_resp) {
		this.life_ins_asest_group_life_resp = life_ins_asest_group_life_resp;
	}

	public String getLife_ins_asset_group_term_resp() {
		return life_ins_asset_group_term_resp;
	}

	public void setLife_ins_asset_group_term_resp(final String life_ins_asset_group_term_resp) {
		this.life_ins_asset_group_term_resp = life_ins_asset_group_term_resp;
	}

	public String getLife_ins_asset_universal_resp() {
		return life_ins_asset_universal_resp;
	}

	public void setLife_ins_asset_universal_resp(final String life_ins_asset_universal_resp) {
		this.life_ins_asset_universal_resp = life_ins_asset_universal_resp;
	}

	public String getLife_insurance_other_resp() {
		return life_insurance_other_resp;
	}

	public void setLife_insurance_other_resp(final String life_insurance_other_resp) {
		this.life_insurance_other_resp = life_insurance_other_resp;
	}

	public String getLiquid_asset_other_type_resp() {
		return liquid_asset_other_type_resp;
	}

	public void setLiquid_asset_other_type_resp(final String liquid_asset_other_type_resp) {
		this.liquid_asset_other_type_resp = liquid_asset_other_type_resp;
	}

	public void setLiquid_asset_bank_acc_resp(final String liquid_asset_bank_acc_resp) {
		this.liquid_asset_bank_acc_resp = liquid_asset_bank_acc_resp;
	}

	public String getLiquid_asset_ira_resp() {
		return liquid_asset_ira_resp;
	}

	public void setLiquid_asset_ira_resp(final String liquid_asset_ira_resp) {
		this.liquid_asset_ira_resp = liquid_asset_ira_resp;
	}

	public String getLiquid_asset_irs_retirmnt_resp() {
		return liquid_asset_irs_retirmnt_resp;
	}

	public String getLiquid_aset_disable_blind_resp() {
		return liquid_aset_disable_blind_resp;
	}

	public void setLiquid_aset_disable_blind_resp(final String liquid_aset_disable_blind_resp) {
		this.liquid_aset_disable_blind_resp = liquid_aset_disable_blind_resp;
	}

	public String getLiquid_asset_savings_acc_resp() {
		return liquid_asset_savings_acc_resp;
	}

	public void setLiquid_asset_savings_acc_resp(final String liquid_asset_savings_acc_resp) {
		this.liquid_asset_savings_acc_resp = liquid_asset_savings_acc_resp;
	}

	public void setLiquid_asset_irs_retirmnt_resp(final String liquid_asset_irs_retirmnt_resp) {
		this.liquid_asset_irs_retirmnt_resp = liquid_asset_irs_retirmnt_resp;
	}

	public String getLiquid_asset_stocks_bonds_resp() {
		return liquid_asset_stocks_bonds_resp;
	}

	public void setLiquid_asset_stocks_bonds_resp(final String liquid_asset_stocks_bonds_resp) {
		this.liquid_asset_stocks_bonds_resp = liquid_asset_stocks_bonds_resp;
	}

	public String getLiquid_asset_trust_fund_resp() {
		return liquid_asset_trust_fund_resp;
	}

	public void setLiquid_asset_trust_fund_resp(final String liquid_asset_trust_fund_resp) {
		this.liquid_asset_trust_fund_resp = liquid_asset_trust_fund_resp;
	}

	public String getLiquid_asset_other_response() {
		return liquid_asset_other_response;
	}

	public void setLiquid_asset_other_response(final String liquid_asset_other_response) {
		this.liquid_asset_other_response = liquid_asset_other_response;
	}

	public String getOther_asset_transfer_resp() {
		return other_asset_transfer_resp;
	}

	public void setOther_asset_transfer_resp(final String other_asset_transfer_resp) {
		this.other_asset_transfer_resp = other_asset_transfer_resp;
	}

	public String getLiquid_asset_pension_plan_resp() {
		return liquid_asset_pension_plan_resp;
	}

	public void setLiquid_asset_pension_plan_resp(final String liquid_asset_pension_plan_resp) {
		this.liquid_asset_pension_plan_resp = liquid_asset_pension_plan_resp;
	}

	public String getLiquid_asset_promissory_resp() {
		return liquid_asset_promissory_resp;
	}

	public void setLiquid_asset_promissory_resp(final String liquid_asset_promissory_resp) {
		this.liquid_asset_promissory_resp = liquid_asset_promissory_resp;
	}

	public String getLiquid_asset_retirement_resp() {
		return liquid_asset_retirement_resp;
	}

	public void setLiquid_asset_retirement_resp(final String liquid_asset_retirement_resp) {
		this.liquid_asset_retirement_resp = liquid_asset_retirement_resp;
	}

	public String getMoved_into_home_response() {
		return moved_into_home_response;
	}

	public void setMoved_into_home_response(final String moved_into_home_response) {
		this.moved_into_home_response = moved_into_home_response;
	}

	public String getMoved_out_of_home_resp() {
		return moved_out_of_home_resp;
	}

	public void setMoved_out_of_home_resp(final String moved_out_of_home_resp) {
		this.moved_out_of_home_resp = moved_out_of_home_resp;
	}

	/**
	 * sets the emergency_medical_service_resp value.
	 */
	public void setMedical_service_resp(final String medical_service_resp) {
		this.medical_service_resp = medical_service_resp;
	}

	/**
	 * returns the emergency_medical_service_resp value.
	 */
	public String getMedical_service_resp() {
		return medical_service_resp;
	}

	/**
	 * sets the emergency_medical_service_resp value.
	 */
	public void setEmergency_medical_service_resp(final String emergency_medical_service_resp) {
		this.emergency_medical_service_resp = emergency_medical_service_resp;
	}

	/**
	 * returns the emergency_medical_service_resp value.
	 */
	public String getEmergency_medical_service_resp() {
		return emergency_medical_service_resp;
	}

	/**
	 * sets the parole_violation_Resp value.
	 */
	public void setParole_violation_resp(final String parole_violation_resp) {
		this.parole_violation_resp = parole_violation_resp;
	}

	/**
	 * returns the emergency_medical_service_resp value.
	 */
	public String getParole_violation_resp() {
		return parole_violation_resp;
	}

	/**
	 * sets the room_board_resp value.
	 */
	public void setRoom_board_resp(final String room_board_resp) {
		this.room_board_resp = room_board_resp;
	}

	/**
	 * returns the room_board_resp value.
	 */
	public String getRoom_board_resp() {
		return room_board_resp;
	}

	/**
	 * sets the room_board_resp value.
	 */
	public void setCurrent_past_job_resp(final String current_past_job_resp) {
		this.current_past_job_resp = current_past_job_resp;
	}

	/**
	 * returns the room_board_resp value.
	 */
	public String getCurrent_past_job_resp() {
		return current_past_job_resp;
	}

	// EDSP-CP mods END
	/**
	 * returns the head_of_household_resp value.
	 */
	public String getHead_of_household_resp() {
		return head_of_household_resp;
	}

	/**
	 * sets the head_of_household_resp value.
	 */
	public void setHead_of_household_resp(final String head_of_household_resp) {
		this.head_of_household_resp = head_of_household_resp;
	}

	// EDSP Ends

	/**
	 * sets the bnft_mapp_resp value.
	 */
	public void setBnft_mapp_resp(final String bnft_mapp_resp) {
		this.bnft_mapp_resp = bnft_mapp_resp;
	}

	/**
	 * returns the schl_enrl_resp value.
	 **/
	public String getSchool_enrollment_resp() {
		return school_enrollment_resp;
	}

	/**
	 * sets the schl_enrl_resp value.
	 */
	public void setSchool_enrollment_resp(final String school_enrollment_resp) {
		this.school_enrollment_resp = school_enrollment_resp;
	}
	

	/**
	 * @return the hospital_stay_resp
	 */
	public String getHospital_stay_resp() {
		return hospital_stay_resp;
	}

	/**
	 * @param hospital_stay_resp the hospital_stay_resp to set
	 */
	public void setHospital_stay_resp(final String hospital_stay_resp) {
		this.hospital_stay_resp = hospital_stay_resp;
	}

	/**
	 * returns the bnft_mapp_resp value.
	 */
	public String getBnft_mapp_resp() {
		return bnft_mapp_resp;
	}

	/**
	 * returns the li_aset_g_l_resp value.
	 */
	public String getLi_aset_g_l_resp() {
		return li_aset_g_l_resp;
	}

	/**
	 * returns the li_aset_g_t_resp value.
	 */
	public String getLi_aset_g_t_resp() {
		return li_aset_g_t_resp;
	}

	/**
	 * returns the li_aset_trm_resp value.
	 */
	public String getLi_aset_trm_resp() {
		return li_aset_trm_resp;
	}

	/**
	 * returns the li_aset_unv_resp value.
	 */
	public String getLi_aset_unv_resp() {
		return li_aset_unv_resp;
	}

	/**
	 * returns the li_aset_w_l_resp value.
	 */
	public String getLi_aset_w_l_resp() {
		return li_aset_w_l_resp;
	}

	/**
	 * returns the lqd_aset_c_a_resp value.
	 */
	public String getLqd_aset_c_a_resp() {
		return lqd_aset_c_a_resp;
	}

	/*	*//**
	 * returns the lqd_aset_cash_resp value.
	 */
	/*
	 * public String getLqd_aset_cash_resp(){ return lqd_aset_cash_resp; }
	 */
	/**
	 * returns the lqd_aset_eb_a_resp value.
	 */
	public String getLqd_aset_eb_a_resp() {
		return lqd_aset_eb_a_resp;
	}

	/**
	 * returns the lqd_aset_h_s_resp value.
	 */
	public String getLqd_aset_h_s_resp() {
		return lqd_aset_h_s_resp;
	}

	/**
	 * returns the lqd_aset_ira_resp value.
	 */
	public String getLqd_aset_ira_resp() {
		return lqd_aset_ira_resp;
	}

	/**
	 * returns the lqd_aset_k_p_resp value.
	 */
	public String getLqd_aset_k_p_resp() {
		return lqd_aset_k_p_resp;
	}

	/**
	 * returns the lqd_aset_m_o_resp value.
	 */
	public String getLqd_aset_m_o_resp() {
		return lqd_aset_m_o_resp;
	}

	/**
	 * returns the lqd_aset_mm_a_resp value.
	 */
	public String getLqd_aset_mm_a_resp() {
		return lqd_aset_mm_a_resp;
	}

	/**
	 * returns the lqd_aset_o_t_resp value.
	 */
	public String getLqd_aset_o_t_resp() {
		return lqd_aset_o_t_resp;
	}

	/**
	 * returns the lqd_aset_othr_resp value.
	 */
	public String getLqd_aset_othr_resp() {
		return lqd_aset_othr_resp;
	}

	/**
	 * returns the lqd_aset_s_a_resp value.
	 */
	public String getLqd_aset_s_a_resp() {
		return lqd_aset_s_a_resp;
	}

	/**
	 * returns the lqd_aset_s_c_resp value.
	 */
	public String getLqd_aset_s_c_resp() {
		return lqd_aset_s_c_resp;
	}

	/**
	 * returns the lqd_aset_st_b_resp value.
	 */
	public String getLqd_aset_st_b_resp() {
		return lqd_aset_st_b_resp;
	}

	/**
	 * returns the lqd_aset_tr_f_resp value.
	 */
	public String getLqd_aset_tr_f_resp() {
		return lqd_aset_tr_f_resp;
	}

	/**
	 * returns the lqd_aset_us_b_resp value.
	 */
	public String getLqd_aset_us_b_resp() {
		return lqd_aset_us_b_resp;
	}

	/**
	 * /** returns the othr_aset_xfr_resp value.
	 */
	/*
	 * public String getOthr_aset_xfr_resp(){ return othr_aset_xfr_resp; }
	 */
	/**
	 * returns the real_aset_apt_resp value.
	 */
	public String getReal_aset_apt_resp() {
		return real_aset_apt_resp;
	}

	/**
	 * returns the real_aset_com_resp value.
	 */
	public String getReal_aset_com_resp() {
		return real_aset_com_resp;
	}

	/**
	 * returns the real_aset_con_resp value.
	 */
	public String getReal_aset_con_resp() {
		return real_aset_con_resp;
	}

	/**
	 * returns the real_aset_dup_resp value.
	 */
	public String getReal_aset_dup_resp() {
		return real_aset_dup_resp;
	}

	/**
	 * returns the real_aset_frm_resp value.
	 */
	public String getReal_aset_frm_resp() {
		return real_aset_frm_resp;
	}

	/**
	 * returns the real_aset_hse_resp value.
	 */
	public String getReal_aset_hse_resp() {
		return real_aset_hse_resp;
	}

	/**
	 * returns the real_aset_lnd_resp value.
	 */
	public String getReal_aset_lnd_resp() {
		return real_aset_lnd_resp;
	}

	/**
	 * returns the real_aset_m_h_resp value.
	 */
	public String getReal_aset_m_h_resp() {
		return real_aset_m_h_resp;
	}

	/**
	 * returns the real_aset_oth_resp value.
	 */
	public String getReal_aset_oth_resp() {
		return real_aset_oth_resp;
	}

	/**
	 * returns the veh_aset_anml_resp value.
	 */
	public String getVeh_aset_anml_resp() {
		return veh_aset_anml_resp;
	}

	/**
	 * returns the veh_aset_arpl_resp value.
	 */
	public String getVeh_aset_arpl_resp() {
		return veh_aset_arpl_resp;
	}

	/**
	 * returns the veh_aset_auto_resp value.
	 */
	public String getVeh_aset_auto_resp() {
		return veh_aset_auto_resp;
	}

	/**
	 * returns the veh_aset_boat_resp value.
	 */
	public String getVeh_aset_boat_resp() {
		return veh_aset_boat_resp;
	}

	/**
	 * returns the veh_aset_bus_resp value.
	 */
	public String getVeh_aset_bus_resp() {
		return veh_aset_bus_resp;
	}

	/**
	 * returns the veh_aset_camp_resp value.
	 */
	public String getVeh_aset_camp_resp() {
		return veh_aset_camp_resp;
	}

	/**
	 * returns the veh_aset_fimp_resp value.
	 */
	public String getVeh_aset_fimp_resp() {
		return veh_aset_fimp_resp;
	}

	/**
	 * returns the veh_aset_fmeq_resp value.
	 */
	public String getVeh_aset_fmeq_resp() {
		return veh_aset_fmeq_resp;
	}

	/**
	 * returns the veh_aset_ftrc_resp value.
	 */
	public String getVeh_aset_ftrc_resp() {
		return veh_aset_ftrc_resp;
	}

	/**
	 * returns the veh_aset_ftrl_resp value.
	 */
	public String getVeh_aset_ftrl_resp() {
		return veh_aset_ftrl_resp;
	}

	/**
	 * returns the veh_aset_lskd_resp value.
	 */
	public String getVeh_aset_lskd_resp() {
		return veh_aset_lskd_resp;
	}

	/**
	 * returns the veh_aset_mcyc_resp value.
	 */
	public String getVeh_aset_mcyc_resp() {
		return veh_aset_mcyc_resp;
	}

	/**
	 * returns the veh_aset_mped_resp value.
	 */
	public String getVeh_aset_mped_resp() {
		return veh_aset_mped_resp;
	}

	/**
	 * returns the veh_aset_nm_b_resp value.
	 */
	public String getVeh_aset_nm_b_resp() {
		return veh_aset_nm_b_resp;
	}

	/**
	 * returns the veh_aset_othr_resp value.
	 */
	public String getVeh_aset_othr_resp() {
		return veh_aset_othr_resp;
	}

	/**
	 * returns the veh_aset_rv_resp value.
	 */
	public String getVeh_aset_rv_resp() {
		return veh_aset_rv_resp;
	}

	/**
	 * returns the veh_aset_s_mb_resp value.
	 */
	public String getVeh_aset_s_mb_resp() {
		return veh_aset_s_mb_resp;
	}

	/**
	 * returns the veh_aset_trk_resp value.
	 */
	public String getVeh_aset_trk_resp() {
		return veh_aset_trk_resp;
	}

	/**
	 * returns the veh_aset_trlr_resp value.
	 */
	public String getVeh_aset_trlr_resp() {
		return veh_aset_trlr_resp;
	}

	/**
	 * returns the veh_aset_van_resp value.
	 */
	public String getVeh_aset_van_resp() {
		return veh_aset_van_resp;
	}

	/**
	 * returns the bury_aset_c_resp value.
	 */
	public String getBury_aset_c_resp() {
		return bury_aset_c_resp;
	}

	/**
	 * returns the bury_aset_ibt_resp value.
	 */
	public String getBury_aset_ibt_resp() {
		return bury_aset_ibt_resp;
	}

	/**
	 * returns the bury_aset_ins_resp value.
	 */
	public String getBury_aset_ins_resp() {
		return bury_aset_ins_resp;
	}

	/**
	 * returns the bury_aset_mas_resp value.
	 */
	public String getBury_aset_mas_resp() {
		return bury_aset_mas_resp;
	}

	/**
	 * returns the bury_aset_oth_resp value.
	 */
	public String getBury_aset_oth_resp() {
		return bury_aset_oth_resp;
	}

	/**
	 * returns the bury_aset_plt_resp value.
	 */
	public String getBury_aset_plt_resp() {
		return bury_aset_plt_resp;
	}

	/**
	 * returns the bury_aset_rbt_resp value.
	 */
	public String getBury_aset_rbt_resp() {
		return bury_aset_rbt_resp;
	}

	/**
	 * returns the bury_aset_v_resp value.
	 */
	public String getBury_aset_v_resp() {
		return bury_aset_v_resp;
	}

	/**
	 * sets the bury_aset_c_resp value.
	 */
	public void setBury_aset_c_resp(final String bury_aset_c_resp) {
		this.bury_aset_c_resp = bury_aset_c_resp;
	}

	/**
	 * sets the bury_aset_ibt_resp value.
	 */
	public void setBury_aset_ibt_resp(final String bury_aset_ibt_resp) {
		this.bury_aset_ibt_resp = bury_aset_ibt_resp;
	}

	/**
	 * sets the bury_aset_ins_resp value.
	 */
	public void setBury_aset_ins_resp(final String bury_aset_ins_resp) {
		this.bury_aset_ins_resp = bury_aset_ins_resp;
	}

	/**
	 * sets the bury_aset_mas_resp value.
	 */
	public void setBury_aset_mas_resp(final String bury_aset_mas_resp) {
		this.bury_aset_mas_resp = bury_aset_mas_resp;
	}

	/**
	 * sets the bury_aset_oth_resp value.
	 */
	public void setBury_aset_oth_resp(final String bury_aset_oth_resp) {
		this.bury_aset_oth_resp = bury_aset_oth_resp;
	}

	/**
	 * sets the bury_aset_plt_resp value.
	 */
	public void setBury_aset_plt_resp(final String bury_aset_plt_resp) {
		this.bury_aset_plt_resp = bury_aset_plt_resp;
	}

	/**
	 * sets the bury_aset_rbt_resp value.
	 */
	public void setBury_aset_rbt_resp(final String bury_aset_rbt_resp) {
		this.bury_aset_rbt_resp = bury_aset_rbt_resp;
	}

	/**
	 * sets the bury_aset_v_resp value.
	 */
	public void setBury_aset_v_resp(final String bury_aset_v_resp) {
		this.bury_aset_v_resp = bury_aset_v_resp;
	}

	/**
	 * returns the trb_cmdy_resp value.
	 */
	public String getTrb_cmdy_resp() {
		return trb_cmdy_resp;
	}

	/**
	 * sets the trb_cmdy_resp value.
	 */
	public void setTrb_cmdy_resp(final String trb_cmdy_resp) {
		this.trb_cmdy_resp = trb_cmdy_resp;
	}

	/**
	 * sets the past_hc_cvrg_resp value.
	 */
	public void setPast_hc_cvrg_resp(final String past_hc_cvrg_resp) {
		this.past_hc_cvrg_resp = past_hc_cvrg_resp;
	}

	/**
	 * returns the past_hc_cvrg_resp value.
	 */
	public String getPast_hc_cvrg_resp() {
		return past_hc_cvrg_resp;
	}

	/**
	 * returns the app_num value.
	 */
	public String getApp_num() {
		return app_num;
	}

	/**
	 * sets the app_num value.
	 */
	public void setApp_num(final String app_num) {
		this.app_num = app_num;
	}

	/**
	 * returns the indv_seq_num value.
	 */
	public String getIndv_seq_num() {
		return indv_seq_num;
	}

	/**
	 * sets the indv_seq_num value.
	 */
	public void setIndv_seq_num(final String indv_seq_num) {
		this.indv_seq_num = indv_seq_num;
	}

	/**
	 * returns the acdt_resp value.
	 */
	public String getAcdt_resp() {
		return acdt_resp;
	}

	/**
	 * sets the acdt_resp value.
	 */
	public void setAcdt_resp(final String acdt_resp) {
		this.acdt_resp = acdt_resp;
	}

	/**
	 * returns the adpt_asst_resp value.
	 */
	public String getAdpt_asst_resp() {
		return adpt_asst_resp;
	}

	/**
	 * sets the adpt_asst_resp value.
	 */
	public void setAdpt_asst_resp(final String adpt_asst_resp) {
		this.adpt_asst_resp = adpt_asst_resp;
	}

	/**
	 * returns the almy_rcv_resp value.
	 */
	public String getAlmy_rcv_resp() {
		return almy_rcv_resp;
	}

	/**
	 * sets the almy_rcv_resp value.
	 */
	public void setAlmy_rcv_resp(final String almy_rcv_resp) {
		this.almy_rcv_resp = almy_rcv_resp;
	}

	/**
	 * returns the bnft_anty_resp value.
	 */
	public String getBnft_anty_resp() {
		return bnft_anty_resp;
	}

	/**
	 * sets the bnft_anty_resp value.
	 */
	public void setBnft_anty_resp(final String bnft_anty_resp) {
		this.bnft_anty_resp = bnft_anty_resp;
	}

	/**
	 * returns the bnft_chl_sprt_resp value.
	 */
	public String getBnft_chl_sprt_resp() {
		return bnft_chl_sprt_resp;
	}

	/**
	 * sets the bnft_chl_sprt_resp value.
	 */
	public void setBnft_chl_sprt_resp(final String bnft_chl_sprt_resp) {
		this.bnft_chl_sprt_resp = bnft_chl_sprt_resp;
	}

	/**
	 * returns the bnft_chrt_resp value.
	 */
	public String getBnft_chrt_resp() {
		return bnft_chrt_resp;
	}

	/**
	 * sets the bnft_chrt_resp value.
	 */
	public void setBnft_chrt_resp(final String bnft_chrt_resp) {
		this.bnft_chrt_resp = bnft_chrt_resp;
	}

	/**
	 * returns the bnft_dabl_resp value.
	 */
	public String getBnft_dabl_resp() {
		return bnft_dabl_resp;
	}

	/**
	 * sets the bnft_dabl_resp value.
	 */
	public void setBnft_dabl_resp(final String bnft_dabl_resp) {
		this.bnft_dabl_resp = bnft_dabl_resp;
	}

	/**
	 * returns the bnft_divnd_resp value.
	 */
	public String getBnft_divnd_resp() {
		return bnft_divnd_resp;
	}

	/**
	 * sets the bnft_divnd_resp value.
	 */
	public void setBnft_divnd_resp(final String bnft_divnd_resp) {
		this.bnft_divnd_resp = bnft_divnd_resp;
	}

	/**
	 * returns the bnft_est_trst_resp value.
	 */
	public String getBnft_est_trst_resp() {
		return bnft_est_trst_resp;
	}

	/**
	 * sets the bnft_est_trst_resp value.
	 */
	public void setBnft_est_trst_resp(final String bnft_est_trst_resp) {
		this.bnft_est_trst_resp = bnft_est_trst_resp;
	}

	/**
	 * returns the bnft_rr_resp value.
	 */
	public String getBnft_rr_resp() {
		return bnft_rr_resp;
	}

	/**
	 * sets the bnft_rr_resp value.
	 */
	public void setBnft_rr_resp(final String bnft_rr_resp) {
		this.bnft_rr_resp = bnft_rr_resp;
	}

	/**
	 * returns the bnft_uempl_resp value.
	 */
	public String getBnft_uempl_resp() {
		return bnft_uempl_resp;
	}

	/**
	 * sets the bnft_uempl_resp value.
	 */
	public void setBnft_uempl_resp(final String bnft_uempl_resp) {
		this.bnft_uempl_resp = bnft_uempl_resp;
	}

	/**
	 * returns the bnft_vet_resp value.
	 */
	public String getBnft_vet_resp() {
		return bnft_vet_resp;
	}

	/**
	 * sets the bnft_vet_resp value.
	 */
	public void setBnft_vet_resp(final String bnft_vet_resp) {
		this.bnft_vet_resp = bnft_vet_resp;
	}

	/**
	 * returns the chld_sprt_pay_resp value.
	 */
	public String getChld_sprt_pay_resp() {
		return chld_sprt_pay_resp;
	}

	/**
	 * sets the chld_sprt_pay_resp value.
	 */
	public void setChld_sprt_pay_resp(final String chld_sprt_pay_resp) {
		this.chld_sprt_pay_resp = chld_sprt_pay_resp;
	}

	/**
	 * returns the dabl_resp value.
	 */
	public String getDabl_resp() {
		return dabl_resp;
	}

	/**
	 * sets the dabl_resp value.
	 */
	public void setDabl_resp(final String dabl_resp) {
		this.dabl_resp = dabl_resp;
	}

	/**
	 * returns the dpnd_care_resp value.
	 */
	public String getDpnd_care_resp() {
		return dpnd_care_resp;
	}

	/**
	 * sets the dpnd_care_resp value.
	 */
	public void setDpnd_care_resp(final String dpnd_care_resp) {
		this.dpnd_care_resp = dpnd_care_resp;
	}

	/**
	 * returns the drug_feln_resp value.
	 */
	public String getDrug_feln_resp() {
		return drug_feln_resp;
	}

	/**
	 * sets the drug_feln_resp value.
	 */
	public void setDrug_feln_resp(final String drug_feln_resp) {
		this.drug_feln_resp = drug_feln_resp;
	}

	/**
	 * returns the educ_aid_resp value.
	 */
	public String getEduc_aid_resp() {
		return educ_aid_resp;
	}

	/**
	 * sets the educ_aid_resp value.
	 */
	public void setEduc_aid_resp(final String educ_aid_resp) {
		this.educ_aid_resp = educ_aid_resp;
	}

	/**
	 * returns the empl_resp value.
	 */
	public String getEmpl_resp() {
		return empl_resp;
	}

	/**
	 * sets the empl_resp value.
	 */
	public void setEmpl_resp(final String empl_resp) {
		this.empl_resp = empl_resp;
	}

	/**
	 * returns the fset_sctn_resp value.
	 */
	public String getFset_sctn_resp() {
		return fset_sctn_resp;
	}

	/**
	 * sets the fset_sctn_resp value.
	 */
	public void setFset_sctn_resp(final String fset_sctn_resp) {
		this.fset_sctn_resp = fset_sctn_resp;
	}

	/**
	 * returns the fstr_care_resp value.
	 */
	public String getFstr_care_resp() {
		return fstr_care_resp;
	}

	/**
	 * sets the fstr_care_resp value.
	 */
	public void setFstr_care_resp(final String fstr_care_resp) {
		this.fstr_care_resp = fstr_care_resp;
	}

	/**
	 * returns the gen_rlf_resp value.
	 */
	public String getGen_rlf_resp() {
		return gen_rlf_resp;
	}

	/**
	 * sets the gen_rlf_resp value.
	 */
	public void setGen_rlf_resp(final String gen_rlf_resp) {
		this.gen_rlf_resp = gen_rlf_resp;
	}

	/**
	 * returns the hc_cvrg_resp value.
	 */
	public String getHc_cvrg_resp() {
		return hc_cvrg_resp;
	}

	/**
	 * sets the hc_cvrg_resp value.
	 */
	public void setHc_cvrg_resp(final String hc_cvrg_resp) {
		this.hc_cvrg_resp = hc_cvrg_resp;
	}

	/**
	 * returns the incm_int_resp value.
	 */
	public String getIncm_int_resp() {
		return incm_int_resp;
	}

	/**
	 * sets the incm_int_resp value.
	 */
	public void setIncm_int_resp(final String incm_int_resp) {
		this.incm_int_resp = incm_int_resp;
	}

	/**
	 * returns the indv_fma_rqst_ind value.
	 */
	public String getIndv_fma_rqst_ind() {
		return indv_fma_rqst_ind;
	}

	/**
	 * sets the indv_fma_rqst_ind value.
	 */
	public void setIndv_fma_rqst_ind(final String indv_fma_rqst_ind) {
		this.indv_fma_rqst_ind = indv_fma_rqst_ind;
	}

	/**
	 * returns the indv_fpw_rqst_ind value.
	 */
	public String getIndv_fpw_rqst_ind() {
		return indv_fpw_rqst_ind;
	}

	/**
	 * sets the indv_fpw_rqst_ind value.
	 */
	public void setIndv_fpw_rqst_ind(final String indv_fpw_rqst_ind) {
		this.indv_fpw_rqst_ind = indv_fpw_rqst_ind;
	}

	/**
	 * returns the indv_fs_rqst_ind value.
	 */
	public String getIndv_fs_rqst_ind() {
		return indv_fs_rqst_ind;
	}

	/**
	 * sets the indv_fs_rqst_ind value.
	 */
	public void setIndv_fs_rqst_ind(final String indv_fs_rqst_ind) {
		this.indv_fs_rqst_ind = indv_fs_rqst_ind;
	}

	/**
	 * returns the irwe_resp value.
	 */
	public String getIrwe_resp() {
		return irwe_resp;
	}

	/**
	 * sets the irwe_resp value.
	 */
	public void setIrwe_resp(final String irwe_resp) {
		this.irwe_resp = irwe_resp;
	}

	/**
	 * returns the job_iknd_resp value.
	 */
	public String getJob_iknd_resp() {
		return job_iknd_resp;
	}

	/**
	 * sets the job_iknd_resp value.
	 */
	public void setJob_iknd_resp(final String job_iknd_resp) {
		this.job_iknd_resp = job_iknd_resp;
	}

	/**
	 * returns the kinship_care_resp value.
	 */
	public String getKinship_care_resp() {
		return kinship_care_resp;
	}

	/**
	 * sets the kinship_care_resp value.
	 */
	public void setKinship_care_resp(final String kinship_care_resp) {
		this.kinship_care_resp = kinship_care_resp;
	}

	/**
	 * returns the med_exp_resp value.
	 */
	public String getMed_exp_resp() {
		return med_exp_resp;
	}

	/**
	 * sets the med_exp_resp value.
	 */
	public void setMed_exp_resp(final String med_exp_resp) {
		this.med_exp_resp = med_exp_resp;
	}

	/**
	 * returns the mil_allot_resp value.
	 */
	public String getMil_allot_resp() {
		return mil_allot_resp;
	}

	/**
	 * sets the mil_allot_resp value.
	 */
	public void setMil_allot_resp(final String mil_allot_resp) {
		this.mil_allot_resp = mil_allot_resp;
	}

	/**
	 * returns the mony_othr_resp value.
	 */
	public String getMony_othr_resp() {
		return mony_othr_resp;
	}

	/**
	 * sets the mony_othr_resp value.
	 */
	public void setMony_othr_resp(final String mony_othr_resp) {
		this.mony_othr_resp = mony_othr_resp;
	}

	/**
	 * returns the natl_rfge_resp value.
	 */
	public String getNatl_rfge_resp() {
		return natl_rfge_resp;
	}

	/**
	 * sets the natl_rfge_resp value.
	 */
	public void setNatl_rfge_resp(final String natl_rfge_resp) {
		this.natl_rfge_resp = natl_rfge_resp;
	}

	/**
	 * returns the need_ind_resp value.
	 */
	public String getNeed_ind_resp() {
		return need_ind_resp;
	}

	/**
	 * sets the need_ind_resp value.
	 */
	public void setNeed_ind_resp(final String need_ind_resp) {
		this.need_ind_resp = need_ind_resp;
	}

	/**
	 * returns the on_strk_sw value.
	 */
	public String getOn_strk_sw() {
		return on_strk_sw;
	}

	/**
	 * sets the on_strk_sw value.
	 */
	public void setOn_strk_sw(final String on_strk_sw) {
		this.on_strk_sw = on_strk_sw;
	}

	/**
	 * returns the op_aoda_tmt_rcv_sw value.
	 */
	public String getOp_aoda_tmt_rcv_sw() {
		return op_aoda_tmt_rcv_sw;
	}

	/**
	 * sets the op_aoda_tmt_rcv_sw value.
	 */
	public void setOp_aoda_tmt_rcv_sw(final String op_aoda_tmt_rcv_sw) {
		this.op_aoda_tmt_rcv_sw = op_aoda_tmt_rcv_sw;
	}

	/**
	 * returns the othr_incm_resp value.
	 */
	public String getOthr_incm_resp() {
		return othr_incm_resp;
	}

	/**
	 * sets the othr_incm_resp value.
	 */
	public void setOthr_incm_resp(final String othr_incm_resp) {
		this.othr_incm_resp = othr_incm_resp;
	}

	/**
	 * returns the othr_src_resp value.
	 */
	public String getOthr_src_resp() {
		return othr_src_resp;
	}

	/**
	 * sets the othr_src_resp value.
	 */
	public void setOthr_src_resp(final String othr_src_resp) {
		this.othr_src_resp = othr_src_resp;
	}

	/**
	 * returns the own_aset_resp value.
	 */
	public String getOwn_aset_resp() {
		return own_aset_resp;
	}

	/**
	 * sets the own_aset_resp value.
	 */
	public void setOwn_aset_resp(final String own_aset_resp) {
		this.own_aset_resp = own_aset_resp;
	}

	/**
	 * returns the pay_hous_bill_resp value.
	 */
	public String getPay_hous_bill_resp() {
		return pay_hous_bill_resp;
	}

	/**
	 * sets the pay_hous_bill_resp value.
	 */
	public void setPay_hous_bill_resp(final String pay_hous_bill_resp) {
		this.pay_hous_bill_resp = pay_hous_bill_resp;
	}

	/**
	 * returns the pay_rmr_brd_resp value.
	 */
	public String getPay_rmr_brd_resp() {
		return pay_rmr_brd_resp;
	}

	/**
	 * sets the pay_rmr_brd_resp value.
	 */
	public void setPay_rmr_brd_resp(final String pay_rmr_brd_resp) {
		this.pay_rmr_brd_resp = pay_rmr_brd_resp;
	}

	/**
	 * returns the pnsn_retr_resp value.
	 */
	public String getPnsn_retr_resp() {
		return pnsn_retr_resp;
	}

	/**
	 * sets the pnsn_retr_resp value.
	 */
	public void setPnsn_retr_resp(final String pnsn_retr_resp) {
		this.pnsn_retr_resp = pnsn_retr_resp;
	}

	/**
	 * returns the preg_resp value.
	 */
	public String getPreg_resp() {
		return preg_resp;
	}

	/**
	 * sets the preg_resp value.
	 */
	public void setPreg_resp(final String preg_resp) {
		this.preg_resp = preg_resp;
	}

	/**
	 * returns the prop_sold_resp value.
	 */
	public String getProp_sold_resp() {
		return prop_sold_resp;
	}

	/**
	 * sets the prop_sold_resp value.
	 */
	public void setProp_sold_resp(final String prop_sold_resp) {
		this.prop_sold_resp = prop_sold_resp;
	}

	/**
	 * returns the pub_asst_resp value.
	 */
	public String getPub_asst_resp() {
		return pub_asst_resp;
	}

	/**
	 * sets the pub_asst_resp value.
	 */
	public void setPub_asst_resp(final String pub_asst_resp) {
		this.pub_asst_resp = pub_asst_resp;
	}

	/**
	 * returns the rcv_fs_oth_st_resp value.
	 */
	public String getRcv_fs_oth_st_resp() {
		return rcv_fs_oth_st_resp;
	}

	/**
	 * sets the rcv_fs_oth_st_resp value.
	 */
	public void setRcv_fs_oth_st_resp(final String rcv_fs_oth_st_resp) {
		this.rcv_fs_oth_st_resp = rcv_fs_oth_st_resp;
	}

	/**
	 * returns the rcv_hous_asst_resp value.
	 */
	public String getRcv_hous_asst_resp() {
		return rcv_hous_asst_resp;
	}

	/**
	 * sets the rcv_hous_asst_resp value.
	 */
	public void setRcv_hous_asst_resp(final String rcv_hous_asst_resp) {
		this.rcv_hous_asst_resp = rcv_hous_asst_resp;
	}

	/**
	 * returns the rcv_medcr_resp value.
	 */
	public String getRcv_medcr_resp() {
		return rcv_medcr_resp;
	}

	/**
	 * sets the rcv_medcr_resp value.
	 */
	public void setRcv_medcr_resp(final String rcv_medcr_resp) {
		this.rcv_medcr_resp = rcv_medcr_resp;
	}

	/**
	 * returns the rcv_ss_resp value.
	 */
	public String getRcv_ss_resp() {
		return rcv_ss_resp;
	}

	/**
	 * sets the rcv_ss_resp value.
	 */
	public void setRcv_ss_resp(final String rcv_ss_resp) {
		this.rcv_ss_resp = rcv_ss_resp;
	}

	/**
	 * returns the rcv_ssi_ltr_resp value.
	 */
	public String getRcv_ssi_ltr_resp() {
		return rcv_ssi_ltr_resp;
	}

	/**
	 * sets the rcv_ssi_ltr_resp value.
	 */
	public void setRcv_ssi_ltr_resp(final String rcv_ssi_ltr_resp) {
		this.rcv_ssi_ltr_resp = rcv_ssi_ltr_resp;
	}

	/**
	 * returns the rcv_ssi_sw value.
	 */
	public String getRcv_ssi_sw() {
		return rcv_ssi_sw;
	}

	/**
	 * sets the rcv_ssi_sw value.
	 */
	public void setRcv_ssi_sw(final String rcv_ssi_sw) {
		this.rcv_ssi_sw = rcv_ssi_sw;
	}

	/**
	 * returns the rmr_brd_incm_resp value.
	 */
	public String getRmr_brd_incm_resp() {
		return rmr_brd_incm_resp;
	}

	/**
	 * sets the rmr_brd_incm_resp value.
	 */
	public void setRmr_brd_incm_resp(final String rmr_brd_incm_resp) {
		this.rmr_brd_incm_resp = rmr_brd_incm_resp;
	}

	/**
	 * returns the self_empl_resp value.
	 */
	public String getSelf_empl_resp() {
		return self_empl_resp;
	}

	/**
	 * sets the self_empl_resp value.
	 */
	public void setSelf_empl_resp(final String self_empl_resp) {
		this.self_empl_resp = self_empl_resp;
	}

	/**
	 * returns the ssi_dcond_resp value.
	 */
	public String getSsi_dcond_resp() {
		return ssi_dcond_resp;
	}

	/**
	 * sets the ssi_dcond_resp value.
	 */
	public void setSsi_dcond_resp(final String ssi_dcond_resp) {
		this.ssi_dcond_resp = ssi_dcond_resp;
	}

	/**
	 * returns the ssi_1619b_rcv_sw value.
	 */
	public String getSsi_1619b_rcv_sw() {
		return ssi_1619b_rcv_sw;
	}

	/**
	 * sets the ssi_1619b_rcv_sw value.
	 */
	public void setSsi_1619b_rcv_sw(final String ssi_1619b_rcv_sw) {
		this.ssi_1619b_rcv_sw = ssi_1619b_rcv_sw;
	}

	/**
	 * returns the su_ases_resp value.
	 */
	public String getSu_ases_resp() {
		return su_ases_resp;
	}

	/**
	 * sets the su_ases_resp value.
	 */
	public void setSu_ases_resp(final String su_ases_resp) {
		this.su_ases_resp = su_ases_resp;
	}

	/**
	 * returns the su_cst_coal_resp value.
	 */
	public String getSu_cst_coal_resp() {
		return su_cst_coal_resp;
	}

	/**
	 * sets the su_cst_coal_resp value.
	 */
	public void setSu_cst_coal_resp(final String su_cst_coal_resp) {
		this.su_cst_coal_resp = su_cst_coal_resp;
	}

	/**
	 * returns the su_cst_elec_resp value.
	 */
	public String getSu_cst_elec_resp() {
		return su_cst_elec_resp;
	}

	/**
	 * sets the su_cst_elec_resp value.
	 */
	public void setSu_cst_elec_resp(final String su_cst_elec_resp) {
		this.su_cst_elec_resp = su_cst_elec_resp;
	}

	/**
	 * returns the su_cst_fuel_resp value.
	 */
	public String getSu_cst_fuel_resp() {
		return su_cst_fuel_resp;
	}

	/**
	 * sets the su_cst_fuel_resp value.
	 */
	public void setSu_cst_fuel_resp(final String su_cst_fuel_resp) {
		this.su_cst_fuel_resp = su_cst_fuel_resp;
	}

	/**
	 * returns the su_cst_gas_resp value.
	 */
	public String getSu_cst_gas_resp() {
		return su_cst_gas_resp;
	}

	/**
	 * sets the su_cst_gas_resp value.
	 */
	public void setSu_cst_gas_resp(final String su_cst_gas_resp) {
		this.su_cst_gas_resp = su_cst_gas_resp;
	}

	/**
	 * returns the su_cst_home_resp value.
	 */
	public String getSu_cst_home_resp() {
		return su_cst_home_resp;
	}

	/**
	 * sets the su_cst_home_resp value.
	 */
	public void setSu_cst_home_resp(final String su_cst_home_resp) {
		this.su_cst_home_resp = su_cst_home_resp;
	}

	/**
	 * returns the su_cst_istl_resp value.
	 */
	public String getSu_cst_istl_resp() {
		return su_cst_istl_resp;
	}

	/**
	 * sets the su_cst_istl_resp value.
	 */
	public void setSu_cst_istl_resp(final String su_cst_istl_resp) {
		this.su_cst_istl_resp = su_cst_istl_resp;
	}

	/**
	 * returns the su_cst_lpgas_resp value.
	 */
	public String getSu_cst_lpgas_resp() {
		return su_cst_lpgas_resp;
	}

	/**
	 * sets the su_cst_lpgas_resp value.
	 */
	public void setSu_cst_lpgas_resp(final String su_cst_lpgas_resp) {
		this.su_cst_lpgas_resp = su_cst_lpgas_resp;
	}

	/**
	 * returns the su_cst_mbl_resp value.
	 */
	public String getSu_cst_mbl_resp() {
		return su_cst_mbl_resp;
	}

	/**
	 * sets the su_cst_mbl_resp value.
	 */
	public void setSu_cst_mbl_resp(final String su_cst_mbl_resp) {
		this.su_cst_mbl_resp = su_cst_mbl_resp;
	}

	/**
	 * returns the su_cst_mtge_resp value.
	 */
	public String getSu_cst_mtge_resp() {
		return su_cst_mtge_resp;
	}

	/**
	 * sets the su_cst_mtge_resp value.
	 */
	public void setSu_cst_mtge_resp(final String su_cst_mtge_resp) {
		this.su_cst_mtge_resp = su_cst_mtge_resp;
	}

	/**
	 * returns the su_cst_othr_resp value.
	 */
	public String getSu_cst_othr_resp() {
		return su_cst_othr_resp;
	}

	/**
	 * sets the su_cst_othr_resp value.
	 */
	public void setSu_cst_othr_resp(final String su_cst_othr_resp) {
		this.su_cst_othr_resp = su_cst_othr_resp;
	}

	/**
	 * returns the su_cst_phn_resp value.
	 */
	public String getSu_cst_phn_resp() {
		return su_cst_phn_resp;
	}

	/**
	 * sets the su_cst_phn_resp value.
	 */
	public void setSu_cst_phn_resp(final String su_cst_phn_resp) {
		this.su_cst_phn_resp = su_cst_phn_resp;
	}

	/**
	 * returns the su_cst_rent_resp value.
	 */
	public String getSu_cst_rent_resp() {
		return su_cst_rent_resp;
	}

	/**
	 * sets the su_cst_rent_resp value.
	 */
	public void setSu_cst_rent_resp(final String su_cst_rent_resp) {
		this.su_cst_rent_resp = su_cst_rent_resp;
	}

	/**
	 * returns the su_cst_swr_resp value.
	 */
	public String getSu_cst_swr_resp() {
		return su_cst_swr_resp;
	}

	/**
	 * sets the su_cst_swr_resp value.
	 */
	public void setSu_cst_swr_resp(final String su_cst_swr_resp) {
		this.su_cst_swr_resp = su_cst_swr_resp;
	}

	/**
	 * returns the su_cst_tax_resp value.
	 */
	public String getSu_cst_tax_resp() {
		return su_cst_tax_resp;
	}

	/**
	 * sets the su_cst_tax_resp value.
	 */
	public void setSu_cst_tax_resp(final String su_cst_tax_resp) {
		this.su_cst_tax_resp = su_cst_tax_resp;
	}

	/**
	 * returns the su_cst_trsh_resp value.
	 */
	public String getSu_cst_trsh_resp() {
		return su_cst_trsh_resp;
	}

	/**
	 * sets the su_cst_trsh_resp value.
	 */
	public void setSu_cst_trsh_resp(final String su_cst_trsh_resp) {
		this.su_cst_trsh_resp = su_cst_trsh_resp;
	}

	/**
	 * returns the su_cst_wood_resp value.
	 */
	public String getSu_cst_wood_resp() {
		return su_cst_wood_resp;
	}

	/**
	 * sets the su_cst_wood_resp value.
	 */
	public void setSu_cst_wood_resp(final String su_cst_wood_resp) {
		this.su_cst_wood_resp = su_cst_wood_resp;
	}

	/**
	 * returns the su_cst_wtr_resp value.
	 */
	public String getSu_cst_wtr_resp() {
		return su_cst_wtr_resp;
	}

	/**
	 * sets the su_cst_wtr_resp value.
	 */
	public void setSu_cst_wtr_resp(final String su_cst_wtr_resp) {
		this.su_cst_wtr_resp = su_cst_wtr_resp;
	}

	/**
	 * returns the su_cst_wwt_resp value.
	 */
	public String getSu_cst_wwt_resp() {
		return su_cst_wwt_resp;
	}

	/**
	 * sets the su_cst_wwt_resp value.
	 */
	public void setSu_cst_wwt_resp(final String su_cst_wwt_resp) {
		this.su_cst_wwt_resp = su_cst_wwt_resp;
	}

	/**
	 * returns the trb_cpta_resp value.
	 */
	public String getTrb_cpta_resp() {
		return trb_cpta_resp;
	}

	/**
	 * sets the trb_cpta_resp value.
	 */
	public void setTrb_cpta_resp(final String trb_cpta_resp) {
		this.trb_cpta_resp = trb_cpta_resp;
	}

	/**
	 * returns the trb_tanf_resp value.
	 */
	public String getTrb_tanf_resp() {
		return trb_tanf_resp;
	}

	/**
	 * sets the trb_tanf_resp value.
	 */
	public void setTrb_tanf_resp(final String trb_tanf_resp) {
		this.trb_tanf_resp = trb_tanf_resp;
	}

	/**
	 * returns the updt_dt value.
	 */
	public String getUpdt_dt() {
		return updt_dt;
	}

	/**
	 * sets the updt_dt value.
	 */
	public void setUpdt_dt(final String updt_dt) {
		this.updt_dt = updt_dt;
	}

	/**
	 * returns the util_exp_resp value.
	 */
	public String getUtil_exp_resp() {
		return util_exp_resp;
	}

	/**
	 * sets the util_exp_resp value.
	 */
	public void setUtil_exp_resp(final String util_exp_resp) {
		this.util_exp_resp = util_exp_resp;
	}

	/**
	 * returns the wheap_resp value.
	 */
	public String getWheap_resp() {
		return wheap_resp;
	}

	/**
	 * sets the wheap_resp value.
	 */
	public void setWheap_resp(final String wheap_resp) {
		this.wheap_resp = wheap_resp;
	}

	/**
	 * returns the work_comp_resp value.
	 */
	public String getWork_comp_resp() {
		return work_comp_resp;
	}

	/**
	 * sets the work_comp_resp value.
	 */
	public void setWork_comp_resp(final String work_comp_resp) {
		this.work_comp_resp = work_comp_resp;
	}

	/**
	 * returns the yehoc_resp value.
	 */
	public String getYehoc_resp() {
		return yehoc_resp;
	}

	/**
	 * sets the yehoc_resp value.
	 */
	public void setYehoc_resp(final String yehoc_resp) {
		this.yehoc_resp = yehoc_resp;
	}

	public String getResettl_inc_resp() {
		return resettl_inc_resp;
	}

	public void setResettl_inc_resp(final String resettl_inc_resp) {
		this.resettl_inc_resp = resettl_inc_resp;
	}

	public String getNone_resp() {
		return none_resp;
	}

	public void setNone_resp(final String none_resp) {
		this.none_resp = none_resp;
	}

	public String getLand_cont_resp() {
		return land_cont_resp;
	}

	public void setLand_cont_resp(final String land_cont_resp) {
		this.land_cont_resp = land_cont_resp;
	}

	public String getRefused_job_lst_30_resp() {
		return refused_job_lst_30_resp;
	}

	public void setRefused_job_lst_30_resp(final String refused_job_lst_30_resp) {
		this.refused_job_lst_30_resp = refused_job_lst_30_resp;
	}

	public String getChild_support_arr_resp() {
		return child_support_arr_resp;
	}

	public void setChild_support_arr_resp(final String child_support_arr_resp) {
		this.child_support_arr_resp = child_support_arr_resp;
	}

	public String getUnocc_home_exp_resp() {
		return unocc_home_exp_resp;
	}

	public void setUnocc_home_exp_resp(final String unocc_home_exp_resp) {
		this.unocc_home_exp_resp = unocc_home_exp_resp;
	}

	public String getTribal_food_dist_resp() {
		return tribal_food_dist_resp;
	}

	public void setTribal_food_dist_resp(final String tribal_food_dist_resp) {
		this.tribal_food_dist_resp = tribal_food_dist_resp;
	}

	public String getChild_adult_care_resp() {
		return child_adult_care_resp;
	}

	public void setChild_adult_care_resp(final String child_adult_care_resp) {
		this.child_adult_care_resp = child_adult_care_resp;
	}

	public String getMi_heating_cred_resp() {
		return mi_heating_cred_resp;
	}

	public void setMi_heating_cred_resp(final String mi_heating_cred_resp) {
		this.mi_heating_cred_resp = mi_heating_cred_resp;
	}

	public String getMortg_guar_ins_resp() {
		return mortg_guar_ins_resp;
	}

	public void setMortg_guar_ins_resp(final String mortg_guar_ins_resp) {
		this.mortg_guar_ins_resp = mortg_guar_ins_resp;
	}

	public String getCoop_condo_fee_resp() {
		return coop_condo_fee_resp;
	}

	public void setCoop_condo_fee_resp(final String coop_condo_fee_resp) {
		this.coop_condo_fee_resp = coop_condo_fee_resp;
	}

	public String getOther_resp() {
		return other_resp;
	}

	public void setOther_resp(final String other_resp) {
		this.other_resp = other_resp;
	}

	public String getWater_well_resp() {
		return water_well_resp;
	}

	public void setWater_well_resp(final String water_well_resp) {
		this.water_well_resp = water_well_resp;
	}

	public String getCooking_fuel_resp() {
		return cooking_fuel_resp;
	}

	public void setCooking_fuel_resp(final String cooking_fuel_resp) {
		this.cooking_fuel_resp = cooking_fuel_resp;
	}

	public String getWater_well_maint_resp() {
		return water_well_maint_resp;
	}

	public void setWater_well_maint_resp(final String water_well_maint_resp) {
		this.water_well_maint_resp = water_well_maint_resp;
	}

	public String getHeating_resp() {
		return heating_resp;
	}

	public void setHeating_resp(final String heating_resp) {
		this.heating_resp = heating_resp;
	}

	public String getCooling_resp() {
		return cooling_resp;
	}

	public void setCooling_resp(final String cooling_resp) {
		this.cooling_resp = cooling_resp;
	}

	public String getSeptic_sewer_resp() {
		return septic_sewer_resp;
	}

	public void setSeptic_sewer_resp(final String septic_sewer_resp) {
		this.septic_sewer_resp = septic_sewer_resp;
	}

	public String getHome_equity_resp() {
		return home_equity_resp;
	}

	public void setHome_equity_resp(final String home_equity_resp) {
		this.home_equity_resp = home_equity_resp;
	}

	public String getSecond_mortgag_resp() {
		return second_mortgag_resp;
	}

	public void setSecond_mortgag_resp(final String second_mortgag_resp) {
		this.second_mortgag_resp = second_mortgag_resp;
	}

	public String getOthr_incm_rentl_resp() {
		return othr_incm_rentl_resp;
	}

	public void setOthr_incm_rentl_resp(final String othr_incm_rentl_resp) {
		this.othr_incm_rentl_resp = othr_incm_rentl_resp;
	}

	/**
	 * sets the li_aset_g_l_resp value.
	 */
	public void setLi_aset_g_l_resp(final String li_aset_g_l_resp) {
		this.li_aset_g_l_resp = li_aset_g_l_resp;
	}

	/**
	 * sets the li_aset_g_t_resp value.
	 */
	public void setLi_aset_g_t_resp(final String li_aset_g_t_resp) {
		this.li_aset_g_t_resp = li_aset_g_t_resp;
	}

	/**
	 * sets the li_aset_trm_resp value.
	 */
	public void setLi_aset_trm_resp(final String li_aset_trm_resp) {
		this.li_aset_trm_resp = li_aset_trm_resp;
	}

	/**
	 * sets the li_aset_unv_resp value.
	 */
	public void setLi_aset_unv_resp(final String li_aset_unv_resp) {
		this.li_aset_unv_resp = li_aset_unv_resp;
	}

	/**
	 * sets the li_aset_w_l_resp value.
	 */
	public void setLi_aset_w_l_resp(final String li_aset_w_l_resp) {
		this.li_aset_w_l_resp = li_aset_w_l_resp;
	}

	/**
	 * sets the lqd_aset_c_a_resp value.
	 */
	public void setLqd_aset_c_a_resp(final String lqd_aset_c_a_resp) {
		this.lqd_aset_c_a_resp = lqd_aset_c_a_resp;
	}

	/*	*//**
	 * sets the lqd_aset_cash_resp value.
	 */
	/*
	 * public void setLqd_aset_cash_resp(String lqd_aset_cash_resp){
	 * this.lqd_aset_cash_resp= lqd_aset_cash_resp; }
	 */
	/**
	 * sets the lqd_aset_eb_a_resp value.
	 */
	public void setLqd_aset_eb_a_resp(final String lqd_aset_eb_a_resp) {
		this.lqd_aset_eb_a_resp = lqd_aset_eb_a_resp;
	}

	/**
	 * sets the lqd_aset_h_s_resp value.
	 */
	public void setLqd_aset_h_s_resp(final String lqd_aset_h_s_resp) {
		this.lqd_aset_h_s_resp = lqd_aset_h_s_resp;
	}

	/**
	 * sets the lqd_aset_ira_resp value.
	 */
	public void setLqd_aset_ira_resp(final String lqd_aset_ira_resp) {
		this.lqd_aset_ira_resp = lqd_aset_ira_resp;
	}

	/**
	 * sets the lqd_aset_k_p_resp value.
	 */
	public void setLqd_aset_k_p_resp(final String lqd_aset_k_p_resp) {
		this.lqd_aset_k_p_resp = lqd_aset_k_p_resp;
	}

	/**
	 * sets the lqd_aset_m_o_resp value.
	 */
	public void setLqd_aset_m_o_resp(final String lqd_aset_m_o_resp) {
		this.lqd_aset_m_o_resp = lqd_aset_m_o_resp;
	}

	/**
	 * sets the lqd_aset_mm_a_resp value.
	 */
	public void setLqd_aset_mm_a_resp(final String lqd_aset_mm_a_resp) {
		this.lqd_aset_mm_a_resp = lqd_aset_mm_a_resp;
	}

	/**
	 * sets the lqd_aset_o_t_resp value.
	 */
	public void setLqd_aset_o_t_resp(final String lqd_aset_o_t_resp) {
		this.lqd_aset_o_t_resp = lqd_aset_o_t_resp;
	}

	/**
	 * sets the lqd_aset_othr_resp value.
	 */
	public void setLqd_aset_othr_resp(final String lqd_aset_othr_resp) {
		this.lqd_aset_othr_resp = lqd_aset_othr_resp;
	}

	/**
	 * sets the lqd_aset_s_a_resp value.
	 */
	public void setLqd_aset_s_a_resp(final String lqd_aset_s_a_resp) {
		this.lqd_aset_s_a_resp = lqd_aset_s_a_resp;
	}

	/**
	 * sets the lqd_aset_s_c_resp value.
	 */
	public void setLqd_aset_s_c_resp(final String lqd_aset_s_c_resp) {
		this.lqd_aset_s_c_resp = lqd_aset_s_c_resp;
	}

	/**
	 * sets the lqd_aset_st_b_resp value.
	 */
	public void setLqd_aset_st_b_resp(final String lqd_aset_st_b_resp) {
		this.lqd_aset_st_b_resp = lqd_aset_st_b_resp;
	}

	/**
	 * sets the lqd_aset_tr_f_resp value.
	 */
	public void setLqd_aset_tr_f_resp(final String lqd_aset_tr_f_resp) {
		this.lqd_aset_tr_f_resp = lqd_aset_tr_f_resp;
	}

	/**
	 * sets the lqd_aset_us_b_resp value.
	 */
	public void setLqd_aset_us_b_resp(final String lqd_aset_us_b_resp) {
		this.lqd_aset_us_b_resp = lqd_aset_us_b_resp;
	}

	/**
	 * sets the othr_aset_bur_resp value.
	 */

	/**
	 * sets the othr_aset_xfr_resp value.
	 */
	/*
	 * public void setOthr_aset_xfr_resp(String othr_aset_xfr_resp){
	 * this.othr_aset_xfr_resp= othr_aset_xfr_resp; }
	 */
	/**
	 * sets the real_aset_apt_resp value.
	 */
	public void setReal_aset_apt_resp(final String real_aset_apt_resp) {
		this.real_aset_apt_resp = real_aset_apt_resp;
	}

	/**
	 * sets the real_aset_com_resp value.
	 */
	public void setReal_aset_com_resp(final String real_aset_com_resp) {
		this.real_aset_com_resp = real_aset_com_resp;
	}

	/**
	 * sets the real_aset_con_resp value.
	 */
	public void setReal_aset_con_resp(final String real_aset_con_resp) {
		this.real_aset_con_resp = real_aset_con_resp;
	}

	/**
	 * sets the real_aset_dup_resp value.
	 */
	public void setReal_aset_dup_resp(final String real_aset_dup_resp) {
		this.real_aset_dup_resp = real_aset_dup_resp;
	}

	/**
	 * sets the real_aset_frm_resp value.
	 */
	public void setReal_aset_frm_resp(final String real_aset_frm_resp) {
		this.real_aset_frm_resp = real_aset_frm_resp;
	}

	/**
	 * sets the real_aset_hse_resp value.
	 */
	public void setReal_aset_hse_resp(final String real_aset_hse_resp) {
		this.real_aset_hse_resp = real_aset_hse_resp;
	}

	/**
	 * sets the real_aset_lnd_resp value.
	 */
	public void setReal_aset_lnd_resp(final String real_aset_lnd_resp) {
		this.real_aset_lnd_resp = real_aset_lnd_resp;
	}

	/**
	 * sets the real_aset_m_h_resp value.
	 */
	public void setReal_aset_m_h_resp(final String real_aset_m_h_resp) {
		this.real_aset_m_h_resp = real_aset_m_h_resp;
	}

	/**
	 * sets the real_aset_oth_resp value.
	 */
	public void setReal_aset_oth_resp(final String real_aset_oth_resp) {
		this.real_aset_oth_resp = real_aset_oth_resp;
	}

	/**
	 * sets the veh_aset_anml_resp value.
	 */
	public void setVeh_aset_anml_resp(final String veh_aset_anml_resp) {
		this.veh_aset_anml_resp = veh_aset_anml_resp;
	}

	/**
	 * sets the veh_aset_arpl_resp value.
	 */
	public void setVeh_aset_arpl_resp(final String veh_aset_arpl_resp) {
		this.veh_aset_arpl_resp = veh_aset_arpl_resp;
	}

	/**
	 * sets the veh_aset_auto_resp value.
	 */
	public void setVeh_aset_auto_resp(final String veh_aset_auto_resp) {
		this.veh_aset_auto_resp = veh_aset_auto_resp;
	}

	/**
	 * sets the veh_aset_boat_resp value.
	 */
	public void setVeh_aset_boat_resp(final String veh_aset_boat_resp) {
		this.veh_aset_boat_resp = veh_aset_boat_resp;
	}

	/**
	 * sets the veh_aset_bus_resp value.
	 */
	public void setVeh_aset_bus_resp(final String veh_aset_bus_resp) {
		this.veh_aset_bus_resp = veh_aset_bus_resp;
	}

	/**
	 * sets the veh_aset_camp_resp value.
	 */
	public void setVeh_aset_camp_resp(final String veh_aset_camp_resp) {
		this.veh_aset_camp_resp = veh_aset_camp_resp;
	}

	/**
	 * sets the veh_aset_fimp_resp value.
	 */
	public void setVeh_aset_fimp_resp(final String veh_aset_fimp_resp) {
		this.veh_aset_fimp_resp = veh_aset_fimp_resp;
	}

	/**
	 * sets the veh_aset_fmeq_resp value.
	 */
	public void setVeh_aset_fmeq_resp(final String veh_aset_fmeq_resp) {
		this.veh_aset_fmeq_resp = veh_aset_fmeq_resp;
	}

	/**
	 * sets the veh_aset_ftrc_resp value.
	 */
	public void setVeh_aset_ftrc_resp(final String veh_aset_ftrc_resp) {
		this.veh_aset_ftrc_resp = veh_aset_ftrc_resp;
	}

	/**
	 * sets the veh_aset_ftrl_resp value.
	 */
	public void setVeh_aset_ftrl_resp(final String veh_aset_ftrl_resp) {
		this.veh_aset_ftrl_resp = veh_aset_ftrl_resp;
	}

	/**
	 * sets the veh_aset_lskd_resp value.
	 */
	public void setVeh_aset_lskd_resp(final String veh_aset_lskd_resp) {
		this.veh_aset_lskd_resp = veh_aset_lskd_resp;
	}

	/**
	 * sets the veh_aset_mcyc_resp value.
	 */
	public void setVeh_aset_mcyc_resp(final String veh_aset_mcyc_resp) {
		this.veh_aset_mcyc_resp = veh_aset_mcyc_resp;
	}

	/**
	 * sets the veh_aset_mped_resp value.
	 */
	public void setVeh_aset_mped_resp(final String veh_aset_mped_resp) {
		this.veh_aset_mped_resp = veh_aset_mped_resp;
	}

	/**
	 * sets the veh_aset_nm_b_resp value.
	 */
	public void setVeh_aset_nm_b_resp(final String veh_aset_nm_b_resp) {
		this.veh_aset_nm_b_resp = veh_aset_nm_b_resp;
	}

	/**
	 * sets the veh_aset_othr_resp value.
	 */
	public void setVeh_aset_othr_resp(final String veh_aset_othr_resp) {
		this.veh_aset_othr_resp = veh_aset_othr_resp;
	}

	/**
	 * sets the veh_aset_rv_resp value.
	 */
	public void setVeh_aset_rv_resp(final String veh_aset_rv_resp) {
		this.veh_aset_rv_resp = veh_aset_rv_resp;
	}

	/**
	 * sets the veh_aset_s_mb_resp value.
	 */
	public void setVeh_aset_s_mb_resp(final String veh_aset_s_mb_resp) {
		this.veh_aset_s_mb_resp = veh_aset_s_mb_resp;
	}

	/**
	 * sets the veh_aset_trk_resp value.
	 */
	public void setVeh_aset_trk_resp(final String veh_aset_trk_resp) {
		this.veh_aset_trk_resp = veh_aset_trk_resp;
	}

	/**
	 * sets the veh_aset_trlr_resp value.
	 */
	public void setVeh_aset_trlr_resp(final String veh_aset_trlr_resp) {
		this.veh_aset_trlr_resp = veh_aset_trlr_resp;
	}

	/**
	 * sets the veh_aset_van_resp value.
	 */
	public void setVeh_aset_van_resp(final String veh_aset_van_resp) {
		this.veh_aset_van_resp = veh_aset_van_resp;
	}
	
	/**
	 * @return the indv_wic_rqst_ind
	 */
	public String getIndv_wic_rqst_ind() {
		return indv_wic_rqst_ind;
	}

	/**
	 * @param indv_wic_rqst_ind the indv_wic_rqst_ind to set
	 */
	public void setIndv_wic_rqst_ind(final String indv_wic_rqst_ind) {
		this.indv_wic_rqst_ind = indv_wic_rqst_ind;
	}

	/**
	 * @return the indv_tanf_rqst_ind
	 */
	public String getIndv_tanf_rqst_ind() {
		return indv_tanf_rqst_ind;
	}

	/**
	 * @param indv_tanf_rqst_ind the indv_tanf_rqst_ind to set
	 */
	public void setIndv_tanf_rqst_ind(final String indv_tanf_rqst_ind) {
		this.indv_tanf_rqst_ind = indv_tanf_rqst_ind;
	}

	
	/**
	 * @return the indv_cc_rqst_ind
	 */
	public String getIndv_cc_rqst_ind() {
		return indv_cc_rqst_ind;
	}

	/**
	 * @param indv_cc_rqst_ind the indv_cc_rqst_ind to set
	 */
	public void setIndv_cc_rqst_ind(final String indv_cc_rqst_ind) {
		this.indv_cc_rqst_ind = indv_cc_rqst_ind;
	}


	public String getLiquid_asset_cash_resp() {
		return liquid_asset_cash_resp;
	}

	public void setLiquid_asset_cash_resp(final String liquid_asset_cash_resp) {
		this.liquid_asset_cash_resp = liquid_asset_cash_resp;
	}
	/**
	 * @return the unpaid_medbill
	 */
	public String getUnpaid_medbill() {
		return unpaid_medbill;
	}

	/**
	 * @param unpaid_medbill the unpaid_medbill to set
	 */
	public void setUnpaid_medbill(final String unpaid_medbill) {
		this.unpaid_medbill = unpaid_medbill;
	}
	

	/**
	 * @return the other_incm_contrib_resp
	 */
	public String getOther_incm_contrib_resp() {
		return other_incm_contrib_resp;
	}

	/**
	 * @param other_incm_contrib_resp the other_incm_contrib_resp to set
	 */
	public void setOther_incm_contrib_resp(final String other_incm_contrib_resp) {
		this.other_incm_contrib_resp = other_incm_contrib_resp;
	}

	public String getVeh_aset_unlic_resp() {
		return veh_aset_unlic_resp;
	}

	public void setVeh_aset_unlic_resp(final String veh_aset_unlic_resp) {
		this.veh_aset_unlic_resp = veh_aset_unlic_resp;
	}

	public String getReal_asset_rental_resp() {
		return real_asset_rental_resp;
	}

	public void setReal_asset_rental_resp(final String real_asset_rental_resp) {
		this.real_asset_rental_resp = real_asset_rental_resp;
	}

	public String getReal_aset_vac_resp() {
		return real_aset_vac_resp;
	}

	public void setReal_aset_vac_resp(final String real_aset_vac_resp) {
		this.real_aset_vac_resp = real_aset_vac_resp;
	}
		/**
	 * @return the adoptAssistance
	 */
	public String getAdoptAssistance() {
		return adoptAssistance;
	}

	/**
	 * @param adoptAssistance the adoptAssistance to set
	 */
	public void setAdoptAssistance(final String adoptAssistance) {
		this.adoptAssistance = adoptAssistance;
	}

	/**
	 * @return the adoptionPayments
	 */
	public String getAdoptionPayments() {
		return adoptionPayments;
	}

	/**
	 * @param adoptionPayments the adoptionPayments to set
	 */
	public void setAdoptionPayments(final String adoptionPayments) {
		this.adoptionPayments = adoptionPayments;
	}

	/**
	 * @return the agentOrangePayments
	 */
	public String getAgentOrangePayments() {
		return agentOrangePayments;
	}

	/**
	 * @param agentOrangePayments the agentOrangePayments to set
	 */
	public void setAgentOrangePayments(final String agentOrangePayments) {
		this.agentOrangePayments = agentOrangePayments;
	}

	/**
	 * @return the alimony
	 */
	public String getAlimony() {
		return alimony;
	}

	/**
	 * @param alimony the alimony to set
	 */
	public void setAlimony(final String alimony) {
		this.alimony = alimony;
	}

	/**
	 * @return the capitalGains
	 */
	public String getCapitalGains() {
		return capitalGains;
	}

	/**
	 * @param capitalGains the capitalGains to set
	 */
	public void setCapitalGains(final String capitalGains) {
		this.capitalGains = capitalGains;
	}

	/**
	 * @return the deathBenefits
	 */
	public String getDeathBenefits() {
		return deathBenefits;
	}

	/**
	 * @param deathBenefits the deathBenefits to set
	 */
	public void setDeathBenefits(final String deathBenefits) {
		this.deathBenefits = deathBenefits;
	}

	/**
	 * @return the disabilityIncome
	 */
	public String getDisabilityIncome() {
		return disabilityIncome;
	}

	/**
	 * @param disabilityIncome the disabilityIncome to set
	 */
	public void setDisabilityIncome(final String disabilityIncome) {
		this.disabilityIncome = disabilityIncome;
	}

	/**
	 * @return the disasterRelief
	 */
	public String getDisasterRelief() {
		return disasterRelief;
	}

	/**
	 * @param disasterRelief the disasterRelief to set
	 */
	public void setDisasterRelief(final String disasterRelief) {
		this.disasterRelief = disasterRelief;
	}

	/**
	 * @return the educationalAssistance
	 */
	public String getEducationalAssistance() {
		return educationalAssistance;
	}

	/**
	 * @param educationalAssistance the educationalAssistance to set
	 */
	public void setEducationalAssistance(final String educationalAssistance) {
		this.educationalAssistance = educationalAssistance;
	}

	/**
	 * @return the energyAssistance
	 */
	public String getEnergyAssistance() {
		return energyAssistance;
	}

	/**
	 * @param energyAssistance the energyAssistance to set
	 */
	public void setEnergyAssistance(final String energyAssistance) {
		this.energyAssistance = energyAssistance;
	}

	/**
	 * @return the farmAllotment
	 */
	public String getFarmAllotment() {
		return farmAllotment;
	}

	/**
	 * @param farmAllotment the farmAllotment to set
	 */
	public void setFarmAllotment(final String farmAllotment) {
		this.farmAllotment = farmAllotment;
	}

	/**
	 * @return the fosterCarePayments
	 */
	public String getFosterCarePayments() {
		return fosterCarePayments;
	}

	/**
	 * @param fosterCarePayments the fosterCarePayments to set
	 */
	public void setFosterCarePayments(final String fosterCarePayments) {
		this.fosterCarePayments = fosterCarePayments;
	}

	/**
	 * @return the generalAssistance
	 */
	public String getGeneralAssistance() {
		return generalAssistance;
	}

	/**
	 * @param generalAssistance the generalAssistance to set
	 */
	public void setGeneralAssistance(final String generalAssistance) {
		this.generalAssistance = generalAssistance;
	}

	/**
	 * @return the interestDividendPayments
	 */
	public String getInterestDividendPayments() {
		return interestDividendPayments;
	}

	/**
	 * @param interestDividendPayments the interestDividendPayments to set
	 */
	public void setInterestDividendPayments(final String interestDividendPayments) {
		this.interestDividendPayments = interestDividendPayments;
	}

	/**
	 * @return the iRADistribution
	 */
	public String getiRADistribution() {
		return iRADistribution;
	}

	/**
	 * @param iRADistribution the iRADistribution to set
	 */
	public void setiRADistribution(final String iRADistribution) {
		this.iRADistribution = iRADistribution;
	}

	/**
	 * @return the lotteryWinnings
	 */
	public String getLotteryWinnings() {
		return lotteryWinnings;
	}

	/**
	 * @param lotteryWinnings the lotteryWinnings to set
	 */
	public void setLotteryWinnings(final String lotteryWinnings) {
		this.lotteryWinnings = lotteryWinnings;
	}

	/**
	 * @return the lumpSum
	 */
	public String getLumpSum() {
		return lumpSum;
	}

	/**
	 * @param lumpSum the lumpSum to set
	 */
	public void setLumpSum(final String lumpSum) {
		this.lumpSum = lumpSum;
	}

	/**
	 * @return the militaryAllotment
	 */
	public String getMilitaryAllotment() {
		return militaryAllotment;
	}

	/**
	 * @param militaryAllotment the militaryAllotment to set
	 */
	public void setMilitaryAllotment(final String militaryAllotment) {
		this.militaryAllotment = militaryAllotment;
	}

	/**
	 * @return the moneyFromAnotherPerson
	 */
	public String getMoneyFromAnotherPerson() {
		return moneyFromAnotherPerson;
	}

	/**
	 * @param moneyFromAnotherPerson the moneyFromAnotherPerson to set
	 */
	public void setMoneyFromAnotherPerson(final String moneyFromAnotherPerson) {
		this.moneyFromAnotherPerson = moneyFromAnotherPerson;
	}

	/**
	 * @return the netRentalRoyalty
	 */
	public String getNetRentalRoyalty() {
		return netRentalRoyalty;
	}

	/**
	 * @param netRentalRoyalty the netRentalRoyalty to set
	 */
	public void setNetRentalRoyalty(final String netRentalRoyalty) {
		this.netRentalRoyalty = netRentalRoyalty;
	}

	/**
	 * @return the otherIncome
	 */
	public String getOtherIncome() {
		return otherIncome;
	}

	/**
	 * @param otherIncome the otherIncome to set
	 */
	public void setOtherIncome(final String otherIncome) {
		this.otherIncome = otherIncome;
	}

	/**
	 * @return the paymentsFromAnnuity
	 */
	public String getPaymentsFromAnnuity() {
		return paymentsFromAnnuity;
	}

	/**
	 * @param paymentsFromAnnuity the paymentsFromAnnuity to set
	 */
	public void setPaymentsFromAnnuity(final String paymentsFromAnnuity) {
		this.paymentsFromAnnuity = paymentsFromAnnuity;
	}

	/**
	 * @return the paymentsMadeOnYourBehalf
	 */
	public String getPaymentsMadeOnYourBehalf() {
		return paymentsMadeOnYourBehalf;
	}

	/**
	 * @param paymentsMadeOnYourBehalf the paymentsMadeOnYourBehalf to set
	 */
	public void setPaymentsMadeOnYourBehalf(final String paymentsMadeOnYourBehalf) {
		this.paymentsMadeOnYourBehalf = paymentsMadeOnYourBehalf;
	}

	/**
	 * @return the pensionOrRetirement
	 */
	public String getPensionOrRetirement() {
		return pensionOrRetirement;
	}

	/**
	 * @param pensionOrRetirement the pensionOrRetirement to set
	 */
	public void setPensionOrRetirement(final String pensionOrRetirement) {
		this.pensionOrRetirement = pensionOrRetirement;
	}

	/**
	 * @return the railroadRetirement
	 */
	public String getRailroadRetirement() {
		return railroadRetirement;
	}

	/**
	 * @param railroadRetirement the railroadRetirement to set
	 */
	public void setRailroadRetirement(final String railroadRetirement) {
		this.railroadRetirement = railroadRetirement;
	}

	/**
	 * @return the refugeeCash
	 */
	public String getRefugeeCash() {
		return refugeeCash;
	}

	/**
	 * @param refugeeCash the refugeeCash to set
	 */
	public void setRefugeeCash(final String refugeeCash) {
		this.refugeeCash = refugeeCash;
	}

	/**
	 * @return the relativeCareSubsidy
	 */
	public String getRelativeCareSubsidy() {
		return relativeCareSubsidy;
	}

	/**
	 * @param relativeCareSubsidy the relativeCareSubsidy to set
	 */
	public void setRelativeCareSubsidy(final String relativeCareSubsidy) {
		this.relativeCareSubsidy = relativeCareSubsidy;
	}

	/**
	 * @return the rentalIncome
	 */
	public String getRentalIncome() {
		return rentalIncome;
	}

	/**
	 * @param rentalIncome the rentalIncome to set
	 */
	public void setRentalIncome(final String rentalIncome) {
		this.rentalIncome = rentalIncome;
	}

	/**
	 * @return the tANFPayments
	 */
	public String gettANFPayments() {
		return tANFPayments;
	}
	/**
	 * @return Returns the cp_wlst_resp.
	 */
	public String getCp_wlst_resp() {
		return cp_wlst_resp;
	}

	/**
	 * @param cp_wlst_resp
	 *            The cp_wlst_resp to set.
	 */
	public void setCp_wlst_resp(final String cp_wlst_resp) {
		this.cp_wlst_resp = cp_wlst_resp;
	}

	/**
	 * @return Returns the indv_cla_ind.
	 */
	public String getIndv_cla_ind() {
		return indv_cla_ind;
	}

	/**
	 * @param indv_cla_ind
	 *            The indv_cla_ind to set.
	 */
	public void setIndv_cla_ind(final String indv_cla_ind) {
		this.indv_cla_ind = indv_cla_ind;
	}

	/**
	 * @param tANFPayments the tANFPayments to set
	 */
	public void settANFPayments(final String tANFPayments) {
		this.tANFPayments = tANFPayments;
	}

	/**
	 * @return the unemploymentCompensation
	 */
	public String getUnemploymentCompensation() {
		return unemploymentCompensation;
	}

	/**
	 * @param unemploymentCompensation the unemploymentCompensation to set
	 */
	public void setUnemploymentCompensation(final String unemploymentCompensation) {
		this.unemploymentCompensation = unemploymentCompensation;
	}

	/**
	 * @return the workStudyStateFederal
	 */
	public String getWorkStudyStateFederal() {
		return workStudyStateFederal;
	}

	/**
	 * @param workStudyStateFederal the workStudyStateFederal to set
	 */
	public void setWorkStudyStateFederal(final String workStudyStateFederal) {
		this.workStudyStateFederal = workStudyStateFederal;
	}

	/**
	 * @return the workersCompensation
	 */
	public String getWorkersCompensation() {
		return workersCompensation;
	}

	/**
	 * @param workersCompensation the workersCompensation to set
	 */
	public void setWorkersCompensation(final String workersCompensation) {
		this.workersCompensation = workersCompensation;
	}
	
	

	/**
	 * @return the room_brd_chg_ind
	 */
	public String getRoom_brd_chg_ind() {
		return room_brd_chg_ind;
	}

	/**
	 * @param room_brd_chg_ind the room_brd_chg_ind to set
	 */
	public void setRoom_brd_chg_ind(final String room_brd_chg_ind) {
		this.room_brd_chg_ind = room_brd_chg_ind;
	}

	/**
	 * @return the dabl_stat_ind
	 */
	public String getDabl_stat_ind() {
		return dabl_stat_ind;
	}

	/**
	 * @param dabl_stat_ind the dabl_stat_ind to set
	 */
	public void setDabl_stat_ind(final String dabl_stat_ind) {
		this.dabl_stat_ind = dabl_stat_ind;
	}

	/**
	 * @return the preg_add_stat_ind
	 */
	public String getPreg_add_stat_ind() {
		return preg_add_stat_ind;
	}

	/**
	 * @param preg_add_stat_ind the preg_add_stat_ind to set
	 */
	public void setPreg_add_stat_ind(final String preg_add_stat_ind) {
		this.preg_add_stat_ind = preg_add_stat_ind;
	}

	/**
	 * @return the preg_chg_ind
	 */
	public String getPreg_chg_ind() {
		return preg_chg_ind;
	}

	/**
	 * @param preg_chg_ind the preg_chg_ind to set
	 */
	public void setPreg_chg_ind(final String preg_chg_ind) {
		this.preg_chg_ind = preg_chg_ind;
	}

	/**
	 * @return the irwe_chg_ind
	 */
	public String getIrwe_chg_ind() {
		return irwe_chg_ind;
	}

	/**
	 * @param irwe_chg_ind the irwe_chg_ind to set
	 */
	public void setIrwe_chg_ind(final String irwe_chg_ind) {
		this.irwe_chg_ind = irwe_chg_ind;
	}

	/**
	 * @return the ei_chg_ind
	 */
	public String getEi_chg_ind() {
		return ei_chg_ind;
	}

	/**
	 * @param ei_chg_ind the ei_chg_ind to set
	 */
	public void setEi_chg_ind(final String ei_chg_ind) {
		this.ei_chg_ind = ei_chg_ind;
	}

	/**
	 * @return the self_empl_chg_ind
	 */
	public String getSelf_empl_chg_ind() {
		return self_empl_chg_ind;
	}

	/**
	 * @param self_empl_chg_ind the self_empl_chg_ind to set
	 */
	public void setSelf_empl_chg_ind(final String self_empl_chg_ind) {
		this.self_empl_chg_ind = self_empl_chg_ind;
	}

	/**
	 * @return the othr_incm_chg_ind
	 */
	public String getOthr_incm_chg_ind() {
		return othr_incm_chg_ind;
	}

	/**
	 * @param othr_incm_chg_ind the othr_incm_chg_ind to set
	 */
	public void setOthr_incm_chg_ind(final String othr_incm_chg_ind) {
		this.othr_incm_chg_ind = othr_incm_chg_ind;
	}

	/**
	 * @return the empl_chg_ind
	 */
	public String getEmpl_chg_ind() {
		return empl_chg_ind;
	}

	/**
	 * @param empl_chg_ind the empl_chg_ind to set
	 */
	public void setEmpl_chg_ind(final String empl_chg_ind) {
		this.empl_chg_ind = empl_chg_ind;
	}

	/**
	 * @return the veh_aset_add_ind
	 */
	public String getVeh_aset_add_ind() {
		return veh_aset_add_ind;
	}

	/**
	 * @param veh_aset_add_ind the veh_aset_add_ind to set
	 */
	public void setVeh_aset_add_ind(final String veh_aset_add_ind) {
		this.veh_aset_add_ind = veh_aset_add_ind;
	}

	/**
	 * @return the veh_aset_chg_ind
	 */
	public String getVeh_aset_chg_ind() {
		return veh_aset_chg_ind;
	}

	/**
	 * @param veh_aset_chg_ind the veh_aset_chg_ind to set
	 */
	public void setVeh_aset_chg_ind(final String veh_aset_chg_ind) {
		this.veh_aset_chg_ind = veh_aset_chg_ind;
	}

	/**
	 * @return the real_aset_add_ind
	 */
	public String getReal_aset_add_ind() {
		return real_aset_add_ind;
	}

	/**
	 * @param real_aset_add_ind the real_aset_add_ind to set
	 */
	public void setReal_aset_add_ind(final String real_aset_add_ind) {
		this.real_aset_add_ind = real_aset_add_ind;
	}

	/**
	 * @return the real_aset_chg_ind
	 */
	public String getReal_aset_chg_ind() {
		return real_aset_chg_ind;
	}

	/**
	 * @param real_aset_chg_ind the real_aset_chg_ind to set
	 */
	public void setReal_aset_chg_ind(final String real_aset_chg_ind) {
		this.real_aset_chg_ind = real_aset_chg_ind;
	}

	/**
	 * @return the bury_aset_add_ind
	 */
	public String getBury_aset_add_ind() {
		return bury_aset_add_ind;
	}

	/**
	 * @param bury_aset_add_ind the bury_aset_add_ind to set
	 */
	public void setBury_aset_add_ind(final String bury_aset_add_ind) {
		this.bury_aset_add_ind = bury_aset_add_ind;
	}

	/**
	 * @return the bury_aset_chg_ind
	 */
	public String getBury_aset_chg_ind() {
		return bury_aset_chg_ind;
	}

	/**
	 * @param bury_aset_chg_ind the bury_aset_chg_ind to set
	 */
	public void setBury_aset_chg_ind(final String bury_aset_chg_ind) {
		this.bury_aset_chg_ind = bury_aset_chg_ind;
	}

	/**
	 * @return the liquid_asset_add_ind
	 */
	public String getLiquid_asset_add_ind() {
		return liquid_asset_add_ind;
	}

	/**
	 * @param liquid_asset_add_ind the liquid_asset_add_ind to set
	 */
	public void setLiquid_asset_add_ind(final String liquid_asset_add_ind) {
		this.liquid_asset_add_ind = liquid_asset_add_ind;
	}

	/**
	 * @return the liquid_asset_bank_acc_chg_ind
	 */
	public String getLiquid_asset_bank_acc_chg_ind() {
		return liquid_asset_bank_acc_chg_ind;
	}

	/**
	 * @param liquid_asset_bank_acc_chg_ind the liquid_asset_bank_acc_chg_ind to set
	 */
	public void setLiquid_asset_bank_acc_chg_ind(final String liquid_asset_bank_acc_chg_ind) {
		this.liquid_asset_bank_acc_chg_ind = liquid_asset_bank_acc_chg_ind;
	}

	/**
	 * @return the liquid_asset_cash_chg_ind
	 */
	public String getLiquid_asset_cash_chg_ind() {
		return liquid_asset_cash_chg_ind;
	}

	/**
	 * @param liquid_asset_cash_chg_ind the liquid_asset_cash_chg_ind to set
	 */
	public void setLiquid_asset_cash_chg_ind(final String liquid_asset_cash_chg_ind) {
		this.liquid_asset_cash_chg_ind = liquid_asset_cash_chg_ind;
	}

	/**
	 * @return the liquid_asset_chg_ind
	 */
	public String getLiquid_asset_chg_ind() {
		return liquid_asset_chg_ind;
	}

	/**
	 * @param liquid_asset_chg_ind the liquid_asset_chg_ind to set
	 */
	public void setLiquid_asset_chg_ind(final String liquid_asset_chg_ind) {
		this.liquid_asset_chg_ind = liquid_asset_chg_ind;
	}

	/**
	 * @return the liquid_asset_other_chg_ind
	 */
	public String getLiquid_asset_other_chg_ind() {
		return liquid_asset_other_chg_ind;
	}

	/**
	 * @param liquid_asset_other_chg_ind the liquid_asset_other_chg_ind to set
	 */
	public void setLiquid_asset_other_chg_ind(final String liquid_asset_other_chg_ind) {
		this.liquid_asset_other_chg_ind = liquid_asset_other_chg_ind;
	}

	/**
	 * @return the life_ins_aset_add_ind
	 */
	public String getLife_ins_aset_add_ind() {
		return life_ins_aset_add_ind;
	}

	/**
	 * @param life_ins_aset_add_ind the life_ins_aset_add_ind to set
	 */
	public void setLife_ins_aset_add_ind(final String life_ins_aset_add_ind) {
		this.life_ins_aset_add_ind = life_ins_aset_add_ind;
	}

	/**
	 * @return the life_ins_aset_chg_ind
	 */
	public String getLife_ins_aset_chg_ind() {
		return life_ins_aset_chg_ind;
	}

	/**
	 * @param life_ins_aset_chg_ind the life_ins_aset_chg_ind to set
	 */
	public void setLife_ins_aset_chg_ind(final String life_ins_aset_chg_ind) {
		this.life_ins_aset_chg_ind = life_ins_aset_chg_ind;
	}

	/**
	 * @return the aset_xfer_chg_ind
	 */
	public String getAset_xfer_chg_ind() {
		return aset_xfer_chg_ind;
	}

	/**
	 * @param aset_xfer_chg_ind the aset_xfer_chg_ind to set
	 */
	public void setAset_xfer_chg_ind(final String aset_xfer_chg_ind) {
		this.aset_xfer_chg_ind = aset_xfer_chg_ind;
	}

	/**
	 * @return the dpnd_care_chg_ind
	 */
	public String getDpnd_care_chg_ind() {
		return dpnd_care_chg_ind;
	}

	/**
	 * @param dpnd_care_chg_ind the dpnd_care_chg_ind to set
	 */
	public void setDpnd_care_chg_ind(final String dpnd_care_chg_ind) {
		this.dpnd_care_chg_ind = dpnd_care_chg_ind;
	}

	/**
	 * @return the health_insurance_chg_ind
	 */
	public String getHealth_insurance_chg_ind() {
		return health_insurance_chg_ind;
	}

	/**
	 * @param health_insurance_chg_ind the health_insurance_chg_ind to set
	 */
	public void setHealth_insurance_chg_ind(final String health_insurance_chg_ind) {
		this.health_insurance_chg_ind = health_insurance_chg_ind;
	}

	/**
	 * @return the child_support_payment_chg_ind
	 */
	public String getChild_support_payment_chg_ind() {
		return child_support_payment_chg_ind;
	}

	/**
	 * @param child_support_payment_chg_ind the child_support_payment_chg_ind to set
	 */
	public void setChild_support_payment_chg_ind(final String child_support_payment_chg_ind) {
		this.child_support_payment_chg_ind = child_support_payment_chg_ind;
	}

	/**
	 * @return the snap_shelter_standard_exp_ind
	 */
	public String getSnap_shelter_standard_exp_ind() {
		return snap_shelter_standard_exp_ind;
	}

	/**
	 * @param snap_shelter_standard_exp_ind the snap_shelter_standard_exp_ind to set
	 */
	public void setSnap_shelter_standard_exp_ind(final String snap_shelter_standard_exp_ind) {
		this.snap_shelter_standard_exp_ind = snap_shelter_standard_exp_ind;
	}

	/**
	 * @return the hous_bill_chg_ind
	 */
	public String getHous_bill_chg_ind() {
		return hous_bill_chg_ind;
	}

	/**
	 * @param hous_bill_chg_ind the hous_bill_chg_ind to set
	 */
	public void setHous_bill_chg_ind(final String hous_bill_chg_ind) {
		this.hous_bill_chg_ind = hous_bill_chg_ind;
	}

	/**
	 * @return the add_chg_ind
	 */
	public String getAdd_chg_ind() {
		return add_chg_ind;
	}

	/**
	 * @param add_chg_ind the add_chg_ind to set
	 */
	public void setAdd_chg_ind(final String add_chg_ind) {
		this.add_chg_ind = add_chg_ind;
	}

	/**
	 * @return the person_moved_in_stat_ind
	 */
	public String getPerson_moved_in_stat_ind() {
		return person_moved_in_stat_ind;
	}

	/**
	 * @param person_moved_in_stat_ind the person_moved_in_stat_ind to set
	 */
	public void setPerson_moved_in_stat_ind(final String person_moved_in_stat_ind) {
		this.person_moved_in_stat_ind = person_moved_in_stat_ind;
	}

	/**
	 * @return the person_moved_out_stat_ind
	 */
	public String getPerson_moved_out_stat_ind() {
		return person_moved_out_stat_ind;
	}

	/**
	 * @param person_moved_out_stat_ind the person_moved_out_stat_ind to set
	 */
	public void setPerson_moved_out_stat_ind(final String person_moved_out_stat_ind) {
		this.person_moved_out_stat_ind = person_moved_out_stat_ind;
	}

	/**
	 * @return the hospice_chg_ind
	 */
	public String getHospice_chg_ind() {
		return hospice_chg_ind;
	}

	/**
	 * @param hospice_chg_ind the hospice_chg_ind to set
	 */
	public void setHospice_chg_ind(final String hospice_chg_ind) {
		this.hospice_chg_ind = hospice_chg_ind;
	}

	/**
	 * @return the medicare_chg_ind
	 */
	public String getMedicare_chg_ind() {
		return medicare_chg_ind;
	}

	/**
	 * @param medicare_chg_ind the medicare_chg_ind to set
	 */
	public void setMedicare_chg_ind(final String medicare_chg_ind) {
		this.medicare_chg_ind = medicare_chg_ind;
	}

	/**
	 * @return the ncp_chg_ind
	 */
	public String getNcp_chg_ind() {
		return ncp_chg_ind;
	}

	/**
	 * @param ncp_chg_ind the ncp_chg_ind to set
	 */
	public void setNcp_chg_ind(final String ncp_chg_ind) {
		this.ncp_chg_ind = ncp_chg_ind;
	}

	/**
	 * @return the third_party_chg_ind
	 */
	public String getThird_party_chg_ind() {
		return third_party_chg_ind;
	}

	/**
	 * @param third_party_chg_ind the third_party_chg_ind to set
	 */
	public void setThird_party_chg_ind(final String third_party_chg_ind) {
		this.third_party_chg_ind = third_party_chg_ind;
	}

	/**
	 * @return the hospital_abd_chg_ind
	 */
	public String getHospital_abd_chg_ind() {
		return hospital_abd_chg_ind;
	}

	/**
	 * @param hospital_abd_chg_ind the hospital_abd_chg_ind to set
	 */
	public void setHospital_abd_chg_ind(final String hospital_abd_chg_ind) {
		this.hospital_abd_chg_ind = hospital_abd_chg_ind;
	}

	/**
	 * @return the public_law_abd_chg_ind
	 */
	public String getPublic_law_abd_chg_ind() {
		return public_law_abd_chg_ind;
	}

	/**
	 * @param public_law_abd_chg_ind the public_law_abd_chg_ind to set
	 */
	public void setPublic_law_abd_chg_ind(final String public_law_abd_chg_ind) {
		this.public_law_abd_chg_ind = public_law_abd_chg_ind;
	}

	/**
	 * @return the living_argmt_chg_ind
	 */
	public String getLiving_argmt_chg_ind() {
		return living_argmt_chg_ind;
	}

	/**
	 * @param living_argmt_chg_ind the living_argmt_chg_ind to set
	 */
	public void setLiving_argmt_chg_ind(final String living_argmt_chg_ind) {
		this.living_argmt_chg_ind = living_argmt_chg_ind;
	}

	/**
	 * @return the other_program_chg_ind
	 */
	public String getOther_program_chg_ind() {
		return other_program_chg_ind;
	}

	/**
	 * @param other_program_chg_ind the other_program_chg_ind to set
	 */
	public void setOther_program_chg_ind(final String other_program_chg_ind) {
		this.other_program_chg_ind = other_program_chg_ind;
	}
		/**
	 * @return the magi_expense_chg_ind
	 */
	public String getMagi_expense_chg_ind() {
		return magi_expense_chg_ind;
	}

	/**
	 * @param magi_expense_chg_ind the magi_expense_chg_ind to set
	 */
	public void setMagi_expense_chg_ind(final String magi_expense_chg_ind) {
		this.magi_expense_chg_ind = magi_expense_chg_ind;
	}
	/**
	 * @return the tax_info_ind
	 */
	public String getTax_info_ind() {
		return tax_info_ind;
	}

	/**
	 * @param tax_info_ind the tax_info_ind to set
	 */
	public void setTax_info_ind(final String tax_info_ind) {
		this.tax_info_ind = tax_info_ind;
	}

	/**
	 * @return the tax_dep_outside_resp
	 */
	public String getTax_dep_outside_resp() {
		return tax_dep_outside_resp;
	}

	/**
	 * @param tax_dep_outside_resp the tax_dep_outside_resp to set
	 */
	public void setTax_dep_outside_resp(final String tax_dep_outside_resp) {
		this.tax_dep_outside_resp = tax_dep_outside_resp;
	}

	/**
	 * @return the oth_ind_gambl_pmnts
	 */
	public String getOth_ind_gambl_pmnts() {
		return oth_ind_gambl_pmnts;
	}

	/**
	 * @param oth_ind_gambl_pmnts the oth_ind_gambl_pmnts to set
	 */
	public void setOth_ind_gambl_pmnts(final String oth_ind_gambl_pmnts) {
		this.oth_ind_gambl_pmnts = oth_ind_gambl_pmnts;
	}
	
	/**
	 * @return the before_tax_deduction_resp
	 */
	public String getBefore_tax_deduction_resp() {
		return before_tax_deduction_resp;
	}

	/**
	 * @param before_tax_deduction_resp the before_tax_deduction_resp to set
	 */
	public void setBefore_tax_deduction_resp(final String before_tax_deduction_resp) {
		this.before_tax_deduction_resp = before_tax_deduction_resp;
	}

	/**
	 * @return the btd_med_ins
	 */
	public String getBtd_med_ins() {
		return btd_med_ins;
	}

	/**
	 * @param btd_med_ins the btd_med_ins to set
	 */
	public void setBtd_med_ins(final String btd_med_ins) {
		this.btd_med_ins = btd_med_ins;
	}

	/**
	 * @return the btd_dent_ins
	 */
	public String getBtd_dent_ins() {
		return btd_dent_ins;
	}

	/**
	 * @param btd_dent_ins the btd_dent_ins to set
	 */
	public void setBtd_dent_ins(final String btd_dent_ins) {
		this.btd_dent_ins = btd_dent_ins;
	}

	/**
	 * @return the btd_vis_care_ins
	 */
	public String getBtd_vis_care_ins() {
		return btd_vis_care_ins;
	}

	/**
	 * @param btd_vis_care_ins the btd_vis_care_ins to set
	 */
	public void setBtd_vis_care_ins(final String btd_vis_care_ins) {
		this.btd_vis_care_ins = btd_vis_care_ins;
	}

	/**
	 * @return the btd_flex_acc
	 */
	public String getBtd_flex_acc() {
		return btd_flex_acc;
	}

	/**
	 * @param btd_flex_acc the btd_flex_acc to set
	 */
	public void setBtd_flex_acc(final String btd_flex_acc) {
		this.btd_flex_acc = btd_flex_acc;
	}

	/**
	 * @return the btd_def_comp
	 */
	public String getBtd_def_comp() {
		return btd_def_comp;
	}

	/**
	 * @param btd_def_comp the btd_def_comp to set
	 */
	public void setBtd_def_comp(final String btd_def_comp) {
		this.btd_def_comp = btd_def_comp;
	}

	/**
	 * @return the btd_pre_tax_ins
	 */
	public String getBtd_pre_tax_ins() {
		return btd_pre_tax_ins;
	}

	/**
	 * @param btd_pre_tax_ins the btd_pre_tax_ins to set
	 */
	public void setBtd_pre_tax_ins(final String btd_pre_tax_ins) {
		this.btd_pre_tax_ins = btd_pre_tax_ins;
	}

	/**
	 * @return the btd_other
	 */
	public String getBtd_other() {
		return btd_other;
	}

	/**
	 * @param btd_other the btd_other to set
	 */
	public void setBtd_other(final String btd_other) {
		this.btd_other = btd_other;
	}

	/**
	 * @return the tax_deduct_resp
	 */
	public String getTax_deduct_resp() {
		return tax_deduct_resp;
	}

	/**
	 * @param tax_deduct_resp the tax_deduct_resp to set
	 */
	public void setTax_deduct_resp(final String tax_deduct_resp) {
		this.tax_deduct_resp = tax_deduct_resp;
	}

    /**
     * @return the tanfDiscResp
     */
    public String getTanfDiscResp() {
        return tanfDiscResp;
    }

    /**
     * @param tanfDiscResp the tanfDiscResp to set
     */
    public void setTanfDiscResp(final String tanfDiscResp) {
        this.tanfDiscResp = tanfDiscResp;
    }

	/**
	 * @return the out_st_bnft_chg_ind
	 */
	public String getOut_st_bnft_chg_ind() {
		return out_st_bnft_chg_ind;
	}

	/**
	 * @param out_st_bnft_chg_ind the out_st_bnft_chg_ind to set
	 */
	public void setOut_st_bnft_chg_ind(final String out_st_bnft_chg_ind) {
		this.out_st_bnft_chg_ind = out_st_bnft_chg_ind;
	}

	/**
	 * @return the schl_enrl_chg_ind
	 */
	public String getSchl_enrl_chg_ind() {
		return schl_enrl_chg_ind;
	}

	/**
	 * @param schl_enrl_chg_ind the schl_enrl_chg_ind to set
	 */
	public void setSchl_enrl_chg_ind(final String schl_enrl_chg_ind) {
		this.schl_enrl_chg_ind = schl_enrl_chg_ind;
	}

	/**
	 * @return the mrtl_stat_chg_ind
	 */
	public String getMrtl_stat_chg_ind() {
		return mrtl_stat_chg_ind;
	}

	/**
	 * @param mrtl_stat_chg_ind the mrtl_stat_chg_ind to set
	 */
	public void setMrtl_stat_chg_ind(final String mrtl_stat_chg_ind) {
		this.mrtl_stat_chg_ind = mrtl_stat_chg_ind;
	}

	/**
	 * @return the thrd_prty_chg_ind
	 */
	public String getThrd_prty_chg_ind() {
		return thrd_prty_chg_ind;
	}

	/**
	 * @param thrd_prty_chg_ind the thrd_prty_chg_ind to set
	 */
	public void setThrd_prty_chg_ind(final String thrd_prty_chg_ind) {
		this.thrd_prty_chg_ind = thrd_prty_chg_ind;
	}
	
	
	/**
	 * @return the alias_name_change_resp
	 */
	public String getAlias_name_change_resp() {
		return alias_name_change_resp;
	}

	/**
	 * @param alias_name_change_resp the alias_name_change_resp to set
	 */
	public void setAlias_name_change_resp(String alias_name_change_resp) {
		this.alias_name_change_resp = alias_name_change_resp;
	}

	/**
	 * @return the citizenship_chg_ind
	 */
	public String getCitizenship_chg_ind() {
		return citizenship_chg_ind;
	}

	/**
	 * @param citizenship_chg_ind the citizenship_chg_ind to set
	 */
	public void setCitizenship_chg_ind(String citizenship_chg_ind) {
		this.citizenship_chg_ind = citizenship_chg_ind;
	}

	/**
	 * @return the demographics_chg_ind
	 */
	public String getDemographics_chg_ind() {
		return demographics_chg_ind;
	}

	/**
	 * @param demographics_chg_ind the demographics_chg_ind to set
	 */
	public void setDemographics_chg_ind(String demographics_chg_ind) {
		this.demographics_chg_ind = demographics_chg_ind;
	}

	/**
	 * @return the alien_chg_ind
	 */
	public String getAlien_chg_ind() {
		return alien_chg_ind;
	}

	/**
	 * @param alien_chg_ind the alien_chg_ind to set
	 */
	public void setAlien_chg_ind(String alien_chg_ind) {
		this.alien_chg_ind = alien_chg_ind;
	}

	/**
	 * @return the util_bill_chg_Ind
	 */
	public String getUtil_bill_chg_Ind() {
		return util_bill_chg_Ind;
	}

	/**
	 * @param util_bill_chg_Ind the util_bill_chg_Ind to set
	 */
	public void setUtil_bill_chg_Ind(String util_bill_chg_Ind) {
		this.util_bill_chg_Ind = util_bill_chg_Ind;
	}

	/**
	 * @return the citizenship_info
	 */
	public String getCitizenship_info() {
		return citizenship_info;
	}

	/**
	 * @param citizenship_info the citizenship_info to set
	 */
	public void setCitizenship_info(String citizenship_info) {
		this.citizenship_info = citizenship_info;
	}

	/**
	 * @return the indv_prgm_chg_ind
	 */
	public String getIndv_prgm_chg_ind() {
		return indv_prgm_chg_ind;
	}

	/**
	 * @param indv_prgm_chg_ind the indv_prgm_chg_ind to set
	 */
	public void setIndv_prgm_chg_ind(String indv_prgm_chg_ind) {
		this.indv_prgm_chg_ind = indv_prgm_chg_ind;
	}
		
	

	/**
	 * @return the empl_hlth_ins_resp
	 */
	public String getEmpl_hlth_ins_resp() {
		return empl_hlth_ins_resp;
	}

	/**
	 * @param empl_hlth_ins_resp the empl_hlth_ins_resp to set
	 */
	public void setEmpl_hlth_ins_resp(String empl_hlth_ins_resp) {
		this.empl_hlth_ins_resp = empl_hlth_ins_resp;
	}

	/**
	 * @return the avd_prsctn_fstf
	 */
	public String getAvd_prsctn_fstf() {
		return avd_prsctn_fstf;
	}

	/**
	 * @param avd_prsctn_fstf the avd_prsctn_fstf to set
	 */
	public void setAvd_prsctn_fstf(String avd_prsctn_fstf) {
		this.avd_prsctn_fstf = avd_prsctn_fstf;
	}

	/**
	 * @return the cntrl_subs_resp
	 */
	public String getCntrl_subs_resp() {
		return cntrl_subs_resp;
	}

	/**
	 * @param cntrl_subs_resp the cntrl_subs_resp to set
	 */
	public void setCntrl_subs_resp(String cntrl_subs_resp) {
		this.cntrl_subs_resp = cntrl_subs_resp;
	}

	
	/**
	 * @return the heat_cool_src
	 */
	public String getHeat_cool_src() {
		return heat_cool_src;
	}

	/**
	 * @param heat_cool_src the heat_cool_src to set
	 */
	public void setHeat_cool_src(String heat_cool_src) {
		this.heat_cool_src = heat_cool_src;
	}

	/**
	 * returns the string value of cargo.
	 */
	@Override
	public String inspectCargo() {
	    
		final StringBuilder builder = new StringBuilder();
        builder.append("RMC_IN_PRFL_Cargo [isDirty=");
        builder.append(isDirty);
        builder.append(", app_num=");
        builder.append(app_num);
        builder.append(", indv_seq_num=");
        builder.append(indv_seq_num);
        builder.append(", acdt_resp=");
        builder.append(acdt_resp);
        builder.append(", adpt_asst_resp=");
        builder.append(adpt_asst_resp);
        builder.append(", almy_rcv_resp=");
        builder.append(almy_rcv_resp);
        builder.append(", bnft_anty_resp=");
        builder.append(bnft_anty_resp);
        builder.append(", bnft_chl_sprt_resp=");
        builder.append(bnft_chl_sprt_resp);
        builder.append(", bnft_chrt_resp=");
        builder.append(bnft_chrt_resp);
        builder.append(", bnft_dabl_resp=");
        builder.append(bnft_dabl_resp);
        builder.append(", bnft_divnd_resp=");
        builder.append(bnft_divnd_resp);
        builder.append(", bnft_est_trst_resp=");
        builder.append(bnft_est_trst_resp);
        builder.append(", bnft_rr_resp=");
        builder.append(bnft_rr_resp);
        builder.append(", bnft_uempl_resp=");
        builder.append(bnft_uempl_resp);
        builder.append(", bnft_vet_resp=");
        builder.append(bnft_vet_resp);
        builder.append(", chld_sprt_pay_resp=");
        builder.append(chld_sprt_pay_resp);
        builder.append(", dabl_resp=");
        builder.append(dabl_resp);
        builder.append(", dpnd_care_resp=");
        builder.append(dpnd_care_resp);
        builder.append(", drug_feln_resp=");
        builder.append(drug_feln_resp);
        builder.append(", educ_aid_resp=");
        builder.append(educ_aid_resp);
        builder.append(", empl_resp=");
        builder.append(empl_resp);
        builder.append(", fset_sctn_resp=");
        builder.append(fset_sctn_resp);
        builder.append(", fstr_care_resp=");
        builder.append(fstr_care_resp);
        builder.append(", gen_rlf_resp=");
        builder.append(gen_rlf_resp);
        builder.append(", hc_cvrg_resp=");
        builder.append(hc_cvrg_resp);
        builder.append(", incm_int_resp=");
        builder.append(incm_int_resp);
        builder.append(", irwe_resp=");
        builder.append(irwe_resp);
        builder.append(", job_iknd_resp=");
        builder.append(job_iknd_resp);
        builder.append(", kinship_care_resp=");
        builder.append(kinship_care_resp);
        builder.append(", med_exp_resp=");
        builder.append(med_exp_resp);
        builder.append(", mil_allot_resp=");
        builder.append(mil_allot_resp);
        builder.append(", mony_othr_resp=");
        builder.append(mony_othr_resp);
        builder.append(", natl_rfge_resp=");
        builder.append(natl_rfge_resp);
        builder.append(", need_ind_resp=");
        builder.append(need_ind_resp);
        builder.append(", on_strk_sw=");
        builder.append(on_strk_sw);
        builder.append(", op_aoda_tmt_rcv_sw=");
        builder.append(op_aoda_tmt_rcv_sw);
        builder.append(", othr_incm_resp=");
        builder.append(othr_incm_resp);
        builder.append(", othr_src_resp=");
        builder.append(othr_src_resp);
        builder.append(", own_aset_resp=");
        builder.append(own_aset_resp);
        builder.append(", pay_hous_bill_resp=");
        builder.append(pay_hous_bill_resp);
        builder.append(", pay_rmr_brd_resp=");
        builder.append(pay_rmr_brd_resp);
        builder.append(", pnsn_retr_resp=");
        builder.append(pnsn_retr_resp);
        builder.append(", preg_resp=");
        builder.append(preg_resp);
        builder.append(", prop_sold_resp=");
        builder.append(prop_sold_resp);
        builder.append(", pub_asst_resp=");
        builder.append(pub_asst_resp);
        builder.append(", rcv_fs_oth_st_resp=");
        builder.append(rcv_fs_oth_st_resp);
        builder.append(", rcv_hous_asst_resp=");
        builder.append(rcv_hous_asst_resp);
        builder.append(", rcv_medcr_resp=");
        builder.append(rcv_medcr_resp);
        builder.append(", rcv_ss_resp=");
        builder.append(rcv_ss_resp);
        builder.append(", rcv_ssi_ltr_resp=");
        builder.append(rcv_ssi_ltr_resp);
        builder.append(", rcv_ssi_sw=");
        builder.append(rcv_ssi_sw);
        builder.append(", rmr_brd_incm_resp=");
        builder.append(rmr_brd_incm_resp);
        builder.append(", self_empl_resp=");
        builder.append(self_empl_resp);
        builder.append(", ssi_dcond_resp=");
        builder.append(ssi_dcond_resp);
        builder.append(", ssi_1619b_rcv_sw=");
        builder.append(ssi_1619b_rcv_sw);
        builder.append(", su_ases_resp=");
        builder.append(su_ases_resp);
        builder.append(", su_cst_coal_resp=");
        builder.append(su_cst_coal_resp);
        builder.append(", su_cst_elec_resp=");
        builder.append(su_cst_elec_resp);
        builder.append(", su_cst_fuel_resp=");
        builder.append(su_cst_fuel_resp);
        builder.append(", su_cst_gas_resp=");
        builder.append(su_cst_gas_resp);
        builder.append(", su_cst_home_resp=");
        builder.append(su_cst_home_resp);
        builder.append(", su_cst_istl_resp=");
        builder.append(su_cst_istl_resp);
        builder.append(", su_cst_lpgas_resp=");
        builder.append(su_cst_lpgas_resp);
        builder.append(", su_cst_mbl_resp=");
        builder.append(su_cst_mbl_resp);
        builder.append(", su_cst_mtge_resp=");
        builder.append(su_cst_mtge_resp);
        builder.append(", su_cst_othr_resp=");
        builder.append(su_cst_othr_resp);
        builder.append(", su_cst_phn_resp=");
        builder.append(su_cst_phn_resp);
        builder.append(", su_cst_rent_resp=");
        builder.append(su_cst_rent_resp);
        builder.append(", su_cst_swr_resp=");
        builder.append(su_cst_swr_resp);
        builder.append(", su_cst_tax_resp=");
        builder.append(su_cst_tax_resp);
        builder.append(", su_cst_trsh_resp=");
        builder.append(su_cst_trsh_resp);
        builder.append(", su_cst_wood_resp=");
        builder.append(su_cst_wood_resp);
        builder.append(", su_cst_wtr_resp=");
        builder.append(su_cst_wtr_resp);
        builder.append(", su_cst_wwt_resp=");
        builder.append(su_cst_wwt_resp);
        builder.append(", trb_cpta_resp=");
        builder.append(trb_cpta_resp);
        builder.append(", trb_tanf_resp=");
        builder.append(trb_tanf_resp);
        builder.append(", updt_dt=");
        builder.append(updt_dt);
        builder.append(", util_exp_resp=");
        builder.append(util_exp_resp);
        builder.append(", wheap_resp=");
        builder.append(wheap_resp);
        builder.append(", work_comp_resp=");
        builder.append(work_comp_resp);
        builder.append(", yehoc_resp=");
        builder.append(yehoc_resp);
        builder.append(", resettl_inc_resp=");
        builder.append(resettl_inc_resp);
        builder.append(", none_resp=");
        builder.append(none_resp);
        builder.append(", land_cont_resp=");
        builder.append(land_cont_resp);
        builder.append(", refused_job_lst_30_resp=");
        builder.append(refused_job_lst_30_resp);
        builder.append(", child_support_arr_resp=");
        builder.append(child_support_arr_resp);
        builder.append(", unocc_home_exp_resp=");
        builder.append(unocc_home_exp_resp);
        builder.append(", tribal_food_dist_resp=");
        builder.append(tribal_food_dist_resp);
        builder.append(", child_adult_care_resp=");
        builder.append(child_adult_care_resp);
        builder.append(", mi_heating_cred_resp=");
        builder.append(mi_heating_cred_resp);
        builder.append(", mortg_guar_ins_resp=");
        builder.append(mortg_guar_ins_resp);
        builder.append(", coop_condo_fee_resp=");
        builder.append(coop_condo_fee_resp);
        builder.append(", other_resp=");
        builder.append(other_resp);
        builder.append(", water_well_resp=");
        builder.append(water_well_resp);
        builder.append(", cooking_fuel_resp=");
        builder.append(cooking_fuel_resp);
        builder.append(", water_well_maint_resp=");
        builder.append(water_well_maint_resp);
        builder.append(", heating_resp=");
        builder.append(heating_resp);
        builder.append(", cooling_resp=");
        builder.append(cooling_resp);
        builder.append(", septic_sewer_resp=");
        builder.append(septic_sewer_resp);
        builder.append(", home_equity_resp=");
        builder.append(home_equity_resp);
        builder.append(", second_mortgag_resp=");
        builder.append(second_mortgag_resp);
        builder.append(", othr_incm_rentl_resp=");
        builder.append(othr_incm_rentl_resp);
        builder.append(", cp_wlst_resp=");
        builder.append(cp_wlst_resp);
        builder.append(", indv_cla_ind=");
        builder.append(indv_cla_ind);
        builder.append(", past_hc_cvrg_resp=");
        builder.append(past_hc_cvrg_resp);
        builder.append(", trb_cmdy_resp=");
        builder.append(trb_cmdy_resp);
        builder.append(", bury_aset_c_resp=");
        builder.append(bury_aset_c_resp);
        builder.append(", bury_aset_ibt_resp=");
        builder.append(bury_aset_ibt_resp);
        builder.append(", bury_aset_ins_resp=");
        builder.append(bury_aset_ins_resp);
        builder.append(", bury_aset_mas_resp=");
        builder.append(bury_aset_mas_resp);
        builder.append(", bury_aset_oth_resp=");
        builder.append(bury_aset_oth_resp);
        builder.append(", bury_aset_plt_resp=");
        builder.append(bury_aset_plt_resp);
        builder.append(", bury_aset_rbt_resp=");
        builder.append(bury_aset_rbt_resp);
        builder.append(", bury_aset_v_resp=");
        builder.append(bury_aset_v_resp);
        builder.append(", li_aset_g_l_resp=");
        builder.append(li_aset_g_l_resp);
        builder.append(", li_aset_g_t_resp=");
        builder.append(li_aset_g_t_resp);
        builder.append(", li_aset_trm_resp=");
        builder.append(li_aset_trm_resp);
        builder.append(", li_aset_unv_resp=");
        builder.append(li_aset_unv_resp);
        builder.append(", li_aset_w_l_resp=");
        builder.append(li_aset_w_l_resp);
        builder.append(", lqd_aset_c_a_resp=");
        builder.append(lqd_aset_c_a_resp);
        builder.append(", lqd_aset_eb_a_resp=");
        builder.append(lqd_aset_eb_a_resp);
        builder.append(", lqd_aset_h_s_resp=");
        builder.append(lqd_aset_h_s_resp);
        builder.append(", lqd_aset_ira_resp=");
        builder.append(lqd_aset_ira_resp);
        builder.append(", lqd_aset_k_p_resp=");
        builder.append(lqd_aset_k_p_resp);
        builder.append(", lqd_aset_m_o_resp=");
        builder.append(lqd_aset_m_o_resp);
        builder.append(", lqd_aset_mm_a_resp=");
        builder.append(lqd_aset_mm_a_resp);
        builder.append(", lqd_aset_o_t_resp=");
        builder.append(lqd_aset_o_t_resp);
        builder.append(", lqd_aset_othr_resp=");
        builder.append(lqd_aset_othr_resp);
        builder.append(", lqd_aset_s_a_resp=");
        builder.append(lqd_aset_s_a_resp);
        builder.append(", lqd_aset_s_c_resp=");
        builder.append(lqd_aset_s_c_resp);
        builder.append(", lqd_aset_st_b_resp=");
        builder.append(lqd_aset_st_b_resp);
        builder.append(", lqd_aset_tr_f_resp=");
        builder.append(lqd_aset_tr_f_resp);
        builder.append(", lqd_aset_us_b_resp=");
        builder.append(lqd_aset_us_b_resp);
        builder.append(", other_asset_burial_resp=");
        builder.append(other_asset_burial_resp);
        builder.append(", other_aset_life_insurance_resp=");
        builder.append(other_aset_life_insurance_resp);
        builder.append(", other_asset_personal_prop_resp=");
        builder.append(other_asset_personal_prop_resp);
        builder.append(", other_asset_real_property_resp=");
        builder.append(other_asset_real_property_resp);
        builder.append(", other_asset_vehicle_resp=");
        builder.append(other_asset_vehicle_resp);
        builder.append(", real_aset_apt_resp=");
        builder.append(real_aset_apt_resp);
        builder.append(", real_aset_com_resp=");
        builder.append(real_aset_com_resp);
        builder.append(", real_aset_con_resp=");
        builder.append(real_aset_con_resp);
        builder.append(", real_aset_dup_resp=");
        builder.append(real_aset_dup_resp);
        builder.append(", real_aset_frm_resp=");
        builder.append(real_aset_frm_resp);
        builder.append(", real_aset_hse_resp=");
        builder.append(real_aset_hse_resp);
        builder.append(", real_aset_lnd_resp=");
        builder.append(real_aset_lnd_resp);
        builder.append(", real_aset_m_h_resp=");
        builder.append(real_aset_m_h_resp);
        builder.append(", real_aset_oth_resp=");
        builder.append(real_aset_oth_resp);
        builder.append(", veh_aset_auto_resp=");
        builder.append(veh_aset_auto_resp);
        builder.append(", veh_aset_boat_resp=");
        builder.append(veh_aset_boat_resp);
        builder.append(", veh_aset_camp_resp=");
        builder.append(veh_aset_camp_resp);
        builder.append(", veh_aset_mcyc_resp=");
        builder.append(veh_aset_mcyc_resp);
        builder.append(", veh_aset_anml_resp=");
        builder.append(veh_aset_anml_resp);
        builder.append(", veh_aset_arpl_resp=");
        builder.append(veh_aset_arpl_resp);
        builder.append(", veh_aset_bus_resp=");
        builder.append(veh_aset_bus_resp);
        builder.append(", veh_aset_fimp_resp=");
        builder.append(veh_aset_fimp_resp);
        builder.append(", veh_aset_fmeq_resp=");
        builder.append(veh_aset_fmeq_resp);
        builder.append(", veh_aset_ftrc_resp=");
        builder.append(veh_aset_ftrc_resp);
        builder.append(", veh_aset_ftrl_resp=");
        builder.append(veh_aset_ftrl_resp);
        builder.append(", veh_aset_lskd_resp=");
        builder.append(veh_aset_lskd_resp);
        builder.append(", veh_aset_mped_resp=");
        builder.append(veh_aset_mped_resp);
        builder.append(", veh_aset_nm_b_resp=");
        builder.append(veh_aset_nm_b_resp);
        builder.append(", veh_aset_othr_resp=");
        builder.append(veh_aset_othr_resp);
        builder.append(", veh_aset_rv_resp=");
        builder.append(veh_aset_rv_resp);
        builder.append(", veh_aset_s_mb_resp=");
        builder.append(veh_aset_s_mb_resp);
        builder.append(", veh_aset_trk_resp=");
        builder.append(veh_aset_trk_resp);
        builder.append(", veh_aset_trlr_resp=");
        builder.append(veh_aset_trlr_resp);
        builder.append(", veh_aset_van_resp=");
        builder.append(veh_aset_van_resp);
        builder.append(", bnft_mapp_resp=");
        builder.append(bnft_mapp_resp);
        builder.append(", school_enrollment_resp=");
        builder.append(school_enrollment_resp);
        builder.append(", hospital_stay_resp=");
        builder.append(hospital_stay_resp);
        builder.append(", head_of_household_resp=");
        builder.append(head_of_household_resp);
        builder.append(", medical_service_resp=");
        builder.append(medical_service_resp);
        builder.append(", emergency_medical_service_resp=");
        builder.append(emergency_medical_service_resp);
        builder.append(", parole_violation_resp=");
        builder.append(parole_violation_resp);
        builder.append(", room_board_resp=");
        builder.append(room_board_resp);
        builder.append(", current_past_job_resp=");
        builder.append(current_past_job_resp);
        builder.append(", moved_into_home_response=");
        builder.append(moved_into_home_response);
        builder.append(", moved_out_of_home_resp=");
        builder.append(moved_out_of_home_resp);
        builder.append(", liquid_asset_bank_acc_resp=");
        builder.append(liquid_asset_bank_acc_resp);
        builder.append(", other_asset_transfer_resp=");
        builder.append(other_asset_transfer_resp);
        builder.append(", liquid_aset_disable_blind_resp=");
        builder.append(liquid_aset_disable_blind_resp);
        builder.append(", liquid_asset_ira_resp=");
        builder.append(liquid_asset_ira_resp);
        builder.append(", liquid_asset_irs_retirmnt_resp=");
        builder.append(liquid_asset_irs_retirmnt_resp);
        builder.append(", liquid_asset_savings_acc_resp=");
        builder.append(liquid_asset_savings_acc_resp);
        builder.append(", liquid_asset_pension_plan_resp=");
        builder.append(liquid_asset_pension_plan_resp);
        builder.append(", liquid_asset_promissory_resp=");
        builder.append(liquid_asset_promissory_resp);
        builder.append(", liquid_asset_retirement_resp=");
        builder.append(liquid_asset_retirement_resp);
        builder.append(", liquid_asset_stocks_bonds_resp=");
        builder.append(liquid_asset_stocks_bonds_resp);
        builder.append(", liquid_asset_trust_fund_resp=");
        builder.append(liquid_asset_trust_fund_resp);
        builder.append(", liquid_asset_other_response=");
        builder.append(liquid_asset_other_response);
        builder.append(", liquid_asset_other_type_resp=");
        builder.append(liquid_asset_other_type_resp);
        builder.append(", liquid_asset_cash_resp=");
        builder.append(liquid_asset_cash_resp);
        builder.append(", indv_wic_rqst_ind=");
        builder.append(indv_wic_rqst_ind);
        builder.append(", indv_tanf_rqst_ind=");
        builder.append(indv_tanf_rqst_ind);
        builder.append(", indv_cc_rqst_ind=");
        builder.append(indv_cc_rqst_ind);
        builder.append(", indv_fma_rqst_ind=");
        builder.append(indv_fma_rqst_ind);
        builder.append(", indv_fs_rqst_ind=");
        builder.append(indv_fs_rqst_ind);
        builder.append(", indv_fpw_rqst_ind=");
        builder.append(indv_fpw_rqst_ind);
        builder.append(", tanf_ind=");
        builder.append(tanf_ind);
        builder.append(", life_ins_asset_whole_life_resp=");
        builder.append(life_ins_asset_whole_life_resp);
        builder.append(", life_insurance_asset_term_resp=");
        builder.append(life_insurance_asset_term_resp);
        builder.append(", life_ins_asest_group_life_resp=");
        builder.append(life_ins_asest_group_life_resp);
        builder.append(", life_ins_asset_group_term_resp=");
        builder.append(life_ins_asset_group_term_resp);
        builder.append(", life_ins_asset_universal_resp=");
        builder.append(life_ins_asset_universal_resp);
        builder.append(", life_insurance_other_resp=");
        builder.append(life_insurance_other_resp);
        builder.append(", real_asset_land_resp=");
        builder.append(real_asset_land_resp);
        builder.append(", real_asset_mobile_home_resp=");
        builder.append(real_asset_mobile_home_resp);
        builder.append(", real_asset_other_resp=");
        builder.append(real_asset_other_resp);
        builder.append(", real_asset_life_estate_resp=");
        builder.append(real_asset_life_estate_resp);
        builder.append(", real_asset_house_resp=");
        builder.append(real_asset_house_resp);
        builder.append(", real_asset_unoccupy_home_resp=");
        builder.append(real_asset_unoccupy_home_resp);
        builder.append(", real_asset_home_resp=");
        builder.append(real_asset_home_resp);
        builder.append(", vehicle_asset_auto_resp=");
        builder.append(vehicle_asset_auto_resp);
        builder.append(", vehicle_asset_boat_resp=");
        builder.append(vehicle_asset_boat_resp);
        builder.append(", vehicle_asset_motorcycle_resp=");
        builder.append(vehicle_asset_motorcycle_resp);
        builder.append(", vehicle_asset_other_resp=");
        builder.append(vehicle_asset_other_resp);
        builder.append(", vehicle_asset_recreation_resp=");
        builder.append(vehicle_asset_recreation_resp);
        builder.append(", vehicle_asset_animal_drwn_resp=");
        builder.append(vehicle_asset_animal_drwn_resp);
        builder.append(", vehicle_asset_tractor_resp=");
        builder.append(vehicle_asset_tractor_resp);
        builder.append(", vehicle_asset_golf_cart_resp=");
        builder.append(vehicle_asset_golf_cart_resp);
        builder.append(", vehicle_asset_nmot_camper_resp=");
        builder.append(vehicle_asset_nmot_camper_resp);
        builder.append(", vehicle_asset_camper_resp=");
        builder.append(vehicle_asset_camper_resp);
        builder.append(", training_allowance_resp=");
        builder.append(training_allowance_resp);
        builder.append(", inheritance_resp=");
        builder.append(inheritance_resp);
        builder.append(", student_financial_aid_resp=");
        builder.append(student_financial_aid_resp);
        builder.append(", food_clothing_util_rent_resp=");
        builder.append(food_clothing_util_rent_resp);
        builder.append(", cash_gifts_resp=");
        builder.append(cash_gifts_resp);
        builder.append(", loan_resp=");
        builder.append(loan_resp);
        builder.append(", benefit_black_lung_resp=");
        builder.append(benefit_black_lung_resp);
        builder.append(", lottery_prize_winning_resp=");
        builder.append(lottery_prize_winning_resp);
        builder.append(", insurance_settlement_resp=");
        builder.append(insurance_settlement_resp);
        builder.append(", othr_social_security_bnft_resp=");
        builder.append(othr_social_security_bnft_resp);
        builder.append(", benefits_on_strike_resp=");
        builder.append(benefits_on_strike_resp);
        builder.append(", work_related_expense_resp=");
        builder.append(work_related_expense_resp);
        builder.append(", med_type_prosthetic_resp=");
        builder.append(med_type_prosthetic_resp);
        builder.append(", med_type_atndnt_meal_resp=");
        builder.append(med_type_atndnt_meal_resp);
        builder.append(", med_type_animal_resp=");
        builder.append(med_type_animal_resp);
        builder.append(", med_type_maintain_attndnt_resp=");
        builder.append(med_type_maintain_attndnt_resp);
        builder.append(", med_type_inhome_resp=");
        builder.append(med_type_inhome_resp);
        builder.append(", med_type_special_equip_resp=");
        builder.append(med_type_special_equip_resp);
        builder.append(", med_type_eyeglasses_resp=");
        builder.append(med_type_eyeglasses_resp);
        builder.append(", med_type_insurance_resp=");
        builder.append(med_type_insurance_resp);
        builder.append(", med_type_bills_resp=");
        builder.append(med_type_bills_resp);
        builder.append(", med_type_supplies_resp=");
        builder.append(med_type_supplies_resp);
        builder.append(", med_type_nursing_resp=");
        builder.append(med_type_nursing_resp);
        builder.append(", med_type_other_resp=");
        builder.append(med_type_other_resp);
        builder.append(", med_type_out_patient_resp=");
        builder.append(med_type_out_patient_resp);
        builder.append(", med_type_psychotherapy_resp=");
        builder.append(med_type_psychotherapy_resp);
        builder.append(", med_type_prescribed_drug_resp=");
        builder.append(med_type_prescribed_drug_resp);
        builder.append(", med_type_transportation_resp=");
        builder.append(med_type_transportation_resp);
        builder.append(", utility_standard_resp=");
        builder.append(utility_standard_resp);
        builder.append(", other_incm_contrib_resp=");
        builder.append(other_incm_contrib_resp);
        builder.append(", child_care_resp=");
        builder.append(child_care_resp);
        builder.append(", child_obligation_resp=");
        builder.append(child_obligation_resp);
        builder.append(", medical_bills_resp=");
        builder.append(medical_bills_resp);
        builder.append(", medtyp_dental=");
        builder.append(medtyp_dental);
        builder.append(", medtyp_attendant_care=");
        builder.append(medtyp_attendant_care);
        builder.append(", medtyp_doctor=");
        builder.append(medtyp_doctor);
        builder.append(", medtyp_med_equip=");
        builder.append(medtyp_med_equip);
        builder.append(", medtyp_hosp_bills=");
        builder.append(medtyp_hosp_bills);
        builder.append(", medtyp_insur_premium=");
        builder.append(medtyp_insur_premium);
        builder.append(", medtyp_rx_cost=");
        builder.append(medtyp_rx_cost);
        builder.append(", medtyp_trans_med=");
        builder.append(medtyp_trans_med);
        builder.append(", medtyp_other=");
        builder.append(medtyp_other);
        builder.append(", hospice_resp=");
        builder.append(hospice_resp);
        builder.append(", outstate_bnft_resp=");
        builder.append(outstate_bnft_resp);
        builder.append(", unpaid_medbill=");
        builder.append(unpaid_medbill);
        builder.append(", veh_aset_unlic_resp=");
        builder.append(veh_aset_unlic_resp);
        builder.append(", real_asset_rental_resp=");
        builder.append(real_asset_rental_resp);
        builder.append(", real_aset_vac_resp=");
        builder.append(real_aset_vac_resp);
        builder.append(", special_need_resp=");
        builder.append(special_need_resp);
        builder.append(", foster_care_resp=");
        builder.append(foster_care_resp);
        builder.append(", former_foster_resp=");
        builder.append(former_foster_resp);
        builder.append(", child_protective_resp=");
        builder.append(child_protective_resp);
        builder.append(", living_prog_resp=");
        builder.append(living_prog_resp);
        builder.append(", grand_parent_resp=");
        builder.append(grand_parent_resp);
        builder.append(", drug_felonies_resp=");
        builder.append(drug_felonies_resp);
        builder.append(", snap_tanf_disc_resp=");
        builder.append(snap_tanf_disc_resp);
        builder.append(", avoid_prosc_resp=");
        builder.append(avoid_prosc_resp);
        builder.append(", violating_parole_resp=");
        builder.append(violating_parole_resp);
        builder.append(", convic_false_info_resp=");
        builder.append(convic_false_info_resp);
        builder.append(", voluntarily_quit_job_resp=");
        builder.append(voluntarily_quit_job_resp);
        builder.append(", trading_snap_resp=");
        builder.append(trading_snap_resp);
        builder.append(", buy_sell_snap_resp=");
        builder.append(buy_sell_snap_resp);
        builder.append(", trade_snap_gun_resp=");
        builder.append(trade_snap_gun_resp);
        builder.append(", prev_ssi_resp=");
        builder.append(prev_ssi_resp);
        builder.append(", home_community_resp=");
        builder.append(home_community_resp);
        builder.append(", tribal_health_resp=");
        builder.append(tribal_health_resp);
        builder.append(", tribal_eligibility_resp=");
        builder.append(tribal_eligibility_resp);
        builder.append(", domestic_violence_resp=");
        builder.append(domestic_violence_resp);
        builder.append(", tanf_eppic_resp=");
        builder.append(tanf_eppic_resp);
        builder.append(", emergency_medical_resp=");
        builder.append(emergency_medical_resp);
        builder.append(", adoptAssistance=");
        builder.append(adoptAssistance);
        builder.append(", adoptionPayments=");
        builder.append(adoptionPayments);
        builder.append(", agentOrangePayments=");
        builder.append(agentOrangePayments);
        builder.append(", alimony=");
        builder.append(alimony);
        builder.append(", capitalGains=");
        builder.append(capitalGains);
        builder.append(", deathBenefits=");
        builder.append(deathBenefits);
        builder.append(", disabilityIncome=");
        builder.append(disabilityIncome);
        builder.append(", disasterRelief=");
        builder.append(disasterRelief);
        builder.append(", educationalAssistance=");
        builder.append(educationalAssistance);
        builder.append(", energyAssistance=");
        builder.append(energyAssistance);
        builder.append(", farmAllotment=");
        builder.append(farmAllotment);
        builder.append(", fosterCarePayments=");
        builder.append(fosterCarePayments);
        builder.append(", generalAssistance=");
        builder.append(generalAssistance);
        builder.append(", interestDividendPayments=");
        builder.append(interestDividendPayments);
        builder.append(", iRADistribution=");
        builder.append(iRADistribution);
        builder.append(", lotteryWinnings=");
        builder.append(lotteryWinnings);
        builder.append(", lumpSum=");
        builder.append(lumpSum);
        builder.append(", militaryAllotment=");
        builder.append(militaryAllotment);
        builder.append(", moneyFromAnotherPerson=");
        builder.append(moneyFromAnotherPerson);
        builder.append(", netRentalRoyalty=");
        builder.append(netRentalRoyalty);
        builder.append(", otherIncome=");
        builder.append(otherIncome);
        builder.append(", paymentsFromAnnuity=");
        builder.append(paymentsFromAnnuity);
        builder.append(", paymentsMadeOnYourBehalf=");
        builder.append(paymentsMadeOnYourBehalf);
        builder.append(", pensionOrRetirement=");
        builder.append(pensionOrRetirement);
        builder.append(", railroadRetirement=");
        builder.append(railroadRetirement);
        builder.append(", refugeeCash=");
        builder.append(refugeeCash);
        builder.append(", relativeCareSubsidy=");
        builder.append(relativeCareSubsidy);
        builder.append(", rentalIncome=");
        builder.append(rentalIncome);
        builder.append(", tANFPayments=");
        builder.append(tANFPayments);
        builder.append(", unemploymentCompensation=");
        builder.append(unemploymentCompensation);
        builder.append(", workStudyStateFederal=");
        builder.append(workStudyStateFederal);
        builder.append(", workersCompensation=");
        builder.append(workersCompensation);
        builder.append(", medtyp_hsa_contrib=");
        builder.append(medtyp_hsa_contrib);
        builder.append(", pers_prop_bus_eqpt=");
        builder.append(pers_prop_bus_eqpt);
        builder.append(", pers_prop_cemetary_lot=");
        builder.append(pers_prop_cemetary_lot);
        builder.append(", pers_prop_livestock=");
        builder.append(pers_prop_livestock);
        builder.append(", pers_prop_saf_depst_box=");
        builder.append(pers_prop_saf_depst_box);
        builder.append(", pers_prop_oth_val=");
        builder.append(pers_prop_oth_val);
        builder.append(", able_to_conceive_resp=");
        builder.append(able_to_conceive_resp);
        builder.append(", underweight_birth_resp=");
        builder.append(underweight_birth_resp);
        builder.append(", preg_add_stat_sw=");
        builder.append(preg_add_stat_sw);
        builder.append(", preg_chg_stat_sw=");
        builder.append(preg_chg_stat_sw);
        builder.append(", prsn_info_stat_sw=");
        builder.append(prsn_info_stat_sw);
        builder.append(", rlt_chg_stat_sw=");
        builder.append(rlt_chg_stat_sw);
        builder.append(", prevent_eviction_resp=");
        builder.append(prevent_eviction_resp);
        builder.append(", disaster_repair_resp=");
        builder.append(disaster_repair_resp);
        builder.append(", other_housing_bill_resp=");
        builder.append(other_housing_bill_resp);
        builder.append(", su_cst_ins_resp=");
        builder.append(su_cst_ins_resp);
        builder.append(", careTaker_resp=");
        builder.append(careTaker_resp);
        builder.append(", othr_incm_trbl_resp=");
        builder.append(othr_incm_trbl_resp);
        builder.append(", lost_health_ins_ind=");
        builder.append(lost_health_ins_ind);
        builder.append(", tax_claim_dependant_resp=");
        builder.append(tax_claim_dependant_resp);
        builder.append(", before_tax_deduction_resp=");
        builder.append(before_tax_deduction_resp);
        builder.append(", btd_med_ins=");
        builder.append(btd_med_ins);
        builder.append(", btd_dent_ins=");
        builder.append(btd_dent_ins);
        builder.append(", btd_vis_care_ins=");
        builder.append(btd_vis_care_ins);
        builder.append(", btd_flex_acc=");
        builder.append(btd_flex_acc);
        builder.append(", btd_def_comp=");
        builder.append(btd_def_comp);
        builder.append(", btd_pre_tax_ins=");
        builder.append(btd_pre_tax_ins);
        builder.append(", btd_other=");
        builder.append(btd_other);
        builder.append(", tax_deduct_resp=");
        builder.append(tax_deduct_resp);
        builder.append(", hlth_ins_resp=");
        builder.append(hlth_ins_resp);
        builder.append(", othr_hlth_ins_resp=");
        builder.append(othr_hlth_ins_resp);
        builder.append(", tanfDiscResp=");
        builder.append(tanfDiscResp);
        builder.append(", housing_bill_others_resp=");
        builder.append(housing_bill_others_resp);
        builder.append(", utility_bills_oil_resp=");
        builder.append(utility_bills_oil_resp);
        
        //add and change indicators
        builder.append(", room_brd_chg_ind=");
        builder.append(	room_brd_chg_ind);
        builder.append(", dabl_stat_ind=");
        builder.append(	dabl_stat_ind);
        builder.append(", preg_add_stat_ind=");
        builder.append(	preg_add_stat_ind);
        builder.append(", preg_chg_ind=");
        builder.append(	preg_chg_ind);
        builder.append(", irwe_chg_ind=");
        builder.append(	irwe_chg_ind);
        builder.append(", ei_chg_ind=");
        builder.append(	ei_chg_ind);
        builder.append(", self_empl_chg_ind=");
        builder.append(	self_empl_chg_ind);
        builder.append(", othr_incm_chg_ind=");
        builder.append(	othr_incm_chg_ind);
        builder.append(", empl_chg_ind=");
        builder.append(	empl_chg_ind);
        builder.append(", veh_aset_add_ind=");
        builder.append(	veh_aset_add_ind);
        builder.append(", veh_aset_chg_ind=");
        builder.append(	veh_aset_chg_ind);
        builder.append(", real_aset_add_ind=");
        builder.append(	real_aset_add_ind);
        builder.append(", real_aset_chg_ind=");
        builder.append(	real_aset_chg_ind);
        builder.append(", bury_aset_add_ind=");
        builder.append(	bury_aset_add_ind);
        builder.append(", bury_aset_chg_ind=");
        builder.append(	bury_aset_chg_ind);
        builder.append(", liquid_asset_add_ind=");
        builder.append(	liquid_asset_add_ind);
        builder.append(", liquid_asset_bank_acc_chg_ind=");
        builder.append(	liquid_asset_bank_acc_chg_ind);
        builder.append(", liquid_asset_cash_chg_ind=");
        builder.append(	liquid_asset_cash_chg_ind);
        builder.append(", liquid_asset_chg_ind=");
        builder.append(	liquid_asset_chg_ind);
        builder.append(", liquid_asset_other_chg_ind=");
        builder.append(	liquid_asset_other_chg_ind);
        builder.append(", life_ins_aset_add_ind=");
        builder.append(	life_ins_aset_add_ind);
        builder.append(", life_ins_aset_chg_ind=");
        builder.append(	life_ins_aset_chg_ind);
        builder.append(", aset_xfer_chg_ind=");
        builder.append(	aset_xfer_chg_ind);
        builder.append(", dpnd_care_chg_ind=");
        builder.append(	dpnd_care_chg_ind);
        builder.append(", health_insurance_chg_ind=");
        builder.append(	health_insurance_chg_ind);
        builder.append(", child_support_payment_chg_ind=");
        builder.append(	child_support_payment_chg_ind);
        builder.append(", snap_shelter_standard_exp_ind=");
        builder.append(	snap_shelter_standard_exp_ind);
        builder.append(", hous_bill_chg_ind=");
        builder.append(	hous_bill_chg_ind);
        builder.append(", add_chg_ind=");
        builder.append(	add_chg_ind);
        builder.append(", person_moved_in_stat_ind=");
        builder.append(	person_moved_in_stat_ind);
        builder.append(", person_moved_out_stat_ind=");
        builder.append(	person_moved_out_stat_ind);
        builder.append(", hospice_chg_ind=");
        builder.append(	hospice_chg_ind);
        builder.append(", medicare_chg_ind=");
        builder.append(	medicare_chg_ind);
        builder.append(", ncp_chg_ind=");
        builder.append(	ncp_chg_ind);
        builder.append(", third_party_chg_ind=");
        builder.append(	third_party_chg_ind	);
        builder.append(", hospital_abd_chg_ind=");
        builder.append(	hospital_abd_chg_ind);
        builder.append(", public_law_abd_chg_ind=");
        builder.append(	public_law_abd_chg_ind);
        builder.append(", living_argmt_chg_ind=");
        builder.append(	living_argmt_chg_ind);
        builder.append(", other_program_chg_ind=");
        builder.append(	other_program_chg_ind);
	    builder.append(", magi_expense_chg_ind=");
        builder.append( magi_expense_chg_ind);
        builder.append(", tax_info_ind=");
        builder.append(	tax_info_ind);
        builder.append(", tax_dep_outside_resp=");
        builder.append(	tax_dep_outside_resp);
        builder.append(", medicare_part_a=");
        builder.append(medicare_part_a);
        builder.append(", medicare_part_b=");
        builder.append(medicare_part_b);
        builder.append(", medicare_part_c=");
        builder.append(medicare_part_c);
        builder.append(", medicare_part_d=");
        builder.append(medicare_part_d);
        builder.append(", cssp_provider_payment=");
        builder.append(cssp_provider_payment);
        builder.append(", animals_to_assist_disabled=");
        builder.append(animals_to_assist_disabled);
        builder.append(", funeral_death_expense=");
        builder.append(funeral_death_expense);
        builder.append(", blind_work_expense=");
        builder.append(blind_work_expense);
        builder.append(", impairment_work_expense=");
        builder.append(impairment_work_expense);    
        builder.append(", oth_ind_gambl_pmnts=");
        builder.append(oth_ind_gambl_pmnts);
        builder.append(", income_from_resource=");
        builder.append(income_from_resource);
        builder.append(", indian_gambling_payments=");
        builder.append(indian_gambling_payments);
        builder.append(", inheritance=");
        builder.append(inheritance);
        builder.append(", insuance_benefits=");
        builder.append(insuance_benefits);
        builder.append(", loan_received=");
        builder.append(loan_received);
        builder.append(", loan_repayment_income=");
        builder.append(loan_repayment_income);
        builder.append(", managed_income=");
        builder.append(managed_income);
        builder.append(", match_grant=");
        builder.append(match_grant);
        builder.append(", montgomery_gi_bill=");
        builder.append(montgomery_gi_bill);
        builder.append(", out_of_state_public=");
        builder.append(out_of_state_public);
        builder.append(", refunds_from_dch=");
        builder.append(refunds_from_dch);
        builder.append(", restitutions_settlements=");
        builder.append(restitutions_settlements);
        builder.append(", senior_companion=");
        builder.append(senior_companion);
        builder.append(", severance_pay=");
        builder.append(severance_pay);
        builder.append(", strike_benefits=");
        builder.append(strike_benefits);
        builder.append(", trade_readjustment=");
        builder.append(trade_readjustment);
        builder.append(", uniform_relocation=");
        builder.append(uniform_relocation);
        builder.append(", union_funds=");
        builder.append(union_funds);
        builder.append(", vendor_excluded=");
        builder.append(vendor_excluded);
        builder.append(", victim_restitution=");
        builder.append(victim_restitution);
        builder.append(", volunteer_payment=");
        builder.append(volunteer_payment);
        builder.append(", volunteer_payment_titlei=");
        builder.append(volunteer_payment_titlei);
        builder.append(", wia_training_and_allowance=");
        builder.append(wia_training_and_allowance);
        builder.append(", included_unearned_income=");
        builder.append(included_unearned_income);
        builder.append(", tanf_max_au_allotment=");
        builder.append(tanf_max_au_allotment);
        builder.append(", tanf_max_grg_allotment=");
        builder.append(tanf_max_grg_allotment);
        builder.append(", charitable_donation=");
        builder.append(charitable_donation);
        builder.append(", child_nutrition_payments=");
        builder.append(child_nutrition_payments);
        builder.append(", black_lung_benefits=");
        builder.append(black_lung_benefits);
        builder.append(", child_support_court=");
        builder.append(child_support_court);
        builder.append(", child_support_gap_payment=");
        builder.append(child_support_gap_payment);
        builder.append(", civil_service=");
        builder.append(civil_service);
        builder.append(", deferred_compensation_plans=");
        builder.append(deferred_compensation_plans);
        builder.append(", disability_insurance=");
        builder.append(disability_insurance);
        builder.append(", excluded_unearned_income=");
        builder.append(excluded_unearned_income);
        builder.append(", fema_payment_disaster=");
        builder.append(fema_payment_disaster);
        builder.append(", fema_payment_non_disaster=");
        builder.append(fema_payment_non_disaster);
        builder.append(", health_savings_account=");
        builder.append(health_savings_account);
        builder.append(", in_kind_support=");
        builder.append(in_kind_support);
        builder.append(", foster_grandparent_program=");
        builder.append(foster_grandparent_program);
        builder.append(", disaster_unemployment=");
        builder.append(disaster_unemployment);
        builder.append(", dividends=");
        builder.append(dividends);
        builder.append(", charitable_donation_federal=");
        builder.append(charitable_donation_federal);         
        builder.append(", bonds=");
        builder.append(bonds);     
        builder.append(", dividend=");
        builder.append(dividend); 
        builder.append(", health_reimbursement_account=");
        builder.append(health_reimbursement_account); 
        builder.append(", individual_development_account=");
        builder.append(individual_development_account); 
        builder.append(", uniform_gifts_to_minors=");
        builder.append(uniform_gifts_to_minors); 
        builder.append(", inheritance_income=");
        builder.append(inheritance_income);
        builder.append(", personal_info=");
        builder.append(personal_info);
        builder.append(", patient_fund=");
        builder.append(patient_fund);       
        builder.append(", disaster_assistance=");
        builder.append(disaster_assistance);
        builder.append(", non_business_equipment=");
        builder.append(non_business_equipment);
        builder.append(", household_goods=");
        builder.append(household_goods);
        builder.append(", other_non_countable=");
        builder.append(other_non_countable);
        builder.append(", schl_enrl_chg_ind=");
        builder.append(schl_enrl_chg_ind);
        builder.append(", mrtl_stat_chg_ind=");
        builder.append(mrtl_stat_chg_ind);
        builder.append(", nur_hme_chg_ind=");
        builder.append(nur_hme_chg_ind);
        builder.append(", bfr_tax_chg_ind=");
        builder.append(bfr_tax_chg_ind);
        builder.append(", inc_tax_chg_ind=");
        builder.append(inc_tax_chg_ind);
        builder.append(", thrd_prty_chg_ind=");
        builder.append(thrd_prty_chg_ind);
        builder.append(", death_benefit_state_federal=");
        builder.append(death_benefit_state_federal);
        builder.append(", social_security_survivor=");
        builder.append(social_security_survivor);
        builder.append(", vendor_payments=");
        builder.append(vendor_payments);
        builder.append(", citizenship_chg_ind=");
        builder.append(citizenship_chg_ind);
        builder.append(", demographics_chg_ind=");
        builder.append(demographics_chg_ind);
        builder.append(", alien_chg_ind=");
        builder.append(alien_chg_ind);
        builder.append(", util_bill_chg_Ind=");
        builder.append(util_bill_chg_Ind);
        builder.append(", citizenship_info=");
        builder.append(citizenship_info);
        builder.append(", indv_prgm_chg_ind=");
        builder.append(indv_prgm_chg_ind);
        builder.append(", empl_hlth_ins_resp=");
        builder.append(empl_hlth_ins_resp);
        builder.append(", avd_prsctn_fstf=");
        builder.append(avd_prsctn_fstf);
        builder.append(", cntrl_subs_resp=");
        builder.append(cntrl_subs_resp);
        builder.append(", heat_cool_src=");
        builder.append(heat_cool_src);
        builder.append("]");
        return builder.toString();
    
	    
	}

	/* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
		final StringBuilder builder = new StringBuilder();
        builder.append("RMC_IN_PRFL_Cargo [isDirty=");
        builder.append(isDirty);
        builder.append(", app_num=");
        builder.append(app_num);
        builder.append(", indv_seq_num=");
        builder.append(indv_seq_num);
        builder.append(", acdt_resp=");
        builder.append(acdt_resp);
        builder.append(", adpt_asst_resp=");
        builder.append(adpt_asst_resp);
        builder.append(", almy_rcv_resp=");
        builder.append(almy_rcv_resp);
        builder.append(", bnft_anty_resp=");
        builder.append(bnft_anty_resp);
        builder.append(", bnft_chl_sprt_resp=");
        builder.append(bnft_chl_sprt_resp);
        builder.append(", bnft_chrt_resp=");
        builder.append(bnft_chrt_resp);
        builder.append(", bnft_dabl_resp=");
        builder.append(bnft_dabl_resp);
        builder.append(", bnft_divnd_resp=");
        builder.append(bnft_divnd_resp);
        builder.append(", bnft_est_trst_resp=");
        builder.append(bnft_est_trst_resp);
        builder.append(", bnft_rr_resp=");
        builder.append(bnft_rr_resp);
        builder.append(", bnft_uempl_resp=");
        builder.append(bnft_uempl_resp);
        builder.append(", bnft_vet_resp=");
        builder.append(bnft_vet_resp);
        builder.append(", chld_sprt_pay_resp=");
        builder.append(chld_sprt_pay_resp);
        builder.append(", dabl_resp=");
        builder.append(dabl_resp);
        builder.append(", dpnd_care_resp=");
        builder.append(dpnd_care_resp);
        builder.append(", drug_feln_resp=");
        builder.append(drug_feln_resp);
        builder.append(", educ_aid_resp=");
        builder.append(educ_aid_resp);
        builder.append(", empl_resp=");
        builder.append(empl_resp);
        builder.append(", fset_sctn_resp=");
        builder.append(fset_sctn_resp);
        builder.append(", fstr_care_resp=");
        builder.append(fstr_care_resp);
        builder.append(", gen_rlf_resp=");
        builder.append(gen_rlf_resp);
        builder.append(", hc_cvrg_resp=");
        builder.append(hc_cvrg_resp);
        builder.append(", incm_int_resp=");
        builder.append(incm_int_resp);
        builder.append(", irwe_resp=");
        builder.append(irwe_resp);
        builder.append(", job_iknd_resp=");
        builder.append(job_iknd_resp);
        builder.append(", kinship_care_resp=");
        builder.append(kinship_care_resp);
        builder.append(", med_exp_resp=");
        builder.append(med_exp_resp);
        builder.append(", mil_allot_resp=");
        builder.append(mil_allot_resp);
        builder.append(", mony_othr_resp=");
        builder.append(mony_othr_resp);
        builder.append(", natl_rfge_resp=");
        builder.append(natl_rfge_resp);
        builder.append(", need_ind_resp=");
        builder.append(need_ind_resp);
        builder.append(", on_strk_sw=");
        builder.append(on_strk_sw);
        builder.append(", op_aoda_tmt_rcv_sw=");
        builder.append(op_aoda_tmt_rcv_sw);
        builder.append(", othr_incm_resp=");
        builder.append(othr_incm_resp);
        builder.append(", othr_src_resp=");
        builder.append(othr_src_resp);
        builder.append(", own_aset_resp=");
        builder.append(own_aset_resp);
        builder.append(", pay_hous_bill_resp=");
        builder.append(pay_hous_bill_resp);
        builder.append(", pay_rmr_brd_resp=");
        builder.append(pay_rmr_brd_resp);
        builder.append(", pnsn_retr_resp=");
        builder.append(pnsn_retr_resp);
        builder.append(", preg_resp=");
        builder.append(preg_resp);
        builder.append(", prop_sold_resp=");
        builder.append(prop_sold_resp);
        builder.append(", pub_asst_resp=");
        builder.append(pub_asst_resp);
        builder.append(", rcv_fs_oth_st_resp=");
        builder.append(rcv_fs_oth_st_resp);
        builder.append(", rcv_hous_asst_resp=");
        builder.append(rcv_hous_asst_resp);
        builder.append(", rcv_medcr_resp=");
        builder.append(rcv_medcr_resp);
        builder.append(", rcv_ss_resp=");
        builder.append(rcv_ss_resp);
        builder.append(", rcv_ssi_ltr_resp=");
        builder.append(rcv_ssi_ltr_resp);
        builder.append(", rcv_ssi_sw=");
        builder.append(rcv_ssi_sw);
        builder.append(", rmr_brd_incm_resp=");
        builder.append(rmr_brd_incm_resp);
        builder.append(", self_empl_resp=");
        builder.append(self_empl_resp);
        builder.append(", ssi_dcond_resp=");
        builder.append(ssi_dcond_resp);
        builder.append(", ssi_1619b_rcv_sw=");
        builder.append(ssi_1619b_rcv_sw);
        builder.append(", su_ases_resp=");
        builder.append(su_ases_resp);
        builder.append(", su_cst_coal_resp=");
        builder.append(su_cst_coal_resp);
        builder.append(", su_cst_elec_resp=");
        builder.append(su_cst_elec_resp);
        builder.append(", su_cst_fuel_resp=");
        builder.append(su_cst_fuel_resp);
        builder.append(", su_cst_gas_resp=");
        builder.append(su_cst_gas_resp);
        builder.append(", su_cst_home_resp=");
        builder.append(su_cst_home_resp);
        builder.append(", su_cst_istl_resp=");
        builder.append(su_cst_istl_resp);
        builder.append(", su_cst_lpgas_resp=");
        builder.append(su_cst_lpgas_resp);
        builder.append(", su_cst_mbl_resp=");
        builder.append(su_cst_mbl_resp);
        builder.append(", su_cst_mtge_resp=");
        builder.append(su_cst_mtge_resp);
        builder.append(", su_cst_othr_resp=");
        builder.append(su_cst_othr_resp);
        builder.append(", su_cst_phn_resp=");
        builder.append(su_cst_phn_resp);
        builder.append(", su_cst_rent_resp=");
        builder.append(su_cst_rent_resp);
        builder.append(", su_cst_swr_resp=");
        builder.append(su_cst_swr_resp);
        builder.append(", su_cst_tax_resp=");
        builder.append(su_cst_tax_resp);
        builder.append(", su_cst_trsh_resp=");
        builder.append(su_cst_trsh_resp);
        builder.append(", su_cst_wood_resp=");
        builder.append(su_cst_wood_resp);
        builder.append(", su_cst_wtr_resp=");
        builder.append(su_cst_wtr_resp);
        builder.append(", su_cst_wwt_resp=");
        builder.append(su_cst_wwt_resp);
        builder.append(", trb_cpta_resp=");
        builder.append(trb_cpta_resp);
        builder.append(", trb_tanf_resp=");
        builder.append(trb_tanf_resp);
        builder.append(", updt_dt=");
        builder.append(updt_dt);
        builder.append(", util_exp_resp=");
        builder.append(util_exp_resp);
        builder.append(", wheap_resp=");
        builder.append(wheap_resp);
        builder.append(", work_comp_resp=");
        builder.append(work_comp_resp);
        builder.append(", yehoc_resp=");
        builder.append(yehoc_resp);
        builder.append(", resettl_inc_resp=");
        builder.append(resettl_inc_resp);
        builder.append(", none_resp=");
        builder.append(none_resp);
        builder.append(", land_cont_resp=");
        builder.append(land_cont_resp);
        builder.append(", refused_job_lst_30_resp=");
        builder.append(refused_job_lst_30_resp);
        builder.append(", child_support_arr_resp=");
        builder.append(child_support_arr_resp);
        builder.append(", unocc_home_exp_resp=");
        builder.append(unocc_home_exp_resp);
        builder.append(", tribal_food_dist_resp=");
        builder.append(tribal_food_dist_resp);
        builder.append(", child_adult_care_resp=");
        builder.append(child_adult_care_resp);
        builder.append(", mi_heating_cred_resp=");
        builder.append(mi_heating_cred_resp);
        builder.append(", mortg_guar_ins_resp=");
        builder.append(mortg_guar_ins_resp);
        builder.append(", coop_condo_fee_resp=");
        builder.append(coop_condo_fee_resp);
        builder.append(", other_resp=");
        builder.append(other_resp);
        builder.append(", water_well_resp=");
        builder.append(water_well_resp);
        builder.append(", cooking_fuel_resp=");
        builder.append(cooking_fuel_resp);
        builder.append(", water_well_maint_resp=");
        builder.append(water_well_maint_resp);
        builder.append(", heating_resp=");
        builder.append(heating_resp);
        builder.append(", cooling_resp=");
        builder.append(cooling_resp);
        builder.append(", septic_sewer_resp=");
        builder.append(septic_sewer_resp);
        builder.append(", home_equity_resp=");
        builder.append(home_equity_resp);
        builder.append(", second_mortgag_resp=");
        builder.append(second_mortgag_resp);
        builder.append(", othr_incm_rentl_resp=");
        builder.append(othr_incm_rentl_resp);
        builder.append(", cp_wlst_resp=");
        builder.append(cp_wlst_resp);
        builder.append(", indv_cla_ind=");
        builder.append(indv_cla_ind);
        builder.append(", past_hc_cvrg_resp=");
        builder.append(past_hc_cvrg_resp);
        builder.append(", trb_cmdy_resp=");
        builder.append(trb_cmdy_resp);
        builder.append(", bury_aset_c_resp=");
        builder.append(bury_aset_c_resp);
        builder.append(", bury_aset_ibt_resp=");
        builder.append(bury_aset_ibt_resp);
        builder.append(", bury_aset_ins_resp=");
        builder.append(bury_aset_ins_resp);
        builder.append(", bury_aset_mas_resp=");
        builder.append(bury_aset_mas_resp);
        builder.append(", bury_aset_oth_resp=");
        builder.append(bury_aset_oth_resp);
        builder.append(", bury_aset_plt_resp=");
        builder.append(bury_aset_plt_resp);
        builder.append(", bury_aset_rbt_resp=");
        builder.append(bury_aset_rbt_resp);
        builder.append(", bury_aset_v_resp=");
        builder.append(bury_aset_v_resp);
        builder.append(", li_aset_g_l_resp=");
        builder.append(li_aset_g_l_resp);
        builder.append(", li_aset_g_t_resp=");
        builder.append(li_aset_g_t_resp);
        builder.append(", li_aset_trm_resp=");
        builder.append(li_aset_trm_resp);
        builder.append(", li_aset_unv_resp=");
        builder.append(li_aset_unv_resp);
        builder.append(", li_aset_w_l_resp=");
        builder.append(li_aset_w_l_resp);
        builder.append(", lqd_aset_c_a_resp=");
        builder.append(lqd_aset_c_a_resp);
        builder.append(", lqd_aset_eb_a_resp=");
        builder.append(lqd_aset_eb_a_resp);
        builder.append(", lqd_aset_h_s_resp=");
        builder.append(lqd_aset_h_s_resp);
        builder.append(", lqd_aset_ira_resp=");
        builder.append(lqd_aset_ira_resp);
        builder.append(", lqd_aset_k_p_resp=");
        builder.append(lqd_aset_k_p_resp);
        builder.append(", lqd_aset_m_o_resp=");
        builder.append(lqd_aset_m_o_resp);
        builder.append(", lqd_aset_mm_a_resp=");
        builder.append(lqd_aset_mm_a_resp);
        builder.append(", lqd_aset_o_t_resp=");
        builder.append(lqd_aset_o_t_resp);
        builder.append(", lqd_aset_othr_resp=");
        builder.append(lqd_aset_othr_resp);
        builder.append(", lqd_aset_s_a_resp=");
        builder.append(lqd_aset_s_a_resp);
        builder.append(", lqd_aset_s_c_resp=");
        builder.append(lqd_aset_s_c_resp);
        builder.append(", lqd_aset_st_b_resp=");
        builder.append(lqd_aset_st_b_resp);
        builder.append(", lqd_aset_tr_f_resp=");
        builder.append(lqd_aset_tr_f_resp);
        builder.append(", lqd_aset_us_b_resp=");
        builder.append(lqd_aset_us_b_resp);
        builder.append(", other_asset_burial_resp=");
        builder.append(other_asset_burial_resp);
        builder.append(", other_aset_life_insurance_resp=");
        builder.append(other_aset_life_insurance_resp);
        builder.append(", other_asset_personal_prop_resp=");
        builder.append(other_asset_personal_prop_resp);
        builder.append(", other_asset_real_property_resp=");
        builder.append(other_asset_real_property_resp);
        builder.append(", other_asset_vehicle_resp=");
        builder.append(other_asset_vehicle_resp);
        builder.append(", real_aset_apt_resp=");
        builder.append(real_aset_apt_resp);
        builder.append(", real_aset_com_resp=");
        builder.append(real_aset_com_resp);
        builder.append(", real_aset_con_resp=");
        builder.append(real_aset_con_resp);
        builder.append(", real_aset_dup_resp=");
        builder.append(real_aset_dup_resp);
        builder.append(", real_aset_frm_resp=");
        builder.append(real_aset_frm_resp);
        builder.append(", real_aset_hse_resp=");
        builder.append(real_aset_hse_resp);
        builder.append(", real_aset_lnd_resp=");
        builder.append(real_aset_lnd_resp);
        builder.append(", real_aset_m_h_resp=");
        builder.append(real_aset_m_h_resp);
        builder.append(", real_aset_oth_resp=");
        builder.append(real_aset_oth_resp);
        builder.append(", veh_aset_auto_resp=");
        builder.append(veh_aset_auto_resp);
        builder.append(", veh_aset_boat_resp=");
        builder.append(veh_aset_boat_resp);
        builder.append(", veh_aset_camp_resp=");
        builder.append(veh_aset_camp_resp);
        builder.append(", veh_aset_mcyc_resp=");
        builder.append(veh_aset_mcyc_resp);
        builder.append(", veh_aset_anml_resp=");
        builder.append(veh_aset_anml_resp);
        builder.append(", veh_aset_arpl_resp=");
        builder.append(veh_aset_arpl_resp);
        builder.append(", veh_aset_bus_resp=");
        builder.append(veh_aset_bus_resp);
        builder.append(", veh_aset_fimp_resp=");
        builder.append(veh_aset_fimp_resp);
        builder.append(", veh_aset_fmeq_resp=");
        builder.append(veh_aset_fmeq_resp);
        builder.append(", veh_aset_ftrc_resp=");
        builder.append(veh_aset_ftrc_resp);
        builder.append(", veh_aset_ftrl_resp=");
        builder.append(veh_aset_ftrl_resp);
        builder.append(", veh_aset_lskd_resp=");
        builder.append(veh_aset_lskd_resp);
        builder.append(", veh_aset_mped_resp=");
        builder.append(veh_aset_mped_resp);
        builder.append(", veh_aset_nm_b_resp=");
        builder.append(veh_aset_nm_b_resp);
        builder.append(", veh_aset_othr_resp=");
        builder.append(veh_aset_othr_resp);
        builder.append(", veh_aset_rv_resp=");
        builder.append(veh_aset_rv_resp);
        builder.append(", veh_aset_s_mb_resp=");
        builder.append(veh_aset_s_mb_resp);
        builder.append(", veh_aset_trk_resp=");
        builder.append(veh_aset_trk_resp);
        builder.append(", veh_aset_trlr_resp=");
        builder.append(veh_aset_trlr_resp);
        builder.append(", veh_aset_van_resp=");
        builder.append(veh_aset_van_resp);
        builder.append(", bnft_mapp_resp=");
        builder.append(bnft_mapp_resp);
        builder.append(", school_enrollment_resp=");
        builder.append(school_enrollment_resp);
        builder.append(", hospital_stay_resp=");
        builder.append(hospital_stay_resp);
        builder.append(", head_of_household_resp=");
        builder.append(head_of_household_resp);
        builder.append(", medical_service_resp=");
        builder.append(medical_service_resp);
        builder.append(", emergency_medical_service_resp=");
        builder.append(emergency_medical_service_resp);
        builder.append(", parole_violation_resp=");
        builder.append(parole_violation_resp);
        builder.append(", room_board_resp=");
        builder.append(room_board_resp);
        builder.append(", current_past_job_resp=");
        builder.append(current_past_job_resp);
        builder.append(", moved_into_home_response=");
        builder.append(moved_into_home_response);
        builder.append(", moved_out_of_home_resp=");
        builder.append(moved_out_of_home_resp);
        builder.append(", liquid_asset_bank_acc_resp=");
        builder.append(liquid_asset_bank_acc_resp);
        builder.append(", other_asset_transfer_resp=");
        builder.append(other_asset_transfer_resp);
        builder.append(", liquid_aset_disable_blind_resp=");
        builder.append(liquid_aset_disable_blind_resp);
        builder.append(", liquid_asset_ira_resp=");
        builder.append(liquid_asset_ira_resp);
        builder.append(", liquid_asset_irs_retirmnt_resp=");
        builder.append(liquid_asset_irs_retirmnt_resp);
        builder.append(", liquid_asset_savings_acc_resp=");
        builder.append(liquid_asset_savings_acc_resp);
        builder.append(", liquid_asset_pension_plan_resp=");
        builder.append(liquid_asset_pension_plan_resp);
        builder.append(", liquid_asset_promissory_resp=");
        builder.append(liquid_asset_promissory_resp);
        builder.append(", liquid_asset_retirement_resp=");
        builder.append(liquid_asset_retirement_resp);
        builder.append(", liquid_asset_stocks_bonds_resp=");
        builder.append(liquid_asset_stocks_bonds_resp);
        builder.append(", liquid_asset_trust_fund_resp=");
        builder.append(liquid_asset_trust_fund_resp);
        builder.append(", liquid_asset_other_response=");
        builder.append(liquid_asset_other_response);
        builder.append(", liquid_asset_other_type_resp=");
        builder.append(liquid_asset_other_type_resp);
        builder.append(", liquid_asset_cash_resp=");
        builder.append(liquid_asset_cash_resp);
        builder.append(", indv_wic_rqst_ind=");
        builder.append(indv_wic_rqst_ind);
        builder.append(", indv_tanf_rqst_ind=");
        builder.append(indv_tanf_rqst_ind);
        builder.append(", indv_cc_rqst_ind=");
        builder.append(indv_cc_rqst_ind);
        builder.append(", indv_fma_rqst_ind=");
        builder.append(indv_fma_rqst_ind);
        builder.append(", indv_fs_rqst_ind=");
        builder.append(indv_fs_rqst_ind);
        builder.append(", indv_fpw_rqst_ind=");
        builder.append(indv_fpw_rqst_ind);
        builder.append(", tanf_ind=");
        builder.append(tanf_ind);
        builder.append(", life_ins_asset_whole_life_resp=");
        builder.append(life_ins_asset_whole_life_resp);
        builder.append(", life_insurance_asset_term_resp=");
        builder.append(life_insurance_asset_term_resp);
        builder.append(", life_ins_asest_group_life_resp=");
        builder.append(life_ins_asest_group_life_resp);
        builder.append(", life_ins_asset_group_term_resp=");
        builder.append(life_ins_asset_group_term_resp);
        builder.append(", life_ins_asset_universal_resp=");
        builder.append(life_ins_asset_universal_resp);
        builder.append(", life_insurance_other_resp=");
        builder.append(life_insurance_other_resp);
        builder.append(", real_asset_land_resp=");
        builder.append(real_asset_land_resp);
        builder.append(", real_asset_mobile_home_resp=");
        builder.append(real_asset_mobile_home_resp);
        builder.append(", real_asset_other_resp=");
        builder.append(real_asset_other_resp);
        builder.append(", real_asset_life_estate_resp=");
        builder.append(real_asset_life_estate_resp);
        builder.append(", real_asset_house_resp=");
        builder.append(real_asset_house_resp);
        builder.append(", real_asset_unoccupy_home_resp=");
        builder.append(real_asset_unoccupy_home_resp);
        builder.append(", real_asset_home_resp=");
        builder.append(real_asset_home_resp);
        builder.append(", vehicle_asset_auto_resp=");
        builder.append(vehicle_asset_auto_resp);
        builder.append(", vehicle_asset_boat_resp=");
        builder.append(vehicle_asset_boat_resp);
        builder.append(", vehicle_asset_motorcycle_resp=");
        builder.append(vehicle_asset_motorcycle_resp);
        builder.append(", vehicle_asset_other_resp=");
        builder.append(vehicle_asset_other_resp);
        builder.append(", vehicle_asset_recreation_resp=");
        builder.append(vehicle_asset_recreation_resp);
        builder.append(", vehicle_asset_animal_drwn_resp=");
        builder.append(vehicle_asset_animal_drwn_resp);
        builder.append(", vehicle_asset_tractor_resp=");
        builder.append(vehicle_asset_tractor_resp);
        builder.append(", vehicle_asset_golf_cart_resp=");
        builder.append(vehicle_asset_golf_cart_resp);
        builder.append(", vehicle_asset_nmot_camper_resp=");
        builder.append(vehicle_asset_nmot_camper_resp);
        builder.append(", vehicle_asset_camper_resp=");
        builder.append(vehicle_asset_camper_resp);
        builder.append(", training_allowance_resp=");
        builder.append(training_allowance_resp);
        builder.append(", inheritance_resp=");
        builder.append(inheritance_resp);
        builder.append(", student_financial_aid_resp=");
        builder.append(student_financial_aid_resp);
        builder.append(", food_clothing_util_rent_resp=");
        builder.append(food_clothing_util_rent_resp);
        builder.append(", cash_gifts_resp=");
        builder.append(cash_gifts_resp);
        builder.append(", loan_resp=");
        builder.append(loan_resp);
        builder.append(", benefit_black_lung_resp=");
        builder.append(benefit_black_lung_resp);
        builder.append(", lottery_prize_winning_resp=");
        builder.append(lottery_prize_winning_resp);
        builder.append(", insurance_settlement_resp=");
        builder.append(insurance_settlement_resp);
        builder.append(", othr_social_security_bnft_resp=");
        builder.append(othr_social_security_bnft_resp);
        builder.append(", benefits_on_strike_resp=");
        builder.append(benefits_on_strike_resp);
        builder.append(", work_related_expense_resp=");
        builder.append(work_related_expense_resp);
        builder.append(", med_type_prosthetic_resp=");
        builder.append(med_type_prosthetic_resp);
        builder.append(", med_type_atndnt_meal_resp=");
        builder.append(med_type_atndnt_meal_resp);
        builder.append(", med_type_animal_resp=");
        builder.append(med_type_animal_resp);
        builder.append(", med_type_maintain_attndnt_resp=");
        builder.append(med_type_maintain_attndnt_resp);
        builder.append(", med_type_inhome_resp=");
        builder.append(med_type_inhome_resp);
        builder.append(", med_type_special_equip_resp=");
        builder.append(med_type_special_equip_resp);
        builder.append(", med_type_eyeglasses_resp=");
        builder.append(med_type_eyeglasses_resp);
        builder.append(", med_type_insurance_resp=");
        builder.append(med_type_insurance_resp);
        builder.append(", med_type_bills_resp=");
        builder.append(med_type_bills_resp);
        builder.append(", med_type_supplies_resp=");
        builder.append(med_type_supplies_resp);
        builder.append(", med_type_nursing_resp=");
        builder.append(med_type_nursing_resp);
        builder.append(", med_type_other_resp=");
        builder.append(med_type_other_resp);
        builder.append(", med_type_out_patient_resp=");
        builder.append(med_type_out_patient_resp);
        builder.append(", med_type_psychotherapy_resp=");
        builder.append(med_type_psychotherapy_resp);
        builder.append(", med_type_prescribed_drug_resp=");
        builder.append(med_type_prescribed_drug_resp);
        builder.append(", med_type_transportation_resp=");
        builder.append(med_type_transportation_resp);
        builder.append(", utility_standard_resp=");
        builder.append(utility_standard_resp);
        builder.append(", other_incm_contrib_resp=");
        builder.append(other_incm_contrib_resp);
        builder.append(", child_care_resp=");
        builder.append(child_care_resp);
        builder.append(", child_obligation_resp=");
        builder.append(child_obligation_resp);
        builder.append(", medical_bills_resp=");
        builder.append(medical_bills_resp);
        builder.append(", medtyp_dental=");
        builder.append(medtyp_dental);
        builder.append(", medtyp_attendant_care=");
        builder.append(medtyp_attendant_care);
        builder.append(", medtyp_doctor=");
        builder.append(medtyp_doctor);
        builder.append(", medtyp_med_equip=");
        builder.append(medtyp_med_equip);
        builder.append(", medtyp_hosp_bills=");
        builder.append(medtyp_hosp_bills);
        builder.append(", medtyp_insur_premium=");
        builder.append(medtyp_insur_premium);
        builder.append(", medtyp_rx_cost=");
        builder.append(medtyp_rx_cost);
        builder.append(", medtyp_trans_med=");
        builder.append(medtyp_trans_med);
        builder.append(", medtyp_other=");
        builder.append(medtyp_other);
        builder.append(", hospice_resp=");
        builder.append(hospice_resp);
        builder.append(", outstate_bnft_resp=");
        builder.append(outstate_bnft_resp);
        builder.append(", unpaid_medbill=");
        builder.append(unpaid_medbill);
        builder.append(", veh_aset_unlic_resp=");
        builder.append(veh_aset_unlic_resp);
        builder.append(", real_asset_rental_resp=");
        builder.append(real_asset_rental_resp);
        builder.append(", real_aset_vac_resp=");
        builder.append(real_aset_vac_resp);
        builder.append(", special_need_resp=");
        builder.append(special_need_resp);
        builder.append(", foster_care_resp=");
        builder.append(foster_care_resp);
        builder.append(", former_foster_resp=");
        builder.append(former_foster_resp);
        builder.append(", child_protective_resp=");
        builder.append(child_protective_resp);
        builder.append(", living_prog_resp=");
        builder.append(living_prog_resp);
        builder.append(", grand_parent_resp=");
        builder.append(grand_parent_resp);
        builder.append(", drug_felonies_resp=");
        builder.append(drug_felonies_resp);
        builder.append(", snap_tanf_disc_resp=");
        builder.append(snap_tanf_disc_resp);
        builder.append(", avoid_prosc_resp=");
        builder.append(avoid_prosc_resp);
        builder.append(", violating_parole_resp=");
        builder.append(violating_parole_resp);
        builder.append(", convic_false_info_resp=");
        builder.append(convic_false_info_resp);
        builder.append(", voluntarily_quit_job_resp=");
        builder.append(voluntarily_quit_job_resp);
        builder.append(", trading_snap_resp=");
        builder.append(trading_snap_resp);
        builder.append(", buy_sell_snap_resp=");
        builder.append(buy_sell_snap_resp);
        builder.append(", trade_snap_gun_resp=");
        builder.append(trade_snap_gun_resp);
        builder.append(", prev_ssi_resp=");
        builder.append(prev_ssi_resp);
        builder.append(", home_community_resp=");
        builder.append(home_community_resp);
        builder.append(", tribal_health_resp=");
        builder.append(tribal_health_resp);
        builder.append(", tribal_eligibility_resp=");
        builder.append(tribal_eligibility_resp);
        builder.append(", domestic_violence_resp=");
        builder.append(domestic_violence_resp);
        builder.append(", tanf_eppic_resp=");
        builder.append(tanf_eppic_resp);
        builder.append(", emergency_medical_resp=");
        builder.append(emergency_medical_resp);
        builder.append(", adoptAssistance=");
        builder.append(adoptAssistance);
        builder.append(", adoptionPayments=");
        builder.append(adoptionPayments);
        builder.append(", agentOrangePayments=");
        builder.append(agentOrangePayments);
        builder.append(", alimony=");
        builder.append(alimony);
        builder.append(", capitalGains=");
        builder.append(capitalGains);
        builder.append(", deathBenefits=");
        builder.append(deathBenefits);
        builder.append(", disabilityIncome=");
        builder.append(disabilityIncome);
        builder.append(", disasterRelief=");
        builder.append(disasterRelief);
        builder.append(", educationalAssistance=");
        builder.append(educationalAssistance);
        builder.append(", energyAssistance=");
        builder.append(energyAssistance);
        builder.append(", farmAllotment=");
        builder.append(farmAllotment);
        builder.append(", fosterCarePayments=");
        builder.append(fosterCarePayments);
        builder.append(", generalAssistance=");
        builder.append(generalAssistance);
        builder.append(", interestDividendPayments=");
        builder.append(interestDividendPayments);
        builder.append(", iRADistribution=");
        builder.append(iRADistribution);
        builder.append(", lotteryWinnings=");
        builder.append(lotteryWinnings);
        builder.append(", lumpSum=");
        builder.append(lumpSum);
        builder.append(", militaryAllotment=");
        builder.append(militaryAllotment);
        builder.append(", moneyFromAnotherPerson=");
        builder.append(moneyFromAnotherPerson);
        builder.append(", netRentalRoyalty=");
        builder.append(netRentalRoyalty);
        builder.append(", otherIncome=");
        builder.append(otherIncome);
        builder.append(", paymentsFromAnnuity=");
        builder.append(paymentsFromAnnuity);
        builder.append(", paymentsMadeOnYourBehalf=");
        builder.append(paymentsMadeOnYourBehalf);
        builder.append(", pensionOrRetirement=");
        builder.append(pensionOrRetirement);
        builder.append(", railroadRetirement=");
        builder.append(railroadRetirement);
        builder.append(", refugeeCash=");
        builder.append(refugeeCash);
        builder.append(", relativeCareSubsidy=");
        builder.append(relativeCareSubsidy);
        builder.append(", rentalIncome=");
        builder.append(rentalIncome);
        builder.append(", tANFPayments=");
        builder.append(tANFPayments);
        builder.append(", unemploymentCompensation=");
        builder.append(unemploymentCompensation);
        builder.append(", workStudyStateFederal=");
        builder.append(workStudyStateFederal);
        builder.append(", workersCompensation=");
        builder.append(workersCompensation);
        builder.append(", medtyp_hsa_contrib=");
        builder.append(medtyp_hsa_contrib);
        builder.append(", pers_prop_bus_eqpt=");
        builder.append(pers_prop_bus_eqpt);
        builder.append(", pers_prop_cemetary_lot=");
        builder.append(pers_prop_cemetary_lot);
        builder.append(", pers_prop_livestock=");
        builder.append(pers_prop_livestock);
        builder.append(", pers_prop_saf_depst_box=");
        builder.append(pers_prop_saf_depst_box);
        builder.append(", pers_prop_oth_val=");
        builder.append(pers_prop_oth_val);
        builder.append(", able_to_conceive_resp=");
        builder.append(able_to_conceive_resp);
        builder.append(", underweight_birth_resp=");
        builder.append(underweight_birth_resp);
        builder.append(", preg_add_stat_sw=");
        builder.append(preg_add_stat_sw);
        builder.append(", preg_chg_stat_sw=");
        builder.append(preg_chg_stat_sw);
        builder.append(", prsn_info_stat_sw=");
        builder.append(prsn_info_stat_sw);
        builder.append(", rlt_chg_stat_sw=");
        builder.append(rlt_chg_stat_sw);
        builder.append(", prevent_eviction_resp=");
        builder.append(prevent_eviction_resp);
        builder.append(", disaster_repair_resp=");
        builder.append(disaster_repair_resp);
        builder.append(", other_housing_bill_resp=");
        builder.append(other_housing_bill_resp);
        builder.append(", su_cst_ins_resp=");
        builder.append(su_cst_ins_resp);
        builder.append(", careTaker_resp=");
        builder.append(careTaker_resp);
        builder.append(", othr_incm_trbl_resp=");
        builder.append(othr_incm_trbl_resp);
        builder.append(", lost_health_ins_ind=");
        builder.append(lost_health_ins_ind);
        builder.append(", tax_claim_dependant_resp=");
        builder.append(tax_claim_dependant_resp);
        builder.append(", before_tax_deduction_resp=");
        builder.append(before_tax_deduction_resp);
        builder.append(", btd_med_ins=");
        builder.append(btd_med_ins);
        builder.append(", btd_dent_ins=");
        builder.append(btd_dent_ins);
        builder.append(", btd_vis_care_ins=");
        builder.append(btd_vis_care_ins);
        builder.append(", btd_flex_acc=");
        builder.append(btd_flex_acc);
        builder.append(", btd_def_comp=");
        builder.append(btd_def_comp);
        builder.append(", btd_pre_tax_ins=");
        builder.append(btd_pre_tax_ins);
        builder.append(", btd_other=");
        builder.append(btd_other);
        builder.append(", tax_deduct_resp=");
        builder.append(tax_deduct_resp);
        builder.append(", hlth_ins_resp=");
        builder.append(hlth_ins_resp);
        builder.append(", othr_hlth_ins_resp=");
        builder.append(othr_hlth_ins_resp);
        builder.append(", tanfDiscResp=");
        builder.append(tanfDiscResp);
        builder.append(", housing_bill_others_resp=");
        builder.append(housing_bill_others_resp);
        builder.append(", utility_bills_oil_resp=");
        builder.append(utility_bills_oil_resp);
        //add and change indicators
        builder.append(", room_brd_chg_ind=");
        builder.append(	room_brd_chg_ind);
        builder.append(", dabl_stat_ind=");
        builder.append(	dabl_stat_ind);
        builder.append(", preg_add_stat_ind=");
        builder.append(	preg_add_stat_ind);
        builder.append(", preg_chg_ind=");
        builder.append(	preg_chg_ind);
        builder.append(", irwe_chg_ind=");
        builder.append(	irwe_chg_ind);
        builder.append(", ei_chg_ind=");
        builder.append(	ei_chg_ind);
        builder.append(", self_empl_chg_ind=");
        builder.append(	self_empl_chg_ind);
        builder.append(", othr_incm_chg_ind=");
        builder.append(	othr_incm_chg_ind);
        builder.append(", empl_chg_ind=");
        builder.append(	empl_chg_ind);
        builder.append(", veh_aset_add_ind=");
        builder.append(	veh_aset_add_ind);
        builder.append(", veh_aset_chg_ind=");
        builder.append(	veh_aset_chg_ind);
        builder.append(", real_aset_add_ind=");
        builder.append(	real_aset_add_ind);
        builder.append(", real_aset_chg_ind=");
        builder.append(	real_aset_chg_ind);
        builder.append(", bury_aset_add_ind=");
        builder.append(	bury_aset_add_ind);
        builder.append(", bury_aset_chg_ind=");
        builder.append(	bury_aset_chg_ind);
        builder.append(", liquid_asset_add_ind=");
        builder.append(	liquid_asset_add_ind);
        builder.append(", liquid_asset_bank_acc_chg_ind=");
        builder.append(	liquid_asset_bank_acc_chg_ind);
        builder.append(", liquid_asset_cash_chg_ind=");
        builder.append(	liquid_asset_cash_chg_ind);
        builder.append(", liquid_asset_chg_ind=");
        builder.append(	liquid_asset_chg_ind);
        builder.append(", liquid_asset_other_chg_ind=");
        builder.append(	liquid_asset_other_chg_ind);
        builder.append(", life_ins_aset_add_ind=");
        builder.append(	life_ins_aset_add_ind);
        builder.append(", life_ins_aset_chg_ind=");
        builder.append(	life_ins_aset_chg_ind);
        builder.append(", aset_xfer_chg_ind=");
        builder.append(	aset_xfer_chg_ind);
        builder.append(", dpnd_care_chg_ind=");
        builder.append(	dpnd_care_chg_ind);
        builder.append(", health_insurance_chg_ind=");
        builder.append(	health_insurance_chg_ind);
        builder.append(", child_support_payment_chg_ind=");
        builder.append(	child_support_payment_chg_ind);
        builder.append(", snap_shelter_standard_exp_ind=");
        builder.append(	snap_shelter_standard_exp_ind);
        builder.append(", hous_bill_chg_ind=");
        builder.append(	hous_bill_chg_ind);
        builder.append(", add_chg_ind=");
        builder.append(	add_chg_ind);
        builder.append(", person_moved_in_stat_ind=");
        builder.append(	person_moved_in_stat_ind);
        builder.append(", person_moved_out_stat_ind=");
        builder.append(	person_moved_out_stat_ind);
        builder.append(", hospice_chg_ind=");
        builder.append(	hospice_chg_ind);
        builder.append(", medicare_chg_ind=");
        builder.append(	medicare_chg_ind);
        builder.append(", ncp_chg_ind=");
        builder.append(	ncp_chg_ind);
        builder.append(", third_party_chg_ind=");
        builder.append(	third_party_chg_ind	);
        builder.append(", hospital_abd_chg_ind=");
        builder.append(	hospital_abd_chg_ind);
        builder.append(", public_law_abd_chg_ind=");
        builder.append(	public_law_abd_chg_ind);
        builder.append(", living_argmt_chg_ind=");
        builder.append(	living_argmt_chg_ind);
        builder.append(", other_program_chg_ind=");
        builder.append(	other_program_chg_ind);
        builder.append(", magi_expense_chg_ind=");
        builder.append(	magi_expense_chg_ind);
        builder.append(", tax_info_ind=");
        builder.append(	tax_info_ind);
        builder.append(", tax_dep_outside_resp=");
        builder.append(	tax_dep_outside_resp);
        builder.append(", medicare_part_a=");
        builder.append(medicare_part_a);
        builder.append(", medicare_part_b=");
        builder.append(medicare_part_b);
        builder.append(", medicare_part_c=");
        builder.append(medicare_part_c);
        builder.append(", medicare_part_d=");
        builder.append(medicare_part_d);
        builder.append(", cssp_provider_payment=");
        builder.append(cssp_provider_payment);
        builder.append(", animals_to_assist_disabled=");
        builder.append(animals_to_assist_disabled);
        builder.append(", funeral_death_expense=");
        builder.append(funeral_death_expense);
        builder.append(", blind_work_expense=");
        builder.append(blind_work_expense);
        builder.append(", impairment_work_expense=");
        builder.append(impairment_work_expense); 
        builder.append(", oth_ind_gambl_pmnts=");
        builder.append(oth_ind_gambl_pmnts);
        builder.append(", income_from_resource=");
        builder.append(income_from_resource);
        builder.append(", indian_gambling_payments=");
        builder.append(indian_gambling_payments);
        builder.append(", inheritance=");
        builder.append(inheritance);
        builder.append(", insuance_benefits=");
        builder.append(insuance_benefits);
        builder.append(", loan_received=");
        builder.append(loan_received);
        builder.append(", loan_repayment_income=");
        builder.append(loan_repayment_income);
        builder.append(", managed_income=");
        builder.append(managed_income);
        builder.append(", match_grant=");
        builder.append(match_grant);
        builder.append(", montgomery_gi_bill=");
        builder.append(montgomery_gi_bill);
        builder.append(", out_of_state_public=");
        builder.append(out_of_state_public);
        builder.append(", refunds_from_dch=");
        builder.append(refunds_from_dch);
        builder.append(", restitutions_settlements=");
        builder.append(restitutions_settlements);
        builder.append(", senior_companion=");
        builder.append(senior_companion);
        builder.append(", severance_pay=");
        builder.append(severance_pay);
        builder.append(", strike_benefits=");
        builder.append(strike_benefits);
        builder.append(", trade_readjustment=");
        builder.append(trade_readjustment);
        builder.append(", uniform_relocation=");
        builder.append(uniform_relocation);
        builder.append(", union_funds=");
        builder.append(union_funds);
        builder.append(", vendor_excluded=");
        builder.append(vendor_excluded);
        builder.append(", victim_restitution=");
        builder.append(victim_restitution);
        builder.append(", volunteer_payment=");
        builder.append(volunteer_payment);
        builder.append(", volunteer_payment_titlei=");
        builder.append(volunteer_payment_titlei);
        builder.append(", wia_training_and_allowance=");
        builder.append(wia_training_and_allowance);
        builder.append(", included_unearned_income=");
        builder.append(included_unearned_income);
        builder.append(", tanf_max_au_allotment=");
        builder.append(tanf_max_au_allotment);
        builder.append(", tanf_max_grg_allotment=");
        builder.append(tanf_max_grg_allotment);
        builder.append(", charitable_donation=");
        builder.append(charitable_donation);
        builder.append(", child_nutrition_payments=");
        builder.append(child_nutrition_payments);
        builder.append(", black_lung_benefits=");
        builder.append(black_lung_benefits);
        builder.append(", child_support_court=");
        builder.append(child_support_court);
        builder.append(", child_support_gap_payment=");
        builder.append(child_support_gap_payment);
        builder.append(", civil_service=");
        builder.append(civil_service);
        builder.append(", deferred_compensation_plans=");
        builder.append(deferred_compensation_plans);
        builder.append(", disability_insurance=");
        builder.append(disability_insurance);
        builder.append(", excluded_unearned_income=");
        builder.append(excluded_unearned_income);
        builder.append(", fema_payment_disaster=");
        builder.append(fema_payment_disaster);
        builder.append(", fema_payment_non_disaster=");
        builder.append(fema_payment_non_disaster);
        builder.append(", health_savings_account=");
        builder.append(health_savings_account);
        builder.append(", in_kind_support=");
        builder.append(in_kind_support);
        builder.append(", foster_grandparent_program=");
        builder.append(foster_grandparent_program);
        builder.append(", disaster_unemployment=");
        builder.append(disaster_unemployment);
        builder.append(", dividends=");
        builder.append(dividends);
        builder.append(", charitable_donation_federal=");
        builder.append(charitable_donation_federal);        
        builder.append(", bonds=");
        builder.append(bonds);
        builder.append(", dividend=");
        builder.append(dividend);
        builder.append(", health_reimbursement_account=");
        builder.append(health_reimbursement_account);
        builder.append(", individual_development_account=");
        builder.append(individual_development_account);
        builder.append(", uniform_gifts_to_minors=");
        builder.append(uniform_gifts_to_minors);   
        builder.append(", inheritance_income=");
        builder.append(inheritance_income);
        builder.append(", personal_info=");
        builder.append(personal_info);
        builder.append(", patient_fund=");
        builder.append(patient_fund);      
        builder.append(", disaster_assistance=");
        builder.append(disaster_assistance);
        builder.append(", non_business_equipment=");
        builder.append(non_business_equipment);
        builder.append(", household_goods=");
        builder.append(household_goods);
        builder.append(", other_non_countable=");
        builder.append(other_non_countable);
        builder.append(", schl_enrl_chg_ind=");
        builder.append(schl_enrl_chg_ind);
        builder.append(", mrtl_stat_chg_ind=");
        builder.append(mrtl_stat_chg_ind);
        builder.append(", nur_hme_chg_ind=");
        builder.append(nur_hme_chg_ind);
        builder.append(", bfr_tax_chg_ind=");
        builder.append(bfr_tax_chg_ind);
        builder.append(", inc_tax_chg_ind=");
        builder.append(inc_tax_chg_ind);
        builder.append(", thrd_prty_chg_ind=");
        builder.append(thrd_prty_chg_ind);
        builder.append(", death_benefit_state_federal=");
        builder.append(death_benefit_state_federal);
        builder.append(", social_security_survivor=");
        builder.append(social_security_survivor);
        builder.append(", vendor_payments=");
        builder.append(vendor_payments);
		builder.append(", alias_name_change_resp=");
	    builder.append(alias_name_change_resp);
        builder.append(", citizenship_chg_ind=");
        builder.append(citizenship_chg_ind);
        builder.append(", demographics_chg_ind=");
        builder.append(demographics_chg_ind);
        builder.append(", alien_chg_ind=");
        builder.append(alien_chg_ind);
        builder.append(", util_bill_chg_Ind=");
        builder.append(util_bill_chg_Ind);
        builder.append(", citizenship_info=");
        builder.append(citizenship_info);
        builder.append(", indv_prgm_chg_ind=");
        builder.append(indv_prgm_chg_ind);
        builder.append(", empl_hlth_ins_resp=");
        builder.append(empl_hlth_ins_resp);
        builder.append(", avd_prsctn_fstf=");
        builder.append(avd_prsctn_fstf);
        builder.append(", cntrl_subs_resp=");
        builder.append(cntrl_subs_resp);
        builder.append(", heat_cool_src=");
        builder.append(heat_cool_src);
        builder.append("]");
        return builder.toString();
    }

    /**
	 * returns the PrimaryKey object.
	 */
	@Override
	public IPrimaryKey getPrimaryKey() {
		final RMC_IN_PRFL_PrimaryKey key = new RMC_IN_PRFL_PrimaryKey();
		key.setApp_num(getApp_num());
		key.setIndv_seq_num(getIndv_seq_num());
		return key;
	}

	/**
	 * compares the given cargo with this cargo and returns the changed
	 * attribute-value Map.
	 */
	public Map compareAttributes(final RMC_IN_PRFL_Cargo aCargo) {
		final Map changedAttributeValue = new HashMap();
		if (!((aCargo.getApp_num() == null) && (app_num == null)) && !((aCargo.getApp_num() != null) && aCargo.getApp_num().equals(app_num))) {
			changedAttributeValue.put("app_num", aCargo.getApp_num());
		}
		if (!((aCargo.getIndv_seq_num() == null) && (indv_seq_num == null))
				&& !((aCargo.getIndv_seq_num() != null) && aCargo.getIndv_seq_num().equals(indv_seq_num))) {
			changedAttributeValue.put("indv_seq_num", aCargo.getIndv_seq_num());
		}
		if (!((aCargo.getAcdt_resp() == null) && (acdt_resp == null))
				&& !((aCargo.getAcdt_resp() != null) && aCargo.getAcdt_resp().equals(acdt_resp))) {
			changedAttributeValue.put("acdt_resp", aCargo.getAcdt_resp());
		}
		if (!((aCargo.getAdpt_asst_resp() == null) && (adpt_asst_resp == null))
				&& !((aCargo.getAdpt_asst_resp() != null) && aCargo.getAdpt_asst_resp().equals(adpt_asst_resp))) {
			changedAttributeValue.put("adpt_asst_resp", aCargo.getAdpt_asst_resp());
		}
		if (!((aCargo.getAlmy_rcv_resp() == null) && (almy_rcv_resp == null))
				&& !((aCargo.getAlmy_rcv_resp() != null) && aCargo.getAlmy_rcv_resp().equals(almy_rcv_resp))) {
			changedAttributeValue.put("almy_rcv_resp", aCargo.getAlmy_rcv_resp());
		}
		if (!((aCargo.getBnft_anty_resp() == null) && (bnft_anty_resp == null))
				&& !((aCargo.getBnft_anty_resp() != null) && aCargo.getBnft_anty_resp().equals(bnft_anty_resp))) {
			changedAttributeValue.put("bnft_anty_resp", aCargo.getBnft_anty_resp());
		}
		if (!((aCargo.getBnft_chl_sprt_resp() == null) && (bnft_chl_sprt_resp == null))
				&& !((aCargo.getBnft_chl_sprt_resp() != null) && aCargo.getBnft_chl_sprt_resp().equals(bnft_chl_sprt_resp))) {
			changedAttributeValue.put("bnft_chl_sprt_resp", aCargo.getBnft_chl_sprt_resp());
		}
		if (!((aCargo.getBnft_chrt_resp() == null) && (bnft_chrt_resp == null))
				&& !((aCargo.getBnft_chrt_resp() != null) && aCargo.getBnft_chrt_resp().equals(bnft_chrt_resp))) {
			changedAttributeValue.put("bnft_chrt_resp", aCargo.getBnft_chrt_resp());
		}
		if (!((aCargo.getBnft_dabl_resp() == null) && (bnft_dabl_resp == null))
				&& !((aCargo.getBnft_dabl_resp() != null) && aCargo.getBnft_dabl_resp().equals(bnft_dabl_resp))) {
			changedAttributeValue.put("bnft_dabl_resp", aCargo.getBnft_dabl_resp());
		}
		if (!((aCargo.getBnft_divnd_resp() == null) && (bnft_divnd_resp == null))
				&& !((aCargo.getBnft_divnd_resp() != null) && aCargo.getBnft_divnd_resp().equals(bnft_divnd_resp))) {
			changedAttributeValue.put("bnft_divnd_resp", aCargo.getBnft_divnd_resp());
		}
		if (!((aCargo.getBnft_est_trst_resp() == null) && (bnft_est_trst_resp == null))
				&& !((aCargo.getBnft_est_trst_resp() != null) && aCargo.getBnft_est_trst_resp().equals(bnft_est_trst_resp))) {
			changedAttributeValue.put("bnft_est_trst_resp", aCargo.getBnft_est_trst_resp());
		}
		if (!((aCargo.getBnft_rr_resp() == null) && (bnft_rr_resp == null))
				&& !((aCargo.getBnft_rr_resp() != null) && aCargo.getBnft_rr_resp().equals(bnft_rr_resp))) {
			changedAttributeValue.put("bnft_rr_resp", aCargo.getBnft_rr_resp());
		}
		if (!((aCargo.getBnft_uempl_resp() == null) && (bnft_uempl_resp == null))
				&& !((aCargo.getBnft_uempl_resp() != null) && aCargo.getBnft_uempl_resp().equals(bnft_uempl_resp))) {
			changedAttributeValue.put("bnft_uempl_resp", aCargo.getBnft_uempl_resp());
		}
		if (!((aCargo.getBnft_vet_resp() == null) && (bnft_vet_resp == null))
				&& !((aCargo.getBnft_vet_resp() != null) && aCargo.getBnft_vet_resp().equals(bnft_vet_resp))) {
			changedAttributeValue.put("bnft_vet_resp", aCargo.getBnft_vet_resp());
		}
		if (!((aCargo.getChld_sprt_pay_resp() == null) && (chld_sprt_pay_resp == null))
				&& !((aCargo.getChld_sprt_pay_resp() != null) && aCargo.getChld_sprt_pay_resp().equals(chld_sprt_pay_resp))) {
			changedAttributeValue.put("chld_sprt_pay_resp", aCargo.getChld_sprt_pay_resp());
		}
		if (!((aCargo.getDabl_resp() == null) && (dabl_resp == null))
				&& !((aCargo.getDabl_resp() != null) && aCargo.getDabl_resp().equals(dabl_resp))) {
			changedAttributeValue.put("dabl_resp", aCargo.getDabl_resp());
		}
		if (!((aCargo.getDpnd_care_resp() == null) && (dpnd_care_resp == null))
				&& !((aCargo.getDpnd_care_resp() != null) && aCargo.getDpnd_care_resp().equals(dpnd_care_resp))) {
			changedAttributeValue.put("dpnd_care_resp", aCargo.getDpnd_care_resp());
		}
		if (!((aCargo.getDrug_feln_resp() == null) && (drug_feln_resp == null))
				&& !((aCargo.getDrug_feln_resp() != null) && aCargo.getDrug_feln_resp().equals(drug_feln_resp))) {
			changedAttributeValue.put("drug_feln_resp", aCargo.getDrug_feln_resp());
		}
		if (!((aCargo.getEduc_aid_resp() == null) && (educ_aid_resp == null))
				&& !((aCargo.getEduc_aid_resp() != null) && aCargo.getEduc_aid_resp().equals(educ_aid_resp))) {
			changedAttributeValue.put("educ_aid_resp", aCargo.getEduc_aid_resp());
		}
		if (!((aCargo.getEmpl_resp() == null) && (empl_resp == null))
				&& !((aCargo.getEmpl_resp() != null) && aCargo.getEmpl_resp().equals(empl_resp))) {
			changedAttributeValue.put("empl_resp", aCargo.getEmpl_resp());
		}
		if (!((aCargo.getFset_sctn_resp() == null) && (fset_sctn_resp == null))
				&& !((aCargo.getFset_sctn_resp() != null) && aCargo.getFset_sctn_resp().equals(fset_sctn_resp))) {
			changedAttributeValue.put("fset_sctn_resp", aCargo.getFset_sctn_resp());
		}
		if (!((aCargo.getFstr_care_resp() == null) && (fstr_care_resp == null))
				&& !((aCargo.getFstr_care_resp() != null) && aCargo.getFstr_care_resp().equals(fstr_care_resp))) {
			changedAttributeValue.put("fstr_care_resp", aCargo.getFstr_care_resp());
		}
		if (!((aCargo.getGen_rlf_resp() == null) && (gen_rlf_resp == null))
				&& !((aCargo.getGen_rlf_resp() != null) && aCargo.getGen_rlf_resp().equals(gen_rlf_resp))) {
			changedAttributeValue.put("gen_rlf_resp", aCargo.getGen_rlf_resp());
		}
		if (!((aCargo.getHc_cvrg_resp() == null) && (hc_cvrg_resp == null))
				&& !((aCargo.getHc_cvrg_resp() != null) && aCargo.getHc_cvrg_resp().equals(hc_cvrg_resp))) {
			changedAttributeValue.put("hc_cvrg_resp", aCargo.getHc_cvrg_resp());
		}
		if (!((aCargo.getIncm_int_resp() == null) && (incm_int_resp == null))
				&& !((aCargo.getIncm_int_resp() != null) && aCargo.getIncm_int_resp().equals(incm_int_resp))) {
			changedAttributeValue.put("incm_int_resp", aCargo.getIncm_int_resp());
		}
		if (!((aCargo.getIndv_fma_rqst_ind() == null) && (indv_fma_rqst_ind == null))
				&& !((aCargo.getIndv_fma_rqst_ind() != null) && aCargo.getIndv_fma_rqst_ind().equals(indv_fma_rqst_ind))) {
			changedAttributeValue.put("indv_fma_rqst_ind", aCargo.getIndv_fma_rqst_ind());
		}
		if (!((aCargo.getIndv_fpw_rqst_ind() == null) && (indv_fpw_rqst_ind == null))
				&& !((aCargo.getIndv_fpw_rqst_ind() != null) && aCargo.getIndv_fpw_rqst_ind().equals(indv_fpw_rqst_ind))) {
			changedAttributeValue.put("indv_fpw_rqst_ind", aCargo.getIndv_fpw_rqst_ind());
		}
		if (!((aCargo.getIndv_fs_rqst_ind() == null) && (indv_fs_rqst_ind == null))
				&& !((aCargo.getIndv_fs_rqst_ind() != null) && aCargo.getIndv_fs_rqst_ind().equals(indv_fs_rqst_ind))) {
			changedAttributeValue.put("indv_fs_rqst_ind", aCargo.getIndv_fs_rqst_ind());
		}
		if (!((aCargo.getIrwe_resp() == null) && (irwe_resp == null))
				&& !((aCargo.getIrwe_resp() != null) && aCargo.getIrwe_resp().equals(irwe_resp))) {
			changedAttributeValue.put("irwe_resp", aCargo.getIrwe_resp());
		}
		if (!((aCargo.getJob_iknd_resp() == null) && (job_iknd_resp == null))
				&& !((aCargo.getJob_iknd_resp() != null) && aCargo.getJob_iknd_resp().equals(job_iknd_resp))) {
			changedAttributeValue.put("job_iknd_resp", aCargo.getJob_iknd_resp());
		}
		if (!((aCargo.getKinship_care_resp() == null) && (kinship_care_resp == null))
				&& !((aCargo.getKinship_care_resp() != null) && aCargo.getKinship_care_resp().equals(kinship_care_resp))) {
			changedAttributeValue.put("kinship_care_resp", aCargo.getKinship_care_resp());
		}
		if (!((aCargo.getMed_exp_resp() == null) && (med_exp_resp == null))
				&& !((aCargo.getMed_exp_resp() != null) && aCargo.getMed_exp_resp().equals(med_exp_resp))) {
			changedAttributeValue.put("med_exp_resp", aCargo.getMed_exp_resp());
		}
		if (!((aCargo.getMil_allot_resp() == null) && (mil_allot_resp == null))
				&& !((aCargo.getMil_allot_resp() != null) && aCargo.getMil_allot_resp().equals(mil_allot_resp))) {
			changedAttributeValue.put("mil_allot_resp", aCargo.getMil_allot_resp());
		}
		if (!((aCargo.getMony_othr_resp() == null) && (mony_othr_resp == null))
				&& !((aCargo.getMony_othr_resp() != null) && aCargo.getMony_othr_resp().equals(mony_othr_resp))) {
			changedAttributeValue.put("mony_othr_resp", aCargo.getMony_othr_resp());
		}
		if (!((aCargo.getNatl_rfge_resp() == null) && (natl_rfge_resp == null))
				&& !((aCargo.getNatl_rfge_resp() != null) && aCargo.getNatl_rfge_resp().equals(natl_rfge_resp))) {
			changedAttributeValue.put("natl_rfge_resp", aCargo.getNatl_rfge_resp());
		}
		if (!((aCargo.getNeed_ind_resp() == null) && (need_ind_resp == null))
				&& !((aCargo.getNeed_ind_resp() != null) && aCargo.getNeed_ind_resp().equals(need_ind_resp))) {
			changedAttributeValue.put("need_ind_resp", aCargo.getNeed_ind_resp());
		}
		if (!((aCargo.getOn_strk_sw() == null) && (on_strk_sw == null))
				&& !((aCargo.getOn_strk_sw() != null) && aCargo.getOn_strk_sw().equals(on_strk_sw))) {
			changedAttributeValue.put("on_strk_sw", aCargo.getOn_strk_sw());
		}
		if (!((aCargo.getOp_aoda_tmt_rcv_sw() == null) && (op_aoda_tmt_rcv_sw == null))
				&& !((aCargo.getOp_aoda_tmt_rcv_sw() != null) && aCargo.getOp_aoda_tmt_rcv_sw().equals(op_aoda_tmt_rcv_sw))) {
			changedAttributeValue.put("op_aoda_tmt_rcv_sw", aCargo.getOp_aoda_tmt_rcv_sw());
		}
		if (!((aCargo.getOthr_incm_resp() == null) && (othr_incm_resp == null))
				&& !((aCargo.getOthr_incm_resp() != null) && aCargo.getOthr_incm_resp().equals(othr_incm_resp))) {
			changedAttributeValue.put("othr_incm_resp", aCargo.getOthr_incm_resp());
		}
		if (!((aCargo.getOthr_src_resp() == null) && (othr_src_resp == null))
				&& !((aCargo.getOthr_src_resp() != null) && aCargo.getOthr_src_resp().equals(othr_src_resp))) {
			changedAttributeValue.put("othr_src_resp", aCargo.getOthr_src_resp());
		}
		if (!((aCargo.getOwn_aset_resp() == null) && (own_aset_resp == null))
				&& !((aCargo.getOwn_aset_resp() != null) && aCargo.getOwn_aset_resp().equals(own_aset_resp))) {
			changedAttributeValue.put("own_aset_resp", aCargo.getOwn_aset_resp());
		}
		if (!((aCargo.getPay_hous_bill_resp() == null) && (pay_hous_bill_resp == null))
				&& !((aCargo.getPay_hous_bill_resp() != null) && aCargo.getPay_hous_bill_resp().equals(pay_hous_bill_resp))) {
			changedAttributeValue.put("pay_hous_bill_resp", aCargo.getPay_hous_bill_resp());
		}
		if (!((aCargo.getPay_rmr_brd_resp() == null) && (pay_rmr_brd_resp == null))
				&& !((aCargo.getPay_rmr_brd_resp() != null) && aCargo.getPay_rmr_brd_resp().equals(pay_rmr_brd_resp))) {
			changedAttributeValue.put("pay_rmr_brd_resp", aCargo.getPay_rmr_brd_resp());
		}
		if (!((aCargo.getPnsn_retr_resp() == null) && (pnsn_retr_resp == null))
				&& !((aCargo.getPnsn_retr_resp() != null) && aCargo.getPnsn_retr_resp().equals(pnsn_retr_resp))) {
			changedAttributeValue.put("pnsn_retr_resp", aCargo.getPnsn_retr_resp());
		}
		if (!((aCargo.getPreg_resp() == null) && (preg_resp == null))
				&& !((aCargo.getPreg_resp() != null) && aCargo.getPreg_resp().equals(preg_resp))) {
			changedAttributeValue.put("preg_resp", aCargo.getPreg_resp());
		}
		if (!((aCargo.getProp_sold_resp() == null) && (prop_sold_resp == null))
				&& !((aCargo.getProp_sold_resp() != null) && aCargo.getProp_sold_resp().equals(prop_sold_resp))) {
			changedAttributeValue.put("prop_sold_resp", aCargo.getProp_sold_resp());
		}
		if (!((aCargo.getPub_asst_resp() == null) && (pub_asst_resp == null))
				&& !((aCargo.getPub_asst_resp() != null) && aCargo.getPub_asst_resp().equals(pub_asst_resp))) {
			changedAttributeValue.put("pub_asst_resp", aCargo.getPub_asst_resp());
		}
		if (!((aCargo.getRcv_fs_oth_st_resp() == null) && (rcv_fs_oth_st_resp == null))
				&& !((aCargo.getRcv_fs_oth_st_resp() != null) && aCargo.getRcv_fs_oth_st_resp().equals(rcv_fs_oth_st_resp))) {
			changedAttributeValue.put("rcv_fs_oth_st_resp", aCargo.getRcv_fs_oth_st_resp());
		}
		if (!((aCargo.getRcv_hous_asst_resp() == null) && (rcv_hous_asst_resp == null))
				&& !((aCargo.getRcv_hous_asst_resp() != null) && aCargo.getRcv_hous_asst_resp().equals(rcv_hous_asst_resp))) {
			changedAttributeValue.put("rcv_hous_asst_resp", aCargo.getRcv_hous_asst_resp());
		}
		if (!((aCargo.getRcv_medcr_resp() == null) && (rcv_medcr_resp == null))
				&& !((aCargo.getRcv_medcr_resp() != null) && aCargo.getRcv_medcr_resp().equals(rcv_medcr_resp))) {
			changedAttributeValue.put("rcv_medcr_resp", aCargo.getRcv_medcr_resp());
		}
		if (!((aCargo.getRcv_ss_resp() == null) && (rcv_ss_resp == null))
				&& !((aCargo.getRcv_ss_resp() != null) && aCargo.getRcv_ss_resp().equals(rcv_ss_resp))) {
			changedAttributeValue.put("rcv_ss_resp", aCargo.getRcv_ss_resp());
		}
		if (!((aCargo.getRcv_ssi_ltr_resp() == null) && (rcv_ssi_ltr_resp == null))
				&& !((aCargo.getRcv_ssi_ltr_resp() != null) && aCargo.getRcv_ssi_ltr_resp().equals(rcv_ssi_ltr_resp))) {
			changedAttributeValue.put("rcv_ssi_ltr_resp", aCargo.getRcv_ssi_ltr_resp());
		}
		if (!((aCargo.getRcv_ssi_sw() == null) && (rcv_ssi_sw == null))
				&& !((aCargo.getRcv_ssi_sw() != null) && aCargo.getRcv_ssi_sw().equals(rcv_ssi_sw))) {
			changedAttributeValue.put("rcv_ssi_sw", aCargo.getRcv_ssi_sw());
		}
		if (!((aCargo.getRmr_brd_incm_resp() == null) && (rmr_brd_incm_resp == null))
				&& !((aCargo.getRmr_brd_incm_resp() != null) && aCargo.getRmr_brd_incm_resp().equals(rmr_brd_incm_resp))) {
			changedAttributeValue.put("rmr_brd_incm_resp", aCargo.getRmr_brd_incm_resp());
		}
		if (!((aCargo.getSelf_empl_resp() == null) && (self_empl_resp == null))
				&& !((aCargo.getSelf_empl_resp() != null) && aCargo.getSelf_empl_resp().equals(self_empl_resp))) {
			changedAttributeValue.put("self_empl_resp", aCargo.getSelf_empl_resp());
		}
		if (!((aCargo.getSsi_dcond_resp() == null) && (ssi_dcond_resp == null))
				&& !((aCargo.getSsi_dcond_resp() != null) && aCargo.getSsi_dcond_resp().equals(ssi_dcond_resp))) {
			changedAttributeValue.put("ssi_dcond_resp", aCargo.getSsi_dcond_resp());
		}
		if (!((aCargo.getSsi_1619b_rcv_sw() == null) && (ssi_1619b_rcv_sw == null))
				&& !((aCargo.getSsi_1619b_rcv_sw() != null) && aCargo.getSsi_1619b_rcv_sw().equals(ssi_1619b_rcv_sw))) {
			changedAttributeValue.put("ssi_1619b_rcv_sw", aCargo.getSsi_1619b_rcv_sw());
		}
		if (!((aCargo.getSu_ases_resp() == null) && (su_ases_resp == null))
				&& !((aCargo.getSu_ases_resp() != null) && aCargo.getSu_ases_resp().equals(su_ases_resp))) {
			changedAttributeValue.put("su_ases_resp", aCargo.getSu_ases_resp());
		}
		if (!((aCargo.getSu_cst_coal_resp() == null) && (su_cst_coal_resp == null))
				&& !((aCargo.getSu_cst_coal_resp() != null) && aCargo.getSu_cst_coal_resp().equals(su_cst_coal_resp))) {
			changedAttributeValue.put("su_cst_coal_resp", aCargo.getSu_cst_coal_resp());
		}
		if (!((aCargo.getSu_cst_elec_resp() == null) && (su_cst_elec_resp == null))
				&& !((aCargo.getSu_cst_elec_resp() != null) && aCargo.getSu_cst_elec_resp().equals(su_cst_elec_resp))) {
			changedAttributeValue.put("su_cst_elec_resp", aCargo.getSu_cst_elec_resp());
		}
		if (!((aCargo.getSu_cst_fuel_resp() == null) && (su_cst_fuel_resp == null))
				&& !((aCargo.getSu_cst_fuel_resp() != null) && aCargo.getSu_cst_fuel_resp().equals(su_cst_fuel_resp))) {
			changedAttributeValue.put("su_cst_fuel_resp", aCargo.getSu_cst_fuel_resp());
		}
		if (!((aCargo.getSu_cst_gas_resp() == null) && (su_cst_gas_resp == null))
				&& !((aCargo.getSu_cst_gas_resp() != null) && aCargo.getSu_cst_gas_resp().equals(su_cst_gas_resp))) {
			changedAttributeValue.put("su_cst_gas_resp", aCargo.getSu_cst_gas_resp());
		}
		if (!((aCargo.getSu_cst_home_resp() == null) && (su_cst_home_resp == null))
				&& !((aCargo.getSu_cst_home_resp() != null) && aCargo.getSu_cst_home_resp().equals(su_cst_home_resp))) {
			changedAttributeValue.put("su_cst_home_resp", aCargo.getSu_cst_home_resp());
		}
		if (!((aCargo.getSu_cst_istl_resp() == null) && (su_cst_istl_resp == null))
				&& !((aCargo.getSu_cst_istl_resp() != null) && aCargo.getSu_cst_istl_resp().equals(su_cst_istl_resp))) {
			changedAttributeValue.put("su_cst_istl_resp", aCargo.getSu_cst_istl_resp());
		}
		if (!((aCargo.getSu_cst_lpgas_resp() == null) && (su_cst_lpgas_resp == null))
				&& !((aCargo.getSu_cst_lpgas_resp() != null) && aCargo.getSu_cst_lpgas_resp().equals(su_cst_lpgas_resp))) {
			changedAttributeValue.put("su_cst_lpgas_resp", aCargo.getSu_cst_lpgas_resp());
		}
		if (!((aCargo.getSu_cst_mbl_resp() == null) && (su_cst_mbl_resp == null))
				&& !((aCargo.getSu_cst_mbl_resp() != null) && aCargo.getSu_cst_mbl_resp().equals(su_cst_mbl_resp))) {
			changedAttributeValue.put("su_cst_mbl_resp", aCargo.getSu_cst_mbl_resp());
		}
		if (!((aCargo.getSu_cst_mtge_resp() == null) && (su_cst_mtge_resp == null))
				&& !((aCargo.getSu_cst_mtge_resp() != null) && aCargo.getSu_cst_mtge_resp().equals(su_cst_mtge_resp))) {
			changedAttributeValue.put("su_cst_mtge_resp", aCargo.getSu_cst_mtge_resp());
		}
		if (!((aCargo.getSu_cst_othr_resp() == null) && (su_cst_othr_resp == null))
				&& !((aCargo.getSu_cst_othr_resp() != null) && aCargo.getSu_cst_othr_resp().equals(su_cst_othr_resp))) {
			changedAttributeValue.put("su_cst_othr_resp", aCargo.getSu_cst_othr_resp());
		}
		if (!((aCargo.getSu_cst_phn_resp() == null) && (su_cst_phn_resp == null))
				&& !((aCargo.getSu_cst_phn_resp() != null) && aCargo.getSu_cst_phn_resp().equals(su_cst_phn_resp))) {
			changedAttributeValue.put("su_cst_phn_resp", aCargo.getSu_cst_phn_resp());
		}
		if (!((aCargo.getSu_cst_rent_resp() == null) && (su_cst_rent_resp == null))
				&& !((aCargo.getSu_cst_rent_resp() != null) && aCargo.getSu_cst_rent_resp().equals(su_cst_rent_resp))) {
			changedAttributeValue.put("su_cst_rent_resp", aCargo.getSu_cst_rent_resp());
		}
		if (!((aCargo.getSu_cst_swr_resp() == null) && (su_cst_swr_resp == null))
				&& !((aCargo.getSu_cst_swr_resp() != null) && aCargo.getSu_cst_swr_resp().equals(su_cst_swr_resp))) {
			changedAttributeValue.put("su_cst_swr_resp", aCargo.getSu_cst_swr_resp());
		}
		if (!((aCargo.getSu_cst_tax_resp() == null) && (su_cst_tax_resp == null))
				&& !((aCargo.getSu_cst_tax_resp() != null) && aCargo.getSu_cst_tax_resp().equals(su_cst_tax_resp))) {
			changedAttributeValue.put("su_cst_tax_resp", aCargo.getSu_cst_tax_resp());
		}
		if (!((aCargo.getSu_cst_trsh_resp() == null) && (su_cst_trsh_resp == null))
				&& !((aCargo.getSu_cst_trsh_resp() != null) && aCargo.getSu_cst_trsh_resp().equals(su_cst_trsh_resp))) {
			changedAttributeValue.put("su_cst_trsh_resp", aCargo.getSu_cst_trsh_resp());
		}
		if (!((aCargo.getSu_cst_wood_resp() == null) && (su_cst_wood_resp == null))
				&& !((aCargo.getSu_cst_wood_resp() != null) && aCargo.getSu_cst_wood_resp().equals(su_cst_wood_resp))) {
			changedAttributeValue.put("su_cst_wood_resp", aCargo.getSu_cst_wood_resp());
		}
		if (!((aCargo.getSu_cst_wtr_resp() == null) && (su_cst_wtr_resp == null))
				&& !((aCargo.getSu_cst_wtr_resp() != null) && aCargo.getSu_cst_wtr_resp().equals(su_cst_wtr_resp))) {
			changedAttributeValue.put("su_cst_wtr_resp", aCargo.getSu_cst_wtr_resp());
		}
		if (!((aCargo.getSu_cst_wwt_resp() == null) && (su_cst_wwt_resp == null))
				&& !((aCargo.getSu_cst_wwt_resp() != null) && aCargo.getSu_cst_wwt_resp().equals(su_cst_wwt_resp))) {
			changedAttributeValue.put("su_cst_wwt_resp", aCargo.getSu_cst_wwt_resp());
		}
		if (!((aCargo.getTrb_cpta_resp() == null) && (trb_cpta_resp == null))
				&& !((aCargo.getTrb_cpta_resp() != null) && aCargo.getTrb_cpta_resp().equals(trb_cpta_resp))) {
			changedAttributeValue.put("trb_cpta_resp", aCargo.getTrb_cpta_resp());
		}
		if (!((aCargo.getTrb_tanf_resp() == null) && (trb_tanf_resp == null))
				&& !((aCargo.getTrb_tanf_resp() != null) && aCargo.getTrb_tanf_resp().equals(trb_tanf_resp))) {
			changedAttributeValue.put("trb_tanf_resp", aCargo.getTrb_tanf_resp());
		}
		if (!((aCargo.getUpdt_dt() == null) && (updt_dt == null)) && !((aCargo.getUpdt_dt() != null) && aCargo.getUpdt_dt().equals(updt_dt))) {
			changedAttributeValue.put("updt_dt", aCargo.getUpdt_dt());
		}
		if (!((aCargo.getUtil_exp_resp() == null) && (util_exp_resp == null))
				&& !((aCargo.getUtil_exp_resp() != null) && aCargo.getUtil_exp_resp().equals(util_exp_resp))) {
			changedAttributeValue.put("util_exp_resp", aCargo.getUtil_exp_resp());
		}
		if (!((aCargo.getWheap_resp() == null) && (wheap_resp == null))
				&& !((aCargo.getWheap_resp() != null) && aCargo.getWheap_resp().equals(wheap_resp))) {
			changedAttributeValue.put("wheap_resp", aCargo.getWheap_resp());
		}
		if (!((aCargo.getWork_comp_resp() == null) && (work_comp_resp == null))
				&& !((aCargo.getWork_comp_resp() != null) && aCargo.getWork_comp_resp().equals(work_comp_resp))) {
			changedAttributeValue.put("work_comp_resp", aCargo.getWork_comp_resp());
		}
		if (!((aCargo.getYehoc_resp() == null) && (yehoc_resp == null))
				&& !((aCargo.getYehoc_resp() != null) && aCargo.getYehoc_resp().equals(yehoc_resp))) {
			changedAttributeValue.put("yehoc_resp", aCargo.getYehoc_resp());
		}
		if (!((aCargo.getResettl_inc_resp() == null) && (resettl_inc_resp == null))
				&& !((aCargo.getResettl_inc_resp() != null) && aCargo.getResettl_inc_resp().equals(resettl_inc_resp))) {
			changedAttributeValue.put("resettl_inc_resp", aCargo.getResettl_inc_resp());
		}
		if (!((aCargo.getNone_resp() == null) && (none_resp == null))
				&& !((aCargo.getNone_resp() != null) && aCargo.getNone_resp().equals(none_resp))) {
			changedAttributeValue.put("none_resp", aCargo.getNone_resp());
		}
		if (!((aCargo.getLand_cont_resp() == null) && (land_cont_resp == null))
				&& !((aCargo.getLand_cont_resp() != null) && aCargo.getLand_cont_resp().equals(land_cont_resp))) {
			changedAttributeValue.put("land_cont_resp", aCargo.getLand_cont_resp());
		}
		if (!((aCargo.getRefused_job_lst_30_resp() == null) && (refused_job_lst_30_resp == null))
				&& !((aCargo.getRefused_job_lst_30_resp() != null) && aCargo.getRefused_job_lst_30_resp().equals(refused_job_lst_30_resp))) {
			changedAttributeValue.put("refused_job_lst_30_resp", aCargo.getRefused_job_lst_30_resp());
		}
		if (!((aCargo.getChild_support_arr_resp() == null) && (child_support_arr_resp == null))
				&& !((aCargo.getChild_support_arr_resp() != null) && aCargo.getChild_support_arr_resp().equals(child_support_arr_resp))) {
			changedAttributeValue.put("child_support_arr_resp", aCargo.getChild_support_arr_resp());
		}
		if (!((aCargo.getUnocc_home_exp_resp() == null) && (unocc_home_exp_resp == null))
				&& !((aCargo.getUnocc_home_exp_resp() != null) && aCargo.getUnocc_home_exp_resp().equals(unocc_home_exp_resp))) {
			changedAttributeValue.put("unocc_home_exp_resp", aCargo.getUnocc_home_exp_resp());
		}
		if (!((aCargo.getTribal_food_dist_resp() == null) && (tribal_food_dist_resp == null))
				&& !((aCargo.getTribal_food_dist_resp() != null) && aCargo.getTribal_food_dist_resp().equals(tribal_food_dist_resp))) {
			changedAttributeValue.put("tribal_food_dist_resp", aCargo.getTribal_food_dist_resp());
		}
		if (!((aCargo.getChild_adult_care_resp() == null) && (child_adult_care_resp == null))
				&& !((aCargo.getChild_adult_care_resp() != null) && aCargo.getChild_adult_care_resp().equals(child_adult_care_resp))) {
			changedAttributeValue.put("child_adult_care_resp", aCargo.getChild_adult_care_resp());
		}
		if (!((aCargo.getMi_heating_cred_resp() == null) && (mi_heating_cred_resp == null))
				&& !((aCargo.getMi_heating_cred_resp() != null) && aCargo.getMi_heating_cred_resp().equals(mi_heating_cred_resp))) {
			changedAttributeValue.put("mi_heating_cred_resp", aCargo.getMi_heating_cred_resp());
		}
		if (!((aCargo.getMortg_guar_ins_resp() == null) && (mortg_guar_ins_resp == null))
				&& !((aCargo.getMortg_guar_ins_resp() != null) && aCargo.getMortg_guar_ins_resp().equals(mortg_guar_ins_resp))) {
			changedAttributeValue.put("mortg_guar_ins_resp", aCargo.getMortg_guar_ins_resp());
		}
		if (!((aCargo.getCoop_condo_fee_resp() == null) && (coop_condo_fee_resp == null))
				&& !((aCargo.getCoop_condo_fee_resp() != null) && aCargo.getCoop_condo_fee_resp().equals(coop_condo_fee_resp))) {
			changedAttributeValue.put("coop_condo_fee_resp", aCargo.getCoop_condo_fee_resp());
		}
		if (!((aCargo.getOther_resp() == null) && (other_resp == null))
				&& !((aCargo.getOther_resp() != null) && aCargo.getOther_resp().equals(other_resp))) {
			changedAttributeValue.put("other_resp", aCargo.getOther_resp());
		}
		if (!((aCargo.getWater_well_resp() == null) && (water_well_resp == null))
				&& !((aCargo.getWater_well_resp() != null) && aCargo.getWater_well_resp().equals(water_well_resp))) {
			changedAttributeValue.put("water_well_resp", aCargo.getWater_well_resp());
		}
		if (!((aCargo.getCooking_fuel_resp() == null) && (cooking_fuel_resp == null))
				&& !((aCargo.getCooking_fuel_resp() != null) && aCargo.getCooking_fuel_resp().equals(cooking_fuel_resp))) {
			changedAttributeValue.put("cooking_fuel_resp", aCargo.getCooking_fuel_resp());
		}
		if (!((aCargo.getWater_well_maint_resp() == null) && (water_well_maint_resp == null))
				&& !((aCargo.getWater_well_maint_resp() != null) && aCargo.getWater_well_maint_resp().equals(water_well_maint_resp))) {
			changedAttributeValue.put("water_well_maint_resp", aCargo.getWater_well_maint_resp());
		}
		if (!((aCargo.getHeating_resp() == null) && (heating_resp == null))
				&& !((aCargo.getHeating_resp() != null) && aCargo.getHeating_resp().equals(heating_resp))) {
			changedAttributeValue.put("heating_resp", aCargo.getHeating_resp());
		}
		if (!((aCargo.getCooling_resp() == null) && (cooling_resp == null))
				&& !((aCargo.getCooling_resp() != null) && aCargo.getCooling_resp().equals(cooling_resp))) {
			changedAttributeValue.put("cooling_resp", aCargo.getCooling_resp());
		}
		if (!((aCargo.getSeptic_sewer_resp() == null) && (septic_sewer_resp == null))
				&& !((aCargo.getSeptic_sewer_resp() != null) && aCargo.getSeptic_sewer_resp().equals(septic_sewer_resp))) {
			changedAttributeValue.put("septic_sewer_resp", aCargo.getSeptic_sewer_resp());
		}
		if (!((aCargo.getHome_equity_resp() == null) && (home_equity_resp == null))
				&& !((aCargo.getHome_equity_resp() != null) && aCargo.getHome_equity_resp().equals(home_equity_resp))) {
			changedAttributeValue.put("home_equity_resp", aCargo.getHome_equity_resp());
		}
		if (!((aCargo.getSecond_mortgag_resp() == null) && (second_mortgag_resp == null))
				&& !((aCargo.getSecond_mortgag_resp() != null) && aCargo.getSecond_mortgag_resp().equals(second_mortgag_resp))) {
			changedAttributeValue.put("second_mortgag_resp", aCargo.getSecond_mortgag_resp());
		}
		if (!((aCargo.getOthr_incm_rentl_resp() == null) && (othr_incm_rentl_resp == null))
				&& !((aCargo.getOthr_incm_rentl_resp() != null) && aCargo.getOthr_incm_rentl_resp().equals(othr_incm_rentl_resp))) {
			changedAttributeValue.put("othr_incm_rentl_resp", aCargo.getOthr_incm_rentl_resp());
		}
		if (!((aCargo.getBury_aset_c_resp() == null) && (bury_aset_c_resp == null))
				&& !((aCargo.getBury_aset_c_resp() != null) && aCargo.getBury_aset_c_resp().equals(bury_aset_c_resp))) {
			changedAttributeValue.put("bury_aset_c_resp", aCargo.getBury_aset_c_resp());
		}
		if (!((aCargo.getBury_aset_ibt_resp() == null) && (bury_aset_ibt_resp == null))
				&& !((aCargo.getBury_aset_ibt_resp() != null) && aCargo.getBury_aset_ibt_resp().equals(bury_aset_ibt_resp))) {
			changedAttributeValue.put("bury_aset_ibt_resp", aCargo.getBury_aset_ibt_resp());
		}
		if (!((aCargo.getBury_aset_ins_resp() == null) && (bury_aset_ins_resp == null))
				&& !((aCargo.getBury_aset_ins_resp() != null) && aCargo.getBury_aset_ins_resp().equals(bury_aset_ins_resp))) {
			changedAttributeValue.put("bury_aset_ins_resp", aCargo.getBury_aset_ins_resp());
		}
		if (!((aCargo.getBury_aset_mas_resp() == null) && (bury_aset_mas_resp == null))
				&& !((aCargo.getBury_aset_mas_resp() != null) && aCargo.getBury_aset_mas_resp().equals(bury_aset_mas_resp))) {
			changedAttributeValue.put("bury_aset_mas_resp", aCargo.getBury_aset_mas_resp());
		}
		if (!((aCargo.getBury_aset_oth_resp() == null) && (bury_aset_oth_resp == null))
				&& !((aCargo.getBury_aset_oth_resp() != null) && aCargo.getBury_aset_oth_resp().equals(bury_aset_oth_resp))) {
			changedAttributeValue.put("bury_aset_oth_resp", aCargo.getBury_aset_oth_resp());
		}
		if (!((aCargo.getBury_aset_plt_resp() == null) && (bury_aset_plt_resp == null))
				&& !((aCargo.getBury_aset_plt_resp() != null) && aCargo.getBury_aset_plt_resp().equals(bury_aset_plt_resp))) {
			changedAttributeValue.put("bury_aset_plt_resp", aCargo.getBury_aset_plt_resp());
		}
		if (!((aCargo.getBury_aset_rbt_resp() == null) && (bury_aset_rbt_resp == null))
				&& !((aCargo.getBury_aset_rbt_resp() != null) && aCargo.getBury_aset_rbt_resp().equals(bury_aset_rbt_resp))) {
			changedAttributeValue.put("bury_aset_rbt_resp", aCargo.getBury_aset_rbt_resp());
		}
		if (!((aCargo.getBury_aset_v_resp() == null) && (bury_aset_v_resp == null))
				&& !((aCargo.getBury_aset_v_resp() != null) && aCargo.getBury_aset_v_resp().equals(bury_aset_v_resp))) {
			changedAttributeValue.put("bury_aset_v_resp", aCargo.getBury_aset_v_resp());
		}
		if (!((aCargo.getMedical_service_resp() == null) && (medical_service_resp == null))
				&& !((aCargo.getMedical_service_resp() != null) && aCargo.getMedical_service_resp().equals(medical_service_resp))) {
			changedAttributeValue.put("medical_service_resp", aCargo.getMedical_service_resp());
		}
		if (!((aCargo.getEmergency_medical_service_resp() == null) && (emergency_medical_service_resp == null))
				&& !((aCargo.getEmergency_medical_service_resp() != null) && aCargo.getEmergency_medical_service_resp().equals(
						emergency_medical_service_resp))) {
			changedAttributeValue.put("emergency_medical_service_resp", aCargo.getEmergency_medical_service_resp());
		}
		if (!((aCargo.getParole_violation_resp() == null) && (parole_violation_resp == null))
				&& !((aCargo.getParole_violation_resp() != null) && aCargo.getParole_violation_resp().equals(parole_violation_resp))) {
			changedAttributeValue.put("parole_violation_resp", aCargo.getParole_violation_resp());
		}
		if (!((aCargo.getRoom_board_resp() == null) && (room_board_resp == null))
				&& !((aCargo.getRoom_board_resp() != null) && aCargo.getRoom_board_resp().equals(room_board_resp))) {
			changedAttributeValue.put("room_board_resp", aCargo.getRoom_board_resp());
		}
		if (!((aCargo.getCurrent_past_job_resp() == null) && (current_past_job_resp == null))
				&& !((aCargo.getCurrent_past_job_resp() != null) && aCargo.getCurrent_past_job_resp().equals(current_past_job_resp))) {
			changedAttributeValue.put("current_past_job_resp", aCargo.getCurrent_past_job_resp());
		}
		if (!((aCargo.getOther_asset_vehicle_resp() == null) && (other_asset_vehicle_resp == null))
				&& !((aCargo.getOther_asset_vehicle_resp() != null) && aCargo.getOther_asset_vehicle_resp().equals(other_asset_vehicle_resp))) {
			changedAttributeValue.put("other_asset_vehicle_resp", aCargo.getOther_asset_vehicle_resp());
		}
		if (!((aCargo.getOther_asset_real_property_resp() == null) && (other_asset_real_property_resp == null))
				&& !((aCargo.getOther_asset_real_property_resp() != null) && aCargo.getOther_asset_real_property_resp().equals(
						other_asset_real_property_resp))) {
			changedAttributeValue.put("other_asset_real_property_resp", aCargo.getOther_asset_real_property_resp());
		}
		if (!((aCargo.getOther_asset_burial_resp() == null) && (other_asset_burial_resp == null))
				&& !((aCargo.getOther_asset_burial_resp() != null) && aCargo.getOther_asset_burial_resp().equals(other_asset_burial_resp))) {
			changedAttributeValue.put("other_asset_burial_resp", aCargo.getOther_asset_burial_resp());
		}
		if (!((aCargo.getOther_asset_personal_prop_resp() == null) && (other_asset_personal_prop_resp == null))
				&& !((aCargo.getOther_asset_personal_prop_resp() != null) && aCargo.getOther_asset_personal_prop_resp().equals(
						other_asset_personal_prop_resp))) {
			changedAttributeValue.put("other_asset_personal_prop_resp", aCargo.getOther_asset_personal_prop_resp());
		}
		if (!((aCargo.getOther_aset_life_insurance_resp() == null) && (other_aset_life_insurance_resp == null))
				&& !((aCargo.getOther_aset_life_insurance_resp() != null) && aCargo.getOther_aset_life_insurance_resp().equals(
						other_aset_life_insurance_resp))) {
			changedAttributeValue.put("other_aset_life_insurance_resp", aCargo.getOther_aset_life_insurance_resp());
		}
		if (!((aCargo.getVehicle_asset_auto_resp() == null) && (vehicle_asset_auto_resp == null))
				&& !((aCargo.getVehicle_asset_auto_resp() != null) && aCargo.getVehicle_asset_auto_resp().equals(vehicle_asset_auto_resp))) {
			changedAttributeValue.put("vehicle_asset_auto_resp", aCargo.getVehicle_asset_auto_resp());
		}
		if (!((aCargo.getVehicle_asset_boat_resp() == null) && (vehicle_asset_boat_resp == null))
				&& !((aCargo.getVehicle_asset_boat_resp() != null) && aCargo.getVehicle_asset_boat_resp().equals(vehicle_asset_boat_resp))) {
			changedAttributeValue.put("vehicle_asset_boat_resp", aCargo.getVehicle_asset_boat_resp());
		}
		if (!((aCargo.getVehicle_asset_motorcycle_resp() == null) && (vehicle_asset_motorcycle_resp == null))
				&& !((aCargo.getVehicle_asset_motorcycle_resp() != null) && aCargo.getVehicle_asset_motorcycle_resp().equals(
						vehicle_asset_motorcycle_resp))) {
			changedAttributeValue.put("vehicle_asset_motorcycle_resp", aCargo.getVehicle_asset_motorcycle_resp());
		}
		if (!((aCargo.getVehicle_asset_other_resp() == null) && (vehicle_asset_other_resp == null))
				&& !((aCargo.getVehicle_asset_other_resp() != null) && aCargo.getVehicle_asset_other_resp().equals(vehicle_asset_other_resp))) {
			changedAttributeValue.put("vehicle_asset_other_resp", aCargo.getVehicle_asset_other_resp());
		}
		if (!((aCargo.getVehicle_asset_recreation_resp() == null) && (vehicle_asset_recreation_resp == null))
				&& !((aCargo.getVehicle_asset_recreation_resp() != null) && aCargo.getVehicle_asset_recreation_resp().equals(
						vehicle_asset_recreation_resp))) {
			changedAttributeValue.put("vehicle_asset_recreation_resp", aCargo.getVehicle_asset_recreation_resp());
		}
		if (!((aCargo.getVehicle_asset_animal_drwn_resp() == null) && (vehicle_asset_animal_drwn_resp == null))
				&& !((aCargo.getVehicle_asset_animal_drwn_resp() != null) && aCargo.getVehicle_asset_animal_drwn_resp().equals(
						vehicle_asset_animal_drwn_resp))) {
			changedAttributeValue.put("vehicle_asset_animal_drwn_resp", aCargo.getVehicle_asset_animal_drwn_resp());
		}
		if (!((aCargo.getVehicle_asset_tractor_resp() == null) && (vehicle_asset_tractor_resp == null))
				&& !((aCargo.getVehicle_asset_tractor_resp() != null) && aCargo.getVehicle_asset_tractor_resp().equals(vehicle_asset_tractor_resp))) {
			changedAttributeValue.put("vehicle_asset_tractor_resp", aCargo.getVehicle_asset_tractor_resp());
		}
		if (!((aCargo.getVehicle_asset_golf_cart_resp() == null) && (vehicle_asset_golf_cart_resp == null))
				&& !((aCargo.getVehicle_asset_golf_cart_resp() != null) && aCargo.getVehicle_asset_golf_cart_resp().equals(
						vehicle_asset_golf_cart_resp))) {
			changedAttributeValue.put("vehicle_asset_golf_cart_resp", aCargo.getVehicle_asset_golf_cart_resp());
		}
		if (!((aCargo.getVehicle_asset_nmot_camper_resp() == null) && (vehicle_asset_nmot_camper_resp == null))
				&& !((aCargo.getVehicle_asset_nmot_camper_resp() != null) && aCargo.getVehicle_asset_nmot_camper_resp().equals(
						vehicle_asset_nmot_camper_resp))) {
			changedAttributeValue.put("vehicle_asset_nmot_camper_resp", aCargo.getVehicle_asset_nmot_camper_resp());
		}
		if (!((aCargo.getTraining_allowance_resp() == null) && (training_allowance_resp == null))
				&& !((aCargo.getTraining_allowance_resp() != null) && aCargo.getTraining_allowance_resp().equals(training_allowance_resp))) {
			changedAttributeValue.put("training_allowance_resp", aCargo.getTraining_allowance_resp());
		}
		// EDSP RMB other income
		if (!((aCargo.getInheritance_resp() == null) && (inheritance_resp == null))
				&& !((aCargo.getInheritance_resp() != null) && aCargo.getInheritance_resp().equals(inheritance_resp))) {
			changedAttributeValue.put("inheritance_resp", aCargo.getInheritance_resp());
		}
		if (!((aCargo.getStudent_financial_aid_resp() == null) && (student_financial_aid_resp == null))
				&& !((aCargo.getStudent_financial_aid_resp() != null) && aCargo.getStudent_financial_aid_resp().equals(student_financial_aid_resp))) {
			changedAttributeValue.put("student_financial_aid_resp", aCargo.getStudent_financial_aid_resp());
		}
		if (!((aCargo.getFood_clothing_util_rent_resp() == null) && (food_clothing_util_rent_resp == null))
				&& !((aCargo.getFood_clothing_util_rent_resp() != null) && aCargo.getFood_clothing_util_rent_resp().equals(
						food_clothing_util_rent_resp))) {
			changedAttributeValue.put("food_clothing_util_rent_resp", aCargo.getFood_clothing_util_rent_resp());
		}
		if (!((aCargo.getCash_gifts_resp() == null) && (cash_gifts_resp == null))
				&& !((aCargo.getCash_gifts_resp() != null) && aCargo.getCash_gifts_resp().equals(cash_gifts_resp))) {
			changedAttributeValue.put("cash_gifts_resp", aCargo.getCash_gifts_resp());
		}
		if (!((aCargo.getLoan_resp() == null) && (loan_resp == null))
				&& !((aCargo.getLoan_resp() != null) && aCargo.getLoan_resp().equals(loan_resp))) {
			changedAttributeValue.put("loan_resp", aCargo.getLoan_resp());
		}
		if (!((aCargo.getBenefit_black_lung_resp() == null) && (benefit_black_lung_resp == null))
				&& !((aCargo.getBenefit_black_lung_resp() != null) && aCargo.getBenefit_black_lung_resp().equals(benefit_black_lung_resp))) {
			changedAttributeValue.put("benefit_black_lung_resp", aCargo.getBenefit_black_lung_resp());
		}
		if (!((aCargo.getLottery_prize_winning_resp() == null) && (lottery_prize_winning_resp == null))
				&& !((aCargo.getLottery_prize_winning_resp() != null) && aCargo.getLottery_prize_winning_resp().equals(lottery_prize_winning_resp))) {
			changedAttributeValue.put("lottery_prize_winning_resp", aCargo.getLottery_prize_winning_resp());
		}
		if (!((aCargo.getInsurance_settlement_resp() == null) && (insurance_settlement_resp == null))
				&& !((aCargo.getInsurance_settlement_resp() != null) && aCargo.getInsurance_settlement_resp().equals(insurance_settlement_resp))) {
			changedAttributeValue.put("insurance_settlement_resp", aCargo.getInsurance_settlement_resp());
		}
		if (!((aCargo.getOthr_social_security_bnft_resp() == null) && (othr_social_security_bnft_resp == null))
				&& !((aCargo.getOthr_social_security_bnft_resp() != null) && aCargo.getOthr_social_security_bnft_resp().equals(
						othr_social_security_bnft_resp))) {
			changedAttributeValue.put("othr_social_security_bnft_resp", aCargo.getOthr_social_security_bnft_resp());
		}
		if (!((aCargo.getBenefits_on_strike_resp() == null) && (benefits_on_strike_resp == null))
				&& !((aCargo.getBenefits_on_strike_resp() != null) && aCargo.getBenefits_on_strike_resp().equals(benefits_on_strike_resp))) {
			changedAttributeValue.put("benefits_on_strike_resp", aCargo.getBenefits_on_strike_resp());
		}
		if (!((aCargo.getVehicle_asset_camper_resp() == null) && (vehicle_asset_camper_resp == null))
				&& !((aCargo.getVehicle_asset_camper_resp() != null) && aCargo.getVehicle_asset_camper_resp().equals(vehicle_asset_camper_resp))) {
			changedAttributeValue.put("vehicle_asset_camper_resp", aCargo.getVehicle_asset_camper_resp());
		}
		if (!((aCargo.getVehicle_asset_camper_resp() == null) && (work_related_expense_resp == null))
				&& !((aCargo.getVehicle_asset_camper_resp() != null) && aCargo.getVehicle_asset_camper_resp().equals(work_related_expense_resp))) {
			changedAttributeValue.put("work_related_expensse_resp", aCargo.getVehicle_asset_camper_resp());
		}
		if (!((aCargo.getOther_incm_contrib_resp() == null) && (other_incm_contrib_resp == null))
				&& !((aCargo.getOther_incm_contrib_resp() != null) && aCargo.getOther_incm_contrib_resp().equals(other_incm_contrib_resp))) {
			changedAttributeValue.put("other_incm_contrib_resp", aCargo.getOther_incm_contrib_resp());
		}
		if (!((aCargo.getHospital_stay_resp() == null) && (hospital_stay_resp == null))
				&& !((aCargo.getHospital_stay_resp() != null) && aCargo.getHospital_stay_resp().equals(hospital_stay_resp))) {
			changedAttributeValue.put("hospital_stay_resp", aCargo.getHospital_stay_resp());
		}
		if (!((aCargo.getChild_care_resp() == null) && (child_care_resp == null))
				&& !((aCargo.getChild_care_resp() != null) && aCargo.getChild_care_resp().equals(child_care_resp))) {
			changedAttributeValue.put("child_care_resp", aCargo.getChild_care_resp());
		}
		if (!((aCargo.getChild_obligation_resp() == null) && (child_obligation_resp == null))
				&& !((aCargo.getChild_obligation_resp() != null) && aCargo.getChild_obligation_resp().equals(child_obligation_resp))) {
			changedAttributeValue.put("child_obligation_resp", aCargo.getChild_obligation_resp());
		}
		if (!((aCargo.getMedical_bills_resp() == null) && (medical_bills_resp == null))
				&& !((aCargo.getMedical_bills_resp() != null) && aCargo.getMedical_bills_resp().equals(medical_bills_resp))) {
			changedAttributeValue.put("medical_bills_resp", aCargo.getMedical_bills_resp());
		}
		
		if (!((aCargo.getMedtyp_dental() == null) && (medtyp_dental == null))
				&& !((aCargo.getMedtyp_dental() != null) && aCargo.getMedtyp_dental().equals(medtyp_dental))) {
			changedAttributeValue.put("medtyp_dental", aCargo.getMedtyp_dental());
		}
		if (!((aCargo.getMedtyp_attendant_care() == null) && (medtyp_attendant_care == null))
				&& !((aCargo.getMedtyp_attendant_care() != null) && aCargo.getMedtyp_attendant_care().equals(medtyp_attendant_care))) {
			changedAttributeValue.put("medtyp_attendant_care", aCargo.getMedtyp_attendant_care());
		}
		if (!((aCargo.getMedtyp_doctor() == null) && (medtyp_doctor == null))
				&& !((aCargo.getMedtyp_doctor() != null) && aCargo.getMedtyp_doctor().equals(medtyp_doctor))) {
			changedAttributeValue.put("medtyp_doctor", aCargo.getMedtyp_doctor());
		}
		if (!((aCargo.getMedtyp_med_equip() == null) && (medtyp_med_equip == null))
				&& !((aCargo.getMedtyp_med_equip() != null) && aCargo.getMedtyp_med_equip().equals(medtyp_med_equip))) {
			changedAttributeValue.put("medtyp_med_equip", aCargo.getMedtyp_med_equip());
		}
		if (!((aCargo.getMedtyp_hosp_bills() == null) && (medtyp_hosp_bills == null))
				&& !((aCargo.getMedtyp_hosp_bills() != null) && aCargo.getMedtyp_hosp_bills().equals(medtyp_hosp_bills))) {
			changedAttributeValue.put("medtyp_hosp_bills", aCargo.getMedtyp_hosp_bills());
		}
		if (!((aCargo.getMedtyp_insur_premium() == null) && (medtyp_insur_premium == null))
				&& !((aCargo.getMedtyp_insur_premium() != null) && aCargo.getMedtyp_insur_premium().equals(medtyp_insur_premium))) {
			changedAttributeValue.put("medtyp_insur_premium", aCargo.getMedtyp_insur_premium());
		}
		if (!((aCargo.getMedtyp_rx_cost() == null) && (medtyp_rx_cost == null))
				&& !((aCargo.getMedtyp_rx_cost() != null) && aCargo.getMedtyp_rx_cost().equals(medtyp_rx_cost))) {
			changedAttributeValue.put("medtyp_rx_cost", aCargo.getMedtyp_rx_cost());
		}
		if (!((aCargo.getMedtyp_trans_med() == null) && (medtyp_trans_med == null))
				&& !((aCargo.getMedtyp_trans_med() != null) && aCargo.getMedtyp_trans_med().equals(medtyp_trans_med))) {
			changedAttributeValue.put("medtyp_trans_med", aCargo.getMedtyp_trans_med());	
		}
		if (!((aCargo.getMedtyp_other() == null) && (medtyp_other == null))
				&& !((aCargo.getMedtyp_other() != null) && aCargo.getMedtyp_other().equals(medtyp_other))) {
			changedAttributeValue.put("medtyp_other", aCargo.getMedtyp_other());
		}
		if (!((aCargo.getHospice_resp() == null) && (hospice_resp == null))
				&& !((aCargo.getHospice_resp() != null) && aCargo.getHospice_resp().equals(hospice_resp))) {
			changedAttributeValue.put("hospice_resp", aCargo.getHospice_resp());
		}
		if (!((aCargo.getOutstate_bnft_resp() == null) && (outstate_bnft_resp == null))
				&& !((aCargo.getOutstate_bnft_resp() != null) && aCargo.getOutstate_bnft_resp().equals(outstate_bnft_resp))) {
			changedAttributeValue.put("outstate_bnft_resp", aCargo.getOutstate_bnft_resp());
		}
		if (!((aCargo.getVeh_aset_unlic_resp() == null) && (veh_aset_unlic_resp == null))
				&& !((aCargo.getVeh_aset_unlic_resp() != null) && aCargo.getVeh_aset_unlic_resp().equals(veh_aset_unlic_resp))) {
			changedAttributeValue.put("veh_aset_unlic_resp", aCargo.getVeh_aset_unlic_resp());
		}
		if (!((aCargo.getUnpaid_medbill() == null) && (unpaid_medbill == null))
				&& !((aCargo.getUnpaid_medbill() != null) && aCargo.getUnpaid_medbill().equals(unpaid_medbill))) {
			changedAttributeValue.put("unpaid_medbill", aCargo.getUnpaid_medbill());
		}
		if (!((aCargo.getReal_asset_rental_resp() == null) && (real_asset_rental_resp == null))
				&& !((aCargo.getReal_asset_rental_resp() != null) && aCargo.getReal_asset_rental_resp().equals(real_asset_rental_resp))) {
				changedAttributeValue.put("real_asset_rental_resp", aCargo.getReal_asset_rental_resp());
		}
		if (!((aCargo.getReal_aset_vac_resp() == null) && (real_aset_vac_resp == null))
				&& !((aCargo.getReal_aset_vac_resp() != null) && aCargo.getReal_aset_vac_resp().equals(real_aset_vac_resp))) {
			changedAttributeValue.put("real_aset_vac_resp", aCargo.getReal_aset_vac_resp());
		}
		if (!((aCargo.getReal_asset_house_resp() == null) && (real_asset_house_resp == null))
				&& !((aCargo.getReal_asset_house_resp() != null) && aCargo.getReal_asset_house_resp().equals(real_asset_house_resp))) {
			changedAttributeValue.put("real_asset_house_resp", aCargo.getReal_asset_house_resp());
		}
		if (!((aCargo.getReal_asset_life_estate_resp() == null) && (real_asset_life_estate_resp == null))
				&& !((aCargo.getReal_asset_life_estate_resp() != null) && aCargo.getReal_asset_life_estate_resp().equals(real_asset_life_estate_resp))) {
			changedAttributeValue.put("real_asset_life_estate_resp", aCargo.getReal_asset_life_estate_resp());
		}
		if (!((aCargo.getReal_asset_other_resp() == null) && (real_asset_other_resp == null))
				&& !((aCargo.getReal_asset_other_resp() != null) && aCargo.getReal_asset_other_resp().equals(real_asset_other_resp))) {
			changedAttributeValue.put("real_asset_other_resp", aCargo.getReal_asset_other_resp());
		}
		if (!((aCargo.getReal_asset_mobile_home_resp() == null) && (real_asset_mobile_home_resp == null))
				&& !((aCargo.getReal_asset_mobile_home_resp() != null) && aCargo.getReal_asset_mobile_home_resp().equals(real_asset_mobile_home_resp))) {
			changedAttributeValue.put("real_asset_mobile_home_resp", aCargo.getReal_asset_mobile_home_resp());
		}
		if (!((aCargo.getReal_asset_land_resp() == null) && (real_asset_land_resp == null))
				&& !((aCargo.getReal_asset_land_resp() != null) && aCargo.getReal_asset_land_resp().equals(real_asset_land_resp))) {
			changedAttributeValue.put("real_asset_land_resp", aCargo.getReal_asset_land_resp());
		}
		if (!((aCargo.getReal_aset_frm_resp() == null) && (real_aset_frm_resp == null))
				&& !((aCargo.getReal_aset_frm_resp() != null) && aCargo.getReal_aset_frm_resp().equals(real_aset_frm_resp))) {
			changedAttributeValue.put("real_aset_frm_resp", aCargo.getReal_aset_frm_resp());
		}
		if (!((aCargo.getReal_aset_dup_resp() == null) && (real_aset_dup_resp == null))
				&& !((aCargo.getReal_aset_dup_resp() != null) && aCargo.getReal_aset_dup_resp().equals(real_aset_dup_resp))) {
			changedAttributeValue.put("real_aset_dup_resp", aCargo.getReal_aset_dup_resp());
		}
		if (!((aCargo.getReal_aset_con_resp() == null) && (real_aset_con_resp == null))
				&& !((aCargo.getReal_aset_con_resp() != null) && aCargo.getReal_aset_con_resp().equals(real_aset_con_resp))) {
			changedAttributeValue.put("real_aset_con_resp", aCargo.getReal_aset_con_resp());
		}
		if (!((aCargo.getReal_aset_apt_resp() == null) && (real_aset_apt_resp == null))
				&& !((aCargo.getReal_aset_apt_resp() != null) && aCargo.getReal_aset_apt_resp().equals(real_aset_apt_resp))) {
			changedAttributeValue.put("real_aset_apt_resp", aCargo.getReal_aset_apt_resp());
		}
		if (!((aCargo.getReal_asset_unoccupy_home_resp() == null) && (real_asset_unoccupy_home_resp == null))
				&& !((aCargo.getReal_asset_unoccupy_home_resp() != null) && aCargo.getReal_asset_unoccupy_home_resp().equals(
						real_asset_unoccupy_home_resp))) {
			changedAttributeValue.put("real_asset_unoccupy_home_resp", aCargo.getReal_asset_unoccupy_home_resp());
		}
		if (!((aCargo.getSpecial_need_resp() == null) && (special_need_resp == null))
				&& !((aCargo.getSpecial_need_resp() != null) && aCargo.getSpecial_need_resp().equals(special_need_resp))) {
			changedAttributeValue.put("special_need_resp", aCargo.getSpecial_need_resp());
		}

		if (!((aCargo.getFoster_care_resp() == null) && (foster_care_resp == null))
				&& !((aCargo.getFoster_care_resp() != null) && aCargo.getFoster_care_resp().equals(foster_care_resp))) {
			changedAttributeValue.put("foster_care_resp", aCargo.getFoster_care_resp());
		}

		if (!((aCargo.getFormer_foster_resp() == null) && (former_foster_resp == null))
				&& !((aCargo.getFormer_foster_resp() != null) && aCargo.getFormer_foster_resp().equals(former_foster_resp))) {
			changedAttributeValue.put("former_foster_resp", aCargo.getFormer_foster_resp());
		}

		if (!((aCargo.getChild_protective_resp() == null) && (child_protective_resp == null))
				&& !((aCargo.getChild_protective_resp() != null) && aCargo.getChild_protective_resp().equals(child_protective_resp))) {
			changedAttributeValue.put("child_protective_resp", aCargo.getChild_protective_resp());
		}

		if (!((aCargo.getLiving_prog_resp() == null) && (living_prog_resp == null))
				&& !((aCargo.getLiving_prog_resp() != null) && aCargo.getLiving_prog_resp().equals(living_prog_resp))) {
			changedAttributeValue.put("living_prog_resp", aCargo.getLiving_prog_resp());
		}

		if (!((aCargo.getGrand_parent_resp() == null) && (grand_parent_resp == null))
				&& !((aCargo.getGrand_parent_resp() != null) && aCargo.getGrand_parent_resp().equals(grand_parent_resp))) {
			changedAttributeValue.put("grand_parent_resp", aCargo.getGrand_parent_resp());
		}

		if (!((aCargo.getDrug_felonies_resp() == null) && (drug_felonies_resp == null))
				&& !((aCargo.getDrug_felonies_resp() != null) && aCargo.getDrug_felonies_resp().equals(drug_felonies_resp))) {
			changedAttributeValue.put("drug_felonies_resp", aCargo.getDrug_felonies_resp());
		}

		if (!((aCargo.getSnap_tanf_disc_resp() == null) && (snap_tanf_disc_resp == null))
				&& !((aCargo.getSnap_tanf_disc_resp() != null) && aCargo.getSnap_tanf_disc_resp().equals(snap_tanf_disc_resp))) {
			changedAttributeValue.put("snap_tanf_disc_resp", aCargo.getSnap_tanf_disc_resp());
		}

		if (!((aCargo.getAvoid_prosc_resp() == null) && (avoid_prosc_resp == null))
				&& !((aCargo.getAvoid_prosc_resp() != null) && aCargo.getAvoid_prosc_resp().equals(avoid_prosc_resp))) {
			changedAttributeValue.put("avoid_prosc_resp", aCargo.getAvoid_prosc_resp());
		}

		if (!((aCargo.getViolating_parole_resp() == null) && (violating_parole_resp == null))
				&& !((aCargo.getViolating_parole_resp() != null) && aCargo.getViolating_parole_resp().equals(violating_parole_resp))) {
			changedAttributeValue.put("violating_parole_resp", aCargo.getViolating_parole_resp());
		}

		if (!((aCargo.getConvic_false_info_resp() == null) && (convic_false_info_resp == null))
				&& !((aCargo.getConvic_false_info_resp() != null) && aCargo.getConvic_false_info_resp().equals(convic_false_info_resp))) {
			changedAttributeValue.put("convic_false_info_resp", aCargo.getConvic_false_info_resp());
		}

		if (!((aCargo.getVoluntarily_quit_job_resp() == null) && (voluntarily_quit_job_resp == null))
				&& !((aCargo.getVoluntarily_quit_job_resp() != null) && aCargo.getVoluntarily_quit_job_resp().equals(voluntarily_quit_job_resp))) {
			changedAttributeValue.put("voluntarily_quit_job_resp", aCargo.getVoluntarily_quit_job_resp());
		}

		if (!((aCargo.getTrading_snap_resp() == null) && (trading_snap_resp == null))
				&& !((aCargo.getTrading_snap_resp() != null) && aCargo.getTrading_snap_resp().equals(trading_snap_resp))) {
			changedAttributeValue.put("trading_snap_resp", aCargo.getTrading_snap_resp());
		}

		if (!((aCargo.getBuy_sell_snap_resp() == null) && (buy_sell_snap_resp == null))
				&& !((aCargo.getBuy_sell_snap_resp() != null) && aCargo.getBuy_sell_snap_resp().equals(buy_sell_snap_resp))) {
			changedAttributeValue.put("buy_sell_snap_resp", aCargo.getBuy_sell_snap_resp());
		}

		if (!((aCargo.getTrade_snap_gun_resp() == null) && (trade_snap_gun_resp == null))
				&& !((aCargo.getTrade_snap_gun_resp() != null) && aCargo.getTrade_snap_gun_resp().equals(trade_snap_gun_resp))) {
			changedAttributeValue.put("trade_snap_gun_resp", aCargo.getTrade_snap_gun_resp());
		}

		if (!((aCargo.getPrev_ssi_resp() == null) && (prev_ssi_resp == null))
				&& !((aCargo.getPrev_ssi_resp() != null) && aCargo.getPrev_ssi_resp().equals(prev_ssi_resp))) {
			changedAttributeValue.put("prev_ssi_resp", aCargo.getPrev_ssi_resp());
		}

		if (!((aCargo.getHome_community_resp() == null) && (home_community_resp == null))
				&& !((aCargo.getHome_community_resp() != null) && aCargo.getHome_community_resp().equals(home_community_resp))) {
			changedAttributeValue.put("home_community_resp", aCargo.getHome_community_resp());
		}

		if (!((aCargo.getTribal_health_resp() == null) && (tribal_health_resp == null))
				&& !((aCargo.getTribal_health_resp() != null) && aCargo.getTribal_health_resp().equals(tribal_health_resp))) {
			changedAttributeValue.put("tribal_health_resp", aCargo.getTribal_health_resp());
		}

		if (!((aCargo.getTribal_eligibility_resp() == null) && (tribal_eligibility_resp == null))
				&& !((aCargo.getTribal_eligibility_resp() != null) && aCargo.getTribal_eligibility_resp().equals(tribal_eligibility_resp))) {
			changedAttributeValue.put("tribal_eligibility_resp", aCargo.getTribal_eligibility_resp());
		}
		if (!((aCargo.getDomestic_violence_resp() == null) && (domestic_violence_resp == null))
				&& !((aCargo.getDomestic_violence_resp() != null) && aCargo.getDomestic_violence_resp().equals(domestic_violence_resp))) {
			changedAttributeValue.put("domestic_violence_resp", aCargo.getDomestic_violence_resp());
		}

		if (!((aCargo.getTanf_eppic_resp() == null) && (tanf_eppic_resp == null))
				&& !((aCargo.getTanf_eppic_resp() != null) && aCargo.getTanf_eppic_resp().equals(tanf_eppic_resp))) {
			changedAttributeValue.put("tanf_eppic_resp", aCargo.getTanf_eppic_resp());
		}

		if (!((aCargo.getEmergency_medical_resp() == null) && (emergency_medical_resp == null))
				&& !((aCargo.getEmergency_medical_resp() != null) && aCargo.getEmergency_medical_resp().equals(emergency_medical_resp))) {
			changedAttributeValue.put("emergency_medical_resp", aCargo.getEmergency_medical_resp());
		}
		if (!((aCargo.getMedtyp_hsa_contrib() == null) && (medtyp_hsa_contrib == null))
				&& !((aCargo.getMedtyp_hsa_contrib() != null) && aCargo.getMedtyp_hsa_contrib().equals(emergency_medical_resp))) {
			changedAttributeValue.put("medtyp_hsa_contrib", aCargo.getMedtyp_hsa_contrib());
		}
		
		if (!((aCargo.getPers_prop_bus_eqpt() == null) && (pers_prop_bus_eqpt == null))
				&& !((aCargo.getPers_prop_bus_eqpt() != null) && aCargo.getPers_prop_bus_eqpt().equals(pers_prop_bus_eqpt))) {
			changedAttributeValue.put("pers_prop_bus_eqpt", aCargo.getPers_prop_bus_eqpt());
		}
		if (!((aCargo.getPers_prop_cemetary_lot() == null) && (pers_prop_cemetary_lot == null))
				&& !((aCargo.getPers_prop_cemetary_lot() != null) && aCargo.getPers_prop_cemetary_lot().equals(pers_prop_cemetary_lot))) {
			changedAttributeValue.put("pers_prop_cemetary_lot", aCargo.getPers_prop_cemetary_lot());
		}
		if (!((aCargo.getPers_prop_livestock() == null) && (pers_prop_livestock == null))
				&& !((aCargo.getPers_prop_livestock() != null) && aCargo.getPers_prop_livestock().equals(pers_prop_livestock))) {
			changedAttributeValue.put("pers_prop_livestock", aCargo.getPers_prop_livestock());
		}
		if (!((aCargo.getPers_prop_saf_depst_box() == null) && (pers_prop_saf_depst_box == null))
				&& !((aCargo.getPers_prop_saf_depst_box() != null) && aCargo.getPers_prop_saf_depst_box().equals(pers_prop_saf_depst_box))) {
			changedAttributeValue.put("pers_prop_saf_depst_box", aCargo.getPers_prop_saf_depst_box());
		}
		if (!((aCargo.getPers_prop_oth_val() == null) && (pers_prop_oth_val == null))
				&& !((aCargo.getPers_prop_oth_val() != null) && aCargo.getPers_prop_oth_val().equals(pers_prop_oth_val))) {
			changedAttributeValue.put("pers_prop_oth_val", aCargo.getPers_prop_oth_val());
		}

		//Added by Srividhya 16Mar15 for RMC5 pregnancy changes
		if (!((aCargo.getAble_to_conceive_resp() == null) && (able_to_conceive_resp == null))
				&& !((aCargo.getAble_to_conceive_resp() != null) && aCargo.getAble_to_conceive_resp().equals(able_to_conceive_resp))) {
			changedAttributeValue.put("able_to_conceive_resp", aCargo.getAble_to_conceive_resp());
		}
		if (!((aCargo.getUnderweight_birth_resp() == null) && (underweight_birth_resp == null))
				&& !((aCargo.getUnderweight_birth_resp() != null) && aCargo.getUnderweight_birth_resp().equals(underweight_birth_resp))) {
			changedAttributeValue.put("underweight_birth_resp", aCargo.getUnderweight_birth_resp());
		}
		if (!((aCargo.getPreg_add_stat_sw() == null) && (preg_add_stat_sw == null))
				&& !((aCargo.getPreg_add_stat_sw() != null) && aCargo.getPreg_add_stat_sw().equals(preg_add_stat_sw))) {
			changedAttributeValue.put("preg_add_stat_sw", aCargo.getPreg_add_stat_sw());
		}
		if (!((aCargo.getPreg_chg_stat_sw() == null) && (preg_chg_stat_sw == null))
				&& !((aCargo.getPreg_chg_stat_sw() != null) && aCargo.getPreg_chg_stat_sw().equals(preg_chg_stat_sw))) {
			changedAttributeValue.put("preg_chg_stat_sw", aCargo.getPreg_chg_stat_sw());
		}
		if (!((aCargo.getPrsn_info_stat_sw() == null) && (prsn_info_stat_sw == null))
				&& !((aCargo.getPrsn_info_stat_sw() != null) && aCargo.getPrsn_info_stat_sw().equals(prsn_info_stat_sw))) {
			changedAttributeValue.put("prsn_info_stat_sw", aCargo.getPrsn_info_stat_sw());
		}
		if (!((aCargo.getRlt_chg_stat_sw() == null) && (rlt_chg_stat_sw == null))
				&& !((aCargo.getRlt_chg_stat_sw() != null) && aCargo.getRlt_chg_stat_sw().equals(rlt_chg_stat_sw))) {
			changedAttributeValue.put("rlt_chg_stat_sw", aCargo.getRlt_chg_stat_sw());
		}
		
		if (!((aCargo.getHousing_bill_others_resp() == null) && (housing_bill_others_resp == null))
				&& !((aCargo.getHousing_bill_others_resp() != null) && aCargo.getHousing_bill_others_resp().equals(housing_bill_others_resp))) {
			changedAttributeValue.put("housing_bill_others_resp", aCargo.getHousing_bill_others_resp());
		}
		if (!((aCargo.getPrevent_eviction_resp() == null) && (prevent_eviction_resp == null))
				&& !((aCargo.getPrevent_eviction_resp() != null) && aCargo.getPrevent_eviction_resp().equals(prevent_eviction_resp))) {
			changedAttributeValue.put("prevent_eviction_resp", aCargo.getPrevent_eviction_resp());
		}
		if (!((aCargo.getDisaster_repair_resp() == null) && (disaster_repair_resp == null))
				&& !((aCargo.getDisaster_repair_resp() != null) && aCargo.getDisaster_repair_resp().equals(disaster_repair_resp))) {
			changedAttributeValue.put("disaster_repair_resp", aCargo.getDisaster_repair_resp());
		}
		if (!((aCargo.getOther_housing_bill_resp() == null) && (other_housing_bill_resp == null))
				&& !((aCargo.getOther_housing_bill_resp() != null) && aCargo.getOther_housing_bill_resp().equals(other_housing_bill_resp))) {
			changedAttributeValue.put("other_housing_bill_resp", aCargo.getOther_housing_bill_resp());
		}
		if (!((aCargo.getSu_cst_ins_resp() == null) && (su_cst_ins_resp == null))
				&& !((aCargo.getSu_cst_ins_resp() != null) && aCargo.getSu_cst_ins_resp().equals(su_cst_ins_resp))) {
			changedAttributeValue.put("su_cst_ins_resp", aCargo.getSu_cst_ins_resp());
		}
		if (!((aCargo.getOthr_incm_trbl_resp() == null) && (othr_incm_trbl_resp == null))
				&& !((aCargo.getOthr_incm_trbl_resp() != null) && aCargo.getOthr_incm_trbl_resp().equals(othr_incm_trbl_resp))) {
			changedAttributeValue.put("othr_incm_trbl_resp", aCargo.getOthr_incm_trbl_resp());
		}
		if (!((aCargo.getCareTaker_resp() == null) && (careTaker_resp == null))
				&& !((aCargo.getCareTaker_resp() != null) && aCargo.getCareTaker_resp().equals(careTaker_resp))) {
			changedAttributeValue.put("careTaker_resp", aCargo.getCareTaker_resp());
		}
		if (!((aCargo.getLost_health_ins_ind() == null) && (lost_health_ins_ind == null))
				&& !((aCargo.getLost_health_ins_ind() != null) && aCargo.getLost_health_ins_ind().equals(lost_health_ins_ind))) {
			changedAttributeValue.put("lost_health_ins_ind", aCargo.getLost_health_ins_ind());
		}
		if (!((aCargo.getTax_claim_dependant_resp() == null) && (tax_claim_dependant_resp == null))
				&& !((aCargo.getTax_claim_dependant_resp() != null) && aCargo.getTax_claim_dependant_resp().equals(tax_claim_dependant_resp))) {
			changedAttributeValue.put("tax_claim_dependant_resp", aCargo.getTax_claim_dependant_resp());
		}
		if (!((aCargo.getBefore_tax_deduction_resp() == null) && (before_tax_deduction_resp == null))
				&& !((aCargo.getBefore_tax_deduction_resp() != null) && aCargo.getBefore_tax_deduction_resp().equals(before_tax_deduction_resp))) {
			changedAttributeValue.put("before_tax_deduction_resp", aCargo.getBefore_tax_deduction_resp());
		}
		if (!((aCargo.getBtd_med_ins() == null) && (btd_med_ins == null))
				&& !((aCargo.getBtd_med_ins() != null) && aCargo.getBtd_med_ins().equals(btd_med_ins))) {
			changedAttributeValue.put("btd_med_ins", aCargo.getBtd_med_ins());
		}
		if (!((aCargo.getBtd_dent_ins() == null) && (btd_dent_ins == null))
				&& !((aCargo.getBtd_dent_ins() != null) && aCargo.getBtd_dent_ins().equals(btd_dent_ins))) {
			changedAttributeValue.put("btd_dent_ins", aCargo.getBtd_dent_ins());
		}
		if (!((aCargo.getBtd_vis_care_ins() == null) && (btd_vis_care_ins == null))
				&& !((aCargo.getBtd_vis_care_ins() != null) && aCargo.getBtd_vis_care_ins().equals(btd_vis_care_ins))) {
			changedAttributeValue.put("btd_vis_care_ins", aCargo.getBtd_vis_care_ins());
		}
		if (!((aCargo.getBtd_flex_acc() == null) && (btd_flex_acc == null))
				&& !((aCargo.getBtd_flex_acc() != null) && aCargo.getBtd_flex_acc().equals(btd_flex_acc))) {
			changedAttributeValue.put("btd_flex_acc", aCargo.getBtd_flex_acc());
		}
		if (!((aCargo.getBtd_def_comp() == null) && (btd_def_comp == null))
				&& !((aCargo.getBtd_def_comp() != null) && aCargo.getBtd_def_comp().equals(btd_def_comp))) {
			changedAttributeValue.put("btd_def_comp", aCargo.getBtd_def_comp());
		}
		if (!((aCargo.getBtd_pre_tax_ins() == null) && (btd_pre_tax_ins == null))
				&& !((aCargo.getBtd_pre_tax_ins() != null) && aCargo.getBtd_pre_tax_ins().equals(btd_pre_tax_ins))) {
			changedAttributeValue.put("btd_pre_tax_ins", aCargo.getBtd_pre_tax_ins());
		}
		if (!((aCargo.getBtd_other() == null) && (btd_other == null))
				&& !((aCargo.getBtd_other() != null) && aCargo.getBtd_other().equals(btd_other))) {
			changedAttributeValue.put("btd_other", aCargo.getBtd_other());
		}
		if (!((aCargo.getTax_deduct_resp() == null) && (tax_deduct_resp == null))
				&& !((aCargo.getTax_deduct_resp() != null) && aCargo.getTax_deduct_resp().equals(tax_deduct_resp))) {
			changedAttributeValue.put("tax_deduct_resp", aCargo.getTax_deduct_resp());
		}
		if (!((aCargo.getHlth_ins_resp() == null) && (hlth_ins_resp == null))
				&& !((aCargo.getHlth_ins_resp() != null) && aCargo.getHlth_ins_resp().equals(hlth_ins_resp))) {
			changedAttributeValue.put("hlth_ins_resp", aCargo.getHlth_ins_resp());
		}
		if (!((aCargo.getOthr_hlth_ins_resp() == null) && (othr_hlth_ins_resp == null))
				&& !((aCargo.getOthr_hlth_ins_resp() != null) && aCargo.getOthr_hlth_ins_resp().equals(othr_hlth_ins_resp))) {
			changedAttributeValue.put("othr_hlth_ins_resp", aCargo.getOthr_hlth_ins_resp());
		}
		
		if (!((aCargo.getRoom_brd_chg_ind() == null) && (room_brd_chg_ind == null))
				&& !((aCargo.getRoom_brd_chg_ind() != null) && aCargo.getRoom_brd_chg_ind().equals(room_brd_chg_ind))) {
			changedAttributeValue.put("room_brd_chg_ind", aCargo.getRoom_brd_chg_ind());
		}
		if (!((aCargo.getDabl_stat_ind() == null) && (dabl_stat_ind == null))
				&& !((aCargo.getDabl_stat_ind() != null) && aCargo.getDabl_stat_ind().equals(dabl_stat_ind))) {
			changedAttributeValue.put("dabl_stat_ind", aCargo.getDabl_stat_ind());
		}
		if (!((aCargo.getPreg_add_stat_ind() == null) && (preg_add_stat_ind == null))
				&& !((aCargo.getPreg_add_stat_ind() != null) && aCargo.getPreg_add_stat_ind().equals(preg_add_stat_ind))) {
			changedAttributeValue.put("preg_add_stat_ind", aCargo.getPreg_add_stat_ind());
		}
		if (!((aCargo.getPreg_chg_ind() == null) && (preg_chg_ind == null))
				&& !((aCargo.getPreg_chg_ind() != null) && aCargo.getPreg_chg_ind().equals(preg_chg_ind))) {
			changedAttributeValue.put("preg_chg_ind", aCargo.getPreg_chg_ind());
		}
		if (!((aCargo.getIrwe_chg_ind() == null) && (irwe_chg_ind == null))
				&& !((aCargo.getIrwe_chg_ind() != null) && aCargo.getIrwe_chg_ind().equals(irwe_chg_ind))) {
			changedAttributeValue.put("irwe_chg_ind", aCargo.getIrwe_chg_ind());
		}
		if (!((aCargo.getEi_chg_ind() == null) && (ei_chg_ind == null))
				&& !((aCargo.getEi_chg_ind() != null) && aCargo.getEi_chg_ind().equals(ei_chg_ind))) {
			changedAttributeValue.put("ei_chg_ind", aCargo.getEi_chg_ind());
		}
		if (!((aCargo.getSelf_empl_chg_ind() == null) && (self_empl_chg_ind == null))
				&& !((aCargo.getSelf_empl_chg_ind() != null) && aCargo.getSelf_empl_chg_ind().equals(self_empl_chg_ind))) {
			changedAttributeValue.put("self_empl_chg_ind", aCargo.getSelf_empl_chg_ind());
		}
		if (!((aCargo.getOthr_incm_chg_ind() == null) && (othr_incm_chg_ind == null))
				&& !((aCargo.getOthr_incm_chg_ind() != null) && aCargo.getOthr_incm_chg_ind().equals(othr_incm_chg_ind))) {
			changedAttributeValue.put("othr_incm_chg_ind", aCargo.getOthr_incm_chg_ind());
		}
		if (!((aCargo.getEmpl_chg_ind() == null) && (empl_chg_ind == null))
				&& !((aCargo.getEmpl_chg_ind() != null) && aCargo.getEmpl_chg_ind().equals(empl_chg_ind))) {
			changedAttributeValue.put("empl_chg_ind", aCargo.getEmpl_chg_ind());
		}
		if (!((aCargo.getVeh_aset_add_ind() == null) && (veh_aset_add_ind == null))
				&& !((aCargo.getVeh_aset_add_ind() != null) && aCargo.getVeh_aset_add_ind().equals(veh_aset_add_ind))) {
			changedAttributeValue.put("veh_aset_add_ind", aCargo.getVeh_aset_add_ind());
		}
		if (!((aCargo.getVeh_aset_chg_ind() == null) && (veh_aset_chg_ind == null))
				&& !((aCargo.getVeh_aset_chg_ind() != null) && aCargo.getVeh_aset_chg_ind().equals(veh_aset_chg_ind))) {
			changedAttributeValue.put("veh_aset_chg_ind", aCargo.getVeh_aset_chg_ind());
		}
		if (!((aCargo.getReal_aset_add_ind() == null) && (real_aset_add_ind == null))
				&& !((aCargo.getReal_aset_add_ind() != null) && aCargo.getReal_aset_add_ind().equals(real_aset_add_ind))) {
			changedAttributeValue.put("real_aset_add_ind", aCargo.getReal_aset_add_ind());
		}
		if (!((aCargo.getReal_aset_chg_ind() == null) && (real_aset_chg_ind == null))
				&& !((aCargo.getReal_aset_chg_ind() != null) && aCargo.getReal_aset_chg_ind().equals(real_aset_chg_ind))) {
			changedAttributeValue.put("real_aset_chg_ind", aCargo.getReal_aset_chg_ind());
		}
		if (!((aCargo.getBury_aset_add_ind() == null) && (bury_aset_add_ind == null))
				&& !((aCargo.getBury_aset_add_ind() != null) && aCargo.getBury_aset_add_ind().equals(bury_aset_add_ind))) {
			changedAttributeValue.put("bury_aset_add_ind", aCargo.getBury_aset_add_ind());
		}
		if (!((aCargo.getBury_aset_chg_ind() == null) && (bury_aset_chg_ind == null))
				&& !((aCargo.getBury_aset_chg_ind() != null) && aCargo.getBury_aset_chg_ind().equals(bury_aset_chg_ind))) {
			changedAttributeValue.put("bury_aset_chg_ind", aCargo.getBury_aset_chg_ind());
		}
		if (!((aCargo.getLiquid_asset_add_ind() == null) && (liquid_asset_add_ind == null))
				&& !((aCargo.getLiquid_asset_add_ind() != null) && aCargo.getLiquid_asset_add_ind().equals(liquid_asset_add_ind))) {
			changedAttributeValue.put("liquid_asset_add_ind", aCargo.getLiquid_asset_add_ind());
		}
		if (!((aCargo.getLiquid_asset_bank_acc_chg_ind() == null) && (liquid_asset_bank_acc_chg_ind == null))
				&& !((aCargo.getLiquid_asset_bank_acc_chg_ind() != null) && aCargo.getLiquid_asset_bank_acc_chg_ind().equals(
						liquid_asset_bank_acc_chg_ind))) {
			changedAttributeValue.put("liquid_asset_bank_acc_chg_ind", aCargo.getLiquid_asset_bank_acc_chg_ind());
		}
		if (!((aCargo.getLiquid_asset_cash_chg_ind() == null) && (liquid_asset_cash_chg_ind == null))
				&& !((aCargo.getLiquid_asset_cash_chg_ind() != null) && aCargo.getLiquid_asset_cash_chg_ind().equals(liquid_asset_cash_chg_ind))) {
			changedAttributeValue.put("liquid_asset_cash_chg_ind", aCargo.getLiquid_asset_cash_chg_ind());
		}
		if (!((aCargo.getLiquid_asset_chg_ind() == null) && (liquid_asset_chg_ind == null))
				&& !((aCargo.getLiquid_asset_chg_ind() != null) && aCargo.getLiquid_asset_chg_ind().equals(liquid_asset_chg_ind))) {
			changedAttributeValue.put("liquid_asset_chg_ind", aCargo.getLiquid_asset_chg_ind());
		}
		if (!((aCargo.getLiquid_asset_other_chg_ind() == null) && (liquid_asset_other_chg_ind == null))
				&& !((aCargo.getLiquid_asset_other_chg_ind() != null) && aCargo.getLiquid_asset_other_chg_ind().equals(liquid_asset_other_chg_ind))) {
			changedAttributeValue.put("liquid_asset_other_chg_ind", aCargo.getLiquid_asset_other_chg_ind());
		}
		if (!((aCargo.getLife_ins_aset_add_ind() == null) && (life_ins_aset_add_ind == null))
				&& !((aCargo.getLife_ins_aset_add_ind() != null) && aCargo.getLife_ins_aset_add_ind().equals(life_ins_aset_add_ind))) {
			changedAttributeValue.put("life_ins_aset_add_ind", aCargo.getLife_ins_aset_add_ind());
		}
		if (!((aCargo.getLife_ins_aset_chg_ind() == null) && (life_ins_aset_chg_ind == null))
				&& !((aCargo.getLife_ins_aset_chg_ind() != null) && aCargo.getLife_ins_aset_chg_ind().equals(life_ins_aset_chg_ind))) {
			changedAttributeValue.put("life_ins_aset_chg_ind", aCargo.getLife_ins_aset_chg_ind());
		}
		if (!((aCargo.getAset_xfer_chg_ind() == null) && (aset_xfer_chg_ind == null))
				&& !((aCargo.getAset_xfer_chg_ind() != null) && aCargo.getAset_xfer_chg_ind().equals(aset_xfer_chg_ind))) {
			changedAttributeValue.put("aset_xfer_chg_ind", aCargo.getAset_xfer_chg_ind());
		}
		if (!((aCargo.getDpnd_care_chg_ind() == null) && (dpnd_care_chg_ind == null))
				&& !((aCargo.getDpnd_care_chg_ind() != null) && aCargo.getDpnd_care_chg_ind().equals(dpnd_care_chg_ind))) {
			changedAttributeValue.put("dpnd_care_chg_ind", aCargo.getDpnd_care_chg_ind());
		}
		if (!((aCargo.getHealth_insurance_chg_ind() == null) && (health_insurance_chg_ind == null))
				&& !((aCargo.getHealth_insurance_chg_ind() != null) && aCargo.getHealth_insurance_chg_ind().equals(health_insurance_chg_ind))) {
			changedAttributeValue.put("health_insurance_chg_ind", aCargo.getHealth_insurance_chg_ind());
		}
		if (!((aCargo.getChild_support_payment_chg_ind() == null) && (child_support_payment_chg_ind == null))
				&& !((aCargo.getChild_support_payment_chg_ind() != null) && aCargo.getChild_support_payment_chg_ind().equals(
						child_support_payment_chg_ind))) {
			changedAttributeValue.put("child_support_payment_chg_ind", aCargo.getChild_support_payment_chg_ind());
		}
		if (!((aCargo.getSnap_shelter_standard_exp_ind() == null) && (snap_shelter_standard_exp_ind == null))
				&& !((aCargo.getSnap_shelter_standard_exp_ind() != null) && aCargo.getSnap_shelter_standard_exp_ind().equals(
						snap_shelter_standard_exp_ind))) {
			changedAttributeValue.put("snap_shelter_standard_exp_ind", aCargo.getSnap_shelter_standard_exp_ind());
		}
		if (!((aCargo.getHous_bill_chg_ind() == null) && (hous_bill_chg_ind == null))
				&& !((aCargo.getHous_bill_chg_ind() != null) && aCargo.getHous_bill_chg_ind().equals(hous_bill_chg_ind))) {
			changedAttributeValue.put("hous_bill_chg_ind", aCargo.getHous_bill_chg_ind());
		}
		if (!((aCargo.getAdd_chg_ind() == null) && (add_chg_ind == null))
				&& !((aCargo.getAdd_chg_ind() != null) && aCargo.getAdd_chg_ind().equals(add_chg_ind))) {
			changedAttributeValue.put("add_chg_ind", aCargo.getAdd_chg_ind());
		}
		if (!((aCargo.getPerson_moved_in_stat_ind() == null) && (person_moved_in_stat_ind == null))
				&& !((aCargo.getPerson_moved_in_stat_ind() != null) && aCargo.getPerson_moved_in_stat_ind().equals(person_moved_in_stat_ind))) {
			changedAttributeValue.put("person_moved_in_stat_ind", aCargo.getPerson_moved_in_stat_ind());
		}
		if (!((aCargo.getPerson_moved_out_stat_ind() == null) && (person_moved_out_stat_ind == null))
				&& !((aCargo.getPerson_moved_out_stat_ind() != null) && aCargo.getPerson_moved_out_stat_ind().equals(person_moved_out_stat_ind))) {
			changedAttributeValue.put("person_moved_out_stat_ind", aCargo.getPerson_moved_out_stat_ind());
		}
		if (!((aCargo.getHospice_chg_ind() == null) && (hospice_chg_ind == null))
				&& !((aCargo.getHospice_chg_ind() != null) && aCargo.getHospice_chg_ind().equals(hospice_chg_ind))) {
			changedAttributeValue.put("hospice_chg_ind", aCargo.getHospice_chg_ind());
		}
		if (!((aCargo.getMedicare_chg_ind() == null) && (medicare_chg_ind == null))
				&& !((aCargo.getMedicare_chg_ind() != null) && aCargo.getMedicare_chg_ind().equals(medicare_chg_ind))) {
			changedAttributeValue.put("medicare_chg_ind", aCargo.getMedicare_chg_ind());
		}
		if (!((aCargo.getNcp_chg_ind() == null) && (ncp_chg_ind == null))
				&& !((aCargo.getNcp_chg_ind() != null) && aCargo.getNcp_chg_ind().equals(ncp_chg_ind))) {
			changedAttributeValue.put("ncp_chg_ind", aCargo.getNcp_chg_ind());
		}
		if (!((aCargo.getThird_party_chg_ind() == null) && (third_party_chg_ind == null))
				&& !((aCargo.getThird_party_chg_ind() != null) && aCargo.getThird_party_chg_ind().equals(third_party_chg_ind))) {
			changedAttributeValue.put("third_party_chg_ind", aCargo.getThird_party_chg_ind());
		}
		if (!((aCargo.getHospital_abd_chg_ind() == null) && (hospital_abd_chg_ind == null))
				&& !((aCargo.getHospital_abd_chg_ind() != null) && aCargo.getHospital_abd_chg_ind().equals(hospital_abd_chg_ind))) {
			changedAttributeValue.put("hospital_abd_chg_ind", aCargo.getHospital_abd_chg_ind());
		}
		if (!((aCargo.getPublic_law_abd_chg_ind() == null) && (public_law_abd_chg_ind == null))
				&& !((aCargo.getPublic_law_abd_chg_ind() != null) && aCargo.getPublic_law_abd_chg_ind().equals(public_law_abd_chg_ind))) {
			changedAttributeValue.put("public_law_abd_chg_ind", aCargo.getPublic_law_abd_chg_ind());
		}
		if (!((aCargo.getLiving_argmt_chg_ind() == null) && (living_argmt_chg_ind == null))
				&& !((aCargo.getLiving_argmt_chg_ind() != null) && aCargo.getLiving_argmt_chg_ind().equals(living_argmt_chg_ind))) {
			changedAttributeValue.put("living_argmt_chg_ind", aCargo.getLiving_argmt_chg_ind());
		}
		if (!((aCargo.getOther_program_chg_ind() == null) && (other_program_chg_ind == null))
				&& !((aCargo.getOther_program_chg_ind() != null) && aCargo.getOther_program_chg_ind().equals(other_program_chg_ind))) {
			changedAttributeValue.put("other_program_chg_ind", aCargo.getOther_program_chg_ind());
		}
		if (!((aCargo.getMagi_expense_chg_ind() == null) && (magi_expense_chg_ind == null))
				&& !((aCargo.getMagi_expense_chg_ind() != null) && aCargo.getMagi_expense_chg_ind().equals(magi_expense_chg_ind))) {
			changedAttributeValue.put("magi_expense_chg_ind", aCargo.getMagi_expense_chg_ind());
		}
		
		if (!((aCargo.getTax_info_ind() == null) && (tax_info_ind == null))
				&& !((aCargo.getTax_info_ind() != null) && aCargo.getTax_info_ind().equals(tax_info_ind))) {
			changedAttributeValue.put("tax_info_ind", aCargo.getTax_info_ind());
		}
		if (!((aCargo.getTax_dep_outside_resp() == null) && (tax_dep_outside_resp == null))
				&& !((aCargo.getTax_dep_outside_resp() != null) && aCargo.getTax_dep_outside_resp().equals(tax_dep_outside_resp))) {
			changedAttributeValue.put("tax_dep_outside_resp", aCargo.getTax_dep_outside_resp());
		}
		
		if (!((aCargo.getMedicare_part_a() == null) && (medicare_part_a == null))
				&& !((aCargo.getMedicare_part_a() != null) && aCargo.getMedicare_part_a().equals(medicare_part_a))) {
			changedAttributeValue.put("medicare_part_a", aCargo.getMedicare_part_a());
		}
		
		if (!((aCargo.getMedicare_part_b() == null) && (medicare_part_b == null))
				&& !((aCargo.getMedicare_part_b() != null) && aCargo.getMedicare_part_b().equals(medicare_part_b))) {
			changedAttributeValue.put("medicare_part_b", aCargo.getMedicare_part_b());
		}
		
		if (!((aCargo.getMedicare_part_c() == null) && (medicare_part_c == null))
				&& !((aCargo.getMedicare_part_c() != null) && aCargo.getMedicare_part_c().equals(medicare_part_c))) {
			changedAttributeValue.put("medicare_part_c", aCargo.getMedicare_part_c());
		}
		
		if (!((aCargo.getMedicare_part_d() == null) && (medicare_part_d == null))
				&& !((aCargo.getMedicare_part_d() != null) && aCargo.getMedicare_part_d().equals(medicare_part_d))) {
			changedAttributeValue.put("medicare_part_d", aCargo.getMedicare_part_d());
		}
		
		if (!((aCargo.getCssp_provider_payment() == null) && (cssp_provider_payment == null))
				&& !((aCargo.getCssp_provider_payment() != null) && aCargo.getCssp_provider_payment().equals(cssp_provider_payment))) {
			changedAttributeValue.put("cssp_provider_payment", aCargo.getCssp_provider_payment());
		}
		
		if (!((aCargo.getFuneral_death_expense() == null) && (funeral_death_expense == null))
				&& !((aCargo.getFuneral_death_expense() != null) && aCargo.getFuneral_death_expense().equals(funeral_death_expense))) {
			changedAttributeValue.put("funeral_death_expense", aCargo.getFuneral_death_expense());
		}
		
		if (!((aCargo.getBlind_work_expense() == null) && (blind_work_expense == null))
				&& !((aCargo.getBlind_work_expense() != null) && aCargo.getBlind_work_expense().equals(blind_work_expense))) {
			changedAttributeValue.put("blind_work_expense", aCargo.getBlind_work_expense());
		}
		
		if (!((aCargo.getImpairment_work_expense() == null) && (impairment_work_expense == null))
				&& !((aCargo.getImpairment_work_expense() != null) && aCargo.getImpairment_work_expense().equals(impairment_work_expense))) {
			changedAttributeValue.put("impairment_work_expense", aCargo.getImpairment_work_expense());
		}
		
		if (!((aCargo.getOth_ind_gambl_pmnts() == null) && (oth_ind_gambl_pmnts == null))
				&& !((aCargo.getOth_ind_gambl_pmnts() != null) && aCargo.getOth_ind_gambl_pmnts().equals(oth_ind_gambl_pmnts))) {
			changedAttributeValue.put("oth_ind_gambl_pmnts", aCargo.getOth_ind_gambl_pmnts());
		}
		
		// Started here
		
		if (!((aCargo.getIncome_from_resource() == null) && (income_from_resource == null))
				&& !((aCargo.getIncome_from_resource() != null) && aCargo.getIncome_from_resource().equals(income_from_resource))) {
			changedAttributeValue.put("income_from_resource", aCargo.getIncome_from_resource());
		}
		
		if (!((aCargo.getIndian_gambling_payments() == null) && (indian_gambling_payments == null))
				&& !((aCargo.getIndian_gambling_payments() != null) && aCargo.getIndian_gambling_payments().equals(indian_gambling_payments))) {
			changedAttributeValue.put("indian_gambling_payments", aCargo.getIndian_gambling_payments());
		}
		
		if (!((aCargo.getInheritance() == null) && (inheritance == null))
				&& !((aCargo.getInheritance() != null) && aCargo.getInheritance().equals(inheritance))) {
			changedAttributeValue.put("inheritance", aCargo.getInheritance());
		}
		
		if (!((aCargo.getInsuance_benefits() == null) && (insuance_benefits == null))
				&& !((aCargo.getInsuance_benefits() != null) && aCargo.getInsuance_benefits().equals(insuance_benefits))) {
			changedAttributeValue.put("insuance_benefits", aCargo.getInsuance_benefits());
		}
		
		if (!((aCargo.getLoan_received() == null) && (loan_received == null))
				&& !((aCargo.getLoan_received() != null) && aCargo.getLoan_received().equals(loan_received))) {
			changedAttributeValue.put("loan_received", aCargo.getLoan_received());
		}
		
		if (!((aCargo.getLoan_repayment_income() == null) && (loan_repayment_income == null))
				&& !((aCargo.getLoan_repayment_income() != null) && aCargo.getLoan_repayment_income().equals(loan_repayment_income))) {
			changedAttributeValue.put("loan_repayment_income", aCargo.getLoan_repayment_income());
		}
		
		if (!((aCargo.getManaged_income() == null) && (managed_income == null))
				&& !((aCargo.getManaged_income() != null) && aCargo.getManaged_income().equals(managed_income))) {
			changedAttributeValue.put("managed_income", aCargo.getManaged_income());
		}
		
		if (!((aCargo.getMatch_grant() == null) && (match_grant == null))
				&& !((aCargo.getMatch_grant() != null) && aCargo.getMatch_grant().equals(match_grant))) {
			changedAttributeValue.put("match_grant", aCargo.getMatch_grant());
		}
		
		if (!((aCargo.getMontgomery_gi_bill() == null) && (montgomery_gi_bill == null))
				&& !((aCargo.getMontgomery_gi_bill() != null) && aCargo.getMontgomery_gi_bill().equals(montgomery_gi_bill))) {
			changedAttributeValue.put("montgomery_gi_bill", aCargo.getMontgomery_gi_bill());
		}
		
		if (!((aCargo.getOut_of_state_public() == null) && (out_of_state_public == null))
				&& !((aCargo.getOut_of_state_public() != null) && aCargo.getOut_of_state_public().equals(out_of_state_public))) {
			changedAttributeValue.put("out_of_state_public", aCargo.getOut_of_state_public());
		}
		
		if (!((aCargo.getRefunds_from_dch() == null) && (refunds_from_dch == null))
				&& !((aCargo.getRefunds_from_dch() != null) && aCargo.getRefunds_from_dch().equals(refunds_from_dch))) {
			changedAttributeValue.put("refunds_from_dch", aCargo.getRefunds_from_dch());
		}
		
		if (!((aCargo.getRestitutions_settlements() == null) && (restitutions_settlements == null))
				&& !((aCargo.getRestitutions_settlements() != null) && aCargo.getRestitutions_settlements().equals(restitutions_settlements))) {
			changedAttributeValue.put("restitutions_settlements", aCargo.getRestitutions_settlements());
		}
		
		if (!((aCargo.getSenior_companion() == null) && (senior_companion == null))
				&& !((aCargo.getSenior_companion() != null) && aCargo.getSenior_companion().equals(senior_companion))) {
			changedAttributeValue.put("senior_companion", aCargo.getSenior_companion());
		}
		
		if (!((aCargo.getSeverance_pay() == null) && (severance_pay == null))
				&& !((aCargo.getSeverance_pay() != null) && aCargo.getSeverance_pay().equals(severance_pay))) {
			changedAttributeValue.put("severance_pay", aCargo.getSeverance_pay());
		}
		
		if (!((aCargo.getStrike_benefits() == null) && (strike_benefits == null))
				&& !((aCargo.getStrike_benefits() != null) && aCargo.getStrike_benefits().equals(strike_benefits))) {
			changedAttributeValue.put("strike_benefits", aCargo.getStrike_benefits());
		}
		
		if (!((aCargo.getTrade_readjustment() == null) && (trade_readjustment == null))
				&& !((aCargo.getTrade_readjustment() != null) && aCargo.getTrade_readjustment().equals(trade_readjustment))) {
			changedAttributeValue.put("trade_readjustment", aCargo.getTrade_readjustment());
		}
		
		if (!((aCargo.getUniform_relocation() == null) && (uniform_relocation == null))
				&& !((aCargo.getUniform_relocation() != null) && aCargo.getUniform_relocation().equals(uniform_relocation))) {
			changedAttributeValue.put("uniform_relocation", aCargo.getUniform_relocation());
		}
		
		if (!((aCargo.getUnion_funds() == null) && (union_funds == null))
				&& !((aCargo.getUnion_funds() != null) && aCargo.getUnion_funds().equals(union_funds))) {
			changedAttributeValue.put("union_funds", aCargo.getUnion_funds());
		}
		
		if (!((aCargo.getVendor_excluded() == null) && (vendor_excluded == null))
				&& !((aCargo.getVendor_excluded() != null) && aCargo.getVendor_excluded().equals(vendor_excluded))) {
			changedAttributeValue.put("vendor_excluded", aCargo.getVendor_excluded());
		}
		
		if (!((aCargo.getVictim_restitution() == null) && (victim_restitution == null))
				&& !((aCargo.getVictim_restitution() != null) && aCargo.getVictim_restitution().equals(victim_restitution))) {
			changedAttributeValue.put("victim_restitution", aCargo.getVictim_restitution());
		}
		
		if (!((aCargo.getVolunteer_payment() == null) && (volunteer_payment == null))
				&& !((aCargo.getVolunteer_payment() != null) && aCargo.getVolunteer_payment().equals(volunteer_payment))) {
			changedAttributeValue.put("volunteer_payment", aCargo.getVolunteer_payment());
		}
		
		if (!((aCargo.getVolunteer_payment_titlei() == null) && (volunteer_payment_titlei == null))
				&& !((aCargo.getVolunteer_payment_titlei() != null) && aCargo.getVolunteer_payment_titlei().equals(volunteer_payment_titlei))) {
			changedAttributeValue.put("volunteer_payment_titlei", aCargo.getVolunteer_payment_titlei());
		}
		
		if (!((aCargo.getWia_training_and_allowance() == null) && (wia_training_and_allowance == null))
				&& !((aCargo.getWia_training_and_allowance() != null) && aCargo.getWia_training_and_allowance().equals(wia_training_and_allowance))) {
			changedAttributeValue.put("wia_training_and_allowance", aCargo.getWia_training_and_allowance());
		}
		
		if (!((aCargo.getIncluded_unearned_income() == null) && (included_unearned_income == null))
				&& !((aCargo.getIncluded_unearned_income() != null) && aCargo.getIncluded_unearned_income().equals(included_unearned_income))) {
			changedAttributeValue.put("included_unearned_income", aCargo.getIncluded_unearned_income());
		}
		
		if (!((aCargo.getTanf_max_au_allotment() == null) && (tanf_max_au_allotment == null))
				&& !((aCargo.getTanf_max_au_allotment() != null) && aCargo.getTanf_max_au_allotment().equals(tanf_max_au_allotment))) {
			changedAttributeValue.put("tanf_max_au_allotment", aCargo.getTanf_max_au_allotment());
		}
		
		if (!((aCargo.getTanf_max_grg_allotment() == null) && (tanf_max_grg_allotment == null))
				&& !((aCargo.getTanf_max_grg_allotment() != null) && aCargo.getTanf_max_grg_allotment().equals(tanf_max_grg_allotment))) {
			changedAttributeValue.put("tanf_max_grg_allotment", aCargo.getTanf_max_grg_allotment());
		}
		
		if (!((aCargo.getCharitable_donation() == null) && (charitable_donation == null))
				&& !((aCargo.getCharitable_donation() != null) && aCargo.getCharitable_donation().equals(charitable_donation))) {
			changedAttributeValue.put("charitable_donation", aCargo.getCharitable_donation());
		}
		
		if (!((aCargo.getChild_nutrition_payments() == null) && (child_nutrition_payments == null))
				&& !((aCargo.getChild_nutrition_payments() != null) && aCargo.getChild_nutrition_payments().equals(child_nutrition_payments))) {
			changedAttributeValue.put("child_nutrition_payments", aCargo.getChild_nutrition_payments());
		}
		
		if (!((aCargo.getBlack_lung_benefits() == null) && (black_lung_benefits == null))
				&& !((aCargo.getBlack_lung_benefits() != null) && aCargo.getBlack_lung_benefits().equals(black_lung_benefits))) {
			changedAttributeValue.put("black_lung_benefits", aCargo.getBlack_lung_benefits());
		}
		
		if (!((aCargo.getChild_support_court() == null) && (child_support_court == null))
				&& !((aCargo.getChild_support_court() != null) && aCargo.getChild_support_court().equals(child_support_court))) {
			changedAttributeValue.put("child_support_court", aCargo.getChild_support_court());
		}
		
		if (!((aCargo.getChild_support_gap_payment() == null) && (child_support_gap_payment == null))
				&& !((aCargo.getChild_support_gap_payment() != null) && aCargo.getChild_support_gap_payment().equals(child_support_gap_payment))) {
			changedAttributeValue.put("child_support_gap_payment", aCargo.getChild_support_gap_payment());
		}
		
		if (!((aCargo.getCivil_service() == null) && (civil_service == null))
				&& !((aCargo.getCivil_service() != null) && aCargo.getCivil_service().equals(civil_service))) {
			changedAttributeValue.put("civil_service", aCargo.getCivil_service());
		}
		
		if (!((aCargo.getDeferred_compensation_plans() == null) && (deferred_compensation_plans == null))
				&& !((aCargo.getDeferred_compensation_plans() != null) && aCargo.getDeferred_compensation_plans().equals(deferred_compensation_plans))) {
			changedAttributeValue.put("deferred_compensation_plans", aCargo.getDeferred_compensation_plans());
		}
		
		if (!((aCargo.getDisability_insurance() == null) && (disability_insurance == null))
				&& !((aCargo.getDisability_insurance() != null) && aCargo.getDisability_insurance().equals(disability_insurance))) {
			changedAttributeValue.put("disability_insurance", aCargo.getDisability_insurance());
		}
		
		if (!((aCargo.getExcluded_unearned_income() == null) && (excluded_unearned_income == null))
				&& !((aCargo.getExcluded_unearned_income() != null) && aCargo.getExcluded_unearned_income().equals(excluded_unearned_income))) {
			changedAttributeValue.put("excluded_unearned_income", aCargo.getExcluded_unearned_income());
		}
		
		if (!((aCargo.getFema_payment_disaster() == null) && (fema_payment_disaster == null))
				&& !((aCargo.getFema_payment_disaster() != null) && aCargo.getFema_payment_disaster().equals(fema_payment_disaster))) {
			changedAttributeValue.put("fema_payment_disaster", aCargo.getFema_payment_disaster());
		}
		
		if (!((aCargo.getFema_payment_non_disaster() == null) && (fema_payment_non_disaster == null))
				&& !((aCargo.getFema_payment_non_disaster() != null) && aCargo.getFema_payment_non_disaster().equals(fema_payment_non_disaster))) {
			changedAttributeValue.put("fema_payment_non_disaster", aCargo.getFema_payment_non_disaster());
		}
		
		if (!((aCargo.getHealth_savings_account() == null) && (health_savings_account == null))
				&& !((aCargo.getHealth_savings_account() != null) && aCargo.getHealth_savings_account().equals(health_savings_account))) {
			changedAttributeValue.put("health_savings_account", aCargo.getHealth_savings_account());
		}
		
		if (!((aCargo.getIn_kind_support() == null) && (in_kind_support == null))
				&& !((aCargo.getIn_kind_support() != null) && aCargo.getIn_kind_support().equals(in_kind_support))) {
			changedAttributeValue.put("in_kind_support", aCargo.getIn_kind_support());
		}
		
		if (!((aCargo.getFoster_grandparent_program() == null) && (foster_grandparent_program == null))
				&& !((aCargo.getFoster_grandparent_program() != null) && aCargo.getFoster_grandparent_program().equals(foster_grandparent_program))) {
			changedAttributeValue.put("foster_grandparent_program", aCargo.getFoster_grandparent_program());
		}
		
		if (!((aCargo.getDisaster_unemployment() == null) && (disaster_unemployment == null))
				&& !((aCargo.getDisaster_unemployment() != null) && aCargo.getDisaster_unemployment().equals(disaster_unemployment))) {
			changedAttributeValue.put("disaster_unemployment", aCargo.getDisaster_unemployment());
		}
		
		if (!((aCargo.getDividends() == null) && (dividends == null))
				&& !((aCargo.getDividends() != null) && aCargo.getDividends().equals(dividends))) {
			changedAttributeValue.put("dividends", aCargo.getDividends());
		}
		
		if (!((aCargo.getCharitable_donation_federal() == null) && (charitable_donation_federal == null))
				&& !((aCargo.getCharitable_donation_federal() != null) && aCargo.getCharitable_donation_federal().equals(charitable_donation_federal))) {
			changedAttributeValue.put("charitable_donation_federal", aCargo.getCharitable_donation_federal());
		}
		
		if (!((aCargo.getBonds() == null) && (bonds == null)) && !((aCargo.getBonds() != null) && aCargo.getBonds().equals(bonds))) {
			changedAttributeValue.put("bonds", aCargo.getBonds());
		}
		if (!((aCargo.getDividend() == null) && (dividend == null)) && !((aCargo.getDividend() != null) && aCargo.getDividend().equals(dividend))) {
			changedAttributeValue.put("dividend", aCargo.getDividend());
		}
		if (!((aCargo.getHealth_reimbursement_account() == null) && (health_reimbursement_account == null))
				&& !((aCargo.getHealth_reimbursement_account() != null) && aCargo.getHealth_reimbursement_account().equals(
						health_reimbursement_account))) {
			changedAttributeValue.put("health_reimbursement_account", aCargo.getHealth_reimbursement_account());
		}
		if (!((aCargo.getIndividual_development_account() == null) && (individual_development_account == null))
				&& !((aCargo.getIndividual_development_account() != null) && aCargo.getIndividual_development_account().equals(
						individual_development_account))) {
			changedAttributeValue.put("individual_development_account", aCargo.getIndividual_development_account());
		}
		if (!((aCargo.getUniform_gifts_to_minors() == null) && (uniform_gifts_to_minors == null))
				&& !((aCargo.getUniform_gifts_to_minors() != null) && aCargo.getUniform_gifts_to_minors().equals(uniform_gifts_to_minors))) {
			changedAttributeValue.put("uniform_gifts_to_minors", aCargo.getUniform_gifts_to_minors());
		}
		if (!((aCargo.getInheritance_income() == null) && (inheritance_income == null))
				&& !((aCargo.getInheritance_income() != null) && aCargo.getInheritance_income().equals(inheritance_income))) {
			changedAttributeValue.put("inheritance_income", aCargo.getInheritance_income());
		}
		if (!((aCargo.getPersonal_info() == null) && (personal_info == null))
				&& !((aCargo.getPersonal_info() != null) && aCargo.getPersonal_info().equals(personal_info))) {
			changedAttributeValue.put("personal_info", aCargo.getPersonal_info());
		}
		
		if (!((aCargo.getPatient_fund() == null) && (patient_fund == null))
				&& !((aCargo.getPatient_fund() != null) && aCargo.getPatient_fund().equals(patient_fund))) {
			changedAttributeValue.put("patient_fund", aCargo.getPatient_fund());
		}
		
		if (!((aCargo.getDisaster_assistance() == null) && (disaster_assistance == null))
				&& !((aCargo.getDisaster_assistance() != null) && aCargo.getDisaster_assistance().equals(disaster_assistance))) {
			changedAttributeValue.put("disaster_assistance", aCargo.getDisaster_assistance());
		}
		if (!((aCargo.getNon_business_equipment() == null) && (non_business_equipment == null))
				&& !((aCargo.getNon_business_equipment() != null) && aCargo.getNon_business_equipment().equals(non_business_equipment))) {
			changedAttributeValue.put("non_business_equipment", aCargo.getNon_business_equipment());
		}
		if (!((aCargo.getHousehold_goods() == null) && (household_goods == null))
				&& !((aCargo.getHousehold_goods() != null) && aCargo.getHousehold_goods().equals(household_goods))) {
			changedAttributeValue.put("household_goods", aCargo.getHousehold_goods());
		}
		if (!((aCargo.getOther_non_countable() == null) && (other_non_countable == null))
				&& !((aCargo.getOther_non_countable() != null) && aCargo.getOther_non_countable().equals(other_non_countable))) {
			changedAttributeValue.put("other_non_countable", aCargo.getOther_non_countable());
		}
		if (!((aCargo.getSchl_enrl_chg_ind() == null) && (schl_enrl_chg_ind == null))
				&& !((aCargo.getSchl_enrl_chg_ind() != null) && aCargo.getSchl_enrl_chg_ind().equals(schl_enrl_chg_ind))) {
			changedAttributeValue.put("schl_enrl_chg_ind", aCargo.getSchl_enrl_chg_ind());
		}
		if (!((aCargo.getMrtl_stat_chg_ind() == null) && (mrtl_stat_chg_ind == null))
				&& !((aCargo.getMrtl_stat_chg_ind() != null) && aCargo.getMrtl_stat_chg_ind().equals(mrtl_stat_chg_ind))) {
			changedAttributeValue.put("mrtl_stat_chg_ind", aCargo.getMrtl_stat_chg_ind());
		}
		if (!((aCargo.getNur_hme_chg_ind() == null) && (nur_hme_chg_ind == null))
				&& !((aCargo.getNur_hme_chg_ind() != null) && aCargo.getNur_hme_chg_ind().equals(nur_hme_chg_ind))) {
			changedAttributeValue.put("nur_hme_chg_ind", aCargo.getNur_hme_chg_ind());
		}
		if (!((aCargo.getBfr_tax_chg_ind() == null) && (bfr_tax_chg_ind == null))
				&& !((aCargo.getBfr_tax_chg_ind() != null) && aCargo.getBfr_tax_chg_ind().equals(bfr_tax_chg_ind))) {
			changedAttributeValue.put("bfr_tax_chg_ind", aCargo.getBfr_tax_chg_ind());
		}
		if (!((aCargo.getInc_tax_chg_ind() == null) && (inc_tax_chg_ind == null))
				&& !((aCargo.getInc_tax_chg_ind() != null) && aCargo.getInc_tax_chg_ind().equals(inc_tax_chg_ind))) {
			changedAttributeValue.put("inc_tax_chg_ind", aCargo.getInc_tax_chg_ind());
		}
		if (!((aCargo.getThrd_prty_chg_ind() == null) && (thrd_prty_chg_ind == null))
				&& !((aCargo.getThrd_prty_chg_ind() != null) && aCargo.getThrd_prty_chg_ind().equals(thrd_prty_chg_ind))) {
			changedAttributeValue.put("thrd_prty_chg_ind", aCargo.getThrd_prty_chg_ind());
		}
		if (!((aCargo.getDeath_benefit_state_federal() == null) && (death_benefit_state_federal == null))
				&& !((aCargo.getDeath_benefit_state_federal() != null) && aCargo.getDeath_benefit_state_federal().equals(death_benefit_state_federal))) {
			changedAttributeValue.put("death_benefit_state_federal", aCargo.getDeath_benefit_state_federal());
		}
		if (!((aCargo.getSocial_security_survivor() == null) && (social_security_survivor == null))
				&& !((aCargo.getSocial_security_survivor() != null) && aCargo.getSocial_security_survivor().equals(social_security_survivor))) {
			changedAttributeValue.put("social_security_survivor", aCargo.getSocial_security_survivor());
		}
		if (!((aCargo.getVendor_payments() == null) && (vendor_payments == null))
				&& !((aCargo.getVendor_payments() != null) && aCargo.getVendor_payments().equals(vendor_payments))) {
			changedAttributeValue.put("vendor_payments", aCargo.getVendor_payments());
		}
		if (!(aCargo.getCitizenship_chg_ind() == null && citizenship_chg_ind == null)
				&& !(aCargo.getCitizenship_chg_ind() != null && aCargo.getCitizenship_chg_ind().equals(citizenship_chg_ind))){
			changedAttributeValue.put("citizenship_chg_ind", aCargo.getCitizenship_chg_ind());
		}
		if (!(aCargo.getDemographics_chg_ind() == null && demographics_chg_ind == null)
				&& !(aCargo.getDemographics_chg_ind() != null && aCargo.getDemographics_chg_ind().equals(demographics_chg_ind))){
			changedAttributeValue.put("demographics_chg_ind", aCargo.getDemographics_chg_ind());
		}
		if (!(aCargo.getAlien_chg_ind() == null && alien_chg_ind == null)
				&& !(aCargo.getAlien_chg_ind() != null && aCargo.getAlien_chg_ind().equals(alien_chg_ind))){
			changedAttributeValue.put("alien_chg_ind", aCargo.getAlien_chg_ind());
		}
		if (!(aCargo.getUtil_bill_chg_Ind() == null && util_bill_chg_Ind == null)
				&& !(aCargo.getUtil_bill_chg_Ind() != null && aCargo.getUtil_bill_chg_Ind().equals(util_bill_chg_Ind))){
			changedAttributeValue.put("util_bill_chg_Ind", aCargo.getUtil_bill_chg_Ind());
		}
		if (!(aCargo.getCitizenship_info() == null && citizenship_info == null)
				&& !(aCargo.getCitizenship_info() != null && aCargo.getCitizenship_info().equals(citizenship_info))){
			changedAttributeValue.put("citizenship_info", aCargo.getCitizenship_info());
		}
		if (!(aCargo.getIndv_prgm_chg_ind() == null && indv_prgm_chg_ind == null)
				&& !(aCargo.getIndv_prgm_chg_ind() != null && aCargo.getIndv_prgm_chg_ind().equals(indv_prgm_chg_ind))){
			changedAttributeValue.put("indv_prgm_chg_ind", aCargo.getIndv_prgm_chg_ind());
		}
		if (!(aCargo.getEmpl_hlth_ins_resp() == null && empl_hlth_ins_resp == null)
				&& !(aCargo.getEmpl_hlth_ins_resp() != null && aCargo.getEmpl_hlth_ins_resp().equals(empl_hlth_ins_resp))){
			changedAttributeValue.put("empl_hlth_ins_resp", aCargo.getEmpl_hlth_ins_resp());
		}
		if (!(aCargo.getAvd_prsctn_fstf() == null && avd_prsctn_fstf == null)
				&& !(aCargo.getAvd_prsctn_fstf() != null && aCargo.getAvd_prsctn_fstf().equals(avd_prsctn_fstf))){
			changedAttributeValue.put("avd_prsctn_fstf", aCargo.getAvd_prsctn_fstf());
		}
		if (!(aCargo.getCntrl_subs_resp() == null && cntrl_subs_resp == null)
				&& !(aCargo.getCntrl_subs_resp() != null && aCargo.getCntrl_subs_resp().equals(cntrl_subs_resp))){
			changedAttributeValue.put("cntrl_subs_resp", aCargo.getCntrl_subs_resp());
		}
		if (!(aCargo.getHeat_cool_src() == null && heat_cool_src == null)
				&& !(aCargo.getHeat_cool_src() != null && aCargo.getHeat_cool_src().equals(heat_cool_src))){
			changedAttributeValue.put("heat_cool_src", aCargo.getHeat_cool_src());
		}
		// ending here
			
		return changedAttributeValue;
	}

	/* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((able_to_conceive_resp == null) ? 0 : able_to_conceive_resp.hashCode());
        result = prime * result + ((acdt_resp == null) ? 0 : acdt_resp.hashCode());
        result = prime * result + ((adoptAssistance == null) ? 0 : adoptAssistance.hashCode());
        result = prime * result + ((adoptionPayments == null) ? 0 : adoptionPayments.hashCode());
        result = prime * result + ((adpt_asst_resp == null) ? 0 : adpt_asst_resp.hashCode());
        result = prime * result + ((agentOrangePayments == null) ? 0 : agentOrangePayments.hashCode());
        result = prime * result + ((alimony == null) ? 0 : alimony.hashCode());
        result = prime * result + ((almy_rcv_resp == null) ? 0 : almy_rcv_resp.hashCode());
        result = prime * result + ((app_num == null) ? 0 : app_num.hashCode());
        result = prime * result + ((avoid_prosc_resp == null) ? 0 : avoid_prosc_resp.hashCode());
        result = prime * result + ((before_tax_deduction_resp == null) ? 0 : before_tax_deduction_resp.hashCode());
        result = prime * result + ((benefit_black_lung_resp == null) ? 0 : benefit_black_lung_resp.hashCode());
        result = prime * result + ((benefits_on_strike_resp == null) ? 0 : benefits_on_strike_resp.hashCode());
        result = prime * result + ((bnft_anty_resp == null) ? 0 : bnft_anty_resp.hashCode());
        result = prime * result + ((bnft_chl_sprt_resp == null) ? 0 : bnft_chl_sprt_resp.hashCode());
        result = prime * result + ((bnft_chrt_resp == null) ? 0 : bnft_chrt_resp.hashCode());
        result = prime * result + ((bnft_dabl_resp == null) ? 0 : bnft_dabl_resp.hashCode());
        result = prime * result + ((bnft_divnd_resp == null) ? 0 : bnft_divnd_resp.hashCode());
        result = prime * result + ((bnft_est_trst_resp == null) ? 0 : bnft_est_trst_resp.hashCode());
        result = prime * result + ((bnft_mapp_resp == null) ? 0 : bnft_mapp_resp.hashCode());
        result = prime * result + ((bnft_rr_resp == null) ? 0 : bnft_rr_resp.hashCode());
        result = prime * result + ((bnft_uempl_resp == null) ? 0 : bnft_uempl_resp.hashCode());
        result = prime * result + ((bnft_vet_resp == null) ? 0 : bnft_vet_resp.hashCode());
        result = prime * result + ((btd_def_comp == null) ? 0 : btd_def_comp.hashCode());
        result = prime * result + ((btd_dent_ins == null) ? 0 : btd_dent_ins.hashCode());
        result = prime * result + ((btd_flex_acc == null) ? 0 : btd_flex_acc.hashCode());
        result = prime * result + ((btd_med_ins == null) ? 0 : btd_med_ins.hashCode());
        result = prime * result + ((btd_other == null) ? 0 : btd_other.hashCode());
        result = prime * result + ((btd_pre_tax_ins == null) ? 0 : btd_pre_tax_ins.hashCode());
        result = prime * result + ((btd_vis_care_ins == null) ? 0 : btd_vis_care_ins.hashCode());
        result = prime * result + ((bury_aset_c_resp == null) ? 0 : bury_aset_c_resp.hashCode());
        result = prime * result + ((bury_aset_ibt_resp == null) ? 0 : bury_aset_ibt_resp.hashCode());
        result = prime * result + ((bury_aset_ins_resp == null) ? 0 : bury_aset_ins_resp.hashCode());
        result = prime * result + ((bury_aset_mas_resp == null) ? 0 : bury_aset_mas_resp.hashCode());
        result = prime * result + ((bury_aset_oth_resp == null) ? 0 : bury_aset_oth_resp.hashCode());
        result = prime * result + ((bury_aset_plt_resp == null) ? 0 : bury_aset_plt_resp.hashCode());
        result = prime * result + ((bury_aset_rbt_resp == null) ? 0 : bury_aset_rbt_resp.hashCode());
        result = prime * result + ((bury_aset_v_resp == null) ? 0 : bury_aset_v_resp.hashCode());
        result = prime * result + ((buy_sell_snap_resp == null) ? 0 : buy_sell_snap_resp.hashCode());
        result = prime * result + ((capitalGains == null) ? 0 : capitalGains.hashCode());
        result = prime * result + ((careTaker_resp == null) ? 0 : careTaker_resp.hashCode());
        result = prime * result + ((cash_gifts_resp == null) ? 0 : cash_gifts_resp.hashCode());
        result = prime * result + ((child_adult_care_resp == null) ? 0 : child_adult_care_resp.hashCode());
        result = prime * result + ((child_care_resp == null) ? 0 : child_care_resp.hashCode());
        result = prime * result + ((child_obligation_resp == null) ? 0 : child_obligation_resp.hashCode());
        result = prime * result + ((child_protective_resp == null) ? 0 : child_protective_resp.hashCode());
        result = prime * result + ((child_support_arr_resp == null) ? 0 : child_support_arr_resp.hashCode());
        result = prime * result + ((chld_sprt_pay_resp == null) ? 0 : chld_sprt_pay_resp.hashCode());
        result = prime * result + ((convic_false_info_resp == null) ? 0 : convic_false_info_resp.hashCode());
        result = prime * result + ((cooking_fuel_resp == null) ? 0 : cooking_fuel_resp.hashCode());
        result = prime * result + ((cooling_resp == null) ? 0 : cooling_resp.hashCode());
        result = prime * result + ((coop_condo_fee_resp == null) ? 0 : coop_condo_fee_resp.hashCode());
        result = prime * result + ((cp_wlst_resp == null) ? 0 : cp_wlst_resp.hashCode());
        result = prime * result + ((current_past_job_resp == null) ? 0 : current_past_job_resp.hashCode());
        result = prime * result + ((dabl_resp == null) ? 0 : dabl_resp.hashCode());
        result = prime * result + ((deathBenefits == null) ? 0 : deathBenefits.hashCode());
        result = prime * result + ((disabilityIncome == null) ? 0 : disabilityIncome.hashCode());
        result = prime * result + ((disasterRelief == null) ? 0 : disasterRelief.hashCode());
        result = prime * result + ((disaster_repair_resp == null) ? 0 : disaster_repair_resp.hashCode());
        result = prime * result + ((domestic_violence_resp == null) ? 0 : domestic_violence_resp.hashCode());
        result = prime * result + ((dpnd_care_resp == null) ? 0 : dpnd_care_resp.hashCode());
        result = prime * result + ((drug_feln_resp == null) ? 0 : drug_feln_resp.hashCode());
        result = prime * result + ((drug_felonies_resp == null) ? 0 : drug_felonies_resp.hashCode());
        result = prime * result + ((educ_aid_resp == null) ? 0 : educ_aid_resp.hashCode());
        result = prime * result + ((educationalAssistance == null) ? 0 : educationalAssistance.hashCode());
        result = prime * result + ((emergency_medical_resp == null) ? 0 : emergency_medical_resp.hashCode());
        result = prime * result + ((emergency_medical_service_resp == null) ? 0 : emergency_medical_service_resp.hashCode());
        result = prime * result + ((empl_resp == null) ? 0 : empl_resp.hashCode());
        result = prime * result + ((energyAssistance == null) ? 0 : energyAssistance.hashCode());
        result = prime * result + ((farmAllotment == null) ? 0 : farmAllotment.hashCode());
        result = prime * result + ((food_clothing_util_rent_resp == null) ? 0 : food_clothing_util_rent_resp.hashCode());
        result = prime * result + ((former_foster_resp == null) ? 0 : former_foster_resp.hashCode());
        result = prime * result + ((fosterCarePayments == null) ? 0 : fosterCarePayments.hashCode());
        result = prime * result + ((foster_care_resp == null) ? 0 : foster_care_resp.hashCode());
        result = prime * result + ((fset_sctn_resp == null) ? 0 : fset_sctn_resp.hashCode());
        result = prime * result + ((fstr_care_resp == null) ? 0 : fstr_care_resp.hashCode());
        result = prime * result + ((gen_rlf_resp == null) ? 0 : gen_rlf_resp.hashCode());
        result = prime * result + ((generalAssistance == null) ? 0 : generalAssistance.hashCode());
        result = prime * result + ((grand_parent_resp == null) ? 0 : grand_parent_resp.hashCode());
        result = prime * result + ((hc_cvrg_resp == null) ? 0 : hc_cvrg_resp.hashCode());
        result = prime * result + ((head_of_household_resp == null) ? 0 : head_of_household_resp.hashCode());
        result = prime * result + ((heating_resp == null) ? 0 : heating_resp.hashCode());
        result = prime * result + ((hlth_ins_resp == null) ? 0 : hlth_ins_resp.hashCode());
        result = prime * result + ((home_community_resp == null) ? 0 : home_community_resp.hashCode());
        result = prime * result + ((home_equity_resp == null) ? 0 : home_equity_resp.hashCode());
        result = prime * result + ((hospice_resp == null) ? 0 : hospice_resp.hashCode());
        result = prime * result + ((hospital_stay_resp == null) ? 0 : hospital_stay_resp.hashCode());
        result = prime * result + ((housing_bill_others_resp == null) ? 0 : housing_bill_others_resp.hashCode());
        result = prime * result + ((iRADistribution == null) ? 0 : iRADistribution.hashCode());
        result = prime * result + ((incm_int_resp == null) ? 0 : incm_int_resp.hashCode());
        result = prime * result + ((indv_cc_rqst_ind == null) ? 0 : indv_cc_rqst_ind.hashCode());
        result = prime * result + ((indv_cla_ind == null) ? 0 : indv_cla_ind.hashCode());
        result = prime * result + ((indv_fma_rqst_ind == null) ? 0 : indv_fma_rqst_ind.hashCode());
        result = prime * result + ((indv_fpw_rqst_ind == null) ? 0 : indv_fpw_rqst_ind.hashCode());
        result = prime * result + ((indv_fs_rqst_ind == null) ? 0 : indv_fs_rqst_ind.hashCode());
        result = prime * result + ((indv_seq_num == null) ? 0 : indv_seq_num.hashCode());
        result = prime * result + ((indv_tanf_rqst_ind == null) ? 0 : indv_tanf_rqst_ind.hashCode());
        result = prime * result + ((indv_wic_rqst_ind == null) ? 0 : indv_wic_rqst_ind.hashCode());
        result = prime * result + ((inheritance_resp == null) ? 0 : inheritance_resp.hashCode());
        result = prime * result + ((insurance_settlement_resp == null) ? 0 : insurance_settlement_resp.hashCode());
        result = prime * result + ((interestDividendPayments == null) ? 0 : interestDividendPayments.hashCode());
        result = prime * result + ((irwe_resp == null) ? 0 : irwe_resp.hashCode());
        result = prime * result + ((job_iknd_resp == null) ? 0 : job_iknd_resp.hashCode());
        result = prime * result + ((kinship_care_resp == null) ? 0 : kinship_care_resp.hashCode());
        result = prime * result + ((land_cont_resp == null) ? 0 : land_cont_resp.hashCode());
        result = prime * result + ((li_aset_g_l_resp == null) ? 0 : li_aset_g_l_resp.hashCode());
        result = prime * result + ((li_aset_g_t_resp == null) ? 0 : li_aset_g_t_resp.hashCode());
        result = prime * result + ((li_aset_trm_resp == null) ? 0 : li_aset_trm_resp.hashCode());
        result = prime * result + ((li_aset_unv_resp == null) ? 0 : li_aset_unv_resp.hashCode());
        result = prime * result + ((li_aset_w_l_resp == null) ? 0 : li_aset_w_l_resp.hashCode());
        result = prime * result + ((life_ins_asest_group_life_resp == null) ? 0 : life_ins_asest_group_life_resp.hashCode());
        result = prime * result + ((life_ins_asset_group_term_resp == null) ? 0 : life_ins_asset_group_term_resp.hashCode());
        result = prime * result + ((life_ins_asset_universal_resp == null) ? 0 : life_ins_asset_universal_resp.hashCode());
        result = prime * result + ((life_ins_asset_whole_life_resp == null) ? 0 : life_ins_asset_whole_life_resp.hashCode());
        result = prime * result + ((life_insurance_asset_term_resp == null) ? 0 : life_insurance_asset_term_resp.hashCode());
        result = prime * result + ((life_insurance_other_resp == null) ? 0 : life_insurance_other_resp.hashCode());
        result = prime * result + ((liquid_aset_disable_blind_resp == null) ? 0 : liquid_aset_disable_blind_resp.hashCode());
        result = prime * result + ((liquid_asset_bank_acc_resp == null) ? 0 : liquid_asset_bank_acc_resp.hashCode());
        result = prime * result + ((liquid_asset_cash_resp == null) ? 0 : liquid_asset_cash_resp.hashCode());
        result = prime * result + ((liquid_asset_ira_resp == null) ? 0 : liquid_asset_ira_resp.hashCode());
        result = prime * result + ((liquid_asset_irs_retirmnt_resp == null) ? 0 : liquid_asset_irs_retirmnt_resp.hashCode());
        result = prime * result + ((liquid_asset_other_response == null) ? 0 : liquid_asset_other_response.hashCode());
        result = prime * result + ((liquid_asset_other_type_resp == null) ? 0 : liquid_asset_other_type_resp.hashCode());
        result = prime * result + ((liquid_asset_pension_plan_resp == null) ? 0 : liquid_asset_pension_plan_resp.hashCode());
        result = prime * result + ((liquid_asset_promissory_resp == null) ? 0 : liquid_asset_promissory_resp.hashCode());
        result = prime * result + ((liquid_asset_retirement_resp == null) ? 0 : liquid_asset_retirement_resp.hashCode());
        result = prime * result + ((liquid_asset_savings_acc_resp == null) ? 0 : liquid_asset_savings_acc_resp.hashCode());
        result = prime * result + ((liquid_asset_stocks_bonds_resp == null) ? 0 : liquid_asset_stocks_bonds_resp.hashCode());
        result = prime * result + ((liquid_asset_trust_fund_resp == null) ? 0 : liquid_asset_trust_fund_resp.hashCode());
        result = prime * result + ((living_prog_resp == null) ? 0 : living_prog_resp.hashCode());
        result = prime * result + ((loan_resp == null) ? 0 : loan_resp.hashCode());
        result = prime * result + ((lost_health_ins_ind == null) ? 0 : lost_health_ins_ind.hashCode());
        result = prime * result + ((lotteryWinnings == null) ? 0 : lotteryWinnings.hashCode());
        result = prime * result + ((lottery_prize_winning_resp == null) ? 0 : lottery_prize_winning_resp.hashCode());
        result = prime * result + ((lqd_aset_c_a_resp == null) ? 0 : lqd_aset_c_a_resp.hashCode());
        result = prime * result + ((lqd_aset_eb_a_resp == null) ? 0 : lqd_aset_eb_a_resp.hashCode());
        result = prime * result + ((lqd_aset_h_s_resp == null) ? 0 : lqd_aset_h_s_resp.hashCode());
        result = prime * result + ((lqd_aset_ira_resp == null) ? 0 : lqd_aset_ira_resp.hashCode());
        result = prime * result + ((lqd_aset_k_p_resp == null) ? 0 : lqd_aset_k_p_resp.hashCode());
        result = prime * result + ((lqd_aset_m_o_resp == null) ? 0 : lqd_aset_m_o_resp.hashCode());
        result = prime * result + ((lqd_aset_mm_a_resp == null) ? 0 : lqd_aset_mm_a_resp.hashCode());
        result = prime * result + ((lqd_aset_o_t_resp == null) ? 0 : lqd_aset_o_t_resp.hashCode());
        result = prime * result + ((lqd_aset_othr_resp == null) ? 0 : lqd_aset_othr_resp.hashCode());
        result = prime * result + ((lqd_aset_s_a_resp == null) ? 0 : lqd_aset_s_a_resp.hashCode());
        result = prime * result + ((lqd_aset_s_c_resp == null) ? 0 : lqd_aset_s_c_resp.hashCode());
        result = prime * result + ((lqd_aset_st_b_resp == null) ? 0 : lqd_aset_st_b_resp.hashCode());
        result = prime * result + ((lqd_aset_tr_f_resp == null) ? 0 : lqd_aset_tr_f_resp.hashCode());
        result = prime * result + ((lqd_aset_us_b_resp == null) ? 0 : lqd_aset_us_b_resp.hashCode());
        result = prime * result + ((lumpSum == null) ? 0 : lumpSum.hashCode());
        result = prime * result + ((med_exp_resp == null) ? 0 : med_exp_resp.hashCode());
        result = prime * result + ((med_type_animal_resp == null) ? 0 : med_type_animal_resp.hashCode());
        result = prime * result + ((med_type_atndnt_meal_resp == null) ? 0 : med_type_atndnt_meal_resp.hashCode());
        result = prime * result + ((med_type_bills_resp == null) ? 0 : med_type_bills_resp.hashCode());
        result = prime * result + ((med_type_eyeglasses_resp == null) ? 0 : med_type_eyeglasses_resp.hashCode());
        result = prime * result + ((med_type_inhome_resp == null) ? 0 : med_type_inhome_resp.hashCode());
        result = prime * result + ((med_type_insurance_resp == null) ? 0 : med_type_insurance_resp.hashCode());
        result = prime * result + ((med_type_maintain_attndnt_resp == null) ? 0 : med_type_maintain_attndnt_resp.hashCode());
        result = prime * result + ((med_type_nursing_resp == null) ? 0 : med_type_nursing_resp.hashCode());
        result = prime * result + ((med_type_other_resp == null) ? 0 : med_type_other_resp.hashCode());
        result = prime * result + ((med_type_out_patient_resp == null) ? 0 : med_type_out_patient_resp.hashCode());
        result = prime * result + ((med_type_prescribed_drug_resp == null) ? 0 : med_type_prescribed_drug_resp.hashCode());
        result = prime * result + ((med_type_prosthetic_resp == null) ? 0 : med_type_prosthetic_resp.hashCode());
        result = prime * result + ((med_type_psychotherapy_resp == null) ? 0 : med_type_psychotherapy_resp.hashCode());
        result = prime * result + ((med_type_special_equip_resp == null) ? 0 : med_type_special_equip_resp.hashCode());
        result = prime * result + ((med_type_supplies_resp == null) ? 0 : med_type_supplies_resp.hashCode());
        result = prime * result + ((med_type_transportation_resp == null) ? 0 : med_type_transportation_resp.hashCode());
        result = prime * result + ((medical_bills_resp == null) ? 0 : medical_bills_resp.hashCode());
        result = prime * result + ((medical_service_resp == null) ? 0 : medical_service_resp.hashCode());
        result = prime * result + ((medtyp_attendant_care == null) ? 0 : medtyp_attendant_care.hashCode());
        result = prime * result + ((medtyp_dental == null) ? 0 : medtyp_dental.hashCode());
        result = prime * result + ((medtyp_doctor == null) ? 0 : medtyp_doctor.hashCode());
        result = prime * result + ((medtyp_hosp_bills == null) ? 0 : medtyp_hosp_bills.hashCode());
        result = prime * result + ((medtyp_hsa_contrib == null) ? 0 : medtyp_hsa_contrib.hashCode());
        result = prime * result + ((medtyp_insur_premium == null) ? 0 : medtyp_insur_premium.hashCode());
        result = prime * result + ((medtyp_med_equip == null) ? 0 : medtyp_med_equip.hashCode());
        result = prime * result + ((medtyp_other == null) ? 0 : medtyp_other.hashCode());
        result = prime * result + ((medtyp_rx_cost == null) ? 0 : medtyp_rx_cost.hashCode());
        result = prime * result + ((medtyp_trans_med == null) ? 0 : medtyp_trans_med.hashCode());
        result = prime * result + ((mi_heating_cred_resp == null) ? 0 : mi_heating_cred_resp.hashCode());
        result = prime * result + ((mil_allot_resp == null) ? 0 : mil_allot_resp.hashCode());
        result = prime * result + ((militaryAllotment == null) ? 0 : militaryAllotment.hashCode());
        result = prime * result + ((moneyFromAnotherPerson == null) ? 0 : moneyFromAnotherPerson.hashCode());
        result = prime * result + ((mony_othr_resp == null) ? 0 : mony_othr_resp.hashCode());
        result = prime * result + ((mortg_guar_ins_resp == null) ? 0 : mortg_guar_ins_resp.hashCode());
        result = prime * result + ((moved_into_home_response == null) ? 0 : moved_into_home_response.hashCode());
        result = prime * result + ((moved_out_of_home_resp == null) ? 0 : moved_out_of_home_resp.hashCode());
        result = prime * result + ((natl_rfge_resp == null) ? 0 : natl_rfge_resp.hashCode());
        result = prime * result + ((need_ind_resp == null) ? 0 : need_ind_resp.hashCode());
        result = prime * result + ((netRentalRoyalty == null) ? 0 : netRentalRoyalty.hashCode());
        result = prime * result + ((none_resp == null) ? 0 : none_resp.hashCode());
        result = prime * result + ((on_strk_sw == null) ? 0 : on_strk_sw.hashCode());
        result = prime * result + ((op_aoda_tmt_rcv_sw == null) ? 0 : op_aoda_tmt_rcv_sw.hashCode());
        result = prime * result + ((otherIncome == null) ? 0 : otherIncome.hashCode());
        result = prime * result + ((other_aset_life_insurance_resp == null) ? 0 : other_aset_life_insurance_resp.hashCode());
        result = prime * result + ((other_asset_burial_resp == null) ? 0 : other_asset_burial_resp.hashCode());
        result = prime * result + ((other_asset_personal_prop_resp == null) ? 0 : other_asset_personal_prop_resp.hashCode());
        result = prime * result + ((other_asset_real_property_resp == null) ? 0 : other_asset_real_property_resp.hashCode());
        result = prime * result + ((other_asset_transfer_resp == null) ? 0 : other_asset_transfer_resp.hashCode());
        result = prime * result + ((other_asset_vehicle_resp == null) ? 0 : other_asset_vehicle_resp.hashCode());
        result = prime * result + ((other_housing_bill_resp == null) ? 0 : other_housing_bill_resp.hashCode());
        result = prime * result + ((other_incm_contrib_resp == null) ? 0 : other_incm_contrib_resp.hashCode());
        result = prime * result + ((other_resp == null) ? 0 : other_resp.hashCode());
        result = prime * result + ((othr_hlth_ins_resp == null) ? 0 : othr_hlth_ins_resp.hashCode());
        result = prime * result + ((othr_incm_rentl_resp == null) ? 0 : othr_incm_rentl_resp.hashCode());
        result = prime * result + ((othr_incm_resp == null) ? 0 : othr_incm_resp.hashCode());
        result = prime * result + ((othr_incm_trbl_resp == null) ? 0 : othr_incm_trbl_resp.hashCode());
        result = prime * result + ((othr_social_security_bnft_resp == null) ? 0 : othr_social_security_bnft_resp.hashCode());
        result = prime * result + ((othr_src_resp == null) ? 0 : othr_src_resp.hashCode());
        result = prime * result + ((outstate_bnft_resp == null) ? 0 : outstate_bnft_resp.hashCode());
        result = prime * result + ((own_aset_resp == null) ? 0 : own_aset_resp.hashCode());
        result = prime * result + ((parole_violation_resp == null) ? 0 : parole_violation_resp.hashCode());
        result = prime * result + ((past_hc_cvrg_resp == null) ? 0 : past_hc_cvrg_resp.hashCode());
        result = prime * result + ((pay_hous_bill_resp == null) ? 0 : pay_hous_bill_resp.hashCode());
        result = prime * result + ((pay_rmr_brd_resp == null) ? 0 : pay_rmr_brd_resp.hashCode());
        result = prime * result + ((paymentsFromAnnuity == null) ? 0 : paymentsFromAnnuity.hashCode());
        result = prime * result + ((paymentsMadeOnYourBehalf == null) ? 0 : paymentsMadeOnYourBehalf.hashCode());
        result = prime * result + ((pensionOrRetirement == null) ? 0 : pensionOrRetirement.hashCode());
        result = prime * result + ((pers_prop_bus_eqpt == null) ? 0 : pers_prop_bus_eqpt.hashCode());
        result = prime * result + ((pers_prop_cemetary_lot == null) ? 0 : pers_prop_cemetary_lot.hashCode());
        result = prime * result + ((pers_prop_livestock == null) ? 0 : pers_prop_livestock.hashCode());
        result = prime * result + ((pers_prop_oth_val == null) ? 0 : pers_prop_oth_val.hashCode());
        result = prime * result + ((pers_prop_saf_depst_box == null) ? 0 : pers_prop_saf_depst_box.hashCode());
        result = prime * result + ((pnsn_retr_resp == null) ? 0 : pnsn_retr_resp.hashCode());
        result = prime * result + ((preg_add_stat_sw == null) ? 0 : preg_add_stat_sw.hashCode());
        result = prime * result + ((preg_chg_stat_sw == null) ? 0 : preg_chg_stat_sw.hashCode());
        result = prime * result + ((preg_resp == null) ? 0 : preg_resp.hashCode());
        result = prime * result + ((prev_ssi_resp == null) ? 0 : prev_ssi_resp.hashCode());
        result = prime * result + ((prevent_eviction_resp == null) ? 0 : prevent_eviction_resp.hashCode());
        result = prime * result + ((prop_sold_resp == null) ? 0 : prop_sold_resp.hashCode());
        result = prime * result + ((prsn_info_stat_sw == null) ? 0 : prsn_info_stat_sw.hashCode());
        result = prime * result + ((pub_asst_resp == null) ? 0 : pub_asst_resp.hashCode());
        result = prime * result + ((railroadRetirement == null) ? 0 : railroadRetirement.hashCode());
        result = prime * result + ((rcv_fs_oth_st_resp == null) ? 0 : rcv_fs_oth_st_resp.hashCode());
        result = prime * result + ((rcv_hous_asst_resp == null) ? 0 : rcv_hous_asst_resp.hashCode());
        result = prime * result + ((rcv_medcr_resp == null) ? 0 : rcv_medcr_resp.hashCode());
        result = prime * result + ((rcv_ss_resp == null) ? 0 : rcv_ss_resp.hashCode());
        result = prime * result + ((rcv_ssi_ltr_resp == null) ? 0 : rcv_ssi_ltr_resp.hashCode());
        result = prime * result + ((rcv_ssi_sw == null) ? 0 : rcv_ssi_sw.hashCode());
        result = prime * result + ((real_aset_apt_resp == null) ? 0 : real_aset_apt_resp.hashCode());
        result = prime * result + ((real_aset_com_resp == null) ? 0 : real_aset_com_resp.hashCode());
        result = prime * result + ((real_aset_con_resp == null) ? 0 : real_aset_con_resp.hashCode());
        result = prime * result + ((real_aset_dup_resp == null) ? 0 : real_aset_dup_resp.hashCode());
        result = prime * result + ((real_aset_frm_resp == null) ? 0 : real_aset_frm_resp.hashCode());
        result = prime * result + ((real_aset_hse_resp == null) ? 0 : real_aset_hse_resp.hashCode());
        result = prime * result + ((real_aset_lnd_resp == null) ? 0 : real_aset_lnd_resp.hashCode());
        result = prime * result + ((real_aset_m_h_resp == null) ? 0 : real_aset_m_h_resp.hashCode());
        result = prime * result + ((real_aset_oth_resp == null) ? 0 : real_aset_oth_resp.hashCode());
        result = prime * result + ((real_aset_vac_resp == null) ? 0 : real_aset_vac_resp.hashCode());
        result = prime * result + ((real_asset_home_resp == null) ? 0 : real_asset_home_resp.hashCode());
        result = prime * result + ((real_asset_house_resp == null) ? 0 : real_asset_house_resp.hashCode());
        result = prime * result + ((real_asset_land_resp == null) ? 0 : real_asset_land_resp.hashCode());
        result = prime * result + ((real_asset_life_estate_resp == null) ? 0 : real_asset_life_estate_resp.hashCode());
        result = prime * result + ((real_asset_mobile_home_resp == null) ? 0 : real_asset_mobile_home_resp.hashCode());
        result = prime * result + ((real_asset_other_resp == null) ? 0 : real_asset_other_resp.hashCode());
        result = prime * result + ((real_asset_rental_resp == null) ? 0 : real_asset_rental_resp.hashCode());
        result = prime * result + ((real_asset_unoccupy_home_resp == null) ? 0 : real_asset_unoccupy_home_resp.hashCode());
        result = prime * result + ((refugeeCash == null) ? 0 : refugeeCash.hashCode());
        result = prime * result + ((refused_job_lst_30_resp == null) ? 0 : refused_job_lst_30_resp.hashCode());
        result = prime * result + ((relativeCareSubsidy == null) ? 0 : relativeCareSubsidy.hashCode());
        result = prime * result + ((rentalIncome == null) ? 0 : rentalIncome.hashCode());
        result = prime * result + ((resettl_inc_resp == null) ? 0 : resettl_inc_resp.hashCode());
        result = prime * result + ((rlt_chg_stat_sw == null) ? 0 : rlt_chg_stat_sw.hashCode());
        result = prime * result + ((rmr_brd_incm_resp == null) ? 0 : rmr_brd_incm_resp.hashCode());
        result = prime * result + ((room_board_resp == null) ? 0 : room_board_resp.hashCode());
        result = prime * result + ((school_enrollment_resp == null) ? 0 : school_enrollment_resp.hashCode());
        result = prime * result + ((second_mortgag_resp == null) ? 0 : second_mortgag_resp.hashCode());
        result = prime * result + ((self_empl_resp == null) ? 0 : self_empl_resp.hashCode());
        result = prime * result + ((septic_sewer_resp == null) ? 0 : septic_sewer_resp.hashCode());
        result = prime * result + ((snap_tanf_disc_resp == null) ? 0 : snap_tanf_disc_resp.hashCode());
        result = prime * result + ((special_need_resp == null) ? 0 : special_need_resp.hashCode());
        result = prime * result + ((ssi_1619b_rcv_sw == null) ? 0 : ssi_1619b_rcv_sw.hashCode());
        result = prime * result + ((ssi_dcond_resp == null) ? 0 : ssi_dcond_resp.hashCode());
        result = prime * result + ((student_financial_aid_resp == null) ? 0 : student_financial_aid_resp.hashCode());
        result = prime * result + ((su_ases_resp == null) ? 0 : su_ases_resp.hashCode());
        result = prime * result + ((su_cst_coal_resp == null) ? 0 : su_cst_coal_resp.hashCode());
        result = prime * result + ((su_cst_elec_resp == null) ? 0 : su_cst_elec_resp.hashCode());
        result = prime * result + ((su_cst_fuel_resp == null) ? 0 : su_cst_fuel_resp.hashCode());
        result = prime * result + ((su_cst_gas_resp == null) ? 0 : su_cst_gas_resp.hashCode());
        result = prime * result + ((su_cst_home_resp == null) ? 0 : su_cst_home_resp.hashCode());
        result = prime * result + ((su_cst_ins_resp == null) ? 0 : su_cst_ins_resp.hashCode());
        result = prime * result + ((su_cst_istl_resp == null) ? 0 : su_cst_istl_resp.hashCode());
        result = prime * result + ((su_cst_lpgas_resp == null) ? 0 : su_cst_lpgas_resp.hashCode());
        result = prime * result + ((su_cst_mbl_resp == null) ? 0 : su_cst_mbl_resp.hashCode());
        result = prime * result + ((su_cst_mtge_resp == null) ? 0 : su_cst_mtge_resp.hashCode());
        result = prime * result + ((su_cst_othr_resp == null) ? 0 : su_cst_othr_resp.hashCode());
        result = prime * result + ((su_cst_phn_resp == null) ? 0 : su_cst_phn_resp.hashCode());
        result = prime * result + ((su_cst_rent_resp == null) ? 0 : su_cst_rent_resp.hashCode());
        result = prime * result + ((su_cst_swr_resp == null) ? 0 : su_cst_swr_resp.hashCode());
        result = prime * result + ((su_cst_tax_resp == null) ? 0 : su_cst_tax_resp.hashCode());
        result = prime * result + ((su_cst_trsh_resp == null) ? 0 : su_cst_trsh_resp.hashCode());
        result = prime * result + ((su_cst_wood_resp == null) ? 0 : su_cst_wood_resp.hashCode());
        result = prime * result + ((su_cst_wtr_resp == null) ? 0 : su_cst_wtr_resp.hashCode());
        result = prime * result + ((su_cst_wwt_resp == null) ? 0 : su_cst_wwt_resp.hashCode());
        result = prime * result + ((tANFPayments == null) ? 0 : tANFPayments.hashCode());
        result = prime * result + ((tanfDiscResp == null) ? 0 : tanfDiscResp.hashCode());
        result = prime * result + ((tanf_eppic_resp == null) ? 0 : tanf_eppic_resp.hashCode());
        result = prime * result + ((tanf_ind == null) ? 0 : tanf_ind.hashCode());
        result = prime * result + ((tax_claim_dependant_resp == null) ? 0 : tax_claim_dependant_resp.hashCode());
        result = prime * result + ((tax_deduct_resp == null) ? 0 : tax_deduct_resp.hashCode());
        result = prime * result + ((trade_snap_gun_resp == null) ? 0 : trade_snap_gun_resp.hashCode());
        result = prime * result + ((trading_snap_resp == null) ? 0 : trading_snap_resp.hashCode());
        result = prime * result + ((training_allowance_resp == null) ? 0 : training_allowance_resp.hashCode());
        result = prime * result + ((trb_cmdy_resp == null) ? 0 : trb_cmdy_resp.hashCode());
        result = prime * result + ((trb_cpta_resp == null) ? 0 : trb_cpta_resp.hashCode());
        result = prime * result + ((trb_tanf_resp == null) ? 0 : trb_tanf_resp.hashCode());
        result = prime * result + ((tribal_eligibility_resp == null) ? 0 : tribal_eligibility_resp.hashCode());
        result = prime * result + ((tribal_food_dist_resp == null) ? 0 : tribal_food_dist_resp.hashCode());
        result = prime * result + ((tribal_health_resp == null) ? 0 : tribal_health_resp.hashCode());
        result = prime * result + ((underweight_birth_resp == null) ? 0 : underweight_birth_resp.hashCode());
        result = prime * result + ((unemploymentCompensation == null) ? 0 : unemploymentCompensation.hashCode());
        result = prime * result + ((unocc_home_exp_resp == null) ? 0 : unocc_home_exp_resp.hashCode());
        result = prime * result + ((unpaid_medbill == null) ? 0 : unpaid_medbill.hashCode());
        result = prime * result + ((updt_dt == null) ? 0 : updt_dt.hashCode());
        result = prime * result + ((util_exp_resp == null) ? 0 : util_exp_resp.hashCode());
        result = prime * result + ((utility_bills_oil_resp == null) ? 0 : utility_bills_oil_resp.hashCode());
        result = prime * result + ((utility_standard_resp == null) ? 0 : utility_standard_resp.hashCode());
        result = prime * result + ((veh_aset_anml_resp == null) ? 0 : veh_aset_anml_resp.hashCode());
        result = prime * result + ((veh_aset_arpl_resp == null) ? 0 : veh_aset_arpl_resp.hashCode());
        result = prime * result + ((veh_aset_auto_resp == null) ? 0 : veh_aset_auto_resp.hashCode());
        result = prime * result + ((veh_aset_boat_resp == null) ? 0 : veh_aset_boat_resp.hashCode());
        result = prime * result + ((veh_aset_bus_resp == null) ? 0 : veh_aset_bus_resp.hashCode());
        result = prime * result + ((veh_aset_camp_resp == null) ? 0 : veh_aset_camp_resp.hashCode());
        result = prime * result + ((veh_aset_fimp_resp == null) ? 0 : veh_aset_fimp_resp.hashCode());
        result = prime * result + ((veh_aset_fmeq_resp == null) ? 0 : veh_aset_fmeq_resp.hashCode());
        result = prime * result + ((veh_aset_ftrc_resp == null) ? 0 : veh_aset_ftrc_resp.hashCode());
        result = prime * result + ((veh_aset_ftrl_resp == null) ? 0 : veh_aset_ftrl_resp.hashCode());
        result = prime * result + ((veh_aset_lskd_resp == null) ? 0 : veh_aset_lskd_resp.hashCode());
        result = prime * result + ((veh_aset_mcyc_resp == null) ? 0 : veh_aset_mcyc_resp.hashCode());
        result = prime * result + ((veh_aset_mped_resp == null) ? 0 : veh_aset_mped_resp.hashCode());
        result = prime * result + ((veh_aset_nm_b_resp == null) ? 0 : veh_aset_nm_b_resp.hashCode());
        result = prime * result + ((veh_aset_othr_resp == null) ? 0 : veh_aset_othr_resp.hashCode());
        result = prime * result + ((veh_aset_rv_resp == null) ? 0 : veh_aset_rv_resp.hashCode());
        result = prime * result + ((veh_aset_s_mb_resp == null) ? 0 : veh_aset_s_mb_resp.hashCode());
        result = prime * result + ((veh_aset_trk_resp == null) ? 0 : veh_aset_trk_resp.hashCode());
        result = prime * result + ((veh_aset_trlr_resp == null) ? 0 : veh_aset_trlr_resp.hashCode());
        result = prime * result + ((veh_aset_unlic_resp == null) ? 0 : veh_aset_unlic_resp.hashCode());
        result = prime * result + ((veh_aset_van_resp == null) ? 0 : veh_aset_van_resp.hashCode());
        result = prime * result + ((vehicle_asset_animal_drwn_resp == null) ? 0 : vehicle_asset_animal_drwn_resp.hashCode());
        result = prime * result + ((vehicle_asset_auto_resp == null) ? 0 : vehicle_asset_auto_resp.hashCode());
        result = prime * result + ((vehicle_asset_boat_resp == null) ? 0 : vehicle_asset_boat_resp.hashCode());
        result = prime * result + ((vehicle_asset_camper_resp == null) ? 0 : vehicle_asset_camper_resp.hashCode());
        result = prime * result + ((vehicle_asset_golf_cart_resp == null) ? 0 : vehicle_asset_golf_cart_resp.hashCode());
        result = prime * result + ((vehicle_asset_motorcycle_resp == null) ? 0 : vehicle_asset_motorcycle_resp.hashCode());
        result = prime * result + ((vehicle_asset_nmot_camper_resp == null) ? 0 : vehicle_asset_nmot_camper_resp.hashCode());
        result = prime * result + ((vehicle_asset_other_resp == null) ? 0 : vehicle_asset_other_resp.hashCode());
        result = prime * result + ((vehicle_asset_recreation_resp == null) ? 0 : vehicle_asset_recreation_resp.hashCode());
        result = prime * result + ((vehicle_asset_tractor_resp == null) ? 0 : vehicle_asset_tractor_resp.hashCode());
        result = prime * result + ((violating_parole_resp == null) ? 0 : violating_parole_resp.hashCode());
        result = prime * result + ((voluntarily_quit_job_resp == null) ? 0 : voluntarily_quit_job_resp.hashCode());
        result = prime * result + ((water_well_maint_resp == null) ? 0 : water_well_maint_resp.hashCode());
        result = prime * result + ((water_well_resp == null) ? 0 : water_well_resp.hashCode());
        result = prime * result + ((wheap_resp == null) ? 0 : wheap_resp.hashCode());
        result = prime * result + ((workStudyStateFederal == null) ? 0 : workStudyStateFederal.hashCode());
        result = prime * result + ((work_comp_resp == null) ? 0 : work_comp_resp.hashCode());
        result = prime * result + ((work_related_expense_resp == null) ? 0 : work_related_expense_resp.hashCode());
        result = prime * result + ((workersCompensation == null) ? 0 : workersCompensation.hashCode());
        result = prime * result + ((yehoc_resp == null) ? 0 : yehoc_resp.hashCode());
        
        result = prime * result + ((room_brd_chg_ind == null) ? 0 : room_brd_chg_ind.hashCode());
        result = prime * result + ((dabl_stat_ind == null) ? 0 : dabl_stat_ind.hashCode());
        result = prime * result + ((preg_add_stat_ind == null) ? 0 : preg_add_stat_ind.hashCode());
        result = prime * result + ((preg_chg_ind == null) ? 0 : preg_chg_ind.hashCode());
        result = prime * result + ((irwe_chg_ind == null) ? 0 : irwe_chg_ind.hashCode());
        result = prime * result + ((ei_chg_ind == null) ? 0 : ei_chg_ind.hashCode());
        result = prime * result + ((self_empl_chg_ind == null) ? 0 : self_empl_chg_ind.hashCode());
        result = prime * result + ((othr_incm_chg_ind == null) ? 0 : othr_incm_chg_ind.hashCode());
        result = prime * result + ((empl_chg_ind == null) ? 0 : empl_chg_ind.hashCode());
        result = prime * result + ((veh_aset_add_ind == null) ? 0 : veh_aset_add_ind.hashCode());
        result = prime * result + ((veh_aset_chg_ind == null) ? 0 : veh_aset_chg_ind.hashCode());
        result = prime * result + ((real_aset_add_ind == null) ? 0 : real_aset_add_ind.hashCode());
        result = prime * result + ((real_aset_chg_ind == null) ? 0 : real_aset_chg_ind.hashCode());
        result = prime * result + ((bury_aset_add_ind == null) ? 0 : bury_aset_add_ind.hashCode());
        result = prime * result + ((bury_aset_chg_ind == null) ? 0 : bury_aset_chg_ind.hashCode());
        result = prime * result + ((liquid_asset_add_ind == null) ? 0 : liquid_asset_add_ind.hashCode());
        result = prime * result + ((liquid_asset_bank_acc_chg_ind == null) ? 0 : liquid_asset_bank_acc_chg_ind.hashCode());
        result = prime * result + ((liquid_asset_cash_chg_ind == null) ? 0 : liquid_asset_cash_chg_ind.hashCode());
        result = prime * result + ((liquid_asset_chg_ind == null) ? 0 : liquid_asset_chg_ind.hashCode());
        result = prime * result + ((liquid_asset_other_chg_ind == null) ? 0 : liquid_asset_other_chg_ind.hashCode());
        result = prime * result + ((life_ins_aset_add_ind == null) ? 0 : life_ins_aset_add_ind.hashCode());
        result = prime * result + ((life_ins_aset_chg_ind == null) ? 0 : life_ins_aset_chg_ind.hashCode());
        result = prime * result + ((aset_xfer_chg_ind == null) ? 0 : aset_xfer_chg_ind.hashCode());
        result = prime * result + ((dpnd_care_chg_ind == null) ? 0 : dpnd_care_chg_ind.hashCode());
        result = prime * result + ((health_insurance_chg_ind == null) ? 0 : health_insurance_chg_ind.hashCode());
        result = prime * result + ((child_support_payment_chg_ind == null) ? 0 : child_support_payment_chg_ind.hashCode());
        result = prime * result + ((snap_shelter_standard_exp_ind == null) ? 0 : snap_shelter_standard_exp_ind.hashCode());
        result = prime * result + ((hous_bill_chg_ind == null) ? 0 : hous_bill_chg_ind.hashCode());
        result = prime * result + ((add_chg_ind == null) ? 0 : add_chg_ind.hashCode());
        result = prime * result + ((person_moved_in_stat_ind == null) ? 0 : person_moved_in_stat_ind.hashCode());
        result = prime * result + ((person_moved_out_stat_ind == null) ? 0 : person_moved_out_stat_ind.hashCode());
        result = prime * result + ((hospice_chg_ind == null) ? 0 : hospice_chg_ind.hashCode());
        result = prime * result + ((medicare_chg_ind == null) ? 0 : medicare_chg_ind.hashCode());
        result = prime * result + ((ncp_chg_ind == null) ? 0 : ncp_chg_ind.hashCode());
        result = prime * result + ((third_party_chg_ind == null) ? 0 : third_party_chg_ind.hashCode());
        result = prime * result + ((hospital_abd_chg_ind == null) ? 0 : hospital_abd_chg_ind.hashCode());
        result = prime * result + ((public_law_abd_chg_ind == null) ? 0 : public_law_abd_chg_ind.hashCode());
        result = prime * result + ((living_argmt_chg_ind == null) ? 0 : living_argmt_chg_ind.hashCode());
        result = prime * result + ((other_program_chg_ind == null) ? 0 : other_program_chg_ind.hashCode());
	    result = prime * result + ((magi_expense_chg_ind == null) ? 0 : magi_expense_chg_ind.hashCode());
        result = prime * result + ((tax_info_ind == null) ? 0 : tax_info_ind.hashCode());
        result = prime * result + ((tax_dep_outside_resp == null) ? 0 : tax_dep_outside_resp.hashCode());        
        result = prime * result + ((medicare_part_a == null) ? 0 : medicare_part_a.hashCode());
        result = prime * result + ((medicare_part_b == null) ? 0 : medicare_part_b.hashCode());
        result = prime * result + ((medicare_part_c == null) ? 0 : medicare_part_c.hashCode());
        result = prime * result + ((medicare_part_d == null) ? 0 : medicare_part_d.hashCode());
        result = prime * result + ((cssp_provider_payment == null) ? 0 : cssp_provider_payment.hashCode());
        result = prime * result + ((animals_to_assist_disabled == null) ? 0 : animals_to_assist_disabled.hashCode());
        result = prime * result + ((funeral_death_expense == null) ? 0 : funeral_death_expense.hashCode());
        result = prime * result + ((blind_work_expense == null) ? 0 : blind_work_expense.hashCode());
        result = prime * result + ((impairment_work_expense == null) ? 0 : impairment_work_expense.hashCode());
        result = prime * result + ((oth_ind_gambl_pmnts == null) ? 0 : oth_ind_gambl_pmnts.hashCode());
        
        result = prime * result + ((income_from_resource == null) ? 0 : income_from_resource.hashCode());
        result = prime * result + ((indian_gambling_payments == null) ? 0 : indian_gambling_payments.hashCode());
        result = prime * result + ((inheritance == null) ? 0 : inheritance.hashCode());
        result = prime * result + ((insuance_benefits == null) ? 0 : insuance_benefits.hashCode());
        result = prime * result + ((loan_received == null) ? 0 : loan_received.hashCode());
        result = prime * result + ((loan_repayment_income == null) ? 0 : loan_repayment_income.hashCode());
        result = prime * result + ((managed_income == null) ? 0 : managed_income.hashCode());
        result = prime * result + ((match_grant == null) ? 0 : match_grant.hashCode());
        result = prime * result + ((montgomery_gi_bill == null) ? 0 : montgomery_gi_bill.hashCode());
        result = prime * result + ((out_of_state_public == null) ? 0 : out_of_state_public.hashCode());
        result = prime * result + ((refunds_from_dch == null) ? 0 : refunds_from_dch.hashCode());
        result = prime * result + ((restitutions_settlements == null) ? 0 : restitutions_settlements.hashCode());
        result = prime * result + ((senior_companion == null) ? 0 : senior_companion.hashCode());
        result = prime * result + ((severance_pay == null) ? 0 : severance_pay.hashCode());
        result = prime * result + ((strike_benefits == null) ? 0 : strike_benefits.hashCode());
        result = prime * result + ((trade_readjustment == null) ? 0 : trade_readjustment.hashCode());
        result = prime * result + ((uniform_relocation == null) ? 0 : uniform_relocation.hashCode());
        result = prime * result + ((union_funds == null) ? 0 : union_funds.hashCode());
        result = prime * result + ((vendor_excluded == null) ? 0 : vendor_excluded.hashCode());
        result = prime * result + ((victim_restitution == null) ? 0 : victim_restitution.hashCode());
        result = prime * result + ((volunteer_payment == null) ? 0 : volunteer_payment.hashCode());
        result = prime * result + ((volunteer_payment_titlei == null) ? 0 : volunteer_payment_titlei.hashCode());
        result = prime * result + ((wia_training_and_allowance == null) ? 0 : wia_training_and_allowance.hashCode());
        result = prime * result + ((included_unearned_income == null) ? 0 : included_unearned_income.hashCode());
        result = prime * result + ((tanf_max_au_allotment == null) ? 0 : tanf_max_au_allotment.hashCode());
        result = prime * result + ((tanf_max_grg_allotment == null) ? 0 : tanf_max_grg_allotment.hashCode());
        result = prime * result + ((charitable_donation == null) ? 0 : charitable_donation.hashCode());
        result = prime * result + ((child_nutrition_payments == null) ? 0 : child_nutrition_payments.hashCode());
        result = prime * result + ((black_lung_benefits == null) ? 0 : black_lung_benefits.hashCode());
        result = prime * result + ((child_support_court == null) ? 0 : child_support_court.hashCode());
        result = prime * result + ((child_support_gap_payment == null) ? 0 : child_support_gap_payment.hashCode());
        result = prime * result + ((civil_service == null) ? 0 : civil_service.hashCode());
        result = prime * result + ((deferred_compensation_plans == null) ? 0 : deferred_compensation_plans.hashCode());
        result = prime * result + ((disability_insurance == null) ? 0 : disability_insurance.hashCode());
        result = prime * result + ((excluded_unearned_income == null) ? 0 : excluded_unearned_income.hashCode());
        result = prime * result + ((fema_payment_disaster == null) ? 0 : fema_payment_disaster.hashCode());
        result = prime * result + ((fema_payment_non_disaster == null) ? 0 : fema_payment_non_disaster.hashCode());
        result = prime * result + ((health_savings_account == null) ? 0 : health_savings_account.hashCode());
        result = prime * result + ((in_kind_support == null) ? 0 : in_kind_support.hashCode());
        result = prime * result + ((foster_grandparent_program == null) ? 0 : foster_grandparent_program.hashCode());
        result = prime * result + ((disaster_unemployment == null) ? 0 : disaster_unemployment.hashCode());
        result = prime * result + ((dividends == null) ? 0 : dividends.hashCode());
        result = prime * result + ((charitable_donation_federal == null) ? 0 : charitable_donation_federal.hashCode());       
        result = prime * result + ((bonds == null) ? 0 : bonds.hashCode());
        result = prime * result + ((dividend == null) ? 0 : dividend.hashCode());
        result = prime * result + ((health_reimbursement_account == null) ? 0 : health_reimbursement_account.hashCode());
        result = prime * result + ((individual_development_account == null) ? 0 : individual_development_account.hashCode());
        result = prime * result + ((uniform_gifts_to_minors == null) ? 0 : uniform_gifts_to_minors.hashCode());  
        result = prime * result + ((inheritance_income == null) ? 0 : inheritance_income.hashCode());
        result = prime * result + ((personal_info == null) ? 0 : personal_info.hashCode());
        result = prime * result + ((patient_fund == null) ? 0 : patient_fund.hashCode()); 
        result = prime * result + ((disaster_assistance == null) ? 0 : disaster_assistance.hashCode()); 
        result = prime * result + ((non_business_equipment == null) ? 0 : non_business_equipment.hashCode()); 
        result = prime * result + ((household_goods == null) ? 0 : household_goods.hashCode()); 
        result = prime * result + ((other_non_countable == null) ? 0 : other_non_countable.hashCode()); 
        result = prime * result + ((out_st_bnft_chg_ind == null) ? 0 : out_st_bnft_chg_ind.hashCode());
        result = prime * result + ((schl_enrl_chg_ind == null) ? 0 : schl_enrl_chg_ind.hashCode());
        result = prime * result + ((mrtl_stat_chg_ind == null) ? 0 : mrtl_stat_chg_ind.hashCode());
        result = prime * result + ((nur_hme_chg_ind == null) ? 0 : nur_hme_chg_ind.hashCode());
        result = prime * result + ((bfr_tax_chg_ind == null) ? 0 : bfr_tax_chg_ind.hashCode());
        result = prime * result + ((inc_tax_chg_ind == null) ? 0 : inc_tax_chg_ind.hashCode());
        result = prime * result + ((thrd_prty_chg_ind == null) ? 0 : thrd_prty_chg_ind.hashCode());
        result = prime * result + ((death_benefit_state_federal == null) ? 0 : death_benefit_state_federal.hashCode());
        result = prime * result + ((social_security_survivor == null) ? 0 : social_security_survivor.hashCode());
        result = prime * result + ((vendor_payments == null) ? 0 : vendor_payments.hashCode());
        result = prime * result + ((citizenship_chg_ind == null) ? 0 : citizenship_chg_ind.hashCode());
        result = prime * result + ((demographics_chg_ind == null) ? 0 : demographics_chg_ind.hashCode());
        result = prime * result + ((alien_chg_ind == null) ? 0 : alien_chg_ind.hashCode());
        result = prime * result + ((util_bill_chg_Ind == null) ? 0 : util_bill_chg_Ind.hashCode());
        result = prime * result + ((citizenship_info == null) ? 0 : citizenship_info.hashCode());
        result = prime * result + ((indv_prgm_chg_ind == null) ? 0 : indv_prgm_chg_ind.hashCode());
        result = prime * result + ((empl_hlth_ins_resp == null) ? 0 : empl_hlth_ins_resp.hashCode());
        result = prime * result + ((avd_prsctn_fstf == null) ? 0 : avd_prsctn_fstf.hashCode());
        result = prime * result + ((cntrl_subs_resp == null) ? 0 : cntrl_subs_resp.hashCode());
        result = prime * result + ((heat_cool_src == null) ? 0 : heat_cool_src.hashCode());
        return result;
    }

	/* (non-Javadoc)
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
		final RMC_IN_PRFL_Cargo other = (RMC_IN_PRFL_Cargo) obj;
        if (able_to_conceive_resp == null) {
            if (other.able_to_conceive_resp != null) {
                return false;
            }
        } else if (!able_to_conceive_resp.equals(other.able_to_conceive_resp)) {
            return false;
        }
        if (acdt_resp == null) {
            if (other.acdt_resp != null) {
                return false;
            }
        } else if (!acdt_resp.equals(other.acdt_resp)) {
            return false;
        }
        if (adoptAssistance == null) {
            if (other.adoptAssistance != null) {
                return false;
            }
        } else if (!adoptAssistance.equals(other.adoptAssistance)) {
            return false;
        }
        if (adoptionPayments == null) {
            if (other.adoptionPayments != null) {
                return false;
            }
        } else if (!adoptionPayments.equals(other.adoptionPayments)) {
            return false;
        }
        if (adpt_asst_resp == null) {
            if (other.adpt_asst_resp != null) {
                return false;
            }
        } else if (!adpt_asst_resp.equals(other.adpt_asst_resp)) {
            return false;
        }
        if (agentOrangePayments == null) {
            if (other.agentOrangePayments != null) {
                return false;
            }
        } else if (!agentOrangePayments.equals(other.agentOrangePayments)) {
            return false;
        }
        if (alimony == null) {
            if (other.alimony != null) {
                return false;
            }
        } else if (!alimony.equals(other.alimony)) {
            return false;
        }
        if (almy_rcv_resp == null) {
            if (other.almy_rcv_resp != null) {
                return false;
            }
        } else if (!almy_rcv_resp.equals(other.almy_rcv_resp)) {
            return false;
        }
        if (app_num == null) {
            if (other.app_num != null) {
                return false;
            }
        } else if (!app_num.equals(other.app_num)) {
            return false;
        }
        if (avoid_prosc_resp == null) {
            if (other.avoid_prosc_resp != null) {
                return false;
            }
        } else if (!avoid_prosc_resp.equals(other.avoid_prosc_resp)) {
            return false;
        }
        if (before_tax_deduction_resp == null) {
            if (other.before_tax_deduction_resp != null) {
                return false;
            }
        } else if (!before_tax_deduction_resp.equals(other.before_tax_deduction_resp)) {
            return false;
        }
        if (benefit_black_lung_resp == null) {
            if (other.benefit_black_lung_resp != null) {
                return false;
            }
        } else if (!benefit_black_lung_resp.equals(other.benefit_black_lung_resp)) {
            return false;
        }
        if (benefits_on_strike_resp == null) {
            if (other.benefits_on_strike_resp != null) {
                return false;
            }
        } else if (!benefits_on_strike_resp.equals(other.benefits_on_strike_resp)) {
            return false;
        }
        if (bnft_anty_resp == null) {
            if (other.bnft_anty_resp != null) {
                return false;
            }
        } else if (!bnft_anty_resp.equals(other.bnft_anty_resp)) {
            return false;
        }
        if (bnft_chl_sprt_resp == null) {
            if (other.bnft_chl_sprt_resp != null) {
                return false;
            }
        } else if (!bnft_chl_sprt_resp.equals(other.bnft_chl_sprt_resp)) {
            return false;
        }
        if (bnft_chrt_resp == null) {
            if (other.bnft_chrt_resp != null) {
                return false;
            }
        } else if (!bnft_chrt_resp.equals(other.bnft_chrt_resp)) {
            return false;
        }
        if (bnft_dabl_resp == null) {
            if (other.bnft_dabl_resp != null) {
                return false;
            }
        } else if (!bnft_dabl_resp.equals(other.bnft_dabl_resp)) {
            return false;
        }
        if (bnft_divnd_resp == null) {
            if (other.bnft_divnd_resp != null) {
                return false;
            }
        } else if (!bnft_divnd_resp.equals(other.bnft_divnd_resp)) {
            return false;
        }
        if (bnft_est_trst_resp == null) {
            if (other.bnft_est_trst_resp != null) {
                return false;
            }
        } else if (!bnft_est_trst_resp.equals(other.bnft_est_trst_resp)) {
            return false;
        }
        if (bnft_mapp_resp == null) {
            if (other.bnft_mapp_resp != null) {
                return false;
            }
        } else if (!bnft_mapp_resp.equals(other.bnft_mapp_resp)) {
            return false;
        }
        if (bnft_rr_resp == null) {
            if (other.bnft_rr_resp != null) {
                return false;
            }
        } else if (!bnft_rr_resp.equals(other.bnft_rr_resp)) {
            return false;
        }
        if (bnft_uempl_resp == null) {
            if (other.bnft_uempl_resp != null) {
                return false;
            }
        } else if (!bnft_uempl_resp.equals(other.bnft_uempl_resp)) {
            return false;
        }
        if (bnft_vet_resp == null) {
            if (other.bnft_vet_resp != null) {
                return false;
            }
        } else if (!bnft_vet_resp.equals(other.bnft_vet_resp)) {
            return false;
        }
        if (btd_def_comp == null) {
            if (other.btd_def_comp != null) {
                return false;
            }
        } else if (!btd_def_comp.equals(other.btd_def_comp)) {
            return false;
        }
        if (btd_dent_ins == null) {
            if (other.btd_dent_ins != null) {
                return false;
            }
        } else if (!btd_dent_ins.equals(other.btd_dent_ins)) {
            return false;
        }
        if (btd_flex_acc == null) {
            if (other.btd_flex_acc != null) {
                return false;
            }
        } else if (!btd_flex_acc.equals(other.btd_flex_acc)) {
            return false;
        }
        if (btd_med_ins == null) {
            if (other.btd_med_ins != null) {
                return false;
            }
        } else if (!btd_med_ins.equals(other.btd_med_ins)) {
            return false;
        }
        if (btd_other == null) {
            if (other.btd_other != null) {
                return false;
            }
        } else if (!btd_other.equals(other.btd_other)) {
            return false;
        }
        if (btd_pre_tax_ins == null) {
            if (other.btd_pre_tax_ins != null) {
                return false;
            }
        } else if (!btd_pre_tax_ins.equals(other.btd_pre_tax_ins)) {
            return false;
        }
        if (btd_vis_care_ins == null) {
            if (other.btd_vis_care_ins != null) {
                return false;
            }
        } else if (!btd_vis_care_ins.equals(other.btd_vis_care_ins)) {
            return false;
        }
        if (bury_aset_c_resp == null) {
            if (other.bury_aset_c_resp != null) {
                return false;
            }
        } else if (!bury_aset_c_resp.equals(other.bury_aset_c_resp)) {
            return false;
        }
        if (bury_aset_ibt_resp == null) {
            if (other.bury_aset_ibt_resp != null) {
                return false;
            }
        } else if (!bury_aset_ibt_resp.equals(other.bury_aset_ibt_resp)) {
            return false;
        }
        if (bury_aset_ins_resp == null) {
            if (other.bury_aset_ins_resp != null) {
                return false;
            }
        } else if (!bury_aset_ins_resp.equals(other.bury_aset_ins_resp)) {
            return false;
        }
        if (bury_aset_mas_resp == null) {
            if (other.bury_aset_mas_resp != null) {
                return false;
            }
        } else if (!bury_aset_mas_resp.equals(other.bury_aset_mas_resp)) {
            return false;
        }
        if (bury_aset_oth_resp == null) {
            if (other.bury_aset_oth_resp != null) {
                return false;
            }
        } else if (!bury_aset_oth_resp.equals(other.bury_aset_oth_resp)) {
            return false;
        }
        if (bury_aset_plt_resp == null) {
            if (other.bury_aset_plt_resp != null) {
                return false;
            }
        } else if (!bury_aset_plt_resp.equals(other.bury_aset_plt_resp)) {
            return false;
        }
        if (bury_aset_rbt_resp == null) {
            if (other.bury_aset_rbt_resp != null) {
                return false;
            }
        } else if (!bury_aset_rbt_resp.equals(other.bury_aset_rbt_resp)) {
            return false;
        }
        if (bury_aset_v_resp == null) {
            if (other.bury_aset_v_resp != null) {
                return false;
            }
        } else if (!bury_aset_v_resp.equals(other.bury_aset_v_resp)) {
            return false;
        }
        if (buy_sell_snap_resp == null) {
            if (other.buy_sell_snap_resp != null) {
                return false;
            }
        } else if (!buy_sell_snap_resp.equals(other.buy_sell_snap_resp)) {
            return false;
        }
        if (capitalGains == null) {
            if (other.capitalGains != null) {
                return false;
            }
        } else if (!capitalGains.equals(other.capitalGains)) {
            return false;
        }
        if (careTaker_resp == null) {
            if (other.careTaker_resp != null) {
                return false;
            }
        } else if (!careTaker_resp.equals(other.careTaker_resp)) {
            return false;
        }
        if (cash_gifts_resp == null) {
            if (other.cash_gifts_resp != null) {
                return false;
            }
        } else if (!cash_gifts_resp.equals(other.cash_gifts_resp)) {
            return false;
        }
        if (child_adult_care_resp == null) {
            if (other.child_adult_care_resp != null) {
                return false;
            }
        } else if (!child_adult_care_resp.equals(other.child_adult_care_resp)) {
            return false;
        }
        if (child_care_resp == null) {
            if (other.child_care_resp != null) {
                return false;
            }
        } else if (!child_care_resp.equals(other.child_care_resp)) {
            return false;
        }
        if (child_obligation_resp == null) {
            if (other.child_obligation_resp != null) {
                return false;
            }
        } else if (!child_obligation_resp.equals(other.child_obligation_resp)) {
            return false;
        }
        if (child_protective_resp == null) {
            if (other.child_protective_resp != null) {
                return false;
            }
        } else if (!child_protective_resp.equals(other.child_protective_resp)) {
            return false;
        }
        if (child_support_arr_resp == null) {
            if (other.child_support_arr_resp != null) {
                return false;
            }
        } else if (!child_support_arr_resp.equals(other.child_support_arr_resp)) {
            return false;
        }
        if (chld_sprt_pay_resp == null) {
            if (other.chld_sprt_pay_resp != null) {
                return false;
            }
        } else if (!chld_sprt_pay_resp.equals(other.chld_sprt_pay_resp)) {
            return false;
        }
        if (convic_false_info_resp == null) {
            if (other.convic_false_info_resp != null) {
                return false;
            }
        } else if (!convic_false_info_resp.equals(other.convic_false_info_resp)) {
            return false;
        }
        if (cooking_fuel_resp == null) {
            if (other.cooking_fuel_resp != null) {
                return false;
            }
        } else if (!cooking_fuel_resp.equals(other.cooking_fuel_resp)) {
            return false;
        }
        if (cooling_resp == null) {
            if (other.cooling_resp != null) {
                return false;
            }
        } else if (!cooling_resp.equals(other.cooling_resp)) {
            return false;
        }
        if (coop_condo_fee_resp == null) {
            if (other.coop_condo_fee_resp != null) {
                return false;
            }
        } else if (!coop_condo_fee_resp.equals(other.coop_condo_fee_resp)) {
            return false;
        }
        if (cp_wlst_resp == null) {
            if (other.cp_wlst_resp != null) {
                return false;
            }
        } else if (!cp_wlst_resp.equals(other.cp_wlst_resp)) {
            return false;
        }
        if (current_past_job_resp == null) {
            if (other.current_past_job_resp != null) {
                return false;
            }
        } else if (!current_past_job_resp.equals(other.current_past_job_resp)) {
            return false;
        }
        if (dabl_resp == null) {
            if (other.dabl_resp != null) {
                return false;
            }
        } else if (!dabl_resp.equals(other.dabl_resp)) {
            return false;
        }
        if (deathBenefits == null) {
            if (other.deathBenefits != null) {
                return false;
            }
        } else if (!deathBenefits.equals(other.deathBenefits)) {
            return false;
        }
        if (disabilityIncome == null) {
            if (other.disabilityIncome != null) {
                return false;
            }
        } else if (!disabilityIncome.equals(other.disabilityIncome)) {
            return false;
        }
        if (disasterRelief == null) {
            if (other.disasterRelief != null) {
                return false;
            }
        } else if (!disasterRelief.equals(other.disasterRelief)) {
            return false;
        }
        if (disaster_repair_resp == null) {
            if (other.disaster_repair_resp != null) {
                return false;
            }
        } else if (!disaster_repair_resp.equals(other.disaster_repair_resp)) {
            return false;
        }
        if (domestic_violence_resp == null) {
            if (other.domestic_violence_resp != null) {
                return false;
            }
        } else if (!domestic_violence_resp.equals(other.domestic_violence_resp)) {
            return false;
        }
        if (dpnd_care_resp == null) {
            if (other.dpnd_care_resp != null) {
                return false;
            }
        } else if (!dpnd_care_resp.equals(other.dpnd_care_resp)) {
            return false;
        }
        if (drug_feln_resp == null) {
            if (other.drug_feln_resp != null) {
                return false;
            }
        } else if (!drug_feln_resp.equals(other.drug_feln_resp)) {
            return false;
        }
        if (drug_felonies_resp == null) {
            if (other.drug_felonies_resp != null) {
                return false;
            }
        } else if (!drug_felonies_resp.equals(other.drug_felonies_resp)) {
            return false;
        }
        if (educ_aid_resp == null) {
            if (other.educ_aid_resp != null) {
                return false;
            }
        } else if (!educ_aid_resp.equals(other.educ_aid_resp)) {
            return false;
        }
        if (educationalAssistance == null) {
            if (other.educationalAssistance != null) {
                return false;
            }
        } else if (!educationalAssistance.equals(other.educationalAssistance)) {
            return false;
        }
        if (emergency_medical_resp == null) {
            if (other.emergency_medical_resp != null) {
                return false;
            }
        } else if (!emergency_medical_resp.equals(other.emergency_medical_resp)) {
            return false;
        }
        if (emergency_medical_service_resp == null) {
            if (other.emergency_medical_service_resp != null) {
                return false;
            }
        } else if (!emergency_medical_service_resp.equals(other.emergency_medical_service_resp)) {
            return false;
        }
        if (empl_resp == null) {
            if (other.empl_resp != null) {
                return false;
            }
        } else if (!empl_resp.equals(other.empl_resp)) {
            return false;
        }
        if (energyAssistance == null) {
            if (other.energyAssistance != null) {
                return false;
            }
        } else if (!energyAssistance.equals(other.energyAssistance)) {
            return false;
        }
        if (farmAllotment == null) {
            if (other.farmAllotment != null) {
                return false;
            }
        } else if (!farmAllotment.equals(other.farmAllotment)) {
            return false;
        }
        if (food_clothing_util_rent_resp == null) {
            if (other.food_clothing_util_rent_resp != null) {
                return false;
            }
        } else if (!food_clothing_util_rent_resp.equals(other.food_clothing_util_rent_resp)) {
            return false;
        }
        if (former_foster_resp == null) {
            if (other.former_foster_resp != null) {
                return false;
            }
        } else if (!former_foster_resp.equals(other.former_foster_resp)) {
            return false;
        }
        if (fosterCarePayments == null) {
            if (other.fosterCarePayments != null) {
                return false;
            }
        } else if (!fosterCarePayments.equals(other.fosterCarePayments)) {
            return false;
        }
        if (foster_care_resp == null) {
            if (other.foster_care_resp != null) {
                return false;
            }
        } else if (!foster_care_resp.equals(other.foster_care_resp)) {
            return false;
        }
        if (fset_sctn_resp == null) {
            if (other.fset_sctn_resp != null) {
                return false;
            }
        } else if (!fset_sctn_resp.equals(other.fset_sctn_resp)) {
            return false;
        }
        if (fstr_care_resp == null) {
            if (other.fstr_care_resp != null) {
                return false;
            }
        } else if (!fstr_care_resp.equals(other.fstr_care_resp)) {
            return false;
        }
        if (gen_rlf_resp == null) {
            if (other.gen_rlf_resp != null) {
                return false;
            }
        } else if (!gen_rlf_resp.equals(other.gen_rlf_resp)) {
            return false;
        }
        if (generalAssistance == null) {
            if (other.generalAssistance != null) {
                return false;
            }
        } else if (!generalAssistance.equals(other.generalAssistance)) {
            return false;
        }
        if (grand_parent_resp == null) {
            if (other.grand_parent_resp != null) {
                return false;
            }
        } else if (!grand_parent_resp.equals(other.grand_parent_resp)) {
            return false;
        }
        if (hc_cvrg_resp == null) {
            if (other.hc_cvrg_resp != null) {
                return false;
            }
        } else if (!hc_cvrg_resp.equals(other.hc_cvrg_resp)) {
            return false;
        }
        if (head_of_household_resp == null) {
            if (other.head_of_household_resp != null) {
                return false;
            }
        } else if (!head_of_household_resp.equals(other.head_of_household_resp)) {
            return false;
        }
        if (heating_resp == null) {
            if (other.heating_resp != null) {
                return false;
            }
        } else if (!heating_resp.equals(other.heating_resp)) {
            return false;
        }
        if (hlth_ins_resp == null) {
            if (other.hlth_ins_resp != null) {
                return false;
            }
        } else if (!hlth_ins_resp.equals(other.hlth_ins_resp)) {
            return false;
        }
        if (home_community_resp == null) {
            if (other.home_community_resp != null) {
                return false;
            }
        } else if (!home_community_resp.equals(other.home_community_resp)) {
            return false;
        }
        if (home_equity_resp == null) {
            if (other.home_equity_resp != null) {
                return false;
            }
        } else if (!home_equity_resp.equals(other.home_equity_resp)) {
            return false;
        }
        if (hospice_resp == null) {
            if (other.hospice_resp != null) {
                return false;
            }
        } else if (!hospice_resp.equals(other.hospice_resp)) {
            return false;
        }
        if (hospital_stay_resp == null) {
            if (other.hospital_stay_resp != null) {
                return false;
            }
        } else if (!hospital_stay_resp.equals(other.hospital_stay_resp)) {
            return false;
        }
        if (housing_bill_others_resp == null) {
            if (other.housing_bill_others_resp != null) {
                return false;
            }
        } else if (!housing_bill_others_resp.equals(other.housing_bill_others_resp)) {
            return false;
        }
        if (iRADistribution == null) {
            if (other.iRADistribution != null) {
                return false;
            }
        } else if (!iRADistribution.equals(other.iRADistribution)) {
            return false;
        }
        if (incm_int_resp == null) {
            if (other.incm_int_resp != null) {
                return false;
            }
        } else if (!incm_int_resp.equals(other.incm_int_resp)) {
            return false;
        }
        if (indv_cc_rqst_ind == null) {
            if (other.indv_cc_rqst_ind != null) {
                return false;
            }
        } else if (!indv_cc_rqst_ind.equals(other.indv_cc_rqst_ind)) {
            return false;
        }
        if (indv_cla_ind == null) {
            if (other.indv_cla_ind != null) {
                return false;
            }
        } else if (!indv_cla_ind.equals(other.indv_cla_ind)) {
            return false;
        }
        if (indv_fma_rqst_ind == null) {
            if (other.indv_fma_rqst_ind != null) {
                return false;
            }
        } else if (!indv_fma_rqst_ind.equals(other.indv_fma_rqst_ind)) {
            return false;
        }
        if (indv_fpw_rqst_ind == null) {
            if (other.indv_fpw_rqst_ind != null) {
                return false;
            }
        } else if (!indv_fpw_rqst_ind.equals(other.indv_fpw_rqst_ind)) {
            return false;
        }
        if (indv_fs_rqst_ind == null) {
            if (other.indv_fs_rqst_ind != null) {
                return false;
            }
        } else if (!indv_fs_rqst_ind.equals(other.indv_fs_rqst_ind)) {
            return false;
        }
        if (indv_seq_num == null) {
            if (other.indv_seq_num != null) {
                return false;
            }
        } else if (!indv_seq_num.equals(other.indv_seq_num)) {
            return false;
        }
        if (indv_tanf_rqst_ind == null) {
            if (other.indv_tanf_rqst_ind != null) {
                return false;
            }
        } else if (!indv_tanf_rqst_ind.equals(other.indv_tanf_rqst_ind)) {
            return false;
        }
        if (indv_wic_rqst_ind == null) {
            if (other.indv_wic_rqst_ind != null) {
                return false;
            }
        } else if (!indv_wic_rqst_ind.equals(other.indv_wic_rqst_ind)) {
            return false;
        }
        if (inheritance_resp == null) {
            if (other.inheritance_resp != null) {
                return false;
            }
        } else if (!inheritance_resp.equals(other.inheritance_resp)) {
            return false;
        }
        if (insurance_settlement_resp == null) {
            if (other.insurance_settlement_resp != null) {
                return false;
            }
        } else if (!insurance_settlement_resp.equals(other.insurance_settlement_resp)) {
            return false;
        }
        if (interestDividendPayments == null) {
            if (other.interestDividendPayments != null) {
                return false;
            }
        } else if (!interestDividendPayments.equals(other.interestDividendPayments)) {
            return false;
        }
        if (irwe_resp == null) {
            if (other.irwe_resp != null) {
                return false;
            }
        } else if (!irwe_resp.equals(other.irwe_resp)) {
            return false;
        }
        if (job_iknd_resp == null) {
            if (other.job_iknd_resp != null) {
                return false;
            }
        } else if (!job_iknd_resp.equals(other.job_iknd_resp)) {
            return false;
        }
        if (kinship_care_resp == null) {
            if (other.kinship_care_resp != null) {
                return false;
            }
        } else if (!kinship_care_resp.equals(other.kinship_care_resp)) {
            return false;
        }
        if (land_cont_resp == null) {
            if (other.land_cont_resp != null) {
                return false;
            }
        } else if (!land_cont_resp.equals(other.land_cont_resp)) {
            return false;
        }
        if (li_aset_g_l_resp == null) {
            if (other.li_aset_g_l_resp != null) {
                return false;
            }
        } else if (!li_aset_g_l_resp.equals(other.li_aset_g_l_resp)) {
            return false;
        }
        if (li_aset_g_t_resp == null) {
            if (other.li_aset_g_t_resp != null) {
                return false;
            }
        } else if (!li_aset_g_t_resp.equals(other.li_aset_g_t_resp)) {
            return false;
        }
        if (li_aset_trm_resp == null) {
            if (other.li_aset_trm_resp != null) {
                return false;
            }
        } else if (!li_aset_trm_resp.equals(other.li_aset_trm_resp)) {
            return false;
        }
        if (li_aset_unv_resp == null) {
            if (other.li_aset_unv_resp != null) {
                return false;
            }
        } else if (!li_aset_unv_resp.equals(other.li_aset_unv_resp)) {
            return false;
        }
        if (li_aset_w_l_resp == null) {
            if (other.li_aset_w_l_resp != null) {
                return false;
            }
        } else if (!li_aset_w_l_resp.equals(other.li_aset_w_l_resp)) {
            return false;
        }
        if (life_ins_asest_group_life_resp == null) {
            if (other.life_ins_asest_group_life_resp != null) {
                return false;
            }
        } else if (!life_ins_asest_group_life_resp.equals(other.life_ins_asest_group_life_resp)) {
            return false;
        }
        if (life_ins_asset_group_term_resp == null) {
            if (other.life_ins_asset_group_term_resp != null) {
                return false;
            }
        } else if (!life_ins_asset_group_term_resp.equals(other.life_ins_asset_group_term_resp)) {
            return false;
        }
        if (life_ins_asset_universal_resp == null) {
            if (other.life_ins_asset_universal_resp != null) {
                return false;
            }
        } else if (!life_ins_asset_universal_resp.equals(other.life_ins_asset_universal_resp)) {
            return false;
        }
        if (life_ins_asset_whole_life_resp == null) {
            if (other.life_ins_asset_whole_life_resp != null) {
                return false;
            }
        } else if (!life_ins_asset_whole_life_resp.equals(other.life_ins_asset_whole_life_resp)) {
            return false;
        }
        if (life_insurance_asset_term_resp == null) {
            if (other.life_insurance_asset_term_resp != null) {
                return false;
            }
        } else if (!life_insurance_asset_term_resp.equals(other.life_insurance_asset_term_resp)) {
            return false;
        }
        if (life_insurance_other_resp == null) {
            if (other.life_insurance_other_resp != null) {
                return false;
            }
        } else if (!life_insurance_other_resp.equals(other.life_insurance_other_resp)) {
            return false;
        }
        if (liquid_aset_disable_blind_resp == null) {
            if (other.liquid_aset_disable_blind_resp != null) {
                return false;
            }
        } else if (!liquid_aset_disable_blind_resp.equals(other.liquid_aset_disable_blind_resp)) {
            return false;
        }
        if (liquid_asset_bank_acc_resp == null) {
            if (other.liquid_asset_bank_acc_resp != null) {
                return false;
            }
        } else if (!liquid_asset_bank_acc_resp.equals(other.liquid_asset_bank_acc_resp)) {
            return false;
        }
        if (liquid_asset_cash_resp == null) {
            if (other.liquid_asset_cash_resp != null) {
                return false;
            }
        } else if (!liquid_asset_cash_resp.equals(other.liquid_asset_cash_resp)) {
            return false;
        }
        if (liquid_asset_ira_resp == null) {
            if (other.liquid_asset_ira_resp != null) {
                return false;
            }
        } else if (!liquid_asset_ira_resp.equals(other.liquid_asset_ira_resp)) {
            return false;
        }
        if (liquid_asset_irs_retirmnt_resp == null) {
            if (other.liquid_asset_irs_retirmnt_resp != null) {
                return false;
            }
        } else if (!liquid_asset_irs_retirmnt_resp.equals(other.liquid_asset_irs_retirmnt_resp)) {
            return false;
        }
        if (liquid_asset_other_response == null) {
            if (other.liquid_asset_other_response != null) {
                return false;
            }
        } else if (!liquid_asset_other_response.equals(other.liquid_asset_other_response)) {
            return false;
        }
        if (liquid_asset_other_type_resp == null) {
            if (other.liquid_asset_other_type_resp != null) {
                return false;
            }
        } else if (!liquid_asset_other_type_resp.equals(other.liquid_asset_other_type_resp)) {
            return false;
        }
        if (liquid_asset_pension_plan_resp == null) {
            if (other.liquid_asset_pension_plan_resp != null) {
                return false;
            }
        } else if (!liquid_asset_pension_plan_resp.equals(other.liquid_asset_pension_plan_resp)) {
            return false;
        }
        if (liquid_asset_promissory_resp == null) {
            if (other.liquid_asset_promissory_resp != null) {
                return false;
            }
        } else if (!liquid_asset_promissory_resp.equals(other.liquid_asset_promissory_resp)) {
            return false;
        }
        if (liquid_asset_retirement_resp == null) {
            if (other.liquid_asset_retirement_resp != null) {
                return false;
            }
        } else if (!liquid_asset_retirement_resp.equals(other.liquid_asset_retirement_resp)) {
            return false;
        }
        if (liquid_asset_savings_acc_resp == null) {
            if (other.liquid_asset_savings_acc_resp != null) {
                return false;
            }
        } else if (!liquid_asset_savings_acc_resp.equals(other.liquid_asset_savings_acc_resp)) {
            return false;
        }
        if (liquid_asset_stocks_bonds_resp == null) {
            if (other.liquid_asset_stocks_bonds_resp != null) {
                return false;
            }
        } else if (!liquid_asset_stocks_bonds_resp.equals(other.liquid_asset_stocks_bonds_resp)) {
            return false;
        }
        if (liquid_asset_trust_fund_resp == null) {
            if (other.liquid_asset_trust_fund_resp != null) {
                return false;
            }
        } else if (!liquid_asset_trust_fund_resp.equals(other.liquid_asset_trust_fund_resp)) {
            return false;
        }
        if (living_prog_resp == null) {
            if (other.living_prog_resp != null) {
                return false;
            }
        } else if (!living_prog_resp.equals(other.living_prog_resp)) {
            return false;
        }
        if (loan_resp == null) {
            if (other.loan_resp != null) {
                return false;
            }
        } else if (!loan_resp.equals(other.loan_resp)) {
            return false;
        }
        if (lost_health_ins_ind == null) {
            if (other.lost_health_ins_ind != null) {
                return false;
            }
        } else if (!lost_health_ins_ind.equals(other.lost_health_ins_ind)) {
            return false;
        }
        if (lotteryWinnings == null) {
            if (other.lotteryWinnings != null) {
                return false;
            }
        } else if (!lotteryWinnings.equals(other.lotteryWinnings)) {
            return false;
        }
        if (lottery_prize_winning_resp == null) {
            if (other.lottery_prize_winning_resp != null) {
                return false;
            }
        } else if (!lottery_prize_winning_resp.equals(other.lottery_prize_winning_resp)) {
            return false;
        }
        if (lqd_aset_c_a_resp == null) {
            if (other.lqd_aset_c_a_resp != null) {
                return false;
            }
        } else if (!lqd_aset_c_a_resp.equals(other.lqd_aset_c_a_resp)) {
            return false;
        }
        if (lqd_aset_eb_a_resp == null) {
            if (other.lqd_aset_eb_a_resp != null) {
                return false;
            }
        } else if (!lqd_aset_eb_a_resp.equals(other.lqd_aset_eb_a_resp)) {
            return false;
        }
        if (lqd_aset_h_s_resp == null) {
            if (other.lqd_aset_h_s_resp != null) {
                return false;
            }
        } else if (!lqd_aset_h_s_resp.equals(other.lqd_aset_h_s_resp)) {
            return false;
        }
        if (lqd_aset_ira_resp == null) {
            if (other.lqd_aset_ira_resp != null) {
                return false;
            }
        } else if (!lqd_aset_ira_resp.equals(other.lqd_aset_ira_resp)) {
            return false;
        }
        if (lqd_aset_k_p_resp == null) {
            if (other.lqd_aset_k_p_resp != null) {
                return false;
            }
        } else if (!lqd_aset_k_p_resp.equals(other.lqd_aset_k_p_resp)) {
            return false;
        }
        if (lqd_aset_m_o_resp == null) {
            if (other.lqd_aset_m_o_resp != null) {
                return false;
            }
        } else if (!lqd_aset_m_o_resp.equals(other.lqd_aset_m_o_resp)) {
            return false;
        }
        if (lqd_aset_mm_a_resp == null) {
            if (other.lqd_aset_mm_a_resp != null) {
                return false;
            }
        } else if (!lqd_aset_mm_a_resp.equals(other.lqd_aset_mm_a_resp)) {
            return false;
        }
        if (lqd_aset_o_t_resp == null) {
            if (other.lqd_aset_o_t_resp != null) {
                return false;
            }
        } else if (!lqd_aset_o_t_resp.equals(other.lqd_aset_o_t_resp)) {
            return false;
        }
        if (lqd_aset_othr_resp == null) {
            if (other.lqd_aset_othr_resp != null) {
                return false;
            }
        } else if (!lqd_aset_othr_resp.equals(other.lqd_aset_othr_resp)) {
            return false;
        }
        if (lqd_aset_s_a_resp == null) {
            if (other.lqd_aset_s_a_resp != null) {
                return false;
            }
        } else if (!lqd_aset_s_a_resp.equals(other.lqd_aset_s_a_resp)) {
            return false;
        }
        if (lqd_aset_s_c_resp == null) {
            if (other.lqd_aset_s_c_resp != null) {
                return false;
            }
        } else if (!lqd_aset_s_c_resp.equals(other.lqd_aset_s_c_resp)) {
            return false;
        }
        if (lqd_aset_st_b_resp == null) {
            if (other.lqd_aset_st_b_resp != null) {
                return false;
            }
        } else if (!lqd_aset_st_b_resp.equals(other.lqd_aset_st_b_resp)) {
            return false;
        }
        if (lqd_aset_tr_f_resp == null) {
            if (other.lqd_aset_tr_f_resp != null) {
                return false;
            }
        } else if (!lqd_aset_tr_f_resp.equals(other.lqd_aset_tr_f_resp)) {
            return false;
        }
        if (lqd_aset_us_b_resp == null) {
            if (other.lqd_aset_us_b_resp != null) {
                return false;
            }
        } else if (!lqd_aset_us_b_resp.equals(other.lqd_aset_us_b_resp)) {
            return false;
        }
        if (lumpSum == null) {
            if (other.lumpSum != null) {
                return false;
            }
        } else if (!lumpSum.equals(other.lumpSum)) {
            return false;
        }
        if (med_exp_resp == null) {
            if (other.med_exp_resp != null) {
                return false;
            }
        } else if (!med_exp_resp.equals(other.med_exp_resp)) {
            return false;
        }
        if (med_type_animal_resp == null) {
            if (other.med_type_animal_resp != null) {
                return false;
            }
        } else if (!med_type_animal_resp.equals(other.med_type_animal_resp)) {
            return false;
        }
        if (med_type_atndnt_meal_resp == null) {
            if (other.med_type_atndnt_meal_resp != null) {
                return false;
            }
        } else if (!med_type_atndnt_meal_resp.equals(other.med_type_atndnt_meal_resp)) {
            return false;
        }
        if (med_type_bills_resp == null) {
            if (other.med_type_bills_resp != null) {
                return false;
            }
        } else if (!med_type_bills_resp.equals(other.med_type_bills_resp)) {
            return false;
        }
        if (med_type_eyeglasses_resp == null) {
            if (other.med_type_eyeglasses_resp != null) {
                return false;
            }
        } else if (!med_type_eyeglasses_resp.equals(other.med_type_eyeglasses_resp)) {
            return false;
        }
        if (med_type_inhome_resp == null) {
            if (other.med_type_inhome_resp != null) {
                return false;
            }
        } else if (!med_type_inhome_resp.equals(other.med_type_inhome_resp)) {
            return false;
        }
        if (med_type_insurance_resp == null) {
            if (other.med_type_insurance_resp != null) {
                return false;
            }
        } else if (!med_type_insurance_resp.equals(other.med_type_insurance_resp)) {
            return false;
        }
        if (med_type_maintain_attndnt_resp == null) {
            if (other.med_type_maintain_attndnt_resp != null) {
                return false;
            }
        } else if (!med_type_maintain_attndnt_resp.equals(other.med_type_maintain_attndnt_resp)) {
            return false;
        }
        if (med_type_nursing_resp == null) {
            if (other.med_type_nursing_resp != null) {
                return false;
            }
        } else if (!med_type_nursing_resp.equals(other.med_type_nursing_resp)) {
            return false;
        }
        if (med_type_other_resp == null) {
            if (other.med_type_other_resp != null) {
                return false;
            }
        } else if (!med_type_other_resp.equals(other.med_type_other_resp)) {
            return false;
        }
        if (med_type_out_patient_resp == null) {
            if (other.med_type_out_patient_resp != null) {
                return false;
            }
        } else if (!med_type_out_patient_resp.equals(other.med_type_out_patient_resp)) {
            return false;
        }
        if (med_type_prescribed_drug_resp == null) {
            if (other.med_type_prescribed_drug_resp != null) {
                return false;
            }
        } else if (!med_type_prescribed_drug_resp.equals(other.med_type_prescribed_drug_resp)) {
            return false;
        }
        if (med_type_prosthetic_resp == null) {
            if (other.med_type_prosthetic_resp != null) {
                return false;
            }
        } else if (!med_type_prosthetic_resp.equals(other.med_type_prosthetic_resp)) {
            return false;
        }
        if (med_type_psychotherapy_resp == null) {
            if (other.med_type_psychotherapy_resp != null) {
                return false;
            }
        } else if (!med_type_psychotherapy_resp.equals(other.med_type_psychotherapy_resp)) {
            return false;
        }
        if (med_type_special_equip_resp == null) {
            if (other.med_type_special_equip_resp != null) {
                return false;
            }
        } else if (!med_type_special_equip_resp.equals(other.med_type_special_equip_resp)) {
            return false;
        }
        if (med_type_supplies_resp == null) {
            if (other.med_type_supplies_resp != null) {
                return false;
            }
        } else if (!med_type_supplies_resp.equals(other.med_type_supplies_resp)) {
            return false;
        }
        if (med_type_transportation_resp == null) {
            if (other.med_type_transportation_resp != null) {
                return false;
            }
        } else if (!med_type_transportation_resp.equals(other.med_type_transportation_resp)) {
            return false;
        }
        if (medical_bills_resp == null) {
            if (other.medical_bills_resp != null) {
                return false;
            }
        } else if (!medical_bills_resp.equals(other.medical_bills_resp)) {
            return false;
        }
        if (medical_service_resp == null) {
            if (other.medical_service_resp != null) {
                return false;
            }
        } else if (!medical_service_resp.equals(other.medical_service_resp)) {
            return false;
        }
        if (medtyp_attendant_care == null) {
            if (other.medtyp_attendant_care != null) {
                return false;
            }
        } else if (!medtyp_attendant_care.equals(other.medtyp_attendant_care)) {
            return false;
        }
        if (medtyp_dental == null) {
            if (other.medtyp_dental != null) {
                return false;
            }
        } else if (!medtyp_dental.equals(other.medtyp_dental)) {
            return false;
        }
        if (medtyp_doctor == null) {
            if (other.medtyp_doctor != null) {
                return false;
            }
        } else if (!medtyp_doctor.equals(other.medtyp_doctor)) {
            return false;
        }
        if (medtyp_hosp_bills == null) {
            if (other.medtyp_hosp_bills != null) {
                return false;
            }
        } else if (!medtyp_hosp_bills.equals(other.medtyp_hosp_bills)) {
            return false;
        }
        if (medtyp_hsa_contrib == null) {
            if (other.medtyp_hsa_contrib != null) {
                return false;
            }
        } else if (!medtyp_hsa_contrib.equals(other.medtyp_hsa_contrib)) {
            return false;
        }
        if (medtyp_insur_premium == null) {
            if (other.medtyp_insur_premium != null) {
                return false;
            }
        } else if (!medtyp_insur_premium.equals(other.medtyp_insur_premium)) {
            return false;
        }
        if (medtyp_med_equip == null) {
            if (other.medtyp_med_equip != null) {
                return false;
            }
        } else if (!medtyp_med_equip.equals(other.medtyp_med_equip)) {
            return false;
        }
        if (medtyp_other == null) {
            if (other.medtyp_other != null) {
                return false;
            }
        } else if (!medtyp_other.equals(other.medtyp_other)) {
            return false;
        }
        if (medtyp_rx_cost == null) {
            if (other.medtyp_rx_cost != null) {
                return false;
            }
        } else if (!medtyp_rx_cost.equals(other.medtyp_rx_cost)) {
            return false;
        }
        if (medtyp_trans_med == null) {
            if (other.medtyp_trans_med != null) {
                return false;
            }
        } else if (!medtyp_trans_med.equals(other.medtyp_trans_med)) {
            return false;
        }
        if (mi_heating_cred_resp == null) {
            if (other.mi_heating_cred_resp != null) {
                return false;
            }
        } else if (!mi_heating_cred_resp.equals(other.mi_heating_cred_resp)) {
            return false;
        }
        if (mil_allot_resp == null) {
            if (other.mil_allot_resp != null) {
                return false;
            }
        } else if (!mil_allot_resp.equals(other.mil_allot_resp)) {
            return false;
        }
        if (militaryAllotment == null) {
            if (other.militaryAllotment != null) {
                return false;
            }
        } else if (!militaryAllotment.equals(other.militaryAllotment)) {
            return false;
        }
        if (moneyFromAnotherPerson == null) {
            if (other.moneyFromAnotherPerson != null) {
                return false;
            }
        } else if (!moneyFromAnotherPerson.equals(other.moneyFromAnotherPerson)) {
            return false;
        }
        if (mony_othr_resp == null) {
            if (other.mony_othr_resp != null) {
                return false;
            }
        } else if (!mony_othr_resp.equals(other.mony_othr_resp)) {
            return false;
        }
        if (mortg_guar_ins_resp == null) {
            if (other.mortg_guar_ins_resp != null) {
                return false;
            }
        } else if (!mortg_guar_ins_resp.equals(other.mortg_guar_ins_resp)) {
            return false;
        }
        if (moved_into_home_response == null) {
            if (other.moved_into_home_response != null) {
                return false;
            }
        } else if (!moved_into_home_response.equals(other.moved_into_home_response)) {
            return false;
        }
        if (moved_out_of_home_resp == null) {
            if (other.moved_out_of_home_resp != null) {
                return false;
            }
        } else if (!moved_out_of_home_resp.equals(other.moved_out_of_home_resp)) {
            return false;
        }
        if (natl_rfge_resp == null) {
            if (other.natl_rfge_resp != null) {
                return false;
            }
        } else if (!natl_rfge_resp.equals(other.natl_rfge_resp)) {
            return false;
        }
        if (need_ind_resp == null) {
            if (other.need_ind_resp != null) {
                return false;
            }
        } else if (!need_ind_resp.equals(other.need_ind_resp)) {
            return false;
        }
        if (netRentalRoyalty == null) {
            if (other.netRentalRoyalty != null) {
                return false;
            }
        } else if (!netRentalRoyalty.equals(other.netRentalRoyalty)) {
            return false;
        }
        if (none_resp == null) {
            if (other.none_resp != null) {
                return false;
            }
        } else if (!none_resp.equals(other.none_resp)) {
            return false;
        }
        if (on_strk_sw == null) {
            if (other.on_strk_sw != null) {
                return false;
            }
        } else if (!on_strk_sw.equals(other.on_strk_sw)) {
            return false;
        }
        if (op_aoda_tmt_rcv_sw == null) {
            if (other.op_aoda_tmt_rcv_sw != null) {
                return false;
            }
        } else if (!op_aoda_tmt_rcv_sw.equals(other.op_aoda_tmt_rcv_sw)) {
            return false;
        }
        if (otherIncome == null) {
            if (other.otherIncome != null) {
                return false;
            }
        } else if (!otherIncome.equals(other.otherIncome)) {
            return false;
        }
        if (other_aset_life_insurance_resp == null) {
            if (other.other_aset_life_insurance_resp != null) {
                return false;
            }
        } else if (!other_aset_life_insurance_resp.equals(other.other_aset_life_insurance_resp)) {
            return false;
        }
        if (other_asset_burial_resp == null) {
            if (other.other_asset_burial_resp != null) {
                return false;
            }
        } else if (!other_asset_burial_resp.equals(other.other_asset_burial_resp)) {
            return false;
        }
        if (other_asset_personal_prop_resp == null) {
            if (other.other_asset_personal_prop_resp != null) {
                return false;
            }
        } else if (!other_asset_personal_prop_resp.equals(other.other_asset_personal_prop_resp)) {
            return false;
        }
        if (other_asset_real_property_resp == null) {
            if (other.other_asset_real_property_resp != null) {
                return false;
            }
        } else if (!other_asset_real_property_resp.equals(other.other_asset_real_property_resp)) {
            return false;
        }
        if (other_asset_transfer_resp == null) {
            if (other.other_asset_transfer_resp != null) {
                return false;
            }
        } else if (!other_asset_transfer_resp.equals(other.other_asset_transfer_resp)) {
            return false;
        }
        if (other_asset_vehicle_resp == null) {
            if (other.other_asset_vehicle_resp != null) {
                return false;
            }
        } else if (!other_asset_vehicle_resp.equals(other.other_asset_vehicle_resp)) {
            return false;
        }
        if (other_housing_bill_resp == null) {
            if (other.other_housing_bill_resp != null) {
                return false;
            }
        } else if (!other_housing_bill_resp.equals(other.other_housing_bill_resp)) {
            return false;
        }
        if (other_incm_contrib_resp == null) {
            if (other.other_incm_contrib_resp != null) {
                return false;
            }
        } else if (!other_incm_contrib_resp.equals(other.other_incm_contrib_resp)) {
            return false;
        }
        if (other_resp == null) {
            if (other.other_resp != null) {
                return false;
            }
        } else if (!other_resp.equals(other.other_resp)) {
            return false;
        }
        if (othr_hlth_ins_resp == null) {
            if (other.othr_hlth_ins_resp != null) {
                return false;
            }
        } else if (!othr_hlth_ins_resp.equals(other.othr_hlth_ins_resp)) {
            return false;
        }
        if (othr_incm_rentl_resp == null) {
            if (other.othr_incm_rentl_resp != null) {
                return false;
            }
        } else if (!othr_incm_rentl_resp.equals(other.othr_incm_rentl_resp)) {
            return false;
        }
        if (othr_incm_resp == null) {
            if (other.othr_incm_resp != null) {
                return false;
            }
        } else if (!othr_incm_resp.equals(other.othr_incm_resp)) {
            return false;
        }
        if (othr_incm_trbl_resp == null) {
            if (other.othr_incm_trbl_resp != null) {
                return false;
            }
        } else if (!othr_incm_trbl_resp.equals(other.othr_incm_trbl_resp)) {
            return false;
        }
        if (othr_social_security_bnft_resp == null) {
            if (other.othr_social_security_bnft_resp != null) {
                return false;
            }
        } else if (!othr_social_security_bnft_resp.equals(other.othr_social_security_bnft_resp)) {
            return false;
        }
        if (othr_src_resp == null) {
            if (other.othr_src_resp != null) {
                return false;
            }
        } else if (!othr_src_resp.equals(other.othr_src_resp)) {
            return false;
        }
        if (outstate_bnft_resp == null) {
            if (other.outstate_bnft_resp != null) {
                return false;
            }
        } else if (!outstate_bnft_resp.equals(other.outstate_bnft_resp)) {
            return false;
        }
        if (own_aset_resp == null) {
            if (other.own_aset_resp != null) {
                return false;
            }
        } else if (!own_aset_resp.equals(other.own_aset_resp)) {
            return false;
        }
        if (parole_violation_resp == null) {
            if (other.parole_violation_resp != null) {
                return false;
            }
        } else if (!parole_violation_resp.equals(other.parole_violation_resp)) {
            return false;
        }
        if (past_hc_cvrg_resp == null) {
            if (other.past_hc_cvrg_resp != null) {
                return false;
            }
        } else if (!past_hc_cvrg_resp.equals(other.past_hc_cvrg_resp)) {
            return false;
        }
        if (pay_hous_bill_resp == null) {
            if (other.pay_hous_bill_resp != null) {
                return false;
            }
        } else if (!pay_hous_bill_resp.equals(other.pay_hous_bill_resp)) {
            return false;
        }
        if (pay_rmr_brd_resp == null) {
            if (other.pay_rmr_brd_resp != null) {
                return false;
            }
        } else if (!pay_rmr_brd_resp.equals(other.pay_rmr_brd_resp)) {
            return false;
        }
        if (paymentsFromAnnuity == null) {
            if (other.paymentsFromAnnuity != null) {
                return false;
            }
        } else if (!paymentsFromAnnuity.equals(other.paymentsFromAnnuity)) {
            return false;
        }
        if (paymentsMadeOnYourBehalf == null) {
            if (other.paymentsMadeOnYourBehalf != null) {
                return false;
            }
        } else if (!paymentsMadeOnYourBehalf.equals(other.paymentsMadeOnYourBehalf)) {
            return false;
        }
        if (pensionOrRetirement == null) {
            if (other.pensionOrRetirement != null) {
                return false;
            }
        } else if (!pensionOrRetirement.equals(other.pensionOrRetirement)) {
            return false;
        }
        if (pers_prop_bus_eqpt == null) {
            if (other.pers_prop_bus_eqpt != null) {
                return false;
            }
        } else if (!pers_prop_bus_eqpt.equals(other.pers_prop_bus_eqpt)) {
            return false;
        }
        if (pers_prop_cemetary_lot == null) {
            if (other.pers_prop_cemetary_lot != null) {
                return false;
            }
        } else if (!pers_prop_cemetary_lot.equals(other.pers_prop_cemetary_lot)) {
            return false;
        }
        if (pers_prop_livestock == null) {
            if (other.pers_prop_livestock != null) {
                return false;
            }
        } else if (!pers_prop_livestock.equals(other.pers_prop_livestock)) {
            return false;
        }
        if (pers_prop_oth_val == null) {
            if (other.pers_prop_oth_val != null) {
                return false;
            }
        } else if (!pers_prop_oth_val.equals(other.pers_prop_oth_val)) {
            return false;
        }
        if (pers_prop_saf_depst_box == null) {
            if (other.pers_prop_saf_depst_box != null) {
                return false;
            }
        } else if (!pers_prop_saf_depst_box.equals(other.pers_prop_saf_depst_box)) {
            return false;
        }
        if (pnsn_retr_resp == null) {
            if (other.pnsn_retr_resp != null) {
                return false;
            }
        } else if (!pnsn_retr_resp.equals(other.pnsn_retr_resp)) {
            return false;
        }
        if (preg_add_stat_sw == null) {
            if (other.preg_add_stat_sw != null) {
                return false;
            }
        } else if (!preg_add_stat_sw.equals(other.preg_add_stat_sw)) {
            return false;
        }
        if (preg_chg_stat_sw == null) {
            if (other.preg_chg_stat_sw != null) {
                return false;
            }
        } else if (!preg_chg_stat_sw.equals(other.preg_chg_stat_sw)) {
            return false;
        }
        if (preg_resp == null) {
            if (other.preg_resp != null) {
                return false;
            }
        } else if (!preg_resp.equals(other.preg_resp)) {
            return false;
        }
        if (prev_ssi_resp == null) {
            if (other.prev_ssi_resp != null) {
                return false;
            }
        } else if (!prev_ssi_resp.equals(other.prev_ssi_resp)) {
            return false;
        }
        if (prevent_eviction_resp == null) {
            if (other.prevent_eviction_resp != null) {
                return false;
            }
        } else if (!prevent_eviction_resp.equals(other.prevent_eviction_resp)) {
            return false;
        }
        if (prop_sold_resp == null) {
            if (other.prop_sold_resp != null) {
                return false;
            }
        } else if (!prop_sold_resp.equals(other.prop_sold_resp)) {
            return false;
        }
        if (prsn_info_stat_sw == null) {
            if (other.prsn_info_stat_sw != null) {
                return false;
            }
        } else if (!prsn_info_stat_sw.equals(other.prsn_info_stat_sw)) {
            return false;
        }
        if (pub_asst_resp == null) {
            if (other.pub_asst_resp != null) {
                return false;
            }
        } else if (!pub_asst_resp.equals(other.pub_asst_resp)) {
            return false;
        }
        if (railroadRetirement == null) {
            if (other.railroadRetirement != null) {
                return false;
            }
        } else if (!railroadRetirement.equals(other.railroadRetirement)) {
            return false;
        }
        if (rcv_fs_oth_st_resp == null) {
            if (other.rcv_fs_oth_st_resp != null) {
                return false;
            }
        } else if (!rcv_fs_oth_st_resp.equals(other.rcv_fs_oth_st_resp)) {
            return false;
        }
        if (rcv_hous_asst_resp == null) {
            if (other.rcv_hous_asst_resp != null) {
                return false;
            }
        } else if (!rcv_hous_asst_resp.equals(other.rcv_hous_asst_resp)) {
            return false;
        }
        if (rcv_medcr_resp == null) {
            if (other.rcv_medcr_resp != null) {
                return false;
            }
        } else if (!rcv_medcr_resp.equals(other.rcv_medcr_resp)) {
            return false;
        }
        if (rcv_ss_resp == null) {
            if (other.rcv_ss_resp != null) {
                return false;
            }
        } else if (!rcv_ss_resp.equals(other.rcv_ss_resp)) {
            return false;
        }
        if (rcv_ssi_ltr_resp == null) {
            if (other.rcv_ssi_ltr_resp != null) {
                return false;
            }
        } else if (!rcv_ssi_ltr_resp.equals(other.rcv_ssi_ltr_resp)) {
            return false;
        }
        if (rcv_ssi_sw == null) {
            if (other.rcv_ssi_sw != null) {
                return false;
            }
        } else if (!rcv_ssi_sw.equals(other.rcv_ssi_sw)) {
            return false;
        }
        if (real_aset_apt_resp == null) {
            if (other.real_aset_apt_resp != null) {
                return false;
            }
        } else if (!real_aset_apt_resp.equals(other.real_aset_apt_resp)) {
            return false;
        }
        if (real_aset_com_resp == null) {
            if (other.real_aset_com_resp != null) {
                return false;
            }
        } else if (!real_aset_com_resp.equals(other.real_aset_com_resp)) {
            return false;
        }
        if (real_aset_con_resp == null) {
            if (other.real_aset_con_resp != null) {
                return false;
            }
        } else if (!real_aset_con_resp.equals(other.real_aset_con_resp)) {
            return false;
        }
        if (real_aset_dup_resp == null) {
            if (other.real_aset_dup_resp != null) {
                return false;
            }
        } else if (!real_aset_dup_resp.equals(other.real_aset_dup_resp)) {
            return false;
        }
        if (real_aset_frm_resp == null) {
            if (other.real_aset_frm_resp != null) {
                return false;
            }
        } else if (!real_aset_frm_resp.equals(other.real_aset_frm_resp)) {
            return false;
        }
        if (real_aset_hse_resp == null) {
            if (other.real_aset_hse_resp != null) {
                return false;
            }
        } else if (!real_aset_hse_resp.equals(other.real_aset_hse_resp)) {
            return false;
        }
        if (real_aset_lnd_resp == null) {
            if (other.real_aset_lnd_resp != null) {
                return false;
            }
        } else if (!real_aset_lnd_resp.equals(other.real_aset_lnd_resp)) {
            return false;
        }
        if (real_aset_m_h_resp == null) {
            if (other.real_aset_m_h_resp != null) {
                return false;
            }
        } else if (!real_aset_m_h_resp.equals(other.real_aset_m_h_resp)) {
            return false;
        }
        if (real_aset_oth_resp == null) {
            if (other.real_aset_oth_resp != null) {
                return false;
            }
        } else if (!real_aset_oth_resp.equals(other.real_aset_oth_resp)) {
            return false;
        }
        if (real_aset_vac_resp == null) {
            if (other.real_aset_vac_resp != null) {
                return false;
            }
        } else if (!real_aset_vac_resp.equals(other.real_aset_vac_resp)) {
            return false;
        }
        if (real_asset_home_resp == null) {
            if (other.real_asset_home_resp != null) {
                return false;
            }
        } else if (!real_asset_home_resp.equals(other.real_asset_home_resp)) {
            return false;
        }
        if (real_asset_house_resp == null) {
            if (other.real_asset_house_resp != null) {
                return false;
            }
        } else if (!real_asset_house_resp.equals(other.real_asset_house_resp)) {
            return false;
        }
        if (real_asset_land_resp == null) {
            if (other.real_asset_land_resp != null) {
                return false;
            }
        } else if (!real_asset_land_resp.equals(other.real_asset_land_resp)) {
            return false;
        }
        if (real_asset_life_estate_resp == null) {
            if (other.real_asset_life_estate_resp != null) {
                return false;
            }
        } else if (!real_asset_life_estate_resp.equals(other.real_asset_life_estate_resp)) {
            return false;
        }
        if (real_asset_mobile_home_resp == null) {
            if (other.real_asset_mobile_home_resp != null) {
                return false;
            }
        } else if (!real_asset_mobile_home_resp.equals(other.real_asset_mobile_home_resp)) {
            return false;
        }
        if (real_asset_other_resp == null) {
            if (other.real_asset_other_resp != null) {
                return false;
            }
        } else if (!real_asset_other_resp.equals(other.real_asset_other_resp)) {
            return false;
        }
        if (real_asset_rental_resp == null) {
            if (other.real_asset_rental_resp != null) {
                return false;
            }
        } else if (!real_asset_rental_resp.equals(other.real_asset_rental_resp)) {
            return false;
        }
        if (real_asset_unoccupy_home_resp == null) {
            if (other.real_asset_unoccupy_home_resp != null) {
                return false;
            }
        } else if (!real_asset_unoccupy_home_resp.equals(other.real_asset_unoccupy_home_resp)) {
            return false;
        }
        if (refugeeCash == null) {
            if (other.refugeeCash != null) {
                return false;
            }
        } else if (!refugeeCash.equals(other.refugeeCash)) {
            return false;
        }
        if (refused_job_lst_30_resp == null) {
            if (other.refused_job_lst_30_resp != null) {
                return false;
            }
        } else if (!refused_job_lst_30_resp.equals(other.refused_job_lst_30_resp)) {
            return false;
        }
        if (relativeCareSubsidy == null) {
            if (other.relativeCareSubsidy != null) {
                return false;
            }
        } else if (!relativeCareSubsidy.equals(other.relativeCareSubsidy)) {
            return false;
        }
        if (rentalIncome == null) {
            if (other.rentalIncome != null) {
                return false;
            }
        } else if (!rentalIncome.equals(other.rentalIncome)) {
            return false;
        }
        if (resettl_inc_resp == null) {
            if (other.resettl_inc_resp != null) {
                return false;
            }
        } else if (!resettl_inc_resp.equals(other.resettl_inc_resp)) {
            return false;
        }
        if (rlt_chg_stat_sw == null) {
            if (other.rlt_chg_stat_sw != null) {
                return false;
            }
        } else if (!rlt_chg_stat_sw.equals(other.rlt_chg_stat_sw)) {
            return false;
        }
        if (rmr_brd_incm_resp == null) {
            if (other.rmr_brd_incm_resp != null) {
                return false;
            }
        } else if (!rmr_brd_incm_resp.equals(other.rmr_brd_incm_resp)) {
            return false;
        }
        if (room_board_resp == null) {
            if (other.room_board_resp != null) {
                return false;
            }
        } else if (!room_board_resp.equals(other.room_board_resp)) {
            return false;
        }
        if (school_enrollment_resp == null) {
            if (other.school_enrollment_resp != null) {
                return false;
            }
        } else if (!school_enrollment_resp.equals(other.school_enrollment_resp)) {
            return false;
        }
        if (second_mortgag_resp == null) {
            if (other.second_mortgag_resp != null) {
                return false;
            }
        } else if (!second_mortgag_resp.equals(other.second_mortgag_resp)) {
            return false;
        }
        if (self_empl_resp == null) {
            if (other.self_empl_resp != null) {
                return false;
            }
        } else if (!self_empl_resp.equals(other.self_empl_resp)) {
            return false;
        }
        if (septic_sewer_resp == null) {
            if (other.septic_sewer_resp != null) {
                return false;
            }
        } else if (!septic_sewer_resp.equals(other.septic_sewer_resp)) {
            return false;
        }
        if (snap_tanf_disc_resp == null) {
            if (other.snap_tanf_disc_resp != null) {
                return false;
            }
        } else if (!snap_tanf_disc_resp.equals(other.snap_tanf_disc_resp)) {
            return false;
        }
        if (special_need_resp == null) {
            if (other.special_need_resp != null) {
                return false;
            }
        } else if (!special_need_resp.equals(other.special_need_resp)) {
            return false;
        }
        if (ssi_1619b_rcv_sw == null) {
            if (other.ssi_1619b_rcv_sw != null) {
                return false;
            }
        } else if (!ssi_1619b_rcv_sw.equals(other.ssi_1619b_rcv_sw)) {
            return false;
        }
        if (ssi_dcond_resp == null) {
            if (other.ssi_dcond_resp != null) {
                return false;
            }
        } else if (!ssi_dcond_resp.equals(other.ssi_dcond_resp)) {
            return false;
        }
        if (student_financial_aid_resp == null) {
            if (other.student_financial_aid_resp != null) {
                return false;
            }
        } else if (!student_financial_aid_resp.equals(other.student_financial_aid_resp)) {
            return false;
        }
        if (su_ases_resp == null) {
            if (other.su_ases_resp != null) {
                return false;
            }
        } else if (!su_ases_resp.equals(other.su_ases_resp)) {
            return false;
        }
        if (su_cst_coal_resp == null) {
            if (other.su_cst_coal_resp != null) {
                return false;
            }
        } else if (!su_cst_coal_resp.equals(other.su_cst_coal_resp)) {
            return false;
        }
        if (su_cst_elec_resp == null) {
            if (other.su_cst_elec_resp != null) {
                return false;
            }
        } else if (!su_cst_elec_resp.equals(other.su_cst_elec_resp)) {
            return false;
        }
        if (su_cst_fuel_resp == null) {
            if (other.su_cst_fuel_resp != null) {
                return false;
            }
        } else if (!su_cst_fuel_resp.equals(other.su_cst_fuel_resp)) {
            return false;
        }
        if (su_cst_gas_resp == null) {
            if (other.su_cst_gas_resp != null) {
                return false;
            }
        } else if (!su_cst_gas_resp.equals(other.su_cst_gas_resp)) {
            return false;
        }
        if (su_cst_home_resp == null) {
            if (other.su_cst_home_resp != null) {
                return false;
            }
        } else if (!su_cst_home_resp.equals(other.su_cst_home_resp)) {
            return false;
        }
        if (su_cst_ins_resp == null) {
            if (other.su_cst_ins_resp != null) {
                return false;
            }
        } else if (!su_cst_ins_resp.equals(other.su_cst_ins_resp)) {
            return false;
        }
        if (su_cst_istl_resp == null) {
            if (other.su_cst_istl_resp != null) {
                return false;
            }
        } else if (!su_cst_istl_resp.equals(other.su_cst_istl_resp)) {
            return false;
        }
        if (su_cst_lpgas_resp == null) {
            if (other.su_cst_lpgas_resp != null) {
                return false;
            }
        } else if (!su_cst_lpgas_resp.equals(other.su_cst_lpgas_resp)) {
            return false;
        }
        if (su_cst_mbl_resp == null) {
            if (other.su_cst_mbl_resp != null) {
                return false;
            }
        } else if (!su_cst_mbl_resp.equals(other.su_cst_mbl_resp)) {
            return false;
        }
        if (su_cst_mtge_resp == null) {
            if (other.su_cst_mtge_resp != null) {
                return false;
            }
        } else if (!su_cst_mtge_resp.equals(other.su_cst_mtge_resp)) {
            return false;
        }
        if (su_cst_othr_resp == null) {
            if (other.su_cst_othr_resp != null) {
                return false;
            }
        } else if (!su_cst_othr_resp.equals(other.su_cst_othr_resp)) {
            return false;
        }
        if (su_cst_phn_resp == null) {
            if (other.su_cst_phn_resp != null) {
                return false;
            }
        } else if (!su_cst_phn_resp.equals(other.su_cst_phn_resp)) {
            return false;
        }
        if (su_cst_rent_resp == null) {
            if (other.su_cst_rent_resp != null) {
                return false;
            }
        } else if (!su_cst_rent_resp.equals(other.su_cst_rent_resp)) {
            return false;
        }
        if (su_cst_swr_resp == null) {
            if (other.su_cst_swr_resp != null) {
                return false;
            }
        } else if (!su_cst_swr_resp.equals(other.su_cst_swr_resp)) {
            return false;
        }
        if (su_cst_tax_resp == null) {
            if (other.su_cst_tax_resp != null) {
                return false;
            }
        } else if (!su_cst_tax_resp.equals(other.su_cst_tax_resp)) {
            return false;
        }
        if (su_cst_trsh_resp == null) {
            if (other.su_cst_trsh_resp != null) {
                return false;
            }
        } else if (!su_cst_trsh_resp.equals(other.su_cst_trsh_resp)) {
            return false;
        }
        if (su_cst_wood_resp == null) {
            if (other.su_cst_wood_resp != null) {
                return false;
            }
        } else if (!su_cst_wood_resp.equals(other.su_cst_wood_resp)) {
            return false;
        }
        if (su_cst_wtr_resp == null) {
            if (other.su_cst_wtr_resp != null) {
                return false;
            }
        } else if (!su_cst_wtr_resp.equals(other.su_cst_wtr_resp)) {
            return false;
        }
        if (su_cst_wwt_resp == null) {
            if (other.su_cst_wwt_resp != null) {
                return false;
            }
        } else if (!su_cst_wwt_resp.equals(other.su_cst_wwt_resp)) {
            return false;
        }
        if (tANFPayments == null) {
            if (other.tANFPayments != null) {
                return false;
            }
        } else if (!tANFPayments.equals(other.tANFPayments)) {
            return false;
        }
        if (tanfDiscResp == null) {
            if (other.tanfDiscResp != null) {
                return false;
            }
        } else if (!tanfDiscResp.equals(other.tanfDiscResp)) {
            return false;
        }
        if (tanf_eppic_resp == null) {
            if (other.tanf_eppic_resp != null) {
                return false;
            }
        } else if (!tanf_eppic_resp.equals(other.tanf_eppic_resp)) {
            return false;
        }
        if (tanf_ind == null) {
            if (other.tanf_ind != null) {
                return false;
            }
        } else if (!tanf_ind.equals(other.tanf_ind)) {
            return false;
        }
        if (tax_claim_dependant_resp == null) {
            if (other.tax_claim_dependant_resp != null) {
                return false;
            }
        } else if (!tax_claim_dependant_resp.equals(other.tax_claim_dependant_resp)) {
            return false;
        }
        if (tax_deduct_resp == null) {
            if (other.tax_deduct_resp != null) {
                return false;
            }
        } else if (!tax_deduct_resp.equals(other.tax_deduct_resp)) {
            return false;
        }
        if (trade_snap_gun_resp == null) {
            if (other.trade_snap_gun_resp != null) {
                return false;
            }
        } else if (!trade_snap_gun_resp.equals(other.trade_snap_gun_resp)) {
            return false;
        }
        if (trading_snap_resp == null) {
            if (other.trading_snap_resp != null) {
                return false;
            }
        } else if (!trading_snap_resp.equals(other.trading_snap_resp)) {
            return false;
        }
        if (training_allowance_resp == null) {
            if (other.training_allowance_resp != null) {
                return false;
            }
        } else if (!training_allowance_resp.equals(other.training_allowance_resp)) {
            return false;
        }
        if (trb_cmdy_resp == null) {
            if (other.trb_cmdy_resp != null) {
                return false;
            }
        } else if (!trb_cmdy_resp.equals(other.trb_cmdy_resp)) {
            return false;
        }
        if (trb_cpta_resp == null) {
            if (other.trb_cpta_resp != null) {
                return false;
            }
        } else if (!trb_cpta_resp.equals(other.trb_cpta_resp)) {
            return false;
        }
        if (trb_tanf_resp == null) {
            if (other.trb_tanf_resp != null) {
                return false;
            }
        } else if (!trb_tanf_resp.equals(other.trb_tanf_resp)) {
            return false;
        }
        if (tribal_eligibility_resp == null) {
            if (other.tribal_eligibility_resp != null) {
                return false;
            }
        } else if (!tribal_eligibility_resp.equals(other.tribal_eligibility_resp)) {
            return false;
        }
        if (tribal_food_dist_resp == null) {
            if (other.tribal_food_dist_resp != null) {
                return false;
            }
        } else if (!tribal_food_dist_resp.equals(other.tribal_food_dist_resp)) {
            return false;
        }
        if (tribal_health_resp == null) {
            if (other.tribal_health_resp != null) {
                return false;
            }
        } else if (!tribal_health_resp.equals(other.tribal_health_resp)) {
            return false;
        }
        if (underweight_birth_resp == null) {
            if (other.underweight_birth_resp != null) {
                return false;
            }
        } else if (!underweight_birth_resp.equals(other.underweight_birth_resp)) {
            return false;
        }
        if (unemploymentCompensation == null) {
            if (other.unemploymentCompensation != null) {
                return false;
            }
        } else if (!unemploymentCompensation.equals(other.unemploymentCompensation)) {
            return false;
        }
        if (unocc_home_exp_resp == null) {
            if (other.unocc_home_exp_resp != null) {
                return false;
            }
        } else if (!unocc_home_exp_resp.equals(other.unocc_home_exp_resp)) {
            return false;
        }
        if (unpaid_medbill == null) {
            if (other.unpaid_medbill != null) {
                return false;
            }
        } else if (!unpaid_medbill.equals(other.unpaid_medbill)) {
            return false;
        }
        if (updt_dt == null) {
            if (other.updt_dt != null) {
                return false;
            }
        } else if (!updt_dt.equals(other.updt_dt)) {
            return false;
        }
        if (util_exp_resp == null) {
            if (other.util_exp_resp != null) {
                return false;
            }
        } else if (!util_exp_resp.equals(other.util_exp_resp)) {
            return false;
        }
        if (utility_bills_oil_resp == null) {
            if (other.utility_bills_oil_resp != null) {
                return false;
            }
        } else if (!utility_bills_oil_resp.equals(other.utility_bills_oil_resp)) {
            return false;
        }
        if (utility_standard_resp == null) {
            if (other.utility_standard_resp != null) {
                return false;
            }
        } else if (!utility_standard_resp.equals(other.utility_standard_resp)) {
            return false;
        }
        if (veh_aset_anml_resp == null) {
            if (other.veh_aset_anml_resp != null) {
                return false;
            }
        } else if (!veh_aset_anml_resp.equals(other.veh_aset_anml_resp)) {
            return false;
        }
        if (veh_aset_arpl_resp == null) {
            if (other.veh_aset_arpl_resp != null) {
                return false;
            }
        } else if (!veh_aset_arpl_resp.equals(other.veh_aset_arpl_resp)) {
            return false;
        }
        if (veh_aset_auto_resp == null) {
            if (other.veh_aset_auto_resp != null) {
                return false;
            }
        } else if (!veh_aset_auto_resp.equals(other.veh_aset_auto_resp)) {
            return false;
        }
        if (veh_aset_boat_resp == null) {
            if (other.veh_aset_boat_resp != null) {
                return false;
            }
        } else if (!veh_aset_boat_resp.equals(other.veh_aset_boat_resp)) {
            return false;
        }
        if (veh_aset_bus_resp == null) {
            if (other.veh_aset_bus_resp != null) {
                return false;
            }
        } else if (!veh_aset_bus_resp.equals(other.veh_aset_bus_resp)) {
            return false;
        }
        if (veh_aset_camp_resp == null) {
            if (other.veh_aset_camp_resp != null) {
                return false;
            }
        } else if (!veh_aset_camp_resp.equals(other.veh_aset_camp_resp)) {
            return false;
        }
        if (veh_aset_fimp_resp == null) {
            if (other.veh_aset_fimp_resp != null) {
                return false;
            }
        } else if (!veh_aset_fimp_resp.equals(other.veh_aset_fimp_resp)) {
            return false;
        }
        if (veh_aset_fmeq_resp == null) {
            if (other.veh_aset_fmeq_resp != null) {
                return false;
            }
        } else if (!veh_aset_fmeq_resp.equals(other.veh_aset_fmeq_resp)) {
            return false;
        }
        if (veh_aset_ftrc_resp == null) {
            if (other.veh_aset_ftrc_resp != null) {
                return false;
            }
        } else if (!veh_aset_ftrc_resp.equals(other.veh_aset_ftrc_resp)) {
            return false;
        }
        if (veh_aset_ftrl_resp == null) {
            if (other.veh_aset_ftrl_resp != null) {
                return false;
            }
        } else if (!veh_aset_ftrl_resp.equals(other.veh_aset_ftrl_resp)) {
            return false;
        }
        if (veh_aset_lskd_resp == null) {
            if (other.veh_aset_lskd_resp != null) {
                return false;
            }
        } else if (!veh_aset_lskd_resp.equals(other.veh_aset_lskd_resp)) {
            return false;
        }
        if (veh_aset_mcyc_resp == null) {
            if (other.veh_aset_mcyc_resp != null) {
                return false;
            }
        } else if (!veh_aset_mcyc_resp.equals(other.veh_aset_mcyc_resp)) {
            return false;
        }
        if (veh_aset_mped_resp == null) {
            if (other.veh_aset_mped_resp != null) {
                return false;
            }
        } else if (!veh_aset_mped_resp.equals(other.veh_aset_mped_resp)) {
            return false;
        }
        if (veh_aset_nm_b_resp == null) {
            if (other.veh_aset_nm_b_resp != null) {
                return false;
            }
        } else if (!veh_aset_nm_b_resp.equals(other.veh_aset_nm_b_resp)) {
            return false;
        }
        if (veh_aset_othr_resp == null) {
            if (other.veh_aset_othr_resp != null) {
                return false;
            }
        } else if (!veh_aset_othr_resp.equals(other.veh_aset_othr_resp)) {
            return false;
        }
        if (veh_aset_rv_resp == null) {
            if (other.veh_aset_rv_resp != null) {
                return false;
            }
        } else if (!veh_aset_rv_resp.equals(other.veh_aset_rv_resp)) {
            return false;
        }
        if (veh_aset_s_mb_resp == null) {
            if (other.veh_aset_s_mb_resp != null) {
                return false;
            }
        } else if (!veh_aset_s_mb_resp.equals(other.veh_aset_s_mb_resp)) {
            return false;
        }
        if (veh_aset_trk_resp == null) {
            if (other.veh_aset_trk_resp != null) {
                return false;
            }
        } else if (!veh_aset_trk_resp.equals(other.veh_aset_trk_resp)) {
            return false;
        }
        if (veh_aset_trlr_resp == null) {
            if (other.veh_aset_trlr_resp != null) {
                return false;
            }
        } else if (!veh_aset_trlr_resp.equals(other.veh_aset_trlr_resp)) {
            return false;
        }
        if (veh_aset_unlic_resp == null) {
            if (other.veh_aset_unlic_resp != null) {
                return false;
            }
        } else if (!veh_aset_unlic_resp.equals(other.veh_aset_unlic_resp)) {
            return false;
        }
        if (veh_aset_van_resp == null) {
            if (other.veh_aset_van_resp != null) {
                return false;
            }
        } else if (!veh_aset_van_resp.equals(other.veh_aset_van_resp)) {
            return false;
        }
        if (vehicle_asset_animal_drwn_resp == null) {
            if (other.vehicle_asset_animal_drwn_resp != null) {
                return false;
            }
        } else if (!vehicle_asset_animal_drwn_resp.equals(other.vehicle_asset_animal_drwn_resp)) {
            return false;
        }
        if (vehicle_asset_auto_resp == null) {
            if (other.vehicle_asset_auto_resp != null) {
                return false;
            }
        } else if (!vehicle_asset_auto_resp.equals(other.vehicle_asset_auto_resp)) {
            return false;
        }
        if (vehicle_asset_boat_resp == null) {
            if (other.vehicle_asset_boat_resp != null) {
                return false;
            }
        } else if (!vehicle_asset_boat_resp.equals(other.vehicle_asset_boat_resp)) {
            return false;
        }
        if (vehicle_asset_camper_resp == null) {
            if (other.vehicle_asset_camper_resp != null) {
                return false;
            }
        } else if (!vehicle_asset_camper_resp.equals(other.vehicle_asset_camper_resp)) {
            return false;
        }
        if (vehicle_asset_golf_cart_resp == null) {
            if (other.vehicle_asset_golf_cart_resp != null) {
                return false;
            }
        } else if (!vehicle_asset_golf_cart_resp.equals(other.vehicle_asset_golf_cart_resp)) {
            return false;
        }
        if (vehicle_asset_motorcycle_resp == null) {
            if (other.vehicle_asset_motorcycle_resp != null) {
                return false;
            }
        } else if (!vehicle_asset_motorcycle_resp.equals(other.vehicle_asset_motorcycle_resp)) {
            return false;
        }
        if (vehicle_asset_nmot_camper_resp == null) {
            if (other.vehicle_asset_nmot_camper_resp != null) {
                return false;
            }
        } else if (!vehicle_asset_nmot_camper_resp.equals(other.vehicle_asset_nmot_camper_resp)) {
            return false;
        }
        if (vehicle_asset_other_resp == null) {
            if (other.vehicle_asset_other_resp != null) {
                return false;
            }
        } else if (!vehicle_asset_other_resp.equals(other.vehicle_asset_other_resp)) {
            return false;
        }
        if (vehicle_asset_recreation_resp == null) {
            if (other.vehicle_asset_recreation_resp != null) {
                return false;
            }
        } else if (!vehicle_asset_recreation_resp.equals(other.vehicle_asset_recreation_resp)) {
            return false;
        }
        if (vehicle_asset_tractor_resp == null) {
            if (other.vehicle_asset_tractor_resp != null) {
                return false;
            }
        } else if (!vehicle_asset_tractor_resp.equals(other.vehicle_asset_tractor_resp)) {
            return false;
        }
        if (violating_parole_resp == null) {
            if (other.violating_parole_resp != null) {
                return false;
            }
        } else if (!violating_parole_resp.equals(other.violating_parole_resp)) {
            return false;
        }
        if (voluntarily_quit_job_resp == null) {
            if (other.voluntarily_quit_job_resp != null) {
                return false;
            }
        } else if (!voluntarily_quit_job_resp.equals(other.voluntarily_quit_job_resp)) {
            return false;
        }
        if (water_well_maint_resp == null) {
            if (other.water_well_maint_resp != null) {
                return false;
            }
        } else if (!water_well_maint_resp.equals(other.water_well_maint_resp)) {
            return false;
        }
        if (water_well_resp == null) {
            if (other.water_well_resp != null) {
                return false;
            }
        } else if (!water_well_resp.equals(other.water_well_resp)) {
            return false;
        }
        if (wheap_resp == null) {
            if (other.wheap_resp != null) {
                return false;
            }
        } else if (!wheap_resp.equals(other.wheap_resp)) {
            return false;
        }
        if (workStudyStateFederal == null) {
            if (other.workStudyStateFederal != null) {
                return false;
            }
        } else if (!workStudyStateFederal.equals(other.workStudyStateFederal)) {
            return false;
        }
        if (work_comp_resp == null) {
            if (other.work_comp_resp != null) {
                return false;
            }
        } else if (!work_comp_resp.equals(other.work_comp_resp)) {
            return false;
        }
        if (work_related_expense_resp == null) {
            if (other.work_related_expense_resp != null) {
                return false;
            }
        } else if (!work_related_expense_resp.equals(other.work_related_expense_resp)) {
            return false;
        }
        if (workersCompensation == null) {
            if (other.workersCompensation != null) {
                return false;
            }
        } else if (!workersCompensation.equals(other.workersCompensation)) {
            return false;
        }
        if (yehoc_resp == null) {
            if (other.yehoc_resp != null) {
                return false;
            }
        } else if (!yehoc_resp.equals(other.yehoc_resp)) {
            return false;
        }
        if (room_brd_chg_ind == null) {
            if (other.room_brd_chg_ind != null) {
                return false;
            }
        } else if (!room_brd_chg_ind.equals(other.room_brd_chg_ind)) {
            return false;
        }
        if (dabl_stat_ind == null) {
            if (other.dabl_stat_ind != null) {
                return false;
            }
        } else if (!dabl_stat_ind.equals(other.dabl_stat_ind)) {
            return false;
        }
        if (preg_add_stat_ind == null) {
            if (other.preg_add_stat_ind != null) {
                return false;
            }
        } else if (!preg_add_stat_ind.equals(other.preg_add_stat_ind)) {
            return false;
        }
        if (preg_chg_ind == null) {
            if (other.preg_chg_ind != null) {
                return false;
            }
        } else if (!preg_chg_ind.equals(other.preg_chg_ind)) {
            return false;
        }
        if (irwe_chg_ind == null) {
            if (other.irwe_chg_ind != null) {
                return false;
            }
        } else if (!irwe_chg_ind.equals(other.irwe_chg_ind)) {
            return false;
        }
        if (ei_chg_ind == null) {
            if (other.ei_chg_ind != null) {
                return false;
            }
        } else if (!ei_chg_ind.equals(other.ei_chg_ind)) {
            return false;
        }
        if (self_empl_chg_ind == null) {
            if (other.self_empl_chg_ind != null) {
                return false;
            }
        } else if (!self_empl_chg_ind.equals(other.self_empl_chg_ind)) {
            return false;
        }
        if (othr_incm_chg_ind == null) {
            if (other.othr_incm_chg_ind != null) {
                return false;
            }
        } else if (!othr_incm_chg_ind.equals(other.othr_incm_chg_ind)) {
            return false;
        }
        if (empl_chg_ind == null) {
            if (other.empl_chg_ind != null) {
                return false;
            }
        } else if (!empl_chg_ind.equals(other.empl_chg_ind)) {
            return false;
        }
        if (veh_aset_add_ind == null) {
            if (other.veh_aset_add_ind != null) {
                return false;
            }
        } else if (!veh_aset_add_ind.equals(other.veh_aset_add_ind)) {
            return false;
        }
        if (veh_aset_chg_ind == null) {
            if (other.veh_aset_chg_ind != null) {
                return false;
            }
        } else if (!veh_aset_chg_ind.equals(other.veh_aset_chg_ind)) {
            return false;
        }
        if (real_aset_add_ind == null) {
            if (other.real_aset_add_ind != null) {
                return false;
            }
        } else if (!real_aset_add_ind.equals(other.real_aset_add_ind)) {
            return false;
        }
        if (real_aset_chg_ind == null) {
            if (other.real_aset_chg_ind != null) {
                return false;
            }
        } else if (!real_aset_chg_ind.equals(other.real_aset_chg_ind)) {
            return false;
        }
        if (bury_aset_add_ind == null) {
            if (other.bury_aset_add_ind != null) {
                return false;
            }
        } else if (!bury_aset_add_ind.equals(other.bury_aset_add_ind)) {
            return false;
        }
        if (bury_aset_chg_ind == null) {
            if (other.bury_aset_chg_ind != null) {
                return false;
            }
        } else if (!bury_aset_chg_ind.equals(other.bury_aset_chg_ind)) {
            return false;
        }
        if (liquid_asset_add_ind == null) {
            if (other.liquid_asset_add_ind != null) {
                return false;
            }
        } else if (!liquid_asset_add_ind.equals(other.liquid_asset_add_ind)) {
            return false;
        }
        if (liquid_asset_bank_acc_chg_ind == null) {
            if (other.liquid_asset_bank_acc_chg_ind != null) {
                return false;
            }
        } else if (!liquid_asset_bank_acc_chg_ind.equals(other.liquid_asset_bank_acc_chg_ind)) {
            return false;
        }
        if (liquid_asset_cash_chg_ind == null) {
            if (other.liquid_asset_cash_chg_ind != null) {
                return false;
            }
        } else if (!liquid_asset_cash_chg_ind.equals(other.liquid_asset_cash_chg_ind)) {
            return false;
        }
        if (liquid_asset_chg_ind == null) {
            if (other.liquid_asset_chg_ind != null) {
                return false;
            }
        } else if (!liquid_asset_chg_ind.equals(other.liquid_asset_chg_ind)) {
            return false;
        }
        if (liquid_asset_other_chg_ind == null) {
            if (other.liquid_asset_other_chg_ind != null) {
                return false;
            }
        } else if (!liquid_asset_other_chg_ind.equals(other.liquid_asset_other_chg_ind)) {
            return false;
        }
        if (life_ins_aset_add_ind == null) {
            if (other.life_ins_aset_add_ind != null) {
                return false;
            }
        } else if (!life_ins_aset_add_ind.equals(other.life_ins_aset_add_ind)) {
            return false;
        }
        if (life_ins_aset_chg_ind == null) {
            if (other.life_ins_aset_chg_ind != null) {
                return false;
            }
        } else if (!life_ins_aset_chg_ind.equals(other.life_ins_aset_chg_ind)) {
            return false;
        }
        if (aset_xfer_chg_ind == null) {
            if (other.aset_xfer_chg_ind != null) {
                return false;
            }
        } else if (!aset_xfer_chg_ind.equals(other.aset_xfer_chg_ind)) {
            return false;
        }
        if (dpnd_care_chg_ind == null) {
            if (other.dpnd_care_chg_ind != null) {
                return false;
            }
        } else if (!dpnd_care_chg_ind.equals(other.dpnd_care_chg_ind)) {
            return false;
        }
        if (health_insurance_chg_ind == null) {
            if (other.health_insurance_chg_ind != null) {
                return false;
            }
        } else if (!health_insurance_chg_ind.equals(other.health_insurance_chg_ind)) {
            return false;
        }
        if (child_support_payment_chg_ind == null) {
            if (other.child_support_payment_chg_ind != null) {
                return false;
            }
        } else if (!child_support_payment_chg_ind.equals(other.child_support_payment_chg_ind)) {
            return false;
        }
        if (snap_shelter_standard_exp_ind == null) {
            if (other.snap_shelter_standard_exp_ind != null) {
                return false;
            }
        } else if (!snap_shelter_standard_exp_ind.equals(other.snap_shelter_standard_exp_ind)) {
            return false;
        }
        if (hous_bill_chg_ind == null) {
            if (other.hous_bill_chg_ind != null) {
                return false;
            }
        } else if (!hous_bill_chg_ind.equals(other.hous_bill_chg_ind)) {
            return false;
        }
        if (add_chg_ind == null) {
            if (other.add_chg_ind != null) {
                return false;
            }
        } else if (!add_chg_ind.equals(other.add_chg_ind)) {
            return false;
        }
        if (person_moved_in_stat_ind == null) {
            if (other.person_moved_in_stat_ind != null) {
                return false;
            }
        } else if (!person_moved_in_stat_ind.equals(other.person_moved_in_stat_ind)) {
            return false;
        }
        if (person_moved_out_stat_ind == null) {
            if (other.person_moved_out_stat_ind != null) {
                return false;
            }
        } else if (!person_moved_out_stat_ind.equals(other.person_moved_out_stat_ind)) {
            return false;
        }
        if (hospice_chg_ind == null) {
            if (other.hospice_chg_ind != null) {
                return false;
            }
        } else if (!hospice_chg_ind.equals(other.hospice_chg_ind)) {
            return false;
        }
        if (medicare_chg_ind == null) {
            if (other.medicare_chg_ind != null) {
                return false;
            }
        } else if (!medicare_chg_ind.equals(other.medicare_chg_ind)) {
            return false;
        }
        if (ncp_chg_ind == null) {
            if (other.ncp_chg_ind != null) {
                return false;
            }
        } else if (!ncp_chg_ind.equals(other.ncp_chg_ind)) {
            return false;
        }
        if (third_party_chg_ind == null) {
            if (other.third_party_chg_ind != null) {
                return false;
            }
        } else if (!third_party_chg_ind.equals(other.third_party_chg_ind)) {
            return false;
        }
        if (hospital_abd_chg_ind == null) {
            if (other.hospital_abd_chg_ind != null) {
                return false;
            }
        } else if (!hospital_abd_chg_ind.equals(other.hospital_abd_chg_ind)) {
            return false;
        }
        if (public_law_abd_chg_ind == null) {
            if (other.public_law_abd_chg_ind != null) {
                return false;
            }
        } else if (!public_law_abd_chg_ind.equals(other.public_law_abd_chg_ind)) {
            return false;
        }
        if (living_argmt_chg_ind == null) {
            if (other.living_argmt_chg_ind != null) {
                return false;
            }
        } else if (!living_argmt_chg_ind.equals(other.living_argmt_chg_ind)) {
            return false;
        }
        if (other_program_chg_ind == null) {
            if (other.other_program_chg_ind != null) {
                return false;
            }
        } else if (!other_program_chg_ind.equals(other.other_program_chg_ind)) {
            return false;
        }
	 if (magi_expense_chg_ind == null) {
            if (other.magi_expense_chg_ind != null) {
                return false;
            }
        } else if (!magi_expense_chg_ind.equals(other.magi_expense_chg_ind)) {
            return false;
        }
        
        if (tax_info_ind == null) {
            if (other.tax_info_ind != null) {
                return false;
            }
        } else if (!tax_info_ind.equals(other.tax_info_ind)) {
            return false;
        }
        
        if (tax_dep_outside_resp == null) {
            if (other.tax_dep_outside_resp != null) {
                return false;
            }
        } else if (!tax_dep_outside_resp.equals(other.tax_dep_outside_resp)) {
            return false;
        }
        if (medicare_part_a == null) {
			if (other.medicare_part_a != null) {
				return false;
				}
		} else if (!medicare_part_a.equals(other.medicare_part_a)){
			return false;
			}
        if (medicare_part_b == null) {
			if (other.medicare_part_b != null) {
				return false;
				}
		} else if (!medicare_part_b.equals(other.medicare_part_b)){
			return false;
			}
		
		if (medicare_part_c == null) {
			if (other.medicare_part_c != null) {
				return false;
				}
		} else if (!medicare_part_c.equals(other.medicare_part_c)){
			return false;
			}
		
		if (medicare_part_d == null) {
			if (other.medicare_part_d != null) {
				return false;
				}
		} else if (!medicare_part_d.equals(other.medicare_part_d)){
			return false;
			}
		
		if (cssp_provider_payment == null) {
			if (other.cssp_provider_payment != null) {
				return false;
				}
		} else if (!cssp_provider_payment.equals(other.cssp_provider_payment)){
			return false;
			}
		
		if (animals_to_assist_disabled == null) {
			if (other.animals_to_assist_disabled != null) {
				return false;
				}
		} else if (!animals_to_assist_disabled.equals(other.animals_to_assist_disabled)){
			return false;
			}
		
		if (funeral_death_expense == null) {
			if (other.funeral_death_expense != null) {
				return false;
				}
		} else if (!funeral_death_expense.equals(other.funeral_death_expense)){
			return false;
			}
		
		if (blind_work_expense == null) {
			if (other.blind_work_expense != null) {
				return false;
				}
		} else if (!blind_work_expense.equals(other.blind_work_expense)){
			return false;
			}
		
		if (impairment_work_expense == null) {
			if (other.impairment_work_expense != null) {
				return false;
				}
		} else if (!impairment_work_expense.equals(other.impairment_work_expense)){
			return false;
			}
		
		if (oth_ind_gambl_pmnts == null) {
			if (other.oth_ind_gambl_pmnts != null) {
				return false;
				}
		} else if (!oth_ind_gambl_pmnts.equals(other.oth_ind_gambl_pmnts)){
			return false;
			}
		
		
		if (bonds == null) {
			if (other.bonds != null) {
				return false;
				}
		} else if (!bonds.equals(other.bonds)){
			return false;
			}
		if (dividend == null) {
			if (other.dividend != null) {
				return false;
				}
		} else if (!dividend.equals(other.dividend)){
			return false;
			}
		if (health_reimbursement_account == null) {
			if (other.health_reimbursement_account != null) {
				return false;
				}
		} else if (!health_reimbursement_account.equals(other.health_reimbursement_account)){
			return false;
			}
		if (individual_development_account == null) {
			if (other.individual_development_account != null) {
				return false;
				}
		} else if (!individual_development_account.equals(other.individual_development_account)){
			return false;
			}
		if (uniform_gifts_to_minors == null) {
			if (other.uniform_gifts_to_minors != null) {
				return false;
				}
		} else if (!uniform_gifts_to_minors.equals(other.uniform_gifts_to_minors)){
			return false;
			}
		if (inheritance_income == null) {
			if (other.inheritance_income != null) {
				return false;
				}
		} else if (!inheritance_income.equals(other.inheritance_income)){
			return false;
			}
		if (personal_info == null) {
			if (other.personal_info != null) {
				return false;
				}
		} else if (!personal_info.equals(other.personal_info)){
			return false;
			}
		if (patient_fund == null) {
			if (other.patient_fund != null) {
				return false;
				}
		} else if (!patient_fund.equals(other.patient_fund)){
			return false;
			}
		
		if (disaster_assistance == null) {
			if (other.disaster_assistance != null) {
				return false;
				}
		} else if (!disaster_assistance.equals(other.disaster_assistance)){
			return false;
			}
		if (non_business_equipment == null) {
			if (other.non_business_equipment != null) {
				return false;
				}
		} else if (!non_business_equipment.equals(other.non_business_equipment)){
			return false;
			}
		if (household_goods == null) {
			if (other.household_goods != null) {
				return false;
				}
		} else if (!household_goods.equals(other.household_goods)){
			return false;
			}
		if (other_non_countable == null) {
			if (other.other_non_countable != null) {
				return false;
				}
		} else if (!other_non_countable.equals(other.other_non_countable)){
			return false;
			}
		if (out_st_bnft_chg_ind == null) {
			if (other.out_st_bnft_chg_ind != null) {
				return false;
				}
		} else if (!out_st_bnft_chg_ind.equals(other.out_st_bnft_chg_ind)){
			return false;
			}
		if (schl_enrl_chg_ind == null) {
			if (other.schl_enrl_chg_ind != null) {
				return false;
				}
		} else if (!schl_enrl_chg_ind.equals(other.schl_enrl_chg_ind)){
			return false;
			}
		if (mrtl_stat_chg_ind == null) {
			if (other.mrtl_stat_chg_ind != null) {
				return false;
				}
		} else if (!mrtl_stat_chg_ind.equals(other.mrtl_stat_chg_ind)){
			return false;
			}
		if (nur_hme_chg_ind == null) {
			if (other.nur_hme_chg_ind != null) {
				return false;
				}
		} else if (!nur_hme_chg_ind.equals(other.nur_hme_chg_ind)){
			return false;
			}
		if (bfr_tax_chg_ind == null) {
			if (other.bfr_tax_chg_ind != null) {
				return false;
				}
		} else if (!bfr_tax_chg_ind.equals(other.bfr_tax_chg_ind)){
			return false;
			}
		if (inc_tax_chg_ind == null) {
			if (other.inc_tax_chg_ind != null) {
				return false;
				}
		} else if (!inc_tax_chg_ind.equals(other.inc_tax_chg_ind)){
			return false;
			}
		if (thrd_prty_chg_ind == null) {
			if (other.thrd_prty_chg_ind != null) {
				return false;
				}
		} else if (!thrd_prty_chg_ind.equals(other.thrd_prty_chg_ind)){
			return false;
			}
		if (death_benefit_state_federal == null) {
			if (other.death_benefit_state_federal != null) {
				return false;
				}
		} else if (!death_benefit_state_federal.equals(other.death_benefit_state_federal)){
			return false;
			}
		if (social_security_survivor == null) {
			if (other.social_security_survivor != null) {
				return false;
				}
		} else if (!social_security_survivor.equals(other.social_security_survivor)){
			return false;
			}
		if (vendor_payments == null) {
			if (other.vendor_payments != null) {
				return false;
				}
		} else if (!vendor_payments.equals(other.vendor_payments)){
			return false;
			}
		if (citizenship_chg_ind == null) {
			if (other.citizenship_chg_ind != null) {
				return false;
				}
		} else if (!citizenship_chg_ind.equals(other.citizenship_chg_ind)){
			return false;
			}
		if (demographics_chg_ind == null) {
			if (other.demographics_chg_ind != null) {
				return false;
				}
		} else if (!demographics_chg_ind.equals(other.demographics_chg_ind)){
			return false;
			}
		if (alien_chg_ind == null) {
			if (other.alien_chg_ind != null) {
				return false;
				}
		} else if (!alien_chg_ind.equals(other.alien_chg_ind)){
			return false;
			}
		if (util_bill_chg_Ind == null) {
			if (other.util_bill_chg_Ind != null) {
				return false;
				}
		} else if (!util_bill_chg_Ind.equals(other.util_bill_chg_Ind)){
			return false;
			}
		if (citizenship_info == null) {
			if (other.citizenship_info != null) {
				return false;
				}
		} else if (!citizenship_info.equals(other.citizenship_info)){
			return false;
			}
		if (indv_prgm_chg_ind == null) {
			if (other.indv_prgm_chg_ind != null) {
				return false;
				}
		} else if (!indv_prgm_chg_ind.equals(other.indv_prgm_chg_ind)){
			return false;
			}
		if (empl_hlth_ins_resp == null) {
			if (other.empl_hlth_ins_resp != null) {
				return false;
				}
		} else if (!empl_hlth_ins_resp.equals(other.empl_hlth_ins_resp)){
			return false;
			}
		if (avd_prsctn_fstf == null) {
			if (other.avd_prsctn_fstf != null) {
				return false;
				}
		} else if (!avd_prsctn_fstf.equals(other.avd_prsctn_fstf)){
			return false;
			}
		if (cntrl_subs_resp == null) {
			if (other.cntrl_subs_resp != null) {
				return false;
				}
		} else if (!cntrl_subs_resp.equals(other.cntrl_subs_resp)){
			return false;
			}
		if (heat_cool_src == null) {
			if (other.heat_cool_src != null) {
				return false;
				}
		} else if (!heat_cool_src.equals(other.heat_cool_src)){
			return false;
			}
        return true;
    }
			
}