package gov.state.nextgen.access.business.services;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import gov.state.nextgen.access.business.entities.CP_APP_SCREENER_Cargo;
import gov.state.nextgen.access.business.entities.CP_APP_SCREENER_Collection;
import gov.state.nextgen.access.business.entities.FwTransaction;
import gov.state.nextgen.access.business.factory.EligibiltyScreenerInterface;
import gov.state.nextgen.access.business.rules.EligibilityScreenerBO;
import gov.state.nextgen.access.exceptions.EligibilityScreenerException;
import gov.state.nextgen.access.exceptions.FwException;
import gov.state.nextgen.access.exceptions.FwExceptionManager;
import gov.state.nextgen.access.management.constants.FwConstants;
import gov.state.nextgen.access.management.messages.FwMessageList;

/**
 * Session Bean implementation class EligibiltyScreenerEJBBean
 */
@Service("EligibiltyScreenerEJBBean")
public class EligibiltyScreenerEJBBean implements EligibiltyScreenerInterface{

	@Autowired
	private EligibilityScreenerBO eligibiltyScreenerBO;

	/**
	 * Default constructor.
	 */
	public EligibiltyScreenerEJBBean() {
	}


	@SuppressWarnings("rawtypes")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveEligibiltyQuestions(FwTransaction txnBean) throws EligibilityScreenerException {

		FwMessageList validationInfo = null;
		CP_APP_SCREENER_Collection app_screener_coll = null;
		CP_APP_SCREENER_Cargo app_screener_cargo = null;

		Map pageCollection = txnBean.getPageCollection();
		Map request = txnBean.getRequest();
		Map session = txnBean.getSession();
		Map dataMap = new HashMap();

		double totalIncome = 0.00;
		int totalNoOfPeopleInHousehold = 0;

		String userId = null;
		String userNum = null;

		try {
			final CP_APP_SCREENER_Collection tmp_screener_coll = new CP_APP_SCREENER_Collection();
			// Getting the collection from the page collection

			app_screener_coll = (CP_APP_SCREENER_Collection) pageCollection
					.get("CP_APP_SCREENER_Collection"); 
			app_screener_cargo =
					(CP_APP_SCREENER_Cargo) app_screener_coll .get(0);

			// Validating the values
			validationInfo = eligibiltyScreenerBO.validateAPPSCREENER(
					app_screener_coll, app_screener_cargo);

			// If there is any error messages then send back to same page
			if (validationInfo != null) {
				if (validationInfo.hasMessages()) {
					request.put(FwConstants.MESSAGE_LIST, validationInfo);
					txnBean.setRequest(request);
					return;
				}
			}
			// Checking for null values
			app_screener_cargo
			.setNum_chld_under_13((!("").equals(app_screener_cargo.getNum_chld_under_13())
					&& !(app_screener_cargo.getNum_chld_under_13()).isEmpty() && app_screener_cargo.getNum_chld_under_13() != null) ? app_screener_cargo
							.getNum_chld_under_13() : "");
			app_screener_cargo
			.setNum_chld_under_19((!("").equals(app_screener_cargo.getNum_chld_under_19())
					&& !(app_screener_cargo.getNum_chld_under_19()).isEmpty() && app_screener_cargo.getNum_chld_under_19() != null) ? app_screener_cargo
							.getNum_chld_under_19() : "");
			app_screener_cargo
			.setNum_adults_age_grp_1((!("").equals(app_screener_cargo.getNum_adults_age_grp_1())
					&& !(app_screener_cargo.getNum_adults_age_grp_1()).isEmpty() && app_screener_cargo.getNum_adults_age_grp_1() != null) ? app_screener_cargo
							.getNum_adults_age_grp_1() : "");
			app_screener_cargo
			.setNum_adults_age_grp_2((!("").equals(app_screener_cargo.getNum_adults_age_grp_2())
					&& !(app_screener_cargo.getNum_adults_age_grp_2()).isEmpty() && app_screener_cargo.getNum_adults_age_grp_2() != null) ? app_screener_cargo
							.getNum_adults_age_grp_2() : "");
			app_screener_cargo
			.setNum_adults_age_grp_3((!("").equals(app_screener_cargo.getNum_adults_age_grp_3())
					&& !(app_screener_cargo.getNum_adults_age_grp_3()).isEmpty() && app_screener_cargo.getNum_adults_age_grp_3() != null) ? app_screener_cargo
							.getNum_adults_age_grp_3() : "");

			app_screener_cargo.setPreg_resp(app_screener_cargo.getPreg_resp() != null ? app_screener_cargo.getPreg_resp() : "N");
			app_screener_cargo.setBreast_feed_resp(app_screener_cargo.getBreast_feed_resp() != null ? app_screener_cargo.getBreast_feed_resp() : "N");
			app_screener_cargo.setEnd_preg_no_breast_feed_resp(app_screener_cargo.getEnd_preg_no_breast_feed_resp() != null ? app_screener_cargo
					.getEnd_preg_no_breast_feed_resp() : "N");
			app_screener_cargo.setMedicare_eligib_resp(app_screener_cargo.getMedicare_eligib_resp() != null ? app_screener_cargo
					.getMedicare_eligib_resp() : "N");
			app_screener_cargo.setGuard_oth_chld_resp(app_screener_cargo.getGuard_oth_chld_resp() != null ? app_screener_cargo
					.getGuard_oth_chld_resp() : "N");
			app_screener_cargo.setWk_sch_train_act_resp(app_screener_cargo.getWk_sch_train_act_resp() != null ? app_screener_cargo
					.getWk_sch_train_act_resp() : "N");

			app_screener_cargo.setDabl_blnd_and_ssa_resp(app_screener_cargo.getDabl_blnd_and_ssa_resp() != null ? app_screener_cargo
					.getDabl_blnd_and_ssa_resp() : "N");
			app_screener_cargo.setLive_in_nurs_home_resp(app_screener_cargo.getLive_in_nurs_home_resp() != null ? app_screener_cargo
					.getLive_in_nurs_home_resp() : "N");
			app_screener_cargo.setChld_hlth_ins_resp(app_screener_cargo.getChld_hlth_ins_resp() != null ? app_screener_cargo.getChld_hlth_ins_resp()
					: "N");
			app_screener_cargo.setChld_hlth_ins_lst_2mth_resp(app_screener_cargo.getChld_hlth_ins_lst_2mth_resp() != null ? app_screener_cargo
					.getChld_hlth_ins_lst_2mth_resp() : "N");
			app_screener_cargo.setCaretaker_of_minor_resp(app_screener_cargo.getCaretaker_of_minor_resp() != null ? app_screener_cargo
					.getCaretaker_of_minor_resp() : "N");
			app_screener_cargo.setCaretaker_60yrs_old_resp(app_screener_cargo.getCaretaker_60yrs_old_resp() != null ? app_screener_cargo
					.getCaretaker_60yrs_old_resp() : "N");

			app_screener_cargo
			.setNum_hsld_employed((!(("").equals(app_screener_cargo.getNum_hsld_employed()) || null == app_screener_cargo.getNum_hsld_employed())
					&& !(app_screener_cargo.getNum_hsld_employed()).isEmpty() ) ? app_screener_cargo
							.getNum_hsld_employed() : "");
			app_screener_cargo.setHsld_bt_earned_income((!(("").equals(app_screener_cargo.getHsld_bt_earned_income()) || null == app_screener_cargo.getHsld_bt_earned_income())
					&& !(app_screener_cargo.getHsld_bt_earned_income()).isEmpty()) ? app_screener_cargo.getHsld_bt_earned_income() : "");
			app_screener_cargo
			.setSs_income((!(("").equals(app_screener_cargo.getSs_income()) || null == app_screener_cargo.getSs_income()) && !(app_screener_cargo.getSs_income()).isEmpty()) ? app_screener_cargo.getSs_income() : "");
			app_screener_cargo
			.setSsi_income((!(("").equals(app_screener_cargo.getSsi_income()) || null == app_screener_cargo.getSsi_income()) && !(app_screener_cargo.getSsi_income()).isEmpty()) ? app_screener_cargo.getSsi_income() : "");
			app_screener_cargo
			.setUnemployment_income((!(("").equals(app_screener_cargo.getUnemployment_income()) || null == app_screener_cargo.getUnemployment_income())
					&& !(app_screener_cargo.getUnemployment_income()).isEmpty() ) ? app_screener_cargo
							.getUnemployment_income() : "");
			app_screener_cargo
			.setCash_gifts_income((!(("").equals(app_screener_cargo.getCash_gifts_income()) || null == app_screener_cargo.getCash_gifts_income() )
					&& !(app_screener_cargo.getCash_gifts_income()).isEmpty() ) ? app_screener_cargo
							.getCash_gifts_income() : "");
			app_screener_cargo.setAlimony_income((!(("").equals(app_screener_cargo.getAlimony_income()) || null == app_screener_cargo.getAlimony_income())
					&& !(app_screener_cargo.getAlimony_income()).isEmpty() ) ? app_screener_cargo
							.getAlimony_income() : "");
			app_screener_cargo.setRental_income((!(("").equals(app_screener_cargo.getRental_income()) || null == app_screener_cargo.getRental_income())
					&& !(app_screener_cargo.getRental_income()).isEmpty() ) ? app_screener_cargo
							.getRental_income() : "");
			app_screener_cargo.setOther_income((!(("").equals(app_screener_cargo.getOther_income()) || null == app_screener_cargo.getOther_income())
					&& !(app_screener_cargo.getOther_income()).isEmpty() ) ? app_screener_cargo
							.getOther_income() : "");

			app_screener_cargo.setDabl_care_chld_lt_5yrs_resp(app_screener_cargo.getDabl_care_chld_lt_5yrs_resp() != null ? app_screener_cargo
					.getDabl_care_chld_lt_5yrs_resp() : "N");
			app_screener_cargo.setChld_13_18_spcl_need_resp(app_screener_cargo.getChld_13_18_spcl_need_resp() != null ? app_screener_cargo
					.getChld_13_18_spcl_need_resp() : "N");
			app_screener_cargo
			.setHshl_rent_mtg_mth_pymt(!("").equals(app_screener_cargo.getHshl_rent_mtg_mth_pymt())
					&& !(app_screener_cargo.getHshl_rent_mtg_mth_pymt() != null && app_screener_cargo.getHshl_rent_mtg_mth_pymt().isEmpty()) ? app_screener_cargo
							.getHshl_rent_mtg_mth_pymt() : "");
			app_screener_cargo.setHshl_pay_heat_cool_exp_resp(app_screener_cargo.getHshl_pay_heat_cool_exp_resp() != null ? app_screener_cargo
					.getHshl_pay_heat_cool_exp_resp() : "N");
			app_screener_cargo.setWrk_and_care_chld_resp(app_screener_cargo.getWrk_and_care_chld_resp() != null ? app_screener_cargo
					.getWrk_and_care_chld_resp() : "N");
			app_screener_cargo.setCaretaker_student_resp(app_screener_cargo.getCaretaker_student_resp() != null ? app_screener_cargo
					.getCaretaker_student_resp() : "N");
			app_screener_cargo.setRcv_snap_tanf_medicaid_resp(app_screener_cargo.getRcv_snap_tanf_medicaid_resp() != null ? app_screener_cargo
					.getRcv_snap_tanf_medicaid_resp() : "N");
			app_screener_cargo.setScr_elg_rslt_ma(app_screener_cargo.getScr_elg_rslt_ma() != null ? app_screener_cargo.getScr_elg_rslt_ma() : "");
			app_screener_cargo.setScr_elg_rslt_cc(app_screener_cargo.getScr_elg_rslt_cc() != null ? app_screener_cargo.getScr_elg_rslt_cc() : "");
			app_screener_cargo.setScr_elg_rslt_snap(app_screener_cargo.getScr_elg_rslt_snap() != null ? app_screener_cargo.getScr_elg_rslt_snap()
					: "");
			app_screener_cargo.setScr_elg_rslt_wic(app_screener_cargo.getScr_elg_rslt_wic() != null ? app_screener_cargo.getScr_elg_rslt_wic() : "");
			app_screener_cargo.setScr_elg_rslt_tanf(app_screener_cargo.getScr_elg_rslt_tanf() != null ? app_screener_cargo.getScr_elg_rslt_tanf()
					: "");
			app_screener_cargo.setScr_elg_rslt_liheap(app_screener_cargo.getScr_elg_rslt_liheap() != null ? app_screener_cargo
					.getScr_elg_rslt_liheap() : "");
			if (userId != null) {
				app_screener_cargo.setCreate_user_id(userId);
			}
			if (userNum != null) {
				app_screener_cargo.setCreate_user_no(userNum);
			}
			// Set the new cargo in collection
			app_screener_coll.set(0, app_screener_cargo);


			// Calculate total no of people in household
			// Total no of people in household
			if (!("").equals(app_screener_cargo.getNum_chld_under_13())
					&& app_screener_cargo.getNum_chld_under_13().toString()
					.matches(".*[0-9].*"))
				totalNoOfPeopleInHousehold = totalNoOfPeopleInHousehold
				+ Integer.parseInt(app_screener_cargo
						.getNum_chld_under_13());

			if (!("").equals(app_screener_cargo.getNum_chld_under_19())
					&& app_screener_cargo.getNum_chld_under_19().toString()
					.matches(".*[0-9].*"))
				totalNoOfPeopleInHousehold = totalNoOfPeopleInHousehold
				+ Integer.parseInt(app_screener_cargo
						.getNum_chld_under_19());

			if (!("").equals(app_screener_cargo.getNum_adults_age_grp_1())
					&& app_screener_cargo.getNum_adults_age_grp_1().toString()
					.matches(".*[0-9].*"))
				totalNoOfPeopleInHousehold = totalNoOfPeopleInHousehold
				+ Integer.parseInt(app_screener_cargo
						.getNum_adults_age_grp_1());

			if (!("").equals(app_screener_cargo.getNum_adults_age_grp_2())
					&& app_screener_cargo.getNum_adults_age_grp_2().toString()
					.matches(".*[0-9].*"))
				totalNoOfPeopleInHousehold = totalNoOfPeopleInHousehold
				+ Integer.parseInt(app_screener_cargo
						.getNum_adults_age_grp_2());

			if (!("").equals(app_screener_cargo.getNum_adults_age_grp_3())
					&& app_screener_cargo.getNum_adults_age_grp_3().toString()
					.matches(".*[0-9].*"))
				totalNoOfPeopleInHousehold = totalNoOfPeopleInHousehold
				+ Integer.parseInt(app_screener_cargo
						.getNum_adults_age_grp_3());

			boolean incEnteredInd = false;

			// Calculate the total income
			if (!("").equals(app_screener_cargo.getHsld_bt_earned_income())
					&& app_screener_cargo.getHsld_bt_earned_income().toString()
					.matches(".*[0-9].*")) {
				totalIncome = totalIncome
						+ Double.parseDouble(app_screener_cargo
								.getHsld_bt_earned_income());
				incEnteredInd = true;
			}
			if (!("").equals(app_screener_cargo.getSs_income())
					&& app_screener_cargo.getSs_income().toString()
					.matches(".*[0-9].*")) {
				totalIncome = totalIncome
						+ Double.parseDouble(app_screener_cargo.getSs_income());
				incEnteredInd = true;
			}
			if (!("").equals(app_screener_cargo.getSsi_income())
					&& app_screener_cargo.getSsi_income().toString()
					.matches(".*[0-9].*")) {
				totalIncome = totalIncome
						+ Double.parseDouble(app_screener_cargo.getSsi_income());
				incEnteredInd = true;
			}
			if (!("").equals(app_screener_cargo.getUnemployment_income())
					&& app_screener_cargo.getUnemployment_income().toString()
					.matches(".*[0-9].*")) {
				totalIncome = totalIncome
						+ Double.parseDouble(app_screener_cargo
								.getUnemployment_income());
				incEnteredInd = true;
			}
			if (!("").equals(app_screener_cargo.getCash_gifts_income())
					&& app_screener_cargo.getCash_gifts_income().toString()
					.matches(".*[0-9].*")) {
				totalIncome = totalIncome
						+ Double.parseDouble(app_screener_cargo
								.getCash_gifts_income());
			}
			if (!("").equals(app_screener_cargo.getAlimony_income())
					&& app_screener_cargo.getAlimony_income().toString()
					.matches(".*[0-9].*")) {
				totalIncome = totalIncome
						+ Double.parseDouble(app_screener_cargo
								.getAlimony_income());
				incEnteredInd = true;
			}
			if (!("").equals(app_screener_cargo.getRental_income())
					&& app_screener_cargo.getRental_income().toString()
					.matches(".*[0-9].*")) {
				totalIncome = totalIncome
						+ Double.parseDouble(app_screener_cargo
								.getRental_income());
				incEnteredInd = true;
			}
			if (!("").equals(app_screener_cargo.getOther_income())
					&& app_screener_cargo.getOther_income().toString()
					.matches(".*[0-9].*")) {
				totalIncome = totalIncome
						+ Double.parseDouble(app_screener_cargo
								.getOther_income());
				incEnteredInd = true;
			}


			app_screener_cargo = buildRules(app_screener_coll, totalIncome,
					totalNoOfPeopleInHousehold, incEnteredInd);


			dataMap.put("CP_APP_SCREENER_Collection", app_screener_coll);
			session.put("EligibilityResults", dataMap);
			eligibiltyScreenerBO.saveScreenerDetails(app_screener_coll);

			txnBean.setPageCollection(dataMap);
			session.put(FwConstants.BEFORE_COLLECTION, dataMap);

			txnBean.setSession(session);

		} catch (FwException fe) {
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("getServiceClass");
			fe.setExceptionText(String.valueOf(fe));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(fe));
			throw fe;
		} catch (Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("getServiceClass");
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			throw new EligibilityScreenerException(this.getClass(), "saveEligibiltyQuestions", e);
		}
	}

	/**
	 * This method is used to calculate the result based on the user inputs
	 **/
	public CP_APP_SCREENER_Cargo buildRules(
			CP_APP_SCREENER_Collection app_screener_coll, Double totalIncome,
			int totalNoOfPeopleInHousehold, boolean incEnteredind) {

		boolean medical = false;
		boolean childcare = false;
		boolean snap = false;
		boolean wic = false;
		boolean tanf = false;
		boolean liheap = false;

		//EligibilityScreenerBO eligibiltyScreenerBO = new EligibilityScreenerBO();

		medical = eligibiltyScreenerBO.getScreenerEligibiltyMedAsst(
				app_screener_coll, medical);
		childcare = eligibiltyScreenerBO.getScreenerEligibiltyChildCare(
				app_screener_coll, childcare, totalIncome,
				totalNoOfPeopleInHousehold);
		snap = eligibiltyScreenerBO.getScreenerEligibiltySnap(
				app_screener_coll, snap, totalIncome,
				totalNoOfPeopleInHousehold);
		wic = eligibiltyScreenerBO.getScreenerEligibiltyWic(app_screener_coll,
				wic, totalIncome, totalNoOfPeopleInHousehold);
		if (incEnteredind) {
			tanf = eligibiltyScreenerBO.getScreenerEligibiltyTanf(
					app_screener_coll, tanf, totalIncome,
					totalNoOfPeopleInHousehold);
		}

		CP_APP_SCREENER_Cargo app_screener_cargo = (CP_APP_SCREENER_Cargo) app_screener_coll
				.get(0);

		if (medical) {
			app_screener_cargo.setScr_elg_rslt_ma(FwConstants.YES);
		} else {
			app_screener_cargo.setScr_elg_rslt_ma(FwConstants.NO);
		}

		if (childcare) {
			app_screener_cargo.setScr_elg_rslt_cc(FwConstants.YES);
		} else {
			app_screener_cargo.setScr_elg_rslt_cc(FwConstants.NO);
		}

		if (snap) {
			app_screener_cargo.setScr_elg_rslt_snap(FwConstants.YES);
		} else {
			app_screener_cargo.setScr_elg_rslt_snap(FwConstants.NO);
		}

		if (wic) {
			app_screener_cargo.setScr_elg_rslt_wic(FwConstants.YES);
		} else {
			app_screener_cargo.setScr_elg_rslt_wic(FwConstants.NO);
		}

		if (tanf) {
			app_screener_cargo.setScr_elg_rslt_tanf(FwConstants.YES);
		} else {
			app_screener_cargo.setScr_elg_rslt_tanf(FwConstants.NO);
		}
		return app_screener_cargo;
	}

}