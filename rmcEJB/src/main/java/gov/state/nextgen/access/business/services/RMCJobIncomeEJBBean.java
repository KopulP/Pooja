package gov.state.nextgen.access.business.services;

import gov.state.nextgen.access.business.customEntities.APP_IN_EMPL_A_WAGE_Custom_Collection;
import gov.state.nextgen.access.business.customEntities.APP_IN_EMPL_WAGE_CUST_Collection;
import gov.state.nextgen.access.business.customEntities.EMPLOYMENT_CUST_Cargo;
import gov.state.nextgen.access.business.customEntities.INDIVIDUAL_Custom_Cargo;
import gov.state.nextgen.access.business.customEntities.INDIVIDUAL_Custom_Collection;
import gov.state.nextgen.access.business.customEntities.JOBINCOME_Custom_Cargo;
import gov.state.nextgen.access.business.customEntities.JOBINCOME_Custom_Collection;
import gov.state.nextgen.access.business.customEntities.RMC_RESPONSE_Custom_Cargo;
import gov.state.nextgen.access.business.customEntities.RMC_RESPONSE_Custom_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_EMPL_A_WAGE_Cargo;
import gov.state.nextgen.access.business.entities.APP_IN_EMPL_A_WAGE_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_EMPL_Cargo;
import gov.state.nextgen.access.business.entities.APP_IN_EMPL_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_EMPL_HEALTH_Cargo;
import gov.state.nextgen.access.business.entities.APP_IN_EMPL_HEALTH_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_EMPL_HEALTH_DEP_Cargo;
import gov.state.nextgen.access.business.entities.APP_IN_EMPL_HEALTH_DEP_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_SELFE_Cargo;
import gov.state.nextgen.access.business.entities.APP_IN_SELFE_Collection;
import gov.state.nextgen.access.business.entities.RMB_RQST_Cargo;
import gov.state.nextgen.access.business.entities.RMB_RQST_Collection;
import gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Cargo;
import gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Collection;
import gov.state.nextgen.access.business.entities.RMC_RQST_Cargo;
import gov.state.nextgen.access.business.rules.ABFinalSubmitBO;
import gov.state.nextgen.access.business.rules.ABJobIncomeBO;
import gov.state.nextgen.access.business.rules.RMCEmplHlthInsBO;
import gov.state.nextgen.access.business.rules.assets.AssetBO;
import gov.state.nextgen.access.business.rules.employment.JobIncomeBO;
import gov.state.nextgen.access.business.rules.employment.SelfEmploymentBO;
import gov.state.nextgen.access.business.rules.household.HouseHoldInfoBO;
import gov.state.nextgen.access.business.rules.wages.WagesBO;
import gov.state.nextgen.access.business.validation.rmc.details.ARJSDValidator;
import gov.state.nextgen.access.management.applications.CategorySequenceDetail;
import gov.state.nextgen.access.management.applications.IRMCResponseProfileManager;
import gov.state.nextgen.access.management.applications.QuestionsExtractionHandler;
import gov.state.nextgen.access.management.applications.RMBRequestManager;
import gov.state.nextgen.access.management.applications.RMCRequestManager;
import gov.state.nextgen.access.management.constants.AppConstants;
import gov.state.nextgen.access.management.individuals.PeopleHandler;
import gov.state.nextgen.access.management.util.IndivTypeSeqBean;
import gov.state.nextgen.access.presentation.entities.listview.RMBJobIncomeListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCJobIncomeSelectionListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCJobIncomeSummaryHealthInsListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCJobIncomeSummaryJobIncomeListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCJobIncomeSummarySelfEmploymentListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCSelfEmplSelectionListView;
import gov.state.nextgen.framework.business.entities.FwTransaction;
import gov.state.nextgen.framework.driver.IDriver;
import gov.state.nextgen.framework.exceptions.FwException;
import gov.state.nextgen.framework.exceptions.FwExceptionManager;
import gov.state.nextgen.framework.exceptions.FwWrappedException;
import gov.state.nextgen.framework.exceptions.IException;
import gov.state.nextgen.framework.factories.FwServiceFactory;
import gov.state.nextgen.framework.management.constants.FwConstants;
import gov.state.nextgen.framework.management.logging.ILog;
import gov.state.nextgen.framework.management.messages.FwMessageList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
 * RMCJobIncomeEJBBean - SessionFacade Object.
 *
 * @author Surendra Nath
 * Creation Date :Tue Jun 06 22:35:28 CDT 2006
 */
@javax.ejb.Stateless
@javax.ejb.LocalBean
@javax.ejb.TransactionManagement(javax.ejb.TransactionManagementType.CONTAINER)
public class RMCJobIncomeEJBBean extends RMCSessionBean {
    
    /** The Constant APP_IN_EMPL_COLLECTION_KEY. */
    private static final String APP_IN_EMPL_COLLECTION_KEY = "APP_IN_EMPL_Collection";
    @EJB
    private RMCJobIncomeEJBBean rmcJobIncomeEJBBean;

    /**
     * Constructor.
     */
    public RMCJobIncomeEJBBean() {
    }
    
    public void setSessionContext(SessionContext sessionContext){
    	ctx=sessionContext;
    }
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
     * Load job income gate post questions.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     * @throws javax.ejb.EJBException the javax.ejb. ejb exception
     */
    public void loadJobIncomeGatePostQuestions(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO,
                "RMCJobIncomeEJBBean.loadJobIncomeGatePostQuestions() - START");
        try {
            log(ILog.INFO,
                    "RMCJobIncomeEJBBean::loadJobIncomeGatePostQuestions:Start");

            final Map session = txnBean.getSession();
            final Map pageCollection = txnBean.getPageCollection();
            txnBean.getRequest();
            Map beforeColl = (Map) session.get(FwConstants.BEFORE_COLLECTION);
            final PeopleHandler peopleHandler = (PeopleHandler) session
                    .get(AppConstants.INDIV_MASTER_HANDLER);
            final INDIVIDUAL_Custom_Collection indvColl = peopleHandler
                    .getInHomeIndividuals();
            final JobIncomeBO jobIncomeBO = new JobIncomeBO();
            final Map httpSessMap = (Map) session.get(FwConstants.HTTP_SESSION);
            final String language = (String) httpSessMap
                    .get(FwConstants.LANGUAGE);
            final String appNum = (String) session.get(AppConstants.APP_NUMBER);
            final List dataList = new ArrayList();

            final HouseHoldInfoBO hhBO = new HouseHoldInfoBO();
            final long acaseNum = hhBO.getcaseNumber(appNum);
            final String aCaseNum = Long.toString(acaseNum);

            // Getting RMC_IN_PROFILE from session
            final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
                    .get(AppConstants.RMC_IN_PRFL_MASTER);

            // get questions extraction handler from session
            final QuestionsExtractionHandler extractionHandler = (QuestionsExtractionHandler) session
                    .get(AppConstants.QUESTION_EXTRACTION_HANDLER);
            // now get the components for the current page
            componentManager.getComponents(AppConstants.ARJGQ, txnBean);
            // get component list from page collection
            final List cpntList = (ArrayList) pageCollection
                    .get(FwConstants.PAGE_COMPONENT_LIST);
            // intialize webservice type array
            final List typeArrayList = new ArrayList();

            // Checking if extraction is complete.
            if (cpntList.contains("5230")
                    && !extractionHandler.checkRMBExtractionStatus(
                            AppConstants.ARJGQ, "5230")
                            && !extractionHandler.checkRMBExtractionStatus(
                                    AppConstants.ARJGQ, "5259")) {
                typeArrayList.add(AppConstants.JI_EXT);
            }
            // If the first component rules does not exist check for the second
            if (!cpntList.contains("5230")
                    && cpntList.contains("5259")
                    && !extractionHandler.checkRMBExtractionStatus(
                            AppConstants.ARJGQ, "5259")
                            && !extractionHandler.checkRMBExtractionStatus(
                                    AppConstants.ARJGQ, "5230")) {
                typeArrayList.add(AppConstants.JI_EXT);
            }

            if (!typeArrayList.isEmpty()) {
                final Map pinNumMap = new HashMap();
                final int indvCollSize = indvColl.size();
                INDIVIDUAL_Custom_Cargo indivCustCargo = null;
                APP_IN_SELFE_Collection selfEmpColl = null;
                // Filter pin numbers which are null (new individuals) - PCR
                // 30457
                String pinNumber = null;
                for (int i = 0; i < indvCollSize; i++) {
                    indivCustCargo = indvColl.getResult(i);
                    pinNumber = indivCustCargo.getIndv_pin_num();
                    if (pinNumber != null) {
                        pinNumMap.put(indivCustCargo.getIndv_pin_num(),
                                indivCustCargo.getIndv_seq_num());
                    }
                }
                Map employmentDetails = new HashMap();
                try {
                    if (pinNumMap != null && !pinNumMap.isEmpty()) {
                        final EMPLOYMENT_CUST_Cargo employmentCustCargo = jobIncomeBO
                                .getEmploymentDetailsFromCares(pinNumMap,
                                        appNum, aCaseNum);
                        if (employmentCustCargo != null) {
                            if (employmentCustCargo.getEmploymentColl() != null
                                    && !employmentCustCargo.getEmploymentColl()
                                    .isEmpty()) {
                                final APP_IN_EMPL_WAGE_CUST_Collection empCustColl = employmentCustCargo
                                        .getEmploymentColl();
                                employmentDetails = jobIncomeBO
                                        .getEmploymentColl(empCustColl, appNum);
                                final APP_IN_EMPL_Collection appInemplColl = (APP_IN_EMPL_Collection) employmentDetails
                                        .get(APP_IN_EMPL_COLLECTION_KEY);
                                final APP_IN_EMPL_A_WAGE_Collection appInemplAWageColl = (APP_IN_EMPL_A_WAGE_Collection) employmentDetails
                                        .get("APP_IN_EMPL_A_WAGE_Collection");
                                final WagesBO wagesBo = new WagesBO();
                                if (appInemplColl != null) {
                                    jobIncomeBO
                                    .insertExistingDetails(appInemplColl);
                                    extractionHandler.addRMBExtractionStatus(
                                            AppConstants.ARJGQ, "5230");
                                    extractionHandler.addRMBExtractionStatus(
                                            AppConstants.ARJGQ, "5259");
                                }
                                if (appInemplAWageColl != null) {
                                    wagesBo.storeDetails(appInemplAWageColl);
                                }
                            }
                            if (employmentCustCargo.getSelfEmpColl() != null
                                    && !employmentCustCargo.getSelfEmpColl()
                                    .isEmpty()) {
                                selfEmpColl = employmentCustCargo
                                        .getSelfEmpColl();
                                if (selfEmpColl != null) {
                                    jobIncomeBO
                                    .insertSelfEmpExistingDetails(selfEmpColl);
                                    extractionHandler.addRMBExtractionStatus(
                                            AppConstants.ARJGQ, "5230");
                                    extractionHandler.addRMBExtractionStatus(
                                            AppConstants.ARJGQ, "5259");
                                }
                            }
                        }
                    }
                } catch (final FwException fe) {
                    fe.setParameterText("Pin List is: " + pinNumMap.toString()
                            + " AppNumber is: " + appNum);
                    final FwWrappedException we = new FwWrappedException(fe);
                    we.setCallingClassID(this.getClass().getName());
                    we.setCallingMethodID("loadJobIncomeGatePostQuestions");
                    we.setFwException(fe);
                    final FwExceptionManager exceptionMgr = (FwExceptionManager) FwServiceFactory
                            .getInstance().create(IException.class);
                    exceptionMgr.log(we);
                    return;

                } catch (final Exception e) {
                    final FwException fe = createFwException(this.getClass()
                            .getName(), "getEmploymentDetailsFromCares", e);
                    fe.setParameterText("Pin List is: " + pinNumMap.toString()
                            + " AppNumber is: " + appNum);
                    final FwWrappedException we = new FwWrappedException(e);
                    we.setCallingClassID(this.getClass().getName());
                    we.setCallingMethodID("loadJobIncomeGatePostQuestions");
                    we.setFwException(fe);
                    final FwExceptionManager exceptionMgr = (FwExceptionManager) FwServiceFactory
                            .getInstance().create(IException.class);
                    exceptionMgr.log(we);
                    return;
                }
            }

            pageCollection.put(FwConstants.PAGE_COMPONENT_LIST, typeArrayList);
            final APP_IN_EMPL_Collection appInEmplColl = jobIncomeBO
                    .loadDetails(appNum);

            final APP_IN_EMPL_A_WAGE_Collection appInEmplWageColl = jobIncomeBO
                    .getAppInAWageDetails(appNum);
            session.get(FwConstants.ACCESS_APPLICATION_TYPE);

            final APP_IN_EMPL_A_WAGE_Custom_Collection regColl = jobIncomeBO
                    .convertJobIncomeToCustomCargo(appInEmplColl,
                            appInEmplWageColl, AppConstants.EMPL_REGULAR);
            dataList.add(regColl);
            dataList.add(rmcInPrflColl);

            final RMBJobIncomeListView rmbJobIncomeListView = new RMBJobIncomeListView();
            rmbJobIncomeListView.setLanguage(language);
            rmbJobIncomeListView.setName("JOB_IN");
            rmbJobIncomeListView.setCollection(indvColl);
            rmbJobIncomeListView.setDisplayData(dataList);
            rmbJobIncomeListView.setPageSize(1000);
            pageCollection.put("JOB_IN", rmbJobIncomeListView);
            pageCollection.put("JOB_IN_COLL", appInEmplColl);


            // if comming back load with previously selection resposnes
            // get current page driver status
            final int[] driverArray = (int[]) session
                    .get(FwConstants.RMC_DRIVER);
            final int currentPageStaus = driverManager.getAFBStatus(
                    FwConstants.RMC_DRIVER, AppConstants.ARJGQ, driverArray);
            // get session RMC_CHG_SEL_PRFL
            SortedSet sessChgSelectionProfile = (SortedSet) session
                    .get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
            // this map holds the response of
            Map securityRadioOptionsMap = new HashMap();
            final RMBRequestManager rmbRqstManager = new RMBRequestManager();
            final RMC_IN_PRFL_Collection sessRMCInPrflColl = (RMC_IN_PRFL_Collection) session
                    .get(AppConstants.RMC_IN_PRFL_MASTER);
            final RMB_RQST_Collection sessRMBRqstColl = (RMB_RQST_Collection) session
                    .get(AppConstants.RMB_RQST_COLLECTION);

            if (currentPageStaus != FwConstants.DRIVER_REQUIRED) {// than the
                // user is
                // re-visiting
                // the page
                // call RMBRequest Manager to get the question response
                sessChgSelectionProfile = categorySelectionProfileManager
                        .loadCategoryChangeSelectionProfile(appNum,
                                AppConstants.RMC_CAT_EMP_PRFL);

                securityRadioOptionsMap = rmbRqstManager.getStatusForGatePost(
                        AppConstants.RMB_JOB_INCOME_GATE_POST_PAGE,
                        sessRMBRqstColl, driverArray, sessRMCInPrflColl,
                        sessChgSelectionProfile, peopleHandler);
                pageCollection.put("RADIO_OPTION_MAP", securityRadioOptionsMap);
            }

            if (beforeColl == null) {
                beforeColl = new HashMap();
                session.put(FwConstants.BEFORE_COLLECTION, beforeColl);
            }
            session.put(FwConstants.BEFORE_COLLECTION,
                    txnBean.getPageCollection());
            beforeColl.putAll(pageCollection);
            componentManager.getComponents(AppConstants.ARJGQ, txnBean);
            log(ILog.INFO,
                    "RMCJobIncomeEJBBean::loadJobIncomeGatePostQuestions:End");
        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("loadJobIncomeGatePostQuestions");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "loadJobIncomeGatePostQuestions", e);
            throw rmcJobIncomeEJBBean.rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.loadJobIncomeGatePostQuestions() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Store job income gate post questions.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     * @throws javax.ejb.EJBException the javax.ejb. ejb exception
     */
    public void storeJobIncomeGatePostQuestions(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO,
                "RMCJobIncomeEJBBean.storeJobIncomeGatePostQuestions() - START");
        try {
            log(ILog.INFO,
                    "RMCJobIncomeEJBBean::storeJobIncomeGatePostQuestions:Start");

            final Map session = txnBean.getSession();
            final Map request = txnBean.getRequest();
            final Map pageCollection = txnBean.getPageCollection();
            session.get(FwConstants.HTTP_SESSION);
            final Map beforeColl = (Map) session
                    .get(FwConstants.BEFORE_COLLECTION);
            final RMBRequestManager rmbRqstManager = new RMBRequestManager();
            // Get driver info.
            final int[] driverArray = (int[]) session
                    .get(FwConstants.RMC_DRIVER);
            // Get appNumber from the session
            final String appNum = (String) session.get(AppConstants.APP_NUMBER);
            session.get(AppConstants.CASE_NUMBER);
            session.get(FwConstants.ACCESS_APPLICATION_TYPE);
            // get people handler from session
            final PeopleHandler peopleHandler = (PeopleHandler) session
                    .get(AppConstants.INDIV_MASTER_HANDLER);
            session.get(AppConstants.QUESTION_EXTRACTION_HANDLER);
            // get RMB_RQST_Collection from pageCollection
            final RMB_RQST_Collection pageRMBRqstColl = (RMB_RQST_Collection) pageCollection
                    .get("RMB_RQST_Collection");
            RMB_RQST_Cargo pageRMBRqstCargo = null;
            // get session RMB_RQST_COlleaction
            final RMB_RQST_Collection sessRMBRqstColl = (RMB_RQST_Collection) session
                    .get("RMB_RQST_COLLECTION");
            // get current page status
            final int currentPageStaus = driverManager.getAFBStatus(
                    FwConstants.RMC_DRIVER, AppConstants.ARJGQ, driverArray);

            final int aARJSEPageStatus = driverManager.getAFBStatus(
                    FwConstants.RMC_DRIVER, "ARJSE", driverArray);
            boolean pARJSEReqFlag = false;

            RMB_RQST_Cargo sessRMBRqstCargo = null;
            if (sessRMBRqstColl != null) {
                sessRMBRqstCargo = sessRMBRqstColl.getCargo(0);
            }

            beforeColl.get(FwConstants.PAGE_COMPONENT_LIST);
            // now do the validation
            final JobIncomeBO validationBO = new JobIncomeBO();
            // get RMB_RQST_Cargo
            pageRMBRqstCargo = pageRMBRqstColl.getCargo(0);

            final String backToMyAccess = (String) request
                    .get(AppConstants.BACK_TO_MY_ACCESS_BUTTON);

            if (backToMyAccess == null) {
                // Rmvd CompList
                validationBO.validateJobIncomeGatePost(pageRMBRqstCargo);
            }

            if (checkBackToMyAccessSelected(request)
                    || validationBO.hasMessages()) {

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

                pageCollection.put("JOB_IN", beforeColl.get("JOB_IN"));

                pageCollection
                .put("JOB_IN_COLL", beforeColl.get("JOB_IN_COLL"));
                pageCollection.put(AppConstants.INDV_COLL,
                        beforeColl.get(AppConstants.INDV_COLL));
                pageCollection.put(FwConstants.PAGE_COMPONENT_LIST,
                        beforeColl.get(FwConstants.PAGE_COMPONENT_LIST));

                pageCollection.put("RMB_RQST_PAGE_Collection",
                        beforeColl.get("RMB_RQST_PAGE_Collection"));
                if (driverManager.getAFBStatus(FwConstants.RMC_DRIVER,
                        AppConstants.ARJGQ, driverArray) == FwConstants.DRIVER_REQUIRED) {
                    pageCollection.put("RADIO_OPTION_MAP", rmbRqstManager
                            .getStatusForGatePostAfterValidation(
                                    AppConstants.RMB_JOB_INCOME_GATE_POST_PAGE,
                                    pageRMBRqstColl));
                } else {
                    final RMC_IN_PRFL_Collection sessRMCInPrflColl = (RMC_IN_PRFL_Collection) session
                            .get(AppConstants.RMC_IN_PRFL_MASTER);
                    // get session RMC_CHG_SEL_PRFL
                    final SortedSet sessChgSelectionProfile = (SortedSet) session
                            .get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
                    pageCollection.put("RADIO_OPTION_MAP", rmbRqstManager
                            .getStatusForGatePost(
                                    AppConstants.RMB_JOB_INCOME_GATE_POST_PAGE,
                                    sessRMBRqstColl, driverArray,
                                    sessRMCInPrflColl, sessChgSelectionProfile,
                                    peopleHandler));
                }

                session.put(FwConstants.BEFORE_COLLECTION, pageCollection);

                return;
            }
            // get complete cargo
            pageRMBRqstCargo = rmbRqstManager.getCompleteCargo(
                    sessRMBRqstCargo, pageRMBRqstCargo);
            // now call ischanged
            pageRMBRqstCargo = (RMB_RQST_Cargo) isChanged(sessRMBRqstCargo,
                    pageRMBRqstCargo);
            if (currentPageStaus != FwConstants.DRIVER_REQUIRED) {// than the
                // user is
                // re-visiting
                // the page
                rmbRqstManager.changeStatusOnGatePost(pageRMBRqstColl, session,
                        AppConstants.RMB_JOB_INCOME_GATE_POST_PAGE);
            }
            // check if collection is Dirty Update RMBRequest Table with user
            // response .
            if (pageRMBRqstCargo.isDirty()) {
                pageRMBRqstCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
                final RMB_RQST_Collection rmbRqstColl = new RMB_RQST_Collection();
                rmbRqstColl.add(pageRMBRqstCargo);
                rmbRqstManager.storeRMBRqst(rmbRqstColl);
                // put the update RMB_RQST_Collection into session
                session.put(AppConstants.RMB_RQST_COLLECTION, rmbRqstColl);
            }

            // Update Driver to schedule required Job income change selection
            // page
            if (FwConstants.YES.equals(pageRMBRqstCargo.getEmpl_stat_ind())
                    && (FwConstants.NO.equals(sessRMBRqstCargo
                            .getEmpl_stat_ind()) || FwConstants.HIDDEN
                            .equals(sessRMBRqstCargo.getEmpl_stat_ind()))) {
                driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARJSE",
                        driverArray, appNum);
                pARJSEReqFlag = true;
            } else if (FwConstants.YES.equals(pageRMBRqstCargo
                    .getEmpl_stat_ind())
                    && (aARJSEPageStatus == FwConstants.DRIVER_REQUIRED || aARJSEPageStatus == FwConstants.DRIVER_VISIT_AGAIN)) {
                pARJSEReqFlag = true;
            }
            // EDSP DO NOT NEED

            if (!pARJSEReqFlag) {
                driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
                        "ARJSE", driverArray, appNum);
            } else {
                driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARJSE",
                        driverArray, appNum);
            }

            driverManager.makeComplete(FwConstants.RMC_DRIVER,
                    AppConstants.ARJGQ, driverArray, appNum);
            driverManager.makeRequired(FwConstants.RMC_DRIVER,
                    AppConstants.ARJIS, driverArray, appNum);
            log(ILog.INFO,
                    "RMCJobIncomeEJBBean::storeJobIncomeGatePostQuestions:End");

            log(ILog.INFO,
                    "RMCJobIncomeEJBBean.storeJobIncomeGatePostQuestions() - END , Time Taken : "
                            + (System.currentTimeMillis() - startTime)
                            + AppConstants.SPACE + AppConstants.MILLISECONDS);
            return;
        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("storeJobIncomeGatePostQuestions");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "storeJobIncomeGatePostQuestions", e);
            throw rmcJobIncomeEJBBean.rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }
    }

    /**
     * Comment here.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */
    public void loadJobIncomeSelection(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.loadJobIncomeSelection() - START");
        try {
            final Map session = txnBean.getSession();
            final Map pageCollection = txnBean.getPageCollection();
            final Map request = txnBean.getRequest();
            final PeopleHandler peopleHandler = (PeopleHandler) session
                    .get(AppConstants.INDIV_MASTER_HANDLER);
            // PCR 30516 - Get only In Home individuals
            final INDIVIDUAL_Custom_Collection indvColl = peopleHandler
                    .getInHomeIndividuals();

            final Map httpSessionMap = (Map) session
                    .get(FwConstants.HTTP_SESSION);
            final String language = (String) httpSessionMap
                    .get(AppConstants.LANGUAGE);
            final String jsEnabled = (String) httpSessionMap
                    .get(FwConstants.JS_ENABLED);

            final String aAppNum = (String) session
                    .get(AppConstants.APP_NUMBER);
            final HouseHoldInfoBO hhBO = new HouseHoldInfoBO();
            final long acaseNum = hhBO.getcaseNumber(aAppNum);
            final String aCaseNum = Long.toString(acaseNum);
            log(ILog.INFO, "+++++loadJobIncomeSelection - casenum=" + aCaseNum
                    + " appnum=" + aAppNum);
            final JobIncomeBO jobIncomeBO = new JobIncomeBO();
            final int[] driverArray = (int[]) session
                    .get(FwConstants.RMC_DRIVER);
            final int driverStatus = driverManager.getAFBStatus(
                    FwConstants.RMC_DRIVER,
                    (String) request.get(FwConstants.CURRENT_PAGE_ID),
                    driverArray);

            // determine agency contact number
            String agencyContactNo = null;
            final RMCRequestManager rmcRqstManager = new RMCRequestManager();
            final RMC_RQST_Cargo rmcCargo = rmcRqstManager
                    .loadRMCRequest(aAppNum);
            if (rmcCargo != null) {
                agencyContactNo = jobIncomeBO.getAgencyContactNo(rmcCargo
                        .getCase_num());
                // Put this agencyContactNo into page collection
                pageCollection.put(AppConstants.AGENCY_CONTACT_NO,
                        agencyContactNo);
            }
            boolean[] categoryExtratFlags = null;
            if (null != session.get(AppConstants.RMC_EXTRACTION_FLAGS)) {
                categoryExtratFlags = (boolean[]) session
                        .get(AppConstants.RMC_EXTRACTION_FLAGS);
            } else {
                categoryExtratFlags = new boolean[11];
            }

            categoryExtratFlags[0] = true;
            if (!categoryExtratFlags[AppConstants.RMC_EXT_EMP_INDEX]) {
                final Map pinNumMap = new HashMap();
                final int indvCollSize = indvColl.size();
                INDIVIDUAL_Custom_Cargo indivCustCargo = null;
                // Filter pin numbers which are null (new individuals) - PCR
                // 30457
                String pinNumber = null;
                for (int i = 0; i < indvCollSize; i++) {
                    indivCustCargo = indvColl.getResult(i);
                    pinNumber = indivCustCargo.getIndv_pin_num();
                    indivCustCargo.getIndv_seq_num();
                    if (pinNumber != null) {
                        pinNumMap.put(indivCustCargo.getIndv_pin_num(),
                                indivCustCargo.getIndv_seq_num());
                    }
                }
                Map employmentDetails = new HashMap();
                try {
                    if (pinNumMap != null && !pinNumMap.isEmpty()) {
                        final EMPLOYMENT_CUST_Cargo employmentCustCargo = jobIncomeBO
                                .getEmploymentDetailsFromCares(pinNumMap,
                                        aAppNum, aCaseNum);
                        if (employmentCustCargo != null) {
                            if (employmentCustCargo.getEmploymentColl() != null
                                    && !employmentCustCargo.getEmploymentColl()
                                    .isEmpty()) {
                                final APP_IN_EMPL_WAGE_CUST_Collection empCustColl = employmentCustCargo
                                        .getEmploymentColl();
                                employmentDetails = jobIncomeBO
                                        .getEmploymentColl(empCustColl, aAppNum);
                                final APP_IN_EMPL_Collection appInemplColl = (APP_IN_EMPL_Collection) employmentDetails
                                        .get(APP_IN_EMPL_COLLECTION_KEY);
                                final APP_IN_EMPL_A_WAGE_Collection appInemplAWageColl = (APP_IN_EMPL_A_WAGE_Collection) employmentDetails
                                        .get("APP_IN_EMPL_A_WAGE_Collection");
                                final WagesBO wagesBo = new WagesBO();
                                if (appInemplColl != null) {
                                    jobIncomeBO
                                    .insertExistingDetails(appInemplColl);
                                    categoryExtratFlags[AppConstants.RMC_EXT_EMP_INDEX] = true;
                                    session.put(
                                            AppConstants.RMC_EXTRACTION_FLAGS,
                                            categoryExtratFlags);
                                }
                                if (appInemplAWageColl != null) {
                                    wagesBo.storeDetails(appInemplAWageColl);
                                }
                            }

                        }
                    }
                } catch (final FwException fe) {
                    fe.setParameterText("Pin Map is: " + pinNumMap.toString()
                            + " AppNumber is: " + aAppNum);
                    final FwWrappedException we = new FwWrappedException(fe);
                    we.setCallingClassID(this.getClass().getName());
                    we.setCallingMethodID("loadJobIncomeSelection");
                    we.setFwException(fe);
                    final FwExceptionManager exceptionMgr = (FwExceptionManager) FwServiceFactory
                            .getInstance().create(IException.class);
                    exceptionMgr.log(we);
                    return;

                } catch (final Exception e) {
                    final FwException fe = createFwException(this.getClass()
                            .getName(), "getEmploymentDetailsFromCares", e);
                    fe.setParameterText("Pin Map is: " + pinNumMap.toString()
                            + " AppNumber is: " + aAppNum);
                    final FwWrappedException we = new FwWrappedException(e);
                    we.setCallingClassID(this.getClass().getName());
                    we.setCallingMethodID("loadJobIncomeSelection");
                    we.setFwException(fe);
                    final FwExceptionManager exceptionMgr = (FwExceptionManager) FwServiceFactory
                            .getInstance().create(IException.class);
                    exceptionMgr.log(we);
                    return;
                }
            }
            final INDIVIDUAL_Custom_Collection indvSortedCustColl = null;
            final SelfEmploymentBO selfBO = new SelfEmploymentBO();

            final APP_IN_EMPL_Collection jobColl = jobIncomeBO
                    .loadDetails(aAppNum);
            final APP_IN_EMPL_Collection inKindColl = jobIncomeBO
                    .loadInKindDetails(aAppNum);

            final APP_IN_SELFE_Collection selfColl = selfBO
                    .listViewData(aAppNum);

            SortedSet selectionProfile = (SortedSet) session
                    .get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
            boolean loadCatSelProfile = false;
            if ((selectionProfile == null || selectionProfile.isEmpty())
                    && driverStatus != FwConstants.DRIVER_NOT_REQUIRED) {
                // load selection profile form the data base
                loadCatSelProfile = true;
            } else if (selectionProfile != null && !selectionProfile.isEmpty()) {
                // here we need to check the session profile is job income
                // session profile
                CategorySequenceDetail catSeqDetail = categorySelectionProfileManager
                        .getCurrentSequenceDetail(selectionProfile);
                if (catSeqDetail == null) {
                    catSeqDetail = categorySelectionProfileManager
                            .getNextSequenceDetail(selectionProfile);
                    if (catSeqDetail != null
                            && AppConstants.RMC_CAT_EMP_PRFL
                            .equals(catSeqDetail
                                    .getChangeSelectionCategoryCd())) {
                        loadCatSelProfile = false;
                    } else {
                        loadCatSelProfile = true;
                    }
                }
            }
            // now loading the cat selection profile form the data base
            if (loadCatSelProfile) {
                selectionProfile = categorySelectionProfileManager
                        .loadCategoryChangeSelectionProfile(aAppNum,
                                AppConstants.RMC_CAT_EMP_PRFL);
                session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER,
                        selectionProfile);
            }

            // Getting RMC_IN_PROFILE from session
            final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
                    .get(AppConstants.RMC_IN_PRFL_MASTER);

            final List jobDataList = new ArrayList();
            jobDataList.add(jobColl);
            jobDataList.add(indvColl);
            jobDataList.add(selectionProfile);
            jobDataList.add(rmcInPrflColl);
            jobDataList.add(driverStatus);

            final List inKindDataList = new ArrayList();
            inKindDataList.add(inKindColl);
            inKindDataList.add(indvColl);
            inKindDataList.add(selectionProfile);
            inKindDataList.add(rmcInPrflColl);
            inKindDataList.add(driverStatus);

            // EDSP CMMT

            final List selfEmplDataList = new ArrayList();
            selfEmplDataList.add(selfColl);
            selfEmplDataList.add(indvColl);
            selfEmplDataList.add(selectionProfile);
            selfEmplDataList.add(rmcInPrflColl);
            selfEmplDataList.add(driverStatus);

            final RMCJobIncomeSelectionListView rmcJobIncomeSelectionListView = new RMCJobIncomeSelectionListView();
            // Preparing listView for regular job
            rmcJobIncomeSelectionListView.setLanguage(language);
            rmcJobIncomeSelectionListView.setJsEnabled(jsEnabled);
            rmcJobIncomeSelectionListView.setName("INCOME_SELECTION_LISTVIEW");
            rmcJobIncomeSelectionListView.setCollection(indvColl);
            rmcJobIncomeSelectionListView.setDisplayData(jobDataList);
            rmcJobIncomeSelectionListView.setPageSize(1000);

          
            pageCollection.put("INCOME_SELECTION_LISTVIEW",
                    rmcJobIncomeSelectionListView);
            pageCollection.put(AppConstants.INDV_COLL, indvColl);
            pageCollection.put("JOB_INCOME", jobColl);
            pageCollection.put("INKIND_INCOME", inKindColl);

            // set pageCollection into transaction Bean
            txnBean.setPageCollection(pageCollection);
            // set before collection to pageCollection
            session.put(FwConstants.BEFORE_COLLECTION,
                    txnBean.getPageCollection());

            final RMCSelfEmplSelectionListView rmcSelfEmplSelectionListView = new RMCSelfEmplSelectionListView();
            // Preparing listView for inkind job
            rmcSelfEmplSelectionListView.setLanguage(language);
            rmcSelfEmplSelectionListView.setJsEnabled(jsEnabled);
            rmcSelfEmplSelectionListView
            .setName("SELF_EMPL_SELECTION_LISTVIEW");
            rmcSelfEmplSelectionListView.setCollection(indvSortedCustColl);
            rmcSelfEmplSelectionListView.setDisplayData(selfEmplDataList);
            rmcSelfEmplSelectionListView.setPageSize(1000);

            // Populating pageCollection with respective response maps

            pageCollection.put("SELF_EMPL_SELECTION_LISTVIEW",
                    rmcSelfEmplSelectionListView);

            pageCollection.put("SELF_EMPL", selfColl);

        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("loadJobIncomeSelection");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "loadJobIncomeSelection", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.loadJobIncomeSelection() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Comment here.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */
    public void storeJobIncomeSelection(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.storeJobIncomeSelection() - START");
        try {

            // EDSP Commented

            final Map session = txnBean.getSession();
            final Map request = txnBean.getRequest();
            final Map pageCollection = txnBean.getPageCollection();
            final String currentPageID = (String) request
                    .get(FwConstants.CURRENT_PAGE_ID);
            final Map beforeColl = (Map) session
                    .get(FwConstants.BEFORE_COLLECTION);
            final RMC_RESPONSE_Custom_Collection beforeRespColl = (RMC_RESPONSE_Custom_Collection) pageCollection
                    .get("RMC_RESPONSE_Custom_Collection");
            final RMC_RESPONSE_Custom_Collection respColl = new RMC_RESPONSE_Custom_Collection();
            for (int i = 0; i < beforeRespColl.size(); i++) {
                RMC_RESPONSE_Custom_Cargo rmcCustomCargo = null;
                rmcCustomCargo = beforeRespColl.getCargo(i);
                if (!FwConstants.NO.equalsIgnoreCase(rmcCustomCargo
                        .getResponse())) {
                    respColl.add(rmcCustomCargo);
                }

            }
            // Get App Number
            final String appNum = (String) session.get(AppConstants.APP_NUMBER);
            final AssetBO assetBO = new AssetBO();
            assetBO.formatAssetResponse(respColl);
            final short[] responseArray = new short[] {
                    IRMCResponseProfileManager.REGULAR_EMPL,
                    IRMCResponseProfileManager.JOB_IN_KIND,
                    IRMCResponseProfileManager.SELF_EMPLOYMENT };
            // build category selection profile
            SortedSet categorySelectionProfile = (SortedSet) session
                    .get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
            // Getting RMC_IN_PROFILE from session
            RMC_IN_PRFL_Collection rmcInPrflSessColl = (RMC_IN_PRFL_Collection) session
                    .get(AppConstants.RMC_IN_PRFL_MASTER);
            final JobIncomeBO jobIncomeBO = new JobIncomeBO();
            RMC_RESPONSE_Custom_Cargo rmcCustomCargo = null;
            int size = respColl.size();
            RMC_IN_PRFL_Collection rmcPrflPageColl = null;
            RMC_IN_PRFL_Cargo rmcPrflSessCargo = null;
            RMC_IN_PRFL_Cargo rmcPrflPageCargo = null;

            final Map assetValidationMap = new HashMap();

            assetValidationMap.put("JOB_INCOME", beforeColl.get("JOB_INCOME"));
            assetValidationMap.put("SELF_EMPL", beforeColl.get("SELF_EMPL"));
            assetValidationMap.put("INKIND_INCOME",
                    beforeColl.get("INKIND_INCOME"));
            String seqNum = null;
            String catType = null;
            String indvSeqNum = null;
            boolean addInd = false;
            for (int i = 0; i < size; i++) {
                rmcCustomCargo = respColl.getCargo(i);
                seqNum = rmcCustomCargo.getSeqNum();
                catType = rmcCustomCargo.getCategoryType();
                indvSeqNum = rmcCustomCargo.getIndvSeqNum();
                rmcCustomCargo.getResponse();

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
                    if (AppConstants.EMPL_REGULAR.equals(catType)) {
                        rmcPrflPageCargo.setEmpl_resp(FwConstants.YES);
                    } else if (AppConstants.EMPL_INKIND.equals(catType)) {
                        rmcPrflPageCargo.setJob_iknd_resp(FwConstants.YES);
                    } else if (AppConstants.EMPL_SELF.equals(catType)) {
                        rmcPrflPageCargo.setSelf_empl_resp(FwConstants.YES);
                    }

                    if (rmcPrflSessCargo.getEmpl_resp() == null) {
                        rmcPrflSessCargo.setEmpl_resp(FwConstants.NO);
                    }

                    addInd = true;
                    respColl.remove(i);
                    size--;
                    i--;
                }
            }
            session.put(AppConstants.RMC_IN_PRFL_MASTER, rmcInPrflSessColl);
            final String backToMyAccess = (String) request
                    .get(AppConstants.BACK_TO_MY_ACCESS_BUTTON);
            if (backToMyAccess == null) {
                // add new selected and that one is disable then no need to
                // doOst
                // any valiaction

                /**jobIncomeBO.validateJobEnd(respColl, assetValidationMap);*/

                jobIncomeBO.validateIncomeSelection(respColl, addInd,
                        assetValidationMap);

            }
            // PCR 30587 - Added the warning message logic when no selection is
            // made
            boolean isWarningMessageShown = false;

            // Below variable contains list of all the warning message codes
            // displayed previously on this page delimited by '~'
            String reqWarningMsgs = FwConstants.EMPTY_STRING;
            if (request.get(FwConstants.WARNING_MSG_DETAILS) != null) {
                reqWarningMsgs = (String) request
                        .get(FwConstants.WARNING_MSG_DETAILS);
            }

            FwMessageList msgList = null;

            if (jobIncomeBO.hasMessages()) {
                msgList = jobIncomeBO.getMessageList();
                if (reqWarningMsgs != null
                        && reqWarningMsgs.trim().length() > 0) {
                    // First check if no-selection warning message is in the
                    // previously displayed list and then if it is also present
                    // in the current list.
                    if (reqWarningMsgs.indexOf("00305") > -1) {
                        if (checkForWarningMesgs("00305", msgList)) {
                            isWarningMessageShown = true;
                        }
                    }
                    if (reqWarningMsgs.indexOf("00306") > -1) {
                        if (checkForWarningMesgs("00306", msgList)) {
                            isWarningMessageShown = true;
                        }
                    }
                    if (reqWarningMsgs.indexOf("00803") > -1) {
                        if (checkForWarningMesgs("00803", msgList)) {
                            isWarningMessageShown = true;
                        }
                    }
                }
            }
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

                final RMCJobIncomeSelectionListView rmcJobIncomeSelectionListView = (RMCJobIncomeSelectionListView) beforeColl
                        .get("INCOME_SELECTION_LISTVIEW");
                final INDIVIDUAL_Custom_Collection indvColl = (INDIVIDUAL_Custom_Collection) beforeColl
                        .get(AppConstants.INDV_COLL);
                final APP_IN_EMPL_Collection jobColl = (APP_IN_EMPL_Collection) beforeColl
                        .get("JOB_INCOME");

                final APP_IN_EMPL_Collection inKindColl = (APP_IN_EMPL_Collection) beforeColl
                        .get("INKIND_INCOME");

                final RMCSelfEmplSelectionListView rmcSelfEmplSelectionListView = (RMCSelfEmplSelectionListView) beforeColl
                        .get("SELF_EMPL_SELECTION_LISTVIEW");
                final APP_IN_SELFE_Collection selfColl = (APP_IN_SELFE_Collection) beforeColl
                        .get("SELF_EMPL");
                final int[] driverArray = (int[]) session
                        .get(FwConstants.RMC_DRIVER);
                final int driverStatus = driverManager.getAFBStatus(
                        FwConstants.RMC_DRIVER,
                        (String) request.get(FwConstants.CURRENT_PAGE_ID),
                        driverArray);

                final List jobDataList = new ArrayList();
                jobDataList.add(jobColl);
                jobDataList.add(indvColl);
                jobDataList.add(categorySelectionProfile);
                jobDataList.add(rmcPrflPageColl);
                jobDataList.add(driverStatus);
                pageCollection.put(AppConstants.INDV_COLL, indvColl);
                pageCollection.put("JOB_INCOME", jobColl);
                rmcJobIncomeSelectionListView.setDisplayData(jobDataList);
                pageCollection.put("INCOME_SELECTION_LISTVIEW",
                        rmcJobIncomeSelectionListView);

                final List inkindDataList = new ArrayList();
                inkindDataList.add(inKindColl);
                inkindDataList.add(indvColl);
                inkindDataList.add(categorySelectionProfile);
                inkindDataList.add(rmcPrflPageColl);
                inkindDataList.add(driverStatus);

                final List selfEmplDataList = new ArrayList();
                selfEmplDataList.add(selfColl);
                selfEmplDataList.add(indvColl);
                selfEmplDataList.add(categorySelectionProfile);
                selfEmplDataList.add(rmcPrflPageColl);
                selfEmplDataList.add(driverStatus);

                rmcJobIncomeSelectionListView.setDisplayData(jobDataList);
    rmcSelfEmplSelectionListView.setDisplayData(selfEmplDataList);
                pageCollection.put("INCOME_SELECTION_LISTVIEW",
                        rmcJobIncomeSelectionListView);

                pageCollection.put("SELF_EMPL_SELECTION_LISTVIEW",
                        rmcSelfEmplSelectionListView);
                pageCollection.put("INKIND_INCOME", inKindColl);
                pageCollection.put("SELF_EMPL", selfColl);

                return;
            }

            final int[] driverArray = (int[]) session
                    .get(FwConstants.RMC_DRIVER);
            final int driverStatus = driverManager.getAFBStatus(
                    FwConstants.RMC_DRIVER,
                    (String) request.get(FwConstants.CURRENT_PAGE_ID),
                    driverArray);
            boolean detailPageRequired = false;
            boolean selfEmplRequired = false;
            boolean inKindRequired = false;

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
                final int[] emplDetailDirtyIndicator = { IRMCResponseProfileManager.NOT_DIRTY };

                final int[] inKindDetailDirtyIndicator = { IRMCResponseProfileManager.NOT_DIRTY };

                final int[] selfEmplDetailDirtyIndicator = { IRMCResponseProfileManager.NOT_DIRTY };
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
                            // TEMP EDSP
                            if (rmcInPrflSessCargo.getEmpl_resp() == null) {
                                rmcInPrflSessCargo.setEmpl_resp(FwConstants.NO);
                            }

                            // Checking for any changes in the page since load
                            // For Current/Recent Job response
                            if (applicationManager.determineDirtyStatus(
                                    rmcInPrflPageCargo.getEmpl_resp(),
                                    rmcInPrflSessCargo.getEmpl_resp(),
                                    emplDetailDirtyIndicator, driverStatus)) {
                                if (!dirtyIndicatorArray[0]) {
                                    dirtyIndicatorArray[0] = true;
                                }
                                dirtyIndicatorArray[Integer
                                                    .parseInt(indivSeqNum)] = true;

                                rmcResponseProfileManager
                                .translateProfileResponses(
                                        rmcInPrflPageCargo
                                        .getEmpl_resp(),
                                        rmcInPrflSessCargo
                                        .getEmpl_resp(),
                                        driverStatus,
                                        IRMCResponseProfileManager.REGULAR_EMPL,
                                        rmcInPrflSessCargo);
                            }
                            translatedProfileArray[0] = rmcInPrflSessCargo
                                    .getEmpl_resp();
							status = (null != rmcInPrflSessCargo.getEmpl_resp()) ? (rmcInPrflSessCargo
									.getEmpl_resp().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
                            if (status == IRMCResponseProfileManager.STATUS_ADD_NEW
                                    || status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
                                    || status == IRMCResponseProfileManager.STATUS_REQUIRED) {
                                detailPageRequired = true;
                            }

                            if (applicationManager.determineDirtyStatus(
                                    rmcInPrflPageCargo.getJob_iknd_resp(),
                                    rmcInPrflSessCargo.getJob_iknd_resp(),
                                    inKindDetailDirtyIndicator, driverStatus)) {
                                if (!dirtyIndicatorArray[0]) {
                                    dirtyIndicatorArray[0] = true;
                                }
                                dirtyIndicatorArray[Integer
                                                    .parseInt(indivSeqNum)] = true;

                                rmcResponseProfileManager
                                .translateProfileResponses(
                                        rmcInPrflPageCargo
                                        .getJob_iknd_resp(),
                                        rmcInPrflSessCargo
                                        .getJob_iknd_resp(),
                                        driverStatus,
                                        IRMCResponseProfileManager.JOB_IN_KIND,
                                        rmcInPrflSessCargo);
                            }
                            translatedProfileArray[1] = rmcInPrflSessCargo
                                    .getJob_iknd_resp();
							status = (null != rmcInPrflSessCargo
									.getJob_iknd_resp()) ? (rmcInPrflSessCargo
									.getJob_iknd_resp().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
                            if (status == IRMCResponseProfileManager.STATUS_ADD_NEW
                                    || status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
                                    || status == IRMCResponseProfileManager.STATUS_REQUIRED) {
                                inKindRequired = true;
                            }

                            // Self-Employment response
                            if (applicationManager.determineDirtyStatus(
                                    rmcInPrflPageCargo.getSelf_empl_resp(),
                                    rmcInPrflSessCargo.getSelf_empl_resp(),
                                    selfEmplDetailDirtyIndicator, driverStatus)) {
                                if (!dirtyIndicatorArray[0]) {
                                    dirtyIndicatorArray[0] = true;
                                }
                                dirtyIndicatorArray[Integer
                                                    .parseInt(indivSeqNum)] = true;

                            }
                            rmcResponseProfileManager
                            .translateProfileResponses(
                                    rmcInPrflPageCargo
                                    .getSelf_empl_resp(),
                                    rmcInPrflSessCargo
                                    .getSelf_empl_resp(),
                                    driverStatus,
                                    IRMCResponseProfileManager.SELF_EMPLOYMENT,
                                    rmcInPrflSessCargo);
                            translatedProfileArray[2] = rmcInPrflSessCargo
                                    .getSelf_empl_resp();
							status = (null != rmcInPrflSessCargo
									.getSelf_empl_resp()) ? (rmcInPrflSessCargo
									.getSelf_empl_resp().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
                            if (status == IRMCResponseProfileManager.STATUS_ADD_NEW
                                    || status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
                                    || status == IRMCResponseProfileManager.STATUS_REQUIRED) {
                                selfEmplRequired = true;
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
                categorySelectionProfile = categorySelectionProfileManager
                        .buildSelectionProfile(respColl, appNum,
                                AppConstants.RMC_CAT_EMP_PRFL);
            } else {
                categorySelectionProfileManager.rebuildSelectionProfile(
                        categorySelectionProfile, respColl, appNum,
                        AppConstants.RMC_CAT_EMP_PRFL);
            }
            // Make category selection (ARCAT) page complete
            driverManager.makeComplete(FwConstants.RMC_DRIVER, currentPageID,
                    driverArray, appNum);
            driverManager.makeRequired(FwConstants.RMC_DRIVER,
                    AppConstants.ARJIS, driverArray, appNum);
            final Map catTypes = new HashMap();

            catTypes.put(AppConstants.EMPL_REGULAR, AppConstants.EMPL_REGULAR);
            String empDetailPageStat = null;
            if (detailPageRequired
                    || checkEmploymentPageRequired(categorySelectionProfile,
                            catTypes)) {
                if (detailPageRequired
                        || !categorySelectionProfileManager
                        .areAllSequencesComplete(
                                categorySelectionProfile, catTypes)) {
                    driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARJID",
                            driverArray, appNum);
                } else {
                    driverManager.makeComplete(FwConstants.RMC_DRIVER, "ARJID",
                            driverArray, appNum);
                }
            } else {

                // PCR 30729 - When the details page is complete it should not
                // be marked AbsoluteNotRequd.
                // Otherwise, after going back to summary from selection page,
                // BACK will display selection instead of details page.
                // PCR#31313 - before making makeNotRequired, check is there any
                // other type of job income
                empDetailPageStat = driverManager.getStatus(
                        FwConstants.RMC_DRIVER, "ARJID", driverArray);
                if (!IDriver.DRIVER_STATUS_COMPLETE.equals(empDetailPageStat)
                        && !jobIncomeBO.checkDataExistance(appNum)) {
                    // AbsoluteNotRequired will set the page status to 'Not
                    // required'. In such case if
                    // there were any employments that were edited or added
                    // (currently in complete status)
                    // cannot be revisited when clicking back.
                    // Use of NotRequired will mark a visitAgain to Complete,
                    // that way any edited or added will be displayed when Back
                    // is clicked.
                    driverManager.makeNotRequired(FwConstants.RMC_DRIVER,
                            "ARJID", driverArray, appNum);
                } else {
                    // if any other type of job income exists than make page as
                    // complete
                    driverManager.makeComplete(FwConstants.RMC_DRIVER, "ARJID",
                            driverArray, appNum);
                }
            }

            catTypes.clear();
            catTypes.put(AppConstants.EMPL_INKIND, AppConstants.EMPL_INKIND);
            if (inKindRequired
                    || checkEmploymentPageRequired(categorySelectionProfile,
                            catTypes)) {
                if (inKindRequired
                        || !categorySelectionProfileManager
                        .areAllSequencesComplete(
                                categorySelectionProfile, catTypes)) {
                    driverManager.makeRequired(FwConstants.RMC_DRIVER,
                            AppConstants.ARIKI, driverArray, appNum);
                } else {
                    driverManager.makeComplete(FwConstants.RMC_DRIVER,
                            AppConstants.ARIKI, driverArray, appNum);
                }

            } else {
                // PCR 30729 - When the details page is complete it should not
                // be marked AbsoluteNotRequd.
                // Otherwise, after going back to summary from selection page,
                // BACK will display selection instead of details page.
                empDetailPageStat = driverManager
                        .getStatus(FwConstants.RMC_DRIVER, AppConstants.ARIKI,
                                driverArray);
                if (!IDriver.DRIVER_STATUS_COMPLETE.equals(empDetailPageStat)) {
                    driverManager.makeNotRequired(FwConstants.RMC_DRIVER,
                            AppConstants.ARIKI, driverArray, appNum);
                }

            }

            catTypes.clear();
            catTypes.put(AppConstants.EMPL_SELF, AppConstants.EMPL_SELF);
            if (selfEmplRequired
                    || checkEmploymentPageRequired(categorySelectionProfile,
                            catTypes)) {
                if (selfEmplRequired
                        || !categorySelectionProfileManager
                        .areAllSequencesComplete(
                                categorySelectionProfile, catTypes)) {
                    driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARJSD",
                            driverArray, appNum);
                } else {
                    driverManager.makeComplete(FwConstants.RMC_DRIVER, "ARJSD",
                            driverArray, appNum);
                }

            } else {
                // PCR 30729 - When the details page is complete it should not
                // be marked AbsoluteNotRequd.
                // Otherwise, after going back to summary from selection page,
                // BACK will display selection instead of details page.
                empDetailPageStat = driverManager.getStatus(
                        FwConstants.RMC_DRIVER, "ARJSD", driverArray);
                if (!IDriver.DRIVER_STATUS_COMPLETE.equals(empDetailPageStat)) {
                    driverManager.makeNotRequired(FwConstants.RMC_DRIVER,
                            "ARJSD", driverArray, appNum);
                }

            }
            // Store values in session

            session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER,
                    categorySelectionProfile);
            session.put(FwConstants.BEFORE_COLLECTION,
                    txnBean.getPageCollection());
            session.put(FwConstants.RMC_DRIVER, driverArray);
            txnBean.setSession(session);

        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("storeJobIncomeSelection");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "storeJobIncomeSelection", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.storeJobIncomeSelection() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Comment here.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */
    public void loadEmploymentDetails(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.loadEmploymentDetails() - START");
        try {
            final Map session = txnBean.getSession();
            final Map request = txnBean.getRequest();
            final Map pageCollection = txnBean.getPageCollection();
            // you'll get the value for Seq
            APP_IN_EMPL_Collection appInEmplColl;
            APP_IN_EMPL_A_WAGE_Collection appInEmplAWageColl;
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

            RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
                    .get(AppConstants.RMC_IN_PRFL_MASTER);
            final String previousPageId = (String) request
                    .get(FwConstants.PREVIOUS_PAGE_ID);
            // EDSP RMB loading from database
            final Map incomeType = new HashMap<String, String>();
            incomeType.put("R", "R");
            incomeType.put("P", "P");

            if (pageStatus == FwConstants.DRIVER_REQUIRED
                    || pageStatus == FwConstants.DRIVER_VISIT_AGAIN
                    && categorySelectionProfileManager.isEmpty(
                            categorySelectionProfile, incomeType)) {
                categorySelectionProfile = categorySelectionProfileManager
                        .loadCategoryChangeSelectionProfile(appNumber,
                                AppConstants.RMC_CAT_EMP_PRFL);
            } else if (pageStatus == FwConstants.DRIVER_COMPLETE
                    && !pageId.equals(previousPageId)
                    && categorySelectionProfileManager.isEmpty(
                            categorySelectionProfile, incomeType)) {
                categorySelectionProfile = categorySelectionProfileManager
                        .loadCategoryChangeSelectionProfile(appNumber,
                                AppConstants.RMC_CAT_EMP_PRFL);
            }
            Map beforeColl = (Map) session.get(FwConstants.BEFORE_COLLECTION);
            // EDSP RMB loading from database ends
            final JobIncomeBO jobIncomeBO = new JobIncomeBO();
            final short[] responseType = new short[] { IRMCResponseProfileManager.REGULAR_EMPL };
            SortedSet jobIncomeProfile = null;
            if (!pageId.equals(previousPageId)) {
                jobIncomeProfile = createPageProfile(categorySelectionProfile,
                        rmcInPrflColl, responseType);
                if (pageStatus != FwConstants.DRIVER_REQUIRED) {
                    final APP_IN_EMPL_Collection newEmplColl = jobIncomeBO
                            .getNewEmploymentDetails(appNumber);
                    if (newEmplColl != null && !newEmplColl.isEmpty()) {
                        APP_IN_EMPL_Cargo appInEmplCargo = null;
                        final int newEmplCollSize = newEmplColl.size();
                        for (int i = 0; i < newEmplCollSize; i++) {
                            appInEmplCargo = newEmplColl.getCargo(i);
                            categorySelectionProfileManager
                            .insertExistingSequenceDetail(
                                    jobIncomeProfile, null, null,
                                    Short.parseShort(appInEmplCargo
                                            .getIndv_seq_num()),
                                            Long.parseLong(appInEmplCargo
                                                    .getEmpl_seq_num()),
                                                    appInEmplCargo.getEmpl_typ());
                        }
                    }
                }
                if (pageStatus == FwConstants.DRIVER_REQUIRED
                        || pageStatus == FwConstants.DRIVER_VISIT_AGAIN) {
                    // set the current record indicator to the first one
                    categorySelectionProfileManager
                    .setCurrentRecordIndToFirst(jobIncomeProfile);
                }
                if (pageStatus == FwConstants.DRIVER_COMPLETE) {
                    // set the current record indicator to the end of the detail
                    // bean
                    categorySelectionProfileManager
                    .setCurrentRecordIndToLast(jobIncomeProfile);
                }
                // create add new sorted set
                // we need to remove the vallues from the session
                session.remove(FwConstants.BEFORE_COLLECTION);
            } else {
                // catAddNewProfile get it from the before collection
                beforeColl = (Map) session.get(FwConstants.BEFORE_COLLECTION);
                jobIncomeProfile = (SortedSet) beforeColl
                        .get(AppConstants.RMC_CATEGORY_PAGE_PRFL);
            }
            final IndivTypeSeqBean indivSeqBean = (IndivTypeSeqBean) pageCollection
                    .get(FwConstants.DETAIL_KEY_BEAN);
            // if details key bean not null means this bean is comming from the
            // summary page
            if (indivSeqBean != null) {
                final CategorySequenceDetail categorySeqDetail1 = categorySelectionProfileManager
                        .getCategorySequenceDetail(
                                jobIncomeProfile,
                                Short.parseShort(indivSeqBean.getIndivSeqNum()),
                                Long.parseLong(indivSeqBean.getSeqNum()),
                                indivSeqBean.getType());
                if (categorySeqDetail1 != null) {

                    if (categorySeqDetail1.getUserEndSelectionInd() != Short
                            .parseShort(indivSeqBean.getUserEndInd())) {
                        categorySelectionProfileManager
                        .updateUserEndSelInd(
                                jobIncomeProfile,
                                appNumber,
                                Short.parseShort(indivSeqBean
                                        .getIndivSeqNum()),
                                        Long.parseLong(indivSeqBean.getSeqNum()),
                                        indivSeqBean.getType(), Short
                                        .parseShort(indivSeqBean
                                                .getUserEndInd()));
                    }
                    categorySelectionProfileManager.makeSequenceDetailRequired(
                            jobIncomeProfile, null,
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
                        // now we need to make required the employment
                        if (AppConstants.EMPL_REGULAR.equals(indivSeqBean
                                .getType())) {
                            rmcResponseProfileManager.makeAddNew(
                                    IRMCResponseProfileManager.REGULAR_EMPL,
                                    rmcInPrflCargo, true);
                        } else {
                            rmcResponseProfileManager.makeAddNew(
                                    IRMCResponseProfileManager.JOB_IN_KIND,
                                    rmcInPrflCargo, true);
                        }

                        categorySelectionProfileManager
                        .insertSequenceDetail(jobIncomeProfile, appNumber,
                        		 AppConstants.RMC_CAT_EMP_PRFL, Short.parseShort(indivSeqBean
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
                        .insertSequenceDetail(jobIncomeProfile, null,
                                AppConstants.RMC_CAT_EMP_PRFL, Short
                                .parseShort(indivSeqBean
                                        .getIndivSeqNum()),
                                        Short.parseShort(indivSeqBean
                                                .getSeqNum()), indivSeqBean
                                                .getType(), Short
                                                .parseShort(userEndInd));
                        categorySelectionProfileManager
                        .makeSequenceDetailRequired(jobIncomeProfile,
                                null, Short.parseShort(indivSeqBean
                                        .getIndivSeqNum()), Short
                                        .parseShort(indivSeqBean
                                                .getSeqNum()),
                                                indivSeqBean.getType());

                        categorySelectionProfileManager
                        .insertSequenceDetail(categorySelectionProfile,
                                appNumber,
                                AppConstants.RMC_CAT_EMP_PRFL, Short
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
                session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER,
						categorySelectionProfile);
            }
            pageCollection.put(AppConstants.RMC_CATEGORY_PAGE_PRFL,
                    jobIncomeProfile);

            CategorySequenceDetail categorySeqDetail = categorySelectionProfileManager
                    .getCurrentSequenceDetail(jobIncomeProfile);
            if (categorySeqDetail == null) {
                categorySeqDetail = categorySelectionProfileManager
                        .getNextSequenceDetail(jobIncomeProfile);
            }
            String categoryType =null;
            String categorySeqNum ="0";
            String indvSeqNum ="0"; 
            if(categorySeqDetail!=null) {
            categoryType = categorySeqDetail.getCategoryType();
            categorySeqNum = Long.toString(categorySeqDetail
                    .getCategorySequence());

            indvSeqNum = Short.toString(categorySeqDetail
                    .getIndividualSequence());

            pageCollection.put("END_PAGE_IND",
                    String.valueOf(categorySeqDetail.getUserEndSelectionInd()));
            }
            // Read from APPL_IN_EMPL AND APPL_IN_EMPL_A_WAGE ORDER BY Source
            // Indicator
            final WagesBO wagesBO = new WagesBO();
            appInEmplColl = jobIncomeBO.loadDetails(appNumber, indvSeqNum,
                    categorySeqNum);
            appInEmplAWageColl = wagesBO.loadDetails(appNumber, indvSeqNum,
                    categorySeqNum);
            pageCollection.put("APP_IN_EMPL_A_WAGE_Collection",
                    appInEmplAWageColl);

            // EDSP RMB adding pagemode
            APP_IN_EMPL_Cargo appInEmplCargo = null;
            String pageMode = null;

            if (appInEmplColl != null && !appInEmplColl.isEmpty()) {
                appInEmplCargo = appInEmplColl.getCargo(0);
            }

            APP_IN_EMPL_Cargo cwwEmplCargo = splitEmplColl(appInEmplColl,
                    AppConstants.CWW_RECORD_IND);
            if (cwwEmplCargo == null) {
                cwwEmplCargo = new APP_IN_EMPL_Cargo();
            }

            pageCollection.put("SEC_EMPL", settingDefaultValues(cwwEmplCargo));

            APP_IN_EMPL_Cargo rmcEmplCargo = splitEmplColl(appInEmplColl,
                    AppConstants.RMC_NEW_RECORD_IND);
            boolean employmentDetailsChanged = false;

            if (appInEmplCargo != null
                    && ("CW".equalsIgnoreCase(appInEmplCargo.getSrc_app_ind()) || "RM"
                            .equalsIgnoreCase(appInEmplCargo.getSrc_app_ind()))
                            && (categorySeqDetail!=null && categorySeqDetail.getUserEndSelectionInd() == 0)) {
                pageMode = "C";

            } else if (categorySeqDetail!=null && categorySeqDetail.getUserEndSelectionInd() == 1) {
                pageMode = "E";
            } else {
                pageMode = FwConstants.NO;

            }

            if (rmcEmplCargo != null) {

                pageCollection.put("FST_EMPL",
                        settingDefaultValues(rmcEmplCargo));
                employmentDetailsChanged = true;
            } else {
                rmcEmplCargo = splitEmplColl(appInEmplColl,
                        AppConstants.RMC_MODIFIED_RECORD_IND);
                if (rmcEmplCargo != null) {
                    pageCollection.put("FST_EMPL",
                            settingDefaultValues(rmcEmplCargo));
                    employmentDetailsChanged = true;
                } else {
                    rmcEmplCargo = splitEmplColl(appInEmplColl,
                            AppConstants.RMC_END_RECORD_IND);
                    if (rmcEmplCargo != null) {
                        pageCollection.put("FST_EMPL",
                                settingDefaultValues(rmcEmplCargo));
                        employmentDetailsChanged = true;
                    } else {
                        pageCollection.put("FST_EMPL",
                                settingDefaultValues(cwwEmplCargo));
                    }
                }
            }

            final Map cwwResultMap = splitWageColl(appInEmplAWageColl,
                    AppConstants.CWW_RECORD_IND);
            if (!cwwResultMap.isEmpty()) {
                pageCollection.put("SEC_WAGE", cwwResultMap);
            }

            Map rmcResultMap = splitWageColl(appInEmplAWageColl,
                    AppConstants.RMC_NEW_RECORD_IND);
            if (!rmcResultMap.isEmpty()) {
                pageCollection.put("FST_WAGE", rmcResultMap);
            } else {
                rmcResultMap = splitWageColl(appInEmplAWageColl,
                        AppConstants.RMC_MODIFIED_RECORD_IND);
                if (!rmcResultMap.isEmpty() || employmentDetailsChanged) {
                    pageCollection.put("FST_WAGE", rmcResultMap);
                } else if (!cwwResultMap.isEmpty()) {
                    pageCollection.put("FST_WAGE", cwwResultMap);
                }
            }
            // end page correction
            final Map rmeResultMap = splitWageColl(appInEmplAWageColl,
                    AppConstants.RMC_END_RECORD_IND);
            if (!rmeResultMap.isEmpty()) {
                pageCollection.put("FST_WAGE", rmeResultMap);
            }
            String srcAppInd = FwConstants.EMPTY_STRING;
            if (appInEmplColl != null && !appInEmplColl.isEmpty()) {
                final APP_IN_EMPL_Cargo rmcInSelfeCargo = appInEmplColl
                        .getCargo(0);
                srcAppInd = rmcInSelfeCargo.getSrc_app_ind();
            }
            if (("CW".equalsIgnoreCase(srcAppInd) || "RM"
                    .equalsIgnoreCase(srcAppInd))
                    && categorySeqDetail.getUserEndSelectionInd() == 0) {
                pageMode = "C";
            }

            if (categorySeqDetail!=null && categorySeqDetail.getUserEndSelectionInd() == 1) {
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

            } else if (!("C".equalsIgnoreCase(pageMode) || "E"
                    .equalsIgnoreCase(pageMode))) {
                pageMode = FwConstants.NO;
            }

            // EDSP RMB Adding for New
            pageCollection.put(APP_IN_EMPL_COLLECTION_KEY, appInEmplColl);
            rmcInPrflColl.size();
            char typeStatus = 'N';
            String showLoopingQuestionFlag = FwConstants.YES;
            if(categorySeqDetail!=null) {
            typeStatus = categorySeqDetail.getStatus();
            }
            if (typeStatus == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
                    || typeStatus == IRMCResponseProfileManager.STATUS_COMPLETE) {
                showLoopingQuestionFlag = FwConstants.NO;
            }
            // set the showLoopingQuestionFlag to PageCollection

            pageCollection.put(AppConstants.SHOW_LOOPING_QUESTION,
                    showLoopingQuestionFlag);

            // end of endpage correction
            pageCollection.put("PAGE_MODE", pageMode);
            pageCollection.put(AppConstants.CURRENT_EMPL_TYPE, categoryType);

            // set first name to page collection
            final PeopleHandler peopleHandler = (PeopleHandler) session
                    .get(AppConstants.INDIV_MASTER_HANDLER);
            pageCollection.put(AppConstants.FIRST_NAME,
                    peopleHandler.getFirstName(indvSeqNum));

            // run component manager
            componentManager.getComponents("ARJID", txnBean);
            request.remove(AppConstants.LOOPING_QUESTION);
            // Add the page collection to before collection
            session.put(FwConstants.BEFORE_COLLECTION, pageCollection);

        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("loadEmploymentDetails");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "loadEmploymentDetails", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.loadEmploymentDetails() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * storing employment and employment expenses.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */
    public void storeEmploymentDetails(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.storeEmploymentDetails() - START");
        try {
            final Map session = txnBean.getSession();
            final Map request = txnBean.getRequest();
            final Map pageCollection = txnBean.getPageCollection();
            final WagesBO wagesBO = new WagesBO();
            final String currentPageID = (String) request
                    .get(FwConstants.CURRENT_PAGE_ID);
            final String appNumber = (String) session
                    .get(AppConstants.APP_NUMBER);
            final List modifiedFields = (ArrayList) session
                    .get(AppConstants.MODIFIED_FIELDS);
            // build category selection profile
            final SortedSet categorySelectionProfile = (SortedSet) session
                    .get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
            // get the BeforeCollection
            Map beforeColl = (Map) session
                    .get(FwConstants.BEFORE_COLLECTION);
            boolean reqInd=false;
            if (null == beforeColl) {
            	beforeColl = pageCollection;
            	log(ILog.DEBUG, "RMCJobIncomeEJBBean.storeEmploymentDetails() - NULL beforeColl , assigning pageCollection Time Taken : " + (System.currentTimeMillis() - startTime) + AppConstants.SPACE + AppConstants.MILLISECONDS);
            }
            
            SortedSet jobIncomeProfile = (SortedSet) beforeColl
                    .get(AppConstants.RMC_CATEGORY_PAGE_PRFL);
            
            if (null == jobIncomeProfile) {
            	jobIncomeProfile = new TreeSet();
            	log(ILog.DEBUG, "RMCJobIncomeEJBBean.storeEmploymentDetails() - NULL jobIncomeProfile , assigning new TreeSet() Time Taken : " + (System.currentTimeMillis() - startTime) + AppConstants.SPACE + AppConstants.MILLISECONDS);
            }
            
            final PeopleHandler peopleHandler = (PeopleHandler) session
                    .get(AppConstants.INDIV_MASTER_HANDLER);
            final APP_IN_EMPL_Collection appInEmplCollection = (APP_IN_EMPL_Collection) pageCollection
                    .get(APP_IN_EMPL_COLLECTION_KEY);
            if (appInEmplCollection.size() > 1) {
                appInEmplCollection.remove(1);
            }
            APP_IN_EMPL_Cargo appInEmplCargo = appInEmplCollection.getCargo(0);
            // final String emplPageResponse = appInEmplCargo.getEr_provd_med_ins_ind();

            final APP_IN_EMPL_A_WAGE_Collection appInEmplAWageCollection = (APP_IN_EMPL_A_WAGE_Collection) pageCollection
                    .get("APP_IN_EMPL_A_WAGE_Collection");
            String pageMode = (String) beforeColl.get("PAGE_MODE");
            
            if (null == pageMode) {
            	pageMode = FwConstants.EMPTY_STRING;
            	log(ILog.DEBUG, "RMCJobIncomeEJBBean.storeEmploymentDetails() - NULL pageMode , assigning FwConstants.EMPTY_STRING Time Taken : " + (System.currentTimeMillis() - startTime) + AppConstants.SPACE + AppConstants.MILLISECONDS);
            }

            // assign cargos
            final APP_IN_EMPL_A_WAGE_Cargo inkindCargo = splitEmplWage(
                    appInEmplAWageCollection, FwConstants.ZERO);
            final APP_IN_EMPL_A_WAGE_Cargo hourlyCargo = splitEmplWage(
                    appInEmplAWageCollection, "1001");
            final APP_IN_EMPL_A_WAGE_Cargo salaryCargo = splitEmplWage(
                    appInEmplAWageCollection, "1002");
            final APP_IN_EMPL_A_WAGE_Cargo adtl1Cargo = splitEmplWage(
                    appInEmplAWageCollection, "1003");
            final APP_IN_EMPL_A_WAGE_Cargo adtl2Cargo = splitEmplWage(
                    appInEmplAWageCollection, "1004");
            final APP_IN_EMPL_A_WAGE_Cargo adtl3Cargo = splitEmplWage(
                    appInEmplAWageCollection, "1005");
            final APP_IN_EMPL_A_WAGE_Cargo adtl4Cargo = splitEmplWage(
                    appInEmplAWageCollection, "1006");
            final APP_IN_EMPL_A_WAGE_Cargo oth1Cargo = splitEmplWage(
                    appInEmplAWageCollection, "7");
            final APP_IN_EMPL_A_WAGE_Cargo oth2Cargo = splitEmplWage(
                    appInEmplAWageCollection, "8");
            final APP_IN_EMPL_A_WAGE_Cargo oth3Cargo = splitEmplWage(
                    appInEmplAWageCollection, "9");
            final APP_IN_EMPL_A_WAGE_Cargo jobCargo = splitEmplWage(
                    appInEmplAWageCollection, "10"); // 1010
            // bob
            APP_IN_EMPL_A_WAGE_Cargo addCargo = splitEmplWage(
                    appInEmplAWageCollection, "11"); // 1010
            // bob

            String firstName = (String) beforeColl
                    .get(AppConstants.FIRST_NAME);
            
            if (null == firstName) {
            	firstName = FwConstants.EMPTY_STRING;
            	log(ILog.DEBUG, "RMCJobIncomeEJBBean.storeEmploymentDetails() - NULL firstName , assigning FwConstants.EMPTY_STRING Time Taken : " + (System.currentTimeMillis() - startTime) + AppConstants.SPACE + AppConstants.MILLISECONDS);
            }
            
            final CategorySequenceDetail categorySeqDetailBean = categorySelectionProfileManager
                    .getCurrentSequenceDetail(jobIncomeProfile);
            
            short userEndInd	= Short.valueOf(FwConstants.ZERO);
            String catPage		= FwConstants.EMPTY_STRING;
            if (null != categorySeqDetailBean) {
	            userEndInd	= categorySeqDetailBean.getUserEndSelectionInd();
	            catPage		= categorySeqDetailBean.getCategoryType();
            }
            
            // Run Validations
            final JobIncomeBO jobIncomeBO = new JobIncomeBO();

            final APP_IN_EMPL_Collection beforeCollAppInEmplColl = (APP_IN_EMPL_Collection) beforeColl
                    .get(APP_IN_EMPL_COLLECTION_KEY);
            APP_IN_EMPL_Cargo beforeEmplCargo = null;

            // now we are setting the default values

            appInEmplCargo.setApp_num(appNumber);

            // EDSP RMB

            if (appInEmplCargo.getStrk_beg_dt() == null
                    || appInEmplCargo.getStrk_beg_dt().trim().length() == 0
                    || AppConstants.HIGH_TIMESTAMP
                    .equalsIgnoreCase(appInEmplCargo.getStrk_beg_dt())
                    || AppConstants.HIGH_TIMESTAMP1
                    .equalsIgnoreCase(appInEmplCargo.getStrk_beg_dt())) {
                appInEmplCargo.setStrk_beg_dt(AppConstants.HIGH_DATE);
            } else {
                String sDate = appInEmplCargo.getStrk_beg_dt();
                if (sDate.length() > 10) {
                    sDate = sDate.substring(0, 10);
                }

                appInEmplCargo.setStrk_beg_dt(sDate);
            }

            if (appInEmplCargo.getStrk_end_dt() == null
                    || appInEmplCargo.getStrk_end_dt().trim().length() == 0
                    || AppConstants.HIGH_TIMESTAMP
                    .equalsIgnoreCase(appInEmplCargo.getStrk_end_dt())
                    || AppConstants.HIGH_TIMESTAMP1
                    .equalsIgnoreCase(appInEmplCargo.getStrk_end_dt())) {
                appInEmplCargo.setStrk_end_dt(AppConstants.HIGH_DATE);
            } else {
                String sDate = appInEmplCargo.getStrk_end_dt();
                if (sDate.length() > 10) {
                    sDate = sDate.substring(0, 10);
                }

                appInEmplCargo.setStrk_end_dt(sDate);
            }
            if (appInEmplCargo.getChg_eff_dt() == null
                    || appInEmplCargo.getChg_eff_dt().trim().length() == 0
                    || AppConstants.HIGH_TIMESTAMP
                    .equalsIgnoreCase(appInEmplCargo.getChg_eff_dt())
                    || AppConstants.HIGH_TIMESTAMP1
                    .equalsIgnoreCase(appInEmplCargo.getChg_eff_dt())) {
                appInEmplCargo.setChg_eff_dt(AppConstants.HIGH_DATE);
            } else {
                String sDate = appInEmplCargo.getChg_eff_dt();
                if (sDate.length() > 10) {
                    sDate = sDate.substring(0, 10);
                }

                appInEmplCargo.setChg_eff_dt(sDate);
            }
            if (appInEmplCargo.getEmpl_beg_dt() != null
                    && appInEmplCargo.getEmpl_beg_dt().trim().length() != 0
                    && !AppConstants.HIGH_TIMESTAMP.equals(appInEmplCargo
                            .getEmpl_beg_dt())
                            && AppConstants.HIGH_TIMESTAMP1
                            .equalsIgnoreCase(appInEmplCargo.getEmpl_beg_dt())) {
                String sDate = appInEmplCargo.getEmpl_beg_dt();
                if (sDate.length() > 10) {
                    sDate = sDate.substring(0, 10);
                }

                appInEmplCargo.setEmpl_beg_dt(sDate);
            }
            if (appInEmplCargo.getEmpl_end_dt() == null
                    || appInEmplCargo.getEmpl_end_dt().trim().length() == 0
                    || AppConstants.HIGH_TIMESTAMP
                    .equalsIgnoreCase(appInEmplCargo.getEmpl_end_dt())
                    || AppConstants.HIGH_TIMESTAMP1
                    .equalsIgnoreCase(appInEmplCargo.getEmpl_end_dt())) {
            } else {
                String sDate = appInEmplCargo.getEmpl_end_dt();
                if (sDate.length() > 10) {
                    sDate = sDate.substring(0, 10);
                }

                appInEmplCargo.setEmpl_end_dt(sDate);
            }
            if (appInEmplCargo.getFst_payck_dt() == null
                    || appInEmplCargo.getFst_payck_dt().trim().length() == 0
                    || AppConstants.HIGH_TIMESTAMP
                    .equalsIgnoreCase(appInEmplCargo.getFst_payck_dt())
                    || AppConstants.HIGH_TIMESTAMP1
                    .equalsIgnoreCase(appInEmplCargo.getFst_payck_dt())) {
                appInEmplCargo.setFst_payck_dt(AppConstants.HIGH_DATE);
            } else {
                String sDate = appInEmplCargo.getFst_payck_dt();
                if (sDate.length() > 10) {
                    sDate = sDate.substring(0, 10);
                }

                appInEmplCargo.setFst_payck_dt(sDate);
            }
            if (appInEmplCargo.getLast_payck_dt() == null
                    || appInEmplCargo.getLast_payck_dt().trim().length() == 0
                    || AppConstants.HIGH_TIMESTAMP
                    .equalsIgnoreCase(appInEmplCargo.getLast_payck_dt())
                    || AppConstants.HIGH_TIMESTAMP1
                    .equalsIgnoreCase(appInEmplCargo.getLast_payck_dt())) {
            } else {
                final String sDate = appInEmplCargo.getLast_payck_dt();
                if (sDate.length() > 10) {

                }

                appInEmplCargo.setLast_payck_dt(sDate);
            }
            if (appInEmplCargo.getNext_paycheck_dt() == null
                    || appInEmplCargo.getNext_paycheck_dt().trim().length() == 0
                    || AppConstants.HIGH_TIMESTAMP
                    .equalsIgnoreCase(appInEmplCargo
                            .getNext_paycheck_dt())
                            || AppConstants.HIGH_TIMESTAMP1
                            .equalsIgnoreCase(appInEmplCargo
                                    .getNext_paycheck_dt())) {
                appInEmplCargo.setNext_paycheck_dt(AppConstants.HIGH_DATE);
            } else {
                String sDate = appInEmplCargo.getNext_paycheck_dt();
                if (sDate.length() > 10) {
                    sDate = sDate.substring(0, 10);
                }

                appInEmplCargo.setNext_paycheck_dt(sDate);
            }
            if (appInEmplCargo.getIk_job_start_date() == null
                    || appInEmplCargo.getIk_job_start_date().trim().length() == 0
                    || AppConstants.HIGH_TIMESTAMP
                    .equalsIgnoreCase(appInEmplCargo
                            .getIk_job_start_date())
                            || AppConstants.HIGH_TIMESTAMP1
                            .equalsIgnoreCase(appInEmplCargo
                                    .getIk_job_start_date())) {
                appInEmplCargo.setIk_job_start_date(AppConstants.HIGH_DATE);
            } else {
                String sDate = appInEmplCargo.getIk_job_start_date();
                if (sDate.length() > 10) {
                    sDate = sDate.substring(0, 10);
                }

                appInEmplCargo.setIk_job_start_date(sDate);
            }
            if (appInEmplCargo.getIk_job_end_date() == null
                    || appInEmplCargo.getIk_job_end_date().trim().length() == 0
                    || AppConstants.HIGH_TIMESTAMP
                    .equalsIgnoreCase(appInEmplCargo
                            .getIk_job_end_date())
                            || AppConstants.HIGH_TIMESTAMP1
                            .equalsIgnoreCase(appInEmplCargo
                                    .getIk_job_end_date())) {
                appInEmplCargo.setIk_job_end_date(AppConstants.HIGH_DATE);
            } else {
                String sDate = appInEmplCargo.getIk_job_end_date();
                if (sDate.length() > 10) {
                    sDate = sDate.substring(0, 10);
                }

                appInEmplCargo.setIk_job_end_date(sDate);
            }
            if (appInEmplCargo.getEr_nam() == null
                    || appInEmplCargo.getEr_nam().trim().length() == 0) {
                appInEmplCargo.setEr_nam(FwConstants.SPACE);
            }

            if (appInEmplCargo.getEr_st_adr() == null
                    || AppConstants.SELECT_DEFAULT_OPTION.equals(appInEmplCargo
                            .getEr_st_adr().trim())) {
                appInEmplCargo.setEr_st_adr(null);
            }

            String completedCheck = jobIncomeBO
                    .completenessCheck(appInEmplCargo);
            completedCheck = FwConstants.ONE;
            appInEmplCargo.setRec_cplt_ind(completedCheck);

            if (appInEmplCargo.getJob_termination_reason() == null
                    || AppConstants.SELECT_DEFAULT_OPTION.equals(appInEmplCargo
                            .getJob_termination_reason())) {
                appInEmplCargo.setJob_termination_reason(null);
            }

            if (appInEmplCargo.getPay_freq_cd() == null
                    || AppConstants.SELECT_DEFAULT_OPTION.equals(appInEmplCargo
                            .getPay_freq_cd().trim())) {
                appInEmplCargo.setPay_freq_cd(null);
            }
            // EDSP RMB
            if (appInEmplCargo.getPay_day_week_cd() == null
                    || AppConstants.SELECT_DEFAULT_OPTION.equals(appInEmplCargo
                            .getPay_day_week_cd().trim())) {
                appInEmplCargo.setPay_day_week_cd(null);
            }

            // /job type and job temp additions PCR#32274

            if (appInEmplCargo.getTemp_job_ind() == null) {
                appInEmplCargo.setTemp_job_ind(FwConstants.SPACE);
            }

            if (appInEmplCargo.getPosn_typ_ind() == null) {
                appInEmplCargo.setPosn_typ_ind(FwConstants.SPACE);
            }

            final String indvSeqNum = String.valueOf(categorySeqDetailBean
                    .getIndividualSequence());
            String sourceAppIndicator = null;
            String recordInd = null;
            String befEmplResponse = null;
            // now we are checking for the before collection
            long empSeqNum = 0;
            boolean empDetailsUpdate = false;
            if (beforeCollAppInEmplColl != null
                    && !beforeCollAppInEmplColl.isEmpty()) {
                final int size = beforeCollAppInEmplColl.size();
                empSeqNum = categorySeqDetailBean.getCategorySequence();
                
                if (size > 1) {
                    // if we have two records means cw and rm
                    // now we are getting RM record to compare
                    // now we need to update the data base if it dirty
                    sourceAppIndicator = AppConstants.RMC_MODIFIED_RECORD_IND;
                    recordInd = FwConstants.ROWACTION_UPDATE;
                    beforeEmplCargo = splitEmplColl(beforeCollAppInEmplColl,
                            sourceAppIndicator);
                    if (beforeEmplCargo == null) {
                        sourceAppIndicator = AppConstants.RMC_END_RECORD_IND;
                        recordInd = FwConstants.ROWACTION_UPDATE;
                        beforeEmplCargo = splitEmplColl(
                                beforeCollAppInEmplColl, sourceAppIndicator);
                    }
                    
                    //befEmplResponse = beforeEmplCargo.getEr_provd_med_ins_ind();

                } else {
                    // now we are checking this record is CW or RN
                    beforeEmplCargo = splitEmplColl(beforeCollAppInEmplColl,
                            AppConstants.CWW_RECORD_IND);
                    if (beforeEmplCargo != null) {
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
                        beforeEmplCargo = splitEmplColl(
                                beforeCollAppInEmplColl, sourceAppIndicator);
                    }
                    // befEmplResponse = beforeEmplCargo.getEr_provd_med_ins_ind();
                }
                if (AppConstants.EMPL_INKIND.equals(categorySeqDetailBean
                        .getCategoryType())) {
                    if (beforeEmplCargo.getFst_payck_dt() == null
                            || beforeEmplCargo.getFst_payck_dt().trim()
                            .length() == 0
                            || AppConstants.HIGH_TIMESTAMP
                            .equalsIgnoreCase(beforeEmplCargo
                                    .getFst_payck_dt())
                                    || AppConstants.HIGH_TIMESTAMP1
                                    .equalsIgnoreCase(beforeEmplCargo
                                            .getFst_payck_dt())) {
                        appInEmplCargo.setFst_payck_dt(AppConstants.HIGH_DATE);
                    } else {
                        String sDate = beforeEmplCargo.getFst_payck_dt();
                        if (sDate.length() > 10) {
                            sDate = sDate.substring(0, 10);
                        }

                        appInEmplCargo.setFst_payck_dt(sDate);
                    }
                    if (beforeEmplCargo.getLast_payck_dt() == null
                            || beforeEmplCargo.getLast_payck_dt().trim()
                            .length() == 0
                            || AppConstants.HIGH_TIMESTAMP
                            .equalsIgnoreCase(beforeEmplCargo
                                    .getLast_payck_dt())
                                    || AppConstants.HIGH_TIMESTAMP1
                                    .equalsIgnoreCase(beforeEmplCargo
                                            .getLast_payck_dt())) {
                    } else {
                        String sDate = beforeEmplCargo.getLast_payck_dt();
                        if (sDate.length() > 10) {
                            sDate = sDate.substring(0, 10);
                        }

                        appInEmplCargo.setLast_payck_dt(sDate);
                    }

                    if (beforeEmplCargo.getStrk_beg_dt() == null
                            || beforeEmplCargo.getStrk_beg_dt().trim().length() == 0
                            || AppConstants.HIGH_TIMESTAMP
                            .equalsIgnoreCase(beforeEmplCargo
                                    .getStrk_beg_dt())
                                    || AppConstants.HIGH_TIMESTAMP1
                                    .equalsIgnoreCase(beforeEmplCargo
                                            .getStrk_beg_dt())) {
                        appInEmplCargo.setStrk_beg_dt(AppConstants.HIGH_DATE);
                    } else {
                        String sDate = beforeEmplCargo.getStrk_beg_dt();
                        if (sDate.length() > 10) {
                            sDate = sDate.substring(0, 10);
                        }

                        appInEmplCargo.setStrk_beg_dt(sDate);
                    }
                    if (beforeEmplCargo.getStrk_end_dt() == null
                            || beforeEmplCargo.getStrk_end_dt().trim().length() == 0
                            || AppConstants.HIGH_TIMESTAMP
                            .equalsIgnoreCase(beforeEmplCargo
                                    .getStrk_end_dt())
                                    || AppConstants.HIGH_TIMESTAMP1
                                    .equalsIgnoreCase(beforeEmplCargo
                                            .getStrk_end_dt())) {
                        appInEmplCargo.setStrk_end_dt(AppConstants.HIGH_DATE);
                    } else {
                        String sDate = beforeEmplCargo.getStrk_end_dt();
                        if (sDate.length() > 10) {
                            sDate = sDate.substring(0, 10);
                        }

                        appInEmplCargo.setStrk_end_dt(sDate);
                    }
                }
                appInEmplCargo.setSrc_app_ind(beforeEmplCargo.getSrc_app_ind());
                appInEmplCargo.setIndv_seq_num(beforeEmplCargo
                        .getIndv_seq_num());
                appInEmplCargo.setEmpl_typ(beforeEmplCargo.getEmpl_typ());
                appInEmplCargo.setEmpl_seq_num(beforeEmplCargo
                        .getEmpl_seq_num());

                appInEmplCargo.setRec_cplt_ind(beforeEmplCargo
                        .getRec_cplt_ind());

                if (sourceAppIndicator == AppConstants.RMC_NEW_RECORD_IND) {
                    if (appInEmplCargo.getPast_job_ind() != null
                            && (FwConstants.YES.equalsIgnoreCase(appInEmplCargo
                                    .getPast_job_ind()) || "Yes"
                                    .equalsIgnoreCase(appInEmplCargo
                                            .getPast_job_ind()))) {
                        appInEmplCargo
                        .setEmpl_typ(AppConstants.EMPLOYMENT_PAST);
                        appInEmplCargo.setEr_Typ(beforeEmplCargo.getEr_Typ());

                    }
                    appInEmplCargo.setEcp_id(beforeEmplCargo.getEcp_id());
                } else if (appInEmplCargo.getPast_job_ind() != null
                        && FwConstants.NO.equals(appInEmplCargo
                                .getPast_job_ind())) {
                    appInEmplCargo.setEmpl_typ(AppConstants.EMPLOYMENT_REGULAR);
                }

                // PCR 30727 - In Edit mode, end date is not populated from the
                // screen. Hence populating it from beforeCargo.
                if (sourceAppIndicator == AppConstants.RMC_MODIFIED_RECORD_IND) {
                    appInEmplCargo.setEcp_id(beforeEmplCargo.getEcp_id());
                }

                if (AppConstants.RMC_END_RECORD_IND.equals(sourceAppIndicator)
                        || AppConstants.EMPL_BOTH_REG_INKD
                        .equals(appInEmplCargo.getEmpl_typ())
                        && AppConstants.EMPL_INKIND
                        .equals(categorySeqDetailBean.getCategoryType())) {
                    if (AppConstants.RMC_END_RECORD_IND
                            .equals(sourceAppIndicator)
                            && AppConstants.EMPL_BOTH_REG_INKD
                            .equals(appInEmplCargo.getEmpl_typ())
                            && AppConstants.EMPL_INKIND
                            .equals(categorySeqDetailBean
                                    .getCategoryType())) {
                        // // Populating the end month
                        if (beforeEmplCargo.getEmpl_end_dt() == null
                                || beforeEmplCargo.getEmpl_end_dt().trim()
                                .length() == 0
                                || AppConstants.HIGH_TIMESTAMP
                                .equalsIgnoreCase(beforeEmplCargo
                                        .getEmpl_end_dt())
                                        || AppConstants.HIGH_TIMESTAMP1
                                        .equalsIgnoreCase(beforeEmplCargo
                                                .getEmpl_end_dt())) {
                        } else {
                            String sDate = beforeEmplCargo.getEmpl_end_dt();
                            if (sDate.length() > 10) {
                                sDate = sDate.substring(0, 10);
                            }
                            appInEmplCargo.setEmpl_end_dt(sDate);
                        }
                    }
                    appInEmplCargo.setEr_city_adr(beforeEmplCargo
                            .getEr_city_adr());
                    appInEmplCargo.setEr_l1_adr(beforeEmplCargo.getEr_l1_adr());
                    appInEmplCargo.setEr_nam(beforeEmplCargo.getEr_nam());
                    appInEmplCargo.setEr_phn_num(beforeEmplCargo
                            .getEr_phn_num());
                    appInEmplCargo.setEr_st_adr(beforeEmplCargo.getEr_st_adr());
                    appInEmplCargo.setEr_zip_adr(beforeEmplCargo
                            .getEr_zip_adr());
                    appInEmplCargo.setEr_Typ(beforeEmplCargo.getEr_Typ());
                    appInEmplCargo.setEcp_id(beforeEmplCargo.getEcp_id());
                    if (beforeEmplCargo.getEmpl_beg_dt() != null
                            && beforeEmplCargo.getEmpl_beg_dt().trim().length() != 0
                            && !AppConstants.HIGH_TIMESTAMP
                            .equalsIgnoreCase(beforeEmplCargo
                                    .getEmpl_beg_dt())
                                    && !AppConstants.HIGH_TIMESTAMP1
                                    .equals(beforeEmplCargo.getEmpl_beg_dt())) {
                        String sDate = beforeEmplCargo.getEmpl_beg_dt();
                        if (sDate.length() > 10) {
                            sDate = sDate.substring(0, 10);
                        }

                        appInEmplCargo.setEmpl_beg_dt(sDate);
                    }
                    if (beforeEmplCargo.getFst_payck_dt() == null
                            || beforeEmplCargo.getFst_payck_dt().trim()
                            .length() == 0
                            || AppConstants.HIGH_TIMESTAMP
                            .equalsIgnoreCase(beforeEmplCargo
                                    .getFst_payck_dt())
                                    || AppConstants.HIGH_TIMESTAMP1
                                    .equalsIgnoreCase(beforeEmplCargo
                                            .getFst_payck_dt())) {
                        appInEmplCargo.setFst_payck_dt(AppConstants.HIGH_DATE);
                    } else {
                        String sDate = beforeEmplCargo.getFst_payck_dt();
                        if (sDate.length() > 10) {
                            sDate = sDate.substring(0, 10);
                        }

                        appInEmplCargo.setFst_payck_dt(sDate);
                    }

                    if (beforeEmplCargo.getStrk_beg_dt() == null
                            || beforeEmplCargo.getStrk_beg_dt().trim().length() == 0
                            || AppConstants.HIGH_TIMESTAMP
                            .equalsIgnoreCase(beforeEmplCargo
                                    .getStrk_beg_dt())
                                    || AppConstants.HIGH_TIMESTAMP1
                                    .equalsIgnoreCase(beforeEmplCargo
                                            .getStrk_beg_dt())) {
                        appInEmplCargo.setStrk_beg_dt(AppConstants.HIGH_DATE);
                    } else {
                        String sDate = beforeEmplCargo.getStrk_beg_dt();
                        if (sDate.length() > 10) {
                            sDate = sDate.substring(0, 10);
                        }

                        appInEmplCargo.setStrk_beg_dt(sDate);
                    }
                    if (beforeEmplCargo.getStrk_end_dt() == null
                            || beforeEmplCargo.getStrk_end_dt().trim().length() == 0
                            || AppConstants.HIGH_TIMESTAMP
                            .equalsIgnoreCase(beforeEmplCargo
                                    .getStrk_end_dt())
                                    || AppConstants.HIGH_TIMESTAMP1
                                    .equalsIgnoreCase(beforeEmplCargo
                                            .getStrk_end_dt())) {
                        appInEmplCargo.setStrk_end_dt(AppConstants.HIGH_DATE);
                    } else {
                        String sDate = beforeEmplCargo.getStrk_end_dt();
                        if (sDate.length() > 10) {
                            sDate = sDate.substring(0, 10);
                        }

                        appInEmplCargo.setStrk_end_dt(sDate);
                    }
                    // /new addition PCR#32247
                    appInEmplCargo.setTemp_job_ind(beforeEmplCargo
                            .getTemp_job_ind());
                    appInEmplCargo.setPosn_typ_ind(beforeEmplCargo
                            .getPosn_typ_ind());

                    appInEmplCargo.setOn_strike_sw(beforeEmplCargo
                            .getOn_strike_sw());
                    appInEmplCargo.setExpected_to_cont_resp(beforeEmplCargo
                            .getExpected_to_cont_resp());
                }

                final String changeEffDate = appInEmplCargo.getChg_eff_dt();
                if (appInEmplCargo.getGross_pay_amt() != null
                        && AppConstants.ON_FILE.equalsIgnoreCase(appInEmplCargo
                                .getGross_pay_amt()))

                {
                    appInEmplCargo.setGross_pay_amt(beforeEmplCargo
                            .getGross_pay_amt());
                    if (modifiedFields.contains(appInEmplCargo
                            .getIndv_seq_num()
                            + "_"
                            + appInEmplCargo.getSeq_num()
                            + "_"
                            + "gross_pay_amt")) {
                        modifiedFields.remove(appInEmplCargo.getIndv_seq_num()
                                + "_" + appInEmplCargo.getSeq_num() + "_"
                                + "gross_pay_amt");
                    }

                }
                if (appInEmplCargo.getHourly_pay_amt() != null
                        && AppConstants.ON_FILE.equalsIgnoreCase(appInEmplCargo
                                .getHourly_pay_amt()))

                {
                    appInEmplCargo.setHourly_pay_amt(beforeEmplCargo
                            .getHourly_pay_amt());
                    if (modifiedFields.contains(appInEmplCargo
                            .getIndv_seq_num()
                            + "_"
                            + appInEmplCargo.getSeq_num()
                            + "_"
                            + "hourly_pay_amt")) {
                        modifiedFields.remove(appInEmplCargo.getIndv_seq_num()
                                + "_" + appInEmplCargo.getSeq_num() + "_"
                                + "hourly_pay_amt");
                    }

                }
                // check dirty
                appInEmplCargo = (APP_IN_EMPL_Cargo) isChanged(beforeEmplCargo,
                        appInEmplCargo);
                appInEmplCargo.setChg_eff_dt(changeEffDate);
                String completed1Check = jobIncomeBO
                        .completenessCheck(appInEmplCargo);
                completed1Check = FwConstants.ONE;
                appInEmplCargo.setRec_cplt_ind(completed1Check);
                appInEmplCargo.setSrc_app_ind(sourceAppIndicator);
                appInEmplCargo.setRowAction(recordInd);
                if (appInEmplCargo.isDirty()) {
                    empDetailsUpdate = true;
                }
            } else {
                // if there is no before collection means this is new record
                sourceAppIndicator = AppConstants.RMC_NEW_RECORD_IND;
                appInEmplCargo
                .setIndv_seq_num(String.valueOf(categorySeqDetailBean
                        .getIndividualSequence()));
                // get the MAX seq number from data base
                empSeqNum = jobIncomeBO.getMaxEmplSeqNumber(appNumber,
                        indvSeqNum);
                empSeqNum = empSeqNum + 1;
                appInEmplCargo.setEmpl_seq_num(String.valueOf(empSeqNum));
                if (appInEmplCargo.getPast_job_ind() != null
                        && (FwConstants.YES.equalsIgnoreCase(appInEmplCargo
                                .getPast_job_ind()) || "Yes"
                                .equalsIgnoreCase(appInEmplCargo
                                        .getPast_job_ind()))) {
                    appInEmplCargo.setEmpl_typ(AppConstants.EMPLOYMENT_PAST);

                } else {
                    appInEmplCargo.setEmpl_typ(categorySeqDetailBean
                            .getCategoryType());
                }

                appInEmplCargo.setSrc_app_ind(sourceAppIndicator);
                recordInd = FwConstants.ROWACTION_INSERT;
                appInEmplCargo.setRowAction(recordInd);
                empDetailsUpdate = true;
                // insert into RMC_SELECTION_PROFILE using Common Mehod()
                categorySelectionProfileManager.updateSequence(
                        jobIncomeProfile, null,
                        categorySeqDetailBean.getIndividualSequence(),
                        empSeqNum, categorySeqDetailBean.getCategoryType());
                categorySelectionProfileManager.updateSequence(categorySelectionProfile, null, categorySeqDetailBean.getIndividualSequence(), empSeqNum, categorySeqDetailBean.getCategoryType());
                if(null!=categorySeqDetailBean.getChangeSelectionCategoryCd())
            	{
            	categorySelectionProfileManager.persistSequence(appNumber, categorySeqDetailBean.getChangeSelectionCategoryCd(), String.valueOf(categorySeqDetailBean.getIndividualSequence()), String.valueOf(empSeqNum), categorySeqDetailBean.getCategoryType(), "0");
            	}
            }
            final List deletedList = (ArrayList) beforeColl
                    .get("DELETED_WAGES");
            Map fstWageMap = (HashMap) beforeColl.get("FST_WAGE");
            Map secWageMap = (HashMap) beforeColl.get("SEC_WAGE");
            
            
            if (null == fstWageMap) {
            	fstWageMap = new HashMap();
            	log(ILog.DEBUG, "RMCJobIncomeEJBBean.storeEmploymentDetails() - NULL fstWageMap , assigning new HashMap() Time Taken : " + (System.currentTimeMillis() - startTime) + AppConstants.SPACE + AppConstants.MILLISECONDS);
            }
            
            if (null == secWageMap) {
            	secWageMap = new HashMap();
            	log(ILog.DEBUG, "RMCJobIncomeEJBBean.storeEmploymentDetails() - NULL secWageMap , assigning new HashMap() Time Taken : " + (System.currentTimeMillis() - startTime) + AppConstants.SPACE + AppConstants.MILLISECONDS);
            }

            final boolean[] wageDetailsUpdate = new boolean[1];
            wageDetailsUpdate[0] = false;
            // set wage cargo values
            if (empDetailsUpdate) {
                wageDetailsUpdate[0] = true;
            }
            final APP_IN_EMPL_A_WAGE_Collection updatedWageColl = new APP_IN_EMPL_A_WAGE_Collection();

            if (deletedList != null
                    && FwConstants.ROWACTION_UPDATE.equals(recordInd)) {
                final int deletedListSize = deletedList.size();
                APP_IN_EMPL_A_WAGE_Cargo beforeCargo = null;
                for (int i = 0; i < deletedListSize; i++) {
                    beforeCargo = assignCargoBySeqNum(fstWageMap,
                            (String) deletedList.get(i));
                    if (beforeCargo != null) {
                        beforeCargo.setRowAction(FwConstants.ROWACTION_DELETE);
                        updatedWageColl.addCargo(beforeCargo);
                        wageDetailsUpdate[0] = true;
                    }
                }
            }

            if ("C".equalsIgnoreCase(pageMode)) {
                assignCargoBySeqNum(secWageMap, "7");
                final APP_IN_EMPL_A_WAGE_Cargo cwOth2Cargo = assignCargoBySeqNum(
                        secWageMap, "8");
                final APP_IN_EMPL_A_WAGE_Cargo cwOth3Cargo = assignCargoBySeqNum(
                        secWageMap, "9");

                if (cwOth2Cargo != null
                        && oth2Cargo.getAdtl_pay_amt() != null
                        && AppConstants.ON_FILE.equals(oth2Cargo
                                .getAdtl_pay_amt())) {
                    oth2Cargo.setAdtl_pay_amt(cwOth2Cargo.getAdtl_pay_amt());
                    if (modifiedFields.contains(appInEmplCargo
                            .getIndv_seq_num()
                            + "_"
                            + appInEmplCargo.getSeq_num()
                            + "_"
                            + cwOth2Cargo.getAdtl_pay_seq_num()
                            + "_"
                            + "adtl_pay_amt")) {
                        modifiedFields.remove(appInEmplCargo.getIndv_seq_num()
                                + "_" + appInEmplCargo.getSeq_num() + "_"
                                + cwOth2Cargo.getAdtl_pay_seq_num() + "_"
                                + "adtl_pay_amt");
                    }

                } else if (cwOth2Cargo != null) {
                    if (!modifiedFields.contains(appInEmplCargo
                            .getIndv_seq_num()
                            + "_"
                            + appInEmplCargo.getSeq_num()
                            + "_"
                            + cwOth2Cargo.getAdtl_pay_seq_num()
                            + "_"
                            + "adtl_pay_amt")) {
                        modifiedFields.add(appInEmplCargo.getIndv_seq_num()
                                + "_" + appInEmplCargo.getSeq_num() + "_"
                                + cwOth2Cargo.getAdtl_pay_seq_num() + "_"
                                + "adtl_pay_amt");
                    }

                }
                if (cwOth3Cargo != null
                        && oth3Cargo.getAdtl_pay_amt() != null
                        && AppConstants.ON_FILE.equals(oth3Cargo
                                .getAdtl_pay_amt())) {
                    oth3Cargo.setAdtl_pay_amt(cwOth3Cargo.getAdtl_pay_amt());
                    if (modifiedFields.contains(appInEmplCargo
                            .getIndv_seq_num()
                            + "_"
                            + appInEmplCargo.getSeq_num()
                            + "_"
                            + cwOth3Cargo.getAdtl_pay_seq_num()
                            + "_"
                            + "adtl_pay_amt")) {
                        modifiedFields.remove(appInEmplCargo.getIndv_seq_num()
                                + "_" + appInEmplCargo.getSeq_num() + "_"
                                + cwOth3Cargo.getAdtl_pay_seq_num() + "_"
                                + "adtl_pay_amt");
                    }

                } else if (cwOth3Cargo != null) {
                    if (!modifiedFields.contains(appInEmplCargo
                            .getIndv_seq_num()
                            + "_"
                            + appInEmplCargo.getSeq_num()
                            + "_"
                            + cwOth3Cargo.getAdtl_pay_seq_num()
                            + "_"
                            + "adtl_pay_amt")) {
                        modifiedFields.add(appInEmplCargo.getIndv_seq_num()
                                + "_" + appInEmplCargo.getSeq_num() + "_"
                                + cwOth3Cargo.getAdtl_pay_seq_num() + "_"
                                + "adtl_pay_amt");
                    }

                }
            }
            final int[] maxWageSeqNum = new int[1];

            maxWageSeqNum[0] = wagesBO.getMaxWageSeqNum(appNumber, indvSeqNum,
                    String.valueOf(empSeqNum));
            APP_IN_EMPL_A_WAGE_Cargo resultCargo = null;

            resultCargo = compareCargos(inkindCargo, fstWageMap,
                    FwConstants.ZERO, empSeqNum, indvSeqNum, appNumber,
                    recordInd, sourceAppIndicator, maxWageSeqNum, deletedList,
                    wageDetailsUpdate, pageMode);
            if (resultCargo != null) {
                if (resultCargo.isDirty()) {
                    wageDetailsUpdate[0] = true;
                }
                if (!"RE".equalsIgnoreCase(resultCargo.getSrc_app_ind())) {
                    updatedWageColl.addCargo(resultCargo);
                }

            }
            resultCargo = compareCargos(hourlyCargo, fstWageMap, "1001",
                    empSeqNum, indvSeqNum, appNumber, recordInd,
                    sourceAppIndicator, maxWageSeqNum, deletedList,
                    wageDetailsUpdate, pageMode);
            if (resultCargo != null) {
                if (resultCargo.isDirty()) {
                    wageDetailsUpdate[0] = true;
                }
                if (!"RE".equalsIgnoreCase(resultCargo.getSrc_app_ind())) {
                    updatedWageColl.addCargo(resultCargo);

                }
            }
            resultCargo = compareCargos(salaryCargo, fstWageMap, "1002",
                    empSeqNum, indvSeqNum, appNumber, recordInd,
                    sourceAppIndicator, maxWageSeqNum, deletedList,
                    wageDetailsUpdate, pageMode);
            if (resultCargo != null) {
                if (resultCargo.isDirty()) {
                    wageDetailsUpdate[0] = true;
                }
                if (!"RE".equalsIgnoreCase(resultCargo.getSrc_app_ind())) {
                    updatedWageColl.addCargo(resultCargo);
                }

            }
            resultCargo = compareCargos(adtl1Cargo, fstWageMap, "1003",
                    empSeqNum, indvSeqNum, appNumber, recordInd,
                    sourceAppIndicator, maxWageSeqNum, deletedList,
                    wageDetailsUpdate, pageMode);
            if (resultCargo != null) {
                if (resultCargo.isDirty()) {
                    wageDetailsUpdate[0] = true;
                }
                if (!"RE".equalsIgnoreCase(resultCargo.getSrc_app_ind())) {
                    updatedWageColl.addCargo(resultCargo);
                }

            }
            resultCargo = compareCargos(adtl2Cargo, fstWageMap, "1004",
                    empSeqNum, indvSeqNum, appNumber, recordInd,
                    sourceAppIndicator, maxWageSeqNum, deletedList,
                    wageDetailsUpdate, pageMode);
            if (resultCargo != null) {
                if (resultCargo.isDirty()) {
                    wageDetailsUpdate[0] = true;
                }
                if (!"RE".equalsIgnoreCase(resultCargo.getSrc_app_ind())) {
                    updatedWageColl.addCargo(resultCargo);
                }

            }
            resultCargo = compareCargos(adtl3Cargo, fstWageMap, "1005",
                    empSeqNum, indvSeqNum, appNumber, recordInd,
                    sourceAppIndicator, maxWageSeqNum, deletedList,
                    wageDetailsUpdate, pageMode);
            if (resultCargo != null) {
                if (resultCargo.isDirty()) {
                    wageDetailsUpdate[0] = true;
                }
                if (!"RE".equalsIgnoreCase(resultCargo.getSrc_app_ind())) {
                    updatedWageColl.addCargo(resultCargo);
                }

            }
            resultCargo = compareCargos(adtl4Cargo, fstWageMap, "1006",
                    empSeqNum, indvSeqNum, appNumber, recordInd,
                    sourceAppIndicator, maxWageSeqNum, deletedList,
                    wageDetailsUpdate, pageMode);
            if (resultCargo != null) {
                if (resultCargo.isDirty()) {
                    wageDetailsUpdate[0] = true;
                }
                if (!"RE".equalsIgnoreCase(resultCargo.getSrc_app_ind())) {
                    updatedWageColl.addCargo(resultCargo);
                }

            }
            resultCargo = compareCargos(oth1Cargo, fstWageMap, "7", empSeqNum,
                    indvSeqNum, appNumber, recordInd, sourceAppIndicator,
                    maxWageSeqNum, deletedList, wageDetailsUpdate, pageMode);
            if (resultCargo != null) {
                if (resultCargo.isDirty()) {
                    wageDetailsUpdate[0] = true;
                }
                if (!"RE".equalsIgnoreCase(resultCargo.getSrc_app_ind())) {
                    updatedWageColl.addCargo(resultCargo);
                }

            }
            resultCargo = compareCargos(oth2Cargo, fstWageMap, "8", empSeqNum,
                    indvSeqNum, appNumber, recordInd, sourceAppIndicator,
                    maxWageSeqNum, deletedList, wageDetailsUpdate, pageMode);
            if (resultCargo != null) {
                if (resultCargo.isDirty()) {
                    wageDetailsUpdate[0] = true;
                }
                if (!"RE".equalsIgnoreCase(resultCargo.getSrc_app_ind())) {
                    updatedWageColl.addCargo(resultCargo);
                }

            }
            resultCargo = compareCargos(oth3Cargo, fstWageMap, "9", empSeqNum,
                    indvSeqNum, appNumber, recordInd, sourceAppIndicator,
                    maxWageSeqNum, deletedList, wageDetailsUpdate, pageMode);
            if (resultCargo != null) {
                if (resultCargo.isDirty()) {
                    wageDetailsUpdate[0] = true;
                }
                if (!"RE".equalsIgnoreCase(resultCargo.getSrc_app_ind())) {
                    updatedWageColl.addCargo(resultCargo);
                }

            }
            // Boris WR # BRGUS00201071
            // - correction - cannot be null, should always present even if 0.0
            // End of WR # BRGUS00201071
            resultCargo = compareCargos(jobCargo,
                    fstWageMap,
                    "10", // 1010 bob
                    empSeqNum, indvSeqNum, appNumber, recordInd,
                    sourceAppIndicator, maxWageSeqNum, deletedList,
                    wageDetailsUpdate, pageMode);
            if (resultCargo != null) {
                resultCargo.setSrc_app_ind(appInEmplCargo.getSrc_app_ind()); // bob
                if (resultCargo.isDirty()) {
                    wageDetailsUpdate[0] = true;
                }
                // RE only for this
                updatedWageColl.addCargo(resultCargo);
            }
            // new1
            if (addCargo != null
                    && (addCargo.getAdtl_pay_amt() == null || FwConstants.EMPTY_STRING
                    .equals(addCargo.getAdtl_pay_amt().trim()))) {
                addCargo = null; // bob
            }
            resultCargo = compareCargos(addCargo, fstWageMap, "11", empSeqNum,
                    indvSeqNum, appNumber, recordInd, sourceAppIndicator,
                    maxWageSeqNum, deletedList, wageDetailsUpdate, pageMode);
            if (resultCargo != null) {
                resultCargo.setSrc_app_ind(appInEmplCargo.getSrc_app_ind()); // bob
                if (resultCargo.isDirty()) {
                    wageDetailsUpdate[0] = true;
                }
                if (!"RE".equalsIgnoreCase(resultCargo.getSrc_app_ind())) {
                    updatedWageColl.addCargo(resultCargo);
                }

            }

            final String backToMyAccess = (String) request
                    .get(AppConstants.BACK_TO_MY_ACCESS_BUTTON);

            if (backToMyAccess == null) {

                final String loopingQuestionResponse = (String) request
                        .get(AppConstants.LOOPING_QUESTION);
                String loopingQuestionShown = (String) beforeColl
                        .get(AppConstants.SHOW_LOOPING_QUESTION);
                
                if (null == loopingQuestionShown) {
                	loopingQuestionShown = FwConstants.EMPTY_STRING;
                	log(ILog.DEBUG, "RMCJobIncomeEJBBean.storeEmploymentDetails() - NULL loopingQuestionShown , assigning FwConstants.EMPTY_STRING Time Taken : " + (System.currentTimeMillis() - startTime) + AppConstants.SPACE + AppConstants.MILLISECONDS);
                }
                boolean isLoopingAnswered = false;
                if (loopingQuestionResponse != null) {
                    if (AppConstants.YES.equals(loopingQuestionResponse)
                            || AppConstants.NO.equals(loopingQuestionResponse)) {
                        isLoopingAnswered = true;
                    }
                }

                jobIncomeBO.validateRMCPageContents(appInEmplCargo,
                        inkindCargo, hourlyCargo, salaryCargo, adtl1Cargo,
                        adtl2Cargo, adtl3Cargo, adtl4Cargo, oth1Cargo,
                        oth2Cargo, oth3Cargo, firstName, userEndInd, catPage,
                        peopleHandler, pageMode, isLoopingAnswered,
                        loopingQuestionShown);
            }
            if (checkBackToMyAccessSelected(request)
                    || jobIncomeBO.hasMessages()) {
            	String reqWarningMsgs="";
            	if(null!=request.get(FwConstants.WARNING_MSG_DETAILS) && !request.get(FwConstants.WARNING_MSG_DETAILS).toString().isEmpty()){
            		if(request.get(FwConstants.WARNING_MSG_DETAILS) instanceof String)
    				{
            			reqWarningMsgs = (String) request
                        .get(FwConstants.WARNING_MSG_DETAILS);
    				}else{
    					String[] strArr = (String[]) request.get(FwConstants.WARNING_MSG_DETAILS);
    					logger.log(RMCJobIncomeEJBBean.class,ILog.FATAL,"DeepLog::CP_DEBUG_LOGS::1:: methodName::storeEmploymentDetails");
    					logger.log(RMCJobIncomeEJBBean.class,ILog.FATAL,"DeepLog::CP_DEBUG_LOGS::1:: WARNING_MSG_DETAILS is not a String but Array and the value is " + Arrays.toString(strArr));
    				}
            	}else{
    				logger.log(RMCJobIncomeEJBBean.class,ILog.FATAL,"DeepLog::CP_DEBUG_LOGS::2:: methodName::storeEmploymentDetails");
    				logger.log(RMCJobIncomeEJBBean.class,ILog.FATAL,"DeepLog::CP_DEBUG_LOGS::2:: null value found for WARNING_MSG_DETAILS");
    			}
                if (!checkForWarningMesgs(reqWarningMsgs,
                        jobIncomeBO.getMessageList())) {
                    if (backToMyAccess == null) {
                        request.put(FwConstants.MESSAGE_LIST,
                                jobIncomeBO.getMessageList());
                    }

                    if (appInEmplCargo.getPast_job_ind() != null
                            && FwConstants.YES.equals(appInEmplCargo
                                    .getPast_job_ind())) {
                        appInEmplCargo
                        .setEmpl_typ(AppConstants.EMPLOYMENT_PAST);
                    } else if (appInEmplCargo.getPast_job_ind() != null
                            && FwConstants.NO.equals(appInEmplCargo
                                    .getPast_job_ind())) {
                        appInEmplCargo
                        .setEmpl_typ(AppConstants.EMPLOYMENT_REGULAR);
                    }
                    pageCollection.put(AppConstants.CURRENT_EMPL_TYPE,
                            beforeColl.get(AppConstants.CURRENT_EMPL_TYPE));
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
                    fstWageMap = new HashMap();
                    fstWageMap.put("APP_IN_EMPL_A_WAGE_INKIND_Cargo",
                            inkindCargo);
                    fstWageMap.put("APP_IN_EMPL_A_WAGE_HOURLY_Cargo",
                            hourlyCargo);
                    fstWageMap.put("APP_IN_EMPL_A_WAGE_SALARY_Cargo",
                            salaryCargo);
                    fstWageMap.put("APP_IN_EMPL_A_WAGE_ADL1_Cargo", adtl1Cargo);
                    fstWageMap.put("APP_IN_EMPL_A_WAGE_ADL2_Cargo", adtl2Cargo);
                    fstWageMap.put("APP_IN_EMPL_A_WAGE_ADL3_Cargo", adtl3Cargo);
                    fstWageMap.put("APP_IN_EMPL_A_WAGE_ADL4_Cargo", adtl4Cargo);
                    fstWageMap.put("APP_IN_EMPL_A_WAGE_OTH1_Cargo", oth1Cargo);
                    fstWageMap.put("APP_IN_EMPL_A_WAGE_OTH2_Cargo", oth2Cargo);
                    fstWageMap.put("APP_IN_EMPL_A_WAGE_OTH3_Cargo", oth3Cargo);
                    fstWageMap.put("APP_IN_EMPL_A_WAGE_JOB_Cargo", jobCargo);
                    fstWageMap.put("APP_IN_EMPL_A_WAGE_ADD_Cargo", addCargo);
                    pageCollection.put("FST_WAGE", fstWageMap);
                    if (beforeColl.containsKey("SEC_WAGE")) {
                        pageCollection.put("SEC_WAGE",
                                beforeColl.get("SEC_WAGE"));
                    }

                    if (beforeColl.containsKey("SEC_EMPL")) {
                        pageCollection.put("SEC_EMPL",
                                beforeColl.get("SEC_EMPL"));
                    }
                    pageCollection.put("FST_EMPL", appInEmplCargo);
                    pageCollection.put(APP_IN_EMPL_COLLECTION_KEY,
                            appInEmplCollection);
                    pageCollection.put("END_PAGE_IND",
                            beforeColl.get("END_PAGE_IND"));
                    pageCollection
                    .put("PAGE_MODE", beforeColl.get("PAGE_MODE"));
                    return;
                }
            }
            // now we need to check the flags
            if (userEndInd == 0 && (empDetailsUpdate || wageDetailsUpdate[0])) {
                // check for the change effective date
                // if they did't fill this one raise validation
                if (!AppConstants.RMC_NEW_RECORD_IND.equals(sourceAppIndicator)
                        && AppConstants.HIGH_DATE.equals(appInEmplCargo
                                .getChg_eff_dt())) {
                    // EDSP validation
                    if (jobIncomeBO.hasMessages()) {
                        final String reqWarningMsgs = (String) request
                                .get(FwConstants.WARNING_MSG_DETAILS);
                        if (!checkForWarningMesgs(reqWarningMsgs,
                                jobIncomeBO.getMessageList())) {
                            request.put(FwConstants.MESSAGE_LIST,
                                    jobIncomeBO.getMessageList());
                            pageCollection
                            .put(AppConstants.CURRENT_EMPL_TYPE,
                                    beforeColl
                                    .get(AppConstants.CURRENT_EMPL_TYPE));
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
                            fstWageMap = new HashMap();
                            fstWageMap.put("APP_IN_EMPL_A_WAGE_INKIND_Cargo",
                                    inkindCargo);
                            fstWageMap.put("APP_IN_EMPL_A_WAGE_HOURLY_Cargo",
                                    hourlyCargo);
                            fstWageMap.put("APP_IN_EMPL_A_WAGE_SALARY_Cargo",
                                    salaryCargo);
                            fstWageMap.put("APP_IN_EMPL_A_WAGE_ADL1_Cargo",
                                    adtl1Cargo);
                            fstWageMap.put("APP_IN_EMPL_A_WAGE_ADL2_Cargo",
                                    adtl2Cargo);
                            fstWageMap.put("APP_IN_EMPL_A_WAGE_ADL3_Cargo",
                                    adtl3Cargo);
                            fstWageMap.put("APP_IN_EMPL_A_WAGE_ADL4_Cargo",
                                    adtl4Cargo);
                            fstWageMap.put("APP_IN_EMPL_A_WAGE_OTH1_Cargo",
                                    oth1Cargo);
                            fstWageMap.put("APP_IN_EMPL_A_WAGE_OTH2_Cargo",
                                    oth2Cargo);
                            fstWageMap.put("APP_IN_EMPL_A_WAGE_OTH3_Cargo",
                                    oth3Cargo);
                            fstWageMap.put("APP_IN_EMPL_A_WAGE_JOB_Cargo",
                                    jobCargo);
                            fstWageMap.put("APP_IN_EMPL_A_WAGE_ADD_Cargo",
                                    addCargo);
                            pageCollection.put("FST_WAGE", fstWageMap);
                            if (beforeColl.containsKey("SEC_WAGE")) {
                                pageCollection.put("SEC_WAGE",
                                        beforeColl.get("SEC_WAGE"));
                            }

                            if (beforeColl.containsKey("SEC_EMPL")) {
                                pageCollection.put("SEC_EMPL",
                                        beforeColl.get("SEC_EMPL"));
                            }
                            pageCollection.put("FST_EMPL", appInEmplCargo);
                            pageCollection.put("END_PAGE_IND",
                                    beforeColl.get("END_PAGE_IND"));
                            return;
                        }
                    }
                }
            }

            // EDSP RMC
            if (appInEmplCargo.getNext_paycheck_dt() == null
                    || appInEmplCargo.getNext_paycheck_dt().trim().length() == 0
                    || AppConstants.HIGH_DATE.equals(appInEmplCargo
                            .getNext_paycheck_dt())) {
                appInEmplCargo.setNext_paycheck_dt(AppConstants.HIGH_DATE);
            } else {
                final StringBuilder dateConverter = new StringBuilder();
                final String sAppDate = appInEmplCargo.getNext_paycheck_dt();
                dateConverter.append(sAppDate.substring(6, 10)).append("-")
                .append(sAppDate.substring(0, 2)).append("-")
                .append(sAppDate.substring(3, 5));
                appInEmplCargo.setNext_paycheck_dt(dateConverter.toString());
            }

            if (appInEmplCargo.getEmpl_beg_dt() != null
                    && appInEmplCargo.getEmpl_beg_dt().trim().length() != 0
                    && appInEmplCargo.getEmpl_beg_dt().length() == 10
                    && appInEmplCargo.getEmpl_beg_dt().charAt(2) == '/'

                    ) {
                final StringBuilder dateConverter = new StringBuilder();
                final String sAppDate = appInEmplCargo.getEmpl_beg_dt();
                dateConverter.append(sAppDate.substring(6, 10)).append("-")
                .append(sAppDate.substring(0, 2)).append("-")
                .append(sAppDate.substring(3, 5));
                appInEmplCargo.setEmpl_beg_dt(dateConverter.toString());
            }

            if (appInEmplCargo.getFst_payck_dt() != null
                    && appInEmplCargo.getFst_payck_dt().trim().length() != 0
                    && appInEmplCargo.getFst_payck_dt().length() == 10
                    && appInEmplCargo.getFst_payck_dt().charAt(2) == '/'

                    ) {
                final StringBuilder dateConverter = new StringBuilder();
                final String sAppDate = appInEmplCargo.getFst_payck_dt();
                dateConverter.append(sAppDate.substring(6, 10)).append("-")
                .append(sAppDate.substring(0, 2)).append("-")
                .append(sAppDate.substring(3, 5));
                appInEmplCargo.setFst_payck_dt(dateConverter.toString());
            }

            if (appInEmplCargo.getEmpl_end_dt() != null
                    && appInEmplCargo.getEmpl_end_dt().trim().length() != 0
                    && appInEmplCargo.getEmpl_end_dt().length() == 10
                    && appInEmplCargo.getEmpl_end_dt().charAt(2) == '/'

                    ) {
                final StringBuilder dateConverter = new StringBuilder();
                final String sAppDate = appInEmplCargo.getEmpl_end_dt();
                dateConverter.append(sAppDate.substring(6, 10)).append("-")
                .append(sAppDate.substring(0, 2)).append("-")
                .append(sAppDate.substring(3, 5));
                appInEmplCargo.setEmpl_end_dt(dateConverter.toString());
            }

            if (appInEmplCargo.getLast_payck_dt() != null
                    && appInEmplCargo.getLast_payck_dt().trim().length() != 0
                    && appInEmplCargo.getLast_payck_dt().length() == 10
                    && appInEmplCargo.getLast_payck_dt().charAt(2) == '/'

                    ) {
                final StringBuilder dateConverter = new StringBuilder();
                final String sAppDate = appInEmplCargo.getLast_payck_dt();
                dateConverter.append(sAppDate.substring(6, 10)).append("-")
                .append(sAppDate.substring(0, 2)).append("-")
                .append(sAppDate.substring(3, 5));
                appInEmplCargo.setLast_payck_dt(dateConverter.toString());
            }

            if (empDetailsUpdate || wageDetailsUpdate[0]) {
                if (FwConstants.ROWACTION_INSERT.equals(appInEmplCargo
                        .getRowAction())) {
                    jobIncomeBO.insertExistingDetails(appInEmplCollection);
                } else {
                    jobIncomeBO.storeDetails(appInEmplCollection);
                }
            }
            if (wageDetailsUpdate[0]) {
                final WagesBO wageBo = new WagesBO();
                wageBo.storeDetails(updatedWageColl);
            }

            final int[] driverArray = (int[]) session
                    .get(FwConstants.RMC_DRIVER);
            boolean loopingQuestion = false;
            if (request.get(AppConstants.LOOPING_QUESTION) != null
                    && FwConstants.YES.equals(request
                            .get(AppConstants.LOOPING_QUESTION))) {
                loopingQuestion = true;
                // Insert into APP_IN_EMPL and APP_IN_EMPL_A_WAGE
                categorySelectionProfileManager.insertSequenceDetail(
                        jobIncomeProfile, null, null,
                        categorySeqDetailBean.getIndividualSequence(),
                        categorySeqDetailBean.getCategoryType());
                driverManager.makeRequired(FwConstants.RMC_DRIVER,
                        currentPageID, driverArray, appNumber);
                // EDSP RMB TEMP

            }
            
            // now i need to update the rmc_in_prfl if looping question is null
            if (!loopingQuestion
//                    && categorySeqDetailBean.getChangeSelectionCategoryCd() == null
                    ) {
                final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
                        .get(AppConstants.RMC_IN_PRFL_MASTER);
                final RMC_IN_PRFL_Cargo rmcInPrflCargo = rmcResponseProfileManager
                        .getProfile(rmcInPrflColl, String
                                .valueOf(categorySeqDetailBean
                                        .getIndividualSequence()));
                short respTyp= rmcResponseProfileManager
                        .getResponseByType(
                                IRMCResponseProfileManager.EMPLOYMENT_DETAILS,
                                categorySeqDetailBean
                                .getCategoryType());
                if (rmcInPrflCargo != null && rmcResponseProfileManager.getProfileResponse(
						rmcInPrflCargo, respTyp).charAt(0) == IRMCResponseProfileManager.STATUS_REQUIRED) {
                	reqInd=true;
                    rmcResponseProfileManager
                    .makeComplete(
                            respTyp,
                                    rmcInPrflCargo, true);
                }
            }
            // Mark complete job sequence using common methods
            if(!reqInd || categorySeqDetailBean.getChangeSelectionCategoryCd()==null)
			{
            categorySelectionProfileManager.makeSequenceDetailComplete(
                    jobIncomeProfile, null,
                    categorySeqDetailBean.getIndividualSequence(),
                    categorySeqDetailBean.getCategorySequence(),
                    categorySeqDetailBean.getCategoryType());
			}
            else{
            	categorySelectionProfileManager.makeSequenceDetailComplete(
    					jobIncomeProfile, appNumber,
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
                    .areAllSequencesComplete(jobIncomeProfile)) {
                driverManager.makeComplete(FwConstants.RMC_DRIVER,
                        currentPageID, driverArray, appNumber);
            } else {
                categorySelectionProfileManager
                .getNextSequenceDetail(jobIncomeProfile);
            }
            
            // logic to schedule Employment health insurance screen using category sequence.
            /*final JobIncomeBO jobBO = new JobIncomeBO();
            APP_IN_EMPL_Collection jobColl = jobBO.loadDetails(appNumber);
            boolean isEmpInsPageReq = false; 
            
            for(Object o : jobColl){
                APP_IN_EMPL_Cargo cargo = (APP_IN_EMPL_Cargo) o;
                if(cargo.getSrc_app_ind()!= null &&( cargo.getSrc_app_ind().equalsIgnoreCase(AppConstants.RMC_NEW_RECORD_IND)
                        || cargo.getSrc_app_ind().equalsIgnoreCase(AppConstants.RMC_MODIFIED_RECORD_IND))
                        && FwConstants.YES.equals(cargo.getEr_provd_med_ins_ind())){
                    isEmpInsPageReq = true;
                    break;
                }
            }
       
            SortedSet catprofileDB = categorySelectionProfileManager.loadCategoryChangeSelectionProfile(appNumber);
            if (FwConstants.YES.equals(appInEmplCargo.getEr_provd_med_ins_ind())) {
                if(null != categorySelectionProfileManager.getCategorySequenceDetail(catprofileDB, Short.parseShort(appInEmplCargo.getIndv_seq_num()), Short.parseShort(appInEmplCargo.getSeq_num()), AppConstants.EMPL_HLTH_INS)){
                    categorySelectionProfileManager.makeSequenceDetailRequired(catprofileDB, appNumber, Short.parseShort(appInEmplCargo.getIndv_seq_num()), Short.parseShort(appInEmplCargo.getSeq_num()), AppConstants.EMPL_HLTH_INS);
                }else{
                    categorySelectionProfileManager.insertSequenceDetail(catprofileDB,
                            appNumber,
                            AppConstants.EMPL_HLTH_INS, 
                            Short.parseShort(appInEmplCargo.getIndv_seq_num()),
                            Short.parseShort(appInEmplCargo.getSeq_num()), 
                            AppConstants.EMPL_HLTH_INS , 
                            Short.parseShort("0"));
                }
                if(!emplPageResponse.equals(befEmplResponse)){
                driverManager.makeRequired(FwConstants.RMC_DRIVER, "AREHI", driverArray, appNumber);
                }
            }else{
                if(null != categorySelectionProfileManager.getCategorySequenceDetail(catprofileDB, Short.parseShort(appInEmplCargo.getIndv_seq_num()), Short.parseShort(appInEmplCargo.getSeq_num()), AppConstants.EMPL_HLTH_INS)){
                    categorySelectionProfileManager.removeSequenceDetail(catprofileDB, appNumber, Short.parseShort(appInEmplCargo.getIndv_seq_num()), Short.parseShort(appInEmplCargo.getSeq_num()), AppConstants.EMPL_HLTH_INS, AppConstants.EMPL_HLTH_INS);
                    jobBO.eraseEmpIns(appInEmplCargo.getApp_num(), appInEmplCargo.getIndv_seq_num(),appInEmplCargo.getSrc_app_ind());
                }
                if(!isEmpInsPageReq){
                    driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
                            "AREHI", driverArray, appNumber);
                }
            }*/
        
        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("storeEmploymentDetails");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "storeEmploymentDetails", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.storeEmploymentDetails() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Comment here.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */
    public void deleteWageDetails(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.deleteWageDetails() - START");
        try {
            final Map session = txnBean.getSession();
            final Map request = txnBean.getRequest();
            final Map pageCollection = txnBean.getPageCollection();
            // get the BeforeCollection
            final Map beforeColl = (Map) session
                    .get(FwConstants.BEFORE_COLLECTION);
            session.get(AppConstants.INDIV_MASTER_HANDLER);
            final String pageMode = (String) beforeColl.get("PAGE_MODE");
            final APP_IN_EMPL_Collection appInEmplCollection = (APP_IN_EMPL_Collection) pageCollection
                    .get(APP_IN_EMPL_COLLECTION_KEY);
            final APP_IN_EMPL_Cargo appInEmplCargo = appInEmplCollection
                    .getCargo(0);

            final APP_IN_EMPL_A_WAGE_Collection appInEmplAWageCollection = (APP_IN_EMPL_A_WAGE_Collection) pageCollection
                    .get("APP_IN_EMPL_A_WAGE_Collection");

            // assign cargos
            final APP_IN_EMPL_A_WAGE_Cargo inkindCargo = splitEmplWage(
                    appInEmplAWageCollection, FwConstants.ZERO);
            final APP_IN_EMPL_A_WAGE_Cargo hourlyCargo = splitEmplWage(
                    appInEmplAWageCollection, "1001");
            final APP_IN_EMPL_A_WAGE_Cargo salaryCargo = splitEmplWage(
                    appInEmplAWageCollection, "1002");

            final Iterator keysIter = request.keySet().iterator();
            String buttonName = null;
            while (keysIter.hasNext()) {
                buttonName = (String) keysIter.next();
                if (buttonName.endsWith(".x") || buttonName.endsWith(".y")) {// viz

                    break;
                }
            }

            APP_IN_EMPL_A_WAGE_Cargo adtl1Cargo = splitEmplWage(
                    appInEmplAWageCollection, "1003");
            APP_IN_EMPL_A_WAGE_Cargo adtl2Cargo = splitEmplWage(
                    appInEmplAWageCollection, "1004");
            APP_IN_EMPL_A_WAGE_Cargo adtl3Cargo = splitEmplWage(
                    appInEmplAWageCollection, "1005");
            APP_IN_EMPL_A_WAGE_Cargo adtl4Cargo = splitEmplWage(
                    appInEmplAWageCollection, "1006");
            APP_IN_EMPL_A_WAGE_Cargo oth1Cargo = splitEmplWage(
                    appInEmplAWageCollection, "7");
            APP_IN_EMPL_A_WAGE_Cargo oth2Cargo = splitEmplWage(
                    appInEmplAWageCollection, "8");
            APP_IN_EMPL_A_WAGE_Cargo oth3Cargo = splitEmplWage(
                    appInEmplAWageCollection, "9");
            APP_IN_EMPL_A_WAGE_Cargo jobCargo = splitEmplWage(
                    appInEmplAWageCollection, "10");
            // bob!!!
            final APP_IN_EMPL_A_WAGE_Cargo addCargo = splitEmplWage(
                    appInEmplAWageCollection, "11");
            // bob!!!
            List deletedList = null;
            deletedList = (List) beforeColl.get("DELETED_WAGES");
            if (deletedList == null) {
                deletedList = new ArrayList();
            }

            if (buttonName.startsWith("delete_1003")) {
                adtl1Cargo = null;
                if (!deletedList.contains("1003")) {
                    deletedList.add("1003");
                }
            } else if (buttonName.startsWith("delete_1004")) {
                adtl2Cargo = null;
                if (!deletedList.contains("1004")) {
                    deletedList.add("1004");
                }
            } else if (buttonName.startsWith("delete_1005")) {
                adtl3Cargo = null;
                if (!deletedList.contains("1005")) {
                    deletedList.add("1005");
                }
            } else if (buttonName.startsWith("delete_1006")) {
                adtl4Cargo = null;
                if (!deletedList.contains("1006")) {
                    deletedList.add("1006");
                }
            } else if (buttonName.startsWith("delete_7")) {
                oth1Cargo = null;
                if (!deletedList.contains("7")) {
                    deletedList.add("7");
                }
            } else if (buttonName.startsWith("delete_8")) {
                oth2Cargo = null;
                if (!deletedList.contains("8")) {
                    deletedList.add("8");
                }
            } else if (buttonName.startsWith("delete_9")) {
                oth3Cargo = null;
                if (!deletedList.contains("9")) {
                    deletedList.add("9");
                }
            } else if (buttonName.startsWith("delete_1010")) { // ???
                jobCargo = null;
                if (!deletedList.contains("10")) {
                    deletedList.add("10"); // 1010 bor
                }
            }
            beforeColl.put("DELETED_WAGES", deletedList);
            session.put(FwConstants.BEFORE_COLLECTION, beforeColl);
            final JobIncomeBO jobIncomeBO = new JobIncomeBO();
            beforeColl.get(AppConstants.FIRST_NAME);
            if ("c".equalsIgnoreCase(pageMode)) {
                final APP_IN_EMPL_Collection appInBeforeEmplCollection = (APP_IN_EMPL_Collection) beforeColl
                        .get(APP_IN_EMPL_COLLECTION_KEY);

                final APP_IN_EMPL_Cargo appInBeforeEmplCargo = appInBeforeEmplCollection
                        .getCargo(0);
                appInEmplCargo.setEmpl_beg_dt(appInBeforeEmplCargo
                        .getEmpl_beg_dt());
                appInEmplCargo.setFst_payck_dt(appInBeforeEmplCargo
                        .getFst_payck_dt());
                appInEmplCargo.setEr_nam(appInBeforeEmplCargo.getEr_nam());
            }

            final SortedSet jobIncomeProfile = (SortedSet) beforeColl
                    .get(AppConstants.RMC_CATEGORY_PAGE_PRFL);
            final CategorySequenceDetail categorySeqDetailBean = categorySelectionProfileManager
                    .getCurrentSequenceDetail(jobIncomeProfile);
            categorySeqDetailBean.getCategoryType();

            jobIncomeBO.validateDelete(deletedList, appInEmplAWageCollection);
            if (jobIncomeBO.hasMessages()) {
                request.put(FwConstants.MESSAGE_LIST,
                        jobIncomeBO.getMessageList());
            }
            pageCollection.put(AppConstants.CURRENT_EMPL_TYPE,
                    beforeColl.get(AppConstants.CURRENT_EMPL_TYPE));
            pageCollection.put("PAGE_MODE", beforeColl.get("PAGE_MODE"));
            pageCollection.put(AppConstants.FIRST_NAME,
                    beforeColl.get(AppConstants.FIRST_NAME));
            if (request.get(AppConstants.LOOPING_QUESTION) != null) {
                request.put(AppConstants.LOOPING_QUESTION,
                        request.get(AppConstants.LOOPING_QUESTION));
            }
            pageCollection.put(FwConstants.PAGE_COMPONENT_LIST,
                    beforeColl.get(FwConstants.PAGE_COMPONENT_LIST));
            final Map fstWageMap = new HashMap();
            fstWageMap.put("APP_IN_EMPL_A_WAGE_INKIND_Cargo", inkindCargo);
            fstWageMap.put("APP_IN_EMPL_A_WAGE_HOURLY_Cargo", hourlyCargo);
            fstWageMap.put("APP_IN_EMPL_A_WAGE_SALARY_Cargo", salaryCargo);
            fstWageMap.put("APP_IN_EMPL_A_WAGE_ADL1_Cargo", adtl1Cargo);
            fstWageMap.put("APP_IN_EMPL_A_WAGE_ADL2_Cargo", adtl2Cargo);
            fstWageMap.put("APP_IN_EMPL_A_WAGE_ADL3_Cargo", adtl3Cargo);
            fstWageMap.put("APP_IN_EMPL_A_WAGE_ADL4_Cargo", adtl4Cargo);
            fstWageMap.put("APP_IN_EMPL_A_WAGE_OTH1_Cargo", oth1Cargo);
            fstWageMap.put("APP_IN_EMPL_A_WAGE_OTH2_Cargo", oth2Cargo);
            fstWageMap.put("APP_IN_EMPL_A_WAGE_OTH3_Cargo", oth3Cargo);
            fstWageMap.put("APP_IN_EMPL_A_WAGE_JOB_Cargo", jobCargo);
            fstWageMap.put("APP_IN_EMPL_A_WAGE_ADD_Cargo", addCargo);
            pageCollection.put("FST_WAGE", fstWageMap);
            if (beforeColl.containsKey("SEC_WAGE")) {
                pageCollection.put("SEC_WAGE", beforeColl.get("SEC_WAGE"));
            }

            if (beforeColl.containsKey("SEC_EMPL")) {
                pageCollection.put("SEC_EMPL", beforeColl.get("SEC_EMPL"));
            }
            pageCollection.put("FST_EMPL", appInEmplCargo);
            // EDSP RMB
            pageCollection.put(APP_IN_EMPL_COLLECTION_KEY, appInEmplCollection);

        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("deleteWageDetails");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "deleteWageDetails", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.deleteWageDetails() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Load inkind details.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */
    public void loadInkindDetails(final FwTransaction txnBean)
            throws javax.ejb.EJBException {

        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.loadInkindDetails() - START");
        try {
            log(ILog.INFO, "RMCJobIncomeEJBBean::loadInkindDetails:Start");
            final Map session = txnBean.getSession();
            final Map request = txnBean.getRequest();
            final Map pageCollection = txnBean.getPageCollection();

            APP_IN_EMPL_Collection appInEmplColl;
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
            // EDSP RMB loading from database
            final Map incomeType = new HashMap<String, String>();
            incomeType.put("I", "I");
            incomeType.put("P", "P");

            if (pageStatus == FwConstants.DRIVER_REQUIRED
                    || pageStatus == FwConstants.DRIVER_VISIT_AGAIN
                    && categorySelectionProfileManager.isEmpty(
                            categorySelectionProfile, incomeType)) {
                categorySelectionProfile = categorySelectionProfileManager
                        .loadCategoryChangeSelectionProfile(appNumber,
                                AppConstants.RMC_CAT_EMP_PRFL);
            } else if (pageStatus == FwConstants.DRIVER_COMPLETE
                    && !pageId.equals(previousPageId)
                    && categorySelectionProfileManager.isEmpty(
                            categorySelectionProfile, incomeType)) {
                categorySelectionProfile = categorySelectionProfileManager
                        .loadCategoryChangeSelectionProfile(appNumber,
                                AppConstants.RMC_CAT_EMP_PRFL);
            }

            Map beforeColl = (Map) session.get(FwConstants.BEFORE_COLLECTION);
            // EDSP RMB loading from database ends
            final JobIncomeBO jobIncomeBO = new JobIncomeBO();
            final short[] responseType = new short[] { IRMCResponseProfileManager.JOB_IN_KIND };
            SortedSet jobIncomeProfile = null;
            if (!pageId.equals(previousPageId)) {
                jobIncomeProfile = createPageProfile(categorySelectionProfile,
                        rmcInPrflColl, responseType);
                if (pageStatus != FwConstants.DRIVER_REQUIRED) {
                    final APP_IN_EMPL_Collection newEmplColl = jobIncomeBO
                            .getInKindDetails(appNumber);
                    if (newEmplColl != null && !newEmplColl.isEmpty()) {
                        APP_IN_EMPL_Cargo appInEmplCargo = null;
                        final int newEmplCollSize = newEmplColl.size();
                        for (int i = 0; i < newEmplCollSize; i++) {
                            appInEmplCargo = newEmplColl.getCargo(i);
                            categorySelectionProfileManager
                            .insertExistingSequenceDetail(
                                    jobIncomeProfile, null, null,
                                    Short.parseShort(appInEmplCargo
                                            .getIndv_seq_num()),
                                            Long.parseLong(appInEmplCargo
                                                    .getEmpl_seq_num()),
                                                    appInEmplCargo.getEmpl_typ());
                        }
                    }
                }
                if (pageStatus == FwConstants.DRIVER_REQUIRED
                        || pageStatus == FwConstants.DRIVER_VISIT_AGAIN) {
                    // set the current record indicator to the first one
                    categorySelectionProfileManager
                    .setCurrentRecordIndToFirst(jobIncomeProfile);
                }
                if (pageStatus == FwConstants.DRIVER_COMPLETE) {
                    // set the current record indicator to the end of the detail
                    // bean
                    categorySelectionProfileManager
                    .setCurrentRecordIndToLast(jobIncomeProfile);
                }
                // create add new sorted set
                // we need to remove the vallues from the session
                session.remove(FwConstants.BEFORE_COLLECTION);
            } else {
                // catAddNewProfile get it from the before collection
                beforeColl = (Map) session.get(FwConstants.BEFORE_COLLECTION);
                jobIncomeProfile = (SortedSet) beforeColl
                        .get(AppConstants.RMC_CATEGORY_PAGE_PRFL);
            }

            final IndivTypeSeqBean indivSeqBean = (IndivTypeSeqBean) pageCollection
                    .get(FwConstants.DETAIL_KEY_BEAN);

            if (indivSeqBean != null) {
                final CategorySequenceDetail categorySeqDetail1 = categorySelectionProfileManager
                        .getCategorySequenceDetail(
                                jobIncomeProfile,
                                Short.parseShort(indivSeqBean.getIndivSeqNum()),
                                Long.parseLong(indivSeqBean.getSeqNum()),
                                indivSeqBean.getType());
                if (categorySeqDetail1 != null) {

                    if (categorySeqDetail1.getUserEndSelectionInd() != Short
                            .parseShort(indivSeqBean.getUserEndInd())) {
                        categorySelectionProfileManager
                        .updateUserEndSelInd(
                                jobIncomeProfile,
                                appNumber,
                                Short.parseShort(indivSeqBean
                                        .getIndivSeqNum()),
                                        Long.parseLong(indivSeqBean.getSeqNum()),
                                        indivSeqBean.getType(), Short
                                        .parseShort(indivSeqBean
                                                .getUserEndInd()));
                    }
                    categorySelectionProfileManager.makeSequenceDetailRequired(
                            jobIncomeProfile, null,
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
                        // now we need to make required the employment
                        if (AppConstants.EMPL_REGULAR.equals(indivSeqBean
                                .getType())) {
                            rmcResponseProfileManager.makeAddNew(
                                    IRMCResponseProfileManager.REGULAR_EMPL,
                                    rmcInPrflCargo, true);
                        } else {
                            rmcResponseProfileManager.makeAddNew(
                                    IRMCResponseProfileManager.JOB_IN_KIND,
                                    rmcInPrflCargo, true);
                        }
                        categorySelectionProfileManager
                        .insertSequenceDetail(jobIncomeProfile, null,
                                null, Short.parseShort(indivSeqBean
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
                        .insertSequenceDetail(jobIncomeProfile, null,
                                AppConstants.RMC_CAT_EMP_PRFL, Short
                                .parseShort(indivSeqBean
                                        .getIndivSeqNum()),
                                        Short.parseShort(indivSeqBean
                                                .getSeqNum()), indivSeqBean
                                                .getType(), Short
                                                .parseShort(userEndInd));
                        categorySelectionProfileManager
                        .makeSequenceDetailRequired(jobIncomeProfile,
                                null, Short.parseShort(indivSeqBean
                                        .getIndivSeqNum()), Short
                                        .parseShort(indivSeqBean
                                                .getSeqNum()),
                                                indivSeqBean.getType());

                        categorySelectionProfileManager
                        .insertSequenceDetail(categorySelectionProfile,
                                appNumber,
                                AppConstants.RMC_CAT_EMP_PRFL, Short
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
                    jobIncomeProfile);

            CategorySequenceDetail categorySeqDetail = categorySelectionProfileManager
                    .getCurrentSequenceDetail(jobIncomeProfile);
            if (categorySeqDetail == null) {
                categorySeqDetail = categorySelectionProfileManager
                        .getNextSequenceDetail(jobIncomeProfile);
            }
            final String categoryType = categorySeqDetail.getCategoryType();
            final String categorySeqNum = Long.toString(categorySeqDetail
                    .getCategorySequence());

            final String indvSeqNum = Short.toString(categorySeqDetail
                    .getIndividualSequence());

            pageCollection.put("END_PAGE_IND",
                    String.valueOf(categorySeqDetail.getUserEndSelectionInd()));

            appInEmplColl = jobIncomeBO.loadDetails(appNumber, indvSeqNum,
                    categorySeqNum);

            APP_IN_EMPL_Cargo appInEmplCargo = null;
            String pageMode = null;

            if (appInEmplColl != null && !appInEmplColl.isEmpty()) {
                appInEmplCargo = appInEmplColl.getCargo(0);
            }

            APP_IN_EMPL_Cargo cwwEmplCargo = splitEmplColl(appInEmplColl,
                    AppConstants.CWW_RECORD_IND);
            if (cwwEmplCargo == null) {
                cwwEmplCargo = new APP_IN_EMPL_Cargo();
            }

            pageCollection.put("SEC_EMPL", settingDefaultValues(cwwEmplCargo));

            APP_IN_EMPL_Cargo rmcEmplCargo = splitEmplColl(appInEmplColl,
                    AppConstants.RMC_NEW_RECORD_IND);
            if (appInEmplCargo != null
                    && ("CW".equalsIgnoreCase(appInEmplCargo.getSrc_app_ind()) || "RM"
                            .equalsIgnoreCase(appInEmplCargo.getSrc_app_ind()))
                            && categorySeqDetail.getUserEndSelectionInd() == 0) {
                pageMode = "C";

            } else if (categorySeqDetail.getUserEndSelectionInd() == 1) {
                pageMode = "E";
            } else {
                pageMode = FwConstants.NO;

            }

            if (rmcEmplCargo != null) {

                pageCollection.put("FST_EMPL",
                        settingDefaultValues(rmcEmplCargo));
            } else {
                rmcEmplCargo = splitEmplColl(appInEmplColl,
                        AppConstants.RMC_MODIFIED_RECORD_IND);
                if (rmcEmplCargo != null) {
                    pageCollection.put("FST_EMPL",
                            settingDefaultValues(rmcEmplCargo));
                } else {
                    rmcEmplCargo = splitEmplColl(appInEmplColl,
                            AppConstants.RMC_END_RECORD_IND);
                    if (rmcEmplCargo != null) {
                        pageCollection.put("FST_EMPL",
                                settingDefaultValues(rmcEmplCargo));
                    } else {
                        pageCollection.put("FST_EMPL",
                                settingDefaultValues(cwwEmplCargo));
                    }
                }
            }

            String srcAppInd = FwConstants.EMPTY_STRING;
            if (appInEmplColl != null && !appInEmplColl.isEmpty()) {
                final APP_IN_EMPL_Cargo rmcInSelfeCargo = appInEmplColl
                        .getCargo(0);
                srcAppInd = rmcInSelfeCargo.getSrc_app_ind();
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

            pageCollection.put(APP_IN_EMPL_COLLECTION_KEY, appInEmplColl);
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
            pageCollection.put(AppConstants.INKIND_EMPL_TYPE, categoryType);

            final PeopleHandler peopleHandler = (PeopleHandler) session
                    .get(AppConstants.INDIV_MASTER_HANDLER);
            pageCollection.put(AppConstants.FIRST_NAME,
                    peopleHandler.getFirstName(indvSeqNum));

            componentManager.getComponents(AppConstants.ARIKI, txnBean);
            request.remove(AppConstants.LOOPING_QUESTION);
            // Add the page collection to before collection
            session.put(FwConstants.BEFORE_COLLECTION, pageCollection);

            log(ILog.INFO, "RMCJobIncomeEJBBean::loadInkindDetails:End");

        } catch (final FwException fe) {
            log(ILog.ERROR, fe.getMessage());
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("loadInkindDetails");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "loadInkindDetails", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.loadInkindDetails() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Store inkind details.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */
    public void storeInkindDetails(final FwTransaction txnBean)
            throws javax.ejb.EJBException {

        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.storeInkindDetails() - START");
        try {

            final Map session = txnBean.getSession();
            final Map request = txnBean.getRequest();
            final Map pageCollection = txnBean.getPageCollection();

            final String currentPageID = (String) request
                    .get(FwConstants.CURRENT_PAGE_ID);
            final String appNumber = (String) session
                    .get(AppConstants.APP_NUMBER);
            final List modifiedFields = (ArrayList) session
                    .get(AppConstants.MODIFIED_FIELDS);
            // build category selection profile
            final SortedSet categorySelectionProfile = (SortedSet) session
                    .get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
            // get the BeforeCollection
            final Map beforeColl = (Map) session
                    .get(FwConstants.BEFORE_COLLECTION);

            final APP_IN_EMPL_Collection appInEmplCollection = (APP_IN_EMPL_Collection) pageCollection
                    .get(APP_IN_EMPL_COLLECTION_KEY);
            if (appInEmplCollection.size() > 1) {
                appInEmplCollection.remove(1);
            }
            APP_IN_EMPL_Cargo appInEmplCargo = appInEmplCollection.getCargo(0);

            final SortedSet jobIncomeProfile = (SortedSet) beforeColl
                    .get(AppConstants.RMC_CATEGORY_PAGE_PRFL);
            final PeopleHandler peopleHandler = (PeopleHandler) session
                    .get(AppConstants.INDIV_MASTER_HANDLER);

            final String pageMode = (String) beforeColl.get("PAGE_MODE");

            final String firstName = (String) beforeColl
                    .get(AppConstants.FIRST_NAME);
            final CategorySequenceDetail categorySeqDetailBean = categorySelectionProfileManager
                    .getCurrentSequenceDetail(jobIncomeProfile);
            final short userEndInd = categorySeqDetailBean
                    .getUserEndSelectionInd();
            final String catPage = categorySeqDetailBean.getCategoryType();
            // Run Validations
            final JobIncomeBO jobIncomeBO = new JobIncomeBO();

            final APP_IN_EMPL_Collection beforeCollAppInEmplColl = (APP_IN_EMPL_Collection) beforeColl
                    .get(APP_IN_EMPL_COLLECTION_KEY);
            APP_IN_EMPL_Cargo beforeEmplCargo = null;

            appInEmplCargo.setApp_num(appNumber);

            if (appInEmplCargo.getIk_empl_nam() == null
                    || appInEmplCargo.getIk_empl_nam().trim().length() == 0) {
                appInEmplCargo.setIk_empl_nam(FwConstants.SPACE);
            }
            if (appInEmplCargo.getIk_empl_add_l1() == null
                    || appInEmplCargo.getIk_empl_add_l1().trim().length() == 0) {
                appInEmplCargo.setIk_empl_add_l1(FwConstants.SPACE);
            }
            if (appInEmplCargo.getIk_empl_add_l2() == null
                    || appInEmplCargo.getIk_empl_add_l2().trim().length() == 0) {
                appInEmplCargo.setIk_empl_add_l2(FwConstants.SPACE);
            }
            if (appInEmplCargo.getIk_empl_city() == null
                    || appInEmplCargo.getIk_empl_city().trim().length() == 0) {
                appInEmplCargo.setIk_empl_city(FwConstants.SPACE);
            }
            if (appInEmplCargo.getIk_empl_state() == null
                    || AppConstants.SELECT_DEFAULT_OPTION.equals(appInEmplCargo
                            .getIk_empl_state().trim())) {
                appInEmplCargo.setIk_empl_city(FwConstants.SPACE);
            }
            if (appInEmplCargo.getIk_empl_zipcode() == null
                    || appInEmplCargo.getIk_empl_zipcode().trim().length() == 0) {
                appInEmplCargo.setIk_empl_zipcode(FwConstants.SPACE);
            }
            if (appInEmplCargo.getIk_empl_phone() == null
                    || appInEmplCargo.getIk_empl_phone().trim().length() == 0) {
                appInEmplCargo.setIk_empl_phone(FwConstants.SPACE);
            }
            if (appInEmplCargo.getIk_job_start_date() == null
                    || appInEmplCargo.getIk_job_start_date().trim().length() == 0
                    || AppConstants.HIGH_TIMESTAMP
                    .equalsIgnoreCase(appInEmplCargo
                            .getIk_job_start_date())
                            || AppConstants.HIGH_TIMESTAMP1
                            .equalsIgnoreCase(appInEmplCargo
                                    .getIk_job_start_date())) {
                appInEmplCargo.setIk_job_start_date(AppConstants.HIGH_DATE);
            } else {
                String sDate = appInEmplCargo.getIk_job_start_date();
                if (sDate.length() > 10) {
                    sDate = sDate.substring(0, 10);
                }
                appInEmplCargo.setIk_job_start_date(sDate);
            }
            if (appInEmplCargo.getIk_job_end_date() == null
                    || appInEmplCargo.getIk_job_end_date().trim().length() == 0
                    || AppConstants.HIGH_TIMESTAMP
                    .equalsIgnoreCase(appInEmplCargo
                            .getIk_job_end_date())
                            || AppConstants.HIGH_TIMESTAMP1
                            .equalsIgnoreCase(appInEmplCargo
                                    .getIk_job_end_date())) {
                appInEmplCargo.setIk_job_end_date(AppConstants.HIGH_DATE);
            } else {
                String sDate = appInEmplCargo.getIk_job_end_date();
                if (sDate.length() > 10) {
                    sDate = sDate.substring(0, 10);
                }
                appInEmplCargo.setIk_job_end_date(sDate);
            }

            if (appInEmplCargo.getEmpl_beg_dt() != null
                    && appInEmplCargo.getEmpl_beg_dt().trim().length() != 0
                    && !AppConstants.HIGH_TIMESTAMP
                    .equalsIgnoreCase(appInEmplCargo.getEmpl_beg_dt())
                    && !AppConstants.HIGH_TIMESTAMP1
                    .equalsIgnoreCase(appInEmplCargo.getEmpl_beg_dt())) {
                String sDate = appInEmplCargo.getEmpl_beg_dt();
                if (sDate.length() > 10) {
                    sDate = sDate.substring(0, 10);
                }
                appInEmplCargo.setEmpl_beg_dt(sDate);
            }

            if (appInEmplCargo.getEmpl_end_dt() == null
                    || appInEmplCargo.getEmpl_end_dt().trim().length() == 0
                    || AppConstants.HIGH_TIMESTAMP
                    .equalsIgnoreCase(appInEmplCargo.getEmpl_end_dt())
                    || AppConstants.HIGH_TIMESTAMP1
                    .equalsIgnoreCase(appInEmplCargo.getEmpl_end_dt())) {
            } else {
                String sDate = appInEmplCargo.getEmpl_beg_dt();
                if (sDate.length() > 10) {
                    sDate = sDate.substring(0, 10);
                }
                appInEmplCargo.setEmpl_end_dt(sDate);
            }
            if (appInEmplCargo.getFst_payck_dt() == null
                    || appInEmplCargo.getFst_payck_dt().trim().length() == 0
                    || AppConstants.HIGH_TIMESTAMP
                    .equalsIgnoreCase(appInEmplCargo.getFst_payck_dt())
                    || AppConstants.HIGH_TIMESTAMP1
                    .equalsIgnoreCase(appInEmplCargo.getFst_payck_dt())) {
                appInEmplCargo.setFst_payck_dt(AppConstants.HIGH_DATE);
            } else {
                String sDate = appInEmplCargo.getEmpl_beg_dt();
                if (sDate.length() > 10) {
                    sDate = sDate.substring(0, 10);
                }
                appInEmplCargo.setFst_payck_dt(sDate);
            }
            if (appInEmplCargo.getLast_payck_dt() == null
                    || appInEmplCargo.getLast_payck_dt().trim().length() == 0
                    || AppConstants.HIGH_TIMESTAMP
                    .equalsIgnoreCase(appInEmplCargo.getLast_payck_dt())
                    || AppConstants.HIGH_TIMESTAMP1
                    .equalsIgnoreCase(appInEmplCargo.getLast_payck_dt())) {
                appInEmplCargo.setLast_payck_dt(AppConstants.HIGH_DATE);
            } else {
                String sDate = appInEmplCargo.getLast_payck_dt();
                if (sDate.length() > 10) {
                    sDate = sDate.substring(0, 10);
                }
                appInEmplCargo.setLast_payck_dt(sDate);
            }
            if (appInEmplCargo.getChg_eff_dt() == null
                    || appInEmplCargo.getChg_eff_dt().trim().length() == 0
                    || AppConstants.HIGH_TIMESTAMP
                    .equalsIgnoreCase(appInEmplCargo.getChg_eff_dt())
                    || AppConstants.HIGH_TIMESTAMP1
                    .equalsIgnoreCase(appInEmplCargo.getChg_eff_dt())) {
                appInEmplCargo.setChg_eff_dt(AppConstants.HIGH_DATE);
            } else {
                String sDate = appInEmplCargo.getChg_eff_dt();
                if (sDate.length() > 10) {
                    sDate = sDate.substring(0, 10);
                }
                appInEmplCargo.setChg_eff_dt(sDate);
            }

            if (appInEmplCargo.getStrk_beg_dt() == null
                    || appInEmplCargo.getStrk_beg_dt().trim().length() == 0
                    || AppConstants.HIGH_TIMESTAMP
                    .equalsIgnoreCase(appInEmplCargo.getStrk_beg_dt())
                    || AppConstants.HIGH_TIMESTAMP1
                    .equalsIgnoreCase(appInEmplCargo.getStrk_beg_dt())) {
                appInEmplCargo.setStrk_beg_dt(AppConstants.HIGH_DATE);
            } else {
                String sDate = appInEmplCargo.getStrk_beg_dt();
                if (sDate.length() > 10) {
                    sDate = sDate.substring(0, 10);
                }
                appInEmplCargo.setStrk_beg_dt(sDate);
            }

            if (appInEmplCargo.getStrk_end_dt() == null
                    || appInEmplCargo.getStrk_end_dt().trim().length() == 0
                    || AppConstants.HIGH_TIMESTAMP
                    .equalsIgnoreCase(appInEmplCargo.getStrk_end_dt())
                    || AppConstants.HIGH_TIMESTAMP1
                    .equalsIgnoreCase(appInEmplCargo.getStrk_end_dt())) {
                appInEmplCargo.setStrk_end_dt(AppConstants.HIGH_DATE);
            } else {
                String sDate = appInEmplCargo.getStrk_end_dt();
                if (sDate.length() > 10) {
                    sDate = sDate.substring(0, 10);
                }
                appInEmplCargo.setStrk_end_dt(sDate);
            }

            if (appInEmplCargo.getJob_termination_reason() == null
                    || AppConstants.SELECT_DEFAULT_OPTION.equals(appInEmplCargo
                            .getJob_termination_reason())) {
                appInEmplCargo.setJob_termination_reason(null);
            }

            if (appInEmplCargo.getPay_freq_cd() == null
                    || AppConstants.SELECT_DEFAULT_OPTION.equals(appInEmplCargo
                            .getPay_freq_cd().trim())) {
                appInEmplCargo.setPay_freq_cd(null);
            }
            // EDSP RMB
            if (appInEmplCargo.getPay_day_week_cd() == null
                    || AppConstants.SELECT_DEFAULT_OPTION.equals(appInEmplCargo
                            .getPay_day_week_cd().trim())) {
                appInEmplCargo.setPay_day_week_cd(null);
            }

            // /job type and job temp additions PCR#32274

            if (appInEmplCargo.getTemp_job_ind() == null) {
                appInEmplCargo.setTemp_job_ind(FwConstants.SPACE);
            }

            if (appInEmplCargo.getPosn_typ_ind() == null) {
                appInEmplCargo.setPosn_typ_ind(FwConstants.SPACE);
            }

            if (appInEmplCargo.getRec_cplt_ind() == null) {
                appInEmplCargo.setRec_cplt_ind(FwConstants.ZERO);
            }

            final String indvSeqNum = String.valueOf(categorySeqDetailBean
                    .getIndividualSequence());
            String sourceAppIndicator = null;
            String recordInd = null;

            // now we are checking for the before collection
            long empSeqNum = 0;
            boolean empDetailsUpdate = false;

            if (beforeCollAppInEmplColl != null
                    && !beforeCollAppInEmplColl.isEmpty()) {
                final int size = beforeCollAppInEmplColl.size();
                empSeqNum = categorySeqDetailBean.getCategorySequence();
                if (size > 1) {
                    // if we have two records means cw and rm
                    // now we are getting RM record to compare
                    // now we need to update the data base if it dirty
                    sourceAppIndicator = AppConstants.RMC_MODIFIED_RECORD_IND;
                    recordInd = FwConstants.ROWACTION_UPDATE;
                    beforeEmplCargo = splitEmplColl(beforeCollAppInEmplColl,
                            sourceAppIndicator);
                    if (beforeEmplCargo == null) {
                        sourceAppIndicator = AppConstants.RMC_END_RECORD_IND;
                        recordInd = FwConstants.ROWACTION_UPDATE;
                        beforeEmplCargo = splitEmplColl(
                                beforeCollAppInEmplColl, sourceAppIndicator);
                    }

                } else {
                    // now we are checking this record is CW or RN
                    beforeEmplCargo = splitEmplColl(beforeCollAppInEmplColl,
                            AppConstants.CWW_RECORD_IND);
                    if (beforeEmplCargo != null) {
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
                        beforeEmplCargo = splitEmplColl(
                                beforeCollAppInEmplColl, sourceAppIndicator);
                    }
                }
                if(beforeEmplCargo != null){
                	if (AppConstants.EMPL_INKIND.equals(categorySeqDetailBean
                            .getCategoryType())) {
                        if (beforeEmplCargo.getFst_payck_dt() == null
                                || beforeEmplCargo.getFst_payck_dt().trim()
                                .length() == 0
                                || AppConstants.HIGH_TIMESTAMP
                                .equalsIgnoreCase(beforeEmplCargo
                                        .getFst_payck_dt())
                                        || AppConstants.HIGH_TIMESTAMP1
                                        .equalsIgnoreCase(beforeEmplCargo
                                                .getFst_payck_dt())) {
                            appInEmplCargo.setFst_payck_dt(AppConstants.HIGH_DATE);
                        } else {
                            String sDate = beforeEmplCargo.getFst_payck_dt();
                            if (sDate.length() > 10) {
                                sDate = sDate.substring(0, 10);
                            }
                            appInEmplCargo.setFst_payck_dt(sDate);
                        }
                        if (beforeEmplCargo.getChg_eff_dt() == null
                                || beforeEmplCargo.getChg_eff_dt().trim().length() == 0) {
                            appInEmplCargo.setChg_eff_dt(AppConstants.HIGH_DATE);
                        } else {
                            appInEmplCargo.setChg_eff_dt(beforeEmplCargo
                                    .getChg_eff_dt());
                        }
                        if (beforeEmplCargo.getLast_payck_dt() == null
                                || beforeEmplCargo.getLast_payck_dt().trim()
                                .length() == 0
                                || AppConstants.HIGH_TIMESTAMP
                                .equalsIgnoreCase(beforeEmplCargo
                                        .getLast_payck_dt())
                                        || AppConstants.HIGH_TIMESTAMP1
                                        .equalsIgnoreCase(beforeEmplCargo
                                                .getLast_payck_dt())) {
                            appInEmplCargo.setLast_payck_dt(AppConstants.HIGH_DATE);
                        } else {
                            String sDate = beforeEmplCargo.getLast_payck_dt();
                            if (sDate.length() > 10) {
                                sDate = sDate.substring(0, 10);
                            }
                            appInEmplCargo.setLast_payck_dt(sDate);
                        }

                        if (beforeEmplCargo.getStrk_beg_dt() == null
                                || beforeEmplCargo.getStrk_beg_dt().trim().length() == 0
                                || AppConstants.HIGH_TIMESTAMP
                                .equalsIgnoreCase(beforeEmplCargo
                                        .getStrk_beg_dt())
                                        || AppConstants.HIGH_TIMESTAMP1
                                        .equalsIgnoreCase(beforeEmplCargo
                                                .getStrk_beg_dt())) {
                            appInEmplCargo.setStrk_beg_dt(AppConstants.HIGH_DATE);
                        } else {
                            String sDate = beforeEmplCargo.getStrk_beg_dt();
                            if (sDate.length() > 10) {
                                sDate = sDate.substring(0, 10);
                            }
                            appInEmplCargo.setStrk_beg_dt(sDate);
                        }
                        if (beforeEmplCargo.getStrk_end_dt() == null
                                || beforeEmplCargo.getStrk_end_dt().trim().length() == 0
                                || AppConstants.HIGH_TIMESTAMP
                                .equalsIgnoreCase(beforeEmplCargo
                                        .getStrk_end_dt())
                                        || AppConstants.HIGH_TIMESTAMP1
                                        .equalsIgnoreCase(beforeEmplCargo
                                                .getStrk_end_dt())) {
                            appInEmplCargo.setStrk_end_dt(AppConstants.HIGH_DATE);
                        } else {
                            String sDate = beforeEmplCargo.getStrk_end_dt();
                            if (sDate.length() > 10) {
                                sDate = sDate.substring(0, 10);
                            }
                            appInEmplCargo.setStrk_end_dt(sDate);
                        }
                    }
                	
                	 appInEmplCargo.setSrc_app_ind(beforeEmplCargo.getSrc_app_ind());
                     appInEmplCargo.setIndv_seq_num(beforeEmplCargo
                             .getIndv_seq_num());
                     appInEmplCargo.setEmpl_typ(beforeEmplCargo.getEmpl_typ());
                     if (!AppConstants.RMC_NEW_RECORD_IND
                             .equalsIgnoreCase(sourceAppIndicator)) {
                         appInEmplCargo.setEmpl_seq_num(beforeEmplCargo
                                 .getEmpl_seq_num());
                     }
                     appInEmplCargo.setRec_cplt_ind(beforeEmplCargo
                             .getRec_cplt_ind());
                     if (sourceAppIndicator == AppConstants.RMC_NEW_RECORD_IND
     						&& appInEmplCargo.getPast_job_ind() != null
     						&& (FwConstants.YES.equalsIgnoreCase(appInEmplCargo
     								.getPast_job_ind()) || "Yes"
     								.equalsIgnoreCase(appInEmplCargo
     										.getPast_job_ind()))) {

     					appInEmplCargo.setEmpl_typ(AppConstants.EMPLOYMENT_PAST);
     					appInEmplCargo.setEr_Typ(beforeEmplCargo.getEr_Typ());

     				}
                  // PCR 30727 - In Edit mode, end date is not populated from the
                     // screen. Hence populating it from beforeCargo.
                     if (sourceAppIndicator == AppConstants.RMC_MODIFIED_RECORD_IND
                             || sourceAppIndicator == AppConstants.RMC_END_RECORD_IND) {
                         appInEmplCargo.setEcp_id(beforeEmplCargo.getEcp_id());
                     }
                     if (AppConstants.RMC_END_RECORD_IND.equals(sourceAppIndicator)
                             || AppConstants.EMPL_BOTH_REG_INKD
                             .equals(appInEmplCargo.getEmpl_typ())
                             && AppConstants.EMPL_INKIND
                             .equals(categorySeqDetailBean.getCategoryType())) {
                         if (AppConstants.RMC_END_RECORD_IND
                                 .equals(sourceAppIndicator)
                                 && AppConstants.EMPL_BOTH_REG_INKD
                                 .equals(appInEmplCargo.getEmpl_typ())
                                 && AppConstants.EMPL_INKIND
                                 .equals(categorySeqDetailBean
                                         .getCategoryType())) {
                             // // Populating the end month
                             if (beforeEmplCargo.getEmpl_end_dt() == null
                                     || beforeEmplCargo.getEmpl_end_dt().trim()
                                     .length() == 0
                                     || AppConstants.HIGH_TIMESTAMP
                                     .equalsIgnoreCase(beforeEmplCargo
                                             .getEmpl_end_dt())
                                             || AppConstants.HIGH_TIMESTAMP1
                                             .equalsIgnoreCase(beforeEmplCargo
                                                     .getEmpl_end_dt())) {
                                 appInEmplCargo
                                 .setEmpl_end_dt(AppConstants.HIGH_DATE);
                             } else {
                                 String sDate = beforeEmplCargo.getEmpl_end_dt();
                                 if (sDate.length() > 10) {
                                     sDate = sDate.substring(0, 10);
                                 }
                                 appInEmplCargo.setEmpl_end_dt(sDate);
                             }
                             if (beforeEmplCargo.getIk_job_end_date() == null
                                     || beforeEmplCargo.getIk_job_end_date().trim()
                                     .length() == 0
                                     || AppConstants.HIGH_TIMESTAMP
                                     .equalsIgnoreCase(beforeEmplCargo
                                             .getIk_job_end_date())
                                             || AppConstants.HIGH_TIMESTAMP1
                                             .equalsIgnoreCase(beforeEmplCargo
                                                     .getIk_job_end_date())) {
                                 appInEmplCargo
                                 .setIk_job_end_date(AppConstants.HIGH_DATE);
                             } else {
                                 String sDate = beforeEmplCargo.getIk_job_end_date();
                                 if (sDate.length() > 10) {
                                     sDate = sDate.substring(0, 10);
                                 }
                                 appInEmplCargo.setIk_job_end_date(sDate);
                             }

                         }
                         appInEmplCargo.setEr_city_adr(beforeEmplCargo
                                 .getEr_city_adr());
                         appInEmplCargo.setEr_l1_adr(beforeEmplCargo.getEr_l1_adr());
                         appInEmplCargo.setEr_nam(beforeEmplCargo.getEr_nam());
                         appInEmplCargo.setEr_phn_num(beforeEmplCargo
                                 .getEr_phn_num());
                         appInEmplCargo.setEr_st_adr(beforeEmplCargo.getEr_st_adr());
                         appInEmplCargo.setEr_zip_adr(beforeEmplCargo
                                 .getEr_zip_adr());
                         appInEmplCargo.setEr_Typ(beforeEmplCargo.getEr_Typ());
                         if (beforeEmplCargo.getChg_eff_dt() == null
                                 || beforeEmplCargo.getChg_eff_dt().trim().length() == 0) {
                             appInEmplCargo.setChg_eff_dt(AppConstants.HIGH_DATE);
                         }

                         if (beforeEmplCargo.getFst_payck_dt() == null
                                 || beforeEmplCargo.getFst_payck_dt().trim()
                                 .length() == 0
                                 || AppConstants.HIGH_TIMESTAMP
                                 .equalsIgnoreCase(beforeEmplCargo
                                         .getFst_payck_dt())
                                         || AppConstants.HIGH_TIMESTAMP1
                                         .equalsIgnoreCase(beforeEmplCargo
                                                 .getFst_payck_dt())) {
                             appInEmplCargo.setFst_payck_dt(AppConstants.HIGH_DATE);
                         } else {
                             String sDate = beforeEmplCargo.getFst_payck_dt();
                             if (sDate.length() > 10) {
                                 sDate = sDate.substring(0, 10);
                             }
                             appInEmplCargo.setFst_payck_dt(sDate);
                         }
                         if (beforeEmplCargo.getStrk_beg_dt() == null
                                 || beforeEmplCargo.getStrk_beg_dt().trim().length() == 0
                                 || AppConstants.HIGH_TIMESTAMP
                                 .equalsIgnoreCase(beforeEmplCargo
                                         .getStrk_beg_dt())
                                         || AppConstants.HIGH_TIMESTAMP1
                                         .equalsIgnoreCase(beforeEmplCargo
                                                 .getStrk_beg_dt())) {
                             appInEmplCargo.setStrk_beg_dt(AppConstants.HIGH_DATE);
                         } else {
                             String sDate = beforeEmplCargo.getStrk_beg_dt();
                             if (sDate.length() > 10) {
                                 sDate = sDate.substring(0, 10);
                             }
                             appInEmplCargo.setStrk_beg_dt(sDate);
                         }

                         if (beforeEmplCargo.getStrk_end_dt() == null
                                 || beforeEmplCargo.getStrk_end_dt().trim().length() == 0
                                 || AppConstants.HIGH_TIMESTAMP
                                 .equalsIgnoreCase(beforeEmplCargo
                                         .getStrk_end_dt())
                                         || AppConstants.HIGH_TIMESTAMP1
                                         .equalsIgnoreCase(beforeEmplCargo
                                                 .getStrk_end_dt())) {
                             appInEmplCargo.setStrk_end_dt(AppConstants.HIGH_DATE);
                         } else {
                             String sDate = beforeEmplCargo.getStrk_end_dt();
                             if (sDate.length() > 10) {
                                 sDate = sDate.substring(0, 10);
                             }
                             appInEmplCargo.setStrk_end_dt(sDate);
                         }
                         appInEmplCargo.setTemp_job_ind(beforeEmplCargo
                                 .getTemp_job_ind());
                         appInEmplCargo.setPosn_typ_ind(beforeEmplCargo
                                 .getPosn_typ_ind());

                         appInEmplCargo.setOn_strike_sw(beforeEmplCargo
                                 .getOn_strike_sw());
                         appInEmplCargo.setExpected_to_cont_resp(beforeEmplCargo
                                 .getExpected_to_cont_resp());
                     }
                     
                     final String changeEffDate = appInEmplCargo.getChg_eff_dt();
                     if (appInEmplCargo.getGross_pay_amt() != null
                             && AppConstants.ON_FILE.equalsIgnoreCase(appInEmplCargo
                                     .getGross_pay_amt()))

                     {
                         appInEmplCargo.setGross_pay_amt(beforeEmplCargo
                                 .getGross_pay_amt());
                         if (modifiedFields.contains(appInEmplCargo
                                 .getIndv_seq_num()
                                 + "_"
                                 + appInEmplCargo.getSeq_num()
                                 + "_"
                                 + "gross_pay_amt")) {
                             modifiedFields.remove(appInEmplCargo.getIndv_seq_num()
                                     + "_" + appInEmplCargo.getSeq_num() + "_"
                                     + "gross_pay_amt");
                         }
                     } else {
                         if (!modifiedFields.contains(appInEmplCargo
                                 .getIndv_seq_num()
                                 + "_"
                                 + appInEmplCargo.getSeq_num()
                                 + "_"
                                 + "gross_pay_amt")) {
                             modifiedFields.add(appInEmplCargo.getIndv_seq_num()
                                     + "_" + appInEmplCargo.getSeq_num() + "_"
                                     + "gross_pay_amt");
                         }
                     }
                     if (appInEmplCargo.getHourly_pay_amt() != null
                             && AppConstants.ON_FILE.equalsIgnoreCase(appInEmplCargo
                                     .getHourly_pay_amt()))

                     {
                         appInEmplCargo.setHourly_pay_amt(beforeEmplCargo
                                 .getHourly_pay_amt());
                         if (modifiedFields.contains(appInEmplCargo
                                 .getIndv_seq_num()
                                 + "_"
                                 + appInEmplCargo.getSeq_num()
                                 + "_"
                                 + "hourly_pay_amt")) {
                             modifiedFields.remove(appInEmplCargo.getIndv_seq_num()
                                     + "_" + appInEmplCargo.getSeq_num() + "_"
                                     + "hourly_pay_amt");
                         }
                     } else {
                         if (!modifiedFields.contains(appInEmplCargo
                                 .getIndv_seq_num()
                                 + "_"
                                 + appInEmplCargo.getSeq_num()
                                 + "_"
                                 + "hourly_pay_amt")) {
                             modifiedFields.add(appInEmplCargo.getIndv_seq_num()
                                     + "_" + appInEmplCargo.getSeq_num() + "_"
                                     + "hourly_pay_amt");
                         }
                     }
                     appInEmplCargo = (APP_IN_EMPL_Cargo) isChanged(beforeEmplCargo,
                             appInEmplCargo);
                     appInEmplCargo.setChg_eff_dt(changeEffDate);
                     appInEmplCargo.setRec_cplt_ind(FwConstants.ONE);
                     appInEmplCargo.setSrc_app_ind(sourceAppIndicator);
                     appInEmplCargo.setEmpl_seq_num(beforeEmplCargo
                             .getEmpl_seq_num());
                     appInEmplCargo.setRowAction(recordInd);
                     if (appInEmplCargo.isDirty()) {
                         empDetailsUpdate = true;
                     }
                }// end of null check               
                
            } else {
                // if there is no before collection means this is new record
                sourceAppIndicator = AppConstants.RMC_NEW_RECORD_IND;
                appInEmplCargo
                .setIndv_seq_num(String.valueOf(categorySeqDetailBean
                        .getIndividualSequence()));
                // get the MAX seq number from data base
                empSeqNum = jobIncomeBO.getMaxEmplSeqNumber(appNumber,
                        indvSeqNum);
                empSeqNum = empSeqNum + 1;
                appInEmplCargo.setEmpl_seq_num(String.valueOf(empSeqNum));
                if (appInEmplCargo.getPast_job_ind() != null
                        && (FwConstants.YES.equalsIgnoreCase(appInEmplCargo
                                .getPast_job_ind()) || "Yes"
                                .equalsIgnoreCase(appInEmplCargo
                                        .getPast_job_ind()))) {
                    appInEmplCargo.setEmpl_typ(AppConstants.EMPLOYMENT_PAST);

                } else {
                    appInEmplCargo.setEmpl_typ(categorySeqDetailBean
                            .getCategoryType());
                }
                appInEmplCargo.setSrc_app_ind(sourceAppIndicator);
                recordInd = FwConstants.ROWACTION_INSERT;
                appInEmplCargo.setRowAction(recordInd);
                empDetailsUpdate = true;
                // insert into RMC_SELECTION_PROFILE using Common Mehod()
                categorySelectionProfileManager.updateSequence(
                        jobIncomeProfile, null,
                        categorySeqDetailBean.getIndividualSequence(),
                        empSeqNum, categorySeqDetailBean.getCategoryType());

            }

            final String backToMyAccess = (String) request
                    .get(AppConstants.BACK_TO_MY_ACCESS_BUTTON);

            if (backToMyAccess == null) {
                final String loopingQuestionResponse = (String) request
                        .get("inKindLoopingQuestion");
                final String loopingQuestionShown = (String) beforeColl
                        .get(AppConstants.SHOW_LOOPING_QUESTION);
                boolean isLoopingAnswered = false;
                if (loopingQuestionResponse != null) {
                    if (AppConstants.YES.equals(loopingQuestionResponse)
                            || AppConstants.NO.equals(loopingQuestionResponse)) {
                        isLoopingAnswered = true;
                    }
                }

                jobIncomeBO.validateInKindPageContents(appInEmplCargo,
                        firstName, userEndInd, catPage, peopleHandler,
                        pageMode, isLoopingAnswered, loopingQuestionShown);
            }

            if (checkBackToMyAccessSelected(request)
                    || jobIncomeBO.hasMessages()) {
                final String reqWarningMsgs = (String) request
                        .get(FwConstants.WARNING_MSG_DETAILS);
                if (!checkForWarningMesgs(reqWarningMsgs,
                        jobIncomeBO.getMessageList())) {
                    if (backToMyAccess == null) {
                        request.put(FwConstants.MESSAGE_LIST,
                                jobIncomeBO.getMessageList());
                    }

                    beforeColl.get(APP_IN_EMPL_COLLECTION_KEY);

                    if (appInEmplCargo.getPast_job_ind() != null
                            && FwConstants.YES.equals(appInEmplCargo
                                    .getPast_job_ind())) {
                        appInEmplCargo
                        .setEmpl_typ(AppConstants.EMPLOYMENT_PAST);
                    } else if (appInEmplCargo.getPast_job_ind() != null
                            && FwConstants.NO.equals(appInEmplCargo
                                    .getPast_job_ind())) {
                        appInEmplCargo.setEmpl_typ(AppConstants.EMPL_INKIND);
                    }
                    pageCollection.put(AppConstants.INKIND_EMPL_TYPE,
                            beforeColl.get(AppConstants.INKIND_EMPL_TYPE));
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
                    pageCollection.put("FST_EMPL", appInEmplCargo);
                    pageCollection.put(APP_IN_EMPL_COLLECTION_KEY,
                            appInEmplCollection);
                    pageCollection.put("END_PAGE_IND",
                            beforeColl.get("END_PAGE_IND"));
                    pageCollection
                    .put("PAGE_MODE", beforeColl.get("PAGE_MODE"));
                    return;
                }
            }

            // now we need to check the flags
            if (userEndInd == 0 && empDetailsUpdate) {
                // check for the change effective date
                // if they did't fill this one raise validation
                if (!AppConstants.RMC_NEW_RECORD_IND.equals(sourceAppIndicator)
                        && AppConstants.HIGH_DATE.equals(appInEmplCargo
                                .getChg_eff_dt())) {
                    // EDSP validation
                    if (jobIncomeBO.hasMessages()) {
                        final String reqWarningMsgs = (String) request
                                .get(FwConstants.WARNING_MSG_DETAILS);
                        if (!checkForWarningMesgs(reqWarningMsgs,
                                jobIncomeBO.getMessageList())) {
                            request.put(FwConstants.MESSAGE_LIST,
                                    jobIncomeBO.getMessageList());
                            pageCollection
                            .put(AppConstants.INKIND_EMPL_TYPE,
                                    beforeColl
                                    .get(AppConstants.INKIND_EMPL_TYPE));
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
                            pageCollection.put("FST_EMPL", appInEmplCargo);
                            pageCollection.put("END_PAGE_IND",
                                    beforeColl.get("END_PAGE_IND"));
                            return;
                        }
                    }
                }
            }

            if (appInEmplCargo.getNext_paycheck_dt() == null
                    || appInEmplCargo.getNext_paycheck_dt().trim().length() == 0
                    || AppConstants.HIGH_DATE.equals(appInEmplCargo
                            .getNext_paycheck_dt())) {
                appInEmplCargo.setNext_paycheck_dt(AppConstants.HIGH_DATE);
            } else {
                final StringBuilder dateConverter = new StringBuilder();
                final String sAppDate = appInEmplCargo.getNext_paycheck_dt();
                dateConverter.append(sAppDate.substring(6, 10)).append("-")
                .append(sAppDate.substring(0, 2)).append("-")
                .append(sAppDate.substring(3, 5));
                appInEmplCargo.setNext_paycheck_dt(dateConverter.toString());
            }

            if (appInEmplCargo.getEmpl_beg_dt() != null
                    && appInEmplCargo.getEmpl_beg_dt().trim().length() != 0
                    && appInEmplCargo.getEmpl_beg_dt().length() == 10
                    && appInEmplCargo.getEmpl_beg_dt().charAt(2) == '/'

                    ) {
                final StringBuilder dateConverter = new StringBuilder();
                final String sAppDate = appInEmplCargo.getEmpl_beg_dt();
                dateConverter.append(sAppDate.substring(6, 10)).append("-")
                .append(sAppDate.substring(0, 2)).append("-")
                .append(sAppDate.substring(3, 5));
                appInEmplCargo.setEmpl_beg_dt(dateConverter.toString());
            }

            if (appInEmplCargo.getFst_payck_dt() != null
                    && appInEmplCargo.getFst_payck_dt().trim().length() != 0
                    && appInEmplCargo.getFst_payck_dt().length() == 10
                    && appInEmplCargo.getFst_payck_dt().charAt(2) == '/'

                    ) {
                final StringBuilder dateConverter = new StringBuilder();
                final String sAppDate = appInEmplCargo.getFst_payck_dt();
                dateConverter.append(sAppDate.substring(6, 10)).append("-")
                .append(sAppDate.substring(0, 2)).append("-")
                .append(sAppDate.substring(3, 5));
                appInEmplCargo.setFst_payck_dt(dateConverter.toString());
            }

            if (appInEmplCargo.getEmpl_end_dt() != null
                    && appInEmplCargo.getEmpl_end_dt().trim().length() != 0
                    && appInEmplCargo.getEmpl_end_dt().length() == 10
                    && appInEmplCargo.getEmpl_end_dt().charAt(2) == '/'

                    ) {
                final StringBuilder dateConverter = new StringBuilder();
                final String sAppDate = appInEmplCargo.getEmpl_end_dt();
                dateConverter.append(sAppDate.substring(6, 10)).append("-")
                .append(sAppDate.substring(0, 2)).append("-")
                .append(sAppDate.substring(3, 5));
                appInEmplCargo.setEmpl_end_dt(dateConverter.toString());
            }

            if (appInEmplCargo.getLast_payck_dt() != null
                    && appInEmplCargo.getLast_payck_dt().trim().length() != 0
                    && appInEmplCargo.getLast_payck_dt().length() == 10
                    && appInEmplCargo.getLast_payck_dt().charAt(2) == '/'

                    ) {
                final StringBuilder dateConverter = new StringBuilder();
                final String sAppDate = appInEmplCargo.getLast_payck_dt();
                dateConverter.append(sAppDate.substring(6, 10)).append("-")
                .append(sAppDate.substring(0, 2)).append("-")
                .append(sAppDate.substring(3, 5));
                appInEmplCargo.setLast_payck_dt(dateConverter.toString());
            }
            if (appInEmplCargo.getIk_job_start_date() != null
                    && appInEmplCargo.getIk_job_start_date().trim().length() != 0
                    && appInEmplCargo.getIk_job_start_date().length() == 10
                    && appInEmplCargo.getIk_job_start_date().charAt(2) == '/'

                    ) {
                final StringBuilder dateConverter = new StringBuilder();
                final String sAppDate = appInEmplCargo.getIk_job_start_date();
                dateConverter.append(sAppDate.substring(6, 10)).append("-")
                .append(sAppDate.substring(0, 2)).append("-")
                .append(sAppDate.substring(3, 5));
                appInEmplCargo.setIk_job_start_date(dateConverter.toString());
            }

            if (appInEmplCargo.getIk_job_end_date() != null
                    && appInEmplCargo.getIk_job_end_date().trim().length() != 0
                    && appInEmplCargo.getIk_job_end_date().length() == 10
                    && appInEmplCargo.getIk_job_end_date().charAt(2) == '/'

                    ) {
                final StringBuilder dateConverter = new StringBuilder();
                final String sAppDate = appInEmplCargo.getIk_job_end_date();
                dateConverter.append(sAppDate.substring(6, 10)).append("-")
                .append(sAppDate.substring(0, 2)).append("-")
                .append(sAppDate.substring(3, 5));
                appInEmplCargo.setIk_job_end_date(dateConverter.toString());
            }
            if (empDetailsUpdate) {
                if (FwConstants.ROWACTION_INSERT.equals(appInEmplCargo
                        .getRowAction())) {
                    jobIncomeBO.insertExistingDetails(appInEmplCollection);
                } else {
                    jobIncomeBO.storeDetails(appInEmplCollection);
                }
            }

            final int[] driverArray = (int[]) session
                    .get(FwConstants.RMC_DRIVER);
            boolean loopingQuestion = false;
            if (appInEmplCargo.getIk_loopingInd() != null
                    && FwConstants.YES.equalsIgnoreCase(appInEmplCargo
                            .getIk_loopingInd())) {
                loopingQuestion = true;
                // Insert into APP_IN_EMPL and APP_IN_EMPL_A_WAGE
                categorySelectionProfileManager.insertSequenceDetail(
                        jobIncomeProfile, null, null,
                        categorySeqDetailBean.getIndividualSequence(),
                        categorySeqDetailBean.getCategoryType());
                driverManager.makeRequired(FwConstants.RMC_DRIVER,
                        currentPageID, driverArray, appNumber);

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
                    rmcResponseProfileManager
                    .makeComplete(
                            rmcResponseProfileManager
                            .getResponseByType(
                                    IRMCResponseProfileManager.EMPLOYMENT_DETAILS,
                                    categorySeqDetailBean
                                    .getCategoryType()),
                                    rmcInPrflCargo, true);
                }
            }
            // Mark complete job sequence using common methods
            categorySelectionProfileManager.makeSequenceDetailComplete(
                    jobIncomeProfile, null,
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
                    .areAllSequencesComplete(jobIncomeProfile)) {
                driverManager.makeComplete(FwConstants.RMC_DRIVER,
                        currentPageID, driverArray, appNumber);
            } else {
                categorySelectionProfileManager
                .getNextSequenceDetail(jobIncomeProfile);
            }

        } catch (final FwException fe) {
            log(ILog.ERROR, fe.getMessage());
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("storeInkindDetails");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "storeInkindDetails", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.storeInkindDetails() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Load Method for Job Income Summary.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */
    public void loadJobIncomeSummary(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.loadJobIncomeSummary() - START");
        try {
            APP_IN_EMPL_Collection appInEmplColl = null;
            //APP_IN_EMPL_HEALTH_Collection appInEmplHlthColl = null;
            APP_IN_EMPL_A_WAGE_Collection appInEmplAWageColl = null;
            final Map session = txnBean.getSession();
            final Map pageCollection = txnBean.getPageCollection();
            final Map request = txnBean.getRequest();
            final String appType = (String) session
                    .get(FwConstants.ACCESS_APPLICATION_TYPE);
            // Get App Number
            final String appNum = (String) session.get(AppConstants.APP_NUMBER);
            final int[] driverArray = (int[]) session
                    .get(FwConstants.RMC_DRIVER);
            final int driverStatus = driverManager.getAFBStatus(
                    FwConstants.RMC_DRIVER,
                    (String) request.get(FwConstants.CURRENT_PAGE_ID),
                    driverArray);

            SortedSet selectionProfile = (SortedSet) session
                    .get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);

            boolean loadCatSelProfile = false;
            if ((selectionProfile == null || selectionProfile.isEmpty())
                    && driverStatus != FwConstants.DRIVER_NOT_REQUIRED) {
                // load selection profile form the data base
                loadCatSelProfile = true;
            } else if (selectionProfile != null && !selectionProfile.isEmpty()) {
                // here we need to check the session profile is job income
                // session profile
                CategorySequenceDetail catSeqDetail = categorySelectionProfileManager
                        .getCurrentSequenceDetail(selectionProfile);
                if (catSeqDetail == null) {
                    catSeqDetail = categorySelectionProfileManager
                            .getNextSequenceDetail(selectionProfile);
                    if (catSeqDetail != null
                            && AppConstants.RMC_CAT_EMP_PRFL
                            .equals(catSeqDetail
                                    .getChangeSelectionCategoryCd())) {
                        loadCatSelProfile = false;
                    } else {
                        loadCatSelProfile = true;
                    }
                }
            }
            // now loading the cat selection profile form the data base
            if (loadCatSelProfile) {
                selectionProfile = categorySelectionProfileManager
                        .loadCategoryChangeSelectionProfile(appNum,
                                AppConstants.RMC_CAT_EMP_PRFL);
            }
            categorySelectionProfileManager
            .resetCurrentSeqeunceDetail(selectionProfile);
            final JobIncomeBO jobBo = new JobIncomeBO();
            appInEmplColl = jobBo.getAppInEmplDetails(appNum);
            appInEmplAWageColl = jobBo.getAppInAWageDetails(appNum);

            // Getting language from http session
            final Map httpSessionMap = (Map) session
                    .get(FwConstants.HTTP_SESSION);
            String language = FwConstants.ENGLISH;
            if (httpSessionMap.get(FwConstants.LANGUAGE) != null) {
                language = (String) httpSessionMap.get(FwConstants.LANGUAGE);
            }
            final APP_IN_EMPL_Collection appInEmplJobColl = new APP_IN_EMPL_Collection();
            final APP_IN_EMPL_Collection appInEmplInKindColl = new APP_IN_EMPL_Collection();
            final int sizeJobCustColl = appInEmplColl.size();
            String newOrModifiedExists = FwConstants.NO;
            for (int i = 0; i < sizeJobCustColl; i++) {

                APP_IN_EMPL_Cargo jobEmplCargo = new APP_IN_EMPL_Cargo();
                jobEmplCargo = appInEmplColl.getCargo(i);
                if (!AppConstants.EMPL_INKIND
                        .equals(jobEmplCargo.getEmpl_typ())) {
                    appInEmplJobColl.addCargo(jobEmplCargo);
                }
                if (AppConstants.EMPL_INKIND.equals(jobEmplCargo.getEmpl_typ())
                        || "X".equals(jobEmplCargo.getEmpl_typ())) {
                    appInEmplInKindColl.addCargo(jobEmplCargo);
                }
                if (FwConstants.NO.equals(newOrModifiedExists)) {
                    if (AppConstants.RMC_NEW_RECORD_IND.equals(jobEmplCargo
                            .getSrc_app_ind())
                            || AppConstants.RMC_MODIFIED_RECORD_IND
                            .equals(jobEmplCargo.getSrc_app_ind())) {
                        newOrModifiedExists = FwConstants.YES;
                    }
                }
            }
            // Get Self Employment Collection
            final SelfEmploymentBO selfBO = new SelfEmploymentBO();
            final APP_IN_SELFE_Collection selfEColl = selfBO
                    .loadSelfEmploymentDetails(appNum);
            // logic for newOrModifiedExists
            final int sizeSelfECustColl = selfEColl.size();
            if (FwConstants.NO.equals(newOrModifiedExists)) {
                for (int i = 0; i < sizeSelfECustColl; i++) {
                    APP_IN_SELFE_Cargo selfEmplCargo = new APP_IN_SELFE_Cargo();
                    selfEmplCargo = selfEColl.getCargo(i);
                    if (AppConstants.RMC_NEW_RECORD_IND.equals(selfEmplCargo
                            .getSrc_app_ind())
                            || AppConstants.RMC_MODIFIED_RECORD_IND
                            .equals(selfEmplCargo.getSrc_app_ind())) {
                        newOrModifiedExists = FwConstants.YES;
                    }
                }
            }

            final RMCJobIncomeSummaryJobIncomeListView rmcJobIncomeSummaryListView = new RMCJobIncomeSummaryJobIncomeListView();
            //final RMCJobIncomeSummaryHealthInsListView rmcJobIncomeSummaryHealthInsListView = new RMCJobIncomeSummaryHealthInsListView();
            final RMCJobIncomeSummarySelfEmploymentListView rmcJobIncomeSummarySelfEListView = new RMCJobIncomeSummarySelfEmploymentListView();

            rmcJobIncomeSummaryListView.setEmplCollection(appInEmplColl);
            rmcJobIncomeSummaryListView.setWageCollection(appInEmplAWageColl);

            /*appInEmplHlthColl = jobBo.getAppInEmplHlthInsDetails(appNum);
            rmcJobIncomeSummaryHealthInsListView
            .setEmplHlthCollection(appInEmplHlthColl);*/

            rmcJobIncomeSummarySelfEListView.setAppInSelfECollection(selfEColl);

            rmcJobIncomeSummaryListView.setAppType(appType);
            //rmcJobIncomeSummaryHealthInsListView.setAppType(appType);
            rmcJobIncomeSummarySelfEListView.setAppType(appType);

            // Put into session of these two collections
            pageCollection.put("APP_IN_EMPL_JOB_Collection", appInEmplJobColl);
            pageCollection.put("APP_IN_EMPL_INKIND_Collection",
                    appInEmplInKindColl);
            pageCollection.put("APP_IN_SELF_EMPL_Collection", selfEColl);
            pageCollection.put("NEW_OR_MOD_EXISTS", newOrModifiedExists);

            // Preparing listView for Job Income selection
            rmcJobIncomeSummaryListView.setLanguage(language);
            rmcJobIncomeSummaryListView.setName("INCOME_SELECTION_LISTVIEW");
            rmcJobIncomeSummaryListView.setDisplayData(appInEmplJobColl);
            rmcJobIncomeSummaryListView.setPageSize(1000);

            // Preparing listView for Job Income selection
            /*rmcJobIncomeSummaryHealthInsListView.setLanguage(language);
            rmcJobIncomeSummaryHealthInsListView
            .setName("HEALTH_SELECTION_LISTVIEW");
            rmcJobIncomeSummaryHealthInsListView
            .setDisplayData(appInEmplHlthColl);
            rmcJobIncomeSummaryHealthInsListView.setPageSize(1000);*/

            // Preparing listView for Self Employment selection
            rmcJobIncomeSummarySelfEListView.setLanguage(language);
            rmcJobIncomeSummarySelfEListView
            .setName("SELF_EMPL_SELECTION_LISTVIEW");
            rmcJobIncomeSummarySelfEListView.setDisplayData(selfEColl);
            rmcJobIncomeSummarySelfEListView.setPageSize(1000);

            // PCR 30690 - To show only in home individuals in the dropdowns.
            final PeopleHandler peopleHandler = (PeopleHandler) session
                    .get(AppConstants.INDIV_MASTER_HANDLER);
            pageCollection.put("PEOPLE_5047",
                    peopleHandler.getInHomeIndividuals());

            // Populating pageCollection with respective response maps
            pageCollection.put("INCOME_SELECTION_LISTVIEW",
                    rmcJobIncomeSummaryListView);
            /*pageCollection.put("HEALTH_SELECTION_LISTVIEW",
                    rmcJobIncomeSummaryHealthInsListView);*/
            pageCollection.put("SELF_EMPL_SELECTION_LISTVIEW",
                    rmcJobIncomeSummarySelfEListView);

            // set pageCollection into transaction Bean
            txnBean.setPageCollection(pageCollection);

            session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER,
                    selectionProfile);
            // set before collection to pageCollection
            session.put(FwConstants.BEFORE_COLLECTION, pageCollection);
            txnBean.setSession(session);

            log(ILog.INFO, "RMCJobIncomeEJBBean::loadJobIncomeSummary:End");
        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("loadJobIncomeSummary");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "loadJobIncomeSummary", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.loadJobIncomeSummary() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Save Job Income Summary Next page Logic nextJobIncomeSummary().
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */
    public void nextJobIncomeSummary(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.nextJobIncomeSummary() - START");
        try {
            log(ILog.INFO, "RMCJobIncomeEJBBean::nextJobIncomeSummary:Start");
            final Map session = txnBean.getSession();
            final Map request = txnBean.getRequest();
            final String currentPageID = (String) request
                    .get(FwConstants.CURRENT_PAGE_ID);
            final int[] driverArray = (int[]) session
                    .get(FwConstants.RMC_DRIVER);
            // Get App Number
            final String appNum = (String) session.get(AppConstants.APP_NUMBER);
            final PeopleHandler peopleHandler = (PeopleHandler) session
                    .get(AppConstants.INDIV_MASTER_HANDLER);
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

            // change indicators
            final JobIncomeBO jobIncomeBo = new JobIncomeBO();
            final APP_IN_EMPL_Collection modifiedIkiCollection = jobIncomeBo
                    .loadInKindCollection(appNum);
            final APP_IN_SELFE_Collection modifiedSelfEMployementCollection = jobIncomeBo
                    .loadSelfEmplCollection(appNum);
            final APP_IN_EMPL_Collection modifiedEMploymentCollection = jobIncomeBo
                    .loadEmploymentCollection(appNum);

            final RMC_IN_PRFL_Collection rmcInPrflSessColl = (RMC_IN_PRFL_Collection) session
                    .get(AppConstants.RMC_IN_PRFL_MASTER);

            final short[] questionsIndicators = new short[3];
            questionsIndicators[0] = IRMCResponseProfileManager.EMPL_CHG_IND;
            questionsIndicators[1] = IRMCResponseProfileManager.SELF_EMPL_CHG_IND;
            questionsIndicators[2] = IRMCResponseProfileManager.EI_CHG_IND;

            String[] indivResponseIndForIndv = null;
            final Map indivResponseIndIndv = new HashMap();

            for (int j = 0; j < rmcInPrflSessColl.size(); j++) {
                indivResponseIndForIndv = new String[3];
                indivResponseIndForIndv[0] = AppConstants.NO;
                indivResponseIndForIndv[1] = AppConstants.NO;
                indivResponseIndForIndv[2] = AppConstants.NO;

                final RMC_IN_PRFL_Cargo sessionCargo = rmcInPrflSessColl
                        .getCargo(j);

                if (modifiedIkiCollection != null
                        && !modifiedIkiCollection.isEmpty()) {
                    for (int i = 0; i < modifiedIkiCollection.size(); i++) {
                        final APP_IN_EMPL_Cargo modifiedCargo = (APP_IN_EMPL_Cargo) modifiedIkiCollection
                                .get(i);

                        if (sessionCargo.getIndv_seq_num().equals(
                                modifiedCargo.getIndv_seq_num())) {
                            sessionCargo.setEi_chg_ind(AppConstants.YES);
                            indivResponseIndForIndv[0] = AppConstants.YES;
                        }
                        indivResponseIndIndv.put(
                                sessionCargo.getIndv_seq_num(),
                                indivResponseIndForIndv);
                    }

                }

                if (modifiedSelfEMployementCollection != null
                        && !modifiedSelfEMployementCollection.isEmpty()) {
                    for (int i = 0; i < modifiedSelfEMployementCollection
                            .size(); i++) {
                        final APP_IN_SELFE_Cargo modifiedCargo = (APP_IN_SELFE_Cargo) modifiedSelfEMployementCollection
                                .get(i);

                        if (sessionCargo.getIndv_seq_num().equals(
                                modifiedCargo.getIndv_seq_num())) {
                            sessionCargo.setSelf_empl_chg_ind(AppConstants.YES);
                            indivResponseIndForIndv[1] = AppConstants.YES;
                        }
                        indivResponseIndIndv.put(
                                sessionCargo.getIndv_seq_num(),
                                indivResponseIndForIndv);
                    }

                }
                if (modifiedEMploymentCollection != null
                        && !modifiedEMploymentCollection.isEmpty()) {
                    for (int i = 0; i < modifiedEMploymentCollection.size(); i++) {
                        final APP_IN_EMPL_Cargo modifiedCargo = (APP_IN_EMPL_Cargo) modifiedEMploymentCollection
                                .get(i);

                        if (sessionCargo.getIndv_seq_num().equals(
                                modifiedCargo.getIndv_seq_num())) {
                            sessionCargo.setEmpl_chg_ind(AppConstants.YES);
                            indivResponseIndForIndv[2] = AppConstants.YES;
                        }
                        indivResponseIndIndv.put(
                                sessionCargo.getIndv_seq_num(),
                                indivResponseIndForIndv);
                    }

                }
                indivResponseIndIndv.put(sessionCargo.getIndv_seq_num(),
                        indivResponseIndForIndv);
            }

            for (int i = 0; i < rmcInPrflSessColl.size(); i++) {
                final RMC_IN_PRFL_Cargo sessionCargo = rmcInPrflSessColl
                        .getCargo(i);
                rmcResponseProfileManager.persist(appNum, sessionCargo
                        .getIndv_seq_num(), questionsIndicators,
                        (String[]) indivResponseIndIndv.get(sessionCargo
                                .getIndv_seq_num()));
            }

            // Set RMC page Job Income Details make required
            driverManager.makeComplete(FwConstants.RMC_DRIVER, currentPageID,
                    driverArray, appNum);
            
            // logic to schedule Employment health insurance screen using category sequence.
            
            // Needs to be a Medicaid program to schedule Employer Offer Health Coverage
			boolean maFlag = false;
			short[] pgmKey = (short[]) session
			.get(FwConstants.RMC_PROGRAM_KEY);
			
			if (pgmKey[0] == 1) {
				maFlag = true;
			}
            
            ABFinalSubmitBO finalSubmitBO = new ABFinalSubmitBO();
			double emplTotalGrossIncome = finalSubmitBO.loadEmplDetailGrossAmtRMB(appNum);
			double selfEmplIncome = finalSubmitBO.loadSelfEmplDetailsRMB(appNum);
			double totalHRIncome = finalSubmitBO.loadEmplDetailGrossHRAmtRMB(appNum);
			double totalUnearnedIncome = finalSubmitBO.loadotherIncomeDetailsRMB(appNum);
			double totalncome = emplTotalGrossIncome + selfEmplIncome + totalHRIncome + totalUnearnedIncome;
			
			ABJobIncomeBO jobIncomeBO = new ABJobIncomeBO();
			double mfplIncome = jobIncomeBO.calculateMFPL(peopleHandler.getNumberOfIndividuals());
            
            final JobIncomeBO jobBO = new JobIncomeBO();
            APP_IN_EMPL_Collection jobColl = jobBO.loadDetails(appNum);
            boolean isEmpInsPageReq = false; 
            SortedSet catprofileDB = categorySelectionProfileManager.loadCategoryChangeSelectionProfile(appNum);
            for(Object o : jobColl){
            	APP_IN_EMPL_Cargo cargo = (APP_IN_EMPL_Cargo) o;
            	if(maFlag && cargo.getSrc_app_ind()!= null &&( cargo.getSrc_app_ind().equalsIgnoreCase(AppConstants.RMC_NEW_RECORD_IND)
            			|| cargo.getSrc_app_ind().equalsIgnoreCase(AppConstants.RMC_MODIFIED_RECORD_IND))
            			&& totalncome > mfplIncome){
            		
                    
                	if(null != categorySelectionProfileManager.getCategorySequenceDetail(catprofileDB, Short.parseShort(cargo.getIndv_seq_num()), Short.parseShort(cargo.getSeq_num()), AppConstants.EMPL_HLTH_INS)){
                		categorySelectionProfileManager.makeSequenceDetailRequired(catprofileDB, appNum, Short.parseShort(cargo.getIndv_seq_num()), Short.parseShort(cargo.getSeq_num()), AppConstants.EMPL_HLTH_INS);
                	}else{
                		categorySelectionProfileManager.insertSequenceDetail(catprofileDB,
                				appNum,
                				AppConstants.EMPL_HLTH_INS, 
                				Short.parseShort(cargo.getIndv_seq_num()),
                				Short.parseShort(cargo.getSeq_num()), 
                				AppConstants.EMPL_HLTH_INS , 
                				Short.parseShort("0"));
                	}
                	final String HlthCovPageStatus = driverManager.getStatus(FwConstants.RMC_DRIVER, "AREHI", driverArray);
                	if (null != HlthCovPageStatus && !AppConstants.COMPLETE.equalsIgnoreCase(HlthCovPageStatus)) {
                		driverManager.makeRequired(FwConstants.RMC_DRIVER, "AREHI", driverArray, appNum);
                		isEmpInsPageReq = true;
                	}
                    
            	} else {
            		if(null != categorySelectionProfileManager.getCategorySequenceDetail(catprofileDB, Short.parseShort(cargo.getIndv_seq_num()), Short.parseShort(cargo.getSeq_num()), AppConstants.EMPL_HLTH_INS)){
                		categorySelectionProfileManager.removeSequenceDetail(catprofileDB, appNum, Short.parseShort(cargo.getIndv_seq_num()), Short.parseShort(cargo.getSeq_num()), AppConstants.EMPL_HLTH_INS, AppConstants.EMPL_HLTH_INS);
                		jobBO.eraseEmpIns(cargo.getApp_num(), cargo.getIndv_seq_num(),cargo.getSrc_app_ind());
                	}
                	if(!isEmpInsPageReq){
                		final String HlthCovPageStatus = driverManager.getStatus(FwConstants.RMC_DRIVER, "AREHI", driverArray);
                		if (null != HlthCovPageStatus && !AppConstants.COMPLETE.equalsIgnoreCase(HlthCovPageStatus)) {
                			driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
                    				"AREHI", driverArray, appNum);
                		}
                		
                	}
            	}
            }

            
            session.put(FwConstants.RMC_DRIVER, driverArray);
            // End
            log(ILog.INFO, "RMCJobIncomeEJBBean::nextJobIncomeSummary:End");
        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("nextJobIncomeSummary");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "nextJobIncomeSummary", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.nextJobIncomeSummary() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Edit Logic for Job Income summary editJobIncome().
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */
    public void editJobIncome(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.editJobIncome() - START");
        try {
            log(ILog.INFO, "RMCJobIncomeEJBBean::editJobIncome:Start");
            final Map session = txnBean.getSession();
            final Map pageCollection = txnBean.getPageCollection();
            // Get driver info.
            final int[] driverArray = (int[]) session
                    .get(FwConstants.RMC_DRIVER);
            // Get the APP_IN_EMPL_Collection from pageCollection.
            final JOBINCOME_Custom_Collection jobIncColl = (JOBINCOME_Custom_Collection) pageCollection
                    .get("JOBINCOME_Custom_Collection");
            final JOBINCOME_Custom_Cargo jobInCargo = jobIncColl.getResult(0);

            final IndivTypeSeqBean seqBean = new IndivTypeSeqBean();
            seqBean.setIndivSeqNum(jobInCargo.getIndv_seq_num());
            seqBean.setSeqNum(jobInCargo.getEmpl_seq_num());
            seqBean.setType(jobInCargo.getEmpl_typ());
            if ("RE".equals(jobInCargo.getSrc_app_ind())) {
				seqBean.setUserEndInd(FwConstants.ONE);
			} else {
				seqBean.setUserEndInd(FwConstants.ZERO);
			}
            pageCollection.put(FwConstants.DETAIL_KEY_BEAN, seqBean);
            // Get App Number
            final String appNum = (String) session.get(AppConstants.APP_NUMBER);
            // Set RMC page Job Income Details make required
            driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARJID",
                    driverArray, appNum);
            driverManager.makeRequired(FwConstants.RMC_DRIVER,
                    AppConstants.ARJIS, driverArray, appNum);
            // End
            log(ILog.INFO, "RMCJobIncomeEJBBean::editJobIncome:End");
        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("editJobIncome");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "editJobIncome", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.editJobIncome() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Edits the health insurance income.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */
    public void editHealthInsuranceIncome(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO,
                "RMCJobIncomeEJBBean.editHealthInsuranceIncome() - START");
        try {
            log(ILog.INFO, "RMCJobIncomeEJBBean::editHealthInsuranceIncome");
            final Map session = txnBean.getSession();
            final Map pageCollection = txnBean.getPageCollection();
            // Get driver info.
            final int[] driverArray = (int[]) session
                    .get(FwConstants.RMC_DRIVER);
            // Get the APP_IN_EMPL_HEALTH_Collection from pageCollection.
            final APP_IN_EMPL_HEALTH_Collection healthInsIncColl = (APP_IN_EMPL_HEALTH_Collection) pageCollection
                    .get("APP_IN_EMPL_HEALTH_Collection");
            final APP_IN_EMPL_HEALTH_Cargo healthInsInCargo = healthInsIncColl
                    .getResult(0);

            final IndivTypeSeqBean seqBean = new IndivTypeSeqBean();
            seqBean.setIndivSeqNum(healthInsInCargo.getIndv_seq_num());
            seqBean.setSeqNum(healthInsInCargo.getSeq_num());
            seqBean.setType(AppConstants.EMPL_HLTH_INS);
            seqBean.setUserEndInd("0");
            
            pageCollection.put(FwConstants.DETAIL_KEY_BEAN, seqBean);
            // Get App Number
            final String appNum = (String) session.get(AppConstants.APP_NUMBER);
//             Set RMC page Health Insurance Income Details make required
            driverManager.makeRequired(FwConstants.RMC_DRIVER,
                    AppConstants.AREHI, driverArray, appNum);
            driverManager.makeRequired(FwConstants.RMC_DRIVER,
                    AppConstants.ARJIS, driverArray, appNum);
            // End
            log(ILog.INFO, "RMCJobIncomeEJBBean::editHealthInsuranceIncome");
        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("editHealthInsuranceIncome");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "editHealthInsuranceIncome", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.editHealthInsuranceIncome() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Comment here.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */
    public void eraseHealthInsuranceIncome(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO,
                "RMCJobIncomeEJBBean.eraseHealthInsuranceIncome() - START");
        try {
            log(ILog.INFO, "RMCJobIncomeEJBBean::eraseHealthInsuranceIncome");
            final Map session = txnBean.getSession();
            txnBean.getRequest();
            final Map pageCollection = txnBean.getPageCollection();
            final Map beforeColl = (Map) session
                    .get(FwConstants.BEFORE_COLLECTION);

            // Get RMCSessionBean from the session

            // Define IndvSeqNum and the SeqNum and Type and RowNum
            String indvSeqNum = null;

            // Get driver info.
            final int[] driverArray = (int[]) session
                    .get(FwConstants.RMC_DRIVER);

            // Get the APP_IN_EMPL_Collection from pageCollection.
            final APP_IN_EMPL_HEALTH_Collection healthInsIncColl = (APP_IN_EMPL_HEALTH_Collection) pageCollection
                    .get("APP_IN_EMPL_HEALTH_Collection");
            final APP_IN_EMPL_HEALTH_Cargo healthInsInCargo = healthInsIncColl
                    .getResult(0);

            // Get the results from the APP_IN_EMPL_Collection
            final String appNum = (String) session.get(AppConstants.APP_NUMBER);

            // delete record from rmc selection profile
            final SortedSet rmcSelPrfl = (SortedSet) session
                    .get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
            final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
                    .get(AppConstants.RMC_IN_PRFL_MASTER);

            indvSeqNum = healthInsInCargo.getIndv_seq_num();
            beforeColl.get("APP_IN_EMPL_HEALTH_Cargo");

            final IndivTypeSeqBean indivTypeSeqBean = new IndivTypeSeqBean();
            indivTypeSeqBean.setIndivSeqNum(indvSeqNum);
            final IndivTypeSeqBean postIndivSeqBean = (IndivTypeSeqBean) beforeColl
                    .get(AppConstants.INDV_TYPE_SEQ_BEAN);
            if (postIndivSeqBean != null) {
                if (postIndivSeqBean.getIndivSeqNum().equals(
                        indivTypeSeqBean.getIndivSeqNum())
                        && postIndivSeqBean.getSeqNum().equals(
                                indivTypeSeqBean.getSeqNum())
                                && postIndivSeqBean.getType().equals(
                                        indivTypeSeqBean.getType())) {
                }
            }

            final Map catType = new HashMap();
            catType.put(AppConstants.EMPL_REGULAR, AppConstants.EMPL_REGULAR);
            catType.put(AppConstants.EMPL_INKIND, AppConstants.EMPL_INKIND);

          /* if (beforeColl != null) {
                final int count = 0;
                final APP_IN_EMPL_Collection emplColl = null;
                if (emplColl != null && !emplColl.isEmpty()) {
                    final int emplCollSize = emplColl.size();
                    for (int i = 0; i < emplCollSize; i++) {
                        emplColl.getCargo(i);
                    }
                }
                if (count == 1) {
                    // now we need to make that profile requeired
                    final RMC_IN_PRFL_Cargo rmcResCargo = rmcResponseProfileManager
                            .getProfile(rmcInPrflColl, indvSeqNum);
                }
            }*/

            boolean rmcPrflNotRequeired = false;
            // here we need to check we have no entrys in rmcPrfl for the job
            // income detail
            // as well as we need to check
            if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
                if (rmcResponseProfileManager.isAppResponseNotRequired(
                        rmcInPrflColl, IRMCResponseProfileManager.REGULAR_EMPL)) {
                    if (rmcResponseProfileManager.isAppResponseNotRequired(
                            rmcInPrflColl,
                            IRMCResponseProfileManager.REGULAR_EMPL)) {
                        rmcPrflNotRequeired = true;
                    }
                }
            } else {
                rmcPrflNotRequeired = true;
            }

            if (categorySelectionProfileManager.isEmpty(rmcSelPrfl, catType)
                    && rmcPrflNotRequeired) {
                driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
                        "ARJID", driverArray, appNum);
            }
            session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER, rmcSelPrfl);
            driverManager.makeRequired(FwConstants.RMC_DRIVER,
                    AppConstants.ARJIS, driverArray, appNum);
            log(ILog.INFO,
                    "RMCJobIncomeEJBBean::eraseHealthInsuranceIncome:End");
        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("eraseHealthInsuranceIncome");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "eraseHealthInsuranceIncome", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.eraseHealthInsuranceIncome() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Edits the in kind income.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */
    public void editInKindIncome(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.editInKindIncome() - START");
        try {
            log(ILog.INFO, "RMCJobIncomeEJBBean::editInKindIncome:Start");
            final Map session = txnBean.getSession();
            final Map pageCollection = txnBean.getPageCollection();
            // Get driver info.
            final int[] driverArray = (int[]) session
                    .get(FwConstants.RMC_DRIVER);
            // Get the APP_IN_EMPL_Collection from pageCollection.
            final JOBINCOME_Custom_Collection jobIncColl = (JOBINCOME_Custom_Collection) pageCollection
                    .get("JOBINCOME_Custom_Collection");
            final JOBINCOME_Custom_Cargo jobInCargo = jobIncColl.getResult(0);

            final IndivTypeSeqBean seqBean = new IndivTypeSeqBean();
            seqBean.setIndivSeqNum(jobInCargo.getIndv_seq_num());
            seqBean.setSeqNum(jobInCargo.getEmpl_seq_num());
            seqBean.setType(jobInCargo.getEmpl_typ());
            pageCollection.put(FwConstants.DETAIL_KEY_BEAN, seqBean);
            // Get App Number
            final String appNum = (String) session.get(AppConstants.APP_NUMBER);
            // Set RMC page Job Income Details make required
            driverManager.makeRequired(FwConstants.RMC_DRIVER,
                    AppConstants.ARIKI, driverArray, appNum);
            driverManager.makeRequired(FwConstants.RMC_DRIVER,
                    AppConstants.ARJIS, driverArray, appNum);
            // End
            log(ILog.INFO, "RMCJobIncomeEJBBean::editInKindIncome:End");
        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("editInKindIncome");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "editInKindIncome", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.editInKindIncome() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Comment here.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */
    public void eraseJobIncome(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.eraseJobIncome() - START");
        try {
            log(ILog.INFO, "RMCJobIncomeEJBBean::eraseJobIncome:Start");
            final Map session = txnBean.getSession();
            final Map request = txnBean.getRequest();
            final Map pageCollection = txnBean.getPageCollection();
            final Map beforeColl = (Map) session
                    .get(FwConstants.BEFORE_COLLECTION);

            // Get RMCSessionBean from the session

            // Define IndvSeqNum and the SeqNum and Type and RowNum
            String indvSeqNum = null;
            String emplSeqNum = null;
            String emplType = null;

            // Get driver info.
            final int[] driverArray = (int[]) session
                    .get(FwConstants.RMC_DRIVER);

            // Get the APP_IN_EMPL_Collection from pageCollection.
            final JOBINCOME_Custom_Collection jobIncColl = (JOBINCOME_Custom_Collection) pageCollection
                    .get("JOBINCOME_Custom_Collection");
            final JOBINCOME_Custom_Cargo jobInCargo = jobIncColl.getResult(0);

            // Get the results from the APP_IN_EMPL_Collection
            final String appNum = (String) session.get(AppConstants.APP_NUMBER);

            // delete record from rmc selection profile
            final SortedSet rmcSelPrfl = (SortedSet) session
                    .get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
            final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
                    .get(AppConstants.RMC_IN_PRFL_MASTER);

            indvSeqNum = jobInCargo.getIndv_seq_num();
            emplSeqNum = jobInCargo.getEmpl_seq_num();
            emplType = jobInCargo.getEmpl_typ();
            JOBINCOME_Custom_Cargo beforeJobInCargo = (JOBINCOME_Custom_Cargo) beforeColl
                    .get("JOB_CUSTOM_CARGO");

            final IndivTypeSeqBean indivTypeSeqBean = new IndivTypeSeqBean();
            indivTypeSeqBean.setIndivSeqNum(indvSeqNum);
            indivTypeSeqBean.setSeqNum(emplSeqNum);
            indivTypeSeqBean.setType(emplType);
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

            final JobIncomeBO jobIncBO = new JobIncomeBO();
            if (beforeJobInCargo == null
                    || jobInCargo.isDifferent(beforeJobInCargo) || !eraseData) {
                final PeopleHandler peopleHandler = (PeopleHandler) session
                        .get(AppConstants.INDIV_MASTER_HANDLER);
                final String name = peopleHandler.getFirstName(indvSeqNum);
                final String type = jobInCargo.getEmpl_typ();
                jobIncBO.validateErase(type, name);
                request.put(FwConstants.MESSAGE_LIST, jobIncBO.getMessageList());
                beforeJobInCargo = new JOBINCOME_Custom_Cargo();
                beforeJobInCargo.setIndv_seq_num(indvSeqNum);
                beforeJobInCargo.setEmpl_seq_num(emplSeqNum);
                beforeJobInCargo.setEmpl_typ(emplType);
                beforeColl.put("JOB_CUSTOM_CARGO", beforeJobInCargo);
                beforeColl.put(AppConstants.INDV_TYPE_SEQ_BEAN,
                        indivTypeSeqBean);
                txnBean.setPageCollection(beforeColl);
                return;
            }
            // delete record from database
            jobIncBO.deleteRecords(indvSeqNum, emplSeqNum, appNum);
            
            // delete any employer offered health insurance record
            RMCEmplHlthInsBO rmcEmplHlthInsBO = new RMCEmplHlthInsBO();
            rmcEmplHlthInsBO.deleteModifiedRecords(indvSeqNum, emplSeqNum, appNum);
            rmcEmplHlthInsBO.deleteModifiedDependentRecords(indvSeqNum, emplSeqNum, appNum);
            if(null!=rmcSelPrfl) {
	            categorySelectionProfileManager.removeSequenceDetail(rmcSelPrfl,
	            		appNum, Short.parseShort(indvSeqNum),
						Long.parseLong(emplSeqNum),AppConstants.RMC_CAT_EMP_PRFL , emplType);
            }
            final Map catType = new HashMap();
            catType.put(AppConstants.EMPL_REGULAR, AppConstants.EMPL_REGULAR);
            catType.put(AppConstants.EMPL_INKIND, AppConstants.EMPL_INKIND);

            if (beforeColl != null) {
                int count = 0;
                APP_IN_EMPL_Collection emplColl = null;
                APP_IN_EMPL_Cargo emplCargo = null;
                if (AppConstants.EMPL_REGULAR.equals(emplType)) {
                    emplColl = (APP_IN_EMPL_Collection) beforeColl
                            .get("APP_IN_EMPL_JOB_Collection");
                } else {
                    emplColl = (APP_IN_EMPL_Collection) beforeColl
                            .get("APP_IN_EMPL_INKIND_Collection");
                }
                if (emplColl != null && !emplColl.isEmpty()) {
                    final int emplCollSize = emplColl.size();
                    for (int i = 0; i < emplCollSize; i++) {
                        emplCargo = emplColl.getCargo(i);
                        if (emplCargo.getIndv_seq_num().equals(indvSeqNum)
                                && emplCargo.getEmpl_typ().equals(emplType)
                                && AppConstants.RMC_NEW_RECORD_IND
                                .equals(emplCargo.getSrc_app_ind())) {
                            count++;
                        }
                    }
                }
                if (count == 1) {
                    // now we need to make that profile requeired
                    final RMC_IN_PRFL_Cargo rmcResCargo = rmcResponseProfileManager
                            .getProfile(rmcInPrflColl, indvSeqNum);
                    if (AppConstants.EMPL_REGULAR.equals(emplType)) {
                        rmcResponseProfileManager.makeAbsoluteNotRequired(
                                IRMCResponseProfileManager.REGULAR_EMPL,
                                rmcResCargo, true);
                    } else {
                        rmcResponseProfileManager.makeAbsoluteNotRequired(
                                IRMCResponseProfileManager.JOB_IN_KIND,
                                rmcResCargo, true);
                    }
                }
            }

            boolean rmcPrflNotRequeired = false;
            // here we need to check we have no entrys in rmcPrfl for the job
            // income detail
            // as well as we need to check
            if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
                if (rmcResponseProfileManager.isAppResponseNotRequired(
                        rmcInPrflColl, IRMCResponseProfileManager.REGULAR_EMPL)) {
                    if (rmcResponseProfileManager.isAppResponseNotRequired(
                            rmcInPrflColl,
                            IRMCResponseProfileManager.REGULAR_EMPL)) {
                        rmcPrflNotRequeired = true;
                    }
                }
            } else {
                rmcPrflNotRequeired = true;
            }
            
            APP_IN_EMPL_Collection nonCwEmplColl= jobIncBO.loadEmploymentCollection(appNum);
           
            if ((nonCwEmplColl == null || nonCwEmplColl.isEmpty())
                    && rmcPrflNotRequeired) {
                driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
                        "ARJID", driverArray, appNum);
            }
            session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER, rmcSelPrfl);
            driverManager.makeRequired(FwConstants.RMC_DRIVER,
                    AppConstants.ARJIS, driverArray, appNum);
            log(ILog.INFO, "RMCJobIncomeEJBBean::eraseJobIncome:End");
        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("eraseJobIncome");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "eraseJobIncome", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.eraseJobIncome() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Erase in kind income.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */
    public void eraseInKindIncome(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.eraseInKindIncome() - START");
        try {
            log(ILog.INFO, "RMCJobIncomeEJBBean::eraseInKindIncome:Start");
            final Map session = txnBean.getSession();
            final Map request = txnBean.getRequest();
            final Map pageCollection = txnBean.getPageCollection();
            final Map beforeColl = (Map) session
                    .get(FwConstants.BEFORE_COLLECTION);

            // Get RMCSessionBean from the session

            // Define IndvSeqNum and the SeqNum and Type and RowNum
            String indvSeqNum = null;
            String emplSeqNum = null;
            String emplType = null;

            // Get driver info.
            final int[] driverArray = (int[]) session
                    .get(FwConstants.RMC_DRIVER);

            // Get the APP_IN_EMPL_Collection from pageCollection.
            final JOBINCOME_Custom_Collection jobIncColl = (JOBINCOME_Custom_Collection) pageCollection
                    .get("JOBINCOME_Custom_Collection");
            final JOBINCOME_Custom_Cargo jobInCargo = jobIncColl.getResult(0);

            // Get the results from the APP_IN_EMPL_Collection
            final String appNum = (String) session.get(AppConstants.APP_NUMBER);

            // delete record from rmc selection profile
            final SortedSet rmcSelPrfl = (SortedSet) session
                    .get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
            final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
                    .get(AppConstants.RMC_IN_PRFL_MASTER);

            indvSeqNum = jobInCargo.getIndv_seq_num();
            emplSeqNum = jobInCargo.getEmpl_seq_num();
            emplType = jobInCargo.getEmpl_typ();
            JOBINCOME_Custom_Cargo beforeJobInCargo = (JOBINCOME_Custom_Cargo) beforeColl
                    .get("JOB_CUSTOM_CARGO");

            final IndivTypeSeqBean indivTypeSeqBean = new IndivTypeSeqBean();
            indivTypeSeqBean.setIndivSeqNum(indvSeqNum);
            indivTypeSeqBean.setSeqNum(emplSeqNum);
            indivTypeSeqBean.setType(emplType);
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

            final JobIncomeBO jobIncBO = new JobIncomeBO();
            if (beforeJobInCargo == null
                    || jobInCargo.isDifferent(beforeJobInCargo) || !eraseData) {
                jobIncBO.validateErase();
                request.put(FwConstants.MESSAGE_LIST, jobIncBO.getMessageList());
                beforeJobInCargo = new JOBINCOME_Custom_Cargo();
                beforeJobInCargo.setIndv_seq_num(indvSeqNum);
                beforeJobInCargo.setEmpl_seq_num(emplSeqNum);
                beforeJobInCargo.setEmpl_typ(emplType);
                beforeColl.put("JOB_CUSTOM_CARGO", beforeJobInCargo);
                beforeColl.put(AppConstants.INDV_TYPE_SEQ_BEAN,
                        indivTypeSeqBean);
                txnBean.setPageCollection(beforeColl);
                return;
            }
            // delete record from database
            jobIncBO.deleteRecords(indvSeqNum, emplSeqNum, appNum);

            final Map catType = new HashMap();
            catType.put(AppConstants.EMPL_INKIND, AppConstants.EMPL_INKIND);

            if (beforeColl != null) {
                int count = 0;
                APP_IN_EMPL_Collection emplColl = null;
                APP_IN_EMPL_Cargo emplCargo = null;
                if (AppConstants.EMPL_REGULAR.equals(emplType)) {
                    emplColl = (APP_IN_EMPL_Collection) beforeColl
                            .get("APP_IN_EMPL_JOB_Collection");
                } else {
                    emplColl = (APP_IN_EMPL_Collection) beforeColl
                            .get("APP_IN_EMPL_INKIND_Collection");
                }
                if (emplColl != null && !emplColl.isEmpty()) {
                    final int emplCollSize = emplColl.size();
                    for (int i = 0; i < emplCollSize; i++) {
                        emplCargo = emplColl.getCargo(i);
                        if (emplCargo.getIndv_seq_num().equals(indvSeqNum)
                                && emplCargo.getEmpl_typ().equals(emplType)
                                && AppConstants.RMC_NEW_RECORD_IND
                                .equals(emplCargo.getSrc_app_ind())) {
                            count++;
                        }
                    }
                }
                if (count == 1) {
                    // now we need to make that profile requeired
                    final RMC_IN_PRFL_Cargo rmcResCargo = rmcResponseProfileManager
                            .getProfile(rmcInPrflColl, indvSeqNum);
                    if (AppConstants.EMPL_REGULAR.equals(emplType)) {
                        rmcResponseProfileManager.makeAbsoluteNotRequired(
                                IRMCResponseProfileManager.REGULAR_EMPL,
                                rmcResCargo, true);
                    } else {
                        rmcResponseProfileManager.makeAbsoluteNotRequired(
                                IRMCResponseProfileManager.JOB_IN_KIND,
                                rmcResCargo, true);
                    }
                }
            }

            boolean rmcPrflNotRequeired = false;
            // here we need to check we have no entrys in rmcPrfl for the job
            // income detail
            // as well as we need to check
            if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
                if (rmcResponseProfileManager.isAppResponseNotRequired(
                        rmcInPrflColl, IRMCResponseProfileManager.JOB_IN_KIND)) {
                    if (rmcResponseProfileManager.isAppResponseNotRequired(
                            rmcInPrflColl,
                            IRMCResponseProfileManager.JOB_IN_KIND)) {
                        rmcPrflNotRequeired = true;
                    }
                }
            } else {
                rmcPrflNotRequeired = true;
            }

            if (categorySelectionProfileManager.isEmpty(rmcSelPrfl, catType)
                    && rmcPrflNotRequeired) {
                driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
                        AppConstants.ARIKI, driverArray, appNum);
            }
            session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER, rmcSelPrfl);
            driverManager.makeRequired(FwConstants.RMC_DRIVER,
                    AppConstants.ARJIS, driverArray, appNum);
            log(ILog.INFO, "RMCJobIncomeEJBBean::eraseInKindIncome:End");
        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("eraseInKindIncome");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "eraseInKindIncome", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.eraseJobIncome() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Comment here.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */

    public void addInkindIncome(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.addInkindIncome() - START");
        try {
            final Map session = txnBean.getSession();
            final Map request = txnBean.getRequest();
            final Map pageCollection = txnBean.getPageCollection();
            // get cargo determining user selection
            final String inkindIncomeSeq = request
                    .get("firstName_inkindIncome") != null ? (String) request
                            .get("firstName_inkindIncome") : FwConstants.EMPTY_STRING;
                            final String appNum = (String) session.get(AppConstants.APP_NUMBER);

                            final JobIncomeBO jobBo = new JobIncomeBO();
                            // validate selections
                            if (inkindIncomeSeq == null
                                    || AppConstants.SELECT_DEFAULT_OPTION
                                    .equals(inkindIncomeSeq)) {
                                jobBo.validateAdd();
                                // add validation message and return
                                request.put(FwConstants.MESSAGE_LIST, jobBo.getMessageList());
                                txnBean.setPageCollection((Map) session
                                        .get(FwConstants.BEFORE_COLLECTION));
                                return;
                            }

                            final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
                            indivSeqBean.setIndivSeqNum(inkindIncomeSeq);
                            indivSeqBean.setSeqNum(FwConstants.ZERO);
                            indivSeqBean.setType(AppConstants.EMPL_INKIND);
                            pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

                            // set driver status
                            final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
                            driverManager.makeRequired(FwConstants.RMC_DRIVER,
                                    AppConstants.ARIKI, driver, appNum);
                            driverManager.makeRequired(FwConstants.RMC_DRIVER,
                                    AppConstants.ARJIS, driver, appNum);
                            session.put(FwConstants.RMC_DRIVER, driver);

        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("addInkindIncome");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "addInkindIncome", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.addInkindIncome() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Comment here.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */
    public void addJobIncome(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.addJobIncome() - START");
        try {
            final Map session = txnBean.getSession();
            final Map request = txnBean.getRequest();
            final Map pageCollection = txnBean.getPageCollection();
            // get cargo determining user selection
            final String jobIncomeSeq = request.get("firstName_jobIncome") != null ? (String) request
                    .get("firstName_jobIncome") : FwConstants.EMPTY_STRING;

                    final JobIncomeBO jobBo = new JobIncomeBO();
                    // validate selections
                    if (jobIncomeSeq == null
                            || AppConstants.SELECT_DEFAULT_OPTION.equals(jobIncomeSeq)) {
                        jobBo.validateAdd();
                        // add validation message and return
                        request.put(FwConstants.MESSAGE_LIST, jobBo.getMessageList());
                        txnBean.setPageCollection((Map) session
                                .get(FwConstants.BEFORE_COLLECTION));
                        return;
                    }
                    final String appNum = (String) session.get(AppConstants.APP_NUMBER);
                    final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
                    indivSeqBean.setIndivSeqNum(jobIncomeSeq);
                    indivSeqBean.setSeqNum(FwConstants.ZERO);
                    indivSeqBean.setType(AppConstants.EMPL_REGULAR);
                    pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

                    // set driver status
                    final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
                    driverManager.makeAddNew(FwConstants.RMC_DRIVER, "ARJID", driver,
                            appNum);
                    driverManager.makeRequired(FwConstants.RMC_DRIVER,
                            AppConstants.ARJIS, driver, appNum);
                    session.put(FwConstants.RMC_DRIVER, driver);

        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("addJobIncome");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "addJobIncome", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.addJobIncome() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Adds the in kind income.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */
    public void addInKindIncome(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.addInKindIncome() - START");
        try {
            final Map session = txnBean.getSession();
            final Map request = txnBean.getRequest();
            final Map pageCollection = txnBean.getPageCollection();
            // get cargo determining user selection
            final String jobIncomeSeq = request.get("firstName_jobIncome") != null ? (String) request
                    .get("firstName_jobIncome") : FwConstants.EMPTY_STRING;

                    final JobIncomeBO jobBo = new JobIncomeBO();
                    // validate selections
                    if (jobIncomeSeq == null
                            || AppConstants.SELECT_DEFAULT_OPTION.equals(jobIncomeSeq)) {
                        jobBo.validateAdd();
                        // add validation message and return
                        request.put(FwConstants.MESSAGE_LIST, jobBo.getMessageList());
                        txnBean.setPageCollection((Map) session
                                .get(FwConstants.BEFORE_COLLECTION));
                        return;
                    }
                    final String appNum = (String) session.get(AppConstants.APP_NUMBER);
                    final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
                    indivSeqBean.setIndivSeqNum(jobIncomeSeq);
                    indivSeqBean.setSeqNum(FwConstants.ZERO);
                    indivSeqBean.setType(AppConstants.EMPL_INKIND);
                    pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

                    // set driver status
                    final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
                    driverManager.makeRequired(FwConstants.RMC_DRIVER,
                            AppConstants.ARIKI, driver, appNum);
                    driverManager.makeRequired(FwConstants.RMC_DRIVER,
                            AppConstants.ARJIS, driver, appNum);
                    session.put(FwConstants.RMC_DRIVER, driver);

        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("addInKindIncome");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "addInKindIncome", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.addInKindIncome() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Adds the empl ins details.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */
    public void addEmplInsDetails(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.addEmplInsDetails() - START");
        log(ILog.INFO,
                "RMCJobIncomeEJBBean.addEmplInsDetails() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Assign cargo by seq num.
     *
     * @param wageMap the wage map
     * @param wageSeq the wage seq
     * @return the AP p_ i n_ emp l_ a_ wag e_ cargo
     */
    private APP_IN_EMPL_A_WAGE_Cargo assignCargoBySeqNum(final Map wageMap,
            final String wageSeq) {

        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.assignCargoBySeqNum() - START");
        try {
            APP_IN_EMPL_A_WAGE_Cargo wageCargo = null;
            if (wageMap != null && !wageMap.isEmpty() && wageSeq != null) {
                if (FwConstants.ZERO.equals(wageSeq)) {
                    wageCargo = (APP_IN_EMPL_A_WAGE_Cargo) wageMap
                            .get("APP_IN_EMPL_A_WAGE_INKIND_Cargo");
                } else if ("1001".equals(wageSeq)) {

                    wageCargo = (APP_IN_EMPL_A_WAGE_Cargo) wageMap
                            .get("APP_IN_EMPL_A_WAGE_HOURLY_Cargo");
                } else if ("1002".equals(wageSeq)) {
                    wageCargo = (APP_IN_EMPL_A_WAGE_Cargo) wageMap
                            .get("APP_IN_EMPL_A_WAGE_SALARY_Cargo");
                } else if ("1003".equals(wageSeq)) {
                    wageCargo = (APP_IN_EMPL_A_WAGE_Cargo) wageMap
                            .get("APP_IN_EMPL_A_WAGE_ADL1_Cargo");
                } else if ("1004".equals(wageSeq)) {
                    wageCargo = (APP_IN_EMPL_A_WAGE_Cargo) wageMap
                            .get("APP_IN_EMPL_A_WAGE_ADL2_Cargo");
                } else if ("1005".equals(wageSeq)) {
                    wageCargo = (APP_IN_EMPL_A_WAGE_Cargo) wageMap
                            .get("APP_IN_EMPL_A_WAGE_ADL3_Cargo");
                } else if ("1006".equals(wageSeq)) {
                    wageCargo = (APP_IN_EMPL_A_WAGE_Cargo) wageMap
                            .get("APP_IN_EMPL_A_WAGE_ADL4_Cargo");
                } else if ("7".equals(wageSeq)) {
                    wageCargo = (APP_IN_EMPL_A_WAGE_Cargo) wageMap
                            .get("APP_IN_EMPL_A_WAGE_OTH1_Cargo");
                } else if ("8".equals(wageSeq)) {
                    wageCargo = (APP_IN_EMPL_A_WAGE_Cargo) wageMap
                            .get("APP_IN_EMPL_A_WAGE_OTH2_Cargo");
                } else if ("9".equals(wageSeq)) {
                    wageCargo = (APP_IN_EMPL_A_WAGE_Cargo) wageMap
                            .get("APP_IN_EMPL_A_WAGE_OTH3_Cargo");
                } else if ("10".equals(wageSeq)) {
                    wageCargo = (APP_IN_EMPL_A_WAGE_Cargo) wageMap
                            .get("APP_IN_EMPL_A_WAGE_JOB_Cargo");
                } else if ("11".equals(wageSeq)) {
                    wageCargo = (APP_IN_EMPL_A_WAGE_Cargo) wageMap
                            .get("APP_IN_EMPL_A_WAGE_ADD_Cargo");
                }
            }
            log(ILog.INFO,
                    "RMCJobIncomeEJBBean.assignCargoBySeqNum() - END , Time Taken : "
                            + (System.currentTimeMillis() - startTime)
                            + AppConstants.SPACE + AppConstants.MILLISECONDS);
            return wageCargo;
        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("assignCargoBySeqNum");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "assignCargoBySeqNum", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

    }

    /**
     * Setting default values.
     *
     * @param tempCargo the temp cargo
     * @return the AP p_ i n_ emp l_ a_ wag e_ cargo
     */
    private APP_IN_EMPL_A_WAGE_Cargo settingDefaultValues(
            final APP_IN_EMPL_A_WAGE_Cargo tempCargo) {

        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.settingDefaultValues() - START");
        try {
            // indicator logic
            if (tempCargo.getAdtl_pay_amt() != null
                    && !FwConstants.EMPTY_STRING.equals(tempCargo
                            .getAdtl_pay_amt().trim())
                            && tempCargo.getAdtl_hrs_qty() != null
                            && !FwConstants.EMPTY_STRING.equals(tempCargo
                                    .getAdtl_hrs_qty().trim())
                                    && (tempCargo.getAdtl_pay_ind() == null || !FwConstants.ONE
                                    .equals(tempCargo.getAdtl_pay_ind()))) {
                tempCargo.setAdtl_pay_ind(FwConstants.ZERO);
            } else if (tempCargo.getAdtl_pay_ind() != null
                    && FwConstants.ONE.equals(tempCargo.getAdtl_pay_ind())) {
                tempCargo.setAdtl_pay_ind(FwConstants.ONE);
            } else if (tempCargo.getAdtl_pay_amt() != null
                    && !FwConstants.EMPTY_STRING.equals(tempCargo
                            .getAdtl_pay_amt().trim())
                            && (tempCargo.getAdtl_hrs_qty() == null || FwConstants.EMPTY_STRING
                            .equals(tempCargo.getAdtl_hrs_qty().trim()))) {
                tempCargo.setAdtl_pay_ind("2");
            } else if (tempCargo.getAdtl_hrs_qty() != null
                    && !FwConstants.EMPTY_STRING.equals(tempCargo
                            .getAdtl_hrs_qty().trim())
                            && (tempCargo.getAdtl_pay_amt() == null || FwConstants.EMPTY_STRING
                            .equals(tempCargo.getAdtl_pay_amt().trim()))) {
                tempCargo.setAdtl_pay_ind("3");
            } else if ((tempCargo.getAdtl_pay_amt() == null || FwConstants.EMPTY_STRING
                    .equals(tempCargo.getAdtl_pay_amt().trim()))
                    && (tempCargo.getAdtl_hrs_qty() == null || FwConstants.EMPTY_STRING
                    .equals(tempCargo.getAdtl_hrs_qty().trim()))) {
                tempCargo.setAdtl_pay_ind("4");
            }
            if (tempCargo.getAdtl_hrs_qty() == null
                    || FwConstants.EMPTY_STRING.equals(tempCargo
                            .getAdtl_hrs_qty().trim())) {
                tempCargo.setAdtl_hrs_qty(FwConstants.EMPTY_STRING);
            }
            if (tempCargo.getAdtl_pay_amt() == null
                    || FwConstants.EMPTY_STRING.equals(tempCargo
                            .getAdtl_pay_amt().trim())) {
                tempCargo.setAdtl_pay_amt(FwConstants.EMPTY_STRING);
            }
            if (tempCargo.getAdtl_pay_typ() == null
                    || FwConstants.EMPTY_STRING.equals(tempCargo
                            .getAdtl_pay_typ().trim())
                            || AppConstants.SELECT_DEFAULT_OPTION.equals(tempCargo
                                    .getAdtl_pay_typ().trim())) {
                tempCargo.setAdtl_pay_typ(FwConstants.EMPTY_STRING);
            }

            log(ILog.INFO,
                    "RMCJobIncomeEJBBean.settingDefaultValues() - END , Time Taken : "
                            + (System.currentTimeMillis() - startTime)
                            + AppConstants.SPACE + AppConstants.MILLISECONDS);
            return tempCargo;
        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("settingDefaultValues");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "settingDefaultValues", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }
    }

    /**
     * Compare cargos.
     *
     * @param appInEmplWageCargo the app in empl wage cargo
     * @param wageMap the wage map
     * @param wageSeqNum the wage seq num
     * @param empSeqNum the emp seq num
     * @param indvSeqNum the indv seq num
     * @param appNum the app num
     * @param rowAction the row action
     * @param srcRecordInd the src record ind
     * @param maxEmplWageSeqNum the max empl wage seq num
     * @param deletedList the deleted list
     * @param wageDetailsUpdate the wage details update
     * @param pageMode the page mode
     * @return the AP p_ i n_ emp l_ a_ wag e_ cargo
     */
    private APP_IN_EMPL_A_WAGE_Cargo compareCargos(
            APP_IN_EMPL_A_WAGE_Cargo appInEmplWageCargo, final Map wageMap,
            final String wageSeqNum, final long empSeqNum,
            final String indvSeqNum, final String appNum,
            final String rowAction, final String srcRecordInd,
            final int[] maxEmplWageSeqNum, final List deletedList,
            final boolean[] wageDetailsUpdate, final String pageMode) {

        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.compareCargos() - START");
        try {
            final APP_IN_EMPL_A_WAGE_Cargo beforeCargo = assignCargoBySeqNum(
                    wageMap, wageSeqNum);
            if (beforeCargo != null
                    && beforeCargo.getAdtl_hrs_qty().trim().length() == 0) {
                beforeCargo.setAdtl_hrs_qty("0.00");
            }

            boolean deletedFlag = false;
            if (deletedList != null && deletedList.contains(wageSeqNum)) {
                deletedFlag = true;
            }
            if (appInEmplWageCargo != null) {

                final String adtlPayAmt = appInEmplWageCargo.getAdtl_pay_amt();
                final String adtlHrsQty = appInEmplWageCargo.getAdtl_hrs_qty();
                if ("10".equalsIgnoreCase(appInEmplWageCargo
                        .getAdtl_pay_seq_num())) {
                    appInEmplWageCargo.setAdtl_pay_typ("JOB");
                }
                if ("11".equalsIgnoreCase(appInEmplWageCargo
                        .getAdtl_pay_seq_num())) {
                    appInEmplWageCargo.setAdtl_pay_typ("ADD");
                }
                final String adtlPayTyp = appInEmplWageCargo.getAdtl_pay_typ();
                if (adtlPayTyp == null
                        || AppConstants.SELECT_DEFAULT_OPTION
                        .equals(adtlPayTyp)) {

                    if (beforeCargo != null
                            && rowAction == FwConstants.ROWACTION_INSERT
                            && deletedFlag) {

                        beforeCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
                        beforeCargo.setDirty(true);
                        wageDetailsUpdate[0] = true;
                        return beforeCargo;
                    }

                    return null;

                }
                // checking for additational hours quanty
                if (FwConstants.ZERO.equals(wageSeqNum)
                        || "1001".equals(wageSeqNum)
                        || "1002".equals(wageSeqNum)) {
                    if ((adtlPayAmt == null || adtlPayAmt.trim().length() == 0)
                            && (adtlHrsQty == null || adtlHrsQty.trim()
                            .length() == 0)) {
                        // first we need to check the row action
                        // if the row action is update means visiting 2 time to
                        // this page
                        // in this scenario we need to check before caro is null
                        // or not
                        // if before cargo is not equals null means first user
                        // enter this information
                        // when they comming back they erased the entered
                        // information
                        // means we need to deleted the before cargo
                        if (beforeCargo != null
                                && rowAction == FwConstants.ROWACTION_UPDATE) {
                            beforeCargo
                            .setRowAction(FwConstants.ROWACTION_DELETE);
                            beforeCargo.setDirty(true);
                            wageDetailsUpdate[0] = true;
                            return beforeCargo;
                        }
                        // no need to insert this record in the data base
                        // NOW WE NEED TO CHECK BEFORE CARGO
                        // IF BEFORE CARGO IS NULL THEN WE NEED TO SET WAGE
                        // DETAILS FLAG TO TRUE
                        if (beforeCargo != null) {
                            wageDetailsUpdate[0] = true;
                        }
                        return null;
                    }
                }
                // now i am setting the default values
                if (adtlPayAmt == null || adtlPayAmt.trim().length() == 0) {
                    appInEmplWageCargo.setAdtl_pay_amt("0.00");
                }
                if (adtlHrsQty == null || adtlHrsQty.trim().length() == 0) {
                    appInEmplWageCargo.setAdtl_hrs_qty("0.00");
                }
                if (beforeCargo != null && !deletedFlag) {
                    appInEmplWageCargo.setApp_num(beforeCargo.getApp_num());
                    appInEmplWageCargo.setIndv_seq_num(beforeCargo
                            .getIndv_seq_num());
                    appInEmplWageCargo.setEmpl_seq_num(beforeCargo
                            .getEmpl_seq_num());
                    appInEmplWageCargo.setAdtl_pay_seq_num(beforeCargo
                            .getAdtl_pay_seq_num());
                    appInEmplWageCargo.setAdtl_pay_ind(FwConstants.ZERO); // beforeCargo.
                    appInEmplWageCargo.setSrc_app_ind(beforeCargo
                            .getSrc_app_ind());

                    appInEmplWageCargo = (APP_IN_EMPL_A_WAGE_Cargo) isChanged(
                            beforeCargo, appInEmplWageCargo);
                    appInEmplWageCargo.setSrc_app_ind(srcRecordInd);
                    appInEmplWageCargo.setRowAction(rowAction);
                } else {
                    // get max seq numer and insert into the data base
                    appInEmplWageCargo.setApp_num(appNum);
                    appInEmplWageCargo.setIndv_seq_num(indvSeqNum);
                    appInEmplWageCargo.setEmpl_seq_num(String
                            .valueOf(empSeqNum));
                    if ("10".equalsIgnoreCase(appInEmplWageCargo
                            .getAdtl_pay_seq_num())) {
                        appInEmplWageCargo.setAdtl_pay_typ("JOB");
                    }
                    if ("11".equalsIgnoreCase(appInEmplWageCargo
                            .getAdtl_pay_seq_num())) {
                        appInEmplWageCargo.setAdtl_pay_typ("ADD");
                    }
                    if (appInEmplWageCargo.getAdtl_pay_typ() != null) {
                        if (AppConstants.EMPL_INKIND.equals(appInEmplWageCargo
                                .getAdtl_pay_typ().trim())) {
                            appInEmplWageCargo
                            .setAdtl_pay_seq_num(FwConstants.ZERO);

                        } else {
                            appInEmplWageCargo.setAdtl_pay_seq_num(String
                                    .valueOf(++maxEmplWageSeqNum[0]));
                        }
                    } else {
                        appInEmplWageCargo.setAdtl_pay_seq_num(String
                                .valueOf(++maxEmplWageSeqNum[0]));
                    }
                    appInEmplWageCargo.setAdtl_pay_ind(FwConstants.ZERO);

                    appInEmplWageCargo
                    .setRowAction(FwConstants.ROWACTION_INSERT);

                    appInEmplWageCargo.setSrc_app_ind(srcRecordInd);
                    appInEmplWageCargo.setDirty(true);
                    wageDetailsUpdate[0] = true;
                }
                return appInEmplWageCargo;

            }
            // this conditation will satisfy only when the employ type is X
            // means R&I
            // if after cargo is null and before cargo is not null
            // means if the page in regular employ type mode then we need to
            // copy the inkind amount
            // if the page in inkind mode we need to copy the regular employee
            // to the data base
            if (beforeCargo != null && !deletedFlag) {
                beforeCargo.setRowAction(rowAction);
                beforeCargo.setSrc_app_ind(srcRecordInd);
                beforeCargo.setDirty(false);
                if (beforeCargo.getAdtl_hrs_qty() == null
                        || beforeCargo.getAdtl_hrs_qty().length() == 0) {
                    beforeCargo.setAdtl_hrs_qty("0.00");
                }
                if (beforeCargo.getAdtl_pay_amt() == null
                        || beforeCargo.getAdtl_pay_amt().length() == 0) {
                    beforeCargo.setAdtl_pay_amt("0.00");
                }
                return beforeCargo;
            }

            log(ILog.INFO,
                    "RMCJobIncomeEJBBean.compareCargos() - END , Time Taken : "
                            + (System.currentTimeMillis() - startTime)
                            + AppConstants.SPACE + AppConstants.MILLISECONDS);
            return null;
        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("compareCargos");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "compareCargos", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }
    }

    /**
     * Split wage coll.
     *
     * @param wageColl the wage coll
     * @param recordIndicator the record indicator
     * @return the map
     */
    private Map splitWageColl(final APP_IN_EMPL_A_WAGE_Collection wageColl,
            final String recordIndicator) {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.splitWageColl() - START");
        try {
            final Map wageMap = new HashMap();
            if (wageColl != null && !wageColl.isEmpty()) {
                APP_IN_EMPL_A_WAGE_Cargo wageCargo = null;
                final int wageCollSize = wageColl.size();
                String wageRecInd = null;
                String wagePayType = null;
                int adlInd = 0;
                int othInd = 0;

                for (int i = 0; i < wageCollSize; i++) {
                    wageCargo = wageColl.getResult(i);
                    wageRecInd = wageCargo.getSrc_app_ind();
                    // changed code by Anupam for IN-Pre Work
                    // added IF condition.Provided Null check before using trim
                    if (wageCargo.getAdtl_pay_typ() != null) {
                        wagePayType = wageCargo.getAdtl_pay_typ().trim();

                        if (recordIndicator.equals(wageRecInd)) {
                            if (AppConstants.EMPL_INKIND.equals(wagePayType)) {
                                wageMap.put("APP_IN_EMPL_A_WAGE_INKIND_Cargo",
                                        settingDefaultValues(wageColl
                                                .getResult(i)));
                            }
                            if (AppConstants.WAGE_TYPE_HOURLY
                                    .equals(wagePayType)) {
                                wageMap.put("APP_IN_EMPL_A_WAGE_HOURLY_Cargo",
                                        settingDefaultValues(wageColl
                                                .getResult(i)));
                            } else if (AppConstants.WAGE_TYPE_SALARY
                                    .equals(wagePayType)) {
                                wageMap.put("APP_IN_EMPL_A_WAGE_SALARY_Cargo",
                                        settingDefaultValues(wageColl
                                                .getResult(i)));
                            } else if (AppConstants.WAGE_TYPE_OVERTIME
                                    .equals(wagePayType)
                                    || AppConstants.WAGE_TYPE_WEEKEND
                                    .equals(wagePayType)
                                    || AppConstants.WAGE_TYPE_HOLIDAY
                                    .equals(wagePayType)
                                    || AppConstants.WAGE_TYPE_SHITDIFF
                                    .equals(wagePayType)
                                    || AppConstants.WAGE_TYPE_OTHER
                                    .equals(wagePayType)) {
                                wageMap.put("APP_IN_EMPL_A_WAGE_ADL" + ++adlInd
                                        + "_Cargo",
                                        settingDefaultValues(wageColl
                                                .getResult(i)));
                                wageMap.put("APP_IN_EMPL_A_WAGE_ADD_Cargo",
                                        settingDefaultValues(wageColl
                                                .getResult(i)));

                            } else if ("BON".equals(wagePayType)) {
                                wageMap.put("APP_IN_EMPL_A_WAGE_OTH" + ++othInd
                                        + "_Cargo",
                                        settingDefaultValues(wageColl
                                                .getResult(i)));
                            } else if (AppConstants.WAGE_TYPE_BONUS
                                    .equals(wagePayType)) {
                                wageMap.put("APP_IN_EMPL_A_WAGE_OTH" + ++othInd
                                        + "_Cargo",
                                        settingDefaultValues(wageColl
                                                .getResult(i)));
                            } else if (AppConstants.WAGE_TYPE_JOB
                                    .equals(wagePayType)) {
                                wageMap.put("APP_IN_EMPL_A_WAGE_JOB_Cargo",
                                        settingDefaultValues(wageColl
                                                .getResult(i)));
                            } else if (AppConstants.WAGE_TYPE_ADDITIONAL
                                    .equals(wagePayType)) {
                                wageMap.put("APP_IN_EMPL_A_WAGE_ADD_Cargo",
                                        settingDefaultValues(wageColl
                                                .getResult(i)));
                            }
                        }
                    }
                }
            }

            log(ILog.INFO,
                    "RMCJobIncomeEJBBean.splitWageColl() - END , Time Taken : "
                            + (System.currentTimeMillis() - startTime)
                            + AppConstants.SPACE + AppConstants.MILLISECONDS);
            return wageMap;
        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("splitWageColl");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "splitWageColl", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }
    }

    /**
     * Sort coll.
     *
     * @param wageColl the wage coll
     * @return the AP p_ i n_ emp l_ a_ wag e_ collection
     */
    public APP_IN_EMPL_A_WAGE_Collection sortColl(
            final APP_IN_EMPL_A_WAGE_Collection wageColl) {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.sortColl() - START");
        final APP_IN_EMPL_A_WAGE_Collection newWageColl = new APP_IN_EMPL_A_WAGE_Collection();
        final APP_IN_EMPL_A_WAGE_Collection newAddColl = new APP_IN_EMPL_A_WAGE_Collection();
        final APP_IN_EMPL_A_WAGE_Collection newOthColl = new APP_IN_EMPL_A_WAGE_Collection();
        APP_IN_EMPL_A_WAGE_Cargo wageCargo = null;
        String wagePayType = null;
        String wagePaySeqNum = null;
        for (int j = 0; j < 5; j++) {
            final int size = wageColl.size();
            for (int i = 0; i < size; i++) {
                wageCargo = wageColl.getResult(i);
                wagePayType = wageCargo.getAdtl_pay_typ();
                wagePaySeqNum = wageCargo.getAdtl_pay_seq_num();
                if (j == 0) {
                    if (AppConstants.EMPL_INKIND.equals(wagePayType)) {
                        newWageColl.addCargo(wageCargo);
                    }
                } else if (j == 1) {
                    if (AppConstants.WAGE_TYPE_HOURLY.equals(wagePayType)) {
                        newWageColl.addCargo(wageCargo);
                    }
                } else if (j == 2) {
                    if (AppConstants.WAGE_TYPE_SALARY.equals(wagePayType)) {
                        newWageColl.addCargo(wageCargo);
                    }
                } else if (j == 3) {
                    if (AppConstants.WAGE_TYPE_OVERTIME.equals(wagePayType)
                            || AppConstants.WAGE_TYPE_WEEKEND
                            .equals(wagePayType)
                            || AppConstants.WAGE_TYPE_HOLIDAY
                            .equals(wagePayType)
                            || AppConstants.WAGE_TYPE_SHITDIFF
                            .equals(wagePayType)
                            || "1003".equals(wagePaySeqNum)
                            || "1004".equals(wagePaySeqNum)
                            || "1005".equals(wagePaySeqNum)
                            || "1006".equals(wagePaySeqNum)) {
                        newAddColl.addCargo(wageCargo);
                    }
                } else if (j == 4) {
                    if (AppConstants.WAGE_TYPE_TIPS.equals(wagePayType)
                            || AppConstants.WAGE_TYPE_BONUS.equals(wagePayType)
                            || "1007".equals(wagePaySeqNum)
                            || "1008".equals(wagePaySeqNum)
                            || "1009".equals(wagePaySeqNum)) {
                        newOthColl.addCargo(wageCargo);

                    }
                }
            }
            if (j == 3 && !newAddColl.isEmpty()) {
                // sort the collections
                final APP_IN_EMPL_A_WAGE_Cargo[] cargoAry = newAddColl
                        .getResults();

                final Comparator sortOrder = new Comparator() {
                    @Override
                    public int compare(final Object obj1, final Object obj2)
                            throws ClassCastException {
                        final APP_IN_EMPL_A_WAGE_Cargo c1 = (APP_IN_EMPL_A_WAGE_Cargo) obj1;
                        final APP_IN_EMPL_A_WAGE_Cargo c2 = (APP_IN_EMPL_A_WAGE_Cargo) obj2;
                        return c1.getAdtl_pay_seq_num().compareTo(
                                c2.getAdtl_pay_seq_num());
                    }
                };

                // add to newWageColl
                java.util.Arrays.sort(cargoAry, sortOrder);
                wageColl.setResults(cargoAry);
            }
            if (j == 4 && !newOthColl.isEmpty()) {
                // sort the collections
                final APP_IN_EMPL_A_WAGE_Cargo[] cargoAry = newOthColl
                        .getResults();

                final Comparator sortOrder = new Comparator() {
                    @Override
                    public int compare(final Object obj1, final Object obj2)
                            throws ClassCastException {
                        final APP_IN_EMPL_A_WAGE_Cargo c1 = (APP_IN_EMPL_A_WAGE_Cargo) obj1;
                        final APP_IN_EMPL_A_WAGE_Cargo c2 = (APP_IN_EMPL_A_WAGE_Cargo) obj2;
                        return c1.getAdtl_pay_seq_num().compareTo(
                                c2.getAdtl_pay_seq_num());
                    }
                };

                // add to newWageColl
                java.util.Arrays.sort(cargoAry, sortOrder);
                wageColl.setResults(cargoAry);
            }
        }
        log(ILog.INFO, "RMCJobIncomeEJBBean.sortColl() - END , Time Taken : "
                + (System.currentTimeMillis() - startTime) + AppConstants.SPACE
                + AppConstants.MILLISECONDS);
        return wageColl;
    }

    /**
     * Split empl coll.
     *
     * @param emplColl the empl coll
     * @param recordIndicator the record indicator
     * @return the AP p_ i n_ emp l_ cargo
     */
    private APP_IN_EMPL_Cargo splitEmplColl(
            final APP_IN_EMPL_Collection emplColl, final String recordIndicator) {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.splitEmplColl() - START");
        try {
            if (emplColl != null && !emplColl.isEmpty()) {
                final int emplCollSize = emplColl.size();
                APP_IN_EMPL_Cargo emplCargo = null;
                for (int i = 0; i < emplCollSize; i++) {
                    emplCargo = emplColl.getCargo(i);
                    if (emplCargo.getSrc_app_ind().equals(recordIndicator)) {
                        return emplColl.getCargo(i);
                    }
                }

            }

            log(ILog.INFO,
                    "RMCJobIncomeEJBBean.splitEmplColl() - END , Time Taken : "
                            + (System.currentTimeMillis() - startTime)
                            + AppConstants.SPACE + AppConstants.MILLISECONDS);
            return null;
        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("splitEmplColl");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "splitEmplColl", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }
    }
    
    private APP_IN_EMPL_HEALTH_Cargo splitEmplHlth(
            final APP_IN_EMPL_HEALTH_Collection emplColl, final String recordIndicator) {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.splitEmplHlth() - START");
        try {
            if (emplColl != null && !emplColl.isEmpty()) {
                final int emplCollSize = emplColl.size();
                APP_IN_EMPL_HEALTH_Cargo emplCargo = null;
                for (int i = 0; i < emplCollSize; i++) {
                    emplCargo = emplColl.getCargo(i);
                    if (emplCargo.getSrc_app_ind().equals(recordIndicator)) {
                        return emplColl.getCargo(i);
                    }
                }

            }

            log(ILog.INFO,
                    "RMCJobIncomeEJBBean.splitEmplHlth() - END , Time Taken : "
                            + (System.currentTimeMillis() - startTime)
                            + AppConstants.SPACE + AppConstants.MILLISECONDS);
            return null;
        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("splitEmplHlth");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "splitEmplHlth", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }
    }

    /**
     * Setting default values.
     *
     * @param emplCargo the empl cargo
     * @return the AP p_ i n_ emp l_ cargo
     */
    private APP_IN_EMPL_Cargo settingDefaultValues(
            final APP_IN_EMPL_Cargo emplCargo) {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.settingDefaultValues() - START");
        try {
            if (emplCargo != null) {
                // initialize date fields
                if (emplCargo.getEmpl_beg_dt() == null) {
                    emplCargo.setEmpl_beg_dt(FwConstants.EMPTY_STRING);
                }
                if (emplCargo.getEmpl_end_dt() == null) {
                    emplCargo.setEmpl_end_dt(FwConstants.EMPTY_STRING);
                }
                if (emplCargo.getStrk_beg_dt() == null) {
                    emplCargo.setStrk_beg_dt(FwConstants.EMPTY_STRING);
                }
                if (emplCargo.getLast_payck_dt() == null) {
                    emplCargo.setLast_payck_dt(FwConstants.EMPTY_STRING);
                }
            }

            log(ILog.INFO,
                    "RMCJobIncomeEJBBean.settingDefaultValues() - END , Time Taken : "
                            + (System.currentTimeMillis() - startTime)
                            + AppConstants.SPACE + AppConstants.MILLISECONDS);
            return emplCargo;
        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("settingDefaultValues");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "settingDefaultValues", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }
    }

    /**
     * Split empl wage1.
     *
     * @param wageColl the wage coll
     * @param seqNum the seq num
     * @return the AP p_ i n_ emp l_ a_ wag e_ cargo
     */
    public APP_IN_EMPL_A_WAGE_Cargo splitEmplWage1(
            APP_IN_EMPL_A_WAGE_Collection wageColl, final String seqNum) {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.splitEmplWage1() - START");
        try {
            APP_IN_EMPL_A_WAGE_Cargo appInEmplCargo = null;
            if (wageColl != null) {
                final int collSize = wageColl.size();
                wageColl = sortColl(wageColl);
                for (int i = 0; i < collSize; i++) {
                    final APP_IN_EMPL_A_WAGE_Cargo tempCargo = wageColl
                            .getResult(i);
                    if (tempCargo.getAdtl_pay_seq_num().equals(seqNum)) {
                        if (AppConstants.EMPL_INKIND.equals(tempCargo
                                .getAdtl_pay_typ())
                                || FwConstants.ZERO.equals(tempCargo
                                        .getAdtl_pay_seq_num())) {
                            return tempCargo;
                        }
                        if ("HOR".equals(tempCargo.getAdtl_pay_typ())
                                || "1001".equals(tempCargo
                                        .getAdtl_pay_seq_num())) {
                            return tempCargo;
                        }
                        if ("SAL".equals(tempCargo.getAdtl_pay_typ())
                                || "1002".equals(tempCargo
                                        .getAdtl_pay_seq_num())) {
                            return tempCargo;
                        }
                        if ("OTP".equals(tempCargo.getAdtl_pay_typ())
                                || "1003".equals(tempCargo
                                        .getAdtl_pay_seq_num())) {
                            return tempCargo;
                        }
                        if ("WKD".equals(tempCargo.getAdtl_pay_typ())
                                || "1004".equals(tempCargo
                                        .getAdtl_pay_seq_num())) {
                            return tempCargo;
                        }
                        if ("HOL".equals(tempCargo.getAdtl_pay_typ())
                                || "1005".equals(tempCargo
                                        .getAdtl_pay_seq_num())) {
                            return tempCargo;
                        }
                        if ("OSP".equals(tempCargo.getAdtl_pay_typ())
                                || "1006".equals(tempCargo
                                        .getAdtl_pay_seq_num())) {
                            return tempCargo;
                        }
                        if ("TIP".equals(tempCargo.getAdtl_pay_typ())
                                || "1007".equals(tempCargo
                                        .getAdtl_pay_seq_num())) {
                            return tempCargo;
                        }
                        if ("COM".equals(tempCargo.getAdtl_pay_typ())
                                || "1008".equals(tempCargo
                                        .getAdtl_pay_seq_num())) {
                            return tempCargo;
                        }
                        appInEmplCargo = tempCargo;
                    }

                }

            }

            log(ILog.INFO,
                    "RMCJobIncomeEJBBean.splitEmplWage1() - END , Time Taken : "
                            + (System.currentTimeMillis() - startTime)
                            + AppConstants.SPACE + AppConstants.MILLISECONDS);
            return appInEmplCargo;
        } catch (final FwException fe) {
        	throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
            final FwException fe = createFwException(this.getClass().getName(),
                    "splitEmplWage", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }
    }

    /**
     * Split empl wage.
     *
     * @param wageColl the wage coll
     * @param seqNum the seq num
     * @return the AP p_ i n_ emp l_ a_ wag e_ cargo
     */
    public APP_IN_EMPL_A_WAGE_Cargo splitEmplWage(
            final APP_IN_EMPL_A_WAGE_Collection wageColl, final String seqNum) {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.splitEmplWage() - START");
        try {
            if (wageColl != null) {
                final int collSize = wageColl.size();
                APP_IN_EMPL_A_WAGE_Cargo tempCargo = null;
                for (int i = 0; i < collSize; i++) {
                    tempCargo = wageColl.getResult(i);
                    if (seqNum.equals(tempCargo.getAdtl_pay_seq_num())) {
                        return tempCargo;
                    }
                }
            }
            log(ILog.INFO,
                    "RMCJobIncomeEJBBean.splitEmplWage() - END , Time Taken : "
                            + (System.currentTimeMillis() - startTime)
                            + AppConstants.SPACE + AppConstants.MILLISECONDS);
            return null;
        } catch (final FwException fe) {
        	throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
            final FwException fe = createFwException(this.getClass().getName(),
                    "splitEmplWage", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }
    }

    /**
     * Erase job income changes.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */
    public void eraseJobIncomeChanges(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.eraseJobIncomeChanges() - START");
        try {
            log(ILog.INFO, "RMCJobIncomeEJBBean::eraseJobIncomeChanges:Start");
            final Map session = txnBean.getSession();
            final Map request = txnBean.getRequest();
            final Map pageCollection = txnBean.getPageCollection();
            final Map beforeColl = (Map) session
                    .get(FwConstants.BEFORE_COLLECTION);

            // Get RMCSessionBean from the session
            // Define IndvSeqNum and the SeqNum and Type and RowNum
            String indvSeqNum = null;
            String emplSeqNum = null;
            String emplType = null;

            // Get driver info.
            final int[] driverArray = (int[]) session
                    .get(FwConstants.RMC_DRIVER);

            // Get the APP_IN_EMPL_Collection from pageCollection.
            final JOBINCOME_Custom_Collection jobIncColl = (JOBINCOME_Custom_Collection) pageCollection
                    .get("JOBINCOME_Custom_Collection");
            final JOBINCOME_Custom_Cargo jobInCargo = jobIncColl.getResult(0);

            // Get the results from the APP_IN_EMPL_Collection
            final String appNum = (String) session.get(AppConstants.APP_NUMBER);
            indvSeqNum = jobInCargo.getIndv_seq_num();
            emplSeqNum = jobInCargo.getEmpl_seq_num();
            emplType = jobInCargo.getEmpl_typ();
            JOBINCOME_Custom_Cargo beforeJobInCargo = (JOBINCOME_Custom_Cargo) beforeColl
                    .get("JOB_CUSTOM_CARGO");

            final IndivTypeSeqBean indivTypeSeqBean = new IndivTypeSeqBean();
            indivTypeSeqBean.setIndivSeqNum(indvSeqNum);
            indivTypeSeqBean.setSeqNum(emplSeqNum);
            indivTypeSeqBean.setType(emplType);
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

            final JobIncomeBO jobIncBO = new JobIncomeBO();
            if (beforeJobInCargo == null
                    || jobInCargo.isDifferent(beforeJobInCargo) || !eraseData) {
                jobIncBO.validateEraseChanges();
                request.put(FwConstants.MESSAGE_LIST, jobIncBO.getMessageList());
                beforeJobInCargo = new JOBINCOME_Custom_Cargo();
                beforeJobInCargo.setIndv_seq_num(indvSeqNum);
                beforeJobInCargo.setEmpl_seq_num(emplSeqNum);
                beforeJobInCargo.setEmpl_typ(emplType);
                beforeColl.put("JOB_CUSTOM_CARGO", beforeJobInCargo);
                beforeColl.put(AppConstants.INDV_TYPE_SEQ_BEAN,
                        indivTypeSeqBean);
                txnBean.setPageCollection(beforeColl);
                return;
            }

            // delete record from database
            jobIncBO.deleteModifiedRecords(indvSeqNum, emplSeqNum, appNum,
                    emplType);
            String catEmpTyp = AppConstants.EMPL_REGULAR;
            if (AppConstants.EMPL_INKIND.equals(emplType)) {
                catEmpTyp = AppConstants.EMPL_INKIND;
            }

            // delete record from rmc selection profile
            final SortedSet rmcSelPrfl = (SortedSet) session
                    .get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
            categorySelectionProfileManager.removeSequenceDetail(rmcSelPrfl,
                    appNum, Short.parseShort(indvSeqNum),
                    Long.parseLong(emplSeqNum), catEmpTyp);
            final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
                    .get(AppConstants.RMC_IN_PRFL_MASTER);
            boolean rmcPrflNotRequeired = false;
            // here we need to check we have no entrys in rmcPrfl for the job
            // income detail
            // as well as we need to check
            if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
                if (rmcResponseProfileManager.isAppResponseNotRequired(
                        rmcInPrflColl, IRMCResponseProfileManager.REGULAR_EMPL)) {
                    if (rmcResponseProfileManager.isAppResponseNotRequired(
                            rmcInPrflColl,
                            IRMCResponseProfileManager.REGULAR_EMPL)) {
                        rmcPrflNotRequeired = true;
                    }
                }
            } else {
                rmcPrflNotRequeired = true;
            }

            final String[] pageId = { "ARJID" };

            final Map catType = new HashMap();
            catType.put(AppConstants.EMPL_REGULAR, AppConstants.EMPL_REGULAR);

            if (categorySelectionProfileManager.isRemoved(rmcSelPrfl, catType)
                    && rmcPrflNotRequeired) {
                driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
                        pageId, driverArray, appNum);
            }
            session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER, rmcSelPrfl);
            driverManager.makeRequired(FwConstants.RMC_DRIVER,
                    AppConstants.ARJIS, driverArray, appNum);

            // End
            log(ILog.INFO, "RMCJobIncomeEJBBean::eraseJobIncomeChanges:End");
        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("eraseJobIncomeChanges");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "eraseJobIncomeChanges", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.eraseJobIncomeChanges() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Erase in kind income changes.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */
    public void eraseInKindIncomeChanges(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.eraseInKindIncomeChanges() - START");
        try {
            log(ILog.INFO,
                    "RMCJobIncomeEJBBean::eraseInKindIncomeChanges:Start");
            final Map session = txnBean.getSession();
            final Map request = txnBean.getRequest();
            final Map pageCollection = txnBean.getPageCollection();
            final Map beforeColl = (Map) session
                    .get(FwConstants.BEFORE_COLLECTION);

            // Get RMCSessionBean from the session
            // Define IndvSeqNum and the SeqNum and Type and RowNum
            String indvSeqNum = null;
            String emplSeqNum = null;
            String emplType = null;

            // Get driver info.
            final int[] driverArray = (int[]) session
                    .get(FwConstants.RMC_DRIVER);

            // Get the APP_IN_EMPL_Collection from pageCollection.
            final JOBINCOME_Custom_Collection jobIncColl = (JOBINCOME_Custom_Collection) pageCollection
                    .get("JOBINCOME_Custom_Collection");
            final JOBINCOME_Custom_Cargo jobInCargo = jobIncColl.getResult(0);

            // Get the results from the APP_IN_EMPL_Collection
            final String appNum = (String) session.get(AppConstants.APP_NUMBER);
            indvSeqNum = jobInCargo.getIndv_seq_num();
            emplSeqNum = jobInCargo.getEmpl_seq_num();
            emplType = jobInCargo.getEmpl_typ();
            JOBINCOME_Custom_Cargo beforeJobInCargo = (JOBINCOME_Custom_Cargo) beforeColl
                    .get("JOB_CUSTOM_CARGO");

            final IndivTypeSeqBean indivTypeSeqBean = new IndivTypeSeqBean();
            indivTypeSeqBean.setIndivSeqNum(indvSeqNum);
            indivTypeSeqBean.setSeqNum(emplSeqNum);
            indivTypeSeqBean.setType(emplType);
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

            final JobIncomeBO jobIncBO = new JobIncomeBO();
            if (beforeJobInCargo == null
                    || jobInCargo.isDifferent(beforeJobInCargo) || !eraseData) {
                jobIncBO.validateEraseChanges();
                request.put(FwConstants.MESSAGE_LIST, jobIncBO.getMessageList());
                beforeJobInCargo = new JOBINCOME_Custom_Cargo();
                beforeJobInCargo.setIndv_seq_num(indvSeqNum);
                beforeJobInCargo.setEmpl_seq_num(emplSeqNum);
                beforeJobInCargo.setEmpl_typ(emplType);
                beforeColl.put("JOB_CUSTOM_CARGO", beforeJobInCargo);
                beforeColl.put(AppConstants.INDV_TYPE_SEQ_BEAN,
                        indivTypeSeqBean);
                txnBean.setPageCollection(beforeColl);
                return;
            }

            // delete record from database
            jobIncBO.deleteModifiedRecords(indvSeqNum, emplSeqNum, appNum,
                    emplType);
            String catEmpTyp = AppConstants.EMPL_REGULAR;
            if (AppConstants.EMPL_INKIND.equals(emplType)) {
                catEmpTyp = AppConstants.EMPL_INKIND;
            }

            // delete record from rmc selection profile
            final SortedSet rmcSelPrfl = (SortedSet) session
                    .get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
            categorySelectionProfileManager.removeSequenceDetail(rmcSelPrfl,
                    appNum, Short.parseShort(indvSeqNum),
                    Long.parseLong(emplSeqNum), catEmpTyp);
            final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
                    .get(AppConstants.RMC_IN_PRFL_MASTER);
            boolean rmcPrflNotRequeired = false;
            // here we need to check we have no entrys in rmcPrfl for the job
            // income detail
            // as well as we need to check
            if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
                if (rmcResponseProfileManager.isAppResponseNotRequired(
                        rmcInPrflColl, IRMCResponseProfileManager.JOB_IN_KIND)) {
                    if (rmcResponseProfileManager.isAppResponseNotRequired(
                            rmcInPrflColl,
                            IRMCResponseProfileManager.JOB_IN_KIND)) {
                        rmcPrflNotRequeired = true;
                    }
                }
            } else {
                rmcPrflNotRequeired = true;
            }

            final String[] pageId = { AppConstants.ARIKI };

            final Map catType = new HashMap();
            catType.put(AppConstants.EMPL_INKIND, AppConstants.EMPL_INKIND);

            if (categorySelectionProfileManager.isRemoved(rmcSelPrfl, catType)
                    && rmcPrflNotRequeired) {
                driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
                        pageId, driverArray, appNum);
            }
            session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER, rmcSelPrfl);
            driverManager.makeRequired(FwConstants.RMC_DRIVER,
                    AppConstants.ARJIS, driverArray, appNum);

            // End
            log(ILog.INFO, "RMCJobIncomeEJBBean::eraseInKindIncomeChanges:End");
        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("eraseInKindIncomeChanges");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "eraseInKindIncomeChanges", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.eraseInKindIncomeChanges() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Comment here.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */
    public void editSelfEmploymentDetails(final FwTransaction txnBean)
            throws javax.ejb.EJBException {

        final long startTime = System.currentTimeMillis();
        log(ILog.INFO,
                "RMCJobIncomeEJBBean.editSelfEmploymentDetails() - START");
        try {
            log(ILog.INFO,
                    "RMCJobIncomeEJBBean::editSelfEmploymentDetails:Start");
            final Map session = txnBean.getSession();
            final Map pageCollection = txnBean.getPageCollection();
            // Get driver info.
            final int[] driverArray = (int[]) session
                    .get(FwConstants.RMC_DRIVER);
            // Get the APP_IN_EMPL_Collection from pageCollection.
            final APP_IN_SELFE_Collection appInSelfEColl = (APP_IN_SELFE_Collection) pageCollection
                    .get("APP_IN_SELFE_Collection");
            final APP_IN_SELFE_Cargo appInSelfECargo = appInSelfEColl
                    .getCargo(0);

            final IndivTypeSeqBean seqBean = new IndivTypeSeqBean();
            seqBean.setIndivSeqNum(appInSelfECargo.getIndv_seq_num());
            seqBean.setSeqNum(appInSelfECargo.getSeq_num());
            seqBean.setType(AppConstants.EMPL_SELF);

            // setting user end indicator

            if ("RE".equals(appInSelfECargo.getSrc_app_ind())) {
                seqBean.setUserEndInd(FwConstants.ONE);
            } else {
                seqBean.setUserEndInd(FwConstants.ZERO);
            }

            pageCollection.put(FwConstants.DETAIL_KEY_BEAN, seqBean);
            // Get App Number
            final String appNum = (String) session.get(AppConstants.APP_NUMBER);
            // Set RMC page Job Income Details make required
            driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARJSD",
                    driverArray, appNum);
            driverManager.makeRequired(FwConstants.RMC_DRIVER,
                    AppConstants.ARJIS, driverArray, appNum);
            // End
            log(ILog.INFO, "RMCJobIncomeEJBBean::editSelfEmploymentDetails:End");

        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("editSelfEmploymentDetails");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "editSelfEmploymentDetails", e);

            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.editSelfEmploymentDetails() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Comment here.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */
    public void eraseSelfEmploymentDetails(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO,
                "RMCJobIncomeEJBBean.eraseSelfEmploymentDetails() - START");
        try {
            log(ILog.INFO,
                    "RMCJobIncomeEJBBean::eraseSelfEmploymentDetails:Start");
            final Map session = txnBean.getSession();
            final Map request = txnBean.getRequest();
            final Map pageCollection = txnBean.getPageCollection();
            final Map beforeColl = (Map) session
                    .get(FwConstants.BEFORE_COLLECTION);

            // Get RMCSessionBean from the session

            // Define IndvSeqNum and the SeqNum and Type and RowNum
            String indvSeqNum = null;
            String seqNum = null;
            String selfEmplType = null;
            String srcAppInd = null;

            // Get driver info.
            final int[] driverArray = (int[]) session
                    .get(FwConstants.RMC_DRIVER);

            // Get the APP_IN_EMPL_Collection from pageCollection.
            final APP_IN_SELFE_Collection appInSelfEColl = (APP_IN_SELFE_Collection) pageCollection
                    .get("APP_IN_SELFE_Collection");
            final APP_IN_SELFE_Cargo appInSelfECargo = appInSelfEColl
                    .getCargo(0);

            // Get the results from the APP_IN_EMPL_Collection
            final String appNum = (String) session.get(AppConstants.APP_NUMBER);

            final SortedSet rmcSelPrfl = (SortedSet) session
                    .get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
            final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
                    .get(AppConstants.RMC_IN_PRFL_MASTER);

            indvSeqNum = appInSelfECargo.getIndv_seq_num();
            seqNum = appInSelfECargo.getSeq_num();
            selfEmplType = appInSelfECargo.getSelf_empl_typ();
            srcAppInd = appInSelfECargo.getSrc_app_ind();
            APP_IN_SELFE_Cargo beforeAppInSelfECargo = (APP_IN_SELFE_Cargo) beforeColl
                    .get("APP_IN_SELFE_CARGO");

            // Setting IndivSeqTypeBean
            final IndivTypeSeqBean indivTypeSeqBean = new IndivTypeSeqBean();
            indivTypeSeqBean.setIndivSeqNum(indvSeqNum);
            indivTypeSeqBean.setSeqNum(seqNum);
            indivTypeSeqBean.setType(selfEmplType);
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

            final SelfEmploymentBO selfBO = new SelfEmploymentBO();
            if (beforeAppInSelfECargo == null
                    || compareAppInSelfECargos(appInSelfECargo,
                            beforeAppInSelfECargo) || !eraseData) {
                final PeopleHandler peopleHandler = (PeopleHandler) session
                        .get(AppConstants.INDIV_MASTER_HANDLER);

                final String name = peopleHandler.getFirstName(indvSeqNum);
                selfBO.validateErase(name);
                request.put(FwConstants.MESSAGE_LIST, selfBO.getMessageList());
                beforeAppInSelfECargo = new APP_IN_SELFE_Cargo();
                beforeAppInSelfECargo.setIndv_seq_num(indvSeqNum);
                beforeAppInSelfECargo.setSeq_num(seqNum);
                beforeAppInSelfECargo.setSelf_empl_typ(selfEmplType);
                beforeAppInSelfECargo.setSrc_app_ind(srcAppInd);
                beforeColl.put("APP_IN_SELFE_CARGO", beforeAppInSelfECargo);
                beforeColl.put(AppConstants.INDV_TYPE_SEQ_BEAN,
                        indivTypeSeqBean);
                txnBean.setPageCollection(beforeColl);
                return;
            }

            selfBO.deleteRecords(indvSeqNum, seqNum, appNum);

            final Map catType = new HashMap();
            catType.put(AppConstants.EMPL_SELF, AppConstants.EMPL_SELF);

            if (beforeColl != null) {
                int count = 0;
                APP_IN_SELFE_Collection selfEColl = null;
                APP_IN_SELFE_Cargo selfECargo = null;

                selfEColl = (APP_IN_SELFE_Collection) beforeColl
                        .get("APP_IN_SELF_EMPL_Collection");

                if (selfEColl != null && !selfEColl.isEmpty()) {
                    final int selfECollSize = selfEColl.size();
                    for (int i = 0; i < selfECollSize; i++) {
                        selfECargo = selfEColl.getCargo(i);
                        if (selfECargo.getIndv_seq_num().equals(indvSeqNum)
                                && AppConstants.RMC_NEW_RECORD_IND
                                .equals(selfECargo.getSrc_app_ind())) {
                            count++;
                        }
                    }
                }
                if (count == 1) {
                    // now we need to make that profile required
                    final RMC_IN_PRFL_Cargo rmcResCargo = rmcResponseProfileManager
                            .getProfile(rmcInPrflColl, indvSeqNum);
                    rmcResponseProfileManager.makeAbsoluteNotRequired(
                            IRMCResponseProfileManager.SELF_EMPLOYMENT,
                            rmcResCargo, true);
                }
            }

            boolean rmcPrflNotRequired = false;
            // here we need to check we have no entrys in rmcPrfl for the job
            // income detail
            // as well as we need to check
            if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
                if (rmcResponseProfileManager.isAppResponseNotRequired(
                        rmcInPrflColl,
                        IRMCResponseProfileManager.SELF_EMPLOYMENT)) {
                    rmcPrflNotRequired = true;
                }
            } else {
                rmcPrflNotRequired = true;
            }

            if (categorySelectionProfileManager.isEmpty(rmcSelPrfl, catType)
                    && rmcPrflNotRequired) {
                driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
                        "ARJSD", driverArray, appNum);
            }
            session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER, rmcSelPrfl);
            driverManager.makeRequired(FwConstants.RMC_DRIVER,
                    AppConstants.ARJIS, driverArray, appNum);
            log(ILog.INFO,
                    "RMCJobIncomeEJBBean::eraseSelfEmploymentDetails:End");

        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("eraseSelfEmploymentDetails");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "eraseSelfEmploymentDetails", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }
        log(ILog.INFO,
                "RMCJobIncomeEJBBean.eraseSelfEmploymentDetails() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Erase self employment changes.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */
    public void eraseSelfEmploymentChanges(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO,
                "RMCJobIncomeEJBBean.eraseSelfEmploymentChanges() - START");
        try {
            log(ILog.INFO,
                    "RMCJobIncomeEJBBean::eraseSelfEmploymentChanges:Start");
            final Map session = txnBean.getSession();
            final Map request = txnBean.getRequest();
            final Map pageCollection = txnBean.getPageCollection();
            final Map beforeColl = (Map) session
                    .get(FwConstants.BEFORE_COLLECTION);

            // Define IndvSeqNum and the SeqNum and Type and RowNum
            String indvSeqNum = null;
            String seqNum = null;
            String selfEmplType = null;
            String srcAppInd = null;

            // Get driver info.
            final int[] driverArray = (int[]) session
                    .get(FwConstants.RMC_DRIVER);

            // Get the results from the APP_IN_EMPL_Collection
            final String appNum = (String) session.get(AppConstants.APP_NUMBER);

            // Get the APP_IN_EMPL_Collection from pageCollection.
            final APP_IN_SELFE_Collection appInSelfEColl = (APP_IN_SELFE_Collection) pageCollection
                    .get("APP_IN_SELFE_Collection");
            final APP_IN_SELFE_Cargo appInSelfECargo = appInSelfEColl
                    .getCargo(0);

            indvSeqNum = appInSelfECargo.getIndv_seq_num();
            seqNum = appInSelfECargo.getSeq_num();
            selfEmplType = appInSelfECargo.getSelf_empl_typ();
            srcAppInd = appInSelfECargo.getSrc_app_ind();
            APP_IN_SELFE_Cargo beforeAppInSelfECargo = (APP_IN_SELFE_Cargo) beforeColl
                    .get("APP_IN_SELFE_CARGO");

            // Setting IndivSeqTypeBean
            final IndivTypeSeqBean indivTypeSeqBean = new IndivTypeSeqBean();
            indivTypeSeqBean.setIndivSeqNum(indvSeqNum);
            indivTypeSeqBean.setSeqNum(seqNum);
            indivTypeSeqBean.setType(selfEmplType);
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

            final SelfEmploymentBO selfBO = new SelfEmploymentBO();
            if (beforeAppInSelfECargo == null
                    || compareAppInSelfECargos(appInSelfECargo,
                            beforeAppInSelfECargo) || !eraseData) {
            	final PeopleHandler peopleHandler = (PeopleHandler) session
                        .get(AppConstants.INDIV_MASTER_HANDLER);

                final String name = peopleHandler.getFirstName(indvSeqNum);
                selfBO.validateEraseChanges(name);
                request.put(FwConstants.MESSAGE_LIST, selfBO.getMessageList());
                beforeAppInSelfECargo = new APP_IN_SELFE_Cargo();
                beforeAppInSelfECargo.setIndv_seq_num(indvSeqNum);
                beforeAppInSelfECargo.setSeq_num(seqNum);
                beforeAppInSelfECargo.setSelf_empl_typ(selfEmplType);
                beforeAppInSelfECargo.setSrc_app_ind(srcAppInd);
                beforeColl.put("APP_IN_SELFE_CARGO", beforeAppInSelfECargo);
                beforeColl.put(AppConstants.INDV_TYPE_SEQ_BEAN,
                        indivTypeSeqBean);
                txnBean.setPageCollection(beforeColl);
                return;
            }

            selfBO.deleteRecords(indvSeqNum, seqNum, appNum);

            final String catEmpTyp = AppConstants.EMPL_SELF;

            final SortedSet rmcSelPrfl = (SortedSet) session
                    .get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
            categorySelectionProfileManager.removeSequenceDetail(rmcSelPrfl,
                    appNum, Short.parseShort(indvSeqNum),
                    Long.parseLong(seqNum), catEmpTyp);
            final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
                    .get(AppConstants.RMC_IN_PRFL_MASTER);
            boolean rmcPrflNotRequired = false;
            // here we need to check we have no entrys in rmcPrfl for the job
            // income detail
            // as well as we need to check
            if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
                if (rmcResponseProfileManager.isAppResponseNotRequired(
                        rmcInPrflColl,
                        IRMCResponseProfileManager.SELF_EMPLOYMENT)) {
                    rmcPrflNotRequired = true;
                }
            } else {
                rmcPrflNotRequired = true;
            }

            final Map catType = new HashMap();
            catType.put(AppConstants.EMPL_SELF, AppConstants.EMPL_SELF);
            if (categorySelectionProfileManager.isRemoved(rmcSelPrfl, catType)
                    && rmcPrflNotRequired) {
                driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
                        "ARJSD", driverArray, appNum);
            }
            session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER, rmcSelPrfl);
            driverManager.makeRequired(FwConstants.RMC_DRIVER,
                    AppConstants.ARJIS, driverArray, appNum);

            // End
            log(ILog.INFO,
                    "RMCJobIncomeEJBBean::eraseSelfEmploymentChanges:End");
        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("eraseSelfEmploymentChanges");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "eraseSelfEmploymentChanges", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.eraseSelfEmploymentChanges() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Comment here.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */
    public void endSelfEmploymentDetails(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.endSelfEmploymentDetails() - START");
        try {
            log(ILog.INFO,
                    "RMCJobIncomeEJBBean::endSelfEmploymentDetails:Start");
            final Map session = txnBean.getSession();
            final Map pageCollection = txnBean.getPageCollection();
            // Get driver info.
            final int[] driverArray = (int[]) session
                    .get(FwConstants.RMC_DRIVER);
            // Get the APP_IN_EMPL_Collection from pageCollection.
            final APP_IN_SELFE_Collection appInSelfEColl = (APP_IN_SELFE_Collection) pageCollection
                    .get("APP_IN_SELFE_Collection");
            final APP_IN_SELFE_Cargo appInSelfECargo = appInSelfEColl
                    .getCargo(0);

            final IndivTypeSeqBean seqBean = new IndivTypeSeqBean();
            seqBean.setIndivSeqNum(appInSelfECargo.getIndv_seq_num());
            seqBean.setSeqNum(appInSelfECargo.getSeq_num());
            seqBean.setType(AppConstants.EMPL_SELF);
            seqBean.setUserEndInd(FwConstants.ONE);
            pageCollection.put(FwConstants.DETAIL_KEY_BEAN, seqBean);
            // Get App Number
            final String appNum = (String) session.get(AppConstants.APP_NUMBER);
            // Set RMC page Job Income Details make required
            driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARJSD",
                    driverArray, appNum);
            driverManager.makeRequired(FwConstants.RMC_DRIVER,
                    AppConstants.ARJIS, driverArray, appNum);
            // End
            log(ILog.INFO, "RMCJobIncomeEJBBean::endSelfEmploymentDetails:End");

        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("endSelfEmploymentDetails");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "endSelfEmploymentDetails", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.endSelfEmploymentDetails() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Comment here.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */
    public void addSelfEmploymentDetails(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.addSelfEmploymentDetails() - START");
        try {
            final Map session = txnBean.getSession();
            final Map request = txnBean.getRequest();
            final Map pageCollection = txnBean.getPageCollection();
            // get cargo determining user selection
            final String selfEmplSeq = request.get("firstName_selfEmplIncome") != null ? (String) request
                    .get("firstName_selfEmplIncome") : FwConstants.EMPTY_STRING;

                    final SelfEmploymentBO selfEBo = new SelfEmploymentBO();
                    // validate selections
                    if (selfEmplSeq == null
                            || AppConstants.SELECT_DEFAULT_OPTION.equals(selfEmplSeq)) {
                        selfEBo.validateAdd();
                        // add validation message and return
                        request.put(FwConstants.MESSAGE_LIST, selfEBo.getMessageList());
                        txnBean.setPageCollection((Map) session
                                .get(FwConstants.BEFORE_COLLECTION));
                        return;
                    }
                    final String appNum = (String) session.get(AppConstants.APP_NUMBER);

                    final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
                    indivSeqBean.setIndivSeqNum(selfEmplSeq);
                    indivSeqBean.setSeqNum(FwConstants.ZERO);
                    indivSeqBean.setType(AppConstants.EMPL_SELF);

                    pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

                    // set driver status
                    final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
                    driverManager.makeAddNew(FwConstants.RMC_DRIVER, "ARJSD", driver,
                            appNum);
                    driverManager.makeRequired(FwConstants.RMC_DRIVER,
                            AppConstants.ARJIS, driver, appNum);
                    session.put(FwConstants.RMC_DRIVER, driver);

        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("addSelfEmploymentDetails");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "addSelfEmploymentDetails", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.addSelfEmploymentDetails() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Comment here.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */
    public void loadSelfEmploymentDetails(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO,
                "RMCJobIncomeEJBBean.loadSelfEmploymentDetails() - START");
        try {
            final Map request = txnBean.getRequest();
            final Map session = txnBean.getSession();
            final Map pageCollection = txnBean.getPageCollection();

            APP_IN_SELFE_Collection appInSelfeColl;
            final String appNumber = (String) session
                    .get(AppConstants.APP_NUMBER);
            final String pageId = (String) request
                    .get(FwConstants.CURRENT_PAGE_ID);
            final int[] driverArray = (int[]) session
                    .get(FwConstants.RMC_DRIVER);
            final int pageStatus = driverManager.getAFBStatus(
                    FwConstants.RMC_DRIVER, pageId, driverArray);
            // get category selection profile
            SortedSet categorySelectionProfile = (SortedSet) session
                    .get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
            RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
                    .get(AppConstants.RMC_IN_PRFL_MASTER);
            final String previousPageId = (String) request
                    .get(FwConstants.PREVIOUS_PAGE_ID);
            final SelfEmploymentBO selfEmploymentBO = new SelfEmploymentBO();
            final short[] responseType = new short[] { IRMCResponseProfileManager.SELF_EMPLOYMENT };
            SortedSet selfEmploymentProfile = null;
            final Map incomeType = new HashMap<String, String>();
            incomeType.put("S", "S");

            if (pageStatus == FwConstants.DRIVER_REQUIRED
                    || pageStatus == FwConstants.DRIVER_VISIT_AGAIN
                    && categorySelectionProfileManager.isEmpty(
                            categorySelectionProfile, incomeType)) {
                categorySelectionProfile = categorySelectionProfileManager
                        .loadCategoryChangeSelectionProfile(appNumber,
                                AppConstants.RMC_CAT_EMP_PRFL);
            } else if (pageStatus == FwConstants.DRIVER_COMPLETE
                    && !pageId.equals(previousPageId)
                    && categorySelectionProfileManager.isEmpty(
                            categorySelectionProfile, incomeType)) {
                categorySelectionProfile = categorySelectionProfileManager
                        .loadCategoryChangeSelectionProfile(appNumber,
                                AppConstants.RMC_CAT_EMP_PRFL);
            }

            if (!pageId.equals(previousPageId)) {
                selfEmploymentProfile = createPageProfile(
                        categorySelectionProfile, rmcInPrflColl, responseType);

                if (pageStatus != FwConstants.DRIVER_REQUIRED) {
                    final APP_IN_SELFE_Collection rnSelfeColl = selfEmploymentBO
                            .getSelfEmploymentDetails(appNumber,
                                    AppConstants.RMC_NEW_RECORD_IND);
                    if (rnSelfeColl != null && !rnSelfeColl.isEmpty()) {
                        APP_IN_SELFE_Cargo rnSelfeCargo = null;
                        final int newEmplCollSize = rnSelfeColl.size();
                        for (int i = 0; i < newEmplCollSize; i++) {
                            rnSelfeCargo = rnSelfeColl.getCargo(i);
                            categorySelectionProfileManager
                            .insertExistingSequenceDetail(
                                    selfEmploymentProfile, null, null,
                                    Short.parseShort(rnSelfeCargo
                                            .getIndv_seq_num()), Long
                                            .parseLong(rnSelfeCargo
                                                    .getSeq_num()),
                                                    AppConstants.EMPL_SELF);
                        }
                    }
                }
                if (pageStatus == FwConstants.DRIVER_REQUIRED
                        || pageStatus == FwConstants.DRIVER_VISIT_AGAIN) {
                    // set the current record indicator to the first one
                    categorySelectionProfileManager
                    .setCurrentRecordIndToFirst(selfEmploymentProfile);
                }
                if (pageStatus == FwConstants.DRIVER_COMPLETE) {
                    // set the current record indicator to the end of the detail
                    // bean
                    categorySelectionProfileManager
                    .setCurrentRecordIndToLast(selfEmploymentProfile);
                }
                // create add new sorted set
                // we need to remove the vallues from the session
                session.remove(FwConstants.BEFORE_COLLECTION);
            } else {
                // catAddNewProfile get it from the before collection
                final Map beforeColl = (Map) session
                        .get(FwConstants.BEFORE_COLLECTION);
                selfEmploymentProfile = (SortedSet) beforeColl
                        .get(AppConstants.RMC_CATEGORY_PAGE_PRFL);
            }

            final IndivTypeSeqBean indivSeqBean = (IndivTypeSeqBean) pageCollection
                    .get(FwConstants.DETAIL_KEY_BEAN);
            // if details key bean not null means this bean is comming from the
            // summary page
            if (indivSeqBean != null) {
                final CategorySequenceDetail categorySeqDetail1 = categorySelectionProfileManager
                        .getCategorySequenceDetail(
                                selfEmploymentProfile,
                                Short.parseShort(indivSeqBean.getIndivSeqNum()),
                                Long.parseLong(indivSeqBean.getSeqNum()),
                                indivSeqBean.getType());
                if (categorySeqDetail1 != null) {
                    if (categorySeqDetail1.getUserEndSelectionInd() != Short
                            .parseShort(indivSeqBean.getUserEndInd())) {
                        categorySelectionProfileManager
                        .updateUserEndSelInd(
                                selfEmploymentProfile,
                                appNumber,
                                Short.parseShort(indivSeqBean
                                        .getIndivSeqNum()),
                                        Long.parseLong(indivSeqBean.getSeqNum()),
                                        indivSeqBean.getType(), Short
                                        .parseShort(indivSeqBean
                                                .getUserEndInd()));
                    }
                    categorySelectionProfileManager.makeSequenceDetailRequired(
                            selfEmploymentProfile, null,
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
                        // now we need to make required the employment
                        if (AppConstants.EMPL_SELF.equals(indivSeqBean
                                .getType())) {
                            rmcResponseProfileManager.makeAddNew(
                                    IRMCResponseProfileManager.SELF_EMPLOYMENT,
                                    rmcInPrflCargo, true);
                        }
                        categorySelectionProfileManager
                        .insertSequenceDetail(selfEmploymentProfile,
                                appNumber,  AppConstants.RMC_CAT_EMP_PRFL, Short
                                .parseShort(indivSeqBean
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
                        .insertExistingSequenceDetail(
                                selfEmploymentProfile,
                                null,
                                AppConstants.RMC_CAT_EMP_PRFL,
                                Short.parseShort(indivSeqBean
                                        .getIndivSeqNum()),
                                        Long.parseLong(indivSeqBean.getSeqNum()),
                                        indivSeqBean.getType(), Short
                                        .parseShort(userEndInd));
                        categorySelectionProfileManager
                        .makeSequenceDetailRequired(
                                selfEmploymentProfile,
                                null,
                                Short.parseShort(indivSeqBean
                                        .getIndivSeqNum()),
                                        Long.parseLong(indivSeqBean.getSeqNum()),
                                        indivSeqBean.getType());

                        categorySelectionProfileManager
                        .insertExistingSequenceDetail(
                                categorySelectionProfile,
                                appNumber,
                                AppConstants.RMC_CAT_EMP_PRFL,
                                Short.parseShort(indivSeqBean
                                        .getIndivSeqNum()),
                                        Long.parseLong(indivSeqBean.getSeqNum()),
                                        indivSeqBean.getType(), Short
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
                session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER,
						categorySelectionProfile);
            }

            pageCollection.put(AppConstants.RMC_CATEGORY_PAGE_PRFL,
                    selfEmploymentProfile);
            CategorySequenceDetail categorySeqDetail = categorySelectionProfileManager
                    .getCurrentSequenceDetail(selfEmploymentProfile);
            if (categorySeqDetail == null) {
                categorySeqDetail = categorySelectionProfileManager
                        .getNextSequenceDetail(selfEmploymentProfile);
            }

            final String categoryType = categorySeqDetail.getCategoryType();
            final String categorySeqNum = Long.toString(categorySeqDetail
                    .getCategorySequence());
            final String indvSeqNum = Short.toString(categorySeqDetail
                    .getIndividualSequence());
            Short.toString(categorySeqDetail.getUserEndSelectionInd());

            appInSelfeColl = selfEmploymentBO.loadSelfEmploymentDetails(
                    appNumber, indvSeqNum, categorySeqNum);
            pageCollection.put("APP_IN_SELFE_Collection", appInSelfeColl);

            APP_IN_SELFE_Cargo appInSelfeCargo = null;
            String pageMode = null;

            if (appInSelfeColl != null && !appInSelfeColl.isEmpty()) {
                appInSelfeCargo = appInSelfeColl.getCargo(0);
            }

            APP_IN_SELFE_Cargo cwwSelfeCargo = splitEmplColl(appInSelfeColl,
                    AppConstants.CWW_RECORD_IND);
            if (cwwSelfeCargo == null) {
                cwwSelfeCargo = new APP_IN_SELFE_Cargo();
            }

            pageCollection.put("CWW_CARGO", cwwSelfeCargo);

            splitEmplColl(appInSelfeColl, AppConstants.RMC_NEW_RECORD_IND);
            if (appInSelfeCargo != null
                    && ("CW".equalsIgnoreCase(appInSelfeCargo.getSrc_app_ind()) || "RM"
                            .equalsIgnoreCase(appInSelfeCargo.getSrc_app_ind()))
                            && categorySeqDetail.getUserEndSelectionInd() == 0) {
                pageMode = "C";
            } else if (categorySeqDetail.getUserEndSelectionInd() == 1) {
                pageMode = "E";
            } else {
                pageMode = FwConstants.NO;
            }

            char typeStatus = 'N';
            String showLoopingQuestionFlag = FwConstants.YES;

            typeStatus = categorySeqDetail.getStatus();
            if (typeStatus == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
                    || typeStatus == IRMCResponseProfileManager.STATUS_COMPLETE) {
                showLoopingQuestionFlag = FwConstants.NO;

            }

            pageCollection.put(AppConstants.SHOW_LOOPING_QUESTION,
                    showLoopingQuestionFlag);

            pageCollection.put("CATEGORY_TYPE", categoryType);
            pageCollection.put("PAGE_MODE", pageMode);

            // set first name to page collection
            final PeopleHandler peopleHandler = (PeopleHandler) session
                    .get(AppConstants.INDIV_MASTER_HANDLER);
            pageCollection.put(AppConstants.FIRST_NAME,
                    peopleHandler.getFirstName(indvSeqNum));

            request.remove(AppConstants.LOOPING_QUESTION);
            // Add the page collection to before collection
            if (session.get(FwConstants.BEFORE_COLLECTION) != null) {
                ((Map) session.get(FwConstants.BEFORE_COLLECTION))
                .putAll(pageCollection);
            } else {
                final Map beforeColl = new HashMap();
                beforeColl.putAll(pageCollection);
                session.put(FwConstants.BEFORE_COLLECTION, beforeColl);
            }

        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("loadSelfEmploymentDetails");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "loadSelfEmploymentDetails", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.loadSelfEmploymentDetails() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Comment here.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */
    public void storeSelfEmploymentDetails(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO,
                "RMCJobIncomeEJBBean.storeSelfEmploymentDetails() - START");
        try {
            APP_IN_SELFE_Cargo appInSelfeCargo = null;
            APP_IN_SELFE_Cargo beforeSelfeCargo = null;
            String sourceAppIndicator = null;
            String recordInd = null;
            long seqNum = 0;
            boolean appInSelfeUpdate = false;
            boolean diff = false;
            String changeEffDate = null;
            ARJSDValidator validator = null;
            final Map request = txnBean.getRequest();
            final Map session = txnBean.getSession();
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
            // get the page profile
            final SortedSet selfeEmploymentProfile = (SortedSet) beforeColl
                    .get(AppConstants.RMC_CATEGORY_PAGE_PRFL);
            final APP_IN_SELFE_Collection pageCollAppInSelfeColl = (APP_IN_SELFE_Collection) pageCollection
                    .get("APP_IN_SELFE_Collection");
            final APP_IN_SELFE_Collection beforeCollAppInSelfeColl = (APP_IN_SELFE_Collection) beforeColl
                    .get("APP_IN_SELFE_Collection");

            if (pageCollAppInSelfeColl != null
                    && !pageCollAppInSelfeColl.isEmpty()) {
                appInSelfeCargo = pageCollAppInSelfeColl.getCargo(0);
            }
            final String firstName = (String) beforeColl
                    .get(AppConstants.FIRST_NAME);
            final String pageMode = (String) beforeColl.get("PAGE_MODE");
            beforeColl.get("CATEGORY_TYPE");
            // Run Validations
            final SelfEmploymentBO selfEmploymentBO = new SelfEmploymentBO();
            /*
             * VALIDATION CODE TO BE ADDED
             */
            final String backToMyAccess = (String) request
                    .get(AppConstants.BACK_TO_MY_ACCESS_BUTTON);
            boolean reqInd = false;
            if (appInSelfeCargo != null) {
                validator = new ARJSDValidator();
                if (backToMyAccess == null) {
                    final String loopingQuestionResponse = (String) request
                            .get(AppConstants.LOOPING_QUESTION);
                    final String loopingQuestionShown = (String) beforeColl
                            .get(AppConstants.SHOW_LOOPING_QUESTION);
                    boolean isLoopingAnswered = false;
                    if (loopingQuestionResponse != null) {
                        if (AppConstants.YES.equals(loopingQuestionResponse)
                                || AppConstants.NO
                                .equals(loopingQuestionResponse)) {
                            isLoopingAnswered = true;
                        }
                    }
                    if ("C".equals(pageMode)) {
                        validator.validateRMCChangeSelfEmpDetails(
                                appInSelfeCargo, firstName, isLoopingAnswered,
                                loopingQuestionShown);
                    } else if ("E".equals(pageMode)) {
                        validator.validateRMCEndSelfEmpDetails(appInSelfeCargo);
                    } else {
                        validator.validateRMCAddSelfEmpDetails(appInSelfeCargo,
                                firstName, isLoopingAnswered,
                                loopingQuestionShown);
                    }
                }
                if (checkBackToMyAccessSelected(request)
                        || validator.hasMessages()) {
                    if (backToMyAccess == null) {
                        request.put(FwConstants.MESSAGE_LIST,
                                validator.getMessageList());
                    }

                    pageCollection.put(AppConstants.FIRST_NAME, firstName);
                    if (request.get(AppConstants.LOOPING_QUESTION) != null) {
                        request.put(AppConstants.LOOPING_QUESTION,
                                request.get(AppConstants.LOOPING_QUESTION));
                    }
                    pageCollection.put(AppConstants.SHOW_LOOPING_QUESTION,
                            beforeColl.get(AppConstants.SHOW_LOOPING_QUESTION));
                    pageCollection
                    .put("PAGE_MODE", beforeColl.get("PAGE_MODE"));
                    pageCollection
                    .put("CWW_CARGO", beforeColl.get("CWW_CARGO"));
                    return;
                }
            }
            final CategorySequenceDetail categorySeqDetailBean = categorySelectionProfileManager
                    .getCurrentSequenceDetail(selfeEmploymentProfile);
            final String indvSeqNum = String.valueOf(categorySeqDetailBean
                    .getIndividualSequence());

            // Setting the app Number to appInSelfe cargo
            appInSelfeCargo.setApp_num(appNumber);
            if (appInSelfeCargo.getChg_eff_dt() != null
                    && appInSelfeCargo.getChg_eff_dt().trim().length() != 0
                    && !AppConstants.HIGH_DATE.equals(appInSelfeCargo
                            .getChg_eff_dt())) {
                changeEffDate = appInSelfeCargo.getChg_eff_dt();
                if (changeEffDate.length() == 10
                        && changeEffDate.charAt(2) == '/') {
                    changeEffDate = displayFormatter
                            .getYYYYMMDDDate(changeEffDate);
                    appInSelfeCargo.setChg_eff_dt(changeEffDate);
                }
            }
            if (appInSelfeCargo.getEff_begin_dt() != null
                    && appInSelfeCargo.getEff_begin_dt().trim().length() != 0
                    && !AppConstants.HIGH_DATE.equals(appInSelfeCargo
                            .getEff_begin_dt())) {
                String effDate = appInSelfeCargo.getEff_begin_dt();
                if (effDate.length() == 10 && effDate.charAt(2) == '/') {
                    effDate = displayFormatter.getYYYYMMDDDate(effDate);
                    appInSelfeCargo.setEff_begin_dt(effDate);
                }
            }

            // Setting default values for all columns for 'RE' and 'RN'
            if (appInSelfeCargo.getSelf_mng_sw() == null
                    || appInSelfeCargo.getSelf_mng_sw().trim().length() == 0) {
                appInSelfeCargo.setSelf_mng_sw(FwConstants.SPACE);
            }
            if (appInSelfeCargo.getChg_eff_dt() == null
                    || appInSelfeCargo.getChg_eff_dt().trim().length() == 0) {
                appInSelfeCargo.setChg_eff_dt(AppConstants.HIGH_DATE);
            }
            if (appInSelfeCargo.getAvg_incm_ind() == null
                    || appInSelfeCargo.getAvg_incm_ind().trim().length() == 0) {
                if (appInSelfeCargo.getAvg_incm_amt() == null
                        || appInSelfeCargo.getAvg_incm_amt().trim().length() == 0) {
                    appInSelfeCargo.setAvg_incm_ind("2");
                } else {
                    appInSelfeCargo.setAvg_incm_ind(FwConstants.ZERO);
                }
            } else {
                if (!(appInSelfeCargo.getAvg_incm_amt() == null || appInSelfeCargo
                        .getAvg_incm_amt().trim().length() == 0)) {

                    pageCollection.put("AvgAmtAndIndChecked", FwConstants.ONE);
                }
            }
            if (appInSelfeCargo.getRec_cplt_ind() == null
                    || appInSelfeCargo.getAvg_incm_ind().trim().length() == 0) {
                appInSelfeCargo.setRec_cplt_ind(FwConstants.ZERO);
            }
            if (appInSelfeCargo.getDprc_ind() == null
                    || appInSelfeCargo.getDprc_ind().trim().length() == 0) {
                if (appInSelfeCargo.getDprc_amt() == null
                        || appInSelfeCargo.getDprc_amt().trim().length() == 0) {
                    appInSelfeCargo.setDprc_amt("0.00");
                    appInSelfeCargo.setDprc_ind("2");
                } else {
                    appInSelfeCargo.setDprc_ind(FwConstants.ZERO);
                }
            } else {
                if (appInSelfeCargo.getDprc_amt() == null
                        || appInSelfeCargo.getDprc_amt().trim().length() == 0) {
                    appInSelfeCargo.setDprc_amt("0.00");
                } else {
                    pageCollection.put("DepAmtAndIndChecked", FwConstants.ONE);
                }
            }
            if (appInSelfeCargo.getExp_ind() == null
                    || appInSelfeCargo.getExp_ind().trim().length() == 0) {
                if (appInSelfeCargo.getExp_amt() == null
                        || appInSelfeCargo.getExp_amt().trim().length() == 0) {
                    appInSelfeCargo.setExp_amt("0.00");
                    appInSelfeCargo.setExp_ind("2");
                } else {
                    appInSelfeCargo.setExp_ind(FwConstants.ZERO);
                }
            } else {
                if (appInSelfeCargo.getExp_amt() == null
                        || appInSelfeCargo.getExp_amt().trim().length() == 0) {
                    appInSelfeCargo.setExp_amt("0.00");
                } else {
                    pageCollection.put("ExpAmtAndIndChecked", FwConstants.ONE);
                }
            }
            if (appInSelfeCargo.getHr_work_mo_ind() == null
                    || appInSelfeCargo.getHr_work_mo_ind().trim().length() == 0) {
                if (appInSelfeCargo.getHr_work_mo_qty() == null
                        || appInSelfeCargo.getHr_work_mo_qty().trim().length() == 0) {
                    appInSelfeCargo.setHr_work_mo_ind("2");
                } else {
                    appInSelfeCargo.setHr_work_mo_ind(FwConstants.ZERO);
                }
            } else {
                if (!(appInSelfeCargo.getHr_work_mo_qty() == null || appInSelfeCargo
                        .getHr_work_mo_qty().trim().length() == 0)) {

                    pageCollection.put("HrWorkMoQtyAndIndChecked",
                            FwConstants.ONE);
                }
            }

            if (appInSelfeCargo.getSelf_empl_typ() == null
                    || AppConstants.SELECT_DEFAULT_OPTION
                    .equals(appInSelfeCargo.getSelf_empl_typ())) {
                appInSelfeCargo.setSelf_empl_typ(null);
            }

            // now we are checking for the before collection
            if (beforeCollAppInSelfeColl != null
                    && !beforeCollAppInSelfeColl.isEmpty()) {
                final int size = beforeCollAppInSelfeColl.size();
                seqNum = categorySeqDetailBean.getCategorySequence();

                if ("C".equalsIgnoreCase(pageMode)) {
                    sourceAppIndicator = AppConstants.RMC_MODIFIED_RECORD_IND;
                } else if ("E".equalsIgnoreCase(pageMode)) {
                    sourceAppIndicator = AppConstants.RMC_END_RECORD_IND;
                } else {
                    sourceAppIndicator = AppConstants.RMC_NEW_RECORD_IND;
                }

                beforeSelfeCargo = splitEmplColl(beforeCollAppInSelfeColl,
                        sourceAppIndicator);
                if (beforeSelfeCargo == null
                        && (AppConstants.RMC_MODIFIED_RECORD_IND
                                .equals(sourceAppIndicator) || AppConstants.RMC_END_RECORD_IND
                                .equals(sourceAppIndicator))) {
                    beforeSelfeCargo = splitEmplColl(beforeCollAppInSelfeColl,
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
                            && beforeSelfeCargo != null) {
                        recordInd = FwConstants.ROWACTION_UPDATE;
                    }
                }
                if (beforeSelfeCargo != null) {
                    // Source App Indicator set to 'RM' and the default values
                    // for appInSelfeCargo populated from the before cargo
                    appInSelfeCargo.setSrc_app_ind(beforeSelfeCargo
                            .getSrc_app_ind());
                    appInSelfeCargo.setIndv_seq_num(beforeSelfeCargo
                            .getIndv_seq_num());
                    appInSelfeCargo.setSeq_num(beforeSelfeCargo.getSeq_num());
                    appInSelfeCargo.setRec_cplt_ind(beforeSelfeCargo
                            .getRec_cplt_ind());
                    appInSelfeCargo.setSelf_mng_sw(beforeSelfeCargo
                            .getSelf_mng_sw());
                    appInSelfeCargo.setUser(beforeSelfeCargo.getUser());
                    appInSelfeCargo.setEcp_id(beforeSelfeCargo.getEcp_id());

                    if ("E".equalsIgnoreCase(pageMode)) {
                        appInSelfeCargo.setSelf_empl_typ(beforeSelfeCargo
                                .getSelf_empl_typ());
                        appInSelfeCargo.setAvg_incm_amt(beforeSelfeCargo
                                .getAvg_incm_amt());
                        appInSelfeCargo.setAvg_incm_ind(beforeSelfeCargo
                                .getAvg_incm_ind());
                        appInSelfeCargo.setDprc_amt(beforeSelfeCargo.getDprc_amt());
                        appInSelfeCargo.setDprc_ind(beforeSelfeCargo.getDprc_ind());
                        appInSelfeCargo.setExp_amt(beforeSelfeCargo.getExp_amt());
                        appInSelfeCargo.setExp_ind(beforeSelfeCargo.getExp_ind());
                        appInSelfeCargo.setHr_work_mo_qty(beforeSelfeCargo
                                .getHr_work_mo_qty());
                        appInSelfeCargo.setHr_work_mo_ind(beforeSelfeCargo
                                .getHr_work_mo_ind());
                        appInSelfeCargo.setEcp_id(beforeSelfeCargo.getEcp_id());
                    }
                    
                    if (appInSelfeCargo.getAvg_incm_amt() != null
                            && AppConstants.ON_FILE
                            .equalsIgnoreCase(appInSelfeCargo
                                    .getAvg_incm_amt())) {
                        appInSelfeCargo.setAvg_incm_amt(beforeSelfeCargo
                                .getAvg_incm_amt());
                        if (modifiedFields.contains(appInSelfeCargo
                                .getIndv_seq_num()
                                + "_"
                                + appInSelfeCargo.getSeq_num()
                                + "_"
                                + "avg_incm_amt")) {
                            modifiedFields.remove(appInSelfeCargo.getIndv_seq_num()
                                    + "_" + appInSelfeCargo.getSeq_num() + "_"
                                    + "avg_incm_amt");
                        }
                    } else {
                        if (!modifiedFields.contains(appInSelfeCargo
                                .getIndv_seq_num()
                                + "_"
                                + appInSelfeCargo.getSeq_num()
                                + "_"
                                + "avg_incm_amt")) {
                            modifiedFields.add(appInSelfeCargo.getIndv_seq_num()
                                    + "_" + appInSelfeCargo.getSeq_num() + "_"
                                    + "avg_incm_amt");
                        }
                    }
                }

                               
                // check dirty
                appInSelfeCargo = (APP_IN_SELFE_Cargo) isChanged(
                        beforeSelfeCargo, appInSelfeCargo);
                if (appInSelfeCargo.isDirty()) {
                    appInSelfeCargo.setSrc_app_ind(sourceAppIndicator);
                    appInSelfeCargo.setRowAction(recordInd);
                    appInSelfeUpdate = true;

                }

                if (changeEffDate != null
                        && !changeEffDate.equals(appInSelfeCargo
                                .getChg_eff_dt())) {
                    appInSelfeCargo.setSrc_app_ind(sourceAppIndicator);
                    appInSelfeCargo.setRowAction(recordInd);
                    appInSelfeUpdate = true;
                }

                if (changeEffDate == null) {
                    changeEffDate = AppConstants.HIGH_DATE;
                }
                appInSelfeCargo.setChg_eff_dt(changeEffDate);
                appInSelfeCargo.setRec_cplt_ind(FwConstants.ONE);
            } else {
                // if there is no before collection means this is new record
                sourceAppIndicator = AppConstants.RMC_NEW_RECORD_IND;
                appInSelfeCargo
                .setIndv_seq_num(String.valueOf(categorySeqDetailBean
                        .getIndividualSequence()));

                // get the MAX seq number from data base
                seqNum = selfEmploymentBO.getMaxEmplSeqNumber(appNumber,
                        indvSeqNum);
                seqNum = seqNum + 1;
                appInSelfeCargo.setSeq_num(String.valueOf(seqNum));
                appInSelfeCargo.setSrc_app_ind(sourceAppIndicator);
                recordInd = FwConstants.ROWACTION_INSERT;
                appInSelfeCargo.setRowAction(recordInd);
                appInSelfeUpdate = true;
                // insert into RMC_SELECTION_PROFILE using Common Mehod()
                categorySelectionProfileManager.updateSequence(
                        selfeEmploymentProfile, null,
                        categorySeqDetailBean.getIndividualSequence(), seqNum,
                        categorySeqDetailBean.getCategoryType());
            }
            categorySelectionProfileManager.updateSequence(categorySelectionProfile, null, categorySeqDetailBean.getIndividualSequence(), seqNum, categorySeqDetailBean.getCategoryType());
            if(null!=categorySeqDetailBean.getChangeSelectionCategoryCd())
        	{
        	categorySelectionProfileManager.persistSequence(appNumber, categorySeqDetailBean.getChangeSelectionCategoryCd(), String.valueOf(categorySeqDetailBean.getIndividualSequence()), String.valueOf(seqNum), categorySeqDetailBean.getCategoryType(), "0");
        	}
            if (!appInSelfeCargo.isDirty() && !appInSelfeUpdate
                    && "CW".equals(appInSelfeCargo.getSrc_app_ind())) {
                diff = validator.validateNoChange(request);
                if (diff) {
                    request.get(FwConstants.WARNING_MSG_DETAILS);
                    pageCollection.put(AppConstants.FIRST_NAME, firstName);
                    if (request.get(AppConstants.LOOPING_QUESTION) != null) {
                        request.put(AppConstants.LOOPING_QUESTION,
                                request.get(AppConstants.LOOPING_QUESTION));
                    }
                    pageCollection
                    .put("PAGE_MODE", beforeColl.get("PAGE_MODE"));
                    pageCollection
                    .put("CWW_CARGO", beforeColl.get("CWW_CARGO"));
                    return;
                }
            }

            beforeColl.get("FST_EXP");
            final boolean[] wageDetailsUpdate = new boolean[1];
            wageDetailsUpdate[0] = false;

            // Check the flag & perform the DAO operation
            if (appInSelfeUpdate) {
                if (FwConstants.ROWACTION_INSERT.equals(appInSelfeCargo
                        .getRowAction())) {
                    selfEmploymentBO.storeSelfEmploymentDetails(
                            pageCollAppInSelfeColl, "insert");
                } else {
                    selfEmploymentBO.storeSelfEmploymentDetails(
                            pageCollAppInSelfeColl, FwConstants.EMPTY_STRING);
                }
            }

            final int[] driverArray = (int[]) session
                    .get(FwConstants.RMC_DRIVER);
            boolean loopingQuestion = false;
            if (request.get(AppConstants.LOOPING_QUESTION) != null
                    && FwConstants.YES.equals(request
                            .get(AppConstants.LOOPING_QUESTION))) {
                loopingQuestion = true;
                // Insert into APP_IN_EMPL and APP_IN_EMPL_A_WAGE
                categorySelectionProfileManager.insertSequenceDetail(
                        selfeEmploymentProfile, null, null,
                        categorySeqDetailBean.getIndividualSequence(),
                        categorySeqDetailBean.getCategoryType());
                driverManager.makeRequired(FwConstants.RMC_DRIVER,
                        currentPageID, driverArray, appNumber);
                driverManager.makeRequired(FwConstants.RMC_DRIVER,
                        AppConstants.ARJIS, driverArray, appNumber);
            }

            // now i need to update the rmc_in_prfl if looping question is null
            if (!loopingQuestion) {
                final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
                        .get(AppConstants.RMC_IN_PRFL_MASTER);
                final RMC_IN_PRFL_Cargo rmcInPrflCargo = rmcResponseProfileManager
                        .getProfile(rmcInPrflColl, String
                                .valueOf(categorySeqDetailBean
                                        .getIndividualSequence()));
                short respTyp=IRMCResponseProfileManager.SELF_EMPLOYMENT;
                if (rmcInPrflCargo != null && rmcResponseProfileManager.getProfileResponse(
						rmcInPrflCargo, respTyp).charAt(0) == IRMCResponseProfileManager.STATUS_REQUIRED) {
                	reqInd=true;
                    rmcResponseProfileManager
                    .makeComplete(
                    		respTyp,
                                    rmcInPrflCargo, true);
                }
            }
            // Mark complete job sequence using common methods
            if(!reqInd || categorySeqDetailBean.getChangeSelectionCategoryCd()==null)
			{
            categorySelectionProfileManager.makeSequenceDetailComplete(
                    selfeEmploymentProfile, null,
                    categorySeqDetailBean.getIndividualSequence(),
                    categorySeqDetailBean.getCategorySequence(),
                    categorySeqDetailBean.getCategoryType());
			}
            else{
            	categorySelectionProfileManager.makeSequenceDetailComplete(
    					selfeEmploymentProfile, appNumber,
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
                    .areAllSequencesComplete(selfeEmploymentProfile)) {
                driverManager.makeComplete(FwConstants.RMC_DRIVER,
                        currentPageID, driverArray, appNumber);
            } else {
                categorySelectionProfileManager
                .getNextSequenceDetail(selfeEmploymentProfile);
            }

        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("storeSelfEmploymentDetails");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "storeSelfEmploymentDetails", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.storeSelfEmploymentDetails() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Compare app in self e cargos.
     *
     * @param aCargo the a cargo
     * @param bCargo the b cargo
     * @return true, if successful
     */
    public boolean compareAppInSelfECargos(final APP_IN_SELFE_Cargo aCargo,
            final APP_IN_SELFE_Cargo bCargo) {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.compareAppInSelfECargos() - START");
        boolean flag = false;
        if (!(aCargo.getIndv_seq_num() == null && bCargo.getIndv_seq_num() == null)
                && !(aCargo.getIndv_seq_num() != null && aCargo
                .getIndv_seq_num().equals(bCargo.getIndv_seq_num()))) {
            flag = true;
        }
        if (!flag
                && !(aCargo.getSeq_num() == null && bCargo.getSeq_num() == null)
                && !(aCargo.getSeq_num() != null && aCargo.getSeq_num().equals(
                        bCargo.getSeq_num()))) {
            flag = true;
        }
        if (!flag
                && !(aCargo.getSelf_empl_typ() == null && bCargo
                .getSelf_empl_typ() == null)
                && !(aCargo.getSelf_empl_typ() != null && aCargo
                .getSelf_empl_typ().equals(bCargo.getSelf_empl_typ()))) {
            flag = true;
        }
        if (!flag
                && !(aCargo.getSrc_app_ind() == null && bCargo.getSrc_app_ind() == null)
                && !(aCargo.getSrc_app_ind() != null && aCargo.getSrc_app_ind()
                .equals(bCargo.getSrc_app_ind()))) {
            flag = true;
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.compareAppInSelfECargos() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
        return flag;
    }

    /**
     * Split empl coll.
     *
     * @param emplColl the empl coll
     * @param recordIndicator the record indicator
     * @return the AP p_ i n_ self e_ cargo
     */
    private APP_IN_SELFE_Cargo splitEmplColl(
            final APP_IN_SELFE_Collection emplColl, final String recordIndicator) {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.splitEmplColl() - START");
        try {
            if (emplColl != null && !emplColl.isEmpty()) {
                final int emplCollSize = emplColl.size();
                APP_IN_SELFE_Cargo emplCargo = null;
                for (int i = 0; i < emplCollSize; i++) {
                    emplCargo = emplColl.getCargo(i);
                    if (emplCargo.getSrc_app_ind().equals(recordIndicator)) {
                        return emplColl.getCargo(i);
                    }
                }

            }

            log(ILog.INFO,
                    "RMCJobIncomeEJBBean.splitEmplColl() - END , Time Taken : "
                            + (System.currentTimeMillis() - startTime)
                            + AppConstants.SPACE + AppConstants.MILLISECONDS);
            return null;
        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("splitEmplColl");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "splitEmplColl", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }
    }

    /**
     * Comment here.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */
    public void endJobIncome(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.endJobIncome() - START");
        try {
            log(ILog.INFO, "RMCJobIncomeEJBBean::endJobIncome:Start");
            final Map session = txnBean.getSession();
            final Map pageCollection = txnBean.getPageCollection();
            // Get driver info.
            final int[] driverArray = (int[]) session
                    .get(FwConstants.RMC_DRIVER);

            final JOBINCOME_Custom_Collection jobIncColl = (JOBINCOME_Custom_Collection) pageCollection
                    .get("JOBINCOME_Custom_Collection");
            final JOBINCOME_Custom_Cargo jobInCargo = jobIncColl.getResult(0);
            final IndivTypeSeqBean seqBean = new IndivTypeSeqBean();
            seqBean.setIndivSeqNum(jobInCargo.getIndv_seq_num());
            seqBean.setSeqNum(jobInCargo.getEmpl_seq_num());
            seqBean.setType(jobInCargo.getEmpl_typ());
            seqBean.setUserEndInd(FwConstants.ONE);
            pageCollection.put(FwConstants.DETAIL_KEY_BEAN, seqBean);
            // Get App Number
            final String appNum = (String) session.get(AppConstants.APP_NUMBER);
            // Set RMC page Job Income Details make required
            driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARJID",
                    driverArray, appNum);
            driverManager.makeRequired(FwConstants.RMC_DRIVER,
                    AppConstants.ARJIS, driverArray, appNum);

            // End
            log(ILog.INFO, "RMCJobIncomeEJBBean::endJobIncome:End");

        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("endJobIncome");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "endJobIncome", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }
        log(ILog.INFO,
                "RMCJobIncomeEJBBean.endJobIncome() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * End in kind income.
     *
     * @param txnBean the txn bean
     \* @throws javax.ejb.EJBException the EJB exception
     */
    public void endInKindIncome(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.endInKindIncome() - START");
        try {
            log(ILog.INFO, "RMCJobIncomeEJBBean::endInKindIncome:Start");
            final Map session = txnBean.getSession();
            final Map pageCollection = txnBean.getPageCollection();
            // Get driver info.
            final int[] driverArray = (int[]) session
                    .get(FwConstants.RMC_DRIVER);

            final JOBINCOME_Custom_Collection jobIncColl = (JOBINCOME_Custom_Collection) pageCollection
                    .get("JOBINCOME_Custom_Collection");
            final JOBINCOME_Custom_Cargo jobInCargo = jobIncColl.getResult(0);
            final IndivTypeSeqBean seqBean = new IndivTypeSeqBean();
            seqBean.setIndivSeqNum(jobInCargo.getIndv_seq_num());
            seqBean.setSeqNum(jobInCargo.getEmpl_seq_num());
            seqBean.setType(jobInCargo.getEmpl_typ());
            seqBean.setUserEndInd(FwConstants.ONE);
            pageCollection.put(FwConstants.DETAIL_KEY_BEAN, seqBean);
            // Get App Number
            final String appNum = (String) session.get(AppConstants.APP_NUMBER);
            // Set RMC page Job Income Details make required
            driverManager.makeRequired(FwConstants.RMC_DRIVER,
                    AppConstants.ARIKI, driverArray, appNum);
            driverManager.makeRequired(FwConstants.RMC_DRIVER,
                    AppConstants.ARJIS, driverArray, appNum);

            // End
            log(ILog.INFO, "RMCJobIncomeEJBBean::endInKindIncome:End");

        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("endInKindIncome");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "endInKindIncome", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }
        log(ILog.INFO,
                "RMCJobIncomeEJBBean.endJobIncome() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Check employment page required.
     *
     * @param categorySelectionProfile the category selection profile
     * @param emplType the empl type
     * @return true, if successful
     */
    private boolean checkEmploymentPageRequired(
            final SortedSet categorySelectionProfile, final Map emplType) {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO,
                "RMCJobIncomeEJBBean.checkEmploymentPageRequired() - START");
        boolean isEmploymentPageRequired = false;
        if (categorySelectionProfile != null) {
            // this one form the category selection profile
            final Iterator iter = categorySelectionProfile.iterator();
            CategorySequenceDetail categorySeqDtl = null;
            while (iter.hasNext()) {
                categorySeqDtl = (CategorySequenceDetail) iter.next();
                if (emplType != null
                        && emplType.get(categorySeqDtl.getCategoryType()) != null
                        && categorySeqDtl.getStatus() != IRMCResponseProfileManager.STATUS_COMPLETE
                        && categorySeqDtl.getUserEndSelectionInd() != AppConstants.RMB_NO_CHANGE_SEL_IND) {
                    isEmploymentPageRequired = true;
                    break;
                }
            }
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.checkEmploymentPageRequired() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
        return isEmploymentPageRequired;

    }

    /**
     * Load method for AREHILoad.
     *
     * @param txnBean the txn bean
     */
    public void loadEmplHealthIns(final FwTransaction txnBean) {

        final long startTime = System.currentTimeMillis();
        log(ILog.INFO,
                "RMCJobIncomeEJBBean.loadEmplHealthIns() - START");
        try {
            final Map request = txnBean.getRequest();
            final Map session = txnBean.getSession();
            Map pageCollection = txnBean.getPageCollection();

            APP_IN_EMPL_HEALTH_Collection appInEmpHlthColl;
            final String appNumber = (String) session
                    .get(AppConstants.APP_NUMBER);
            final String pageId = (String) request
                    .get(FwConstants.CURRENT_PAGE_ID);
            final int[] driverArray = (int[]) session
                    .get(FwConstants.RMC_DRIVER);
            final int pageStatus = driverManager.getAFBStatus(
                    FwConstants.RMC_DRIVER, pageId, driverArray);
            // get category selection profile
            SortedSet categorySelectionProfile = (SortedSet) session
                    .get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
            RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
                    .get(AppConstants.RMC_IN_PRFL_MASTER);
            final String previousPageId = (String) request
                    .get(FwConstants.PREVIOUS_PAGE_ID);
            final PeopleHandler peopleHandler = (PeopleHandler) session
                    .get(AppConstants.INDIV_MASTER_HANDLER);
            final INDIVIDUAL_Custom_Collection indvColl = peopleHandler
                    .getInHomeIndividuals();
            final RMCEmplHlthInsBO emplHlthInsBo = new RMCEmplHlthInsBO();
            final short[] responseType = new short[] { IRMCResponseProfileManager.EMPL_HLTH_INS_RESP };
            SortedSet emplHlthInsProfile = null;
            final Map emplHlthInsType = new HashMap<String, String>();
            emplHlthInsType.put("EHI", "EHI");

            if (pageStatus == FwConstants.DRIVER_REQUIRED
                    || pageStatus == FwConstants.DRIVER_VISIT_AGAIN
                    && categorySelectionProfileManager.isEmpty(
                            categorySelectionProfile, emplHlthInsType)) {
                categorySelectionProfile = categorySelectionProfileManager
                        .loadCategoryChangeSelectionProfile(appNumber,
                                AppConstants.EMPL_HLTH_INS);
            } else if (pageStatus == FwConstants.DRIVER_COMPLETE
                    && !pageId.equals(previousPageId)
                    && categorySelectionProfileManager.isEmpty(
                            categorySelectionProfile, emplHlthInsType)) {
                categorySelectionProfile = categorySelectionProfileManager
                        .loadCategoryChangeSelectionProfile(appNumber,
                                AppConstants.EMPL_HLTH_INS);
            }

            if (!pageId.equals(previousPageId)) {
                emplHlthInsProfile = createPageProfile(
                        categorySelectionProfile, rmcInPrflColl, responseType);
                
                if (pageStatus != FwConstants.DRIVER_REQUIRED) {
                    final APP_IN_EMPL_HEALTH_Collection newEmplColl = emplHlthInsBo
                            .getNewEmplHlthInsDetails(appNumber);
                    if (newEmplColl != null && !newEmplColl.isEmpty()) {
                    	APP_IN_EMPL_HEALTH_Cargo appInEmplCargo = null;
                        final int newEmplCollSize = newEmplColl.size();
                        for (int i = 0; i < newEmplCollSize; i++) {
                            appInEmplCargo = newEmplColl.getCargo(i);
                            categorySelectionProfileManager
                            .insertExistingSequenceDetail(
                            		emplHlthInsProfile, null, null,
                                    Short.parseShort(appInEmplCargo
                                            .getIndv_seq_num()),
                                            Long.parseLong(appInEmplCargo
                                                    .getSeq_num()),
                                                    AppConstants.EMPL_HLTH_INS);
                        }
                    }
                }
                if (pageStatus == FwConstants.DRIVER_REQUIRED
                        || pageStatus == FwConstants.DRIVER_VISIT_AGAIN) {
                    // set the current record indicator to the first one
                    categorySelectionProfileManager
                    .setCurrentRecordIndToFirst(emplHlthInsProfile);
                }
                if (pageStatus == FwConstants.DRIVER_COMPLETE) {
                    // set the current record indicator to the end of the detail
                    // bean
                    categorySelectionProfileManager
                    .setCurrentRecordIndToLast(emplHlthInsProfile);
                }
                // create add new sorted set
                // we need to remove the vallues from the session
                session.remove(FwConstants.BEFORE_COLLECTION);
            } else {
                // catAddNewProfile get it from the before collection
                final Map beforeColl = (Map) session
                        .get(FwConstants.BEFORE_COLLECTION);
                emplHlthInsProfile = (SortedSet) beforeColl
                        .get(AppConstants.RMC_CATEGORY_PAGE_PRFL);
            }

            final IndivTypeSeqBean indivSeqBean = (IndivTypeSeqBean) pageCollection
                    .get(FwConstants.DETAIL_KEY_BEAN);
            // if details key bean not null means this bean is comming from the
            // summary page
            if (indivSeqBean != null) {
                final CategorySequenceDetail categorySeqDetail1 = categorySelectionProfileManager
                        .getCategorySequenceDetail(
                                emplHlthInsProfile,
                                Short.parseShort(indivSeqBean.getIndivSeqNum()),
                                Long.parseLong(indivSeqBean.getSeqNum()),
                                indivSeqBean.getType());
                if (categorySeqDetail1 != null) {
                    if (categorySeqDetail1.getUserEndSelectionInd() != Short
                            .parseShort(indivSeqBean.getUserEndInd())) {
                        categorySelectionProfileManager
                        .updateUserEndSelInd(
                                emplHlthInsProfile,
                                appNumber,
                                Short.parseShort(indivSeqBean
                                        .getIndivSeqNum()),
                                        Long.parseLong(indivSeqBean.getSeqNum()),
                                        indivSeqBean.getType(), Short
                                        .parseShort(indivSeqBean
                                                .getUserEndInd()));
                    }
                    categorySelectionProfileManager.makeSequenceDetailRequired(
                            emplHlthInsProfile, null,
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
                        // now we need to make required the employment
                        if (AppConstants.EMPL_HLTH_INS.equals(indivSeqBean
                                .getType())) {
                            rmcResponseProfileManager.makeAddNew(
                                    IRMCResponseProfileManager.SELF_EMPLOYMENT,
                                    rmcInPrflCargo, true);
                        }
                        categorySelectionProfileManager
                        .insertSequenceDetail(emplHlthInsProfile,
                                null, null, Short
                                .parseShort(indivSeqBean
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
                        .insertExistingSequenceDetail(
                                emplHlthInsProfile,
                                null,
                                AppConstants.EMPL_HLTH_INS,
                                Short.parseShort(indivSeqBean
                                        .getIndivSeqNum()),
                                        Long.parseLong(indivSeqBean.getSeqNum()),
                                        indivSeqBean.getType(), Short
                                        .parseShort(userEndInd));
                        categorySelectionProfileManager
                        .makeSequenceDetailRequired(
                                emplHlthInsProfile,
                                null,
                                Short.parseShort(indivSeqBean
                                        .getIndivSeqNum()),
                                        Long.parseLong(indivSeqBean.getSeqNum()),
                                        indivSeqBean.getType());

                        categorySelectionProfileManager
                        .insertExistingSequenceDetail(
                                categorySelectionProfile,
                                appNumber,
                                AppConstants.EMPL_HLTH_INS,
                                Short.parseShort(indivSeqBean
                                        .getIndivSeqNum()),
                                        Long.parseLong(indivSeqBean.getSeqNum()),
                                        indivSeqBean.getType(), Short
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
                    emplHlthInsProfile);
            CategorySequenceDetail categorySeqDetail = categorySelectionProfileManager
                    .getCurrentSequenceDetail(emplHlthInsProfile);
            if (categorySeqDetail == null) {
                categorySeqDetail = categorySelectionProfileManager
                        .getNextSequenceDetail(emplHlthInsProfile);
            }

            final String categoryType = categorySeqDetail.getCategoryType();
            final String categorySeqNum = Long.toString(categorySeqDetail
                    .getCategorySequence());
            String indvSeqNum = Short.toString(categorySeqDetail
                    .getIndividualSequence());
            Short.toString(categorySeqDetail.getUserEndSelectionInd());

            appInEmpHlthColl = emplHlthInsBo.getEmplhlthInsDetails(
                    appNumber, indvSeqNum, categorySeqNum);
            pageCollection.put("APP_IN_EMPL_HEALTH_Collection", appInEmpHlthColl);

            APP_IN_EMPL_HEALTH_Cargo appInEmplhlthInsCargo = null;
            String pageMode = null;

            if (appInEmpHlthColl != null && !appInEmpHlthColl.isEmpty()) {
                appInEmplhlthInsCargo = appInEmpHlthColl.getCargo(0);
            }

            APP_IN_EMPL_HEALTH_Cargo cwwEmplInsCargo = splitEmplHlth(appInEmpHlthColl,
                    AppConstants.CWW_RECORD_IND);
            if (cwwEmplInsCargo == null) {
                cwwEmplInsCargo = new APP_IN_EMPL_HEALTH_Cargo();
            }
            APP_IN_EMPL_HEALTH_Cargo cargoRN = splitEmplHlth(appInEmpHlthColl,
                    AppConstants.RMC_NEW_RECORD_IND);
            APP_IN_EMPL_HEALTH_Cargo cargoRM = splitEmplHlth(appInEmpHlthColl,
                    AppConstants.RMC_MODIFIED_RECORD_IND);

            if(cargoRM != null){
                pageCollection.put("APP_IN_EMPL_HEALTH_Cargo", cargoRM);
            }else if (cargoRN != null){
                pageCollection.put("APP_IN_EMPL_HEALTH_Cargo", cargoRN);
            }

            pageCollection.put("CWW_CARGO", cwwEmplInsCargo);

            final JobIncomeBO jobIncomeBO = new JobIncomeBO();
            APP_IN_EMPL_Collection emplColl =jobIncomeBO.loadDetails(appNumber, indvSeqNum, categorySeqNum);
            if(null!=emplColl && !emplColl.isEmpty())
                pageCollection.put("employerName", ((APP_IN_EMPL_Cargo) emplColl.get(0)).getEr_nam());

            if (pageStatus == FwConstants.DRIVER_COMPLETE
                    || pageStatus == FwConstants.DRIVER_VISIT_AGAIN
                    || pageStatus == FwConstants.DRIVER_REQUIRED
                    ) {
                /**
                 * Load and display checked Dependents (START) 06/11/2015
                 * NCanedo - Check-in Defect 19084
                 * --------------------------------------------------
                 */
                if (cwwEmplInsCargo.getSrc_app_ind()!= null && cwwEmplInsCargo.getSrc_app_ind().equalsIgnoreCase(AppConstants.CWW_RECORD_IND)) {

                    pageCollection = emplHlthInsBo.loadDependants(appNumber,
                            categorySeqNum, indvSeqNum, pageCollection,
                            AppConstants.CWW_RECORD_IND);
                    /*
                     * Because we inserted RM while editing Emp Hlth Ins
                     * */
                    if(null == pageCollection.get("APP_IN_EMPL_HEALTH_DEP_Collection"))
                        pageCollection = emplHlthInsBo.loadDependants(appNumber,
                                        categorySeqNum, indvSeqNum, pageCollection,
                                        AppConstants.RMC_MODIFIED_RECORD_IND);
                } else {
                    pageCollection = emplHlthInsBo.loadDependants(appNumber,
                            categorySeqNum, indvSeqNum, pageCollection,
                            AppConstants.RMC_MODIFIED_RECORD_IND);
                }

                final Map indivCollection = new HashMap();

                final APP_IN_EMPL_HEALTH_DEP_Collection dependentsBeforeCollection = null == pageCollection
                        .get("APP_IN_EMPL_HEALTH_DEP_Collection") ? new APP_IN_EMPL_HEALTH_DEP_Collection()
                : (APP_IN_EMPL_HEALTH_DEP_Collection) pageCollection
                .get("APP_IN_EMPL_HEALTH_DEP_Collection");

                        for (int index = 0; index < dependentsBeforeCollection.size(); index++) {
                            indivCollection.put(
                                    dependentsBeforeCollection.getResult(index)
                                    .getDependent_indv_seq_num(), "R");
                        }

                        pageCollection.put("APP_IN_EMPL_HEALTH_DEP_Collection",
                                dependentsBeforeCollection);
                        pageCollection.put("indivCollection", indivCollection);
                        /**
                         * Load and display checked Dependents (END)
                         * --------------------------------------------------
                         */

            }
            if (pageStatus == FwConstants.DRIVER_ADD_NEW
                    && indvSeqNum == null) {
                final String addedIndv = (String) request
                        .get("firstNameHealth");
                if (addedIndv != null) {
                    indvSeqNum = addedIndv;
                }
            }
            INDIVIDUAL_Custom_Collection collection = (INDIVIDUAL_Custom_Collection) request
                    .get("collection");

            // Remove current applicant from dependats list
            //*********************************************//*
            String firstName = AppConstants.EMPTY_STRING;
            if (null == collection) {
                collection = new INDIVIDUAL_Custom_Collection();

                if (indvColl != null && !indvColl.isEmpty()) {
                    for (int i = 0; i < indvColl.size(); i++) {
                        final INDIVIDUAL_Custom_Cargo cargo = indvColl
                                .getResult(i);
                        if (cargo.getIndv_seq_num() != null
                                && !cargo.getIndv_seq_num().equals(
                                        indvSeqNum)) {
                            collection.addCargo(cargo);
                        } else {
                        	firstName = cargo.getFst_nam();
                            pageCollection.put(AppConstants.FIRST_NAME, firstName);
                        }
                    }
                }
                // Set the Dependats Collection into Session
                pageCollection.put("collection", collection);
            }
            //*********************************************//*


            if (appInEmplhlthInsCargo != null
                    && ("CW".equalsIgnoreCase(appInEmplhlthInsCargo.getSrc_app_ind()) || "RM"
                            .equalsIgnoreCase(appInEmplhlthInsCargo.getSrc_app_ind()))
                            && categorySeqDetail.getUserEndSelectionInd() == 0) {
                pageMode = "C";
            } else if (categorySeqDetail.getUserEndSelectionInd() == 1) {
                pageMode = "E";
            } else {
                pageMode = FwConstants.NO;
            }

            char typeStatus = 'N';
            String showLoopingQuestionFlag = FwConstants.YES;

            typeStatus = categorySeqDetail.getStatus();
            if (typeStatus == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
                    || typeStatus == IRMCResponseProfileManager.STATUS_COMPLETE) {
                showLoopingQuestionFlag = FwConstants.NO;

            }

            pageCollection.put(AppConstants.SHOW_LOOPING_QUESTION,
                    showLoopingQuestionFlag);

            pageCollection.put("CATEGORY_TYPE", categoryType);
            pageCollection.put("PAGE_MODE", pageMode);
            request.remove(AppConstants.LOOPING_QUESTION);
            // Add the page collection to before collection
            if (session.get(FwConstants.BEFORE_COLLECTION) != null) {
                ((Map) session.get(FwConstants.BEFORE_COLLECTION))
                .putAll(pageCollection);
            } else {
                final Map beforeColl = new HashMap();
                beforeColl.putAll(pageCollection);
                session.put(FwConstants.BEFORE_COLLECTION, beforeColl);
            }

        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("loadEmplHealthIns");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "loadEmplHealthIns", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.loadEmplHealthIns() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }

    /**
     * Store method for AREHISave and AREHINext.
     *
     * @param txnBean the txn bean
     */
    public void storeEmplHealthIns(final FwTransaction txnBean) {

        final long startTime = System.currentTimeMillis();
        log(ILog.INFO,
                "RMCJobIncomeEJBBean.storeEmplHealthIns() - START");
        try {
            APP_IN_EMPL_HEALTH_Cargo appInEmplHlthCargo = null;
            APP_IN_EMPL_HEALTH_Cargo beforeEmplHlthCargo = null;
            APP_IN_EMPL_HEALTH_Cargo appInEmplCargo = null;
            APP_IN_EMPL_HEALTH_Cargo beforeEmplCargo = null;
            String sourceAppIndicator = null;
            String recordInd = null;
            long seqNum = 0;
            boolean appInEmplHlthUpdate = false;
            boolean diff = false;
            String changeEffDate = null;
            final Map request = txnBean.getRequest();
            final Map session = txnBean.getSession();
            final Map pageCollection = txnBean.getPageCollection();

            final PeopleHandler peopleHandler = (PeopleHandler) session
                    .get(AppConstants.INDIV_MASTER_HANDLER);
            final INDIVIDUAL_Custom_Collection indvColl = peopleHandler
                    .getInHomeIndividuals();
            final String currentPageID = (String) request
                    .get(FwConstants.CURRENT_PAGE_ID);
            final String appNumber = (String) session
                    .get(AppConstants.APP_NUMBER);
            final List modifiedFields = (ArrayList) session
                    .get(AppConstants.MODIFIED_FIELDS);
            // build category selection profile
            final SortedSet categorySelectionProfile = (SortedSet) session
                    .get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
            // get the BeforeCollection
            final Map beforeColl = (Map) session
                    .get(FwConstants.BEFORE_COLLECTION);
            // get the page profile
            final SortedSet emplHlthProfile = (SortedSet) beforeColl
                    .get(AppConstants.RMC_CATEGORY_PAGE_PRFL);
            final APP_IN_EMPL_HEALTH_Collection appInEmplHlthPageColl = (APP_IN_EMPL_HEALTH_Collection) pageCollection
                    .get("APP_IN_EMPL_HEALTH_Collection");
            final APP_IN_EMPL_HEALTH_Collection appInEmplHlthBeforeColl = (APP_IN_EMPL_HEALTH_Collection) beforeColl
                    .get("APP_IN_EMPL_HEALTH_Collection");

            if (appInEmplHlthPageColl != null
                    && !appInEmplHlthPageColl.isEmpty()) {
                appInEmplHlthCargo = appInEmplHlthPageColl.getCargo(0);
            }
            final String firstName = (String) beforeColl
                    .get(AppConstants.FIRST_NAME);
            
            final String pageMode = (String) beforeColl.get("PAGE_MODE");
            beforeColl.get("CATEGORY_TYPE");
            // Run Validations
            final RMCEmplHlthInsBO emplHlthInsBO = new RMCEmplHlthInsBO();
            /*
             * VALIDATION CODE TO BE ADDED
             */
            final String backToMyAccess = (String) request
                    .get(AppConstants.BACK_TO_MY_ACCESS_BUTTON);

            if (appInEmplHlthCargo != null) {
                appInEmplHlthCargo.setApp_num(appNumber);
                // validations
               
                String employerName = (String) beforeColl.get("employerName");
				pageCollection.put("employerName", employerName);
                emplHlthInsBO.validateInsuranceDetail(appInEmplHlthCargo,
                        firstName, employerName);


                
                if (checkBackToMyAccessSelected(request)
                        || emplHlthInsBO.hasMessages()) {
                    if (backToMyAccess == null) {
                        request.put(FwConstants.MESSAGE_LIST,
                                emplHlthInsBO.getMessageList());
                    }

                    pageCollection.put(AppConstants.FIRST_NAME, firstName);
                    if (request.get(AppConstants.LOOPING_QUESTION) != null) {
                        request.put(AppConstants.LOOPING_QUESTION,
                                request.get(AppConstants.LOOPING_QUESTION));
                    }
                    pageCollection.put(AppConstants.SHOW_LOOPING_QUESTION,
                            beforeColl.get(AppConstants.SHOW_LOOPING_QUESTION));
                    pageCollection
                    .put("PAGE_MODE", beforeColl.get("PAGE_MODE"));
                    pageCollection.put("CWW_CARGO", beforeColl.get("CWW_CARGO"));
                    pageCollection.put("employerName", beforeColl.get("employerName"));
                    pageCollection.put("collection", beforeColl.get("collection"));
                    pageCollection.put("indivCollection", beforeColl.get("indivCollection"));

                    if("C".equalsIgnoreCase((String) beforeColl.get("PAGE_MODE"))){
                        APP_IN_EMPL_HEALTH_Cargo cwCargo = (APP_IN_EMPL_HEALTH_Cargo) pageCollection.get("CWW_CARGO");
                        cwCargo.setEr_provd_med_ins_ind(appInEmplHlthCargo.getEr_provd_med_ins_ind());
                        cwCargo.setIns_cvrg_ofr_empl(appInEmplHlthCargo.getIns_cvrg_ofr_empl());
                        APP_IN_EMPL_HEALTH_Cargo appEmplHlthCargo = null;
                        if(null != beforeColl.get("APP_IN_EMPL_HEALTH_Cargo")) {
                        	appEmplHlthCargo = (APP_IN_EMPL_HEALTH_Cargo) beforeColl.get("APP_IN_EMPL_HEALTH_Cargo");
                        }
                        if(null != appEmplHlthCargo && null!=appInEmplHlthCargo) {
                        	appEmplHlthCargo.setEr_provd_med_ins_ind(appInEmplHlthCargo.getEr_provd_med_ins_ind());
                        }
                        if(null != appEmplHlthCargo && null!=appInEmplHlthCargo) {
                        	appEmplHlthCargo.setIns_cvrg_ofr_empl(appInEmplHlthCargo.getIns_cvrg_ofr_empl());
                        }
                        pageCollection.put("APP_IN_EMPL_HEALTH_Cargo", appEmplHlthCargo);                        
                    }
                    if("N".equalsIgnoreCase((String) beforeColl.get("PAGE_MODE"))){
                        pageCollection.put("APP_IN_EMPL_HEALTH_Cargo", appInEmplHlthCargo);
                    }
                    if(null != request.get("displayOfferHealthCovQuesOnly")) {
                    	String displayOfferHealthCovQuesOnly = (String) request.get("displayOfferHealthCovQuesOnly");
                    	if(null != appInEmplHlthCargo.getEr_provd_med_ins_ind() && null != displayOfferHealthCovQuesOnly 
                    			&& (FwConstants.YES).equals(displayOfferHealthCovQuesOnly)) {
                    		emplHlthInsBO.getMessageList().getMessageList().clear();
                    	}
                    }
                    if(null != request.get("displayEnrollQuesOnly")) {
                    	String displayEnrollQuesOnly = (String) request.get("displayEnrollQuesOnly");
                    	if(null != appInEmplHlthCargo.getIns_cvrg_ofr_empl() && null != displayEnrollQuesOnly 
                    			&& (FwConstants.YES).equals(displayEnrollQuesOnly)) {
                    		emplHlthInsBO.getMessageList().getMessageList().clear();
                    	}
                    }
                    return;
                }
            }
            final CategorySequenceDetail categorySeqDetailBean = categorySelectionProfileManager
                    .getCurrentSequenceDetail(emplHlthProfile);
            final String indvSeqNum = String.valueOf(categorySeqDetailBean
                    .getIndividualSequence());

            //////////////////////////////////

            if (appInEmplHlthCargo.getIns_cobra_ind() == null) {
                appInEmplHlthCargo.setIns_cobra_ind(FwConstants.SPACE);
            }

            if (appInEmplHlthCargo.getIns_retiree_plan_ind() == null) {
                appInEmplHlthCargo
                .setIns_retiree_plan_ind(FwConstants.SPACE);
            }

            if (appInEmplHlthCargo.getIns_limited_bnft_plan_ind() == null) {
                appInEmplHlthCargo
                .setIns_limited_bnft_plan_ind(FwConstants.SPACE);
            }

            if (appInEmplHlthCargo.getIns_cvrg_ofr_empl() == null) {
                appInEmplHlthCargo.setIns_cvrg_ofr_empl(FwConstants.SPACE);
            }
            
            if (appInEmplHlthCargo.getEr_provd_med_ins_ind() == null) {
                appInEmplHlthCargo.setEr_provd_med_ins_ind(FwConstants.SPACE);
            }

            if (appInEmplHlthCargo.getName_health_ins() == null) {
                appInEmplHlthCargo.setName_health_ins(FwConstants.SPACE);
            }

            if (appInEmplHlthCargo.getPolicy_num() == null) {
                appInEmplHlthCargo.setPolicy_num(FwConstants.SPACE);
            }

            if (appInEmplHlthCargo.getHealth_insurance_name() == null) {
                appInEmplHlthCargo
                .setHealth_insurance_name(FwConstants.SPACE);
            }

            if (appInEmplHlthCargo.getHealth_insurance_phone_number() == null) {
                appInEmplHlthCargo
                .setHealth_insurance_phone_number(FwConstants.SPACE);
            }

            if (appInEmplHlthCargo.getHealth_insuranc_email_adr() == null) {
                appInEmplHlthCargo
                .setHealth_insuranc_email_adr(FwConstants.SPACE);
            }

            if (appInEmplHlthCargo.getElg_empl_ins_next_3_mths_ind() == null) {
                appInEmplHlthCargo
                .setElg_empl_ins_next_3_mths_ind(FwConstants.SPACE);
            }

            if (appInEmplHlthCargo.getCvrg_beg_dt() == null
                    || appInEmplHlthCargo.getCvrg_beg_dt().trim().length() == 0) {
                appInEmplHlthCargo.setCvrg_beg_dt(FwConstants.SPACE);
            } else {
                appInEmplHlthCargo.setCvrg_beg_dt(displayFormatter
                        .getYYYYMMDDDate(appInEmplHlthCargo
                                .getCvrg_beg_dt()));
            }

            if (appInEmplHlthCargo.getEmpl_covrg_meets_min_val_ind() == null) {
                appInEmplHlthCargo
                .setEmpl_covrg_meets_min_val_ind(FwConstants.SPACE);
            }

            if (appInEmplHlthCargo.getPremium_pay_freq_cd() == null) {
                appInEmplHlthCargo
                .setPremium_pay_freq_cd(FwConstants.SPACE);
            }

            if (appInEmplHlthCargo.getEmpl_covrg_chg_next_yr_ind() == null) {
                appInEmplHlthCargo
                .setEmpl_covrg_chg_next_yr_ind(FwConstants.SPACE);
            }

            if (appInEmplHlthCargo.getNew_premium_pay_freq_cd() == null) {
                appInEmplHlthCargo
                .setNew_premium_pay_freq_cd(FwConstants.SPACE);
            }

            if (appInEmplHlthCargo.getCvrg_chg_dt() == null
                    || appInEmplHlthCargo.getCvrg_chg_dt().trim().length() == 0) {
                appInEmplHlthCargo.setCvrg_chg_dt(FwConstants.SPACE);
            } else {
                appInEmplHlthCargo.setCvrg_chg_dt(displayFormatter
                        .getYYYYMMDDDate(appInEmplHlthCargo
                                .getCvrg_chg_dt()));
            }

            // now we are checking for the before collection
            if (appInEmplHlthBeforeColl != null
                    && !appInEmplHlthBeforeColl.isEmpty()) {
                final int size = appInEmplHlthBeforeColl.size();
                seqNum = categorySeqDetailBean.getCategorySequence();

                if ("C".equalsIgnoreCase(pageMode)) {
                    sourceAppIndicator = AppConstants.RMC_MODIFIED_RECORD_IND;
                } else if ("E".equalsIgnoreCase(pageMode)) {
                    sourceAppIndicator = AppConstants.RMC_END_RECORD_IND;
                } else {
                    sourceAppIndicator = AppConstants.RMC_NEW_RECORD_IND;
                }

                beforeEmplHlthCargo = splitEmplHlth(appInEmplHlthBeforeColl,
                        sourceAppIndicator);
                if (beforeEmplHlthCargo == null
                        && (AppConstants.RMC_MODIFIED_RECORD_IND
                                .equals(sourceAppIndicator) || AppConstants.RMC_END_RECORD_IND
                                .equals(sourceAppIndicator))) {
                    beforeEmplHlthCargo = splitEmplHlth(appInEmplHlthBeforeColl,
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
                            && beforeEmplHlthCargo != null) {
                        recordInd = FwConstants.ROWACTION_UPDATE;
                    }
                }
                if (beforeEmplHlthCargo != null) {
                    // Source App Indicator set to 'RM' and the default values
                    // for appInSelfeCargo populated from the before cargo
                    appInEmplHlthCargo.setSrc_app_ind(beforeEmplHlthCargo
                            .getSrc_app_ind());
                    appInEmplHlthCargo.setIndv_seq_num(beforeEmplHlthCargo
                            .getIndv_seq_num());
                    appInEmplHlthCargo.setSeq_num(beforeEmplHlthCargo.getSeq_num());
                    appInEmplHlthCargo.setRec_cplt_ind(beforeEmplHlthCargo
                            .getRec_cplt_ind());
                    appInEmplHlthCargo.setUser(beforeEmplHlthCargo.getUser());
                    appInEmplHlthCargo.setEcp_id(beforeEmplHlthCargo.getEcp_id());

                }
                // check dirty
                appInEmplHlthCargo = (APP_IN_EMPL_HEALTH_Cargo) isChanged(
                        beforeEmplHlthCargo, appInEmplHlthCargo);
                if (appInEmplHlthCargo.isDirty()) {
                    appInEmplHlthCargo.setSrc_app_ind(sourceAppIndicator);
                    appInEmplHlthCargo.setRowAction(recordInd);
                    appInEmplHlthUpdate = true;

                }

            } else {
                // if there is no before collection means this is new record
                sourceAppIndicator = AppConstants.RMC_NEW_RECORD_IND;
                appInEmplHlthCargo
                .setIndv_seq_num(String.valueOf(categorySeqDetailBean
                        .getIndividualSequence()));

                // get the MAX seq number from data base
                seqNum = emplHlthInsBO.getMaxEmplHlthSeq(appNumber,
                        indvSeqNum);
                seqNum = seqNum + 1;
                appInEmplHlthCargo.setSeq_num(String.valueOf(seqNum));
                appInEmplHlthCargo.setSrc_app_ind(sourceAppIndicator);
                recordInd = FwConstants.ROWACTION_INSERT;
                appInEmplHlthCargo.setRowAction(recordInd);
                appInEmplHlthUpdate = true;
                // insert into RMC_SELECTION_PROFILE using Common Mehod()
                categorySelectionProfileManager.updateSequence(
                        emplHlthProfile, null,
                        categorySeqDetailBean.getIndividualSequence(), seqNum,
                        categorySeqDetailBean.getCategoryType());
            }

            final boolean[] wageDetailsUpdate = new boolean[1];
            wageDetailsUpdate[0] = false;

            /**
             * Store Dependents (START) 06/11/2015 NCanedo - Check-in Defect
             * 19084 --------------------------------------------------
             */
            // Fetch dependentsCollection and dependentsBeforeCollection
            final APP_IN_EMPL_HEALTH_DEP_Collection dependentsCollection = null == pageCollection
                    .get("APP_IN_EMPL_HEALTH_DEP_Collection") ? new APP_IN_EMPL_HEALTH_DEP_Collection()
            : (APP_IN_EMPL_HEALTH_DEP_Collection) pageCollection
            .get("APP_IN_EMPL_HEALTH_DEP_Collection");
                    final APP_IN_EMPL_HEALTH_DEP_Collection dependentsBeforeCollection = null == beforeColl
                            .get("APP_IN_EMPL_HEALTH_DEP_Collection") ? new APP_IN_EMPL_HEALTH_DEP_Collection()
                    : (APP_IN_EMPL_HEALTH_DEP_Collection) beforeColl
                    .get("APP_IN_EMPL_HEALTH_DEP_Collection");

                            // Check if there are selected dependents
                            if (null!=dependentsCollection && !dependentsCollection.isEmpty()) {
                                for (int index = 0; index < dependentsCollection.size(); index++) {
                                    // Set dependent cargo values to be store in
                                    // CP_APP_IN_EMPL_HLTH_INS_DEP
                                    final APP_IN_EMPL_HEALTH_DEP_Cargo dependentCargo = dependentsCollection
                                            .getResult(index);
                                    dependentCargo.setApp_num(appNumber); // CP_APP_IN_EMPL_HLTH_INS_DEP.APP_NUM
                                    dependentCargo.setEmpl_seq_num(appInEmplHlthCargo
                                            .getSeq_num()); // CP_APP_IN_EMPL_HLTH_INS_DEP.EMPL_SEQ_NUM
                                    dependentCargo.setIndv_seq_num(appInEmplHlthCargo
                                            .getIndv_seq_num()); // CP_APP_IN_EMPL_HLTH_INS_DEP.INDV_SEQ_NUM
                                    dependentCargo
                                    .setSrc_app_ind(AppConstants.RMC_MODIFIED_RECORD_IND);
                                    dependentCargo
                                    .setRowAction(FwConstants.ROWACTION_INSERT);

                                    // Iterate dependentsBeforeCollection to check if
                                    // individual selected already, in which case use an
                                    // UPDATE Statement
                                    for (int bfCIndex = 0; bfCIndex < dependentsBeforeCollection
                                            .size(); bfCIndex++) {
                                        if (dependentsBeforeCollection
                                                .getResult(bfCIndex)
                                                .getDependent_indv_seq_num()
                                                .equals(dependentCargo
                                                        .getDependent_indv_seq_num())) {

                                            if (!AppConstants.CWW_RECORD_IND
                                                    .equalsIgnoreCase(dependentsBeforeCollection
                                                            .getResult(bfCIndex)
                                                            .getSrc_app_ind())) {
                                                dependentCargo
                                                .setRowAction(FwConstants.ROWACTION_UPDATE);
                                            }
                                            break;
                                        }
                                    }

                                }

                            }
                            // Check if dependents were UN-CHECKED in which case use add the
                            // un-checked dependent to the collection and use DELETE
                            // Statement
                            for (int bfCIndex = 0; bfCIndex < dependentsBeforeCollection
                                    .size(); bfCIndex++) {
                                boolean found = false;
                                for (int index = 0; index < dependentsCollection.size(); index++) {
                                    if (dependentsBeforeCollection
                                            .getResult(bfCIndex)
                                            .getDependent_indv_seq_num()
                                            .equals(dependentsCollection.getResult(index)
                                                    .getDependent_indv_seq_num())) {
                                        found = true;
                                        break;
                                    }
                                }

                                if (!found) {
                                    final APP_IN_EMPL_HEALTH_DEP_Cargo deleteCargo = dependentsBeforeCollection
                                            .getResult(bfCIndex);

                                    if (!(deleteCargo.getSrc_app_ind() != null && AppConstants.CWW_RECORD_IND
                                            .equalsIgnoreCase(deleteCargo.getSrc_app_ind()))) {
                                        deleteCargo
                                        .setRowAction(FwConstants.ROWACTION_DELETE);
                                        dependentsCollection.addCargo(deleteCargo);
                                    }
                                }
                            }

                            // Persist Selected Dependents
                            emplHlthInsBO.storeEmplHlthInsDepAFB(dependentsCollection);
                            beforeColl.remove("APP_IN_EMPL_HEALTH_DEP_Collection");
                            /**
                             * Store Dependents (END)
                             * --------------------------------------------------
                             */


                            new ABJobIncomeBO();
                            // Check the flag & perform the DAO operation
                            if (appInEmplHlthUpdate) {
                                if (FwConstants.ROWACTION_INSERT.equals(appInEmplHlthCargo
                                        .getRowAction())) {
                                    emplHlthInsBO.storeEmplHlthIns(
                                            appInEmplHlthPageColl, "insert");
                                } else {
                                    emplHlthInsBO.storeEmplHlthIns(
                                            appInEmplHlthPageColl, FwConstants.EMPTY_STRING);
                                }
                            }

                            final int[] driverArray = (int[]) session
                                    .get(FwConstants.RMC_DRIVER);
                            boolean loopingQuestion = false;
                            if (request.get(AppConstants.LOOPING_QUESTION) != null
                                    && FwConstants.YES.equals(request
                                            .get(AppConstants.LOOPING_QUESTION))) {
                                loopingQuestion = true;
                                // Insert into APP_IN_EMPL and APP_IN_EMPL_A_WAGE
                                categorySelectionProfileManager.insertSequenceDetail(
                                        emplHlthProfile, null, null,
                                        categorySeqDetailBean.getIndividualSequence(),
                                        categorySeqDetailBean.getCategoryType());
                                driverManager.makeRequired(FwConstants.RMC_DRIVER,
                                        currentPageID, driverArray, appNumber);
                                driverManager.makeRequired(FwConstants.RMC_DRIVER,
                                        AppConstants.ARUIS, driverArray, appNumber);
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
                                    rmcResponseProfileManager
                                    .makeComplete(
                                            rmcResponseProfileManager
                                            .getResponseByType(
                                                    IRMCResponseProfileManager.EMPL_HLTH_INS_RESP,
                                                    categorySeqDetailBean
                                                    .getCategoryType()),
                                                    rmcInPrflCargo, true);
                                }
                            }
                            driverManager.makeRequired(FwConstants.RMC_DRIVER,
                                    AppConstants.ARUIS, driverArray, appNumber);
                            // Mark complete sequence using common methods
                            categorySelectionProfileManager.makeSequenceDetailComplete(
                                    emplHlthProfile, appNumber,
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
                                    .areAllSequencesComplete(emplHlthProfile)) {
                                driverManager.makeComplete(FwConstants.RMC_DRIVER,
                                        currentPageID, driverArray, appNumber);
                            } else {
                                categorySelectionProfileManager
                                .getNextSequenceDetail(emplHlthProfile);
                            }

        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("storeEmplHealthIns");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "storeEmplHealthIns", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.storeEmplHealthIns() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }
    
    public void eraseEmplInsChanges(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.eraseEmplInsChanges() - START");
        try {
            log(ILog.INFO, "RMCJobIncomeEJBBean::eraseEmplInsChanges::Start");
            final Map session = txnBean.getSession();
            final Map request = txnBean.getRequest();
            final Map pageCollection = txnBean.getPageCollection();
            final Map beforeColl = (Map) session
                    .get(FwConstants.BEFORE_COLLECTION);

            // Get RMCSessionBean from the session
            // Define IndvSeqNum and the SeqNum and Type and RowNum
            String indvSeqNum = null;
            String emplSeqNum = null;
            String emplType = null;

            // Get driver info.
            final int[] driverArray = (int[]) session
                    .get(FwConstants.RMC_DRIVER);

            // Get the APP_IN_EMPL_Collection from pageCollection.
            final APP_IN_EMPL_HEALTH_Collection jobIncColl = (APP_IN_EMPL_HEALTH_Collection) pageCollection
                    .get("APP_IN_EMPL_HEALTH_Collection");
            final APP_IN_EMPL_HEALTH_Cargo jobInCargo = jobIncColl.getResult(0);

            // Get the results from the APP_IN_EMPL_Collection
            final String appNum = (String) session.get(AppConstants.APP_NUMBER);
            indvSeqNum = jobInCargo.getIndv_seq_num();
            emplSeqNum = jobInCargo.getSeq_num();
            emplType = AppConstants.EMPL_HLTH_INS;
            APP_IN_EMPL_HEALTH_Cargo beforeJobInCargo = (APP_IN_EMPL_HEALTH_Cargo) beforeColl
                    .get("APP_IN_EMPL_HEALTH_Cargo");

            final IndivTypeSeqBean seqBean = new IndivTypeSeqBean();
            seqBean.setIndivSeqNum(jobInCargo.getIndv_seq_num());
            seqBean.setSeqNum(jobInCargo.getSeq_num());
            seqBean.setType(AppConstants.EMPL_HLTH_INS);
            seqBean.setUserEndInd("0");
            final IndivTypeSeqBean postIndivSeqBean = (IndivTypeSeqBean) beforeColl
                    .get(AppConstants.INDV_TYPE_SEQ_BEAN);
            boolean eraseData = false;

            if (postIndivSeqBean != null) {
                if (postIndivSeqBean.getIndivSeqNum().equals(
                		seqBean.getIndivSeqNum())
                        && postIndivSeqBean.getSeqNum().equals(
                        		seqBean.getSeqNum())
                                && postIndivSeqBean.getType().equals(
                                		seqBean.getType())) {
                    eraseData = true;
                }
            }
            final RMCEmplHlthInsBO emplHlthInsBO = new RMCEmplHlthInsBO();
            final JobIncomeBO jobIncBO = new JobIncomeBO();
            if (beforeJobInCargo == null || emplHlthInsBO.isDifferentIns(jobInCargo, beforeJobInCargo)
                     || !eraseData) {
            	final PeopleHandler peopleHandler = (PeopleHandler) session
                        .get(AppConstants.INDIV_MASTER_HANDLER);
                final String name = peopleHandler.getFirstName(indvSeqNum);
            	emplHlthInsBO.validateEraseChanges(name);
                request.put(FwConstants.MESSAGE_LIST, emplHlthInsBO.getMessageList());
                beforeJobInCargo = new APP_IN_EMPL_HEALTH_Cargo();
                beforeJobInCargo.setIndv_seq_num(indvSeqNum);
                beforeJobInCargo.setSeq_num(emplSeqNum);               
                beforeColl.put("APP_IN_EMPL_HEALTH_Cargo", beforeJobInCargo);
                beforeColl.put(AppConstants.INDV_TYPE_SEQ_BEAN,
                		seqBean);
                txnBean.setPageCollection(beforeColl);
                return;
            }

            // delete record from database           
            emplHlthInsBO.deleteModifiedRecords(indvSeqNum, emplSeqNum, appNum);
            emplHlthInsBO.deleteModifiedDependentRecords(indvSeqNum, emplSeqNum, appNum);
            APP_IN_EMPL_Collection emplColl = jobIncBO.loadDetails(appNum, indvSeqNum, emplSeqNum);
            APP_IN_EMPL_Cargo emplCargo = null;            
            	//update RM/ RN cargo          	
            	for(int i=0; i<emplColl.size(); i++){          		
            		if(!emplColl.getCargo(i).getSrc_app_ind().equals(AppConstants.CWW_RECORD_IND)){
            			emplCargo = emplColl.getCargo(i);
            			emplCargo.setEr_provd_med_ins_ind(AppConstants.NO);
            			emplCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
            		}
            	}
            	if(emplCargo!=null){
            		APP_IN_EMPL_Collection updateColl = new APP_IN_EMPL_Collection();
                	updateColl.addCargo(emplCargo);
                	updateColl.persist(FwConstants.DAO);
            	}
            	
           
            String catEmpTyp = AppConstants.EMPL_HLTH_INS;
            

            // delete record from rmc selection profile
            final SortedSet rmcSelPrfl = (SortedSet) session
                    .get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
            categorySelectionProfileManager.removeSequenceDetail(rmcSelPrfl,
                    appNum, Short.parseShort(indvSeqNum),
                    Long.parseLong(emplSeqNum), catEmpTyp);
            final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
                    .get(AppConstants.RMC_IN_PRFL_MASTER);
            boolean rmcPrflNotRequeired = false;
            // here we need to check we have no entrys in rmcPrfl for the job
            // income detail
            // as well as we need to check
            if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
                if (rmcResponseProfileManager.isAppResponseNotRequired(
                        rmcInPrflColl, IRMCResponseProfileManager.EMPL_HLTH_INS_RESP)) {
                    if (rmcResponseProfileManager.isAppResponseNotRequired(
                            rmcInPrflColl,
                            IRMCResponseProfileManager.EMPL_HLTH_INS_RESP)) {
                        rmcPrflNotRequeired = true;
                    }
                }
            } else {
                rmcPrflNotRequeired = true;
            }

            final String[] pageId = { "AREHI" };

            final Map catType = new HashMap();
            catType.put(AppConstants.EMPL_HLTH_INS, AppConstants.EMPL_HLTH_INS);

            if (categorySelectionProfileManager.isRemoved(rmcSelPrfl, catType)
                    && rmcPrflNotRequeired) {
                driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
                        pageId, driverArray, appNum);
            }
            session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER, rmcSelPrfl);
            driverManager.makeRequired(FwConstants.RMC_DRIVER,
                    AppConstants.ARJIS, driverArray, appNum);

            // End
            log(ILog.INFO, "RMCJobIncomeEJBBean::eraseEmplInsChanges::End");
        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("eraseEmplInsChanges");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "eraseEmplInsChanges", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.eraseEmplInsChanges() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }
    
    public void eraseEmplInsNew(final FwTransaction txnBean)
            throws javax.ejb.EJBException {
        final long startTime = System.currentTimeMillis();
        log(ILog.INFO, "RMCJobIncomeEJBBean.eraseEmplInsChanges() - START");
        try {
            log(ILog.INFO, "RMCJobIncomeEJBBean::eraseEmplInsChanges::Start");
            final Map session = txnBean.getSession();
            final Map request = txnBean.getRequest();
            final Map pageCollection = txnBean.getPageCollection();
            final Map beforeColl = (Map) session
                    .get(FwConstants.BEFORE_COLLECTION);

            // Get RMCSessionBean from the session
            // Define IndvSeqNum and the SeqNum and Type and RowNum
            String indvSeqNum = null;
            String emplSeqNum = null;
            String emplType = null;

            // Get driver info.
            final int[] driverArray = (int[]) session
                    .get(FwConstants.RMC_DRIVER);

            // Get the APP_IN_EMPL_Collection from pageCollection.
            final APP_IN_EMPL_HEALTH_Collection jobIncColl = (APP_IN_EMPL_HEALTH_Collection) pageCollection
                    .get("APP_IN_EMPL_HEALTH_Collection");
            final APP_IN_EMPL_HEALTH_Cargo jobInCargo = jobIncColl.getResult(0);

            // Get the results from the APP_IN_EMPL_Collection
            final String appNum = (String) session.get(AppConstants.APP_NUMBER);
            indvSeqNum = jobInCargo.getIndv_seq_num();
            emplSeqNum = jobInCargo.getSeq_num();
            emplType = AppConstants.EMPL_HLTH_INS;
            APP_IN_EMPL_HEALTH_Cargo beforeJobInCargo = (APP_IN_EMPL_HEALTH_Cargo) beforeColl
                    .get("APP_IN_EMPL_HEALTH_Cargo");

            final IndivTypeSeqBean seqBean = new IndivTypeSeqBean();
            seqBean.setIndivSeqNum(jobInCargo.getIndv_seq_num());
            seqBean.setSeqNum(jobInCargo.getSeq_num());
            seqBean.setType(AppConstants.EMPL_HLTH_INS);
            seqBean.setUserEndInd("0");
            final IndivTypeSeqBean postIndivSeqBean = (IndivTypeSeqBean) beforeColl
                    .get(AppConstants.INDV_TYPE_SEQ_BEAN);
            boolean eraseData = false;

            if (postIndivSeqBean != null) {
                if (postIndivSeqBean.getIndivSeqNum().equals(
                		seqBean.getIndivSeqNum())
                        && postIndivSeqBean.getSeqNum().equals(
                        		seqBean.getSeqNum())
                                && postIndivSeqBean.getType().equals(
                                		seqBean.getType())) {
                    eraseData = true;
                }
            }
            final RMCEmplHlthInsBO emplHlthInsBO = new RMCEmplHlthInsBO();
            final JobIncomeBO jobIncBO = new JobIncomeBO();
            if (beforeJobInCargo == null || emplHlthInsBO.isDifferentIns(jobInCargo, beforeJobInCargo)
                     || !eraseData) {
            	final PeopleHandler peopleHandler = (PeopleHandler) session
                        .get(AppConstants.INDIV_MASTER_HANDLER);
                final String name = peopleHandler.getFirstName(indvSeqNum);
            	emplHlthInsBO.validateErase(name);
                request.put(FwConstants.MESSAGE_LIST, emplHlthInsBO.getMessageList());
                beforeJobInCargo = new APP_IN_EMPL_HEALTH_Cargo();
                beforeJobInCargo.setIndv_seq_num(indvSeqNum);
                beforeJobInCargo.setSeq_num(emplSeqNum);               
                beforeColl.put("APP_IN_EMPL_HEALTH_Cargo", beforeJobInCargo);
                beforeColl.put(AppConstants.INDV_TYPE_SEQ_BEAN,
                		seqBean);
                txnBean.setPageCollection(beforeColl);
                return;
            }

            // delete record from database           
            emplHlthInsBO.deleteModifiedRecords(indvSeqNum, emplSeqNum, appNum);
            emplHlthInsBO.deleteModifiedDependentRecords(indvSeqNum, emplSeqNum, appNum);
            APP_IN_EMPL_Collection emplColl = jobIncBO.loadDetails(appNum, indvSeqNum, emplSeqNum);
            APP_IN_EMPL_Cargo emplCargo = null;            
            	//update RM/ RN cargo          	
            	for(int i=0; i<emplColl.size(); i++){          		
            		if(!emplColl.getCargo(i).getSrc_app_ind().equals(AppConstants.CWW_RECORD_IND)){
            			emplCargo = emplColl.getCargo(i);
            			emplCargo.setEr_provd_med_ins_ind(AppConstants.NO);
            			emplCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
            		}
            	}
            	if(emplCargo!=null){
            		APP_IN_EMPL_Collection updateColl = new APP_IN_EMPL_Collection();
                	updateColl.addCargo(emplCargo);
                	updateColl.persist(FwConstants.DAO);
            	}
            	
           
            String catEmpTyp = AppConstants.EMPL_HLTH_INS;
            

            // delete record from rmc selection profile
            final SortedSet rmcSelPrfl = (SortedSet) session
                    .get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
            categorySelectionProfileManager.removeSequenceDetail(rmcSelPrfl,
                    appNum, Short.parseShort(indvSeqNum),
                    Long.parseLong(emplSeqNum), catEmpTyp);
            final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
                    .get(AppConstants.RMC_IN_PRFL_MASTER);
            boolean rmcPrflNotRequeired = false;
            // here we need to check we have no entrys in rmcPrfl for the job
            // income detail
            // as well as we need to check
            if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
                if (rmcResponseProfileManager.isAppResponseNotRequired(
                        rmcInPrflColl, IRMCResponseProfileManager.EMPL_HLTH_INS_RESP)) {
                    if (rmcResponseProfileManager.isAppResponseNotRequired(
                            rmcInPrflColl,
                            IRMCResponseProfileManager.EMPL_HLTH_INS_RESP)) {
                        rmcPrflNotRequeired = true;
                    }
                }
            } else {
                rmcPrflNotRequeired = true;
            }

            final String[] pageId = { "AREHI" };

            final Map catType = new HashMap();
            catType.put(AppConstants.EMPL_HLTH_INS, AppConstants.EMPL_HLTH_INS);

            if (categorySelectionProfileManager.isRemoved(rmcSelPrfl, catType)
                    && rmcPrflNotRequeired) {
                driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
                        pageId, driverArray, appNum);
            }
            session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER, rmcSelPrfl);
            driverManager.makeRequired(FwConstants.RMC_DRIVER,
                    AppConstants.ARJIS, driverArray, appNum);

            // End
            log(ILog.INFO, "RMCJobIncomeEJBBean::eraseEmplInsChanges::End");
        } catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwWrappedException we = new FwWrappedException(fe);
            we.setCallingClassID(this.getClass().getName());
            we.setCallingMethodID("eraseEmplInsChanges");
            we.setFwException(fe);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
            final FwException fe = createFwException(this.getClass().getName(),
                    "eraseEmplInsChanges", e);
            throw rmcJobIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
        }

        log(ILog.INFO,
                "RMCJobIncomeEJBBean.eraseEmplInsChanges() - END , Time Taken : "
                        + (System.currentTimeMillis() - startTime)
                        + AppConstants.SPACE + AppConstants.MILLISECONDS);
    }
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public FwException exceptionManagerLog(Exception e, String className,
			String methodName) {
		return super.exceptionManagerLog(e, className, methodName);
	}
}
