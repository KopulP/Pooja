package gov.state.nextgen.access.business.services;

import gov.state.nextgen.access.business.customEntities.INDIVIDUAL_Custom_Cargo;
import gov.state.nextgen.access.business.customEntities.INDIVIDUAL_Custom_Collection;
import gov.state.nextgen.access.business.customEntities.OTHER_BENEFITS_Custom_Cargo;
import gov.state.nextgen.access.business.customEntities.RMC_RESPONSE_Custom_Cargo;
import gov.state.nextgen.access.business.customEntities.RMC_RESPONSE_Custom_Collection;
import gov.state.nextgen.access.business.entities.APP_INDV_ADDI_INFO_Cargo;
import gov.state.nextgen.access.business.entities.APP_INDV_ADDI_INFO_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_BNFT_CNVCTN_Cargo;
import gov.state.nextgen.access.business.entities.APP_IN_BNFT_CNVCTN_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_DABL_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_FELON_DET_Cargo;
import gov.state.nextgen.access.business.entities.APP_IN_FELON_DET_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_HLTH_INS_BNFTS_Cargo;
import gov.state.nextgen.access.business.entities.APP_IN_HLTH_INS_BNFTS_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_MAPP_Cargo;
import gov.state.nextgen.access.business.entities.APP_IN_MAPP_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_MEDCR_Cargo;
import gov.state.nextgen.access.business.entities.APP_IN_MEDCR_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_MED_INS_Cargo;
import gov.state.nextgen.access.business.entities.APP_IN_MED_INS_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_OTHR_HLTH_INS_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_OUT_ST_BNFT_Cargo;
import gov.state.nextgen.access.business.entities.APP_IN_OUT_ST_BNFT_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_SCHLE_Cargo;
import gov.state.nextgen.access.business.entities.APP_IN_SCHLE_Collection;
import gov.state.nextgen.access.business.entities.APP_MED_INS_Cargo;
import gov.state.nextgen.access.business.entities.APP_MED_INS_Collection;
import gov.state.nextgen.access.business.entities.APP_PRFL_Cargo;
import gov.state.nextgen.access.business.entities.APP_PRFL_Collection;
import gov.state.nextgen.access.business.entities.CP_APP_IN_CARE_PROV_Cargo;
import gov.state.nextgen.access.business.entities.CP_APP_IN_CARE_PROV_Collection;
import gov.state.nextgen.access.business.entities.CP_APP_IN_LST_HLTH_INS_Cargo;
import gov.state.nextgen.access.business.entities.CP_APP_IN_LST_HLTH_INS_Collection;
import gov.state.nextgen.access.business.entities.CP_APP_IN_MED_INS_CVRG_Cargo;
import gov.state.nextgen.access.business.entities.CP_APP_IN_MED_INS_CVRG_Collection;
import gov.state.nextgen.access.business.entities.CP_APP_IN_TAX_INFORMATION_Cargo;
import gov.state.nextgen.access.business.entities.CP_APP_IN_TAX_INFORMATION_Collection;
import gov.state.nextgen.access.business.entities.RMB_RQST_Cargo;
import gov.state.nextgen.access.business.entities.RMB_RQST_Collection;
import gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Cargo;
import gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Collection;
import gov.state.nextgen.access.business.rules.ABHouseHoldMemberBO;
import gov.state.nextgen.access.business.rules.OutOfStateBenefitsBO;
import gov.state.nextgen.access.business.rules.assets.AssetBO;
import gov.state.nextgen.access.business.rules.benefits.HealthCareCoverageBO;
import gov.state.nextgen.access.business.rules.benefits.MappDetailsBO;
import gov.state.nextgen.access.business.rules.benefits.OtherBenefitsBO;
import gov.state.nextgen.access.business.rules.household.LostHealthInsBO;
import gov.state.nextgen.access.business.rules.household.MedicareBO;
import gov.state.nextgen.access.business.rules.household.SchoolEnrollmentBO;
import gov.state.nextgen.access.business.rules.household.TaxClaimDependantBO;
import gov.state.nextgen.access.business.validation.ChangingValidation;
import gov.state.nextgen.access.business.validation.rmc.details.ARMAPValidator;
import gov.state.nextgen.access.business.validation.rmc.questions.AROBQValidator;
import gov.state.nextgen.access.management.applications.CategorySequenceDetail;
import gov.state.nextgen.access.management.applications.CategorySequenceDetailsComparator;
import gov.state.nextgen.access.management.applications.IAppProfileManager;
import gov.state.nextgen.access.management.applications.IApplicationManager;
import gov.state.nextgen.access.management.applications.ICategorySelectionProfileManager;
import gov.state.nextgen.access.management.applications.IRMCResponseProfileManager;
import gov.state.nextgen.access.management.applications.QuestionsExtractionHandler;
import gov.state.nextgen.access.management.applications.RMBRequestManager;
import gov.state.nextgen.access.management.constants.AppConstants;
import gov.state.nextgen.access.management.individuals.PeopleHandler;
import gov.state.nextgen.access.management.programs.FwProgramManager;
import gov.state.nextgen.access.management.programs.IProgramManager;
import gov.state.nextgen.access.management.util.IndivTypeSeqBean;
import gov.state.nextgen.access.management.util.IndividualAge;
import gov.state.nextgen.access.presentation.entities.listview.RMBHealthInsIndvSelectionListView;
import gov.state.nextgen.access.presentation.entities.listview.RMBLostHealthInsuranceSelectionListView;
import gov.state.nextgen.access.presentation.entities.listview.RMBMappChangeSelectionListView;
import gov.state.nextgen.access.presentation.entities.listview.RMBMedicareExpIndvSelectionListView;
import gov.state.nextgen.access.presentation.entities.listview.RMBSchoolEnrlChangeSelectionListView;
import gov.state.nextgen.access.presentation.entities.listview.RMBSchoolEnrollmentChangesSummaryListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCBnftCnvctnDFTSummaryListVIew;
import gov.state.nextgen.access.presentation.entities.listview.RMCBnftCnvctnFRISummaryListVIew;
import gov.state.nextgen.access.presentation.entities.listview.RMCBnftCnvctnPDSSummaryListVIew;
import gov.state.nextgen.access.presentation.entities.listview.RMCBnftCnvctnSFESummaryListVIew;
import gov.state.nextgen.access.presentation.entities.listview.RMCBnftCnvctnTRASummaryListVIew;
import gov.state.nextgen.access.presentation.entities.listview.RMCBnftCnvctnTSBSummaryListVIew;
import gov.state.nextgen.access.presentation.entities.listview.RMCBnftCnvctnUBUSummaryListVIew;
import gov.state.nextgen.access.presentation.entities.listview.RMCBnftCnvctnVQJSummaryListVIew;
import gov.state.nextgen.access.presentation.entities.listview.RMCConvictionSelectionListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCDFTConvictionSelectionListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCFRIConvictionSelectionListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCFelonyConvictionSummaryListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCHealthInsuranceChangesSummaryListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCHosPiceListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCHospiceChangesSummaryListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCHospitalStayListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCHospitalStaySummaryListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCMedicareChangeSummaryListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCNursingHomeChangesSummaryListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCNursingHomeListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCOutStateBenefitsListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCOutStateSummaryListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCPDSConvictionSelectionListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCPastHealthInsuranceSummaryListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCSFEConvictionSelectionListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCSchoolEnrollmentGatePostListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCTRAConvictionSelectionListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCTSBConvictionSelectionListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCUBUConvictionSelectionListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCVQJConvictionSelectionListView;
import gov.state.nextgen.framework.business.entities.FwTransaction;
import gov.state.nextgen.framework.driver.IDriver;
import gov.state.nextgen.framework.exceptions.FwException;
import gov.state.nextgen.framework.exceptions.FwExceptionManager;
import gov.state.nextgen.framework.exceptions.FwWrappedException;
import gov.state.nextgen.framework.exceptions.IException;
import gov.state.nextgen.framework.factories.FwServiceFactory;
import gov.state.nextgen.framework.management.constants.FwConstants;
import gov.state.nextgen.framework.management.logging.wkp.ILog;
import gov.state.nextgen.framework.management.messages.FwMessageList;
import gov.state.nextgen.framework.management.references.IReferenceTableManager;
import gov.state.nextgen.framework.management.references.ReferenceTableManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * RMCOtherBenefitsEJBBean - SessionFacade Object.
 *
 * @author Gopal Nagaraj
 * Creation Date :07/15/2009 Modified By: Modified on:
 */

/* ************************************************************************************
 * ***************** SONAR FIXES MADE IN THIS CODE
 * ************************************** ISSUE DESCRIPTION NATURE OF FIX DATE
 * **** ================== ============= **** **** Avoid commented code Deleted
 * Commented code 09/1/2015 ** Lage Blocks of commented code *** are converted
 * to javadoc *** **
 * *************************************************************
 * *************************
 */

@javax.ejb.Stateless
@javax.ejb.LocalBean
@javax.ejb.TransactionManagement(javax.ejb.TransactionManagementType.CONTAINER)
public class RMCOtherBenefitsEJBBean extends RMCSessionBean {

	/** Constructor. */
	static final String ARLHI = "ARLHI";
	@EJB
	private RMCOtherBenefitsEJBBean rmcOtherBenefitsEJBBean;
	/**
	 * Instantiates a new RMC other benefits ejb bean.
	 */ 
	public RMCOtherBenefitsEJBBean() {
	}

	/**
	 * Gets the MAPP types.
	 *
	 * @return the MAPP types
	 */
	private Map getMAPPTypes() {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.getMAPPTypes() - START");

		final Map catDCTypes = new HashMap();
		catDCTypes.put("MC", "MC");

		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.getMAPPTypes() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return catDCTypes;

	}

	/**
	 * Load other benefits gate post questions.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 * @throws javax.ejb.EJBException the javax.ejb. ejb exception
	 */
	public void loadOtherBenefitsGatePostQuestions(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.loadOtherBenefitsGatePostQuestions() - START");

		try {
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::loadOtherBenefitsGatePostQuestions:Start");
			final Map session = txnBean.getSession();
			final Map pageCollection = txnBean.getPageCollection();
			final Map httpSession = (Map) session.get(FwConstants.HTTP_SESSION);
			Map beforeColl = (Map) session.get(FwConstants.BEFORE_COLLECTION);

			final SchoolEnrollmentBO schEnrlBO = new SchoolEnrollmentBO();
			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			// Get appNumber from the session
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			// get people handler from session
			final PeopleHandler peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);
			// Get Individuals
			final INDIVIDUAL_Custom_Collection indvColl = peopleHandler
					.getInHomeIndividuals();
			// get questions extraction handler from session
			final QuestionsExtractionHandler extractionHandler = (QuestionsExtractionHandler) session
					.get(AppConstants.QUESTION_EXTRACTION_HANDLER);
			// now get the components for the current page
			componentManager.getComponents("AROBQ", txnBean);
			// get component list from page collection
			final List cpntList = (ArrayList) pageCollection
					.get(FwConstants.PAGE_COMPONENT_LIST);

			// get RMB Rqst Manager
			final RMBRequestManager rmbRqstManager = new RMBRequestManager();
			// get rmc_in_prfl from session
			final RMC_IN_PRFL_Collection sessRMCInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			// get session RMC_CHG_SEL_PRFL
			final SortedSet sessChgSelectionProfile = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			// this map holds the response of
			Map securityRadioOptionsMap = new HashMap();
			// get RMB_RQST from session
			final RMB_RQST_Collection sessRMBRqstColl = (RMB_RQST_Collection) session
					.get(AppConstants.RMB_RQST_COLLECTION);
			// get language from httpsession
			final String languageCd = (String) httpSession
					.get(AppConstants.LANGUAGE);
			// get javascript enabled
			final String jsEnabled = (String) httpSession
					.get(FwConstants.JS_ENABLED);
			// intialize webservice type array
			final List typeArrayList = new ArrayList();

			// for getting the school Enrollment Details and for the web Service
			// call//
			if (cpntList.contains("5204")
					&& !extractionHandler.checkRMBExtractionStatus("AROBQ",
							"5204")) {
				typeArrayList.add(AppConstants.SCHOOL_ENROLLMENT);
			}
			// For Getting the Mapp Details and web service call

			if (cpntList.contains("5206")
					&& !extractionHandler.checkRMBExtractionStatus("AROBQ",
							"5206")) {
				typeArrayList.add(AppConstants.MAPP);
			}

			// now start webservice logic
			final AROBQValidator validationBO = new AROBQValidator();
			APP_IN_SCHLE_Collection schoolColl = null;
			final APP_IN_MAPP_Collection mappColl = null;
			if (typeArrayList != null && !typeArrayList.isEmpty()) {
				final List pinNumList = new ArrayList();
				final int indvCollSize = indvColl.size();
				INDIVIDUAL_Custom_Cargo indivCustCargo = null;
				// Filter pin numbers which are null (new individuals) - PCR
				// 30457era
				String pinNumber = null;
				APP_IN_SCHLE_Collection schColl = null;
				for (int i = 0; i < indvCollSize; i++) {
					indivCustCargo = indvColl.getResult(i);
					pinNumber = indivCustCargo.getIndv_pin_num();
					if (pinNumber != null) {
						pinNumList.add(indivCustCargo.getIndv_pin_num());
					}
				}

				final String[] arrayTypes = new String[typeArrayList.size()];
				for (int i = 0; i < typeArrayList.size(); i++) {
					arrayTypes[i] = (String) typeArrayList.get(i);
				}
				try {
					if (null!=typeArrayList && !typeArrayList.isEmpty()) {
						final OTHER_BENEFITS_Custom_Cargo otherBenefitsCustCargo = validationBO
								.getOtherBenefitsFromCares(pinNumList, appNum,
										arrayTypes);
						if (otherBenefitsCustCargo != null) {
							if (otherBenefitsCustCargo.getAppInMappColl() != null
									&& !otherBenefitsCustCargo
									.getAppInMappColl().isEmpty()) {

								final APP_IN_MAPP_Collection mappColl1 = otherBenefitsCustCargo
										.getAppInMappColl();
								final APP_IN_MAPP_Collection updatedMappColl = new APP_IN_MAPP_Collection();
								if (mappColl1 != null) {
									for (int i = 0; i < mappColl1.size(); i++) {
										final APP_IN_MAPP_Cargo mappCargo = mappColl1
												.getCargo(i);
										final String indvSeqNum = mappCargo
												.getIndv_seq_num();
										final IndividualAge indvAge = peopleHandler
												.getIndividualAge(indvSeqNum);
										final INDIVIDUAL_Custom_Cargo cargo = peopleHandler
												.getIndividual(indvSeqNum);

										if (indvAge.getYears() >= 18
												&& cargo.getDabl_resp() != null
												&& FwConstants.YES.equals(cargo
														.getDabl_resp())
														&& mappCargo
														.getMapp_rqst_resp() != null
														&& FwConstants.YES
														.equals(mappCargo
																.getMapp_rqst_resp())) {
											updatedMappColl.addCargo(mappCargo);
										}
									}

									validationBO
									.insertMappDetails(updatedMappColl);
									extractionHandler.addRMBExtractionStatus(
											"AROBQ", "5206");
									session.put(
											AppConstants.QUESTION_EXTRACTION_HANDLER,
											extractionHandler);
								}

							}
							if (otherBenefitsCustCargo.getAppInSchleColl() != null
									&& !otherBenefitsCustCargo
									.getAppInSchleColl().isEmpty()) {
								schColl = otherBenefitsCustCargo
										.getAppInSchleColl();
								final APP_IN_SCHLE_Collection updatedSchColl = new APP_IN_SCHLE_Collection();
								if (schColl != null) {
									for (int i = 0; i < schColl.size(); i++) {
										final APP_IN_SCHLE_Cargo schCargo = schColl
												.getResult(i);
										final String indvSeqNum = schCargo
												.getIndv_seq_num();
										final IndividualAge indvAge = peopleHandler
												.getIndividualAge(indvSeqNum);
										if (indvAge.getYears() >= 14
												&& indvAge.getYears() <= 49) {
											updatedSchColl.addCargo(schCargo);
										}
									}
									validationBO
									.insertSEDetails(updatedSchColl);
									extractionHandler.addRMBExtractionStatus(
											"AROBQ", "5204");
									session.put(
											AppConstants.QUESTION_EXTRACTION_HANDLER,
											extractionHandler);
								}
							}
						}
					}
				} catch (final FwException fe) {
					fe.setParameterText("Pin List is: " + pinNumList.toString()
							+ " AppNumber is: " + appNum);
					final FwWrappedException we = new FwWrappedException(fe);
					we.setCallingClassID(this.getClass().getName());
					we.setCallingMethodID("loadOtherBenefitsGatePostQuestions");
					we.setFwException(fe);
					final FwExceptionManager exceptionMgr = (FwExceptionManager) FwServiceFactory
							.getInstance().create(IException.class);
					exceptionMgr.log(we);
					return;

				} catch (final Exception e) {
					final FwException fe = createFwException(this.getClass()
							.getName(), "getEmploymentDetailsFromCares", e);
					fe.setParameterText("Pin List is: " + pinNumList.toString()
							+ " AppNumber is: " + appNum);
					final FwWrappedException we = new FwWrappedException(e);
					we.setCallingClassID(this.getClass().getName());
					we.setCallingMethodID("loadOtherBenefitsGatePostQuestions");
					we.setFwException(fe);
					final FwExceptionManager exceptionMgr = (FwExceptionManager) FwServiceFactory
							.getInstance().create(IException.class);
					exceptionMgr.log(we);
					return;
				}

			}

			schoolColl = schEnrlBO
					.getSchoolEnrlDetailsForChangeSelection(appNum);
			final RMCSchoolEnrollmentGatePostListView rmbschoolEnrlListView = new RMCSchoolEnrollmentGatePostListView();
			rmbschoolEnrlListView.setLanguage(languageCd);
			rmbschoolEnrlListView.setJsEnabled(jsEnabled);
			rmbschoolEnrlListView.setName("RMB_SCHLENRL_GATEPOST_LISTVIEW");
			rmbschoolEnrlListView.setDisplayData(schoolColl);
			rmbschoolEnrlListView.setPageSize(1000);
			pageCollection.put("RMB_SCHLENRL_GATEPOST_LISTVIEW",
					rmbschoolEnrlListView);

			/*
			 * VG SONAR Cleanup - 09/1/2015 Changed Commented code block to
			 * javadoc
			 */
			/**
			 * mappColl = mappBO.getMappDetailsForGatePost(appNum); // Now
			 * create your ListView for room and board List mappDataList = new
			 * ArrayList(2); mappDataList.add(indvColl);
			 * mappDataList.add(mappColl); mappDataList.add(peopleHandler);
			 */
			/*
			 * VG SONAR Cleanup - 09/1/2015 Deleted 5 lines Commented Code in
			 * this block
			 */
			// Put in page collection
			pageCollection.put("INDV_COLL", indvColl);
			pageCollection.put("APP_IN_MAPP_Collection", mappColl);
			pageCollection.put("APP_IN_SCHLE_Collection", schoolColl);
			pageCollection.put("RMB_RQST_PAGE_Collection", sessRMBRqstColl);
			// get current page driver status
			final int currentPageStaus = driverManager.getAFBStatus(
					FwConstants.RMC_DRIVER, "AROBQ", driverArray);
			// EDSP Need to Uncomment if statement

			// preapare security map for questions if the user is re-visting the
			// page
			if (currentPageStaus != FwConstants.DRIVER_REQUIRED) {
				// call RMBRequest Manager to get the question response
				securityRadioOptionsMap = rmbRqstManager.getStatusForGatePost(
						AppConstants.RMB_OTHER_BENEFITS_GATE_POST_PAGE,
						sessRMBRqstColl, driverArray, sessRMCInPrflColl,
						sessChgSelectionProfile, peopleHandler);
				pageCollection.put("RADIO_OPTION_MAP", securityRadioOptionsMap);
			}

			if (beforeColl == null) {
				beforeColl = new HashMap();
				session.put(FwConstants.BEFORE_COLLECTION, beforeColl);
			}
			pageCollection.put(FwConstants.BEFORE_COLLECTION, pageCollection);
			beforeColl.putAll(pageCollection);
			componentManager.getComponents("AROBQ", txnBean);
			log(ILog.INFO,
					"RMCOtherIncomeEJBBean::loadOtherIncomeGatePostQuestions:End");

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("loadOtherBenefitsGatePostQuestions");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"loadOtherBenefitsGatePostQuestions", e);
			throw rmcOtherBenefitsEJBBean.rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.loadOtherBenefitsGatePostQuestions() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Store other benefits gate post questions.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 * @throws javax.ejb.EJBException the javax.ejb. ejb exception
	 */
	public void storeOtherBenefitsGatePostQuestions(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.storeOtherBenefitsGatePostQuestions() - START");

		try {
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::storeOtherBenefitsGatePostQuestions:Start");
			log(ILog.INFO,
					"RMCOtherIncomeEJBBean::storeOtherIncomeGatePostQuestions:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);
			final RMBRequestManager rmbRqstManager = new RMBRequestManager();
			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			// Get appNumber from the session
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			// get people handler from session
			final PeopleHandler peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);
			// get RMB_RQST_Collection from pageCollection
			final RMB_RQST_Collection pageRMBRqstColl = (RMB_RQST_Collection) pageCollection
					.get("RMB_RQST_Collection");
			RMB_RQST_Cargo pageRMBRqstCargo = null;
			// get session RMB_RQST_COlleaction
			/*
			 * VG SONAR Cleanup - 09/1/2015 Deleted 2 lines Commented Code in
			 * this block
			 */

			final RMB_RQST_Collection sessRMBRqstColl = (RMB_RQST_Collection) session
					.get(AppConstants.RMB_RQST_COLLECTION);
			final RMB_RQST_Cargo sessRMBRqstCargo = sessRMBRqstColl.getCargo(0);
			// get RMB_RQST_Cargo
			pageRMBRqstCargo = pageRMBRqstColl.getCargo(0);
			final int currentPageStaus = driverManager.getAFBStatus(
					FwConstants.RMC_DRIVER, "AROBQ", driverArray);
			// get component list for before collection to know which are all
			// the questions displayed on the JSP
			final List pageCpntList = (ArrayList) beforeColl
					.get(FwConstants.PAGE_COMPONENT_LIST);
			// now do the validation
			final AROBQValidator validationBO = new AROBQValidator();
			beforeColl.get(FwConstants.PAGE_COMPONENT_LIST);

			final String backToMyAccess = (String) request
					.get(AppConstants.BACK_TO_MY_ACCESS_BUTTON);
			boolean isMA = false;
			final short[] programKey = (short[]) session
					.get(FwConstants.RMC_PROGRAM_KEY);
			if (programKey != null) {
				if (programKey[AppConstants.PROGRAM_KEY_MA] == 1) {
					isMA = true;
				}
			}

			if (backToMyAccess == null) {
				validationBO
				.validateAROBQ(pageRMBRqstCargo, pageCpntList, isMA);
			}

			if (checkBackToMyAccessSelected(request) || validationBO != null
					&& validationBO.hasMessages()) {
				if (backToMyAccess == null) {
					request.put(FwConstants.MESSAGE_LIST,
							validationBO.getMessageList());
				}
				session.put(AppConstants.RMB_RQST_COLLECTION,
						session.get(AppConstants.RMB_RQST_COLLECTION));
				session.put(FwConstants.BEFORE_COLLECTION,
						session.get(FwConstants.BEFORE_COLLECTION));
				session.put(AppConstants.QUESTION_EXTRACTION_HANDLER,
						session.get(AppConstants.QUESTION_EXTRACTION_HANDLER));
				pageCollection.put("RMB_SCHLENRL_GATEPOST_LISTVIEW",
						beforeColl.get("RMB_SCHLENRL_GATEPOST_LISTVIEW"));
				pageCollection.put("RMB_MAPP_GATEPOST_LISTVIEW",
						beforeColl.get("RMB_MAPP_GATEPOST_LISTVIEW"));
				pageCollection.put("INDV_COLL", beforeColl.get("INDV_COLL"));
				pageCollection.put("APP_IN_MAPP_Collection",
						beforeColl.get("APP_IN_MAPP_Collection"));
				pageCollection.put("APP_IN_SCHLE_Collection",
						beforeColl.get("APP_IN_SCHLE_Collection"));
				pageCollection.put("RMB_RQST_PAGE_Collection",
						beforeColl.get("RMB_RQST_PAGE_Collection"));
				if (driverManager.getAFBStatus(FwConstants.RMC_DRIVER, "AROBQ",
						driverArray) == FwConstants.DRIVER_REQUIRED) {
					pageCollection
					.put("RADIO_OPTION_MAP",
							rmbRqstManager
							.getStatusForGatePostAfterValidation(
									AppConstants.RMB_OTHER_BENEFITS_GATE_POST_PAGE,
									pageRMBRqstColl));
				} else {
					final RMC_IN_PRFL_Collection sessRMCInPrflColl = (RMC_IN_PRFL_Collection) session
							.get(AppConstants.RMC_IN_PRFL_MASTER);
					// get session RMC_CHG_SEL_PRFL
					final SortedSet sessChgSelectionProfile = (SortedSet) session
							.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
					pageCollection
					.put("RADIO_OPTION_MAP",
							rmbRqstManager
							.getStatusForGatePost(
									AppConstants.RMB_OTHER_BENEFITS_GATE_POST_PAGE,
									sessRMBRqstColl,
									driverArray,
									sessRMCInPrflColl,
									sessChgSelectionProfile,
									peopleHandler));
				}

				componentManager.getComponents("AROBQ", txnBean);
				return;
			}
			// call request manager to get complete cargo
			pageRMBRqstCargo = rmbRqstManager.getCompleteCargo(
					sessRMBRqstCargo, pageRMBRqstCargo);
			// now call ischanged
			pageRMBRqstCargo = (RMB_RQST_Cargo) isChanged(sessRMBRqstCargo,
					pageRMBRqstCargo);
			if (currentPageStaus != FwConstants.DRIVER_REQUIRED) {
				rmbRqstManager.changeStatusOnGatePost(pageRMBRqstColl, session,
						AppConstants.RMB_OTHER_BENEFITS_GATE_POST_PAGE);
			}
			// check if collection is Dirty Update RMBRequest Table with user
			// response .
			if (pageRMBRqstCargo.isDirty()) {
				pageRMBRqstCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
				final RMB_RQST_Collection rMBRqstColl = new RMB_RQST_Collection();
				rMBRqstColl.add(pageRMBRqstCargo);
				rmbRqstManager.storeRMBRqst(rMBRqstColl);
				// put the update RMB_RQST_Collection into session
				session.put(AppConstants.RMB_RQST_COLLECTION, rMBRqstColl);
			}

			final int aAROBCPageStatus = driverManager.getAFBStatus(
					FwConstants.RMC_DRIVER, "AROBC", driverArray);
			/*
			 * VG SONAR Cleanup - 09/1/2015 Deleted 2 lines Commented Code in
			 * this block
			 */

			boolean aAROBCPageRequired = false;
			boolean aAROBCPageCompleted = false;

			if (FwConstants.YES.equals(pageRMBRqstCargo.getMed_cvrg_stat_ind())
					&& (FwConstants.NO.equals(sessRMBRqstCargo
							.getMed_cvrg_stat_ind()) || FwConstants.HIDDEN
							.equals(sessRMBRqstCargo.getMed_cvrg_stat_ind()))) {
				driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBC",
						driverArray, appNum);
				aAROBCPageRequired = true;
			} else if (FwConstants.YES.equals(pageRMBRqstCargo
					.getMed_cvrg_stat_ind())
					&& (aAROBCPageStatus == FwConstants.DRIVER_REQUIRED || aAROBCPageStatus == FwConstants.DRIVER_VISIT_AGAIN)) {
				aAROBCPageRequired = true;
			} else if (FwConstants.YES.equals(pageRMBRqstCargo
					.getMed_cvrg_stat_ind())
					&& aAROBCPageStatus == FwConstants.DRIVER_COMPLETE) {
				aAROBCPageCompleted = true;
			}
			/*
			 * VG SONAR Cleanup - 09/1/2015 Changed Commented code block to
			 * javadoc
			 */
			/**
			 * // PAST HEALTH COVERAGE - PCR# 43100 - CLA RENEWALS CHANGES /*
			 * if((pageRMBRqstCargo.getHealth_insurance_chg_stat_ind().equals(
			 * FwConstants.YES)) &&
			 * (sessRMBRqstCargo.getHealth_insurance_chg_stat_ind
			 * ().equals(FwConstants.NO) ||
			 * sessRMBRqstCargo.getHealth_insurance_chg_stat_ind
			 * ().equals(FwConstants.HIDDEN))){
			 * driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBC",
			 * driverArray, appNum); aAROBCPageRequired = true; }else
			 * if(pageRMBRqstCargo
			 * .getHealth_insurance_chg_stat_ind().equals(FwConstants.YES) &&
			 * (aAROBCPageStatus == FwConstants.DRIVER_REQUIRED ||
			 * aAROBCPageStatus == FwConstants.DRIVER_VISIT_AGAIN)) {
			 * aAROBCPageRequired = true; }else
			 * if(pageRMBRqstCargo.getHealth_insurance_chg_stat_ind
			 * ().equals(FwConstants.YES) && (aAROBCPageStatus ==
			 * FwConstants.DRIVER_COMPLETE)) { aAROBCPageCompleted = true; }
			 */
			/**
			 * if((pageRMBRqstCargo.getTrb_cmdy_stat_ind().equals(FwConstants.
			 * YES )) &&
			 * (sessRMBRqstCargo.getTrb_cmdy_stat_ind().equals(FwConstants.NO)
			 * || sessRMBRqstCargo.getTrb_cmdy_stat_ind().equals(FwConstants.
			 * HIDDEN ))){ driverManager.makeRequired(FwConstants.RMC_DRIVER,
			 * "AROBI", driverArray, appNum); detailPageRequired = true; }else
			 * if(pageRMBRqstCargo
			 * .getTrb_cmdy_stat_ind().equals(FwConstants.YES) &&
			 * (aAROBIPageStatus == FwConstants.DRIVER_REQUIRED ||
			 * aAROBIPageStatus == FwConstants.DRIVER_VISIT_AGAIN)) {
			 * detailPageRequired = true; } else
			 * if(pageRMBRqstCargo.getTrb_cmdy_stat_ind
			 * ().equals(FwConstants.YES) && (aAROBIPageStatus ==
			 * FwConstants.DRIVER_COMPLETE)) { interGPageComplete = true; }
			 */

			// personal information change
			if (FwConstants.YES
					.equals(pageRMBRqstCargo.getSchl_enrl_stat_ind())
					&& (FwConstants.NO.equals(sessRMBRqstCargo
							.getSchl_enrl_stat_ind()) || FwConstants.HIDDEN
							.equals(sessRMBRqstCargo.getSchl_enrl_stat_ind()))) {
				driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBC",
						driverArray, appNum);
				aAROBCPageRequired = true;
			} else if (FwConstants.YES.equals(pageRMBRqstCargo
					.getSchl_enrl_stat_ind())
					&& (aAROBCPageStatus == FwConstants.DRIVER_REQUIRED || aAROBCPageStatus == FwConstants.DRIVER_VISIT_AGAIN)) {
				aAROBCPageRequired = true;
			} else if (FwConstants.YES.equals(pageRMBRqstCargo
					.getSchl_enrl_stat_ind())
					&& aAROBCPageStatus == FwConstants.DRIVER_COMPLETE) {
				aAROBCPageCompleted = true;
			}
			/*
			 * VG SONAR Cleanup - 09/1/2015 Changed Commented code block to
			 * javadoc
			 */
			// pregnancy change
			/**
			 * if((pageRMBRqstCargo.getMapp_stat_ind().equals(FwConstants.YES))
			 * && (sessRMBRqstCargo.getMapp_stat_ind().equals(FwConstants.NO) ||
			 * sessRMBRqstCargo.getMapp_stat_ind().equals(FwConstants.HIDDEN))){
			 * driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBC",
			 * driverArray, appNum); aAROBCPageRequired = true; }else
			 * if(pageRMBRqstCargo.getMapp_stat_ind().equals(FwConstants.YES) &&
			 * (aAROBCPageStatus == FwConstants.DRIVER_REQUIRED ||
			 * aAROBCPageStatus == FwConstants.DRIVER_VISIT_AGAIN)) {
			 * aAROBCPageRequired = true; }else
			 * if(pageRMBRqstCargo.getMapp_stat_ind().equals(FwConstants.YES) &&
			 * (aAROBCPageStatus == FwConstants.DRIVER_COMPLETE)) {
			 * aAROBCPageCompleted = true; }
			 */

			/**
			 * if(!detailPageRequired ){ if (!interGPageComplete)
			 * driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
			 * "AROBI", driverArray, appNum); }else {
			 * driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBI",
			 * driverArray, appNum); }
			 */

			if (!aAROBCPageRequired) {
				if (!aAROBCPageCompleted) {
					driverManager.makeAbsoluteNotRequired(
							FwConstants.RMC_DRIVER, "AROBC", driverArray,
							appNum);
				}
			} else {
				driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBC",
						driverArray, appNum);
			}

			driverManager.makeComplete(FwConstants.RMC_DRIVER, "AROBQ",
					driverArray, appNum);

			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::storeOtherBenefitsGatePostQuestions:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("storeOtherBenefitsGatePostQuestions");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"storeOtherBenefitsGatePostQuestions", e);
			throw rmcOtherBenefitsEJBBean.rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.storeOtherBenefitsGatePostQuestions() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Load other benefits intermediate questions.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 * @throws javax.ejb.EJBException the javax.ejb. ejb exception
	 */
	public void loadOtherBenefitsIntermediateQuestions(
			final FwTransaction txnBean) throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.loadOtherBenefitsIntermediateQuestions() - START");

		try {
			log(ILog.INFO,
					"RMCLiquidAndOtherAssetsEJBBean::loadOtherBenefitsIntermediateQuestions:Start");

			final Map session = txnBean.getSession();
			final Map pageCollection = txnBean.getPageCollection();
			final Map request = txnBean.getRequest();
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			final PeopleHandler peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);
			/*
			 * VG SONAR Cleanup - 09/1/2015 Deleted 1 lines Commented Code in
			 * this block
			 */

			final INDIVIDUAL_Custom_Collection indvColl = peopleHandler
					.getInHomeIndividuals();
			final Map httpSessMap = (Map) session.get(FwConstants.HTTP_SESSION);
			httpSessMap.get(FwConstants.LANGUAGE);
			final RMBRequestManager rmbRequestManager = new RMBRequestManager();


			// Getting RMC_IN_PROFILE from session
			final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			RMB_RQST_Collection rmbPageColl = (RMB_RQST_Collection) session
					.get("RMB_RQST_COLLECTION");
			if (rmbPageColl == null) {
				rmbPageColl = new RMB_RQST_Collection();
				rmbPageColl.add(rmbRequestManager.loadRMBRequest(appNum));
			}
			final RMB_RQST_Cargo rmbCargo = rmbPageColl.getCargo(0);

			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			final int driverStatus = driverManager.getAFBStatus(
					FwConstants.RMC_DRIVER,
					(String) request.get(FwConstants.CURRENT_PAGE_ID),
					driverArray);

			// get health insurance details

			final HealthCareCoverageBO healthBO = new HealthCareCoverageBO();

			final APP_MED_INS_Collection healthCvrgDtl = healthBO
					.loadAppMedInsForPE(appNum);

			SortedSet selectionProfile = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			boolean loadCatSelProfile = false;

			if ((selectionProfile == null || selectionProfile.isEmpty())
					&& driverStatus != FwConstants.DRIVER_NOT_REQUIRED) {
				// load selection profile form the data base
				loadCatSelProfile = true;
			} else if (selectionProfile != null && !selectionProfile.isEmpty()) {
				// here we need to check the session profile is housing/utility
				// session profile
				CategorySequenceDetail catSeqDetail = categorySelectionProfileManager
						.getCurrentSequenceDetail(selectionProfile);
				if (catSeqDetail == null) {
					catSeqDetail = categorySelectionProfileManager
							.getNextSequenceDetail(selectionProfile);
					/*
					 * VG SONAR Cleanup - 09/1/2015 Deleted 4 lines Commented
					 * Code in this block
					 */

					if (catSeqDetail != null
							&& AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL
							.equals(catSeqDetail
									.getChangeSelectionCategoryCd())) {
						loadCatSelProfile = false;
					} else {
						loadCatSelProfile = true;
					}
				}
			}

			// now loading the cat selection profile from the data base
			if (loadCatSelProfile) {
				final String categoryCodes = "'"
						+ AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL + "'";

				selectionProfile = categorySelectionProfileManager
						.loadCategoryChangeSelectionProfileByCategoryCds(
								appNum, categoryCodes);
				session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER,
						selectionProfile);
			}

			final List healthList = new ArrayList();
			healthList.add(healthCvrgDtl);
			healthList.add(indvColl);
			healthList.add(rmcInPrflColl);
			healthList.add(rmbCargo);
			healthList.add(selectionProfile);
			/*
			 * VG SONAR Cleanup - 09/1/2015 Changed Commented code block to
			 * javadoc
			 */
			/**
			 * // RMBHealthCvrgSelectionListView rmcHlthCvrgSelectionListView =
			 * new RMBHealthCvrgSelectionListView(); // // Preparing listView
			 * for regular job //
			 * rmcHlthCvrgSelectionListView.setLanguage(language); // //
			 * rmcliquidAssetSelectionListView.setJsEnabled(jsEnabled); //
			 * rmcHlthCvrgSelectionListView.setName("HEALTHCVRG"); //
			 * rmcHlthCvrgSelectionListView.setCollection(indvSortedCustColl);
			 * // rmcHlthCvrgSelectionListView.setDisplayData(healthList); //
			 * rmcHlthCvrgSelectionListView.setPageSize(1000); //
			 * pageCollection.put("HEALTHCVRG", rmcHlthCvrgSelectionListView);
			 * // pageCollection.put("HEALTHCVRG_COLL", healthCvrgDtl);
			 *
			 */

			final Map newAssetMap = new HashMap();
			pageCollection.put("NEW_ASSET_MAP", newAssetMap);
			pageCollection.put("RMB_RQST_Collection", rmbPageColl);
			session.put(FwConstants.BEFORE_COLLECTION, pageCollection);

			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::loadOtherBenefitsIntermediateQuestions:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("loadOtherBenefitsIntermediateQuestions");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"loadOtherBenefitsIntermediateQuestions", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.loadOtherBenefitsIntermediateQuestions() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Store other benefits intermediate questions.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 * @throws javax.ejb.EJBException the javax.ejb. ejb exception
	 */
	public void storeOtherBenefitsIntermediateQuestions(
			final FwTransaction txnBean) throws javax.ejb.EJBException {
		try {
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::storeOtherBenefitsIntermediateQuestions:Start");

			final long startTime = System.currentTimeMillis();
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean.storeOtherBenefitsIntermediateQuestions() - START");

			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);
			request.get(FwConstants.CURRENT_PAGE_ID);
			final RMBRequestManager rmbRequestManager = new RMBRequestManager();

			final RMC_RESPONSE_Custom_Collection respColl = (RMC_RESPONSE_Custom_Collection) pageCollection
					.get("RMC_RESPONSE_Custom_Collection");
			// Get App Number
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			final HealthCareCoverageBO healthCvrgBo = new HealthCareCoverageBO();

			healthCvrgBo.formatResponse(respColl);

			RMB_RQST_Collection rmbRqstPageColl = (RMB_RQST_Collection) pageCollection
					.get("RMB_RQST_Collection");

			if (rmbRqstPageColl == null) {
				rmbRqstPageColl = new RMB_RQST_Collection();
				rmbRqstPageColl.add(rmbRequestManager.loadRMBRequest(appNum));
			}

			final RMB_RQST_Cargo rmbRqstCargo = rmbRqstPageColl.getCargo(0);

			final PeopleHandler peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);
			final INDIVIDUAL_Custom_Collection indvColl = peopleHandler
					.getInHomeIndividuals();
			final int indvSize = indvColl.size();
			final Map indvNameMap = new HashMap();
			for (int i = 0; i < indvSize; i++) {
				final INDIVIDUAL_Custom_Cargo indvCargo = (INDIVIDUAL_Custom_Cargo) indvColl
						.get(i);
				indvNameMap.put(indvCargo.getIndv_seq_num(),
						indvCargo.getFst_nam());
			}

			final Map assetCollMap = new HashMap();
			assetCollMap.put("HEALTHCVRG", beforeColl.get("HEALTHCVRG_COLL"));

			assetCollMap.put("INDV_COLL", indvColl);

			final short[] responseArray = new short[] { IRMCResponseProfileManager.HEALTHCARE_COVERAGE

			};

			// build category selection profile
			SortedSet categorySelectionProfile = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			// Getting RMC_IN_PROFILE from session
			RMC_IN_PRFL_Collection rmcInPrflSessColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			// if empl seq is "A" then set to empty string

			RMC_RESPONSE_Custom_Cargo rmcCustomCargo = null;
			int size = respColl.size();
			RMC_IN_PRFL_Collection rmcPrflPageColl = null;
			RMC_IN_PRFL_Cargo rmcPrflSessCargo = null;
			RMC_IN_PRFL_Cargo rmcPrflPageCargo = null;
			String seqNum = null;
			String catType = null;
			String indvSeqNum = null;
			boolean healthCvrgChanged = false;
			if (respColl != null && !respColl.isEmpty()) {
				for (int i = 0; i < respColl.size(); i++) {
					final RMC_RESPONSE_Custom_Cargo cargo = respColl
							.getCargo(i);
					if (cargo != null && cargo.getCategoryType() != null) {
						final Map hlthMap = new HashMap();

						hlthMap.put(AppConstants.HEALTHCARE_COVERAGE,
								AppConstants.HEALTHCARE_COVERAGE);

						if (hlthMap.containsKey(cargo.getCategoryType())) {
							if (!"2".equals(cargo.getUserEndSelectionInd())) {
								healthCvrgChanged = true;
							}

						}

					}
				}
			}

			for (int i = 0; i < size; i++) {

				rmcCustomCargo = respColl.getCargo(i);
				seqNum = rmcCustomCargo.getSeqNum();
				catType = rmcCustomCargo.getCategoryType();

				indvSeqNum = rmcCustomCargo.getIndvSeqNum();
				if (AppConstants.RMC_ADD_NEW_IND.equals(seqNum)) {
					// this one is for the page collection
					if (rmcPrflPageColl != null) {
						rmcPrflPageCargo = rmcResponseProfileManager
								.getProfile(rmcPrflPageColl, indvSeqNum);
					} else {
						rmcPrflPageColl = new RMC_IN_PRFL_Collection();
					}
					if (rmcPrflPageCargo == null) {
						rmcPrflPageCargo = new RMC_IN_PRFL_Cargo();
						rmcPrflPageCargo.setApp_num(appNum);
						rmcPrflPageCargo.setIndv_seq_num(indvSeqNum);
						rmcPrflPageColl.addCargo(rmcPrflPageCargo);
					}
					// this one is for the session collection
					if (rmcInPrflSessColl != null) {
						rmcPrflSessCargo = rmcResponseProfileManager
								.getProfile(rmcInPrflSessColl, indvSeqNum);
					} else {
						rmcInPrflSessColl = new RMC_IN_PRFL_Collection();
					}
					if (rmcPrflSessCargo == null) {
						rmcPrflSessCargo = new RMC_IN_PRFL_Cargo();
						rmcPrflSessCargo.setApp_num(appNum);
						rmcPrflSessCargo.setIndv_seq_num(indvSeqNum);
						rmcResponseProfileManager
						.createRMCIndividualProfile(rmcPrflSessCargo);
						rmcInPrflSessColl.addCargo(rmcPrflSessCargo);
					}

					if (AppConstants.HEALTHCARE_COVERAGE.equals(catType)) {
						rmcPrflPageCargo.setHc_cvrg_resp(FwConstants.YES);
					}

					respColl.remove(i);
					size--;
					i--;
				}
			}
			session.put(AppConstants.RMC_IN_PRFL_MASTER, rmcInPrflSessColl);
			final String backToMyAccess = (String) request
					.get(AppConstants.BACK_TO_MY_ACCESS_BUTTON);
			final Map httpSessionMap = (Map) session
					.get(FwConstants.HTTP_SESSION);
			httpSessionMap.get(AppConstants.LANGUAGE);

			request.get(FwConstants.WARNING_MSG_DETAILS);
			FwMessageList msgList = null;

			if (backToMyAccess == null) {
				// Change selction validation.
				healthCvrgBo.validateHlthCvrgChangeSelection(respColl,
						assetCollMap);

			}

			if (healthCvrgBo.hasMessages()) {

				msgList = healthCvrgBo.getMessageList();

			}

			final boolean isWarningMessageShown = false;

			if (checkBackToMyAccessSelected(request) || msgList != null
					&& !isWarningMessageShown) {
				if (backToMyAccess == null) {
					request.put(FwConstants.MESSAGE_LIST, msgList);
				}

				// here i am calling the translate profile to trans late the
				// session values to the page collection
				if (rmcPrflPageColl != null) {
					rmcResponseProfileManager
					.translateProfileResponseAfterValidation(
							rmcPrflPageColl, rmcInPrflSessColl,
							responseArray);
				}
				if (respColl != null && !respColl.isEmpty()) {
					categorySelectionProfile = categorySelectionProfileManager
							.buildSelectionProfileAfterValidation(
									categorySelectionProfile, respColl);
				}

				/*
				 * VG SONAR Cleanup - 09/1/2015 Deleted 3,7 lines Commented Code
				 * in this block
				 */

				final APP_MED_INS_Collection hlthCvrgColl = (APP_MED_INS_Collection) beforeColl
						.get("HEALTHCVRG_COLL");

				final List hlthDataList = new ArrayList();
				hlthDataList.add(hlthCvrgColl);
				hlthDataList.add(indvColl);
				hlthDataList.add(rmcPrflPageColl);
				hlthDataList.add(rmbRqstCargo);
				hlthDataList.add(categorySelectionProfile);

				pageCollection.put("RMB_RQST_Collection",
						beforeColl.get("RMB_RQST_Collection"));
				return;
			}

			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			final int driverStatus = driverManager.getAFBStatus(
					FwConstants.RMC_DRIVER,
					(String) request.get(FwConstants.CURRENT_PAGE_ID),
					driverArray);

			boolean detailPageRequired = false;

			if (rmcInPrflSessColl != null) {
				if (rmcPrflPageColl == null) {
					rmcPrflPageColl = new RMC_IN_PRFL_Collection();
				}
				// populating missing app in profile collection into page
				// collection for enter key press
				rmcResponseProfileManager.preparePageColl(rmcPrflPageColl,
						rmcInPrflSessColl, responseArray);

				final int rmcInPrflSessCollectionSize = rmcInPrflSessColl
						.size();
				final int rmcInPrflPageCollectionSize = rmcPrflPageColl.size();
				RMC_IN_PRFL_Cargo rmcInPrflPageCargo = null;
				String[] translatedProfileArray = null;
				String indivSeqNum = null;

				final int[] hlthCvrgDetailDirtyIndicator = { IRMCResponseProfileManager.NOT_DIRTY };

				final Map indvResponseMap = new HashMap();
				final boolean[] dirtyIndicatorArray = new boolean[rmcResponseProfileManager
				                                                  .getMaxIndvSeqNumber(rmcInPrflSessColl) + 1];
				char status = IRMCResponseProfileManager.STATUS_NOT_REQUIRED;
				// Loop for each individual in session app indv profile
				for (int s = 0; s < rmcInPrflSessCollectionSize; s++) {

					final RMC_IN_PRFL_Cargo rmcInPrflSessCargo = rmcInPrflSessColl
							.getCargo(s);
					// Loop for each individual in page collection app indv
					// profile
					for (int p = 0; p < rmcInPrflPageCollectionSize; p++) {
						rmcInPrflPageCargo = rmcPrflPageColl.getCargo(p);
						// Picking up the matching individuals of session app
						// indv profile from page collection app indv profile
						if (rmcInPrflPageCargo.getIndv_seq_num().equals(
								rmcInPrflSessCargo.getIndv_seq_num())) {
							translatedProfileArray = new String[responseArray.length];
							indivSeqNum = rmcInPrflPageCargo.getIndv_seq_num();
							// Checking for any changes in the page since load
							// Liquid asset other response
							if (rmcResponseProfileManager.determineDirtyStatus(
									rmcInPrflPageCargo.getHc_cvrg_resp(),
									rmcInPrflSessCargo.getHc_cvrg_resp(),
									hlthCvrgDetailDirtyIndicator, driverStatus)) {
								if (!dirtyIndicatorArray[0]) {
									dirtyIndicatorArray[0] = true;
								}
								dirtyIndicatorArray[Integer
								                    .parseInt(indivSeqNum)] = true;

							}

							if (!rmcInPrflSessCargo
									.getHc_cvrg_resp()
									.equalsIgnoreCase(
											String.valueOf(ICategorySelectionProfileManager.STATUS_COMPLETE))) {
								rmcResponseProfileManager
								.translateProfileResponses(
										rmcInPrflPageCargo
										.getHc_cvrg_resp(),
										rmcInPrflSessCargo
										.getHc_cvrg_resp(),
										driverStatus,
										IRMCResponseProfileManager.HEALTHCARE_COVERAGE,
										rmcInPrflSessCargo);
							}
							translatedProfileArray[0] = rmcInPrflSessCargo
									.getHc_cvrg_resp();
							status = (null != rmcInPrflSessCargo
									.getHc_cvrg_resp()) ? (rmcInPrflSessCargo
									.getHc_cvrg_resp().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
							if (status == IRMCResponseProfileManager.STATUS_ADD_NEW
									|| status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
									|| status == IRMCResponseProfileManager.STATUS_REQUIRED) {
								detailPageRequired = true;
								driverManager.makeRequired(
										FwConstants.RMC_DRIVER, "ARHCD",
										driverArray, appNum);
							}

							if (!IDriver.DRIVER_STATUS_COMPLETE
									.equals(driverManager.getStatus(
											FwConstants.RMC_DRIVER, "ARHCD",
											driverArray))) {
								driverManager.makeAbsoluteNotRequired(
										FwConstants.RMC_DRIVER, "ARHCD",
										driverArray, appNum);
							} else {
								driverManager.makeComplete(
										FwConstants.RMC_DRIVER, "ARHCD",
										driverArray, appNum);
							}

							indvResponseMap.put(indivSeqNum,
									translatedProfileArray);
							// breaking to pick the next matching individual
							// from session app indv profile
							break;
						}
					}
				}
				// Persistence logic start
				if (dirtyIndicatorArray[0]) {
					String indvSeqNumber = null;
					for (int i = 0; i < rmcInPrflPageCollectionSize; i++) {
						indvSeqNumber = rmcPrflPageColl.getCargo(i)
								.getIndv_seq_num();
						// Changed indvSeqNum to indvSeqNumber
						if (dirtyIndicatorArray[Integer.parseInt(indvSeqNumber)]) {
							rmcResponseProfileManager.persist(appNum,
									indvSeqNumber, responseArray,
									(String[]) indvResponseMap
									.get(indvSeqNumber));
						}
					}
				}
			}

			if (categorySelectionProfile == null
					|| categorySelectionProfile.isEmpty()) {
				// This method will build profile for all the 6 assets types
				categorySelectionProfile = categorySelectionProfileManager
						.buildSelectionProfile(respColl, appNum,
								AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL);
			} else {

				// Here we rebuild the profile for each asset types
				/*
				 * VG SONAR Cleanup - 09/1/2015 Deleted 4,3 lines Commented Code
				 * in this block
				 */

				categorySelectionProfileManager.rebuildSelectionProfile(
						categorySelectionProfile, respColl, appNum,
						AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL);

			}

			final Map hlthCvrgMap = new HashMap();
			hlthCvrgMap.put("HI", "HI");
			if (detailPageRequired
					|| !categorySelectionProfileManager
					.areAllSequencesComplete(categorySelectionProfile,
							hlthCvrgMap) && healthCvrgChanged) {
				driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARHCD",
						driverArray, appNum);
			} else {
				driverManager.makeComplete(FwConstants.RMC_DRIVER, "ARHCD",
						driverArray, appNum);
			}

			driverManager.makeComplete(FwConstants.RMC_DRIVER, "AROBI",
					driverArray, appNum);
			// Store values in session
			session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER,
					categorySelectionProfile);
			session.put(FwConstants.BEFORE_COLLECTION,
					txnBean.getPageCollection());
			session.put(FwConstants.RMC_DRIVER, driverArray);
			pageCollection.put("RMB_RQST_Collection", rmbRqstPageColl);
			txnBean.setSession(session);

			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::storeOtherBenefitsIntermediateQuestions:End");
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean.storeOtherBenefitsIntermediateQuestions() - END , Time Taken : "
							+ (System.currentTimeMillis() - startTime)
							+ " milliseconds");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("storeAssetChangeSelection");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"storeOtherBenefitsIntermediateQuestions", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

	}

	/**
	 * Load other benefits change selection.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 * @throws javax.ejb.EJBException the javax.ejb. ejb exception
	 */
	public void loadOtherBenefitsChangeSelection(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.loadOtherBenefitsChangeSelection() - START");
		try {
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::loadOtherBenefitsChangeSelection:Start");

			final Map session = txnBean.getSession();
			final Map pageCollection = txnBean.getPageCollection();
			final Map request = txnBean.getRequest();
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			final PeopleHandler peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);
			/*
			 * VG SONAR Cleanup - 09/1/2015 Deleted 2 lines Commented Code in
			 * this block
			 */
			//Migrant farm worker implementation
			APP_INDV_ADDI_INFO_Collection addiInfoColl = null;
			final ABHouseHoldMemberBO hmbo = new ABHouseHoldMemberBO();
			// Get Migrant Farm Worker reponses
			addiInfoColl = hmbo.getMigFarmWrkrDtl(appNum);
			//Colleting Migrant Farm worker details in Case level, To pre populate if we have details.
			pageCollection.put("APP_INDV_ADDI_INFO_Collection", addiInfoColl);
						
			final INDIVIDUAL_Custom_Collection indvColl = peopleHandler
					.getInHomeIndividuals();

			final Map httpSessMap = (Map) session.get(FwConstants.HTTP_SESSION);
			final String language = (String) httpSessMap
					.get(FwConstants.LANGUAGE);
			String jsEnabled = FwConstants.NO;
			jsEnabled = (String) httpSessMap.get(FwConstants.JS_ENABLED);
			final INDIVIDUAL_Custom_Collection indvSortedCustColl = null;
			List dataList = new ArrayList();
			final RMBRequestManager rmbRequestManager = new RMBRequestManager();
			// Getting RMC_IN_PROFILE from session
			final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			final String applicationType = (String) session
					.get(FwConstants.ACCESS_APPLICATION_TYPE);
			final char appType = applicationType.charAt(0);
			RMB_RQST_Cargo rmbCargo = null;
			RMB_RQST_Collection rmbPageColl = (RMB_RQST_Collection) session
					.get("RMB_RQST_COLLECTION");
			if (appType != FwConstants.RMC_APP_TYPE) {

				if (rmbPageColl == null) {
					rmbPageColl = new RMB_RQST_Collection();
					rmbPageColl.add(rmbRequestManager.loadRMBRequest(appNum));
				}
				rmbCargo = rmbPageColl.getCargo(0);
			}

			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			final int driverStatus = driverManager.getAFBStatus(
					FwConstants.RMC_DRIVER,
					(String) request.get(FwConstants.CURRENT_PAGE_ID),
					driverArray);
			final SchoolEnrollmentBO schEnrlBO = new SchoolEnrollmentBO();
			final APP_IN_SCHLE_Collection schlEnrlColl = schEnrlBO
					.getSchoolEnrlDetailsForChangeSelection(appNum);
			final ABHouseHoldMemberBO abHouseholdMemberBo = new ABHouseHoldMemberBO();
			abHouseholdMemberBo.loadHospitalStayDetails(appNum);

			final HealthCareCoverageBO healthBO = new HealthCareCoverageBO();

			final APP_MED_INS_Collection healthCvrgDtl = healthBO
					.loadAppMedInsForPE(appNum);

			SortedSet selectionProfile = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			boolean loadCatSelProfile = false;

			if ((selectionProfile == null || selectionProfile.isEmpty())
					&& driverStatus != FwConstants.DRIVER_NOT_REQUIRED) {
				loadCatSelProfile = true;
			} else if (selectionProfile != null && !selectionProfile.isEmpty()) {
				CategorySequenceDetail catSeqDetail = categorySelectionProfileManager
						.getCurrentSequenceDetail(selectionProfile);
				if (catSeqDetail == null) {
					catSeqDetail = categorySelectionProfileManager
							.getNextSequenceDetail(selectionProfile);
					if (catSeqDetail != null
							&& AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL
							.equals(catSeqDetail
									.getChangeSelectionCategoryCd())) {
						loadCatSelProfile = false;
					} else {
						loadCatSelProfile = true;
					}
				}
			}

			if (loadCatSelProfile) {
				final String catategoryCodes = AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL;

				selectionProfile = categorySelectionProfileManager
						.loadCategoryChangeSelectionProfile(appNum,
								catategoryCodes);
				session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER,
						selectionProfile);
			}

			dataList.add(schlEnrlColl);
			dataList.add(indvColl);
			dataList.add(rmcInPrflColl);
			dataList.add(selectionProfile);
			dataList.add(driverStatus);

			final RMBSchoolEnrlChangeSelectionListView rmcScholEnrlChangeSelectionListView = new RMBSchoolEnrlChangeSelectionListView();
			rmcScholEnrlChangeSelectionListView.setLanguage(language);
			rmcScholEnrlChangeSelectionListView.setName("SCHOOL_ENRL_LISTVIEW");
			rmcScholEnrlChangeSelectionListView.setCollection(indvColl);
			rmcScholEnrlChangeSelectionListView.setDisplayData(dataList);
			rmcScholEnrlChangeSelectionListView.setPageSize(1000);
			pageCollection.put("SCHOOL_ENRL_LISTVIEW",
					rmcScholEnrlChangeSelectionListView);
			pageCollection.put("APP_IN_SCHLE_Collection", schlEnrlColl);

			// HOSP_STAY_LISTVIEW

			final List housStayList = new ArrayList();
			final ABHouseHoldMemberBO aBHouseHoldMemberBO = new ABHouseHoldMemberBO();
			final CP_APP_IN_CARE_PROV_Collection nursinHomeColl = aBHouseHoldMemberBO
					.loadNursingcareDetailsRmc(appNum);
			housStayList.add(nursinHomeColl);
			housStayList.add(indvColl);
			housStayList.add(rmcInPrflColl);
			housStayList.add(rmbCargo);
			housStayList.add(selectionProfile);
			housStayList.add(driverStatus);
			final RMCHospitalStayListView rmcHospitalStayListView = new RMCHospitalStayListView();
			rmcHospitalStayListView.setLanguage(language);
			rmcHospitalStayListView.setName("HOSPITALSTAY");
			rmcHospitalStayListView.setCollection(indvColl);
			rmcHospitalStayListView.setDisplayData(housStayList);
			rmcHospitalStayListView.setPageSize(1000);
			pageCollection.put("HOSPITALSTAY", rmcHospitalStayListView);
			pageCollection.put("APP_IN_CARE_PROV_Collection", nursinHomeColl);

			/*
			 * VG SONAR Cleanup - 09/1/2015 Changed Commented code block to
			 * javadoc
			 */
			/**
			 * // if (appType != FwConstants.RMC_APP_TYPE) {
			 */

			final List healthList = new ArrayList();
			healthList.add(healthCvrgDtl);
			healthList.add(indvColl);
			healthList.add(rmcInPrflColl);
			healthList.add(rmbCargo);
			healthList.add(selectionProfile);
			healthList.add(driverStatus);

			/**
			 * /*RMBHealthCvrgSelectionListView rmcHlthCvrgSelectionListView =
			 * new RMBHealthCvrgSelectionListView(); // Preparing listView for
			 * regular job rmcHlthCvrgSelectionListView.setLanguage(language);
			 * // rmcliquidAssetSelectionListView.setJsEnabled(jsEnabled);
			 * rmcHlthCvrgSelectionListView.setName("HEALTHCVRG");
			 * rmcHlthCvrgSelectionListView.setCollection(indvSortedCustColl);
			 * rmcHlthCvrgSelectionListView.setDisplayData(healthList);
			 * rmcHlthCvrgSelectionListView.setPageSize(1000);
			 * pageCollection.put("HEALTHCVRG", rmcHlthCvrgSelectionListView);
			 * pageCollection.put("HEALTHCVRG_COLL", healthCvrgDtl);*=/ // } //
			 * Nursing Home Starts here
			 *
			 */

			final List nurHomeList = new ArrayList();
			nurHomeList.add(nursinHomeColl);
			nurHomeList.add(indvColl);
			nurHomeList.add(rmcInPrflColl);
			nurHomeList.add(rmbCargo);
			nurHomeList.add(selectionProfile);
			nurHomeList.add(driverStatus);
			final RMCNursingHomeListView rMCNursingHomeListView = new RMCNursingHomeListView();

			rMCNursingHomeListView.setLanguage(language);
			rMCNursingHomeListView.setName("NURSINGHOME");
			rMCNursingHomeListView.setCollection(indvColl);
			rMCNursingHomeListView.setDisplayData(nurHomeList);
			rMCNursingHomeListView.setPageSize(1000);
			pageCollection.put("NURSINGHOME", rMCNursingHomeListView);
			pageCollection
			.put("CP_APP_IN_CARE_PROV_Collection", nursinHomeColl);
			// Nursing Home Ends here
			// Hospice Starts here
			final List hosPiceList = new ArrayList();
			hosPiceList.add(nursinHomeColl);
			hosPiceList.add(indvColl);
			hosPiceList.add(rmcInPrflColl);
			hosPiceList.add(rmbCargo);
			hosPiceList.add(selectionProfile);
			hosPiceList.add(driverStatus);

			final RMCHosPiceListView rMCHosPiceListView = new RMCHosPiceListView();
			rMCHosPiceListView.setLanguage(language);
			rMCHosPiceListView.setName("HOSPICELISTVIEW");
			rMCHosPiceListView.setCollection(indvColl);
			rMCHosPiceListView.setDisplayData(hosPiceList);
			rMCHosPiceListView.setPageSize(1000);
			pageCollection.put("HOSPICELISTVIEW", rMCHosPiceListView);
			pageCollection
			.put("CP_APP_IN_CARE_PROV_Collection", nursinHomeColl);

			// Hospice Ends here

			// Medicare Starts here
			final MedicareBO medicareBO = new MedicareBO();
			final APP_IN_MEDCR_Collection mediCareColl = medicareBO
					.loadMedicareDetails(appNum);
			final List mediCareList = new ArrayList();
			mediCareList.add(mediCareColl);
			mediCareList.add(indvColl);
			mediCareList.add(selectionProfile);
			mediCareList.add(rmcInPrflColl);
			mediCareList.add(driverStatus);
			final RMBMedicareExpIndvSelectionListView rmbMedicareExpSelectionListView = new RMBMedicareExpIndvSelectionListView();
			rmbMedicareExpSelectionListView.setLanguage(language);
			rmbMedicareExpSelectionListView.setName("MEDICARELISTVIEW");
			rmbMedicareExpSelectionListView.setCollection(indvColl);
			rmbMedicareExpSelectionListView.setDisplayData(mediCareList);
			rmbMedicareExpSelectionListView.setPageSize(1000);
			pageCollection.put("MEDICARELISTVIEW",
					rmbMedicareExpSelectionListView);
			pageCollection.put("APP_IN_MEDCR_Collection", mediCareColl);

			// Medicare ends here

			// Health Insurance
			final APP_IN_HLTH_INS_BNFTS_Collection hlthInsColl = medicareBO
					.loadHealthInsDetails(appNum);
			final List hlthInsList = new ArrayList();
			hlthInsList.add(hlthInsColl);
			hlthInsList.add(indvColl);
			hlthInsList.add(selectionProfile);
			hlthInsList.add(rmcInPrflColl);
			hlthInsList.add(driverStatus);
			final RMBHealthInsIndvSelectionListView rmbHealthInsSelectionListView = new RMBHealthInsIndvSelectionListView();
			rmbHealthInsSelectionListView.setLanguage(language);
			rmbHealthInsSelectionListView.setName("HEALTHINSLISTVIEW");
			rmbHealthInsSelectionListView.setCollection(indvColl);
			rmbHealthInsSelectionListView.setDisplayData(hlthInsList);
			rmbHealthInsSelectionListView.setPageSize(1000);
			pageCollection.put("HEALTHINSLISTVIEW",
					rmbHealthInsSelectionListView);
			pageCollection.put("APP_IN_HLTH_INS_BNFTS_Collection", hlthInsColl);

			// Medicare ends here
			// OutState Starts here
			final APP_IN_OUT_ST_BNFT_Collection outStateBnftColl = aBHouseHoldMemberBO
					.loadOutStateDetailsWithAppNum(appNum);
			final List outStateList = new ArrayList();
			outStateList.add(outStateBnftColl);
			outStateList.add(indvColl);
			outStateList.add(selectionProfile);
			outStateList.add(rmcInPrflColl);
			outStateList.add(driverStatus);
			final RMCOutStateBenefitsListView rMCOutStateBenefitsListView = new RMCOutStateBenefitsListView();
			rMCOutStateBenefitsListView.setLanguage(language);
			rMCOutStateBenefitsListView.setName("OUTSTATELISTVIEW");
			rMCOutStateBenefitsListView.setCollection(indvColl);
			rMCOutStateBenefitsListView.setDisplayData(outStateList);
			rMCOutStateBenefitsListView.setPageSize(1000);
			pageCollection.put("OUTSTATELISTVIEW", rMCOutStateBenefitsListView);
			pageCollection.put("APP_IN_OUT_ST_BNFT_Collection",
					outStateBnftColl);
			// Out state Ends here
			/* Lost Health Insurance */

			final CP_APP_IN_LST_HLTH_INS_Collection loadLostHealthColl = aBHouseHoldMemberBO
					.loadLostHealthDetailsWithAppNum(appNum);
			final List lostHealthList = new ArrayList();
			lostHealthList.add(loadLostHealthColl);
			lostHealthList.add(indvColl);
			lostHealthList.add(selectionProfile);
			lostHealthList.add(rmcInPrflColl);
			lostHealthList.add(driverStatus);
			final RMBLostHealthInsuranceSelectionListView rMCLostHealthListView = new RMBLostHealthInsuranceSelectionListView();
			rMCLostHealthListView.setLanguage(language);
			rMCLostHealthListView.setName("LOSTHEALTHINSLISTVIEW");
			rMCLostHealthListView.setCollection(indvColl);
			rMCLostHealthListView.setDisplayData(lostHealthList);
			rMCLostHealthListView.setPageSize(1000);
			pageCollection.put("LOSTHEALTHINSLISTVIEW", rMCLostHealthListView);
			pageCollection.put("CP_APP_IN_LST_HLTH_INS_Collection",
					loadLostHealthColl);

			dataList = null;
			dataList = new ArrayList();

			/*
			 * VG SONAR Cleanup - 09/1/2015 Deleted 1,1,1,1,2 lines Commented
			 * Code in this block
			 */

			dataList.add(indvColl);
			dataList.add(rmcInPrflColl);
			dataList.add(selectionProfile);

			dataList.add(peopleHandler);

			final RMBMappChangeSelectionListView rmcVehicleAssetSelectionListView = new RMBMappChangeSelectionListView();
			// Preparing listView for regular job
			rmcVehicleAssetSelectionListView.setLanguage(language);

			rmcVehicleAssetSelectionListView.setName("MAPP_LISTVIEW");
			rmcVehicleAssetSelectionListView.setCollection(indvSortedCustColl);
			// EDSP AI

			rmcVehicleAssetSelectionListView.setPageSize(1000);
			pageCollection.put("MAPP_LISTVIEW",
					rmcVehicleAssetSelectionListView);
			// EDSP AI

			// Special Needs

			// convicted felon
			final APP_IN_FELON_DET_Collection felnColl = abHouseholdMemberBo
					.loadConvictionDetails(appNum);

			final List felnList = new ArrayList();
			felnList.add(felnColl);
			felnList.add(indvColl);
			felnList.add(selectionProfile);
			felnList.add(rmcInPrflColl);
			felnList.add(driverStatus);

			final RMCConvictionSelectionListView rmcCvtnSelectionListView = new RMCConvictionSelectionListView();
			// Preparing listView for regular job
			rmcCvtnSelectionListView.setLanguage(language);
			rmcCvtnSelectionListView.setJsEnabled(jsEnabled);
			rmcCvtnSelectionListView.setName("CNVTN_SELECTION_LISTVIEW");
			rmcCvtnSelectionListView.setCollection(indvColl);
			rmcCvtnSelectionListView.setDisplayData(felnList);
			rmcCvtnSelectionListView.setPageSize(1000);
			
			

			pageCollection.put("CNVTN_SELECTION_LISTVIEW",
					rmcCvtnSelectionListView);
			pageCollection.put("CNVTN_COLL", felnColl);
			
			final APP_IN_BNFT_CNVCTN_Collection bnftCnvtColl = abHouseholdMemberBo.loadBenefitConvictionDetails(appNum);
			final List bnftCnvtList = new ArrayList();
			bnftCnvtList.add(bnftCnvtColl);
			bnftCnvtList.add(indvColl);
			bnftCnvtList.add(selectionProfile);
			bnftCnvtList.add(rmcInPrflColl);
			bnftCnvtList.add(driverStatus);
			
			final RMCTSBConvictionSelectionListView rmcTsbConvictionSelectionListView = new RMCTSBConvictionSelectionListView();
			rmcTsbConvictionSelectionListView.setLanguage(language);
			rmcTsbConvictionSelectionListView.setJsEnabled(jsEnabled);
			rmcTsbConvictionSelectionListView.setName("TSBCNVCTN_SELECTION_LISTVIEW");
			rmcTsbConvictionSelectionListView.setCollection(indvColl);
			rmcTsbConvictionSelectionListView.setDisplayData(bnftCnvtList);
			rmcTsbConvictionSelectionListView.setPageSize(1000);
			
			pageCollection.put("TSBCNVCTN_SELECTION_LISTVIEW",
					rmcTsbConvictionSelectionListView);
			pageCollection.put("TSBCNVCTN_COLL", bnftCnvtColl);
			
			
			final RMCFRIConvictionSelectionListView rmcFriConvictionSelectionListView = new RMCFRIConvictionSelectionListView();
			rmcFriConvictionSelectionListView.setLanguage(language);
			rmcFriConvictionSelectionListView.setJsEnabled(jsEnabled);
			rmcFriConvictionSelectionListView.setName("FRICNVCTN_SELECTION_LISTVIEW");
			rmcFriConvictionSelectionListView.setCollection(indvColl);
			rmcFriConvictionSelectionListView.setDisplayData(bnftCnvtList);
			rmcFriConvictionSelectionListView.setPageSize(1000);
			
			pageCollection.put("FRICNVCTN_SELECTION_LISTVIEW",
					rmcFriConvictionSelectionListView);
			pageCollection.put("FRICNVCTN_COLL", bnftCnvtColl);
			
			final RMCTRAConvictionSelectionListView rmcTraConvictionSelectionListView = new RMCTRAConvictionSelectionListView();
			rmcTraConvictionSelectionListView.setLanguage(language);
			rmcTraConvictionSelectionListView.setJsEnabled(jsEnabled);
			rmcTraConvictionSelectionListView.setName("TRACNVCTN_SELECTION_LISTVIEW");
			rmcTraConvictionSelectionListView.setCollection(indvColl);
			rmcTraConvictionSelectionListView.setDisplayData(bnftCnvtList);
			rmcTraConvictionSelectionListView.setPageSize(1000);
			
			pageCollection.put("TRACNVCTN_SELECTION_LISTVIEW",
					rmcTraConvictionSelectionListView);
			pageCollection.put("TRACNVCTN_COLL", bnftCnvtColl);
			
			final RMCPDSConvictionSelectionListView rmcPdsConvictionSelectionListView = new RMCPDSConvictionSelectionListView();
			rmcPdsConvictionSelectionListView.setLanguage(language);
			rmcPdsConvictionSelectionListView.setJsEnabled(jsEnabled);
			rmcPdsConvictionSelectionListView.setName("PDSCNVCTN_SELECTION_LISTVIEW");
			rmcPdsConvictionSelectionListView.setCollection(indvColl);
			rmcPdsConvictionSelectionListView.setDisplayData(bnftCnvtList);
			rmcPdsConvictionSelectionListView.setPageSize(1000);
			
			pageCollection.put("PDSCNVCTN_SELECTION_LISTVIEW",
					rmcPdsConvictionSelectionListView);
			pageCollection.put("PDSCNVCTN_COLL", bnftCnvtColl);
			
			final RMCSFEConvictionSelectionListView rmcSfeConvictionSelectionListView = new RMCSFEConvictionSelectionListView();
			rmcSfeConvictionSelectionListView.setLanguage(language);
			rmcSfeConvictionSelectionListView.setJsEnabled(jsEnabled);
			rmcSfeConvictionSelectionListView.setName("SFECNVCTN_SELECTION_LISTVIEW");
			rmcSfeConvictionSelectionListView.setCollection(indvColl);
			rmcSfeConvictionSelectionListView.setDisplayData(bnftCnvtList);
			rmcSfeConvictionSelectionListView.setPageSize(1000);
			
			pageCollection.put("SFECNVCTN_SELECTION_LISTVIEW",
					rmcSfeConvictionSelectionListView);
			pageCollection.put("SFECNVCTN_COLL", bnftCnvtColl);
			
			final RMCUBUConvictionSelectionListView rmcUbuConvictionSelectionListView = new RMCUBUConvictionSelectionListView();
			rmcUbuConvictionSelectionListView.setLanguage(language);
			rmcUbuConvictionSelectionListView.setJsEnabled(jsEnabled);
			rmcUbuConvictionSelectionListView.setName("UBUCNVCTN_SELECTION_LISTVIEW");
			rmcUbuConvictionSelectionListView.setCollection(indvColl);
			rmcUbuConvictionSelectionListView.setDisplayData(bnftCnvtList);
			rmcUbuConvictionSelectionListView.setPageSize(1000);
			
			pageCollection.put("UBUCNVCTN_SELECTION_LISTVIEW",
					rmcUbuConvictionSelectionListView);
			pageCollection.put("UBUCNVCTN_COLL", bnftCnvtColl);
			
			
			//Voluntarily Quit Job
			final RMCVQJConvictionSelectionListView rmcVQJConvictionSelectionListView = new RMCVQJConvictionSelectionListView();
			rmcVQJConvictionSelectionListView.setLanguage(language);
			rmcVQJConvictionSelectionListView.setJsEnabled(jsEnabled);
			rmcVQJConvictionSelectionListView.setName("VQJCNVCTN_SELECTION_LISTVIEW");
			rmcVQJConvictionSelectionListView.setCollection(indvColl);
			rmcVQJConvictionSelectionListView.setDisplayData(bnftCnvtList);
			rmcVQJConvictionSelectionListView.setPageSize(1000);
			
			pageCollection.put("VQJCNVCTN_SELECTION_LISTVIEW",
					rmcVQJConvictionSelectionListView);
			pageCollection.put("VQJCNVCTN_COLL", bnftCnvtColl);
			
			
			//Disqulified from FS or TANF
			final RMCDFTConvictionSelectionListView rmcDFTConvictionSelectionListView = new RMCDFTConvictionSelectionListView();
			rmcDFTConvictionSelectionListView.setLanguage(language);
			rmcDFTConvictionSelectionListView.setJsEnabled(jsEnabled);
			rmcDFTConvictionSelectionListView.setName("DFTCNVCTN_SELECTION_LISTVIEW");
			rmcDFTConvictionSelectionListView.setCollection(indvColl);
			rmcDFTConvictionSelectionListView.setDisplayData(bnftCnvtList);
			rmcDFTConvictionSelectionListView.setPageSize(1000);
			
			pageCollection.put("DFTCNVCTN_SELECTION_LISTVIEW",
					rmcDFTConvictionSelectionListView);
			pageCollection.put("DFTCNVCTN_COLL", bnftCnvtColl);
			
//			componentManager.getComponents(
//					(String) request.get(FwConstants.CURRENT_PAGE_ID), txnBean);
			createAndLoadAROBCResponseMapsToPageCollection(rmcInPrflColl,
					pageCollection, peopleHandler, true, driverStatus);

			final Map newAssetMap = new HashMap();
			pageCollection.put("NEW_ASSET_MAP", newAssetMap);

			pageCollection.put("RMB_RQST_Collection", rmbPageColl);
			componentManager.getComponents("AROBC", txnBean);
			session.put(FwConstants.BEFORE_COLLECTION, pageCollection);

			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::loadOtherBenefitsChangeSelection:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("loadOtherBenefitsChangeSelection");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"loadOtherBenefitsChangeSelection", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.loadOtherBenefitsChangeSelection() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Store other benefits change selection.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 * @throws javax.ejb.EJBException the javax.ejb. ejb exception
	 */
	public void storeOtherBenefitsChangeSelection(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.storeOtherBenefitsChangeSelection() - START");

		try {
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::storeOtherBenefitsChangeSelection:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);
			request.get(FwConstants.CURRENT_PAGE_ID);
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			final int driverStatus = driverManager.getAFBStatus(
					FwConstants.RMC_DRIVER,
					(String) request.get(FwConstants.CURRENT_PAGE_ID),
					driverArray);
			
			
			short[] programKey = (short[]) session
					.get(FwConstants.RMC_PROGRAM_KEY);
			boolean wicFlag = false;
			if (programKey[AppConstants.PROGRAM_KEY_WIC] == 1) {
				wicFlag = true;
			}
			
			/*
			 * VG SONAR Cleanup - 09/1/2015 Deleted 2,2 lines Commented Code in
			 * this block
			 */
			//Migrant farm worker code
			APP_INDV_ADDI_INFO_Collection additionalInfoColl = null;
			APP_INDV_ADDI_INFO_Cargo addiInfoCargo = null;
			boolean snapFlag = true;

			additionalInfoColl = (APP_INDV_ADDI_INFO_Collection) pageCollection
					.get("APP_INDV_ADDI_INFO_Collection");
			if (snapFlag
					&& ((additionalInfoColl == null) || additionalInfoColl
							.isEmpty())) {
				additionalInfoColl = new APP_INDV_ADDI_INFO_Collection();
				final APP_INDV_ADDI_INFO_Cargo tempCargo = new APP_INDV_ADDI_INFO_Cargo();
				tempCargo.setMig_farm_wrkr_resp("");
				tempCargo.setMig_farm_wrkr_job_end_resp("");
				tempCargo.setMig_farm_wrkr_job_rate_resp("");
				tempCargo.setFs_bneft_rcve_cur_mth("");

				additionalInfoColl.addCargo(tempCargo);
			}
			
			//Validatoin goes here
			
			final RMC_RESPONSE_Custom_Collection beforeRespColl = (RMC_RESPONSE_Custom_Collection) pageCollection
					.get("RMC_RESPONSE_Custom_Collection");
			final HealthCareCoverageBO healthCvrgBo = new HealthCareCoverageBO();
			healthCvrgBo.formatResponse(beforeRespColl);
			final int respSize = beforeRespColl.size();
			final RMC_RESPONSE_Custom_Collection respColl = new RMC_RESPONSE_Custom_Collection();
			for (int i = 0; i < respSize; i++) {
				RMC_RESPONSE_Custom_Cargo rmcCustomCargo = null;
				rmcCustomCargo = beforeRespColl.getCargo(i);
				if (rmcCustomCargo != null
						&& rmcCustomCargo.getResponse() != null
						&& !FwConstants.NO.equalsIgnoreCase(rmcCustomCargo
								.getResponse())) {
					respColl.add(rmcCustomCargo);
				}
			}

			// Get App Number
			final RMBRequestManager rmbRequestManager = new RMBRequestManager();
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			final String applicationType = (String) session
					.get(FwConstants.ACCESS_APPLICATION_TYPE);
			final char appType = applicationType.charAt(0);

			final AssetBO assetBO = new AssetBO();
			assetBO.formatAssetResponse(respColl);

			RMB_RQST_Cargo rmbRqstCargo = null;
			if (appType != FwConstants.RMC_APP_TYPE) {
				RMB_RQST_Collection rmbRqstPageColl = (RMB_RQST_Collection) pageCollection
						.get("RMB_RQST_Collection");

				if (rmbRqstPageColl == null) {
					rmbRqstPageColl = new RMB_RQST_Collection();
					rmbRqstPageColl.add(rmbRequestManager
							.loadRMBRequest(appNum));
				}
				rmbRqstCargo = rmbRqstPageColl.getCargo(0);
			}
			final OtherBenefitsBO benefitsBO = new OtherBenefitsBO();
			final PeopleHandler peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);
			final INDIVIDUAL_Custom_Collection indvColl = peopleHandler
					.getInHomeIndividuals();
			final int indvSize = indvColl.size();
			final Map indvNameMap = new HashMap();
			for (int i = 0; i < indvSize; i++) {
				final INDIVIDUAL_Custom_Cargo indvCargo = (INDIVIDUAL_Custom_Cargo) indvColl
						.get(i);
				indvNameMap.put(indvCargo.getIndv_seq_num(),
						indvCargo.getFst_nam());
			}

			final List pageCpntList = (ArrayList) beforeColl
					.get(FwConstants.PAGE_COMPONENT_LIST);

			final Map assetCollMap = new HashMap();
			assetCollMap.put("APP_IN_SCHLE_Collection",
					beforeColl.get("APP_IN_SCHLE_Collection"));
			assetCollMap.put("APP_IN_CARE_PROV_Collection",
					beforeColl.get("APP_IN_CARE_PROV_Collection"));
			assetCollMap.put("MAPP_COLL", beforeColl.get("MAPP_COLL"));
			assetCollMap.put("APP_IN_DABL_Collection",
					beforeColl.get("APP_IN_DABL_Collection"));
			assetCollMap.put("HEALTHCVRG", beforeColl.get("HEALTHCVRG_COLL"));
			assetCollMap.put("INDV_COLL", indvColl);
			assetCollMap.put("RMB_RQST_Cargo", rmbRqstCargo);
			assetCollMap.put("APP_IN_MEDCR_Collection",
					beforeColl.get("APP_IN_MEDCR_Collection"));
			assetCollMap.put("APP_IN_OUT_ST_BNFT_Collection",
					beforeColl.get("APP_IN_OUT_ST_BNFT_Collection"));
			assetCollMap.put("CP_APP_IN_LST_HLTH_INS_Collection",
					beforeColl.get("CP_APP_IN_LST_HLTH_INS_Collection"));
			assetCollMap.put("CP_APP_IN_CARE_PROV_Collection",
					beforeColl.get("CP_APP_IN_CARE_PROV_Collection"));
			assetCollMap.put("APP_IN_HLTH_INS_BNFTS_Collection",
					beforeColl.get("APP_IN_HLTH_INS_BNFTS_Collection"));
			assetCollMap.put("APP_IN_OTHR_HLTH_INS_Collection",
					beforeColl.get("APP_IN_OTHR_HLTH_INS_Collection"));
			assetCollMap.put("CNVTN_COLL", beforeColl.get("CNVTN_COLL"));
			assetCollMap.put("TSBCNVCTN_COLL", beforeColl.get("TSBCNVCTN_COLL"));
			assetCollMap.put("FRICNVCTN_COLL", beforeColl.get("FRICNVCTN_COLL"));
			assetCollMap.put("TRACNVCTN_COLL", beforeColl.get("TRACNVCTN_COLL"));
			assetCollMap.put("PDSCNVCTN_COLL", beforeColl.get("PDSCNVCTN_COLL"));
			assetCollMap.put("SFECNVCTN_COLL", beforeColl.get("SFECNVCTN_COLL"));
			assetCollMap.put("UBUCNVCTN_COLL", beforeColl.get("UBUCNVCTN_COLL"));
			assetCollMap.put("VQJCNVCTN_COLL", beforeColl.get("VQJCNVCTN_COLL"));
			assetCollMap.put("DFTCNVCTN_COLL", beforeColl.get("DFTCNVCTN_COLL"));

			// build category selection profile
			SortedSet categorySelectionProfile = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			// Getting RMC_IN_PROFILE from session
			// EDSP AI
			RMC_IN_PRFL_Collection rmcInPrflSessColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			final RMC_IN_PRFL_Collection rmcInPrflPageColl = (RMC_IN_PRFL_Collection) pageCollection
					.get("RMC_IN_PRFL_Collection");

			for (int i = 0; i < rmcInPrflPageColl.size(); i++) {
				final RMC_IN_PRFL_Cargo cargo = rmcInPrflPageColl.getCargo(i);

				if (cargo.getSpecial_need_resp() == null) {
					cargo.setSpecial_need_resp(FwConstants.NO);
				}
				if (cargo.getFoster_care_resp() == null) {
					cargo.setFoster_care_resp(FwConstants.NO);
				}
				if (cargo.getFormer_foster_resp() == null) {
					cargo.setFormer_foster_resp(FwConstants.NO);
				}

				if (cargo.getChild_protective_resp() == null) {
					cargo.setChild_protective_resp(FwConstants.NO);
				}
				if (cargo.getLiving_prog_resp() == null) {
					cargo.setLiving_prog_resp(FwConstants.NO);
				}
				if (cargo.getGrand_parent_resp() == null) {
					cargo.setGrand_parent_resp(FwConstants.NO);
				}
				if (cargo.getDrug_felonies_resp() == null) {
					cargo.setDrug_felonies_resp(FwConstants.NO);
				}

				if (cargo.getSnap_tanf_disc_resp() == null) {
					cargo.setSnap_tanf_disc_resp(FwConstants.NO);
				}

				if (cargo.getTanfDiscResp() == null) {
					cargo.setTanfDiscResp(FwConstants.NO);
				}
				if (cargo.getViolating_parole_resp() == null) {
					cargo.setViolating_parole_resp(FwConstants.NO);
				}
				if (cargo.getConvic_false_info_resp() == null) {
					cargo.setConvic_false_info_resp(FwConstants.NO);
				}
				if (cargo.getVoluntarily_quit_job_resp() == null) {
					cargo.setVoluntarily_quit_job_resp(FwConstants.NO);
				}
				if (cargo.getTrading_snap_resp() == null) {
					cargo.setTrading_snap_resp(FwConstants.NO);
				}
				if (cargo.getBuy_sell_snap_resp() == null) {
					cargo.setBuy_sell_snap_resp(FwConstants.NO);
				}
				if (cargo.getTrade_snap_gun_resp() == null) {
					cargo.setTrade_snap_gun_resp(FwConstants.NO);
				}
				if (cargo.getPrev_ssi_resp() == null) {
					cargo.setPrev_ssi_resp(FwConstants.NO);
				}
				if (cargo.getHome_community_resp() == null) {
					cargo.setHome_community_resp(FwConstants.NO);
				}
				if (cargo.getTribal_health_resp() == null) {
					cargo.setTribal_health_resp(FwConstants.NO);
				}
				if (cargo.getTribal_eligibility_resp() == null) {
					cargo.setTribal_eligibility_resp(FwConstants.NO);
				}
				if (cargo.getDomestic_violence_resp() == null) {
					cargo.setDomestic_violence_resp(FwConstants.NO);
				}
				if (cargo.getTanf_eppic_resp() == null) {
					cargo.setTanf_eppic_resp(FwConstants.NO);
				}
				if (cargo.getEmergency_medical_resp() == null) {
					cargo.setEmergency_medical_resp(FwConstants.NO);
				}
				if (cargo.getAvd_prsctn_fstf() == null) {
					cargo.setAvd_prsctn_fstf(FwConstants.NO);
				}
				if (cargo.getMed_type_katie_beckett() == null) {
					cargo.setMed_type_katie_beckett(FwConstants.NO);
				}

			}

			final short[] questionsArrayForIndv = new short[16];
			questionsArrayForIndv[0] = IRMCResponseProfileManager.SPECIAL_NEED;
			questionsArrayForIndv[1] = IRMCResponseProfileManager.FOSTER_CARE_RESP;
			questionsArrayForIndv[2] = IRMCResponseProfileManager.FORMER_FOSTER_RESP;
			questionsArrayForIndv[3] = IRMCResponseProfileManager.CHILD_PROTECTIVE_RESP;
			questionsArrayForIndv[4] = IRMCResponseProfileManager.LIVING_PROG_RESP;
			questionsArrayForIndv[5] = IRMCResponseProfileManager.GRAND_PARENT_RESP;
			/*questionsArrayForIndv[6] = IRMCResponseProfileManager.DRUG_FELONIES_RESP;*/
			questionsArrayForIndv[6] = IRMCResponseProfileManager.SNAP_TANF_DISC_RESP;
			/*questionsArrayForIndv[7] = IRMCResponseProfileManager.TANF_DISC_RESP;*/
			questionsArrayForIndv[7] = IRMCResponseProfileManager.VIOLATING_PAROLE_RESP;
			/*questionsArrayForIndv[10] = IRMCResponseProfileManager.CONVIC_FALSE_INFO_RESP;*/
			/*questionsArrayForIndv[9] = IRMCResponseProfileManager.VOLUNTARILY_QUIT_JOB_RESP;*/
			/*questionsArrayForIndv[12] = IRMCResponseProfileManager.TRADING_SNAP_RESP;*/
			/*questionsArrayForIndv[13] = IRMCResponseProfileManager.BUY_SELL_SNAP_RESP;*/
			/*questionsArrayForIndv[14] = IRMCResponseProfileManager.TRADE_SNAP_GUN_RESP;*/
			questionsArrayForIndv[8] = IRMCResponseProfileManager.PREV_SSI_RESP;
			questionsArrayForIndv[9] = IRMCResponseProfileManager.HOME_COMMUNITY_RESP;
			questionsArrayForIndv[10] = IRMCResponseProfileManager.TRIBAL_HEALTH_RESP;
			questionsArrayForIndv[11] = IRMCResponseProfileManager.TRIBAL_ELIGIBILITY_RESP;
			questionsArrayForIndv[12] = IRMCResponseProfileManager.DOMESTIC_VIOLENCE_RESP;
			/*questionsArrayForIndv[20] = IRMCResponseProfileManager.TANF_EPPIC_RESP;*/
			questionsArrayForIndv[13] = IRMCResponseProfileManager.EMERGENCY_MEDICAL_RESP;
			questionsArrayForIndv[14] = IRMCResponseProfileManager.AVD_PRSCTN_FSTF;
			questionsArrayForIndv[15] = IRMCResponseProfileManager.KATIE_BECKETT;

			// if empl seq is "A" then set to empty string

			RMC_RESPONSE_Custom_Cargo rmcCustomCargo = null;
			int size = respColl.size();
			RMC_IN_PRFL_Collection rmcPrflPageColl = new RMC_IN_PRFL_Collection();
			RMC_IN_PRFL_Cargo rmcPrflSessCargo = null;
			RMC_IN_PRFL_Cargo rmcPrflPageCargo = null;
			final RMC_RESPONSE_Custom_Collection valRespColl = new RMC_RESPONSE_Custom_Collection();
			String catType = null;
			String indvSeqNum = null;
			boolean addInd = false;
            String seqNum = null;

			for (int i = 0; i < respColl.size(); i++) {
				final RMC_RESPONSE_Custom_Cargo respCargo = respColl
						.getCargo(i);
				if (respCargo.getUserEndSelectionInd() == null) {
					respCargo.setUserEndSelectionInd(respCargo.getResponse());
				}
			}

			for (int i = 0; i < size; i++) {
				rmcCustomCargo = respColl.getCargo(i);
				seqNum = rmcCustomCargo.getSeqNum();
				catType = rmcCustomCargo.getCategoryType();
				indvSeqNum = rmcCustomCargo.getIndvSeqNum();

				if (AppConstants.RMC_ADD_NEW_IND.equals(seqNum)) {
					// this one is for the page collection
					if (rmcPrflPageColl != null) {
						rmcPrflPageCargo = rmcResponseProfileManager
								.getProfile(rmcPrflPageColl, indvSeqNum);
					}
					if (rmcPrflPageCargo == null) {
						rmcPrflPageCargo = new RMC_IN_PRFL_Cargo();
						rmcPrflPageCargo.setApp_num(appNum);
						rmcPrflPageCargo.setIndv_seq_num(indvSeqNum);
						rmcPrflPageColl.addCargo(rmcPrflPageCargo);
					}
					// this one is for the session collection
					if (rmcInPrflSessColl != null) {
						rmcPrflSessCargo = rmcResponseProfileManager
								.getProfile(rmcInPrflSessColl, indvSeqNum);
					} else {
						rmcInPrflSessColl = new RMC_IN_PRFL_Collection();
					}
					if (rmcPrflSessCargo == null) {
						rmcPrflSessCargo = new RMC_IN_PRFL_Cargo();
						rmcPrflSessCargo.setApp_num(appNum);
						rmcPrflSessCargo.setIndv_seq_num(indvSeqNum);
						rmcResponseProfileManager
						.createRMCIndividualProfile(rmcPrflSessCargo);
						rmcInPrflSessColl.addCargo(rmcPrflSessCargo);
					}

					if (AppConstants.MEDICARE_INFORMATION.equals(rmcCustomCargo
							.getCategoryType())) {
						rmcPrflPageCargo.setRcv_medcr_resp(FwConstants.YES);
					} else if (AppConstants.HEALTHINS_INFORMATION
							.equals(rmcCustomCargo.getCategoryType())) {
						rmcPrflPageCargo.setHlth_ins_resp(FwConstants.YES);
					/*} else if (AppConstants.OTHR_HLTH_INS_INFORMATION
							.equals(rmcCustomCargo.getCategoryType())) {*/
						rmcPrflPageCargo.setOthr_hlth_ins_resp(FwConstants.YES);
					} else if (AppConstants.HOSPITAL_STAY.equals(rmcCustomCargo
							.getCategoryType())) {
						rmcPrflPageCargo.setHospital_stay_resp(FwConstants.YES);
					} else if (AppConstants.LOST_HEALTH_INSURANCE
							.equals(rmcCustomCargo.getCategoryType())) {
						rmcPrflPageCargo
						.setLost_health_ins_ind(FwConstants.YES);
					} else if (AppConstants.HOSPICE_INFORMATION
							.equals(rmcCustomCargo.getCategoryType())) {
						rmcPrflPageCargo.setHospice_resp(FwConstants.YES);
					} else if (AppConstants.NURSING_INFORMATION
							.equals(rmcCustomCargo.getCategoryType())) {
						rmcPrflPageCargo
						.setMed_type_nursing_resp(FwConstants.YES);
					} else if (AppConstants.OUTOFSTATE_INFORMATION
							.equals(rmcCustomCargo.getCategoryType())) {
						rmcPrflPageCargo.setOutstate_bnft_resp(FwConstants.YES);
					} else if (AppConstants.SCHOOL_ENROLLEMENT_CHANGE
							.equals(rmcCustomCargo.getCategoryType())) {
						rmcPrflPageCargo
						.setSchool_enrollment_resp(FwConstants.YES);
					} else if (AppConstants.CONVICTION.equals(rmcCustomCargo
							.getCategoryType())) {
						rmcPrflPageCargo.setAvoid_prosc_resp(FwConstants.YES);
					} else if (AppConstants.CNVCT_TSB.equals(rmcCustomCargo.getCategoryType())){
						rmcPrflPageCargo.setTrading_snap_resp(FwConstants.YES);
					} else if (AppConstants.CNVCT_FRI.equals(rmcCustomCargo.getCategoryType())){
						rmcPrflPageCargo.setConvic_false_info_resp(FwConstants.YES);
					} else if (AppConstants.CNVCT_TRA.equals(rmcCustomCargo.getCategoryType())){
						rmcPrflPageCargo.setBuy_sell_snap_resp(FwConstants.YES);
					} else if (AppConstants.CNVCT_PDS.equals(rmcCustomCargo.getCategoryType())){
						rmcPrflPageCargo.setDrug_felonies_resp(FwConstants.YES);
					} else if (AppConstants.CNVCT_SFE.equals(rmcCustomCargo.getCategoryType())){
						rmcPrflPageCargo.setTrade_snap_gun_resp(FwConstants.YES);
					} else if (AppConstants.CNVCT_UBU.equals(rmcCustomCargo.getCategoryType())){
						rmcPrflPageCargo.setTanf_eppic_resp(FwConstants.YES);
					}else if (AppConstants.CNVCT_VQJ.equals(rmcCustomCargo.getCategoryType())){
						rmcPrflPageCargo.setVoluntarily_quit_job_resp(FwConstants.YES);
					}else if (AppConstants.CNVCT_DFT.equals(rmcCustomCargo.getCategoryType())){
						rmcPrflPageCargo.setTanfDiscResp(FwConstants.YES);
					}

					/*
					 * VG SONAR Cleanup - 09/1/2015 Deleted 3 lines Commented
					 * Code in this block
					 */

					valRespColl.addCargo(rmcCustomCargo);
					addInd = true;
					// EDSP AI
					respColl.remove(i);
					size--;
					i--;
				}else if (AppConstants.HEALTHINS_INFORMATION.equals(catType)
						&& rmcCustomCargo.getUserEndSelectionInd() != null
						&& AppConstants.ZERO.equals(rmcCustomCargo
								.getUserEndSelectionInd())) {
					RMC_RESPONSE_Custom_Cargo rmcCitCustomCargo = new RMC_RESPONSE_Custom_Cargo();
					rmcCitCustomCargo.setIndvSeqNum(rmcCustomCargo
							.getIndvSeqNum());
					rmcCitCustomCargo.setUserEndSelectionInd(rmcCustomCargo
							.getResponse());
					rmcCitCustomCargo
					.setChangeSelectionCategoryCd(rmcCustomCargo
							.getChangeSelectionCategoryCd());
					rmcCitCustomCargo.setSeqNum(rmcCustomCargo.getSeqNum());
					rmcCitCustomCargo.setResponse(rmcCustomCargo.getResponse());
					rmcCitCustomCargo
					.setCategoryType(AppConstants.OTHR_HLTH_INS_INFORMATION);
					respColl.add(rmcCitCustomCargo);

				}
			}

			final short[] responseArray = new short[] {
					IRMCResponseProfileManager.SCHL_ENRL_RESP,
					IRMCResponseProfileManager.HOSPITAL_STAY_RESP,
					IRMCResponseProfileManager.MED_TYPE_NURSING_RESP,
					IRMCResponseProfileManager.RECEIVE_MEDICARE,
					IRMCResponseProfileManager.HOUS_PICE,
					IRMCResponseProfileManager.OUTSTATE_BNFTS,
					IRMCResponseProfileManager.LOST_HEALTH_INS_IND,
					IRMCResponseProfileManager.HLTH_INS_RESP,
					IRMCResponseProfileManager.OTHR_HLTH_INS_RESP,
					IRMCResponseProfileManager.AVOID_PROSC_RESP,
					IRMCResponseProfileManager.TRADING_SNAP_RESP,
					IRMCResponseProfileManager.CONVIC_FALSE_INFO_RESP,
					IRMCResponseProfileManager.BUY_SELL_SNAP_RESP,
					IRMCResponseProfileManager.DRUG_FELONIES_RESP,
					IRMCResponseProfileManager.TRADE_SNAP_GUN_RESP,
					IRMCResponseProfileManager.TANF_EPPIC_RESP,
					IRMCResponseProfileManager.VOLUNTARILY_QUIT_JOB_RESP,
					IRMCResponseProfileManager.TANF_DISC_RESP/*,
					IRMCResponseProfileManager.KATIE_BECKETT*/};

			session.put(AppConstants.RMC_IN_PRFL_MASTER, rmcInPrflSessColl);
			final String backToMyAccess = (String) request
					.get(AppConstants.BACK_TO_MY_ACCESS_BUTTON);
			final Map httpSessionMap = (Map) session
					.get(FwConstants.HTTP_SESSION);
			final String language = (String) httpSessionMap
					.get(AppConstants.LANGUAGE);

			if (backToMyAccess == null) {

				if (appType != FwConstants.RMC_APP_TYPE) {
					benefitsBO.validateAssetChangeSelection(respColl,
							assetCollMap, indvNameMap, addInd, pageCpntList,
							language);

					benefitsBO.validateHlthCvrgChangeSelection(respColl,
							assetCollMap,pageCpntList);
					//validateRMBMedicareChange
					benefitsBO.validateRMBMedicareChange(respColl,
							assetCollMap, indvNameMap, addInd, pageCpntList,
							language);
				} else {
					benefitsBO.validateRMCAssetChangeSelection(respColl,
							assetCollMap, indvNameMap, addInd, pageCpntList,
							language,wicFlag);
				}
				benefitsBO.validateMigrantSection(additionalInfoColl,snapFlag);
			}

			if (checkBackToMyAccessSelected(request)
					|| benefitsBO.hasMessages()) {

				request.get(FwConstants.WARNING_MSG_DETAILS);
				if (backToMyAccess == null) {
					request.put(FwConstants.MESSAGE_LIST,
							benefitsBO.getMessageList());
				}
				if (rmcPrflPageColl != null) {
					rmcResponseProfileManager
					.translateProfileResponseAfterValidation(
							rmcPrflPageColl, rmcInPrflSessColl,
							responseArray);
				}
				if (respColl != null && !respColl.isEmpty()) {
					categorySelectionProfile = categorySelectionProfileManager
							.buildSelectionProfileAfterValidation(
									categorySelectionProfile, respColl);
				}
				final RMBSchoolEnrlChangeSelectionListView rmbLiquidAssetSelectionListView = (RMBSchoolEnrlChangeSelectionListView) beforeColl
						.get("SCHOOL_ENRL_LISTVIEW");

				final RMBMappChangeSelectionListView rmbVehicleAssetSelectionListView = (RMBMappChangeSelectionListView) beforeColl
						.get("MAPP_LISTVIEW");

				/*
				 * VG SONAR Cleanup - 09/1/2015 Deleted 2,1 lines Commented Code
				 * in this block
				 */

				final APP_IN_SCHLE_Collection schColl = (APP_IN_SCHLE_Collection) beforeColl
						.get("APP_IN_SCHLE_Collection");

				final APP_IN_MAPP_Collection mappColl = (APP_IN_MAPP_Collection) beforeColl
						.get("MAPP_COLL");
				final APP_IN_DABL_Collection dablColl = (APP_IN_DABL_Collection) beforeColl
						.get("APP_IN_DABL_Collection");
				final APP_MED_INS_Collection hlthCvrgColl = (APP_MED_INS_Collection) beforeColl
						.get("HEALTHCVRG_COLL");

				final List schataList = new ArrayList();
				schataList.add(schColl);
				schataList.add(indvColl);
				schataList.add(rmcPrflPageColl);
				schataList.add(categorySelectionProfile);
				schataList.add(driverStatus);

				final List dataList = new ArrayList();
				dataList.add(mappColl);
				dataList.add(indvColl);
				dataList.add(rmcPrflPageColl);
				dataList.add(categorySelectionProfile);
				dataList.add(dablColl);
				dataList.add(peopleHandler);

				rmbLiquidAssetSelectionListView.setDisplayData(schataList);

				pageCollection.put("SCHOOL_ENRL_LISTVIEW",
						rmbLiquidAssetSelectionListView);
				pageCollection.put("MAPP_LISTVIEW",
						rmbVehicleAssetSelectionListView);
				pageCollection.put("APP_IN_SCHLE_Collection", schColl);

				final List hlthDataList = new ArrayList();
				hlthDataList.add(hlthCvrgColl);
				hlthDataList.add(indvColl);
				hlthDataList.add(rmcPrflPageColl);
				hlthDataList.add(rmbRqstCargo);
				hlthDataList.add(categorySelectionProfile);
				hlthDataList.add(driverStatus);

				/*
				 * VG SONAR Cleanup - 09/1/2015 Changed Commented code block to
				 * javadoc
				 */

				/**
				 * if (appType != FwConstants.RMC_APP_TYPE) {*=/
				 * /*RMBHealthCvrgSelectionListView rmbHlthCvrgSelectionListView
				 * = (RMBHealthCvrgSelectionListView) beforeColl
				 * .get("HEALTHCVRG");
				 * rmbHlthCvrgSelectionListView.setLanguage(language); //
				 * rmcliquidAssetSelectionListView.setJsEnabled(jsEnabled);
				 * rmbHlthCvrgSelectionListView.setName("HEALTHCVRG");
				 * rmbHlthCvrgSelectionListView.setCollection(indvColl);
				 * rmbHlthCvrgSelectionListView.setDisplayData(hlthDataList);
				 * rmbHlthCvrgSelectionListView.setPageSize(1000);
				 *
				 * pageCollection.put("HEALTHCVRG",
				 * rmbHlthCvrgSelectionListView);
				 * pageCollection.put("HEALTHCVRG_COLL", hlthCvrgColl);
				 * pageCollection.put("RMB_RQST_Collection",
				 * (RMB_RQST_Collection) beforeColl.get("RMB_RQST_Collection"));
				 */

				// Nursing Home starts here
				final CP_APP_IN_CARE_PROV_Collection nursinHomeColl = (CP_APP_IN_CARE_PROV_Collection) beforeColl
						.get("CP_APP_IN_CARE_PROV_Collection");
				final List nurHomeList = new ArrayList();
				nurHomeList.add(nursinHomeColl);
				nurHomeList.add(indvColl);
				nurHomeList.add(rmcPrflPageColl);
				nurHomeList.add(rmbRqstCargo);
				nurHomeList.add(categorySelectionProfile);
				nurHomeList.add(driverStatus);
				final RMCNursingHomeListView rMCNursingHomeListView = (RMCNursingHomeListView) beforeColl
						.get("NURSINGHOME");
				rMCNursingHomeListView.setLanguage(language);
				rMCNursingHomeListView.setName("NURSINGHOME");
				rMCNursingHomeListView.setCollection(indvColl);
				rMCNursingHomeListView.setDisplayData(nurHomeList);
				rMCNursingHomeListView.setPageSize(1000);
				pageCollection.put("NURSINGHOME", rMCNursingHomeListView);
				pageCollection.put("CP_APP_IN_CARE_PROV_Collection",
						nursinHomeColl);
				// Nursing Home Ends here

				// Hospice Starts here
				final List hosPiceList = new ArrayList();
				hosPiceList.add(nursinHomeColl);
				hosPiceList.add(indvColl);
				hosPiceList.add(rmcPrflPageColl);
				hosPiceList.add(rmbRqstCargo);
				hosPiceList.add(categorySelectionProfile);
				hosPiceList.add(driverStatus);

				final RMCHosPiceListView rMCHosPiceListView = (RMCHosPiceListView) beforeColl
						.get("HOSPICELISTVIEW");
				rMCHosPiceListView.setLanguage(language);
				rMCHosPiceListView.setName("HOSPICELISTVIEW");
				rMCHosPiceListView.setCollection(indvColl);
				rMCHosPiceListView.setDisplayData(hosPiceList);
				rMCHosPiceListView.setPageSize(1000);
				pageCollection.put("HOSPICELISTVIEW", rMCHosPiceListView);
				pageCollection.put("CP_APP_IN_CARE_PROV_Collection",
						nursinHomeColl);

				// Hospice Ends here
				// Medicare Starts here

				final APP_IN_MEDCR_Collection mediCareColl = (APP_IN_MEDCR_Collection) beforeColl
						.get("APP_IN_MEDCR_Collection");
				final List mediCareList = new ArrayList();
				mediCareList.add(mediCareColl);
				mediCareList.add(indvColl);
				mediCareList.add(categorySelectionProfile);
				mediCareList.add(rmcPrflPageColl);
				mediCareList.add(driverStatus);
				final RMBMedicareExpIndvSelectionListView rmbMedicareExpSelectionListView = (RMBMedicareExpIndvSelectionListView) beforeColl
						.get("MEDICARELISTVIEW");
				rmbMedicareExpSelectionListView.setLanguage(language);
				rmbMedicareExpSelectionListView.setName("MEDICARELISTVIEW");
				rmbMedicareExpSelectionListView.setCollection(indvColl);
				rmbMedicareExpSelectionListView.setDisplayData(mediCareList);
				rmbMedicareExpSelectionListView.setPageSize(1000);
				pageCollection.put("MEDICARELISTVIEW",
						rmbMedicareExpSelectionListView);
				pageCollection.put("APP_IN_MEDCR_Collection", mediCareColl);

				// Medicare ends here

				// Health Insurance Starts here

				final APP_IN_HLTH_INS_BNFTS_Collection hlthInsColl = (APP_IN_HLTH_INS_BNFTS_Collection) beforeColl
						.get("APP_IN_HLTH_INS_BNFTS_Collection");
				final APP_IN_OTHR_HLTH_INS_Collection otherHlthInsColl = (APP_IN_OTHR_HLTH_INS_Collection) beforeColl
						.get("APP_IN_OTHR_HLTH_INS_Collection");
				final List hlthInsList = new ArrayList();
				hlthInsList.add(hlthInsColl);
				hlthInsList.add(indvColl);
				hlthInsList.add(categorySelectionProfile);
				hlthInsList.add(rmcPrflPageColl);
				hlthInsList.add(driverStatus);
				hlthInsList.add(otherHlthInsColl);
				final RMBHealthInsIndvSelectionListView rmbHealthInsSelectionListView = (RMBHealthInsIndvSelectionListView) beforeColl
						.get("HEALTHINSLISTVIEW");
				rmbHealthInsSelectionListView.setLanguage(language);
				rmbHealthInsSelectionListView.setName("HEALTHINSLISTVIEW");
				rmbHealthInsSelectionListView.setCollection(indvColl);
				rmbHealthInsSelectionListView.setDisplayData(hlthInsList);
				rmbHealthInsSelectionListView.setPageSize(1000);
				pageCollection.put("HEALTHINSLISTVIEW",
						rmbHealthInsSelectionListView);
				pageCollection.put("APP_IN_HLTH_INS_BNFTS_Collection",
						hlthInsColl);
				pageCollection.put("APP_IN_OTHR_HLTH_INS_Collection",
						otherHlthInsColl);

				// Health Insurance ends here
				// OutState Starts here
				final APP_IN_OUT_ST_BNFT_Collection outStateBnftColl = (APP_IN_OUT_ST_BNFT_Collection) beforeColl
						.get("APP_IN_OUT_ST_BNFT_Collection");
				final List outStateList = new ArrayList();
				outStateList.add(outStateBnftColl);
				outStateList.add(indvColl);
				outStateList.add(categorySelectionProfile);
				outStateList.add(rmcPrflPageColl);
				outStateList.add(driverStatus);
				final RMCOutStateBenefitsListView rMCOutStateBenefitsListView = (RMCOutStateBenefitsListView) beforeColl
						.get("OUTSTATELISTVIEW");
				rMCOutStateBenefitsListView.setLanguage(language);
				rMCOutStateBenefitsListView.setName("OUTSTATELISTVIEW");
				rMCOutStateBenefitsListView.setCollection(indvColl);
				rMCOutStateBenefitsListView.setDisplayData(outStateList);
				rMCOutStateBenefitsListView.setPageSize(1000);
				pageCollection.put("OUTSTATELISTVIEW",
						rMCOutStateBenefitsListView);
				pageCollection.put("APP_IN_OUT_ST_BNFT_Collection",
						outStateBnftColl);
				// Out state Ends here
				// Lost Health Starts here
				final CP_APP_IN_LST_HLTH_INS_Collection lostHealthColl = (CP_APP_IN_LST_HLTH_INS_Collection) beforeColl
						.get("CP_APP_IN_LST_HLTH_INS_Collection");
				final List lostHealthList = new ArrayList();
				lostHealthList.add(lostHealthColl);
				lostHealthList.add(indvColl);
				lostHealthList.add(categorySelectionProfile);
				lostHealthList.add(rmcPrflPageColl);
				lostHealthList.add(driverStatus);
				final RMBLostHealthInsuranceSelectionListView rMCLostHealthListView = (RMBLostHealthInsuranceSelectionListView) beforeColl
						.get("LOSTHEALTHINSLISTVIEW");
				rMCLostHealthListView.setLanguage(language);
				rMCLostHealthListView.setName("LOSTHEALTHINSLISTVIEW");
				rMCLostHealthListView.setCollection(indvColl);
				rMCLostHealthListView.setDisplayData(lostHealthList);
				rMCLostHealthListView.setPageSize(1000);
				pageCollection.put("LOSTHEALTHINSLISTVIEW",
						rMCLostHealthListView);
				pageCollection.put("CP_APP_IN_LST_HLTH_INS_Collection",
						lostHealthColl);
				// Lost Health Ends here
				// Hospital Stay Starts here
				final RMCHospitalStayListView hospStayListView = (RMCHospitalStayListView) beforeColl
						.get("HOSPITALSTAY");
				final CP_APP_IN_CARE_PROV_Collection appInCreProvColl = (CP_APP_IN_CARE_PROV_Collection) beforeColl
						.get("APP_IN_CARE_PROV_Collection");
				final List appInCreProvDataList = new ArrayList();
				appInCreProvDataList.add(appInCreProvColl);
				appInCreProvDataList.add(indvColl);
				appInCreProvDataList.add(rmcPrflPageColl);
				appInCreProvDataList.add(rmbRqstCargo);
				appInCreProvDataList.add(categorySelectionProfile);
				appInCreProvDataList.add(driverStatus);
				hospStayListView.setLanguage(language);
				hospStayListView.setName("HOSPITALSTAY");
				hospStayListView.setCollection(indvColl);
				hospStayListView.setDisplayData(appInCreProvDataList);
				hospStayListView.setPageSize(1000);
				pageCollection.put("HOSPITALSTAY", hospStayListView);
				pageCollection.put("APP_IN_CARE_PROV_Collection",
						appInCreProvColl);
				// Hospital Stay Ends Here

				final APP_IN_FELON_DET_Collection felnColl = (APP_IN_FELON_DET_Collection) beforeColl
						.get("CNVTN_COLL");

				final List felnList = new ArrayList();
				felnList.add(felnColl);
				felnList.add(indvColl);
				felnList.add(categorySelectionProfile);
				felnList.add(rmcPrflPageColl);
				felnList.add(driverStatus);
				String jsEnabled = FwConstants.NO;
				final Map httpSessMap = (Map) session
						.get(FwConstants.HTTP_SESSION);
				jsEnabled = (String) httpSessMap.get(FwConstants.JS_ENABLED);
				final RMCConvictionSelectionListView rmcCvtnSelectionListView = new RMCConvictionSelectionListView();
				// Preparing listView for regular job
				rmcCvtnSelectionListView.setLanguage(language);
				rmcCvtnSelectionListView.setJsEnabled(jsEnabled);
				rmcCvtnSelectionListView.setName("CNVTN_SELECTION_LISTVIEW");
				rmcCvtnSelectionListView.setCollection(indvColl);
				rmcCvtnSelectionListView.setDisplayData(felnList);
				rmcCvtnSelectionListView.setPageSize(1000);

				pageCollection.put("CNVTN_SELECTION_LISTVIEW",
						rmcCvtnSelectionListView);
				pageCollection.put("CNVTN_COLL", felnColl);
				
				final APP_IN_BNFT_CNVCTN_Collection bnftCnvtColl = (APP_IN_BNFT_CNVCTN_Collection) beforeColl.get("TSBCNVCTN_COLL");
				final List tsbConvList = new ArrayList();
				tsbConvList.add(bnftCnvtColl);
				tsbConvList.add(indvColl);
				tsbConvList.add(categorySelectionProfile);
				tsbConvList.add(rmcPrflPageColl);
				tsbConvList.add(driverStatus);
				
				final RMCTSBConvictionSelectionListView rmcTsbConvictionSelectionListView = new RMCTSBConvictionSelectionListView();
				rmcTsbConvictionSelectionListView.setLanguage(language);
				rmcTsbConvictionSelectionListView.setJsEnabled(jsEnabled);
				rmcTsbConvictionSelectionListView.setName("TSBCNVCTN_SELECTION_LISTVIEW");
				rmcTsbConvictionSelectionListView.setCollection(indvColl);
				rmcTsbConvictionSelectionListView.setDisplayData(tsbConvList);
				rmcTsbConvictionSelectionListView.setPageSize(1000);
				
				
				final RMCFRIConvictionSelectionListView rmcFriConvictionSelectionListView = new RMCFRIConvictionSelectionListView();
				rmcFriConvictionSelectionListView.setLanguage(language);
				rmcFriConvictionSelectionListView.setJsEnabled(jsEnabled);
				rmcFriConvictionSelectionListView.setName("FRICNVCTN_SELECTION_LISTVIEW");
				rmcFriConvictionSelectionListView.setCollection(indvColl);
				rmcFriConvictionSelectionListView.setDisplayData(tsbConvList);
				rmcFriConvictionSelectionListView.setPageSize(1000);
				
				final RMCTRAConvictionSelectionListView rmcTraConvictionSelectionListView = new RMCTRAConvictionSelectionListView();
				rmcTraConvictionSelectionListView.setLanguage(language);
				rmcTraConvictionSelectionListView.setJsEnabled(jsEnabled);
				rmcTraConvictionSelectionListView.setName("TRACNVCTN_SELECTION_LISTVIEW");
				rmcTraConvictionSelectionListView.setCollection(indvColl);
				rmcTraConvictionSelectionListView.setDisplayData(tsbConvList);
				rmcTraConvictionSelectionListView.setPageSize(1000);
				
				final RMCPDSConvictionSelectionListView rmcPdsConvictionSelectionListView = new RMCPDSConvictionSelectionListView();
				rmcPdsConvictionSelectionListView.setLanguage(language);
				rmcPdsConvictionSelectionListView.setJsEnabled(jsEnabled);
				rmcPdsConvictionSelectionListView.setName("PDSCNVCTN_SELECTION_LISTVIEW");
				rmcPdsConvictionSelectionListView.setCollection(indvColl);
				rmcPdsConvictionSelectionListView.setDisplayData(tsbConvList);
				rmcPdsConvictionSelectionListView.setPageSize(1000);
				
				final RMCSFEConvictionSelectionListView rmcSfeConvictionSelectionListView = new RMCSFEConvictionSelectionListView();
				rmcSfeConvictionSelectionListView.setLanguage(language);
				rmcSfeConvictionSelectionListView.setJsEnabled(jsEnabled);
				rmcSfeConvictionSelectionListView.setName("SFECNVCTN_SELECTION_LISTVIEW");
				rmcSfeConvictionSelectionListView.setCollection(indvColl);
				rmcSfeConvictionSelectionListView.setDisplayData(tsbConvList);
				rmcSfeConvictionSelectionListView.setPageSize(1000);
				
				final RMCUBUConvictionSelectionListView rmcUbuConvictionSelectionListView = new RMCUBUConvictionSelectionListView();
				rmcUbuConvictionSelectionListView.setLanguage(language);
				rmcUbuConvictionSelectionListView.setJsEnabled(jsEnabled);
				rmcUbuConvictionSelectionListView.setName("UBUCNVCTN_SELECTION_LISTVIEW");
				rmcUbuConvictionSelectionListView.setCollection(indvColl);
				rmcUbuConvictionSelectionListView.setDisplayData(tsbConvList);
				rmcUbuConvictionSelectionListView.setPageSize(1000);
				
				final RMCVQJConvictionSelectionListView rmcVqjConvictionSelectionListView = new RMCVQJConvictionSelectionListView();
				rmcVqjConvictionSelectionListView.setLanguage(language);
				rmcVqjConvictionSelectionListView.setJsEnabled(jsEnabled);
				rmcVqjConvictionSelectionListView.setName("VQJCNVCTN_SELECTION_LISTVIEW");
				rmcVqjConvictionSelectionListView.setCollection(indvColl);
				rmcVqjConvictionSelectionListView.setDisplayData(tsbConvList);
				rmcVqjConvictionSelectionListView.setPageSize(1000);
				
				final RMCDFTConvictionSelectionListView rmcDftConvictionSelectionListView = new RMCDFTConvictionSelectionListView();
				rmcDftConvictionSelectionListView.setLanguage(language);
				rmcDftConvictionSelectionListView.setJsEnabled(jsEnabled);
				rmcDftConvictionSelectionListView.setName("DftCNVCTN_SELECTION_LISTVIEW");
				rmcDftConvictionSelectionListView.setCollection(indvColl);
				rmcDftConvictionSelectionListView.setDisplayData(tsbConvList);
				rmcDftConvictionSelectionListView.setPageSize(1000);
				
				pageCollection.put("TSBCNVCTN_SELECTION_LISTVIEW", rmcTsbConvictionSelectionListView);
				pageCollection.put("TSBCNVCTN_COLL", bnftCnvtColl);
				pageCollection.put("FRICNVCTN_SELECTION_LISTVIEW", rmcFriConvictionSelectionListView);
				pageCollection.put("FRICNVCTN_COLL", bnftCnvtColl);
				pageCollection.put("TRACNVCTN_SELECTION_LISTVIEW", rmcTraConvictionSelectionListView);
				pageCollection.put("TRACNVCTN_COLL", bnftCnvtColl);
				pageCollection.put("PDSCNVCTN_SELECTION_LISTVIEW", rmcPdsConvictionSelectionListView);
				pageCollection.put("PDSCNVCTN_COLL", bnftCnvtColl);
				pageCollection.put("SFECNVCTN_SELECTION_LISTVIEW", rmcSfeConvictionSelectionListView);
				pageCollection.put("SFECNVCTN_COLL", bnftCnvtColl);
				pageCollection.put("UBUCNVCTN_SELECTION_LISTVIEW", rmcUbuConvictionSelectionListView);
				pageCollection.put("UBUCNVCTN_COLL", bnftCnvtColl);
				pageCollection.put("VQJCNVCTN_SELECTION_LISTVIEW", rmcVqjConvictionSelectionListView);
				pageCollection.put("VQJCNVCTN_COLL", bnftCnvtColl);
				pageCollection.put("DftCNVCTN_SELECTION_LISTVIEW", rmcDftConvictionSelectionListView);
				pageCollection.put("DftCNVCTN_COLL", bnftCnvtColl);

				for (int i = 0; i < rmcInPrflSessColl.size(); i++) {

					final RMC_IN_PRFL_Cargo sessionCargo = rmcInPrflSessColl
							.getCargo(i);
					final RMC_IN_PRFL_Cargo pageCollCargo = rmcResponseProfileManager
							.getProfile(rmcInPrflPageColl,
									sessionCargo.getIndv_seq_num());
					if (pageCollCargo == null) {
						sessionCargo.setSpecial_need_resp(FwConstants.NO);
						sessionCargo.setFoster_care_resp(FwConstants.NO);
						sessionCargo.setFormer_foster_resp(FwConstants.NO);
						sessionCargo.setChild_protective_resp(FwConstants.NO);
						sessionCargo.setLiving_prog_resp(FwConstants.NO);
						sessionCargo.setGrand_parent_resp(FwConstants.NO);
						sessionCargo.setDrug_felonies_resp(FwConstants.NO);
						sessionCargo.setSnap_tanf_disc_resp(FwConstants.NO);
						sessionCargo.setTanfDiscResp(FwConstants.NO);
						sessionCargo.setAvoid_prosc_resp(FwConstants.NO);
						sessionCargo.setViolating_parole_resp(FwConstants.NO);
						/*sessionCargo.setConvic_false_info_resp(FwConstants.NO);*/
						sessionCargo
						.setVoluntarily_quit_job_resp(FwConstants.NO);
						/*sessionCargo.setTrading_snap_resp(FwConstants.NO);*/
						/*sessionCargo.setBuy_sell_snap_resp(FwConstants.NO);*/
						/*sessionCargo.setTrade_snap_gun_resp(FwConstants.NO);*/
						sessionCargo.setPrev_ssi_resp(FwConstants.NO);
						sessionCargo.setHome_community_resp(FwConstants.NO);
						sessionCargo.setTribal_health_resp(FwConstants.NO);
						sessionCargo.setTribal_eligibility_resp(FwConstants.NO);
						sessionCargo.setDomestic_violence_resp(FwConstants.NO);
						/*sessionCargo.setTanf_eppic_resp(FwConstants.NO);*/
						sessionCargo.setEmergency_medical_resp(FwConstants.NO);
						sessionCargo.setAvd_prsctn_fstf(FwConstants.NO);
						sessionCargo.setMed_type_katie_beckett(FwConstants.NO);

					} else {
						sessionCargo.setSpecial_need_resp(pageCollCargo
								.getSpecial_need_resp());
						sessionCargo.setFoster_care_resp(pageCollCargo
								.getFoster_care_resp());
						sessionCargo.setFormer_foster_resp(pageCollCargo
								.getFormer_foster_resp());
						sessionCargo.setChild_protective_resp(pageCollCargo
								.getChild_protective_resp());
						sessionCargo.setLiving_prog_resp(pageCollCargo
								.getLiving_prog_resp());
						sessionCargo.setGrand_parent_resp(pageCollCargo
								.getGrand_parent_resp());
						sessionCargo.setDrug_felonies_resp(pageCollCargo
								.getDrug_felonies_resp());
						sessionCargo.setSnap_tanf_disc_resp(pageCollCargo
								.getSnap_tanf_disc_resp());
						sessionCargo.setTanfDiscResp(pageCollCargo
								.getTanfDiscResp());
						sessionCargo.setViolating_parole_resp(pageCollCargo
								.getViolating_parole_resp());
						/*sessionCargo.setConvic_false_info_resp(pageCollCargo
								.getConvic_false_info_resp());*/
						sessionCargo.setVoluntarily_quit_job_resp(pageCollCargo
								.getVoluntarily_quit_job_resp());
						/*sessionCargo.setTrading_snap_resp(pageCollCargo
								.getTrading_snap_resp());*/
						/*sessionCargo.setBuy_sell_snap_resp(pageCollCargo
								.getBuy_sell_snap_resp());*/
						/*sessionCargo.setTrade_snap_gun_resp(pageCollCargo
								.getTrade_snap_gun_resp());*/
						sessionCargo.setPrev_ssi_resp(pageCollCargo
								.getPrev_ssi_resp());
						sessionCargo.setHome_community_resp(pageCollCargo
								.getHome_community_resp());
						sessionCargo.setTribal_health_resp(pageCollCargo
								.getTribal_health_resp());
						sessionCargo.setTribal_eligibility_resp(pageCollCargo
								.getTribal_eligibility_resp());
						sessionCargo.setDomestic_violence_resp(pageCollCargo
								.getDomestic_violence_resp());
						/*sessionCargo.setTanf_eppic_resp(pageCollCargo
								.getTanf_eppic_resp());*/
						sessionCargo.setEmergency_medical_resp(pageCollCargo
								.getEmergency_medical_resp());
						sessionCargo.setAvd_prsctn_fstf(pageCollCargo
								.getAvd_prsctn_fstf());
						sessionCargo.setMed_type_katie_beckett(pageCollCargo
								.getMed_type_katie_beckett());
					}
				}
				createAndLoadAROBCResponseMapsToPageCollection(
						rmcInPrflSessColl, pageCollection, peopleHandler, true,
						driverStatus);
				pageCollection.put("MAPP_COLL", mappColl);
				pageCollection.put("APP_IN_DABL_Collection", dablColl);
				componentManager.getComponents("AROBC", txnBean);
				pageCollection.put("DABLSIZE", beforeColl.get("DABLSIZE"));
				return;
			}

			boolean schoolEnrlDetailPageRequired = false;
			boolean hospStayDetailPageRequired = false;
			boolean detailPageRequired = false;
			boolean nurHomeDetailPageRequired = false;
			boolean medicareDetailPageRequired = false;
			boolean hosPiceDetailPageRequired = false;
			boolean outStateDetailPageRequired = false;
			boolean lostHealthDetailPageRequired = false;
			boolean healthInsDetailPageRequired = false;
			boolean otherHealthInsDetailRequired = false;
			boolean cnvtFelonDetailPageRequired = false;
			boolean bnftCnvtnDetailPageRequired = false;

			if (respColl != null && !respColl.isEmpty()) {
				for (int i = 0; i < respColl.size(); i++) {
					final RMC_RESPONSE_Custom_Cargo cargo = respColl
							.getCargo(i);
					if (cargo != null && cargo.getCategoryType() != null) {
						final Map hlthMap = new HashMap();

						hlthMap.put(AppConstants.HEALTHCARE_COVERAGE,
								AppConstants.HEALTHCARE_COVERAGE);

						if (hlthMap.containsKey(cargo.getCategoryType())) {
							if (!"2".equals(cargo.getUserEndSelectionInd())) {
							}

						}

					}
				}
			}
			for (int i = 0; i < rmcPrflPageColl.size(); i++) {
				final RMC_IN_PRFL_Cargo cargo = rmcPrflPageColl.getCargo(i);

				// EDSP AI
				if (cargo.getSchool_enrollment_resp() == null) {
					cargo.setSchool_enrollment_resp(FwConstants.NO);
				}
				if (cargo.getHospital_stay_resp() == null) {
					cargo.setHospital_stay_resp(FwConstants.NO);
				}
				if (cargo.getBnft_mapp_resp() == null) {
					cargo.setBnft_mapp_resp(FwConstants.NO);
				}
				if (cargo.getHc_cvrg_resp() == null) {
					cargo.setHc_cvrg_resp(FwConstants.NO);
				}
				if (cargo.getMed_type_nursing_resp() == null) {
					cargo.setMed_type_nursing_resp(FwConstants.NO);
				}
				if (cargo.getAvoid_prosc_resp() == null) {
					cargo.setAvoid_prosc_resp(FwConstants.NO);
				}
				
				if (cargo.getTrading_snap_resp() == null){
					cargo.setTrading_snap_resp(FwConstants.NO);
				}
				
				if(cargo.getConvic_false_info_resp()==null){
					cargo.setConvic_false_info_resp(FwConstants.NO);
				}
				
				if(cargo.getBuy_sell_snap_resp()==null){
					cargo.setBuy_sell_snap_resp(FwConstants.NO);
				}
				
				if(cargo.getDrug_felonies_resp()==null){
					cargo.setDrug_felonies_resp(FwConstants.NO);
				}
				
				if(cargo.getTrade_snap_gun_resp()==null){
					cargo.setTrade_snap_gun_resp(FwConstants.NO);
				}
				
				if(cargo.getTanf_eppic_resp()==null){
					cargo.setTanf_eppic_resp(FwConstants.NO);
				}
				if(cargo.getVoluntarily_quit_job_resp()==null){
					cargo.setVoluntarily_quit_job_resp(FwConstants.NO);
				}
				if(cargo.getTanfDiscResp()==null){
					cargo.setTanfDiscResp(FwConstants.NO);
				}
			}

			if (rmcInPrflSessColl != null) {
				if (rmcPrflPageColl == null) {
					rmcPrflPageColl = new RMC_IN_PRFL_Collection();
				}

				rmcResponseProfileManager.preparePageColl(rmcPrflPageColl,
						rmcInPrflSessColl, responseArray);

				final int rmcInPrflSessCollectionSize = rmcInPrflSessColl
						.size();
				final int rmcInPrflPageCollectionSize = rmcPrflPageColl.size();
				RMC_IN_PRFL_Cargo rmcInPrflPageCargo = null;
				String[] translatedProfileArray = null;
				String indivSeqNum = null;

				final int[] schlErnlDetailDirtyIndicator = { IRMCResponseProfileManager.NOT_DIRTY };
				final int[] hospStayDetailDirtyIndicator = { IRMCResponseProfileManager.NOT_DIRTY };
				final int[] nursingHomeDirtyIndicator = { IRMCResponseProfileManager.NOT_DIRTY };
				final int[] medicareDirtyIndicator = { IRMCResponseProfileManager.NOT_DIRTY };
				final int[] hosPiceDirtyIndicator = { IRMCResponseProfileManager.NOT_DIRTY };
				final int[] outStateDirtyIndicator = { IRMCResponseProfileManager.NOT_DIRTY };
				final int[] lostHealthDirtyIndicator = { IRMCResponseProfileManager.NOT_DIRTY };
				final int[] healthInsDirtyIndicator = { IRMCResponseProfileManager.NOT_DIRTY };
				final int[] otherHealthIndDirtyIndicator = { IRMCResponseProfileManager.NOT_DIRTY };
				final int[] cnvtFelonDirtyIndicator = { IRMCResponseProfileManager.NOT_DIRTY };
				final int[] bnftCnvtnDirtyIndicator = { IRMCResponseProfileManager.NOT_DIRTY };				
				final int[] cnvtFaslseInfoDirtyIndicator = { IRMCResponseProfileManager.NOT_DIRTY };
				final int[] buySellFsDirtyIndicator = { IRMCResponseProfileManager.NOT_DIRTY };
				final int[] drugFelnsDirtyIndicator = { IRMCResponseProfileManager.NOT_DIRTY };
				final int[] tradeFsGunDirtyIndicator = { IRMCResponseProfileManager.NOT_DIRTY };
				final int[] tanfEppicDirtyIndicator = { IRMCResponseProfileManager.NOT_DIRTY };
				final int[] voluQuitDirtyIndicator = { IRMCResponseProfileManager.NOT_DIRTY };
				final int[] tanfDiscDirtyIndicator = { IRMCResponseProfileManager.NOT_DIRTY };
				final int[] katieBeckettDirtyIndicator = { IRMCResponseProfileManager.NOT_DIRTY };

				final Map indvResponseMap = new HashMap();
				final boolean[] dirtyIndicatorArray = new boolean[rmcResponseProfileManager
				                                                  .getMaxIndvSeqNumber(rmcInPrflSessColl) + 1];
				char status = IRMCResponseProfileManager.STATUS_NOT_REQUIRED;
				// Loop for each individual in session app indv profile
				for (int s = 0; s < rmcInPrflSessCollectionSize; s++) {
					final RMC_IN_PRFL_Cargo rmcInPrflSessCargo = rmcInPrflSessColl
							.getCargo(s);
					// Loop for each individual in page collection app indv
					// profile
					for (int p = 0; p < rmcInPrflPageCollectionSize; p++) {
						rmcInPrflPageCargo = rmcPrflPageColl.getCargo(p);
						// Picking up the matching individuals of session app
						// indv profile from page collection app indv profile
						if (rmcInPrflPageCargo.getIndv_seq_num().equals(
								rmcInPrflSessCargo.getIndv_seq_num())) {
							translatedProfileArray = new String[responseArray.length];
							indivSeqNum = rmcInPrflPageCargo.getIndv_seq_num();

							if (applicationManager.determineDirtyStatus(
									rmcInPrflPageCargo
									.getSchool_enrollment_resp(),
									rmcInPrflSessCargo
									.getSchool_enrollment_resp(),
									schlErnlDetailDirtyIndicator, driverStatus)) {
								if (!dirtyIndicatorArray[0]) {
									dirtyIndicatorArray[0] = true;
								}
								dirtyIndicatorArray[Integer
								                    .parseInt(indivSeqNum)] = true;
								rmcResponseProfileManager
								.translateProfileResponses(
										rmcInPrflPageCargo
										.getSchool_enrollment_resp(),
										rmcInPrflSessCargo
										.getSchool_enrollment_resp(),
										driverStatus,
										IRMCResponseProfileManager.SCHL_ENRL_RESP,
										rmcInPrflSessCargo);

							}
							translatedProfileArray[0] = rmcInPrflSessCargo
									.getSchool_enrollment_resp();
							status = (null != rmcInPrflSessCargo
									.getSchool_enrollment_resp()) ? (rmcInPrflSessCargo
									.getSchool_enrollment_resp().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
							if (status == IRMCResponseProfileManager.STATUS_ADD_NEW
									|| status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
									|| status == IRMCResponseProfileManager.STATUS_REQUIRED) {
								schoolEnrlDetailPageRequired = true;
							}

							if (applicationManager.determineDirtyStatus(
									rmcInPrflPageCargo.getHospital_stay_resp(),
									rmcInPrflSessCargo.getHospital_stay_resp(),
									hospStayDetailDirtyIndicator, driverStatus)) {
								if (!dirtyIndicatorArray[0]) {
									dirtyIndicatorArray[0] = true;
								}
								dirtyIndicatorArray[Integer
								                    .parseInt(indivSeqNum)] = true;
								rmcResponseProfileManager
								.translateProfileResponses(
										rmcInPrflPageCargo
										.getHospital_stay_resp(),
										rmcInPrflSessCargo
										.getHospital_stay_resp(),
										driverStatus,
										IRMCResponseProfileManager.HOSPITAL_STAY_RESP,
										rmcInPrflSessCargo);

							}
							translatedProfileArray[1] = rmcInPrflSessCargo
									.getHospital_stay_resp();
							status = (null != rmcInPrflSessCargo
									.getHospital_stay_resp()) ? (rmcInPrflSessCargo
									.getHospital_stay_resp().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
							if (status == IRMCResponseProfileManager.STATUS_ADD_NEW
									|| status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
									|| status == IRMCResponseProfileManager.STATUS_REQUIRED) {
								hospStayDetailPageRequired = true;
								driverManager.makeRequired(
										FwConstants.RMC_DRIVER, "ARHPS",
										driverArray, appNum);
							}

							if (!IDriver.DRIVER_STATUS_COMPLETE.equals(driverManager.getStatus(FwConstants.RMC_DRIVER, "ARHPS", driverArray))) {
								driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER, "ARHPS", driverArray, appNum);
							} else {
								driverManager.makeComplete(FwConstants.RMC_DRIVER, "ARHPS", driverArray, appNum);
							}

							// Nursing Home Persistence logic starts here
							if (rmcResponseProfileManager.determineDirtyStatus(rmcInPrflPageCargo.getMed_type_nursing_resp(),
									rmcInPrflSessCargo.getMed_type_nursing_resp(), nursingHomeDirtyIndicator, driverStatus)) {
								if (!dirtyIndicatorArray[0]) {
									dirtyIndicatorArray[0] = true;
								}
								dirtyIndicatorArray[Integer
								                    .parseInt(indivSeqNum)] = true;

							}

							if (!rmcInPrflSessCargo.getMed_type_nursing_resp().equalsIgnoreCase(
									String.valueOf(ICategorySelectionProfileManager.STATUS_COMPLETE))) {
								rmcResponseProfileManager.translateProfileResponses(rmcInPrflPageCargo.getMed_type_nursing_resp(),
										rmcInPrflSessCargo.getMed_type_nursing_resp(), driverStatus,
										IRMCResponseProfileManager.MED_TYPE_NURSING_RESP, rmcInPrflSessCargo);
							}
							translatedProfileArray[2] = rmcInPrflSessCargo.getMed_type_nursing_resp();
							status = (null != rmcInPrflSessCargo
									.getMed_type_nursing_resp()) ? (rmcInPrflSessCargo
									.getMed_type_nursing_resp().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
							if ((status == IRMCResponseProfileManager.STATUS_ADD_NEW) || (status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN)
									|| (status == IRMCResponseProfileManager.STATUS_REQUIRED)) {
								nurHomeDetailPageRequired = true;
								/*
								 * VG SONAR Cleanup - 09/1/2015 Deleted 1,1,1
								 * lines Commented Code in this block
								 */
							}

							// Nursing Home Persistence logic Ends here
							// Medicare Persistence logic starts here
							if (rmcResponseProfileManager.determineDirtyStatus(rmcInPrflPageCargo.getRcv_medcr_resp(),
									rmcInPrflSessCargo.getRcv_medcr_resp(), medicareDirtyIndicator, driverStatus)) {
								if (!dirtyIndicatorArray[0]) {
									dirtyIndicatorArray[0] = true;
								}
								dirtyIndicatorArray[Integer
								                    .parseInt(indivSeqNum)] = true;

							}

							if (!rmcInPrflSessCargo.getRcv_medcr_resp().equalsIgnoreCase(
									String.valueOf(ICategorySelectionProfileManager.STATUS_COMPLETE))) {
								rmcResponseProfileManager.translateProfileResponses(rmcInPrflPageCargo.getRcv_medcr_resp(),
										rmcInPrflSessCargo.getRcv_medcr_resp(), driverStatus, IRMCResponseProfileManager.RECEIVE_MEDICARE,
										rmcInPrflSessCargo);
							}
							translatedProfileArray[3] = rmcInPrflSessCargo.getRcv_medcr_resp();
							status = (null != rmcInPrflSessCargo
									.getRcv_medcr_resp()) ? (rmcInPrflSessCargo
									.getRcv_medcr_resp().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
							if ((status == IRMCResponseProfileManager.STATUS_ADD_NEW) || (status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN)
									|| (status == IRMCResponseProfileManager.STATUS_REQUIRED)) {
								medicareDetailPageRequired = true;

							}

							// Medicare Persistence logic Ends here
							// HouPice Persistence logic starts here
							if (rmcResponseProfileManager.determineDirtyStatus(rmcInPrflPageCargo.getHospice_resp(),
									rmcInPrflSessCargo.getHospice_resp(), hosPiceDirtyIndicator, driverStatus)) {
								if (!dirtyIndicatorArray[0]) {
									dirtyIndicatorArray[0] = true;
								}
								dirtyIndicatorArray[Integer
								                    .parseInt(indivSeqNum)] = true;

							}

							if (!rmcInPrflSessCargo.getHospice_resp().equalsIgnoreCase(
									String.valueOf(ICategorySelectionProfileManager.STATUS_COMPLETE))) {
								rmcResponseProfileManager.translateProfileResponses(rmcInPrflPageCargo.getHospice_resp(),
										rmcInPrflSessCargo.getHospice_resp(), driverStatus, IRMCResponseProfileManager.HOUS_PICE, rmcInPrflSessCargo);
							}
							translatedProfileArray[4] = rmcInPrflSessCargo.getHospice_resp();
							status = (null != rmcInPrflSessCargo
									.getHospice_resp()) ? (rmcInPrflSessCargo
									.getHospice_resp().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
							if ((status == IRMCResponseProfileManager.STATUS_ADD_NEW) || (status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN)
									|| (status == IRMCResponseProfileManager.STATUS_REQUIRED)) {
								hosPiceDetailPageRequired = true;

							}

							// HouPice Persistence logic Ends here
							// OutState Persistence logic starts here
							if (rmcResponseProfileManager.determineDirtyStatus(
									rmcInPrflPageCargo.getOutstate_bnft_resp(),
									rmcInPrflSessCargo.getOutstate_bnft_resp(),
									outStateDirtyIndicator, driverStatus)) {
								if (!dirtyIndicatorArray[0]) {
									dirtyIndicatorArray[0] = true;
								}
								dirtyIndicatorArray[Integer
								                    .parseInt(indivSeqNum)] = true;

							}

							if (!rmcInPrflSessCargo
									.getOutstate_bnft_resp()
									.equalsIgnoreCase(
									String.valueOf(ICategorySelectionProfileManager.STATUS_COMPLETE))) {
								rmcResponseProfileManager
								.translateProfileResponses(
										rmcInPrflPageCargo
										.getOutstate_bnft_resp(),
										rmcInPrflSessCargo
										.getOutstate_bnft_resp(),
										driverStatus,
										IRMCResponseProfileManager.OUTSTATE_BNFTS,
										rmcInPrflSessCargo);
							}
							translatedProfileArray[5] = rmcInPrflSessCargo
									.getOutstate_bnft_resp();
							status = (null != rmcInPrflSessCargo
									.getOutstate_bnft_resp()) ? (rmcInPrflSessCargo
									.getOutstate_bnft_resp().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
							if (status == IRMCResponseProfileManager.STATUS_ADD_NEW
									|| status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
									|| status == IRMCResponseProfileManager.STATUS_REQUIRED) {
								outStateDetailPageRequired = true;
							}
							// OutState Persistence logic Ends here
							if (rmcResponseProfileManager
									.determineDirtyStatus(rmcInPrflPageCargo
											.getLost_health_ins_ind(),
											rmcInPrflSessCargo
											.getLost_health_ins_ind(),
											lostHealthDirtyIndicator,
											driverStatus)) {
								if (!dirtyIndicatorArray[0]) {
									dirtyIndicatorArray[0] = true;
								}
								dirtyIndicatorArray[Integer
								                    .parseInt(indivSeqNum)] = true;

							}

							if (!rmcInPrflSessCargo
									.getLost_health_ins_ind()
									.equalsIgnoreCase(
									String.valueOf(ICategorySelectionProfileManager.STATUS_COMPLETE))) {
								rmcResponseProfileManager
								.translateProfileResponses(
										rmcInPrflPageCargo
										.getLost_health_ins_ind(),
										rmcInPrflSessCargo
										.getLost_health_ins_ind(),
										driverStatus,
										IRMCResponseProfileManager.LOST_HEALTH_INS_IND,
										rmcInPrflSessCargo);
							}
							translatedProfileArray[6] = rmcInPrflSessCargo
									.getLost_health_ins_ind();
							status = (null != rmcInPrflSessCargo
									.getLost_health_ins_ind()) ? (rmcInPrflSessCargo
									.getLost_health_ins_ind().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
							if (status == IRMCResponseProfileManager.STATUS_ADD_NEW
									|| status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
									|| status == IRMCResponseProfileManager.STATUS_REQUIRED) {
								lostHealthDetailPageRequired = true;
							}

							if (rmcResponseProfileManager.determineDirtyStatus(
									rmcInPrflPageCargo.getHlth_ins_resp(),
									rmcInPrflSessCargo.getHlth_ins_resp(),
									healthInsDirtyIndicator, driverStatus)) {
								if (!dirtyIndicatorArray[0]) {
									dirtyIndicatorArray[0] = true;
								}
								dirtyIndicatorArray[Integer
								                    .parseInt(indivSeqNum)] = true;

							}

							if (!rmcInPrflSessCargo
									.getHlth_ins_resp()
									.equalsIgnoreCase(
									String.valueOf(ICategorySelectionProfileManager.STATUS_COMPLETE))) {
								rmcResponseProfileManager
								.translateProfileResponses(
										rmcInPrflPageCargo
										.getHlth_ins_resp(),
										rmcInPrflSessCargo
										.getHlth_ins_resp(),
										driverStatus,
										IRMCResponseProfileManager.HLTH_INS_RESP,
										rmcInPrflSessCargo);
							}
							translatedProfileArray[7] = rmcInPrflSessCargo
									.getHlth_ins_resp();
							status = (null != rmcInPrflSessCargo
									.getHlth_ins_resp()) ? (rmcInPrflSessCargo
									.getHlth_ins_resp().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
							if (status == IRMCResponseProfileManager.STATUS_ADD_NEW
									|| status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
									|| status == IRMCResponseProfileManager.STATUS_REQUIRED) {
								healthInsDetailPageRequired = true;
							}

							if (rmcResponseProfileManager.determineDirtyStatus(
									rmcInPrflPageCargo.getOthr_hlth_ins_resp(),
									rmcInPrflSessCargo.getOthr_hlth_ins_resp(),
									otherHealthIndDirtyIndicator, driverStatus)) {
								if (!dirtyIndicatorArray[0]) {
									dirtyIndicatorArray[0] = true;
								}
								dirtyIndicatorArray[Integer
								                    .parseInt(indivSeqNum)] = true;
							}

							if (!rmcInPrflSessCargo
									.getOthr_hlth_ins_resp()
									.equalsIgnoreCase(
									String.valueOf(ICategorySelectionProfileManager.STATUS_COMPLETE))) {
								rmcResponseProfileManager
								.translateProfileResponses(
										rmcInPrflPageCargo
										.getOthr_hlth_ins_resp(),
										rmcInPrflSessCargo
										.getOthr_hlth_ins_resp(),
										driverStatus,
										IRMCResponseProfileManager.OTHR_HLTH_INS_RESP,
										rmcInPrflSessCargo);
							}
							translatedProfileArray[8] = rmcInPrflSessCargo
									.getOthr_hlth_ins_resp();
							status = (null != rmcInPrflSessCargo
									.getOthr_hlth_ins_resp()) ? (rmcInPrflSessCargo
									.getOthr_hlth_ins_resp().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
							if (status == IRMCResponseProfileManager.STATUS_ADD_NEW
									|| status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
									|| status == IRMCResponseProfileManager.STATUS_REQUIRED) {
								otherHealthInsDetailRequired = true;
							}

							//convicted felon

							if (rmcResponseProfileManager.determineDirtyStatus(
									rmcInPrflPageCargo.getAvoid_prosc_resp(),
									rmcInPrflSessCargo.getAvoid_prosc_resp(),
									cnvtFelonDirtyIndicator, driverStatus)) {
								if (!dirtyIndicatorArray[0]) {
									dirtyIndicatorArray[0] = true;
								}
								dirtyIndicatorArray[Integer
								                    .parseInt(indivSeqNum)] = true;

							}

							if (!rmcInPrflSessCargo
									.getAvoid_prosc_resp()
									.equalsIgnoreCase(
									String.valueOf(ICategorySelectionProfileManager.STATUS_COMPLETE))) {
								rmcResponseProfileManager
								.translateProfileResponses(
										rmcInPrflPageCargo
										.getAvoid_prosc_resp(),
										rmcInPrflSessCargo
										.getAvoid_prosc_resp(),
										driverStatus,
										IRMCResponseProfileManager.AVOID_PROSC_RESP,
										rmcInPrflSessCargo);
							}
							translatedProfileArray[9] = rmcInPrflSessCargo
									.getAvoid_prosc_resp();
							status = (null != rmcInPrflSessCargo
									.getAvoid_prosc_resp()) ? (rmcInPrflSessCargo
									.getAvoid_prosc_resp().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
							if (status == IRMCResponseProfileManager.STATUS_ADD_NEW
									|| status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
									|| status == IRMCResponseProfileManager.STATUS_REQUIRED) {
								cnvtFelonDetailPageRequired = true;
							}
							
							//Traded or sold benefits for drugs after 8/22/96

							if (rmcResponseProfileManager.determineDirtyStatus(
									rmcInPrflPageCargo.getTrading_snap_resp(),
									rmcInPrflSessCargo.getTrading_snap_resp(),
									bnftCnvtnDirtyIndicator, driverStatus)) {
								if (!dirtyIndicatorArray[0]) {
									dirtyIndicatorArray[0] = true;
								}
								dirtyIndicatorArray[Integer
								                    .parseInt(indivSeqNum)] = true;

							}

							if (!rmcInPrflSessCargo
									.getTrading_snap_resp()
									.equalsIgnoreCase(
									String.valueOf(ICategorySelectionProfileManager.STATUS_COMPLETE))) {
								rmcResponseProfileManager
								.translateProfileResponses(
										rmcInPrflPageCargo
										.getTrading_snap_resp(),
										rmcInPrflSessCargo
										.getTrading_snap_resp(),
										driverStatus,
										IRMCResponseProfileManager.TRADING_SNAP_RESP,
										rmcInPrflSessCargo);
							}
							translatedProfileArray[10] = rmcInPrflSessCargo
									.getTrading_snap_resp();
							status = (null != rmcInPrflSessCargo
									.getTrading_snap_resp()) ? (rmcInPrflSessCargo
									.getTrading_snap_resp().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
							if (status == IRMCResponseProfileManager.STATUS_ADD_NEW
									|| status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
									|| status == IRMCResponseProfileManager.STATUS_REQUIRED) {
								bnftCnvtnDetailPageRequired = true;
							}
							
							//Falsified residency or identity after 8/22/96

							if (rmcResponseProfileManager.determineDirtyStatus(
									rmcInPrflPageCargo.getConvic_false_info_resp(),
									rmcInPrflSessCargo.getConvic_false_info_resp(),
									cnvtFaslseInfoDirtyIndicator, driverStatus)) {
								if (!dirtyIndicatorArray[0]) {
									dirtyIndicatorArray[0] = true;
								}
								dirtyIndicatorArray[Integer
								                    .parseInt(indivSeqNum)] = true;

							}

							if (!rmcInPrflSessCargo
									.getConvic_false_info_resp()
									.equalsIgnoreCase(
									String.valueOf(ICategorySelectionProfileManager.STATUS_COMPLETE))) {
								rmcResponseProfileManager
								.translateProfileResponses(
										rmcInPrflPageCargo
										.getConvic_false_info_resp(),
										rmcInPrflSessCargo
										.getConvic_false_info_resp(),
										driverStatus,
										IRMCResponseProfileManager.CONVIC_FALSE_INFO_RESP,
										rmcInPrflSessCargo);
							}
							translatedProfileArray[11] = rmcInPrflSessCargo
									.getConvic_false_info_resp();
							status = (null != rmcInPrflSessCargo
									.getConvic_false_info_resp()) ? (rmcInPrflSessCargo
									.getConvic_false_info_resp().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
							if (status == IRMCResponseProfileManager.STATUS_ADD_NEW
									|| status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
									|| status == IRMCResponseProfileManager.STATUS_REQUIRED) {
								bnftCnvtnDetailPageRequired = true;
							}
							
							//Trafficked benefits of $500 or more after 8/22/96

							if (rmcResponseProfileManager.determineDirtyStatus(
									rmcInPrflPageCargo.getBuy_sell_snap_resp(),
									rmcInPrflSessCargo.getBuy_sell_snap_resp(),
									buySellFsDirtyIndicator, driverStatus)) {
								if (!dirtyIndicatorArray[0]) {
									dirtyIndicatorArray[0] = true;
								}
								dirtyIndicatorArray[Integer
								                    .parseInt(indivSeqNum)] = true;

							}

							if (!rmcInPrflSessCargo
									.getBuy_sell_snap_resp()
									.equalsIgnoreCase(
									String.valueOf(ICategorySelectionProfileManager.STATUS_COMPLETE))) {
								rmcResponseProfileManager
								.translateProfileResponses(
										rmcInPrflPageCargo
										.getBuy_sell_snap_resp(),
										rmcInPrflSessCargo
										.getBuy_sell_snap_resp(),
										driverStatus,
										IRMCResponseProfileManager.BUY_SELL_SNAP_RESP,
										rmcInPrflSessCargo);
							}
							translatedProfileArray[12] = rmcInPrflSessCargo
									.getBuy_sell_snap_resp();
							status = (null != rmcInPrflSessCargo
									.getBuy_sell_snap_resp()) ? (rmcInPrflSessCargo
									.getBuy_sell_snap_resp().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
							if (status == IRMCResponseProfileManager.STATUS_ADD_NEW
									|| status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
									|| status == IRMCResponseProfileManager.STATUS_REQUIRED) {
								bnftCnvtnDetailPageRequired = true;
							}
							
							//Possessed or distributed controlled substance (drugs)

							if (rmcResponseProfileManager.determineDirtyStatus(
									rmcInPrflPageCargo.getDrug_felonies_resp(),
									rmcInPrflSessCargo.getDrug_felonies_resp(),
									drugFelnsDirtyIndicator, driverStatus)) {
								if (!dirtyIndicatorArray[0]) {
									dirtyIndicatorArray[0] = true;
								}
								dirtyIndicatorArray[Integer
								                    .parseInt(indivSeqNum)] = true;

							}

							if (!rmcInPrflSessCargo
									.getDrug_felonies_resp()
									.equalsIgnoreCase(
									String.valueOf(ICategorySelectionProfileManager.STATUS_COMPLETE))) {
								rmcResponseProfileManager
								.translateProfileResponses(
										rmcInPrflPageCargo
										.getDrug_felonies_resp(),
										rmcInPrflSessCargo
										.getDrug_felonies_resp(),
										driverStatus,
										IRMCResponseProfileManager.DRUG_FELONIES_RESP,
										rmcInPrflSessCargo);
							}
							translatedProfileArray[13] = rmcInPrflSessCargo
									.getDrug_felonies_resp();
							status = (null != rmcInPrflSessCargo
									.getDrug_felonies_resp()) ? (rmcInPrflSessCargo
									.getDrug_felonies_resp().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
							if (status == IRMCResponseProfileManager.STATUS_ADD_NEW
									|| status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
									|| status == IRMCResponseProfileManager.STATUS_REQUIRED) {
								bnftCnvtnDetailPageRequired = true;
							}
							
							//Sold or received benefits for firearms, ammunition, or explosives after 8/22/96 

							if (rmcResponseProfileManager.determineDirtyStatus(
									rmcInPrflPageCargo.getTrade_snap_gun_resp(),
									rmcInPrflSessCargo.getTrade_snap_gun_resp(),
									tradeFsGunDirtyIndicator, driverStatus)) {
								if (!dirtyIndicatorArray[0]) {
									dirtyIndicatorArray[0] = true;
								}
								dirtyIndicatorArray[Integer
								                    .parseInt(indivSeqNum)] = true;

							}

							if (!rmcInPrflSessCargo
									.getTrade_snap_gun_resp()
									.equalsIgnoreCase(
									String.valueOf(ICategorySelectionProfileManager.STATUS_COMPLETE))) {
								rmcResponseProfileManager
								.translateProfileResponses(
										rmcInPrflPageCargo
										.getTrade_snap_gun_resp(),
										rmcInPrflSessCargo
										.getTrade_snap_gun_resp(),
										driverStatus,
										IRMCResponseProfileManager.TRADE_SNAP_GUN_RESP,
										rmcInPrflSessCargo);
							}
							translatedProfileArray[14] = rmcInPrflSessCargo
									.getTrade_snap_gun_resp();
							status = (null != rmcInPrflSessCargo
									.getTrade_snap_gun_resp()) ? (rmcInPrflSessCargo
									.getTrade_snap_gun_resp().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
							if (status == IRMCResponseProfileManager.STATUS_ADD_NEW
									|| status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
									|| status == IRMCResponseProfileManager.STATUS_REQUIRED) {
								bnftCnvtnDetailPageRequired = true;
							}
							
							//Used benefits at unauthorized retailer (liquor store, gambling establishments, etc.) after 6/1/12

							if (rmcResponseProfileManager.determineDirtyStatus(
									rmcInPrflPageCargo.getTanf_eppic_resp(),
									rmcInPrflSessCargo.getTanf_eppic_resp(),
									tanfEppicDirtyIndicator, driverStatus)) {
								if (!dirtyIndicatorArray[0]) {
									dirtyIndicatorArray[0] = true;
								}
								dirtyIndicatorArray[Integer
								                    .parseInt(indivSeqNum)] = true;

							}

							if (!rmcInPrflSessCargo
									.getTanf_eppic_resp()
									.equalsIgnoreCase(
									String.valueOf(ICategorySelectionProfileManager.STATUS_COMPLETE))) {
								rmcResponseProfileManager
								.translateProfileResponses(
										rmcInPrflPageCargo
										.getTanf_eppic_resp(),
										rmcInPrflSessCargo
										.getTanf_eppic_resp(),
										driverStatus,
										IRMCResponseProfileManager.TANF_EPPIC_RESP,
										rmcInPrflSessCargo);
							}
							translatedProfileArray[15] = rmcInPrflSessCargo
									.getTanf_eppic_resp();
							status = (null != rmcInPrflSessCargo
									.getTanf_eppic_resp()) ? (rmcInPrflSessCargo
									.getTanf_eppic_resp().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
							if (status == IRMCResponseProfileManager.STATUS_ADD_NEW
									|| status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
									|| status == IRMCResponseProfileManager.STATUS_REQUIRED) {
								bnftCnvtnDetailPageRequired = true;
							}
							
							//Voluntarlity Quit Job

							if (rmcResponseProfileManager.determineDirtyStatus(
									rmcInPrflPageCargo.getVoluntarily_quit_job_resp(),
									rmcInPrflSessCargo.getVoluntarily_quit_job_resp(),
									voluQuitDirtyIndicator, driverStatus)) {
								if (!dirtyIndicatorArray[0]) {
									dirtyIndicatorArray[0] = true;
								}
								dirtyIndicatorArray[Integer
								                    .parseInt(indivSeqNum)] = true;

							}

							if (!rmcInPrflSessCargo
									.getVoluntarily_quit_job_resp()
									.equalsIgnoreCase(
									String.valueOf(ICategorySelectionProfileManager.STATUS_COMPLETE))) {
								rmcResponseProfileManager
								.translateProfileResponses(
										rmcInPrflPageCargo
										.getVoluntarily_quit_job_resp(),
										rmcInPrflSessCargo
										.getVoluntarily_quit_job_resp(),
										driverStatus,
										IRMCResponseProfileManager.VOLUNTARILY_QUIT_JOB_RESP,
										rmcInPrflSessCargo);
							}
							translatedProfileArray[16] = rmcInPrflSessCargo
									.getVoluntarily_quit_job_resp();
							status = (null != rmcInPrflSessCargo
									.getVoluntarily_quit_job_resp()) ? (rmcInPrflSessCargo
									.getVoluntarily_quit_job_resp().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
							if (status == IRMCResponseProfileManager.STATUS_ADD_NEW
									|| status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
									|| status == IRMCResponseProfileManager.STATUS_REQUIRED) {
								bnftCnvtnDetailPageRequired = true;
							}
							
							//Disqualified TANF or FS 

							if (rmcResponseProfileManager.determineDirtyStatus(
									rmcInPrflPageCargo.getTanfDiscResp(),
									rmcInPrflSessCargo.getTanfDiscResp(),
									tanfDiscDirtyIndicator, driverStatus)) {
								if (!dirtyIndicatorArray[0]) {
									dirtyIndicatorArray[0] = true;
								}
								dirtyIndicatorArray[Integer
								                    .parseInt(indivSeqNum)] = true;

							}

							if (!rmcInPrflSessCargo
									.getTanfDiscResp()
									.equalsIgnoreCase(
									String.valueOf(ICategorySelectionProfileManager.STATUS_COMPLETE))) {
								rmcResponseProfileManager
								.translateProfileResponses(
										rmcInPrflPageCargo
										.getTanfDiscResp(),
										rmcInPrflSessCargo
										.getTanfDiscResp(),
										driverStatus,
										IRMCResponseProfileManager.TANF_DISC_RESP,
										rmcInPrflSessCargo);
							}
							translatedProfileArray[17] = rmcInPrflSessCargo
									.getTanfDiscResp();
							status = (null != rmcInPrflSessCargo
									.getTanfDiscResp()) ? (rmcInPrflSessCargo
									.getTanfDiscResp().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
							if (status == IRMCResponseProfileManager.STATUS_ADD_NEW
									|| status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
									|| status == IRMCResponseProfileManager.STATUS_REQUIRED) {
								bnftCnvtnDetailPageRequired = true;
							}
							
							
							indvResponseMap.put(indivSeqNum,
									translatedProfileArray);

							break;
						}
					}
				}
				if (dirtyIndicatorArray[0]) {

					String indvSeqNumber = null;
					for (int i = 0; i < rmcInPrflPageCollectionSize; i++) {
						indvSeqNumber = rmcPrflPageColl.getCargo(i)
								.getIndv_seq_num();
						if (dirtyIndicatorArray[Integer.parseInt(indvSeqNumber)]) {
							rmcResponseProfileManager.persist(appNum,
									indvSeqNumber, responseArray,
									(String[]) indvResponseMap
									.get(indvSeqNumber));
						}
					}
				}
			}

			// Peristence Logic to INDVs
			String[] indivResponseArrayForIndv = null;
			final RMC_IN_PRFL_Collection validationRMCPrflColl = new RMC_IN_PRFL_Collection();
			final Map indivResponseMapForIndv = new HashMap();
			for (int i = 0; i < rmcInPrflSessColl.size(); i++) {
				indivResponseArrayForIndv = new String[16];
				final RMC_IN_PRFL_Cargo sessionCargo = rmcInPrflSessColl
						.getCargo(i);
				final RMC_IN_PRFL_Cargo pageCollCargo = rmcResponseProfileManager
						.getProfile(rmcInPrflPageColl,
								sessionCargo.getIndv_seq_num());
				if (pageCollCargo == null) {
					sessionCargo.setSpecial_need_resp(FwConstants.NO);
					sessionCargo.setFoster_care_resp(FwConstants.NO);
					sessionCargo.setFormer_foster_resp(FwConstants.NO);
					sessionCargo.setChild_protective_resp(FwConstants.NO);
					sessionCargo.setLiving_prog_resp(FwConstants.NO);
					sessionCargo.setGrand_parent_resp(FwConstants.NO);
					sessionCargo.setDrug_felonies_resp(FwConstants.NO);
					sessionCargo.setSnap_tanf_disc_resp(FwConstants.NO);

					sessionCargo.setViolating_parole_resp(FwConstants.NO);
					//sessionCargo.setConvic_false_info_resp(FwConstants.NO);
					//sessionCargo.setTrading_snap_resp(FwConstants.NO);
					//sessionCargo.setBuy_sell_snap_resp(FwConstants.NO);
					//sessionCargo.setTrade_snap_gun_resp(FwConstants.NO);
					sessionCargo.setPrev_ssi_resp(FwConstants.NO);
					sessionCargo.setHome_community_resp(FwConstants.NO);
					sessionCargo.setTribal_health_resp(FwConstants.NO);
					sessionCargo.setTribal_eligibility_resp(FwConstants.NO);
					sessionCargo.setDomestic_violence_resp(FwConstants.NO);
					//sessionCargo.setTanf_eppic_resp(FwConstants.NO);
					sessionCargo.setEmergency_medical_resp(FwConstants.NO);
					sessionCargo.setAvd_prsctn_fstf(FwConstants.NO);
					sessionCargo.setMed_type_katie_beckett(FwConstants.NO);

				} else {
					sessionCargo.setSpecial_need_resp(pageCollCargo
							.getSpecial_need_resp());
					sessionCargo.setFoster_care_resp(pageCollCargo
							.getFoster_care_resp());
					sessionCargo.setFormer_foster_resp(pageCollCargo
							.getFormer_foster_resp());
					sessionCargo.setChild_protective_resp(pageCollCargo
							.getChild_protective_resp());
					sessionCargo.setLiving_prog_resp(pageCollCargo
							.getLiving_prog_resp());
					sessionCargo.setGrand_parent_resp(pageCollCargo
							.getGrand_parent_resp());
					sessionCargo.setDrug_felonies_resp(pageCollCargo
							.getDrug_felonies_resp());
					sessionCargo.setSnap_tanf_disc_resp(pageCollCargo
							.getSnap_tanf_disc_resp());
					sessionCargo.setTanfDiscResp(pageCollCargo
							.getTanfDiscResp());
					/*
					 * VG SONAR Cleanup - 09/1/2015 Deleted 1,1 lines Commented
					 * Code in this block
					 */

					sessionCargo.setViolating_parole_resp(pageCollCargo
							.getViolating_parole_resp());
					/*sessionCargo.setConvic_false_info_resp(pageCollCargo
							.getConvic_false_info_resp());*/
					sessionCargo.setVoluntarily_quit_job_resp(pageCollCargo
							.getVoluntarily_quit_job_resp());
					/*sessionCargo.setTrading_snap_resp(pageCollCargo
							.getTrading_snap_resp());*/
					/*sessionCargo.setBuy_sell_snap_resp(pageCollCargo
							.getBuy_sell_snap_resp());
					sessionCargo.setTrade_snap_gun_resp(pageCollCargo
							.getTrade_snap_gun_resp());*/
					sessionCargo.setPrev_ssi_resp(pageCollCargo
							.getPrev_ssi_resp());
					sessionCargo.setHome_community_resp(pageCollCargo
							.getHome_community_resp());
					sessionCargo.setTribal_health_resp(pageCollCargo
							.getTribal_health_resp());
					sessionCargo.setTribal_eligibility_resp(pageCollCargo
							.getTribal_eligibility_resp());
					sessionCargo.setDomestic_violence_resp(pageCollCargo
							.getDomestic_violence_resp());
					/*sessionCargo.setTanf_eppic_resp(pageCollCargo
							.getTanf_eppic_resp());*/
					sessionCargo.setEmergency_medical_resp(pageCollCargo
							.getEmergency_medical_resp());
					sessionCargo.setAvd_prsctn_fstf(pageCollCargo
							.getAvd_prsctn_fstf());
					sessionCargo.setMed_type_katie_beckett(pageCollCargo
							.getMed_type_katie_beckett());
				}
				indivResponseArrayForIndv[0] = sessionCargo
						.getSpecial_need_resp();
				indivResponseArrayForIndv[1] = sessionCargo
						.getFoster_care_resp();
				indivResponseArrayForIndv[2] = sessionCargo
						.getFormer_foster_resp();
				indivResponseArrayForIndv[3] = sessionCargo
						.getChild_protective_resp();
				indivResponseArrayForIndv[4] = sessionCargo
						.getLiving_prog_resp();
				indivResponseArrayForIndv[5] = sessionCargo
						.getGrand_parent_resp();
				/*indivResponseArrayForIndv[6] = sessionCargo
						.getDrug_felonies_resp();*/
				indivResponseArrayForIndv[6] = sessionCargo
						.getSnap_tanf_disc_resp();

				indivResponseArrayForIndv[7] = sessionCargo
						.getViolating_parole_resp();
				/*indivResponseArrayForIndv[10] = sessionCargo
						.getConvic_false_info_resp();*/
				/*indivResponseArrayForIndv[12] = sessionCargo
						.getTrading_snap_resp();*/
				/*indivResponseArrayForIndv[13] = sessionCargo
						.getBuy_sell_snap_resp();*/
				/*indivResponseArrayForIndv[14] = sessionCargo
						.getTrade_snap_gun_resp();*/
				indivResponseArrayForIndv[8] = sessionCargo.getPrev_ssi_resp();
				indivResponseArrayForIndv[9] = sessionCargo
						.getHome_community_resp();
				indivResponseArrayForIndv[10] = sessionCargo
						.getTribal_health_resp();
				indivResponseArrayForIndv[11] = sessionCargo
						.getTribal_eligibility_resp();
				indivResponseArrayForIndv[12] = sessionCargo
						.getDomestic_violence_resp();
				/*indivResponseArrayForIndv[20] = sessionCargo
						.getTanf_eppic_resp();*/
				indivResponseArrayForIndv[13] = sessionCargo
						.getEmergency_medical_resp();
				indivResponseArrayForIndv[14] = sessionCargo
						.getAvd_prsctn_fstf();
				indivResponseArrayForIndv[15] = sessionCargo
						.getMed_type_katie_beckett();

				indivResponseMapForIndv.put(sessionCargo.getIndv_seq_num(),
						indivResponseArrayForIndv);
				validationRMCPrflColl.addCargo(sessionCargo);
			}
			for (int i = 0; i < rmcInPrflSessColl.size(); i++) {
				final RMC_IN_PRFL_Cargo sessionCargo = rmcInPrflSessColl
						.getCargo(i);
				rmcResponseProfileManager.persist(appNum, sessionCargo
						.getIndv_seq_num(), questionsArrayForIndv,
						(String[]) indivResponseMapForIndv.get(sessionCargo
								.getIndv_seq_num()));
			}

			if (categorySelectionProfile == null
					|| categorySelectionProfile.isEmpty()) {

				categorySelectionProfile = categorySelectionProfileManager
						.buildSelectionProfile(respColl, appNum,
								AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL);
			} else {
				categorySelectionProfileManager.rebuildSelectionProfile(
						categorySelectionProfile, respColl, appNum,
						AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL);
			}

			final Map schlEnrlMap = new HashMap();
			schlEnrlMap.put("SC", "SC");

			/*
			 * VG SONAR Cleanup - 09/1/2015 Deleted 1,2 lines Commented Code in
			 * this block
			 */

			final APP_IN_SCHLE_Collection schColl = (APP_IN_SCHLE_Collection) beforeColl
					.get("APP_IN_SCHLE_Collection");
			peopleHandler.getInHomeIndividuals();
			if (schColl != null && !schColl.isEmpty()) {

					if (schoolEnrlDetailPageRequired
						|| checkExpenseDetailPageRequired(
								categorySelectionProfile, schlEnrlMap)) {
					if (schoolEnrlDetailPageRequired
							|| !categorySelectionProfileManager
							.areAllSequencesComplete(
									categorySelectionProfile,
									schlEnrlMap)) {
						driverManager.makeRequired(FwConstants.RMC_DRIVER,
								"ARHSE", driverArray, appNum);
						driverManager.makeRequired(FwConstants.RMC_DRIVER,
								"AROBS", driverArray, appNum);
					} else {
						driverManager.makeComplete(FwConstants.RMC_DRIVER,
								"ARHSE", driverArray, appNum);
					}
				} else {
					if (!IDriver.DRIVER_STATUS_COMPLETE.equals(driverManager
							.getStatus(FwConstants.RMC_DRIVER, "ARHSE",
									driverArray))) {
						driverManager.makeNotRequired(FwConstants.RMC_DRIVER,
								"ARHSE", driverArray, appNum);
					}
				}
			} else {
				if (schoolEnrlDetailPageRequired) {
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARHSE",
							driverArray, appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
							driverArray, appNum);
				} else {
					if (!IDriver.DRIVER_STATUS_COMPLETE.equals(driverManager
							.getStatus(FwConstants.RMC_DRIVER, "ARHSE",
									driverArray))) {
						driverManager.makeNotRequired(FwConstants.RMC_DRIVER,
								"ARHSE", driverArray, appNum);
					}
				}
			}

			final Map hospStayMap = new HashMap();
			hospStayMap.put("HS", "HS");

			final CP_APP_IN_CARE_PROV_Collection appInCreProcColl = (CP_APP_IN_CARE_PROV_Collection) beforeColl
					.get("APP_IN_CARE_PROV_Collection");
			if (appInCreProcColl != null && !appInCreProcColl.isEmpty()) {
				if (hospStayDetailPageRequired
						|| checkExpenseDetailPageRequired(
								categorySelectionProfile, hospStayMap)) {
					if (hospStayDetailPageRequired
							|| !categorySelectionProfileManager
							.areAllSequencesComplete(
									categorySelectionProfile,
									hospStayMap)) {
						driverManager.makeRequired(FwConstants.RMC_DRIVER,
								"ARHPS", driverArray, appNum);
						driverManager.makeRequired(FwConstants.RMC_DRIVER,
								"AROBS", driverArray, appNum);
					} else {
						driverManager.makeComplete(FwConstants.RMC_DRIVER,
								"ARHPS", driverArray, appNum);
					}
				} else {
					if (!IDriver.DRIVER_STATUS_COMPLETE.equals(driverManager
							.getStatus(FwConstants.RMC_DRIVER, "ARHPS",
									driverArray))) {
						driverManager.makeNotRequired(FwConstants.RMC_DRIVER,
								"ARHPS", driverArray, appNum);
					}
				}

			} else {
				if (hospStayDetailPageRequired) {
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARHPS",
							driverArray, appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
							driverArray, appNum);
				} else {
					if (!IDriver.DRIVER_STATUS_COMPLETE.equals(driverManager
							.getStatus(FwConstants.RMC_DRIVER, "ARHPS",
									driverArray))) {
						driverManager.makeNotRequired(FwConstants.RMC_DRIVER,
								"ARHPS", driverArray, appNum);
					}
				}
			}

			// health care
			final Map hlthCvrgMap = new HashMap();
			hlthCvrgMap.put("HI", "HI"); // For Dependent care
			final APP_MED_INS_Collection healthColl = (APP_MED_INS_Collection) beforeColl
					.get("HEALTHCVRG_COLL");

			if (healthColl != null && !healthColl.isEmpty()) {

				/*
				 * VG SONAR Cleanup - 09/1/2015 Deleted 2 lines Commented Code
				 * in this block
				 */

				if (detailPageRequired
						|| checkExpenseDetailPageRequired(
								categorySelectionProfile, hlthCvrgMap)) {
					if (detailPageRequired
							|| !categorySelectionProfileManager
							.areAllSequencesComplete(
									categorySelectionProfile,
									hlthCvrgMap)) {
						driverManager.makeRequired(FwConstants.RMC_DRIVER,
								"ARHCD", driverArray, appNum);
						driverManager.makeRequired(FwConstants.RMC_DRIVER,
								"AROBS", driverArray, appNum);
					} else {
						driverManager.makeComplete(FwConstants.RMC_DRIVER,
								"ARHCD", driverArray, appNum);
					}
				} else {

					if (!IDriver.DRIVER_STATUS_COMPLETE.equals(driverManager
							.getStatus(FwConstants.RMC_DRIVER, "ARHCD",
									driverArray))) {
						driverManager.makeNotRequired(FwConstants.RMC_DRIVER,
								"ARHCD", driverArray, appNum);
					}
				}
			} else {
				if (detailPageRequired) {
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARHCD",
							driverArray, appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
							driverArray, appNum);
				} else {
					if (!IDriver.DRIVER_STATUS_COMPLETE.equals(driverManager
							.getStatus(FwConstants.RMC_DRIVER, "ARHCD",
									driverArray))) {
						driverManager.makeNotRequired(FwConstants.RMC_DRIVER,
								"ARHCD", driverArray, appNum);
					}
				}
			}

			final CP_APP_IN_CARE_PROV_Collection nursinHomeColl = (CP_APP_IN_CARE_PROV_Collection) beforeColl.get("CP_APP_IN_CARE_PROV_Collection");
			int nurSize = 0;
			if (nursinHomeColl != null) {
				nurSize = nursinHomeColl.size();
			}
			final CP_APP_IN_CARE_PROV_Collection schNursinHomeColl = new CP_APP_IN_CARE_PROV_Collection();
			final CP_APP_IN_CARE_PROV_Collection hosPiceColl = new CP_APP_IN_CARE_PROV_Collection();
			for (int i = 0; i < nurSize; i++) {
				final CP_APP_IN_CARE_PROV_Cargo cargo = nursinHomeColl.getCargo(i);
				if (AppConstants.NURSING_INFORMATION.equalsIgnoreCase(cargo.getCare_type_cd())) {
					schNursinHomeColl.addCargo(cargo);
				} else if (AppConstants.HOSPICE_INFORMATION.equalsIgnoreCase(cargo.getCare_type_cd())) {
					hosPiceColl.addCargo(cargo);
				}
			}

			//Nursing Home Scheduling Starts here
			final Map nursingHomeMap = new HashMap();
			nursingHomeMap.put("NH", "NH");
			if ((schNursinHomeColl != null) && (!schNursinHomeColl.isEmpty())) {
				if (nurHomeDetailPageRequired || checkExpenseDetailPageRequired(categorySelectionProfile, nursingHomeMap)) {
					if (nurHomeDetailPageRequired
							|| !categorySelectionProfileManager.areAllSequencesComplete(categorySelectionProfile, nursingHomeMap)) {
						driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARNUR", driverArray, appNum);
						driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driverArray, appNum);
					} else {
						driverManager.makeComplete(FwConstants.RMC_DRIVER, "ARNUR", driverArray, appNum);
					}
				} else {

					if (!IDriver.DRIVER_STATUS_COMPLETE.equals(driverManager.getStatus(FwConstants.RMC_DRIVER, "ARNUR", driverArray))) {
						driverManager.makeNotRequired(FwConstants.RMC_DRIVER, "ARNUR", driverArray, appNum);
					}
				}
			} else {
				if (nurHomeDetailPageRequired) {
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARNUR", driverArray, appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driverArray, appNum);
				} else {
					if (!IDriver.DRIVER_STATUS_COMPLETE.equals(driverManager.getStatus(FwConstants.RMC_DRIVER, "ARNUR", driverArray))) {
						driverManager.makeNotRequired(FwConstants.RMC_DRIVER, "ARNUR", driverArray, appNum);
					}
				}
			}
			// Nursing Home Schduling Ends here
			//HosPice Scheduling Starts here
			final Map hosPiceHomeMap = new HashMap();
			hosPiceHomeMap.put("HP", "HP");
			if ((hosPiceColl != null) && (!hosPiceColl.isEmpty())) {
				if (hosPiceDetailPageRequired || checkExpenseDetailPageRequired(categorySelectionProfile, hosPiceHomeMap)) {
					if (hosPiceDetailPageRequired
							|| !categorySelectionProfileManager.areAllSequencesComplete(categorySelectionProfile, hosPiceHomeMap)) {
						driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARHOS", driverArray, appNum);
						driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driverArray, appNum);
					} else {
						driverManager.makeComplete(FwConstants.RMC_DRIVER, "ARHOS", driverArray, appNum);
					}
				} else {

					if (!IDriver.DRIVER_STATUS_COMPLETE.equals(driverManager.getStatus(FwConstants.RMC_DRIVER, "ARHOS", driverArray))) {
						driverManager.makeNotRequired(FwConstants.RMC_DRIVER, "ARHOS", driverArray, appNum);
					}
				}
			} else {
				if (hosPiceDetailPageRequired) {
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARHOS", driverArray, appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driverArray, appNum);
				} else {
					if (!IDriver.DRIVER_STATUS_COMPLETE.equals(driverManager.getStatus(FwConstants.RMC_DRIVER, "ARHOS", driverArray))) {
						driverManager.makeNotRequired(FwConstants.RMC_DRIVER, "ARHOS", driverArray, appNum);
					}
				}
			}
			// HosPice Schduling Ends here
			//OutState Scheduling Starts here
			final APP_IN_OUT_ST_BNFT_Collection outStateBnftColl = (APP_IN_OUT_ST_BNFT_Collection) beforeColl.get("APP_IN_OUT_ST_BNFT_Collection");
			final Map outStateMap = new HashMap();
			outStateMap.put("OF", "OF");
			if ((outStateBnftColl != null) && (!outStateBnftColl.isEmpty())) {
				if (outStateDetailPageRequired || checkExpenseDetailPageRequired(categorySelectionProfile, outStateMap)) {
					if (outStateDetailPageRequired || !categorySelectionProfileManager.areAllSequencesComplete(categorySelectionProfile, outStateMap)) {
						driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROFS", driverArray, appNum);
						driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driverArray, appNum);
					} else {
						driverManager.makeComplete(FwConstants.RMC_DRIVER, "AROFS", driverArray, appNum);
					}
				} else {

					if (!IDriver.DRIVER_STATUS_COMPLETE.equals(driverManager.getStatus(FwConstants.RMC_DRIVER, "AROFS", driverArray))) {
						driverManager.makeNotRequired(FwConstants.RMC_DRIVER, "AROFS", driverArray, appNum);
					}
				}
			} else {
				if (outStateDetailPageRequired) {
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROFS", driverArray, appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driverArray, appNum);
				} else {
					if (!IDriver.DRIVER_STATUS_COMPLETE.equals(driverManager.getStatus(FwConstants.RMC_DRIVER, "AROFS", driverArray))) {
						driverManager.makeNotRequired(FwConstants.RMC_DRIVER, "AROFS", driverArray, appNum);
					}
				}
			}
			// OutState Schduling Ends here
			//LostHealth Scheduling Starts here
			final CP_APP_IN_LST_HLTH_INS_Collection lstHealthColl = (CP_APP_IN_LST_HLTH_INS_Collection) beforeColl
					.get("CP_APP_IN_LST_HLTH_INS_Collection");
			final Map lostHealthMap = new HashMap();
			lostHealthMap.put(AppConstants.LOST_HEALTH_INSURANCE, AppConstants.LOST_HEALTH_INSURANCE);
			if (lstHealthColl != null && !lstHealthColl.isEmpty()) {
				if (lostHealthDetailPageRequired
						|| checkExpenseDetailPageRequired(
								categorySelectionProfile, lostHealthMap)) {
					if (lostHealthDetailPageRequired
							|| !categorySelectionProfileManager
							.areAllSequencesComplete(
									categorySelectionProfile,
									lostHealthMap)) {
						driverManager.makeRequired(FwConstants.RMC_DRIVER,
								"ARLHI", driverArray, appNum);
						driverManager.makeRequired(FwConstants.RMC_DRIVER,
								"AROBS", driverArray, appNum);
					} else {
						driverManager.makeComplete(FwConstants.RMC_DRIVER,
								"ARLHI", driverArray, appNum);
					}
				} else {

					if (!IDriver.DRIVER_STATUS_COMPLETE.equals(driverManager
							.getStatus(FwConstants.RMC_DRIVER, "ARLHI",
									driverArray))) {
						driverManager.makeNotRequired(FwConstants.RMC_DRIVER,
								"ARLHI", driverArray, appNum);
					}
				}
			} else  {
				if (lostHealthDetailPageRequired) {
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARLHI", driverArray, appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driverArray, appNum);
				} else {
					if (!IDriver.DRIVER_STATUS_COMPLETE.equals(driverManager.getStatus(FwConstants.RMC_DRIVER, "ARLHI", driverArray))) {
						driverManager.makeNotRequired(FwConstants.RMC_DRIVER, "ARLHI", driverArray, appNum);
					}
				}
			}
			// LostHealth Schduling Ends here
			//Medicare Scheduling Starts here
			final APP_IN_MEDCR_Collection mediCareColl = (APP_IN_MEDCR_Collection) beforeColl.get("APP_IN_MEDCR_Collection");
			final Map medCareMap = new HashMap();
			medCareMap.put("MC", "MC");
			if ((mediCareColl != null) && (!mediCareColl.isEmpty())) {
				if (medicareDetailPageRequired || checkExpenseDetailPageRequired(categorySelectionProfile, medCareMap)) {
					if (medicareDetailPageRequired || !categorySelectionProfileManager.areAllSequencesComplete(categorySelectionProfile, medCareMap)) {
						driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARMED", driverArray, appNum);
						driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driverArray, appNum);
					} else {
						driverManager.makeComplete(FwConstants.RMC_DRIVER, "ARMED", driverArray, appNum);
					}
				} else {

					if (!IDriver.DRIVER_STATUS_COMPLETE.equals(driverManager.getStatus(FwConstants.RMC_DRIVER, "ARMED", driverArray))) {
						driverManager.makeNotRequired(FwConstants.RMC_DRIVER, "ARMED", driverArray, appNum);
					}
				}
			} else {
				if (medicareDetailPageRequired) {
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARMED", driverArray, appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driverArray, appNum);
				} else {
					if (!IDriver.DRIVER_STATUS_COMPLETE.equals(driverManager.getStatus(FwConstants.RMC_DRIVER, "ARMED", driverArray))) {
						driverManager.makeNotRequired(FwConstants.RMC_DRIVER, "ARMED", driverArray, appNum);
					}
				}
			}
			// Medicare Schduling Ends here

			//Health Insurance Scheduling Starts here
			final APP_IN_HLTH_INS_BNFTS_Collection hlthInsColl = (APP_IN_HLTH_INS_BNFTS_Collection) beforeColl
					.get("APP_IN_HLTH_INS_BNFTS_Collection");
			final Map hlthInsMap = new HashMap();
			hlthInsMap.put(AppConstants.HEALTHINS_INFORMATION, AppConstants.HEALTHINS_INFORMATION);
			if ((hlthInsColl != null) && (!hlthInsColl.isEmpty())) {
				if (healthInsDetailPageRequired || checkExpenseDetailPageRequired(categorySelectionProfile, hlthInsMap)) {
					if (healthInsDetailPageRequired || !categorySelectionProfileManager.areAllSequencesComplete(categorySelectionProfile, hlthInsMap)) {
						driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARHIN", driverArray, appNum);
						driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driverArray, appNum);
					} else {
						driverManager.makeComplete(FwConstants.RMC_DRIVER, "ARHIN", driverArray, appNum);
					}
				} else {

					if (!IDriver.DRIVER_STATUS_COMPLETE.equals(driverManager.getStatus(FwConstants.RMC_DRIVER, "ARHIN", driverArray))) {
						driverManager.makeNotRequired(FwConstants.RMC_DRIVER, "ARHIN", driverArray, appNum);
					}
				}
			} else {
				if (healthInsDetailPageRequired) {
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARHIN", driverArray, appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driverArray, appNum);
				} else {
					if (!IDriver.DRIVER_STATUS_COMPLETE.equals(driverManager.getStatus(FwConstants.RMC_DRIVER, "ARHIN", driverArray))) {
						driverManager.makeNotRequired(FwConstants.RMC_DRIVER, "ARHIN", driverArray, appNum);
					}
				}
			}
			// Health Insurance Schduling Ends here
			//other health Insurance scheduling starts here
			final APP_IN_OTHR_HLTH_INS_Collection othrHlthInsColl = (APP_IN_OTHR_HLTH_INS_Collection) beforeColl
					.get("APP_IN_OTHR_HLTH_INS_Collection");
			final Map othrHlthMap = new HashMap();
			othrHlthMap.put(AppConstants.OTHR_HLTH_INS_INFORMATION, AppConstants.OTHR_HLTH_INS_INFORMATION);
			if ((othrHlthInsColl != null) && (!othrHlthInsColl.isEmpty())) {
				if (otherHealthInsDetailRequired || checkExpenseDetailPageRequired(categorySelectionProfile, othrHlthMap)) {
					if (otherHealthInsDetailRequired
							|| !categorySelectionProfileManager.areAllSequencesComplete(categorySelectionProfile, othrHlthMap)) {
						driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROHI", driverArray, appNum);
						driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driverArray, appNum);
					} else {
						driverManager.makeComplete(FwConstants.RMC_DRIVER, "AROHI", driverArray, appNum);
					}
				} else {
					if (!IDriver.DRIVER_STATUS_COMPLETE.equals(driverManager.getStatus(FwConstants.RMC_DRIVER, "AROHI", driverArray))) {
						driverManager.makeNotRequired(FwConstants.RMC_DRIVER, "AROHI", driverArray, appNum);
					}
				}
			} else {
				if (otherHealthInsDetailRequired) {
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROHI", driverArray, appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driverArray, appNum);
				} else {
					if (!IDriver.DRIVER_STATUS_COMPLETE.equals(driverManager.getStatus(FwConstants.RMC_DRIVER, "AROHI", driverArray))) {
						driverManager.makeNotRequired(FwConstants.RMC_DRIVER, "AROHI", driverArray, appNum);
					}
				}
			}
			//other health insurance scheduling ends here
			//convicted felon Scheduling Starts here
			final APP_IN_FELON_DET_Collection felonColl = (APP_IN_FELON_DET_Collection) beforeColl.get("CNVTN_COLL");
			final Map felonMap = new HashMap();
			felonMap.put(AppConstants.CONVICTION, AppConstants.CONVICTION);
			if ((felonColl != null) && (!felonColl.isEmpty())) {
				if (cnvtFelonDetailPageRequired || checkExpenseDetailPageRequired(categorySelectionProfile, felonMap)) {
					if (cnvtFelonDetailPageRequired || !categorySelectionProfileManager.areAllSequencesComplete(categorySelectionProfile, felonMap)) {
						driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARCFN", driverArray, appNum);
						driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driverArray, appNum);
					} else {
						driverManager.makeComplete(FwConstants.RMC_DRIVER, "ARCFN", driverArray, appNum);
					}
				} else {

					if (!IDriver.DRIVER_STATUS_COMPLETE.equals(driverManager.getStatus(FwConstants.RMC_DRIVER, "ARCFN", driverArray))) {
						driverManager.makeNotRequired(FwConstants.RMC_DRIVER, "ARCFN", driverArray, appNum);
					}
				}

			} else {
				if (cnvtFelonDetailPageRequired) {
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARCFN", driverArray, appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driverArray, appNum);
				} else {
					if (!IDriver.DRIVER_STATUS_COMPLETE.equals(driverManager.getStatus(FwConstants.RMC_DRIVER, "ARCFN", driverArray))) {
						driverManager.makeNotRequired(FwConstants.RMC_DRIVER, "ARCFN", driverArray, appNum);
					}
				}
			}
			// convicted felon Schduling Ends here
			
			//Traded or sold benefits for drugs after 8/22/96 Scheduling Starts here
			final APP_IN_BNFT_CNVCTN_Collection bnftCnvtColl = (APP_IN_BNFT_CNVCTN_Collection) beforeColl.get("TSBCNVCTN_COLL");
			if( beforeColl.get("VQJCNVCTN_COLL")!=null)bnftCnvtColl.addAll((APP_IN_BNFT_CNVCTN_Collection) beforeColl.get("VQJCNVCTN_COLL"));
			if( beforeColl.get("DftCNVCTN_COLL")!=null)bnftCnvtColl.addAll((APP_IN_BNFT_CNVCTN_Collection) beforeColl.get("DftCNVCTN_COLL"));
			/*final Map bnftCnvtnMap = new HashMap();
			bnftCnvtnMap.put(AppConstants.CNVCT_TSB, AppConstants.CNVCT_TSB);*/
			final Map catTypes = createCatTypes();
			if ((bnftCnvtColl != null) && (!bnftCnvtColl.isEmpty())) {
				if (bnftCnvtnDetailPageRequired || checkExpenseDetailPageRequired(categorySelectionProfile, catTypes)) {
					if (bnftCnvtnDetailPageRequired || !categorySelectionProfileManager.areAllSequencesComplete(categorySelectionProfile, catTypes)) {
						driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARBCN", driverArray, appNum);
						driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driverArray, appNum);
					} else {
						driverManager.makeComplete(FwConstants.RMC_DRIVER, "ARBCN", driverArray, appNum);
					}
				} else {

					if (!IDriver.DRIVER_STATUS_COMPLETE.equals(driverManager.getStatus(FwConstants.RMC_DRIVER, "ARBCN", driverArray))) {
						driverManager.makeNotRequired(FwConstants.RMC_DRIVER, "ARBCN", driverArray, appNum);
					}
				}

			} else {
				if (bnftCnvtnDetailPageRequired) {
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARBCN", driverArray, appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driverArray, appNum);
				} else {
					if (!IDriver.DRIVER_STATUS_COMPLETE.equals(driverManager.getStatus(FwConstants.RMC_DRIVER, "ARBCN", driverArray))) {
						driverManager.makeNotRequired(FwConstants.RMC_DRIVER, "ARBCN", driverArray, appNum);
					}
				}
			}
			// Traded or sold benefits for drugs after 8/22/96 Schduling Ends here

			driverManager.makeComplete(FwConstants.RMC_DRIVER, "AROBC",
					driverArray, appNum);
			
			// Persist data for APP_INDV_ADDI_INFO
						if ((additionalInfoColl != null) && (!additionalInfoColl.isEmpty())) {
							addiInfoCargo = (APP_INDV_ADDI_INFO_Cargo) additionalInfoColl
									.get(0);
							addiInfoCargo.setApp_num(appNum);
							addiInfoCargo.setIndv_seq_num(FwConstants.ONE);
							final APP_INDV_ADDI_INFO_Collection coll = (APP_INDV_ADDI_INFO_Collection) beforeColl
									.get("APP_INDV_ADDI_INFO_Collection");
							// data already exist
							if ((coll != null) && (!coll.isEmpty())) {
								addiInfoCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
							} else {
								addiInfoCargo.setRowAction(FwConstants.ROWACTION_INSERT);
							}
							APP_INDV_ADDI_INFO_Collection storecollAddIfo = new APP_INDV_ADDI_INFO_Collection();
							storecollAddIfo.addCargo(addiInfoCargo);
							storecollAddIfo.persist(FwConstants.DAO);
						}

						pageCollection.put("APP_INDV_ADDI_INFO_Collection",
								additionalInfoColl);
			
			// Store values in session
			session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER,
					categorySelectionProfile);
			session.put(FwConstants.BEFORE_COLLECTION,
					txnBean.getPageCollection());
			txnBean.setSession(session);

			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::storeOtherBenefitsChangeSelection:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("storeOtherBenefitsChangeSelection");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"storeOtherBenefitsChangeSelection", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.storeOtherBenefitsChangeSelection() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Creates the and load arobc response maps to page collection.
	 *
	 * @param appInPrflColl the app in prfl coll
	 * @param pageCollection the page collection
	 * @param peopleHandler the people handler
	 * @param pageLoad the page load
	 * @param driverStatus the driver status
	 * @return Map
	 */
	private Map createAndLoadAROBCResponseMapsToPageCollection(
			final RMC_IN_PRFL_Collection appInPrflColl,
			final Map pageCollection, final PeopleHandler peopleHandler,
			final boolean pageLoad, final int driverStatus) {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"HouseHoldInfoEJBBean.createAndLoadAROBCResponseMapsToPageCollection() - START");
		try {

			getPeopleCollectionAndUpdateMaps(appInPrflColl, pageCollection,
					peopleHandler, "20033",
					IRMCResponseProfileManager.SPECIAL_NEED, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(appInPrflColl, pageCollection,
					peopleHandler, "20034",
					IRMCResponseProfileManager.FOSTER_CARE_RESP, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(appInPrflColl, pageCollection,
					peopleHandler, "20035",
					IRMCResponseProfileManager.FORMER_FOSTER_RESP, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(appInPrflColl, pageCollection,
					peopleHandler, "20036",
					IRMCResponseProfileManager.CHILD_PROTECTIVE_RESP, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(appInPrflColl, pageCollection,
					peopleHandler, "20037",
					IRMCResponseProfileManager.LIVING_PROG_RESP, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(appInPrflColl, pageCollection,
					peopleHandler, "20038",
					IRMCResponseProfileManager.GRAND_PARENT_RESP, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(appInPrflColl, pageCollection,
					peopleHandler, "20039",
					IRMCResponseProfileManager.DRUG_FELONIES_RESP, pageLoad,
					driverStatus, false);

			getPeopleCollectionAndUpdateMaps(appInPrflColl, pageCollection,
					peopleHandler, "20040",
					IRMCResponseProfileManager.SNAP_TANF_DISC_RESP, pageLoad,
					driverStatus, false);

			getPeopleCollectionAndUpdateMaps(appInPrflColl, pageCollection,
					peopleHandler, "20062",
					IRMCResponseProfileManager.TANF_DISC_RESP, pageLoad,
					driverStatus, false);

			getPeopleCollectionAndUpdateMaps(appInPrflColl, pageCollection,
					peopleHandler, "20041",
					IRMCResponseProfileManager.AVOID_PROSC_RESP, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(appInPrflColl, pageCollection,
					peopleHandler, "20042",
					IRMCResponseProfileManager.VIOLATING_PAROLE_RESP, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(appInPrflColl, pageCollection,
					peopleHandler, "20043",
					IRMCResponseProfileManager.CONVIC_FALSE_INFO_RESP,
					pageLoad, driverStatus, false);
			getPeopleCollectionAndUpdateMaps(appInPrflColl, pageCollection,
					peopleHandler, "20044",
					IRMCResponseProfileManager.VOLUNTARILY_QUIT_JOB_RESP,
					pageLoad, driverStatus, false);
			getPeopleCollectionAndUpdateMaps(appInPrflColl, pageCollection,
					peopleHandler, "20045",
					IRMCResponseProfileManager.TRADING_SNAP_RESP, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(appInPrflColl, pageCollection,
					peopleHandler, "20046",
					IRMCResponseProfileManager.BUY_SELL_SNAP_RESP, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(appInPrflColl, pageCollection,
					peopleHandler, "20047",
					IRMCResponseProfileManager.TRADE_SNAP_GUN_RESP, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(appInPrflColl, pageCollection,
					peopleHandler, "20048",
					IRMCResponseProfileManager.PREV_SSI_RESP, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(appInPrflColl, pageCollection,
					peopleHandler, "20049",
					IRMCResponseProfileManager.HOME_COMMUNITY_RESP, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(appInPrflColl, pageCollection,
					peopleHandler, "20050",
					IRMCResponseProfileManager.TRIBAL_HEALTH_RESP, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(appInPrflColl, pageCollection,
					peopleHandler, "20051",
					IRMCResponseProfileManager.TRIBAL_ELIGIBILITY_RESP,
					pageLoad, driverStatus, false);
			getPeopleCollectionAndUpdateMaps(appInPrflColl, pageCollection,
					peopleHandler, "20052",
					IRMCResponseProfileManager.DOMESTIC_VIOLENCE_RESP,
					pageLoad, driverStatus, false);
			getPeopleCollectionAndUpdateMaps(appInPrflColl, pageCollection,
					peopleHandler, "20053",
					IRMCResponseProfileManager.TANF_EPPIC_RESP, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(appInPrflColl, pageCollection,
					peopleHandler, "20054",
					IRMCResponseProfileManager.EMERGENCY_MEDICAL_RESP,
					pageLoad, driverStatus, false);
			getPeopleCollectionAndUpdateMaps(appInPrflColl, pageCollection,
					peopleHandler, "20016",
					IRMCResponseProfileManager.AVD_PRSCTN_FSTF,
					pageLoad, driverStatus, false);
			getPeopleCollectionAndUpdateMaps(appInPrflColl, pageCollection,
					peopleHandler, "20019",
					IRMCResponseProfileManager.VOLUNTARILY_QUIT_JOB_RESP,
					pageLoad, driverStatus, false);
			getPeopleCollectionAndUpdateMaps(appInPrflColl, pageCollection,
					peopleHandler, "20061",
					IRMCResponseProfileManager.TANF_DISC_RESP,
					pageLoad, driverStatus, false);
			pageCollection.get("PEOPLE_20085");
			getPeopleCollectionAndUpdateMaps(appInPrflColl, pageCollection,
					peopleHandler, "508",
					IRMCResponseProfileManager.KATIE_BECKETT,
					pageLoad, driverStatus, false);

			log(ILog.INFO,
					"HouseHoldInfoEJBBean.createAndLoadAROBCResponseMapsToPageCollection() - END , Time Taken : "
							+ (System.currentTimeMillis() - startTime)
							+ " milliseconds");
			return pageCollection;
			// exit
		} catch (final FwException fe) {
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			final FwException fe = createFwException(this.getClass().getName(),
					"createAndLoadAROBCResponseMapsToPageCollection", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

	}

	/**
	 * Check expense detail page required.
	 *
	 * @param categorySelectionProfile the category selection profile
	 * @param catType the cat type
	 * @return true, if successful
	 */
	public boolean checkExpenseDetailPageRequired(
			final SortedSet categorySelectionProfile, final Map catType) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.checkExpenseDetailPageRequired() - START");

		try {
			boolean isbenefitsPageRequired = false;
			if (categorySelectionProfile != null) {
				// this one form the category selection profile
				final Iterator iter = categorySelectionProfile.iterator();
				CategorySequenceDetail categorySeqDtl = null;
				while (iter.hasNext()) {
					categorySeqDtl = (CategorySequenceDetail) iter.next();
					if (catType != null
							&& catType.get(categorySeqDtl.getCategoryType()) != null
							&& categorySeqDtl.getUserEndSelectionInd() != AppConstants.RMB_NO_CHANGE_SEL_IND) {
						isbenefitsPageRequired = true;
						break;
					}
				}
			}
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean.checkExpenseDetailPageRequired() - END , Time Taken : "
							+ (System.currentTimeMillis() - startTime)
							+ " milliseconds");
			return isbenefitsPageRequired;
		} catch (final FwException fe) {
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			final FwException fe = createFwException(this.getClass().getName(),
					"checkExpenseDetailPageRequired", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
	}

	/**
	 * Health care coverage : Which collects information about individuals who
	 * own a health insurance policy that covers one or more people in the
	 * household - Load and Store methods are newly coded for RMB PCR#40362
	 * Return Void.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 * @throws javax.ejb.EJBException the javax.ejb. ejb exception
	 */
	public void loadHealthCareCoverageDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.loadHealthCareCoverageDetails() - START");

		log(ILog.INFO,
				"RMCOt:RMCOtherBenefitsEJBBean:loadHealthCareCoverageDetails:Start");

		final Map session = txnBean.getSession();
		final Map request = txnBean.getRequest();
		final Map pageCollection = txnBean.getPageCollection();
		String pageId = null;
		String previousPageId = null;
		Map beforeColl = null;
		PeopleHandler peopleHandler = null;
		int[] driverArray = null;
		String appNumber = null;
		int currentPageStatus = 0;

		String indvSeqNumber = null;
		// PCR# 40362 changes: page mode
		String pageMode = FwConstants.NO;
		try {
			peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);
			appNumber = (String) session.get(AppConstants.APP_NUMBER);
			driverArray = (int[]) session.get(FwConstants.RMC_DRIVER);
			pageId = (String) request.get(FwConstants.CURRENT_PAGE_ID);
			currentPageStatus = driverManager.getAFBStatus(
					FwConstants.RMC_DRIVER, pageId, driverArray);
			previousPageId = (String) request.get(FwConstants.PREVIOUS_PAGE_ID);
			final HealthCareCoverageBO healthCvrgBO = new HealthCareCoverageBO();

			// PCR# 40362 Changes for RMB/SMIRF starts here

			// build category selection profile
			SortedSet categorySelectionProfile = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);

			final Map catMappTypes = new HashMap();
			catMappTypes.put(AppConstants.HEALTHCARE_COVERAGE,
					AppConstants.HEALTHCARE_COVERAGE);

			if (currentPageStatus == FwConstants.DRIVER_REQUIRED
					|| currentPageStatus == FwConstants.DRIVER_VISIT_AGAIN
					&& categorySelectionProfileManager.isEmpty(
							categorySelectionProfile, catMappTypes)) {
				categorySelectionProfile = categorySelectionProfileManager
						.loadCategoryChangeSelectionProfile(appNumber,
								AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL);
			} else if (currentPageStatus == FwConstants.DRIVER_COMPLETE
					&& !pageId.equals(previousPageId)
					&& categorySelectionProfileManager.isEmpty(
							categorySelectionProfile, catMappTypes)) {
				categorySelectionProfile = categorySelectionProfileManager
						.loadCategoryChangeSelectionProfile(appNumber,
								AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL);
			}

			RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			previousPageId = (String) request.get(FwConstants.PREVIOUS_PAGE_ID);

			final short[] responseType = new short[] { IRMCResponseProfileManager.HEALTHCARE_COVERAGE };
			SortedSet hlthDetailsProfile = null;
			boolean rnRecordFound = false;
			final String categType = AppConstants.HEALTHCARE_COVERAGE;

			if (!pageId.equals(previousPageId)) {
				hlthDetailsProfile = createPageProfile(
						categorySelectionProfile, rmcInPrflColl, responseType);
				if (currentPageStatus != FwConstants.DRIVER_REQUIRED) {
					/*
					 * VG SONAR Cleanup - 09/1/2015 Deleted 3 lines Commented
					 * Code in this block
					 */

					final APP_MED_INS_Collection hlthColl = healthCvrgBO
							.loadAppMedInsForPE(appNumber);
					final APP_MED_INS_Collection newHlthColl = healthCvrgBO
							.splitHlthCvrgColl(hlthColl,
									AppConstants.RMC_NEW_RECORD_IND);

					if (newHlthColl != null && !newHlthColl.isEmpty()) {
						APP_MED_INS_Cargo appInHlthCvrgCargo = null;
						final int newHlthCollSize = newHlthColl.size();
						rnRecordFound = true;

						for (int i = 0; i < newHlthCollSize; i++) {
							appInHlthCvrgCargo = newHlthColl.getCargo(i);
							categorySelectionProfileManager
							.insertExistingSequenceDetail(
									hlthDetailsProfile, null, null,
									Short.parseShort(appInHlthCvrgCargo
											.getIndv_seq_num()),
											Short.parseShort(appInHlthCvrgCargo
													.getPlcy_seq_num()),
													categType);
						}
					}
				}

				if (currentPageStatus == FwConstants.DRIVER_REQUIRED
						|| currentPageStatus == FwConstants.DRIVER_VISIT_AGAIN) {
					// set the current record indicator to the first one
					categorySelectionProfileManager
					.setCurrentRecordIndToFirst(hlthDetailsProfile);
				}

				if (currentPageStatus == FwConstants.DRIVER_COMPLETE) {
					// set the current record indicator to the end of the detail
					// bean
					categorySelectionProfileManager
					.setCurrentRecordIndToLast(hlthDetailsProfile);
				}
				// create add new sorted set
				// we need to remove the vallues from the session
				session.remove(FwConstants.BEFORE_COLLECTION);
			} else {
				// catAddNewProfile get it from the before collection
				beforeColl = (Map) session.get(FwConstants.BEFORE_COLLECTION);
				hlthDetailsProfile = (SortedSet) beforeColl
						.get(AppConstants.RMC_CATEGORY_PAGE_PRFL);
			}

			IndivTypeSeqBean indivSeqBean = (IndivTypeSeqBean) pageCollection
					.get(FwConstants.DETAIL_KEY_BEAN);
			if (indivSeqBean == null
					&& currentPageStatus == FwConstants.DRIVER_VISIT_AGAIN
					&& !pageId.equals(previousPageId)) {
				indivSeqBean = (IndivTypeSeqBean) session
						.get("Hlth_cvrg_seqBean");
			}
			// if details key bean not null means this bean is comming from the
			// summary page
			if (indivSeqBean != null) {
				final CategorySequenceDetail categorySeqDetail1 = categorySelectionProfileManager
						.getCategorySequenceDetail(
								hlthDetailsProfile,
								Short.parseShort(indivSeqBean.getIndivSeqNum()),
								Short.parseShort(indivSeqBean.getSeqNum()),
								AppConstants.HEALTHCARE_COVERAGE);
				if (categorySeqDetail1 != null) {
					if (categorySeqDetail1.getUserEndSelectionInd() != 1
							&& !rnRecordFound) {
						String userEndIndicator = indivSeqBean.getUserEndInd();
						if (userEndIndicator == null) {
							userEndIndicator = FwConstants.ZERO;
						}
						categorySelectionProfileManager
						.updateUserEndSelInd(hlthDetailsProfile,
								appNumber, Short
								.parseShort(indivSeqBean
										.getIndivSeqNum()),
										Short.parseShort(indivSeqBean
												.getSeqNum()),
												AppConstants.HEALTHCARE_COVERAGE, Short
												.parseShort(userEndIndicator));
					}
					categorySelectionProfileManager.makeSequenceDetailRequired(
							hlthDetailsProfile, null,
							Short.parseShort(indivSeqBean.getIndivSeqNum()),
							Short.parseShort(indivSeqBean.getSeqNum()),
							AppConstants.HEALTHCARE_COVERAGE);
					final CategorySequenceDetail categorySeqDetail2 = categorySelectionProfileManager
							.getCategorySequenceDetail(
									categorySelectionProfile, Short
									.parseShort(indivSeqBean
											.getIndivSeqNum()), Short
											.parseShort(indivSeqBean
													.getSeqNum()),
													AppConstants.HEALTHCARE_COVERAGE);
					if (categorySeqDetail2 != null) {
						if (categorySeqDetail2.getUserEndSelectionInd() != 1
								&& !rnRecordFound) {
							String userEndIndicator = indivSeqBean
									.getUserEndInd();
							if (userEndIndicator == null) {
								userEndIndicator = FwConstants.ZERO;
							}
							categorySelectionProfileManager
							.updateUserEndSelInd(
									categorySelectionProfile,
									appNumber, Short
									.parseShort(indivSeqBean
											.getIndivSeqNum()),
											Short.parseShort(indivSeqBean
													.getSeqNum()),
													AppConstants.HEALTHCARE_COVERAGE,
													Short.parseShort(userEndIndicator));
						}
						categorySelectionProfileManager
						.makeSequenceDetailRequired(
								categorySelectionProfile, appNumber,
								Short.parseShort(indivSeqBean
										.getIndivSeqNum()), Short
										.parseShort(indivSeqBean
												.getSeqNum()),
												AppConstants.HEALTHCARE_COVERAGE);
					}
				} else {
					if (FwConstants.ZERO.equals(indivSeqBean.getSeqNum())) {
						if (AppConstants.ADD_SCHOOL_ENROLLMENT
								.equals(indivSeqBean.getType())) {
							// first we are checking rnc in profile exists in
							// the sess
							RMC_IN_PRFL_Cargo rmcInPrflCargo = null;
							if (rmcInPrflColl != null) {
								rmcInPrflCargo = rmcResponseProfileManager
										.getProfile(rmcInPrflColl,
												indivSeqBean.getIndivSeqNum());
							} else {
								rmcInPrflColl = new RMC_IN_PRFL_Collection();
							}
							if (rmcInPrflCargo == null) {
								rmcInPrflCargo = new RMC_IN_PRFL_Cargo();
								rmcInPrflCargo.setApp_num(appNumber);
								rmcInPrflCargo.setIndv_seq_num(indivSeqBean
										.getIndivSeqNum());
								rmcResponseProfileManager
								.createRMCIndividualProfile(rmcInPrflCargo);
								rmcInPrflColl.addCargo(rmcInPrflCargo);
							}
							// now we need to make required the MAPP page
							rmcResponseProfileManager
							.makeAddNew(
									IRMCResponseProfileManager.HEALTHCARE_COVERAGE,
									rmcInPrflCargo, true);
							/*
							 * VG SONAR Cleanup - 09/1/2015 Deleted 1 loooonng
							 * lines Commented Code in this block
							 */

							CategorySequenceDetail catseqDet = null;
							if (!hlthDetailsProfile.isEmpty()) {
								catseqDet = categorySelectionProfileManager
										.getCategorySequenceDetail(
												hlthDetailsProfile,
												Short.parseShort(indivSeqBean
														.getIndivSeqNum()),
														(short) 0,
														AppConstants.HEALTHCARE_COVERAGE);
							}

							if (catseqDet == null) {
								categorySelectionProfileManager
								.insertSequenceDetail(
										hlthDetailsProfile,
										null,
										null,
										Short.parseShort(indivSeqBean
												.getIndivSeqNum()),
												AppConstants.HEALTHCARE_COVERAGE);
							}
						} else {

							if (AppConstants.RMC_MODIFIED_RECORD_IND
									.equals(indivSeqBean.getType())
									|| AppConstants.CWW_RECORD_IND
									.equals(indivSeqBean.getType())) {
								boolean sErowExists = false;
								if (categorySelectionProfileManager != null) {
									final Iterator iter = categorySelectionProfile
											.iterator();
									CategorySequenceDetail catSeqDetail = null;
									while (iter.hasNext()) {
										catSeqDetail = (CategorySequenceDetail) iter
												.next();
										if (catSeqDetail != null) {
											if (catSeqDetail
													.getIndividualSequence() == Short
													.parseShort(indivSeqBean
															.getIndivSeqNum())
															&& AppConstants.HEALTHCARE_COVERAGE
															.equals(catSeqDetail
																	.getCategoryType()
																	.trim())
																	&& AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL
															.equals(catSeqDetail
																			.getChangeSelectionCategoryCd())) {
												sErowExists = true;
												break;
											}
										}

									}
								}
								if (sErowExists) {
									categorySelectionProfileManager
									.removeSequenceDetail(
											categorySelectionProfile,
											appNumber,
											Short.parseShort(indivSeqBean
													.getIndivSeqNum()),
													(short) 0,
													AppConstants.HEALTHCARE_COVERAGE);
								}
								categorySelectionProfileManager
								.insertSequenceDetail(
										categorySelectionProfile,
										appNumber,
										AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL,
										Short.parseShort(indivSeqBean
												.getIndivSeqNum()),
												AppConstants.HEALTHCARE_COVERAGE);
								categorySelectionProfileManager
								.makeSequenceDetailRequired(
										categorySelectionProfile,
										appNumber,
										Short.parseShort(indivSeqBean
												.getIndivSeqNum()),
												Short.parseShort(indivSeqBean
														.getSeqNum()),
														AppConstants.HEALTHCARE_COVERAGE);

								SortedSet pregAddSortedSet = null;
								final String[] catTypePregAdd = { AppConstants.HEALTHCARE_COVERAGE };
								pregAddSortedSet = createPageProfile(
										categorySelectionProfile,
										catTypePregAdd);
								CategorySequenceDetail catseqDet = null;
								if (!hlthDetailsProfile.isEmpty()) {
									catseqDet = categorySelectionProfileManager
											.getCategorySequenceDetail(
													hlthDetailsProfile,
													Short.parseShort(indivSeqBean
															.getIndivSeqNum()),
															(short) 0,
															AppConstants.HEALTHCARE_COVERAGE);
								}
								if (catseqDet != null) {
									categorySelectionProfileManager
									.removeSequenceDetail(
											hlthDetailsProfile,
											null,
											Short.parseShort(indivSeqBean
													.getIndivSeqNum()),
													(short) 0,
													AppConstants.HEALTHCARE_COVERAGE);
									hlthDetailsProfile.addAll(pregAddSortedSet);
								} else {
									hlthDetailsProfile.addAll(pregAddSortedSet);
								}

							} else {
								CategorySequenceDetail catseqDet = null;
								if (!hlthDetailsProfile.isEmpty()) {
									catseqDet = categorySelectionProfileManager
											.getCategorySequenceDetail(
													hlthDetailsProfile,
													Short.parseShort(indivSeqBean
															.getIndivSeqNum()),
															(short) 0,
															AppConstants.HEALTHCARE_COVERAGE);
								}
								if (catseqDet != null) {
									categorySelectionProfileManager
									.removeSequenceDetail(
											hlthDetailsProfile,
											null,
											Short.parseShort(indivSeqBean
													.getIndivSeqNum()),
													(short) 0,
													AppConstants.HEALTHCARE_COVERAGE);
									categorySelectionProfileManager
									.insertSequenceDetail(
											hlthDetailsProfile,
											null,
											null,
											Short.parseShort(indivSeqBean
													.getIndivSeqNum()),
													AppConstants.HEALTHCARE_COVERAGE);
								} else {
									categorySelectionProfileManager
									.insertSequenceDetail(
											hlthDetailsProfile,
											null,
											null,
											Short.parseShort(indivSeqBean
													.getIndivSeqNum()),
													AppConstants.HEALTHCARE_COVERAGE);
								}

							}
						}

						session.put(AppConstants.RMC_IN_PRFL_MASTER,
								rmcInPrflColl);
						session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER,
								categorySelectionProfile);

					} else {
						String userEndInd = indivSeqBean.getUserEndInd();
						if (userEndInd == null) {
							userEndInd = FwConstants.ZERO;
						}
						categorySelectionProfileManager
						.insertExistingSequenceDetail(
								hlthDetailsProfile,
								null,
								AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL,
								Short.parseShort(indivSeqBean
										.getIndivSeqNum()), Short
										.parseShort(indivSeqBean
												.getSeqNum()),
												indivSeqBean.getType(), Short
												.parseShort(userEndInd));
						categorySelectionProfileManager
						.makeSequenceDetailRequired(hlthDetailsProfile,
								null, Short.parseShort(indivSeqBean
										.getIndivSeqNum()), Short
										.parseShort(indivSeqBean
												.getSeqNum()),
												indivSeqBean.getType());

						categorySelectionProfileManager
						.insertExistingSequenceDetail(
								categorySelectionProfile,
								appNumber,
								AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL,
								Short.parseShort(indivSeqBean
										.getIndivSeqNum()), Short
										.parseShort(indivSeqBean
												.getSeqNum()),
												indivSeqBean.getType(), Short
												.parseShort(userEndInd));
						categorySelectionProfileManager
						.makeSequenceDetailRequired(
								categorySelectionProfile, appNumber,
								Short.parseShort(indivSeqBean
										.getIndivSeqNum()), Short
										.parseShort(indivSeqBean
												.getSeqNum()),
												indivSeqBean.getType());
					}
				}
				session.put("SchoolEnrl_IndSeqBean", indivSeqBean);
			}
			pageCollection.put(AppConstants.RMC_CATEGORY_PAGE_PRFL,
					hlthDetailsProfile);

			CategorySequenceDetail categorySeqDetail = categorySelectionProfileManager
					.getCurrentSequenceDetail(hlthDetailsProfile);
			if (categorySeqDetail == null) {
				categorySeqDetail = categorySelectionProfileManager
						.getNextSequenceDetail(hlthDetailsProfile);
			}

			categorySeqDetail.getCategoryType();
			final String categorySeqNum = Long.toString(categorySeqDetail
					.getCategorySequence());

			indvSeqNumber = Short.toString(categorySeqDetail
					.getIndividualSequence());

			final APP_MED_INS_Collection appInMedCvrgColl = healthCvrgBO
					.loadAppMedIns(appNumber, indvSeqNumber, categorySeqNum);

			pageCollection.put("APP_MED_INS_Collection", appInMedCvrgColl);

			APP_MED_INS_Cargo cwwHlthCvrgCargo = healthCvrgBO
					.splitHlthCvrgCargo(appInMedCvrgColl,
							AppConstants.CWW_RECORD_IND);

			if (cwwHlthCvrgCargo == null) {
				cwwHlthCvrgCargo = new APP_MED_INS_Cargo();
			}
			pageCollection.put("SEC_HLTH",
					healthCvrgBO.settingDefaultValues(cwwHlthCvrgCargo));

			APP_MED_INS_Cargo rmcHlthCvrgCargo = healthCvrgBO
					.splitHlthCvrgCargo(appInMedCvrgColl,
							AppConstants.RMC_NEW_RECORD_IND);
			if (rmcHlthCvrgCargo != null) {
				pageCollection.put("FST_HLTH",
						healthCvrgBO.settingDefaultValues(rmcHlthCvrgCargo));
			} else {
				rmcHlthCvrgCargo = healthCvrgBO.splitHlthCvrgCargo(
						appInMedCvrgColl, AppConstants.RMC_MODIFIED_RECORD_IND);
				if (rmcHlthCvrgCargo != null) {
					pageCollection
					.put("FST_HLTH", healthCvrgBO
							.settingDefaultValues(rmcHlthCvrgCargo));
				} else {
					pageCollection
					.put("FST_HLTH", healthCvrgBO
							.settingDefaultValues(cwwHlthCvrgCargo));
				}

			}

			String srcAppInd = FwConstants.EMPTY_STRING;

			if (appInMedCvrgColl != null && !appInMedCvrgColl.isEmpty()) {
				final APP_MED_INS_Cargo appHlthCvrgCargo = appInMedCvrgColl
						.getCargo(0);
				srcAppInd = appHlthCvrgCargo.getSrc_app_ind();
			}

			if (("CW".equalsIgnoreCase(srcAppInd) || "RM"
					.equalsIgnoreCase(srcAppInd))
					&& categorySeqDetail.getUserEndSelectionInd() == 0) {
				pageMode = "C";
			}

			if (categorySeqDetail.getUserEndSelectionInd() == 1) // categorySeqDetail.getUserEndSelectionInd()==
				// 1)
				// userEndInd.equals(FwConstants.ONE)
			{
				pageMode = "E";
			} else if (indivSeqBean != null
					&& indivSeqBean.getUserEndInd() != null) {
				if (FwConstants.ONE.equalsIgnoreCase(indivSeqBean
						.getUserEndInd())) // categorySeqDetail.getUserEndSelectionInd()==
				// 1)
				// userEndInd.equals(FwConstants.ONE)
				{
					pageMode = "E";
				} else if (FwConstants.ZERO
						.equals(indivSeqBean.getUserEndInd())
						&& "RM".equalsIgnoreCase(srcAppInd)
						|| "CW".equalsIgnoreCase(srcAppInd)) {
					pageMode = "C";
				} else {
					pageMode = FwConstants.NO;
				}
			} else if (!("C".equals(pageMode) || "E".equals(pageMode))) {
				pageMode = FwConstants.NO;
			}
			CP_APP_IN_MED_INS_CVRG_Collection reMedCvrgColl = null;

			// ESDP - CP Start Insured Policy person box
			if (appInMedCvrgColl != null && !appInMedCvrgColl.isEmpty()) {
				final APP_MED_INS_Cargo insMedCvrgCargo = appInMedCvrgColl
						.getCargo(0);
				/*
				 * VG SONAR Cleanup - 09/1/2015 Deleted 1 lines Commented Code
				 * in this block
				 */

				final String indSeqNum = insMedCvrgCargo.getIndv_seq_num();
				insMedCvrgCargo.getSrc_app_ind();
				if (insMedCvrgCargo.getSeq_num() != null) {
					final CP_APP_IN_MED_INS_CVRG_Collection cpAppMedCvrgColl = healthCvrgBO
							.loadHealthCarePolicyCoverageIndv((String) session
									.get(AppConstants.APP_NUMBER), indSeqNum,
									insMedCvrgCargo.getPlcy_seq_num());
					if (cpAppMedCvrgColl != null && !cpAppMedCvrgColl.isEmpty()) {
						pageCollection.put("CP_APP_IN_MED_INS_CVRG_Collection",
								cpAppMedCvrgColl);

						CP_APP_IN_MED_INS_CVRG_Collection cwwCpAppMedCvrgColl = healthCvrgBO
								.splitMedCvrgCargo(cpAppMedCvrgColl,
										AppConstants.CWW_RECORD_IND);
						if (cwwCpAppMedCvrgColl == null) {
							cwwCpAppMedCvrgColl = new CP_APP_IN_MED_INS_CVRG_Collection();

						}

						pageCollection.put("SEC_MEDCVRG", cwwCpAppMedCvrgColl);

						CP_APP_IN_MED_INS_CVRG_Collection rnMedCvrgColl = healthCvrgBO
								.splitMedCvrgCargo(cpAppMedCvrgColl);
						reMedCvrgColl = healthCvrgBO.splitMedCvrgCargo(
								cpAppMedCvrgColl,
								AppConstants.RMC_END_RECORD_IND);

						if (null!=rnMedCvrgColl && !rnMedCvrgColl.isEmpty()) {

							pageCollection.put("FST_MEDCVRG", rnMedCvrgColl);
						} else {
							rnMedCvrgColl = healthCvrgBO.splitMedCvrgCargo(
									cpAppMedCvrgColl,
									AppConstants.RMC_NEW_RECORD_IND);
							if (null!=rnMedCvrgColl && !rnMedCvrgColl.isEmpty()) {
								pageCollection
								.put("FST_MEDCVRG", rnMedCvrgColl);
							} else {

								pageCollection.put("FST_MEDCVRG",
										cwwCpAppMedCvrgColl);

							}
						}
					}
				}
			}
			// This code is added by EDSP- Team for populating check boxes
			CP_APP_IN_MED_INS_CVRG_Collection cvrgColl = null;
			CP_APP_IN_MED_INS_CVRG_Collection cwCvrgColl = null;
			cvrgColl = (CP_APP_IN_MED_INS_CVRG_Collection) pageCollection
					.get("FST_MEDCVRG");
			cwCvrgColl = (CP_APP_IN_MED_INS_CVRG_Collection) pageCollection
					.get("SEC_MEDCVRG");

			if (reMedCvrgColl != null && !reMedCvrgColl.isEmpty()) {
				for (int i = 0; i < reMedCvrgColl.size(); i++) {
					final CP_APP_IN_MED_INS_CVRG_Cargo cwCargo = reMedCvrgColl
							.getCargo(i);
					final CP_APP_IN_MED_INS_CVRG_Cargo matchingCargo = healthCvrgBO
							.getMatchingCargo(cvrgColl, cwCargo);

					if (matchingCargo != null) {
						cvrgColl.remove(matchingCargo);
						cvrgColl.addCargo(cwCargo);
					}

				}
				pageCollection.put("FST_MEDCVRG", cvrgColl);
			}

			final INDIVIDUAL_Custom_Collection indvCustColl = peopleHandler
					.sortIndividuals(peopleHandler.getInHomeIndividuals());
			if (indvCustColl != null && !indvCustColl.isEmpty()) {
				final Map coverageMap = new HashMap();
				for (int i = 0; i < indvCustColl.size(); i++) {
					final INDIVIDUAL_Custom_Cargo custCargo = indvCustColl
							.getResult(i);
					coverageMap.put(custCargo.getIndv_seq_num(),
							FwConstants.SPACE);
					if (cvrgColl != null && !cvrgColl.isEmpty()) {
						for (int j = 0; j < cvrgColl.size(); j++) {
							final CP_APP_IN_MED_INS_CVRG_Cargo cvrgCargo = cvrgColl
									.getCargo(j);
							if (!"RE".equals(cvrgCargo.getSrc_app_ind())
									&& custCargo.getIndv_seq_num()
									.equals(cvrgCargo
											.getCovered_indv_seq_num())) {
								coverageMap.remove(cvrgCargo
										.getCovered_indv_seq_num());
								coverageMap.put(custCargo.getIndv_seq_num(),
										"R");
							}
						}
					}
				}
				pageCollection.put("coverageMap", coverageMap);
			}

			if (indvCustColl != null && !indvCustColl.isEmpty()) {
				final Map cwCoverageMap = new HashMap();
				for (int i = 0; i < indvCustColl.size(); i++) {
					final INDIVIDUAL_Custom_Cargo custCargo = indvCustColl
							.getResult(i);
					cwCoverageMap.put(custCargo.getIndv_seq_num(),
							FwConstants.SPACE);
					if (cwCvrgColl != null && !cwCvrgColl.isEmpty()) {
						for (int j = 0; j < cwCvrgColl.size(); j++) {
							final CP_APP_IN_MED_INS_CVRG_Cargo cvrgCargo = cwCvrgColl
									.getCargo(j);
							if (custCargo.getIndv_seq_num().equals(
									cvrgCargo.getCovered_indv_seq_num())) {
								cwCoverageMap.remove(cvrgCargo
										.getCovered_indv_seq_num());
								cwCoverageMap.put(custCargo.getIndv_seq_num(),
										"R");
							}
						}
					}
				}
				pageCollection.put("cwCoverageMap", cwCoverageMap);
			}

			// Get the Individuals in the house hold exclude the HLT Insurance
			// Owner to Show the list of the household member to select whoever
			// is covered in the Insurance
			final INDIVIDUAL_Custom_Collection inHomeIndividuals = peopleHandler
					.getInHomeIndividuals();
			for (final Object inHomeIndivObject : inHomeIndividuals) {
				final INDIVIDUAL_Custom_Cargo inHomeIndiv = (INDIVIDUAL_Custom_Cargo) inHomeIndivObject;
				if (inHomeIndiv.getIndv_seq_num().equals(indvSeqNumber)) {
					inHomeIndividuals.remove(inHomeIndiv);
					break;
				}
			}
			pageCollection.put("HOUSEHOLD_INDIV_COVERAGE_AVAILABLE",
					inHomeIndividuals);
			// set the passed response map = new map
			final Map questionRespMap = new HashMap();
			pageCollection
			.put("HOUSEHOLD_INDIV_COVERAGED_MAP", questionRespMap);
			// Code end by added by EDSP- CP team for populating check boxes

			pageCollection.put("CP_APP_IN_MED_INS_CVRG_Collection", cvrgColl);
			pageCollection.put("PAGE_MODE", pageMode);

			// set first name to page collection
			peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);
			pageCollection.put(AppConstants.FIRST_NAME,
					peopleHandler.getFirstName(indvSeqNumber));

			peopleHandler.getIndividual(indvSeqNumber);

			pageCollection.put(AppConstants.INDV_SEQUENCE_NUMBERS,
					indvSeqNumber);
			pageCollection.put(AppConstants.CURRENT_INDIV_SEQ_NUM,
					indvSeqNumber);
			// PCR 30421 - Added first name to the pagecollection to use in JSP
			pageCollection.put(AppConstants.FIRST_NAME,
					peopleHandler.getFirstName(indvSeqNumber));
			txnBean.setPageCollection(pageCollection);
			beforeColl = (Map) session.get(FwConstants.BEFORE_COLLECTION);
			// Calling Component Manager for Page components
			componentManager.getComponents(pageId, txnBean);
			// Checking for Before Collection is Null
			if (beforeColl == null) {
				beforeColl = new HashMap();
			}

			beforeColl.putAll(pageCollection);
			session.put(FwConstants.BEFORE_COLLECTION, beforeColl);

			log(ILog.INFO,
					"RMCHouseHoldInfoEJBBean::loadHealthCareCoverageDetails:END");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("loadHealthCareCoverageDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"loadHealthCareCoverageDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.loadHealthCareCoverageDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Store health care coverage details.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void storeHealthCareCoverageDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.storeHealthCareCoverageDetails() - START");

		String appNumber = null;
		try {
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::storeHealthCareCoverageDetails:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();

			final String currentPageID = (String) request
					.get(FwConstants.CURRENT_PAGE_ID);
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);
			appNumber = (String) session.get(AppConstants.APP_NUMBER);
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			driverManager.getAFBStatus(FwConstants.RMC_DRIVER, currentPageID,
					driverArray);
			final HealthCareCoverageBO helthCareBO = new HealthCareCoverageBO();
			// build category selection profile
			final SortedSet categorySelectionProfile = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			final SortedSet hlthCvrgProfile = (SortedSet) beforeColl
					.get(AppConstants.RMC_CATEGORY_PAGE_PRFL);
			final APP_MED_INS_Collection appMedInsColl = (APP_MED_INS_Collection) pageCollection
					.get("APP_MED_INS_Collection");
			/*
			 * VG SONAR Cleanup - 09/1/2015 Deleted 2,2 lines Commented Code in
			 * this block
			 */

			APP_MED_INS_Cargo appMedInsCargo = appMedInsColl.getCargo(0);
			final PeopleHandler peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);
			final CP_APP_IN_MED_INS_CVRG_Collection cpAppInMedInsCvrgColl = (CP_APP_IN_MED_INS_CVRG_Collection) pageCollection
					.get("CP_APP_IN_MED_INS_CVRG_Collection");
			final CP_APP_IN_MED_INS_CVRG_Collection cpAppInMedInsCvrgBeforeColl = (CP_APP_IN_MED_INS_CVRG_Collection) beforeColl
					.get("CP_APP_IN_MED_INS_CVRG_Collection");
			final CP_APP_IN_MED_INS_CVRG_Collection cpAppInMedInsCvrgCWColl = (CP_APP_IN_MED_INS_CVRG_Collection) beforeColl
					.get("SEC_MEDCVRG");

			final RMC_IN_PRFL_Collection sessionAppInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			final APP_MED_INS_Collection appMedInsBeforeColl = (APP_MED_INS_Collection) beforeColl
					.get("APP_MED_INS_Collection");

			final CategorySequenceDetail categorySeqDetailBean = categorySelectionProfileManager
					.getCurrentSequenceDetail(hlthCvrgProfile);
			final short userEndInd = categorySeqDetailBean
					.getUserEndSelectionInd();
			categorySeqDetailBean.getCategoryType();

			APP_MED_INS_Cargo appMedInsBeforeCargo = null;
			beforeColl.get("APP_PRFL_Cargo");
			appMedInsCargo.getPlcy_hold_seq_num();

			beforeColl.get(AppConstants.POLICY_HOLDER_STATUS);

			final String backToMyAccess = (String) request
					.get(AppConstants.BACK_TO_MY_ACCESS_BUTTON);

			final String indvSeqNum = String.valueOf(categorySeqDetailBean
					.getIndividualSequence());
			helthCareBO.validateRMBPolicyHolder(appMedInsCargo,
					cpAppInMedInsCvrgColl, peopleHandler, indvSeqNum);

			if (checkBackToMyAccessSelected(request)
					|| helthCareBO.hasMessages()) {

				if (backToMyAccess == null) {
					request.put(FwConstants.MESSAGE_LIST,
							helthCareBO.getMessageList());
				}

				pageCollection.put(AppConstants.POLICY_HOLDER_STATUS,
						beforeColl.get(AppConstants.POLICY_HOLDER_STATUS));
				pageCollection.put("APP_MED_INS_Collection", appMedInsColl);

				pageCollection.put("CP_APP_IN_MED_INS_CVRG_Collection",
						cpAppInMedInsCvrgColl);
				// put the first Name into request to avoid null pointer in JSP
				pageCollection.put(AppConstants.FIRST_NAME,
						beforeColl.get(AppConstants.FIRST_NAME));
				pageCollection.put("ShowLoopingQuestionFlag",
						beforeColl.get("ShowLoopingQuestionFlag"));
				pageCollection.put(FwConstants.PAGE_COMPONENT_LIST,
						beforeColl.get(FwConstants.PAGE_COMPONENT_LIST));
				pageCollection.put("PAGE_MODE", beforeColl.get("PAGE_MODE"));
				pageCollection
				.put("coverageMap", beforeColl.get("coverageMap"));
				pageCollection.put("cwCoverageMap",
						beforeColl.get("cwCoverageMap"));
				if (beforeColl.containsKey("SEC_HLTH")) {
					pageCollection.put("SEC_HLTH", beforeColl.get("SEC_HLTH"));
				}
				pageCollection.put("FST_HLTH", appMedInsCargo);
				if (beforeColl.containsKey("FST_MEDCVRG")) {
					pageCollection.put("FST_MEDCVRG",
							beforeColl.get("FST_MEDCVRG"));
				}
				if (beforeColl.containsKey("SEC_MEDCVRG")) {
					pageCollection.put("SEC_MEDCVRG",
							beforeColl.get("SEC_MEDCVRG"));
				}

				return;
			}
			FwProgramManager.getInstance();
			appMedInsCargo.setApp_num((String) session
					.get(AppConstants.APP_NUMBER));

			// EDSP ADDED
			// //////////////////////////////////////////////////////
			appMedInsCargo.setApp_num((String) session
					.get(AppConstants.APP_NUMBER));
			if (appMedInsCargo.getPlcy_hold_seq_num() == null
					|| appMedInsCargo.getPlcy_hold_seq_num().length() == 0) {
				appMedInsCargo.setPlcy_hold_seq_num(FwConstants.ZERO);
			}
			if (appMedInsCargo.getIndv_seq_num() == null
					|| appMedInsCargo.getIndv_seq_num().length() == 0) {
				appMedInsCargo.setIndv_seq_num(FwConstants.ZERO);
			}

			if (appMedInsCargo.getPlcy_seq_num() == null
					|| appMedInsCargo.getPlcy_seq_num().length() == 0) {
				appMedInsCargo.setPlcy_seq_num(FwConstants.ZERO);
			}
			if (appMedInsCargo.getPremium_amt() == null
					|| appMedInsCargo.getPremium_amt().length() == 0
					|| "0.00".equals(appMedInsCargo.getPremium_amt())) {
				appMedInsCargo.setPremium_amt(FwConstants.ZERO);
			}

			if (appMedInsCargo.getCvrg_beg_dt() == null
					|| appMedInsCargo.getCvrg_beg_dt().trim().length() == 0) {
				appMedInsCargo.setCvrg_beg_dt(AppConstants.LOW_DATE);
			} else {
				final StringBuilder dateConverter = new StringBuilder();
				final String sAppDate = appMedInsCargo.getCvrg_beg_dt();
				dateConverter.append(sAppDate.substring(6, 10)).append("-")
				.append(sAppDate.substring(0, 2)).append("-")
				.append(sAppDate.substring(3, 5));
				appMedInsCargo.setCvrg_beg_dt(dateConverter.toString());
			}
			if (appMedInsCargo.getCvrg_end_dt() == null
					|| appMedInsCargo.getCvrg_end_dt().trim().length() == 0) {
				appMedInsCargo.setCvrg_end_dt(AppConstants.HIGH_DATE);
			} else {
				final StringBuilder dateConverter = new StringBuilder();
				final String sAppDate = appMedInsCargo.getCvrg_end_dt();
				dateConverter.append(sAppDate.substring(6, 10)).append("-")
				.append(sAppDate.substring(0, 2)).append("-")
				.append(sAppDate.substring(3, 5));
				appMedInsCargo.setCvrg_end_dt(dateConverter.toString());
			}
			if (FwConstants.DEFAULT_DROPDOWN_SEL.equals(appMedInsCargo
					.getHealth_insurance_state_addr())) {
				appMedInsCargo
				.setHealth_insurance_state_addr(FwConstants.SPACE);
			}

			appMedInsCargo.setRec_cplt_ind(FwConstants.ONE);

			// get componet list
			final List componentList = (ArrayList) beforeColl
					.get(FwConstants.PAGE_COMPONENT_LIST);
			if (!componentList.contains("5196")) {
			}

			String sourceAppIndicator = null;
			String recordInd = null;
			long policySeqNum = 0;
			boolean hlthDetailsUpdate = false;
			if (appMedInsBeforeColl != null && !appMedInsBeforeColl.isEmpty()) {
				final int size = appMedInsBeforeColl.size();
				policySeqNum = categorySeqDetailBean.getCategorySequence();
				if (size > 1) {
					// if we have two records means cw and rm
					// now we are getting RM record to compare
					// now we need to update the data base if it dirty
					sourceAppIndicator = AppConstants.RMC_MODIFIED_RECORD_IND;
					recordInd = FwConstants.ROWACTION_UPDATE;
					appMedInsBeforeCargo = helthCareBO.splitHlthCvrgCargo(
							appMedInsBeforeColl, sourceAppIndicator);
					if (appMedInsBeforeCargo == null) {
						sourceAppIndicator = AppConstants.RMC_END_RECORD_IND;
						recordInd = FwConstants.ROWACTION_UPDATE;
						appMedInsBeforeCargo = helthCareBO.splitHlthCvrgCargo(
								appMedInsBeforeColl, sourceAppIndicator);
					}

				} else {
					// now we are checking this record is CW or RN
					appMedInsBeforeCargo = helthCareBO.splitHlthCvrgCargo(
							appMedInsBeforeColl, AppConstants.CWW_RECORD_IND);
					if (appMedInsBeforeCargo != null) {
						if (userEndInd == 2) {
							sourceAppIndicator = AppConstants.RMC_END_RECORD_IND;
							recordInd = FwConstants.ROWACTION_INSERT;

						} else {
							sourceAppIndicator = AppConstants.RMC_MODIFIED_RECORD_IND;
							recordInd = FwConstants.ROWACTION_INSERT;
						}
					} else {
						sourceAppIndicator = AppConstants.RMC_NEW_RECORD_IND;
						recordInd = FwConstants.ROWACTION_UPDATE;
						appMedInsBeforeCargo = helthCareBO.splitHlthCvrgCargo(
								appMedInsBeforeColl, sourceAppIndicator);
					}
				}

				appMedInsCargo.setApp_num(appNumber);
				//
				appMedInsCargo.setIndv_seq_num(appMedInsBeforeCargo
						.getIndv_seq_num());
				appMedInsCargo.setPlcy_hold_seq_num(appMedInsBeforeCargo
						.getPlcy_hold_seq_num());
				appMedInsCargo.setPlcy_seq_num(appMedInsBeforeCargo
						.getPlcy_seq_num());
				appMedInsCargo.setSrc_app_ind(sourceAppIndicator);
				appMedInsCargo = (APP_MED_INS_Cargo) isChanged(
						appMedInsBeforeCargo, appMedInsCargo);

				appMedInsCargo.setRowAction(recordInd);
				// PersistData if the cargo is dirty
				if (appMedInsCargo.isDirty()) {

					hlthDetailsUpdate = true;

				}

			} else {
				sourceAppIndicator = AppConstants.RMC_NEW_RECORD_IND;
				appMedInsCargo
				.setIndv_seq_num(String.valueOf(categorySeqDetailBean
						.getIndividualSequence()));
				// get the MAX seq number from data base
				policySeqNum = helthCareBO.getMaxPolicySeqNumber(appNumber,
						indvSeqNum);
				policySeqNum = policySeqNum + 1;
				appMedInsCargo.setPlcy_seq_num(String.valueOf(policySeqNum));

				appMedInsCargo.setSrc_app_ind(sourceAppIndicator);
				recordInd = FwConstants.ROWACTION_INSERT;
				appMedInsCargo.setRowAction(recordInd);
				hlthDetailsUpdate = true;
				categorySelectionProfileManager.updateSequence(hlthCvrgProfile,
						null, categorySeqDetailBean.getIndividualSequence(),
						policySeqNum, categorySeqDetailBean.getCategoryType());

			}

			// Added by EDSP-CP team for health insurance coverage individuals.
			final String plcySeqNum = appMedInsColl.getCargo(0)
					.getPlcy_seq_num();
			CP_APP_IN_MED_INS_CVRG_Cargo cpAppInMedInsBeforeCargo = null;
			CP_APP_IN_MED_INS_CVRG_Cargo cpAppInMedInsCargo = null;
			CP_APP_IN_MED_INS_CVRG_Cargo cpAppInMedInsCWCargo = null;
			final CP_APP_IN_MED_INS_CVRG_Collection cpAppInMedInsPersistColl = new CP_APP_IN_MED_INS_CVRG_Collection();
			if (cpAppInMedInsCvrgBeforeColl != null) {
				final int cpAppInMedInsCvrgBeforeCollSize = cpAppInMedInsCvrgBeforeColl
						.size();
				for (int i = 0; i < cpAppInMedInsCvrgBeforeCollSize; i++) {
					cpAppInMedInsBeforeCargo = cpAppInMedInsCvrgBeforeColl
							.getCargo(i);

					if ("RE".equalsIgnoreCase(cpAppInMedInsBeforeCargo
							.getSrc_app_ind())) {
						cpAppInMedInsCWCargo = helthCareBO.getCWMedCvrgCargo(
								cpAppInMedInsCvrgCWColl,
								cpAppInMedInsBeforeCargo
								.getCovered_indv_seq_num());
						cpAppInMedInsCargo = helthCareBO.getMatchingCargo(
								cpAppInMedInsCvrgColl, cpAppInMedInsCWCargo);
						if (cpAppInMedInsCargo != null) {
							cpAppInMedInsBeforeCargo
							.setRowAction(FwConstants.ROWACTION_DELETE);
							cpAppInMedInsPersistColl
							.add(cpAppInMedInsBeforeCargo);
						}

					} else {
						cpAppInMedInsCargo = helthCareBO
								.getMatchingCargo(cpAppInMedInsCvrgColl,
										cpAppInMedInsBeforeCargo);
						if (cpAppInMedInsCargo == null
								&& !"RE".equalsIgnoreCase(cpAppInMedInsBeforeCargo
										.getSrc_app_ind())) {
							if ("CW".equalsIgnoreCase(cpAppInMedInsBeforeCargo
									.getSrc_app_ind())) {
								helthCareBO.setDefaultValues(
										cpAppInMedInsBeforeCargo, appNumber,
										indvSeqNum, plcySeqNum);

								cpAppInMedInsBeforeCargo
								.setSrc_app_ind(AppConstants.RMC_END_RECORD_IND);
								cpAppInMedInsBeforeCargo
								.setRowAction(FwConstants.ROWACTION_INSERT);
								cpAppInMedInsPersistColl
								.add(cpAppInMedInsBeforeCargo);

							} else {
								cpAppInMedInsBeforeCargo
								.setRowAction(FwConstants.ROWACTION_DELETE);
								cpAppInMedInsPersistColl
								.add(cpAppInMedInsBeforeCargo);
							}

						} else {
							// now we need to check the dirty indicator
							helthCareBO.setDefaultValues(cpAppInMedInsCargo,
									appNumber, indvSeqNum, plcySeqNum);

							cpAppInMedInsCargo = (CP_APP_IN_MED_INS_CVRG_Cargo) isChanged(
									cpAppInMedInsBeforeCargo,
									cpAppInMedInsCargo);
							cpAppInMedInsCargo.setSrc_app_ind(appMedInsCargo
									.getSrc_app_ind());

							if (cpAppInMedInsCargo.isDirty()) {
								cpAppInMedInsCargo
								.setRowAction(FwConstants.ROWACTION_INSERT);
								cpAppInMedInsPersistColl
								.add(cpAppInMedInsCargo);
							}
						}
					}
				}
			}
			if (cpAppInMedInsCvrgColl != null) {
				final int cpAppInMedInsCollSize = cpAppInMedInsCvrgColl.size();
				for (int i = 0; i < cpAppInMedInsCollSize; i++) {
					cpAppInMedInsCargo = cpAppInMedInsCvrgColl.getCargo(i);
					cpAppInMedInsBeforeCargo = helthCareBO.getMatchingCargo(
							cpAppInMedInsCvrgBeforeColl, cpAppInMedInsCargo);
					if (cpAppInMedInsBeforeCargo == null) {
						cpAppInMedInsBeforeCargo = helthCareBO
								.getMatchingCargo(cpAppInMedInsCvrgCWColl,
										cpAppInMedInsCargo);
					}
					if (cpAppInMedInsBeforeCargo == null) {
						helthCareBO.setDefaultValues(cpAppInMedInsCargo,
								appNumber, indvSeqNum, plcySeqNum);
						cpAppInMedInsCargo.setSrc_app_ind(appMedInsCargo
								.getSrc_app_ind());
						cpAppInMedInsCargo
						.setRowAction(FwConstants.ROWACTION_INSERT);
						cpAppInMedInsPersistColl.add(cpAppInMedInsCargo);
					}
				}
			}

			beforeColl.get("PAGE_MODE");

			if (hlthDetailsUpdate) {
				helthCareBO.storeHealthCareCoverage(appMedInsColl);

			}
			helthCareBO.storeHealthInsuranceCoverage(cpAppInMedInsPersistColl);

			boolean outSideTheHomeFlag = false;
			if (FwConstants.ZERO.equals(indvSeqNum)) {
				outSideTheHomeFlag = true;
			}
			if (!outSideTheHomeFlag) {
				rmcResponseProfileManager.getProfile(sessionAppInPrflColl,
						appMedInsCargo.getPlcy_hold_seq_num());
			}
			boolean loopingQuestion = false;
			if (request.get("loopingQuestion") != null
					&& FwConstants.YES.equals(request.get("loopingQuestion"))) {
				loopingQuestion = true;
				// Insert into APP_IN_EMPL and APP_IN_EMPL_A_WAGE
				categorySelectionProfileManager.insertSequenceDetail(
						hlthCvrgProfile, null, null,
						categorySeqDetailBean.getIndividualSequence(),
						categorySeqDetailBean.getCategoryType());
				driverManager.makeRequired(FwConstants.RMC_DRIVER,
						currentPageID, driverArray, appNumber);
				// EDSP RMB TEMP

			}

			// now i need to update the rmc_in_prfl if looping question is null
			if (!loopingQuestion
					&& categorySeqDetailBean.getChangeSelectionCategoryCd() == null) {
				final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
						.get(AppConstants.RMC_IN_PRFL_MASTER);
				final RMC_IN_PRFL_Cargo rmcInPrflCargo = rmcResponseProfileManager
						.getProfile(rmcInPrflColl, String
								.valueOf(categorySeqDetailBean
										.getIndividualSequence()));
				if (rmcInPrflCargo != null) {
					rmcResponseProfileManager.makeComplete(
							IRMCResponseProfileManager.HEALTHCARE_COVERAGE,
							rmcInPrflCargo, true);
				}
			}
			// Mark complete job sequence using common methods
			categorySelectionProfileManager.makeSequenceDetailComplete(
					hlthCvrgProfile, null,
					categorySeqDetailBean.getIndividualSequence(),
					categorySeqDetailBean.getCategorySequence(),
					categorySeqDetailBean.getCategoryType());
			if (categorySelectionProfile != null) {
				categorySelectionProfileManager.makeSequenceDetailComplete(
						categorySelectionProfile, appNumber,
						categorySeqDetailBean.getIndividualSequence(),
						categorySeqDetailBean.getCategorySequence(),
						categorySeqDetailBean.getCategoryType());
			}

			if (categorySelectionProfileManager
					.areAllSequencesComplete(hlthCvrgProfile)) {
				driverManager.makeComplete(FwConstants.RMC_DRIVER,
						currentPageID, driverArray, appNumber);
			} else {
				categorySelectionProfileManager
				.getNextSequenceDetail(hlthCvrgProfile);
			}
			// Does LoopingQuestion flag is YES
			// manju EDSP RMB

			session.remove("APP_IN_MED_INS_Collection");
			session.put("APP_IN_MED_INS_Collection", appMedInsColl);
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::storeHealthCareCoverageDetails:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("storeHealthCareCoverageDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"storeHealthCareCoverageDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.storeHealthCareCoverageDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Load mapp details.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 * @throws javax.ejb.EJBException the javax.ejb. ejb exception
	 */
	public void loadMAPPDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.loadMAPPDetails() - START");

		try {

			log(ILog.INFO, "RMCOtherBenefitsEJBBean::loadMAPPDetails:Start");

			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();

			// you'll get the value for Seq
			APP_IN_MAPP_Collection appInMAPPColl;

			final String appNumber = (String) session
					.get(AppConstants.APP_NUMBER);
			final String pageId = (String) request
					.get(FwConstants.CURRENT_PAGE_ID);
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			final int pageStatus = driverManager.getAFBStatus(
					FwConstants.RMC_DRIVER, pageId, driverArray);

			// build category selection profile
			SortedSet categorySelectionProfile = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);

			final Map catMappTypes = new HashMap();
			catMappTypes
			.put(AppConstants.MAPP_CHANGE, AppConstants.MAPP_CHANGE);

			if (pageStatus == FwConstants.DRIVER_REQUIRED
					|| pageStatus == FwConstants.DRIVER_VISIT_AGAIN
					&& categorySelectionProfileManager.isEmpty(
							categorySelectionProfile, catMappTypes)) {
				categorySelectionProfile = categorySelectionProfileManager
						.loadCategoryChangeSelectionProfile(appNumber,
								AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL);
			}

			RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			final String previousPageId = (String) request
					.get(FwConstants.PREVIOUS_PAGE_ID);

			final MappDetailsBO inMAPPBO = new MappDetailsBO();

			final short[] responseType = new short[] { IRMCResponseProfileManager.MAPP_BENEFITS_RESP };
			SortedSet mappDetailsProfile = null;
			boolean rnRecordFound = false;
			final String categType = AppConstants.MAPP_CHANGE;
			if (!pageId.equals(previousPageId)) {
				mappDetailsProfile = createPageProfile(
						categorySelectionProfile, rmcInPrflColl, responseType);
				if (pageStatus != FwConstants.DRIVER_REQUIRED) {
					final APP_IN_MAPP_Collection newMAPPColl = inMAPPBO
							.getMAPPList(appNumber);
					if (newMAPPColl != null && !newMAPPColl.isEmpty()) {
						APP_IN_MAPP_Cargo appInMAPPCargo = null;
						final int newMAPPCollSize = newMAPPColl.size();
						rnRecordFound = true;

						for (int i = 0; i < newMAPPCollSize; i++) {
							appInMAPPCargo = newMAPPColl.getCargo(i);
							categorySelectionProfileManager
							.insertExistingSequenceDetail(
									mappDetailsProfile, null, null,
									Short.parseShort(appInMAPPCargo
											.getIndv_seq_num()),
											(short) 0, categType);
						}
					}
				}

				if (pageStatus == FwConstants.DRIVER_REQUIRED
						|| pageStatus == FwConstants.DRIVER_VISIT_AGAIN) {
					// set the current record indicator to the first one
					categorySelectionProfileManager
					.setCurrentRecordIndToFirst(mappDetailsProfile);
				}

				if (pageStatus == FwConstants.DRIVER_COMPLETE) {
					// set the current record indicator to the end of the detail
					// bean
					categorySelectionProfileManager
					.setCurrentRecordIndToLast(mappDetailsProfile);
				}
				// create add new sorted set
				// we need to remove the vallues from the session
				session.remove(FwConstants.BEFORE_COLLECTION);
			} else {
				// catAddNewProfile get it from the before collection
				final Map beforeColl = (Map) session
						.get(FwConstants.BEFORE_COLLECTION);
				mappDetailsProfile = (SortedSet) beforeColl
						.get(AppConstants.RMC_CATEGORY_PAGE_PRFL);
			}

			final IndivTypeSeqBean indivSeqBean = (IndivTypeSeqBean) pageCollection
					.get(FwConstants.DETAIL_KEY_BEAN);
			// if details key bean not null means this bean is comming from the
			// summary page
			if (indivSeqBean != null) {
				final CategorySequenceDetail categorySeqDetail1 = categorySelectionProfileManager
						.getCategorySequenceDetail(
								mappDetailsProfile,
								Short.parseShort(indivSeqBean.getIndivSeqNum()),
								Short.parseShort(indivSeqBean.getSeqNum()),
								AppConstants.MAPP_CHANGE);
				if (categorySeqDetail1 != null) {
					if (categorySeqDetail1.getUserEndSelectionInd() != 1
							&& !rnRecordFound) {
						String userEndIndicator = indivSeqBean.getUserEndInd();
						if (userEndIndicator == null) {
							userEndIndicator = FwConstants.ZERO;
						}
						categorySelectionProfileManager
						.updateUserEndSelInd(mappDetailsProfile,
								appNumber, Short
								.parseShort(indivSeqBean
										.getIndivSeqNum()),
										Short.parseShort(indivSeqBean
												.getSeqNum()),
												AppConstants.MAPP_CHANGE, Short
												.parseShort(userEndIndicator));
					}
					categorySelectionProfileManager.makeSequenceDetailRequired(
							mappDetailsProfile, null,
							Short.parseShort(indivSeqBean.getIndivSeqNum()),
							Short.parseShort(indivSeqBean.getSeqNum()),
							AppConstants.MAPP_CHANGE);
					final CategorySequenceDetail categorySeqDetail2 = categorySelectionProfileManager
							.getCategorySequenceDetail(
									categorySelectionProfile, Short
									.parseShort(indivSeqBean
											.getIndivSeqNum()), Short
											.parseShort(indivSeqBean
													.getSeqNum()),
													AppConstants.MAPP_CHANGE);
					if (categorySeqDetail2 != null) {
						if (categorySeqDetail2.getUserEndSelectionInd() != 1
								&& !rnRecordFound) {
							String userEndIndicator = indivSeqBean
									.getUserEndInd();
							if (userEndIndicator == null) {
								userEndIndicator = FwConstants.ZERO;
							}
							categorySelectionProfileManager
							.updateUserEndSelInd(
									categorySelectionProfile,
									appNumber, Short
									.parseShort(indivSeqBean
											.getIndivSeqNum()),
											Short.parseShort(indivSeqBean
													.getSeqNum()),
													AppConstants.MAPP_CHANGE,
													Short.parseShort(userEndIndicator));
						}
						categorySelectionProfileManager
								.makeSequenceDetailRequired(
								categorySelectionProfile, appNumber,
								Short.parseShort(indivSeqBean
										.getIndivSeqNum()), Short
										.parseShort(indivSeqBean
												.getSeqNum()),
												AppConstants.MAPP_CHANGE);
					}
				} else {
					if (FwConstants.ZERO.equals(indivSeqBean.getSeqNum())) {
						// first we are checking rnc in profile exists in the
						// sess
						RMC_IN_PRFL_Cargo rmcInPrflCargo = null;
						if (AppConstants.REQUEST_MAPP.equals(indivSeqBean
								.getType())) {
							if (rmcInPrflColl != null) {
								rmcInPrflCargo = rmcResponseProfileManager
										.getProfile(rmcInPrflColl,
												indivSeqBean.getIndivSeqNum());
							} else {
								rmcInPrflColl = new RMC_IN_PRFL_Collection();
							}
							if (rmcInPrflCargo == null) {
								rmcInPrflCargo = new RMC_IN_PRFL_Cargo();
								rmcInPrflCargo.setApp_num(appNumber);
								rmcInPrflCargo.setIndv_seq_num(indivSeqBean
										.getIndivSeqNum());
								rmcResponseProfileManager
								.createRMCIndividualProfile(rmcInPrflCargo);
								rmcInPrflColl.addCargo(rmcInPrflCargo);
							}
							rmcResponseProfileManager
							.makeAddNew(
									IRMCResponseProfileManager.MAPP_BENEFITS_RESP,
									rmcInPrflCargo, true);

							CategorySequenceDetail catseqDet = null;
							if (!mappDetailsProfile.isEmpty()) {
								catseqDet = categorySelectionProfileManager
										.getCategorySequenceDetail(
												mappDetailsProfile,
												Short.parseShort(indivSeqBean
														.getIndivSeqNum()),
														(short) 0,
														AppConstants.MAPP_CHANGE);
							}

							if (catseqDet == null) {
								categorySelectionProfileManager
								.insertSequenceDetail(
										mappDetailsProfile, null, null,
										Short.parseShort(indivSeqBean
												.getIndivSeqNum()),
												AppConstants.MAPP_CHANGE);
							}
						} else {
							if (AppConstants.RMC_MODIFIED_RECORD_IND
									.equals(indivSeqBean.getType())
									|| AppConstants.CWW_RECORD_IND
									.equals(indivSeqBean.getType())) {
								boolean sErowExists = false;

								final Iterator iter = categorySelectionProfile
										.iterator();
								CategorySequenceDetail catSeqDetail = null;
								while (iter.hasNext()) {
									catSeqDetail = (CategorySequenceDetail) iter
											.next();
									if (catSeqDetail != null) {
										if (catSeqDetail
												.getIndividualSequence() == Short
												.parseShort(indivSeqBean
														.getIndivSeqNum())
														&& AppConstants.MAPP_CHANGE
														.equals(catSeqDetail
																.getCategoryType()
																.trim())
																&& AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL
														.equals(catSeqDetail
																		.getChangeSelectionCategoryCd())) {
											sErowExists = true;
											break;
										}
									}

								}

								if (sErowExists) {
									categorySelectionProfileManager
									.removeSequenceDetail(
											categorySelectionProfile,
											appNumber,
											Short.parseShort(indivSeqBean
													.getIndivSeqNum()),
													(short) 0,
													AppConstants.MAPP_CHANGE);
								}

								categorySelectionProfileManager
								.insertSequenceDetail(
										categorySelectionProfile,
										appNumber,
										AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL,
										Short.parseShort(indivSeqBean
												.getIndivSeqNum()),
												AppConstants.MAPP_CHANGE);
								categorySelectionProfileManager
								.makeSequenceDetailRequired(
										categorySelectionProfile,
										appNumber,
										Short.parseShort(indivSeqBean
												.getIndivSeqNum()),
												Short.parseShort(indivSeqBean
														.getSeqNum()),
														AppConstants.MAPP_CHANGE);

								SortedSet pregAddSortedSet = null;
								final String[] catTypePregAdd = { AppConstants.MAPP_CHANGE };
								pregAddSortedSet = createPageProfile(
										categorySelectionProfile,
										catTypePregAdd);
								mappDetailsProfile.addAll(pregAddSortedSet);

							} else {
								CategorySequenceDetail catseqDet = null;
								if (!mappDetailsProfile.isEmpty()) {
									catseqDet = categorySelectionProfileManager
											.getCategorySequenceDetail(
													mappDetailsProfile,
													Short.parseShort(indivSeqBean
															.getIndivSeqNum()),
															(short) 0,
															AppConstants.MAPP_CHANGE);
								}
								if (catseqDet != null) {
									categorySelectionProfileManager
									.removeSequenceDetail(
											mappDetailsProfile,
											null,
											Short.parseShort(indivSeqBean
													.getIndivSeqNum()),
													(short) 0,
													AppConstants.MAPP_CHANGE);
									categorySelectionProfileManager
									.insertSequenceDetail(
											mappDetailsProfile,
											null,
											null,
											Short.parseShort(indivSeqBean
													.getIndivSeqNum()),
													AppConstants.MAPP_CHANGE);
								} else {
									categorySelectionProfileManager
									.insertSequenceDetail(
											mappDetailsProfile,
											null,
											null,
											Short.parseShort(indivSeqBean
													.getIndivSeqNum()),
													AppConstants.MAPP_CHANGE);
								}

							}
						}

					} else {
						String userEndInd = indivSeqBean.getUserEndInd();
						if (userEndInd == null) {
							userEndInd = FwConstants.ZERO;
						}
						categorySelectionProfileManager
						.insertExistingSequenceDetail(
								mappDetailsProfile,
								null,
								AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL,
								Short.parseShort(indivSeqBean
										.getIndivSeqNum()), Short
										.parseShort(indivSeqBean
												.getSeqNum()),
												AppConstants.MAPP_CHANGE, Short
												.parseShort(userEndInd));
						categorySelectionProfileManager
								.makeSequenceDetailRequired(mappDetailsProfile,
								null, Short.parseShort(indivSeqBean
										.getIndivSeqNum()), Short
										.parseShort(indivSeqBean
												.getSeqNum()),
												AppConstants.MAPP_CHANGE);

						categorySelectionProfileManager
						.insertExistingSequenceDetail(
								categorySelectionProfile,
								appNumber,
								AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL,
								Short.parseShort(indivSeqBean
										.getIndivSeqNum()), Short
										.parseShort(indivSeqBean
												.getSeqNum()),
												AppConstants.MAPP_CHANGE, Short
												.parseShort(userEndInd));
						categorySelectionProfileManager
								.makeSequenceDetailRequired(
								categorySelectionProfile, appNumber,
								Short.parseShort(indivSeqBean
										.getIndivSeqNum()), Short
										.parseShort(indivSeqBean
												.getSeqNum()),
												AppConstants.MAPP_CHANGE);
					}
				}
			}
			pageCollection.put(AppConstants.RMC_CATEGORY_PAGE_PRFL,
					mappDetailsProfile);
			session.put(AppConstants.RMC_IN_PRFL_MASTER, rmcInPrflColl);
			session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER,
					categorySelectionProfile);

			CategorySequenceDetail categorySeqDetail = categorySelectionProfileManager
					.getCurrentSequenceDetail(mappDetailsProfile);
			if (categorySeqDetail == null) {
				categorySeqDetail = categorySelectionProfileManager
						.getNextSequenceDetail(mappDetailsProfile);
			}

			categorySeqDetail.getCategoryType();
			final String indvSeqNum = Short.toString(categorySeqDetail
					.getIndividualSequence());

			appInMAPPColl = inMAPPBO.loadMAPPDetails(appNumber, indvSeqNum);

			pageCollection.put("APP_IN_MAPP_Collection", appInMAPPColl);

			APP_IN_MAPP_Cargo cwwMAPPCargo = inMAPPBO.splitMAPPInfoColl(
					appInMAPPColl, AppConstants.CWW_RECORD_IND);

			if (cwwMAPPCargo == null) {
				cwwMAPPCargo = new APP_IN_MAPP_Cargo();
			}
			pageCollection.put("SEC_MAPP",
					inMAPPBO.settingDefaultValues(cwwMAPPCargo));

			APP_IN_MAPP_Cargo rmcMAPPCargo = inMAPPBO.splitMAPPInfoColl(
					appInMAPPColl, AppConstants.RMC_NEW_RECORD_IND);
			if (rmcMAPPCargo != null) {
				pageCollection.put("FST_MAPP",
						inMAPPBO.settingDefaultValues(rmcMAPPCargo));
			} else {
				rmcMAPPCargo = inMAPPBO.splitMAPPInfoColl(appInMAPPColl,
						AppConstants.RMC_MODIFIED_RECORD_IND);
				if (rmcMAPPCargo != null) {
					pageCollection.put("FST_MAPP",
							inMAPPBO.settingDefaultValues(rmcMAPPCargo));
				} else {
					pageCollection.put("FST_MAPP",
							inMAPPBO.settingDefaultValues(rmcMAPPCargo));
				}

			}

			String srcAppInd = FwConstants.EMPTY_STRING;
			String pageMode = FwConstants.EMPTY_STRING;

			if (appInMAPPColl != null && !appInMAPPColl.isEmpty()) {
				final APP_IN_MAPP_Cargo appMAPPCargo = appInMAPPColl
						.getCargo(0);
				srcAppInd = appMAPPCargo.getSrc_app_ind();
			}

			if ((AppConstants.CWW_RECORD_IND.equalsIgnoreCase(srcAppInd) || AppConstants.RMC_MODIFIED_RECORD_IND
					.equalsIgnoreCase(srcAppInd))
					&& categorySeqDetail.getUserEndSelectionInd() == 0) {
				pageMode = "C";
			}

			if (categorySeqDetail.getUserEndSelectionInd() == 1)
			/*
				 * VG SONAR Cleanup - 09/1/2015 Deleted 3,3,1 lines Commented Code
				 * in this block
				 */

			{
				pageMode = "E";
			} else if (indivSeqBean != null
					&& indivSeqBean.getUserEndInd() != null) {
				if (FwConstants.ONE.equalsIgnoreCase(indivSeqBean
						.getUserEndInd()))

				{
					pageMode = "E";
				} else if (FwConstants.ZERO
						.equals(indivSeqBean.getUserEndInd())
						&& AppConstants.RMC_MODIFIED_RECORD_IND
						.equalsIgnoreCase(srcAppInd)
						|| AppConstants.CWW_RECORD_IND
						.equalsIgnoreCase(srcAppInd)) {
					pageMode = "C";
				} else {
					pageMode = FwConstants.NO;
				}
			} else if (!("C".equals(pageMode) || "E".equals(pageMode))) {
				pageMode = FwConstants.NO;
			}

			pageCollection.put("PAGE_MODE", pageMode);

			// set first name to page collection
			final PeopleHandler peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);
			pageCollection.put(AppConstants.FIRST_NAME,
					peopleHandler.getFirstName(indvSeqNum));

			// run component manager
			componentManager.getComponents("ARMAP", txnBean);

			// Add the page collection to before collection
			session.put(FwConstants.BEFORE_COLLECTION, pageCollection);

			log(ILog.INFO, "RMCOtherBenefitsEJBBean::loadMAPPDetails:End");

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("loadMAPPDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"loadMAPPDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.loadMAPPDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Store mapp details.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 * @throws javax.ejb.EJBException the javax.ejb. ejb exception
	 */
	public void storeMAPPDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.storeMAPPDetails() - START");

		log(ILog.INFO, "RMCOtherBenefitsEJBBean::storeMAPPDetails:Start");

		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();

			/*
			 * VG SONAR Cleanup - 09/1/2015 Deleted 2 lines Commented Code in
			 * this block
			 */

			final String currentPageID = (String) request
					.get(FwConstants.CURRENT_PAGE_ID);
			final String appNumber = (String) session
					.get(AppConstants.APP_NUMBER);
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);

			// build category selection profile
			final SortedSet categorySelectionProfile = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			// get the BeforeCollection
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);

			final SortedSet inMAPPProfile = (SortedSet) beforeColl
					.get(AppConstants.RMC_CATEGORY_PAGE_PRFL);

			final APP_IN_MAPP_Collection appInMAPPCollection = (APP_IN_MAPP_Collection) pageCollection
					.get("APP_IN_MAPP_Collection");
			APP_IN_MAPP_Cargo appInMAPPCargo = appInMAPPCollection.getCargo(0);

			beforeColl.get(AppConstants.FIRST_NAME);
			final CategorySequenceDetail categorySeqDetailBean = categorySelectionProfileManager
					.getCurrentSequenceDetail(inMAPPProfile);

			/*
			 * VG SONAR Cleanup - 09/1/2015 Deleted 1,2,1,1 lines Commented Code
			 * in this block
			 */

			// Run Validations

			final MappDetailsBO inMAPPBO = new MappDetailsBO();

			final short indvSeqNum = categorySeqDetailBean
					.getIndividualSequence();

			request.get(AppConstants.BACK_TO_MY_ACCESS_BUTTON);

			if (checkBackToMyAccessSelected(request)) {
				request.get(FwConstants.WARNING_MSG_DETAILS);
				pageCollection.put(AppConstants.CURRENT_MAPP_TYPE,
						beforeColl.get(AppConstants.CURRENT_MAPP_TYPE));
				pageCollection.put(AppConstants.FIRST_NAME,
						beforeColl.get(AppConstants.FIRST_NAME));
				pageCollection.put("APP_IN_MAPP_Collection",
						appInMAPPCollection);
				pageCollection.put(FwConstants.PAGE_COMPONENT_LIST,
						beforeColl.get(FwConstants.PAGE_COMPONENT_LIST));
				pageCollection.put("PAGE_MODE", beforeColl.get("PAGE_MODE"));

				if (beforeColl.containsKey("SEC_MAPP")) {
					pageCollection.put("SEC_MAPP", beforeColl.get("SEC_MAPP"));
				}
				pageCollection.put("FST_MAPP", appInMAPPCargo);
				return;

			}

			final APP_IN_MAPP_Collection beforeCollAppInMAPPColl = (APP_IN_MAPP_Collection) beforeColl
					.get("APP_IN_MAPP_Collection");
			APP_IN_MAPP_Cargo beforeMAPPCargo = null;

			// now we are setting the default values

			final StringBuilder dateConverter1 = new StringBuilder();
			String effBegMo = FwConstants.EMPTY_STRING;
			final String sAppDate1 = fwDate.getToday();

			dateConverter1.append(sAppDate1.substring(0, 4)).append(
					sAppDate1.substring(5, 7));
			effBegMo = dateConverter1.toString();

			appInMAPPCargo.setApp_num(appNumber);
			appInMAPPCargo.setIndv_seq_num(String.valueOf(indvSeqNum));

			if (appInMAPPCargo.getEff_beg_mo() != null
					&& appInMAPPCargo.getEff_beg_mo().trim().length() > 0) {
				appInMAPPCargo.setEff_beg_mo(appInMAPPCargo.getEff_beg_mo());
			} else {
				appInMAPPCargo.setEff_beg_mo(effBegMo);
			}

			if (appInMAPPCargo.getWork_resp() != null
					&& appInMAPPCargo.getWork_resp().trim().length() > 0) {
				appInMAPPCargo.setWork_resp(appInMAPPCargo.getWork_resp());
			} else {
				appInMAPPCargo.setWork_resp(FwConstants.SPACE);
			}

			if (appInMAPPCargo.getMapp_rqst_resp() != null
					&& appInMAPPCargo.getMapp_rqst_resp().trim().length() > 0) {

				appInMAPPCargo.setMapp_rqst_resp(appInMAPPCargo
						.getMapp_rqst_resp());
			} else {
				appInMAPPCargo.setMapp_rqst_resp(FwConstants.SPACE);
			}

			if (appInMAPPCargo.getHec_pgm_resp() != null
					&& appInMAPPCargo.getHec_pgm_resp().trim().length() > 0) {

				appInMAPPCargo
				.setHec_pgm_resp(appInMAPPCargo.getHec_pgm_resp());
			} else {
				appInMAPPCargo.setHec_pgm_resp(FwConstants.SPACE);
			}
			if (appInMAPPCargo.getWork_resp() != null
					&& FwConstants.YES.equals(appInMAPPCargo.getWork_resp()
							.trim())) {
				appInMAPPCargo.setWork_exmp_resp(FwConstants.SPACE);
			} else {
				if (appInMAPPCargo.getWork_exmp_resp() != null
						&& appInMAPPCargo.getWork_exmp_resp().trim().length() > 0) {
					appInMAPPCargo.setWork_exmp_resp(appInMAPPCargo
							.getWork_exmp_resp());
				} else {
					appInMAPPCargo.setWork_exmp_resp(FwConstants.SPACE);
				}
			}

			String sourceAppIndicator = null;
			String recordInd = null;

			// now we are checking for the before collection

			boolean inMAPPDetailsUpdate = false;

			if (beforeCollAppInMAPPColl != null
					&& !beforeCollAppInMAPPColl.isEmpty()) {
				final int size = beforeCollAppInMAPPColl.size();

				if (size > 1) {
					// if we have two records means cw and rm
					// now we are getting RM record to compare
					// now we need to update the data base if it dirty
					sourceAppIndicator = AppConstants.RMC_MODIFIED_RECORD_IND;
					recordInd = FwConstants.ROWACTION_UPDATE;
					beforeMAPPCargo = inMAPPBO.splitMAPPInfoColl(
							beforeCollAppInMAPPColl, sourceAppIndicator);

				} else {
					// now we are checking this record is CW or RN
					beforeMAPPCargo = inMAPPBO.splitMAPPInfoColl(
							beforeCollAppInMAPPColl,
							AppConstants.CWW_RECORD_IND);
					if (beforeMAPPCargo != null) {
						sourceAppIndicator = AppConstants.RMC_MODIFIED_RECORD_IND;
						recordInd = FwConstants.ROWACTION_INSERT;
					} else {
						sourceAppIndicator = AppConstants.RMC_NEW_RECORD_IND;
						recordInd = FwConstants.ROWACTION_UPDATE;
						beforeMAPPCargo = inMAPPBO.splitMAPPInfoColl(
								beforeCollAppInMAPPColl, sourceAppIndicator);
					}
				}

				if (beforeMAPPCargo != null) {

					if (appInMAPPCargo.getWork_resp() == null
							|| FwConstants.SPACE.equals(appInMAPPCargo
									.getWork_resp())) {
						appInMAPPCargo.setWork_resp(beforeMAPPCargo
								.getWork_resp());
					}

					if (appInMAPPCargo.getHec_pgm_resp() == null
							|| FwConstants.SPACE.equals(appInMAPPCargo
									.getHec_pgm_resp())) {
						appInMAPPCargo.setHec_pgm_resp(beforeMAPPCargo
								.getHec_pgm_resp());
					}

					if (appInMAPPCargo.getWork_resp() != null
							&& FwConstants.YES.equals(appInMAPPCargo
									.getWork_resp().trim())) {
						appInMAPPCargo.setWork_exmp_resp(FwConstants.SPACE);
					} else {
						if (appInMAPPCargo.getWork_exmp_resp() == null) {
							appInMAPPCargo.setWork_exmp_resp(beforeMAPPCargo
									.getWork_exmp_resp());
						}
					}
					if (appInMAPPCargo.getMapp_rqst_resp() == null
							|| FwConstants.SPACE.equals(appInMAPPCargo
									.getMapp_rqst_resp())) {
						appInMAPPCargo.setMapp_rqst_resp(beforeMAPPCargo
								.getMapp_rqst_resp());
					}
				}

				// check dirty
				appInMAPPCargo = (APP_IN_MAPP_Cargo) isChanged(beforeMAPPCargo,
						appInMAPPCargo);

				appInMAPPCargo.setSrc_app_ind(sourceAppIndicator);
				appInMAPPCargo.setRowAction(recordInd);

				if (appInMAPPCargo.isDirty()) {
					inMAPPDetailsUpdate = true;
				}
			} else {
				// if there is no before collection means this is new record
				sourceAppIndicator = AppConstants.RMC_NEW_RECORD_IND;
				/*
				 * VG SONAR Cleanup - 09/1/2015 Deleted 1,2 lines Commented Code
				 * in this block
				 */

				appInMAPPCargo.setSrc_app_ind(sourceAppIndicator);
				recordInd = FwConstants.ROWACTION_INSERT;

				appInMAPPCargo.setRowAction(recordInd);

				inMAPPDetailsUpdate = true;

				// insert into RMC_SELECTION_PROFILE using Common Mehod()
				categorySelectionProfileManager.updateSequence(inMAPPProfile,
						null, categorySeqDetailBean.getIndividualSequence(),
						(short) 0, categorySeqDetailBean.getCategoryType());

				categorySelectionProfileManager.updateSequence(
						categorySelectionProfile, appNumber,
						categorySeqDetailBean.getIndividualSequence(),
						(short) 0, categorySeqDetailBean.getCategoryType());

			}

			// now we need to check the flags
			if (inMAPPDetailsUpdate) {
				inMAPPBO.storeMAPPDetails(appInMAPPCollection);
			}

			// now i need to update the rmc_in_prfl
			if (categorySeqDetailBean.getChangeSelectionCategoryCd() == null) {

				final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
						.get(AppConstants.RMC_IN_PRFL_MASTER);
				final RMC_IN_PRFL_Cargo rmcInPrflCargo = rmcResponseProfileManager
						.getProfile(rmcInPrflColl, String
								.valueOf(categorySeqDetailBean
										.getIndividualSequence()));
				if (rmcInPrflCargo != null) {
					rmcResponseProfileManager.makeComplete(
							IRMCResponseProfileManager.MAPP_BENEFITS_RESP,
							rmcInPrflCargo, true);
				}
			}

			// Mark complete job sequence using common methods
			categorySelectionProfileManager.makeSequenceDetailComplete(
					inMAPPProfile, null,
					categorySeqDetailBean.getIndividualSequence(),
					categorySeqDetailBean.getCategorySequence(),
					categorySeqDetailBean.getCategoryType());
			if (categorySelectionProfile != null) {
				categorySelectionProfileManager.makeSequenceDetailComplete(
						categorySelectionProfile, appNumber,
						categorySeqDetailBean.getIndividualSequence(),
						categorySeqDetailBean.getCategorySequence(),
						categorySeqDetailBean.getCategoryType());
			}

			if (categorySelectionProfileManager
					.areAllSequencesComplete(inMAPPProfile)) {
				driverManager.makeComplete(FwConstants.RMC_DRIVER,
						currentPageID, driverArray, appNumber);
			} else {
				categorySelectionProfileManager
				.getNextSequenceDetail(inMAPPProfile);
			}
			log(ILog.INFO, "RMCOtherBenefitsEJBBean::storeMAPPDetails:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("storeMAPPDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"storeMAPPDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.storeMAPPDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Load other benefits summary.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 * @throws javax.ejb.EJBException the javax.ejb. ejb exception
	 */
	public void loadOtherBenefitsSummary(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.loadOtherBenefitsSummary() - START");

		try {
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::loadOtherBenefitsSummary:Start");
			APP_IN_BNFT_CNVCTN_Collection rmcTsbBnftCnvctnColl = null;
			APP_IN_BNFT_CNVCTN_Collection rmcFriBnftCnvctnColl = null;
			APP_IN_BNFT_CNVCTN_Collection rmcTraBnftCnvctnColl = null;
			APP_IN_BNFT_CNVCTN_Collection rmcPdsBnftCnvctnColl = null;
			APP_IN_BNFT_CNVCTN_Collection rmcSfeBnftCnvctnColl = null;
			APP_IN_BNFT_CNVCTN_Collection rmcUbuBnftCnvctnColl = null;
			APP_IN_BNFT_CNVCTN_Collection rmcVqjBnftCnvctnColl = null;
			APP_IN_BNFT_CNVCTN_Collection rmcDftBnftCnvctnColl = null;
			
			
			APP_IN_SCHLE_Collection schoolEnrollColl = null;
			APP_IN_HLTH_INS_BNFTS_Collection medInsColl = null;
			final APP_MED_INS_Collection pastInsColl = null;
			final APP_IN_MED_INS_Collection appInMedInsColl = null;
			CP_APP_IN_LST_HLTH_INS_Collection pastHealthcoll = null;
			APP_INDV_ADDI_INFO_Collection addiInfoColl = null;
			final ABHouseHoldMemberBO hmbo = new ABHouseHoldMemberBO();
			final HealthCareCoverageBO heathCareBO = new HealthCareCoverageBO();
			APP_IN_HLTH_INS_BNFTS_Cargo medInsCargo = new APP_IN_HLTH_INS_BNFTS_Cargo();
			final Map session = txnBean.getSession();
			final Map pageCollection = txnBean.getPageCollection();
			final Map request = txnBean.getRequest();
			// Get App Number, driver array and driver status
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			final int driverStatus = driverManager.getAFBStatus(
					FwConstants.RMC_DRIVER,
					(String) request.get(FwConstants.CURRENT_PAGE_ID),
					driverArray);
			final PeopleHandler peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);

			SortedSet selectionProfile = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			final RMC_IN_PRFL_Collection prflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			boolean loadschoolEnrlProfile = false;
			boolean loadmedInsProfile = false;

			if ((selectionProfile == null || selectionProfile.isEmpty())
					&& driverStatus != FwConstants.DRIVER_NOT_REQUIRED) {
				// load selection profile form the data base
				loadschoolEnrlProfile = true;
			} else if (selectionProfile != null && !selectionProfile.isEmpty()) {
				// here we need to check the session profile is housing bills
				// session profile
				CategorySequenceDetail catSeqDetail = categorySelectionProfileManager
						.getCurrentSequenceDetail(selectionProfile);
				if (catSeqDetail == null) {
					catSeqDetail = categorySelectionProfileManager
							.getNextSequenceDetail(selectionProfile);
					if (catSeqDetail != null
							&& AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL
							.equals(catSeqDetail
									.getChangeSelectionCategoryCd())) {
						loadschoolEnrlProfile = false;
					} else {
						loadschoolEnrlProfile = true;
					}
				}
			}

			if ((selectionProfile == null || selectionProfile.isEmpty())
					&& driverStatus != FwConstants.DRIVER_NOT_REQUIRED) {
				// load selection profile form the data base
				loadmedInsProfile = true;
			} else if (selectionProfile != null && !selectionProfile.isEmpty()) {
				// here we need to check the session profile is housing bills
				// session profile
				CategorySequenceDetail catSeqDetail = categorySelectionProfileManager
						.getCurrentSequenceDetail(selectionProfile);
				if (catSeqDetail == null) {
					catSeqDetail = categorySelectionProfileManager
							.getNextSequenceDetail(selectionProfile);
					if (catSeqDetail != null
							&& AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL
							.equals(catSeqDetail
									.getChangeSelectionCategoryCd())) {
						loadmedInsProfile = false;
					} else {
						loadmedInsProfile = true;
					}
				}
			}
			//Migrant farm worker logic
			addiInfoColl = hmbo.getMigFarmWrkrDtl(appNum);
			pageCollection.put("APP_INDV_ADDI_INFO_Collection", addiInfoColl);

			// now loading the cat selection profile form the data base
			if (loadschoolEnrlProfile
					|| /* loadMappProfile || */loadmedInsProfile) {
				selectionProfile = categorySelectionProfileManager
						.loadCategoryChangeSelectionProfile(appNum,
								AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL);
			}
			categorySelectionProfileManager
			.resetCurrentSeqeunceDetail(selectionProfile);
			final SchoolEnrollmentBO schEnrlBO = new SchoolEnrollmentBO();
			final HealthCareCoverageBO hlthInsBO = new HealthCareCoverageBO();
			final LostHealthInsBO pastHealthInsBO = new LostHealthInsBO();
			final HealthCareCoverageBO healthCvrgBO = new HealthCareCoverageBO();
			final ABHouseHoldMemberBO abHouseHoldMemberBO = new ABHouseHoldMemberBO();

			schoolEnrollColl = schEnrlBO.getSchoolEnrlDetails(appNum);
			medInsColl = hlthInsBO.getHealthInsrDetails(appNum);
			final CP_APP_IN_MED_INS_CVRG_Collection loadHealthCarePolicyCoverageIndv = healthCvrgBO
					.loadHealthCarePolicyCoverageIndv(appNum, null, null);
			final Map<String, Map<String, Map<String, CP_APP_IN_MED_INS_CVRG_Collection>>> healthCoverageMap = prepareHealthCoverageMap(loadHealthCarePolicyCoverageIndv);

			pastHealthcoll = pastHealthInsBO.getpastHealthInsDetails(appNum);

			// Getting language from http session
			final Map httpSessionMap = (Map) session
					.get(FwConstants.HTTP_SESSION);
			final String language = (String) httpSessionMap
					.get(AppConstants.LANGUAGE);
			final int sizeSchlEnrlColl = schoolEnrollColl.size();

			String newOrModifiedSchlEnrlExists = FwConstants.NO;
			for (int i = 0; i < sizeSchlEnrlColl; i++) {
				APP_IN_SCHLE_Cargo schlEnrlCargo = new APP_IN_SCHLE_Cargo();
				schlEnrlCargo = schoolEnrollColl.getResult(i);
				if (FwConstants.NO.equals(newOrModifiedSchlEnrlExists)) {
					if (AppConstants.RMC_NEW_RECORD_IND.equals(schlEnrlCargo
							.getSrc_app_ind())
							|| AppConstants.RMC_MODIFIED_RECORD_IND
							.equals(schlEnrlCargo.getSrc_app_ind())
							|| AppConstants.RMC_END_RECORD_IND
							.equals(schlEnrlCargo.getSrc_app_ind())) {
						newOrModifiedSchlEnrlExists = FwConstants.YES;
					}
				}
			}

			String newOrModifiedCnvtnExists = FwConstants.NO;

			
			final APP_IN_FELON_DET_Collection felonDetCollection = abHouseHoldMemberBO
					.loadConvictedFelonDetails(appNum);
			final int felonDetCollSize = felonDetCollection.size();

			for (int i = 0; i < felonDetCollSize; i++) {
				APP_IN_FELON_DET_Cargo felonDetCargo = new APP_IN_FELON_DET_Cargo();
				felonDetCargo = felonDetCollection.getCargo(i);

				if (FwConstants.NO.equals(newOrModifiedCnvtnExists)) {
					if (AppConstants.RMC_NEW_RECORD_IND.equals(felonDetCargo
							.getSrc_app_ind())
							|| AppConstants.RMC_MODIFIED_RECORD_IND
							.equals(felonDetCargo.getSrc_app_ind())
							|| AppConstants.RMC_END_RECORD_IND
							.equals(felonDetCargo.getSrc_app_ind())) {
						newOrModifiedCnvtnExists = FwConstants.YES;
					}
				}

			}

			/* Schhol Enrollment */
			final RMBSchoolEnrollmentChangesSummaryListView schoolEnrlListView = new RMBSchoolEnrollmentChangesSummaryListView();
			schoolEnrlListView.setSchEnrlCollection(schoolEnrollColl);
			// Preparing listView for House Bills selection
			schoolEnrlListView.setLanguage(language);
			schoolEnrlListView.setName("RMC_SCHOOLENRL_SUMMARY_LISTVIEW");
			schoolEnrlListView.setDisplayData(schoolEnrollColl);
			schoolEnrlListView.setPageSize(999);
			pageCollection.put("RMC_SCHOOLENRL_SUMMARY_LISTVIEW",
					schoolEnrlListView);
			/* Schhol Enrollment - Ends */

			/* Health Coverage */
			final RMCHealthInsuranceChangesSummaryListView healthInsuranceSummaryListView = new RMCHealthInsuranceChangesSummaryListView();
			// List View for Health Coverage
			final Map additionalInfo = new HashMap();
			additionalInfo.put("APP_IN_HLTH_INS_BNFTS_Collection", medInsColl);
			additionalInfo.put("APP_IN_HLTH_INS_COVERAGE_MAP",
					healthCoverageMap);
			additionalInfo.put("PEOPLE_HANDLER", peopleHandler);
			healthInsuranceSummaryListView.setAdditionalInfo(additionalInfo);
			healthInsuranceSummaryListView.setCollection(medInsColl);
			healthInsuranceSummaryListView.setLanguage(language);
			healthInsuranceSummaryListView
			.setName("APP_IN_HLTH_INS_BNFTS_LISTVIEW");
			healthInsuranceSummaryListView.setDisplayData(medInsColl);
			healthInsuranceSummaryListView.setPageSize(1000);
			pageCollection.put("APP_IN_HLTH_INS_BNFTS_LISTVIEW",
					healthInsuranceSummaryListView);
			/* Health Coverage - Starts */

			/* Past health Insurance */
			final RMCPastHealthInsuranceSummaryListView pasthealthInsuranceSummaryListView = new RMCPastHealthInsuranceSummaryListView();
			final Map pastHealthInfo = new HashMap();
			pastHealthInfo.put("CP_APP_IN_LST_HLTH_INS_Collection",
					pastHealthcoll);
			pasthealthInsuranceSummaryListView
			.setAdditionalInfo(pastHealthInfo);
			pasthealthInsuranceSummaryListView.setCollection(pastHealthcoll);
			pasthealthInsuranceSummaryListView.setLanguage(language);
			pasthealthInsuranceSummaryListView
			.setName("RMC_PASTINS_SUMMARY_LISTVIEW");
			pasthealthInsuranceSummaryListView.setDisplayData(pastHealthcoll);
			pasthealthInsuranceSummaryListView.setPageSize(1000);
			pageCollection.put("RMC_PASTINS_SUMMARY_LISTVIEW",
					pasthealthInsuranceSummaryListView);

			/* Past health Insurance - Ends */

			/* Convicted Felon */
			final String appType = (String) session
					.get(FwConstants.ACCESS_APPLICATION_TYPE);
			final RMCFelonyConvictionSummaryListView convictionSummaryListView = new RMCFelonyConvictionSummaryListView();
			convictionSummaryListView.setFelnCollection(felonDetCollection);
			convictionSummaryListView.setAppType(appType);
			convictionSummaryListView.setLanguage(language);
			convictionSummaryListView.setName("CNVT_SUMMARY_LISTVIEW");
			convictionSummaryListView.setDisplayData(felonDetCollection);
			convictionSummaryListView.setPageSize(1000);
			pageCollection.put("CNVT_SUMMARY_LISTVIEW",
					convictionSummaryListView);
			/* Convicted Felon - Ends */
			
			/*
			 * benefit convictions listviews - start
			 */
			rmcTsbBnftCnvctnColl = abHouseHoldMemberBO.getRmcBnftCnvctnDetails(appNum, AppConstants.CNVCT_TSB);
			rmcFriBnftCnvctnColl = abHouseHoldMemberBO.getRmcBnftCnvctnDetails(appNum, AppConstants.CNVCT_FRI);
			rmcTraBnftCnvctnColl = abHouseHoldMemberBO.getRmcBnftCnvctnDetails(appNum, AppConstants.CNVCT_TRA);
			rmcPdsBnftCnvctnColl = abHouseHoldMemberBO.getRmcBnftCnvctnDetails(appNum, AppConstants.CNVCT_PDS);
			rmcSfeBnftCnvctnColl = abHouseHoldMemberBO.getRmcBnftCnvctnDetails(appNum, AppConstants.CNVCT_SFE);
			rmcUbuBnftCnvctnColl = abHouseHoldMemberBO.getRmcBnftCnvctnDetails(appNum, AppConstants.CNVCT_UBU);
			rmcVqjBnftCnvctnColl = abHouseHoldMemberBO.getRmcBnftCnvctnDetails(appNum, AppConstants.CNVCT_VQJ);
			rmcDftBnftCnvctnColl = abHouseHoldMemberBO.getRmcBnftCnvctnDetails(appNum, AppConstants.CNVCT_DFT);
			if(rmcTsbBnftCnvctnColl == null){
				rmcTsbBnftCnvctnColl = new APP_IN_BNFT_CNVCTN_Collection();
			}
			
			if(rmcFriBnftCnvctnColl == null){
				rmcFriBnftCnvctnColl = new APP_IN_BNFT_CNVCTN_Collection();
			}
			
			if(rmcTraBnftCnvctnColl == null){
				rmcTraBnftCnvctnColl = new APP_IN_BNFT_CNVCTN_Collection();
			}
			
			if(rmcPdsBnftCnvctnColl == null){
				rmcPdsBnftCnvctnColl = new APP_IN_BNFT_CNVCTN_Collection();
			}
			
			if(rmcSfeBnftCnvctnColl == null){
				rmcSfeBnftCnvctnColl = new APP_IN_BNFT_CNVCTN_Collection();
			}
			
			if(rmcUbuBnftCnvctnColl == null){
				rmcUbuBnftCnvctnColl = new APP_IN_BNFT_CNVCTN_Collection();
			}
			
			if(rmcVqjBnftCnvctnColl == null){
				rmcVqjBnftCnvctnColl = new APP_IN_BNFT_CNVCTN_Collection();
			}
			
			if(rmcDftBnftCnvctnColl == null){
				rmcDftBnftCnvctnColl = new APP_IN_BNFT_CNVCTN_Collection();
			}
			
			RMCBnftCnvctnTSBSummaryListVIew rmcBnftCnvctnTSBSummaryListVIew = new RMCBnftCnvctnTSBSummaryListVIew();
			RMCBnftCnvctnFRISummaryListVIew rmcBnftCnvctnFRISummaryListVIew = new RMCBnftCnvctnFRISummaryListVIew();
			RMCBnftCnvctnTRASummaryListVIew rmcBnftCnvctnTRASummaryListVIew = new RMCBnftCnvctnTRASummaryListVIew();
			RMCBnftCnvctnPDSSummaryListVIew rmcBnftCnvctnPDSSummaryListVIew = new RMCBnftCnvctnPDSSummaryListVIew();
			RMCBnftCnvctnSFESummaryListVIew rmcBnftCnvctnSFESummaryListVIew = new RMCBnftCnvctnSFESummaryListVIew();
			RMCBnftCnvctnUBUSummaryListVIew rmcBnftCnvctnUBUSummaryListVIew = new RMCBnftCnvctnUBUSummaryListVIew();
			RMCBnftCnvctnVQJSummaryListVIew rmcBnftCnvctnVQJSummaryListVIew = new RMCBnftCnvctnVQJSummaryListVIew();
			RMCBnftCnvctnDFTSummaryListVIew rmcBnftCnvctnDFTSummaryListVIew = new RMCBnftCnvctnDFTSummaryListVIew();
			
			rmcBnftCnvctnTSBSummaryListVIew.setBnftCnvctnCollection(rmcTsbBnftCnvctnColl);
			rmcBnftCnvctnFRISummaryListVIew.setBnftCnvctnCollection(rmcFriBnftCnvctnColl);
			rmcBnftCnvctnTRASummaryListVIew.setBnftCnvctnCollection(rmcTraBnftCnvctnColl);
			rmcBnftCnvctnPDSSummaryListVIew.setBnftCnvctnCollection(rmcPdsBnftCnvctnColl);
			rmcBnftCnvctnSFESummaryListVIew.setBnftCnvctnCollection(rmcSfeBnftCnvctnColl);
			rmcBnftCnvctnUBUSummaryListVIew.setBnftCnvctnCollection(rmcUbuBnftCnvctnColl);
			rmcBnftCnvctnVQJSummaryListVIew.setBnftCnvctnCollection(rmcVqjBnftCnvctnColl);
			rmcBnftCnvctnDFTSummaryListVIew.setBnftCnvctnCollection(rmcDftBnftCnvctnColl);
			
			rmcBnftCnvctnTSBSummaryListVIew.setLanguage(language);
			rmcBnftCnvctnTSBSummaryListVIew
			.setName("RMC_BNFTCNVCTN_TSB_SUMMARY_LISTVIEW");
			rmcBnftCnvctnTSBSummaryListVIew.setAppType(appType);
			rmcBnftCnvctnTSBSummaryListVIew.setDisplayData(rmcTsbBnftCnvctnColl);
			rmcBnftCnvctnTSBSummaryListVIew.setPageSize(1000);
			
			rmcBnftCnvctnFRISummaryListVIew.setLanguage(language);
			rmcBnftCnvctnFRISummaryListVIew
			.setName("RMC_BNFTCNVCTN_FRI_SUMMARY_LISTVIEW");
			rmcBnftCnvctnFRISummaryListVIew.setAppType(appType);
			rmcBnftCnvctnFRISummaryListVIew.setDisplayData(rmcFriBnftCnvctnColl);
			rmcBnftCnvctnFRISummaryListVIew.setPageSize(1000);
			
			rmcBnftCnvctnTRASummaryListVIew.setLanguage(language);
			rmcBnftCnvctnTRASummaryListVIew
			.setName("RMC_BNFTCNVCTN_TRA_SUMMARY_LISTVIEW");
			rmcBnftCnvctnTRASummaryListVIew.setAppType(appType);
			rmcBnftCnvctnTRASummaryListVIew.setDisplayData(rmcTraBnftCnvctnColl);
			rmcBnftCnvctnTRASummaryListVIew.setPageSize(1000);
			
			rmcBnftCnvctnPDSSummaryListVIew.setLanguage(language);
			rmcBnftCnvctnPDSSummaryListVIew
			.setName("RMC_BNFTCNVCTN_PDS_SUMMARY_LISTVIEW");
			rmcBnftCnvctnPDSSummaryListVIew.setAppType(appType);
			rmcBnftCnvctnPDSSummaryListVIew.setDisplayData(rmcPdsBnftCnvctnColl);
			rmcBnftCnvctnPDSSummaryListVIew.setPageSize(1000);
			
			rmcBnftCnvctnSFESummaryListVIew.setLanguage(language);
			rmcBnftCnvctnSFESummaryListVIew
			.setName("RMC_BNFTCNVCTN_SFE_SUMMARY_LISTVIEW");
			rmcBnftCnvctnSFESummaryListVIew.setAppType(appType);
			rmcBnftCnvctnSFESummaryListVIew.setDisplayData(rmcSfeBnftCnvctnColl);
			rmcBnftCnvctnSFESummaryListVIew.setPageSize(1000);
			
			rmcBnftCnvctnUBUSummaryListVIew.setLanguage(language);
			rmcBnftCnvctnUBUSummaryListVIew
			.setName("RMC_BNFTCNVCTN_UBU_SUMMARY_LISTVIEW");
			rmcBnftCnvctnUBUSummaryListVIew.setAppType(appType);
			rmcBnftCnvctnUBUSummaryListVIew.setDisplayData(rmcUbuBnftCnvctnColl);
			rmcBnftCnvctnUBUSummaryListVIew.setPageSize(1000);
			
			rmcBnftCnvctnVQJSummaryListVIew.setLanguage(language);
			rmcBnftCnvctnVQJSummaryListVIew
			.setName("RMC_BNFTCNVCTN_VQJ_SUMMARY_LISTVIEW");
			rmcBnftCnvctnVQJSummaryListVIew.setAppType(appType);
			rmcBnftCnvctnVQJSummaryListVIew.setDisplayData(rmcVqjBnftCnvctnColl);
			rmcBnftCnvctnVQJSummaryListVIew.setPageSize(1000);
			
			rmcBnftCnvctnDFTSummaryListVIew.setLanguage(language);
			rmcBnftCnvctnDFTSummaryListVIew
			.setName("RMC_BNFTCNVCTN_DFT_SUMMARY_LISTVIEW");
			rmcBnftCnvctnDFTSummaryListVIew.setAppType(appType);
			rmcBnftCnvctnDFTSummaryListVIew.setDisplayData(rmcDftBnftCnvctnColl);
			rmcBnftCnvctnDFTSummaryListVIew.setPageSize(1000);
			
			pageCollection.put("TSBSummaryColl", rmcTsbBnftCnvctnColl);
			pageCollection.put("FRISummaryColl", rmcFriBnftCnvctnColl);
			pageCollection.put("TRASummaryColl", rmcTraBnftCnvctnColl);
			pageCollection.put("PDSSummaryColl", rmcPdsBnftCnvctnColl);
			pageCollection.put("SFESummaryColl", rmcSfeBnftCnvctnColl);
			pageCollection.put("UBUSummaryColl", rmcUbuBnftCnvctnColl);
			pageCollection.put("VQJSummaryColl", rmcVqjBnftCnvctnColl);
			pageCollection.put("DFTSummaryColl", rmcDftBnftCnvctnColl);
			
			
			pageCollection.put("RMC_BNFTCNVCTN_TSB_SUMMARY_LISTVIEW",
					rmcBnftCnvctnTSBSummaryListVIew);
			pageCollection.put("RMC_BNFTCNVCTN_FRI_SUMMARY_LISTVIEW",
					rmcBnftCnvctnFRISummaryListVIew);
			pageCollection.put("RMC_BNFTCNVCTN_TRA_SUMMARY_LISTVIEW",
					rmcBnftCnvctnTRASummaryListVIew);
			pageCollection.put("RMC_BNFTCNVCTN_PDS_SUMMARY_LISTVIEW",
					rmcBnftCnvctnPDSSummaryListVIew);
			pageCollection.put("RMC_BNFTCNVCTN_SFE_SUMMARY_LISTVIEW",
					rmcBnftCnvctnSFESummaryListVIew);
			pageCollection.put("RMC_BNFTCNVCTN_UBU_SUMMARY_LISTVIEW",
					rmcBnftCnvctnUBUSummaryListVIew);
			pageCollection.put("RMC_BNFTCNVCTN_VQJ_SUMMARY_LISTVIEW",
					rmcBnftCnvctnVQJSummaryListVIew);
			pageCollection.put("RMC_BNFTCNVCTN_DFT_SUMMARY_LISTVIEW",
					rmcBnftCnvctnDFTSummaryListVIew);
			/*
			 * benefit convictions listviews - end
			 */

			/* Nursing Home */
			final ABHouseHoldMemberBO aBHouseHoldMemberBO = new ABHouseHoldMemberBO();
			final CP_APP_IN_CARE_PROV_Collection nusingHomeCollection = aBHouseHoldMemberBO
					.loadNursingcareDetailsWithCareType(appNum,
							AppConstants.NURSING_INFORMATION);
			final RMCNursingHomeChangesSummaryListView rMCNursingHomeChangesSummaryListView = new RMCNursingHomeChangesSummaryListView();
			rMCNursingHomeChangesSummaryListView
			.setNursingHomeCollection(nusingHomeCollection);
			rMCNursingHomeChangesSummaryListView.setLanguage(language);
			rMCNursingHomeChangesSummaryListView
			.setName("RMC_NURHOME_SUMMARY_LISTVIEW");
			rMCNursingHomeChangesSummaryListView
			.setDisplayData(nusingHomeCollection);
			rMCNursingHomeChangesSummaryListView.setPageSize(999);
			pageCollection.put("CP_APP_IN_CARE_PROV_Collection",
					nusingHomeCollection);
			pageCollection.put("RMC_NURHOME_SUMMARY_LISTVIEW",
					rMCNursingHomeChangesSummaryListView);
			/* Nursing Home Ends here */

			/* Hospice Care */
			final RMCHospiceChangesSummaryListView rMCHospiceChangesSummaryListView = new RMCHospiceChangesSummaryListView();
			final CP_APP_IN_CARE_PROV_Collection hosPice_Collection = aBHouseHoldMemberBO.loadNursingcareDetailsWithCareType(appNum,
					AppConstants.HOSPICE_INFORMATION);
			final CP_APP_IN_CARE_PROV_Collection hospiceStayCollectionlForListView = new CP_APP_IN_CARE_PROV_Collection();
			rMCHospiceChangesSummaryListView.setHosPiceCollection(hosPice_Collection);
			rMCHospiceChangesSummaryListView.setLanguage(language);
			rMCHospiceChangesSummaryListView.setName("RMC_HOSPICE_SUMMARY_LISTVIEW");
			/* VG SONAR Cleanup - 09/1/2015 Deleted 1,1  lines Commented Code in this block*/
			
			rMCHospiceChangesSummaryListView.setPageSize(999);
			
			/* Hospice Ends here */
			
			//* Out of State Benefits */
			final RMCOutStateSummaryListView rMCOutStateSummaryListView = new RMCOutStateSummaryListView();
			final OutOfStateBenefitsBO outBO = new OutOfStateBenefitsBO();
			final APP_IN_OUT_ST_BNFT_Collection appInoutColl = outBO.loadOutOfStateDetailsBySrcInd(appNum);
			final Map additionalInfoOutStateBenefits = new HashMap();
			additionalInfoOutStateBenefits.put("PEOPLE_HANDLER",peopleHandler);
			rMCOutStateSummaryListView.setAdditionalInfo(additionalInfoOutStateBenefits);
			rMCOutStateSummaryListView.setOutStateCollection(appInoutColl);
			rMCOutStateSummaryListView.setLanguage(language);
			rMCOutStateSummaryListView.setName("RMC_OUTSTATE_SUMMARY_LISTVIEW");
			rMCOutStateSummaryListView.setDisplayData(appInoutColl);
			rMCOutStateSummaryListView.setPageSize(999);
			pageCollection.put("RMC_OUTSTATE_SUMMARY_LISTVIEW", rMCOutStateSummaryListView);
			/* Out State benefits ends here*/
			
			/* Hospital Stay */
			final RMCHospitalStaySummaryListView rMCHospitalStaySummaryListView = new RMCHospitalStaySummaryListView();
			final CP_APP_IN_CARE_PROV_Collection hosStay_Collection = aBHouseHoldMemberBO.loadNursingcareDetailsWithCareType(appNum,
					AppConstants.HOSPITAL_STAY);
			final CP_APP_IN_CARE_PROV_Collection hosStayCollectionlForListView = new CP_APP_IN_CARE_PROV_Collection();
			rMCHospitalStaySummaryListView.setHospitalStayCollection(hosStay_Collection);
			rMCHospitalStaySummaryListView.setLanguage(language);
			rMCHospitalStaySummaryListView.setName("RMC_HSTAY_SUMMARY_LISTVIEW");
			rMCHospitalStaySummaryListView.setPageSize(999);
			/* Hospital Stay ends here */
				
			/* Medicare AB */
			final RMCMedicareChangeSummaryListView rMCMedicareChangeSummaryListView = new RMCMedicareChangeSummaryListView();
			final MedicareBO medicareBO = new MedicareBO();
			final APP_IN_MEDCR_Collection medColl = medicareBO.loadMedicareDetails(appNum);
			rMCMedicareChangeSummaryListView.setMedicareCollection(medColl);
			rMCMedicareChangeSummaryListView.setLanguage(language);
			rMCMedicareChangeSummaryListView.setName("RMC_MEDIC_SUMMARY_LISTVIEW");
			rMCMedicareChangeSummaryListView.setDisplayData(medColl);
			rMCMedicareChangeSummaryListView.setPageSize(999);
			pageCollection.put("RMC_MEDIC_SUMMARY_LISTVIEW", rMCMedicareChangeSummaryListView);
			

			// get covered indvs
			
			StringBuilder sb = null;
			final Map coveredIndvMap = new HashMap();
			final int medInsCollSize = medInsColl != null ? medInsColl.size() : 0;
			for (int i = 0; i < medInsCollSize; i++) {
				sb = new StringBuilder();
				medInsCargo = medInsColl.getCargo(i);
				heathCareBO.loadModifiedCollection(medInsCargo.getApp_num());
				coveredIndvMap.put(medInsCargo.getIndv_seq_num() + "_" + medInsCargo.getSeq_num(), sb);
			}
			final INDIVIDUAL_Custom_Collection schColl = new INDIVIDUAL_Custom_Collection();
			final INDIVIDUAL_Custom_Collection indvColl = peopleHandler.getInHomeIndividuals();
			for (int i = 0; i < indvColl.size(); i++) {
				boolean found = false;
				final INDIVIDUAL_Custom_Cargo indvCargo = indvColl.getResult(i);

				for (int j = 0; j < schoolEnrollColl.size(); j++) {
					final APP_IN_SCHLE_Cargo schCargo = schoolEnrollColl.getResult(j);
					if (schCargo.getIndv_seq_num().equals(indvCargo.getIndv_seq_num())) {
						found = true;
					}
				}
				if (!found) {
					schColl.addCargo(indvCargo);
				}

			}
			pageCollection.put("NEWINDV", schColl);
			
			/*Past Health Insurance - Start */
			final INDIVIDUAL_Custom_Collection pastHealthColl = new INDIVIDUAL_Custom_Collection();
			for (int i = 0; i < indvColl.size(); i++) {
				boolean pastHealthInsuFound = false;
				final INDIVIDUAL_Custom_Cargo indvCargo = indvColl.getResult(i);

				for (int j = 0; j < pastHealthcoll.size(); j++) {
					final CP_APP_IN_LST_HLTH_INS_Cargo pastHealthInsuCargo = pastHealthcoll.getResult(j);
					if (pastHealthInsuCargo.getIndv_seq_num().equals(indvCargo.getIndv_seq_num())) {
						pastHealthInsuFound = true;
					}
				}
				if (!pastHealthInsuFound) {
					pastHealthColl.addCargo(indvCargo);
				}
			}
			pageCollection.put("PASTHEALTHINSINDV", pastHealthColl);	
			/*Past Health Insurance - End */

			// Nursing Home indivs start
			final INDIVIDUAL_Custom_Collection nurColl = new INDIVIDUAL_Custom_Collection();
			for (int i = 0; i < indvColl.size(); i++) {
				boolean nurFound = false;
				final INDIVIDUAL_Custom_Cargo indvCargo = indvColl.getResult(i);

				for (int j = 0; j < nusingHomeCollection.size(); j++) {
					final CP_APP_IN_CARE_PROV_Cargo nurHomeCargo = nusingHomeCollection.getResult(j);
					if (nurHomeCargo.getIndv_seq_num().equals(indvCargo.getIndv_seq_num())) {
						nurFound = true;
					}
				}
				if (!nurFound) {
					nurColl.addCargo(indvCargo);
				}
			}
			pageCollection.put("NURHOMENEWINDV", nurColl);

			// Nursing Home indivs ends 
			// Hospice indivs start
			final INDIVIDUAL_Custom_Collection hosColl = new INDIVIDUAL_Custom_Collection();
			for (int i = 0; i < indvColl.size(); i++) {
				boolean hosFound = false;
				final INDIVIDUAL_Custom_Cargo indvCargo = indvColl.getResult(i);

				for (int j = 0; j < hosPice_Collection.size(); j++) {
					final CP_APP_IN_CARE_PROV_Cargo hosPiceCargo = hosPice_Collection.getResult(j);
					if (hosPiceCargo.getIndv_seq_num().equals(indvCargo.getIndv_seq_num())) {
						hosFound = true;
						CP_APP_IN_CARE_PROV_Collection inColl = getIndividualColl(hosPice_Collection, indvCargo.getIndv_seq_num());
						if(inColl.size()>1){
							if(inColl.getCargo(0).getSrc_app_ind().equals(AppConstants.CWW_RECORD_IND)){
								hospiceStayCollectionlForListView.add(inColl.getCargo(1));
							} else {
								hospiceStayCollectionlForListView.add(inColl.getCargo(0));
							}														
						} else {
							hospiceStayCollectionlForListView.add(hosPice_Collection.get(j));
						}						
						break;
					}
				}
				if (!hosFound) {
					hosColl.addCargo(indvCargo);
				}
			}
			pageCollection.put("HOSPICENEWINDV", hosColl);
			rMCHospiceChangesSummaryListView.setDisplayData(hospiceStayCollectionlForListView);
			pageCollection.put("RMC_HOSPICE_SUMMARY_LISTVIEW", rMCHospiceChangesSummaryListView);

			// Hospice indivs ends
			// Hospital stay indiv starthere
			final INDIVIDUAL_Custom_Collection hospitalColl = new INDIVIDUAL_Custom_Collection();
			for (int i = 0; i < indvColl.size(); i++) {
				boolean hosFound = false;
				final INDIVIDUAL_Custom_Cargo indvCargo = indvColl.getResult(i);

				for (int j = 0; j < hosStay_Collection.size(); j++) {
					final CP_APP_IN_CARE_PROV_Cargo hospitalCargo = hosStay_Collection.getResult(j);
					if (hospitalCargo.getIndv_seq_num().equals(indvCargo.getIndv_seq_num())) {
						hosFound = true;
						CP_APP_IN_CARE_PROV_Collection inColl = getIndividualColl(hosStay_Collection, indvCargo.getIndv_seq_num());
						if(inColl.size()>1){
							if(inColl.getCargo(0).getSrc_app_ind().equals(AppConstants.CWW_RECORD_IND)){
								hosStayCollectionlForListView.add(inColl.getCargo(1));
							} else {
								hosStayCollectionlForListView.add(inColl.getCargo(0));
							}
							
						} else {
							hosStayCollectionlForListView.add(hosStay_Collection.get(j));
						}
						
						break;
					}
				}
				if (!hosFound) {
					hospitalColl.addCargo(indvCargo);
				}
			}
			pageCollection.put("HOSPITALNEWINDV", hospitalColl);

			rMCHospitalStaySummaryListView.setDisplayData(hosStayCollectionlForListView);
			pageCollection.put("RMC_HSTAY_SUMMARY_LISTVIEW", rMCHospitalStaySummaryListView);
			// Hospital stay indiv ends here
			// Outstate starts here

			final INDIVIDUAL_Custom_Collection outStateColl = new INDIVIDUAL_Custom_Collection();
			for (int i = 0; i < indvColl.size(); i++) {
				boolean outFound = false;
				final INDIVIDUAL_Custom_Cargo indvCargo = indvColl.getResult(i);

				for (int j = 0; j < appInoutColl.size(); j++) {
					final APP_IN_OUT_ST_BNFT_Cargo outCargo = appInoutColl.getResult(j);
					if (outCargo.getIndv_seq_num().equals(indvCargo.getIndv_seq_num())) {
						outFound = true;
					}
				}
				if (!outFound) {
					outStateColl.addCargo(indvCargo);
				}
			}
			pageCollection.put("OUTSTATENEWINDV", outStateColl);
			// Out State ends here	

			// medicare starts here
			final INDIVIDUAL_Custom_Collection medicareIndvColl = new INDIVIDUAL_Custom_Collection();
			for (int i = 0; i < indvColl.size(); i++) {
				boolean medFound = false;
				final INDIVIDUAL_Custom_Cargo indvCargo = indvColl.getResult(i);

				for (int j = 0; j < medColl.size(); j++) {
					final APP_IN_MEDCR_Cargo medCargo = medColl.getResult(j);
					if (medCargo.getIndv_seq_num().equals(indvCargo.getIndv_seq_num())) {
						medFound = true;
					}
				}
				if (!medFound) {
					medicareIndvColl.addCargo(indvCargo);
				}
			}
			pageCollection.put("MEDICARENEWINDV", medicareIndvColl);
			// medicare ends here

			final INDIVIDUAL_Custom_Collection convictionIndvColl = new INDIVIDUAL_Custom_Collection();
			for (int i = 0; i < indvColl.size(); i++) {
				final INDIVIDUAL_Custom_Cargo indvCargo = indvColl.getResult(i);

				for (int j = 0; j < felonDetCollection.size(); j++) {
					final APP_IN_FELON_DET_Cargo felnCargo = felonDetCollection.getCargo(j);
					if (felnCargo.getIndv_seq_num().equals(indvCargo.getIndv_seq_num())) {
					}
				}
				/* VG SONAR Cleanup - 09/1/2015 Deleted 1,1  lines Commented Code in this block*/

				convictionIndvColl.addCargo(indvCargo);

			}
			pageCollection.put("CONVICTIONNEWINDV", convictionIndvColl);

			
			createandLoadAROBSResponseMapsToPageCollection(prflColl, pageCollection, peopleHandler, true, driverStatus, true);
			componentManager.getComponents("AROBS", txnBean);
			// set pageCollection into transaction Bean
			txnBean.setPageCollection(pageCollection);

			// Put into session of these two collections
			pageCollection.put("APP_IN_SCHLE_Collection", schoolEnrollColl);
			pageCollection.put("APP_IN_HLTH_INS_BNFTS_Collection", medInsColl);
			pageCollection.put("APP_MED_INS_Collection_PAST", pastInsColl);
			pageCollection.put("APP_IN_MED_INS_Collection", appInMedInsColl);
			pageCollection.put("CP_APP_IN_LST_HLTH_INS_Collection", pastHealthcoll);
			pageCollection.put("NEW_OR_MOD_SCHE_EXISTS", newOrModifiedSchlEnrlExists);

			session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER, selectionProfile);
			// set before collection to pageCollection
			session.put(FwConstants.BEFORE_COLLECTION, pageCollection);
			txnBean.setSession(session);

			log(ILog.INFO, "RMCOtherBenefitsEJBBean::loadOtherBenefitsSummary:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("loadOtherBenefitsSummary");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"loadOtherBenefitsSummary", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.loadOtherBenefitsSummary() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Prepare health coverage map.
	 *
	 * @param loadHealthCarePolicyCoverageIndv the load health care policy coverage indv
	 * @return the map
	 */
	private Map<String, Map<String, Map<String, CP_APP_IN_MED_INS_CVRG_Collection>>> prepareHealthCoverageMap(
			final CP_APP_IN_MED_INS_CVRG_Collection loadHealthCarePolicyCoverageIndv) {
		final Map<String, Map<String, Map<String, CP_APP_IN_MED_INS_CVRG_Collection>>> coverageMap = new HashMap<String, Map<String, Map<String, CP_APP_IN_MED_INS_CVRG_Collection>>>();
		Map<String, CP_APP_IN_MED_INS_CVRG_Collection> policyMap = null;
		Map<String, Map<String, CP_APP_IN_MED_INS_CVRG_Collection>> individualMap = null;
		CP_APP_IN_MED_INS_CVRG_Collection coveragePolicyCollection = null;
		for (final Object coverageObject : loadHealthCarePolicyCoverageIndv) {
			final CP_APP_IN_MED_INS_CVRG_Cargo coverageCargo = (CP_APP_IN_MED_INS_CVRG_Cargo) coverageObject;
			if (coverageMap.containsKey(coverageCargo.getIndv_seq_num())) {
				individualMap = coverageMap
						.get(coverageCargo.getIndv_seq_num());
			} else {
				individualMap = new HashMap<String, Map<String, CP_APP_IN_MED_INS_CVRG_Collection>>();
			}

			if (individualMap.containsKey(coverageCargo.getPlcy_seq_num())) {
				policyMap = individualMap.get(coverageCargo.getPlcy_seq_num());
			} else {
				policyMap = new HashMap<String, CP_APP_IN_MED_INS_CVRG_Collection>();
			}
			if (policyMap.containsKey(coverageCargo.getSrc_app_ind())) {
				coveragePolicyCollection = policyMap.get(coverageCargo
						.getSrc_app_ind());
			} else {
				coveragePolicyCollection = new CP_APP_IN_MED_INS_CVRG_Collection();
			}

			coveragePolicyCollection.add(coverageCargo);
			policyMap.put(coverageCargo.getSrc_app_ind(),
					coveragePolicyCollection);
			individualMap.put(coverageCargo.getPlcy_seq_num(), policyMap);
			coverageMap.put(coverageCargo.getIndv_seq_num(), individualMap);

		}
		return coverageMap;
	}

	/**
	 * Store other benefits summary.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 * @throws javax.ejb.EJBException the javax.ejb. ejb exception
	 */
	public void storeOtherBenefitsSummary(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.storeOtherBenefitsSummary() - START");

		try {
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::storeOtherBenefitsSummary:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final String currentPageID = (String) request
					.get(FwConstants.CURRENT_PAGE_ID);
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);
			pageCollection.get("NO_ONE_Collection");
			// Get App Number
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			final String backToMyAccess = (String) request
					.get(AppConstants.BACK_TO_MY_ACCESS_BUTTON);
			if (backToMyAccess != null) {
				if (checkBackToMyAccessSelected(request)) {
					request.get(FwConstants.WARNING_MSG_DETAILS);
					txnBean.setPageCollection((Map) session
							.get(FwConstants.BEFORE_COLLECTION));
					return;
				}
			}
			//Migrant form worker logic
			boolean snapFlag = true;
			APP_INDV_ADDI_INFO_Collection additionalInfoColl = null;
			additionalInfoColl = (APP_INDV_ADDI_INFO_Collection) pageCollection
					.get("APP_INDV_ADDI_INFO_Collection");

			APP_INDV_ADDI_INFO_Cargo addiInfoCargo = null;
			final OtherBenefitsBO benefitsBO = new OtherBenefitsBO();
			final Map noOneCheckedMap = (Map) beforeColl
					.get(AppConstants.NO_ONE_CHECKED_MAP);
			final int driverStatus = driverManager.getAFBStatus(
					FwConstants.RMC_DRIVER, "AROBS", driverArray);
			beforeColl.get(FwConstants.PAGE_COMPONENT_LIST);
			final RMC_IN_PRFL_Collection beforePrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			final RMC_IN_PRFL_Collection rmcPrflColl = (RMC_IN_PRFL_Collection) pageCollection
					.get("RMC_IN_PRFL_Collection");
			final RMC_IN_PRFL_Collection rmcInPrflSessColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			final RMC_IN_PRFL_Collection rmcInPrflPageColl = (RMC_IN_PRFL_Collection) pageCollection
					.get("RMC_IN_PRFL_Collection");
			for (int i = 0; i < rmcInPrflPageColl.size(); i++) {
				final RMC_IN_PRFL_Cargo cargo = rmcInPrflPageColl.getCargo(i);

				if (cargo.getSpecial_need_resp() == null) {
					cargo.setSpecial_need_resp(FwConstants.NO);
				}
				if (cargo.getFoster_care_resp() == null) {
					cargo.setFoster_care_resp(FwConstants.NO);
				}
				if (cargo.getFormer_foster_resp() == null) {
					cargo.setFormer_foster_resp(FwConstants.NO);
				}

				if (cargo.getChild_protective_resp() == null) {
					cargo.setChild_protective_resp(FwConstants.NO);
				}
				if (cargo.getLiving_prog_resp() == null) {
					cargo.setLiving_prog_resp(FwConstants.NO);
				}
				if (cargo.getGrand_parent_resp() == null) {
					cargo.setGrand_parent_resp(FwConstants.NO);
				}
				if (cargo.getDrug_felonies_resp() == null) {
					cargo.setDrug_felonies_resp(FwConstants.NO);
				}

				if (cargo.getSnap_tanf_disc_resp() == null) {
					cargo.setSnap_tanf_disc_resp(FwConstants.NO);
				}

				if (cargo.getTanfDiscResp() == null) {
					cargo.setTanfDiscResp(FwConstants.NO);
				}

				if (cargo.getAvoid_prosc_resp() == null) {
					cargo.setAvoid_prosc_resp(FwConstants.NO);
				}
				if (cargo.getViolating_parole_resp() == null) {
					cargo.setViolating_parole_resp(FwConstants.NO);
				}
				if (cargo.getConvic_false_info_resp() == null) {
					cargo.setConvic_false_info_resp(FwConstants.NO);
				}
				if (cargo.getVoluntarily_quit_job_resp() == null) {
					cargo.setVoluntarily_quit_job_resp(FwConstants.NO);
				}
				if (cargo.getTrading_snap_resp() == null) {
					cargo.setTrading_snap_resp(FwConstants.NO);
				}
				if (cargo.getBuy_sell_snap_resp() == null) {
					cargo.setBuy_sell_snap_resp(FwConstants.NO);
				}
				if (cargo.getTrade_snap_gun_resp() == null) {
					cargo.setTrade_snap_gun_resp(FwConstants.NO);
				}
				if (cargo.getPrev_ssi_resp() == null) {
					cargo.setPrev_ssi_resp(FwConstants.NO);
				}
				if (cargo.getHome_community_resp() == null) {
					cargo.setHome_community_resp(FwConstants.NO);
				}
				if (cargo.getTribal_health_resp() == null) {
					cargo.setTribal_health_resp(FwConstants.NO);
				}
				if (cargo.getTribal_eligibility_resp() == null) {
					cargo.setTribal_eligibility_resp(FwConstants.NO);
				}
				if (cargo.getDomestic_violence_resp() == null) {
					cargo.setDomestic_violence_resp(FwConstants.NO);
				}
				if (cargo.getTanf_eppic_resp() == null) {
					cargo.setTanf_eppic_resp(FwConstants.NO);
				}
				if (cargo.getEmergency_medical_resp() == null) {
					cargo.setEmergency_medical_resp(FwConstants.NO);
				}
				if (cargo.getAvd_prsctn_fstf() == null) {
					cargo.setAvd_prsctn_fstf(FwConstants.NO);
				}

			}

			final short[] questionsArrayForIndv = new short[26];
			questionsArrayForIndv[0] = IRMCResponseProfileManager.SPECIAL_NEED;
			questionsArrayForIndv[1] = IRMCResponseProfileManager.FOSTER_CARE_RESP;
			questionsArrayForIndv[2] = IRMCResponseProfileManager.FORMER_FOSTER_RESP;
			questionsArrayForIndv[3] = IRMCResponseProfileManager.CHILD_PROTECTIVE_RESP;
			questionsArrayForIndv[4] = IRMCResponseProfileManager.LIVING_PROG_RESP;
			questionsArrayForIndv[5] = IRMCResponseProfileManager.GRAND_PARENT_RESP;
			questionsArrayForIndv[6] = IRMCResponseProfileManager.DRUG_FELONIES_RESP;
			questionsArrayForIndv[7] = IRMCResponseProfileManager.SNAP_TANF_DISC_RESP;
			questionsArrayForIndv[8] = IRMCResponseProfileManager.TANF_DISC_RESP;
			questionsArrayForIndv[9] = IRMCResponseProfileManager.AVOID_PROSC_RESP;
			questionsArrayForIndv[10] = IRMCResponseProfileManager.VIOLATING_PAROLE_RESP;
			questionsArrayForIndv[11] = IRMCResponseProfileManager.CONVIC_FALSE_INFO_RESP;
			questionsArrayForIndv[12] = IRMCResponseProfileManager.VOLUNTARILY_QUIT_JOB_RESP;
			questionsArrayForIndv[13] = IRMCResponseProfileManager.TRADING_SNAP_RESP;
			questionsArrayForIndv[14] = IRMCResponseProfileManager.BUY_SELL_SNAP_RESP;
			questionsArrayForIndv[15] = IRMCResponseProfileManager.TRADE_SNAP_GUN_RESP;
			questionsArrayForIndv[16] = IRMCResponseProfileManager.PREV_SSI_RESP;
			questionsArrayForIndv[17] = IRMCResponseProfileManager.HOME_COMMUNITY_RESP;
			questionsArrayForIndv[18] = IRMCResponseProfileManager.TRIBAL_HEALTH_RESP;
			questionsArrayForIndv[19] = IRMCResponseProfileManager.TRIBAL_ELIGIBILITY_RESP;
			questionsArrayForIndv[20] = IRMCResponseProfileManager.DOMESTIC_VIOLENCE_RESP;
			questionsArrayForIndv[21] = IRMCResponseProfileManager.TANF_EPPIC_RESP;
			questionsArrayForIndv[22] = IRMCResponseProfileManager.EMERGENCY_MEDICAL_RESP;
			questionsArrayForIndv[23] = IRMCResponseProfileManager.MEDICARE_CHG_IND;
			questionsArrayForIndv[24] = IRMCResponseProfileManager.AVD_PRSCTN_FSTF;
			questionsArrayForIndv[25] = IRMCResponseProfileManager.KATIE_BECKETT;

			final AROBQValidator validator = new AROBQValidator();
			benefitsBO.validateMigrantSection(additionalInfoColl,snapFlag);

			if (validator.hasMessages()||benefitsBO.hasMessages()) {
				FwMessageList list1=new FwMessageList(); 
				list1.addMessageToList(validator.getMessageList());
				list1.addMessageToList(benefitsBO.getMessageList());
				request.put(FwConstants.MESSAGE_LIST, list1);
				pageCollection.put("PEOPLE_5202", beforeColl.get("PEOPLE_5202"));
				pageCollection.put("PEOPLE_5205", beforeColl.get("PEOPLE_5205"));
				pageCollection.put("PEOPLE_5203", beforeColl.get("PEOPLE_5203"));
				pageCollection.put("PEOPLE_5203", beforeColl.get("PEOPLE_5203"));
				pageCollection.put("PEOPLE_5271", beforeColl.get("PEOPLE_5271"));
				pageCollection.put("RMC_SCHOOLENRL_SUMMARY_LISTVIEW", beforeColl.get("RMC_SCHOOLENRL_SUMMARY_LISTVIEW"));
				pageCollection.put("APP_IN_HLTH_INS_BNFTS_LISTVIEW", beforeColl.get("APP_IN_HLTH_INS_BNFTS_LISTVIEW"));
				pageCollection.put("RMC_PASTINS_SUMMARY_LISTVIEW", beforeColl.get("RMC_PASTINS_SUMMARY_LISTVIEW"));
				pageCollection.put("RMC_MAPP_SUMMARY_LISTVIEW", beforeColl.get("RMC_MAPP_SUMMARY_LISTVIEW"));
				pageCollection.put("APP_INDV_ADDI_INFO_Collection", beforeColl.get("APP_INDV_ADDI_INFO_Collection"));
				final PeopleHandler peopleHandler = (PeopleHandler) session.get(AppConstants.INDIV_MASTER_HANDLER);
				createandLoadAROBSResponseMapsToPageCollectionAfterValidation(rmcPrflColl, beforePrflColl, pageCollection, peopleHandler, true,
						driverStatus, true);
				final Map respMap5202 = (Map) pageCollection.get("RESP_MAP_5202");

				if (respMap5202 != null) {
					for (int j = 0; j < rmcPrflColl.size(); j++) {
						final RMC_IN_PRFL_Cargo custCargo = rmcPrflColl.getCargo(j);
						if (respMap5202.containsKey(custCargo.getIndv_seq_num())) {
							final String value = (String) respMap5202.get(custCargo.getIndv_seq_num());
							if ((value != null) && FwConstants.YES.equals(value)) {
								respMap5202.put(custCargo.getIndv_seq_num(), "R");
							}
						}
					}
				}

				pageCollection.put("RESP_MAP_5202", respMap5202);
				pageCollection.put("APP_IN_SCHLE_Collection",
						beforeColl.get("APP_IN_SCHLE_Collection"));
				pageCollection.put("APP_MED_INS_Collection",
						beforeColl.get("APP_MED_INS_Collection"));
				pageCollection.put("APP_IN_MAPP_Collection",
						beforeColl.get("APP_IN_MAPP_Collection"));
				pageCollection.put("APP_IN_MED_INS_Collection",
						beforeColl.get("APP_IN_MED_INS_Collection"));
				pageCollection.put("CP_APP_IN_LST_HLTH_INS_Collection",
						beforeColl.get("CP_APP_IN_LST_HLTH_INS_Collection"));
				pageCollection.put("NEW_OR_MOD_SCHE_EXISTS",
						beforeColl.get("NEW_OR_MOD_SCHE_EXISTS"));
				pageCollection.put("NEW_OR_MOD_MAPP_EXISTS",
						beforeColl.get("NEW_OR_MOD_MAPP_EXISTS"));
				pageCollection.put(AppConstants.NO_ONE_CHECKED_MAP,
						noOneCheckedMap);
				componentManager.getComponents("AROBS", txnBean);
				for (int i = 0; i < rmcInPrflSessColl.size(); i++) {

					final RMC_IN_PRFL_Cargo sessionCargo = rmcInPrflSessColl
							.getCargo(i);
					final RMC_IN_PRFL_Cargo pageCollCargo = rmcResponseProfileManager
							.getProfile(rmcInPrflPageColl,
									sessionCargo.getIndv_seq_num());
					if (pageCollCargo == null) {
						sessionCargo.setSpecial_need_resp(FwConstants.NO);
						sessionCargo.setFoster_care_resp(FwConstants.NO);
						sessionCargo.setFormer_foster_resp(FwConstants.NO);
						sessionCargo.setChild_protective_resp(FwConstants.NO);
						sessionCargo.setLiving_prog_resp(FwConstants.NO);
						sessionCargo.setGrand_parent_resp(FwConstants.NO);
						sessionCargo.setDrug_felonies_resp(FwConstants.NO);
						sessionCargo.setSnap_tanf_disc_resp(FwConstants.NO);
						sessionCargo.setTanfDiscResp(FwConstants.NO);
						sessionCargo.setAvoid_prosc_resp(FwConstants.NO);
						sessionCargo.setViolating_parole_resp(FwConstants.NO);
						sessionCargo.setConvic_false_info_resp(FwConstants.NO);
						sessionCargo
						.setVoluntarily_quit_job_resp(FwConstants.NO);
						sessionCargo.setTrading_snap_resp(FwConstants.NO);
						sessionCargo.setBuy_sell_snap_resp(FwConstants.NO);
						sessionCargo.setTrade_snap_gun_resp(FwConstants.NO);
						sessionCargo.setPrev_ssi_resp(FwConstants.NO);
						sessionCargo.setHome_community_resp(FwConstants.NO);
						sessionCargo.setTribal_health_resp(FwConstants.NO);
						sessionCargo.setTribal_eligibility_resp(FwConstants.NO);
						sessionCargo.setDomestic_violence_resp(FwConstants.NO);
						sessionCargo.setTanf_eppic_resp(FwConstants.NO);
						sessionCargo.setEmergency_medical_resp(FwConstants.NO);
						sessionCargo.setAvd_prsctn_fstf(FwConstants.NO);
						sessionCargo.setMed_type_katie_beckett(FwConstants.NO);

					} else {
						sessionCargo.setSpecial_need_resp(pageCollCargo
								.getSpecial_need_resp());
						sessionCargo.setFoster_care_resp(pageCollCargo
								.getFoster_care_resp());
						sessionCargo.setFormer_foster_resp(pageCollCargo
								.getFormer_foster_resp());
						sessionCargo.setChild_protective_resp(pageCollCargo
								.getChild_protective_resp());
						sessionCargo.setLiving_prog_resp(pageCollCargo
								.getLiving_prog_resp());
						sessionCargo.setGrand_parent_resp(pageCollCargo
								.getGrand_parent_resp());
						sessionCargo.setDrug_felonies_resp(pageCollCargo
								.getDrug_felonies_resp());
						sessionCargo.setSnap_tanf_disc_resp(pageCollCargo
								.getSnap_tanf_disc_resp());
						sessionCargo.setTanfDiscResp(pageCollCargo
								.getTanfDiscResp());
						/*
						 * VG SONAR Cleanup - 09/1/2015 Deleted 1 lines
						 * Commented Code in this block
						 */

						sessionCargo.setViolating_parole_resp(pageCollCargo
								.getViolating_parole_resp());
						sessionCargo.setConvic_false_info_resp(pageCollCargo
								.getConvic_false_info_resp());
						sessionCargo.setVoluntarily_quit_job_resp(pageCollCargo
								.getVoluntarily_quit_job_resp());
						sessionCargo.setTrading_snap_resp(pageCollCargo
								.getTrading_snap_resp());
						sessionCargo.setBuy_sell_snap_resp(pageCollCargo
								.getBuy_sell_snap_resp());
						sessionCargo.setTrade_snap_gun_resp(pageCollCargo
								.getTrade_snap_gun_resp());
						sessionCargo.setPrev_ssi_resp(pageCollCargo
								.getPrev_ssi_resp());
						sessionCargo.setHome_community_resp(pageCollCargo
								.getHome_community_resp());
						sessionCargo.setTribal_health_resp(pageCollCargo
								.getTribal_health_resp());
						sessionCargo.setTribal_eligibility_resp(pageCollCargo
								.getTribal_eligibility_resp());
						sessionCargo.setDomestic_violence_resp(pageCollCargo
								.getDomestic_violence_resp());
						sessionCargo.setTanf_eppic_resp(pageCollCargo
								.getTanf_eppic_resp());
						sessionCargo.setEmergency_medical_resp(pageCollCargo
								.getEmergency_medical_resp());
						sessionCargo.setAvd_prsctn_fstf(pageCollCargo
								.getAvd_prsctn_fstf());
						sessionCargo.setMed_type_katie_beckett(pageCollCargo
								.getMed_type_katie_beckett());
					}
				}
				createandLoadAROBSResponseMapsToPageCollection(
						rmcInPrflSessColl, pageCollection, peopleHandler, true,
						driverStatus, true);
				Map newBeforeColl = (Map) session.get(FwConstants.BEFORE_COLLECTION);
				txnBean.setPageCollection((Map) session
					.get(FwConstants.BEFORE_COLLECTION));
				 Map pageCollectionTemp = txnBean.getPageCollection();
				 pageCollectionTemp.put("APP_INDV_ADDI_INFO_Collection", additionalInfoColl);
				 txnBean.setPageCollection(pageCollectionTemp);
				
				return;

			}

			// Set RMC page House Bills Details make required
			// Persistence Logic Starts here
			// Peristence Logic to INDVs
			String[] indivResponseArrayForIndv = null;
			final RMC_IN_PRFL_Collection validationRMCPrflColl = new RMC_IN_PRFL_Collection();
			final Map indivResponseMapForIndv = new HashMap();
			for (int i = 0; i < rmcInPrflSessColl.size(); i++) {
				indivResponseArrayForIndv = new String[25];
				final RMC_IN_PRFL_Cargo sessionCargo = rmcInPrflSessColl
						.getCargo(i);
				final RMC_IN_PRFL_Cargo pageCollCargo = rmcResponseProfileManager
						.getProfile(rmcInPrflPageColl,
								sessionCargo.getIndv_seq_num());
				if (pageCollCargo == null) {
					sessionCargo.setSpecial_need_resp(FwConstants.NO);
					sessionCargo.setFoster_care_resp(FwConstants.NO);
					sessionCargo.setFormer_foster_resp(FwConstants.NO);
					sessionCargo.setChild_protective_resp(FwConstants.NO);
					sessionCargo.setLiving_prog_resp(FwConstants.NO);
					sessionCargo.setGrand_parent_resp(FwConstants.NO);
					sessionCargo.setDrug_felonies_resp(FwConstants.NO);
					sessionCargo.setSnap_tanf_disc_resp(FwConstants.NO);
					sessionCargo.setTanfDiscResp(FwConstants.NO);
					sessionCargo.setAvoid_prosc_resp(FwConstants.NO);
					sessionCargo.setViolating_parole_resp(FwConstants.NO);
					sessionCargo.setConvic_false_info_resp(FwConstants.NO);
					sessionCargo.setVoluntarily_quit_job_resp(FwConstants.NO);
					sessionCargo.setTrading_snap_resp(FwConstants.NO);
					sessionCargo.setBuy_sell_snap_resp(FwConstants.NO);
					sessionCargo.setTrade_snap_gun_resp(FwConstants.NO);
					sessionCargo.setPrev_ssi_resp(FwConstants.NO);
					sessionCargo.setHome_community_resp(FwConstants.NO);
					sessionCargo.setTribal_health_resp(FwConstants.NO);
					sessionCargo.setTribal_eligibility_resp(FwConstants.NO);
					sessionCargo.setDomestic_violence_resp(FwConstants.NO);
					sessionCargo.setTanf_eppic_resp(FwConstants.NO);
					sessionCargo.setEmergency_medical_resp(FwConstants.NO);
					sessionCargo.setAvd_prsctn_fstf(FwConstants.NO);
					sessionCargo.setMed_type_katie_beckett(FwConstants.NO);

				} else {
					sessionCargo.setSpecial_need_resp(pageCollCargo
							.getSpecial_need_resp());
					sessionCargo.setFoster_care_resp(pageCollCargo
							.getFoster_care_resp());
					sessionCargo.setFormer_foster_resp(pageCollCargo
							.getFormer_foster_resp());
					sessionCargo.setChild_protective_resp(pageCollCargo
							.getChild_protective_resp());
					sessionCargo.setLiving_prog_resp(pageCollCargo
							.getLiving_prog_resp());
					sessionCargo.setGrand_parent_resp(pageCollCargo
							.getGrand_parent_resp());
					sessionCargo.setDrug_felonies_resp(pageCollCargo
							.getDrug_felonies_resp());
					sessionCargo.setSnap_tanf_disc_resp(pageCollCargo
							.getSnap_tanf_disc_resp());
					sessionCargo.setTanfDiscResp(pageCollCargo
							.getTanfDiscResp());
					/*
					 * VG SONAR Cleanup - 09/1/2015 Deleted 1 lines Commented
					 * Code in this block
					 */

					sessionCargo.setViolating_parole_resp(pageCollCargo
							.getViolating_parole_resp());
					sessionCargo.setConvic_false_info_resp(pageCollCargo
							.getConvic_false_info_resp());
					sessionCargo.setVoluntarily_quit_job_resp(pageCollCargo
							.getVoluntarily_quit_job_resp());
					sessionCargo.setTrading_snap_resp(pageCollCargo
							.getTrading_snap_resp());
					sessionCargo.setBuy_sell_snap_resp(pageCollCargo
							.getBuy_sell_snap_resp());
					sessionCargo.setTrade_snap_gun_resp(pageCollCargo
							.getTrade_snap_gun_resp());
					sessionCargo.setPrev_ssi_resp(pageCollCargo
							.getPrev_ssi_resp());
					sessionCargo.setHome_community_resp(pageCollCargo
							.getHome_community_resp());
					sessionCargo.setTribal_health_resp(pageCollCargo
							.getTribal_health_resp());
					sessionCargo.setTribal_eligibility_resp(pageCollCargo
							.getTribal_eligibility_resp());
					sessionCargo.setDomestic_violence_resp(pageCollCargo
							.getDomestic_violence_resp());
					sessionCargo.setTanf_eppic_resp(pageCollCargo
							.getTanf_eppic_resp());
					sessionCargo.setEmergency_medical_resp(pageCollCargo
							.getEmergency_medical_resp());
					sessionCargo.setAvoid_prosc_resp(pageCollCargo
							.getAvoid_prosc_resp());
					sessionCargo.setAvd_prsctn_fstf(pageCollCargo
							.getAvd_prsctn_fstf());
					sessionCargo.setMed_type_katie_beckett(pageCollCargo
							.getMed_type_katie_beckett());
				}
				indivResponseArrayForIndv[0] = sessionCargo
						.getSpecial_need_resp();
				indivResponseArrayForIndv[1] = sessionCargo
						.getFoster_care_resp();
				indivResponseArrayForIndv[2] = sessionCargo
						.getFormer_foster_resp();
				indivResponseArrayForIndv[3] = sessionCargo
						.getChild_protective_resp();
				indivResponseArrayForIndv[4] = sessionCargo
						.getLiving_prog_resp();
				indivResponseArrayForIndv[5] = sessionCargo
						.getGrand_parent_resp();
				indivResponseArrayForIndv[6] = sessionCargo
						.getDrug_felonies_resp();
				indivResponseArrayForIndv[7] = sessionCargo
						.getSnap_tanf_disc_resp();
				indivResponseArrayForIndv[8] = sessionCargo.getTanfDiscResp();

				indivResponseArrayForIndv[9] = sessionCargo
						.getAvoid_prosc_resp();
				indivResponseArrayForIndv[10] = sessionCargo
						.getViolating_parole_resp();
				indivResponseArrayForIndv[11] = sessionCargo
						.getConvic_false_info_resp();
				indivResponseArrayForIndv[12] = sessionCargo
						.getVoluntarily_quit_job_resp();
				indivResponseArrayForIndv[13] = sessionCargo
						.getTrading_snap_resp();
				indivResponseArrayForIndv[14] = sessionCargo
						.getBuy_sell_snap_resp();
				indivResponseArrayForIndv[15] = sessionCargo
						.getTrade_snap_gun_resp();
				indivResponseArrayForIndv[16] = sessionCargo.getPrev_ssi_resp();
				indivResponseArrayForIndv[17] = sessionCargo
						.getHome_community_resp();
				indivResponseArrayForIndv[18] = sessionCargo
						.getTribal_health_resp();
				indivResponseArrayForIndv[19] = sessionCargo
						.getTribal_eligibility_resp();
				indivResponseArrayForIndv[20] = sessionCargo
						.getDomestic_violence_resp();
				indivResponseArrayForIndv[21] = sessionCargo
						.getTanf_eppic_resp();
				indivResponseArrayForIndv[22] = sessionCargo
						.getEmergency_medical_resp();
				indivResponseArrayForIndv[23] = sessionCargo
						.getMedicare_chg_ind();
				indivResponseArrayForIndv[24] = sessionCargo
						.getAvd_prsctn_fstf();
				/*indivResponseArrayForIndv[25] = sessionCargo
						.getMed_type_katie_beckett();*/

				indivResponseMapForIndv.put(sessionCargo.getIndv_seq_num(),
						indivResponseArrayForIndv);
				validationRMCPrflColl.addCargo(sessionCargo);
			}
			for (int i = 0; i < rmcInPrflSessColl.size(); i++) {
				final RMC_IN_PRFL_Cargo sessionCargo = rmcInPrflSessColl
						.getCargo(i);
				rmcResponseProfileManager.persist(appNum, sessionCargo
						.getIndv_seq_num(), questionsArrayForIndv,
						(String[]) indivResponseMapForIndv.get(sessionCargo
								.getIndv_seq_num()));
			}


			final short[] questionsIndicators = new short[6];
			questionsIndicators[0] = IRMCResponseProfileManager.MEDICARE_CHG_IND;
			questionsIndicators[1] = IRMCResponseProfileManager.HEALTH_INSURANCE_CHG_IND;
			questionsIndicators[2] = IRMCResponseProfileManager.HOSPITAL_ABD_CHG_IND;
			questionsIndicators[3] = IRMCResponseProfileManager.HOSPICE_CHG_IND;
			questionsIndicators[4] = IRMCResponseProfileManager.LOST_HEALTH_INS_IND;
			questionsIndicators[5] = IRMCResponseProfileManager.NUR_HME_CHG_IND;

			// checking change indicators for medicare part A and B
			final RMB_RQST_Collection sessRqstColl = (RMB_RQST_Collection) session
					.get(AppConstants.RMB_RQST_COLLECTION);
			if (sessRqstColl != null) {
				sessRqstColl.getCargo(0);
			}

			final MedicareBO medicareBO = new MedicareBO();
			final HealthCareCoverageBO healthCvrgBO = new HealthCareCoverageBO();

			final APP_IN_HLTH_INS_BNFTS_Collection modifiedHealthCOverage = healthCvrgBO
					.loadModifiedCollection(appNum);

			final APP_IN_MEDCR_Collection modifiedCollection = medicareBO
					.loadModifiedCollection(appNum);

			final CP_APP_IN_CARE_PROV_Collection modifiedHospitalCollection = healthCvrgBO
					.loadModifiedHospitalCollection(appNum);
			final CP_APP_IN_CARE_PROV_Collection modifiedHospiceCollection = healthCvrgBO
					.loadModifiedHospiceCollection(appNum);
			final CP_APP_IN_CARE_PROV_Collection modifiedNursingHmeCollection = healthCvrgBO
					.loadModifiedNurHmeCollection(appNum);

			final CP_APP_IN_LST_HLTH_INS_Collection modifiedLostHealthInsCollection = healthCvrgBO
					.loadModifiedLostHlthInsCollection(appNum);

			String[] indivResponseIndForIndv = null;
			final Map indivResponseIndIndv = new HashMap();

			for (int j = 0; j < rmcInPrflSessColl.size(); j++) {

				indivResponseIndForIndv = new String[6];
				indivResponseIndForIndv[0] = AppConstants.NO;
				indivResponseIndForIndv[1] = AppConstants.NO;
				indivResponseIndForIndv[2] = AppConstants.NO;
				indivResponseIndForIndv[3] = AppConstants.NO;
				indivResponseIndForIndv[4] = AppConstants.NO;
				indivResponseIndForIndv[5] = AppConstants.NO;

				final RMC_IN_PRFL_Cargo sessionCargo = rmcInPrflSessColl
						.getCargo(j);
				if (modifiedCollection != null && !modifiedCollection.isEmpty()) {
					for (int i = 0; i < modifiedCollection.size(); i++) {
						final APP_IN_MEDCR_Cargo modifiedCargo = (APP_IN_MEDCR_Cargo) modifiedCollection
								.get(i);

						if (sessionCargo.getIndv_seq_num().equals(
								modifiedCargo.getIndv_seq_num())) {
							sessionCargo.setMedicare_chg_ind(AppConstants.YES);
							indivResponseIndForIndv[0] = AppConstants.YES;
						}
						indivResponseIndIndv.put(
								sessionCargo.getIndv_seq_num(),
								indivResponseIndForIndv);
					}

				}

				if (modifiedHealthCOverage != null
						&& !modifiedHealthCOverage.isEmpty()) {
					for (int i = 0; i < modifiedHealthCOverage.size(); i++) {
						final APP_IN_HLTH_INS_BNFTS_Cargo modifiedCargo = (APP_IN_HLTH_INS_BNFTS_Cargo) modifiedHealthCOverage
								.get(i);

						if (sessionCargo.getIndv_seq_num().equals(
								modifiedCargo.getIndv_seq_num())) {
							sessionCargo
							.setHealth_insurance_chg_ind(AppConstants.YES);
							indivResponseIndForIndv[1] = AppConstants.YES;
						}
						indivResponseIndIndv.put(
								sessionCargo.getIndv_seq_num(),
								indivResponseIndForIndv);
					}

				}

				if (modifiedHospitalCollection != null
						&& !modifiedHospitalCollection.isEmpty()) {
					for (int i = 0; i < modifiedHospitalCollection.size(); i++) {
						final CP_APP_IN_CARE_PROV_Cargo modifiedCargo = (CP_APP_IN_CARE_PROV_Cargo) modifiedHospitalCollection
								.get(i);

						if (sessionCargo.getIndv_seq_num().equals(
								modifiedCargo.getIndv_seq_num())) {
							sessionCargo
							.setHospital_abd_chg_ind(AppConstants.YES);
							indivResponseIndForIndv[2] = AppConstants.YES;
						}
						indivResponseIndIndv.put(
								sessionCargo.getIndv_seq_num(),
								indivResponseIndForIndv);
					}

				}

				if (modifiedHospiceCollection != null
						&& !modifiedHospiceCollection.isEmpty()) {
					for (int i = 0; i < modifiedHospiceCollection.size(); i++) {
						final CP_APP_IN_CARE_PROV_Cargo modifiedCargo = (CP_APP_IN_CARE_PROV_Cargo) modifiedHospiceCollection
								.get(i);

						if (sessionCargo.getIndv_seq_num().equals(
								modifiedCargo.getIndv_seq_num())) {
							sessionCargo.setHospice_chg_ind(AppConstants.YES);
							indivResponseIndForIndv[3] = AppConstants.YES;
						}
						indivResponseIndIndv.put(
								sessionCargo.getIndv_seq_num(),
								indivResponseIndForIndv);
					}

				}

				if (modifiedLostHealthInsCollection != null
						&& !modifiedLostHealthInsCollection.isEmpty()) {
					for (int i = 0; i < modifiedLostHealthInsCollection.size(); i++) {
						final CP_APP_IN_LST_HLTH_INS_Cargo modifiedCargo = (CP_APP_IN_LST_HLTH_INS_Cargo) modifiedLostHealthInsCollection
								.get(i);

						if (sessionCargo.getIndv_seq_num().equals(
								modifiedCargo.getIndv_seq_num())) {
							sessionCargo
							.setLost_health_ins_ind(AppConstants.YES);
							indivResponseIndForIndv[4] = AppConstants.YES;
						}
						indivResponseIndIndv.put(
								sessionCargo.getIndv_seq_num(),
								indivResponseIndForIndv);
					}

				}

				indivResponseIndIndv.put(sessionCargo.getIndv_seq_num(),
						indivResponseIndForIndv);

				if (modifiedNursingHmeCollection != null
						&& !modifiedNursingHmeCollection.isEmpty()) {
					for (int i = 0; i < modifiedNursingHmeCollection.size(); i++) {
						final CP_APP_IN_CARE_PROV_Cargo modifiedCargo = modifiedNursingHmeCollection
								.getCargo(i);
						if (sessionCargo.getIndv_seq_num().equals(
								modifiedCargo.getIndv_seq_num())) {
							sessionCargo.setNur_hme_chg_ind(AppConstants.YES);
							indivResponseIndForIndv[5] = AppConstants.YES;
						}

						indivResponseIndIndv.put(
								sessionCargo.getIndv_seq_num(),
								indivResponseIndForIndv);
					}
				}
			}
			
			//Migrant farm worker persistence logic
			if ((additionalInfoColl != null) && (!additionalInfoColl.isEmpty())) {
				addiInfoCargo = (APP_INDV_ADDI_INFO_Cargo) additionalInfoColl
						.get(0);
				addiInfoCargo.setApp_num(appNum);
				addiInfoCargo.setIndv_seq_num(FwConstants.ONE);
				final APP_INDV_ADDI_INFO_Collection coll = (APP_INDV_ADDI_INFO_Collection) beforeColl
						.get("APP_INDV_ADDI_INFO_Collection");
				// data already exist
				if ((coll != null) && (!coll.isEmpty())) {
					addiInfoCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
				}/* else {
					addiInfoCargo.setRowAction(FwConstants.ROWACTION_INSERT);
				}*/
				APP_INDV_ADDI_INFO_Collection storecollAddIfo = new APP_INDV_ADDI_INFO_Collection();
				storecollAddIfo.addCargo(addiInfoCargo);
				storecollAddIfo.persist(FwConstants.DAO);
			}

			pageCollection.put("APP_INDV_ADDI_INFO_Collection",
					additionalInfoColl);

			final ChangingValidation cv = new ChangingValidation();
			cv.setOutStateBnftInd(txnBean);
			cv.setSchoolEnrChgInd(txnBean);
			cv.setThrdPrtyChgInd(txnBean);
			cv.setConvicFelnChangeInd(txnBean);
			//persist all indicators

			for (int i = 0; i < rmcInPrflSessColl.size(); i++) {
				final RMC_IN_PRFL_Cargo sessionCargo = rmcInPrflSessColl
						.getCargo(i);
				rmcResponseProfileManager.persist(appNum, sessionCargo
						.getIndv_seq_num(), questionsIndicators,
						(String[]) indivResponseIndIndv.get(sessionCargo
								.getIndv_seq_num()));
			}

			driverManager.makeComplete(FwConstants.RMC_DRIVER, currentPageID,
					driverArray, appNum);
			session.put(FwConstants.RMC_DRIVER, driverArray);

			final short[] programKey = (short[]) session
					.get(FwConstants.RMC_PROGRAM_KEY);
			if (session.get(FwConstants.ACCESS_APPLICATION_TYPE).equals(
					String.valueOf(FwConstants.RMB_APP_TYPE))
					&& programKey[7] == 1) {
				driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARPER",
						driverArray, appNum);
			}
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::storeOtherBenefitsSummary:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("storeOtherBenefitsSummary");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"storeOtherBenefitsSummary", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.storeOtherBenefitsSummary() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Adds the health insurance details.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void addHealthInsuranceDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.addHealthInsuranceDetails() - START");

		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			request.get(FwConstants.CURRENT_PAGE_ID);
			request.put("firstName_MAPP", null);
			// short array for appProfile (someone outside the home)
			final short[] appPrflArray = new short[1];
			appPrflArray[0] = IAppProfileManager.POLICY_HOLDER_OTHER_RESP;
			final String[] appPrflResponseArray = new String[1];
			appPrflResponseArray[0] = "R";

			// Initialize ValidationBO
			final HealthCareCoverageBO hlthCareBO = new HealthCareCoverageBO();

			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);

			// Get appNumber from the session
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);

			// Get the session AIP Collection
			final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			// Cargo

			final int rmcPrflCollSize = rmcInPrflColl != null ? rmcInPrflColl
					.size() : 0;

			// Get the firstName
			final String indvSeqNum = (String) request.get("firstName_medIns");

			final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
			indivSeqBean.setIndivSeqNum(indvSeqNum);
			indivSeqBean.setSeqNum(FwConstants.ZERO);
			indivSeqBean.setType(AppConstants.ADD_HEALTHNIS);
			indivSeqBean.setUserEndInd(FwConstants.ZERO);
			pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

					// Run Validation
					hlthCareBO.validateHinsurAdd(indvSeqNum);
					if (hlthCareBO.hasMessages()) {
						request.put(FwConstants.MESSAGE_LIST,
								hlthCareBO.getMessageList());
						txnBean.setPageCollection((Map) session
								.get(FwConstants.BEFORE_COLLECTION));
						return;
					}

			if (FwConstants.ZERO.equals(indvSeqNum)) {
				// reason to put in session : to handle out side home person: if
				// user moves to add new individual from Health Care Details
				// page and comes back.
				session.put("Out_Side_Home_Add_New", FwConstants.YES);
				// PCR# 35538 - updated PLCY_HOLD_OTHR_RES to "R" in APP_PRFL
				// while adding Policy For Out Side Home
				APP_PRFL_Cargo cargo = new APP_PRFL_Cargo();
				cargo.setApp_num(appNum);
				cargo.setPay_rmr_brd_resp(FwConstants.NO);
				cargo.setPlcy_hold_oth_resp(FwConstants.NO);
				cargo.setSbsid_hse_resp(FwConstants.NO);
				cargo.setSu_asst_lieap_resp(FwConstants.NO);
				cargo.setUser(FwConstants.ONE);
				APP_PRFL_Collection prflColl = new APP_PRFL_Collection();
				prflColl = appProfileManager.loadProfile(appNum);
				if (prflColl.isEmpty()) {
					cargo = appProfileManager.createAppProfile(cargo);
				}
				appProfileManager.persist(appNum, FwConstants.EMPTY_STRING, appPrflArray, appPrflResponseArray);

			} else {
				if (rmcPrflCollSize > 0) {
					RMC_IN_PRFL_Cargo rmcInPrflCargo = rmcResponseProfileManager.getProfile(rmcInPrflColl, indvSeqNum);
					if (rmcInPrflCargo == null) {
						rmcInPrflCargo = new RMC_IN_PRFL_Cargo();
						rmcInPrflCargo.setApp_num(appNum);
						rmcInPrflCargo.setIndv_seq_num(indvSeqNum);
						rmcInPrflCargo.setUpdt_dt(fwDate.getToday());
						rmcInPrflCargo.setUser(FwConstants.ONE);
						rmcInPrflCargo = rmcResponseProfileManager.createRMCIndividualProfile(rmcInPrflCargo);
						rmcInPrflCargo.setHc_cvrg_resp("R");
						rmcInPrflColl.addCargo(rmcInPrflCargo);
						session.put(AppConstants.RMC_IN_PRFL_MASTER, rmcInPrflColl);
					}
					rmcInPrflCargo.setHc_cvrg_resp("R");
				} else {
					RMC_IN_PRFL_Cargo rmcInPrflCargo = new RMC_IN_PRFL_Cargo();
					rmcInPrflCargo.setIndv_seq_num(indvSeqNum);
					rmcInPrflCargo.setUpdt_dt(fwDate.getToday());
					rmcInPrflCargo.setUser(FwConstants.ONE);
					rmcInPrflCargo = rmcResponseProfileManager.createRMCIndividualProfile(rmcInPrflCargo);
					rmcInPrflCargo.setHc_cvrg_resp("R");
					rmcInPrflColl.addCargo(rmcInPrflCargo);
					session.put(AppConstants.RMC_IN_PRFL_MASTER, rmcInPrflColl);
				}

					}

					final String appType = (String) session
							.get(FwConstants.ACCESS_APPLICATION_TYPE);

					if (appType.equalsIgnoreCase(String
							.valueOf(FwConstants.RMB_APP_TYPE))) {
						final RMB_RQST_Collection rmbColl = (RMB_RQST_Collection) session
								.get(AppConstants.RMB_RQST_COLLECTION);
						
						if(rmbColl != null && !rmbColl.isEmpty()) {
							// Get RMB_RQST_Cargo for appNum
							final RMB_RQST_Cargo rmbRqstCargo = rmbColl.getCargo(0);
							if (rmbRqstCargo.getMed_cvrg_stat_ind() != null
									&& !FwConstants.YES.equals(rmbRqstCargo
											.getMed_cvrg_stat_ind())) {
								rmbRqstCargo.setMed_cvrg_stat_ind(FwConstants.YES);
								rmbRqstCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
								rmbColl.addCargo(rmbRqstCargo);
								rmbColl.persist(FwConstants.DAO);
							}
							// add to session
							session.put(AppConstants.RMB_RQST_COLLECTION, rmbColl);
						}

						
					}
					driverManager.makeAddNew(FwConstants.RMC_DRIVER, "ARHIN",
							driverArray, appNum);
					driverManager.makeAddNew(FwConstants.RMC_DRIVER, "AROHI",
							driverArray, appNum);

					// make summary page as required
					driverManager.makeRequired(FwConstants.RMC_DRIVER,
							(String) request.get(FwConstants.CURRENT_PAGE_ID),
							driverArray, appNum);
					// end
					log(ILog.INFO,
							"RMCOtherBenefitsEJBBean::addHealthInsuranceDetails:End");

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("addHealthInsuranceDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"addHealthInsuranceDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.addHealthInsuranceDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Adds the mapp details.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void addMappDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.addMappDetails() - START");

		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			// get cargo determining user selection
			request.put("firstName_medIns", null);
			final String mappSeq = request.get("firstName_MAPP") != null ? (String) request
					.get("firstName_MAPP") : FwConstants.EMPTY_STRING;

					final ARMAPValidator validator = new ARMAPValidator();// Write the
					// validator
					// validate selections

					if (mappSeq == null
							|| AppConstants.SELECT_DEFAULT_OPTION.equals(mappSeq)) {
						validator.validateAdd();
						// add validation message and return
						request.put(FwConstants.MESSAGE_LIST,
								validator.getMessageList());
						txnBean.setPageCollection((Map) session
								.get(FwConstants.BEFORE_COLLECTION));
						return;
					}
					final String appNum = (String) session.get(AppConstants.APP_NUMBER);
					final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
					indivSeqBean.setIndivSeqNum(mappSeq);
					indivSeqBean.setSeqNum(FwConstants.ZERO);
					indivSeqBean.setType(AppConstants.REQUEST_MAPP);
					indivSeqBean.setUserEndInd(FwConstants.ZERO);
					pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

					final RMB_RQST_Collection rmbColl = (RMB_RQST_Collection) session
							.get(AppConstants.RMB_RQST_COLLECTION);

					// Get RMB_RQST_Cargo for appNum
					final RMB_RQST_Cargo rmbRqstCargo = rmbColl.getCargo(0);
					if (rmbRqstCargo.getMapp_stat_ind() != null
							&& !FwConstants.YES.equals(rmbRqstCargo.getMapp_stat_ind())) {
						rmbRqstCargo.setMapp_stat_ind(FwConstants.YES);
						rmbRqstCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
						rmbColl.addCargo(rmbRqstCargo);
						rmbColl.persist(FwConstants.DAO);
					}
					// add to session
					session.put(AppConstants.RMB_RQST_COLLECTION, rmbColl);

					// set driver status
					final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARMAP", driver,
							appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driver,
							appNum);
					session.put(FwConstants.RMC_DRIVER, driver);

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("addMappDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"addMappDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.addMappDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Edits the mapp details.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void editMappDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.editMappDetails() - START");

		try {
			log(ILog.INFO, "RMCHousingExpenseEJBBean::editMappDetails:Start");
			final Map session = txnBean.getSession();
			final Map pageCollection = txnBean.getPageCollection();

			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			// Get the APP_IN_EMPL_Collection from pageCollection.
			final APP_IN_MAPP_Collection mappColl = (APP_IN_MAPP_Collection) pageCollection
					.get("APP_IN_MAPP_Collection");
			final APP_IN_MAPP_Cargo mappCargo = mappColl.getCargo(0);

			final IndivTypeSeqBean seqBean = new IndivTypeSeqBean();
			seqBean.setIndivSeqNum(mappCargo.getIndv_seq_num());
			seqBean.setSeqNum(FwConstants.ZERO);
			seqBean.setType(mappCargo.getSrc_app_ind());
			// seqBean.set
			// setting user end indicator

			pageCollection.put(FwConstants.DETAIL_KEY_BEAN, seqBean);
			final RMB_RQST_Collection rmbColl = (RMB_RQST_Collection) session
					.get(AppConstants.RMB_RQST_COLLECTION);

			// Get RMB_RQST_Cargo for appNum
			final RMB_RQST_Cargo rmbRqstCargo = rmbColl.getCargo(0);
			if (rmbRqstCargo.getMapp_stat_ind() != null
					&& !FwConstants.YES.equals(rmbRqstCargo.getMapp_stat_ind())) {
				rmbRqstCargo.setMapp_stat_ind(FwConstants.YES);
				rmbRqstCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
				rmbColl.addCargo(rmbRqstCargo);
				rmbColl.persist(FwConstants.DAO);
			}
			// add to session
			session.put(AppConstants.RMB_RQST_COLLECTION, rmbColl);
			// Get App Number
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			// Set RMC page Job Income Details make required
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARMAP",
					driverArray, appNum);
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
					driverArray, appNum);
			// End
			log(ILog.INFO, "RMCHousingExpenseEJBBean::editMappDetails:End");

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("editMappDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"editMappDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.editMappDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Comment here.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void eraseMappDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.eraseMappDetails() - START");

		try {
			log(ILog.INFO, "RMCHousingExpenseEJBBean::eraseMappDetails:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);

			// Get RMCSessionBean from the session

			// Define IndvSeqNum and the SeqNum and Type and RowNum
			String indvSeqNum = null;
			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);

			// Get the APP_IN_SHLTC_Collection from pageCollection.
			final APP_IN_MAPP_Collection mappColl = (APP_IN_MAPP_Collection) pageCollection
					.get("APP_IN_MAPP_Collection");
			final APP_IN_MAPP_Cargo mappCargo = mappColl.getCargo(0);

			// Get the results from the APP_IN_EMPL_Collection
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);

			// delete record from rmc selection profile
			final SortedSet rmcSelPrfl = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);

			indvSeqNum = mappCargo.getIndv_seq_num();
			APP_IN_MAPP_Cargo beforeMappCargo = (APP_IN_MAPP_Cargo) beforeColl
					.get("APP_IN_MAPP_Cargo");
			final MappDetailsBO mappBO = new MappDetailsBO();

			if (beforeMappCargo == null
					|| mappBO.isDifferentMAPP(mappCargo, beforeMappCargo)) {

				mappBO.validateErase();
				request.put(FwConstants.MESSAGE_LIST, mappBO.getMessageList());
				beforeMappCargo = new APP_IN_MAPP_Cargo();
				beforeMappCargo.setIndv_seq_num(indvSeqNum);
				/*
				 * VG SONAR Cleanup - 09/1/2015 Deleted 1,1 lines Commented Code
				 * in this block
				 */

				beforeColl.put("APP_IN_MAPP_Cargo", beforeMappCargo);
				txnBean.setPageCollection(beforeColl);
				return;

			}

			mappBO.deleteMappRecords(indvSeqNum, appNum);
			final short[] responseArray = new short[] { IRMCResponseProfileManager.MAPP_BENEFITS_RESP };

			if (beforeColl != null) {
				int count = 0;
				APP_IN_MAPP_Collection rb1Coll = null;
				APP_IN_MAPP_Cargo rb1Cargo = null;
				rb1Coll = (APP_IN_MAPP_Collection) beforeColl
						.get("APP_IN_MAPP_Collection");

				if (rb1Coll != null && !rb1Coll.isEmpty()) {
					final int rbCollSize = rb1Coll.size();
					for (int i = 0; i < rbCollSize; i++) {
						rb1Cargo = rb1Coll.getCargo(i);
						if (rb1Cargo.getIndv_seq_num().equals(indvSeqNum)
								&& AppConstants.RMC_NEW_RECORD_IND
								.equals(rb1Cargo.getSrc_app_ind())) {
							count++;
						}
					}
				}
				if (count == 1) {
					// now we need to make that profile requirred
					final RMC_IN_PRFL_Cargo rmcResCargo = rmcResponseProfileManager
							.getProfile(rmcInPrflColl, indvSeqNum);
					rmcResponseProfileManager.makeAbsoluteNotRequired(
							responseArray, rmcResCargo, true);

				}
			}

			boolean rmcPrflMappNotRequired = false;

			// here we need to check we have no entrys in rmcPrfl for the job
			// income detail
			// as well as we need to check
			if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {

				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl,
						IRMCResponseProfileManager.MAPP_BENEFITS_RESP)) {
					rmcPrflMappNotRequired = true;
				}

			} else {

				rmcPrflMappNotRequired = true;

			}

			if (!checkBenefitDetailPageRequired(rmcSelPrfl, getMAPPTypes())
					&& rmcPrflMappNotRequired) {
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"ARMAP", driverArray, appNum);
			}

			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
					driverArray, appNum);
			log(ILog.INFO, "RMCHousingExpenseEJBBean::eraseMappDetails:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("eraseMappDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"eraseMappDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.eraseMappDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Erase mapp changes.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void eraseMappChanges(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.eraseMappChanges() - START");

		try {
			log(ILog.INFO, "RMCHousingExpenseEJBBean::eraseMappChanges:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);

			// Get RMCSessionBean from the session
			// Define IndvSeqNum and the SeqNum and Type and RowNum
			String indvSeqNum = null;
			String seqNum = null;
			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);

			// Get the APP_IN_SHLTC_Collection from pageCollection.
			final APP_IN_MAPP_Collection mappColl = (APP_IN_MAPP_Collection) pageCollection
					.get("APP_IN_MAPP_Collection");
			final APP_IN_MAPP_Cargo mappCargo = mappColl.getCargo(0);

			// Get the results from the APP_IN_EMPL_Collection
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			indvSeqNum = mappCargo.getIndv_seq_num();
			seqNum = FwConstants.ZERO;

			APP_IN_MAPP_Cargo beforeMappCargo = (APP_IN_MAPP_Cargo) beforeColl
					.get("APP_IN_MAPP_Cargo");

			final MappDetailsBO mappBO = new MappDetailsBO();
			if (beforeMappCargo == null
					|| mappBO.isDifferentMAPP(mappCargo, beforeMappCargo)) {
				mappBO.validateEraseChanges();
				request.put(FwConstants.MESSAGE_LIST, mappBO.getMessageList());
				beforeMappCargo = new APP_IN_MAPP_Cargo();
				beforeMappCargo.setIndv_seq_num(indvSeqNum);
				beforeColl.put("APP_IN_MAPP_Cargo", beforeMappCargo);
				txnBean.setPageCollection(beforeColl);
				return;
			}

			// delete record from database
			mappBO.deleteMappRecords(indvSeqNum, appNum);

			final String catUtilType = AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL;

			// delete record from rmc selection profile
			final SortedSet rmcSelPrfl = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			categorySelectionProfileManager.removeSequenceDetail(rmcSelPrfl,
					appNum, Short.parseShort(indvSeqNum),
					Short.parseShort(seqNum), catUtilType,
					AppConstants.MAPP_CHANGE);
			categorySelectionProfileManager.insertSequenceDetail(rmcSelPrfl,
					appNum, catUtilType, Short.parseShort(indvSeqNum),
					Short.parseShort(seqNum), AppConstants.MAPP_CHANGE,
					(short) 2, 'N');
			final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			boolean rmcPrflNotRequeired = false;
			// here we need to check we have no entrys in rmcPrfl for the other
			// income detail
			// as well as we need to check
			if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl,
						IRMCResponseProfileManager.MAPP_BENEFITS_RESP)) {
					rmcPrflNotRequeired = true;
				}
			} else {
				rmcPrflNotRequeired = true;
			}

			if (!checkBenefitDetailPageRequired(rmcSelPrfl, getMAPPTypes())
					&& rmcPrflNotRequeired) {
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"ARMAP", driverArray, appNum);
			}

			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
					driverArray, appNum);
			// End
			log(ILog.INFO, "RMCHousingExpenseEJBBean::eraseMappChanges:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("eraseMappChanges");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"eraseMappChanges", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.eraseMappChanges() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Erase se details.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void eraseSEDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.eraseSEDetails() - START");

		try {
			log(ILog.INFO, "RMCHousingExpenseEJBBean::eraseMappDetails:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);

			// Get RMCSessionBean from the session

			// Define IndvSeqNum and the SeqNum and Type and RowNum
			String indvSeqNum = null;
			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);

			// Get the APP_IN_SHLTC_Collection from pageCollection.
			final APP_IN_SCHLE_Collection schColl = (APP_IN_SCHLE_Collection) pageCollection
					.get("APP_IN_SCHLE_Collection");
			final APP_IN_SCHLE_Cargo schCargo = schColl.getResult(0);

			// Get the results from the APP_IN_EMPL_Collection
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);

			// delete record from rmc selection profile
			final SortedSet rmcSelPrfl = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);

			indvSeqNum = schCargo.getIndv_seq_num();
			APP_IN_SCHLE_Cargo beforeschCargo = (APP_IN_SCHLE_Cargo) beforeColl
					.get("APP_IN_SCHLE_Cargo");
			final SchoolEnrollmentBO schBO = new SchoolEnrollmentBO();

			if (beforeschCargo == null
					|| schBO.isDifferentSE(schCargo, beforeschCargo)) {

				schBO.validateErase();
				request.put(FwConstants.MESSAGE_LIST, schBO.getMessageList());
				beforeschCargo = new APP_IN_SCHLE_Cargo();
				beforeschCargo.setIndv_seq_num(indvSeqNum);
				/*
				 * VG SONAR Cleanup - 09/1/2015 Deleted 1,1 lines Commented Code
				 * in this block
				 */

				beforeColl.put("APP_IN_SCHLE_Cargo", beforeschCargo);
				txnBean.setPageCollection(beforeColl);
				return;

			}

			schBO.deleteSERecords(indvSeqNum, appNum);
			final short[] responseArray = new short[] { IRMCResponseProfileManager.SCHL_ENRL_RESP };

			if (beforeColl != null) {
				int count = 0;
				APP_IN_SCHLE_Collection rb1Coll = null;
				APP_IN_SCHLE_Cargo rb1Cargo = null;
				rb1Coll = (APP_IN_SCHLE_Collection) beforeColl
						.get("APP_IN_SCHLE_Collection");

				if (rb1Coll != null && !rb1Coll.isEmpty()) {
					final int rbCollSize = rb1Coll.size();
					for (int i = 0; i < rbCollSize; i++) {
						rb1Cargo = rb1Coll.getResult(i);
						if (rb1Cargo.getIndv_seq_num().equals(indvSeqNum)
								&& AppConstants.RMC_NEW_RECORD_IND
								.equals(rb1Cargo.getSrc_app_ind())) {
							count++;
						}
					}
				}
				if (count == 1) {
					// now we need to make that profile requirred
					final RMC_IN_PRFL_Cargo rmcResCargo = rmcResponseProfileManager
							.getProfile(rmcInPrflColl, indvSeqNum);
					rmcResponseProfileManager.makeAbsoluteNotRequired(
							responseArray, rmcResCargo, true);

				}
			}

			boolean rmcPrflSchEnrlNotRequired = false;
			// here we need to check we have no entrys in rmcPrfl for the job
			// income detail
			// as well as we need to check
			if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl,
						IRMCResponseProfileManager.SCHL_ENRL_RESP)) {
					rmcPrflSchEnrlNotRequired = true;
				}

			} else {
				rmcPrflSchEnrlNotRequired = true;

			}
			final Map schEnrl = new HashMap();
			schEnrl.put("SC", "SC");
			if (!checkBenefitDetailPageRequired(rmcSelPrfl, schEnrl)
					&& rmcPrflSchEnrlNotRequired) {
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"ARHSE", driverArray, appNum);
			}

			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
					driverArray, appNum);
			log(ILog.INFO, "RMCHousingExpenseEJBBean::eraseSEDetails:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("eraseSEDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"eraseSEDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.eraseSEDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Erase se changes.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void eraseSEChanges(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.eraseSEChanges() - START");

		try {
			log(ILog.INFO, "RMCHousingExpenseEJBBean::eraseSEChanges:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);

			// Get RMCSessionBean from the session
			// Define IndvSeqNum and the SeqNum and Type and RowNum
			String indvSeqNum = null;
			String seqNum = null;
			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);

			// Get the APP_IN_SHLTC_Collection from pageCollection.
			final APP_IN_SCHLE_Collection schColl = (APP_IN_SCHLE_Collection) pageCollection
					.get("APP_IN_SCHLE_Collection");
			final APP_IN_SCHLE_Cargo schCargo = schColl.getResult(0);

			// Get the results from the APP_IN_EMPL_Collection
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			indvSeqNum = schCargo.getIndv_seq_num();
			seqNum = FwConstants.ZERO;

			APP_IN_SCHLE_Cargo beforeSchCargo = (APP_IN_SCHLE_Cargo) beforeColl
					.get("APP_IN_SCHLE_Cargo");

			final SchoolEnrollmentBO schBO = new SchoolEnrollmentBO();
			if (beforeSchCargo == null
					|| schBO.isDifferentSE(schCargo, beforeSchCargo)) {
				schBO.validateEraseChanges();
				request.put(FwConstants.MESSAGE_LIST, schBO.getMessageList());
				beforeSchCargo = new APP_IN_SCHLE_Cargo();
				beforeSchCargo.setIndv_seq_num(indvSeqNum);
				beforeColl.put("APP_IN_SCHLE_Cargo", beforeSchCargo);
				txnBean.setPageCollection(beforeColl);
				return;
			}

			// delete record from database
			schBO.deleteSERecords(indvSeqNum, appNum);

			final String catUtilType = AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL;

			// delete record from rmc selection profile
			final SortedSet rmcSelPrfl = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			categorySelectionProfileManager.removeSequenceDetail(rmcSelPrfl,
					appNum, Short.parseShort(indvSeqNum),
					Short.parseShort(seqNum), catUtilType,
					AppConstants.SCHOOL_ENROLLEMENT_CHANGE);
			categorySelectionProfileManager.insertSequenceDetail(rmcSelPrfl,
					appNum, catUtilType, Short.parseShort(indvSeqNum),
					Short.parseShort(seqNum),
					AppConstants.SCHOOL_ENROLLEMENT_CHANGE, (short) 2, 'N');
			final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			boolean rmcPrflNotRequeired = false;
			// here we need to check we have no entrys in rmcPrfl for the other
			// income detail
			// as well as we need to check
			if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl,
						IRMCResponseProfileManager.SCHL_ENRL_RESP)) {
					rmcPrflNotRequeired = true;
				}
			} else {
				rmcPrflNotRequeired = true;
			}
			final Map schEnrl = new HashMap();
			schEnrl.put("SC", "SC");
			if (!checkBenefitDetailPageRequired(rmcSelPrfl, schEnrl)
					&& rmcPrflNotRequeired) {
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"ARHSE", driverArray, appNum);
			}

			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
					driverArray, appNum);
			// End
			log(ILog.INFO, "RMCHousingExpenseEJBBean::eraseSEChanges:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("eraseSEChanges");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"eraseSEChanges", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.eraseSEChanges() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Edits the med ins details.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void editMedInsDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.editMedInsDetails() - START");

		try {
			log(ILog.INFO, "RMCHousingExpenseEJBBean::editMedInsDetails:Start");
			final Map session = txnBean.getSession();
			final Map pageCollection = txnBean.getPageCollection();

			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			// Get the APP_IN_EMPL_Collection from pageCollection.
			final APP_MED_INS_Collection medInsColl = (APP_MED_INS_Collection) pageCollection
					.get("APP_MED_INS_Collection");
			final APP_MED_INS_Cargo medInsCargo = medInsColl.getCargo(0);

			final IndivTypeSeqBean seqBean = new IndivTypeSeqBean();
			seqBean.setIndivSeqNum(medInsCargo.getIndv_seq_num());
			seqBean.setSeqNum(medInsCargo.getPlcy_seq_num());
			seqBean.setType(AppConstants.HEALTHINS_INFORMATION);
            seqBean.setUserEndInd(FwConstants.ZERO);

			// setting user end indicator

			pageCollection.put(FwConstants.DETAIL_KEY_BEAN, seqBean);
			final String appType = (String) session
					.get(FwConstants.ACCESS_APPLICATION_TYPE);
			if (appType.equalsIgnoreCase(String
					.valueOf(FwConstants.RMB_APP_TYPE))) {
				final RMB_RQST_Collection rmbColl = (RMB_RQST_Collection) session
						.get(AppConstants.RMB_RQST_COLLECTION);

				// Get RMB_RQST_Cargo for appNum
				if (rmbColl != null && !rmbColl.isEmpty()) {
				final RMB_RQST_Cargo rmbRqstCargo = rmbColl.getCargo(0);
				if (rmbRqstCargo.getMed_cvrg_stat_ind() != null
						&& !FwConstants.YES.equals(rmbRqstCargo
								.getMed_cvrg_stat_ind())) {
					rmbRqstCargo.setMed_cvrg_stat_ind(FwConstants.YES);
					rmbRqstCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
					rmbColl.addCargo(rmbRqstCargo);
					rmbColl.persist(FwConstants.DAO);
				}
				// add to session
				session.put(AppConstants.RMB_RQST_COLLECTION, rmbColl);
				}
			}
			// Get App Number
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			// Set RMC page Job Income Details make required
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARHIN",
					driverArray, appNum);
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROHI",
					driverArray, appNum);
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
					driverArray, appNum);
			// End
			log(ILog.INFO, "RMCHousingExpenseEJBBean::editMedInsDetails:End");

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("editMedInsDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"editMedInsDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.editMedInsDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Comment here.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void eraseMedInsDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.eraseMedInsDetails() - START");

		try {
			log(ILog.INFO,
					"BenefitsEJBBean::eraseHealthCareCoverageDetails:Start");

			// get variables from session and page collection
			final Map session = txnBean.getSession();
			final Map pageCollection = txnBean.getPageCollection();
			final Map request = txnBean.getRequest();
			request.get(FwConstants.CURRENT_PAGE_ID);

			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);


			// Get appNumber from the session
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);

			// Get beforeMap
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);


			beforeColl.get("APP_MED_INS_Collection");

			// Define IndvSeqNum and the SeqNum and Type and RowNum
			String indvSeqNum = null, seqNum = null;
			final String type = null;

			// Get the pageCollection APP_IN_MEDCR_Collection
			final APP_MED_INS_Collection insurColl = (APP_MED_INS_Collection) pageCollection
					.get("APP_MED_INS_Collection");

			beforeColl.get("APP_IN_MED_INS_Collection");

			// Get the results from medcrColl
			seqNum = insurColl.getCargo(0).getPlcy_seq_num();
			indvSeqNum = insurColl.getCargo(0).getIndv_seq_num();

			// Setting IndivSeqTypeBean
			final IndivTypeSeqBean indivTypeSeqBean = new IndivTypeSeqBean();
			indivTypeSeqBean.setIndivSeqNum(indvSeqNum);
			indivTypeSeqBean.setSeqNum(seqNum);
			indivTypeSeqBean.setType(type);
			// This code is added to display persons name for the erase message
			// in th summary page
			final PeopleHandler peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);
//			if (FwConstants.ZERO.equals(indvSeqNum)) {
//				final APP_MED_INS_Collection medBeforeColl = (APP_MED_INS_Collection) beforeColl
//						.get("APP_MED_INS_Collection");
//				getOutSideHomeName(medBeforeColl, indvSeqNum, seqNum);
//			} else {
//				peopleHandler.getFirstName(indvSeqNum);
//			}
			APP_MED_INS_Cargo beforeHlthCargo = (APP_MED_INS_Cargo) beforeColl
					.get("APP_MED_INS_Cargo");
			final APP_MED_INS_Cargo hlthCargo = insurColl.getCargo(0);
			final HealthCareCoverageBO hlthBO = new HealthCareCoverageBO();

			if (beforeHlthCargo == null
					|| hlthBO.isDifferentMedIns(hlthCargo, beforeHlthCargo)) {

				hlthBO.validateErase();
				request.put(FwConstants.MESSAGE_LIST, hlthBO.getMessageList());
				beforeHlthCargo = new APP_MED_INS_Cargo();
				beforeHlthCargo.setIndv_seq_num(indvSeqNum);
				beforeHlthCargo.setPlcy_seq_num(seqNum);
				beforeColl.put("APP_MED_INS_Cargo", beforeHlthCargo);
				txnBean.setPageCollection(beforeColl);
				return;

			}

			hlthBO.deleteMedInsBRecords(indvSeqNum, seqNum, appNum);

			/*
			 * VG SONAR Cleanup - 09/1/2015 Changed Commented code block to
			 * javadoc
			 */
			/**
			 * // PCR 44966 (43100) TO delete the individual who is covered by
			 * the // above deleted person
			 *
			 * /* int insurCollPastSize = 0; insurCollPastSize =
			 * medInsColl.size(); APP_IN_MED_INS_Collection deletePinsurColl =
			 * new APP_IN_MED_INS_Collection(); APP_IN_MED_INS_Cargo
			 * deletePinsurCargo = new APP_IN_MED_INS_Cargo(); for(int i=0;i <
			 * insurCollPastSize; i++) { deletePinsurCargo =
			 * (APP_IN_MED_INS_Cargo)medInsColl.getCargo(i);
			 * if(deletePinsurCargo.getPlcy_seq_num().equals(seqNum)) {
			 * deletePinsurCargo.setRowAction(FwConstants.ROWACTION_DELETE);
			 * deletePinsurColl.addCargo(deletePinsurCargo); } }
			 * hlthBO.deletePinsurRecord(deletePinsurColl);
			 */

			// End of Delete
			/*
			 * VG SONAR Cleanup - 09/1/2015 Changed Commented code block to
			 * javadoc
			 */
			/**
			 * int insurBeforeSize = 0; insurBeforeSize =
			 * insurBeforeColl.size(); String Current_Health =FwConstants.SPACE;
			 * insurBeforeColl =
			 * hlthBO.getHealthInsrDetailsFilterByHealthStatus(
			 * insurBeforeColl,Current_Health);
			 *
			 *
			 * String indvSeqNumSession = null; for(int i=0;i <
			 * appInPrflColl.size();i++) { appInPrflCargo =
			 * appInPrflColl.getCargo(i); indvSeqNumSession =
			 * appInPrflCargo.getIndv_seq_num();
			 * if(indvSeqNumSession.equals(indvSeqNum)) { //Get the responseId
			 * responseId = IRMCResponseProfileManager.HEALTHCARE_COVERAGE; //If
			 * count is one if(insurBeforeColl.size()==1) { //Make
			 * AbsoluteNotRequired on Medicare Insurance
			 * rmcResponseProfileManager
			 * .makeAbsoluteNotRequired(responseId,appInPrflCargo,true);
			 *
			 * //call absoluteNotRequired on ABHCD String[] pageIds = {"ARHCD"};
			 * driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
			 * pageIds, driverArray, appNum); }else{ //Make AbsoluteNotRequired
			 * on Medical Insurance
			 * rmcResponseProfileManager.makeAbsoluteNotRequired
			 * (responseId,appInPrflCargo,true); }
			 *
			 * } }
			 *
			 * //if outside home person if(indvSeqNum.equals(FwConstants.ZERO)){
			 *
			 * APP_PRFL_Collection appPrflColl =
			 * appProfileManager.loadProfile(appNum);
			 *
			 * boolean isOutSideHomePlcy = false; int countOutSideHome = 0;
			 * for(int i=0; i<insurBeforeColl.size();i++){ APP_MED_INS_Cargo
			 * medInsCargo = insurBeforeColl.getCargo(i);
			 * if(medInsCargo.getPlcy_hold_seq_num().equals(FwConstants.ZERO)){
			 * countOutSideHome = countOutSideHome + 1; } } //if this is the
			 * last policy for outside home than we have enable checkbox in
			 * question page if(appPrflColl != null && !appPrflColl.isEmpty() &&
			 * countOutSideHome == 1){
			 * appProfileManager.makeAbsoluteNotRequired(
			 * IAppProfileManager.POLICY_HOLDER_OTHER_RESP,
			 * appPrflColl.getCargo(0), true ); } if(insurBeforeColl.size()==1)
			 * { String[] pageIds = {"ARHCD"};
			 * driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
			 * pageIds, driverArray, appNum); } }
			 */
			final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			
			final SortedSet categorySelectionProfile = categorySelectionProfileManager
					.loadCategoryChangeSelectionProfile(appNum,
							AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL);
			if(categorySelectionProfile!=null && categorySelectionProfile.size()>0)
			{
			categorySelectionProfileManager.removeSequenceDetail(categorySelectionProfile,
					appNum, Short.parseShort(indvSeqNum),
					Long.parseLong(seqNum),AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL , AppConstants.HEALTHINS_INFORMATION);
			categorySelectionProfileManager.removeSequenceDetail(categorySelectionProfile,
					appNum, Short.parseShort(indvSeqNum),
					Long.parseLong(seqNum),AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL , AppConstants.OTHR_HLTH_INS_INFORMATION);
			}
			
			final short[] responseArray = new short[] { IRMCResponseProfileManager.HEALTHCARE_COVERAGE };
			final SortedSet rmcSelPrfl = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			final HealthCareCoverageBO hlthInsBO = new HealthCareCoverageBO();
			if (beforeColl != null) {
				int count = 0;
				APP_IN_HLTH_INS_BNFTS_Collection rb1Coll = null;
				APP_IN_HLTH_INS_BNFTS_Cargo rb1Cargo = null;
				rb1Coll = hlthInsBO.getHealthInsrDetails(appNum);

				if (rb1Coll != null && !rb1Coll.isEmpty()) {
					final int rbCollSize = rb1Coll.size();
					for (int i = 0; i < rbCollSize; i++) {
						rb1Cargo = rb1Coll.getCargo(i);
						if (rb1Cargo.getIndv_seq_num().equals(indvSeqNum)
								&& AppConstants.RMC_NEW_RECORD_IND
								.equals(rb1Cargo.getSrc_app_ind())) {
							count++;
						}
					}
				}
				if (count == 0) {
					// now we need to make that profile requirred
					final RMC_IN_PRFL_Cargo rmcResCargo = rmcResponseProfileManager
							.getProfile(rmcInPrflColl, indvSeqNum);
					rmcResponseProfileManager.makeAbsoluteNotRequired(
							responseArray, rmcResCargo, true);
					/*
					 * VG SONAR Cleanup - 09/1/2015 Deleted 1 lines Commented
					 * Code in this block
					 */

				}
			}

			boolean rmcPrflSchEnrlNotRequired = false;
			// here we need to check we have no entrys in rmcPrfl for the job
			// income detail
			// as well as we need to check
			if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl,
						IRMCResponseProfileManager.HEALTHCARE_COVERAGE)) {
					rmcPrflSchEnrlNotRequired = true;
				}

			} else {
				rmcPrflSchEnrlNotRequired = true;

			}
			final Map hlthcvrg = new HashMap();
			hlthcvrg.put("HI", "HI");
			if (!checkBenefitDetailPageRequired(rmcSelPrfl, hlthcvrg)
					&& rmcPrflSchEnrlNotRequired) {
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"ARHIN", driverArray, appNum);
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"AROHI", driverArray, appNum);
			}
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
					driverArray, appNum);
			session.remove(AppConstants.RMC_IN_PRFL_MASTER);
			session.put(AppConstants.RMC_IN_PRFL_MASTER, rmcInPrflColl);
			log(ILog.INFO, "RMCOtherBenefitsEJBBean::eraseMedInsDetails:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("eraseMedInsDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"eraseMedInsDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.eraseMedInsDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Createand load arobs response maps to page collection.
	 *
	 * @param rmcInPrflColl the rmc in prfl coll
	 * @param pageCollection the page collection
	 * @param peopleHandler the people handler
	 * @param pageLoad the page load
	 * @param driverStatus the driver status
	 * @param outsideStatus the outside status
	 * @return the map
	 */
	private Map createandLoadAROBSResponseMapsToPageCollection(
			final RMC_IN_PRFL_Collection rmcInPrflColl,
			final Map pageCollection, final PeopleHandler peopleHandler,
			final boolean pageLoad, final int driverStatus,
			final boolean outsideStatus) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.createandLoadAROBSResponseMapsToPageCollection() - START");

		try {
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::createandLoadAROBSResponseMapsToPageCollection:Start");
			getPeopleCollectionAndUpdateMaps(rmcInPrflColl, pageCollection,
					peopleHandler, "20033",
					IRMCResponseProfileManager.SPECIAL_NEED, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(rmcInPrflColl, pageCollection,
					peopleHandler, "20034",
					IRMCResponseProfileManager.FOSTER_CARE_RESP, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(rmcInPrflColl, pageCollection,
					peopleHandler, "20035",
					IRMCResponseProfileManager.FORMER_FOSTER_RESP, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(rmcInPrflColl, pageCollection,
					peopleHandler, "20036",
					IRMCResponseProfileManager.CHILD_PROTECTIVE_RESP, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(rmcInPrflColl, pageCollection,
					peopleHandler, "20037",
					IRMCResponseProfileManager.LIVING_PROG_RESP, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(rmcInPrflColl, pageCollection,
					peopleHandler, "20038",
					IRMCResponseProfileManager.GRAND_PARENT_RESP, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(rmcInPrflColl, pageCollection,
					peopleHandler, "20039",
					IRMCResponseProfileManager.DRUG_FELONIES_RESP, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(rmcInPrflColl, pageCollection,
					peopleHandler, "20040",
					IRMCResponseProfileManager.SNAP_TANF_DISC_RESP, pageLoad,
					driverStatus, false);

			getPeopleCollectionAndUpdateMaps(rmcInPrflColl, pageCollection,
					peopleHandler, "20062",
					IRMCResponseProfileManager.TANF_DISC_RESP, pageLoad,
					driverStatus, false);

			getPeopleCollectionAndUpdateMaps(rmcInPrflColl, pageCollection,
					peopleHandler, "20041",
					IRMCResponseProfileManager.AVOID_PROSC_RESP, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(rmcInPrflColl, pageCollection,
					peopleHandler, "20042",
					IRMCResponseProfileManager.VIOLATING_PAROLE_RESP, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(rmcInPrflColl, pageCollection,
					peopleHandler, "20043",
					IRMCResponseProfileManager.CONVIC_FALSE_INFO_RESP,
					pageLoad, driverStatus, false);
			getPeopleCollectionAndUpdateMaps(rmcInPrflColl, pageCollection,
					peopleHandler, "20044",
					IRMCResponseProfileManager.VOLUNTARILY_QUIT_JOB_RESP,
					pageLoad, driverStatus, false);
			getPeopleCollectionAndUpdateMaps(rmcInPrflColl, pageCollection,
					peopleHandler, "20045",
					IRMCResponseProfileManager.TRADING_SNAP_RESP, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(rmcInPrflColl, pageCollection,
					peopleHandler, "20046",
					IRMCResponseProfileManager.BUY_SELL_SNAP_RESP, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(rmcInPrflColl, pageCollection,
					peopleHandler, "20047",
					IRMCResponseProfileManager.TRADE_SNAP_GUN_RESP, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(rmcInPrflColl, pageCollection,
					peopleHandler, "20048",
					IRMCResponseProfileManager.PREV_SSI_RESP, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(rmcInPrflColl, pageCollection,
					peopleHandler, "20049",
					IRMCResponseProfileManager.HOME_COMMUNITY_RESP, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(rmcInPrflColl, pageCollection,
					peopleHandler, "20050",
					IRMCResponseProfileManager.TRIBAL_HEALTH_RESP, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(rmcInPrflColl, pageCollection,
					peopleHandler, "20051",
					IRMCResponseProfileManager.TRIBAL_ELIGIBILITY_RESP,
					pageLoad, driverStatus, false);
			getPeopleCollectionAndUpdateMaps(rmcInPrflColl, pageCollection,
					peopleHandler, "20052",
					IRMCResponseProfileManager.DOMESTIC_VIOLENCE_RESP,
					pageLoad, driverStatus, false);
			getPeopleCollectionAndUpdateMaps(rmcInPrflColl, pageCollection,
					peopleHandler, "20053",
					IRMCResponseProfileManager.TANF_EPPIC_RESP, pageLoad,
					driverStatus, false);
			getPeopleCollectionAndUpdateMaps(rmcInPrflColl, pageCollection,
					peopleHandler, "20054",
					IRMCResponseProfileManager.EMERGENCY_MEDICAL_RESP,
					pageLoad, driverStatus, false);
			getPeopleCollectionAndUpdateMaps(rmcInPrflColl, pageCollection,
					peopleHandler, "20016",
					IRMCResponseProfileManager.AVD_PRSCTN_FSTF,
					pageLoad, driverStatus, false);
			getPeopleCollectionAndUpdateMaps(rmcInPrflColl, pageCollection,
					peopleHandler, "508",
					IRMCResponseProfileManager.KATIE_BECKETT,
					pageLoad, driverStatus, false);

			/*
			 * VG SONAR Cleanup - 09/1/2015 Changed Commented code block to
			 * javadoc
			 */
			/**
			 * getPeopleCollectionAndUpdateMaps(rmcInPrflColl, pageCollection,
			 * peopleHandler, "5205",
			 * IRMCResponseProfileManager.MAPP_BENEFITS_RESP, pageLoad,
			 * driverStatus, true);
			 * getPeopleCollectionAndUpdateMaps(rmcInPrflColl, pageCollection,
			 * peopleHandler, "5203",
			 * IRMCResponseProfileManager.HEALTHCARE_COVERAGE, pageLoad,
			 * driverStatus, true);
			 * getPeopleCollectionAndUpdateMapsForSummary(rmcInPrflColl,
			 * pageCollection, peopleHandler, "5202",
			 * IRMCResponseProfileManager.TRB_CMDY_RESP, pageLoad, true);
			 * getPeopleCollectionAndUpdateMaps(rmcInPrflColl, pageCollection,
			 * peopleHandler, "5249",
			 * IRMCResponseProfileManager.HEALTHCARE_COVERAGE, pageLoad,
			 * driverStatus, true);
			 *
			 * // Past Health Coverage
			 *
			 * getPeopleCollectionAndUpdateMaps(rmcInPrflColl,pageCollection,
			 * peopleHandler, "5273",
			 * IRMCResponseProfileManager.PAST_HEALTHCARE_COVERAGE, pageLoad,
			 * driverStatus, true);
			 */

			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::createandLoadAROBSResponseMapsToPageCollection:End");

			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean.createandLoadAROBSResponseMapsToPageCollection() - END , Time Taken : "
							+ (System.currentTimeMillis() - startTime)
							+ " milliseconds");
			return pageCollection;
		} catch (final FwException fe) {
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			final FwException fe = createFwException(this.getClass().getName(),
					"createandLoadAROBSResponseMapsToPageCollection", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
	}

	/**
	 * Createand load arobs response maps to page collection after validation.
	 *
	 * @param rmcInPrflColl the rmc in prfl coll
	 * @param sessRmcInPrflColl the sess rmc in prfl coll
	 * @param pageCollection the page collection
	 * @param peopleHandler the people handler
	 * @param pageLoad the page load
	 * @param driverStatus the driver status
	 * @param outsideStatus the outside status
	 * @return the map
	 */
	private Map createandLoadAROBSResponseMapsToPageCollectionAfterValidation(
			final RMC_IN_PRFL_Collection rmcInPrflColl,
			final RMC_IN_PRFL_Collection sessRmcInPrflColl,
			final Map pageCollection, final PeopleHandler peopleHandler,
			final boolean pageLoad, final int driverStatus,
			final boolean outsideStatus) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.createandLoadAROBSResponseMapsToPageCollectionAfterValidation() - START");

		try {
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::createandLoadAROBSResponseMapsToPageCollection:Start");
			/*
			 * VG SONAR Cleanup - 09/1/2015 Changed Commented code block to
			 * javadoc
			 */
			/**
			 * getPeopleCollectionAndUpdateMaps(sessRmcInPrflColl,
			 * pageCollection, peopleHandler, "5205",
			 * IRMCResponseProfileManager.MAPP_BENEFITS_RESP, pageLoad,
			 * driverStatus, true);
			 * getPeopleCollectionAndUpdateMaps(sessRmcInPrflColl,
			 * pageCollection, peopleHandler, "5203",
			 * IRMCResponseProfileManager.HEALTHCARE_COVERAGE, pageLoad,
			 * driverStatus, true);
			 * getPeopleCollectionAndUpdateMapsForSummaryAfterValidation
			 * (rmcInPrflColl,sessRmcInPrflColl, pageCollection, peopleHandler,
			 * "5202", IRMCResponseProfileManager.TRB_CMDY_RESP, pageLoad,
			 * true); getPeopleCollectionAndUpdateMaps(sessRmcInPrflColl,
			 * pageCollection, peopleHandler, "5249",
			 * IRMCResponseProfileManager.HEALTHCARE_COVERAGE, pageLoad,
			 * driverStatus, true); //Past Health Coverage
			 * getPeopleCollectionAndUpdateMaps(sessRmcInPrflColl,
			 * pageCollection, peopleHandler, "5273",
			 * IRMCResponseProfileManager.HEALTHCARE_COVERAGE, pageLoad,
			 * driverStatus, true);
			 */
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::createandLoadAROBSResponseMapsToPageCollection:End");
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean.createandLoadAROBSResponseMapsToPageCollectionAfterValidation() - END , Time Taken : "
							+ (System.currentTimeMillis() - startTime)
							+ " milliseconds");
			return pageCollection;
		} catch (final FwException fe) {
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			final FwException fe = createFwException(this.getClass().getName(),
					"createandLoadAROBSResponseMapsToPageCollection", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
	}

	/**
	 * Edits the se details.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void editSEDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.editSEDetails() - START");

		try {
			log(ILog.INFO, "RMCHousingExpenseEJBBean::editSEDetails:Start");
			final Map session = txnBean.getSession();
			final Map pageCollection = txnBean.getPageCollection();

			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			// Get the APP_IN_EMPL_Collection from pageCollection.
			final APP_IN_SCHLE_Collection schColl = (APP_IN_SCHLE_Collection) pageCollection
					.get("APP_IN_SCHLE_Collection");
			final APP_IN_SCHLE_Cargo schCargo = schColl.getResult(0);

			final IndivTypeSeqBean seqBean = new IndivTypeSeqBean();
			seqBean.setIndivSeqNum(schCargo.getIndv_seq_num());
			seqBean.setSeqNum(FwConstants.ZERO);
			seqBean.setType(schCargo.getSrc_app_ind());
			// setting user end indicator

			pageCollection.put(FwConstants.DETAIL_KEY_BEAN, seqBean);
			final RMB_RQST_Collection rmbColl = (RMB_RQST_Collection) session
					.get(AppConstants.RMB_RQST_COLLECTION);

			if (rmbColl != null && !rmbColl.isEmpty()) {

				// Get RMB_RQST_Cargo for appNum
				final RMB_RQST_Cargo rmbRqstCargo = rmbColl.getCargo(0);
				if (rmbRqstCargo.getSchl_enrl_stat_ind() != null
						&& !FwConstants.YES.equals(rmbRqstCargo
								.getSchl_enrl_stat_ind())) {
					rmbRqstCargo.setSchl_enrl_stat_ind(FwConstants.YES);
					rmbRqstCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
					rmbColl.addCargo(rmbRqstCargo);
					rmbColl.persist(FwConstants.DAO);
				}
				// add to session
				session.put(AppConstants.RMB_RQST_COLLECTION, rmbColl);
			}

			// Get App Number
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			// Set RMC page Job Income Details make required
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARHSE",
					driverArray, appNum);
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
					driverArray, appNum);
			// End
			log(ILog.INFO, "RMCHousingExpenseEJBBean::editSEDetails:End");

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("editSEDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"editSEDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.editSEDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Adds the schl enrl details.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void addSchlEnrlDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.addSchlEnrlDetails() - START");

		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			// get cargo determining user selection
			request.put("firstName_medIns", null);
			request.put("firstName_MAPP", null);
			final String schSeq = request.get("firstName_SE") != null ? (String) request
					.get("firstName_SE") : FwConstants.EMPTY_STRING;

					final SchoolEnrollmentBO schBO = new SchoolEnrollmentBO();// Write
					// the
					// validator
					// validate selections

					if (schSeq == null
							|| AppConstants.SELECT_DEFAULT_OPTION.equals(schSeq)) {
						schBO.validateAdd();
						// add validation message and return
						request.put(FwConstants.MESSAGE_LIST, schBO.getMessageList());
						txnBean.setPageCollection((Map) session
								.get(FwConstants.BEFORE_COLLECTION));
						return;
					}
					final String appNum = (String) session.get(AppConstants.APP_NUMBER);
					final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
					indivSeqBean.setIndivSeqNum(schSeq);
					indivSeqBean.setSeqNum(FwConstants.ZERO);
					indivSeqBean.setType(AppConstants.ADD_SCHOOL_ENROLLMENT);
					indivSeqBean.setUserEndInd(FwConstants.ZERO);
					pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

					final String appType = (String) session
							.get(FwConstants.ACCESS_APPLICATION_TYPE);

					if (appType.equalsIgnoreCase(String
							.valueOf(FwConstants.RMB_APP_TYPE))) {
						final RMB_RQST_Collection rmbColl = (RMB_RQST_Collection) session
								.get(AppConstants.RMB_RQST_COLLECTION);

						// Get RMB_RQST_Cargo for appNum
						final RMB_RQST_Cargo rmbRqstCargo = rmbColl.getCargo(0);
						if (rmbRqstCargo.getSchl_enrl_stat_ind() != null
								&& !FwConstants.YES.equals(rmbRqstCargo
										.getSchl_enrl_stat_ind())) {
							rmbRqstCargo.setSchl_enrl_stat_ind(FwConstants.YES);
							rmbRqstCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
							rmbColl.addCargo(rmbRqstCargo);
							rmbColl.persist(FwConstants.DAO);
						}
						// add to session
						session.put(AppConstants.RMB_RQST_COLLECTION, rmbColl);
					}
					// set driver status
					final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARHSE", driver,
							appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driver,
							appNum);
					session.put(FwConstants.RMC_DRIVER, driver);

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("addSchlEnrlDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"addSchlEnrlDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.addSchlEnrlDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Gets the out side home name.
	 *
	 * @param medColl the med coll
	 * @param indvSeqNum the indv seq num
	 * @param plcySeqNum the plcy seq num
	 * @return the out side home name
	 */
	private String getOutSideHomeName(final APP_MED_INS_Collection medColl,
			final String indvSeqNum, final String plcySeqNum) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.getOutSideHomeName() - START");

		try {
			String personName = FwConstants.EMPTY_STRING;

			final int collSize = medColl.size();
			for (int i = 0; i < collSize; i++) {
				final APP_MED_INS_Cargo medCargo = medColl.getCargo(i);
				if (indvSeqNum.equals(medCargo.getPlcy_hold_seq_num())
						&& plcySeqNum.equals(medCargo.getPlcy_seq_num())) {
					personName = medCargo.getPlcy_hold_fst_nam();
				}
			}
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean.getOutSideHomeName() - END , Time Taken : "
							+ (System.currentTimeMillis() - startTime)
							+ " milliseconds");
			return personName;
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("getOutSideHomeName");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"getOutSideHomeName", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
	}

	/**
	 * Gets the past health ins.
	 *
	 * @param pastHlthInsColl the past hlth ins coll
	 * @param indvSeqNum the indv seq num
	 * @param coverageType the coverage type
	 * @return the past health ins
	 */
	private String getpastHealthIns(
			final CP_APP_IN_LST_HLTH_INS_Collection pastHlthInsColl,
			final String indvSeqNum, final String coverageType) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.getpastHealthIns() - START");

		try {
			String hlthCovEndDate = FwConstants.EMPTY_STRING;

			final int collSize = pastHlthInsColl.size();
			for (int i = 0; i < collSize; i++) {
				final CP_APP_IN_LST_HLTH_INS_Cargo medCargo = pastHlthInsColl
						.getCargo(i);
				if (indvSeqNum.equals(medCargo.getCoverageType())
						&& coverageType.equals(medCargo.getCoverageType())) {
					hlthCovEndDate = medCargo.getEnd_date();
				}
			}
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean.getpastHealthIns() - END , Time Taken : "
							+ (System.currentTimeMillis() - startTime)
							+ " milliseconds");
			return hlthCovEndDate;
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("getpastHealthIns");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"getpastHealthIns", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
	}

	/**
	 * Gets the people collection and update mapsfor rmc.
	 *
	 * @param rmcInPrflColl the rmc in prfl coll
	 * @param sessRmcInPrflColl the sess rmc in prfl coll
	 * @param pageCollection the page collection
	 * @param peopleHandler the people handler
	 * @param compID the comp id
	 * @param questionName the question name
	 * @param pageLoad the page load
	 * @param driverStatus the driver status
	 * @param getRelevant the get relevant
	 * @return the people collection and update mapsfor rmc
	 */
	public Map getPeopleCollectionAndUpdateMapsforRMC(
			final RMC_IN_PRFL_Collection rmcInPrflColl,
			final RMC_IN_PRFL_Collection sessRmcInPrflColl,
			final Map pageCollection, final PeopleHandler peopleHandler,
			final String compID, final short questionName,
			final boolean pageLoad, final int driverStatus,
			final boolean getRelevant) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.getPeopleCollectionAndUpdateMapsforRMC() - START");

		try {
			// Declarations
			String indivSeqNum = null;
			INDIVIDUAL_Custom_Cargo indivCargo;
			INDIVIDUAL_Custom_Collection indivColl;
			final StringBuilder indivCollKey = new StringBuilder();
			indivCollKey.append(AppConstants.PEOPLE);
			indivCollKey.append(compID);

			// try to get a filtered list. If it doesn't exist, get the
			// peopleHandler getIndividuals
			if (pageCollection.get(indivCollKey.toString()) == null) {

				if (getRelevant) {
					indivColl = peopleHandler.getInHomeIndividuals();
				} else {
					indivColl = peopleHandler.getInHomeIndividuals();
				}
			} else {
				indivColl = (INDIVIDUAL_Custom_Collection) pageCollection
						.get(indivCollKey.toString());
			}

			// set the passed response map = new map
			final Map questionRespMap = new HashMap();

			// create an appInPrfl object
			RMC_IN_PRFL_Cargo rmcInPrflCargo = null;

			// get size of the collection
			final int indivCollSize = indivColl.size();

			// Define NoOneChecked = YES flags for the question
			String noOneChecked = FwConstants.YES;

			// Loop for each Cargo in the people collection (for each person)
			for (int i = 0; i < indivCollSize; i++) {
				// get the indivCargo
				indivCargo = (INDIVIDUAL_Custom_Cargo) indivColl.get(i);

				// get app_indiv_seq_num
				indivSeqNum = indivCargo.getIndv_seq_num();

				// Get the rmcInPrflCargo for this person
				rmcInPrflCargo = rmcResponseProfileManager.getProfile(
						rmcInPrflColl, indivSeqNum);

				// get the RMC_IN_PRFL Response for the given question from this
				// cargo
				String questionResp = rmcResponseProfileManager
						.getProfileResponse(rmcInPrflCargo, questionName);

				if (questionName == (short) 18 || questionName == (short) 80) {
					for (int j = 0; j < sessRmcInPrflColl.size(); j++) {
						final RMC_IN_PRFL_Cargo cargo = sessRmcInPrflColl
								.getCargo(j);
						if (cargo.getIndv_seq_num().equals(indivSeqNum)) {
							final String status = rmcResponseProfileManager
									.getProfileResponse(cargo, questionName);
							if (status != null && questionResp != null
									&& "C".equals(status)
									&& FwConstants.YES.equals(questionResp)) {
								questionResp = "C";
							}
						}
					}
				}

				// for this question, add the person's response to a map
				questionRespMap.put(indivSeqNum, questionResp);

				if (pageLoad == true) {
					// for each question, set the noOneChecked flag
					// check if there is anything other than not required - if
					// so, change flag
					if (questionResp != null
							&& (questionResp.charAt(0) == IRMCResponseProfileManager.STATUS_REQUIRED
									|| questionResp.charAt(0) == IRMCResponseProfileManager.STATUS_COMPLETE || questionResp
							.charAt(0) == IRMCResponseProfileManager.STATUS_VISIT_AGAIN)) {
						noOneChecked = FwConstants.NO;
					}
				}

			}// end for loop

			if (pageLoad == true) {
				if (driverStatus == FwConstants.DRIVER_REQUIRED) {
					noOneChecked = FwConstants.NO;
				}

				// get the NoOneChecked map from the pagecollection
				Map noOneCheckedMap = (Map) pageCollection
						.get(AppConstants.NO_ONE_CHECKED_MAP);
				if (noOneCheckedMap == null) {
					noOneCheckedMap = new HashMap();
				}

				// update the noOneCheckedMap and re-add it to the page coll
				final StringBuilder noOneCheckedString = new StringBuilder();
				noOneCheckedString.append(AppConstants.NO_ONE_CHECKED);
				noOneCheckedString.append(compID);
				noOneCheckedMap
				.put(noOneCheckedString.toString(), noOneChecked);
				pageCollection.put(AppConstants.NO_ONE_CHECKED_MAP,
						noOneCheckedMap);
			}

			// Store all maps in page collection
			final StringBuilder respMapString = new StringBuilder();
			respMapString.append(AppConstants.RESP_MAP);
			respMapString.append(compID);
			pageCollection.put(respMapString.toString(), questionRespMap);

			// store people collection in page collection
			final StringBuilder peopleString = new StringBuilder();
			peopleString.append(AppConstants.PEOPLE);
			peopleString.append(compID);
			pageCollection.put(peopleString.toString(), indivColl);
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean.getPeopleCollectionAndUpdateMapsforRMC() - END , Time Taken : "
							+ (System.currentTimeMillis() - startTime)
							+ " milliseconds");

			return pageCollection;
			// exit
		} catch (final FwException fe) {
			fe.setParameterText(compID);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			final FwException fe = createFwException(this.getClass().getName(),
					"getPeopleCollectionAndUpdateMaps", e);
			fe.setParameterText(compID);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
	}

	/**
	 * Check benefit detail page required.
	 *
	 * @param categorySelectionProfile the category selection profile
	 * @param catType the cat type
	 * @return true, if successful
	 */
	public boolean checkBenefitDetailPageRequired(
			final SortedSet categorySelectionProfile, final Map catType) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.checkBenefitDetailPageRequired() - START");

		try {
			boolean isexpensePageRequired = false;
			if (categorySelectionProfile != null) {
				// this one form the category selection profile
				final Iterator iter = categorySelectionProfile.iterator();
				CategorySequenceDetail categorySeqDtl = null;
				while (iter.hasNext()) {
					categorySeqDtl = (CategorySequenceDetail) iter.next();
					if (catType != null
							&& catType.get(categorySeqDtl.getCategoryType()) != null
							&& categorySeqDtl.getUserEndSelectionInd() != AppConstants.RMB_NO_CHANGE_SEL_IND) {
						isexpensePageRequired = true;
						break;
					}
				}
			}
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean.checkBenefitDetailPageRequired() - END , Time Taken : "
							+ (System.currentTimeMillis() - startTime)
							+ " milliseconds");
			return isexpensePageRequired;
		} catch (final FwException fe) {
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			final FwException fe = createFwException(this.getClass().getName(),
					"checkExpenseDetailPageRequired", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
	}

	/**
	 * Gets the people collection and update maps for summary after validation.
	 *
	 * @param rmcInPrflColl the rmc in prfl coll
	 * @param sessRmcInPrflColl the sess rmc in prfl coll
	 * @param pageCollection the page collection
	 * @param peopleHandler the people handler
	 * @param compID the comp id
	 * @param questionName the question name
	 * @param pageLoad the page load
	 * @param getRelevant the get relevant
	 * @return the people collection and update maps for summary after validation
	 */
	public Map getPeopleCollectionAndUpdateMapsForSummaryAfterValidation(
			final RMC_IN_PRFL_Collection rmcInPrflColl,
			final RMC_IN_PRFL_Collection sessRmcInPrflColl,
			final Map pageCollection, final PeopleHandler peopleHandler,
			final String compID, final short questionName,
			final boolean pageLoad, final boolean getRelevant) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.getPeopleCollectionAndUpdateMapsForSummaryAfterValidation() - START");

		try {
			// Declarations
			String indivSeqNum = null;
			INDIVIDUAL_Custom_Cargo indivCargo;
			INDIVIDUAL_Custom_Collection indivColl;
			final StringBuilder indivCollKey = new StringBuilder();
			indivCollKey.append(AppConstants.PEOPLE);
			indivCollKey.append(compID);

			// try to get a filtered list. If it doesn't exist, get the
			// peopleHandler getIndividuals
			if (pageCollection.get(indivCollKey.toString()) == null) {
				if (getRelevant) {
					indivColl = peopleHandler.getInHomeIndividuals();
				} else {
					indivColl = peopleHandler.getInHomeIndividuals();
				}
			} else {
				indivColl = (INDIVIDUAL_Custom_Collection) pageCollection
						.get(indivCollKey.toString());
			}

			// set the passed response map = new map
			final Map questionRespMap = new HashMap();

			// create an appInPrfl object
			RMC_IN_PRFL_Cargo rmcInPrflCargo = null;

			// get size of the collection
			final int indivCollSize = indivColl.size();

			// Define NoOneChecked = YES flags for the question
			String noOneChecked = FwConstants.YES;

			// Loop for each Cargo in the people collection (for each person)
			for (int i = 0; i < indivCollSize; i++) {
				// get the indivCargo
				indivCargo = (INDIVIDUAL_Custom_Cargo) indivColl.get(i);

				// get app_indiv_seq_num
				indivSeqNum = indivCargo.getIndv_seq_num();

				// Call the nethod to check is the Indv Seq Num is exists in
				// APP_IN_PRFL or Not
				if (checkIndvExistsInRmcInPrfl(indivSeqNum, rmcInPrflColl)) {
					// Get the appInPrflCargo for this person
					rmcInPrflCargo = rmcResponseProfileManager.getProfile(
							rmcInPrflColl, indivSeqNum);

					// get the AIP Response for the given question from this
					// cargo
					String questionResp = FwConstants.EMPTY_STRING;
					if (rmcInPrflCargo.getTrb_cmdy_resp() != null) {
						questionResp = rmcResponseProfileManager
								.getProfileResponse(rmcInPrflCargo,
										questionName);
					} else {
						questionResp = FwConstants.NO;
					}

					// for this question, add the person's response to a map
					questionRespMap.put(indivSeqNum, questionResp);

					if (pageLoad == true) {
						// for each question, set the noOneChecked flag
						// check if there is anything other than not required -
						// if so, change flag
						if (questionResp.charAt(0) != IApplicationManager.STATUS_NOT_REQUIRED) {
							noOneChecked = FwConstants.NO;
						}
					}
				}// end of if - check IndvSeqNum exists or not
			}// end for loop

			if (pageLoad == true) {
				// get the NoOneChecked map from the pagecollection
				Map noOneCheckedMap = (Map) pageCollection
						.get(AppConstants.NO_ONE_CHECKED_MAP);
				if (noOneCheckedMap == null) {
					noOneCheckedMap = new HashMap();
				}

				// update the noOneCheckedMap and re-add it to the page coll
				final StringBuilder noOneCheckedString = new StringBuilder();
				noOneCheckedString.append(AppConstants.NO_ONE_CHECKED);
				noOneCheckedString.append(compID);
				noOneCheckedMap
				.put(noOneCheckedString.toString(), noOneChecked);
				pageCollection.put(AppConstants.NO_ONE_CHECKED_MAP,
						noOneCheckedMap);
			}

			// Store all maps in page collection
			final StringBuilder respMapString = new StringBuilder();
			respMapString.append(AppConstants.RESP_MAP);
			respMapString.append(compID);
			pageCollection.put(respMapString.toString(), questionRespMap);

			// store people collection in page collection
			final StringBuilder peopleString = new StringBuilder();
			peopleString.append(AppConstants.PEOPLE);
			peopleString.append(compID);
			pageCollection.put(peopleString.toString(), indivColl);
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean.getPeopleCollectionAndUpdateMapsForSummaryAfterValidation() - END , Time Taken : "
							+ (System.currentTimeMillis() - startTime)
							+ " milliseconds");

			return pageCollection;
			// exit
		} catch (final FwException fe) {
			fe.setParameterText(compID);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			final FwException fe = createFwException(this.getClass().getName(),
					"getPeopleCollectionAndUpdateMapsForSummary", e);
			fe.setParameterText(compID);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
	}

	/**
	 * Check indv exists in rmc in prfl.
	 *
	 * @param indvSeqNum the indv seq num
	 * @param rmcInPrflColl the rmc in prfl coll
	 * @return true, if successful
	 */
	private boolean checkIndvExistsInRmcInPrfl(final String indvSeqNum,
			final RMC_IN_PRFL_Collection rmcInPrflColl) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.checkIndvExistsInRmcInPrfl() - START");

		try {
			boolean existOrNotFlag = false;

			final int collSize = rmcInPrflColl.size();
			RMC_IN_PRFL_Cargo rmcinPrflCargo = null;
			for (int i = 0; i < collSize; i++) {
				rmcinPrflCargo = rmcInPrflColl.getCargo(i);

				if (indvSeqNum.equals(rmcinPrflCargo.getIndv_seq_num())) {
					existOrNotFlag = true;
					break;
				}
			}
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean.checkIndvExistsInRmcInPrfl() - END , Time Taken : "
							+ (System.currentTimeMillis() - startTime)
							+ " milliseconds");

			return existOrNotFlag;

		} catch (final FwException fe) {
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			final FwException fe = createFwException(this.getClass().getName(),
					"checkIndvExistsInRmcInPrfl", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
	}

	/**
	 * Past Health care coverage : Which collects information about individuals
	 * who had a health insurance policy that ended in the past 12 months- Load
	 * and Store methods are newly coded for RMB PCR# 43100 - CLA RENEWALS
	 * CHANGES.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 * @throws javax.ejb.EJBException the javax.ejb. ejb exception
	 */
	public void loadPastCoverageDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.loadPastCoverageDetails() - START");

		try {
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::loadPastCoverageDetails:Start");

			// Initial loading of session, request and pagecontext data.
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			Map pageCollection = txnBean.getPageCollection();
			// record array list to prepare indivduals
			final List recordArray = new ArrayList();
			// index for the current individual
			String currentRecordIndex = AppConstants.EMPTY_STRING;

			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			final String currentPageID = (String) request
					.get(FwConstants.CURRENT_PAGE_ID);
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			final int driverStatus = driverManager.getAFBStatus(
					FwConstants.RMC_DRIVER, currentPageID, driverArray);
			final RMC_IN_PRFL_Collection sessionRmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);

			final PeopleHandler peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);
			final HealthCareCoverageBO heathCareBO = new HealthCareCoverageBO();
			// if previous pageID is not equal to the present pageID then clean
			// the session and Before Collection
			if (!((String) request.get(FwConstants.PREVIOUS_PAGE_ID))
					.equals(currentPageID)) {
				session.remove("APP_MED_INS_Collection");
				session.remove(FwConstants.BEFORE_COLLECTION);
			}

			if (pageCollection.get(FwConstants.DETAIL_KEY_BEAN) != null) {
				APP_MED_INS_Collection appmedcolltemp = new APP_MED_INS_Collection();
				APP_MED_INS_Cargo appMedCargo = null;

				final IndivTypeSeqBean indvTypeSeqBean = (IndivTypeSeqBean) pageCollection
						.get(FwConstants.DETAIL_KEY_BEAN);
				pageCollection = new HashMap();

				pageCollection.put("APP_MED_INS_Collection", heathCareBO
						.loadPastHealthCareCoverageWithIndvNum(appNum,
								indvTypeSeqBean.getIndivSeqNum()));
				pageCollection.put(AppConstants.FIRST_NAME, peopleHandler
						.getFirstName(indvTypeSeqBean.getIndivSeqNum()));

				appmedcolltemp = heathCareBO.loadPastHealthCareCoverage(appNum);

				IndivTypeSeqBean recordBean = null;
				if (appmedcolltemp != null && !appmedcolltemp.isEmpty()) {
					for (int s = 0; s < appmedcolltemp.size(); s++) {
						appMedCargo = appmedcolltemp.getCargo(s);
						recordBean = new IndivTypeSeqBean(
								appMedCargo.getPlcy_hold_seq_num(),
								FwConstants.EMPTY_STRING,
								appMedCargo.getPlcy_seq_num());
						recordArray.add(recordBean);
						if (appMedCargo.getPlcy_seq_num().equals(
								indvTypeSeqBean.getSeqNum())) {
							currentRecordIndex = String.valueOf(s);
						}
					}
				}
			} else {
				// if DETAIL_KEY_BEAN is not there in pageCollection
				if (session.get("APP_MED_INS_Collection") == null) {
					setPastCoverageCollectionToSession(txnBean, driverStatus);
				}
				// check if pageStatus is REQ OR ADDNEW or VISIT_AGAIN
				if (driverStatus == FwConstants.DRIVER_REQUIRED
						|| driverStatus == FwConstants.DRIVER_ADD_NEW
						|| driverStatus == FwConstants.DRIVER_VISIT_AGAIN) {
					RMC_IN_PRFL_Cargo rmcinprflCargo = null;
					// Reference Table Code
					String indvSeqNum = null;
					final int cargoSize = sessionRmcInPrflColl.size();
					char typeStatus = 'N';
					// loop thru RMC_IN_PRFL Collection
					// Check status of each Medical details type in alphabetical
					// order as defined in Reference table for each Cargo
					for (int i = 0; i < cargoSize; i++) {
						rmcinprflCargo = sessionRmcInPrflColl.getCargo(i);
						indvSeqNum = rmcinprflCargo.getIndv_seq_num();
						typeStatus = rmcResponseProfileManager
								.getProfileResponse(
										rmcinprflCargo,
										IRMCResponseProfileManager.PAST_HEALTHCARE_COVERAGE)
										.charAt(0);
						if (typeStatus == IRMCResponseProfileManager.STATUS_VISIT_AGAIN) {
							setPastCoverageDetailsCargoFromSession(session,
									pageCollection, driverStatus, indvSeqNum);
							APP_MED_INS_Collection appmedcolltemp = new APP_MED_INS_Collection();
							APP_MED_INS_Cargo appMedCargo = null;
							appmedcolltemp = heathCareBO
									.loadPastHealthCareCoverage(appNum);

							IndivTypeSeqBean recordBean = null;
							if (appmedcolltemp != null
									&& !appmedcolltemp.isEmpty()) {
								for (int s = 0; s < appmedcolltemp.size(); s++) {
									appMedCargo = appmedcolltemp.getCargo(s);
									recordBean = new IndivTypeSeqBean(
											appMedCargo.getPlcy_hold_seq_num(),
											FwConstants.EMPTY_STRING,
											appMedCargo.getPlcy_seq_num());
									recordArray.add(recordBean);
									if (appMedCargo.getPlcy_hold_seq_num()
											.equals(indvSeqNum)) {
										currentRecordIndex = String.valueOf(s);
									}
								}
							}
							break;
						} else if (typeStatus == IRMCResponseProfileManager.STATUS_REQUIRED
								|| typeStatus == IRMCResponseProfileManager.STATUS_ADD_NEW) {
							setPastCoverageDetailsCargo(indvSeqNum, session,
									pageCollection);
							break;
						}
					}

				} else {
					final APP_MED_INS_Collection appMedInsColl = (APP_MED_INS_Collection) session
							.get("APP_MED_INS_Collection");
					APP_MED_INS_Cargo appMedInsCargo = null;
					final int size = appMedInsColl.size();
					if (size > 0) {
						// get last cargo from session
						appMedInsCargo = appMedInsColl.getCargo(size - 1);
					}
					final APP_MED_INS_Collection appMedInsNewColl = new APP_MED_INS_Collection();
					appMedInsNewColl.addCargo(appMedInsCargo);
					// set Details_Collection from session to PageCollection
					pageCollection.put("APP_MED_INS_Collection",
							appMedInsNewColl);
					// set frist Name to PageCollection
					pageCollection.put(AppConstants.FIRST_NAME,
							peopleHandler.getFirstName(appMedInsCargo
									.getPlcy_hold_seq_num()));

				}
			}
			APP_MED_INS_Cargo appMedFinalCargo = null;
			final APP_MED_INS_Collection appMedFinalColl = (APP_MED_INS_Collection) pageCollection
					.get("APP_MED_INS_Collection");
			if (appMedFinalColl != null) {
				appMedFinalCargo = appMedFinalColl.getCargo(0);
			}

			APP_IN_MED_INS_Collection appInMedColl = new APP_IN_MED_INS_Collection();
			// now we need to get the data for the sec section
			if (appMedFinalCargo != null
					&& appMedFinalCargo.getPlcy_hold_seq_num() != null
					&& appMedFinalCargo.getPlcy_seq_num() != null) {
				appInMedColl = heathCareBO.loadAppInMedInsPast(appNum,
						appMedFinalCargo.getPlcy_seq_num(),
						appMedFinalCargo.getPlcy_hold_seq_num());
			}
			pageCollection.put("APP_IN_MED_INS_Collection", appInMedColl);

			txnBean.setPageCollection(pageCollection);

			// if the currentindex is not empty then put the record array,
			// currentRecordIndex and lastRecordIndex into the Page Collection
			if (!AppConstants.EMPTY_STRING.equals(currentRecordIndex)) {
				pageCollection.put(FwConstants.RECORD_ARRAY, recordArray);
				pageCollection.put(FwConstants.CURRENT_RECORD_INDEX,
						currentRecordIndex);
				pageCollection.put(FwConstants.LAST_RECORD_INDEX,
						currentRecordIndex);
			}
			if (session.get(FwConstants.BEFORE_COLLECTION) != null) {
				((Map) session.get(FwConstants.BEFORE_COLLECTION))
				.putAll(pageCollection);
			} else {
				final Map beforeColl = new HashMap();
				beforeColl.putAll(pageCollection);
				session.put(FwConstants.BEFORE_COLLECTION, beforeColl);
			}
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::loadPastCoverageDetails:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("loadPastCoverageDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"loadPastCoverageDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.loadPastCoverageDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * To Store PAST HEALTH COVERAGE - PCR# 43100 - CLA RENEWALS CHANGES.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 * @throws javax.ejb.EJBException the javax.ejb. ejb exception
	 */
	public void storePastCoverageDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.storePastCoverageDetails() - START");

		String appNumber = null;

		try {
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::storePastCoverageDetails:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final String currentPageID = (String) request
					.get(FwConstants.CURRENT_PAGE_ID);
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);
			appNumber = (String) session.get(AppConstants.APP_NUMBER);
			final String language = FwConstants.ENGLISH;
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			final int driverStatus = driverManager.getAFBStatus(
					FwConstants.RMC_DRIVER, currentPageID, driverArray);
			final HealthCareCoverageBO helthCareBO = new HealthCareCoverageBO();
			final IReferenceTableManager iref = ReferenceTableManager
					.getInstance();

			final APP_IN_MED_INS_Collection appInMedInsColl = (APP_IN_MED_INS_Collection) pageCollection
					.get("APP_IN_MED_INS_Collection");
			APP_MED_INS_Cargo appMedInsCargo = new APP_MED_INS_Cargo();
			final RMC_IN_PRFL_Collection sessionRmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			final APP_MED_INS_Collection appMedInsBeforeColl = (APP_MED_INS_Collection) beforeColl
					.get("APP_MED_INS_Collection");
			final APP_IN_MED_INS_Collection appInMedInsBeforeColl = (APP_IN_MED_INS_Collection) beforeColl
					.get("APP_IN_MED_INS_Collection");
			APP_MED_INS_Cargo appMedInsBeforeCargo = new APP_MED_INS_Cargo();
			beforeColl.get("APP_PRFL_Cargo");
			if (appMedInsBeforeColl != null
					&& appMedInsBeforeColl.getCargo(0) != null) {
				appMedInsBeforeCargo = appMedInsBeforeColl.getCargo(0);
				appMedInsCargo.setApp_num(appNumber);
				appMedInsCargo.setPlcy_hold_seq_num(appMedInsBeforeColl
						.getCargo(0).getPlcy_hold_seq_num());
				appMedInsCargo.setPlcy_seq_num(appMedInsBeforeColl.getCargo(0)
						.getPlcy_seq_num());

			}
			APP_IN_MED_INS_Cargo appInMedInsCargo = null;

			final String backToMyAccess = (String) request
					.get(AppConstants.BACK_TO_MY_ACCESS_BUTTON);

			if (backToMyAccess == null) {
				helthCareBO.validatePastInsurance(appInMedInsColl);
			}
			if (checkBackToMyAccessSelected(request)
					|| helthCareBO.hasMessages()) {
				final String reqWarningMsgs = (String) request
						.get(FwConstants.WARNING_MSG_DETAILS);
				if (!checkForWarningMesgs(reqWarningMsgs,
						helthCareBO.getMessageList())) {
					helthCareBO.getMessageList();
					if (!checkBackToMyAccessSelected(request)) {
						request.put(FwConstants.MESSAGE_LIST,
								helthCareBO.getMessageList());
					}
					if (appInMedInsColl != null) {
						final int size = appInMedInsColl.size();
						for (int i = 0; i < size; i++) {
							appInMedInsCargo = appInMedInsColl.getCargo(i);
							appInMedInsCargo.setIndv_seq_num(appMedInsCargo
									.getPlcy_hold_seq_num());
							appInMedInsCargo.setCvrg_end_dt(appInMedInsCargo
									.getCvrg_end_dt());
							if (appInMedInsCargo.getPast_cvrg_gdcs_cd() != null) {
								appInMedInsCargo
								.setPast_cvrg_gdcs_cd(iref
										.getColumnValue(
												"TPCR",
												139,
												appInMedInsCargo
												.getPast_cvrg_gdcs_cd(),
												language));
							}
						}
					}
					appInMedInsColl.addCargo(appInMedInsCargo);
					pageCollection.put("APP_IN_MED_INS_Collection",
							appInMedInsColl);
					// put the first Name into request to avoid null pointer in
					// JSP
					pageCollection.put(AppConstants.FIRST_NAME,
							beforeColl.get(AppConstants.FIRST_NAME));
					pageCollection.put(FwConstants.PAGE_COMPONENT_LIST,
							beforeColl.get(FwConstants.PAGE_COMPONENT_LIST));
					return;

				}
			}
			final short[] programKeyArray = (short[]) session
					.get(FwConstants.RMC_PROGRAM_KEY);
			final IProgramManager programManager = FwProgramManager
					.getInstance();
			programManager.isThisProgramRequested(programKeyArray,
					FwConstants.BCLA_INDEX);
			final APP_MED_INS_Collection appMedInsColl = new APP_MED_INS_Collection();
			appMedInsCargo.setApp_num((String) session
					.get(AppConstants.APP_NUMBER));
			if (appMedInsCargo.getPlcy_hold_seq_num() == null) {
				appMedInsCargo.setPlcy_hold_seq_num(FwConstants.ONE);
			}

			if (appMedInsCargo.getPlcy_seq_num() == null) {
				appMedInsCargo.setPlcy_seq_num(FwConstants.ZERO);
			}
			if (appMedInsCargo.getPrvd_nam() == null) {
				appMedInsCargo.setPrvd_nam(FwConstants.SPACE);
			}
			if (appMedInsCargo.getPrvd_l1_adr() == null) {
				appMedInsCargo.setPrvd_l1_adr(FwConstants.SPACE);
			}
			if (appMedInsCargo.getPrvd_city_adr() == null) {
				appMedInsCargo.setPrvd_city_adr(FwConstants.SPACE);
			}
			if (appMedInsCargo.getPrvd_sta_adr() == null
					|| FwConstants.DEFAULT_DROPDOWN_SEL.equals(appMedInsCargo
							.getPrvd_sta_adr())) {
				appMedInsCargo.setPrvd_sta_adr(FwConstants.SPACE);
			}
			if (appMedInsCargo.getPrvd_zip_adr() == null) {
				appMedInsCargo.setPrvd_zip_adr(FwConstants.SPACE);
			}
			if (appMedInsCargo.getIns_plcy_num() == null) {
				appMedInsCargo.setIns_plcy_num(FwConstants.SPACE);
			}
			if (appMedInsCargo.getGrp_num() == null) {
				appMedInsCargo.setGrp_num(FwConstants.SPACE);
			}
			if (appMedInsCargo.getPlcy_hold_brth_dt() == null
					|| FwConstants.EMPTY_STRING.equals(appMedInsCargo
							.getPlcy_hold_brth_dt().trim())) {
				appMedInsCargo.setPlcy_hold_brth_dt(AppConstants.HIGH_DATE);
			}
			if (appMedInsCargo.getPrem_freq_ind() == null
					|| AppConstants.SELECT_DEFAULT_OPTION.equals(appMedInsCargo
							.getPrem_freq_ind())) {
				appMedInsCargo.setPrem_freq_ind(FwConstants.EMPTY_STRING);
			}
			if (appMedInsCargo.getMaj_med_sw() == null) {
				appMedInsCargo.setMaj_med_sw(FwConstants.SPACE);
			}
			if (appMedInsCargo.getPlcy_hold_fst_nam() == null) {
				appMedInsCargo.setPlcy_hold_fst_nam(FwConstants.SPACE);
			}
			if (appMedInsCargo.getPlcy_hold_mid_init() == null) {
				appMedInsCargo.setPlcy_hold_mid_init(FwConstants.SPACE);
			}
			if (appMedInsCargo.getPlcy_hold_last_nam() == null) {
				appMedInsCargo.setPlcy_hold_last_nam(FwConstants.SPACE);
			}
			if (appMedInsCargo.getMo_prem_amt() == null
					|| FwConstants.EMPTY_STRING.equals(appMedInsCargo
							.getMo_prem_amt().trim())) {
				appMedInsCargo.setMo_prem_amt(String.valueOf("0.0"));
			}
			if (appMedInsCargo.getMo_prem_amt_ind() == null) {
				appMedInsCargo.setMo_prem_amt_ind(FwConstants.ZERO);
			}
			if (appMedInsCargo.getRec_cplt_ind() == null) {
				appMedInsCargo.setRec_cplt_ind(FwConstants.SPACE);
			}
			if (appMedInsCargo.getPlcy_hold_seq_num() == null) {
				appMedInsCargo.setPlcy_hold_seq_num(FwConstants.SPACE);
			}
			if (appMedInsCargo.getHlth_cvrg_ind() == null) {
				appMedInsCargo.setHlth_cvrg_ind("P");
			}
			if (FwConstants.ZERO.equals(appMedInsCargo.getPlcy_seq_num())) {
				appMedInsCargo.setRowAction(FwConstants.ROWACTION_INSERT);
			} else {
				appMedInsCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
			}

			if (appMedInsBeforeColl != null && !appMedInsBeforeColl.isEmpty()) {
				// here we need to check data has been change or not
				appMedInsBeforeCargo = appMedInsBeforeColl.getCargo(0);
			} else {
				appMedInsCargo.setDirty(true);
			}
			appMedInsCargo = (APP_MED_INS_Cargo) isChanged(
					appMedInsBeforeCargo, appMedInsCargo);
			// PersistData if the cargo is dirty
			if (appMedInsCargo.isDirty()) {
				if (appMedInsCargo.getMaj_med_sw() == null) {
					appMedInsCargo.setMaj_med_sw(FwConstants.ZERO);
				}
				if (appMedInsCargo.getIns_plcy_num() == null) {
					appMedInsCargo.setIns_plcy_num(FwConstants.EMPTY_STRING);
				}
				if (appMedInsCargo.getMo_prem_amt() == null
						|| "-1".equals(appMedInsCargo.getMo_prem_amt())) {
					appMedInsCargo.setMo_prem_amt(FwConstants.ZERO);
				}

				if (appInMedInsColl != null) {
					final int appInMedInsCollSize = appInMedInsColl.size();
					for (int i = 0; i < appInMedInsCollSize; i++) {
						APP_IN_MED_INS_Cargo inMedInscargo = null;
						inMedInscargo = appInMedInsColl.getCargo(i);
						if (inMedInscargo.getApp_num() == null
								&& inMedInscargo.getDelete_reason_cd() == null
								&& (inMedInscargo.getCvrg_beg_dt() == null || AppConstants.HIGH_DATE
								.equals(inMedInscargo.getCvrg_beg_dt()))
								&& (inMedInscargo.getCvrg_end_dt() == null
								|| AppConstants.HIGH_DATE
								.equals(inMedInscargo
										.getCvrg_end_dt()) || FwConstants.EMPTY_STRING
										.equals(inMedInscargo
												.getCvrg_end_dt().trim()))
												&& inMedInscargo.getPast_cvrg_gdcs_cd() == null
												&& inMedInscargo.getPlcy_seq_num() == null) {
							appMedInsCargo.setRec_cplt_ind(FwConstants.ZERO);
						} else {
							appMedInsCargo.setRec_cplt_ind(FwConstants.ONE);
						}
					}
				}

				appMedInsColl.addCargo(appMedInsCargo);
				helthCareBO.storeHealthCareCoverage(appMedInsColl);

			}
			final String plcySeqNum = appMedInsColl.getCargo(0)
					.getPlcy_seq_num();

			final String indvSeqNum = appMedInsCargo.getPlcy_hold_seq_num();
			APP_IN_MED_INS_Cargo appInMedInsBeforeCargo = null;
			final APP_IN_MED_INS_Collection appInMedInsPersistColl = new APP_IN_MED_INS_Collection();
			if (appInMedInsBeforeColl != null) {
				final int appInMedInsBeforeCollSize = appInMedInsBeforeColl
						.size();
				for (int i = 0; i < appInMedInsBeforeCollSize; i++) {
					appInMedInsBeforeCargo = appInMedInsBeforeColl.getCargo(i);
					if (appInMedInsColl != null) {
						final int size = appInMedInsColl.size();
						for (int j = 0; j < size; j++) {
							appInMedInsCargo = appInMedInsColl.getCargo(j);
							appInMedInsCargo.setIndv_seq_num(appMedInsCargo
									.getPlcy_hold_seq_num());
						}
					}
					appInMedInsColl.addCargo(appInMedInsCargo);
					/*
					 * VG SONAR Cleanup - 09/1/2015 Deleted 2,2 lines Commented
					 * Code in this block
					 */

					if (appInMedInsCargo == null) {
						appInMedInsBeforeCargo
						.setRowAction(FwConstants.ROWACTION_DELETE);
						appInMedInsPersistColl.add(appInMedInsBeforeCargo);
					} else {
						if (appInMedInsCargo.getPast_cvrg_gdcs_cd() == null) {
							appInMedInsCargo
							.setPast_cvrg_gdcs_cd(AppConstants.EMPTY_STRING);
						}
						// now we need to check the dirty indicator
						helthCareBO.setPastInsuranceDefaultValues(
								appInMedInsCargo, appNumber, plcySeqNum);
						appInMedInsCargo = (APP_IN_MED_INS_Cargo) isChanged(
								appInMedInsBeforeCargo, appInMedInsCargo);
						if (appInMedInsCargo.isDirty()) {
							appInMedInsCargo.setIndv_seq_num(indvSeqNum);
							appInMedInsCargo
							.setRowAction(FwConstants.ROWACTION_UPDATE);

							appInMedInsCargo.setPast_cvrg_gdcs_cd(iref
									.getColumnValue("TPCR", 139,
											appInMedInsCargo
											.getPast_cvrg_gdcs_cd(),
											language));
							if (appInMedInsCargo.getPast_cvrg_gdcs_cd() == null) {
								appInMedInsCargo
								.setPast_cvrg_gdcs_cd(AppConstants.EMPTY_STRING);
							}
							appInMedInsPersistColl.add(appInMedInsCargo);
						}
					}
				}
			}

			if (appInMedInsColl != null) {
				final int appInMedInsCollSize = appInMedInsColl.size();
				for (int i = 0; i < appInMedInsCollSize; i++) {
					appInMedInsCargo = appInMedInsColl.getCargo(i);
					if (appInMedInsCargo.getApp_num() == null
							&& appInMedInsCargo.getDelete_reason_cd() == null
							&& (appInMedInsCargo.getCvrg_beg_dt() == null || AppConstants.HIGH_DATE
							.equals(appInMedInsCargo.getCvrg_beg_dt()))
							&& (appInMedInsCargo.getCvrg_end_dt() == null
							|| AppConstants.HIGH_DATE
							.equals(appInMedInsCargo
									.getCvrg_end_dt()) || FwConstants.EMPTY_STRING
									.equals(appInMedInsCargo
											.getCvrg_end_dt().trim()))
											&& appInMedInsCargo.getPast_cvrg_gdcs_cd() == null
											&& appInMedInsCargo.getPlcy_seq_num() == null) {
						break;
						/*
						 * VG SONAR Cleanup - 09/1/2015 Deleted 2,2 lines
						 * Commented Code in this block
						 */
					}

					if (appInMedInsBeforeCargo == null) {
						helthCareBO.setPastInsuranceDefaultValues(
								appInMedInsCargo, appNumber, plcySeqNum);
						if (appInMedInsCargo.getPast_cvrg_gdcs_cd() == null) {
							appInMedInsCargo
							.setPast_cvrg_gdcs_cd(AppConstants.EMPTY_STRING);
						}

						appInMedInsCargo
						.setPast_cvrg_gdcs_cd(iref.getColumnValue(
								"TPCR",
								139,
								appInMedInsCargo.getPast_cvrg_gdcs_cd(),
								language));

						if (appInMedInsCargo.getPast_cvrg_gdcs_cd() == null) {
							appInMedInsCargo
							.setPast_cvrg_gdcs_cd(AppConstants.EMPTY_STRING);
						}

						appInMedInsCargo.setIndv_seq_num(indvSeqNum);
						appInMedInsCargo
						.setRowAction(FwConstants.ROWACTION_INSERT);
						appInMedInsPersistColl.add(appInMedInsCargo);
					}
				}
			}
			/*
			 * VG SONAR Cleanup - 09/1/2015 Deleted 2 lines Commented Code in
			 * this block
			 */

			RMC_IN_PRFL_Cargo rmcInPrflSessCargo = null;
			// get the matching APP_IN_PRFL_Cargo

			if (appInMedInsCargo != null) {
				appInMedInsCargo.setIndv_seq_num(indvSeqNum);
			}
			rmcInPrflSessCargo = rmcResponseProfileManager
					.getProfile(sessionRmcInPrflColl,
							appMedInsCargo.getPlcy_hold_seq_num());
			if (rmcResponseProfileManager.getProfileResponse(
					rmcInPrflSessCargo,
					IRMCResponseProfileManager.PAST_HEALTHCARE_COVERAGE)
					.charAt(0) == IApplicationManager.STATUS_VISIT_AGAIN) {
				// Remove first Cargo from DetailCollection
				final APP_MED_INS_Collection appMedSessColl = (APP_MED_INS_Collection) session
						.get("APP_MED_INS_Collection");
				if (appMedSessColl != null) {
					appMedSessColl.remove(appMedInsBeforeCargo);
				}
				// Make "Complete" for Type
				rmcResponseProfileManager.makeComplete(
						IRMCResponseProfileManager.PAST_HEALTHCARE_COVERAGE,
						rmcInPrflSessCargo, true);
				// Make "AddNew" for Type
				rmcResponseProfileManager.makeAddNew(
						IRMCResponseProfileManager.PAST_HEALTHCARE_COVERAGE,
						rmcInPrflSessCargo, true);
				// Make driver for this page ADDNEW - if typeStatus is
				// VisitAgain
				driverManager.makeAddNew(FwConstants.RMC_DRIVER, currentPageID,
						driverArray,
						(String) session.get(AppConstants.APP_NUMBER));
			}

			if (driverStatus == FwConstants.DRIVER_REQUIRED
					|| driverStatus == FwConstants.DRIVER_ADD_NEW) {
				if (beforeColl.get(FwConstants.LAST_RECORD_INDEX) != null
						&& beforeColl.get(FwConstants.CURRENT_RECORD_INDEX) != null
						&& ((String) beforeColl
								.get(FwConstants.LAST_RECORD_INDEX))
								.equals(beforeColl
										.get(FwConstants.CURRENT_RECORD_INDEX))) {
					// Make "Complete" for Type and persist
					rmcResponseProfileManager
					.makeComplete(
							IRMCResponseProfileManager.PAST_HEALTHCARE_COVERAGE,
							rmcInPrflSessCargo, true);
				}
			// when page status is VisitAgain or Complete
			} else {
				// Remove first Cargo from DetailCollection
				final APP_MED_INS_Collection appMedSessColl = (APP_MED_INS_Collection) session
						.get("APP_MED_INS_Collection");
				if (appMedSessColl != null) {
					appMedSessColl.remove(appMedInsBeforeCargo);
				}
				if (driverStatus != FwConstants.DRIVER_COMPLETE) {
					// Make "Complete" for Type and persist

					rmcResponseProfileManager
					.makeComplete(
							IRMCResponseProfileManager.PAST_HEALTHCARE_COVERAGE,
							rmcInPrflSessCargo, true);
				}
			}

			// Define DetailsFinishedFlag as True
			boolean detailsFinishedFlag = true;
			RMC_IN_PRFL_Cargo rmcInPrflCargo = null;
			final int cargoSize = sessionRmcInPrflColl.size();
			// loop thru appInPrflColl_Session
			char typeStatus = ' ';

			for (int i = 0; i < cargoSize; i++) {
				rmcInPrflCargo = sessionRmcInPrflColl.getCargo(i);
				typeStatus = 'N';
				// check if any type is required, visitAgain and AddNew
				typeStatus = rmcResponseProfileManager.getProfileResponse(
						rmcInPrflCargo,
						IRMCResponseProfileManager.PAST_HEALTHCARE_COVERAGE)
						.charAt(0);
				if (typeStatus == IRMCResponseProfileManager.STATUS_REQUIRED
						|| typeStatus == IRMCResponseProfileManager.STATUS_ADD_NEW
						|| typeStatus == IRMCResponseProfileManager.STATUS_VISIT_AGAIN) {
					detailsFinishedFlag = false;
					break;
				}
			}
			if (detailsFinishedFlag) {
				// Make driver for this page "COMPLETE"
				driverManager.makeComplete(FwConstants.RMC_DRIVER,
						currentPageID, driverArray,
						(String) session.get(AppConstants.APP_NUMBER));

			}

			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
					driverArray, appNumber);

			// PCR# 43100 - schedule ARPER (Potential Eligiblity Page) if its a
			// CLA Renewals
			if (session.get(FwConstants.ACCESS_APPLICATION_TYPE).equals(
					String.valueOf(FwConstants.RMB_APP_TYPE))
					&& programKeyArray[7] == 1) {
				driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARPER",
						driverArray, appNumber);
			}

			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::storePastCoverageDetails:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("storePastCoverageDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"storePastCoverageDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.storePastCoverageDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * To Store APP_MED_INS_Collection to the Session PCR# 43100 - CLA RENEWALS
	 * CHANGES.
	 *
	 * @param txnBean the txn bean
	 * @param driverStatus the driver status
	 * @throws javax.ejb.EJBException the javax.ejb. ejb exception
	 */

	private void setPastCoverageCollectionToSession(
			final FwTransaction txnBean, final int driverStatus) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.setPastCoverageCollectionToSession() - START");

		final Map session = txnBean.getSession();
		final Map pageCollection = txnBean.getPageCollection();
		try {
			APP_MED_INS_Collection medicalColl = new APP_MED_INS_Collection();
			final HealthCareCoverageBO heathCareBO = new HealthCareCoverageBO();
			if (pageCollection.get("APP_MED_INS_Collection") != null) {
				medicalColl = heathCareBO
						.loadPastHealthCareCoverage((String) session
								.get(AppConstants.APP_NUMBER));
				/*
				 * VG SONAR Cleanup - 09/1/2015 Deleted 2 lines Commented Code
				 * in this block
				 */

				// put the APP_MED_INS_Coll in session
				session.put("APP_MED_INS_Collection", medicalColl);
			} else {
				final RMC_IN_PRFL_Collection rmcInPrflCollSession = (RMC_IN_PRFL_Collection) session
						.get(AppConstants.RMC_IN_PRFL_MASTER);
				// Read Database :: and populate the Individuals who has
				// HealthCare response as "P"
				final APP_MED_INS_Collection appMedColl = heathCareBO
						.loadPastHealthCareCoverage((String) session
								.get(AppConstants.APP_NUMBER));

				if (appMedColl != null) {
					final int sessAppPrflCollSize = rmcInPrflCollSession.size();
					final int emplCollSize = appMedColl.size();
					String indvPrflSeqNum = null;

					for (int i = 0; i < sessAppPrflCollSize; i++) {
						indvPrflSeqNum = rmcInPrflCollSession.getCargo(i)
								.getIndv_seq_num();
						String indvSeqNum = null;
						for (int j = 0; j < emplCollSize; j++) {
							indvSeqNum = appMedColl.getCargo(j)
									.getPlcy_hold_seq_num();
							if (indvSeqNum.equals(indvPrflSeqNum)) {
								medicalColl.addCargo(appMedColl.getCargo(j));
							}

						}
					}

				}

				// create IndivSeqTypeBean for each cargo and populate Record
				// Array
				IndivTypeSeqBean indvTypeSeqBean = null;
				APP_MED_INS_Cargo medCargo = null;
				APP_MED_INS_Collection appMedInsColl = null;
				RMC_IN_PRFL_Cargo rmcInPrflSessCargo = null;
				final int size = medicalColl.size();
				char status = 'N';
				String policyHolderSeqNum = null;
				for (int k = 0; k < size; k++) {
					medCargo = medicalColl.getCargo(k);
					policyHolderSeqNum = medCargo.getPlcy_hold_seq_num();
					rmcInPrflSessCargo = rmcResponseProfileManager.getProfile(
							rmcInPrflCollSession, policyHolderSeqNum);
					status = rmcResponseProfileManager
							.getProfileResponse(
									rmcInPrflSessCargo,
									IRMCResponseProfileManager.PAST_HEALTHCARE_COVERAGE)
									.charAt(0);

					if (driverStatus == FwConstants.DRIVER_VISIT_AGAIN) {
						// if driverStatus is VisitAgain or Complete, filter
						// those types which are complete
						if (status != IRMCResponseProfileManager.STATUS_COMPLETE) {
							if (appMedInsColl == null) {
								appMedInsColl = new APP_MED_INS_Collection();
							}
							appMedInsColl.add(medCargo);
						}
					}
					indvTypeSeqBean = new IndivTypeSeqBean(policyHolderSeqNum,
							FwConstants.SPACE, medCargo.getPlcy_seq_num());
					populateRecordArray(indvTypeSeqBean, session);
				}
				if (driverStatus == FwConstants.DRIVER_VISIT_AGAIN) {
					if (appMedInsColl != null && !appMedInsColl.isEmpty()) {
						// put the new APP_MED_INS_Collection in session
						session.put("APP_MED_INS_Collection", appMedInsColl);
					}
				} else if (null!=medicalColl && !medicalColl.isEmpty()) {
					// put the APP_MED_INS_Coll in session
					session.put("APP_MED_INS_Collection", medicalColl);
				}
			}

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("setPastCoverageCollectionToSession");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"setPastCoverageCollectionToSession", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.setPastCoverageCollectionToSession() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Populate the Past Coverage Indivduals when the status is visit Again.
	 *
	 * @param session the session
	 * @param pageCollection the page collection
	 * @param driverStatus the driver status
	 * @param indvSeqNum the indv seq num
	 * @throws javax.ejb.EJBException the javax.ejb. ejb exception
	 */
	private void setPastCoverageDetailsCargoFromSession(final Map session,
			final Map pageCollection, final int driverStatus,
			final String indvSeqNum) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.setPastCoverageDetailsCargoFromSession() - START");

		try {
			final PeopleHandler peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);
			// get the session APP_MED_INS_Coll
			final APP_MED_INS_Collection appMedSessColl = (APP_MED_INS_Collection) session
					.get("APP_MED_INS_Collection");
			APP_MED_INS_Cargo appMedSessCargo = null;
			final int appInMedSessCollSize = appMedSessColl.size();
			for (int i = 0; i < appInMedSessCollSize; i++) {
				if (appMedSessColl.getCargo(i).getPlcy_hold_seq_num()
						.equals(indvSeqNum)) {
					appMedSessCargo = appMedSessColl.getCargo(i);
					break;
				}
			}

			final APP_MED_INS_Collection appMedNewColl = new APP_MED_INS_Collection();
			appMedNewColl.addCargo(appMedSessCargo);
			if(appMedSessCargo != null){
				if (driverStatus == FwConstants.DRIVER_VISIT_AGAIN) {
					// set the current record index for the record array
					setCurrentRecord(
							new IndivTypeSeqBean(
									appMedSessCargo.getPlcy_hold_seq_num(),
									appMedSessCargo.getPlcy_seq_num(),
									appMedSessCargo.getPlcy_seq_num()), session);
				}
				// set Details_Collection from session to PageCollection
				pageCollection.put("APP_MED_INS_Collection", appMedNewColl);
				// set frist Name to PageCollection
				pageCollection.put(AppConstants.FIRST_NAME, peopleHandler
						.getFirstName(appMedSessCargo.getPlcy_hold_seq_num()));
			}			
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("setPastCoverageDetailsCargoFromSession");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"setPastCoverageDetailsCargoFromSession", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.setPastCoverageDetailsCargoFromSession() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * To Populate individuals when they are first visting the page.
	 *
	 * @param indvSeqNum the indv seq num
	 * @param session the session
	 * @param pageCollection the page collection
	 * @throws javax.ejb.EJBException the javax.ejb. ejb exception
	 */
	private void setPastCoverageDetailsCargo(final String indvSeqNum,
			final Map session, final Map pageCollection) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.setPastCoverageDetailsCargo() - START");

		try {
			final PeopleHandler peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);
			final APP_MED_INS_Cargo cargo = new APP_MED_INS_Cargo();
			// set indvSeqNum and type to new Cargo
			cargo.setPlcy_hold_seq_num(indvSeqNum);
			// create IndivSeqTypeBean for the cargo and populate Record Array
			final IndivTypeSeqBean indvTSBean = new IndivTypeSeqBean(
					indvSeqNum, FwConstants.SPACE, cargo.getSeq_num());
			populateRecordArray(indvTSBean, session);
			// set cargo into Collection
			final APP_MED_INS_Collection appMedInsColl = new APP_MED_INS_Collection();
			appMedInsColl.addCargo(cargo);
			// set Details_Collection to PageCollection
			pageCollection.put("APP_MED_INS_Collection", appMedInsColl);
			// put FirstName in PageCollection
			pageCollection.put(AppConstants.FIRST_NAME,
					peopleHandler.getFirstName(indvSeqNum));

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("setPastCoverageDetailsCargo");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"setPastCoverageDetailsCargo", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.setPastCoverageDetailsCargo() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * EDIT Past Health Insurance Details.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 * @throws javax.ejb.EJBException the javax.ejb. ejb exception
	 */

	public void editPastCoverageDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.editPastCoverageDetails() - START");

		try {
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::editPastCoverageDetails:Start");
			final Map session = txnBean.getSession();
			final Map pageCollection = txnBean.getPageCollection();

			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			// Get the APP_IN_EMPL_Collection from pageCollection.
			final CP_APP_IN_LST_HLTH_INS_Collection pastHlthInsuColl = (CP_APP_IN_LST_HLTH_INS_Collection) pageCollection
					.get("CP_APP_IN_LST_HLTH_INS_Collection");
			final CP_APP_IN_LST_HLTH_INS_Cargo pastHlthInsuCargo = pastHlthInsuColl
					.getCargo(0);

			final IndivTypeSeqBean seqBean = new IndivTypeSeqBean();
			seqBean.setIndivSeqNum(pastHlthInsuCargo.getIndv_seq_num());
			seqBean.setType(pastHlthInsuCargo.getSrc_app_ind());
			seqBean.setSeqNum(pastHlthInsuCargo.getSeq_num());
			// setting user end indicator

			pageCollection.put(FwConstants.DETAIL_KEY_BEAN, seqBean);

			// Get App Number
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			// Set RMC page Job Income Details make required
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARLHI",
					driverArray, appNum);
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
					driverArray, appNum);
			// End
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::editPastCoverageDetails:End");

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("editPastCoverageDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"editPastCoverageDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.editPastCoverageDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * ERASE Past Health Insurance Details.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 * @throws javax.ejb.EJBException the javax.ejb. ejb exception
	 */
	public void erasePastCoverageDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.erasePastCoverageDetails() - START");

		try {
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::erasePastCoverageDetails:Start");

			// get variables from session and page collection
			final Map session = txnBean.getSession();
			final Map pageCollection = txnBean.getPageCollection();
			final Map request = txnBean.getRequest();
			request.get(FwConstants.CURRENT_PAGE_ID);

			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);


			// Get appNumber from the session
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);

			// Get beforeMap
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);

			session.get(AppConstants.RMC_IN_PRFL_MASTER);

			beforeColl.get("CP_APP_IN_LST_HLTH_INS_Collection");

			// Define IndvSeqNum and the SeqNum and Type and RowNum
			String indvSeqNum = null;
			String seqNum = null;
			String srcAppInd = null;
			final String type = null;

			// Get the pageCollection CP_APP_IN_LST_HLTH_INS_Collection
			final CP_APP_IN_LST_HLTH_INS_Collection pastHlthInsurColl = (CP_APP_IN_LST_HLTH_INS_Collection) pageCollection
					.get("CP_APP_IN_LST_HLTH_INS_Collection");

			beforeColl.get("CP_APP_IN_LST_HLTH_INS_Collection");

			// Get the results from pastHealthcoverageColl
			srcAppInd = pastHlthInsurColl.getCargo(0).getSrc_app_ind();
			indvSeqNum = pastHlthInsurColl.getCargo(0).getIndv_seq_num();
			seqNum = pastHlthInsurColl.getCargo(0).getSeq_num();
			// Setting IndivSeqTypeBean
			final IndivTypeSeqBean indivTypeSeqBean = new IndivTypeSeqBean();
			indivTypeSeqBean.setIndivSeqNum(indvSeqNum);
			indivTypeSeqBean.setSeqNum(seqNum);
			indivTypeSeqBean.setType(type);
			// This code is added to display persons name for the erase message
			// in th summary page
			final PeopleHandler peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);
			if (FwConstants.ZERO.equals(indvSeqNum)) {
				final CP_APP_IN_LST_HLTH_INS_Collection medBeforeColl = (CP_APP_IN_LST_HLTH_INS_Collection) beforeColl
						.get("CP_APP_IN_LST_HLTH_INS_Collection");
				getpastHealthIns(medBeforeColl, indvSeqNum, seqNum);
			} else {
				peopleHandler.getFirstName(indvSeqNum);
			}
			CP_APP_IN_LST_HLTH_INS_Cargo beforeHlthCargo = (CP_APP_IN_LST_HLTH_INS_Cargo) beforeColl
					.get("CP_APP_IN_LST_HLTH_INS_Cargo");
			final CP_APP_IN_LST_HLTH_INS_Cargo hlthCargo = pastHlthInsurColl
					.getCargo(0);
			final HealthCareCoverageBO hlthBO = new HealthCareCoverageBO();

			if (beforeHlthCargo == null
					|| hlthBO.isDifferentPastHlth(hlthCargo, beforeHlthCargo)) {

				hlthBO.validateErase();
				request.put(FwConstants.MESSAGE_LIST, hlthBO.getMessageList());
				beforeHlthCargo = new CP_APP_IN_LST_HLTH_INS_Cargo();
				beforeHlthCargo.setIndv_seq_num(indvSeqNum);
				beforeHlthCargo.setSrc_app_ind(srcAppInd);
				beforeHlthCargo.setSeq_num(seqNum);
				beforeColl.put("CP_APP_IN_LST_HLTH_INS_Cargo", beforeHlthCargo);
				txnBean.setPageCollection(beforeColl);
				return;

			}

			hlthBO.deletePastHlthInsuRecords(indvSeqNum, appNum, seqNum);

			final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			final short[] responseArray = new short[] { IRMCResponseProfileManager.LOST_HEALTH_INS_IND };
			final SortedSet rmcSelPrfl = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);

			if (beforeColl != null) {
				int count = 0;
				CP_APP_IN_LST_HLTH_INS_Collection rb1Coll = null;
				CP_APP_IN_LST_HLTH_INS_Cargo rb1Cargo = null;
				rb1Coll = (CP_APP_IN_LST_HLTH_INS_Collection) beforeColl
						.get("CP_APP_IN_LST_HLTH_INS_Collection");

				if (rb1Coll != null && !rb1Coll.isEmpty()) {
					final int rbCollSize = rb1Coll.size();
					for (int i = 0; i < rbCollSize; i++) {
						rb1Cargo = rb1Coll.getCargo(i);
						if (rb1Cargo.getIndv_seq_num().equals(indvSeqNum)
								&& AppConstants.RMC_NEW_RECORD_IND
								.equals(rb1Cargo.getSrc_app_ind())) {
							count++;
						}
					}
				}
				if (count == 1) {
					// now we need to make that profile requirred
					final RMC_IN_PRFL_Cargo rmcResCargo = rmcResponseProfileManager
							.getProfile(rmcInPrflColl, indvSeqNum);
					rmcResponseProfileManager.makeAbsoluteNotRequired(
							responseArray, rmcResCargo, true);
				}
			}

			boolean rmcPrflSchEnrlNotRequired = false;
			if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl,
						IRMCResponseProfileManager.LOST_HEALTH_INS_IND)) {
					rmcPrflSchEnrlNotRequired = true;
				}

			} else {
				rmcPrflSchEnrlNotRequired = true;

			}
			final Map hlthcvrg = new HashMap();
			hlthcvrg.put("LH", "LH");
			if (!checkBenefitDetailPageRequired(rmcSelPrfl, hlthcvrg)
					&& rmcPrflSchEnrlNotRequired) {
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"ARLHI", driverArray, appNum);
			}
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
					driverArray, appNum);
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::erasePastCoverageDetails:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("erasePastCoverageDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"erasePastCoverageDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.erasePastCoverageDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * ADD Past Health Insurance Details.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 * @throws javax.ejb.EJBException the javax.ejb. ejb exception
	 */

	public void addPastCoverageDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.addPastCoverageDetails() - START");

		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			// get cargo determining user selection
			request.put("firstName_medIns", null);
			request.put("firstName_MAPP", null);
			final String schSeq = request.get("firstName_LH") != null ? (String) request
					.get("firstName_LH") : FwConstants.EMPTY_STRING;

					final HealthCareCoverageBO hlthCareBO = new HealthCareCoverageBO();// Write
					// the
					// validator
					// validate selections

					if (schSeq == null
							|| AppConstants.SELECT_DEFAULT_OPTION.equals(schSeq)) {
						hlthCareBO.validateAdd();
						// add validation message and return
						request.put(FwConstants.MESSAGE_LIST,
								hlthCareBO.getMessageList());
						txnBean.setPageCollection((Map) session
								.get(FwConstants.BEFORE_COLLECTION));
						return;
					}
					final String appNum = (String) session.get(AppConstants.APP_NUMBER);
					final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
					indivSeqBean.setIndivSeqNum(schSeq);
					indivSeqBean.setSeqNum(FwConstants.ZERO);
					indivSeqBean.setType(AppConstants.LOST_HEALTH_INS);
					indivSeqBean.setUserEndInd(FwConstants.ZERO);
					pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

					final String appType = (String) session
							.get(FwConstants.ACCESS_APPLICATION_TYPE);

					if (appType.equalsIgnoreCase(String
							.valueOf(FwConstants.RMB_APP_TYPE))) {
						final RMB_RQST_Collection rmbColl = (RMB_RQST_Collection) session
								.get(AppConstants.RMB_RQST_COLLECTION);

						// Get RMB_RQST_Cargo for appNum
						if(null!=rmbColl){
							final RMB_RQST_Cargo rmbRqstCargo = rmbColl.getCargo(0);
							if (rmbRqstCargo.getPast_cvrg_stat_ind() != null
									&& !FwConstants.YES.equals(rmbRqstCargo
											.getPast_cvrg_stat_ind())) {
								rmbRqstCargo.setPast_cvrg_stat_ind(FwConstants.YES);
								rmbRqstCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
								rmbColl.addCargo(rmbRqstCargo);
								rmbColl.persist(FwConstants.DAO);
							}
						}
						
						// add to session
						session.put(AppConstants.RMB_RQST_COLLECTION, rmbColl);
					}
					// set driver status
					final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARLHI", driver,
							appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driver,
							appNum);
					session.put(FwConstants.RMC_DRIVER, driver);

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("addPastCoverageDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"addPastCoverageDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.addPastCoverageDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Edits the nh details.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	/* Nursing Home Methods starts here */
	public void editNHDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.editNHDetails() - START");

		try {
			log(ILog.INFO, "RMCHousingExpenseEJBBean::editNHDetails:Start");
			final Map session = txnBean.getSession();
			final Map pageCollection = txnBean.getPageCollection();

			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			// Get the APP_IN_EMPL_Collection from pageCollection.
			final CP_APP_IN_CARE_PROV_Collection schColl = (CP_APP_IN_CARE_PROV_Collection) pageCollection
					.get("CP_APP_IN_CARE_PROV_Collection");
			final CP_APP_IN_CARE_PROV_Cargo schCargo = schColl.getResult(0);

			final IndivTypeSeqBean seqBean = new IndivTypeSeqBean();
			seqBean.setIndivSeqNum(schCargo.getIndv_seq_num());
			seqBean.setSeqNum(schCargo.getSeq_num());
			seqBean.setType(schCargo.getSrc_app_ind());
			// setting user end indicator
			if(AppConstants.RMC_END_RECORD_IND.equals(schCargo.getSrc_app_ind())){
				seqBean.setUserEndInd(FwConstants.ONE);
			}else {
				seqBean.setUserEndInd(FwConstants.ZERO);
			}

			pageCollection.put(FwConstants.DETAIL_KEY_BEAN, seqBean);
			// Get App Number
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			// Set RMC page Nursing Home Details make required
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARNUR",
					driverArray, appNum);
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
					driverArray, appNum);
			// End
			log(ILog.INFO, "RMCHousingExpenseEJBBean::editNHDetails:End");

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("editNHDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"editNHDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.editNHDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Erase nh details.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void eraseNHDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.eraseNHDetails() - START");

		try {
			log(ILog.INFO, "RMCHousingExpenseEJBBean::eraseNHDetails:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);

			// Get RMCSessionBean from the session

			// Define IndvSeqNum and the SeqNum and Type and RowNum
			String indvSeqNum = null;
			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);

			// Get the APP_IN_SHLTC_Collection from pageCollection.
			final CP_APP_IN_CARE_PROV_Collection schColl = (CP_APP_IN_CARE_PROV_Collection) pageCollection
					.get("CP_APP_IN_CARE_PROV_Collection");
			final CP_APP_IN_CARE_PROV_Cargo schCargo = schColl.getResult(0);

			// Get the results from the APP_IN_EMPL_Collection
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);

			// delete record from rmc selection profile
			final SortedSet rmcSelPrfl = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);

			indvSeqNum = schCargo.getIndv_seq_num();
			CP_APP_IN_CARE_PROV_Cargo beforeschCargo = (CP_APP_IN_CARE_PROV_Cargo) beforeColl
					.get("CP_APP_IN_CARE_PROV_Cargo");
			final ABHouseHoldMemberBO aBHouseHoldMemberBO = new ABHouseHoldMemberBO();

			if (beforeschCargo == null
					|| aBHouseHoldMemberBO.isDifferentNH(schCargo,
							beforeschCargo)) {

				aBHouseHoldMemberBO.validateErase();
				request.put(FwConstants.MESSAGE_LIST,
						aBHouseHoldMemberBO.getMessageList());
				beforeschCargo = new CP_APP_IN_CARE_PROV_Cargo();
				beforeschCargo.setIndv_seq_num(indvSeqNum);
				/*
				 * VG SONAR Cleanup - 09/1/2015 Deleted 1,1 lines Commented Code
				 * in this block
				 */

				beforeColl.put("CP_APP_IN_CARE_PROV_Cargo", beforeschCargo);
				txnBean.setPageCollection(beforeColl);
				return;

			}

			aBHouseHoldMemberBO.deleteSERecordsForNursingHome(indvSeqNum, appNum);
			final short[] responseArray = new short[] { IRMCResponseProfileManager.MED_TYPE_NURSING_RESP };

			if (beforeColl != null) {
				int count = 0;
				CP_APP_IN_CARE_PROV_Collection rb1Coll = null;
				CP_APP_IN_CARE_PROV_Cargo rb1Cargo = null;
				rb1Coll = (CP_APP_IN_CARE_PROV_Collection) beforeColl
						.get("CP_APP_IN_CARE_PROV_Collection");

				if (rb1Coll != null && !rb1Coll.isEmpty()) {
					final int rbCollSize = rb1Coll.size();
					for (int i = 0; i < rbCollSize; i++) {
						rb1Cargo = rb1Coll.getCargo(i);
						if (rb1Cargo.getIndv_seq_num().equals(indvSeqNum)
								&& AppConstants.RMC_NEW_RECORD_IND
								.equals(rb1Cargo.getSrc_app_ind())) {
							count++;
						}
					}
				}
				if (count == 1) {
					// now we need to make that profile requirred
					final RMC_IN_PRFL_Cargo rmcResCargo = rmcResponseProfileManager
							.getProfile(rmcInPrflColl, indvSeqNum);
					rmcResponseProfileManager.makeAbsoluteNotRequired(
							responseArray, rmcResCargo, true);

				}
			}

			boolean rmcPrflNurHomeNotRequired = false;

			// here we need to check we have no entrys in rmcPrfl for the job
			// income detail
			// as well as we need to check
			if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl,
						IRMCResponseProfileManager.MED_TYPE_NURSING_RESP)) {
					rmcPrflNurHomeNotRequired = true;
				}

			} else {
				rmcPrflNurHomeNotRequired = true;

			}
			final Map nurHome = new HashMap();
			nurHome.put("NH", "NH");
			if (!checkBenefitDetailPageRequired(rmcSelPrfl, nurHome)
					&& rmcPrflNurHomeNotRequired) {
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"ARNUR", driverArray, appNum);
			}
			
			CP_APP_IN_CARE_PROV_Collection aColl = aBHouseHoldMemberBO.loadNurDetails(appNum);
			boolean changeExists = false;
			
			for(int i=0; i<aColl.size(); i++){
				if(!aColl.getCargo(i).getSrc_app_ind().equals(AppConstants.CWW_RECORD_IND)){
					changeExists = true;
					break;
				}
			}
			if(!changeExists){
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"ARNUR", driverArray, appNum);
			}

			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
					driverArray, appNum);
			log(ILog.INFO, "RMCHousingExpenseEJBBean::eraseNHDetails:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("eraseNHDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"eraseNHDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.eraseNHDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Erase nh changes.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void eraseNHChanges(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.eraseNHChanges() - START");

		try {
			log(ILog.INFO, "RMCHousingExpenseEJBBean::eraseNHChanges:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);

			// Get RMCSessionBean from the session
			// Define IndvSeqNum and the SeqNum and Type and RowNum
			String indvSeqNum = null;
			String seqNum = null;
			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);

			// Get the APP_IN_SHLTC_Collection from pageCollection.
			final CP_APP_IN_CARE_PROV_Collection schColl = (CP_APP_IN_CARE_PROV_Collection) pageCollection
					.get("CP_APP_IN_CARE_PROV_Collection");
			final CP_APP_IN_CARE_PROV_Cargo schCargo = schColl.getResult(0);

			// Get the results from the APP_IN_EMPL_Collection
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			indvSeqNum = schCargo.getIndv_seq_num();
			seqNum = FwConstants.ZERO;

			CP_APP_IN_CARE_PROV_Cargo beforeSchCargo = (CP_APP_IN_CARE_PROV_Cargo) beforeColl
					.get("CP_APP_IN_CARE_PROV_Cargo");

			final ABHouseHoldMemberBO aBHouseHoldMemberBO = new ABHouseHoldMemberBO();
			if (beforeSchCargo == null
					|| aBHouseHoldMemberBO.isDifferentNH(schCargo,
							beforeSchCargo)) {
				aBHouseHoldMemberBO.validateEraseChanges();
				request.put(FwConstants.MESSAGE_LIST,
						aBHouseHoldMemberBO.getMessageList());
				beforeSchCargo = new CP_APP_IN_CARE_PROV_Cargo();
				beforeSchCargo.setIndv_seq_num(indvSeqNum);
				beforeColl.put("CP_APP_IN_CARE_PROV_Cargo", beforeSchCargo);
				txnBean.setPageCollection(beforeColl);
				return;
			}

			// delete record from database
			aBHouseHoldMemberBO.deleteSERecordsForNursingHome(indvSeqNum, appNum);

			final String catUtilType = AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL;

			// delete record from rmc selection profile
			final SortedSet rmcSelPrfl = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			categorySelectionProfileManager.removeSequenceDetail(rmcSelPrfl,
					appNum, Short.parseShort(indvSeqNum),
					Short.parseShort(seqNum), catUtilType,
					AppConstants.NURSING_INFORMATION);

			final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			boolean rmcPrflNotRequeired = false;

			if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl,
						IRMCResponseProfileManager.MED_TYPE_NURSING_RESP)) {
					rmcPrflNotRequeired = true;
				}
			} else {
				rmcPrflNotRequeired = true;
			}
			final Map nurHome = new HashMap();
			nurHome.put("NH", "NH");
			if (categorySelectionProfileManager.isRemoved(rmcSelPrfl, nurHome)
					&& rmcPrflNotRequeired) {
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"ARNUR", driverArray, appNum);
			}

			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
					driverArray, appNum);
			// End
			log(ILog.INFO, "RMCHousingExpenseEJBBean::eraseNHChanges:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("eraseNHChanges");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"eraseNHChanges", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.eraseNHChanges() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Adds the nur home details.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void addNurHomeDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.addNurHomeDetails() - START");

		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			// get cargo determining user selection
			request.put("firstName_medIns", null);
			request.put("firstName_MAPP", null);
			request.put("firstName_SE", null);
			final String schSeq = request.get("firstName_NH") != null ? (String) request
					.get("firstName_NH") : FwConstants.EMPTY_STRING;

					final SchoolEnrollmentBO schBO = new SchoolEnrollmentBO();// Write
					// the
					// validator
					// validate selections

					if (schSeq == null
							|| AppConstants.SELECT_DEFAULT_OPTION.equals(schSeq)) {
						schBO.validateAdd();
						// add validation message and return
						request.put(FwConstants.MESSAGE_LIST, schBO.getMessageList());
						txnBean.setPageCollection((Map) session
								.get(FwConstants.BEFORE_COLLECTION));
						return;
					}
					final String appNum = (String) session.get(AppConstants.APP_NUMBER);
					final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
					indivSeqBean.setIndivSeqNum(schSeq);
					indivSeqBean.setSeqNum(FwConstants.ZERO);
					indivSeqBean.setType("NH");
					indivSeqBean.setUserEndInd(FwConstants.ZERO);
					pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

					// set driver status
					final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARNUR", driver,
							appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driver,
							appNum);
					session.put(FwConstants.RMC_DRIVER, driver);

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("addNurHomeDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"addNurHomeDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.addSchlEnrlDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/* Nursing Home Methods ends here */

	/**
	 * Edits the hp details.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	/* Hospice Methods starts here */
	public void editHPDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.editHPDetails() - START");

		try {
			log(ILog.INFO, "RMCHousingExpenseEJBBean::editNHDetails:Start");
			final Map session = txnBean.getSession();
			final Map pageCollection = txnBean.getPageCollection();

			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			// Get the APP_IN_EMPL_Collection from pageCollection.
			final CP_APP_IN_CARE_PROV_Collection schColl = (CP_APP_IN_CARE_PROV_Collection) pageCollection
					.get("CP_APP_IN_CARE_PROV_Collection");
			final CP_APP_IN_CARE_PROV_Cargo schCargo = schColl.getResult(0);

			final IndivTypeSeqBean seqBean = new IndivTypeSeqBean();
			seqBean.setIndivSeqNum(schCargo.getIndv_seq_num());
			seqBean.setSeqNum(schCargo.getSeq_num());
			seqBean.setType(schCargo.getSrc_app_ind());
			if(AppConstants.RMC_END_RECORD_IND.equals(schCargo.getSrc_app_ind())){
				seqBean.setUserEndInd(FwConstants.ONE);
			}else {
				seqBean.setUserEndInd(FwConstants.ZERO);
			}
			
			
			// setting user end indicator

			pageCollection.put(FwConstants.DETAIL_KEY_BEAN, seqBean);
			// Get App Number
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			// Set RMC page Nursing Home Details make required
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARHOS",
					driverArray, appNum);
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
					driverArray, appNum);
			// End
			log(ILog.INFO, "RMCHousingExpenseEJBBean::editHPDetails");

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("editHPDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"editHPDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.editSEDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Erase hp details.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void eraseHPDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.eraseHPDetails() - START");

		try {
			log(ILog.INFO, "RMCHousingExpenseEJBBean::eraseHPDetails:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);

			// Get RMCSessionBean from the session

			// Define IndvSeqNum and the SeqNum and Type and RowNum
			String indvSeqNum = null;
			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);

			// Get the APP_IN_SHLTC_Collection from pageCollection.
			final CP_APP_IN_CARE_PROV_Collection schColl = (CP_APP_IN_CARE_PROV_Collection) pageCollection
					.get("CP_APP_IN_CARE_PROV_Collection");
			final CP_APP_IN_CARE_PROV_Cargo schCargo = schColl.getResult(0);

			// Get the results from the APP_IN_EMPL_Collection
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);

			// delete record from rmc selection profile
			final SortedSet rmcSelPrfl = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);

			indvSeqNum = schCargo.getIndv_seq_num();
			CP_APP_IN_CARE_PROV_Cargo beforeschCargo = (CP_APP_IN_CARE_PROV_Cargo) beforeColl
					.get("CP_APP_IN_CARE_PROV_Cargo");
			final ABHouseHoldMemberBO aBHouseHoldMemberBO = new ABHouseHoldMemberBO();

			if (beforeschCargo == null
					|| aBHouseHoldMemberBO.isDifferentNH(schCargo,
							beforeschCargo)) {

				aBHouseHoldMemberBO.validateErase();
				request.put(FwConstants.MESSAGE_LIST,
						aBHouseHoldMemberBO.getMessageList());
				beforeschCargo = new CP_APP_IN_CARE_PROV_Cargo();
				beforeschCargo.setIndv_seq_num(indvSeqNum);
				/*
				 * VG SONAR Cleanup - 09/1/2015 Deleted 1,1 lines Commented Code
				 * in this block
				 */

				beforeColl.put("CP_APP_IN_CARE_PROV_Cargo", beforeschCargo);
				txnBean.setPageCollection(beforeColl);
				return;

			}

			aBHouseHoldMemberBO.deleteSERecordsForHP(indvSeqNum, appNum);
			final short[] responseArray = new short[] { IRMCResponseProfileManager.HOUS_PICE };

			if (beforeColl != null) {
				int count = 0;
				CP_APP_IN_CARE_PROV_Collection rb1Coll = null;
				CP_APP_IN_CARE_PROV_Cargo rb1Cargo = null;
				rb1Coll = (CP_APP_IN_CARE_PROV_Collection) beforeColl
						.get("CP_APP_IN_CARE_PROV_Collection");

				if (rb1Coll != null && !rb1Coll.isEmpty()) {
					final int rbCollSize = rb1Coll.size();
					for (int i = 0; i < rbCollSize; i++) {
						rb1Cargo = rb1Coll.getCargo(i);
						if (rb1Cargo.getIndv_seq_num().equals(indvSeqNum)
								&& AppConstants.RMC_NEW_RECORD_IND
								.equals(rb1Cargo.getSrc_app_ind())) {
							count++;
						}
					}
				}
				if (count == 1) {
					// now we need to make that profile requirred
					final RMC_IN_PRFL_Cargo rmcResCargo = rmcResponseProfileManager
							.getProfile(rmcInPrflColl, indvSeqNum);
					rmcResponseProfileManager.makeAbsoluteNotRequired(
							responseArray, rmcResCargo, true);

				}
			}

			boolean rmcPrflNurHomeNotRequired = false;

			// here we need to check we have no entrys in rmcPrfl for the job
			// income detail
			// as well as we need to check
			if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl, IRMCResponseProfileManager.HOUS_PICE)) {
					rmcPrflNurHomeNotRequired = true;
				}

			} else {
				rmcPrflNurHomeNotRequired = true;

			}
			final Map nurHome = new HashMap();
			nurHome.put("HP", "HP");
			if (!checkBenefitDetailPageRequired(rmcSelPrfl, nurHome)
					&& rmcPrflNurHomeNotRequired) {
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"ARHOS", driverArray, appNum);
			}
			CP_APP_IN_CARE_PROV_Collection aColl = aBHouseHoldMemberBO.loadHospDetails(appNum);
			boolean changeExists = false;
			
			for(int i=0; i<aColl.size(); i++){
				if(!aColl.getCargo(i).getSrc_app_ind().equals(AppConstants.CWW_RECORD_IND)){
					changeExists = true;
					break;
				}
			}
			if(!changeExists){
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"ARHOS", driverArray, appNum);
			}

			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
					driverArray, appNum);
			log(ILog.INFO, "RMCHousingExpenseEJBBean::eraseHPDetails:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("eraseHPDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"eraseHPDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.eraseHPDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Erase hp changes.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void eraseHPChanges(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.eraseHPChanges() - START");

		try {
			log(ILog.INFO, "RMCHousingExpenseEJBBean::eraseHPChanges:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);

			// Get RMCSessionBean from the session
			// Define IndvSeqNum and the SeqNum and Type and RowNum
			String indvSeqNum = null;
			String seqNum = null;
			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);

			// Get the APP_IN_SHLTC_Collection from pageCollection.
			final CP_APP_IN_CARE_PROV_Collection schColl = (CP_APP_IN_CARE_PROV_Collection) pageCollection
					.get("CP_APP_IN_CARE_PROV_Collection");
			final CP_APP_IN_CARE_PROV_Cargo schCargo = schColl.getResult(0);

			// Get the results from the APP_IN_EMPL_Collection
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			indvSeqNum = schCargo.getIndv_seq_num();
			seqNum = schCargo.getSeq_num();

			CP_APP_IN_CARE_PROV_Cargo beforeSchCargo = (CP_APP_IN_CARE_PROV_Cargo) beforeColl
					.get("CP_APP_IN_CARE_PROV_Cargo");

			final ABHouseHoldMemberBO aBHouseHoldMemberBO = new ABHouseHoldMemberBO();
			if (beforeSchCargo == null
					|| aBHouseHoldMemberBO.isDifferentNH(schCargo,
							beforeSchCargo)) {
				aBHouseHoldMemberBO.validateEraseChanges();
				request.put(FwConstants.MESSAGE_LIST,
						aBHouseHoldMemberBO.getMessageList());
				beforeSchCargo = new CP_APP_IN_CARE_PROV_Cargo();
				beforeSchCargo.setIndv_seq_num(indvSeqNum);
				beforeColl.put("CP_APP_IN_CARE_PROV_Cargo", beforeSchCargo);
				txnBean.setPageCollection(beforeColl);
				return;
			}

			// delete record from database
			aBHouseHoldMemberBO.deleteSERecordsForNH(indvSeqNum, appNum);

			final String catUtilType = AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL;

			// delete record from rmc selection profile
			final SortedSet rmcSelPrfl = (SortedSet) session.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			categorySelectionProfileManager.removeSequenceDetail(rmcSelPrfl, appNum, Short.parseShort(indvSeqNum), Short.parseShort(seqNum),
					catUtilType, AppConstants.HOSPICE_INFORMATION);

			final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session.get(AppConstants.RMC_IN_PRFL_MASTER);
			boolean rmcPrflNotRequeired = false;

			if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl, IRMCResponseProfileManager.HOUS_PICE)) {
					rmcPrflNotRequeired = true;
				}
			} else {
				rmcPrflNotRequeired = true;
			}
			final Map nurHome = new HashMap();
			nurHome.put("HP", "HP");
			if (categorySelectionProfileManager.isRemoved(rmcSelPrfl, nurHome) && rmcPrflNotRequeired) {
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER, "ARHOS", driverArray, appNum);
			}
			CP_APP_IN_CARE_PROV_Collection aColl = aBHouseHoldMemberBO.loadHospDetails(appNum);
			boolean changeExists = false;
			
			for(int i=0; i<aColl.size(); i++){
				if(!aColl.getCargo(i).getSrc_app_ind().equals(AppConstants.CWW_RECORD_IND)){
					changeExists = true;
					break;
				}
			}
			if(!changeExists){
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"ARHOS", driverArray, appNum);
			}

			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
					driverArray, appNum);
			// End
			log(ILog.INFO, "RMCHousingExpenseEJBBean::eraseHPChanges:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("eraseHPChanges");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"eraseHPChanges", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.eraseHPChanges() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Adds the hos pice details.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void addHosPiceDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.addHosPiceDetails() - START");

		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			// get cargo determining user selection
			request.put("firstName_medIns", null);
			request.put("firstName_MAPP", null);
			request.put("firstName_SE", null);
			request.put("firstName_NH", null);
			final String schSeq = request.get("firstName_HP") != null ? (String) request
					.get("firstName_HP") : FwConstants.EMPTY_STRING;

					final SchoolEnrollmentBO schBO = new SchoolEnrollmentBO();// Write
					// the
					// validator
					// validate selections

					if (schSeq == null
							|| AppConstants.SELECT_DEFAULT_OPTION.equals(schSeq)) {
						schBO.validateAdd();
						// add validation message and return
						request.put(FwConstants.MESSAGE_LIST, schBO.getMessageList());
						txnBean.setPageCollection((Map) session
								.get(FwConstants.BEFORE_COLLECTION));
						return;
					}
					final String appNum = (String) session.get(AppConstants.APP_NUMBER);
					final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
					indivSeqBean.setIndivSeqNum(schSeq);
					indivSeqBean.setSeqNum(FwConstants.ZERO);
					indivSeqBean.setType("HP");
					indivSeqBean.setUserEndInd(FwConstants.ZERO);
					pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

					// set driver status
					final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARHOS", driver,
							appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driver,
							appNum);
					session.put(FwConstants.RMC_DRIVER, driver);

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("addHosPiceDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"addHosPiceDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.addHosPiceDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/* Hospice Methods ends here */

	/**
	 * Edits the hs details.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	/* Hospital stay Methods starts here */
	public void editHSDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.editHSDetails() - START");

		try {
			log(ILog.INFO, "RMCHousingExpenseEJBBean::editHSDetails:Start");
			final Map session = txnBean.getSession();
			final Map pageCollection = txnBean.getPageCollection();

			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			// Get the APP_IN_EMPL_Collection from pageCollection.
			final CP_APP_IN_CARE_PROV_Collection schColl = (CP_APP_IN_CARE_PROV_Collection) pageCollection
					.get("CP_APP_IN_CARE_PROV_Collection");
			final CP_APP_IN_CARE_PROV_Cargo schCargo = schColl.getResult(0);

			final IndivTypeSeqBean seqBean = new IndivTypeSeqBean();
			seqBean.setIndivSeqNum(schCargo.getIndv_seq_num());
			seqBean.setSeqNum(FwConstants.ZERO);
			seqBean.setType(schCargo.getSrc_app_ind());
			// setting user end indicator
			if(AppConstants.RMC_END_RECORD_IND.equals(schCargo.getSrc_app_ind())){
				seqBean.setUserEndInd(FwConstants.ONE);
			}else {
				seqBean.setUserEndInd(FwConstants.ZERO);
			}

			pageCollection.put(FwConstants.DETAIL_KEY_BEAN, seqBean);
			// Get App Number
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			// Set RMC page Nursing Home Details make required
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARHPS",
					driverArray, appNum);
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
					driverArray, appNum);
			// End
			log(ILog.INFO, "RMCHousingExpenseEJBBean::editHSDetails:End");

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("editHSDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"editHSDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.editHSDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Erase hs details.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void eraseHSDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.eraseHSDetails() - START");

		try {
			log(ILog.INFO, "RMCHousingExpenseEJBBean::eraseHSDetails:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);

			// Get RMCSessionBean from the session

			// Define IndvSeqNum and the SeqNum and Type and RowNum
			String indvSeqNum = null;
			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);

			// Get the APP_IN_SHLTC_Collection from pageCollection.
			final CP_APP_IN_CARE_PROV_Collection schColl = (CP_APP_IN_CARE_PROV_Collection) pageCollection
					.get("CP_APP_IN_CARE_PROV_Collection");
			final CP_APP_IN_CARE_PROV_Cargo schCargo = schColl.getResult(0);

			// Get the results from the APP_IN_EMPL_Collection
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);

			// delete record from rmc selection profile
			final SortedSet rmcSelPrfl = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);

			indvSeqNum = schCargo.getIndv_seq_num();
			CP_APP_IN_CARE_PROV_Cargo beforeschCargo = (CP_APP_IN_CARE_PROV_Cargo) beforeColl
					.get("CP_APP_IN_CARE_PROV_Cargo");
			final ABHouseHoldMemberBO aBHouseHoldMemberBO = new ABHouseHoldMemberBO();

			if (beforeschCargo == null
					|| aBHouseHoldMemberBO.isDifferentNH(schCargo,
							beforeschCargo)) {

				aBHouseHoldMemberBO.validateErase();
				request.put(FwConstants.MESSAGE_LIST,
						aBHouseHoldMemberBO.getMessageList());
				beforeschCargo = new CP_APP_IN_CARE_PROV_Cargo();
				beforeschCargo.setIndv_seq_num(indvSeqNum);
				/*
				 * VG SONAR Cleanup - 09/1/2015 Deleted 1 lines Commented Code
				 * in this block
				 */

				beforeColl.put("CP_APP_IN_CARE_PROV_Cargo", beforeschCargo);
				txnBean.setPageCollection(beforeColl);
				return;

			}

			aBHouseHoldMemberBO.deleteSERecordsForHS(indvSeqNum, appNum);
			final short[] responseArray = new short[] { IRMCResponseProfileManager.HOSPITAL_STAY_RESP };

			if (beforeColl != null) {
				int count = 0;
				CP_APP_IN_CARE_PROV_Collection rb1Coll = null;
				CP_APP_IN_CARE_PROV_Cargo rb1Cargo = null;
				rb1Coll = (CP_APP_IN_CARE_PROV_Collection) beforeColl
						.get("CP_APP_IN_CARE_PROV_Collection");

				if (rb1Coll != null && !rb1Coll.isEmpty()) {
					final int rbCollSize = rb1Coll.size();
					for (int i = 0; i < rbCollSize; i++) {
						rb1Cargo = rb1Coll.getCargo(i);
						if (rb1Cargo.getIndv_seq_num().equals(indvSeqNum)
								&& AppConstants.RMC_NEW_RECORD_IND
								.equals(rb1Cargo.getSrc_app_ind())) {
							count++;
						}
					}
				}
				if (count == 1) {
					// now we need to make that profile requirred
					final RMC_IN_PRFL_Cargo rmcResCargo = rmcResponseProfileManager
							.getProfile(rmcInPrflColl, indvSeqNum);
					rmcResponseProfileManager.makeAbsoluteNotRequired(
							responseArray, rmcResCargo, true);
				}
			}

			boolean rmcPrflNurHomeNotRequired = false;

			// here we need to check we have no entrys in rmcPrfl for the job
			// income detail
			// as well as we need to check
			if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl,
						IRMCResponseProfileManager.HOSPITAL_STAY_RESP)) {
					rmcPrflNurHomeNotRequired = true;
				}

			} else {
				rmcPrflNurHomeNotRequired = true;

			}
			final Map nurHome = new HashMap();
			nurHome.put("HS", "HS");
			if (!checkBenefitDetailPageRequired(rmcSelPrfl, nurHome)
					&& rmcPrflNurHomeNotRequired) {
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"ARHPS", driverArray, appNum);
			}
			
			CP_APP_IN_CARE_PROV_Collection aColl = aBHouseHoldMemberBO.loadHospitalStayDetails(appNum);
			boolean changeExists = false;
			
			for(int i=0; i<aColl.size(); i++){
				if(!aColl.getCargo(i).getSrc_app_ind().equals(AppConstants.CWW_RECORD_IND)){
					changeExists = true;
					break;
				}
			}
			if(!changeExists){
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"ARHPS", driverArray, appNum);
			}

			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
					driverArray, appNum);
			log(ILog.INFO, "RMCHousingExpenseEJBBean::eraseHSDetails:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("eraseHSDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"eraseHSDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.eraseHSDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Erase hs changes.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void eraseHSChanges(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.eraseHSChanges() - START");

		try {
			log(ILog.INFO, "RMCHousingExpenseEJBBean::eraseHSChanges:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);

			// Get RMCSessionBean from the session
			// Define IndvSeqNum and the SeqNum and Type and RowNum
			String indvSeqNum = null;
			String seqNum = null;
			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);

			// Get the APP_IN_SHLTC_Collection from pageCollection.
			final CP_APP_IN_CARE_PROV_Collection schColl = (CP_APP_IN_CARE_PROV_Collection) pageCollection
					.get("CP_APP_IN_CARE_PROV_Collection");
			final CP_APP_IN_CARE_PROV_Cargo schCargo = schColl.getResult(0);

			// Get the results from the APP_IN_EMPL_Collection
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			indvSeqNum = schCargo.getIndv_seq_num();
			seqNum = schCargo.getSeq_num();

			CP_APP_IN_CARE_PROV_Cargo beforeSchCargo = (CP_APP_IN_CARE_PROV_Cargo) beforeColl
					.get("CP_APP_IN_CARE_PROV_Cargo");

			final ABHouseHoldMemberBO aBHouseHoldMemberBO = new ABHouseHoldMemberBO();
			if (beforeSchCargo == null
					|| aBHouseHoldMemberBO.isDifferentNH(schCargo,
							beforeSchCargo)) {
				aBHouseHoldMemberBO.validateEraseChanges();
				request.put(FwConstants.MESSAGE_LIST,
						aBHouseHoldMemberBO.getMessageList());
				beforeSchCargo = new CP_APP_IN_CARE_PROV_Cargo();
				beforeSchCargo.setIndv_seq_num(indvSeqNum);
				beforeColl.put("CP_APP_IN_CARE_PROV_Cargo", beforeSchCargo);
				txnBean.setPageCollection(beforeColl);
				return;
			}

			// delete record from database
			aBHouseHoldMemberBO.deleteSERecordsForHS(indvSeqNum, appNum);

			final String catUtilType = AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL;

			// delete record from rmc selection profile
			final SortedSet rmcSelPrfl = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			categorySelectionProfileManager.removeSequenceDetail(rmcSelPrfl,
					appNum, Short.parseShort(indvSeqNum),
					Short.parseShort(seqNum), catUtilType,
					AppConstants.HOSPITAL_STAY);

			final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			boolean rmcPrflNotRequeired = false;

			if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl,
						IRMCResponseProfileManager.HOSPITAL_STAY_RESP)) {
					rmcPrflNotRequeired = true;
				}
			} else {
				rmcPrflNotRequeired = true;
			}
			final Map nurHome = new HashMap();
			nurHome.put("HS", "HS");
			if (categorySelectionProfileManager.isRemoved(rmcSelPrfl, nurHome)
					&& rmcPrflNotRequeired) {
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"ARHPS", driverArray, appNum);
			}
			
			CP_APP_IN_CARE_PROV_Collection aColl = aBHouseHoldMemberBO.loadHospitalStayDetails(appNum);
			boolean changeExists = false;
			
			for(int i=0; i<aColl.size(); i++){
				if(!aColl.getCargo(i).getSrc_app_ind().equals(AppConstants.CWW_RECORD_IND)){
					changeExists = true;
					break;
				}
			}
			if(!changeExists){
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"ARHPS", driverArray, appNum);
			}

			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
					driverArray, appNum);
			// End
			log(ILog.INFO, "RMCHousingExpenseEJBBean::eraseHSChanges:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("eraseHSChanges");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"eraseHSChanges", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.eraseHSChanges() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 *
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void addHospitalDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.addHosPiceDetails() - START");

		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			// get cargo determining user selection
			request.put("firstName_medIns", null);
			request.put("firstName_MAPP", null);
			request.put("firstName_SE", null);
			request.put("firstName_NH", null);
			request.put("firstName_HP", null);
			final String schSeq = request.get("firstName_HS") != null ? (String) request
					.get("firstName_HS") : FwConstants.EMPTY_STRING;

					final SchoolEnrollmentBO schBO = new SchoolEnrollmentBO();// Write
					// the
					// validator
					// validate selections

					if (schSeq == null
							|| AppConstants.SELECT_DEFAULT_OPTION.equals(schSeq)) {
						schBO.validateAdd();
						// add validation message and return
						request.put(FwConstants.MESSAGE_LIST, schBO.getMessageList());
						txnBean.setPageCollection((Map) session
								.get(FwConstants.BEFORE_COLLECTION));
						return;
					}
					final String appNum = (String) session.get(AppConstants.APP_NUMBER);
					final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
					indivSeqBean.setIndivSeqNum(schSeq);
					indivSeqBean.setSeqNum(FwConstants.ZERO);
					indivSeqBean.setType("HS");
					indivSeqBean.setUserEndInd(FwConstants.ZERO);
					pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

					// set driver status
					final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARHPS", driver,
							appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driver,
							appNum);
					session.put(FwConstants.RMC_DRIVER, driver);

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("addHospitalDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"addHospitalDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.addHospitalDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/* Hospital stay Methods ends here */

	/**
	 * Edits the of details.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	/* Outstate methods starts here */
	public void editOFDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.editOFDetails() - START");

		try {
			log(ILog.INFO, "RMCHousingExpenseEJBBean::editOFDetails:Start");
			final Map session = txnBean.getSession();
			final Map pageCollection = txnBean.getPageCollection();

			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			// Get the APP_IN_OUT_ST_BNFT_Collection from pageCollection.
			final APP_IN_OUT_ST_BNFT_Collection schColl = (APP_IN_OUT_ST_BNFT_Collection) pageCollection
					.get("APP_IN_OUT_ST_BNFT_Collection");
			final APP_IN_OUT_ST_BNFT_Cargo schCargo = schColl.getResult(0);

			final IndivTypeSeqBean seqBean = new IndivTypeSeqBean();
			seqBean.setIndivSeqNum(schCargo.getIndv_seq_num());
			seqBean.setSeqNum(FwConstants.ZERO);
			seqBean.setType(schCargo.getSrc_app_ind());
			// setting user end indicator

			pageCollection.put(FwConstants.DETAIL_KEY_BEAN, seqBean);
			// Get App Number
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			// Set RMC Details make required
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROFS",
					driverArray, appNum);
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
					driverArray, appNum);
			// End
			log(ILog.INFO, "RMCHousingExpenseEJBBean::editOFDetails:End");

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("editOFDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"editOFDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.editOFDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Erase of details.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void eraseOFDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.eraseOFDetails() - START");

		try {
			log(ILog.INFO, "RMCHousingExpenseEJBBean::eraseOFDetails:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);

			// Get RMCSessionBean from the session

			// Define IndvSeqNum and the SeqNum and Type and RowNum
			String indvSeqNum = null;
			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);

			// Get the APP_IN_SHLTC_Collection from pageCollection.
			final APP_IN_OUT_ST_BNFT_Collection schColl = (APP_IN_OUT_ST_BNFT_Collection) pageCollection
					.get("APP_IN_OUT_ST_BNFT_Collection");
			final APP_IN_OUT_ST_BNFT_Cargo schCargo = schColl.getResult(0);

			// Get the results from the APP_IN_EMPL_Collection
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);

			// delete record from rmc selection profile
			final SortedSet rmcSelPrfl = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);

			indvSeqNum = schCargo.getIndv_seq_num();
			APP_IN_OUT_ST_BNFT_Cargo beforeschCargo = (APP_IN_OUT_ST_BNFT_Cargo) beforeColl
					.get("APP_IN_OUT_ST_BNFT_Cargo");
			final ABHouseHoldMemberBO aBHouseHoldMemberBO = new ABHouseHoldMemberBO();

			if (beforeschCargo == null
					|| aBHouseHoldMemberBO.isDifferentOF(schCargo,
							beforeschCargo)) {

				aBHouseHoldMemberBO.validateErase();
				request.put(FwConstants.MESSAGE_LIST,
						aBHouseHoldMemberBO.getMessageList());
				beforeschCargo = new APP_IN_OUT_ST_BNFT_Cargo();
				beforeschCargo.setIndv_seq_num(indvSeqNum);
				/*
				 * VG SONAR Cleanup - 09/1/2015 Deleted 1 lines Commented Code
				 * in this block
				 */

				beforeColl.put("APP_IN_OUT_ST_BNFT_Cargo", beforeschCargo);
				txnBean.setPageCollection(beforeColl);
				return;

			}

			aBHouseHoldMemberBO.deleteSERecordsForOF(indvSeqNum, appNum);
			final SortedSet categorySelectionProfile = categorySelectionProfileManager
					.loadCategoryChangeSelectionProfile(appNum,
							AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL);
			if(categorySelectionProfile!=null && categorySelectionProfile.size()>0)
			{
			categorySelectionProfileManager.removeSequenceDetail(categorySelectionProfile,
					appNum, Short.parseShort(indvSeqNum),
					Long.parseLong("0"),AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL , AppConstants.OUTOFSTATE_INFORMATION);
			}
			final short[] responseArray = new short[] { IRMCResponseProfileManager.OUTSTATE_BNFTS };

			final OutOfStateBenefitsBO outBO = new OutOfStateBenefitsBO();
			final APP_IN_OUT_ST_BNFT_Collection outColl = outBO.loadOutOfStateDetailsBySrcInd(appNum);
			int count = 0;
			if (outColl != null) {				
				APP_IN_OUT_ST_BNFT_Cargo outCargo = null;
				if (outColl != null && !outColl.isEmpty()) {
					final int rbCollSize = outColl.size();
					for (int i = 0; i < rbCollSize; i++) {
						outCargo = outColl.getResult(i);
						if (outCargo.getIndv_seq_num().equals(indvSeqNum)
								&& AppConstants.RMC_NEW_RECORD_IND
								.equals(outCargo.getSrc_app_ind())) {
							count++;
						}
					}
				}
				if (count == 0) {
					// now we need to make that profile requirred
					final RMC_IN_PRFL_Cargo rmcResCargo = rmcResponseProfileManager
							.getProfile(rmcInPrflColl, indvSeqNum);
					rmcResponseProfileManager.makeAbsoluteNotRequired(
							responseArray, rmcResCargo, true);
				}
			}

			boolean rmcPrflNurHomeNotRequired = false;

			// here we need to check we have no entrys in rmcPrfl for the job
			// income detail
			// as well as we need to check
			if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl,
						IRMCResponseProfileManager.OUTSTATE_BNFTS)) {
					rmcPrflNurHomeNotRequired = true;
				}

			} else {
				rmcPrflNurHomeNotRequired = true;

			}
			final Map nurHome = new HashMap();
			nurHome.put("OF", "OF");
			count = outBO.loadOutStateByTyp(outColl,indvSeqNum);
			if (count==0) {
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"AROFS", driverArray, appNum);
			}

			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
					driverArray, appNum);
			log(ILog.INFO, "RMCHousingExpenseEJBBean::eraseOFDetails:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("eraseOFDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"eraseOFDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.eraseOFDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Erase of changes.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void eraseOFChanges(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.eraseOFChanges() - START");

		try {
			log(ILog.INFO, "RMCHousingExpenseEJBBean::eraseOFChanges:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);

			// Get RMCSessionBean from the session
			// Define IndvSeqNum and the SeqNum and Type and RowNum
			String indvSeqNum = null;
			String seqNum = null;
			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);

			// Get the APP_IN_OUT_ST_BNFT_Collection from pageCollection.
			final APP_IN_OUT_ST_BNFT_Collection schColl = (APP_IN_OUT_ST_BNFT_Collection) pageCollection
					.get("APP_IN_OUT_ST_BNFT_Collection");
			final APP_IN_OUT_ST_BNFT_Cargo schCargo = schColl.getResult(0);

			// Get the results from the APP_IN_EMPL_Collection
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			indvSeqNum = schCargo.getIndv_seq_num();
			seqNum = FwConstants.ZERO;

			APP_IN_OUT_ST_BNFT_Cargo beforeSchCargo = (APP_IN_OUT_ST_BNFT_Cargo) beforeColl
					.get("APP_IN_OUT_ST_BNFT_Cargo");

			final ABHouseHoldMemberBO aBHouseHoldMemberBO = new ABHouseHoldMemberBO();
			if (beforeSchCargo == null
					|| aBHouseHoldMemberBO.isDifferentOF(schCargo,
							beforeSchCargo)) {
				aBHouseHoldMemberBO.validateEraseChanges();
				request.put(FwConstants.MESSAGE_LIST,
						aBHouseHoldMemberBO.getMessageList());
				beforeSchCargo = new APP_IN_OUT_ST_BNFT_Cargo();
				beforeSchCargo.setIndv_seq_num(indvSeqNum);
				beforeColl.put("APP_IN_OUT_ST_BNFT_Cargo", beforeSchCargo);
				txnBean.setPageCollection(beforeColl);
				return;
			}

			// delete record from database
			aBHouseHoldMemberBO.deleteSERecordsForOF(indvSeqNum, appNum);

			final String catUtilType = AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL;

			// delete record from rmc selection profile
			final SortedSet rmcSelPrfl = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			categorySelectionProfileManager.removeSequenceDetail(rmcSelPrfl,
					appNum, Short.parseShort(indvSeqNum),
					Short.parseShort(seqNum), catUtilType,
					AppConstants.OUTOFSTATE_INFORMATION);
			categorySelectionProfileManager.insertSequenceDetail(rmcSelPrfl,
					appNum, catUtilType, Short.parseShort(indvSeqNum),
					Short.parseShort(seqNum),
					AppConstants.OUTOFSTATE_INFORMATION, (short) 2, 'N');
			final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			boolean rmcPrflNotRequeired = false;

			if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl,
						IRMCResponseProfileManager.OUTSTATE_BNFTS)) {
					rmcPrflNotRequeired = true;
				}
			} else {
				rmcPrflNotRequeired = true;
			}
			final Map nurHome = new HashMap();
			nurHome.put("OF", "OF");
			if (!checkBenefitDetailPageRequired(rmcSelPrfl, nurHome)
					&& rmcPrflNotRequeired) {
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"AROFS", driverArray, appNum);
			}

			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
					driverArray, appNum);
			// End
			log(ILog.INFO, "RMCHousingExpenseEJBBean::eraseOFChanges:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("eraseOFChanges");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"eraseOFChanges", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.eraseOFChanges() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 *
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void addOutStateDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.addOutStateDetails() - START");

		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			// get cargo determining user selection
			request.put("firstName_medIns", null);
			request.put("firstName_MAPP", null);
			request.put("firstName_SE", null);
			request.put("firstName_NH", null);
			request.put("firstName_HP", null);
			request.put("firstName_HS", null);
			final String schSeq = request.get("firstName_OF") != null ? (String) request
					.get("firstName_OF") : FwConstants.EMPTY_STRING;

					final SchoolEnrollmentBO schBO = new SchoolEnrollmentBO();// Write
					// the
					// validator
					// validate selections

					if (schSeq == null
							|| AppConstants.SELECT_DEFAULT_OPTION.equals(schSeq)) {
						schBO.validateAdd();
						// add validation message and return
						request.put(FwConstants.MESSAGE_LIST, schBO.getMessageList());
						txnBean.setPageCollection((Map) session
								.get(FwConstants.BEFORE_COLLECTION));
						return;
					}
					final String appNum = (String) session.get(AppConstants.APP_NUMBER);
					final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
					indivSeqBean.setIndivSeqNum(schSeq);
					indivSeqBean.setSeqNum(FwConstants.ZERO);
					indivSeqBean.setType("OF");
					indivSeqBean.setUserEndInd(FwConstants.ZERO);
					pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

					// set driver status
					final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
					driverManager.makeAddNew(FwConstants.RMC_DRIVER, "AROFS", driver,
							appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driver,
							appNum);
					session.put(FwConstants.RMC_DRIVER, driver);

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("addOutStateDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"addOutStateDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.addOutStateDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/* Out State Methods ends here */

	/* medicare starts here */

	/**
	 *
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void editMCDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.editMCDetails() - START");

		try {
			log(ILog.INFO, "RMCHousingExpenseEJBBean::editMCDetails:Start");
			final Map session = txnBean.getSession();
			final Map pageCollection = txnBean.getPageCollection();

			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			// Get the APP_IN_EMPL_Collection from pageCollection.
			final APP_IN_MEDCR_Collection medcareColl = (APP_IN_MEDCR_Collection) pageCollection
					.get("APP_IN_MEDCR_Collection");
			final APP_IN_MEDCR_Cargo medicareCargo = medcareColl.getResult(0);

			final IndivTypeSeqBean seqBean = new IndivTypeSeqBean();
			seqBean.setIndivSeqNum(medicareCargo.getIndv_seq_num());
			seqBean.setSeqNum(medicareCargo.getSeq_num());
			seqBean.setType(medicareCargo.getSrc_app_ind());
			// setting user end indicator

			pageCollection.put(FwConstants.DETAIL_KEY_BEAN, seqBean);
			// Get App Number
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			// Set RMC page Nursing Home Details make required
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARMED",
					driverArray, appNum);
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
					driverArray, appNum);
			// End
			log(ILog.INFO, "RMCHousingExpenseEJBBean::editMCDetails:End");

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("editMCDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"editMCDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.editMCDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 *
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void eraseMCDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.eraseMCDetails() - START");

		try {
			log(ILog.INFO, "RMCHousingExpenseEJBBean::eraseMCDetails:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);

			// Get RMCSessionBean from the session

			// Define IndvSeqNum and the SeqNum and Type and RowNum
			String indvSeqNum = null;
			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);

			// Get the APP_IN_MEDCR_Collection from pageCollection.
			final APP_IN_MEDCR_Collection medicareColl = (APP_IN_MEDCR_Collection) pageCollection
					.get("APP_IN_MEDCR_Collection");
			final APP_IN_MEDCR_Cargo medicCargo = medicareColl.getResult(0);

			// Get the results from the APP_IN_EMPL_Collection
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);

			// delete record from rmc selection profile
			final SortedSet rmcSelPrfl = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);

			indvSeqNum = medicCargo.getIndv_seq_num();
			APP_IN_MEDCR_Cargo beforeschCargo = (APP_IN_MEDCR_Cargo) beforeColl
					.get("APP_IN_MEDCR_Cargo");
			final ABHouseHoldMemberBO aBHouseHoldMemberBO = new ABHouseHoldMemberBO();

			if (beforeschCargo == null
					|| aBHouseHoldMemberBO.isDifferentMC(medicCargo,
							beforeschCargo)) {

				aBHouseHoldMemberBO.validateErase();
				request.put(FwConstants.MESSAGE_LIST,
						aBHouseHoldMemberBO.getMessageList());
				beforeschCargo = new APP_IN_MEDCR_Cargo();
				beforeschCargo.setIndv_seq_num(indvSeqNum);
				/*
				 * VG SONAR Cleanup - 09/1/2015 Deleted 1 lines Commented Code
				 * in this block
				 */

				beforeColl.put("APP_IN_MEDCR_Cargo", beforeschCargo);
				txnBean.setPageCollection(beforeColl);
				return;

			}

			aBHouseHoldMemberBO.deleteRecordsForMC(indvSeqNum, appNum);
			final SortedSet categorySelectionProfile = categorySelectionProfileManager
					.loadCategoryChangeSelectionProfile(appNum,
							AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL);
			if(categorySelectionProfile!=null && categorySelectionProfile.size()>0)
			{
			categorySelectionProfileManager.removeSequenceDetail(categorySelectionProfile,
					appNum, Short.parseShort(indvSeqNum),
					Long.parseLong("0"),AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL , AppConstants.MEDICARE_INFORMATION);
			}
			final short[] responseArray = new short[] { IRMCResponseProfileManager.RECEIVE_MEDICARE };
			final MedicareBO medicareBO = new MedicareBO();
			final APP_IN_MEDCR_Collection medColl = medicareBO.loadMedicareDetails(appNum);
			int count = 0;
			if (medColl != null) {				
				APP_IN_MEDCR_Cargo medCargo = null;
				if (medColl != null && !medColl.isEmpty()) {
					final int rbCollSize = medColl.size();
					for (int i = 0; i < rbCollSize; i++) {
						medCargo = medColl.getResult(i);
						if (medCargo.getIndv_seq_num().equals(indvSeqNum)
								&& AppConstants.RMC_NEW_RECORD_IND
								.equals(medCargo.getSrc_app_ind())) {
							count++;
						}
					}
				}
				if (count == 0) {
					// now we need to make that profile requirred
					final RMC_IN_PRFL_Cargo rmcResCargo = rmcResponseProfileManager
							.getProfile(rmcInPrflColl, indvSeqNum);
					rmcResponseProfileManager.makeAbsoluteNotRequired(
							responseArray, rmcResCargo, true);
				}
			}

			boolean rmcPrflNurHomeNotRequired = false;

			if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl,
						IRMCResponseProfileManager.RECEIVE_MEDICARE)) {
					rmcPrflNurHomeNotRequired = true;
				}

			} else {
				rmcPrflNurHomeNotRequired = true;

			}
			final Map nurHome = new HashMap();
			nurHome.put("MC", "MC");
			count = medicareBO.loadMedicareByTyp(medColl,indvSeqNum);
			if (count==0) {
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"ARMED", driverArray, appNum);
			}

			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
					driverArray, appNum);
			log(ILog.INFO, "RMCHousingExpenseEJBBean::eraseSEDetails:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("eraseMCDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"eraseMCDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.eraseMCDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 *
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 * @throws javax.ejb.EJBException the javax.ejb. ejb exception
	 */
	public void eraseMCChanges(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.eraseMCChanges() - START");

		try {
			log(ILog.INFO, "RMCHousingExpenseEJBBean::eraseMCChanges:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);

			// Get RMCSessionBean from the session
			// Define IndvSeqNum and the SeqNum and Type and RowNum
			String indvSeqNum = null;
			String seqNum = null;
			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);

			// Get the APP_IN_OUT_ST_BNFT_Collection from pageCollection.
			final APP_IN_MEDCR_Collection medicColl = (APP_IN_MEDCR_Collection) pageCollection
					.get("APP_IN_MEDCR_Collection");
			final APP_IN_MEDCR_Cargo medicCargo = medicColl.getResult(0);

			// Get the results from the APP_IN_EMPL_Collection
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			indvSeqNum = medicCargo.getIndv_seq_num();
			seqNum = FwConstants.ZERO;

			APP_IN_MEDCR_Cargo beforeSchCargo = (APP_IN_MEDCR_Cargo) beforeColl
					.get("APP_IN_MEDCR_Cargo");

			final ABHouseHoldMemberBO aBHouseHoldMemberBO = new ABHouseHoldMemberBO();
			if (beforeSchCargo == null
					|| aBHouseHoldMemberBO.isDifferentMC(medicCargo,
							beforeSchCargo)) {
				aBHouseHoldMemberBO.validateEraseChanges();
				request.put(FwConstants.MESSAGE_LIST,
						aBHouseHoldMemberBO.getMessageList());
				beforeSchCargo = new APP_IN_MEDCR_Cargo();
				beforeSchCargo.setIndv_seq_num(indvSeqNum);
				beforeColl.put("APP_IN_MEDCR_Cargo", beforeSchCargo);
				txnBean.setPageCollection(beforeColl);
				return;
			}

			// delete record from database
			aBHouseHoldMemberBO.deleteSERecordsForOF(indvSeqNum, appNum);

			final String catUtilType = AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL;

			// delete record from rmc selection profile
			final SortedSet rmcSelPrfl = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			categorySelectionProfileManager.removeSequenceDetail(rmcSelPrfl,
					appNum, Short.parseShort(indvSeqNum),
					Short.parseShort(seqNum), catUtilType,
					AppConstants.MEDICARE_INFORMATION);
			categorySelectionProfileManager.insertSequenceDetail(rmcSelPrfl,
					appNum, catUtilType, Short.parseShort(indvSeqNum),
					Short.parseShort(seqNum),
					AppConstants.MEDICARE_INFORMATION, (short) 2, 'N');
			final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			boolean rmcPrflNotRequeired = false;

			if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl,
						IRMCResponseProfileManager.RECEIVE_MEDICARE)) {
					rmcPrflNotRequeired = true;
				}
			} else {
				rmcPrflNotRequeired = true;
			}
			final Map nurHome = new HashMap();
			nurHome.put("MC", "MC");
			if (!checkBenefitDetailPageRequired(rmcSelPrfl, nurHome)
					&& rmcPrflNotRequeired) {
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"ARMED", driverArray, appNum);
			}

			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
					driverArray, appNum);
			// End
			log(ILog.INFO, "RMCHousingExpenseEJBBean::eraseMCChanges:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("eraseMCChanges");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"eraseMCChanges", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.eraseMCChanges() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 *
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void addMedicareDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.addMedicareDetails() - START");

		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			// get cargo determining user selection
			request.put("firstName_medIns", null);
			request.put("firstName_MAPP", null);
			request.put("firstName_SE", null);
			request.put("firstName_NH", null);
			request.put("firstName_HP", null);
			request.put("firstName_HS", null);
			request.put("firstName_OF", null);
			final String schSeq = request.get("firstName_MC") != null ? (String) request
					.get("firstName_MC") : FwConstants.EMPTY_STRING;

			final SchoolEnrollmentBO schBO = new SchoolEnrollmentBO();

			// validate selections

					if (schSeq == null
							|| AppConstants.SELECT_DEFAULT_OPTION.equals(schSeq)) {
						schBO.validateAdd();
						// add validation message and return
						request.put(FwConstants.MESSAGE_LIST, schBO.getMessageList());
						txnBean.setPageCollection((Map) session
								.get(FwConstants.BEFORE_COLLECTION));
						return;
					}
					final String appNum = (String) session.get(AppConstants.APP_NUMBER);
					final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
					indivSeqBean.setIndivSeqNum(schSeq);
					indivSeqBean.setSeqNum(FwConstants.ZERO);
					indivSeqBean.setType("MC");
					indivSeqBean.setUserEndInd(FwConstants.ZERO);
					pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

					// set driver status
					final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
					driverManager.makeAddNew(FwConstants.RMC_DRIVER, "ARMED", driver,
							appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driver,
							appNum);
					session.put(FwConstants.RMC_DRIVER, driver);

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("addMedicareDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"addMedicareDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.addMedicareDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Load tax claimer details.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void loadTaxClaimerDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.DEBUG,
				"RMCOtherBenefitsEJBBean.loadTaxClaimerDetails() - START");
		final Map request = txnBean.getRequest();
		final Map session = txnBean.getSession();
		final Map pageCollection = txnBean.getPageCollection();
		try {
			final String appNumber = (String) session
					.get(AppConstants.APP_NUMBER);
			final String pageId = (String) request
					.get(FwConstants.CURRENT_PAGE_ID);
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			final int pageStatus = driverManager.getAFBStatus(
					FwConstants.RMC_DRIVER, pageId, driverArray);
			final String previousPageId = (String) request
					.get(FwConstants.PREVIOUS_PAGE_ID);
			final String currentPageID = (String) request
					.get(FwConstants.CURRENT_PAGE_ID);
			final String newPersonInd = (String) session.get("ADD_NEW_PERSON");
			String pageMode = FwConstants.EMPTY_STRING;
			if (FwConstants.YES.equals(newPersonInd)) {
				pageMode = FwConstants.NO;
			}
			// build category selection profile
			final SortedSet categorySelectionProfile = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);

			RMC_IN_PRFL_Collection rmcInPrflColl = new RMC_IN_PRFL_Collection();
			rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);

			final TaxClaimDependantBO taxClaimBO = new TaxClaimDependantBO();
			final short[] responseType = new short[] { IRMCResponseProfileManager.TAX_CLAIM_DEPENDENT };
			final String[] catType = new String[] { AppConstants.TAX_CLAIM_DEPENDENT };

			SortedSet taxProfile = null;
			SortedSet taxCategoryProfile = null;
			SortedSet taxRmcProfile = null;

			String editTaxResponse = FwConstants.EMPTY_STRING;
			String editTaxIndvSeqNum = FwConstants.EMPTY_STRING;
			INDIVIDUAL_Custom_Cargo indvCustCargo =null;
			String sexInd=null;
			if (session.containsKey("EDIT_Tax_Response")) {
				editTaxResponse = (String) session.get("EDIT_Tax_Response");
			}
			if (session.containsKey("EDIT_Tax_IndvSeqNum")) {
				editTaxIndvSeqNum = (String) session.get("EDIT_Tax_IndvSeqNum");
			}

			if (!pageId.equals(previousPageId)) {
				taxProfile = new TreeSet(
						new CategorySequenceDetailsComparator());
				if (categorySelectionProfile != null) {
					taxCategoryProfile = createPageProfile(
							categorySelectionProfile, catType);
					taxProfile.addAll(taxCategoryProfile);
				}
				if (rmcInPrflColl != null) {
					taxRmcProfile = createPageProfile(new TreeSet(),
							rmcInPrflColl, responseType);
					taxProfile.addAll(taxRmcProfile);
				}
				if (pageStatus != FwConstants.DRIVER_REQUIRED) {
					final CP_APP_IN_TAX_INFORMATION_Collection collectionToSplit = taxClaimBO
							.loadTaxClaimDependantInfo(appNumber);
					CP_APP_IN_TAX_INFORMATION_Collection newTaxColl = new CP_APP_IN_TAX_INFORMATION_Collection();
					newTaxColl = taxClaimBO.splitTaxClaimDependantColl(
							collectionToSplit,
							AppConstants.RMC_MODIFIED_RECORD_IND);
					newTaxColl
					.addAll(taxClaimBO.splitTaxClaimDependantColl(
							collectionToSplit,
							AppConstants.RMC_NEW_RECORD_IND));
					if (newTaxColl != null && !newTaxColl.isEmpty()) {
						CP_APP_IN_TAX_INFORMATION_Cargo appInTaxCargo = null;
						final int newTaxCollSize = newTaxColl.size();
						for (int i = 0; i < newTaxCollSize; i++) {
							appInTaxCargo = newTaxColl.getCargo(i);
							if (editTaxResponse != null
									&& FwConstants.YES.equals(editTaxResponse)
									&& editTaxIndvSeqNum != null
									&& editTaxIndvSeqNum.equals(appInTaxCargo
											.getIndv_seq_num())) {
								categorySelectionProfileManager
								.insertSequenceDetail(
										categorySelectionProfile,
										null,
										AppConstants.RMC_CAT_HO_COMP_PRFL,
										Short.parseShort(appInTaxCargo
												.getIndv_seq_num()),
												AppConstants.TAX_CLAIM_DEPENDENT);
							} else {
								categorySelectionProfileManager
								.insertExistingSequenceDetail(
										taxProfile,
										null,
										null,
										Short.parseShort(appInTaxCargo
												.getIndv_seq_num()),
												0,
												AppConstants.TAX_CLAIM_DEPENDENT);
							}

						}
					}
				}
				if (pageStatus == FwConstants.DRIVER_REQUIRED
						|| pageStatus == FwConstants.DRIVER_VISIT_AGAIN) {
					// set the current record indicator to the first one
					categorySelectionProfileManager
					.setCurrentRecordIndToFirst(taxProfile);
				}
				if (pageStatus == FwConstants.DRIVER_COMPLETE) {
					// set the current record indicator to the end of the detail
					// bean
					categorySelectionProfileManager
					.setCurrentRecordIndToLast(taxProfile);
				}
				// create add new sorted set
				// we need to remove the vallues from the session
				session.remove(FwConstants.BEFORE_COLLECTION);
			} else {
				// catAddNewProfile get it from the before collection
				final Map beforeColl = (Map) session
						.get(FwConstants.BEFORE_COLLECTION);
				taxProfile = (SortedSet) beforeColl
						.get(AppConstants.RMC_CATEGORY_PAGE_PRFL);
			}
			final IndivTypeSeqBean indivSeqBean = (IndivTypeSeqBean) pageCollection
					.get(FwConstants.DETAIL_KEY_BEAN);
			// if details key bean not null means this bean is comming from the
			// summary page
			if (indivSeqBean != null) {
				final CategorySequenceDetail categorySeqDetail1 = categorySelectionProfileManager
						.getCategorySequenceDetail(
								taxProfile,
								Short.parseShort(indivSeqBean.getIndivSeqNum()),
								Long.parseLong(indivSeqBean.getSeqNum()),
								indivSeqBean.getType());
				if (categorySeqDetail1 != null) {
					categorySelectionProfileManager.makeSequenceDetailRequired(
							taxProfile, null,
							Short.parseShort(indivSeqBean.getIndivSeqNum()),
							Long.parseLong(indivSeqBean.getSeqNum()),
							indivSeqBean.getType());
					final CategorySequenceDetail categorySeqDetail2 = categorySelectionProfileManager
							.getCategorySequenceDetail(
									categorySelectionProfile, Short
									.parseShort(indivSeqBean
											.getIndivSeqNum()),
											Long.parseLong(indivSeqBean.getSeqNum()),
											indivSeqBean.getType());
					if (categorySeqDetail2 != null) {
						categorySelectionProfileManager
						.makeSequenceDetailRequired(
								categorySelectionProfile, appNumber,
								Short.parseShort(indivSeqBean
										.getIndivSeqNum()), Long
										.parseLong(indivSeqBean
												.getSeqNum()),
												indivSeqBean.getType());
					}
				} else {
					if (FwConstants.ZERO.equals(indivSeqBean.getSeqNum())) {
						RMC_IN_PRFL_Cargo rmcInPrflCargo = null;
						if (rmcInPrflColl != null) {
							rmcInPrflCargo = rmcResponseProfileManager
									.getProfile(rmcInPrflColl,
											indivSeqBean.getIndivSeqNum());
						} else {
							rmcInPrflColl = new RMC_IN_PRFL_Collection();
						}
						if (rmcInPrflCargo == null) {
							rmcInPrflCargo = new RMC_IN_PRFL_Cargo();
							rmcInPrflCargo.setApp_num(appNumber);
							rmcInPrflCargo.setIndv_seq_num(indivSeqBean
									.getIndivSeqNum());
							rmcResponseProfileManager
							.createRMCIndividualProfile(rmcInPrflCargo);
							rmcInPrflColl.addCargo(rmcInPrflCargo);
						}
						rmcResponseProfileManager.makeAddNew(
								IRMCResponseProfileManager.TAX_CLAIM_DEPENDENT,
								rmcInPrflCargo, true);
						categorySelectionProfileManager
						.insertSequenceDetail(categorySelectionProfile,
								appNumber,
								AppConstants.RMC_CAT_HO_COMP_PRFL,
								Short.parseShort(indivSeqBean
										.getIndivSeqNum()),
										indivSeqBean.getType());
						categorySelectionProfileManager
						.makeSequenceDetailRequired(
								categorySelectionProfile, appNumber,
								Short.parseShort(indivSeqBean
										.getIndivSeqNum()), Long
										.parseLong(indivSeqBean
												.getSeqNum()),
												indivSeqBean.getType());
						session.put(AppConstants.RMC_IN_PRFL_MASTER,
								rmcInPrflColl);

						SortedSet disabSortedSet = null;
						final String[] catTypeDisabBlind = { AppConstants.TAX_CLAIM_DEPENDENT };
						disabSortedSet = createPageProfile(
								categorySelectionProfile, catTypeDisabBlind);
						taxProfile.addAll(disabSortedSet);
						categorySelectionProfileManager
						.getNextSequenceDetail(taxProfile);
						/*
						 * VG SONAR Cleanup - 09/1/2015 Deleted 3 lines
						 * Commented Code in this block
						 */

					} else {
						categorySelectionProfileManager
						.insertExistingSequenceDetail(taxProfile, null,
								null, Short.parseShort(indivSeqBean
										.getIndivSeqNum()), Long
										.parseLong(indivSeqBean
												.getSeqNum()),
												indivSeqBean.getType());
						categorySelectionProfileManager
						.makeSequenceDetailRequired(taxProfile, null,
								Short.parseShort(indivSeqBean
										.getIndivSeqNum()), Long
										.parseLong(indivSeqBean
												.getSeqNum()),
												indivSeqBean.getType());

						categorySelectionProfileManager
						.insertExistingSequenceDetail(
								categorySelectionProfile, appNumber,
								AppConstants.RMC_CAT_HO_COMP_PRFL,
								Short.parseShort(indivSeqBean
										.getIndivSeqNum()), Long
										.parseLong(indivSeqBean
												.getSeqNum()),
												indivSeqBean.getType());
						categorySelectionProfileManager
						.makeSequenceDetailRequired(
								categorySelectionProfile, appNumber,
								Short.parseShort(indivSeqBean
										.getIndivSeqNum()), Long
										.parseLong(indivSeqBean
												.getSeqNum()),
												indivSeqBean.getType());
					}
				}
			}
			pageCollection.put(AppConstants.RMC_CATEGORY_PAGE_PRFL, taxProfile);
			CategorySequenceDetail categorySeqDetail = categorySelectionProfileManager
					.getCurrentSequenceDetail(taxProfile);
			if (categorySeqDetail == null) {
				categorySeqDetail = categorySelectionProfileManager
						.getNextSequenceDetail(taxProfile);
			}
			categorySeqDetail.getCategoryType();
			Long.toString(categorySeqDetail.getCategorySequence());
			String indvSeqNum ="0";
			if (categorySeqDetail != null) {
				indvSeqNum = Short.toString(categorySeqDetail.getIndividualSequence());
			}
			// load details from the data base
			CP_APP_IN_TAX_INFORMATION_Collection appInTaxCollectionToSplit = new CP_APP_IN_TAX_INFORMATION_Collection();
			CP_APP_IN_TAX_INFORMATION_Collection appInTaxCollection = new CP_APP_IN_TAX_INFORMATION_Collection();
			appInTaxCollectionToSplit = taxClaimBO
					.loadTaxClaimDependantDetails(appNumber, indvSeqNum);
			appInTaxCollection = taxClaimBO.splitTaxClaimDependantColl(
					appInTaxCollectionToSplit, AppConstants.RMC_NEW_RECORD_IND);
			if (appInTaxCollection != null && !(appInTaxCollection.size() > 0)) {
				appInTaxCollection = taxClaimBO.splitTaxClaimDependantColl(
						appInTaxCollectionToSplit,
						AppConstants.RMC_MODIFIED_RECORD_IND);
//				if (!(appInTaxCollection.size() > 0)) {

					appInTaxCollection.addAll( taxClaimBO.splitTaxClaimDependantColl(
							appInTaxCollectionToSplit,
							AppConstants.CWW_RECORD_IND));
//				}
			}

			CP_APP_IN_TAX_INFORMATION_Collection secondaryColl;

			secondaryColl = taxClaimBO.loadTaxClaimDependantDetails(appNumber,
					indvSeqNum);

			CP_APP_IN_TAX_INFORMATION_Cargo cwwTaxCargo = taxClaimBO
					.splitCTaxClaimDependantColl(secondaryColl,
							AppConstants.CWW_RECORD_IND);
			if (cwwTaxCargo == null) {
				cwwTaxCargo = new CP_APP_IN_TAX_INFORMATION_Cargo();
			}
			if (appInTaxCollectionToSplit != null
					&& appInTaxCollectionToSplit.size() > 1) {
				pageMode = "C";
			} else if (appInTaxCollectionToSplit != null
					&& appInTaxCollectionToSplit.size() == 1
					&& "CW".equals(appInTaxCollectionToSplit.getCargo(0)
							.getSrc_app_ind())) {
				pageMode = "C";
			} else {
				pageMode = FwConstants.NO;
			}
			pageCollection.put("SEC_TAX_DETAIL",
					taxClaimBO.settingDefaultValues(cwwTaxCargo));
			pageCollection.put(
					AppConstants.CP_APP_IN_TAX_INFORMATION_COLLECTION,
					appInTaxCollection);
			// set first name to page collection

			final PeopleHandler peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);
			pageCollection.put(AppConstants.FIRST_NAME,
					peopleHandler.getFirstName(indvSeqNum));
			if(indvSeqNum !=null){
				indvCustCargo =peopleHandler.getIndividual(indvSeqNum);
				if(indvCustCargo!=null){
					sexInd=indvCustCargo.getSex_ind();
					pageCollection.put(AppConstants.SEX_IND, sexInd);
				}					
			}
			pageCollection.put(AppConstants.CURRENT_INDIV_SEQ_NUM, indvSeqNum);
			pageCollection.put("PAGE_MODE", pageMode);
			componentManager.getComponents(currentPageID, txnBean);
			request.remove("loopingQuestion");
			session.put(FwConstants.BEFORE_COLLECTION, pageCollection);
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("loadTaxClaimerDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"loadTaxClaimerDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

		log(ILog.DEBUG,
				"RMCOtherBenefitsEJBBean::loadTaxClaimerDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Store tax claimer details.
	 *
	 * @param txnBean the txn bean
	 */
	public void storeTaxClaimerDetails(final FwTransaction txnBean) {

		final long startTime = System.currentTimeMillis();
		log(ILog.DEBUG,
				"RMCOtherBenefitsEJBBean.storeTaxClaimerDetails() - START");
		log(ILog.INFO, "RMCOtherBenefitsEJBBean::storeTaxClaimerDetails:Start");
		final Map session = txnBean.getSession();
		final Map request = txnBean.getRequest();
		final Map pageCollection = txnBean.getPageCollection();
		int[] driverArray = null;
		String appNumber = null;
		Map beforeColl = null;
		PeopleHandler peopleHandler = null;
		final int currentPageStatus = 0;
		String pageId = null;
		FwMessageList validateInfo = new FwMessageList();

		try {
			// Get the status of the Driver from Session
			driverArray = (int[]) session.get(FwConstants.RMC_DRIVER);
			// Get the current Page Id from the Request
			pageId = (String) request.get(FwConstants.CURRENT_PAGE_ID);
			// Get the APP_NUM from the Session
			appNumber = (String) session.get(AppConstants.APP_NUMBER);
			// Get the before Collection from the Session
			beforeColl = (Map) session.get(FwConstants.BEFORE_COLLECTION);

			// build category selection profile
			final SortedSet categorySelectionProfile = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			// get the BeforeCollection

			final SortedSet inTaxClaimProfile = (SortedSet) beforeColl
					.get(AppConstants.RMC_CATEGORY_PAGE_PRFL);

			final CP_APP_IN_TAX_INFORMATION_Collection appInTaxCollection = (CP_APP_IN_TAX_INFORMATION_Collection) pageCollection
					.get("CP_APP_IN_TAX_INFORMATION_Collection");
			CP_APP_IN_TAX_INFORMATION_Cargo appInCargo = appInTaxCollection
					.getResult(0);

			beforeColl.get(AppConstants.FIRST_NAME);

			final CategorySequenceDetail categorySeqDetailBean = categorySelectionProfileManager
					.getCurrentSequenceDetail(inTaxClaimProfile);

			// Run Validations
			final TaxClaimDependantBO taxClaimBo = new TaxClaimDependantBO();

			request.get(AppConstants.BACK_TO_MY_ACCESS_BUTTON);

			/*
			 * VG SONAR Cleanup - 09/1/2015 Deleted 4,3,1 lines Commented Code
			 * in this block
			 */

			peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);
			final short indvSeqNum = categorySeqDetailBean
					.getIndividualSequence();

			if (checkBackToMyAccessSelected(request)) {

				pageCollection.put(AppConstants.FIRST_NAME,
						beforeColl.get(AppConstants.FIRST_NAME));
				pageCollection.put("CP_APP_IN_TAX_INFORMATION_Collection",
						appInTaxCollection);
				pageCollection.put("PAGE_MODE", beforeColl.get("PAGE_MODE"));
				pageCollection.put(FwConstants.PAGE_COMPONENT_LIST,
						beforeColl.get(FwConstants.PAGE_COMPONENT_LIST));
				pageCollection.put(AppConstants.INDV_SEQUENCE_NUMBERS,
						String.valueOf(indvSeqNum));
				pageCollection.put(AppConstants.CURRENT_INDIV_SEQ_NUM,
						String.valueOf(indvSeqNum));
				pageCollection.put(AppConstants.FIRST_NAME,
						peopleHandler.getFirstName(String.valueOf(indvSeqNum)));
				pageCollection.put(AppConstants.SEX_IND, beforeColl.get(AppConstants.SEX_IND));
				return;
			}

			if (appInTaxCollection != null && !appInTaxCollection.isEmpty()) {
				appInCargo.setApp_num(appNumber);
				appInCargo.setIndv_seq_num(String.valueOf(indvSeqNum));

				validateInfo = taxClaimBo.validateTaxClaimDepDetail(appInCargo,
						peopleHandler);
				if (validateInfo != null && validateInfo.hasMessages()) {
					request.put(FwConstants.MESSAGE_LIST, validateInfo);
										pageCollection.put("CP_APP_IN_TAX_INFORMATION_Collection",
							appInTaxCollection);
					pageCollection.put(FwConstants.PAGE_COMPONENT_LIST,
							beforeColl.get(FwConstants.PAGE_COMPONENT_LIST));
					pageCollection.put(AppConstants.INDV_SEQUENCE_NUMBERS,
							indvSeqNum);
					pageCollection.put(AppConstants.CURRENT_INDIV_SEQ_NUM,
							indvSeqNum);
					pageCollection.put("CurrentPageStatus",
							String.valueOf(currentPageStatus));
					pageCollection.put(AppConstants.FIRST_NAME, peopleHandler
							.getFirstName(String.valueOf(indvSeqNum)));
					pageCollection.put("PAGE_MODE",beforeColl.get("PAGE_MODE"));
					return;
				}
			}

			appInCargo.setApp_num(appNumber);
			appInCargo.setIndv_seq_num(String.valueOf(indvSeqNum));

			final CP_APP_IN_TAX_INFORMATION_Collection beforeAppInTaxColl = (CP_APP_IN_TAX_INFORMATION_Collection) beforeColl
					.get("CP_APP_IN_TAX_INFORMATION_Collection");
			CP_APP_IN_TAX_INFORMATION_Cargo beforeInTaxCargo = null;

			String sourceAppIndicator = null;
			String recordInd = null;

			// now we are checking for the before collection
			boolean inTaxDetailsUpdate = false;

			if (beforeAppInTaxColl != null && !beforeAppInTaxColl.isEmpty()) {
				final int size = beforeAppInTaxColl.size();
				if (size > 1) {
					// if we have two records means cw and rm
					// now we are getting RM record to compare
					// now we need to update the data base if it dirty
					sourceAppIndicator = AppConstants.RMC_MODIFIED_RECORD_IND;
					recordInd = FwConstants.ROWACTION_UPDATE;
					beforeInTaxCargo = taxClaimBo.splitCTaxClaimDependantColl(
							beforeAppInTaxColl, sourceAppIndicator);
				} else {
					// now we are checking this record is CW or RN
					sourceAppIndicator = AppConstants.CWW_RECORD_IND;
					beforeInTaxCargo = taxClaimBo.splitCTaxClaimDependantColl(
							beforeAppInTaxColl, sourceAppIndicator);
					if (beforeInTaxCargo != null) {
						sourceAppIndicator = AppConstants.RMC_MODIFIED_RECORD_IND;
						recordInd = FwConstants.ROWACTION_INSERT;
					} else {
						sourceAppIndicator = AppConstants.RMC_NEW_RECORD_IND;
						recordInd = FwConstants.ROWACTION_UPDATE;
						beforeInTaxCargo = taxClaimBo
								.splitCTaxClaimDependantColl(
										beforeAppInTaxColl, sourceAppIndicator);
					}
				}

				/*
				 * VG SONAR Cleanup - 09/1/2015 Deleted 1 lines Commented Code
				 * in this block
				 */

				// check dirty
				appInCargo = (CP_APP_IN_TAX_INFORMATION_Cargo) isChanged(
						beforeInTaxCargo, appInCargo);

				appInCargo.setSrc_app_ind(sourceAppIndicator);
				appInCargo.setRowAction(recordInd);

				if (appInCargo.isDirty()) {
					inTaxDetailsUpdate = true;
				}
			} else {
				//if there is no before collection means this is new record
				sourceAppIndicator = AppConstants.RMC_NEW_RECORD_IND;
				appInCargo.setSrc_app_ind(sourceAppIndicator);
				recordInd = FwConstants.ROWACTION_INSERT;
				appInCargo.setRowAction(recordInd);
				inTaxDetailsUpdate = true;
				// insert into RMC_SELECTION_PROFILE using Common Mehod()
				/*
				 * VG SONAR Cleanup - 09/1/2015 Deleted 2 looong lines Commented
				 * Code in this block
				 */

			}

			// now we need to check the flags
			if (inTaxDetailsUpdate) {
				taxClaimBo.storeTaxClaimDependantDetails(appInTaxCollection);
			}
			// now i need to update the rmc_in_prfl
			if (categorySeqDetailBean.getChangeSelectionCategoryCd() == null) {

				final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
						.get(AppConstants.RMC_IN_PRFL_MASTER);
				final RMC_IN_PRFL_Cargo rmcInPrflCargo = rmcResponseProfileManager
						.getProfile(rmcInPrflColl, String
								.valueOf(categorySeqDetailBean
										.getIndividualSequence()));
				if (rmcInPrflCargo != null) {
					rmcResponseProfileManager.makeComplete(
							IRMCResponseProfileManager.TAX_CLAIM_DEPENDENT,
							rmcInPrflCargo, true);
				}
			}

			// Mark complete job sequence using common methods
			categorySelectionProfileManager.makeSequenceDetailComplete(
					inTaxClaimProfile, null,
					categorySeqDetailBean.getIndividualSequence(),
					categorySeqDetailBean.getCategorySequence(),
					categorySeqDetailBean.getCategoryType());
			if (categorySelectionProfile != null) {
				categorySelectionProfileManager.makeSequenceDetailComplete(
						categorySelectionProfile, null,
						categorySeqDetailBean.getIndividualSequence(),
						categorySeqDetailBean.getCategorySequence(),
						categorySeqDetailBean.getCategoryType());
			}

			if (categorySelectionProfileManager
					.areAllSequencesComplete(categorySelectionProfile)) {
				driverManager.makeComplete(FwConstants.RMC_DRIVER, pageId,
						driverArray, appNumber);
			} else {
				categorySelectionProfileManager
				.getNextSequenceDetail(categorySelectionProfile);
			}
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::storeTaxClaimerDetails:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("storeTaxClaimerDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"storeTaxClaimerDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.DEBUG,
				"RMCOtherBenefitsEJBBean.storeTaxClaimerDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Load submission details.
	 *
	 * @param txnBean the txn bean
	 */
	/* medicare ends here */
	public void loadSubmissionDetails(final FwTransaction txnBean) {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.loadSubmissionDetails() - START");
		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();

			final String currentPageID = (String) request
					.get(FwConstants.CURRENT_PAGE_ID);

			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			driverManager.getAFBStatus(FwConstants.RMC_DRIVER, currentPageID,
					driverArray);

			log(ILog.INFO, "RMCOtherBenefitsEJBBean::loadSubmissionDetails:End");

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("getMedicareDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"loadSubmissionDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.loadSubmissionDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Comment here.
	 *
	 * @param txnBean the txn bean
	 */
	public void storeSubmissionDetails(final FwTransaction txnBean) {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.storeSubmissionDetails() - START");
		String appNumber = null;
		try {
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::storeSubmissionDetails:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();

			final String currentPageID = (String) request
					.get(FwConstants.CURRENT_PAGE_ID);
			appNumber = (String) session.get(AppConstants.APP_NUMBER);

			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			final int driverStatus = driverManager.getAFBStatus(
					FwConstants.RMC_DRIVER, currentPageID, driverArray);
			if (driverStatus != FwConstants.DRIVER_COMPLETE) {
				driverManager.makeComplete(FwConstants.RMC_DRIVER,
						currentPageID, driverArray, appNumber);

			}
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::storeSubmissionDetails:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("storeSubmissionDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"storeSubmissionDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.storeSubmissionDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Load convicted.
	 *
	 * @param txnBean the txn bean
	 */
	public void loadConvicted(final FwTransaction txnBean) {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.loadConvicted() - START");
		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();

			APP_IN_FELON_DET_Collection appInFelColl;
			final String appNumber = (String) session
					.get(AppConstants.APP_NUMBER);

			final String pageId = (String) request
					.get(FwConstants.CURRENT_PAGE_ID);

			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			final int pageStatus = driverManager.getAFBStatus(
					FwConstants.RMC_DRIVER, pageId, driverArray);

			SortedSet categorySelectionProfile = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			final String previousPageId = (String) request
					.get(FwConstants.PREVIOUS_PAGE_ID);

			final Map type = new HashMap<String, String>();
			type.put(AppConstants.CONVICTION, AppConstants.CONVICTION);

			if (pageStatus == FwConstants.DRIVER_REQUIRED
					|| pageStatus == FwConstants.DRIVER_VISIT_AGAIN
					&& categorySelectionProfileManager.isEmpty(
							categorySelectionProfile, type)) {
				categorySelectionProfile = categorySelectionProfileManager
						.loadCategoryChangeSelectionProfile(appNumber,
								AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL);
			}
			/*
			 * VG SONAR Cleanup - 09/1/2015 Changed Commented code block to
			 * javadoc
			 */
			/**
			 * else if (pageStatus == FwConstants.DRIVER_COMPLETE &&
			 * !pageId.equals(previousPageId) &&
			 * categorySelectionProfileManager.isEmpty(
			 * categorySelectionProfile, type)) { categorySelectionProfile =
			 * categorySelectionProfileManager
			 * .loadCategoryChangeSelectionProfile(appNumber,
			 * AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL); }
			 */

			Map beforeColl = (Map) session.get(FwConstants.BEFORE_COLLECTION);
			final ABHouseHoldMemberBO abHouseholdMemberBo = new ABHouseHoldMemberBO();
			final short[] responseType = new short[] { IRMCResponseProfileManager.AVOID_PROSC_RESP };
			SortedSet convictionProfile = null;
			if (!pageId.equals(previousPageId)) {
				convictionProfile = createPageProfile(categorySelectionProfile,
						rmcInPrflColl, responseType);
				if (pageStatus != FwConstants.DRIVER_REQUIRED) {
					final APP_IN_FELON_DET_Collection newFelnColl = abHouseholdMemberBo
							.loadConvictionDetails(appNumber);
					if (newFelnColl != null && !newFelnColl.isEmpty()) {
						APP_IN_FELON_DET_Cargo appInFelCargo = null;
						final int newFelnCollSize = newFelnColl.size();
						for (int i = 0; i < newFelnCollSize; i++) {
							appInFelCargo = newFelnColl.getCargo(i);
							categorySelectionProfileManager
							.insertExistingSequenceDetail(
									convictionProfile, null, null,
									Short.parseShort(appInFelCargo
											.getIndv_seq_num()), Long
											.parseLong(appInFelCargo
													.getSeq_num()),
													AppConstants.CONVICTION);
						}
					}
				}
				if (pageStatus == FwConstants.DRIVER_REQUIRED
						|| pageStatus == FwConstants.DRIVER_VISIT_AGAIN) {
					// set the current record indicator to the first one
					categorySelectionProfileManager
					.setCurrentRecordIndToFirst(convictionProfile);
				}
				if (pageStatus == FwConstants.DRIVER_COMPLETE) {
					// set the current record indicator to the end of the detail
					// bean
					categorySelectionProfileManager
					.setCurrentRecordIndToLast(convictionProfile);
				}
				// create add new sorted set
				// we need to remove the vallues from the session
				session.remove(FwConstants.BEFORE_COLLECTION);
			} else {
				// catAddNewProfile get it from the before collection
				beforeColl = (Map) session.get(FwConstants.BEFORE_COLLECTION);
				convictionProfile = (SortedSet) beforeColl
						.get(AppConstants.RMC_CATEGORY_PAGE_PRFL);
			}


			
			final IndivTypeSeqBean indivSeqBean = (IndivTypeSeqBean) pageCollection
					.get(FwConstants.DETAIL_KEY_BEAN);

			if (indivSeqBean != null) {
				final CategorySequenceDetail categorySeqDetail1 = categorySelectionProfileManager
						.getCategorySequenceDetail(
								convictionProfile,
								Short.parseShort(indivSeqBean.getIndivSeqNum()),
								Long.parseLong(indivSeqBean.getSeqNum()),
								indivSeqBean.getType());
				if (categorySeqDetail1 != null) {

					if (categorySeqDetail1.getUserEndSelectionInd() != Short
							.parseShort(indivSeqBean.getUserEndInd())) {
						categorySelectionProfileManager
						.updateUserEndSelInd(
								convictionProfile,
								appNumber,
								Short.parseShort(indivSeqBean
										.getIndivSeqNum()),
										Long.parseLong(indivSeqBean.getSeqNum()),
										indivSeqBean.getType(), Short
										.parseShort(indivSeqBean
												.getUserEndInd()));
					}
					categorySelectionProfileManager.makeSequenceDetailRequired(
							convictionProfile, null,
							Short.parseShort(indivSeqBean.getIndivSeqNum()),
							Long.parseLong(indivSeqBean.getSeqNum()),
							indivSeqBean.getType());
					final CategorySequenceDetail categorySeqDetail2 = categorySelectionProfileManager
							.getCategorySequenceDetail(
									categorySelectionProfile, Short
									.parseShort(indivSeqBean
											.getIndivSeqNum()),
											Long.parseLong(indivSeqBean.getSeqNum()),
											indivSeqBean.getType());
					if (categorySeqDetail2 != null) {
						if (categorySeqDetail2.getUserEndSelectionInd() != Short
								.parseShort(indivSeqBean.getUserEndInd())) {
							categorySelectionProfileManager
							.updateUserEndSelInd(
									categorySelectionProfile,
									appNumber, Short
									.parseShort(indivSeqBean
											.getIndivSeqNum()),
											Long.parseLong(indivSeqBean
													.getSeqNum()), indivSeqBean
													.getType(), Short
													.parseShort(indivSeqBean
															.getUserEndInd()));
						}
						categorySelectionProfileManager
						.makeSequenceDetailRequired(
								categorySelectionProfile, appNumber,
								Short.parseShort(indivSeqBean
										.getIndivSeqNum()), Long
										.parseLong(indivSeqBean
												.getSeqNum()),
												indivSeqBean.getType());
					}

				} else {
					if (FwConstants.ZERO.equals(indivSeqBean.getSeqNum())) {
						// first we are checking rmc in profile exists in the
						// sess
						RMC_IN_PRFL_Cargo rmcInPrflCargo = null;
						if (rmcInPrflColl != null) {
							rmcInPrflCargo = rmcResponseProfileManager
									.getProfile(rmcInPrflColl,
											indivSeqBean.getIndivSeqNum());
						} else {
							rmcInPrflColl = new RMC_IN_PRFL_Collection();
						}
						if (rmcInPrflCargo == null) {
							rmcInPrflCargo = new RMC_IN_PRFL_Cargo();
							rmcInPrflCargo.setApp_num(appNumber);
							rmcInPrflCargo.setIndv_seq_num(indivSeqBean
									.getIndivSeqNum());
							rmcResponseProfileManager
							.createRMCIndividualProfile(rmcInPrflCargo);
							rmcInPrflColl.addCargo(rmcInPrflCargo);
						}
						// now we need to make required
						if (AppConstants.CONVICTION.equals(indivSeqBean
								.getType())) {
							rmcResponseProfileManager
							.makeAddNew(
									IRMCResponseProfileManager.AVOID_PROSC_RESP,
									rmcInPrflCargo, true);
						}

						categorySelectionProfileManager
						.insertSequenceDetail(convictionProfile, appNumber,
								AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL, Short.parseShort(indivSeqBean
										.getIndivSeqNum()),
										indivSeqBean.getType());
						session.put(AppConstants.RMC_IN_PRFL_MASTER,
								rmcInPrflColl);
					} else {
						String userEndInd = indivSeqBean.getUserEndInd();
						if (userEndInd == null) {
							userEndInd = FwConstants.ZERO;
						}
						categorySelectionProfileManager
						.insertSequenceDetail(convictionProfile, null,
								AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL, Short
								.parseShort(indivSeqBean
										.getIndivSeqNum()),
										Short.parseShort(indivSeqBean
												.getSeqNum()), indivSeqBean
												.getType(), Short
												.parseShort(userEndInd));
						categorySelectionProfileManager
						.makeSequenceDetailRequired(convictionProfile,
								null, Short.parseShort(indivSeqBean
										.getIndivSeqNum()), Short
										.parseShort(indivSeqBean
												.getSeqNum()),
												indivSeqBean.getType());

						categorySelectionProfileManager
						.insertSequenceDetail(categorySelectionProfile,
								appNumber,
								AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL, Short
								.parseShort(indivSeqBean
										.getIndivSeqNum()),
										Short.parseShort(indivSeqBean
												.getSeqNum()), indivSeqBean
												.getType(), Short
												.parseShort(userEndInd));
						categorySelectionProfileManager
						.makeSequenceDetailRequired(
								categorySelectionProfile, appNumber,
								Short.parseShort(indivSeqBean
										.getIndivSeqNum()), Short
										.parseShort(indivSeqBean
												.getSeqNum()),
												indivSeqBean.getType());
					}
				}
			}



			pageCollection.put(AppConstants.RMC_CATEGORY_PAGE_PRFL,
					convictionProfile);

			CategorySequenceDetail categorySeqDetail = categorySelectionProfileManager
					.getCurrentSequenceDetail(convictionProfile);
			if (categorySeqDetail == null) {
				categorySeqDetail = categorySelectionProfileManager
						.getNextSequenceDetail(convictionProfile);
			}
			final String categoryType = categorySeqDetail.getCategoryType();
			final String categorySeqNum = Long.toString(categorySeqDetail
					.getCategorySequence());

			final String indvSeqNum = Short.toString(categorySeqDetail
					.getIndividualSequence());

			pageCollection.put("END_PAGE_IND",
					String.valueOf(categorySeqDetail.getUserEndSelectionInd()));

			appInFelColl = abHouseholdMemberBo.loadDetails(appNumber,
					indvSeqNum, categorySeqNum);

			APP_IN_FELON_DET_Cargo appInFelCargo = null;
			String pageMode = null;

			if (appInFelColl != null && !appInFelColl.isEmpty()) {
				appInFelCargo = appInFelColl.getCargo(0);
			}

			APP_IN_FELON_DET_Cargo cwwFelCargo = splitFelColl(appInFelColl,
					AppConstants.CWW_RECORD_IND);
			if (cwwFelCargo == null) {
				cwwFelCargo = new APP_IN_FELON_DET_Cargo();
			}

			APP_IN_FELON_DET_Cargo rmcFelCargo = splitFelColl(appInFelColl,
					AppConstants.RMC_NEW_RECORD_IND);
			if (appInFelCargo != null
					&& ("CW".equalsIgnoreCase(appInFelCargo.getSrc_app_ind()) || "RM"
							.equalsIgnoreCase(appInFelCargo.getSrc_app_ind()))
							&& categorySeqDetail.getUserEndSelectionInd() == 0) {
				pageMode = "C";

			} else if (categorySeqDetail.getUserEndSelectionInd() == 1) {
				pageMode = "E";
			} else {
				pageMode = FwConstants.NO;

			}


			if (rmcFelCargo != null) {

				pageCollection.put("FST_EMPL",
						settingDefaultValues(rmcFelCargo));
			} else {
				rmcFelCargo = splitFelColl(appInFelColl,
						AppConstants.RMC_MODIFIED_RECORD_IND);
				if (rmcFelCargo != null) {
					pageCollection.put("FST_EMPL",
							settingDefaultValues(rmcFelCargo));
				} else {
					rmcFelCargo = splitFelColl(appInFelColl,
							AppConstants.RMC_END_RECORD_IND);
					if (rmcFelCargo != null) {
						pageCollection.put("FST_EMPL",
								settingDefaultValues(rmcFelCargo));
					} else {
						pageCollection.put("FST_EMPL",
								settingDefaultValues(cwwFelCargo));
					}
				}
			}

			String srcAppInd = FwConstants.EMPTY_STRING;
			if (appInFelColl != null && !appInFelColl.isEmpty()) {
				final APP_IN_FELON_DET_Cargo rmcInFelCargo = appInFelColl
						.getCargo(0);
				srcAppInd = rmcInFelCargo.getSrc_app_ind();
			}
			if (("CW".equalsIgnoreCase(srcAppInd) || "RM"
					.equalsIgnoreCase(srcAppInd))
					&& categorySeqDetail.getUserEndSelectionInd() == 0) {
				pageMode = "C";
			}

			if (categorySeqDetail.getUserEndSelectionInd() == 1)

			{
				pageMode = "E";
			} else if (indivSeqBean != null
					&& indivSeqBean.getUserEndInd() != null) {
				if (FwConstants.ONE.equalsIgnoreCase(indivSeqBean
						.getUserEndInd()))

				{
					pageMode = "E";
				} else if (FwConstants.ZERO
						.equals(indivSeqBean.getUserEndInd())
						&& "RM".equalsIgnoreCase(srcAppInd)
						|| "CW".equalsIgnoreCase(srcAppInd)) {
					pageMode = "C";
				} else {
					pageMode = FwConstants.NO;
				}
			} else if (!("C".equalsIgnoreCase(pageMode) || "E"
					.equalsIgnoreCase(pageMode))) {
				pageMode = FwConstants.NO;
			}

			if ("C".equals(pageMode)) {
				pageCollection.put("SEC_EMPL",
						settingDefaultValues(cwwFelCargo));
			}

			pageCollection.put("APP_IN_FELON_DET_Collection", appInFelColl);
			rmcInPrflColl.size();
			char typeStatus = 'N';
			String showLoopingQuestionFlag = FwConstants.YES;

			typeStatus = categorySeqDetail.getStatus();
			if (typeStatus == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
					|| typeStatus == IRMCResponseProfileManager.STATUS_COMPLETE) {
				showLoopingQuestionFlag = FwConstants.NO;
			}

			pageCollection.put(AppConstants.SHOW_LOOPING_QUESTION,
					showLoopingQuestionFlag);

			pageCollection.put("PAGE_MODE", pageMode);
			pageCollection.put(AppConstants.CONVICTION, categoryType);

			final PeopleHandler peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);
			pageCollection.put(AppConstants.FIRST_NAME,
					peopleHandler.getFirstName(indvSeqNum));

			componentManager.getComponents(AppConstants.ARCFN, txnBean);
			request.remove(AppConstants.LOOPING_QUESTION);
			// Add the page collection to before collection
			session.put(FwConstants.BEFORE_COLLECTION, pageCollection);

			log(ILog.INFO, "RMCOtherBenefitsEJBBean::loadConvicted:End");

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("loadConvicted");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"loadConvicted", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.loadConvicted() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Comment here.
	 *
	 * @param txnBean the txn bean
	 */
	public void storeConvicted(final FwTransaction txnBean) {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.storeConvicted() - START");
		String appNumber = null;
		try {

			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();

			final String currentPageID = (String) request
					.get(FwConstants.CURRENT_PAGE_ID);
			appNumber = (String) session.get(AppConstants.APP_NUMBER);
			// build category selection profile
			final SortedSet categorySelectionProfile = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			// get the BeforeCollection
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);

			final APP_IN_FELON_DET_Collection appInFelnCollection = (APP_IN_FELON_DET_Collection) pageCollection
					.get("APP_IN_FELON_DET_Collection");
			if (appInFelnCollection.size() > 1) {
				appInFelnCollection.remove(1);
			}
			APP_IN_FELON_DET_Cargo appInFelnCargo = appInFelnCollection
					.getCargo(0);

			final SortedSet felnCnvtnProfile = (SortedSet) beforeColl
					.get(AppConstants.RMC_CATEGORY_PAGE_PRFL);
			final CategorySequenceDetail categorySeqDetailBean = categorySelectionProfileManager
					.getCurrentSequenceDetail(felnCnvtnProfile);
			final short userEndInd = categorySeqDetailBean
					.getUserEndSelectionInd();

			final ABHouseHoldMemberBO abHouseHoldMemberBO = new ABHouseHoldMemberBO();

			final APP_IN_FELON_DET_Collection beforeCollAppInFelnColl = (APP_IN_FELON_DET_Collection) beforeColl
					.get("APP_IN_FELON_DET_Collection");
			APP_IN_FELON_DET_Cargo beforeFelnCargo = null;

			appInFelnCargo.setApp_num(appNumber);

			final String indvSeqNum = String.valueOf(categorySeqDetailBean
					.getIndividualSequence());
			String sourceAppIndicator = null;
			String recordInd = null;

			// now we are checking for the before collection
			long seqNum = 0;
			boolean felnDetailsUpdate = false;

			if (beforeCollAppInFelnColl != null
					&& !beforeCollAppInFelnColl.isEmpty()) {
				final int size = beforeCollAppInFelnColl.size();
				seqNum = categorySeqDetailBean.getCategorySequence();
				if (size > 1) {
					// if we have two records means cw and rm
					// now we are getting RM record to compare
					// now we need to update the data base if it dirty
					sourceAppIndicator = AppConstants.RMC_MODIFIED_RECORD_IND;
					recordInd = FwConstants.ROWACTION_UPDATE;
					beforeFelnCargo = splitFelColl(beforeCollAppInFelnColl,
							sourceAppIndicator);
					if (beforeFelnCargo == null) {
						sourceAppIndicator = AppConstants.RMC_END_RECORD_IND;
						recordInd = FwConstants.ROWACTION_UPDATE;
						beforeFelnCargo = splitFelColl(beforeCollAppInFelnColl,
								sourceAppIndicator);
					}

				} else {
					// now we are checking this record is CW or RN
					beforeFelnCargo = splitFelColl(beforeCollAppInFelnColl,
							AppConstants.CWW_RECORD_IND);
					if (beforeFelnCargo != null) {
						if (userEndInd == 1) {
							sourceAppIndicator = AppConstants.RMC_END_RECORD_IND;
							recordInd = FwConstants.ROWACTION_INSERT;

						} else {
							sourceAppIndicator = AppConstants.RMC_MODIFIED_RECORD_IND;
							recordInd = FwConstants.ROWACTION_INSERT;
						}
					} else {
						sourceAppIndicator = AppConstants.RMC_NEW_RECORD_IND;
						recordInd = FwConstants.ROWACTION_UPDATE;
						beforeFelnCargo = splitFelColl(beforeCollAppInFelnColl,
								sourceAppIndicator);
					}
				}
				if(beforeFelnCargo != null){
					appInFelnCargo.setSrc_app_ind(beforeFelnCargo.getSrc_app_ind());
					appInFelnCargo.setIndv_seq_num(beforeFelnCargo
							.getIndv_seq_num());
					if (!AppConstants.RMC_NEW_RECORD_IND
							.equalsIgnoreCase(sourceAppIndicator)) {
						appInFelnCargo.setSeq_num(beforeFelnCargo.getSeq_num());
					}
					appInFelnCargo.setRec_cplt_ind(beforeFelnCargo
							.getRec_cplt_ind());
					// PCR 30727 - In Edit mode, end date is not populated from the
					// screen. Hence populating it from beforeCargo.
					if (sourceAppIndicator == AppConstants.RMC_MODIFIED_RECORD_IND
							|| sourceAppIndicator == AppConstants.RMC_END_RECORD_IND) {
						appInFelnCargo.setEcp_id(beforeFelnCargo.getEcp_id());
					}
					appInFelnCargo = (APP_IN_FELON_DET_Cargo) isChanged(
							beforeFelnCargo, appInFelnCargo);

					appInFelnCargo.setRec_cplt_ind(FwConstants.ONE);
					appInFelnCargo.setSrc_app_ind(sourceAppIndicator);
					appInFelnCargo.setSeq_num(beforeFelnCargo.getSeq_num());
				}// end of null check 
				
				appInFelnCargo.setRowAction(recordInd);
				if (appInFelnCargo.isDirty()) {
					felnDetailsUpdate = true;
				}
			} else {
				// if there is no before collection means this is new record
				sourceAppIndicator = AppConstants.RMC_NEW_RECORD_IND;
				appInFelnCargo
				.setIndv_seq_num(String.valueOf(categorySeqDetailBean
						.getIndividualSequence()));
				// get the MAX seq number from data base
				seqNum = abHouseHoldMemberBO.getMaxFelnSeqNumber(appNumber,
						indvSeqNum);
				seqNum = seqNum + 1;
				appInFelnCargo.setSeq_num(String.valueOf(seqNum));

				appInFelnCargo.setSrc_app_ind(sourceAppIndicator);
				recordInd = FwConstants.ROWACTION_INSERT;
				appInFelnCargo.setRowAction(recordInd);
				felnDetailsUpdate = true;
				// insert into RMC_SELECTION_PROFILE using Common Mehod()
				categorySelectionProfileManager.updateSequence(
						felnCnvtnProfile, null,
						categorySeqDetailBean.getIndividualSequence(), seqNum,
						categorySeqDetailBean.getCategoryType());
				categorySelectionProfileManager.updateSequence(categorySelectionProfile, null, categorySeqDetailBean.getIndividualSequence(), seqNum, categorySeqDetailBean.getCategoryType());
				if(null!=categorySeqDetailBean.getChangeSelectionCategoryCd())
				{
				categorySelectionProfileManager.persistSequence(appNumber, categorySeqDetailBean.getChangeSelectionCategoryCd(), String.valueOf(categorySeqDetailBean.getIndividualSequence()), String.valueOf(seqNum), categorySeqDetailBean.getCategoryType(), "0");
				}
			}

			final String backToMyAccess = (String) request
					.get(AppConstants.BACK_TO_MY_ACCESS_BUTTON);

			if (backToMyAccess == null) {
				final String loopingQuestionResponse = (String) request
						.get("loopingQuestion");
				beforeColl.get(AppConstants.SHOW_LOOPING_QUESTION);
				if (loopingQuestionResponse != null) {
					if (AppConstants.YES.equals(loopingQuestionResponse)
							|| AppConstants.NO.equals(loopingQuestionResponse)) {
					}
				}

			}

			final String showLoopingQuestionFlag = (String) beforeColl
					.get(AppConstants.SHOW_LOOPING_QUESTION);
			final String pageMode = beforeColl.get("PAGE_MODE")!= null ? (String) beforeColl.get("PAGE_MODE"):"";
			abHouseHoldMemberBO.validateConvictedFelon(appInFelnCargo,
					showLoopingQuestionFlag, pageMode);

			if (checkBackToMyAccessSelected(request)
					|| abHouseHoldMemberBO.hasMessages()) {
				final String reqWarningMsgs = (String) request
						.get(FwConstants.WARNING_MSG_DETAILS);
				if (!checkForWarningMesgs(reqWarningMsgs,
						abHouseHoldMemberBO.getMessageList())) {
					if (backToMyAccess == null) {
						request.put(FwConstants.MESSAGE_LIST,
								abHouseHoldMemberBO.getMessageList());
					}

					beforeColl.get("APP_IN_FELON_DET_Collection");

					pageCollection.put(AppConstants.FIRST_NAME,
							beforeColl.get(AppConstants.FIRST_NAME));
					if (request.get(AppConstants.LOOPING_QUESTION) != null) {
						request.put(AppConstants.LOOPING_QUESTION,
								request.get(AppConstants.LOOPING_QUESTION));
					}

					pageCollection.put(AppConstants.SHOW_LOOPING_QUESTION,
							beforeColl.get(AppConstants.SHOW_LOOPING_QUESTION));
					pageCollection.put(FwConstants.PAGE_COMPONENT_LIST,
							beforeColl.get(FwConstants.PAGE_COMPONENT_LIST));

					if (beforeColl.containsKey("SEC_EMPL")) {
						pageCollection.put("SEC_EMPL",
								beforeColl.get("SEC_EMPL"));
					}
					pageCollection.put("FST_EMPL", appInFelnCargo);
					pageCollection.put("APP_IN_FELON_DET_Collection",
							appInFelnCollection);
					pageCollection.put("END_PAGE_IND",
							beforeColl.get("END_PAGE_IND"));
					pageCollection
					.put("PAGE_MODE", beforeColl.get("PAGE_MODE"));
					return;
				}
			}

			// now we need to check the flags
			if (userEndInd == 0 && felnDetailsUpdate) {
				// check for the change effective date
				// if they did't fill this one raise validation
				if (!AppConstants.RMC_NEW_RECORD_IND.equals(sourceAppIndicator)) {
					// EDSP validation
					if (abHouseHoldMemberBO.hasMessages()) {
						final String reqWarningMsgs = (String) request
								.get(FwConstants.WARNING_MSG_DETAILS);
						if (!checkForWarningMesgs(reqWarningMsgs,
								abHouseHoldMemberBO.getMessageList())) {
							request.put(FwConstants.MESSAGE_LIST,
									abHouseHoldMemberBO.getMessageList());

							pageCollection.put(AppConstants.FIRST_NAME,
									beforeColl.get(AppConstants.FIRST_NAME));
							if (request.get(AppConstants.LOOPING_QUESTION) != null) {
								request.put(
										AppConstants.LOOPING_QUESTION,
										request.get(AppConstants.LOOPING_QUESTION));
							}
							pageCollection
							.put(FwConstants.PAGE_COMPONENT_LIST,
									beforeColl
									.get(FwConstants.PAGE_COMPONENT_LIST));

							if (beforeColl.containsKey("SEC_EMPL")) {
								pageCollection.put("SEC_EMPL",
										beforeColl.get("SEC_EMPL"));
							}
							pageCollection.put("FST_EMPL", appInFelnCargo);
							pageCollection.put("END_PAGE_IND",
									beforeColl.get("END_PAGE_IND"));
							return;
						}
					}
				}
			}

			if (appInFelnCargo.getConviction_date() != null
					&& appInFelnCargo.getConviction_date().trim().length() != 0
					&& appInFelnCargo.getConviction_date().length() == 10
					&& appInFelnCargo.getConviction_date().charAt(2) == '/'

					) {
				final StringBuilder dateConverter = new StringBuilder();
				final String sAppDate = appInFelnCargo.getConviction_date();
				dateConverter.append(sAppDate.substring(6, 10)).append("-")
				.append(sAppDate.substring(0, 2)).append("-")
				.append(sAppDate.substring(3, 5));
				appInFelnCargo.setConviction_date(dateConverter.toString());
			}

			if (felnDetailsUpdate) {
				if (FwConstants.ROWACTION_INSERT.equals(appInFelnCargo
						.getRowAction())) {
					abHouseHoldMemberBO
					.insertExistingDetails(appInFelnCollection);
				} else {
					abHouseHoldMemberBO.storeDetails(appInFelnCollection);
				}
			}

			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			boolean loopingQuestion = false;
			if (appInFelnCargo.getLoopingInd() != null
					&& FwConstants.YES.equalsIgnoreCase(appInFelnCargo
							.getLoopingInd())) {
				loopingQuestion = true;
				// Insert into APP_IN_EMPL and APP_IN_EMPL_A_WAGE
				categorySelectionProfileManager.insertSequenceDetail(
						felnCnvtnProfile, null, null,
						categorySeqDetailBean.getIndividualSequence(),
						categorySeqDetailBean.getCategoryType());
				driverManager.makeRequired(FwConstants.RMC_DRIVER,
						currentPageID, driverArray, appNumber);

			}
			
			//reqInd is indicator to decide if we have complete the response profile or not
			boolean reqInd=false;
			// now i need to update the rmc_in_prfl if looping question is null			
			if (!loopingQuestion) {
				short respTyp=rmcResponseProfileManager
						.getResponseByType(
								IRMCResponseProfileManager.AVOID_PROSC_RESP,
								categorySeqDetailBean
								.getCategoryType());
				final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
						.get(AppConstants.RMC_IN_PRFL_MASTER);
				final RMC_IN_PRFL_Cargo rmcInPrflCargo = rmcResponseProfileManager
						.getProfile(rmcInPrflColl, String
								.valueOf(categorySeqDetailBean
										.getIndividualSequence()));
				if (rmcInPrflCargo != null && rmcResponseProfileManager.getProfileResponse(
						rmcInPrflCargo, respTyp).charAt(0) == IRMCResponseProfileManager.STATUS_REQUIRED) {
					reqInd=true;
					rmcResponseProfileManager
					.makeComplete(
							rmcResponseProfileManager
							.getResponseByType(
									IRMCResponseProfileManager.AVOID_PROSC_RESP,
									categorySeqDetailBean
									.getCategoryType()),
									rmcInPrflCargo, true);
				}
			}
			// Mark complete job sequence using common methods
			//if the profile response was not 'R' or if we came from gatepost then don't persist else persist
			if(!reqInd || categorySeqDetailBean.getChangeSelectionCategoryCd()==null)
			{
			categorySelectionProfileManager.makeSequenceDetailComplete(
					felnCnvtnProfile, null,
					categorySeqDetailBean.getIndividualSequence(),
					categorySeqDetailBean.getCategorySequence(),
					categorySeqDetailBean.getCategoryType());
			}else{
			categorySelectionProfileManager.makeSequenceDetailComplete(
									felnCnvtnProfile, appNumber,
									categorySeqDetailBean.getIndividualSequence(),
									categorySeqDetailBean.getCategorySequence(),
									categorySeqDetailBean.getCategoryType());
			}
			if (categorySelectionProfile != null) {
				categorySelectionProfileManager.makeSequenceDetailComplete(
						categorySelectionProfile, appNumber,
						categorySeqDetailBean.getIndividualSequence(),
						categorySeqDetailBean.getCategorySequence(),
						categorySeqDetailBean.getCategoryType());
			}

			if (categorySelectionProfileManager
					.areAllSequencesComplete(felnCnvtnProfile)) {
				driverManager.makeComplete(FwConstants.RMC_DRIVER,
						currentPageID, driverArray, appNumber);
			} else {
				categorySelectionProfileManager
				.getNextSequenceDetail(felnCnvtnProfile);
			}

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("storeConvicted");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"storeConvicted", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.storeConvicted() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * Split fel coll.
	 *
	 * @param felColl the fel coll
	 * @param recordIndicator the record indicator
	 * @return the AP p_ i n_ felo n_ de t_ cargo
	 */
	private APP_IN_FELON_DET_Cargo splitFelColl(
			final APP_IN_FELON_DET_Collection felColl,
			final String recordIndicator) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.splitFelColl() - START");
		try {
			if (felColl != null && !felColl.isEmpty()) {
				final int felCollSize = felColl.size();
				APP_IN_FELON_DET_Cargo felCargo = null;
				for (int i = 0; i < felCollSize; i++) {
					felCargo = felColl.getCargo(i);
					if (felCargo.getSrc_app_ind().equals(recordIndicator)) {
						return felColl.getCargo(i);
					}
				}

			}

			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean.splitFelColl() - END , Time Taken : "
							+ (System.currentTimeMillis() - startTime)
							+ AppConstants.SPACE + AppConstants.MILLISECONDS);
			return null;
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("splitFelColl");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"splitFelColl", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
	}

	/**
	 * Setting default values.
	 *
	 * @param felCargo the fel cargo
	 * @return the AP p_ i n_ felo n_ de t_ cargo
	 */
	private APP_IN_FELON_DET_Cargo settingDefaultValues(
			final APP_IN_FELON_DET_Cargo felCargo) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.settingDefaultValues() - START");
		try {
			if (felCargo != null) {
				// initialize date fields
				if (felCargo.getConviction_date() == null) {
					felCargo.setConviction_date(FwConstants.EMPTY_STRING);
				}
			}

			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean.settingDefaultValues() - END , Time Taken : "
							+ (System.currentTimeMillis() - startTime)
							+ AppConstants.SPACE + AppConstants.MILLISECONDS);
			return felCargo;
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("settingDefaultValues");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"settingDefaultValues", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
	}

	/**
	 * edit.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 * @throws javax.ejb.EJBException the javax.ejb. ejb exception
	 */
	public void editFelonyConviction(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.editFelonyConviction() - START");
		try {
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::editFelonyConviction:Start");
			final Map session = txnBean.getSession();
			final Map pageCollection = txnBean.getPageCollection();
			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			final APP_IN_FELON_DET_Collection felConvtColl = (APP_IN_FELON_DET_Collection) pageCollection
					.get("APP_IN_FELON_DET_Collection");
			final APP_IN_FELON_DET_Cargo felConvtCargo = felConvtColl
					.getCargo(0);

			final IndivTypeSeqBean seqBean = new IndivTypeSeqBean();
			seqBean.setIndivSeqNum(felConvtCargo.getIndv_seq_num());
			seqBean.setSeqNum(felConvtCargo.getSeq_num());
			seqBean.setType(AppConstants.CONVICTION);
			seqBean.setUserEndInd(AppConstants.ZERO);
			pageCollection.put(FwConstants.DETAIL_KEY_BEAN, seqBean);
			// Get App Number
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			// Set RMC page Job Income Details make required
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARCFN",
					driverArray, appNum);
			driverManager.makeRequired(FwConstants.RMC_DRIVER,
					AppConstants.AROBS, driverArray, appNum);
			// End
			log(ILog.INFO, "RMCOtherBenefitsEJBBean::editFelonyConviction:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("editFelonyConviction");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"editFelonyConviction", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.editFelonyConviction() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

	/**
	 * Erase felony conviction.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void eraseFelonyConviction(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.eraseFelonyConviction() - START");
		try {
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::eraseFelonyConviction:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);

			// Get RMCSessionBean from the session

			// Define IndvSeqNum and the SeqNum and Type and RowNum
			String indvSeqNum = null;
			String seqNum = null;
			String type = null;

			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);

			final APP_IN_FELON_DET_Collection felnCnvtnColl = (APP_IN_FELON_DET_Collection) pageCollection
					.get("APP_IN_FELON_DET_Collection");
			final APP_IN_FELON_DET_Cargo felnCnvtnCargo = felnCnvtnColl
					.getCargo(0);

			final String appNum = (String) session.get(AppConstants.APP_NUMBER);

			// delete record from rmc selection profile
			final SortedSet rmcSelPrfl = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);

			indvSeqNum = felnCnvtnCargo.getIndv_seq_num();
			seqNum = felnCnvtnCargo.getSeq_num();
			type = AppConstants.CONVICTION;
			APP_IN_FELON_DET_Cargo beforeFelnCnvtnCargo = (APP_IN_FELON_DET_Cargo) beforeColl
					.get("APP_IN_FELON_DET_Cargo");

			final IndivTypeSeqBean indivTypeSeqBean = new IndivTypeSeqBean();
			indivTypeSeqBean.setIndivSeqNum(indvSeqNum);
			indivTypeSeqBean.setSeqNum(seqNum);
			indivTypeSeqBean.setType(type);
			final IndivTypeSeqBean postIndivSeqBean = (IndivTypeSeqBean) beforeColl
					.get(AppConstants.INDV_TYPE_SEQ_BEAN);
			boolean eraseData = false;

			if (postIndivSeqBean != null) {
				if (postIndivSeqBean.getIndivSeqNum().equals(
						indivTypeSeqBean.getIndivSeqNum())
						&& postIndivSeqBean.getSeqNum().equals(
								indivTypeSeqBean.getSeqNum())
								&& postIndivSeqBean.getType().equals(
										indivTypeSeqBean.getType())) {
					eraseData = true;
				}
			}

			final ABHouseHoldMemberBO abHouseHoldMemberBO = new ABHouseHoldMemberBO();
			if (beforeFelnCnvtnCargo == null
					|| felnCnvtnCargo.isDifferent(beforeFelnCnvtnCargo)
					|| !eraseData) {
				abHouseHoldMemberBO.validateCnvtnErase();
				request.put(FwConstants.MESSAGE_LIST,
						abHouseHoldMemberBO.getMessageList());
				beforeFelnCnvtnCargo = new APP_IN_FELON_DET_Cargo();
				beforeFelnCnvtnCargo.setIndv_seq_num(indvSeqNum);
				beforeFelnCnvtnCargo.setSeq_num(seqNum);
				beforeColl.put("APP_IN_FELON_DET_Cargo", beforeFelnCnvtnCargo);
				beforeColl.put(AppConstants.INDV_TYPE_SEQ_BEAN,
						indivTypeSeqBean);
				txnBean.setPageCollection(beforeColl);
				return;
			}
			// delete record from database
			abHouseHoldMemberBO.deleteRecords(indvSeqNum, seqNum, appNum);
			categorySelectionProfileManager.removeSequenceDetail(rmcSelPrfl,
					appNum, Short.parseShort(indvSeqNum),
					Long.parseLong(seqNum),
					AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL,
					AppConstants.CONVICTION);

			final Map catType = new HashMap();
			catType.put(AppConstants.CONVICTION, AppConstants.CONVICTION);

			final APP_IN_FELON_DET_Collection newFelnColl = abHouseHoldMemberBO
							.loadConvictionDetails(appNum);
			int count = 0;
			if (newFelnColl != null) {				
				APP_IN_FELON_DET_Cargo appInFelCargo  = null;
				if (newFelnColl != null && !newFelnColl.isEmpty()) {
					final int rbCollSize = newFelnColl.size();
					for (int i = 0; i < rbCollSize; i++) {
						appInFelCargo  = newFelnColl.getCargo(i);
						if (appInFelCargo .getIndv_seq_num().equals(indvSeqNum)
								&& AppConstants.RMC_NEW_RECORD_IND
								.equals(appInFelCargo .getSrc_app_ind())) {
							count++;
						}
					}
				}
				if (count == 0) {
					// now we need to make that profile requeired
					final RMC_IN_PRFL_Cargo rmcResCargo = rmcResponseProfileManager
							.getProfile(rmcInPrflColl, indvSeqNum);
					if (AppConstants.CONVICTION.equals(type)) {
						rmcResponseProfileManager.makeAbsoluteNotRequired(
								IRMCResponseProfileManager.AVOID_PROSC_RESP,
								rmcResCargo, true);
					}
				}
			}

			boolean rmcPrflNotRequeired = false;
			boolean makeDetailsNotRerquired = false;
			// here we need to check we have no entrys in rmcPrfl for the job
			// income detail
			// as well as we need to check
			if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl,
						IRMCResponseProfileManager.AVOID_PROSC_RESP)) {
					if (rmcResponseProfileManager.isAppResponseNotRequired(
							rmcInPrflColl,
							IRMCResponseProfileManager.AVOID_PROSC_RESP)) {
						rmcPrflNotRequeired = true;
						makeDetailsNotRerquired = true;
					}
				}
			} else {
				rmcPrflNotRequeired = true;
			}
			count = abHouseHoldMemberBO.loadfelonyConvictionByTyp(newFelnColl,indvSeqNum);
			if (makeDetailsNotRerquired || count==0) {
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"ARCFN", driverArray, appNum);
			}

			if (categorySelectionProfileManager.isEmpty(rmcSelPrfl, catType)
					&& rmcPrflNotRequeired) {
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"ARCFN", driverArray, appNum);
			}
			session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER, rmcSelPrfl);
			driverManager.makeRequired(FwConstants.RMC_DRIVER,
					AppConstants.AROBS, driverArray, appNum);
			log(ILog.INFO, "RMCOtherBenefitsEJBBean::eraseFelonyConviction:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("eraseFelonyConviction");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"eraseFelonyConviction", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.eraseFelonyConviction() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

	/**
	 * Erase foln convtn changes.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void eraseFolnConvtnChanges(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.eraseFolnConvtnChanges() - START");
		try {
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::eraseFolnConvtnChanges:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);

			// Get RMCSessionBean from the session
			// Define IndvSeqNum and the SeqNum and Type and RowNum
			String indvSeqNum = null;
			String seqNum = null;
			String type = null;

			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);

			final APP_IN_FELON_DET_Collection felnCnvtnColl = (APP_IN_FELON_DET_Collection) pageCollection
					.get("APP_IN_FELON_DET_Collection");
			final APP_IN_FELON_DET_Cargo felnCnvtnCargo = felnCnvtnColl
					.getCargo(0);

			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			indvSeqNum = felnCnvtnCargo.getIndv_seq_num();
			seqNum = felnCnvtnCargo.getSeq_num();
			type = AppConstants.CONVICTION;
			APP_IN_FELON_DET_Cargo beforefelnCnvtnCargo = (APP_IN_FELON_DET_Cargo) beforeColl
					.get("APP_IN_FELON_DET_Cargo");

			final IndivTypeSeqBean indivTypeSeqBean = new IndivTypeSeqBean();
			indivTypeSeqBean.setIndivSeqNum(indvSeqNum);
			indivTypeSeqBean.setSeqNum(seqNum);
			indivTypeSeqBean.setType(type);
			final IndivTypeSeqBean postIndivSeqBean = (IndivTypeSeqBean) beforeColl
					.get(AppConstants.INDV_TYPE_SEQ_BEAN);
			boolean eraseData = false;

			if (postIndivSeqBean != null) {
				if (postIndivSeqBean.getIndivSeqNum().equals(
						indivTypeSeqBean.getIndivSeqNum())
						&& postIndivSeqBean.getSeqNum().equals(
								indivTypeSeqBean.getSeqNum())
								&& postIndivSeqBean.getType().equals(
										indivTypeSeqBean.getType())) {
					eraseData = true;
				}
			}

			final ABHouseHoldMemberBO abHouseHoldMemberBO = new ABHouseHoldMemberBO();
			if (beforefelnCnvtnCargo == null
					|| felnCnvtnCargo.isDifferent(beforefelnCnvtnCargo)
					|| !eraseData) {
				abHouseHoldMemberBO.validateCnvtnEraseChanges();
				request.put(FwConstants.MESSAGE_LIST,
						abHouseHoldMemberBO.getMessageList());
				beforefelnCnvtnCargo = new APP_IN_FELON_DET_Cargo();
				beforefelnCnvtnCargo.setIndv_seq_num(indvSeqNum);
				beforefelnCnvtnCargo.setSeq_num(seqNum);

				beforeColl.put("APP_IN_FELON_DET_Cargo", beforefelnCnvtnCargo);
				beforeColl.put(AppConstants.INDV_TYPE_SEQ_BEAN,
						indivTypeSeqBean);
				txnBean.setPageCollection(beforeColl);
				return;
			}

			// delete record from database
			abHouseHoldMemberBO.deleteModifiedRecords(indvSeqNum, seqNum,
					appNum);
			final String catTyp = AppConstants.CONVICTION;

			// delete record from rmc selection profile
			final SortedSet rmcSelPrfl = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			categorySelectionProfileManager.removeSequenceDetail(rmcSelPrfl,
					appNum, Short.parseShort(indvSeqNum),
					Long.parseLong(seqNum), catTyp);
			final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			boolean rmcPrflNotRequeired = false;
			// here we need to check we have no entrys in rmcPrfl for the job
			// income detail
			// as well as we need to check
			if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl,
						IRMCResponseProfileManager.AVOID_PROSC_RESP)) {
					if (rmcResponseProfileManager.isAppResponseNotRequired(
							rmcInPrflColl,
							IRMCResponseProfileManager.AVOID_PROSC_RESP)) {
						rmcPrflNotRequeired = true;
					}
				}
			} else {
				rmcPrflNotRequeired = true;
			}

			final String[] pageId = { "ARCFN" };

			final Map catType = new HashMap();
			catType.put(AppConstants.CONVICTION, AppConstants.CONVICTION);

			if (categorySelectionProfileManager.isRemoved(rmcSelPrfl, catType)
					&& rmcPrflNotRequeired) {
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						pageId, driverArray, appNum);
			}
			session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER, rmcSelPrfl);
			driverManager.makeRequired(FwConstants.RMC_DRIVER,
					AppConstants.AROBS, driverArray, appNum);

			// End
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::eraseFolnConvtnChanges:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("eraseFolnConvtnChanges");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"eraseFolnConvtnChanges", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.eraseFolnConvtnChanges() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

	/**
	 * Adds the conviction.
	 *
	 * @param txnBean the txn bean
	 * @throws javax.ejb.EJBException the EJB exception
	 */
	public void addConviction(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.addConviction() - START");
		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			// get cargo determining user selection
			final String cnvtnSeq = request.get("firstName_conviction") != null ? (String) request
					.get("firstName_conviction") : FwConstants.EMPTY_STRING;

					final ABHouseHoldMemberBO abHouseHoldMemberBO = new ABHouseHoldMemberBO();
					// validate selections
					if (cnvtnSeq == null
							|| AppConstants.SELECT_DEFAULT_OPTION.equals(cnvtnSeq)) {
						abHouseHoldMemberBO.validateAdd();
						// add validation message and return
						request.put(FwConstants.MESSAGE_LIST,
								abHouseHoldMemberBO.getMessageList());
						txnBean.setPageCollection((Map) session
								.get(FwConstants.BEFORE_COLLECTION));
						return;
					}
					final String appNum = (String) session.get(AppConstants.APP_NUMBER);
					final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
					indivSeqBean.setIndivSeqNum(cnvtnSeq);
					indivSeqBean.setSeqNum(FwConstants.ZERO);
					indivSeqBean.setType(AppConstants.CONVICTION);
					pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

					// set driver status
					final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARCFN", driver,
							appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER,
							AppConstants.AROBS, driver, appNum);
					session.put(FwConstants.RMC_DRIVER, driver);

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("addConviction");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"addConviction", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

		log(ILog.INFO, "RMCOtherBenefitsEJBBean.addConviction() - END , Time Taken : " + (System.currentTimeMillis() - startTime) + AppConstants.SPACE
				+ AppConstants.MILLISECONDS);
	}
	
	/**
	 * 
	 * @param txnBean
	 * @throws javax.ejb.EJBException
	 */
	public void endHPDetails(final FwTransaction txnBean) throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.endHPDetails() - START");
		try {
			log(ILog.INFO, "RMCOtherBenefitsEJBBean::endHPDetails:Start");
			final Map session = txnBean.getSession();
			final Map pageCollection = txnBean.getPageCollection();
			// Get driver info.
			final int[] driverArray = (int[]) session.get(FwConstants.RMC_DRIVER);

			final CP_APP_IN_CARE_PROV_Collection hpColl = (CP_APP_IN_CARE_PROV_Collection) pageCollection.get("CP_APP_IN_CARE_PROV_Collection");
			final CP_APP_IN_CARE_PROV_Cargo hpCargo = hpColl.getResult(0);
			final IndivTypeSeqBean seqBean = new IndivTypeSeqBean();
			seqBean.setIndivSeqNum(hpCargo.getIndv_seq_num());
			seqBean.setSeqNum(hpCargo.getSeq_num());
			seqBean.setType(hpCargo.getSrc_app_ind());
			seqBean.setUserEndInd(FwConstants.ONE);
			pageCollection.put(FwConstants.DETAIL_KEY_BEAN, seqBean);
			// Get App Number
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);

			log(ILog.INFO, "RMCOtherBenefitsEJBBean::endHPDetails:End");

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("endHPDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(), "endHPDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.endHPDetails() - END , Time Taken : " + (System.currentTimeMillis() - startTime) + AppConstants.SPACE
				+ AppConstants.MILLISECONDS);
	}
	
	
	public void endNHDetails(final FwTransaction txnBean) throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.endNHDetails() - START");
		try {
			log(ILog.INFO, "RMCOtherBenefitsEJBBean::endNHDetails::Start");
			final Map session = txnBean.getSession();
			final Map pageCollection = txnBean.getPageCollection();
			// Get driver info.
			final int[] driverArray = (int[]) session.get(FwConstants.RMC_DRIVER);

			final CP_APP_IN_CARE_PROV_Collection nhColl = (CP_APP_IN_CARE_PROV_Collection) pageCollection.get("CP_APP_IN_CARE_PROV_Collection");
			final CP_APP_IN_CARE_PROV_Cargo nhCargo = nhColl.getResult(0);
			final IndivTypeSeqBean seqBean = new IndivTypeSeqBean();
			seqBean.setIndivSeqNum(nhCargo.getIndv_seq_num());
			seqBean.setSeqNum(nhCargo.getSeq_num());
			seqBean.setType(nhCargo.getSrc_app_ind());
			seqBean.setUserEndInd(FwConstants.ONE);
			pageCollection.put(FwConstants.DETAIL_KEY_BEAN, seqBean);
			// Get App Number
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);

			log(ILog.INFO, "RMCOtherBenefitsEJBBean::endNHDetails::End");

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("endNHDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(), "endHPDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.endHPDetails() - END , Time Taken : " + (System.currentTimeMillis() - startTime) + AppConstants.SPACE
				+ AppConstants.MILLISECONDS);
	}
	
	public void endHSDetails(final FwTransaction txnBean) throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.endHSDetails() - START");
		try {
			log(ILog.INFO, "RMCOtherBenefitsEJBBean::endHSDetails::Start");
			final Map session = txnBean.getSession();
			final Map pageCollection = txnBean.getPageCollection();
			// Get driver info.
			final int[] driverArray = (int[]) session.get(FwConstants.RMC_DRIVER);

			final CP_APP_IN_CARE_PROV_Collection hpColl = (CP_APP_IN_CARE_PROV_Collection) pageCollection.get("CP_APP_IN_CARE_PROV_Collection");
			final CP_APP_IN_CARE_PROV_Cargo hpCargo = hpColl.getResult(0);
			final IndivTypeSeqBean seqBean = new IndivTypeSeqBean();
			seqBean.setIndivSeqNum(hpCargo.getIndv_seq_num());
			seqBean.setSeqNum(hpCargo.getSeq_num());
			seqBean.setType(hpCargo.getSrc_app_ind());
			seqBean.setUserEndInd(FwConstants.ONE);
			pageCollection.put(FwConstants.DETAIL_KEY_BEAN, seqBean);
			// Get App Number
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);

			log(ILog.INFO, "RMCOtherBenefitsEJBBean::endHSDetails::End");

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("endHSDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(), "endHSDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.endHSDetails() - END , Time Taken : " + (System.currentTimeMillis() - startTime) + AppConstants.SPACE
				+ AppConstants.MILLISECONDS);
	}
	
	private CP_APP_IN_CARE_PROV_Collection getIndividualColl(CP_APP_IN_CARE_PROV_Collection inColl, String indvSeqNum){
		
		CP_APP_IN_CARE_PROV_Collection outColl = new CP_APP_IN_CARE_PROV_Collection();
		
		for(int i=0; i<inColl.size();i++){
			String indvNum = inColl.getCargo(i).getIndv_seq_num();
			
			if(indvSeqNum.equals(indvNum)){
				outColl.addCargo(inColl.getCargo(i));
			}
		}
		
		return outColl;
	}
	
	public void getBenefitConvictionDetails(final FwTransaction txnBean) {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.getBenefitConvictionDetails() - START");
		try {
			
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			// you'll get the value for Seq
			APP_IN_BNFT_CNVCTN_Collection rmcInBnftCnvctnColl;
			// make loopingQuestion value NO in the request
			final String appNumber = (String) session
					.get(AppConstants.APP_NUMBER);
			final String pageId = (String) request
					.get(FwConstants.CURRENT_PAGE_ID);
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			final int pageStatus = driverManager.getAFBStatus(
					FwConstants.RMC_DRIVER, pageId, driverArray);
			String srcAppInd = FwConstants.SPACE;
			String pageMode = FwConstants.SPACE;

			final Map catTypes = createCatTypes();

			SortedSet categorySelectionProfile = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);

			if (pageStatus == FwConstants.DRIVER_REQUIRED
					|| pageStatus == FwConstants.DRIVER_VISIT_AGAIN
					&& categorySelectionProfileManager.isEmpty(
							categorySelectionProfile, catTypes)) {
				categorySelectionProfile = categorySelectionProfileManager
						.loadCategoryChangeSelectionProfile(appNumber,
								AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL);
			}
			
			RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			final String previousPageId = (String) request
					.get(FwConstants.PREVIOUS_PAGE_ID);
			
			final ABHouseHoldMemberBO abHouseholdMemberBo = new ABHouseHoldMemberBO();
			
			final short[] responseType = new short[] {
					IRMCResponseProfileManager.TRADING_SNAP_RESP,
					IRMCResponseProfileManager.CONVIC_FALSE_INFO_RESP,
					IRMCResponseProfileManager.BUY_SELL_SNAP_RESP,
					IRMCResponseProfileManager.DRUG_FELONIES_RESP,
					IRMCResponseProfileManager.TRADE_SNAP_GUN_RESP,
					IRMCResponseProfileManager.TANF_EPPIC_RESP,	
					IRMCResponseProfileManager.VOLUNTARILY_QUIT_JOB_RESP,
					IRMCResponseProfileManager.TANF_DISC_RESP
			};
			
			SortedSet bnftCnvctnProfile = null;
			boolean rnRecordFound = false;
			
			if (!pageId.equals(previousPageId)) {
				bnftCnvctnProfile = createBnftCnvctnPageProfile(
						categorySelectionProfile, rmcInPrflColl, responseType);
				if (pageStatus != FwConstants.DRIVER_REQUIRED) {
					final APP_IN_BNFT_CNVCTN_Collection newBnftCnvctnColl = abHouseholdMemberBo
							.loadBenefitConvictionDetails(appNumber);
					if (newBnftCnvctnColl != null && !newBnftCnvctnColl.isEmpty()) {
						APP_IN_BNFT_CNVCTN_Cargo rmcInBnftCnvctnCargo = null;
						final int newBnftCollSize = newBnftCnvctnColl.size();
						rnRecordFound = true;
						for (int i = 0; i < newBnftCollSize; i++) {
							rmcInBnftCnvctnCargo = newBnftCnvctnColl.getCargo(i);
							categorySelectionProfileManager
							.insertExistingSequenceDetail(
									bnftCnvctnProfile, null, null,
									Short.parseShort(rmcInBnftCnvctnCargo
											.getIndv_seq_num()),
											Long.parseLong(rmcInBnftCnvctnCargo
													.getSeq_num()),
													rmcInBnftCnvctnCargo.getConviction_type_cd());
						}
					}
				}
				if (pageStatus == FwConstants.DRIVER_REQUIRED
						|| pageStatus == FwConstants.DRIVER_VISIT_AGAIN) {
					// set the current record indicator to the first one
					categorySelectionProfileManager
					.setCurrentRecordIndToFirst(bnftCnvctnProfile);
				}
				if (pageStatus == FwConstants.DRIVER_COMPLETE) {
					// set the current record indicator to the end of the detail
					// bean
					categorySelectionProfileManager
					.setCurrentRecordIndToLast(bnftCnvctnProfile);
				}

				// create add new sorted set
				// we need to remove the values from the session
				session.remove(FwConstants.BEFORE_COLLECTION);
			} else {
				// catAddNewProfile get it from the before collection
				final Map beforeColl = (Map) session
						.get(FwConstants.BEFORE_COLLECTION);
				bnftCnvctnProfile = (SortedSet) beforeColl
						.get(AppConstants.RMC_CATEGORY_PAGE_PRFL);
			}
			
			IndivTypeSeqBean indivSeqBean = (IndivTypeSeqBean) pageCollection
					.get(FwConstants.DETAIL_KEY_BEAN);
			if (indivSeqBean == null && "AROBS".equals(previousPageId)) {
				indivSeqBean = (IndivTypeSeqBean) session
						.get(FwConstants.DETAIL_KEY_BEAN);
			}
			// Populating into session
			session.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);
			
			if (indivSeqBean != null) {
				final CategorySequenceDetail categorySeqDetail1 = categorySelectionProfileManager
						.getCategorySequenceDetail(
								bnftCnvctnProfile,
								Short.parseShort(indivSeqBean.getIndivSeqNum()),
								Long.parseLong(indivSeqBean.getSeqNum()),
								indivSeqBean.getType());
				if (categorySeqDetail1 != null) {
					if (categorySeqDetail1.getUserEndSelectionInd() != 1
							&& !rnRecordFound) {
						String userEndIndicator = indivSeqBean.getUserEndInd();

						if (userEndIndicator == null) {
							userEndIndicator = FwConstants.ZERO;
						}
						categorySelectionProfileManager
						.updateUserEndSelInd(
								bnftCnvctnProfile,
								appNumber,
								Short.parseShort(indivSeqBean
										.getIndivSeqNum()),
										Long.parseLong(indivSeqBean.getSeqNum()),
										indivSeqBean.getType(), Short
										.parseShort(userEndIndicator));

					}
					categorySelectionProfileManager.makeSequenceDetailRequired(
							bnftCnvctnProfile, null,
							Short.parseShort(indivSeqBean.getIndivSeqNum()),
							Long.parseLong(indivSeqBean.getSeqNum()),
							indivSeqBean.getType());
					final CategorySequenceDetail categorySeqDetail2 = categorySelectionProfileManager
							.getCategorySequenceDetail(
									categorySelectionProfile, Short
									.parseShort(indivSeqBean
											.getIndivSeqNum()),
											Long.parseLong(indivSeqBean.getSeqNum()),
											indivSeqBean.getType());
					if (categorySeqDetail2 != null) {

						if (categorySeqDetail2.getUserEndSelectionInd() != 1
								&& !rnRecordFound) {
							String userEndIndicator = indivSeqBean
									.getUserEndInd();
							if (userEndIndicator == null) {
								userEndIndicator = FwConstants.ZERO;
							}
							categorySelectionProfileManager
							.updateUserEndSelInd(
									categorySelectionProfile,
									appNumber, Short
									.parseShort(indivSeqBean
											.getIndivSeqNum()),
											Long.parseLong(indivSeqBean
													.getSeqNum()), indivSeqBean
													.getType(),
													Short.parseShort(userEndIndicator));
						}
						categorySelectionProfileManager
						.makeSequenceDetailRequired(
								categorySelectionProfile, appNumber,
								Short.parseShort(indivSeqBean
										.getIndivSeqNum()), Long
										.parseLong(indivSeqBean
												.getSeqNum()),
												indivSeqBean.getType());
					}
				} else {
					if (FwConstants.ZERO.equals(indivSeqBean.getSeqNum())) {

						RMC_IN_PRFL_Cargo rmcInPrflCargo = null;
						if (rmcInPrflColl != null) {
							rmcInPrflCargo = rmcResponseProfileManager
									.getProfile(rmcInPrflColl,
											indivSeqBean.getIndivSeqNum());
						} else {
							rmcInPrflColl = new RMC_IN_PRFL_Collection();

						}
						if (rmcInPrflCargo == null) {
							rmcInPrflCargo = new RMC_IN_PRFL_Cargo();
							rmcInPrflCargo.setApp_num(appNumber);
							rmcInPrflCargo.setIndv_seq_num(indivSeqBean
									.getIndivSeqNum());
							rmcResponseProfileManager
							.createRMCIndividualProfile(rmcInPrflCargo);
							rmcInPrflColl.addCargo(rmcInPrflCargo);
						}
						indivSeqBean.getUserEndInd();
						// now we need to make required the employment
						rmcResponseProfileManager.makeAddNew(
								rmcResponseProfileManager.getResponseByType(IRMCResponseProfileManager.BNFT_CNVCTN, indivSeqBean.getType()),
								rmcInPrflCargo, true);
						categorySelectionProfileManager
						.insertSequenceDetail(bnftCnvctnProfile, appNumber,
								AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL, Short.parseShort(indivSeqBean
										.getIndivSeqNum()), Short
										.parseShort(indivSeqBean
												.getSeqNum()),
												indivSeqBean.getType(), Short
												.parseShort(indivSeqBean
														.getUserEndInd()));
						session.put(AppConstants.RMC_IN_PRFL_MASTER,
								rmcInPrflColl);
					} else {

						String userEndInd = indivSeqBean.getUserEndInd();
						if (userEndInd == null) {
							userEndInd = FwConstants.ZERO;
						}
						categorySelectionProfileManager
						.insertSequenceDetail(bnftCnvctnProfile, null,
								AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL, Short
								.parseShort(indivSeqBean
										.getIndivSeqNum()),
										Short.parseShort(indivSeqBean
												.getSeqNum()), indivSeqBean
												.getType(), Short
												.parseShort(userEndInd));
						categorySelectionProfileManager
						.makeSequenceDetailRequired(bnftCnvctnProfile,
								null, Short.parseShort(indivSeqBean
										.getIndivSeqNum()), Long
										.parseLong(indivSeqBean
												.getSeqNum()),
												indivSeqBean.getType());
						log(ILog.INFO,
								"RMCOtherIncomeEJBBean:loadOtherIncomeDetails:Values"+indivSeqBean
								.getSeqNum()+"Type"+indivSeqBean
								.getType()+"IndvSeq"+indivSeqBean
								.getIndivSeqNum());
						categorySelectionProfileManager
						.insertSequenceDetail(categorySelectionProfile,
								appNumber,
								AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL, Short
								.parseShort(indivSeqBean
										.getIndivSeqNum()),
										Short.parseShort(indivSeqBean
												.getSeqNum()), indivSeqBean
												.getType(), Short
												.parseShort(userEndInd));
						
						categorySelectionProfileManager
						.makeSequenceDetailRequired(
								categorySelectionProfile, appNumber,
								Short.parseShort(indivSeqBean
										.getIndivSeqNum()), Long
										.parseLong(indivSeqBean
												.getSeqNum()),
												indivSeqBean.getType());
					}
				}
			}
			
			pageCollection.put(AppConstants.RMC_CATEGORY_PAGE_PRFL,
					bnftCnvctnProfile);

			CategorySequenceDetail categorySeqDetail = categorySelectionProfileManager
					.getCurrentSequenceDetail(bnftCnvctnProfile);
			if (categorySeqDetail == null) {
				categorySeqDetail = categorySelectionProfileManager
						.getNextSequenceDetail(bnftCnvctnProfile);
			}

			final String categoryType = categorySeqDetail.getCategoryType();
			final String categorySeqNum = Long.toString(categorySeqDetail
					.getCategorySequence());
			final String indvSeqNum = Short.toString(categorySeqDetail
					.getIndividualSequence());
			pageCollection.put("END_PAGE_IND",
					String.valueOf(categorySeqDetail.getUserEndSelectionInd()));

			rmcInBnftCnvctnColl = abHouseholdMemberBo.loadBnftCnvctnDetails(appNumber,
					indvSeqNum, categorySeqNum);
			
			if (rmcInBnftCnvctnColl != null && !rmcInBnftCnvctnColl.isEmpty()) {
				rmcInBnftCnvctnColl.getCargo(0);
			}
			pageCollection.put("APP_IN_BNFT_CNVCTN_Collection", rmcInBnftCnvctnColl);

			
			APP_IN_BNFT_CNVCTN_Cargo cwwBnftCnvctnCargo = abHouseholdMemberBo.splitOtherIncColl(
					rmcInBnftCnvctnColl, AppConstants.CWW_RECORD_IND);
			if (cwwBnftCnvctnCargo == null) {
				cwwBnftCnvctnCargo = new APP_IN_BNFT_CNVCTN_Cargo();
			}
			pageCollection.put("SEC_BNFT", cwwBnftCnvctnCargo);

			APP_IN_BNFT_CNVCTN_Cargo rmcEmplCargo = abHouseholdMemberBo.splitOtherIncColl(
					rmcInBnftCnvctnColl, AppConstants.RMC_NEW_RECORD_IND);
			if (rmcEmplCargo != null) {
				pageCollection.put("FST_BNFT", rmcEmplCargo);
			} else {
				rmcEmplCargo = abHouseholdMemberBo.splitOtherIncColl(rmcInBnftCnvctnColl,
						AppConstants.RMC_MODIFIED_RECORD_IND);
				if (rmcEmplCargo != null) {
					pageCollection.put("FST_BNFT", rmcEmplCargo);
				} else {
					rmcEmplCargo = abHouseholdMemberBo.splitOtherIncColl(
							rmcInBnftCnvctnColl, AppConstants.RMC_END_RECORD_IND);
					if (rmcEmplCargo != null) {
						pageCollection.put("FST_BNFT", rmcEmplCargo);
					} else {
						pageCollection.put("FST_BNFT", cwwBnftCnvctnCargo);
					}
				}

			}
			
			if (rmcInBnftCnvctnColl != null && !rmcInBnftCnvctnColl.isEmpty()) {
				final APP_IN_BNFT_CNVCTN_Cargo appInBnftCnvctnCargo = rmcInBnftCnvctnColl
						.getCargo(0);
				srcAppInd = appInBnftCnvctnCargo.getSrc_app_ind();
			}

			if (("CW".equalsIgnoreCase(srcAppInd) || "RM"
					.equalsIgnoreCase(srcAppInd))
					&& categorySeqDetail.getUserEndSelectionInd() == 0) {
				pageMode = "C";
			}

			if (categorySeqDetail.getUserEndSelectionInd() == 1) {
				pageMode = "E";
			} else if (indivSeqBean != null
					&& indivSeqBean.getUserEndInd() != null) {
				if (FwConstants.ONE.equalsIgnoreCase(indivSeqBean
						.getUserEndInd())) {
					pageMode = "E";
				} else if (FwConstants.ZERO
						.equals(indivSeqBean.getUserEndInd())
						&& "RM".equalsIgnoreCase(srcAppInd)
						|| "CW".equalsIgnoreCase(srcAppInd)) {
					pageMode = "C";
				} else {
					pageMode = FwConstants.NO;
				}
			} else if (!("C".equals(pageMode) || "E".equals(pageMode))) {
				pageMode = FwConstants.NO;
			}
			
			char typeStatus = 'N';
			String showLoopingQuestionFlag = FwConstants.YES;

			typeStatus = categorySeqDetail.getStatus();
			if (typeStatus == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
					|| typeStatus == IRMCResponseProfileManager.STATUS_COMPLETE) {
				showLoopingQuestionFlag = FwConstants.NO;
			}

			pageCollection.put("showLoopingQuestion", showLoopingQuestionFlag);
			pageCollection.put("PAGE_MODE", pageMode);

			pageCollection.put("BNFT_CNVCTN_TYPE", categoryType);
			
			final PeopleHandler peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);
			pageCollection.put(AppConstants.FIRST_NAME,
					peopleHandler.getFirstName(indvSeqNum));
			
			componentManager.getComponents("ARBCN", txnBean);
			request.remove("loopingQuestion");
			// Add the page collection to before collection
			session.put(FwConstants.BEFORE_COLLECTION, pageCollection);

			log(ILog.INFO, "RMCOtherBenefitsEJBBean::getBenefitConvictionDetails:End");

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("getBenefitConvictionDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"getBenefitConvictionDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.getBenefitConvictionDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}
	
	public void storeBenefitConvictionDetails(final FwTransaction txnBean) {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.storeBenefitConvictionDetails() - START");
		
		try {

			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();

			final String currentPageID = (String) request
					.get(FwConstants.CURRENT_PAGE_ID);
			final String appNumber = (String) session
					.get(AppConstants.APP_NUMBER);
			List modifiedFields = (ArrayList) session
					.get(AppConstants.MODIFIED_FIELDS);
			if(modifiedFields == null){
			    modifiedFields = new ArrayList();
			}
			// build category selection profile
			final SortedSet categorySelectionProfile = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			// get the BeforeCollection
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);
			final PeopleHandler peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);
			final SortedSet otherIncomeProfile = (SortedSet) beforeColl
					.get(AppConstants.RMC_CATEGORY_PAGE_PRFL);

			final APP_IN_BNFT_CNVCTN_Collection rmcInOthrIncCollection = (APP_IN_BNFT_CNVCTN_Collection) pageCollection
					.get("APP_IN_BNFT_CNVCTN_Collection");
			APP_IN_BNFT_CNVCTN_Cargo rmcInothrIncCargo = rmcInOthrIncCollection
					.getCargo(0);
			final boolean amtEntered = false;
			final CategorySequenceDetail categorySeqDetailBean = categorySelectionProfileManager
					.getCurrentSequenceDetail(otherIncomeProfile);
			final short userEndInd = categorySeqDetailBean
					.getUserEndSelectionInd();
			
			ABHouseHoldMemberBO abHouseHoldMemberBo = new ABHouseHoldMemberBO();
			
			final String backToMyAccess = (String) request
					.get(AppConstants.BACK_TO_MY_ACCESS_BUTTON);
			final String pageMode = (String) beforeColl.get("PAGE_MODE");

			String changeEffDate = null;
			final APP_IN_BNFT_CNVCTN_Collection beforeCollRmcInOthIncColl = (APP_IN_BNFT_CNVCTN_Collection) beforeColl
					.get("APP_IN_BNFT_CNVCTN_Collection");
			APP_IN_BNFT_CNVCTN_Cargo beforeOthrIncCargo = null;

			rmcInothrIncCargo.setApp_num(appNumber);
			
		
			if (rmcInothrIncCargo.getRec_cplt_ind() == null) {
				rmcInothrIncCargo.setRec_cplt_ind(FwConstants.ZERO);
			}

			
			final String indvSeqNum = String.valueOf(categorySeqDetailBean
					.getIndividualSequence());
			String sourceAppIndicator = null;
			String recordInd = null;

			// now we are checking for the before collection
			long seqNum = 0;
			boolean othrIncDetailsUpdate = false;

			if (beforeCollRmcInOthIncColl != null
					&& !beforeCollRmcInOthIncColl.isEmpty()) {

				final int size = beforeCollRmcInOthIncColl.size();
				seqNum = categorySeqDetailBean.getCategorySequence();

				if ("C".equalsIgnoreCase(pageMode)) {
					sourceAppIndicator = AppConstants.RMC_MODIFIED_RECORD_IND;
				} else if ("E".equalsIgnoreCase(pageMode)) {
					sourceAppIndicator = AppConstants.RMC_END_RECORD_IND;
				} else {
					sourceAppIndicator = AppConstants.RMC_NEW_RECORD_IND;
				}

				beforeOthrIncCargo = abHouseHoldMemberBo.splitOtherIncColl(
						beforeCollRmcInOthIncColl, sourceAppIndicator);
				if (beforeOthrIncCargo == null
						&& (AppConstants.RMC_MODIFIED_RECORD_IND
								.equals(sourceAppIndicator) || AppConstants.RMC_END_RECORD_IND
								.equals(sourceAppIndicator))) {
					beforeOthrIncCargo = abHouseHoldMemberBo.splitOtherIncColl(
							beforeCollRmcInOthIncColl,
							AppConstants.CWW_RECORD_IND);
				}

				if (size > 1) {
					// if we have two records means cw and rm or cw and re
					// now we are getting RM/RE record to compare
					// now we need to update the data base if it dirty
					recordInd = FwConstants.ROWACTION_UPDATE;
				} else {
					// now we are checking this record is CW or RN
					recordInd = FwConstants.ROWACTION_INSERT;
					if (AppConstants.RMC_NEW_RECORD_IND
							.equals(sourceAppIndicator)
							&& beforeOthrIncCargo != null) {
						recordInd = FwConstants.ROWACTION_UPDATE;
					}
				}

				if (beforeOthrIncCargo != null) {
					// Source App Indicator set to 'RM' and the default values
					// for appInSelfeCargo populated from the before cargo
					rmcInothrIncCargo.setSrc_app_ind(beforeOthrIncCargo
							.getSrc_app_ind());
					rmcInothrIncCargo.setIndv_seq_num(beforeOthrIncCargo
							.getIndv_seq_num());
					rmcInothrIncCargo.setConviction_type_cd(beforeOthrIncCargo
							.getConviction_type_cd());
					rmcInothrIncCargo.setSeq_num(beforeOthrIncCargo
							.getSeq_num());
					rmcInothrIncCargo.setRec_cplt_ind(beforeOthrIncCargo
							.getRec_cplt_ind());
					
					rmcInothrIncCargo.setEcp_id(beforeOthrIncCargo.getEcp_id());

					
				}

				
				
				// check dirty
				rmcInothrIncCargo = (APP_IN_BNFT_CNVCTN_Cargo) isChanged(
						beforeOthrIncCargo, rmcInothrIncCargo);
				if (rmcInothrIncCargo.isDirty()) {
					rmcInothrIncCargo.setSrc_app_ind(sourceAppIndicator);
					rmcInothrIncCargo.setRowAction(recordInd);
					// Start of VaCMS - Removal of Chg_eff_dt field
					// End of VaCMS - Removal of Chg_eff_dt field
					rmcInothrIncCargo.setRec_cplt_ind(FwConstants.ONE);
					othrIncDetailsUpdate = true;
					// EDSP RMB

				}
				
				rmcInothrIncCargo.setRec_cplt_ind(FwConstants.ONE);

			} else {
				// if there is no before collection means this is new record
				sourceAppIndicator = AppConstants.RMC_NEW_RECORD_IND;
				rmcInothrIncCargo
				.setIndv_seq_num(String.valueOf(categorySeqDetailBean
						.getIndividualSequence()));
				// get the MAX seq number from data base
				seqNum = abHouseHoldMemberBo.getMaxBnftCnvctnSeqNumber(appNumber,
						indvSeqNum);
				seqNum = seqNum + 1;
				rmcInothrIncCargo.setSeq_num(String.valueOf(seqNum));
				rmcInothrIncCargo.setConviction_type_cd(categorySeqDetailBean
						.getCategoryType());
				rmcInothrIncCargo.setSrc_app_ind(sourceAppIndicator);
				recordInd = FwConstants.ROWACTION_INSERT;
				rmcInothrIncCargo.setRowAction(recordInd);
				othrIncDetailsUpdate = true;
				// insert into RMC_SELECTION_PROFILE using Common Mehod()
				categorySelectionProfileManager.updateSequence(
						otherIncomeProfile, null,
						categorySeqDetailBean.getIndividualSequence(), seqNum,
						categorySeqDetailBean.getCategoryType());
				categorySelectionProfileManager.updateSequence(categorySelectionProfile, null, categorySeqDetailBean.getIndividualSequence(), seqNum, categorySeqDetailBean.getCategoryType());
				if(null!=categorySeqDetailBean.getChangeSelectionCategoryCd())
				{
				categorySelectionProfileManager.persistSequence(appNumber, categorySeqDetailBean.getChangeSelectionCategoryCd(), String.valueOf(categorySeqDetailBean.getIndividualSequence()), String.valueOf(seqNum), categorySeqDetailBean.getCategoryType(), "0");
				}
			}
			// now we need to check the flags
			if (backToMyAccess == null) {
				boolean isLoopingQuestionShown = false;
				final String showLooping = (String) beforeColl
						.get("showLoopingQuestion");
				if (AppConstants.YES.equalsIgnoreCase(showLooping)) {
					isLoopingQuestionShown = true;
				}

				final String loopingAnswer = (String) request
						.get("loopingQuestion");
				//validations go here
				abHouseHoldMemberBo.validateBenefitConviction(rmcInothrIncCargo, showLooping, peopleHandler);
			}

			if (checkBackToMyAccessSelected(request)
					|| abHouseHoldMemberBo.hasMessages()) {
				if (backToMyAccess == null) {
					request.put(FwConstants.MESSAGE_LIST,
							abHouseHoldMemberBo.getMessageList());
				}
				pageCollection.put("BNFT_CNVCTN_TYPE",
						beforeColl.get("BNFT_CNVCTN_TYPE"));
				pageCollection.put("APP_IN_BNFT_CNVCTN_Collection",
						rmcInOthrIncCollection);
				pageCollection.put(AppConstants.FIRST_NAME,
						beforeColl.get(AppConstants.FIRST_NAME));
				if (request.get("loopingQuestion") != null) {
					request.put("loopingQuestion",
							request.get("loopingQuestion"));
				}
				pageCollection.put("showLoopingQuestion",
						beforeColl.get("showLoopingQuestion"));
				pageCollection.put(FwConstants.PAGE_COMPONENT_LIST,
						beforeColl.get(FwConstants.PAGE_COMPONENT_LIST));

				pageCollection.put("PAGE_MODE", beforeColl.get("PAGE_MODE"));
				if (beforeColl.containsKey("SEC_BNFT")) {
					pageCollection.put("SEC_BNFT", beforeColl.get("SEC_BNFT"));
				}
				pageCollection.put("FST_BNFT", rmcInothrIncCargo);
				return;
			}
			

			if (othrIncDetailsUpdate) {
				if (FwConstants.ROWACTION_INSERT.equals(rmcInothrIncCargo
						.getRowAction())) {
					
					abHouseHoldMemberBo.insertExistingDetails(rmcInOthrIncCollection);
				} else {
					abHouseHoldMemberBo.storeBnftCnvctnDetails(rmcInOthrIncCollection);
				}
			}

			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			boolean loopingQuestion = false;
			if (request.get("loopingQuestion") != null
					&& FwConstants.YES.equals(request.get("loopingQuestion"))) {
				loopingQuestion = true;
				// Insert into APP_IN_UEI
				categorySelectionProfileManager.insertSequenceDetail(
						otherIncomeProfile, null, null,
						categorySeqDetailBean.getIndividualSequence(),
						categorySeqDetailBean.getCategoryType());
				driverManager.makeRequired(FwConstants.RMC_DRIVER,
						currentPageID, driverArray, appNumber);
				driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
						driverArray, appNumber);
			}
			
			//reqInd is indicator to decide if we have complete the response profile or not
			boolean reqInd=false;
			if (!loopingQuestion) {
				short respTyp=rmcResponseProfileManager
						.getResponseByType(
								IRMCResponseProfileManager.BNFT_CNVCTN,
								categorySeqDetailBean
								.getCategoryType());
				final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
						.get(AppConstants.RMC_IN_PRFL_MASTER);
				final RMC_IN_PRFL_Cargo rmcInPrflCargo = rmcResponseProfileManager
						.getProfile(rmcInPrflColl, String
								.valueOf(categorySeqDetailBean
										.getIndividualSequence()));
				if (rmcInPrflCargo != null && rmcResponseProfileManager.getProfileResponse(
						rmcInPrflCargo, respTyp).charAt(0) == IRMCResponseProfileManager.STATUS_REQUIRED) {
					reqInd=true;
					rmcResponseProfileManager
					.makeComplete(
							rmcResponseProfileManager
							.getResponseByType(
									IRMCResponseProfileManager.BNFT_CNVCTN,
									categorySeqDetailBean
									.getCategoryType()),
									rmcInPrflCargo, true);
				}
			}

			// Mark complete otherinc sequence using common methods
			//if the profile response was not 'R' or if we came from gatepost then don't persist else persist
			if(!reqInd || categorySeqDetailBean.getChangeSelectionCategoryCd()==null){
			categorySelectionProfileManager.makeSequenceDetailComplete(
					otherIncomeProfile, null,
					categorySeqDetailBean.getIndividualSequence(),
					categorySeqDetailBean.getCategorySequence(),
					categorySeqDetailBean.getCategoryType());
			}else{
				categorySelectionProfileManager.makeSequenceDetailComplete(
						otherIncomeProfile, appNumber,
						categorySeqDetailBean.getIndividualSequence(),
						categorySeqDetailBean.getCategorySequence(),
						categorySeqDetailBean.getCategoryType());
			}
			if (categorySelectionProfile != null) {
				categorySelectionProfileManager.makeSequenceDetailComplete(
						categorySelectionProfile, appNumber,
						categorySeqDetailBean.getIndividualSequence(),
						categorySeqDetailBean.getCategorySequence(),
						categorySeqDetailBean.getCategoryType());
			}
			if (categorySelectionProfileManager
					.areAllSequencesComplete(otherIncomeProfile)) {
				driverManager.makeComplete(FwConstants.RMC_DRIVER,
						currentPageID, driverArray, appNumber);
			} else {
				categorySelectionProfileManager
				.getNextSequenceDetail(otherIncomeProfile);
			}
			// Removing the indvSeqBean from session
			final IndivTypeSeqBean indivSeqBean = (IndivTypeSeqBean) session
					.get(FwConstants.DETAIL_KEY_BEAN);
			if (indivSeqBean != null) {
				if (indivSeqBean.getIndivSeqNum().equals(
						rmcInothrIncCargo.getIndv_seq_num())
						&& indivSeqBean.getSeqNum().equals(
								rmcInothrIncCargo.getSeq_num())
								&& indivSeqBean.getType().equals(
										rmcInothrIncCargo.getConviction_type_cd())) {
					session.remove(FwConstants.DETAIL_KEY_BEAN);
				}
			}

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("storeBenefitConvictionDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"storeBenefitConvictionDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.storeBenefitConvictionDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}
	
	private Map createCatTypes() {
		final Map catTypes = new HashMap();
		catTypes.put("TSB", "TSB");
		catTypes.put("FRI", "FRI");
		catTypes.put("TRA", "TRA");
		catTypes.put("PDS", "PDS");
		catTypes.put("SFE", "SFE");
		catTypes.put("UBU", "UBU");
		catTypes.put("VQJ", "VQJ");
		catTypes.put("DFT", "DFT");
		return catTypes;
	}
	
	public void editBnftCnvctnDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherBenefitsEJBBean.editBnftCnvctnDetails() - START");
		try {

			log(ILog.INFO, "RMCOtherBenefitsEJBBean::editBnftCnvctnDetails:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			Map pageCollection = txnBean.getPageCollection();
			final PeopleHandler peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);
			// Get App Number
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);

			// Get driver info.

			// Get the APP_IN_BNFT_CNVCTN_Collection from pageCollection.
			final APP_IN_BNFT_CNVCTN_Collection bnftCnvctnColl = (APP_IN_BNFT_CNVCTN_Collection) pageCollection
					.get("APP_IN_BNFT_CNVCTN_Collection");
			final APP_IN_BNFT_CNVCTN_Cargo bnftCnvctnCargo = bnftCnvctnColl.getCargo(0);
			bnftCnvctnCargo.getIndv_seq_num();
			bnftCnvctnCargo.getConviction_type_cd();

			final IndivTypeSeqBean seqBean = new IndivTypeSeqBean();
			seqBean.setIndivSeqNum(bnftCnvctnCargo.getIndv_seq_num());
			seqBean.setSeqNum(bnftCnvctnCargo.getSeq_num());
			seqBean.setType(bnftCnvctnCargo.getConviction_type_cd());

			if ("RE".equals(bnftCnvctnCargo.getSrc_app_ind())) {
				seqBean.setUserEndInd(FwConstants.ONE);
			} else {
				seqBean.setUserEndInd(FwConstants.ZERO);
			}
			final RMC_IN_PRFL_Collection rmcInPrflSessColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			final int driverStatus = driverManager.getAFBStatus(
					FwConstants.RMC_DRIVER,
					(String) request.get(FwConstants.CURRENT_PAGE_ID),
					driverArray);
			
			pageCollection.put(FwConstants.DETAIL_KEY_BEAN, seqBean);
			session.put(FwConstants.BEFORE_COLLECTION, pageCollection);

			// Set RMC page Other Income Details make required
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARBCN",
					driverArray, appNum);
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
					driverArray, appNum);
			txnBean.setSession(session);
			// End
			log(ILog.INFO, "RMCOtherBenefitsEJBBean::editBnftCnvctnDetails:End");

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("editBnftCnvctnDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"editBnftCnvctnDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.editBnftCnvctnDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}
	
	public void eraseBnftCnvctnChanges(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.eraseBnftCnvctnChanges() - START");
		try {
			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::eraseBnftCnvctnChanges:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);

			// Get RMCSessionBean from the session
			// Define IndvSeqNum and the SeqNum and Type and RowNum
			String indvSeqNum = null;
			String seqNum = null;
			String convctnType = null;

			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);

			// Get the APP_IN_BNFT_CNVCTN_Collection from pageCollection.
			final APP_IN_BNFT_CNVCTN_Collection bnftCnvctnColl = (APP_IN_BNFT_CNVCTN_Collection) pageCollection
					.get("APP_IN_BNFT_CNVCTN_Collection");
			final APP_IN_BNFT_CNVCTN_Cargo bnftCnvctnCargo = bnftCnvctnColl.getCargo(0);

			// Get the results from the APP_IN_EMPL_Collection
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			indvSeqNum = bnftCnvctnCargo.getIndv_seq_num();
			seqNum = bnftCnvctnCargo.getSeq_num();
			convctnType = bnftCnvctnCargo.getConviction_type_cd();
			APP_IN_BNFT_CNVCTN_Cargo beforeBnftCnvctnCargo = (APP_IN_BNFT_CNVCTN_Cargo) beforeColl
					.get("APP_IN_BNFT_CNVCTN_Cargo");

			final ABHouseHoldMemberBO abHouseHoldMemberBO = new ABHouseHoldMemberBO();
			if (beforeBnftCnvctnCargo == null
					|| abHouseHoldMemberBO.isDifferent(bnftCnvctnCargo,
							beforeBnftCnvctnCargo)) {
				abHouseHoldMemberBO.validateEraseChanges(convctnType);
				request.put(FwConstants.MESSAGE_LIST,
						abHouseHoldMemberBO.getMessageList());
				beforeBnftCnvctnCargo = new APP_IN_BNFT_CNVCTN_Cargo();
				beforeBnftCnvctnCargo.setIndv_seq_num(indvSeqNum);
				beforeBnftCnvctnCargo.setSeq_num(seqNum);
				beforeBnftCnvctnCargo.setConviction_type_cd(convctnType);
				beforeColl.put("APP_IN_BNFT_CNVCTN_Cargo", beforeBnftCnvctnCargo);
				txnBean.setPageCollection(beforeColl);
				return;
			}

			// delete record from database
			abHouseHoldMemberBO.deleteBnftCnvctnRecords(indvSeqNum, seqNum, appNum);
			final String catBnftCnvctnTyp = AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL;

			// delete record from rmc selection profile
			final SortedSet rmcSelPrfl = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			categorySelectionProfileManager.removeSequenceDetail(rmcSelPrfl,
					appNum, Short.parseShort(indvSeqNum),
					Long.parseLong(seqNum), catBnftCnvctnTyp, convctnType);
			final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			boolean rmcPrflNotRequeired = false;
			// here we need to check we have no entrys in rmcPrfl for the other
			// income detail
			// as well as we need to check
			if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl, IRMCResponseProfileManager.BNFT_CNVCTN)) {
					if (rmcResponseProfileManager.isAppResponseNotRequired(
							rmcInPrflColl,
							IRMCResponseProfileManager.BNFT_CNVCTN)) {
						rmcPrflNotRequeired = true;
					}
				}
			} else {
				rmcPrflNotRequeired = true;
			}

			final Map catTypes = createCatTypes();

			if (categorySelectionProfileManager.isEmpty(rmcSelPrfl, catTypes)
					&& rmcPrflNotRequeired) {
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"ARBCN", driverArray, appNum);
			}
			session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER, rmcSelPrfl);
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
					driverArray, appNum);
			// End
			log(ILog.INFO, "RMCOtherBenefitsEJBBean::eraseBnftCnvctnChanges:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("eraseBnftCnvctnChanges");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"eraseBnftCnvctnChanges", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.eraseBnftCnvctnChanges() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}
	
	public void eraseBnftCnvctnDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.eraseBnftCnvctnDetails() - START");
		try {

			log(ILog.INFO,
					"RMCOtherBenefitsEJBBean::eraseBnftCnvctnDetails:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);

			// Get RMCSessionBean from the session

			// Define IndvSeqNum and the SeqNum and Type and RowNum
			String indvSeqNum = null;
			String seqNum = null;
			String ueiType = null;
			final String catEmpTyp = AppConstants.RMC_CAT_OTHER_BENEFITS_PRFL;

			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);

			// Get the APP_IN_UEI_Collection from pageCollection.
			final APP_IN_BNFT_CNVCTN_Collection otherIncColl = (APP_IN_BNFT_CNVCTN_Collection) pageCollection
					.get("APP_IN_BNFT_CNVCTN_Collection");
			final APP_IN_BNFT_CNVCTN_Cargo otherInCargo = otherIncColl.getCargo(0);

			// Get the results from the APP_IN_EMPL_Collection
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);

			// delete record from rmc selection profile
			final SortedSet rmcSelPrfl = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);

			indvSeqNum = otherInCargo.getIndv_seq_num();
			seqNum = otherInCargo.getSeq_num();
			ueiType = otherInCargo.getConviction_type_cd();

			final short responseId = rmcResponseProfileManager
					.getResponseByType(
							IApplicationManager.BNFT_CNVCTN, ueiType);

			APP_IN_BNFT_CNVCTN_Cargo beforeOtherInCargo = (APP_IN_BNFT_CNVCTN_Cargo) beforeColl
					.get("APP_IN_BNFT_CNVCTN_Cargo");
			final ABHouseHoldMemberBO otherIncomeBo = new ABHouseHoldMemberBO();

			if (beforeOtherInCargo == null
					|| otherIncomeBo.isDifferent(otherInCargo,
							beforeOtherInCargo)) {

				
				otherIncomeBo.validateBnftCnvctnErase(ueiType);
				request.put(FwConstants.MESSAGE_LIST,
						otherIncomeBo.getMessageList());
				beforeOtherInCargo = new APP_IN_BNFT_CNVCTN_Cargo();
				beforeOtherInCargo.setIndv_seq_num(indvSeqNum);
				beforeOtherInCargo.setSeq_num(seqNum);
				beforeOtherInCargo.setConviction_type_cd(ueiType);
				beforeColl.put("APP_IN_BNFT_CNVCTN_Cargo", beforeOtherInCargo);
				txnBean.setPageCollection(beforeColl);
				return;

			}

			otherIncomeBo.deleteBnftCnvctnRecords(indvSeqNum, seqNum, appNum);
			categorySelectionProfileManager.removeSequenceDetail(rmcSelPrfl,
					appNum, Short.parseShort(indvSeqNum),
					Long.parseLong(seqNum), catEmpTyp, ueiType);
			final Map catTypes = createCatTypes();
			

			final ABHouseHoldMemberBO abHouseholdMemberBo = new ABHouseHoldMemberBO();
			final APP_IN_BNFT_CNVCTN_Collection benefitConvColl = abHouseholdMemberBo
							.loadBenefitConvictionDetails(appNum);
			int count = 0;
			if (benefitConvColl != null) {				
				APP_IN_BNFT_CNVCTN_Cargo benefitConvCargo  = null;
				if (benefitConvColl != null && !benefitConvColl.isEmpty()) {
					final int rbCollSize = benefitConvColl.size();
					for (int i = 0; i < rbCollSize; i++) {
						benefitConvCargo  = benefitConvColl.getCargo(i);
						if (benefitConvCargo.getIndv_seq_num().equals(indvSeqNum)
								&& benefitConvCargo.getConviction_type_cd().equals(ueiType)
								&& AppConstants.RMC_NEW_RECORD_IND
								.equals(benefitConvCargo.getSrc_app_ind())) {
							count++;
						}
					}
				}
				if (count == 0) {
					// now we need to make that profile required
					final RMC_IN_PRFL_Cargo rmcResCargo = rmcResponseProfileManager
							.getProfile(rmcInPrflColl, indvSeqNum);
					rmcResponseProfileManager.makeAbsoluteNotRequired(
							rmcResponseProfileManager.getResponseByType(IRMCResponseProfileManager.BNFT_CNVCTN, ueiType),
							rmcResCargo, true);
					rmcResponseProfileManager.makeAbsoluteNotRequired(
							responseId, rmcResCargo, true);
				}
			}
			rmcResponseProfileManager.getProfile(rmcInPrflColl, indvSeqNum);
			boolean makeDetailsNotRerquired = false;
			if (AppConstants.CNVCT_TSB.equals(ueiType)) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl,
						IRMCResponseProfileManager.TRADING_SNAP_RESP)) {
					makeDetailsNotRerquired = true;
				}
			} else if (AppConstants.CNVCT_FRI.equals(ueiType)) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl,
						IRMCResponseProfileManager.CONVIC_FALSE_INFO_RESP)) {
					makeDetailsNotRerquired = true;
				}
			} else if (AppConstants.CNVCT_TRA.equals(ueiType)) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl, IRMCResponseProfileManager.BUY_SELL_SNAP_RESP)) {
					makeDetailsNotRerquired = true;
				}
			} else if (AppConstants.CNVCT_PDS.equals(ueiType)) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl,
						IRMCResponseProfileManager.DRUG_FELONIES_RESP)) {
					makeDetailsNotRerquired = true;
				}
			} else if (AppConstants.CNVCT_SFE.equals(ueiType)) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl,
						IRMCResponseProfileManager.TRADE_SNAP_GUN_RESP)) {
					makeDetailsNotRerquired = true;
				}
			} else if (AppConstants.CNVCT_UBU.equals(ueiType)) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl,
						IRMCResponseProfileManager.TANF_EPPIC_RESP)) {
					makeDetailsNotRerquired = true;
				}
			} 
			count = abHouseholdMemberBo.loadBenefitConvictionByTyp(benefitConvColl,ueiType);
			if (makeDetailsNotRerquired || count==0) {
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"ARBCN", driverArray, appNum);
			}

			boolean rmcPrflNotRequeired = false;
			// here we need to check we have no entrys in rmcPrfl for the other
			// income detail
			// as well as we need to check
			if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl, IRMCResponseProfileManager.OTHER_INCOME)) {
					rmcPrflNotRequeired = true;
				}
			} else {
				rmcPrflNotRequeired = true;
			}

			if (categorySelectionProfileManager.isEmpty(rmcSelPrfl, catTypes)
					&& rmcPrflNotRequeired) {
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"ARBCN", driverArray, appNum);
			}
			session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER, rmcSelPrfl);
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS",
					driverArray, appNum);
			log(ILog.INFO, "RMCOtherBenefitsEJBBean::eraseBnftCnvctnDetails:End");

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("eraseBnftCnvctnDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"eraseBnftCnvctnDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.eraseBnftCnvctnDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}
	
	public void addBnftCnvctnTsbDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.addBnftCnvctnTsbDetails() - START");
		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			// get cargo determining user selection
			final String bnftCnvctnSeq = request.get("firstName_tsb") != null ? (String) request
					.get("firstName_tsb") : FwConstants.EMPTY_STRING;

					final ABHouseHoldMemberBO abHouseHoldMemberBO = new ABHouseHoldMemberBO();
					
					// validate selections
					if (bnftCnvctnSeq == null
							|| AppConstants.SELECT_DEFAULT_OPTION
							.equals(bnftCnvctnSeq)) {
						abHouseHoldMemberBO.validateAdd(bnftCnvctnSeq,
								AppConstants.CNVCT_TSB);
						// add validation message and return
						request.put(FwConstants.MESSAGE_LIST,
								abHouseHoldMemberBO.getMessageList());
						txnBean.setPageCollection((Map) session
								.get(FwConstants.BEFORE_COLLECTION));
						return;
					}
					final String appNum = (String) session.get(AppConstants.APP_NUMBER);

					final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
					indivSeqBean.setIndivSeqNum(bnftCnvctnSeq);
					indivSeqBean.setSeqNum(FwConstants.ZERO);
					indivSeqBean.setType(AppConstants.CNVCT_TSB);
					indivSeqBean.setUserEndInd(FwConstants.ZERO);
					pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

					// set driver status
					final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARBCN", driver,
							appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driver,
							appNum);
					session.put(FwConstants.RMC_DRIVER, driver);

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("addBnftCnvctnTsbDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"addBnftCnvctnTsbDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		
		

		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.addBnftCnvctnTsbDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}
	
	public void addBnftCnvctnFriDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.addBnftCnvctnFriDetails() - START");
		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			// get cargo determining user selection
			final String bnftCnvctnSeq = request.get("firstName_fri") != null ? (String) request
					.get("firstName_fri") : FwConstants.EMPTY_STRING;

					final ABHouseHoldMemberBO abHouseHoldMemberBO = new ABHouseHoldMemberBO();
					
					// validate selections
					if (bnftCnvctnSeq == null
							|| AppConstants.SELECT_DEFAULT_OPTION
							.equals(bnftCnvctnSeq)) {
						abHouseHoldMemberBO.validateAdd(bnftCnvctnSeq,
								AppConstants.CNVCT_FRI);
						// add validation message and return
						request.put(FwConstants.MESSAGE_LIST,
								abHouseHoldMemberBO.getMessageList());
						txnBean.setPageCollection((Map) session
								.get(FwConstants.BEFORE_COLLECTION));
						return;
					}
					final String appNum = (String) session.get(AppConstants.APP_NUMBER);

					final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
					indivSeqBean.setIndivSeqNum(bnftCnvctnSeq);
					indivSeqBean.setSeqNum(FwConstants.ZERO);
					indivSeqBean.setType(AppConstants.CNVCT_FRI);
					indivSeqBean.setUserEndInd(FwConstants.ZERO);
					pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

					// set driver status
					final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARBCN", driver,
							appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driver,
							appNum);
					session.put(FwConstants.RMC_DRIVER, driver);

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("addBnftCnvctnFriDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"addBnftCnvctnFriDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		
		

		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.addBnftCnvctnFriDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}
	
	public void addBnftCnvctnTraDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.addBnftCnvctnTraDetails() - START");
		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			// get cargo determining user selection
			final String bnftCnvctnSeq = request.get("firstName_tra") != null ? (String) request
					.get("firstName_tra") : FwConstants.EMPTY_STRING;

					final ABHouseHoldMemberBO abHouseHoldMemberBO = new ABHouseHoldMemberBO();
					
					// validate selections
					if (bnftCnvctnSeq == null
							|| AppConstants.SELECT_DEFAULT_OPTION
							.equals(bnftCnvctnSeq)) {
						abHouseHoldMemberBO.validateAdd(bnftCnvctnSeq,
								AppConstants.CNVCT_TRA);
						// add validation message and return
						request.put(FwConstants.MESSAGE_LIST,
								abHouseHoldMemberBO.getMessageList());
						txnBean.setPageCollection((Map) session
								.get(FwConstants.BEFORE_COLLECTION));
						return;
					}
					final String appNum = (String) session.get(AppConstants.APP_NUMBER);

					final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
					indivSeqBean.setIndivSeqNum(bnftCnvctnSeq);
					indivSeqBean.setSeqNum(FwConstants.ZERO);
					indivSeqBean.setType(AppConstants.CNVCT_TRA);
					indivSeqBean.setUserEndInd(FwConstants.ZERO);
					pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

					// set driver status
					final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARBCN", driver,
							appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driver,
							appNum);
					session.put(FwConstants.RMC_DRIVER, driver);

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("addBnftCnvctnTraDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"addBnftCnvctnTraDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		
		

		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.addBnftCnvctnTraDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}
	
	public void addBnftCnvctnPdsDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.addBnftCnvctnPdsDetails() - START");
		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			// get cargo determining user selection
			final String bnftCnvctnSeq = request.get("firstName_pds") != null ? (String) request
					.get("firstName_pds") : FwConstants.EMPTY_STRING;

					final ABHouseHoldMemberBO abHouseHoldMemberBO = new ABHouseHoldMemberBO();
					
					// validate selections
					if (bnftCnvctnSeq == null
							|| AppConstants.SELECT_DEFAULT_OPTION
							.equals(bnftCnvctnSeq)) {
						abHouseHoldMemberBO.validateAdd(bnftCnvctnSeq,
								AppConstants.CNVCT_PDS);
						// add validation message and return
						request.put(FwConstants.MESSAGE_LIST,
								abHouseHoldMemberBO.getMessageList());
						txnBean.setPageCollection((Map) session
								.get(FwConstants.BEFORE_COLLECTION));
						return;
					}
					final String appNum = (String) session.get(AppConstants.APP_NUMBER);

					final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
					indivSeqBean.setIndivSeqNum(bnftCnvctnSeq);
					indivSeqBean.setSeqNum(FwConstants.ZERO);
					indivSeqBean.setType(AppConstants.CNVCT_PDS);
					indivSeqBean.setUserEndInd(FwConstants.ZERO);
					pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

					// set driver status
					final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARBCN", driver,
							appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driver,
							appNum);
					session.put(FwConstants.RMC_DRIVER, driver);

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("addBnftCnvctnPdsDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"addBnftCnvctnPdsDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		
		

		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.addBnftCnvctnPdsDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

	public void addBnftCnvctnSfeDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.addBnftCnvctnSfeDetails() - START");
		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			// get cargo determining user selection
			final String bnftCnvctnSeq = request.get("firstName_sfe") != null ? (String) request
					.get("firstName_sfe") : FwConstants.EMPTY_STRING;

					final ABHouseHoldMemberBO abHouseHoldMemberBO = new ABHouseHoldMemberBO();
					
					// validate selections
					if (bnftCnvctnSeq == null
							|| AppConstants.SELECT_DEFAULT_OPTION
							.equals(bnftCnvctnSeq)) {
						abHouseHoldMemberBO.validateAdd(bnftCnvctnSeq,
								AppConstants.CNVCT_SFE);
						// add validation message and return
						request.put(FwConstants.MESSAGE_LIST,
								abHouseHoldMemberBO.getMessageList());
						txnBean.setPageCollection((Map) session
								.get(FwConstants.BEFORE_COLLECTION));
						return;
					}
					final String appNum = (String) session.get(AppConstants.APP_NUMBER);

					final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
					indivSeqBean.setIndivSeqNum(bnftCnvctnSeq);
					indivSeqBean.setSeqNum(FwConstants.ZERO);
					indivSeqBean.setType(AppConstants.CNVCT_SFE);
					indivSeqBean.setUserEndInd(FwConstants.ZERO);
					pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

					// set driver status
					final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARBCN", driver,
							appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driver,
							appNum);
					session.put(FwConstants.RMC_DRIVER, driver);

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("addBnftCnvctnSfeDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"addBnftCnvctnSfeDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		
		

		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.addBnftCnvctnSfeDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

	public void addBnftCnvctnUbuDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.addBnftCnvctnUbuDetails() - START");
		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			// get cargo determining user selection
			final String bnftCnvctnSeq = request.get("firstName_ubu") != null ? (String) request
					.get("firstName_ubu") : FwConstants.EMPTY_STRING;

					final ABHouseHoldMemberBO abHouseHoldMemberBO = new ABHouseHoldMemberBO();
					
					// validate selections
					if (bnftCnvctnSeq == null
							|| AppConstants.SELECT_DEFAULT_OPTION
							.equals(bnftCnvctnSeq)) {
						abHouseHoldMemberBO.validateAdd(bnftCnvctnSeq,
								AppConstants.CNVCT_UBU);
						// add validation message and return
						request.put(FwConstants.MESSAGE_LIST,
								abHouseHoldMemberBO.getMessageList());
						txnBean.setPageCollection((Map) session
								.get(FwConstants.BEFORE_COLLECTION));
						return;
					}
					final String appNum = (String) session.get(AppConstants.APP_NUMBER);

					final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
					indivSeqBean.setIndivSeqNum(bnftCnvctnSeq);
					indivSeqBean.setSeqNum(FwConstants.ZERO);
					indivSeqBean.setType(AppConstants.CNVCT_UBU);
					indivSeqBean.setUserEndInd(FwConstants.ZERO);
					pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

					// set driver status
					final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARBCN", driver,
							appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driver,
							appNum);
					session.put(FwConstants.RMC_DRIVER, driver);

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("addBnftCnvctnUbuDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"addBnftCnvctnUbuDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		
		

		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.addBnftCnvctnUbuDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

	
	public void addBnftCnvctnVQJDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.addBnftCnvctnUbuDetails() - START");
		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			// get cargo determining user selection
			final String bnftCnvctnSeq = request.get("firstName_vqj") != null ? (String) request
					.get("firstName_vqj") : FwConstants.EMPTY_STRING;

					final ABHouseHoldMemberBO abHouseHoldMemberBO = new ABHouseHoldMemberBO();
					
					// validate selections
					if (bnftCnvctnSeq == null
							|| AppConstants.SELECT_DEFAULT_OPTION
							.equals(bnftCnvctnSeq)) {
						abHouseHoldMemberBO.validateAdd(bnftCnvctnSeq,
								AppConstants.CNVCT_VQJ);
						// add validation message and return
						request.put(FwConstants.MESSAGE_LIST,
								abHouseHoldMemberBO.getMessageList());
						txnBean.setPageCollection((Map) session
								.get(FwConstants.BEFORE_COLLECTION));
						return;
					}
					final String appNum = (String) session.get(AppConstants.APP_NUMBER);

					final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
					indivSeqBean.setIndivSeqNum(bnftCnvctnSeq);
					indivSeqBean.setSeqNum(FwConstants.ZERO);
					indivSeqBean.setType(AppConstants.CNVCT_VQJ);
					indivSeqBean.setUserEndInd(FwConstants.ZERO);
					pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

					// set driver status
					final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARBCN", driver,
							appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driver,
							appNum);
					session.put(FwConstants.RMC_DRIVER, driver);

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("addBnftCnvctnUbuDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"addBnftCnvctnUbuDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		
		

		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.addBnftCnvctnUbuDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}
	
	public void addBnftCnvctnDFTDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.addBnftCnvctnUbuDetails() - START");
		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			// get cargo determining user selection
			final String bnftCnvctnSeq = request.get("firstName_dft") != null ? (String) request
					.get("firstName_dft") : FwConstants.EMPTY_STRING;

					final ABHouseHoldMemberBO abHouseHoldMemberBO = new ABHouseHoldMemberBO();
					
					// validate selections
					if (bnftCnvctnSeq == null
							|| AppConstants.SELECT_DEFAULT_OPTION
							.equals(bnftCnvctnSeq)) {
						abHouseHoldMemberBO.validateAdd(bnftCnvctnSeq,
								AppConstants.CNVCT_DFT);
						// add validation message and return
						request.put(FwConstants.MESSAGE_LIST,
								abHouseHoldMemberBO.getMessageList());
						txnBean.setPageCollection((Map) session
								.get(FwConstants.BEFORE_COLLECTION));
						return;
					}
					final String appNum = (String) session.get(AppConstants.APP_NUMBER);

					final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
					indivSeqBean.setIndivSeqNum(bnftCnvctnSeq);
					indivSeqBean.setSeqNum(FwConstants.ZERO);
					indivSeqBean.setType(AppConstants.CNVCT_DFT);
					indivSeqBean.setUserEndInd(FwConstants.ZERO);
					pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

					// set driver status
					final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARBCN", driver,
							appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "AROBS", driver,
							appNum);
					session.put(FwConstants.RMC_DRIVER, driver);

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("addBnftCnvctnUbuDetails");
			we.setFwException(fe);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"addBnftCnvctnUbuDetails", e);
			throw rmcOtherBenefitsEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		
		

		log(ILog.INFO,
				"RMCOtherBenefitsEJBBean.addBnftCnvctnUbuDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

    
    public void setSessionContext(SessionContext sessionContext){
    	ctx = sessionContext;
    }   
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public FwException exceptionManagerLog(Exception e, String className,
			String methodName) {
		return super.exceptionManagerLog(e, className, methodName);
	}

}
