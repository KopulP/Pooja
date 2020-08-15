/*
 * 
 */
package gov.state.nextgen.access.management.applications;


import java.util.HashMap;
import java.util.Map;

import gov.state.nextgen.access.business.entities.RMC_IN_PRFL_CUST_Cargo;
import gov.state.nextgen.access.business.entities.RMC_IN_PRFL_CUST_Collection;
import gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Cargo;
import gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Collection;
import gov.state.nextgen.access.business.entities.RMC_RESPONSE_Custom_Cargo;
import gov.state.nextgen.access.business.entities.RMC_RESPONSE_Custom_Collection;
import gov.state.nextgen.access.business.rules.AbstractBO;
import gov.state.nextgen.access.driver.DriverManager;
import gov.state.nextgen.access.driver.IDriver;
import gov.state.nextgen.access.exceptions.FwException;
import gov.state.nextgen.access.management.constants.AppConstants;
import gov.state.nextgen.access.management.constants.FwConstants;
import gov.state.nextgen.access.management.logging.ILog;
import gov.state.nextgen.access.management.util.FwDataCriteria;

/**
 * Response Profile Manager contains common business functions to manage the
 * business process
 *
 * @author Surendra Nath Modified on: Jan 31, 2007 PCR#
 */
public class RMCResponseProfileManager extends AbstractBO implements IRMCResponseProfileManager {

	// Row order : R, N, C, A, V (existing status) Column order : R, N, C, A, V,
	// X (make status)
	char[][] driverMatrix = { { STATUS_REQUIRED, STATUS_NOT_REQUIRED, STATUS_COMPLETE, STATUS_REQUIRED, STATUS_REQUIRED, STATUS_NOT_REQUIRED },
			{ STATUS_REQUIRED, STATUS_NOT_REQUIRED, STATUS_COMPLETE, STATUS_REQUIRED, STATUS_NOT_REQUIRED, STATUS_NOT_REQUIRED },
			{ STATUS_VISIT_AGAIN, STATUS_NOT_REQUIRED, STATUS_COMPLETE, STATUS_ADD_NEW, STATUS_COMPLETE, STATUS_NOT_REQUIRED },
			{ STATUS_VISIT_AGAIN, STATUS_NOT_REQUIRED, STATUS_COMPLETE, STATUS_ADD_NEW, STATUS_ADD_NEW, STATUS_NOT_REQUIRED },
			{ STATUS_VISIT_AGAIN, STATUS_NOT_REQUIRED, STATUS_COMPLETE, STATUS_VISIT_AGAIN, STATUS_VISIT_AGAIN, STATUS_NOT_REQUIRED } };

	private static final RMCResponseProfileManager applicationManager = new RMCResponseProfileManager();

	private static Map typeResponseMap = new HashMap();
	private static Map liquidResource = new HashMap();
	private static Map otherIncomeTypeResponseMap = new HashMap();
	private static Map bnftCnvctnTypeResponseMap = new HashMap();

	public static IRMCResponseProfileManager getInstance() {
		return applicationManager;
	}

	/**
	 * @see gov.state.nextgen.access.management.applications.IRMCResponseProfileManager#createRMCIndividualProfile(gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Cargo)
	 */
	@Override
	public RMC_IN_PRFL_Cargo createRMCIndividualProfile(final RMC_IN_PRFL_Cargo aRMCInPrflCargo) {
		try {
			RMC_IN_PRFL_Collection aRMCInPrflCollection = new RMC_IN_PRFL_Collection();
			aRMCInPrflCargo.setRowAction(FwConstants.ROWACTION_INSERT);
			setDefaultValues(aRMCInPrflCargo);
			aRMCInPrflCollection.addCargo(aRMCInPrflCargo);
			aRMCInPrflCollection = (RMC_IN_PRFL_Collection) aRMCInPrflCollection.persist(FwConstants.DAO);
			return aRMCInPrflCollection.getCargo(0);
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "createRMCIndividualProfile", e);
		}
	}

	/**
	 * @see gov.state.nextgen.access.management.applications.IRMCResponseProfileManager#updateProgramRequestProfile(gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Cargo)
	 */
	@Override
	public void updateProgramRequestProfile(final RMC_IN_PRFL_Cargo aAppInPrflCargo) {
		try {
			final Map dataCriteria = new HashMap();
			dataCriteria.put(FwConstants.SQL_IND, "sql-RM18");
			final FwDataCriteria[] criteria = new FwDataCriteria[8];

			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_value(aAppInPrflCargo.getIndv_fma_rqst_ind());
			criteria[0].setData_type(FwConstants.SHORT);

			criteria[1] = new FwDataCriteria();
			criteria[1].setColumn_value(aAppInPrflCargo.getIndv_fpw_rqst_ind());
			criteria[1].setData_type(FwConstants.SHORT);

			criteria[2] = new FwDataCriteria();
			criteria[2].setColumn_value(aAppInPrflCargo.getIndv_fs_rqst_ind());
			criteria[2].setData_type(FwConstants.SHORT);

			criteria[3] = new FwDataCriteria();
			criteria[3].setColumn_value(aAppInPrflCargo.getIndv_wic_rqst_ind());
			criteria[3].setData_type(FwConstants.SHORT);

			criteria[4] = new FwDataCriteria();
			criteria[4].setColumn_value(aAppInPrflCargo.getIndv_tanf_rqst_ind());
			criteria[4].setData_type(FwConstants.SHORT);

			criteria[5] = new FwDataCriteria();
			criteria[5].setColumn_value(aAppInPrflCargo.getIndv_cc_rqst_ind());
			criteria[5].setData_type(FwConstants.SHORT);

			criteria[6] = new FwDataCriteria();
			criteria[6].setColumn_value(aAppInPrflCargo.getApp_num());
			criteria[6].setData_type(FwConstants.STRING);

			criteria[7] = new FwDataCriteria();
			criteria[7].setColumn_value(aAppInPrflCargo.getIndv_seq_num());
			criteria[7].setData_type(FwConstants.SHORT);

			dataCriteria.put(FwConstants.CRITERIA, criteria);
			executeSQL(dataCriteria);
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "updateProgramRequestProfile", e);
		}
	}

	/**
	 * @see gov.state.nextgen.access.management.applications.IRMCResponseProfileManager#loadProfile(java.lang.String)
	 */
	@Override
	public RMC_IN_PRFL_Collection loadProfile(final String aAppNum) {
		try {
			final Map criteria = new HashMap();
			final RMC_IN_PRFL_Collection appInPrflCollection = new RMC_IN_PRFL_Collection();
			final FwDataCriteria[] dataCriteria = new FwDataCriteria[1];
			dataCriteria[0] = new FwDataCriteria();
			dataCriteria[0].setColumn_name("APP_NUM");
			dataCriteria[0].setColumn_value(String.valueOf(aAppNum));
			criteria.put(FwConstants.CRITERIA, dataCriteria);
			final RMC_IN_PRFL_Cargo[] appInPrflCargo = (RMC_IN_PRFL_Cargo[]) appInPrflCollection.select(FwConstants.DAO, criteria);
			if (appInPrflCargo.length > 0) {
				appInPrflCollection.setResults(appInPrflCargo);
			}
			return appInPrflCollection;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "loadProfile", e);
		}
	}

	/**
	 * @see gov.state.nextgen.access.management.applications.IRMCResponseProfileManager#loadProfile(java.lang.String)
	 */
	public RMC_IN_PRFL_Collection loadProfile(final String aAppNum, final String indSeqNum) {
		try {
			final Map criteria = new HashMap();
			final RMC_IN_PRFL_Collection appInPrflCollection = new RMC_IN_PRFL_Collection();
			final FwDataCriteria[] dataCriteria = new FwDataCriteria[2];
			dataCriteria[0] = new FwDataCriteria();
			dataCriteria[0].setColumn_name("APP_NUM");
			dataCriteria[0].setColumn_value(String.valueOf(aAppNum));

			dataCriteria[1] = new FwDataCriteria();
			dataCriteria[1].setColumn_name("INDV_SEQ_NUM");
			dataCriteria[1].setColumn_value(String.valueOf(indSeqNum));

			criteria.put(FwConstants.CRITERIA, dataCriteria);
			final RMC_IN_PRFL_Cargo[] appInPrflCargo = (RMC_IN_PRFL_Cargo[]) appInPrflCollection.select(FwConstants.DAO, criteria);
			if (appInPrflCargo.length > 0) {
				appInPrflCollection.setResults(appInPrflCargo);
			}
			return appInPrflCollection;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "loadProfile", e);
		}
	}

	/**
	 * @see gov.state.nextgen.access.management.applications.IRMCResponseProfileManager#deleteIndividualFromAppIndividualProfile(gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Collection,
	 *      java.lang.String)
	 */
	@Override
	public RMC_IN_PRFL_Collection deleteIndividualFromAppIndividualProfile(final RMC_IN_PRFL_Collection aSessionappInPrflColl, final String indvSeqNum) {
		try {
			// first we need to locate the cargo
			final RMC_IN_PRFL_Cargo appInPrflCargo = getProfile(aSessionappInPrflColl, indvSeqNum);
			if (appInPrflCargo != null) {
				// first we are removing cargo from the sessionCollection
				aSessionappInPrflColl.remove(appInPrflCargo);
				// now we are deleting the cargo from the data base
				final RMC_IN_PRFL_Collection appInPrflCollection = new RMC_IN_PRFL_Collection();
				appInPrflCargo.setRowAction(FwConstants.ROWACTION_DELETE);
				appInPrflCollection.addCargo(appInPrflCargo);
				appInPrflCollection.persist(FwConstants.DAO);
			}
			return aSessionappInPrflColl;

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "deleteIndividualFromAppIndividualProfile", e);
		}
	}

	/**
	 * @see gov.state.nextgen.access.management.applications.IRMCResponseProfileManager#runDirtyLogicOnDriver(java.lang.String,
	 *      int, java.lang.String, int[])
	 */
	@Override
	public void runDirtyLogicOnDriver(final String aAppNumber, final int aDirtyStatus, final String aDesiredPageId, final int[] aDriverArray) {
		final IDriver driver = DriverManager.getInstance();

		try {
			switch (aDirtyStatus) {
			case NOT_DIRTY:
				return;
			case DIRTY_UNCHECKED:
				driver.makeNotRequired(FwConstants.RMC_DRIVER, aDesiredPageId, aDriverArray, aAppNumber);
				return;
			case DIRTY_CHECKED:
				driver.makeRequired(FwConstants.RMC_DRIVER, aDesiredPageId, aDriverArray, aAppNumber);
				return;
			case DIRTY_CHECKED_ADD_NEW:
				driver.makeAddNew(FwConstants.RMC_DRIVER, aDesiredPageId, aDriverArray, aAppNumber);
				return;
			default:
				log(ILog.INFO, "RMCResponseProfileManager.runDirtyLogicOnDriver() - Raising FwException manually on a condition");
				final FwException fe = new FwException("Incorrect Dirty Status : " + aDirtyStatus + " passed.");
				fe.setClassID(this.getClass().getName());
				fe.setMethodID("runDirtyLogiconDriver");
				fe.setExceptionType(FwConstants.EXP_TYP_APPLICATION);
				fe.setExceptionText("Incorrect Dirty Status : " + aDirtyStatus + " passed.");
				throw fe;
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "runDirtyLogicOnDriver", e);
		}

	}

	/**
	 * @see gov.state.nextgen.access.management.applications.IRMCResponseProfileManager#translateProfileResponses(java.lang.String,
	 *      java.lang.String, int, short,
	 *      gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Cargo)
	 */
	@Override
	public void translateProfileResponses(final String aResponseFromPage, final String aResponseFromSession, final int aCurrentPageStatus,
			final short aResponseId, final RMC_IN_PRFL_Cargo aSessionAppInPrflCargo) {
		translateProfileResponsesForType(aResponseFromPage, aResponseFromSession, aCurrentPageStatus, aResponseId, aSessionAppInPrflCargo,
				NO_RESPONSE);
	}

	/**
	 * @see gov.state.nextgen.access.management.applications.IRMCResponseProfileManager#translateProfileResponsesForType(java.lang.String,
	 *      java.lang.String, int, short,
	 *      gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Cargo, short)
	 */
	@Override
	public void translateProfileResponsesForType(String aResponseFromPage, final String aResponseFromSession, final int aCurrentPageStatus,
			final short aResponseId, final RMC_IN_PRFL_Cargo aSessionAppInPrflCargo, final short aParentPageResponseId) {

		try {

			if ((aResponseFromPage == null) 
					|| "null".equals(aResponseFromPage)) {
				aResponseFromPage = "N";
			}

			if (null != aResponseFromPage 
					&& aResponseFromPage.charAt(0) == RESPONSE_YES) {
				// if response from the session is complete
				if (null != aResponseFromSession 
						&& aResponseFromSession.charAt(0) == STATUS_COMPLETE) {
					// if currernt page status is visit again
					if (aCurrentPageStatus == FwConstants.DRIVER_VISIT_AGAIN) {
						// then i am making required that response
						makeRequired(aResponseId, aSessionAppInPrflCargo, false);
					} else {
						return;
					}
				} else {
					// if response from the session not complete then
					// making required that response
					makeRequired(aResponseId, aSessionAppInPrflCargo, false);

					// if this method is calling type page
					// basically i am checking for the null.
					if (aParentPageResponseId != NO_RESPONSE) {
						makeComplete(aParentPageResponseId, aSessionAppInPrflCargo, true);
					}
				}
			} else if (null != aResponseFromPage 
					&&	aResponseFromPage.charAt(0) == RESPONSE_NO) {
				if (null != aResponseFromSession 
						&& aResponseFromSession.charAt(0) == STATUS_REQUIRED) {
					makeAbsoluteNotRequired(aResponseId, aSessionAppInPrflCargo, false);
				} else {
					return;
				}
			} else {
				log(ILog.INFO, "RMCResponseProfileManager.translateProfileResponsesForType() - Raising FwException manually on a condition");
				final FwException fe = new FwException("Incorrect Response From The Page : " + aResponseFromPage + " passed.");
				fe.setClassID(this.getClass().getName());
				fe.setMethodID("translateProfileResponsesForType");
				fe.setExceptionType(FwConstants.EXP_TYP_APPLICATION);
				fe.setExceptionText("Incorrect Response From The Page : " + aResponseFromPage + " passed.");
				throw fe;
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "translateProfileResponsesForType", e);
		}
	}

	/**
	 * @see gov.state.nextgen.access.management.applications.IRMCResponseProfileManager#determineDirtyStatus(java.lang.String,
	 *      java.lang.String, int[], int)
	 */
	@Override
	public boolean determineDirtyStatus(String aResponseFromPage, final String aResponseFromSession, final int[] aDirtyStatus,
			final int aCurrentPageStatus) {

		try {

			if ((aResponseFromPage == null) || "null".equals(aResponseFromPage)) {
				aResponseFromPage = "N";
			}
			// Initialing the temp status
			int tempStatus = 0;
			boolean responseYesAndReq = false;
			// if the response from the page equals "Y" and response from the
			// session is "R"
			if ((aResponseFromPage.charAt(0) == RESPONSE_YES) && (aResponseFromSession.charAt(0) == STATUS_REQUIRED)) {
				tempStatus = DIRTY_CHECKED;
				responseYesAndReq = true;			
			// if the response from the page equals "Y"
			} else if ((aResponseFromPage.charAt(0) == RESPONSE_YES) 
					&& (aResponseFromSession.charAt(0) == STATUS_NOT_REQUIRED)) {
				switch (aCurrentPageStatus) {

				case FwConstants.DRIVER_NOT_REQUIRED:
					tempStatus = NOT_DIRTY;
					break;

				case FwConstants.DRIVER_REQUIRED:
					tempStatus = DIRTY_CHECKED;
					break;

				case FwConstants.DRIVER_COMPLETE:
					tempStatus = DIRTY_CHECKED_ADD_NEW;
					break;

				case FwConstants.DRIVER_ADD_NEW:
					tempStatus = DIRTY_CHECKED_ADD_NEW;
					break;

				case FwConstants.DRIVER_VISIT_AGAIN:
					tempStatus = DIRTY_CHECKED_ADD_NEW;
					break;

				default:
					log(ILog.INFO, "RMCResponseProfileManager.determineDirtyStatus() - Raising FwException manually on a condition");
					final FwException fe = new FwException("Incorrect Page Status : " + aCurrentPageStatus + " passed.");
					fe.setClassID(this.getClass().getName());
					fe.setMethodID("determineDirtyStatus");
					fe.setExceptionType(FwConstants.EXP_TYP_APPLICATION);
					fe.setExceptionText("Incorrect Page Status : " + aCurrentPageStatus + " passed.");
					throw fe;
				}			
			// if the response from the page is null
			} else if ((aResponseFromPage.charAt(0) == RESPONSE_NO) && (aResponseFromSession.charAt(0) == STATUS_REQUIRED)) {
				switch (aCurrentPageStatus) {

				case FwConstants.DRIVER_NOT_REQUIRED:
					tempStatus = NOT_DIRTY;
					break;

				case FwConstants.DRIVER_REQUIRED:
					tempStatus = NOT_DIRTY;
					break;

				case FwConstants.DRIVER_COMPLETE:
					tempStatus = DIRTY_UNCHECKED;
					break;

				case FwConstants.DRIVER_ADD_NEW:
					tempStatus = NOT_DIRTY;
					break;

				case FwConstants.DRIVER_VISIT_AGAIN:
					tempStatus = DIRTY_UNCHECKED;
					break;

				default:
					log(ILog.INFO, "RMCResponseProfileManager.determineDirtyStatus() - Raising FwException manually on a condition");
					final FwException fe = new FwException("Incorrect Page Status : " + aCurrentPageStatus + " passed.");
					fe.setClassID(this.getClass().getName());
					fe.setMethodID("determineDirtyStatus");
					fe.setExceptionType(FwConstants.EXP_TYP_APPLICATION);
					fe.setExceptionText("Incorrect Page Status : " + aCurrentPageStatus + " passed.");
					throw fe;
				}
			} else {
				// if the current page status is visit again
				if (aCurrentPageStatus == FwConstants.DRIVER_VISIT_AGAIN) {
					if ((aResponseFromPage.charAt(0) == RESPONSE_NO) && (aResponseFromSession.charAt(0) == STATUS_NOT_REQUIRED)) {
						tempStatus = NOT_DIRTY;
					} else {
						tempStatus = DIRTY_CHECKED;
					}
				}
			}

			// if temp status greater than the dirty status
			// through the reflection we are sending back the tempstatus
			if (tempStatus > aDirtyStatus[0]) {
				aDirtyStatus[0] = tempStatus;
			}

			// if response from the page is "Y" and session response is "R"
			// then we need to sent as false because there is no change in the
			// response for that question
			if (responseYesAndReq) {
				return false;
			}

			// if temp status greater than zero means we done some change for
			// this response
			// then we are sending the flag true
			if (tempStatus > 0) {
				return true;
			}

			return false;

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "determineDirtyStatus", e);
		}
	}

	/**
	 * @see gov.state.nextgen.access.management.applications.IRMCResponseProfileManager#translateProfileResponseAfterValidation(gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Collection,
	 *      gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Collection,
	 *      short[])
	 */
	@Override
	public void translateProfileResponseAfterValidation(final RMC_IN_PRFL_Collection aAppInPrflPageColl,
			final RMC_IN_PRFL_Collection aAppInPrflSessionColl, final short[] aResponsesIds) {
		try {
			RMC_IN_PRFL_Cargo appInPrflPageCargo = null;
			RMC_IN_PRFL_Cargo appInPrflSessionCargo = null;
			int pageCollSize = 0;
			if (aAppInPrflPageColl != null) {
				pageCollSize = aAppInPrflPageColl.size();
			}
			final int sessionCollSize = aAppInPrflSessionColl.size();
			final int responseSize = aResponsesIds.length;
			
			if(aAppInPrflPageColl !=null && !aAppInPrflPageColl.isEmpty() && aAppInPrflPageColl.size()>0){
				for (int i = 0; i < pageCollSize; i++) {
					appInPrflPageCargo = aAppInPrflPageColl.getCargo(i);
					for (int j = 0; j < sessionCollSize; j++) {
						appInPrflSessionCargo = aAppInPrflSessionColl.getCargo(j);
						if (appInPrflPageCargo.getIndv_seq_num().equals(appInPrflSessionCargo.getIndv_seq_num())) {
							break;
						}
					}
					// for each response id's
					for (int k = 0; k < responseSize; k++) {
						translateProfileStatus(appInPrflPageCargo, appInPrflSessionCargo, aResponsesIds[k]);
					}
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "translateProfileResponseAfterValidation", e);
		}
	}

	/**
	 * updates cargo with the new status and returns the new status
	 */
	private void translateProfileStatus(final RMC_IN_PRFL_Cargo aPageCargo, final RMC_IN_PRFL_Cargo aSessionCargo, final short aFieldId) {

		switch (aFieldId) {

		case ACCIDENT:
			aPageCargo.setAcdt_resp(settingProfileStatus(aPageCargo.getAcdt_resp(), aSessionCargo.getAcdt_resp()));
			return;
		case ADOPTION_ASSISTANCE:
			aPageCargo.setAdpt_asst_resp(settingProfileStatus(aPageCargo.getAdpt_asst_resp(), aSessionCargo.getAdpt_asst_resp()));
			return;
		case ALIMONY_RECEIVED:
			aPageCargo.setAlmy_rcv_resp(settingProfileStatus(aPageCargo.getAlmy_rcv_resp(), aSessionCargo.getAlmy_rcv_resp()));
			return;
		case BENEFIT_ANNUITIES:
			aPageCargo.setBnft_anty_resp(settingProfileStatus(aPageCargo.getBnft_anty_resp(), aSessionCargo.getBnft_anty_resp()));
			return;
		case BENEFIT_CHARITY:
			aPageCargo.setBnft_chrt_resp(settingProfileStatus(aPageCargo.getBnft_chrt_resp(), aSessionCargo.getBnft_chrt_resp()));
			return;
		case BENEFIT_DISABLE:
			aPageCargo.setBnft_dabl_resp(settingProfileStatus(aPageCargo.getBnft_dabl_resp(), aSessionCargo.getBnft_dabl_resp()));
			return;
		case BENEFIT_DIVIDEND:
			aPageCargo.setBnft_divnd_resp(settingProfileStatus(aPageCargo.getBnft_divnd_resp(), aSessionCargo.getBnft_divnd_resp()));
			return;
		case BENEFIT_TRUST:
			aPageCargo.setBnft_est_trst_resp(settingProfileStatus(aPageCargo.getBnft_est_trst_resp(), aSessionCargo.getBnft_est_trst_resp()));
			return;
		case BENEFIT_RAILROAD_RETIREMENT:
			aPageCargo.setBnft_rr_resp(settingProfileStatus(aPageCargo.getBnft_rr_resp(), aSessionCargo.getBnft_rr_resp()));
			return;
		case BENEFIT_UNEMPLOYMENT:
			aPageCargo.setBnft_uempl_resp(settingProfileStatus(aPageCargo.getBnft_uempl_resp(), aSessionCargo.getBnft_uempl_resp()));
			return;
		case BENEFIT_VETERAN:
			aPageCargo.setBnft_vet_resp(settingProfileStatus(aPageCargo.getBnft_vet_resp(), aSessionCargo.getBnft_vet_resp()));
			return;
		case CHILD_SUPPORT_PAYMENT:
			aPageCargo.setChld_sprt_pay_resp(settingProfileStatus(aPageCargo.getChld_sprt_pay_resp(), aSessionCargo.getChld_sprt_pay_resp()));
			return;
		case DISABLE:
			aPageCargo.setDabl_resp(settingProfileStatus(aPageCargo.getDabl_resp(), aSessionCargo.getDabl_resp()));
			return;
		case DEPENDENT_CARE:
			aPageCargo.setDpnd_care_resp(settingProfileStatus(aPageCargo.getDpnd_care_resp(), aSessionCargo.getDpnd_care_resp()));
			return;
		case DRUG_FELON:
			aPageCargo.setDrug_feln_resp(settingProfileStatus(aPageCargo.getDrug_feln_resp(), aSessionCargo.getDrug_feln_resp()));
			return;
		case FSET_SANCTION:
			aPageCargo.setFset_sctn_resp(settingProfileStatus(aPageCargo.getFset_sctn_resp(), aSessionCargo.getFset_sctn_resp()));
			return;
		case FOSTER_CARE:
			aPageCargo.setFstr_care_resp(settingProfileStatus(aPageCargo.getFstr_care_resp(), aSessionCargo.getFstr_care_resp()));
			return;
		case GENERAL_RELIEF:
			aPageCargo.setGen_rlf_resp(settingProfileStatus(aPageCargo.getGen_rlf_resp(), aSessionCargo.getGen_rlf_resp()));
			return;
		case HEALTHCARE_COVERAGE:
			aPageCargo.setHc_cvrg_resp(settingProfileStatus(aPageCargo.getHc_cvrg_resp(), aSessionCargo.getHc_cvrg_resp()));
			return;
		case HOUS_PICE:
			aPageCargo.setHospice_resp(settingProfileStatus(aPageCargo.getHospice_resp(), aSessionCargo.getHospice_resp()));
			return;
		case OUTSTATE_BNFTS:
			aPageCargo.setOutstate_bnft_resp(settingProfileStatus(aPageCargo.getOutstate_bnft_resp(), aSessionCargo.getOutstate_bnft_resp()));
			return;
		case SPECIAL_NEED:
			aPageCargo.setSpecial_need_resp(settingProfileStatus(aPageCargo.getSpecial_need_resp(), aSessionCargo.getSpecial_need_resp()));
			return;
		case MOVED_OUT_OF_HOME_RESP:
			aPageCargo.setMoved_out_of_home_resp(settingProfileStatus(aPageCargo.getMoved_out_of_home_resp(),
					aSessionCargo.getMoved_out_of_home_resp()));
			return;
		case PRSN_INFO_STAT_SW:
			aPageCargo.setPersonal_info(settingProfileStatus(aPageCargo.getPersonal_info(), aSessionCargo.getPersonal_info()));
			return;
		case CITIZENSHIP_INFO:
			aPageCargo.setCitizenship_info(settingProfileStatus(aPageCargo.getCitizenship_info(), aSessionCargo.getCitizenship_info()));
			return;
		case RLT_CHG_STAT_SW:
			aPageCargo.setRlt_chg_stat_sw(settingProfileStatus(aPageCargo.getRlt_chg_stat_sw(), aSessionCargo.getRlt_chg_stat_sw()));
			return;
		case FOSTER_CARE_RESP:
			aPageCargo.setFoster_care_resp(settingProfileStatus(aPageCargo.getFoster_care_resp(), aSessionCargo.getFoster_care_resp()));
			return;
		case FORMER_FOSTER_RESP:
			aPageCargo.setFormer_foster_resp(settingProfileStatus(aPageCargo.getFormer_foster_resp(), aSessionCargo.getFormer_foster_resp()));
			return;
		case CHILD_PROTECTIVE_RESP:
			aPageCargo
					.setChild_protective_resp(settingProfileStatus(aPageCargo.getChild_protective_resp(), aSessionCargo.getChild_protective_resp()));
			return;
		case LIVING_PROG_RESP:
			aPageCargo.setLiving_prog_resp(settingProfileStatus(aPageCargo.getLiving_prog_resp(), aSessionCargo.getLiving_prog_resp()));
			return;
		case GRAND_PARENT_RESP:
			aPageCargo.setGrand_parent_resp(settingProfileStatus(aPageCargo.getGrand_parent_resp(), aSessionCargo.getGrand_parent_resp()));
			return;
		case DRUG_FELONIES_RESP:
			aPageCargo.setDrug_felonies_resp(settingProfileStatus(aPageCargo.getDrug_felonies_resp(), aSessionCargo.getDrug_felonies_resp()));
			return;
		case SNAP_TANF_DISC_RESP:
			aPageCargo.setSnap_tanf_disc_resp(settingProfileStatus(aPageCargo.getSnap_tanf_disc_resp(), aSessionCargo.getSnap_tanf_disc_resp()));
			return;
		case TANF_DISC_RESP:
			aPageCargo.setTanfDiscResp(settingProfileStatus(aPageCargo.getTanfDiscResp(), aSessionCargo.getTanfDiscResp()));
			return;
		case AVOID_PROSC_RESP:
			aPageCargo.setAvoid_prosc_resp(settingProfileStatus(aPageCargo.getAvoid_prosc_resp(), aSessionCargo.getAvoid_prosc_resp()));
			return;
		case AVD_PRSCTN_FSTF:
			aPageCargo.setAvd_prsctn_fstf(settingProfileStatus(aPageCargo.getAvd_prsctn_fstf(), aSessionCargo.getAvd_prsctn_fstf()));
			return;
		case VIOLATING_PAROLE_RESP:
			aPageCargo
					.setViolating_parole_resp(settingProfileStatus(aPageCargo.getViolating_parole_resp(), aSessionCargo.getViolating_parole_resp()));
			return;
		case CONVIC_FALSE_INFO_RESP:
			aPageCargo.setConvic_false_info_resp(settingProfileStatus(aPageCargo.getConvic_false_info_resp(),
					aSessionCargo.getConvic_false_info_resp()));
			return;
		case VOLUNTARILY_QUIT_JOB_RESP:
			aPageCargo.setVoluntarily_quit_job_resp(settingProfileStatus(aPageCargo.getVoluntarily_quit_job_resp(),
					aSessionCargo.getVoluntarily_quit_job_resp()));
			return;
		case TRADING_SNAP_RESP:
			aPageCargo.setTrading_snap_resp(settingProfileStatus(aPageCargo.getTrading_snap_resp(), aSessionCargo.getTrading_snap_resp()));
			return;
		case BUY_SELL_SNAP_RESP:
			aPageCargo.setBuy_sell_snap_resp(settingProfileStatus(aPageCargo.getBuy_sell_snap_resp(), aSessionCargo.getBuy_sell_snap_resp()));
			return;
		case TRADE_SNAP_GUN_RESP:
			aPageCargo.setTrade_snap_gun_resp(settingProfileStatus(aPageCargo.getTrade_snap_gun_resp(), aSessionCargo.getTrade_snap_gun_resp()));
			return;
		case PREV_SSI_RESP:
			aPageCargo.setPrev_ssi_resp(settingProfileStatus(aPageCargo.getPrev_ssi_resp(), aSessionCargo.getPrev_ssi_resp()));
			return;
		case HOME_COMMUNITY_RESP:
			aPageCargo.setHome_community_resp(settingProfileStatus(aPageCargo.getHome_community_resp(), aSessionCargo.getHome_community_resp()));
			return;
		case TRIBAL_HEALTH_RESP:
			aPageCargo.setTribal_health_resp(settingProfileStatus(aPageCargo.getTribal_health_resp(), aSessionCargo.getTribal_health_resp()));
			return;
		case TRIBAL_ELIGIBILITY_RESP:
			aPageCargo.setTribal_eligibility_resp(settingProfileStatus(aPageCargo.getTribal_eligibility_resp(),
					aSessionCargo.getTribal_eligibility_resp()));
			return;
		case DOMESTIC_VIOLENCE_RESP:
			aPageCargo.setDomestic_violence_resp(settingProfileStatus(aPageCargo.getDomestic_violence_resp(),
					aSessionCargo.getDomestic_violence_resp()));
			return;
		case TANF_EPPIC_RESP:
			aPageCargo.setTanf_eppic_resp(settingProfileStatus(aPageCargo.getTanf_eppic_resp(), aSessionCargo.getTanf_eppic_resp()));
			return;
		case EMERGENCY_MEDICAL_RESP:
			aPageCargo.setEmergency_medical_resp(settingProfileStatus(aPageCargo.getEmergency_medical_resp(),
					aSessionCargo.getEmergency_medical_resp()));
			return;
		case INCOME_INTEREST:
			aPageCargo.setIndv_fma_rqst_ind(settingProfileStatus(aPageCargo.getIndv_fma_rqst_ind(), aSessionCargo.getIndv_fma_rqst_ind()));
			aPageCargo.setIncm_int_resp(settingProfileStatus(aPageCargo.getIncm_int_resp(), aSessionCargo.getIncm_int_resp()));
			return;
		case INDIVIDUAL_FAMILY_MEDICAID:
			aPageCargo.setIndv_fma_rqst_ind(settingProfileStatus(aPageCargo.getIndv_fma_rqst_ind(), aSessionCargo.getIndv_fma_rqst_ind()));
			return;
		case INDIVIDUAL_FPW:
			aPageCargo.setIndv_fpw_rqst_ind(settingProfileStatus(aPageCargo.getIndv_fpw_rqst_ind(), aSessionCargo.getIndv_fpw_rqst_ind()));
			return;
		case INDIVIDUAL_FOODSHARE:
			aPageCargo.setIndv_fs_rqst_ind(settingProfileStatus(aPageCargo.getIndv_fs_rqst_ind(), aSessionCargo.getIndv_fs_rqst_ind()));
			return;
		case IREW:
			aPageCargo.setIrwe_resp(settingProfileStatus(aPageCargo.getIrwe_resp(), aSessionCargo.getIrwe_resp()));
			return;
		case KINSHIP_CARE:
			aPageCargo.setKinship_care_resp(settingProfileStatus(aPageCargo.getKinship_care_resp(), aSessionCargo.getKinship_care_resp()));
			return;
		case MEDICAL_EXPENSE:
			aPageCargo.setMed_exp_resp(settingProfileStatus(aPageCargo.getMed_exp_resp(), aSessionCargo.getMed_exp_resp()));
			return;
		case MILITARY_ALLOTMENT:
			aPageCargo.setMil_allot_resp(settingProfileStatus(aPageCargo.getMil_allot_resp(), aSessionCargo.getMil_allot_resp()));
			return;
		case MONEY_FROM_ANOTHER_PERSON:
			aPageCargo.setMony_othr_resp(settingProfileStatus(aPageCargo.getMony_othr_resp(), aSessionCargo.getMony_othr_resp()));
			return;
		case REFUGE:
			aPageCargo.setNatl_rfge_resp(settingProfileStatus(aPageCargo.getNatl_rfge_resp(), aSessionCargo.getNatl_rfge_resp()));
			return;
		case NEEDY_INDIAN:
			aPageCargo.setNeed_ind_resp(settingProfileStatus(aPageCargo.getNeed_ind_resp(), aSessionCargo.getNeed_ind_resp()));
			return;
		case ON_STRIKE:
			aPageCargo.setOn_strk_sw(settingProfileStatus(aPageCargo.getOn_strk_sw(), aSessionCargo.getOn_strk_sw()));
			return;
		case OTHER_PENSION:
			aPageCargo.setOp_aoda_tmt_rcv_sw(settingProfileStatus(aPageCargo.getOp_aoda_tmt_rcv_sw(), aSessionCargo.getOp_aoda_tmt_rcv_sw()));
			return;
		case OTHER_INCOME:
			aPageCargo.setOthr_incm_resp(settingProfileStatus(aPageCargo.getOthr_incm_resp(), aSessionCargo.getOthr_incm_resp()));
			return;
		case OTHER_SOURCE:
			aPageCargo.setOthr_src_resp(settingProfileStatus(aPageCargo.getOthr_src_resp(), aSessionCargo.getOthr_src_resp()));
			return;
		case OWNER_ASSET:
			aPageCargo.setOwn_aset_resp(settingProfileStatus(aPageCargo.getOwn_aset_resp(), aSessionCargo.getOwn_aset_resp()));
			return;
		case PAY_HOUSING_BILL:
			aPageCargo.setPay_hous_bill_resp(settingProfileStatus(aPageCargo.getPay_hous_bill_resp(), aSessionCargo.getPay_hous_bill_resp()));
			return;
		case PREGNANCY:
			aPageCargo.setPreg_resp(settingProfileStatus(aPageCargo.getPreg_resp(), aSessionCargo.getPreg_resp()));
			return;
		case JOB_IN_KIND:
			aPageCargo.setJob_iknd_resp(settingProfileStatus(aPageCargo.getJob_iknd_resp(), aSessionCargo.getJob_iknd_resp()));
			return;
		case PAY_ROOM_AND_BOARD:
			aPageCargo.setPay_rmr_brd_resp(settingProfileStatus(aPageCargo.getPay_rmr_brd_resp(), aSessionCargo.getPay_rmr_brd_resp()));
			return;
		case PENSION_RETIREMENT:
			aPageCargo.setPnsn_retr_resp(settingProfileStatus(aPageCargo.getPnsn_retr_resp(), aSessionCargo.getPnsn_retr_resp()));
			return;
		case PROPERTY_SOLD:
			aPageCargo.setProp_sold_resp(settingProfileStatus(aPageCargo.getProp_sold_resp(), aSessionCargo.getProp_sold_resp()));
			return;
		case RECEIVE_FS_IN_OTHER_STATE:
			aPageCargo.setRcv_fs_oth_st_resp(settingProfileStatus(aPageCargo.getRcv_fs_oth_st_resp(), aSessionCargo.getRcv_fs_oth_st_resp()));
			return;
		case RECEIVE_HOUSING_ASSET:
			aPageCargo.setRcv_hous_asst_resp(settingProfileStatus(aPageCargo.getRcv_hous_asst_resp(), aSessionCargo.getRcv_hous_asst_resp()));
			return;
		case RECEIVE_MEDICARE:
			aPageCargo.setRcv_medcr_resp(settingProfileStatus(aPageCargo.getRcv_medcr_resp(), aSessionCargo.getRcv_medcr_resp()));
			return;
		case RECEIVE_SOCIAL_SECURITY:
			aPageCargo.setRcv_ss_resp(settingProfileStatus(aPageCargo.getRcv_ss_resp(), aSessionCargo.getRcv_ss_resp()));
			return;
		case RECEIVE_SSI_LETTER:
			aPageCargo.setRcv_ssi_ltr_resp(settingProfileStatus(aPageCargo.getRcv_ssi_ltr_resp(), aSessionCargo.getRcv_ssi_ltr_resp()));
			return;
		case RECEIVE_SSI:
			aPageCargo.setRcv_ssi_sw(settingProfileStatus(aPageCargo.getRcv_ssi_sw(), aSessionCargo.getRcv_ssi_sw()));
			return;
		case ROOM_AND_BOARD:
			aPageCargo.setRmr_brd_incm_resp(settingProfileStatus(aPageCargo.getRmr_brd_incm_resp(), aSessionCargo.getRmr_brd_incm_resp()));
			return;
		case SELF_EMPLOYMENT:
			aPageCargo.setSelf_empl_resp(settingProfileStatus(aPageCargo.getSelf_empl_resp(), aSessionCargo.getSelf_empl_resp()));
			return;
		case RECEIVE_SSI_DCOND:
			aPageCargo.setSsi_dcond_resp(settingProfileStatus(aPageCargo.getSsi_dcond_resp(), aSessionCargo.getSsi_dcond_resp()));
			return;
		case RECEIVE_SSI_1619B:
			aPageCargo.setSsi_1619b_rcv_sw(settingProfileStatus(aPageCargo.getSsi_1619b_rcv_sw(), aSessionCargo.getSsi_1619b_rcv_sw()));
			return;
		case SHELTER_COST_ASSESSMENT:
			aPageCargo.setSu_ases_resp(settingProfileStatus(aPageCargo.getSu_ases_resp(), aSessionCargo.getSu_ases_resp()));
			return;
		case SHELTER_COST_COAL:
			aPageCargo.setSu_cst_coal_resp(settingProfileStatus(aPageCargo.getSu_cst_coal_resp(), aSessionCargo.getSu_cst_coal_resp()));
			return;
		case SHELTER_COST_ELECTRICTY:
			aPageCargo.setSu_cst_elec_resp(settingProfileStatus(aPageCargo.getSu_cst_elec_resp(), aSessionCargo.getSu_cst_elec_resp()));
			return;
		case SHELTER_COST_FUEL:
			aPageCargo.setSu_cst_fuel_resp(settingProfileStatus(aPageCargo.getSu_cst_fuel_resp(), aSessionCargo.getSu_cst_fuel_resp()));
			return;
		case SHELTER_COST_GAS:
			aPageCargo.setSu_cst_gas_resp(settingProfileStatus(aPageCargo.getSu_cst_gas_resp(), aSessionCargo.getSu_cst_gas_resp()));
			return;
		case SHELTER_COST_HOME:
			aPageCargo.setSu_cst_home_resp(settingProfileStatus(aPageCargo.getSu_cst_home_resp(), aSessionCargo.getSu_cst_home_resp()));
			return;
		case SHELTER_COST_INSTALL:
			aPageCargo.setSu_cst_istl_resp(settingProfileStatus(aPageCargo.getSu_cst_istl_resp(), aSessionCargo.getSu_cst_istl_resp()));
			return;
		case SHELTER_COST_LPGAS:
			aPageCargo.setSu_cst_lpgas_resp(settingProfileStatus(aPageCargo.getSu_cst_lpgas_resp(), aSessionCargo.getSu_cst_lpgas_resp()));
			return;
		case SHELTER_COST_MOBILE_HOME:
			aPageCargo.setSu_cst_mbl_resp(settingProfileStatus(aPageCargo.getSu_cst_mbl_resp(), aSessionCargo.getSu_cst_mbl_resp()));
			return;
		case SHELTER_COST_MORTGAGE:
			aPageCargo.setSu_cst_mtge_resp(settingProfileStatus(aPageCargo.getSu_cst_mtge_resp(), aSessionCargo.getSu_cst_mtge_resp()));
			return;
		case SHELTER_COST_OTHER:
			aPageCargo.setSu_cst_othr_resp(settingProfileStatus(aPageCargo.getSu_cst_othr_resp(), aSessionCargo.getSu_cst_othr_resp()));
			return;
		case SHELTER_COST_PHONE:
			aPageCargo.setSu_cst_phn_resp(settingProfileStatus(aPageCargo.getSu_cst_phn_resp(), aSessionCargo.getSu_cst_phn_resp()));
			return;
		case SHELTER_COST_RENT:
			aPageCargo.setSu_cst_rent_resp(settingProfileStatus(aPageCargo.getSu_cst_rent_resp(), aSessionCargo.getSu_cst_rent_resp()));
			return;
		case SHELTER_COST_SEWER:
			aPageCargo.setSu_cst_swr_resp(settingProfileStatus(aPageCargo.getSu_cst_swr_resp(), aSessionCargo.getSu_cst_swr_resp()));
			return;
		case SHELTER_COST_TAX:
			aPageCargo.setSu_cst_tax_resp(settingProfileStatus(aPageCargo.getSu_cst_tax_resp(), aSessionCargo.getSu_cst_tax_resp()));
			return;
		case SHELTER_COST_TRASH:
			aPageCargo.setSu_cst_trsh_resp(settingProfileStatus(aPageCargo.getSu_cst_trsh_resp(), aSessionCargo.getSu_cst_trsh_resp()));
			return;
		case SHELTER_COST_WOOD:
			aPageCargo.setSu_cst_wood_resp(settingProfileStatus(aPageCargo.getSu_cst_wood_resp(), aSessionCargo.getSu_cst_wood_resp()));
			return;
		case SHELTER_COST_WATER:
			aPageCargo.setSu_cst_wtr_resp(settingProfileStatus(aPageCargo.getSu_cst_wtr_resp(), aSessionCargo.getSu_cst_wtr_resp()));
			return;
		case SHELTER_COST_WASTE:
			aPageCargo.setSu_cst_wwt_resp(settingProfileStatus(aPageCargo.getSu_cst_wwt_resp(), aSessionCargo.getSu_cst_wwt_resp()));
			return;
		case TRIBAL_TANF:
			aPageCargo.setTrb_tanf_resp(settingProfileStatus(aPageCargo.getTrb_tanf_resp(), aSessionCargo.getTrb_tanf_resp()));
			return;
		case UTILITY_EXPENSE:
			aPageCargo.setUtil_exp_resp(settingProfileStatus(aPageCargo.getUtil_exp_resp(), aSessionCargo.getUtil_exp_resp()));
			return;
		case WORKER_COMP:
			aPageCargo.setWork_comp_resp(settingProfileStatus(aPageCargo.getWork_comp_resp(), aSessionCargo.getWork_comp_resp()));
			return;
		case TRIBAL_CAPITA:
			aPageCargo.setTrb_cpta_resp(settingProfileStatus(aPageCargo.getTrb_cpta_resp(), aSessionCargo.getTrb_cpta_resp()));
			return;
		case EDUCATIONAL_AID:
			aPageCargo.setEduc_aid_resp(settingProfileStatus(aPageCargo.getEduc_aid_resp(), aSessionCargo.getEduc_aid_resp()));
			return;
		case WHEAP:
			aPageCargo.setWheap_resp(settingProfileStatus(aPageCargo.getWheap_resp(), aSessionCargo.getWheap_resp()));
			return;
		case REGULAR_EMPL:
			aPageCargo.setEmpl_resp(settingProfileStatus(aPageCargo.getEmpl_resp(), aSessionCargo.getEmpl_resp()));
			return;
		case BNFT_CHL_SPRT_RESP:
			aPageCargo.setBnft_chl_sprt_resp(settingProfileStatus(aPageCargo.getBnft_chl_sprt_resp(), aSessionCargo.getBnft_chl_sprt_resp()));
			return;
		case PUB_ASST_RESP:
			aPageCargo.setPub_asst_resp(settingProfileStatus(aPageCargo.getPub_asst_resp(), aSessionCargo.getPub_asst_resp()));
			return;
		case YEHOC_RESP:
			aPageCargo.setYehoc_resp(settingProfileStatus(aPageCargo.getYehoc_resp(), aSessionCargo.getYehoc_resp()));
			return;
			// PCR 35980 - Past_hc_cvrg_resp
		case PAST_HEALTHCARE_COVERAGE:
			aPageCargo.setPast_hc_cvrg_resp(settingProfileStatus(aPageCargo.getPast_hc_cvrg_resp(), aSessionCargo.getPast_hc_cvrg_resp()));
			return;

			// PCR# 40362 - ADDED NEW RESPONSES FOR RMB AND SMRF CHANGES -
			// starts
		case MAPP_BENEFITS_RESP:
			aPageCargo.setBnft_mapp_resp(settingProfileStatus(aPageCargo.getBnft_mapp_resp(), aSessionCargo.getBnft_mapp_resp()));
			return;

		case BUR_AST_CASKET:
			aPageCargo.setBury_aset_oth_resp(settingProfileStatus(aPageCargo.getBury_aset_oth_resp(), aSessionCargo.getBury_aset_oth_resp()));
			return;

		case BUR_AST_IRREVOCABLE:
			aPageCargo.setBury_aset_rbt_resp(settingProfileStatus(aPageCargo.getBury_aset_rbt_resp(), aSessionCargo.getBury_aset_rbt_resp()));
			return;

		case BUR_AST_INSURANCE:
			aPageCargo.setBury_aset_ins_resp(settingProfileStatus(aPageCargo.getBury_aset_ins_resp(), aSessionCargo.getBury_aset_ins_resp()));
			return;

		case BUR_AST_MAUSOLEUM:
			aPageCargo.setBury_aset_mas_resp(settingProfileStatus(aPageCargo.getBury_aset_mas_resp(), aSessionCargo.getBury_aset_mas_resp()));
			return;

		case BUR_AST_OTHER:
			aPageCargo.setBury_aset_oth_resp(settingProfileStatus(aPageCargo.getBury_aset_oth_resp(), aSessionCargo.getBury_aset_oth_resp()));
			return;

		case BUR_AST_PLOT:
			aPageCargo.setBury_aset_plt_resp(settingProfileStatus(aPageCargo.getBury_aset_plt_resp(), aSessionCargo.getBury_aset_plt_resp()));
			return;

		case BUR_AST_REVOCABLE:
			aPageCargo.setBury_aset_rbt_resp(settingProfileStatus(aPageCargo.getBury_aset_rbt_resp(), aSessionCargo.getBury_aset_rbt_resp()));
			return;

		case BUR_AST_VAULT:
			aPageCargo.setBury_aset_v_resp(settingProfileStatus(aPageCargo.getBury_aset_v_resp(), aSessionCargo.getBury_aset_v_resp()));
			return;

		case LIF_AST_GROUP_LIFE:
			aPageCargo.setLi_aset_g_l_resp(settingProfileStatus(aPageCargo.getLi_aset_g_l_resp(), aSessionCargo.getLi_aset_g_l_resp()));
			return;

		case LIF_AST_GROUP_TERM:
			aPageCargo.setLi_aset_g_t_resp(settingProfileStatus(aPageCargo.getLi_aset_g_t_resp(), aSessionCargo.getLi_aset_g_t_resp()));
			return;

		case LIF_AST_TERM:
			aPageCargo.setLi_aset_trm_resp(settingProfileStatus(aPageCargo.getLi_aset_trm_resp(), aSessionCargo.getLi_aset_trm_resp()));
			return;

		case LIF_AST_UNIVERSAL:
			aPageCargo.setLi_aset_unv_resp(settingProfileStatus(aPageCargo.getLi_aset_unv_resp(), aSessionCargo.getLi_aset_unv_resp()));
			return;

		case LIF_AST_WHOLE_LIFE:
			aPageCargo.setLi_aset_w_l_resp(settingProfileStatus(aPageCargo.getLi_aset_w_l_resp(), aSessionCargo.getLi_aset_w_l_resp()));
			return;

		case LIQ_ASET_CASH:
			aPageCargo.setLiquid_asset_cash_resp(settingProfileStatus(aPageCargo.getLiquid_asset_cash_resp(),
					aSessionCargo.getLiquid_asset_cash_resp()));
			return;

		case LIQUID_ASSET_XFER:
			aPageCargo.setLqd_aset_tr_f_resp(settingProfileStatus(aPageCargo.getLqd_aset_tr_f_resp(), aSessionCargo.getLqd_aset_tr_f_resp()));
			return;
		case LIQUID_ASET_BANK:
			aPageCargo.setLiquid_asset_bank_acc_resp(settingProfileStatus(aPageCargo.getLiquid_asset_bank_acc_resp(),
					aSessionCargo.getLiquid_asset_bank_acc_resp()));
			return;
		case LIQUID_ASSET_ANNUITY:
			aPageCargo.setLiquid_aset_disable_blind_resp(settingProfileStatus(aPageCargo.getLiquid_aset_disable_blind_resp(),
					aSessionCargo.getLiquid_aset_disable_blind_resp()));
			return;
		case LIQUID_ASSET_IRA:
			aPageCargo
					.setLiquid_asset_ira_resp(settingProfileStatus(aPageCargo.getLiquid_asset_ira_resp(), aSessionCargo.getLiquid_asset_ira_resp()));
			return;
		case LIQUID_ASSET_IRS_RET:
			aPageCargo.setLiquid_asset_irs_retirmnt_resp(settingProfileStatus(aPageCargo.getLiquid_asset_irs_retirmnt_resp(),
					aSessionCargo.getLiquid_asset_irs_retirmnt_resp()));
			return;
		case LIQUID_ASSET_SAVINGS_ACC:
			aPageCargo.setLiquid_asset_savings_acc_resp(settingProfileStatus(aPageCargo.getLiquid_asset_savings_acc_resp(),
					aSessionCargo.getLiquid_asset_savings_acc_resp()));
			return;
		case LIQUID_ASSET_PENSION_PLAN:
			aPageCargo.setLiquid_asset_pension_plan_resp(settingProfileStatus(aPageCargo.getLiquid_asset_pension_plan_resp(),
					aSessionCargo.getLiquid_asset_pension_plan_resp()));
			return;
		case LIQUID_ASSET_PROMISSORY:
			aPageCargo.setLiquid_asset_promissory_resp(settingProfileStatus(aPageCargo.getLiquid_asset_promissory_resp(),
					aSessionCargo.getLiquid_asset_promissory_resp()));
			return;
		case LIQUID_ASSET_RETIREMENT:
			aPageCargo.setLiquid_asset_retirement_resp(settingProfileStatus(aPageCargo.getLiquid_asset_retirement_resp(),
					aSessionCargo.getLiquid_asset_retirement_resp()));
			return;
		case LIQUID_ASSET_STOCK_BONDS:
			aPageCargo.setLiquid_asset_stocks_bonds_resp(settingProfileStatus(aPageCargo.getLiquid_asset_stocks_bonds_resp(),
					aSessionCargo.getLiquid_asset_stocks_bonds_resp()));
			return;
		case LIQUID_ASSET_TRUST_FUND:
			aPageCargo.setLiquid_asset_trust_fund_resp(settingProfileStatus(aPageCargo.getLiquid_asset_trust_fund_resp(),
					aSessionCargo.getLiquid_asset_trust_fund_resp()));
			return;
		case LIQUID_ASSET_OTHER:
			aPageCargo.setLiquid_asset_other_response(settingProfileStatus(aPageCargo.getLiquid_asset_other_response(),
					aSessionCargo.getLiquid_asset_other_response()));
			return;
		case LIQUID_ASSET_OTHER_TYPE:
			aPageCargo.setLiquid_asset_other_type_resp(settingProfileStatus(aPageCargo.getLiquid_asset_other_type_resp(),
					aSessionCargo.getLiquid_asset_other_type_resp()));
			return;

		case LIQ_ASET_HOME_SALE:
			aPageCargo.setLqd_aset_h_s_resp(settingProfileStatus(aPageCargo.getLqd_aset_h_s_resp(), aSessionCargo.getLqd_aset_h_s_resp()));
			return;

		case LIQ_ASET_US_BOND:
			aPageCargo.setLqd_aset_us_b_resp(settingProfileStatus(aPageCargo.getLqd_aset_us_b_resp(), aSessionCargo.getLqd_aset_us_b_resp()));
			return;

		case OTHR_ASET_BURIAL:
			aPageCargo.setOther_asset_burial_resp(settingProfileStatus(aPageCargo.getOther_asset_burial_resp(),
					aSessionCargo.getOther_asset_burial_resp()));
			return;

		case OTHR_ASET_LIFE_INSURANCE:
			aPageCargo.setOther_aset_life_insurance_resp(settingProfileStatus(aPageCargo.getOther_aset_life_insurance_resp(),
					aSessionCargo.getOther_aset_life_insurance_resp()));
			return;

		case OTHR_ASET_PERSONAL_PROPERTY:
			aPageCargo.setOther_asset_personal_prop_resp(settingProfileStatus(aPageCargo.getOther_asset_personal_prop_resp(),
					aSessionCargo.getOther_asset_personal_prop_resp()));
			return;

		case OTHR_ASET_REAL_PROPERTY:
			aPageCargo.setOther_asset_real_property_resp(settingProfileStatus(aPageCargo.getOther_asset_real_property_resp(),
					aSessionCargo.getOther_asset_real_property_resp()));
			return;

		case OTHR_ASET_VEHICLE:
			aPageCargo.setOther_asset_vehicle_resp(settingProfileStatus(aPageCargo.getOther_asset_vehicle_resp(),
					aSessionCargo.getOther_asset_vehicle_resp()));
			return;

		case OTHR_ASET_TRANSFER:
			aPageCargo.setOther_asset_transfer_resp(settingProfileStatus(aPageCargo.getOther_asset_transfer_resp(),
					aSessionCargo.getOther_asset_transfer_resp()));
			return;

		case REAL_ASET_APARTMENT:
			aPageCargo.setReal_aset_apt_resp(settingProfileStatus(aPageCargo.getReal_aset_apt_resp(), aSessionCargo.getReal_aset_apt_resp()));
			return;

		case REAL_ASET_RENTAL:
			aPageCargo.setReal_asset_rental_resp(settingProfileStatus(aPageCargo.getReal_asset_rental_resp(),
					aSessionCargo.getReal_asset_rental_resp()));
			return;

		case REAL_ASET_VAC:
			aPageCargo.setReal_aset_vac_resp(settingProfileStatus(aPageCargo.getReal_aset_vac_resp(), aSessionCargo.getReal_aset_vac_resp()));
			return;

		case REAL_ASET_COMMERCIAL:
			aPageCargo.setReal_aset_com_resp(settingProfileStatus(aPageCargo.getReal_aset_com_resp(), aSessionCargo.getReal_aset_com_resp()));
			return;

		case REAL_ASET_CONDO:
			aPageCargo.setReal_aset_con_resp(settingProfileStatus(aPageCargo.getReal_aset_con_resp(), aSessionCargo.getReal_aset_con_resp()));
			return;

		case REAL_ASET_DUPLEX:
			aPageCargo.setReal_aset_dup_resp(settingProfileStatus(aPageCargo.getReal_aset_dup_resp(), aSessionCargo.getReal_aset_dup_resp()));
			return;

		case REAL_ASET_FARM:
			aPageCargo.setReal_aset_frm_resp(settingProfileStatus(aPageCargo.getReal_aset_frm_resp(), aSessionCargo.getReal_aset_frm_resp()));
			return;

		case REAL_ASET_HOUSE:
			aPageCargo
					.setReal_asset_house_resp(settingProfileStatus(aPageCargo.getReal_asset_house_resp(), aSessionCargo.getReal_asset_house_resp()));
			return;

		case REAL_ASET_LAND:
			aPageCargo.setReal_asset_land_resp(settingProfileStatus(aPageCargo.getReal_asset_land_resp(), aSessionCargo.getReal_asset_land_resp()));
			return;

		case REAL_ASET_MOBILE_HOME:
			aPageCargo.setReal_asset_mobile_home_resp(settingProfileStatus(aPageCargo.getReal_asset_mobile_home_resp(),
					aSessionCargo.getReal_asset_mobile_home_resp()));
			return;

		case REAL_ASET_OTHER:
			aPageCargo
					.setReal_asset_other_resp(settingProfileStatus(aPageCargo.getReal_asset_other_resp(), aSessionCargo.getReal_asset_other_resp()));
			return;

		case REAL_ASET_HOME:
			aPageCargo.setReal_asset_home_resp(settingProfileStatus(aPageCargo.getReal_asset_home_resp(), aSessionCargo.getReal_asset_home_resp()));
			return;
		case REAL_ASET_LIFE_ESTATE:
			aPageCargo.setReal_asset_life_estate_resp(settingProfileStatus(aPageCargo.getReal_asset_life_estate_resp(),
					aSessionCargo.getReal_asset_life_estate_resp()));
			return;
		case REAL_ASET_UNOCCUPY_HOME:
			aPageCargo.setReal_asset_unoccupy_home_resp(settingProfileStatus(aPageCargo.getReal_asset_unoccupy_home_resp(),
					aSessionCargo.getReal_asset_unoccupy_home_resp()));
			return;
		case VEH_ASET_ANIMAL_DRAWN:
			aPageCargo.setVehicle_asset_animal_drwn_resp(settingProfileStatus(aPageCargo.getVehicle_asset_animal_drwn_resp(),
					aSessionCargo.getVehicle_asset_animal_drwn_resp()));
			return;
		case VEH_ASET_NONMOTORIZED_CAMPER:
			aPageCargo.setVehicle_asset_nmot_camper_resp(settingProfileStatus(aPageCargo.getVehicle_asset_nmot_camper_resp(),
					aSessionCargo.getVehicle_asset_nmot_camper_resp()));
			return;
		case VEH_ASET_TRACTOR:
			aPageCargo.setVehicle_asset_tractor_resp(settingProfileStatus(aPageCargo.getVehicle_asset_tractor_resp(),
					aSessionCargo.getVehicle_asset_tractor_resp()));
			return;
		case VEH_ASET_GOLFCART:
			aPageCargo.setVehicle_asset_golf_cart_resp(settingProfileStatus(aPageCargo.getVehicle_asset_golf_cart_resp(),
					aSessionCargo.getVehicle_asset_golf_cart_resp()));
			return;
		case VEH_ASET_AIRPLANE:
			aPageCargo.setVeh_aset_arpl_resp(settingProfileStatus(aPageCargo.getVeh_aset_arpl_resp(), aSessionCargo.getVeh_aset_arpl_resp()));
			return;
			// vehhicle
		case VEH_ASET_AUTOMOBILE:
			aPageCargo.setVehicle_asset_auto_resp(settingProfileStatus(aPageCargo.getVehicle_asset_auto_resp(),
					aSessionCargo.getVehicle_asset_auto_resp()));
			return;

		case VEH_ASET_BOAT:
			aPageCargo.setVehicle_asset_boat_resp(settingProfileStatus(aPageCargo.getVehicle_asset_boat_resp(),
					aSessionCargo.getVehicle_asset_boat_resp()));
			return;

		case VEH_ASET_BUS:
			aPageCargo.setVeh_aset_bus_resp(settingProfileStatus(aPageCargo.getVeh_aset_bus_resp(), aSessionCargo.getVeh_aset_bus_resp()));
			return;

		case VEH_ASET_CAMPER:
			aPageCargo.setVehicle_asset_camper_resp(settingProfileStatus(aPageCargo.getVehicle_asset_camper_resp(),
					aSessionCargo.getVehicle_asset_camper_resp()));
			return;

		case VEH_ASET_FARM_IMPLEMENT:
			aPageCargo.setVeh_aset_fimp_resp(settingProfileStatus(aPageCargo.getVeh_aset_fimp_resp(), aSessionCargo.getVeh_aset_fimp_resp()));
			return;

		case VEH_ASET_FARM_EQUIP:
			aPageCargo.setVeh_aset_fmeq_resp(settingProfileStatus(aPageCargo.getVeh_aset_fmeq_resp(), aSessionCargo.getVeh_aset_fmeq_resp()));
			return;

		case VEH_ASET_FARM_TRACTOR:
			aPageCargo.setVeh_aset_ftrc_resp(settingProfileStatus(aPageCargo.getVeh_aset_ftrc_resp(), aSessionCargo.getVeh_aset_ftrc_resp()));
			return;

		case VEH_ASET_FARM_TRAILER:
			aPageCargo.setVeh_aset_ftrl_resp(settingProfileStatus(aPageCargo.getVeh_aset_ftrl_resp(), aSessionCargo.getVeh_aset_ftrl_resp()));
			return;

		case VEH_ASET_LOG_SKIDDER:
			aPageCargo.setVeh_aset_lskd_resp(settingProfileStatus(aPageCargo.getVeh_aset_lskd_resp(), aSessionCargo.getVeh_aset_lskd_resp()));
			return;

		case VEH_ASET_MOTORCYCLE:
			aPageCargo.setVehicle_asset_motorcycle_resp(settingProfileStatus(aPageCargo.getVehicle_asset_motorcycle_resp(),
					aSessionCargo.getVehicle_asset_motorcycle_resp()));
			return;
		case VEH_ASET_NONMOTORIZED_BOAT:
			aPageCargo.setVeh_aset_nm_b_resp(settingProfileStatus(aPageCargo.getVeh_aset_nm_b_resp(), aSessionCargo.getVeh_aset_nm_b_resp()));
			return;

		case VEH_ASET_UNLIC:
			aPageCargo.setVeh_aset_unlic_resp(settingProfileStatus(aPageCargo.getVeh_aset_unlic_resp(), aSessionCargo.getVeh_aset_unlic_resp()));
			return;

		case VEH_ASET_OTHER:
			aPageCargo.setVeh_aset_othr_resp(settingProfileStatus(aPageCargo.getVeh_aset_othr_resp(), aSessionCargo.getVeh_aset_othr_resp()));
			return;

		case VEH_ASET_RECREATIONAL_VEHICLE:
			aPageCargo.setVehicle_asset_recreation_resp(settingProfileStatus(aPageCargo.getVehicle_asset_recreation_resp(),
					aSessionCargo.getVehicle_asset_recreation_resp()));
			return;

		case VEH_ASET_TRUCK:
			aPageCargo.setVeh_aset_trk_resp(settingProfileStatus(aPageCargo.getVeh_aset_trk_resp(), aSessionCargo.getVeh_aset_trk_resp()));
			return;

		case VEH_ASET_TRAVEL_TRAILER:
			aPageCargo.setVeh_aset_trlr_resp(settingProfileStatus(aPageCargo.getVeh_aset_trlr_resp(), aSessionCargo.getVeh_aset_trlr_resp()));
			return;

		case VEH_ASET_VAN:
			aPageCargo.setVeh_aset_van_resp(settingProfileStatus(aPageCargo.getVeh_aset_van_resp(), aSessionCargo.getVeh_aset_van_resp()));
			return;
			// PCR# 40362 - ADDED NEW RESPONSES FOR RMB AND SMRF CHANGES - ends

		case APRV_ACTV_RESP:
			return;
		case BNFT_CRT_O_KC_RESP:
			return;
		case BNFT_FC_RESP:
			return;
		case BNFT_KC_RESP:
			return;
		case BNFT_SG_RESP:
			return;
		case INDV_CC_RQST_IND:
			aPageCargo.setIndv_cc_rqst_ind(settingProfileStatus(aPageCargo.getIndv_cc_rqst_ind(), aSessionCargo.getIndv_cc_rqst_ind()));
			return;

		case INDV_TANF_RQST_IND:
			aPageCargo.setIndv_tanf_rqst_ind(settingProfileStatus(aPageCargo.getIndv_tanf_rqst_ind(), aSessionCargo.getIndv_tanf_rqst_ind()));
			return;

		case INDV_WIC_RQST_IND:
			aPageCargo.setIndv_wic_rqst_ind(settingProfileStatus(aPageCargo.getIndv_wic_rqst_ind(), aSessionCargo.getIndv_wic_rqst_ind()));
			return;

		case SCHL_ENRL_RESP:
			aPageCargo.setSchool_enrollment_resp(settingProfileStatus(aPageCargo.getSchool_enrollment_resp(),
					aSessionCargo.getSchool_enrollment_resp()));
			return;
		case TRB_CMDY_RESP:
			aPageCargo.setTrb_cmdy_resp(settingProfileStatus(aPageCargo.getTrb_cmdy_resp(), aSessionCargo.getTrb_cmdy_resp()));
			return;
		case HEAD_OF_HOUSE:
			aPageCargo.setHead_of_household_resp(settingProfileStatus(aPageCargo.getHead_of_household_resp(),
					aSessionCargo.getHead_of_household_resp()));
			return;
			// EDSP OTHER INCOME TYPES
		case STRIKE_BENEFITS_RESP:
			aPageCargo.setBenefits_on_strike_resp(settingProfileStatus(aPageCargo.getBenefits_on_strike_resp(),
					aSessionCargo.getBenefits_on_strike_resp()));
			return;
		case TRAINING_ALLOWANCE:
			aPageCargo.setTraining_allowance_resp(settingProfileStatus(aPageCargo.getTraining_allowance_resp(),
					aSessionCargo.getTraining_allowance_resp()));
			return;
		case INHERITANCE:
			aPageCargo.setInheritance_resp(settingProfileStatus(aPageCargo.getInheritance_resp(), aSessionCargo.getInheritance_resp()));
			return;
		case STUDENT_FINANCIAL_AID:
			aPageCargo.setStudent_financial_aid_resp(settingProfileStatus(aPageCargo.getStudent_financial_aid_resp(),
					aSessionCargo.getStudent_financial_aid_resp()));
			return;
		case FOOD_CLOTHING_UTIL_RENT:
			aPageCargo.setFood_clothing_util_rent_resp(settingProfileStatus(aPageCargo.getFood_clothing_util_rent_resp(),
					aSessionCargo.getFood_clothing_util_rent_resp()));
			return;
		case CASH_GIFTS_CONT:
			aPageCargo.setCash_gifts_resp(settingProfileStatus(aPageCargo.getCash_gifts_resp(), aSessionCargo.getCash_gifts_resp()));
			return;
		case LOAN:
			aPageCargo.setLoan_resp(settingProfileStatus(aPageCargo.getLoan_resp(), aSessionCargo.getLoan_resp()));
			return;
		case BLACK_LUNG_BENEFIT:
			aPageCargo.setBenefit_black_lung_resp(settingProfileStatus(aPageCargo.getBenefit_black_lung_resp(),
					aSessionCargo.getBenefit_black_lung_resp()));
			return;
		case LOTTERY_PRIZE_WINNING:
			aPageCargo.setLottery_prize_winning_resp(settingProfileStatus(aPageCargo.getLottery_prize_winning_resp(),
					aSessionCargo.getLottery_prize_winning_resp()));
			return;
		case INSURANCE_SETTLEMENT:
			aPageCargo.setInsurance_settlement_resp(settingProfileStatus(aPageCargo.getInsurance_settlement_resp(),
					aSessionCargo.getInsurance_settlement_resp()));
			return;
		case OTHR_SOCIAL_SECURITY_BENEFITS:
			aPageCargo.setOthr_social_security_bnft_resp(settingProfileStatus(aPageCargo.getOthr_social_security_bnft_resp(),
					aSessionCargo.getOthr_social_security_bnft_resp()));
			return;
		case RESETTL_INC_RESP:
			aPageCargo.setResettl_inc_resp(settingProfileStatus(aPageCargo.getResettl_inc_resp(), aSessionCargo.getResettl_inc_resp()));
			return;
		case OTHR_INCM_RENTL_RESP:
			aPageCargo.setOthr_incm_rentl_resp(settingProfileStatus(aPageCargo.getOthr_incm_rentl_resp(), aSessionCargo.getOthr_incm_rentl_resp()));
			return;
		case LAND_CONT_RESP:
			aPageCargo.setLand_cont_resp(settingProfileStatus(aPageCargo.getLand_cont_resp(), aSessionCargo.getLand_cont_resp()));
			return;
		case HOUSING_BILLS_OTHERS:
			aPageCargo.setHousing_bill_others_resp(settingProfileStatus(aPageCargo.getHousing_bill_others_resp(),
					aSessionCargo.getHousing_bill_others_resp()));
			return;
		case UTILITY_BILLS_OIL:
			aPageCargo.setUtility_bills_oil_resp(settingProfileStatus(aPageCargo.getUtility_bills_oil_resp(),
					aSessionCargo.getUtility_bills_oil_resp()));
			return;
			// housing bills
		case WORK_RELATED_EXPENSE_RESP:
			aPageCargo.setWork_related_expense_resp(settingProfileStatus(aPageCargo.getWork_related_expense_resp(),
					aSessionCargo.getWork_related_expense_resp()));
			return;
		case LIFE_INS_ASSET_WHOLE_LIFE_RESP:
			aPageCargo.setLife_ins_asset_whole_life_resp(settingProfileStatus(aPageCargo.getLife_ins_asset_whole_life_resp(),
					aSessionCargo.getLife_ins_asset_whole_life_resp()));
			return;
		case LIFE_INSURANCE_ASSET_TERM_RESP:
			aPageCargo.setLife_insurance_asset_term_resp(settingProfileStatus(aPageCargo.getLife_insurance_asset_term_resp(),
					aSessionCargo.getLife_insurance_asset_term_resp()));
			return;
		case LIFE_INS_ASEST_GROUP_LIFE_RESP:
			aPageCargo.setLife_ins_asest_group_life_resp(settingProfileStatus(aPageCargo.getLife_ins_asest_group_life_resp(),
					aSessionCargo.getLife_ins_asest_group_life_resp()));
			return;

		case LIFE_INS_ASSET_GROUP_TERM_RESP:
			aPageCargo.setLife_ins_asset_group_term_resp(settingProfileStatus(aPageCargo.getLife_ins_asset_group_term_resp(),
					aSessionCargo.getLife_ins_asset_group_term_resp()));
			return;

		case LIFE_INS_ASSET_UNIVERSAL_RESP:
			aPageCargo.setLife_ins_asset_universal_resp(settingProfileStatus(aPageCargo.getLife_ins_asset_universal_resp(),
					aSessionCargo.getLife_ins_asset_universal_resp()));
			return;
		case MED_TYPE_PROSTHETIC_RESP:
			aPageCargo.setMed_type_prosthetic_resp(settingProfileStatus(aPageCargo.getMed_type_prosthetic_resp(),
					aSessionCargo.getMed_type_prosthetic_resp()));
			return;

		case MED_TYPE_ATNDNT_MEAL_RESP:
			aPageCargo.setMed_type_atndnt_meal_resp(settingProfileStatus(aPageCargo.getMed_type_atndnt_meal_resp(),
					aSessionCargo.getMed_type_atndnt_meal_resp()));
			return;
		case MED_TYPE_ANIMAL_RESP:
			aPageCargo.setMed_type_animal_resp(settingProfileStatus(aPageCargo.getMed_type_animal_resp(), aSessionCargo.getMed_type_animal_resp()));
			return;
		case MED_TYPE_MAINTAIN_ATTNDNT_RESP:
			aPageCargo.setMed_type_maintain_attndnt_resp(settingProfileStatus(aPageCargo.getMed_type_maintain_attndnt_resp(),
					aSessionCargo.getMed_type_maintain_attndnt_resp()));
			return;
		case MED_TYPE_INHOME_RESP:
			aPageCargo.setMed_type_inhome_resp(settingProfileStatus(aPageCargo.getMed_type_inhome_resp(), aSessionCargo.getMed_type_inhome_resp()));
			return;
		case MED_TYPE_SPECIAL_EQUIP_RESP:
			aPageCargo.setMed_type_special_equip_resp(settingProfileStatus(aPageCargo.getMed_type_special_equip_resp(),
					aSessionCargo.getMed_type_special_equip_resp()));
			return;
		case MED_TYPE_EYEGLASSES_RESP:
			aPageCargo.setMed_type_eyeglasses_resp(settingProfileStatus(aPageCargo.getMed_type_eyeglasses_resp(),
					aSessionCargo.getMed_type_eyeglasses_resp()));
			return;
		case MED_TYPE_INSURANCE_RESP:
			aPageCargo.setMed_type_insurance_resp(settingProfileStatus(aPageCargo.getMed_type_insurance_resp(),
					aSessionCargo.getMed_type_insurance_resp()));
			return;
		case MED_TYPE_BILLS_RESP:
			aPageCargo.setMed_type_bills_resp(settingProfileStatus(aPageCargo.getMed_type_bills_resp(), aSessionCargo.getMed_type_bills_resp()));
			return;
		case MED_TYPE_SUPPLIES_RESP:
			aPageCargo.setMed_type_supplies_resp(settingProfileStatus(aPageCargo.getMed_type_supplies_resp(),
					aSessionCargo.getMed_type_supplies_resp()));
			return;
		case MED_TYPE_NURSING_RESP:
			aPageCargo
					.setMed_type_nursing_resp(settingProfileStatus(aPageCargo.getMed_type_nursing_resp(), aSessionCargo.getMed_type_nursing_resp()));
			return;
		case MED_TYPE_OTHER_RESP:
			aPageCargo.setMed_type_other_resp(settingProfileStatus(aPageCargo.getMed_type_other_resp(), aSessionCargo.getMed_type_other_resp()));
			return;
		case MED_TYPE_OUT_PATIENT_RESP:
			aPageCargo.setMed_type_out_patient_resp(settingProfileStatus(aPageCargo.getMed_type_out_patient_resp(),
					aSessionCargo.getMed_type_out_patient_resp()));
			return;
		case MED_TYPE_PSYCHOTHERAPY_RESP:
			aPageCargo.setMed_type_psychotherapy_resp(settingProfileStatus(aPageCargo.getMed_type_psychotherapy_resp(),
					aSessionCargo.getMed_type_psychotherapy_resp()));
			return;
		case MED_TYPE_PRESCRIBED_DRUG_RESP:
			aPageCargo.setMed_type_prescribed_drug_resp(settingProfileStatus(aPageCargo.getMed_type_prescribed_drug_resp(),
					aSessionCargo.getMed_type_prescribed_drug_resp()));
			return;
		case MED_TYPE_TRANSPORTATION_RESP:
			aPageCargo.setMed_type_transportation_resp(settingProfileStatus(aPageCargo.getMed_type_transportation_resp(),
					aSessionCargo.getMed_type_transportation_resp()));
			return;
		case UTILITY_STANDARD_RESP:
			aPageCargo
					.setUtility_standard_resp(settingProfileStatus(aPageCargo.getUtility_standard_resp(), aSessionCargo.getUtility_standard_resp()));
			return;
		case LIFE_INSURANCE_OTHER_RESP:
			aPageCargo.setLife_insurance_other_resp(settingProfileStatus(aPageCargo.getLife_insurance_other_resp(),
					aSessionCargo.getLife_insurance_other_resp()));
			return;
		case HOSPITAL_STAY_RESP:
			aPageCargo.setHospital_stay_resp(settingProfileStatus(aPageCargo.getHospital_stay_resp(), aSessionCargo.getHospital_stay_resp()));
			return;

		case CHILD_CARE_RESP:
			aPageCargo.setChild_care_resp(settingProfileStatus(aPageCargo.getChild_care_resp(), aSessionCargo.getChild_care_resp()));
			return;

		case CHILD_OBLIGATION_RESP:
			aPageCargo
					.setChild_obligation_resp(settingProfileStatus(aPageCargo.getChild_obligation_resp(), aSessionCargo.getChild_obligation_resp()));
			return;

		case MEDICAL_BILLS_RESP:
			aPageCargo.setMedical_bills_resp(settingProfileStatus(aPageCargo.getMedical_bills_resp(), aSessionCargo.getMedical_bills_resp()));
			return;

		case OTHR_INCM_CONTRIB_RESP:
			aPageCargo.setOther_incm_contrib_resp(settingProfileStatus(aPageCargo.getOther_incm_contrib_resp(),
					aSessionCargo.getOther_incm_contrib_resp()));
			return;
		case OTHR_INCM_TRBL_RESP:
			aPageCargo.setOthr_incm_trbl_resp(settingProfileStatus(aPageCargo.getOthr_incm_trbl_resp(), aSessionCargo.getOthr_incm_trbl_resp()));
			return;
		case MEDTYP_DENTAL:
			aPageCargo.setMedtyp_dental(settingProfileStatus(aPageCargo.getMedtyp_dental(), aSessionCargo.getMedtyp_dental()));
			return;
		case MEDTYP_ATTENDANT_CARE:
			aPageCargo
					.setMedtyp_attendant_care(settingProfileStatus(aPageCargo.getMedtyp_attendant_care(), aSessionCargo.getMedtyp_attendant_care()));
			return;
		case MEDTYP_DOCTOR:
			aPageCargo.setMedtyp_doctor(settingProfileStatus(aPageCargo.getMedtyp_doctor(), aSessionCargo.getMedtyp_doctor()));
			return;
		case MEDTYP_MED_EQUIP:
			aPageCargo.setMedtyp_med_equip(settingProfileStatus(aPageCargo.getMedtyp_med_equip(), aSessionCargo.getMedtyp_med_equip()));
			return;
		case MEDTYP_HOSP_BILLS:
			aPageCargo.setMedtyp_hosp_bills(settingProfileStatus(aPageCargo.getMedtyp_hosp_bills(), aSessionCargo.getMedtyp_hosp_bills()));
			return;
		case MEDTYP_INSUR_PREMIUM:
			aPageCargo.setMedtyp_insur_premium(settingProfileStatus(aPageCargo.getMedtyp_insur_premium(), aSessionCargo.getMedtyp_insur_premium()));
			return;
		case MEDTYP_RX_COST:
			aPageCargo.setMedtyp_rx_cost(settingProfileStatus(aPageCargo.getMedtyp_rx_cost(), aSessionCargo.getMedtyp_rx_cost()));
			return;
		case MEDTYP_TRANS_MED:
			aPageCargo.setMedtyp_trans_med(settingProfileStatus(aPageCargo.getMedtyp_trans_med(), aSessionCargo.getMedtyp_trans_med()));
			return;
		case MEDTYP_OTHER:
			aPageCargo.setMedtyp_other(settingProfileStatus(aPageCargo.getMedtyp_other(), aSessionCargo.getMedtyp_other()));
			return;
		case UNPAID_MEDBILL:
			aPageCargo.setUnpaid_medbill(settingProfileStatus(aPageCargo.getUnpaid_medbill(), aSessionCargo.getUnpaid_medbill()));
			return;
		case MEDTYP_HSA_CONTRIB:
			aPageCargo.setMedtyp_hsa_contrib(settingProfileStatus(aPageCargo.getMedtyp_hsa_contrib(), aSessionCargo.getMedtyp_hsa_contrib()));

			return;

		case PERS_PROP_BUS_EQPT:
			aPageCargo.setPers_prop_bus_eqpt(settingProfileStatus(aPageCargo.getPers_prop_bus_eqpt(), aSessionCargo.getPers_prop_bus_eqpt()));
			return;
		case PERS_PROP_CEMETARY_LOT:
			aPageCargo.setPers_prop_cemetary_lot(settingProfileStatus(aPageCargo.getPers_prop_cemetary_lot(),
					aSessionCargo.getPers_prop_cemetary_lot()));
			return;
		case PERS_PROP_LIVESTOCK:
			aPageCargo.setPers_prop_livestock(settingProfileStatus(aPageCargo.getPers_prop_livestock(), aSessionCargo.getPers_prop_livestock()));
			return;
		case PERS_PROP_SAF_DEPST_BOX:
			aPageCargo.setPers_prop_saf_depst_box(settingProfileStatus(aPageCargo.getPers_prop_saf_depst_box(),
					aSessionCargo.getPers_prop_saf_depst_box()));
			return;
		case PERS_PROP_OTH_VAL:
			aPageCargo.setPers_prop_oth_val(settingProfileStatus(aPageCargo.getPers_prop_oth_val(), aSessionCargo.getPers_prop_oth_val()));
			return;
		case ABLE_TO_CONCEIVE_RESP:
			aPageCargo
					.setAble_to_conceive_resp(settingProfileStatus(aPageCargo.getAble_to_conceive_resp(), aSessionCargo.getAble_to_conceive_resp()));
			return;
		case UNDERWEIGHT_BIRTH_RESP:
			aPageCargo.setUnderweight_birth_resp(settingProfileStatus(aPageCargo.getUnderweight_birth_resp(),
					aSessionCargo.getUnderweight_birth_resp()));
			return;

		case PREG_ADD_STAT_SW:
			aPageCargo.setPreg_add_stat_sw(settingProfileStatus(aPageCargo.getPreg_add_stat_sw(), aSessionCargo.getPreg_add_stat_sw()));
			return;
		case PREG_CHG_STAT_SW:
			aPageCargo.setPreg_chg_stat_sw(settingProfileStatus(aPageCargo.getPreg_chg_stat_sw(), aSessionCargo.getPreg_chg_stat_sw()));
			return;

		case UEI_ADOPTION_ASSIST:
			aPageCargo.setAdoptAssistance(settingProfileStatus(aPageCargo.getAdoptAssistance(), aSessionCargo.getAdoptAssistance()));
			return;
		case UEI_ADOPTION_PYMT:
			aPageCargo.setAdoptionPayments(settingProfileStatus(aPageCargo.getAdoptionPayments(), aSessionCargo.getAdoptionPayments()));
			return;
		case UEI_AGENT_ORNG_PYMT:
			aPageCargo.setAgentOrangePayments(settingProfileStatus(aPageCargo.getAgentOrangePayments(), aSessionCargo.getAgentOrangePayments()));
			return;
		case UEI_ALIMONY:
			aPageCargo.setAlimony(settingProfileStatus(aPageCargo.getAlimony(), aSessionCargo.getAlimony()));
			return;
		case UEI_CAPITAL_GAINS:
			aPageCargo.setCapitalGains(settingProfileStatus(aPageCargo.getCapitalGains(), aSessionCargo.getCapitalGains()));
			return;
		case UEI_DEATH_BNFT:
			aPageCargo.setDeathBenefits(settingProfileStatus(aPageCargo.getDeathBenefits(), aSessionCargo.getDeathBenefits()));
			return;
		case UEI_DABL_INCM:
			aPageCargo.setDisabilityIncome(settingProfileStatus(aPageCargo.getDisabilityIncome(), aSessionCargo.getDisabilityIncome()));
			return;
		case UEI_DR_RELIEF:
			aPageCargo.setDisasterRelief(settingProfileStatus(aPageCargo.getDisasterRelief(), aSessionCargo.getDisasterRelief()));
			return;
		case UEI_EDU_ASSIST:
			aPageCargo
					.setEducationalAssistance(settingProfileStatus(aPageCargo.getEducationalAssistance(), aSessionCargo.getEducationalAssistance()));
			return;
		case UEI_ENERGY_ASSIST:
			aPageCargo.setEnergyAssistance(settingProfileStatus(aPageCargo.getEnergyAssistance(), aSessionCargo.getEnergyAssistance()));
			return;
		case UEI_FRM_ALOT:
			aPageCargo.setFarmAllotment(settingProfileStatus(aPageCargo.getFarmAllotment(), aSessionCargo.getFarmAllotment()));
			return;
		case UEI_FOSTER_CARE_PYMT:
			aPageCargo.setFosterCarePayments(settingProfileStatus(aPageCargo.getFosterCarePayments(), aSessionCargo.getFosterCarePayments()));
			return;
		case UEI_GEN_ASSIST:
			aPageCargo.setGeneralAssistance(settingProfileStatus(aPageCargo.getGeneralAssistance(), aSessionCargo.getGeneralAssistance()));
			return;
		case UEI_INT_DIV_PYMT:
			aPageCargo.setInterestDividendPayments(settingProfileStatus(aPageCargo.getInterestDividendPayments(),
					aSessionCargo.getInterestDividendPayments()));
			return;
		case UEI_IRA_DIST:
			aPageCargo.setiRADistribution(settingProfileStatus(aPageCargo.getiRADistribution(), aSessionCargo.getiRADistribution()));
			return;
		case UEI_LOTTERY_WIN:
			aPageCargo.setLotteryWinnings(settingProfileStatus(aPageCargo.getLotteryWinnings(), aSessionCargo.getLotteryWinnings()));
			return;
		case UEI_LUMP_SUM:
			aPageCargo.setLumpSum(settingProfileStatus(aPageCargo.getLumpSum(), aSessionCargo.getLumpSum()));
			return;
		case UEI_MIL_ALOT:
			aPageCargo.setMilitaryAllotment(settingProfileStatus(aPageCargo.getMilitaryAllotment(), aSessionCargo.getMilitaryAllotment()));
			return;
		case UEI_MON_FRO_OTH:
			aPageCargo.setMoneyFromAnotherPerson(settingProfileStatus(aPageCargo.getMoneyFromAnotherPerson(),
					aSessionCargo.getMoneyFromAnotherPerson()));
			return;
		case UEI_NET_RENT_ROYALTY:
			aPageCargo.setNetRentalRoyalty(settingProfileStatus(aPageCargo.getNetRentalRoyalty(), aSessionCargo.getNetRentalRoyalty()));
			return;
		case UEI_OTH:
			aPageCargo.setOtherIncome(settingProfileStatus(aPageCargo.getOtherIncome(), aSessionCargo.getOtherIncome()));
			return;
		case UEI_ANNY_PYMT:
			aPageCargo.setPaymentsFromAnnuity(settingProfileStatus(aPageCargo.getPaymentsFromAnnuity(), aSessionCargo.getPaymentsFromAnnuity()));
			return;
		case UEI_PYMT_BO:
			aPageCargo.setPaymentsMadeOnYourBehalf(settingProfileStatus(aPageCargo.getPaymentsMadeOnYourBehalf(),
					aSessionCargo.getPaymentsMadeOnYourBehalf()));
			return;
		case UEI_PENSION:
			aPageCargo.setPensionOrRetirement(settingProfileStatus(aPageCargo.getPensionOrRetirement(), aSessionCargo.getPensionOrRetirement()));
			return;
		case UEI_RR_RETIRE:
			aPageCargo.setRailroadRetirement(settingProfileStatus(aPageCargo.getRailroadRetirement(), aSessionCargo.getRailroadRetirement()));
			return;
		case UEI_REFUGEE_CASH:
			aPageCargo.setRefugeeCash(settingProfileStatus(aPageCargo.getRefugeeCash(), aSessionCargo.getRefugeeCash()));
			return;
		case UEI_REL_CARE:
			aPageCargo.setRelativeCareSubsidy(settingProfileStatus(aPageCargo.getRelativeCareSubsidy(), aSessionCargo.getRelativeCareSubsidy()));
			return;
		case UEI_RENTAL_INCM:
			aPageCargo.setRentalIncome(settingProfileStatus(aPageCargo.getRentalIncome(), aSessionCargo.getRentalIncome()));
			return;
		case UEI_TANF_PYMT:
			aPageCargo.settANFPayments(settingProfileStatus(aPageCargo.gettANFPayments(), aSessionCargo.gettANFPayments()));
			return;
		case UEI_UNEMPL:
			aPageCargo.setUnemploymentCompensation(settingProfileStatus(aPageCargo.getUnemploymentCompensation(),
					aSessionCargo.getUnemploymentCompensation()));
			return;
		case UEI_WORKER_STUDY:
			aPageCargo
					.setWorkStudyStateFederal(settingProfileStatus(aPageCargo.getWorkStudyStateFederal(), aSessionCargo.getWorkStudyStateFederal()));
			return;
		case UEI_WORKER_COMP:
			aPageCargo.setWorkersCompensation(settingProfileStatus(aPageCargo.getWorkersCompensation(), aSessionCargo.getWorkersCompensation()));
			return;

		case SU_CST_INS_RESP:
			aPageCargo.setSu_cst_ins_resp(settingProfileStatus(aPageCargo.getSu_cst_ins_resp(), aSessionCargo.getSu_cst_ins_resp()));
			return;
		case OTHER_HOUSING_BILL_RESP:
			aPageCargo.setOther_housing_bill_resp(settingProfileStatus(aPageCargo.getOther_housing_bill_resp(),
					aSessionCargo.getOther_housing_bill_resp()));
			return;
		case DISASTER_REPAIR_RESP:
			aPageCargo.setDisaster_repair_resp(settingProfileStatus(aPageCargo.getDisaster_repair_resp(), aSessionCargo.getDisaster_repair_resp()));
			return;
		case PREVENT_EVICTION_RESP:
			aPageCargo
					.setPrevent_eviction_resp(settingProfileStatus(aPageCargo.getPrevent_eviction_resp(), aSessionCargo.getPrevent_eviction_resp()));
			return;
		case CARE_TAKER_RESP:
			aPageCargo.setCareTaker_resp(settingProfileStatus(aPageCargo.getCareTaker_resp(), aSessionCargo.getCareTaker_resp()));
			return;
		case LOST_HEALTH_INS_IND:
			aPageCargo.setLost_health_ins_ind(settingProfileStatus(aPageCargo.getLost_health_ins_ind(), aSessionCargo.getLost_health_ins_ind()));
			return;
		case TAX_CLAIM_DEPENDENT:
			aPageCargo.setTax_claim_dependant_resp(settingProfileStatus(aPageCargo.getTax_claim_dependant_resp(),
					aSessionCargo.getTax_claim_dependant_resp()));
			return;
			//NextGen  NG-6481 Phase 3 updates to ACA Streamline changes : Start
		case BEFORE_TAX_DEDUCTION:
			aPageCargo.setBefore_tax_deduction_resp(settingProfileStatus(aPageCargo.getBefore_tax_deduction_resp(),
					aSessionCargo.getBefore_tax_deduction_resp()));
			return;
		case BTD_MED_INS:
			aPageCargo.setBtd_med_ins(settingProfileStatus(aPageCargo.getBtd_med_ins(), aSessionCargo.getBtd_med_ins()));
			return;
		case BTD_DENT_INS:
			aPageCargo.setBtd_dent_ins(settingProfileStatus(aPageCargo.getBtd_dent_ins(), aSessionCargo.getBtd_dent_ins()));
			return;
		case BTD_VIS_CARE_INS:
			aPageCargo.setBtd_vis_care_ins(settingProfileStatus(aPageCargo.getBtd_vis_care_ins(), aSessionCargo.getBtd_vis_care_ins()));
			return;
		case BTD_FLEX_ACC:
			aPageCargo.setBtd_flex_acc(settingProfileStatus(aPageCargo.getBtd_flex_acc(), aSessionCargo.getBtd_flex_acc()));
			return;
		case BTD_DEF_COMP:
			aPageCargo.setBtd_def_comp(settingProfileStatus(aPageCargo.getBtd_def_comp(), aSessionCargo.getBtd_def_comp()));
			return;
		case BTD_PRE_TAX_INS:
			aPageCargo.setBtd_pre_tax_ins(settingProfileStatus(aPageCargo.getBtd_pre_tax_ins(), aSessionCargo.getBtd_pre_tax_ins()));
			return;
		case BTD_OTHER:
			aPageCargo.setBtd_other(settingProfileStatus(aPageCargo.getBtd_other(), aSessionCargo.getBtd_other()));
			return;
			//NextGen  NG-6481 Phase 3 updates to ACA Streamline changes : End
			// NextGen NG-6481 Phase 3 updates to ACA Streamline changes – start
		case TAX_DEDUCT_RESP:
			aPageCargo.setTax_deduct_resp(settingProfileStatus(aPageCargo.getTax_deduct_resp(), aSessionCargo.getTax_deduct_resp()));
			return;
			// NextGen NG-6481 Phase 3 updates to ACA Streamline changes – end

		case HLTH_INS_RESP:
			aPageCargo.setHlth_ins_resp(settingProfileStatus(aPageCargo.getHlth_ins_resp(), aSessionCargo.getHlth_ins_resp()));
			return;
		case OTHR_HLTH_INS_RESP:
			aPageCargo.setOthr_hlth_ins_resp(settingProfileStatus(aPageCargo.getOthr_hlth_ins_resp(), aSessionCargo.getOthr_hlth_ins_resp()));
			return;

		case ROOM_BRD_CHG_IND:
			aPageCargo.setRoom_brd_chg_ind(settingProfileStatus(aPageCargo.getRoom_brd_chg_ind(), aSessionCargo.getRoom_brd_chg_ind()));
			return;

		case DABL_STAT_IND:
			aPageCargo.setDabl_stat_ind(settingProfileStatus(aPageCargo.getDabl_stat_ind(), aSessionCargo.getDabl_stat_ind()));
			return;

		case PREG_ADD_STAT_IND:
			aPageCargo.setPreg_add_stat_ind(settingProfileStatus(aPageCargo.getPreg_add_stat_ind(), aSessionCargo.getPreg_add_stat_ind()));
			return;

		case PREG_CHG_IND:
			aPageCargo.setPreg_chg_ind(settingProfileStatus(aPageCargo.getPreg_chg_ind(), aSessionCargo.getPreg_chg_ind()));
			return;
		case IRWE_CHG_IND:
			aPageCargo.setIrwe_chg_ind(settingProfileStatus(aPageCargo.getIrwe_chg_ind(), aSessionCargo.getIrwe_chg_ind()));
			return;
		case EI_CHG_IND:
			aPageCargo.setEi_chg_ind(settingProfileStatus(aPageCargo.getEi_chg_ind(), aSessionCargo.getEi_chg_ind()));
			return;
		case SELF_EMPL_CHG_IND:
			aPageCargo.setSelf_empl_chg_ind(settingProfileStatus(aPageCargo.getSelf_empl_chg_ind(), aSessionCargo.getSelf_empl_chg_ind()));
			return;
		case OTHR_INCM_CHG_IND:
			aPageCargo.setOthr_incm_chg_ind(settingProfileStatus(aPageCargo.getOthr_incm_chg_ind(), aSessionCargo.getOthr_incm_chg_ind()));
			return;
		case EMPL_CHG_IND:
			aPageCargo.setEmpl_chg_ind(settingProfileStatus(aPageCargo.getEmpl_chg_ind(), aSessionCargo.getEmpl_chg_ind()));
			return;
		case VEH_ASET_ADD_IND:
			aPageCargo.setVeh_aset_add_ind(settingProfileStatus(aPageCargo.getVeh_aset_add_ind(), aSessionCargo.getVeh_aset_add_ind()));
			return;
		case VEH_ASET_CHG_IND:
			aPageCargo.setVeh_aset_chg_ind(settingProfileStatus(aPageCargo.getVeh_aset_chg_ind(), aSessionCargo.getVeh_aset_chg_ind()));
			return;
		case REAL_ASET_ADD_IND:
			aPageCargo.setReal_aset_add_ind(settingProfileStatus(aPageCargo.getReal_aset_add_ind(), aSessionCargo.getReal_aset_add_ind()));
			return;
		case REAL_ASET_CHG_IND:
			aPageCargo.setReal_aset_chg_ind(settingProfileStatus(aPageCargo.getReal_aset_chg_ind(), aSessionCargo.getReal_aset_chg_ind()));
			return;
		case BURY_ASET_ADD_IND:
			aPageCargo.setBury_aset_add_ind(settingProfileStatus(aPageCargo.getBury_aset_add_ind(), aSessionCargo.getBury_aset_add_ind()));
			return;
		case BURY_ASET_CHG_IND:
			aPageCargo.setBury_aset_chg_ind(settingProfileStatus(aPageCargo.getBury_aset_chg_ind(), aSessionCargo.getBury_aset_chg_ind()));
			return;
		case LIQUID_ASSET_ADD_IND:
			aPageCargo.setLiquid_asset_add_ind(settingProfileStatus(aPageCargo.getLiquid_asset_add_ind(), aSessionCargo.getLiquid_asset_add_ind()));
			return;
		case LIQUID_ASSET_BANK_ACC_CHG_IND:
			aPageCargo.setLiquid_asset_bank_acc_chg_ind(settingProfileStatus(aPageCargo.getLiquid_asset_bank_acc_chg_ind(),
					aSessionCargo.getLiquid_asset_bank_acc_chg_ind()));
			return;
		case LIQUID_ASSET_CASH_CHG_IND:
			aPageCargo.setLiquid_asset_cash_chg_ind(settingProfileStatus(aPageCargo.getLiquid_asset_cash_chg_ind(),
					aSessionCargo.getLiquid_asset_cash_chg_ind()));
			return;
		case LIQUID_ASSET_CHG_IND:
			aPageCargo.setLiquid_asset_chg_ind(settingProfileStatus(aPageCargo.getLiquid_asset_chg_ind(), aSessionCargo.getLiquid_asset_chg_ind()));
			return;
		case LIQUID_ASSET_OTHER_CHG_IND:
			aPageCargo.setLiquid_asset_other_chg_ind(settingProfileStatus(aPageCargo.getLiquid_asset_other_chg_ind(),
					aSessionCargo.getLiquid_asset_other_chg_ind()));
			return;
		case LIFE_INS_ASET_ADD_IND:
			aPageCargo
			.setLife_ins_aset_add_ind(settingProfileStatus(aPageCargo.getLife_ins_aset_add_ind(), aSessionCargo.getLife_ins_aset_add_ind()));
			return;
		case LIFE_INS_ASET_CHG_IND:
			aPageCargo
			.setLife_ins_aset_chg_ind(settingProfileStatus(aPageCargo.getLife_ins_aset_chg_ind(), aSessionCargo.getLife_ins_aset_chg_ind()));
			return;
		case ASET_XFER_CHG_IND:
			aPageCargo.setAset_xfer_chg_ind(settingProfileStatus(aPageCargo.getAset_xfer_chg_ind(), aSessionCargo.getAset_xfer_chg_ind()));
			return;
		case DPND_CARE_CHG_IND:
			aPageCargo.setDpnd_care_chg_ind(settingProfileStatus(aPageCargo.getDpnd_care_chg_ind(), aSessionCargo.getDpnd_care_chg_ind()));
			return;
		case HEALTH_INSURANCE_CHG_IND:
			aPageCargo.setHealth_insurance_chg_ind(settingProfileStatus(aPageCargo.getHealth_insurance_chg_ind(),
					aSessionCargo.getHealth_insurance_chg_ind()));
			return;
		case OUT_ST_BNFT_CHG_IND:
			aPageCargo.setOut_st_bnft_chg_ind(settingProfileStatus(aPageCargo.getOut_st_bnft_chg_ind(), aSessionCargo.getOut_st_bnft_chg_ind()));
			return;
		case SCHL_ENRL_CHG_IND:
			aPageCargo.setSchl_enrl_chg_ind(settingProfileStatus(aPageCargo.getSchl_enrl_chg_ind(), aSessionCargo.getSchl_enrl_chg_ind()));
			return;
		case MRTL_STAT_CHG_IND:
			aPageCargo.setMrtl_stat_chg_ind(settingProfileStatus(aPageCargo.getMrtl_stat_chg_ind(), aSessionCargo.getMrtl_stat_chg_ind()));
			return;
		case NUR_HME_CHG_IND:
			aPageCargo.setNur_hme_chg_ind(settingProfileStatus(aPageCargo.getNur_hme_chg_ind(), aSessionCargo.getNur_hme_chg_ind()));
			return;
		case BFR_TAX_CHG_IND:
			aPageCargo.setBfr_tax_chg_ind(settingProfileStatus(aPageCargo.getBfr_tax_chg_ind(), aSessionCargo.getBfr_tax_chg_ind()));
			return;
		case INC_TAX_CHG_IND:
			aPageCargo.setInc_tax_chg_ind(settingProfileStatus(aPageCargo.getInc_tax_chg_ind(), aSessionCargo.getInc_tax_chg_ind()));
			return;
		case THRD_PRTY_CHG_IND:
			aPageCargo.setThrd_prty_chg_ind(settingProfileStatus(aPageCargo.getThrd_prty_chg_ind(), aSessionCargo.getThrd_prty_chg_ind()));
			return;
		case CHILD_SUPPORT_PAYMENT_CHG_IND:
			aPageCargo.setChild_support_payment_chg_ind(settingProfileStatus(aPageCargo.getChild_support_payment_chg_ind(),
					aSessionCargo.getChild_support_payment_chg_ind()));
			return;
		case SNAP_SHELTER_STANDARD_EXP_IND:
			aPageCargo.setSnap_shelter_standard_exp_ind(settingProfileStatus(aPageCargo.getSnap_shelter_standard_exp_ind(),
					aSessionCargo.getSnap_shelter_standard_exp_ind()));
			return;
		case HOUS_BILL_CHG_IND:
			aPageCargo.setHous_bill_chg_ind(settingProfileStatus(aPageCargo.getHous_bill_chg_ind(), aSessionCargo.getHous_bill_chg_ind()));
			return;
		case ADD_CHG_IND:
			aPageCargo.setAdd_chg_ind(settingProfileStatus(aPageCargo.getAdd_chg_ind(), aSessionCargo.getAdd_chg_ind()));
			return;
		case PERSON_MOVED_IN_STAT_IND:
			aPageCargo.setPerson_moved_in_stat_ind(settingProfileStatus(aPageCargo.getPerson_moved_in_stat_ind(),
					aSessionCargo.getPerson_moved_in_stat_ind()));
			return;
		case PERSON_MOVED_OUT_STAT_IND:
			aPageCargo.setPerson_moved_out_stat_ind(settingProfileStatus(aPageCargo.getPerson_moved_out_stat_ind(),
					aSessionCargo.getPerson_moved_out_stat_ind()));
			return;
		case HOSPICE_CHG_IND:
			aPageCargo.setHospice_chg_ind(settingProfileStatus(aPageCargo.getHospice_chg_ind(), aSessionCargo.getHospice_chg_ind()));
			return;
		case MEDICARE_CHG_IND:
			aPageCargo.setMedicare_chg_ind(settingProfileStatus(aPageCargo.getMedicare_chg_ind(), aSessionCargo.getMedicare_chg_ind()));
			return;
		case NCP_CHG_IND:
			aPageCargo.setNcp_chg_ind(settingProfileStatus(aPageCargo.getNcp_chg_ind(), aSessionCargo.getNcp_chg_ind()));
			return;
		case THIRD_PARTY_CHG_IND:
			aPageCargo.setThird_party_chg_ind(settingProfileStatus(aPageCargo.getThird_party_chg_ind(), aSessionCargo.getThird_party_chg_ind()));
			return;
		case HOSPITAL_ABD_CHG_IND:
			aPageCargo.setHospital_abd_chg_ind(settingProfileStatus(aPageCargo.getHospital_abd_chg_ind(), aSessionCargo.getHospital_abd_chg_ind()));
			return;
		case PUBLIC_LAW_ABD_CHG_IND:
			aPageCargo.setPublic_law_abd_chg_ind(settingProfileStatus(aPageCargo.getPublic_law_abd_chg_ind(),
					aSessionCargo.getPublic_law_abd_chg_ind()));
			return;
		case LIVING_ARGMT_CHG_IND:
			aPageCargo.setLiving_argmt_chg_ind(settingProfileStatus(aPageCargo.getLiving_argmt_chg_ind(), aSessionCargo.getLiving_argmt_chg_ind()));
			return;
		case OTHER_PROGRAM_CHG_IND:
			aPageCargo
			.setOther_program_chg_ind(settingProfileStatus(aPageCargo.getOther_program_chg_ind(), aSessionCargo.getOther_program_chg_ind()));
			return;
		case TAX_INFO_IND:
			aPageCargo.setTax_info_ind(settingProfileStatus(aPageCargo.getTax_info_ind(), aSessionCargo.getTax_info_ind()));
			return;

		case TAX_DEPENDENT_IND:
			aPageCargo.setTax_dep_outside_resp(settingProfileStatus(aPageCargo.getTax_dep_outside_resp(), aSessionCargo.getTax_dep_outside_resp()));
			return;
		case MAGI_EXPENSE_CHG_IND:
			aPageCargo.setMagi_expense_chg_ind(settingProfileStatus(aPageCargo.getMagi_expense_chg_ind(), aSessionCargo.getMagi_expense_chg_ind()));
			return;
		case MEDICARE_PART_A:
			aPageCargo.setMedicare_part_a(settingProfileStatus(aPageCargo.getMedicare_part_a(), aSessionCargo.getMedicare_part_a()));
			return;
		case MEDICARE_PART_B:
			aPageCargo.setMedicare_part_b(settingProfileStatus(aPageCargo.getMedicare_part_b(), aSessionCargo.getMedicare_part_b()));
			return;
		case MEDICARE_PART_C:
			aPageCargo.setMedicare_part_c(settingProfileStatus(aPageCargo.getMedicare_part_c(), aSessionCargo.getMedicare_part_c()));
			return;
		case MEDICARE_PART_D:
			aPageCargo.setMedicare_part_d(settingProfileStatus(aPageCargo.getMedicare_part_d(), aSessionCargo.getMedicare_part_d()));
			return;
		case CCSP_PROVIDER_PAYMENT:
			aPageCargo
					.setCssp_provider_payment(settingProfileStatus(aPageCargo.getCssp_provider_payment(), aSessionCargo.getCssp_provider_payment()));
			return;
		case ANIMALS_TO_ASSIST_DISABLED:
			aPageCargo.setAnimals_to_assist_disabled(settingProfileStatus(aPageCargo.getAnimals_to_assist_disabled(),
					aSessionCargo.getAnimals_to_assist_disabled()));
			return;
		case FUNERAL_DEATH_EXPENSE:
			aPageCargo
					.setFuneral_death_expense(settingProfileStatus(aPageCargo.getFuneral_death_expense(), aSessionCargo.getFuneral_death_expense()));
			return;
		case BLIND_WORK_EXPENSE:
			aPageCargo.setBlind_work_expense(settingProfileStatus(aPageCargo.getBlind_work_expense(), aSessionCargo.getBlind_work_expense()));
			return;

		case IMPAIRMENT_WORK_EXPENSE:
			aPageCargo.setImpairment_work_expense(settingProfileStatus(aPageCargo.getImpairment_work_expense(),
					aSessionCargo.getImpairment_work_expense()));
			return;

		case OTH_IND_GAMBL_PMNTS:
			aPageCargo.setOth_ind_gambl_pmnts(settingProfileStatus(aPageCargo.getOth_ind_gambl_pmnts(), aSessionCargo.getOth_ind_gambl_pmnts()));
			return;

		case BONDS:
			aPageCargo.setBonds(settingProfileStatus(aPageCargo.getBonds(), aSessionCargo.getBonds()));
			return;

		case DIVIDEND:
			aPageCargo.setDividend(settingProfileStatus(aPageCargo.getDividend(), aSessionCargo.getDividend()));
			return;

		case HEALTH_REIMBURSEMENT_ACCOUNT:
			aPageCargo.setHealth_reimbursement_account(settingProfileStatus(aPageCargo.getHealth_reimbursement_account(),
					aSessionCargo.getHealth_reimbursement_account()));
			return;

		case INDIVIDUAL_DEVELOPMENT_ACCOUNT:
			aPageCargo.setIndividual_development_account(settingProfileStatus(aPageCargo.getIndividual_development_account(),
					aSessionCargo.getIndividual_development_account()));
			return;

		case UNIFORM_GIFTS_TO_MINORS:
			aPageCargo.setUniform_gifts_to_minors(settingProfileStatus(aPageCargo.getUniform_gifts_to_minors(),
					aSessionCargo.getUniform_gifts_to_minors()));
			return;

		case INCOME_FROM_RESOURCE:
			aPageCargo.setIncome_from_resource(settingProfileStatus(aPageCargo.getIncome_from_resource(), aSessionCargo.getIncome_from_resource()));
			return;

		case INDIAN_GAMBLING_PAYMENTS:
			aPageCargo.setIndian_gambling_payments(settingProfileStatus(aPageCargo.getIndian_gambling_payments(),
					aSessionCargo.getIndian_gambling_payments()));
			return;

		case INHERITANCE_INCOME:
			aPageCargo.setInheritance_income(settingProfileStatus(aPageCargo.getInheritance_income(), aSessionCargo.getInheritance_income()));
			return;

		case INSUANCE_BENEFITS:
			aPageCargo.setInsuance_benefits(settingProfileStatus(aPageCargo.getInsuance_benefits(), aSessionCargo.getInsuance_benefits()));
			return;

		case LOAN_RECEIVED:
			aPageCargo.setLoan_received(settingProfileStatus(aPageCargo.getLoan_received(), aSessionCargo.getLoan_received()));
			return;

		case LOAN_REPAYMENT_INCOME:
			aPageCargo
					.setLoan_repayment_income(settingProfileStatus(aPageCargo.getLoan_repayment_income(), aSessionCargo.getLoan_repayment_income()));
			return;

		case MANAGED_INCOME:
			aPageCargo.setManaged_income(settingProfileStatus(aPageCargo.getManaged_income(), aSessionCargo.getManaged_income()));
			return;

		case MATCH_GRANT:
			aPageCargo.setMatch_grant(settingProfileStatus(aPageCargo.getMatch_grant(), aSessionCargo.getMatch_grant()));
			return;

		case MONTGOMERY_GI_BILL:
			aPageCargo.setMontgomery_gi_bill(settingProfileStatus(aPageCargo.getMontgomery_gi_bill(), aSessionCargo.getMontgomery_gi_bill()));
			return;

		case OUT_OF_STATE_PUBLIC:
			aPageCargo.setOut_of_state_public(settingProfileStatus(aPageCargo.getOut_of_state_public(), aSessionCargo.getOut_of_state_public()));
			return;

		case REFUNDS_FROM_DCH:
			aPageCargo.setRefunds_from_dch(settingProfileStatus(aPageCargo.getRefunds_from_dch(), aSessionCargo.getRefunds_from_dch()));
			return;

		case RESTITUTIONS_SETTLEMENTS:
			aPageCargo.setRestitutions_settlements(settingProfileStatus(aPageCargo.getRestitutions_settlements(),
					aSessionCargo.getRestitutions_settlements()));
			return;

		case SENIOR_COMPANION:
			aPageCargo.setSenior_companion(settingProfileStatus(aPageCargo.getSenior_companion(), aSessionCargo.getSenior_companion()));
			return;

		case SEVERANCE_PAY:
			aPageCargo.setSeverance_pay(settingProfileStatus(aPageCargo.getSeverance_pay(), aSessionCargo.getSeverance_pay()));
			return;

		case STRIKE_BENEFITS:
			aPageCargo.setStrike_benefits(settingProfileStatus(aPageCargo.getStrike_benefits(), aSessionCargo.getStrike_benefits()));
			return;

		case TRADE_READJUSTMENT:
			aPageCargo.setTrade_readjustment(settingProfileStatus(aPageCargo.getTrade_readjustment(), aSessionCargo.getTrade_readjustment()));
			return;

		case UNIFORM_RELOCATION:
			aPageCargo.setUniform_relocation(settingProfileStatus(aPageCargo.getUniform_relocation(), aSessionCargo.getUniform_relocation()));
			return;

		case UNION_FUNDS:
			aPageCargo.setUnion_funds(settingProfileStatus(aPageCargo.getUnion_funds(), aSessionCargo.getUnion_funds()));
			return;

		case VENDOR_EXCLUDED:
			aPageCargo.setVendor_excluded(settingProfileStatus(aPageCargo.getVendor_excluded(), aSessionCargo.getVendor_excluded()));
			return;

		case VICTIM_RESTITUTION:
			aPageCargo.setVictim_restitution(settingProfileStatus(aPageCargo.getVictim_restitution(), aSessionCargo.getVictim_restitution()));
			return;

		case VOLUNTEER_PAYMENT:
			aPageCargo.setVolunteer_payment(settingProfileStatus(aPageCargo.getVolunteer_payment(), aSessionCargo.getVolunteer_payment()));
			return;

		case VOLUNTEER_PAYMENT_TITLEI:
			aPageCargo.setVolunteer_payment_titlei(settingProfileStatus(aPageCargo.getVolunteer_payment_titlei(),
					aSessionCargo.getVolunteer_payment_titlei()));
			return;

		case WIA_TRAINING_AND_ALLOWANCE:
			aPageCargo.setWia_training_and_allowance(settingProfileStatus(aPageCargo.getWia_training_and_allowance(),
					aSessionCargo.getWia_training_and_allowance()));
			return;

		case INCLUDED_UNEARNED_INCOME:
			aPageCargo.setIncluded_unearned_income(settingProfileStatus(aPageCargo.getIncluded_unearned_income(),
					aSessionCargo.getIncluded_unearned_income()));
			return;

		case TANF_MAX_AU_ALLOTMENT:
			aPageCargo
					.setTanf_max_au_allotment(settingProfileStatus(aPageCargo.getTanf_max_au_allotment(), aSessionCargo.getTanf_max_au_allotment()));
			return;

		case TANF_MAX_GRG_ALLOTMENT:
			aPageCargo.setTanf_max_grg_allotment(settingProfileStatus(aPageCargo.getTanf_max_grg_allotment(),
					aSessionCargo.getTanf_max_grg_allotment()));
			return;

		case CHARITABLE_DONATION:
			aPageCargo.setCharitable_donation(settingProfileStatus(aPageCargo.getCharitable_donation(), aSessionCargo.getCharitable_donation()));
			return;

		case CHILD_NUTRITION_PAYMENTS:
			aPageCargo.setChild_nutrition_payments(settingProfileStatus(aPageCargo.getChild_nutrition_payments(),
					aSessionCargo.getChild_nutrition_payments()));
			return;

		case BLACK_LUNG_BENEFITS:
			aPageCargo.setBlack_lung_benefits(settingProfileStatus(aPageCargo.getBlack_lung_benefits(), aSessionCargo.getBlack_lung_benefits()));
			return;

		case CHILD_SUPPORT_COURT:
			aPageCargo.setChild_support_court(settingProfileStatus(aPageCargo.getChild_support_court(), aSessionCargo.getChild_support_court()));
			return;

		case CHILD_SUPPORT_GAP_PAYMENT:
			aPageCargo.setChild_support_gap_payment(settingProfileStatus(aPageCargo.getChild_support_gap_payment(),
					aSessionCargo.getChild_support_gap_payment()));
			return;

		case CIVIL_SERVICE:
			aPageCargo.setCivil_service(settingProfileStatus(aPageCargo.getCivil_service(), aSessionCargo.getCivil_service()));
			return;

		case DEFERRED_COMPENSATION_PLANS:
			aPageCargo.setDeferred_compensation_plans(settingProfileStatus(aPageCargo.getDeferred_compensation_plans(),
					aSessionCargo.getDeferred_compensation_plans()));
			return;

		case DISABILITY_INSURANCE:
			aPageCargo.setDisability_insurance(settingProfileStatus(aPageCargo.getDisability_insurance(), aSessionCargo.getDisability_insurance()));
			return;

		case EXCLUDED_UNEARNED_INCOME:
			aPageCargo.setExcluded_unearned_income(settingProfileStatus(aPageCargo.getExcluded_unearned_income(),
					aSessionCargo.getExcluded_unearned_income()));
			return;

		case FEMA_PAYMENT_DISASTER:
			aPageCargo
					.setFema_payment_disaster(settingProfileStatus(aPageCargo.getFema_payment_disaster(), aSessionCargo.getFema_payment_disaster()));
			return;

		case FEMA_PAYMENT_NON_DISASTER:
			aPageCargo.setFema_payment_non_disaster(settingProfileStatus(aPageCargo.getFema_payment_non_disaster(),
					aSessionCargo.getFema_payment_non_disaster()));
			return;

		case HEALTH_SAVINGS_ACCOUNT:
			aPageCargo.setHealth_savings_account(settingProfileStatus(aPageCargo.getHealth_savings_account(),
					aSessionCargo.getHealth_savings_account()));
			return;

		case IN_KIND_SUPPORT:
			aPageCargo.setIn_kind_support(settingProfileStatus(aPageCargo.getIn_kind_support(), aSessionCargo.getIn_kind_support()));
			return;

		case FOSTER_GRANDPARENT_PROGRAM:
			aPageCargo.setFoster_grandparent_program(settingProfileStatus(aPageCargo.getFoster_grandparent_program(),
					aSessionCargo.getFoster_grandparent_program()));
			return;

		case DISASTER_UNEMPLOYMENT:
			aPageCargo
					.setDisaster_unemployment(settingProfileStatus(aPageCargo.getDisaster_unemployment(), aSessionCargo.getDisaster_unemployment()));
			return;

		case DIVIDENDS:
			aPageCargo.setDividends(settingProfileStatus(aPageCargo.getDividends(), aSessionCargo.getDividends()));
			return;

		case CHARITABLE_DONATION_FEDERAL:
			aPageCargo.setCharitable_donation_federal(settingProfileStatus(aPageCargo.getCharitable_donation_federal(),
					aSessionCargo.getCharitable_donation_federal()));
			return;
		case PERSONAL_INFO:
			aPageCargo.setPersonal_info(settingProfileStatus(aPageCargo.getPersonal_info(), aSessionCargo.getPersonal_info()));
			return;
		case PATIENT_FUND:
			aPageCargo.setPatient_fund(settingProfileStatus(aPageCargo.getPatient_fund(), aSessionCargo.getPatient_fund()));
			return;

		case DISASTER_ASSISTANCE:
			aPageCargo.setDisaster_assistance(settingProfileStatus(aPageCargo.getDisaster_assistance(), aSessionCargo.getDisaster_assistance()));
			return;
		case NON_BUSINESS_EQUIPMENT:
			aPageCargo.setNon_business_equipment(settingProfileStatus(aPageCargo.getNon_business_equipment(),
					aSessionCargo.getNon_business_equipment()));
			return;
		case HOUSEHOLD_GOODS:
			aPageCargo.setHousehold_goods(settingProfileStatus(aPageCargo.getHousehold_goods(), aSessionCargo.getHousehold_goods()));
			return;
		case OTHER_NON_COUNTABLE:
			aPageCargo.setOther_non_countable(settingProfileStatus(aPageCargo.getOther_non_countable(), aSessionCargo.getOther_non_countable()));
			return;
		case LIQ_ASET_CHECKING_ACCOUNT:
			aPageCargo.setLqd_aset_c_a_resp(settingProfileStatus(aPageCargo.getLqd_aset_c_a_resp(), aSessionCargo.getLqd_aset_c_a_resp()));
			return;
		case LIQ_ASET_KEOUGH_PLAN:
			aPageCargo.setLqd_aset_k_p_resp(settingProfileStatus(aPageCargo.getLqd_aset_k_p_resp(), aSessionCargo.getLqd_aset_k_p_resp()));
			return;
		case DEATH_BENEFIT_STATE_FEDERAL:
			aPageCargo.setDeath_benefit_state_federal(settingProfileStatus(aPageCargo.getDeath_benefit_state_federal(),
					aSessionCargo.getDeath_benefit_state_federal()));
			return;
		case SOCIAL_SECURITY_SURVIVOR:
			aPageCargo.setSocial_security_survivor(settingProfileStatus(aPageCargo.getSocial_security_survivor(),
					aSessionCargo.getSocial_security_survivor()));
			return;
		case VENDOR_PAYMENTS:
			aPageCargo.setVendor_payments(settingProfileStatus(aPageCargo.getVendor_payments(), aSessionCargo.getVendor_payments()));
			return;
			
		case INDV_PRGM_CHG_IND:
			aPageCargo.setIndv_prgm_chg_ind(settingProfileStatus(aPageCargo.getIndv_prgm_chg_ind(), aSessionCargo.getIndv_prgm_chg_ind()));
			return;
			
		case EMPL_HLTH_INS_RESP:
			aPageCargo.setEmpl_hlth_ins_resp(settingProfileStatus(aPageCargo.getEmpl_hlth_ins_resp(), aSessionCargo.getEmpl_hlth_ins_resp()));
			return;
	    case KATIE_BECKETT:
	        aPageCargo.setMed_type_katie_beckett(settingProfileStatus(aPageCargo.getMed_type_katie_beckett(), aSessionCargo.getMed_type_katie_beckett()));
	        return;
			

		default:
			log(ILog.INFO, "RMCResponseProfileManager.translateProfileStatus() - Raising FwException manually on a condition");
			final FwException fe = new FwException("Incorrect field id : " + aFieldId + " passed.");

			fe.setClassID(this.getClass().getName());
			fe.setMethodID("translateProfileStatus");
			fe.setExceptionType(FwConstants.EXP_TYP_APPLICATION);
			fe.setExceptionText("Incorrect field id : " + aFieldId + " passed.");
			throw fe;
		}
	}

	/**
	 * here i am setting the profilestatus
	 */
	private String settingProfileStatus(String aPageStatus, final String aSessionStatus) {
		try {
			if ((aPageStatus == null) || "null".equals(aPageStatus)) {
				aPageStatus = "N";
			}
			if ((aPageStatus.charAt(0) == RESPONSE_YES) 
					&& (aSessionStatus.charAt(0) == STATUS_NOT_REQUIRED)) {
				return String.valueOf(STATUS_REQUIRED);
			} else if ((aPageStatus.charAt(0) == RESPONSE_NO) 
					&& (aSessionStatus.charAt(0) == STATUS_REQUIRED)) {
				return String.valueOf(STATUS_NOT_REQUIRED);
			} else {
				return aSessionStatus;
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "settingProfileStatus", e);
		}

	}

	/**
	 * @see gov.state.nextgen.access.management.applications.IRMCResponseProfileManager#preparePageColl(gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Collection,
	 *      gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Collection,
	 *      short[])
	 */
	@Override
	public void preparePageColl(final RMC_IN_PRFL_Collection aAppInPrflPageColl, final RMC_IN_PRFL_Collection aAppInPrflSessionColl,
			final short[] aResponsesIds) {
		log(ILog.INFO, "RMCResponseProfileManager.preparePageColl() - start");
		try {
			RMC_IN_PRFL_Cargo appInPrflPageCargo = null;
			RMC_IN_PRFL_Cargo appInPrflSessionCargo = null;

			int pageCollSize = 0;
			pageCollSize = aAppInPrflPageColl.size();
			final int sessionCollSize = aAppInPrflSessionColl.size();
			final int responseSize = aResponsesIds.length;
			boolean foundFlag = false;
			String indvSeqNum = null;
			for (int i = 0; i < sessionCollSize; i++) {
				appInPrflSessionCargo = aAppInPrflSessionColl.getCargo(i);
				indvSeqNum = appInPrflSessionCargo.getIndv_seq_num();
				// here we are checking for relevent individuals

				foundFlag = false;
				for (int j = 0; j < pageCollSize; j++) {
					appInPrflPageCargo = aAppInPrflPageColl.getCargo(j);
					if (appInPrflPageCargo.getIndv_seq_num().equals(indvSeqNum)) {
						foundFlag = true;
						break;
					}
				}
				if (!foundFlag) {
					appInPrflPageCargo = new RMC_IN_PRFL_Cargo();
					appInPrflPageCargo.setIndv_seq_num(indvSeqNum);
					aAppInPrflPageColl.addCargo(appInPrflPageCargo);
				}
				// for each response id's
				for (int k = 0; k < responseSize; k++) {
					copyingProfilesFromBeforeCollection(appInPrflPageCargo, appInPrflSessionCargo, aResponsesIds[k]);
				}
			}
			log(ILog.INFO, "RMCResponseProfileManager.preparePageColl() - end");
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "preparePageColl", e);
		}
	}

	/**
	 * updates cargo with the new status and returns the new status
	 */
	private void copyingProfilesFromBeforeCollection(final RMC_IN_PRFL_Cargo aPageCargo, final RMC_IN_PRFL_Cargo aBeforeCargo, final short aFieldId) {
		log(ILog.INFO, "RMCResponseProfileManager.copyingProfilesFromBeforeCollection() - start");
		switch (aFieldId) {
		case ACCIDENT:
			aPageCargo.setAcdt_resp(copyingProfileStatus(aPageCargo.getAcdt_resp(), aBeforeCargo.getAcdt_resp()));
			return;
		case ADOPTION_ASSISTANCE:
			aPageCargo.setAdpt_asst_resp(copyingProfileStatus(aPageCargo.getAdpt_asst_resp(), aBeforeCargo.getAdpt_asst_resp()));
			return;
		case ALIMONY_RECEIVED:
			aPageCargo.setAlmy_rcv_resp(copyingProfileStatus(aPageCargo.getAlmy_rcv_resp(), aBeforeCargo.getAlmy_rcv_resp()));
			return;
		case BENEFIT_ANNUITIES:
			aPageCargo.setBnft_anty_resp(copyingProfileStatus(aPageCargo.getBnft_anty_resp(), aBeforeCargo.getBnft_anty_resp()));
			return;
		case BENEFIT_CHARITY:
			aPageCargo.setBnft_chrt_resp(copyingProfileStatus(aPageCargo.getBnft_chrt_resp(), aBeforeCargo.getBnft_chrt_resp()));
			return;
		case BENEFIT_DISABLE:
			aPageCargo.setBnft_dabl_resp(copyingProfileStatus(aPageCargo.getBnft_dabl_resp(), aBeforeCargo.getBnft_dabl_resp()));
			return;
		case BENEFIT_DIVIDEND:
			aPageCargo.setBnft_divnd_resp(copyingProfileStatus(aPageCargo.getBnft_divnd_resp(), aBeforeCargo.getBnft_divnd_resp()));
			return;
		case BENEFIT_TRUST:
			aPageCargo.setBnft_est_trst_resp(copyingProfileStatus(aPageCargo.getBnft_est_trst_resp(), aBeforeCargo.getBnft_est_trst_resp()));
			return;
		case BENEFIT_RAILROAD_RETIREMENT:
			aPageCargo.setBnft_rr_resp(copyingProfileStatus(aPageCargo.getBnft_rr_resp(), aBeforeCargo.getBnft_rr_resp()));
			return;
		case BENEFIT_UNEMPLOYMENT:
			aPageCargo.setBnft_uempl_resp(copyingProfileStatus(aPageCargo.getBnft_uempl_resp(), aBeforeCargo.getBnft_uempl_resp()));
			return;
		case BENEFIT_VETERAN:
			aPageCargo.setBnft_vet_resp(copyingProfileStatus(aPageCargo.getBnft_vet_resp(), aBeforeCargo.getBnft_vet_resp()));
			return;
		case CHILD_SUPPORT_PAYMENT:
			aPageCargo.setChld_sprt_pay_resp(copyingProfileStatus(aPageCargo.getChld_sprt_pay_resp(), aBeforeCargo.getChld_sprt_pay_resp()));
			return;
		case DISABLE:
			aPageCargo.setDabl_resp(copyingProfileStatus(aPageCargo.getDabl_resp(), aBeforeCargo.getDabl_resp()));
			return;
		case DEPENDENT_CARE:
			aPageCargo.setDpnd_care_resp(copyingProfileStatus(aPageCargo.getDpnd_care_resp(), aBeforeCargo.getDpnd_care_resp()));
			return;
		case DRUG_FELON:
			aPageCargo.setDrug_feln_resp(copyingProfileStatus(aPageCargo.getDrug_feln_resp(), aBeforeCargo.getDrug_feln_resp()));
			return;
		case FSET_SANCTION:
			aPageCargo.setFset_sctn_resp(copyingProfileStatus(aPageCargo.getFset_sctn_resp(), aBeforeCargo.getFset_sctn_resp()));
			return;
		case FOSTER_CARE:
			aPageCargo.setFstr_care_resp(copyingProfileStatus(aPageCargo.getFstr_care_resp(), aBeforeCargo.getFstr_care_resp()));
			return;
		case GENERAL_RELIEF:
			aPageCargo.setGen_rlf_resp(copyingProfileStatus(aPageCargo.getGen_rlf_resp(), aBeforeCargo.getGen_rlf_resp()));
			return;
		case HEALTHCARE_COVERAGE:
			aPageCargo.setHc_cvrg_resp(copyingProfileStatus(aPageCargo.getHc_cvrg_resp(), aBeforeCargo.getHc_cvrg_resp()));
			return;
		case HOUS_PICE:
			aPageCargo.setHospice_resp(copyingProfileStatus(aPageCargo.getHospice_resp(), aBeforeCargo.getHospice_resp()));
			return;
		case OUTSTATE_BNFTS:
			aPageCargo.setOutstate_bnft_resp(copyingProfileStatus(aPageCargo.getOutstate_bnft_resp(), aBeforeCargo.getOutstate_bnft_resp()));
			return;
		case SPECIAL_NEED:
			aPageCargo.setSpecial_need_resp(copyingProfileStatus(aPageCargo.getSpecial_need_resp(), aBeforeCargo.getSpecial_need_resp()));
			return;
		case MOVED_OUT_OF_HOME_RESP:
			aPageCargo.setMoved_out_of_home_resp(copyingProfileStatus(aPageCargo.getMoved_out_of_home_resp(),
					aBeforeCargo.getMoved_out_of_home_resp()));
			return;
		case PRSN_INFO_STAT_SW:
			aPageCargo.setPersonal_info(copyingProfileStatus(aPageCargo.getPersonal_info(), aBeforeCargo.getPersonal_info()));
			return;
		case CITIZENSHIP_INFO:
			aPageCargo.setCitizenship_info(copyingProfileStatus(aPageCargo.getCitizenship_info(), aBeforeCargo.getCitizenship_info()));
			return;
		case RLT_CHG_STAT_SW:
			aPageCargo.setRlt_chg_stat_sw(copyingProfileStatus(aPageCargo.getRlt_chg_stat_sw(), aBeforeCargo.getRlt_chg_stat_sw()));
			return;
		case FOSTER_CARE_RESP:
			aPageCargo.setFoster_care_resp(copyingProfileStatus(aPageCargo.getFoster_care_resp(), aBeforeCargo.getFoster_care_resp()));
			return;
		case FORMER_FOSTER_RESP:
			aPageCargo.setFormer_foster_resp(copyingProfileStatus(aPageCargo.getFormer_foster_resp(), aBeforeCargo.getFormer_foster_resp()));
			return;
		case CHILD_PROTECTIVE_RESP:
			aPageCargo.setChild_protective_resp(copyingProfileStatus(aPageCargo.getChild_protective_resp(), aBeforeCargo.getChild_protective_resp()));
			return;
		case LIVING_PROG_RESP:
			aPageCargo.setLiving_prog_resp(copyingProfileStatus(aPageCargo.getLiving_prog_resp(), aBeforeCargo.getLiving_prog_resp()));
			return;
		case GRAND_PARENT_RESP:
			aPageCargo.setGrand_parent_resp(copyingProfileStatus(aPageCargo.getGrand_parent_resp(), aBeforeCargo.getGrand_parent_resp()));
			return;
		case DRUG_FELONIES_RESP:
			aPageCargo.setDrug_felonies_resp(copyingProfileStatus(aPageCargo.getDrug_felonies_resp(), aBeforeCargo.getDrug_felonies_resp()));
			return;
		case SNAP_TANF_DISC_RESP:
			aPageCargo.setSnap_tanf_disc_resp(copyingProfileStatus(aPageCargo.getSnap_tanf_disc_resp(), aBeforeCargo.getSnap_tanf_disc_resp()));
			return;

		case TANF_DISC_RESP:
			aPageCargo.setTanfDiscResp(copyingProfileStatus(aPageCargo.getTanfDiscResp(), aBeforeCargo.getTanfDiscResp()));
			return;
		case AVOID_PROSC_RESP:
			aPageCargo.setAvoid_prosc_resp(copyingProfileStatus(aPageCargo.getAvoid_prosc_resp(), aBeforeCargo.getAvoid_prosc_resp()));
			return;
		case AVD_PRSCTN_FSTF:
			aPageCargo.setAvd_prsctn_fstf(copyingProfileStatus(aPageCargo.getAvd_prsctn_fstf(), aBeforeCargo.getAvd_prsctn_fstf()));
			return;
		case VIOLATING_PAROLE_RESP:
			aPageCargo.setViolating_parole_resp(copyingProfileStatus(aPageCargo.getViolating_parole_resp(), aBeforeCargo.getViolating_parole_resp()));
			return;
		case CONVIC_FALSE_INFO_RESP:
			aPageCargo.setConvic_false_info_resp(copyingProfileStatus(aPageCargo.getConvic_false_info_resp(),
					aBeforeCargo.getConvic_false_info_resp()));
			return;
		case VOLUNTARILY_QUIT_JOB_RESP:
			aPageCargo.setVoluntarily_quit_job_resp(copyingProfileStatus(aPageCargo.getVoluntarily_quit_job_resp(),
					aBeforeCargo.getVoluntarily_quit_job_resp()));
			return;
		case TRADING_SNAP_RESP:
			aPageCargo.setTrading_snap_resp(copyingProfileStatus(aPageCargo.getTrading_snap_resp(), aBeforeCargo.getTrading_snap_resp()));
			return;
		case BUY_SELL_SNAP_RESP:
			aPageCargo.setBuy_sell_snap_resp(copyingProfileStatus(aPageCargo.getBuy_sell_snap_resp(), aBeforeCargo.getBuy_sell_snap_resp()));
			return;
		case TRADE_SNAP_GUN_RESP:
			aPageCargo.setTrade_snap_gun_resp(copyingProfileStatus(aPageCargo.getTrade_snap_gun_resp(), aBeforeCargo.getTrade_snap_gun_resp()));
			return;
		case PREV_SSI_RESP:
			aPageCargo.setPrev_ssi_resp(copyingProfileStatus(aPageCargo.getPrev_ssi_resp(), aBeforeCargo.getPrev_ssi_resp()));
			return;
		case HOME_COMMUNITY_RESP:
			aPageCargo.setHome_community_resp(copyingProfileStatus(aPageCargo.getHome_community_resp(), aBeforeCargo.getHome_community_resp()));
			return;
		case TRIBAL_HEALTH_RESP:
			aPageCargo.setTribal_health_resp(copyingProfileStatus(aPageCargo.getTribal_health_resp(), aBeforeCargo.getTribal_health_resp()));
			return;
		case TRIBAL_ELIGIBILITY_RESP:
			aPageCargo.setTribal_eligibility_resp(copyingProfileStatus(aPageCargo.getTribal_eligibility_resp(),
					aBeforeCargo.getTribal_eligibility_resp()));
			return;
		case DOMESTIC_VIOLENCE_RESP:
			aPageCargo.setDomestic_violence_resp(copyingProfileStatus(aPageCargo.getDomestic_violence_resp(),
					aBeforeCargo.getDomestic_violence_resp()));
			return;
		case TANF_EPPIC_RESP:
			aPageCargo.setTanf_eppic_resp(copyingProfileStatus(aPageCargo.getTanf_eppic_resp(), aBeforeCargo.getTanf_eppic_resp()));
			return;
		case EMERGENCY_MEDICAL_RESP:
			aPageCargo.setEmergency_medical_resp(copyingProfileStatus(aPageCargo.getEmergency_medical_resp(),
					aBeforeCargo.getEmergency_medical_resp()));
			return;
		case INCOME_INTEREST:
			aPageCargo.setIncm_int_resp(copyingProfileStatus(aPageCargo.getIncm_int_resp(), aBeforeCargo.getIncm_int_resp()));
			return;
		case INDIVIDUAL_FAMILY_MEDICAID:
			aPageCargo.setIndv_fma_rqst_ind(copyingProfileStatus(aPageCargo.getIndv_fma_rqst_ind(), aBeforeCargo.getIndv_fma_rqst_ind()));
			return;
		case INDIVIDUAL_FPW:
			aPageCargo.setIndv_fpw_rqst_ind(copyingProfileStatus(aPageCargo.getIndv_fpw_rqst_ind(), aBeforeCargo.getIndv_fpw_rqst_ind()));
			return;
		case INDIVIDUAL_FOODSHARE:
			aPageCargo.setIndv_fs_rqst_ind(copyingProfileStatus(aPageCargo.getIndv_fs_rqst_ind(), aBeforeCargo.getIndv_fs_rqst_ind()));
			return;
		case IREW:
			aPageCargo.setIrwe_resp(copyingProfileStatus(aPageCargo.getIrwe_resp(), aBeforeCargo.getIrwe_resp()));
			return;
		case KINSHIP_CARE:
			aPageCargo.setKinship_care_resp(copyingProfileStatus(aPageCargo.getKinship_care_resp(), aBeforeCargo.getKinship_care_resp()));
			return;
		case MEDICAL_EXPENSE:
			aPageCargo.setMed_exp_resp(copyingProfileStatus(aPageCargo.getMed_exp_resp(), aBeforeCargo.getMed_exp_resp()));
			return;
		case MILITARY_ALLOTMENT:
			aPageCargo.setMil_allot_resp(copyingProfileStatus(aPageCargo.getMil_allot_resp(), aBeforeCargo.getMil_allot_resp()));
			return;
		case MONEY_FROM_ANOTHER_PERSON:
			aPageCargo.setMony_othr_resp(copyingProfileStatus(aPageCargo.getMony_othr_resp(), aBeforeCargo.getMony_othr_resp()));
			return;
		case REFUGE:
			aPageCargo.setNatl_rfge_resp(copyingProfileStatus(aPageCargo.getNatl_rfge_resp(), aBeforeCargo.getNatl_rfge_resp()));
			return;
		case NEEDY_INDIAN:
			aPageCargo.setNeed_ind_resp(copyingProfileStatus(aPageCargo.getNeed_ind_resp(), aBeforeCargo.getNeed_ind_resp()));
			return;
		case ON_STRIKE:
			aPageCargo.setOn_strk_sw(copyingProfileStatus(aPageCargo.getOn_strk_sw(), aBeforeCargo.getOn_strk_sw()));
			return;
		case OTHER_PENSION:
			aPageCargo.setOp_aoda_tmt_rcv_sw(copyingProfileStatus(aPageCargo.getOp_aoda_tmt_rcv_sw(), aBeforeCargo.getOp_aoda_tmt_rcv_sw()));
			return;
		case OTHER_INCOME:
			aPageCargo.setOthr_incm_resp(copyingProfileStatus(aPageCargo.getOthr_incm_resp(), aBeforeCargo.getOthr_incm_resp()));
			return;
		case OTHER_SOURCE:
			aPageCargo.setOthr_src_resp(copyingProfileStatus(aPageCargo.getOthr_src_resp(), aBeforeCargo.getOthr_src_resp()));
			return;
		case OWNER_ASSET:
			aPageCargo.setOwn_aset_resp(copyingProfileStatus(aPageCargo.getOwn_aset_resp(), aBeforeCargo.getOwn_aset_resp()));
			return;
		case PAY_HOUSING_BILL:
			aPageCargo.setPay_hous_bill_resp(copyingProfileStatus(aPageCargo.getPay_hous_bill_resp(), aBeforeCargo.getPay_hous_bill_resp()));
			return;

		case PREGNANCY:
			aPageCargo.setPreg_resp(copyingProfileStatus(aPageCargo.getPreg_resp(), aBeforeCargo.getPreg_resp()));
			return;
		case JOB_IN_KIND:
			aPageCargo.setJob_iknd_resp(copyingProfileStatus(aPageCargo.getJob_iknd_resp(), aBeforeCargo.getJob_iknd_resp()));
			return;
		case PAY_ROOM_AND_BOARD:
			aPageCargo.setPay_rmr_brd_resp(copyingProfileStatus(aPageCargo.getPay_rmr_brd_resp(), aBeforeCargo.getPay_rmr_brd_resp()));
			return;
		case PENSION_RETIREMENT:
			aPageCargo.setPnsn_retr_resp(copyingProfileStatus(aPageCargo.getPnsn_retr_resp(), aBeforeCargo.getPnsn_retr_resp()));
			return;
		case PROPERTY_SOLD:
			aPageCargo.setProp_sold_resp(copyingProfileStatus(aPageCargo.getProp_sold_resp(), aBeforeCargo.getProp_sold_resp()));
			return;
		case RECEIVE_FS_IN_OTHER_STATE:
			aPageCargo.setRcv_fs_oth_st_resp(copyingProfileStatus(aPageCargo.getRcv_fs_oth_st_resp(), aBeforeCargo.getRcv_fs_oth_st_resp()));
			return;
		case RECEIVE_HOUSING_ASSET:
			aPageCargo.setRcv_hous_asst_resp(copyingProfileStatus(aPageCargo.getRcv_hous_asst_resp(), aBeforeCargo.getRcv_hous_asst_resp()));
			return;
		case RECEIVE_SOCIAL_SECURITY:
			aPageCargo.setRcv_ss_resp(copyingProfileStatus(aPageCargo.getRcv_ss_resp(), aBeforeCargo.getRcv_ss_resp()));
			return;
		case RECEIVE_SSI_LETTER:
			aPageCargo.setRcv_ssi_ltr_resp(copyingProfileStatus(aPageCargo.getRcv_ssi_ltr_resp(), aBeforeCargo.getRcv_ssi_ltr_resp()));
			return;
		case RECEIVE_SSI:
			aPageCargo.setRcv_ssi_sw(copyingProfileStatus(aPageCargo.getRcv_ssi_sw(), aBeforeCargo.getRcv_ssi_sw()));
			return;
		case ROOM_AND_BOARD:
			aPageCargo.setRmr_brd_incm_resp(copyingProfileStatus(aPageCargo.getRmr_brd_incm_resp(), aBeforeCargo.getRmr_brd_incm_resp()));
			return;
		case SELF_EMPLOYMENT:
			aPageCargo.setSelf_empl_resp(copyingProfileStatus(aPageCargo.getSelf_empl_resp(), aBeforeCargo.getSelf_empl_resp()));
			return;
		case RECEIVE_SSI_DCOND:
			aPageCargo.setSsi_dcond_resp(copyingProfileStatus(aPageCargo.getSsi_dcond_resp(), aBeforeCargo.getSsi_dcond_resp()));
			return;
		case RECEIVE_SSI_1619B:
			aPageCargo.setSsi_1619b_rcv_sw(copyingProfileStatus(aPageCargo.getSsi_1619b_rcv_sw(), aBeforeCargo.getSsi_1619b_rcv_sw()));
			return;
		case SHELTER_COST_ASSESSMENT:
			aPageCargo.setSu_ases_resp(copyingProfileStatus(aPageCargo.getSu_ases_resp(), aBeforeCargo.getSu_ases_resp()));
			return;
		case SHELTER_COST_COAL:
			aPageCargo.setSu_cst_coal_resp(copyingProfileStatus(aPageCargo.getSu_cst_coal_resp(), aBeforeCargo.getSu_cst_coal_resp()));
			return;
		case SHELTER_COST_ELECTRICTY:
			aPageCargo.setSu_cst_elec_resp(copyingProfileStatus(aPageCargo.getSu_cst_elec_resp(), aBeforeCargo.getSu_cst_elec_resp()));
			return;
		case SHELTER_COST_FUEL:
			aPageCargo.setSu_cst_fuel_resp(copyingProfileStatus(aPageCargo.getSu_cst_fuel_resp(), aBeforeCargo.getSu_cst_fuel_resp()));
			return;
		case SHELTER_COST_GAS:
			aPageCargo.setSu_cst_gas_resp(copyingProfileStatus(aPageCargo.getSu_cst_gas_resp(), aBeforeCargo.getSu_cst_gas_resp()));
			return;
		case SHELTER_COST_HOME:
			aPageCargo.setSu_cst_home_resp(copyingProfileStatus(aPageCargo.getSu_cst_home_resp(), aBeforeCargo.getSu_cst_home_resp()));
			return;
		case SHELTER_COST_INSTALL:
			aPageCargo.setSu_cst_istl_resp(copyingProfileStatus(aPageCargo.getSu_cst_istl_resp(), aBeforeCargo.getSu_cst_istl_resp()));
			return;
		case SHELTER_COST_LPGAS:
			aPageCargo.setSu_cst_lpgas_resp(copyingProfileStatus(aPageCargo.getSu_cst_lpgas_resp(), aBeforeCargo.getSu_cst_lpgas_resp()));
			return;
		case SHELTER_COST_MOBILE_HOME:
			aPageCargo.setSu_cst_mbl_resp(copyingProfileStatus(aPageCargo.getSu_cst_mbl_resp(), aBeforeCargo.getSu_cst_mbl_resp()));
			return;
		case SHELTER_COST_MORTGAGE:
			aPageCargo.setSu_cst_mtge_resp(copyingProfileStatus(aPageCargo.getSu_cst_mtge_resp(), aBeforeCargo.getSu_cst_mtge_resp()));
			return;
		case SHELTER_COST_OTHER:
			aPageCargo.setSu_cst_othr_resp(copyingProfileStatus(aPageCargo.getSu_cst_othr_resp(), aBeforeCargo.getSu_cst_othr_resp()));
			return;
		case SHELTER_COST_PHONE:
			aPageCargo.setSu_cst_phn_resp(copyingProfileStatus(aPageCargo.getSu_cst_phn_resp(), aBeforeCargo.getSu_cst_phn_resp()));
			return;
		case SHELTER_COST_RENT:
			aPageCargo.setSu_cst_rent_resp(copyingProfileStatus(aPageCargo.getSu_cst_rent_resp(), aBeforeCargo.getSu_cst_rent_resp()));
			return;
		case SHELTER_COST_SEWER:
			aPageCargo.setSu_cst_swr_resp(copyingProfileStatus(aPageCargo.getSu_cst_swr_resp(), aBeforeCargo.getSu_cst_swr_resp()));
			return;
		case SHELTER_COST_TAX:
			aPageCargo.setSu_cst_tax_resp(copyingProfileStatus(aPageCargo.getSu_cst_tax_resp(), aBeforeCargo.getSu_cst_tax_resp()));
			return;
		case SHELTER_COST_TRASH:
			aPageCargo.setSu_cst_trsh_resp(copyingProfileStatus(aPageCargo.getSu_cst_trsh_resp(), aBeforeCargo.getSu_cst_trsh_resp()));
			return;
		case SHELTER_COST_WOOD:
			aPageCargo.setSu_cst_wood_resp(copyingProfileStatus(aPageCargo.getSu_cst_wood_resp(), aBeforeCargo.getSu_cst_wood_resp()));
			return;
		case SHELTER_COST_WATER:
			aPageCargo.setSu_cst_wtr_resp(copyingProfileStatus(aPageCargo.getSu_cst_wtr_resp(), aBeforeCargo.getSu_cst_wtr_resp()));
			return;
		case SHELTER_COST_WASTE:
			aPageCargo.setSu_cst_wwt_resp(copyingProfileStatus(aPageCargo.getSu_cst_wwt_resp(), aBeforeCargo.getSu_cst_wwt_resp()));
			return;
		case TRIBAL_TANF:
			aPageCargo.setTrb_tanf_resp(copyingProfileStatus(aPageCargo.getTrb_tanf_resp(), aBeforeCargo.getTrb_tanf_resp()));
			return;
		case UTILITY_EXPENSE:
			aPageCargo.setUtil_exp_resp(copyingProfileStatus(aPageCargo.getUtil_exp_resp(), aBeforeCargo.getUtil_exp_resp()));
			return;
		case WORKER_COMP:
			aPageCargo.setWork_comp_resp(copyingProfileStatus(aPageCargo.getWork_comp_resp(), aBeforeCargo.getWork_comp_resp()));
			return;
		case TRIBAL_CAPITA:
			aPageCargo.setTrb_cpta_resp(copyingProfileStatus(aPageCargo.getTrb_cpta_resp(), aBeforeCargo.getTrb_cpta_resp()));
			return;
		case EDUCATIONAL_AID:
			aPageCargo.setEduc_aid_resp(copyingProfileStatus(aPageCargo.getEduc_aid_resp(), aBeforeCargo.getEduc_aid_resp()));
			return;
		case WHEAP:
			aPageCargo.setWheap_resp(copyingProfileStatus(aPageCargo.getWheap_resp(), aBeforeCargo.getWheap_resp()));
			return;
		case REGULAR_EMPL:
			aPageCargo.setEmpl_resp(copyingProfileStatus(aPageCargo.getEmpl_resp(), aBeforeCargo.getEmpl_resp()));
			return;
		case BNFT_CHL_SPRT_RESP:
			aPageCargo.setBnft_chl_sprt_resp(copyingProfileStatus(aPageCargo.getBnft_chl_sprt_resp(), aBeforeCargo.getBnft_chl_sprt_resp()));
			return;
		case OTHR_INCM_CONTRIB_RESP:
			aPageCargo.setOther_incm_contrib_resp(copyingProfileStatus(aPageCargo.getOther_incm_contrib_resp(),
					aBeforeCargo.getOther_incm_contrib_resp()));
			return;
		case OTHR_INCM_TRBL_RESP:
			aPageCargo.setOthr_incm_trbl_resp(copyingProfileStatus(aPageCargo.getOthr_incm_trbl_resp(), aBeforeCargo.getOthr_incm_trbl_resp()));
			return;
		case PUB_ASST_RESP:
			aPageCargo.setPub_asst_resp(copyingProfileStatus(aPageCargo.getPub_asst_resp(), aBeforeCargo.getPub_asst_resp()));
			return;
		case YEHOC_RESP:
			aPageCargo.setYehoc_resp(copyingProfileStatus(aPageCargo.getYehoc_resp(), aBeforeCargo.getYehoc_resp()));
			return;

			// PCR 35980
		case PAST_HEALTHCARE_COVERAGE:
			aPageCargo.setPast_hc_cvrg_resp(copyingProfileStatus(aPageCargo.getPast_hc_cvrg_resp(), aBeforeCargo.getPast_hc_cvrg_resp()));
			return;

			// PCR# 40362 - ADDED NEW RESPONSES FOR RMB AND SMRF CHANGES -
			// starts
		case MAPP_BENEFITS_RESP:
			aPageCargo.setBnft_mapp_resp(copyingProfileStatus(aPageCargo.getBnft_mapp_resp(), aBeforeCargo.getBnft_mapp_resp()));
			return;

		case BUR_AST_CASKET:
			aPageCargo.setBury_aset_oth_resp(copyingProfileStatus(aPageCargo.getBury_aset_oth_resp(), aBeforeCargo.getBury_aset_oth_resp()));
			return;

		case BUR_AST_IRREVOCABLE:
			aPageCargo.setBury_aset_rbt_resp(copyingProfileStatus(aPageCargo.getBury_aset_rbt_resp(), aBeforeCargo.getBury_aset_rbt_resp()));
			return;

		case BUR_AST_INSURANCE:
			aPageCargo.setBury_aset_ins_resp(copyingProfileStatus(aPageCargo.getBury_aset_ins_resp(), aBeforeCargo.getBury_aset_ins_resp()));
			return;

		case BUR_AST_MAUSOLEUM:
			aPageCargo.setBury_aset_mas_resp(copyingProfileStatus(aPageCargo.getBury_aset_mas_resp(), aBeforeCargo.getBury_aset_mas_resp()));
			return;

		case BUR_AST_OTHER:
			aPageCargo.setBury_aset_oth_resp(copyingProfileStatus(aPageCargo.getBury_aset_oth_resp(), aBeforeCargo.getBury_aset_oth_resp()));
			return;

		case BUR_AST_PLOT:
			aPageCargo.setBury_aset_plt_resp(copyingProfileStatus(aPageCargo.getBury_aset_plt_resp(), aBeforeCargo.getBury_aset_plt_resp()));
			return;

		case BUR_AST_REVOCABLE:
			aPageCargo.setBury_aset_rbt_resp(copyingProfileStatus(aPageCargo.getBury_aset_rbt_resp(), aBeforeCargo.getBury_aset_rbt_resp()));
			return;

		case BUR_AST_VAULT:
			aPageCargo.setBury_aset_v_resp(copyingProfileStatus(aPageCargo.getBury_aset_v_resp(), aBeforeCargo.getBury_aset_v_resp()));
			return;

		case LIF_AST_GROUP_LIFE:
			aPageCargo.setLi_aset_g_l_resp(copyingProfileStatus(aPageCargo.getLi_aset_g_l_resp(), aBeforeCargo.getLi_aset_g_l_resp()));
			return;

		case LIF_AST_GROUP_TERM:
			aPageCargo.setLi_aset_g_t_resp(copyingProfileStatus(aPageCargo.getLi_aset_g_t_resp(), aBeforeCargo.getLi_aset_g_t_resp()));
			return;

		case LIF_AST_TERM:
			aPageCargo.setLi_aset_trm_resp(copyingProfileStatus(aPageCargo.getLi_aset_trm_resp(), aBeforeCargo.getLi_aset_trm_resp()));
			return;

		case LIF_AST_UNIVERSAL:
			aPageCargo.setLi_aset_unv_resp(copyingProfileStatus(aPageCargo.getLi_aset_unv_resp(), aBeforeCargo.getLi_aset_unv_resp()));
			return;

		case LIF_AST_WHOLE_LIFE:
			aPageCargo.setLi_aset_w_l_resp(copyingProfileStatus(aPageCargo.getLi_aset_w_l_resp(), aBeforeCargo.getLi_aset_w_l_resp()));
			return;

			// Adding cash and bank
		case LIQUID_ASET_BANK:
			aPageCargo.setLiquid_asset_bank_acc_resp(copyingProfileStatus(aPageCargo.getLiquid_asset_bank_acc_resp(),
					aBeforeCargo.getLiquid_asset_bank_acc_resp()));
			return;
		case LIQ_ASET_CASH:
			aPageCargo.setLiquid_asset_cash_resp(copyingProfileStatus(aPageCargo.getLiquid_asset_cash_resp(),
					aBeforeCargo.getLiquid_asset_cash_resp()));
			return;
		case LIQUID_ASSET_XFER:
			aPageCargo.setLqd_aset_tr_f_resp(copyingProfileStatus(aPageCargo.getLqd_aset_tr_f_resp(), aBeforeCargo.getLqd_aset_tr_f_resp()));
			return;
			// Adding cash and bank ended
		case LIQUID_ASSET_ANNUITY:
			aPageCargo.setLiquid_aset_disable_blind_resp(copyingProfileStatus(aPageCargo.getLiquid_aset_disable_blind_resp(),
					aBeforeCargo.getLiquid_aset_disable_blind_resp()));
			return;
		case LIQUID_ASSET_IRA:
			aPageCargo.setLiquid_asset_ira_resp(copyingProfileStatus(aPageCargo.getLiquid_asset_ira_resp(), aBeforeCargo.getLiquid_asset_ira_resp()));
			return;
		case LIQUID_ASSET_IRS_RET:
			aPageCargo.setLiquid_asset_irs_retirmnt_resp(copyingProfileStatus(aPageCargo.getLiquid_asset_irs_retirmnt_resp(),
					aBeforeCargo.getLiquid_asset_irs_retirmnt_resp()));
			return;
		case LIQUID_ASSET_SAVINGS_ACC:
			aPageCargo.setLiquid_asset_savings_acc_resp(copyingProfileStatus(aPageCargo.getLiquid_asset_savings_acc_resp(),
					aBeforeCargo.getLiquid_asset_savings_acc_resp()));
			return;
		case LIQUID_ASSET_PENSION_PLAN:
			aPageCargo.setLiquid_asset_pension_plan_resp(copyingProfileStatus(aPageCargo.getLiquid_asset_pension_plan_resp(),
					aBeforeCargo.getLiquid_asset_pension_plan_resp()));
			return;
		case LIQUID_ASSET_PROMISSORY:
			aPageCargo.setLiquid_asset_promissory_resp(copyingProfileStatus(aPageCargo.getLiquid_asset_promissory_resp(),
					aBeforeCargo.getLiquid_asset_promissory_resp()));
			return;
		case LIQUID_ASSET_RETIREMENT:
			aPageCargo.setLiquid_asset_retirement_resp(copyingProfileStatus(aPageCargo.getLiquid_asset_retirement_resp(),
					aBeforeCargo.getLiquid_asset_retirement_resp()));
			return;
		case LIQUID_ASSET_STOCK_BONDS:
			aPageCargo.setLiquid_asset_stocks_bonds_resp(copyingProfileStatus(aPageCargo.getLiquid_asset_stocks_bonds_resp(),
					aBeforeCargo.getLiquid_asset_stocks_bonds_resp()));
			return;
		case LIQUID_ASSET_TRUST_FUND:
			aPageCargo.setLiquid_asset_trust_fund_resp(copyingProfileStatus(aPageCargo.getLiquid_asset_trust_fund_resp(),
					aBeforeCargo.getLiquid_asset_trust_fund_resp()));
			return;
		case LIQUID_ASSET_OTHER:
			aPageCargo.setLiquid_asset_other_response(copyingProfileStatus(aPageCargo.getLiquid_asset_other_response(),
					aBeforeCargo.getLiquid_asset_other_response()));
			return;
		case LIQUID_ASSET_OTHER_TYPE:
			aPageCargo.setLiquid_asset_other_type_resp(copyingProfileStatus(aPageCargo.getLiquid_asset_other_type_resp(),
					aBeforeCargo.getLiquid_asset_other_type_resp()));
			return;

		case LIQ_ASET_HOME_SALE:
			aPageCargo.setLqd_aset_h_s_resp(copyingProfileStatus(aPageCargo.getLqd_aset_h_s_resp(), aBeforeCargo.getLqd_aset_h_s_resp()));
			return;

		case LIQ_ASET_US_BOND:
			aPageCargo.setLqd_aset_us_b_resp(copyingProfileStatus(aPageCargo.getLqd_aset_us_b_resp(), aBeforeCargo.getLqd_aset_us_b_resp()));
			return;

		case OTHR_ASET_BURIAL:
			aPageCargo.setOther_asset_burial_resp(copyingProfileStatus(aPageCargo.getOther_asset_burial_resp(),
					aBeforeCargo.getOther_asset_burial_resp()));
			return;

		case OTHR_ASET_LIFE_INSURANCE:
			aPageCargo.setOther_aset_life_insurance_resp(copyingProfileStatus(aPageCargo.getOther_aset_life_insurance_resp(),
					aBeforeCargo.getOther_aset_life_insurance_resp()));
			return;

		case OTHR_ASET_PERSONAL_PROPERTY:
			aPageCargo.setOther_asset_personal_prop_resp(copyingProfileStatus(aPageCargo.getOther_asset_personal_prop_resp(),
					aBeforeCargo.getOther_asset_personal_prop_resp()));
			return;

		case OTHR_ASET_REAL_PROPERTY:
			aPageCargo.setOther_asset_real_property_resp(copyingProfileStatus(aPageCargo.getOther_asset_real_property_resp(),
					aBeforeCargo.getOther_asset_real_property_resp()));
			return;

		case OTHR_ASET_VEHICLE:
			aPageCargo.setOther_asset_vehicle_resp(copyingProfileStatus(aPageCargo.getOther_asset_vehicle_resp(),
					aBeforeCargo.getOther_asset_vehicle_resp()));
			return;

		case OTHR_ASET_TRANSFER:
			aPageCargo.setOther_asset_transfer_resp(copyingProfileStatus(aPageCargo.getOther_asset_transfer_resp(),
					aBeforeCargo.getOther_asset_transfer_resp()));
			return;

		case REAL_ASET_APARTMENT:
			aPageCargo.setReal_aset_apt_resp(copyingProfileStatus(aPageCargo.getReal_aset_apt_resp(), aBeforeCargo.getReal_aset_apt_resp()));
			return;

		case REAL_ASET_VAC:
			aPageCargo.setReal_aset_vac_resp(copyingProfileStatus(aPageCargo.getReal_aset_vac_resp(), aBeforeCargo.getReal_aset_vac_resp()));
			return;

		case REAL_ASET_RENTAL:
			aPageCargo.setReal_asset_rental_resp(copyingProfileStatus(aPageCargo.getReal_asset_rental_resp(),
					aBeforeCargo.getReal_asset_rental_resp()));
			return;

		case REAL_ASET_COMMERCIAL:
			aPageCargo.setReal_aset_com_resp(copyingProfileStatus(aPageCargo.getReal_aset_com_resp(), aBeforeCargo.getReal_aset_com_resp()));
			return;

		case REAL_ASET_CONDO:
			aPageCargo.setReal_aset_con_resp(copyingProfileStatus(aPageCargo.getReal_aset_con_resp(), aBeforeCargo.getReal_aset_con_resp()));
			return;

		case REAL_ASET_DUPLEX:
			aPageCargo.setReal_aset_dup_resp(copyingProfileStatus(aPageCargo.getReal_aset_dup_resp(), aBeforeCargo.getReal_aset_dup_resp()));
			return;

		case REAL_ASET_FARM:
			aPageCargo.setReal_aset_frm_resp(copyingProfileStatus(aPageCargo.getReal_aset_frm_resp(), aBeforeCargo.getReal_aset_frm_resp()));
			return;

			// real
		case REAL_ASET_HOUSE:
			aPageCargo.setReal_asset_house_resp(copyingProfileStatus(aPageCargo.getReal_asset_house_resp(), aBeforeCargo.getReal_asset_house_resp()));
			return;

		case REAL_ASET_LAND:
			aPageCargo.setReal_asset_land_resp(copyingProfileStatus(aPageCargo.getReal_asset_land_resp(), aBeforeCargo.getReal_asset_land_resp()));
			return;

		case REAL_ASET_MOBILE_HOME:
			aPageCargo.setReal_asset_mobile_home_resp(copyingProfileStatus(aPageCargo.getReal_asset_mobile_home_resp(),
					aBeforeCargo.getReal_asset_mobile_home_resp()));
			return;

		case REAL_ASET_OTHER:
			aPageCargo.setReal_asset_other_resp(copyingProfileStatus(aPageCargo.getReal_asset_other_resp(), aBeforeCargo.getReal_asset_other_resp()));
			return;
		case REAL_ASET_HOME:
			aPageCargo.setReal_asset_home_resp(copyingProfileStatus(aPageCargo.getReal_asset_home_resp(), aBeforeCargo.getReal_asset_home_resp()));
			return;
		case REAL_ASET_LIFE_ESTATE:
			aPageCargo.setReal_asset_life_estate_resp(copyingProfileStatus(aPageCargo.getReal_asset_life_estate_resp(),
					aBeforeCargo.getReal_asset_life_estate_resp()));
			return;
		case REAL_ASET_UNOCCUPY_HOME:
			aPageCargo.setReal_asset_unoccupy_home_resp(copyingProfileStatus(aPageCargo.getReal_asset_unoccupy_home_resp(),
					aBeforeCargo.getReal_asset_unoccupy_home_resp()));
			return;
		case VEH_ASET_ANIMAL_DRAWN:
			aPageCargo.setVehicle_asset_animal_drwn_resp(copyingProfileStatus(aPageCargo.getVehicle_asset_animal_drwn_resp(),
					aBeforeCargo.getVehicle_asset_animal_drwn_resp()));
			return;
		case VEH_ASET_NONMOTORIZED_CAMPER:
			aPageCargo.setVehicle_asset_nmot_camper_resp(copyingProfileStatus(aPageCargo.getVehicle_asset_nmot_camper_resp(),
					aBeforeCargo.getVehicle_asset_nmot_camper_resp()));
			return;
		case VEH_ASET_UNLIC:
			aPageCargo.setVeh_aset_unlic_resp(copyingProfileStatus(aPageCargo.getVeh_aset_unlic_resp(), aBeforeCargo.getVeh_aset_unlic_resp()));
			return;
		case VEH_ASET_GOLFCART:
			aPageCargo.setVehicle_asset_golf_cart_resp(copyingProfileStatus(aPageCargo.getVehicle_asset_golf_cart_resp(),
					aBeforeCargo.getVehicle_asset_golf_cart_resp()));
			return;
		case VEH_ASET_TRACTOR:
			aPageCargo.setVehicle_asset_tractor_resp(copyingProfileStatus(aPageCargo.getVehicle_asset_tractor_resp(),
					aBeforeCargo.getVehicle_asset_tractor_resp()));
			return;
		case VEH_ASET_AIRPLANE:
			aPageCargo.setVeh_aset_arpl_resp(copyingProfileStatus(aPageCargo.getVeh_aset_arpl_resp(), aBeforeCargo.getVeh_aset_arpl_resp()));
			return;

		case VEH_ASET_AUTOMOBILE:
			aPageCargo.setVehicle_asset_auto_resp(copyingProfileStatus(aPageCargo.getVehicle_asset_auto_resp(),
					aBeforeCargo.getVehicle_asset_auto_resp()));
			return;

		case VEH_ASET_BOAT:
			aPageCargo.setVehicle_asset_boat_resp(copyingProfileStatus(aPageCargo.getVehicle_asset_boat_resp(),
					aBeforeCargo.getVehicle_asset_boat_resp()));
			return;

		case VEH_ASET_BUS:
			aPageCargo.setVeh_aset_bus_resp(copyingProfileStatus(aPageCargo.getVeh_aset_bus_resp(), aBeforeCargo.getVeh_aset_bus_resp()));
			return;

		case VEH_ASET_CAMPER:
			aPageCargo.setVehicle_asset_camper_resp(copyingProfileStatus(aPageCargo.getVehicle_asset_camper_resp(),
					aBeforeCargo.getVehicle_asset_camper_resp()));
			return;

		case VEH_ASET_FARM_IMPLEMENT:
			aPageCargo.setVeh_aset_fimp_resp(copyingProfileStatus(aPageCargo.getVeh_aset_fimp_resp(), aBeforeCargo.getVeh_aset_fimp_resp()));
			return;

		case VEH_ASET_FARM_EQUIP:
			aPageCargo.setVeh_aset_fmeq_resp(copyingProfileStatus(aPageCargo.getVeh_aset_fmeq_resp(), aBeforeCargo.getVeh_aset_fmeq_resp()));
			return;

		case VEH_ASET_FARM_TRACTOR:
			aPageCargo.setVeh_aset_ftrc_resp(copyingProfileStatus(aPageCargo.getVeh_aset_ftrc_resp(), aBeforeCargo.getVeh_aset_ftrc_resp()));
			return;

		case VEH_ASET_FARM_TRAILER:
			aPageCargo.setVeh_aset_ftrl_resp(copyingProfileStatus(aPageCargo.getVeh_aset_ftrl_resp(), aBeforeCargo.getVeh_aset_ftrl_resp()));
			return;

		case VEH_ASET_LOG_SKIDDER:
			aPageCargo.setVeh_aset_lskd_resp(copyingProfileStatus(aPageCargo.getVeh_aset_lskd_resp(), aBeforeCargo.getVeh_aset_lskd_resp()));
			return;

		case VEH_ASET_MOTORCYCLE:
			aPageCargo.setVehicle_asset_motorcycle_resp(copyingProfileStatus(aPageCargo.getVehicle_asset_motorcycle_resp(),
					aBeforeCargo.getVehicle_asset_motorcycle_resp()));
			return;

		case VEH_ASET_NONMOTORIZED_BOAT:
			aPageCargo.setVeh_aset_nm_b_resp(copyingProfileStatus(aPageCargo.getVeh_aset_nm_b_resp(), aBeforeCargo.getVeh_aset_nm_b_resp()));
			return;

		case VEH_ASET_OTHER:
			aPageCargo.setVeh_aset_othr_resp(copyingProfileStatus(aPageCargo.getVeh_aset_othr_resp(), aBeforeCargo.getVeh_aset_othr_resp()));
			return;

		case VEH_ASET_RECREATIONAL_VEHICLE:
			aPageCargo.setVehicle_asset_recreation_resp(copyingProfileStatus(aPageCargo.getVehicle_asset_recreation_resp(),
					aBeforeCargo.getVehicle_asset_recreation_resp()));
			return;

		case VEH_ASET_TRUCK:
			aPageCargo.setVeh_aset_trk_resp(copyingProfileStatus(aPageCargo.getVeh_aset_trk_resp(), aBeforeCargo.getVeh_aset_trk_resp()));
			return;

		case VEH_ASET_TRAVEL_TRAILER:
			aPageCargo.setVeh_aset_trlr_resp(copyingProfileStatus(aPageCargo.getVeh_aset_trlr_resp(), aBeforeCargo.getVeh_aset_trlr_resp()));
			return;

		case VEH_ASET_VAN:
			aPageCargo.setVeh_aset_van_resp(copyingProfileStatus(aPageCargo.getVeh_aset_van_resp(), aBeforeCargo.getVeh_aset_van_resp()));
			return;
			// PCR# 40362 - ADDED NEW RESPONSES FOR RMB AND SMRF CHANGES - ends

		case APRV_ACTV_RESP:
			return;
		case BNFT_CRT_O_KC_RESP:
			return;
		case BNFT_FC_RESP:
			return;
		case BNFT_KC_RESP:
			return;
		case BNFT_SG_RESP:
			return;
		case INDV_CC_RQST_IND:
			aPageCargo.setIndv_cc_rqst_ind(copyingProfileStatus(aPageCargo.getIndv_cc_rqst_ind(), aBeforeCargo.getIndv_cc_rqst_ind()));
			return;
		case SCHL_ENRL_RESP:
			aPageCargo.setSchool_enrollment_resp(copyingProfileStatus(aPageCargo.getSchool_enrollment_resp(),
					aBeforeCargo.getSchool_enrollment_resp()));
			return;
		case TRB_CMDY_RESP:
			return;
		case HEAD_OF_HOUSE:
			aPageCargo.setHead_of_household_resp(copyingProfileStatus(aPageCargo.getHead_of_household_resp(),
					aBeforeCargo.getHead_of_household_resp()));
			return;
			// EDSP RMB Other Income
		case STRIKE_BENEFITS_RESP:
			aPageCargo.setBenefits_on_strike_resp(copyingProfileStatus(aPageCargo.getBenefits_on_strike_resp(),
					aBeforeCargo.getBenefits_on_strike_resp()));
			return;
		case TRAINING_ALLOWANCE:
			aPageCargo.setTraining_allowance_resp(copyingProfileStatus(aPageCargo.getTraining_allowance_resp(),
					aBeforeCargo.getTraining_allowance_resp()));
			return;
		case INHERITANCE:
			aPageCargo.setInheritance_resp(copyingProfileStatus(aPageCargo.getInheritance_resp(), aBeforeCargo.getInheritance_resp()));
			return;
		case STUDENT_FINANCIAL_AID:
			aPageCargo.setStudent_financial_aid_resp(copyingProfileStatus(aPageCargo.getStudent_financial_aid_resp(),
					aBeforeCargo.getStudent_financial_aid_resp()));
			return;
		case FOOD_CLOTHING_UTIL_RENT:
			aPageCargo.setFood_clothing_util_rent_resp(copyingProfileStatus(aPageCargo.getFood_clothing_util_rent_resp(),
					aBeforeCargo.getFood_clothing_util_rent_resp()));
			return;
		case CASH_GIFTS_CONT:
			aPageCargo.setCash_gifts_resp(copyingProfileStatus(aPageCargo.getCash_gifts_resp(), aBeforeCargo.getCash_gifts_resp()));
			return;
		case LOAN:
			aPageCargo.setLoan_resp(copyingProfileStatus(aPageCargo.getLoan_resp(), aBeforeCargo.getLoan_resp()));
			return;
		case BLACK_LUNG_BENEFIT:
			aPageCargo.setBenefit_black_lung_resp(copyingProfileStatus(aPageCargo.getBenefit_black_lung_resp(),
					aBeforeCargo.getBenefit_black_lung_resp()));
			return;
		case LOTTERY_PRIZE_WINNING:
			aPageCargo.setLottery_prize_winning_resp(copyingProfileStatus(aPageCargo.getLottery_prize_winning_resp(),
					aBeforeCargo.getLottery_prize_winning_resp()));
			return;
		case INSURANCE_SETTLEMENT:
			aPageCargo.setInsurance_settlement_resp(copyingProfileStatus(aPageCargo.getInsurance_settlement_resp(),
					aBeforeCargo.getInsurance_settlement_resp()));
			return;
		case OTHR_SOCIAL_SECURITY_BENEFITS:
			aPageCargo.setOthr_social_security_bnft_resp(copyingProfileStatus(aPageCargo.getOthr_social_security_bnft_resp(),
					aBeforeCargo.getOthr_social_security_bnft_resp()));
			return;
		case RESETTL_INC_RESP:
			aPageCargo.setResettl_inc_resp(copyingProfileStatus(aPageCargo.getResettl_inc_resp(), aBeforeCargo.getResettl_inc_resp()));
			return;
		case OTHR_INCM_RENTL_RESP:
			aPageCargo.setOthr_incm_rentl_resp(copyingProfileStatus(aPageCargo.getOthr_incm_rentl_resp(), aBeforeCargo.getOthr_incm_rentl_resp()));
			return;
		case LAND_CONT_RESP:
			aPageCargo.setLand_cont_resp(copyingProfileStatus(aPageCargo.getLand_cont_resp(), aBeforeCargo.getLand_cont_resp()));
			return;
		case HOUSING_BILLS_OTHERS:
			aPageCargo.setHousing_bill_others_resp(copyingProfileStatus(aPageCargo.getHousing_bill_others_resp(),
					aBeforeCargo.getHousing_bill_others_resp()));
			return;
		case UTILITY_BILLS_OIL:
			aPageCargo.setUtility_bills_oil_resp(copyingProfileStatus(aPageCargo.getUtility_bills_oil_resp(),
					aBeforeCargo.getUtility_bills_oil_resp()));
			return;
		case WORK_RELATED_EXPENSE_RESP:
			aPageCargo.setWork_related_expense_resp(copyingProfileStatus(aPageCargo.getWork_related_expense_resp(),
					aBeforeCargo.getWork_related_expense_resp()));
			return;
		case RECEIVE_MEDICARE:
			aPageCargo.setRcv_medcr_resp(copyingProfileStatus(aPageCargo.getRcv_medcr_resp(), aBeforeCargo.getRcv_medcr_resp()));
			return;
		case LIFE_INS_ASSET_WHOLE_LIFE_RESP:
			aPageCargo.setLife_ins_asset_whole_life_resp(copyingProfileStatus(aPageCargo.getLife_ins_asset_whole_life_resp(),
					aBeforeCargo.getLife_ins_asset_whole_life_resp()));
			return;
		case LIFE_INSURANCE_ASSET_TERM_RESP:
			aPageCargo.setLife_insurance_asset_term_resp(copyingProfileStatus(aPageCargo.getLife_insurance_asset_term_resp(),
					aBeforeCargo.getLife_insurance_asset_term_resp()));
			return;
		case LIFE_INS_ASEST_GROUP_LIFE_RESP:
			aPageCargo.setLife_ins_asest_group_life_resp(copyingProfileStatus(aPageCargo.getLife_ins_asest_group_life_resp(),
					aBeforeCargo.getLife_ins_asest_group_life_resp()));
			return;
		case LIFE_INS_ASSET_GROUP_TERM_RESP:
			aPageCargo.setLife_ins_asset_group_term_resp(copyingProfileStatus(aPageCargo.getLife_ins_asset_group_term_resp(),
					aBeforeCargo.getLife_ins_asset_group_term_resp()));
			return;
		case LIFE_INS_ASSET_UNIVERSAL_RESP:
			aPageCargo.setLife_ins_asset_universal_resp(copyingProfileStatus(aPageCargo.getLife_ins_asset_universal_resp(),
					aBeforeCargo.getLife_ins_asset_universal_resp()));
			return;
		case LIFE_INSURANCE_OTHER_RESP:
			aPageCargo.setLife_insurance_other_resp(copyingProfileStatus(aPageCargo.getLife_insurance_other_resp(),
					aBeforeCargo.getLife_insurance_other_resp()));
			return;

		case MED_TYPE_PROSTHETIC_RESP:
			aPageCargo.setMed_type_prosthetic_resp(copyingProfileStatus(aPageCargo.getMed_type_prosthetic_resp(),
					aBeforeCargo.getMed_type_prosthetic_resp()));
			return;

		case MED_TYPE_ATNDNT_MEAL_RESP:
			aPageCargo.setMed_type_atndnt_meal_resp(copyingProfileStatus(aPageCargo.getMed_type_atndnt_meal_resp(),
					aBeforeCargo.getMed_type_atndnt_meal_resp()));
			return;
		case MED_TYPE_ANIMAL_RESP:
			aPageCargo.setMed_type_animal_resp(copyingProfileStatus(aPageCargo.getMed_type_animal_resp(), aBeforeCargo.getMed_type_animal_resp()));
			return;
		case MED_TYPE_MAINTAIN_ATTNDNT_RESP:
			aPageCargo.setMed_type_maintain_attndnt_resp(copyingProfileStatus(aPageCargo.getMed_type_maintain_attndnt_resp(),
					aBeforeCargo.getMed_type_maintain_attndnt_resp()));
			return;
		case MED_TYPE_INHOME_RESP:
			aPageCargo.setMed_type_inhome_resp(copyingProfileStatus(aPageCargo.getMed_type_inhome_resp(), aBeforeCargo.getMed_type_inhome_resp()));
			return;
		case MED_TYPE_SPECIAL_EQUIP_RESP:
			aPageCargo.setMed_type_special_equip_resp(copyingProfileStatus(aPageCargo.getMed_type_special_equip_resp(),
					aBeforeCargo.getMed_type_special_equip_resp()));
			return;
		case MED_TYPE_EYEGLASSES_RESP:
			aPageCargo.setMed_type_eyeglasses_resp(copyingProfileStatus(aPageCargo.getMed_type_eyeglasses_resp(),
					aBeforeCargo.getMed_type_eyeglasses_resp()));
			return;
		case MED_TYPE_INSURANCE_RESP:
			aPageCargo.setMed_type_insurance_resp(copyingProfileStatus(aPageCargo.getMed_type_insurance_resp(),
					aBeforeCargo.getMed_type_insurance_resp()));
			return;
		case MED_TYPE_BILLS_RESP:
			aPageCargo.setMed_type_bills_resp(copyingProfileStatus(aPageCargo.getMed_type_bills_resp(), aBeforeCargo.getMed_type_bills_resp()));
			return;
		case MED_TYPE_SUPPLIES_RESP:
			aPageCargo.setMed_type_supplies_resp(copyingProfileStatus(aPageCargo.getMed_type_supplies_resp(),
					aBeforeCargo.getMed_type_supplies_resp()));
			return;
		case MED_TYPE_NURSING_RESP:
			aPageCargo.setMed_type_nursing_resp(copyingProfileStatus(aPageCargo.getMed_type_nursing_resp(), aBeforeCargo.getMed_type_nursing_resp()));
			return;
		case MED_TYPE_OTHER_RESP:
			aPageCargo.setMed_type_other_resp(copyingProfileStatus(aPageCargo.getMed_type_other_resp(), aBeforeCargo.getMed_type_other_resp()));
			return;
		case MED_TYPE_OUT_PATIENT_RESP:
			aPageCargo.setMed_type_out_patient_resp(copyingProfileStatus(aPageCargo.getMed_type_out_patient_resp(),
					aBeforeCargo.getMed_type_out_patient_resp()));
			return;
		case MED_TYPE_PSYCHOTHERAPY_RESP:
			aPageCargo.setMed_type_psychotherapy_resp(copyingProfileStatus(aPageCargo.getMed_type_psychotherapy_resp(),
					aBeforeCargo.getMed_type_psychotherapy_resp()));
			return;
		case MED_TYPE_PRESCRIBED_DRUG_RESP:
			aPageCargo.setMed_type_prescribed_drug_resp(copyingProfileStatus(aPageCargo.getMed_type_prescribed_drug_resp(),
					aBeforeCargo.getMed_type_prescribed_drug_resp()));
			return;
		case MED_TYPE_TRANSPORTATION_RESP:
			aPageCargo.setMed_type_transportation_resp(copyingProfileStatus(aPageCargo.getMed_type_transportation_resp(),
					aBeforeCargo.getMed_type_transportation_resp()));
			return;
		case UTILITY_STANDARD_RESP:
			aPageCargo.setUtility_standard_resp(copyingProfileStatus(aPageCargo.getUtility_standard_resp(), aBeforeCargo.getUtility_standard_resp()));
			return;
		case ROOM_BOARD:
			aPageCargo.setRoom_board_resp(copyingProfileStatus(aPageCargo.getRoom_board_resp(), aBeforeCargo.getRoom_board_resp()));
			return;
		case PAROLE_VIOLATION:
			aPageCargo.setParole_violation_resp(copyingProfileStatus(aPageCargo.getParole_violation_resp(), aBeforeCargo.getParole_violation_resp()));
			return;
		case HOSPITAL_STAY_RESP:
			aPageCargo.setHospital_stay_resp(copyingProfileStatus(aPageCargo.getHospital_stay_resp(), aBeforeCargo.getHospital_stay_resp()));
			return;
		case CHILD_CARE_RESP:
			aPageCargo.setChild_care_resp(copyingProfileStatus(aPageCargo.getChild_care_resp(), aBeforeCargo.getChild_care_resp()));
			return;
		case CHILD_OBLIGATION_RESP:
			aPageCargo.setChild_obligation_resp(copyingProfileStatus(aPageCargo.getChild_obligation_resp(), aBeforeCargo.getChild_obligation_resp()));
			return;
		case MEDICAL_BILLS_RESP:
			aPageCargo.setMedical_bills_resp(copyingProfileStatus(aPageCargo.getMedical_bills_resp(), aBeforeCargo.getMedical_bills_resp()));
			return;
		case MEDTYP_DENTAL:
			aPageCargo.setMedtyp_dental(copyingProfileStatus(aPageCargo.getMedtyp_dental(), aBeforeCargo.getMedtyp_dental()));
			return;
		case MEDTYP_ATTENDANT_CARE:
			aPageCargo.setMedtyp_attendant_care(copyingProfileStatus(aPageCargo.getMedtyp_attendant_care(), aBeforeCargo.getMedtyp_attendant_care()));
			return;
		case MEDTYP_DOCTOR:
			aPageCargo.setMedtyp_doctor(copyingProfileStatus(aPageCargo.getMedtyp_doctor(), aBeforeCargo.getMedtyp_doctor()));
			return;
		case MEDTYP_MED_EQUIP:
			aPageCargo.setMedtyp_med_equip(copyingProfileStatus(aPageCargo.getMedtyp_med_equip(), aBeforeCargo.getMedtyp_med_equip()));
			return;
		case MEDTYP_HOSP_BILLS:
			aPageCargo.setMedtyp_hosp_bills(copyingProfileStatus(aPageCargo.getMedtyp_hosp_bills(), aBeforeCargo.getMedtyp_hosp_bills()));
			return;
		case MEDTYP_INSUR_PREMIUM:
			aPageCargo.setMedtyp_insur_premium(copyingProfileStatus(aPageCargo.getMedtyp_insur_premium(), aBeforeCargo.getMedtyp_insur_premium()));
			return;
		case MEDTYP_RX_COST:
			aPageCargo.setMedtyp_rx_cost(copyingProfileStatus(aPageCargo.getMedtyp_rx_cost(), aBeforeCargo.getMedtyp_rx_cost()));
			return;
		case MEDTYP_TRANS_MED:
			aPageCargo.setMedtyp_trans_med(copyingProfileStatus(aPageCargo.getMedtyp_trans_med(), aBeforeCargo.getMedtyp_trans_med()));
			return;
		case MEDTYP_OTHER:
			aPageCargo.setMedtyp_other(copyingProfileStatus(aPageCargo.getMedtyp_other(), aBeforeCargo.getMedtyp_other()));
			return;
		case UNPAID_MEDBILL:
			aPageCargo.setUnpaid_medbill(copyingProfileStatus(aPageCargo.getUnpaid_medbill(), aBeforeCargo.getUnpaid_medbill()));
			return;
		case MEDTYP_HSA_CONTRIB:
			aPageCargo.setMedtyp_hsa_contrib(copyingProfileStatus(aPageCargo.getMedtyp_hsa_contrib(), aBeforeCargo.getMedtyp_hsa_contrib()));
			return;
		case UEI_ADOPTION_ASSIST:
			aPageCargo.setAdoptAssistance(copyingProfileStatus(aPageCargo.getAdoptAssistance(), aBeforeCargo.getAdoptAssistance()));
			return;
		case UEI_ADOPTION_PYMT:
			aPageCargo.setAdoptionPayments(copyingProfileStatus(aPageCargo.getAdoptionPayments(), aBeforeCargo.getAdoptionPayments()));
			return;
		case UEI_AGENT_ORNG_PYMT:
			aPageCargo.setAgentOrangePayments(copyingProfileStatus(aPageCargo.getAgentOrangePayments(), aBeforeCargo.getAgentOrangePayments()));
			return;
		case UEI_ALIMONY:
			aPageCargo.setAlimony(copyingProfileStatus(aPageCargo.getAlimony(), aBeforeCargo.getAlimony()));
			return;
		case UEI_CAPITAL_GAINS:
			aPageCargo.setCapitalGains(copyingProfileStatus(aPageCargo.getCapitalGains(), aBeforeCargo.getCapitalGains()));
			return;
		case UEI_DEATH_BNFT:
			aPageCargo.setDeathBenefits(copyingProfileStatus(aPageCargo.getDeathBenefits(), aBeforeCargo.getDeathBenefits()));
			return;
		case UEI_DABL_INCM:
			aPageCargo.setDisabilityIncome(copyingProfileStatus(aPageCargo.getDisabilityIncome(), aBeforeCargo.getDisabilityIncome()));
			return;
		case UEI_DR_RELIEF:
			aPageCargo.setDisasterRelief(copyingProfileStatus(aPageCargo.getDisasterRelief(), aBeforeCargo.getDisasterRelief()));
			return;
		case UEI_EDU_ASSIST:
			aPageCargo.setEducationalAssistance(copyingProfileStatus(aPageCargo.getEducationalAssistance(), aBeforeCargo.getEducationalAssistance()));
			return;
		case UEI_ENERGY_ASSIST:
			aPageCargo.setEnergyAssistance(copyingProfileStatus(aPageCargo.getEnergyAssistance(), aBeforeCargo.getEnergyAssistance()));
			return;
		case UEI_FRM_ALOT:
			aPageCargo.setFarmAllotment(copyingProfileStatus(aPageCargo.getFarmAllotment(), aBeforeCargo.getFarmAllotment()));
			return;
		case UEI_FOSTER_CARE_PYMT:
			aPageCargo.setFosterCarePayments(copyingProfileStatus(aPageCargo.getFosterCarePayments(), aBeforeCargo.getFosterCarePayments()));
			return;
		case UEI_GEN_ASSIST:
			aPageCargo.setGeneralAssistance(copyingProfileStatus(aPageCargo.getGeneralAssistance(), aBeforeCargo.getGeneralAssistance()));
			return;
		case UEI_INT_DIV_PYMT:
			aPageCargo.setInterestDividendPayments(copyingProfileStatus(aPageCargo.getInterestDividendPayments(),
					aBeforeCargo.getInterestDividendPayments()));
			return;
		case UEI_IRA_DIST:
			aPageCargo.setiRADistribution(copyingProfileStatus(aPageCargo.getiRADistribution(), aBeforeCargo.getiRADistribution()));
			return;
		case UEI_LOTTERY_WIN:
			aPageCargo.setLotteryWinnings(copyingProfileStatus(aPageCargo.getLotteryWinnings(), aBeforeCargo.getLotteryWinnings()));
			return;
		case UEI_LUMP_SUM:
			aPageCargo.setLumpSum(copyingProfileStatus(aPageCargo.getLumpSum(), aBeforeCargo.getLumpSum()));
			return;
		case UEI_MIL_ALOT:
			aPageCargo.setMilitaryAllotment(copyingProfileStatus(aPageCargo.getMilitaryAllotment(), aBeforeCargo.getMilitaryAllotment()));
			return;
		case UEI_MON_FRO_OTH:
			aPageCargo.setMoneyFromAnotherPerson(copyingProfileStatus(aPageCargo.getMoneyFromAnotherPerson(),
					aBeforeCargo.getMoneyFromAnotherPerson()));
			return;
		case UEI_NET_RENT_ROYALTY:
			aPageCargo.setNetRentalRoyalty(copyingProfileStatus(aPageCargo.getNetRentalRoyalty(), aBeforeCargo.getNetRentalRoyalty()));
			return;
		case UEI_OTH:
			aPageCargo.setOtherIncome(copyingProfileStatus(aPageCargo.getOtherIncome(), aBeforeCargo.getOtherIncome()));
			return;
		case UEI_ANNY_PYMT:
			aPageCargo.setPaymentsFromAnnuity(copyingProfileStatus(aPageCargo.getPaymentsFromAnnuity(), aBeforeCargo.getPaymentsFromAnnuity()));
			return;
		case UEI_PYMT_BO:
			aPageCargo.setPaymentsMadeOnYourBehalf(copyingProfileStatus(aPageCargo.getPaymentsMadeOnYourBehalf(),
					aBeforeCargo.getPaymentsMadeOnYourBehalf()));
			return;
		case UEI_PENSION:
			aPageCargo.setPensionOrRetirement(copyingProfileStatus(aPageCargo.getPensionOrRetirement(), aBeforeCargo.getPensionOrRetirement()));
			return;
		case UEI_RR_RETIRE:
			aPageCargo.setRailroadRetirement(copyingProfileStatus(aPageCargo.getRailroadRetirement(), aBeforeCargo.getRailroadRetirement()));
			return;
		case UEI_REFUGEE_CASH:
			aPageCargo.setRefugeeCash(copyingProfileStatus(aPageCargo.getRefugeeCash(), aBeforeCargo.getRefugeeCash()));
			return;
		case UEI_REL_CARE:
			aPageCargo.setRelativeCareSubsidy(copyingProfileStatus(aPageCargo.getRelativeCareSubsidy(), aBeforeCargo.getRelativeCareSubsidy()));
			return;
		case UEI_RENTAL_INCM:
			aPageCargo.setRentalIncome(copyingProfileStatus(aPageCargo.getRentalIncome(), aBeforeCargo.getRentalIncome()));
			return;
		case UEI_TANF_PYMT:
			aPageCargo.settANFPayments(copyingProfileStatus(aPageCargo.gettANFPayments(), aBeforeCargo.gettANFPayments()));
			return;
		case UEI_UNEMPL:
			aPageCargo.setUnemploymentCompensation(copyingProfileStatus(aPageCargo.getUnemploymentCompensation(),
					aBeforeCargo.getUnemploymentCompensation()));
			return;
		case UEI_WORKER_STUDY:
			aPageCargo.setWorkStudyStateFederal(copyingProfileStatus(aPageCargo.getWorkStudyStateFederal(), aBeforeCargo.getWorkStudyStateFederal()));
			return;
		case UEI_WORKER_COMP:
			aPageCargo.setWorkersCompensation(copyingProfileStatus(aPageCargo.getWorkersCompensation(), aBeforeCargo.getWorkersCompensation()));
			return;
		case PERS_PROP_BUS_EQPT:
			aPageCargo.setPers_prop_bus_eqpt(copyingProfileStatus(aPageCargo.getPers_prop_bus_eqpt(), aBeforeCargo.getPers_prop_bus_eqpt()));
			return;
		case PERS_PROP_CEMETARY_LOT:
			aPageCargo.setPers_prop_cemetary_lot(copyingProfileStatus(aPageCargo.getPers_prop_cemetary_lot(),
					aBeforeCargo.getPers_prop_cemetary_lot()));
			return;
		case PERS_PROP_LIVESTOCK:
			aPageCargo.setPers_prop_livestock(copyingProfileStatus(aPageCargo.getPers_prop_livestock(), aBeforeCargo.getPers_prop_livestock()));
			return;
		case PERS_PROP_SAF_DEPST_BOX:
			aPageCargo.setPers_prop_saf_depst_box(copyingProfileStatus(aPageCargo.getPers_prop_saf_depst_box(),
					aBeforeCargo.getPers_prop_saf_depst_box()));
			return;
		case PERS_PROP_OTH_VAL:
			aPageCargo.setPers_prop_oth_val(copyingProfileStatus(aPageCargo.getPers_prop_oth_val(), aBeforeCargo.getPers_prop_oth_val()));
			return;

			// Added by Srividhya 16Mar15 for RMC5 Pregnancy changes
		case ABLE_TO_CONCEIVE_RESP:
			aPageCargo.setAble_to_conceive_resp(copyingProfileStatus(aPageCargo.getAble_to_conceive_resp(), aBeforeCargo.getAble_to_conceive_resp()));
			return;

		case UNDERWEIGHT_BIRTH_RESP:
			aPageCargo.setUnderweight_birth_resp(copyingProfileStatus(aPageCargo.getUnderweight_birth_resp(),
					aBeforeCargo.getUnderweight_birth_resp()));
			return;

		case PREG_ADD_STAT_SW:
			aPageCargo.setPreg_add_stat_sw(copyingProfileStatus(aPageCargo.getPreg_add_stat_sw(), aBeforeCargo.getPreg_add_stat_sw()));
			return;

		case PREG_CHG_STAT_SW:
			aPageCargo.setPreg_chg_stat_sw(copyingProfileStatus(aPageCargo.getPreg_chg_stat_sw(), aBeforeCargo.getPreg_chg_stat_sw()));
			return;

		case SU_CST_INS_RESP:
			aPageCargo.setSu_cst_ins_resp(copyingProfileStatus(aPageCargo.getSu_cst_ins_resp(), aBeforeCargo.getSu_cst_ins_resp()));
			return;
		case OTHER_HOUSING_BILL_RESP:
			aPageCargo.setOther_housing_bill_resp(copyingProfileStatus(aPageCargo.getOther_housing_bill_resp(),
					aBeforeCargo.getOther_housing_bill_resp()));
			return;
		case DISASTER_REPAIR_RESP:
			aPageCargo.setDisaster_repair_resp(copyingProfileStatus(aPageCargo.getDisaster_repair_resp(), aBeforeCargo.getDisaster_repair_resp()));
			return;
		case PREVENT_EVICTION_RESP:
			aPageCargo.setPrevent_eviction_resp(copyingProfileStatus(aPageCargo.getPrevent_eviction_resp(), aBeforeCargo.getPrevent_eviction_resp()));
			return;
		case CARE_TAKER_RESP:
			aPageCargo.setCareTaker_resp(copyingProfileStatus(aPageCargo.getCareTaker_resp(), aBeforeCargo.getCareTaker_resp()));
			return;
		case LOST_HEALTH_INS_IND:
			aPageCargo.setLost_health_ins_ind(copyingProfileStatus(aPageCargo.getLost_health_ins_ind(), aBeforeCargo.getLost_health_ins_ind()));
			return;
		case TAX_CLAIM_DEPENDENT:
			aPageCargo.setTax_claim_dependant_resp(copyingProfileStatus(aPageCargo.getTax_claim_dependant_resp(),
					aBeforeCargo.getTax_claim_dependant_resp()));
			return;
			//NextGen  NG-6481 Phase 3 updates to ACA Streamline changes : Start
		case BEFORE_TAX_DEDUCTION:
			aPageCargo.setBefore_tax_deduction_resp(copyingProfileStatus(aPageCargo.getBefore_tax_deduction_resp(),
					aBeforeCargo.getBefore_tax_deduction_resp()));
			return;
		case BTD_MED_INS:
			aPageCargo.setBtd_med_ins(copyingProfileStatus(aPageCargo.getBtd_med_ins(), aBeforeCargo.getBtd_med_ins()));
			return;
		case BTD_DENT_INS:
			aPageCargo.setBtd_dent_ins(copyingProfileStatus(aPageCargo.getBtd_dent_ins(), aBeforeCargo.getBtd_dent_ins()));
			return;
		case BTD_VIS_CARE_INS:
			aPageCargo.setBtd_vis_care_ins(copyingProfileStatus(aPageCargo.getBtd_vis_care_ins(), aBeforeCargo.getBtd_vis_care_ins()));
			return;
		case BTD_FLEX_ACC:
			aPageCargo.setBtd_flex_acc(copyingProfileStatus(aPageCargo.getBtd_flex_acc(), aBeforeCargo.getBtd_flex_acc()));
			return;
		case BTD_DEF_COMP:
			aPageCargo.setBtd_def_comp(copyingProfileStatus(aPageCargo.getBtd_def_comp(), aBeforeCargo.getBtd_def_comp()));
			return;
		case BTD_PRE_TAX_INS:
			aPageCargo.setBtd_pre_tax_ins(copyingProfileStatus(aPageCargo.getBtd_pre_tax_ins(), aBeforeCargo.getBtd_pre_tax_ins()));
			return;
		case BTD_OTHER:
			aPageCargo.setBtd_other(copyingProfileStatus(aPageCargo.getBtd_other(), aBeforeCargo.getBtd_other()));
			return;
		case TAX_DEDUCT_RESP:
			aPageCargo.setTax_deduct_resp(copyingProfileStatus(aPageCargo.getTax_deduct_resp(), aBeforeCargo.getTax_deduct_resp()));
			return;
			// NextGen NG-6481 Phase 3 updates to ACA Streamline changes – end
		case HLTH_INS_RESP:
			aPageCargo.setHlth_ins_resp(copyingProfileStatus(aPageCargo.getHlth_ins_resp(), aBeforeCargo.getHlth_ins_resp()));
			return;
		case OTHR_HLTH_INS_RESP:
			aPageCargo.setOthr_hlth_ins_resp(copyingProfileStatus(aPageCargo.getOthr_hlth_ins_resp(), aBeforeCargo.getOthr_hlth_ins_resp()));
			return;
			//add and change indicators
		case ROOM_BRD_CHG_IND:
			aPageCargo.setRoom_brd_chg_ind(copyingProfileStatus(aPageCargo.getRoom_brd_chg_ind(), aBeforeCargo.getRoom_brd_chg_ind()));
			return;
		case DABL_STAT_IND:
			aPageCargo.setDabl_stat_ind(copyingProfileStatus(aPageCargo.getDabl_stat_ind(), aBeforeCargo.getDabl_stat_ind()));
			return;
		case PREG_ADD_STAT_IND:
			aPageCargo.setPreg_add_stat_ind(copyingProfileStatus(aPageCargo.getPreg_add_stat_ind(), aBeforeCargo.getPreg_add_stat_ind()));
			return;
		case PREG_CHG_IND:
			aPageCargo.setPreg_chg_ind(copyingProfileStatus(aPageCargo.getPreg_chg_ind(), aBeforeCargo.getPreg_chg_ind()));
			return;
		case IRWE_CHG_IND:
			aPageCargo.setIrwe_chg_ind(copyingProfileStatus(aPageCargo.getIrwe_chg_ind(), aBeforeCargo.getIrwe_chg_ind()));
			return;
		case EI_CHG_IND:
			aPageCargo.setEi_chg_ind(copyingProfileStatus(aPageCargo.getEi_chg_ind(), aBeforeCargo.getEi_chg_ind()));
			return;
		case SELF_EMPL_CHG_IND:
			aPageCargo.setSelf_empl_chg_ind(copyingProfileStatus(aPageCargo.getSelf_empl_chg_ind(), aBeforeCargo.getSelf_empl_chg_ind()));
			return;
		case OTHR_INCM_CHG_IND:
			aPageCargo.setOthr_incm_chg_ind(copyingProfileStatus(aPageCargo.getOthr_incm_chg_ind(), aBeforeCargo.getOthr_incm_chg_ind()));
			return;
		case EMPL_CHG_IND:
			aPageCargo.setEmpl_chg_ind(copyingProfileStatus(aPageCargo.getEmpl_chg_ind(), aBeforeCargo.getEmpl_chg_ind()));
			return;
		case VEH_ASET_ADD_IND:
			aPageCargo.setVeh_aset_add_ind(copyingProfileStatus(aPageCargo.getVeh_aset_add_ind(), aBeforeCargo.getVeh_aset_add_ind()));
			return;
		case VEH_ASET_CHG_IND:
			aPageCargo.setVeh_aset_chg_ind(copyingProfileStatus(aPageCargo.getVeh_aset_chg_ind(), aBeforeCargo.getVeh_aset_chg_ind()));
			return;
		case REAL_ASET_ADD_IND:
			aPageCargo.setReal_aset_add_ind(copyingProfileStatus(aPageCargo.getReal_aset_add_ind(), aBeforeCargo.getReal_aset_add_ind()));
			return;
		case REAL_ASET_CHG_IND:
			aPageCargo.setReal_aset_chg_ind(copyingProfileStatus(aPageCargo.getReal_aset_chg_ind(), aBeforeCargo.getReal_aset_chg_ind()));
			return;
		case BURY_ASET_ADD_IND:
			aPageCargo.setBury_aset_add_ind(copyingProfileStatus(aPageCargo.getBury_aset_add_ind(), aBeforeCargo.getBury_aset_add_ind()));
			return;
		case BURY_ASET_CHG_IND:
			aPageCargo.setBury_aset_chg_ind(copyingProfileStatus(aPageCargo.getBury_aset_chg_ind(), aBeforeCargo.getBury_aset_chg_ind()));
			return;
		case LIQUID_ASSET_ADD_IND:
			aPageCargo.setLiquid_asset_add_ind(copyingProfileStatus(aPageCargo.getLiquid_asset_add_ind(), aBeforeCargo.getLiquid_asset_add_ind()));
			return;
		case LIQUID_ASSET_BANK_ACC_CHG_IND:
			aPageCargo.setLiquid_asset_bank_acc_chg_ind(copyingProfileStatus(aPageCargo.getLiquid_asset_bank_acc_chg_ind(),
					aBeforeCargo.getLiquid_asset_bank_acc_chg_ind()));
			return;
		case LIQUID_ASSET_CASH_CHG_IND:
			aPageCargo.setLiquid_asset_cash_chg_ind(copyingProfileStatus(aPageCargo.getLiquid_asset_cash_chg_ind(),
					aBeforeCargo.getLiquid_asset_cash_chg_ind()));
			return;
		case LIQUID_ASSET_CHG_IND:
			aPageCargo.setLiquid_asset_chg_ind(copyingProfileStatus(aPageCargo.getLiquid_asset_chg_ind(), aBeforeCargo.getLiquid_asset_chg_ind()));
			return;
		case LIQUID_ASSET_OTHER_CHG_IND:
			aPageCargo.setLiquid_asset_other_chg_ind(copyingProfileStatus(aPageCargo.getLiquid_asset_other_chg_ind(),
					aBeforeCargo.getLiquid_asset_other_chg_ind()));
			return;
		case LIFE_INS_ASET_ADD_IND:
			aPageCargo.setLife_ins_aset_add_ind(copyingProfileStatus(aPageCargo.getLife_ins_aset_add_ind(), aBeforeCargo.getLife_ins_aset_add_ind()));
			return;
		case LIFE_INS_ASET_CHG_IND:
			aPageCargo.setLife_ins_aset_chg_ind(copyingProfileStatus(aPageCargo.getLife_ins_aset_chg_ind(), aBeforeCargo.getLife_ins_aset_chg_ind()));
			return;
		case ASET_XFER_CHG_IND:
			aPageCargo.setAset_xfer_chg_ind(copyingProfileStatus(aPageCargo.getAset_xfer_chg_ind(), aBeforeCargo.getAset_xfer_chg_ind()));
			return;
		case DPND_CARE_CHG_IND:
			aPageCargo.setDpnd_care_chg_ind(copyingProfileStatus(aPageCargo.getDpnd_care_chg_ind(), aBeforeCargo.getDpnd_care_chg_ind()));
			return;
		case HEALTH_INSURANCE_CHG_IND:
			aPageCargo.setHealth_insurance_chg_ind(copyingProfileStatus(aPageCargo.getHealth_insurance_chg_ind(),
					aBeforeCargo.getHealth_insurance_chg_ind()));
			return;
		case OUT_ST_BNFT_CHG_IND:
			aPageCargo.setOut_st_bnft_chg_ind(copyingProfileStatus(aPageCargo.getOut_st_bnft_chg_ind(), aBeforeCargo.getOut_st_bnft_chg_ind()));
			return;
		case SCHL_ENRL_CHG_IND:
			aPageCargo.setSchl_enrl_chg_ind(copyingProfileStatus(aPageCargo.getSchl_enrl_chg_ind(), aBeforeCargo.getSchl_enrl_chg_ind()));
			return;
		case MRTL_STAT_CHG_IND:
			aPageCargo.setMrtl_stat_chg_ind(copyingProfileStatus(aPageCargo.getMrtl_stat_chg_ind(), aBeforeCargo.getMrtl_stat_chg_ind()));
			return;
		case NUR_HME_CHG_IND:
			aPageCargo.setNur_hme_chg_ind(copyingProfileStatus(aPageCargo.getNur_hme_chg_ind(), aBeforeCargo.getNur_hme_chg_ind()));
			return;
		case BFR_TAX_CHG_IND:
			aPageCargo.setBfr_tax_chg_ind(copyingProfileStatus(aPageCargo.getBfr_tax_chg_ind(), aBeforeCargo.getBfr_tax_chg_ind()));
			return;
		case INC_TAX_CHG_IND:
			aPageCargo.setInc_tax_chg_ind(copyingProfileStatus(aPageCargo.getInc_tax_chg_ind(), aBeforeCargo.getInc_tax_chg_ind()));
			return;
		case THRD_PRTY_CHG_IND:
			aPageCargo.setThrd_prty_chg_ind(copyingProfileStatus(aPageCargo.getThrd_prty_chg_ind(), aBeforeCargo.getThrd_prty_chg_ind()));
			return;
		case CHILD_SUPPORT_PAYMENT_CHG_IND:
			aPageCargo.setChild_support_payment_chg_ind(copyingProfileStatus(aPageCargo.getChild_support_payment_chg_ind(),
					aBeforeCargo.getChild_support_payment_chg_ind()));
			return;
		case SNAP_SHELTER_STANDARD_EXP_IND:
			aPageCargo.setSnap_shelter_standard_exp_ind(copyingProfileStatus(aPageCargo.getSnap_shelter_standard_exp_ind(),
					aBeforeCargo.getSnap_shelter_standard_exp_ind()));
			return;
		case HOUS_BILL_CHG_IND:
			aPageCargo.setHous_bill_chg_ind(copyingProfileStatus(aPageCargo.getHous_bill_chg_ind(), aBeforeCargo.getHous_bill_chg_ind()));
			return;
		case ADD_CHG_IND:
			aPageCargo.setAdd_chg_ind(copyingProfileStatus(aPageCargo.getAdd_chg_ind(), aBeforeCargo.getAdd_chg_ind()));
			return;
		case PERSON_MOVED_IN_STAT_IND:
			aPageCargo.setPerson_moved_in_stat_ind(copyingProfileStatus(aPageCargo.getPerson_moved_in_stat_ind(),
					aBeforeCargo.getPerson_moved_in_stat_ind()));
			return;
		case PERSON_MOVED_OUT_STAT_IND:
			aPageCargo.setPerson_moved_out_stat_ind(copyingProfileStatus(aPageCargo.getPerson_moved_out_stat_ind(),
					aBeforeCargo.getPerson_moved_out_stat_ind()));
			return;
		case HOSPICE_CHG_IND:
			aPageCargo.setHospice_chg_ind(copyingProfileStatus(aPageCargo.getHospice_chg_ind(), aBeforeCargo.getHospice_chg_ind()));
			return;
		case MEDICARE_CHG_IND:
			aPageCargo.setMedicare_chg_ind(copyingProfileStatus(aPageCargo.getMedicare_chg_ind(), aBeforeCargo.getMedicare_chg_ind()));
			return;
		case NCP_CHG_IND:
			aPageCargo.setNcp_chg_ind(copyingProfileStatus(aPageCargo.getNcp_chg_ind(), aBeforeCargo.getNcp_chg_ind()));
			return;
		case THIRD_PARTY_CHG_IND:
			aPageCargo.setThird_party_chg_ind(copyingProfileStatus(aPageCargo.getThird_party_chg_ind(), aBeforeCargo.getThird_party_chg_ind()));
			return;
		case HOSPITAL_ABD_CHG_IND:
			aPageCargo.setHospital_abd_chg_ind(copyingProfileStatus(aPageCargo.getHospital_abd_chg_ind(), aBeforeCargo.getHospital_abd_chg_ind()));
			return;
		case PUBLIC_LAW_ABD_CHG_IND:
			aPageCargo.setPublic_law_abd_chg_ind(copyingProfileStatus(aPageCargo.getPublic_law_abd_chg_ind(),
					aBeforeCargo.getPublic_law_abd_chg_ind()));
			return;
		case LIVING_ARGMT_CHG_IND:
			aPageCargo.setLiving_argmt_chg_ind(copyingProfileStatus(aPageCargo.getLiving_argmt_chg_ind(), aBeforeCargo.getLiving_argmt_chg_ind()));
			return;
		case OTHER_PROGRAM_CHG_IND:
			aPageCargo.setOther_program_chg_ind(copyingProfileStatus(aPageCargo.getOther_program_chg_ind(), aBeforeCargo.getOther_program_chg_ind()));
			return;
		case TAX_INFO_IND:
			aPageCargo.setTax_info_ind(copyingProfileStatus(aPageCargo.getTax_info_ind(), aBeforeCargo.getTax_info_ind()));
			return;
		case TAX_DEPENDENT_IND:
			aPageCargo.setTax_dep_outside_resp(copyingProfileStatus(aPageCargo.getTax_dep_outside_resp(), aBeforeCargo.getTax_dep_outside_resp()));
			return;
		case MAGI_EXPENSE_CHG_IND:
			aPageCargo.setMagi_expense_chg_ind(copyingProfileStatus(aPageCargo.getMagi_expense_chg_ind(), aBeforeCargo.getMagi_expense_chg_ind()));
			return;
			//adding new med type columns

		case MEDICARE_PART_A:
			aPageCargo.setMedicare_part_a(copyingProfileStatus(aPageCargo.getMedicare_part_a(), aBeforeCargo.getMedicare_part_a()));
			return;
		case MEDICARE_PART_B:
			aPageCargo.setMedicare_part_b(copyingProfileStatus(aPageCargo.getMedicare_part_b(), aBeforeCargo.getMedicare_part_b()));
			return;
		case MEDICARE_PART_C:
			aPageCargo.setMedicare_part_c(copyingProfileStatus(aPageCargo.getMedicare_part_c(), aBeforeCargo.getMedicare_part_c()));
			return;
		case MEDICARE_PART_D:
			aPageCargo.setMedicare_part_d(copyingProfileStatus(aPageCargo.getMedicare_part_d(), aBeforeCargo.getMedicare_part_d()));
			return;
		case CCSP_PROVIDER_PAYMENT:
			aPageCargo.setCssp_provider_payment(copyingProfileStatus(aPageCargo.getCssp_provider_payment(), aBeforeCargo.getCssp_provider_payment()));
			return;
		case ANIMALS_TO_ASSIST_DISABLED:
			aPageCargo.setAnimals_to_assist_disabled(copyingProfileStatus(aPageCargo.getAnimals_to_assist_disabled(),
					aBeforeCargo.getAnimals_to_assist_disabled()));
			return;
		case FUNERAL_DEATH_EXPENSE:
			aPageCargo.setFuneral_death_expense(copyingProfileStatus(aPageCargo.getFuneral_death_expense(), aBeforeCargo.getFuneral_death_expense()));
			return;
		case BLIND_WORK_EXPENSE:
			aPageCargo.setBlind_work_expense(copyingProfileStatus(aPageCargo.getBlind_work_expense(), aBeforeCargo.getBlind_work_expense()));
			return;

		case IMPAIRMENT_WORK_EXPENSE:
			aPageCargo.setImpairment_work_expense(copyingProfileStatus(aPageCargo.getImpairment_work_expense(),
					aBeforeCargo.getImpairment_work_expense()));
			return;
		case OTH_IND_GAMBL_PMNTS:
			aPageCargo.setOth_ind_gambl_pmnts(copyingProfileStatus(aPageCargo.getOth_ind_gambl_pmnts(), aBeforeCargo.getOth_ind_gambl_pmnts()));
			return;

		case BONDS:
			aPageCargo.setBonds(copyingProfileStatus(aPageCargo.getBonds(), aBeforeCargo.getBonds()));
			return;

		case DIVIDEND:
			aPageCargo.setDividend(copyingProfileStatus(aPageCargo.getDividend(), aBeforeCargo.getDividend()));
			return;

		case HEALTH_REIMBURSEMENT_ACCOUNT:
			aPageCargo.setHealth_reimbursement_account(copyingProfileStatus(aPageCargo.getHealth_reimbursement_account(),
					aBeforeCargo.getHealth_reimbursement_account()));
			return;

		case INDIVIDUAL_DEVELOPMENT_ACCOUNT:
			aPageCargo.setIndividual_development_account(copyingProfileStatus(aPageCargo.getIndividual_development_account(),
					aBeforeCargo.getIndividual_development_account()));
			return;

		case UNIFORM_GIFTS_TO_MINORS:
			aPageCargo.setUniform_gifts_to_minors(copyingProfileStatus(aPageCargo.getUniform_gifts_to_minors(),
					aBeforeCargo.getUniform_gifts_to_minors()));
			return;

		case INCOME_FROM_RESOURCE:
			aPageCargo.setIncome_from_resource(copyingProfileStatus(aPageCargo.getIncome_from_resource(), aBeforeCargo.getIncome_from_resource()));
			return;

		case INDIAN_GAMBLING_PAYMENTS:
			aPageCargo.setIndian_gambling_payments(copyingProfileStatus(aPageCargo.getIndian_gambling_payments(),
					aBeforeCargo.getIndian_gambling_payments()));
			return;

		case INHERITANCE_INCOME:
			aPageCargo.setInheritance_income(copyingProfileStatus(aPageCargo.getInheritance_income(), aBeforeCargo.getInheritance_income()));
			return;

		case INSUANCE_BENEFITS:
			aPageCargo.setInsuance_benefits(copyingProfileStatus(aPageCargo.getInsuance_benefits(), aBeforeCargo.getInsuance_benefits()));
			return;

		case LOAN_RECEIVED:
			aPageCargo.setLoan_received(copyingProfileStatus(aPageCargo.getLoan_received(), aBeforeCargo.getLoan_received()));
			return;

		case LOAN_REPAYMENT_INCOME:
			aPageCargo.setLoan_repayment_income(copyingProfileStatus(aPageCargo.getLoan_repayment_income(), aBeforeCargo.getLoan_repayment_income()));
			return;

		case MANAGED_INCOME:
			aPageCargo.setManaged_income(copyingProfileStatus(aPageCargo.getManaged_income(), aBeforeCargo.getManaged_income()));
			return;

		case MATCH_GRANT:
			aPageCargo.setMatch_grant(copyingProfileStatus(aPageCargo.getMatch_grant(), aBeforeCargo.getMatch_grant()));
			return;

		case MONTGOMERY_GI_BILL:
			aPageCargo.setMontgomery_gi_bill(copyingProfileStatus(aPageCargo.getMontgomery_gi_bill(), aBeforeCargo.getMontgomery_gi_bill()));
			return;

		case OUT_OF_STATE_PUBLIC:
			aPageCargo.setOut_of_state_public(copyingProfileStatus(aPageCargo.getOut_of_state_public(), aBeforeCargo.getOut_of_state_public()));
			return;

		case REFUNDS_FROM_DCH:
			aPageCargo.setRefunds_from_dch(copyingProfileStatus(aPageCargo.getRefunds_from_dch(), aBeforeCargo.getRefunds_from_dch()));
			return;

		case RESTITUTIONS_SETTLEMENTS:
			aPageCargo.setRestitutions_settlements(copyingProfileStatus(aPageCargo.getRestitutions_settlements(),
					aBeforeCargo.getRestitutions_settlements()));
			return;

		case SENIOR_COMPANION:
			aPageCargo.setSenior_companion(copyingProfileStatus(aPageCargo.getSenior_companion(), aBeforeCargo.getSenior_companion()));
			return;

		case SEVERANCE_PAY:
			aPageCargo.setSeverance_pay(copyingProfileStatus(aPageCargo.getSeverance_pay(), aBeforeCargo.getSeverance_pay()));
			return;

		case STRIKE_BENEFITS:
			aPageCargo.setStrike_benefits(copyingProfileStatus(aPageCargo.getStrike_benefits(), aBeforeCargo.getStrike_benefits()));
			return;

		case TRADE_READJUSTMENT:
			aPageCargo.setTrade_readjustment(copyingProfileStatus(aPageCargo.getTrade_readjustment(), aBeforeCargo.getTrade_readjustment()));
			return;

		case UNIFORM_RELOCATION:
			aPageCargo.setUniform_relocation(copyingProfileStatus(aPageCargo.getUniform_relocation(), aBeforeCargo.getUniform_relocation()));
			return;

		case UNION_FUNDS:
			aPageCargo.setUnion_funds(copyingProfileStatus(aPageCargo.getUnion_funds(), aBeforeCargo.getUnion_funds()));
			return;

		case VENDOR_EXCLUDED:
			aPageCargo.setVendor_excluded(copyingProfileStatus(aPageCargo.getVendor_excluded(), aBeforeCargo.getVendor_excluded()));
			return;

		case VICTIM_RESTITUTION:
			aPageCargo.setVictim_restitution(copyingProfileStatus(aPageCargo.getVictim_restitution(), aBeforeCargo.getVictim_restitution()));
			return;

		case VOLUNTEER_PAYMENT:
			aPageCargo.setVolunteer_payment(copyingProfileStatus(aPageCargo.getVolunteer_payment(), aBeforeCargo.getVolunteer_payment()));
			return;

		case VOLUNTEER_PAYMENT_TITLEI:
			aPageCargo.setVolunteer_payment_titlei(copyingProfileStatus(aPageCargo.getVolunteer_payment_titlei(),
					aBeforeCargo.getVolunteer_payment_titlei()));
			return;

		case WIA_TRAINING_AND_ALLOWANCE:
			aPageCargo.setWia_training_and_allowance(copyingProfileStatus(aPageCargo.getWia_training_and_allowance(),
					aBeforeCargo.getWia_training_and_allowance()));
			return;

		case INCLUDED_UNEARNED_INCOME:
			aPageCargo.setIncluded_unearned_income(copyingProfileStatus(aPageCargo.getIncluded_unearned_income(),
					aBeforeCargo.getIncluded_unearned_income()));
			return;

		case TANF_MAX_AU_ALLOTMENT:
			aPageCargo.setTanf_max_au_allotment(copyingProfileStatus(aPageCargo.getTanf_max_au_allotment(), aBeforeCargo.getTanf_max_au_allotment()));
			return;

		case TANF_MAX_GRG_ALLOTMENT:
			aPageCargo.setTanf_max_grg_allotment(copyingProfileStatus(aPageCargo.getTanf_max_grg_allotment(),
					aBeforeCargo.getTanf_max_grg_allotment()));
			return;

		case CHARITABLE_DONATION:
			aPageCargo.setCharitable_donation(copyingProfileStatus(aPageCargo.getCharitable_donation(), aBeforeCargo.getCharitable_donation()));
			return;

		case CHILD_NUTRITION_PAYMENTS:
			aPageCargo.setChild_nutrition_payments(copyingProfileStatus(aPageCargo.getChild_nutrition_payments(),
					aBeforeCargo.getChild_nutrition_payments()));
			return;

		case BLACK_LUNG_BENEFITS:
			aPageCargo.setBlack_lung_benefits(copyingProfileStatus(aPageCargo.getBlack_lung_benefits(), aBeforeCargo.getBlack_lung_benefits()));
			return;

		case CHILD_SUPPORT_COURT:
			aPageCargo.setChild_support_court(copyingProfileStatus(aPageCargo.getChild_support_court(), aBeforeCargo.getChild_support_court()));
			return;

		case CHILD_SUPPORT_GAP_PAYMENT:
			aPageCargo.setChild_support_gap_payment(copyingProfileStatus(aPageCargo.getChild_support_gap_payment(),
					aBeforeCargo.getChild_support_gap_payment()));
			return;

		case CIVIL_SERVICE:
			aPageCargo.setCivil_service(copyingProfileStatus(aPageCargo.getCivil_service(), aBeforeCargo.getCivil_service()));
			return;

		case DEFERRED_COMPENSATION_PLANS:
			aPageCargo.setDeferred_compensation_plans(copyingProfileStatus(aPageCargo.getDeferred_compensation_plans(),
					aBeforeCargo.getDeferred_compensation_plans()));
			return;

		case DISABILITY_INSURANCE:
			aPageCargo.setDisability_insurance(copyingProfileStatus(aPageCargo.getDisability_insurance(), aBeforeCargo.getDisability_insurance()));
			return;

		case EXCLUDED_UNEARNED_INCOME:
			aPageCargo.setExcluded_unearned_income(copyingProfileStatus(aPageCargo.getExcluded_unearned_income(),
					aBeforeCargo.getExcluded_unearned_income()));
			return;

		case FEMA_PAYMENT_DISASTER:
			aPageCargo.setFema_payment_disaster(copyingProfileStatus(aPageCargo.getFema_payment_disaster(), aBeforeCargo.getFema_payment_disaster()));
			return;

		case FEMA_PAYMENT_NON_DISASTER:
			aPageCargo.setFema_payment_non_disaster(copyingProfileStatus(aPageCargo.getFema_payment_non_disaster(),
					aBeforeCargo.getFema_payment_non_disaster()));
			return;

		case HEALTH_SAVINGS_ACCOUNT:
			aPageCargo.setHealth_savings_account(copyingProfileStatus(aPageCargo.getHealth_savings_account(),
					aBeforeCargo.getHealth_savings_account()));
			return;

		case IN_KIND_SUPPORT:
			aPageCargo.setIn_kind_support(copyingProfileStatus(aPageCargo.getIn_kind_support(), aBeforeCargo.getIn_kind_support()));
			return;

		case FOSTER_GRANDPARENT_PROGRAM:
			aPageCargo.setFoster_grandparent_program(copyingProfileStatus(aPageCargo.getFoster_grandparent_program(),
					aBeforeCargo.getFoster_grandparent_program()));
			return;

		case DISASTER_UNEMPLOYMENT:
			aPageCargo.setDisaster_unemployment(copyingProfileStatus(aPageCargo.getDisaster_unemployment(), aBeforeCargo.getDisaster_unemployment()));
			return;

		case DIVIDENDS:
			aPageCargo.setDividends(copyingProfileStatus(aPageCargo.getDividends(), aBeforeCargo.getDividends()));
			return;

		case CHARITABLE_DONATION_FEDERAL:
			aPageCargo.setCharitable_donation_federal(copyingProfileStatus(aPageCargo.getCharitable_donation_federal(),
					aBeforeCargo.getCharitable_donation_federal()));
			return;
		case PERSONAL_INFO:
			aPageCargo.setPersonal_info(copyingProfileStatus(aPageCargo.getPersonal_info(), aBeforeCargo.getPersonal_info()));
			return;
		case PATIENT_FUND:
			aPageCargo.setPatient_fund(copyingProfileStatus(aPageCargo.getPatient_fund(), aBeforeCargo.getPatient_fund()));
			return;

		case DISASTER_ASSISTANCE:
			aPageCargo.setDisaster_assistance(copyingProfileStatus(aPageCargo.getDisaster_assistance(), aBeforeCargo.getDisaster_assistance()));
			return;
		case NON_BUSINESS_EQUIPMENT:
			aPageCargo.setNon_business_equipment(copyingProfileStatus(aPageCargo.getNon_business_equipment(),
					aBeforeCargo.getNon_business_equipment()));
			return;
		case HOUSEHOLD_GOODS:
			aPageCargo.setHousehold_goods(copyingProfileStatus(aPageCargo.getHousehold_goods(), aBeforeCargo.getHousehold_goods()));
			return;
		case OTHER_NON_COUNTABLE:
			aPageCargo.setOther_non_countable(copyingProfileStatus(aPageCargo.getOther_non_countable(), aBeforeCargo.getOther_non_countable()));
			return;
		case LIQ_ASET_CHECKING_ACCOUNT:
			aPageCargo.setLqd_aset_c_a_resp(copyingProfileStatus(aPageCargo.getLqd_aset_c_a_resp(), aBeforeCargo.getLqd_aset_c_a_resp()));
			return;
		case LIQ_ASET_KEOUGH_PLAN:
			aPageCargo.setLqd_aset_k_p_resp(copyingProfileStatus(aPageCargo.getLqd_aset_k_p_resp(), aBeforeCargo.getLqd_aset_k_p_resp()));
			return;
		case DEATH_BENEFIT_STATE_FEDERAL:
			aPageCargo.setDeath_benefit_state_federal(copyingProfileStatus(aPageCargo.getDeath_benefit_state_federal(),
					aBeforeCargo.getDeath_benefit_state_federal()));
			return;
		case SOCIAL_SECURITY_SURVIVOR:
			aPageCargo.setSocial_security_survivor(copyingProfileStatus(aPageCargo.getSocial_security_survivor(),
					aBeforeCargo.getSocial_security_survivor()));
			return;
		case VENDOR_PAYMENTS:
			aPageCargo.setVendor_payments(copyingProfileStatus(aPageCargo.getVendor_payments(), aBeforeCargo.getVendor_payments()));
			return;
		
		case INDV_PRGM_CHG_IND:
			aPageCargo.setIndv_prgm_chg_ind(copyingProfileStatus(aPageCargo.getIndv_prgm_chg_ind(), aBeforeCargo.getIndv_prgm_chg_ind()));
			return;
			
		case EMPL_HLTH_INS_RESP:
			aPageCargo.setEmpl_hlth_ins_resp(copyingProfileStatus(aPageCargo.getEmpl_hlth_ins_resp(), aBeforeCargo.getEmpl_hlth_ins_resp()));
			return;
			
		case KATIE_BECKETT:
			aPageCargo.setMed_type_katie_beckett(copyingProfileStatus(aPageCargo.getMed_type_katie_beckett(), aBeforeCargo.getMed_type_katie_beckett()));
			return;

		default:
			log(ILog.INFO, "RMCResponseProfileManager.copyingProfilesFromBeforeCollection() - Raising FwException manually on a condition");
			final FwException fe = new FwException("Incorrect field id : " + aFieldId + " passed.");
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("copyingProfilesFromBeforeCollection");
			fe.setExceptionType(FwConstants.EXP_TYP_APPLICATION);
			fe.setExceptionText("Incorrect field id : " + aFieldId + " passed.");
			throw fe;
		}
	}

	/**
	 * here i am setting the profilestatus
	 */
	private String copyingProfileStatus(final String aPageStatus, final String aBeforeStatus) {
		if ((null == aPageStatus) || (null == aBeforeStatus)) {
			return aPageStatus;
		}
		try {
			if ((aBeforeStatus.charAt(0) == STATUS_COMPLETE) || (aBeforeStatus.charAt(0) == STATUS_VISIT_AGAIN)
					|| (aBeforeStatus.charAt(0) == STATUS_ADD_NEW)) {
				return String.valueOf(RESPONSE_YES);
			} else {
				return aPageStatus;
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "copyingProfileStatus", e);
		}
	}

	/**
	 * set the default value ('N') to the cargo fields.
	 */
	private void setDefaultValues(final RMC_IN_PRFL_Cargo aRMCInPrflCargo) {
		// all RMC_IN_prfl cargo attributes are populate here except
		// indv_fma_rqst, indv_fpw_rqst, indv_fs_rqst
		// this is because they are setting in the save household member details
		// method/page
		aRMCInPrflCargo.setAcdt_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setAdpt_asst_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setAlmy_rcv_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setBnft_anty_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setBnft_chrt_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setBnft_dabl_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setBnft_divnd_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setBnft_est_trst_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setBnft_rr_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setBnft_uempl_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setBnft_vet_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setChld_sprt_pay_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setDabl_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setDpnd_care_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setDrug_feln_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setFset_sctn_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setFstr_care_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setGen_rlf_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setHc_cvrg_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setHospice_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setOutstate_bnft_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSpecial_need_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMoved_out_of_home_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setPrsn_info_stat_sw(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setCitizenship_info(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setRlt_chg_stat_sw(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setFoster_care_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setFormer_foster_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setChild_protective_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLiving_prog_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setGrand_parent_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setDrug_felonies_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSnap_tanf_disc_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setAvoid_prosc_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setAvd_prsctn_fstf(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setViolating_parole_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setConvic_false_info_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setVoluntarily_quit_job_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setTrading_snap_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setBuy_sell_snap_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setTrade_snap_gun_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setPrev_ssi_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setHome_community_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setTribal_health_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setTribal_eligibility_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setDomestic_violence_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setTanf_eppic_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setEmergency_medical_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setIncm_int_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setIrwe_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setKinship_care_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMed_exp_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMil_allot_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMony_othr_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setNatl_rfge_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setNeed_ind_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setOn_strk_sw(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setOp_aoda_tmt_rcv_sw(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setOthr_incm_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setOthr_src_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setOwn_aset_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setPay_hous_bill_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setPreg_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setJob_iknd_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setPay_rmr_brd_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setPnsn_retr_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setProp_sold_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setRcv_fs_oth_st_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setRcv_hous_asst_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setRcv_medcr_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setRcv_ss_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setRcv_ssi_ltr_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setRcv_ssi_sw(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSelf_empl_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSsi_dcond_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSsi_1619b_rcv_sw(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSu_ases_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSu_cst_coal_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSu_cst_elec_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSu_cst_fuel_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSu_cst_gas_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSu_cst_home_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSu_cst_istl_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSu_cst_lpgas_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSu_cst_mbl_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSu_cst_mtge_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSu_cst_othr_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSu_cst_phn_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSu_cst_swr_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSu_cst_tax_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSu_cst_trsh_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSu_cst_wood_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSu_cst_wtr_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSu_cst_wwt_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setTrb_tanf_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setUtil_exp_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setWork_comp_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setTrb_cpta_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setEduc_aid_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setRmr_brd_incm_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setWheap_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setEmpl_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setBnft_chl_sprt_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setOther_incm_contrib_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setOthr_incm_trbl_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setPub_asst_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setYehoc_resp(DEFAULT_RMC_IN_PRFL_SW);
		// PCR 35980 - past_hc_cvrg_resp
		aRMCInPrflCargo.setPast_hc_cvrg_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setBnft_mapp_resp(DEFAULT_RMC_IN_PRFL_SW);
		// PCR# 40362 - NEW RESPONSES FOR RMB/SMRF - STARTS
		aRMCInPrflCargo.setBury_aset_c_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setBury_aset_rbt_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setBury_aset_ins_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setBury_aset_mas_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setBury_aset_oth_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setBury_aset_plt_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setBury_aset_v_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLi_aset_g_l_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLi_aset_g_t_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLi_aset_trm_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLi_aset_unv_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLi_aset_w_l_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLqd_aset_c_a_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLiquid_asset_cash_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLqd_aset_eb_a_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLqd_aset_h_s_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLqd_aset_ira_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLqd_aset_k_p_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLqd_aset_m_o_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLqd_aset_mm_a_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLqd_aset_o_t_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLqd_aset_othr_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLqd_aset_s_a_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLqd_aset_s_c_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLqd_aset_st_b_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLqd_aset_tr_f_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLqd_aset_us_b_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setOther_asset_burial_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setOther_aset_life_insurance_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setOther_asset_personal_prop_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setOther_asset_real_property_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setOther_asset_vehicle_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setOther_asset_transfer_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setReal_aset_apt_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setReal_asset_rental_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setReal_aset_vac_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setReal_aset_com_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setReal_aset_con_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setReal_aset_dup_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setReal_aset_frm_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setReal_aset_hse_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setReal_aset_lnd_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setReal_aset_m_h_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setReal_aset_oth_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setVeh_aset_arpl_resp(DEFAULT_RMC_IN_PRFL_SW);

		aRMCInPrflCargo.setVehicle_asset_golf_cart_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setVehicle_asset_nmot_camper_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setVehicle_asset_auto_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setVehicle_asset_boat_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setVeh_aset_unlic_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setVehicle_asset_animal_drwn_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setVehicle_asset_camper_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setVeh_aset_fimp_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setVeh_aset_fmeq_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setVeh_aset_ftrc_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setVeh_aset_ftrl_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setVeh_aset_lskd_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setVehicle_asset_motorcycle_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setVeh_aset_mped_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setVeh_aset_nm_b_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setVeh_aset_trk_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setVeh_aset_othr_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setVehicle_asset_recreation_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setVeh_aset_s_mb_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setVehicle_asset_tractor_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setVeh_aset_trlr_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setVeh_aset_van_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setTrb_cmdy_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setCp_wlst_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setRoom_board_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setParole_violation_resp(DEFAULT_RMC_IN_PRFL_SW);

		if (aRMCInPrflCargo.getIndv_fma_rqst_ind() == null) {
			aRMCInPrflCargo.setIndv_fma_rqst_ind("0");
		}
		if (aRMCInPrflCargo.getIndv_fs_rqst_ind() == null) {
			aRMCInPrflCargo.setIndv_fs_rqst_ind("0");
		}
		if (aRMCInPrflCargo.getIndv_fpw_rqst_ind() == null) {
			aRMCInPrflCargo.setIndv_fpw_rqst_ind("0");
		}
		if (aRMCInPrflCargo.getIndv_cla_ind() == null) {
			aRMCInPrflCargo.setIndv_cla_ind("0");
		}

		if (aRMCInPrflCargo.getIndv_wic_rqst_ind() == null) {
			aRMCInPrflCargo.setIndv_wic_rqst_ind("0");
		}
		if (aRMCInPrflCargo.getIndv_tanf_rqst_ind() == null) {
			aRMCInPrflCargo.setIndv_tanf_rqst_ind("0");
		}
		if (aRMCInPrflCargo.getIndv_cc_rqst_ind() == null) {
			aRMCInPrflCargo.setIndv_cc_rqst_ind("0");
		}

		aRMCInPrflCargo.setLiquid_aset_disable_blind_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLiquid_asset_bank_acc_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLiquid_asset_ira_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLiquid_asset_irs_retirmnt_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLiquid_asset_other_response(DEFAULT_RMC_IN_PRFL_SW);

		aRMCInPrflCargo.setLiquid_asset_pension_plan_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLiquid_asset_other_type_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLiquid_asset_promissory_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLiquid_asset_retirement_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLiquid_asset_savings_acc_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLiquid_asset_stocks_bonds_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLiquid_asset_trust_fund_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setHead_of_household_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setHousing_bill_others_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSu_cst_home_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSu_cst_rent_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSu_cst_mbl_resp(DEFAULT_RMC_IN_PRFL_SW);
		// EDSP RMB Other income types
		aRMCInPrflCargo.setBenefit_black_lung_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setCash_gifts_resp(DEFAULT_RMC_IN_PRFL_SW);

		aRMCInPrflCargo.setFood_clothing_util_rent_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setInheritance_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setInsurance_settlement_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLoan_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLottery_prize_winning_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setOthr_social_security_bnft_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setStudent_financial_aid_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setTraining_allowance_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setBenefits_on_strike_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setResettl_inc_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setOthr_incm_rentl_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLand_cont_resp(DEFAULT_RMC_IN_PRFL_SW);
		// EDSP RMB added schoolenrollment resp
		aRMCInPrflCargo.setSchool_enrollment_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setUtility_bills_oil_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setWork_related_expense_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setHospital_stay_resp(DEFAULT_RMC_IN_PRFL_SW);

		// real property types

		aRMCInPrflCargo.setReal_asset_home_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setReal_asset_land_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setReal_asset_mobile_home_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setReal_asset_life_estate_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setReal_asset_house_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setReal_asset_other_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setReal_asset_unoccupy_home_resp(DEFAULT_RMC_IN_PRFL_SW);

		// EDSP RMB Other income types ends
		aRMCInPrflCargo.setLife_ins_asset_whole_life_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLife_insurance_asset_term_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLife_ins_asest_group_life_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLife_ins_asset_group_term_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLife_ins_asset_universal_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLife_insurance_other_resp(DEFAULT_RMC_IN_PRFL_SW);
		// medical types

		aRMCInPrflCargo.setMed_type_prosthetic_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMed_type_atndnt_meal_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMed_type_animal_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMed_type_maintain_attndnt_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMed_type_inhome_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMed_type_special_equip_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMed_type_eyeglasses_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMed_type_insurance_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMed_type_bills_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMed_type_supplies_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMed_type_nursing_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMed_type_out_patient_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMed_type_psychotherapy_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMed_type_prescribed_drug_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMed_type_transportation_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMed_type_other_resp(DEFAULT_RMC_IN_PRFL_SW);

		aRMCInPrflCargo.setUtility_standard_resp(DEFAULT_RMC_IN_PRFL_SW);
		// burial
		aRMCInPrflCargo.setUpdt_dt(String.valueOf(fwDate.getDate()));
		//Other Bills
		aRMCInPrflCargo.setChild_care_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setChild_obligation_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMedical_bills_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMedtyp_dental(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMedtyp_attendant_care(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMedtyp_doctor(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMedtyp_med_equip(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMedtyp_hosp_bills(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMedtyp_insur_premium(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMedtyp_rx_cost(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMedtyp_trans_med(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMedtyp_other(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setUnpaid_medbill(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMedtyp_hsa_contrib(DEFAULT_RMC_IN_PRFL_SW);

		aRMCInPrflCargo.setAdoptAssistance(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setAdoptionPayments(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setAgentOrangePayments(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setAlimony(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setCapitalGains(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setDeathBenefits(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setDisabilityIncome(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setDisasterRelief(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setEducationalAssistance(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setEnergyAssistance(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setFarmAllotment(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setFosterCarePayments(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setGeneralAssistance(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setInterestDividendPayments(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setiRADistribution(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLotteryWinnings(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLumpSum(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMilitaryAllotment(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMoneyFromAnotherPerson(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setNetRentalRoyalty(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setOtherIncome(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setPaymentsFromAnnuity(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setPaymentsMadeOnYourBehalf(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setPensionOrRetirement(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setRailroadRetirement(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setRefugeeCash(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setRelativeCareSubsidy(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setRentalIncome(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.settANFPayments(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setUnemploymentCompensation(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setWorkStudyStateFederal(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setWorkersCompensation(DEFAULT_RMC_IN_PRFL_SW);

		aRMCInPrflCargo.setPers_prop_bus_eqpt(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setPers_prop_cemetary_lot(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setPers_prop_livestock(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setPers_prop_saf_depst_box(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setPers_prop_oth_val(DEFAULT_RMC_IN_PRFL_SW);

		aRMCInPrflCargo.setAble_to_conceive_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setUnderweight_birth_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setPreg_add_stat_sw(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setPreg_chg_stat_sw(DEFAULT_RMC_IN_PRFL_SW);

		aRMCInPrflCargo.setSu_cst_ins_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setOther_housing_bill_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setDisaster_repair_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setPrevent_eviction_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setCareTaker_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLost_health_ins_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setTax_claim_dependant_resp(DEFAULT_RMC_IN_PRFL_SW);
		//NextGen  NG-6481 Phase 3 updates to ACA Streamline changes : Start
		aRMCInPrflCargo.setBefore_tax_deduction_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setBtd_med_ins(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setBtd_dent_ins(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setBtd_vis_care_ins(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setBtd_flex_acc(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setBtd_def_comp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setBtd_pre_tax_ins(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setBtd_other(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setTax_deduct_resp(DEFAULT_RMC_IN_PRFL_SW);
		//NextGen  NG-6481 Phase 3 updates to ACA Streamline changes : End
		aRMCInPrflCargo.setHlth_ins_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setOthr_hlth_ins_resp(DEFAULT_RMC_IN_PRFL_SW);
		//wp sync
		aRMCInPrflCargo.setTanfDiscResp(DEFAULT_RMC_IN_PRFL_SW);

		//add and change indicators
		aRMCInPrflCargo.setRoom_brd_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setDabl_stat_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setPreg_add_stat_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setPreg_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setIrwe_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setEi_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSelf_empl_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setOthr_incm_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setEmpl_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setVeh_aset_add_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setVeh_aset_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setReal_aset_add_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setReal_aset_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setBury_aset_add_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setBury_aset_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLiquid_asset_add_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLiquid_asset_bank_acc_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLiquid_asset_cash_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLiquid_asset_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLiquid_asset_other_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLife_ins_aset_add_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLife_ins_aset_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setAset_xfer_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setDpnd_care_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setHealth_insurance_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setOut_st_bnft_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSchl_enrl_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMrtl_stat_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setNur_hme_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setChild_support_payment_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSnap_shelter_standard_exp_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setHous_bill_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setAdd_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setPerson_moved_in_stat_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setPerson_moved_out_stat_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setHospice_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMedicare_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setNcp_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setThird_party_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setHospital_abd_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setPublic_law_abd_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLiving_argmt_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setOther_program_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMagi_expense_chg_ind(DEFAULT_RMC_IN_PRFL_SW);

		aRMCInPrflCargo.setMedicare_part_a(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMedicare_part_b(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMedicare_part_c(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMedicare_part_d(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setCssp_provider_payment(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setAnimals_to_assist_disabled(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setFuneral_death_expense(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setBlind_work_expense(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setImpairment_work_expense(DEFAULT_RMC_IN_PRFL_SW);

		aRMCInPrflCargo.setOth_ind_gambl_pmnts(DEFAULT_RMC_IN_PRFL_SW);

		aRMCInPrflCargo.setBonds(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setDividend(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setHealth_reimbursement_account(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setIndividual_development_account(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setUniform_gifts_to_minors(DEFAULT_RMC_IN_PRFL_SW);

		// Other Income Type Addition
		aRMCInPrflCargo.setIncome_from_resource(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setIndian_gambling_payments(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setInheritance_income(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setInsuance_benefits(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLoan_received(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setLoan_repayment_income(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setManaged_income(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMatch_grant(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMontgomery_gi_bill(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setOut_of_state_public(DEFAULT_RMC_IN_PRFL_SW);

		aRMCInPrflCargo.setRefunds_from_dch(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setRestitutions_settlements(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSenior_companion(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSeverance_pay(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setStrike_benefits(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setTrade_readjustment(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setUniform_relocation(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setUnion_funds(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setVendor_excluded(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setVictim_restitution(DEFAULT_RMC_IN_PRFL_SW);

		aRMCInPrflCargo.setVolunteer_payment(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setVolunteer_payment_titlei(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setWia_training_and_allowance(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setIncluded_unearned_income(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setTanf_max_au_allotment(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setTanf_max_grg_allotment(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setCharitable_donation(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setChild_nutrition_payments(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setBlack_lung_benefits(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setChild_support_court(DEFAULT_RMC_IN_PRFL_SW);

		aRMCInPrflCargo.setChild_support_gap_payment(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setCivil_service(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setDeferred_compensation_plans(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setDisability_insurance(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setExcluded_unearned_income(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setFema_payment_disaster(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setFema_payment_non_disaster(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setHealth_savings_account(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setIn_kind_support(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setFoster_grandparent_program(DEFAULT_RMC_IN_PRFL_SW);

		aRMCInPrflCargo.setDisaster_unemployment(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setDividends(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setCharitable_donation_federal(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setPersonal_info(DEFAULT_RMC_IN_PRFL_SW);

		aRMCInPrflCargo.setPatient_fund(DEFAULT_RMC_IN_PRFL_SW);

		aRMCInPrflCargo.setDisaster_assistance(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setNon_business_equipment(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setHousehold_goods(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setOther_non_countable(DEFAULT_RMC_IN_PRFL_SW);

		aRMCInPrflCargo.setDeath_benefit_state_federal(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setSocial_security_survivor(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setVendor_payments(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setIndv_prgm_chg_ind(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setEmpl_hlth_ins_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setOther_incm_contrib_resp(DEFAULT_RMC_IN_PRFL_SW);
		aRMCInPrflCargo.setMed_type_katie_beckett(DEFAULT_RMC_IN_PRFL_SW);
		
	}

	/**
	 * @see gov.state.nextgen.access.management.applications.IRMCResponseProfileManager#persist(java.lang.String,
	 *      java.lang.String, short[], java.lang.String[])
	 */
	@Override
	public void persist(final String aAppNum, final String aIndvSeqNum, final short[] responseIds, final String[] responseValues) {
		// if the two arrays length same then only it will persists the data
		if (responseIds.length == responseValues.length) {
			persistStatus(aAppNum, aIndvSeqNum, responseIds, responseValues);
		}
	}

	/**
	 * @see gov.state.nextgen.access.management.applications.IRMCResponseProfileManager#makeAbsoluteNotRequired(short,
	 *      gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Cargo,
	 *      boolean)
	 */
	@Override
	public void makeAbsoluteNotRequired(final short aResponseID, final RMC_IN_PRFL_Cargo aCargo, final boolean persist) {
		makeAbsoluteNotRequired(new short[] { aResponseID }, aCargo, persist);
	}

	/**
	 * @see gov.state.nextgen.access.management.applications.IRMCResponseProfileManager#makeAbsoluteNotRequired(short[],
	 *      gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Cargo,
	 *      boolean)
	 */
	@Override
	public void makeAbsoluteNotRequired(final short[] aResponseId, final RMC_IN_PRFL_Cargo aCargo, final boolean persist) {
		updateProfileStatusOfResponses(aResponseId, aCargo, persist, STATUS_ABSOLUTE_NOT_REQUIRED);
	}

	/**
	 * @see gov.state.nextgen.access.management.applications.IRMCResponseProfileManager#makeAddNew(short,
	 *      gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Cargo,
	 *      boolean)
	 */
	@Override
	public void makeAddNew(final short aResponseID, final RMC_IN_PRFL_Cargo aCargo, final boolean persist) {
		makeAddNew(new short[] { aResponseID }, aCargo, persist);
	}

	/**
	 * @see gov.state.nextgen.access.management.applications.IRMCResponseProfileManager#makeAddNew(short[],
	 *      gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Cargo,
	 *      boolean)
	 */
	@Override
	public void makeAddNew(final short[] aResponseId, final RMC_IN_PRFL_Cargo aCargo, final boolean persist) {
		updateProfileStatusOfResponses(aResponseId, aCargo, persist, STATUS_ADD_NEW);
	}

	/**
	 * @see gov.state.nextgen.access.management.applications.IRMCResponseProfileManager#makeComplete(short,
	 *      gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Cargo,
	 *      boolean)
	 */
	@Override
	public void makeComplete(final short aResponseID, final RMC_IN_PRFL_Cargo aCargo, final boolean persist) {
		makeComplete(new short[] { aResponseID }, aCargo, persist);
	}

	/**
	 * @see gov.state.nextgen.access.management.applications.IRMCResponseProfileManager#makeComplete(short[],
	 *      gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Cargo,
	 *      boolean)
	 */
	@Override
	public void makeComplete(final short[] aResponseId, final RMC_IN_PRFL_Cargo aCargo, final boolean persist) {
		updateProfileStatusOfResponses(aResponseId, aCargo, persist, STATUS_COMPLETE);
	}

	/**
	 * @see gov.state.nextgen.access.management.applications.IRMCResponseProfileManager#makeNotRequired(short,
	 *      gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Cargo,
	 *      boolean)
	 */
	@Override
	public void makeNotRequired(final short aResponseID, final RMC_IN_PRFL_Cargo aCargo, final boolean persist) {
		makeNotRequired(new short[] { aResponseID }, aCargo, persist);
	}

	/**
	 * @see gov.state.nextgen.access.management.applications.IRMCResponseProfileManager#makeNotRequired(short[],
	 *      gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Cargo,
	 *      boolean)
	 */
	@Override
	public void makeNotRequired(final short[] aResponseId, final RMC_IN_PRFL_Cargo aCargo, final boolean persist) {
		updateProfileStatusOfResponses(aResponseId, aCargo, persist, STATUS_NOT_REQUIRED);
	}

	/**
	 * @see gov.state.nextgen.access.management.applications.IRMCResponseProfileManager#makeRequired(short,
	 *      gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Cargo,
	 *      boolean)
	 */
	@Override
	public void makeRequired(final short aResponseID, final RMC_IN_PRFL_Cargo aCargo, final boolean persist) {
		makeRequired(new short[] { aResponseID }, aCargo, persist);
	}

	/**
	 * @see gov.state.nextgen.access.management.applications.IRMCResponseProfileManager#makeRequired(short[],
	 *      gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Cargo,
	 *      boolean)
	 */
	@Override
	public void makeRequired(final short[] aResponseId, final RMC_IN_PRFL_Cargo aCargo, final boolean persist) {
		updateProfileStatusOfResponses(aResponseId, aCargo, persist, STATUS_REQUIRED);
	}

	private void updateProfileStatusOfResponses(final short[] aResponseId, final RMC_IN_PRFL_Cargo aCargo, final boolean persist, final char status) {
		final int aResponseIdSize = aResponseId.length;
		final String[] programValues = new String[aResponseIdSize];
		for (int i = 0; i < aResponseIdSize; i++) {
			programValues[i] = updateAndGetProfileStatus(aCargo, aResponseId[i], status);
		}
		if (persist) {
			persistStatus(aCargo.getApp_num(), aCargo.getIndv_seq_num(), aResponseId, programValues);
		}
	}

	/**
	 * updates cargo with the new status and returns the new status
	 */
	private String updateAndGetProfileStatus(final RMC_IN_PRFL_Cargo aCargo, final short aFieldId, final char aMakeStatus) {

		switch (aFieldId) {
		case ACCIDENT:
			aCargo.setAcdt_resp(String.valueOf(getStatus(aCargo.getAcdt_resp(), aMakeStatus)));
			return aCargo.getAcdt_resp();
		case ADOPTION_ASSISTANCE:
			aCargo.setAdpt_asst_resp(String.valueOf(getStatus(aCargo.getAdpt_asst_resp(), aMakeStatus)));
			return aCargo.getAdpt_asst_resp();
		case ALIMONY_RECEIVED:
			aCargo.setAlmy_rcv_resp(String.valueOf(getStatus(aCargo.getAlmy_rcv_resp(), aMakeStatus)));
			return aCargo.getAlmy_rcv_resp();
		case BENEFIT_ANNUITIES:
			aCargo.setBnft_anty_resp(String.valueOf(getStatus(aCargo.getBnft_anty_resp(), aMakeStatus)));
			return aCargo.getBnft_anty_resp();
		case BENEFIT_CHARITY:
			aCargo.setBnft_chrt_resp(String.valueOf(getStatus(aCargo.getBnft_chrt_resp(), aMakeStatus)));
			return aCargo.getBnft_chrt_resp();
		case BENEFIT_DISABLE:
			aCargo.setBnft_dabl_resp(String.valueOf(getStatus(aCargo.getBnft_dabl_resp(), aMakeStatus)));
			return aCargo.getBnft_dabl_resp();
		case BENEFIT_DIVIDEND:
			aCargo.setBnft_divnd_resp(String.valueOf(getStatus(aCargo.getBnft_divnd_resp(), aMakeStatus)));
			return aCargo.getBnft_divnd_resp();
		case BENEFIT_TRUST:
			aCargo.setBnft_est_trst_resp(String.valueOf(getStatus(aCargo.getBnft_est_trst_resp(), aMakeStatus)));
			return aCargo.getBnft_est_trst_resp();
		case BENEFIT_RAILROAD_RETIREMENT:
			aCargo.setBnft_rr_resp(String.valueOf(getStatus(aCargo.getBnft_rr_resp(), aMakeStatus)));
			return aCargo.getBnft_rr_resp();
		case BENEFIT_UNEMPLOYMENT:
			aCargo.setBnft_uempl_resp(String.valueOf(getStatus(aCargo.getBnft_uempl_resp(), aMakeStatus)));
			return aCargo.getBnft_uempl_resp();
		case BENEFIT_VETERAN:
			aCargo.setBnft_vet_resp(String.valueOf(getStatus(aCargo.getBnft_vet_resp(), aMakeStatus)));
			return aCargo.getBnft_vet_resp();
		case CHILD_SUPPORT_PAYMENT:
			aCargo.setChld_sprt_pay_resp(String.valueOf(getStatus(aCargo.getChld_sprt_pay_resp(), aMakeStatus)));
			return aCargo.getChld_sprt_pay_resp();
		case DISABLE:
			aCargo.setDabl_resp(String.valueOf(getStatus(aCargo.getDabl_resp(), aMakeStatus)));
			return aCargo.getDabl_resp();
		case DEPENDENT_CARE:
			aCargo.setDpnd_care_resp(String.valueOf(getStatus(aCargo.getDpnd_care_resp(), aMakeStatus)));
			return aCargo.getDpnd_care_resp();
		case DRUG_FELON:
			aCargo.setDrug_feln_resp(String.valueOf(getStatus(aCargo.getDrug_feln_resp(), aMakeStatus)));
			return aCargo.getDrug_feln_resp();
		case FSET_SANCTION:
			aCargo.setFset_sctn_resp(String.valueOf(getStatus(aCargo.getFset_sctn_resp(), aMakeStatus)));
			return aCargo.getFset_sctn_resp();
		case FOSTER_CARE:
			aCargo.setFstr_care_resp(String.valueOf(getStatus(aCargo.getFstr_care_resp(), aMakeStatus)));
			return aCargo.getFstr_care_resp();
		case GENERAL_RELIEF:
			aCargo.setGen_rlf_resp(String.valueOf(getStatus(aCargo.getGen_rlf_resp(), aMakeStatus)));
			return aCargo.getGen_rlf_resp();
		case HEALTHCARE_COVERAGE:
			aCargo.setHc_cvrg_resp(String.valueOf(getStatus(aCargo.getHc_cvrg_resp(), aMakeStatus)));
			return aCargo.getHc_cvrg_resp();
		case HOUS_PICE:
			aCargo.setHospice_resp(String.valueOf(getStatus(aCargo.getHospice_resp(), aMakeStatus)));
			return aCargo.getHospice_resp();
		case OUTSTATE_BNFTS:
			aCargo.setOutstate_bnft_resp(String.valueOf(getStatus(aCargo.getOutstate_bnft_resp(), aMakeStatus)));
			return aCargo.getOutstate_bnft_resp();
		case SPECIAL_NEED:
			aCargo.setSpecial_need_resp(String.valueOf(getStatus(aCargo.getSpecial_need_resp(), aMakeStatus)));
			return aCargo.getSpecial_need_resp();
		case FOSTER_CARE_RESP:
			aCargo.setFoster_care_resp(String.valueOf(getStatus(aCargo.getFoster_care_resp(), aMakeStatus)));
			return aCargo.getFoster_care_resp();
		case FORMER_FOSTER_RESP:
			aCargo.setFormer_foster_resp(String.valueOf(getStatus(aCargo.getFormer_foster_resp(), aMakeStatus)));
			return aCargo.getFormer_foster_resp();
		case CHILD_PROTECTIVE_RESP:
			aCargo.setChild_protective_resp(String.valueOf(getStatus(aCargo.getChild_protective_resp(), aMakeStatus)));
			return aCargo.getChild_protective_resp();
		case LIVING_PROG_RESP:
			aCargo.setLiving_prog_resp(String.valueOf(getStatus(aCargo.getLiving_prog_resp(), aMakeStatus)));
			return aCargo.getLiving_prog_resp();
		case GRAND_PARENT_RESP:
			aCargo.setGrand_parent_resp(String.valueOf(getStatus(aCargo.getGrand_parent_resp(), aMakeStatus)));
			return aCargo.getGrand_parent_resp();
		case DRUG_FELONIES_RESP:
			aCargo.setDrug_felonies_resp(String.valueOf(getStatus(aCargo.getDrug_felonies_resp(), aMakeStatus)));
			return aCargo.getDrug_felonies_resp();
		case SNAP_TANF_DISC_RESP:
			aCargo.setSnap_tanf_disc_resp(String.valueOf(getStatus(aCargo.getSnap_tanf_disc_resp(), aMakeStatus)));
			return aCargo.getSnap_tanf_disc_resp();
		case TANF_DISC_RESP:
			aCargo.setTanfDiscResp(String.valueOf(getStatus(aCargo.getTanfDiscResp(), aMakeStatus)));
			return aCargo.getTanfDiscResp();

		case AVOID_PROSC_RESP:
			aCargo.setAvoid_prosc_resp(String.valueOf(getStatus(aCargo.getAvoid_prosc_resp(), aMakeStatus)));
			return aCargo.getAvoid_prosc_resp();
		case AVD_PRSCTN_FSTF:
			aCargo.setAvd_prsctn_fstf(String.valueOf(getStatus(aCargo.getAvd_prsctn_fstf(), aMakeStatus)));
			return aCargo.getAvd_prsctn_fstf();
		case VIOLATING_PAROLE_RESP:
			aCargo.setViolating_parole_resp(String.valueOf(getStatus(aCargo.getViolating_parole_resp(), aMakeStatus)));
			return aCargo.getViolating_parole_resp();
		case CONVIC_FALSE_INFO_RESP:
			aCargo.setConvic_false_info_resp(String.valueOf(getStatus(aCargo.getConvic_false_info_resp(), aMakeStatus)));
			return aCargo.getConvic_false_info_resp();
		case VOLUNTARILY_QUIT_JOB_RESP:
			aCargo.setVoluntarily_quit_job_resp(String.valueOf(getStatus(aCargo.getVoluntarily_quit_job_resp(), aMakeStatus)));
			return aCargo.getVoluntarily_quit_job_resp();
		case TRADING_SNAP_RESP:
			aCargo.setTrading_snap_resp(String.valueOf(getStatus(aCargo.getTrading_snap_resp(), aMakeStatus)));
			return aCargo.getTrading_snap_resp();
		case BUY_SELL_SNAP_RESP:
			aCargo.setBuy_sell_snap_resp(String.valueOf(getStatus(aCargo.getBuy_sell_snap_resp(), aMakeStatus)));
			return aCargo.getBuy_sell_snap_resp();
		case TRADE_SNAP_GUN_RESP:
			aCargo.setTrade_snap_gun_resp(String.valueOf(getStatus(aCargo.getTrade_snap_gun_resp(), aMakeStatus)));
			return aCargo.getTrade_snap_gun_resp();
		case PREV_SSI_RESP:
			aCargo.setPrev_ssi_resp(String.valueOf(getStatus(aCargo.getPrev_ssi_resp(), aMakeStatus)));
			return aCargo.getPrev_ssi_resp();
		case HOME_COMMUNITY_RESP:
			aCargo.setHome_community_resp(String.valueOf(getStatus(aCargo.getHome_community_resp(), aMakeStatus)));
			return aCargo.getHome_community_resp();
		case TRIBAL_HEALTH_RESP:
			aCargo.setTribal_health_resp(String.valueOf(getStatus(aCargo.getTribal_health_resp(), aMakeStatus)));
			return aCargo.getTribal_health_resp();
		case TRIBAL_ELIGIBILITY_RESP:
			aCargo.setTribal_eligibility_resp(String.valueOf(getStatus(aCargo.getTribal_eligibility_resp(), aMakeStatus)));
			return aCargo.getTribal_eligibility_resp();
		case DOMESTIC_VIOLENCE_RESP:
			aCargo.setDomestic_violence_resp(String.valueOf(getStatus(aCargo.getDomestic_violence_resp(), aMakeStatus)));
			return aCargo.getDomestic_violence_resp();
		case TANF_EPPIC_RESP:
			aCargo.setTanf_eppic_resp(String.valueOf(getStatus(aCargo.getTanf_eppic_resp(), aMakeStatus)));
			return aCargo.getTanf_eppic_resp();
		case EMERGENCY_MEDICAL_RESP:
			aCargo.setEmergency_medical_resp(String.valueOf(getStatus(aCargo.getEmergency_medical_resp(), aMakeStatus)));
			return aCargo.getEmergency_medical_resp();
		case INCOME_INTEREST:
			aCargo.setIncm_int_resp(String.valueOf(getStatus(aCargo.getIncm_int_resp(), aMakeStatus)));
			return aCargo.getIncm_int_resp();
		case INDIVIDUAL_FAMILY_MEDICAID:
			aCargo.setIndv_fma_rqst_ind(String.valueOf(getStatus(aCargo.getIndv_fma_rqst_ind(), aMakeStatus)));
			return aCargo.getIndv_fma_rqst_ind();
		case INDIVIDUAL_FPW:
			aCargo.setIndv_fpw_rqst_ind(String.valueOf(getStatus(aCargo.getIndv_fpw_rqst_ind(), aMakeStatus)));
			return aCargo.getIndv_fpw_rqst_ind();
		case INDIVIDUAL_FOODSHARE:
			aCargo.setIndv_fs_rqst_ind(String.valueOf(getStatus(aCargo.getIndv_fs_rqst_ind(), aMakeStatus)));
			return aCargo.getIndv_fs_rqst_ind();
		case IREW:
			aCargo.setIrwe_resp(String.valueOf(getStatus(aCargo.getIrwe_resp(), aMakeStatus)));
			return aCargo.getIrwe_resp();
		case KINSHIP_CARE:
			aCargo.setKinship_care_resp(String.valueOf(getStatus(aCargo.getKinship_care_resp(), aMakeStatus)));
			return aCargo.getKinship_care_resp();
		case MEDICAL_EXPENSE:
			aCargo.setMed_exp_resp(String.valueOf(getStatus(aCargo.getMed_exp_resp(), aMakeStatus)));
			return aCargo.getMed_exp_resp();
		case MILITARY_ALLOTMENT:
			aCargo.setMil_allot_resp(String.valueOf(getStatus(aCargo.getMil_allot_resp(), aMakeStatus)));
			return aCargo.getMil_allot_resp();
		case MONEY_FROM_ANOTHER_PERSON:
			aCargo.setMony_othr_resp(String.valueOf(getStatus(aCargo.getMony_othr_resp(), aMakeStatus)));
			return aCargo.getMony_othr_resp();
		case REFUGE:
			aCargo.setNatl_rfge_resp(String.valueOf(getStatus(aCargo.getNatl_rfge_resp(), aMakeStatus)));
			return aCargo.getNatl_rfge_resp();
		case NEEDY_INDIAN:
			aCargo.setNeed_ind_resp(String.valueOf(getStatus(aCargo.getNeed_ind_resp(), aMakeStatus)));
			return aCargo.getNeed_ind_resp();
		case ON_STRIKE:
			aCargo.setOn_strk_sw(String.valueOf(getStatus(aCargo.getOn_strk_sw(), aMakeStatus)));
			return aCargo.getOn_strk_sw();
		case OTHER_PENSION:
			aCargo.setOp_aoda_tmt_rcv_sw(String.valueOf(getStatus(aCargo.getOp_aoda_tmt_rcv_sw(), aMakeStatus)));
			return aCargo.getOp_aoda_tmt_rcv_sw();
		case OTHER_INCOME:
			aCargo.setOthr_incm_resp(String.valueOf(getStatus(aCargo.getOthr_incm_resp(), aMakeStatus)));
			return aCargo.getOthr_incm_resp();
		case OTHER_SOURCE:
			aCargo.setOthr_src_resp(String.valueOf(getStatus(aCargo.getOthr_src_resp(), aMakeStatus)));
			return aCargo.getOthr_src_resp();
		case OWNER_ASSET:
			aCargo.setOwn_aset_resp(String.valueOf(getStatus(aCargo.getOwn_aset_resp(), aMakeStatus)));
			return aCargo.getOwn_aset_resp();
		case PAY_HOUSING_BILL:
			aCargo.setPay_hous_bill_resp(String.valueOf(getStatus(aCargo.getPay_hous_bill_resp(), aMakeStatus)));
			return aCargo.getPay_hous_bill_resp();
		case PREGNANCY:
			aCargo.setPreg_resp(String.valueOf(getStatus(aCargo.getPreg_resp(), aMakeStatus)));
			return aCargo.getPreg_resp();
		case JOB_IN_KIND:
			aCargo.setJob_iknd_resp(String.valueOf(getStatus(aCargo.getJob_iknd_resp(), aMakeStatus)));
			return aCargo.getJob_iknd_resp();
		case PAY_ROOM_AND_BOARD:
			aCargo.setPay_rmr_brd_resp(String.valueOf(getStatus(aCargo.getPay_rmr_brd_resp(), aMakeStatus)));
			return aCargo.getPay_rmr_brd_resp();
		case PENSION_RETIREMENT:
			aCargo.setPnsn_retr_resp(String.valueOf(getStatus(aCargo.getPnsn_retr_resp(), aMakeStatus)));
			return aCargo.getPnsn_retr_resp();
		case PROPERTY_SOLD:
			aCargo.setProp_sold_resp(String.valueOf(getStatus(aCargo.getProp_sold_resp(), aMakeStatus)));
			return aCargo.getProp_sold_resp();
		case RECEIVE_FS_IN_OTHER_STATE:
			aCargo.setRcv_fs_oth_st_resp(String.valueOf(getStatus(aCargo.getRcv_fs_oth_st_resp(), aMakeStatus)));
			return aCargo.getRcv_fs_oth_st_resp();
		case RECEIVE_HOUSING_ASSET:
			aCargo.setRcv_hous_asst_resp(String.valueOf(getStatus(aCargo.getRcv_hous_asst_resp(), aMakeStatus)));
			return aCargo.getRcv_hous_asst_resp();
		case RECEIVE_MEDICARE:
			aCargo.setRcv_medcr_resp(String.valueOf(getStatus(aCargo.getRcv_medcr_resp(), aMakeStatus)));
			return aCargo.getRcv_medcr_resp();
		case RECEIVE_SOCIAL_SECURITY:
			aCargo.setRcv_ss_resp(String.valueOf(getStatus(aCargo.getRcv_ss_resp(), aMakeStatus)));
			return aCargo.getRcv_ss_resp();
		case RECEIVE_SSI_LETTER:
			aCargo.setRcv_ssi_ltr_resp(String.valueOf(getStatus(aCargo.getRcv_ssi_ltr_resp(), aMakeStatus)));
			return aCargo.getRcv_ssi_ltr_resp();
		case RECEIVE_SSI:
			aCargo.setRcv_ssi_sw(String.valueOf(getStatus(aCargo.getRcv_ssi_sw(), aMakeStatus)));
			return aCargo.getRcv_ssi_sw();
		case ROOM_AND_BOARD:
			aCargo.setRmr_brd_incm_resp(String.valueOf(getStatus(aCargo.getRmr_brd_incm_resp(), aMakeStatus)));
			return aCargo.getRmr_brd_incm_resp();
		case SELF_EMPLOYMENT:
			aCargo.setSelf_empl_resp(String.valueOf(getStatus(aCargo.getSelf_empl_resp(), aMakeStatus)));
			return aCargo.getSelf_empl_resp();
		case RECEIVE_SSI_DCOND:
			aCargo.setSsi_dcond_resp(String.valueOf(getStatus(aCargo.getSsi_dcond_resp(), aMakeStatus)));
			return aCargo.getSsi_dcond_resp();
		case RECEIVE_SSI_1619B:
			aCargo.setSsi_1619b_rcv_sw(String.valueOf(getStatus(aCargo.getSsi_1619b_rcv_sw(), aMakeStatus)));
			return aCargo.getSsi_1619b_rcv_sw();
		case SHELTER_COST_ASSESSMENT:
			aCargo.setSu_ases_resp(String.valueOf(getStatus(aCargo.getSu_ases_resp(), aMakeStatus)));
			return aCargo.getSu_ases_resp();
		case SHELTER_COST_COAL:
			aCargo.setSu_cst_coal_resp(String.valueOf(getStatus(aCargo.getSu_cst_coal_resp(), aMakeStatus)));
			return aCargo.getSu_cst_coal_resp();
		case SHELTER_COST_ELECTRICTY:
			aCargo.setSu_cst_elec_resp(String.valueOf(getStatus(aCargo.getSu_cst_elec_resp(), aMakeStatus)));
			return aCargo.getSu_cst_elec_resp();
		case SHELTER_COST_FUEL:
			aCargo.setSu_cst_fuel_resp(String.valueOf(getStatus(aCargo.getSu_cst_fuel_resp(), aMakeStatus)));
			return aCargo.getSu_cst_fuel_resp();
		case SHELTER_COST_GAS:
			aCargo.setSu_cst_gas_resp(String.valueOf(getStatus(aCargo.getSu_cst_gas_resp(), aMakeStatus)));
			return aCargo.getSu_cst_gas_resp();
		case SHELTER_COST_HOME:
			aCargo.setSu_cst_home_resp(String.valueOf(getStatus(aCargo.getSu_cst_home_resp(), aMakeStatus)));
			return aCargo.getSu_cst_home_resp();
		case SHELTER_COST_INSTALL:
			aCargo.setSu_cst_istl_resp(String.valueOf(getStatus(aCargo.getSu_cst_istl_resp(), aMakeStatus)));
			return aCargo.getSu_cst_istl_resp();
		case SHELTER_COST_LPGAS:
			aCargo.setSu_cst_lpgas_resp(String.valueOf(getStatus(aCargo.getSu_cst_lpgas_resp(), aMakeStatus)));
			return aCargo.getSu_cst_lpgas_resp();
		case SHELTER_COST_MOBILE_HOME:
			aCargo.setSu_cst_mbl_resp(String.valueOf(getStatus(aCargo.getSu_cst_mbl_resp(), aMakeStatus)));
			return aCargo.getSu_cst_mbl_resp();
		case SHELTER_COST_MORTGAGE:
			aCargo.setSu_cst_mtge_resp(String.valueOf(getStatus(aCargo.getSu_cst_mtge_resp(), aMakeStatus)));
			return aCargo.getSu_cst_mtge_resp();
		case SHELTER_COST_OTHER:
			aCargo.setSu_cst_othr_resp(String.valueOf(getStatus(aCargo.getSu_cst_othr_resp(), aMakeStatus)));
			return aCargo.getSu_cst_othr_resp();
		case SHELTER_COST_PHONE:
			aCargo.setSu_cst_phn_resp(String.valueOf(getStatus(aCargo.getSu_cst_phn_resp(), aMakeStatus)));
			return aCargo.getSu_cst_phn_resp();
		case SHELTER_COST_RENT:
			aCargo.setSu_cst_rent_resp(String.valueOf(getStatus(aCargo.getSu_cst_rent_resp(), aMakeStatus)));
			return aCargo.getSu_cst_rent_resp();
		case SHELTER_COST_SEWER:
			aCargo.setSu_cst_swr_resp(String.valueOf(getStatus(aCargo.getSu_cst_swr_resp(), aMakeStatus)));
			return aCargo.getSu_cst_swr_resp();
		case SHELTER_COST_TAX:
			aCargo.setSu_cst_tax_resp(String.valueOf(getStatus(aCargo.getSu_cst_tax_resp(), aMakeStatus)));
			return aCargo.getSu_cst_tax_resp();
		case SHELTER_COST_TRASH:
			aCargo.setSu_cst_trsh_resp(String.valueOf(getStatus(aCargo.getSu_cst_trsh_resp(), aMakeStatus)));
			return aCargo.getSu_cst_trsh_resp();
		case SHELTER_COST_WOOD:
			aCargo.setSu_cst_wood_resp(String.valueOf(getStatus(aCargo.getSu_cst_wood_resp(), aMakeStatus)));
			return aCargo.getSu_cst_wood_resp();
		case SHELTER_COST_WATER:
			aCargo.setSu_cst_wtr_resp(String.valueOf(getStatus(aCargo.getSu_cst_wtr_resp(), aMakeStatus)));
			return aCargo.getSu_cst_wtr_resp();
		case SHELTER_COST_WASTE:
			aCargo.setSu_cst_wwt_resp(String.valueOf(getStatus(aCargo.getSu_cst_wwt_resp(), aMakeStatus)));
			return aCargo.getSu_cst_wwt_resp();
		case TRIBAL_TANF:
			aCargo.setTrb_tanf_resp(String.valueOf(getStatus(aCargo.getTrb_tanf_resp(), aMakeStatus)));
			return aCargo.getTrb_tanf_resp();
		case UTILITY_EXPENSE:
			aCargo.setUtil_exp_resp(String.valueOf(getStatus(aCargo.getUtil_exp_resp(), aMakeStatus)));
			return aCargo.getUtil_exp_resp();
		case WORKER_COMP:
			aCargo.setWork_comp_resp(String.valueOf(getStatus(aCargo.getWork_comp_resp(), aMakeStatus)));
			return aCargo.getWork_comp_resp();
		case TRIBAL_CAPITA:
			aCargo.setTrb_cpta_resp(String.valueOf(getStatus(aCargo.getTrb_cpta_resp(), aMakeStatus)));
			return aCargo.getTrb_cpta_resp();
		case EDUCATIONAL_AID:
			aCargo.setEduc_aid_resp(String.valueOf(getStatus(aCargo.getEduc_aid_resp(), aMakeStatus)));
			return aCargo.getEduc_aid_resp();
		case WHEAP:
			aCargo.setWheap_resp(String.valueOf(getStatus(aCargo.getWheap_resp(), aMakeStatus)));
			return aCargo.getWheap_resp();
		case REGULAR_EMPL:
			aCargo.setEmpl_resp(String.valueOf(getStatus(aCargo.getEmpl_resp(), aMakeStatus)));
			return aCargo.getEmpl_resp();
		case BNFT_CHL_SPRT_RESP:
			aCargo.setBnft_chl_sprt_resp(String.valueOf(getStatus(aCargo.getBnft_chl_sprt_resp(), aMakeStatus)));
			return aCargo.getBnft_chl_sprt_resp();
		case OTHR_INCM_CONTRIB_RESP:
			aCargo.setOther_incm_contrib_resp(String.valueOf(getStatus(aCargo.getOther_incm_contrib_resp(), aMakeStatus)));
			return aCargo.getOther_incm_contrib_resp();
		case OTHR_INCM_TRBL_RESP:
			aCargo.setOthr_incm_trbl_resp(String.valueOf(getStatus(aCargo.getOthr_incm_trbl_resp(), aMakeStatus)));
			return aCargo.getOthr_incm_trbl_resp();
		case PUB_ASST_RESP:
			aCargo.setPub_asst_resp(String.valueOf(getStatus(aCargo.getPub_asst_resp(), aMakeStatus)));
			return aCargo.getPub_asst_resp();
		case YEHOC_RESP:
			aCargo.setYehoc_resp(String.valueOf(getStatus(aCargo.getYehoc_resp(), aMakeStatus)));
			return aCargo.getYehoc_resp();
		case EMERGENCY_MEDICAL:
			aCargo.setEmergency_medical_service_resp(String.valueOf(getStatus(aCargo.getEmergency_medical_service_resp(), aMakeStatus)));
			return aCargo.getEmergency_medical_service_resp();
			// PCR 35980 - past_hc_cvrg_resp
		case PAST_HEALTHCARE_COVERAGE:
			aCargo.setPast_hc_cvrg_resp(String.valueOf(getStatus(aCargo.getPast_hc_cvrg_resp(), aMakeStatus)));
			return aCargo.getPast_hc_cvrg_resp();

			// PCR# 40362 - ADDED NEW RESPONSES FOR RMB AND SMRF CHANGES -
			// starts
		case MAPP_BENEFITS_RESP:
			aCargo.setBnft_mapp_resp(String.valueOf(getStatus(aCargo.getBnft_mapp_resp(), aMakeStatus)));
			return aCargo.getBnft_mapp_resp();

		case BUR_AST_CASKET:
			aCargo.setBury_aset_oth_resp(String.valueOf(getStatus(aCargo.getBury_aset_oth_resp(), aMakeStatus)));
			return aCargo.getBury_aset_oth_resp();

		case BUR_AST_IRREVOCABLE:
			aCargo.setBury_aset_rbt_resp(String.valueOf(getStatus(aCargo.getBury_aset_rbt_resp(), aMakeStatus)));
			return aCargo.getBury_aset_rbt_resp();

		case BUR_AST_INSURANCE:
			aCargo.setBury_aset_ins_resp(String.valueOf(getStatus(aCargo.getBury_aset_ins_resp(), aMakeStatus)));
			return aCargo.getBury_aset_ins_resp();

		case BUR_AST_MAUSOLEUM:
			aCargo.setBury_aset_mas_resp(String.valueOf(getStatus(aCargo.getBury_aset_mas_resp(), aMakeStatus)));
			return aCargo.getBury_aset_mas_resp();

		case BUR_AST_OTHER:
			aCargo.setBury_aset_oth_resp(String.valueOf(getStatus(aCargo.getBury_aset_oth_resp(), aMakeStatus)));
			return aCargo.getBury_aset_oth_resp();

		case BUR_AST_PLOT:
			aCargo.setBury_aset_plt_resp(String.valueOf(getStatus(aCargo.getBury_aset_plt_resp(), aMakeStatus)));
			return aCargo.getBury_aset_plt_resp();

		case BUR_AST_REVOCABLE:
			aCargo.setBury_aset_rbt_resp(String.valueOf(getStatus(aCargo.getBury_aset_rbt_resp(), aMakeStatus)));
			return aCargo.getBury_aset_rbt_resp();

		case BUR_AST_VAULT:
			aCargo.setBury_aset_v_resp(String.valueOf(getStatus(aCargo.getBury_aset_v_resp(), aMakeStatus)));
			return aCargo.getBury_aset_v_resp();

		case LIF_AST_GROUP_LIFE:
			aCargo.setLi_aset_g_l_resp(String.valueOf(getStatus(aCargo.getLi_aset_g_l_resp(), aMakeStatus)));
			return aCargo.getLi_aset_g_l_resp();

		case LIF_AST_GROUP_TERM:
			aCargo.setLi_aset_g_t_resp(String.valueOf(getStatus(aCargo.getLi_aset_g_t_resp(), aMakeStatus)));
			return aCargo.getLi_aset_g_t_resp();

		case LIF_AST_TERM:
			aCargo.setLi_aset_trm_resp(String.valueOf(getStatus(aCargo.getLi_aset_trm_resp(), aMakeStatus)));
			return aCargo.getLi_aset_trm_resp();

		case LIF_AST_UNIVERSAL:
			aCargo.setLi_aset_unv_resp(String.valueOf(getStatus(aCargo.getLi_aset_unv_resp(), aMakeStatus)));
			return aCargo.getLi_aset_unv_resp();

		case LIF_AST_WHOLE_LIFE:
			aCargo.setLi_aset_w_l_resp(String.valueOf(getStatus(aCargo.getLi_aset_w_l_resp(), aMakeStatus)));
			return aCargo.getLi_aset_w_l_resp();

		case LIQ_ASET_CASH:
			aCargo.setLiquid_asset_cash_resp(String.valueOf(getStatus(aCargo.getLiquid_asset_cash_resp(), aMakeStatus)));
			return aCargo.getLiquid_asset_cash_resp();
		case LIQUID_ASSET_XFER:
			aCargo.setLqd_aset_tr_f_resp(String.valueOf(getStatus(aCargo.getLqd_aset_tr_f_resp(), aMakeStatus)));
			return aCargo.getLqd_aset_tr_f_resp();

		case LIQUID_ASSET_ANNUITY:
			aCargo.setLiquid_aset_disable_blind_resp(String.valueOf(getStatus(aCargo.getLiquid_aset_disable_blind_resp(), aMakeStatus)));
			return aCargo.getLiquid_aset_disable_blind_resp();
		case LIQUID_ASSET_IRA:
			aCargo.setLiquid_asset_ira_resp(String.valueOf(getStatus(aCargo.getLiquid_asset_ira_resp(), aMakeStatus)));
			return aCargo.getLiquid_asset_ira_resp();
		case LIQUID_ASSET_IRS_RET:
			aCargo.setLiquid_asset_irs_retirmnt_resp(String.valueOf(getStatus(aCargo.getLiquid_asset_irs_retirmnt_resp(), aMakeStatus)));
			return aCargo.getLiquid_asset_irs_retirmnt_resp();
		case LIQUID_ASSET_SAVINGS_ACC:
			aCargo.setLiquid_asset_savings_acc_resp(String.valueOf(getStatus(aCargo.getLiquid_asset_savings_acc_resp(), aMakeStatus)));
			return aCargo.getLiquid_asset_savings_acc_resp();
		case LIQUID_ASSET_PENSION_PLAN:
			aCargo.setLiquid_asset_pension_plan_resp(String.valueOf(getStatus(aCargo.getLiquid_asset_pension_plan_resp(), aMakeStatus)));
			return aCargo.getLiquid_asset_pension_plan_resp();
		case LIQUID_ASSET_PROMISSORY:
			aCargo.setLiquid_asset_promissory_resp(String.valueOf(getStatus(aCargo.getLiquid_asset_promissory_resp(), aMakeStatus)));
			return aCargo.getLiquid_asset_promissory_resp();
		case LIQUID_ASSET_RETIREMENT:
			aCargo.setLiquid_asset_retirement_resp(String.valueOf(getStatus(aCargo.getLiquid_asset_retirement_resp(), aMakeStatus)));
			return aCargo.getLiquid_asset_retirement_resp();
		case LIQUID_ASSET_STOCK_BONDS:
			aCargo.setLiquid_asset_stocks_bonds_resp(String.valueOf(getStatus(aCargo.getLiquid_asset_stocks_bonds_resp(), aMakeStatus)));
			return aCargo.getLiquid_asset_stocks_bonds_resp();
		case LIQUID_ASSET_TRUST_FUND:
			aCargo.setLiquid_asset_trust_fund_resp(String.valueOf(getStatus(aCargo.getLiquid_asset_trust_fund_resp(), aMakeStatus)));
			return aCargo.getLiquid_asset_trust_fund_resp();
		case LIQUID_ASSET_OTHER:
			aCargo.setLiquid_asset_other_response(String.valueOf(getStatus(aCargo.getLiquid_asset_other_response(), aMakeStatus)));
			return aCargo.getLiquid_asset_other_response();
		case LIQUID_ASSET_OTHER_TYPE:
			aCargo.setLiquid_asset_other_type_resp(String.valueOf(getStatus(aCargo.getLiquid_asset_other_type_resp(), aMakeStatus)));
			return aCargo.getLiquid_asset_other_type_resp();

		case LIQ_ASET_HOME_SALE:
			aCargo.setLqd_aset_h_s_resp(String.valueOf(getStatus(aCargo.getLqd_aset_h_s_resp(), aMakeStatus)));
			return aCargo.getLqd_aset_h_s_resp();

		case LIQUID_ASET_BANK:
			aCargo.setLiquid_asset_bank_acc_resp(String.valueOf(getStatus(aCargo.getLiquid_asset_bank_acc_resp(), aMakeStatus)));
			return aCargo.getLiquid_asset_bank_acc_resp();

		case LIQ_ASET_US_BOND:
			aCargo.setLqd_aset_us_b_resp(String.valueOf(getStatus(aCargo.getLqd_aset_us_b_resp(), aMakeStatus)));
			return aCargo.getLqd_aset_us_b_resp();

		case OTHR_ASET_BURIAL:
			aCargo.setOther_asset_burial_resp(String.valueOf(getStatus(aCargo.getOther_asset_burial_resp(), aMakeStatus)));
			return aCargo.getOther_asset_burial_resp();

		case OTHR_ASET_LIFE_INSURANCE:
			aCargo.setOther_aset_life_insurance_resp(String.valueOf(getStatus(aCargo.getOther_aset_life_insurance_resp(), aMakeStatus)));
			return aCargo.getOther_aset_life_insurance_resp();

		case OTHR_ASET_PERSONAL_PROPERTY:
			aCargo.setOther_asset_personal_prop_resp(String.valueOf(getStatus(aCargo.getOther_asset_personal_prop_resp(), aMakeStatus)));
			return aCargo.getOther_asset_personal_prop_resp();

		case OTHR_ASET_REAL_PROPERTY:
			aCargo.setOther_asset_real_property_resp(String.valueOf(getStatus(aCargo.getOther_asset_real_property_resp(), aMakeStatus)));
			return aCargo.getOther_asset_real_property_resp();

		case OTHR_ASET_VEHICLE:
			aCargo.setOther_asset_vehicle_resp(String.valueOf(getStatus(aCargo.getOther_asset_vehicle_resp(), aMakeStatus)));
			return aCargo.getOther_asset_vehicle_resp();

		case OTHR_ASET_TRANSFER:
			aCargo.setOther_asset_transfer_resp(String.valueOf(getStatus(aCargo.getOther_asset_transfer_resp(), aMakeStatus)));
			return aCargo.getOther_asset_transfer_resp();

		case REAL_ASET_APARTMENT:
			aCargo.setReal_aset_apt_resp(String.valueOf(getStatus(aCargo.getReal_aset_apt_resp(), aMakeStatus)));
			return aCargo.getReal_aset_apt_resp();

		case REAL_ASET_VAC:
			aCargo.setReal_aset_vac_resp(String.valueOf(getStatus(aCargo.getReal_aset_vac_resp(), aMakeStatus)));
			return aCargo.getReal_aset_vac_resp();

		case REAL_ASET_RENTAL:
			aCargo.setReal_asset_rental_resp(String.valueOf(getStatus(aCargo.getReal_asset_rental_resp(), aMakeStatus)));
			return aCargo.getReal_asset_rental_resp();

		case REAL_ASET_COMMERCIAL:
			aCargo.setReal_aset_com_resp(String.valueOf(getStatus(aCargo.getReal_aset_com_resp(), aMakeStatus)));
			return aCargo.getReal_aset_com_resp();

		case REAL_ASET_CONDO:
			aCargo.setReal_aset_con_resp(String.valueOf(getStatus(aCargo.getReal_aset_con_resp(), aMakeStatus)));
			return aCargo.getReal_aset_con_resp();

		case REAL_ASET_DUPLEX:
			aCargo.setReal_aset_dup_resp(String.valueOf(getStatus(aCargo.getReal_aset_dup_resp(), aMakeStatus)));
			return aCargo.getReal_aset_dup_resp();

		case REAL_ASET_FARM:
			aCargo.setReal_aset_frm_resp(String.valueOf(getStatus(aCargo.getReal_aset_frm_resp(), aMakeStatus)));
			return aCargo.getReal_aset_frm_resp();

		case REAL_ASET_HOUSE:
			aCargo.setReal_asset_house_resp(String.valueOf(getStatus(aCargo.getReal_asset_house_resp(), aMakeStatus)));
			return aCargo.getReal_asset_house_resp();

		case REAL_ASET_LAND:
			aCargo.setReal_asset_land_resp(String.valueOf(getStatus(aCargo.getReal_asset_land_resp(), aMakeStatus)));
			return aCargo.getReal_asset_land_resp();

		case REAL_ASET_MOBILE_HOME:
			aCargo.setReal_asset_mobile_home_resp(String.valueOf(getStatus(aCargo.getReal_asset_mobile_home_resp(), aMakeStatus)));
			return aCargo.getReal_asset_mobile_home_resp();

		case REAL_ASET_OTHER:
			aCargo.setReal_asset_other_resp(String.valueOf(getStatus(aCargo.getReal_asset_other_resp(), aMakeStatus)));
			return aCargo.getReal_asset_other_resp();
		case REAL_ASET_HOME:
			aCargo.setReal_asset_home_resp(String.valueOf(getStatus(aCargo.getReal_asset_home_resp(), aMakeStatus)));
			return aCargo.getReal_asset_home_resp();
		case REAL_ASET_LIFE_ESTATE:
			aCargo.setReal_asset_life_estate_resp(String.valueOf(getStatus(aCargo.getReal_asset_life_estate_resp(), aMakeStatus)));
			return aCargo.getReal_asset_life_estate_resp();
		case REAL_ASET_UNOCCUPY_HOME:
			aCargo.setReal_asset_unoccupy_home_resp(String.valueOf(getStatus(aCargo.getReal_asset_unoccupy_home_resp(), aMakeStatus)));
			return aCargo.getReal_asset_unoccupy_home_resp();

		case VEH_ASET_ANIMAL_DRAWN:
			aCargo.setVehicle_asset_animal_drwn_resp(String.valueOf(getStatus(aCargo.getVehicle_asset_animal_drwn_resp(), aMakeStatus)));
			return aCargo.getVehicle_asset_animal_drwn_resp();
		case VEH_ASET_UNLIC:
			aCargo.setVeh_aset_unlic_resp(String.valueOf(getStatus(aCargo.getVeh_aset_unlic_resp(), aMakeStatus)));
			return aCargo.getVeh_aset_unlic_resp();
		case VEH_ASET_NONMOTORIZED_CAMPER:
			aCargo.setVehicle_asset_nmot_camper_resp(String.valueOf(getStatus(aCargo.getVehicle_asset_nmot_camper_resp(), aMakeStatus)));
			return aCargo.getVehicle_asset_nmot_camper_resp();
		case VEH_ASET_GOLFCART:
			aCargo.setVehicle_asset_golf_cart_resp(String.valueOf(getStatus(aCargo.getVehicle_asset_golf_cart_resp(), aMakeStatus)));
			return aCargo.getVehicle_asset_golf_cart_resp();
		case VEH_ASET_TRACTOR:
			aCargo.setVehicle_asset_tractor_resp(String.valueOf(getStatus(aCargo.getVehicle_asset_tractor_resp(), aMakeStatus)));
			return aCargo.getVehicle_asset_tractor_resp();
		case VEH_ASET_AIRPLANE:
			aCargo.setVeh_aset_arpl_resp(String.valueOf(getStatus(aCargo.getVeh_aset_arpl_resp(), aMakeStatus)));
			return aCargo.getVeh_aset_arpl_resp();

		case VEH_ASET_AUTOMOBILE:
			aCargo.setVehicle_asset_auto_resp(String.valueOf(getStatus(aCargo.getVehicle_asset_auto_resp(), aMakeStatus)));
			return aCargo.getVehicle_asset_auto_resp();

		case VEH_ASET_BOAT:
			aCargo.setVehicle_asset_boat_resp(String.valueOf(getStatus(aCargo.getVehicle_asset_boat_resp(), aMakeStatus)));
			return aCargo.getVehicle_asset_boat_resp();

		case VEH_ASET_BUS:
			aCargo.setVeh_aset_bus_resp(String.valueOf(getStatus(aCargo.getVeh_aset_bus_resp(), aMakeStatus)));
			return aCargo.getVeh_aset_bus_resp();

		case VEH_ASET_CAMPER:
			aCargo.setVehicle_asset_camper_resp(String.valueOf(getStatus(aCargo.getVehicle_asset_camper_resp(), aMakeStatus)));
			return aCargo.getVehicle_asset_camper_resp();

		case VEH_ASET_FARM_IMPLEMENT:
			aCargo.setVeh_aset_fimp_resp(String.valueOf(getStatus(aCargo.getVeh_aset_fimp_resp(), aMakeStatus)));
			return aCargo.getVeh_aset_fimp_resp();

		case VEH_ASET_FARM_EQUIP:
			aCargo.setVeh_aset_fmeq_resp(String.valueOf(getStatus(aCargo.getVeh_aset_fmeq_resp(), aMakeStatus)));
			return aCargo.getVeh_aset_fmeq_resp();

		case VEH_ASET_FARM_TRACTOR:
			aCargo.setVeh_aset_ftrc_resp(String.valueOf(getStatus(aCargo.getVeh_aset_ftrc_resp(), aMakeStatus)));
			return aCargo.getVeh_aset_ftrc_resp();

		case VEH_ASET_FARM_TRAILER:
			aCargo.setVeh_aset_ftrl_resp(String.valueOf(getStatus(aCargo.getVeh_aset_ftrl_resp(), aMakeStatus)));
			return aCargo.getVeh_aset_ftrl_resp();

		case VEH_ASET_LOG_SKIDDER:
			aCargo.setVeh_aset_lskd_resp(String.valueOf(getStatus(aCargo.getVeh_aset_lskd_resp(), aMakeStatus)));
			return aCargo.getVeh_aset_lskd_resp();

		case VEH_ASET_MOTORCYCLE:
			aCargo.setVehicle_asset_motorcycle_resp(String.valueOf(getStatus(aCargo.getVehicle_asset_motorcycle_resp(), aMakeStatus)));
			return aCargo.getVehicle_asset_motorcycle_resp();
		case VEH_ASET_NONMOTORIZED_BOAT:
			aCargo.setVeh_aset_nm_b_resp(String.valueOf(getStatus(aCargo.getVeh_aset_nm_b_resp(), aMakeStatus)));
			return aCargo.getVeh_aset_nm_b_resp();

		case VEH_ASET_OTHER:
			aCargo.setVeh_aset_othr_resp(String.valueOf(getStatus(aCargo.getVeh_aset_othr_resp(), aMakeStatus)));
			return aCargo.getVeh_aset_othr_resp();

		case VEH_ASET_RECREATIONAL_VEHICLE:
			aCargo.setVehicle_asset_recreation_resp(String.valueOf(getStatus(aCargo.getVehicle_asset_recreation_resp(), aMakeStatus)));
			return aCargo.getVehicle_asset_recreation_resp();

		case VEH_ASET_SNOWMOBILE:
			aCargo.setVeh_aset_s_mb_resp(String.valueOf(getStatus(aCargo.getVeh_aset_s_mb_resp(), aMakeStatus)));
			return aCargo.getVeh_aset_s_mb_resp();

		case VEH_ASET_TRUCK:
			aCargo.setVeh_aset_trk_resp(String.valueOf(getStatus(aCargo.getVeh_aset_trk_resp(), aMakeStatus)));
			return aCargo.getVeh_aset_trk_resp();

		case VEH_ASET_TRAVEL_TRAILER:
			aCargo.setVeh_aset_trlr_resp(String.valueOf(getStatus(aCargo.getVeh_aset_trlr_resp(), aMakeStatus)));
			return aCargo.getVeh_aset_trlr_resp();

		case VEH_ASET_VAN:
			aCargo.setVeh_aset_van_resp(String.valueOf(getStatus(aCargo.getVeh_aset_van_resp(), aMakeStatus)));
			return aCargo.getVeh_aset_van_resp();
			// PCR# 40362 - ADDED NEW RESPONSES FOR RMB AND SMRF CHANGES - ends

		case INDV_CC_RQST_IND:
			aCargo.setIndv_cc_rqst_ind(String.valueOf(getStatus(aCargo.getIndv_cc_rqst_ind(), aMakeStatus)));
			return "Y";

		case INDV_TANF_RQST_IND:
			aCargo.setIndv_wic_rqst_ind(String.valueOf(getStatus(aCargo.getIndv_wic_rqst_ind(), aMakeStatus)));
			return "Y";

		case INDV_WIC_RQST_IND:
			aCargo.setIndv_wic_rqst_ind(String.valueOf(getStatus(aCargo.getIndv_wic_rqst_ind(), aMakeStatus)));
			return "Y";

		case SCHL_ENRL_RESP:
			aCargo.setSchool_enrollment_resp(String.valueOf(getStatus(aCargo.getSchool_enrollment_resp(), aMakeStatus)));
			return aCargo.getSchool_enrollment_resp();

		case HOSPITAL_STAY_RESP:
			aCargo.setHospital_stay_resp(String.valueOf(getStatus(aCargo.getHospital_stay_resp(), aMakeStatus)));
			return aCargo.getHospital_stay_resp();

		case TRB_CMDY_RESP:
			aCargo.setTrb_cmdy_resp(String.valueOf(getStatus(aCargo.getTrb_cmdy_resp(), aMakeStatus)));
			return aCargo.getTrb_cmdy_resp();
		case CP_WLST_RESP:
			aCargo.setCp_wlst_resp(String.valueOf(getStatus(aCargo.getCp_wlst_resp(), aMakeStatus)));
			return aCargo.getCp_wlst_resp();
		case INDIVIDUAL_CLA:
			aCargo.setIndv_cla_ind(String.valueOf(getStatus(aCargo.getIndv_cla_ind(), aMakeStatus)));
			return aCargo.getIndv_cla_ind();
		case HEAD_OF_HOUSE:
			aCargo.setHead_of_household_resp(String.valueOf(getStatus(aCargo.getHead_of_household_resp(), aMakeStatus)));
			return aCargo.getHead_of_household_resp();
			// EDSP OTHER INCOME
		case STRIKE_BENEFITS_RESP:
			aCargo.setBenefits_on_strike_resp(String.valueOf(getStatus(aCargo.getBenefits_on_strike_resp(), aMakeStatus)));
			return aCargo.getTraining_allowance_resp();
		case TRAINING_ALLOWANCE:
			aCargo.setTraining_allowance_resp(String.valueOf(getStatus(aCargo.getTraining_allowance_resp(), aMakeStatus)));
			return aCargo.getTraining_allowance_resp();
		case INHERITANCE:
			aCargo.setInheritance_resp(String.valueOf(getStatus(aCargo.getInheritance_resp(), aMakeStatus)));
			return aCargo.getInheritance_resp();
		case STUDENT_FINANCIAL_AID:
			aCargo.setStudent_financial_aid_resp(String.valueOf(getStatus(aCargo.getStudent_financial_aid_resp(), aMakeStatus)));
			return aCargo.getStudent_financial_aid_resp();
		case FOOD_CLOTHING_UTIL_RENT:
			aCargo.setFood_clothing_util_rent_resp(String.valueOf(getStatus(aCargo.getFood_clothing_util_rent_resp(), aMakeStatus)));
			return aCargo.getFood_clothing_util_rent_resp();
		case CASH_GIFTS_CONT:
			aCargo.setCash_gifts_resp(String.valueOf(getStatus(aCargo.getCash_gifts_resp(), aMakeStatus)));
			return aCargo.getCash_gifts_resp();
		case LOAN:
			aCargo.setLoan_resp(String.valueOf(getStatus(aCargo.getLoan_resp(), aMakeStatus)));
			return aCargo.getLoan_resp();
		case BLACK_LUNG_BENEFIT:
			aCargo.setBenefit_black_lung_resp(String.valueOf(getStatus(aCargo.getBenefit_black_lung_resp(), aMakeStatus)));
			return aCargo.getBenefit_black_lung_resp();
		case LOTTERY_PRIZE_WINNING:
			aCargo.setLottery_prize_winning_resp(String.valueOf(getStatus(aCargo.getLottery_prize_winning_resp(), aMakeStatus)));
			return aCargo.getLottery_prize_winning_resp();
		case INSURANCE_SETTLEMENT:
			aCargo.setInsurance_settlement_resp(String.valueOf(getStatus(aCargo.getInsurance_settlement_resp(), aMakeStatus)));
			return aCargo.getInsurance_settlement_resp();
		case OTHR_SOCIAL_SECURITY_BENEFITS:
			aCargo.setOthr_social_security_bnft_resp(String.valueOf(getStatus(aCargo.getOthr_social_security_bnft_resp(), aMakeStatus)));
			return aCargo.getOthr_social_security_bnft_resp();
		case RESETTL_INC_RESP:
			aCargo.setResettl_inc_resp(String.valueOf(getStatus(aCargo.getResettl_inc_resp(), aMakeStatus)));
			return aCargo.getResettl_inc_resp();
		case OTHR_INCM_RENTL_RESP:
			aCargo.setOthr_incm_rentl_resp(String.valueOf(getStatus(aCargo.getOthr_incm_rentl_resp(), aMakeStatus)));
			return aCargo.getOthr_incm_rentl_resp();
		case LAND_CONT_RESP:
			aCargo.setLand_cont_resp(String.valueOf(getStatus(aCargo.getLand_cont_resp(), aMakeStatus)));
			return aCargo.getLand_cont_resp();
		case HOUSING_BILLS_OTHERS:
			aCargo.setHousing_bill_others_resp(String.valueOf(getStatus(aCargo.getHousing_bill_others_resp(), aMakeStatus)));
			return aCargo.getHousing_bill_others_resp();
		case UTILITY_BILLS_OIL:
			aCargo.setUtility_bills_oil_resp(String.valueOf(getStatus(aCargo.getUtility_bills_oil_resp(), aMakeStatus)));
			return aCargo.getUtility_bills_oil_resp();
		case WORK_RELATED_EXPENSE_RESP:
			aCargo.setWork_related_expense_resp(String.valueOf(getStatus(aCargo.getWork_related_expense_resp(), aMakeStatus)));
			return aCargo.getWork_related_expense_resp();
		case LIFE_INS_ASSET_WHOLE_LIFE_RESP:
			aCargo.setLife_ins_asset_whole_life_resp(String.valueOf(getStatus(aCargo.getLife_ins_asset_whole_life_resp(), aMakeStatus)));
			return aCargo.getLife_ins_asset_whole_life_resp();
		case LIFE_INSURANCE_ASSET_TERM_RESP:
			aCargo.setLife_insurance_asset_term_resp(String.valueOf(getStatus(aCargo.getLife_insurance_asset_term_resp(), aMakeStatus)));
			return aCargo.getLife_insurance_asset_term_resp();
		case LIFE_INS_ASEST_GROUP_LIFE_RESP:
			aCargo.setLife_ins_asest_group_life_resp(String.valueOf(getStatus(aCargo.getLife_ins_asest_group_life_resp(), aMakeStatus)));
			return aCargo.getLife_ins_asest_group_life_resp();
		case LIFE_INS_ASSET_GROUP_TERM_RESP:
			aCargo.setLife_ins_asset_group_term_resp(String.valueOf(getStatus(aCargo.getLife_ins_asset_group_term_resp(), aMakeStatus)));
			return aCargo.getLife_ins_asset_group_term_resp();
		case LIFE_INS_ASSET_UNIVERSAL_RESP:
			aCargo.setLife_ins_asset_universal_resp(String.valueOf(getStatus(aCargo.getLife_ins_asset_universal_resp(), aMakeStatus)));
			return aCargo.getLife_ins_asset_universal_resp();
		case LIFE_INSURANCE_OTHER_RESP:
			aCargo.setLife_insurance_other_resp(String.valueOf(getStatus(aCargo.getLife_insurance_other_resp(), aMakeStatus)));
			return aCargo.getLife_insurance_other_resp();
		case MED_TYPE_PROSTHETIC_RESP:
			aCargo.setMed_type_prosthetic_resp(String.valueOf(getStatus(aCargo.getMed_type_prosthetic_resp(), aMakeStatus)));
			return aCargo.getMed_type_prosthetic_resp();

		case MED_TYPE_ATNDNT_MEAL_RESP:
			aCargo.setMed_type_atndnt_meal_resp(String.valueOf(getStatus(aCargo.getMed_type_atndnt_meal_resp(), aMakeStatus)));
			return aCargo.getMed_type_atndnt_meal_resp();
		case MED_TYPE_ANIMAL_RESP:
			aCargo.setMed_type_animal_resp(String.valueOf(getStatus(aCargo.getMed_type_animal_resp(), aMakeStatus)));
			return aCargo.getMed_type_animal_resp();
		case MED_TYPE_MAINTAIN_ATTNDNT_RESP:
			aCargo.setMed_type_maintain_attndnt_resp(String.valueOf(getStatus(aCargo.getMed_type_maintain_attndnt_resp(), aMakeStatus)));
			return aCargo.getMed_type_maintain_attndnt_resp();
		case MED_TYPE_INHOME_RESP:
			aCargo.setMed_type_inhome_resp(String.valueOf(getStatus(aCargo.getMed_type_inhome_resp(), aMakeStatus)));
			return aCargo.getMed_type_inhome_resp();
		case MED_TYPE_SPECIAL_EQUIP_RESP:
			aCargo.setMed_type_special_equip_resp(String.valueOf(getStatus(aCargo.getMed_type_special_equip_resp(), aMakeStatus)));
			return aCargo.getMed_type_special_equip_resp();
		case MED_TYPE_EYEGLASSES_RESP:
			aCargo.setMed_type_eyeglasses_resp(String.valueOf(getStatus(aCargo.getMed_type_eyeglasses_resp(), aMakeStatus)));
			return aCargo.getMed_type_eyeglasses_resp();
		case MED_TYPE_INSURANCE_RESP:
			aCargo.setMed_type_insurance_resp(String.valueOf(getStatus(aCargo.getMed_type_insurance_resp(), aMakeStatus)));
			return aCargo.getMed_type_insurance_resp();
		case MED_TYPE_BILLS_RESP:
			aCargo.setMed_type_bills_resp(String.valueOf(getStatus(aCargo.getMed_type_bills_resp(), aMakeStatus)));
			return aCargo.getMed_type_bills_resp();
		case MED_TYPE_SUPPLIES_RESP:
			aCargo.setMed_type_supplies_resp(String.valueOf(getStatus(aCargo.getMed_type_supplies_resp(), aMakeStatus)));
			return aCargo.getMed_type_supplies_resp();
		case MED_TYPE_NURSING_RESP:
			aCargo.setMed_type_nursing_resp(String.valueOf(getStatus(aCargo.getMed_type_nursing_resp(), aMakeStatus)));
			return aCargo.getMed_type_nursing_resp();
		case MED_TYPE_OTHER_RESP:
			aCargo.setMed_type_other_resp(String.valueOf(getStatus(aCargo.getMed_type_other_resp(), aMakeStatus)));
			return aCargo.getMed_type_other_resp();
		case MED_TYPE_OUT_PATIENT_RESP:
			aCargo.setMed_type_out_patient_resp(String.valueOf(getStatus(aCargo.getMed_type_out_patient_resp(), aMakeStatus)));
			return aCargo.getMed_type_out_patient_resp();
		case MED_TYPE_PSYCHOTHERAPY_RESP:
			aCargo.setMed_type_psychotherapy_resp(String.valueOf(getStatus(aCargo.getMed_type_psychotherapy_resp(), aMakeStatus)));
			return aCargo.getMed_type_psychotherapy_resp();
		case MED_TYPE_PRESCRIBED_DRUG_RESP:
			aCargo.setMed_type_prescribed_drug_resp(String.valueOf(getStatus(aCargo.getMed_type_prescribed_drug_resp(), aMakeStatus)));
			return aCargo.getMed_type_prescribed_drug_resp();
		case MED_TYPE_TRANSPORTATION_RESP:
			aCargo.setMed_type_transportation_resp(String.valueOf(getStatus(aCargo.getMed_type_transportation_resp(), aMakeStatus)));
			return aCargo.getMed_type_transportation_resp();
		case UTILITY_STANDARD_RESP:
			aCargo.setUtility_standard_resp(String.valueOf(getStatus(aCargo.getUtility_standard_resp(), aMakeStatus)));
			return aCargo.getUtility_standard_resp();
		case ROOM_BOARD:
			aCargo.setRoom_board_resp(String.valueOf(getStatus(aCargo.getRoom_board_resp(), aMakeStatus)));
			return aCargo.getRoom_board_resp();
		case PAROLE_VIOLATION:
			aCargo.setParole_violation_resp(String.valueOf(getStatus(aCargo.getParole_violation_resp(), aMakeStatus)));
			return aCargo.getParole_violation_resp();
		case MOVED_OUT_OF_HOME_RESP:
			aCargo.setMoved_out_of_home_resp(String.valueOf(getStatus(aCargo.getMoved_out_of_home_resp(), aMakeStatus)));
			return aCargo.getMoved_out_of_home_resp();
		case PRSN_INFO_STAT_SW:
			aCargo.setPersonal_info(String.valueOf(getStatus(aCargo.getPersonal_info(), aMakeStatus)));
			return aCargo.getPersonal_info();
		case CITIZENSHIP_INFO:
			aCargo.setCitizenship_info(String.valueOf(getStatus(aCargo.getCitizenship_info(), aMakeStatus)));
			return aCargo.getCitizenship_info();
		case RLT_CHG_STAT_SW:
			aCargo.setRlt_chg_stat_sw(String.valueOf(getStatus(aCargo.getRlt_chg_stat_sw(), aMakeStatus)));
			return aCargo.getRlt_chg_stat_sw();
		case CHILD_CARE_RESP:
			aCargo.setChild_care_resp(String.valueOf(getStatus(aCargo.getChild_care_resp(), aMakeStatus)));
			return aCargo.getChild_care_resp();
		case CHILD_OBLIGATION_RESP:
			aCargo.setChild_obligation_resp(String.valueOf(getStatus(aCargo.getChild_obligation_resp(), aMakeStatus)));
			return aCargo.getChild_obligation_resp();
		case MEDICAL_BILLS_RESP:
			aCargo.setMedical_bills_resp(String.valueOf(getStatus(aCargo.getMedical_bills_resp(), aMakeStatus)));
			return aCargo.getMedical_bills_resp();

		case MEDTYP_DENTAL:
			aCargo.setMedtyp_dental(String.valueOf(getStatus(aCargo.getMedtyp_dental(), aMakeStatus)));
			return aCargo.getMedtyp_dental();
		case MEDTYP_ATTENDANT_CARE:
			aCargo.setMedtyp_attendant_care(String.valueOf(getStatus(aCargo.getMedtyp_attendant_care(), aMakeStatus)));
			return aCargo.getMedtyp_attendant_care();
		case MEDTYP_DOCTOR:
			aCargo.setMedtyp_doctor(String.valueOf(getStatus(aCargo.getMedtyp_doctor(), aMakeStatus)));
			return aCargo.getMedtyp_doctor();
		case MEDTYP_MED_EQUIP:
			aCargo.setMedtyp_med_equip(String.valueOf(getStatus(aCargo.getMedtyp_med_equip(), aMakeStatus)));
			return aCargo.getMedtyp_med_equip();
		case MEDTYP_HOSP_BILLS:
			aCargo.setMedtyp_hosp_bills(String.valueOf(getStatus(aCargo.getMedtyp_hosp_bills(), aMakeStatus)));
			return aCargo.getMedtyp_hosp_bills();
		case MEDTYP_INSUR_PREMIUM:
			aCargo.setMedtyp_insur_premium(String.valueOf(getStatus(aCargo.getMedtyp_insur_premium(), aMakeStatus)));
			return aCargo.getMedtyp_insur_premium();
		case MEDTYP_RX_COST:
			aCargo.setMedtyp_rx_cost(String.valueOf(getStatus(aCargo.getMedtyp_rx_cost(), aMakeStatus)));
			return aCargo.getMedtyp_rx_cost();
		case MEDTYP_TRANS_MED:
			aCargo.setMedtyp_trans_med(String.valueOf(getStatus(aCargo.getMedtyp_trans_med(), aMakeStatus)));
			return aCargo.getMedtyp_trans_med();
		case MEDTYP_OTHER:
			aCargo.setMedtyp_other(String.valueOf(getStatus(aCargo.getMedtyp_other(), aMakeStatus)));
			return aCargo.getMedtyp_other();
		case UNPAID_MEDBILL:
			aCargo.setUnpaid_medbill(String.valueOf(getStatus(aCargo.getUnpaid_medbill(), aMakeStatus)));
			return aCargo.getUnpaid_medbill();
		case MEDTYP_HSA_CONTRIB:
			aCargo.setMedtyp_hsa_contrib(String.valueOf(getStatus(aCargo.getMedtyp_hsa_contrib(), aMakeStatus)));
			return aCargo.getMedtyp_hsa_contrib();
		case UEI_ADOPTION_ASSIST:
			aCargo.setAdoptAssistance(String.valueOf(getStatus(aCargo.getAdoptAssistance(), aMakeStatus)));
			return aCargo.getAdoptAssistance();
		case UEI_ADOPTION_PYMT:
			aCargo.setAdoptionPayments(String.valueOf(getStatus(aCargo.getAdoptionPayments(), aMakeStatus)));
			return aCargo.getAdoptionPayments();
		case UEI_AGENT_ORNG_PYMT:
			aCargo.setAgentOrangePayments(String.valueOf(getStatus(aCargo.getAgentOrangePayments(), aMakeStatus)));
			return aCargo.getAgentOrangePayments();
		case UEI_ALIMONY:
			aCargo.setAlimony(String.valueOf(getStatus(aCargo.getAlimony(), aMakeStatus)));
			return aCargo.getAlimony();
		case UEI_CAPITAL_GAINS:
			aCargo.setCapitalGains(String.valueOf(getStatus(aCargo.getCapitalGains(), aMakeStatus)));
			return aCargo.getCapitalGains();
		case UEI_DEATH_BNFT:
			aCargo.setDeathBenefits(String.valueOf(getStatus(aCargo.getDeathBenefits(), aMakeStatus)));
			return aCargo.getDeathBenefits();
		case UEI_DABL_INCM:
			aCargo.setDisabilityIncome(String.valueOf(getStatus(aCargo.getDisabilityIncome(), aMakeStatus)));
			return aCargo.getDisabilityIncome();
		case UEI_DR_RELIEF:
			aCargo.setDisasterRelief(String.valueOf(getStatus(aCargo.getDisasterRelief(), aMakeStatus)));
			return aCargo.getDisasterRelief();
		case UEI_EDU_ASSIST:
			aCargo.setEducationalAssistance(String.valueOf(getStatus(aCargo.getEducationalAssistance(), aMakeStatus)));
			return aCargo.getEducationalAssistance();
		case UEI_ENERGY_ASSIST:
			aCargo.setEnergyAssistance(String.valueOf(getStatus(aCargo.getEnergyAssistance(), aMakeStatus)));
			return aCargo.getEnergyAssistance();
		case UEI_FRM_ALOT:
			aCargo.setFarmAllotment(String.valueOf(getStatus(aCargo.getFarmAllotment(), aMakeStatus)));
			return aCargo.getFarmAllotment();
		case UEI_FOSTER_CARE_PYMT:
			aCargo.setFosterCarePayments(String.valueOf(getStatus(aCargo.getFosterCarePayments(), aMakeStatus)));
			return aCargo.getFosterCarePayments();
		case UEI_GEN_ASSIST:
			aCargo.setGeneralAssistance(String.valueOf(getStatus(aCargo.getGeneralAssistance(), aMakeStatus)));
			return aCargo.getGeneralAssistance();
		case UEI_INT_DIV_PYMT:
			aCargo.setInterestDividendPayments(String.valueOf(getStatus(aCargo.getInterestDividendPayments(), aMakeStatus)));
			return aCargo.getInterestDividendPayments();
		case UEI_IRA_DIST:
			aCargo.setiRADistribution(String.valueOf(getStatus(aCargo.getiRADistribution(), aMakeStatus)));
			return aCargo.getiRADistribution();
		case UEI_LOTTERY_WIN:
			aCargo.setLotteryWinnings(String.valueOf(getStatus(aCargo.getLotteryWinnings(), aMakeStatus)));
			return aCargo.getLotteryWinnings();
		case UEI_LUMP_SUM:
			aCargo.setLumpSum(String.valueOf(getStatus(aCargo.getLumpSum(), aMakeStatus)));
			return aCargo.getLumpSum();
		case UEI_MIL_ALOT:
			aCargo.setMilitaryAllotment(String.valueOf(getStatus(aCargo.getMilitaryAllotment(), aMakeStatus)));
			return aCargo.getMilitaryAllotment();
		case UEI_MON_FRO_OTH:
			aCargo.setMoneyFromAnotherPerson(String.valueOf(getStatus(aCargo.getMoneyFromAnotherPerson(), aMakeStatus)));
			return aCargo.getMoneyFromAnotherPerson();
		case UEI_NET_RENT_ROYALTY:
			aCargo.setNetRentalRoyalty(String.valueOf(getStatus(aCargo.getNetRentalRoyalty(), aMakeStatus)));
			return aCargo.getNetRentalRoyalty();
		case UEI_OTH:
			aCargo.setOtherIncome(String.valueOf(getStatus(aCargo.getOtherIncome(), aMakeStatus)));
			return aCargo.getOtherIncome();
		case UEI_ANNY_PYMT:
			aCargo.setPaymentsFromAnnuity(String.valueOf(getStatus(aCargo.getPaymentsFromAnnuity(), aMakeStatus)));
			return aCargo.getPaymentsFromAnnuity();
		case UEI_PYMT_BO:
			aCargo.setPaymentsMadeOnYourBehalf(String.valueOf(getStatus(aCargo.getPaymentsMadeOnYourBehalf(), aMakeStatus)));
			return aCargo.getPaymentsMadeOnYourBehalf();
		case UEI_PENSION:
			aCargo.setPensionOrRetirement(String.valueOf(getStatus(aCargo.getPensionOrRetirement(), aMakeStatus)));
			return aCargo.getPensionOrRetirement();
		case UEI_RR_RETIRE:
			aCargo.setRailroadRetirement(String.valueOf(getStatus(aCargo.getRailroadRetirement(), aMakeStatus)));
			return aCargo.getRailroadRetirement();
		case UEI_REFUGEE_CASH:
			aCargo.setRefugeeCash(String.valueOf(getStatus(aCargo.getRefugeeCash(), aMakeStatus)));
			return aCargo.getRefugeeCash();
		case UEI_REL_CARE:
			aCargo.setRelativeCareSubsidy(String.valueOf(getStatus(aCargo.getRelativeCareSubsidy(), aMakeStatus)));
			return aCargo.getRelativeCareSubsidy();
		case UEI_RENTAL_INCM:
			aCargo.setRentalIncome(String.valueOf(getStatus(aCargo.getRentalIncome(), aMakeStatus)));
			return aCargo.getRentalIncome();
		case UEI_TANF_PYMT:
			aCargo.settANFPayments(String.valueOf(getStatus(aCargo.gettANFPayments(), aMakeStatus)));
			return aCargo.gettANFPayments();
		case UEI_UNEMPL:
			aCargo.setUnemploymentCompensation(String.valueOf(getStatus(aCargo.getUnemploymentCompensation(), aMakeStatus)));
			return aCargo.getUnemploymentCompensation();
		case UEI_WORKER_STUDY:
			aCargo.setWorkStudyStateFederal(String.valueOf(getStatus(aCargo.getWorkStudyStateFederal(), aMakeStatus)));
			return aCargo.getWorkStudyStateFederal();
		case UEI_WORKER_COMP:
			aCargo.setWorkersCompensation(String.valueOf(getStatus(aCargo.getWorkersCompensation(), aMakeStatus)));
			return aCargo.getWorkersCompensation();

		case PERS_PROP_BUS_EQPT:
			aCargo.setPers_prop_bus_eqpt(String.valueOf(getStatus(aCargo.getPers_prop_bus_eqpt(), aMakeStatus)));
			return aCargo.getPers_prop_bus_eqpt();
		case PERS_PROP_CEMETARY_LOT:
			aCargo.setPers_prop_cemetary_lot(String.valueOf(getStatus(aCargo.getPers_prop_cemetary_lot(), aMakeStatus)));
			return aCargo.getPers_prop_cemetary_lot();
		case PERS_PROP_LIVESTOCK:
			aCargo.setPers_prop_livestock(String.valueOf(getStatus(aCargo.getPers_prop_livestock(), aMakeStatus)));
			return aCargo.getPers_prop_livestock();
		case PERS_PROP_SAF_DEPST_BOX:
			aCargo.setPers_prop_saf_depst_box(String.valueOf(getStatus(aCargo.getPers_prop_saf_depst_box(), aMakeStatus)));
			return aCargo.getPers_prop_saf_depst_box();
		case PERS_PROP_OTH_VAL:
			aCargo.setPers_prop_oth_val(String.valueOf(getStatus(aCargo.getPers_prop_oth_val(), aMakeStatus)));
			return aCargo.getPers_prop_oth_val();

			// Added by Srividhya 16Mar15 for RMC5 Pregnancy changes
		case ABLE_TO_CONCEIVE_RESP:
			aCargo.setAble_to_conceive_resp(String.valueOf(getStatus(aCargo.getAble_to_conceive_resp(), aMakeStatus)));
			return aCargo.getAble_to_conceive_resp();

		case UNDERWEIGHT_BIRTH_RESP:
			aCargo.setUnderweight_birth_resp(String.valueOf(getStatus(aCargo.getUnderweight_birth_resp(), aMakeStatus)));
			return aCargo.getUnderweight_birth_resp();

		case PREG_ADD_STAT_SW:
			aCargo.setPreg_add_stat_sw(String.valueOf(getStatus(aCargo.getPreg_add_stat_sw(), aMakeStatus)));
			return aCargo.getPreg_add_stat_sw();

		case PREG_CHG_STAT_SW:
			aCargo.setPreg_chg_stat_sw(String.valueOf(getStatus(aCargo.getPreg_chg_stat_sw(), aMakeStatus)));
			return aCargo.getPreg_chg_stat_sw();

		case SU_CST_INS_RESP:
			aCargo.setSu_cst_ins_resp(String.valueOf(getStatus(aCargo.getSu_cst_ins_resp(), aMakeStatus)));
			return aCargo.getSu_cst_ins_resp();
		case OTHER_HOUSING_BILL_RESP:
			aCargo.setOther_housing_bill_resp(String.valueOf(getStatus(aCargo.getOther_housing_bill_resp(), aMakeStatus)));
			return aCargo.getOther_housing_bill_resp();
		case DISASTER_REPAIR_RESP:
			aCargo.setDisaster_repair_resp(String.valueOf(getStatus(aCargo.getDisaster_repair_resp(), aMakeStatus)));
			return aCargo.getDisaster_repair_resp();
		case PREVENT_EVICTION_RESP:
			aCargo.setPrevent_eviction_resp(String.valueOf(getStatus(aCargo.getPrevent_eviction_resp(), aMakeStatus)));
			return aCargo.getPrevent_eviction_resp();
		case CARE_TAKER_RESP:
			aCargo.setCareTaker_resp(String.valueOf(getStatus(aCargo.getCareTaker_resp(), aMakeStatus)));
			return aCargo.getCareTaker_resp();
		case LOST_HEALTH_INS_IND:
			aCargo.setLost_health_ins_ind(String.valueOf(getStatus(aCargo.getLost_health_ins_ind(), aMakeStatus)));
			return aCargo.getLost_health_ins_ind();
		case TAX_CLAIM_DEPENDENT:
			aCargo.setTax_claim_dependant_resp(String.valueOf(getStatus(aCargo.getTax_claim_dependant_resp(), aMakeStatus)));
			return aCargo.getTax_claim_dependant_resp();

			//NextGen  NG-6481 Phase 3 updates to ACA Streamline changes : Start
		case BEFORE_TAX_DEDUCTION:
			aCargo.setBefore_tax_deduction_resp(String.valueOf(getStatus(aCargo.getBefore_tax_deduction_resp(), aMakeStatus)));
			return aCargo.getBefore_tax_deduction_resp();
		case BTD_MED_INS:
			aCargo.setBtd_med_ins(String.valueOf(getStatus(aCargo.getBtd_med_ins(), aMakeStatus)));
			return aCargo.getBtd_med_ins();
		case BTD_DENT_INS:
			aCargo.setBtd_dent_ins(String.valueOf(getStatus(aCargo.getBtd_dent_ins(), aMakeStatus)));
			return aCargo.getBtd_dent_ins();
		case BTD_VIS_CARE_INS:
			aCargo.setBtd_vis_care_ins(String.valueOf(getStatus(aCargo.getBtd_vis_care_ins(), aMakeStatus)));
			return aCargo.getBtd_vis_care_ins();
		case BTD_FLEX_ACC:
			aCargo.setBtd_flex_acc(String.valueOf(getStatus(aCargo.getBtd_flex_acc(), aMakeStatus)));
			return aCargo.getBtd_flex_acc();
		case BTD_DEF_COMP:
			aCargo.setBtd_def_comp(String.valueOf(getStatus(aCargo.getBtd_def_comp(), aMakeStatus)));
			return aCargo.getBtd_def_comp();
		case BTD_PRE_TAX_INS:
			aCargo.setBtd_pre_tax_ins(String.valueOf(getStatus(aCargo.getBtd_pre_tax_ins(), aMakeStatus)));
			return aCargo.getBtd_pre_tax_ins();
		case BTD_OTHER:
			aCargo.setBtd_other(String.valueOf(getStatus(aCargo.getBtd_other(), aMakeStatus)));
			return aCargo.getBtd_other();
		case TAX_DEDUCT_RESP:
			aCargo.setTax_deduct_resp(String.valueOf(getStatus(aCargo.getTax_deduct_resp(), aMakeStatus)));
			return aCargo.getTax_deduct_resp();
			// NextGen NG-6481 Phase 3 updates to ACA Streamline changes – end
		case HLTH_INS_RESP:
			aCargo.setHlth_ins_resp(String.valueOf(getStatus(aCargo.getHlth_ins_resp(), aMakeStatus)));
			return aCargo.getHlth_ins_resp();
		case OTHR_HLTH_INS_RESP:
			aCargo.setOthr_hlth_ins_resp(String.valueOf(getStatus(aCargo.getOthr_hlth_ins_resp(), aMakeStatus)));
			return aCargo.getOthr_hlth_ins_resp();

			//add and change indicators
		case ROOM_BRD_CHG_IND:
			aCargo.setRoom_brd_chg_ind(String.valueOf(getStatus(aCargo.getRoom_brd_chg_ind(), aMakeStatus)));
			return aCargo.getRoom_brd_chg_ind();
		case DABL_STAT_IND:
			aCargo.setDabl_stat_ind(String.valueOf(getStatus(aCargo.getDabl_stat_ind(), aMakeStatus)));
			return aCargo.getDabl_stat_ind();
		case PREG_ADD_STAT_IND:
			aCargo.setPreg_add_stat_ind(String.valueOf(getStatus(aCargo.getPreg_add_stat_ind(), aMakeStatus)));
			return aCargo.getPreg_add_stat_ind();
		case PREG_CHG_IND:
			aCargo.setPreg_chg_ind(String.valueOf(getStatus(aCargo.getPreg_chg_ind(), aMakeStatus)));
			return aCargo.getPreg_chg_ind();
		case IRWE_CHG_IND:
			aCargo.setIrwe_chg_ind(String.valueOf(getStatus(aCargo.getIrwe_chg_ind(), aMakeStatus)));
			return aCargo.getIrwe_chg_ind();
		case EI_CHG_IND:
			aCargo.setEi_chg_ind(String.valueOf(getStatus(aCargo.getEi_chg_ind(), aMakeStatus)));
			return aCargo.getEi_chg_ind();
		case SELF_EMPL_CHG_IND:
			aCargo.setSelf_empl_chg_ind(String.valueOf(getStatus(aCargo.getSelf_empl_chg_ind(), aMakeStatus)));
			return aCargo.getSelf_empl_chg_ind();
		case OTHR_INCM_CHG_IND:
			aCargo.setOthr_incm_chg_ind(String.valueOf(getStatus(aCargo.getOthr_incm_chg_ind(), aMakeStatus)));
			return aCargo.getOthr_incm_chg_ind();
		case EMPL_CHG_IND:
			aCargo.setEmpl_chg_ind(String.valueOf(getStatus(aCargo.getEmpl_chg_ind(), aMakeStatus)));
			return aCargo.getEmpl_chg_ind();
		case VEH_ASET_ADD_IND:
			aCargo.setVeh_aset_add_ind(String.valueOf(getStatus(aCargo.getVeh_aset_add_ind(), aMakeStatus)));
			return aCargo.getVeh_aset_add_ind();
		case VEH_ASET_CHG_IND:
			aCargo.setVeh_aset_chg_ind(String.valueOf(getStatus(aCargo.getVeh_aset_chg_ind(), aMakeStatus)));
			return aCargo.getVeh_aset_chg_ind();
		case REAL_ASET_ADD_IND:
			aCargo.setReal_aset_add_ind(String.valueOf(getStatus(aCargo.getReal_aset_add_ind(), aMakeStatus)));
			return aCargo.getReal_aset_add_ind();
		case REAL_ASET_CHG_IND:
			aCargo.setReal_aset_chg_ind(String.valueOf(getStatus(aCargo.getReal_aset_chg_ind(), aMakeStatus)));
			return aCargo.getReal_aset_chg_ind();
		case BURY_ASET_ADD_IND:
			aCargo.setBury_aset_add_ind(String.valueOf(getStatus(aCargo.getBury_aset_add_ind(), aMakeStatus)));
			return aCargo.getBury_aset_add_ind();
		case BURY_ASET_CHG_IND:
			aCargo.setBury_aset_chg_ind(String.valueOf(getStatus(aCargo.getBury_aset_chg_ind(), aMakeStatus)));
			return aCargo.getBury_aset_chg_ind();
		case LIQUID_ASSET_ADD_IND:
			aCargo.setLiquid_asset_add_ind(String.valueOf(getStatus(aCargo.getLiquid_asset_add_ind(), aMakeStatus)));
			return aCargo.getLiquid_asset_add_ind();
		case LIQUID_ASSET_BANK_ACC_CHG_IND:
			aCargo.setLiquid_asset_bank_acc_chg_ind(String.valueOf(getStatus(aCargo.getLiquid_asset_bank_acc_chg_ind(), aMakeStatus)));
			return aCargo.getLiquid_asset_bank_acc_chg_ind();
		case LIQUID_ASSET_CASH_CHG_IND:
			aCargo.setLiquid_asset_cash_chg_ind(String.valueOf(getStatus(aCargo.getLiquid_asset_cash_chg_ind(), aMakeStatus)));
			return aCargo.getLiquid_asset_cash_chg_ind();
		case LIQUID_ASSET_CHG_IND:
			aCargo.setLiquid_asset_chg_ind(String.valueOf(getStatus(aCargo.getLiquid_asset_chg_ind(), aMakeStatus)));
			return aCargo.getLiquid_asset_chg_ind();
		case LIQUID_ASSET_OTHER_CHG_IND:
			aCargo.setLiquid_asset_other_chg_ind(String.valueOf(getStatus(aCargo.getLiquid_asset_other_chg_ind(), aMakeStatus)));
			return aCargo.getLiquid_asset_other_chg_ind();
		case LIFE_INS_ASET_ADD_IND:
			aCargo.setLife_ins_aset_add_ind(String.valueOf(getStatus(aCargo.getLife_ins_aset_add_ind(), aMakeStatus)));
			return aCargo.getLife_ins_aset_add_ind();
		case LIFE_INS_ASET_CHG_IND:
			aCargo.setLife_ins_aset_chg_ind(String.valueOf(getStatus(aCargo.getLife_ins_aset_chg_ind(), aMakeStatus)));
			return aCargo.getLife_ins_aset_chg_ind();
		case ASET_XFER_CHG_IND:
			aCargo.setAset_xfer_chg_ind(String.valueOf(getStatus(aCargo.getAset_xfer_chg_ind(), aMakeStatus)));
			return aCargo.getAset_xfer_chg_ind();
		case DPND_CARE_CHG_IND:
			aCargo.setDpnd_care_chg_ind(String.valueOf(getStatus(aCargo.getDpnd_care_chg_ind(), aMakeStatus)));
			return aCargo.getDpnd_care_chg_ind();
		case HEALTH_INSURANCE_CHG_IND:
			aCargo.setHealth_insurance_chg_ind(String.valueOf(getStatus(aCargo.getHealth_insurance_chg_ind(), aMakeStatus)));
			return aCargo.getHealth_insurance_chg_ind();
		case OUT_ST_BNFT_CHG_IND:
			aCargo.setOut_st_bnft_chg_ind(String.valueOf(getStatus(aCargo.getOut_st_bnft_chg_ind(), aMakeStatus)));
			return aCargo.getOut_st_bnft_chg_ind();
		case SCHL_ENRL_CHG_IND:
			aCargo.setSchl_enrl_chg_ind(String.valueOf(getStatus(aCargo.getSchl_enrl_chg_ind(), aMakeStatus)));
			return aCargo.getSchl_enrl_chg_ind();
		case MRTL_STAT_CHG_IND:
			aCargo.setMrtl_stat_chg_ind(String.valueOf(getStatus(aCargo.getMrtl_stat_chg_ind(), aMakeStatus)));
			return aCargo.getMrtl_stat_chg_ind();
		case NUR_HME_CHG_IND:
			aCargo.setNur_hme_chg_ind(String.valueOf(getStatus(aCargo.getNur_hme_chg_ind(), aMakeStatus)));
			return aCargo.getNur_hme_chg_ind();
		case BFR_TAX_CHG_IND:
			aCargo.setBfr_tax_chg_ind(String.valueOf(getStatus(aCargo.getBfr_tax_chg_ind(), aMakeStatus)));
			return aCargo.getBfr_tax_chg_ind();
		case INC_TAX_CHG_IND:
			aCargo.setInc_tax_chg_ind(String.valueOf(getStatus(aCargo.getInc_tax_chg_ind(), aMakeStatus)));
			return aCargo.getInc_tax_chg_ind();
		case THRD_PRTY_CHG_IND:
			aCargo.setThrd_prty_chg_ind(String.valueOf(getStatus(aCargo.getThrd_prty_chg_ind(), aMakeStatus)));
			return aCargo.getThrd_prty_chg_ind();
		case CHILD_SUPPORT_PAYMENT_CHG_IND:
			aCargo.setChild_support_payment_chg_ind(String.valueOf(getStatus(aCargo.getChild_support_payment_chg_ind(), aMakeStatus)));
			return aCargo.getChild_support_payment_chg_ind();
		case SNAP_SHELTER_STANDARD_EXP_IND:
			aCargo.setSnap_shelter_standard_exp_ind(String.valueOf(getStatus(aCargo.getSnap_shelter_standard_exp_ind(), aMakeStatus)));
			return aCargo.getSnap_shelter_standard_exp_ind();
		case HOUS_BILL_CHG_IND:
			aCargo.setHous_bill_chg_ind(String.valueOf(getStatus(aCargo.getHous_bill_chg_ind(), aMakeStatus)));
			return aCargo.getHous_bill_chg_ind();
		case ADD_CHG_IND:
			aCargo.setAdd_chg_ind(String.valueOf(getStatus(aCargo.getAdd_chg_ind(), aMakeStatus)));
			return aCargo.getAdd_chg_ind();
		case PERSON_MOVED_IN_STAT_IND:
			aCargo.setPerson_moved_in_stat_ind(String.valueOf(getStatus(aCargo.getPerson_moved_in_stat_ind(), aMakeStatus)));
			return aCargo.getPerson_moved_in_stat_ind();
		case PERSON_MOVED_OUT_STAT_IND:
			aCargo.setPerson_moved_out_stat_ind(String.valueOf(getStatus(aCargo.getPerson_moved_out_stat_ind(), aMakeStatus)));
			return aCargo.getPerson_moved_out_stat_ind();
		case HOSPICE_CHG_IND:
			aCargo.setHospice_chg_ind(String.valueOf(getStatus(aCargo.getHospice_chg_ind(), aMakeStatus)));
			return aCargo.getHospice_chg_ind();
		case MEDICARE_CHG_IND:
			aCargo.setMedicare_chg_ind(String.valueOf(getStatus(aCargo.getMedicare_chg_ind(), aMakeStatus)));
			return aCargo.getMedicare_chg_ind();
		case NCP_CHG_IND:
			aCargo.setNcp_chg_ind(String.valueOf(getStatus(aCargo.getNcp_chg_ind(), aMakeStatus)));
			return aCargo.getNcp_chg_ind();
		case THIRD_PARTY_CHG_IND:
			aCargo.setThird_party_chg_ind(String.valueOf(getStatus(aCargo.getThird_party_chg_ind(), aMakeStatus)));
			return aCargo.getThird_party_chg_ind();
		case HOSPITAL_ABD_CHG_IND:
			aCargo.setHospital_abd_chg_ind(String.valueOf(getStatus(aCargo.getHospital_abd_chg_ind(), aMakeStatus)));
			return aCargo.getHospital_abd_chg_ind();
		case PUBLIC_LAW_ABD_CHG_IND:
			aCargo.setPublic_law_abd_chg_ind(String.valueOf(getStatus(aCargo.getPublic_law_abd_chg_ind(), aMakeStatus)));
			return aCargo.getPublic_law_abd_chg_ind();
		case LIVING_ARGMT_CHG_IND:
			aCargo.setLiving_argmt_chg_ind(String.valueOf(getStatus(aCargo.getLiving_argmt_chg_ind(), aMakeStatus)));
			return aCargo.getLiving_argmt_chg_ind();
		case OTHER_PROGRAM_CHG_IND:
			aCargo.setOther_program_chg_ind(String.valueOf(getStatus(aCargo.getOther_program_chg_ind(), aMakeStatus)));
			return aCargo.getOther_program_chg_ind();
		case TAX_INFO_IND:
			aCargo.setTax_info_ind(String.valueOf(getStatus(aCargo.getTax_info_ind(), aMakeStatus)));
			return aCargo.getTax_info_ind();
		case TAX_DEPENDENT_IND:
			aCargo.setTax_dep_outside_resp(String.valueOf(getStatus(aCargo.getTax_dep_outside_resp(), aMakeStatus)));
			return aCargo.getTax_dep_outside_resp();
		case MAGI_EXPENSE_CHG_IND:
			aCargo.setMagi_expense_chg_ind(String.valueOf(getStatus(aCargo.getMagi_expense_chg_ind(), aMakeStatus)));
			return aCargo.getMagi_expense_chg_ind();

		case MEDICARE_PART_A:
			aCargo.setMedicare_part_a(String.valueOf(getStatus(aCargo.getMedicare_part_a(), aMakeStatus)));
			return aCargo.getMedicare_part_a();
		case MEDICARE_PART_B:
			aCargo.setMedicare_part_b(String.valueOf(getStatus(aCargo.getMedicare_part_b(), aMakeStatus)));
			return aCargo.getMedicare_part_b();
		case MEDICARE_PART_C:
			aCargo.setMedicare_part_c(String.valueOf(getStatus(aCargo.getMedicare_part_c(), aMakeStatus)));
			return aCargo.getMedicare_part_c();
		case MEDICARE_PART_D:
			aCargo.setMedicare_part_d(String.valueOf(getStatus(aCargo.getMedicare_part_d(), aMakeStatus)));
			return aCargo.getMedicare_part_d();
		case CCSP_PROVIDER_PAYMENT:
			aCargo.setCssp_provider_payment(String.valueOf(getStatus(aCargo.getCssp_provider_payment(), aMakeStatus)));
			return aCargo.getCssp_provider_payment();
		case ANIMALS_TO_ASSIST_DISABLED:
			aCargo.setAnimals_to_assist_disabled(String.valueOf(getStatus(aCargo.getAnimals_to_assist_disabled(), aMakeStatus)));
			return aCargo.getAnimals_to_assist_disabled();
		case FUNERAL_DEATH_EXPENSE:
			aCargo.setFuneral_death_expense(String.valueOf(getStatus(aCargo.getFuneral_death_expense(), aMakeStatus)));
			return aCargo.getFuneral_death_expense();
		case BLIND_WORK_EXPENSE:
			aCargo.setBlind_work_expense(String.valueOf(getStatus(aCargo.getBlind_work_expense(), aMakeStatus)));
			return aCargo.getBlind_work_expense();
		case IMPAIRMENT_WORK_EXPENSE:
			aCargo.setImpairment_work_expense(String.valueOf(getStatus(aCargo.getImpairment_work_expense(), aMakeStatus)));
			return aCargo.getImpairment_work_expense();
		case OTH_IND_GAMBL_PMNTS:
			aCargo.setOth_ind_gambl_pmnts(String.valueOf(getStatus(aCargo.getOth_ind_gambl_pmnts(), aMakeStatus)));
			return aCargo.getOth_ind_gambl_pmnts();

		case BONDS:
			aCargo.setBonds(String.valueOf(getStatus(aCargo.getBonds(), aMakeStatus)));
			return aCargo.getBonds();
		case DIVIDEND:
			aCargo.setDividend(String.valueOf(getStatus(aCargo.getDividend(), aMakeStatus)));
			return aCargo.getDividend();
		case HEALTH_REIMBURSEMENT_ACCOUNT:
			aCargo.setHealth_reimbursement_account(String.valueOf(getStatus(aCargo.getHealth_reimbursement_account(), aMakeStatus)));
			return aCargo.getHealth_reimbursement_account();
		case INDIVIDUAL_DEVELOPMENT_ACCOUNT:
			aCargo.setIndividual_development_account(String.valueOf(getStatus(aCargo.getIndividual_development_account(), aMakeStatus)));
			return aCargo.getIndividual_development_account();
		case UNIFORM_GIFTS_TO_MINORS:
			aCargo.setUniform_gifts_to_minors(String.valueOf(getStatus(aCargo.getUniform_gifts_to_minors(), aMakeStatus)));
			return aCargo.getUniform_gifts_to_minors();

			// Other Income Type Addition

		case INCOME_FROM_RESOURCE:
			aCargo.setIncome_from_resource(String.valueOf(getStatus(aCargo.getIncome_from_resource(), aMakeStatus)));
			return aCargo.getIncome_from_resource();

		case INDIAN_GAMBLING_PAYMENTS:
			aCargo.setIndian_gambling_payments(String.valueOf(getStatus(aCargo.getIndian_gambling_payments(), aMakeStatus)));
			return aCargo.getIndian_gambling_payments();

		case INHERITANCE_INCOME:
			aCargo.setInheritance_income(String.valueOf(getStatus(aCargo.getInheritance_income(), aMakeStatus)));
			return aCargo.getInheritance_income();

		case INSUANCE_BENEFITS:
			aCargo.setInsuance_benefits(String.valueOf(getStatus(aCargo.getInsuance_benefits(), aMakeStatus)));
			return aCargo.getInsuance_benefits();

		case LOAN_RECEIVED:
			aCargo.setLoan_received(String.valueOf(getStatus(aCargo.getLoan_received(), aMakeStatus)));
			return aCargo.getLoan_received();

		case LOAN_REPAYMENT_INCOME:
			aCargo.setLoan_repayment_income(String.valueOf(getStatus(aCargo.getLoan_repayment_income(), aMakeStatus)));
			return aCargo.getLoan_repayment_income();

		case MANAGED_INCOME:
			aCargo.setManaged_income(String.valueOf(getStatus(aCargo.getManaged_income(), aMakeStatus)));
			return aCargo.getManaged_income();

		case MATCH_GRANT:
			aCargo.setMatch_grant(String.valueOf(getStatus(aCargo.getMatch_grant(), aMakeStatus)));
			return aCargo.getMatch_grant();

		case MONTGOMERY_GI_BILL:
			aCargo.setMontgomery_gi_bill(String.valueOf(getStatus(aCargo.getMontgomery_gi_bill(), aMakeStatus)));
			return aCargo.getMontgomery_gi_bill();

		case OUT_OF_STATE_PUBLIC:
			aCargo.setOut_of_state_public(String.valueOf(getStatus(aCargo.getOut_of_state_public(), aMakeStatus)));
			return aCargo.getOut_of_state_public();

		case REFUNDS_FROM_DCH:
			aCargo.setRefunds_from_dch(String.valueOf(getStatus(aCargo.getRefunds_from_dch(), aMakeStatus)));
			return aCargo.getRefunds_from_dch();

		case RESTITUTIONS_SETTLEMENTS:
			aCargo.setRestitutions_settlements(String.valueOf(getStatus(aCargo.getRestitutions_settlements(), aMakeStatus)));
			return aCargo.getRestitutions_settlements();

		case SENIOR_COMPANION:
			aCargo.setSenior_companion(String.valueOf(getStatus(aCargo.getSenior_companion(), aMakeStatus)));
			return aCargo.getSenior_companion();

		case SEVERANCE_PAY:
			aCargo.setSeverance_pay(String.valueOf(getStatus(aCargo.getSeverance_pay(), aMakeStatus)));
			return aCargo.getSeverance_pay();

		case STRIKE_BENEFITS:
			aCargo.setStrike_benefits(String.valueOf(getStatus(aCargo.getStrike_benefits(), aMakeStatus)));
			return aCargo.getStrike_benefits();

		case TRADE_READJUSTMENT:
			aCargo.setTrade_readjustment(String.valueOf(getStatus(aCargo.getTrade_readjustment(), aMakeStatus)));
			return aCargo.getTrade_readjustment();

		case UNIFORM_RELOCATION:
			aCargo.setUniform_relocation(String.valueOf(getStatus(aCargo.getUniform_relocation(), aMakeStatus)));
			return aCargo.getUniform_relocation();

		case UNION_FUNDS:
			aCargo.setUnion_funds(String.valueOf(getStatus(aCargo.getUnion_funds(), aMakeStatus)));
			return aCargo.getUnion_funds();

		case VENDOR_EXCLUDED:
			aCargo.setVendor_excluded(String.valueOf(getStatus(aCargo.getVendor_excluded(), aMakeStatus)));
			return aCargo.getVendor_excluded();

		case VICTIM_RESTITUTION:
			aCargo.setVictim_restitution(String.valueOf(getStatus(aCargo.getVictim_restitution(), aMakeStatus)));
			return aCargo.getVictim_restitution();

		case VOLUNTEER_PAYMENT:
			aCargo.setVolunteer_payment(String.valueOf(getStatus(aCargo.getVolunteer_payment(), aMakeStatus)));
			return aCargo.getVolunteer_payment();

		case VOLUNTEER_PAYMENT_TITLEI:
			aCargo.setVolunteer_payment_titlei(String.valueOf(getStatus(aCargo.getVolunteer_payment_titlei(), aMakeStatus)));
			return aCargo.getVolunteer_payment_titlei();

		case WIA_TRAINING_AND_ALLOWANCE:
			aCargo.setWia_training_and_allowance(String.valueOf(getStatus(aCargo.getWia_training_and_allowance(), aMakeStatus)));
			return aCargo.getWia_training_and_allowance();

		case INCLUDED_UNEARNED_INCOME:
			aCargo.setIncluded_unearned_income(String.valueOf(getStatus(aCargo.getIncluded_unearned_income(), aMakeStatus)));
			return aCargo.getIncluded_unearned_income();

		case TANF_MAX_AU_ALLOTMENT:
			aCargo.setTanf_max_au_allotment(String.valueOf(getStatus(aCargo.getTanf_max_au_allotment(), aMakeStatus)));
			return aCargo.getTanf_max_au_allotment();

		case TANF_MAX_GRG_ALLOTMENT:
			aCargo.setTanf_max_grg_allotment(String.valueOf(getStatus(aCargo.getTanf_max_grg_allotment(), aMakeStatus)));
			return aCargo.getTanf_max_grg_allotment();

		case CHARITABLE_DONATION:
			aCargo.setCharitable_donation(String.valueOf(getStatus(aCargo.getCharitable_donation(), aMakeStatus)));
			return aCargo.getCharitable_donation();

		case CHILD_NUTRITION_PAYMENTS:
			aCargo.setChild_nutrition_payments(String.valueOf(getStatus(aCargo.getChild_nutrition_payments(), aMakeStatus)));
			return aCargo.getChild_nutrition_payments();

		case BLACK_LUNG_BENEFITS:
			aCargo.setBlack_lung_benefits(String.valueOf(getStatus(aCargo.getBlack_lung_benefits(), aMakeStatus)));
			return aCargo.getBlack_lung_benefits();

		case CHILD_SUPPORT_COURT:
			aCargo.setChild_support_court(String.valueOf(getStatus(aCargo.getChild_support_court(), aMakeStatus)));
			return aCargo.getChild_support_court();

		case CHILD_SUPPORT_GAP_PAYMENT:
			aCargo.setChild_support_gap_payment(String.valueOf(getStatus(aCargo.getChild_support_gap_payment(), aMakeStatus)));
			return aCargo.getChild_support_gap_payment();

		case CIVIL_SERVICE:
			aCargo.setCivil_service(String.valueOf(getStatus(aCargo.getCivil_service(), aMakeStatus)));
			return aCargo.getCivil_service();

		case DEFERRED_COMPENSATION_PLANS:
			aCargo.setDeferred_compensation_plans(String.valueOf(getStatus(aCargo.getDeferred_compensation_plans(), aMakeStatus)));
			return aCargo.getDeferred_compensation_plans();

		case DISABILITY_INSURANCE:
			aCargo.setDisability_insurance(String.valueOf(getStatus(aCargo.getDisability_insurance(), aMakeStatus)));
			return aCargo.getDisability_insurance();

		case EXCLUDED_UNEARNED_INCOME:
			aCargo.setExcluded_unearned_income(String.valueOf(getStatus(aCargo.getExcluded_unearned_income(), aMakeStatus)));
			return aCargo.getExcluded_unearned_income();

		case FEMA_PAYMENT_DISASTER:
			aCargo.setFema_payment_disaster(String.valueOf(getStatus(aCargo.getFema_payment_disaster(), aMakeStatus)));
			return aCargo.getFema_payment_disaster();

		case FEMA_PAYMENT_NON_DISASTER:
			aCargo.setFema_payment_non_disaster(String.valueOf(getStatus(aCargo.getFema_payment_non_disaster(), aMakeStatus)));
			return aCargo.getFema_payment_non_disaster();

		case HEALTH_SAVINGS_ACCOUNT:
			aCargo.setHealth_savings_account(String.valueOf(getStatus(aCargo.getHealth_savings_account(), aMakeStatus)));
			return aCargo.getHealth_savings_account();

		case IN_KIND_SUPPORT:
			aCargo.setIn_kind_support(String.valueOf(getStatus(aCargo.getIn_kind_support(), aMakeStatus)));
			return aCargo.getIn_kind_support();

		case FOSTER_GRANDPARENT_PROGRAM:
			aCargo.setFoster_grandparent_program(String.valueOf(getStatus(aCargo.getFoster_grandparent_program(), aMakeStatus)));
			return aCargo.getFoster_grandparent_program();

		case DISASTER_UNEMPLOYMENT:
			aCargo.setDisaster_unemployment(String.valueOf(getStatus(aCargo.getDisaster_unemployment(), aMakeStatus)));
			return aCargo.getDisaster_unemployment();

		case DIVIDENDS:
			aCargo.setDividends(String.valueOf(getStatus(aCargo.getDividends(), aMakeStatus)));
			return aCargo.getDividends();

		case CHARITABLE_DONATION_FEDERAL:
			aCargo.setCharitable_donation_federal(String.valueOf(getStatus(aCargo.getCharitable_donation_federal(), aMakeStatus)));
			return aCargo.getCharitable_donation_federal();
		case PERSONAL_INFO:
			aCargo.setPersonal_info(String.valueOf(getStatus(aCargo.getPersonal_info(), aMakeStatus)));
			return aCargo.getPersonal_info();

		case PATIENT_FUND:
			aCargo.setPatient_fund(String.valueOf(getStatus(aCargo.getPatient_fund(), aMakeStatus)));
			return aCargo.getPatient_fund();

		case DISASTER_ASSISTANCE:
			aCargo.setDisaster_assistance(String.valueOf(getStatus(aCargo.getDisaster_assistance(), aMakeStatus)));
			return aCargo.getDisaster_assistance();
		case NON_BUSINESS_EQUIPMENT:
			aCargo.setNon_business_equipment(String.valueOf(getStatus(aCargo.getNon_business_equipment(), aMakeStatus)));
			return aCargo.getNon_business_equipment();
		case HOUSEHOLD_GOODS:
			aCargo.setHousehold_goods(String.valueOf(getStatus(aCargo.getHousehold_goods(), aMakeStatus)));
			return aCargo.getHousehold_goods();
		case OTHER_NON_COUNTABLE:
			aCargo.setOther_non_countable(String.valueOf(getStatus(aCargo.getOther_non_countable(), aMakeStatus)));
			return aCargo.getOther_non_countable();

		case LIQ_ASET_CHECKING_ACCOUNT:
			aCargo.setLqd_aset_c_a_resp(String.valueOf(getStatus(aCargo.getLqd_aset_c_a_resp(), aMakeStatus)));
			return aCargo.getLqd_aset_c_a_resp();

		case LIQ_ASET_KEOUGH_PLAN:
			aCargo.setLqd_aset_k_p_resp(String.valueOf(getStatus(aCargo.getLqd_aset_k_p_resp(), aMakeStatus)));
			return aCargo.getLqd_aset_k_p_resp();

		case DEATH_BENEFIT_STATE_FEDERAL:
			aCargo.setDeath_benefit_state_federal(String.valueOf(getStatus(aCargo.getDeath_benefit_state_federal(), aMakeStatus)));
			return aCargo.getDeath_benefit_state_federal();
		case SOCIAL_SECURITY_SURVIVOR:
			aCargo.setSocial_security_survivor(String.valueOf(getStatus(aCargo.getSocial_security_survivor(), aMakeStatus)));
			return aCargo.getSocial_security_survivor();
		case VENDOR_PAYMENTS:
			aCargo.setVendor_payments(String.valueOf(getStatus(aCargo.getVendor_payments(), aMakeStatus)));
			return aCargo.getVendor_payments();
		case INDV_PRGM_CHG_IND:
			aCargo.setIndv_prgm_chg_ind(String.valueOf(getStatus(aCargo.getIndv_prgm_chg_ind(), aMakeStatus)));
			return aCargo.getIndv_prgm_chg_ind();
		case EMPL_HLTH_INS_RESP:
			aCargo.setEmpl_hlth_ins_resp(String.valueOf(getStatus(aCargo.getEmpl_hlth_ins_resp(), aMakeStatus)));
			return aCargo.getEmpl_hlth_ins_resp();
		default:
			log(ILog.INFO, "RMCResponseProfileManager.updateAndGetProfileStatus() - Raising FwException manually on a condition");
			final FwException fe = new FwException("Incorrect field id : " + aFieldId + " passed.");
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("updateAndGetProfileStatus");
			fe.setExceptionType(FwConstants.EXP_TYP_APPLICATION);
			fe.setExceptionText("Incorrect field id : " + aFieldId + " passed.");
			throw fe;
		}
	}

	/**
	 * @see gov.state.nextgen.access.management.applications.IRMCResponseProfileManager#getMaxIndvSeqNumber(gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Collection)
	 */
	@Override
	public int getMaxIndvSeqNumber(final RMC_IN_PRFL_Collection sessionRmcInPrflColl) {
		int maxNum = 0;
		RMC_IN_PRFL_Cargo sessionRmcInPrflCargo = null;
		final int sesAppPrflCollSize = sessionRmcInPrflColl.size();
		for (int i = 0; i < sesAppPrflCollSize; i++) {
			sessionRmcInPrflCargo = (RMC_IN_PRFL_Cargo) sessionRmcInPrflColl.get(i);
			final int seqNum = Integer.parseInt(sessionRmcInPrflCargo.getIndv_seq_num());
			maxNum = Math.max(maxNum, seqNum);
		}

		return maxNum;
	}

	/**
	 * @see gov.state.nextgen.access.management.applications.IRMCResponseProfileManager#getStatus(gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Cargo,
	 *      short, java.lang.String)
	 */
	@Override
	public char getStatus(final RMC_IN_PRFL_Cargo aRmcInPrflCargo, final short detailType, final String costType) {
		try {
			char typeStatus = ' ';
			if (detailType == UTILITY_COST_DETAILS) {
				if ("EL".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getSu_cst_elec_resp().charAt(0);
				} else if ("PH".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getSu_cst_phn_resp().charAt(0);
				} else if ("WA".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getSu_cst_wtr_resp().charAt(0);
				} else if ("GA".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getSu_cst_gas_resp().charAt(0);
				} else if ("LP".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getSu_cst_lpgas_resp().charAt(0);
				} else if ("KE".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getSu_cst_fuel_resp().charAt(0);
				} else if ("WO".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getSu_cst_wood_resp().charAt(0);
				} else if ("CO".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getSu_cst_coal_resp().charAt(0);
				} else if ("TR".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getSu_cst_trsh_resp().charAt(0);
				} else if ("WS".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getSu_cst_wwt_resp().charAt(0);
				} else if ("SE".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getSu_cst_swr_resp().charAt(0);
				} else if ("IN".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getSu_cst_istl_resp().charAt(0);
				} else if ("OT".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getSu_cst_othr_resp().charAt(0);
				}
			} else if (detailType == SHELTER_COST_DETAILS) {
				if ("RM".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getSu_cst_rent_resp().charAt(0);
				} else if ("RE".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getSu_cst_mtge_resp().charAt(0);
				} else if ("HI".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getSu_cst_tax_resp().charAt(0);
				} else if ("NO".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getSu_cst_ins_resp().charAt(0);
				} else if ("OT".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getOther_housing_bill_resp().charAt(0);
				} else if ("DR".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getDisaster_repair_resp().charAt(0);
				} else if ("PE".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getPrevent_eviction_resp().charAt(0);
				} else if ("OH".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getHousing_bill_others_resp().charAt(0);
				} else if ("SA".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getSu_ases_resp().charAt(0);
				}

			} else if (detailType == OTHER_INCOME_DETAILS) {
				if ("AA".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getOthr_incm_trbl_resp().charAt(0);
				} else if ("AN".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getBnft_anty_resp().charAt(0);
				} else if ("CH".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getBnft_chrt_resp().charAt(0);
				} else if ("DS".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getBnft_chl_sprt_resp().charAt(0);
				} else if ("DC".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getChld_sprt_pay_resp().charAt(0);
				} else if ("DI".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getBnft_dabl_resp().charAt(0);
				} else if ("DV".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getBnft_divnd_resp().charAt(0);
				} else if ("FO".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getFstr_care_resp().charAt(0);
				} else if ("GR".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getGen_rlf_resp().charAt(0);
				} else if ("IN".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getIncm_int_resp().charAt(0);
				} else if ("KC".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getKinship_care_resp().charAt(0);
				} else if ("MA".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMil_allot_resp().charAt(0);
				} else if ("MN".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getAlmy_rcv_resp().charAt(0);
				} else if ("MO".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMony_othr_resp().charAt(0);
				} else if ("NA".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getNatl_rfge_resp().charAt(0);
				} else if ("PA".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getPub_asst_resp().charAt(0);
				} else if ("PE".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getPnsn_retr_resp().charAt(0);
				} else if ("CT".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getOther_incm_contrib_resp().charAt(0);
				} else if ("PS".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getLand_cont_resp().charAt(0);
				} else if ("RE".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getResettl_inc_resp().charAt(0);
				} else if ("RR".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getOthr_incm_rentl_resp().charAt(0);
				} else if ("SI".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getRcv_ssi_sw().charAt(0);
				} else if ("SS".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getRcv_ss_resp().charAt(0);
				} else if ("TR".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getBnft_est_trst_resp().charAt(0);
				} else if ("TT".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getTrb_tanf_resp().charAt(0);
				} else if ("UN".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getBnft_uempl_resp().charAt(0);
				} else if ("VE".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getBnft_vet_resp().charAt(0);
				} else if ("WC".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getWork_comp_resp().charAt(0);
				} else if ("OT".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getOthr_src_resp().charAt(0);
				} else if (costType.endsWith("TP")) {
					typeStatus = aRmcInPrflCargo.getTrb_cpta_resp().charAt(0);
				} else if ("AS".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getAdoptAssistance().charAt(0);
				} else if ("AP".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getAdoptionPayments().charAt(0);
				} else if ("AO".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getAgentOrangePayments().charAt(0);
				} else if ("AL".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getAlimony().charAt(0);
				} else if ("CG".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getCapitalGains().charAt(0);
				} else if ("DB".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getDeathBenefits().charAt(0);
				} else if ("DM".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getDisabilityIncome().charAt(0);
				} else if ("DR".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getDisasterRelief().charAt(0);
				} else if ("ED".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getEducationalAssistance().charAt(0);
				} else if ("EA".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getEnergyAssistance().charAt(0);
				} else if ("FA".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getFarmAllotment().charAt(0);
				} else if ("FP".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getFosterCarePayments().charAt(0);
				} else if ("GA".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getGeneralAssistance().charAt(0);
				} else if ("IP".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getInterestDividendPayments().charAt(0);
				} else if ("ID".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getiRADistribution().charAt(0);
				} else if ("LW".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getLotteryWinnings().charAt(0);
				} else if ("LS".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getLumpSum().charAt(0);
				} else if ("MI".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMilitaryAllotment().charAt(0);
				} else if ("MF".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMoneyFromAnotherPerson().charAt(0);
				} else if ("NR".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getNetRentalRoyalty().charAt(0);
				} else if ("OO".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getOtherIncome().charAt(0);
				} else if ("PF".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getPaymentsFromAnnuity().charAt(0);
				} else if ("PB".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getPaymentsMadeOnYourBehalf().charAt(0);
				} else if ("PN".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getPensionOrRetirement().charAt(0);
				} else if ("RT".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getRailroadRetirement().charAt(0);
				} else if ("RC".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getRefugeeCash().charAt(0);
				} else if ("RS".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getRelativeCareSubsidy().charAt(0);
				} else if ("RI".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getRentalIncome().charAt(0);
				} else if ("TN".equals(costType)) {
					typeStatus = aRmcInPrflCargo.gettANFPayments().charAt(0);
				} else if ("UC".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getUnemploymentCompensation().charAt(0);
				} else if ("WS".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getWorkStudyStateFederal().charAt(0);
				} else if ("WO".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getWorkersCompensation().charAt(0);
				} else if ("IGP".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getOth_ind_gambl_pmnts().charAt(0);
				} else if ("IFS".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getIncome_from_resource().charAt(0);
				} else if ("IGPI".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getIndian_gambling_payments().charAt(0);
				} else if ("INH".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getInheritance_income().charAt(0);
				} else if ("IBLI".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getInsuance_benefits().charAt(0);
				} else if ("LR".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getLoan_received().charAt(0);
				} else if ("LRI".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getLoan_repayment_income().charAt(0);
				} else if ("MII".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getManaged_income().charAt(0);
				} else if ("MGRA".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMatch_grant().charAt(0);
				} else if ("MGBP".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMontgomery_gi_bill().charAt(0);
				} else if ("OSPA".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getOut_of_state_public().charAt(0);
				} else if ("RDCH".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getRefunds_from_dch().charAt(0);
				} else if ("RSE".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getRestitutions_settlements().charAt(0);
				} else if ("SCP".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getSenior_companion().charAt(0);
				} else if ("SEV".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getSeverance_pay().charAt(0);
				} else if ("SBT".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getStrike_benefits().charAt(0);
				} else if ("TRA".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getTrade_readjustment().charAt(0);
				} else if ("URAR".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getUniform_relocation().charAt(0);
				} else if ("UF".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getUnion_funds().charAt(0);
				} else if ("V1".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getVendor_excluded().charAt(0);
				} else if ("V3".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getVictim_restitution().charAt(0);
				} else if ("VLP".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getVolunteer_payment().charAt(0);
				} else if ("VLPT".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getVolunteer_payment_titlei().charAt(0);
				} else if ("VLPT".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getVolunteer_payment_titlei().charAt(0);
				} else if ("WIAT".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getWia_training_and_allowance().charAt(0);
				} else if ("IUI".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getIncluded_unearned_income().charAt(0);
				} else if ("3TMA".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getTanf_max_au_allotment().charAt(0);
				} else if ("3TGA".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getTanf_max_grg_allotment().charAt(0);
				} else if ("D1".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getCharitable_donation().charAt(0);
				} else if ("CNP".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getChild_nutrition_payments().charAt(0);
				} else if ("BLB".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getBlack_lung_benefits().charAt(0);
				} else if ("CSCO".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getChild_support_court().charAt(0);
				} else if ("CSGP".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getChild_support_gap_payment().charAt(0);
				} else if ("CSEB".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getCivil_service().charAt(0);
				} else if ("DCP".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getDeferred_compensation_plans().charAt(0);
				} else if ("DIN".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getDisability_insurance().charAt(0);
				} else if ("EUI".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getExcluded_unearned_income().charAt(0);
				} else if ("FDE".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getFema_payment_disaster().charAt(0);
				} else if ("FNDE".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getFema_payment_non_disaster().charAt(0);
				} else if ("HAS".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getHealth_savings_account().charAt(0);
				} else if ("IKS".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getIn_kind_support().charAt(0);
				} else if ("FGPP".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getFoster_grandparent_program().charAt(0);
				} else if ("DIS".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getDisaster_unemployment().charAt(0);
				} else if ("DIV".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getDividends().charAt(0);
				} else if ("DFS".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getCharitable_donation_federal().charAt(0);
				} else if ("DBSF".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getDeath_benefit_state_federal().charAt(0);
				} else if ("SSR".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getSocial_security_survivor().charAt(0);
				} else if ("V2".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getVendor_payments().charAt(0);
				}			
			// EDSP ADding Life Insurance
			} else if (detailType == LIFE_INSURANCE_ASSET_DETAILS) {
				if ("GR".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getLife_ins_asest_group_life_resp().charAt(0);
				} else if ("TM".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getLife_ins_asset_group_term_resp().charAt(0);
				} else if ("GT".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getLife_insurance_asset_term_resp().charAt(0);
				} else if ("UN".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getLife_ins_asset_universal_resp().charAt(0);
				} else if ("WH".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getLife_ins_asset_whole_life_resp().charAt(0);
				} else if ("OT".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getLife_insurance_other_resp().charAt(0);
				}

			} else if (detailType == OTHER_RESOURCE_ASET_DETAILS) {
				if ("BE".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getPers_prop_bus_eqpt().charAt(0);
				} else if ("CL".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getPers_prop_cemetary_lot().charAt(0);
				} else if ("LV".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getPers_prop_livestock().charAt(0);
				} else if ("SB".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getPers_prop_saf_depst_box().charAt(0);
				} else if ("OV".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getPers_prop_oth_val().charAt(0);
				} else if ("DA".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getDisaster_assistance().charAt(0);
				} else if ("NB".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getNon_business_equipment().charAt(0);
				} else if ("HG".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getHousehold_goods().charAt(0);
				} else if ("ON".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getOther_non_countable().charAt(0);
				}

			} else if (detailType == EMPLOYMENT_DETAILS) {
				if ("S".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getOn_strk_sw().charAt(0);
				} else if ("I".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getJob_iknd_resp().charAt(0);
				} else if ("R".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getEmpl_resp().charAt(0);
				} else if("EHI".equals(costType)){
					typeStatus = aRmcInPrflCargo.getEmpl_hlth_ins_resp().charAt(0);
				}			
			// PCR# 40362 - ADDED FOR RMB/SMRF - STARTS
			} else if (detailType == LIQUID_ASSET_DETAILS) {
				// LIQUID ASSET
				if ("IR".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getLiquid_asset_ira_resp().charAt(0);
				} else if ("CAS".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getLiquid_asset_cash_resp().charAt(0);
				} else if ("PN".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getLiquid_asset_promissory_resp().charAt(0);
				} else if ("FA".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getLiquid_asset_bank_acc_resp().charAt(0);
				} else if ("XR".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getLqd_aset_tr_f_resp().charAt(0);
				} else if ("MQ".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getLiquid_aset_disable_blind_resp().charAt(0);
				} else if ("PP".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getLiquid_asset_pension_plan_resp().charAt(0);
				} else if ("SP".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getLiquid_asset_irs_retirmnt_resp().charAt(0);
				} else if ("ST".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getLiquid_asset_stocks_bonds_resp().charAt(0);
				} else if ("TR".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getLiquid_asset_trust_fund_resp().charAt(0);
				} else if ("BD".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getBonds().charAt(0);
				} else if ("DIV".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getDividend().charAt(0);
				} else if ("UNG".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getUniform_gifts_to_minors().charAt(0);
				} else if ("PTF".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getPatient_fund().charAt(0);
				} else if ("OT".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getLiquid_asset_other_response().charAt(0);
				}
			} else if (detailType == LIQUID_ASET_BANK) {
				if ("CA".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getLqd_aset_c_a_resp().charAt(0);
				} else if ("HRA".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getHealth_reimbursement_account().charAt(0);
				} else if ("IDA".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getIndividual_development_account().charAt(0);
				} else if ("IRA".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getLiquid_asset_retirement_resp().charAt(0);
				} else if ("KEO".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getLqd_aset_k_p_resp().charAt(0);
				} else if ("SA".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getLiquid_asset_savings_acc_resp().charAt(0);
				}
			} else if (detailType == VEHICLE_ASSET_DETAILS) {
				if ("AI".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getVeh_aset_arpl_resp().charAt(0);
				} else if ("CAR".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getVehicle_asset_auto_resp().charAt(0);
				} else if ("AN".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getVeh_aset_anml_resp().charAt(0);
				} else if ("WC".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getVehicle_asset_boat_resp().charAt(0);
				} else if ("BU".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getVeh_aset_bus_resp().charAt(0);
				} else if ("CA".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getVehicle_asset_camper_resp().charAt(0);
				} else if ("MC".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getVehicle_asset_motorcycle_resp().charAt(0);
				} else if ("MP".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getVeh_aset_mped_resp().charAt(0);
				} else if ("NB".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getVeh_aset_nm_b_resp().charAt(0);
				} else if ("RV".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getVehicle_asset_recreation_resp().charAt(0);
				} else if ("SN".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getVeh_aset_s_mb_resp().charAt(0);
				} else if ("TK".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getVeh_aset_trk_resp().charAt(0);
				} else if ("TL".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getVeh_aset_trlr_resp().charAt(0);
				} else if ("VA".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getVeh_aset_van_resp().charAt(0);
				} else if ("UL".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getVeh_aset_unlic_resp().charAt(0);
				} else if ("OT".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getVeh_aset_othr_resp().charAt(0);
				} else if ("FT".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getVeh_aset_fmeq_resp().charAt(0);
				} else if ("FI".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getVeh_aset_fimp_resp().charAt(0);
				} else if ("FR".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getVeh_aset_ftrl_resp().charAt(0);
				} else if ("FC".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getVeh_aset_ftrc_resp().charAt(0);
				} else if ("LS".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getVeh_aset_lskd_resp().charAt(0);
				}

			} else if (detailType == REAL_PROPERTY_ASSET_DETAILS) {
				if ("BU".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getReal_aset_apt_resp().charAt(0);
				} else if ("CO".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getReal_aset_con_resp().charAt(0);
				} else if ("DP".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getReal_aset_dup_resp().charAt(0);
				} else if ("FM".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getReal_aset_frm_resp().charAt(0);
				} else if ("LD".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getReal_asset_land_resp().charAt(0);
				} else if ("MH".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getReal_asset_mobile_home_resp().charAt(0);
				} else if ("HO".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getReal_asset_home_resp().charAt(0);
				} else if ("LE".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getReal_asset_life_estate_resp().charAt(0);
				} else if ("RE".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getReal_asset_rental_resp().charAt(0);
				} else if ("HS".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getReal_asset_house_resp().charAt(0);
				} else if ("OT".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getReal_asset_other_resp().charAt(0);
				} else if ("VH".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getReal_aset_vac_resp().charAt(0);
				} else if ("UH".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getReal_asset_unoccupy_home_resp().charAt(0);
				}
			} else if (detailType == BURIAL_ASSET_DETAILS) {
				if ("BN".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getBury_aset_ins_resp().charAt(0);
				} else if ("PLT".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getBury_aset_plt_resp().charAt(0);
				} else if ("CNTRT".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getBury_aset_c_resp().charAt(0);
				} else if ("IT".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getBury_aset_ibt_resp().charAt(0);
				} else if ("MS".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getBury_aset_mas_resp().charAt(0);
				} else if ("RT".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getBury_aset_rbt_resp().charAt(0);
				} else if ("CK".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getBury_aset_c_resp().charAt(0);
				} else if ("VT".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getBury_aset_v_resp().charAt(0);
				} else if ("OT".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getBury_aset_oth_resp().charAt(0);
				} else if ("BA".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getOther_asset_burial_resp().charAt(0);
				}
			} else if (detailType == RECEIVE_MEDICARE) {
				if ("MC".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getRcv_medcr_resp().charAt(0);
				}

			} else if (detailType == OUTSTATE_BNFTS) {
				if ("OF".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getOutstate_bnft_resp().charAt(0);
				}

			} else if (detailType == HOUS_PICE) {
				if ("HP".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getHospice_resp().charAt(0);
				}

			} else if (detailType == WORK_RELATED_EXPENSE_RESP) {
				if ("WE".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getWork_related_expense_resp().charAt(0);
				}

			} else if (detailType == DEPENDENT_CARE) {
				if ("DC".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getDpnd_care_resp().charAt(0);
				}

			} else if (detailType == CHILD_SUPPORT_PAYMENT) {
				if ("SP".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getChld_sprt_pay_resp().charAt(0);
				}

			} else if (detailType == OTHER_BILLS_MEDI_DETAILS) {
				if ("MB".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMedical_bills_resp().charAt(0);
				} else if ("DN".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMedtyp_dental().charAt(0);
				} else if ("AC".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMedtyp_attendant_care().charAt(0);
				} else if ("DR".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMedtyp_doctor().charAt(0);
				} else if ("EQ".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMedtyp_med_equip().charAt(0);
				} else if ("HS".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMedtyp_hosp_bills().charAt(0);
				} else if ("HIP".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMedtyp_insur_premium().charAt(0);
				} else if ("PS".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMedtyp_rx_cost().charAt(0);
				} else if ("TM".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMedtyp_trans_med().charAt(0);
				} else if ("OT".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMedtyp_other().charAt(0);
				} else if ("UM".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getUnpaid_medbill().charAt(0);
				} else if ("MPA".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMedicare_part_a().charAt(0);
				} else if ("MPB".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMedicare_part_b().charAt(0);
				} else if ("MPC".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMedicare_part_c().charAt(0);
				} else if ("MPD".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMedicare_part_d().charAt(0);
				} else if ("CS".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getCssp_provider_payment().charAt(0);
				} else if ("AN".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getAnimals_to_assist_disabled().charAt(0);
				} else if ("FDE".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getFuneral_death_expense().charAt(0);
				} else if ("BWE".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getBlind_work_expense().charAt(0);
				} else if ("IRW".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getImpairment_work_expense().charAt(0);
				}

			} else if (detailType == MEDICAL_EXPENSE) {
				if ("AM".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMed_type_atndnt_meal_resp().charAt(0);
				}
				if ("AN".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMed_type_animal_resp().charAt(0);
				}
				if ("AT".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMed_type_maintain_attndnt_resp().charAt(0);
				}
				if ("CB".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMed_type_inhome_resp().charAt(0);
				}
				if ("DE".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMed_type_special_equip_resp().charAt(0);
				}
				if ("EY".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMed_type_eyeglasses_resp().charAt(0);
				}
				if ("HO".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMed_type_insurance_resp().charAt(0);
				}
				if ("MD".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMed_type_bills_resp().charAt(0);
				}
				if ("ME".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMed_type_supplies_resp().charAt(0);
				}
				if ("NH".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMed_type_nursing_resp().charAt(0);
				}
				if ("OT".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMed_type_other_resp().charAt(0);
				}
				if ("OU".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMed_type_out_patient_resp().charAt(0);
				}
				if ("PS".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMed_type_psychotherapy_resp().charAt(0);
				}
				if ("RX".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMed_type_prescribed_drug_resp().charAt(0);
				}
				if ("TR".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getMed_type_transportation_resp().charAt(0);
				}
			} else if (detailType == AVOID_PROSC_RESP) {
				if ("CV".equals(costType)) {
					typeStatus = aRmcInPrflCargo.getAvoid_prosc_resp().charAt(0);
				}

			} else if (detailType == BNFT_CNVCTN){
				if(AppConstants.CNVCT_TSB.equals(costType)){
					typeStatus = aRmcInPrflCargo.getTrading_snap_resp().charAt(0);
				}
				if(AppConstants.CNVCT_FRI.equals(costType)){
					typeStatus = aRmcInPrflCargo.getConvic_false_info_resp().charAt(0);
				}
				if(AppConstants.CNVCT_TRA.equals(costType)){
					typeStatus = aRmcInPrflCargo.getBuy_sell_snap_resp().charAt(0);
				}
				if(AppConstants.CNVCT_PDS.equals(costType)){
					typeStatus = aRmcInPrflCargo.getDrug_felonies_resp().charAt(0);
				}
				if(AppConstants.CNVCT_SFE.equals(costType)){
					typeStatus = aRmcInPrflCargo.getTrade_snap_gun_resp().charAt(0);
				}
				if(AppConstants.CNVCT_UBU.equals(costType)){
					typeStatus = aRmcInPrflCargo.getTanf_eppic_resp().charAt(0);
				}
				
			}

			// PCR# 40362 - ADDED FOR RMB/SMRF - ENDS
			return typeStatus;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "getStatus", e);
		}
	}

	/**
	 * @see gov.state.nextgen.access.management.applications.IRMCResponseProfileManager#getResponseByType(short,
	 *      java.lang.String)
	 */
	@Override
	public short getResponseByType(final short detailType, final String costType) {
		try {
			short typeConstant = 99;
			if (detailType == UTILITY_COST_DETAILS) {
				if ("EL".equals(costType)) {
					typeConstant = SHELTER_COST_ELECTRICTY;
				} else if ("PH".equals(costType)) {
					typeConstant = SHELTER_COST_PHONE;
				} else if ("WA".equals(costType)) {
					typeConstant = SHELTER_COST_WATER;
				} else if ("GA".equals(costType)) {
					typeConstant = SHELTER_COST_GAS;
				} else if ("LP".equals(costType)) {
					typeConstant = SHELTER_COST_LPGAS;
				} else if ("KE".equals(costType)) {
					typeConstant = SHELTER_COST_FUEL;
				} else if ("WO".equals(costType)) {
					typeConstant = SHELTER_COST_WOOD;
				} else if ("CO".equals(costType)) {
					typeConstant = SHELTER_COST_COAL;
				} else if ("TR".equals(costType)) {
					typeConstant = SHELTER_COST_TRASH;
				} else if ("WS".equals(costType)) {
					typeConstant = SHELTER_COST_WASTE;
				} else if ("SE".equals(costType)) {
					typeConstant = SHELTER_COST_SEWER;
				} else if ("IN".equals(costType)) {
					typeConstant = SHELTER_COST_INSTALL;
				} else if ("OT".equals(costType)) {
					typeConstant = SHELTER_COST_OTHER;
				}
			} else if (detailType == SHELTER_COST_DETAILS) {
				if ("RM".equals(costType)) {
					typeConstant = SHELTER_COST_RENT;
				} else if ("RE".equals(costType)) {
					typeConstant = SHELTER_COST_MORTGAGE;
				} else if ("HI".equals(costType)) {
					typeConstant = SHELTER_COST_TAX;
				} else if ("NO".equals(costType)) {
					typeConstant = SU_CST_INS_RESP;
				} else if ("OT".equals(costType)) {
					typeConstant = OTHER_HOUSING_BILL_RESP;
				} else if ("DR".equals(costType)) {
					typeConstant = DISASTER_REPAIR_RESP;
				} else if ("PE".equals(costType)) {
					typeConstant = PREVENT_EVICTION_RESP;
				} else if ("HI".equals(costType)) {
					typeConstant = SHELTER_COST_HOME;
				} else if ("OH".equals(costType)) {
					typeConstant = HOUSING_BILLS_OTHERS;
				} else if ("SA".equals(costType)) {
					typeConstant = SHELTER_COST_ASSESSMENT;
				}
			} else if (detailType == OTHER_INCOME_DETAILS) {
				if ("BL".equals(costType)) {
					typeConstant = BLACK_LUNG_BENEFIT;
				} else if ("CA".equals(costType)) {
					typeConstant = CASH_GIFTS_CONT;
				} else if ("DS".equals(costType)) {
					typeConstant = BNFT_CHL_SPRT_RESP;
				} else if ("DC".equals(costType)){
					typeConstant = CHILD_SUPPORT_PAYMENT;
				} else if ("DI".equals(costType)) {
					typeConstant = BENEFIT_DISABLE;
				} else if ("FC".equals(costType)) {
					typeConstant = FOOD_CLOTHING_UTIL_RENT;
				} else if ("IH".equals(costType)) {
					typeConstant = INHERITANCE;
				} else if ("IS".equals(costType)) {
					typeConstant = INSURANCE_SETTLEMENT;
				} else if ("LO".equals(costType)) {
					typeConstant = LOAN;
				} else if ("CT".equals(costType)) {
					typeConstant = OTHR_INCM_CONTRIB_RESP;
				} else if ("AA".equals(costType)) {
					typeConstant = OTHR_INCM_TRBL_RESP;
				} else if ("IGP".equals(costType)) {
					typeConstant = OTH_IND_GAMBL_PMNTS;
				} else if ("MA".equals(costType)) {
					typeConstant = MILITARY_ALLOTMENT;
				} else if ("SA".equals(costType)) {
					typeConstant = OTHR_SOCIAL_SECURITY_BENEFITS;
				} else if ("SS".equals(costType)) {
					typeConstant = RECEIVE_SOCIAL_SECURITY;
				} else if ("RM".equals(costType)) {
					typeConstant = ROOM_AND_BOARD;
				} else if ("RE".equals(costType)) {
					typeConstant = RESETTL_INC_RESP;
				} else if ("PA".equals(costType)) {
					typeConstant = PUB_ASST_RESP;
				} else if ("DV".equals(costType)) {
					typeConstant = BENEFIT_DIVIDEND;
				} else if ("TR".equals(costType)) {
					typeConstant = TRAINING_ALLOWANCE;
				} else if ("SI".equals(costType)) {
					typeConstant = RECEIVE_SSI;
				} else if ("SF".equals(costType)) {
					typeConstant = STUDENT_FINANCIAL_AID;
				} else if ("RR".equals(costType)) {
					typeConstant = OTHR_INCM_RENTL_RESP;
				} else if ("MO".equals(costType)) {
					typeConstant = MONEY_FROM_ANOTHER_PERSON;
				} else if ("IN".equals(costType)) {
					typeConstant = INCOME_INTEREST;
				} else if ("WC".equals(costType)) {
					typeConstant = WORKER_COMP;
				} else if ("PE".equals(costType)) {
					typeConstant = PENSION_RETIREMENT;
				} else if ("SB".equals(costType)) {
					typeConstant = STRIKE_BENEFITS_RESP;
				} else if ("PS".equals(costType)) {
					typeConstant = LAND_CONT_RESP;
				} else if ("PR".equals(costType)) {
					typeConstant = LOTTERY_PRIZE_WINNING;
				} else if ("UN".equals(costType)) {
					typeConstant = BENEFIT_UNEMPLOYMENT;
				} else if ("VE".equals(costType)) {
					typeConstant = BENEFIT_VETERAN;
				} else if ("RA".equals(costType)) {
					typeConstant = BENEFIT_RAILROAD_RETIREMENT;
				} else if ("AN".equals(costType)) {
					typeConstant = BENEFIT_ANNUITIES;
				} else if ("CH".equals(costType)) {
					typeConstant = BENEFIT_CHARITY;
				} else if ("OT".equals(costType)) {
					typeConstant = OTHER_SOURCE;
				} else if ("FO".equals(costType)) {
					typeConstant = FOSTER_CARE;
				} else if ("GR".equals(costType)) {
					typeConstant = GENERAL_RELIEF;
				} else if ("KC".equals(costType)) {
					typeConstant = KINSHIP_CARE;
				} else if ("MN".equals(costType)) {
					typeConstant = ALIMONY_RECEIVED;
				} else if ("NA".equals(costType)) {
					typeConstant = REFUGE;
				} else if ("TT".equals(costType)) {
					typeConstant = TRIBAL_TANF;
				} else if ("TP".equals(costType)) {
					typeConstant = TRIBAL_CAPITA;
				} else if ("AS".equals(costType)) {
					typeConstant = UEI_ADOPTION_ASSIST;
				} else if ("AP".equals(costType)) {
					typeConstant = UEI_ADOPTION_PYMT;
				} else if ("AO".equals(costType)) {
					typeConstant = UEI_AGENT_ORNG_PYMT;
				} else if ("AL".equals(costType)) {
					typeConstant = UEI_ALIMONY;
				} else if ("CG".equals(costType)) {
					typeConstant = UEI_CAPITAL_GAINS;
				} else if ("DB".equals(costType)) {
					typeConstant = UEI_DEATH_BNFT;
				} else if ("DM".equals(costType)) {
					typeConstant = UEI_DABL_INCM;
				} else if ("DR".equals(costType)) {
					typeConstant = UEI_DR_RELIEF;
				} else if ("ED".equals(costType)) {
					typeConstant = UEI_EDU_ASSIST;
				} else if ("EA".equals(costType)) {
					typeConstant = UEI_ENERGY_ASSIST;
				} else if ("FA".equals(costType)) {
					typeConstant = UEI_FRM_ALOT;
				} else if ("FP".equals(costType)) {
					typeConstant = UEI_FOSTER_CARE_PYMT;
				} else if ("GA".equals(costType)) {
					typeConstant = UEI_GEN_ASSIST;
				} else if ("IP".equals(costType)) {
					typeConstant = UEI_INT_DIV_PYMT;
				} else if ("ID".equals(costType)) {
					typeConstant = UEI_IRA_DIST;
				} else if ("LW".equals(costType)) {
					typeConstant = UEI_LOTTERY_WIN;
				} else if ("LS".equals(costType)) {
					typeConstant = UEI_LUMP_SUM;
				} else if ("MI".equals(costType)) {
					typeConstant = UEI_MIL_ALOT;
				} else if ("MF".equals(costType)) {
					typeConstant = UEI_MON_FRO_OTH;
				} else if ("NR".equals(costType)) {
					typeConstant = UEI_NET_RENT_ROYALTY;
				} else if ("OO".equals(costType)) {
					typeConstant = UEI_OTH;
				} else if ("OI".equals(costType)) {
					typeConstant = OTHER_INCOME;
				} else if ("PF".equals(costType)) {
					typeConstant = UEI_ANNY_PYMT;
				} else if ("PB".equals(costType)) {
					typeConstant = UEI_PYMT_BO;
				} else if ("PN".equals(costType)) {
					typeConstant = UEI_PENSION;
				} else if ("RT".equals(costType)) {
					typeConstant = UEI_RR_RETIRE;
				} else if ("RC".equals(costType)) {
					typeConstant = UEI_REFUGEE_CASH;
				} else if ("RS".equals(costType)) {
					typeConstant = UEI_REL_CARE;
				} else if ("RI".equals(costType)) {
					typeConstant = UEI_RENTAL_INCM;
				} else if ("TN".equals(costType)) {
					typeConstant = UEI_TANF_PYMT;
				} else if ("UC".equals(costType)) {
					typeConstant = UEI_UNEMPL;
				} else if ("WS".equals(costType)) {
					typeConstant = UEI_WORKER_STUDY;
				} else if ("WO".equals(costType)) {
					typeConstant = UEI_WORKER_COMP;
				} else if ("IFS".equals(costType)) {
					typeConstant = INCOME_FROM_RESOURCE;
				} else if ("IGPI".equals(costType)) {
					typeConstant = INDIAN_GAMBLING_PAYMENTS;
				} else if ("INH".equals(costType)) {
					typeConstant = INHERITANCE_INCOME;
				} else if ("IBLI".equals(costType)) {
					typeConstant = INSUANCE_BENEFITS;
				} else if ("LR".equals(costType)) {
					typeConstant = LOAN_RECEIVED;
				} else if ("LRI".equals(costType)) {
					typeConstant = LOAN_REPAYMENT_INCOME;
				} else if ("MII".equals(costType)) {
					typeConstant = MANAGED_INCOME;
				} else if ("MGRA".equals(costType)) {
					typeConstant = MATCH_GRANT;
				} else if ("MGBP".equals(costType)) {
					typeConstant = MONTGOMERY_GI_BILL;
				} else if ("OSPA".equals(costType)) {
					typeConstant = OUT_OF_STATE_PUBLIC;
				} else if ("RDCH".equals(costType)) {
					typeConstant = REFUNDS_FROM_DCH;
				} else if ("RSE".equals(costType)) {
					typeConstant = RESTITUTIONS_SETTLEMENTS;
				} else if ("SCP".equals(costType)) {
					typeConstant = SENIOR_COMPANION;
				} else if ("SEV".equals(costType)) {
					typeConstant = SEVERANCE_PAY;
				} else if ("SBT".equals(costType)) {
					typeConstant = STRIKE_BENEFITS;
				} else if ("TRA".equals(costType)) {
					typeConstant = TRADE_READJUSTMENT;
				} else if ("URAR".equals(costType)) {
					typeConstant = UNIFORM_RELOCATION;
				} else if ("UF".equals(costType)) {
					typeConstant = UNION_FUNDS;
				} else if ("V1".equals(costType)) {
					typeConstant = VENDOR_EXCLUDED;
				} else if ("V3".equals(costType)) {
					typeConstant = VICTIM_RESTITUTION;
				} else if ("VLP".equals(costType)) {
					typeConstant = VOLUNTEER_PAYMENT;
				} else if ("VLPT".equals(costType)) {
					typeConstant = VOLUNTEER_PAYMENT_TITLEI;
				} else if ("WIAT".equals(costType)) {
					typeConstant = WIA_TRAINING_AND_ALLOWANCE;
				} else if ("IUI".equals(costType)) {
					typeConstant = INCLUDED_UNEARNED_INCOME;
				} else if ("3TMA".equals(costType)) {
					typeConstant = TANF_MAX_AU_ALLOTMENT;
				} else if ("3TGA".equals(costType)) {
					typeConstant = TANF_MAX_GRG_ALLOTMENT;
				} else if ("D1".equals(costType)) {
					typeConstant = CHARITABLE_DONATION;
				} else if ("CNP".equals(costType)) {
					typeConstant = CHILD_NUTRITION_PAYMENTS;
				} else if ("BLB".equals(costType)) {
					typeConstant = BLACK_LUNG_BENEFITS;
				} else if ("CSCO".equals(costType)) {
					typeConstant = CHILD_SUPPORT_COURT;
				} else if ("CSGP".equals(costType)) {
					typeConstant = CHILD_SUPPORT_GAP_PAYMENT;
				} else if ("CSEB".equals(costType)) {
					typeConstant = CIVIL_SERVICE;
				} else if ("DCP".equals(costType)) {
					typeConstant = DEFERRED_COMPENSATION_PLANS;
				} else if ("DIN".equals(costType)) {
					typeConstant = DISABILITY_INSURANCE;
				} else if ("EUI".equals(costType)) {
					typeConstant = EXCLUDED_UNEARNED_INCOME;
				} else if ("FDE".equals(costType)) {
					typeConstant = FEMA_PAYMENT_DISASTER;
				} else if ("FNDE".equals(costType)) {
					typeConstant = FEMA_PAYMENT_NON_DISASTER;
				} else if ("HAS".equals(costType)) {
					typeConstant = HEALTH_SAVINGS_ACCOUNT;
				} else if ("IKS".equals(costType)) {
					typeConstant = IN_KIND_SUPPORT;
				} else if ("FGPP".equals(costType)) {
					typeConstant = FOSTER_GRANDPARENT_PROGRAM;
				} else if ("DIS".equals(costType)) {
					typeConstant = DISASTER_UNEMPLOYMENT;
				} else if ("DIV".equals(costType)) {
					typeConstant = DIVIDENDS;
				} else if ("DFS".equals(costType)) {
					typeConstant = CHARITABLE_DONATION_FEDERAL;
				} else if ("DBSF".equals(costType)) {
					typeConstant = DEATH_BENEFIT_STATE_FEDERAL;
				} else if ("SSR".equals(costType)) {
					typeConstant = SOCIAL_SECURITY_SURVIVOR;
				} else if ("V2".equals(costType)) {
					typeConstant = VENDOR_PAYMENTS;
				}

			} else if (detailType == EMPLOYMENT_DETAILS) {
				if ("R".equals(costType)) {
					typeConstant = REGULAR_EMPL;
				} else if ("I".equals(costType)) {
					typeConstant = JOB_IN_KIND;
				} else if ("S".equals(costType)) {
					typeConstant = SELF_EMPLOYMENT;
				} else if ("EHI".equals(costType)){
					typeConstant = EMPL_HLTH_INS_RESP;
				}
			} else if (detailType == AVOID_PROSC_RESP) {
				if ("CV".equals(costType)) {
					typeConstant = AVOID_PROSC_RESP;
				}
			} else if (detailType == LIQUID_ASSET_DETAILS) {
				if ("IR".equals(costType)) {
					typeConstant = LIQUID_ASSET_IRA;
				} else if ("ST".equals(costType)) {
					typeConstant = LIQUID_ASSET_STOCK_BONDS;
				} else if ("MQ".equals(costType)) {
					typeConstant = LIQUID_ASSET_ANNUITY;
				} else if ("SP".equals(costType)) {
					typeConstant = LIQUID_ASSET_IRS_RET;
				} else if ("TR".equals(costType)) {
					typeConstant = LIQUID_ASSET_TRUST_FUND;
				} else if ("CAS".equals(costType)) {
					typeConstant = LIQ_ASET_CASH;//first:7
				} else if ("XR".equals(costType)) {
					typeConstant = LIQUID_ASSET_XFER;//first:7
				} else if ("PP".equals(costType)) {
					typeConstant = LIQUID_ASSET_PENSION_PLAN;
				} else if ("PN".equals(costType)) {
					typeConstant = LIQUID_ASSET_PROMISSORY;
				} else if ("OT".equals(costType)) {
					typeConstant = LIQUID_ASSET_OTHER;
				} else if ("FA".equals(costType)) {
					typeConstant = LIQUID_ASET_BANK;//first:6
				} else if ("BD".equals(costType)) {
					typeConstant = BONDS;
				} else if ("DIV".equals(costType)) {
					typeConstant = DIVIDEND;
				} else if ("UNG".equals(costType)) {
					typeConstant = UNIFORM_GIFTS_TO_MINORS;
				} else if ("PTF".equals(costType)) {
					typeConstant = PATIENT_FUND;
				}

			} else if (detailType == LIQUID_ASET_BANK) {
				if ("CA".equals(costType)) {
					typeConstant = LIQ_ASET_CHECKING_ACCOUNT;
				} else if ("HRA".equals(costType)) {
					typeConstant = HEALTH_REIMBURSEMENT_ACCOUNT;
				} else if ("IDA".equals(costType)) {
					typeConstant = INDIVIDUAL_DEVELOPMENT_ACCOUNT;
				} else if ("IRA".equals(costType)) {
					typeConstant = LIQUID_ASSET_RETIREMENT;
				} else if ("KEO".equals(costType)) {
					typeConstant = LIQ_ASET_KEOUGH_PLAN;
				} else if ("SA".equals(costType)) {
					typeConstant = LIQUID_ASSET_SAVINGS_ACC;
				}
			} else if (detailType == VEHICLE_ASSET_DETAILS) {
				if ("AI".equals(costType)) {
					typeConstant = VEH_ASET_AIRPLANE;
				} else if ("CAR".equals(costType)) {
					typeConstant = VEH_ASET_AUTOMOBILE;
				} else if ("WC".equals(costType)) {
					typeConstant = VEH_ASET_BOAT;
				} else if ("CA".equals(costType)) {
					typeConstant = VEH_ASET_CAMPER;
				} else if ("MC".equals(costType)) {
					typeConstant = VEH_ASET_MOTORCYCLE;
				} else if ("MP".equals(costType)) {
					typeConstant = VEH_ASET_MOPED;
				} else if ("NB".equals(costType)) {
					typeConstant = VEH_ASET_NONMOTORIZED_BOAT;
				} else if ("RV".equals(costType)) {
					typeConstant = VEH_ASET_RECREATIONAL_VEHICLE;
				} else if ("SN".equals(costType)) {
					typeConstant = VEH_ASET_SNOWMOBILE;
				} else if ("TK".equals(costType)) {
					typeConstant = VEH_ASET_TRUCK;
				} else if ("UL".equals(costType)) {
					typeConstant = VEH_ASET_UNLIC;
				} else if ("TL".equals(costType)) {
					typeConstant = VEH_ASET_TRAVEL_TRAILER;
				} else if ("VA".equals(costType)) {
					typeConstant = VEH_ASET_VAN;
				} else if ("OT".equals(costType)) {
					typeConstant = VEH_ASET_OTHER;
				} else if ("FT".equals(costType)) {
					typeConstant = VEH_ASET_FARM_EQUIP;
				} else if ("FI".equals(costType)) {
					typeConstant = VEH_ASET_FARM_IMPLEMENT;
				} else if ("FR".equals(costType)) {
					typeConstant = VEH_ASET_FARM_TRAILER;
				} else if ("FC".equals(costType)) {
					typeConstant = VEH_ASET_FARM_TRACTOR;
				} else if ("LS".equals(costType)) {
					typeConstant = VEH_ASET_LOG_SKIDDER;
				} else if ("BU".equals(costType)) {
					typeConstant = VEH_ASET_BUS;
				} else if ("AN".equals(costType)) {
					typeConstant = VEH_ASET_ANIMAL_DRAWN;
				} else if ("FTT".equals(costType)) {
					typeConstant = VEH_ASET_TRACTOR;
				} else if ("GC".equals(costType)) {
					typeConstant = VEH_ASET_GOLFCART;
				} else if ("NC".equals(costType)) {
					typeConstant = VEH_ASET_NONMOTORIZED_CAMPER;
				}
			} else if (detailType == REAL_PROPERTY_ASSET_DETAILS) {
				if ("BU".equals(costType)) {
					typeConstant = REAL_ASET_APARTMENT;
				} else if ("CO".equals(costType)) {
					typeConstant = REAL_ASET_CONDO;
				} else if ("DP".equals(costType)) {
					typeConstant = REAL_ASET_DUPLEX;
				} else if ("FM".equals(costType)) {
					typeConstant = REAL_ASET_FARM;
				} else if ("LD".equals(costType)) {
					typeConstant = REAL_ASET_LAND;
				} else if ("MH".equals(costType)) {
					typeConstant = REAL_ASET_MOBILE_HOME;
				} else if ("OT".equals(costType)) {
					typeConstant = REAL_ASET_OTHER;				
				// EDSP CP ADD Starts:Real Estate Types-home,life
				// estate,unoccupied home
				} else if ("HO".equals(costType)) {
					typeConstant = REAL_ASET_HOME;
				} else if ("LE".equals(costType)) {
					typeConstant = REAL_ASET_LIFE_ESTATE;
				} else if ("RE".equals(costType)) {
					typeConstant = REAL_ASET_RENTAL;
				} else if ("HS".equals(costType)) {
					typeConstant = REAL_ASET_HOUSE;
				} else if ("UH".equals(costType)) {
					typeConstant = REAL_ASET_UNOCCUPY_HOME;
				} else if ("VH".equals(costType)) {
					typeConstant = REAL_ASET_VAC;
				}

				// EDSP CP ADD Ends:Real Estate Types-home,life
				// estate,unoccupied home
			} else if (detailType == BURIAL_ASSET_DETAILS) {
				if ("BI".equals(costType)) {
					typeConstant = BUR_AST_INSURANCE;				
				// IN-Pre Work: Changes for Reference Table Sync
				} else if ("PLT".equals(costType)) {
					typeConstant = BUR_AST_PLOT;
				} else if ("RT".equals(costType)) {
					typeConstant = BUR_AST_IRREVOCABLE;
				} else if ("MS".equals(costType)) {
					typeConstant = BUR_AST_MAUSOLEUM;
				} else if ("RT".equals(costType)) {
					typeConstant = BUR_AST_REVOCABLE;
				} else if ("OT".equals(costType)) {
					typeConstant = BUR_AST_OTHER;				
				// IN-Pre Work: Changes for Reference Table Sync
				} else if ("CNTRT".equals(costType)) {
					typeConstant = BUR_AST_CASKET;
				} else if ("VT".equals(costType)) {
					typeConstant = BUR_AST_VAULT;
				} else if ("BA".equals(costType)) {
					typeConstant = OTHR_ASET_BURIAL;
				}
			} else if (detailType == LIFE_INSURANCE_ASSET_DETAILS) {
				if ("GR".equals(costType)) {
					typeConstant = LIFE_INS_ASEST_GROUP_LIFE_RESP;
				} else if ("TM".equals(costType)) {
					typeConstant = LIFE_INS_ASSET_GROUP_TERM_RESP;
				} else if ("GT".equals(costType)) {
					typeConstant = LIFE_INSURANCE_ASSET_TERM_RESP;
				} else if ("UN".equals(costType)) {
					typeConstant = LIFE_INS_ASSET_UNIVERSAL_RESP;
				} else if ("WH".equals(costType)) {
					typeConstant = LIFE_INS_ASSET_WHOLE_LIFE_RESP;
				} else if ("OT".equals(costType)) {
					typeConstant = LIFE_INSURANCE_OTHER_RESP;
				}
			} else if (detailType == OTHER_RESOURCE_ASET_DETAILS) {
				if ("BE".equals(costType)) {
					typeConstant = PERS_PROP_BUS_EQPT;
				} else if ("CL".equals(costType)) {
					typeConstant = PERS_PROP_CEMETARY_LOT;
				} else if ("LV".equals(costType)) {
					typeConstant = PERS_PROP_LIVESTOCK;
				} else if ("SB".equals(costType)) {
					typeConstant = PERS_PROP_SAF_DEPST_BOX;
				} else if ("OV".equals(costType)) {
					typeConstant = PERS_PROP_OTH_VAL;
				} else if ("DA".equals(costType)) {
					typeConstant = DISASTER_ASSISTANCE;
				} else if ("NB".equals(costType)) {
					typeConstant = NON_BUSINESS_EQUIPMENT;
				} else if ("HG".equals(costType)) {
					typeConstant = HOUSEHOLD_GOODS;
				} else if ("ON".equals(costType)) {
					typeConstant = OTHER_NON_COUNTABLE;
				}
			} else if (detailType == RECEIVE_MEDICARE) {
				if ("MC".equals(costType)) {
					typeConstant = RECEIVE_MEDICARE;
				}

			} else if (detailType == OUTSTATE_BNFTS) {
				if ("OF".equals(costType)) {
					typeConstant = OUTSTATE_BNFTS;
				}

			} else if (detailType == HOUS_PICE) {
				if ("HP".equals(costType)) {
					typeConstant = HOUS_PICE;
				}

			} else if (detailType == WORK_RELATED_EXPENSE_RESP) {
				if ("WE".equals(costType)) {
					typeConstant = WORK_RELATED_EXPENSE_RESP;
				}

			} else if (detailType == DEPENDENT_CARE) {
				if ("DC".equals(costType)) {
					typeConstant = DEPENDENT_CARE;
				}

			} else if (detailType == CHILD_SUPPORT_PAYMENT) {
				if ("SP".equals(costType)) {
					typeConstant = CHILD_SUPPORT_PAYMENT;
				}

			} else if (detailType == CHILD_CARE_RESP) {
				if ("CCB".equals(costType)) {
					typeConstant = CHILD_CARE_RESP;
				}

			} else if (detailType == CHILD_OBLIGATION_RESP) {
				if ("CT".equals(costType)) {
					typeConstant = CHILD_OBLIGATION_RESP;
				}
			} else if (detailType == OTHER_BILLS_MEDI_DETAILS) {
				if ("MB".equals(costType)) {
					typeConstant = MEDICAL_BILLS_RESP;
				}
				if ("DN".equals(costType)) {
					typeConstant = MEDTYP_DENTAL;
				}
				if ("AC".equals(costType)) {
					typeConstant = MEDTYP_ATTENDANT_CARE;
				}
				if ("DR".equals(costType)) {
					typeConstant = MEDTYP_DOCTOR;
				}
				if ("EQ".equals(costType)) {
					typeConstant = MEDTYP_MED_EQUIP;
				}
				if ("HS".equals(costType)) {
					typeConstant = MEDTYP_HOSP_BILLS;
				}
				if ("HIP".equals(costType)) {
					typeConstant = MEDTYP_INSUR_PREMIUM;
				}
				if ("PS".equals(costType)) {
					typeConstant = MEDTYP_RX_COST;
				}
				if ("TM".equals(costType)) {
					typeConstant = MEDTYP_TRANS_MED;
				}
				if ("OT".equals(costType)) {
					typeConstant = MEDTYP_OTHER;
				}
				if ("UM".equals(costType)) {
					typeConstant = UNPAID_MEDBILL;
				}
				if ("MPA".equals(costType)) {
					typeConstant = MEDICARE_PART_A;
				}
				if ("MPB".equals(costType)) {
					typeConstant = MEDICARE_PART_B;
				}
				if ("MPC".equals(costType)) {
					typeConstant = MEDICARE_PART_C;
				}
				if ("MPD".equals(costType)) {
					typeConstant = MEDICARE_PART_D;
				}
				if ("CS".equals(costType)) {
					typeConstant = CCSP_PROVIDER_PAYMENT;
				}
				if ("AN".equals(costType)) {
					typeConstant = ANIMALS_TO_ASSIST_DISABLED;
				}
				if ("FDE".equals(costType)) {
					typeConstant = FUNERAL_DEATH_EXPENSE;
				}
				if ("BWE".equals(costType)) {
					typeConstant = BLIND_WORK_EXPENSE;
				}
				if ("IRW".equals(costType)) {
					typeConstant = IMPAIRMENT_WORK_EXPENSE;
				}

			} else if (detailType == MEDICAL_EXPENSE) {
				if ("AI".equals(costType)) {
					typeConstant = MED_TYPE_PROSTHETIC_RESP;
				}
				if ("AM".equals(costType)) {
					typeConstant = MED_TYPE_ATNDNT_MEAL_RESP;
				}
				if ("AN".equals(costType)) {
					typeConstant = MED_TYPE_ANIMAL_RESP;
				}
				if ("AT".equals(costType)) {
					typeConstant = MED_TYPE_MAINTAIN_ATTNDNT_RESP;
				}
				if ("CB".equals(costType)) {
					typeConstant = MED_TYPE_INHOME_RESP;
				}
				if ("DE".equals(costType)) {
					typeConstant = MED_TYPE_SPECIAL_EQUIP_RESP;
				}
				if ("EY".equals(costType)) {
					typeConstant = MED_TYPE_EYEGLASSES_RESP;
				}
				if ("HO".equals(costType)) {
					typeConstant = MED_TYPE_INSURANCE_RESP;
				}
				if ("MD".equals(costType)) {
					typeConstant = MED_TYPE_BILLS_RESP;
				}
				if ("ME".equals(costType)) {
					typeConstant = MED_TYPE_SUPPLIES_RESP;
				}
				if ("NH".equals(costType)) {
					typeConstant = MED_TYPE_NURSING_RESP;
				}
				if ("OT".equals(costType)) {
					typeConstant = MED_TYPE_OTHER_RESP;
				}
				if ("OU".equals(costType)) {
					typeConstant = MED_TYPE_OUT_PATIENT_RESP;
				}
				if ("PS".equals(costType)) {
					typeConstant = MED_TYPE_PSYCHOTHERAPY_RESP;
				}
				if ("RX".equals(costType)) {
					typeConstant = MED_TYPE_PRESCRIBED_DRUG_RESP;
				}
				if ("TR".equals(costType)) {
					typeConstant = MED_TYPE_TRANSPORTATION_RESP;
				}

			} else if (detailType == PRSN_INFO_STAT_SW){
				if ("PI".equals(costType)) {
					typeConstant = PRSN_INFO_STAT_SW;
				}
			} else if (detailType == CITIZENSHIP_INFO){
				if ("CI".equals(costType)) {
					typeConstant = CITIZENSHIP_INFO;
				}
			} else if (detailType == BNFT_CNVCTN){
				if(AppConstants.CNVCT_TSB.equals(costType)){
					typeConstant = TRADING_SNAP_RESP;
				}
				if(AppConstants.CNVCT_FRI.equals(costType)){
					typeConstant = CONVIC_FALSE_INFO_RESP;
				}
				if(AppConstants.CNVCT_TRA.equals(costType)){
					typeConstant = BUY_SELL_SNAP_RESP;
				}
				if(AppConstants.CNVCT_PDS.equals(costType)){
					typeConstant = DRUG_FELONIES_RESP;
				}
				if(AppConstants.CNVCT_SFE.equals(costType)){
					typeConstant = TRADE_SNAP_GUN_RESP;
				}
				if(AppConstants.CNVCT_UBU.equals(costType)){
					typeConstant = TANF_EPPIC_RESP;
				}
				if(AppConstants.CNVCT_DFT.equals(costType)){
					typeConstant = TANF_DISC_RESP;
				}
				if(AppConstants.CNVCT_VQJ.equals(costType)){
					typeConstant = VOLUNTARILY_QUIT_JOB_RESP;
				}
				
			}
			// PCR# 40362 - ADDED FOR RMB/SMRF CHANGES - ENDS
			return typeConstant;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "getResponseByType", e);
		}
	}

	@Override
	public String getOtherIncomeTypeByResponse(final short response) {
		try {

			if (otherIncomeTypeResponseMap.isEmpty()) {
				otherIncomeTypeResponseMap.put(String.valueOf(BNFT_CHL_SPRT_RESP), "DS");
				otherIncomeTypeResponseMap.put(String.valueOf(CHILD_SUPPORT_PAYMENT), "DC");
				otherIncomeTypeResponseMap.put(String.valueOf(RECEIVE_SSI), "SI");
				otherIncomeTypeResponseMap.put(String.valueOf(RECEIVE_SOCIAL_SECURITY), "SS");
				otherIncomeTypeResponseMap.put(String.valueOf(BENEFIT_VETERAN), "VE");
				otherIncomeTypeResponseMap.put(String.valueOf(OTHR_INCM_CONTRIB_RESP), "CT");
				otherIncomeTypeResponseMap.put(String.valueOf(OTHR_INCM_TRBL_RESP), "AA");
				otherIncomeTypeResponseMap.put(String.valueOf(OTHER_INCOME), "OI");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_ADOPTION_ASSIST), "AS");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_ADOPTION_PYMT), "AP");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_AGENT_ORNG_PYMT), "AO");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_ALIMONY), "AL");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_CAPITAL_GAINS), "CG");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_DEATH_BNFT), "DB");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_DABL_INCM), "DM");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_DR_RELIEF), "DR");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_EDU_ASSIST), "ED");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_ENERGY_ASSIST), "EA");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_FRM_ALOT), "FA");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_FOSTER_CARE_PYMT), "FP");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_GEN_ASSIST), "GA");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_INT_DIV_PYMT), "IP");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_IRA_DIST), "ID");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_LOTTERY_WIN), "LW");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_LUMP_SUM), "LS");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_MIL_ALOT), "MI");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_MON_FRO_OTH), "MF");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_NET_RENT_ROYALTY), "NR");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_OTH), "OO");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_ANNY_PYMT), "PF");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_PYMT_BO), "PB");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_PENSION), "PN");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_RR_RETIRE), "RT");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_REFUGEE_CASH), "RC");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_REL_CARE), "RS");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_RENTAL_INCM), "RI");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_TANF_PYMT), "TN");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_UNEMPL), "UC");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_WORKER_STUDY), "WS");
				otherIncomeTypeResponseMap.put(String.valueOf(UEI_WORKER_COMP), "WO");
				otherIncomeTypeResponseMap.put(String.valueOf(OTH_IND_GAMBL_PMNTS), "IGP");

				otherIncomeTypeResponseMap.put(String.valueOf(INCOME_FROM_RESOURCE), "IFS");
				otherIncomeTypeResponseMap.put(String.valueOf(INDIAN_GAMBLING_PAYMENTS), "IGPI");
				otherIncomeTypeResponseMap.put(String.valueOf(INHERITANCE_INCOME), "INH");
				otherIncomeTypeResponseMap.put(String.valueOf(INSUANCE_BENEFITS), "IBLI");
				otherIncomeTypeResponseMap.put(String.valueOf(LOAN_RECEIVED), "LR");
				otherIncomeTypeResponseMap.put(String.valueOf(LOAN_REPAYMENT_INCOME), "LRI");
				otherIncomeTypeResponseMap.put(String.valueOf(MANAGED_INCOME), "MII");
				otherIncomeTypeResponseMap.put(String.valueOf(MATCH_GRANT), "MGRA");
				otherIncomeTypeResponseMap.put(String.valueOf(MONTGOMERY_GI_BILL), "MGBP");
				otherIncomeTypeResponseMap.put(String.valueOf(OUT_OF_STATE_PUBLIC), "OSPA");

				otherIncomeTypeResponseMap.put(String.valueOf(REFUNDS_FROM_DCH), "RDCH");
				otherIncomeTypeResponseMap.put(String.valueOf(RESTITUTIONS_SETTLEMENTS), "RSE");
				otherIncomeTypeResponseMap.put(String.valueOf(SENIOR_COMPANION), "SCP");
				otherIncomeTypeResponseMap.put(String.valueOf(SEVERANCE_PAY), "SEV");
				otherIncomeTypeResponseMap.put(String.valueOf(STRIKE_BENEFITS), "SBT");
				otherIncomeTypeResponseMap.put(String.valueOf(TRADE_READJUSTMENT), "TRA");
				otherIncomeTypeResponseMap.put(String.valueOf(UNIFORM_RELOCATION), "URAR");
				otherIncomeTypeResponseMap.put(String.valueOf(UNION_FUNDS), "UF");
				otherIncomeTypeResponseMap.put(String.valueOf(VENDOR_EXCLUDED), "V1");
				otherIncomeTypeResponseMap.put(String.valueOf(VICTIM_RESTITUTION), "V3");

				otherIncomeTypeResponseMap.put(String.valueOf(VOLUNTEER_PAYMENT), "VLP");
				otherIncomeTypeResponseMap.put(String.valueOf(VOLUNTEER_PAYMENT_TITLEI), "VLPT");
				otherIncomeTypeResponseMap.put(String.valueOf(WIA_TRAINING_AND_ALLOWANCE), "WIAT");
				otherIncomeTypeResponseMap.put(String.valueOf(INCLUDED_UNEARNED_INCOME), "IUI");
				otherIncomeTypeResponseMap.put(String.valueOf(TANF_MAX_AU_ALLOTMENT), "3TMA");
				otherIncomeTypeResponseMap.put(String.valueOf(TANF_MAX_GRG_ALLOTMENT), "3TGA");
				otherIncomeTypeResponseMap.put(String.valueOf(CHARITABLE_DONATION), "D1");
				otherIncomeTypeResponseMap.put(String.valueOf(CHILD_NUTRITION_PAYMENTS), "CNP");
				otherIncomeTypeResponseMap.put(String.valueOf(BLACK_LUNG_BENEFITS), "BLB");
				otherIncomeTypeResponseMap.put(String.valueOf(CHILD_SUPPORT_COURT), "CSCO");

				otherIncomeTypeResponseMap.put(String.valueOf(CHILD_SUPPORT_GAP_PAYMENT), "CSGP");
				otherIncomeTypeResponseMap.put(String.valueOf(CIVIL_SERVICE), "CSEB");
				otherIncomeTypeResponseMap.put(String.valueOf(DEFERRED_COMPENSATION_PLANS), "DCP");
				otherIncomeTypeResponseMap.put(String.valueOf(DISABILITY_INSURANCE), "DIN");
				otherIncomeTypeResponseMap.put(String.valueOf(EXCLUDED_UNEARNED_INCOME), "EUI");
				otherIncomeTypeResponseMap.put(String.valueOf(FEMA_PAYMENT_DISASTER), "FDE");
				otherIncomeTypeResponseMap.put(String.valueOf(FEMA_PAYMENT_NON_DISASTER), "FNDE");
				otherIncomeTypeResponseMap.put(String.valueOf(HEALTH_SAVINGS_ACCOUNT), "HAS");
				otherIncomeTypeResponseMap.put(String.valueOf(IN_KIND_SUPPORT), "IKS");
				otherIncomeTypeResponseMap.put(String.valueOf(FOSTER_GRANDPARENT_PROGRAM), "FGPP");

				otherIncomeTypeResponseMap.put(String.valueOf(DISASTER_UNEMPLOYMENT), "DIS");
				otherIncomeTypeResponseMap.put(String.valueOf(DIVIDENDS), "DIV");
				otherIncomeTypeResponseMap.put(String.valueOf(CHARITABLE_DONATION_FEDERAL), "DFS");
				otherIncomeTypeResponseMap.put(String.valueOf(DEATH_BENEFIT_STATE_FEDERAL), "DBSF");
				otherIncomeTypeResponseMap.put(String.valueOf(SOCIAL_SECURITY_SURVIVOR), "SSR");
				otherIncomeTypeResponseMap.put(String.valueOf(VENDOR_PAYMENTS), "V2");

			}

			final String typeForResponse = (String) otherIncomeTypeResponseMap.get(String.valueOf(response));
			if (typeForResponse != null) {
				return typeForResponse;
			}
			return "";
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "getTypeByResponse", e);
		}

	}

	@Override
	public String getTypeByResponse(final short response) {
		try {
			if (typeResponseMap.isEmpty()) {
				typeResponseMap.put(String.valueOf(SHELTER_COST_ELECTRICTY), "EL");
				typeResponseMap.put(String.valueOf(SHELTER_COST_PHONE), "PH");
				typeResponseMap.put(String.valueOf(SHELTER_COST_WATER), "WA");
				typeResponseMap.put(String.valueOf(SHELTER_COST_GAS), "GA");
				typeResponseMap.put(String.valueOf(SHELTER_COST_LPGAS), "LP");
				typeResponseMap.put(String.valueOf(SHELTER_COST_FUEL), "KE");
				typeResponseMap.put(String.valueOf(SHELTER_COST_WOOD), "WO");
				typeResponseMap.put(String.valueOf(SHELTER_COST_COAL), "CO");
				typeResponseMap.put(String.valueOf(SHELTER_COST_TRASH), "TR");
				typeResponseMap.put(String.valueOf(SHELTER_COST_WASTE), "WS");
				typeResponseMap.put(String.valueOf(SHELTER_COST_SEWER), "SE");
				typeResponseMap.put(String.valueOf(SHELTER_COST_INSTALL), "IN");
				typeResponseMap.put(String.valueOf(SHELTER_COST_OTHER), "OT");
				typeResponseMap.put(String.valueOf(SHELTER_COST_HOME), "HI");
				typeResponseMap.put(String.valueOf(SHELTER_COST_MORTGAGE), "RE");
				typeResponseMap.put(String.valueOf(SHELTER_COST_TAX), "HI");
				typeResponseMap.put(String.valueOf(SHELTER_COST_RENT), "RM");
				typeResponseMap.put(String.valueOf(HOUSING_BILLS_OTHERS), "OH");
				typeResponseMap.put(String.valueOf(SHELTER_COST_ASSESSMENT), "SA");
				typeResponseMap.put(String.valueOf(OTHR_INCM_TRBL_RESP), "AA");
				typeResponseMap.put(String.valueOf(PUB_ASST_RESP), "PA");
				typeResponseMap.put(String.valueOf(BNFT_CHL_SPRT_RESP), "DS");
				typeResponseMap.put(String.valueOf(OTHR_INCM_CONTRIB_RESP), "CT");
				typeResponseMap.put(String.valueOf(INCOME_INTEREST), "IN");
				typeResponseMap.put(String.valueOf(BENEFIT_ANNUITIES), "AN");
				typeResponseMap.put(String.valueOf(BENEFIT_CHARITY), "CH");
				typeResponseMap.put(String.valueOf(BENEFIT_DISABLE), "DI");
				typeResponseMap.put(String.valueOf(BENEFIT_DIVIDEND), "DV");
				typeResponseMap.put(String.valueOf(FOSTER_CARE), "FO");
				typeResponseMap.put(String.valueOf(GENERAL_RELIEF), "GR");
				typeResponseMap.put(String.valueOf(KINSHIP_CARE), "KC");
				typeResponseMap.put(String.valueOf(MILITARY_ALLOTMENT), "MA");
				typeResponseMap.put(String.valueOf(ALIMONY_RECEIVED), "MN");
				typeResponseMap.put(String.valueOf(MONEY_FROM_ANOTHER_PERSON), "MO");
				typeResponseMap.put(String.valueOf(REFUGE), "NA");
				typeResponseMap.put(String.valueOf(OTHER_SOURCE), "OT");
				typeResponseMap.put(String.valueOf(PENSION_RETIREMENT), "PE");
				typeResponseMap.put(String.valueOf(PROPERTY_SOLD), "PS");
				typeResponseMap.put(String.valueOf(NEEDY_INDIAN), "RE");
				typeResponseMap.put(String.valueOf(BENEFIT_RAILROAD_RETIREMENT), "RR");
				typeResponseMap.put(String.valueOf(RECEIVE_SSI), "SI");
				typeResponseMap.put(String.valueOf(RECEIVE_SOCIAL_SECURITY), "SS");
				typeResponseMap.put(String.valueOf(CHILD_SUPPORT_PAYMENT), "DC");
				typeResponseMap.put(String.valueOf(BENEFIT_TRUST), "TR");
				typeResponseMap.put(String.valueOf(TRIBAL_TANF), "TT");
				typeResponseMap.put(String.valueOf(BENEFIT_UNEMPLOYMENT), "UN");
				typeResponseMap.put(String.valueOf(BENEFIT_VETERAN), "VE");
				typeResponseMap.put(String.valueOf(WORKER_COMP), "WC");
				typeResponseMap.put(String.valueOf(TRIBAL_CAPITA), "TP");
				typeResponseMap.put(String.valueOf(REGULAR_EMPL), "R");
				typeResponseMap.put(String.valueOf(JOB_IN_KIND), "I");
				typeResponseMap.put(String.valueOf(SELF_EMPLOYMENT), "S");
				typeResponseMap.put(String.valueOf(PREGNANCY), "BP");
				typeResponseMap.put(String.valueOf(DISABLE), "DB");
				typeResponseMap.put(String.valueOf(LIQ_ASET_CHECKING_ACCOUNT), "CH");

				typeResponseMap.put(String.valueOf(LIQ_ASET_CASH), "CAS");
				typeResponseMap.put(String.valueOf(LIQUID_ASSET_XFER), "XR");
				typeResponseMap.put(String.valueOf(LIQUID_ASET_BANK), "FA");
				typeResponseMap.put(String.valueOf(LIQUID_ASSET_OTHER), "OT");
				typeResponseMap.put(String.valueOf(LIQUID_ASSET_ANNUITY), "MQ");
				typeResponseMap.put(String.valueOf(LIQUID_ASSET_PENSION_PLAN), "PP");
				typeResponseMap.put(String.valueOf(LIQUID_ASSET_RETIREMENT), "IRA");
				typeResponseMap.put(String.valueOf(LIQUID_ASSET_STOCK_BONDS), "ST");

				typeResponseMap.put(String.valueOf(LIQUID_ASSET_IRA), "IR");

				typeResponseMap.put(String.valueOf(LIQUID_ASSET_IRS_RET), "SP");

				typeResponseMap.put(String.valueOf(LIQUID_ASSET_SAVINGS_ACC), "SA");

				typeResponseMap.put(String.valueOf(LIQUID_ASSET_PROMISSORY), "PN");

				typeResponseMap.put(String.valueOf(LIQUID_ASSET_TRUST_FUND), "TR");

				typeResponseMap.put(String.valueOf(BUR_AST_IRREVOCABLE), "RT");
				typeResponseMap.put(String.valueOf(BUR_AST_INSURANCE), "BI");
				typeResponseMap.put(String.valueOf(BUR_AST_MAUSOLEUM), "MS");
				typeResponseMap.put(String.valueOf(BUR_AST_OTHER), "OT");
				typeResponseMap.put(String.valueOf(BUR_AST_PLOT), "BUP");
				typeResponseMap.put(String.valueOf(BUR_AST_CASKET), "BC");

				typeResponseMap.put(String.valueOf(BUR_AST_VAULT), "VT");
				typeResponseMap.put(String.valueOf(VEH_ASET_ANIMAL_DRAWN), "AN");
				typeResponseMap.put(String.valueOf(VEH_ASET_NONMOTORIZED_CAMPER), "NC");
				typeResponseMap.put(String.valueOf(VEH_ASET_GOLFCART), "GC");
				typeResponseMap.put(String.valueOf(VEH_ASET_TRACTOR), "FTT");
				typeResponseMap.put(String.valueOf(VEH_ASET_AIRPLANE), "AI");
				typeResponseMap.put(String.valueOf(VEH_ASET_AUTOMOBILE), "CAR");
				typeResponseMap.put(String.valueOf(VEH_ASET_BOAT), "WC");
				typeResponseMap.put(String.valueOf(VEH_ASET_BUS), "BU");
				typeResponseMap.put(String.valueOf(VEH_ASET_CAMPER), "CA");
				typeResponseMap.put(String.valueOf(VEH_ASET_FARM_IMPLEMENT), "FI");
				typeResponseMap.put(String.valueOf(VEH_ASET_FARM_EQUIP), "FT");
				typeResponseMap.put(String.valueOf(VEH_ASET_FARM_TRACTOR), "FC");
				typeResponseMap.put(String.valueOf(VEH_ASET_FARM_TRAILER), "FR");
				typeResponseMap.put(String.valueOf(VEH_ASET_LOG_SKIDDER), "LS");
				typeResponseMap.put(String.valueOf(VEH_ASET_MOTORCYCLE), "MC");
				typeResponseMap.put(String.valueOf(VEH_ASET_MOPED), "MP");
				typeResponseMap.put(String.valueOf(VEH_ASET_NONMOTORIZED_BOAT), "NB");
				typeResponseMap.put(String.valueOf(VEH_ASET_OTHER), "OT");
				typeResponseMap.put(String.valueOf(VEH_ASET_RECREATIONAL_VEHICLE), "RV");
				typeResponseMap.put(String.valueOf(VEH_ASET_SNOWMOBILE), "SN");
				typeResponseMap.put(String.valueOf(VEH_ASET_TRUCK), "TK");
				typeResponseMap.put(String.valueOf(VEH_ASET_TRAVEL_TRAILER), "TL");
				typeResponseMap.put(String.valueOf(VEH_ASET_VAN), "VA");
				typeResponseMap.put(String.valueOf(VEH_ASET_UNLIC), "UL");
				typeResponseMap.put(String.valueOf(REAL_ASET_APARTMENT), "BU");
				typeResponseMap.put(String.valueOf(REAL_ASET_COMMERCIAL), "CP");
				typeResponseMap.put(String.valueOf(REAL_ASET_CONDO), "CO");
				typeResponseMap.put(String.valueOf(REAL_ASET_DUPLEX), "DP");
				typeResponseMap.put(String.valueOf(REAL_ASET_HOME), "HO");
				typeResponseMap.put(String.valueOf(REAL_ASET_LAND), "LD");
				typeResponseMap.put(String.valueOf(REAL_ASET_MOBILE_HOME), "MH");
				typeResponseMap.put(String.valueOf(REAL_ASET_OTHER), "OT");
				typeResponseMap.put(String.valueOf(REAL_ASET_LIFE_ESTATE), "LE");
				typeResponseMap.put(String.valueOf(REAL_ASET_HOUSE), "HS");
				typeResponseMap.put(String.valueOf(REAL_ASET_UNOCCUPY_HOME), "UH");
				typeResponseMap.put(String.valueOf(MAPP_BENEFITS_RESP), "MC");
				typeResponseMap.put(String.valueOf(INDV_DEMO_CHANGE), "DC");
				typeResponseMap.put(String.valueOf(PREGNANCY_END), "PE");
				typeResponseMap.put(String.valueOf(ROOM_AND_BOARD), "RB");
				typeResponseMap.put(String.valueOf(SCHL_ENRL_RESP), "SC");
				typeResponseMap.put(String.valueOf(HOSPITAL_STAY_RESP), "HS");
				typeResponseMap.put(String.valueOf(LIF_AST_GROUP_LIFE), "GR");
				typeResponseMap.put(String.valueOf(LIF_AST_GROUP_TERM), "GT");
				typeResponseMap.put(String.valueOf(LIF_AST_TERM), "TM");
				typeResponseMap.put(String.valueOf(LIF_AST_WHOLE_LIFE), "WH");
				typeResponseMap.put(String.valueOf(LIF_AST_UNIVERSAL), "UN");
				typeResponseMap.put(String.valueOf(DRUG_FELON), "BD");
				typeResponseMap.put(String.valueOf(PAY_ROOM_AND_BOARD), "RB");
				typeResponseMap.put(String.valueOf(DEPENDENT_CARE), "DC");
				typeResponseMap.put(String.valueOf(IREW), "IR");
				typeResponseMap.put(String.valueOf(LIQ_ASET_CHRISTMAS_CLUB), "CC");
//				typeResponseMap.put(String.valueOf(LIQ_ASET_CREDIT_UNION), "CU");
				typeResponseMap.put(String.valueOf(LIQ_ASET_CHILD_SUP_DD), "DD");
				typeResponseMap.put(String.valueOf(LIQ_ASET_EXCESS_OVER_LIFE_GRANT_REFU), "LR");
				typeResponseMap.put(String.valueOf(LIQ_ASET_SPECIAL_RESOURCE_ACCOUNT), "SR");
				typeResponseMap.put(String.valueOf(LIQ_ASET_TAX_SHELTER_ACCOUNT), "TS");
				typeResponseMap.put(String.valueOf(LIQ_ASET_TAX_REFUND), "TX");
				typeResponseMap.put(String.valueOf(BUR_AST_BURIAL_FUND), "BF");
				typeResponseMap.put(String.valueOf(BUR_AST_BURIAL_INTEREST), "BI");
				typeResponseMap.put(String.valueOf(BUR_AST_BURIAL_SPACE), "BS");
				typeResponseMap.put(String.valueOf(BUR_AST_COUNTABLE_BURIAL_TRUST), "CT");
				typeResponseMap.put(String.valueOf(LIF_AST_ANNUITY), "AN");
				typeResponseMap.put(String.valueOf(REAL_ASET_TRADE_WORK), "RT");
				typeResponseMap.put(String.valueOf(REAL_ASET_MOBILE_HOME_LAND), "ML");
				typeResponseMap.put(String.valueOf(LIQ_ASET_MONTHLY_EXCESS_OVER_GRANT_REFU), "MR");
				typeResponseMap.put(String.valueOf(STUDENT_FINANCIAL_AID), "SF");
				typeResponseMap.put(String.valueOf(OTHR_SOCIAL_SECURITY_BENEFITS), "SA");
				typeResponseMap.put(String.valueOf(BLACK_LUNG_BENEFIT), "BL");
				typeResponseMap.put(String.valueOf(CASH_GIFTS_CONT), "CA");
				typeResponseMap.put(String.valueOf(FOOD_CLOTHING_UTIL_RENT), "FC");
				typeResponseMap.put(String.valueOf(INHERITANCE), "IH");

				typeResponseMap.put(String.valueOf(INSURANCE_SETTLEMENT), "IS");
				typeResponseMap.put(String.valueOf(LOAN), "LO");
				typeResponseMap.put(String.valueOf(LOTTERY_PRIZE_WINNING), "PR");
				typeResponseMap.put(String.valueOf(BENEFIT_RAILROAD_RETIREMENT), "RA");
				typeResponseMap.put(String.valueOf(ROOM_AND_BOARD), "RM");
				typeResponseMap.put(String.valueOf(STRIKE_BENEFITS_RESP), "SB");
				typeResponseMap.put(String.valueOf(TRAINING_ALLOWANCE), "TR");
				typeResponseMap.put(String.valueOf(RECEIVE_SOCIAL_SECURITY), "SS");
				typeResponseMap.put(String.valueOf(RESETTL_INC_RESP), "RE");
				typeResponseMap.put(String.valueOf(OTHR_INCM_RENTL_RESP), "RR");
				typeResponseMap.put(String.valueOf(LAND_CONT_RESP), "PS");
				typeResponseMap.put(String.valueOf(HEALTHCARE_COVERAGE), "HI");
				typeResponseMap.put(String.valueOf(HOUS_PICE), "HP");
				typeResponseMap.put(String.valueOf(OUTSTATE_BNFTS), "OF");
				typeResponseMap.put(String.valueOf(UTILITY_BILLS_OIL), "OI");
				typeResponseMap.put(String.valueOf(RECEIVE_MEDICARE), "MC");

				typeResponseMap.put(String.valueOf(LIFE_INS_ASEST_GROUP_LIFE_RESP), "GR");
				typeResponseMap.put(String.valueOf(LIFE_INS_ASSET_GROUP_TERM_RESP), "TM");
				typeResponseMap.put(String.valueOf(LIFE_INS_ASSET_UNIVERSAL_RESP), "UN");
				typeResponseMap.put(String.valueOf(LIFE_INS_ASSET_WHOLE_LIFE_RESP), "WH");

				typeResponseMap.put(String.valueOf(LIFE_INSURANCE_ASSET_TERM_RESP), "GT");
				typeResponseMap.put(String.valueOf(LIFE_INSURANCE_OTHER_RESP), "OT");
				typeResponseMap.put(String.valueOf(OTHR_ASET_PERSONAL_PROPERTY), "PA");
				typeResponseMap.put(String.valueOf(OTHR_ASET_LIFE_INSURANCE), "LI");
				typeResponseMap.put(String.valueOf(WORK_RELATED_EXPENSE_RESP), "WE");
				typeResponseMap.put(String.valueOf(MEDICAL_EXPENSE), "ME");

				typeResponseMap.put(String.valueOf(MED_TYPE_PROSTHETIC_RESP), "AI");
				typeResponseMap.put(String.valueOf(MED_TYPE_ATNDNT_MEAL_RESP), "AM");
				typeResponseMap.put(String.valueOf(MED_TYPE_ANIMAL_RESP), "AN");
				typeResponseMap.put(String.valueOf(MED_TYPE_MAINTAIN_ATTNDNT_RESP), "AT");
				typeResponseMap.put(String.valueOf(MED_TYPE_INHOME_RESP), "CB");
				typeResponseMap.put(String.valueOf(MED_TYPE_SPECIAL_EQUIP_RESP), "DE");
				typeResponseMap.put(String.valueOf(MED_TYPE_EYEGLASSES_RESP), "EY");
				typeResponseMap.put(String.valueOf(MED_TYPE_INSURANCE_RESP), "HO");
				typeResponseMap.put(String.valueOf(MED_TYPE_BILLS_RESP), "MD");
				typeResponseMap.put(String.valueOf(MED_TYPE_SUPPLIES_RESP), "ME");
				typeResponseMap.put(String.valueOf(MED_TYPE_NURSING_RESP), "NH"); // new
				typeResponseMap.put(String.valueOf(MED_TYPE_OUT_PATIENT_RESP), "OU"); // new
				typeResponseMap.put(String.valueOf(MED_TYPE_PSYCHOTHERAPY_RESP), "PS");
				typeResponseMap.put(String.valueOf(MED_TYPE_PRESCRIBED_DRUG_RESP), "RX");
				typeResponseMap.put(String.valueOf(MED_TYPE_TRANSPORTATION_RESP), "TR");
				typeResponseMap.put(String.valueOf(MED_TYPE_OTHER_RESP), "OT");
				typeResponseMap.put(String.valueOf(CHILD_CARE_RESP), "CCB");
				typeResponseMap.put(String.valueOf(CHILD_OBLIGATION_RESP), "CT");
				typeResponseMap.put(String.valueOf(MEDICAL_BILLS_RESP), "MB");
				typeResponseMap.put(String.valueOf(MEDTYP_DENTAL), "DN");
				typeResponseMap.put(String.valueOf(MEDTYP_ATTENDANT_CARE), "AC");
				typeResponseMap.put(String.valueOf(MEDTYP_DOCTOR), "DR");
				typeResponseMap.put(String.valueOf(MEDTYP_MED_EQUIP), "EQ");
				typeResponseMap.put(String.valueOf(MEDTYP_HOSP_BILLS), "HS");
				typeResponseMap.put(String.valueOf(MEDTYP_INSUR_PREMIUM), "HIP");
				typeResponseMap.put(String.valueOf(MEDTYP_RX_COST), "PS");
				typeResponseMap.put(String.valueOf(MEDTYP_TRANS_MED), "TM");
				typeResponseMap.put(String.valueOf(MEDTYP_OTHER), "OT");
				typeResponseMap.put(String.valueOf(UNPAID_MEDBILL), "UM");
				typeResponseMap.put(String.valueOf(REAL_ASET_FARM), "FM");
				typeResponseMap.put(String.valueOf(REAL_ASET_RENTAL), "RE");
				typeResponseMap.put(String.valueOf(REAL_ASET_VAC), "VH");
				typeResponseMap.put(String.valueOf(MEDTYP_HSA_CONTRIB), "HS");

				typeResponseMap.put(String.valueOf(UEI_ADOPTION_ASSIST), "AS");
				typeResponseMap.put(String.valueOf(UEI_ADOPTION_PYMT), "AP");
				typeResponseMap.put(String.valueOf(UEI_AGENT_ORNG_PYMT), "AO");
				typeResponseMap.put(String.valueOf(UEI_ALIMONY), "AL");
				typeResponseMap.put(String.valueOf(UEI_CAPITAL_GAINS), "CG");
				typeResponseMap.put(String.valueOf(UEI_DEATH_BNFT), "DB");
				typeResponseMap.put(String.valueOf(UEI_DABL_INCM), "DM");
				typeResponseMap.put(String.valueOf(UEI_DR_RELIEF), "DR");
				typeResponseMap.put(String.valueOf(UEI_EDU_ASSIST), "ED");
				typeResponseMap.put(String.valueOf(UEI_ENERGY_ASSIST), "EA");
				typeResponseMap.put(String.valueOf(UEI_FRM_ALOT), "FA");
				typeResponseMap.put(String.valueOf(UEI_FOSTER_CARE_PYMT), "FP");
				typeResponseMap.put(String.valueOf(UEI_GEN_ASSIST), "GA");
				typeResponseMap.put(String.valueOf(UEI_INT_DIV_PYMT), "IP");
				typeResponseMap.put(String.valueOf(UEI_IRA_DIST), "ID");
				typeResponseMap.put(String.valueOf(UEI_LOTTERY_WIN), "LW");
				typeResponseMap.put(String.valueOf(UEI_LUMP_SUM), "LS");
				typeResponseMap.put(String.valueOf(UEI_MIL_ALOT), "MI");
				typeResponseMap.put(String.valueOf(UEI_MON_FRO_OTH), "MF");
				typeResponseMap.put(String.valueOf(UEI_NET_RENT_ROYALTY), "NR");
				typeResponseMap.put(String.valueOf(UEI_OTH), "OO");
				typeResponseMap.put(String.valueOf(UEI_ANNY_PYMT), "PF");
				typeResponseMap.put(String.valueOf(UEI_PYMT_BO), "PB");
				typeResponseMap.put(String.valueOf(UEI_PENSION), "PN");
				typeResponseMap.put(String.valueOf(UEI_RR_RETIRE), "RT");
				typeResponseMap.put(String.valueOf(UEI_REFUGEE_CASH), "RC");
				typeResponseMap.put(String.valueOf(UEI_REL_CARE), "RS");
				typeResponseMap.put(String.valueOf(UEI_RENTAL_INCM), "RI");
				typeResponseMap.put(String.valueOf(UEI_TANF_PYMT), "TN");
				typeResponseMap.put(String.valueOf(UEI_UNEMPL), "UC");
				typeResponseMap.put(String.valueOf(UEI_WORKER_STUDY), "WS");
				typeResponseMap.put(String.valueOf(UEI_WORKER_COMP), "WO");
				typeResponseMap.put(String.valueOf(OTHR_ASET_BURIAL), "BA");

				typeResponseMap.put(String.valueOf(PERS_PROP_BUS_EQPT), "BE");
				typeResponseMap.put(String.valueOf(PERS_PROP_CEMETARY_LOT), "CL");
				typeResponseMap.put(String.valueOf(PERS_PROP_LIVESTOCK), "LV");
				typeResponseMap.put(String.valueOf(PERS_PROP_SAF_DEPST_BOX), "SB");
				typeResponseMap.put(String.valueOf(PERS_PROP_OTH_VAL), "OV");

				typeResponseMap.put(String.valueOf(ABLE_TO_CONCEIVE_RESP), "AC");
				typeResponseMap.put(String.valueOf(UNDERWEIGHT_BIRTH_RESP), "UB");
				typeResponseMap.put(String.valueOf(PREG_ADD_STAT_SW), "BP");
				typeResponseMap.put(String.valueOf(PREG_CHG_STAT_SW), "PE");

				typeResponseMap.put(String.valueOf(SU_CST_INS_RESP), "NO");
				typeResponseMap.put(String.valueOf(OTHER_HOUSING_BILL_RESP), "OT");
				typeResponseMap.put(String.valueOf(DISASTER_REPAIR_RESP), "DR");
				typeResponseMap.put(String.valueOf(PREVENT_EVICTION_RESP), "PE");

				typeResponseMap.put(String.valueOf(BTD_MED_INS), "MI");
				typeResponseMap.put(String.valueOf(BTD_DENT_INS), "DI");
				typeResponseMap.put(String.valueOf(BTD_VIS_CARE_INS), "VI");
				typeResponseMap.put(String.valueOf(BTD_FLEX_ACC), "FS");
				typeResponseMap.put(String.valueOf(BTD_DEF_COMP), "DC");
				typeResponseMap.put(String.valueOf(BTD_PRE_TAX_INS), "PI");
				typeResponseMap.put(String.valueOf(BTD_OTHER), "OT");
				typeResponseMap.put(String.valueOf(TAX_INFO_IND), "TR");
				typeResponseMap.put(String.valueOf(TAX_DEPENDENT_IND), "TD");
				typeResponseMap.put(String.valueOf(TAX_CLAIM_DEPENDENT), "TC");
				typeResponseMap.put(String.valueOf(MEDICARE_PART_A), "MPA");
				typeResponseMap.put(String.valueOf(MEDICARE_PART_B), "MPB");
				typeResponseMap.put(String.valueOf(MEDICARE_PART_C), "MPC");
				typeResponseMap.put(String.valueOf(MEDICARE_PART_D), "MPD");
				typeResponseMap.put(String.valueOf(CCSP_PROVIDER_PAYMENT), "CS");
				typeResponseMap.put(String.valueOf(ANIMALS_TO_ASSIST_DISABLED), "AN");
				typeResponseMap.put(String.valueOf(FUNERAL_DEATH_EXPENSE), "FDE");
				typeResponseMap.put(String.valueOf(BLIND_WORK_EXPENSE), "BWE");
				typeResponseMap.put(String.valueOf(IMPAIRMENT_WORK_EXPENSE), "IRW");
				typeResponseMap.put(String.valueOf(OTH_IND_GAMBL_PMNTS), "IGP");

				typeResponseMap.put(String.valueOf(BONDS), "BD");
				typeResponseMap.put(String.valueOf(DIVIDEND), "DIV");
				typeResponseMap.put(String.valueOf(HEALTH_REIMBURSEMENT_ACCOUNT), "HRA");
				typeResponseMap.put(String.valueOf(INDIVIDUAL_DEVELOPMENT_ACCOUNT), "IDA");
				typeResponseMap.put(String.valueOf(UNIFORM_GIFTS_TO_MINORS), "UNG");
				typeResponseMap.put(String.valueOf(LOST_HEALTH_INS_IND), "LH");

				typeResponseMap.put(String.valueOf(INCOME_FROM_RESOURCE), "IFS");
				typeResponseMap.put(String.valueOf(INDIAN_GAMBLING_PAYMENTS), "IGPI");
				typeResponseMap.put(String.valueOf(INHERITANCE_INCOME), "INH");
				typeResponseMap.put(String.valueOf(INSUANCE_BENEFITS), "IBLI");
				typeResponseMap.put(String.valueOf(LOAN_RECEIVED), "LR");
				typeResponseMap.put(String.valueOf(LOAN_REPAYMENT_INCOME), "LRI");
				typeResponseMap.put(String.valueOf(MANAGED_INCOME), "MII");
				typeResponseMap.put(String.valueOf(MATCH_GRANT), "MGRA");
				typeResponseMap.put(String.valueOf(MONTGOMERY_GI_BILL), "MGBP");
				typeResponseMap.put(String.valueOf(OUT_OF_STATE_PUBLIC), "OSPA");

				typeResponseMap.put(String.valueOf(REFUNDS_FROM_DCH), "RDCH");
				typeResponseMap.put(String.valueOf(RESTITUTIONS_SETTLEMENTS), "RSE");
				typeResponseMap.put(String.valueOf(SENIOR_COMPANION), "SCP");
				typeResponseMap.put(String.valueOf(SEVERANCE_PAY), "SEV");
				typeResponseMap.put(String.valueOf(STRIKE_BENEFITS), "SBT");
				typeResponseMap.put(String.valueOf(TRADE_READJUSTMENT), "TRA");
				typeResponseMap.put(String.valueOf(UNIFORM_RELOCATION), "URAR");
				typeResponseMap.put(String.valueOf(UNION_FUNDS), "UF");
				typeResponseMap.put(String.valueOf(VENDOR_EXCLUDED), "V1");
				typeResponseMap.put(String.valueOf(VICTIM_RESTITUTION), "V3");

				typeResponseMap.put(String.valueOf(VOLUNTEER_PAYMENT), "VLP");
				typeResponseMap.put(String.valueOf(VOLUNTEER_PAYMENT_TITLEI), "VLPT");
				typeResponseMap.put(String.valueOf(WIA_TRAINING_AND_ALLOWANCE), "WIAT");
				typeResponseMap.put(String.valueOf(INCLUDED_UNEARNED_INCOME), "IUI");
				typeResponseMap.put(String.valueOf(TANF_MAX_AU_ALLOTMENT), "3TMA");
				typeResponseMap.put(String.valueOf(TANF_MAX_GRG_ALLOTMENT), "3TGA");
				typeResponseMap.put(String.valueOf(CHARITABLE_DONATION), "D1");
				typeResponseMap.put(String.valueOf(CHILD_NUTRITION_PAYMENTS), "CNP");
				typeResponseMap.put(String.valueOf(BLACK_LUNG_BENEFITS), "BLB");
				typeResponseMap.put(String.valueOf(CHILD_SUPPORT_COURT), "CSCO");

				typeResponseMap.put(String.valueOf(CHILD_SUPPORT_GAP_PAYMENT), "CSGP");
				typeResponseMap.put(String.valueOf(CIVIL_SERVICE), "CSEB");
				typeResponseMap.put(String.valueOf(DEFERRED_COMPENSATION_PLANS), "DCP");
				typeResponseMap.put(String.valueOf(DISABILITY_INSURANCE), "DIN");
				typeResponseMap.put(String.valueOf(EXCLUDED_UNEARNED_INCOME), "EUI");
				typeResponseMap.put(String.valueOf(FEMA_PAYMENT_DISASTER), "FDE");
				typeResponseMap.put(String.valueOf(FEMA_PAYMENT_NON_DISASTER), "FNDE");
				typeResponseMap.put(String.valueOf(HEALTH_SAVINGS_ACCOUNT), "HAS");
				typeResponseMap.put(String.valueOf(IN_KIND_SUPPORT), "IKS");
				typeResponseMap.put(String.valueOf(FOSTER_GRANDPARENT_PROGRAM), "FGPP");

				typeResponseMap.put(String.valueOf(DISASTER_UNEMPLOYMENT), "DIS");
				typeResponseMap.put(String.valueOf(DIVIDENDS), "DIV");
				typeResponseMap.put(String.valueOf(CHARITABLE_DONATION_FEDERAL), "DFS");
				typeResponseMap.put(String.valueOf(BEFORE_TAX_DEDUCTION), "BT");
				typeResponseMap.put(String.valueOf(TAX_DEDUCT_RESP), "XH");
				typeResponseMap.put(String.valueOf(OTHR_HLTH_INS_RESP), "OH");

				typeResponseMap.put(String.valueOf(PATIENT_FUND), "PTF");
				typeResponseMap.put(String.valueOf(DISASTER_ASSISTANCE), "DA");
				typeResponseMap.put(String.valueOf(NON_BUSINESS_EQUIPMENT), "NB");
				typeResponseMap.put(String.valueOf(HOUSEHOLD_GOODS), "HG");
				typeResponseMap.put(String.valueOf(OTHER_NON_COUNTABLE), "ON");
				typeResponseMap.put(String.valueOf(AVOID_PROSC_RESP), "CV");
				typeResponseMap.put(String.valueOf(HLTH_INS_RESP), "HN");

				typeResponseMap.put(String.valueOf(LIQ_ASET_CHECKING_ACCOUNT), "CA");
				typeResponseMap.put(String.valueOf(LIQ_ASET_KEOUGH_PLAN), "KEO");
				typeResponseMap.put(String.valueOf(DEATH_BENEFIT_STATE_FEDERAL), "DBSF");
				typeResponseMap.put(String.valueOf(SOCIAL_SECURITY_SURVIVOR), "SSR");
				typeResponseMap.put(String.valueOf(VENDOR_PAYMENTS), "V2");
				
				typeResponseMap.put(String.valueOf(PRSN_INFO_STAT_SW), "PI");
				typeResponseMap.put(String.valueOf(CITIZENSHIP_INFO), "CI");
				typeResponseMap.put(String.valueOf(EMPL_HLTH_INS_RESP), "EHI");

			}
			final String typeForResponse = (String) typeResponseMap.get(String.valueOf(response));
			if (typeForResponse != null) {
				return typeForResponse;
			}
			return "";
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "getTypeByResponse", e);
		}
	}

	@Override
	public String getLiquidResourceTypeByResponse(final short response) {
		try {

			if (liquidResource.get(String.valueOf(response))==null || liquidResource.get(String.valueOf(response)).toString().isEmpty()) {
				liquidResource.put(String.valueOf(LIQ_ASET_CASH), "CAS");
				liquidResource.put(String.valueOf(LIQUID_ASSET_XFER), "XR");
				liquidResource.put(String.valueOf(LIQUID_ASET_BANK), "FA");
				liquidResource.put(String.valueOf(LIQUID_ASSET_OTHER), "OT");
				liquidResource.put(String.valueOf(LIQUID_ASSET_ANNUITY), "MQ");
				liquidResource.put(String.valueOf(LIQUID_ASSET_PENSION_PLAN), "PP");
				liquidResource.put(String.valueOf(LIQUID_ASSET_RETIREMENT), "IRA");
				liquidResource.put(String.valueOf(LIQUID_ASSET_STOCK_BONDS), "ST");

				liquidResource.put(String.valueOf(LIQUID_ASSET_IRA), "IR");

				liquidResource.put(String.valueOf(LIQUID_ASSET_IRS_RET), "SP");

				liquidResource.put(String.valueOf(LIQUID_ASSET_SAVINGS_ACC), "SA");

				liquidResource.put(String.valueOf(LIQUID_ASSET_PROMISSORY), "PN");

				liquidResource.put(String.valueOf(LIQUID_ASSET_TRUST_FUND), "TR");
				liquidResource.put(String.valueOf(PATIENT_FUND), "PTF");

				liquidResource.put(String.valueOf(BONDS), "BD");
				liquidResource.put(String.valueOf(DIVIDEND), "DIV");
				liquidResource.put(String.valueOf(UNIFORM_GIFTS_TO_MINORS), "UNG");

				liquidResource.put(String.valueOf(LIQ_ASET_CHECKING_ACCOUNT), "CA");
				liquidResource.put(String.valueOf(LIQ_ASET_KEOUGH_PLAN), "KEO");
				liquidResource.put(String.valueOf(HEALTH_REIMBURSEMENT_ACCOUNT), "HRA");
				liquidResource.put(String.valueOf(INDIVIDUAL_DEVELOPMENT_ACCOUNT), "IDA");

			}

			final String typeForResponse = (String) liquidResource.get(String.valueOf(response));
			if (typeForResponse != null) {
				return typeForResponse;
			}
			return "";
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "getLiquidResourceTypeByResponse", e);
		}

	}

	@Override
	public String getTaxTypeByResponse(final short response) {
		try {

			if (liquidResource.isEmpty()) {
				liquidResource.put(String.valueOf(TAX_INFO_IND), "OB");
				liquidResource.put(String.valueOf(TAX_DEPENDENT_IND), "TD");

			}

			final String typeForResponse = (String) liquidResource.get(String.valueOf(response));
			if (typeForResponse != null) {
				return typeForResponse;
			}
			return "";
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "getLiquidResourceTypeByResponse", e);
		}

	}

	@Override
	public String geHousingBillsTypeByResponse(final short response) {
		try {

			if (liquidResource.isEmpty()) {
				liquidResource.put(String.valueOf(SHELTER_COST_RENT), "RM");
				liquidResource.put(String.valueOf(SHELTER_COST_MORTGAGE), "RE");
				liquidResource.put(String.valueOf(SHELTER_COST_TAX), "HI");
				liquidResource.put(String.valueOf(SU_CST_INS_RESP), "NO");
				liquidResource.put(String.valueOf(OTHER_HOUSING_BILL_RESP), "OT");
				liquidResource.put(String.valueOf(DISASTER_REPAIR_RESP), "DR");
				liquidResource.put(String.valueOf(PREVENT_EVICTION_RESP), "PE");
				liquidResource.put(String.valueOf(HOUSING_BILLS_OTHERS), "OH");
				liquidResource.put(String.valueOf(SHELTER_COST_ASSESSMENT), "SA");

			}

			final String typeForResponse = (String) liquidResource.get(String.valueOf(response));
			if (typeForResponse != null) {
				return typeForResponse;
			}
			return "";
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "getLiquidResourceTypeByResponse", e);
		}

	}

	/**
	 * @see gov.state.nextgen.access.management.applications.IRMCResponseProfileManager#isAppResponseNotRequired(gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Collection,
	 *      short)
	 */
	@Override
	public boolean isAppResponseNotRequired(final RMC_IN_PRFL_Collection aRmcInProfileCollection, final short aRespId) {
		try {
			final int size = aRmcInProfileCollection.size();
			RMC_IN_PRFL_Cargo rmcInPrflCargo = null;
			for (int i = 0; i < size; i++) {
				rmcInPrflCargo = (RMC_IN_PRFL_Cargo) aRmcInProfileCollection.get(i);
				if ((getProfileResponse(rmcInPrflCargo, aRespId) != null)
						&& (getProfileResponse(rmcInPrflCargo, aRespId).charAt(0) != STATUS_NOT_REQUIRED)) {
					return false;
				}
			}
			return true;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "isAppInPrflRespNotRequired", e);
		}
	}

	/**
	 * get the new status for the given (current) status and required status
	 */
	private char getStatus(final String aCurrentStatus, final char aMakeStatus) {
		return driverMatrix[getIndex(aCurrentStatus.charAt(0))][getIndex(aMakeStatus)];
	}

	/**
	 * returns index for given driver indicatior. It is used to look up the
	 * driver matrix
	 */
	private int getIndex(final char aResponseInd) {

		switch (aResponseInd) {
		case STATUS_REQUIRED:
			return INDEX_REQUIRED;
		case STATUS_NOT_REQUIRED:
			return INDEX_NOT_REQUIRED;
		case STATUS_COMPLETE:
			return INDEX_COMPLETE;
		case STATUS_ADD_NEW:
			return INDEX_ADD_NEW;
		case STATUS_VISIT_AGAIN:
			return INDEX_VISIT_AGAIN;
		case STATUS_ABSOLUTE_NOT_REQUIRED:
			return INDEX_ABSOLUTE_NOT_REQUIRED;
		default:
			return INDEX_UNKNOWN;
		}
	}

	/**
	 * persists the status through SQLManager for given SQL (SQL_IND)
	 */

	private void persistStatus(final String aAppNum, final String aIndvSeqNum, final short[] aProgramIds, final String[] aProgramValues) {
		try {

			// create a cargo and set the colnames array and values array to the
			// cargo and the datatype.
			// 35980 added PAST_HC_CVRG_RESP
			final FwDataCriteria[] dataCriteriaArray = new FwDataCriteria[aProgramIds.length];
			final String[] colnames = { "ACDT_RESP", "ADPT_ASST_RESP", "ALMY_RCV_RESP", "BNFT_ANTY_RESP", "BNFT_CHRT_RESP", "BNFT_DABL_RESP",
					"BNFT_DIVND_RESP", "BNFT_EST_TRST_RESP", "BNFT_RR_RESP", "BNFT_UEMPL_RESP", "BNFT_VET_RESP", "CHLD_SPRT_PAY_RESP", "DABL_RESP",
					"DPND_CARE_RESP", "DRUG_FELN_RESP", "FSET_SCTN_RESP", "FSTR_CARE_RESP", "GEN_RLF_RESP", "HC_CVRG_RESP", "INCM_INT_RESP",
					"INDV_FMA_RQST_IND", "INDV_FPW_RQST_IND", "INDV_FS_RQST_IND", "IRWE_RESP", "KINSHIP_CARE_RESP", "MED_EXP_RESP", "MIL_ALLOT_RESP",
					"MONY_OTHR_RESP", "NATL_RFGE_RESP", "NEED_IND_RESP", "ON_STRK_SW", "OP_AODA_TMT_RCV_SW", "OTHR_INCM_RESP", "OTHR_SRC_RESP",
					"OWN_ASET_RESP", "PAY_HOUS_BILL_RESP", "PREG_RESP", "JOB_IKND_RESP", "PAY_RMR_BRD_RESP", "PNSN_RETR_RESP", "PROP_SOLD_RESP",
					"RCV_FS_OTH_ST_RESP", "RCV_HOUS_ASST_RESP", "RCV_MEDCR_RESP", "RCV_SS_RESP", "RCV_SSI_LTR_RESP", "RCV_SSI_SW",
					"RMR_BRD_INCM_RESP", "SELF_EMPL_RESP", "SSI_DCOND_RESP", "SSI_1619B_RCV_SW", "SU_ASES_RESP", "SU_CST_COAL_RESP",
					"SU_CST_ELEC_RESP", "SU_CST_FUEL_RESP", "SU_CST_GAS_RESP", "SU_CST_HOME_RESP", "SU_CST_ISTL_RESP", "SU_CST_LPGAS_RESP",
					"SU_CST_MBL_RESP", "SU_CST_MTGE_RESP", "SU_CST_OTHR_RESP", "SU_CST_PHN_RESP", "SU_CST_RENT_RESP", "SU_CST_SWR_RESP",
					"SU_CST_TAX_RESP", "SU_CST_TRSH_RESP", "SU_CST_WOOD_RESP", "SU_CST_WTR_RESP", "SU_CST_WWT_RESP", "TRB_TANF_RESP",
					"UTIL_EXP_RESP", "WORK_COMP_RESP", "TRB_CPTA_RESP", "EDUC_AID_RESP", "WHEAP_RESP", "EMPL_RESP", "BNFT_CHL_SPRT_RESP",
					"PUB_ASST_RESP", "YEHOC_RESP", "PAST_HC_CVRG_RESP", "BNFT_MAPP_RESP", "bury_aset_oth_resp", "BURY_ASET_RBT_RESP",
					"BURY_ASET_INS_RESP", "BURY_ASET_MAS_RESP", "BURY_ASET_OTH_RESP", "BURY_ASET_PLT_RESP", "BURY_ASET_RBT_RESP", "BURY_ASET_V_RESP",
					"LI_ASET_G_L_RESP", "LI_ASET_G_T_RESP", "LI_ASET_TRM_RESP", "LI_ASET_UNV_RESP", "LI_ASET_W_L_RESP", "LIQUID_ASSET_BANK_ACC_RESP",
					"LIQUID_ASSET_CASH_RESP", "liquid_aset_disable_blind_resp", "LQD_ASET_H_S_RESP", "liquid_asset_ira_resp",
					"liquid_asset_irs_retirmnt_resp", "liquid_asset_pension_plan_resp", "liquid_asset_promissory_resp",
					"liquid_asset_retirement_resp", "liquid_asset_stocks_bonds_resp", "liquid_asset_savings_acc_resp",
					"liquid_asset_trust_fund_resp", "liquid_asset_other_response", "liquid_asset_other_type_resp", "LQD_ASET_US_B_RESP",
					"OTHER_ASSET_BURIAL_RESP", "other_aset_life_insurance_resp", "OTHER_ASSET_PERSONAL_PROP_RESP", "OTHER_ASSET_REAL_PROPERTY_RESP",
					"OTHER_ASSET_VEHICLE_RESP", "Other_asset_transfer_resp", "real_asset_house_resp", "real_asset_land_resp",
					"real_asset_mobile_home_resp", "real_asset_other_resp", "real_asset_home_resp", "real_asset_life_estate_resp",
					"real_asset_unoccupy_home_resp", "REAL_ASET_CON_RESP", "REAL_ASET_DUP_RESP", "vehicle_asset_animal_drwn_resp",
					"VEH_ASET_ARPL_RESP", "vehicle_asset_auto_resp", "vehicle_asset_boat_resp", "VEH_ASET_BUS_RESP", "vehicle_asset_camper_resp",
					"VEH_ASET_FIMP_RESP", "VEH_ASET_FMEQ_RESP", "VEH_ASET_FTRC_RESP", "VEH_ASET_FTRL_RESP", "VEH_ASET_LSKD_RESP",
					"vehicle_asset_motorcycle_resp", "VEH_ASET_MPED_RESP", "REAL_ASET_COM_RESP", "VEH_ASET_OTHR_RESP",
					"vehicle_asset_recreation_resp", "vehicle_asset_tractor_resp", "vehicle_asset_golf_cart_resp", "vehicle_asset_nmot_camper_resp",
					"VEHICLE_ASSET_VAN_RESP", "APRV_ACTV_RESP", "BNFT_CRT_O_KC_RESP", "BNFT_FC_RESP", "BNFT_KC_RESP", "BNFT_SG_RESP",
					"INDV_CC_RQST_IND", "school_enrollment_resp", "TRB_CMDY_RESP", "CP_WLST_RESP", "INDV_CLA_IND", "MOVED_INTO_HOME_RESPONSE",
					"MOVED_OUT_OF_HOME_RESP", "PAROLE_VIOLATION_RESP", "ROOM_BOARD_RESP", "HEAD_OF_HOUSEHOLD_RESP", "MEDICAL_SERVICE_RESP",
					"EMERGENCY_MEDICAL_SERVICE_RESP", "", "student_financial_aid_resp", "benefit_black_lung_resp", "cash_gifts_resp",
					"food_clothing_util_rent_resp", "inheritance_resp", "insurance_settlement_resp", "loan_resp", "lottery_prize_winning_resp",
					"training_allowance_resp", "othr_social_security_bnft_resp", "benefits_on_strike_resp", "RESETTL_INC_RESP",
					"OTHR_INCM_RENTL_RESP", "LAND_CONT_RESP", "housing_bill_others_resp", "utility_bills_oil_resp", "WORK_RELATED_EXPENSE_RESP",
					"life_ins_asset_whole_life_resp", "life_insurance_asset_term_resp", "life_ins_asest_group_life_resp",
					"life_ins_asset_group_term_resp", "life_ins_asset_universal_resp", "life_insurance_other_resp", "MED_TYPE_PROSTHETIC_RESP",
					"MED_TYPE_ATNDNT_MEAL_RESP", "MED_TYPE_ANIMAL_RESP", "MED_TYPE_MAINTAIN_ATTNDNT_RESP", "MED_TYPE_INHOME_RESP",
					"MED_TYPE_SPECIAL_EQUIP_RESP", "MED_TYPE_EYEGLASSES_RESP", "MED_TYPE_INSURANCE_RESP", "MED_TYPE_BILLS_RESP",
					"MED_TYPE_SUPPLIES_RESP", "MED_TYPE_NURSING_RESP", "MED_TYPE_OTHER_RESP", "MED_TYPE_OUT_PATIENT_RESP",
					"MED_TYPE_PSYCHOTHERAPY_RESP", "MED_TYPE_PRESCRIBED_DRUG_RESP", "MED_TYPE_TRANSPORTATION_RESP", "UTILITY_STANDARD_RESP",
					"LQD_ASET_TR_F_RESP", "HOSPITAL_STAY_RESP", "LIQ_ASET_EXCESS_OVER_LIFE_GRANT_REFU", "LIQ_ASET_SPECIAL_RESOURCE_ACCOUNT",
					"LIQ_ASET_TAX_SHELTER_ACCOUNT", "LIQ_ASET_TAX_REFUND", "BUR_AST_BURIAL_FUND", "BUR_AST_BURIAL_INTEREST", "BUR_AST_BURIAL_SPACE",
					"BUR_AST_COUNTABLE_BURIAL_TRUST", "LIF_AST_ANNUITY", "REAL_ASET_TRADE_WORK", "REAL_ASET_MOBILE_HOME_LAND",
					"LIQ_ASET_MONTHLY_EXCESS_OVER_GRANT_REFU", "LIQ_ASET_CHILD_SUP_DD", "INDV_TANF_RQST_IND", "INDV_WIC_RQST_IND",
					"OTHR_INCM_CONTRIB_RESP", "CHILD_CARE_RESP", "CHILD_OBLIGATION_RESP", "MEDICAL_BILLS_RESP", "MEDTYP_DENTAL",
					"MEDTYP_ATTENDANT_CARE", "MEDTYP_DOCTOR", "MEDTYP_MED_EQUIP", "MEDTYP_HOSP_BILLS", "MEDTYP_INSUR_PREMIUM", "MEDTYP_RX_COST",
					"MEDTYP_TRANS_MED", "MEDTYP_OTHER", "HOSPICE_RESP", "OUTSTATE_BNFT_RESP", "VEH_ASET_NM_B_RESP", "VEHICLE_ASSET_TRAILER_RESP",
					"VEHICLE_ASSET_TRUCK_RESP", "VEH_ASET_UNLIC_RESP", "UNPAID_MEDBILL", "SPECIAL_NEED_RESP", "FOSTER_CARE_RESP",
					"FORMER_FOSTER_RESP", "CHILD_PROTECTIVE_RESP", "LIVING_PROG_RESP", "GRAND_PARENT_RESP", "DRUG_FELONIES_RESP",
					"SNAP_TANF_DISC_RESP", "AVOID_PROSC_RESP", "VIOLATING_PAROLE_RESP", "CONVIC_FALSE_INFO_RESP", "VOLUNTARILY_QUIT_JOB_RESP",
					"TRADING_SNAP_RESP", "BUY_SELL_SNAP_RESP", "TRADE_SNAP_GUN_RESP", "PREV_SSI_RESP", "HOME_COMMUNITY_RESP", "TRIBAL_HEALTH_RESP",
					"TRIBAL_ELIGIBILITY_RESP", "DOMESTIC_VIOLENCE_RESP", "TANF_EPPIC_RESP", "EMERGENCY_MEDICAL_RESP", "MEDTYP_HSA_CONTRIB",
					"UEI_ADOPTION_ASSIST", "UEI_ADOPTION_PYMT", "UEI_AGENT_ORNG_PYMT", "UEI_ALIMONY", "UEI_CAPITAL_GAINS", "UEI_DEATH_BNFT",
					"UEI_DABL_INCM", "UEI_DR_RELIEF", "UEI_EDU_ASSIST", "UEI_ENERGY_ASSIST", "UEI_FRM_ALOT", "UEI_FOSTER_CARE_PYMT",
					"UEI_GEN_ASSIST", "UEI_INT_DIV_PYMT", "UEI_IRA_DIST", "UEI_LOTTERY_WIN", "UEI_LUMP_SUM", "UEI_MIL_ALOT", "UEI_MON_FRO_OTH",
					"UEI_NET_RENT_ROYALTY", "UEI_OTH", "UEI_ANNY_PYMT", "UEI_PYMT_BO", "UEI_PENSION", "UEI_RR_RETIRE", "UEI_REFUGEE_CASH",
					"UEI_REL_CARE", "UEI_RENTAL_INCM", "UEI_TANF_PYMT", "UEI_UNEMPL", "UEI_WORKER_STUDY", "UEI_WORKER_COMP",
					"real_asset_rental_resp", "real_aset_vac_resp", "REAL_ASET_APT_RESP", "REAL_ASET_FRM_RESP", "PERS_PROP_BUS_EQPT",
					"PERS_PROP_CEMETARY_LOT", "PERS_PROP_LIVESTOCK", "PERS_PROP_SAF_DEPST_BOX", "PERS_PROP_OTH_VAL", "ABLE_TO_CONCEIVE_RESP",
					"UNDERWEIGHT_BIRTH_RESP", "PREG_ADD_STAT_SW", "PREG_CHG_STAT_SW", "PERSONAL_INFO", "RLT_CHG_STAT_SW", "Su_cst_ins_resp",
					"Other_housing_bill_resp", "Disaster_repair_resp", "Prevent_eviction_resp", "CARE_TAKER_RESP", "OTHR_INCM_TRBL_RESP",
					"LOST_HEALTH_INS_IND", "TAX_CLAIM_DEPENDANT_RESP", "BEFORE_TAX_DEDUCTION_RESP", "BTD_MED_INS", "BTD_DENT_INS",
					"BTD_VIS_CARE_INS", "BTD_FLEX_ACC", "BTD_DEF_COMP", "BTD_PRE_TAX_INS", "BTD_OTHER", "TAX_DEDUCT_RESP", "HLTH_INS_RESP",
					"OTHR_HLTH_INS_RESP", "TANF_DISC_RESP", "ROOM_BRD_CHG_IND", "DABL_STAT_IND", "PREG_ADD_STAT_IND", "PREG_CHG_IND", "IRWE_CHG_IND",
					"EI_CHG_IND", "SELF_EMPL_CHG_IND", "OTHR_INCM_CHG_IND", "EMPL_CHG_IND", "VEH_ASET_ADD_IND", "VEH_ASET_CHG_IND",
					"REAL_ASET_ADD_IND", "REAL_ASET_CHG_IND", "BURY_ASET_ADD_IND", "BURY_ASET_CHG_IND", "LIQUID_ASSET_ADD_IND",
					"LIQUID_ASSET_BANK_ACC_CHG_IND", "LIQUID_ASSET_CASH_CHG_IND", "LIQUID_ASSET_CHG_IND", "LIQUID_ASSET_OTHER_CHG_IND",
					"LIFE_INS_ASET_ADD_IND", "LIFE_INS_ASET_CHG_IND", "ASET_XFER_CHG_IND", "DPND_CARE_CHG_IND", "HEALTH_INSURANCE_CHG_IND",
					"CHILD_SUPPORT_PAYMENT_CHG_IND", "SNAP_SHELTER_STANDARD_EXP_IND", "HOUS_BILL_CHG_IND", "ADD_CHG_IND", "PERSON_MOVED_IN_STAT_IND",
					"PERSON_MOVED_OUT_STAT_IND", "HOSPICE_CHG_IND", "MEDICARE_CHG_IND", "NCP_CHG_IND", "THIRD_PARTY_CHG_IND", "HOSPITAL_ABD_CHG_IND",
					"PUBLIC_LAW_ABD_CHG_IND", "LIVING_ARGMT_CHG_IND", "OTHER_PROGRAM_CHG_IND", "MAGI_EXPENSE_CHG_IND", "TAX_INFO_IND",
					"TAX_DEP_OUTSIDE_RESP", "MEDICARE_PART_A", "MEDICARE_PART_B", "MEDICARE_PART_C", "MEDICARE_PART_D", "CCSP_PROVIDER_PAYMENT",
					"ANIMALS_TO_ASSIST_DISABLED", "FUNERAL_DEATH_EXPENSE", "BLIND_WORK_EXPENSE", "IMPAIRMENT_WORK_EXPENSE", "OTH_IND_GAMBL_PMNTS",
					"BONDS", "DIVIDEND", "HEALTH_REIMBURSEMENT_ACCOUNT", "INDIVIDUAL_DEVELOPMENT_ACCOUNT", "UNIFORM_GIFTS_TO_MINORS",
					"INCOME_FROM_RESOURCE", "INDIAN_GAMBLING_PAYMENTS", "INHERITANCE_INCOME", "INSUANCE_BENEFITS", "LOAN_RECEIVED",
					"LOAN_REPAYMENT_INCOME", "MANAGED_INCOME", "MATCH_GRANT", "MONTGOMERY_GI_BILL", "OUT_OF_STATE_PUBLIC", "REFUNDS_FROM_DCH",
					"RESTITUTIONS_SETTLEMENTS", "SENIOR_COMPANION", "SEVERANCE_PAY", "STRIKE_BENEFITS", "TRADE_READJUSTMENT", "UNIFORM_RELOCATION",
					"UNION_FUNDS", "VENDOR_EXCLUDED", "VICTIM_RESTITUTION", "VOLUNTEER_PAYMENT", "VOLUNTEER_PAYMENT_TITLEI",
					"WIA_TRAINING_AND_ALLOWANCE", "INCLUDED_UNEARNED_INCOME", "TANF_MAX_AU_ALLOTMENT", "TANF_MAX_GRG_ALLOTMENT",
					"CHARITABLE_DONATION", "CHILD_NUTRITION_PAYMENTS", "BLACK_LUNG_BENEFITS", "CHILD_SUPPORT_COURT", "CHILD_SUPPORT_GAP_PAYMENT",
					"CIVIL_SERVICE", "DEFERRED_COMPENSATION_PLANS", "DISABILITY_INSURANCE", "EXCLUDED_UNEARNED_INCOME", "FEMA_PAYMENT_DISASTER",
					"FEMA_PAYMENT_NON_DISASTER", "HEALTH_SAVINGS_ACCOUNT", "IN_KIND_SUPPORT", "FOSTER_GRANDPARENT_PROGRAM", "DISASTER_UNEMPLOYMENT",
					"DIVIDENDS", "CHARITABLE_DONATION_FEDERAL", "PRSN_INFO_STAT_SW", "PATIENT_FUND", "DISASTER_ASSISTANCE", "NON_BUSINESS_EQUIPMENT",
					"HOUSEHOLD_GOODS", "OTHER_NON_COUNTABLE", "OUT_ST_BNFT_CHG_IND", "SCHL_ENRL_CHG_IND", "MRTL_STAT_CHG_IND", "lqd_aset_c_a_resp",
					"lqd_aset_k_p_resp", "NUR_HME_CHG_IND", "BFR_TAX_CHG_IND", "INC_TAX_CHG_IND", "THRD_PRTY_CHG_IND", "DEATH_BENEFIT_STATE_FEDERAL",
					"SOCIAL_SECURITY_SURVIVOR", "VENDOR_PAYMENTS", "CITIZENSHIP_INFO","INDV_PRGM_CHG_IND","EMPL_HLTH_INS_RESP","AVD_PRSCTN_FSTF","HEAT_COOL_SRC","KATIE_BECKETT_MEDICAID_RESP"};

			final int dataCriteriaLength = dataCriteriaArray.length;
			for (int i = 0; i < dataCriteriaLength; i++) {
				dataCriteriaArray[i] = new FwDataCriteria();
				dataCriteriaArray[i].setColumn_name(colnames[aProgramIds[i]]);
				dataCriteriaArray[i].setColumn_value(aProgramValues[i]);
				dataCriteriaArray[i].setData_type(FwConstants.CHAR);
			}

			final FwDataCriteria[] whereCriteriaArray = new FwDataCriteria[2];
			whereCriteriaArray[0] = new FwDataCriteria();
			whereCriteriaArray[0].setColumn_name("APP_NUM");
			whereCriteriaArray[0].setColumn_value(aAppNum);
			whereCriteriaArray[0].setData_type(FwConstants.LONG);
			whereCriteriaArray[1] = new FwDataCriteria();
			whereCriteriaArray[1].setColumn_name("INDV_SEQ_NUM");
			whereCriteriaArray[1].setColumn_value(aIndvSeqNum);
			whereCriteriaArray[1].setData_type(FwConstants.SHORT);
			final RMC_IN_PRFL_CUST_Cargo cargo = new RMC_IN_PRFL_CUST_Cargo();
			cargo.setDataCriteria(dataCriteriaArray);
			cargo.setWhereCriteria(whereCriteriaArray);
			final RMC_IN_PRFL_CUST_Collection collec = new RMC_IN_PRFL_CUST_Collection();
			collec.setCargo(cargo);
			collec.persist(FwConstants.DAO, "updateAppInPrflTable");
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "persistStatus", e);
		}
	}

	/**
	 * @see gov.state.nextgen.access.management.applications.IRMCResponseProfileManager#getProfile(gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Collection,
	 *      java.lang.String)
	 */
	@Override
	public RMC_IN_PRFL_Cargo getProfile(final RMC_IN_PRFL_Collection aRmcInProfileCollection, final String aIndvSeqNum) {

		try {
			final int aAppInProfileCollectionSize = aRmcInProfileCollection.size();
			RMC_IN_PRFL_Cargo rmcInPrflCargo = null;
			for (int i = 0; i < aAppInProfileCollectionSize; i++) {
				rmcInPrflCargo = (RMC_IN_PRFL_Cargo) aRmcInProfileCollection.get(i);
				if (rmcInPrflCargo.getIndv_seq_num().equals(aIndvSeqNum)) {
					return rmcInPrflCargo;
				}
			}
			return null;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "getAppInProfile", e);
		}
	}

	/**
	 * @see gov.state.nextgen.access.management.applications.IRMCResponseProfileManager#getProfileResponse(gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Cargo,
	 *      short)
	 */
	@Override
	public String getProfileResponse(final RMC_IN_PRFL_Cargo aRmcInPrflCargo, final short aFieldId) {

		switch (aFieldId) {
		case ACCIDENT:
			return aRmcInPrflCargo.getAcdt_resp();
		case ADOPTION_ASSISTANCE:
			return aRmcInPrflCargo.getAdpt_asst_resp();
		case ALIMONY_RECEIVED:
			return aRmcInPrflCargo.getAlmy_rcv_resp();
		case BENEFIT_ANNUITIES:
			return aRmcInPrflCargo.getBnft_anty_resp();
		case BENEFIT_CHARITY:
			return aRmcInPrflCargo.getBnft_chrt_resp();
		case BENEFIT_DISABLE:
			return aRmcInPrflCargo.getBnft_dabl_resp();
		case BENEFIT_DIVIDEND:
			return aRmcInPrflCargo.getBnft_divnd_resp();
		case BENEFIT_TRUST:
			return aRmcInPrflCargo.getBnft_est_trst_resp();
		case BENEFIT_RAILROAD_RETIREMENT:
			return aRmcInPrflCargo.getBnft_rr_resp();
		case BENEFIT_UNEMPLOYMENT:
			return aRmcInPrflCargo.getBnft_uempl_resp();
		case BENEFIT_VETERAN:
			return aRmcInPrflCargo.getBnft_vet_resp();
		case CHILD_SUPPORT_PAYMENT:
			return aRmcInPrflCargo.getChld_sprt_pay_resp();
		case DISABLE:
			return aRmcInPrflCargo.getDabl_resp();
		case DEPENDENT_CARE:
			return aRmcInPrflCargo.getDpnd_care_resp();
		case DRUG_FELON:
			return aRmcInPrflCargo.getDrug_feln_resp();
		case FSET_SANCTION:
			return aRmcInPrflCargo.getFset_sctn_resp();
		case FOSTER_CARE:
			return aRmcInPrflCargo.getFstr_care_resp();
		case GENERAL_RELIEF:
			return aRmcInPrflCargo.getGen_rlf_resp();
		case HEALTHCARE_COVERAGE:
			return aRmcInPrflCargo.getHc_cvrg_resp();
		case INCOME_INTEREST:
			return aRmcInPrflCargo.getIncm_int_resp();
		case INDIVIDUAL_FAMILY_MEDICAID:
			return aRmcInPrflCargo.getIndv_fma_rqst_ind();
		case INDIVIDUAL_FPW:
			return aRmcInPrflCargo.getIndv_fpw_rqst_ind();
		case INDIVIDUAL_FOODSHARE:
			return aRmcInPrflCargo.getIndv_fs_rqst_ind();
		case IREW:
			return aRmcInPrflCargo.getIrwe_resp();
		case KINSHIP_CARE:
			return aRmcInPrflCargo.getKinship_care_resp();
		case MEDICAL_EXPENSE:
			return aRmcInPrflCargo.getMed_exp_resp();
		case MILITARY_ALLOTMENT:
			return aRmcInPrflCargo.getMil_allot_resp();
		case MONEY_FROM_ANOTHER_PERSON:
			return aRmcInPrflCargo.getMony_othr_resp();
		case REFUGE:
			return aRmcInPrflCargo.getNatl_rfge_resp();
		case NEEDY_INDIAN:
			return aRmcInPrflCargo.getNeed_ind_resp();
		case ON_STRIKE:
			return aRmcInPrflCargo.getOn_strk_sw();
		case OTHER_PENSION:
			return aRmcInPrflCargo.getOp_aoda_tmt_rcv_sw();
		case OTHER_INCOME:
			return aRmcInPrflCargo.getOthr_incm_resp();
		case OTHER_SOURCE:
			return aRmcInPrflCargo.getOthr_src_resp();
		case OWNER_ASSET:
			return aRmcInPrflCargo.getOwn_aset_resp();
		case PAY_HOUSING_BILL:
			return aRmcInPrflCargo.getPay_hous_bill_resp();
		case PREGNANCY:
			return aRmcInPrflCargo.getPreg_resp();
		case JOB_IN_KIND:
			return aRmcInPrflCargo.getJob_iknd_resp();
		case PAY_ROOM_AND_BOARD:
			return aRmcInPrflCargo.getPay_rmr_brd_resp();
		case PENSION_RETIREMENT:
			return aRmcInPrflCargo.getPnsn_retr_resp();
		case PROPERTY_SOLD:
			return aRmcInPrflCargo.getProp_sold_resp();
		case RECEIVE_FS_IN_OTHER_STATE:
			return aRmcInPrflCargo.getRcv_fs_oth_st_resp();
		case RECEIVE_HOUSING_ASSET:
			return aRmcInPrflCargo.getRcv_hous_asst_resp();
		case RECEIVE_MEDICARE:
			return aRmcInPrflCargo.getRcv_medcr_resp();
		case RECEIVE_SOCIAL_SECURITY:
			return aRmcInPrflCargo.getRcv_ss_resp();
		case RECEIVE_SSI_LETTER:
			return aRmcInPrflCargo.getRcv_ssi_ltr_resp();
		case RECEIVE_SSI:
			return aRmcInPrflCargo.getRcv_ssi_sw();
		case ROOM_AND_BOARD:
			return aRmcInPrflCargo.getRmr_brd_incm_resp();
		case SELF_EMPLOYMENT:
			return aRmcInPrflCargo.getSelf_empl_resp();
		case RECEIVE_SSI_DCOND:
			return aRmcInPrflCargo.getSsi_dcond_resp();
		case RECEIVE_SSI_1619B:
			return aRmcInPrflCargo.getSsi_1619b_rcv_sw();
		case SHELTER_COST_ASSESSMENT:
			return aRmcInPrflCargo.getSu_ases_resp();
		case SHELTER_COST_COAL:
			return aRmcInPrflCargo.getSu_cst_coal_resp();
		case SHELTER_COST_ELECTRICTY:
			return aRmcInPrflCargo.getSu_cst_elec_resp();
		case SHELTER_COST_FUEL:
			return aRmcInPrflCargo.getSu_cst_fuel_resp();
		case SHELTER_COST_GAS:
			return aRmcInPrflCargo.getSu_cst_gas_resp();
		case SHELTER_COST_HOME:
			return aRmcInPrflCargo.getSu_cst_home_resp();
		case SHELTER_COST_INSTALL:
			return aRmcInPrflCargo.getSu_cst_istl_resp();
		case SHELTER_COST_LPGAS:
			return aRmcInPrflCargo.getSu_cst_lpgas_resp();
		case SHELTER_COST_MOBILE_HOME:
			return aRmcInPrflCargo.getSu_cst_mbl_resp();
		case SHELTER_COST_MORTGAGE:
			return aRmcInPrflCargo.getSu_cst_mtge_resp();
		case SHELTER_COST_OTHER:
			return aRmcInPrflCargo.getSu_cst_othr_resp();
		case SHELTER_COST_PHONE:
			return aRmcInPrflCargo.getSu_cst_phn_resp();
		case SHELTER_COST_RENT:
			return aRmcInPrflCargo.getSu_cst_rent_resp();
		case SHELTER_COST_SEWER:
			return aRmcInPrflCargo.getSu_cst_swr_resp();
		case SHELTER_COST_TAX:
			return aRmcInPrflCargo.getSu_cst_tax_resp();
		case SHELTER_COST_TRASH:
			return aRmcInPrflCargo.getSu_cst_trsh_resp();
		case SHELTER_COST_WOOD:
			return aRmcInPrflCargo.getSu_cst_wood_resp();
		case SHELTER_COST_WATER:
			return aRmcInPrflCargo.getSu_cst_wtr_resp();
		case SHELTER_COST_WASTE:
			return aRmcInPrflCargo.getSu_cst_wwt_resp();
		case TRIBAL_TANF:
			return aRmcInPrflCargo.getTrb_tanf_resp();
		case UTILITY_EXPENSE:
			return aRmcInPrflCargo.getUtil_exp_resp();
		case WORKER_COMP:
			return aRmcInPrflCargo.getWork_comp_resp();
		case TRIBAL_CAPITA:
			return aRmcInPrflCargo.getTrb_cpta_resp();
		case EDUCATIONAL_AID:
			return aRmcInPrflCargo.getEduc_aid_resp();
		case WHEAP:
			return aRmcInPrflCargo.getWheap_resp();
		case REGULAR_EMPL:
			return aRmcInPrflCargo.getEmpl_resp();
		case BNFT_CHL_SPRT_RESP:
			return aRmcInPrflCargo.getBnft_chl_sprt_resp();
		case PUB_ASST_RESP:
			return aRmcInPrflCargo.getPub_asst_resp();
		case YEHOC_RESP:
			return aRmcInPrflCargo.getYehoc_resp();
			// PCR 35980
		case PAST_HEALTHCARE_COVERAGE:
			return aRmcInPrflCargo.getPast_hc_cvrg_resp();

			// PCR# 40362 - ADDED NEW RESPONSES FOR RMB AND SMRF CHANGES -
			// starts
		case MAPP_BENEFITS_RESP:
			return aRmcInPrflCargo.getBnft_mapp_resp();

		case BUR_AST_CASKET:
			return aRmcInPrflCargo.getBury_aset_oth_resp();

		case BUR_AST_IRREVOCABLE:
			return aRmcInPrflCargo.getBury_aset_rbt_resp();

		case BUR_AST_INSURANCE:
			return aRmcInPrflCargo.getBury_aset_ins_resp();

		case BUR_AST_MAUSOLEUM:
			return aRmcInPrflCargo.getBury_aset_mas_resp();

		case BUR_AST_OTHER:
			return aRmcInPrflCargo.getBury_aset_oth_resp();

		case BUR_AST_PLOT:
			return aRmcInPrflCargo.getBury_aset_plt_resp();

		case BUR_AST_REVOCABLE:
			return aRmcInPrflCargo.getBury_aset_rbt_resp();

		case BUR_AST_VAULT:
			return aRmcInPrflCargo.getBury_aset_v_resp();

		case LIF_AST_GROUP_LIFE:
			return aRmcInPrflCargo.getLi_aset_g_l_resp();

		case LIF_AST_GROUP_TERM:
			return aRmcInPrflCargo.getLi_aset_g_t_resp();

		case LIF_AST_TERM:
			return aRmcInPrflCargo.getLi_aset_trm_resp();

		case LIF_AST_UNIVERSAL:
			return aRmcInPrflCargo.getLi_aset_unv_resp();

		case LIF_AST_WHOLE_LIFE:
			return aRmcInPrflCargo.getLi_aset_w_l_resp();

		case LIQ_ASET_CASH:
			return aRmcInPrflCargo.getLiquid_asset_cash_resp();
		case LIQUID_ASSET_XFER:
			return aRmcInPrflCargo.getLqd_aset_tr_f_resp();
		case LIQUID_ASSET_ANNUITY:
			return aRmcInPrflCargo.getLiquid_aset_disable_blind_resp();
		case LIQUID_ASSET_IRA:
			return aRmcInPrflCargo.getLiquid_asset_ira_resp();
		case LIQUID_ASSET_IRS_RET:
			return aRmcInPrflCargo.getLiquid_asset_irs_retirmnt_resp();
		case LIQUID_ASSET_SAVINGS_ACC:
			return aRmcInPrflCargo.getLiquid_asset_savings_acc_resp();
		case LIQUID_ASSET_PENSION_PLAN:
			return aRmcInPrflCargo.getLiquid_asset_pension_plan_resp();
		case LIQUID_ASSET_PROMISSORY:
			return aRmcInPrflCargo.getLiquid_asset_promissory_resp();
		case LIQUID_ASSET_RETIREMENT:
			return aRmcInPrflCargo.getLiquid_asset_retirement_resp();
		case LIQUID_ASSET_STOCK_BONDS:
			return aRmcInPrflCargo.getLiquid_asset_stocks_bonds_resp();
		case LIQUID_ASSET_TRUST_FUND:
			return aRmcInPrflCargo.getLiquid_asset_trust_fund_resp();
		case LIQUID_ASSET_OTHER:
			return aRmcInPrflCargo.getLiquid_asset_other_response();
		case LIQUID_ASSET_OTHER_TYPE:
			return aRmcInPrflCargo.getLiquid_asset_other_type_resp();
		case LIQUID_ASET_BANK:
			return aRmcInPrflCargo.getLiquid_asset_bank_acc_resp();

		case LIQ_ASET_HOME_SALE:
			return aRmcInPrflCargo.getLqd_aset_h_s_resp();

		case LIQ_ASET_US_BOND:
			return aRmcInPrflCargo.getLqd_aset_us_b_resp();

		case OTHR_ASET_BURIAL:
			return aRmcInPrflCargo.getOther_asset_burial_resp();

		case OTHR_ASET_LIFE_INSURANCE:
			return aRmcInPrflCargo.getOther_aset_life_insurance_resp();

		case OTHR_ASET_PERSONAL_PROPERTY:
			return aRmcInPrflCargo.getOther_asset_personal_prop_resp();

		case OTHR_ASET_REAL_PROPERTY:
			return aRmcInPrflCargo.getOther_asset_real_property_resp();

		case OTHR_ASET_VEHICLE:
			return aRmcInPrflCargo.getOther_asset_vehicle_resp();

		case OTHR_ASET_TRANSFER:
			return aRmcInPrflCargo.getOther_asset_transfer_resp();

		case REAL_ASET_APARTMENT:
			return aRmcInPrflCargo.getReal_aset_apt_resp();

		case REAL_ASET_COMMERCIAL:
			return aRmcInPrflCargo.getReal_aset_com_resp();

		case REAL_ASET_CONDO:
			return aRmcInPrflCargo.getReal_aset_con_resp();

		case REAL_ASET_RENTAL:
			return aRmcInPrflCargo.getReal_asset_rental_resp();

		case REAL_ASET_DUPLEX:
			return aRmcInPrflCargo.getReal_aset_dup_resp();

		case REAL_ASET_FARM:
			return aRmcInPrflCargo.getReal_aset_frm_resp();

		case REAL_ASET_HOUSE:
			return aRmcInPrflCargo.getReal_asset_house_resp();

		case REAL_ASET_LAND:
			return aRmcInPrflCargo.getReal_asset_land_resp();

		case REAL_ASET_MOBILE_HOME:
			return aRmcInPrflCargo.getReal_asset_mobile_home_resp();

		case REAL_ASET_OTHER:
			return aRmcInPrflCargo.getReal_asset_other_resp();
		case REAL_ASET_HOME:
			return aRmcInPrflCargo.getReal_asset_home_resp();
		case REAL_ASET_LIFE_ESTATE:
			return aRmcInPrflCargo.getReal_asset_life_estate_resp();
		case REAL_ASET_UNOCCUPY_HOME:
			return aRmcInPrflCargo.getReal_asset_unoccupy_home_resp();
		case REAL_ASET_VAC:
			return aRmcInPrflCargo.getReal_aset_vac_resp();

		case VEH_ASET_ANIMAL_DRAWN:
			return aRmcInPrflCargo.getVehicle_asset_animal_drwn_resp();
		case VEH_ASET_NONMOTORIZED_CAMPER:
			return aRmcInPrflCargo.getVehicle_asset_nmot_camper_resp();
		case VEH_ASET_GOLFCART:
			return aRmcInPrflCargo.getVehicle_asset_golf_cart_resp();
		case VEH_ASET_TRACTOR:
			return aRmcInPrflCargo.getVehicle_asset_tractor_resp();
		case VEH_ASET_AIRPLANE:
			return aRmcInPrflCargo.getVeh_aset_arpl_resp();
		case VEH_ASET_UNLIC:
			return aRmcInPrflCargo.getVeh_aset_unlic_resp();

		case VEH_ASET_AUTOMOBILE:
			return aRmcInPrflCargo.getVehicle_asset_auto_resp();

		case VEH_ASET_BOAT:
			return aRmcInPrflCargo.getVehicle_asset_boat_resp();

		case VEH_ASET_BUS:
			return aRmcInPrflCargo.getVeh_aset_bus_resp();

		case VEH_ASET_CAMPER:
			return aRmcInPrflCargo.getVehicle_asset_camper_resp();

		case VEH_ASET_FARM_IMPLEMENT:
			return aRmcInPrflCargo.getVeh_aset_fimp_resp();

		case VEH_ASET_FARM_EQUIP:
			return aRmcInPrflCargo.getVeh_aset_fmeq_resp();

		case VEH_ASET_FARM_TRACTOR:
			return aRmcInPrflCargo.getVeh_aset_ftrc_resp();

		case VEH_ASET_FARM_TRAILER:
			return aRmcInPrflCargo.getVeh_aset_ftrl_resp();

		case VEH_ASET_LOG_SKIDDER:
			return aRmcInPrflCargo.getVeh_aset_lskd_resp();

		case VEH_ASET_MOTORCYCLE:
			return aRmcInPrflCargo.getVehicle_asset_motorcycle_resp();

		case VEH_ASET_NONMOTORIZED_BOAT:
			return aRmcInPrflCargo.getVeh_aset_nm_b_resp();

		case VEH_ASET_OTHER:
			return aRmcInPrflCargo.getVeh_aset_othr_resp();

		case VEH_ASET_RECREATIONAL_VEHICLE:
			return aRmcInPrflCargo.getVehicle_asset_recreation_resp();

		case VEH_ASET_SNOWMOBILE:
			return aRmcInPrflCargo.getVeh_aset_s_mb_resp();

		case VEH_ASET_TRUCK:
			return aRmcInPrflCargo.getVeh_aset_trk_resp();

		case VEH_ASET_TRAVEL_TRAILER:
			return aRmcInPrflCargo.getVeh_aset_trlr_resp();

		case VEH_ASET_VAN:
			return aRmcInPrflCargo.getVeh_aset_van_resp();

		case INDV_CC_RQST_IND:
			return aRmcInPrflCargo.getIndv_cc_rqst_ind();

		case INDV_TANF_RQST_IND:
			return aRmcInPrflCargo.getIndv_tanf_rqst_ind();

		case INDV_WIC_RQST_IND:
			return aRmcInPrflCargo.getIndv_wic_rqst_ind();

		case SCHL_ENRL_RESP:
			return aRmcInPrflCargo.getSchool_enrollment_resp();
		case TRB_CMDY_RESP:
			return aRmcInPrflCargo.getTrb_cmdy_resp();
		case CP_WLST_RESP:
			return aRmcInPrflCargo.getCp_wlst_resp();
		case INDIVIDUAL_CLA:
			return aRmcInPrflCargo.getIndv_cla_ind();
		case HEAD_OF_HOUSE:
			return aRmcInPrflCargo.getHead_of_household_resp();
		case STUDENT_FINANCIAL_AID:
			return aRmcInPrflCargo.getStudent_financial_aid_resp();
		case BLACK_LUNG_BENEFIT:
			return aRmcInPrflCargo.getBenefit_black_lung_resp();
		case CASH_GIFTS_CONT:
			return aRmcInPrflCargo.getCash_gifts_resp();
		case FOOD_CLOTHING_UTIL_RENT:
			return aRmcInPrflCargo.getFood_clothing_util_rent_resp();
		case INHERITANCE:
			return aRmcInPrflCargo.getInheritance_resp();
		case INSURANCE_SETTLEMENT:
			return aRmcInPrflCargo.getInsurance_settlement_resp();
		case LOAN:
			return aRmcInPrflCargo.getLoan_resp();
		case LOTTERY_PRIZE_WINNING:
			return aRmcInPrflCargo.getLottery_prize_winning_resp();
		case STRIKE_BENEFITS_RESP:
			return aRmcInPrflCargo.getBenefits_on_strike_resp();
		case TRAINING_ALLOWANCE:
			return aRmcInPrflCargo.getTraining_allowance_resp();
		case OTHR_SOCIAL_SECURITY_BENEFITS:
			return aRmcInPrflCargo.getOthr_social_security_bnft_resp();
		case RESETTL_INC_RESP:
			return aRmcInPrflCargo.getResettl_inc_resp();
		case OTHR_INCM_RENTL_RESP:
			return aRmcInPrflCargo.getOthr_incm_rentl_resp();
		case LAND_CONT_RESP:
			return aRmcInPrflCargo.getLand_cont_resp();
		case HOUSING_BILLS_OTHERS:
			return aRmcInPrflCargo.getHousing_bill_others_resp();
		case UTILITY_BILLS_OIL:
			return aRmcInPrflCargo.getUtility_bills_oil_resp();
		case WORK_RELATED_EXPENSE_RESP:
			return aRmcInPrflCargo.getWork_related_expense_resp();
		case LIFE_INS_ASSET_WHOLE_LIFE_RESP:
			return aRmcInPrflCargo.getLife_ins_asset_whole_life_resp();
		case LIFE_INSURANCE_ASSET_TERM_RESP:
			return aRmcInPrflCargo.getLife_insurance_asset_term_resp();
		case LIFE_INS_ASEST_GROUP_LIFE_RESP:
			return aRmcInPrflCargo.getLife_ins_asest_group_life_resp();
		case LIFE_INS_ASSET_GROUP_TERM_RESP:
			return aRmcInPrflCargo.getLife_ins_asset_group_term_resp();
		case LIFE_INS_ASSET_UNIVERSAL_RESP:
			return aRmcInPrflCargo.getLife_ins_asset_universal_resp();
		case LIFE_INSURANCE_OTHER_RESP:
			return aRmcInPrflCargo.getLife_insurance_other_resp();
		case MED_TYPE_PROSTHETIC_RESP:

			return aRmcInPrflCargo.getMed_type_prosthetic_resp();

		case MED_TYPE_ATNDNT_MEAL_RESP:

			return aRmcInPrflCargo.getMed_type_atndnt_meal_resp();
		case MED_TYPE_ANIMAL_RESP:

			return aRmcInPrflCargo.getMed_type_animal_resp();
		case MED_TYPE_MAINTAIN_ATTNDNT_RESP:

			return aRmcInPrflCargo.getMed_type_maintain_attndnt_resp();
		case MED_TYPE_INHOME_RESP:

			return aRmcInPrflCargo.getMed_type_inhome_resp();
		case MED_TYPE_SPECIAL_EQUIP_RESP:

			return aRmcInPrflCargo.getMed_type_special_equip_resp();
		case MED_TYPE_EYEGLASSES_RESP:

			return aRmcInPrflCargo.getMed_type_eyeglasses_resp();
		case MED_TYPE_INSURANCE_RESP:

			return aRmcInPrflCargo.getMed_type_insurance_resp();
		case MED_TYPE_BILLS_RESP:
			return aRmcInPrflCargo.getMed_type_bills_resp();
		case MED_TYPE_SUPPLIES_RESP:

			return aRmcInPrflCargo.getMed_type_supplies_resp();
		case MED_TYPE_NURSING_RESP:

			return aRmcInPrflCargo.getMed_type_nursing_resp();
		case MED_TYPE_OTHER_RESP:

			return aRmcInPrflCargo.getMed_type_other_resp();
		case MED_TYPE_OUT_PATIENT_RESP:

			return aRmcInPrflCargo.getMed_type_out_patient_resp();
		case MED_TYPE_PSYCHOTHERAPY_RESP:

			return aRmcInPrflCargo.getMed_type_psychotherapy_resp();
		case MED_TYPE_PRESCRIBED_DRUG_RESP:

			return aRmcInPrflCargo.getMed_type_prescribed_drug_resp();
		case MED_TYPE_TRANSPORTATION_RESP:

			return aRmcInPrflCargo.getMed_type_transportation_resp();

		case UTILITY_STANDARD_RESP:
			return aRmcInPrflCargo.getUtility_standard_resp();

		case OTHR_INCM_CONTRIB_RESP:
			return aRmcInPrflCargo.getOther_incm_contrib_resp();
		case OTHR_INCM_TRBL_RESP:
			return aRmcInPrflCargo.getOthr_incm_trbl_resp();
		case HOSPITAL_STAY_RESP:
			return aRmcInPrflCargo.getHospital_stay_resp();
		case CHILD_CARE_RESP:
			return aRmcInPrflCargo.getChild_care_resp();
		case CHILD_OBLIGATION_RESP:
			return aRmcInPrflCargo.getChild_obligation_resp();
		case MEDICAL_BILLS_RESP:
			return aRmcInPrflCargo.getMedical_bills_resp();
		case MEDTYP_DENTAL:
			return aRmcInPrflCargo.getMedtyp_dental();
		case MEDTYP_ATTENDANT_CARE:
			return aRmcInPrflCargo.getMedtyp_attendant_care();
		case MEDTYP_DOCTOR:
			return aRmcInPrflCargo.getMedtyp_doctor();
		case MEDTYP_MED_EQUIP:
			return aRmcInPrflCargo.getMedtyp_med_equip();
		case MEDTYP_HOSP_BILLS:
			return aRmcInPrflCargo.getMedtyp_hosp_bills();
		case MEDTYP_INSUR_PREMIUM:
			return aRmcInPrflCargo.getMedtyp_insur_premium();
		case MEDTYP_RX_COST:
			return aRmcInPrflCargo.getMedtyp_rx_cost();
		case MEDTYP_TRANS_MED:
			return aRmcInPrflCargo.getMedtyp_trans_med();
		case MEDTYP_OTHER:
			return aRmcInPrflCargo.getMedtyp_other();
		case UNPAID_MEDBILL:
			return aRmcInPrflCargo.getUnpaid_medbill();
		case MEDTYP_HSA_CONTRIB:
			return aRmcInPrflCargo.getMedtyp_hsa_contrib();
		case UEI_ADOPTION_ASSIST:
			return aRmcInPrflCargo.getAdoptAssistance();
		case UEI_ADOPTION_PYMT:
			return aRmcInPrflCargo.getAdoptionPayments();
		case UEI_AGENT_ORNG_PYMT:
			return aRmcInPrflCargo.getAgentOrangePayments();
		case UEI_ALIMONY:
			return aRmcInPrflCargo.getAlimony();
		case UEI_CAPITAL_GAINS:
			return aRmcInPrflCargo.getCapitalGains();
		case UEI_DEATH_BNFT:
			return aRmcInPrflCargo.getDeathBenefits();
		case UEI_DABL_INCM:
			return aRmcInPrflCargo.getDisabilityIncome();
		case UEI_DR_RELIEF:
			return aRmcInPrflCargo.getDisasterRelief();
		case UEI_EDU_ASSIST:
			return aRmcInPrflCargo.getEducationalAssistance();
		case UEI_ENERGY_ASSIST:
			return aRmcInPrflCargo.getEnergyAssistance();
		case UEI_FRM_ALOT:
			return aRmcInPrflCargo.getFarmAllotment();
		case UEI_FOSTER_CARE_PYMT:
			return aRmcInPrflCargo.getFosterCarePayments();
		case UEI_GEN_ASSIST:
			return aRmcInPrflCargo.getGeneralAssistance();
		case UEI_INT_DIV_PYMT:
			return aRmcInPrflCargo.getInterestDividendPayments();
		case UEI_IRA_DIST:
			return aRmcInPrflCargo.getiRADistribution();
		case UEI_LOTTERY_WIN:
			return aRmcInPrflCargo.getLotteryWinnings();
		case UEI_LUMP_SUM:
			return aRmcInPrflCargo.getLumpSum();
		case UEI_MIL_ALOT:
			return aRmcInPrflCargo.getMilitaryAllotment();
		case UEI_MON_FRO_OTH:
			return aRmcInPrflCargo.getMoneyFromAnotherPerson();
		case UEI_NET_RENT_ROYALTY:
			return aRmcInPrflCargo.getNetRentalRoyalty();
		case UEI_OTH:
			return aRmcInPrflCargo.getOtherIncome();
		case UEI_ANNY_PYMT:
			return aRmcInPrflCargo.getPaymentsFromAnnuity();
		case UEI_PYMT_BO:
			return aRmcInPrflCargo.getPaymentsMadeOnYourBehalf();
		case UEI_PENSION:
			return aRmcInPrflCargo.getPensionOrRetirement();
		case UEI_RR_RETIRE:
			return aRmcInPrflCargo.getRailroadRetirement();
		case UEI_REFUGEE_CASH:
			return aRmcInPrflCargo.getRefugeeCash();
		case UEI_REL_CARE:
			return aRmcInPrflCargo.getRelativeCareSubsidy();
		case UEI_RENTAL_INCM:
			return aRmcInPrflCargo.getRentalIncome();
		case UEI_TANF_PYMT:
			return aRmcInPrflCargo.gettANFPayments();
		case UEI_UNEMPL:
			return aRmcInPrflCargo.getUnemploymentCompensation();
		case UEI_WORKER_STUDY:
			return aRmcInPrflCargo.getWorkStudyStateFederal();
		case UEI_WORKER_COMP:
			return aRmcInPrflCargo.getWorkersCompensation();
		case SPECIAL_NEED:
			return aRmcInPrflCargo.getSpecial_need_resp();
		case FOSTER_CARE_RESP:
			return aRmcInPrflCargo.getFoster_care_resp();
		case FORMER_FOSTER_RESP:
			return aRmcInPrflCargo.getFormer_foster_resp();
		case CHILD_PROTECTIVE_RESP:
			return aRmcInPrflCargo.getChild_protective_resp();
		case LIVING_PROG_RESP:
			return aRmcInPrflCargo.getLiving_prog_resp();
		case GRAND_PARENT_RESP:
			return aRmcInPrflCargo.getGrand_parent_resp();
		case DRUG_FELONIES_RESP:
			return aRmcInPrflCargo.getDrug_felonies_resp();
		case SNAP_TANF_DISC_RESP:
			return aRmcInPrflCargo.getSnap_tanf_disc_resp();
		case TANF_DISC_RESP:
			return aRmcInPrflCargo.getTanfDiscResp();
		case AVOID_PROSC_RESP:
			return aRmcInPrflCargo.getAvoid_prosc_resp();
		case AVD_PRSCTN_FSTF:
			return aRmcInPrflCargo.getAvd_prsctn_fstf();
		case VIOLATING_PAROLE_RESP:
			return aRmcInPrflCargo.getViolating_parole_resp();
		case CONVIC_FALSE_INFO_RESP:
			return aRmcInPrflCargo.getConvic_false_info_resp();
		case VOLUNTARILY_QUIT_JOB_RESP:
			return aRmcInPrflCargo.getVoluntarily_quit_job_resp();
		case TRADING_SNAP_RESP:
			return aRmcInPrflCargo.getTrading_snap_resp();
		case BUY_SELL_SNAP_RESP:
			return aRmcInPrflCargo.getBuy_sell_snap_resp();
		case TRADE_SNAP_GUN_RESP:
			return aRmcInPrflCargo.getTrade_snap_gun_resp();
		case PREV_SSI_RESP:
			return aRmcInPrflCargo.getPrev_ssi_resp();
		case HOME_COMMUNITY_RESP:
			return aRmcInPrflCargo.getHome_community_resp();
		case TRIBAL_HEALTH_RESP:
			return aRmcInPrflCargo.getTribal_health_resp();
		case TRIBAL_ELIGIBILITY_RESP:
			return aRmcInPrflCargo.getTribal_eligibility_resp();
		case DOMESTIC_VIOLENCE_RESP:
			return aRmcInPrflCargo.getDomestic_violence_resp();
		case TANF_EPPIC_RESP:
			return aRmcInPrflCargo.getTanf_eppic_resp();
		case EMERGENCY_MEDICAL_RESP:
			return aRmcInPrflCargo.getEmergency_medical_resp();

		case PERS_PROP_BUS_EQPT:
			return aRmcInPrflCargo.getPers_prop_bus_eqpt();
		case PERS_PROP_CEMETARY_LOT:
			return aRmcInPrflCargo.getPers_prop_cemetary_lot();
		case PERS_PROP_LIVESTOCK:
			return aRmcInPrflCargo.getPers_prop_livestock();
		case PERS_PROP_SAF_DEPST_BOX:
			return aRmcInPrflCargo.getPers_prop_saf_depst_box();
		case PERS_PROP_OTH_VAL:
			return aRmcInPrflCargo.getPers_prop_oth_val();
		case MOVED_OUT_OF_HOME_RESP:
			return aRmcInPrflCargo.getMoved_out_of_home_resp();
		case PRSN_INFO_STAT_SW:
			return aRmcInPrflCargo.getPersonal_info();
		case CITIZENSHIP_INFO:
			return aRmcInPrflCargo.getCitizenship_info();
		case RLT_CHG_STAT_SW:
			return aRmcInPrflCargo.getRlt_chg_stat_sw();
		case OUTSTATE_BNFTS:
			return aRmcInPrflCargo.getOutstate_bnft_resp();
		case HOUS_PICE:
			return aRmcInPrflCargo.getHospice_resp();

		case ABLE_TO_CONCEIVE_RESP:
			return aRmcInPrflCargo.getAble_to_conceive_resp();
		case UNDERWEIGHT_BIRTH_RESP:
			return aRmcInPrflCargo.getUnderweight_birth_resp();
		case PREG_ADD_STAT_SW:
			return aRmcInPrflCargo.getPreg_add_stat_sw();
		case PREG_CHG_STAT_SW:
			return aRmcInPrflCargo.getPreg_chg_stat_sw();

		case SU_CST_INS_RESP:
			return aRmcInPrflCargo.getSu_cst_ins_resp();
		case OTHER_HOUSING_BILL_RESP:
			return aRmcInPrflCargo.getOther_housing_bill_resp();
		case DISASTER_REPAIR_RESP:
			return aRmcInPrflCargo.getDisaster_repair_resp();
		case PREVENT_EVICTION_RESP:
			return aRmcInPrflCargo.getPrevent_eviction_resp();
		case CARE_TAKER_RESP:
			return aRmcInPrflCargo.getCareTaker_resp();
		case LOST_HEALTH_INS_IND:
			return aRmcInPrflCargo.getLost_health_ins_ind();
		case TAX_CLAIM_DEPENDENT:
			return aRmcInPrflCargo.getTax_claim_dependant_resp();

		case BEFORE_TAX_DEDUCTION:
			return aRmcInPrflCargo.getBefore_tax_deduction_resp();

		case BTD_MED_INS:
			return aRmcInPrflCargo.getBtd_med_ins();

		case BTD_DENT_INS:
			return aRmcInPrflCargo.getBtd_dent_ins();

		case BTD_VIS_CARE_INS:
			return aRmcInPrflCargo.getBtd_vis_care_ins();

		case BTD_FLEX_ACC:
			return aRmcInPrflCargo.getBtd_flex_acc();

		case BTD_DEF_COMP:
			return aRmcInPrflCargo.getBtd_def_comp();

		case BTD_PRE_TAX_INS:
			return aRmcInPrflCargo.getBtd_pre_tax_ins();

		case BTD_OTHER:
			return aRmcInPrflCargo.getBtd_other();

		case TAX_DEDUCT_RESP:
			return aRmcInPrflCargo.getTax_deduct_resp();
		case HLTH_INS_RESP:
			return aRmcInPrflCargo.getHlth_ins_resp();
		case OTHR_HLTH_INS_RESP:
			return aRmcInPrflCargo.getOthr_hlth_ins_resp();

			//add and change indicator

		case ROOM_BRD_CHG_IND:
			return aRmcInPrflCargo.getRoom_brd_chg_ind();
		case DABL_STAT_IND:
			return aRmcInPrflCargo.getDabl_stat_ind();
		case PREG_ADD_STAT_IND:
			return aRmcInPrflCargo.getPreg_add_stat_ind();
		case PREG_CHG_IND:
			return aRmcInPrflCargo.getPreg_chg_ind();
		case IRWE_CHG_IND:
			return aRmcInPrflCargo.getIrwe_chg_ind();
		case EI_CHG_IND:
			return aRmcInPrflCargo.getEi_chg_ind();
		case SELF_EMPL_CHG_IND:
			return aRmcInPrflCargo.getSelf_empl_chg_ind();
		case OTHR_INCM_CHG_IND:
			return aRmcInPrflCargo.getOthr_incm_chg_ind();
		case EMPL_CHG_IND:
			return aRmcInPrflCargo.getEmpl_chg_ind();
		case VEH_ASET_ADD_IND:
			return aRmcInPrflCargo.getVeh_aset_add_ind();
		case VEH_ASET_CHG_IND:
			return aRmcInPrflCargo.getVeh_aset_chg_ind();
		case REAL_ASET_ADD_IND:
			return aRmcInPrflCargo.getReal_aset_add_ind();
		case REAL_ASET_CHG_IND:
			return aRmcInPrflCargo.getReal_aset_chg_ind();
		case BURY_ASET_ADD_IND:
			return aRmcInPrflCargo.getBury_aset_add_ind();
		case BURY_ASET_CHG_IND:
			return aRmcInPrflCargo.getBury_aset_chg_ind();
		case LIQUID_ASSET_ADD_IND:
			return aRmcInPrflCargo.getLiquid_asset_add_ind();
		case LIQUID_ASSET_BANK_ACC_CHG_IND:
			return aRmcInPrflCargo.getLiquid_asset_bank_acc_chg_ind();
		case LIQUID_ASSET_CASH_CHG_IND:
			return aRmcInPrflCargo.getLiquid_asset_cash_chg_ind();
		case LIQUID_ASSET_CHG_IND:
			return aRmcInPrflCargo.getLiquid_asset_chg_ind();
		case LIQUID_ASSET_OTHER_CHG_IND:
			return aRmcInPrflCargo.getLiquid_asset_other_chg_ind();
		case LIFE_INS_ASET_ADD_IND:
			return aRmcInPrflCargo.getLife_ins_aset_add_ind();
		case LIFE_INS_ASET_CHG_IND:
			return aRmcInPrflCargo.getLife_ins_aset_chg_ind();
		case ASET_XFER_CHG_IND:
			return aRmcInPrflCargo.getAset_xfer_chg_ind();
		case DPND_CARE_CHG_IND:
			return aRmcInPrflCargo.getDpnd_care_chg_ind();
		case HEALTH_INSURANCE_CHG_IND:
			return aRmcInPrflCargo.getHealth_insurance_chg_ind();
		case OUT_ST_BNFT_CHG_IND:
			return aRmcInPrflCargo.getOut_st_bnft_chg_ind();
		case SCHL_ENRL_CHG_IND:
			return aRmcInPrflCargo.getSchl_enrl_chg_ind();
		case MRTL_STAT_CHG_IND:
			return aRmcInPrflCargo.getMrtl_stat_chg_ind();
		case NUR_HME_CHG_IND:
			return aRmcInPrflCargo.getNur_hme_chg_ind();
		case BFR_TAX_CHG_IND:
			return aRmcInPrflCargo.getBfr_tax_chg_ind();
		case INC_TAX_CHG_IND:
			return aRmcInPrflCargo.getInc_tax_chg_ind();
		case THRD_PRTY_CHG_IND:
			return aRmcInPrflCargo.getThrd_prty_chg_ind();
		case CHILD_SUPPORT_PAYMENT_CHG_IND:
			return aRmcInPrflCargo.getChild_support_payment_chg_ind();
		case SNAP_SHELTER_STANDARD_EXP_IND:
			return aRmcInPrflCargo.getSnap_shelter_standard_exp_ind();
		case HOUS_BILL_CHG_IND:
			return aRmcInPrflCargo.getHous_bill_chg_ind();
		case ADD_CHG_IND:
			return aRmcInPrflCargo.getAdd_chg_ind();
		case PERSON_MOVED_IN_STAT_IND:
			return aRmcInPrflCargo.getPerson_moved_in_stat_ind();
		case PERSON_MOVED_OUT_STAT_IND:
			return aRmcInPrflCargo.getPerson_moved_out_stat_ind();
		case HOSPICE_CHG_IND:
			return aRmcInPrflCargo.getHospice_chg_ind();
		case MEDICARE_CHG_IND:
			return aRmcInPrflCargo.getMedicare_chg_ind();
		case NCP_CHG_IND:
			return aRmcInPrflCargo.getNcp_chg_ind();
		case THIRD_PARTY_CHG_IND:
			return aRmcInPrflCargo.getThird_party_chg_ind();
		case HOSPITAL_ABD_CHG_IND:
			return aRmcInPrflCargo.getHospital_abd_chg_ind();
		case PUBLIC_LAW_ABD_CHG_IND:
			return aRmcInPrflCargo.getPublic_law_abd_chg_ind();
		case LIVING_ARGMT_CHG_IND:
			return aRmcInPrflCargo.getLiving_argmt_chg_ind();
		case OTHER_PROGRAM_CHG_IND:
			return aRmcInPrflCargo.getOther_program_chg_ind();
		case MAGI_EXPENSE_CHG_IND:
			return aRmcInPrflCargo.getMagi_expense_chg_ind();
		case TAX_INFO_IND:
			return aRmcInPrflCargo.getTax_info_ind();
		case TAX_DEPENDENT_IND:
			return aRmcInPrflCargo.getTax_dep_outside_resp();

		case MEDICARE_PART_A:
			return aRmcInPrflCargo.getMedicare_part_a();
		case MEDICARE_PART_B:
			return aRmcInPrflCargo.getMedicare_part_b();
		case MEDICARE_PART_C:
			return aRmcInPrflCargo.getMedicare_part_c();
		case MEDICARE_PART_D:
			return aRmcInPrflCargo.getMedicare_part_d();
		case CCSP_PROVIDER_PAYMENT:
			return aRmcInPrflCargo.getCssp_provider_payment();
		case ANIMALS_TO_ASSIST_DISABLED:
			return aRmcInPrflCargo.getAnimals_to_assist_disabled();
		case FUNERAL_DEATH_EXPENSE:
			return aRmcInPrflCargo.getFuneral_death_expense();
		case BLIND_WORK_EXPENSE:
			return aRmcInPrflCargo.getBlind_work_expense();
		case IMPAIRMENT_WORK_EXPENSE:
			return aRmcInPrflCargo.getImpairment_work_expense();
		case OTH_IND_GAMBL_PMNTS:
			return aRmcInPrflCargo.getOth_ind_gambl_pmnts();
		case BONDS:
			return aRmcInPrflCargo.getBonds();
		case DIVIDEND:
			return aRmcInPrflCargo.getDividend();
		case HEALTH_REIMBURSEMENT_ACCOUNT:
			return aRmcInPrflCargo.getHealth_reimbursement_account();
		case INDIVIDUAL_DEVELOPMENT_ACCOUNT:
			return aRmcInPrflCargo.getIndividual_development_account();
		case UNIFORM_GIFTS_TO_MINORS:
			return aRmcInPrflCargo.getUniform_gifts_to_minors();

		case INCOME_FROM_RESOURCE:
			return aRmcInPrflCargo.getIncome_from_resource();
		case INDIAN_GAMBLING_PAYMENTS:
			return aRmcInPrflCargo.getIndian_gambling_payments();
		case INHERITANCE_INCOME:
			return aRmcInPrflCargo.getInheritance_income();
		case INSUANCE_BENEFITS:
			return aRmcInPrflCargo.getInsuance_benefits();
		case LOAN_RECEIVED:
			return aRmcInPrflCargo.getLoan_received();
		case LOAN_REPAYMENT_INCOME:
			return aRmcInPrflCargo.getLoan_repayment_income();
		case MANAGED_INCOME:
			return aRmcInPrflCargo.getManaged_income();
		case MATCH_GRANT:
			return aRmcInPrflCargo.getMatch_grant();
		case MONTGOMERY_GI_BILL:
			return aRmcInPrflCargo.getMontgomery_gi_bill();
		case OUT_OF_STATE_PUBLIC:
			return aRmcInPrflCargo.getOut_of_state_public();

		case REFUNDS_FROM_DCH:
			return aRmcInPrflCargo.getRefunds_from_dch();
		case RESTITUTIONS_SETTLEMENTS:
			return aRmcInPrflCargo.getRestitutions_settlements();
		case SENIOR_COMPANION:
			return aRmcInPrflCargo.getSenior_companion();
		case SEVERANCE_PAY:
			return aRmcInPrflCargo.getSeverance_pay();
		case STRIKE_BENEFITS:
			return aRmcInPrflCargo.getStrike_benefits();
		case TRADE_READJUSTMENT:
			return aRmcInPrflCargo.getTrade_readjustment();
		case UNIFORM_RELOCATION:
			return aRmcInPrflCargo.getUniform_relocation();
		case UNION_FUNDS:
			return aRmcInPrflCargo.getUnion_funds();
		case VENDOR_EXCLUDED:
			return aRmcInPrflCargo.getVendor_excluded();
		case VICTIM_RESTITUTION:
			return aRmcInPrflCargo.getVictim_restitution();

		case VOLUNTEER_PAYMENT:
			return aRmcInPrflCargo.getVolunteer_payment();
		case VOLUNTEER_PAYMENT_TITLEI:
			return aRmcInPrflCargo.getVolunteer_payment_titlei();
		case WIA_TRAINING_AND_ALLOWANCE:
			return aRmcInPrflCargo.getWia_training_and_allowance();
		case INCLUDED_UNEARNED_INCOME:
			return aRmcInPrflCargo.getIncluded_unearned_income();
		case TANF_MAX_AU_ALLOTMENT:
			return aRmcInPrflCargo.getTanf_max_au_allotment();
		case TANF_MAX_GRG_ALLOTMENT:
			return aRmcInPrflCargo.getTanf_max_grg_allotment();
		case CHARITABLE_DONATION:
			return aRmcInPrflCargo.getCharitable_donation();
		case CHILD_NUTRITION_PAYMENTS:
			return aRmcInPrflCargo.getChild_nutrition_payments();
		case BLACK_LUNG_BENEFITS:
			return aRmcInPrflCargo.getBlack_lung_benefits();
		case CHILD_SUPPORT_COURT:
			return aRmcInPrflCargo.getChild_support_court();

		case CHILD_SUPPORT_GAP_PAYMENT:
			return aRmcInPrflCargo.getChild_support_gap_payment();
		case CIVIL_SERVICE:
			return aRmcInPrflCargo.getCivil_service();
		case DEFERRED_COMPENSATION_PLANS:
			return aRmcInPrflCargo.getDeferred_compensation_plans();
		case DISABILITY_INSURANCE:
			return aRmcInPrflCargo.getDisability_insurance();
		case EXCLUDED_UNEARNED_INCOME:
			return aRmcInPrflCargo.getExcluded_unearned_income();
		case FEMA_PAYMENT_DISASTER:
			return aRmcInPrflCargo.getFema_payment_disaster();
		case FEMA_PAYMENT_NON_DISASTER:
			return aRmcInPrflCargo.getFema_payment_non_disaster();
		case HEALTH_SAVINGS_ACCOUNT:
			return aRmcInPrflCargo.getHealth_savings_account();
		case IN_KIND_SUPPORT:
			return aRmcInPrflCargo.getIn_kind_support();
		case FOSTER_GRANDPARENT_PROGRAM:
			return aRmcInPrflCargo.getFoster_grandparent_program();

		case DISASTER_UNEMPLOYMENT:
			return aRmcInPrflCargo.getDisaster_unemployment();
		case DIVIDENDS:
			return aRmcInPrflCargo.getDividends();
		case CHARITABLE_DONATION_FEDERAL:
			return aRmcInPrflCargo.getCharitable_donation_federal();
		case PERSONAL_INFO:
			return aRmcInPrflCargo.getPersonal_info();
		case PATIENT_FUND:
			return aRmcInPrflCargo.getPatient_fund();

		case DISASTER_ASSISTANCE:
			return aRmcInPrflCargo.getDisaster_assistance();
		case NON_BUSINESS_EQUIPMENT:
			return aRmcInPrflCargo.getNon_business_equipment();
		case HOUSEHOLD_GOODS:
			return aRmcInPrflCargo.getHousehold_goods();
		case OTHER_NON_COUNTABLE:
			return aRmcInPrflCargo.getOther_non_countable();

		case LIQ_ASET_CHECKING_ACCOUNT:
			return aRmcInPrflCargo.getLqd_aset_c_a_resp();
		case LIQ_ASET_KEOUGH_PLAN:
			return aRmcInPrflCargo.getLqd_aset_k_p_resp();
		case DEATH_BENEFIT_STATE_FEDERAL:
			return aRmcInPrflCargo.getDeath_benefit_state_federal();
		case SOCIAL_SECURITY_SURVIVOR:
			return aRmcInPrflCargo.getSocial_security_survivor();
		case VENDOR_PAYMENTS:
			return aRmcInPrflCargo.getVendor_payments();
		case INDV_PRGM_CHG_IND:
			return aRmcInPrflCargo.getIndv_prgm_chg_ind();
		case EMPL_HLTH_INS_RESP:
			return aRmcInPrflCargo.getEmpl_hlth_ins_resp();
		case KATIE_BECKETT:
			return aRmcInPrflCargo.getMed_type_katie_beckett();

		default:
			log(ILog.INFO, "RMCResponseProfileManager.getProfileResponse() - Raising FwException manually on a condition");
			final FwException fe = new FwException("Incorrect field id : " + aFieldId + " passed.");
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("getProfileResponse");
			fe.setExceptionType(FwConstants.EXP_TYP_APPLICATION);
			fe.setExceptionText("Incorrect field id : " + aFieldId + " passed.");
			throw fe;
		}
	}

	@Override
	public boolean isRMCInPrflRespNotRequired(final RMC_IN_PRFL_Collection aRMCInProfileCollection, final short[] aRespId) {
		try {
			final int size = aRMCInProfileCollection.size();
			RMC_IN_PRFL_Cargo appInPrflCargo = null;
			for (int i = 0; i < size; i++) {
				appInPrflCargo = aRMCInProfileCollection.getCargo(i);
				for (int j = 0; j < aRespId.length; j++) {
					if (getProfileResponse(appInPrflCargo, aRespId[j]).charAt(0) != IRMCResponseProfileManager.STATUS_NOT_REQUIRED) {
						return false;
					}
				}
			}
			return true;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "isRMCInPrflRespNotRequired", e);
		}
	}

	@Override
	public RMC_IN_PRFL_Collection updateSessionProfile(final RMC_RESPONSE_Custom_Collection respColl, final RMC_IN_PRFL_Collection rmcInSessPrfl,
			final short[] responseArray) {

		int respCollSize = 0;
		int sessCollSize = 0;
		RMC_IN_PRFL_Cargo sessPrflCargo = null;
		boolean isPresent = false;
		RMC_RESPONSE_Custom_Cargo rmcRespCargo = null;
		if ((rmcInSessPrfl != null) && (!rmcInSessPrfl.isEmpty())) {
			sessCollSize = rmcInSessPrfl.size();
		}

		if ((respColl != null) && (!respColl.isEmpty())) {
			respCollSize = respColl.size();
		}
        
		if(rmcInSessPrfl !=null && !rmcInSessPrfl.isEmpty() && rmcInSessPrfl.size()>0){
		for (int i = 0; i < sessCollSize; i++) {
			sessPrflCargo = rmcInSessPrfl.getCargo(i);
			isPresent = false;
			if(respColl !=null && !respColl.isEmpty() && respColl.size()>0){
			for (int j = 0; j < respCollSize; j++) {
				rmcRespCargo = respColl.getCargo(j);
				if (sessPrflCargo.getIndv_seq_num().equals(rmcRespCargo.getIndvSeqNum())) {
					isPresent = true;
				}
			}
		}

			if (!isPresent) {
				makeNotRequired(responseArray, sessPrflCargo, true);
			}
		}
	}

		return rmcInSessPrfl;
	}
	
	
	
	@Override
	public String getBnftCnvctnTypeByResponse(final short response) {
		try {

			if (bnftCnvctnTypeResponseMap.isEmpty()) {				

				bnftCnvctnTypeResponseMap.put(String.valueOf(TRADING_SNAP_RESP), "TSB");
				bnftCnvctnTypeResponseMap.put(String.valueOf(CONVIC_FALSE_INFO_RESP), "FRI");
				bnftCnvctnTypeResponseMap.put(String.valueOf(BUY_SELL_SNAP_RESP), "TRA");
				bnftCnvctnTypeResponseMap.put(String.valueOf(DRUG_FELONIES_RESP), "PDS");
				bnftCnvctnTypeResponseMap.put(String.valueOf(TRADE_SNAP_GUN_RESP), "SFE");
				bnftCnvctnTypeResponseMap.put(String.valueOf(TANF_EPPIC_RESP), "UBU");
				bnftCnvctnTypeResponseMap.put(String.valueOf(VOLUNTARILY_QUIT_JOB_RESP), "VQJ");
				bnftCnvctnTypeResponseMap.put(String.valueOf(TANF_DISC_RESP), "DFT");
			}

			final String typeForResponse = (String) bnftCnvctnTypeResponseMap.get(String.valueOf(response));
			if (typeForResponse != null) {
				return typeForResponse;
			}
			return "";
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "getBnftCnvctnTypeByResponse", e);
		}

	}

}
