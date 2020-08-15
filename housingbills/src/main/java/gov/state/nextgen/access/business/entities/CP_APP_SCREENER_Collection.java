package gov.state.nextgen.access.business.entities;


import gov.state.nextgen.access.business.entities.AbstractCollection;

/**
 * This class acts as a wrapper for one or many cargos of CP_APP_SCREENER
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date Sep 18 15:00:00 EDT 2014 Modified By: Modified on: PCR#
 */

public class CP_APP_SCREENER_Collection extends AbstractCollection {

	private static final long serialVersionUID = -3332968231214817417L;
	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.CP_APP_SCREENER";

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
	public void addCargo(final CP_APP_SCREENER_Cargo aNewCargo) {
		add(aNewCargo);
	}

	/**
	 * Sets cargo array into collection.
	 */
	public void setResults(final CP_APP_SCREENER_Cargo[] cbArray) {
		clear();
		for (int i = 0; i < cbArray.length; i++) {
			add(cbArray[i]);
		}
	}

	/**
	 * Sets cargo into collection at the given index.
	 */
	public void setCargo(final int idx, final CP_APP_SCREENER_Cargo aCargo) {
		set(idx, aCargo);
	}

	/**
	 * returns all the values in the Collection as Cargo Array.
	 */
	public CP_APP_SCREENER_Cargo[] getResults() {
		final CP_APP_SCREENER_Cargo[] cbArray = new CP_APP_SCREENER_Cargo[size()];
		toArray(cbArray);
		return cbArray;
	}

	/**
	 * returns a cargo from the Collection for the given index.
	 */
	public CP_APP_SCREENER_Cargo getCargo(final int idx) {
		return (CP_APP_SCREENER_Cargo) get(idx);
	}

	/**
	 * This one for clone Results.
	 */
	public CP_APP_SCREENER_Cargo[] cloneResults() {
		final CP_APP_SCREENER_Cargo[] rescargo = new CP_APP_SCREENER_Cargo[size()];
		for (int i = 0; i < size(); i++) {
			final CP_APP_SCREENER_Cargo cargo = getCargo(i);
			rescargo[i] = new CP_APP_SCREENER_Cargo();

			rescargo[i].setApp_screener_num(cargo.getApp_screener_num());
			rescargo[i].setRes_ga_resp(cargo.getRes_ga_resp());
			rescargo[i].setCnty_name_cd(cargo.getCnty_name_cd());
			rescargo[i].setNum_chld_under_13(cargo.getNum_chld_under_13());
			rescargo[i].setNum_chld_under_19(cargo.getNum_chld_under_19());
			rescargo[i]
					.setNum_adults_age_grp_1(cargo.getNum_adults_age_grp_1());
			rescargo[i]
					.setNum_adults_age_grp_2(cargo.getNum_adults_age_grp_2());
			rescargo[i]
					.setNum_adults_age_grp_3(cargo.getNum_adults_age_grp_3());
			rescargo[i].setPreg_resp(cargo.getPreg_resp());
			rescargo[i].setBreast_feed_resp(cargo.getBreast_feed_resp());
			rescargo[i].setEnd_preg_no_breast_feed_resp(cargo
					.getEnd_preg_no_breast_feed_resp());
			rescargo[i]
					.setMedicare_eligib_resp(cargo.getMedicare_eligib_resp());
			rescargo[i].setGuard_oth_chld_resp(cargo.getGuard_oth_chld_resp());
			rescargo[i].setWk_sch_train_act_resp(cargo
					.getWk_sch_train_act_resp());
			rescargo[i].setDabl_blnd_and_ssa_resp(cargo
					.getDabl_blnd_and_ssa_resp());
			rescargo[i].setLive_in_nurs_home_resp(cargo
					.getLive_in_nurs_home_resp());
			rescargo[i].setChld_hlth_ins_resp(cargo.getChld_hlth_ins_resp());
			rescargo[i].setChld_hlth_ins_lst_2mth_resp(cargo
					.getChld_hlth_ins_lst_2mth_resp());
			rescargo[i].setCaretaker_of_minor_resp(cargo
					.getCaretaker_of_minor_resp());
			rescargo[i].setCaretaker_60yrs_old_resp(cargo
					.getCaretaker_60yrs_old_resp());
			rescargo[i].setCaretaker_student_resp(cargo
					.getCaretaker_student_resp());
			rescargo[i].setNum_hsld_employed(cargo.getNum_hsld_employed());
			rescargo[i].setHsld_bt_earned_income(cargo
					.getHsld_bt_earned_income());
			rescargo[i].setSs_income(cargo.getSs_income());
			rescargo[i].setSsi_income(cargo.getSsi_income());
			rescargo[i].setUnemployment_income(cargo.getUnemployment_income());
			rescargo[i].setCash_gifts_income(cargo.getCash_gifts_income());
			rescargo[i].setAlimony_income(cargo.getAlimony_income());
			rescargo[i].setRental_income(cargo.getRental_income());
			rescargo[i].setOther_income(cargo.getOther_income());
			rescargo[i].setCreate_dt(cargo.getCreate_dt());
			rescargo[i].setDabl_care_chld_lt_5yrs_resp(cargo
					.getDabl_care_chld_lt_5yrs_resp());
			rescargo[i].setChld_13_18_spcl_need_resp(cargo
					.getChld_13_18_spcl_need_resp());
			rescargo[i].setWrk_and_care_chld_resp(cargo
					.getWrk_and_care_chld_resp());
			rescargo[i].setHshl_rent_mtg_mth_pymt(cargo
					.getHshl_rent_mtg_mth_pymt());
			rescargo[i].setHshl_pay_heat_cool_exp_resp(cargo
					.getHshl_pay_heat_cool_exp_resp());
			rescargo[i].setRcv_snap_tanf_medicaid_resp(cargo
					.getRcv_snap_tanf_medicaid_resp());
			rescargo[i].setScr_elg_rslt_ma(cargo.getScr_elg_rslt_ma());
			rescargo[i].setScr_elg_rslt_cc(cargo.getScr_elg_rslt_cc());
			rescargo[i].setScr_elg_rslt_snap(cargo.getScr_elg_rslt_snap());
			rescargo[i].setScr_elg_rslt_wic(cargo.getScr_elg_rslt_wic());
			rescargo[i].setScr_elg_rslt_tanf(cargo.getScr_elg_rslt_tanf());
			rescargo[i].setScr_elg_rslt_liheap(cargo.getScr_elg_rslt_liheap());
			rescargo[i].setCreate_user_no(cargo.getCreate_user_no());
			rescargo[i].setCreate_user_id(cargo.getCreate_user_id());
			/*
			 * rescargo[i].setRowAction(cargo.getRowAction());
			 * rescargo[i].setUser(cargo.getUser()); rescargo[i].setDirty(cargo.isDirty());
			 */
		}
		return rescargo;
	}

	/**
	 * Set the cargo array object to the collection.
	 */
	@Override
	public void setGenericResults(final Object obj) {
		if (obj instanceof CP_APP_SCREENER_Cargo[]) {
			final CP_APP_SCREENER_Cargo[] cbArray = (CP_APP_SCREENER_Cargo[]) obj;
			setResults(cbArray);
		}
	}
}
