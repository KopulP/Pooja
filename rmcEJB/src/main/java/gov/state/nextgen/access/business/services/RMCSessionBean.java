/*
 *
 */
package gov.state.nextgen.access.business.services;

import gov.state.nextgen.access.business.customEntities.INDIVIDUAL_Custom_Cargo;
import gov.state.nextgen.access.business.customEntities.INDIVIDUAL_Custom_Collection;
import gov.state.nextgen.access.business.entities.NO_ONE_Cargo;
import gov.state.nextgen.access.business.entities.NO_ONE_Collection;
import gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Cargo;
import gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Collection;
import gov.state.nextgen.access.management.applications.CategorySequenceDetail;
import gov.state.nextgen.access.management.applications.CategorySequenceDetailsComparator;
import gov.state.nextgen.access.management.applications.IApplicationManager;
import gov.state.nextgen.access.management.applications.IRMCResponseProfileManager;
import gov.state.nextgen.access.management.constants.AppConstants;
import gov.state.nextgen.access.management.individuals.PeopleHandler;
import gov.state.nextgen.framework.business.entities.FwTransaction;
import gov.state.nextgen.framework.exceptions.FwException;
import gov.state.nextgen.framework.exceptions.FwWrappedException;
import gov.state.nextgen.framework.management.constants.FwConstants;
import gov.state.nextgen.framework.management.logging.ILog;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 * This class contains methods that can be used by EJB beans throughout RMC
 * project. These are common actions that are used througout RMC pages.
 *
 * @author Architecture Team Creation Date Feb 7, 2007 Modified By: Modified on:
 *         PCR#
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class RMCSessionBean extends AppSessionBeanEjb3 {

	@EJB
	private RMCSessionBean rmcSessionBean;
	/**
	 * Compare RmcInPrflBeforeColl and PageCollection and returns updated
	 * pageCollection with dummy cargo if not found in session.
	 *
	 * @param rmcInPrflCollSession the rmc in prfl coll session
	 * @param pageColl the page coll
	 * @return the RM c_ i n_ prf l_ collection
	 */
	public RMC_IN_PRFL_Collection compareRmcInPrflColl(
			final RMC_IN_PRFL_Collection rmcInPrflCollSession,
			final RMC_IN_PRFL_Collection pageColl) {
		try {
			final int pageCollSize = pageColl.size();
			final int sessionSize = rmcInPrflCollSession.size();
			RMC_IN_PRFL_Cargo beforeCargo = null;
			RMC_IN_PRFL_Cargo afterCargo = null;
			boolean found = false;
			final RMC_IN_PRFL_Collection rmcInPrflCollRequest = new RMC_IN_PRFL_Collection();
			for (int i = 0; i < sessionSize; i++) {
				found = false;
				beforeCargo = rmcInPrflCollSession.getCargo(i);
				for (int j = 0; j < pageCollSize; j++) {
					afterCargo = pageColl.getCargo(j);
					if (beforeCargo.getIndv_seq_num().equals(
							afterCargo.getIndv_seq_num())) {
						rmcInPrflCollRequest.add(afterCargo);
						found = true;
						break;
					}
				}
				if (!found) {
					afterCargo = new RMC_IN_PRFL_Cargo();
					afterCargo.setIndv_seq_num(beforeCargo.getIndv_seq_num());
					rmcInPrflCollRequest.add(afterCargo);
				}
			}
			return rmcInPrflCollRequest;

		} catch (final FwException fe) {
			throw rmcSessionBean.exceptionManagerLog(fe, getClass().getName(), "compareRmcInPrflColl");
		} catch (final Exception e) {
			final FwException fe = createFwException(this.getClass().getName(),
					"compareRmcInPrflColl", e);
			throw rmcSessionBean.exceptionManagerLog(fe, getClass().getName(), "compareRmcInPrflColl");
		}

	}

	/**
	 * Creates the page profile.
	 *
	 * @param categorySelectionProfile the category selection profile
	 * @param rmcInPrflColl the rmc in prfl coll
	 * @param responseType the response type
	 * @return the sorted set
	 */
	/*
	 * Creates the Page Category Selection Profile form the RMC_IN_PRFL,
	 * Category Selection Profile
	 */
	public SortedSet createPageProfile(
			final SortedSet categorySelectionProfile,
			final RMC_IN_PRFL_Collection rmcInPrflColl,
			final short[] responseType) {
		try {
			int rmcInPrflCollSize = 0;
			if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
				rmcInPrflCollSize = rmcInPrflColl.size();
			}
			final int responseArraySize = responseType.length;
			RMC_IN_PRFL_Cargo rmcInPrflCargo = null;
			final SortedSet catSelProfile = new TreeSet(
					new CategorySequenceDetailsComparator());
			if (categorySelectionProfile != null) {
				// this one form the category selection profile
				final Iterator iter = categorySelectionProfile.iterator();
				CategorySequenceDetail categorySeqDtl = null;
				while (iter.hasNext()) {
					categorySeqDtl = (CategorySequenceDetail) iter.next();
					for (int i = 0; i < responseArraySize; i++) {
						if (categorySeqDtl.getCategoryType().equals(
								rmcResponseProfileManager
								.getTypeByResponse(responseType[i]))
								&& categorySeqDtl.getStatus() != IRMCResponseProfileManager.STATUS_NOT_REQUIRED) {
							catSelProfile.add(categorySeqDtl);
							break;
						}
					}
				}
			}

			// this one form the rmc in profile
			for (int j = 0; j < rmcInPrflCollSize; j++) {
				rmcInPrflCargo = rmcInPrflColl.getCargo(j);
				for (int i = 0; i < responseArraySize; i++) {
					// PCR 30729 - For Job Income details page when another job
					// is added for the same indiv from Summary page,
					// the detail page will be scheduled in visit again mode.
					// Added check for visit again mode too, in order
					// to have an empty profile created in that case too.
					if (null != rmcResponseProfileManager.getProfileResponse(
							rmcInPrflCargo, responseType[i])
							&& (rmcResponseProfileManager.getProfileResponse(
								rmcInPrflCargo, responseType[i]).charAt(0) == IRMCResponseProfileManager.STATUS_REQUIRED)) {
						categorySelectionProfileManager.insertSequenceDetail(
								catSelProfile, null, null, Short
								.parseShort(rmcInPrflCargo
										.getIndv_seq_num()),
										rmcResponseProfileManager
										.getTypeByResponse(responseType[i]));
					}
				}
			}

			return catSelProfile;
		} catch (final FwException fe) {
			throw rmcSessionBean.exceptionManagerLog(fe, getClass().getName(), "createPageProfile");
		} catch (final Exception e) {
			final FwException fe = createFwException(this.getClass().getName(),
					"createPageProfile", e);
			throw rmcSessionBean.exceptionManagerLog(fe, getClass().getName(), "createPageProfile");
		}
	}

	/**
	 * Creates the other income page profile.
	 *
	 * @param categorySelectionProfile the category selection profile
	 * @param rmcInPrflColl the rmc in prfl coll
	 * @param responseType the response type
	 * @return the sorted set
	 */
	public SortedSet createOtherIncomePageProfile(
			final SortedSet categorySelectionProfile,
			final RMC_IN_PRFL_Collection rmcInPrflColl,
			final short[] responseType) {
		try {
			int rmcInPrflCollSize = 0;
			if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
				rmcInPrflCollSize = rmcInPrflColl.size();
			}
			final int responseArraySize = responseType.length;
			RMC_IN_PRFL_Cargo rmcInPrflCargo = null;
			final SortedSet catSelProfile = new TreeSet(
					new CategorySequenceDetailsComparator());
			if (categorySelectionProfile != null) {
				// this one form the category selection profile
				final Iterator iter = categorySelectionProfile.iterator();
				CategorySequenceDetail categorySeqDtl = null;
				while (iter.hasNext()) {
					categorySeqDtl = (CategorySequenceDetail) iter.next();
					for (int i = 0; i < responseArraySize; i++) {
						if (categorySeqDtl
								.getCategoryType()
								.equals(rmcResponseProfileManager
										.getOtherIncomeTypeByResponse(responseType[i]))
										&& categorySeqDtl.getStatus() != IRMCResponseProfileManager.STATUS_NOT_REQUIRED) {
							catSelProfile.add(categorySeqDtl);
							break;
						}
					}
				}
			}

			// this one form the rmc in profile
			for (int j = 0; j < rmcInPrflCollSize; j++) {
				rmcInPrflCargo = rmcInPrflColl.getCargo(j);
				for (int i = 0; i < responseArraySize; i++) {
					// PCR 30729 - For Job Income details page when another job
					// is added for the same indiv from Summary page,
					// the detail page will be scheduled in visit again mode.
					// Added check for visit again mode too, in order
					// to have an empty profile created in that case too.
					if (null != rmcResponseProfileManager.getProfileResponse(
							rmcInPrflCargo, responseType[i]) 
							&& (rmcResponseProfileManager.getProfileResponse(
								rmcInPrflCargo, responseType[i]).charAt(0) == IRMCResponseProfileManager.STATUS_REQUIRED)) {
						categorySelectionProfileManager
						.insertSequenceDetail(
								catSelProfile,
								null,
								null,
								Short.parseShort(rmcInPrflCargo
										.getIndv_seq_num()),
										rmcResponseProfileManager
										.getOtherIncomeTypeByResponse(responseType[i]));
					}
				}
			}

			return catSelProfile;
		} catch (final FwException fe) {
			throw rmcSessionBean.exceptionManagerLog(fe, getClass().getName(), "createOtherIncomePageProfile");
		} catch (final Exception e) {
			final FwException fe = createFwException(this.getClass().getName(),
					"createPageProfile", e);
			throw rmcSessionBean.exceptionManagerLog(fe, getClass().getName(), "createOtherIncomePageProfile");
		}
	}

	/**
	 * Creates the housing bills page profile.
	 *
	 * @param categorySelectionProfile the category selection profile
	 * @param rmcInPrflColl the rmc in prfl coll
	 * @param responseType the response type
	 * @return the sorted set
	 */
	public SortedSet createHousingBillsPageProfile(
			final SortedSet categorySelectionProfile,
			final RMC_IN_PRFL_Collection rmcInPrflColl,
			final short[] responseType) {
		try {
			int rmcInPrflCollSize = 0;
			if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
				rmcInPrflCollSize = rmcInPrflColl.size();
			}
			final int responseArraySize = responseType.length;
			RMC_IN_PRFL_Cargo rmcInPrflCargo = null;
			final SortedSet catSelProfile = new TreeSet(
					new CategorySequenceDetailsComparator());
			if (categorySelectionProfile != null) {
				// this one form the category selection profile
				final Iterator iter = categorySelectionProfile.iterator();
				CategorySequenceDetail categorySeqDtl = null;
				while (iter.hasNext()) {
					categorySeqDtl = (CategorySequenceDetail) iter.next();
					for (int i = 0; i < responseArraySize; i++) {
						if (categorySeqDtl
								.getCategoryType()
								.equals(rmcResponseProfileManager
										.geHousingBillsTypeByResponse(responseType[i]))
										&& categorySeqDtl.getStatus() != IRMCResponseProfileManager.STATUS_NOT_REQUIRED) {
							catSelProfile.add(categorySeqDtl);
							break;
						}
					}
				}
			}

			// this one form the rmc in profile
			for (int j = 0; j < rmcInPrflCollSize; j++) {
				rmcInPrflCargo = rmcInPrflColl.getCargo(j);
				for (int i = 0; i < responseArraySize; i++) {
					// PCR 30729 - For Job Income details page when another job
					// is added for the same indiv from Summary page,
					// the detail page will be scheduled in visit again mode.
					// Added check for visit again mode too, in order
					// to have an empty profile created in that case too.
					if (null != rmcResponseProfileManager.getProfileResponse(
							rmcInPrflCargo, responseType[i]) 
							&& (rmcResponseProfileManager.getProfileResponse(
								rmcInPrflCargo, responseType[i]).charAt(0) == IRMCResponseProfileManager.STATUS_REQUIRED)) {
						categorySelectionProfileManager
						.insertSequenceDetail(
								catSelProfile,
								null,
								null,
								Short.parseShort(rmcInPrflCargo
										.getIndv_seq_num()),
										rmcResponseProfileManager
										.geHousingBillsTypeByResponse(responseType[i]));
					}
				}
			}

			return catSelProfile;
		} catch (final FwException fe) {
			throw rmcSessionBean.exceptionManagerLog(fe, getClass().getName(), "createHousingBillsPageProfile");
		} catch (final Exception e) {
			final FwException fe = createFwException(this.getClass().getName(),
					"createPageProfile", e);
			throw rmcSessionBean.exceptionManagerLog(fe, getClass().getName(), "createHousingBillsPageProfile");
		}
	}

	/**
	 * Creates the page profile liquid.
	 *
	 * @param categorySelectionProfile the category selection profile
	 * @param rmcInPrflColl the rmc in prfl coll
	 * @param responseType the response type
	 * @return the sorted set
	 */
	public SortedSet createPageProfileLiquid(
			final SortedSet categorySelectionProfile,
			final RMC_IN_PRFL_Collection rmcInPrflColl,
			final short[] responseType) {
		try {
			int rmcInPrflCollSize = 0;
			if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
				rmcInPrflCollSize = rmcInPrflColl.size();
			}
			final int responseArraySize = responseType.length;
			RMC_IN_PRFL_Cargo rmcInPrflCargo = null;
			final SortedSet catSelProfile = new TreeSet(
					new CategorySequenceDetailsComparator());
			if (categorySelectionProfile != null) {
				// this one form the category selection profile
				final Iterator iter = categorySelectionProfile.iterator();
				CategorySequenceDetail categorySeqDtl = null;
				while (iter.hasNext()) {
					categorySeqDtl = (CategorySequenceDetail) iter.next();
					for (int i = 0; i < responseArraySize; i++) {
						if (categorySeqDtl
								.getCategoryType()
								.equals(rmcResponseProfileManager
										.getLiquidResourceTypeByResponse(responseType[i]))
										&& categorySeqDtl.getStatus() != IRMCResponseProfileManager.STATUS_NOT_REQUIRED) {
							catSelProfile.add(categorySeqDtl);
							break;
						}
					}
				}
			}

			// this one form the rmc in profile
			for (int j = 0; j < rmcInPrflCollSize; j++) {
				rmcInPrflCargo = rmcInPrflColl.getCargo(j);
				for (int i = 0; i < responseArraySize; i++) {
					// PCR 30729 - For Job Income details page when another job
					// is added for the same indiv from Summary page,
					// the detail page will be scheduled in visit again mode.
					// Added check for visit again mode too, in order
					// to have an empty profile created in that case too.
					if (null != rmcResponseProfileManager.getProfileResponse(
							rmcInPrflCargo, responseType[i])
							&& (rmcResponseProfileManager.getProfileResponse(
								rmcInPrflCargo, responseType[i]).charAt(0) == IRMCResponseProfileManager.STATUS_REQUIRED)) {
						categorySelectionProfileManager.insertSequenceDetail(
								catSelProfile, null, null, Short
								.parseShort(rmcInPrflCargo
										.getIndv_seq_num()),
										rmcResponseProfileManager
										.getTypeByResponse(responseType[i]));
					}
				}
			}

			return catSelProfile;
		} catch (final FwException fe) {
			throw rmcSessionBean.exceptionManagerLog(fe, getClass().getName(), "createPageProfileLiquid");
		} catch (final Exception e) {
			final FwException fe = createFwException(this.getClass().getName(),
					"createPageProfile", e);
			throw rmcSessionBean.exceptionManagerLog(fe, getClass().getName(), "createPageProfileLiquid");
		}
	}

	/**
	 * Creates the page profile tax.
	 *
	 * @param categorySelectionProfile the category selection profile
	 * @param rmcInPrflColl the rmc in prfl coll
	 * @param responseType the response type
	 * @return the sorted set
	 */
	public SortedSet createPageProfileTax(
			final SortedSet categorySelectionProfile,
			final RMC_IN_PRFL_Collection rmcInPrflColl,
			final short[] responseType) {
		try {
			int rmcInPrflCollSize = 0;
			if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
				rmcInPrflCollSize = rmcInPrflColl.size();
			}
			final int responseArraySize = responseType.length;
			RMC_IN_PRFL_Cargo rmcInPrflCargo = null;
			final SortedSet catSelProfile = new TreeSet(
					new CategorySequenceDetailsComparator());
			if (categorySelectionProfile != null) {
				// this one form the category selection profile
				final Iterator iter = categorySelectionProfile.iterator();
				CategorySequenceDetail categorySeqDtl = null;
				while (iter.hasNext()) {
					categorySeqDtl = (CategorySequenceDetail) iter.next();
					for (int i = 0; i < responseArraySize; i++) {
						if (categorySeqDtl.getCategoryType().equals(
								rmcResponseProfileManager
								.getTaxTypeByResponse(responseType[i]))
								&& categorySeqDtl.getStatus() != IRMCResponseProfileManager.STATUS_NOT_REQUIRED) {
							catSelProfile.add(categorySeqDtl);
							break;
						}
					}
				}
			}

			// this one form the rmc in profile
			for (int j = 0; j < rmcInPrflCollSize; j++) {
				rmcInPrflCargo = rmcInPrflColl.getCargo(j);
				for (int i = 0; i < responseArraySize; i++) {
					// PCR 30729 - For Job Income details page when another job
					// is added for the same indiv from Summary page,
					// the detail page will be scheduled in visit again mode.
					// Added check for visit again mode too, in order
					// to have an empty profile created in that case too.
					if (null != rmcResponseProfileManager.getProfileResponse(
							rmcInPrflCargo, responseType[i])
							&& (rmcResponseProfileManager.getProfileResponse(
								rmcInPrflCargo, responseType[i]).charAt(0) == IRMCResponseProfileManager.STATUS_REQUIRED)) {
						categorySelectionProfileManager.insertSequenceDetail(
								catSelProfile, null, null, Short
								.parseShort(rmcInPrflCargo
										.getIndv_seq_num()),
										rmcResponseProfileManager
										.getTypeByResponse(responseType[i]));
					}
				}
			}

			return catSelProfile;
		} catch (final FwException fe) {
			throw rmcSessionBean.exceptionManagerLog(fe, getClass().getName(), "createPageProfileTax");
		} catch (final Exception e) {
			final FwException fe = createFwException(this.getClass().getName(),
					"createPageProfile", e);
			throw rmcSessionBean.exceptionManagerLog(fe, getClass().getName(), "createPageProfileTax");
		}
	}

	/**
	 * Creates the page profile.
	 *
	 * @param categorySelectionProfile the category selection profile
	 * @param catType the cat type
	 * @return the sorted set
	 */
	/*
	 * Creates the Page Category Selection Profile form Category Selection
	 * Profile
	 */
	public SortedSet createPageProfile(
			final SortedSet categorySelectionProfile, final String[] catType) {
		try {
			final int catTypeSize = catType.length;
			final SortedSet catSelProfile = new TreeSet(
					new CategorySequenceDetailsComparator());
			if (categorySelectionProfile != null) {
				final Iterator iter = categorySelectionProfile.iterator();
				CategorySequenceDetail categorySeqDtl = null;
				while (iter.hasNext()) {
					categorySeqDtl = (CategorySequenceDetail) iter.next();
					for (int i = 0; i < catTypeSize; i++) {
						if (categorySeqDtl.getCategoryType().equals(catType[i])
								&& categorySeqDtl.getUserEndSelectionInd() != AppConstants.RMB_NO_CHANGE_SEL_IND) {
							catSelProfile.add(categorySeqDtl);
							break;
						}
					}
				}
			}
			return catSelProfile;
		} catch (final FwException fe) {
			throw rmcSessionBean.exceptionManagerLog(fe, getClass().getName(), "createPageProfile");
		} catch (final Exception e) {
			final FwException fe = createFwException(this.getClass().getName(),
					"createPageProfile", e);
			throw rmcSessionBean.exceptionManagerLog(fe, getClass().getName(), "createPageProfile");
		}

	}

	/**
	 * This will load the following information into page collection. This
	 * method is generally used for loading Type jsp pages.
	 *
	 * RMC_IN_PRFL_Collection: This is a collection of the profiles for each
	 * individual in the people handler FIRST_NAME_LIST: A list of first names
	 * for each individual in the peoplehandler
	 *
	 * @param txnBean
	 *            A transfer object
	 * @param responseId
	 *            A short that indicates which question these types are being
	 *            loaded for
	 * @param pageCollectionPrefix
	 *            A String prefix used to store the above information in the
	 *            page collection
	 */
	public void loadTypes(final FwTransaction txnBean, final short responseId,
			final String pageCollectionPrefix) {

		try {
			log(ILog.INFO, "RMCSessionBean::loadTypes:Start");
			final Map session = txnBean.getSession();
			final Map request = txnBean.getRequest();
			final Map pageCollection = txnBean.getPageCollection();

			final PeopleHandler peopleHandler = (PeopleHandler) session
					.get(AppConstants.INDIV_MASTER_HANDLER);
			INDIVIDUAL_Custom_Collection indvCustColl = peopleHandler
					.getInHomeIndividuals();
			indvCustColl = peopleHandler.sortIndividuals(indvCustColl);

			RMC_IN_PRFL_Cargo rmcInPrflCargo = null;
			final RMC_IN_PRFL_Collection sessionRIPCollection = (RMC_IN_PRFL_Collection) session
					.get(AppConstants.RMC_IN_PRFL_MASTER);

			final RMC_IN_PRFL_Collection rmcInPrflColl = new RMC_IN_PRFL_Collection();
			final NO_ONE_Collection noOneCollection = new NO_ONE_Collection();

			final int size = indvCustColl.size();

			String indivSeqNum = null;
			String firstName = null;
			String response = null;
			final Map firstNameList = new HashMap();

			for (int i = 0; i < size; i++) {
				// get cargo in the collection
				final INDIVIDUAL_Custom_Cargo indvCargo = indvCustColl
						.getResult(i);
				rmcInPrflCargo = rmcResponseProfileManager.getProfile(
						sessionRIPCollection, indvCargo.getIndv_seq_num());

				// get app_indiv_seq_num,firstName,response
				indivSeqNum = rmcInPrflCargo.getIndv_seq_num();
				firstName = peopleHandler.getFirstName(indivSeqNum);

				response = rmcResponseProfileManager.getProfileResponse(
						rmcInPrflCargo, responseId);
				final NO_ONE_Cargo noOneOtherIncCargo = new NO_ONE_Cargo();

				// get response flag
				// Added check with space for newly added individuals with
				// response as space
				if (null != response && response.charAt(0) != IApplicationManager.STATUS_NOT_REQUIRED
						&& response.charAt(0) != FwConstants.SPACE.charAt(0)) {
					firstNameList.put(indivSeqNum, firstName);
					rmcInPrflColl.addCargo(rmcInPrflCargo);
					noOneOtherIncCargo.setNo_one_name(indivSeqNum);
					noOneOtherIncCargo.setNo_one_value(String
							.valueOf(IApplicationManager.STATUS_NOT_REQUIRED));
					noOneCollection.addCargo(noOneOtherIncCargo);
				}
			}

			pageCollection.put(
					pageCollectionPrefix + "_RMC_IN_PRFL_COLLECTION",
					rmcInPrflColl);
			pageCollection.put(pageCollectionPrefix + "_FIRST_NAME_LIST",
					firstNameList);
			pageCollection.put(pageCollectionPrefix + "_NO_ONE_COLLECTION",
					noOneCollection);

			// Run ComponentManager to get list of components
			componentManager.getComponents(
					(String) request.get(FwConstants.CURRENT_PAGE_ID), txnBean);

			// Add the page collection to before collection
			session.put(FwConstants.BEFORE_COLLECTION, pageCollection);
			txnBean.setPageCollection(pageCollection);
			txnBean.setSession(session);
			log(ILog.INFO, "RMCSessionBean::loadTypes:End");

		} catch (final FwException fe) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("loadTypes");
			we.setFwException(fe);
			throw rmcSessionBean.exceptionManagerLog(fe, getClass().getName(), "loadTypes");
		} catch (final Exception e) {
			if (ctx != null) {
				ctx.setRollbackOnly();
			}
			final FwException fe = createFwException(this.getClass().getName(),
					"loadTypes", e);
			throw rmcSessionBean.exceptionManagerLog(fe, getClass().getName(), "loadTypes");
		}
	}

	/**
	 * Creates the people page profile.
	 *
	 * @param categorySelectionProfile the category selection profile
	 * @param rmcInPrflColl the rmc in prfl coll
	 * @param responseType the response type
	 * @return the sorted set
	 */
	public SortedSet createPeoplePageProfile(
			final SortedSet categorySelectionProfile,
			final RMC_IN_PRFL_Collection rmcInPrflColl,
			final short[] responseType) {
		try {
			int rmcInPrflCollSize = 0;
			if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
				rmcInPrflCollSize = rmcInPrflColl.size();
			}
			final int responseArraySize = responseType.length;
			RMC_IN_PRFL_Cargo rmcInPrflCargo = null;
			final SortedSet catSelProfile = new TreeSet(
					new CategorySequenceDetailsComparator());
			if (categorySelectionProfile != null) {
				// this one form the category selection profile
				final Iterator iter = categorySelectionProfile.iterator();
				CategorySequenceDetail categorySeqDtl = null;
				while (iter.hasNext()) {
					categorySeqDtl = (CategorySequenceDetail) iter.next();
					for (int i = 0; i < responseArraySize; i++) {
						if (categorySeqDtl.getCategoryType().equals(
								rmcResponseProfileManager
								.getTypeByResponse(responseType[i]))
								&& categorySeqDtl.getStatus() != IRMCResponseProfileManager.STATUS_NOT_REQUIRED) {
							catSelProfile.add(categorySeqDtl);
							break;
						}
					}
				}
			}

			// this one form the rmc in profile
			for (int j = 0; j < rmcInPrflCollSize; j++) {
				rmcInPrflCargo = rmcInPrflColl.getCargo(j);
				for (int i = 0; i < responseArraySize; i++) {
					// PCR 30729 - For Job Income details page when another job
					// is added for the same indiv from Summary page,
					// the detail page will be scheduled in visit again mode.
					// Added check for visit again mode too, in order
					// to have an empty profile created in that case too.
					if (null != rmcResponseProfileManager.getProfileResponse(
							rmcInPrflCargo, responseType[i])
							&& (rmcResponseProfileManager.getProfileResponse(
								rmcInPrflCargo, responseType[i]).charAt(0) == IRMCResponseProfileManager.STATUS_REQUIRED)) {
						categorySelectionProfileManager.insertSequenceDetail(
								catSelProfile, null, null, Short
								.parseShort(rmcInPrflCargo
										.getIndv_seq_num()),
										rmcResponseProfileManager
										.getTypeByResponse(responseType[i]));
						categorySelectionProfileManager.insertSequenceDetail(
								catSelProfile, null, null, Short
								.parseShort(rmcInPrflCargo
										.getIndv_seq_num()),
										AppConstants.CITIZEN_INFO);
					}
				}
			}

			return catSelProfile;
		} catch (final FwException fe) {
			throw rmcSessionBean.exceptionManagerLog(fe, getClass().getName(), "createPeoplePageProfile");
		} catch (final Exception e) {
			final FwException fe = createFwException(this.getClass().getName(),
					"createPageProfile", e);
			throw rmcSessionBean.exceptionManagerLog(fe, getClass().getName(), "createPeoplePageProfile");
		}
	}
	
	public SortedSet createBnftCnvctnPageProfile(
			final SortedSet categorySelectionProfile,
			final RMC_IN_PRFL_Collection rmcInPrflColl,
			final short[] responseType) {
		try {
			int rmcInPrflCollSize = 0;
			if (rmcInPrflColl != null && !rmcInPrflColl.isEmpty()) {
				rmcInPrflCollSize = rmcInPrflColl.size();
			}
			final int responseArraySize = responseType.length;
			RMC_IN_PRFL_Cargo rmcInPrflCargo = null;
			final SortedSet catSelProfile = new TreeSet(
					new CategorySequenceDetailsComparator());
			if (categorySelectionProfile != null) {
				// this one form the category selection profile
				final Iterator iter = categorySelectionProfile.iterator();
				CategorySequenceDetail categorySeqDtl = null;
				while (iter.hasNext()) {
					categorySeqDtl = (CategorySequenceDetail) iter.next();
					for (int i = 0; i < responseArraySize; i++) {
						if (categorySeqDtl
								.getCategoryType()
								.equals(rmcResponseProfileManager
										.getBnftCnvctnTypeByResponse(responseType[i]))
										&& categorySeqDtl.getStatus() != IRMCResponseProfileManager.STATUS_NOT_REQUIRED) {
							catSelProfile.add(categorySeqDtl);
							break;
						}
					}
				}
			}

			// this one form the rmc in profile
			for (int j = 0; j < rmcInPrflCollSize; j++) {
				rmcInPrflCargo = rmcInPrflColl.getCargo(j);
				for (int i = 0; i < responseArraySize; i++) {
					// PCR 30729 - For Job Income details page when another job
					// is added for the same indiv from Summary page,
					// the detail page will be scheduled in visit again mode.
					// Added check for visit again mode too, in order
					// to have an empty profile created in that case too.
					if (null != rmcResponseProfileManager.getProfileResponse(
							rmcInPrflCargo, responseType[i]) 
							&& (rmcResponseProfileManager.getProfileResponse(
								rmcInPrflCargo, responseType[i]).charAt(0) == IRMCResponseProfileManager.STATUS_REQUIRED)) {
						categorySelectionProfileManager
						.insertSequenceDetail(
								catSelProfile,
								null,
								null,
								Short.parseShort(rmcInPrflCargo
										.getIndv_seq_num()),
										rmcResponseProfileManager
										.getBnftCnvctnTypeByResponse(responseType[i]));
					}
				}
			}

			return catSelProfile;
		} catch (final FwException fe) {
			throw rmcSessionBean.exceptionManagerLog(fe, getClass().getName(), "createBnftCnvctnPageProfile");
		} catch (final Exception e) {
			final FwException fe = createFwException(this.getClass().getName(),
					"createPageProfile", e);
			throw rmcSessionBean.exceptionManagerLog(fe, getClass().getName(), "createBnftCnvctnPageProfile");
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
