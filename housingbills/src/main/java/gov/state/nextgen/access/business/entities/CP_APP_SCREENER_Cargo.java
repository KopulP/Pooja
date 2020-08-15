package gov.state.nextgen.access.business.entities;


import gov.state.nextgen.access.business.entities.AbstractCargo;
import gov.state.nextgen.access.business.entities.IPrimaryKey;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * This java bean contains the entities of CP_APP_SCREENER
 *
 * @author Shine Prasad
 * Creation Date Date Sep 18 15:00:00 EDT 2014 Modified By: Modified on: PCR#
 */
@Entity
@Table(name = "CP_APP_SCREENER")
public class CP_APP_SCREENER_Cargo extends AbstractCargo implements
		Serializable {

	private static final long serialVersionUID = -3952632001756177444L;
	private static final String PACKAGE = "gov.state.nextgen.framework.business.entities.CP_APP_SCREENER";
	
	@Transient
	boolean isDirty = false;
	
	
	 @Id
	 @GenericGenerator(name="seq_id", strategy="gov.state.nextgen.access.data.sequenceGenerator.StringKeyGenerator")
	 @GeneratedValue(generator="seq_id")
	private String app_screener_num;

	@Override
	public boolean isDirty() {
		return isDirty;
	}

	@Override
	public void setDirty(final boolean isDirty) {
		this.isDirty = isDirty;
	}

	// Resident of Georgia Response
	private String res_ga_resp;
	// County Name Code
	private String cnty_name_cd;
	// Number of adults (19 through 59 years):
	private String num_chld_under_19;
	// Number of adults (19 through 59 years):
	private String num_adults_age_grp_1;
	// Number of adults (60 through 64 years):
	private String num_adults_age_grp_2;
	// Number of Adults (65 years or older):
	private String num_adults_age_grp_3;
	// Pregnant Response
	private String preg_resp;
	// Breastfeed Response
	private String breast_feed_resp;
	// Ended Pregnancy but no Breastfeed Response
	private String end_preg_no_breast_feed_resp;
	// Medicare Eligible Response
	private String medicare_eligib_resp;
	// Guardian of Other Children Response
	private String guard_oth_chld_resp;
	// Work School Training Activity Response
	private String wk_sch_train_act_resp;
	// Disabled Blind And SSA Response
	private String dabl_blnd_and_ssa_resp;
	// Living In Nursing Home Response
	private String live_in_nurs_home_resp;
	// Child Healthcare Insurance Response
	private String chld_hlth_ins_resp;
	// Child Healthcare Insurance In Last 2 Months Response
	private String chld_hlth_ins_lst_2mth_resp;
	// Caretaker of Minor Response
	private String caretaker_of_minor_resp;
	// Caretaker 60 Years Older Response
	private String caretaker_60yrs_old_resp;
	// Caretaker Student Response
	private String caretaker_student_resp;
	// Number of Household Members Employed
	private String num_hsld_employed;
	// Household Before Tax Earned income
	private String hsld_bt_earned_income;
	// Social Security income
	private String ss_income;
	// SSI Income
	private String ssi_income;
	// Unemployment Income
	private String unemployment_income;
	// Cash and Gifts Income
	private String cash_gifts_income;
	// Alimony Income
	private String alimony_income;
	// Rental income
	private String rental_income;
	// Other Income
	private String other_income;
	// Create Date
	private String create_dt;
	// Disabled Caring For Child Under 5 Years
	private String dabl_care_chld_lt_5yrs_resp;
	// Any Child In Home With Special Needs
	private String chld_13_18_spcl_need_resp;
	// Work, Training Program And Caring of Child
	private String wrk_and_care_chld_resp;
	// Household Rent And Mortgage
	private String hshl_rent_mtg_mth_pymt;
	// Heating And Cooling Expenses
	private String hshl_pay_heat_cool_exp_resp;
	// Anyone With TANF or Medicaid or Snap
	private String rcv_snap_tanf_medicaid_resp;
	// Screener Eligibility Result Medical Assistance
	private String scr_elg_rslt_ma;
	// Screener Eligibility Result Child Care
	private String scr_elg_rslt_cc;
	// Screener Eligibility Result SNAP
	private String scr_elg_rslt_snap;
	// Screener Eligibility Result WIC
	private String scr_elg_rslt_wic;
	// Screener Eligibility Result TANF
	private String scr_elg_rslt_tanf;
	// Screener Eligibility Result LIHEAP
	private String scr_elg_rslt_liheap;
	private String num_chld_under_13;

	private String create_user_no;
	private String create_user_id;

	/**
	 * @return the num_chld_under_13
	 */
	public String getNum_chld_under_13() {
		return num_chld_under_13;
	}

	/**
	 * @param num_chld_under_13
	 *            the num_chld_under_13 to set
	 */
	public void setNum_chld_under_13(final String num_chld_under_13) {
		this.num_chld_under_13 = num_chld_under_13;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the app_screener_num
	 */
	public String getApp_screener_num() {
		return app_screener_num;
	}

	/**
	 * @param app_screener_num
	 *            the app_screener_num to set
	 */
	public void setApp_screener_num(final String app_screener_num) {
		this.app_screener_num = app_screener_num;
	}

	/**
	 * @return the res_ga_resp
	 */
	public String getRes_ga_resp() {
		return res_ga_resp;
	}

	/**
	 * @param res_ga_resp
	 *            the res_ga_resp to set
	 */
	public void setRes_ga_resp(final String res_ga_resp) {
		this.res_ga_resp = res_ga_resp;
	}

	/**
	 * @return the cnty_name_cd
	 */
	public String getCnty_name_cd() {
		return cnty_name_cd;
	}

	/**
	 * @param cnty_name_cd
	 *            the cnty_name_cd to set
	 */
	public void setCnty_name_cd(final String cnty_name_cd) {
		this.cnty_name_cd = cnty_name_cd;
	}

	/**
	 * @return the num_chld_under_19
	 */
	public String getNum_chld_under_19() {
		return num_chld_under_19;
	}

	/**
	 * @param num_chld_under_19
	 *            the num_chld_under_19 to set
	 */
	public void setNum_chld_under_19(final String num_chld_under_19) {
		this.num_chld_under_19 = num_chld_under_19;
	}

	/**
	 * @return the num_adults_age_grp_1
	 */
	public String getNum_adults_age_grp_1() {
		return num_adults_age_grp_1;
	}

	/**
	 * @param num_adults_age_grp_1
	 *            the num_adults_age_grp_1 to set
	 */
	public void setNum_adults_age_grp_1(final String num_adults_age_grp_1) {
		this.num_adults_age_grp_1 = num_adults_age_grp_1;
	}

	/**
	 * @return the num_adults_age_grp_2
	 */
	public String getNum_adults_age_grp_2() {
		return num_adults_age_grp_2;
	}

	/**
	 * @param num_adults_age_grp_2
	 *            the num_adults_age_grp_2 to set
	 */

	public void setNum_adults_age_grp_2(final String num_adults_age_grp_2) {
		this.num_adults_age_grp_2 = num_adults_age_grp_2;
	}

	/**
	 * @return the num_adults_age_grp_3
	 */
	public String getNum_adults_age_grp_3() {
		return num_adults_age_grp_3;
	}

	/**
	 * @param num_adults_age_grp_3
	 *            the num_adults_age_grp_3 to set
	 */
	public void setNum_adults_age_grp_3(final String num_adults_age_grp_3) {
		this.num_adults_age_grp_3 = num_adults_age_grp_3;
	}

	/**
	 * @return the preg_resp
	 */
	public String getPreg_resp() {
		return preg_resp;
	}

	/**
	 * @param preg_resp
	 *            the preg_resp to set
	 */
	public void setPreg_resp(final String preg_resp) {
		this.preg_resp = preg_resp;
	}

	/**
	 * @return the breast_feed_resp
	 */
	public String getBreast_feed_resp() {
		return breast_feed_resp;
	}

	/**
	 * @param breast_feed_resp
	 *            the breast_feed_resp to set
	 */
	public void setBreast_feed_resp(final String breast_feed_resp) {
		this.breast_feed_resp = breast_feed_resp;
	}

	/**
	 * @return the end_preg_no_breast_feed_resp
	 */
	public String getEnd_preg_no_breast_feed_resp() {
		return end_preg_no_breast_feed_resp;
	}

	/**
	 * @param end_preg_no_breast_feed_resp
	 *            the end_preg_no_breast_feed_resp to set
	 */
	public void setEnd_preg_no_breast_feed_resp(
			final String end_preg_no_breast_feed_resp) {
		this.end_preg_no_breast_feed_resp = end_preg_no_breast_feed_resp;
	}

	/**
	 * @return the v
	 */
	public String getMedicare_eligib_resp() {
		return medicare_eligib_resp;
	}

	/**
	 * @param medicare_eligib_resp
	 *            the medicare_eligib_resp to set
	 */
	public void setMedicare_eligib_resp(final String medicare_eligib_resp) {
		this.medicare_eligib_resp = medicare_eligib_resp;
	}

	/**
	 * @return the guard_oth_chld_resp
	 */
	public String getGuard_oth_chld_resp() {
		return guard_oth_chld_resp;
	}

	/**
	 * @param guard_oth_chld_resp
	 *            the guard_oth_chld_resp to set
	 */
	public void setGuard_oth_chld_resp(final String guard_oth_chld_resp) {
		this.guard_oth_chld_resp = guard_oth_chld_resp;
	}

	/**
	 * @return the wk_sch_train_act_resp
	 */
	public String getWk_sch_train_act_resp() {
		return wk_sch_train_act_resp;
	}

	/**
	 * @param wk_sch_train_act_resp
	 *            the wk_sch_train_act_resp to set
	 */
	public void setWk_sch_train_act_resp(final String wk_sch_train_act_resp) {
		this.wk_sch_train_act_resp = wk_sch_train_act_resp;
	}

	/**
	 * @return the dabl_blnd_and_ssa_resp
	 */
	public String getDabl_blnd_and_ssa_resp() {
		return dabl_blnd_and_ssa_resp;
	}

	/**
	 * @param dabl_blnd_and_ssa_resp
	 *            the dabl_blnd_and_ssa_resp to set
	 */
	public void setDabl_blnd_and_ssa_resp(final String dabl_blnd_and_ssa_resp) {
		this.dabl_blnd_and_ssa_resp = dabl_blnd_and_ssa_resp;
	}

	/**
	 * @return the live_in_nurs_home_resp
	 */
	public String getLive_in_nurs_home_resp() {
		return live_in_nurs_home_resp;
	}

	/**
	 * @param live_in_nurs_home_resp
	 *            the live_in_nurs_home_resp to set
	 */
	public void setLive_in_nurs_home_resp(final String live_in_nurs_home_resp) {
		this.live_in_nurs_home_resp = live_in_nurs_home_resp;
	}

	/**
	 * @return the chld_hlth_ins_resp
	 */
	public String getChld_hlth_ins_resp() {
		return chld_hlth_ins_resp;
	}

	/**
	 * @param chld_hlth_ins_resp
	 *            the chld_hlth_ins_resp to set
	 */
	public void setChld_hlth_ins_resp(final String chld_hlth_ins_resp) {
		this.chld_hlth_ins_resp = chld_hlth_ins_resp;
	}

	/**
	 * @return the chld_hlth_ins_lst_2mth_resp
	 */
	public String getChld_hlth_ins_lst_2mth_resp() {
		return chld_hlth_ins_lst_2mth_resp;
	}

	/**
	 * @param chld_hlth_ins_lst_2mth_resp
	 *            the chld_hlth_ins_lst_2mth_resp to set
	 */
	public void setChld_hlth_ins_lst_2mth_resp(
			final String chld_hlth_ins_lst_2mth_resp) {
		this.chld_hlth_ins_lst_2mth_resp = chld_hlth_ins_lst_2mth_resp;
	}

	/**
	 * @return the caretaker_of_minor_resp
	 */
	public String getCaretaker_of_minor_resp() {
		return caretaker_of_minor_resp;
	}

	/**
	 * @param caretaker_of_minor_resp
	 *            the caretaker_of_minor_resp to set
	 */
	public void setCaretaker_of_minor_resp(final String caretaker_of_minor_resp) {
		this.caretaker_of_minor_resp = caretaker_of_minor_resp;
	}

	/**
	 * @return the caretaker_60yrs_old_resp
	 */
	public String getCaretaker_60yrs_old_resp() {
		return caretaker_60yrs_old_resp;
	}

	/**
	 * @param caretaker_60yrs_old_resp
	 *            the caretaker_60yrs_old_resp to set
	 */
	public void setCaretaker_60yrs_old_resp(
			final String caretaker_60yrs_old_resp) {
		this.caretaker_60yrs_old_resp = caretaker_60yrs_old_resp;
	}

	/**
	 * @return the caretaker_student_resp
	 */
	public String getCaretaker_student_resp() {
		return caretaker_student_resp;
	}

	/**
	 * @param caretaker_student_resp
	 *            the caretaker_student_resp to set
	 */
	public void setCaretaker_student_resp(final String caretaker_student_resp) {
		this.caretaker_student_resp = caretaker_student_resp;
	}

	/**
	 * @return the num_hsld_employed
	 */
	public String getNum_hsld_employed() {
		return num_hsld_employed;
	}

	/**
	 * @param num_hsld_employed
	 *            the num_hsld_employed to set
	 */
	public void setNum_hsld_employed(final String num_hsld_employed) {
		this.num_hsld_employed = num_hsld_employed;
	}

	/**
	 * @return the hsld_bt_earned_income
	 */
	public String getHsld_bt_earned_income() {
		return hsld_bt_earned_income;
	}

	/**
	 * @param hsld_bt_earned_income
	 *            the hsld_bt_earned_income to set
	 */
	public void setHsld_bt_earned_income(final String hsld_bt_earned_income) {
		this.hsld_bt_earned_income = hsld_bt_earned_income;
	}

	/**
	 * @return the ss_income
	 */
	public String getSs_income() {
		return ss_income;
	}

	/**
	 * @param ss_income
	 *            the ss_income to set
	 */
	public void setSs_income(final String ss_income) {
		this.ss_income = ss_income;
	}

	/**
	 * @return the ssi_income
	 */
	public String getSsi_income() {
		return ssi_income;
	}

	/**
	 * @param ssi_income
	 *            the ssi_income to set
	 */
	public void setSsi_income(final String ssi_income) {
		this.ssi_income = ssi_income;
	}

	/**
	 * @return the unemployment_income
	 */
	public String getUnemployment_income() {
		return unemployment_income;
	}

	/**
	 * @param unemployment_income
	 *            the unemployment_income to set
	 */
	public void setUnemployment_income(final String unemployment_income) {
		this.unemployment_income = unemployment_income;
	}

	/**
	 * @return the cash_gifts_income
	 */
	public String getCash_gifts_income() {
		return cash_gifts_income;
	}

	/**
	 * @param cash_gifts_income
	 *            the cash_gifts_income to set
	 */
	public void setCash_gifts_income(final String cash_gifts_income) {
		this.cash_gifts_income = cash_gifts_income;
	}

	/**
	 * @return the alimony_income
	 */
	public String getAlimony_income() {
		return alimony_income;
	}

	/**
	 * @param alimony_income
	 *            the alimony_income to set
	 */
	public void setAlimony_income(final String alimony_income) {
		this.alimony_income = alimony_income;
	}

	/**
	 * @return the rental_income
	 */
	public String getRental_income() {
		return rental_income;
	}

	/**
	 * @param rental_income
	 *            the rental_income to set
	 */
	public void setRental_income(final String rental_income) {
		this.rental_income = rental_income;
	}

	/**
	 * @return the other_income
	 */
	public String getOther_income() {
		return other_income;
	}

	/**
	 * @param other_income
	 *            the other_income to set
	 */
	public void setOther_income(final String other_income) {
		this.other_income = other_income;
	}

	/**
	 * @return the create_dt
	 */
	public String getCreate_dt() {
		return create_dt;
	}

	/**
	 * @param create_dt
	 *            the create_dt to set
	 */
	public void setCreate_dt(final String create_dt) {
		this.create_dt = create_dt;
	}

	/**
	 * @return the dabl_care_chld_lt_5yrs_resp
	 */
	public String getDabl_care_chld_lt_5yrs_resp() {
		return dabl_care_chld_lt_5yrs_resp;
	}

	/**
	 * @param dabl_care_chld_lt_5yrs_resp
	 *            the dabl_care_chld_lt_5yrs_resp to set
	 */
	public void setDabl_care_chld_lt_5yrs_resp(
			final String dabl_care_chld_lt_5yrs_resp) {
		this.dabl_care_chld_lt_5yrs_resp = dabl_care_chld_lt_5yrs_resp;
	}

	/**
	 * @return the chld_13_18_spcl_need_resp
	 */
	public String getChld_13_18_spcl_need_resp() {
		return chld_13_18_spcl_need_resp;
	}

	/**
	 * @param chld_13_18_spcl_need_resp
	 *            the chld_13_18_spcl_need_resp to set
	 */
	public void setChld_13_18_spcl_need_resp(
			final String chld_13_18_spcl_need_resp) {
		this.chld_13_18_spcl_need_resp = chld_13_18_spcl_need_resp;
	}

	public String getWrk_and_care_chld_resp() {
		return wrk_and_care_chld_resp;
	}

	public void setWrk_and_care_chld_resp(final String wrk_and_care_chld_resp) {
		this.wrk_and_care_chld_resp = wrk_and_care_chld_resp;
	}

	/**
	 * @return the hshl_rent_mtg_mth_pymt
	 */
	public String getHshl_rent_mtg_mth_pymt() {
		return hshl_rent_mtg_mth_pymt;
	}

	/**
	 * @param hshl_rent_mtg_mth_pymt
	 *            the hshl_rent_mtg_mth_pymt
	 */
	public void setHshl_rent_mtg_mth_pymt(final String hshl_rent_mtg_mth_pymt) {
		this.hshl_rent_mtg_mth_pymt = hshl_rent_mtg_mth_pymt;
	}

	/**
	 * @return the hshl_pay_heat_cool_exp_resp
	 */
	public String getHshl_pay_heat_cool_exp_resp() {
		return hshl_pay_heat_cool_exp_resp;
	}

	/**
	 * @param hshl_pay_heat_cool_exp_resp
	 *            the hshl_pay_heat_cool_exp_resp
	 */
	public void setHshl_pay_heat_cool_exp_resp(
			final String hshl_pay_heat_cool_exp_resp) {
		this.hshl_pay_heat_cool_exp_resp = hshl_pay_heat_cool_exp_resp;
	}

	/**
	 * @return the rcv_snap_tanf_medicaid_resp
	 */
	public String getRcv_snap_tanf_medicaid_resp() {
		return rcv_snap_tanf_medicaid_resp;
	}

	/**
	 * @param rcv_snap_tanf_medicaid_resp
	 *            the rcv_snap_tanf_medicaid_resp
	 */
	public void setRcv_snap_tanf_medicaid_resp(
			final String rcv_snap_tanf_medicaid_resp) {
		this.rcv_snap_tanf_medicaid_resp = rcv_snap_tanf_medicaid_resp;
	}

	/**
	 * @return the scr_elg_rslt_ma
	 */
	public String getScr_elg_rslt_ma() {
		return scr_elg_rslt_ma;
	}

	/**
	 * @param scr_elg_rslt_ma
	 *            the scr_elg_rslt_ma to set
	 */
	public void setScr_elg_rslt_ma(final String scr_elg_rslt_ma) {
		this.scr_elg_rslt_ma = scr_elg_rslt_ma;
	}

	/**
	 * @return the scr_elg_rslt_cc
	 */
	public String getScr_elg_rslt_cc() {
		return scr_elg_rslt_cc;
	}

	/**
	 * @param scr_elg_rslt_cc
	 *            the scr_elg_rslt_cc to set
	 */
	public void setScr_elg_rslt_cc(final String scr_elg_rslt_cc) {
		this.scr_elg_rslt_cc = scr_elg_rslt_cc;
	}

	/**
	 * @return the scr_elg_rslt_snap
	 */
	public String getScr_elg_rslt_snap() {
		return scr_elg_rslt_snap;
	}

	/**
	 * @param scr_elg_rslt_snap
	 *            the scr_elg_rslt_snap to set
	 */
	public void setScr_elg_rslt_snap(final String scr_elg_rslt_snap) {
		this.scr_elg_rslt_snap = scr_elg_rslt_snap;
	}

	/**
	 * @return the scr_elg_rslt_wic
	 */
	public String getScr_elg_rslt_wic() {
		return scr_elg_rslt_wic;
	}

	/**
	 * @param scr_elg_rslt_wic
	 *            the scr_elg_rslt_wic to set
	 */
	public void setScr_elg_rslt_wic(final String scr_elg_rslt_wic) {
		this.scr_elg_rslt_wic = scr_elg_rslt_wic;
	}

	/**
	 * @return the scr_elg_rslt_tanf
	 */
	public String getScr_elg_rslt_tanf() {
		return scr_elg_rslt_tanf;
	}

	/**
	 * @param scr_elg_rslt_tanf
	 *            the scr_elg_rslt_tanf to set
	 */
	public void setScr_elg_rslt_tanf(final String scr_elg_rslt_tanf) {
		this.scr_elg_rslt_tanf = scr_elg_rslt_tanf;
	}

	/**
	 * @return the scr_elg_rslt_liheap
	 */
	public String getScr_elg_rslt_liheap() {
		return scr_elg_rslt_liheap;
	}

	/**
	 * @param scr_elg_rslt_liheap
	 *            the scr_elg_rslt_liheap to set
	 */
	public void setScr_elg_rslt_liheap(final String scr_elg_rslt_liheap) {
		this.scr_elg_rslt_liheap = scr_elg_rslt_liheap;
	}

	/**
	 * @return the create_user_no
	 */
	public String getCreate_user_no() {
		return create_user_no;
	}

	/**
	 * @param create_user_no
	 *            the create_user_no to set
	 */
	public void setCreate_user_no(final String create_user_no) {
		this.create_user_no = create_user_no;
	}

	/**
	 * @return the create_user_id
	 */
	public String getCreate_user_id() {
		return create_user_id;
	}

	/**
	 * @param create_user_id
	 *            the create_user_id to set
	 */
	public void setCreate_user_id(final String create_user_id) {
		this.create_user_id = create_user_id;
	}

	/**
	 * returns the PrimaryKey object.
	 */
	@Override
	public IPrimaryKey getPrimaryKey() {
		final CP_APP_SCREENER_PrimaryKey key = new CP_APP_SCREENER_PrimaryKey();
		key.setApp_screener_num(getApp_screener_num());
		return key;
	}

	/**
	 * returns the PACKAGE name.
	 */
	public String getPackage() {
		return PACKAGE;
	}

	/**
	 * returns the string value of cargo.
	 */

	/**
	 * returns the string value of cargo.
	 */
	@Override
	public String inspectCargo() {

		return new StringBuilder().append("CP_APP_SCREENER: ")
				.append("app_screener_num=").append(app_screener_num)
				.append("res_ga_resp=").append(res_ga_resp)
				.append("cnty_name_cd=").append(cnty_name_cd)
				.append("num_chld_under_19=").append(num_chld_under_19)
				.append("num_adults_age_grp_1=").append(num_adults_age_grp_1)
				.append("num_adults_age_grp_2=").append(num_adults_age_grp_2)
				.append("num_adults_age_grp_3=").append(num_adults_age_grp_3)
				.append("preg_resp=").append(preg_resp)
				.append("breast_feed_resp=").append(breast_feed_resp)
				.append("end_preg_no_breast_feed_resp=")
				.append(end_preg_no_breast_feed_resp)
				.append("medicare_eligib_resp=").append(medicare_eligib_resp)
				.append("guard_oth_chld_resp=").append(guard_oth_chld_resp)
				.append("wk_sch_train_act_resp=").append(wk_sch_train_act_resp)
				.append("dabl_blnd_and_ssa_resp=")
				.append(dabl_blnd_and_ssa_resp)
				.append("live_in_nurs_home_resp=")
				.append(live_in_nurs_home_resp).append("chld_hlth_ins_resp=")
				.append(chld_hlth_ins_resp)
				.append("chld_hlth_ins_lst_2mth_resp=")
				.append(chld_hlth_ins_lst_2mth_resp)
				.append("caretaker_of_minor_resp=")
				.append(caretaker_of_minor_resp)
				.append("caretaker_60yrs_old_resp=")
				.append(caretaker_60yrs_old_resp)
				.append("caretaker_student_resp=")
				.append(caretaker_student_resp).append("num_hsld_employed=")
				.append(num_hsld_employed).append("hsld_bt_earned_income=")
				.append(hsld_bt_earned_income).append("ss_income=")
				.append(ss_income).append("ssi_income=").append(ssi_income)
				.append("unemployment_income=").append(unemployment_income)
				.append("cash_gifts_income=").append(cash_gifts_income)
				.append("alimony_income=").append(alimony_income)
				.append("rental_income=").append(rental_income)
				.append("other_income=").append(other_income)
				.append("create_dt=").append(create_dt)
				.append("dabl_care_chld_lt_5yrs_resp=")
				.append(dabl_care_chld_lt_5yrs_resp)
				.append("chld_13_18_spcl_need_resp=")
				.append(chld_13_18_spcl_need_resp)
				.append("wrk_and_care_chld_resp=")
				.append(wrk_and_care_chld_resp)
				.append("hshl_rent_mtg_mth_pymt=")
				.append(hshl_rent_mtg_mth_pymt)
				.append("hshl_pay_heat_cool_exp_resp=")
				.append(hshl_pay_heat_cool_exp_resp)
				.append("rcv_snap_tanf_medicaid_resp=")
				.append(rcv_snap_tanf_medicaid_resp).append("scr_elg_rslt_ma=")
				.append(scr_elg_rslt_ma).append("scr_elg_rslt_cc=")
				.append(scr_elg_rslt_cc).append("scr_elg_rslt_snap=")
				.append(scr_elg_rslt_snap).append("scr_elg_rslt_wic=")
				.append(scr_elg_rslt_wic).append("scr_elg_rslt_tanf=")
				.append(scr_elg_rslt_tanf).append("scr_elg_rslt_liheap=")
				.append(scr_elg_rslt_liheap).append("num_chld_under_13=")
				.append(num_chld_under_13).append("create_user_no=")
				.append(create_user_no).append("create_user_id=")
				.append(create_user_id).toString();

	}

	/**
	 * compares the given cargo with this cargo and returns the changed
	 * attribute-value Map.
	 */
	public Map<String, String> compareAttributes(
			final CP_APP_SCREENER_Cargo aCargo) {
		final Map<String, String> changedAttributeValue = new HashMap<String, String>();

		if (!((aCargo.getApp_screener_num() == null) && (app_screener_num == null))
				&& !((aCargo.getApp_screener_num() != null) && aCargo
						.getApp_screener_num().equals(app_screener_num))) {
			changedAttributeValue.put("app_screener_num",
					aCargo.getApp_screener_num());
		}
		if (!((aCargo.getRes_ga_resp() == null) && (res_ga_resp == null))
				&& !((aCargo.getRes_ga_resp() != null) && aCargo
						.getRes_ga_resp().equals(res_ga_resp))) {
			changedAttributeValue.put("res_ga_resp", aCargo.getRes_ga_resp());
		}
		if (!((aCargo.getCnty_name_cd() == null) && (cnty_name_cd == null))
				&& !((aCargo.getCnty_name_cd() != null) && aCargo
						.getCnty_name_cd().equals(cnty_name_cd))) {
			changedAttributeValue.put("cnty_name_cd", aCargo.getCnty_name_cd());
		}
		if (!((aCargo.getNum_chld_under_19() == null) && (num_chld_under_19 == null))
				&& !((aCargo.getNum_chld_under_19() != null) && aCargo
						.getNum_chld_under_19().equals(num_chld_under_19))) {
			changedAttributeValue.put("num_chld_under_19",
					aCargo.getNum_chld_under_19());
		}
		if (!((aCargo.getNum_adults_age_grp_1() == null) && (num_adults_age_grp_1 == null))
				&& !((aCargo.getNum_adults_age_grp_1() != null) && aCargo
						.getNum_adults_age_grp_1().equals(num_adults_age_grp_1))) {
			changedAttributeValue.put("num_adults_age_grp_1",
					aCargo.getNum_adults_age_grp_1());
		}
		if (!((aCargo.getNum_adults_age_grp_2() == null) && (num_adults_age_grp_2 == null))
				&& !((aCargo.getNum_adults_age_grp_2() != null) && aCargo
						.getNum_adults_age_grp_2().equals(num_adults_age_grp_2))) {
			changedAttributeValue.put("num_adults_age_grp_2",
					aCargo.getNum_adults_age_grp_2());
		}
		if (!((aCargo.getNum_adults_age_grp_3() == null) && (num_adults_age_grp_3 == null))
				&& !((aCargo.getNum_adults_age_grp_3() != null) && aCargo
						.getNum_adults_age_grp_3().equals(num_adults_age_grp_3))) {
			changedAttributeValue.put("num_adults_age_grp_3",
					aCargo.getNum_adults_age_grp_3());
		}
		if (!((aCargo.getPreg_resp() == null) && (preg_resp == null))
				&& !((aCargo.getPreg_resp() != null) && aCargo.getPreg_resp()
						.equals(preg_resp))) {
			changedAttributeValue.put("preg_resp", aCargo.getPreg_resp());
		}
		if (!((aCargo.getBreast_feed_resp() == null) && (breast_feed_resp == null))
				&& !((aCargo.getBreast_feed_resp() != null) && aCargo
						.getBreast_feed_resp().equals(breast_feed_resp))) {
			changedAttributeValue.put("breast_feed_resp",
					aCargo.getBreast_feed_resp());
		}
		if (!((aCargo.getEnd_preg_no_breast_feed_resp() == null) && (end_preg_no_breast_feed_resp == null))
				&& !((aCargo.getEnd_preg_no_breast_feed_resp() != null) && aCargo
						.getEnd_preg_no_breast_feed_resp().equals(
								end_preg_no_breast_feed_resp))) {
			changedAttributeValue.put("end_preg_no_breast_feed_resp",
					aCargo.getEnd_preg_no_breast_feed_resp());
		}
		if (!((aCargo.getMedicare_eligib_resp() == null) && (medicare_eligib_resp == null))
				&& !((aCargo.getMedicare_eligib_resp() != null) && aCargo
						.getMedicare_eligib_resp().equals(medicare_eligib_resp))) {
			changedAttributeValue.put("medicare_eligib_resp",
					aCargo.getMedicare_eligib_resp());
		}
		if (!((aCargo.getGuard_oth_chld_resp() == null) && (guard_oth_chld_resp == null))
				&& !((aCargo.getGuard_oth_chld_resp() != null) && aCargo
						.getGuard_oth_chld_resp().equals(guard_oth_chld_resp))) {
			changedAttributeValue.put("guard_oth_chld_resp",
					aCargo.getGuard_oth_chld_resp());
		}
		if (!((aCargo.getWk_sch_train_act_resp() == null) && (wk_sch_train_act_resp == null))
				&& !((aCargo.getWk_sch_train_act_resp() != null) && aCargo
						.getWk_sch_train_act_resp().equals(
								wk_sch_train_act_resp))) {
			changedAttributeValue.put("wk_sch_train_act_resp",
					aCargo.getWk_sch_train_act_resp());
		}
		if (!((aCargo.getDabl_blnd_and_ssa_resp() == null) && (dabl_blnd_and_ssa_resp == null))
				&& !((aCargo.getDabl_blnd_and_ssa_resp() != null) && aCargo
						.getDabl_blnd_and_ssa_resp().equals(
								dabl_blnd_and_ssa_resp))) {
			changedAttributeValue.put("dabl_blnd_and_ssa_resp",
					aCargo.getDabl_blnd_and_ssa_resp());
		}
		if (!((aCargo.getLive_in_nurs_home_resp() == null) && (live_in_nurs_home_resp == null))
				&& !((aCargo.getLive_in_nurs_home_resp() != null) && aCargo
						.getLive_in_nurs_home_resp().equals(
								live_in_nurs_home_resp))) {
			changedAttributeValue.put("live_in_nurs_home_resp",
					aCargo.getLive_in_nurs_home_resp());
		}
		if (!((aCargo.getChld_hlth_ins_resp() == null) && (chld_hlth_ins_resp == null))
				&& !((aCargo.getChld_hlth_ins_resp() != null) && aCargo
						.getChld_hlth_ins_resp().equals(chld_hlth_ins_resp))) {
			changedAttributeValue.put("chld_hlth_ins_resp",
					aCargo.getChld_hlth_ins_resp());
		}
		if (!((aCargo.getChld_hlth_ins_lst_2mth_resp() == null) && (chld_hlth_ins_lst_2mth_resp == null))
				&& !((aCargo.getChld_hlth_ins_lst_2mth_resp() != null) && aCargo
						.getChld_hlth_ins_lst_2mth_resp().equals(
								chld_hlth_ins_lst_2mth_resp))) {
			changedAttributeValue.put("chld_hlth_ins_lst_2mth_resp",
					aCargo.getChld_hlth_ins_lst_2mth_resp());
		}
		if (!((aCargo.getCaretaker_of_minor_resp() == null) && (caretaker_of_minor_resp == null))
				&& !((aCargo.getCaretaker_of_minor_resp() != null) && aCargo
						.getCaretaker_of_minor_resp().equals(
								caretaker_of_minor_resp))) {
			changedAttributeValue.put("caretaker_of_minor_resp",
					aCargo.getCaretaker_of_minor_resp());
		}
		if (!((aCargo.getCaretaker_60yrs_old_resp() == null) && (caretaker_60yrs_old_resp == null))
				&& !((aCargo.getCaretaker_60yrs_old_resp() != null) && aCargo
						.getCaretaker_60yrs_old_resp().equals(
								caretaker_60yrs_old_resp))) {
			changedAttributeValue.put("caretaker_60yrs_old_resp",
					aCargo.getCaretaker_60yrs_old_resp());
		}
		if (!((aCargo.getCaretaker_student_resp() == null) && (caretaker_student_resp == null))
				&& !((aCargo.getCaretaker_student_resp() != null) && aCargo
						.getCaretaker_student_resp().equals(
								caretaker_student_resp))) {
			changedAttributeValue.put("caretaker_student_resp",
					aCargo.getCaretaker_student_resp());
		}
		if (!((aCargo.getNum_hsld_employed() == null) && (num_hsld_employed == null))
				&& !((aCargo.getNum_hsld_employed() != null) && aCargo
						.getNum_hsld_employed().equals(num_hsld_employed))) {
			changedAttributeValue.put("num_hsld_employed",
					aCargo.getNum_hsld_employed());
		}
		if (!((aCargo.getHsld_bt_earned_income() == null) && (hsld_bt_earned_income == null))
				&& !((aCargo.getHsld_bt_earned_income() != null) && aCargo
						.getHsld_bt_earned_income().equals(
								hsld_bt_earned_income))) {
			changedAttributeValue.put("hsld_bt_earned_income",
					aCargo.getHsld_bt_earned_income());
		}
		if (!((aCargo.getSs_income() == null) && (ss_income == null))
				&& !((aCargo.getSs_income() != null) && aCargo.getSs_income()
						.equals(ss_income))) {
			changedAttributeValue.put("ss_income", aCargo.getSs_income());
		}
		if (!((aCargo.getSsi_income() == null) && (ssi_income == null))
				&& !((aCargo.getSsi_income() != null) && aCargo.getSsi_income()
						.equals(ssi_income))) {
			changedAttributeValue.put("ssi_income", aCargo.getSsi_income());
		}
		if (!((aCargo.getUnemployment_income() == null) && (unemployment_income == null))
				&& !((aCargo.getUnemployment_income() != null) && aCargo
						.getUnemployment_income().equals(unemployment_income))) {
			changedAttributeValue.put("unemployment_income",
					aCargo.getUnemployment_income());
		}
		if (!((aCargo.getCash_gifts_income() == null) && (cash_gifts_income == null))
				&& !((aCargo.getCash_gifts_income() != null) && aCargo
						.getCash_gifts_income().equals(cash_gifts_income))) {
			changedAttributeValue.put("cash_gifts_income",
					aCargo.getCash_gifts_income());
		}
		if (!((aCargo.getAlimony_income() == null) && (alimony_income == null))
				&& !((aCargo.getAlimony_income() != null) && aCargo
						.getAlimony_income().equals(alimony_income))) {
			changedAttributeValue.put("alimony_income",
					aCargo.getAlimony_income());
		}
		if (!((aCargo.getRental_income() == null) && (rental_income == null))
				&& !((aCargo.getRental_income() != null) && aCargo
						.getRental_income().equals(rental_income))) {
			changedAttributeValue.put("rental_income",
					aCargo.getRental_income());
		}
		if (!((aCargo.getOther_income() == null) && (other_income == null))
				&& !((aCargo.getOther_income() != null) && aCargo
						.getOther_income().equals(other_income))) {
			changedAttributeValue.put("other_income", aCargo.getOther_income());
		}
		if (!((aCargo.getCreate_dt() == null) && (create_dt == null))
				&& !((aCargo.getCreate_dt() != null) && aCargo.getCreate_dt()
						.equals(create_dt))) {
			changedAttributeValue.put("create_dt", aCargo.getCreate_dt());
		}
		if (!((aCargo.getDabl_care_chld_lt_5yrs_resp() == null) && (dabl_care_chld_lt_5yrs_resp == null))
				&& !((aCargo.getDabl_care_chld_lt_5yrs_resp() != null) && aCargo
						.getDabl_care_chld_lt_5yrs_resp().equals(
								dabl_care_chld_lt_5yrs_resp))) {
			changedAttributeValue.put("dabl_care_chld_lt_5yrs_resp",
					aCargo.getDabl_care_chld_lt_5yrs_resp());
		}
		if (!((aCargo.getChld_13_18_spcl_need_resp() == null) && (chld_13_18_spcl_need_resp == null))
				&& !((aCargo.getChld_13_18_spcl_need_resp() != null) && aCargo
						.getChld_13_18_spcl_need_resp().equals(
								chld_13_18_spcl_need_resp))) {
			changedAttributeValue.put("chld_13_18_spcl_need_resp",
					aCargo.getChld_13_18_spcl_need_resp());
		}
		if (!((aCargo.getWrk_and_care_chld_resp() == null) && (wrk_and_care_chld_resp == null))
				&& !((aCargo.getWrk_and_care_chld_resp() != null) && aCargo
						.getWrk_and_care_chld_resp().equals(
								wrk_and_care_chld_resp))) {
			changedAttributeValue.put("wrk_and_care_chld_resp",
					aCargo.getWrk_and_care_chld_resp());
		}
		if (!((aCargo.getHshl_pay_heat_cool_exp_resp() == null) && (hshl_pay_heat_cool_exp_resp == null))
				&& !((aCargo.getHshl_pay_heat_cool_exp_resp() != null) && aCargo
						.getHshl_pay_heat_cool_exp_resp().equals(
								hshl_pay_heat_cool_exp_resp))) {
			changedAttributeValue.put("hshl_pay_heat_cool_exp_resp",
					aCargo.getHshl_pay_heat_cool_exp_resp());
		}
		if (!((aCargo.getHshl_rent_mtg_mth_pymt() == null) && (hshl_rent_mtg_mth_pymt == null))
				&& !((aCargo.getHshl_rent_mtg_mth_pymt() != null) && aCargo
						.getHshl_rent_mtg_mth_pymt().equals(
								hshl_rent_mtg_mth_pymt))) {
			changedAttributeValue.put("hshl_rent_mtg_mth_pymt",
					aCargo.getHshl_rent_mtg_mth_pymt());
		}
		if (!((aCargo.getRcv_snap_tanf_medicaid_resp() == null) && (rcv_snap_tanf_medicaid_resp == null))
				&& !((aCargo.getRcv_snap_tanf_medicaid_resp() != null) && aCargo
						.getRcv_snap_tanf_medicaid_resp().equals(
								rcv_snap_tanf_medicaid_resp))) {
			changedAttributeValue.put("rcv_snap_tanf_medicaid_resp",
					aCargo.getRcv_snap_tanf_medicaid_resp());
		}
		if (!((aCargo.getScr_elg_rslt_ma() == null) && (scr_elg_rslt_ma == null))
				&& !((aCargo.getScr_elg_rslt_ma() != null) && aCargo
						.getScr_elg_rslt_ma().equals(scr_elg_rslt_ma))) {
			changedAttributeValue.put("scr_elg_rslt_ma",
					aCargo.getScr_elg_rslt_ma());
		}
		if (!((aCargo.getScr_elg_rslt_cc() == null) && (scr_elg_rslt_cc == null))
				&& !((aCargo.getScr_elg_rslt_cc() != null) && aCargo
						.getScr_elg_rslt_cc().equals(scr_elg_rslt_cc))) {
			changedAttributeValue.put("scr_elg_rslt_cc",
					aCargo.getScr_elg_rslt_cc());
		}
		if (!((aCargo.getScr_elg_rslt_snap() == null) && (scr_elg_rslt_snap == null))
				&& !((aCargo.getScr_elg_rslt_snap() != null) && aCargo
						.getScr_elg_rslt_snap().equals(scr_elg_rslt_snap))) {
			changedAttributeValue.put("scr_elg_rslt_snap",
					aCargo.getScr_elg_rslt_snap());
		}
		if (!((aCargo.getScr_elg_rslt_wic() == null) && (scr_elg_rslt_wic == null))
				&& !((aCargo.getScr_elg_rslt_wic() != null) && aCargo
						.getScr_elg_rslt_wic().equals(scr_elg_rslt_wic))) {
			changedAttributeValue.put("scr_elg_rslt_wic",
					aCargo.getScr_elg_rslt_wic());
		}
		if (!((aCargo.getScr_elg_rslt_tanf() == null) && (scr_elg_rslt_tanf == null))
				&& !((aCargo.getScr_elg_rslt_tanf() != null) && aCargo
						.getScr_elg_rslt_tanf().equals(scr_elg_rslt_tanf))) {
			changedAttributeValue.put("scr_elg_rslt_tanf",
					aCargo.getScr_elg_rslt_tanf());
		}
		if (!((aCargo.getScr_elg_rslt_liheap() == null) && (scr_elg_rslt_liheap == null))
				&& !((aCargo.getScr_elg_rslt_liheap() != null) && aCargo
						.getScr_elg_rslt_liheap().equals(scr_elg_rslt_liheap))) {
			changedAttributeValue.put("scr_elg_rslt_liheap",
					aCargo.getScr_elg_rslt_liheap());
		}
		if (!((aCargo.getNum_chld_under_13() == null) && (num_chld_under_13 == null))
				&& !((aCargo.getScr_elg_rslt_liheap() != null) && aCargo
						.getNum_chld_under_13().equals(num_chld_under_13))) {
			changedAttributeValue.put("num_chld_under_13",
					aCargo.getNum_chld_under_13());
		}
		if (!((aCargo.getCreate_user_no() == null) && (create_user_no == null))
				&& !((aCargo.getCreate_user_no() != null) && aCargo
						.getCreate_user_no().equals(create_user_no))) {
			changedAttributeValue.put("create_user_no",
					aCargo.getCreate_user_no());
		}
		if (!((aCargo.getCreate_user_id() == null) && (create_user_id == null))
				&& !((aCargo.getCreate_user_id() != null) && aCargo
						.getCreate_user_id().equals(create_user_id))) {
			changedAttributeValue.put("create_user_id",
					aCargo.getCreate_user_id());
		}

		return changedAttributeValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result)
				+ ((alimony_income == null) ? 0 : alimony_income.trim()
						.hashCode());
		result = (prime * result)
				+ ((app_screener_num == null) ? 0 : app_screener_num.trim()
						.hashCode());
		result = (prime * result)
				+ ((breast_feed_resp == null) ? 0 : breast_feed_resp.trim()
						.hashCode());
		result = (prime * result)
				+ ((caretaker_60yrs_old_resp == null) ? 0
						: caretaker_60yrs_old_resp.trim().hashCode());
		result = (prime * result)
				+ ((caretaker_of_minor_resp == null) ? 0
						: caretaker_of_minor_resp.trim().hashCode());
		result = (prime * result)
				+ ((caretaker_student_resp == null) ? 0
						: caretaker_student_resp.trim().hashCode());
		result = (prime * result)
				+ ((cash_gifts_income == null) ? 0 : cash_gifts_income.trim()
						.hashCode());
		result = (prime * result)
				+ ((chld_13_18_spcl_need_resp == null) ? 0
						: chld_13_18_spcl_need_resp.trim().hashCode());
		result = (prime * result)
				+ ((chld_hlth_ins_lst_2mth_resp == null) ? 0
						: chld_hlth_ins_lst_2mth_resp.trim().hashCode());
		result = (prime * result)
				+ ((chld_hlth_ins_resp == null) ? 0 : chld_hlth_ins_resp.trim()
						.hashCode());
		result = (prime * result)
				+ ((cnty_name_cd == null) ? 0 : cnty_name_cd.trim().hashCode());
		result = (prime * result)
				+ ((create_dt == null) ? 0 : create_dt.trim().hashCode());
		result = (prime * result)
				+ ((dabl_blnd_and_ssa_resp == null) ? 0
						: dabl_blnd_and_ssa_resp.trim().hashCode());
		result = (prime * result)
				+ ((dabl_care_chld_lt_5yrs_resp == null) ? 0
						: dabl_care_chld_lt_5yrs_resp.trim().hashCode());
		result = (prime * result)
				+ ((end_preg_no_breast_feed_resp == null) ? 0
						: end_preg_no_breast_feed_resp.trim().hashCode());
		result = (prime * result)
				+ ((guard_oth_chld_resp == null) ? 0 : guard_oth_chld_resp
						.trim().hashCode());
		result = (prime * result)
				+ ((hshl_pay_heat_cool_exp_resp == null) ? 0
						: hshl_pay_heat_cool_exp_resp.trim().hashCode());
		result = (prime * result)
				+ ((hshl_rent_mtg_mth_pymt == null) ? 0
						: hshl_rent_mtg_mth_pymt.trim().hashCode());
		result = (prime * result)
				+ ((hsld_bt_earned_income == null) ? 0 : hsld_bt_earned_income
						.trim().hashCode());
		result = (prime * result)
				+ ((live_in_nurs_home_resp == null) ? 0
						: live_in_nurs_home_resp.trim().hashCode());
		result = (prime * result)
				+ ((medicare_eligib_resp == null) ? 0 : medicare_eligib_resp
						.trim().hashCode());
		result = (prime * result)
				+ ((num_adults_age_grp_1 == null) ? 0 : num_adults_age_grp_1
						.trim().hashCode());
		result = (prime * result)
				+ ((num_adults_age_grp_2 == null) ? 0 : num_adults_age_grp_2
						.trim().hashCode());
		result = (prime * result)
				+ ((num_adults_age_grp_3 == null) ? 0 : num_adults_age_grp_3
						.trim().hashCode());
		result = (prime * result)
				+ ((num_chld_under_13 == null) ? 0 : num_chld_under_13.trim()
						.hashCode());
		result = (prime * result)
				+ ((num_chld_under_19 == null) ? 0 : num_chld_under_19.trim()
						.hashCode());
		result = (prime * result)
				+ ((num_hsld_employed == null) ? 0 : num_hsld_employed.trim()
						.hashCode());
		result = (prime * result)
				+ ((other_income == null) ? 0 : other_income.trim().hashCode());
		result = (prime * result)
				+ ((preg_resp == null) ? 0 : preg_resp.trim().hashCode());
		result = (prime * result)
				+ ((rcv_snap_tanf_medicaid_resp == null) ? 0
						: rcv_snap_tanf_medicaid_resp.trim().hashCode());
		result = (prime * result)
				+ ((rental_income == null) ? 0 : rental_income.trim()
						.hashCode());
		result = (prime * result)
				+ ((res_ga_resp == null) ? 0 : res_ga_resp.trim().hashCode());
		result = (prime * result)
				+ ((scr_elg_rslt_cc == null) ? 0 : scr_elg_rslt_cc.trim()
						.hashCode());
		result = (prime * result)
				+ ((scr_elg_rslt_liheap == null) ? 0 : scr_elg_rslt_liheap
						.trim().hashCode());
		result = (prime * result)
				+ ((scr_elg_rslt_ma == null) ? 0 : scr_elg_rslt_ma.trim()
						.hashCode());
		result = (prime * result)
				+ ((scr_elg_rslt_snap == null) ? 0 : scr_elg_rslt_snap.trim()
						.hashCode());
		result = (prime * result)
				+ ((scr_elg_rslt_tanf == null) ? 0 : scr_elg_rslt_tanf.trim()
						.hashCode());
		result = (prime * result)
				+ ((scr_elg_rslt_wic == null) ? 0 : scr_elg_rslt_wic.trim()
						.hashCode());
		result = (prime * result)
				+ ((ss_income == null) ? 0 : ss_income.trim().hashCode());
		result = (prime * result)
				+ ((ssi_income == null) ? 0 : ssi_income.trim().hashCode());
		result = (prime * result)
				+ ((unemployment_income == null) ? 0 : unemployment_income
						.trim().hashCode());
		result = (prime * result)
				+ ((wk_sch_train_act_resp == null) ? 0 : wk_sch_train_act_resp
						.trim().hashCode());
		result = (prime * result)
				+ ((wrk_and_care_chld_resp == null) ? 0
						: wrk_and_care_chld_resp.trim().hashCode());
		result = (prime * result)
				+ ((create_user_no == null) ? 0 : create_user_no.trim()
						.hashCode());
		result = (prime * result)
				+ ((create_user_id == null) ? 0 : create_user_id.trim()
						.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		final CP_APP_SCREENER_Cargo other = (CP_APP_SCREENER_Cargo) obj;
		if (alimony_income == null) {
			if (other.alimony_income != null) {
				return false;
			}
		} else if (!alimony_income.equals(other.alimony_income)) {
			return false;
		}
		if (app_screener_num == null) {
			if (other.app_screener_num != null) {
				return false;
			}
		} else if (!app_screener_num.equals(other.app_screener_num)) {
			return false;
		}
		if (breast_feed_resp == null) {
			if (other.breast_feed_resp != null) {
				return false;
			}
		} else if (!breast_feed_resp.equals(other.breast_feed_resp)) {
			return false;
		}
		if (caretaker_60yrs_old_resp == null) {
			if (other.caretaker_60yrs_old_resp != null) {
				return false;
			}
		} else if (!caretaker_60yrs_old_resp
				.equals(other.caretaker_60yrs_old_resp)) {
			return false;
		}
		if (caretaker_of_minor_resp == null) {
			if (other.caretaker_of_minor_resp != null) {
				return false;
			}
		} else if (!caretaker_of_minor_resp
				.equals(other.caretaker_of_minor_resp)) {
			return false;
		}
		if (caretaker_student_resp == null) {
			if (other.caretaker_student_resp != null) {
				return false;
			}
		} else if (!caretaker_student_resp.equals(other.caretaker_student_resp)) {
			return false;
		}
		if (cash_gifts_income == null) {
			if (other.cash_gifts_income != null) {
				return false;
			}
		} else if (!cash_gifts_income.equals(other.cash_gifts_income)) {
			return false;
		}
		if (chld_13_18_spcl_need_resp == null) {
			if (other.chld_13_18_spcl_need_resp != null) {
				return false;
			}
		} else if (!chld_13_18_spcl_need_resp
				.equals(other.chld_13_18_spcl_need_resp)) {
			return false;
		}
		if (chld_hlth_ins_lst_2mth_resp == null) {
			if (other.chld_hlth_ins_lst_2mth_resp != null) {
				return false;
			}
		} else if (!chld_hlth_ins_lst_2mth_resp
				.equals(other.chld_hlth_ins_lst_2mth_resp)) {
			return false;
		}
		if (chld_hlth_ins_resp == null) {
			if (other.chld_hlth_ins_resp != null) {
				return false;
			}
		} else if (!chld_hlth_ins_resp.equals(other.chld_hlth_ins_resp)) {
			return false;
		}
		if (cnty_name_cd == null) {
			if (other.cnty_name_cd != null) {
				return false;
			}
		} else if (!cnty_name_cd.equals(other.cnty_name_cd)) {
			return false;
		}
		if (create_dt == null) {
			if (other.create_dt != null) {
				return false;
			}
		} else if (!create_dt.equals(other.create_dt)) {
			return false;
		}
		if (dabl_blnd_and_ssa_resp == null) {
			if (other.dabl_blnd_and_ssa_resp != null) {
				return false;
			}
		} else if (!dabl_blnd_and_ssa_resp.equals(other.dabl_blnd_and_ssa_resp)) {
			return false;
		}
		if (dabl_care_chld_lt_5yrs_resp == null) {
			if (other.dabl_care_chld_lt_5yrs_resp != null) {
				return false;
			}
		} else if (!dabl_care_chld_lt_5yrs_resp
				.equals(other.dabl_care_chld_lt_5yrs_resp)) {
			return false;
		}
		if (end_preg_no_breast_feed_resp == null) {
			if (other.end_preg_no_breast_feed_resp != null) {
				return false;
			}
		} else if (!end_preg_no_breast_feed_resp
				.equals(other.end_preg_no_breast_feed_resp)) {
			return false;
		}
		if (guard_oth_chld_resp == null) {
			if (other.guard_oth_chld_resp != null) {
				return false;
			}
		} else if (!guard_oth_chld_resp.equals(other.guard_oth_chld_resp)) {
			return false;
		}
		if (hshl_pay_heat_cool_exp_resp == null) {
			if (other.hshl_pay_heat_cool_exp_resp != null) {
				return false;
			}
		} else if (!hshl_pay_heat_cool_exp_resp
				.equals(other.hshl_pay_heat_cool_exp_resp)) {
			return false;
		}
		if (hshl_rent_mtg_mth_pymt == null) {
			if (other.hshl_rent_mtg_mth_pymt != null) {
				return false;
			}
		} else if (!hshl_rent_mtg_mth_pymt.equals(other.hshl_rent_mtg_mth_pymt)) {
			return false;
		}
		if (hsld_bt_earned_income == null) {
			if (other.hsld_bt_earned_income != null) {
				return false;
			}
		} else if (!hsld_bt_earned_income.equals(other.hsld_bt_earned_income)) {
			return false;
		}
		if (live_in_nurs_home_resp == null) {
			if (other.live_in_nurs_home_resp != null) {
				return false;
			}
		} else if (!live_in_nurs_home_resp.equals(other.live_in_nurs_home_resp)) {
			return false;
		}
		if (medicare_eligib_resp == null) {
			if (other.medicare_eligib_resp != null) {
				return false;
			}
		} else if (!medicare_eligib_resp.equals(other.medicare_eligib_resp)) {
			return false;
		}
		if (num_adults_age_grp_1 == null) {
			if (other.num_adults_age_grp_1 != null) {
				return false;
			}
		} else if (!num_adults_age_grp_1.equals(other.num_adults_age_grp_1)) {
			return false;
		}
		if (num_adults_age_grp_2 == null) {
			if (other.num_adults_age_grp_2 != null) {
				return false;
			}
		} else if (!num_adults_age_grp_2.equals(other.num_adults_age_grp_2)) {
			return false;
		}
		if (num_adults_age_grp_3 == null) {
			if (other.num_adults_age_grp_3 != null) {
				return false;
			}
		} else if (!num_adults_age_grp_3.equals(other.num_adults_age_grp_3)) {
			return false;
		}
		if (num_chld_under_13 == null) {
			if (other.num_chld_under_13 != null) {
				return false;
			}
		} else if (!num_chld_under_13.equals(other.num_chld_under_13)) {
			return false;
		}
		if (num_chld_under_19 == null) {
			if (other.num_chld_under_19 != null) {
				return false;
			}
		} else if (!num_chld_under_19.equals(other.num_chld_under_19)) {
			return false;
		}
		if (num_hsld_employed == null) {
			if (other.num_hsld_employed != null) {
				return false;
			}
		} else if (!num_hsld_employed.equals(other.num_hsld_employed)) {
			return false;
		}
		if (other_income == null) {
			if (other.other_income != null) {
				return false;
			}
		} else if (!other_income.equals(other.other_income)) {
			return false;
		}
		if (preg_resp == null) {
			if (other.preg_resp != null) {
				return false;
			}
		} else if (!preg_resp.equals(other.preg_resp)) {
			return false;
		}
		if (rcv_snap_tanf_medicaid_resp == null) {
			if (other.rcv_snap_tanf_medicaid_resp != null) {
				return false;
			}
		} else if (!rcv_snap_tanf_medicaid_resp
				.equals(other.rcv_snap_tanf_medicaid_resp)) {
			return false;
		}
		if (rental_income == null) {
			if (other.rental_income != null) {
				return false;
			}
		} else if (!rental_income.equals(other.rental_income)) {
			return false;
		}
		if (res_ga_resp == null) {
			if (other.res_ga_resp != null) {
				return false;
			}
		} else if (!res_ga_resp.equals(other.res_ga_resp)) {
			return false;
		}
		if (scr_elg_rslt_cc == null) {
			if (other.scr_elg_rslt_cc != null) {
				return false;
			}
		} else if (!scr_elg_rslt_cc.equals(other.scr_elg_rslt_cc)) {
			return false;
		}
		if (scr_elg_rslt_liheap == null) {
			if (other.scr_elg_rslt_liheap != null) {
				return false;
			}
		} else if (!scr_elg_rslt_liheap.equals(other.scr_elg_rslt_liheap)) {
			return false;
		}
		if (scr_elg_rslt_ma == null) {
			if (other.scr_elg_rslt_ma != null) {
				return false;
			}
		} else if (!scr_elg_rslt_ma.equals(other.scr_elg_rslt_ma)) {
			return false;
		}
		if (scr_elg_rslt_snap == null) {
			if (other.scr_elg_rslt_snap != null) {
				return false;
			}
		} else if (!scr_elg_rslt_snap.equals(other.scr_elg_rslt_snap)) {
			return false;
		}
		if (scr_elg_rslt_tanf == null) {
			if (other.scr_elg_rslt_tanf != null) {
				return false;
			}
		} else if (!scr_elg_rslt_tanf.equals(other.scr_elg_rslt_tanf)) {
			return false;
		}
		if (scr_elg_rslt_wic == null) {
			if (other.scr_elg_rslt_wic != null) {
				return false;
			}
		} else if (!scr_elg_rslt_wic.equals(other.scr_elg_rslt_wic)) {
			return false;
		}
		if (ss_income == null) {
			if (other.ss_income != null) {
				return false;
			}
		} else if (!ss_income.equals(other.ss_income)) {
			return false;
		}
		if (ssi_income == null) {
			if (other.ssi_income != null) {
				return false;
			}
		} else if (!ssi_income.equals(other.ssi_income)) {
			return false;
		}
		if (unemployment_income == null) {
			if (other.unemployment_income != null) {
				return false;
			}
		} else if (!unemployment_income.equals(other.unemployment_income)) {
			return false;
		}
		if (wk_sch_train_act_resp == null) {
			if (other.wk_sch_train_act_resp != null) {
				return false;
			}
		} else if (!wk_sch_train_act_resp.equals(other.wk_sch_train_act_resp)) {
			return false;
		}
		if (wrk_and_care_chld_resp == null) {
			if (other.wrk_and_care_chld_resp != null) {
				return false;
			}
		} else if (!wrk_and_care_chld_resp.equals(other.wrk_and_care_chld_resp)) {
			return false;
		}
		if (create_user_no == null) {
			if (other.create_user_no != null) {
				return false;
			}
		} else if (!create_user_no.equals(other.create_user_no)) {
			return false;
		}
		if (create_user_id == null) {
			if (other.create_user_id != null) {
				return false;
			}
		} else if (!create_user_id.equals(other.create_user_id)) {
			return false;
		}
		return true;
	}

}
