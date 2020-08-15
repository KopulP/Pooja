/*
 * 
 */
package gov.state.nextgen.access.business.rules;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gov.state.nextgen.access.business.entities.BNFT_INDV_Cargo;
import gov.state.nextgen.access.business.entities.BNFT_INDV_Collection;
import gov.state.nextgen.access.business.entities.BNFT_INDV_RFA_Cargo;
import gov.state.nextgen.access.business.entities.BNFT_INDV_RFA_Collection;
import gov.state.nextgen.access.exceptions.FwException;
import gov.state.nextgen.access.management.constants.FwConstants;
import gov.state.nextgen.access.management.logging.ILog;
import gov.state.nextgen.access.management.util.FwDataCriteria;

/**
 * @author mohanmu
 *
 */
public class BenefitIndividualDemographicsBO extends MyAccessBO {
	/*
	 * Method for returning the data from the Access database for the XML data
	 * pin numbers
	 */
	public BNFT_INDV_Collection getBenefitIndivData(final BNFT_INDV_Collection bnftIndivXmlColl, final boolean aConnTypeBatch) {
		final long startTime = System.currentTimeMillis();
		try {
			Map map = null;
			BNFT_INDV_Collection bnftIndvAccessColl = null;
			BNFT_INDV_Cargo bnftIndvAccessCargo = null;
			// XML data Pin Numbers
			final int bnftXmlCollSize = bnftIndivXmlColl.size();
			if (bnftXmlCollSize == 0) {
				return null;
			}
			bnftIndvAccessColl = new BNFT_INDV_Collection();
			map = new HashMap();
			// Getting the data for the XML Data pin numbers
			map.put(FwConstants.SQL_IND, "sql-BR1");
			final FwDataCriteria[] criteria = new FwDataCriteria[30];
			int k = 0;
			for (int i = 0; i < 30; i++) {
				criteria[k] = new FwDataCriteria();
				criteria[k].setColumn_name("A.BNFT_PIN_NUM");
				if (i < bnftXmlCollSize) {
					criteria[k].setColumn_value(bnftIndivXmlColl.getCargo(i).getBnft_pin_num());
				} else {
					criteria[k].setColumn_value("0");
				}
				criteria[k].setData_type(FwConstants.LONG);
				k++;
			}
			map.put(FwConstants.CRITERIA, criteria);
			List res = null;
			if (aConnTypeBatch) {
				res = executeSQLBatch(map);
			} else {
				res = executeSQL(map);
			}
			final int resSize = res.size();
			// Assigning the Access data to the collection
			for (int i = 0; i < resSize; i++) {
				final Map resMap = (Map) res.get(i);
				bnftIndvAccessCargo = new BNFT_INDV_Cargo();
				bnftIndvAccessCargo.setBnft_pin_num(resMap.get("BNFT_PIN_NUM").toString().trim());
				bnftIndvAccessCargo.setBrth_dt(resMap.get("BRTH_DT").toString().trim());
				bnftIndvAccessCargo.setDth_dt(resMap.get("DTH_DT").toString().trim());
				bnftIndvAccessCargo.setFst_nam(resMap.get("FST_NAM").toString().trim());
				bnftIndvAccessCargo.setLast_nam(resMap.get("LAST_NAM").toString().trim());
				bnftIndvAccessCargo.setMid_init(resMap.get("MID_INIT").toString().trim());
				bnftIndvAccessCargo.setSex_ind(resMap.get("SEX_IND").toString().trim());
				bnftIndvAccessCargo.setSfx_nam(resMap.get("SFX_NAM").toString().trim());
				bnftIndvAccessCargo.setIc_flg(resMap.get("IC_FLG").toString().trim());
				bnftIndvAccessCargo.setUpdt_dt("");
				bnftIndvAccessColl.addCargo(bnftIndvAccessCargo);
			}
			
			return bnftIndvAccessColl;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw e;
		}
	}

	public void saveIndvDemoData(final BNFT_INDV_Collection bnftIndvUpdateColl, final BNFT_INDV_Collection bnftIndvInsertColl,
			final boolean aConnTypeBatch) {
		final long startTime = System.currentTimeMillis();
		try {
			// Persising the collections i.e Insert
			if (null != bnftIndvInsertColl && !bnftIndvInsertColl.isEmpty()) {
				if (aConnTypeBatch) {
					bnftIndvInsertColl.persistBatch(FwConstants.DAO);
				} else {
					bnftIndvInsertColl.persist(FwConstants.DAO);
				}
			}
			// Update
			if (null != bnftIndvUpdateColl && !bnftIndvUpdateColl.isEmpty()) {
				if (aConnTypeBatch) {
					bnftIndvUpdateColl.persistBatch(FwConstants.DAO);
				} else {
					bnftIndvUpdateColl.persist(FwConstants.DAO);
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw e;
		}
		
	}

	public BNFT_INDV_RFA_Collection getBenefitIndvRFAData(final String aPinNum, final boolean aConnTypeBatch) {
		final long startTime = System.currentTimeMillis();
		try {
			final BNFT_INDV_RFA_Collection bnftRFAColl = new BNFT_INDV_RFA_Collection();
			final Map sqlMap = new HashMap();
			final FwDataCriteria[] criteria = new FwDataCriteria[1];

			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_name("BNFT_PIN_NUM");
			criteria[0].setColumn_value(aPinNum);
			sqlMap.put(FwConstants.CRITERIA, criteria);
			BNFT_INDV_RFA_Cargo[] accountHolderRFAData = null;
			// retrieve data from BNFT_INDV_CASE TABLE
			if (aConnTypeBatch) {
				accountHolderRFAData = (BNFT_INDV_RFA_Cargo[]) bnftRFAColl.selectBatch(FwConstants.DAO, sqlMap);
			} else {
				accountHolderRFAData = (BNFT_INDV_RFA_Cargo[]) bnftRFAColl.select(FwConstants.DAO, sqlMap);
			}
			bnftRFAColl.setResults(accountHolderRFAData);
			
			return bnftRFAColl;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw e;
		}
	}

	public void saveIndvRFAData(final BNFT_INDV_RFA_Collection aUpdtColl, final BNFT_INDV_RFA_Collection aInsertColl,
			final BNFT_INDV_RFA_Collection aDeleteColl, final boolean aConnTypeBatch) {
		final long startTime = System.currentTimeMillis();
		try {
			// Update
			if (null != aUpdtColl && !aUpdtColl.isEmpty()) {
				if (aConnTypeBatch) {
					aUpdtColl.persistBatch(FwConstants.DAO);
				} else {
					aUpdtColl.persist(FwConstants.DAO);
				}
			}

			// Insert
			if (null != aInsertColl && !aInsertColl.isEmpty()) {
				if (aConnTypeBatch) {
					aInsertColl.persistBatch(FwConstants.DAO);
				} else {
					aInsertColl.persist(FwConstants.DAO);
				}
			}

			// Delete
			if (null != aDeleteColl && !aDeleteColl.isEmpty()) {
				if (aConnTypeBatch) {
					aDeleteColl.persistBatch(FwConstants.DAO);
				} else {
					aDeleteColl.persist(FwConstants.DAO);
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw e;
		}
		
	}
}
