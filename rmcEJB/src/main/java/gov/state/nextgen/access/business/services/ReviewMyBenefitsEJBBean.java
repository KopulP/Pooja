/*
 *
 */
package gov.state.nextgen.access.business.services;

import gov.state.nextgen.access.business.customEntities.CLA_Renewal_Custom_Collection;
import gov.state.nextgen.access.business.customEntities.INDIVIDUAL_Custom_Collection;
import gov.state.nextgen.access.business.customEntities.RMB_SMRF_Custom_Cargo;
import gov.state.nextgen.access.business.customEntities.RMB_SMRF_Custom_Collection;
import gov.state.nextgen.access.business.entities.APP_AUTH_REP_Cargo;
import gov.state.nextgen.access.business.entities.APP_AUTH_REP_Collection;
import gov.state.nextgen.access.business.entities.APP_CMT_Cargo;
import gov.state.nextgen.access.business.entities.APP_CMT_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_CP_WLST_Cargo;
import gov.state.nextgen.access.business.entities.APP_IN_CP_WLST_Collection;
import gov.state.nextgen.access.business.entities.APP_PGM_RQST_Cargo;
import gov.state.nextgen.access.business.entities.APP_PGM_RQST_Collection;
import gov.state.nextgen.access.business.entities.APP_PTNL_ELG_RSLT_Collection;
import gov.state.nextgen.access.business.entities.APP_PTNL_INELG_RSN_Collection;
import gov.state.nextgen.access.business.entities.APP_SBMS_Cargo;
import gov.state.nextgen.access.business.entities.APP_SBMS_Collection;
import gov.state.nextgen.access.business.entities.APP_USER_ADDITIONAL_INFO_Cargo;
import gov.state.nextgen.access.business.entities.APP_USER_ADDITIONAL_INFO_Collection;
import gov.state.nextgen.access.business.entities.CP_CMB_CASE_INFORMATION_Cargo;
import gov.state.nextgen.access.business.entities.CP_CMB_CASE_INFORMATION_Collection;
import gov.state.nextgen.access.business.entities.RMB_RQST_Cargo;
import gov.state.nextgen.access.business.entities.RMB_RQST_Collection;
import gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Collection;
import gov.state.nextgen.access.business.rules.ABCreateAppNumBO;
import gov.state.nextgen.access.business.rules.ABFinalSubmitBO;
import gov.state.nextgen.access.business.rules.ABUserAdditionalInfoBO;
import gov.state.nextgen.access.business.rules.AFBValidationBO;
import gov.state.nextgen.access.business.rules.GenerateNextCntlNumBO;
import gov.state.nextgen.access.business.rules.RMBCorePlanRenewalsBO;
import gov.state.nextgen.access.business.rules.RMBPotentialEligibilityBO;
import gov.state.nextgen.access.business.rules.RMBReceiveWebServiceBO;
import gov.state.nextgen.access.business.rules.ReviewMyBenefitsBO;
import gov.state.nextgen.access.business.rules.SessionManagementBO;
import gov.state.nextgen.access.business.rules.household.AbsentParentBO;
import gov.state.nextgen.access.management.applications.RMBRequestManager;
import gov.state.nextgen.access.management.constants.AppConstants;
import gov.state.nextgen.access.management.individuals.PeopleHandler;
import gov.state.nextgen.framework.business.entities.FwTransaction;
import gov.state.nextgen.framework.exceptions.FwException;
import gov.state.nextgen.framework.exceptions.FwWrappedException;
import gov.state.nextgen.framework.management.constants.FwConstants;
import gov.state.nextgen.framework.management.logging.ILog;
import gov.state.nextgen.framework.management.messages.FwMessageList;
import gov.state.nextgen.framework.management.util.FwDate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.ejb.EJBException;

/**
 * ReviewMyBenefitsEJBBean - SessionFacade Object.
 *
 * @author Gopal Nagaraj
 * Creation Date :07/17/2009 Modified By: Modified on:
 */
@javax.ejb.Stateless
@javax.ejb.LocalBean
@javax.ejb.TransactionManagement(javax.ejb.TransactionManagementType.CONTAINER)
public class ReviewMyBenefitsEJBBean extends RMCSessionBean {

	private static final String ABSENT_PARENT_PRESENT_FLAG = "AbsentParentPresentFlag";

	/**
	 * Constructor.
	 */
	public ReviewMyBenefitsEJBBean() {
	}

	/**
	 * Load rmb landing.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 * @throws javax.ejb.EJBException the javax.ejb. ejb exception
	 */
	public void loadRMBLanding(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ReviewMyBenefitsEJBBean.loadRMBLanding() - START");
		try {
			log(ILog.INFO, "ReviewMyBenefitsEJBBean::loadRMBLanding:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			Map beforeColl = (Map) session.get(FwConstants.BEFORE_COLLECTION);
			if (beforeColl == null) {
				beforeColl = new HashMap();
			}
			final Map httpSession = (Map) session.get(FwConstants.HTTP_SESSION);
			String caseNumber = null;
			if (request.containsKey("CMB_CASE_NUMBER")) {
				caseNumber = (String) request.get("CMB_CASE_NUMBER");
			} else if (httpSession.containsKey("CMB_CASE_NUM")) {
				caseNumber = (String) httpSession.get("CMB_CASE_NUM");
			}

			if (session.containsKey("Store_CMB_CASE_NUMBER")) {
				session.remove("Store_CMB_CASE_NUMBER");
			}
			session.put("Store_CMB_CASE_NUMBER", caseNumber);
			String programCd = FwConstants.EMPTY_STRING;
			if (request.containsKey("CMB_PRGM_CD")) {
				programCd = (String) request.get("CMB_PRGM_CD");
			} else {
				programCd = (String) httpSession.get("RMB_RMC_PRGM_CD");
			}
			String appNumber = null;
			String requestType = null;
			RMB_SMRF_Custom_Collection aRmbSmrfCustColl = null;
			RMB_SMRF_Custom_Cargo cargo = null;
			final CP_CMB_CASE_INFORMATION_Collection cmbCaseInfoCollection = (CP_CMB_CASE_INFORMATION_Collection) session
					.get("CP_CMB_CASE_SUMMARY_INFO_Collection");
			if (caseNumber != null && caseNumber.length() > 0) {
				final GenerateNextCntlNumBO generateCntlNum = new GenerateNextCntlNumBO();
				final ABCreateAppNumBO createAppNumBo = new ABCreateAppNumBO();
				String nextCntlNum = null;
				nextCntlNum = generateCntlNum.getNextCntlNum("AF");
				final StringBuilder sbCn = new StringBuilder();
				final String firstNum = nextCntlNum.substring(nextCntlNum
						.length() - 1);
				if (nextCntlNum.length() < 9) {
					sbCn.append(firstNum);
				} else {
					nextCntlNum = firstNum + nextCntlNum.substring(1);
				}
				final int cntlNumSize = nextCntlNum.length();
				for (int i = 1; i < 9 - cntlNumSize; i++) {
					sbCn.append(AppConstants.ZERO);
				}
				sbCn.append(nextCntlNum);
				appNumber = String.valueOf(createAppNumBo
						.computeCheckDigit(sbCn.toString()));
				List<String> pgmCodes = new ArrayList<String>();
				if (httpSession.get("UpdatePermissionsByCase") != null) {
					pgmCodes = ((Map<String, List<String>>) httpSession
							.get("UpdatePermissionsByCase")).get(caseNumber);
				} else {
					if (programCd != null) {

						final StringTokenizer st = new StringTokenizer(
								programCd, "-");
						while (st.hasMoreTokens()) {
							pgmCodes.add(st.nextToken());
						}
					}
				}
				pgmCodes.add(programCd);
				requestType = AppConstants.RMB_REQUEST_TYPE;
				final RMBReceiveWebServiceBO rmbBo = new RMBReceiveWebServiceBO();
				rmbBo.getRmbDetails(caseNumber, pgmCodes, appNumber,
						requestType, txnBean);
				if (request.get("ERROR_WEB_SERVICE") != null) {
					request.put(FwConstants.NEXT_PAGE_ACTION,
							"CMBMyAccountSummary");
					request.put(FwConstants.NEXT_PAGE_ID, "AMHME");
					return;
				}
				aRmbSmrfCustColl = new RMB_SMRF_Custom_Collection();
			}
			((Map<String, List<String>>) httpSession
					.get("UpdatePermissionsByCase")).get(caseNumber);
			boolean childCare = false;
			boolean wic = false;
			boolean medicare = false;
			boolean snap = false;
			boolean tanf = false;
			boolean pck = false;
			for (int i = 0; i < cmbCaseInfoCollection.size(); i++) {
				final CP_CMB_CASE_INFORMATION_Cargo cmbCargo = cmbCaseInfoCollection
						.getCargo(i);
				String typeCode = cmbCargo.getProgram_type_cd();
				//Boolean flag=(session.get(typeCode+"_RENEW_FALG")!=null)?(Boolean)session.get(typeCode+"_RENEW_FALG"):false;
				//if (flag) {
				if (cmbCargo.getProgram_type_cd() != null
						&& "MC".equals(cmbCargo.getProgram_type_cd())) {
					medicare = true;
				}
				if (cmbCargo.getProgram_type_cd() != null
						&& "TA".equals(cmbCargo.getProgram_type_cd())) {
					tanf = true;
				}
				if (cmbCargo.getProgram_type_cd() != null
						&& "SN".equals(cmbCargo.getProgram_type_cd())) {
					snap = true;
				}
				if (cmbCargo.getProgram_type_cd() != null
						&& "CD".equals(cmbCargo.getProgram_type_cd())) {
					childCare = true;
				}
				if (cmbCargo.getProgram_type_cd() != null
						&& "WC".equals(cmbCargo.getProgram_type_cd())) {
					wic = true;
				}
				if (cmbCargo.getProgram_type_cd() != null
						&& "PC".equals(cmbCargo.getProgram_type_cd())) {
					pck = true;
				}

				cargo = new RMB_SMRF_Custom_Cargo();
				cargo.setValidAGForReview(true);
				cargo.setCat_type(cmbCargo.getProgram_type_cd());
				cargo.setReviewDue(false);
				cargo.setCase_num(caseNumber);
				if(cmbCargo.getRenewal_dt()==null) continue;
				else{
				cargo.setActual_review_date(FwDate.getInstance().getDate(
						cmbCargo.getRenewal_dt().substring(0, 10)));
				}
				aRmbSmrfCustColl.add(cargo);
				//}
			}

			String required = FwConstants.YES;
			if (medicare && tanf && snap || childCare || wic) {
				required = FwConstants.NO;

			}
			
			APP_PGM_RQST_Collection rqstColl = new APP_PGM_RQST_Collection();
			APP_PGM_RQST_Cargo rqstCargo = new APP_PGM_RQST_Cargo();
			if(medicare)
				rqstCargo.setFma_rqst_ind("1");
			if(snap)
				rqstCargo.setFs_rqst_ind("1");
			if(tanf)
				rqstCargo.setTanf_rqst_ind("1");
			if(childCare)
				rqstCargo.setCc_rqst_ind("1");
			if(wic)
				rqstCargo.setWic_rqst_ind("1");
			if(pck)
				rqstCargo.setPeach_rqst_ind("1");
			rqstColl.add(rqstCargo);
			pageCollection.put("APP_PGM_RQST_Collection",rqstColl);
			
			
			final ReviewMyBenefitsBO reviewBO = new ReviewMyBenefitsBO();
			final Map reviewDetMap = reviewBO.getReviewProgramDetailsMap(
					aRmbSmrfCustColl, "RMB");
			pageCollection.put("RMB_PRGM_DET_MAP", reviewDetMap);
			if (reviewBO.isCorePlanRenewals(aRmbSmrfCustColl)) {
				final List claIndvPinList = reviewBO
						.getCLAIndvPINList(aRmbSmrfCustColl);
				final Map rrpIndvMap = reviewBO.getRRPStatus(claIndvPinList);
				final Map phyIndvMap = reviewBO.getPhysicalExamStatus(
						claIndvPinList, rrpIndvMap);
				reviewBO.checkForRRPAndPhicalExamStatus(reviewDetMap,
						claIndvPinList, rrpIndvMap, phyIndvMap);
				pageCollection.put("BCLA_INDV_RRP_MAP", rrpIndvMap);
				pageCollection.put("BCLA_INDV_PHY_EXM_MAP", phyIndvMap);
			}
			beforeColl.putAll(pageCollection);
			session.put(FwConstants.BEFORE_COLLECTION, beforeColl);
			session.put(FwConstants.ACCESS_APPLICATION_TYPE,
					String.valueOf(FwConstants.RMB_APP_TYPE));
			session.put(FwConstants.REQUIRED, required);
			session.put(AppConstants.APP_NUMBER, appNumber);
			session.put(AppConstants.REVIEW_CASE_NUM, caseNumber);
			final ReviewMyBenefitsBO reviewBenfBO = new ReviewMyBenefitsBO();
			reviewBenfBO.updateAppType("RMB", appNumber);
			log(ILog.INFO, "ReviewMyBenefitsEJBBean::loadRMBLanding:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("loadRMBLanding");
			we.setFwException(fe);
			throw exceptionManagerLog(fe, getClass().getName(), "loadRMBLanding");
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"loadRMBLanding", e);
			throw exceptionManagerLog(fe, getClass().getName(), "loadRMBLanding");
		}

		log(ILog.INFO,
				"ReviewMyBenefitsEJBBean.loadRMBLanding() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Store other information.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	private void storeOtherInformation(final FwTransaction txnBean)
			throws EJBException {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"ReviewMyBenefitsEJBBean.storeOtherInformation() - START");
		try {

			final ABUserAdditionalInfoBO userAdditionalInfoBO = new ABUserAdditionalInfoBO();

			final Map session = txnBean.getSession();

			// set language
			final Map httpSessionMap = (Map) session
					.get(FwConstants.HTTP_SESSION);
			httpSessionMap.get(AppConstants.LANGUAGE);
			final Map pageCollection = txnBean.getPageCollection();

			final Map httpSession = (Map) session.get(FwConstants.HTTP_SESSION);
			Map securedSession = null;
			if (httpSession.get(FwConstants.SECURED_SESSION) != null) {
				securedSession = (Map) httpSession
						.get(FwConstants.SECURED_SESSION);
			}

			String caseNumber = (String) session
					.get(AppConstants.REVIEW_CASE_NUM);
			caseNumber = "712656";

			securedSession.get("wid");
			final String appNumber = (String) session
					.get(AppConstants.APP_NUMBER);
			securedSession.get("password");
			RMB_RQST_Collection rmbRqstCol = null;
			final RMB_RQST_Collection rmbRqstColNew = new RMB_RQST_Collection();
			RMB_RQST_Cargo rmbRqstCargo = null;
			String sAuthResp = null;

			rmbRqstCol = (RMB_RQST_Collection) pageCollection
					.get("RMB_RQST_Collection");

			if (rmbRqstCol != null && !rmbRqstCol.isEmpty()) {

				if (rmbRqstCol.getCargo(0).getAuthorized_rep_stat_ind() != null) {
					sAuthResp = rmbRqstCol.getCargo(0)
							.getAuthorized_rep_stat_ind();
				}
				final RMB_RQST_Collection rmbcoll = (RMB_RQST_Collection) session
						.get(AppConstants.RMB_RQST_COLLECTION);
				if (rmbcoll != null && !rmbcoll.isEmpty()) {
					rmbRqstCargo = rmbcoll.getCargo(0);
				} else {
					rmbRqstCargo = userAdditionalInfoBO.getRMBAppRequest(
							appNumber, caseNumber);
				}
				if (rmbRqstCargo != null) {
					rmbRqstCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
				} else {

					rmbRqstCargo = rmbRqstCol.getCargo(0);
					rmbRqstCargo.setApp_num(appNumber);
					rmbRqstCargo.setCase_num(caseNumber);
					rmbRqstCargo.setAdr_chg_stat_ind(FwConstants.YES);
					rmbRqstCargo.setRowAction(FwConstants.ROWACTION_INSERT);
				}

				if (FwConstants.YES.equalsIgnoreCase(sAuthResp)) {
					rmbRqstCargo.setAuthorized_rep_stat_ind(FwConstants.YES);
				} else {
					rmbRqstCargo.setAuthorized_rep_stat_ind(FwConstants.NO);
				}

				final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
				rmbRqstCargo.setUpdt_dt(sdf.format(new Date())); // "MM/dd/yyyy"
				rmbRqstColNew.addCargo(rmbRqstCargo);
				rmbRqstColNew.persist(FwConstants.DAO);
				session.put(AppConstants.RMB_RQST_COLLECTION, rmbRqstColNew);
			}

			final APP_PGM_RQST_Collection appPgmRqstColNew = new APP_PGM_RQST_Collection();
			APP_PGM_RQST_Collection appPgmRqstCol = null;
			APP_PGM_RQST_Cargo appPgmRqstCargo = null;
			String sMA = FwConstants.ZERO;
			String sSNAP = FwConstants.ZERO;
			String sTANF = FwConstants.ZERO;
			String anyProgram = FwConstants.ZERO;

			appPgmRqstCol = (APP_PGM_RQST_Collection) pageCollection
					.get("APP_PGM_RQST_Collection");

			if (appPgmRqstCol != null && !appPgmRqstCol.isEmpty()) {
				final APP_PGM_RQST_Cargo cargo = appPgmRqstCol.getCargo(0);
				if (cargo.getRmb_other_program_ind() != null
						&& FwConstants.YES.equalsIgnoreCase(cargo
								.getRmb_other_program_ind())) {
					anyProgram = FwConstants.ONE;
					if (appPgmRqstCol.getCargo(0).getRmb_fma_rqst_ind() != null) {
						if (FwConstants.YES.equalsIgnoreCase(appPgmRqstCol
								.getCargo(0).getRmb_fma_rqst_ind())) {
							sMA = FwConstants.ONE;
						}
					}
					if (appPgmRqstCol.getCargo(0).getRmb_snap_rqst_ind() != null) {
						if (FwConstants.YES.equalsIgnoreCase(appPgmRqstCol
								.getCargo(0).getRmb_snap_rqst_ind())) {
							sSNAP = FwConstants.ONE;
						}
					}
					if (appPgmRqstCol.getCargo(0).getRmb_tanf_rqst_ind() != null) {
						if (FwConstants.YES.equalsIgnoreCase(appPgmRqstCol
								.getCargo(0).getRmb_tanf_rqst_ind())) {
							sTANF = FwConstants.ONE;
						}
					}
				}

				appPgmRqstCargo = userAdditionalInfoBO
						.getRMBProgramRequest(appNumber);

				if (appPgmRqstCargo != null) {
					appPgmRqstCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
				} else {
					appPgmRqstCargo = appPgmRqstCol.getCargo(0);
					appPgmRqstCargo.setRowAction(FwConstants.ROWACTION_INSERT);
					appPgmRqstCargo.setApp_num(appNumber);
				}

				appPgmRqstCargo.setRmb_other_program_ind(anyProgram);
				appPgmRqstCargo.setRmb_fma_rqst_ind(sMA);
				appPgmRqstCargo.setRmb_snap_rqst_ind(sSNAP);
				appPgmRqstCargo.setRmb_tanf_rqst_ind(sTANF);
				appPgmRqstColNew.addCargo(appPgmRqstCargo);
				appPgmRqstColNew.persist(FwConstants.DAO);

			}

		} catch (final FwException fe) {
			log(ILog.ERROR, fe.getMessage());
			exceptionManagerLog(fe, getClass().getName(), "storeOtherInformation");
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"storeOtherInformation", e);
			throw exceptionManagerLog(fe, getClass().getName(), "storeOtherInformation");
		} finally {
			log(ILog.INFO,
					"ReviewMyBenefitsEJBBean::storeOtherInformation: END ");
			log(ILog.INFO,
					"ReviewMyBenefitsEJBBean.storeOtherInformation() - END , Time Taken : "
							+ (System.currentTimeMillis() - startTime)
							+ " milliseconds");
		}

	}

	/**
	 * Store add user detail.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void storeAddUserDetail(final FwTransaction txnBean)
			throws javax.ejb.EJBException {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ReviewMyBenefitsEJBBean.storeAddUserDetail() - START");
		try {
			log(ILog.INFO, "ReviewMyBenefitsEJBBean::storeAddUserDetail:Start");
			final Map session = txnBean.getSession();
			final Map pageCollection = txnBean.getPageCollection();
			final Map request = txnBean.getRequest();
			final ABUserAdditionalInfoBO abSerTribalBO = new ABUserAdditionalInfoBO();
			final String currentPageID = (String) request
					.get(FwConstants.CURRENT_PAGE_ID);

			storeOtherInformation(txnBean);

			String action = FwConstants.EMPTY_STRING;
			// get driver array
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);

			// get Details Collection and Cargo
			final APP_USER_ADDITIONAL_INFO_Collection appUserAddCollReq = (APP_USER_ADDITIONAL_INFO_Collection) pageCollection
					.get("APP_USER_ADDITIONAL_INFO_Collection");

			APP_USER_ADDITIONAL_INFO_Cargo appUserAddCargoReq = new APP_USER_ADDITIONAL_INFO_Cargo();
			if (appUserAddCollReq != null) {
				appUserAddCargoReq = appUserAddCollReq.getCargo(0);
			}

			final Map beforePageColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);
			// values to the cargo
			final APP_USER_ADDITIONAL_INFO_Collection beforeTribalSerColl = (APP_USER_ADDITIONAL_INFO_Collection) beforePageColl
					.get("APP_USER_ADDITIONAL_INFO_Collection");

			if (beforeTribalSerColl != null
					&& beforeTribalSerColl.getCargo(0) != null) {
				final APP_USER_ADDITIONAL_INFO_Cargo beforeCargo = beforeTribalSerColl
						.getCargo(0);
				appUserAddCargoReq.setApp_num((String) session
						.get(AppConstants.APP_NUMBER));

				// check dirty
				appUserAddCargoReq = (APP_USER_ADDITIONAL_INFO_Cargo) isChanged(
						beforeCargo, appUserAddCargoReq);
			}

			// Run Validations
			abSerTribalBO.validatePageContents(appUserAddCargoReq
					.getAdditional_info());

			if (abSerTribalBO.hasMessages()) {
				request.put(FwConstants.MESSAGE_LIST,
						abSerTribalBO.getMessageList());
				// put the first Name into request to avoid null pointer in JSP
				pageCollection.put(AppConstants.FIRST_NAME,
						beforePageColl.get(AppConstants.FIRST_NAME));
				pageCollection.put("ShowLoopingQuestionFlag",
						beforePageColl.get("ShowLoopingQuestionFlag"));
				pageCollection.put(FwConstants.PAGE_COMPONENT_LIST,
						beforePageColl.get(FwConstants.PAGE_COMPONENT_LIST));
				return;
			}

			// PersistData if the cargo is dirty
			if (appUserAddCargoReq.isDirty()) {

				if (appUserAddCollReq != null
						&& appUserAddCollReq.getCargo(0).getApp_num() != null
						&& beforeTribalSerColl != null
						&& (beforeTribalSerColl.getCargo(0).getApp_num() == null || beforeTribalSerColl
						.getCargo(0).getApp_num() != null
						&& !beforeTribalSerColl
						.getCargo(0)
						.getApp_num()
						.equals(appUserAddCollReq.getCargo(0)
								.getApp_num()))) {
					action = "insert";
				} else {
					action = "update";
				}

				abSerTribalBO.storeUserAdditionalDetails(appUserAddCollReq,
						action);
			}

			// check the detailsFinishedFlag
			// Make driver for this page "COMPLETE"
			driverManager.makeComplete(FwConstants.RMC_DRIVER, currentPageID,
					driverArray, (String) session.get(AppConstants.APP_NUMBER));

			log(ILog.INFO, "ReviewMyBenefitsEJBBean::storeAddUserDetail:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("storeAddUserDetail");
			we.setFwException(fe);
			throw exceptionManagerLog(fe, getClass().getName(), "storeAddUserDetail");
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"storeAddUserDetail", e);
			throw exceptionManagerLog(fe, getClass().getName(), "storeAddUserDetail");
		}
		log(ILog.INFO,
				"ReviewMyBenefitsEJBBean.storeAddUserDetail() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Gets the user additional details.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void getUserAdditionalDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"ReviewMyBenefitsEJBBean.getUserAdditionalDetails() - START");
		try {
			log(ILog.INFO, "ReviewMyBenefitsEJBBean::getUserAddDetails:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			Map pageCollection = txnBean.getPageCollection();
			// make loopingQuestion value NO in the request
			request.put("loopingQuestion", FwConstants.NO);
			final String currentPageID = (String) request
					.get(FwConstants.CURRENT_PAGE_ID);
			final String previousPageId = (String) request
					.get(FwConstants.PREVIOUS_PAGE_ID);

			final String appNumber = (String) session
					.get(AppConstants.APP_NUMBER);// "6000251360"
			if (!previousPageId.equals(currentPageID)) {
				// clean Session
				session.remove("APP_USER_ADDITIONAL_INFO_Collection");
				session.remove(FwConstants.BEFORE_COLLECTION);
				if (!"ABHIS".equals(previousPageId)) {
					pageCollection.remove(FwConstants.DETAIL_KEY_BEAN);
				}
			}

			final Map httpSessionMap = (Map) session
					.get(FwConstants.HTTP_SESSION);
			httpSessionMap.get(AppConstants.LANGUAGE);

			final String caseNumber = (String) session
					.get(AppConstants.REVIEW_CASE_NUM);

			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			final int driverStatus = driverManager.getAFBStatus(
					FwConstants.RMC_DRIVER, currentPageID, driverArray);
			final ABUserAdditionalInfoBO userAdditionalInfoBO = new ABUserAdditionalInfoBO();
			// When user hits the Back button or comes from the Summary Page
			if (pageCollection.get(FwConstants.DETAIL_KEY_BEAN) != null) {

				pageCollection = new HashMap();
				// get Details_Collection from DataBase and set to
				// PageCollection
				pageCollection.put("APP_USER_ADDITIONAL_INFO_Collection",
						userAdditionalInfoBO
						.loadUserAdditionalDetails((String) session
								.get(AppConstants.APP_NUMBER)));

				if (session.get(AppConstants.INDIV_MASTER_HANDLER) == null
						&& !pageCollection.isEmpty()) {
					// now we are loading the people handler
					final PeopleHandler newpeopleHandler = new PeopleHandler();
					newpeopleHandler.loadPeopleHandler(appNumber);
					session.put(AppConstants.INDIV_MASTER_HANDLER,
							newpeopleHandler);
				}

			} else {
				pageCollection = new HashMap();
				// check the session and pageCollection for
				// APP_IN_SHLTC_Collection
				// if not found read the database and populate the RecordArray.
				if (session.get("APP_USER_ADDITIONAL_INFO_Collection") == null) {
					setUserAdditionalUserInfoCollectionToSession(txnBean,
							driverStatus);
				}
				// check is pageStatus is REQ OR ADDNEW or VISIT_AGAIN
				if (driverStatus == FwConstants.DRIVER_REQUIRED
						|| driverStatus == FwConstants.DRIVER_ADD_NEW
						|| driverStatus == FwConstants.DRIVER_VISIT_AGAIN) {

					// loop thru appInPrflColl_Session
					final APP_USER_ADDITIONAL_INFO_Collection collSes = (APP_USER_ADDITIONAL_INFO_Collection) session
							.get("APP_USER_ADDITIONAL_INFO_Collection");
					APP_USER_ADDITIONAL_INFO_Cargo cargoSes = null;
					final int size = collSes.size();
					if (size > 0) {
						// get last cargo from session
						cargoSes = collSes.getCargo(size - 1);
					}

					final APP_USER_ADDITIONAL_INFO_Collection newColl = new APP_USER_ADDITIONAL_INFO_Collection();
					newColl.addCargo(cargoSes);
					// set Details_Collection from session to PageCollection
					pageCollection.put("APP_USER_ADDITIONAL_INFO_Collection",
							newColl);
				} else {
					final APP_USER_ADDITIONAL_INFO_Collection collSes = (APP_USER_ADDITIONAL_INFO_Collection) session
							.get("APP_USER_ADDITIONAL_INFO_Collection");
					APP_USER_ADDITIONAL_INFO_Cargo cargoSes = null;
					final int size = collSes.size();
					if (size > 0) {
						// get last cargo from session
						cargoSes = collSes.getCargo(size - 1);
					}
					final APP_USER_ADDITIONAL_INFO_Collection newColl = new APP_USER_ADDITIONAL_INFO_Collection();
					newColl.addCargo(cargoSes);
					// set Details_Collection from session to PageCollection
					pageCollection.put("APP_USER_ADDITIONAL_INFO_Collection",
							newColl);

				}

			}
			// START
			final RMB_RQST_Collection rmbReqCol = new RMB_RQST_Collection();
			final RMB_RQST_Cargo rmbCargo = userAdditionalInfoBO
					.getRMBAppRequest(appNumber, caseNumber);
			if (rmbCargo != null) {
				rmbReqCol.addCargo(rmbCargo);
				pageCollection.put("RMB_RQST_Cargo", rmbCargo);
			}
			pageCollection.put("RMB_RQST_Collection", rmbReqCol);

			final APP_PGM_RQST_Collection appPgmRqstCol = new APP_PGM_RQST_Collection();
			final APP_PGM_RQST_Cargo appPgmRqstCargo = userAdditionalInfoBO
					.getRMBProgramRequest(appNumber);
			if (appPgmRqstCargo != null) {
				appPgmRqstCol.addCargo(appPgmRqstCargo);
				pageCollection.put("APP_PGM_RQST_Cargo", appPgmRqstCargo);
			}
			pageCollection.put("APP_PGM_RQST_Collection", appPgmRqstCol);

			// END

			txnBean.setPageCollection(pageCollection);
			// Run ComponentManager to get the components for the current page
			componentManager.getComponents(currentPageID, txnBean);
			// Add the page collection to before collection
			if (session.get(FwConstants.BEFORE_COLLECTION) != null) {
				((Map) session.get(FwConstants.BEFORE_COLLECTION))
				.putAll(pageCollection);
			} else {
				final Map beforeColl = new HashMap();
				beforeColl.putAll(pageCollection);
				session.put(FwConstants.BEFORE_COLLECTION, beforeColl);
			}
			log(ILog.INFO, "ReviewMyBenefitsEJBBean::getUserAddDetails:End");

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("getUserAddDetails");
			we.setFwException(fe);
			throw exceptionManagerLog(fe, getClass().getName(), "getUserAdditionalDetails");
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"getUserAddDetails", e);
			throw exceptionManagerLog(fe, getClass().getName(), "getUserAdditionalDetails");
		}
		log(ILog.INFO,
				"ReviewMyBenefitsEJBBean.getUserAddDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Sets the user additional user info collection to session.
	 *
	 * @param txnBean the txn bean
	 * @param driverStatus the driver status
	 */
	private void setUserAdditionalUserInfoCollectionToSession(
			final FwTransaction txnBean, final int driverStatus) {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"ReviewMyBenefitsEJBBean.setUserAdditionalUserInfoCollectionToSession() - START");
		final Map session = txnBean.getSession();
		final Map pageCollection = txnBean.getPageCollection();
		try {
			APP_USER_ADDITIONAL_INFO_Collection additionalInfoColl = new APP_USER_ADDITIONAL_INFO_Collection();

			if (pageCollection.get("APP_USER_ADDITIONAL_INFO_Collection") != null) {
				additionalInfoColl = (APP_USER_ADDITIONAL_INFO_Collection) pageCollection
						.get("APP_USER_ADDITIONAL_INFO_Collection");
				session.put("APP_USER_ADDITIONAL_INFO_Collection",
						additionalInfoColl);
			} else {
				final ABUserAdditionalInfoBO abUserAdditionalInfoBO = new ABUserAdditionalInfoBO();
				APP_USER_ADDITIONAL_INFO_Collection appShltcColl = null;

				appShltcColl = abUserAdditionalInfoBO
						.loadUserAdditionalDetails((String) session
								.get(AppConstants.APP_NUMBER));

				if (appShltcColl != null) {
					final int emplCollSize = appShltcColl.size();
					for (int i = 0; i < emplCollSize; i++) {
						if (appShltcColl.getCargo(i) != null) {
							additionalInfoColl.addCargo(appShltcColl
									.getCargo(i));
						}
					}
				}
				if (null!=additionalInfoColl && !additionalInfoColl.isEmpty()) {
					session.put("APP_USER_ADDITIONAL_INFO_Collection",
							additionalInfoColl);
				}
			}
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("setUserAdditionalUserInfoCollectionToSession");
			we.setFwException(fe);
			throw exceptionManagerLog(fe, getClass().getName(), "setUserAdditionalUserInfoCollectionToSession");
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"setUserAdditionalUserInfoCollectionToSession", e);
			throw exceptionManagerLog(fe, getClass().getName(), "setUserAdditionalUserInfoCollectionToSession");
		}
		log(ILog.INFO,
				"ReviewMyBenefitsEJBBean.setUserAdditionalUserInfoCollectionToSession() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Load smrf landing.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 * @throws javax.ejb.EJBException the javax.ejb. ejb exception
	 */
	public void loadSMRFLanding(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ReviewMyBenefitsEJBBean.loadSMRFLanding() - START");
		try {
			log(ILog.INFO, "ReviewMyBenefitsEJBBean::loadSMRFLanding:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);

			final ReviewMyBenefitsBO reviewBO = new ReviewMyBenefitsBO();
			// get RMB_SMRF_Custom_Collection from before collection which was
			// set in CMB ladning page
			final RMB_SMRF_Custom_Collection aRmbSmrfCustColl = (RMB_SMRF_Custom_Collection) beforeColl
					.get("RMB_SMRF_Custom_Collection");
			// call BO to prepare map to display in JSP
			final Map reviewDetMap = reviewBO.getReviewProgramDetailsMap(
					aRmbSmrfCustColl, "SMRF");
			pageCollection.put("SMRF_PRGM_DET_MAP", reviewDetMap);

			// check if user is already submitted RMB application in this review
			// window
			// than show the warring message on load of the page
			FwMessageList messageList = null;
			messageList = reviewBO.isSMRFApplicationSubmitted(aRmbSmrfCustColl);
			if (messageList != null && messageList.hasMessages()) {
				request.put(FwConstants.MESSAGE_LIST, reviewBO.getMessageList());
				request.put(FwConstants.CURRENT_PAGE_ID, "ARSLD");
			}

			beforeColl.putAll(pageCollection);
			session.put(FwConstants.ACCESS_APPLICATION_TYPE,
					String.valueOf(FwConstants.SMRF_APP_TYPE));
			log(ILog.INFO, "ReviewMyBenefitsEJBBean::loadSMRFLanding:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("loadSMRFLanding");
			we.setFwException(fe);
			throw exceptionManagerLog(fe, getClass().getName(), "loadSMRFLanding");
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"loadSMRFLanding", e);
			throw exceptionManagerLog(fe, getClass().getName(), "loadSMRFLanding");
		}
		log(ILog.INFO,
				"ReviewMyBenefitsEJBBean.loadSMRFLanding() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Load final application submission.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 * @throws javax.ejb.EJBException the javax.ejb. ejb exception
	 */
	public void loadFinalApplicationSubmission(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"ReviewMyBenefitsEJBBean.loadFinalApplicationSubmission() - START");
		try {
			log(ILog.INFO,
					"ReviewMyBenefitsEJBBean::loadFinalApplicationSubmission");
			// Initial loading of session, request and pagecontext data.
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			final String currentPageID = (String) request
					.get(FwConstants.CURRENT_PAGE_ID);
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			final int driverStatus = driverManager.getAFBStatus(
					FwConstants.RMC_DRIVER, currentPageID, driverArray);
			final ABFinalSubmitBO finalBO = new ABFinalSubmitBO();

			/*if (driverStatus == FwConstants.DRIVER_COMPLETE) {
				
				final APP_SBMS_Collection appSbmsCollection = finalBO
						.loadFinalApplicationSubmission(appNum);
				pageCollection.put("APP_SBMS_Collection", appSbmsCollection);
			} else if (driverStatus == FwConstants.DRIVER_REQUIRED) {*/

				final APP_AUTH_REP_Collection appAuthRepCol = new APP_AUTH_REP_Collection();
				if (pageCollection.get("APP_AUTH_REP_Collection") != null) {
					pageCollection.put("APP_AUTH_REP_Collection",
							pageCollection.get("APP_AUTH_REP_Collection"));
				} else {
					final APP_AUTH_REP_Cargo appAuthRepCargo = new APP_AUTH_REP_Cargo();
					appAuthRepCol.addCargo(appAuthRepCargo);
				}
				pageCollection.put("APP_AUTH_REP_Collection", appAuthRepCol);

				final APP_SBMS_Collection appSbmsCollection =  finalBO.loadFinalApplicationSubmission(appNum);
				pageCollection.put("APP_SBMS_Collection", appSbmsCollection);
				/*if (pageCollection.get("APP_SBMS_Collection") != null) {
					pageCollection.put("APP_SBMS_Collection",
							pageCollection.get("APP_SBMS_Collection"));
				} else {
					final APP_SBMS_Cargo appSbmsCargo = new APP_SBMS_Cargo();
					appSbmsCollection.addCargo(appSbmsCargo);
				}
				pageCollection.put("APP_SBMS_Collection", appSbmsCollection);*/
//			}
			session.put(FwConstants.BEFORE_COLLECTION, pageCollection);

			/*Map beforeColl = (Map) session.get(FwConstants.BEFORE_COLLECTION);
			if (beforeColl == null) {
				beforeColl = new HashMap();
				session.put(FwConstants.BEFORE_COLLECTION, beforeColl);
			}*/
			
			// getting absent parent present
			final AbsentParentBO abo = new AbsentParentBO();
			final String isAbsentParentPresent = abo.isAbsentParentPresent(appNum);
			if (FwConstants.YES.equals(isAbsentParentPresent)) {
				pageCollection.put(ABSENT_PARENT_PRESENT_FLAG, FwConstants.YES);
			}
			

			log(ILog.INFO,
					"ReviewMyBenefitsEJBBean::loadFinalApplicationSubmission");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("loadFinalApplicationSubmission");
			we.setFwException(fe);
			throw exceptionManagerLog(fe, getClass().getName(), "loadFinalApplicationSubmission");
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"loadFinalApplicationSubmission", e);
			throw exceptionManagerLog(fe, getClass().getName(), "loadFinalApplicationSubmission");
		}
		log(ILog.INFO,
				"ReviewMyBenefitsEJBBean.loadFinalApplicationSubmission() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Load rmbsmrf coments.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 * @throws javax.ejb.EJBException the javax.ejb. ejb exception
	 */
	public void loadRMBSMRFComents(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ReviewMyBenefitsEJBBean.loadRMBSMRFComents() - START");
		try {
			log(ILog.INFO, "ReviewMyBenefitsEJBBean::loadRMBSMRFComents:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);
			final String currentPageId = (String) request
					.get(FwConstants.CURRENT_PAGE_ID);

			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			final ReviewMyBenefitsBO rmbBO = new ReviewMyBenefitsBO();
			final APP_CMT_Collection appCmtColl = rmbBO.loadRMBComments(appNum);
			if (appCmtColl != null && !appCmtColl.isEmpty()) {
				pageCollection.put("APP_CMT_Collection_exits", appCmtColl);
			}

			pageCollection.put("APP_CMT_Collection", appCmtColl);
			if (currentPageId != null && "ARCMT".equals(currentPageId)) {
				if (pageCollection.get("close_window") == null
						|| !FwConstants.NO.equals(pageCollection
								.get("close_window"))) {
					pageCollection.put("close_window", FwConstants.YES);
				}
			}

			beforeColl.putAll(pageCollection);

			log(ILog.INFO, "ReviewMyBenefitsEJBBean::loadRMBSMRFComents:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("loadRMBSMRFComents");
			we.setFwException(fe);
			throw exceptionManagerLog(fe, getClass().getName(), "loadRMBSMRFComents");
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"loadRMBSMRFComents", e);
			throw exceptionManagerLog(fe, getClass().getName(), "loadRMBSMRFComents");
		}
		log(ILog.INFO,
				"ReviewMyBenefitsEJBBean.loadRMBSMRFComents() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Store rmbsmrf coments.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 * @throws javax.ejb.EJBException the javax.ejb. ejb exception
	 */
	public void storeRMBSMRFComents(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ReviewMyBenefitsEJBBean.storeRMBSMRFComents() - START");
		try {
			log(ILog.INFO, "ReviewMyBenefitsEJBBean::storeRMBSMRFComents:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			FwMessageList validationInfo = null;
			final Map pageCollection = txnBean.getPageCollection();
			final ReviewMyBenefitsBO rmbBO = new ReviewMyBenefitsBO();
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			final String aatype = (String) session
					.get(FwConstants.ACCESS_APPLICATION_TYPE);
			final String sendCommentstxt = (String) request.get("sendComments");
			final APP_CMT_Collection appCmntBeforeColl = (APP_CMT_Collection) beforeColl
					.get("APP_CMT_Collection");
			final APP_CMT_Collection appCmntBeforeCollExits = (APP_CMT_Collection) beforeColl
					.get("APP_CMT_Collection_exits");
			String rwoAction = FwConstants.ROWACTION_INSERT;

			validationInfo = rmbBO.validateRMBComments(sendCommentstxt);
			if (validationInfo != null && validationInfo.hasMessages()) {
				request.put(FwConstants.MESSAGE_LIST, validationInfo);

				if (!appCmntBeforeColl.isEmpty()) {
					appCmntBeforeColl.getCargo(0).setCmt_txt(sendCommentstxt);
				} else {
					final APP_CMT_Cargo cmntCargo = new APP_CMT_Cargo();
					cmntCargo.setApp_num(appNum);
					cmntCargo.setCmt_txt(sendCommentstxt);
					cmntCargo.setCmt_tms(String.valueOf(fwDate.getTimestamp()));
					cmntCargo.setApp_typ(aatype);
					appCmntBeforeColl.addCargo(cmntCargo);
				}

				pageCollection.put("APP_CMT_Collection", appCmntBeforeColl);
				pageCollection.put("close_window", FwConstants.NO);
				request.put("Validation", FwConstants.YES);
				txnBean.setPageCollection(pageCollection);
				txnBean.setRequest(request);
				return;
			}

			if (appCmntBeforeCollExits != null
					&& !appCmntBeforeCollExits.isEmpty()) {
				rwoAction = FwConstants.ROWACTION_UPDATE;
			}
			final APP_CMT_Cargo cmntCargo = new APP_CMT_Cargo();
			cmntCargo.setApp_num(appNum);
			cmntCargo.setCmt_txt(sendCommentstxt);
			cmntCargo.setCmt_tms(String.valueOf(fwDate.getTimestamp()));
			cmntCargo.setApp_typ(aatype);
			cmntCargo.setRowAction(rwoAction);

			final APP_CMT_Collection cmntColl = new APP_CMT_Collection();
			cmntColl.addCargo(cmntCargo);
			rmbBO.storeRMBComments(cmntColl);

			log(ILog.INFO, "ReviewMyBenefitsEJBBean::storeRMBSMRFComents:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("storeRMBSMRFComents");
			we.setFwException(fe);
			throw exceptionManagerLog(fe, getClass().getName(), "storeRMBSMRFComents");
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"storeRMBSMRFComents", e);
			throw exceptionManagerLog(fe, getClass().getName(), "storeRMBSMRFComents");
		}
		log(ILog.INFO,
				"ReviewMyBenefitsEJBBean.storeRMBSMRFComents() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Load potential eligibility result.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 * @throws javax.ejb.EJBException the javax.ejb. ejb exception
	 */
	public void loadPotentialEligibilityResult(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"ReviewMyBenefitsEJBBean.loadPotentialEligibilityResult() - START");
		try {
			log(ILog.INFO,
					"ReviewMyBenefitsEJBBean::loadPotentialEligibilityResult:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			Map beforeColl = (Map) session.get(FwConstants.BEFORE_COLLECTION);

			final short[] programKeyArray = (short[]) session
					.get(FwConstants.RMC_PROGRAM_KEY);
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);

			final RMBCorePlanRenewalsBO claRenewalBO = new RMBCorePlanRenewalsBO();
			final RMBPotentialEligibilityBO ptlEligBO = new RMBPotentialEligibilityBO();

			boolean isCLARenewal = false;
			String isOtherPrgmRenewal = FwConstants.NO;

			final boolean isWaitListON = claRenewalBO.isWaitListON();
			boolean isPEPageRequired = false;

			// check is CLA renewals
			if (programKeyArray[7] == 1) {
				isCLARenewal = true;
			}
			// check is other programs renewals
			if (programKeyArray[0] == 1 || programKeyArray[2] == 1
					|| programKeyArray[4] == 1 || programKeyArray[8] == 1) {
				isOtherPrgmRenewal = FwConstants.YES;
			}

			// get renewals custom collection from session
			final CLA_Renewal_Custom_Collection renewalColl = (CLA_Renewal_Custom_Collection) session
					.get("CLA_Renewal_Custom_Collection");
			// get all cla individuals (existing + moved-in)
			final List claIndvList = claRenewalBO
					.getAllCLAIndividuals(renewalColl);

			if (claIndvList.isEmpty()) {
				isPEPageRequired = false;
			}

			if (isCLARenewal && !claIndvList.isEmpty()) {

				final PeopleHandler peopleHandler = (PeopleHandler) session
						.get(AppConstants.INDIV_MASTER_HANDLER);
				final List movedOutIndvList = peopleHandler
						.getAllMovedOutIndividuals();

				final RMC_IN_PRFL_Collection sessRMCInPrfl = (RMC_IN_PRFL_Collection) session
						.get(AppConstants.RMC_IN_PRFL_MASTER);
				final Map ptnElgRsltMap = ptlEligBO
						.potentialEligCheckForCLAIndividuals(appNum,
								sessRMCInPrfl, claIndvList, movedOutIndvList,
								renewalColl);

				// put household income map into page collection
				pageCollection.put("Income_Det_Map",
						ptnElgRsltMap.get("Income_Det_Map"));

				final Map incomeDetMap = (Map) ptnElgRsltMap
						.get("Income_Det_Map");
				session.put("House_Hold_Income",
						incomeDetMap.get("House_Hold_Income"));

				final Map claIndvMap = ptlEligBO.getCLAIndvDet(renewalColl,
						movedOutIndvList);

				final List existCLAIndvList = (List) claIndvMap
						.get("EXIST_CLA_LIST");
				final List newCLAIndvList = (List) claIndvMap
						.get("NEW_CLA_LIST");

				// put into pagecollection
				pageCollection.put("EXIST_CLA_LIST", existCLAIndvList);
				pageCollection.put("NEW_CLA_LIST", newCLAIndvList);

				final APP_PTNL_ELG_RSLT_Collection peElgRsltColl = (APP_PTNL_ELG_RSLT_Collection) ptnElgRsltMap
						.get("APP_PTNL_ELG_RSLT_Collection");
				final APP_PTNL_INELG_RSN_Collection peElgRsnColl = (APP_PTNL_INELG_RSN_Collection) ptnElgRsltMap
						.get("APP_PTNL_INELG_RSN_Collection");
				pageCollection.put("APP_PTNL_ELG_RSLT_Collection",
						peElgRsltColl);
				pageCollection.put("APP_PTNL_INELG_RSN_Collection",
						peElgRsnColl);

				// now updated CLA_Renewals Custom Colleaction with PE result
				final CLA_Renewal_Custom_Collection claRenewalColl = (CLA_Renewal_Custom_Collection) session
						.get("CLA_Renewal_Custom_Collection");
				for (int i = 0; i < peElgRsltColl.size(); i++) {
					claRenewalBO.updateIndvPEResult(claRenewalColl,
							peElgRsltColl.getCargo(i).getIndv_seq_num(),
							peElgRsltColl.getCargo(i).getElg_rslt_ind());
				}

				final List exstPEIndvList = new ArrayList();
				final List exstNonPEIndvList = new ArrayList();
				final List newPEIndvList = new ArrayList();
				final List newNonPEIndvList = new ArrayList();

				// loop APP_PTNL_ELG_RSLT_Collection
				for (int i = 0; i < peElgRsltColl.size(); i++) {
					if (existCLAIndvList.contains(peElgRsltColl.getCargo(i)
							.getIndv_seq_num())) {
						if (FwConstants.YES.equals(peElgRsltColl.getCargo(i)
								.getElg_rslt_ind())) {
							exstPEIndvList.add(peElgRsltColl.getCargo(i)
									.getIndv_seq_num());
						} else {
							exstNonPEIndvList.add(peElgRsltColl.getCargo(i)
									.getIndv_seq_num());
						}
					} else if (newCLAIndvList.contains(peElgRsltColl
							.getCargo(i).getIndv_seq_num())) {
						if (FwConstants.YES.equals(peElgRsltColl.getCargo(i)
								.getElg_rslt_ind())) {
							newPEIndvList.add(peElgRsltColl.getCargo(i)
									.getIndv_seq_num());
						} else {
							newNonPEIndvList.add(peElgRsltColl.getCargo(i)
									.getIndv_seq_num());
						}
					}
				}

				pageCollection.put("EXIST_PE_INDV_LIST", exstPEIndvList);
				pageCollection.put("EXIST_NON_PE_INDV_LIST", exstNonPEIndvList);
				pageCollection.put("NEW_PE_INDV_LIST", newPEIndvList);
				pageCollection.put("NEW_NON_PE_INDV_LIST", newNonPEIndvList);

				// check conditions now
				if (newCLAIndvList.isEmpty()) {
					if (null!=exstPEIndvList && !exstPEIndvList.isEmpty()) {
						isPEPageRequired = false;
					} else if (null!=exstNonPEIndvList && !exstNonPEIndvList.isEmpty()) {
						isPEPageRequired = true;
						pageCollection.put("EXIST_INDV_SEC", FwConstants.YES);
						pageCollection.put("EXIST_INDV_SEC_TYPE", "NE");
						pageCollection.put("IS_OTHER_PRGM_RQST",
								isOtherPrgmRenewal);
						pageCollection.put("NEW_INDV_SEC", FwConstants.NO);

					}
				} else {
					if (null!=newPEIndvList && !newPEIndvList.isEmpty()) {// new indv is PE
						if (!isWaitListON) {// if wait list is off
							isPEPageRequired = false;
						} else {// if wait list is on
							if (null!=exstPEIndvList && !exstPEIndvList.isEmpty()) {
								pageCollection.put("EXIST_INDV_SEC",
										FwConstants.YES);
								pageCollection.put("EXIST_INDV_SEC_TYPE", "PE");
							} else {
								if (null!=exstNonPEIndvList && !exstNonPEIndvList.isEmpty()) {
									pageCollection.put("EXIST_INDV_SEC",
											FwConstants.YES);
									pageCollection.put("EXIST_INDV_SEC_TYPE",
											"NE");
								} else {
									pageCollection.put("EXIST_INDV_SEC",
											FwConstants.NO);
									pageCollection.put("EXIST_INDV_SEC_TYPE",
											FwConstants.EMPTY_STRING);
								}
							}
							isPEPageRequired = true;
							pageCollection.put("IS_OTHER_PRGM_RQST",
									isOtherPrgmRenewal);
							pageCollection.put("NEW_INDV_SEC", FwConstants.YES);
							pageCollection
							.put("WAITLIST_FLAG", FwConstants.YES);
							pageCollection.put("NEW_INDV_SEC_TYPE", "WL");

							final INDIVIDUAL_Custom_Collection wlIndvCustColl = new INDIVIDUAL_Custom_Collection();
							for (int i = 0; i < newPEIndvList.size(); i++) {
								wlIndvCustColl.addCargo(peopleHandler
										.getIndividual(newPEIndvList.get(i)
												.toString()));
							}
							pageCollection.put("WAIT_LIST_INDV_COLL",
									wlIndvCustColl);

						}
					} else {// new indv is not PE
						if (null!=exstPEIndvList && !exstPEIndvList.isEmpty()) {// existing indv is PE
							if (!isWaitListON) {// if wait list is off
								isPEPageRequired = false;
							} else {// if wait list is on
								isPEPageRequired = true;
								pageCollection.put("EXIST_INDV_SEC",
										FwConstants.YES);
								pageCollection.put("EXIST_INDV_SEC_TYPE", "PE");

								pageCollection.put("NEW_INDV_SEC",
										FwConstants.YES);
								pageCollection.put("WAITLIST_FLAG",
										FwConstants.YES);

								pageCollection.put("NEW_INDV_SEC_TYPE", "PE");
							}
						} else {// existing indv is non PE
							isPEPageRequired = true;
							if (null!=exstNonPEIndvList && !exstNonPEIndvList.isEmpty()) {
								pageCollection.put("EXIST_INDV_SEC",
										FwConstants.YES);
								pageCollection.put("EXIST_INDV_SEC_TYPE", "NE");
							} else {
								pageCollection.put("EXIST_INDV_SEC",
										FwConstants.NO);
								pageCollection.put("EXIST_INDV_SEC_TYPE",
										FwConstants.EMPTY_STRING);
							}
							pageCollection.put("IS_OTHER_PRGM_RQST",
									isOtherPrgmRenewal);

							pageCollection.put("NEW_INDV_SEC", FwConstants.YES);
							pageCollection
							.put("WAITLIST_FLAG", FwConstants.YES);

							pageCollection.put("NEW_INDV_SEC_TYPE", "PE");

						}
					}
				}
				if (pageCollection.get("EXIST_INDV_SEC_TYPE") != null
						&& "NE".equals(pageCollection
								.get("EXIST_INDV_SEC_TYPE").toString())) {
					if (FwConstants.YES.equals(isOtherPrgmRenewal)) {
						pageCollection.put("RADIO_OPTION", FwConstants.NO);
						pageCollection.put("CHECK_BOX_OPTION", FwConstants.YES);
					} else if (FwConstants.NO.equals(isOtherPrgmRenewal)) {
						if (pageCollection.get("NEW_INDV_SEC_TYPE") != null
								&& "WL".equals(pageCollection.get(
										"NEW_INDV_SEC_TYPE").toString())) {
							pageCollection.put("RADIO_OPTION", FwConstants.NO);
							pageCollection.put("CHECK_BOX_OPTION",
									FwConstants.YES);
						} else {
							pageCollection.put("RADIO_OPTION", FwConstants.YES);
							pageCollection.put("CHECK_BOX_OPTION",
									FwConstants.NO);
						}

					}
				}
				session.put(FwConstants.BEFORE_COLLECTION, pageCollection);
			}// main if

			if (!isCLARenewal || !isPEPageRequired) {// no need to load PE
				// result page
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"ARPER", driverArray, appNum);
				request.put(FwConstants.NEXT_PAGE_ID, "ARFAS");
				request.put(FwConstants.NEXT_PAGE_ACTION, "ARFASLoad");
				componentManager.getComponents("ARFAS", txnBean);
			}
			if (beforeColl == null) {
				beforeColl = new HashMap();
				session.put(FwConstants.BEFORE_COLLECTION, beforeColl);
			}

			// put back previously selected options if user is comming from
			// final application submission
			if (request.get(FwConstants.PREVIOUS_PAGE_ID) != null
					&& "ARFAS"
					.equals(request.get(FwConstants.PREVIOUS_PAGE_ID))) {
				final APP_PTNL_ELG_RSLT_Collection peElgColl = (APP_PTNL_ELG_RSLT_Collection) beforeColl
						.get("APP_PTNL_ELG_RSLT_Collection");
				final APP_IN_CP_WLST_Collection appInWlstColl = (APP_IN_CP_WLST_Collection) beforeColl
						.get("APP_IN_CP_WLST_Collection");

				if (peElgColl != null && !peElgColl.isEmpty()) {
					peElgColl.getCargo(0).getPgm_rqst_resp();
					if (FwConstants.YES.equals(peElgColl.getCargo(0)
							.getPgm_rqst_resp())) {
						pageCollection.put("PREV_USER_OPTION", "R");
					}
				}

				if (appInWlstColl != null && !appInWlstColl.isEmpty()) {
					pageCollection.put("PREV_WLST_OPTION", FwConstants.YES);
				} else {
					pageCollection.put("PREV_WLST_OPTION", FwConstants.NO);
				}

			}

			beforeColl.putAll(pageCollection);

			log(ILog.INFO,
					"ReviewMyBenefitsEJBBean::loadPotentialEligibilityResult:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("loadPotentialEligibilityResult");
			we.setFwException(fe);
			throw exceptionManagerLog(fe, getClass().getName(), "loadPotentialEligibilityResult");
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"loadPotentialEligibilityResult", e);
			throw exceptionManagerLog(fe, getClass().getName(), "loadPotentialEligibilityResult");
		}
		log(ILog.INFO,
				"ReviewMyBenefitsEJBBean.loadPotentialEligibilityResult() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Store potential eligibility result.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void storePotentialEligibilityResult(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"ReviewMyBenefitsEJBBean.storePotentialEligibilityResult() - START");
		try {
			log(ILog.INFO,
					"ReviewMyBenefitsEJBBean::storePotentialEligibilityResult:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();

			final Map pageCollection = txnBean.getPageCollection();
			final Map beforeCollection = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);
			request.get(FwConstants.CURRENT_PAGE_ID);
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			request.get(FwConstants.PAGE_ACTION);

			final String noOneCLA = FwConstants.EMPTY_STRING;
			String radioOption = FwConstants.EMPTY_STRING;
			String checkBoxOption = FwConstants.EMPTY_STRING;
			String userOption = FwConstants.EMPTY_STRING;
			boolean processAbandonFlag = false;
			APP_PTNL_ELG_RSLT_Collection peElgColl = null;
			final AFBValidationBO validatorObj = new AFBValidationBO();
			boolean validationFlag = false;

			if (beforeCollection != null) {
				radioOption = (String) beforeCollection.get("RADIO_OPTION");
				checkBoxOption = (String) beforeCollection
						.get("CHECK_BOX_OPTION");

				peElgColl = (APP_PTNL_ELG_RSLT_Collection) beforeCollection
						.get("APP_PTNL_ELG_RSLT_Collection");
			}

			// back to my acess warring
			if (checkBackToMyAccessSelected(request)) {
				pageCollection.putAll(beforeCollection);
				return;
			}

			// wait list validation
			final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) pageCollection
					.get("RMC_IN_PRFL_Collection");
			String waitListFlag = FwConstants.EMPTY_STRING;
			if (beforeCollection.get("NEW_INDV_SEC_TYPE") != null) {
				waitListFlag = (String) beforeCollection
						.get("NEW_INDV_SEC_TYPE");
			}
			if (waitListFlag != null && "WL".equals(waitListFlag)) {
				String tempNoOne = null;
				if (request.get("NoOne_WAITLIST") != null) {
					tempNoOne = request.get("NoOne_WAITLIST").toString();
				}
				if ((rmcInPrflColl == null || rmcInPrflColl.isEmpty())
						&& tempNoOne == null) {
					validatorObj.addMessageCode("60046");
					validationFlag = true;
				} else if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()
						&& tempNoOne != null
						&& FwConstants.YES.equals(tempNoOne)) {
					validatorObj.addMessageCode("60051");
					pageCollection.put("PREV_WLST_OPTION", "B");
					validationFlag = true;
				}
			}
			// user option validation
			if (radioOption != null && FwConstants.YES.equals(radioOption)
					&& checkBoxOption != null
					&& FwConstants.NO.equals(checkBoxOption)) {
				userOption = (String) request.get("radioGroup");
				if (userOption == null) {// user must select either one option
					// Validation message not needed when no one is CLA
					if (!noOneCLA.equals(FwConstants.YES)) {
						validatorObj.addMessageCode("60097");
						validationFlag = true;
					}
				}

			}

			if (validationFlag) {
				request.put(FwConstants.MESSAGE_LIST,
						validatorObj.getMessageList());
				pageCollection.putAll(beforeCollection);
				return;
			}

			if (radioOption != null && FwConstants.YES.equals(radioOption)
					&& checkBoxOption != null
					&& FwConstants.NO.equals(checkBoxOption)) {
				userOption = (String) request.get("radioGroup");
				// if user select an option either to continue or to exit
				if ("continue".equals(userOption)) {// continue
					final int collSize = peElgColl.size();
					for (int i = 0; i < collSize; i++) {
						peElgColl.getCargo(i).setPgm_rqst_resp(FwConstants.YES);
					}
				} else if ("stop".equals(userOption)) {// stop
					final int collSize = peElgColl.size();
					for (int i = 0; i < collSize; i++) {
						peElgColl.getCargo(i).setPgm_rqst_resp(FwConstants.NO);
					}
					processAbandonFlag = true;

				}
			} else if (radioOption != null
					&& FwConstants.NO.equals(radioOption)
					&& checkBoxOption != null
					&& FwConstants.YES.equals(checkBoxOption)) {
				// other programs request along with HC
				final String checkBoxValue = (String) request
						.get("electronicSignature_app");
				final int collSize = peElgColl.size();
				for (int i = 0; i < collSize; i++) {
					if (FwConstants.NO.equals(peElgColl.getCargo(i)
							.getElg_rslt_ind())) {
						if (checkBoxValue != null
								&& FwConstants.ONE.equals(checkBoxValue)) {
							peElgColl.getCargo(i).setPgm_rqst_resp(
									FwConstants.YES);
						} else {
							peElgColl.getCargo(i).setPgm_rqst_resp(
									FwConstants.NO);
						}
					} else {
						peElgColl.getCargo(i).setPgm_rqst_resp(FwConstants.YES);
					}

				}
			}

			// waitlist logic
			if (waitListFlag != null && "WL".equals(waitListFlag)) {
				final APP_IN_CP_WLST_Collection appInWlstColl = new APP_IN_CP_WLST_Collection();
				APP_IN_CP_WLST_Cargo appInWlstCargo = null;
				final ABFinalSubmitBO finalBO = new ABFinalSubmitBO();

				long wlstNum = finalBO.getMaximumWaitlistNum();
				if (rmcInPrflColl != null && rmcInPrflColl.isEmpty()) {
					processAbandonFlag = false;
					for (int i = 0; i < rmcInPrflColl.size(); i++) {
						appInWlstCargo = new APP_IN_CP_WLST_Cargo();
						appInWlstCargo.setApp_num(appNum);
						appInWlstCargo.setIndv_seq_num(rmcInPrflColl
								.getCargo(i).getIndv_seq_num());
						appInWlstCargo.setWlst_num(String.valueOf(++wlstNum));
						appInWlstCargo
						.setRowAction(FwConstants.ROWACTION_INSERT);
						appInWlstColl.addCargo(appInWlstCargo);

					}
				}
				beforeCollection
				.put("APP_IN_CP_WLST_Collection", appInWlstColl);
			}

			// NOW UPDATE THE FEE_RQR_IND IN RMB_RQST TABLE
			final RMB_RQST_Collection rmbRqstColl = (RMB_RQST_Collection) session
					.get("RMB_RQST_COLLECTION");
			final RMB_RQST_Cargo rmbRqstCargo = rmbRqstColl.getCargo(0);
			final RMBRequestManager rmbReqManger = new RMBRequestManager();
			final RMBCorePlanRenewalsBO renewalBO = new RMBCorePlanRenewalsBO();
			final CLA_Renewal_Custom_Collection renewalColl = (CLA_Renewal_Custom_Collection) session
					.get("CLA_Renewal_Custom_Collection");

			if (renewalBO.isFeeRequired(renewalColl, peElgColl)) {// is fee
				// required
				rmbRqstCargo.setFee_rqr_ind(FwConstants.YES);
			} else {
				rmbRqstCargo.setFee_rqr_ind(FwConstants.NO);
			}

			rmbReqManger.storeRMBRqst(rmbRqstColl);

			if (processAbandonFlag) {
				final SessionManagementBO sessionManagementBO = new SessionManagementBO();
				sessionManagementBO.clearRMCSession(txnBean.getSession());
				request.put(FwConstants.NEXT_PAGE_ID, "AMHME");
				request.put(FwConstants.NEXT_PAGE_ACTION, "LoadMyAccess");
			}

			driverManager.makeComplete(FwConstants.RMC_DRIVER, "ARPER",
					driverArray, appNum);

			log(ILog.INFO,
					"ReviewMyBenefitsEJBBean::storePotentialEligibilityResult:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("storePotentialEligibilityResult");
			we.setFwException(fe);
			throw exceptionManagerLog(fe, getClass().getName(), "storePotentialEligibilityResult");
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"storePotentialEligibilityResult", e);
			throw exceptionManagerLog(fe, getClass().getName(), "storePotentialEligibilityResult");
		}

		log(ILog.INFO,
				"ReviewMyBenefitsEJBBean.storePotentialEligibilityResult() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}
}
