package gov.state.nextgen.access.business.rules;


import gov.state.nextgen.access.business.entities.CP_APP_SCREENER_Cargo;
import gov.state.nextgen.access.business.entities.CP_APP_SCREENER_Collection;
import gov.state.nextgen.access.data.db2.AppScreenerRepository;
import gov.state.nextgen.access.exceptions.ApplicationException;
import gov.state.nextgen.access.exceptions.FwException;
import gov.state.nextgen.access.management.constants.FwConstants;
import gov.state.nextgen.access.management.logging.ILog;
import gov.state.nextgen.access.management.messages.FwMessageList;
import gov.state.nextgen.access.management.references.FwReferenceTable;
import gov.state.nextgen.access.management.references.FwReferenceTableData;
import gov.state.nextgen.access.management.references.IReferenceTableData;
import gov.state.nextgen.access.management.references.IReferenceTableManager;
import gov.state.nextgen.access.management.references.ReferenceTableManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * GetDataBO - Business Object - The purpose of this class is to provide the
 * business handling functionality for Eligibility Screener.
 *
 * @author Deloitte Consulting.
 */
@Service("EligibilityScreenerBO")
public class EligibilityScreenerBO extends AbstractBO {
	
	@Autowired
	private AppScreenerRepository appScreenerRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	final String startUrl = "http://172.30.168.60:8082/docker/";
	//final String startUrl = "http://localhost:8082/docker/";



	/**
	 * saveDetails - This method save data into CP_APP_SCREENER table.
	 *
	 * @param screenerColl
	 *            the screener coll
	 */

	public void saveScreenerDetails(
			final CP_APP_SCREENER_Collection screenerColl) {
		try {
			log(ILog.INFO, "EligibilityScreenerBO::saveScreenerDetails::Start");
			CP_APP_SCREENER_Cargo app_screener_cargo = null;
			
			// Here we are comparing the old and new cargos
			
			  if (screenerColl != null && screenerColl.size() > 0) { 
				  app_screener_cargo = screenerColl.getCargo(0);
			  //app_screener_cargo.setApp_screener_num(getScreenerNum());
				  
					appScreenerRepository.save(app_screener_cargo);

			  
					/*
					 * app_screener_cargo.setRowAction(FwConstants.ROWACTION_INSERT);
					 * tmp_screener_coll.addCargo(app_screener_cargo);
					 */
			} /*
				 * if(tmp_screener_coll.size() > 0) {
				 * tmp_screener_coll.persist(FwConstants.DAO); }
				 */
			
		}
		catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = createFwException(getClass().getName(),
					"saveScreenerDetails", e);
			throw fe;
		}

	}

	/**
	 * This method retrieves the the next screener Number from the Database
	 * sequence CP_APP_SCREENER_1SQ.
	 *
	 * @return screenerNum
	 * @throws ApplicationException
	 *             the application exception
	 */
	public String getScreenerNum() throws ApplicationException {
		final Map<String, String> sqlMap = new HashMap<String, String>();
		String screenerNum = null;
		try {
			sqlMap.put(FwConstants.SQL_IND, "sql-132");
			final List<?> tempList = executeSQL(sqlMap);
			if (tempList != null && tempList.size() > 0) {
				final Map<?, ?> tempMap = (Map<?, ?>) tempList.get(0);
				if (tempMap != null) {
					screenerNum = (String) tempMap.get("NEXTVAL");
				}
			}
		} catch (final Exception e) {
			log(ILog.ERROR,
					"Exception in ACScreenerBO.getScreenerNum : screenerNum : "
							+ screenerNum + " Error: " + e.getMessage());
			throw new ApplicationException(e.getLocalizedMessage());
		}

		return screenerNum;
	}

	/**
	 * Gets the screener eligibilty med asst.
	 *
	 * @param appScreenColl
	 *            the app screen coll
	 * @param medical
	 *            the medical
	 * @return the screener eligibilty med asst
	 */
	public boolean getScreenerEligibiltyMedAsst(
			final CP_APP_SCREENER_Collection appScreenColl, boolean medical) {
		medical = false;

		CP_APP_SCREENER_Cargo appScreenCargo = null;
		try {
			if (null != appScreenColl && appScreenColl.size() > 0) {
				appScreenCargo = appScreenColl.getCargo(0);

				if (null != appScreenCargo.getRes_ga_resp()
						&& (FwConstants.YES).equals(appScreenCargo
								.getRes_ga_resp())
						&& null != appScreenCargo.getPreg_resp()
						&& (FwConstants.YES).equals(appScreenCargo
								.getPreg_resp())) {
					medical = true;
				} else if (null != appScreenCargo.getRes_ga_resp()
						&& (FwConstants.YES).equals(appScreenCargo
								.getRes_ga_resp())
						&& null != appScreenCargo.getPreg_resp()
						&& (FwConstants.NO).equals(appScreenCargo
								.getPreg_resp())
						&& ((null != appScreenCargo.getNum_chld_under_13()
								&& !(FwConstants.ZERO).equals(appScreenCargo
										.getNum_chld_under_13()) && !(FwConstants.EMPTY_STRING)
									.equals(appScreenCargo
											.getNum_chld_under_13())) || (null != appScreenCargo
								.getNum_chld_under_19()
								&& !(FwConstants.ZERO).equals(appScreenCargo
										.getNum_chld_under_19()) && !(FwConstants.EMPTY_STRING)
									.equals(appScreenCargo
											.getNum_chld_under_19())))) {
					medical = true;
				} else if (null != appScreenCargo.getRes_ga_resp()
						&& (FwConstants.YES).equals(appScreenCargo
								.getRes_ga_resp())
						&& ((null != appScreenCargo.getNum_adults_age_grp_3()
								&& !(FwConstants.ZERO).equals(appScreenCargo
										.getNum_adults_age_grp_3()) && !(FwConstants.EMPTY_STRING)
									.equals(appScreenCargo
											.getNum_adults_age_grp_3())) || (null != appScreenCargo
								.getDabl_blnd_and_ssa_resp() && (FwConstants.YES)
								.equals(appScreenCargo
										.getDabl_blnd_and_ssa_resp())))) {
					medical = true;
				} else {
					medical = false;
				}
			}
			return medical;

		} catch (final FwException fe) {
			log(ILog.ERROR,
					"Exception in EligibilityScreenerBO , method getScreenerEligibiltyMedAsst :: "
							+ fe.getMessage());
			throw fe;
		} catch (final Exception e) {
			log(ILog.ERROR,
					"Exception in EligibilityScreenerBO , method getScreenerEligibiltyMedAsst :: "
							+ e.getMessage());
			final FwException fe = createFwException(getClass().getName(),
					"getScreenerEligibiltyMedAsst", e);
			throw fe;
		}

	}

	/**
	 * Gets the screener eligibilty child care.
	 *
	 * @param appScreenColl
	 *            the app screen coll
	 * @param childcare
	 *            the childcare
	 * @param totalIncome
	 *            the total income
	 * @param totalNoOfPeopleInHousehold
	 *            the total no of people in household
	 * @return the screener eligibilty child care
	 */
	public boolean getScreenerEligibiltyChildCare(
			final CP_APP_SCREENER_Collection appScreenColl, boolean childcare,
			final double totalIncome, final int totalNoOfPeopleInHousehold) {
		childcare = false;
		CP_APP_SCREENER_Cargo appScreenCargo = null;
		//final IReferenceTableManager iref = ReferenceTableManager.getInstance();
		Double fplIncome = 0.0;
		//final String startUrl = "http://172.30.168.82:8082/docker";
		String ref_table = "FPLV";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		try {
			// Get the code values from reference table -FPL_MNTH_200% - Code
			// 2811
			FwReferenceTable refTable = new FwReferenceTable();
			refTable.setLanguage(FwConstants.ENGLISH);
			refTable.setReferenceTables(ref_table);
			
			HttpEntity<FwReferenceTable> requestEntity = new HttpEntity<FwReferenceTable>(refTable, headers);
			ResponseEntity<FwReferenceTableData> result = restTemplate.postForEntity (startUrl+"/referencetableLanguage", requestEntity, FwReferenceTableData.class);
			
			IReferenceTableData refData = result.getBody();
			
			/*
			 * final IReferenceTableData refData = iref.getReferenceTableData( "FPLV",
			 * "EN");
			 */
			 
			final String[] codeValues = refData.getCodeValues();

			final List<Integer> intValues = new ArrayList<Integer>();
			for (int i = 0; i < codeValues.length; i++) {
				if (appMgr.isInteger(codeValues[i].trim())) {
					intValues.add(Integer.parseInt(codeValues[i].trim()));
				}
			}
			
			
			

			
			
			if (totalNoOfPeopleInHousehold <= intValues.size()) {
				
				refTable.setColumnId(2811);
				refTable.setCode(String.valueOf(totalNoOfPeopleInHousehold));
				HttpEntity<FwReferenceTable> httpentity = new HttpEntity<FwReferenceTable>(refTable, headers);
				String columnValue = restTemplate.postForObject(startUrl+"/columnValue", httpentity, String.class);
				fplIncome = Double.valueOf(columnValue);

				/*
				 * fplIncome = Double.valueOf(iref.getColumnValue("FPLV", 2811,
				 * String.valueOf(totalNoOfPeopleInHousehold), "EN"));
				 */
			} else {
				
				refTable.setColumnId(2811);
				refTable.setCode(String.valueOf(intValues.size()));
				HttpEntity<FwReferenceTable> httpentity = new HttpEntity<FwReferenceTable>(refTable, headers);
				String columnValue = restTemplate.postForObject(startUrl+"/columnValue", httpentity, String.class);
				fplIncome = Double.valueOf(columnValue);
				/*
				 * fplIncome = Double.valueOf(iref.getColumnValue("FPLV", 2811,
				 * String.valueOf(intValues.size()), "EN"));
				 */
			}

			if (appScreenColl != null && appScreenColl.size() > 0) {
				appScreenCargo = appScreenColl.getCargo(0);

				if (appScreenCargo.getNum_chld_under_13() != null
						&& !"0".equals(appScreenCargo.getNum_chld_under_13())
						&& !"".equals(appScreenCargo.getNum_chld_under_13())
						&& ("Y".equals(appScreenCargo
								.getDabl_care_chld_lt_5yrs_resp()) || "Y"
								.equals(appScreenCargo
										.getCaretaker_60yrs_old_resp()))
						&& totalIncome <= fplIncome * 2) {
					childcare = true;
				} else if (appScreenCargo.getNum_chld_under_13() != null
						&& !"0".equals(appScreenCargo.getNum_chld_under_13())
						&& !"".equals(appScreenCargo.getNum_chld_under_13())
						&& ("N".equals(appScreenCargo
								.getDabl_care_chld_lt_5yrs_resp()) || "N"
								.equals(appScreenCargo
										.getCaretaker_60yrs_old_resp()))
						&& appScreenCargo.getWrk_and_care_chld_resp() != null
						&& "Y".equals(appScreenCargo
								.getWrk_and_care_chld_resp())
						&& totalIncome <= fplIncome * 2) {
					childcare = true;
				} else if (appScreenCargo.getNum_chld_under_13() != null
						&& !"0".equals(appScreenCargo.getNum_chld_under_13())
						&& !"".equals(appScreenCargo.getNum_chld_under_13())
						&& ("N".equals(appScreenCargo
								.getDabl_care_chld_lt_5yrs_resp()) || "N"
								.equals(appScreenCargo
										.getCaretaker_60yrs_old_resp()))
						&& appScreenCargo.getWrk_and_care_chld_resp() != null
						&& "N".equals(appScreenCargo
								.getWrk_and_care_chld_resp())
						&& appScreenCargo.getCaretaker_student_resp() != null
						&& "Y".equals(appScreenCargo
								.getCaretaker_student_resp())
						&& totalIncome <= fplIncome * 2) {
					childcare = true;
				} else if ((appScreenCargo.getNum_chld_under_13() == null
						|| "0".equals(appScreenCargo.getNum_chld_under_13()) || ""
							.equals(appScreenCargo.getNum_chld_under_13()))
						&& appScreenCargo.getNum_chld_under_19() != null
						&& !"0".equals(appScreenCargo.getNum_chld_under_19())
						&& !"".equals(appScreenCargo.getNum_chld_under_19())
						&& appScreenCargo.getChld_13_18_spcl_need_resp() != null
						&& "Y".equals(appScreenCargo
								.getChld_13_18_spcl_need_resp())
						&& ("Y".equals(appScreenCargo
								.getDabl_care_chld_lt_5yrs_resp()) || "Y"
								.equals(appScreenCargo
										.getCaretaker_60yrs_old_resp()))
						&& totalIncome <= fplIncome * 2) {
					childcare = true;
				} else if ((appScreenCargo.getNum_chld_under_13() == null
						|| "0".equals(appScreenCargo.getNum_chld_under_13()) || ""
							.equals(appScreenCargo.getNum_chld_under_13()))
						&& appScreenCargo.getNum_chld_under_19() != null
						&& !"0".equals(appScreenCargo.getNum_chld_under_19())
						&& !"".equals(appScreenCargo.getNum_chld_under_19())
						&& appScreenCargo.getChld_13_18_spcl_need_resp() != null
						&& "Y".equals(appScreenCargo
								.getChld_13_18_spcl_need_resp())
						&& ("N".equals(appScreenCargo
								.getDabl_care_chld_lt_5yrs_resp()) || "N"
								.equals(appScreenCargo
										.getCaretaker_60yrs_old_resp())
								&& appScreenCargo.getWrk_and_care_chld_resp() != null
								&& "Y".equals(appScreenCargo
										.getWrk_and_care_chld_resp()))
						&& totalIncome <= fplIncome * 2) {
					childcare = true;
				} else {
					childcare = (appScreenCargo.getNum_chld_under_13() == null
							|| "0".equals(appScreenCargo.getNum_chld_under_13()) || ""
								.equals(appScreenCargo.getNum_chld_under_13()))
							&& appScreenCargo.getNum_chld_under_19() != null
							&& !"0".equals(appScreenCargo
									.getNum_chld_under_19())
							&& !"".equals(appScreenCargo.getNum_chld_under_19())
							&& appScreenCargo.getChld_13_18_spcl_need_resp() != null
							&& "Y".equals(appScreenCargo
									.getChld_13_18_spcl_need_resp())
							&& ("N".equals(appScreenCargo
									.getDabl_care_chld_lt_5yrs_resp()) || "N"
									.equals(appScreenCargo
											.getCaretaker_60yrs_old_resp()))
							&& appScreenCargo.getWrk_and_care_chld_resp() != null
							&& "N".equals(appScreenCargo
									.getWrk_and_care_chld_resp())
							&& appScreenCargo.getCaretaker_student_resp() != null
							&& "Y".equals(appScreenCargo
									.getCaretaker_student_resp())
							&& totalIncome <= fplIncome * 2;
				}
			}
			return childcare;
		} catch (final FwException fe) {
			log(ILog.ERROR,
					"Exception in EligibilityScreenerBO , method getScreenerEligibiltyMedAsst :: "
							+ fe.getMessage());
			throw fe;
		} catch (final Exception e) {
			log(ILog.ERROR,
					"Exception in EligibilityScreenerBO , method getScreenerEligibiltyMedAsst :: "
							+ e.getMessage());
			final FwException fe = createFwException(getClass().getName(),
					"getScreenerEligibiltyChildCare", e);
			throw fe;
		}
	}

	/**
	 * Gets the screener eligibilty snap.
	 *
	 * @param appScreenColl
	 *            the app screen coll
	 * @param snap
	 *            the snap
	 * @param totalIncome
	 *            the total income
	 * @param totalNoOfPeopleInHousehold
	 *            the total no of people in household
	 * @return the screener eligibilty snap
	 */
	public boolean getScreenerEligibiltySnap(
			final CP_APP_SCREENER_Collection appScreenColl, boolean snap,
			final double totalIncome, final int totalNoOfPeopleInHousehold) {
		snap = false;
		CP_APP_SCREENER_Cargo appScreenCargo = null;
		//final IReferenceTableManager iref = ReferenceTableManager.getInstance();
		Double fplIncome = 0.0;
		//final String startUrl = "http://172.30.168.82:8082/docker/";
		String ref_table = "FPLV";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			FwReferenceTable refTable = new FwReferenceTable();
			refTable.setLanguage(FwConstants.ENGLISH);
			refTable.setReferenceTables(ref_table);
			
			HttpEntity<FwReferenceTable> requestEntity = new HttpEntity<FwReferenceTable>(refTable, headers);
			ResponseEntity<FwReferenceTableData> result = restTemplate.postForEntity (startUrl+"/referencetableLanguage", requestEntity, FwReferenceTableData.class);
			
			IReferenceTableData refData = result.getBody();
			
			/*
			 * final IReferenceTableData refData = iref.getReferenceTableData( "FPLV",
			 * "EN");
			 */
			final String[] codeValues = refData.getCodeValues();

			final List<Integer> intValues = new ArrayList<Integer>();
			for (int i = 0; i < codeValues.length; i++) {
				if (appMgr.isInteger(codeValues[i].trim())) {
					intValues.add(Integer.parseInt(codeValues[i].trim()));
				}
			}
			if (totalNoOfPeopleInHousehold <= intValues.size()) {
				refTable.setColumnId(2809);
				refTable.setCode(String.valueOf(totalNoOfPeopleInHousehold));
				HttpEntity<FwReferenceTable> httpentity = new HttpEntity<FwReferenceTable>(refTable, headers);
				String columnValue = restTemplate.postForObject(startUrl+"/columnValue", httpentity, String.class);
				fplIncome = Double.valueOf(columnValue);
				/*
				 * fplIncome = Double.valueOf(iref.getColumnValue("FPLV", 2809,
				 * String.valueOf(totalNoOfPeopleInHousehold), "EN"));
				 */
			} else {
				/*
				 * fplIncome = Double.valueOf(iref.getColumnValue("FPLV", 2809,
				 * String.valueOf(intValues.size()), "EN"));
				 */
				
				refTable.setColumnId(2809);
				refTable.setCode(String.valueOf(intValues.size()));
				HttpEntity<FwReferenceTable> httpentity = new HttpEntity<FwReferenceTable>(refTable, headers);
				String columnValue = restTemplate.postForObject(startUrl+"/columnValue", httpentity, String.class);
				fplIncome = Double.valueOf(columnValue);
			}

			if (appScreenColl != null && appScreenColl.size() > 0) {
				appScreenCargo = appScreenColl.getCargo(0);

				if ("Y".equals(appScreenCargo.getRes_ga_resp())
						&& appScreenCargo.getDabl_blnd_and_ssa_resp() != null
						&& "Y".equals(appScreenCargo
								.getDabl_blnd_and_ssa_resp())) {
					snap = true;
				} else if ("Y".equals(appScreenCargo.getRes_ga_resp())
						&& appScreenCargo.getDabl_blnd_and_ssa_resp() != null
						&& "N".equals(appScreenCargo
								.getDabl_blnd_and_ssa_resp())
						&& appScreenCargo.getNum_adults_age_grp_2() != null
						&& !"0".equals(appScreenCargo.getNum_adults_age_grp_2())
						&& !"".equals(appScreenCargo.getNum_adults_age_grp_2())
						|| appScreenCargo.getNum_adults_age_grp_3() != null
						&& !"0".equals(appScreenCargo.getNum_adults_age_grp_3())
						&& !"".equals(appScreenCargo.getNum_adults_age_grp_3())) {
					snap = true;
				} else if ("Y".equals(appScreenCargo.getRes_ga_resp())
						&& appScreenCargo.getDabl_blnd_and_ssa_resp() != null
						&& "N".equals(appScreenCargo
								.getDabl_blnd_and_ssa_resp())
						&& (appScreenCargo.getNum_adults_age_grp_2() == null
								|| "0".equals(appScreenCargo
										.getNum_adults_age_grp_2()) || ""
									.equals(appScreenCargo
											.getNum_adults_age_grp_2()))
						&& (appScreenCargo.getNum_adults_age_grp_3() == null
								|| "0".equals(appScreenCargo
										.getNum_adults_age_grp_3()) || ""
									.equals(appScreenCargo
											.getNum_adults_age_grp_3()))
						&& totalIncome <= fplIncome * 1.3) {
					snap = true;
				}

			} else {
				snap = false;
			}
			return snap;
		} catch (final FwException fe) {
			log(ILog.ERROR,
					"Exception in EligibilityScreenerBO , method getScreenerEligibiltySnap :: "
							+ fe.getMessage());
			throw fe;
		} catch (final Exception e) {
			log(ILog.ERROR,
					"Exception in EligibilityScreenerBO , method getScreenerEligibiltySnap :: "
							+ e.getMessage());
			final FwException fe = createFwException(getClass().getName(),
					"getScreenerEligibiltySnap", e);
			throw fe;
		}
	}

	/**
	 * Gets the screener eligibilty wic.
	 *
	 * @param appScreenColl
	 *            the app screen coll
	 * @param wic
	 *            the wic
	 * @param totalIncome
	 *            the total income
	 * @param totalNoOfPeopleInHousehold
	 *            the total no of people in household
	 * @return the screener eligibilty wic
	 */
	public boolean getScreenerEligibiltyWic(
			final CP_APP_SCREENER_Collection appScreenColl, boolean wic,
			final double totalIncome, final int totalNoOfPeopleInHousehold) {
		wic = false;
		//final IReferenceTableManager iref = ReferenceTableManager.getInstance();
		Double fplIncome = 0.0;
		CP_APP_SCREENER_Cargo appScreenCargo = null;
		//final String startUrl = "http://172.30.168.82:8082/docker";
		String ref_table = "FPLV";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		try {
			/*
			 * final IReferenceTableData refData = iref.getReferenceTableData( "FPLV",
			 * "EN");
			 */
			FwReferenceTable refTable = new FwReferenceTable();
			refTable.setLanguage(FwConstants.ENGLISH);
			refTable.setReferenceTables(ref_table);
			
			HttpEntity<FwReferenceTable> requestEntity = new HttpEntity<FwReferenceTable>(refTable, headers);
			ResponseEntity<FwReferenceTableData> result = restTemplate.postForEntity (startUrl+"/referencetableLanguage", requestEntity, FwReferenceTableData.class);
			
			IReferenceTableData refData = result.getBody();
			
			final String[] codeValues = refData.getCodeValues();

			final List<Integer> intValues = new ArrayList<Integer>();
			for (int i = 0; i < codeValues.length; i++) {
				if (appMgr.isInteger(codeValues[i].trim())) {
					intValues.add(Integer.parseInt(codeValues[i].trim()));
				}
			}
			if (totalNoOfPeopleInHousehold <= intValues.size()) {
				/*
				 * fplIncome = Double.valueOf(iref.getColumnValue("FPLV", 2810,
				 * String.valueOf(totalNoOfPeopleInHousehold), "EN"));
				 */
				refTable.setColumnId(2810);
				refTable.setCode(String.valueOf(totalNoOfPeopleInHousehold));
				HttpEntity<FwReferenceTable> httpentity = new HttpEntity<FwReferenceTable>(refTable, headers);
				String columnValue = restTemplate.postForObject(startUrl+"/columnValue", httpentity, String.class);
				fplIncome = Double.valueOf(columnValue);
			} else {
				/*
				 * fplIncome = Double.valueOf(iref.getColumnValue("FPLV", 2810,
				 * String.valueOf(intValues.size()), "EN"));
				 */
				refTable.setColumnId(2810);
				refTable.setCode(String.valueOf(intValues.size()));
				HttpEntity<FwReferenceTable> httpentity = new HttpEntity<FwReferenceTable>(refTable, headers);
				String columnValue = restTemplate.postForObject(startUrl+"/columnValue", httpentity, String.class);
				fplIncome = Double.valueOf(columnValue);
			}

			if (appScreenColl != null && appScreenColl.size() > 0) {
				appScreenCargo = appScreenColl.getCargo(0);

				if ("Y".equals(appScreenCargo.getRes_ga_resp())
						&& appScreenCargo.getRcv_snap_tanf_medicaid_resp() != null
						&& "Y".equals(appScreenCargo
								.getRcv_snap_tanf_medicaid_resp())
						&& appScreenCargo.getNum_chld_under_13() != null
						&& !"0".equals(appScreenCargo.getNum_chld_under_13())
						&& !"".equals(appScreenCargo.getNum_chld_under_13())) {
					wic = true;
				} else if ("Y".equals(appScreenCargo.getRes_ga_resp())
						&& appScreenCargo.getRcv_snap_tanf_medicaid_resp() != null
						&& "Y".equals(appScreenCargo
								.getRcv_snap_tanf_medicaid_resp())
						&& (appScreenCargo.getNum_chld_under_13() == null
								|| "0".equals(appScreenCargo
										.getNum_chld_under_13()) || ""
									.equals(appScreenCargo
											.getNum_chld_under_13()))
						&& appScreenCargo.getPreg_resp() != null
						&& "Y".equals(appScreenCargo.getPreg_resp())) {
					wic = true;
				} else if ("Y".equals(appScreenCargo.getRes_ga_resp())
						&& appScreenCargo.getRcv_snap_tanf_medicaid_resp() != null
						&& "Y".equals(appScreenCargo
								.getRcv_snap_tanf_medicaid_resp())
						&& (appScreenCargo.getNum_chld_under_13() == null
								|| "0".equals(appScreenCargo
										.getNum_chld_under_13()) || ""
									.equals(appScreenCargo
											.getNum_chld_under_13()))
						&& appScreenCargo.getPreg_resp() != null
						&& "N".equals(appScreenCargo.getPreg_resp())
						&& appScreenCargo.getBreast_feed_resp() != null
						&& "Y".equals(appScreenCargo.getBreast_feed_resp())) {
					wic = true;
				} else if ("Y".equals(appScreenCargo.getRes_ga_resp())
						&& appScreenCargo.getRcv_snap_tanf_medicaid_resp() != null
						&& "N".equals(appScreenCargo
								.getRcv_snap_tanf_medicaid_resp())
						&& appScreenCargo.getNum_chld_under_13() != null
						&& !"0".equals(appScreenCargo.getNum_chld_under_13())
						&& !"".equals(appScreenCargo.getNum_chld_under_13())
						&& totalIncome <= fplIncome * 1.85) {
					wic = true;
				} else if ("Y".equals(appScreenCargo.getRes_ga_resp())
						&& appScreenCargo.getRcv_snap_tanf_medicaid_resp() != null
						&& "N".equals(appScreenCargo
								.getRcv_snap_tanf_medicaid_resp())
						&& (appScreenCargo.getNum_chld_under_13() == null
								|| "0".equals(appScreenCargo
										.getNum_chld_under_13()) || ""
									.equals(appScreenCargo
											.getNum_chld_under_13()))
						&& appScreenCargo.getPreg_resp() != null
						&& "Y".equals(appScreenCargo.getPreg_resp())
						&& totalIncome <= fplIncome * 1.85) {
					wic = true;
				} else if ("Y".equals(appScreenCargo.getRes_ga_resp())
						&& appScreenCargo.getRcv_snap_tanf_medicaid_resp() != null
						&& "N".equals(appScreenCargo
								.getRcv_snap_tanf_medicaid_resp())
						&& (appScreenCargo.getNum_chld_under_13() == null
								|| "0".equals(appScreenCargo
										.getNum_chld_under_13()) || ""
									.equals(appScreenCargo
											.getNum_chld_under_13()))
						&& appScreenCargo.getPreg_resp() != null
						&& "N".equals(appScreenCargo.getPreg_resp())
						&& appScreenCargo.getBreast_feed_resp() != null
						&& "Y".equals(appScreenCargo.getBreast_feed_resp())
						&& totalIncome <= fplIncome * 1.85) {
					wic = true;
				}

			} else {
				wic = false;
			}
			return wic;
		} catch (final FwException fe) {
			log(ILog.ERROR,
					"Exception in EligibilityScreenerBO , method getScreenerEligibiltyWic :: "
							+ fe.getMessage());
			throw fe;
		} catch (final Exception e) {
			log(ILog.ERROR,
					"Exception in EligibilityScreenerBO , method getScreenerEligibiltyWic :: "
							+ e.getMessage());
			final FwException fe = createFwException(getClass().getName(),
					"getScreenerEligibiltyWic", e);
			throw fe;
		}
	}

	/**
	 * Gets the screener eligibilty tanf.
	 *
	 * @param appScreenColl
	 *            the app screen coll
	 * @param tanf
	 *            the tanf
	 * @param totalIncome
	 *            the total income
	 * @param totalNoOfPeopleInHousehold
	 *            the total no of people in household
	 * @return the screener eligibilty tanf
	 */
	public boolean getScreenerEligibiltyTanf(
			final CP_APP_SCREENER_Collection appScreenColl, boolean tanf,
			final double totalIncome, final int totalNoOfPeopleInHousehold) {
		tanf = false;
		CP_APP_SCREENER_Cargo appScreenCargo = null;
		Double tanf_gic_val_group = 0.0;
		Double tanf_gic_val_additional = 0.0;
		// Reference table that stores TANF and GEorgia Income Ceiling value
		//final IReferenceTableManager iref = ReferenceTableManager.getInstance();
		//final String startUrl = "http://172.30.168.82:8082/docker";
		String ref_table = "TNFS";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		int noOfAdditionalPeople = 0;
		try {

			/*
			 * final IReferenceTableData refData = iref.getReferenceTableData( "TNFS",
			 * "EN");
			 */
			FwReferenceTable refTable = new FwReferenceTable();
			refTable.setLanguage(FwConstants.ENGLISH);
			refTable.setReferenceTables(ref_table);
			
			HttpEntity<FwReferenceTable> requestEntity = new HttpEntity<FwReferenceTable>(refTable, headers);
			ResponseEntity<FwReferenceTableData> result = restTemplate.postForEntity (startUrl+"/referencetableLanguage", requestEntity, FwReferenceTableData.class);
			
			IReferenceTableData refData = result.getBody();
			
			final String[] codeValues = refData.getCodeValues();

			final List<Integer> intValues = new ArrayList<Integer>();
			for (int i = 0; i < codeValues.length; i++) {
				if (appMgr.isInteger(codeValues[i].trim())) {
					intValues.add(Integer.parseInt(codeValues[i].trim()));
				}
			}
			// Get the TANF values for the group
			if (totalNoOfPeopleInHousehold <= intValues.size()) {
				/*
				 * tanf_gic_val_group = Double .valueOf(iref.getColumnValue("TNFS", 2812,
				 * String.valueOf(totalNoOfPeopleInHousehold), "EN"));
				 */
				refTable.setColumnId(2812);
				refTable.setCode(String.valueOf(totalNoOfPeopleInHousehold));
				HttpEntity<FwReferenceTable> httpentity = new HttpEntity<FwReferenceTable>(refTable, headers);
				String columnValue = restTemplate.postForObject(startUrl+"/columnValue", httpentity, String.class);
				tanf_gic_val_group = Double.valueOf(columnValue);
			}
			// Get number of additional people for whom TANF to be calculated
			// seperately
			if (totalNoOfPeopleInHousehold > intValues.size()) {
				noOfAdditionalPeople = totalNoOfPeopleInHousehold
						- intValues.size();
				tanf_gic_val_additional = noOfAdditionalPeople * 44.0;

				refTable.setColumnId(2812);
				refTable.setCode(String.valueOf(intValues.size()));
				HttpEntity<FwReferenceTable> httpentity = new HttpEntity<FwReferenceTable>(refTable, headers);
				String columnValue = restTemplate.postForObject(startUrl+"/columnValue", httpentity, String.class);
				tanf_gic_val_group = Double.valueOf(columnValue);
				/*
				 * tanf_gic_val_group = Double.valueOf(iref.getColumnValue("TNFS", 2812,
				 * String.valueOf(intValues.size()), "EN"));
				 */
				tanf_gic_val_group = tanf_gic_val_group
						+ tanf_gic_val_additional;
			}

			// Get the TANF value from reference table

			if (appScreenColl != null && appScreenColl.size() > 0) {
				appScreenCargo = appScreenColl.getCargo(0);

				tanf = "Y".equals(appScreenCargo.getRes_ga_resp())
						&& (appScreenCargo.getNum_chld_under_13() != null
								&& !"0".equals(appScreenCargo
										.getNum_chld_under_13())
								&& !"".equals(appScreenCargo
										.getNum_chld_under_13()) || appScreenCargo
								.getNum_chld_under_19() != null
								&& !"0".equals(appScreenCargo
										.getNum_chld_under_19())
								&& !"".equals(appScreenCargo
										.getNum_chld_under_19()))
						&& appScreenCargo.getCaretaker_of_minor_resp() != null
						&& "Y".equals(appScreenCargo
								.getCaretaker_of_minor_resp())
						&& totalIncome <= tanf_gic_val_group;
			}
			return tanf;
		} catch (final FwException fe) {
			log(ILog.ERROR,
					"Exception in EligibilityScreenerBO , method getScreenerEligibiltyTanf :: "
							+ fe.getMessage());
			throw fe;
		} catch (final Exception e) {
			log(ILog.ERROR,
					"Exception in EligibilityScreenerBO , method getScreenerEligibiltyTanf :: "
							+ e.getMessage());
			final FwException fe = createFwException(getClass().getName(),
					"getScreenerEligibiltyTanf", e);
			throw fe;
		}
	}

	/**
	 * Validate appscreener.
	 *
	 * @param aColl
	 *            the a coll
	 * @param cargo
	 *            the cargo
	 * @return the fw message list
	 */
	public FwMessageList validateAPPSCREENER(
			final CP_APP_SCREENER_Collection aColl,
			final CP_APP_SCREENER_Cargo cargo) {
		try {
			final CP_APP_SCREENER_Cargo app_screener_cargo = aColl.getCargo(0);
			if(getMessageList() != null) {
				getMessageList().getMessageList().clear();
			}
			
			int noOfPeopleInHousehold = 0;

			// If resident of Georgia or not
			if (appMgr.isFieldEmpty(app_screener_cargo.getRes_ga_resp())) {
				addMessageCode("00610");
			}

			// If selected county code or not
			if ("Y".equals(app_screener_cargo.getRes_ga_resp())
					&& "000".equals(app_screener_cargo.getCnty_name_cd())) {
				addMessageCode("00611");
			}

			// If selected county code or not
			if ("N".equals(app_screener_cargo.getRes_ga_resp())
					&& !"000".equals(app_screener_cargo.getCnty_name_cd())
					&& !"999".equals(app_screener_cargo.getCnty_name_cd())) {
				addMessageCode("00041");
			}

			// If user has entered 0s for all the fields in people in your home
			// , throw error
			if (!appMgr.isFieldEmpty(app_screener_cargo.getNum_chld_under_13())
					&& !"".equals(app_screener_cargo.getNum_chld_under_13())
					&& appMgr.isInteger(app_screener_cargo
							.getNum_chld_under_13())) {
				noOfPeopleInHousehold = noOfPeopleInHousehold
						+ Integer.parseInt(app_screener_cargo
								.getNum_chld_under_13());
			}
			if (!appMgr.isFieldEmpty(app_screener_cargo.getNum_chld_under_19())
					&& !"".equals(app_screener_cargo.getNum_chld_under_19())
					&& appMgr.isInteger(app_screener_cargo
							.getNum_chld_under_19())) {
				noOfPeopleInHousehold = noOfPeopleInHousehold
						+ Integer.parseInt(app_screener_cargo
								.getNum_chld_under_19());
			}
			if (!appMgr.isFieldEmpty(app_screener_cargo
					.getNum_adults_age_grp_1())
					&& !"".equals(app_screener_cargo.getNum_adults_age_grp_1())
					&& appMgr.isInteger(app_screener_cargo
							.getNum_adults_age_grp_1())) {
				noOfPeopleInHousehold = noOfPeopleInHousehold
						+ Integer.parseInt(app_screener_cargo
								.getNum_adults_age_grp_1());
			}
			if (!appMgr.isFieldEmpty(app_screener_cargo
					.getNum_adults_age_grp_2())
					&& !"".equals(app_screener_cargo.getNum_adults_age_grp_2())
					&& appMgr.isInteger(app_screener_cargo
							.getNum_adults_age_grp_2())) {
				noOfPeopleInHousehold = noOfPeopleInHousehold
						+ Integer.parseInt(app_screener_cargo
								.getNum_adults_age_grp_2());
			}
			if (!appMgr.isFieldEmpty(app_screener_cargo
					.getNum_adults_age_grp_3())
					&& !"".equals(app_screener_cargo.getNum_adults_age_grp_3())
					&& appMgr.isInteger(app_screener_cargo
							.getNum_adults_age_grp_3())) {
				noOfPeopleInHousehold = noOfPeopleInHousehold
						+ Integer.parseInt(app_screener_cargo
								.getNum_adults_age_grp_3());
			}

			// If people in home is empty
			if (appMgr.isFieldEmpty(app_screener_cargo.getNum_chld_under_13())
					&& appMgr.isFieldEmpty(app_screener_cargo
							.getNum_chld_under_19())
					&& appMgr.isFieldEmpty(app_screener_cargo
							.getNum_adults_age_grp_1())
					&& appMgr.isFieldEmpty(app_screener_cargo
							.getNum_adults_age_grp_2())
					&& appMgr.isFieldEmpty(app_screener_cargo
							.getNum_adults_age_grp_3())
					|| noOfPeopleInHousehold == 0) {
				addMessageCode("00627");
			}
			/*else {*/
				// validation for age under 13
				if (appMgr.isFieldEmpty(app_screener_cargo
						.getNum_chld_under_13())
						|| !appMgr.isInteger(app_screener_cargo
								.getNum_chld_under_13())) {
					addMessageCode("00612");
				}
				// validation for age between 13 to 18
				if (appMgr.isFieldEmpty(app_screener_cargo
						.getNum_chld_under_19())
						|| !appMgr.isInteger(app_screener_cargo
								.getNum_chld_under_19())) {
					addMessageCode("79005");
				}
				// validation for age between 19 to 59
				if (appMgr.isFieldEmpty(app_screener_cargo
						.getNum_adults_age_grp_1())
						|| !appMgr.isInteger(app_screener_cargo
								.getNum_adults_age_grp_1())) {
					addMessageCode("00613");
				}
				// validation for age between 60 to 64
				if (appMgr.isFieldEmpty(app_screener_cargo
						.getNum_adults_age_grp_2())
						|| !appMgr.isInteger(app_screener_cargo
								.getNum_adults_age_grp_2())) {
					addMessageCode("00614");
				}
				// validation for age greater than 65
				if (appMgr.isFieldEmpty(app_screener_cargo
						.getNum_adults_age_grp_3())
						|| !appMgr.isInteger(app_screener_cargo
								.getNum_adults_age_grp_3())) {
					addMessageCode("00615");
				}
			/*}*/

			// If no of household employed non numeric
			if (!appMgr.isInteger(app_screener_cargo.getNum_hsld_employed())) {
				addMessageCode("00616");
			}
			// If no of household income non numeric
			if (null != app_screener_cargo.getHsld_bt_earned_income()
					&& !appMgr.isCurrency(app_screener_cargo
							.getHsld_bt_earned_income())) {
				addMessageCode("00617");
			}

			if (null != app_screener_cargo.getHshl_rent_mtg_mth_pymt()
					&& !appMgr.isCurrency(app_screener_cargo
							.getHshl_rent_mtg_mth_pymt())) {
				addMessageCode("99338");
			}

			// If no of ssn income non numeric
			if (null != app_screener_cargo.getSs_income()
					&& !appMgr.isCurrency(app_screener_cargo.getSs_income())) {
				addMessageCode("00618");
			}
			// If no of ssi income non numeric
			if (null != app_screener_cargo.getSsi_income()
					&& !appMgr.isCurrency(app_screener_cargo.getSsi_income())) {
				addMessageCode("00619");
			}
			// If no of unemployment income non numeric
			if (null != app_screener_cargo.getUnemployment_income()
					&& !appMgr.isCurrency(app_screener_cargo
							.getUnemployment_income())) {
				addMessageCode("00620");
			}
			// If no of cash gits income non numeric
			if (null != app_screener_cargo.getCash_gifts_income()
					&& !appMgr.isCurrency(app_screener_cargo
							.getCash_gifts_income())) {
				addMessageCode("00621");
			}
			// If no of alimony income non numeric
			if (null != app_screener_cargo.getAlimony_income()
					&& !appMgr.isCurrency(app_screener_cargo
							.getAlimony_income())) {
				addMessageCode("00622");
			}
			// If no of rental income non numeric
			if (null != app_screener_cargo.getRental_income()
					&& !appMgr
							.isCurrency(app_screener_cargo.getRental_income())) {
				addMessageCode("00623");
			}
			// If no of other income non numeric
			if (null != app_screener_cargo.getOther_income()
					&& !appMgr.isCurrency(app_screener_cargo.getOther_income())) {
				addMessageCode("00624");
			}

			return getMessageList();
		} catch (final FwException fe) {
			log(ILog.ERROR,
					"Exception in EligibilityScreenerBO , method validateAPPSCREENER :: "
							+ fe.getMessage());
			throw fe;
		} catch (final Exception e) {
			final FwException fe = createFwException(getClass().getName(),
					"validateAPPSCREENER", e);
			log(ILog.ERROR,
					"Exception in EligibilityScreenerBO , method validateAPPSCREENER :: "
							+ e.getMessage());
			throw fe;

		}
	}
	
	private CP_APP_SCREENER_Cargo prepareCargo() {

		CP_APP_SCREENER_Cargo app_screener_cargo = new CP_APP_SCREENER_Cargo();
		app_screener_cargo.setRes_ga_resp("Y");
		app_screener_cargo.setCnty_name_cd("001");
		app_screener_cargo.setNum_chld_under_19("109");
		app_screener_cargo.setNum_adults_age_grp_1("1");
		app_screener_cargo.setNum_adults_age_grp_2("1");
		app_screener_cargo.setNum_adults_age_grp_3("1");
		app_screener_cargo.setPreg_resp("Y");
		app_screener_cargo.setBreast_feed_resp("Y");
		app_screener_cargo.setEnd_preg_no_breast_feed_resp("Y");
		app_screener_cargo.setMedicare_eligib_resp("Y");
		app_screener_cargo.setGuard_oth_chld_resp("Y");
		app_screener_cargo.setWk_sch_train_act_resp("Y");
		app_screener_cargo.setDabl_blnd_and_ssa_resp("Y");
		app_screener_cargo.setLive_in_nurs_home_resp("Y");
		app_screener_cargo.setChld_hlth_ins_resp("Y");
		app_screener_cargo.setChld_hlth_ins_lst_2mth_resp("Y");
		app_screener_cargo.setCaretaker_of_minor_resp("Y");
		app_screener_cargo.setCaretaker_60yrs_old_resp("Y");
		app_screener_cargo.setCaretaker_student_resp("Y");
		app_screener_cargo.setNum_hsld_employed("1");
		app_screener_cargo.setHsld_bt_earned_income("2");
		app_screener_cargo.setSs_income("3");
		app_screener_cargo.setSsi_income("4");
		app_screener_cargo.setUnemployment_income("5");
		app_screener_cargo.setCash_gifts_income("6");
		app_screener_cargo.setAlimony_income("7");
		app_screener_cargo.setRental_income("8");
		app_screener_cargo.setOther_income("9");
		app_screener_cargo.setCreate_dt("08-AUG-19");
		app_screener_cargo.setDabl_care_chld_lt_5yrs_resp("Y");
		app_screener_cargo.setChld_13_18_spcl_need_resp("Y");
		app_screener_cargo.setWrk_and_care_chld_resp("Y");
		app_screener_cargo.setHshl_rent_mtg_mth_pymt("10");
		app_screener_cargo.setHshl_pay_heat_cool_exp_resp("Y");
		app_screener_cargo.setRcv_snap_tanf_medicaid_resp("Y");
		app_screener_cargo.setScr_elg_rslt_ma("Y");
		app_screener_cargo.setScr_elg_rslt_cc("Y");
		app_screener_cargo.setScr_elg_rslt_snap("Y");
		app_screener_cargo.setScr_elg_rslt_wic("Y");
		app_screener_cargo.setScr_elg_rslt_tanf("Y");
		//app_screener_cargo.setScr_elg_rslt_liheap();
		app_screener_cargo.setNum_chld_under_13("1");
		//app_screener_cargo.setCreate_user_no();
		//app_screener_cargo.setCreate_user_id();
		return app_screener_cargo;
	}

}
