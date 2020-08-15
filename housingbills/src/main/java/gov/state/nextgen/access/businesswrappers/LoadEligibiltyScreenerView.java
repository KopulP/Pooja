package gov.state.nextgen.access.businesswrappers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import gov.state.nextgen.access.business.entities.CP_APP_SCREENER_Cargo;
import gov.state.nextgen.access.business.entities.CP_APP_SCREENER_Collection;
import gov.state.nextgen.access.business.entities.FwTransaction;
import gov.state.nextgen.access.factory.CommonResponseBean;
import gov.state.nextgen.access.management.constants.FwConstants;
import gov.state.nextgen.access.model.AmIEligibleResults;
import gov.state.nextgen.access.model.DriverPageResponse;
import gov.state.nextgen.access.model.PageResponse;


@Component("ACAIE")
@Scope("prototype")
public class LoadEligibiltyScreenerView extends CommonResponseBean {

	private static final String PAGE_ID = "ACAIE";

	@Override
	public PageResponse constructPageResponse(FwTransaction txBean)

	{
		DriverPageResponse driverPageResponse = new DriverPageResponse();

		Map<Object, Object> beforeCollection = new HashMap<Object, Object>();
		Map pageCollection = txBean.getPageCollection();
		List<CP_APP_SCREENER_Cargo> aieQuesList = new ArrayList<CP_APP_SCREENER_Cargo>();
		CP_APP_SCREENER_Cargo cargo = new CP_APP_SCREENER_Cargo();
		
		CP_APP_SCREENER_Collection cpAppScreenerCollection = pageCollection.get("CP_APP_SCREENER_Collection") != null ? (CP_APP_SCREENER_Collection)pageCollection.get("CP_APP_SCREENER_Collection") : null;

		if(cpAppScreenerCollection != null) {
			cargo = (CP_APP_SCREENER_Cargo) cpAppScreenerCollection.get(0);
		}
		aieQuesList.add(cargo);
		driverPageResponse.getPageCollection().put("CP_APP_SCREENER_Collection", aieQuesList);

	/*	
		if(cpAppScreenerCollection != null) {
			CP_APP_SCREENER_Cargo cargo = (CP_APP_SCREENER_Cargo) cpAppScreenerCollection.get(0);
			
			aieQues.setIsResidentOfState(cargo.getRes_ga_resp());
			aieQues.setWhatCounty(cargo.getCnty_name_cd());
			aieQues.setHowManyUnder13(cargo.getNum_chld_under_13());
			aieQues.setHowManyUnder19(cargo.getNum_chld_under_19());
			aieQues.setAgeGroup19Thru59(cargo.getNum_adults_age_grp_1());
			aieQues.setAgeGroup60Thru64(cargo.getNum_adults_age_grp_2());
			aieQues.setAgeGroup65OrOlder(cargo.getNum_adults_age_grp_3());
			aieQues.setIsPregnant(cargo.getPreg_resp());
			aieQues.setIsBreastFeeding(cargo.getBreast_feed_resp());
			aieQues.setHasEndedBreastFeeding(cargo.getEnd_preg_no_breast_feed_resp());
			aieQues.setIsEnrolledInMedicare(cargo.getMedicare_eligib_resp());
			aieQues.setReceiveSnapTanfMedicaid(cargo.getRcv_snap_tanf_medicaid_resp());
			aieQues.setGuardianOfChildren(cargo.getGuard_oth_chld_resp());
			aieQues.setIsInAnyActivityWST(cargo.getWk_sch_train_act_resp());
			aieQues.setIsDisabled(cargo.getDabl_blnd_and_ssa_resp());
			aieQues.setIsInNursingHome(cargo.getLive_in_nurs_home_resp());
			aieQues.setIsChildInHIS(cargo.getChld_hlth_ins_resp());
			aieQues.setIsChildInHISIn2Mon(cargo.getChld_hlth_ins_lst_2mth_resp());
			aieQues.setIsChildI1318SpclNeed(cargo.getChld_13_18_spcl_need_resp());
			aieQues.setIsDisableChildCare5yrs(cargo.getDabl_care_chld_lt_5yrs_resp());
			aieQues.setIsWorkingChildCare(cargo.getWrk_and_care_chld_resp());
			aieQues.setIsCareTaker(cargo.getCaretaker_of_minor_resp());
			aieQues.setIsGrandparentCaretaker(cargo.getCaretaker_60yrs_old_resp());
			aieQues.setIsStudentCaretaker(cargo.getCaretaker_student_resp());
			aieQues.setHowManyEmployed(cargo.getNum_hsld_employed());
			aieQues.setHowMuchIncomeBT(cargo.getHsld_bt_earned_income());
			aieQues.setSsnIncomeAmount(cargo.getSs_income());
			aieQues.setSsiIncomeAmount(cargo.getSsi_income());
			aieQues.setUnemploymentPayment(cargo.getUnemployment_income());
			aieQues.setCashGitsIncomeAmount(cargo.getCash_gifts_income());
			aieQues.setAlimonyIncomeAmount(cargo.getAlimony_income());
			aieQues.setRentalIncomeAmount(cargo.getRental_income());
			aieQues.setOtherIncome(cargo.getOther_income());
			aieQues.setRentMortgageMonthlyPayment(cargo.getHshl_rent_mtg_mth_pymt());
			aieQues.setHeatingCoolingExpense(cargo.getHshl_pay_heat_cool_exp_resp());
		}
		
		aieQuesList.add(aieQues);
		driverPageResponse.getPageMap().put("AmIEligibleQuestions", aieQuesList);
*/
		driverPageResponse.setCurrentPageID(PAGE_ID);
		driverPageResponse.setNextPageAction(String.valueOf(txBean.getRequest().get(FwConstants.NEXT_PAGE_ACTION)));
		driverPageResponse.setNextPageID(String.valueOf(txBean.getRequest().get(FwConstants.NEXT_PAGE_ID)));
		driverPageResponse.setPageDriver((int[]) txBean.getSession().get(FwConstants.AFB_DRIVER));
		driverPageResponse.setAppNum(String.valueOf(txBean.getSession().get(FwConstants.APP_NUMBER)));
		driverPageResponse.setPreviousPageID(String.valueOf(txBean.getRequest().get(FwConstants.PREVIOUS_PAGE_ID)));
		
		beforeCollection.put("CP_APP_SCREENER_Collection", pageCollection.get("CP_APP_SCREENER_Collection"));

		driverPageResponse.setBeforeCollection(beforeCollection);

		return driverPageResponse;
	}

}
