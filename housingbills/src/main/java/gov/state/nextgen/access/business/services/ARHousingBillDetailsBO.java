/*
 * 
 */
package gov.state.nextgen.access.business.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gov.state.nextgen.access.business.entities.APP_IN_SHLTC_Cargo;
import gov.state.nextgen.access.business.entities.APP_IN_SHLTC_Collection;
import gov.state.nextgen.access.business.entities.APP_IN_UTILC_Collection;
import gov.state.nextgen.access.business.entities.AppInHouBillsCargo;
import gov.state.nextgen.access.business.entities.AppInHouBillsCollection;
import gov.state.nextgen.access.business.entities.AppInUtilcCargo;
import gov.state.nextgen.access.business.rules.AbstractBO;
import gov.state.nextgen.access.exceptions.FwException;
import gov.state.nextgen.access.management.constants.FwConstants;
import gov.state.nextgen.access.management.logging.ILog;
import gov.state.nextgen.access.management.messages.FwMessageTextLabel;
import gov.state.nextgen.access.management.util.FwDataCriteria;
import gov.state.nextgen.access.management.util.FwDataSortOrder;

/**
 * ABHousingBillsBO - Business Object skeleton auto generated - Architecture
 * Team
 *
 * Creation Date :Wed Dec 21 19:15:13 CST 2005 Modified By: Saravana Muppuru
 *           Modified on: Mon Feb 13 2006
 */
public class ARHousingBillDetailsBO extends AbstractBO {

	/**
	 * Constructor
	 */
	public ARHousingBillDetailsBO() {
	}

	public APP_IN_SHLTC_Collection loadHouseBillDetails(final String appNumber) {
		final long startTime = System.currentTimeMillis();
		//log(ILog.INFO, "ARHousingBillDetailsBO.loadHouseBillDetails- START");
		try {

			final APP_IN_SHLTC_Collection appHousingBillIndvSelColl = new APP_IN_SHLTC_Collection();

			final Map value = new HashMap();
			final FwDataCriteria[] criteria = new FwDataCriteria[1];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_name("APP_NUM");
			criteria[0].setColumn_value(appNumber);
			value.put(FwConstants.CRITERIA, criteria);

			final FwDataSortOrder[] sort = new FwDataSortOrder[3];
			sort[0] = new FwDataSortOrder();
			sort[0].setColumnName("INDV_SEQ_NUM");
			sort[1] = new FwDataSortOrder();
			sort[1].setColumnName("SEQ_NUM");
			sort[2] = new FwDataSortOrder();
			sort[2].setColumnName("SHLT_TYPE");
			value.put(FwConstants.ORDER_BY, sort);

			final APP_IN_SHLTC_Cargo[] appInHouseBillCargoArray = (APP_IN_SHLTC_Cargo[]) appHousingBillIndvSelColl.select(FwConstants.DAO, value);
			appHousingBillIndvSelColl.setResults(appInHouseBillCargoArray);
			log(ILog.INFO, "ARHousingBillDetailsBO.loadHouseBillDetails - END , Time Taken : " + (System.currentTimeMillis() - startTime)
					+ " milliseconds");
			return appHousingBillIndvSelColl;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "loadHouseBillDetails", e);
		}
	}

	/**
	 * Method description here
	 */

	public APP_IN_SHLTC_Collection loadHouseBillDetails(final String appNumber, final String indvSeqNum, final String seqNum) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ARHousingBillDetailsBO.loadHouseBillDetails- START");
		try {
			final APP_IN_SHLTC_Collection appHouseIndvSelColl = new APP_IN_SHLTC_Collection();

			final Map value = new HashMap();
			final FwDataCriteria[] criteria = new FwDataCriteria[3];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_name("APP_NUM");
			criteria[0].setColumn_value(appNumber);
			criteria[1] = new FwDataCriteria();
			criteria[1].setColumn_name("INDV_SEQ_NUM");
			criteria[1].setColumn_value(indvSeqNum);
			criteria[2] = new FwDataCriteria();
			criteria[2].setColumn_name("SEQ_NUM");
			criteria[2].setColumn_value(seqNum);
			value.put(FwConstants.CRITERIA, criteria);

			final FwDataSortOrder[] sort = new FwDataSortOrder[3];
			sort[0] = new FwDataSortOrder();
			sort[0].setColumnName("INDV_SEQ_NUM");
			sort[1] = new FwDataSortOrder();
			sort[1].setColumnName("SEQ_NUM");
			sort[2] = new FwDataSortOrder();
			sort[2].setColumnName("SHLT_TYP");
			value.put(FwConstants.ORDER_BY, sort);

			final APP_IN_SHLTC_Cargo[] appHousingCargoArray = (APP_IN_SHLTC_Cargo[]) appHouseIndvSelColl.select(FwConstants.DAO, value);
			appHouseIndvSelColl.setResults(appHousingCargoArray);
			log(ILog.INFO, "ARHousingBillDetailsBO.loadHouseBillDetails - END , Time Taken : " + (System.currentTimeMillis() - startTime)
					+ " milliseconds");
			return appHouseIndvSelColl;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "loadHouseBillDetails", e);
		}
	}

	public AppInHouBillsCargo splitOtherIncColl(final AppInHouBillsCollection emplColl, final String recordIndicator) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "OtherIncomeBO.splitOtherIncColl() - START");
		try {
			if ((emplColl != null) && !emplColl.isEmpty()) {
				final int emplCollSize = emplColl.size();
				AppInHouBillsCargo emplCargo = null;
				for (int i = 0; i < emplCollSize; i++) {
					emplCargo = emplColl.getCargo(i);
					/*
					 * if (emplCargo.getSrc_app_ind().equals(recordIndicator)) { return
					 * emplColl.getCargo(i); }
					 */
				}

			}
			log(ILog.INFO, "OtherIncomeBO.splitOtherIncColl() - END , Time Taken : " + (System.currentTimeMillis() - startTime) + " milliseconds");
			return null;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "splitOtherIncColl", e);
		}

	}

	/**
	 * Method description here
	 */
	public void insertExistingDetails(final APP_IN_SHLTC_Collection appInHouseBillColl) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ARHousingBillDetailsBO.insertExistingDetails- START");
		try {
			if (null!=appInHouseBillColl && !appInHouseBillColl.isEmpty()) {
				appInHouseBillColl.persist(FwConstants.DAO, "insert");
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "insertExistingDetails", e);
		}
		log(ILog.INFO, "ARHousingBillDetailsBO.insertExistingDetails - END , Time Taken : " + (System.currentTimeMillis() - startTime)
				+ " milliseconds");
	}

	public void insertExistingDetails(final AppInHouBillsCollection appInHouseBillColl) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ARHousingBillDetailsBO.insertExistingDetails- START");
		try {
			if (null!=appInHouseBillColl && !appInHouseBillColl.isEmpty()) {
				appInHouseBillColl.persist(FwConstants.DAO, "insert");
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "insertExistingDetails", e);
		}
		log(ILog.INFO, "ARHousingBillDetailsBO.insertExistingDetails - END , Time Taken : " + (System.currentTimeMillis() - startTime)
				+ " milliseconds");
	}

	public int getMaxHouseSeqNumber(final String aAppNum, final String indvSeqNum) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ARHousingBillDetailsBO.getMaxHouseSeqNumber- START");
		final Map sqlMap = new HashMap();
		// Map value = new HashMap()
		int maxSeqNum = 0;
		FwDataCriteria[] employmentCriteria = null;
		try {
			sqlMap.put(FwConstants.SQL_IND, "sql-RM22");
			employmentCriteria = new FwDataCriteria[2];
			employmentCriteria[0] = new FwDataCriteria();
			employmentCriteria[0].setColumn_name("APP_NUM");
			employmentCriteria[0].setColumn_value(aAppNum);
			employmentCriteria[0].setData_type(FwConstants.STRING);
			employmentCriteria[1] = new FwDataCriteria();
			employmentCriteria[1].setColumn_name("INDV_SEQ_NUM");
			employmentCriteria[1].setColumn_value(indvSeqNum);
			employmentCriteria[1].setData_type(FwConstants.SHORT);
			sqlMap.put(FwConstants.CRITERIA, employmentCriteria);
			final List res = executeSQL(sqlMap);
			final Map temp = (Map) res.get(0);
			if (temp.get("MAX_SEQ_NUM") != null) {
				maxSeqNum = Integer.parseInt((String) temp.get("MAX_SEQ_NUM"));
			}
			log(ILog.INFO, "ARHousingBillDetailsBO.getMaxHouseSeqNumber - END , Time Taken : " + (System.currentTimeMillis() - startTime)
					+ " milliseconds");
			return maxSeqNum;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "getMaxHouseSeqNumber", e);
		}

	}

	public int getMaxSeqNumber(final String aAppNum, final String indvSeqNum) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "OtherIncomeBO.getMaxEmplSeqNumber() - START");
		final Map sqlMap = new HashMap();
		int maxSeqNum = 0;
		FwDataCriteria[] employmentCriteria = null;
		try {
			sqlMap.put(FwConstants.SQL_IND, "sql-RM381");
			employmentCriteria = new FwDataCriteria[2];
			employmentCriteria[0] = new FwDataCriteria();
			employmentCriteria[0].setColumn_name("APP_NUM");
			employmentCriteria[0].setColumn_value(aAppNum);
			employmentCriteria[0].setData_type(FwConstants.STRING);
			employmentCriteria[1] = new FwDataCriteria();
			employmentCriteria[1].setColumn_name("INDV_SEQ_NUM");
			employmentCriteria[1].setColumn_value(indvSeqNum);
			employmentCriteria[1].setData_type(FwConstants.SHORT);
			sqlMap.put(FwConstants.CRITERIA, employmentCriteria);
			final List res = executeSQL(sqlMap);
			final Map temp = (Map) res.get(0);
			if (temp.get("MAX_SEQ_NUM") != null) {
				maxSeqNum = Integer.parseInt((String) temp.get("MAX_SEQ_NUM"));
			}
			log(ILog.INFO, "OtherIncomeBO.getMaxEmplSeqNumber() - END , Time Taken : " + (System.currentTimeMillis() - startTime) + " milliseconds");
			return maxSeqNum;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "getMaxEmplSeqNumber", e);
		}

	}

	public void storeHouseDetails(final APP_IN_SHLTC_Collection appInHouseColl) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ARHousingBillDetailsBO.storeHouseDetails- START");
		try {
			if (null!=appInHouseColl && !appInHouseColl.isEmpty()) {
				appInHouseColl.persist(FwConstants.DAO);
			}

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "storeHouseDetails", e);
		}
		log(ILog.INFO, "ARHousingBillDetailsBO.storeHouseDetails - END , Time Taken : " + (System.currentTimeMillis() - startTime) + " milliseconds");
	}

	public void storeHouseDetails(final AppInHouBillsCollection appInHouseColl) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ARHousingBillDetailsBO.storeHouseDetails- START");
		try {
			if (null!=appInHouseColl && !appInHouseColl.isEmpty()) {
				appInHouseColl.persist(FwConstants.DAO);
			}

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "storeHouseDetails", e);
		}
		log(ILog.INFO, "ARHousingBillDetailsBO.storeHouseDetails - END , Time Taken : " + (System.currentTimeMillis() - startTime) + " milliseconds");
	}

	public APP_IN_SHLTC_Cargo splitHouseColl(final APP_IN_SHLTC_Collection houseColl, final String recordIndicator) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ARHousingBillDetailsBO.splitHouseColl- START");
		try {
			if ((houseColl != null) && (!houseColl.isEmpty())) {
				final int houseCollSize = houseColl.size();
				APP_IN_SHLTC_Cargo houseCargo = null;
				for (int i = 0; i < houseCollSize; i++) {
					houseCargo = houseColl.getCargo(i);
					if (houseCargo.getSrc_app_ind().equals(recordIndicator)) {
						log(ILog.INFO, "ARHousingBillDetailsBO.splitHouseColl - END , Time Taken : " + (System.currentTimeMillis() - startTime)
								+ " milliseconds");
						return houseColl.getCargo(i);
					}
				}

			}
			log(ILog.INFO, "ARHousingBillDetailsBO.splitHouseColl - END , Time Taken : " + (System.currentTimeMillis() - startTime) + " milliseconds");
			return null;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "splitHouseColl", e);
		}

	}

	public APP_IN_SHLTC_Cargo settingDefaultValues(final APP_IN_SHLTC_Cargo houseCargo) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ARHousingBillDetailsBO.settingDefaultValues- START");
		try {
			if (houseCargo != null) {
				// initialize date fields
				if (houseCargo.getChg_eff_dt() == null) {
					houseCargo.setChg_eff_dt(FwConstants.EMPTY_STRING);
				}
				if (houseCargo.getShlt_oblg_amt() == null) {
					houseCargo.setShlt_oblg_amt(FwConstants.EMPTY_STRING);
				}

			}
			log(ILog.INFO, "ARHousingBillDetailsBO.settingDefaultValues - END , Time Taken : " + (System.currentTimeMillis() - startTime)
					+ " milliseconds");
			return houseCargo;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "settingDefaultValues", e);
		}
	}

	public AppInHouBillsCargo settingDefaultValues(final AppInHouBillsCargo houseCargo) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ARHousingBillDetailsBO.settingDefaultValues- START");
		try {
			if (houseCargo != null) {
				// initialize date fields
				if (houseCargo.getPymt_amt() == null) {
					houseCargo.setPymt_amt(FwConstants.EMPTY_STRING);
				}

			}
			log(ILog.INFO, "ARHousingBillDetailsBO.settingDefaultValues - END , Time Taken : " + (System.currentTimeMillis() - startTime)
					+ " milliseconds");
			return houseCargo;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "settingDefaultValues", e);
		}
	}

	/***************************************************************************************************************/

	public APP_IN_UTILC_Collection loadUtilityDetails(final String appNumber) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ARHousingBillDetailsBO.loadUtilityDetails- START");
		try {
			final APP_IN_UTILC_Collection appInUtilcColl = new APP_IN_UTILC_Collection();

			final Map value = new HashMap();
			final FwDataCriteria[] criteria = new FwDataCriteria[1];

			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_name("APP_NUM");
			criteria[0].setColumn_value(appNumber);
			value.put(FwConstants.CRITERIA, criteria);

			final FwDataSortOrder[] sort = new FwDataSortOrder[3];
			sort[0] = new FwDataSortOrder();
			sort[0].setColumnName("INDV_SEQ_NUM");
			sort[1] = new FwDataSortOrder();
			sort[1].setColumnName("UTIL_TYP");
			sort[2] = new FwDataSortOrder();
			sort[2].setColumnName("SEQ_NUM");
			value.put(FwConstants.ORDER_BY, sort);

			final AppInUtilcCargo[] appInUtilcCargoArray = (AppInUtilcCargo[]) appInUtilcColl.select(FwConstants.DAO, value);
			appInUtilcColl.setResults(appInUtilcCargoArray);
			log(ILog.INFO, "ARHousingBillDetailsBO.loadUtilityDetails - END , Time Taken : " + (System.currentTimeMillis() - startTime)
					+ " milliseconds");
			return appInUtilcColl;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "loadUtilityDetails", e);
		}
	}

	/**
	 * Method description here
	 */
	public APP_IN_UTILC_Collection loadIndividualUtilityDetails(final String appNumber, final String indvSeqNum, final String seqNum) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ARHousingBillDetailsBO.loadIndividualUtilityDetails- START");
		try {
			final APP_IN_UTILC_Collection appInUtilcColl = new APP_IN_UTILC_Collection();

			final Map value = new HashMap();
			final FwDataCriteria[] criteria = new FwDataCriteria[3];

			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_name("APP_NUM");
			criteria[0].setColumn_value(appNumber);

			criteria[1] = new FwDataCriteria();
			criteria[1].setColumn_name("INDV_SEQ_NUM");
			criteria[1].setColumn_value(indvSeqNum);

			criteria[2] = new FwDataCriteria();
			criteria[2].setColumn_name("SEQ_NUM");
			criteria[2].setColumn_value(seqNum);

			value.put(FwConstants.CRITERIA, criteria);

			final FwDataSortOrder[] sort = new FwDataSortOrder[3];
			sort[0] = new FwDataSortOrder();
			sort[0].setColumnName("INDV_SEQ_NUM");
			sort[1] = new FwDataSortOrder();
			sort[1].setColumnName("UTIL_TYP");
			sort[2] = new FwDataSortOrder();
			sort[2].setColumnName("SEQ_NUM");
			value.put(FwConstants.ORDER_BY, sort);

			final AppInUtilcCargo[] appInUtilcCargoArray = (AppInUtilcCargo[]) appInUtilcColl.select(FwConstants.DAO, value);
			appInUtilcColl.setResults(appInUtilcCargoArray);
			log(ILog.INFO, "ARHousingBillDetailsBO.loadIndividualUtilityDetails - END , Time Taken : " + (System.currentTimeMillis() - startTime)
					+ " milliseconds");
			return appInUtilcColl;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "loadIndividualUtilityDetails", e);
		}

	}

	/**
	 * Method description here
	 */
	public APP_IN_SHLTC_Collection loadShelterDetails(final String appNumber) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ARHousingBillDetailsBO.loadShelterDetails- START");
		try {
			final APP_IN_SHLTC_Collection appInShltcColl = new APP_IN_SHLTC_Collection();

			final Map value = new HashMap();
			final FwDataCriteria[] criteria = new FwDataCriteria[1];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_name("APP_NUM");
			criteria[0].setColumn_value(appNumber);
			value.put(FwConstants.CRITERIA, criteria);

			final FwDataSortOrder[] sort = new FwDataSortOrder[3];
			sort[0] = new FwDataSortOrder();
			sort[0].setColumnName("INDV_SEQ_NUM");
			sort[1] = new FwDataSortOrder();
			sort[1].setColumnName("SHLT_TYP");
			sort[2] = new FwDataSortOrder();
			sort[2].setColumnName("SEQ_NUM");
			value.put(FwConstants.ORDER_BY, sort);

			final APP_IN_SHLTC_Cargo[] appInShltcCargoArray = (APP_IN_SHLTC_Cargo[]) appInShltcColl.select(FwConstants.DAO, value);
			appInShltcColl.setResults(appInShltcCargoArray);
			log(ILog.INFO, "ARHousingBillDetailsBO.loadShelterDetails - END , Time Taken : " + (System.currentTimeMillis() - startTime)
					+ " milliseconds");
			return appInShltcColl;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "loadShelterDetails", e);
		}
	}

	/**
	 * Method description here
	 */
	public APP_IN_SHLTC_Collection loadIndividualShelterDetails(final String appNumber, final String indvSeqNum, final String seqNum) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ARHousingBillDetailsBO.loadIndividualShelterDetails- START");
		try {
			final APP_IN_SHLTC_Collection appInShltcColl = new APP_IN_SHLTC_Collection();

			final Map value = new HashMap();
			final FwDataCriteria[] criteria = new FwDataCriteria[3];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_name("APP_NUM");
			criteria[0].setColumn_value(appNumber);
			criteria[1] = new FwDataCriteria();
			criteria[1].setColumn_name("INDV_SEQ_NUM");
			criteria[1].setColumn_value(indvSeqNum);
			criteria[2] = new FwDataCriteria();
			criteria[2].setColumn_name("SEQ_NUM");
			criteria[2].setColumn_value(seqNum);

			value.put(FwConstants.CRITERIA, criteria);

			final FwDataSortOrder[] sort = new FwDataSortOrder[3];
			sort[0] = new FwDataSortOrder();
			sort[0].setColumnName("INDV_SEQ_NUM");
			sort[1] = new FwDataSortOrder();
			sort[1].setColumnName("SHLT_TYP");
			sort[2] = new FwDataSortOrder();
			sort[2].setColumnName("SEQ_NUM");
			value.put(FwConstants.ORDER_BY, sort);

			final APP_IN_SHLTC_Cargo[] appInShltcCargoArray = (APP_IN_SHLTC_Cargo[]) appInShltcColl.select(FwConstants.DAO, value);
			appInShltcColl.setResults(appInShltcCargoArray);
			log(ILog.INFO, "ARHousingBillDetailsBO.loadIndividualShelterDetails - END , Time Taken : " + (System.currentTimeMillis() - startTime)
					+ " milliseconds");
			return appInShltcColl;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "loadIndividualShelterDetails", e);
		}
	}

	/**
	 * Method description here
	 */

	public APP_IN_SHLTC_Collection getRmcHousingDetails(final String appNumber) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ARHousingBillDetailsBO.getRmcHousingDetails- START");
		log(ILog.INFO, "ARHousingBillDetailsBO::getRmcHousingDetails:Start");
		try {
			final APP_IN_SHLTC_Collection rmcInHousingColl = new APP_IN_SHLTC_Collection();
			final Map value = new HashMap();
			final FwDataCriteria[] criteria = new FwDataCriteria[1];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_name("APP_NUM");
			criteria[0].setColumn_value(appNumber);
			value.put(FwConstants.CRITERIA, criteria);
			final FwDataSortOrder[] sort = new FwDataSortOrder[3];
			sort[0] = new FwDataSortOrder();
			sort[0].setColumnName("INDV_SEQ_NUM");
			sort[1] = new FwDataSortOrder();
			sort[1].setColumnName("SEQ_NUM");
			sort[2] = new FwDataSortOrder();
			sort[2].setColumnName("SRC_APP_IND");
			value.put(FwConstants.ORDER_BY, sort);
			final APP_IN_SHLTC_Cargo[] appInHousingCargoArray = (APP_IN_SHLTC_Cargo[]) rmcInHousingColl.select(FwConstants.DAO, value);
			rmcInHousingColl.setResults(appInHousingCargoArray);
			log(ILog.INFO, "ARHousingBillDetailsBO::getRmcHousingDetails:End");
			log(ILog.INFO, "ARHousingBillDetailsBO.getRmcHousingDetails - END , Time Taken : " + (System.currentTimeMillis() - startTime)
					+ " milliseconds");
			return rmcInHousingColl;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "getRmcHousingDetails", e);
		}
	}

	/**
	 * Method description here
	 */
	public void storeShelterCostDetails(final APP_IN_SHLTC_Collection appInShltcColl) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ARHousingBillDetailsBO.storeShelterCostDetails- START");
		try {
			if (null!=appInShltcColl && !appInShltcColl.isEmpty()) {
				appInShltcColl.persist(FwConstants.DAO);
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "storeShelterDetails", e);
		}
		log(ILog.INFO, "ARHousingBillDetailsBO.storeShelterCostDetails - END , Time Taken : " + (System.currentTimeMillis() - startTime)
				+ " milliseconds");
	}

	/**
	 * Method description here
	 */
	public void storeUtilityCostDetails(final APP_IN_UTILC_Collection appInUtilcColl) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ARHousingBillDetailsBO.storeUtilityCostDetails- START");
		try {
			if (null!=appInUtilcColl && !appInUtilcColl.isEmpty()) {
				appInUtilcColl.persist(FwConstants.DAO);
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "storeUtilityDetails", e);
		}
		log(ILog.INFO, "ARHousingBillDetailsBO.storeUtilityCostDetails - END , Time Taken : " + (System.currentTimeMillis() - startTime)
				+ " milliseconds");
	}

	public void validatePageContents(final String howMuch, final String iDontknow, final boolean amtEntered) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ARHousingBillDetailsBO.validatePageContents- START");
		try {
			if (!appMgr.isCurrency(howMuch)) {
				final Object[] error = new Object[] { new FwMessageTextLabel("512") };
				this.addMessageWithFieldValues("10039", error);
			} else if (!appMgr.isValidAmountLimit(howMuch)) {
				addMessageCode("10034");
			}
			if ("1".equals(iDontknow) && amtEntered) {
				final Object[] error = new Object[] { new FwMessageTextLabel("512") };
				this.addMessageWithFieldValues("20013", error);
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "validatePageContents", e);
		}
		log(ILog.INFO, "ARHousingBillDetailsBO.validatePageContents - END , Time Taken : " + (System.currentTimeMillis() - startTime)
				+ " milliseconds");
	}

	public String completenessCheckABUCD(final AppInUtilcCargo utilcCargo) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ARHousingBillDetailsBO.completenessCheckABUCD- START");
		try {
			String completeIndicator = "0";
			if ("0".equals(utilcCargo.getMo_oblg_ind())) {
				if (!FwConstants.SPACE.equals(utilcCargo.getBill_exp_resp())) {
					completeIndicator = "1";
				}
			}
			log(ILog.INFO, "ARHousingBillDetailsBO.completenessCheckABUCD - END , Time Taken : " + (System.currentTimeMillis() - startTime)
					+ " milliseconds");
			return completeIndicator;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "completenessCheckABUCD", e);
		}
	}

	public String completenessCheckABSCD(final APP_IN_SHLTC_Cargo shltcCargo) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "ARHousingBillDetailsBO.completenessCheckABSCD- START");
		try {
			if ("0".equals(shltcCargo.getShlt_oblg_ind())) {
				log(ILog.INFO, "ARHousingBillDetailsBO.completenessCheckABSCD - END , Time Taken : " + (System.currentTimeMillis() - startTime)
						+ " milliseconds");
				return "1";
			} else {
				log(ILog.INFO, "ARHousingBillDetailsBO.completenessCheckABSCD - END , Time Taken : " + (System.currentTimeMillis() - startTime)
						+ " milliseconds");
				return "0";
			}

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "completenessCheckABSCD", e);
		}
	}

}
