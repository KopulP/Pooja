package gov.state.nextgen.access.business.entities;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "RMC_IN_PRFL")
public class RmcInPrflCargo  implements java.io.Serializable {

	@Transient
	boolean isDirty = false;

	@EmbeddedId
	private RmcInPrflPrimaryKey rmcInPrflPrimaryKey;
	
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

	
	public boolean isDirty() {
		return isDirty;
	}

	public void setDirty(boolean isDirty) {
		this.isDirty = isDirty;
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

	}
