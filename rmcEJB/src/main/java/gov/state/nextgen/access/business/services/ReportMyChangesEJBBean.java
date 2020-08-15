/*
 *
 */
package gov.state.nextgen.access.business.services;

import gov.state.nextgen.access.business.entities.APP_INDV_Cargo;
import gov.state.nextgen.access.business.entities.APP_INDV_Collection;
import gov.state.nextgen.access.business.entities.APP_SBMS_Cargo;
import gov.state.nextgen.access.business.entities.APP_SBMS_Collection;
import gov.state.nextgen.access.business.entities.BNFT_CASE_ADR_Cargo;
import gov.state.nextgen.access.business.entities.BNFT_CASE_ADR_Collection;
import gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Cargo;
import gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Collection;
import gov.state.nextgen.access.business.entities.RMC_RQST_Cargo;
import gov.state.nextgen.access.business.entities.RMC_RQST_Collection;
import gov.state.nextgen.access.business.rules.ABFinalSubmitBO;
import gov.state.nextgen.access.business.rules.ABHouseholdMembersSummaryBO;
import gov.state.nextgen.access.business.rules.benefitcase.ContactInformationBO;
import gov.state.nextgen.access.business.rules.employment.JobIncomeBO;
import gov.state.nextgen.access.business.rules.household.HouseHoldInfoBO;
import gov.state.nextgen.access.business.rules.household.MovedInBO;
import gov.state.nextgen.access.business.utility.AgeUtil;
import gov.state.nextgen.access.management.applications.RMCRequestManager;
import gov.state.nextgen.access.management.constants.AppConstants;
import gov.state.nextgen.access.management.individuals.PeopleHandler;
import gov.state.nextgen.access.presentation.entities.listview.RMCSubmitNextStepListView;
import gov.state.nextgen.framework.business.entities.FwTransaction;
import gov.state.nextgen.framework.exceptions.FwException;
import gov.state.nextgen.framework.exceptions.FwWrappedException;
import gov.state.nextgen.framework.factories.FwServiceFactory;
import gov.state.nextgen.framework.management.constants.FwConstants;
import gov.state.nextgen.framework.management.logging.ILog;
import gov.state.nextgen.framework.management.util.FwDataCriteria;
import gov.state.nextgen.framework.persistence.management.IData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ReportMyChangesEJBBean - SessionFacade Object skeleton auto generated -
 * Architecture Team.
 *
 * Creation Date :Tue Jun 06 22:35:28 CDT 2006 Modified By: Modified on:
 */
@javax.ejb.Stateless
@javax.ejb.LocalBean
@javax.ejb.TransactionManagement(javax.ejb.TransactionManagementType.CONTAINER)
public class ReportMyChangesEJBBean extends RMCSessionBean {

	/**
	 * Constructor.
	 */
	public ReportMyChangesEJBBean() {
	}

	/**
	 * Save logic for Category Selection Page (PadeId ARCAT).
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void storeCategorySelection(final FwTransaction txnBean)
			throws javax.ejb.EJBException {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"ReportMyChangesEJBBean.storeCategorySelection() - START");
		log(ILog.INFO, "ReportMyChangesEJBBean::storeCategorySelection:Start");
		RMC_RQST_Cargo rmcRqstCargo = null;
		RMC_RQST_Collection rmcAfterColl = null;
		RMC_RQST_Cargo rmcRqstBeforeCargo = null;
		Map beforeColl = null;
		log(ILog.INFO, "hi");
		try {
			// Getting the session
			final Map session = txnBean.getSession();
			final Map pageCollection = txnBean.getPageCollection();
			final Map request = txnBean.getRequest();
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			final String currentPageID = (String) request
					.get(FwConstants.CURRENT_PAGE_ID);
			final String tfsSw = (String) request
					.get("changeSelection_tfs_stat_sw");
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			rmcAfterColl = (RMC_RQST_Collection) pageCollection
					.get("RMC_RQST_Collection");
			beforeColl = (Map) session.get(FwConstants.BEFORE_COLLECTION);
			rmcRqstBeforeCargo = (RMC_RQST_Cargo) session
					.get(AppConstants.RMC_RQST);
			beforeColl.get(AppConstants.TFS_FLG);
			((Boolean) beforeColl.get(AppConstants.TFS_FLG)).booleanValue();
			final RMCRequestManager rmcRequestManager = new RMCRequestManager();
			final JobIncomeBO jobBo = new JobIncomeBO();
			rmcRqstCargo = rmcAfterColl.getCargo(0);
			jobBo.validateARCAT(rmcRqstCargo, tfsSw);
			if (jobBo.hasMessages()) {
				request.put(FwConstants.MESSAGE_LIST, jobBo.getMessageList());
				pageCollection.put("IS_PREGNANCY_QUE",
						beforeColl.get("IS_PREGNANCY_QUE"));
				pageCollection.put("IS_TARGET_PREGNANTABLE",
						beforeColl.get("IS_TARGET_PREGNANTABLE"));
				pageCollection.put(AppConstants.AGENCY_CONTACT_NO,
						beforeColl.get(AppConstants.AGENCY_CONTACT_NO));
				pageCollection.put("RMC_RQST_Collection", rmcAfterColl);
				pageCollection.put(AppConstants.CS_MUST_ARRAY,
						beforeColl.get(AppConstants.CS_MUST_ARRAY));
				pageCollection.put(AppConstants.CS_MAY_ARRAY,
						beforeColl.get(AppConstants.CS_MAY_ARRAY));
				pageCollection.put(AppConstants.CS_MUST_ARRAY_SUFFIX,
						beforeColl.get(AppConstants.CS_MUST_ARRAY_SUFFIX));
				pageCollection.put(AppConstants.CS_MAY_ARRAY_SUFFIX,
						beforeColl.get(AppConstants.CS_MAY_ARRAY_SUFFIX));
				pageCollection
				.put("Program_Key", beforeColl.get("Program_Key"));
				pageCollection.put(AppConstants.PGM_KEY,
						beforeColl.get(AppConstants.PGM_KEY));
				pageCollection.put(AppConstants.TFS_FLG,
						beforeColl.get(AppConstants.TFS_FLG));
				pageCollection.put(AppConstants.CS_MUST_ARRAY_SECOND,
						beforeColl.get(AppConstants.CS_MUST_ARRAY_SECOND));
				pageCollection.put(AppConstants.CS_MAY_ARRAY_SECOND,
						beforeColl.get(AppConstants.CS_MAY_ARRAY_SECOND));
				pageCollection
				.put("ChangeMonth", beforeColl.get("ChangeMonth"));
				pageCollection.put(AppConstants.FPL_NO,
						beforeColl.get(AppConstants.FPL_NO));
				pageCollection.put(FwConstants.PAGE_COMPONENT_LIST,
						beforeColl.get(FwConstants.PAGE_COMPONENT_LIST));
				final Map statusCheckMust = new HashMap();
				pageCollection.get(AppConstants.CS_MUST_ARRAY);
				final String[] securityOverideMust = (String[]) statusCheckMust
						.get("SECURITY_STATUS");
				final String[] catSelStatMust = (String[]) statusCheckMust
						.get(AppConstants.CATEGORY_SEL_RESPONSE);
				pageCollection.put("SECURITY_STATUS_MUST", securityOverideMust);
				pageCollection.put("STATUS_MUST", catSelStatMust);
				final Map statusCheckMay = new HashMap();
				pageCollection.get(AppConstants.CS_MAY_ARRAY);
				final String[] securityOverideMay = (String[]) statusCheckMay
						.get("SECURITY_STATUS");
				final String[] catSelStatMay = (String[]) statusCheckMay
						.get(AppConstants.CATEGORY_SEL_RESPONSE);
				pageCollection.put("SECURITY_STATUS_MAY", securityOverideMay);
				pageCollection.put("STATUS_MAY", catSelStatMay);
				request.put("fpil", session.get("fpil"));
				if (session.get("fpil130") != null) {
					request.put("fpil130", session.get("fpil130"));
				}
				return;
			}
			RMC_RQST_Cargo rmcRqstFullCargo = null;
			rmcRqstFullCargo = jobBo.getCompleteCargo(rmcRqstBeforeCargo,
					rmcRqstCargo);
			if (rmcRqstBeforeCargo != null) {
				rmcRqstFullCargo = (RMC_RQST_Cargo) isChanged(
						rmcRqstBeforeCargo, rmcRqstFullCargo);
			}
			if (rmcRqstBeforeCargo == null || rmcRqstFullCargo.isDirty()) {
				rmcRqstFullCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
				final RMC_RQST_Collection rmcRqstcoll = new RMC_RQST_Collection();
				rmcRqstcoll.addCargo(rmcRqstFullCargo);
				rmcRequestManager.storeRMCRqst(rmcRqstcoll);
				session.put(AppConstants.RMC_RQST, rmcRqstFullCargo);
				session.put(FwConstants.RMB_DRIVER, driverArray);
			}
			short[] programKeyArr = (short[]) beforeColl.get(AppConstants.PGM_KEY);
			boolean isWIC = false;
			if(programKeyArr[AppConstants.PROGRAM_KEY_WIC] == 1){
				isWIC = true;
			}
			driverManager.makeComplete(FwConstants.RMC_DRIVER, currentPageID,
					driverArray, appNum);
			if (rmcRqstCargo.getEi_chg_sw() != null
					&& FwConstants.YES.equals(rmcRqstCargo.getEi_chg_sw())
					&& rmcRqstBeforeCargo.getEi_chg_sw() != null
					&& FwConstants.NO.equals(rmcRqstBeforeCargo.getEi_chg_sw())) {
				final String[] pageId = { "ARJSE", "ARJIS" };
				driverManager.makeRequired(FwConstants.RMC_DRIVER, pageId,
						driverArray, appNum);
			} else if (rmcRqstBeforeCargo.getEi_chg_sw() != null
					&& FwConstants.YES
					.equals(rmcRqstBeforeCargo.getEi_chg_sw())
					&& rmcRqstCargo.getEi_chg_sw() == null) {
				final String[] pageId = { "ARJSE", "ARJIS" };
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						pageId, driverArray, appNum);
			}

			if (rmcRqstCargo.getAdd_chg_stat_sw() != null
					&& FwConstants.YES
					.equals(rmcRqstCargo.getAdd_chg_stat_sw())
					&& rmcRqstBeforeCargo.getAdd_chg_stat_sw() != null
					&& FwConstants.NO.equals(rmcRqstBeforeCargo
							.getAdd_chg_stat_sw())) {
				final String[] pageId = { "ARACD", "ARHCS" };
				driverManager.makeRequired(FwConstants.RMC_DRIVER, pageId,
						driverArray, appNum);
			} else if (rmcRqstBeforeCargo.getAdd_chg_stat_sw() != null
					&& FwConstants.YES.equals(rmcRqstBeforeCargo
							.getAdd_chg_stat_sw())
							&& rmcRqstCargo.getAdd_chg_stat_sw() == null) {
				final String[] pageId = { "ARACD", "ARHCS" };
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						pageId, driverArray, appNum);
			}

			if (rmcRqstCargo.getDabl_stat_sw() != null
					&& FwConstants.YES.equals(rmcRqstCargo.getDabl_stat_sw())
					&& rmcRqstBeforeCargo.getDabl_stat_sw() != null
					&& FwConstants.NO.equals(rmcRqstBeforeCargo
							.getDabl_stat_sw())) {
				final String[] pageId = { "ARDGP", "ARHCS" };
				driverManager.makeRequired(FwConstants.RMC_DRIVER, pageId,
						driverArray, appNum);
			} else if (rmcRqstBeforeCargo.getDabl_stat_sw() != null
					&& FwConstants.YES.equals(rmcRqstBeforeCargo
							.getDabl_stat_sw())
							&& rmcRqstCargo.getDabl_stat_sw() == null) {
				final String[] pageId = { "ARDGP", "ARHCS" };
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						pageId, driverArray, appNum);
			}

			if (rmcRqstCargo.getHous_util_stat_sw() != null
					&& FwConstants.YES.equals(rmcRqstCargo
							.getHous_util_stat_sw())
							&& rmcRqstBeforeCargo.getHous_util_stat_sw() != null
							&& FwConstants.NO.equals(rmcRqstBeforeCargo
									.getHous_util_stat_sw())) {
				final String[] pageId = { "ARXHU", "ARXHS" };
				driverManager.makeRequired(FwConstants.RMC_DRIVER, pageId,
						driverArray, appNum);
			} else if (rmcRqstBeforeCargo.getHous_util_stat_sw() != null
					&& FwConstants.YES.equals(rmcRqstBeforeCargo
							.getHous_util_stat_sw())
							&& rmcRqstCargo.getHous_util_stat_sw() == null) {
				final String[] pageId = { "ARXHU", "ARXHS" };
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						pageId, driverArray, appNum);
			}

			if (rmcRqstCargo.getOthr_stat_sw() != null
					&& FwConstants.YES.equals(rmcRqstCargo.getOthr_stat_sw())
					&& rmcRqstBeforeCargo.getOthr_stat_sw() != null
					&& FwConstants.NO.equals(rmcRqstBeforeCargo
							.getOthr_stat_sw())) {
				final String[] pageId = { "ARUII", "ARUIS" };
				driverManager.makeRequired(FwConstants.RMC_DRIVER, pageId,
						driverArray, appNum);
			} else if (rmcRqstBeforeCargo.getOthr_stat_sw() != null
					&& FwConstants.YES.equals(rmcRqstBeforeCargo
							.getOthr_stat_sw())
							&& rmcRqstCargo.getOthr_stat_sw() == null) {
				final String[] pageId = { "ARUII", "ARUIS" };
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						pageId, driverArray, appNum);
			}
			if (rmcRqstCargo.getPreg_add_stat_sw() != null
					&& FwConstants.YES.equals(rmcRqstCargo
							.getPreg_add_stat_sw())
							&& rmcRqstBeforeCargo.getPreg_add_stat_sw() != null
							&& FwConstants.NO.equals(rmcRqstBeforeCargo
									.getPreg_add_stat_sw())) {
				final String[] pageId = { "ARHIS", "ARHCS" };
				driverManager.makeRequired(FwConstants.RMC_DRIVER, pageId,
						driverArray, appNum);
			} else if (rmcRqstBeforeCargo.getPreg_add_stat_sw() != null
					&& FwConstants.YES.equals(rmcRqstBeforeCargo
							.getPreg_add_stat_sw())
							&& rmcRqstCargo.getPreg_add_stat_sw() == null) {
				final String[] pageId = { "ARHIS", "ARHCS" };
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						pageId, driverArray, appNum);
			}
			if (rmcRqstCargo.getPreg_chg_stat_sw() != null
					&& FwConstants.YES.equals(rmcRqstCargo
							.getPreg_chg_stat_sw())
							&& rmcRqstBeforeCargo.getPreg_chg_stat_sw() != null
							&& FwConstants.NO.equals(rmcRqstBeforeCargo
									.getPreg_chg_stat_sw())) {
				final String[] pageId = { "ARHIS", "ARHCS" };
				driverManager.makeRequired(FwConstants.RMC_DRIVER, pageId,
						driverArray, appNum);
			} else if (rmcRqstBeforeCargo.getPreg_chg_stat_sw() != null
					&& FwConstants.YES.equals(rmcRqstBeforeCargo
							.getPreg_chg_stat_sw())
							&& rmcRqstCargo.getPreg_chg_stat_sw() == null) {
				final String[] pageId = { "ARHIS", "ARHCS" };
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						pageId, driverArray, appNum);
			}
			if (rmcRqstCargo.getPrsn_add_stat_sw() != null
					&& FwConstants.YES.equals(rmcRqstCargo
							.getPrsn_add_stat_sw())
							&& rmcRqstBeforeCargo.getPrsn_add_stat_sw() != null
							&& FwConstants.NO.equals(rmcRqstBeforeCargo
									.getPrsn_add_stat_sw())) {
				String[] pageId = { "ARHMI", "ARHMX", "ARHCS", "AROBC",
						"AROBS", "ARACS", "ARASM", "AROAC", "AROAS", "ARJSE",
						"ARJIS", "ARUII", "ARUIS", "ARXHU", "ARXHS", "ARBBQ",
				"ARBBS" };
				
				if(isWIC){
					List<String> pageIdList = new ArrayList<>(); 
					pageIdList.add("ARHMI");
					pageIdList.add("ARHMX");
					pageIdList.add("ARHCS");
					pageIdList.add("ARJSE");
					pageIdList.add("ARJIS");
					pageIdList.add("ARUII");
					pageIdList.add("ARUIS");
					pageId = pageIdList.toArray(new String[pageIdList.size()]);
				
				}
				driverManager.makeRequired(FwConstants.RMC_DRIVER, pageId,
						driverArray, appNum);
				rmcAddNewPerson(txnBean);

			} else if (rmcRqstBeforeCargo.getPrsn_add_stat_sw() != null
					&& FwConstants.YES.equals(rmcRqstBeforeCargo
							.getPrsn_add_stat_sw())
							&& rmcRqstCargo.getPrsn_add_stat_sw() == null) {
				String[] pageId = { "ARHMI", "ARHCS", "AROBC", "AROBS",
						"ARACS", "ARASM", "AROAC", "AROAS", "ARJSE", "ARJIS",
						"ARUII", "ARUIS", "ARXHU", "ARXHS", "ARBBQ", "ARBBS" };
				if(isWIC){
					List<String> pageIdList = new ArrayList<>(); 
					pageIdList.add("ARHMI");
					pageIdList.add("ARHMX");
					pageIdList.add("ARHCS");
					pageIdList.add("ARJSE");
					pageIdList.add("ARJIS");
					pageIdList.add("ARUII");
					pageIdList.add("ARUIS");
					pageId = pageIdList.toArray(new String[pageIdList.size()]);
				}
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						pageId, driverArray, appNum);
			}

			if (rmcRqstCargo.getPrsn_move_stat_sw() != null
					&& FwConstants.YES.equals(rmcRqstCargo
							.getPrsn_move_stat_sw())
							&& rmcRqstBeforeCargo.getPrsn_move_stat_sw() != null
							&& FwConstants.NO.equals(rmcRqstBeforeCargo
									.getPrsn_move_stat_sw()) || tfsSw != null
									&& FwConstants.YES.equals(tfsSw)) {
				final String[] pageId = { "ARMOV", "ARHCS" };
				driverManager.makeRequired(FwConstants.RMC_DRIVER, pageId,
						driverArray, appNum);
			} else if (rmcRqstBeforeCargo.getPrsn_move_stat_sw() != null
					&& FwConstants.YES.equals(rmcRqstBeforeCargo
							.getPrsn_move_stat_sw())
							&& rmcRqstCargo.getPrsn_move_stat_sw() == null) {
				final String[] pageId = { "ARMOV", "ARHCS" };
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						pageId, driverArray, appNum);
			}

			if (rmcRqstCargo.getLiquid_asset_changed() != null
					&& FwConstants.YES.equals(rmcRqstCargo
							.getLiquid_asset_changed())
							&& rmcRqstBeforeCargo.getLiquid_asset_changed() != null
							&& FwConstants.NO.equals(rmcRqstBeforeCargo
									.getLiquid_asset_changed())) {
				final String[] pageId = { "ARACS", "ARASM" };
				driverManager.makeRequired(FwConstants.RMC_DRIVER, pageId,
						driverArray, appNum);
			} else if (rmcRqstBeforeCargo.getLiquid_asset_changed() != null
					&& FwConstants.YES.equals(rmcRqstBeforeCargo
							.getLiquid_asset_changed())
							&& rmcRqstCargo.getLiquid_asset_changed() == null) {
				final String[] pageId = { "ARACS", "ARASM" };
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						pageId, driverArray, appNum);
			}
			// SY Added
			if (rmcRqstCargo.getChange_in_personal_info() != null
					&& FwConstants.YES.equals(rmcRqstCargo
							.getChange_in_personal_info())
							&& rmcRqstBeforeCargo.getChange_in_personal_info() != null
							&& FwConstants.NO.equals(rmcRqstBeforeCargo
									.getChange_in_personal_info())) {
				final String[] pageId = { "ARHIS", "ARHMX", "ARHCS" };
				driverManager.makeRequired(FwConstants.RMC_DRIVER, pageId,
						driverArray, appNum);
			} else if (rmcRqstBeforeCargo.getChange_in_personal_info() != null
					&& FwConstants.YES.equals(rmcRqstBeforeCargo
							.getChange_in_personal_info())
							&& rmcRqstCargo.getChange_in_personal_info() == null) {
				final String[] pageId = { "ARHIS", "ARHCS" };
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						pageId, driverArray, appNum);
			}

			if (rmcRqstCargo.getOther_asset_changed() != null
					&& FwConstants.YES.equals(rmcRqstCargo
							.getOther_asset_changed())
							&& rmcRqstBeforeCargo.getOther_asset_changed() != null
							&& FwConstants.NO.equals(rmcRqstBeforeCargo
									.getOther_asset_changed())) {
				final String[] pageId = { "AROAC", "AROAS" };
				driverManager.makeRequired(FwConstants.RMC_DRIVER, pageId,
						driverArray, appNum);
			} else if (rmcRqstBeforeCargo.getOther_asset_changed() != null
					&& FwConstants.YES.equals(rmcRqstBeforeCargo
							.getOther_asset_changed())
							&& rmcRqstCargo.getOther_asset_changed() == null) {
				final String[] pageId = { "AROAC", "AROAS" };
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						pageId, driverArray, appNum);
			}

			if (rmcRqstCargo.getChange_in_child_care() != null
					&& FwConstants.YES.equals(rmcRqstCargo
							.getChange_in_child_care())
							&& rmcRqstBeforeCargo.getChange_in_child_care() != null
							&& FwConstants.NO.equals(rmcRqstBeforeCargo
									.getChange_in_child_care())) {
				final String[] pageId = { "ARHPG", "ARHCS" };
				driverManager.makeRequired(FwConstants.RMC_DRIVER, pageId,
						driverArray, appNum);
			} else if (rmcRqstBeforeCargo.getChange_in_child_care() != null
					&& FwConstants.YES.equals(rmcRqstBeforeCargo
							.getChange_in_child_care())
							&& rmcRqstCargo.getChange_in_child_care() == null) {
				final String[] pageId = { "ARHPG", "ARHCS" };
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						pageId, driverArray, appNum);
			}

			if (rmcRqstCargo.getRlt_stat_sw() != null
					&& FwConstants.YES.equals(rmcRqstCargo.getRlt_stat_sw())
					&& rmcRqstBeforeCargo.getRlt_stat_sw() != null
					&& FwConstants.NO.equals(rmcRqstBeforeCargo
							.getRlt_stat_sw())) {
				final String[] pageId = { "ARHIS", "ARHCS" };
				driverManager.makeRequired(FwConstants.RMC_DRIVER, pageId,
						driverArray, appNum);
			} else if (rmcRqstBeforeCargo.getRlt_stat_sw() != null
					&& FwConstants.YES.equals(rmcRqstBeforeCargo
							.getRlt_stat_sw())
							&& rmcRqstCargo.getRlt_stat_sw() == null) {
				final String[] pageId = { "ARHIS", "ARHCS" };
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						pageId, driverArray, appNum);
			}

			if (rmcRqstCargo.getChange_in_care() != null
					&& FwConstants.YES.equals(rmcRqstCargo.getChange_in_care())
					&& rmcRqstBeforeCargo.getChange_in_care() != null
					&& FwConstants.NO.equals(rmcRqstBeforeCargo
							.getChange_in_care())) {
				final String[] pageId = { "ARBBQ", "ARBBS" };
				driverManager.makeRequired(FwConstants.RMC_DRIVER, pageId,
						driverArray, appNum);
			} else if (rmcRqstBeforeCargo.getChange_in_care() != null
					&& FwConstants.YES.equals(rmcRqstBeforeCargo
							.getChange_in_care())
							&& rmcRqstCargo.getChange_in_care() == null) {
				final String[] pageId = { "ARBBQ", "ARBBS" };
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						pageId, driverArray, appNum);
			}

			if (rmcRqstCargo.getAdditional_info_sw() != null
					&& FwConstants.YES.equals(rmcRqstCargo
							.getAdditional_info_sw())
							&& rmcRqstBeforeCargo.getAdditional_info_sw() != null
							&& FwConstants.NO.equals(rmcRqstBeforeCargo
									.getAdditional_info_sw())) {
				final String[] pageId = { "AROBC", "AROBS" };
				driverManager.makeRequired(FwConstants.RMC_DRIVER, pageId,
						driverArray, appNum);
			} else if (rmcRqstBeforeCargo.getAdditional_info_sw() != null
					&& FwConstants.YES.equals(rmcRqstBeforeCargo
							.getAdditional_info_sw())
							&& rmcRqstCargo.getAdditional_info_sw() == null) {
				final String[] pageId = { "AROBC", "AROBS" };
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						pageId, driverArray, appNum);
			}

           /*MAGI LOGIC STARTS*/
			
			final ABHouseholdMembersSummaryBO  aSummaryBO= new ABHouseholdMembersSummaryBO();
			Boolean medFlag = aSummaryBO.loadMedicaidProgram(appNum);
			if(medFlag){
				final APP_INDV_Collection tempColl = aSummaryBO.loadHouseholdMembers(appNum);
				int ageMagi = 0;
				boolean fullMedicaid = false;
				for (int j = 0; j < tempColl.size(); j++) {
					final APP_INDV_Cargo tempCargo = (APP_INDV_Cargo) tempColl
							.get(j);
					ageMagi = AgeUtil.calculateAge(tempCargo.getBrth_dt());
					if ((FwConstants.YES
									.equals(tempCargo.getDisabled_resp()) || (ageMagi >= 65))) {
						fullMedicaid = true;
						break;
					}
				}
				if(fullMedicaid){
					aSummaryBO.updateMagiProgram(appNum);
					short[] pgmKey = (short[]) session.get(FwConstants.RMC_PROGRAM_KEY);
					pgmKey[FwConstants.MAGI_INDEX] = Short.valueOf(FwConstants.ONE);
					session.put(FwConstants.RMC_PROGRAM_KEY, pgmKey);
				}
			}
			
			
			
			/*MAGI LOGIC ENDS*/
			
			
			session.put("changeSelection_tfs_stat_sw", tfsSw);

			// RMC Extraction Changes starts
			final Map httpSessionMap = (Map) session
					.get(FwConstants.HTTP_SESSION);
			//httpSessionMap.put(AppConstants.LANGUAGE, "EN");
			final Map securedSessionMap = (Map) httpSessionMap
					.get(FwConstants.SECURED_SESSION);
			securedSessionMap.get(AppConstants.ACCESS_LEVEL_COLL);
			final PeopleHandler peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);
			peopleHandler.getAllIndividuals();
			final HouseHoldInfoBO hhBO = new HouseHoldInfoBO();
			final String aAppNum = (String) session
					.get(AppConstants.APP_NUMBER);
			hhBO.getcaseNumber(aAppNum);
			new ArrayList();
			final String[] pageId = { "ARPRS", "ARTKY" };
			driverManager.makeRequired(FwConstants.RMC_DRIVER, pageId,
					driverArray, appNum);
			log(ILog.INFO, "ReportMyChangesEJBBean::storeCategorySelection:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("storeCategorySelection");
			we.setFwException(fe);
			throw we;
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"storeCategorySelection", e);
			throw fe;
		}

		log(ILog.INFO,
				"ReportMyChangesEJBBean.storeCategorySelection() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Comment here.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void loadThankYou(final FwTransaction txnBean)
			throws javax.ejb.EJBException {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ReportMyChangesEJBBean.loadThankYou() - START");
		try {
			// load the session, request and page data.
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final Map session = txnBean.getSession();
			// remove the RMC session variables
			session.remove(FwConstants.RMC_SESSION);
			session.remove(FwConstants.RMC_PROGRAM_KEY);
			session.remove(FwConstants.RMC_DRIVER);
			if(session.containsKey("clickSubmitCounter")){
            	session.remove("clickSubmitCounter");
            }

			// Get the appNum from the request and get the RMC_RQST Collection
			String appNum = (String) request.get(AppConstants.APP_NUMBER);
			if (appNum == null) {
				// if they are comming back from the common questions this logic
				// execute
				final Map beforeColl = (HashMap) session
						.get(FwConstants.BEFORE_COLLECTION);
				if (beforeColl != null) {
					appNum = (String) beforeColl.get(AppConstants.APP_NUMBER);
				}
			}

			final RMCRequestManager rmcReqManage = new RMCRequestManager();
			final RMC_RQST_Cargo rmcRqstCargo = rmcReqManage
					.loadRMCRequest(appNum);
			final String caseNumber = rmcRqstCargo.getCase_num();
			// "100004755"
			// Un-comment when
			// integrated with
			// RMC Flow //

			final List filterTypes = new ArrayList();
			filterTypes.add(AppConstants.WORKER_ADDRESS_TYPE);
			filterTypes.add(AppConstants.CASE_ADDRESS_TYPE);
			// get all the addresses for the case
			final ContactInformationBO bo = new ContactInformationBO();
			final BNFT_CASE_ADR_Collection bnftCaseAdr = bo
					.loadContactInformation(caseNumber);
			// filter the address types 'C' and 'W'
			final BNFT_CASE_ADR_Collection bnftCaseAdrFiltered = bo
					.filterAddresses(bnftCaseAdr, filterTypes);
			BNFT_CASE_ADR_Cargo bnftCargo = null;
			if (bnftCaseAdrFiltered != null) {

				final int bnftSize = bnftCaseAdrFiltered.size();
				for (int i = 0; i < bnftSize; i++) {
					bnftCargo = bnftCaseAdrFiltered.getResult(i);
					bnftCargo = changeReportTo(bnftCargo);
					// additions - officeNum => moOffices changes
					if (!(bnftCargo.getAdr_typ() == null)) {
						if ("C".equals(bnftCargo.getAdr_typ())) {
							pageCollection.put("BNFT_CASE_CHG_CENTER_ADR",
									bnftCargo);
						} else {
							// equals W
							pageCollection.put("BNFT_CASE_WORKER_ADR",
									bnftCargo);
						}

					}
				}
			}

			final RMCSubmitNextStepListView listView = new RMCSubmitNextStepListView();
			final String token = session != null ? (String) session
					.get(FwConstants.SECURITY_TOKEN) : "";
					final List dataList = new ArrayList<>();
					dataList.add("RMC");
					dataList.add(token);
					listView.setLanguage("EN");
					listView.setDisplayData(dataList);
					listView.setName("NextSteps_ListView");
					listView.setPageSize(100);
					pageCollection.put("NextSteps_ListView", listView);
					pageCollection.put(AppConstants.APP_NUMBER, appNum);
					session.put(FwConstants.BEFORE_COLLECTION, pageCollection);
					txnBean.setSession(session);
					txnBean.setPageCollection(pageCollection);
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("loadThankYou");
			we.setFwException(fe);
			throw we;
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"loadThankYou", e);
			throw fe;
		}

		log(ILog.INFO,
				"ReportMyChangesEJBBean.loadThankYou() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Comment here.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void loadTypesOfProof(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ReportMyChangesEJBBean.loadTypesOfProof() - START");
		try {

			final Map session = txnBean.getSession();
			final Map pageCollection = txnBean.getPageCollection();
			componentManager.getComponents("ARTOP", txnBean);
			List componentIdARTOP = new ArrayList();
			componentIdARTOP = (List) pageCollection
					.get(FwConstants.PAGE_COMPONENT_LIST);
			pageCollection.put("COMPONENT_ID_ARTOP", componentIdARTOP);
			session.put(FwConstants.BEFORE_COLLECTION, pageCollection);
			txnBean.setPageCollection(pageCollection);
			txnBean.setSession(session);
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("loadTypesOfProof");
			we.setFwException(fe);
			throw we;
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"loadTypesOfProof", e);
			throw fe;
		}
		log(ILog.INFO,
				"ReportMyChangesEJBBean.loadTypesOfProof() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Load pre submit.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	// PCR 30332 - To hide submit button when no changes are reported.
	public void loadPreSubmit(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ReportMyChangesEJBBean.loadPreSubmit() - START");
		try {
			final Map session = txnBean.getSession();
			final Map pageCollection = txnBean.getPageCollection();
			final Map request = txnBean.getRequest();
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			
			final ABFinalSubmitBO finalBO = new ABFinalSubmitBO();
			final APP_SBMS_Collection appSbmsCollection = finalBO
					.loadFinalApplicationSubmission(appNum);
			pageCollection.put("APP_SBMS_COLLECTION", appSbmsCollection);
			
			if(!appSbmsCollection.isEmpty()){
				APP_SBMS_Cargo cargo = (APP_SBMS_Cargo) appSbmsCollection.get(0);
				request.put(AppConstants.SELF_FIRST_NAME, cargo.getApplicant_first_name());
				request.put(AppConstants.AR_FIRST_NAME, cargo.getFst_nam());
				request.put(AppConstants.SELF_LAST_NAME, cargo.getApplicant_last_name());
				request.put(AppConstants.AR_LAST_NAME, cargo.getLast_nam());
				request.put(AppConstants.SELF_MIDDLE_INITIAL, cargo.getApplicant_mid_name());
				request.put(AppConstants.AR_MIDDLE_INITIAL,	cargo.getMid_init());
				request.put(AppConstants.SELF_SUFFIX, cargo.getApplicant_suffix_name());
				request.put(AppConstants.AR_SUFFIX, cargo.getSuffix_name());
				request.put(AppConstants.SELF_ELEC_SIGN, FwConstants.ONE.equalsIgnoreCase(cargo.getElectronically_sign_ind())?FwConstants.YES:FwConstants.NO);
				request.put(AppConstants.AR_ELEC_SIGN, FwConstants.ONE.equalsIgnoreCase(cargo.getE_sign_ind())?FwConstants.YES:FwConstants.NO);
				request.put(AppConstants.PHY_MEN_CHALLENGED,FwConstants.ONE.equalsIgnoreCase(cargo.getUnable_sign_ind())?FwConstants.YES:FwConstants.NO);
				request.put(AppConstants.VOTER_REG, cargo.getVoter_registration_sw());
			}
			
			pageCollection.put("RMC_DATA_EXISTS", FwConstants.YES);
			request.put("RMC_DATA_EXISTS", FwConstants.YES);
			session.put(FwConstants.BEFORE_COLLECTION, pageCollection);
			txnBean.setRequest(request);
			txnBean.setSession(session);
			txnBean.setPageCollection(pageCollection);
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("loadPreSubmit");
			we.setFwException(fe);
			throw we;
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"loadPreSubmit", e);
			throw fe;
		}
		log(ILog.INFO,
				"ReportMyChangesEJBBean.loadPreSubmit() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * execeutes the given sql and returns the result as a list.
	 *
	 * @param aData the a data
	 * @return the list
	 * @throws FwException the fw exception
	 */
	public List executeSQL(final Map aData) throws FwException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ReportMyChangesEJBBean.executeSQL() - START");

		// get the IData using service factory
		final IData data = (IData) FwServiceFactory.getInstance().create(
				IData.class);
		log(ILog.INFO,
				"ReportMyChangesEJBBean.executeSQL() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return data.execute(FwConstants.SQL, aData);
	}

	/**
	 * Change report to.
	 *
	 * @param aCargo the a cargo
	 * @return the BNF t_ cas e_ ad r_ cargo
	 */
	private BNFT_CASE_ADR_Cargo changeReportTo(final BNFT_CASE_ADR_Cargo aCargo) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ReportMyChangesEJBBean.changeReportTo() - START");
		BNFT_CASE_ADR_Cargo resCargo = new BNFT_CASE_ADR_Cargo();

		// additional work for MoOffice
		if (aCargo == null) {
			return null;
		}
		final String offNum = aCargo.getOffice_num();
		// looking MoOffices about transitionSwitch
		try {
			if (offNum != null && offNum.trim().length() > 1) {
				final Map sqlMap = new HashMap();
				sqlMap.put(FwConstants.SQL_IND, "sql-RM144");

				FwDataCriteria[] criteria = new FwDataCriteria[1];
				criteria[0] = new FwDataCriteria();
				criteria[0].setColumn_name("OFFICE_NUM");
				criteria[0].setColumn_value(offNum);
				criteria[0].setData_type(FwConstants.LONG);
				sqlMap.put(FwConstants.CRITERIA, criteria);
				final List moOfficeList = executeSQL(sqlMap);
				Map moOfficeMap = null;
				if (null!=moOfficeList && !moOfficeList.isEmpty()) {
					moOfficeMap = (Map) moOfficeList.get(0);
				}
				String rmcOffNum = FwConstants.ZERO;
				if (moOfficeMap != null) {
					rmcOffNum = (String) moOfficeMap.get("SS_RMC_OFFICE_NUM");
				}
				if (rmcOffNum == null || rmcOffNum.trim().length() < 1) {
					rmcOffNum = FwConstants.ZERO;
				}
				long rmcOfficeNumber = 0L;
				if (rmcOffNum != null) {
					rmcOfficeNumber = Long.parseLong(rmcOffNum);
				}
				log(ILog.INFO, "++++rmcOfficeNumber=" + rmcOfficeNumber);

				String rmcSw = FwConstants.NO;
				if (moOfficeMap != null) {
					rmcSw = (String) moOfficeMap.get("SS_CHANGE_REPORT_TO_SW");
				}
				if (rmcSw == null || rmcSw.trim().length() < 1) {
					rmcSw = FwConstants.NO;
				}
				log(ILog.INFO, "++++rmcSw=" + rmcSw);

				if ("D".equalsIgnoreCase(rmcSw)) { // change to
					// Mo_Office_addresses
					sqlMap.put(FwConstants.SQL_IND, "sql-RM145");

					criteria = new FwDataCriteria[1];
					criteria[0] = new FwDataCriteria();
					criteria[0].setColumn_name("OFFICE_NUM");
					criteria[0].setColumn_value(offNum);
					criteria[0].setData_type(FwConstants.LONG);
					sqlMap.put(FwConstants.CRITERIA, criteria);
					final List moAddrList = executeSQL(sqlMap);
					Map moAddrMap = null;
					if (null!=moAddrList && !moAddrList.isEmpty()) {
						moAddrMap = (Map) moAddrList.get(0);
						resCargo.setAddr_care_of_line(FwConstants.SPACE);

						String sAddrDwType = FwConstants.SPACE;
						if (moAddrMap.get("ADDR_DWELLING_TYPE_CD") != null) {
							sAddrDwType = (String) moAddrMap
									.get("ADDR_DWELLING_TYPE_CD");
						}
						resCargo.setAddr_dwelling_type_cd(sAddrDwType);

						String sAddrStNumFrac = FwConstants.SPACE;
						if (moAddrMap.get("ADDR_ST_NUM_FRAC") != null) {
							sAddrStNumFrac = (String) moAddrMap
									.get("ADDR_ST_NUM_FRAC");
						}
						resCargo.setAddr_st_num_frac(sAddrStNumFrac);

						String sAddrTyp = FwConstants.SPACE;
						if (moAddrMap.get("ADDRESS_TYPE_CD") != null) {
							sAddrTyp = (String) moAddrMap
									.get("ADDRESS_TYPE_CD");
						}
						resCargo.setAdr_typ(sAddrTyp);

						String sAptAddr = FwConstants.SPACE;
						if (moAddrMap.get("ADDR_APT_NUM") != null) {
							sAptAddr = (String) moAddrMap.get("ADDR_APT_NUM");
						}
						resCargo.setApt_adr(sAptAddr);

						resCargo.setBnft_case_num(aCargo.getBnft_case_num());

						resCargo.setCargoName(aCargo.getCargoName());

						String sCityAddr = FwConstants.SPACE;
						if (moAddrMap.get("ADDR_CITY") != null) {
							sCityAddr = (String) moAddrMap.get("ADDR_CITY");
						}
						resCargo.setCity_adr(sCityAddr);

						String sFaxNum = FwConstants.SPACE;
						if (aCargo.getCntc_fax_num() != null) {
							sFaxNum = aCargo.getCntc_fax_num();
						}
						resCargo.setCntc_fax_num(sFaxNum);

						String sFstNam = FwConstants.SPACE;
						if (aCargo.getCntc_fst_nam() != null) {
							sFstNam = aCargo.getCntc_fst_nam();
						}
						resCargo.setCntc_fst_nam(sFstNam);

						String sLstNam = FwConstants.SPACE;
						if (aCargo.getCntc_last_nam() != null) {
							sLstNam = aCargo.getCntc_last_nam();
						}
						resCargo.setCntc_last_nam(sLstNam);

						String sMidInit = FwConstants.SPACE;
						if (aCargo.getCntc_mid_init() != null) {
							sMidInit = aCargo.getCntc_mid_init();
						}
						resCargo.setCntc_mid_init(sMidInit);

						String sPhnNum = FwConstants.SPACE;
						if (aCargo.getCntc_phn_num() != null) {
							sPhnNum = aCargo.getCntc_phn_num();
						}
						resCargo.setCntc_phn_num(sPhnNum);

						String sCntyNum = FwConstants.SPACE;
						if (moAddrMap.get("ADDR_COUNTY_CD") != null) {
							sCntyNum = (String) moAddrMap.get("ADDR_COUNTY_CD");
						}
						resCargo.setCnty_num(sCntyNum);

						String sDirAddr = FwConstants.SPACE;
						if (moAddrMap.get("ADDR_ST_DIR_CD") != null) {
							sDirAddr = (String) moAddrMap.get("ADDR_ST_DIR_CD");
						}
						resCargo.setDir_adr(sDirAddr);

						String sEmail = FwConstants.SPACE;
						if (aCargo.getEmail() != null) {
							sEmail = aCargo.getEmail();
						}
						resCargo.setEmail(sEmail); // ??

						String sEmpId = FwConstants.SPACE;
						if (aCargo.getEmp_id() != null) {
							sEmpId = aCargo.getEmp_id();
						}
						resCargo.setEmp_id(sEmpId);

						String sL2Addr = FwConstants.SPACE;
						if (moAddrMap.get("ADDR_LINE") != null) {
							sL2Addr = (String) moAddrMap.get("ADDR_LINE");
						}
						resCargo.setL2_adr(sL2Addr);

						String sOffNam = FwConstants.SPACE;
						if (aCargo.getOffice_name() != null) {
							sOffNam = aCargo.getOffice_name();
						}
						resCargo.setOffice_name(sOffNam);

						resCargo.setOffice_num(offNum);

						String sOrgNam = FwConstants.SPACE;
						if (aCargo.getOrg_name() != null) {
							sOrgNam = aCargo.getOrg_name();
						}
						resCargo.setOrg_name(sOrgNam);

						resCargo.setQdrt_adr(FwConstants.SPACE);

						final String sSfxAddr = FwConstants.SPACE;
						resCargo.setSfx_adr(sSfxAddr);

						String sStAddr = FwConstants.SPACE;
						if (moAddrMap.get("ADDR_STATE_CD") != null) {
							sStAddr = (String) moAddrMap.get("ADDR_STATE_CD");
						}
						resCargo.setSt_adr(sStAddr);

						String sStNumAddr = FwConstants.SPACE;
						if (moAddrMap.get("ADDR_ST_NUM") != null) {
							sStNumAddr = (String) moAddrMap.get("ADDR_ST_NUM");
						}
						resCargo.setSt_num_adr(sStNumAddr);

						String sStRurlAddr = FwConstants.SPACE;
						if (moAddrMap.get("ADDR_ST_NM") != null) {
							sStRurlAddr = (String) moAddrMap.get("ADDR_ST_NM");
						}
						resCargo.setSt_rurl_adr(sStRurlAddr);

						resCargo.setUnit_adr(FwConstants.SPACE);

						final java.util.Date today = new java.util.Date();
						final java.sql.Timestamp sqlToday = new java.sql.Timestamp(
								today.getTime());
						resCargo.setUpdt_dt(sqlToday.toString());

						String sZipAddr = FwConstants.SPACE;
						if (moAddrMap.get("ADDR_ZIP5") != null) {
							sZipAddr = (String) moAddrMap.get("ADDR_ZIP5");
						}
						if (moAddrMap.get("ADDR_ZIP4") != null) {
							sZipAddr = sZipAddr
									+ (String) moAddrMap.get("ADDR_ZIP4");
						}
						resCargo.setZip_adr(sZipAddr);
						log(ILog.INFO, "+++++type=D resCargo completed");
					}

				} else {
					resCargo = aCargo;
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = createFwException(this.getClass().getName(),
					"changeReportTo", e);
			throw fe;
		}
		log(ILog.INFO,
				"ReportMyChangesEJBBean.changeReportTo() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return resCargo;
	}

	/**
	 * Rmc add new person.
	 *
	 * @param txnBean the txn bean
	 */
	private void rmcAddNewPerson(final FwTransaction txnBean) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCHouseHoldInfoEJBBean.rmcAddNewPerson() - START");
		final Map session = txnBean.getSession();
		final String appNum = (String) session.get(AppConstants.APP_NUMBER);
		String indvSeqNum = null;
		try {
			
			final RMC_IN_PRFL_Collection rmcInPrflSessColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			RMC_IN_PRFL_Collection rmcPrflPageColl = null;
			RMC_IN_PRFL_Cargo rmcPrflSessCargo = null;
			final MovedInBO movedInBo = new MovedInBO();
			indvSeqNum = String.valueOf(movedInBo.loadMaxSeqNum(appNum) + 1);
			// create new cargo, persist and add to session collection
			rmcPrflSessCargo = new RMC_IN_PRFL_Cargo();
			rmcPrflSessCargo.setApp_num(appNum);
			rmcPrflSessCargo.setIndv_seq_num(indvSeqNum);
			rmcResponseProfileManager
			.createRMCIndividualProfile(rmcPrflSessCargo);
			// set responses for personal information and citizenship
			// information to required
			rmcPrflPageColl = new RMC_IN_PRFL_Collection();
			rmcPrflSessCargo.setPersonal_info(AppConstants.REQUIRED);
			rmcPrflSessCargo.setCitizenship_info(AppConstants.REQUIRED);
			rmcPrflSessCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
			rmcPrflPageColl.addCargo(rmcPrflSessCargo);
			rmcInPrflSessColl.addCargo(rmcPrflSessCargo);
			rmcPrflPageColl.persist(FwConstants.DAO);

			session.put(AppConstants.RMC_IN_PRFL_MASTER, rmcInPrflSessColl);

		} catch (final FwException fe) {
			log(ILog.FATAL,"RMCHouseHoldInfoEJBBeanAPP"+appNum+"INDV_NUM"+indvSeqNum);
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("rmcAddNewPerson");
			we.setFwException(fe);
			throw we;
		} catch (final Exception e) {
			log(ILog.FATAL,"RMCHouseHoldInfoEJBBeanAPP"+appNum+"INDV_NUM"+indvSeqNum);
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"rmcAddNewPerson", e);
			throw fe;
		}

		log(ILog.INFO,
				"RMCJobIncomeEJBBean.rmcAddNewPerson() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

}
