package gov.state.nextgen.access.business.services;

import gov.state.nextgen.access.business.customEntities.INDIVIDUAL_Custom_Cargo;
import gov.state.nextgen.access.business.customEntities.INDIVIDUAL_Custom_Collection;
import gov.state.nextgen.access.business.customEntities.OTHER_INCOME_Custom_Cargo;
import gov.state.nextgen.access.business.customEntities.RMC_RESPONSE_Custom_Cargo;
import gov.state.nextgen.access.business.customEntities.RMC_RESPONSE_Custom_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_EMPL_Cargo;
import gov.state.nextgen.access.business.entities.APP_IN_EMPL_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_EMPL_HEALTH_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_RM_BRD_INCM_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_UEI_Cargo;
import gov.state.nextgen.access.business.entities.APP_IN_UEI_Collection;
import gov.state.nextgen.access.business.entities.NO_ONE_Collection;
import gov.state.nextgen.access.business.entities.RMB_RQST_Cargo;
import gov.state.nextgen.access.business.entities.RMB_RQST_Collection;
import gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Cargo;
import gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Collection;
import gov.state.nextgen.access.business.rules.ABFinalSubmitBO;
import gov.state.nextgen.access.business.rules.ABJobIncomeBO;
import gov.state.nextgen.access.business.rules.employment.JobIncomeBO;
import gov.state.nextgen.access.business.rules.employment.OtherIncomeBO;
import gov.state.nextgen.access.business.rules.household.HouseHoldInfoBO;
import gov.state.nextgen.access.business.validation.ChangingValidation;
import gov.state.nextgen.access.business.validation.rmc.details.ARUIDValidator;
import gov.state.nextgen.access.business.validation.rmc.questions.AROIQValidator;
import gov.state.nextgen.access.management.applications.CategorySequenceDetail;
import gov.state.nextgen.access.management.applications.IApplicationManager;
import gov.state.nextgen.access.management.applications.IRMCResponseProfileManager;
import gov.state.nextgen.access.management.applications.QuestionsExtractionHandler;
import gov.state.nextgen.access.management.applications.RMBRequestManager;
import gov.state.nextgen.access.management.applications.RMCResponseProfileManager;
import gov.state.nextgen.access.management.constants.AppConstants;
import gov.state.nextgen.access.management.individuals.PeopleHandler;
import gov.state.nextgen.access.management.util.IndivTypeSeqBean;
import gov.state.nextgen.access.presentation.entities.listview.RMBOtherIncomeIndvGatePostListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCAmericanIndianIncomeSelectionListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCAmericanIndianPaymentsListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCContributionsIncomeSelectionListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCDCSSIncomeSelectionListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCDirectChildSupportIncomeSelectionListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCJobIncomeSummaryHealthInsListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCOtherIncomeAmericanIndianSummaryListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCOtherIncomeContrSummaryListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCOtherIncomeDCSSSummaryListVIew;
import gov.state.nextgen.access.presentation.entities.listview.RMCOtherIncomeDirChildSummaryListVIew;
import gov.state.nextgen.access.presentation.entities.listview.RMCOtherIncomeOthOthIncSummaryListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCOtherIncomeRSDISummaryListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCOtherIncomeSSISummaryListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCOtherIncomeTypeSelectionListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCOtherIncomeVetSummaryListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCRSDISupportIncomeSelectionListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCSSISupportIncomeSelectionListView;
import gov.state.nextgen.access.presentation.entities.listview.RMCVetSupportIncomeSelectionListView;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.apache.commons.lang.exception.ExceptionUtils;

/**
 * RMCOtherIncomeEJBBean - SessionFacade Object skeleton auto generated -
 * Architecture Team.
 *
 * Creation Date :Tue Feb 06 13:47:45 CST 2007 Modified By: Modified on:
 */
@javax.ejb.Stateless
@javax.ejb.LocalBean
@javax.ejb.TransactionManagement(javax.ejb.TransactionManagementType.CONTAINER)
public class RMCOtherIncomeEJBBean extends RMCSessionBean {

	@EJB
	private RMCOtherIncomeEJBBean rmcOtherIncomeEJBBean;
	/**
	 * Constructor.
	 */
	public RMCOtherIncomeEJBBean() {
	}

	/**
	 * Comment here.
	 *
	 * @param txnBean the txn bean
	 \* @throws javax.ejb.EJBException the EJB exception
	 */
	public void loadOtherIncomeIndvSelection(final FwTransaction txnBean)
			throws javax.ejb.EJBException {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.loadOtherIncomeIndvSelection() - START");
		try {

			final Map session = txnBean.getSession();
			Map pageCollection = txnBean.getPageCollection();
			final Map request = txnBean.getRequest();
			final PeopleHandler peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);
			final INDIVIDUAL_Custom_Collection indvColl = peopleHandler
					.getInHomeIndividuals();
			// Extraction process needs all the individuals from people handle
			// don't comment this line
			final INDIVIDUAL_Custom_Collection extractionIndvColl = indvColl;
			// Getting language from http session
			final Map httpSessionMap = (Map) session
					.get(FwConstants.HTTP_SESSION);
			final String language = (String) httpSessionMap
					.get(AppConstants.LANGUAGE);
			final String jsEnabled = (String) httpSessionMap
					.get(FwConstants.JS_ENABLED);
			final String aAppNum = (String) session
					.get(AppConstants.APP_NUMBER);
			log(ILog.DEBUG, "***** App Number : " + aAppNum);
			final OtherIncomeBO otherIncomeBO = new OtherIncomeBO();
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			final HouseHoldInfoBO hhBO = new HouseHoldInfoBO();
			final long acaseNum = hhBO.getcaseNumber(aAppNum);
			final int driverStatus = driverManager.getAFBStatus(
					FwConstants.RMC_DRIVER,
					(String) request.get(FwConstants.CURRENT_PAGE_ID),
					driverArray);

			driverManager.getStatus(FwConstants.RMC_DRIVER, "ARUIT",
					driverArray);
			// RMC Extraction Changes starts
			final boolean[] categoryExtratFlags = (boolean[]) session
					.get(AppConstants.RMC_EXTRACTION_FLAGS);
			if(null != categoryExtratFlags) {
				categoryExtratFlags[AppConstants.RMC_EXT_OI_INDEX] = true;
				if (!categoryExtratFlags[AppConstants.RMC_EXT_OI_INDEX]) {
	
					final Map pinNumMap = new HashMap();
					final List pinNumList = new ArrayList();
					final int indvCollSize = extractionIndvColl.size();
					INDIVIDUAL_Custom_Cargo indivCustCargo = null;
					APP_IN_UEI_Collection otherIncColl = null;
					OTHER_INCOME_Custom_Cargo otherIncCustCargo = null;
					// Filter pin numbers which are null (new individuals)
					String pinNumber = null;
					for (int i = 0; i < indvCollSize; i++) {
						indivCustCargo = extractionIndvColl.getResult(i);
						pinNumber = indivCustCargo.getIndv_pin_num();
						indivCustCargo.getIndv_seq_num();
						if (pinNumber != null) {
							pinNumList.add(indivCustCargo.getIndv_pin_num());
						}
						if (pinNumber != null) {
							pinNumMap.put(indivCustCargo.getIndv_pin_num(),
									indivCustCargo.getIndv_seq_num());
	
						}
					}
					try {
						if (pinNumMap != null && !pinNumMap.isEmpty()) {
							otherIncCustCargo = otherIncomeBO
									.getOtherIncomeDetailsFromCares(pinNumMap,
											aAppNum, String.valueOf(acaseNum));
							if (otherIncCustCargo != null) {
								otherIncColl = otherIncCustCargo.getUeColl();
							}
						}
					} catch (final FwException fe) {
						fe.setParameterText("Pin List is: " + pinNumList.toString()
								+ " AppNumber is: " + aAppNum);
						final FwWrappedException we = new FwWrappedException(fe);
						we.setCallingClassID(this.getClass().getName());
						we.setCallingMethodID("loadOtherIncomeIndvSelection");
						we.setFwException(fe);
						final FwExceptionManager exceptionMgr = (FwExceptionManager) FwServiceFactory
								.getInstance().create(IException.class);
						exceptionMgr.log(we);
						return;
	
					} catch (final Exception e) {
						final FwException fe = createFwException(this.getClass()
								.getName(), "getOtherIncomeDetailsFromCares", e);
						fe.setParameterText("Pin List is: " + pinNumList.toString()
								+ " AppNumber is: " + aAppNum);
						final FwWrappedException we = new FwWrappedException(e);
						we.setCallingClassID(this.getClass().getName());
						we.setCallingMethodID("loadOtherIncomeIndvSelection");
						we.setFwException(fe);
						final FwExceptionManager exceptionMgr = (FwExceptionManager) FwServiceFactory
								.getInstance().create(IException.class);
						exceptionMgr.log(we);
						return;
					}
					if (otherIncColl != null) {
						otherIncomeBO.insertExistingDetails(otherIncColl);
						categoryExtratFlags[AppConstants.RMC_EXT_OI_INDEX] = true;
						session.put(AppConstants.RMC_EXTRACTION_FLAGS,
								categoryExtratFlags);
					}
				}
			}
			// RMC Extraction Changes ends

			final APP_IN_UEI_Collection ueiColl = otherIncomeBO
					.getDataForlistViewData(aAppNum);
			final APP_IN_UEI_Collection dcssColl = otherIncomeBO
					.getDataForDcssListView(aAppNum);
			final APP_IN_UEI_Collection dirchldColl = otherIncomeBO
					.getDataForDirectChildSuppListView(aAppNum);
			final APP_IN_UEI_Collection ssiColl = otherIncomeBO
					.getDataForSSIListView(aAppNum);
			final APP_IN_UEI_Collection rsdiColl = otherIncomeBO
					.getDataForRSDIListView(aAppNum);
			final APP_IN_UEI_Collection vetColl = otherIncomeBO
					.getDataForVetListView(aAppNum);
			final APP_IN_UEI_Collection contColl = otherIncomeBO
					.getDataForContListView(aAppNum);
			final APP_IN_UEI_Collection trblColl = otherIncomeBO
					.getDataForTrblListView(aAppNum);
			final APP_IN_UEI_Collection indnColl = otherIncomeBO
					.getDataForIndnListView(aAppNum);
			final APP_IN_UEI_Collection otherIncomeColl = otherIncomeBO
					.getDataForOtherIncListView(aAppNum);

			SortedSet selectionProfile = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			boolean loadCatSelProfile = false;
			if ((selectionProfile == null || selectionProfile.isEmpty())
					&& driverStatus != FwConstants.DRIVER_NOT_REQUIRED) {
				// load selection profile from the data base
				loadCatSelProfile = true;
			} else if (selectionProfile != null && !selectionProfile.isEmpty()) {
				// here we need to check the session profile is other income
				// session profile
				CategorySequenceDetail catSeqDetail = categorySelectionProfileManager
						.getCurrentSequenceDetail(selectionProfile);
				if (catSeqDetail == null) {
					catSeqDetail = categorySelectionProfileManager
							.getNextSequenceDetail(selectionProfile);
					if (catSeqDetail != null
							&& AppConstants.RMC_CAT_OT_INC_PRFL
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
				selectionProfile = categorySelectionProfileManager
						.loadCategoryChangeSelectionProfile(aAppNum,
								AppConstants.RMC_CAT_OT_INC_PRFL);
				session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER,
						selectionProfile);
			}

			// Getting RMC_IN_PROFILE from session
			final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);

			// for room and board and tribal benefits
			componentManager.getComponents(
					(String) request.get(FwConstants.CURRENT_PAGE_ID), txnBean);
			pageCollection = createAndLoadResponseMapsToPageCollection(
					rmcInPrflColl, pageCollection, peopleHandler, true,
					driverStatus);

			session.put(AppConstants.RMC_IN_PRFL_MASTER, rmcInPrflColl);
			log(ILog.DEBUG,
					"RMCOtherIncomeEJBBean.loadOtherIncomeIndvSelection() - populating listview dataLists for ARUII");
			final List dcssDataList = new ArrayList(5);
			dcssDataList.add(dcssColl);
			dcssDataList.add(indvColl);
			dcssDataList.add(selectionProfile);
			dcssDataList.add(rmcInPrflColl);
			dcssDataList.add(driverStatus);
			

			final List dirChldDataList = new ArrayList(5);
			dirChldDataList.add(dirchldColl);
			dirChldDataList.add(indvColl);
			dirChldDataList.add(selectionProfile);
			dirChldDataList.add(rmcInPrflColl);
			dirChldDataList.add(driverStatus);

			final List ssiDataList = new ArrayList(5);
			ssiDataList.add(ssiColl);
			ssiDataList.add(indvColl);
			ssiDataList.add(selectionProfile);
			ssiDataList.add(rmcInPrflColl);
			ssiDataList.add(driverStatus);

			final List rsdiiDataList = new ArrayList(5);
			rsdiiDataList.add(rsdiColl);
			rsdiiDataList.add(indvColl);
			rsdiiDataList.add(selectionProfile);
			rsdiiDataList.add(rmcInPrflColl);
			rsdiiDataList.add(driverStatus);

			final List vetDataList = new ArrayList(5);
			vetDataList.add(vetColl);
			vetDataList.add(indvColl);
			vetDataList.add(selectionProfile);
			vetDataList.add(rmcInPrflColl);
			vetDataList.add(driverStatus);

			final List contDataList = new ArrayList(5);
			contDataList.add(contColl);
			contDataList.add(indvColl);
			contDataList.add(selectionProfile);
			contDataList.add(rmcInPrflColl);
			contDataList.add(driverStatus);

			final List trblDataList = new ArrayList(5);
			trblDataList.add(trblColl);
			trblDataList.add(indvColl);
			trblDataList.add(selectionProfile);
			trblDataList.add(rmcInPrflColl);
			trblDataList.add(driverStatus);

			final List indnDataList = new ArrayList(5);
			indnDataList.add(indnColl);
			indnDataList.add(indvColl);
			indnDataList.add(selectionProfile);
			indnDataList.add(rmcInPrflColl);
			indnDataList.add(driverStatus);

			final List othIncTypeDataList = new ArrayList(5);
			othIncTypeDataList.add(otherIncomeColl);
			othIncTypeDataList.add(indvColl);
			othIncTypeDataList.add(selectionProfile);
			othIncTypeDataList.add(rmcInPrflColl);
			othIncTypeDataList.add(driverStatus);
			
			log(ILog.DEBUG,
					"RMCOtherIncomeEJBBean.loadOtherIncomeIndvSelection() - building ListViews for ARUII");
			
			final RMCDCSSIncomeSelectionListView rmcDCSSIncomeSelectionListView = new RMCDCSSIncomeSelectionListView();
			rmcDCSSIncomeSelectionListView.setLanguage(language);
			rmcDCSSIncomeSelectionListView
			.setJsEnabled(jsEnabled);
			rmcDCSSIncomeSelectionListView
			.setName("OTHER_INCOME_DCSS_SELECTION_LISTVIEW");
			rmcDCSSIncomeSelectionListView
			.setCollection(indvColl);
			rmcDCSSIncomeSelectionListView
			.setDisplayData(dcssDataList);
			rmcDCSSIncomeSelectionListView.setPageSize(1000);
			log(ILog.DEBUG,
					"RMCOtherIncomeEJBBean.loadOtherIncomeIndvSelection() - after RMCDCSSIncomeSelectionListView");

			final RMCDirectChildSupportIncomeSelectionListView rmcDirectChildSupportIncomeSelectionListView = new RMCDirectChildSupportIncomeSelectionListView();
			rmcDirectChildSupportIncomeSelectionListView.setLanguage(language);
			rmcDirectChildSupportIncomeSelectionListView
			.setJsEnabled(jsEnabled);
			rmcDirectChildSupportIncomeSelectionListView
			.setName("OTHER_INCOME_DIRCHLD_SELECTION_LISTVIEW");
			rmcDirectChildSupportIncomeSelectionListView
			.setCollection(indvColl);
			rmcDirectChildSupportIncomeSelectionListView
			.setDisplayData(dirChldDataList);
			rmcDirectChildSupportIncomeSelectionListView.setPageSize(1000);
			log(ILog.DEBUG,
					"RMCOtherIncomeEJBBean.loadOtherIncomeIndvSelection() - after RMCDirectChildSupportIncomeSelectionListView");

			final RMCSSISupportIncomeSelectionListView rmcSSISupportIncomeSelectionListView = new RMCSSISupportIncomeSelectionListView();
			rmcSSISupportIncomeSelectionListView.setLanguage(language);
			rmcSSISupportIncomeSelectionListView.setJsEnabled(jsEnabled);
			rmcSSISupportIncomeSelectionListView
			.setName("OTHER_INCOME_SSI_SELECTION_LISTVIEW");
			rmcSSISupportIncomeSelectionListView.setCollection(indvColl);
			rmcSSISupportIncomeSelectionListView.setDisplayData(ssiDataList);
			rmcSSISupportIncomeSelectionListView.setPageSize(1000);
			log(ILog.DEBUG,
					"RMCOtherIncomeEJBBean.loadOtherIncomeIndvSelection() - after RMCSSISupportIncomeSelectionListView");

			final RMCRSDISupportIncomeSelectionListView rmcRSDISupportIncomeSelectionListView = new RMCRSDISupportIncomeSelectionListView();
			rmcRSDISupportIncomeSelectionListView.setLanguage(language);
			rmcRSDISupportIncomeSelectionListView.setJsEnabled(jsEnabled);
			rmcRSDISupportIncomeSelectionListView
			.setName("OTHER_INCOME_RSDI_SELECTION_LISTVIEW");
			rmcRSDISupportIncomeSelectionListView.setCollection(indvColl);
			rmcRSDISupportIncomeSelectionListView.setDisplayData(rsdiiDataList);
			rmcRSDISupportIncomeSelectionListView.setPageSize(1000);
			log(ILog.DEBUG,
					"RMCOtherIncomeEJBBean.loadOtherIncomeIndvSelection() - after RMCRSDISupportIncomeSelectionListView");

			final RMCVetSupportIncomeSelectionListView rmcVetSupportIncomeSelectionListView = new RMCVetSupportIncomeSelectionListView();
			rmcVetSupportIncomeSelectionListView.setLanguage(language);
			rmcVetSupportIncomeSelectionListView.setJsEnabled(jsEnabled);
			rmcVetSupportIncomeSelectionListView
			.setName("OTHER_INCOME_VET_SELECTION_LISTVIEW");
			rmcVetSupportIncomeSelectionListView.setCollection(indvColl);
			rmcVetSupportIncomeSelectionListView.setDisplayData(vetDataList);
			rmcVetSupportIncomeSelectionListView.setPageSize(1000);
			log(ILog.DEBUG,
					"RMCOtherIncomeEJBBean.loadOtherIncomeIndvSelection() - after RMCVetSupportIncomeSelectionListView");

			final RMCContributionsIncomeSelectionListView rmcContributionsIncomeSelectionListView = new RMCContributionsIncomeSelectionListView();
			rmcContributionsIncomeSelectionListView.setLanguage(language);
			rmcContributionsIncomeSelectionListView.setJsEnabled(jsEnabled);
			rmcContributionsIncomeSelectionListView
			.setName("OTHER_INCOME_CONT_SELECTION_LISTVIEW");
			rmcContributionsIncomeSelectionListView.setCollection(indvColl);
			rmcContributionsIncomeSelectionListView
			.setDisplayData(contDataList);
			rmcContributionsIncomeSelectionListView.setPageSize(1000);
			log(ILog.DEBUG,
					"RMCOtherIncomeEJBBean.loadOtherIncomeIndvSelection() - after RMCContributionsIncomeSelectionListView");

			final RMCAmericanIndianIncomeSelectionListView rmcAmericanIndianIncomeSelectionListView = new RMCAmericanIndianIncomeSelectionListView();
			rmcAmericanIndianIncomeSelectionListView.setLanguage(language);
			rmcAmericanIndianIncomeSelectionListView.setJsEnabled(jsEnabled);
			rmcAmericanIndianIncomeSelectionListView
			.setName("OTHER_INCOME_TRBL_SELECTION_LISTVIEW");
			rmcAmericanIndianIncomeSelectionListView.setCollection(indvColl);
			rmcAmericanIndianIncomeSelectionListView
			.setDisplayData(trblDataList);
			rmcAmericanIndianIncomeSelectionListView.setPageSize(1000);
			log(ILog.DEBUG,
					"RMCOtherIncomeEJBBean.loadOtherIncomeIndvSelection() - after RMCAmericanIndianIncomeSelectionListView");

			final RMCAmericanIndianPaymentsListView rmcAmericanIndianPaymentsListView = new RMCAmericanIndianPaymentsListView();
			rmcAmericanIndianPaymentsListView.setLanguage(language);
			rmcAmericanIndianPaymentsListView.setJsEnabled(jsEnabled);
			rmcAmericanIndianPaymentsListView
			.setName("OTHER_INCOME_INDN_SELECTION_LISTVIEW");
			rmcAmericanIndianPaymentsListView.setCollection(indvColl);
			rmcAmericanIndianPaymentsListView.setDisplayData(indnDataList);
			rmcAmericanIndianPaymentsListView.setPageSize(1000);
			log(ILog.DEBUG,
					"RMCOtherIncomeEJBBean.loadOtherIncomeIndvSelection() - after RMCAmericanIndianPaymentsListView");

			final RMCOtherIncomeTypeSelectionListView rmcOtherIncomeTypeSelectionListView = new RMCOtherIncomeTypeSelectionListView();
			rmcOtherIncomeTypeSelectionListView.setLanguage(language);
			rmcOtherIncomeTypeSelectionListView.setJsEnabled(jsEnabled);
			rmcOtherIncomeTypeSelectionListView
			.setName("OTHER_INCOME_OTHTYPE_SELECTION_LISTVIEW");
			rmcOtherIncomeTypeSelectionListView.setCollection(indvColl);
			rmcOtherIncomeTypeSelectionListView
			.setDisplayData(othIncTypeDataList);
			rmcOtherIncomeTypeSelectionListView.setPageSize(1000);
			log(ILog.DEBUG,
					"RMCOtherIncomeEJBBean.loadOtherIncomeIndvSelection() - after RMCOtherIncomeTypeSelectionListView");

			pageCollection.put("OTHER_INCOME_DCSS_SELECTION_LISTVIEW", 
					rmcDCSSIncomeSelectionListView);
			pageCollection.put("OTHER_INCOME_DIRCHLD_SELECTION_LISTVIEW",
					rmcDirectChildSupportIncomeSelectionListView);
			pageCollection.put("OTHER_INCOME_SSI_SELECTION_LISTVIEW",
					rmcSSISupportIncomeSelectionListView);
			pageCollection.put("OTHER_INCOME_RSDI_SELECTION_LISTVIEW",
					rmcRSDISupportIncomeSelectionListView);
			pageCollection.put("OTHER_INCOME_VET_SELECTION_LISTVIEW",
					rmcVetSupportIncomeSelectionListView);
			pageCollection.put("OTHER_INCOME_CONT_SELECTION_LISTVIEW",
					rmcContributionsIncomeSelectionListView);
			pageCollection.put("OTHER_INCOME_TRBL_SELECTION_LISTVIEW",
					rmcAmericanIndianIncomeSelectionListView);
			pageCollection.put("OTHER_INCOME_INDN_SELECTION_LISTVIEW",
					rmcAmericanIndianPaymentsListView);
			pageCollection.put("OTHER_INCOME_OTHTYPE_SELECTION_LISTVIEW",
					rmcOtherIncomeTypeSelectionListView);
			pageCollection.put("INDV_COLL", indvColl);
			pageCollection.put("OTHER_INCOME", ueiColl);
			pageCollection.put("DCSS_COLL", dcssColl);
			pageCollection.put("DIRCHLD_COLL", dirchldColl);
			pageCollection.put("SSI_COLL", ssiColl);
			pageCollection.put("RSDI_COLL", rsdiColl);
			pageCollection.put("VET_COLL", vetColl);
			pageCollection.put("CONT_COLL", contColl);
			pageCollection.put("TRBL_COLL", trblColl);
			pageCollection.put("INDN_COLL", indnColl);
			pageCollection.put("OTHTYPE_COLL", otherIncomeColl);

			// set pageCollection into transaction Bean
			txnBean.setPageCollection(pageCollection);
			// set before collection to pageCollection
			session.put(FwConstants.BEFORE_COLLECTION,
					txnBean.getPageCollection());

		} catch (final FwException fe) {
			log(ILog.ERROR, fe.inspectException());
			log(ILog.ERROR, ExceptionUtils.getFullStackTrace(fe));
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("loadOtherIncomeIndvSelection");
			we.setFwException(fe);
			throw rmcOtherIncomeEJBBean.rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			log(ILog.ERROR, ExceptionUtils.getFullStackTrace(e));
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"loadOtherIncomeIndvSelection", e);
			throw rmcOtherIncomeEJBBean.rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.loadOtherIncomeIndvSelection() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

	/**
	 * Comment here.
	 *
	 * @param txnBean the txn bean
	 \* @throws javax.ejb.EJBException the EJB exception
	 */
	public void storeOtherIncomeIndvSelection(final FwTransaction txnBean)
			throws javax.ejb.EJBException {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.storeOtherIncomeIndvSelection() - START");
		try {

			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			Map pageCollection = txnBean.getPageCollection();
			final String currentPageID = (String) request
					.get(FwConstants.CURRENT_PAGE_ID);

			final PeopleHandler peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);
			SortedSet categorySelectionProfile = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			// Get App Number
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			RMC_RESPONSE_Custom_Collection beforeRespColl = (RMC_RESPONSE_Custom_Collection) pageCollection
					.get("RMC_RESPONSE_Custom_Collection");
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			final int driverStatus = driverManager.getAFBStatus(
					FwConstants.RMC_DRIVER,
					(String) request.get(FwConstants.CURRENT_PAGE_ID),
					driverArray);
			final OtherIncomeBO othIncomeBO = new OtherIncomeBO();
			beforeRespColl = othIncomeBO.formatResponse(beforeRespColl);
			final RMC_RESPONSE_Custom_Collection respColl = new RMC_RESPONSE_Custom_Collection();
			for (int i = 0; i < beforeRespColl.size(); i++) {
				RMC_RESPONSE_Custom_Cargo rmcCustomCargo = null;
				rmcCustomCargo = beforeRespColl.getCargo(i);
				if (!FwConstants.NO.equalsIgnoreCase(rmcCustomCargo
						.getResponse())) {
					respColl.add(rmcCustomCargo);
				}
			}

			// get the BeforeCollection
			final Map beforeColl = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);
			final short[] responseArray = new short[] {
					IRMCResponseProfileManager.CHILD_SUPPORT_COURT,
					IRMCResponseProfileManager.CHILD_SUPPORT_PAYMENT,
					IRMCResponseProfileManager.RECEIVE_SSI,
					IRMCResponseProfileManager.RECEIVE_SOCIAL_SECURITY,
					IRMCResponseProfileManager.BENEFIT_VETERAN,
					IRMCResponseProfileManager.OTHR_INCM_CONTRIB_RESP,
					IRMCResponseProfileManager.OTHR_INCM_TRBL_RESP,
					IRMCResponseProfileManager.OTH_IND_GAMBL_PMNTS,
					IRMCResponseProfileManager.OTHER_INCOME };
			final short[] questionsArray = new short[] { IRMCResponseProfileManager.ROOM_AND_BOARD };
			// Getting RMC_IN_PROFILE from session
			RMC_IN_PRFL_Collection rmcInPrflSessColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			final RMC_IN_PRFL_Collection rmcInPrflFromPageColl = (RMC_IN_PRFL_Collection) pageCollection
					.get("RMC_IN_PRFL_Collection");

			boolean indvSelected = false;
			if (!rmcInPrflFromPageColl.isEmpty()) {
				indvSelected = true;
			}
			int size = respColl.size();
			RMC_RESPONSE_Custom_Cargo rmcCustomCargo = null;
			RMC_IN_PRFL_Collection rmcPrflPageColl = null;
			RMC_IN_PRFL_Cargo rmcPrflSessCargo = null;
			RMC_IN_PRFL_Cargo rmcPrflPageCargo = null;
			String seqNum = null;
			String indvSeqNum = null;
			boolean addInd = false;

			final Map assetValidationMap = new HashMap();
			assetValidationMap.put("DCSS_COLL", beforeColl.get("DCSS_COLL"));
			assetValidationMap.put("DIRCHLD_COLL",
					beforeColl.get("DIRCHLD_COLL"));
			assetValidationMap.put("SSI_COLL", beforeColl.get("SSI_COLL"));
			assetValidationMap.put("RSDI_COLL", beforeColl.get("RSDI_COLL"));
			assetValidationMap.put("VET_COLL", beforeColl.get("VET_COLL"));
			assetValidationMap.put("CONT_COLL", beforeColl.get("CONT_COLL"));
			assetValidationMap.put("TRBL_COLL", beforeColl.get("TRBL_COLL"));
			assetValidationMap.put("INDN_COLL", beforeColl.get("INDN_COLL"));
			assetValidationMap.put("OTHTYPE_COLL",
					beforeColl.get("OTHTYPE_COLL"));
			final Map noOneCheckedMap = (Map) beforeColl
					.get(AppConstants.NO_ONE_CHECKED_MAP);
			final NO_ONE_Collection noOneCollection = (NO_ONE_Collection) pageCollection
					.get("NO_ONE_Collection");
			boolean[] componentsDisplayed = new boolean[] { false };

			rmcResponseProfileManager.preparePageColl(rmcInPrflFromPageColl,
					rmcInPrflSessColl, questionsArray);

			pageCollection.put(FwConstants.PAGE_COMPONENT_LIST,
					beforeColl.get(FwConstants.PAGE_COMPONENT_LIST));

			componentsDisplayed = othIncomeBO.getComponentsDisplayed(
					beforeColl, componentsDisplayed);

			final int collectionSize = rmcInPrflFromPageColl.size();

			if (collectionSize > 0) {
				for (int i = 0; i < collectionSize; i++) {
					final RMC_IN_PRFL_Cargo pCargo = rmcInPrflFromPageColl
							.getCargo(i);
					final String[] pResponseValues = new String[1];
					final String rmrResponse = pCargo.getRmr_brd_incm_resp();
					if (rmrResponse != null) {
						pResponseValues[0] = rmrResponse;
					} else {
						pResponseValues[0] = AppConstants.NO;
					}

					rmcResponseProfileManager.persist(appNum,
							pCargo.getIndv_seq_num(), questionsArray,
							pResponseValues);
				}
			}

			for (int i = 0; i < size; i++) {
				rmcCustomCargo = respColl.getCargo(i);
				seqNum = rmcCustomCargo.getSeqNum();
				rmcCustomCargo.getCategoryType();
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
						rmcPrflPageCargo.setBnft_chl_sprt_resp(FwConstants.NO);
						rmcPrflPageCargo.setChld_sprt_pay_resp(FwConstants.NO);
						rmcPrflPageCargo.setRcv_ssi_sw(FwConstants.NO);
						rmcPrflPageCargo.setRcv_ss_resp(FwConstants.NO);
						rmcPrflPageCargo.setBnft_vet_resp(FwConstants.NO);
						rmcPrflPageCargo
						.setOther_incm_contrib_resp(FwConstants.NO);
						rmcPrflPageCargo.setOthr_incm_trbl_resp(FwConstants.NO);
						rmcPrflPageCargo.setOthr_incm_resp(FwConstants.NO);
						rmcPrflPageCargo.setOth_ind_gambl_pmnts(FwConstants.NO);
						rmcPrflPageCargo.setChild_support_court(FwConstants.NO);
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
					if (AppConstants.INC_CHIL_SUPP.equals(rmcCustomCargo
							.getCategoryType())) {
						rmcPrflPageCargo.setBnft_chl_sprt_resp(FwConstants.YES);
					} else if (AppConstants.INC_DIR_CHIL.equals(rmcCustomCargo
							.getCategoryType())) {
						rmcPrflPageCargo.setChld_sprt_pay_resp(FwConstants.YES);
					} else if (AppConstants.INC_SSI_SUPP.equals(rmcCustomCargo
							.getCategoryType())) {
						rmcPrflPageCargo.setRcv_ssi_sw(FwConstants.YES);
					} else if (AppConstants.INC_OTH_RSDI.equals(rmcCustomCargo
							.getCategoryType())) {
						rmcPrflPageCargo.setRcv_ss_resp(FwConstants.YES);
					} else if (AppConstants.INC_OTH_VET_BNFT
							.equals(rmcCustomCargo.getCategoryType())) {
						rmcPrflPageCargo.setBnft_vet_resp(FwConstants.YES);
					} else if (AppConstants.INC_OTH_CONT.equals(rmcCustomCargo
							.getCategoryType())) {
						rmcPrflPageCargo
						.setOther_incm_contrib_resp(FwConstants.YES);
					} else if (AppConstants.INC_OTH_TRBL_ASST
							.equals(rmcCustomCargo.getCategoryType())) {
						rmcPrflPageCargo
						.setOthr_incm_trbl_resp(FwConstants.YES);
					} else if (AppConstants.INC_OTH_INC.equals(rmcCustomCargo
							.getCategoryType())) {
						rmcPrflPageCargo.setOthr_incm_resp(FwConstants.YES);
					} else if (AppConstants.OTH_IND_GAMBL_PMNTS
							.equals(rmcCustomCargo.getCategoryType())) {
						rmcPrflPageCargo
						.setOth_ind_gambl_pmnts(FwConstants.YES);
					} else if (AppConstants.INC_OTH_DCSS.equals(rmcCustomCargo.getCategoryType())){
						rmcPrflPageCargo.setChild_support_court(FwConstants.YES);
					}

					addInd = true;
					respColl.remove(i);
					size--;
					i--;
				}
			}
			final String backToMyAccess = (String) request
					.get(AppConstants.BACK_TO_MY_ACCESS_BUTTON);
			if (backToMyAccess == null) {
				// add new selected and that one is disable then no need to do
				// any valiaction
				othIncomeBO
				.validateOtherIncomeEnd(respColl, assetValidationMap);
				othIncomeBO.validateOthIncomeSelection(respColl, addInd,
						assetValidationMap);
				othIncomeBO.validateQuestions(indvSelected, noOneCollection,
						noOneCheckedMap, componentsDisplayed);
			}
			// PCR 30561 - Added warning message when no selection is made
			boolean isWarningMessageShown = false;

			// Below variable contains list of all the warning message codes
			// displayed previously on this page delimited by '~'
			final String reqWarningMsgs = (String) request
					.get(FwConstants.WARNING_MSG_DETAILS);
			FwMessageList msgList = null;

			if (othIncomeBO.hasMessages()) {
				msgList = othIncomeBO.getMessageList();
				if (reqWarningMsgs != null
						&& reqWarningMsgs.trim().length() > 0) {
					// First check if no-selection warning message is in the
					// previously displayed list and then if it is also present
					// in the current list.
					if (reqWarningMsgs.indexOf("00804") > -1) {
						if (checkForWarningMesgs("00804", msgList)) {
							isWarningMessageShown = true;
						}
					}
					if (reqWarningMsgs.indexOf("00805") > -1) {
						if (checkForWarningMesgs("00805", msgList)) {
							isWarningMessageShown = true;
						}
					}
					if (reqWarningMsgs.indexOf("00806") > -1) {
						if (checkForWarningMesgs("00806", msgList)) {
							isWarningMessageShown = true;
						}
					}
					if (reqWarningMsgs.indexOf("00807") > -1) {
						if (checkForWarningMesgs("00807", msgList)) {
							isWarningMessageShown = true;
						}
					}
					if (reqWarningMsgs.indexOf("00808") > -1) {
						if (checkForWarningMesgs("00808", msgList)) {
							isWarningMessageShown = true;
						}
					}
					if (reqWarningMsgs.indexOf("00809") > -1) {
						if (checkForWarningMesgs("00809", msgList)) {
							isWarningMessageShown = true;
						}
					}
					if (reqWarningMsgs.indexOf("00810") > -1) {
						if (checkForWarningMesgs("00810", msgList)) {
							isWarningMessageShown = true;
						}
					}
					if (reqWarningMsgs.indexOf("00811") > -1) {
						if (checkForWarningMesgs("00811", msgList)) {
							isWarningMessageShown = true;
						}
					}
					if (reqWarningMsgs.indexOf("00812") > -1) {
						if (checkForWarningMesgs("00812", msgList)) {
							isWarningMessageShown = true;
						}
					}
				}
			}

			if (checkBackToMyAccessSelected(request) || msgList != null
					&& !isWarningMessageShown) {
				log(ILog.DEBUG,
						"RMCOtherIncomeEJBBean.storeOtherIncomeIndvSelection() - display validation error msg block: - start " + msgList); 
				if (backToMyAccess == null) {
					request.put(FwConstants.MESSAGE_LIST, msgList);
				}

				// here i am calling the translate profile to translate the
				// session values to the page collection
				if (rmcPrflPageColl != null) {
					rmcResponseProfileManager
					.translateProfileResponseAfterValidation(
							rmcPrflPageColl, rmcInPrflSessColl,
							responseArray);
				}

				if (respColl != null && !respColl.isEmpty()) {
					categorySelectionProfile = categorySelectionProfileManager
							.buildSelectionOthIncProfileAfterValidation(
									categorySelectionProfile, respColl);
				}
				final RMCDCSSIncomeSelectionListView rmcDCSSIncomeSelectionListView = (RMCDCSSIncomeSelectionListView) beforeColl
						.get("OTHER_INCOME_DCSS_SELECTION_LISTVIEW");
				final RMCDirectChildSupportIncomeSelectionListView rmcDirectChildSupportIncomeSelectionListView = (RMCDirectChildSupportIncomeSelectionListView) beforeColl
						.get("OTHER_INCOME_DIRCHLD_SELECTION_LISTVIEW");
				final RMCSSISupportIncomeSelectionListView rmcSSISupportIncomeSelectionListView = (RMCSSISupportIncomeSelectionListView) beforeColl
						.get("OTHER_INCOME_SSI_SELECTION_LISTVIEW");
				final RMCRSDISupportIncomeSelectionListView rmcRSDISupportIncomeSelectionListView = (RMCRSDISupportIncomeSelectionListView) beforeColl
						.get("OTHER_INCOME_RSDI_SELECTION_LISTVIEW");
				final RMCVetSupportIncomeSelectionListView rmcVetSupportIncomeSelectionListView = (RMCVetSupportIncomeSelectionListView) beforeColl
						.get("OTHER_INCOME_VET_SELECTION_LISTVIEW");
				final RMCContributionsIncomeSelectionListView rmcContributionsIncomeSelectionListView = (RMCContributionsIncomeSelectionListView) beforeColl
						.get("OTHER_INCOME_CONT_SELECTION_LISTVIEW");
				final RMCAmericanIndianIncomeSelectionListView rmcAmericanIndianIncomeSelectionListView = (RMCAmericanIndianIncomeSelectionListView) beforeColl
						.get("OTHER_INCOME_TRBL_SELECTION_LISTVIEW");
				final RMCAmericanIndianPaymentsListView rmcAmericanIndianPaymentsListView = (RMCAmericanIndianPaymentsListView) beforeColl
						.get("OTHER_INCOME_INDN_SELECTION_LISTVIEW");
				final RMCOtherIncomeTypeSelectionListView rmcOtherIncomeTypeSelectionListView = (RMCOtherIncomeTypeSelectionListView) beforeColl
						.get("OTHER_INCOME_OTHTYPE_SELECTION_LISTVIEW");
				final INDIVIDUAL_Custom_Collection indvColl = (INDIVIDUAL_Custom_Collection) beforeColl
						.get("INDV_COLL");
				final APP_IN_UEI_Collection dcssColl = (APP_IN_UEI_Collection) beforeColl
						.get("DCSS_COLL");
				final APP_IN_UEI_Collection dirchldColl = (APP_IN_UEI_Collection) beforeColl
						.get("DIRCHLD_COLL");
				final APP_IN_UEI_Collection ssiColl = (APP_IN_UEI_Collection) beforeColl
						.get("SSI_COLL");
				final APP_IN_UEI_Collection rsdiColl = (APP_IN_UEI_Collection) beforeColl
						.get("RSDI_COLL");
				final APP_IN_UEI_Collection vetColl = (APP_IN_UEI_Collection) beforeColl
						.get("VET_COLL");
				final APP_IN_UEI_Collection contColl = (APP_IN_UEI_Collection) beforeColl
						.get("CONT_COLL");
				final APP_IN_UEI_Collection trblColl = (APP_IN_UEI_Collection) beforeColl
						.get("TRBL_COLL");
				final APP_IN_UEI_Collection indnColl = (APP_IN_UEI_Collection) beforeColl
						.get("INDN_COLL");
				final APP_IN_UEI_Collection otherIncomeColl = (APP_IN_UEI_Collection) beforeColl
						.get("OTHTYPE_COLL");

				final List dcssDataList = new ArrayList(5);
				dcssDataList.add(dcssColl);
				dcssDataList.add(indvColl);
				dcssDataList.add(categorySelectionProfile);
				dcssDataList.add(rmcPrflPageColl);
				dcssDataList.add(driverStatus);
				rmcDCSSIncomeSelectionListView
				.setDisplayData(dcssDataList);
				
				final List dirChldDataList = new ArrayList(5);
				dirChldDataList.add(dirchldColl);
				dirChldDataList.add(indvColl);
				dirChldDataList.add(categorySelectionProfile);
				dirChldDataList.add(rmcPrflPageColl);
				dirChldDataList.add(driverStatus);
				rmcDirectChildSupportIncomeSelectionListView
				.setDisplayData(dirChldDataList);

				final List ssiDataList = new ArrayList(5);
				ssiDataList.add(ssiColl);
				ssiDataList.add(indvColl);
				ssiDataList.add(categorySelectionProfile);
				ssiDataList.add(rmcPrflPageColl);
				ssiDataList.add(driverStatus);
				rmcSSISupportIncomeSelectionListView
				.setDisplayData(ssiDataList);

				final List rsdiDataList = new ArrayList(5);
				rsdiDataList.add(rsdiColl);
				rsdiDataList.add(indvColl);
				rsdiDataList.add(categorySelectionProfile);
				rsdiDataList.add(rmcPrflPageColl);
				rsdiDataList.add(driverStatus);
				rmcRSDISupportIncomeSelectionListView
				.setDisplayData(rsdiDataList);

				final List vetDataList = new ArrayList(5);
				vetDataList.add(vetColl);
				vetDataList.add(indvColl);
				vetDataList.add(categorySelectionProfile);
				vetDataList.add(rmcPrflPageColl);
				vetDataList.add(driverStatus);
				rmcVetSupportIncomeSelectionListView
				.setDisplayData(vetDataList);

				log(ILog.INFO,
						"RMCOtherIncomeEJBBean BEFORE RMCContributionsIncomeSelectionListView");
				final List contDataList = new ArrayList(5);
				contDataList.add(contColl);
				contDataList.add(indvColl);
				contDataList.add(categorySelectionProfile);
				contDataList.add(rmcPrflPageColl);
				contDataList.add(driverStatus);
				rmcContributionsIncomeSelectionListView
				.setDisplayData(contDataList);
				log(ILog.INFO,
						"RMCOtherIncomeEJBBean After RMCContributionsIncomeSelectionListView");
				final List trblDataList = new ArrayList(5);
				trblDataList.add(trblColl);
				trblDataList.add(indvColl);
				trblDataList.add(categorySelectionProfile);
				trblDataList.add(rmcPrflPageColl);
				trblDataList.add(driverStatus);
				rmcAmericanIndianIncomeSelectionListView
				.setDisplayData(trblDataList);

				final List indnDatList = new ArrayList(5);
				indnDatList.add(indnColl);
				indnDatList.add(indvColl);
				indnDatList.add(categorySelectionProfile);
				indnDatList.add(rmcPrflPageColl);
				indnDatList.add(driverStatus);
				rmcAmericanIndianPaymentsListView.setDisplayData(indnDatList);

				final List othIncTypeDataList = new ArrayList(5);
				othIncTypeDataList.add(otherIncomeColl);
				othIncTypeDataList.add(indvColl);
				othIncTypeDataList.add(categorySelectionProfile);
				othIncTypeDataList.add(rmcPrflPageColl);
				othIncTypeDataList.add(driverStatus);
				rmcOtherIncomeTypeSelectionListView
				.setDisplayData(othIncTypeDataList);

				pageCollection = createAndLoadResponseMapsToPageCollection(
						rmcInPrflFromPageColl, pageCollection, peopleHandler, false,
						driverStatus);
				pageCollection.put("OTHER_INCOME_DCSS_SELECTION_LISTVIEW",
						rmcDCSSIncomeSelectionListView);
				pageCollection.put("OTHER_INCOME_DIRCHLD_SELECTION_LISTVIEW",
						rmcDirectChildSupportIncomeSelectionListView);
				pageCollection.put("OTHER_INCOME_SSI_SELECTION_LISTVIEW",
						rmcSSISupportIncomeSelectionListView);
				pageCollection.put("OTHER_INCOME_RSDI_SELECTION_LISTVIEW",
						rmcRSDISupportIncomeSelectionListView);
				pageCollection.put("OTHER_INCOME_VET_SELECTION_LISTVIEW",
						rmcVetSupportIncomeSelectionListView);
				pageCollection.put("OTHER_INCOME_CONT_SELECTION_LISTVIEW",
						rmcContributionsIncomeSelectionListView);
				pageCollection.put("OTHER_INCOME_TRBL_SELECTION_LISTVIEW",
						rmcAmericanIndianIncomeSelectionListView);
				pageCollection.put("OTHER_INCOME_INDN_SELECTION_LISTVIEW",
						rmcAmericanIndianPaymentsListView);
				pageCollection.put("OTHER_INCOME_OTHTYPE_SELECTION_LISTVIEW",
						rmcOtherIncomeTypeSelectionListView);
				pageCollection.put("INDV_COLL", indvColl);
				pageCollection.put("DCSS_COLL", dcssColl);
				pageCollection.put("DIRCHLD_COLL", dirchldColl);
				pageCollection.put("SSI_COLL", ssiColl);
				pageCollection.put("RSDI_COLL", rsdiColl);
				pageCollection.put("VET_COLL", vetColl);
				pageCollection.put("CONT_COLL", contColl);
				pageCollection.put("TRBL_COLL", trblColl);
				pageCollection.put("INDN_COLL", indnColl);
				pageCollection.put("OTHTYPE_COLL", otherIncomeColl);
				pageCollection.put(AppConstants.NO_ONE_CHECKED_MAP, noOneCheckedMap);
				
				log(ILog.DEBUG, "RMCOtherIncomeEJBBean.storeOtherIncomeIndvSelection() - display validation error msg block: - end "); 
				return;
			}
			
			log(ILog.DEBUG, "RMCOtherIncomeEJBBean.storeOtherIncomeIndvSelection() - room and board - start "); 
			for (int i = 0; i < rmcInPrflSessColl.size(); i++) {
				final RMC_IN_PRFL_Cargo sessionCargo = rmcInPrflSessColl.getCargo(i);
				int sizeColl = rmcInPrflFromPageColl.size();
				for (int j = 0; j <sizeColl ; j++) {
					final RMC_IN_PRFL_Cargo pageCargo = rmcInPrflFromPageColl
							.getCargo(j);
					if (pageCargo.getIndv_seq_num().equals(
							sessionCargo.getIndv_seq_num())) {
						if (pageCargo.getRmr_brd_incm_resp() != null) {
							sessionCargo.setRmr_brd_incm_resp(pageCargo
									.getRmr_brd_incm_resp());
						}else{
							sessionCargo.setRmr_brd_incm_resp("N");	
						}
					}
				}

			}
			
			boolean detailPageRequired = false;
			boolean isOtherInc = false;
			if (rmcInPrflSessColl != null) {
				// populating missing app in profile collection into page
				// collection for enter key press
				// this method copys completed and visit again responses from
				// session to page collection and populate empty cargos				
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

				final int[] othIncDetailDirtyIndicator = { IRMCResponseProfileManager.NOT_DIRTY };

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
							if (rmcInPrflSessCargo.getBnft_chl_sprt_resp() == null) {
								rmcInPrflSessCargo
								.setBnft_chl_sprt_resp(AppConstants.NO);
							}
							// Checking for any changes in the page since load
							if (applicationManager.determineDirtyStatus(
									rmcInPrflPageCargo.getChild_support_court(),
									rmcInPrflSessCargo.getChild_support_court(),
									othIncDetailDirtyIndicator, driverStatus)) {
								if (!dirtyIndicatorArray[0]) {
									dirtyIndicatorArray[0] = true;
								}
								dirtyIndicatorArray[Integer
								                    .parseInt(indivSeqNum)] = true;
							}
							// translating page coll app indiv profile values to
							// session app indv profile values
							rmcResponseProfileManager
							.translateProfileResponses(
									rmcInPrflPageCargo
									.getChild_support_court(),
									rmcInPrflSessCargo
									.getChild_support_court(),
									driverStatus,
									IRMCResponseProfileManager.CHILD_SUPPORT_COURT,
									rmcInPrflSessCargo);
							translatedProfileArray[0] = rmcInPrflSessCargo
									.getChild_support_court();
							status = (null != rmcInPrflSessCargo
									.getChild_support_court()) ? (rmcInPrflSessCargo
									.getChild_support_court().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
							if (status == IRMCResponseProfileManager.STATUS_ADD_NEW
									|| status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
									|| status == IRMCResponseProfileManager.STATUS_REQUIRED) {
								detailPageRequired = true;
							}
							if (applicationManager.determineDirtyStatus(
									rmcInPrflPageCargo.getChld_sprt_pay_resp(),
									rmcInPrflSessCargo.getChld_sprt_pay_resp(),
									othIncDetailDirtyIndicator, driverStatus)) {
								if (!dirtyIndicatorArray[0]) {
									dirtyIndicatorArray[0] = true;
								}
								dirtyIndicatorArray[Integer
								                    .parseInt(indivSeqNum)] = true;
							}
							// translating page coll app indiv profile values to
							// session app indv profile values
							rmcResponseProfileManager
							.translateProfileResponses(
									rmcInPrflPageCargo
									.getChld_sprt_pay_resp(),
									rmcInPrflSessCargo
									.getChld_sprt_pay_resp(),
									driverStatus,
									IRMCResponseProfileManager.CHILD_SUPPORT_PAYMENT,
									rmcInPrflSessCargo);
							translatedProfileArray[1] = rmcInPrflSessCargo
									.getChld_sprt_pay_resp();
							status = (null != rmcInPrflSessCargo
									.getChld_sprt_pay_resp()) ? (rmcInPrflSessCargo
									.getChld_sprt_pay_resp().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
							if (status == IRMCResponseProfileManager.STATUS_ADD_NEW
									|| status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
									|| status == IRMCResponseProfileManager.STATUS_REQUIRED) {
								detailPageRequired = true;
							}
							if (applicationManager.determineDirtyStatus(
									rmcInPrflPageCargo.getRcv_ssi_sw(),
									rmcInPrflSessCargo.getRcv_ssi_sw(),
									othIncDetailDirtyIndicator, driverStatus)) {
								if (!dirtyIndicatorArray[0]) {
									dirtyIndicatorArray[0] = true;
								}
								dirtyIndicatorArray[Integer
								                    .parseInt(indivSeqNum)] = true;
							}
							// translating page coll app indiv profile values to
							// session app indv profile values
							rmcResponseProfileManager
							.translateProfileResponses(
									rmcInPrflPageCargo.getRcv_ssi_sw(),
									rmcInPrflSessCargo.getRcv_ssi_sw(),
									driverStatus,
									IRMCResponseProfileManager.RECEIVE_SSI,
									rmcInPrflSessCargo);
							translatedProfileArray[2] = rmcInPrflSessCargo
									.getRcv_ssi_sw();
							status = (null != rmcInPrflSessCargo
									.getRcv_ssi_sw()) ? (rmcInPrflSessCargo
									.getRcv_ssi_sw().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
							if (status == IRMCResponseProfileManager.STATUS_ADD_NEW
									|| status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
									|| status == IRMCResponseProfileManager.STATUS_REQUIRED) {
								detailPageRequired = true;
							}
							if (applicationManager.determineDirtyStatus(
									rmcInPrflPageCargo.getRcv_ss_resp(),
									rmcInPrflSessCargo.getRcv_ss_resp(),
									othIncDetailDirtyIndicator, driverStatus)) {
								if (!dirtyIndicatorArray[0]) {
									dirtyIndicatorArray[0] = true;
								}
								dirtyIndicatorArray[Integer
								                    .parseInt(indivSeqNum)] = true;
							}
							// translating page coll app indiv profile values to
							// session app indv profile values
							rmcResponseProfileManager
							.translateProfileResponses(
									rmcInPrflPageCargo.getRcv_ss_resp(),
									rmcInPrflSessCargo.getRcv_ss_resp(),
									driverStatus,
									IRMCResponseProfileManager.RECEIVE_SOCIAL_SECURITY,
									rmcInPrflSessCargo);
							translatedProfileArray[3] = rmcInPrflSessCargo
									.getRcv_ss_resp();
							status = (null != rmcInPrflSessCargo
									.getRcv_ss_resp()) ? (rmcInPrflSessCargo
									.getRcv_ss_resp().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
							if (status == IRMCResponseProfileManager.STATUS_ADD_NEW
									|| status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
									|| status == IRMCResponseProfileManager.STATUS_REQUIRED) {
								detailPageRequired = true;
							}
							if (applicationManager.determineDirtyStatus(
									rmcInPrflPageCargo.getBnft_vet_resp(),
									rmcInPrflSessCargo.getBnft_vet_resp(),
									othIncDetailDirtyIndicator, driverStatus)) {
								if (!dirtyIndicatorArray[0]) {
									dirtyIndicatorArray[0] = true;
								}
								dirtyIndicatorArray[Integer
								                    .parseInt(indivSeqNum)] = true;
							}
							// translating page coll app indiv profile values to
							// session app indv profile values
							rmcResponseProfileManager
							.translateProfileResponses(
									rmcInPrflPageCargo
									.getBnft_vet_resp(),
									rmcInPrflSessCargo
									.getBnft_vet_resp(),
									driverStatus,
									IRMCResponseProfileManager.BENEFIT_VETERAN,
									rmcInPrflSessCargo);
							translatedProfileArray[4] = rmcInPrflSessCargo
									.getBnft_vet_resp();
							status = (null != rmcInPrflSessCargo
									.getBnft_vet_resp()) ? (rmcInPrflSessCargo
									.getBnft_vet_resp().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
							if (status == IRMCResponseProfileManager.STATUS_ADD_NEW
									|| status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
									|| status == IRMCResponseProfileManager.STATUS_REQUIRED) {
								detailPageRequired = true;
							}
							if (applicationManager.determineDirtyStatus(
									rmcInPrflPageCargo
									.getOther_incm_contrib_resp(),
									rmcInPrflSessCargo
									.getOther_incm_contrib_resp(),
									othIncDetailDirtyIndicator, driverStatus)) {
								if (!dirtyIndicatorArray[0]) {
									dirtyIndicatorArray[0] = true;
								}
								dirtyIndicatorArray[Integer
								                    .parseInt(indivSeqNum)] = true;
							}
							// translating page coll app indiv profile values to
							// session app indv profile values
							rmcResponseProfileManager
							.translateProfileResponses(
									rmcInPrflPageCargo
									.getOther_incm_contrib_resp(),
									rmcInPrflSessCargo
									.getOther_incm_contrib_resp(),
									driverStatus,
									IRMCResponseProfileManager.OTHR_INCM_CONTRIB_RESP,
									rmcInPrflSessCargo);
							translatedProfileArray[5] = rmcInPrflSessCargo
									.getOther_incm_contrib_resp();
							status = (null != rmcInPrflSessCargo
									.getOther_incm_contrib_resp()) ? (rmcInPrflSessCargo
									.getOther_incm_contrib_resp().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
							if (status == IRMCResponseProfileManager.STATUS_ADD_NEW
									|| status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
									|| status == IRMCResponseProfileManager.STATUS_REQUIRED) {
								detailPageRequired = true;
							}
							if (applicationManager
									.determineDirtyStatus(rmcInPrflPageCargo
											.getOthr_incm_trbl_resp(),
											rmcInPrflSessCargo
											.getOthr_incm_trbl_resp(),
											othIncDetailDirtyIndicator,
											driverStatus)) {
								if (!dirtyIndicatorArray[0]) {
									dirtyIndicatorArray[0] = true;
								}
								dirtyIndicatorArray[Integer
								                    .parseInt(indivSeqNum)] = true;
							}
							// translating page coll app indiv profile values to
							// session app indv profile values
							rmcResponseProfileManager
							.translateProfileResponses(
									rmcInPrflPageCargo
									.getOthr_incm_trbl_resp(),
									rmcInPrflSessCargo
									.getOthr_incm_trbl_resp(),
									driverStatus,
									IRMCResponseProfileManager.OTHR_INCM_TRBL_RESP,
									rmcInPrflSessCargo);
							translatedProfileArray[6] = rmcInPrflSessCargo
									.getOthr_incm_trbl_resp();
							status = (null != rmcInPrflSessCargo
									.getOthr_incm_trbl_resp()) ? (rmcInPrflSessCargo
									.getOthr_incm_trbl_resp().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
							if (status == IRMCResponseProfileManager.STATUS_ADD_NEW
									|| status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
									|| status == IRMCResponseProfileManager.STATUS_REQUIRED) {
								detailPageRequired = true;
							}
							if (applicationManager
									.determineDirtyStatus(rmcInPrflPageCargo
											.getOth_ind_gambl_pmnts(),
											rmcInPrflSessCargo
											.getOth_ind_gambl_pmnts(),
											othIncDetailDirtyIndicator,
											driverStatus)) {
								if (!dirtyIndicatorArray[0]) {
									dirtyIndicatorArray[0] = true;
								}
								dirtyIndicatorArray[Integer
								                    .parseInt(indivSeqNum)] = true;
							}
							// translating page coll app indiv profile values to
							// session app indv profile values
							rmcResponseProfileManager
							.translateProfileResponses(
									rmcInPrflPageCargo
									.getOth_ind_gambl_pmnts(),
									rmcInPrflSessCargo
									.getOth_ind_gambl_pmnts(),
									driverStatus,
									IRMCResponseProfileManager.OTH_IND_GAMBL_PMNTS,
									rmcInPrflSessCargo);
							translatedProfileArray[7] = rmcInPrflSessCargo
									.getOth_ind_gambl_pmnts();
							status = (null != rmcInPrflSessCargo
									.getOth_ind_gambl_pmnts()) ? (rmcInPrflSessCargo
									.getOth_ind_gambl_pmnts().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
							if (status == IRMCResponseProfileManager.STATUS_ADD_NEW
									|| status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
									|| status == IRMCResponseProfileManager.STATUS_REQUIRED) {
								detailPageRequired = true;
							}
							if (applicationManager.determineDirtyStatus(
									rmcInPrflPageCargo.getRmr_brd_incm_resp(),
									rmcInPrflSessCargo.getRmr_brd_incm_resp(),
									othIncDetailDirtyIndicator, driverStatus)) {
								if (!dirtyIndicatorArray[0]) {
									dirtyIndicatorArray[0] = true;
								}
								dirtyIndicatorArray[Integer
								                    .parseInt(indivSeqNum)] = true;
							}
							
							// For Current/Recent OtherInc response
							if (applicationManager.determineDirtyStatus(
									rmcInPrflPageCargo.getOthr_incm_resp(),
									rmcInPrflSessCargo.getOthr_incm_resp(),
									othIncDetailDirtyIndicator, driverStatus)) {
								if (!dirtyIndicatorArray[0]) {
									dirtyIndicatorArray[0] = true;
								}
								dirtyIndicatorArray[Integer
								                    .parseInt(indivSeqNum)] = true;
							}
							// translating page coll app indiv profile values to
							// session app indv profile values
							rmcResponseProfileManager
							.translateProfileResponses(
									rmcInPrflPageCargo
									.getOthr_incm_resp(),
									rmcInPrflSessCargo
									.getOthr_incm_resp(),
									driverStatus,
									IRMCResponseProfileManager.OTHER_INCOME,
									rmcInPrflSessCargo);
							translatedProfileArray[8] = rmcInPrflSessCargo
									.getOthr_incm_resp();
							status = (null != rmcInPrflSessCargo
									.getOthr_incm_resp()) ? (rmcInPrflSessCargo
									.getOthr_incm_resp().charAt(0))
									: (IRMCResponseProfileManager.STATUS_NOT_REQUIRED);
							if (status == IRMCResponseProfileManager.STATUS_ADD_NEW
									|| status == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
									|| status == IRMCResponseProfileManager.STATUS_REQUIRED) {
								detailPageRequired = true;
								isOtherInc = true;
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

						if (dirtyIndicatorArray[Integer.parseInt(indvSeqNumber)]) {
							// rmcinprfl checkboxes **
							rmcResponseProfileManager.persist(appNum,
									indvSeqNumber, responseArray,
									(String[]) indvResponseMap
									.get(indvSeqNumber));
						}
					}
				}
			}

			// build category selection profile

			
			if (categorySelectionProfile == null
					|| categorySelectionProfile.isEmpty()) {
				// rmcchgselprfl radiobuttons
				// constructs the SortedSet which will represent the
				// selectionProfile for a given collection of cargos
				categorySelectionProfile = categorySelectionProfileManager
						.buildSelectionProfile(respColl, appNum,
								AppConstants.RMC_CAT_OT_INC_PRFL);					
			} else {
				// updates existing(given) SelectionProfile with the provided
				// new Collection
				categorySelectionProfileManager.rebuildSelectionProfile(
						categorySelectionProfile, respColl, appNum,
						AppConstants.RMC_CAT_OT_INC_PRFL);
			}
			
			log(ILog.DEBUG, "RMCOtherIncomeEJBBean.storeOtherIncomeIndvSelection() - respColl " + respColl);

			// Make category selection (ARCAT) page complete
			driverManager.makeComplete(FwConstants.RMC_DRIVER, currentPageID,
					driverArray, appNum);
			final Map catTypes = createCatTypes();

			String uiDetailPageStat = null;
			if (detailPageRequired
					|| othIncomeBO.checkEmploymentPageRequired(
							categorySelectionProfile, catTypes)) {
				if (detailPageRequired
						|| !categorySelectionProfileManager
						.areAllSequencesComplete(
								categorySelectionProfile, catTypes)) {
					if (!isOtherInc) {
						driverManager.makeRequired(FwConstants.RMC_DRIVER,
								"ARUID", driverArray, appNum);
					}

					if (addInd
							&& othIncomeBO.checkUiTypesPageRequired(
									rmcInPrflSessColl, rmcPrflPageColl)) {
						driverManager.makeRequired(FwConstants.RMC_DRIVER,
								"ARUIT", driverArray, appNum);
					} else {
						driverManager.makeAbsoluteNotRequired(
								FwConstants.RMC_DRIVER, "ARUIT", driverArray,
								appNum);
					}
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARUIS",
							driverArray, appNum);
				}

			} else {
				// PCR 30729 - When the details page is complete it should not
				// be marked AbsoluteNotRequd.
				// Otherwise, after going back to summary from selection page,
				// BACK will display selection instead of details page.
				uiDetailPageStat = driverManager.getStatus(
						FwConstants.RMC_DRIVER, "ARUID", driverArray);
				driverManager.getStatus(FwConstants.RMC_DRIVER, "ARUIT",
						driverArray);
				if (!IDriver.DRIVER_STATUS_COMPLETE.equals(uiDetailPageStat)
						&& !IDriver.DRIVER_STATUS_VISIT_AGAIN
						.equals(uiDetailPageStat)
						&& !IDriver.DRIVER_STATUS_REQUIRED
						.equals(uiDetailPageStat)) {
					// AbsoluteNotRequired will set the page status to 'Not
					// required'. In such case if
					// there were any otherIncome that were edited or added
					// (currently in complete status)
					// cannot be revisited when clicking back.
					// Use of NotRequired will mark a visitAgain to Complete,
					// that way any edited or added will be displayed when Back
					// is clicked.
					driverManager.makeNotRequired(FwConstants.RMC_DRIVER,
							"ARUID", driverArray, appNum);
				}
				if (!addInd
						|| !othIncomeBO.checkUiTypesPageRequired(
								rmcInPrflSessColl, rmcPrflPageColl)) {
					driverManager.makeAbsoluteNotRequired(
							FwConstants.RMC_DRIVER, "ARUIT", driverArray,
							appNum);
				}
				driverManager.makeNotRequired(FwConstants.RMC_DRIVER, "ARUID",
						driverArray, appNum);

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
			we.setCallingMethodID("storeOtherIncomeIndvSelection");
			we.setFwException(fe);
			throw rmcOtherIncomeEJBBean.rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"storeOtherIncomeIndvSelection", e);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.storeOtherIncomeIndvSelection() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

	/**
	 * Creates the cat types.
	 *
	 * @return the map
	 */
	private Map createCatTypes() {
		final Map catTypes = new HashMap();
		catTypes.put("SS", "SS");
		catTypes.put("SI", "SI");
		catTypes.put("VE", "VE");
		catTypes.put("DS", "DS");
		catTypes.put("DC", "DC");
		catTypes.put("CT", "CT");
		catTypes.put("AA", "AA");
		catTypes.put("OI", "OI");
		catTypes.put("AS", "AS");
		catTypes.put("AP", "AP");
		catTypes.put("AO", "AO");
		catTypes.put("AL", "AL");
		catTypes.put("CG", "CG");
		catTypes.put("DB", "DB");
		catTypes.put("DM", "DM");
		catTypes.put("DR", "DR");
		catTypes.put("ED", "ED");
		catTypes.put("EA", "EA");
		catTypes.put("FA", "FA");
		catTypes.put("FP", "FP");
		catTypes.put("GA", "GA");
		catTypes.put("IP", "IP");
		catTypes.put("ID", "ID");
		catTypes.put("LW", "LW");
		catTypes.put("LS", "LS");
		catTypes.put("MI", "MI");
		catTypes.put("MF", "MF");
		catTypes.put("NR", "NR");
		catTypes.put("PF", "PF");
		catTypes.put("PB", "PB");
		catTypes.put("PN", "PN");
		catTypes.put("RT", "RT");
		catTypes.put("RC", "RC");
		catTypes.put("RS", "RS");
		catTypes.put("RI", "RI");
		catTypes.put("TN", "TN");
		catTypes.put("UC", "UC");
		catTypes.put("WS", "WS");
		catTypes.put("WO", "WO");
		catTypes.put("OO", "OO");
		catTypes.put("IGP", "IGP");
		catTypes.put("IFS", "IFS");
		catTypes.put("IGPI", "IGPI");
		catTypes.put("INH", "INH");
		catTypes.put("IBLI", "IBLI");
		catTypes.put("LR", "LR");
		catTypes.put("LRI", "LRI");
		catTypes.put("MII", "MII");
		catTypes.put("MGRA", "MGRA");
		catTypes.put("MGBP", "MGBP");
		catTypes.put("OSPA", "OSPA");
		catTypes.put("RDCH", "RDCH");
		catTypes.put("RSE", "RSE");
		catTypes.put("SCP", "SCP");
		catTypes.put("SEV", "SEV");
		catTypes.put("SBT", "SBT");
		catTypes.put("TRA", "TRA");
		catTypes.put("URAR", "URAR");
		catTypes.put("UF", "UF");
		catTypes.put("V1", "V1");
		catTypes.put("V3", "V3");
		catTypes.put("VLP", "VLP");
		catTypes.put("VLPT", "VLPT");
		catTypes.put("WIAT", "WIAT");
		catTypes.put("IUI", "IUI");
		catTypes.put("3TMA", "3TMA");
		catTypes.put("3TGA", "3TGA");
		catTypes.put("D1", "D1");
		catTypes.put("CNP", "CNP");
		catTypes.put("BLB", "BLB");
		catTypes.put("CSCO", "CSCO");
		catTypes.put("CSGP", "CSGP");
		catTypes.put("CSEB", "CSEB");
		catTypes.put("DCP", "DCP");
		catTypes.put("DIN", "DIN");
		catTypes.put("EUI", "EUI");
		catTypes.put("FDE", "FDE");
		catTypes.put("FNDE", "FNDE");
		catTypes.put("HAS", "HAS");
		catTypes.put("IKS", "IKS");
		catTypes.put("FGPP", "FGPP");
		catTypes.put("DIS", "DIS");
		catTypes.put("DIV", "DIV");
		catTypes.put("DFS", "DFS");
		catTypes.put("DBSF", "DBSF");
		catTypes.put("SSR", "SSR");
		catTypes.put("V2", "V2");
		return catTypes;
	}

	/**
	 * Comment here.
	 *
	 * @param txnBean the txn bean
	 \* @throws javax.ejb.EJBException the EJB exception
	 */

	public void loadOtherIncomeSubTypeSelection(final FwTransaction txnBean)
			throws javax.ejb.EJBException {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.loadOtherIncomeSubTypeSelection() - START");
		log(ILog.INFO,
				"RMCOtherIncomeEJBBean::loadOtherIncomeSubTypeSelection:Start");
		final Map session = txnBean.getSession();
		final Map request = txnBean.getRequest();
		final Map pageCollection = txnBean.getPageCollection();
		try {
			final String currentPageID = (String) request
					.get(FwConstants.CURRENT_PAGE_ID);
			final PeopleHandler peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);
			INDIVIDUAL_Custom_Collection indvCustColl = peopleHandler
					.getInHomeIndividuals();
			indvCustColl = peopleHandler.sortIndividuals(indvCustColl);

			RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			final NO_ONE_Collection noOneOtherIncColl = new NO_ONE_Collection();

			int size = 0;
			if (rmcInPrflColl != null) {
				size = rmcInPrflColl.size();
			}
			String indivSeqNum = null;
			String firstName = null;
			String otherIncomeResp = null;

			final Map firstNameList = new HashMap();
			RMC_IN_PRFL_Cargo rmcInPrflCargo = null;
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
			driverManager.getAFBStatus(FwConstants.RMC_DRIVER,
					(String) request.get(FwConstants.CURRENT_PAGE_ID),
					driverArray);

			session.get(FwConstants.DETAIL_KEY_BEAN);

			final RMC_IN_PRFL_Collection rmcInPrflCollNew = new RMC_IN_PRFL_Collection();
			for (int i = 0; i < size; i++) {
				// get cargo in the collection
				rmcInPrflCargo = rmcInPrflColl.getCargo(i);
				indivSeqNum = rmcInPrflCargo.getIndv_seq_num();
				firstName = peopleHandler.getFirstName(indivSeqNum);
				// EDSP RMB Testing

				firstNameList.put(indivSeqNum, firstName);
				otherIncomeResp = rmcInPrflCargo.getOthr_incm_resp();
				if (otherIncomeResp != null
						&& ("R".equals(otherIncomeResp) || "C"
								.equals(otherIncomeResp))) {
					rmcInPrflCollNew.addCargo(rmcInPrflCargo);
				}

			}
			rmcInPrflColl = rmcInPrflCollNew;
			pageCollection.put("RMC_IN_PRFL_TEMP_Collection", rmcInPrflColl);
			pageCollection.put("FIRST_NAME_LIST", firstNameList);
			pageCollection.put("NO_ONE_Collection", noOneOtherIncColl);
			// Run ComponentManager to get list of components
			componentManager.getComponents(currentPageID, txnBean);
			// Add the page collection to before collection
			session.put(FwConstants.BEFORE_COLLECTION, pageCollection);
			txnBean.setPageCollection(pageCollection);
			txnBean.setSession(session);
			log(ILog.INFO,
					"RMCOtherIncomeEJBBean::getOtherIncomeSubTypeSelection:End");

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("loadOtherIncomeSubTypeSelection");
			we.setFwException(fe);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"loadOtherIncomeSubTypeSelection", e);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.loadOtherIncomeSubTypeSelection() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

	/**
	 * Comment here.
	 *
	 * @param txnBean the txn bean
	 \* @throws javax.ejb.EJBException the EJB exception
	 */
	public void storeOtherIncomeSubTypeSelection(final FwTransaction txnBean)
			throws javax.ejb.EJBException {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.storeOtherIncomeSubTypeSelection() - START");
		try {

			log(ILog.INFO,
					"RMCOtherIncomeEJBBean::storeOtherIncomeSubTypeSelection:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final OtherIncomeBO validateNoOneBO = new OtherIncomeBO();
			final PeopleHandler peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);
			final INDIVIDUAL_Custom_Collection indvCustColl = peopleHandler
					.getInHomeIndividuals();
			final OtherIncomeBO othIncomeBO = new OtherIncomeBO();
			SortedSet categorySelectionProfile = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			final String appType = (String) session
					.get(FwConstants.ACCESS_APPLICATION_TYPE);
			// Initialize short field names
			final short[] fieldName = new short[] {
					IRMCResponseProfileManager.UEI_ADOPTION_ASSIST,
					IRMCResponseProfileManager.UEI_ADOPTION_PYMT,
					IRMCResponseProfileManager.UEI_AGENT_ORNG_PYMT,
					IRMCResponseProfileManager.UEI_ALIMONY,
					IRMCResponseProfileManager.UEI_CAPITAL_GAINS,
					IRMCResponseProfileManager.UEI_DEATH_BNFT,
					IRMCResponseProfileManager.UEI_DABL_INCM,
					IRMCResponseProfileManager.UEI_DR_RELIEF,
					IRMCResponseProfileManager.UEI_EDU_ASSIST,
					IRMCResponseProfileManager.UEI_ENERGY_ASSIST,
					IRMCResponseProfileManager.UEI_FRM_ALOT,
					IRMCResponseProfileManager.UEI_FOSTER_CARE_PYMT,
					IRMCResponseProfileManager.UEI_GEN_ASSIST,
					IRMCResponseProfileManager.UEI_INT_DIV_PYMT,
					IRMCResponseProfileManager.UEI_IRA_DIST,
					IRMCResponseProfileManager.UEI_LOTTERY_WIN,
					IRMCResponseProfileManager.UEI_LUMP_SUM,
					IRMCResponseProfileManager.UEI_MIL_ALOT,
					IRMCResponseProfileManager.UEI_MON_FRO_OTH,
					IRMCResponseProfileManager.UEI_NET_RENT_ROYALTY,
					IRMCResponseProfileManager.UEI_OTH,
					IRMCResponseProfileManager.UEI_ANNY_PYMT,
					IRMCResponseProfileManager.UEI_PYMT_BO,
					IRMCResponseProfileManager.UEI_PENSION,
					IRMCResponseProfileManager.UEI_RR_RETIRE,
					IRMCResponseProfileManager.UEI_REFUGEE_CASH,
					IRMCResponseProfileManager.UEI_REL_CARE,
					IRMCResponseProfileManager.UEI_RENTAL_INCM,
					IRMCResponseProfileManager.UEI_TANF_PYMT,
					IRMCResponseProfileManager.UEI_UNEMPL,
					IRMCResponseProfileManager.UEI_WORKER_STUDY,
					IRMCResponseProfileManager.UEI_WORKER_COMP,
					IRMCResponseProfileManager.INCOME_FROM_RESOURCE,
					IRMCResponseProfileManager.INDIAN_GAMBLING_PAYMENTS,
					IRMCResponseProfileManager.INHERITANCE_INCOME,
					IRMCResponseProfileManager.INSUANCE_BENEFITS,
					IRMCResponseProfileManager.LOAN_RECEIVED,
					IRMCResponseProfileManager.LOAN_REPAYMENT_INCOME,
					IRMCResponseProfileManager.MANAGED_INCOME,
					IRMCResponseProfileManager.MATCH_GRANT,
					IRMCResponseProfileManager.MONTGOMERY_GI_BILL,
					IRMCResponseProfileManager.OUT_OF_STATE_PUBLIC,
					IRMCResponseProfileManager.REFUNDS_FROM_DCH,
					IRMCResponseProfileManager.RESTITUTIONS_SETTLEMENTS,
					IRMCResponseProfileManager.SENIOR_COMPANION,
					IRMCResponseProfileManager.SEVERANCE_PAY,
					IRMCResponseProfileManager.STRIKE_BENEFITS,
					IRMCResponseProfileManager.TRADE_READJUSTMENT,
					IRMCResponseProfileManager.UNIFORM_RELOCATION,
					IRMCResponseProfileManager.UNION_FUNDS,
					IRMCResponseProfileManager.VENDOR_EXCLUDED,
					IRMCResponseProfileManager.VICTIM_RESTITUTION,
					IRMCResponseProfileManager.VOLUNTEER_PAYMENT,
					IRMCResponseProfileManager.VOLUNTEER_PAYMENT_TITLEI,
					IRMCResponseProfileManager.WIA_TRAINING_AND_ALLOWANCE,
					IRMCResponseProfileManager.INCLUDED_UNEARNED_INCOME,
					IRMCResponseProfileManager.TANF_MAX_AU_ALLOTMENT,
					IRMCResponseProfileManager.TANF_MAX_GRG_ALLOTMENT,
					IRMCResponseProfileManager.CHARITABLE_DONATION,
					IRMCResponseProfileManager.CHILD_NUTRITION_PAYMENTS,
					IRMCResponseProfileManager.BLACK_LUNG_BENEFITS,
					IRMCResponseProfileManager.CHILD_SUPPORT_COURT,
					IRMCResponseProfileManager.CHILD_SUPPORT_GAP_PAYMENT,
					IRMCResponseProfileManager.CIVIL_SERVICE,
					IRMCResponseProfileManager.DEFERRED_COMPENSATION_PLANS,
					IRMCResponseProfileManager.DISABILITY_INSURANCE,
					IRMCResponseProfileManager.EXCLUDED_UNEARNED_INCOME,
					IRMCResponseProfileManager.FEMA_PAYMENT_DISASTER,
					IRMCResponseProfileManager.FEMA_PAYMENT_NON_DISASTER,
					IRMCResponseProfileManager.HEALTH_SAVINGS_ACCOUNT,
					IRMCResponseProfileManager.IN_KIND_SUPPORT,
					IRMCResponseProfileManager.FOSTER_GRANDPARENT_PROGRAM,
					IRMCResponseProfileManager.DISASTER_UNEMPLOYMENT,
					IRMCResponseProfileManager.DIVIDENDS,
					IRMCResponseProfileManager.CHARITABLE_DONATION_FEDERAL,
					IRMCResponseProfileManager.DEATH_BENEFIT_STATE_FEDERAL,
					IRMCResponseProfileManager.SOCIAL_SECURITY_SURVIVOR,
					IRMCResponseProfileManager.VENDOR_PAYMENTS };
			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);

			// Get appNumber
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);

			// Get pageStatus from DriverArray
			final int pageStatus = driverManager.getAFBStatus(
					FwConstants.RMC_DRIVER,
					(String) request.get(FwConstants.CURRENT_PAGE_ID),
					driverArray);

			// Persist Array List Collection and cargo
			final List persistArray = new ArrayList();
			final RMC_IN_PRFL_Collection persistColl = new RMC_IN_PRFL_Collection();

			// Get the session Collection and Cargo for AIP
			final RMC_IN_PRFL_Collection rmcInPrflCollSession = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);

			// Get the PAGE Collection
			final RMC_IN_PRFL_Collection pageColl = (RMC_IN_PRFL_Collection) pageCollection
					.get("RMC_IN_PRFL_Collection");

			// Create a copy of pagecollection
			RMC_IN_PRFL_Collection rmcInPrflCollRequest = new RMC_IN_PRFL_Collection();

			// Get ARUIT Other Income Type Before Collection
			final Map beforeMap = (Map) session
					.get(FwConstants.BEFORE_COLLECTION);

			final Map beforeFirstNamesList = (Map) beforeMap
					.get("FIRST_NAME_LIST");
			final NO_ONE_Collection noOneBeforeColl = (NO_ONE_Collection) beforeMap
					.get("NO_ONE_Collection");
			final RMC_IN_PRFL_Collection rmcInPrflBeforeColl = (RMC_IN_PRFL_Collection) beforeMap
					.get("RMC_IN_PRFL_TEMP_Collection");

			// Populate responses from BeforeCollection to Page Collection
			final IRMCResponseProfileManager rmcResponseProfileManager = RMCResponseProfileManager
					.getInstance();
			// this method copys completed and visit again responses from
			// session to page collection and populate empty cargos
			rmcResponseProfileManager.preparePageColl(pageColl,
					rmcInPrflBeforeColl, fieldName);

			// Get the NO ONE Collection and Cargo from Session
			final NO_ONE_Collection noOneOtherIncColl = (NO_ONE_Collection) pageCollection
					.get("NO_ONE_Collection");

			// Cargo
			RMC_IN_PRFL_Cargo rmcInPrflBeforeCargo = new RMC_IN_PRFL_Cargo();
			RMC_IN_PRFL_Cargo rmcInPrflCargoRequest = new RMC_IN_PRFL_Cargo();

			// Get Request Collection
			rmcInPrflCollRequest = compareRmcInPrflColl(rmcInPrflBeforeColl,
					pageColl);
			rmcResponseProfileManager.preparePageColl(pageColl,
					rmcInPrflCollSession, fieldName);
			/*final RMC_IN_PRFL_Collection combinedCollection = new RMC_IN_PRFL_Collection();
			for (int i = 0; i < rmcInPrflCollSession.size(); i++) {
				final RMC_IN_PRFL_Cargo sessionCargo = rmcInPrflCollSession
						.getCargo(i);

				for (int j = 0; j < pageColl.size(); j++) {
					final RMC_IN_PRFL_Cargo pageCargo = pageColl.getCargo(j);
					if (pageCargo.getIndv_seq_num().equals(
							sessionCargo.getIndv_seq_num())) {
						if (pageCargo.getAdoptAssistance() != null) {
							sessionCargo.setAdoptAssistance(pageCargo
									.getAdoptAssistance());
						}
						if (pageCargo.getAdoptionPayments() != null) {
							sessionCargo.setAdoptionPayments(pageCargo
									.getAdoptionPayments());
						}
						if (pageCargo.getAgentOrangePayments() != null) {
							sessionCargo.setAgentOrangePayments(pageCargo
									.getAgentOrangePayments());
						}
						if (pageCargo.getAlimony() != null) {
							sessionCargo.setAlimony(pageCargo.getAlimony());
						}
						if (pageCargo.getCapitalGains() != null) {
							sessionCargo.setCapitalGains(pageCargo
									.getCapitalGains());
						}
						if (pageCargo.getDeathBenefits() != null) {
							sessionCargo.setDeathBenefits(pageCargo
									.getDeathBenefits());
						}
						if (pageCargo.getDisabilityIncome() != null) {
							sessionCargo.setDisabilityIncome(pageCargo
									.getDisabilityIncome());
						}
						if (pageCargo.getDisasterRelief() != null) {
							sessionCargo.setDisasterRelief(pageCargo
									.getDisasterRelief());
						}
						if (pageCargo.getEducationalAssistance() != null) {
							sessionCargo.setEducationalAssistance(pageCargo
									.getEducationalAssistance());
						}
						if (pageCargo.getEnergyAssistance() != null) {
							sessionCargo.setEnergyAssistance(pageCargo
									.getEnergyAssistance());
						}
						if (pageCargo.getFarmAllotment() != null) {
							sessionCargo.setFarmAllotment(pageCargo
									.getFarmAllotment());
						}
						if (pageCargo.getFosterCarePayments() != null) {
							sessionCargo.setFosterCarePayments(pageCargo
									.getFosterCarePayments());
						}
						if (pageCargo.getGeneralAssistance() != null) {
							sessionCargo.setGeneralAssistance(pageCargo
									.getGeneralAssistance());
						}
						if (pageCargo.getInterestDividendPayments() != null) {
							sessionCargo.setInterestDividendPayments(pageCargo
									.getInterestDividendPayments());
						}
						if (pageCargo.getiRADistribution() != null) {
							sessionCargo.setiRADistribution(pageCargo
									.getiRADistribution());
						}
						if (pageCargo.getLotteryWinnings() != null) {
							sessionCargo.setLotteryWinnings(pageCargo
									.getLotteryWinnings());
						}
						if (pageCargo.getLumpSum() != null) {
							sessionCargo.setLumpSum(pageCargo.getLumpSum());
						}
						if (pageCargo.getMilitaryAllotment() != null) {
							sessionCargo.setMilitaryAllotment(pageCargo
									.getMilitaryAllotment());
						}
						if (pageCargo.getMoneyFromAnotherPerson() != null) {
							sessionCargo.setMoneyFromAnotherPerson(pageCargo
									.getMoneyFromAnotherPerson());
						}
						if (pageCargo.getNetRentalRoyalty() != null) {
							sessionCargo.setNetRentalRoyalty(pageCargo
									.getNetRentalRoyalty());
						}
						if (pageCargo.getOtherIncome() != null) {
							sessionCargo.setOtherIncome(pageCargo
									.getOtherIncome());
						}
						if (pageCargo.getPaymentsFromAnnuity() != null) {
							sessionCargo.setPaymentsFromAnnuity(pageCargo
									.getPaymentsFromAnnuity());
						}
						if (pageCargo.getPaymentsMadeOnYourBehalf() != null) {
							sessionCargo.setPaymentsMadeOnYourBehalf(pageCargo
									.getPaymentsMadeOnYourBehalf());
						}
						if (pageCargo.getPensionOrRetirement() != null) {
							sessionCargo.setPensionOrRetirement(pageCargo
									.getPensionOrRetirement());
						}
						if (pageCargo.getRailroadRetirement() != null) {
							sessionCargo.setRailroadRetirement(pageCargo
									.getRailroadRetirement());
						}
						if (pageCargo.getRefugeeCash() != null) {
							sessionCargo.setRefugeeCash(pageCargo
									.getRefugeeCash());
						}
						if (pageCargo.getRelativeCareSubsidy() != null) {
							sessionCargo.setRelativeCareSubsidy(pageCargo
									.getRelativeCareSubsidy());
						}
						if (pageCargo.getRentalIncome() != null) {
							sessionCargo.setRentalIncome(pageCargo
									.getRentalIncome());
						}
						if (pageCargo.gettANFPayments() != null) {
							sessionCargo.settANFPayments(pageCargo
									.gettANFPayments());
						}
						if (pageCargo.getUnemploymentCompensation() != null) {
							sessionCargo.setUnemploymentCompensation(pageCargo
									.getUnemploymentCompensation());
						}
						if (pageCargo.getWorkStudyStateFederal() != null) {
							sessionCargo.setWorkStudyStateFederal(pageCargo
									.getWorkStudyStateFederal());
						}
						if (pageCargo.getWorkersCompensation() != null) {
							sessionCargo.setWorkersCompensation(pageCargo
									.getWorkersCompensation());
						}
						if (pageCargo.getIncome_from_resource() != null) {
							sessionCargo.setIncome_from_resource(pageCargo
									.getIncome_from_resource());
						}
						if (pageCargo.getIndian_gambling_payments() != null) {
							sessionCargo.setIndian_gambling_payments(pageCargo
									.getIndian_gambling_payments());
						}
						if (pageCargo.getInheritance_income() != null) {
							sessionCargo.setInheritance_income(pageCargo
									.getInheritance_income());
						}
						if (pageCargo.getInsuance_benefits() != null) {
							sessionCargo.setInsuance_benefits(pageCargo
									.getInsuance_benefits());
						}
						if (pageCargo.getLoan_received() != null) {
							sessionCargo.setLoan_received(pageCargo
									.getLoan_received());
						}
						if (pageCargo.getLoan_repayment_income() != null) {
							sessionCargo.setLoan_repayment_income(pageCargo
									.getLoan_repayment_income());
						}
						if (pageCargo.getManaged_income() != null) {
							sessionCargo.setManaged_income(pageCargo
									.getManaged_income());
						}
						if (pageCargo.getMatch_grant() != null) {
							sessionCargo.setMatch_grant(pageCargo
									.getMatch_grant());
						}
						if (pageCargo.getMontgomery_gi_bill() != null) {
							sessionCargo.setMontgomery_gi_bill(pageCargo
									.getMontgomery_gi_bill());
						}
						if (pageCargo.getOut_of_state_public() != null) {
							sessionCargo.setOut_of_state_public(pageCargo
									.getOut_of_state_public());
						}

						if (pageCargo.getRefunds_from_dch() != null) {
							sessionCargo.setRefunds_from_dch(pageCargo
									.getRefunds_from_dch());
						}
						if (pageCargo.getRestitutions_settlements() != null) {
							sessionCargo.setRestitutions_settlements(pageCargo
									.getRestitutions_settlements());
						}
						if (pageCargo.getSenior_companion() != null) {
							sessionCargo.setSenior_companion(pageCargo
									.getSenior_companion());
						}
						if (pageCargo.getSeverance_pay() != null) {
							sessionCargo.setSeverance_pay(pageCargo
									.getSeverance_pay());
						}
						if (pageCargo.getStrike_benefits() != null) {
							sessionCargo.setStrike_benefits(pageCargo
									.getStrike_benefits());
						}
						if (pageCargo.getTrade_readjustment() != null) {
							sessionCargo.setTrade_readjustment(pageCargo
									.getTrade_readjustment());
						}
						if (pageCargo.getUniform_relocation() != null) {
							sessionCargo.setUniform_relocation(pageCargo
									.getUniform_relocation());
						}
						if (pageCargo.getUnion_funds() != null) {
							sessionCargo.setUnion_funds(pageCargo
									.getUnion_funds());
						}
						if (pageCargo.getVendor_excluded() != null) {
							sessionCargo.setVendor_excluded(pageCargo
									.getVendor_excluded());
						}
						if (pageCargo.getVictim_restitution() != null) {
							sessionCargo.setVictim_restitution(pageCargo
									.getVictim_restitution());
						}
						if (pageCargo.getVolunteer_payment() != null) {
							sessionCargo.setVolunteer_payment(pageCargo
									.getVolunteer_payment());
						}
						if (pageCargo.getVolunteer_payment_titlei() != null) {
							sessionCargo.setVolunteer_payment_titlei(pageCargo
									.getVolunteer_payment_titlei());
						}
						if (pageCargo.getWia_training_and_allowance() != null) {
							sessionCargo
							.setWia_training_and_allowance(pageCargo
									.getWia_training_and_allowance());
						}
						if (pageCargo.getIncluded_unearned_income() != null) {
							sessionCargo.setIncluded_unearned_income(pageCargo
									.getIncluded_unearned_income());
						}
						if (pageCargo.getTanf_max_au_allotment() != null) {
							sessionCargo.setTanf_max_au_allotment(pageCargo
									.getTanf_max_au_allotment());
						}
						if (pageCargo.getTanf_max_grg_allotment() != null) {
							sessionCargo.setTanf_max_grg_allotment(pageCargo
									.getTanf_max_grg_allotment());
						}
						if (pageCargo.getCharitable_donation() != null) {
							sessionCargo.setCharitable_donation(pageCargo
									.getCharitable_donation());
						}
						if (pageCargo.getChild_nutrition_payments() != null) {
							sessionCargo.setChild_nutrition_payments(pageCargo
									.getChild_nutrition_payments());
						}
						if (pageCargo.getBlack_lung_benefits() != null) {
							sessionCargo.setBlack_lung_benefits(pageCargo
									.getBlack_lung_benefits());
						}
						if (pageCargo.getChild_support_court() != null) {
							sessionCargo.setChild_support_court(pageCargo
									.getChild_support_court());
						}
						if (pageCargo.getChild_support_gap_payment() != null) {
							sessionCargo.setChild_support_gap_payment(pageCargo
									.getChild_support_gap_payment());
						}
						if (pageCargo.getCivil_service() != null) {
							sessionCargo.setCivil_service(pageCargo
									.getCivil_service());
						}
						if (pageCargo.getDeferred_compensation_plans() != null) {
							sessionCargo
							.setDeferred_compensation_plans(pageCargo
									.getDeferred_compensation_plans());
						}
						if (pageCargo.getDisability_insurance() != null) {
							sessionCargo.setDisability_insurance(pageCargo
									.getDisability_insurance());
						}
						if (pageCargo.getExcluded_unearned_income() != null) {
							sessionCargo.setExcluded_unearned_income(pageCargo
									.getExcluded_unearned_income());
						}
						if (pageCargo.getFema_payment_disaster() != null) {
							sessionCargo.setFema_payment_disaster(pageCargo
									.getFema_payment_disaster());
						}
						if (pageCargo.getFema_payment_non_disaster() != null) {
							sessionCargo.setFema_payment_non_disaster(pageCargo
									.getFema_payment_non_disaster());
						}
						if (pageCargo.getHealth_savings_account() != null) {
							sessionCargo.setHealth_savings_account(pageCargo
									.getHealth_savings_account());
						}
						if (pageCargo.getIn_kind_support() != null) {
							sessionCargo.setIn_kind_support(pageCargo
									.getIn_kind_support());
						}
						if (pageCargo.getFoster_grandparent_program() != null) {
							sessionCargo
							.setFoster_grandparent_program(pageCargo
									.getFoster_grandparent_program());
						}
						if (pageCargo.getDisaster_unemployment() != null) {
							sessionCargo.setDisaster_unemployment(pageCargo
									.getDisaster_unemployment());
						}
						if (pageCargo.getDividends() != null) {
							sessionCargo.setDividends(pageCargo.getDividends());
						}
						if (pageCargo.getCharitable_donation_federal() != null) {
							sessionCargo
							.setCharitable_donation_federal(pageCargo
									.getCharitable_donation_federal());
						}
						if (pageCargo.getDeath_benefit_state_federal() != null) {
							sessionCargo
							.setDeath_benefit_state_federal(pageCargo
									.getDeath_benefit_state_federal());
						}
						if (pageCargo.getSocial_security_survivor() != null) {
							sessionCargo.setSocial_security_survivor(pageCargo
									.getSocial_security_survivor());
						}
						if (pageCargo.getVendor_payments() != null) {
							sessionCargo.setVendor_payments(pageCargo
									.getVendor_payments());
						}
						combinedCollection.add(sessionCargo);
					}
				}
			}*/

			// Get NoOneCollection
			NO_ONE_Collection newNoOneColl = new NO_ONE_Collection();
			newNoOneColl = compareNoOneCollections(noOneBeforeColl,
					noOneOtherIncColl);

			if (!newNoOneColl.equals(noOneOtherIncColl)) {
				newNoOneColl = noOneOtherIncColl;
			}
			validateNoOneBO.validateNoOneOtherIncomeType(rmcInPrflCollRequest,
					newNoOneColl, beforeFirstNamesList, appType);
			// // Run Validation
			final String backToMyAccess = (String) request
					.get(AppConstants.BACK_TO_MY_ACCESS_BUTTON);

			if (checkBackToMyAccessSelected(request)
					|| validateNoOneBO.hasMessages()) {
				final String reqWarningMsgs = (String) request
						.get(FwConstants.WARNING_MSG_DETAILS);
				if (!checkForWarningMesgs(reqWarningMsgs,
						validateNoOneBO.getMessageList())) {
					if (backToMyAccess == null) {
						request.put(FwConstants.MESSAGE_LIST,
								validateNoOneBO.getMessageList());
					}

					// Translate Profile Response After Validation

					if (rmcInPrflCollSession != null) {
						rmcResponseProfileManager
						.translateProfileResponseAfterValidation(
								rmcInPrflCollRequest,
								rmcInPrflCollSession, fieldName);
					}
					if (rmcInPrflCollSession == null) {
						RMC_IN_PRFL_Cargo rmcInPrflCargo = new RMC_IN_PRFL_Cargo();
						if (rmcInPrflCargo == null) {
							final INDIVIDUAL_Custom_Cargo indvCargo = indvCustColl
									.getResult(0);
							rmcInPrflCargo = new RMC_IN_PRFL_Cargo();
							rmcInPrflCargo.setApp_num(appNum);
							rmcInPrflCargo.setIndv_seq_num(indvCargo
									.getIndv_seq_num());
							rmcResponseProfileManager
							.createRMCIndividualProfile(rmcInPrflCargo);
							rmcInPrflCollSession.addCargo(rmcInPrflCargo);
						}

					}
					pageCollection.put("RMC_IN_PRFL_TEMP_Collection",
							rmcInPrflCollRequest);
					pageCollection.put("NO_ONE_Collection", noOneOtherIncColl);
					pageCollection.put(FwConstants.PAGE_COMPONENT_LIST,
							beforeMap.get(FwConstants.PAGE_COMPONENT_LIST));
					txnBean.setRequest(request);
					txnBean.setPageCollection(pageCollection);
					return;
				}
			}

			// Initialize the colSize
			final int colSize = rmcInPrflBeforeColl.size();
			final int reqsize = rmcInPrflCollRequest.size();
			int noOneSize = 0;
			if (noOneOtherIncColl != null) {
				noOneSize = noOneOtherIncColl.size();
			}
			final List reqResponse = new ArrayList();
			final List sesResponse = new ArrayList();
			boolean persistFlag = false;
			boolean driverFlag = true;
			final int sizeQuestion = 78;
			String beforeIndvSeqNum = null;
			String resIndvSeqNum = null;

			// Initialize dirty status
			final int[] dirtyStatus = { 0 };

			// Start of loop for each cargo in session AIP
			for (int i = 0; i < colSize; i++) {
				// get cargo in the collection
				rmcInPrflBeforeCargo = rmcInPrflBeforeColl.getCargo(i);
				beforeIndvSeqNum = rmcInPrflBeforeCargo.getIndv_seq_num();

				if (rmcInPrflBeforeCargo.getOthr_incm_resp().charAt(0) != IRMCResponseProfileManager.STATUS_NOT_REQUIRED) {
					rmcInPrflCargoRequest = rmcResponseProfileManager
							.getProfile(rmcInPrflCollRequest, beforeIndvSeqNum);
					resIndvSeqNum = rmcInPrflCargoRequest.getIndv_seq_num();

					if (beforeIndvSeqNum.equals(resIndvSeqNum)) {
						// get responses from request

						// GA IES
						reqResponse.add(rmcInPrflCargoRequest
								.getAdoptAssistance());
						reqResponse.add(rmcInPrflCargoRequest
								.getAdoptionPayments());
						reqResponse.add(rmcInPrflCargoRequest
								.getAgentOrangePayments());
						reqResponse.add(rmcInPrflCargoRequest.getAlimony());
						reqResponse
						.add(rmcInPrflCargoRequest.getCapitalGains());
						reqResponse.add(rmcInPrflCargoRequest
								.getDeathBenefits());
						reqResponse.add(rmcInPrflCargoRequest
								.getDisabilityIncome());
						reqResponse.add(rmcInPrflCargoRequest
								.getDisasterRelief());
						reqResponse.add(rmcInPrflCargoRequest
								.getEducationalAssistance());
						reqResponse.add(rmcInPrflCargoRequest
								.getEnergyAssistance());
						reqResponse.add(rmcInPrflCargoRequest
								.getFarmAllotment());
						reqResponse.add(rmcInPrflCargoRequest
								.getFosterCarePayments());
						reqResponse.add(rmcInPrflCargoRequest
								.getGeneralAssistance());
						reqResponse.add(rmcInPrflCargoRequest
								.getInterestDividendPayments());
						reqResponse.add(rmcInPrflCargoRequest
								.getiRADistribution());
						reqResponse.add(rmcInPrflCargoRequest
								.getLotteryWinnings());
						reqResponse.add(rmcInPrflCargoRequest.getLumpSum());
						reqResponse.add(rmcInPrflCargoRequest
								.getMilitaryAllotment());
						reqResponse.add(rmcInPrflCargoRequest
								.getMoneyFromAnotherPerson());
						reqResponse.add(rmcInPrflCargoRequest
								.getNetRentalRoyalty());
						reqResponse.add(rmcInPrflCargoRequest.getOtherIncome());
						reqResponse.add(rmcInPrflCargoRequest
								.getPaymentsFromAnnuity());
						reqResponse.add(rmcInPrflCargoRequest
								.getPaymentsMadeOnYourBehalf());
						reqResponse.add(rmcInPrflCargoRequest
								.getPensionOrRetirement());
						reqResponse.add(rmcInPrflCargoRequest
								.getRailroadRetirement());
						reqResponse.add(rmcInPrflCargoRequest.getRefugeeCash());
						reqResponse.add(rmcInPrflCargoRequest
								.getRelativeCareSubsidy());
						reqResponse
						.add(rmcInPrflCargoRequest.getRentalIncome());
						reqResponse
						.add(rmcInPrflCargoRequest.gettANFPayments());
						reqResponse.add(rmcInPrflCargoRequest
								.getUnemploymentCompensation());
						reqResponse.add(rmcInPrflCargoRequest
								.getWorkStudyStateFederal());
						reqResponse.add(rmcInPrflCargoRequest
								.getWorkersCompensation());
						reqResponse.add(rmcInPrflCargoRequest
								.getIncome_from_resource());
						reqResponse.add(rmcInPrflCargoRequest
								.getIndian_gambling_payments());
						reqResponse.add(rmcInPrflCargoRequest
								.getInheritance_income());
						reqResponse.add(rmcInPrflCargoRequest
								.getInsuance_benefits());
						reqResponse.add(rmcInPrflCargoRequest
								.getLoan_received());
						reqResponse.add(rmcInPrflCargoRequest
								.getLoan_repayment_income());
						reqResponse.add(rmcInPrflCargoRequest
								.getManaged_income());
						reqResponse.add(rmcInPrflCargoRequest.getMatch_grant());
						reqResponse.add(rmcInPrflCargoRequest
								.getMontgomery_gi_bill());
						reqResponse.add(rmcInPrflCargoRequest
								.getOut_of_state_public());
						reqResponse.add(rmcInPrflCargoRequest
								.getRefunds_from_dch());
						reqResponse.add(rmcInPrflCargoRequest
								.getRestitutions_settlements());
						reqResponse.add(rmcInPrflCargoRequest
								.getSenior_companion());
						reqResponse.add(rmcInPrflCargoRequest
								.getSeverance_pay());
						reqResponse.add(rmcInPrflCargoRequest
								.getStrike_benefits());
						reqResponse.add(rmcInPrflCargoRequest
								.getTrade_readjustment());
						reqResponse.add(rmcInPrflCargoRequest
								.getUniform_relocation());
						reqResponse.add(rmcInPrflCargoRequest.getUnion_funds());
						reqResponse.add(rmcInPrflCargoRequest
								.getVendor_excluded());
						reqResponse.add(rmcInPrflCargoRequest
								.getVictim_restitution());
						reqResponse.add(rmcInPrflCargoRequest
								.getVolunteer_payment());
						reqResponse.add(rmcInPrflCargoRequest
								.getVolunteer_payment_titlei());
						reqResponse.add(rmcInPrflCargoRequest
								.getWia_training_and_allowance());
						reqResponse.add(rmcInPrflCargoRequest
								.getIncluded_unearned_income());
						reqResponse.add(rmcInPrflCargoRequest
								.getTanf_max_au_allotment());
						reqResponse.add(rmcInPrflCargoRequest
								.getTanf_max_grg_allotment());
						reqResponse.add(rmcInPrflCargoRequest
								.getCharitable_donation());
						reqResponse.add(rmcInPrflCargoRequest
								.getChild_nutrition_payments());
						reqResponse.add(rmcInPrflCargoRequest
								.getBlack_lung_benefits());
						reqResponse.add(rmcInPrflCargoRequest
								.getChild_support_court());
						reqResponse.add(rmcInPrflCargoRequest
								.getChild_support_gap_payment());
						reqResponse.add(rmcInPrflCargoRequest
								.getCivil_service());
						reqResponse.add(rmcInPrflCargoRequest
								.getDeferred_compensation_plans());
						reqResponse.add(rmcInPrflCargoRequest
								.getDisability_insurance());
						reqResponse.add(rmcInPrflCargoRequest
								.getExcluded_unearned_income());
						reqResponse.add(rmcInPrflCargoRequest
								.getFema_payment_disaster());
						reqResponse.add(rmcInPrflCargoRequest
								.getFema_payment_non_disaster());
						reqResponse.add(rmcInPrflCargoRequest
								.getHealth_savings_account());
						reqResponse.add(rmcInPrflCargoRequest
								.getIn_kind_support());
						reqResponse.add(rmcInPrflCargoRequest
								.getFoster_grandparent_program());
						reqResponse.add(rmcInPrflCargoRequest
								.getDisaster_unemployment());
						reqResponse.add(rmcInPrflCargoRequest.getDividends());
						reqResponse.add(rmcInPrflCargoRequest
								.getCharitable_donation_federal());
						reqResponse.add(rmcInPrflCargoRequest
								.getDeath_benefit_state_federal());
						reqResponse.add(rmcInPrflCargoRequest
								.getSocial_security_survivor());
						reqResponse.add(rmcInPrflCargoRequest
								.getVendor_payments());
						// GA IES
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getAdoptAssistance())) {
							rmcInPrflBeforeCargo
							.setAdoptAssistance(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getAdoptionPayments())) {
							rmcInPrflBeforeCargo
							.setAdoptionPayments(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getAgentOrangePayments())) {
							rmcInPrflBeforeCargo
							.setAgentOrangePayments(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getAlimony())) {
							rmcInPrflBeforeCargo
							.setAlimony(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getCapitalGains())) {
							rmcInPrflBeforeCargo
							.setCapitalGains(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getDeathBenefits())) {
							rmcInPrflBeforeCargo
							.setDeathBenefits(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getDisabilityIncome())) {
							rmcInPrflBeforeCargo
							.setDisabilityIncome(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getDisasterRelief())) {
							rmcInPrflBeforeCargo
							.setDisasterRelief(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getEducationalAssistance())) {
							rmcInPrflBeforeCargo
							.setEducationalAssistance(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getEnergyAssistance())) {
							rmcInPrflBeforeCargo
							.setEnergyAssistance(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getFarmAllotment())) {
							rmcInPrflBeforeCargo
							.setFarmAllotment(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getFosterCarePayments())) {
							rmcInPrflBeforeCargo
							.setFosterCarePayments(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getGeneralAssistance())) {
							rmcInPrflBeforeCargo
							.setGeneralAssistance(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getInterestDividendPayments())) {
							rmcInPrflBeforeCargo
							.setInterestDividendPayments(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getiRADistribution())) {
							rmcInPrflBeforeCargo
							.setiRADistribution(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getLotteryWinnings())) {
							rmcInPrflBeforeCargo
							.setLotteryWinnings(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getLumpSum())) {
							rmcInPrflBeforeCargo
							.setLumpSum(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getMilitaryAllotment())) {
							rmcInPrflBeforeCargo
							.setMilitaryAllotment(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getMoneyFromAnotherPerson())) {
							rmcInPrflBeforeCargo
							.setMoneyFromAnotherPerson(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getNetRentalRoyalty())) {
							rmcInPrflBeforeCargo
							.setNetRentalRoyalty(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getOtherIncome())) {
							rmcInPrflBeforeCargo
							.setOtherIncome(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getPaymentsFromAnnuity())) {
							rmcInPrflBeforeCargo
							.setPaymentsFromAnnuity(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getPaymentsMadeOnYourBehalf())) {
							rmcInPrflBeforeCargo
							.setPaymentsMadeOnYourBehalf(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getPensionOrRetirement())) {
							rmcInPrflBeforeCargo
							.setPensionOrRetirement(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getRailroadRetirement())) {
							rmcInPrflBeforeCargo
							.setRailroadRetirement(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getRefugeeCash())) {
							rmcInPrflBeforeCargo
							.setRefugeeCash(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getRelativeCareSubsidy())) {
							rmcInPrflBeforeCargo
							.setRelativeCareSubsidy(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getRentalIncome())) {
							rmcInPrflBeforeCargo
							.setRentalIncome(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.gettANFPayments())) {
							rmcInPrflBeforeCargo
							.settANFPayments(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getUnemploymentCompensation())) {
							rmcInPrflBeforeCargo
							.setUnemploymentCompensation(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getWorkStudyStateFederal())) {
							rmcInPrflBeforeCargo
							.setWorkStudyStateFederal(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getWorkersCompensation())) {
							rmcInPrflBeforeCargo
							.setWorkersCompensation(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getIncome_from_resource())) {
							rmcInPrflBeforeCargo
							.setIncome_from_resource(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getIndian_gambling_payments())) {
							rmcInPrflBeforeCargo
							.setIndian_gambling_payments(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getInheritance_income())) {
							rmcInPrflBeforeCargo
							.setInheritance_income(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getInsuance_benefits())) {
							rmcInPrflBeforeCargo
							.setInsuance_benefits(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getLoan_received())) {
							rmcInPrflBeforeCargo
							.setLoan_received(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getLoan_repayment_income())) {
							rmcInPrflBeforeCargo
							.setLoan_repayment_income(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getManaged_income())) {
							rmcInPrflBeforeCargo
							.setManaged_income(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getMatch_grant())) {
							rmcInPrflBeforeCargo
							.setMatch_grant(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getMontgomery_gi_bill())) {
							rmcInPrflBeforeCargo
							.setMontgomery_gi_bill(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getOut_of_state_public())) {
							rmcInPrflBeforeCargo
							.setOut_of_state_public(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getRefunds_from_dch())) {
							rmcInPrflBeforeCargo
							.setRefunds_from_dch(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getRestitutions_settlements())) {
							rmcInPrflBeforeCargo
							.setRestitutions_settlements(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getSenior_companion())) {
							rmcInPrflBeforeCargo
							.setSenior_companion(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getSeverance_pay())) {
							rmcInPrflBeforeCargo
							.setSeverance_pay(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getStrike_benefits())) {
							rmcInPrflBeforeCargo
							.setStrike_benefits(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getTrade_readjustment())) {
							rmcInPrflBeforeCargo
							.setTrade_readjustment(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getUniform_relocation())) {
							rmcInPrflBeforeCargo
							.setUniform_relocation(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getUnion_funds())) {
							rmcInPrflBeforeCargo
							.setUnion_funds(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getVendor_excluded())) {
							rmcInPrflBeforeCargo
							.setVendor_excluded(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getVictim_restitution())) {
							rmcInPrflBeforeCargo
							.setVictim_restitution(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getVolunteer_payment())) {
							rmcInPrflBeforeCargo
							.setVolunteer_payment(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getVolunteer_payment_titlei())) {
							rmcInPrflBeforeCargo
							.setVolunteer_payment_titlei(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getWia_training_and_allowance())) {
							rmcInPrflBeforeCargo
							.setWia_training_and_allowance(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getIncluded_unearned_income())) {
							rmcInPrflBeforeCargo
							.setIncluded_unearned_income(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getTanf_max_au_allotment())) {
							rmcInPrflBeforeCargo
							.setTanf_max_au_allotment(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getTanf_max_grg_allotment())) {
							rmcInPrflBeforeCargo
							.setTanf_max_grg_allotment(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getCharitable_donation())) {
							rmcInPrflBeforeCargo
							.setCharitable_donation(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getChild_nutrition_payments())) {
							rmcInPrflBeforeCargo
							.setChild_nutrition_payments(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getBlack_lung_benefits())) {
							rmcInPrflBeforeCargo
							.setBlack_lung_benefits(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getChild_support_court())) {
							rmcInPrflBeforeCargo
							.setChild_support_court(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getChild_support_gap_payment())) {
							rmcInPrflBeforeCargo
							.setChild_support_gap_payment(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getCivil_service())) {
							rmcInPrflBeforeCargo
							.setCivil_service(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getDeferred_compensation_plans())) {
							rmcInPrflBeforeCargo
							.setDeferred_compensation_plans(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getDisability_insurance())) {
							rmcInPrflBeforeCargo
							.setDisability_insurance(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getExcluded_unearned_income())) {
							rmcInPrflBeforeCargo
							.setExcluded_unearned_income(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getFema_payment_disaster())) {
							rmcInPrflBeforeCargo
							.setFema_payment_disaster(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getFema_payment_non_disaster())) {
							rmcInPrflBeforeCargo
							.setFema_payment_non_disaster(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getHealth_savings_account())) {
							rmcInPrflBeforeCargo
							.setHealth_savings_account(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getIn_kind_support())) {
							rmcInPrflBeforeCargo
							.setIn_kind_support(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getFoster_grandparent_program())) {
							rmcInPrflBeforeCargo
							.setFoster_grandparent_program(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getDisaster_unemployment())) {
							rmcInPrflBeforeCargo
							.setDisaster_unemployment(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getDividends())) {
							rmcInPrflBeforeCargo
							.setDividends(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getCharitable_donation_federal())) {
							rmcInPrflBeforeCargo
							.setCharitable_donation_federal(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getDeath_benefit_state_federal())) {
							rmcInPrflBeforeCargo
							.setDeath_benefit_state_federal(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getSocial_security_survivor())) {
							rmcInPrflBeforeCargo
							.setSocial_security_survivor(AppConstants.REQUIRED);
						}
						if (AppConstants.YES.equals(rmcInPrflBeforeCargo
								.getVendor_payments())) {
							rmcInPrflBeforeCargo
							.setVendor_payments(AppConstants.REQUIRED);
						}

						sesResponse.add(rmcInPrflBeforeCargo
								.getAdoptAssistance());
						sesResponse.add(rmcInPrflBeforeCargo
								.getAdoptionPayments());
						sesResponse.add(rmcInPrflBeforeCargo
								.getAgentOrangePayments());
						sesResponse.add(rmcInPrflBeforeCargo.getAlimony());
						sesResponse.add(rmcInPrflBeforeCargo.getCapitalGains());
						sesResponse
						.add(rmcInPrflBeforeCargo.getDeathBenefits());
						sesResponse.add(rmcInPrflBeforeCargo
								.getDisabilityIncome());
						sesResponse.add(rmcInPrflBeforeCargo
								.getDisasterRelief());
						sesResponse.add(rmcInPrflBeforeCargo
								.getEducationalAssistance());
						sesResponse.add(rmcInPrflBeforeCargo
								.getEnergyAssistance());
						sesResponse
						.add(rmcInPrflBeforeCargo.getFarmAllotment());
						sesResponse.add(rmcInPrflBeforeCargo
								.getFosterCarePayments());
						sesResponse.add(rmcInPrflBeforeCargo
								.getGeneralAssistance());
						sesResponse.add(rmcInPrflBeforeCargo
								.getInterestDividendPayments());
						sesResponse.add(rmcInPrflBeforeCargo
								.getiRADistribution());
						sesResponse.add(rmcInPrflBeforeCargo
								.getLotteryWinnings());
						sesResponse.add(rmcInPrflBeforeCargo.getLumpSum());
						sesResponse.add(rmcInPrflBeforeCargo
								.getMilitaryAllotment());
						sesResponse.add(rmcInPrflBeforeCargo
								.getMoneyFromAnotherPerson());
						sesResponse.add(rmcInPrflBeforeCargo
								.getNetRentalRoyalty());
						sesResponse.add(rmcInPrflBeforeCargo.getOtherIncome());
						sesResponse.add(rmcInPrflBeforeCargo
								.getPaymentsFromAnnuity());
						sesResponse.add(rmcInPrflBeforeCargo
								.getPaymentsMadeOnYourBehalf());
						sesResponse.add(rmcInPrflBeforeCargo
								.getPensionOrRetirement());
						sesResponse.add(rmcInPrflBeforeCargo
								.getRailroadRetirement());
						sesResponse.add(rmcInPrflBeforeCargo.getRefugeeCash());
						sesResponse.add(rmcInPrflBeforeCargo
								.getRelativeCareSubsidy());
						sesResponse.add(rmcInPrflBeforeCargo.getRentalIncome());
						sesResponse.add(rmcInPrflBeforeCargo.gettANFPayments());
						sesResponse.add(rmcInPrflBeforeCargo
								.getUnemploymentCompensation());
						sesResponse.add(rmcInPrflBeforeCargo
								.getWorkStudyStateFederal());
						sesResponse.add(rmcInPrflBeforeCargo
								.getWorkersCompensation());
						sesResponse.add(rmcInPrflBeforeCargo
								.getIncome_from_resource());
						sesResponse.add(rmcInPrflBeforeCargo
								.getIndian_gambling_payments());
						sesResponse.add(rmcInPrflBeforeCargo
								.getInheritance_income());
						sesResponse.add(rmcInPrflBeforeCargo
								.getInsuance_benefits());
						sesResponse
						.add(rmcInPrflBeforeCargo.getLoan_received());
						sesResponse.add(rmcInPrflBeforeCargo
								.getLoan_repayment_income());
						sesResponse.add(rmcInPrflBeforeCargo
								.getManaged_income());
						sesResponse.add(rmcInPrflBeforeCargo.getMatch_grant());
						sesResponse.add(rmcInPrflBeforeCargo
								.getMontgomery_gi_bill());
						sesResponse.add(rmcInPrflBeforeCargo
								.getOut_of_state_public());
						sesResponse.add(rmcInPrflBeforeCargo
								.getRefunds_from_dch());
						sesResponse.add(rmcInPrflBeforeCargo
								.getRestitutions_settlements());
						sesResponse.add(rmcInPrflBeforeCargo
								.getSenior_companion());
						sesResponse
						.add(rmcInPrflBeforeCargo.getSeverance_pay());
						sesResponse.add(rmcInPrflBeforeCargo
								.getStrike_benefits());
						sesResponse.add(rmcInPrflBeforeCargo
								.getTrade_readjustment());
						sesResponse.add(rmcInPrflBeforeCargo
								.getUniform_relocation());
						sesResponse.add(rmcInPrflBeforeCargo.getUnion_funds());
						sesResponse.add(rmcInPrflBeforeCargo
								.getVendor_excluded());
						sesResponse.add(rmcInPrflBeforeCargo
								.getVictim_restitution());
						sesResponse.add(rmcInPrflBeforeCargo
								.getVolunteer_payment());
						sesResponse.add(rmcInPrflBeforeCargo
								.getVolunteer_payment_titlei());
						sesResponse.add(rmcInPrflBeforeCargo
								.getWia_training_and_allowance());
						sesResponse.add(rmcInPrflBeforeCargo
								.getIncluded_unearned_income());
						sesResponse.add(rmcInPrflBeforeCargo
								.getTanf_max_au_allotment());
						sesResponse.add(rmcInPrflBeforeCargo
								.getTanf_max_grg_allotment());
						sesResponse.add(rmcInPrflBeforeCargo
								.getCharitable_donation());
						sesResponse.add(rmcInPrflBeforeCargo
								.getChild_nutrition_payments());
						sesResponse.add(rmcInPrflBeforeCargo
								.getBlack_lung_benefits());
						sesResponse.add(rmcInPrflBeforeCargo
								.getChild_support_court());
						sesResponse.add(rmcInPrflBeforeCargo
								.getChild_support_gap_payment());
						sesResponse
						.add(rmcInPrflBeforeCargo.getCivil_service());
						sesResponse.add(rmcInPrflBeforeCargo
								.getDeferred_compensation_plans());
						sesResponse.add(rmcInPrflBeforeCargo
								.getDisability_insurance());
						sesResponse.add(rmcInPrflBeforeCargo
								.getExcluded_unearned_income());
						sesResponse.add(rmcInPrflBeforeCargo
								.getFema_payment_disaster());
						sesResponse.add(rmcInPrflBeforeCargo
								.getFema_payment_non_disaster());
						sesResponse.add(rmcInPrflBeforeCargo
								.getHealth_savings_account());
						sesResponse.add(rmcInPrflBeforeCargo
								.getIn_kind_support());
						sesResponse.add(rmcInPrflBeforeCargo
								.getFoster_grandparent_program());
						sesResponse.add(rmcInPrflBeforeCargo
								.getDisaster_unemployment());
						sesResponse.add(rmcInPrflBeforeCargo.getDividends());
						sesResponse.add(rmcInPrflBeforeCargo
								.getCharitable_donation_federal());
						sesResponse.add(rmcInPrflBeforeCargo
								.getDeath_benefit_state_federal());
						sesResponse.add(rmcInPrflBeforeCargo
								.getSocial_security_survivor());
						sesResponse.add(rmcInPrflBeforeCargo
								.getVendor_payments());

						persistFlag = false;
						for (int s = 0; s < sizeQuestion; s++) {

							// determine dirty status
							if (rmcResponseProfileManager.determineDirtyStatus(
									(String) reqResponse.get(s),
									(String) sesResponse.get(s), dirtyStatus,
									pageStatus)) {
								persistFlag = true;
							}
							// translate profile response
							rmcResponseProfileManager
							.translateProfileResponsesForType(
									(String) reqResponse.get(s),
									(String) sesResponse.get(s),
									pageStatus,
									fieldName[s],
									rmcInPrflBeforeCargo,
									IRMCResponseProfileManager.OTHER_INCOME);
						}

						if (persistFlag == true) {
							persistArray.add(beforeIndvSeqNum);
							persistColl.add(rmcInPrflBeforeCargo);
						}

						if (rmcInPrflBeforeCargo
								.getAdoptAssistance()
								.equals(String
										.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
										&& rmcInPrflBeforeCargo
										.getAdoptionPayments()
										.equals(String
												.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
												&& rmcInPrflBeforeCargo
												.getAgentOrangePayments()
												.equals(String
														.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
														.getAlimony()
														.equals(String
																.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																.getCapitalGains()
																.equals(String
																		.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																		.getDeathBenefits()
																		.equals(String
																				.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																				.getDisabilityIncome()
																				.equals(String
																						.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																						.getDisasterRelief()
																						.equals(String
																								.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																								.getEducationalAssistance()
																								.equals(String
																										.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																										.getEnergyAssistance()
																										.equals(String
																												.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																												.getFarmAllotment()
																												.equals(String
																														.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																														.getFosterCarePayments()
										.equals(String
																																.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																.getGeneralAssistance()
																																.equals(String
																																		.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																		.getInterestDividendPayments()
																																		.equals(String
																																				.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																				.getiRADistribution()
																																				.equals(String
																																						.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																						.getLotteryWinnings()
																																						.equals(String
																																								.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																								.getLumpSum()
																																								.equals(String
																																										.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																										.getMilitaryAllotment()
																																										.equals(String
																																												.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																												.getMoneyFromAnotherPerson()
																																												.equals(String
																																														.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																														.getNetRentalRoyalty()
																																														.equals(String
																																																.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																.getOtherIncome()
																																																.equals(String
																																																		.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																		.getPaymentsFromAnnuity()
																																																		.equals(String
																																																				.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																				.getPaymentsMadeOnYourBehalf()
																																																				.equals(String
																																																						.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																						.getPensionOrRetirement()
																																																						.equals(String
																																																								.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																								.getRailroadRetirement()
										.equals(String
																																																										.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																										.getRefugeeCash()
																																																										.equals(String
																																																												.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																												.getRelativeCareSubsidy()
																																																												.equals(String
																																																														.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																														.getRentalIncome()
																																																														.equals(String
																																																																.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																.gettANFPayments()
																																																																.equals(String
																																																																		.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																		.getUnemploymentCompensation()
																																																																		.equals(String
																																																																				.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																				.getWorkStudyStateFederal()
																																																																				.equals(String
																																																																						.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																						.getWorkersCompensation()
																																																																						.equals(String
																																																																								.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																								.getIncome_from_resource()
																																																																								.equals(String
																																																																										.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																										.getIndian_gambling_payments()
																																																																										.equals(String
																																																																												.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																												.getInheritance_income()
										.equals(String
																																																																														.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																														.getInsuance_benefits()
																																																																														.equals(String
																																																																																.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																.getLoan_received()
																																																																																.equals(String
																																																																																		.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																		.getLoan_repayment_income()
																																																																																		.equals(String
																																																																																				.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																				.getManaged_income()
																																																																																				.equals(String
																																																																																						.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																						.getMatch_grant()
																																																																																						.equals(String
																																																																																								.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																								.getMontgomery_gi_bill()
										.equals(String
																																																																																										.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																										.getOut_of_state_public()
																																																																																										.equals(String
																																																																																												.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																												.getRefunds_from_dch()
																																																																																												.equals(String
																																																																																														.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																														.getRestitutions_settlements()
																																																																																														.equals(String
																																																																																																.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																.getSenior_companion()
																																																																																																.equals(String
																																																																																																		.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																		.getSeverance_pay()
																																																																																																		.equals(String
																																																																																																				.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																				.getStrike_benefits()
																																																																																																				.equals(String
																																																																																																						.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																						.getTrade_readjustment()
										.equals(String
																																																																																																								.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																								.getUniform_relocation()
										.equals(String
																																																																																																										.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																										.getUnion_funds()
																																																																																																										.equals(String
																																																																																																												.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																												.getVendor_excluded()
																																																																																																												.equals(String
																																																																																																														.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																														.getVictim_restitution()
										.equals(String
																																																																																																																.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																																.getVolunteer_payment()
																																																																																																																.equals(String
																																																																																																																		.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																																		.getVolunteer_payment_titlei()
																																																																																																																		.equals(String
																																																																																																																				.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																																				.getWia_training_and_allowance()
																																																																																																																				.equals(String
																																																																																																																						.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																																						.getIncluded_unearned_income()
																																																																																																																						.equals(String
																																																																																																																								.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																																								.getTanf_max_au_allotment()
																																																																																																																								.equals(String
																																																																																																																										.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																																										.getTanf_max_grg_allotment()
																																																																																																																										.equals(String
																																																																																																																												.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																																												.getCharitable_donation()
																																																																																																																												.equals(String
																																																																																																																														.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																																														.getChild_nutrition_payments()
																																																																																																																														.equals(String
																																																																																																																																.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																																																.getBlack_lung_benefits()
																																																																																																																																.equals(String
																																																																																																																																		.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																																																		.getChild_support_court()
																																																																																																																																		.equals(String
																																																																																																																																				.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																																																				.getChild_support_gap_payment()
																																																																																																																																				.equals(String
																																																																																																																																						.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																																																						.getCivil_service()
																																																																																																																																						.equals(String
																																																																																																																																								.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																																																								.getDeferred_compensation_plans()
																																																																																																																																								.equals(String
																																																																																																																																										.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																																																										.getDisability_insurance()
																																																																																																																																										.equals(String
																																																																																																																																												.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																																																												.getExcluded_unearned_income()
																																																																																																																																												.equals(String
																																																																																																																																														.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																																																														.getFema_payment_disaster()
																																																																																																																																														.equals(String
																																																																																																																																																.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																																																																.getFema_payment_non_disaster()
																																																																																																																																																.equals(String
																																																																																																																																																		.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																																																																		.getHealth_savings_account()
																																																																																																																																																		.equals(String
																																																																																																																																																				.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																																																																				.getIn_kind_support()
																																																																																																																																																				.equals(String
																																																																																																																																																						.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																																																																						.getFoster_grandparent_program()
																																																																																																																																																						.equals(String
																																																																																																																																																								.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																																																																								.getDisaster_unemployment()
																																																																																																																																																								.equals(String
																																																																																																																																																										.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																																																																										.getDividends()
																																																																																																																																																										.equals(String
																																																																																																																																																												.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																																																																												.getCharitable_donation_federal()
																																																																																																																																																												.equals(String
																																																																																																																																																														.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																																																																														.getDeath_benefit_state_federal()
																																																																																																																																																														.equals(String
																																																																																																																																																																.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																																																																																.getSocial_security_survivor()
																																																																																																																																																																.equals(String
																																																																																																																																																																		.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))
								&& rmcInPrflBeforeCargo
																																																																																																																																																																		.getVendor_payments()
																																																																																																																																																																		.equals(String
																																																																																																																																																																				.valueOf(IRMCResponseProfileManager.STATUS_NOT_REQUIRED))) {
							rmcResponseProfileManager.makeNotRequired(
									IRMCResponseProfileManager.OTHER_INCOME,
									rmcInPrflBeforeCargo, true);
							persistArray.add(beforeIndvSeqNum);
							persistColl.add(rmcInPrflBeforeCargo);

							if (reqsize == noOneSize) {
								// Make AbsoluteNotRequired on the driver
								final String[] pageId = { "ARUIT" };
								driverManager.makeAbsoluteNotRequired(
										FwConstants.RMC_DRIVER, pageId,
										driverArray, appNum);
								driverFlag = false;
							}
						}
						
						if(rmcInPrflBeforeCargo
								.getAdoptAssistance()
								.equals(String
										.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
										|| rmcInPrflBeforeCargo
										.getAdoptionPayments()
										.equals(String
												.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
												|| rmcInPrflBeforeCargo
												.getAgentOrangePayments()
												.equals(String
														.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
														.getAlimony()
														.equals(String
																.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																.getCapitalGains()
																.equals(String
																		.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																		.getDeathBenefits()
																		.equals(String
																				.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																				.getDisabilityIncome()
																				.equals(String
																						.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																						.getDisasterRelief()
																						.equals(String
																								.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																								.getEducationalAssistance()
																								.equals(String
																										.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																										.getEnergyAssistance()
																										.equals(String
																												.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																												.getFarmAllotment()
																												.equals(String
																														.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																														.getFosterCarePayments()
										.equals(String
																																.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																.getGeneralAssistance()
																																.equals(String
																																		.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																		.getInterestDividendPayments()
																																		.equals(String
																																				.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																				.getiRADistribution()
																																				.equals(String
																																						.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																						.getLotteryWinnings()
																																						.equals(String
																																								.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																								.getLumpSum()
																																								.equals(String
																																										.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																										.getMilitaryAllotment()
																																										.equals(String
																																												.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																												.getMoneyFromAnotherPerson()
																																												.equals(String
																																														.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																														.getNetRentalRoyalty()
																																														.equals(String
																																																.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																.getOtherIncome()
																																																.equals(String
																																																		.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																		.getPaymentsFromAnnuity()
																																																		.equals(String
																																																				.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																				.getPaymentsMadeOnYourBehalf()
																																																				.equals(String
																																																						.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																						.getPensionOrRetirement()
																																																						.equals(String
																																																								.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																								.getRailroadRetirement()
										.equals(String
																																																										.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																										.getRefugeeCash()
																																																										.equals(String
																																																												.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																												.getRelativeCareSubsidy()
																																																												.equals(String
																																																														.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																														.getRentalIncome()
																																																														.equals(String
																																																																.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																.gettANFPayments()
																																																																.equals(String
																																																																		.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																		.getUnemploymentCompensation()
																																																																		.equals(String
																																																																				.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																				.getWorkStudyStateFederal()
																																																																				.equals(String
																																																																						.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																						.getWorkersCompensation()
																																																																						.equals(String
																																																																								.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																								.getIncome_from_resource()
																																																																								.equals(String
																																																																										.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																										.getIndian_gambling_payments()
																																																																										.equals(String
																																																																												.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																												.getInheritance_income()
										.equals(String
																																																																														.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																														.getInsuance_benefits()
																																																																														.equals(String
																																																																																.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																.getLoan_received()
																																																																																.equals(String
																																																																																		.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																		.getLoan_repayment_income()
																																																																																		.equals(String
																																																																																				.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																				.getManaged_income()
																																																																																				.equals(String
																																																																																						.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																						.getMatch_grant()
																																																																																						.equals(String
																																																																																								.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																								.getMontgomery_gi_bill()
										.equals(String
																																																																																										.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																										.getOut_of_state_public()
																																																																																										.equals(String
																																																																																												.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																												.getRefunds_from_dch()
																																																																																												.equals(String
																																																																																														.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																														.getRestitutions_settlements()
																																																																																														.equals(String
																																																																																																.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																.getSenior_companion()
																																																																																																.equals(String
																																																																																																		.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																		.getSeverance_pay()
																																																																																																		.equals(String
																																																																																																				.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																				.getStrike_benefits()
																																																																																																				.equals(String
																																																																																																						.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																						.getTrade_readjustment()
										.equals(String
																																																																																																								.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																								.getUniform_relocation()
										.equals(String
																																																																																																										.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																										.getUnion_funds()
																																																																																																										.equals(String
																																																																																																												.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																												.getVendor_excluded()
																																																																																																												.equals(String
																																																																																																														.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																														.getVictim_restitution()
										.equals(String
																																																																																																																.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																																.getVolunteer_payment()
																																																																																																																.equals(String
																																																																																																																		.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																																		.getVolunteer_payment_titlei()
																																																																																																																		.equals(String
																																																																																																																				.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																																				.getWia_training_and_allowance()
																																																																																																																				.equals(String
																																																																																																																						.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																																						.getIncluded_unearned_income()
																																																																																																																						.equals(String
																																																																																																																								.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																																								.getTanf_max_au_allotment()
																																																																																																																								.equals(String
																																																																																																																										.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																																										.getTanf_max_grg_allotment()
																																																																																																																										.equals(String
																																																																																																																												.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																																												.getCharitable_donation()
																																																																																																																												.equals(String
																																																																																																																														.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																																														.getChild_nutrition_payments()
																																																																																																																														.equals(String
																																																																																																																																.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																																																.getBlack_lung_benefits()
																																																																																																																																.equals(String
																																																																																																																																		.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																																																		.getChild_support_court()
																																																																																																																																		.equals(String
																																																																																																																																				.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																																																				.getChild_support_gap_payment()
																																																																																																																																				.equals(String
																																																																																																																																						.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																																																						.getCivil_service()
																																																																																																																																						.equals(String
																																																																																																																																								.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																																																								.getDeferred_compensation_plans()
																																																																																																																																								.equals(String
																																																																																																																																										.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																																																										.getDisability_insurance()
																																																																																																																																										.equals(String
																																																																																																																																												.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																																																												.getExcluded_unearned_income()
																																																																																																																																												.equals(String
																																																																																																																																														.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																																																														.getFema_payment_disaster()
																																																																																																																																														.equals(String
																																																																																																																																																.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																																																																.getFema_payment_non_disaster()
																																																																																																																																																.equals(String
																																																																																																																																																		.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																																																																		.getHealth_savings_account()
																																																																																																																																																		.equals(String
																																																																																																																																																				.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																																																																				.getIn_kind_support()
																																																																																																																																																				.equals(String
																																																																																																																																																						.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																																																																						.getFoster_grandparent_program()
																																																																																																																																																						.equals(String
																																																																																																																																																								.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																																																																								.getDisaster_unemployment()
																																																																																																																																																								.equals(String
																																																																																																																																																										.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																																																																										.getDividends()
																																																																																																																																																										.equals(String
																																																																																																																																																												.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																																																																												.getCharitable_donation_federal()
																																																																																																																																																												.equals(String
																																																																																																																																																														.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																																																																														.getDeath_benefit_state_federal()
																																																																																																																																																														.equals(String
																																																																																																																																																																.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																																																																																.getSocial_security_survivor()
																																																																																																																																																																.equals(String
																																																																																																																																																																		.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))
								|| rmcInPrflBeforeCargo
																																																																																																																																																																		.getVendor_payments()
																																																																																																																																																																		.equals(String
																																																																																																																																																																				.valueOf(IRMCResponseProfileManager.STATUS_REQUIRED))) {
							persistArray.add(beforeIndvSeqNum);
							persistColl.add(rmcInPrflBeforeCargo);
						}
						// Clear the list
						reqResponse.clear();
						sesResponse.clear();
					}
					// end of outer if
				}
			}

			// persist the data
			final int persistArraySize = persistArray.size();
			boolean detailsPageRequired = false;
			for (int i = 0; i < persistArraySize; i++) {

				final RMC_IN_PRFL_Cargo cargo = persistColl.getCargo(i);
				final String[] fieldValues = {

						cargo.getAdoptAssistance(), cargo.getAdoptionPayments(),
						cargo.getAgentOrangePayments(), cargo.getAlimony(),
						cargo.getCapitalGains(), cargo.getDeathBenefits(),
						cargo.getDisabilityIncome(), cargo.getDisasterRelief(),
						cargo.getEducationalAssistance(),
						cargo.getEnergyAssistance(), cargo.getFarmAllotment(),
						cargo.getFosterCarePayments(),
						cargo.getGeneralAssistance(),
						cargo.getInterestDividendPayments(),
						cargo.getiRADistribution(), cargo.getLotteryWinnings(),
						cargo.getLumpSum(), cargo.getMilitaryAllotment(),
						cargo.getMoneyFromAnotherPerson(),
						cargo.getNetRentalRoyalty(), cargo.getOtherIncome(),
						cargo.getPaymentsFromAnnuity(),
						cargo.getPaymentsMadeOnYourBehalf(),
						cargo.getPensionOrRetirement(),
						cargo.getRailroadRetirement(), cargo.getRefugeeCash(),
						cargo.getRelativeCareSubsidy(),
						cargo.getRentalIncome(), cargo.gettANFPayments(),
						cargo.getUnemploymentCompensation(),
						cargo.getWorkStudyStateFederal(),
						cargo.getWorkersCompensation(),
						cargo.getIncome_from_resource(),
						cargo.getIndian_gambling_payments(),
						cargo.getInheritance_income(),
						cargo.getInsuance_benefits(), cargo.getLoan_received(),
						cargo.getLoan_repayment_income(),
						cargo.getManaged_income(), cargo.getMatch_grant(),
						cargo.getMontgomery_gi_bill(),
						cargo.getOut_of_state_public(),
						cargo.getRefunds_from_dch(),
						cargo.getRestitutions_settlements(),
						cargo.getSenior_companion(), cargo.getSeverance_pay(),
						cargo.getStrike_benefits(),
						cargo.getTrade_readjustment(),
						cargo.getUniform_relocation(), cargo.getUnion_funds(),
						cargo.getVendor_excluded(),
						cargo.getVictim_restitution(),
						cargo.getVolunteer_payment(),
						cargo.getVolunteer_payment_titlei(),
						cargo.getWia_training_and_allowance(),
						cargo.getIncluded_unearned_income(),
						cargo.getTanf_max_au_allotment(),
						cargo.getTanf_max_grg_allotment(),
						cargo.getCharitable_donation(),
						cargo.getChild_nutrition_payments(),
						cargo.getBlack_lung_benefits(),
						cargo.getChild_support_court(),
						cargo.getChild_support_gap_payment(),
						cargo.getCivil_service(),
						cargo.getDeferred_compensation_plans(),
						cargo.getDisability_insurance(),
						cargo.getExcluded_unearned_income(),
						cargo.getFema_payment_disaster(),
						cargo.getFema_payment_non_disaster(),
						cargo.getHealth_savings_account(),
						cargo.getIn_kind_support(),
						cargo.getFoster_grandparent_program(),
						cargo.getDisaster_unemployment(), cargo.getDividends(),
						cargo.getCharitable_donation_federal(),
						cargo.getDeath_benefit_state_federal(),
						cargo.getSocial_security_survivor(),
						cargo.getVendor_payments()

				};

				rmcResponseProfileManager.persist(appNum,
						cargo.getIndv_seq_num(), fieldName, fieldValues);
				
				if(AppConstants.REQUIRED.equals(cargo.getAdoptAssistance()) ||
						 AppConstants.REQUIRED.equals(cargo.getAdoptionPayments())
						|| AppConstants.REQUIRED.equals(cargo.getAgentOrangePayments())
						|| AppConstants.REQUIRED.equals(cargo.getAlimony())
						|| AppConstants.REQUIRED.equals(cargo.getCapitalGains())
						|| AppConstants.REQUIRED.equals(cargo.getDeathBenefits())
						|| AppConstants.REQUIRED.equals(cargo.getDisabilityIncome())
						|| AppConstants.REQUIRED.equals(cargo.getDisasterRelief())
						|| AppConstants.REQUIRED.equals(cargo.getEducationalAssistance())	
						|| AppConstants.REQUIRED.equals(cargo.getEnergyAssistance())
						|| AppConstants.REQUIRED.equals(cargo.getFarmAllotment())
						|| AppConstants.REQUIRED.equals(cargo.getFosterCarePayments())
						|| AppConstants.REQUIRED.equals(cargo.getGeneralAssistance())
						|| AppConstants.REQUIRED.equals(cargo.getInterestDividendPayments())
						|| AppConstants.REQUIRED.equals(cargo.getiRADistribution())
						|| AppConstants.REQUIRED.equals(cargo.getLotteryWinnings())
						|| AppConstants.REQUIRED.equals(cargo.getLumpSum())
						|| AppConstants.REQUIRED.equals(cargo.getMilitaryAllotment())
						|| AppConstants.REQUIRED.equals(cargo.getMoneyFromAnotherPerson())
						|| AppConstants.REQUIRED.equals(cargo.getNetRentalRoyalty())
						|| AppConstants.REQUIRED.equals(cargo.getOtherIncome())
						|| AppConstants.REQUIRED.equals(cargo.getPaymentsFromAnnuity())
						|| AppConstants.REQUIRED.equals(cargo.getPaymentsMadeOnYourBehalf())
						|| AppConstants.REQUIRED.equals(cargo.getPensionOrRetirement())
						|| AppConstants.REQUIRED.equals(cargo.getRailroadRetirement())
						|| AppConstants.REQUIRED.equals(cargo.getRefugeeCash())
						|| AppConstants.REQUIRED.equals(cargo.getRelativeCareSubsidy())
						|| AppConstants.REQUIRED.equals(cargo.getRentalIncome())
						|| AppConstants.REQUIRED.equals(cargo.gettANFPayments())
						|| AppConstants.REQUIRED.equals(cargo.getUnemploymentCompensation())
						|| AppConstants.REQUIRED.equals(cargo.getWorkStudyStateFederal())
						|| AppConstants.REQUIRED.equals(cargo.getWorkersCompensation())
						|| AppConstants.REQUIRED.equals(cargo.getIncome_from_resource())
						|| AppConstants.REQUIRED.equals(cargo.getIndian_gambling_payments())
						|| AppConstants.REQUIRED.equals(cargo.getInheritance_income())
						|| AppConstants.REQUIRED.equals(cargo.getInsuance_benefits())
						|| AppConstants.REQUIRED.equals(cargo.getLoan_received())
						|| AppConstants.REQUIRED.equals(cargo
								.getLoan_repayment_income())
						|| AppConstants.REQUIRED.equals(cargo
								.getManaged_income())
						|| AppConstants.REQUIRED.equals(cargo.getMatch_grant())
						|| AppConstants.REQUIRED.equals(cargo
								.getMontgomery_gi_bill())
						|| AppConstants.REQUIRED.equals(cargo
								.getOut_of_state_public())
						|| AppConstants.REQUIRED.equals(cargo
								.getRefunds_from_dch())
						|| AppConstants.REQUIRED.equals(cargo
								.getRestitutions_settlements())
						|| AppConstants.REQUIRED.equals(cargo
								.getSenior_companion())
						|| AppConstants.REQUIRED
						.equals(cargo.getSeverance_pay())
						|| AppConstants.REQUIRED.equals(cargo
								.getStrike_benefits())
						|| AppConstants.REQUIRED.equals(cargo
								.getTrade_readjustment())
						|| AppConstants.REQUIRED.equals(cargo
								.getUniform_relocation())
						|| AppConstants.REQUIRED.equals(cargo.getUnion_funds())
						|| AppConstants.REQUIRED.equals(cargo
								.getVendor_excluded())
						|| AppConstants.REQUIRED.equals(cargo
								.getVictim_restitution())
						|| AppConstants.REQUIRED.equals(cargo
								.getVolunteer_payment())
						|| AppConstants.REQUIRED.equals(cargo
								.getVolunteer_payment_titlei())
						|| AppConstants.REQUIRED.equals(cargo
								.getWia_training_and_allowance())
						|| AppConstants.REQUIRED.equals(cargo
								.getIncluded_unearned_income())
						|| AppConstants.REQUIRED.equals(cargo
								.getTanf_max_au_allotment())
						|| AppConstants.REQUIRED.equals(cargo
								.getTanf_max_grg_allotment())
						|| AppConstants.REQUIRED.equals(cargo
								.getCharitable_donation())
						|| AppConstants.REQUIRED.equals(cargo
								.getChild_nutrition_payments())
						|| AppConstants.REQUIRED.equals(cargo
								.getBlack_lung_benefits())
						|| AppConstants.REQUIRED.equals(cargo
								.getChild_support_court())
						|| AppConstants.REQUIRED.equals(cargo
								.getChild_support_gap_payment())
						|| AppConstants.REQUIRED
						.equals(cargo.getCivil_service())
						|| AppConstants.REQUIRED.equals(cargo
								.getDeferred_compensation_plans())
						|| AppConstants.REQUIRED.equals(cargo
								.getDisability_insurance())
						|| AppConstants.REQUIRED.equals(cargo
								.getExcluded_unearned_income())
						|| AppConstants.REQUIRED.equals(cargo
								.getFema_payment_disaster())
						|| AppConstants.REQUIRED.equals(cargo
								.getFema_payment_non_disaster())
						|| AppConstants.REQUIRED.equals(cargo
								.getHealth_savings_account())
						|| AppConstants.REQUIRED.equals(cargo
								.getIn_kind_support())
						|| AppConstants.REQUIRED.equals(cargo
								.getFoster_grandparent_program())
						|| AppConstants.REQUIRED.equals(cargo
								.getDisaster_unemployment())
						|| AppConstants.REQUIRED.equals(cargo.getDividends())
						|| AppConstants.REQUIRED.equals(cargo
								.getCharitable_donation_federal())
						|| AppConstants.REQUIRED.equals(cargo
								.getDeath_benefit_state_federal())
						|| AppConstants.REQUIRED.equals(cargo
								.getSocial_security_survivor())
						|| AppConstants.REQUIRED.equals(cargo
								.getVendor_payments())) {
					detailsPageRequired = true;
				}
				
			}
			if (persistFlag == true) {
				// Run Dirty Logic on Driver
				rmcResponseProfileManager.runDirtyLogicOnDriver(appNum,
						dirtyStatus[0], "ARUID", driverArray);
			}

			final Map catTypes = new HashMap();
			catTypes.put("AS", "AS");
			catTypes.put("AP", "AP");
			catTypes.put("AO", "AO");
			catTypes.put("AL", "AL");
			catTypes.put("CG", "CG");
			catTypes.put("DB", "DB");
			catTypes.put("DM", "DM");
			catTypes.put("DR", "DR");
			catTypes.put("ED", "ED");
			catTypes.put("EA", "EA");
			catTypes.put("FA", "FA");
			catTypes.put("FP", "FP");
			catTypes.put("GA", "GA");
			catTypes.put("IP", "IP");
			catTypes.put("ID", "ID");
			catTypes.put("LW", "LW");
			catTypes.put("LS", "LS");
			catTypes.put("MI", "MI");
			catTypes.put("MF", "MF");
			catTypes.put("NR", "NR");
			catTypes.put("OO", "OO");
			catTypes.put("PF", "PF");
			catTypes.put("PB", "PB");
			catTypes.put("PN", "PN");
			catTypes.put("RT", "RT");
			catTypes.put("RC", "RC");
			catTypes.put("RS", "RS");
			catTypes.put("RI", "RI");
			catTypes.put("TN", "TN");
			catTypes.put("UC", "UC");
			catTypes.put("WS", "WS");
			catTypes.put("WO", "WO");
			catTypes.put("IFS", "IFS");
			catTypes.put("IGPI", "IGPI");
			catTypes.put("INH", "INH");
			catTypes.put("IBLI", "IBLI");
			catTypes.put("LR", "LR");
			catTypes.put("LRI", "LRI");
			catTypes.put("MII", "MII");
			catTypes.put("MGRA", "MGRA");
			catTypes.put("MGBP", "MGBP");
			catTypes.put("OSPA", "OSPA");
			catTypes.put("RDCH", "RDCH");
			catTypes.put("RSE", "RSE");
			catTypes.put("SCP", "SCP");
			catTypes.put("SEV", "SEV");
			catTypes.put("SBT", "SBT");
			catTypes.put("TRA", "TRA");
			catTypes.put("URAR", "URAR");
			catTypes.put("UF", "UF");
			catTypes.put("V1", "V1");
			catTypes.put("V3", "V3");
			catTypes.put("VLP", "VLP");
			catTypes.put("VLPT", "VLPT");
			catTypes.put("WIAT", "WIAT");
			catTypes.put("IUI", "IUI");
			catTypes.put("3TMA", "3TMA");
			catTypes.put("3TGA", "3TGA");
			catTypes.put("D1", "D1");
			catTypes.put("CNP", "CNP");
			catTypes.put("BLB", "BLB");
			catTypes.put("CSCO", "CSCO");
			catTypes.put("CSGP", "CSGP");
			catTypes.put("CSEB", "CSEB");
			catTypes.put("DCP", "DCP");
			catTypes.put("DIN", "DIN");
			catTypes.put("EUI", "EUI");
			catTypes.put("FDE", "FDE");
			catTypes.put("FNDE", "FNDE");
			catTypes.put("HAS", "HAS");
			catTypes.put("IKS", "IKS");
			catTypes.put("FGPP", "FGPP");
			catTypes.put("DIS", "DIS");
			catTypes.put("DIV", "DIV");
			catTypes.put("DFS", "DFS");
			catTypes.put("DBSF", "DBSF");
			catTypes.put("SSR", "SSR");
			catTypes.put("V2", "V2");

			/*String uipDetailPageStat = null;
			final short[] responseType = new short[] {
					IRMCResponseProfileManager.UEI_ADOPTION_ASSIST,
					IRMCResponseProfileManager.UEI_ADOPTION_PYMT,
					IRMCResponseProfileManager.UEI_AGENT_ORNG_PYMT,
					IRMCResponseProfileManager.UEI_ALIMONY,
					IRMCResponseProfileManager.UEI_CAPITAL_GAINS,
					IRMCResponseProfileManager.UEI_DEATH_BNFT,
					IRMCResponseProfileManager.UEI_DABL_INCM,
					IRMCResponseProfileManager.UEI_DR_RELIEF,
					IRMCResponseProfileManager.UEI_EDU_ASSIST,
					IRMCResponseProfileManager.UEI_ENERGY_ASSIST,
					IRMCResponseProfileManager.UEI_FRM_ALOT,
					IRMCResponseProfileManager.UEI_FOSTER_CARE_PYMT,
					IRMCResponseProfileManager.UEI_GEN_ASSIST,
					IRMCResponseProfileManager.UEI_INT_DIV_PYMT,
					IRMCResponseProfileManager.UEI_IRA_DIST,
					IRMCResponseProfileManager.UEI_LOTTERY_WIN,
					IRMCResponseProfileManager.UEI_LUMP_SUM,
					IRMCResponseProfileManager.UEI_MIL_ALOT,
					IRMCResponseProfileManager.UEI_MON_FRO_OTH,
					IRMCResponseProfileManager.UEI_NET_RENT_ROYALTY,
					IRMCResponseProfileManager.UEI_OTH,
					IRMCResponseProfileManager.UEI_ANNY_PYMT,
					IRMCResponseProfileManager.UEI_PYMT_BO,
					IRMCResponseProfileManager.UEI_PENSION,
					IRMCResponseProfileManager.UEI_RR_RETIRE,
					IRMCResponseProfileManager.UEI_REFUGEE_CASH,
					IRMCResponseProfileManager.UEI_REL_CARE,
					IRMCResponseProfileManager.UEI_RENTAL_INCM,
					IRMCResponseProfileManager.UEI_TANF_PYMT,
					IRMCResponseProfileManager.UEI_UNEMPL,
					IRMCResponseProfileManager.UEI_WORKER_STUDY,
					IRMCResponseProfileManager.UEI_WORKER_COMP,
					IRMCResponseProfileManager.BNFT_CHL_SPRT_RESP,
					IRMCResponseProfileManager.CHILD_SUPPORT_PAYMENT,
					IRMCResponseProfileManager.RECEIVE_SSI,
					IRMCResponseProfileManager.RECEIVE_SOCIAL_SECURITY,
					IRMCResponseProfileManager.BENEFIT_VETERAN,
					IRMCResponseProfileManager.OTHR_INCM_CONTRIB_RESP,
					IRMCResponseProfileManager.ADOPTION_ASSISTANCE,
					IRMCResponseProfileManager.OTHER_INCOME,
					IRMCResponseProfileManager.INCOME_FROM_RESOURCE,
					IRMCResponseProfileManager.INDIAN_GAMBLING_PAYMENTS,
					IRMCResponseProfileManager.INHERITANCE_INCOME,
					IRMCResponseProfileManager.INSUANCE_BENEFITS,
					IRMCResponseProfileManager.LOAN_RECEIVED,
					IRMCResponseProfileManager.LOAN_REPAYMENT_INCOME,
					IRMCResponseProfileManager.MANAGED_INCOME,
					IRMCResponseProfileManager.MATCH_GRANT,
					IRMCResponseProfileManager.MONTGOMERY_GI_BILL,
					IRMCResponseProfileManager.OUT_OF_STATE_PUBLIC,
					IRMCResponseProfileManager.REFUNDS_FROM_DCH,
					IRMCResponseProfileManager.RESTITUTIONS_SETTLEMENTS,
					IRMCResponseProfileManager.SENIOR_COMPANION,
					IRMCResponseProfileManager.SEVERANCE_PAY,
					IRMCResponseProfileManager.STRIKE_BENEFITS,
					IRMCResponseProfileManager.TRADE_READJUSTMENT,
					IRMCResponseProfileManager.UNIFORM_RELOCATION,
					IRMCResponseProfileManager.UNION_FUNDS,
					IRMCResponseProfileManager.VENDOR_EXCLUDED,
					IRMCResponseProfileManager.VICTIM_RESTITUTION,
					IRMCResponseProfileManager.VOLUNTEER_PAYMENT,
					IRMCResponseProfileManager.VOLUNTEER_PAYMENT_TITLEI,
					IRMCResponseProfileManager.WIA_TRAINING_AND_ALLOWANCE,
					IRMCResponseProfileManager.INCLUDED_UNEARNED_INCOME,
					IRMCResponseProfileManager.TANF_MAX_AU_ALLOTMENT,
					IRMCResponseProfileManager.TANF_MAX_GRG_ALLOTMENT,
					IRMCResponseProfileManager.CHARITABLE_DONATION,
					IRMCResponseProfileManager.CHILD_NUTRITION_PAYMENTS,
					IRMCResponseProfileManager.BLACK_LUNG_BENEFITS,
					IRMCResponseProfileManager.CHILD_SUPPORT_COURT,
					IRMCResponseProfileManager.CHILD_SUPPORT_GAP_PAYMENT,
					IRMCResponseProfileManager.CIVIL_SERVICE,
					IRMCResponseProfileManager.DEFERRED_COMPENSATION_PLANS,
					IRMCResponseProfileManager.DISABILITY_INSURANCE,
					IRMCResponseProfileManager.EXCLUDED_UNEARNED_INCOME,
					IRMCResponseProfileManager.FEMA_PAYMENT_DISASTER,
					IRMCResponseProfileManager.FEMA_PAYMENT_NON_DISASTER,
					IRMCResponseProfileManager.HEALTH_SAVINGS_ACCOUNT,
					IRMCResponseProfileManager.IN_KIND_SUPPORT,
					IRMCResponseProfileManager.FOSTER_GRANDPARENT_PROGRAM,
					IRMCResponseProfileManager.DISASTER_UNEMPLOYMENT,
					IRMCResponseProfileManager.DIVIDENDS,
					IRMCResponseProfileManager.CHARITABLE_DONATION_FEDERAL,
					IRMCResponseProfileManager.DEATH_BENEFIT_STATE_FEDERAL,
					IRMCResponseProfileManager.SOCIAL_SECURITY_SURVIVOR,
					IRMCResponseProfileManager.VENDOR_PAYMENTS

			};*/

			/*boolean detailsPageRequired = false;
			for (int i = 0; i < pageColl.size(); i++) {
				final RMC_IN_PRFL_Cargo pageCargo = pageColl.getCargo(i);
				if (pageCargo.getAdoptAssistance() != null
						&& AppConstants.YES.equals(pageCargo
								.getAdoptAssistance())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getAdoptionPayments() != null
						&& AppConstants.YES.equals(pageCargo
								.getAdoptionPayments())) {
					detailsPageRequired = true;
					break;
				}

				if (pageCargo.getAgentOrangePayments() != null
						&& AppConstants.YES.equals(pageCargo
								.getAgentOrangePayments())) {
					detailsPageRequired = true;
					break;
				}

				if (pageCargo.getAlimony() != null
						&& AppConstants.YES.equals(pageCargo.getAlimony())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getCapitalGains() != null
						&& AppConstants.YES.equals(pageCargo.getCapitalGains())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getDeathBenefits() != null
						&& AppConstants.YES
						.equals(pageCargo.getDeathBenefits())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getDisabilityIncome() != null
						&& AppConstants.YES.equals(pageCargo
								.getDisabilityIncome())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getDisasterRelief() != null
						&& AppConstants.YES.equals(pageCargo
								.getDisasterRelief())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getEducationalAssistance() != null
						&& AppConstants.YES.equals(pageCargo
								.getEducationalAssistance())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getEnergyAssistance() != null
						&& AppConstants.YES.equals(pageCargo
								.getEnergyAssistance())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getFarmAllotment() != null
						&& AppConstants.YES
						.equals(pageCargo.getFarmAllotment())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getFosterCarePayments() != null
						&& AppConstants.YES.equals(pageCargo
								.getFosterCarePayments())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getGeneralAssistance() != null
						&& AppConstants.YES.equals(pageCargo
								.getGeneralAssistance())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getInterestDividendPayments() != null
						&& AppConstants.YES.equals(pageCargo
								.getInterestDividendPayments())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getiRADistribution() != null
						&& AppConstants.YES.equals(pageCargo
								.getiRADistribution())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getLotteryWinnings() != null
						&& AppConstants.YES.equals(pageCargo
								.getLotteryWinnings())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getLumpSum() != null
						&& AppConstants.YES.equals(pageCargo.getLumpSum())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getMilitaryAllotment() != null
						&& AppConstants.YES.equals(pageCargo
								.getMilitaryAllotment())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getMoneyFromAnotherPerson() != null
						&& AppConstants.YES.equals(pageCargo
								.getMoneyFromAnotherPerson())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getNetRentalRoyalty() != null
						&& AppConstants.YES.equals(pageCargo
								.getNetRentalRoyalty())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getOtherIncome() != null
						&& AppConstants.YES.equals(pageCargo.getOtherIncome())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getPaymentsFromAnnuity() != null
						&& AppConstants.YES.equals(pageCargo
								.getPaymentsFromAnnuity())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getPaymentsMadeOnYourBehalf() != null
						&& AppConstants.YES.equals(pageCargo
								.getPaymentsMadeOnYourBehalf())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getPensionOrRetirement() != null
						&& AppConstants.YES.equals(pageCargo
								.getPensionOrRetirement())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getRailroadRetirement() != null
						&& AppConstants.YES.equals(pageCargo
								.getRailroadRetirement())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getRefugeeCash() != null
						&& AppConstants.YES.equals(pageCargo.getRefugeeCash())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getRelativeCareSubsidy() != null
						&& AppConstants.YES.equals(pageCargo
								.getRelativeCareSubsidy())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getRentalIncome() != null
						&& AppConstants.YES.equals(pageCargo.getRentalIncome())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.gettANFPayments() != null
						&& AppConstants.YES.equals(pageCargo.gettANFPayments())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getUnemploymentCompensation() != null
						&& AppConstants.YES.equals(pageCargo
								.getUnemploymentCompensation())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getWorkStudyStateFederal() != null
						&& AppConstants.YES.equals(pageCargo
								.getWorkStudyStateFederal())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getWorkersCompensation() != null
						&& AppConstants.YES.equals(pageCargo
								.getWorkersCompensation())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getIncome_from_resource() != null
						&& AppConstants.YES.equals(pageCargo
								.getIncome_from_resource())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getIndian_gambling_payments() != null
						&& AppConstants.YES.equals(pageCargo
								.getIndian_gambling_payments())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getInheritance_income() != null
						&& AppConstants.YES.equals(pageCargo
								.getInheritance_income())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getInsuance_benefits() != null
						&& AppConstants.YES.equals(pageCargo
								.getInsuance_benefits())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getLoan_received() != null
						&& AppConstants.YES
						.equals(pageCargo.getLoan_received())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getLoan_repayment_income() != null
						&& AppConstants.YES.equals(pageCargo
								.getLoan_repayment_income())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getManaged_income() != null
						&& AppConstants.YES.equals(pageCargo
								.getManaged_income())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getMatch_grant() != null
						&& AppConstants.YES.equals(pageCargo.getMatch_grant())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getMontgomery_gi_bill() != null
						&& AppConstants.YES.equals(pageCargo
								.getMontgomery_gi_bill())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getOut_of_state_public() != null
						&& AppConstants.YES.equals(pageCargo
								.getOut_of_state_public())) {
					detailsPageRequired = true;
					break;
				}

				if (pageCargo.getRefunds_from_dch() != null
						&& AppConstants.YES.equals(pageCargo
								.getRefunds_from_dch())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getRestitutions_settlements() != null
						&& AppConstants.YES.equals(pageCargo
								.getRestitutions_settlements())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getSenior_companion() != null
						&& AppConstants.YES.equals(pageCargo
								.getSenior_companion())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getSeverance_pay() != null
						&& AppConstants.YES
						.equals(pageCargo.getSeverance_pay())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getStrike_benefits() != null
						&& AppConstants.YES.equals(pageCargo
								.getStrike_benefits())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getTrade_readjustment() != null
						&& AppConstants.YES.equals(pageCargo
								.getTrade_readjustment())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getUniform_relocation() != null
						&& AppConstants.YES.equals(pageCargo
								.getUniform_relocation())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getUnion_funds() != null
						&& AppConstants.YES.equals(pageCargo.getUnion_funds())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getVendor_excluded() != null
						&& AppConstants.YES.equals(pageCargo
								.getVendor_excluded())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getVictim_restitution() != null
						&& AppConstants.YES.equals(pageCargo
								.getVictim_restitution())) {
					detailsPageRequired = true;
					break;
				}

				if (pageCargo.getVolunteer_payment() != null
						&& AppConstants.YES.equals(pageCargo
								.getVolunteer_payment())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getVolunteer_payment_titlei() != null
						&& AppConstants.YES.equals(pageCargo
								.getVolunteer_payment_titlei())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getWia_training_and_allowance() != null
						&& AppConstants.YES.equals(pageCargo
								.getWia_training_and_allowance())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getIncluded_unearned_income() != null
						&& AppConstants.YES.equals(pageCargo
								.getIncluded_unearned_income())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getTanf_max_au_allotment() != null
						&& AppConstants.YES.equals(pageCargo
								.getTanf_max_au_allotment())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getTanf_max_grg_allotment() != null
						&& AppConstants.YES.equals(pageCargo
								.getTanf_max_grg_allotment())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getCharitable_donation() != null
						&& AppConstants.YES.equals(pageCargo
								.getCharitable_donation())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getChild_nutrition_payments() != null
						&& AppConstants.YES.equals(pageCargo
								.getChild_nutrition_payments())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getBlack_lung_benefits() != null
						&& AppConstants.YES.equals(pageCargo
								.getBlack_lung_benefits())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getChild_support_court() != null
						&& AppConstants.YES.equals(pageCargo
								.getChild_support_court())) {
					detailsPageRequired = true;
					break;
				}

				if (pageCargo.getChild_support_gap_payment() != null
						&& AppConstants.YES.equals(pageCargo
								.getChild_support_gap_payment())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getCivil_service() != null
						&& AppConstants.YES
						.equals(pageCargo.getCivil_service())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getDeferred_compensation_plans() != null
						&& AppConstants.YES.equals(pageCargo
								.getDeferred_compensation_plans())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getDisability_insurance() != null
						&& AppConstants.YES.equals(pageCargo
								.getDisability_insurance())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getExcluded_unearned_income() != null
						&& AppConstants.YES.equals(pageCargo
								.getExcluded_unearned_income())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getFema_payment_disaster() != null
						&& AppConstants.YES.equals(pageCargo
								.getFema_payment_disaster())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getFema_payment_non_disaster() != null
						&& AppConstants.YES.equals(pageCargo
								.getFema_payment_non_disaster())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getHealth_savings_account() != null
						&& AppConstants.YES.equals(pageCargo
								.getHealth_savings_account())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getIn_kind_support() != null
						&& AppConstants.YES.equals(pageCargo
								.getIn_kind_support())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getFoster_grandparent_program() != null
						&& AppConstants.YES.equals(pageCargo
								.getFoster_grandparent_program())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getDisaster_unemployment() != null
						&& AppConstants.YES.equals(pageCargo
								.getDisaster_unemployment())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getDividends() != null
						&& AppConstants.YES.equals(pageCargo.getDividends())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getCharitable_donation_federal() != null
						&& AppConstants.YES.equals(pageCargo
								.getCharitable_donation_federal())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getDeath_benefit_state_federal() != null
						&& AppConstants.YES.equals(pageCargo
								.getDeath_benefit_state_federal())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getSocial_security_survivor() != null
						&& AppConstants.YES.equals(pageCargo
								.getSocial_security_survivor())) {
					detailsPageRequired = true;
					break;
				}
				if (pageCargo.getVendor_payments() != null
						&& AppConstants.YES.equals(pageCargo
								.getVendor_payments())) {
					detailsPageRequired = true;
					break;
				}
			}*/

/*			categorySelectionProfile = createPageProfile(
					categorySelectionProfile, combinedCollection, responseType);
			if (othIncomeBO.checkEmploymentPageRequired(
					categorySelectionProfile, catTypes) || detailsPageRequired) {
				if (detailsPageRequired
						|| !categorySelectionProfileManager
						.areAllSequencesComplete(
								categorySelectionProfile, catTypes)) {
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARUID",
							driverArray, appNum);
				} else {
					driverManager.makeComplete(FwConstants.RMC_DRIVER, "ARUID",
							driverArray, appNum);
				}
			} else {
				uipDetailPageStat = driverManager.getStatus(
						FwConstants.RMC_DRIVER, "ARUID", driverArray);
				if (!IDriver.DRIVER_STATUS_COMPLETE.equals(uipDetailPageStat)
						&& !IDriver.DRIVER_STATUS_REQUIRED
						.equals(uipDetailPageStat)
						|| categorySelectionProfile != null
						&& categorySelectionProfile.isEmpty()
						&& IDriver.DRIVER_STATUS_REQUIRED
						.equals(uipDetailPageStat)) {
					driverManager.makeNotRequired(FwConstants.RMC_DRIVER,
							"ARUID", driverArray, appNum);
				}
			}*/

			// Make Complete
			if (driverFlag) {
				driverManager.makeComplete(FwConstants.RMC_DRIVER, "ARUIT",
						driverArray, appNum);
			}
			
			categorySelectionProfile = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			if (detailsPageRequired) {
				rmcResponseProfileManager.runDirtyLogicOnDriver(appNum,
						dirtyStatus[0], "ARUID", driverArray);
				driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARUID",
						driverArray, appNum);
			} else if (othIncomeBO.checkEmploymentPageRequired(
					categorySelectionProfile, catTypes)) {

				final SortedSet selectionProfile = createPageProfile(
						categorySelectionProfile, rmcInPrflCollSession,
						fieldName);
				final String otherIncomeDetailPageStat = driverManager.getStatus(
						FwConstants.RMC_DRIVER, "ARUID", driverArray);
				if (!IDriver.DRIVER_STATUS_COMPLETE
						.equals(otherIncomeDetailPageStat)
						&& !IDriver.DRIVER_STATUS_REQUIRED
						.equals(otherIncomeDetailPageStat)
						|| selectionProfile != null
						&& selectionProfile.isEmpty()
						&& IDriver.DRIVER_STATUS_REQUIRED
						.equals(otherIncomeDetailPageStat)) {
					driverManager.makeAbsoluteNotRequired(
							FwConstants.RMC_DRIVER, "ARUID", driverArray,
							appNum);
				}
			} else if (driverManager.getAFBStatus(FwConstants.RMC_DRIVER,
					"ARUID", driverArray) == FwConstants.DRIVER_VISIT_AGAIN) {
				driverManager.makeComplete(FwConstants.RMC_DRIVER, "ARUID",
						driverArray, appNum);
			}

			if (!detailsPageRequired) {
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"ARUIT", driverArray, appNum);
				driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARUIS",
						driverArray, appNum);
			}
			
			
			
//			session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER,
//					categorySelectionProfile);
			/*session.put(AppConstants.RMC_IN_PRFL_MASTER, rmcInPrflCollSession);
			session.put(FwConstants.BEFORE_COLLECTION,
					txnBean.getPageCollection());
			session.put(FwConstants.RMC_DRIVER, driverArray);
			txnBean.setSession(session);*/

			log(ILog.INFO,
					"RMCOtherIncomeEJBBean::storeOtherIncomeSubTypeSelection:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("storeOtherIncomeSubTypeSelection");
			we.setFwException(fe);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"storeOtherIncomeSubTypeSelection", e);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.storeOtherIncomeSubTypeSelection() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

	/**
	 * Comment here.
	 *
	 * @param txnBean the txn bean
	 \* @throws javax.ejb.EJBException the EJB exception
	 */

	public void loadOtherIncomeDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherIncomeEJBBean.loadOtherIncomeDetails() - START");
		try {
			log(ILog.INFO,
					"RMCOtherIncomeEJBBean::loadOtherIncomeDetails:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			// you'll get the value for Seq
			APP_IN_UEI_Collection rmcInOthrIncColl;
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

			// build category selection profile
			SortedSet categorySelectionProfile = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);

			if (pageStatus == FwConstants.DRIVER_REQUIRED
					|| pageStatus == FwConstants.DRIVER_VISIT_AGAIN
					&& categorySelectionProfileManager.isEmpty(
							categorySelectionProfile, catTypes)) {
				categorySelectionProfile = categorySelectionProfileManager
						.loadCategoryChangeSelectionProfile(appNumber,
								AppConstants.RMC_CAT_OT_INC_PRFL);
			}

			RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			final String previousPageId = (String) request
					.get(FwConstants.PREVIOUS_PAGE_ID);
			final OtherIncomeBO otherIncomeBO = new OtherIncomeBO();

			final short[] responseType = new short[] {
					IRMCResponseProfileManager.RECEIVE_SOCIAL_SECURITY,
					IRMCResponseProfileManager.RECEIVE_SSI,
					IRMCResponseProfileManager.BENEFIT_VETERAN,
					IRMCResponseProfileManager.BNFT_CHL_SPRT_RESP,
					IRMCResponseProfileManager.CHILD_SUPPORT_PAYMENT,
					IRMCResponseProfileManager.OTHR_INCM_CONTRIB_RESP,
					IRMCResponseProfileManager.OTHR_INCM_TRBL_RESP,
					IRMCResponseProfileManager.OTH_IND_GAMBL_PMNTS,
					// IRMCResponseProfileManager.OTHER_INCOME,
					IRMCResponseProfileManager.UEI_ADOPTION_ASSIST,
					IRMCResponseProfileManager.UEI_ADOPTION_PYMT,
					IRMCResponseProfileManager.UEI_AGENT_ORNG_PYMT,
					IRMCResponseProfileManager.UEI_ALIMONY,
					IRMCResponseProfileManager.UEI_CAPITAL_GAINS,
					IRMCResponseProfileManager.UEI_DEATH_BNFT,
					IRMCResponseProfileManager.UEI_DABL_INCM,
					IRMCResponseProfileManager.UEI_DR_RELIEF,
					IRMCResponseProfileManager.UEI_EDU_ASSIST,
					IRMCResponseProfileManager.UEI_ENERGY_ASSIST,
					IRMCResponseProfileManager.UEI_FRM_ALOT,
					IRMCResponseProfileManager.UEI_FOSTER_CARE_PYMT,
					IRMCResponseProfileManager.UEI_GEN_ASSIST,
					IRMCResponseProfileManager.UEI_INT_DIV_PYMT,
					IRMCResponseProfileManager.UEI_IRA_DIST,
					IRMCResponseProfileManager.UEI_LOTTERY_WIN,
					IRMCResponseProfileManager.UEI_LUMP_SUM,
					IRMCResponseProfileManager.UEI_MIL_ALOT,
					IRMCResponseProfileManager.UEI_MON_FRO_OTH,
					IRMCResponseProfileManager.UEI_NET_RENT_ROYALTY,
					IRMCResponseProfileManager.UEI_OTH,
					IRMCResponseProfileManager.UEI_ANNY_PYMT,
					IRMCResponseProfileManager.UEI_PYMT_BO,
					IRMCResponseProfileManager.UEI_PENSION,
					IRMCResponseProfileManager.UEI_RR_RETIRE,
					IRMCResponseProfileManager.UEI_REFUGEE_CASH,
					IRMCResponseProfileManager.UEI_REL_CARE,
					IRMCResponseProfileManager.UEI_RENTAL_INCM,
					IRMCResponseProfileManager.UEI_TANF_PYMT,
					IRMCResponseProfileManager.UEI_UNEMPL,
					IRMCResponseProfileManager.UEI_WORKER_STUDY,
					IRMCResponseProfileManager.UEI_WORKER_COMP,
					IRMCResponseProfileManager.INCOME_FROM_RESOURCE,
					IRMCResponseProfileManager.INDIAN_GAMBLING_PAYMENTS,
					IRMCResponseProfileManager.INHERITANCE_INCOME,
					IRMCResponseProfileManager.INSUANCE_BENEFITS,
					IRMCResponseProfileManager.LOAN_RECEIVED,
					IRMCResponseProfileManager.LOAN_REPAYMENT_INCOME,
					IRMCResponseProfileManager.MANAGED_INCOME,
					IRMCResponseProfileManager.MATCH_GRANT,
					IRMCResponseProfileManager.MONTGOMERY_GI_BILL,
					IRMCResponseProfileManager.OUT_OF_STATE_PUBLIC,
					IRMCResponseProfileManager.REFUNDS_FROM_DCH,
					IRMCResponseProfileManager.RESTITUTIONS_SETTLEMENTS,
					IRMCResponseProfileManager.SENIOR_COMPANION,
					IRMCResponseProfileManager.SEVERANCE_PAY,
					IRMCResponseProfileManager.STRIKE_BENEFITS,
					IRMCResponseProfileManager.TRADE_READJUSTMENT,
					IRMCResponseProfileManager.UNIFORM_RELOCATION,
					IRMCResponseProfileManager.UNION_FUNDS,
					IRMCResponseProfileManager.VENDOR_EXCLUDED,
					IRMCResponseProfileManager.VICTIM_RESTITUTION,
					IRMCResponseProfileManager.VOLUNTEER_PAYMENT,
					IRMCResponseProfileManager.VOLUNTEER_PAYMENT_TITLEI,
					IRMCResponseProfileManager.WIA_TRAINING_AND_ALLOWANCE,
					IRMCResponseProfileManager.INCLUDED_UNEARNED_INCOME,
					IRMCResponseProfileManager.TANF_MAX_AU_ALLOTMENT,
					IRMCResponseProfileManager.TANF_MAX_GRG_ALLOTMENT,
					IRMCResponseProfileManager.CHARITABLE_DONATION,
					IRMCResponseProfileManager.CHILD_NUTRITION_PAYMENTS,
					IRMCResponseProfileManager.BLACK_LUNG_BENEFITS,
					IRMCResponseProfileManager.CHILD_SUPPORT_COURT,
					IRMCResponseProfileManager.CHILD_SUPPORT_GAP_PAYMENT,
					IRMCResponseProfileManager.CIVIL_SERVICE,
					IRMCResponseProfileManager.DEFERRED_COMPENSATION_PLANS,
					IRMCResponseProfileManager.DISABILITY_INSURANCE,
					IRMCResponseProfileManager.EXCLUDED_UNEARNED_INCOME,
					IRMCResponseProfileManager.FEMA_PAYMENT_DISASTER,
					IRMCResponseProfileManager.FEMA_PAYMENT_NON_DISASTER,
					IRMCResponseProfileManager.HEALTH_SAVINGS_ACCOUNT,
					IRMCResponseProfileManager.IN_KIND_SUPPORT,
					IRMCResponseProfileManager.FOSTER_GRANDPARENT_PROGRAM,
					IRMCResponseProfileManager.DISASTER_UNEMPLOYMENT,
					IRMCResponseProfileManager.DIVIDENDS,
					IRMCResponseProfileManager.CHARITABLE_DONATION_FEDERAL,
					IRMCResponseProfileManager.DEATH_BENEFIT_STATE_FEDERAL,
					IRMCResponseProfileManager.SOCIAL_SECURITY_SURVIVOR,
					IRMCResponseProfileManager.VENDOR_PAYMENTS };

			SortedSet otherIncomeProfile = null;
			boolean rnRecordFound = false;

			if (!pageId.equals(previousPageId)) {
				otherIncomeProfile = createOtherIncomePageProfile(
						categorySelectionProfile, rmcInPrflColl, responseType);
				if (pageStatus != FwConstants.DRIVER_REQUIRED) {
					final APP_IN_UEI_Collection newOtherIncColl = otherIncomeBO
							.loadOtherIncomeDetails(appNumber);
					if (newOtherIncColl != null && !newOtherIncColl.isEmpty()) {
						APP_IN_UEI_Cargo rmcInOtherIncCargo = null;
						final int newEmplCollSize = newOtherIncColl.size();
						rnRecordFound = true;
						for (int i = 0; i < newEmplCollSize; i++) {
							rmcInOtherIncCargo = newOtherIncColl.getCargo(i);
							categorySelectionProfileManager
							.insertExistingSequenceDetail(
									otherIncomeProfile, null, null,
									Short.parseShort(rmcInOtherIncCargo
											.getIndv_seq_num()),
											Long.parseLong(rmcInOtherIncCargo
													.getSeq_num()),
													rmcInOtherIncCargo.getUei_typ());
						}
					}
				}
				if (pageStatus == FwConstants.DRIVER_REQUIRED
						|| pageStatus == FwConstants.DRIVER_VISIT_AGAIN) {
					// set the current record indicator to the first one
					categorySelectionProfileManager
					.setCurrentRecordIndToFirst(otherIncomeProfile);
				}
				if (pageStatus == FwConstants.DRIVER_COMPLETE) {
					// set the current record indicator to the end of the detail
					// bean
					categorySelectionProfileManager
					.setCurrentRecordIndToLast(otherIncomeProfile);
				}

				// create add new sorted set
				// we need to remove the values from the session
				session.remove(FwConstants.BEFORE_COLLECTION);
			} else {
				// catAddNewProfile get it from the before collection
				final Map beforeColl = (Map) session
						.get(FwConstants.BEFORE_COLLECTION);
				otherIncomeProfile = (SortedSet) beforeColl
						.get(AppConstants.RMC_CATEGORY_PAGE_PRFL);
			}

			IndivTypeSeqBean indivSeqBean = (IndivTypeSeqBean) pageCollection
					.get(FwConstants.DETAIL_KEY_BEAN);
			if (indivSeqBean == null && "ARUIS".equals(previousPageId)) {
				indivSeqBean = (IndivTypeSeqBean) session
						.get(FwConstants.DETAIL_KEY_BEAN);
			}
			// Populating into session
			session.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

			// if details key bean not null means this bean is coming from the
			// summary page
			if (indivSeqBean != null) {
				final CategorySequenceDetail categorySeqDetail1 = categorySelectionProfileManager
						.getCategorySequenceDetail(
								otherIncomeProfile,
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
								otherIncomeProfile,
								appNumber,
								Short.parseShort(indivSeqBean
										.getIndivSeqNum()),
										Long.parseLong(indivSeqBean.getSeqNum()),
										indivSeqBean.getType(), Short
										.parseShort(userEndIndicator));

					}
					categorySelectionProfileManager.makeSequenceDetailRequired(
							otherIncomeProfile, null,
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
						final short[] responseArray = new short[] {
								IRMCResponseProfileManager.OTHER_INCOME,
								rmcResponseProfileManager.getResponseByType(
										IRMCResponseProfileManager.OTHER_INCOME_DETAILS,
										indivSeqBean.getType()) };
						// now we need to make required the employment
						rmcResponseProfileManager.makeAddNew(
								responseArray,
								rmcInPrflCargo, true);
						categorySelectionProfileManager
						.insertSequenceDetail(otherIncomeProfile, appNumber,
								AppConstants.RMC_CAT_OT_INC_PRFL, Short.parseShort(indivSeqBean
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
						.insertSequenceDetail(otherIncomeProfile, null,
								AppConstants.RMC_CAT_OT_INC_PRFL, Short
								.parseShort(indivSeqBean
										.getIndivSeqNum()),
										Short.parseShort(indivSeqBean
												.getSeqNum()), indivSeqBean
												.getType(), Short
												.parseShort(userEndInd));
						categorySelectionProfileManager
						.makeSequenceDetailRequired(otherIncomeProfile,
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
								AppConstants.RMC_CAT_OT_INC_PRFL, Short
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
				session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER,
						categorySelectionProfile);
			}

			pageCollection.put(AppConstants.RMC_CATEGORY_PAGE_PRFL,
					otherIncomeProfile);

			CategorySequenceDetail categorySeqDetail = categorySelectionProfileManager
					.getCurrentSequenceDetail(otherIncomeProfile);
			if (categorySeqDetail == null) {
				categorySeqDetail = categorySelectionProfileManager
						.getNextSequenceDetail(otherIncomeProfile);
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
			rmcInOthrIncColl = otherIncomeBO.loadOtherIncomeDetails(appNumber,
					indvSeqNum, categorySeqNum);
			if (rmcInOthrIncColl != null && !rmcInOthrIncColl.isEmpty()) {
				rmcInOthrIncColl.getCargo(0);
			}
			pageCollection.put("APP_IN_UEI_Collection", rmcInOthrIncColl);

			final OtherIncomeBO otherIncBO = new OtherIncomeBO();
			APP_IN_UEI_Cargo cwwOthrIncCargo = otherIncBO.splitOtherIncColl(
					rmcInOthrIncColl, AppConstants.CWW_RECORD_IND);
			if (cwwOthrIncCargo == null) {
				cwwOthrIncCargo = new APP_IN_UEI_Cargo();
			}
			pageCollection.put("SEC_EMPL",
					otherIncBO.settingDefaultValues(cwwOthrIncCargo));

			APP_IN_UEI_Cargo rmcEmplCargo = otherIncBO.splitOtherIncColl(
					rmcInOthrIncColl, AppConstants.RMC_NEW_RECORD_IND);
			if (rmcEmplCargo != null) {
				pageCollection.put("FST_EMPL",
						otherIncBO.settingDefaultValues(rmcEmplCargo));
			} else {
				rmcEmplCargo = otherIncBO.splitOtherIncColl(rmcInOthrIncColl,
						AppConstants.RMC_MODIFIED_RECORD_IND);
				if (rmcEmplCargo != null) {
					pageCollection.put("FST_EMPL",
							otherIncBO.settingDefaultValues(rmcEmplCargo));
				} else {
					rmcEmplCargo = otherIncBO.splitOtherIncColl(
							rmcInOthrIncColl, AppConstants.RMC_END_RECORD_IND);
					if (rmcEmplCargo != null) {
						pageCollection.put("FST_EMPL",
								otherIncBO.settingDefaultValues(rmcEmplCargo));
					} else {
						pageCollection.put("FST_EMPL", otherIncBO
								.settingDefaultValues(cwwOthrIncCargo));
					}
				}

			}

			if (rmcInOthrIncColl != null && !rmcInOthrIncColl.isEmpty()) {
				final APP_IN_UEI_Cargo appInSelfeCargo = rmcInOthrIncColl
						.getCargo(0);
				srcAppInd = appInSelfeCargo.getSrc_app_ind();
			}

			if (("CW".equalsIgnoreCase(srcAppInd) || "RM"
					.equalsIgnoreCase(srcAppInd))
					&& (categorySeqDetail!=null &&categorySeqDetail.getUserEndSelectionInd() == 0)) {
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
			} else if (!("C".equals(pageMode) || "E".equals(pageMode))) {
				pageMode = FwConstants.NO;
			}
			char typeStatus = 'N';
			String showLoopingQuestionFlag = FwConstants.YES;
			if(categorySeqDetail!=null) {
			typeStatus = categorySeqDetail.getStatus();
			}
			if (typeStatus == IRMCResponseProfileManager.STATUS_VISIT_AGAIN
					|| typeStatus == IRMCResponseProfileManager.STATUS_COMPLETE) {
				showLoopingQuestionFlag = FwConstants.NO;
			}

			pageCollection.put("showLoopingQuestion", showLoopingQuestionFlag);
			pageCollection.put("PAGE_MODE", pageMode);

			pageCollection.put("OTHER_INCOME_TYPE", categoryType);

			// set first name to page collection
			final PeopleHandler peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);
			pageCollection.put(AppConstants.FIRST_NAME,
					peopleHandler.getFirstName(indvSeqNum));

			// run component manager
			componentManager.getComponents("ARUID", txnBean);
			request.remove("loopingQuestion");
			// Add the page collection to before collection
			session.put(FwConstants.BEFORE_COLLECTION, pageCollection);

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("loadOtherIncomeDetails");
			we.setFwException(fe);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"loadOtherIncomeDetails", e);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.loadOtherIncomeDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

	/**
	 * Creates the and load response maps to page collection.
	 *
	 * @param rmcInPrflColl the rmc in prfl coll
	 * @param pageCollection the page collection
	 * @param peopleHandler the people handler
	 * @param pageLoad the page load
	 * @param driverStatus the driver status
	 * @return the map
	 */
	private Map createAndLoadResponseMapsToPageCollection(
			final RMC_IN_PRFL_Collection rmcInPrflColl,
			final Map pageCollection, final PeopleHandler peopleHandler,
			final boolean pageLoad, final int driverStatus) {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"OtherIncomeEJBBean.createAndLoadResponseMapsToPageCollection() - START");
		try {

			this.getPeopleCollectionAndUpdateMaps(rmcInPrflColl,
					pageCollection, peopleHandler, "255",
					IRMCResponseProfileManager.ROOM_AND_BOARD, pageLoad,
					driverStatus, true);
			// OTHR_INCM_TRBL_GA_RESP

			log(ILog.INFO,
					"OtherIncomeEJBBean.createAndLoadResponseMapsToPageCollection() - END , Time Taken : "
							+ (System.currentTimeMillis() - startTime)
							+ AppConstants.SPACE + AppConstants.MILLISECONDS);
			return pageCollection;
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("createAndLoadResponseMapsToPageCollection");
			we.setFwException(fe);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"createAndLoadResponseMapsToPageCollection", e);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
	}

	/**
	 * Creates the and load response maps to page collection after validation.
	 *
	 * @param rmcInPrflColl the rmc in prfl coll
	 * @param pageCollection the page collection
	 * @param peopleHandler the people handler
	 * @param pageLoad the page load
	 * @param driverStatus the driver status
	 * @return the map
	 */
	private Map createAndLoadResponseMapsToPageCollectionAfterValidation(
			final RMC_IN_PRFL_Collection rmcInPrflColl,
			final Map pageCollection, final PeopleHandler peopleHandler,
			final boolean pageLoad, final int driverStatus) {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"OtherIncomeEJBBean.createAndLoadResponseMapsToPageCollection() - START");
		try {

			getPeopleCollectionAndUpdateMapsAfterValidation(rmcInPrflColl,
					pageCollection, peopleHandler, "255",
					IRMCResponseProfileManager.ROOM_AND_BOARD, pageLoad,
					driverStatus, true);

			log(ILog.INFO,
					"OtherIncomeEJBBean.createAndLoadResponseMapsToPageCollection() - END , Time Taken : "
							+ (System.currentTimeMillis() - startTime)
							+ AppConstants.SPACE + AppConstants.MILLISECONDS);
			return pageCollection;
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("createAndLoadResponseMapsToPageCollection");
			we.setFwException(fe);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"createAndLoadResponseMapsToPageCollection", e);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
	}

	/**
	 * Comment here.
	 *
	 * @param txnBean the txn bean
	 \* @throws javax.ejb.EJBException the EJB exception
	 */
	public void storeOtherIncomeDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.storeOtherIncomeDetails() - START");
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

			final APP_IN_UEI_Collection rmcInOthrIncCollection = (APP_IN_UEI_Collection) pageCollection
					.get("APP_IN_UEI_Collection");
			APP_IN_UEI_Cargo rmcInothrIncCargo = rmcInOthrIncCollection
					.getCargo(0);
			final boolean amtEntered = false;
			final CategorySequenceDetail categorySeqDetailBean = categorySelectionProfileManager
					.getCurrentSequenceDetail(otherIncomeProfile);
			final short userEndInd = categorySeqDetailBean
					.getUserEndSelectionInd();
			final OtherIncomeBO otherIncomeBO = new OtherIncomeBO();
			final String backToMyAccess = (String) request
					.get(AppConstants.BACK_TO_MY_ACCESS_BUTTON);
			final String pageMode = (String) beforeColl.get("PAGE_MODE");

			String changeEffDate = null;
			final APP_IN_UEI_Collection beforeCollRmcInOthIncColl = (APP_IN_UEI_Collection) beforeColl
					.get("APP_IN_UEI_Collection");
			APP_IN_UEI_Cargo beforeOthrIncCargo = null;

			rmcInothrIncCargo.setApp_num(appNumber);
			// Start of VaCMS - Removal of Uei_beg_dt and Chg_eff_dt fields

			if (rmcInothrIncCargo.getUei_beg_dt() != null
					&& rmcInothrIncCargo.getUei_beg_dt().trim().length() != 0
					&& !AppConstants.HIGH_DATE.equals(rmcInothrIncCargo
							.getUei_beg_dt())) {
				if (rmcInothrIncCargo.getUei_beg_dt().length() == 10
						&& rmcInothrIncCargo.getUei_beg_dt().charAt(2) == '/') {
					rmcInothrIncCargo
					.setUei_beg_dt(displayFormatter
							.getYYYYMMDDDate(rmcInothrIncCargo
									.getUei_beg_dt()));
				}
			}

			// End of VaCMS - Removal of Uei_beg_dt and Chg_eff_dt fields

			if (rmcInothrIncCargo.getRsdi_income_expected_sw() == null) {
				rmcInothrIncCargo.setRsdi_income_expected_sw(FwConstants.SPACE);
			}

			if (rmcInothrIncCargo.getRec_cplt_ind() == null) {
				rmcInothrIncCargo.setRec_cplt_ind(FwConstants.ZERO);
			}

			// End of VaCMS - Removal of frequency field
			if (rmcInothrIncCargo.getExpected_to_cont_resp() == null) {
				rmcInothrIncCargo.setExpected_to_cont_resp(FwConstants.SPACE);
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

				beforeOthrIncCargo = otherIncomeBO.splitOtherIncColl(
						beforeCollRmcInOthIncColl, sourceAppIndicator);
				if (beforeOthrIncCargo == null
						&& (AppConstants.RMC_MODIFIED_RECORD_IND
								.equals(sourceAppIndicator) || AppConstants.RMC_END_RECORD_IND
								.equals(sourceAppIndicator))) {
					beforeOthrIncCargo = otherIncomeBO.splitOtherIncColl(
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
					rmcInothrIncCargo.setUei_typ(beforeOthrIncCargo
							.getUei_typ());
					rmcInothrIncCargo.setSeq_num(beforeOthrIncCargo
							.getSeq_num());
					rmcInothrIncCargo.setRec_cplt_ind(beforeOthrIncCargo
							.getRec_cplt_ind());
					if (rmcInothrIncCargo.getUei_amt() == null) {
						rmcInothrIncCargo.setUei_amt(beforeOthrIncCargo
								.getUei_amt());
					}

					if (rmcInothrIncCargo.getUei_Sub_Type() == null) {
						rmcInothrIncCargo.setUei_Sub_Type(beforeOthrIncCargo
								.getUei_Sub_Type());
					}
					if (rmcInothrIncCargo.getUei_claim_num() == null) {
						rmcInothrIncCargo.setUei_claim_num(beforeOthrIncCargo
								.getUei_claim_num());
					}
					if (rmcInothrIncCargo.getOthr_incm_src() == null) {
						rmcInothrIncCargo.setOthr_incm_src(beforeOthrIncCargo
								.getOthr_incm_src());
					}

					if (rmcInothrIncCargo.getFreq_cd() == null) {
						rmcInothrIncCargo.setFreq_cd(beforeOthrIncCargo
								.getFreq_cd());
					}

					rmcInothrIncCargo.setEcp_id(beforeOthrIncCargo.getEcp_id());

					// Start of VaCMS - Removal of frequency and Uei_beg_dt
					// fields

					// End of VaCMS - Removal of frequency and Uei_beg_dt fields

					// Start of VaCMS - Removal of Chg_eff_dt fields

					// End of VaCMS - Removal of frequency and Uei_beg_dt fields
				}

				if ("E".equalsIgnoreCase(pageMode)) {
					rmcInothrIncCargo.setUei_typ(beforeOthrIncCargo
							.getUei_typ());
					rmcInothrIncCargo.setUei_amt(beforeOthrIncCargo
							.getUei_amt());
					rmcInothrIncCargo.setUei_amt_ind(beforeOthrIncCargo
							.getUei_amt_ind());
					rmcInothrIncCargo.setUei_beg_dt(beforeOthrIncCargo
							.getUei_beg_dt());
					rmcInothrIncCargo.setEcp_id(beforeOthrIncCargo.getEcp_id());
					// Start of VaCMS - Removal of frequency field
					// End of VaCMS - Removal of frequency field
				}

				// Start of VaCMS - Removal of frequency field

				// End of VaCMS - Removal of frequency field
				if (rmcInothrIncCargo.getUei_amt() != null
						&& AppConstants.ON_FILE
						.equalsIgnoreCase(rmcInothrIncCargo
								.getUei_amt())) {
					rmcInothrIncCargo.setUei_amt(beforeOthrIncCargo
							.getUei_amt());
					if (modifiedFields.contains(rmcInothrIncCargo
							.getIndv_seq_num()
							+ "_"
							+ rmcInothrIncCargo.getSeq_num() + "_" + "uei_amt")) {
						modifiedFields.remove(rmcInothrIncCargo
								.getIndv_seq_num()
								+ "_"
								+ rmcInothrIncCargo.getSeq_num()
								+ "_"
								+ "uei_amt");
					}
				} else {
					if (!modifiedFields.contains(rmcInothrIncCargo
							.getIndv_seq_num()
							+ "_"
							+ rmcInothrIncCargo.getSeq_num() + "_" + "uei_amt")) {
						modifiedFields.add(rmcInothrIncCargo.getIndv_seq_num()
								+ "_" + rmcInothrIncCargo.getSeq_num() + "_"
								+ "uei_amt");
					}
				}
				// check dirty
				rmcInothrIncCargo = (APP_IN_UEI_Cargo) isChanged(
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

				// Start of VaCMS - Removal of Chg_eff_dt field

				// End of VaCMS - Removal of Chg_eff_dt field

				if (changeEffDate == null) {
					changeEffDate = AppConstants.HIGH_DATE;
				}
				// Start of VaCMS - Removal of Chg_eff_dt field
				// End of VaCMS - Removal of Chg_eff_dt field
				rmcInothrIncCargo.setRec_cplt_ind(FwConstants.ONE);

			} else {
				// if there is no before collection means this is new record
				sourceAppIndicator = AppConstants.RMC_NEW_RECORD_IND;
				rmcInothrIncCargo
				.setIndv_seq_num(String.valueOf(categorySeqDetailBean
						.getIndividualSequence()));
				// get the MAX seq number from data base
				seqNum = otherIncomeBO.getMaxEmplSeqNumber(appNumber,
						indvSeqNum);
				seqNum = seqNum + 1;
				rmcInothrIncCargo.setSeq_num(String.valueOf(seqNum));
				rmcInothrIncCargo.setUei_typ(categorySeqDetailBean
						.getCategoryType());
				rmcInothrIncCargo.setSrc_app_ind(sourceAppIndicator);
				recordInd = FwConstants.ROWACTION_INSERT;
				rmcInothrIncCargo.setRowAction(recordInd);
				othrIncDetailsUpdate = true;
				// insert into RMC_SELECTION_PROFILE using Common Mehod()
				categorySelectionProfileManager.updateSequence(otherIncomeProfile, null, categorySeqDetailBean.getIndividualSequence(), seqNum, categorySeqDetailBean.getCategoryType());
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
				if ("C".equals(pageMode)) {
					otherIncomeBO.validateChangePageContents(
							rmcInothrIncCargo.getUei_amt(), rmcInothrIncCargo,
							userEndInd, amtEntered, peopleHandler,
							isLoopingQuestionShown, loopingAnswer);
				} else if ("E".equals(pageMode)) {
					otherIncomeBO.validatePageContents(
							rmcInothrIncCargo.getUei_amt(), rmcInothrIncCargo,
							userEndInd, amtEntered);
				} else {
					otherIncomeBO.validateNewPageContents(
							rmcInothrIncCargo.getUei_amt(), rmcInothrIncCargo,
							userEndInd, amtEntered, peopleHandler,
							isLoopingQuestionShown, loopingAnswer);
				}
			}

			if (checkBackToMyAccessSelected(request)
					|| otherIncomeBO.hasMessages()) {
				if (backToMyAccess == null) {
					request.put(FwConstants.MESSAGE_LIST,
							otherIncomeBO.getMessageList());
				}
				pageCollection.put("OTHER_INCOME_TYPE",
						beforeColl.get("OTHER_INCOME_TYPE"));
				pageCollection.put("APP_IN_UEI_Collection",
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
				if (beforeColl.containsKey("SEC_EMPL")) {
					pageCollection.put("SEC_EMPL", beforeColl.get("SEC_EMPL"));
				}
				pageCollection.put("FST_EMPL", rmcInothrIncCargo);
				return;
			}
			if (rmcInothrIncCargo.getUei_amt_ind() == null
					|| rmcInothrIncCargo.getUei_amt_ind().trim().length() == 0) {
				if (rmcInothrIncCargo.getUei_amt() == null
						|| rmcInothrIncCargo.getUei_amt().trim().length() == 0) {
					rmcInothrIncCargo.setUei_amt("0.00");
					rmcInothrIncCargo.setUei_amt_ind("2");
				} else {
					rmcInothrIncCargo.setUei_amt_ind(FwConstants.ZERO);
				}
			} else {
				if (rmcInothrIncCargo.getUei_amt() == null
						|| rmcInothrIncCargo.getUei_amt().trim().length() == 0) {
					rmcInothrIncCargo.setUei_amt("0.00");
				} else {
					pageCollection.put("AmtAndIndChecked", FwConstants.ONE);
				}
			}

			if (othrIncDetailsUpdate) {
				if (FwConstants.ROWACTION_INSERT.equals(rmcInothrIncCargo
						.getRowAction())) {
					if ("E".equalsIgnoreCase(pageMode)) {
						if (FwConstants.ZERO.equals(rmcInothrIncCargo
								.getUei_amt_ind())) {
							rmcInothrIncCargo.setUei_amt_ind(FwConstants.ONE);
						}
					}

					otherIncomeBO.insertExistingDetails(rmcInOthrIncCollection);
				} else {
					otherIncomeBO
					.storeOtherIncomeDetails(rmcInOthrIncCollection);
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
				driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARUIS",
						driverArray, appNumber);
			}
			//reqInd is indicator to decide if we have complete the response profile or not
			boolean reqInd=false;
			if (!loopingQuestion) {
				short respTyp=rmcResponseProfileManager
				.getResponseByType(
						IRMCResponseProfileManager.OTHER_INCOME_DETAILS,
						categorySeqDetailBean
						.getCategoryType());
				final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
						.get(AppConstants.RMC_IN_PRFL_MASTER);
				final RMC_IN_PRFL_Cargo rmcInPrflCargo = rmcResponseProfileManager
						.getProfile(rmcInPrflColl, String
								.valueOf(categorySeqDetailBean
										.getIndividualSequence()));
				if (rmcInPrflCargo != null && (rmcResponseProfileManager.getProfileResponse(
						rmcInPrflCargo, respTyp).charAt(0) == IRMCResponseProfileManager.STATUS_REQUIRED || rmcResponseProfileManager.getProfileResponse(
								rmcInPrflCargo, respTyp).charAt(0) == IRMCResponseProfileManager.STATUS_ADD_NEW)) {
					reqInd=true;
					rmcResponseProfileManager
					.makeComplete(
							rmcResponseProfileManager
							.getResponseByType(
									IRMCResponseProfileManager.OTHER_INCOME_DETAILS,
									categorySeqDetailBean
									.getCategoryType()),
									rmcInPrflCargo, true);

					rmcResponseProfileManager
					.makeComplete(IRMCResponseProfileManager.OTHER_INCOME,rmcInPrflCargo, true);
				}
			}
			//if the profile response was not 'R' or if we came from gatepost then don't persist else persist
			if(!reqInd || categorySeqDetailBean.getChangeSelectionCategoryCd() == null)
			{
				categorySelectionProfileManager.makeSequenceDetailComplete(
						otherIncomeProfile, null,
						categorySeqDetailBean.getIndividualSequence(),
						categorySeqDetailBean.getCategorySequence(),
						categorySeqDetailBean.getCategoryType());
			}
			else
			{
			// Mark complete otherinc sequence using common methods
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
										rmcInothrIncCargo.getUei_typ())) {
					session.remove(FwConstants.DETAIL_KEY_BEAN);
				}
			}
			
			// logic to schedule Employment health insurance screen using category sequence.
			
			// Needs to be a Medicaid program to schedule Employer Offer Health Coverage
			boolean maFlag = false;
			short[] pgmKey = (short[]) session
			.get(FwConstants.RMC_PROGRAM_KEY);
			
			if (pgmKey[0] == 1) {
				maFlag = true;
			}
            
            ABFinalSubmitBO finalSubmitBO = new ABFinalSubmitBO();
			double emplTotalGrossIncome = finalSubmitBO.loadEmplDetailGrossAmtRMB(appNumber);
			double selfEmplIncome = finalSubmitBO.loadSelfEmplDetailsRMB(appNumber);
			double totalHRIncome = finalSubmitBO.loadEmplDetailGrossHRAmtRMB(appNumber);
			double totalEarnedIncome = emplTotalGrossIncome + selfEmplIncome + totalHRIncome;
			double totalUnearnedIncome = finalSubmitBO.loadotherIncomeDetailsRMB(appNumber);
			ABJobIncomeBO jobIncomeBO = new ABJobIncomeBO();
			double mfplIncome = jobIncomeBO.calculateMFPL(peopleHandler.getNumberOfIndividuals());
            
            final JobIncomeBO jobBO = new JobIncomeBO();
            APP_IN_EMPL_Collection jobColl = jobBO.loadDetails(appNumber);
            boolean isEmpInsPageReq = false; 
            SortedSet catprofileDB = categorySelectionProfileManager.loadCategoryChangeSelectionProfile(appNumber);
            for(Object o : jobColl){
            	APP_IN_EMPL_Cargo cargo = (APP_IN_EMPL_Cargo) o;
            	if(maFlag && cargo.getSrc_app_ind()!= null &&( cargo.getSrc_app_ind().equalsIgnoreCase(AppConstants.RMC_NEW_RECORD_IND)
            			|| cargo.getSrc_app_ind().equalsIgnoreCase(AppConstants.RMC_MODIFIED_RECORD_IND))
            			&& totalEarnedIncome + totalUnearnedIncome > mfplIncome){
            		
                    
                	if(null != categorySelectionProfileManager.getCategorySequenceDetail(catprofileDB, Short.parseShort(cargo.getIndv_seq_num()), Short.parseShort(cargo.getSeq_num()), AppConstants.EMPL_HLTH_INS)){
                		categorySelectionProfileManager.makeSequenceDetailRequired(catprofileDB, appNumber, Short.parseShort(cargo.getIndv_seq_num()), Short.parseShort(cargo.getSeq_num()), AppConstants.EMPL_HLTH_INS);
                	}else{
                		categorySelectionProfileManager.insertSequenceDetail(catprofileDB,
                				appNumber,
                				AppConstants.EMPL_HLTH_INS, 
                				Short.parseShort(cargo.getIndv_seq_num()),
                				Short.parseShort(cargo.getSeq_num()), 
                				AppConstants.EMPL_HLTH_INS , 
                				Short.parseShort("0"));
                	}
                	
                	driverManager.makeRequired(FwConstants.RMC_DRIVER, "AREHI", driverArray, appNumber);
                	isEmpInsPageReq = true;
                    
                	
                    
            	} else {
            		if(null != categorySelectionProfileManager.getCategorySequenceDetail(catprofileDB, Short.parseShort(cargo.getIndv_seq_num()), Short.parseShort(cargo.getSeq_num()), AppConstants.EMPL_HLTH_INS)){
                		categorySelectionProfileManager.removeSequenceDetail(catprofileDB, appNumber, Short.parseShort(cargo.getIndv_seq_num()), Short.parseShort(cargo.getSeq_num()), AppConstants.EMPL_HLTH_INS, AppConstants.EMPL_HLTH_INS);
                		jobBO.eraseEmpIns(cargo.getApp_num(), cargo.getIndv_seq_num(),cargo.getSrc_app_ind());
                	}
                	if(!isEmpInsPageReq){
                		driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
                				"AREHI", driverArray, appNumber);
                	}
            	}
            }

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("storeOtherIncomeDetails");
			we.setFwException(fe);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"storeOtherIncomeDetails", e);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.storeOtherIncomeDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

	/**
	 * Comment here.
	 *
	 * @param txnBean the txn bean
	 \* @throws javax.ejb.EJBException the EJB exception
	 */
	public void loadOtherIncomeSummary(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherIncomeEJBBean.loadOtherIncomeSummary() - START");
		try {
			APP_IN_UEI_Collection rmcOtherIncColl = null;
			APP_IN_UEI_Collection rmcDcssColl = null;
			APP_IN_UEI_Collection rmcDcColl = null;
			APP_IN_UEI_Collection rmcSsiColl = null;
			APP_IN_UEI_Collection rmcRsdi = null;
			APP_IN_UEI_Collection rmcVetColl = null;
			APP_IN_UEI_Collection rmcConColl = null;
			APP_IN_UEI_Collection rmcAAColl = null;
			APP_IN_UEI_Collection rmcIgpColl = null;
			APP_IN_UEI_Collection rmcOthColl = null;
			final Map session = txnBean.getSession();
			Map pageCollection = txnBean.getPageCollection();
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
				// here we need to check the session profile is other income
				// session profile
				CategorySequenceDetail catSeqDetail = categorySelectionProfileManager
						.getCurrentSequenceDetail(selectionProfile);
				if (catSeqDetail == null) {
					catSeqDetail = categorySelectionProfileManager
							.getNextSequenceDetail(selectionProfile);
					if (catSeqDetail != null
							&& catSeqDetail.getChangeSelectionCategoryCd() != null
							&& AppConstants.RMC_CAT_OT_INC_PRFL
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
								AppConstants.RMC_CAT_OT_INC_PRFL);
			}

			categorySelectionProfileManager
			.resetCurrentSeqeunceDetail(selectionProfile);
			final OtherIncomeBO otherIncBO = new OtherIncomeBO();
			rmcOtherIncColl = otherIncBO.getRmcOtherIncDetails(appNum);
			rmcDcssColl = otherIncBO.getRmcOtherIncomeSubTypeDetails(rmcOtherIncColl,
					AppConstants.INC_OTH_DCSS);
			rmcDcColl = otherIncBO.getRmcOtherIncomeSubTypeDetails(rmcOtherIncColl,
					AppConstants.INC_DIR_CHIL);
			rmcSsiColl = otherIncBO.getRmcOtherIncomeSubTypeDetails(rmcOtherIncColl,
					AppConstants.INC_SSI_SUPP);
			rmcRsdi = otherIncBO.getRmcOtherIncomeSubTypeDetails(rmcOtherIncColl,
					AppConstants.INC_OTH_RSDI);
			rmcVetColl = otherIncBO.getRmcOtherIncomeSubTypeDetails(rmcOtherIncColl,
					AppConstants.INC_OTH_VET_BNFT);
			rmcConColl = otherIncBO.getRmcOtherIncomeSubTypeDetails(rmcOtherIncColl,
					AppConstants.INC_OTH_CONT);
			rmcAAColl = otherIncBO.getRmcOtherIncomeSubTypeDetails(rmcOtherIncColl,
					AppConstants.INC_OTH_TRBL_ASST);
			rmcIgpColl = otherIncBO.getRmcOtherIncomeSubTypeDetails(rmcOtherIncColl,
					AppConstants.OTH_IND_GAMBL_PMNTS);
			rmcOthColl = otherIncBO.getDataForOtherIncListView(appNum);

			if (rmcOtherIncColl == null) {
				rmcOtherIncColl = new APP_IN_UEI_Collection();
			}
			if (rmcDcssColl == null) {
				rmcDcssColl = new APP_IN_UEI_Collection();
			}
			if (rmcDcColl == null) {
				rmcDcColl = new APP_IN_UEI_Collection();
			}
			if (rmcSsiColl == null) {
				rmcSsiColl = new APP_IN_UEI_Collection();
			}
			if (rmcVetColl == null) {
				rmcVetColl = new APP_IN_UEI_Collection();
			}
			if (rmcConColl == null) {
				rmcConColl = new APP_IN_UEI_Collection();
			}
			if (rmcAAColl == null) {
				rmcAAColl = new APP_IN_UEI_Collection();
			}
			if (rmcIgpColl == null) {
				rmcIgpColl = new APP_IN_UEI_Collection();
			}
			if (rmcOthColl == null) {
				rmcOthColl = new APP_IN_UEI_Collection();
			}

			// Getting language from http session
			final Map httpSessionMap = (Map) session
					.get(FwConstants.HTTP_SESSION);
			final String language = (String) httpSessionMap
					.get(AppConstants.LANGUAGE);

			final int sizeJobCustColl = rmcOtherIncColl.size();
			String newOrModifiedExists = FwConstants.NO;

			if (FwConstants.NO.equals(newOrModifiedExists)) {
				for (int i = 0; i < sizeJobCustColl; i++) {
					APP_IN_UEI_Cargo otherIncCargo = new APP_IN_UEI_Cargo();
					otherIncCargo = rmcOtherIncColl.getCargo(i);
					if (AppConstants.RMC_NEW_RECORD_IND.equals(otherIncCargo
							.getSrc_app_ind())
							|| AppConstants.RMC_MODIFIED_RECORD_IND
							.equals(otherIncCargo.getSrc_app_ind())) {
						newOrModifiedExists = FwConstants.YES;
					}
				}
			}
			final PeopleHandler peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);
			final RMC_IN_PRFL_Collection rmcInPrflSessColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			pageCollection = createAndLoadResponseMapsToPageCollectionForSummary(
					rmcInPrflSessColl, pageCollection, peopleHandler, true);
			final RMCOtherIncomeDCSSSummaryListVIew rmcOtherIncomeDCSSSummaryListVIew = new RMCOtherIncomeDCSSSummaryListVIew();
			final RMCOtherIncomeDirChildSummaryListVIew rmcOtherIncomeDirChildSummaryListVIew = new RMCOtherIncomeDirChildSummaryListVIew();
			final RMCOtherIncomeSSISummaryListView rmcOtherIncomeSSISummaryListView = new RMCOtherIncomeSSISummaryListView();
			final RMCOtherIncomeRSDISummaryListView rmcOtherIncomeRSDISummaryListView = new RMCOtherIncomeRSDISummaryListView();
			final RMCOtherIncomeVetSummaryListView rmcOtherIncomeVetSummaryListView = new RMCOtherIncomeVetSummaryListView();
			final RMCOtherIncomeContrSummaryListView rmcOtherIncomeContrSummaryListView = new RMCOtherIncomeContrSummaryListView();
			final RMCOtherIncomeAmericanIndianSummaryListView rmcOtherIncomeAmericanIndianSummaryListView = new RMCOtherIncomeAmericanIndianSummaryListView();
			final RMCOtherIncomeOthOthIncSummaryListView rmcOtherIncomeOthOthIncSummaryListView = new RMCOtherIncomeOthOthIncSummaryListView();

			final JobIncomeBO jobBo = new JobIncomeBO();
			APP_IN_EMPL_HEALTH_Collection appInEmplHlthColl = jobBo.getAppInEmplHlthInsDetails(appNum);
			final RMCJobIncomeSummaryHealthInsListView rmcJobIncomeSummaryHealthInsListView = new RMCJobIncomeSummaryHealthInsListView();
            rmcJobIncomeSummaryHealthInsListView
            .setEmplHlthCollection(appInEmplHlthColl);
            rmcJobIncomeSummaryHealthInsListView.setAppType(appType);
            rmcJobIncomeSummaryHealthInsListView.setLanguage(language);
            rmcJobIncomeSummaryHealthInsListView
            .setName("HEALTH_SELECTION_LISTVIEW");
            rmcJobIncomeSummaryHealthInsListView
            .setDisplayData(appInEmplHlthColl);
            rmcJobIncomeSummaryHealthInsListView.setPageSize(1000);
            pageCollection.put("APP_IN_EMPL_HEALTH_Collection", appInEmplHlthColl);
            pageCollection.put("HEALTH_SELECTION_LISTVIEW", rmcJobIncomeSummaryHealthInsListView);
            
			
			rmcOtherIncomeDCSSSummaryListVIew.setEmplCollection(rmcDcssColl);
			rmcOtherIncomeDirChildSummaryListVIew.setEmplCollection(rmcDcColl);
			rmcOtherIncomeSSISummaryListView.setEmplCollection(rmcSsiColl);
			rmcOtherIncomeRSDISummaryListView.setEmplCollection(rmcRsdi);
			rmcOtherIncomeVetSummaryListView.setEmplCollection(rmcVetColl);
			rmcOtherIncomeContrSummaryListView.setEmplCollection(rmcConColl);
			rmcOtherIncomeAmericanIndianSummaryListView
			.setEmplCollection(rmcAAColl);
			rmcOtherIncomeOthOthIncSummaryListView
			.setEmplCollection(rmcOthColl);

			// Put into session of these two collections
			pageCollection.put("APP_IN_UEI_Collection", rmcOtherIncColl);
			pageCollection.put("DCSSSummaryColl", rmcDcssColl);
			pageCollection.put("DirChildSummaryColl", rmcDcColl);
			pageCollection.put("SSISummaryColl", rmcSsiColl);
			pageCollection.put("RSDISummaryColl", rmcRsdi);
			pageCollection.put("VetSummaryColl", rmcVetColl);
			pageCollection.put("ConSummaryColl", rmcConColl);
			pageCollection.put("AmericanIndianSummaryColl", rmcAAColl);
			pageCollection.put("IgpSummaryColl", rmcIgpColl);
			pageCollection.put("OtherIncomeSummaryColl", rmcOthColl);
			pageCollection.put("NEW_OR_MOD_EXISTS", newOrModifiedExists);

			// Preparing listView for other Income selection
			rmcOtherIncomeDCSSSummaryListVIew.setLanguage(language);
			rmcOtherIncomeDCSSSummaryListVIew
			.setName("RMC_OTHERINCOME_DCSS_SUMMARY_LISTVIEW");
			rmcOtherIncomeDCSSSummaryListVIew.setAppType(appType);
			rmcOtherIncomeDCSSSummaryListVIew.setDisplayData(rmcDcssColl);
			rmcOtherIncomeDCSSSummaryListVIew.setPageSize(1000);
			
			rmcOtherIncomeDirChildSummaryListVIew.setLanguage(language);
			rmcOtherIncomeDirChildSummaryListVIew
			.setName("RMC_OTHERINCOME_DIRCHILD_SUMMARY_LISTVIEW");
			rmcOtherIncomeDirChildSummaryListVIew.setAppType(appType);
			rmcOtherIncomeDirChildSummaryListVIew.setDisplayData(rmcDcColl);
			rmcOtherIncomeDirChildSummaryListVIew.setPageSize(1000);

			rmcOtherIncomeSSISummaryListView.setLanguage(language);
			rmcOtherIncomeSSISummaryListView
			.setName("RMC_OTHERINCOME_SSI_SUMMARY_LISTVIEW");
			rmcOtherIncomeSSISummaryListView.setAppType(appType);
			rmcOtherIncomeSSISummaryListView.setDisplayData(rmcSsiColl);
			rmcOtherIncomeSSISummaryListView.setPageSize(1000);

			rmcOtherIncomeRSDISummaryListView.setLanguage(language);
			rmcOtherIncomeRSDISummaryListView
			.setName("RMC_OTHERINCOME_RSDI_SUMMARY_LISTVIEW");
			rmcOtherIncomeRSDISummaryListView.setAppType(appType);
			rmcOtherIncomeRSDISummaryListView.setDisplayData(rmcRsdi);
			rmcOtherIncomeRSDISummaryListView.setPageSize(1000);

			rmcOtherIncomeVetSummaryListView.setLanguage(language);
			rmcOtherIncomeVetSummaryListView
			.setName("RMC_OTHERINCOME_VET_SUMMARY_LISTVIEW");
			rmcOtherIncomeVetSummaryListView.setAppType(appType);
			rmcOtherIncomeVetSummaryListView.setDisplayData(rmcVetColl);
			rmcOtherIncomeVetSummaryListView.setPageSize(1000);

			rmcOtherIncomeContrSummaryListView.setLanguage(language);
			rmcOtherIncomeContrSummaryListView
			.setName("RMC_OTHERINCOME_CON_SUMMARY_LISTVIEW");
			rmcOtherIncomeContrSummaryListView.setAppType(appType);
			rmcOtherIncomeContrSummaryListView.setDisplayData(rmcConColl);
			rmcOtherIncomeContrSummaryListView.setPageSize(1000);

			rmcOtherIncomeAmericanIndianSummaryListView.setLanguage(language);
			rmcOtherIncomeAmericanIndianSummaryListView
			.setName("RMC_OTHERINCOME_AA_SUMMARY_LISTVIEW");
			rmcOtherIncomeAmericanIndianSummaryListView.setAppType(appType);
			rmcOtherIncomeAmericanIndianSummaryListView
			.setDisplayData(rmcAAColl);
			rmcOtherIncomeAmericanIndianSummaryListView.setPageSize(1000);

			rmcOtherIncomeOthOthIncSummaryListView.setLanguage(language);
			rmcOtherIncomeOthOthIncSummaryListView
			.setName("RMC_OTHERINCOME_OO_SUMMARY_LISTVIEW");
			rmcOtherIncomeOthOthIncSummaryListView.setAppType(appType);
			rmcOtherIncomeOthOthIncSummaryListView.setDisplayData(rmcOthColl);
			rmcOtherIncomeOthOthIncSummaryListView.setPageSize(1000);

			// Poupulating pageCollection with respective response maps
			pageCollection.put("RMC_OTHERINCOME_DCSS_SUMMARY_LISTVIEW",
					rmcOtherIncomeDCSSSummaryListVIew);
			pageCollection.put("RMC_OTHERINCOME_DIRCHILD_SUMMARY_LISTVIEW",
					rmcOtherIncomeDirChildSummaryListVIew);
			pageCollection.put("RMC_OTHERINCOME_SSI_SUMMARY_LISTVIEW",
					rmcOtherIncomeSSISummaryListView);
			pageCollection.put("RMC_OTHERINCOME_RSDI_SUMMARY_LISTVIEW",
					rmcOtherIncomeRSDISummaryListView);
			pageCollection.put("RMC_OTHERINCOME_VET_SUMMARY_LISTVIEW",
					rmcOtherIncomeVetSummaryListView);
			pageCollection.put("RMC_OTHERINCOME_CON_SUMMARY_LISTVIEW",
					rmcOtherIncomeContrSummaryListView);
			pageCollection.put("RMC_OTHERINCOME_AA_SUMMARY_LISTVIEW",
					rmcOtherIncomeAmericanIndianSummaryListView);
			pageCollection.put("RMC_OTHERINCOME_OO_SUMMARY_LISTVIEW",
					rmcOtherIncomeOthOthIncSummaryListView);
			// run component manager
			componentManager.getComponents("ARUIS", txnBean);
			session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER,
					selectionProfile);
			// set before collection to pageCollection
			session.put(FwConstants.BEFORE_COLLECTION, pageCollection);
			txnBean.setSession(session);

			log(ILog.INFO, "RMCOtherIncomeEJBBean::loadOtherIncomeSummary:End");

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("loadOtherIncomeSummary");
			we.setFwException(fe);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"loadOtherIncomeSummary", e);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.loadOtherIncomeSummary() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

	/**
	 * Comment here.
	 *
	 * @param txnBean the txn bean
	 \* @throws javax.ejb.EJBException the EJB exception
	 */
	public void storeOtherIncomeSummary(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.storeOtherIncomeSummary() - START");

		try {

			log(ILog.INFO,
					"RMCOtherIncomeEJBBean::storeOtherIncomeSummary:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final String currentPageID = (String) request
					.get(FwConstants.CURRENT_PAGE_ID);
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);
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
			// Update Indicators for rmc
			final ChangingValidation cv = new ChangingValidation();
			cv.setOtherIncomeInd(txnBean);
			cv.setRSDIIncomeInd(txnBean);
			cv.setVetaranBenefitInd(txnBean);
			cv.setRoomBoardInd(txnBean);

			final OtherIncomeBO otherIncomeBO = new OtherIncomeBO();
			final APP_IN_UEI_Collection ueiCollection = otherIncomeBO
					.loadOtherIncomeCollection(appNum);

			final RMC_IN_PRFL_Collection rmcInPrflSessColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);

			final short[] questionsIndicators = new short[1];
			questionsIndicators[0] = IRMCResponseProfileManager.OTHR_INCM_CHG_IND;

			String[] indivResponseIndForIndv = null;
			final Map indivResponseIndIndv = new HashMap();
			if (ueiCollection != null && !ueiCollection.isEmpty()) {
				for (int j = 0; j < rmcInPrflSessColl.size(); j++) {

					indivResponseIndForIndv = new String[1];
					indivResponseIndForIndv[0] = AppConstants.NO;

					final RMC_IN_PRFL_Cargo sessionCargo = rmcInPrflSessColl
							.getCargo(j);

					for (int i = 0; i < ueiCollection.size(); i++) {
						final APP_IN_UEI_Cargo modifiedCargo = (APP_IN_UEI_Cargo) ueiCollection
								.get(i);

						if (sessionCargo.getIndv_seq_num().equals(
								modifiedCargo.getIndv_seq_num())) {
							sessionCargo.setOthr_incm_chg_ind(AppConstants.YES);
							indivResponseIndForIndv[0] = AppConstants.YES;
						}
						indivResponseIndIndv.put(
								sessionCargo.getIndv_seq_num(),
								indivResponseIndForIndv);
					}

				}

				for (int i = 0; i < rmcInPrflSessColl.size(); i++) {
					final RMC_IN_PRFL_Cargo sessionCargo = rmcInPrflSessColl
							.getCargo(i);
					rmcResponseProfileManager.persist(appNum, sessionCargo
							.getIndv_seq_num(), questionsIndicators,
							(String[]) indivResponseIndIndv.get(sessionCargo
									.getIndv_seq_num()));
				}

			}

			// Set RMC page Other Income Details make required
			driverManager.makeComplete(FwConstants.RMC_DRIVER, currentPageID,
					driverArray, appNum);

			session.put(FwConstants.RMC_DRIVER, driverArray);

			// End
			log(ILog.INFO, "RMCOtherIncomeEJBBean::storeOtherIncomeSummary:End");

		} catch (final FwException fe) {
			final FwWrappedException we = new FwWrappedException(fe);
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("storeOtherIncomeSummary");
			we.setFwException(fe);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"storeOtherIncomeSummary", e);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.storeOtherIncomeSummary() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

	/**
	 * Comment here.
	 *
	 * @param txnBean the txn bean
	 \* @throws javax.ejb.EJBException the EJB exception
	 */
	public void editOtherIncomeDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherIncomeEJBBean.editOtherIncomeDetails() - START");
		try {

			log(ILog.INFO, "RMCOtherIncomeEJBBean::editOtherIncome:Start");
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

			// Get the APP_IN_EMPL_Collection from pageCollection.
			final APP_IN_UEI_Collection otherIncColl = (APP_IN_UEI_Collection) pageCollection
					.get("APP_IN_UEI_Collection");
			final APP_IN_UEI_Cargo otherInCargo = otherIncColl.getCargo(0);
			otherInCargo.getIndv_seq_num();
			otherInCargo.getUei_typ();

			final IndivTypeSeqBean seqBean = new IndivTypeSeqBean();
			seqBean.setIndivSeqNum(otherInCargo.getIndv_seq_num());
			seqBean.setSeqNum(otherInCargo.getSeq_num());
			seqBean.setType(otherInCargo.getUei_typ());

			if ("RE".equals(otherInCargo.getSrc_app_ind())) {
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
			pageCollection = createAndLoadResponseMapsToPageCollection(
					rmcInPrflSessColl, pageCollection, peopleHandler, true,
					driverStatus);

			pageCollection.put(FwConstants.DETAIL_KEY_BEAN, seqBean);
			session.put(FwConstants.BEFORE_COLLECTION, pageCollection);

			// Set RMC page Other Income Details make required
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARUID",
					driverArray, appNum);
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARUIS",
					driverArray, appNum);
			txnBean.setSession(session);
			// End
			log(ILog.INFO, "RMCOtherIncomeEJBBean::editOtherIncomeDetails:End");

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("editOtherIncomeDetails");
			we.setFwException(fe);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"editOtherIncomeDetails", e);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.editOtherIncomeDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

	/**
	 * Comment here.
	 *
	 * @param txnBean the txn bean
	 \* @throws javax.ejb.EJBException the EJB exception
	 */
	public void eraseOtherIncomeDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.eraseOtherIncomeDetails() - START");
		try {

			log(ILog.INFO,
					"RMCOtherIncomeEJBBean::eraseOtherIncomeDetails:Start");
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
			final String catEmpTyp = AppConstants.RMC_CAT_OT_INC_PRFL;

			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);

			// Get the APP_IN_UEI_Collection from pageCollection.
			final APP_IN_UEI_Collection otherIncColl = (APP_IN_UEI_Collection) pageCollection
					.get("APP_IN_UEI_Collection");
			final APP_IN_UEI_Cargo otherInCargo = otherIncColl.getCargo(0);

			// Get the results from the APP_IN_EMPL_Collection
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);

			// delete record from rmc selection profile
			final SortedSet rmcSelPrfl = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);

			indvSeqNum = otherInCargo.getIndv_seq_num();
			seqNum = otherInCargo.getSeq_num();
			ueiType = otherInCargo.getUei_typ();

			final short responseId = rmcResponseProfileManager
					.getResponseByType(
							IApplicationManager.OTHER_INCOME_DETAILS, ueiType);

			APP_IN_UEI_Cargo beforeOtherInCargo = (APP_IN_UEI_Cargo) beforeColl
					.get("APP_IN_UEI_Cargo");
			final OtherIncomeBO otherIncomeBo = new OtherIncomeBO();

			if (beforeOtherInCargo == null
					|| otherIncomeBo.isDifferent(otherInCargo,
							beforeOtherInCargo)) {

				otherIncomeBo.validateErase(ueiType);
				request.put(FwConstants.MESSAGE_LIST,
						otherIncomeBo.getMessageList());
				beforeOtherInCargo = new APP_IN_UEI_Cargo();
				beforeOtherInCargo.setIndv_seq_num(indvSeqNum);
				beforeOtherInCargo.setSeq_num(seqNum);
				beforeOtherInCargo.setUei_typ(ueiType);
				beforeColl.put("APP_IN_UEI_Cargo", beforeOtherInCargo);
				txnBean.setPageCollection(beforeColl);
				return;

			}

			otherIncomeBo.deleteRecords(indvSeqNum, seqNum, appNum);
//			final SortedSet categorySelectionProfile = categorySelectionProfileManager
//					.loadCategoryChangeSelectionProfile(appNum,
//							catEmpTyp);
			categorySelectionProfileManager.removeSequenceDetail(rmcSelPrfl,
					appNum, Short.parseShort(indvSeqNum),
					Long.parseLong(seqNum), catEmpTyp, ueiType);
			final Map catTypes = new HashMap();
			catTypes.put(AppConstants.INC_CHIL_SUPP, AppConstants.INC_CHIL_SUPP);
			catTypes.put(AppConstants.INC_DIR_CHIL, AppConstants.INC_DIR_CHIL);
			catTypes.put(AppConstants.INC_SSI_SUPP, AppConstants.INC_SSI_SUPP);
			catTypes.put(AppConstants.INC_OTH_RSDI, AppConstants.INC_OTH_RSDI);
			catTypes.put(AppConstants.INC_OTH_VET_BNFT,
					AppConstants.INC_OTH_VET_BNFT);
			catTypes.put(AppConstants.INC_OTH_CONT, AppConstants.INC_OTH_CONT);
			catTypes.put(AppConstants.INC_OTH_TRBL_ASST,
					AppConstants.INC_OTH_TRBL_ASST);
			catTypes.put(AppConstants.INC_OTH_INC, AppConstants.INC_OTH_INC);
			catTypes.put(AppConstants.OTH_ADOPTION_ASSISTANCE,
					AppConstants.OTH_ADOPTION_ASSISTANCE);
			catTypes.put(AppConstants.OTH_ADOPTION_PAYMENTS,
					AppConstants.OTH_ADOPTION_PAYMENTS);
			catTypes.put(AppConstants.OTH_AGENT_ORNG_PYMT,
					AppConstants.OTH_AGENT_ORNG_PYMT);
			catTypes.put(AppConstants.OTH_ALIMONY, AppConstants.OTH_ALIMONY);
			catTypes.put(AppConstants.OTH_CAPITAL_GAINS,
					AppConstants.OTH_CAPITAL_GAINS);
			catTypes.put(AppConstants.OTH_DEATH_BNFT,
					AppConstants.OTH_DEATH_BNFT);
			catTypes.put(AppConstants.OTH_DABL_INCM, AppConstants.OTH_DABL_INCM);
			catTypes.put(AppConstants.OTH_DR_RELIEF, AppConstants.OTH_DR_RELIEF);
			catTypes.put(AppConstants.OTH_EDU_ASSIST,
					AppConstants.OTH_EDU_ASSIST);
			catTypes.put(AppConstants.OTH_ENERGY_ASSIST,
					AppConstants.OTH_ENERGY_ASSIST);
			catTypes.put(AppConstants.OTH_FRM_ALOT, AppConstants.OTH_FRM_ALOT);
			catTypes.put(AppConstants.OTH_FOSTER_CARE_PYMT,
					AppConstants.OTH_FOSTER_CARE_PYMT);
			catTypes.put(AppConstants.OTH_GEN_ASSIST,
					AppConstants.OTH_GEN_ASSIST);
			catTypes.put(AppConstants.OTH_INT_DIV_PYMT,
					AppConstants.OTH_INT_DIV_PYMT);
			catTypes.put(AppConstants.OTH_IRA_DIST, AppConstants.OTH_IRA_DIST);
			catTypes.put(AppConstants.OTH_LOTTERY_WIN,
					AppConstants.OTH_LOTTERY_WIN);
			catTypes.put(AppConstants.OTH_LUMP_SUM, AppConstants.OTH_LUMP_SUM);
			catTypes.put(AppConstants.OTH_MIL_ALOT, AppConstants.OTH_MIL_ALOT);
			catTypes.put(AppConstants.OTH_MON_FRO_OTH,
					AppConstants.OTH_MON_FRO_OTH);
			catTypes.put(AppConstants.OTH_NET_RENT_ROYALTY,
					AppConstants.OTH_NET_RENT_ROYALTY);
			catTypes.put(AppConstants.OTH_OTH, AppConstants.OTH_OTH);
			catTypes.put(AppConstants.OTH_ANNY_PYMT, AppConstants.OTH_ANNY_PYMT);
			catTypes.put(AppConstants.OTH_PYMT_BO, AppConstants.OTH_PYMT_BO);
			catTypes.put(AppConstants.OTH_PENSION, AppConstants.OTH_PENSION);
			catTypes.put(AppConstants.OTH_RR_RETIRE, AppConstants.OTH_RR_RETIRE);
			catTypes.put(AppConstants.OTH_REFUGEE_CASH,
					AppConstants.OTH_REFUGEE_CASH);
			catTypes.put(AppConstants.OTH_REL_CARE, AppConstants.OTH_REL_CARE);
			catTypes.put(AppConstants.OTH_RENTAL_INCM,
					AppConstants.OTH_RENTAL_INCM);
			catTypes.put(AppConstants.OTH_TANF_PYMT, AppConstants.OTH_TANF_PYMT);
			catTypes.put(AppConstants.OTH_UNEMPL, AppConstants.OTH_UNEMPL);
			catTypes.put(AppConstants.OTH_WORKER_STUDY,
					AppConstants.OTH_WORKER_STUDY);
			catTypes.put(AppConstants.OTH_WORKER_COMP,
					AppConstants.OTH_WORKER_COMP);
			catTypes.put(AppConstants.OTH_IND_GAMBL_PMNTS,
					AppConstants.OTH_IND_GAMBL_PMNTS);

			final Map otherIncCatTypes = new HashMap();
			otherIncCatTypes.put(AppConstants.OTH_ADOPTION_ASSISTANCE,
					AppConstants.OTH_ADOPTION_ASSISTANCE);
			otherIncCatTypes.put(AppConstants.OTH_ADOPTION_PAYMENTS,
					AppConstants.OTH_ADOPTION_PAYMENTS);
			otherIncCatTypes.put(AppConstants.OTH_AGENT_ORNG_PYMT,
					AppConstants.OTH_AGENT_ORNG_PYMT);
			otherIncCatTypes.put(AppConstants.OTH_ALIMONY,
					AppConstants.OTH_ALIMONY);
			otherIncCatTypes.put(AppConstants.OTH_CAPITAL_GAINS,
					AppConstants.OTH_CAPITAL_GAINS);
			otherIncCatTypes.put(AppConstants.OTH_DEATH_BNFT,
					AppConstants.OTH_DEATH_BNFT);
			otherIncCatTypes.put(AppConstants.OTH_DABL_INCM,
					AppConstants.OTH_DABL_INCM);
			otherIncCatTypes.put(AppConstants.OTH_DR_RELIEF,
					AppConstants.OTH_DR_RELIEF);
			otherIncCatTypes.put(AppConstants.OTH_EDU_ASSIST,
					AppConstants.OTH_EDU_ASSIST);
			otherIncCatTypes.put(AppConstants.OTH_ENERGY_ASSIST,
					AppConstants.OTH_ENERGY_ASSIST);
			otherIncCatTypes.put(AppConstants.OTH_FRM_ALOT,
					AppConstants.OTH_FRM_ALOT);
			otherIncCatTypes.put(AppConstants.OTH_FOSTER_CARE_PYMT,
					AppConstants.OTH_FOSTER_CARE_PYMT);
			otherIncCatTypes.put(AppConstants.OTH_GEN_ASSIST,
					AppConstants.OTH_GEN_ASSIST);
			otherIncCatTypes.put(AppConstants.OTH_INT_DIV_PYMT,
					AppConstants.OTH_INT_DIV_PYMT);
			otherIncCatTypes.put(AppConstants.OTH_IRA_DIST,
					AppConstants.OTH_IRA_DIST);
			otherIncCatTypes.put(AppConstants.OTH_LOTTERY_WIN,
					AppConstants.OTH_LOTTERY_WIN);
			otherIncCatTypes.put(AppConstants.OTH_LUMP_SUM,
					AppConstants.OTH_LUMP_SUM);
			otherIncCatTypes.put(AppConstants.OTH_MIL_ALOT,
					AppConstants.OTH_MIL_ALOT);
			otherIncCatTypes.put(AppConstants.OTH_MON_FRO_OTH,
					AppConstants.OTH_MON_FRO_OTH);
			otherIncCatTypes.put(AppConstants.OTH_NET_RENT_ROYALTY,
					AppConstants.OTH_NET_RENT_ROYALTY);
			otherIncCatTypes.put(AppConstants.OTH_OTH, AppConstants.OTH_OTH);
			otherIncCatTypes.put(AppConstants.OTH_ANNY_PYMT,
					AppConstants.OTH_ANNY_PYMT);
			otherIncCatTypes.put(AppConstants.OTH_PYMT_BO,
					AppConstants.OTH_PYMT_BO);
			otherIncCatTypes.put(AppConstants.OTH_PENSION,
					AppConstants.OTH_PENSION);
			otherIncCatTypes.put(AppConstants.OTH_RR_RETIRE,
					AppConstants.OTH_RR_RETIRE);
			otherIncCatTypes.put(AppConstants.OTH_REFUGEE_CASH,
					AppConstants.OTH_REFUGEE_CASH);
			otherIncCatTypes.put(AppConstants.OTH_REL_CARE,
					AppConstants.OTH_REL_CARE);
			otherIncCatTypes.put(AppConstants.OTH_RENTAL_INCM,
					AppConstants.OTH_RENTAL_INCM);
			otherIncCatTypes.put(AppConstants.OTH_TANF_PYMT,
					AppConstants.OTH_TANF_PYMT);
			otherIncCatTypes.put(AppConstants.OTH_UNEMPL,
					AppConstants.OTH_UNEMPL);
			otherIncCatTypes.put(AppConstants.OTH_WORKER_STUDY,
					AppConstants.OTH_WORKER_STUDY);
			otherIncCatTypes.put(AppConstants.OTH_WORKER_COMP,
					AppConstants.OTH_WORKER_COMP);
			otherIncCatTypes.put(AppConstants.OTH_IND_GAMBL_PMNTS,
					AppConstants.OTH_IND_GAMBL_PMNTS);

			if (beforeColl != null) {
				int count = 0;
				APP_IN_UEI_Collection otherColl = null;
				APP_IN_UEI_Cargo otherCargo = null;
				otherColl = (APP_IN_UEI_Collection) beforeColl
						.get("APP_IN_UEI_Collection");

				if (otherColl != null && !otherColl.isEmpty()) {
					final int otherIncCollSize = otherColl.size();
					for (int i = 0; i < otherIncCollSize; i++) {
						otherCargo = otherColl.getCargo(i);
						if (otherCargo.getIndv_seq_num().equals(indvSeqNum)
								&& otherCargo.getUei_typ().equals(ueiType)
								&& AppConstants.RMC_NEW_RECORD_IND
								.equals(otherCargo.getSrc_app_ind())) {
							count++;
						}
					}
				}
				if (count == 1) {
					// now we need to make that profile required
					final RMC_IN_PRFL_Cargo rmcResCargo = rmcResponseProfileManager
							.getProfile(rmcInPrflColl, indvSeqNum);
					rmcResponseProfileManager.makeAbsoluteNotRequired(
							IRMCResponseProfileManager.OTHER_INCOME,
							rmcResCargo, true);
					rmcResponseProfileManager.makeAbsoluteNotRequired(
							responseId, rmcResCargo, true);
				}
			}
			rmcResponseProfileManager.getProfile(rmcInPrflColl, indvSeqNum);
			boolean makeDetailsNotRerquired = false;
			if (AppConstants.INC_CHIL_SUPP.equals(ueiType)) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl,
						IRMCResponseProfileManager.BNFT_CHL_SPRT_RESP)) {
					makeDetailsNotRerquired = true;
				}
			} else if (AppConstants.INC_DIR_CHIL.equals(ueiType)) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl,
						IRMCResponseProfileManager.CHILD_SUPPORT_PAYMENT)) {
					makeDetailsNotRerquired = true;
				}
			} else if (AppConstants.INC_SSI_SUPP.equals(ueiType)) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl, IRMCResponseProfileManager.RECEIVE_SSI)) {
					makeDetailsNotRerquired = true;
				}
			} else if (AppConstants.INC_OTH_RSDI.equals(ueiType)) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl,
						IRMCResponseProfileManager.RECEIVE_SOCIAL_SECURITY)) {
					makeDetailsNotRerquired = true;
				}
			} else if (AppConstants.INC_OTH_VET_BNFT.equals(ueiType)) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl,
						IRMCResponseProfileManager.BENEFIT_VETERAN)) {
					makeDetailsNotRerquired = true;
				}
			} else if (AppConstants.INC_OTH_CONT.equals(ueiType)) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl,
						IRMCResponseProfileManager.OTHR_INCM_CONTRIB_RESP)) {
					makeDetailsNotRerquired = true;
				}
			} else if (AppConstants.INC_OTH_TRBL_ASST.equals(ueiType)) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl,
						IRMCResponseProfileManager.OTHR_INCM_TRBL_RESP)) {
					makeDetailsNotRerquired = true;
				}
			} else if (AppConstants.OTH_IND_GAMBL_PMNTS.equals(ueiType)) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl,
						IRMCResponseProfileManager.OTH_IND_GAMBL_PMNTS)) {
					makeDetailsNotRerquired = true;
				}
			} else {
				final String type = (String) otherIncCatTypes.get(ueiType);
				if (type != null
						&& rmcResponseProfileManager.isAppResponseNotRequired(
								rmcInPrflColl, responseId)) {
					driverManager.makeAbsoluteNotRequired(
							FwConstants.RMC_DRIVER, "ARUID", driverArray,
							appNum);
					driverManager.makeAbsoluteNotRequired(
							FwConstants.RMC_DRIVER, "ARUIT", driverArray,
							appNum);
				}
			}

			if (makeDetailsNotRerquired) {
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"ARUID", driverArray, appNum);
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
						"ARUID", driverArray, appNum);
			}
			session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER, rmcSelPrfl);
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARUIS",
					driverArray, appNum);
			log(ILog.INFO, "RMCOtherIncomeEJBBean::eraseOtherIncome:End");

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("eraseOtherIncomeDetails");
			we.setFwException(fe);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"eraseOtherIncomeDetails", e);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.eraseOtherIncomeDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

	/**
	 * Comment here.
	 *
	 * @param txnBean the txn bean
	 \* @throws javax.ejb.EJBException the EJB exception
	 */
	public void endOtherIncomeDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherIncomeEJBBean.endOtherIncomeDetails() - START");
		try {

			log(ILog.INFO, "RMCOtherIncomeEJBBean::endOtherIncomeDetails:Start");
			final Map session = txnBean.getSession();
			final Map pageCollection = txnBean.getPageCollection();
			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);

			final APP_IN_UEI_Collection jobIncColl = (APP_IN_UEI_Collection) pageCollection
					.get("APP_IN_UEI_Collection");
			final APP_IN_UEI_Cargo jobInCargo = jobIncColl.getCargo(0);

			final IndivTypeSeqBean seqBean = new IndivTypeSeqBean();
			seqBean.setIndivSeqNum(jobInCargo.getIndv_seq_num());
			seqBean.setSeqNum(jobInCargo.getSeq_num());
			seqBean.setType(jobInCargo.getUei_typ());
			seqBean.setUserEndInd(FwConstants.ONE);
			pageCollection.put(FwConstants.DETAIL_KEY_BEAN, seqBean);
			// Get App Number
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			// Set RMC page Other Income Details make required
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARUID",
					driverArray, appNum);
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARUIS",
					driverArray, appNum);

			// End
			log(ILog.INFO, "RMCOtherIncomeEJBBean::endOtherIncomeDetails:End");

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("endOtherIncomeDetails");
			we.setFwException(fe);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"endOtherIncomeDetails", e);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.endOtherIncomeDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

	/**
	 * Comment here.
	 *
	 * @param txnBean the txn bean
	 \* @throws javax.ejb.EJBException the EJB exception
	 */
	public void addOtherIncomeDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "RMCOtherIncomeEJBBean.addOtherIncomeDetails() - START");
		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			// get cargo determining user selection
			final String otherIncomeSeq = request.get("firstName_otherIncome") != null ? (String) request
					.get("firstName_otherIncome") : FwConstants.EMPTY_STRING;

					final String otherIncomeType = request.get("otherIncomeType") != null ? (String) request
							.get("otherIncomeType") : FwConstants.EMPTY_STRING;

							final ARUIDValidator validatorBO = new ARUIDValidator();
							// validate selections
							if (otherIncomeSeq == null
									|| AppConstants.SELECT_DEFAULT_OPTION
									.equals(otherIncomeSeq)
									|| AppConstants.SELECT_DEFAULT_OPTION
									.equals(otherIncomeType)) {
								validatorBO.validateAdd(otherIncomeSeq, otherIncomeType);
								// add validation message and return
								request.put(FwConstants.MESSAGE_LIST,
										validatorBO.getMessageList());
								txnBean.setPageCollection((Map) session
										.get(FwConstants.BEFORE_COLLECTION));
								return;
							}
							final String appNum = (String) session.get(AppConstants.APP_NUMBER);

							final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
							indivSeqBean.setIndivSeqNum(otherIncomeSeq);
							indivSeqBean.setSeqNum(FwConstants.ZERO);
							indivSeqBean.setType(otherIncomeType);
							indivSeqBean.setUserEndInd(FwConstants.ZERO);
							pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

							// set driver status
							final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
							driverManager.makeAddNew(FwConstants.RMC_DRIVER, "ARUID", driver,
									appNum);
							driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
									"ARUIT", driver, appNum);
							driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARUIS", driver,
									appNum);
							session.put(FwConstants.RMC_DRIVER, driver);

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("addOtherIncomeDetails");
			we.setFwException(fe);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"addOtherIncomeDetails", e);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.addOtherIncomeDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

	/**
	 * Adds the other income dcss details.
	 *
	 * @param txnBean the txn bean
	 \* @throws javax.ejb.EJBException the EJB exception
	 */
	public void addOtherIncomeDcssDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.addOtherIncomeDcssDetails() - START");
		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			// get cargo determining user selection
			final String otherIncomeSeq = request.get("firstName_dcss") != null ? (String) request
					.get("firstName_dcss") : FwConstants.EMPTY_STRING;

					final ARUIDValidator validatorBO = new ARUIDValidator();
					// validate selections
					if (otherIncomeSeq == null
							|| AppConstants.SELECT_DEFAULT_OPTION
							.equals(otherIncomeSeq)) {
						validatorBO.validateAdd(otherIncomeSeq,
								AppConstants.INC_OTH_DCSS);
						// add validation message and return
						request.put(FwConstants.MESSAGE_LIST,
								validatorBO.getMessageList());
						txnBean.setPageCollection((Map) session
								.get(FwConstants.BEFORE_COLLECTION));
						return;
					}
					final String appNum = (String) session.get(AppConstants.APP_NUMBER);

					final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
					indivSeqBean.setIndivSeqNum(otherIncomeSeq);
					indivSeqBean.setSeqNum(FwConstants.ZERO);
					indivSeqBean.setType(AppConstants.INC_OTH_DCSS);
					indivSeqBean.setUserEndInd(FwConstants.ZERO);
					pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

					// set driver status
					final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
					driverManager.makeAddNew(FwConstants.RMC_DRIVER, "ARUID", driver,
							appNum);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARUIS", driver,
							appNum);
					session.put(FwConstants.RMC_DRIVER, driver);

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("addOtherIncomeDcssDetails");
			we.setFwException(fe);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"addOtherIncomeDcssDetails", e);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.addOtherIncomeDcssDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

	/**
	 * Adds the other income dc details.
	 *
	 * @param txnBean the txn bean
	 \* @throws javax.ejb.EJBException the EJB exception
	 */
	public void addOtherIncomeDcDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.addOtherIncomeDcDetails() - START");
		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			// get cargo determining user selection

			final String otherIncomeSeq = request.get("firstName_dc") != null ? (String) request
					.get("firstName_dc") : FwConstants.EMPTY_STRING;

					final ARUIDValidator validatorBO = new ARUIDValidator();
					// validate selections
					if (otherIncomeSeq == null
							|| AppConstants.SELECT_DEFAULT_OPTION
							.equals(otherIncomeSeq)) {
						validatorBO.validateAdd(otherIncomeSeq,
								AppConstants.INC_DIR_CHIL);
						// add validation message and return
						request.put(FwConstants.MESSAGE_LIST,
								validatorBO.getMessageList());
						txnBean.setPageCollection((Map) session
								.get(FwConstants.BEFORE_COLLECTION));
						return;
					}
					final String appNum = (String) session.get(AppConstants.APP_NUMBER);

					final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
					indivSeqBean.setIndivSeqNum(otherIncomeSeq);
					indivSeqBean.setSeqNum(FwConstants.ZERO);
					indivSeqBean.setType(AppConstants.INC_DIR_CHIL);
					indivSeqBean.setUserEndInd(FwConstants.ZERO);
					pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

					// set driver status
					final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
					driverManager.makeAddNew(FwConstants.RMC_DRIVER, "ARUID", driver,
							appNum);

					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARUIS", driver,
							appNum);
					session.put(FwConstants.RMC_DRIVER, driver);

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("addOtherIncomeDcDetails");
			we.setFwException(fe);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"addOtherIncomeDcDetails", e);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.addOtherIncomeDcDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

	/**
	 * Adds the other income ssi details.
	 *
	 * @param txnBean the txn bean
	 \* @throws javax.ejb.EJBException the EJB exception
	 */
	public void addOtherIncomeSsiDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.addOtherIncomeSsiDetails() - START");
		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			// get cargo determining user selection

			final String otherIncomeSeq = request.get("firstName_ssi") != null ? (String) request
					.get("firstName_ssi") : FwConstants.EMPTY_STRING;

					final ARUIDValidator validatorBO = new ARUIDValidator();
					// validate selections
					if (otherIncomeSeq == null
							|| AppConstants.SELECT_DEFAULT_OPTION
							.equals(otherIncomeSeq)) {
						validatorBO.validateAdd(otherIncomeSeq,
								AppConstants.INC_SSI_SUPP);
						// add validation message and return
						request.put(FwConstants.MESSAGE_LIST,
								validatorBO.getMessageList());
						txnBean.setPageCollection((Map) session
								.get(FwConstants.BEFORE_COLLECTION));
						return;
					}
					final String appNum = (String) session.get(AppConstants.APP_NUMBER);

					final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
					indivSeqBean.setIndivSeqNum(otherIncomeSeq);
					indivSeqBean.setSeqNum(FwConstants.ZERO);
					indivSeqBean.setType(AppConstants.INC_SSI_SUPP);
					indivSeqBean.setUserEndInd(FwConstants.ZERO);
					pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

					// set driver status
					final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
					driverManager.makeAddNew(FwConstants.RMC_DRIVER, "ARUID", driver,
							appNum);

					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARUIS", driver,
							appNum);
					session.put(FwConstants.RMC_DRIVER, driver);

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("addOtherIncomeSsiDetails");
			we.setFwException(fe);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"addOtherIncomeSsiDetails", e);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.addOtherIncomeSsiDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

	/**
	 * Adds the other income rsdi details.
	 *
	 * @param txnBean the txn bean
	 \* @throws javax.ejb.EJBException the EJB exception
	 */
	public void addOtherIncomeRsdiDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.addOtherIncomeRsdiDetails() - START");
		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			// get cargo determining user selection

			final String otherIncomeSeq = request.get("firstName_rsdi") != null ? (String) request
					.get("firstName_rsdi") : FwConstants.EMPTY_STRING;

					final ARUIDValidator validatorBO = new ARUIDValidator();
					// validate selections
					if (otherIncomeSeq == null
							|| AppConstants.SELECT_DEFAULT_OPTION
							.equals(otherIncomeSeq)) {
						validatorBO.validateAdd(otherIncomeSeq,
								AppConstants.INC_OTH_RSDI);
						// add validation message and return
						request.put(FwConstants.MESSAGE_LIST,
								validatorBO.getMessageList());
						txnBean.setPageCollection((Map) session
								.get(FwConstants.BEFORE_COLLECTION));
						return;
					}
					final String appNum = (String) session.get(AppConstants.APP_NUMBER);

					final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
					indivSeqBean.setIndivSeqNum(otherIncomeSeq);
					indivSeqBean.setSeqNum(FwConstants.ZERO);
					indivSeqBean.setType(AppConstants.INC_OTH_RSDI);
					indivSeqBean.setUserEndInd(FwConstants.ZERO);
					pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

					// set driver status
					final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
					driverManager.makeAddNew(FwConstants.RMC_DRIVER, "ARUID", driver,
							appNum);

					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARUIS", driver,
							appNum);
					session.put(FwConstants.RMC_DRIVER, driver);

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("addOtherIncomeRsdiDetails");
			we.setFwException(fe);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"addOtherIncomeRsdiDetails", e);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.addOtherIncomeRsdiDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

	/**
	 * Adds the other income vet details.
	 *
	 * @param txnBean the txn bean
	 \* @throws javax.ejb.EJBException the EJB exception
	 */
	public void addOtherIncomeVetDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.addOtherIncomeVetDetails() - START");
		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			// get cargo determining user selection

			final String otherIncomeSeq = request.get("firstName_vet") != null ? (String) request
					.get("firstName_vet") : FwConstants.EMPTY_STRING;

					final ARUIDValidator validatorBO = new ARUIDValidator();
					// validate selections
					if (otherIncomeSeq == null
							|| AppConstants.SELECT_DEFAULT_OPTION
							.equals(otherIncomeSeq)) {
						validatorBO.validateAdd(otherIncomeSeq,
								AppConstants.INC_OTH_VET_BNFT);
						// add validation message and return
						request.put(FwConstants.MESSAGE_LIST,
								validatorBO.getMessageList());
						txnBean.setPageCollection((Map) session
								.get(FwConstants.BEFORE_COLLECTION));
						return;
					}
					final String appNum = (String) session.get(AppConstants.APP_NUMBER);

					final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
					indivSeqBean.setIndivSeqNum(otherIncomeSeq);
					indivSeqBean.setSeqNum(FwConstants.ZERO);
					indivSeqBean.setType(AppConstants.INC_OTH_VET_BNFT);
					indivSeqBean.setUserEndInd(FwConstants.ZERO);
					pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

					// set driver status
					final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
					driverManager.makeAddNew(FwConstants.RMC_DRIVER, "ARUID", driver,
							appNum);

					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARUIS", driver,
							appNum);
					session.put(FwConstants.RMC_DRIVER, driver);

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("addOtherIncomeVetDetails");
			we.setFwException(fe);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"addOtherIncomeVetDetails", e);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.addOtherIncomeVetDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

	/**
	 * Adds the other income con details.
	 *
	 * @param txnBean the txn bean
	 \* @throws javax.ejb.EJBException the EJB exception
	 */
	public void addOtherIncomeConDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.addOtherIncomeConDetails() - START");
		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			// get cargo determining user selection

			final String otherIncomeSeq = request.get("firstName_con") != null ? (String) request
					.get("firstName_con") : FwConstants.EMPTY_STRING;

					final ARUIDValidator validatorBO = new ARUIDValidator();
					// validate selections
					if (otherIncomeSeq == null
							|| AppConstants.SELECT_DEFAULT_OPTION
							.equals(otherIncomeSeq)) {
						validatorBO.validateAdd(otherIncomeSeq,
								AppConstants.INC_OTH_CONT);
						// add validation message and return
						request.put(FwConstants.MESSAGE_LIST,
								validatorBO.getMessageList());
						txnBean.setPageCollection((Map) session
								.get(FwConstants.BEFORE_COLLECTION));
						return;
					}
					final String appNum = (String) session.get(AppConstants.APP_NUMBER);

					final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
					indivSeqBean.setIndivSeqNum(otherIncomeSeq);
					indivSeqBean.setSeqNum(FwConstants.ZERO);
					indivSeqBean.setType(AppConstants.INC_OTH_CONT);
					indivSeqBean.setUserEndInd(FwConstants.ZERO);
					pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

					// set driver status
					final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
					driverManager.makeAddNew(FwConstants.RMC_DRIVER, "ARUID", driver,
							appNum);

					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARUIS", driver,
							appNum);
					session.put(FwConstants.RMC_DRIVER, driver);

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("addOtherIncomeConDetails");
			we.setFwException(fe);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"addOtherIncomeConDetails", e);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.addOtherIncomeConDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

	/**
	 * Adds the other income aa details.
	 *
	 * @param txnBean the txn bean
	 \* @throws javax.ejb.EJBException the EJB exception
	 */
	public void addOtherIncomeAaDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.addOtherIncomeAaDetails() - START");
		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			// get cargo determining user selection

			final String otherIncomeSeq = request.get("firstName_aa") != null ? (String) request
					.get("firstName_aa") : FwConstants.EMPTY_STRING;

					final ARUIDValidator validatorBO = new ARUIDValidator();
					// validate selections
					if (otherIncomeSeq == null
							|| AppConstants.SELECT_DEFAULT_OPTION
							.equals(otherIncomeSeq)) {
						validatorBO.validateAdd(otherIncomeSeq,
								AppConstants.INC_OTH_TRBL_ASST);
						// add validation message and return
						request.put(FwConstants.MESSAGE_LIST,
								validatorBO.getMessageList());
						txnBean.setPageCollection((Map) session
								.get(FwConstants.BEFORE_COLLECTION));
						return;
					}
					final String appNum = (String) session.get(AppConstants.APP_NUMBER);

					final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
					indivSeqBean.setIndivSeqNum(otherIncomeSeq);
					indivSeqBean.setSeqNum(FwConstants.ZERO);
					indivSeqBean.setType(AppConstants.INC_OTH_TRBL_ASST);
					indivSeqBean.setUserEndInd(FwConstants.ZERO);
					pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

					// set driver status
					final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
					driverManager.makeAddNew(FwConstants.RMC_DRIVER, "ARUID", driver,
							appNum);

					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARUIS", driver,
							appNum);
					session.put(FwConstants.RMC_DRIVER, driver);

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("addOtherIncomeAaDetails");
			we.setFwException(fe);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"addOtherIncomeAaDetails", e);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.addOtherIncomeAaDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

	/**
	 * Adds the other income igp details.
	 *
	 * @param txnBean the txn bean
	 \* @throws javax.ejb.EJBException the EJB exception
	 */
	public void addOtherIncomeIgpDetails(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.addOtherIncomeIgpDetails() - START");
		try {
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			// get cargo determining user selection

			final String otherIncomeSeq = request.get("firstName_igp") != null ? (String) request
					.get("firstName_igp") : FwConstants.EMPTY_STRING;

					final ARUIDValidator validatorBO = new ARUIDValidator();
					// validate selections
					if (otherIncomeSeq == null
							|| AppConstants.SELECT_DEFAULT_OPTION
							.equals(otherIncomeSeq)) {
						validatorBO.validateAdd(otherIncomeSeq,
								AppConstants.OTH_IND_GAMBL_PMNTS);
						// add validation message and return
						request.put(FwConstants.MESSAGE_LIST,
								validatorBO.getMessageList());
						txnBean.setPageCollection((Map) session
								.get(FwConstants.BEFORE_COLLECTION));
						return;
					}
					final String appNum = (String) session.get(AppConstants.APP_NUMBER);

					final IndivTypeSeqBean indivSeqBean = new IndivTypeSeqBean();
					indivSeqBean.setIndivSeqNum(otherIncomeSeq);
					indivSeqBean.setSeqNum(FwConstants.ZERO);
					indivSeqBean.setType(AppConstants.OTH_IND_GAMBL_PMNTS);
					indivSeqBean.setUserEndInd(FwConstants.ZERO);
					pageCollection.put(FwConstants.DETAIL_KEY_BEAN, indivSeqBean);

					// set driver status
					final int[] driver = (int[]) session.get(FwConstants.RMC_DRIVER);
					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARUID", driver,
							appNum);

					driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARUIS", driver,
							appNum);
					session.put(FwConstants.RMC_DRIVER, driver);

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("addOtherIncomeIgpDetails");
			we.setFwException(fe);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"addOtherIncomeIgpDetails", e);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.addOtherIncomeIgpDetails() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

	/**
	 * Erase other income changes.
	 *
	 * @param txnBean the txn bean
	 \* @throws javax.ejb.EJBException the EJB exception
	 */
	public void eraseOtherIncomeChanges(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.eraseOtherIncomeChanges() - START");
		try {
			log(ILog.INFO,
					"RMCOtherIncomeEJBBean::eraseOtherIncomeChanges:Start");
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

			// Get driver info.
			final int[] driverArray = (int[]) session
					.get(FwConstants.RMC_DRIVER);

			// Get the APP_IN_UEI_Collection from pageCollection.
			final APP_IN_UEI_Collection otherIncColl = (APP_IN_UEI_Collection) pageCollection
					.get("APP_IN_UEI_Collection");
			final APP_IN_UEI_Cargo otherInCargo = otherIncColl.getCargo(0);

			// Get the results from the APP_IN_EMPL_Collection
			final String appNum = (String) session.get(AppConstants.APP_NUMBER);
			indvSeqNum = otherInCargo.getIndv_seq_num();
			seqNum = otherInCargo.getSeq_num();
			ueiType = otherInCargo.getUei_typ();
			APP_IN_UEI_Cargo beforeOtherInCargo = (APP_IN_UEI_Cargo) beforeColl
					.get("APP_IN_UEI_Cargo");

			final OtherIncomeBO otherIncomeBo = new OtherIncomeBO();
			if (beforeOtherInCargo == null
					|| otherIncomeBo.isDifferent(otherInCargo,
							beforeOtherInCargo)) {
				otherIncomeBo.validateEraseChanges(ueiType);
				request.put(FwConstants.MESSAGE_LIST,
						otherIncomeBo.getMessageList());
				beforeOtherInCargo = new APP_IN_UEI_Cargo();
				beforeOtherInCargo.setIndv_seq_num(indvSeqNum);
				beforeOtherInCargo.setSeq_num(seqNum);
				beforeOtherInCargo.setUei_typ(ueiType);
				beforeColl.put("APP_IN_UEI_Cargo", beforeOtherInCargo);
				txnBean.setPageCollection(beforeColl);
				return;
			}

			// delete record from database
			otherIncomeBo.deleteRecords(indvSeqNum, seqNum, appNum);
			final String catEmpTyp = AppConstants.RMC_CAT_OT_INC_PRFL;

			// delete record from rmc selection profile
			final SortedSet rmcSelPrfl = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			categorySelectionProfileManager.removeSequenceDetail(rmcSelPrfl,
					appNum, Short.parseShort(indvSeqNum),
					Long.parseLong(seqNum), catEmpTyp, ueiType);
			final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			boolean rmcPrflNotRequeired = false;
			// here we need to check we have no entrys in rmcPrfl for the other
			// income detail
			// as well as we need to check
			if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
				if (rmcResponseProfileManager.isAppResponseNotRequired(
						rmcInPrflColl, IRMCResponseProfileManager.OTHER_INCOME)) {
					if (rmcResponseProfileManager.isAppResponseNotRequired(
							rmcInPrflColl,
							IRMCResponseProfileManager.OTHER_INCOME)) {
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
						"ARUID", driverArray, appNum);
			}
			session.put(AppConstants.RMC_CATEGORY_PROFILE_MASTER, rmcSelPrfl);
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARUIS",
					driverArray, appNum);
			// End
			log(ILog.INFO, "RMCOtherIncomeEJBBean::eraseOtherIncomeChanges:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("eraseOtherIncomeChanges");
			we.setFwException(fe);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"eraseOtherIncomeChanges", e);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.eraseOtherIncomeChanges() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

	/**
	 * Load other income gate post questions.
	 *
	 * @param txnBean the txn bean
	 \* @throws javax.ejb.EJBException the EJB exception
	 * @throws javax.ejb.EJBException             zachael : The Unearned Income Gatepost Questions page
	 *             collects high level information on if the user would like to
	 *             report changes or additions to his/her unearned income
	 *             depending on the type of case
	 */
	public void loadOtherIncomeGatePostQuestions(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.loadOtherIncomeGatePostQuestions() - START");
		try {
			log(ILog.INFO,
					"RMCOtherIncomeEJBBean::loadOtherIncomeGatePostQuestions:Start");
			final Map session = txnBean.getSession();
			final Map pageCollection = txnBean.getPageCollection();
			final Map httpSession = (Map) session.get(FwConstants.HTTP_SESSION);
			Map beforeColl = (Map) session.get(FwConstants.BEFORE_COLLECTION);
			final OtherIncomeBO otherIncomeBO = new OtherIncomeBO();
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
			componentManager.getComponents("AROIQ", txnBean);
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
			// for change in address or help from others
			// for change in address or help from others
			if (cpntList.contains("5197")
					&& !extractionHandler.checkRMBExtractionStatus("AROIQ",
							"5197")) {
				typeArrayList.add(AppConstants.OI_EXT_ROOM_AND_BOARD_EARNINGS);

				typeArrayList.add(AppConstants.OI_EXT);
			}

			// now start webservice logic
			if (!typeArrayList.isEmpty() && !typeArrayList.isEmpty()) {
				// make webservice call
				final List pinNumList = new ArrayList();
				final int indvCollSize = indvColl.size();
				INDIVIDUAL_Custom_Cargo indivCustCargo = null;
				OTHER_INCOME_Custom_Cargo otherIncCustCargo = null;
				APP_IN_UEI_Collection otherIncColl = null;
				APP_IN_RM_BRD_INCM_Collection rmIncColl = null;
				String pinNumber = null;
				for (int i = 0; i < indvCollSize; i++) {
					indivCustCargo = indvColl.getResult(i);
					pinNumber = indivCustCargo.getIndv_pin_num();
					if (pinNumber != null) {
						pinNumList.add(indivCustCargo.getIndv_pin_num());
					}
				}
				final List types = new ArrayList();
				types.add(AppConstants.OI_EXT);
				types.add(AppConstants.ROOM_AND_BOARD);
				try {
					if (pinNumList != null && !pinNumList.isEmpty()) {
						otherIncCustCargo = otherIncomeBO
								.getOtherIncomeDetailsFromCares(pinNumList,
										appNum, types);
						if (otherIncCustCargo != null) {
							otherIncColl = otherIncCustCargo.getUeColl();
							if (otherIncColl != null) {
								otherIncomeBO
								.insertExistingDetails(otherIncColl);
							}
							rmIncColl = otherIncCustCargo.getRmBrdColl();
							if (rmIncColl != null) {
								otherIncomeBO
								.insertExistingRBDetails(rmIncColl);
							}
						}
						// ADD to extraction handler
						extractionHandler.addRMBExtractionStatus("AROIQ",
								"5197");
					}
				} catch (final FwException fe) {
					fe.setParameterText("Pin List is: " + pinNumList.toString()
							+ " AppNumber is: " + appNum);
					final FwWrappedException we = new FwWrappedException(fe);
					we.setCallingClassID(this.getClass().getName());
					we.setCallingMethodID("loadOtherIncomeGatePostQuestions");
					we.setFwException(fe);
					final FwExceptionManager exceptionMgr = (FwExceptionManager) FwServiceFactory
							.getInstance().create(IException.class);
					exceptionMgr.log(we);
					return;

				} catch (final Exception e) {
					final FwException fe = createFwException(this.getClass()
							.getName(), "getOtherIncomeDetailsFromCares", e);
					fe.setParameterText("Pin List is: " + pinNumList.toString()
							+ " AppNumber is: " + appNum);
					final FwWrappedException we = new FwWrappedException(e);
					we.setCallingClassID(this.getClass().getName());
					we.setCallingMethodID("loadOtherIncomeGatePostQuestions");
					we.setFwException(fe);
					final FwExceptionManager exceptionMgr = (FwExceptionManager) FwServiceFactory
							.getInstance().create(IException.class);
					exceptionMgr.log(we);
					return;
				}

				// persist webservice result
			}
			// Now create your ListView

			// load other income data for CW src
			final APP_IN_UEI_Collection ueiColl = otherIncomeBO
					.loadOtherIncomeDetailsBySrc(appNum,
							AppConstants.CWW_RECORD_IND);

			// Build custom Cargo for List view
			final List otherIncViewList = otherIncomeBO
					.buildOtherIncomeCustomCargo(ueiColl);
			// determine row count for list view
			final String rowCount = otherIncomeBO.otherIncomeTypeSelectionRows(
					ueiColl, indvColl);

			// build list view
			final List incDataList = new ArrayList(3);
			incDataList.add(otherIncViewList);
			incDataList.add(peopleHandler);
			incDataList.add(rowCount);

			final RMBOtherIncomeIndvGatePostListView rmbIndvOtherIncomeIndvGatePostListView = new RMBOtherIncomeIndvGatePostListView();
			rmbIndvOtherIncomeIndvGatePostListView.setLanguage(languageCd);
			rmbIndvOtherIncomeIndvGatePostListView.setJsEnabled(jsEnabled);
			rmbIndvOtherIncomeIndvGatePostListView
			.setName("RMB_INDV_OTHER_INCOME_GATEPOST_LISTVIEW");
			rmbIndvOtherIncomeIndvGatePostListView.setDisplayData(incDataList);
			rmbIndvOtherIncomeIndvGatePostListView.setPageSize(1000);
			pageCollection.put("RMB_INDV_OTHER_INCOME_GATEPOST_LISTVIEW",
					rmbIndvOtherIncomeIndvGatePostListView);
			pageCollection.put("OTHER_INCOME_VIEW", otherIncViewList);
			pageCollection.put("OTHER_INCOME_ROW_COUNT", rowCount);

			// Put in page collection
			pageCollection.put("INDV_COLL", indvColl);

			// get current page driver status
			final int currentPageStaus = driverManager.getAFBStatus(
					FwConstants.RMC_DRIVER, "AROIQ", driverArray);

			// preapare security map for questions if the user is re-visting the
			// page
			if (currentPageStaus != FwConstants.DRIVER_REQUIRED) {
				// call RMBRequest Manager to get the question response
				securityRadioOptionsMap = rmbRqstManager.getStatusForGatePost(
						AppConstants.RMB_OTHER_INCOME_GATE_POST_PAGE,
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
			componentManager.getComponents("AROIQ", txnBean);

			log(ILog.INFO,
					"RMCOtherIncomeEJBBean::loadOtherIncomeGatePostQuestions:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("loadOtherIncomeGatePostQuestions");
			we.setFwException(fe);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"loadOtherIncomeGatePostQuestions", e);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.loadOtherIncomeGatePostQuestions() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}

	/**
	 * Store other income gate post questions.
	 *
	 * @param txnBean the txn bean
	 \* @throws javax.ejb.EJBException the EJB exception
	 * @throws javax.ejb.EJBException the javax.ejb. ejb exception
	 */
	public void storeOtherIncomeGatePostQuestions(final FwTransaction txnBean)
			throws javax.ejb.EJBException {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.storeOtherIncomeGatePostQuestions() - START");
		try {
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
			final RMB_RQST_Collection sessRMBRqstColl = (RMB_RQST_Collection) session
					.get(AppConstants.RMB_RQST_COLLECTION);
			final RMB_RQST_Cargo sessRMBRqstCargo = sessRMBRqstColl.getCargo(0);
			// get RMB_RQST_Cargo
			pageRMBRqstCargo = pageRMBRqstColl.getCargo(0);
			final int currentPageStaus = driverManager.getAFBStatus(
					FwConstants.RMC_DRIVER, "AROIQ", driverArray);

			final int aARUIIPageStatus = driverManager.getAFBStatus(
					FwConstants.RMC_DRIVER, "ARUII", driverArray);
			boolean pARUIIReqFlag = false;

			// get component list for before collection to know which are all
			// the questions displayed on the JSP
			final List pageCpntList = (ArrayList) beforeColl
					.get(FwConstants.PAGE_COMPONENT_LIST);

			// Validate response
			final AROIQValidator validationBO = new AROIQValidator();
			final String backToMyAccess = (String) request
					.get(AppConstants.BACK_TO_MY_ACCESS_BUTTON);

			if (backToMyAccess == null) {
				validationBO.validateAROIQ(pageRMBRqstCargo, pageCpntList);
			}

			// Build page if validation fails
			if (checkBackToMyAccessSelected(request)
					|| validationBO.hasMessages()) {
				log(ILog.INFO, " ### Validation Failed ###");
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
				if (driverManager.getAFBStatus(FwConstants.RMC_DRIVER, "AROIQ",
						driverArray) == FwConstants.DRIVER_REQUIRED) {
					pageCollection
					.put("RADIO_OPTION_MAP",
							rmbRqstManager
							.getStatusForGatePostAfterValidation(
									AppConstants.RMB_OTHER_INCOME_GATE_POST_PAGE,
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
									AppConstants.RMB_OTHER_INCOME_GATE_POST_PAGE,
									sessRMBRqstColl,
									driverArray,
									sessRMCInPrflColl,
									sessChgSelectionProfile,
									peopleHandler));
				}
				pageCollection
				.put("RMB_INDV_OTHER_INCOME_GATEPOST_LISTVIEW",
						beforeColl
						.get("RMB_INDV_OTHER_INCOME_GATEPOST_LISTVIEW"));
				return;
			}
			// call request manager to get complete cargo
			pageRMBRqstCargo = rmbRqstManager.getCompleteCargo(
					sessRMBRqstCargo, pageRMBRqstCargo);
			// now call ischanged
			pageRMBRqstCargo = (RMB_RQST_Cargo) isChanged(sessRMBRqstCargo,
					pageRMBRqstCargo);
			// check if collection is Dirty Update RMBRequest Table with user
			// response .
			if (currentPageStaus != FwConstants.DRIVER_REQUIRED) {
				rmbRqstManager.changeStatusOnGatePost(pageRMBRqstColl, session,
						AppConstants.RMB_OTHER_INCOME_GATE_POST_PAGE);
			}
			if (pageRMBRqstCargo.isDirty()) {
				pageRMBRqstCargo.setRowAction(FwConstants.ROWACTION_UPDATE);
				final RMB_RQST_Collection rmbRqstColl = new RMB_RQST_Collection();
				rmbRqstColl.add(pageRMBRqstCargo);
				rmbRqstManager.storeRMBRqst(rmbRqstColl);
				// put the update RMB_RQST_Collection into session
				session.put(AppConstants.RMB_RQST_COLLECTION, rmbRqstColl);
			}

			// Update Driver to schedule required Other income change selection
			// page
			if (FwConstants.YES
					.equals(pageRMBRqstCargo.getOthr_incm_stat_ind())
					&& (FwConstants.NO.equals(sessRMBRqstCargo
							.getOthr_incm_stat_ind()) || FwConstants.HIDDEN
							.equals(sessRMBRqstCargo.getOthr_incm_stat_ind()))) {
				driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARUII",
						driverArray, appNum);
				pARUIIReqFlag = true;
			} else if (FwConstants.YES.equals(pageRMBRqstCargo
					.getOthr_incm_stat_ind())
					&& (aARUIIPageStatus == FwConstants.DRIVER_REQUIRED || aARUIIPageStatus == FwConstants.DRIVER_VISIT_AGAIN)) {
				pARUIIReqFlag = true;
			}

			if (!pARUIIReqFlag) {
				driverManager.makeAbsoluteNotRequired(FwConstants.RMC_DRIVER,
						"ARUII", driverArray, appNum);
			} else {
				driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARUII",
						driverArray, appNum);
			}

			driverManager.makeComplete(FwConstants.RMC_DRIVER, "AROIQ",
					driverArray, appNum);
			driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARUIS",
					driverArray, appNum);

			log(ILog.INFO,
					"RMCOtherIncomeEJBBean::storeOtherIncomeGatePostQuestions:End");
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("storeOtherIncomeGatePostQuestions");
			we.setFwException(fe);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"storeOtherIncomeGatePostQuestions", e);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

		log(ILog.INFO,
				"RMCOtherIncomeEJBBean.storeOtherIncomeGatePostQuestions() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ AppConstants.SPACE + AppConstants.MILLISECONDS);
	}
	
	/**
	 * Creates the and load response maps to page collection.
	 *
	 * @param rmcInPrflColl the rmc in prfl coll
	 * @param pageCollection the page collection
	 * @param peopleHandler the people handler
	 * @param pageLoad the page load
	 * @param driverStatus the driver status
	 * @return the map
	 */
	private Map createAndLoadResponseMapsToPageCollectionForSummary(
			final RMC_IN_PRFL_Collection rmcInPrflColl,
			final Map pageCollection, final PeopleHandler peopleHandler,
			final boolean pageLoad) {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"OtherIncomeEJBBean.createAndLoadResponseMapsToPageCollectionForSummary() - START");
		try {

			getPeopleCollectionAndUpdateMapsForSummary(rmcInPrflColl,
					pageCollection, peopleHandler, "255",
					IRMCResponseProfileManager.ROOM_AND_BOARD, pageLoad,
					true);
			// OTHR_INCM_TRBL_GA_RESP

			log(ILog.INFO,
					"OtherIncomeEJBBean.createAndLoadResponseMapsToPageCollectionForSummary() - END , Time Taken : "
							+ (System.currentTimeMillis() - startTime)
							+ AppConstants.SPACE + AppConstants.MILLISECONDS);
			return pageCollection;
		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("createAndLoadResponseMapsToPageCollectionForSummary");
			we.setFwException(fe);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"createAndLoadResponseMapsToPageCollection", e);
			throw rmcOtherIncomeEJBBean.exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}
	}
    
    public void setSessionContext(SessionContext sessionContext){
    	ctx=sessionContext;
    }   
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public FwException exceptionManagerLog(Exception e, String className,
			String methodName) {
		return super.exceptionManagerLog(e, className, methodName);
	}

}
