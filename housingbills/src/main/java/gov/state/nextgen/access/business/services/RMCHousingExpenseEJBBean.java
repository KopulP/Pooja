package gov.state.nextgen.access.business.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.StringTokenizer;

import org.springframework.stereotype.Service;

import gov.state.nextgen.access.business.entities.AppInHouBillsCargo;
import gov.state.nextgen.access.business.entities.AppInHouBillsCollection;
import gov.state.nextgen.access.business.entities.FwTransaction;
import gov.state.nextgen.access.business.entities.ICargo;
import gov.state.nextgen.access.business.entities.INDIVIDUAL_Custom_Collection;
import gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Cargo;
import gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Collection;
import gov.state.nextgen.access.business.factory.HousingBillsInterface;
import gov.state.nextgen.access.business.validations.ARXHDValidator;
import gov.state.nextgen.access.business.validations.FwComponentManager;
import gov.state.nextgen.access.business.validations.IComponent;
import gov.state.nextgen.access.driver.DriverManager;
import gov.state.nextgen.access.driver.IDriver;
import gov.state.nextgen.access.exceptions.EligibilityScreenerException;
import gov.state.nextgen.access.exceptions.FwException;
import gov.state.nextgen.access.factories.FwServiceFactory;
/*import gov.state.nextgen.access.individuals.PeopleHandler;*/
import gov.state.nextgen.access.management.applications.CategorySequenceDetail;
import gov.state.nextgen.access.management.applications.ICategorySelectionProfileManager;
import gov.state.nextgen.access.management.applications.IRMCResponseProfileManager;
import gov.state.nextgen.access.management.applications.IndivTypeSeqBean;
import gov.state.nextgen.access.management.applications.RMCResponseProfileManager;
import gov.state.nextgen.access.management.constants.AppConstants;
import gov.state.nextgen.access.management.constants.FwConstants;
import gov.state.nextgen.access.management.messages.FwMessage;
import gov.state.nextgen.access.management.messages.FwMessageList;
import gov.state.nextgen.access.management.references.IReferenceTableManager;
import gov.state.nextgen.access.management.references.ReferenceTableManager;
import gov.state.nextgen.access.management.util.Formatter;

/**
 * RMCHousingExpenseEJBBean - SessionFacade Object skeleton auto generated -
 * Architecture Team.
 *
 * Creation Date :Tue Feb 06 13:47:45 CST 2007 Modified By: Modified on:
 */

/*
 * *****************************************************************************
 * ******* ***************** SONAR FIXES MADE IN THIS CODE
 * ************************************** ISSUE DESCRIPTION NATURE OF FIX DATE
 * **** ================== ============= **** **** Avoid commented code Deleted
 * Commented code 09/1/2015 ** Lage Blocks of commented code *** are converted
 * to javadoc *** **
 * *************************************************************
 * *************************
 */

@Service("RMCHousingExpenseEJBBean")
public class RMCHousingExpenseEJBBean implements HousingBillsInterface {
	/**
	 * Comment here.
	 *
	 * @param txnBean the txn bean \* @throws javax.ejb.EJBException the EJB
	 *                exception
	 */
	
	private static final String TILDE = "~";
	private static final String MSG_30075 = "30075";
	
	/** The component manager. */
	IComponent componentManager = FwComponentManager.getInstance();
	
	Formatter displayFormatter = Formatter.getInstance();
	IDriver driverManager = DriverManager.getInstance();
	ICategorySelectionProfileManager categorySelectionProfileManager = (ICategorySelectionProfileManager) FwServiceFactory
			.getInstance().create(ICategorySelectionProfileManager.class);

	IRMCResponseProfileManager rmcResponseProfileManager = RMCResponseProfileManager.getInstance();

	private RMCHousingExpenseEJBBean rmcHousingExpenseEJBBean;

	public void storeHousingDetails(final FwTransaction txnBean) throws EligibilityScreenerException {

		final long startTime = System.currentTimeMillis();
		// log(ILog.INFO, "RMCHousingExpenseEJBBean.storeHousingDetails() - START");
		try {

			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();
			final int[] driverArray = (int[]) session.get(FwConstants.RMC_DRIVER);
			final String currentPageID = (String) request.get(FwConstants.CURRENT_PAGE_ID);
			final String appNumber = (String) session.get(AppConstants.APP_NUMBER);
			final List modifiedFields = (ArrayList) session.get(AppConstants.MODIFIED_FIELDS);
			final Map httpSessMap = (Map) session.get(FwConstants.HTTP_SESSION);
			final String currentLang = (String) httpSessMap.get(FwConstants.LANGUAGE);
			// build category selection profile
			final SortedSet categorySelectionProfile = (SortedSet) session
					.get(AppConstants.RMC_CATEGORY_PROFILE_MASTER);
			// get the BeforeCollection
			final RMC_IN_PRFL_Collection rmcInPrflColl = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);
			final Map beforeColl = (Map) session.get(FwConstants.BEFORE_COLLECTION);
		//	final PeopleHandler peopleHandler = (PeopleHandler) session.get(AppConstants.INDIV_MASTER_HANDLER);
			final SortedSet otherIncomeProfile = (SortedSet) beforeColl.get(AppConstants.RMC_CATEGORY_PAGE_PRFL);
			final AppInHouBillsCollection rmcInOthrIncCollection = (AppInHouBillsCollection) pageCollection
					.get("AppInHouBillsCollection");
			final IReferenceTableManager referenceTableManager = ReferenceTableManager.getInstance();
			AppInHouBillsCargo rmcInothrIncCargo = rmcInOthrIncCollection.getCargo(0);
			final CategorySequenceDetail categorySeqDetailBean = categorySelectionProfileManager
					.getCurrentSequenceDetail(otherIncomeProfile);
			final short userEndInd = categorySeqDetailBean.getUserEndSelectionInd();
			/*
			 * VG SONAR Cleanup - 09/1/2015 Deleted 1 lines Commented Code in this block
			 */

			final ARHousingBillDetailsBO otherIncBO = new ARHousingBillDetailsBO();
			final String backToMyAccess = (String) request.get(AppConstants.BACK_TO_MY_ACCESS_BUTTON);
			final String pageMode = (String) beforeColl.get("PAGE_MODE");

			final int driverStatus = driverManager.getAFBStatus(FwConstants.RMC_DRIVER,
					(String) request.get(FwConstants.CURRENT_PAGE_ID), driverArray);
			String changeEffDate = null;
			final AppInHouBillsCollection beforeCollRmcInOthIncColl = (AppInHouBillsCollection) beforeColl
					.get("AppInHouBillsCollection");
			AppInHouBillsCargo beforeOthrIncCargo = null;

			rmcInothrIncCargo.setApp_num(appNumber);

			if (rmcInothrIncCargo.getRec_cplt_ind() == null) {
				rmcInothrIncCargo.setRec_cplt_ind(FwConstants.ZERO);
			}
			final String indvSeqNum = String.valueOf(categorySeqDetailBean.getIndividualSequence());
			String sourceAppIndicator = null;
			String recordInd = null;

			// now we are checking for the before collection
			long seqNum = 0;
			boolean othrIncDetailsUpdate = false;

			if (beforeCollRmcInOthIncColl != null && !beforeCollRmcInOthIncColl.isEmpty()) {

				final int size = beforeCollRmcInOthIncColl.size();
				seqNum = categorySeqDetailBean.getCategorySequence();

				if ("C".equalsIgnoreCase(pageMode)) {
					sourceAppIndicator = AppConstants.RMC_MODIFIED_RECORD_IND;
				} else if ("E".equalsIgnoreCase(pageMode)) {
					sourceAppIndicator = AppConstants.RMC_END_RECORD_IND;
				} else {
					sourceAppIndicator = AppConstants.RMC_NEW_RECORD_IND;
				}

				beforeOthrIncCargo = otherIncBO.splitOtherIncColl(beforeCollRmcInOthIncColl, sourceAppIndicator);
				if (beforeOthrIncCargo == null && (sourceAppIndicator.equals(AppConstants.RMC_MODIFIED_RECORD_IND)
						|| sourceAppIndicator.equals(AppConstants.RMC_END_RECORD_IND))) {
					beforeOthrIncCargo = otherIncBO.splitOtherIncColl(beforeCollRmcInOthIncColl,
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
					if (sourceAppIndicator.equals(AppConstants.RMC_NEW_RECORD_IND) && beforeOthrIncCargo != null) {
						recordInd = FwConstants.ROWACTION_UPDATE;
					}
				}

				if (beforeOthrIncCargo != null) {
					// Source App Indicator set to 'RM' and the default values
					// for appInSelfeCargo populated from the before cargo
					rmcInothrIncCargo.setSrc_app_ind(beforeOthrIncCargo.getSrc_app_ind());
					rmcInothrIncCargo.setIndv_seq_num(beforeOthrIncCargo.getIndv_seq_num());
					rmcInothrIncCargo.setBill_type(beforeOthrIncCargo.getBill_type());
					rmcInothrIncCargo.setSeq_num(beforeOthrIncCargo.getSeq_num());
					rmcInothrIncCargo.setRec_cplt_ind(beforeOthrIncCargo.getRec_cplt_ind());
					if (rmcInothrIncCargo.getPymt_amt() == null) {
						rmcInothrIncCargo.setPymt_amt(beforeOthrIncCargo.getPymt_amt());
					}
					if (rmcInothrIncCargo.getPaid_amt() == null) {
						rmcInothrIncCargo.setPaid_amt(beforeOthrIncCargo.getPaid_amt());
					}
					if (rmcInothrIncCargo.getPymt_freq() == null) {
						rmcInothrIncCargo.setPymt_freq(beforeOthrIncCargo.getPymt_freq());
					}
					if (rmcInothrIncCargo.getProperty_name() == null) {
						rmcInothrIncCargo.setProperty_name(beforeOthrIncCargo.getProperty_name());
					}
					if (rmcInothrIncCargo.getProp_addr_l1() == null) {
						rmcInothrIncCargo.setProp_addr_l1(beforeOthrIncCargo.getProp_addr_l1());
					}
					if (rmcInothrIncCargo.getProp_addr_l2() == null) {
						rmcInothrIncCargo.setProp_addr_l2(beforeOthrIncCargo.getProp_addr_l2());
					}
					if (rmcInothrIncCargo.getProp_addr_city() == null) {
						rmcInothrIncCargo.setProp_addr_city(beforeOthrIncCargo.getProp_addr_city());
					}
					if (rmcInothrIncCargo.getProp_addr_state_cd() == null) {
						rmcInothrIncCargo.setProp_addr_state_cd(beforeOthrIncCargo.getProp_addr_state_cd());
					}
					if (rmcInothrIncCargo.getProp_addr_zip() == null) {
						rmcInothrIncCargo.setProp_addr_zip(beforeOthrIncCargo.getProp_addr_zip());
					}

					rmcInothrIncCargo.setEcp_id(beforeOthrIncCargo.getEcp_id());

				} else {

					final AppInHouBillsCargo beforeCargo = beforeCollRmcInOthIncColl.getCargo(0);
					rmcInothrIncCargo.setEcp_id(beforeCargo.getEcp_id());
				}

				if (rmcInothrIncCargo.getPymt_amt() != null
						&& rmcInothrIncCargo.getPymt_amt().equalsIgnoreCase(AppConstants.ON_FILE)) {
					rmcInothrIncCargo.setPymt_amt(beforeOthrIncCargo.getPymt_amt());
					if (modifiedFields.contains(rmcInothrIncCargo.getIndv_seq_num() + "_"
							+ rmcInothrIncCargo.getSeq_num() + "_" + "payment_amt")) {
						modifiedFields.remove(rmcInothrIncCargo.getIndv_seq_num() + "_" + rmcInothrIncCargo.getSeq_num()
								+ "_" + "payment_amt");
					}
				} else {
					if (modifiedFields != null && !modifiedFields.contains(rmcInothrIncCargo.getIndv_seq_num() + "_"
							+ rmcInothrIncCargo.getSeq_num() + "_" + "payment_amt")) {
						modifiedFields.add(rmcInothrIncCargo.getIndv_seq_num() + "_" + rmcInothrIncCargo.getSeq_num()
								+ "_" + "payment_amt");
					}
				}
				// check dirty
				rmcInothrIncCargo = (AppInHouBillsCargo) isChanged(beforeOthrIncCargo, rmcInothrIncCargo);
				if (rmcInothrIncCargo.isDirty()) {
					rmcInothrIncCargo.setSrc_app_ind(sourceAppIndicator);
					rmcInothrIncCargo.setRowAction(recordInd);

					rmcInothrIncCargo.setRec_cplt_ind(FwConstants.ONE);
					othrIncDetailsUpdate = true;
					// EDSP RMB

				}

				if (changeEffDate == null) {
					changeEffDate = AppConstants.HIGH_DATE;
				}

				rmcInothrIncCargo.setRec_cplt_ind(FwConstants.ONE);

			} else {

				sourceAppIndicator = AppConstants.RMC_NEW_RECORD_IND;
				rmcInothrIncCargo.setIndv_seq_num(String.valueOf(categorySeqDetailBean.getIndividualSequence()));
				// get the MAX seq number from data base
				seqNum = otherIncBO.getMaxSeqNumber(appNumber, indvSeqNum);
				seqNum = seqNum + 1;
				rmcInothrIncCargo.setSeq_num(String.valueOf(seqNum));
				rmcInothrIncCargo.setBill_type(categorySeqDetailBean.getCategoryType());
				/*
				 * VG SONAR Cleanup - 09/1/2015 Deleted 1 lines Commented Code in this block
				 */

				rmcInothrIncCargo.setSrc_app_ind(sourceAppIndicator);
				recordInd = FwConstants.ROWACTION_INSERT;
				rmcInothrIncCargo.setRowAction(recordInd);
				othrIncDetailsUpdate = true;
				// insert into RMC_SELECTION_PROFILE using Common Mehod()
				categorySelectionProfileManager.updateSequence(otherIncomeProfile, null,
						categorySeqDetailBean.getIndividualSequence(), seqNum, categorySeqDetailBean.getCategoryType());
				categorySelectionProfileManager.updateSequence(categorySelectionProfile, null,
						categorySeqDetailBean.getIndividualSequence(), seqNum, categorySeqDetailBean.getCategoryType());
				if (null != categorySeqDetailBean.getChangeSelectionCategoryCd()) {
					categorySelectionProfileManager.persistSequence(appNumber,
							categorySeqDetailBean.getChangeSelectionCategoryCd(),
							String.valueOf(categorySeqDetailBean.getIndividualSequence()), String.valueOf(seqNum),
							categorySeqDetailBean.getCategoryType(), "0");
				}
			}
			final String type = categorySeqDetailBean.getCategoryType();
			final String descToPass = referenceTableManager.getColumnValue("THBT", 59, type, currentLang);
			final ARXHDValidator arxhdValidator = new ARXHDValidator();
			if (backToMyAccess == null) {

				if (userEndInd == 1) {
					arxhdValidator.validateEndScreen(rmcInothrIncCargo);
				} else {
					arxhdValidator.validateHousePageContents(rmcInothrIncCargo, userEndInd, pageMode, request,
							beforeColl, currentLang, session, indvSeqNum, descToPass);
				}
			}

			if (checkBackToMyAccessSelected(request) || arxhdValidator.hasMessages()) {
				if (backToMyAccess == null) {
					request.put(FwConstants.MESSAGE_LIST, arxhdValidator.getMessageList());
				}
				pageCollection.put("BILL_TYPE", beforeColl.get("BILL_TYPE"));
				pageCollection.put("AppInHouBillsCollection", rmcInOthrIncCollection);
				pageCollection.put(AppConstants.FIRST_NAME, beforeColl.get(AppConstants.FIRST_NAME));
				if (request.get("loopingQuestion") != null) {
					pageCollection.put("loopingQuestion", request.get("loopingQuestion"));
				}
				pageCollection.put("showLoopingQuestion", beforeColl.get("showLoopingQuestion"));
				pageCollection.put(FwConstants.PAGE_COMPONENT_LIST, beforeColl.get(FwConstants.PAGE_COMPONENT_LIST));
				componentManager.getComponents("ARXHD", txnBean);
				/*
				 * createAndLoadARXHDResponseMapsToPageCollection(rmcInPrflColl, pageCollection,
				 * peopleHandler, true, driverStatus);
				 */
				pageCollection.put("PAGE_MODE", beforeColl.get("PAGE_MODE"));
				if (beforeColl.containsKey("SEC_BILL")) {
					pageCollection.put("SEC_BILL", beforeColl.get("SEC_BILL"));
				}
				pageCollection.put("FST_BILL", rmcInothrIncCargo);
				return;

			}
			if ("E".equalsIgnoreCase(pageMode)) {
				if (rmcInothrIncCargo.getEnd_dt() != null && rmcInothrIncCargo.getEnd_dt().contains("/")) {
					final String endDate = rmcInothrIncCargo.getEnd_dt().substring(0, 10);
					rmcInothrIncCargo.setEnd_dt(displayFormatter.getYYYYMMDDDate(endDate));
				}
			}
			if (othrIncDetailsUpdate) {
				if (rmcInothrIncCargo.getRowAction().equals(FwConstants.ROWACTION_INSERT)) {
					otherIncBO.insertExistingDetails(rmcInOthrIncCollection);
				} else {
					otherIncBO.storeHouseDetails(rmcInOthrIncCollection);
				}
			}

			boolean loopingQuestion = false;
			if (request.get("loopingQuestion") != null
					&& ((String) request.get("loopingQuestion")).equals(FwConstants.YES)) {
				loopingQuestion = true;
				// Insert into APP_IN_UEI
				categorySelectionProfileManager.insertSequenceDetail(otherIncomeProfile, null, null,
						categorySeqDetailBean.getIndividualSequence(), categorySeqDetailBean.getCategoryType());
				driverManager.makeRequired(FwConstants.RMC_DRIVER, currentPageID, driverArray, appNumber);
				driverManager.makeRequired(FwConstants.RMC_DRIVER, "ARXHS", driverArray, appNumber);
			}

			// reqInd is indicator to decide if we have complete the response profile or not
			boolean reqInd = false;

			if (!loopingQuestion) {
//				short respTyp=IRMCResponseProfileManager.PAY_HOUSING_BILL;
				short respTyp = rmcResponseProfileManager.getResponseByType(
						IRMCResponseProfileManager.SHELTER_COST_DETAILS, categorySeqDetailBean.getCategoryType());
				final RMC_IN_PRFL_Cargo rmcInPrflCargo = rmcResponseProfileManager.getProfile(rmcInPrflColl,
						String.valueOf(categorySeqDetailBean.getIndividualSequence()));
				if (rmcInPrflCargo != null
						&& rmcResponseProfileManager.getProfileResponse(rmcInPrflCargo, respTyp)
								.charAt(0) == IRMCResponseProfileManager.STATUS_REQUIRED
						|| rmcResponseProfileManager.getProfileResponse(rmcInPrflCargo, respTyp)
								.charAt(0) == IRMCResponseProfileManager.STATUS_ADD_NEW) {
					reqInd = true;
					rmcResponseProfileManager.makeComplete(
							rmcResponseProfileManager.getResponseByType(IRMCResponseProfileManager.SHELTER_COST_DETAILS,
									categorySeqDetailBean.getCategoryType()),
							rmcInPrflCargo, true);
					rmcResponseProfileManager.makeComplete(IRMCResponseProfileManager.PAY_HOUSING_BILL, rmcInPrflCargo,
							true);
				}
			}

			// Mark complete otherinc sequence using common methods
			// if the profile response was not 'R' or if we came from gatepost then don't
			// persist else persist
			if (!reqInd || categorySeqDetailBean.getChangeSelectionCategoryCd() == null) {
				categorySelectionProfileManager.makeSequenceDetailComplete(otherIncomeProfile, null,
						categorySeqDetailBean.getIndividualSequence(), categorySeqDetailBean.getCategorySequence(),
						categorySeqDetailBean.getCategoryType());
			} else {
				categorySelectionProfileManager.makeSequenceDetailComplete(otherIncomeProfile, appNumber,
						categorySeqDetailBean.getIndividualSequence(), categorySeqDetailBean.getCategorySequence(),
						categorySeqDetailBean.getCategoryType());
			}

			if (categorySelectionProfile != null) {
				categorySelectionProfileManager.makeSequenceDetailComplete(categorySelectionProfile, appNumber,
						categorySeqDetailBean.getIndividualSequence(), categorySeqDetailBean.getCategorySequence(),
						categorySeqDetailBean.getCategoryType());
			}
			if (categorySelectionProfileManager.areAllSequencesComplete(otherIncomeProfile)) {
				driverManager.makeComplete(FwConstants.RMC_DRIVER, currentPageID, driverArray, appNumber);
			} else {
				categorySelectionProfileManager.getNextSequenceDetail(otherIncomeProfile);
			}
			// Removing the indvSeqBean from session
			final IndivTypeSeqBean indivSeqBean = (IndivTypeSeqBean) session.get(FwConstants.DETAIL_KEY_BEAN);
			if (indivSeqBean != null) {
				if (indivSeqBean.getIndivSeqNum().equals(rmcInothrIncCargo.getIndv_seq_num())
						&& indivSeqBean.getSeqNum().equals(rmcInothrIncCargo.getSeq_num())
						&& indivSeqBean.getType().equals(rmcInothrIncCargo.getBill_type())) {
					session.remove(FwConstants.DETAIL_KEY_BEAN);
				}
			}

		} catch (final FwException fe) {
		} catch (final Exception e) {

		}

	}

	@Override
	public void saveEligibiltyQuestions(FwTransaction txnBean) throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * Creates the and load arxhd response maps to page collection.
	 *
	 * @param appInPrflColl  the app in prfl coll
	 * @param pageCollection the page collection
	 * @param peopleHandler  the people handler
	 * @param pageLoad       the page load
	 * @param driverStatus   the driver status
	 * @return Map
	 */
	/*
	 * private Map createAndLoadARXHDResponseMapsToPageCollection(final
	 * RMC_IN_PRFL_Collection appInPrflColl, final Map pageCollection, final
	 * PeopleHandler peopleHandler, final boolean pageLoad, final int driverStatus)
	 * { final long startTime = System.currentTimeMillis(); try {
	 * getPeopleCollectionAndUpdateMapsARXHD(appInPrflColl, pageCollection,
	 * peopleHandler, "56", IRMCResponseProfileManager.HEAD_OF_HOUSE, pageLoad,
	 * driverStatus, false);
	 * 
	 * 
	 * // exit } catch (final FwException fe) { } catch (final Exception e) { }
	 * return pageCollection; }
	 */

	/*
	 * public Map getPeopleCollectionAndUpdateMapsARXHD(final RMC_IN_PRFL_Collection
	 * appInPrflColl, final Map pageCollection, final PeopleHandler peopleHandler,
	 * final String compID, final short questionName, final boolean pageLoad, final
	 * int driverStatus, final boolean getRelevant) { final long startTime =
	 * System.currentTimeMillis(); try { // Declarations String indivSeqNum = null;
	 * INDIVIDUAL_Custom_Cargo indivCargo; INDIVIDUAL_Custom_Collection indivColl;
	 * final StringBuilder indivCollKey = new StringBuilder();
	 * indivCollKey.append(AppConstants.PEOPLE); indivCollKey.append(compID);
	 * 
	 * // try to get a filtered list. If it doesn't exist, get the // peopleHandler
	 * getIndividuals
	 * 
	 * if (pageCollection.get(indivCollKey.toString()) == null) { indivColl =
	 * peopleHandler.getAllIndividuals(); if (getRelevant) { indivColl =
	 * peopleHandler.getRelevantIndividuals(); } else { indivColl =
	 * peopleHandler.getAllIndividuals(); } } else { indivColl =
	 * (INDIVIDUAL_Custom_Collection) pageCollection.get(indivCollKey.toString()); }
	 * 
	 * // set the passed response map = new map final Map questionRespMap = new
	 * HashMap();
	 * 
	 * // create an appInPrfl object RMC_IN_PRFL_Cargo appInPrflCargo = null;
	 * 
	 * // get size of the collection final int indivCollSize = indivColl.size();
	 * 
	 * // Define NoOneChecked = YES flags for the question String noOneChecked =
	 * FwConstants.YES;
	 * 
	 * // Loop for each Cargo in the people collection (for each person) for (int i
	 * = 0; i < indivCollSize; i++) { // get the indivCargo indivCargo =
	 * (INDIVIDUAL_Custom_Cargo) indivColl.get(i);
	 * 
	 * // get app_indiv_seq_num indivSeqNum = indivCargo.getIndv_seq_num();
	 * 
	 * // Get the appInPrflCargo for this person appInPrflCargo =
	 * rmcResponseProfileManager.getProfile(appInPrflColl, indivSeqNum);
	 * 
	 * // get the AIP Response for the given question from this cargo final String
	 * questionResp = rmcResponseProfileManager.getProfileResponse(appInPrflCargo,
	 * questionName);
	 * 
	 * // for this question, add the person's response to a map
	 * questionRespMap.put(indivSeqNum, questionResp);
	 * 
	 * if (pageLoad == true) { // for each question, set the noOneChecked flag //
	 * check if there is anything other than not required - if // so, change flag if
	 * (questionResp.charAt(0) != IRMCResponseProfileManager.STATUS_NOT_REQUIRED) {
	 * noOneChecked = FwConstants.NO; } }
	 * 
	 * } // end for loop
	 * 
	 * if (pageLoad == true) { if (driverStatus == FwConstants.DRIVER_REQUIRED) {
	 * noOneChecked = FwConstants.NO; }
	 * 
	 * // get the NoOneChecked map from the pagecollection Map noOneCheckedMap =
	 * (Map) pageCollection.get(AppConstants.NO_ONE_CHECKED_MAP); if
	 * (noOneCheckedMap == null) { noOneCheckedMap = new HashMap(); }
	 * 
	 * // update the noOneCheckedMap and re-add it to the page coll final
	 * StringBuilder noOneCheckedString = new StringBuilder();
	 * noOneCheckedString.append(AppConstants.NO_ONE_CHECKED);
	 * noOneCheckedString.append(compID);
	 * noOneCheckedMap.put(noOneCheckedString.toString(), noOneChecked);
	 * pageCollection.put(AppConstants.NO_ONE_CHECKED_MAP, noOneCheckedMap); }
	 * 
	 * // Store all maps in page collection final StringBuilder respMapString = new
	 * StringBuilder(); respMapString.append(AppConstants.RESP_MAP);
	 * respMapString.append(compID); pageCollection.put(respMapString.toString(),
	 * questionRespMap);
	 * 
	 * // store people collection in page collection final StringBuilder
	 * peopleString = new StringBuilder(); peopleString.append(AppConstants.PEOPLE);
	 * peopleString.append(compID); pageCollection.put(peopleString.toString(),
	 * indivColl);
	 * 
	 * 
	 * return pageCollection; // exit } catch (final FwException fe) {} catch (final
	 * Exception e) {} return pageCollection; }
	 */	public boolean checkBackToMyAccessSelected(final Map request) {
		try {
			if (request.get(AppConstants.BACK_TO_MY_ACCESS_BUTTON) == null) {
				return false;
			}
			final String reqWarningMsgs = (String) request
					.get(FwConstants.WARNING_MSG_DETAILS);
			if ((reqWarningMsgs != null)
					&& (reqWarningMsgs.trim().length() > 0)) {
				// Tokenizing the request warrning message and putting into a
				// list
				final StringTokenizer tokenizer = new StringTokenizer(
						reqWarningMsgs, TILDE);
				final List reqMsgList = new ArrayList();
				while (tokenizer.hasMoreElements()) {
					reqMsgList.add(tokenizer.nextElement());
				}
				if (reqMsgList.contains(MSG_30075)) {
					return true;
				}
			}
			final FwMessageList messageList = new FwMessageList();
			final FwMessage message = new FwMessage();
			message.addMessageCode(MSG_30075);
			messageList.addMessageToList(message);
			request.put(FwConstants.MESSAGE_LIST, messageList);
			return true;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw e;
		}
	}
	
	/**
	 * returns AfterCargo and dirty is true if cargo's are different. Creation
	 * date: (06/03/2004 12:00:00 AM)
	 *
	 * @param aBeforeCargo
	 *            ICargo
	 * @param aAfterCargo
	 *            ICargo
	 * @return ICargo
	 */
	protected ICargo isChanged(final ICargo aBeforeCargo, final ICargo aAfterCargo) throws FwException {

		try {
			if (aBeforeCargo == aAfterCargo) {
				aAfterCargo.setDirty(false);
			} else {
				/*aAfterCargo.setDirty((aBeforeCargo == null) ? ((aAfterCargo == null) ? false : true) : (aAfterCargo == null) ? true : (aBeforeCargo
						.hashCode() != aAfterCargo.hashCode()));*/
				
				if(null != aAfterCargo){
					if((aBeforeCargo==null) || (aBeforeCargo.hashCode() != aAfterCargo.hashCode())){
						aAfterCargo.setDirty(true);
					}					
					else aAfterCargo.setDirty(false);	
				}
			}
			return aAfterCargo;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw e;
		}
	}
}
