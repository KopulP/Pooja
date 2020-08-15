/*
 * 
 */
package gov.state.nextgen.access.management.applications;

import gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Cargo;
import gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Collection;
import gov.state.nextgen.access.business.entities.RMC_RESPONSE_Custom_Collection;

/**
 * Enter the description of the class
 *
 * @author Surendra Nath Creation Date Feb 8, 2007 Modified By: Modified on:
 *         PCR#
 */
public interface IRMCResponseProfileManager {

	String DEFAULT_RMC_IN_PRFL_SW = "N";

	char STATUS_REQUIRED = 'R';
	char STATUS_NOT_REQUIRED = 'N';
	char STATUS_COMPLETE = 'C';
	char STATUS_ADD_NEW = 'A';
	char STATUS_VISIT_AGAIN = 'V';
	char STATUS_ABSOLUTE_NOT_REQUIRED = 'X';

	char RESPONSE_YES = 'Y';
	char RESPONSE_NO = 'N';

	int INDEX_REQUIRED = 0;
	int INDEX_NOT_REQUIRED = 1;
	int INDEX_COMPLETE = 2;
	int INDEX_ADD_NEW = 3;
	int INDEX_VISIT_AGAIN = 4;
	int INDEX_ABSOLUTE_NOT_REQUIRED = 5;
	int INDEX_UNKNOWN = -1;

	int ARE_PEOPLE_DIRTY = 0;
	int NOT_DIRTY = 0;
	int DIRTY_UNCHECKED = 1;
	int DIRTY_CHECKED = 2;
	int DIRTY_CHECKED_ADD_NEW = 3;

	short ACCIDENT = 0; // ACDT_RESP
	short ADOPTION_ASSISTANCE = 1;// ADPT_ASST_RESP
	short ALIMONY_RECEIVED = 2;// ALMY_RCV_RESP
	short BENEFIT_ANNUITIES = 3;// BNFT_ANTY_RESP
	short BENEFIT_CHARITY = 4;// BNFT_CHRT_RESP
	short BENEFIT_DISABLE = 5;// BNFT_DABL_RESP
	short BENEFIT_DIVIDEND = 6;// BNFT_DIVND_RESP
	short BENEFIT_TRUST = 7;// BNFT_EST_TRST_RESP
	short BENEFIT_RAILROAD_RETIREMENT = 8;// BNFT_RR_RESP
	short BENEFIT_UNEMPLOYMENT = 9;// BNFT_UEMPL_RESP
	short BENEFIT_VETERAN = 10;// BNFT_VET_RESP
	short CHILD_SUPPORT_PAYMENT = 11;// CHLD_SPRT_PAY_RESP
	short DISABLE = 12;// DABL_RESP
	short DEPENDENT_CARE = 13;// DPND_CARE_RESP
	short DRUG_FELON = 14;// DRUG_FELN_RESP
	short FSET_SANCTION = 15;// FSET_SCTN_RESP
	short FOSTER_CARE = 16;// FSTR_CARE_RESP
	short GENERAL_RELIEF = 17;// GEN_RLF_RESP
	short HEALTHCARE_COVERAGE = 18;// HC_CVRG_RESP
	short INCOME_INTEREST = 19;// INCM_INT_RESP
	short INDIVIDUAL_FAMILY_MEDICAID = 20;// INDV_FMA_RQST_IND
	short INDIVIDUAL_FPW = 21;// INDV_FPW_RQST_IND
	short INDIVIDUAL_FOODSHARE = 22;// INDV_FS_RQST_IND
	short IREW = 23; // IREW_RESP
	short KINSHIP_CARE = 24;// KINSHIP_CARE_RESP
	short MEDICAL_EXPENSE = 25;// MED_EXP_RESP
	short MILITARY_ALLOTMENT = 26;// MIL_ALLOT_RESP
	short MONEY_FROM_ANOTHER_PERSON = 27;// MONY_OTHR_RESP
	short REFUGE = 28;// NATL_RFGE_RESP
	short NEEDY_INDIAN = 29;// NEED_IND_RESP
	short ON_STRIKE = 30;// ON_STRK_SW
	short OTHER_PENSION = 31;// OP_AODA_TMT_RCV_SW
	short OTHER_INCOME = 32;// OTHR_INCM_RESP
	short OTHER_SOURCE = 33;// OTHR_SRC_RESP
	short OWNER_ASSET = 34; // OWN_ASET_RESP
	short PAY_HOUSING_BILL = 35; // PAY_HOUS_BILL_RESP
	short PREGNANCY = 36;// PREG_RESP
	short JOB_IN_KIND = 37;// JOB_IKND_RESP
	short PAY_ROOM_AND_BOARD = 38;// PAY_RMR_BRD_RESP
	short PENSION_RETIREMENT = 39;// PNSN_RETR_RESP
	short PROPERTY_SOLD = 40;// PROP_SOLD_RESP
	short RECEIVE_FS_IN_OTHER_STATE = 41;// RCV_FS_OTH_ST_RESP
	short RECEIVE_HOUSING_ASSET = 42;// RCV_HOUS_ASST_RESP
	short RECEIVE_MEDICARE = 43;// RCV_MEDCR_RESP
	short RECEIVE_SOCIAL_SECURITY = 44;// RCV_SS_RESP
	short RECEIVE_SSI_LETTER = 45;// RCV_SSI_LTR_RESP
	short RECEIVE_SSI = 46;// RCV_SSI_SW
	short ROOM_AND_BOARD = 47;// RMR_BRD_INCM_RESP
	short SELF_EMPLOYMENT = 48;// SELF_EMPL_RESP
	short RECEIVE_SSI_DCOND = 49;// SSI_DCOND_RESP
	short RECEIVE_SSI_1619B = 50;// SSI_1619B_RCV_SW
	short SHELTER_COST_ASSESSMENT = 51;// SU_CST_ASES_RESP
	short SHELTER_COST_COAL = 52;// SU_CST_COAL_RESP
	short SHELTER_COST_ELECTRICTY = 53;// SU_CST_ELEC_RESP
	short SHELTER_COST_FUEL = 54;// SU_CST_FUEL_RESP
	short SHELTER_COST_GAS = 55;// SU_CST_GAS_RESP
	short SHELTER_COST_HOME = 56;// SU_CST_HOME_RESP
	short SHELTER_COST_INSTALL = 57;// SU_CST_ISTL_RESP
	short SHELTER_COST_LPGAS = 58;// SU_CST_LPGAS_RESP
	short SHELTER_COST_MOBILE_HOME = 59;// SU_CST_MBL_RESP
	short SHELTER_COST_MORTGAGE = 60;// SU_CST_MTGE_RESP
	short SHELTER_COST_OTHER = 61;// SU_CST_OTHR_RESP
	short SHELTER_COST_PHONE = 62;// SU_CST_PHN_RESP
	short SHELTER_COST_RENT = 63;// SU_CST_RENT_RESP
	short SHELTER_COST_SEWER = 64;// SU_CST_SWR_RESP
	short SHELTER_COST_TAX = 65;// SU_CST_TAX_RESP
	short SHELTER_COST_TRASH = 66;// SU_CST_TRSH_RESP
	short SHELTER_COST_WOOD = 67;// SU_CST_WOOD_RESP
	short SHELTER_COST_WATER = 68;// SU_CST_WTR_RESP
	short SHELTER_COST_WASTE = 69;// SU_CST_WWT_RESP
	short TRIBAL_TANF = 70;// TRB_TANF_RESP
	short UTILITY_EXPENSE = 71;// UTIL_EXP_RESP
	short WORKER_COMP = 72;// WORK_COMP_RESP
	short TRIBAL_CAPITA = 73;// TRB_CPTA_RESP
	short EDUCATIONAL_AID = 74;// educ_aid_resp;---
	short WHEAP = 75;// educ_aid_resp;---
	short REGULAR_EMPL = 76;// Empl_resp
	short BNFT_CHL_SPRT_RESP = 77;// BNFT_CHL_SPRT_RESP
	short PUB_ASST_RESP = 78;// PUB_ASST_RESP
	short YEHOC_RESP = 79; // YEHOC_RESP
	// PCR 35980 Added - past_hc_cvrg_resp
	short PAST_HEALTHCARE_COVERAGE = 80; // PAST_HC_CVRG_RESP
	// PCR# 40362 - New responses added for RMB/SMRF - starts
	short MAPP_BENEFITS_RESP = 81; // BNFT_MAPP_RESP
	short BUR_AST_CASKET = 82; // BURY_ASET_C_RESP
	short BUR_AST_IRREVOCABLE = 83;// BURY_ASET_IBT_RESP
	short BUR_AST_INSURANCE = 84; // BURY_ASET_INS_RESP
	short BUR_AST_MAUSOLEUM = 85; // BURY_ASET_MAS_RESP
	short BUR_AST_OTHER = 86; // BURY_ASET_OTH_RESP
	short BUR_AST_PLOT = 87; // BURY_ASET_PLT_RESP
	short BUR_AST_REVOCABLE = 88; // BURY_ASET_RBT_RESP
	short BUR_AST_VAULT = 89; // BURY_ASET_V_RESP
	short LIF_AST_GROUP_LIFE = 90; // LI_ASET_G_L_RESP
	short LIF_AST_GROUP_TERM = 91; // LI_ASET_G_T_RESP
	short LIF_AST_TERM = 92; // LI_ASET_TRM_RESP
	short LIF_AST_UNIVERSAL = 93; // LI_ASET_UNV_RESP
	short LIF_AST_WHOLE_LIFE = 94; // LI_ASET_W_L_RESP
	//short LIQ_ASET_CHECKING_ACCOUNT = 95; // LQD_ASET_C_A_RESP
	short LIQ_ASET_CASH = 96; // LQD_ASET_CASH_RESP
	short LIQ_ASET_EBD = 97; // LQD_ASET_EB_A_RESP
	short LIQ_ASET_HOME_SALE = 98; // LQD_ASET_H_S_RESP
	short LIQ_ASET_IRA = 99; // LQD_ASET_IRA_RESP
	//short LIQ_ASET_KEOUGH_PLAN = 100; // LQD_ASET_K_P_RESP
	short LIQ_ASET_MONEY_OWNED = 101; // LQD_ASET_M_O_RESP
	short LIQ_ASET_MONEY_MARKET_ACCOUNT = 102; // LQD_ASET_MM_A_RESP
	short LIQ_ASET_MONEY_OTHER_TYPE = 103; // LQD_ASET_O_T_RESP
	short LIQ_ASET_OTHER = 104; // LQD_ASET_OTHR_RESP
	short LIQ_ASET_SAVINGS_ACCOUNT = 105; // LQD_ASET_S_A_RESP
	short LIQ_ASET_SAVINGS_CERTIFICATE = 106; // LQD_ASET_S_C_RESP
	short LIQ_ASET_STOCKS_BONDS = 107; // LQD_ASET_ST_B_RESP
	short LIQ_ASET_TRUST_FUNDS = 108; // LQD_ASET_TR_F_RESP
	short LIQ_ASET_US_BOND = 109; // LQD_ASET_US_B_RESP
	short OTHR_ASET_BURIAL = 110; // OTHR_ASET_BUR_RESP
	short OTHR_ASET_LIFE_INSURANCE = 111; // OTHR_ASET_L_I_RESP
	short OTHR_ASET_PERSONAL_PROPERTY = 112; // OTHR_ASET_P_P_RESP
	short OTHR_ASET_REAL_PROPERTY = 113; // OTHR_ASET_R_P_RESP
	short OTHR_ASET_VEHICLE = 114; // OTHR_ASET_VEH_RESP
	short OTHR_ASET_TRANSFER = 115; // OTHR_ASET_XFR_RESP
	short REAL_ASET_COMMERCIAL = 138;// REAL_ASET_COM_RESP
	short REAL_ASET_CONDO = 123; // REAL_ASET_CON_RESP
	short REAL_ASET_DUPLEX = 124; // REAL_ASET_DUP_RESP
	short REAL_ASET_HOUSE = 116; // real_asset_house_resp
	short REAL_ASET_LAND = 117; // real_asset_land_resp
	short REAL_ASET_MOBILE_HOME = 118; // real_asset_mobile_home_resp
	short REAL_ASET_OTHER = 119; // real_asset_other_resp
	short VEH_ASET_ANIMAL_DRAWN = 125; // VEH_ASET_ANML_RESP
	short VEH_ASET_AIRPLANE = 126; // VEH_ASET_ARPL_RESP
	short VEH_ASET_AUTOMOBILE = 127; // VEH_ASET_AUTO_RESP
	short VEH_ASET_BOAT = 128; // VEH_ASET_BOAT_RESP
	short VEH_ASET_BUS = 129; // VEH_ASET_BUS_RESP
	short VEH_ASET_CAMPER = 130; // VEH_ASET_CAMP_RESP
	short VEH_ASET_FARM_IMPLEMENT = 131; // VEH_ASET_FIMP_RESP
	short VEH_ASET_FARM_EQUIP = 132; // VEH_ASET_FMEQ_RESP
	short VEH_ASET_FARM_TRACTOR = 133; // VEH_ASET_FTRC_RESP
	short VEH_ASET_FARM_TRAILER = 134; // VEH_ASET_FTRL_RESP
	short VEH_ASET_LOG_SKIDDER = 135; // VEH_ASET_LSKD_RESP
	short VEH_ASET_MOTORCYCLE = 136; // VEH_ASET_MCYC_RESP
	short VEH_ASET_MOPED = 137; // VEH_ASET_MPED_RESP
	short VEH_ASET_NONMOTORIZED_BOAT = 235; // VEH_ASET_NM_B_RESP
	short VEH_ASET_OTHER = 139; // VEH_ASET_OTHR_RESP
	short VEH_ASET_RECREATIONAL_VEHICLE = 140; // VEH_ASET_RV_RESP
	short VEH_ASET_SNOWMOBILE = 145; // VEH_ASET_S_MB_RESP //not used
	short VEH_ASET_TRUCK = 237; // VEH_ASET_TRK_RESP
	short VEH_ASET_TRAVEL_TRAILER = 236; // VEH_ASET_TRLR_RESP
	short VEH_ASET_VAN = 144; // VEH_ASET_VAN_RESP
	// PCR# 40362 - New responses added for RMB/SMRF - ends

	short APRV_ACTV_RESP = 145; // APRV_ACTV_RESP
	short BNFT_CRT_O_KC_RESP = 146; // BNFT_CRT_O_KC_RESP
	short BNFT_FC_RESP = 147; // BNFT_FC_RESP
	short BNFT_KC_RESP = 148; // BNFT_KC_RESP
	short BNFT_SG_RESP = 149; // BNFT_SG_RESP
	short INDV_CC_RQST_IND = 150; // INDV_CC_RQST_IND

	short SCHL_ENRL_RESP = 151; // SCHL_ENRL_RESP
	short TRB_CMDY_RESP = 152; // TRB_CMDY_RESP
	short CP_WLST_RESP = 153; // CP_WLST_RESP
	short INDIVIDUAL_CLA = 154; // INDV_CLA_IND

	//
	short NO_RESPONSE = 199; // no response.

	short INDV_DEMO_CHANGE = 200; // no response.
	short PREGNANCY_END = 201; // no response.
	short LIQ_ASET_CHRISTMAS_CLUB = 202;
//	short LIQ_ASET_CREDIT_UNION = 203; incorrect as asset transfer is 203
	short LIQ_ASET_CHILD_SUP_DD = 217;//added last sequence num 217 previous number was 204 replaced to use in persit for IRMCResponseProfileManager.persistStatus index sequence
	short LIQ_ASET_EXCESS_OVER_LIFE_GRANT_REFU = 205;
	short LIQ_ASET_SPECIAL_RESOURCE_ACCOUNT = 206;
	short LIQ_ASET_TAX_SHELTER_ACCOUNT = 207;
	short LIQ_ASET_TAX_REFUND = 208;
	short BUR_AST_BURIAL_FUND = 209;
	short BUR_AST_BURIAL_INTEREST = 210;
	short BUR_AST_BURIAL_SPACE = 211;
	short BUR_AST_COUNTABLE_BURIAL_TRUST = 212;
	short LIF_AST_ANNUITY = 213;
	short REAL_ASET_TRADE_WORK = 214;
	short REAL_ASET_MOBILE_HOME_LAND = 215;
	short LIQ_ASET_MONTHLY_EXCESS_OVER_GRANT_REFU = 216;

	short SHELTER_COST_DETAILS = 0;
	short UTILITY_COST_DETAILS = 1;
	short OTHER_INCOME_DETAILS = 2;
	short EMPLOYMENT_DETAILS = 3;
	short LIQUID_ASSET_DETAILS = 4;
	short VEHICLE_ASSET_DETAILS = 5;
	short REAL_PROPERTY_ASSET_DETAILS = 6;
	short BURIAL_ASSET_DETAILS = 7;
	short LIFE_INSURANCE_ASSET_DETAILS = 8;
	short OTHER_RESOURCE_ASET_DETAILS = 9;
	short OTHER_BILLS_MEDI_DETAILS = 10;

	short MOVED_INTO_HOME_RESPONSE = 155; // MOVED_INTO_HOME_RESPONSE
	short MOVED_OUT_OF_HOME_RESP = 156;// MOVED_OUT_OF_HOME_RESP
	short PAROLE_VIOLATION = 157;// PAROLE_VIOLATION_RESP
	short ROOM_BOARD = 158;// ROOM_BOARD_RESP

	short CURRENT_PAST_PENDING = 162;
	short MEDICAL_SERVICE = 160;
	short EMERGENCY_MEDICAL = 161;
	// other income types
	short STUDENT_FINANCIAL_AID = 163; // Student_financial_aid_resp
	short BLACK_LUNG_BENEFIT = 164;
	short CASH_GIFTS_CONT = 165;
	short FOOD_CLOTHING_UTIL_RENT = 166;
	short INHERITANCE = 167;
	short INSURANCE_SETTLEMENT = 168;
	short LOAN = 169;
	short LOTTERY_PRIZE_WINNING = 170;

	short STRIKE_BENEFITS_RESP = 173;

	short TRAINING_ALLOWANCE = 171;
	short OTHR_SOCIAL_SECURITY_BENEFITS = 172;
	short RESETTL_INC_RESP = 174;
	short OTHR_INCM_RENTL_RESP = 175;
	short LAND_CONT_RESP = 176;
	// other income types ends

	short HOUSING_BILLS_OTHERS = 177;
	short UTILITY_BILLS_OIL = 178;
	// other bills rmb

	short WORK_RELATED_EXPENSE_RESP = 179;

	short LIQUID_ASSET_ANNUITY = 97;// liquid_aset_disable_blind_resp
	short LIQUID_ASSET_IRA = 99;// liquid_asset_ira_resp
	short LIQUID_ASSET_IRS_RET = 100; // liquid_asset_irs_retirmnt_resp
	short LIQUID_ASSET_SAVINGS_ACC = 105;// liquid_asset_savings_acc_resp
	short LIQUID_ASSET_PENSION_PLAN = 101;// liquid_asset_pension_plan_resp
	short LIQUID_ASSET_PROMISSORY = 102;// liquid_asset_promissory_resp
	short LIQUID_ASSET_RETIREMENT = 103;// liquid_asset_retirement_resp
	short LIQUID_ASSET_STOCK_BONDS = 104;// liquid_asset_stocks_bonds_resp
	short LIQUID_ASSET_TRUST_FUND = 106;// liquid_asset_trust_fund_resp
	short LIQUID_ASSET_OTHER = 107;// liquid_asset_other_response
	short LIQUID_ASSET_OTHER_TYPE = 108;// liquid_asset_other_type_resp

	short HEAD_OF_HOUSE = 159; // head_of_household_resp

	// EDSP starts - life insurance type
	short LIFE_INS_ASSET_WHOLE_LIFE_RESP = 180; // whole life
	short LIFE_INSURANCE_ASSET_TERM_RESP = 181;// - asset term
	short LIFE_INS_ASEST_GROUP_LIFE_RESP = 182;// - group life
	short LIFE_INS_ASSET_GROUP_TERM_RESP = 183;// - group term
	short LIFE_INS_ASSET_UNIVERSAL_RESP = 184;// - asset universal
	short LIFE_INSURANCE_OTHER_RESP = 185;// - Other
	// short OTHER_ASET_LIFE_INSURANCE_RESP = 129; //- page resp

	// EDSP ends - life insurance type

	// medical types
	short MED_TYPE_PROSTHETIC_RESP = 186; // med_type_prosthetic_resp
	short MED_TYPE_ATNDNT_MEAL_RESP = 187;
	short MED_TYPE_ANIMAL_RESP = 188;
	short MED_TYPE_MAINTAIN_ATTNDNT_RESP = 189;
	short MED_TYPE_INHOME_RESP = 190;
	short MED_TYPE_SPECIAL_EQUIP_RESP = 191;
	short MED_TYPE_EYEGLASSES_RESP = 192;
	short MED_TYPE_INSURANCE_RESP = 193;
	short MED_TYPE_BILLS_RESP = 194;
	short MED_TYPE_SUPPLIES_RESP = 195;
	short MED_TYPE_NURSING_RESP = 196;
	short MED_TYPE_OTHER_RESP = 197;
	short MED_TYPE_OUT_PATIENT_RESP = 198;
	short MED_TYPE_PSYCHOTHERAPY_RESP = 199;
	short MED_TYPE_PRESCRIBED_DRUG_RESP = 200;
	short MED_TYPE_TRANSPORTATION_RESP = 201;
	short UTILITY_STANDARD_RESP = 202;
	short LIQUID_ASSET_XFER = 203;
	short INDV_TANF_RQST_IND = 218;//added last sequence num 217 previous number was 204 replaced to use in persit for IRMCResponseProfileManager.persistStatus index sequence
	short INDV_WIC_RQST_IND = 219;
	short OTHR_INCM_CONTRIB_RESP = 220;
	//	short INDV_TANF_RQST_IND = 217;//added last sequence num 217 previous number was 204 replaced to use in persit for IRMCResponseProfileManager.persistStatus index sequence 
	short CHILD_CARE_RESP = 221;
	short CHILD_OBLIGATION_RESP = 222;
	short MEDICAL_BILLS_RESP = 223;

	// RMC-Medical Bill Types
	short MEDTYP_DENTAL = 224;
	short MEDTYP_ATTENDANT_CARE = 225;
	short MEDTYP_DOCTOR = 226;
	short MEDTYP_MED_EQUIP = 227;
	short MEDTYP_HOSP_BILLS = 228;
	short MEDTYP_INSUR_PREMIUM = 229;
	short MEDTYP_RX_COST = 230;
	short MEDTYP_TRANS_MED = 231;
	short MEDTYP_OTHER = 232;
	short HOUS_PICE = 233;
	short OUTSTATE_BNFTS = 234;

	// medical types

	short LIQUID_ASET_BANK = 95;

	// EDSP RMC Real aset types

	short REAL_ASET_HOME = 120; // REAL_ASET_HOME_RESP
	short REAL_ASET_LIFE_ESTATE = 121; // real_asset_life_estate_resp
	short REAL_ASET_UNOCCUPY_HOME = 122; // REAL_ASET_UNOCCUPY_HOME_RESP

	// EDSP RMC Real aset types ends

	short VEH_ASET_TRACTOR = 141;
	short VEH_ASET_GOLFCART = 142;

	short VEH_ASET_NONMOTORIZED_CAMPER = 143;

	int INDV_PRG_RQST = 1000;

	short HOSPITAL_STAY_RESP = 204;//HOSPITAL_STAY_RESP
	short VEH_ASET_UNLIC = 238;//VEH_ASET_UNLIC_RESP

	short UNPAID_MEDBILL = 239;

	short SPECIAL_NEED = 240;
	short FOSTER_CARE_RESP = 241;
	short FORMER_FOSTER_RESP = 242;
	short CHILD_PROTECTIVE_RESP = 243;
	short LIVING_PROG_RESP = 244;
	short GRAND_PARENT_RESP = 245;
	short DRUG_FELONIES_RESP = 246;
	short SNAP_TANF_DISC_RESP = 247;
	short TANF_DISC_RESP = 329;
	short AVOID_PROSC_RESP = 248;
	short VIOLATING_PAROLE_RESP = 249;
	short CONVIC_FALSE_INFO_RESP = 250;
	short VOLUNTARILY_QUIT_JOB_RESP = 251;
	short TRADING_SNAP_RESP = 252;
	short BUY_SELL_SNAP_RESP = 253;
	short TRADE_SNAP_GUN_RESP = 254;
	short PREV_SSI_RESP = 255;
	short HOME_COMMUNITY_RESP = 256;
	short TRIBAL_HEALTH_RESP = 257;
	short TRIBAL_ELIGIBILITY_RESP = 258;
	short DOMESTIC_VIOLENCE_RESP = 259;
	short TANF_EPPIC_RESP = 260;
	short EMERGENCY_MEDICAL_RESP = 261;

	short MEDTYP_HSA_CONTRIB = 262;

	//Other Income types

	short UEI_ADOPTION_ASSIST = 263;
	short UEI_ADOPTION_PYMT = 264;
	short UEI_AGENT_ORNG_PYMT = 265;
	short UEI_ALIMONY = 266;
	short UEI_CAPITAL_GAINS = 267;
	short UEI_DEATH_BNFT = 268;
	short UEI_DABL_INCM = 269;
	short UEI_DR_RELIEF = 270;
	short UEI_EDU_ASSIST = 271;
	short UEI_ENERGY_ASSIST = 272;
	short UEI_FRM_ALOT = 273;
	short UEI_FOSTER_CARE_PYMT = 274;
	short UEI_GEN_ASSIST = 275;
	short UEI_INT_DIV_PYMT = 276;
	short UEI_IRA_DIST = 277;
	short UEI_LOTTERY_WIN = 278;
	short UEI_LUMP_SUM = 279;
	short UEI_MIL_ALOT = 280;
	short UEI_MON_FRO_OTH = 281;
	short UEI_NET_RENT_ROYALTY = 282;
	short UEI_OTH = 283;
	short UEI_ANNY_PYMT = 284;
	short UEI_PYMT_BO = 285;
	short UEI_PENSION = 286;
	short UEI_RR_RETIRE = 287;
	short UEI_REFUGEE_CASH = 288;
	short UEI_REL_CARE = 289;
	short UEI_RENTAL_INCM = 290;
	short UEI_TANF_PYMT = 291;
	short UEI_UNEMPL = 292;
	short UEI_WORKER_STUDY = 293;
	short UEI_WORKER_COMP = 294;
	short REAL_ASET_RENTAL = 295;//real_asset_rental_resp
	short REAL_ASET_VAC = 296;//real_aset_vac_resp
	short REAL_ASET_APARTMENT = 297; // REAL_ASET_APT_RESP
	short REAL_ASET_FARM = 298; // REAL_ASET_FRM_RESP

	short PERS_PROP_BUS_EQPT = 299;
	short PERS_PROP_CEMETARY_LOT = 300;
	short PERS_PROP_LIVESTOCK = 301;
	short PERS_PROP_SAF_DEPST_BOX = 302;
	short PERS_PROP_OTH_VAL = 303;

	short ABLE_TO_CONCEIVE_RESP = 304;
	short UNDERWEIGHT_BIRTH_RESP = 305;
	short PREG_ADD_STAT_SW = 306;
	short PREG_CHG_STAT_SW = 307;
	short PRSN_INFO_STAT_SW = 308;
	short RLT_CHG_STAT_SW = 309;

	short SU_CST_INS_RESP = 310;
	short OTHER_HOUSING_BILL_RESP = 311;
	short DISASTER_REPAIR_RESP = 312;
	short PREVENT_EVICTION_RESP = 313;
	short CARE_TAKER_RESP = 314;
	short OTHR_INCM_TRBL_RESP = 315;
	short LOST_HEALTH_INS_IND = 316;
	short TAX_CLAIM_DEPENDENT = 317;
	//NextGen  NG-6481 Phase 3 updates to ACA Streamline changes : Start
	short BEFORE_TAX_DEDUCTION = 318;
	short BTD_MED_INS = 319;
	short BTD_DENT_INS = 320;
	short BTD_VIS_CARE_INS = 321;
	short BTD_FLEX_ACC = 322;
	short BTD_DEF_COMP = 323;
	short BTD_PRE_TAX_INS = 324;
	short BTD_OTHER = 325;
	short TAX_DEDUCT_RESP = 326;
	short HLTH_INS_RESP = 327;
	short OTHR_HLTH_INS_RESP = 328;
	// NextGen NG-6481 Phase 3 updates to ACA Streamline changes � end

	//add and change indicator
	short ROOM_BRD_CHG_IND = 330;
	short DABL_STAT_IND = 331;
	short PREG_ADD_STAT_IND = 332;
	short PREG_CHG_IND = 333;
	short IRWE_CHG_IND = 334;
	short EI_CHG_IND = 335;
	short SELF_EMPL_CHG_IND = 336;
	short OTHR_INCM_CHG_IND = 337;
	short EMPL_CHG_IND = 338;
	short VEH_ASET_ADD_IND = 339;
	short VEH_ASET_CHG_IND = 340;
	short REAL_ASET_ADD_IND = 341;
	short REAL_ASET_CHG_IND = 342;
	short BURY_ASET_ADD_IND = 343;
	short BURY_ASET_CHG_IND = 344;
	short LIQUID_ASSET_ADD_IND = 345;
	short LIQUID_ASSET_BANK_ACC_CHG_IND = 346;
	short LIQUID_ASSET_CASH_CHG_IND = 347;
	short LIQUID_ASSET_CHG_IND = 348;
	short LIQUID_ASSET_OTHER_CHG_IND = 349;
	short LIFE_INS_ASET_ADD_IND = 350;
	short LIFE_INS_ASET_CHG_IND = 351;
	short ASET_XFER_CHG_IND = 352;
	short DPND_CARE_CHG_IND = 353;
	short HEALTH_INSURANCE_CHG_IND = 354;
	short CHILD_SUPPORT_PAYMENT_CHG_IND = 355;
	short SNAP_SHELTER_STANDARD_EXP_IND = 356;
	short HOUS_BILL_CHG_IND = 357;
	short ADD_CHG_IND = 358;
	short PERSON_MOVED_IN_STAT_IND = 359;
	short PERSON_MOVED_OUT_STAT_IND = 360;
	short HOSPICE_CHG_IND = 361;
	short MEDICARE_CHG_IND = 362;
	short NCP_CHG_IND = 363;
	short THIRD_PARTY_CHG_IND = 364;
	short HOSPITAL_ABD_CHG_IND = 365;
	short PUBLIC_LAW_ABD_CHG_IND = 366;
	short LIVING_ARGMT_CHG_IND = 367;
	short OTHER_PROGRAM_CHG_IND = 368;
	short MAGI_EXPENSE_CHG_IND = 369;
	short TAX_INFO_IND = 370;
	short TAX_DEPENDENT_IND = 371;
	//adding additional medical bill types
	short MEDICARE_PART_A = 372;
	short MEDICARE_PART_B = 373;
	short MEDICARE_PART_C = 374;
	short MEDICARE_PART_D = 375;
	short CCSP_PROVIDER_PAYMENT = 376;
	short ANIMALS_TO_ASSIST_DISABLED = 377;
	short FUNERAL_DEATH_EXPENSE = 378;
	short BLIND_WORK_EXPENSE = 379;
	short IMPAIRMENT_WORK_EXPENSE = 380;

	//other income american indian income
	short OTH_IND_GAMBL_PMNTS = 381;

	// Liquid Asset Types Addition
	short BONDS = 382;
	short DIVIDEND = 383;
	short HEALTH_REIMBURSEMENT_ACCOUNT = 384;
	short INDIVIDUAL_DEVELOPMENT_ACCOUNT = 385;
	short UNIFORM_GIFTS_TO_MINORS = 386;

	// Other Income Type Additional Types
	short INCOME_FROM_RESOURCE = 387;
	short INDIAN_GAMBLING_PAYMENTS = 388;
	short INHERITANCE_INCOME = 389;
	short INSUANCE_BENEFITS = 390;
	short LOAN_RECEIVED = 391;
	short LOAN_REPAYMENT_INCOME = 392;
	short MANAGED_INCOME = 393;
	short MATCH_GRANT = 394;
	short MONTGOMERY_GI_BILL = 395;
	short OUT_OF_STATE_PUBLIC = 396;

	short REFUNDS_FROM_DCH = 397;
	short RESTITUTIONS_SETTLEMENTS = 398;
	short SENIOR_COMPANION = 399;
	short SEVERANCE_PAY = 400;
	short STRIKE_BENEFITS = 401;
	short TRADE_READJUSTMENT = 402;
	short UNIFORM_RELOCATION = 403;
	short UNION_FUNDS = 404;
	short VENDOR_EXCLUDED = 405;
	short VICTIM_RESTITUTION = 406;

	short VOLUNTEER_PAYMENT = 407;
	short VOLUNTEER_PAYMENT_TITLEI = 408;
	short WIA_TRAINING_AND_ALLOWANCE = 409;
	short INCLUDED_UNEARNED_INCOME = 410;
	short TANF_MAX_AU_ALLOTMENT = 411;
	short TANF_MAX_GRG_ALLOTMENT = 412;
	short CHARITABLE_DONATION = 413;
	short CHILD_NUTRITION_PAYMENTS = 414;
	short BLACK_LUNG_BENEFITS = 415;
	short CHILD_SUPPORT_COURT = 416;

	short CHILD_SUPPORT_GAP_PAYMENT = 417;
	short CIVIL_SERVICE = 418;
	short DEFERRED_COMPENSATION_PLANS = 419;
	short DISABILITY_INSURANCE = 420;
	short EXCLUDED_UNEARNED_INCOME = 421;
	short FEMA_PAYMENT_DISASTER = 422;
	short FEMA_PAYMENT_NON_DISASTER = 423;
	short HEALTH_SAVINGS_ACCOUNT = 424;
	short IN_KIND_SUPPORT = 425;
	short FOSTER_GRANDPARENT_PROGRAM = 426;

	short DISASTER_UNEMPLOYMENT = 427;
	short DIVIDENDS = 428;
	short CHARITABLE_DONATION_FEDERAL = 429;
	short PERSONAL_INFO = 430;

	short PATIENT_FUND = 431;
	short DISASTER_ASSISTANCE = 432;
	short NON_BUSINESS_EQUIPMENT = 433;
	short HOUSEHOLD_GOODS = 434;
	short OTHER_NON_COUNTABLE = 435;
	short OUT_ST_BNFT_CHG_IND = 436;
	short SCHL_ENRL_CHG_IND = 437;
	short MRTL_STAT_CHG_IND = 438;
	short LIQ_ASET_CHECKING_ACCOUNT = 439; // LQD_ASET_C_A_RESP
	short LIQ_ASET_KEOUGH_PLAN = 440; // LQD_ASET_K_P_RESP
	short NUR_HME_CHG_IND = 441;
	short BFR_TAX_CHG_IND = 442;
	short INC_TAX_CHG_IND = 443;
	short THRD_PRTY_CHG_IND = 444;
	short DEATH_BENEFIT_STATE_FEDERAL = 445;
	short SOCIAL_SECURITY_SURVIVOR = 446;
	short VENDOR_PAYMENTS = 447;
	short CITIZENSHIP_INFO = 448;
	short INDV_PRGM_CHG_IND = 449;
	short EMPL_HLTH_INS_RESP = 450;
	short AVD_PRSCTN_FSTF = 451;
	short BNFT_CNVCTN = 1000;
	short HEAT_COOL_SRC = 452;
	short KATIE_BECKETT = 453;

	/**
	 * creates and returns RMC_IN_PRFL_Cargo
	 */
	public RMC_IN_PRFL_Cargo createRMCIndividualProfile(RMC_IN_PRFL_Cargo aRMCInPrflCargo);

	/**
	 * here we are determine the dirty status
	 */
	public boolean determineDirtyStatus(String aResponseFromPage, String aResponseFromSession, int[] aDirtyStatus, int aCurrentPageStatus);

	/**
	 * returns the response indicator from RMC_IN_PRFL_Cargo for the given
	 * fieldID
	 */
	public String getProfileResponse(RMC_IN_PRFL_Cargo aPrflCargo, short aProfileId);

	/**
	 * returns the RMC_IN_PRFL_Cargo for the given indvSeqNum from the given
	 * collection, otherwise throws exception
	 */
	public RMC_IN_PRFL_Cargo getProfile(RMC_IN_PRFL_Collection aRMCInProfileCollection, String aIndvSeqNum);

	/**
	 * getting the max seq number for the appInPrflColl.
	 */
	public int getMaxIndvSeqNumber(RMC_IN_PRFL_Collection sessionRMCInPrflColl);

	/**
	 * This method will get the Type Constant
	 */
	public short getResponseByType(short detailsType, String aType);

	/**
	 * this method returns type status from the RMC_IN_PRFL cargo
	 */
	public char getStatus(RMC_IN_PRFL_Cargo aRMCInPrflCargo, short detailType, String aType);

	/**
	 * if seleted resp id is notrequired it returns true other wise it returns
	 * false
	 */
	public boolean isAppResponseNotRequired(RMC_IN_PRFL_Collection aRMCInProfileCollection, short aRespId);

	/**
	 * loads the RMC_IN_PRFL_Collection from database for the given RMC_NUM
	 */
	public RMC_IN_PRFL_Collection loadProfile(String aAppNum);

	/**
	 * updates the cargo with the new status for the passed responseId's
	 * (column)
	 */
	public void makeAbsoluteNotRequired(short[] aResponseID, RMC_IN_PRFL_Cargo aCargo, boolean persist);

	/**
	 * updates the cargo with the new status for the passed responseId (column)
	 */
	public void makeAbsoluteNotRequired(short aResponseID, RMC_IN_PRFL_Cargo aCargo, boolean persist);

	/**
	 * updates the cargo with the new status for the passed responseId's
	 * (column)
	 */
	public void makeAddNew(short[] aResponseID, RMC_IN_PRFL_Cargo aCargo, boolean persist);

	/**
	 * updates the cargo with the new status for the passed responseId (column)
	 */
	public void makeAddNew(short aResponseID, RMC_IN_PRFL_Cargo aCargo, boolean persist);

	/**
	 * updates the cargo with the new status for the passed responseId's
	 * (column)
	 */
	public void makeComplete(short[] aResponseID, RMC_IN_PRFL_Cargo aCargo, boolean persist);

	/**
	 * updates the cargo with the new status for the passed responseId's
	 * (column)
	 */
	public void makeComplete(short aResponseID, RMC_IN_PRFL_Cargo aCargo, boolean persist);

	/**
	 * updates the cargo with the new status for the passed responseId's
	 * (column)
	 */
	public void makeNotRequired(short[] aResponseID, RMC_IN_PRFL_Cargo aCargo, boolean persist);

	/**
	 * updates the cargo with the new status for the passed responseId (column)
	 */
	public void makeNotRequired(short aResponseID, RMC_IN_PRFL_Cargo aCargo, boolean persist);

	/**
	 * updates the cargo with the new status for the passed responseId's
	 * (column)
	 */
	public void makeRequired(short[] aResponseID, RMC_IN_PRFL_Cargo aCargo, boolean persist);

	/**
	 * updates the cargo with the new status for the passed responseId (column)
	 */
	public void makeRequired(short aResponseID, RMC_IN_PRFL_Cargo aCargo, boolean persist);

	/**
	 * persist the data to the data base
	 */
	public void persist(String aAppNum, String aIndvSeqNum, short[] aResponseIds, String[] aResponseValues);

	/**
	 * this method copys completed and visit again responses from session to
	 * page collection and populate empty cargos
	 */
	public void preparePageColl(RMC_IN_PRFL_Collection aPageCollProfile, RMC_IN_PRFL_Collection aSessionProfile, short[] aResponsesIds);

	/**
	 * in this method we will run the dirty logic on driver on the base of dirty
	 * status we are updating driver manager
	 */
	public void runDirtyLogicOnDriver(String aAppNumber, int aDirtyStatus, String aDesiredPageId, int[] aDriverArray);

	/**
	 * this method translate the profile responses
	 */
	public void translateProfileResponseAfterValidation(RMC_IN_PRFL_Collection aPageCollection, RMC_IN_PRFL_Collection aSessionColl,
			short[] aResponsesIds);

	/**
	 * This is overloaded method to the translate profile responses fot type
	 */
	public void translateProfileResponses(String aResponseFromPage, String aResponseFromSession, int aCurrentPageStatus, short aResponseId,
			RMC_IN_PRFL_Cargo aSessionAppInPrflCargo);

	/**
	 * this method translate the profile responses as well as it will update the
	 * session with the new responsess
	 */
	public void translateProfileResponsesForType(String aResponseFromPage, String aResponseFromSession, int aCurrentPageStatus, short aResponseId,
			RMC_IN_PRFL_Cargo aSessionAppInPrflCargo, short aParentPageResponseId);

	/**
	 * This method only updateds these program Requests indv_fma_rqst,
	 * indv_fpw_rqst, indv_fs_rqst
	 */
	public void updateProgramRequestProfile(RMC_IN_PRFL_Cargo aPrflCargo);

	/**
	 * This method deletes the individual from rmc inidvidual profile
	 */
	public RMC_IN_PRFL_Collection deleteIndividualFromAppIndividualProfile(RMC_IN_PRFL_Collection aSessionappInPrflColl, String indvSeqNum);

	/**
	 * This method retruns the type for given response
	 */
	public String getTypeByResponse(short response);

	public String getOtherIncomeTypeByResponse(short response);
	public String getBnftCnvctnTypeByResponse(short response);

	public String getLiquidResourceTypeByResponse(short response);

	public String getTaxTypeByResponse(short response);

	public String geHousingBillsTypeByResponse(short response);

	/**
	 * if selected resp id is notrequired it returns true otherwise it returns
	 * false
	 *
	 * @param aRMCInProfileCollection
	 * @param aRespId
	 * @return
	 */
	public boolean isRMCInPrflRespNotRequired(RMC_IN_PRFL_Collection aRMCInProfileCollection, short[] aRespId);

	/**
	 * Updates RMC_IN_PRFL_Collection session profile collection based on the
	 * RESPONSE_CUSTOM_Collection
	 *
	 * @param aResponseCustomColl
	 * @param aRMCInSessionPrflColl
	 * @param aRespId
	 * @return
	 */
	public RMC_IN_PRFL_Collection updateSessionProfile(RMC_RESPONSE_Custom_Collection aResponseCustomColl,
			RMC_IN_PRFL_Collection aRMCInSessionPrflColl, short[] aRespId);
}
