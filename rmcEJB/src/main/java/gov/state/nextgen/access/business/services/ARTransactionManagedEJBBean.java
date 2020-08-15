/*
 *
 */
package gov.state.nextgen.access.business.services;


import gov.state.nextgen.access.business.customEntities.APP_ABS_PRNT_Cust_Collection;
import gov.state.nextgen.access.business.customEntities.INDIVIDUAL_Custom_Cargo;
import gov.state.nextgen.access.business.customEntities.INDIVIDUAL_Custom_Collection;
import gov.state.nextgen.access.business.customEntities.JOBINCOME_Custom_Collection;
import gov.state.nextgen.access.business.customEntities.RMC_CUSTOM_COLLECTION;
import gov.state.nextgen.access.business.entities.APP_AUTH_REP_Cargo;
import gov.state.nextgen.access.business.entities.APP_AUTH_REP_Collection;
import gov.state.nextgen.access.business.entities.APP_HSHL_RLT_Collection;
import gov.state.nextgen.access.business.entities.APP_INDV_Cargo;
import gov.state.nextgen.access.business.entities.APP_INDV_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_ABSNP_Cargo;
import gov.state.nextgen.access.business.entities.APP_IN_ABSNP_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_DABL_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_EMPL_A_WAGE_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_EMPL_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_MEDCR_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_NEWB_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_PLAN_HLTH_BABIES_Cargo;
import gov.state.nextgen.access.business.entities.APP_IN_PLAN_HLTH_BABIES_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_PREG_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_SCHLE_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_SELFE_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_SHLTC_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_UEI_Cargo;
import gov.state.nextgen.access.business.entities.APP_IN_UEI_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_UTILC_Collection;
import gov.state.nextgen.access.business.entities.APP_PGM_RQST_Cargo;
import gov.state.nextgen.access.business.entities.APP_PGM_RQST_Collection;
import gov.state.nextgen.access.business.entities.APP_PRIR_SRV_Cargo;
import gov.state.nextgen.access.business.entities.APP_PRIR_SRV_Collection;
import gov.state.nextgen.access.business.entities.APP_RGST_Collection;
import gov.state.nextgen.access.business.entities.APP_RQST_Cargo;
import gov.state.nextgen.access.business.entities.APP_RQST_Collection;
import gov.state.nextgen.access.business.entities.APP_SBMS_Cargo;
import gov.state.nextgen.access.business.entities.APP_SBMS_Collection;
import gov.state.nextgen.access.business.entities.APP_USER_ADDITIONAL_INFO_Cargo;
import gov.state.nextgen.access.business.entities.APP_USER_ADDITIONAL_INFO_Collection;
import gov.state.nextgen.access.business.entities.APP_USER_Cargo;
import gov.state.nextgen.access.business.entities.APP_USER_Collection;
import gov.state.nextgen.access.business.entities.BNFT_CASE_ADR_Collection;
import gov.state.nextgen.access.business.entities.BNFT_INDV_CASE_Cargo;
import gov.state.nextgen.access.business.entities.BNFT_INDV_CASE_Collection;
import gov.state.nextgen.access.business.entities.CP_DOL_UCB_RESP_Cargo;
import gov.state.nextgen.access.business.entities.CP_DOL_UCB_RESP_Collection;
import gov.state.nextgen.access.business.entities.CP_DOL_WAGES_INFO_Cargo;
import gov.state.nextgen.access.business.entities.CP_DOL_WAGES_INFO_Collection;
import gov.state.nextgen.access.business.entities.CP_RTE_VERF_Cargo;
import gov.state.nextgen.access.business.entities.CP_RTE_VERF_Collection;
import gov.state.nextgen.access.business.entities.INDV_LIVE_CHG_Collection;
import gov.state.nextgen.access.business.entities.RMB_RQST_Cargo;
import gov.state.nextgen.access.business.entities.RMB_RQST_Collection;
import gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Cargo;
import gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Collection;
import gov.state.nextgen.access.business.entities.RMC_PDF_DOC_Cargo;
import gov.state.nextgen.access.business.entities.RMC_PDF_DOC_Collection;
import gov.state.nextgen.access.business.entities.RMC_RQST_Cargo;
import gov.state.nextgen.access.business.entities.RMC_RQST_Collection;
import gov.state.nextgen.access.business.entities.SSA_CMPS_SVC_RESPONSE_Cargo;
import gov.state.nextgen.access.business.entities.SSA_CMPS_SVC_RESPONSE_Collection;
import gov.state.nextgen.access.business.rules.ABCreateAppNumBO;
import gov.state.nextgen.access.business.rules.ABFinalSubmitBO;
import gov.state.nextgen.access.business.rules.ABHouseHoldRelationshipBO;
import gov.state.nextgen.access.business.rules.ABNextStepsOverviewBO;
import gov.state.nextgen.access.business.rules.ABPreSubmitBO;
import gov.state.nextgen.access.business.rules.ABPriorityServiceBO;
import gov.state.nextgen.access.business.rules.ABProgramInformationBO;
import gov.state.nextgen.access.business.rules.ABSaveAndExitBO;
import gov.state.nextgen.access.business.rules.AFBAppRegBO;
import gov.state.nextgen.access.business.rules.AFBUtil;
import gov.state.nextgen.access.business.rules.DOLWebServiceBO;
import gov.state.nextgen.access.business.rules.ExtractRMBApplicationDetailsBO;
import gov.state.nextgen.access.business.rules.ExtractRMCApplicationDetailsBO;
import gov.state.nextgen.access.business.rules.GenerateNextCntlNumBO;
import gov.state.nextgen.access.business.rules.ProcessApplicationBO;
import gov.state.nextgen.access.business.rules.RMBReceiveWebServiceBO;
import gov.state.nextgen.access.business.rules.RTEWebserviceBO;
import gov.state.nextgen.access.business.rules.ReviewMyBenefitsBO;
import gov.state.nextgen.access.business.rules.SSAWebServiceBO;
import gov.state.nextgen.access.business.rules.assets.LiquidAssetBO;
import gov.state.nextgen.access.business.rules.benefitcase.ContactInformationBO;
import gov.state.nextgen.access.business.rules.employment.JobIncomeBO;
import gov.state.nextgen.access.business.rules.employment.OtherIncomeBO;
import gov.state.nextgen.access.business.rules.employment.SelfEmploymentBO;
import gov.state.nextgen.access.business.rules.expenses.ShelterCostsBO;
import gov.state.nextgen.access.business.rules.expenses.UtilityCostsBO;
import gov.state.nextgen.access.business.rules.household.AbsentParentBO;
import gov.state.nextgen.access.business.rules.household.DisabilityBO;
import gov.state.nextgen.access.business.rules.household.HouseHoldInfoBO;
import gov.state.nextgen.access.business.rules.household.LivingArrangementBO;
import gov.state.nextgen.access.business.rules.household.MaritalBO;
import gov.state.nextgen.access.business.rules.household.MovedInBO;
import gov.state.nextgen.access.business.rules.household.PregnancyBO;
import gov.state.nextgen.access.business.rules.household.SchoolEnrollmentBO;
import gov.state.nextgen.access.business.rules.pdf.RMCPdfHelperBO;
import gov.state.nextgen.access.business.utility.RMBrealTimeServiceCall;
import gov.state.nextgen.access.management.applications.IRMCResponseProfileManager;
import gov.state.nextgen.access.management.applications.QuestionsExtractionHandler;
import gov.state.nextgen.access.management.applications.RMBRequestManager;
import gov.state.nextgen.access.management.applications.RMCRequestManager;
import gov.state.nextgen.access.management.constants.AppConstants;
import gov.state.nextgen.access.management.individuals.PeopleHandler;
import gov.state.nextgen.access.management.rules.PeopleRulesBO;
import gov.state.nextgen.access.management.util.IndivTypeSeqBean;
import gov.state.nextgen.access.navigation.RMCNavigationBO;
import gov.state.nextgen.access.presentation.entities.listview.RMBPDFNextStepsListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCSummaryListView;
import gov.state.nextgen.business.ejb.services.st.CallWebService;
import gov.state.nextgen.business.ejb.services.st.appreg.webserviceentities.IndicatorType;
import gov.state.nextgen.business.ejb.services.st.appreg.webserviceentities.String3Type;
import gov.state.nextgen.business.ejb.services.st.appreg.webserviceentities.StringType;
import gov.state.nextgen.business.ejb.services.st.changealert.webserviceentities.CaseChangeResponse;
import gov.state.nextgen.business.ejb.services.st.changealert.webserviceentities.CaseChanges;
import gov.state.nextgen.business.ejb.services.st.pdf.SelfServiceRMCAlertBO;
import gov.state.nextgen.ejb.business.services.dol.BenefitPayments;
import gov.state.nextgen.ejb.business.services.dol.GetUIBenefitInfoOutput;
import gov.state.nextgen.ejb.business.services.dol.GetWagesInput;
import gov.state.nextgen.ejb.business.services.dol.GetWagesResponse;
import gov.state.nextgen.ejb.business.services.dol.benefit.MailingAddress;
import gov.state.nextgen.ejb.business.services.dol.benefit.Response;
import gov.state.nextgen.ejb.business.services.dol.benefit.UiBenefitDetails;
import gov.state.nextgen.ejb.business.services.dol.benefit.UiBenefitInfo;
import gov.state.nextgen.ejb.business.services.dol.wages.EmployerInfo;
import gov.state.nextgen.ejb.business.services.dol.wages.Wage;
import gov.state.nextgen.ejb.business.services.dol.wages.WageInfo;
import gov.state.nextgen.ejb.business.services.fdsh.ResponseMetadataType;
import gov.state.nextgen.ejb.business.services.fdsh.SSACompositeIndividualRequestType;
import gov.state.nextgen.ejb.business.services.fdsh.SSACompositeIndividualResponseType;
import gov.state.nextgen.ejb.business.services.fdsh.SSACompositeRequestType;
import gov.state.nextgen.ejb.business.services.fdsh.SSACompositeResponseType;
import gov.state.nextgen.ejb.business.services.fdsh.SSAResponseType;
import gov.state.nextgen.ejb.business.services.fdsh.SSATitleIIMonthlyIncomeType;
import gov.state.nextgen.ejb.business.services.fdsh.SSATitleIIMonthlyInformationType;
import gov.state.nextgen.ejb.business.services.fdsh.VerifySSAResponse;
import gov.state.nextgen.ejb.business.services.fdsh.VerifySSAResponseE;
import gov.state.nextgen.framework.business.entities.AbstractCargo;
import gov.state.nextgen.framework.business.entities.AbstractCollection;
import gov.state.nextgen.framework.business.entities.FwTransaction;
import gov.state.nextgen.framework.exceptions.ApplicationException;
import gov.state.nextgen.framework.exceptions.FwException;
import gov.state.nextgen.framework.exceptions.FwExceptionManager;
import gov.state.nextgen.framework.exceptions.FwWrappedException;
import gov.state.nextgen.framework.exceptions.IException;
import gov.state.nextgen.framework.factories.FwServiceFactory;
import gov.state.nextgen.framework.management.configuration.FwConfigurationManager;
import gov.state.nextgen.framework.management.configuration.IConfiguration;
import gov.state.nextgen.framework.management.constants.FwConstants;
import gov.state.nextgen.framework.management.logging.wkp.ILog;
import gov.state.nextgen.framework.management.messages.FwMessageList;
import gov.state.nextgen.framework.management.references.IReferenceTableManager;
import gov.state.nextgen.framework.management.references.ReferenceTableManager;
import gov.state.nextgen.framework.management.util.FwDataCriteria;
import gov.state.nextgen.framework.security.utility.CommonInstanceCreator;

import java.io.ByteArrayOutputStream;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.StringTokenizer;

import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;


/**
 * Enter the description of the class.
 *
 * @author nathsu Creation Date Jul 5, 2006 Modified By: Modified on: PCR#
 */

/* ************************************************************************************
 * ***************** SONAR FIXES MADE IN THIS CODE
 * ************************************** ISSUE DESCRIPTION NATURE OF FIX DATE
 * **** ================== ============= **** **** Avoid commented code Deleted
 * Commented code 09/4/2015 ** Lage Blocks of commented code *** are converted
 * to javadoc *** **
 * *************************************************************
 * *************************
 */
@javax.ejb.Stateless
@javax.ejb.LocalBean
@javax.ejb.TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class ARTransactionManagedEJBBean extends BeanManagedTxnSessionBeanEjb3 {

	/** The my session ctx. */
	@Resource
	private javax.ejb.SessionContext mySessionCtx;

	/** The logger. */
    private ILog logger;
    @Override
   	protected void log(final int level, final String message) {
   		if (logger == null) {
   			logger = (ILog) FwServiceFactory.getInstance().create(ILog.class);
   		}
   		logger.log(this.getClass(), level, message);
   	}

	/**
	 * Instantiates a new AR transaction managed ejb bean.
	 */
	public ARTransactionManagedEJBBean() {
	}

	/**
	 * Store rmb landing page.
	 *
	 * @param txnBean
	 *            the txn bean
	 * @throws EJBException
	 *             the EJB exception
	 * @throws javax.ejb.EJBException
	 *             the javax.ejb. ejb exception
	 */
	public void storeRMBLandingPage(final FwTransaction txnBean)
			throws javax.ejb.EJBException {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"ARTransactionManagedEJBBean.storeRMBLandingPage() - START");
		try {
			log(ILog.INFO,
					"ARTransactionManagedEJBBean::storeRMBLandingPage:Start");
			log(ILog.INFO, "store called");
			// Getting the session
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);
			int[] driverArray = null;
			final PeopleHandler peopleHandler = new PeopleHandler();
			String appNumber = null;
			final Map httpSessionMap = (Map) session
					.get(FwConstants.HTTP_SESSION);
			httpSessionMap.get(FwConstants.SECURED_SESSION);
			final JobIncomeBO jobBo = new JobIncomeBO();
			final ReviewMyBenefitsBO reviewBenfBO = new ReviewMyBenefitsBO();

			String languageCd = (String) httpSessionMap.get(AppConstants.LANGUAGE);
			if ((languageCd == null) || (languageCd.trim().length() == 0)) {
				languageCd = "EN";
			}
			// validation

			final RMBRequestManager rmbRqstManager = new RMBRequestManager();
			final RMB_RQST_Collection rmbRqstColl = new RMB_RQST_Collection();
			final QuestionsExtractionHandler extractionHandler = new QuestionsExtractionHandler();

			FwMessageList validateInfo = null;
			// validation
			final APP_PGM_RQST_Collection appPgmRqstColl = (APP_PGM_RQST_Collection) pageCollection
					.get("APP_PGM_RQST_Collection");
			APP_PGM_RQST_Cargo appPgmRqstCargo = null;
			if (appPgmRqstColl != null) {
				appPgmRqstCargo = appPgmRqstColl.getCargo(0);
			}

			final String backToMyAccess = (String) request
					.get(AppConstants.BACK_TO_MY_ACCESS_BUTTON);
			final Map reviewDetMap = (HashMap) beforeColl
					.get("RMB_PRGM_DET_MAP");
			APP_PGM_RQST_Collection beforePgmColl = (APP_PGM_RQST_Collection) beforeColl.get("APP_PGM_RQST_Collection");
			APP_PGM_RQST_Cargo beforePgmCargo = beforePgmColl.getCargo(0);
			if (backToMyAccess == null) {
				validateInfo = reviewBenfBO.validateRMBLandingPage(
						reviewDetMap, appPgmRqstColl,beforePgmCargo, languageCd);
			}

			if (checkBackToMyAccessSelected(request) || validateInfo != null
					&& validateInfo.hasMessages()) {
				final String reqWarningMsgs = (String) request
						.get(FwConstants.WARNING_MSG_DETAILS);
				if (!checkForWarningMesgs(reqWarningMsgs,
						reviewBenfBO.getMessageList())) {
					if (backToMyAccess == null) {
						request.put(FwConstants.MESSAGE_LIST,
								reviewBenfBO.getMessageList());
					}
					request.put("RMB_PRGM_DET_MAP",
							beforeColl.get("RMB_PRGM_DET_MAP"));
					pageCollection.putAll(beforeColl);
					pageCollection.put("APP_PGM_RQST_Collection",appPgmRqstColl);
					txnBean.setPageCollection(pageCollection);
					txnBean.setRequest(request);
					return;
				}
			}
			String caseNumber = null;
			if (session.containsKey(AppConstants.REVIEW_CASE_NUM)) {
				caseNumber = (String) session.get(AppConstants.REVIEW_CASE_NUM);
			}

			if (caseNumber != null) {
				final ABCreateAppNumBO createAppNumBo = new ABCreateAppNumBO();
				if (session.containsKey(AppConstants.APP_NUMBER)) {
					appNumber = (String) session.get(AppConstants.APP_NUMBER);
				}

				final Map httpSession = (Map) session
						.get(FwConstants.HTTP_SESSION);
				String acsId = FwConstants.EMPTY_STRING;
				if ((Map) httpSession.get(FwConstants.SECURED_SESSION) != null) {
					acsId = (String) ((Map) httpSession
							.get(FwConstants.SECURED_SESSION)).get("wid");
				}
				createAppNumBo.storeAcsIdAndAppNum(acsId, appNumber);
				javaTransactionSuccess();

				startJavaTransaction(mySessionCtx);
				// now we need to create the session, program key amd
				// peoplehandler
				// finding the agency contact number
				final String agencyCntNumber = jobBo
						.getAgencyContactNo(caseNumber);
				pageCollection.put(AppConstants.AGENCY_CONTACT_NO,
						agencyCntNumber);

				// make transaction success
				javaTransactionSuccess();

				// vulebribility check
				// add new app_number to USER_APP_NUM_LIST - PCR# 43100
				final Map securedMap = (Map) httpSession
						.get(FwConstants.SECURED_SESSION);

				if (securedMap != null) {
					String appNum = appNumber;
					if (appNum != null) {
						appNum = appNum.replaceAll("^0*",
								FwConstants.EMPTY_STRING);
						List appNumList = (List) securedMap
								.get("USER_APP_NUM_LIST");
						if (appNumList != null) {
							appNumList.add(appNum);
						} else {
							appNumList = new ArrayList();
							appNumList.add(appNum);
							securedMap.put("USER_APP_NUM_LIST", appNumList);
						}
					}
				}

				if (appPgmRqstColl != null && !appPgmRqstColl.isEmpty()) {

					final ABProgramInformationBO programInfoBo = new ABProgramInformationBO();

					appPgmRqstCargo = appPgmRqstColl.getCargo(0);
					if (appPgmRqstCargo.getFs_rqst_ind() == null) {
						appPgmRqstCargo.setFs_rqst_ind(FwConstants.ZERO);
					}
					if (appPgmRqstCargo.getCc_rqst_ind() == null) {
						appPgmRqstCargo.setCc_rqst_ind(FwConstants.ZERO);
					}
					if (appPgmRqstCargo.getFpw_rqst_ind() == null) {
						appPgmRqstCargo.setFpw_rqst_ind(FwConstants.ZERO);
					}
					if (appPgmRqstCargo.getFma_rqst_ind() == null) {
						appPgmRqstCargo.setFma_rqst_ind(FwConstants.ZERO);
					}
					if (appPgmRqstCargo.getFpw_rqst_ind() == null) {
						appPgmRqstCargo.setFpw_rqst_ind(FwConstants.ZERO);
					}
					if (appPgmRqstCargo.getCooling_assistance_rqst_ind() == null) {
						appPgmRqstCargo
								.setCooling_assistance_rqst_ind(FwConstants.ZERO);
					}
					if (appPgmRqstCargo.getFuel_assistance_rqst_ind() == null) {
						appPgmRqstCargo
								.setFuel_assistance_rqst_ind(FwConstants.ZERO);
					}
					if (appPgmRqstCargo.getNoSNAP_rqst_ind() == null) {
						appPgmRqstCargo.setNoSNAP_rqst_ind(FwConstants.ZERO);
					}
					if (appPgmRqstCargo.getTanf_rqst_ind() == null) {
						appPgmRqstCargo.setTanf_rqst_ind(FwConstants.ZERO);
					}
					if (appPgmRqstCargo.getCrisis_assistance_rqst_ind() == null) {
						appPgmRqstCargo
								.setCrisis_assistance_rqst_ind(FwConstants.ZERO);
					}
					if (appPgmRqstCargo.getWic_rqst_ind() == null) {
						appPgmRqstCargo.setWic_rqst_ind(FwConstants.ZERO);
					}
					if (appPgmRqstCargo.getEbd_rqst_ind() == null) {
						appPgmRqstCargo.setEbd_rqst_ind(FwConstants.ZERO);
					}
					if (appPgmRqstCargo.getHc_rqst_ind() == null) {
						appPgmRqstCargo.setHc_rqst_ind(FwConstants.ZERO);
					}
					if (appPgmRqstCargo.getSer_rqst_ind() == null) {
						appPgmRqstCargo.setSer_rqst_ind(FwConstants.ZERO);
					}
					if (appPgmRqstCargo.getMagi_rqst_ind() == null) {
						appPgmRqstCargo.setMagi_rqst_ind(FwConstants.ZERO);
					}
					if (appPgmRqstCargo.getPeach_rqst_ind() == null) {
						appPgmRqstCargo.setPeach_rqst_ind(FwConstants.ZERO);
					}
					if ("1".equals(appPgmRqstCargo.getPeach_rqst_ind())) {
						appPgmRqstCargo.setFma_rqst_ind(FwConstants.ONE);
					}
					appPgmRqstCargo.setApp_num(appNumber);
					appPgmRqstCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
					programInfoBo.updateProgram(appPgmRqstColl);

				}

				// call createCaseNumber on RMB Request Manager
				final RMB_RQST_Cargo rmbRqstCargo = rmbRqstManager
						.createRMBRequest(appNumber, caseNumber);
				rmbRqstColl.addCargo(rmbRqstCargo);

				// find the earlieast review daue date
				final Map rmbDetMap = (Map) beforeColl.get("RMB_PRGM_DET_MAP");
				final Date dueDate = reviewBenfBO
						.findEarliestDueDate(rmbDetMap);

				final RMB_RQST_Cargo rmbRqstUpdateCargo = rmbRqstColl
						.getCargo(0);
				rmbRqstUpdateCargo.setDue_dt(String.valueOf(dueDate));
				// PCR# 43100 - RMB-CLA Renewals changes
				rmbRqstUpdateCargo.setCla_due_dt(String.valueOf(reviewBenfBO
						.findBCLADueDate(rmbDetMap)));
				// if its only CLA renewals than we have to set CLA_DUE_DT as
				// DUE_DT

				if (Date.valueOf(rmbRqstUpdateCargo.getDue_dt()).equals(
						AppConstants.HIGH_DATE_OBJ)) {
					rmbRqstUpdateCargo.setDue_dt(rmbRqstUpdateCargo
							.getCla_due_dt());
				}
				// EDSP CP Temp
				rmbRqstUpdateCargo.setRowAction(FwConstants.ROWACTION_INSERT);
				rmbRqstManager.storeRMBRqst(rmbRqstColl);


				APP_INDV_Collection appIndvColl = null;

				extractionHandler.loadRMBQuestionsSelection();

				peopleHandler.loadPeopleHandler(appNumber);
				appIndvColl = new APP_INDV_Collection();
				final Map sqlMap = new HashMap();
				final FwDataCriteria[] criteria = new FwDataCriteria[1];
				criteria[0] = new FwDataCriteria();
				criteria[0].setColumn_name("APP_NUM");
				// EDSP CP Temp

				criteria[0].setColumn_value(appNumber);
				sqlMap.put(FwConstants.CRITERIA, criteria);
				final APP_INDV_Cargo[] cargoArray = (APP_INDV_Cargo[]) appIndvColl
						.select(FwConstants.DAO, sqlMap);
				for (int i = 0; i < cargoArray.length; i++) {
					appIndvColl.add(cargoArray[i]);
				}

				// now initialize RMC_IN_PRFL for all the individuals in CASE
				final int indvCollSize = appIndvColl.size();
				RMC_IN_PRFL_Cargo rmcInPrflCargo = null;
				final RMC_IN_PRFL_Collection rmcInPrflColl = new RMC_IN_PRFL_Collection();
				for (int i = 0; i < indvCollSize; i++) {
					rmcInPrflCargo = new RMC_IN_PRFL_Cargo();
					rmcInPrflCargo.setApp_num(appNumber);
					rmcInPrflCargo.setIndv_seq_num(appIndvColl.getCargo(i)
							.getIndv_seq_num());
					rmcInPrflCargo = rmcResponseProfileManager
							.createRMCIndividualProfile(rmcInPrflCargo);
					if (FwConstants.ONE
							.equals(rmcInPrflCargo.getIndv_seq_num())) {
						rmcInPrflCargo.setHead_of_household_resp("R");

					}
					rmcInPrflColl.addCargo(rmcInPrflCargo);
				}
				rmcInPrflCargo = new RMC_IN_PRFL_Cargo();
				rmcInPrflCargo.setApp_num(appNumber);
				rmcInPrflCargo.setIndv_seq_num("0");
				rmcInPrflCargo = rmcResponseProfileManager
						.createRMCIndividualProfile(rmcInPrflCargo);
				rmcInPrflColl.addCargo(rmcInPrflCargo);
				// load program key arrray
				final Map detMap = reviewBenfBO
						.loadProgramKeyArrayForRMB(rmbDetMap);
				short[] programKeyArray = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0 };

				/*
				 * VG SONAR Cleanup - 09/4/2015 Deleted 2,1 lines Commented Code
				 * in this block
				 */

				final String isInstCase = (String) detMap.get("INST_CASE");
				final String isFSEBDCase = (String) detMap.get("FSEBD_IND");
				programKeyArray = reviewBenfBO.findDafaultProgramsForReview(
						rmbDetMap, programKeyArray, appPgmRqstCargo);
				// persist program ket in APP_PGM_RQST table

				// create default driver to RMB application
				driverArray = driverManager.createDefaultDriver(
						FwConstants.RMB_DRIVER, appNumber);
				// intializing RMB driver with required pages
				final String required = (String) session
						.get(FwConstants.REQUIRED);
				final String[] pageIds = reviewBenfBO
						.getRMBRequiredPagesByPrograms(programKeyArray,
								required);
				driverManager.makeRequired(FwConstants.RMC_DRIVER, pageIds,
						driverArray, appNumber);
				programKeyArray = (short[]) programManager.loadProgramKey(
						appNumber).get(FwConstants.ZERO);
				final boolean[] categoryExtratFlags = new boolean[11];
				session.put(AppConstants.RMC_EXTRACTION_FLAGS,
						categoryExtratFlags);
				session.put(AppConstants.RMC_IN_PRFL_MASTER, rmcInPrflColl);
				session.put(AppConstants.INDIV_MASTER_HANDLER, peopleHandler);
				session.put(FwConstants.RMC_PROGRAM_KEY, programKeyArray);
				session.put(AppConstants.APP_NUMBER, appNumber);
				session.put(AppConstants.PGM_KEY, programKeyArray);
				session.put(FwConstants.RMC_DRIVER, driverArray);
				session.put(AppConstants.QUESTION_EXTRACTION_HANDLER,
						extractionHandler);
				session.put(AppConstants.REVIEW_CASE_NUM, caseNumber);
				session.put(AppConstants.RMB_RQST, rmbRqstCargo);
				session.put(AppConstants.INSTITUTIONAL_CASE, isInstCase);
				session.put(AppConstants.FSEBD_CASE, isFSEBDCase);
				session.put(AppConstants.RMB_RQST_COLLECTION, rmbRqstColl);
				session.put("APP_PGM_RQST_Collection", appPgmRqstColl);
				session.put(FwConstants.ACCESS_APPLICATION_TYPE,
						String.valueOf(FwConstants.RMB_APP_TYPE));
				session.put(AppConstants.MODIFIED_FIELDS, new ArrayList());
				reviewBenfBO.updateAppType("RMB", appNumber);
				Boolean progFlag = (programKeyArray[0] == 1&&programKeyArray[2] == 0&&programKeyArray[9] == 0&&programKeyArray[8] == 0&&programKeyArray[14] == 0)?true:false;
				if (progFlag){
					final String[] notRequiredPages = {"ARXHU","ARXHS"};
					driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
							notRequiredPages, driverArray, appNumber);
				}
			}

			log(ILog.INFO,
					"ARTransactionManagedEJBBean::storeRMBLandingPage:End");
		} catch (final FwException fe) {
			javaTransactionFailure();
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(getClass().getName());
			we.setCallingMethodID("storeRMBLandingPage");
			we.setFwException(fe);
			throw exceptionManagerLog(fe, getClass().getName(), "storeRMBLandingPage");
		} catch (final Exception e) {
			javaTransactionFailure();
			final FwException fe = createFwException(getClass().getName(),
					"storeRMBLandingPage", e);
			throw exceptionManagerLog(fe, getClass().getName(), "storeRMBLandingPage");
		}
		log(ILog.INFO,
				"ARTransactionManagedEJBBean.storeRMBLandingPage() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");

	}

	/**
	 * Load logic for Category Selection Page (PadeId ARCAT).
	 *
	 * @param txnBean
	 *            the txn bean
	 * @throws EJBException
	 *             the EJB exception
	 */
	public void loadCategorySelection(final FwTransaction txnBean)
			throws javax.ejb.EJBException {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"ARTransactionManagedEJBBean.loadCategorySelection() - START");
		try {
			log(ILog.INFO,
					"ARTransactionManagedEJBBean::loadCategorySelection:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			int[] driverArray = null;
			final JobIncomeBO jobBo = new JobIncomeBO();
			PeopleHandler peopleHandler = new PeopleHandler();
			short[] programKeyArray = null;
			boolean tfsPgmFlag = false;
			String appNumber = null;
			String caseNumber = null;
			final List peopleCaseList = new ArrayList();
			final List programCaseList = new ArrayList();
			final List pinNumbers = new ArrayList();
			final Map httpSessionMap = (Map) session
					.get(FwConstants.HTTP_SESSION);
			httpSessionMap.get(FwConstants.SECURED_SESSION);
			request.get(FwConstants.CURRENT_PAGE_ID);
			Map statusCheckMust = new HashMap();
			Map statusCheckMay = new HashMap();
			ReferenceTableManager.getInstance();
			RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			final BNFT_INDV_CASE_Collection bnftIndvCaseColl = null;
			String appNum = null;
			final RMCRequestManager rmcRqstManager = new RMCRequestManager();
			driverArray = (int[]) session.get(FwConstants.RMC_DRIVER);
			RMC_RQST_Cargo rmcRequestCargo = (RMC_RQST_Cargo) session
					.get(AppConstants.RMC_RQST);
			final RMC_RQST_Collection rmcRequestColl = new RMC_RQST_Collection();
			boolean isPregQue = false;
			final boolean isTargetPregnantable = false;
			INDIVIDUAL_Custom_Collection indvColl = new INDIVIDUAL_Custom_Collection();
			boolean isCCOnlyApp = false;
			boolean isTanfOnlyApp = false;
			boolean isWICApp = false;
			final Map httpSession = (Map) session
					.get(FwConstants.HTTP_SESSION);

			if (rmcRequestCargo == null) {
				final GenerateNextCntlNumBO generateCntlNum = new GenerateNextCntlNumBO();
				final ABCreateAppNumBO createAppNumBo = new ABCreateAppNumBO();
				String nextCntlNum = null;
				startJavaTransaction(mySessionCtx);
				nextCntlNum = generateCntlNum.getNextCntlNum("AF");
				javaTransactionSuccess();
				startJavaTransaction(mySessionCtx);
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
				javaTransactionSuccess();
				startJavaTransaction(mySessionCtx);
				
				String acsId = FwConstants.EMPTY_STRING;
				if ((Map) httpSession.get(FwConstants.SECURED_SESSION) != null) {
					acsId = (String) ((Map) httpSession
							.get(FwConstants.SECURED_SESSION)).get("wid");
				}
				createAppNumBo.storeAcsIdAndAppNum(acsId, appNumber);
				javaTransactionSuccess();

				caseNumber = (String) httpSession.get("CMB_CASE_NUM");
				String programCd = FwConstants.EMPTY_STRING;
				programCd = (String) httpSession.get("RMB_RMC_PRGM_CD");
				List<String> pgmCodes = new ArrayList<String>();
				if (httpSession.get("UpdatePermissionsByCase") != null) {

					pgmCodes = ((Map<String, List<String>>) httpSession
							.get("UpdatePermissionsByCase")).get(caseNumber);
					if(pgmCodes==null) {
						pgmCodes = new ArrayList<>();
					}
				} else if (programCd != null) {
					final StringTokenizer st = new StringTokenizer(programCd,
							"-");
					while (st.hasMoreTokens()) {
						pgmCodes.add(st.nextToken());
					}
				}
				
				if(pgmCodes.size()==1){
					if(pgmCodes.get(0).equals("CD")){
						isCCOnlyApp = true;
					} else if (
							pgmCodes.get(0).equals("TA")){
						isTanfOnlyApp = true;
					} else if(("WC").equalsIgnoreCase(pgmCodes.get(0))){
						isWICApp = true;
					}
				}
				final String requestType = AppConstants.RMC_REQUEST_TYPE;
				final RMBReceiveWebServiceBO rmbBo = new RMBReceiveWebServiceBO();
				rmbBo.getRmbDetails(caseNumber, pgmCodes, appNumber,
						requestType, txnBean);
				if (request.get("ERROR_WEB_SERVICE") != null) {
					request.put(FwConstants.NEXT_PAGE_ACTION,
							"CMBMyAccountSummary");
					request.put(FwConstants.NEXT_PAGE_ID, "AMHME");
					return;
				}
				final String agencyCntNumber = null;
				pageCollection.put(AppConstants.AGENCY_CONTACT_NO,
						agencyCntNumber);
				final int bnftIndvCaseCollSize = 0;
				BNFT_INDV_CASE_Cargo bnftIndvCaseCargo = null;
				
				// now loading the peoplehandler and program key array

				peopleHandler.loadPeopleHandler(appNumber);
				if (null!=programCaseList && !programCaseList.isEmpty()) {
					indvColl = peopleHandler.getAllIndividuals();
					final int indvCollSize = indvColl.size();
					INDIVIDUAL_Custom_Cargo indivCustCargo = null;
					for (int i = 0; i < indvCollSize; i++) {
						indivCustCargo = indvColl.getResult(i);
						pinNumbers.add(indivCustCargo.getIndv_pin_num());
					}
					final Map tempMap = programManager
							.loadProgramKeyByCaseNumbers(programCaseList,
									pinNumbers);
					programKeyArray = new short[18];
					tfsPgmFlag = ((Boolean) tempMap.get(AppConstants.TFS_FLG))
							.booleanValue();

					isPregQue = isAnyPregnantable(indvColl);
				}
				RMC_IN_PRFL_Cargo rmcInPrflCargo = null;
				if (rmcInPrflColl == null) {
					rmcInPrflColl = new RMC_IN_PRFL_Collection();
					indvColl = peopleHandler.getAllIndividuals();
					final int indvCollSize = indvColl.size();

					for (int i = 0; i < indvCollSize; i++) {
						rmcInPrflCargo = new RMC_IN_PRFL_Cargo();
						rmcInPrflCargo.setApp_num(appNumber);
						rmcInPrflCargo.setIndv_seq_num(indvColl.getResult(i)
								.getIndv_seq_num());

						rmcInPrflCargo = rmcResponseProfileManager
								.createRMCIndividualProfile(rmcInPrflCargo);

						rmcInPrflCargo = setHealthyBabiesIndicators(rmcInPrflCargo);

						rmcInPrflColl.addCargo(rmcInPrflCargo);
					}
					rmcInPrflCargo = new RMC_IN_PRFL_Cargo();
					rmcInPrflCargo.setApp_num(appNumber);
					rmcInPrflCargo.setIndv_seq_num("0");

					rmcInPrflCargo = rmcResponseProfileManager
							.createRMCIndividualProfile(rmcInPrflCargo);

					rmcInPrflCargo = setHealthyBabiesIndicators(rmcInPrflCargo);

					rmcInPrflColl.addCargo(rmcInPrflCargo);
					session.put(AppConstants.RMC_IN_PRFL_MASTER, rmcInPrflColl);
				}
				Map pgmMap = programManager.loadProgramKey(appNumber);
				programKeyArray = (short[]) pgmMap.get("0");
				driverArray = driverManager.createDefaultDriver(
						FwConstants.RMC_DRIVER, appNumber);
				final boolean[] categoryExtratFlags = new boolean[11];
				session.put(AppConstants.RMC_EXTRACTION_FLAGS,
						categoryExtratFlags);
				session.put(AppConstants.INDIV_MASTER_HANDLER, peopleHandler);
				session.put(FwConstants.RMC_PROGRAM_KEY, programKeyArray);
				session.put(AppConstants.APP_NUMBER, appNumber);
				session.put(AppConstants.PGM_KEY, programKeyArray);
				session.put(AppConstants.TFS_FLG, Boolean.valueOf(tfsPgmFlag));
				final RMC_RQST_Cargo rmcRqstCargo = rmcRqstManager
						.createRMCRequest(appNumber, caseNumber);
				session.put(AppConstants.RMC_RQST, rmcRqstCargo);
				session.put(AppConstants.MODIFIED_FIELDS, new ArrayList());
				final Map securedMap = (Map) httpSession
						.get(FwConstants.SECURED_SESSION);
				final List rmcAppNumList = (List) securedMap
						.get("USER_APP_NUM_LIST");
				String applicationNum = appNumber;
				applicationNum = applicationNum.replaceAll("^0*",
						FwConstants.EMPTY_STRING);
				if (rmcAppNumList != null) {
					rmcAppNumList.add(applicationNum);
				}

			} else {
				appNum = (String) session.get(AppConstants.APP_NUMBER);
				String programCd = FwConstants.EMPTY_STRING;
				programCd = (String) httpSession.get("RMB_RMC_PRGM_CD");
				List<String> pgmCodes = new ArrayList<String>();
				caseNumber = (String) httpSession.get("CMB_CASE_NUM");
				if (httpSession.get("UpdatePermissionsByCase") != null) {

					pgmCodes = ((Map<String, List<String>>) httpSession
							.get("UpdatePermissionsByCase")).get(caseNumber);
				} else if (programCd != null) {
					final StringTokenizer st = new StringTokenizer(programCd,
							"-");
					while (st.hasMoreTokens()) {
						pgmCodes.add(st.nextToken());
					}
				}
				if(pgmCodes.size()==1){
					if(pgmCodes.get(0).equals("CD")){
						isCCOnlyApp = true;
					}else if (
							pgmCodes.get(0).equals("TA")){
						isTanfOnlyApp = true;
					}else if(("WC").equalsIgnoreCase(pgmCodes.get(0))){
						isWICApp = true;
					}
				}
				peopleHandler = new PeopleHandler();
				peopleHandler.loadPeopleHandler(appNum);

				indvColl = peopleHandler.getAllIndividuals();
				isPregQue = isAnyPregnantable(indvColl);
				Map pgmMap = programManager.loadProgramKey(appNum);
				programKeyArray = (short[]) pgmMap.get("0");
				tfsPgmFlag = false;
				appNumber = (String) session.get(AppConstants.APP_NUMBER);
				if (rmcRequestCargo != null) {
					rmcRequestColl.addCargo(rmcRequestCargo);
					pageCollection.put("RMC_RQST_Collection", rmcRequestColl);
					caseNumber = rmcRequestCargo.getCase_num();
				}
				driverArray = (int[]) session.get(FwConstants.RMC_DRIVER);
				final boolean[] categoryExtratFlags = new boolean[11];
				session.put(AppConstants.RMC_EXTRACTION_FLAGS,
						categoryExtratFlags);
				session.put(AppConstants.INDIV_MASTER_HANDLER, peopleHandler);
				session.put(FwConstants.RMC_PROGRAM_KEY, programKeyArray);
				session.put(AppConstants.APP_NUMBER, appNumber);
				session.put(AppConstants.PGM_KEY, programKeyArray);
				session.put(AppConstants.TFS_FLG, Boolean.valueOf(tfsPgmFlag));
				final int bnftIndvCaseCollSize = 0;
				BNFT_INDV_CASE_Cargo bnftIndvCaseCargo = null;
				
				if (null!=programCaseList && !programCaseList.isEmpty()) {
					indvColl = peopleHandler.getAllIndividuals();
					final int indvCollSize = indvColl.size();
					INDIVIDUAL_Custom_Cargo indivCustCargo = null;
					String pinNumber = null;
					for (int i = 0; i < indvCollSize; i++) {
						indivCustCargo = indvColl.getResult(i);
						pinNumber = indivCustCargo.getIndv_pin_num();
						if (pinNumber != null) {
							pinNumbers.add(pinNumber);
						}
					}
				}
			}

			startJavaTransaction(mySessionCtx);

			final String agencyCntNumber = FwConstants.EMPTY_STRING;
			pageCollection.put(AppConstants.AGENCY_CONTACT_NO, agencyCntNumber);
			Map result = new HashMap();
			String[] messageArray1 = null;
			String[] messageArray1Suffix = null;
			final INDIVIDUAL_Custom_Collection allIndvs = peopleHandler
					.getAllIndividuals();
			final boolean anyPregIndiv = isAnyPregnantable(allIndvs);
			session.put("preg_flag", anyPregIndiv);
			final List<String> messageList = new ArrayList<String>();
			messageList.add("45111");
			messageList.add("45113");
			messageList.add("45116");
			messageList.add("800000233");
			// Show "Someone had a change in household relationships." only if more than 1 Individual on file.
			if (null != allIndvs && allIndvs.size() > 1) {
				messageList.add("500001452");
			}
			if (anyPregIndiv) {
				messageList.add("45119");
			}
			messageList.add("45123");
			messageList.add("800001076");
			messageList.add("500001451");
			messageList.add("500001455");
			messageList.add("500001450");
			messageList.add("45126");
			if(!isTanfOnlyApp){
				messageList.add("45132");
			}			
			if(!isCCOnlyApp){
				messageList.add("500001456");
			}
			
			

			messageArray1 = messageList.toArray(new String[messageList.size()]);

			final List<String> messageSuffixList = new ArrayList<String>();
			// Msg_ID 45111
			messageSuffixList.add("add_chg_stat_sw");
			// Msg_ID 45113
			messageSuffixList.add("prsn_move_stat_sw");
			// Msg_ID 45116
			messageSuffixList.add("prsn_add_stat_sw");
			// Msg_ID 800000233
			messageSuffixList.add("change_in_personal_info");
			if (null != allIndvs && allIndvs.size() > 1) {
				// Msg_ID 500001452
				messageSuffixList.add("rlt_stat_sw");
			}
			if (anyPregIndiv) {
				// Msg_ID 45119
				messageSuffixList.add("preg_chg_stat_sw");
			}
			// Msg_ID 45123
			messageSuffixList.add("dabl_stat_sw");
			// Msg_ID 800001076
			messageSuffixList.add("additional_info_sw");
			// Msg_ID 500001451
			messageSuffixList.add("liquid_asset_changed");
			// Msg_ID 500001455
			messageSuffixList.add("other_asset_changed");
			// Msg_ID 500001450
			messageSuffixList.add("ei_chg_sw");
			// Msg_ID 45126
			messageSuffixList.add("othr_stat_sw");
			// Msg_ID 45132
			if(!isTanfOnlyApp){
				messageSuffixList.add("hous_util_stat_sw");
			}			
			if(!isCCOnlyApp) {
				// Msg_ID 500001456
				messageSuffixList.add("change_in_care");
			}
			

			messageArray1Suffix = messageSuffixList
					.toArray(new String[messageSuffixList.size()]);

			programKeyArray = (short[]) programManager
					.loadProgramKey(appNumber).get(FwConstants.ZERO);

			final String currentPageID = (String) request
					.get(FwConstants.CURRENT_PAGE_ID);
			final int currentPageStatus = driverManager.getAFBStatus(
					FwConstants.RMC_DRIVER, currentPageID, driverArray);

			final ABHouseHoldRelationshipBO houseHoldRelationship = new ABHouseHoldRelationshipBO();
			final APP_HSHL_RLT_Collection houseHoldColl = houseHoldRelationship
					.getCareTaker(peopleHandler.getAllIndividuals(),
							peopleHandler, appNumber,
							AppConstants.CWW_RECORD_IND);

			final boolean isDisplayCareTaker = houseHoldColl != null
					&& houseHoldColl.size() > 0;

			if (isDisplayCareTaker) {
				messageList.add(7, "500001457");
				messageArray1 = messageList.toArray(new String[messageList
						.size()]);
				// Msg_ID 500001457
				messageSuffixList.add(7, "change_in_child_care");
				messageArray1Suffix = messageSuffixList
						.toArray(new String[messageSuffixList.size()]);
			}
			
			
			//for WIC program no need to schedule 
			if(isWICApp){
				messageList.remove("800001076");
				messageList.remove("500001451");
				messageList.remove("500001455");
				messageList.remove("45132");
				messageList.remove("500001456");
				messageList.remove("500001457");

				messageSuffixList.remove("additional_info_sw");
				messageSuffixList.remove("liquid_asset_changed");
				messageSuffixList.remove("other_asset_changed");
				messageSuffixList.remove("hous_util_stat_sw");
				messageSuffixList.remove("change_in_care");
				messageSuffixList.remove("change_in_child_care");
				
				messageArray1 = messageList.toArray(new String[messageList
				                       						.size()]);
				messageArray1Suffix = messageSuffixList
						.toArray(new String[messageSuffixList.size()]);
			}

			result = jobBo
					.buildMustArrayRMC(messageArray1, messageArray1Suffix);
			log(ILog.INFO, "messageArray1Suffix.length"
					+ messageArray1Suffix.length);

			final RMC_RQST_Cargo rmcRqstCargo = new RMC_RQST_Cargo();
			boolean rmcDataExists = false;
			boolean[] rmcPregDataExists = { false, false };
			final boolean[] rmcIndvLiveChgDataExists = { false, false, false,
					false };
			boolean rmcJobInkindDataExists = false;
			boolean rmcSelfEmpDataExists = false;
			boolean rmcHousingBillsDataExists = false;
			boolean rmcUtilityBillsDataExists = false;

			boolean rmcChangeInOtherBillsDataExists = false;
			boolean rmcRelationshipExists = false;
			final List pgStatList = new ArrayList();
			pgStatList.add(String.valueOf(FwConstants.DRIVER_COMPLETE));
			pgStatList.add(String.valueOf(FwConstants.DRIVER_VISIT_AGAIN));
			int pageStatus = 0;
			rmcDataExists = true;
			if (!rmcDataExists) {
				pageStatus = driverManager.getAFBStatus(FwConstants.RMC_DRIVER,
						"ARACD", driverArray);
				if (pgStatList.contains(String.valueOf(pageStatus))
						&& rmcRqstCargo != null
						&& rmcRqstCargo.getAdd_chg_stat_sw() != null
						&& FwConstants.YES.equals(rmcRqstCargo
								.getAdd_chg_stat_sw())) {
					rmcRqstCargo.setAdd_chg_stat_sw(FwConstants.NO);
				}
			} else if (rmcRqstCargo != null
					&& rmcRqstCargo.getAdd_chg_stat_sw() != null
					&& FwConstants.NO.equals(rmcRqstCargo.getAdd_chg_stat_sw())) {
				rmcRqstCargo.setAdd_chg_stat_sw(FwConstants.YES);
			}
			final HouseHoldInfoBO hhInfoBO = new HouseHoldInfoBO();
			rmcDataExists = hhInfoBO.checkDataExistance(appNum);
			if (!rmcDataExists) {
				pageStatus = driverManager.getAFBStatus(FwConstants.RMC_DRIVER,
						"ARHMI", driverArray);
				if (pgStatList.contains(String.valueOf(pageStatus))
						&& rmcRqstCargo != null
						&& rmcRqstCargo.getPrsn_add_stat_sw() != null
						&& FwConstants.YES.equals(rmcRqstCargo
								.getPrsn_add_stat_sw())) {
					rmcRqstCargo.setPrsn_add_stat_sw(FwConstants.NO);
				}
			} else if (rmcRqstCargo != null
					&& rmcRqstCargo.getPrsn_add_stat_sw() != null
					&& FwConstants.NO
							.equals(rmcRqstCargo.getPrsn_add_stat_sw())) {
				rmcRqstCargo.setPrsn_add_stat_sw(FwConstants.YES);
			}
			if (rmcRqstCargo != null
					&& rmcRqstCargo.getPrsn_move_stat_sw() != null) {
				if (FwConstants.NO.equals(rmcRqstCargo.getPrsn_move_stat_sw())) {
					rmcRqstCargo.setPrsn_move_stat_sw(FwConstants.NO);
				} else if (FwConstants.YES.equals(rmcRqstCargo
						.getPrsn_move_stat_sw())) {
					rmcRqstCargo.setPrsn_move_stat_sw(FwConstants.YES);
				}
			}
			final PregnancyBO pregBO = new PregnancyBO();
			rmcPregDataExists = pregBO.checkDataExistance(appNum);
			boolean pregnancyFlagSet = false;
			// ADD
			if (!rmcPregDataExists[AppConstants.RMC_PREG_ADD_INDEX]) {
				if (pgStatList.contains(String.valueOf(pageStatus))
						&& rmcRqstCargo != null
						&& rmcRqstCargo.getPreg_add_stat_sw() != null
						&& FwConstants.YES.equals(rmcRqstCargo
								.getPreg_add_stat_sw())) {
					rmcRqstCargo.setPreg_add_stat_sw(FwConstants.NO);
					pregnancyFlagSet = true;
				}
			} else {
				if (rmcRqstCargo != null
						&& rmcRqstCargo.getPreg_add_stat_sw() != null
						&& FwConstants.NO.equals(rmcRqstCargo
								.getPreg_add_stat_sw())) {
					rmcRqstCargo.setPreg_add_stat_sw(FwConstants.YES);
				}
				pregnancyFlagSet = true;
			}
			if (!rmcPregDataExists[AppConstants.RMC_PREG_END_INDEX]) {
				if (pregnancyFlagSet
								&& pgStatList.contains(String.valueOf(pageStatus))
						|| !pregnancyFlagSet
								&& pgStatList.contains(String.valueOf(pageStatus))
								&& rmcRqstCargo != null
								&& rmcRqstCargo.getPreg_chg_stat_sw() != null
								&& FwConstants.YES.equals(rmcRqstCargo
										.getPreg_chg_stat_sw())) {
					rmcRqstCargo.setPreg_chg_stat_sw(FwConstants.NO);
				}
			} else if (rmcRqstCargo != null
					&& rmcRqstCargo.getPreg_chg_stat_sw() != null
					&& FwConstants.NO
							.equals(rmcRqstCargo.getPreg_chg_stat_sw())) {
				rmcRqstCargo.setPreg_chg_stat_sw(FwConstants.YES);
			}
			final DisabilityBO disabBO = new DisabilityBO();
			rmcDataExists = disabBO.checkDataExistance(appNum);
			if (!rmcDataExists) {
				pageStatus = driverManager.getAFBStatus(FwConstants.RMC_DRIVER,
						"ARDGP", driverArray);
				if (pgStatList.contains(String.valueOf(pageStatus))
						&& rmcRqstCargo != null
						&& rmcRqstCargo.getDabl_stat_sw() != null
						&& FwConstants.YES.equals(rmcRqstCargo
								.getDabl_stat_sw())) {
					rmcRqstCargo.setDabl_stat_sw(FwConstants.NO);
				}
			} else if (rmcRqstCargo != null
					&& rmcRqstCargo.getDabl_stat_sw() != null
					&& FwConstants.NO.equals(rmcRqstCargo.getDabl_stat_sw())) {
				rmcRqstCargo.setDabl_stat_sw(FwConstants.YES);
			}
			final SelfEmploymentBO selfEmpBO = new SelfEmploymentBO();
			rmcSelfEmpDataExists = selfEmpBO.checkDataExistance(appNum);
			final JobIncomeBO jobBO = new JobIncomeBO();
			rmcJobInkindDataExists = jobBO.checkDataExistance(appNum);
			if (!rmcJobInkindDataExists && !rmcSelfEmpDataExists) {
				rmcRqstCargo.setEi_chg_sw(FwConstants.NO);
			} else if (rmcRqstCargo != null
					&& rmcRqstCargo.getEi_chg_sw() != null
					&& FwConstants.NO.equals(rmcRqstCargo.getEi_chg_sw())) {
				rmcRqstCargo.setEi_chg_sw(FwConstants.YES);
			}

			final OtherIncomeBO othrBO = new OtherIncomeBO();
			rmcDataExists = othrBO.checkDataExistance(appNum);
			if (!rmcDataExists) {
				if (pgStatList.contains(String.valueOf(pageStatus))
						&& rmcRqstCargo != null
						&& rmcRqstCargo.getOthr_stat_sw() != null
						&& FwConstants.YES.equals(rmcRqstCargo
								.getOthr_stat_sw())) {
					rmcRqstCargo.setOthr_stat_sw(FwConstants.NO);
				}
			} else if (rmcRqstCargo != null
					&& rmcRqstCargo.getOthr_stat_sw() != null
					&& FwConstants.NO.equals(rmcRqstCargo.getOthr_stat_sw())) {
				rmcRqstCargo.setOthr_stat_sw(FwConstants.YES);
			}
			final ShelterCostsBO shltBO = new ShelterCostsBO();
			rmcHousingBillsDataExists = shltBO.checkDataExistance(appNum);
			final UtilityCostsBO utilBO = new UtilityCostsBO();
			rmcUtilityBillsDataExists = utilBO.checkDataExistance(appNum);
			if (!rmcHousingBillsDataExists && !rmcUtilityBillsDataExists) {
				rmcRqstCargo.setHous_util_stat_sw(FwConstants.NO);

			} else if (rmcRqstCargo != null
					&& rmcRqstCargo.getHous_util_stat_sw() != null
					&& FwConstants.NO.equals(rmcRqstCargo
							.getHous_util_stat_sw())) {
				rmcRqstCargo.setHous_util_stat_sw(FwConstants.YES);
			}
			final LiquidAssetBO lqdasstBO = new LiquidAssetBO();
			rmcDataExists = lqdasstBO.checkDataExistance(appNum);
			if (!rmcDataExists) {
				pageStatus = driverManager.getAFBStatus(FwConstants.RMC_DRIVER,
						"ARACS", driverArray);
				if (pgStatList.contains(String.valueOf(pageStatus))
						&& rmcRqstCargo != null
						&& rmcRqstCargo.getLiquid_asset_changed() != null
						&& FwConstants.YES.equals(rmcRqstCargo
								.getLiquid_asset_changed())) {
					rmcRqstCargo.setLiquid_asset_changed(FwConstants.NO);
				}
			} else if (rmcRqstCargo != null
					&& rmcRqstCargo.getLiquid_asset_changed() != null
					&& FwConstants.NO.equals(rmcRqstCargo
							.getLiquid_asset_changed())) {
				rmcRqstCargo.setLiquid_asset_changed(FwConstants.YES);
			}

			rmcRelationshipExists = lqdasstBO
					.checkRelationDataExistance(appNum);
			if (!rmcRelationshipExists) {
				rmcRqstCargo.setRlt_stat_sw(FwConstants.NO);
			} else if (rmcRqstCargo != null
					&& rmcRqstCargo.getRlt_stat_sw() != null
					&& FwConstants.NO.equals(rmcRqstCargo.getRlt_stat_sw())) {
				rmcRqstCargo.setRlt_stat_sw(FwConstants.YES);
			}
			boolean rmcChangeInChildBillsDataExists = false;
			boolean rmcChangeInMedBillsDataExists = false;
			rmcChangeInOtherBillsDataExists = lqdasstBO
					.checkBillDataExistance(appNum);
			rmcChangeInChildBillsDataExists = lqdasstBO
					.checkChildBillDataExistance(appNum);
			rmcChangeInMedBillsDataExists = lqdasstBO
					.checkChildBillDataExistance(appNum);

			if (!rmcChangeInOtherBillsDataExists
					&& !rmcChangeInChildBillsDataExists
					&& !rmcChangeInMedBillsDataExists) {
				pageStatus = driverManager.getAFBStatus(FwConstants.RMC_DRIVER,
						"ARBBQ", driverArray);
				if (pgStatList.contains(String.valueOf(pageStatus))
						&& rmcRqstCargo != null
						&& rmcRqstCargo.getChange_in_care() != null
						&& FwConstants.YES.equals(rmcRqstCargo
								.getChange_in_care())) {
					rmcRqstCargo.setChange_in_care(FwConstants.NO);
				}
			} else if (rmcRqstCargo != null
					&& rmcRqstCargo.getChange_in_care() != null
					&& FwConstants.NO.equals(rmcRqstCargo.getChange_in_care())) {
				rmcRqstCargo.setChange_in_care(FwConstants.YES);
			}

			if (!rmcIndvLiveChgDataExists[AppConstants.RMC_DIED_INDEX]) {
				if (pgStatList.contains(String.valueOf(pageStatus))
						&& rmcRqstCargo != null
						&& rmcRqstCargo.getDth_stat_sw() != null
						&& FwConstants.YES
								.equals(rmcRqstCargo.getDth_stat_sw())) {
					rmcRqstCargo.setDth_stat_sw(FwConstants.NO);
				}
			} else if (rmcRqstCargo != null
					&& rmcRqstCargo.getDth_stat_sw() != null
					&& FwConstants.NO.equals(rmcRqstCargo.getDth_stat_sw())) {
				rmcRqstCargo.setDth_stat_sw(FwConstants.YES);
			}
			rmcRequestCargo = (RMC_RQST_Cargo) session
					.get(AppConstants.RMC_RQST);
			final List mayArray = (List) result.get(AppConstants.CS_MAY_ARRAY);
			final List mustArray = (List) result
					.get(AppConstants.CS_MUST_ARRAY);
			final List mayArraySuffix = (List) result
					.get(AppConstants.CS_MAY_ARRAY_SUFFIX);
			final List mustArraySuffix = (List) result
					.get(AppConstants.CS_MUST_ARRAY_SUFFIX);
			final List benefitArray = (List) result
					.get(AppConstants.BENEFIT_ARRAY);
			pageCollection.put(AppConstants.CS_MUST_ARRAY, mustArray);
			pageCollection.put(AppConstants.CS_MAY_ARRAY, mayArray);
			pageCollection.put(AppConstants.CS_MUST_ARRAY_SUFFIX,
					mustArraySuffix);
			pageCollection
					.put(AppConstants.CS_MAY_ARRAY_SUFFIX, mayArraySuffix);
			pageCollection.put(AppConstants.BENEFIT_ARRAY, benefitArray);
			pageCollection.put(AppConstants.PGM_KEY, programKeyArray);
			pageCollection.put(AppConstants.TFS_FLG,
					Boolean.valueOf(tfsPgmFlag));
			pageCollection.put("IS_PREGNANCY_QUE", String.valueOf(isPregQue));
			pageCollection.put("IS_TARGET_PREGNANTABLE",
					String.valueOf(isTargetPregnantable));
			if (appNum != null && rmcRequestCargo != null) {
				statusCheckMust = checkCategorySelStatusFlag(appNum, mustArray,
						rmcRequestCargo, rmcInPrflColl, driverArray,
						FwConstants.YES);
				final String[] securityOverideMust = (String[]) statusCheckMust
						.get("SECURITY_STATUS");
				final String[] catSelStatMust = (String[]) statusCheckMust
						.get(AppConstants.CATEGORY_SEL_RESPONSE);
				pageCollection.put("SECURITY_STATUS_MUST", securityOverideMust);
				pageCollection.put("STATUS_MUST", catSelStatMust);
				/*
				 * VG SONAR Cleanup - 09/4/2015 Deleted 1 lines Commented Code
				 * in this block
				 */

				statusCheckMay = checkCategorySelStatusFlagRMC(appNum,
						mayArraySuffix, rmcRequestCargo, rmcInPrflColl,
						driverArray);
				final String[] securityOverideMay = (String[]) statusCheckMay
						.get("SECURITY_STATUS");
				final String[] catSelStatMay = (String[]) statusCheckMay
						.get(AppConstants.CATEGORY_SEL_RESPONSE);
				pageCollection.put("SECURITY_STATUS_MAY", securityOverideMay);
				pageCollection.put("STATUS_MAY", catSelStatMay);
			}
			String fplNo = jobBo.getExtractFPLNo(pinNumbers, programCaseList);
			String fplNoBCP = jobBo.getExtractFPLNoForBCP(pinNumbers,
					programCaseList);
			String fplNoCC = null;

			if (FwConstants.ZERO.equals(fplNo)) {
				fplNo = "0.00";
			}
			if (FwConstants.ZERO.equals(fplNoBCP)) {
				fplNoBCP = "0.00";
			}

			if (FwConstants.ZERO.equals(fplNoCC)) {
				fplNoCC = "0.00";
			}
			double tempFPLNo = 0.00;
			double tempBCPFPLNo = 0.00;
			if (fplNo != null) {
				tempFPLNo = Double.valueOf(fplNo.trim()).doubleValue();
			}
			if (fplNoBCP != null) {
				tempBCPFPLNo = Double.valueOf(fplNoBCP.trim()).doubleValue();
			}

			if (fplNoCC != null) {
				Double.valueOf(fplNoCC.trim()).doubleValue();
			}

			final String lowestFplNo = tempFPLNo > tempBCPFPLNo ? fplNoBCP
					: fplNo;
			pageCollection.put(AppConstants.FPL_NO, fplNo);
			pageCollection.put("FPL_NO_BCP", fplNoBCP);
			pageCollection.put("FPL_NO_CC", fplNoCC);
			pageCollection.put("FPL_NO_LOWEST", lowestFplNo);

			session.put(FwConstants.RMC_PROGRAM_KEY, programKeyArray);
			pageCollection.put("RMC_RQST_Collection", rmcRequestColl);
			txnBean.setPageCollection(pageCollection);
			componentManager.getComponents("ARCAT", txnBean);
			final List pgmCmptList = (ArrayList) pageCollection
					.get(FwConstants.PAGE_COMPONENT_LIST);
			if (pgmCmptList != null) {
				pgmCmptList.size();
			}
			session.put(FwConstants.BEFORE_COLLECTION, pageCollection);
			session.put(FwConstants.RMC_DRIVER, driverArray);
			final String language = (String) httpSessionMap
					.get(FwConstants.LANGUAGE);
			pageCollection.put("ChangeMonth", jobBo.getNextMonth(language));
			session.put(FwConstants.ACCESS_APPLICATION_TYPE,
					String.valueOf(FwConstants.RMC_APP_TYPE));
			final ReviewMyBenefitsBO reviewBenfBO = new ReviewMyBenefitsBO();
			reviewBenfBO.updateAppType("RMC", appNumber);
			javaTransactionSuccess();
			log(ILog.INFO, "ReportMyChangesEJBBean::loadCategorySelection:End");
		} catch (final FwException fe) {
			javaTransactionFailure();
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(getClass().getName());
			we.setCallingMethodID("loadCategorySelection");
			we.setFwException(fe);
			throw exceptionManagerLog(fe, getClass().getName(), "loadCategorySelection");
		} catch (final Exception e) {
			javaTransactionFailure();
			final FwException fe = createFwException(getClass().getName(),
					"loadCategorySelection", e);
			throw exceptionManagerLog(fe, getClass().getName(), "loadCategorySelection");
		}

		log(ILog.INFO,
				"ARTransactionManagedEJBBean.loadCategorySelection() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Store final application submission.
	 *
	 * @param txnBean
	 *            the txn bean
	 * @throws EJBException
	 *             the EJB exception
	 */
	public void storeFinalApplicationSubmission(final FwTransaction txnBean)
			throws javax.ejb.EJBException {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"ARTransactionManagedEJBBean.storeFinalApplicationSubmission() - START");
		try {

			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final ABFinalSubmitBO finalBO = new ABFinalSubmitBO();

			String appNum = null;
			boolean authRep = false;
			boolean sbms = false;
			try {
				// getting current pageid from request
				final String currentPageID = (String) request
						.get(FwConstants.CURRENT_PAGE_ID);

				// Auth Rep Cargo and Collection
				APP_AUTH_REP_Collection appAuthRepColl = null;// new

				APP_AUTH_REP_Cargo appAuthRepCargo = null;// new

				if (pageCollection.containsKey("APP_AUTH_REP_Collection")) {
					appAuthRepColl = (APP_AUTH_REP_Collection) pageCollection
							.get("APP_AUTH_REP_Collection");
				}

				// getting before collection from before collection
				final Map beforeColl = (Map) session
						.get(FwConstants.BEFORE_COLLECTION);
				final APP_SBMS_Collection beforeSbmsColl = (APP_SBMS_Collection) beforeColl.get("APP_SBMS_Collection");

				// getting driver status
				final int[] driverArray = (int[]) session
						.get(FwConstants.RMC_DRIVER);

				// getting app number
				appNum = (String) session.get(AppConstants.APP_NUMBER);

				// what are the values i have to set this time. No application
				// number in app_auth_rep
				if (appAuthRepColl != null && !appAuthRepColl.isEmpty()) {
					appAuthRepCargo = appAuthRepColl.getCargo(0);
					appAuthRepCargo.setApp_num(appNum);
					if (appAuthRepCargo.getAuth_rep_fst_nam() != null
							&& appAuthRepCargo.getAuth_rep_fst_nam().trim()
									.length() > 0) {
						appAuthRepCargo.setRep_code("AR");
						appAuthRepCargo.setSrc_app_ind("RN");
						appAuthRepCargo
								.setRowAction(FwConstants.ROWACTION_INSERT);
						appAuthRepCargo.setSeq_num(FwConstants.ONE);

						if (appAuthRepCargo.getAuth_rep_mid_init() == null
								|| appAuthRepCargo.getAuth_rep_mid_init()
										.trim().length() == 0) {
							appAuthRepCargo
									.setAuth_rep_mid_init(FwConstants.SPACE);
						}

						if (appAuthRepCargo.getAuth_rep_esign_ind() == null
								|| appAuthRepCargo.getAuth_rep_esign_ind()
										.trim().length() == 0) {
							appAuthRepCargo
									.setAuth_rep_esign_ind(AppConstants.ZERO);
						}

						if (appAuthRepCargo.getAppl_esign_ind() == null
								|| appAuthRepCargo.getAppl_esign_ind().trim()
										.length() == 0) {
							appAuthRepCargo
									.setAppl_esign_ind(AppConstants.ZERO);
						}

						if (appAuthRepCargo.getAppl_fst_nam() == null
								|| appAuthRepCargo.getAppl_fst_nam().trim()
										.length() == 0) {
							appAuthRepCargo.setAppl_fst_nam(FwConstants.SPACE);
						}

						if (appAuthRepCargo.getAppl_last_nam() == null
								|| appAuthRepCargo.getAppl_last_nam().trim()
										.length() == 0) {
							appAuthRepCargo.setAppl_last_nam(FwConstants.SPACE);
						}

						if (appAuthRepCargo.getAppl_mid_init() == null
								|| appAuthRepCargo.getAppl_mid_init().trim()
										.length() == 0) {
							appAuthRepCargo.setAppl_mid_init(FwConstants.SPACE);
						}

						if (appAuthRepCargo.getAuth_rep_esign_ind() == null
								|| appAuthRepCargo.getAuth_rep_esign_ind()
										.trim().length() == 0) {
							appAuthRepCargo
									.setAuth_rep_esign_ind(AppConstants.ZERO);
						}

						if (appAuthRepCargo.getMa_fs_auth_rep_nam() == null
								|| appAuthRepCargo.getMa_fs_auth_rep_nam()
										.trim().length() == 0) {
							appAuthRepCargo
									.setMa_fs_auth_rep_nam(FwConstants.SPACE);
						}

						if (appAuthRepCargo.getWitn_esign_ind() == null
								|| appAuthRepCargo.getWitn_esign_ind().trim()
										.length() == 0) {
							appAuthRepCargo
									.setWitn_esign_ind(AppConstants.ZERO);
						}

						if (appAuthRepCargo.getWitn_fst_nam() == null
								|| appAuthRepCargo.getWitn_fst_nam().trim()
										.length() == 0) {
							appAuthRepCargo.setWitn_fst_nam(FwConstants.SPACE);
						}

						if (appAuthRepCargo.getWitn_last_nam() == null
								|| appAuthRepCargo.getWitn_last_nam().trim()
										.length() == 0) {
							appAuthRepCargo.setWitn_last_nam(FwConstants.SPACE);
						}

						if (appAuthRepCargo.getWitn_mid_init() == null
								|| appAuthRepCargo.getWitn_mid_init().trim()
										.length() == 0) {
							appAuthRepCargo.setWitn_mid_init(FwConstants.SPACE);
						}

						if (appAuthRepCargo.getBrg_crd_rcv_ind() == null
								|| appAuthRepCargo.getBrg_crd_rcv_ind().trim()
										.length() == 0) {
							appAuthRepCargo
									.setBrg_crd_rcv_ind(FwConstants.SPACE);

							authRep = true;

						}
					}
				}
				
				final RMBRequestManager rmbRqstManager1 = new RMBRequestManager();
				RMB_RQST_Cargo rmbRqstCargo1 =  rmbRqstManager1.loadRMBRequest(appNum);
				boolean medicaid = false;
				boolean pregnant = false;
				boolean newborn = false;
				if(rmbRqstCargo1 != null && FwConstants.APPLY_FOR_ADDITIONAL_BENEFITS.equalsIgnoreCase(rmbRqstCargo1.getApp_typ())){
					APP_PRIR_SRV_Collection expeditedScreeningColl = new APP_PRIR_SRV_Collection();
					final APP_PRIR_SRV_Cargo expeditedCargo = new APP_PRIR_SRV_Cargo();
					final ABPriorityServiceBO aBPriorityServiceBO = new ABPriorityServiceBO();
					Double totalAmtLiquid = Double.valueOf(0);
					Double totalAmtIncome = Double.valueOf(0);
					Double totalAmtRent = Double.valueOf(0);
					String migWorker = null;

//					boolean eligible = false;
					
					String liquidless = "";
//					boolean snapFlag = false;
//					short[] pgmKey = (short[]) session.get(FwConstants.RMC_PROGRAM_KEY);
//					if (pgmKey[2] == 1) {
//						snapFlag = true;
//					}

					expeditedScreeningColl = finalBO.loadExpSNAPDetails(appNum);
					totalAmtIncome = finalBO.totalHouseholdMonthlyIncome(appNum);
					totalAmtLiquid = finalBO.totalLiquidResources(appNum);
					totalAmtRent = finalBO.totalRentMortgageResources(appNum);
					migWorker = finalBO.migrantFarm(appNum);
//					if(snapFlag){
//						eligible = finalBO.checkExpeditedSNAPForRMB(appNum);
//					}
					
					medicaid = finalBO.medicaidABD(appNum, txnBean);
					pregnant = finalBO.pregnant(appNum);
					newborn = finalBO.newBorn(appNum);

					if (FwConstants.YES.equals(migWorker)) {
						if (totalAmtLiquid.doubleValue() <= Double
								.parseDouble(FwConstants.EXP_SNAP_LA_LMT)) {
							liquidless = "Y";
						} else {
							liquidless = "N";
						}

					}
				
				expeditedCargo
				.setMo_gr_incm_amt(String.valueOf(totalAmtIncome));
				expeditedCargo.setLqd_aset_amt(String.valueOf(totalAmtLiquid));
				expeditedCargo.setApp_num(appNum);
				expeditedCargo.setIncm_stop_sw(FwConstants.ZERO);
				expeditedCargo.setLqd_aset_ind(FwConstants.ZERO);
				expeditedCargo.setMig_farm_wrkr_sw(migWorker);
				expeditedCargo.setMo_gr_incm_ind(FwConstants.ZERO);
				expeditedCargo
				.setMo_rent_mrtg_amt(String.valueOf(totalAmtRent));
				expeditedCargo.setMo_rent_mrtg_ind(FwConstants.ZERO);
				expeditedCargo.setMo_util_amt(FwConstants.ZERO);
				expeditedCargo.setMo_util_ind(FwConstants.ZERO);
				expeditedCargo.setNew_incm_sw(liquidless);
				expeditedCargo.setRcv_fs_cur_mo_sw(FwConstants.ZERO);
				expeditedCargo.setRec_cplt_ind(FwConstants.ZERO);
				expeditedCargo.setWmen_chld_shlt_sw(FwConstants.ZERO);
				expeditedCargo.setNon_heat_ele_exp(FwConstants.ZERO);
				expeditedCargo.setTrash_removal_exp(FwConstants.ZERO);
				expeditedCargo.setCook_fuel_exp(FwConstants.ZERO);
				expeditedCargo.setWatsew_exp(FwConstants.ZERO);
				expeditedCargo.setTele_exp(FwConstants.ZERO);
				expeditedCargo.setHeat_utility_exp(FwConstants.ZERO);
				expeditedCargo.setIncm_same_grwr_sw(FwConstants.ZERO);
				expeditedCargo.setDt_incm_same_grwr(FwConstants.HIGH_DATE);
				expeditedCargo.setAmt_same_grwr(FwConstants.ZERO);
				expeditedCargo.setIncm_crnt_mnth_sw(FwConstants.ZERO);
				expeditedCargo.setDt_incm_crnt_mnth(FwConstants.HIGH_DATE);
				expeditedCargo.setAmt_crnt_mnth(FwConstants.ZERO);
				expeditedCargo.setTrvl_advc_sw(FwConstants.ZERO);
				expeditedCargo.setDt_trvl_advc(FwConstants.HIGH_DATE);
				expeditedCargo.setAmt_trvl_advc(FwConstants.ZERO);
				expeditedCargo.setLst_only_src_incm_sw(FwConstants.ZERO);
				expeditedCargo.setDt_final_pay_chk(FwConstants.HIGH_DATE);
				expeditedCargo.setAmt_fnal_pay_chk(FwConstants.ZERO);
				expeditedCargo.setCount_grs_assets_incm_resp(FwConstants.ZERO);
				expeditedCargo
				.setElectricity_airc_utility_ind(FwConstants.ZERO);
				expeditedCargo.setElectricity_utility_ind(FwConstants.ZERO);
				expeditedCargo.setGarbage_utility_ind(FwConstants.ZERO);
				expeditedCargo.setHeat_utility_ind(FwConstants.ZERO);
				expeditedCargo.setOther_utility_ind(FwConstants.ZERO);
				expeditedCargo.setSrc_app_ind("AB");
				expeditedCargo.setSewer_utility_ind(FwConstants.ZERO);
				expeditedCargo.setTelephone_utility_ind(FwConstants.ZERO);
				expeditedCargo.setWater_utility_ind(FwConstants.ZERO);
				if ((expeditedScreeningColl != null)
						&& (!expeditedScreeningColl.isEmpty())) {

					expeditedCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
				} else {

					expeditedCargo.setRowAction(FwConstants.ROWACTION_INSERT);
				}

				APP_PRIR_SRV_Collection storedExpeditedScreeningColl = new APP_PRIR_SRV_Collection();
				storedExpeditedScreeningColl.addCargo(expeditedCargo);
				aBPriorityServiceBO
				.storePriorityServiceQuestions(storedExpeditedScreeningColl);
				}
				// getting APP_SBMS_Collection from page collection
				APP_SBMS_Collection appSbmsColl = null;
				APP_SBMS_Cargo appSbmsCargo = null;
				if (pageCollection.containsKey("APP_SBMS_Collection")) {
					appSbmsColl = (APP_SBMS_Collection) pageCollection
							.get("APP_SBMS_Collection");
				}
				final String backToMyAccess = (String) request
						.get(AppConstants.BACK_TO_MY_ACCESS_BUTTON);
				if (appSbmsColl != null && !appSbmsColl.isEmpty()) {
					appSbmsCargo = appSbmsColl.getCargo(0);
					// setting values to the APP_SBMS_Cargo
					appSbmsCargo.setApp_num(appNum);
					if(beforeSbmsColl != null && !beforeSbmsColl.isEmpty()){
						appSbmsCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
					}else{
						appSbmsCargo.setRowAction(FwConstants.ROWACTION_INSERT);
					}

					if (appSbmsCargo.getFs_ivw_resp() == null) {
						appSbmsCargo.setFs_ivw_resp(AppConstants.ZERO);
					}

					if (appSbmsCargo.getCare_exmp_ind() == null) {
						appSbmsCargo.setCare_exmp_ind(AppConstants.ZERO);
					}

					if (appSbmsCargo.getEdb_exmp_ind() == null) {
						appSbmsCargo.setEdb_exmp_ind(AppConstants.ZERO);
					}

					if (appSbmsCargo.getTrnsp_exmp_ind() == null) {
						appSbmsCargo.setTrnsp_exmp_ind(AppConstants.ZERO);
					}

					if (appSbmsCargo.getWork_exmp_ind() == null) {
						appSbmsCargo.setWork_exmp_ind(AppConstants.ZERO);
					}

					if (appSbmsCargo.getWthr_exmp_ind() == null) {
						appSbmsCargo.setWthr_exmp_ind(AppConstants.ZERO);
					}

					if (appSbmsCargo.getUcmft_exmp_ind() == null) {
						appSbmsCargo.setUcmft_exmp_ind(AppConstants.ZERO);
					}

					if (appSbmsCargo.getBus_hr_exmp_ind() == null) {
						appSbmsCargo.setBus_hr_exmp_ind(AppConstants.ZERO);
					}

					if (appSbmsCargo.getIlns_exmp_ind() == null) {
						appSbmsCargo.setIlns_exmp_ind(AppConstants.ZERO);
					}

					if (appSbmsCargo.getCc_exmp_ind() == null) {
						appSbmsCargo.setCc_exmp_ind(AppConstants.ZERO);
					}

					if (appSbmsCargo.getOthr_exmp_ind() == null) {
						appSbmsCargo.setOthr_exmp_ind(AppConstants.ZERO);
					}

					if (appSbmsCargo.getOthr_rsn_txt() == null) {
						appSbmsCargo.setOthr_rsn_txt(FwConstants.SPACE);
					}

					if (appSbmsCargo.getSps_fst_nam() == null) {
						appSbmsCargo.setSps_fst_nam(FwConstants.SPACE);
					}

					if (appSbmsCargo.getSps_last_nam() == null) {
						appSbmsCargo.setSps_last_nam(FwConstants.SPACE);
					}

					if (appSbmsCargo.getSps_mid_init() == null
							|| FwConstants.EMPTY_STRING.equals(appSbmsCargo
									.getSps_mid_init())) {
						appSbmsCargo.setSps_mid_init(FwConstants.SPACE);
					}

					if (appSbmsCargo.getSps_esign_ind() == null) {
						appSbmsCargo.setSps_esign_ind(FwConstants.ZERO);
					}

					// EDSP Starts
					if (appSbmsCargo.getFst_nam() == null) {
						appSbmsCargo.setFst_nam(FwConstants.SPACE);
					}

					if (appSbmsCargo.getLast_nam() == null) {
						appSbmsCargo.setLast_nam(FwConstants.SPACE);
					}

					if (appSbmsCargo.getMid_init() == null
							|| FwConstants.EMPTY_STRING.equals(appSbmsCargo
									.getMid_init())) {
						appSbmsCargo.setMid_init(FwConstants.SPACE);
					}
					if (appSbmsCargo.getE_sign_ind() == null) {
						appSbmsCargo.setE_sign_ind(FwConstants.ZERO);
					}
					if (appSbmsCargo.getUnable_sign_ind() == null) {
						appSbmsCargo.setUnable_sign_ind(FwConstants.ZERO);
					}
					if (appSbmsCargo.getVoter_registration_sw() == null) {
						appSbmsCargo.setVoter_registration_sw(FwConstants.SPACE);
					}
					if (appSbmsCargo.getElectronically_sign_ind() == null) {
						appSbmsCargo.setElectronically_sign_ind(FwConstants.ZERO);
					}
					if (appSbmsCargo.getInfo_exchange_consent_ind() == null) {
						appSbmsCargo.setInfo_exchange_consent_ind(FwConstants.ZERO);
					}
					if (appSbmsCargo.getCitizenship_sign() == null) {
						appSbmsCargo.setCitizenship_sign(FwConstants.ZERO);
					}
					if (appSbmsCargo.getAuthrep_citizenship_sign() == null) {
						appSbmsCargo.setAuthrep_citizenship_sign(FwConstants.ZERO);
					}
					boolean eligible = false;
					boolean snapFlag = false;
					short[] pgmKey = (short[]) session.get(FwConstants.RMC_PROGRAM_KEY);
					if (pgmKey[2] == 1) {
					snapFlag = true;
					}
					if(snapFlag){
						final ABFinalSubmitBO abFinalSubmitBO = new ABFinalSubmitBO();
						eligible = abFinalSubmitBO.checkExpeditedSNAPForRMB(appNum);
					if(eligible){
						appSbmsCargo.setExpedited_fap_sw(FwConstants.YES);
						}else{
						appSbmsCargo.setExpedited_fap_sw(FwConstants.NO);	
						}
					}else{
						appSbmsCargo.setExpedited_fap_sw(FwConstants.NO);	
					}
					if (medicaid) {
						appSbmsCargo.setMedicaid_abd_sw(FwConstants.YES);
					} else {
						appSbmsCargo.setMedicaid_abd_sw(FwConstants.NO);
					}
					if (pregnant) {
						appSbmsCargo.setPregnant_sw(FwConstants.YES);
					} else {
						appSbmsCargo.setPregnant_sw(FwConstants.NO);
					}
					if (newborn) {
						appSbmsCargo.setNew_born_sw(FwConstants.YES);
					} else {
						appSbmsCargo.setNew_born_sw(FwConstants.NO);
					}
					final Map httpSession = (Map) session.get(FwConstants.HTTP_SESSION);
					final Set caseArMap = (Set) httpSession.get(AppConstants.AR_FLAG);

					final String caseNumber = (String) httpSession
							.get("CMB_CASE_NUM");
					final String helpIndvIndex = (String) session
							.get(FwConstants.HELP_INDIVIDUAL_INDEX);
					
					final short[] programKeyArray = (short[]) session
							.get(FwConstants.RMC_PROGRAM_KEY);
					
					final boolean maReqFlag = programManager
							.isThisProgramRequested(programKeyArray,
									FwConstants.FMA_INDEX);
					final boolean ccReqFlag = programManager
							.isThisProgramRequested(programKeyArray,
									FwConstants.CC_INDEX);
					final boolean wicReqFlag = programManager
							.isThisProgramRequested(programKeyArray,
									FwConstants.WIC_INDEX);
					final boolean fsReqFlag = programManager
							.isThisProgramRequested(programKeyArray,
									FwConstants.FS_INDEX);
					final boolean tanfReqFlag = programManager
							.isThisProgramRequested(programKeyArray,
									FwConstants.TANF_INDEX);

					boolean isAr = false;
					if(caseArMap!=null){
						isAr=caseArMap.contains(caseNumber);
					}

					finalBO.validateRMBFinalSubmission(appSbmsCargo, isAr,
							helpIndvIndex, maReqFlag,ccReqFlag,wicReqFlag,fsReqFlag,tanfReqFlag);

					sbms = true;
					// VACMS end - converting FS to CC
					// if any errors are there validation messages are thrown to the user
				}

				if (checkBackToMyAccessSelected(request)
						|| finalBO.hasMessages()) {
					if (backToMyAccess == null) {
						request.put(FwConstants.MESSAGE_LIST,
								finalBO.getMessageList());
					}

					pageCollection.put("APP_SBMS_Collection", appSbmsColl);
					pageCollection.put("APP_AUTH_REP_Collection",
							appAuthRepColl);
					pageCollection.put(FwConstants.PAGE_COMPONENT_LIST,
							beforeColl.get(FwConstants.PAGE_COMPONENT_LIST));

					return;
				}
				
				int clickSubmitCounter = 0;
				if(session.get("clickSubmitCounter") != null) {
					clickSubmitCounter = (int) session.get("clickSubmitCounter") + 1;
				} else {
					clickSubmitCounter = 1;
				}
				session.put("clickSubmitCounter", clickSubmitCounter);
				logger.log(ARTransactionManagedEJBBean.class,ILog.FATAL,"DeepLog::CP_DEBUG_LOGS::1:: methodName::storeFinalApplicationSubmission");
				logger.log(ARTransactionManagedEJBBean.class,ILog.FATAL,"DeepLog::CP_DEBUG_LOGS::1:: Number of times user clicked on submit button: " + clickSubmitCounter);
				
				final short[] programKeyArray = (short[]) session
						.get(FwConstants.RMC_PROGRAM_KEY);
				final String programArray = Arrays.toString(programKeyArray);
				APP_INDV_Collection appIndvCollection = new APP_INDV_Collection();
				if (programKeyArray != null && programArray.charAt(1) == '1'
						&& !programArray.substring(2).contains(FwConstants.ONE)) {
					appIndvCollection = finalBO.loadPeople(appNum);
		
				final SSACompositeRequestType ssaCompositeRequestType = new SSACompositeRequestType();
				final List<SSACompositeIndividualRequestType> ssaCompositeIndvList = new ArrayList<SSACompositeIndividualRequestType>();
				Boolean ssnflag = true;
				for (int i = 0; i < appIndvCollection.size(); i++) {
					SSACompositeIndividualRequestType ssaCompositeIndividual = new SSACompositeIndividualRequestType();
					final APP_INDV_Cargo appIndvCargo = appIndvCollection
							.getCargo(i);
					if (appIndvCargo.getSsn_num() != null
							&& appIndvCargo.getSsn_num().length() == 9) {
						ssaCompositeIndividual = finalBO
								.generateIndivRequest(appIndvCargo);
					} else {
						ssnflag = false;
						break;
					}
					ssaCompositeIndvList.add(ssaCompositeIndividual);
				}
				if(null!=ssaCompositeIndvList && !ssaCompositeIndvList.isEmpty())
				ssaCompositeRequestType
				.setSSACompositeIndividualRequest(ssaCompositeIndvList
						.toArray(new SSACompositeIndividualRequestType[ssaCompositeIndvList
						                                               .size()]));
				final boolean[] ssaResults = new boolean[appIndvCollection
				                                         .size()];
				boolean[] ssnResults = new boolean[appIndvCollection.size()];
				boolean[] citizenResults = new boolean[appIndvCollection.size()];
				boolean[] wageResults = new boolean[appIndvCollection.size()];
				boolean[] uiBenefitResults = new boolean[appIndvCollection
						.size()];
				boolean[] workingNumberResults = new boolean[appIndvCollection
						.size()];
				Arrays.fill(ssaResults, false);
				if (ssnflag) {
					// make SSA Composite Web Service call
					final SSAWebServiceBO ssaBo = new SSAWebServiceBO();
					try {
						SSACompositeResponseType ssaCompositeResponseType =null; 
						VerifySSAResponseE verifySSAResponseE=ssaBo
								.getSSAVerification(txnBean,
										ssaCompositeRequestType);
							if (verifySSAResponseE != null) {
								final VerifySSAResponse verifySSAResponse = verifySSAResponseE
										.getVerifySSAResponse();
								if (verifySSAResponse != null) {
									ssaCompositeResponseType = verifySSAResponse
											.getSSACompositeResponse();
								}
							}
						if (ssaCompositeResponseType != null) {
							appIndvCollection.getCargo(0);

							storeSSAResponse(appIndvCollection,
									ssaCompositeResponseType);
							ssnResults = finalBO
									.ssnValidation(appIndvCollection);
							citizenResults = finalBO
									.citizenValidation(appIndvCollection);

						}
					} catch (final Exception e) {
						log(ILog.ERROR, e.getMessage());
						exceptionManagerLog(e, getClass().getName(), "storeFinalApplicationSubmission");
					}
				}
				boolean rteresult = false;
				for (int z = 0; z < appIndvCollection.size(); z++) {
					rteresult = !ssaResults[z] != !false;
					break;
				}
				final String rteTest = FwConfigurationManager.getInstance()
						.getEnvironmentProperty(AppConstants.RTE_TEST_FLAG);
				if (FwConstants.TRUE.equalsIgnoreCase(rteTest)||rteresult) {
					GetWagesInput getWagesInput = new GetWagesInput();
					getWagesInput = finalBO.generateWagesInput(txnBean,appIndvCollection);
					gov.state.nextgen.business.ejb.services.st.dol.GetWagesInput wpWagesInput = new gov.state.nextgen.business.ejb.services.st.dol.GetWagesInput();
					wpWagesInput = finalBO.generateWPWagesInput(txnBean,appIndvCollection);
					CP_DOL_WAGES_INFO_Collection wageColl = new CP_DOL_WAGES_INFO_Collection();
					final DOLWebServiceBO dolBo = new DOLWebServiceBO();
					try {
						final gov.state.nextgen.business.ejb.services.st.dol.GetWagesResponse getWPWagesResponse = dolBo
								.getWageInquiryFromWP(txnBean, wpWagesInput);
						if ((getWPWagesResponse != null)&&(getWPWagesResponse.getResponse().getWageInfo()!=null)
								&& (!getWPWagesResponse.getResponse().getWageInfo().isEmpty())) {
							wageColl = storeWPDOLWagesResponse(
									appIndvCollection, getWPWagesResponse);

						}if(!((getWPWagesResponse != null)&&(getWPWagesResponse.getResponse()!=null)
								&&(getWPWagesResponse.getResponse().getWageInfo().size() ==appIndvCollection.size())))
							{	getWagesInput=finalBO.generateWagesInputForRest(getWagesInput,getWPWagesResponse);
						final GetWagesResponse getWagesResponse = dolBo
								.getWageInquiry(txnBean, getWagesInput);
						if (getWagesResponse != null
								&& !getWagesResponse.getResponse().getWageInfo()
								.isEmpty()) {
							wageColl.addAll( storeDOLWagesResponse(
									appIndvCollection, getWagesResponse));
							
						}
						wageResults = wagesValidation(appIndvCollection,
								wageColl);
						}
					} catch (final Exception e) {
						log(ILog.ERROR, e.getMessage());
						exceptionManagerLog(e, getClass().getName(), "storeFinalApplicationSubmission");
					}
				}
					storeRTEResults(appIndvCollection, ssaResults, ssnResults,
							citizenResults, wageResults, uiBenefitResults,
							workingNumberResults);
				
				}		
				try {

					if (sbms) {
						finalBO.storeFinalApplicationSubmission(appSbmsColl);
						pageCollection.put("APP_SBMS_Collection", appSbmsColl);
					}

					// only when authorized rep name entered updates
					// database
					if (authRep) {
						finalBO.storeAppAuthRep(appAuthRepColl);
					}
					final RMBRequestManager rmbRqstManager = new RMBRequestManager();
					final RMB_RQST_Collection rmbcoll = (RMB_RQST_Collection) session
							.get(AppConstants.RMB_RQST_COLLECTION);
					RMB_RQST_Cargo rmbRqstCargo =null;
					if (rmbcoll != null && !rmbcoll.isEmpty()) {
						rmbRqstCargo = rmbcoll.getCargo(0);

						rmbRqstCargo
								.setStat_cd(AppConstants.AFB_SUBMISSION_READY);

						rmbRqstCargo.setApp_end_dt(String.valueOf(fwDate
								.getDate()));
						rmbRqstCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
						rmbRqstManager.storeRMBRqst(rmbcoll);
					}

					// making the final submission page complete
					driverManager.makeComplete(FwConstants.RMC_DRIVER,
							currentPageID, driverArray,
							(String) session.get(AppConstants.APP_NUMBER));

					javaTransactionSuccess();
					request.put(AppConstants.APP_NUMBER, appNum);
					session.put(AppConstants.APP_TYPE, AppConstants.RMB);
					processApplication(txnBean);
					javaTransactionSuccess();
					final String rmcAppNum = (String) session
							.get(AppConstants.AFB_BRIDGES_APP_NUM);
					final Map httpSession = (Map) session
							.get(FwConstants.HTTP_SESSION);
					final String caseNum = (String) httpSession
							.get("CMB_CASE_NUM");
					// IN_PREWORK - to get app_num for rmb
					final SelfServiceRMCAlertBO rmcAlert = new SelfServiceRMCAlertBO();
					final CaseChanges caseChanges = rmcAlert
							.prepareCaseRenewRequest(caseNum, rmcAppNum,
									appNum, rmbRqstCargo);
					final String webServiceURL = FwConfigurationManager
							.getInstance()
							.getEnvironmentProperty(
									AppConstants.SELF_SERVICE_INTEGRATION_WEBSERVICE_URL);
					boolean isError = false;
					try {
						final CaseChangeResponse changeResponse = CallWebService
								.callRMCAlertWebService(webServiceURL,
										caseChanges);
						if (null == changeResponse
								|| !AppConstants.WEBSERVICE_SUCCESS
										.equals(changeResponse.getResponse())) {
							isError = true;
							log(ILog.ERROR,
									getClass().getName()
											+ " : storePreSubmit : Error in invoking RMC Alert Web Service");
							if (null != changeResponse
									&& null != changeResponse.getError()) {
								log(ILog.ERROR, "Error Code : "
										+ changeResponse.getError()
												.getErrorCode()
										+ " : \nError Description : "
										+ changeResponse.getError()
												.getErrorDescription());
							}
						}
					} catch (final Exception e) {
						isError = true;
						log(ILog.ERROR,
								getClass().getName()
										+ " : storePreSubmit : Error in invoking RMC Alert Web Service");
						exceptionManagerLog(e, getClass().getName(), "storeFinalApplicationSubmission");
					} finally {
						if (isError) {
							new ProcessApplicationBO().updateAppStatus(appNum,
									AppConstants.AFB_SUBMISSION_EXCEPTION,
									AppConstants.RMB);
						} else {
							new ProcessApplicationBO().updateAppStatus(appNum,
									AppConstants.RMC_APPLICATION_COMPLETE,
									AppConstants.RMB);
						}
					}
					txnBean.setPageCollection(pageCollection);
				} catch (final FwException fe) {
					javaTransactionFailure();
					throw exceptionManagerLog(fe, getClass().getName(), "storeFinalApplicationSubmission");
				} catch (final Exception e) {
					javaTransactionFailure();
					final FwException fe = createFwException(getClass()
							.getName(),
							"preSubmitBO.storePreApplicationSubmission", e);
					throw exceptionManagerLog(fe, getClass().getName(), "storeFinalApplicationSubmission");
				}

			} catch (final FwException fe) {
				throw exceptionManagerLog(fe, getClass().getName(), "storeFinalApplicationSubmission");
			} catch (final Exception e) {
				final FwException fe = createFwException(getClass().getName(),
						"storeFinalApplicationSubmission", e);
				throw exceptionManagerLog(fe, getClass().getName(), "storeFinalApplicationSubmission");
			}
			// send app num to queue
			final StringBuilder afbAppMessage = new StringBuilder();
			afbAppMessage.append(FwConstants.AFB_SUBSYSTEM_IND)
					.append(FwConstants.MESSAGE_DELIMITER).append(appNum);

			final ABFinalSubmitBO abFinalSubmitBO = new ABFinalSubmitBO();
			abFinalSubmitBO.storeAppPDFXML(txnBean);

			log(ILog.INFO,
					"ARTransactionManagedEJBBean::storeFinalApplicationSubmission::End");
		} catch (final FwException fe) {
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(getClass().getName());
			we.setCallingMethodID("storeFinalApplicationSubmission");
			we.setFwException(fe);
			throw exceptionManagerLog(fe, getClass().getName(), "storeFinalApplicationSubmission");
		} catch (final Exception e) {
			final FwException fe = createFwException(getClass().getName(),
					"storeFinalApplicationSubmission", e);
			throw exceptionManagerLog(fe, getClass().getName(), "storeFinalApplicationSubmission");
		}

		log(ILog.INFO,
				"ARTransactionManagedEJBBean.storeFinalApplicationSubmission() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");

	}
	
	public void saveExitFinalRMB(final FwTransaction txnBean){

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"ARTransactionManagedEJBBean.saveExitFinalRMB() - START");


		final Map session = txnBean.getSession();
		final Map request = txnBean.getRequest();
		final Map pageCollection = txnBean.getPageCollection();
		
		final ABFinalSubmitBO finalBO = new ABFinalSubmitBO();
		String appNum = null;
		boolean authRep = false;
		boolean sbms = false;
		try {
			// getting current pageid from request
			final String currentPageID = (String) request
					.get(FwConstants.CURRENT_PAGE_ID);

			// Auth Rep Cargo and Collection
			APP_AUTH_REP_Collection appAuthRepColl = null;// new

			APP_AUTH_REP_Cargo appAuthRepCargo = null;// new

			if (pageCollection.containsKey("APP_AUTH_REP_Collection")) {
				appAuthRepColl = (APP_AUTH_REP_Collection) pageCollection
						.get("APP_AUTH_REP_Collection");
			}

			// getting before collection from before collection
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);
			final APP_SBMS_Collection beforeSbmsColl = (APP_SBMS_Collection) beforeColl.get("APP_SBMS_Collection");

			// getting driver status
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);

			// getting app number
			appNum = (String) session.get(AppConstants.APP_NUMBER);

			// getting APP_SBMS_Collection from page collection
			APP_SBMS_Collection appSbmsColl = null;
			APP_SBMS_Cargo appSbmsCargo = null;
			if (pageCollection.containsKey("APP_SBMS_Collection")) {
				appSbmsColl = (APP_SBMS_Collection) pageCollection
						.get("APP_SBMS_Collection");
			}
			final String backToMyAccess = (String) request
					.get(AppConstants.BACK_TO_MY_ACCESS_BUTTON);
			if (appSbmsColl != null && !appSbmsColl.isEmpty()) {
				appSbmsCargo = appSbmsColl.getCargo(0);
				// setting values to the APP_SBMS_Cargo
				appSbmsCargo.setApp_num(appNum);
				if(beforeSbmsColl != null && !beforeSbmsColl.isEmpty()){
					appSbmsCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
				}else{
					appSbmsCargo.setRowAction(FwConstants.ROWACTION_INSERT);
				}
				

				if (appSbmsCargo.getFs_ivw_resp() == null) {
					appSbmsCargo.setFs_ivw_resp(AppConstants.ZERO);
				}

				if (appSbmsCargo.getCare_exmp_ind() == null) {
					appSbmsCargo.setCare_exmp_ind(AppConstants.ZERO);
				}

				if (appSbmsCargo.getEdb_exmp_ind() == null) {
					appSbmsCargo.setEdb_exmp_ind(AppConstants.ZERO);
				}

				if (appSbmsCargo.getTrnsp_exmp_ind() == null) {
					appSbmsCargo.setTrnsp_exmp_ind(AppConstants.ZERO);
				}

				if (appSbmsCargo.getWork_exmp_ind() == null) {
					appSbmsCargo.setWork_exmp_ind(AppConstants.ZERO);
				}

				if (appSbmsCargo.getWthr_exmp_ind() == null) {
					appSbmsCargo.setWthr_exmp_ind(AppConstants.ZERO);
				}

				if (appSbmsCargo.getUcmft_exmp_ind() == null) {
					appSbmsCargo.setUcmft_exmp_ind(AppConstants.ZERO);
				}

				if (appSbmsCargo.getBus_hr_exmp_ind() == null) {
					appSbmsCargo.setBus_hr_exmp_ind(AppConstants.ZERO);
				}

				if (appSbmsCargo.getIlns_exmp_ind() == null) {
					appSbmsCargo.setIlns_exmp_ind(AppConstants.ZERO);
				}

				if (appSbmsCargo.getCc_exmp_ind() == null) {
					appSbmsCargo.setCc_exmp_ind(AppConstants.ZERO);
				}

				if (appSbmsCargo.getOthr_exmp_ind() == null) {
					appSbmsCargo.setOthr_exmp_ind(AppConstants.ZERO);
				}

				if (appSbmsCargo.getOthr_rsn_txt() == null) {
					appSbmsCargo.setOthr_rsn_txt(FwConstants.SPACE);
				}

				if (appSbmsCargo.getSps_fst_nam() == null) {
					appSbmsCargo.setSps_fst_nam(FwConstants.SPACE);
				}

				if (appSbmsCargo.getSps_last_nam() == null) {
					appSbmsCargo.setSps_last_nam(FwConstants.SPACE);
				}

				if (appSbmsCargo.getSps_mid_init() == null
						|| FwConstants.EMPTY_STRING.equals(appSbmsCargo
								.getSps_mid_init())) {
					appSbmsCargo.setSps_mid_init(FwConstants.SPACE);
				}

				if (appSbmsCargo.getSps_esign_ind() == null) {
					appSbmsCargo.setSps_esign_ind(FwConstants.ZERO);
				}

				// EDSP Starts
				if (appSbmsCargo.getFst_nam() == null) {
					appSbmsCargo.setFst_nam(FwConstants.SPACE);
				}

				if (appSbmsCargo.getLast_nam() == null) {
					appSbmsCargo.setLast_nam(FwConstants.SPACE);
				}

				if (appSbmsCargo.getMid_init() == null
						|| FwConstants.EMPTY_STRING.equals(appSbmsCargo
								.getMid_init())) {
					appSbmsCargo.setMid_init(FwConstants.SPACE);
				}
				if (appSbmsCargo.getE_sign_ind() == null) {
					appSbmsCargo.setE_sign_ind(FwConstants.ZERO);
				}
				if (appSbmsCargo.getUnable_sign_ind() == null) {
					appSbmsCargo.setUnable_sign_ind(FwConstants.ZERO);
				}
				if (appSbmsCargo.getVoter_registration_sw() == null) {
					appSbmsCargo.setVoter_registration_sw(FwConstants.SPACE);
				}
				if (appSbmsCargo.getElectronically_sign_ind() == null) {
					appSbmsCargo.setElectronically_sign_ind(FwConstants.ZERO);
				}
				if (appSbmsCargo.getInfo_exchange_consent_ind() == null) {
					appSbmsCargo.setInfo_exchange_consent_ind(FwConstants.ZERO);
				}
				if (appSbmsCargo.getCitizenship_sign() == null) {
					appSbmsCargo.setCitizenship_sign(FwConstants.ZERO);
				}
				if (appSbmsCargo.getAuthrep_citizenship_sign() == null) {
					appSbmsCargo.setAuthrep_citizenship_sign(FwConstants.ZERO);
				}
				boolean eligible = false;
				boolean snapFlag = false;
				short[] pgmKey = (short[]) session.get(FwConstants.RMC_PROGRAM_KEY);
				if (pgmKey[2] == 1) {
					snapFlag = true;
				}
				if(snapFlag){
					final ABFinalSubmitBO abFinalSubmitBO = new ABFinalSubmitBO();
					eligible = abFinalSubmitBO.checkExpeditedSNAPForRMB(appNum);
					if(eligible){
						appSbmsCargo.setExpedited_fap_sw(FwConstants.YES);
					}else{
						appSbmsCargo.setExpedited_fap_sw(FwConstants.NO);	
					}
				}else{
					appSbmsCargo.setExpedited_fap_sw(FwConstants.NO);	
				}
				final Map httpSession = (Map) session.get(FwConstants.HTTP_SESSION);
				final Set caseArMap = (Set) httpSession.get(AppConstants.AR_FLAG);

				final String caseNumber = (String) httpSession
						.get("CMB_CASE_NUM");
				final String helpIndvIndex = (String) session
						.get(FwConstants.HELP_INDIVIDUAL_INDEX);

				final short[] programKeyArray = (short[]) session
						.get(FwConstants.RMC_PROGRAM_KEY);

				final boolean maReqFlag = programManager
						.isThisProgramRequested(programKeyArray,
								FwConstants.FMA_INDEX);
				final boolean ccReqFlag = programManager
						.isThisProgramRequested(programKeyArray,
								FwConstants.CC_INDEX);
				final boolean wicReqFlag = programManager
						.isThisProgramRequested(programKeyArray,
								FwConstants.WIC_INDEX);
				final boolean fsReqFlag = programManager
						.isThisProgramRequested(programKeyArray,
								FwConstants.FS_INDEX);
				final boolean tanfReqFlag = programManager
						.isThisProgramRequested(programKeyArray,
								FwConstants.TANF_INDEX);

				boolean isAr = false;
				if(caseArMap!=null){
					isAr=caseArMap.contains(caseNumber);
				}

				finalBO.validateRMBFinalSubmission(appSbmsCargo, isAr,
						helpIndvIndex, maReqFlag,ccReqFlag,wicReqFlag,fsReqFlag,tanfReqFlag);

			}

			if (checkBackToMyAccessSelected(request)
					|| finalBO.hasMessages()) {
				if (backToMyAccess == null) {
					request.put(FwConstants.MESSAGE_LIST,
							finalBO.getMessageList());
				}

				pageCollection.put("APP_SBMS_Collection", appSbmsColl);
				pageCollection.put("APP_AUTH_REP_Collection",
						appAuthRepColl);
				pageCollection.put(FwConstants.PAGE_COMPONENT_LIST,
						beforeColl.get(FwConstants.PAGE_COMPONENT_LIST));

				return;
			}
			finalBO.storeAppRqstStatus(appSbmsColl);

		} catch (final FwException fe) {
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(getClass().getName());
			we.setCallingMethodID("saveExitFinalRMB");
			we.setFwException(fe);
			throw exceptionManagerLog(fe, getClass().getName(), "saveExitFinalRMB");
		} catch (final Exception e) {
			final FwException fe = createFwException(getClass().getName(),
					"saveExitFinalRMB", e);
			throw exceptionManagerLog(fe, getClass().getName(), "saveExitFinalRMB");
		}

		log(ILog.INFO,
				"ARTransactionManagedEJBBean.saveExitFinalRMB() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");

	}
	
	
	

	/**
	 * Process application.
	 *
	 * @param txnBean
	 *            the txn bean
	 * @throws EJBException
	 *             the EJB exception
	 */
	public void processApplication(final FwTransaction txnBean)
			throws EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"ARTransactionManagedEJBBean.processApplication() - START");
		final Map request = txnBean.getRequest();
		final Map sessionMap = txnBean.getSession();
		final ABSaveAndExitBO submitApplicationBO = new ABSaveAndExitBO();
		final ProcessApplicationBO processApplicationBO = new ProcessApplicationBO();
		String appNum = null;
		final Map session = txnBean.getSession();
		final String appType = (String) session.get(AppConstants.APP_TYPE);
		try {
			/** get string message */
			appNum = (String) request.get(AppConstants.APP_NUMBER);
			final int[] driverArray = null;
			boolean continueProcessingOfApp = false;
			String bridgesAppNum = null;
			long appNumsAvbl;
			String appStatCd = FwConstants.EMPTY_STRING;
			String noTouchValue = AppConstants.NO;
			final IndicatorType notouch = new IndicatorType();
			try {
				/**
				 * Start of VaCMS - Removal of Web Service which fetches the
				 * Application Number
				 */
				/**
				 * IN-Prework : Uncommenting old web service code Check to see
				 * the status of the given app.
				 */
				startJavaTransaction(mySessionCtx);
				
				/**
				 * IN-Prework : Removed code to get appStatCd from CP_APP_RQST
				 * and now fetching appType from RMB_RQST and RMC_RQST based on
				 * appType
				 */
				if (AppConstants.RMC.equals(appType)) {
					appStatCd = new ExtractRMCApplicationDetailsBO()
							.getAppStatCd(appNum);
				} else if (AppConstants.RMB.equals(appType)) {
					appStatCd = new ExtractRMBApplicationDetailsBO()
							.getAppStatCd(appNum);
					/** IN-Prework : Use this for testing */
					/**
					 * appStatCd = new
					 * ExtractRMBApplicationDetailsBO().getAppStatCd
					 * ("8000161281");
					 */
				}
				continueProcessingOfApp = processApplicationBO
						.continueProcessing(appStatCd);
				javaTransactionSuccess();
				if (continueProcessingOfApp) {
					
					final RMBRequestManager rmbRqstManager = new RMBRequestManager();
					RMB_RQST_Cargo rmbRqst =  rmbRqstManager.loadRMBRequest(appNum);
					
					if(rmbRqst != null && FwConstants.APPLY_FOR_ADDITIONAL_BENEFITS.equalsIgnoreCase(rmbRqst.getApp_typ())){
						//if its an apply for additional benefits application process it like AFB and split applications
						//RMB application status is already updated at this point. Need to update AFB applicaitonstatus as well
						final ABPreSubmitBO preSubmitBO = new ABPreSubmitBO();
						final ABFinalSubmitBO finalBO = new ABFinalSubmitBO();
						
						final Map req = preSubmitBO.storePreApplicationSubmission(
								appNum, AppConstants.REQUIRED);
						final APP_RQST_Collection appRqstColl = (APP_RQST_Collection) req
								.get("TYPE");
						final APP_RQST_Cargo appRqstCargo = appRqstColl.getCargo(0);

						// Setting the application status to AFB_SUBMISSION_READY
						appRqstCargo
						.setApp_stat_cd(AppConstants.AFB_SUBMISSION_READY);
						appRqstCargo.setApp_cplt_tms(String.valueOf(fwDate
								.getTimestamp()));
						appRqstCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
						// Updating the database with new app rqst cargo
						finalBO.storeAppRqstStatus(appRqstColl);
						
						
						
						String splitInd = AppConstants.NO;
						final gov.state.nextgen.business.ejb.services.st.appreg.webserviceentities.Case caseObj = new RMCNavigationBO().extractApplication(appNum, FwConstants.APPLY_FOR_ADDITIONAL_BENEFITS);
						final gov.state.nextgen.business.ejb.services.st.appreg.webserviceentities.String10ExactType applicationTrackNum = new gov.state.nextgen.business.ejb.services.st.appreg.webserviceentities.String10ExactType();
						List<String> applicationList = new ArrayList<String>();
						APP_PGM_RQST_Cargo appPgmRqstCargo = submitApplicationBO.getPgmRqstCargo(appNum);
						applicationList = submitApplicationBO.getApplicationList(applicationList,appPgmRqstCargo);
						for (int index = 0, size = applicationList.size(); index < size; index++) {
							String application = applicationList.get(index);
							synchronized (this) {
								bridgesAppNum = getAppnum(appNum,
										AppConstants.AFB_APP_CONV_ST_PROCESSING,
										submitApplicationBO);
							}
							applicationTrackNum.setValue(bridgesAppNum);
							StringBuilder programCd =  new StringBuilder();
							caseObj.setApplicationTrackingNumber(applicationTrackNum);
							
							final StringType cpAppNum = new StringType();
							cpAppNum.setValue(appNum);
							caseObj.setCpAppNum(cpAppNum);
							String3Type afbType = new String3Type();
							afbType.setValue(AppConstants.AFB);
							caseObj.setApplicationType(afbType);
							
							//Setting Apply for additional benefits Application type AAB
							IndicatorType indicatorType = new IndicatorType();
							indicatorType.setValue(AppConstants.YES);
							caseObj.setIsApplyForAdditionalBenefitsApp(indicatorType);
							
							if (index == 0) {
								splitInd = AppConstants.YES;
							}
							
							submitApplicationBO.setSelectedProgram(appPgmRqstCargo, application,
									programCd, caseObj);
							
							
							
							String response = null;
							
							final String webServiceURL = FwConfigurationManager
									.getInstance().getEnvironmentProperty(
											AppConstants.AFB_BRIDGES_WEBSERVICE_URL);
							boolean isDolSsn = true;
							int dolssn=0;
							APP_INDV_Collection appIndvCollection = finalBO.loadPeople(appNum);
							final String rteTest = FwConfigurationManager.getInstance()
									.getEnvironmentProperty(AppConstants.RTE_TEST_FLAG);
							
							if(FwConstants.TRUE.equalsIgnoreCase(rteTest)){
								submitApplicationBO.updateVerfResult(appIndvCollection);
							}
							final boolean medOnlyFlag = getProgramInfo(sessionMap);
							RTEWebserviceBO rTEWebserviceBO = new RTEWebserviceBO();
							final boolean dolFlag = rTEWebserviceBO.dolVerification(appNum);
							final boolean ssnFlag = rTEWebserviceBO.ssnVerification(appNum);
							final boolean idProofingFlag = rTEWebserviceBO.idProofingVerification(appNum);
							if (medOnlyFlag && dolFlag && ssnFlag && idProofingFlag ) {
								noTouchValue = callRealTimeEligibilityService(
										sessionMap, appNum, notouch,
										caseObj);
							} else {
								notouch.setValue(noTouchValue);
								caseObj.setNoTouchIndicator(notouch);
								final List<String> elibstatusList = new ArrayList<String>();
								sessionMap
								.put("elibstatusList", elibstatusList);
							}

							boolean isEligible = AppConstants.YES.equals(noTouchValue);
							
							// Auto App Reg
							String autoAppRegValue = isEligible?AppConstants.NO:AppConstants.REQUIRED;
							IndicatorType autoAppReg = new IndicatorType();
							autoAppReg.setValue(autoAppRegValue);
							caseObj.setAutoAppRegIndicator(autoAppReg);
							
							Map pageColl = txnBean.getPageCollection();
							final APP_SBMS_Collection sbmsCollection=(APP_SBMS_Collection) pageColl.get("APP_SBMS_Collection");
							APP_SBMS_Cargo sbmsCargo=null;
							if(sbmsCollection!=null && !sbmsCollection.isEmpty()){
								sbmsCargo=sbmsCollection.getCargo(0);
							}
							// Expedited SNAP
							if(sbmsCargo!=null){
								String expSNAPVal = AppConstants.YES.equalsIgnoreCase(sbmsCargo.getExpedited_fap_sw())?AppConstants.YES:AppConstants.NO;
								IndicatorType expeditedSNAP = new IndicatorType();
								expeditedSNAP.setValue(expSNAPVal);
								caseObj.setExpSNAPIndicator(expeditedSNAP);
							}
							final JAXBContext context = CommonInstanceCreator.getJAXBContext(gov.state.nextgen.business.ejb.services.st.appreg.webserviceentities.Case.class);
							final Marshaller marshaller = context.createMarshaller();
							final StringWriter sw = new StringWriter();
							marshaller.marshal(caseObj, sw);
							final String afbAppOutputXML = sw.toString();
							
							response = CallWebService
									.callAppCreationWebService(webServiceURL,
											caseObj);
							String autoMaticAppregResponse = FwConstants.EMPTY_STRING;
							try {
								if (!isEligible) {
									autoMaticAppregResponse = CallWebService
											.callAutoReg(bridgesAppNum);
									if((response != null)&& response.contains(AppConstants.WEBSERVICE_SUCCESS) 
											&&(autoMaticAppregResponse != null)&& !autoMaticAppregResponse.contains(AppConstants.WEBSERVICE_SUCCESS) 
										    && !autoMaticAppregResponse.contains(AppConstants.WEBSERVICE_SKIP)){
										CallWebService.updateAutoAppReg(webServiceURL, bridgesAppNum);
									}
									
								}
						} catch (final Exception exception) {
							log(ILog.ERROR,
									"CallWebService.callAutoReg:  response :  "
											+ autoMaticAppregResponse
											+ "Exception Message : "
											+ exception.getMessage());
							exceptionManagerLog(exception, getClass().getName(), "processApplication");
						}
								
							if (response != null
									&& response
											.contains(AppConstants.WEBSERVICE_SUCCESS)) {
								log(ILog.INFO,
										"ABTransactionManagedEJBBean.processApplication()- updateSSAppNumConversionStatus - start");
								submitApplicationBO.updateSSAppNumConversionStatus(
										bridgesAppNum,
										AppConstants.AFB_APP_CONV_ST_SUCCESS,
										programCd.toString(),
										FwConstants.EMPTY_STRING);
							} else if (response != null
									&& response.contains("INCOMPLETE")) {
								log(ILog.INFO,
										"ABTransactionManagedEJBBean.processApplication() service response INCOMPLETE");
								submitApplicationBO.storeAppXML(appNum,
										afbAppOutputXML, programCd.toString());
								submitApplicationBO.updateSSAppNumConversionStatus(
										bridgesAppNum,
										AppConstants.AFB_APP_CONV_ST_INCOMPLETE,
										programCd.toString(),
										FwConstants.EMPTY_STRING);
							} else if (response != null
									&& response
											.contains(AppConstants.WEBSERVICE_FAILURE)) {
								log(ILog.INFO,
										"ABTransactionManagedEJBBean.processApplication()- WEBSERVICE_FAILURE");
								submitApplicationBO.storeAppXML(appNum,
										afbAppOutputXML, programCd.toString());
								submitApplicationBO.updateSSAppNumConversionStatus(
										bridgesAppNum,
										AppConstants.AFB_APP_CONV_ST_ERROR,
										programCd.toString(),
										FwConstants.EMPTY_STRING);
							}else{
							    log(ILog.INFO,
		                                "ABTransactionManagedEJBBean.processApplication()- No response form webservice");
		                        submitApplicationBO.storeAppXML(appNum,
		                                afbAppOutputXML, programCd.toString());
		                        submitApplicationBO.updateSSAppNumConversionStatus(
		                                bridgesAppNum,
		                                AppConstants.AFB_APP_CONV_ST_ERROR,
		                                programCd.toString(),
										FwConstants.EMPTY_STRING);
							}
						}
						
					}else{
					
					startJavaTransaction(mySessionCtx);
					/**
					 * check whether the available BRIDGES AppNumm is less than
					 * the Threshold. If Yes then invoke the Web service to
					 * fetch the Bridges app nums. insert into ss_app_xref
					 * table.
					 */
					final IConfiguration iConfiguration = FwConfigurationManager
							.getInstance();
					String appNumThreshHold = iConfiguration
							.getEnvironmentProperty(AppConstants.APP_NUM_THRESHOLD);
					String appNumFetchSize = iConfiguration
							.getEnvironmentProperty(AppConstants.APP_NUM_FETCH_SIZE);
					appNumsAvbl = submitApplicationBO
							.findAvailabeBridgesAppNum();
//					appNumThreshHold = "5";
//					appNumFetchSize = "10";
					String bridgesAppNums = null;
					final AFBUtil afbUtil = new AFBUtil();
					AFBUtil.setAvblAppNums(appNumsAvbl);
					final boolean isInvokeWebService = afbUtil
							.isInvokeWebService(Long
									.parseLong(appNumThreshHold));
					if (isInvokeWebService) {
						final String webServiceURL = FwConfigurationManager
								.getInstance()
								.getEnvironmentProperty(
										AppConstants.SELF_SERVICE_INTEGRATION_WEBSERVICE_URL);
						bridgesAppNums = CallWebService
								.callAppNumGenerateWebService(webServiceURL,
										appNumFetchSize);
						submitApplicationBO.insertSSAppXREF(bridgesAppNums,
								AppConstants.CONVERSION_STATUS_FREE);
						appNumsAvbl = Long.parseLong(appNumThreshHold) + 100;
						AFBUtil.setAvblAppNums(Long.parseLong(appNumThreshHold) + 100);
						AFBUtil.isInvokeService = false;
					}
					synchronized (this) {
						bridgesAppNum = getAppnum(appNum,
								AppConstants.AFB_APP_CONV_ST_PROCESSING,
								submitApplicationBO);
						javaTransactionSuccess();
					}
					startJavaTransaction(mySessionCtx);
					/** extract AFB app. details */
					final gov.state.nextgen.business.ejb.services.st.appreg.webserviceentities.Case caseObj = new RMCNavigationBO()
							.extractApplication(appNum, null);
					final gov.state.nextgen.business.ejb.services.st.appreg.webserviceentities.String10ExactType applicationTrackNum = new gov.state.nextgen.business.ejb.services.st.appreg.webserviceentities.String10ExactType();
					applicationTrackNum.setValue(bridgesAppNum);
					caseObj.setApplicationTrackingNumber(applicationTrackNum);
					final Map httpSession = (Map) sessionMap
							.get(FwConstants.HTTP_SESSION);
					String caseNumber = (String) httpSession
							.get("CMB_CASE_NUM");
					if(AppConstants.RMB.equals(appType)){
						caseNumber = submitApplicationBO.getRMBCaseNumber(appNum);
					}
					final StringType caseN = new StringType();
					caseN.setValue(caseNumber);
					caseObj.setCaseNumber(caseN);
					final StringType cpAppNum=new StringType();
					cpAppNum.setValue(appNum);
					caseObj.setCpAppNum(cpAppNum);
					final JAXBContext context = CommonInstanceCreator.getJAXBContext(gov.state.nextgen.business.ejb.services.st.appreg.webserviceentities.Case.class);
							
					final Marshaller marshaller = context.createMarshaller();
					marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
							Boolean.TRUE);
					final StringWriter sw = new StringWriter();
					marshaller.marshal(caseObj, sw);
					final String afbAppOutputXML = sw.toString();
					// RTE Call
					if (AppConstants.RMB.equals(appType)) {
						final short[] pgmKey = (short[]) programManager
								.loadProgramKey(appNum).get(FwConstants.ZERO);
						sessionMap.put(FwConstants.RMC_PROGRAM_KEY, pgmKey);
						final boolean medOnlyFlag = getProgramInfo(sessionMap);
						if (medOnlyFlag) {
							noTouchValue = callRealTimeEligibilityService(
									sessionMap, appNum, notouch, caseObj);
						} else {
							notouch.setValue(noTouchValue);
							caseObj.setNoTouchIndicator(notouch);
							final List<String> elibstatusList = new ArrayList<String>();
							sessionMap.put("elibstatusList", elibstatusList);
						}
					}
					final String webServiceURL = FwConfigurationManager
							.getInstance().getEnvironmentProperty(
									AppConstants.AFB_BRIDGES_WEBSERVICE_URL);
					final String response = CallWebService
							.callAppCreationWebService(webServiceURL, caseObj);
					log(ILog.INFO, "Webservice response : " + response);
					String pgmCode = processApplicationBO.getPgmCodes(session);
					if (response != null
							&& response
									.contains(AppConstants.WEBSERVICE_SUCCESS)) {
						log(ILog.INFO,
								"ABTransactionManagedEJBBean.processApplication()- updateSSAppNumConversionStatus - start");
						submitApplicationBO.updateSSAppNumConversionStatus(
								bridgesAppNum,
								AppConstants.AFB_APP_CONV_ST_SUCCESS,
								pgmCode,
								FwConstants.EMPTY_STRING);
					} else if (response != null
							&& response.contains("INCOMPLETE")) {
						log(ILog.INFO,
								"ABTransactionManagedEJBBean.processApplication() service response INCOMPLETE");
						submitApplicationBO.storeAppXML(appNum,
								afbAppOutputXML, FwConstants.SPACE);
						submitApplicationBO.updateSSAppNumConversionStatus(
								bridgesAppNum,
								AppConstants.AFB_APP_CONV_ST_INCOMPLETE,
								pgmCode,
								FwConstants.EMPTY_STRING);
					} else if (response != null
							&& response
									.contains(AppConstants.WEBSERVICE_FAILURE)) {
						log(ILog.INFO,
								"ABTransactionManagedEJBBean.processApplication()- WEBSERVICE_FAILURE");
						submitApplicationBO.storeAppXML(appNum,
								afbAppOutputXML, FwConstants.SPACE);
						submitApplicationBO.updateSSAppNumConversionStatus(
								bridgesAppNum,
								AppConstants.AFB_APP_CONV_ST_ERROR,
								pgmCode,
								FwConstants.EMPTY_STRING);
					}else{
					    log(ILog.INFO,
                                "ABTransactionManagedEJBBean.processApplication()- No response form webservice");
                        submitApplicationBO.storeAppXML(appNum,
                                afbAppOutputXML, FwConstants.SPACE);
                        submitApplicationBO.updateSSAppNumConversionStatus(
                                bridgesAppNum,
                                AppConstants.AFB_APP_CONV_ST_ERROR,
                                pgmCode,
								FwConstants.EMPTY_STRING);
					}
					sessionMap.put(AppConstants.AFB_BRIDGES_APP_NUM,
							bridgesAppNum);
					continueProcessingOfApp = false;
				}
				} else {
					return;
				}
				continueProcessingOfApp = false;
				/** End of VaCMS - To fetch the application number from VaCMS */
			} catch (final FwException fe) {
				/** set the isInvokeService to false in case of exception */
				AFBUtil.isInvokeService = false;
				log(ILog.ERROR,
						"Error in ABTransactionManagedEJBBean processApplication Error is: "
								+ fe.getMessage());
				javaTransactionFailure();
				fe.setServiceDescription("Driver is: " + driverArray
						+ " appNumber is: " + appNum);
				throw exceptionManagerLog(fe, getClass().getName(), "processApplication");
			} catch (final Exception e) {
				/** set the isInvokeService to false in case of exception */
				AFBUtil.isInvokeService = false;
				log(ILog.ERROR,
						"Error in ABTransactionManagedEJBBean processApplication Error is: "
								+ e.getMessage());
				javaTransactionFailure();
				final FwException fe = createFwException(getClass().getName(),
						"processApplication - extractApplicationDetails", e);
				fe.setServiceDescription("Driver is: " + driverArray
						+ " appNumber is: " + appNum);
				throw exceptionManagerLog(fe, getClass().getName(), "processApplication");
			}
			try {
				if (continueProcessingOfApp) {
					startJavaTransaction(mySessionCtx);
					String stagingInsertProcessStatus = null;
					if (appStatCd != null) {
						stagingInsertProcessStatus = appStatCd;
					}
					processApplicationBO.updateAppStatus(appNum,
							stagingInsertProcessStatus,
							appType);
					javaTransactionSuccess();
				} else {
					javaTransactionSuccess();
					return;
				}
			} catch (final FwException fe) {
				javaTransactionFailure();
				fe.setServiceDescription("Driver is: " + driverArray
						+ " appNumber is: " + appNum
						+ "Status code from CWW web service call is "
						+ (appStatCd != null ? appStatCd : "appStatCd is null"));
				throw exceptionManagerLog(fe, getClass().getName(), "processApplication");
			} catch (final Exception e) {
				javaTransactionFailure();
				final FwException fe = createFwException(getClass().getName(),
						"processApplication - updateAppStatCd", e);
				fe.setServiceDescription("Driver is: " + driverArray
						+ " appNumber is: " + appNum
						+ "Status code from CWW web service call is "
						+ (appStatCd != null ? appStatCd : "appStatCd is null"));
				throw exceptionManagerLog(fe, getClass().getName(), "processApplication");
			}
		} catch (final FwException fe) {
			/** update the app_stat_cd to "EX" (Exception) */
			startJavaTransaction(mySessionCtx);
			processApplicationBO.updateAppStatus(appNum,
					AppConstants.AFB_SUBMISSION_EXCEPTION,
					appType);
			javaTransactionSuccess();
			exceptionManagerLog(fe, getClass().getName(), "processApplication");
		} catch (final Exception e) {
			/** update the app_stat_cd to "EX" (Exception) */
			startJavaTransaction(mySessionCtx);
			processApplicationBO.updateAppStatus(appNum,
					AppConstants.AFB_SUBMISSION_EXCEPTION,
					appType);
			javaTransactionSuccess();
			exceptionManagerLog(e, getClass().getName(), "processApplication");
		}
		log(ILog.INFO, "ABTransactionManagedEJBBean::processApplication::End");
		log(ILog.INFO,
				"ARTransactionManagedEJBBean.processApplication() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Gets the program info.
	 *
	 * @param sessionMap
	 *            the session map
	 * @return the program info
	 */
	private boolean getProgramInfo(final Map sessionMap) {
		final short[] pgmKey = (short[]) sessionMap
				.get(FwConstants.RMC_PROGRAM_KEY);
		boolean medOnlyFlag = false;

		boolean snapFlag = false;
		boolean tanfFlag = false;
		boolean maFlag = false;
		boolean wicFlag = false;
		boolean cCareFlag = false;

		if (pgmKey[0] == 1) {
			maFlag = true;
		}
		if (pgmKey[9] == 1) {
			tanfFlag = true;
		}
		if (pgmKey[2] == 1) {
			snapFlag = true;
		}

		if (pgmKey[14] == 1) {
			wicFlag = true;
		}
		if (pgmKey[8] == 1) {
			cCareFlag = true;
		}

		if (maFlag && !tanfFlag && !snapFlag && !wicFlag && !cCareFlag) {
			medOnlyFlag = true;
		}
		return medOnlyFlag;
	}

	/**
	 * Call real time eligibility service.
	 *
	 * @param sessionMap
	 *            the session map
	 * @param appNum
	 *            the app num
	 * @param notouch
	 *            the notouch
	 * @param caseObj
	 *            the case obj
	 * @return the string
	 */
	private String callRealTimeEligibilityService(
			final Map sessionMap,
			final String appNum,
			final IndicatorType notouch,
			final gov.state.nextgen.business.ejb.services.st.appreg.webserviceentities.Case caseObj) {
		String noTouchValue = AppConstants.EMPTY_STRING;
		try {
			final List<String> elibstatusList = RMBrealTimeServiceCall
					.loadRTEValue(appNum);
			sessionMap.put("elibstatusList", elibstatusList);
			if (elibstatusList != null && !elibstatusList.isEmpty()) {
				for (final String value : elibstatusList) {
					if ("PE".equalsIgnoreCase(value)
							|| "DN".equalsIgnoreCase(value)) {
						noTouchValue = AppConstants.NO;
						break;
					} else {
						noTouchValue = AppConstants.YES;
					}
				}
			} else {
				noTouchValue = AppConstants.NO;
			}
		} catch (final Exception e) {
			exceptionManagerLog(e, getClass().getName(), "callRealTimeEligibilityService");
			log(ILog.ERROR,
					"ABTransactionManagedEJBBean.processApplication()- WEBSERVICE_FAILURE");
		}
		notouch.setValue(noTouchValue);
		caseObj.setNoTouchIndicator(notouch);
		return noTouchValue;
	}

	/**
	 * getSessionContext.
	 *
	 * @return the session context
	 */
	@Override
	public javax.ejb.SessionContext getSessionContext() {
		return mySessionCtx;
	}

	/**
	 * setSessionContext.
	 *
	 * @param ctx
	 *            the new session context
	 */
	@Override
	public void setSessionContext(final javax.ejb.SessionContext ctx) {
		mySessionCtx = ctx;
	}

	/**
	 *
	 * @param txnBean
	 * @throws javax.ejb.EJBException
	 */
	public void loadRMCPDF(final FwTransaction txnBean)
			throws javax.ejb.EJBException {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ARTransactionManagedEJBBean.loadRMCPDF() - START");
		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			startJavaTransaction(mySessionCtx);

			String appNumber = (String) session.get(AppConstants.APP_NUMBER);
			final String appType = (String) request
					.get(AppConstants.APPLICATION);
			final ABFinalSubmitBO finalBO = new ABFinalSubmitBO();
			if (appType == null) {
				request.put(AppConstants.APPLICATION, AppConstants.AFB);
			}
			if (appNumber == null) {
				appNumber = (String) request.get(AppConstants.APP_NUMBER);
			}

			if (appNumber != null) {
				request.put(AppConstants.APP_NUMBER, appNumber);
				
				if (request.get(FwConstants.PDF_BYTE_ARRAY) == null) {
					// Get Environment
					final IConfiguration configuration = (IConfiguration) FwServiceFactory
							.getInstance().create(IConfiguration.class);
					String environment = configuration
							.getEnvironmentProperty(FwConstants.ENVIRONMENT);
					if ("Prod".equals(environment)) {
						environment = AppConstants.EMPTY_STRING;
					}
					String language = null;
					if (((Map) session.get(FwConstants.HTTP_SESSION))
							.get(FwConstants.LANGUAGE) != null) {
						language = (String) ((Map) session
								.get(FwConstants.HTTP_SESSION))
								.get(FwConstants.LANGUAGE);
					} else {
						language = FwConstants.ENGLISH;
					}

					byte[] byteArray = finalBO.loadRMBPDFForAppNum(appNumber,
							language, FwConstants.NO);

					if (FwConstants.SPANISH.equalsIgnoreCase(language)
							&& byteArray == null) {
						byteArray = finalBO.loadRMBPDFForAppNum(appNumber,
								FwConstants.ENGLISH, FwConstants.NO);
					}
					request.put(FwConstants.PDF_BYTE_ARRAY, byteArray);
				}
			}
			javaTransactionSuccess();
		} catch (final FwWrappedException we) {
			javaTransactionFailure();
			final FwExceptionManager exceptionMgr = (FwExceptionManager) FwServiceFactory
					.getInstance().create(IException.class);
			exceptionMgr.log(we);
		} catch (final FwException fe) {
			javaTransactionFailure();
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(getClass().getName());
			we.setCallingMethodID("loadRMCPDF");
			we.setFwException(fe);
			final FwExceptionManager exceptionMgr = (FwExceptionManager) FwServiceFactory
					.getInstance().create(IException.class);
			exceptionMgr.log(we);
		} catch (final Exception e) {
			javaTransactionFailure();
			final FwException fe = createFwException(getClass().getName(),
					"loadRMCPDF", e);
			final FwWrappedException we = new FwWrappedException(e);
			we.setCallingClassID(getClass().getName());
			we.setCallingMethodID("loadRMCPDF");
			we.setFwException(fe);
			final FwExceptionManager exceptionMgr = (FwExceptionManager) FwServiceFactory
					.getInstance().create(IException.class);
			exceptionMgr.log(we);
		}
		log(ILog.INFO,
				"ARTransactionManagedEJBBean.loadRMCPDF() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Generate rmcpdf map.
	 *
	 * @param txnBean
	 *            the txn bean
	 * @return the map
	 * @throws EJBException
	 *             the EJB exception
	 */
	public Map generateRMCPDFMap(final FwTransaction txnBean)
			throws javax.ejb.EJBException {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"ARTransactionManagedEJBBean.generateRMCPDFMap() - START");
		try {

			log(ILog.DEBUG, "start: generateRMCPDFMap");
			final Map request = txnBean.getRequest();
			final Map session = txnBean.getSession();

			final Map pdfMap = new HashMap();
			final Map rmcDriverMap = new HashMap();
			final Map registrationMap = new HashMap();
			final Map deathDtlsMap = new HashMap();
			final Map movedOutDtlsMap = new HashMap();
			Map marrDtlsMap = new HashMap();
			final Map hshlMemberInfoMap = new HashMap();
			final Map relationshipsMap = new HashMap();
			final Map newBornMap = new HashMap();
			final Map schlEnrollMap = new HashMap();
			final Map disabilityDtlsMap = new HashMap();
			final Map endPregMap = new HashMap();
			final Map addPregMap = new HashMap();
			final Map absentParentMap = new HashMap();
			final Map medicareMap = new HashMap();
			final Map selfEmplMap = new HashMap();
			final Map otherIncomeMap = new HashMap();
			final Map housingBillsMap = new HashMap();
			final Map utilityBillsMap = new HashMap();
			// BO's
			final RMCPdfHelperBO pdfHelperBO = new RMCPdfHelperBO();
			final LivingArrangementBO livingArrBO = new LivingArrangementBO();
			final MaritalBO maritalBO = new MaritalBO();
			final MovedInBO movedInBO = new MovedInBO();
			final SchoolEnrollmentBO schlEnrollBO = new SchoolEnrollmentBO();
			final DisabilityBO disabilityBO = new DisabilityBO();
			final PregnancyBO pregnancyBO = new PregnancyBO();
			final AbsentParentBO absentParentBO = new AbsentParentBO();

			PeopleHandler peopleHandler = null;

			String appNumber = FwConstants.EMPTY_STRING;
			String language = FwConstants.ENGLISH;
			String environment = FwConstants.EMPTY_STRING;

			appNumber = (String) session.get(AppConstants.APP_NUMBER);
			RMC_IN_PRFL_Collection rmcInPrflColl = null;
			// Household Comp
			SortedSet rmcSelPrflHO = null;
			// Employment Income
			SortedSet rmcSelPrflEI = null;
			// Other Income
			SortedSet rmcSelPrflOI = null;
			// Housing Utility
			SortedSet rmcSelPrflHU = null;

			boolean requestAppNumFlag = false;
			if (appNumber == null) {
				appNumber = (String) request.get(AppConstants.APP_NUMBER);
				environment = (String) request.get(FwConstants.ENVIRONMENT);
				if ("Prod".equals(environment)) {
					environment = FwConstants.EMPTY_STRING;
				}
				// commented for PCR# 29436, we should never put the app number
				// in session for pdf. This affects the 'Click Here' link on
				// Home page for RMC.
				// The loadRMCPdf method in ARTransactionManagedEJBBean gets the
				// application number from session first, if we put the app
				// number here in session, for all the 'Click Here' links, PDF
				// for same app number gets opened.

				session.put("RequestAppNumFlag",
						Boolean.valueOf(requestAppNumFlag));
				requestAppNumFlag = true;
			}
			log(ILog.DEBUG, "Inside: generateRMCPDFMap - appNumber: "
					+ appNumber);
			log(ILog.DEBUG, "Inside: generateRMCPDFMap - requestAppNumFlag: "
					+ requestAppNumFlag);
			final Map httpMap = (Map) session.get(FwConstants.HTTP_SESSION);
			short[] programKeyArray = null;
			if (requestAppNumFlag) {
				language = (String) request.get(FwConstants.LANGUAGE);
				peopleHandler = new PeopleHandler();
				peopleHandler.loadPeopleHandler(appNumber);
				session.put(AppConstants.INDIV_MASTER_HANDLER, peopleHandler);

				rmcInPrflColl = rmcResponseProfileManager
						.loadProfile(appNumber);
				session.put(AppConstants.RMC_IN_PRFL_MASTER, rmcInPrflColl);
			} else {
				language = httpMap.get(FwConstants.LANGUAGE).toString();
				// PeopleHandler
				peopleHandler = (PeopleHandler) session
						.get(AppConstants.INDIV_MASTER_HANDLER);

				// Get Environment
				final IConfiguration configuration = (IConfiguration) FwServiceFactory
						.getInstance().create(IConfiguration.class);
				environment = configuration
						.getEnvironmentProperty(FwConstants.ENVIRONMENT);
				if ("Prod".equals(environment)) {
					environment = FwConstants.EMPTY_STRING;
				}
				rmcInPrflColl = (RMC_IN_PRFL_Collection) session
						.get(AppConstants.RMC_IN_PRFL_MASTER);
				if (rmcInPrflColl == null) {
					rmcInPrflColl = rmcResponseProfileManager
							.loadProfile(appNumber);
					session.put(AppConstants.RMC_IN_PRFL_MASTER, rmcInPrflColl);
				}

				programKeyArray = (short[]) session
						.get(FwConstants.RMC_PROGRAM_KEY);

			}
			log(ILog.DEBUG,
					"Inside: generateRMCPdf - : start loading Category Change selection profile");
			rmcSelPrflHO = categorySelectionProfileManager
					.loadCategoryChangeSelectionProfile(appNumber,
							AppConstants.RMC_CAT_HO_COMP_PRFL);
			rmcSelPrflEI = categorySelectionProfileManager
					.loadCategoryChangeSelectionProfile(appNumber,
							AppConstants.RMC_CAT_EMP_PRFL);
			rmcSelPrflOI = categorySelectionProfileManager
					.loadCategoryChangeSelectionProfile(appNumber,
							AppConstants.RMC_CAT_OT_INC_PRFL);
			rmcSelPrflHU = categorySelectionProfileManager
					.loadCategoryChangeSelectionProfile(appNumber,
							AppConstants.RMC_CAT_HO_EXP_PRFL);

			pdfMap.put("RMC_SEL_PRFL_HO", rmcSelPrflHO);
			pdfMap.put("RMC_SEL_PRFL_EI", rmcSelPrflEI);
			pdfMap.put("RMC_SEL_PRFL_OI", rmcSelPrflOI);
			pdfMap.put("RMC_SEL_PRFL_HU", rmcSelPrflHU);

			// read RMC_RQST table for this APP_Number to get the Case_Number
			final RMC_RQST_Cargo rmcRqstCargo = pdfHelperBO
					.loadRMCRequest(appNumber);
			final Map pageCollection = txnBean.getPageCollection();
			final RMC_RQST_Collection rmcRqstColl = new RMC_RQST_Collection();
			rmcRqstColl.addCargo(rmcRqstCargo);
			pageCollection.put(AppConstants.RMC_RQST, rmcRqstColl);
			txnBean.setPageCollection(pageCollection);
			pdfMap.put("RMC_RQST_Cargo", rmcRqstCargo);
			log(ILog.DEBUG,
					"start: generateRMCPdf - Done loading RMC Rqst Cargo");
			final IReferenceTableManager iref = ReferenceTableManager
					.getInstance();
			if (language == null) {
				language = FwConstants.ENGLISH;
			}
			final Timestamp referenceTableDate = Timestamp.valueOf(iref
					.getColumnValue("TPDF", 94, "003", language));
			final Timestamp submissionDate = Timestamp.valueOf(rmcRqstCargo
					.getSbmt_tms());
			final boolean isBeforeDate = submissionDate
					.before(referenceTableDate);

			final String caseNumber = rmcRqstCargo.getCase_num();

			final List pinNumbersList = peopleHandler.getIndivPinNumbers();
			log(ILog.DEBUG,
					"start: generateRMCPdf - Done loading Pin Number List");
			if (programKeyArray == null) {
				final List caseNumberList = new ArrayList();
				caseNumberList.add(caseNumber);
				final Map tempMap = programManager.loadProgramKeyByCaseNumbers(
						caseNumberList, pinNumbersList);
				programKeyArray = (short[]) tempMap.get(AppConstants.PGM_KEY);
				((Boolean) tempMap.get(AppConstants.TFS_FLG)).booleanValue();

				session.put(FwConstants.RMC_PROGRAM_KEY, programKeyArray);
			}

			log(ILog.DEBUG,
					"Inside: generateRMCPdf - Program Key Array Load Done: ");
			pdfMap.put(FwConstants.RMC_PROGRAM_KEY, programKeyArray);

			pdfMap.put(AppConstants.APP_NUMBER, appNumber);
			pdfMap.put(AppConstants.LANGUAGE, language);
			pdfMap.put(FwConstants.ENV, environment);
			pdfMap.put(AppConstants.RMC_IN_PRFL_MASTER, rmcInPrflColl);
			log(ILog.DEBUG, "Inside: generateRMCPdf - Start loading driver ");
			// Get RMC Driver Information
			int[] rmcDriver = { 0 };
			rmcDriver = driverManager.loadDriver(FwConstants.RMC_DRIVER,
					appNumber);
			if (rmcDriver == null || rmcDriver.length <= 0) {
				rmcDriver = driverManager.createDefaultDriver(
						FwConstants.RMC_DRIVER, appNumber);
			}
			rmcDriverMap.put("RMC_DRVR", rmcDriver);
			pdfMap.put("RMCDriverMap", rmcDriverMap);
			log(ILog.DEBUG,
					"Inside: generateRMCPdf - Driver load done, start names list");
			// get First name and Last names List of individuals under this
			// appNumber
			final List namesList = pdfHelperBO.getFirstAndLastNames(appNumber);
			final List appIndvNamesList = pdfHelperBO
					.getAppIndvFirstAndLastNames(appNumber);
			final Iterator itr = appIndvNamesList.iterator();
			while (itr.hasNext()) {
				namesList.add(itr.next());
			}
			log(ILog.DEBUG,
					"Inside: generateRMCPdf - names list done, load ages");
			pdfMap.put("NamesList", namesList);
			final Map namesMap = pdfHelperBO.getFirstAndLastNamesMap(namesList);
			pdfMap.put("NamesMap", namesMap);

			// ages map
			final List agesList = pdfHelperBO.getIndividualAgeList(appNumber);
			final Map ageMap = new HashMap();
			final int agesListSize = agesList.size();
			for (int i = 0; i < agesListSize; i++) {
				final Map tempAgesMap = (Map) agesList.get(i);
				if (tempAgesMap.get("BRTH_DT") != null) {
					ageMap.put(tempAgesMap.get("INDV_SEQ_NUM"),
							tempAgesMap.get("BRTH_DT"));
				}
			}
			pdfMap.put("AgesMap", ageMap);
			log(ILog.DEBUG,
					"Inside: generateRMCPdf - ages list done, load Contact Details");
			// load Contact Details, ARACD
			// Get Registration Information
			if (!driverManager
					.getStatus(FwConstants.RMC_DRIVER, "ARACD", rmcDriver)
					.equals(String
							.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))) {

				APP_RGST_Collection regiSummaryColl = new APP_RGST_Collection();
				regiSummaryColl = pdfHelperBO.getContactDetails(appNumber);
				registrationMap.put("APP_RGST_Collection", regiSummaryColl);
				pdfMap.put("registrationMap", registrationMap);
			}
			log(ILog.DEBUG,
					"Inside: generateRMCPdf - Contact Details done, load Death Details");
			// load Death Details, ARHDE
			if (!driverManager
					.getStatus(FwConstants.RMC_DRIVER, "ARHMO", rmcDriver)
					.equals(String
							.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))) {
				INDV_LIVE_CHG_Collection indvLiveChgColl = new INDV_LIVE_CHG_Collection();
				indvLiveChgColl = livingArrBO
						.loadLivingArrangementDetailsByLiveArrType(appNumber,
								AppConstants.SOMEONE_DIED);
				deathDtlsMap.put("INDV_LIVE_CHG_Collection", indvLiveChgColl);
				pdfMap.put("deathDtlsMap", deathDtlsMap);
			}
			log(ILog.DEBUG,
					"Inside: generateRMCPdf - Death Details done, load Divorce Details");
			// load Divorce Details and marriage details, ARHMA
			if (!driverManager
					.getStatus(FwConstants.RMC_DRIVER, "ARHMA", rmcDriver)
					.equals(String
							.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))) {
				final INDV_LIVE_CHG_Collection divorceColl = maritalBO
						.loadDivorceDetails(appNumber,
								AppConstants.DIVORCE_INDICATOR);
				final Map divorceDtlsMap = new HashMap();
				divorceDtlsMap.put("INDV_LIVE_CHG_COLL", divorceColl);
				pdfMap.put("divorceDtlsMap", divorceDtlsMap);

				marrDtlsMap = maritalBO.loadMarriageDetails(appNumber,
						AppConstants.MARRIAGE_INDICATOR, namesMap);
				pdfMap.put("marrDtlsMap", marrDtlsMap);
			}
			log(ILog.DEBUG,
					"Inside: generateRMCPdf - Divorce Details done, load Moved Out Details");
			// load Moved Out Details, ARHMO
			if (!driverManager
					.getStatus(FwConstants.RMC_DRIVER, "ARHMO", rmcDriver)
					.equals(String
							.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))) {
				final INDV_LIVE_CHG_Collection prsnLeftTheHomeColl = livingArrBO
						.loadMovedOutDetails(appNumber,
								AppConstants.SOMEONE_DIED);
				movedOutDtlsMap
						.put("MOVED_OUT_Collection", prsnLeftTheHomeColl);
				pdfMap.put("movedOutDtlsMap", movedOutDtlsMap);
			}
			log(ILog.DEBUG,
					"Inside: generateRMCPdf - Moved Out Details done, load Moved In Details");
			// load HouseHold Member Information, i.e Moved In Details, ARHMI
			if (!driverManager
					.getStatus(FwConstants.RMC_DRIVER, "ARHMI", rmcDriver)
					.equals(String
							.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))) {
				final APP_INDV_Collection movedInColl = movedInBO
						.loadMovedInDetails(appNumber);
				hshlMemberInfoMap.put("APP_INDV_Collection", movedInColl);
				pdfMap.put("movedInDtlsMap", hshlMemberInfoMap);
			}
			log(ILog.DEBUG,
					"Inside: generateRMCPdf - Moved In Details done, load Relationships Details");
			// load Relationships, ARHRL, display on RN row, we are displaying
			// CW and RM row for divorce and marriage respectively.
			if (!driverManager
					.getStatus(FwConstants.RMC_DRIVER, "ARHRL", rmcDriver)
					.equals(String
							.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))) {
				APP_HSHL_RLT_Collection appHshlRltColl = new APP_HSHL_RLT_Collection();

				appHshlRltColl = pdfHelperBO.loadRelationshipDetails(appNumber,
						AppConstants.RMC_NEW_RECORD_IND);
				relationshipsMap.put("APP_HSHL_RLT_Collection", appHshlRltColl);
				pdfMap.put("hshlRelationMap", relationshipsMap);

				// load APP_IN_NEWB_Collection
				APP_IN_NEWB_Collection appNewBornColl = new APP_IN_NEWB_Collection();
				appNewBornColl = pdfHelperBO.loadNewBornForPdf(appNumber);
				newBornMap.put("APP_IN_NEWB_Collection", appNewBornColl);
				pdfMap.put("newBornMap", newBornMap);
			}
			log(ILog.DEBUG,
					"Inside: generateRMCPdf - Relationship Details done, load School Enrollment Details");
			// load School Enrollment, ARHSE
			if (!driverManager
					.getStatus(FwConstants.RMC_DRIVER, "ARHSE", rmcDriver)
					.equals(String
							.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
					&& programKeyArray != null) {
				final List schoolList = schlEnrollBO
						.findSchoolEnrollmentPeople(peopleHandler,
								programKeyArray);
				schlEnrollMap.put("schoolList", schoolList);
				// load APP_IN_SCHLE_Collection
				if (schoolList != null && !schoolList.isEmpty()) {
					APP_IN_SCHLE_Collection appInSchColl = new APP_IN_SCHLE_Collection();
					appInSchColl = pdfHelperBO
							.getSchoolEnrollmentForPdf(appNumber);
					schlEnrollMap.put("APP_IN_SCHLE_Collection", appInSchColl);
					pdfMap.put("schlEnrollMap", schlEnrollMap);
				}
			}
			log(ILog.DEBUG,
					"Inside: generateRMCPdf - SchoolEnrollment Details done, load Disability Details");
			// load Disability Details
			// for PCR 30677
			if (!driverManager
					.getStatus(FwConstants.RMC_DRIVER, "ARHDD", rmcDriver)
					.equals(String
							.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))) {
				final APP_IN_DABL_Collection appInDablColl = disabilityBO
						.loadDisability(appNumber);
				disabilityDtlsMap.put("APP_IN_DABL_Collection", appInDablColl);
				pdfMap.put("disabilityDtlsMap", disabilityDtlsMap);
			}
			log(ILog.DEBUG,
					"Inside: generateRMCPdf - Disability Details done, load End Pregnancy Details");
			// load End Pregnancy
			if (!driverManager
					.getStatus(FwConstants.RMC_DRIVER, "ARHPD", rmcDriver)
					.equals(String
							.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))) {
				final APP_IN_PREG_Collection appInPregColl = pregnancyBO
						.loadPregnancyDetails(appNumber,
								AppConstants.RMC_END_RECORD_IND);
				endPregMap.put("APP_IN_PREG_Collection", appInPregColl);
				pdfMap.put("endPregMap", endPregMap);

				// load Add Pregnancy
				final APP_IN_PREG_Collection addPregColl = pregnancyBO
						.loadPregnancyDetails(appNumber,
								AppConstants.RMC_NEW_RECORD_IND);
				addPregMap.put("ADD_PREG_Collection", addPregColl);
				pdfMap.put("addPregMap", addPregMap);
			}
			log(ILog.DEBUG,
					"Inside: generateRMCPdf - End Pregnancy & Add Pregnancy Details done, load Absent Parent Details");
			if (!driverManager
					.getStatus(FwConstants.RMC_DRIVER, "ARHAP", rmcDriver)
					.equals(String
							.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))) {
				// load APP_ABS_PRNT_Collection
				final INDIVIDUAL_Custom_Collection indvColl = peopleHandler
						.getSortedIndividualsByIndvSeqNum();
				final int indvCollSize = indvColl.size();
				final String[] indvSeq = new String[indvCollSize];
				// Getting all indv seq numbers
				for (int i = 0; i < indvCollSize; i++) {
					indvSeq[i] = indvColl.getResult(i).getIndv_seq_num();
				}

				APP_ABS_PRNT_Cust_Collection appAbsPrnCustColl = new APP_ABS_PRNT_Cust_Collection();
				appAbsPrnCustColl = absentParentBO.loadAbsentParentSummary(
						appNumber, indvSeq);
				absentParentMap.put("APP_ABS_PRNT_Cust_Collection",
						appAbsPrnCustColl);

				// Below logic is to get the details for displaying More About
				// Parents Section in PDF(Paternity Switch)
				List fatherMotherList = null;
				fatherMotherList = absentParentBO.findAbsentParent(
						peopleHandler, rmcInPrflColl, appNumber,
						programKeyArray);
				int fatherMotherListSize = 0;

				if (fatherMotherList != null && !fatherMotherList.isEmpty()) {
					fatherMotherListSize = fatherMotherList.size();
				}
				String indvSeqNumber = null;
				String absInd = null;
				final APP_IN_ABSNP_Collection appInAbsnpColl = new APP_IN_ABSNP_Collection();
				APP_IN_ABSNP_Cargo appInAbnspCargo = new APP_IN_ABSNP_Cargo();
				for (int i = 0; i < fatherMotherListSize; i++) {
					final IndivTypeSeqBean indvTypeSeqBean = (IndivTypeSeqBean) fatherMotherList
							.get(i);
					indvSeqNumber = indvTypeSeqBean.getIndivSeqNum();
					absInd = indvTypeSeqBean.getType();
					appInAbnspCargo = pdfHelperBO
							.loadAbsentParentDetailsForPrintPdf(appNumber,
									indvSeqNumber, absInd);
					appInAbsnpColl.addCargo(appInAbnspCargo);

				}
				absentParentMap.put("APP_IN_ABSNP_Collection", appInAbsnpColl);
				pdfMap.put("absentParentMap", absentParentMap);
			}

			log(ILog.DEBUG,
					"Inside: generateRMCPdf - Absent Parent Details done, load Medicare Details");
			// load Medicare Details
			if (!driverManager
					.getStatus(FwConstants.RMC_DRIVER, "ARHMD", rmcDriver)
					.equals(String
							.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))) {
				// load APP_IN_MEDCR_Collection
				APP_IN_MEDCR_Collection appInMedicareColl = new APP_IN_MEDCR_Collection();
				appInMedicareColl = pdfHelperBO
						.getMedicareDetailsForPdf(appNumber);
				medicareMap.put("APP_IN_MEDCR_Collection", appInMedicareColl);
				pdfMap.put("medicareMap", medicareMap);
			}
			log(ILog.DEBUG,
					"Inside: generateRMCPdf - MedicareDetails done, load Job Income Details");
			// Check for Previous version
			if (isBeforeDate
					|| !driverManager
							.getStatus(FwConstants.RMC_DRIVER, "ARJID",
									rmcDriver)
							.equals(String
									.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))) {
				// load APP_IN_EMPL Table

				final APP_IN_EMPL_Collection emplColl = pdfHelperBO
						.getEmploymentDetails(appNumber);
				pdfMap.put("APP_IN_EMPL_Collection", emplColl);

				// load APP_IN_EMPL_A_WAGE Table
				final APP_IN_EMPL_A_WAGE_Collection wageColl = pdfHelperBO
						.getEmpAWageDetails(appNumber);
				pdfMap.put("APP_IN_EMPL_A_WAGE_Collection", wageColl);

				// segregate New jobs and Modified jobs
				final APP_IN_EMPL_Collection emplChangeColl = pdfHelperBO
						.getFilteredEmplCollection(emplColl,
								AppConstants.RMC_MODIFIED_RECORD_IND);
				final APP_IN_EMPL_Collection emplNewColl = pdfHelperBO
						.getFilteredEmplCollection(emplColl,
								AppConstants.RMC_NEW_RECORD_IND);
				final APP_IN_EMPL_Collection emplEndColl = pdfHelperBO
						.getFilteredEmplCollection(emplColl,
								AppConstants.RMC_END_RECORD_IND);
				pdfMap.put("emplChangeColl", emplChangeColl);
				pdfMap.put("emplNewColl", emplNewColl);
				pdfMap.put("emplEndColl", emplEndColl);
				// segregate New jobs and Modified jobs in Wage Table
				final APP_IN_EMPL_A_WAGE_Collection wageChangeColl = pdfHelperBO
						.getFilteredWageCollection(wageColl,
								AppConstants.RMC_MODIFIED_RECORD_IND);
				final APP_IN_EMPL_A_WAGE_Collection wageNewColl = pdfHelperBO
						.getFilteredWageCollection(wageColl,
								AppConstants.RMC_NEW_RECORD_IND);
				// Populate JOB INCOME_CUSTOM_Collection for modified jobs
				JOBINCOME_Custom_Collection jobCustChangeColl = new JOBINCOME_Custom_Collection();
				jobCustChangeColl = pdfHelperBO.populateJobIncomeCustomColl(
						emplChangeColl, wageChangeColl);
				pdfMap.put("JOBINCOME_Custom_Collection_Changed",
						jobCustChangeColl);

				// Populate JOB INCOME_CUSTOM_Collection for New jobs
				JOBINCOME_Custom_Collection jobCustNewColl = new JOBINCOME_Custom_Collection();
				jobCustNewColl = pdfHelperBO.populateJobIncomeCustomColl(
						emplNewColl, wageNewColl);
				pdfMap.put("JOBINCOME_Custom_Collection_New", jobCustNewColl);
			}
			log(ILog.DEBUG,
					"Inside: generateRMCPdf - Job Income Details done, load Self Employment Details");
			if (!driverManager
					.getStatus(FwConstants.RMC_DRIVER, "ARJSD", rmcDriver)
					.equals(String
							.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))) {
				// load APP_IN_SELF_EMPL Table
				final APP_IN_SELFE_Collection selfEColl = pdfHelperBO
						.getSelfEmploymentDetails(appNumber);
				pdfMap.put("APP_IN_SELFE_Collection", selfEColl);
				// segregate New jobs and Modified jobs in SELFE Table
				final APP_IN_SELFE_Collection selfEChangeColl = pdfHelperBO
						.getFilteredSelfECollection(selfEColl,
								AppConstants.RMC_MODIFIED_RECORD_IND);
				final APP_IN_SELFE_Collection selfENewColl = pdfHelperBO
						.getFilteredSelfECollection(selfEColl,
								AppConstants.RMC_NEW_RECORD_IND);
				final APP_IN_SELFE_Collection selfEEndColl = pdfHelperBO
						.getFilteredSelfECollection(selfEColl,
								AppConstants.RMC_END_RECORD_IND);
				selfEmplMap.put("selfEChangeColl", selfEChangeColl);
				selfEmplMap.put("selfENewColl", selfENewColl);
				selfEmplMap.put("selfEEndColl", selfEEndColl);
				selfEmplMap.put("APP_IN_SELFE_Collection", selfEColl);
				pdfMap.put("selfEmplMap", selfEmplMap);
			}
			log(ILog.DEBUG,
					"Inside: generateRMCPdf - Self Employment Details done, load Other Income Details");
			if (!driverManager
					.getStatus(FwConstants.RMC_DRIVER, "ARUID", rmcDriver)
					.equals(String
							.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))) {
				// load APP_IN_UEI_Collection
				APP_IN_UEI_Collection appInUEIColl = new APP_IN_UEI_Collection();
				appInUEIColl = pdfHelperBO
						.loadOtherIncomeDetailsForPdf(appNumber);

				final APP_IN_UEI_Collection ueiChangeColl = pdfHelperBO
						.getFilteredUeiCollection(appInUEIColl,
								AppConstants.RMC_MODIFIED_RECORD_IND);
				final APP_IN_UEI_Collection ueiNewColl = pdfHelperBO
						.getFilteredUeiCollection(appInUEIColl,
								AppConstants.RMC_NEW_RECORD_IND);
				final APP_IN_UEI_Collection ueiEndColl = pdfHelperBO
						.getFilteredUeiCollection(appInUEIColl,
								AppConstants.RMC_END_RECORD_IND);
				otherIncomeMap.put("ueiChangeColl", ueiChangeColl);
				otherIncomeMap.put("ueiNewColl", ueiNewColl);
				otherIncomeMap.put("ueiEndColl", ueiEndColl);
				otherIncomeMap.put("APP_IN_UEI_Collection", appInUEIColl);

				pdfMap.put("otherIncomeMap", otherIncomeMap);
			}
			log(ILog.DEBUG,
					"Inside: generateRMCPdf - Other Income Details done, load Housing Details");
			if (!driverManager
					.getStatus(FwConstants.RMC_DRIVER, "ARXHD", rmcDriver)
					.equals(String
							.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))) {
				// load APP_IN_SHLTC_Collection
				APP_IN_SHLTC_Collection appInShltcColl = new APP_IN_SHLTC_Collection();
				appInShltcColl = pdfHelperBO.getShelterCostDetails(appNumber);
				final APP_IN_SHLTC_Collection shltcChangeColl = pdfHelperBO
						.getFilteredShltcCollection(appInShltcColl,
								AppConstants.RMC_MODIFIED_RECORD_IND);
				final APP_IN_SHLTC_Collection shltcNewColl = pdfHelperBO
						.getFilteredShltcCollection(appInShltcColl,
								AppConstants.RMC_NEW_RECORD_IND);
				final APP_IN_SHLTC_Collection shltcEndColl = pdfHelperBO
						.getFilteredShltcCollection(appInShltcColl,
								AppConstants.RMC_END_RECORD_IND);
				housingBillsMap.put("shltcChangeColl", shltcChangeColl);
				housingBillsMap.put("shltcNewColl", shltcNewColl);
				housingBillsMap.put("shltcEndColl", shltcEndColl);
				housingBillsMap.put("APP_IN_SHLTC_Collection", appInShltcColl);
				pdfMap.put("housingBillMap", housingBillsMap);
			}
			log(ILog.DEBUG,
					"Inside: generateRMCPdf - Housing Details done, load Utility Details");
			if (!driverManager
					.getStatus(FwConstants.RMC_DRIVER, "ARXUD", rmcDriver)
					.equals(String
							.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))) {
				// load APP_IN_UTILC_Collection
				APP_IN_UTILC_Collection appInUtilColl = new APP_IN_UTILC_Collection();
				appInUtilColl = pdfHelperBO.getUtilityCostDetails(appNumber);
				final APP_IN_UTILC_Collection utilcChangeColl = pdfHelperBO
						.getFilteredUtilcCollection(appInUtilColl,
								AppConstants.RMC_MODIFIED_RECORD_IND);
				final APP_IN_UTILC_Collection utilcNewColl = pdfHelperBO
						.getFilteredUtilcCollection(appInUtilColl,
								AppConstants.RMC_NEW_RECORD_IND);
				final APP_IN_UTILC_Collection utilcEndColl = pdfHelperBO
						.getFilteredUtilcCollection(appInUtilColl,
								AppConstants.RMC_END_RECORD_IND);
				utilityBillsMap.put("utilcChangeColl", utilcChangeColl);
				utilityBillsMap.put("utilcNewColl", utilcNewColl);
				utilityBillsMap.put("utilcEndColl", utilcEndColl);
				utilityBillsMap.put("APP_IN_UTILC_Collection", appInUtilColl);
				pdfMap.put("utilityBillMap", utilityBillsMap);
			}
			log(ILog.DEBUG,
					"Inside: generateRMCPdf - Utility Details done, load bnft case Details");
			final List filterTypes = new ArrayList();
			filterTypes.add(AppConstants.WORKER_ADDRESS_TYPE);
			filterTypes.add(AppConstants.CASE_ADDRESS_TYPE);
			final ContactInformationBO contactInfoBO = new ContactInformationBO();
			final BNFT_CASE_ADR_Collection bnftCaseAdr = contactInfoBO
					.loadContactInformation(caseNumber);
			final BNFT_CASE_ADR_Collection bnftCaseAdrFiltered = contactInfoBO
					.filterAddresses(bnftCaseAdr, filterTypes);
			log(ILog.DEBUG,
					"Inside: generateRMCPdf - Bnft Case Adr Details done, load ARTOP Components");
			// Run Component Manager to get types of proof component id
			final Map componentIdMap = new HashMap();
			componentManager.getComponents("ARTOP", txnBean);
			List componentIdARTOP = new ArrayList();
			componentIdARTOP = (List) pageCollection
					.get(FwConstants.PAGE_COMPONENT_LIST);
			componentIdMap.put("componentIdARTOP", componentIdARTOP);
			log(ILog.DEBUG,
					"Inside: generateRMCPdf - ARTOP Components done, load ARHMI Components");
			// Run Compoenent Manager to get New Person Added page Component id
			componentManager.getComponents("ARHMI", txnBean);
			List componentIdListARHMI = new ArrayList();
			componentIdListARHMI = (List) pageCollection
					.get(FwConstants.PAGE_COMPONENT_LIST);
			componentIdMap.put("componentIdListARHMI", componentIdListARHMI);
			// add component Map to PDFMap
			pdfMap.put("componentIdMap", componentIdMap);
			log(ILog.DEBUG,
					"Inside: generateRMCPdf - ARHMI Components done, load bnftCaseAdrMap");
			final Map bnftCaseAdrMap = new HashMap();
			bnftCaseAdrMap.put("BNFT_CASE_ADR_Collection", bnftCaseAdrFiltered);
			pdfMap.put("BNFT_CASE_ADR_Collection", bnftCaseAdrMap);
			pdfMap.put("INDV_SEQ_NUM",
					pdfHelperBO.getLoginPersonIndvSeqNum(appNumber));
			log(ILog.DEBUG, "End: generateRMCPdf");
			log(ILog.INFO,
					"ARTransactionManagedEJBBean.generateRMCPDFMap() - END , Time Taken : "
							+ (System.currentTimeMillis() - startTime)
							+ " milliseconds");
			return pdfMap;
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(getClass().getName());
			we.setCallingMethodID("generateRMCPDFMap");
			we.setFwException(fe);
			throw exceptionManagerLog(fe, getClass().getName(), "generateRMCPDFMap");
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(getClass().getName(),
					"generateRMCPDFMap", e);
			throw exceptionManagerLog(fe, getClass().getName(), "generateRMCPDFMap");
		}
	}

	/**
	 * Checks if is any pregnantable.
	 *
	 * @param indvColl
	 *            the indv coll
	 * @return true, if is any pregnantable
	 */
	private boolean isAnyPregnantable(
			final INDIVIDUAL_Custom_Collection indvColl) {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"ARTransactionManagedEJBBean.isAnyPregnantable() - START");
		try {
			boolean ispreg = false;
			indvColl.size();
			INDIVIDUAL_Custom_Collection indvPregColl = new INDIVIDUAL_Custom_Collection();
			indvPregColl = PeopleRulesBO.getPregnantableIndividuals(indvColl);
			if (indvPregColl != null && !indvPregColl.isEmpty()) {
				ispreg = true;
			}
			log(ILog.INFO,
					"ARTransactionManagedEJBBean.isAnyPregnantable() - END , Time Taken : "
							+ (System.currentTimeMillis() - startTime)
							+ " milliseconds");
			return ispreg;
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(getClass().getName());
			we.setCallingMethodID("isAnyPregnantable");
			we.setFwException(fe);
			throw exceptionManagerLog(fe, getClass().getName(), "isAnyPregnantable");
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(getClass().getName(),
					"isAnyPregnantable", e);
			throw exceptionManagerLog(fe, getClass().getName(), "isAnyPregnantable");
		}

	}

	/**
	 * This method is invoked when the user clicks on the RMC button on the My
	 * access screen. This loads all the cases for that individual Id on the
	 * case selection screen.
	 *
	 * @param txnBean
	 *            the txn bean
	 * @throws EJBException
	 *             the EJB exception
	 * @throws javax.ejb.EJBException
	 *             the javax.ejb. ejb exception
	 */
	public void loadCases(final FwTransaction txnBean)
			throws javax.ejb.EJBException {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ARTransactionManagedEJBBean.loadCases() - START");
		final Map session = txnBean.getSession();
		final Map request = txnBean.getRequest();
		final Map pageCollection = txnBean.getPageCollection();
		final Map httpSessionMap = (Map) session.get(FwConstants.HTTP_SESSION);
		httpSessionMap.get(FwConstants.SECURED_SESSION);
		request.get(FwConstants.CURRENT_PAGE_ID);
		final JobIncomeBO jobBo = new JobIncomeBO();
		String language = null;
		String pinNum = null;

		final Map httpSession = (Map) session.get(FwConstants.HTTP_SESSION);
		if (httpSession.containsKey(AppConstants.LANGUAGE)) {
			language = (String) httpSession.get(AppConstants.LANGUAGE);
		}
		try {
			if (httpSession.get(FwConstants.SECURED_SESSION) != null) {

				Map securedSession = null;
				securedSession = (Map) httpSession
						.get(FwConstants.SECURED_SESSION);
				if (securedSession.containsKey(FwConstants.USER_PIN_NUM)) {
					pinNum = (String) securedSession
							.get(FwConstants.USER_PIN_NUM);
				}

				final BNFT_INDV_CASE_Collection bnftIndvCaseColl = jobBo
						.getRmcLivingArrangementColl(pinNum);

				final RMC_CUSTOM_COLLECTION rmcCustomCollection = jobBo
						.loadAllCases(bnftIndvCaseColl);

				final RMCSummaryListView listViewBean = new RMCSummaryListView();
				listViewBean.setLanguage(language);
				listViewBean.setName("RMCSummaryStatusListView_Listview");
				listViewBean.setDisplayData(rmcCustomCollection);
				listViewBean.setPageSize(1000);
				pageCollection.put(RMCSummaryListView.LISTVIEWNAME,
						listViewBean);
			}

		} catch (final FwException fe) {
			javaTransactionFailure();
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(getClass().getName());
			we.setCallingMethodID("loadCategorySelection");
			we.setFwException(fe);
			throw exceptionManagerLog(fe, getClass().getName(), "loadCases");
		} catch (final Exception e) {
			javaTransactionFailure();
			final FwException fe = createFwException(getClass().getName(),
					"loadCategorySelection", e);
			throw exceptionManagerLog(fe, getClass().getName(), "loadCases");
		}
		log(ILog.INFO,
				"ARTransactionManagedEJBBean.loadCases() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Prepares load page for next step overview.
	 *
	 * @param txnBean
	 *            Transaction details
	 * @throws EJBException
	 *             the EJB exception
	 * @throws javax.ejb.EJBException
	 *             the javax.ejb. ejb exception
	 */
	public void getNextStepsOverview(final FwTransaction txnBean)
			throws javax.ejb.EJBException {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"ARTransactionManagedEJBBean.getNextStepsOverview() - START");
		try {
			// Initial loading of session, request and pagecontext data.
			final Map session = txnBean.getSession();
			final Map pageCollection = txnBean.getPageCollection();
			final Map httpSession = (Map) session.get(FwConstants.HTTP_SESSION);
			final String languageCd = (String) httpSession
					.get(AppConstants.LANGUAGE);
			if(session.containsKey("clickSubmitCounter")){
            	session.remove("clickSubmitCounter");
            }
			final Map datMap = new HashMap();
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			final String caseNum = (String) session.get(AppConstants.CMB_CASE_NUM);
			final ABNextStepsOverviewBO bo = new ABNextStepsOverviewBO();
			final APP_RGST_Collection hhColl = bo.getHouseHoldAddress(appNum);
			final APP_SBMS_Collection appSbmsCollection = bo
					.listViewData(appNum);
			final ABFinalSubmitBO abFinalSubmitBO = new ABFinalSubmitBO();
			Boolean Flag = abFinalSubmitBO.loadExistedSNAPVal(caseNum);
			pageCollection.put("EXISTED_SNAP", Flag);
            pageCollection.put("APP_SBMS_Collection", appSbmsCollection);
			final String trackingNum = bo.loadTrackingNumber(appNum);
			pageCollection.put("TRACK_NUM", trackingNum);
			session.put("OTHR_TRACK_NUM", trackingNum);
			hhColl.getCargo(0).getCnty_num();
			// call component manager to get all the components mapped to this
			// page.
			// this is added as we added new section in this page -- PCR# 33996
			componentManager.getComponents("ABNSO", txnBean);
			pageCollection.put("NEXT_STEPS_OVRW_ADDR_MAILIN",
					"TEST MALING ADDRESS");
			// End of VaCMS - Not required to fetch the officeName from VaCMS

			final RMBPDFNextStepsListView listView = new RMBPDFNextStepsListView();
			listView.setLanguage(languageCd);
			// EDSP temp
			final String token = session != null ? (String) session
					.get(FwConstants.SECURITY_TOKEN) : "";
					datMap.put(FwConstants.SECURITY_TOKEN, token);
					listView.setDisplayData(datMap);

					listView.setName("NextSteps_ListView");
					listView.setPageSize(100);
					pageCollection.put("NextSteps_ListView", listView);

					// Set pageCollection into transaction Bean
					txnBean.setPageCollection(pageCollection);
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(getClass().getName());
			we.setCallingMethodID("getNextStepsOverview");
			we.setFwException(fe);
			throw exceptionManagerLog(fe, getClass().getName(), "getNextStepsOverview");
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(getClass().getName(),
					"getNextStepsOverview", e);
			throw exceptionManagerLog(fe, getClass().getName(), "getNextStepsOverview");
		}

		log(ILog.INFO,
				"ARTransactionManagedEJBBean.getNextStepsOverview() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * This method is used to get next step detail.
	 *
	 * @param txnBean
	 *            Transaction details
	 * @throws javax.ejb.EJBException
	 *             the javax.ejb. ejb exception
	 */
	public void getNextStepsDetail(final FwTransaction txnBean)
			throws javax.ejb.EJBException {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"ARTransactionManagedEJBBean.getNextStepsDetail() - START");
		final Map session = txnBean.getSession();
		final Map pageCollection = txnBean.getPageCollection();
		try {
			// calling the component manager
			componentManager.getComponents("ABNSD", txnBean);
			List componentIdABNSD = new ArrayList();
			componentIdABNSD = (List) pageCollection
					.get(FwConstants.PAGE_COMPONENT_LIST);
			pageCollection.put("COMPONENT_ID_ABNSD", componentIdABNSD);
			session.put(FwConstants.BEFORE_COLLECTION, pageCollection);
			txnBean.setPageCollection(pageCollection);
			txnBean.setSession(session);
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(getClass().getName());
			we.setCallingMethodID("getNextStepsDetail");
			we.setFwException(fe);
			throw exceptionManagerLog(fe, getClass().getName(), "getNextStepsDetail");
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(getClass().getName(),
					"getNextStepsDetail", e);
			throw exceptionManagerLog(fe, getClass().getName(), "getNextStepsDetail");
		}
		log(ILog.INFO,
				"ARTransactionManagedEJBBean.getNextStepsDetail() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * This method is used to store next step overview.
	 *
	 * @param txnBean
	 *            Transaction details
	 * @throws EJBException
	 *             the EJB exception
	 * @throws javax.ejb.EJBException
	 *             the javax.ejb. ejb exception
	 */
	public void storeNextStepsOverview(final FwTransaction txnBean)
			throws javax.ejb.EJBException {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"ARTransactionManagedEJBBean.storeNextStepsOverview() - START");
		try {
			final Map session = txnBean.getSession();

			session.remove(AppConstants.APP_NUMBER);
			session.remove(AppConstants.RMC_IN_PRFL_MASTER);
			session.remove(AppConstants.INDIV_MASTER_HANDLER);
			session.remove(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			session.remove(AppConstants.RMC_CATEGORY_PAGE_PRFL);
			session.remove(FwConstants.RMC_PROGRAM_KEY);
			session.remove(FwConstants.RMC_DRIVER);
			session.remove(AppConstants.RMC_EXTRACTION_FLAGS);
			session.remove(AppConstants.RMC_RQST);
			session.remove(AppConstants.RMB_RQST);
			session.remove(AppConstants.RMB_RQST_COLLECTION);
			session.remove(FwConstants.BEFORE_COLLECTION);
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(getClass().getName());
			we.setCallingMethodID("storeNextStepsOverview");
			we.setFwException(fe);
			throw exceptionManagerLog(fe, getClass().getName(), "storeNextStepsOverview");
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(getClass().getName(),
					"storeNextStepsOverview", e);
			throw exceptionManagerLog(fe, getClass().getName(), "storeNextStepsOverview");
		}
		log(ILog.INFO,
				"ARTransactionManagedEJBBean.storeNextStepsOverview() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Store pre submit.
	 *
	 * @param txnBean
	 *            the txn bean
	 * @throws EJBException
	 *             the EJB exception
	 */
	public void storePreSubmit(final FwTransaction txnBean)
			throws javax.ejb.EJBException {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ARTransactionManagedEJBBean.storePreSubmit() - START");
		try {
			log(ILog.INFO,
					"ARTransactionManagedEJBBean::storeFinalApplicationSubmission::Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();final Map beforeColl = (Map) session.get(FwConstants.BEFORE_COLLECTION);
			final APP_SBMS_Collection beforeAppSbmsColl = (APP_SBMS_Collection) beforeColl.get("APP_SBMS_COLLECTION");
			// getting current pageid from request
			final String currentPageID = (String) request
					.get(FwConstants.CURRENT_PAGE_ID);
			// getting driver status
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			// getting app number
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			// initializing variables
			String firstNameSelf = AppConstants.EMPTY_STRING;
			String lastNameSelf = AppConstants.EMPTY_STRING;
			String middleInitialSelf = AppConstants.EMPTY_STRING;
			String suffixSelf = AppConstants.EMPTY_STRING;
			String firstNameAuthRep = AppConstants.EMPTY_STRING;
			String lastNameAuthRep = AppConstants.EMPTY_STRING;
			String middleInitialAuthRep = AppConstants.EMPTY_STRING;
			String suffixAuthRep = AppConstants.EMPTY_STRING;
			String selfSignFlag = AppConstants.EMPTY_STRING;
			String authRepSignFlag = AppConstants.EMPTY_STRING;
			String appPhyMenChalngdFlag = AppConstants.EMPTY_STRING;
			String registrationInd = AppConstants.EMPTY_STRING;
			final String clientCaseAssocInd = AppConstants.EMPTY_STRING;
			final String caseAssocInd = AppConstants.EMPTY_STRING;
			String addtnInfo = AppConstants.EMPTY_STRING;

			// retrieveing values from session or request
			if (request.get(AppConstants.SELF_FIRST_NAME) != null) {
				firstNameSelf = (String) request
						.get(AppConstants.SELF_FIRST_NAME);
			}
			if (request.get(AppConstants.AR_FIRST_NAME) != null) {
				firstNameAuthRep = (String) request
						.get(AppConstants.AR_FIRST_NAME);
			}
			if (request.get(AppConstants.SELF_LAST_NAME) != null) {
				lastNameSelf = (String) request
						.get(AppConstants.SELF_LAST_NAME);
			}
			if (request.get(AppConstants.AR_LAST_NAME) != null) {
				lastNameAuthRep = (String) request
						.get(AppConstants.AR_LAST_NAME);
			}
			if (request.get(AppConstants.SELF_MIDDLE_INITIAL) != null) {
				middleInitialSelf = (String) request
						.get(AppConstants.SELF_MIDDLE_INITIAL);
			}
			if (request.get(AppConstants.AR_MIDDLE_INITIAL) != null) {
				middleInitialAuthRep = (String) request
						.get(AppConstants.AR_MIDDLE_INITIAL);
			}
			if (request.get(AppConstants.SELF_SUFFIX) != null) {
				suffixSelf = (String) request.get(AppConstants.SELF_SUFFIX);
			}
			if (request.get(AppConstants.AR_SUFFIX) != null) {
				suffixAuthRep = (String) request.get(AppConstants.AR_SUFFIX);
			}
			if (request.get(AppConstants.SELF_ELEC_SIGN) != null) {
				selfSignFlag = (String) request
						.get(AppConstants.SELF_ELEC_SIGN);
			}
			if (request.get(AppConstants.AR_ELEC_SIGN) != null) {
				authRepSignFlag = (String) request
						.get(AppConstants.AR_ELEC_SIGN);
			}
			if (request.get(AppConstants.PHY_MEN_CHALLENGED) != null) {
				appPhyMenChalngdFlag = (String) request
						.get(AppConstants.PHY_MEN_CHALLENGED);
			}
			if (request.get(AppConstants.VOTER_REG) != null) {
				registrationInd = (String) request.get(AppConstants.VOTER_REG);
			}
			if (request.get(AppConstants.ADDTN_INFO) != null) {
				addtnInfo = (String) request.get(AppConstants.ADDTN_INFO);
			}

			// valdiations for data captured onscreen
			final RMCNavigationBO validationBO = new RMCNavigationBO();
			FwMessageList messageList = new FwMessageList();
			messageList = validationBO.validatePreSubmit(firstNameSelf,
					firstNameAuthRep, lastNameSelf, lastNameAuthRep,
					middleInitialSelf, middleInitialAuthRep, suffixSelf,
					suffixAuthRep, selfSignFlag, authRepSignFlag,
					appPhyMenChalngdFlag, registrationInd, clientCaseAssocInd,
					caseAssocInd);
			// routing to same screen on validation errors
			if (messageList != null && messageList.hasMessages()) {
				request.put(FwConstants.MESSAGE_LIST, messageList);
				request.put(AppConstants.SELF_FIRST_NAME, firstNameSelf);
				request.put(AppConstants.AR_FIRST_NAME, firstNameAuthRep);
				request.put(AppConstants.SELF_LAST_NAME, lastNameSelf);
				request.put(AppConstants.AR_LAST_NAME, lastNameAuthRep);
				request.put(AppConstants.SELF_MIDDLE_INITIAL, middleInitialSelf);
				request.put(AppConstants.AR_MIDDLE_INITIAL,
						middleInitialAuthRep);
				request.put(AppConstants.SELF_SUFFIX, suffixSelf);
				request.put(AppConstants.AR_SUFFIX, suffixAuthRep);
				request.put(AppConstants.SELF_ELEC_SIGN, selfSignFlag);
				request.put(AppConstants.AR_ELEC_SIGN, authRepSignFlag);
				request.put(AppConstants.PHY_MEN_CHALLENGED,
						appPhyMenChalngdFlag);
				request.put(AppConstants.VOTER_REG, registrationInd);
				request.put(AppConstants.ADDTN_INFO, addtnInfo);
				txnBean.setRequest(request);
				return;
			}

			int clickSubmitCounter = 0;
			if(session.get("clickSubmitCounter") != null) {
				clickSubmitCounter = (int) session.get("clickSubmitCounter") + 1;
			} else {
				clickSubmitCounter = 1;
			}
			session.put("clickSubmitCounter", clickSubmitCounter);
			logger.log(ARTransactionManagedEJBBean.class,ILog.FATAL,"DeepLog::CP_DEBUG_LOGS::1:: methodName::storePreSubmit");
			logger.log(ARTransactionManagedEJBBean.class,ILog.FATAL,"DeepLog::CP_DEBUG_LOGS::1:: Number of times user clicked on submit button: " + clickSubmitCounter);

			final ABFinalSubmitBO finalBO = new ABFinalSubmitBO();
			// getting APP_SBMS_Collection
			APP_SBMS_Collection appSbmsColl = null;
			APP_SBMS_Cargo appSbmsCargo = null;
			// getting APP_USER_ADDITIONAL_INFO_Collection
			APP_USER_ADDITIONAL_INFO_Collection addInfoColl = null;
			APP_USER_ADDITIONAL_INFO_Cargo addInfoCargo = null;

			appSbmsColl = new APP_SBMS_Collection();
			appSbmsCargo = new APP_SBMS_Cargo();

			// storing CP_APP_SBMS
			appSbmsCargo.setApp_num(appNum);
			appSbmsCargo.setFst_nam(firstNameAuthRep);
			appSbmsCargo.setApplicant_first_name(firstNameSelf);
			appSbmsCargo.setLast_nam(lastNameAuthRep);
			appSbmsCargo.setApplicant_last_name(lastNameSelf);
			appSbmsCargo.setMid_init(middleInitialAuthRep);
			appSbmsCargo.setApplicant_mid_name(middleInitialSelf);
			appSbmsCargo.setSuffix_name(suffixAuthRep);
			appSbmsCargo.setApplicant_suffix_name(suffixSelf);
			appSbmsCargo
					.setE_sign_ind(authRepSignFlag != null
							&& !authRepSignFlag.isEmpty()
							&& FwConstants.YES
									.equalsIgnoreCase(authRepSignFlag) ? FwConstants.ONE
							: FwConstants.ZERO);
			appSbmsCargo
					.setElectronically_sign_ind(selfSignFlag != null
							&& !selfSignFlag.isEmpty()
							&& FwConstants.YES.equalsIgnoreCase(selfSignFlag) ? FwConstants.ONE
							: FwConstants.ZERO);
			appSbmsCargo
					.setUnable_sign_ind(appPhyMenChalngdFlag != null
							&& !appPhyMenChalngdFlag.isEmpty()
							&& FwConstants.YES
									.equalsIgnoreCase(appPhyMenChalngdFlag) ? FwConstants.ONE
							: FwConstants.ZERO);
			appSbmsCargo
					.setVoter_registration_sw(registrationInd != null
							&& !registrationInd.isEmpty()
							&& FwConstants.YES
									.equalsIgnoreCase(registrationInd) ? FwConstants.ONE
							: FwConstants.ZERO);
			if(beforeAppSbmsColl != null && !beforeAppSbmsColl.isEmpty()){
				appSbmsCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
			}else{
				appSbmsCargo.setRowAction(FwConstants.ROWACTION_INSERT);
			}
			appSbmsColl.addCargo(appSbmsCargo);
			finalBO.storeAppRqstStatus(appSbmsColl);

			if (addtnInfo != null && !addtnInfo.isEmpty()) {
				addInfoColl = new APP_USER_ADDITIONAL_INFO_Collection();
				addInfoCargo = new APP_USER_ADDITIONAL_INFO_Cargo();
				addInfoCargo.setApp_num(appNum);
				if (addtnInfo.trim().length() > 1000) {
					addtnInfo = addtnInfo.trim().substring(0, 1000);
				}
				addInfoCargo.setAdditional_info(addtnInfo);
				addInfoCargo.setRowAction(FwConstants.ROWACTION_INSERT);
				addInfoColl.addCargo(addInfoCargo);
				finalBO.storeAdditionalInfo(addInfoColl);
			}
			
			boolean isItPartner = false;
			String partnerTypeCd = null;
			if(session.containsKey("PARTNER_TYPE_CD")){
				 partnerTypeCd = (String) session.get("PARTNER_TYPE_CD");
				 isItPartner = finalBO.validateRefdata(partnerTypeCd, "CPTY", "AFB....");
			}
			if(isItPartner){
				String submitAcsId = (String) session.get("securedWid");
				APP_USER_Collection aUserColl = finalBO.loadAppUser(appNum);
				APP_USER_Cargo aUserCargo = aUserColl.getCargo();
				aUserCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
				//aUserCargo.setApp_num(appNum);
				aUserCargo.setSbmt_acs_id(submitAcsId);
				aUserColl.persist(FwConstants.DAO);
				
				
			}

			final RMCRequestManager rmcRqstManager = new RMCRequestManager();
			final RMC_RQST_Collection rmccoll = new RMC_RQST_Collection();
			final RMC_RQST_Cargo rmcRqstCargo = rmcRqstManager
					.loadRMCRequest(appNum);
			rmcRqstCargo.setStat_cd(AppConstants.AFB_SUBMISSION_READY);

			rmcRqstCargo.setApp_end_dt(String.valueOf(fwDate.getDate()));
			rmcRqstCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
			rmccoll.addCargo(rmcRqstCargo);
			rmcRqstManager.storeRMCRqst(rmccoll);

			// making the final submission page complete
			driverManager.makeComplete(FwConstants.RMC_DRIVER, currentPageID,
					driverArray, appNum);

			request.put(AppConstants.APP_NUMBER, appNum);
			txnBean.setRequest(request);
			txnBean.setPageCollection(pageCollection);

			session.put(AppConstants.APP_TYPE, AppConstants.RMC);
			processApplication(txnBean);
			final ABFinalSubmitBO abFinalSubmitBO = new ABFinalSubmitBO();
			abFinalSubmitBO.storeAppPDFXML(txnBean);
			//storeRMCPDF(txnBean);

		} catch (final FwException fe) {
			log(ILog.ERROR, fe.getMessage());
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			exceptionManagerLog(fe, getClass().getName(), "storePreSubmit");
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			exceptionManagerLog(e, getClass().getName(), "storePreSubmit");
		}
		log(ILog.INFO,
				"ARTransactionManagedEJBBean.storePreSubmit() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}
	
	public void saveExitFinalRMC(final FwTransaction txnBean){

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ARTransactionManagedEJBBean.saveExitFinalRMC() - START");
		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final Map beforeColl = (Map) session.get(FwConstants.BEFORE_COLLECTION);
			final APP_SBMS_Collection beforeAppSbmsColl = (APP_SBMS_Collection) beforeColl.get("APP_SBMS_COLLECTION");

			// getting current pageid from request
			final String currentPageID = (String) request
					.get(FwConstants.CURRENT_PAGE_ID);
			// getting driver status
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			// getting app number
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			// initializing variables
			String firstNameSelf = AppConstants.EMPTY_STRING;
			String lastNameSelf = AppConstants.EMPTY_STRING;
			String middleInitialSelf = AppConstants.EMPTY_STRING;
			String suffixSelf = AppConstants.EMPTY_STRING;
			String firstNameAuthRep = AppConstants.EMPTY_STRING;
			String lastNameAuthRep = AppConstants.EMPTY_STRING;
			String middleInitialAuthRep = AppConstants.EMPTY_STRING;
			String suffixAuthRep = AppConstants.EMPTY_STRING;
			String selfSignFlag = AppConstants.EMPTY_STRING;
			String authRepSignFlag = AppConstants.EMPTY_STRING;
			String appPhyMenChalngdFlag = AppConstants.EMPTY_STRING;
			String registrationInd = AppConstants.EMPTY_STRING;
			final String clientCaseAssocInd = AppConstants.EMPTY_STRING;
			final String caseAssocInd = AppConstants.EMPTY_STRING;
			String addtnInfo = AppConstants.EMPTY_STRING;

			// retrieveing values from session or request
			if (request.get(AppConstants.SELF_FIRST_NAME) != null) {
				firstNameSelf = (String) request
						.get(AppConstants.SELF_FIRST_NAME);
			}
			if (request.get(AppConstants.AR_FIRST_NAME) != null) {
				firstNameAuthRep = (String) request
						.get(AppConstants.AR_FIRST_NAME);
			}
			if (request.get(AppConstants.SELF_LAST_NAME) != null) {
				lastNameSelf = (String) request
						.get(AppConstants.SELF_LAST_NAME);
			}
			if (request.get(AppConstants.AR_LAST_NAME) != null) {
				lastNameAuthRep = (String) request
						.get(AppConstants.AR_LAST_NAME);
			}
			if (request.get(AppConstants.SELF_MIDDLE_INITIAL) != null) {
				middleInitialSelf = (String) request
						.get(AppConstants.SELF_MIDDLE_INITIAL);
			}
			if (request.get(AppConstants.AR_MIDDLE_INITIAL) != null) {
				middleInitialAuthRep = (String) request
						.get(AppConstants.AR_MIDDLE_INITIAL);
			}
			if (request.get(AppConstants.SELF_SUFFIX) != null) {
				suffixSelf = (String) request.get(AppConstants.SELF_SUFFIX);
			}
			if (request.get(AppConstants.AR_SUFFIX) != null) {
				suffixAuthRep = (String) request.get(AppConstants.AR_SUFFIX);
			}
			if (request.get(AppConstants.SELF_ELEC_SIGN) != null) {
				selfSignFlag = (String) request
						.get(AppConstants.SELF_ELEC_SIGN);
			}
			if (request.get(AppConstants.AR_ELEC_SIGN) != null) {
				authRepSignFlag = (String) request
						.get(AppConstants.AR_ELEC_SIGN);
			}
			if (request.get(AppConstants.PHY_MEN_CHALLENGED) != null) {
				appPhyMenChalngdFlag = (String) request
						.get(AppConstants.PHY_MEN_CHALLENGED);
			}
			if (request.get(AppConstants.VOTER_REG) != null) {
				registrationInd = (String) request.get(AppConstants.VOTER_REG);
			}
			if (request.get(AppConstants.ADDTN_INFO) != null) {
				addtnInfo = (String) request.get(AppConstants.ADDTN_INFO);
			}

			// valdiations for data captured onscreen
			final RMCNavigationBO validationBO = new RMCNavigationBO();
			FwMessageList messageList = new FwMessageList();
			messageList = validationBO.validatePreSubmit(firstNameSelf,
					firstNameAuthRep, lastNameSelf, lastNameAuthRep,
					middleInitialSelf, middleInitialAuthRep, suffixSelf,
					suffixAuthRep, selfSignFlag, authRepSignFlag,
					appPhyMenChalngdFlag, registrationInd, clientCaseAssocInd,
					caseAssocInd);
			// routing to same screen on validation errors
			if (messageList != null && messageList.hasMessages()) {
				request.put(FwConstants.MESSAGE_LIST, messageList);
				request.put(AppConstants.SELF_FIRST_NAME, firstNameSelf);
				request.put(AppConstants.AR_FIRST_NAME, firstNameAuthRep);
				request.put(AppConstants.SELF_LAST_NAME, lastNameSelf);
				request.put(AppConstants.AR_LAST_NAME, lastNameAuthRep);
				request.put(AppConstants.SELF_MIDDLE_INITIAL, middleInitialSelf);
				request.put(AppConstants.AR_MIDDLE_INITIAL,
						middleInitialAuthRep);
				request.put(AppConstants.SELF_SUFFIX, suffixSelf);
				request.put(AppConstants.AR_SUFFIX, suffixAuthRep);
				request.put(AppConstants.SELF_ELEC_SIGN, selfSignFlag);
				request.put(AppConstants.AR_ELEC_SIGN, authRepSignFlag);
				request.put(AppConstants.PHY_MEN_CHALLENGED,
						appPhyMenChalngdFlag);
				request.put(AppConstants.VOTER_REG, registrationInd);
				request.put(AppConstants.ADDTN_INFO, addtnInfo);
				txnBean.setRequest(request);
				return;
			}

			final ABFinalSubmitBO finalBO = new ABFinalSubmitBO();
			// getting APP_SBMS_Collection
			APP_SBMS_Collection appSbmsColl = null;
			APP_SBMS_Cargo appSbmsCargo = null;
			// getting APP_USER_ADDITIONAL_INFO_Collection
			APP_USER_ADDITIONAL_INFO_Collection addInfoColl = null;
			APP_USER_ADDITIONAL_INFO_Cargo addInfoCargo = null;

			appSbmsColl = new APP_SBMS_Collection();
			appSbmsCargo = new APP_SBMS_Cargo();

			// storing CP_APP_SBMS
			appSbmsCargo.setApp_num(appNum);
			appSbmsCargo.setFst_nam(firstNameAuthRep);
			appSbmsCargo.setApplicant_first_name(firstNameSelf);
			appSbmsCargo.setLast_nam(lastNameAuthRep);
			appSbmsCargo.setApplicant_last_name(lastNameSelf);
			appSbmsCargo.setMid_init(middleInitialAuthRep);
			appSbmsCargo.setApplicant_mid_name(middleInitialSelf);
			appSbmsCargo.setSuffix_name(suffixAuthRep);
			appSbmsCargo.setApplicant_suffix_name(suffixSelf);
			appSbmsCargo
					.setE_sign_ind(authRepSignFlag != null
							&& !authRepSignFlag.isEmpty()
							&& FwConstants.YES
									.equalsIgnoreCase(authRepSignFlag) ? FwConstants.ONE
							: FwConstants.ZERO);
			appSbmsCargo
					.setElectronically_sign_ind(selfSignFlag != null
							&& !selfSignFlag.isEmpty()
							&& FwConstants.YES.equalsIgnoreCase(selfSignFlag) ? FwConstants.ONE
							: FwConstants.ZERO);
			appSbmsCargo
					.setUnable_sign_ind(appPhyMenChalngdFlag != null
							&& !appPhyMenChalngdFlag.isEmpty()
							&& FwConstants.YES
									.equalsIgnoreCase(appPhyMenChalngdFlag) ? FwConstants.ONE
							: FwConstants.ZERO);
			appSbmsCargo
					.setVoter_registration_sw(registrationInd != null
							&& !registrationInd.isEmpty()
							&& FwConstants.YES
									.equalsIgnoreCase(registrationInd) ? FwConstants.ONE
							: FwConstants.ZERO);
			if(beforeAppSbmsColl != null && !beforeAppSbmsColl.isEmpty()){
				appSbmsCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
			}else{
				appSbmsCargo.setRowAction(FwConstants.ROWACTION_INSERT);
			}
			
			appSbmsColl.addCargo(appSbmsCargo);
			finalBO.storeAppRqstStatus(appSbmsColl);
			
		} catch (final FwException fe) {
			fe.printStackTrace();
			log(ILog.ERROR, fe.getMessage());
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			exceptionManagerLog(fe, getClass().getName(), "saveExitFinalRMC");
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			exceptionManagerLog(e, getClass().getName(), "saveExitFinalRMC");
		}
		log(ILog.INFO,
				"ARTransactionManagedEJBBean.saveExitFinalRMC() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Store rmcpdf.
	 *
	 * @param txnBean
	 *            the txn bean
	 */
	public void storeRMCPDF(final FwTransaction txnBean) {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ARTransactionManagedEJBBean.storeRMCPDF() - START");
		log(ILog.INFO, "start of storeRMCPDF");
		final Map session = txnBean.getSession();
		final Map request = txnBean.getRequest();
		String appNum = null;
		final ProcessApplicationBO processApplicationBO = new ProcessApplicationBO();
		boolean exception = false;
		// holds CWW Case Number
		String cwwCaseNum = FwConstants.ZERO;
		// holds true if exception happens when Case Num is 0
		boolean caseNumZeroExcp = false;
		try {
			// getting the app number from the session
			appNum = (String) session.get(AppConstants.APP_NUMBER);

			final Map httpSessionMap = (Map) session
					.get(FwConstants.HTTP_SESSION);
			httpSessionMap.get(AppConstants.LANGUAGE);
			// this one is for batch process
			if (appNum == null) {
				appNum = (String) request.get(AppConstants.APP_NUMBER);
				if (request.get(AppConstants.BATCH_PROCESS) != null) {
				}
			}

			if (appNum != null) {
				log(ILog.DEBUG, "start: storeRMCPDFInECF - appNum: " + appNum);
				request.put(AppConstants.APP_NUMBER, appNum);
				// now i need to get case number from the rmc_rqst table

				// Get Environment
				log(ILog.DEBUG, "Start: createRMCPDF");
				final IConfiguration configuration = (IConfiguration) FwServiceFactory
						.getInstance().create(IConfiguration.class);
				String environment = configuration
						.getEnvironmentProperty(FwConstants.ENVIRONMENT);
				if ("Prod".equals(environment)) {
					environment = AppConstants.EMPTY_STRING;
				}
				log(ILog.DEBUG, "Start generateRMCPDFMap");

				log(ILog.INFO, "start of generatePdfMap");
				log(ILog.INFO, "emd of generatePdfMap");
				javaTransactionSuccess();
				// Manish: Naresh to give pdfMap
				log(ILog.DEBUG, "End generateRMCPDFMap");
				// now we need to create byte array

				log(ILog.DEBUG, "Start new PrintRMCPdf()");
				// Changes for PCR #30847, for versioning PDF

				log(ILog.DEBUG, "End: buildByteArray");

				/**
				 * Modified on : 08-14-2009 Modified by Kumar Karuppanan to
				 * store the English as well as Spanish Pdf based on the
				 * language indicator
				 *
				 */
				final ByteArrayOutputStream byteArray = null;
				byte[] finalPDFByteArray = null;

				// now i am storing the PDF document
				// get the case number form the rmc_rqst table
				final RMCRequestManager rmcReqManage = new RMCRequestManager();
				log(ILog.INFO, "start loadRMBRequest");
				final RMC_RQST_Cargo rmcRqstCargo = rmcReqManage
						.loadRMCRequest(appNum);
				log(ILog.INFO, "end loadRMBRequest");
				log(ILog.DEBUG, "End: loadRMCRequest");
				// if Case number is FwConstants.ZERO than throw an exception
				// and log
				// comments
				cwwCaseNum = rmcRqstCargo.getCase_num();
				if (FwConstants.ZERO.equals(cwwCaseNum)) {
					caseNumZeroExcp = true;
					log(ILog.INFO,
							"ARTransactionManagedEJBBean.storeRMCPDF() - Raising FwException manually on a condition");
					final FwException fe = new FwException("Case Number is "
							+ FwConstants.ZERO);
					fe.setMethodID("storeRMCPDFInECF");
					fe.setExceptionText("Case Number:" + cwwCaseNum);
					throw fe;
				}
				log(ILog.INFO, "start of buildByteArray in ARTrans");
				log(ILog.INFO, "end of buildByteArray in ARTrans");
				

				final RMC_PDF_DOC_Collection rmcPDFdocCollection = new RMC_PDF_DOC_Collection();
				final RMC_PDF_DOC_Cargo rmcPDFdocCargo = new RMC_PDF_DOC_Cargo();
				rmcPDFdocCargo.setApp_num(appNum);
				rmcPDFdocCargo.setByteArray(finalPDFByteArray);
				rmcPDFdocCargo.setRowAction(FwConstants.ROWACTION_INSERT);
				rmcPDFdocCollection.addCargo(rmcPDFdocCargo);
				rmcPDFdocCollection.persist(FwConstants.DAO);
				log(ILog.DEBUG, "End: Application PDF stored in APP_PDF_DOC");

				// updating the status
				processApplicationBO.updateECFStatus(appNum,
						AppConstants.DOCUMENT_SUBMISSION_PROCESSED,
						FwConstants.RMC_SUBSYSTEM_IND);
				log(ILog.DEBUG, "End: updateECFStatus");
				javaTransactionSuccess();
			}
		} catch (final FwWrappedException we) {
			javaTransactionFailure();
			final FwExceptionManager exceptionMgr = (FwExceptionManager) FwServiceFactory
					.getInstance().create(IException.class);
			final FwException fe = createFwException(getClass().getName(),
					"storeRMCPDFInECF", we);
			fe.setParameterText("appNum: " + appNum + " caseNum: " + cwwCaseNum);
			we.setFwException(fe);
			exceptionMgr.log(we);
			exception = true;
		} catch (final FwException fe) {
			javaTransactionFailure();
			fe.setParameterText("appNum: " + appNum + " caseNum: " + cwwCaseNum);
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(getClass().getName());
			we.setCallingMethodID("storeRMCPDFInECF");
			we.setFwException(fe);
			final FwExceptionManager exceptionMgr = (FwExceptionManager) FwServiceFactory
					.getInstance().create(IException.class);
			exceptionMgr.log(we);
			exception = true;
		} catch (final Exception e) {
			javaTransactionFailure();
			final FwException fe = createFwException(getClass().getName(),
					"storeRMCPDFInECF", e);
			fe.setParameterText("appNum: " + appNum + " caseNum: " + cwwCaseNum);
			final FwWrappedException we = new FwWrappedException(e);
			we.setCallingClassID(getClass().getName());
			we.setCallingMethodID("storeRMCPDFInECF");
			we.setFwException(fe);
			final FwExceptionManager exceptionMgr = (FwExceptionManager) FwServiceFactory
					.getInstance().create(IException.class);
			exceptionMgr.log(we);
			exception = true;
		} finally {
			if (exception) {
				try {
					startJavaTransaction(mySessionCtx);
					// updating the status
					if (!caseNumZeroExcp) {
						processApplicationBO.updateECFStatus(appNum,
								AppConstants.DOCUMENT_SUBMISSION_EXCEPTION,
								FwConstants.RMC_SUBSYSTEM_IND);
					}
					javaTransactionSuccess();
				} catch (final FwException fee) {
					javaTransactionFailure();
					final FwWrappedException wee = new FwWrappedException(fee);
					wee.setCallingClassID(getClass().getName());
					wee.setCallingMethodID("storeRMCPDFInECF");
					wee.setFwException(fee);
					final FwExceptionManager exceptionMagr = (FwExceptionManager) FwServiceFactory
							.getInstance().create(IException.class);
					exceptionMagr.log(wee);
				} catch (final Exception ee) {
					javaTransactionFailure();
					final FwException fee = createFwException(getClass()
							.getName(), "storeRMCPDFInECF", ee);
					final FwWrappedException wee = new FwWrappedException(ee);
					wee.setCallingClassID(getClass().getName());
					wee.setCallingMethodID("storeRMCPDFInECF");
					wee.setFwException(fee);
					final FwExceptionManager exceptionMagr = (FwExceptionManager) FwServiceFactory
							.getInstance().create(IException.class);
					exceptionMagr.log(wee);
				}
			}
		}

		log(ILog.INFO,
				"ARTransactionManagedEJBBean.storeRMCPDF() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * This method is used to get the free bridges appnumber and update the
	 * status as 'P'.
	 *
	 * @param appNum
	 *            The MIBridges appnumber
	 * @param appStatus
	 *            The application Status as 'P'
	 * @param saveAndExitBO
	 *            the save and exit bo
	 * @return the Bridges Appnumber
	 * @throws ApplicationException
	 *             the application exception
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	private synchronized String getAppnum(final String appNum,
			final String appStatus, final ABSaveAndExitBO saveAndExitBO)
			throws ApplicationException, InterruptedException {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ARTransactionManagedEJBBean.getAppnum() - START");
		String bridgesAppNum = saveAndExitBO.updateAppCrossRef(appNum,
				AppConstants.AFB_APP_CONV_ST_PROCESSING);
		if (bridgesAppNum != null
				&& "NOWAITEXCEPTION".equals(bridgesAppNum.toUpperCase())) {
			try {
				bridgesAppNum = getAppnum(appNum,
						AppConstants.AFB_APP_CONV_ST_PROCESSING, saveAndExitBO);
			} catch (final InterruptedException intEx) {
				throw intEx;
			}
		}

		log(ILog.INFO,
				"ARTransactionManagedEJBBean.getAppnum() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return bridgesAppNum;
	}

	/**
	 * Store ssa response.
	 *
	 * @param mediColl
	 *            the medi coll
	 * @param ssaCompositeResponseType
	 *            the ssa composite response type
	 */
	public void storeSSAResponse(final APP_INDV_Collection mediColl,
			final SSACompositeResponseType ssaCompositeResponseType) {
		final String appNum = mediColl.getCargo(0).getApp_num();
		final SSACompositeIndividualResponseType[] indvResponseList = ssaCompositeResponseType
				.getSSACompositeIndividualResponse();
		final int size = indvResponseList.length;
		final SSA_CMPS_SVC_RESPONSE_Collection ssaColl = new SSA_CMPS_SVC_RESPONSE_Collection();
		try {
			for (int i = 0; i < size; i++) {
				final SSACompositeIndividualResponseType indvResponse = indvResponseList[i];
				final SSA_CMPS_SVC_RESPONSE_Cargo ssaCargo = new SSA_CMPS_SVC_RESPONSE_Cargo();
				ssaCargo.setCargoName("SSA_CMPS_SVC_RESPONSE_Cargo");
				ssaCargo.setRowAction(FwConstants.ROWACTION_INSERT);
				ssaCargo.setApp_num(appNum);
				ssaCargo.setIndv_seq_num(mediColl.getCargo(i).getIndv_seq_num());
				final ResponseMetadataType metadata = indvResponse
						.getResponseMetadata();
				if (metadata.getResponseCode() != null
						&& metadata.getResponseCode()
						.getResponseCodeSimpleType().length() > 0) {
					ssaCargo.setResponse_cd(metadata.getResponseCode()
							.getResponseCodeSimpleType());
				}
				if (metadata.getResponseDescriptionText() != null
						&& metadata.getResponseDescriptionText().length() > 0) {
					ssaCargo.setResponse_desc_txt(metadata
							.getResponseDescriptionText());
				}
				if (metadata.getResponseDescriptionText() != null
						&& metadata.getResponseDescriptionText().length() > 0) {
					ssaCargo.setResponse_desc_txt(metadata
							.getResponseDescriptionText());
				}
				if (metadata.getTDSResponseDescriptionText() != null
						&& metadata.getTDSResponseDescriptionText().length() > 0) {
					ssaCargo.setTds_response_desc_txt(metadata
							.getTDSResponseDescriptionText());
				}
				if (indvResponse.getPersonSSNIdentification().get_x002A_body() != null
						&& indvResponse.getPersonSSNIdentification()
						.get_x002A_body().length() > 0) {
					ssaCargo.setPerson_ssn(indvResponse
							.getPersonSSNIdentification().get_x002A_body());
				}
				final SSAResponseType response = indvResponse.getSSAResponse();
				if (response!=null && response.getSSNVerificationIndicator() != null) {
					ssaCargo.setSsn_verifi_ind(response
							.getSSNVerificationIndicator().get_boolean() ? FwConstants.YES
									: FwConstants.NO);
				}
				if (response!=null && response.getDeathConfirmationCode()!=null &&response.getDeathConfirmationCode().getValue() != null
						&& response.getDeathConfirmationCode().getValue()
						.toString().length() > 0) {
					ssaCargo.setDeath_confirmation_cd(response
							.getDeathConfirmationCode().getValue().toString());
				}
				if (response!=null && response.getPersonUSCitizenIndicator() != null) {
					ssaCargo.setPerson_us_citizen_ind(response
							.getPersonUSCitizenIndicator().get_boolean() ? FwConstants.YES
									: FwConstants.NO);
				}
				if (response!=null && response.getPersonIncarcerationInformationIndicator() != null) {
					ssaCargo.setPerson_incarcer_info_ind(response
							.getPersonIncarcerationInformationIndicator()
							.get_boolean() ? FwConstants.YES : FwConstants.NO);
				}
				if (response!=null && response.getSSATitleIIMonthlyIncomeInformationIndicator() != null) {
					ssaCargo.setSsa_tii_mi_info_ind(response
							.getSSATitleIIMonthlyIncomeInformationIndicator()
							.get_boolean() ? FwConstants.YES : FwConstants.NO);
				}
				if (response!=null && response.getSSATitleIIAnnualIncomeInformationIndicator() != null) {
					ssaCargo.setSsa_tii_al_infor_ind(response
							.getSSATitleIIAnnualIncomeInformationIndicator()
							.get_boolean() ? FwConstants.YES : FwConstants.NO);
				}
				ssaColl.addCargo(ssaCargo);
			}
			final ABFinalSubmitBO finalBO = new ABFinalSubmitBO();
			finalBO.saveSSAResponse(ssaColl);
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			log(ILog.DEBUG,
					"ABTransactionManagedEJBBean::storeSSAResponse:SSA_CMPS_SVC_RESPONSE : "
							+ fe.getMessage());
			throw exceptionManagerLog(fe, getClass().getName(), "storeSSAResponse");
		}
	}

	/**
	 * calls both work number services and updates the verification status.
	 *
	 * @param txnBean
	 *            the txn bean
	 * @throws EJBException
	 *             the EJB exception
	 * @throws javax.ejb.EJBException
	 *             the javax.ejb. ejb exception
	 */

	public void loadWorkNumberService(final FwTransaction txnBean)
			throws javax.ejb.EJBException {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"ARTransactionManagedEJBBean.loadWorkNumberService() - START");

		String appNum = null;
		try {
			log(ILog.INFO,
					"ARTransactionManagedEJBBean::loadWorkNumberService:Start");
			final Map session = txnBean.getSession();
			List ssnList = new ArrayList();
			List einList = new ArrayList();

			appNum = (String) session.get(AppConstants.APP_NUMBER);

			final RMBReceiveWebServiceBO webServiceBo = new RMBReceiveWebServiceBO();
			ssnList = webServiceBo.getSsnForIndivduals(appNum);

			final int size = ssnList.size();

			for (int i = 0; i < size; i++) {
				ssnList.get(i);

			}
			final Iterator<String> ssnIterator = ssnList.iterator();

			while (ssnIterator.hasNext()) {
				final String ssn = ssnIterator.next();
				webServiceBo.getFullEmployerHistory(txnBean,
						AppConstants.TRNUID, AppConstants.TRNPURPOSE, ssn);

				einList = webServiceBo.getEinForIndividuals(appNum, ssn);

				final Iterator<String> einIterator = einList.iterator();

				while (einIterator.hasNext()) {
					final String eiNum = einIterator.next();
					webServiceBo.getFullEmployerDetails(txnBean,
							AppConstants.TRNUID, AppConstants.TRNPURPOSE, ssn,
							eiNum);
				}
			}

			log(ILog.INFO, "ReportMyChangesEJBBean::loadWorkNumberService:End");
		} catch (final FwException fe) {
			javaTransactionFailure();
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(getClass().getName());
			we.setCallingMethodID("loadWorkNumberService");
			we.setFwException(fe);
			throw exceptionManagerLog(fe, getClass().getName(), "loadWorkNumberService");
		} catch (final Exception e) {
			javaTransactionFailure();
			final FwException fe = createFwException(getClass().getName(),
					"loadWorkNumberService", e);
			throw exceptionManagerLog(fe, getClass().getName(), "loadWorkNumberService");
		}

		log(ILog.INFO,
				"ARTransactionManagedEJBBean.loadWorkNumberService() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");

	}

	/**
	 * SSA validation.
	 *
	 * @param appIndvCollection
	 *            the app indv collection
	 * @param ssaCompositeResponseType
	 *            the ssa composite response type
	 * @return the boolean[]
	 */
	public boolean[] SSAValidation(final APP_INDV_Collection appIndvCollection,
			final SSACompositeResponseType ssaCompositeResponseType) {
		final boolean[] result = new boolean[appIndvCollection.size()];
		Arrays.fill(result, true);
		ReferenceTableManager.getInstance();
		final String appNum = appIndvCollection.getCargo(0).getApp_num();
		APP_IN_UEI_Collection ueiColl = new APP_IN_UEI_Collection();
		final ABFinalSubmitBO finalBO = new ABFinalSubmitBO();
		ueiColl = finalBO.loadUEIInfo(appNum);
		final Map<String, Double> ueiInfo = new HashMap<String, Double>();
		for (int i = 0; i < ueiColl.size(); i++) {
			final APP_IN_UEI_Cargo cargo = new APP_IN_UEI_Cargo();
			if ("UC".equals(cargo.getUei_typ())) {
				final String freq = ueiColl.getCargo(i).getFreq_cd();
				final String ueiamt = ueiColl.getCargo(i).getUei_amt();
				double converter = 0;
				switch (freq) {
				case "DA":
					converter = 30.4166;
					break;
				case "WK":
					converter = 4.3333;
					break;
				case "BI":
					converter = 2.1666;
					break;
				case "TM":
					converter = 2.0000;
					break;
				case "MO":
					converter = 1.0000;
					break;
				case "QU":
					converter = 0.3333;
					break;
				case "SA":
					converter = 0.1666;
					break;
				case "AN":
					converter = 0.0833;
					break;
				default:
					converter = 0;
					break;
				}
				final double tempamt = Double.parseDouble(ueiamt);
				double amt = 0;
				if (ueiInfo.get(cargo.getIndv_seq_num()) != null) {
					amt = ueiInfo.get(cargo.getIndv_seq_num());
					amt = amt + tempamt * converter;
				} else {
					amt = tempamt * converter;
				}
				ueiInfo.put(cargo.getIndv_seq_num(), amt);
			}
			final SSACompositeIndividualResponseType[] ssaResponseType = ssaCompositeResponseType
					.getSSACompositeIndividualResponse();
			for (int j = 0; j < ssaResponseType.length; j++) {
				final SSACompositeIndividualResponseType ssaResponse = ssaResponseType[j];
				final SSAResponseType response = ssaResponse.getSSAResponse();
				if (response.getSSATitleIIMonthlyIncome() != null) {
					final SSATitleIIMonthlyIncomeType monthlyIncomInfo = response
							.getSSATitleIIMonthlyIncome();
					final SSATitleIIMonthlyInformationType thismonthInfo = monthlyIncomInfo
							.getRequestedMonthInformation();
					final double responseAmt = thismonthInfo
							.getMonthlyIncomeAmount().doubleValue();
					final double amt = ueiInfo
							.get(j + FwConstants.EMPTY_STRING);
					if (Math.abs(responseAmt - amt) / amt > 0.05) {
						result[j] = false;
					}
				}
			}
		}
		return result;
	}

	/**
	 * UI benefit validation.
	 *
	 * @param appIndvCollection
	 *            the app indv collection
	 * @param uiBenefitColl
	 *            the ui benefit coll
	 * @return the boolean[]
	 */
	public boolean[] UIBenefitValidation(
			final APP_INDV_Collection appIndvCollection,
			final CP_DOL_UCB_RESP_Collection uiBenefitColl) {
		final boolean[] result = new boolean[appIndvCollection.size()];
		Arrays.fill(result, true);
		final ABFinalSubmitBO finalBO = new ABFinalSubmitBO();
		for (int i = 0; i < appIndvCollection.size(); i++) {
			final APP_INDV_Cargo cargo = appIndvCollection.getCargo(i);
			final String appNum = cargo.getApp_num();
			final String indvSeqNum = cargo.getIndv_seq_num();
			final APP_IN_UEI_Collection ueiColl = finalBO.loadUCBIInfo(appNum,
					indvSeqNum);
			final Calendar cal = Calendar.getInstance();
			final java.util.Date date = cal.getTime();
			final double ueiAmt = finalBO.ueiAggregate(ueiColl, date);
			final String ssn = cargo.getSsn_num();
			double ueiamtount = 0.0;
			for (int j = 0; j < uiBenefitColl.size(); j++) {
				final CP_DOL_UCB_RESP_Cargo ucbCargo = uiBenefitColl
						.getCargo(j);
				if (ucbCargo.getSsn().equals(ssn)) {
					ueiamtount += Double.parseDouble(ucbCargo
							.getWeekly_ben_amt());
				}
			}
			if (Math.abs(ueiamtount - ueiAmt) / ueiAmt > 0.05) {
				result[i] = false;
			}
		}
		return result;
	}

	/**
	 * Store dolui benefit response.
	 *
	 * @param appIndvCollection
	 *            the app indv collection
	 * @param getUIBenefitInfoOutput
	 *            the get ui benefit info output
	 * @return the c p_ do l_ uc b_ res p_ collection
	 */
	public CP_DOL_UCB_RESP_Collection storeDOLUIBenefitResponse(
			final APP_INDV_Collection appIndvCollection,
			final GetUIBenefitInfoOutput getUIBenefitInfoOutput) {
		final Response response = getUIBenefitInfoOutput.getResponse();
		final CP_DOL_UCB_RESP_Collection coll = new CP_DOL_UCB_RESP_Collection();
		if (response.getReturnCode() == 0) {
			try {
				final List<UiBenefitInfo> uiBenefitList = response
						.getUIBenefitInfo();
				for (int i = 0; i < uiBenefitList.size(); i++) {
					final UiBenefitInfo uiBenefit = uiBenefitList.get(i);
					final String dolInd = null;
					final String ssn = uiBenefit.getSSN()
							+ FwConstants.EMPTY_STRING;
					final MailingAddress mailAddress = uiBenefit
							.getClaimantMailingAddress();
					final String mailFirstName = mailAddress.getFirstName();
					final String mailLastName = mailAddress.getLastName();
					final String mailMiddleInitial = mailAddress
							.getMiddleInitial();
					final String mailStreetAddress = mailAddress
							.getStreetAddress();
					final String mailCity = mailAddress.getCity();
					final String mailState = mailAddress.getState();
					final String mailZip = mailAddress.getZip();
					final BenefitPayments benefitpayments = uiBenefit
							.getBenefitPayments();
					final List<UiBenefitDetails> benefitDetailsList = benefitpayments
							.getBenefitPayment();
					for (int j = 0; j < benefitDetailsList.size(); j++) {
						final CP_DOL_UCB_RESP_Cargo cargo = new CP_DOL_UCB_RESP_Cargo();
						cargo.setCargoName("CP_DOL_UCB_RESP_Cargo");
						cargo.setRowAction(FwConstants.ROWACTION_INSERT);
						final UiBenefitDetails benefitDetails = benefitDetailsList
								.get(j);
						String beginDate;
						if (benefitDetails.getBeginDate() != null) {
							beginDate = benefitDetails.getBeginDate()
									.toString();
						} else {
							beginDate = null;
						}
						String endDate;
						if (benefitDetails.getEndDate() != null) {
							endDate = benefitDetails.getEndDate().toString();
						} else {
							endDate = null;
						}
						final String weeklyBenefitamout = benefitDetails
								.getWeeklyBenefitAmount()
								+ FwConstants.EMPTY_STRING;
						final String totalBenefitAwarded = benefitDetails
								.getTotalBenefitAwarded()
								+ FwConstants.EMPTY_STRING;
						String benefitExhaustDate;
						if (benefitDetails.getBenefitExhaustDate() != null) {
							benefitExhaustDate = benefitDetails
									.getBenefitExhaustDate().toString();
						} else {
							benefitExhaustDate = null;
						}
						String benefitPaidDate;
						if (benefitDetails.getBenefitPaidDate() != null) {
							benefitPaidDate = benefitDetails
									.getBenefitPaidDate().toString();
						} else {
							benefitPaidDate = null;
						}
						final String availableBalance = benefitDetails
								.getAvailableBalance()
								+ FwConstants.EMPTY_STRING;
						final String extendedBenefitIndicator = benefitDetails
								.getExtendedBenefitIndicator();
						String checkdate;
						if (benefitDetails.getCheckDate() != null) {
							checkdate = benefitDetails.getCheckDate()
									.toString();
						} else {
							checkdate = null;
						}
						final String checkamount = benefitDetails
								.getCheckAmount() + FwConstants.EMPTY_STRING;
						if (ssn != null && ssn.length() > 0) {
							cargo.setSsn(ssn);
						}
						if (benefitExhaustDate != null
								&& benefitExhaustDate.length() > 0) {
							cargo.getBen_exhaust_dt();
						}
						if (availableBalance != null
								&& availableBalance.length() > 0) {
							cargo.setAvail_balance(availableBalance);
						}
						if (benefitPaidDate != null
								&& benefitPaidDate.length() > 0) {
							cargo.setBen_paid_dt(benefitPaidDate);
						}
						if (checkamount != null && checkamount.length() > 0) {
							cargo.setCheck_amount(checkamount);
						}
						if (checkdate != null && checkdate.length() > 0) {
							cargo.setCheck_date(checkdate);
						}
						if (mailCity != null && mailCity.length() > 0) {
							cargo.setClaimant_city(mailCity);
						}
						if (mailFirstName != null && mailFirstName.length() > 0) {
							cargo.setClaimant_first_name(mailFirstName);
						}
						if (mailLastName != null && mailLastName.length() > 0) {
							cargo.setClaimant_last_name(mailLastName);
						}
						if (mailMiddleInitial != null
								&& mailMiddleInitial.length() > 0) {
							cargo.setClaimant_middle_initial(mailMiddleInitial);
						}
						if (mailStreetAddress != null
								&& mailStreetAddress.length() > 0) {
							cargo.setClaimant_street_address(mailStreetAddress);
						}
						if (mailState != null && mailState.length() > 0) {
							cargo.setClaimant_state(mailState);
						}
						if (mailZip != null && mailZip.length() > 0) {
							cargo.setClaimant_zip(mailZip);
						}
						if (dolInd != null && dolInd.length() > 0) {
							cargo.setDol_ucb_resp_seq(dolInd);
						}
						if (extendedBenefitIndicator != null
								&& extendedBenefitIndicator.length() > 0) {
							cargo.setExtended_benefits(extendedBenefitIndicator);
						}
						if (totalBenefitAwarded != null
								&& totalBenefitAwarded.length() > 0) {
							cargo.setTotal_ben_awarded(totalBenefitAwarded);
						}
						if (beginDate != null && beginDate.length() > 0) {
							cargo.setUi_ben_begin_dt(beginDate);
						}
						if (endDate != null && endDate.length() > 0) {
							cargo.setUi_ben_end_dt(endDate);
						}
						if (weeklyBenefitamout != null
								&& weeklyBenefitamout.length() > 0) {
							cargo.setWeekly_ben_amt(weeklyBenefitamout);
						}
						coll.addCargo(cargo);
					}

				}
				final ABFinalSubmitBO finalBO = new ABFinalSubmitBO();
				finalBO.saveDOLUIBenefitResponse(coll);

			} catch (final FwException fe) {
				if (ctx != null) {
					ctx.setRollbackOnly();
				}
				log(ILog.DEBUG,
						"ABTransactionManagedEJBBean::storeDOLUIBenefitResponse:getUIBenefitInfoOutput : "
								+ fe.getMessage());
				throw exceptionManagerLog(fe, getClass().getName(), "storeDOLUIBenefitResponse");
			}

		}
		return coll;
	}

	/**
	 * Wages validation.
	 *
	 * @param appIndvCollection
	 *            the app indv collection
	 * @param wageColl
	 *            the wage coll
	 * @return the boolean[]
	 */
	public boolean[] wagesValidation(
			final APP_INDV_Collection appIndvCollection,
			final CP_DOL_WAGES_INFO_Collection wageColl) {
		final boolean[] result = new boolean[appIndvCollection.size()];
		Arrays.fill(result, true);
		final ABFinalSubmitBO finalBO = new ABFinalSubmitBO();
		for (int i = 0; i < appIndvCollection.size(); i++) {
			final APP_INDV_Cargo cargo = appIndvCollection.getCargo(i);
			final String appNum = cargo.getApp_num();
			final String indvSeqNum = cargo.getIndv_seq_num();
			final APP_IN_EMPL_Collection emplColl = finalBO.loadWageIInfo(
					appNum, indvSeqNum);
			final Calendar cal = Calendar.getInstance();
			final java.util.Date date = cal.getTime();
			int year = cal.get(Calendar.DAY_OF_YEAR);
			cal.set(year, 2, 31);
			final java.util.Date q1 = cal.getTime();
			cal.set(year, 5, 30);
			final java.util.Date q2 = cal.getTime();
			cal.set(year, 8, 30);
			final java.util.Date q3 = cal.getTime();
			cal.set(year, 11, 31);
			final java.util.Date q4 = cal.getTime();
			String quarter = FwConstants.EMPTY_STRING;
			if (date.before(q1)) {
				date.setTime(q1.getTime());
				quarter = "4";
				year = year - 1;
			} else if (date.before(q2)) {
				date.setTime(q2.getTime());
				quarter = FwConstants.ONE;
			} else if (date.before(q3)) {
				date.setTime(q3.getTime());
				quarter = "2";
			} else if (date.before(q4)) {
				date.setTime(q4.getTime());
				quarter = "3";
			}
			final double wageAmt = finalBO.wageAggregate(emplColl, date);
			final String ssn = cargo.getSsn_num();
			double responseAmt = 0.0;
			final String qtrYr = quarter + "/" + year;
			for (int j = 0; j < wageColl.size(); j++) {
				final CP_DOL_WAGES_INFO_Cargo wageCargo = wageColl.getCargo(j);
				if (wageCargo.getSsn().equals(ssn)
						&& wageCargo.getQtr_yr().equals(qtrYr)) {
					responseAmt += Double.parseDouble(wageCargo.getWage_amt());
				}
			}
			if (Math.abs(responseAmt - wageAmt) / wageAmt > 0.05) {
				result[i] = false;
			}
		}
		return result;
	}

	/**
	 * Store dol wages response.
	 *
	 * @param appIndvCollection
	 *            the app indv collection
	 * @param getWagesResponse
	 *            the get wages response
	 * @return the c p_ do l_ wage s_ inf o_ collection
	 */
	public CP_DOL_WAGES_INFO_Collection storeDOLWagesResponse(
			final APP_INDV_Collection appIndvCollection,
			final GetWagesResponse getWagesResponse) {
		final gov.state.nextgen.ejb.business.services.dol.wages.Response response = getWagesResponse
				.getResponse();
		final List<WageInfo> wageInfoList = response.getWageInfo();
		final CP_DOL_WAGES_INFO_Collection coll = new CP_DOL_WAGES_INFO_Collection();
		try {
			for (int i = 0; i < wageInfoList.size(); i++) {
				final WageInfo wageInfo = wageInfoList.get(i);
				final String ssn = wageInfo.getSSN() + FwConstants.EMPTY_STRING;
				final String dolWageInd = wageInfo.getDOLWageIndicator();
				final List<EmployerInfo> employerInfoList = wageInfo
						.getEmployerInfo();
				for (int j = 0; j < employerInfoList.size(); j++) {
					final EmployerInfo employerInfo = employerInfoList.get(j);
					final String employerName = employerInfo.getEmployerName();
					final String locationAddressLine1 = employerInfo
							.getLocationAddressLine1();
					final String locationAddressLine2 = employerInfo
							.getLocationAddressLine2();
					final String locationCity = employerInfo.getLocationCity();
					final String locationStateCode = employerInfo
							.getLocationStateCode();
					String locationZip;
					if (employerInfo.getLocationZip() != null) {
						locationZip = employerInfo.getLocationZip().toString();
					} else {
						locationZip = null;
					}
					String locationTelNum;
					if (employerInfo.getLocationTelNum() != null) {
						locationTelNum = employerInfo.getLocationTelNum()
								.toString();
					} else {
						locationTelNum = null;
					}
					final String mailingAddressLine1 = employerInfo
							.getMailingAddressLine1();
					final String mailingAddressLine2 = employerInfo
							.getMailingAddressLine2();
					final String mailingCity = employerInfo.getMailingCity();
					final String mailingStateCd = employerInfo
							.getMailingStateCode();
					String mailingZip;
					if (employerInfo.getMailingZip() != null) {
						mailingZip = employerInfo.getMailingZip().toString();
					} else {
						mailingZip = null;
					}
					String mailingTelNum;
					if (employerInfo.getMailingTelNum() != null) {
						mailingTelNum = employerInfo.getMailingTelNum()
								.toString();
					} else {
						mailingTelNum = null;
					}
					final List<Wage> wageList = employerInfo.getWages();
					for (int k = 0; k < wageList.size(); k++) {
						final Wage wage = wageList.get(k);
						final String qtrYr = wage.getQtrYr();
						final String wageAmt = wage.getWageAmount();
						final String surnameprefix = wage.getSurnamePrefix();
						final CP_DOL_WAGES_INFO_Cargo cargo = new CP_DOL_WAGES_INFO_Cargo();
						cargo.setCargoName("CP_DOL_WAGES_INFO_Cargo");
						cargo.setRowAction(FwConstants.ROWACTION_INSERT);
						if (ssn != null && ssn.length() > 0) {
							cargo.setSsn(ssn);
						}
						if (dolWageInd != null && dolWageInd.length() > 0) {
							cargo.setDol_wage_ind(dolWageInd);
						}
						if (employerName != null && employerName.length() > 0) {
							cargo.setEmployer_name(employerName);
						}
						if (locationAddressLine1 != null
								&& locationAddressLine1.length() > 0) {
							cargo.setLocation_addr_line_1(locationAddressLine1);
						}
						if (locationAddressLine2 != null
								&& locationAddressLine2.length() > 0) {
							cargo.setLocation_addr_line_2(locationAddressLine2);
						}
						if (locationCity != null && locationCity.length() > 0) {
							cargo.setLocation_city(locationCity);
						}
						if (locationStateCode != null
								&& locationStateCode.length() > 0) {
							cargo.setLocation_st_cd(locationStateCode);
						}
						if (locationZip != null && locationZip.length() > 0) {
							cargo.setLocation_zip(locationZip);
						}
						if (locationTelNum != null
								&& locationTelNum.length() > 0) {
							cargo.setLocation_tel_num(locationTelNum);
						}
						if (mailingAddressLine1 != null
								&& mailingAddressLine1.length() > 0) {
							cargo.setMailing_addr_line_1(mailingAddressLine1);
						}
						if (mailingAddressLine2 != null
								&& mailingAddressLine2.length() > 0) {
							cargo.setMailing_addr_line_2(mailingAddressLine2);
						}
						if (mailingCity != null && mailingCity.length() > 0) {
							cargo.setMailing_city(mailingCity);
						}
						if (mailingStateCd != null
								&& mailingStateCd.length() > 0) {
							cargo.setMailing_st_cd(mailingStateCd);
						}
						if (mailingZip != null && mailingZip.length() > 0) {
							cargo.setMailing_zip(mailingZip);
						}
						if (mailingTelNum != null && mailingTelNum.length() > 0) {
							cargo.setMailing_tel_num(mailingTelNum);
						}
						if (qtrYr != null && qtrYr.length() > 0) {
							cargo.setQtr_yr(qtrYr);
						}
						if (wageAmt != null && wageAmt.length() > 0) {
							cargo.setWage_amt(wageAmt);
						}
						if (surnameprefix != null && surnameprefix.length() > 0) {
							cargo.setSurname_prefix(surnameprefix);
						}
						coll.addCargo(cargo);
					}
				}

			}
			final ABFinalSubmitBO finalBO = new ABFinalSubmitBO();
			finalBO.saveDOLWageResponse(coll);
			return coll;
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			log(ILog.DEBUG,
					"ABTransactionManagedEJBBean::storeDOLWagesResponse:getWagesResponse : "
							+ fe.getMessage());
			throw exceptionManagerLog(fe, getClass().getName(), "storeDOLWagesResponse");
		}
	}

	/**
	 * Store rte results.
	 *
	 * @param appIndvCollection
	 *            the app indv collection
	 * @param ssaResults
	 *            the ssa results
	 * @param ssnResults
	 *            the ssn results
	 * @param citizenResults
	 *            the citizen results
	 * @param wageResults
	 *            the wage results
	 * @param uiBenefitResults
	 *            the ui benefit results
	 * @param workNumberResults
	 *            the work number results
	 */
	private void storeRTEResults(final APP_INDV_Collection appIndvCollection,
			final boolean[] ssaResults, final boolean[] ssnResults,
			final boolean[] citizenResults, final boolean[] wageResults,
			final boolean[] uiBenefitResults, final boolean[] workNumberResults) {
		final CP_RTE_VERF_Collection coll = new CP_RTE_VERF_Collection();
		//final String appNum = appIndvCollection.getCargo(0).getApp_num();
		for (int i = 0; i < appIndvCollection.size(); i++) {

			final APP_INDV_Cargo indvCargo = appIndvCollection.getCargo(i);
			indvCargo.setRowAction(FwConstants.ROWACTION_UPDATE);

			final CP_RTE_VERF_Cargo cargo = new CP_RTE_VERF_Cargo();
			cargo.setCargoName("CP_RTE_VERF_Cargo");
			cargo.setRowAction(FwConstants.ROWACTION_INSERT);
			cargo.setApp_num(indvCargo.getApp_num());
			cargo.setIndv_seq_num(i + 1 + FwConstants.EMPTY_STRING);

			String ssnResult = FwConstants.EMPTY_STRING;
			if (ssnResults[i]) {
				ssnResult = FwConstants.YES;
			} else {
				ssnResult = FwConstants.NO;
			}
			cargo.setSsn_vrf(ssnResult);
			cargo.setDob_vrf(ssnResult);
			if (AppConstants.YES.equals(ssnResult)) {
				indvCargo.setSsn_vrfn_fed_hub_ind(AppConstants.FDSH_APPROVED);
				indvCargo.setDob_fed_hub_ind(AppConstants.FDSH_APPROVED);
			}

			String citizenResult = FwConstants.EMPTY_STRING;
			if (citizenResults[i]) {
				citizenResult = FwConstants.YES;
			} else {
				citizenResult = FwConstants.NO;
			}
			cargo.setCitizen_status_vrf(citizenResult);
			if (AppConstants.YES.equals(citizenResult)) {
				indvCargo.setUs_ctzn_fed_hub_ind(AppConstants.FDSH_APPROVED);
			}

			String ssaResult = FwConstants.EMPTY_STRING;
			if (ssaResults[i]) {
				ssaResult = FwConstants.YES;
			} else {
				ssaResult = FwConstants.NO;
			}
			cargo.setUnearned_income_fdsh_vrf(ssaResult);

			String wageResult = FwConstants.EMPTY_STRING;
			if (wageResults[i]) {
				wageResult = FwConstants.YES;
			} else {
				wageResult = FwConstants.NO;
			}
			cargo.setEarned_inc_dol_vrf(wageResult);
			if (AppConstants.YES.equals(wageResult)) {
				indvCargo.setEarned_inc_dol_ind(AppConstants.DOL_APPROVED);
			}

			String uiBenefitResult = FwConstants.EMPTY_STRING;
			if (uiBenefitResults[i]) {
				uiBenefitResult = FwConstants.YES;
			} else {
				uiBenefitResult = FwConstants.NO;
			}
			cargo.setUnearned_income_dol_vrf(uiBenefitResult);
			if (AppConstants.YES.equals(uiBenefitResult)) {
				indvCargo.setUnearned_inc_dol_ind(AppConstants.DOL_APPROVED);
			}

			String workNumberResult = FwConstants.EMPTY_STRING;
			if (workNumberResults[i]) {
				workNumberResult = FwConstants.YES;
			} else {
				workNumberResult = FwConstants.NO;
			}
			cargo.setEarned_inc_work_number_vrf(workNumberResult);

			coll.addCargo(cargo);
		}
		final ABFinalSubmitBO finalBO = new ABFinalSubmitBO();
		finalBO.saveRTEResults(coll);
		finalBO.saveRTEIndicators(appIndvCollection);
	}

	/**
	 * Sets the healthy babies indicators.
	 *
	 * @param rCargo
	 *            the r cargo
	 * @return the RM c_ i n_ prf l_ cargo
	 */
	private RMC_IN_PRFL_Cargo setHealthyBabiesIndicators(
			final RMC_IN_PRFL_Cargo rCargo) {

		final String appNum = rCargo.getApp_num();

		final AFBAppRegBO afbAppRegBO = new AFBAppRegBO();
		final APP_IN_PLAN_HLTH_BABIES_Collection aColl = afbAppRegBO
				.getAppInPlanHlthBabiesCw(appNum);
		APP_IN_PLAN_HLTH_BABIES_Cargo aCargo = null;

		List babiesList = null;

		babiesList = getIndvCargoFromCollection(aColl,
				rCargo.getIndv_seq_num(), APP_IN_PLAN_HLTH_BABIES_Cargo.class,
				"getIndv_seq_num");

		if (null != babiesList && !babiesList.isEmpty()) {
			aCargo = (APP_IN_PLAN_HLTH_BABIES_Cargo) babiesList.get(0);

			rCargo.setAble_to_conceive_resp(aCargo.getAble_to_conceive_resp());
			rCargo.setUnderweight_birth_resp(aCargo.getUnderweight_birth_resp());
		}

		return rCargo;

	}

	/**
	 * Gets the indv cargo from collection.
	 *
	 * @param collection
	 *            the collection
	 * @param targetParameter
	 *            the target parameter
	 * @param cargoType
	 *            the cargo type
	 * @param methodName
	 *            the method name
	 * @return the indv cargo from collection
	 */
	private List<AbstractCargo> getIndvCargoFromCollection(
			final AbstractCollection collection, final String targetParameter,
			final Class cargoType, final String methodName) {
		try {
			final Method m = cargoType.getMethod(methodName);
			final List<AbstractCargo> cargoList = new ArrayList<AbstractCargo>();
			for (final Object o : collection) {
				final AbstractCargo cargo = (AbstractCargo) o;
				final String actualParameter = m.invoke(cargo).toString();
				if (actualParameter.equalsIgnoreCase(targetParameter)) {
					cargoList.add(cargo);
				}
			}
			return cargoList;
		} catch (final Exception e) {
			log(ILog.ERROR, e.getMessage());
			final FwException fe = FwExceptionManager.createFwException(
					getClass().getName(), "getIndvCargoFromCollection", e);
			throw exceptionManagerLog(fe, getClass().getName(), "getIndvCargoFromCollection");
		}

	}
	public CP_DOL_WAGES_INFO_Collection storeWPDOLWagesResponse(
			final APP_INDV_Collection appIndvCollection,
			final gov.state.nextgen.business.ejb.services.st.dol.GetWagesResponse getWPWagesResponse) {
		final gov.state.nextgen.business.ejb.services.st.dol.wage.webserviceentities.Response response = getWPWagesResponse
				.getResponse();
		final List<gov.state.nextgen.business.ejb.services.st.dol.wage.webserviceentities.WageInfo> wageInfos = response
				.getWageInfo();
		final CP_DOL_WAGES_INFO_Collection coll = new CP_DOL_WAGES_INFO_Collection();
		try {
			for (int i = 0; i < wageInfos.size(); i++) {
				final gov.state.nextgen.business.ejb.services.st.dol.wage.webserviceentities.WageInfo wageInfo = wageInfos
						.get(i);
				final String ssn = wageInfo.getSSN() + FwConstants.EMPTY_STRING;
				final String dolWageInd = wageInfo.getDOLWageIndicator();
				final List<gov.state.nextgen.business.ejb.services.st.dol.wage.webserviceentities.EmployerInfo> employerInfoList = wageInfo
						.getEmployerInfo();
				for (int j = 0; j < employerInfoList.size(); j++) {
					final gov.state.nextgen.business.ejb.services.st.dol.wage.webserviceentities.EmployerInfo employerInfo = employerInfoList
							.get(j);
					final String employerName = employerInfo.getEmployerName();
					final String locationAddressLine1 = employerInfo
							.getLocationAddressLine1();
					final String locationAddressLine2 = employerInfo
							.getLocationAddressLine2();
					final String locationCity = employerInfo.getLocationCity();
					final String locationStateCode = employerInfo
							.getLocationStateCode();
					String locationZip;
					if (employerInfo.getLocationZip() != null) {
						locationZip = employerInfo.getLocationZip().toString();
					} else {
						locationZip = null;
					}
					String locationTelNum;
					if (employerInfo.getLocationTelNum() != null) {
						locationTelNum = employerInfo.getLocationTelNum()
								.toString();
					} else {
						locationTelNum = null;
					}
					final String mailingAddressLine1 = employerInfo
							.getMailingAddressLine1();
					final String mailingAddressLine2 = employerInfo
							.getMailingAddressLine2();
					final String mailingCity = employerInfo.getMailingCity();
					final String mailingStateCd = employerInfo
							.getMailingStateCode();
					String mailingZip;
					if (employerInfo.getMailingZip() != null) {
						mailingZip = employerInfo.getMailingZip().toString();
					} else {
						mailingZip = null;
					}
					String mailingTelNum;
					if (employerInfo.getMailingTelNum() != null) {
						mailingTelNum = employerInfo.getMailingTelNum()
								.toString();
					} else {
						mailingTelNum = null;
					}
					final List<gov.state.nextgen.business.ejb.services.st.dol.wage.webserviceentities.Wage> wageList = employerInfo
							.getWages();
					for (int k = 0; k < wageList.size(); k++) {
						final gov.state.nextgen.business.ejb.services.st.dol.wage.webserviceentities.Wage wage = wageList
								.get(k);
						final String qtrYr = wage.getQtrYr();
						final String wageAmt = wage.getWageAmount();
						final String surnameprefix = wage.getSurnamePrefix();
						final CP_DOL_WAGES_INFO_Cargo cargo = new CP_DOL_WAGES_INFO_Cargo();
						cargo.setCargoName("CP_DOL_WAGES_INFO_Cargo");
						cargo.setRowAction(FwConstants.ROWACTION_INSERT);
						if ((ssn != null) && (ssn.length() > 0)) {
							cargo.setSsn(ssn);
						}
						if ((dolWageInd != null) && (dolWageInd.length() > 0)) {
							cargo.setDol_wage_ind(dolWageInd);
						}
						if ((employerName != null)
								&& (employerName.length() > 0)) {
							cargo.setEmployer_name(employerName);
						}
						if ((locationAddressLine1 != null)
								&& (locationAddressLine1.length() > 0)) {
							cargo.setLocation_addr_line_1(locationAddressLine1);
						}
						if ((locationAddressLine2 != null)
								&& (locationAddressLine2.length() > 0)) {
							cargo.setLocation_addr_line_2(locationAddressLine2);
						}
						if ((locationCity != null)
								&& (locationCity.length() > 0)) {
							cargo.setLocation_city(locationCity);
						}
						if ((locationStateCode != null)
								&& (locationStateCode.length() > 0)) {
							cargo.setLocation_st_cd(locationStateCode);
						}
						if ((locationZip != null) && (locationZip.length() > 0)) {
							cargo.setLocation_zip(locationZip);
						}
						if ((locationTelNum != null)
								&& (locationTelNum.length() > 0)) {
							cargo.setLocation_tel_num(locationTelNum);
						}
						if ((mailingAddressLine1 != null)
								&& (mailingAddressLine1.length() > 0)) {
							cargo.setMailing_addr_line_1(mailingAddressLine1);
						}
						if ((mailingAddressLine2 != null)
								&& (mailingAddressLine2.length() > 0)) {
							cargo.setMailing_addr_line_2(mailingAddressLine2);
						}
						if ((mailingCity != null) && (mailingCity.length() > 0)) {
							cargo.setMailing_city(mailingCity);
						}
						if ((mailingStateCd != null)
								&& (mailingStateCd.length() > 0)) {
							cargo.setMailing_st_cd(mailingStateCd);
						}
						if ((mailingZip != null) && (mailingZip.length() > 0)) {
							cargo.setMailing_zip(mailingZip);
						}
						if ((mailingTelNum != null)
								&& (mailingTelNum.length() > 0)) {
							cargo.setMailing_tel_num(mailingTelNum);
						}
						if ((qtrYr != null) && (qtrYr.length() > 0)) {
							cargo.setQtr_yr(qtrYr);
						}
						if ((wageAmt != null) && (wageAmt.length() > 0)) {
							cargo.setWage_amt(wageAmt);
						}
						if ((surnameprefix != null)
								&& (surnameprefix.length() > 0)) {
							cargo.setSurname_prefix(surnameprefix);
						}
						coll.addCargo(cargo);
					}
				}

			}
			final ABFinalSubmitBO finalBO = new ABFinalSubmitBO();
			finalBO.saveDOLWageResponse(coll);
			return coll;
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			log(ILog.DEBUG,
					"ABTransactionManagedEJBBean::storeDOLWagesResponse:getWagesResponse : "
							+ fe.getMessage());
			throw exceptionManagerLog(fe, getClass().getName(), "storeWPDOLWagesResponse");
		}
	}
}
