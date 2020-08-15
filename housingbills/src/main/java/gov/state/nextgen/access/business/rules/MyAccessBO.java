/*
 *
 */
package gov.state.nextgen.access.business.rules;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gov.state.nextgen.access.business.entities.BNFT_APPOINTMENTS_Cargo;
import gov.state.nextgen.access.business.entities.BNFT_APPOINTMENTS_Collection;
import gov.state.nextgen.access.business.entities.BNFT_INDV_CASE_Collection;
import gov.state.nextgen.access.business.entities.CUST_INDV_ELG_Cargo;
import gov.state.nextgen.access.business.entities.CUST_INDV_ELG_Collection;
import gov.state.nextgen.access.business.entities.HIST_MTH_CUST_Cargo;
import gov.state.nextgen.access.business.entities.HIST_MTH_CUST_Collection;
import gov.state.nextgen.access.driver.FwPageManager;
import gov.state.nextgen.access.driver.IPage;
import gov.state.nextgen.access.exceptions.FwException;
import gov.state.nextgen.access.management.constants.AppConstants;
import gov.state.nextgen.access.management.constants.FwConstants;
import gov.state.nextgen.access.management.logging.ILog;
import gov.state.nextgen.access.management.messages.AccessMessage;
import gov.state.nextgen.access.management.references.IReferenceTableManager;
import gov.state.nextgen.access.management.references.ReferenceTableManager;
import gov.state.nextgen.access.management.util.FwDataCriteria;
import gov.state.nextgen.access.management.validations.FwMessageFormatter;

/**
 * The Class MyAccessBO.
 *
 * @author nathsu
 *
 *         This is common method
 */

/* ************************************************************************************
 * ***************** SONAR FIXES MADE IN THIS CODE
 * ************************************** ISSUE DESCRIPTION NATURE OF FIX DATE
 * **** ================== ============= **** **** Avoid commented code Deleted
 * Commented code 08/25/2015 ** Lage Blocks of commented code *** are converted
 * to javadoc *** **
 * *************************************************************
 * *************************
 */

public class MyAccessBO extends AbstractBO {

	/**
	 * This is method for all detail pages(Eligable, InEligable,
	 * IndividualInEligable).
	 *
	 * @param caseNum
	 *            case number
	 * @param catCd
	 *            category code
	 * @param elgInd
	 *            elgibility indicator
	 * @param currentEligInd
	 *            current elig indicator
	 * @return the detail grouping
	 */

	public CUST_INDV_ELG_Collection getDetailGrouping(final String caseNum,
			final String catCd, final String elgInd, final String currentEligInd) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getDetailGrouping() - START");
		final Map sqlMap = new HashMap();
		final CUST_INDV_ELG_Collection custIndvElgColl = new CUST_INDV_ELG_Collection();
		try {
			sqlMap.put(FwConstants.SQL_IND, "sql-202");
			final FwDataCriteria[] criteria = new FwDataCriteria[5];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_value(caseNum);
			criteria[0].setData_type(FwConstants.LONG);
			criteria[1] = new FwDataCriteria();
			criteria[1].setColumn_value(catCd);
			criteria[1].setData_type(FwConstants.STRING);
			criteria[2] = new FwDataCriteria();
			criteria[2].setColumn_value(elgInd);
			criteria[2].setData_type(FwConstants.STRING);
			/*
			 * VG SONAR Cleanup - 08/25/2015 Deleted 3 lines Commented Code in
			 * this block
			 */

			sqlMap.put(FwConstants.CRITERIA, criteria);

			Date currentDate = fwDate.getDate();
			currentDate.setDate(1);
			currentDate.setMonth(currentDate.getMonth() + 1);
			currentDate.setDate(currentDate.getDate() - 1);
			final Date endOfCurMnth = currentDate;// added for FAP amt
			criteria[3] = new FwDataCriteria();
			criteria[3].setColumn_value(currentDate.toString());
			criteria[3].setData_type(FwConstants.STRING);

			currentDate = fwDate.getDate();
			currentDate.setDate(1);
			final Date beginOfCurMnth = currentDate;// added for FAP amt
			criteria[4] = new FwDataCriteria();
			criteria[4].setColumn_value(currentDate.toString());
			criteria[4].setData_type(FwConstants.STRING);
			sqlMap.put(FwConstants.CRITERIA, criteria);
			final String paymentAmount = getFAPPaymentAmount(caseNum,
					endOfCurMnth, beginOfCurMnth);// added
			// for
			// FAP
			// amt
			final List res = executeSQL(sqlMap);
			if (null != res && !res.isEmpty()) {
				final CUST_INDV_ELG_Cargo[] custIndvElgCargo = new CUST_INDV_ELG_Cargo[res
						.size()];

				for (int i = 0; i < res.size(); i++) {
					final Map cargo = (Map) res.get(i);
					custIndvElgCargo[i] = new CUST_INDV_ELG_Cargo();
					custIndvElgCargo[i].setMci_id((String) cargo.get("MCI_ID"));
					custIndvElgCargo[i].setBnft_pin_num((String) cargo
							.get("BNFT_PIN_NUM"));
					custIndvElgCargo[i].setBnft_case_num((String) cargo
							.get("BNFT_CASE_NUM"));
					custIndvElgCargo[i].setCat_cd((String) cargo.get("CAT_CD"));
					custIndvElgCargo[i].setScat_cd((String) cargo
							.get("SCAT_CD"));
					custIndvElgCargo[i].setScat_seq_num((String) cargo
							.get("SCAT_SEQ_NUM"));
					custIndvElgCargo[i].setCur_elg_ind((String) cargo
							.get("CUR_ELG_IND"));
					custIndvElgCargo[i].setBnft_stat_cd((String) cargo
							.get("BNFT_STAT_CD"));
					custIndvElgCargo[i].setCnfm_dt((String) cargo
							.get("CNFM_DT"));
					custIndvElgCargo[i].setElg_beg_dt((String) cargo
							.get("ELG_BEG_DT"));
					custIndvElgCargo[i].setElg_end_dt((String) cargo
							.get("ELG_END_DT"));
					custIndvElgCargo[i].setElg_ind((String) cargo
							.get("ELG_IND"));
					custIndvElgCargo[i].setMa_ddct_bal_amt((String) cargo
							.get("MA_DDCT_BAL_AMT"));
					if (paymentAmount != null) {
						custIndvElgCargo[i].setPymt_amt(paymentAmount);
					} else {
						custIndvElgCargo[i].setPymt_amt("0.00");
					}
					custIndvElgCargo[i].setPymt_beg_dt((String) cargo
							.get("PYMT_BEG_DT"));
					custIndvElgCargo[i].setPymt_end_dt((String) cargo
							.get("PYMT_END_DT"));
					custIndvElgCargo[i].setPymt_typ((String) cargo
							.get("PYMT_TYP"));
					custIndvElgCargo[i].setSc_bnft_lvl_cd((String) cargo
							.get("SC_BNFT_LVL_CD"));
					custIndvElgCargo[i].setUpdt_dt((String) cargo
							.get("UPDT_DT"));
					custIndvElgCargo[i].setVfcn_due_dt((String) cargo
							.get("VFCN_DUE_DT"));
					custIndvElgCargo[i].setMsg_cd_txt((String) cargo
							.get("MSG_CD_TXT"));
					custIndvElgCargo[i].setFst_nam(cargo.get("FST_NAM")
							.toString().trim());
					custIndvElgCargo[i].setSex_ind((String) cargo
							.get("SEX_IND"));
					custIndvElgCargo[i].setAg_stat_rsn_1_cd((String) cargo
							.get("AG_STAT_RSN_1_CD"));
					custIndvElgCargo[i].setAg_stat_rsn_2_cd((String) cargo
							.get("AG_STAT_RSN_2_CD"));
					custIndvElgCargo[i].setAg_stat_rsn_3_cd((String) cargo
							.get("AG_STAT_RSN_3_CD"));
					custIndvElgCargo[i].setNf_elg_rslt_cd((String) cargo
							.get("NF_ELG_RSLT_CD"));
					custIndvElgCargo[i].setNf_fail_rsn_1_cd((String) cargo
							.get("NF_FAIL_RSN_1_CD"));
					custIndvElgCargo[i].setNf_fail_rsn_2_cd((String) cargo
							.get("NF_FAIL_RSN_2_CD"));
					custIndvElgCargo[i].setNf_fail_rsn_3_cd((String) cargo
							.get("NF_FAIL_RSN_3_CD"));
					custIndvElgCargo[i].setOrg_elg_ind((String) cargo
							.get("ORIG_ELG_IND"));
					custIndvElgCargo[i].setPrev_pymt_amt((String) cargo
							.get("PREV_PYMT_AMT"));
					custIndvElgCargo[i].setFs_grp_typ((String) cargo
							.get("FS_GRP_TYP"));
					custIndvElgCargo[i].setFs_fpl_130pct_amt((String) cargo
							.get("FS_FPL_130PCT_AMT"));
					custIndvElgCargo[i].setPgm_rqst_sw((String) cargo
							.get("PGM_RQST_SW"));
					custIndvElgCargo[i].setPrev_sc_bnft_l_cd((String) cargo
							.get("PREV_SC_BNFT_L_CD"));
					custIndvElgCargo[i].setBrth_dt((String) cargo
							.get("BRTH_DT"));
					custIndvElgCargo[i].setEmpl_vfcn_due_dt((String) cargo
							.get("EMPL_VFCN_DUE_DT"));
					custIndvElgCargo[i].setIns_vfcn_due_dt((String) cargo
							.get("INS_VFCN_DUE_DT"));
					custIndvElgCargo[i].setSmirf_mo((String) cargo
							.get("SMIRF_MO"));
					custIndvElgCargo[i]
							.setSemi_annual_review_date((String) cargo
									.get("SEMI_ANNUAL_REVIEW_DT"));
					custIndvElgCargo[i].setReview_dt((String) cargo
							.get("REVIEW_DT"));
					custIndvElgCargo[i].setMid_cert_review_date((String) cargo
							.get("MID_CERT_REVIEW_DT"));
					custIndvElgCargo[i].setEstm_elg_end_dt((String) cargo
							.get("ESTM_ELG_END_DT"));
				}
				custIndvElgColl.setResults(custIndvElgCargo);
			}

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getDetailGrouping", e);
		}
		log(ILog.INFO, "MyAccessBO.getDetailGrouping() - END , Time Taken : "
				+ (System.currentTimeMillis() - startTime) + " milliseconds");
		return custIndvElgColl;
	}

	/**
	 * This method returns Indv eligibility collection.
	 *
	 * @param caseNum
	 *            case number
	 * @param catCd
	 *            the cat cd
	 * @param elgInd
	 *            the elg ind
	 * @return the detail ineligible grouping
	 */

	public CUST_INDV_ELG_Collection getDetailIneligibleGrouping(
			final String caseNum, final String catCd, final String elgInd) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getDetailIneligibleGrouping() - START");
		final Map sqlMap = new HashMap();
		final CUST_INDV_ELG_Collection custIndvElgColl = new CUST_INDV_ELG_Collection();
		try {
			sqlMap.put(FwConstants.SQL_IND, "sql-244");
			final FwDataCriteria[] criteria = new FwDataCriteria[4];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_value(caseNum);
			criteria[0].setData_type(FwConstants.LONG);
			criteria[1] = new FwDataCriteria();
			criteria[1].setColumn_value(catCd);
			criteria[1].setData_type(FwConstants.STRING);
			/*
			 * VG SONAR Cleanup - 08/25/2015 Deleted 6 lines Commented Code in
			 * this block
			 */

			sqlMap.put(FwConstants.CRITERIA, criteria);

			Date currentDate = fwDate.getDate();
			currentDate.setDate(1);
			currentDate.setMonth(currentDate.getMonth() + 1);
			currentDate.setDate(currentDate.getDate() - 1);
			final Date endOfCurMnth = currentDate;
			criteria[2] = new FwDataCriteria();
			criteria[2].setColumn_value(currentDate.toString());
			criteria[2].setData_type(FwConstants.STRING);

			currentDate = fwDate.getDate();
			currentDate.setDate(1);
			final Date beginOfCurMnth = currentDate;// added for FAP amt
			criteria[3] = new FwDataCriteria();
			criteria[3].setColumn_value(currentDate.toString());
			criteria[3].setData_type(FwConstants.STRING);
			sqlMap.put(FwConstants.CRITERIA, criteria);
			final String paymentAmount = getFAPPaymentAmount(caseNum,
					endOfCurMnth, beginOfCurMnth);// added
			// for
			// FAP
			// amt
			final List res = executeSQL(sqlMap);
			if (null != res && !res.isEmpty()) {
				final CUST_INDV_ELG_Cargo[] custIndvElgCargo = new CUST_INDV_ELG_Cargo[res
						.size()];

				for (int i = 0; i < res.size(); i++) {
					final Map cargo = (Map) res.get(i);
					custIndvElgCargo[i] = new CUST_INDV_ELG_Cargo();
					custIndvElgCargo[i].setMci_id((String) cargo.get("MCI_ID"));
					custIndvElgCargo[i].setBnft_pin_num((String) cargo
							.get("BNFT_PIN_NUM"));
					custIndvElgCargo[i].setBnft_case_num((String) cargo
							.get("BNFT_CASE_NUM"));
					custIndvElgCargo[i].setCat_cd((String) cargo.get("CAT_CD"));
					custIndvElgCargo[i].setScat_cd((String) cargo
							.get("SCAT_CD"));
					custIndvElgCargo[i].setScat_seq_num((String) cargo
							.get("SCAT_SEQ_NUM"));
					custIndvElgCargo[i].setCur_elg_ind((String) cargo
							.get("CUR_ELG_IND"));
					custIndvElgCargo[i].setBnft_stat_cd((String) cargo
							.get("BNFT_STAT_CD"));
					custIndvElgCargo[i].setCnfm_dt((String) cargo
							.get("CNFM_DT"));
					custIndvElgCargo[i].setElg_beg_dt((String) cargo
							.get("ELG_BEG_DT"));
					custIndvElgCargo[i].setElg_end_dt((String) cargo
							.get("ELG_END_DT"));
					custIndvElgCargo[i].setElg_ind((String) cargo
							.get("ELG_IND"));
					custIndvElgCargo[i].setMa_ddct_bal_amt((String) cargo
							.get("MA_DDCT_BAL_AMT"));

					if (paymentAmount == null) {

						custIndvElgCargo[i].setPymt_amt("0.00");
						custIndvElgCargo[i].setFapAmountExists(false);
					} else {

						custIndvElgCargo[i].setPymt_amt(paymentAmount);
						custIndvElgCargo[i].setFapAmountExists(true);
					}

					custIndvElgCargo[i].setPymt_beg_dt((String) cargo
							.get("PYMT_BEG_DT"));
					custIndvElgCargo[i].setPymt_end_dt((String) cargo
							.get("PYMT_END_DT"));
					custIndvElgCargo[i].setPymt_typ((String) cargo
							.get("PYMT_TYP"));
					custIndvElgCargo[i].setSc_bnft_lvl_cd((String) cargo
							.get("SC_BNFT_LVL_CD"));
					custIndvElgCargo[i].setUpdt_dt((String) cargo
							.get("UPDT_DT"));
					custIndvElgCargo[i].setVfcn_due_dt((String) cargo
							.get("VFCN_DUE_DT"));
					custIndvElgCargo[i].setMsg_cd_txt((String) cargo
							.get("MSG_CD_TXT"));
					custIndvElgCargo[i].setFst_nam(cargo.get("FST_NAM")
							.toString().trim());
					custIndvElgCargo[i].setSex_ind((String) cargo
							.get("SEX_IND"));
					custIndvElgCargo[i].setAg_stat_rsn_1_cd((String) cargo
							.get("AG_STAT_RSN_1_CD"));
					custIndvElgCargo[i].setAg_stat_rsn_2_cd((String) cargo
							.get("AG_STAT_RSN_2_CD"));
					custIndvElgCargo[i].setAg_stat_rsn_3_cd((String) cargo
							.get("AG_STAT_RSN_3_CD"));
					custIndvElgCargo[i].setNf_elg_rslt_cd((String) cargo
							.get("NF_ELG_RSLT_CD"));
					custIndvElgCargo[i].setNf_fail_rsn_1_cd((String) cargo
							.get("NF_FAIL_RSN_1_CD"));
					custIndvElgCargo[i].setNf_fail_rsn_2_cd((String) cargo
							.get("NF_FAIL_RSN_2_CD"));
					custIndvElgCargo[i].setNf_fail_rsn_3_cd((String) cargo
							.get("NF_FAIL_RSN_3_CD"));
					custIndvElgCargo[i].setOrg_elg_ind((String) cargo
							.get("ORIG_ELG_IND"));
					custIndvElgCargo[i].setPrev_pymt_amt((String) cargo
							.get("PREV_PYMT_AMT"));
					custIndvElgCargo[i].setFs_grp_typ((String) cargo
							.get("FS_GRP_TYP"));
					custIndvElgCargo[i].setFs_fpl_130pct_amt((String) cargo
							.get("FS_FPL_130PCT_AMT"));
					custIndvElgCargo[i].setPgm_rqst_sw((String) cargo
							.get("PGM_RQST_SW"));
					custIndvElgCargo[i].setPrev_sc_bnft_l_cd((String) cargo
							.get("PREV_SC_BNFT_L_CD"));
					custIndvElgCargo[i].setBrth_dt((String) cargo
							.get("BRTH_DT"));
					custIndvElgCargo[i].setEmpl_vfcn_due_dt((String) cargo
							.get("EMPL_VFCN_DUE_DT"));
					custIndvElgCargo[i].setIns_vfcn_due_dt((String) cargo
							.get("INS_VFCN_DUE_DT"));
					custIndvElgCargo[i].setSmirf_mo((String) cargo
							.get("SMIRF_MO"));
					custIndvElgCargo[i]
							.setSemi_annual_review_date((String) cargo
									.get("SEMI_ANNUAL_REVIEW_DT"));
					custIndvElgCargo[i].setReview_dt((String) cargo
							.get("REVIEW_DT"));
					custIndvElgCargo[i].setMid_cert_review_date((String) cargo
							.get("MID_CERT_REVIEW_DT"));
				}
				custIndvElgColl.setResults(custIndvElgCargo);
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getDetailGrouping", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getDetailIneligibleGrouping() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return custIndvElgColl;
	}

	/**
	 * This method returns Indv eligibility collection.
	 *
	 * @param caseNum
	 *            case number
	 * @param catCd
	 *            the cat cd
	 * @param elgInd
	 *            the elg ind
	 * @return the detail individual ineligible grouping
	 */

	public CUST_INDV_ELG_Collection getDetailIndividualIneligibleGrouping(
			final String caseNum, final String catCd, final String elgInd) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"MyAccessBO.getDetailIndividualIneligibleGrouping() - START");
		final Map sqlMap = new HashMap();
		final CUST_INDV_ELG_Collection custIndvElgColl = new CUST_INDV_ELG_Collection();
		try {
			sqlMap.put(FwConstants.SQL_IND, "sql-245");
			final FwDataCriteria[] criteria = new FwDataCriteria[4];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_value(caseNum);
			criteria[0].setData_type(FwConstants.LONG);
			criteria[1] = new FwDataCriteria();
			criteria[1].setColumn_value(catCd);
			criteria[1].setData_type(FwConstants.STRING);

			/*
			 * VG SONAR Cleanup - 08/25/2015 Deleted 6,1,1 lines Commented Code
			 * in this block
			 */

			sqlMap.put(FwConstants.CRITERIA, criteria);

			Date currentDate = fwDate.getDate();
			currentDate.setDate(1);
			currentDate.setMonth(currentDate.getMonth() + 1);
			currentDate.setDate(currentDate.getDate() - 1);

			criteria[2] = new FwDataCriteria();
			criteria[2].setColumn_value(currentDate.toString());
			criteria[2].setData_type(FwConstants.STRING);

			currentDate = fwDate.getDate();
			currentDate.setDate(1);
			// added for FAP amt
			criteria[3] = new FwDataCriteria();
			criteria[3].setColumn_value(currentDate.toString());
			criteria[3].setData_type(FwConstants.STRING);
			sqlMap.put(FwConstants.CRITERIA, criteria);
			final List res = executeSQL(sqlMap);
			if (null != res && !res.isEmpty()) {
				final CUST_INDV_ELG_Cargo[] custIndvElgCargo = new CUST_INDV_ELG_Cargo[res
						.size()];

				for (int i = 0; i < res.size(); i++) {
					final Map cargo = (Map) res.get(i);
					custIndvElgCargo[i] = new CUST_INDV_ELG_Cargo();
					custIndvElgCargo[i].setMci_id((String) cargo.get("MCI_ID"));
					custIndvElgCargo[i].setBnft_pin_num((String) cargo
							.get("BNFT_PIN_NUM"));
					custIndvElgCargo[i].setBnft_case_num((String) cargo
							.get("BNFT_CASE_NUM"));
					custIndvElgCargo[i].setCat_cd((String) cargo.get("CAT_CD"));
					custIndvElgCargo[i].setScat_cd((String) cargo
							.get("SCAT_CD"));
					custIndvElgCargo[i].setScat_seq_num((String) cargo
							.get("SCAT_SEQ_NUM"));
					custIndvElgCargo[i].setCur_elg_ind((String) cargo
							.get("CUR_ELG_IND"));
					custIndvElgCargo[i].setBnft_stat_cd((String) cargo
							.get("BNFT_STAT_CD"));
					custIndvElgCargo[i].setCnfm_dt((String) cargo
							.get("CNFM_DT"));
					custIndvElgCargo[i].setElg_beg_dt((String) cargo
							.get("ELG_BEG_DT"));
					custIndvElgCargo[i].setElg_end_dt((String) cargo
							.get("ELG_END_DT"));
					custIndvElgCargo[i].setElg_ind((String) cargo
							.get("ELG_IND"));
					custIndvElgCargo[i].setMa_ddct_bal_amt((String) cargo
							.get("MA_DDCT_BAL_AMT"));
					custIndvElgCargo[i].setPymt_amt((String) cargo
							.get("PYMT_AMT"));
					custIndvElgCargo[i].setPymt_beg_dt((String) cargo
							.get("PYMT_BEG_DT"));
					custIndvElgCargo[i].setPymt_end_dt((String) cargo
							.get("PYMT_END_DT"));
					custIndvElgCargo[i].setPymt_typ((String) cargo
							.get("PYMT_TYP"));
					custIndvElgCargo[i].setSc_bnft_lvl_cd((String) cargo
							.get("SC_BNFT_LVL_CD"));
					custIndvElgCargo[i].setUpdt_dt((String) cargo
							.get("UPDT_DT"));
					custIndvElgCargo[i].setVfcn_due_dt((String) cargo
							.get("VFCN_DUE_DT"));
					custIndvElgCargo[i].setMsg_cd_txt((String) cargo
							.get("MSG_CD_TXT"));
					custIndvElgCargo[i].setFst_nam(cargo.get("FST_NAM")
							.toString().trim());
					custIndvElgCargo[i].setSex_ind((String) cargo
							.get("SEX_IND"));
					custIndvElgCargo[i].setAg_stat_rsn_1_cd((String) cargo
							.get("AG_STAT_RSN_1_CD"));
					custIndvElgCargo[i].setAg_stat_rsn_2_cd((String) cargo
							.get("AG_STAT_RSN_2_CD"));
					custIndvElgCargo[i].setAg_stat_rsn_3_cd((String) cargo
							.get("AG_STAT_RSN_3_CD"));
					custIndvElgCargo[i].setNf_elg_rslt_cd((String) cargo
							.get("NF_ELG_RSLT_CD"));
					custIndvElgCargo[i].setNf_fail_rsn_1_cd((String) cargo
							.get("NF_FAIL_RSN_1_CD"));
					custIndvElgCargo[i].setNf_fail_rsn_2_cd((String) cargo
							.get("NF_FAIL_RSN_2_CD"));
					custIndvElgCargo[i].setNf_fail_rsn_3_cd((String) cargo
							.get("NF_FAIL_RSN_3_CD"));
					custIndvElgCargo[i].setOrg_elg_ind((String) cargo
							.get("ORIG_ELG_IND"));
					custIndvElgCargo[i].setPrev_pymt_amt((String) cargo
							.get("PREV_PYMT_AMT"));
					custIndvElgCargo[i].setFs_grp_typ((String) cargo
							.get("FS_GRP_TYP"));
					custIndvElgCargo[i].setFs_fpl_130pct_amt((String) cargo
							.get("FS_FPL_130PCT_AMT"));
					custIndvElgCargo[i].setPgm_rqst_sw((String) cargo
							.get("PGM_RQST_SW"));
					custIndvElgCargo[i].setPrev_sc_bnft_l_cd((String) cargo
							.get("PREV_SC_BNFT_L_CD"));
					custIndvElgCargo[i].setBrth_dt((String) cargo
							.get("BRTH_DT"));
					custIndvElgCargo[i].setEmpl_vfcn_due_dt((String) cargo
							.get("EMPL_VFCN_DUE_DT"));
					custIndvElgCargo[i].setIns_vfcn_due_dt((String) cargo
							.get("INS_VFCN_DUE_DT"));
					custIndvElgCargo[i].setSmirf_mo((String) cargo
							.get("SMIRF_MO"));
					custIndvElgCargo[i]
							.setSemi_annual_review_date((String) cargo
									.get("SEMI_ANNUAL_REVIEW_DT"));
					custIndvElgCargo[i].setReview_dt((String) cargo
							.get("REVIEW_DT"));
					custIndvElgCargo[i].setMid_cert_review_date((String) cargo
							.get("MID_CERT_REVIEW_DT"));
				}
				custIndvElgColl.setResults(custIndvElgCargo);
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getDetailGrouping", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getDetailIndividualIneligibleGrouping() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return custIndvElgColl;
	}

	/**
	 * This method returns Indv eligibility collection.
	 *
	 * @param caseNum
	 *            case number
	 * @param catCd
	 *            the cat cd
	 * @return the pend record grouping
	 */

	// this method for the pend records
	public CUST_INDV_ELG_Collection getPendRecordGrouping(final String caseNum,
			final String catCd) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getPendRecordGrouping() - START");
		final Map sqlMap = new HashMap();
		final CUST_INDV_ELG_Collection custIndvElgColl = new CUST_INDV_ELG_Collection();
		try {
			sqlMap.put(FwConstants.SQL_IND, "sql-203");
			final FwDataCriteria[] criteria = new FwDataCriteria[2];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_value(caseNum);
			criteria[0].setData_type(FwConstants.LONG);
			criteria[1] = new FwDataCriteria();
			criteria[1].setColumn_value(catCd);
			criteria[1].setData_type(FwConstants.STRING);
			sqlMap.put(FwConstants.CRITERIA, criteria);
			final List res = executeSQL(sqlMap);
			if (null != res && !res.isEmpty()) {
				final CUST_INDV_ELG_Cargo[] custIndvElgCargo = new CUST_INDV_ELG_Cargo[res
						.size()];
				for (int i = 0; i < res.size(); i++) {
					final Map cargo = (Map) res.get(i);
					custIndvElgCargo[i] = new CUST_INDV_ELG_Cargo();
					custIndvElgCargo[i].setMci_id((String) cargo.get("MCI_ID"));
					custIndvElgCargo[i].setBnft_pin_num((String) cargo
							.get("BNFT_PIN_NUM"));
					custIndvElgCargo[i].setBnft_case_num((String) cargo
							.get("BNFT_CASE_NUM"));
					custIndvElgCargo[i].setCat_cd((String) cargo.get("CAT_CD"));
					custIndvElgCargo[i].setScat_cd((String) cargo
							.get("SCAT_CD"));
					custIndvElgCargo[i].setScat_seq_num((String) cargo
							.get("SCAT_SEQ_NUM"));
					custIndvElgCargo[i].setCur_elg_ind((String) cargo
							.get("CUR_ELG_IND"));
					custIndvElgCargo[i].setElg_ind((String) cargo
							.get("ELG_IND"));
					custIndvElgCargo[i].setCnfm_dt((String) cargo
							.get("CNFM_DT"));
					custIndvElgCargo[i].setOrg_elg_ind((String) cargo
							.get("ORIG_ELG_IND"));
					custIndvElgCargo[i].setVfcn_due_dt((String) cargo
							.get("VFCN_DUE_DT"));
					custIndvElgCargo[i].setMsg_cd_txt((String) cargo
							.get("MSG_CD_TXT"));
					custIndvElgCargo[i].setFst_nam(cargo.get("FST_NAM")
							.toString().trim());
					custIndvElgCargo[i].setSex_ind((String) cargo
							.get("SEX_IND"));
					custIndvElgCargo[i].setPgm_rqst_sw((String) cargo
							.get("PGM_RQST_SW"));
					custIndvElgCargo[i].setPrev_sc_bnft_l_cd((String) cargo
							.get("PREV_SC_BNFT_L_CD"));
					custIndvElgCargo[i].setBrth_dt((String) cargo
							.get("BRTH_DT"));
					custIndvElgCargo[i].setEmpl_vfcn_due_dt((String) cargo
							.get("EMPL_VFCN_DUE_DT"));
					custIndvElgCargo[i].setIns_vfcn_due_dt((String) cargo
							.get("INS_VFCN_DUE_DT"));
					custIndvElgCargo[i].setPymt_beg_dt((String) cargo
							.get("PYMT_BEG_DT"));
					custIndvElgCargo[i].setPymt_end_dt((String) cargo
							.get("PYMT_END_DT"));
					custIndvElgCargo[i].setMid_name(cargo.get("MID_INIT")
							.toString().trim());
					custIndvElgCargo[i].setLast_name(cargo.get("LAST_NAM")
							.toString().trim());

				}
				custIndvElgColl.setResults(custIndvElgCargo);
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getPendRecordGrouping", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getPendRecordGrouping() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return custIndvElgColl;
	}

	/**
	 * This method returns Indv eligibility collection.
	 *
	 * @param caseNum
	 *            case number
	 * @return the online summary in eligible grouping
	 */

	// this one for the online summary page Eligable, InEligable,
	// IndividualInEligable
	public CUST_INDV_ELG_Collection getOnlineSummaryInEligibleGrouping(
			final String caseNum) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"MyAccessBO.getOnlineSummaryInEligibleGrouping() - START");
		final Map sqlMap = new HashMap();
		final CUST_INDV_ELG_Collection custIndvElgColl = new CUST_INDV_ELG_Collection();
		try {

			sqlMap.put(FwConstants.SQL_IND, "sql-257");
			final FwDataCriteria[] criteria = new FwDataCriteria[1];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_value(caseNum);
			criteria[0].setData_type(FwConstants.LONG);
			Date currentDate = fwDate.getDate();
			currentDate.setDate(1);
			currentDate.setMonth(currentDate.getMonth() + 1);
			currentDate.setDate(currentDate.getDate() - 1);
			final Date endOfCurMnth = currentDate;
			/*
			 * VG SONAR Cleanup - 08/25/2015 Deleted 3,3,1 lines Commented Code
			 * in this block
			 */

			currentDate = fwDate.getDate();
			currentDate.setDate(1);
			final Date beginOfCurMnth = currentDate;
			// added for FAP amt

			sqlMap.put(FwConstants.CRITERIA, criteria);
			final String paymentAmount = getFAPPaymentAmount(caseNum,
					endOfCurMnth, beginOfCurMnth);// added
			// for
			// FAP
			// amt

			final List res = executeSQL(sqlMap);
			if (null != res && !res.isEmpty()) {
				final CUST_INDV_ELG_Cargo[] custIndvElgCargo = new CUST_INDV_ELG_Cargo[res
						.size()];

				for (int i = 0; i < res.size(); i++) {
					final Map cargo = (Map) res.get(i);
					custIndvElgCargo[i] = new CUST_INDV_ELG_Cargo();
					custIndvElgCargo[i].setMci_id((String) cargo.get("MCI_ID"));
					custIndvElgCargo[i].setBnft_pin_num((String) cargo
							.get("BNFT_PIN_NUM"));
					custIndvElgCargo[i].setBnft_case_num((String) cargo
							.get("BNFT_CASE_NUM"));
					custIndvElgCargo[i].setCat_cd((String) cargo.get("CAT_CD"));
					custIndvElgCargo[i].setScat_cd((String) cargo
							.get("SCAT_CD"));
					custIndvElgCargo[i].setScat_seq_num((String) cargo
							.get("SCAT_SEQ_NUM"));
					custIndvElgCargo[i].setCur_elg_ind((String) cargo
							.get("CUR_ELG_IND"));
					custIndvElgCargo[i].setBnft_stat_cd((String) cargo
							.get("BNFT_STAT_CD"));
					custIndvElgCargo[i].setCnfm_dt((String) cargo
							.get("CNFM_DT"));
					custIndvElgCargo[i].setElg_beg_dt((String) cargo
							.get("ELG_BEG_DT"));
					custIndvElgCargo[i].setElg_end_dt((String) cargo
							.get("ELG_END_DT"));
					custIndvElgCargo[i].setElg_ind((String) cargo
							.get("ELG_IND"));
					custIndvElgCargo[i].setMa_ddct_bal_amt((String) cargo
							.get("MA_DDCT_BAL_AMT"));

					if (paymentAmount == null) {
						custIndvElgCargo[i].setFapAmountExists(false);
						custIndvElgCargo[i].setPymt_amt("0.00");

					} else {
						custIndvElgCargo[i].setFapAmountExists(true);
						custIndvElgCargo[i].setPymt_amt(paymentAmount);
					}
					custIndvElgCargo[i].setPymt_beg_dt((String) cargo
							.get("PYMT_BEG_DT"));
					custIndvElgCargo[i].setPymt_end_dt((String) cargo
							.get("PYMT_END_DT"));
					custIndvElgCargo[i].setPymt_typ((String) cargo
							.get("PYMT_TYP"));
					custIndvElgCargo[i].setSc_bnft_lvl_cd((String) cargo
							.get("SC_BNFT_LVL_CD"));
					custIndvElgCargo[i].setUpdt_dt((String) cargo
							.get("UPDT_DT"));
					custIndvElgCargo[i].setVfcn_due_dt((String) cargo
							.get("VFCN_DUE_DT"));
					custIndvElgCargo[i].setMsg_cd_txt((String) cargo
							.get("MSG_CD_TXT"));
					custIndvElgCargo[i].setFst_nam(cargo.get("FST_NAM")
							.toString().trim());
					custIndvElgCargo[i].setSex_ind((String) cargo
							.get("SEX_IND"));
					custIndvElgCargo[i].setPgm_rqst_sw((String) cargo
							.get("PGM_RQST_SW"));
					custIndvElgCargo[i].setOrg_elg_ind((String) cargo
							.get("ORIG_ELG_IND"));
					custIndvElgCargo[i].setNf_fail_rsn_1_cd((String) cargo
							.get("NF_FAIL_RSN_1_CD"));
					custIndvElgCargo[i].setPrev_sc_bnft_l_cd((String) cargo
							.get("PREV_SC_BNFT_L_CD"));
					custIndvElgCargo[i].setBrth_dt((String) cargo
							.get("BRTH_DT"));
					custIndvElgCargo[i].setEmpl_vfcn_due_dt((String) cargo
							.get("EMPL_VFCN_DUE_DT"));
					custIndvElgCargo[i].setIns_vfcn_due_dt((String) cargo
							.get("INS_VFCN_DUE_DT"));
					custIndvElgCargo[i].setSmirf_mo((String) cargo
							.get("SMIRF_MO"));
					custIndvElgCargo[i]
							.setSemi_annual_review_date((String) cargo
									.get("SEMI_ANNUAL_REVIEW_DT"));
					custIndvElgCargo[i].setReview_dt((String) cargo
							.get("REVIEW_DT"));
					custIndvElgCargo[i].setMid_cert_review_date((String) cargo
							.get("MID_CERT_REVIEW_DT"));
					custIndvElgCargo[i].setMid_name(cargo.get("MID_INIT")
							.toString().trim());
					custIndvElgCargo[i].setLast_name(cargo.get("LAST_NAM")
							.toString().trim());

					if (cargo.get("SER_AUTH_DT") != null) {

						custIndvElgCargo[i].setSer_auth_dt(cargo
								.get("SER_AUTH_DT").toString().trim());

					} else {

						custIndvElgCargo[i].setSer_auth_dt(" ");
					}
				}
				custIndvElgColl.setResults(custIndvElgCargo);
			}

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getSummaryGrouping", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getOnlineSummaryInEligibleGrouping() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return custIndvElgColl;
	}

	/**
	 * This method returns Indv eligibility collection.
	 *
	 * @param caseNum
	 *            case number
	 * @return the summary in eligible grouping
	 */

	// this one for the summary page Eligable, InEligable, IndividualInEligable
	public CUST_INDV_ELG_Collection getSummaryInEligibleGrouping(
			final String caseNum) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getSummaryInEligibleGrouping() - START");
		final Map sqlMap = new HashMap();
		final CUST_INDV_ELG_Collection custIndvElgColl = new CUST_INDV_ELG_Collection();
		try {

			sqlMap.put(FwConstants.SQL_IND, "sql-ivr-242");
			final FwDataCriteria[] criteria = new FwDataCriteria[3];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_value(caseNum);
			criteria[0].setData_type(FwConstants.LONG);
			Date currentDate = fwDate.getDate();
			currentDate.setDate(1);
			currentDate.setMonth(currentDate.getMonth() + 1);
			currentDate.setDate(currentDate.getDate() - 1);
			final Date endOfCurMnth = currentDate;
			criteria[1] = new FwDataCriteria();
			criteria[1].setColumn_value(currentDate.toString());
			criteria[1].setData_type(FwConstants.STRING);
			currentDate = fwDate.getDate();
			currentDate.setDate(1);
			final Date beginOfCurMnth = currentDate;// added for FAP amt
			criteria[2] = new FwDataCriteria();
			criteria[2].setColumn_value(currentDate.toString());
			criteria[2].setData_type(FwConstants.STRING);
			sqlMap.put(FwConstants.CRITERIA, criteria);
			// santosh changed the method from getFAPPaymentAmount
			final String paymentAmount = getIVRFAPPaymentAmount(caseNum,
					endOfCurMnth, beginOfCurMnth);// added
													// for
													// FAP
													// amt

			final List res = executeSQL(sqlMap);
			if (null != res && !res.isEmpty()) {
				final CUST_INDV_ELG_Cargo[] custIndvElgCargo = new CUST_INDV_ELG_Cargo[res
						.size()];

				for (int i = 0; i < res.size(); i++) {
					final Map cargo = (Map) res.get(i);
					custIndvElgCargo[i] = new CUST_INDV_ELG_Cargo();
					custIndvElgCargo[i].setMci_id((String) cargo.get("MCI_ID"));
					custIndvElgCargo[i].setBnft_pin_num((String) cargo
							.get("BNFT_PIN_NUM"));
					custIndvElgCargo[i].setBnft_case_num((String) cargo
							.get("BNFT_CASE_NUM"));
					custIndvElgCargo[i].setCat_cd((String) cargo.get("CAT_CD"));
					custIndvElgCargo[i].setScat_cd((String) cargo
							.get("SCAT_CD"));
					custIndvElgCargo[i].setScat_seq_num((String) cargo
							.get("SCAT_SEQ_NUM"));
					custIndvElgCargo[i].setCur_elg_ind((String) cargo
							.get("CUR_ELG_IND"));
					custIndvElgCargo[i].setBnft_stat_cd((String) cargo
							.get("BNFT_STAT_CD"));
					custIndvElgCargo[i].setCnfm_dt((String) cargo
							.get("CNFM_DT"));
					custIndvElgCargo[i].setElg_beg_dt((String) cargo
							.get("ELG_BEG_DT"));
					custIndvElgCargo[i].setElg_end_dt((String) cargo
							.get("ELG_END_DT"));
					custIndvElgCargo[i].setElg_ind((String) cargo
							.get("ELG_IND"));
					custIndvElgCargo[i].setMa_ddct_bal_amt((String) cargo
							.get("MA_DDCT_BAL_AMT"));

					if (paymentAmount == null) {
						custIndvElgCargo[i].setFapAmountExists(false);
						custIndvElgCargo[i].setPymt_amt("0.00");

					} else {
						custIndvElgCargo[i].setFapAmountExists(true);
						custIndvElgCargo[i].setPymt_amt(paymentAmount);
					}
					custIndvElgCargo[i].setPymt_beg_dt((String) cargo
							.get("PYMT_BEG_DT"));
					custIndvElgCargo[i].setPymt_end_dt((String) cargo
							.get("PYMT_END_DT"));
					custIndvElgCargo[i].setPymt_typ((String) cargo
							.get("PYMT_TYP"));
					custIndvElgCargo[i].setSc_bnft_lvl_cd((String) cargo
							.get("SC_BNFT_LVL_CD"));
					custIndvElgCargo[i].setUpdt_dt((String) cargo
							.get("UPDT_DT"));
					custIndvElgCargo[i].setVfcn_due_dt((String) cargo
							.get("VFCN_DUE_DT"));
					custIndvElgCargo[i].setMsg_cd_txt((String) cargo
							.get("MSG_CD_TXT"));
					custIndvElgCargo[i].setFst_nam(cargo.get("FST_NAM")
							.toString().trim());
					custIndvElgCargo[i].setSex_ind((String) cargo
							.get("SEX_IND"));
					custIndvElgCargo[i].setPgm_rqst_sw((String) cargo
							.get("PGM_RQST_SW"));
					custIndvElgCargo[i].setOrg_elg_ind((String) cargo
							.get("ORIG_ELG_IND"));
					custIndvElgCargo[i].setNf_fail_rsn_1_cd((String) cargo
							.get("NF_FAIL_RSN_1_CD"));
					custIndvElgCargo[i].setPrev_sc_bnft_l_cd((String) cargo
							.get("PREV_SC_BNFT_L_CD"));
					custIndvElgCargo[i].setBrth_dt((String) cargo
							.get("BRTH_DT"));
					custIndvElgCargo[i].setEmpl_vfcn_due_dt((String) cargo
							.get("EMPL_VFCN_DUE_DT"));
					custIndvElgCargo[i].setIns_vfcn_due_dt((String) cargo
							.get("INS_VFCN_DUE_DT"));
					custIndvElgCargo[i].setSmirf_mo((String) cargo
							.get("SMIRF_MO"));
					custIndvElgCargo[i]
							.setSemi_annual_review_date((String) cargo
									.get("SEMI_ANNUAL_REVIEW_DT"));
					custIndvElgCargo[i].setReview_dt((String) cargo
							.get("REVIEW_DT"));
					custIndvElgCargo[i].setMid_cert_review_date((String) cargo
							.get("MID_CERT_REVIEW_DT"));
					custIndvElgCargo[i].setMid_name(cargo.get("MID_INIT")
							.toString().trim());
					custIndvElgCargo[i].setLast_name(cargo.get("LAST_NAM")
							.toString().trim());
				}
				custIndvElgColl.setResults(custIndvElgCargo);
			}

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getSummaryGrouping", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getSummaryInEligibleGrouping() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return custIndvElgColl;
	}

	/**
	 * This method returns Indv eligibility collection.
	 *
	 * @param caseNum
	 *            case number
	 * @return the summary individual ineligible grouping
	 */

	public CUST_INDV_ELG_Collection getSummaryIndividualIneligibleGrouping(
			final String caseNum) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"MyAccessBO.getSummaryIndividualIneligibleGrouping() - START");
		final Map sqlMap = new HashMap();
		final CUST_INDV_ELG_Collection custIndvElgColl = new CUST_INDV_ELG_Collection();
		try {

			sqlMap.put(FwConstants.SQL_IND, "sql-243");
			final FwDataCriteria[] criteria = new FwDataCriteria[3];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_value(caseNum);
			criteria[0].setData_type(FwConstants.LONG);
			Date currentDate = fwDate.getDate();
			currentDate.setDate(1);
			currentDate.setMonth(currentDate.getMonth() + 1);
			currentDate.setDate(currentDate.getDate() - 1);
			criteria[1] = new FwDataCriteria();
			criteria[1].setColumn_value(currentDate.toString());
			criteria[1].setData_type(FwConstants.STRING);
			currentDate = fwDate.getDate();
			currentDate.setDate(1);
			criteria[2] = new FwDataCriteria();
			criteria[2].setColumn_value(currentDate.toString());
			criteria[2].setData_type(FwConstants.STRING);
			sqlMap.put(FwConstants.CRITERIA, criteria);
			/*
			 * VG SONAR Cleanup - 08/25/2015 Deleted 1 lines Commented Code in
			 * this block
			 */
			// added for FAP amt
			final List res = executeSQL(sqlMap);
			if (null != res && !res.isEmpty()) {
				final CUST_INDV_ELG_Cargo[] custIndvElgCargo = new CUST_INDV_ELG_Cargo[res
						.size()];

				for (int i = 0; i < res.size(); i++) {
					final Map cargo = (Map) res.get(i);
					custIndvElgCargo[i] = new CUST_INDV_ELG_Cargo();
					custIndvElgCargo[i].setMci_id((String) cargo.get("MCI_ID"));
					custIndvElgCargo[i].setBnft_pin_num((String) cargo
							.get("BNFT_PIN_NUM"));
					custIndvElgCargo[i].setBnft_case_num((String) cargo
							.get("BNFT_CASE_NUM"));
					custIndvElgCargo[i].setCat_cd((String) cargo.get("CAT_CD"));
					custIndvElgCargo[i].setScat_cd((String) cargo
							.get("SCAT_CD"));
					custIndvElgCargo[i].setScat_seq_num((String) cargo
							.get("SCAT_SEQ_NUM"));
					custIndvElgCargo[i].setCur_elg_ind((String) cargo
							.get("CUR_ELG_IND"));
					custIndvElgCargo[i].setBnft_stat_cd((String) cargo
							.get("BNFT_STAT_CD"));
					custIndvElgCargo[i].setCnfm_dt((String) cargo
							.get("CNFM_DT"));
					custIndvElgCargo[i].setElg_beg_dt((String) cargo
							.get("ELG_BEG_DT"));
					custIndvElgCargo[i].setElg_end_dt((String) cargo
							.get("ELG_END_DT"));
					custIndvElgCargo[i].setElg_ind((String) cargo
							.get("ELG_IND"));
					custIndvElgCargo[i].setMa_ddct_bal_amt((String) cargo
							.get("MA_DDCT_BAL_AMT"));
					custIndvElgCargo[i].setPymt_amt((String) cargo
							.get("PYMT_AMT"));
					custIndvElgCargo[i].setPymt_beg_dt((String) cargo
							.get("PYMT_BEG_DT"));
					custIndvElgCargo[i].setPymt_end_dt((String) cargo
							.get("PYMT_END_DT"));
					custIndvElgCargo[i].setPymt_typ((String) cargo
							.get("PYMT_TYP"));
					custIndvElgCargo[i].setSc_bnft_lvl_cd((String) cargo
							.get("SC_BNFT_LVL_CD"));
					custIndvElgCargo[i].setUpdt_dt((String) cargo
							.get("UPDT_DT"));
					custIndvElgCargo[i].setVfcn_due_dt((String) cargo
							.get("VFCN_DUE_DT"));
					custIndvElgCargo[i].setMsg_cd_txt((String) cargo
							.get("MSG_CD_TXT"));
					custIndvElgCargo[i].setFst_nam(cargo.get("FST_NAM")
							.toString().trim());
					custIndvElgCargo[i].setSex_ind((String) cargo
							.get("SEX_IND"));
					custIndvElgCargo[i].setPgm_rqst_sw((String) cargo
							.get("PGM_RQST_SW"));
					custIndvElgCargo[i].setOrg_elg_ind((String) cargo
							.get("ORIG_ELG_IND"));
					custIndvElgCargo[i].setNf_fail_rsn_1_cd((String) cargo
							.get("NF_FAIL_RSN_1_CD"));
					custIndvElgCargo[i].setPrev_sc_bnft_l_cd((String) cargo
							.get("PREV_SC_BNFT_L_CD"));
					custIndvElgCargo[i].setBrth_dt((String) cargo
							.get("BRTH_DT"));
					custIndvElgCargo[i].setEmpl_vfcn_due_dt((String) cargo
							.get("EMPL_VFCN_DUE_DT"));
					custIndvElgCargo[i].setIns_vfcn_due_dt((String) cargo
							.get("INS_VFCN_DUE_DT"));
					custIndvElgCargo[i].setSmirf_mo((String) cargo
							.get("SMIRF_MO"));
					custIndvElgCargo[i]
							.setSemi_annual_review_date((String) cargo
									.get("SEMI_ANNUAL_REVIEW_DT"));
					custIndvElgCargo[i].setReview_dt((String) cargo
							.get("REVIEW_DT"));
					custIndvElgCargo[i].setMid_cert_review_date((String) cargo
							.get("MID_CERT_REVIEW_DT"));
				}
				custIndvElgColl.setResults(custIndvElgCargo);
			}

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getSummaryGrouping", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getSummaryIndividualIneligibleGrouping() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return custIndvElgColl;
	}

	/**
	 * This method returns Indv eligibility collection.
	 *
	 * @param caseNum
	 *            case number
	 * @return the summary eligible grouping
	 */

	// this one for the summary page Eligable, InEligable, IndividualInEligable
	public CUST_INDV_ELG_Collection getSummaryEligibleGrouping(
			final String caseNum) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getSummaryEligibleGrouping() - START");
		final Map sqlMap = new HashMap();
		final CUST_INDV_ELG_Collection custIndvElgColl = new CUST_INDV_ELG_Collection();
		try {

			sqlMap.put(FwConstants.SQL_IND, "sql-204");
			final FwDataCriteria[] criteria = new FwDataCriteria[1];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_value(caseNum);
			criteria[0].setData_type(FwConstants.LONG);
			Date currentDate = fwDate.getDate();
			currentDate.setDate(1);
			currentDate.setMonth(currentDate.getMonth() + 1);
			currentDate.setDate(currentDate.getDate() - 1);
			final Date endOfCurMnth = currentDate;// added for FAP amt
			/*
			 * VG SONAR Cleanup - 08/25/2015 Deleted 3,3,1 lines Commented Code
			 * in this block
			 */

			currentDate = fwDate.getDate();
			currentDate.setDate(1);
			final Date beginOfCurMnth = currentDate;// added for FAP amt

			sqlMap.put(FwConstants.CRITERIA, criteria);
			final String paymentAmount = getFAPPaymentAmount(caseNum,
					endOfCurMnth, beginOfCurMnth);// added
			// for
			// FAP
			// amt
			final List res = executeSQL(sqlMap);
			if (null != res && !res.isEmpty()) {
				final CUST_INDV_ELG_Cargo[] custIndvElgCargo = new CUST_INDV_ELG_Cargo[res
						.size()];

				for (int i = 0; i < res.size(); i++) {
					final Map cargo = (Map) res.get(i);
					custIndvElgCargo[i] = new CUST_INDV_ELG_Cargo();
					custIndvElgCargo[i].setMci_id((String) cargo.get("MCI_ID"));
					custIndvElgCargo[i].setBnft_pin_num((String) cargo
							.get("BNFT_PIN_NUM"));
					custIndvElgCargo[i].setBnft_case_num((String) cargo
							.get("BNFT_CASE_NUM"));
					custIndvElgCargo[i].setCat_cd((String) cargo.get("CAT_CD"));
					custIndvElgCargo[i].setScat_cd((String) cargo
							.get("SCAT_CD"));
					custIndvElgCargo[i].setScat_seq_num((String) cargo
							.get("SCAT_SEQ_NUM"));
					custIndvElgCargo[i].setCur_elg_ind((String) cargo
							.get("CUR_ELG_IND"));
					custIndvElgCargo[i].setBnft_stat_cd((String) cargo
							.get("BNFT_STAT_CD"));
					custIndvElgCargo[i].setCnfm_dt((String) cargo
							.get("CNFM_DT"));
					custIndvElgCargo[i].setElg_beg_dt((String) cargo
							.get("ELG_BEG_DT"));
					custIndvElgCargo[i].setElg_end_dt((String) cargo
							.get("ELG_END_DT"));
					custIndvElgCargo[i].setElg_ind((String) cargo
							.get("ELG_IND"));
					custIndvElgCargo[i].setMa_ddct_bal_amt((String) cargo
							.get("MA_DDCT_BAL_AMT"));
					if (paymentAmount != null) {
						custIndvElgCargo[i].setPymt_amt(paymentAmount);
					} else {
						custIndvElgCargo[i].setPymt_amt("0.00");
					}
					custIndvElgCargo[i].setPymt_beg_dt((String) cargo
							.get("PYMT_BEG_DT"));
					custIndvElgCargo[i].setPymt_end_dt((String) cargo
							.get("PYMT_END_DT"));
					custIndvElgCargo[i].setPymt_typ((String) cargo
							.get("PYMT_TYP"));
					custIndvElgCargo[i].setSc_bnft_lvl_cd((String) cargo
							.get("SC_BNFT_LVL_CD"));
					custIndvElgCargo[i].setUpdt_dt((String) cargo
							.get("UPDT_DT"));
					custIndvElgCargo[i].setVfcn_due_dt((String) cargo
							.get("VFCN_DUE_DT"));
					custIndvElgCargo[i].setMsg_cd_txt((String) cargo
							.get("MSG_CD_TXT"));
					custIndvElgCargo[i].setFst_nam(cargo.get("FST_NAM")
							.toString().trim());
					custIndvElgCargo[i].setSex_ind((String) cargo
							.get("SEX_IND"));
					custIndvElgCargo[i].setPgm_rqst_sw((String) cargo
							.get("PGM_RQST_SW"));
					custIndvElgCargo[i].setOrg_elg_ind((String) cargo
							.get("ORIG_ELG_IND"));
					custIndvElgCargo[i].setNf_fail_rsn_1_cd((String) cargo
							.get("NF_FAIL_RSN_1_CD"));
					custIndvElgCargo[i].setPrev_sc_bnft_l_cd((String) cargo
							.get("PREV_SC_BNFT_L_CD"));
					custIndvElgCargo[i].setBrth_dt((String) cargo
							.get("BRTH_DT"));
					custIndvElgCargo[i].setEmpl_vfcn_due_dt((String) cargo
							.get("EMPL_VFCN_DUE_DT"));
					custIndvElgCargo[i].setIns_vfcn_due_dt((String) cargo
							.get("INS_VFCN_DUE_DT"));
					custIndvElgCargo[i].setSmirf_mo((String) cargo
							.get("SMIRF_MO"));

					if (cargo.get("SER_AUTH_DT") != null) {

						custIndvElgCargo[i].setSer_auth_dt(cargo
								.get("SER_AUTH_DT").toString().trim());

					} else {

						custIndvElgCargo[i].setSer_auth_dt(" ");
					}

					custIndvElgCargo[i].setMid_cert_review_date((String) cargo
							.get("MID_CERT_REVIEW_DT"));
					custIndvElgCargo[i]
							.setSemi_annual_review_date((String) cargo
									.get("SEMI_ANNUAL_REVIEW_DT"));
					custIndvElgCargo[i].setReview_dt((String) cargo
							.get("REVIEW_DT"));
				}
				custIndvElgColl.setResults(custIndvElgCargo);
			}

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getSummaryGrouping", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getSummaryEligibleGrouping() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return custIndvElgColl;
	}

	/**
	 * This method returns Indv eligibility collection.
	 *
	 * @param caseNum
	 *            case number
	 * @return the IVR summary eligible grouping
	 */

	public CUST_INDV_ELG_Collection getIVRSummaryEligibleGrouping(
			final String caseNum) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getIVRSummaryEligibleGrouping() - START");
		final Map sqlMap = new HashMap();
		final CUST_INDV_ELG_Collection custIndvElgColl = new CUST_INDV_ELG_Collection();
		try {

			sqlMap.put(FwConstants.SQL_IND, "sql-ivr-004");
			final FwDataCriteria[] criteria = new FwDataCriteria[3];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_value(caseNum);
			criteria[0].setData_type(FwConstants.LONG);
			Date currentDate = fwDate.getDate();
			currentDate.setDate(1);
			currentDate.setMonth(currentDate.getMonth() + 1);
			currentDate.setDate(currentDate.getDate() - 1);
			final Date endOfCurMnth = currentDate;// added for FAP amt
			criteria[1] = new FwDataCriteria();
			criteria[1].setColumn_value(currentDate.toString());
			criteria[1].setData_type(FwConstants.STRING);
			currentDate = fwDate.getDate();
			currentDate.setDate(1);
			final Date beginOfCurMnth = currentDate;// added for FAP amt
			criteria[2] = new FwDataCriteria();
			criteria[2].setColumn_value(currentDate.toString());
			criteria[2].setData_type(FwConstants.STRING);
			sqlMap.put(FwConstants.CRITERIA, criteria);
			// santosh changed the from getFAPPaymentAmount for SER IVR Impact
			final String paymentAmount = getIVRFAPPaymentAmount(caseNum,
					endOfCurMnth, beginOfCurMnth);// added
													// for
													// FAP
													// amt
			final List res = executeSQL(sqlMap);
			if (null != res && !res.isEmpty()) {
				final CUST_INDV_ELG_Cargo[] custIndvElgCargo = new CUST_INDV_ELG_Cargo[res
						.size()];

				for (int i = 0; i < res.size(); i++) {
					final Map cargo = (Map) res.get(i);
					custIndvElgCargo[i] = new CUST_INDV_ELG_Cargo();
					custIndvElgCargo[i].setMci_id((String) cargo.get("MCI_ID"));
					custIndvElgCargo[i].setBnft_pin_num((String) cargo
							.get("BNFT_PIN_NUM"));
					custIndvElgCargo[i].setBnft_case_num((String) cargo
							.get("BNFT_CASE_NUM"));
					custIndvElgCargo[i].setCat_cd((String) cargo.get("CAT_CD"));
					custIndvElgCargo[i].setScat_cd((String) cargo
							.get("SCAT_CD"));
					custIndvElgCargo[i].setScat_seq_num((String) cargo
							.get("SCAT_SEQ_NUM"));
					custIndvElgCargo[i].setCur_elg_ind((String) cargo
							.get("CUR_ELG_IND"));
					custIndvElgCargo[i].setBnft_stat_cd((String) cargo
							.get("BNFT_STAT_CD"));
					custIndvElgCargo[i].setCnfm_dt((String) cargo
							.get("CNFM_DT"));
					custIndvElgCargo[i].setElg_beg_dt((String) cargo
							.get("ELG_BEG_DT"));
					custIndvElgCargo[i].setElg_end_dt((String) cargo
							.get("ELG_END_DT"));
					custIndvElgCargo[i].setElg_ind((String) cargo
							.get("ELG_IND"));
					custIndvElgCargo[i].setMa_ddct_bal_amt((String) cargo
							.get("MA_DDCT_BAL_AMT"));
					custIndvElgCargo[i].setPymt_amt(paymentAmount);// added for
					// FAP amt
					custIndvElgCargo[i].setPymt_beg_dt((String) cargo
							.get("PYMT_BEG_DT"));
					custIndvElgCargo[i].setPymt_end_dt((String) cargo
							.get("PYMT_END_DT"));
					custIndvElgCargo[i].setPymt_typ((String) cargo
							.get("PYMT_TYP"));
					custIndvElgCargo[i].setSc_bnft_lvl_cd((String) cargo
							.get("SC_BNFT_LVL_CD"));
					custIndvElgCargo[i].setUpdt_dt((String) cargo
							.get("UPDT_DT"));
					custIndvElgCargo[i].setVfcn_due_dt((String) cargo
							.get("VFCN_DUE_DT"));
					custIndvElgCargo[i].setMsg_cd_txt((String) cargo
							.get("MSG_CD_TXT"));
					custIndvElgCargo[i].setFst_nam(cargo.get("FST_NAM")
							.toString().trim());
					custIndvElgCargo[i].setSex_ind((String) cargo
							.get("SEX_IND"));
					custIndvElgCargo[i].setPgm_rqst_sw((String) cargo
							.get("PGM_RQST_SW"));
					custIndvElgCargo[i].setOrg_elg_ind((String) cargo
							.get("ORIG_ELG_IND"));
					custIndvElgCargo[i].setNf_fail_rsn_1_cd((String) cargo
							.get("NF_FAIL_RSN_1_CD"));
					custIndvElgCargo[i].setPrev_sc_bnft_l_cd((String) cargo
							.get("PREV_SC_BNFT_L_CD"));
					custIndvElgCargo[i].setBrth_dt((String) cargo
							.get("BRTH_DT"));
					custIndvElgCargo[i].setEmpl_vfcn_due_dt((String) cargo
							.get("EMPL_VFCN_DUE_DT"));
					custIndvElgCargo[i].setIns_vfcn_due_dt((String) cargo
							.get("INS_VFCN_DUE_DT"));
					custIndvElgCargo[i].setSmirf_mo((String) cargo
							.get("SMIRF_MO"));
					custIndvElgCargo[i].setMid_name(cargo.get("MID_INIT")
							.toString().trim());
					custIndvElgCargo[i].setLast_name(cargo.get("LAST_NAM")
							.toString().trim());
				}
				custIndvElgColl.setResults(custIndvElgCargo);
			}

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getIVRSummaryEligibleGrouping", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getIVRSummaryEligibleGrouping() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return custIndvElgColl;
	}

	/**
	 * This method returns Indv eligibility collection.
	 *
	 * @param caseNum
	 *            case number
	 * @param caseAccessLvl
	 *            the case access lvl
	 * @param pinNum
	 *            the pin num
	 * @return the summary pend record grouping
	 */

	// this method for the pend records
	public CUST_INDV_ELG_Collection getSummaryPendRecordGrouping(
			final String caseNum, final String caseAccessLvl,
			final String pinNum) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getSummaryPendRecordGrouping() - START");
		final Map sqlMap = new HashMap();
		final CUST_INDV_ELG_Collection custIndvElgColl = new CUST_INDV_ELG_Collection();
		try {
			if (AppConstants.NOVIEW.equals(caseAccessLvl)) {
				return custIndvElgColl;
			}

			sqlMap.put(FwConstants.SQL_IND, "sql-205");
			final FwDataCriteria[] criteria = new FwDataCriteria[3];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_value(caseNum);
			criteria[0].setData_type(FwConstants.LONG);
			if (AppConstants.FULLVIEW.equals(caseAccessLvl)) {
				criteria[1] = new FwDataCriteria();
				criteria[1].setColumn_value("0");
				criteria[1].setData_type(FwConstants.LONG);
				criteria[2] = new FwDataCriteria();
				criteria[2].setColumn_value("0");
				criteria[2].setData_type(FwConstants.LONG);
			} else if (AppConstants.TARGETVIEW.equals(caseAccessLvl)) {
				criteria[1] = new FwDataCriteria();
				criteria[1].setColumn_value(pinNum);
				criteria[1].setData_type(FwConstants.LONG);
				criteria[2] = new FwDataCriteria();
				criteria[2].setColumn_value("1");
				criteria[2].setData_type(FwConstants.LONG);
			}
			sqlMap.put(FwConstants.CRITERIA, criteria);
			final List res = executeSQL(sqlMap);
			if (null != res && !res.isEmpty()) {
				final CUST_INDV_ELG_Cargo[] custIndvElgCargo = new CUST_INDV_ELG_Cargo[res
						.size()];
				for (int i = 0; i < res.size(); i++) {
					final Map cargo = (Map) res.get(i);
					custIndvElgCargo[i] = new CUST_INDV_ELG_Cargo();
					custIndvElgCargo[i].setMci_id((String) cargo.get("MCI_ID"));
					custIndvElgCargo[i].setBnft_pin_num((String) cargo
							.get("BNFT_PIN_NUM"));
					custIndvElgCargo[i].setBnft_case_num((String) cargo
							.get("BNFT_CASE_NUM"));
					custIndvElgCargo[i].setCat_cd((String) cargo.get("CAT_CD"));
					custIndvElgCargo[i].setScat_cd((String) cargo
							.get("SCAT_CD"));
					custIndvElgCargo[i].setCur_elg_ind((String) cargo
							.get("CUR_ELG_IND"));
					custIndvElgCargo[i].setElg_ind((String) cargo
							.get("ELG_IND"));
					custIndvElgCargo[i].setCnfm_dt((String) cargo
							.get("CNFM_DT"));
					custIndvElgCargo[i].setVfcn_due_dt((String) cargo
							.get("VFCN_DUE_DT"));
					custIndvElgCargo[i].setMsg_cd_txt((String) cargo
							.get("MSG_CD_TXT"));
					custIndvElgCargo[i].setFst_nam(cargo.get("FST_NAM")
							.toString().trim());
					custIndvElgCargo[i].setSex_ind((String) cargo
							.get("SEX_IND"));
					custIndvElgCargo[i].setPgm_rqst_sw((String) cargo
							.get("PGM_RQST_SW"));
					custIndvElgCargo[i].setOrg_elg_ind((String) cargo
							.get("ORIG_ELG_IND"));
					custIndvElgCargo[i].setPrev_sc_bnft_l_cd((String) cargo
							.get("PREV_SC_BNFT_L_CD"));
					custIndvElgCargo[i].setBrth_dt((String) cargo
							.get("BRTH_DT"));
					custIndvElgCargo[i].setEmpl_vfcn_due_dt((String) cargo
							.get("EMPL_VFCN_DUE_DT"));
					custIndvElgCargo[i].setIns_vfcn_due_dt((String) cargo
							.get("INS_VFCN_DUE_DT"));
					custIndvElgCargo[i].setPymt_beg_dt((String) cargo
							.get("PYMT_BEG_DT"));
					custIndvElgCargo[i].setPymt_end_dt((String) cargo
							.get("PYMT_END_DT"));
					custIndvElgCargo[i]
							.setSemi_annual_review_date((String) cargo
									.get("SEMI_ANNUAL_REVIEW_DT"));
					custIndvElgCargo[i].setReview_dt((String) cargo
							.get("REVIEW_DT"));
					custIndvElgCargo[i].setMid_cert_review_date((String) cargo
							.get("MID_CERT_REVIEW_DT"));
				}
				custIndvElgColl.setResults(custIndvElgCargo);
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getSummaryPendRecordGrouping", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getSummaryPendRecordGrouping() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return custIndvElgColl;
	}

	/**
	 * This method returns Indv eligibility collection.
	 *
	 * @param caseNum
	 *            case number
	 * @param caseAccessLvl
	 *            the case access lvl
	 * @param pinNum
	 *            the pin num
	 * @return the summary appointment record grouping
	 */

	// this method for the appointments records
	public BNFT_APPOINTMENTS_Collection getSummaryAppointmentRecordGrouping(
			final String caseNum, final String caseAccessLvl,
			final String pinNum) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"MyAccessBO.getSummaryAppointmentRecordGrouping() - START");
		final Map sqlMap = new HashMap();
		final BNFT_APPOINTMENTS_Collection custAppColl = new BNFT_APPOINTMENTS_Collection();
		try {
			/*
			 * VG SONAR Cleanup - 08/25/2015 Deleted 1 lines Commented Code in
			 * this block
			 */

			sqlMap.put(FwConstants.SQL_IND, "sql-236");
			final FwDataCriteria[] criteria = new FwDataCriteria[3];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_value(pinNum);
			criteria[0].setData_type(FwConstants.LONG);
			criteria[1] = new FwDataCriteria();
			criteria[1].setColumn_value(pinNum);
			criteria[1].setData_type(FwConstants.LONG);
			criteria[2] = new FwDataCriteria();
			criteria[2].setColumn_value(caseNum);
			criteria[2].setData_type(FwConstants.LONG);
			/*
			 * VG SONAR Cleanup - 08/25/2015 Changed Commented code block to
			 * javadoc
			 */
			/**
			 * if(caseAccessLvl.equals(AppConstants.FULLVIEW)){ criteria[1] =
			 * new FwDataCriteria(); criteria[1].setColumn_value("0");
			 * criteria[1].setData_type(FwConstants.LONG); criteria[2] = new
			 * FwDataCriteria(); criteria[2].setColumn_value("0");
			 * criteria[2].setData_type(FwConstants.LONG); } else
			 * if(caseAccessLvl.equals(AppConstants.TARGETVIEW)){ criteria[1] =
			 * new FwDataCriteria(); criteria[1].setColumn_value(pinNum);
			 * criteria[1].setData_type(FwConstants.LONG); criteria[2] = new
			 * FwDataCriteria(); criteria[2].setColumn_value("1");
			 * criteria[2].setData_type(FwConstants.LONG); }
			 */
			sqlMap.put(FwConstants.CRITERIA, criteria);
			final List res = executeSQL(sqlMap);
			if (null != res && !res.isEmpty()) {
				final BNFT_APPOINTMENTS_Cargo[] custApptCargo = new BNFT_APPOINTMENTS_Cargo[res
						.size()];
				for (int i = 0; i < res.size(); i++) {
					final Map cargo = (Map) res.get(i);
					custApptCargo[i] = new BNFT_APPOINTMENTS_Cargo();
					custApptCargo[i].setAppt_beg_datetime((String) cargo
							.get("APPT_BEG_DATETIME"));
					custApptCargo[i].setAppt_end_datetime((String) cargo
							.get("APPT_END_DATETIME"));
					custApptCargo[i].setAppt_id(Integer.parseInt((String) cargo
							.get("APPT_ID")));
					custApptCargo[i].setAppt_mode_cd((String) cargo
							.get("APPT_MODE_CD"));
					custApptCargo[i].setAppt_type_cd((String) cargo
							.get("APPT_TYPE_CD"));
					/*
					 * VG SONAR Cleanup - 08/25/2015 Changed Commented code
					 * block to javadoc
					 */
					/**
					 * custIndvElgCargo[i].setMci_id((String)
					 * cargo.get("MCI_ID"));
					 * custIndvElgCargo[i].setBnft_pin_num((String)
					 * cargo.get("BNFT_PIN_NUM"));
					 * custIndvElgCargo[i].setBnft_case_num((String)
					 * cargo.get("BNFT_CASE_NUM"));
					 * custIndvElgCargo[i].setCat_cd((String)
					 * cargo.get("CAT_CD"));
					 * custIndvElgCargo[i].setScat_cd((String)
					 * cargo.get("SCAT_CD"));
					 * custIndvElgCargo[i].setCur_elg_ind((String)
					 * cargo.get("CUR_ELG_IND"));
					 * custIndvElgCargo[i].setElg_ind((String)
					 * cargo.get("ELG_IND"));
					 * custIndvElgCargo[i].setCnfm_dt((String)
					 * cargo.get("CNFM_DT"));
					 * custIndvElgCargo[i].setVfcn_due_dt((String)
					 * cargo.get("VFCN_DUE_DT"));
					 * custIndvElgCargo[i].setMsg_cd_txt((String)
					 * cargo.get("MSG_CD_TXT"));
					 * custIndvElgCargo[i].setFst_nam(cargo
					 * .get("FST_NAM").toString().trim());
					 * custIndvElgCargo[i].setSex_ind((String)
					 * cargo.get("SEX_IND"));
					 * custIndvElgCargo[i].setPgm_rqst_sw(
					 * (String)cargo.get("PGM_RQST_SW"));
					 * custIndvElgCargo[i].setOrg_elg_ind
					 * ((String)cargo.get("ORIG_ELG_IND"));
					 * custIndvElgCargo[i].setPrev_sc_bnft_l_cd
					 * ((String)cargo.get("PREV_SC_BNFT_L_CD"));
					 * custIndvElgCargo
					 * [i].setBrth_dt((String)cargo.get("BRTH_DT"));
					 * custIndvElgCargo[i].setEmpl_vfcn_due_dt((String)
					 * cargo.get("EMPL_VFCN_DUE_DT"));
					 * custIndvElgCargo[i].setIns_vfcn_due_dt((String)
					 * cargo.get("INS_VFCN_DUE_DT"));
					 */
				}
				custAppColl.setResults(custApptCargo);
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getSummaryAppointmentRecordGrouping", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getSummaryAppointmentRecordGrouping() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return custAppColl;
	}

	/**
	 * This method returns Indv eligibility collection.
	 *
	 * @param custIndvElgColl
	 *            the cust indv elg coll
	 * @param accessLevel
	 *            the access level
	 * @param pinNum
	 *            the pin num
	 * @return true, if successful
	 */

	// this one for the given pin number it will check the access level for that
	// group
	public boolean chkSecurity(final CUST_INDV_ELG_Collection custIndvElgColl,
			final String accessLevel, final String pinNum) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.chkSecurity() - START");
		boolean toView = false;
		try {
			if (AppConstants.TARGETVIEW.equals(accessLevel)) {
				CUST_INDV_ELG_Cargo custIndvElgCargo = null;
				for (int i = 0; i < custIndvElgColl.size(); i++) {
					custIndvElgCargo = custIndvElgColl.getResult(i);
					if (custIndvElgCargo.getBnft_pin_num().trim()
							.equals(pinNum.trim())) {
						if (AppConstants.INELIGIBLE.equals(custIndvElgCargo
								.getElg_ind().trim())
								|| AppConstants.INDVINELIGIBLE
										.equals(custIndvElgCargo.getElg_ind()
												.trim())) {
							if ("Y".equals(custIndvElgCargo.getPgm_rqst_sw()
									.trim())) {
								toView = true;
							}
						} else {
							// this person is ELIGIBLE
							toView = true;
						}
					} else // if individual is Elg_ind is X and pin number is
							// not
						// same as session pin then we r removing that
						// collection
						if (AppConstants.INDVINELIGIBLE.equals(custIndvElgCargo
							.getElg_ind().trim())) {
							custIndvElgColl.remove(custIndvElgCargo);
							i--;
						}

				}
			} else if (AppConstants.FULLVIEW.equals(accessLevel)) {
				toView = true;
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"chkSecurity", e);
		}
		log(ILog.INFO, "MyAccessBO.chkSecurity() - END , Time Taken : "
				+ (System.currentTimeMillis() - startTime) + " milliseconds");
		return toView;
	}

	/**
	 * This method returns case access level.
	 *
	 * @param bnftIndvCaseColl
	 *            the bnft indv case coll
	 * @param caseNum
	 *            case number
	 * @return the case access lvl
	 */

	// this method will return the case access level for the user
	public String getCaseAccessLvl(
			final BNFT_INDV_CASE_Collection bnftIndvCaseColl,
			final String caseNum) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getCaseAccessLvl() - START");
		String caseAccessLvl = null;
		try {
			for (int i = 0; i < bnftIndvCaseColl.size(); i++) {
				if (bnftIndvCaseColl.getResult(i).getBnft_case_num()
						.equals(caseNum)) {
					caseAccessLvl = bnftIndvCaseColl.getResult(i)
							.getIndv_acs_lvl_cd();
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getCaseAccessLvl", e);
		}
		log(ILog.INFO, "MyAccessBO.getCaseAccessLvl() - END , Time Taken : "
				+ (System.currentTimeMillis() - startTime) + " milliseconds");
		return caseAccessLvl;
	}

	/**
	 * This method returns case mode.
	 *
	 * @param bnftIndvCaseColl
	 *            the bnft indv case coll
	 * @param caseNum
	 *            case number
	 * @return the case mode
	 */

	// this method will return the case Mode
	public String getCaseMode(final BNFT_INDV_CASE_Collection bnftIndvCaseColl,
			final String caseNum) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getCaseMode() - START");
		String caseMode = null;
		try {
			for (int i = 0; i < bnftIndvCaseColl.size(); i++) {
				if (bnftIndvCaseColl.getResult(i).getBnft_case_num()
						.equals(caseNum)) {
					caseMode = bnftIndvCaseColl.getResult(i).getCase_mode_cd();
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getCaseMode", e);
		}
		log(ILog.INFO, "MyAccessBO.getCaseMode() - END , Time Taken : "
				+ (System.currentTimeMillis() - startTime) + " milliseconds");
		return caseMode;
	}

	/**
	 * This method is used for getting the category desc from category cd.
	 *
	 * @param catCd
	 *            the cat cd
	 * @param subCatCd
	 *            the sub cat cd
	 * @param language
	 *            the language
	 * @return the category desc
	 */

	public String getCategoryDesc(String catCd, final String subCatCd,
			final String language) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getCategoryDesc() - START");
		String catDesc = "";
		final IReferenceTableManager iref = ReferenceTableManager.getInstance();
		try {
			catCd = catCd.trim();
			final IPage ipage = FwPageManager.createInstance();
			if (AppConstants.FOOD_SHARE.equals(catCd)) {
				catDesc = ipage.getDisplayText(20047, language);
			} else if (AppConstants.SER_ENERGY.equals(catCd)) {
				ipage.getDisplayText(99929, language);
				if (AppConstants.SER_SRV_26.equals(subCatCd)) {
					catDesc = iref.getColumnValue("TSES", 212,
							AppConstants.SER_SRV_26, language);
				} else if (AppConstants.SER_SRV_27.equals(subCatCd)) {
					catDesc = iref.getColumnValue("TSES", 212,
							AppConstants.SER_SRV_27, language);
				} else if (AppConstants.SER_SRV_33.equals(subCatCd)) {
					catDesc = iref.getColumnValue("TSES", 212,
							AppConstants.SER_SRV_33, language);
				} else if (AppConstants.SER_SRV_63.equals(subCatCd)) {
					catDesc = iref.getColumnValue("TSES", 212,
							AppConstants.SER_SRV_63, language);
				} else if (AppConstants.SER_SRV_63A.equals(subCatCd)) {
					catDesc = iref.getColumnValue("TSES", 212,
							AppConstants.SER_SRV_63A, language);
				} else if (AppConstants.SER_SRV_65.equals(subCatCd)) {
					catDesc = iref.getColumnValue("TSES", 212,
							AppConstants.SER_SRV_65, language);
				} else if (AppConstants.SER_SRV_64.equals(subCatCd)) {
					catDesc = iref.getColumnValue("TSES", 212,
							AppConstants.SER_SRV_64, language);
				} else {
					catDesc = ipage.getDisplayText(99929, language);
				}
			} else if (AppConstants.HEALTH_CARE_M01.equals(catCd)) {
				catDesc = ipage.getDisplayText(20048, language);
			} else if (AppConstants.HEALTH_CARE_M02.equals(catCd)
					&& (subCatCd != null)
					&& (subCatCd.startsWith(AppConstants.BADGERCARE_PLUS) || subCatCd
							.startsWith("MA"))) {
				catDesc = ipage.getDisplayText(20049, language);
			} else if (AppConstants.HEALTH_CARE_M02.equals(catCd)) {
				catDesc = ipage.getDisplayText(20044, language);
			} else if (AppConstants.HEALTH_CARE_M03.equals(catCd)
					&& (subCatCd != null)
					&& !subCatCd.startsWith(AppConstants.BADGERCARE_PLUS)) {
				catDesc = ipage.getDisplayText(20199, language);
			} else if (AppConstants.HEALTH_CARE_M03.equals(catCd)) {
				catDesc = ipage.getDisplayText(20050, language);
			} else if (AppConstants.HEALTH_CARE_M04.equals(catCd)) {
				catDesc = ipage.getDisplayText(20051, language);
			} else if (AppConstants.HEALTH_CARE_M05.equals(catCd)) {
				catDesc = ipage.getDisplayText(20052, language);
			} else if (AppConstants.HEALTH_CARE_M06.equals(catCd)) {
				catDesc = ipage.getDisplayText(20053, language);
			} else if (AppConstants.HEALTH_CARE_M07.equals(catCd)) {
				catDesc = ipage.getDisplayText(20054, language);
			} else if (AppConstants.HEALTH_CARE_M08.equals(catCd)) {
				catDesc = ipage.getDisplayText(20055, language);
			} else if (AppConstants.HEALTH_CARE_M09.equals(catCd)) {
				catDesc = ipage.getDisplayText(20056, language);
			} else if (AppConstants.HEALTH_CARE_M10.equals(catCd)) {
				catDesc = ipage.getDisplayText(20057, language);
			} else if (AppConstants.HEALTH_CARE_M11.equals(catCd)) {
				catDesc = ipage.getDisplayText(20058, language);
			} else if (AppConstants.HEALTH_CARE_M12.equals(catCd)) {
				catDesc = ipage.getDisplayText(20059, language);
			} else if (AppConstants.HEALTH_CARE_M13.equals(catCd)) {
				catDesc = ipage.getDisplayText(20202, language);
			} else if (AppConstants.HEALTH_CARE_M14.equals(catCd)) {
				catDesc = ipage.getDisplayText(20227, language);
			} else if (AppConstants.HEALTH_CARE_M15.equals(catCd)) {
				catDesc = ipage.getDisplayText(20243, language);
			} else if (AppConstants.HEALTH_CARE_M16.equals(catCd)) {
				catDesc = ipage.getDisplayText(20244, language);
			} else if (AppConstants.HEALTH_CARE_M17.equals(catCd)) {
				catDesc = ipage.getDisplayText(20245, language);
			} else if (AppConstants.HEALTH_CARE_M18.equals(catCd)) {
				catDesc = ipage.getDisplayText(20246, language);
			} else if (AppConstants.HEALTH_CARE_M19.equals(catCd)) {
				catDesc = ipage.getDisplayText(20247, language);
			} else if (AppConstants.HEALTH_CARE_M20.equals(catCd)) {
				catDesc = ipage.getDisplayText(20248, language);
			} else if (AppConstants.HEALTH_CARE_M21.equals(catCd)) {
				catDesc = ipage.getDisplayText(20249, language);
			} else if (AppConstants.HEALTH_CARE_M22.equals(catCd)) {
				catDesc = ipage.getDisplayText(20250, language);
			} else if (AppConstants.HEALTH_CARE_M23.equals(catCd)) {
				catDesc = ipage.getDisplayText(20254, language);
			} else if (AppConstants.HEALTH_CARE_M24.equals(catCd)) {
				catDesc = ipage.getDisplayText(20255, language);
			} else if (AppConstants.HEALTH_CARE_M25.equals(catCd)) {
				catDesc = ipage.getDisplayText(20270, language);
			} else if (AppConstants.CARETAKER_SUPPLEMENT.equals(catCd)) {
				catDesc = ipage.getDisplayText(20060, language);
			} else if (AppConstants.SENIOR_CARE.equals(catCd)) {
				catDesc = ipage.getDisplayText(20061, language);
			} else if (AppConstants.SER_SRV_33.equals(catCd)) {
				catDesc = ipage.getDisplayText(99908, language);
			} else if (AppConstants.SER_SRV_63.equals(catCd)) {
				catDesc = ipage.getDisplayText(99909, language);
			} else if (AppConstants.SER_SRV_63A.equals(catCd)) {
				catDesc = ipage.getDisplayText(99910, language);
			} else if (AppConstants.SER_SRV_64.equals(catCd)) {
				catDesc = ipage.getDisplayText(99911, language);
			} else if (AppConstants.SER_SRV_65.equals(catCd)) {
				catDesc = ipage.getDisplayText(99912, language);
			} else if (AppConstants.SER_SRV_26.equals(catCd)) {
				catDesc = ipage.getDisplayText(99913, language);
			} else if (AppConstants.SER_SRV_27.equals(catCd)) {
				catDesc = ipage.getDisplayText(99914, language);
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getCategoryDesc", e);
		}
		log(ILog.INFO, "MyAccessBO.getCategoryDesc() - END , Time Taken : "
				+ (System.currentTimeMillis() - startTime) + " milliseconds");
		return catDesc;
	}

	/**
	 * This method returns split message.
	 *
	 * @param message
	 *            the message
	 * @param curEligInd
	 *            the cur elig ind
	 * @return the string[]
	 */

	public String[] splitMessage(final String message, final String curEligInd) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.splitMessage() - START");
		/*
		 * VG SONAR Cleanup - 08/25/2015 Deleted 1 lines Commented Code in this
		 * block
		 */

		String[] result = null;
		try {
			if (message != null) {
				result = message.split(",");

			}
			/*
			 * VG SONAR Cleanup - 08/25/2015 Changed Commented code block to
			 * javadoc
			 */
			/**
			 * if(msgLen > 0){ int i = -1; int j = -1;
			 * if(curEligInd.equals(AppConstants.ELIGIBILITY_UN_CONFIRM)){
			 * result = new String[msgLen/10]; i = 10; j = 0; while(msgLen >=
			 * i){ fullMessage = message.substring(i-10,i); result[j] =
			 * fullMessage.substring(0,10); i = i+10; j = j+1; } }else
			 * if(curEligInd.equals(AppConstants.ELIGIBILITY_CONFIRM) ||
			 * curEligInd.equals(AppConstants.ELIGIBILITY_HISTORY)){ result =
			 * new String[msgLen/5]; i = 5; j = 0; while(msgLen >= i){
			 * fullMessage = message.substring(i-5,i); result[j] =
			 * fullMessage.substring(0,5); i = i+5; j = j+1; } } }
			 */
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"splitMessage", e);
		}
		log(ILog.INFO, "MyAccessBO.splitMessage() - END , Time Taken : "
				+ (System.currentTimeMillis() - startTime) + " milliseconds");
		return result;
	}

	/**
	 * This method returns case details.
	 *
	 * @param caseNum
	 *            case number
	 * @return the case details
	 */

	public String getCaseDetails(final String caseNum) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getCaseDetails() - START");
		final Map map = new HashMap();
		StringBuilder nameBuffer = null;
		try {
			map.put(FwConstants.SQL_IND, "sql-206");
			final FwDataCriteria[] criteria = new FwDataCriteria[1];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_name("B.BNFT_CASE_NUM");
			criteria[0].setColumn_value(caseNum);
			criteria[0].setData_type(FwConstants.LONG);
			map.put(FwConstants.CRITERIA, criteria);
			final List res = executeSQL(map);
			nameBuffer = new StringBuilder();

			final int resSize = res.size();
			for (int i = 0; i < resSize; i++) {
				nameBuffer = new StringBuilder();
				final Map resMap = (Map) res.get(i);
				/*
				 * VG SONAR Cleanup - 08/25/2015 Deleted 1 lines Commented Code
				 * in this block
				 */

				nameBuffer.append(resMap.get("FST_NAM").toString().trim())
						.append(" ");
				nameBuffer.append(resMap.get("MID_INIT").toString().trim())
						.append(" ");
				nameBuffer.append(resMap.get("LAST_NAM").toString().trim());
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getCaseDetails", e);
		}
		log(ILog.INFO, "MyAccessBO.getCaseDetails() - END , Time Taken : "
				+ (System.currentTimeMillis() - startTime) + " milliseconds");
		return nameBuffer.toString();
	}

	/**
	 * This method returns check benefit status is open or not.
	 *
	 * @param pinNum
	 *            the pin num
	 * @param catCd
	 *            the cat cd
	 * @param sCatSeq
	 *            the s cat seq
	 * @return the date
	 */

	public Date chkBenefitStatusIsOpen(final String pinNum, final String catCd,
			final int sCatSeq) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.chkBenefitStatusIsOpen() - START");
		final Map map = new HashMap();
		Date elgEndDt = null;
		try {
			map.put(FwConstants.SQL_IND, "sql-223");
			final FwDataCriteria[] criteria = new FwDataCriteria[3];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_value(pinNum);
			criteria[0].setData_type(FwConstants.LONG);

			criteria[1] = new FwDataCriteria();
			criteria[1].setColumn_value(catCd);
			criteria[1].setData_type(FwConstants.STRING);

			criteria[2] = new FwDataCriteria();
			criteria[2].setColumn_value(String.valueOf(sCatSeq));
			criteria[2].setData_type(FwConstants.INT);

			map.put(FwConstants.CRITERIA, criteria);
			final List res = executeSQL(map);
			if (null != res && !res.isEmpty()) {
				final Map resMap = (Map) res.get(0);
				if (resMap.get("BNFT_STAT_CD") != null) {
					if (AppConstants.HEALTH_CARE_M03.equals(catCd.trim())
							|| AppConstants.HEALTH_CARE_M06
									.equals(catCd.trim())) {
						if ("M".equals(resMap.get("BNFT_STAT_CD").toString()
								.trim())
								&& (resMap.get("REVIEW_DT") != null)) {
							elgEndDt = dateRoutine.getDateFromTimeStamp(resMap
									.get("REVIEW_DT").toString());
						}
					} else if ("AP".equals(resMap.get("BNFT_STAT_CD")
							.toString().trim())
							&& (resMap.get("REVIEW_DT") != null)) {
						elgEndDt = dateRoutine.getDateFromTimeStamp(resMap.get(
								"REVIEW_DT").toString());
					}
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getBenefitStatusIsOpen", e);
		}
		log(ILog.INFO,
				"MyAccessBO.chkBenefitStatusIsOpen() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return elgEndDt;
	}

	/**
	 * This method returns check benefit status is open or not.
	 *
	 * @param pinNum
	 *            the pin num
	 * @param catCd
	 *            the cat cd
	 * @param sCatSeq
	 *            the s cat seq
	 * @return the string
	 */

	public String chkBenefitStatusIsOpenForMidCertReview(final String pinNum,
			final String catCd, final int sCatSeq) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"MyAccessBO.chkBenefitStatusIsOpenForMidCertReview() - START");
		final Map map = new HashMap();
		String midCertificationReviewDate = null;
		try {
			map.put(FwConstants.SQL_IND, "sql-223");
			final FwDataCriteria[] criteria = new FwDataCriteria[3];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_value(pinNum);
			criteria[0].setData_type(FwConstants.LONG);

			criteria[1] = new FwDataCriteria();
			criteria[1].setColumn_value(catCd);
			criteria[1].setData_type(FwConstants.STRING);

			criteria[2] = new FwDataCriteria();
			criteria[2].setColumn_value(String.valueOf(sCatSeq));
			criteria[2].setData_type(FwConstants.INT);

			map.put(FwConstants.CRITERIA, criteria);
			final List res = executeSQL(map);
			if (null != res && !res.isEmpty()) {
				final Map resMap = (Map) res.get(0);
				if (resMap.get("BNFT_STAT_CD") != null) {
					if (AppConstants.HEALTH_CARE_M03.equals(catCd.trim())
							|| AppConstants.HEALTH_CARE_M06
									.equals(catCd.trim())) {
						if ("M".equals(resMap.get("BNFT_STAT_CD").toString()
								.trim())
								&& (resMap.get("MID_CERT_REVIEW_DT") != null)) {
							midCertificationReviewDate = resMap
									.get("REVIEW_DT").toString();
						}
					} else if ("AP".equals(resMap.get("BNFT_STAT_CD")
							.toString().trim())
							&& (resMap.get("MID_CERT_REVIEW_DT") != null)) {
						midCertificationReviewDate = resMap.get(
								"MID_CERT_REVIEW_DT").toString();
					}
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getBenefitStatusIsOpen", e);
		}
		log(ILog.INFO,
				"MyAccessBO.chkBenefitStatusIsOpenForMidCertReview() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return midCertificationReviewDate;
	}

	/**
	 * Method for determinig the Message substitutes.
	 *
	 * @param message
	 *            the message
	 * @param language
	 *            the language
	 * @param verCode
	 *            the ver code
	 * @param pageId
	 *            the page id
	 * @return the string[]
	 */

	public String[] determineMessageSubstitutes(final String message,
			final String language, final String verCode, final String pageId) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.determineMessageSubstitutes() - START");
		final int msgLen = message.length();
		final String[] result = null;
		try {
			if (msgLen > 0) {

				/**
				 * if(result.length>0){ //Code changes for verification if
				 * (message != null && message.length() >0 &&
				 * message.startsWith("24")){ result[i] =
				 * AppConstants.VFCN_DUE_DT; }
				 *
				 *
				 * if (message.startsWith("24")){ if(refTildaCount == 1 &&
				 * messageTildaCount == 0){ result[i] = AppConstants.FST_NAM; }
				 * else if(refTildaCount == 0 && messageTildaCount == 1){
				 * if(message.equals("24092") ||message.equals("24097")
				 * ||message.equals("24098") ||message.equals("24099")||
				 * message.equals("24105") ||message.equals("24106")
				 * ||message.equals("24571") ||message.equals("24572") ||
				 * message.equals("24573") ||message.equals("24575")
				 * ||message.equals("24586") ||message.equals("24588")){
				 * result[i] = AppConstants.EMPL_VFCN_DUE_DT; } else if
				 * (message.equals("24587") || message.equals("24589") ||
				 * message.equals("24597") ||message.equals("24600")){ result[i]
				 * = AppConstants.INS_VFCN_DUE_DT; } else{ result[i] =
				 * AppConstants.VFCN_DUE_DT; } } else if (refTildaCount == 0 &&
				 * messageTildaCount == 2 ){ result[i] = AppConstants.FST_NAM;
				 * if(message.equals("24092") ||message.equals("24097")
				 * ||message.equals("24098") ||message.equals("24099")||
				 * message.equals("24105") ||message.equals("24106")
				 * ||message.equals("24571") ||message.equals("24572") ||
				 * message.equals("24573") ||message.equals("24575")
				 * ||message.equals("24586") ||message.equals("24588")){
				 * result[++i] = AppConstants.EMPL_VFCN_DUE_DT; } else if
				 * (message.equals("24587") || message.equals("24589") ||
				 * message.equals("24597") ||message.equals("24600")){
				 * result[++i] = AppConstants.INS_VFCN_DUE_DT; } else{
				 * result[++i] = AppConstants.VFCN_DUE_DT; } } else if
				 * (refTildaCount == 1 && messageTildaCount == 1){ result[i] =
				 * AppConstants.FST_NAM; if(message.equals("24092")
				 * ||message.equals("24097") ||message.equals("24098")
				 * ||message.equals("24099")|| message.equals("24105")
				 * ||message.equals("24106") ||message.equals("24571")
				 * ||message.equals("24572") || message.equals("24573")
				 * ||message.equals("24575") ||message.equals("24586")
				 * ||message.equals("24588")){ result[++i] =
				 * AppConstants.EMPL_VFCN_DUE_DT; } else if
				 * (message.equals("24587") ||message.equals("24589") ||
				 * message.equals("24597") ||message.equals("24600")){
				 * result[++i] = AppConstants.INS_VFCN_DUE_DT; } else{
				 * result[++i] = AppConstants.VFCN_DUE_DT; } } else if
				 * (refTildaCount == 1 && messageTildaCount == 2){ result[i] =
				 * AppConstants.FST_NAM; result[++i] = AppConstants.FST_NAM;
				 * if(message.equals("24092") ||message.equals("24097")
				 * ||message.equals("24098") ||message.equals("24099")||
				 * message.equals("24105") ||message.equals("24106")
				 * ||message.equals("24571") ||message.equals("24572") ||
				 * message.equals("24573") ||message.equals("24575")
				 * ||message.equals("24586") ||message.equals("24588")){
				 * result[++i] = AppConstants.EMPL_VFCN_DUE_DT; } else if
				 * (message.equals("24587") ||message.equals("24589") ||
				 * message.equals("24597") ||message.equals("24600")){
				 * result[++i] = AppConstants.INS_VFCN_DUE_DT; } else{
				 * result[++i] = AppConstants.VFCN_DUE_DT; } } }
				 * if(message.equals
				 * ("23028")||message.equals("23046")||message.equals
				 * ("23141")||message
				 * .equals("23281")||message.equals("23368")||message
				 * .equals("23537")){ String[] sub1 = new String[2]; sub1[0]=
				 * pageId; if(message.equals("23281")){ sub1[1]=
				 * AppConstants.COMMON_QUESTIONS_FMA_LINK_HEADER; } else{
				 * sub1[1]= AppConstants.GENERAL_QUESTIONS_LINK_HEADER; }
				 * result[i] =
				 * FwMessageFormatter.getFormattedMessage(FwMessageFormatter
				 * .getCachedText(20166,language),sub1); }
				 * if(message.equals("23038") ||
				 * message.equals("23116")||message.equals("23143")){ String[]
				 * sub1 = new String[2]; sub1[0]= pageId; sub1[1]=
				 * AppConstants.GENERAL_QUESTIONS_LINK_HEADER; result[i] =
				 * FwMessageFormatter
				 * .getFormattedMessage(FwMessageFormatter.getCachedText
				 * (20177,language),sub1); }
				 *
				 * if(message.equals("22073") || message.equals("22074") ||
				 * message.equals("22075") || message.equals("22076") ){
				 * result[i] = AppConstants.FST_NAM; }
				 *
				 * }
				 */
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"determineMessageSubstitutes", e);
		}
		log(ILog.INFO,
				"MyAccessBO.determineMessageSubstitutes() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return result;
	}

	/**
	 * Number of '~' count in a message.
	 *
	 * @param message
	 *            the message
	 * @param languageIndicator
	 *            the language_indicator
	 * @return the replace count
	 */

	public int getReplaceCount(final String message,
			final String languageIndicator) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getReplaceCount() - START");
		int count = 0;
		int messageLen = 0;
		try {
			if (message != null) {
				messageLen = message.length();
			}
			if (messageLen > 0) {
				// Getting the message for the given code
				final IPage ipage = FwPageManager.createInstance();
				final String dplyTxt = ipage.getDisplayText(
						Integer.parseInt(message), languageIndicator);
				messageLen = dplyTxt.length();
				for (int i = 0; i < messageLen; i++) {
					final String aa = dplyTxt.substring(i, i + 1);
					// As the string comparision is expensive doing character
					// comparision
					if (aa.charAt(0) == '~') {
						count++;
					}
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getReplaceCount", e);
		}
		log(ILog.INFO, "MyAccessBO.getReplaceCount() - END , Time Taken : "
				+ (System.currentTimeMillis() - startTime) + " milliseconds");
		return count;
	}

	/**
	 * This method gets the refernce table info for the given message.
	 *
	 * @param appType
	 *            the app type
	 * @param appMode
	 *            the app mode
	 * @param language
	 *            the language
	 * @return the ref value appointment
	 */
	/**
	 * This method gets the refernce table info for the given message for
	 * Appointments.
	 *
	 * @param appType
	 * @param appMode
	 * @param language
	 * @return
	 */

	public String[] getRefValueAppointment(final String appType,
			final String appMode, final String language) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getRefValueAppointment() - START");
		final String[] sub = new String[2];
		try {
			final String language1 = language.toUpperCase();
			final IReferenceTableManager iref = ReferenceTableManager
					.getInstance();

			if ((appType != null) && (appType.length() > 0)) {
				sub[0] = iref.getColumnValue("TAPP", 166, appType, language1);
			}

			if ((appMode != null) && (appMode.length() > 0)) {
				sub[1] = iref.getColumnValue("TAPM", 167, appMode, language1);

			}

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getRefValueAppointment", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getRefValueAppointment() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return sub;
	}

	/**
	 * This method can be called for SQL_G1, SQL_G2 data along with data
	 * obtained from SQL_C
	 *
	 * If message type is not AppConstants.MESSAGE_PEND_REVIEW Then this method
	 * will return an empty msgArray (Zero/0 size.)
	 *
	 * @param msgArrayList
	 *            the msg array list
	 * @param indvElgCargo
	 *            the indv elg cargo
	 * @param pendIndvElgCollection
	 *            the pend indv elg collection
	 * @param caseMode
	 *            the case mode
	 * @param language
	 *            the language
	 * @param pageMode
	 *            the page mode
	 * @param reviewDate
	 *            the review date
	 * @return the list
	 */

	public List generatePendingReviewMessages(final List msgArrayList,
			final CUST_INDV_ELG_Cargo indvElgCargo,
			final CUST_INDV_ELG_Collection pendIndvElgCollection,
			final String caseMode, final String language,
			final String pageMode, final Date reviewDate) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.generatePendingReviewMessages() - START");
		try {

			if (AppConstants.HISTORY_MODE.equals(pageMode)
					&& ((reviewDate == null) || (dateRoutine.getTotalDays(
							fwDate.getDate(), reviewDate) > 45))) {
				return msgArrayList;
			}

			if ((indvElgCargo != null)
					&& (AppConstants.MESSAGE_BEN_OPEN.equals(indvElgCargo
							.getBnft_stat_cd()) || AppConstants.MESSAGE_MED_BEN_OPEN
							.equals(indvElgCargo.getBnft_stat_cd()))
					&& (indvElgCargo.getReview_dt() != null)
					&& dateRoutine.getDateFromTimeStamp(
							indvElgCargo.getReview_dt())
							.after(fwDate.getDate())
					&& (dateRoutine.getTotalDays(fwDate.getDate(), dateRoutine
							.getDateFromTimeStamp(indvElgCargo.getReview_dt())) <= 45)) {
				// if case mode is in review mode
				if (!AppConstants.CASE_MODE_REVIEW.equals(caseMode)) {
					final AccessMessage message = new AccessMessage();
					message.setMsgCode("22000");
					final String[] sub = new String[] { displayFormatter
							.getExpandedMonthYear(dateRoutine
									.getDateFromTimeStamp(indvElgCargo
											.getReview_dt()), language) };
					message.setMsgSubstitution(sub);
					msgArrayList.add(message);
				} else // case is in review mode
				// Check if a pend record exists.
				if (null != pendIndvElgCollection && !pendIndvElgCollection.isEmpty()) {
					final AccessMessage message = new AccessMessage();
					message.setMsgCode("22001");
					msgArrayList.add(message);
				} else {
					final AccessMessage message = new AccessMessage();
					message.setMsgCode("22002");
					final String[] sub = new String[] { displayFormatter
							.getExpandedMonthYear(
								fwDate.getDate(indvElgCargo.getReview_dt()),
									language) };
					message.setMsgSubstitution(sub);
					msgArrayList.add(message);
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"generatePendingReviewMessages", e);
		}
		// Finally return Array List.
		log(ILog.INFO,
				"MyAccessBO.generatePendingReviewMessages() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return msgArrayList;
	}

	/**
	 * This method for the generate found messages.
	 *
	 * @param msgArrayList
	 *            the msg array list
	 * @param pendIndvElgCollection
	 *            the pend indv elg collection
	 * @param language
	 *            the language
	 * @param pageId
	 *            the page id
	 * @return the list
	 */

	public List generatePendingFoundMessages(final List msgArrayList,
			final CUST_INDV_ELG_Collection pendIndvElgCollection,
			final String language, final String pageId) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.generatePendingFoundMessages() - START");
		try {
			// This method is used for the pend messages MSG_CD_TXT(SQL-C)
			final int size = pendIndvElgCollection.size();
			for (int i = 0; i < size; i++) {
				generateFoundMessages(msgArrayList,
						pendIndvElgCollection.getResult(i), language, pageId);
			}

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"generatePendingFoundMessages", e);
		}
		// Finally return Array List.
		log(ILog.INFO,
				"MyAccessBO.generatePendingFoundMessages() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return msgArrayList;
	}

	/**
	 * This method returns found messages.
	 *
	 * @param msgArrayList
	 *            the msg array list
	 * @param indvElgCargo
	 *            the indv elg cargo
	 * @param language
	 *            the language
	 * @param pageId
	 *            the page id
	 */

	public void generateFoundMessages(final List msgArrayList,
			final CUST_INDV_ELG_Cargo indvElgCargo, final String language,
			final String pageId) {
		// This method is currently empty
	}

	/**
	 * This method returns group failure messages.
	 *
	 * @param msgArrayList
	 *            the msg array list
	 * @param indvElgCargo
	 *            the indv elg cargo
	 * @param language
	 *            the language
	 * @param pageId
	 *            the page id
	 * @param aDsplyRsnCodesList
	 *            the a dsply rsn codes list
	 */

	public void generateGroupFailureMessages(final List msgArrayList,
			final CUST_INDV_ELG_Cargo indvElgCargo, final String language,
			final String pageId, final List aDsplyRsnCodesList) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.generateGroupFailureMessages() - START");
		try {
			// Loop through the collection

			String rnsCode = processReasonCodeSuppression(
					indvElgCargo.getAg_stat_rsn_1_cd(), aDsplyRsnCodesList,
					pageId, indvElgCargo);
			indvElgCargo.setAg_stat_rsn_1_cd(rnsCode);
			final String agStatRsn1Cd = indvElgCargo.getAg_stat_rsn_1_cd();
			String description = null;
			final IPage ipage = FwPageManager.createInstance();

			rnsCode = processReasonCodeSuppression(
					indvElgCargo.getAg_stat_rsn_2_cd(), aDsplyRsnCodesList,
					pageId, indvElgCargo);
			indvElgCargo.setAg_stat_rsn_2_cd(rnsCode);
			final String agStatRsn2Cd = indvElgCargo.getAg_stat_rsn_2_cd();

			rnsCode = processReasonCodeSuppression(
					indvElgCargo.getAg_stat_rsn_3_cd(), aDsplyRsnCodesList,
					pageId, indvElgCargo);
			indvElgCargo.setAg_stat_rsn_3_cd(rnsCode);
			final String agStatRsn3Cd = indvElgCargo.getAg_stat_rsn_3_cd();
			if ((agStatRsn1Cd != null)
					&& !"".equals(agStatRsn1Cd.trim())
					&& (!"014".equals(agStatRsn1Cd.trim())
							|| "O".equals(indvElgCargo.getBnft_stat_cd().trim()) || (!"M03"
							.equals(indvElgCargo.getCat_cd().trim()) && !"M06"
							.equals(indvElgCargo.getCat_cd().trim())))
					&& (!"525".equals(agStatRsn1Cd.trim())
							|| "O".equals(indvElgCargo.getBnft_stat_cd().trim()) || !"M12"
								.equals(indvElgCargo.getCat_cd().trim()))) {
				final String[] msgTxtSubArray = determineMessageSubstitutes(
						indvElgCargo.getAg_stat_rsn_1_cd(), language,
						AppConstants.REASON_CODE, pageId);
				final AccessMessage message = new AccessMessage();
				message.setMsgCode(getTextIdForMsgCode(agStatRsn1Cd,
						AppConstants.VERIFICATION_FAILURE_RSN));
				message.setMsgSubstitution(msgTxtSubArray);
				description = ipage.getDisplayText(
						Integer.parseInt(message.getMsgCode()), "EN");
				if (!"suppress".equals(description)) {
					msgArrayList.add(message);
					aDsplyRsnCodesList.add(message.getMsgCode());
				}
			}
			if ((agStatRsn2Cd != null)
					&& !"".equals(agStatRsn2Cd.trim())
					&& (!"014".equals(agStatRsn2Cd.trim())
							|| "O".equals(indvElgCargo.getBnft_stat_cd().trim()) || (!"M03"
							.equals(indvElgCargo.getCat_cd().trim()) && !"M06"
							.equals(indvElgCargo.getCat_cd().trim())))
					&& (!"525".equals(agStatRsn2Cd.trim())
							|| "O".equals(indvElgCargo.getBnft_stat_cd().trim()) || !"M12"
								.equals(indvElgCargo.getCat_cd().trim()))) {
				final String[] msgTxtSubArray = determineMessageSubstitutes(
						indvElgCargo.getAg_stat_rsn_2_cd(), language,
						AppConstants.REASON_CODE, pageId);
				final AccessMessage message = new AccessMessage();
				message.setMsgCode(getTextIdForMsgCode(agStatRsn2Cd,
						AppConstants.VERIFICATION_FAILURE_RSN));
				message.setMsgSubstitution(msgTxtSubArray);

				description = ipage.getDisplayText(
						Integer.parseInt(message.getMsgCode()), "EN");
				if (!"suppress".equals(description)) {
					msgArrayList.add(message);
					aDsplyRsnCodesList.add(message.getMsgCode());
				}
			}
			if ((agStatRsn3Cd != null)
					&& !"".equals(agStatRsn3Cd.trim())
					&& (!"014".equals(agStatRsn3Cd.trim())
							|| "O".equals(indvElgCargo.getBnft_stat_cd().trim()) || (!"M03"
							.equals(indvElgCargo.getCat_cd().trim()) && !"M06"
							.equals(indvElgCargo.getCat_cd().trim())))
					&& (!"525".equals(agStatRsn3Cd.trim())
							|| "O".equals(indvElgCargo.getBnft_stat_cd().trim()) || !"M12"
								.equals(indvElgCargo.getCat_cd().trim()))) {
				final String[] msgTxtSubArray = determineMessageSubstitutes(
						indvElgCargo.getAg_stat_rsn_3_cd(), language,
						AppConstants.REASON_CODE, pageId);
				final AccessMessage message = new AccessMessage();
				message.setMsgCode(getTextIdForMsgCode(agStatRsn3Cd,
						AppConstants.VERIFICATION_FAILURE_RSN));
				message.setMsgSubstitution(msgTxtSubArray);

				description = ipage.getDisplayText(
						Integer.parseInt(message.getMsgCode()), "EN");
				if (!"suppress".equals(description)) {
					msgArrayList.add(message);
					aDsplyRsnCodesList.add(message.getMsgCode());
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"generateGroupFailureMessages", e);
		}
		log(ILog.INFO,
				"MyAccessBO.generateGroupFailureMessages() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * This method returns indv failure messages.
	 *
	 * @param msgArrayList
	 *            the msg array list
	 * @param indvElgCargo
	 *            the indv elg cargo
	 * @param language
	 *            the language
	 * @param pageId
	 *            the page id
	 * @param aDsplyRsnCodesList
	 *            the a dsply rsn codes list
	 */

	public void generateIndvFailureMessages(final List msgArrayList,
			final CUST_INDV_ELG_Cargo indvElgCargo, final String language,
			final String pageId, final List aDsplyRsnCodesList) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.generateIndvFailureMessages() - START");
		try {
			final IPage ipage = FwPageManager.createInstance();
			String description = null;
			String rnsCode = processReasonCodeSuppression(
					indvElgCargo.getNf_fail_rsn_1_cd(), aDsplyRsnCodesList,
					pageId, indvElgCargo);
			indvElgCargo.setNf_fail_rsn_1_cd(rnsCode);
			final String nfFailRsn1Cd = indvElgCargo.getNf_fail_rsn_1_cd();

			rnsCode = processReasonCodeSuppression(
					indvElgCargo.getNf_fail_rsn_2_cd(), aDsplyRsnCodesList,
					pageId, indvElgCargo);
			indvElgCargo.setNf_fail_rsn_2_cd(rnsCode);
			final String nfFailRsn2Cd = indvElgCargo.getNf_fail_rsn_2_cd();

			rnsCode = processReasonCodeSuppression(
					indvElgCargo.getNf_fail_rsn_3_cd(), aDsplyRsnCodesList,
					pageId, indvElgCargo);
			indvElgCargo.setNf_fail_rsn_3_cd(rnsCode);
			final String nfFailRsn3Cd = indvElgCargo.getNf_fail_rsn_3_cd();

			// Reason codes from reference table
			if ((nfFailRsn1Cd != null) && !"".equals(nfFailRsn1Cd.trim())) {
				final String[] msgTxtSubArray = determineMessageSubstitutes(
						indvElgCargo.getNf_fail_rsn_1_cd(), language,
						AppConstants.REASON_CODE, pageId);
				final AccessMessage message = new AccessMessage();
				message.setMsgCode(getTextIdForMsgCode(nfFailRsn1Cd,
						AppConstants.VERIFICATION_FAILURE_RSN));
				message.setMsgSubstitution(msgTxtSubArray);

				description = ipage.getDisplayText(
						Integer.parseInt(message.getMsgCode()), "EN");

				if (!"suppress".equals(description)) {
					msgArrayList.add(message);
					aDsplyRsnCodesList.add(indvElgCargo.getNf_fail_rsn_1_cd());
				}
			}
			if ((nfFailRsn2Cd != null) && !"".equals(nfFailRsn2Cd.trim())) {
				final String[] msgTxtSubArray = determineMessageSubstitutes(
						indvElgCargo.getNf_fail_rsn_2_cd(), language,
						AppConstants.REASON_CODE, pageId);
				final AccessMessage message = new AccessMessage();
				message.setMsgCode(getTextIdForMsgCode(nfFailRsn2Cd,
						AppConstants.VERIFICATION_FAILURE_RSN));
				message.setMsgSubstitution(msgTxtSubArray);
				description = ipage.getDisplayText(
						Integer.parseInt(message.getMsgCode()), "EN");

				if (!"suppress".equals(description)) {
					msgArrayList.add(message);
					aDsplyRsnCodesList.add(indvElgCargo.getNf_fail_rsn_2_cd());
				}
			}
			if ((nfFailRsn3Cd != null) && !"".equals(nfFailRsn3Cd.trim())) {
				final String[] msgTxtSubArray = determineMessageSubstitutes(
						indvElgCargo.getNf_fail_rsn_3_cd(), language,
						AppConstants.REASON_CODE, pageId);
				final AccessMessage message = new AccessMessage();
				message.setMsgCode(getTextIdForMsgCode(nfFailRsn3Cd,
						AppConstants.VERIFICATION_FAILURE_RSN));
				message.setMsgSubstitution(msgTxtSubArray);
				description = ipage.getDisplayText(
						Integer.parseInt(message.getMsgCode()), "EN");

				if (!"suppress".equals(description)) {
					msgArrayList.add(message);
					aDsplyRsnCodesList.add(message);
				}
			}

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"generateIndvFailureMessages", e);
		}
		log(ILog.INFO,
				"MyAccessBO.generateIndvFailureMessages() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
	}

	/**
	 * This method returns true or false if the reason code exists in Reference
	 * table and if it is displayed or not once.
	 *
	 * @param aCurrentRsnCd
	 *            the a current rsn cd
	 * @param aDsplyRsnCodesList
	 *            the a dsply rsn codes list
	 * @param aPageId
	 *            the a page id
	 * @param aAIndvElgCustCargo
	 *            the a a indv elg cust cargo
	 * @return the string
	 */

	private String processReasonCodeSuppression(String aCurrentRsnCd,
			final List aDsplyRsnCodesList, final String aPageId,
			final CUST_INDV_ELG_Cargo aAIndvElgCustCargo) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.processReasonCodeSuppression() - START");
		try {
			// Current reason code
			String rsnCode = aCurrentRsnCd;
			final IPage ipage = FwPageManager.createInstance();
			// Reason codes from reference table read
			final Map reasonCodesMap = (Map) ipage.getAllData().get(
					FwConstants.SUPPRESS_REASON_CODES);
			if ((aCurrentRsnCd != null) && (aCurrentRsnCd.trim().length() > 0)) {
				aCurrentRsnCd = aCurrentRsnCd.trim();
				if (reasonCodesMap.containsKey(aCurrentRsnCd)) {
					final Map aTempMap = (Map) reasonCodesMap
							.get(aCurrentRsnCd);
					final String action = aTempMap.get("ACTION").toString();
					final String category = aTempMap.get("CATEGORY").toString()
							.trim();
					/*
					 * ALL --> we should apply any suppression rule Apply
					 * suppression rule only if a) category is 'FS' and the page
					 * ids is 'AMFSD (Foodshare details page)' b) category is
					 * 'CTS' and the page ids is 'AMCSD (Caretaker Suppliment
					 * details page)' c) category starts with 'M00 (i.e M01 to
					 * M12)' and the page ids is 'AMHCD (Health Care details
					 * page)' d) category is 'SC' and the page ids is 'AMSCD
					 * (Senior Care details page)'
					 */
					if ("ALL".equals(category)
							|| (AppConstants.FS_PAGE_ID.equals(aPageId)
									&& aAIndvElgCustCargo
											.getCat_cd()
											.startsWith(AppConstants.FOOD_SHARE) && AppConstants.FOOD_SHARE
										.equals(category))
							|| (AppConstants.HC_PAGE_ID.equals(aPageId)
									&& aAIndvElgCustCargo.getCat_cd()
											.startsWith("M") && "M00"
										.equals(category))
							|| (AppConstants.CTS_PAGE_ID.equals(aPageId)
									&& aAIndvElgCustCargo
											.getCat_cd()
											.startsWith(
													AppConstants.CARETAKER_SUPPLEMENT) && AppConstants.CARETAKER_SUPPLEMENT
										.equals(category))
							|| (AppConstants.SC_PAGE_ID.equals(aPageId)
									&& aAIndvElgCustCargo.getCat_cd()
											.startsWith(
													AppConstants.SENIOR_CARE) && AppConstants.SENIOR_CARE
										.equals(category))) {
						if ("R".equals(action)) { // R --> replace
							rsnCode = aTempMap.get("SUBST_RSN_CD").toString();
							if (!aDsplyRsnCodesList.contains(rsnCode)) {
								aDsplyRsnCodesList.add(rsnCode);
							} else {
								rsnCode = "";
							}
						} else if ("S".equals(action)) { // S --> Suppress
							if (null != aDsplyRsnCodesList && aDsplyRsnCodesList.isEmpty()) {
								aDsplyRsnCodesList.add(aCurrentRsnCd);
								rsnCode = aCurrentRsnCd;
							} else {
								rsnCode = "";
							}
						}
					} else if (aDsplyRsnCodesList.contains(aCurrentRsnCd)) {
						rsnCode = "";
					} else {
						aDsplyRsnCodesList.add(aCurrentRsnCd);
						rsnCode = aCurrentRsnCd;
					}

				} else if (aDsplyRsnCodesList.contains(aCurrentRsnCd)) { // If
					// not
					// in
					// the
					// list
					// but
					// already
					// added
					// by
					// prev
					// subst
					rsnCode = "";
				} else if (!aDsplyRsnCodesList.contains(aCurrentRsnCd)) { // Adding
					// to
					// the
					// list
					// first
					// time
					aDsplyRsnCodesList.add(aCurrentRsnCd);
					rsnCode = aCurrentRsnCd;
				}
			}
			log(ILog.INFO,
					"MyAccessBO.processReasonCodeSuppression() - END , Time Taken : "
							+ (System.currentTimeMillis() - startTime)
							+ " milliseconds");
			return rsnCode;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"isSuppRsnCodeExist", e);
		}
	}

	/**
	 * Gets the text id for msg code.
	 *
	 * @author parepum
	 *
	 *         To get the Accesss equivalent Text id for the cares generated
	 *         failure reason codes in INDV_ELG
	 * @param msgCode
	 *            the msg code
	 * @param msgVerCode
	 *            the msg ver code
	 * @return the text id for msg code
	 */

	protected String getTextIdForMsgCode(final String msgCode,
			final String msgVerCode) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getTextIdForMsgCode() - START");
		String textId = "";
		final IPage ipage = FwPageManager.createInstance();
		textId = ipage.getMessageCode(msgCode, msgVerCode);
		log(ILog.INFO, "MyAccessBO.getTextIdForMsgCode() - END , Time Taken : "
				+ (System.currentTimeMillis() - startTime) + " milliseconds");
		return textId;
	}

	/* VG SONAR Cleanup - 08/25/2015 Changed Commented code block to javadoc */
	/**
	 * //this method for the pend records public HIST_MTH_CUST_Collection
	 * getHistoryMonthsCount(String caseNum, String catCd, Date currentDate){
	 * Map sqlMap = new HashMap(); HIST_MTH_CUST_Collection histMthCountColl =
	 * new HIST_MTH_CUST_Collection(); String catCdFull = null;
	 * if(catCd.equals(AppConstants.SENIOR_CARE)) catCdFull =
	 * AppConstants.SENIOR_CARE+"%"; else
	 * if(catCd.equals(AppConstants.FOOD_SHARE)) catCdFull =
	 * AppConstants.FOOD_SHARE+"%"; else
	 * if(catCd.equals(AppConstants.CARETAKER_SUPPLEMENT)) catCdFull =
	 * AppConstants.CARETAKER_SUPPLEMENT+"%"; else if(catCd.startsWith("M"))
	 * catCdFull = "M%"; else catCdFull="";
	 *
	 * try{ sqlMap.put(FwConstants.SQL_IND, "sql-211"); FwDataCriteria[]
	 * criteria = new FwDataCriteria[3]; criteria[0] = new FwDataCriteria();
	 * criteria[0].setColumn_value(caseNum);
	 * criteria[0].setData_type(FwConstants.LONG); criteria[1] = new
	 * FwDataCriteria(); criteria[1].setColumn_value(catCdFull);
	 * criteria[1].setData_type(FwConstants.STRING); criteria[2] = new
	 * FwDataCriteria(); criteria[2].setColumn_value(currentDate.toString());
	 * criteria[2].setData_type(FwConstants.DATE);
	 * sqlMap.put(FwConstants.CRITERIA, criteria); List res =
	 * executeSQL(sqlMap); if(res.size()>0){ HIST_MTH_CUST_Cargo[] histMthCount
	 * = new HIST_MTH_CUST_Cargo[res.size()]; int resSize = res.size(); for(int
	 * i=0; i<res.size();i++){ Map cargo = (Map) res.get(i); histMthCount[i] =
	 * new HIST_MTH_CUST_Cargo();
	 * histMthCount[i].setCat_cd((String)cargo.get("CAT"));
	 * histMthCount[i].setScat_seq_num((String)cargo.get("SEQ"));
	 * histMthCount[i].setMth_count((String)cargo.get("COUNT")); }
	 * histMthCountColl.setResults(histMthCount); } } catch (FwException fe) {
	 * throw fe; } catch (Exception e) { FwException fe = createFwException(
	 * this.getClass().getName(), "getHistoryMonthsCount", e); throw fe; }
	 * return histMthCountColl; }
	 *
	 *
	 * //this method for getting the history months public
	 * HIST_MTH_CUST_Collection getHistoryMonths(String caseNum, String catCd,
	 * Date currentDate){ Map sqlMap = new HashMap(); HIST_MTH_CUST_Collection
	 * histMthColl = new HIST_MTH_CUST_Collection(); String catCdFull = null;
	 * if(catCd.equals(AppConstants.SENIOR_CARE)) catCdFull =
	 * AppConstants.SENIOR_CARE+"%"; else
	 * if(catCd.equals(AppConstants.FOOD_SHARE)) catCdFull =
	 * AppConstants.FOOD_SHARE+"%"; else
	 * if(catCd.equals(AppConstants.CARETAKER_SUPPLEMENT)) catCdFull =
	 * AppConstants.CARETAKER_SUPPLEMENT+"%"; else if(catCd.startsWith("M"))
	 * catCdFull = "M%"; else catCdFull=""; try{ sqlMap.put(FwConstants.SQL_IND,
	 * "sql-212"); FwDataCriteria[] criteria = new FwDataCriteria[3];
	 * criteria[0] = new FwDataCriteria(); criteria[0].setColumn_value(caseNum);
	 * criteria[0].setData_type(FwConstants.LONG); criteria[1] = new
	 * FwDataCriteria(); criteria[1].setColumn_value(catCdFull);
	 * criteria[1].setData_type(FwConstants.STRING); criteria[2] = new
	 * FwDataCriteria(); criteria[2].setColumn_value(currentDate.toString());
	 * criteria[2].setData_type(FwConstants.DATE);
	 * sqlMap.put(FwConstants.CRITERIA, criteria); List res =
	 * executeSQL(sqlMap); if(res.size()>0){ HIST_MTH_CUST_Cargo[] histMth = new
	 * HIST_MTH_CUST_Cargo[res.size()]; int resSize = res.size(); for(int i=0;
	 * i<res.size();i++){ Map cargo = (Map) res.get(i); histMth[i] = new
	 * HIST_MTH_CUST_Cargo(); histMth[i].setCat_cd((String)cargo.get("CAT_CD"));
	 * histMth[i].setScat_seq_num((String)cargo.get("SCAT_SEQ_NUM"));
	 * histMth[i].setPymt_beg_dt((String)cargo.get("PYMT_BEG_DT"));
	 * histMth[i].setPymt_end_dt((String)cargo.get("PYMT_END_DT")); }
	 * histMthColl.setResults(histMth); } } catch (FwException fe) { throw fe; }
	 * catch (Exception e) { FwException fe = createFwException(
	 * this.getClass().getName(), "getHistoryMonths", e); throw fe; } return
	 * histMthColl; }
	 *
	 * @param caseNum
	 *            the case num
	 * @param catCd
	 *            the cat cd
	 * @param currentDate
	 *            the current date
	 * @return the history months count
	 */

	/**
	 * This method for getting the history months.
	 *
	 * @param caseNum
	 * @param catCd
	 * @param currentDate
	 * @return
	 */

	public int getHistoryMonthsCount(final String caseNum, final String catCd,
			final Date currentDate) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getHistoryMonthsCount() - START");
		final Map sqlMap = new HashMap();
		int count = 0;
		String catCdFull = null;
		if (AppConstants.SENIOR_CARE.equals(catCd)) {
			catCdFull = AppConstants.SENIOR_CARE + "%";
		} else if (AppConstants.FOOD_SHARE.equals(catCd)) {
			catCdFull = AppConstants.FOOD_SHARE + "%";
		} else if (AppConstants.CARETAKER_SUPPLEMENT.equals(catCd)) {
			catCdFull = AppConstants.CARETAKER_SUPPLEMENT + "%";
		} else if (catCd.startsWith("M")) {
			catCdFull = "M%";
		} else {
			catCdFull = "";
		}

		try {
			sqlMap.put(FwConstants.SQL_IND, "sql-211");
			final FwDataCriteria[] criteria = new FwDataCriteria[3];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_value(caseNum);
			criteria[0].setData_type(FwConstants.LONG);
			criteria[1] = new FwDataCriteria();
			criteria[1].setColumn_value(catCdFull);
			criteria[1].setData_type(FwConstants.STRING);
			criteria[2] = new FwDataCriteria();
			criteria[2].setColumn_value(currentDate.toString());
			criteria[2].setData_type(FwConstants.DATE);
			sqlMap.put(FwConstants.CRITERIA, criteria);
			final List res = executeSQL(sqlMap);
			if (null != res && !res.isEmpty()) {
				final Map cargo = (Map) res.get(0);
				count = Integer
						.parseInt((String) cargo.get("HIST_MONTH_COUNT"));
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getHistoryMonthsCount", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getHistoryMonthsCount() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return count;
	}

	/**
	 * This method for getting the history months.
	 *
	 * @param caseNum
	 *            case number
	 * @param catCd
	 *            the cat cd
	 * @param currentDate
	 *            the current date
	 * @return the history months
	 */

	public Date[] getHistoryMonths(final String caseNum, final String catCd,
			final Date currentDate) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getHistoryMonths() - START");
		final Map sqlMap = new HashMap();
		final Date[] pymtDate = new Date[2];
		String catCdFull = null;
		if (AppConstants.SENIOR_CARE.equals(catCd)) {
			catCdFull = AppConstants.SENIOR_CARE + "%";
		} else if (AppConstants.FOOD_SHARE.equals(catCd)) {
			catCdFull = AppConstants.FOOD_SHARE + "%";
		} else if (AppConstants.CARETAKER_SUPPLEMENT.equals(catCd)) {
			catCdFull = AppConstants.CARETAKER_SUPPLEMENT + "%";
		} else if (catCd.startsWith("M")) {
			catCdFull = "M%";
		} else {
			catCdFull = "";
		}
		try {
			sqlMap.put(FwConstants.SQL_IND, "sql-212");
			final FwDataCriteria[] criteria = new FwDataCriteria[3];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_value(caseNum);
			criteria[0].setData_type(FwConstants.LONG);
			criteria[1] = new FwDataCriteria();
			criteria[1].setColumn_value(catCdFull);
			criteria[1].setData_type(FwConstants.STRING);
			criteria[2] = new FwDataCriteria();
			criteria[2].setColumn_value(currentDate.toString());
			criteria[2].setData_type(FwConstants.DATE);
			sqlMap.put(FwConstants.CRITERIA, criteria);
			final List res = executeSQL(sqlMap);
			if (null != res && !res.isEmpty()) {
				final Map cargo = (Map) res.get(0);
				pymtDate[0] = dateRoutine.getDateFromTimeStamp((String) cargo
						.get("PYMT_BEG_DT"));
				pymtDate[1] = dateRoutine.getDateFromTimeStamp((String) cargo
						.get("PYMT_END_DT"));
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getHistoryMonths", e);
		}
		log(ILog.INFO, "MyAccessBO.getHistoryMonths() - END , Time Taken : "
				+ (System.currentTimeMillis() - startTime) + " milliseconds");
		return pymtDate;
	}

	/**
	 * This method returns Individual Eligibility collection.
	 *
	 * @param caseNum
	 *            case number
	 * @param elgInd
	 *            the elg ind
	 * @param catCd
	 *            the cat cd
	 * @return the summary grouping for previous month
	 */

	public CUST_INDV_ELG_Collection getSummaryGroupingForPreviousMonth(
			final String caseNum, final String elgInd, final String catCd) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"MyAccessBO.getSummaryGroupingForPreviousMonth() - START");
		final Map sqlMap = new HashMap();
		final CUST_INDV_ELG_Collection custIndvElgCollPreviousMonth = new CUST_INDV_ELG_Collection();
		try {
			if ((elgInd != null) && (caseNum != null)) {
				sqlMap.put(FwConstants.SQL_IND, "sql-239");
				final FwDataCriteria[] criteria = new FwDataCriteria[4];
				criteria[0] = new FwDataCriteria();
				criteria[0].setColumn_value(caseNum);
				criteria[0].setData_type(FwConstants.LONG);
				criteria[1] = new FwDataCriteria();
				criteria[1].setColumn_value(elgInd);
				criteria[1].setData_type(FwConstants.STRING);

				Date currentDate = fwDate.getDate();
				currentDate.setDate(1);
				currentDate.setDate(currentDate.getDate() - 1);
				final Date endOfMnth = currentDate;// added for FAP amt
				criteria[2] = new FwDataCriteria();
				criteria[2].setColumn_value(currentDate.toString());
				criteria[2].setData_type(FwConstants.STRING);

				currentDate = fwDate.getDate();
				currentDate.setDate(1);
				currentDate.setMonth(currentDate.getMonth() - 1);
				final Date beginOfMnth = currentDate;// added for FAP amt
				criteria[3] = new FwDataCriteria();
				criteria[3].setColumn_value(currentDate.toString());
				criteria[3].setData_type(FwConstants.STRING);
				sqlMap.put(FwConstants.CRITERIA, criteria);
				final String paymentAmount = getFAPPaymentAmount(caseNum,
						endOfMnth, beginOfMnth);// added
				// for
				// FAP
				// amt
				final List res = executeSQL(sqlMap);
				if (null != res && !res.isEmpty()) {
					final CUST_INDV_ELG_Cargo[] custIndvElgCargo = new CUST_INDV_ELG_Cargo[res
							.size()];

					for (int i = 0; i < res.size(); i++) {
						final Map cargo = (Map) res.get(i);
						custIndvElgCargo[i] = new CUST_INDV_ELG_Cargo();
						custIndvElgCargo[i].setMci_id((String) cargo
								.get("MCI_ID"));
						custIndvElgCargo[i].setBnft_pin_num((String) cargo
								.get("BNFT_PIN_NUM"));
						custIndvElgCargo[i].setBnft_case_num((String) cargo
								.get("BNFT_CASE_NUM"));
						custIndvElgCargo[i].setCat_cd((String) cargo
								.get("CAT_CD"));
						custIndvElgCargo[i].setScat_cd((String) cargo
								.get("SCAT_CD"));
						custIndvElgCargo[i].setScat_seq_num((String) cargo
								.get("SCAT_SEQ_NUM"));
						custIndvElgCargo[i].setCur_elg_ind((String) cargo
								.get("CUR_ELG_IND"));
						custIndvElgCargo[i].setBnft_stat_cd((String) cargo
								.get("BNFT_STAT_CD"));
						custIndvElgCargo[i].setCnfm_dt((String) cargo
								.get("CNFM_DT"));
						custIndvElgCargo[i].setElg_beg_dt((String) cargo
								.get("ELG_BEG_DT"));
						custIndvElgCargo[i].setElg_end_dt((String) cargo
								.get("ELG_END_DT"));
						custIndvElgCargo[i].setElg_ind((String) cargo
								.get("ELG_IND"));
						custIndvElgCargo[i].setMa_ddct_bal_amt((String) cargo
								.get("MA_DDCT_BAL_AMT"));
						if (paymentAmount != null) {
							custIndvElgCargo[i].setPymt_amt(paymentAmount);
						} else {
							custIndvElgCargo[i].setPymt_amt("0.00");
						}
						custIndvElgCargo[i].setPymt_beg_dt((String) cargo
								.get("PYMT_BEG_DT"));
						custIndvElgCargo[i].setPymt_end_dt((String) cargo
								.get("PYMT_END_DT"));
						custIndvElgCargo[i].setPymt_typ((String) cargo
								.get("PYMT_TYP"));
						custIndvElgCargo[i].setSc_bnft_lvl_cd((String) cargo
								.get("SC_BNFT_LVL_CD"));
						custIndvElgCargo[i].setUpdt_dt((String) cargo
								.get("UPDT_DT"));
						custIndvElgCargo[i].setVfcn_due_dt((String) cargo
								.get("VFCN_DUE_DT"));
						custIndvElgCargo[i].setMsg_cd_txt((String) cargo
								.get("MSG_CD_TXT"));
						custIndvElgCargo[i].setFst_nam(cargo.get("FST_NAM")
								.toString().trim());
						custIndvElgCargo[i].setSex_ind((String) cargo
								.get("SEX_IND"));
						custIndvElgCargo[i].setPgm_rqst_sw((String) cargo
								.get("PGM_RQST_SW"));
						custIndvElgCargo[i].setOrg_elg_ind((String) cargo
								.get("ORIG_ELG_IND"));
						custIndvElgCargo[i].setNf_fail_rsn_1_cd((String) cargo
								.get("NF_FAIL_RSN_1_CD"));
						custIndvElgCargo[i].setPrev_sc_bnft_l_cd((String) cargo
								.get("PREV_SC_BNFT_L_CD"));
						custIndvElgCargo[i].setBrth_dt((String) cargo
								.get("BRTH_DT"));
						custIndvElgCargo[i].setEmpl_vfcn_due_dt((String) cargo
								.get("EMPL_VFCN_DUE_DT"));
						custIndvElgCargo[i].setIns_vfcn_due_dt((String) cargo
								.get("INS_VFCN_DUE_DT"));
						custIndvElgCargo[i].setSmirf_mo((String) cargo
								.get("SMIRF_MO"));
						custIndvElgCargo[i]
								.setSemi_annual_review_date((String) cargo
										.get("SEMI_ANNUAL_REVIEW_DT"));
						custIndvElgCargo[i].setReview_dt((String) cargo
								.get("REVIEW_DT"));
						custIndvElgCargo[i]
								.setMid_cert_review_date((String) cargo
										.get("MID_CERT_REVIEW_DT"));
						custIndvElgCargo[i].setEstm_elg_end_dt((String) cargo
								.get("ESTM_ELG_END_DT"));

					}
					custIndvElgCollPreviousMonth.setResults(custIndvElgCargo);
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getSummaryGroupingForPreviousMonth", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getSummaryGroupingForPreviousMonth() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return custIndvElgCollPreviousMonth;

	}

	/**
	 * Gets the summary grouping for previous month for manual issuance.
	 *
	 * @param caseNum
	 *            case number
	 * @param elgInd
	 *            the elg ind
	 * @param catCd
	 *            the cat cd
	 * @return the summary grouping for previous month for manual issuance
	 */

	public CUST_INDV_ELG_Collection getSummaryGroupingForPreviousMonthForManualIssuance(
			final String caseNum, final String elgInd, final String catCd) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"MyAccessBO.getSummaryGroupingForPreviousMonthForManualIssuance() - START");
		final Map sqlMap = new HashMap();
		final CUST_INDV_ELG_Collection custIndvElgCollPreviousMonth = new CUST_INDV_ELG_Collection();
		try {
			if ((elgInd != null) && (caseNum != null)) {
				sqlMap.put(FwConstants.SQL_IND, "sql-249");
				final FwDataCriteria[] criteria = new FwDataCriteria[3];
				criteria[0] = new FwDataCriteria();
				criteria[0].setColumn_value(caseNum);
				criteria[0].setData_type(FwConstants.LONG);
				/*
				 * VG SONAR Cleanup - 08/25/2015 Deleted 3,1,1,1 lines Commented
				 * Code in this block
				 */

				Date currentDate = fwDate.getDate();
				currentDate.setDate(1);
				currentDate.setDate(currentDate.getDate() - 1);
				// added for FAP amt
				criteria[1] = new FwDataCriteria();
				criteria[1].setColumn_value(currentDate.toString());
				criteria[1].setData_type(FwConstants.STRING);

				currentDate = fwDate.getDate();
				currentDate.setDate(1);
				currentDate.setMonth(currentDate.getMonth() - 1);
				// added for FAP amt
				criteria[2] = new FwDataCriteria();
				criteria[2].setColumn_value(currentDate.toString());
				criteria[2].setData_type(FwConstants.STRING);
				sqlMap.put(FwConstants.CRITERIA, criteria);
				final List res = executeSQL(sqlMap);
				if (null != res && !res.isEmpty()) {
					final CUST_INDV_ELG_Cargo[] custIndvElgCargo = new CUST_INDV_ELG_Cargo[res
							.size()];

					for (int i = 0; i < res.size(); i++) {

						final Map cargo = (Map) res.get(i);
						custIndvElgCargo[i] = new CUST_INDV_ELG_Cargo();
						custIndvElgCargo[i].setPymt_amt((String) cargo
								.get("TOTAL_AMT"));
						custIndvElgCargo[i].setCat_cd((String) cargo
								.get("CAT_CD"));
						custIndvElgCargo[i].setBnft_case_num((String) cargo
								.get("BNFT_CASE_NUM"));
						custIndvElgCargo[i].setFst_nam((String) cargo
								.get("FST_NAM"));
						custIndvElgCargo[i].setSex_ind((String) cargo
								.get("SEX_IND"));
						custIndvElgCargo[i].setBrth_dt((String) cargo
								.get("BRTH_DT"));

					}
					custIndvElgCollPreviousMonth.setResults(custIndvElgCargo);
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getSummaryGroupingForPreviousMonth", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getSummaryGroupingForPreviousMonthForManualIssuance() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return custIndvElgCollPreviousMonth;

	}

	/**
	 * Chk is previous month exits.
	 *
	 * @param caseNum
	 *            case number
	 * @param elgInd
	 *            the elg ind
	 * @return true, if successful
	 */

	public boolean chkIsPreviousMonthExits(final String caseNum,
			final String elgInd) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.chkIsPreviousMonthExits() - START");
		final Map sqlMap = new HashMap();
		boolean isPreviousMonthExis = false;
		try {
			if ((elgInd != null) && (caseNum != null)) {
				sqlMap.put(FwConstants.SQL_IND, "sql-248");
				final FwDataCriteria[] criteria = new FwDataCriteria[3];
				criteria[0] = new FwDataCriteria();
				criteria[0].setColumn_value(caseNum);
				criteria[0].setData_type(FwConstants.LONG);

				/*
				 * VG SONAR Cleanup - 08/25/2015 Deleted 3 lines Commented Code
				 * in this block
				 */

				Date currentDate = fwDate.getDate();
				currentDate.setDate(1);
				currentDate.setDate(currentDate.getDate() - 1);
				criteria[1] = new FwDataCriteria();
				criteria[1].setColumn_value(currentDate.toString());
				criteria[1].setData_type(FwConstants.STRING);

				currentDate = fwDate.getDate();
				currentDate.setDate(1);
				currentDate.setMonth(currentDate.getMonth() - 1);
				criteria[2] = new FwDataCriteria();
				criteria[2].setColumn_value(currentDate.toString());
				criteria[2].setData_type(FwConstants.STRING);
				sqlMap.put(FwConstants.CRITERIA, criteria);
				final List res = executeSQL(sqlMap);
				if (null != res && !res.isEmpty()) {
					isPreviousMonthExis = true;
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"chkIsPreviousMonthExits", e);
		}
		log(ILog.INFO,
				"MyAccessBO.chkIsPreviousMonthExits() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return isPreviousMonthExis;

	}

	/**
	 * Chk is previous month exits for manual issuance.
	 *
	 * @param caseNum
	 *            case number
	 * @param elgInd
	 *            the elg ind
	 * @return true, if successful
	 */

	public boolean chkIsPreviousMonthExitsForManualIssuance(
			final String caseNum, final String elgInd) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"MyAccessBO.chkIsPreviousMonthExitsForManualIssuance() - START");
		final Map sqlMap = new HashMap();
		boolean isPreviousMonthExis = false;
		try {
			if ((elgInd != null) && (caseNum != null)) {
				sqlMap.put(FwConstants.SQL_IND, "sql-249");
				final FwDataCriteria[] criteria = new FwDataCriteria[3];
				criteria[0] = new FwDataCriteria();
				criteria[0].setColumn_value(caseNum);
				criteria[0].setData_type(FwConstants.LONG);

				/*
				 * VG SONAR Cleanup - 08/25/2015 Deleted 3 lines Commented Code
				 * in this block
				 */

				Date currentDate = fwDate.getDate();
				currentDate.setDate(1);
				currentDate.setDate(currentDate.getDate() - 1);
				criteria[1] = new FwDataCriteria();
				criteria[1].setColumn_value(currentDate.toString());
				criteria[1].setData_type(FwConstants.STRING);

				currentDate = fwDate.getDate();
				currentDate.setDate(1);
				currentDate.setMonth(currentDate.getMonth() - 1);
				criteria[2] = new FwDataCriteria();
				criteria[2].setColumn_value(currentDate.toString());
				criteria[2].setData_type(FwConstants.STRING);
				sqlMap.put(FwConstants.CRITERIA, criteria);
				final List res = executeSQL(sqlMap);
				if (null != res && !res.isEmpty()) {
					isPreviousMonthExis = true;
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"chkIsPreviousMonthExits", e);
		}
		log(ILog.INFO,
				"MyAccessBO.chkIsPreviousMonthExitsForManualIssuance() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return isPreviousMonthExis;

	}

	/**
	 * Chk isnext month exist for manual issuance.
	 *
	 * @param caseNum
	 *            case number
	 * @param elgInd
	 *            the elg ind
	 * @return true, if successful
	 */

	public boolean chkIsnextMonthExistForManualIssuance(final String caseNum,
			final String elgInd) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"MyAccessBO.chkIsnextMonthExistForManualIssuance() - START");
		final Map sqlMap = new HashMap();
		boolean isPreviousMonthExis = false;
		try {
			if ((elgInd != null) && (caseNum != null)) {
				sqlMap.put(FwConstants.SQL_IND, "sql-249");
				final FwDataCriteria[] criteria = new FwDataCriteria[3];
				criteria[0] = new FwDataCriteria();
				criteria[0].setColumn_value(caseNum);
				criteria[0].setData_type(FwConstants.LONG);

				/*
				 * VG SONAR Cleanup - 08/25/2015 Deleted 3 lines Commented Code
				 * in this block
				 */

				Date currentDate = fwDate.getDate();
				currentDate.setDate(1);
				currentDate.setMonth(currentDate.getMonth() + 2);
				currentDate.setDate(currentDate.getDate() - 1);
				criteria[1] = new FwDataCriteria();
				criteria[1].setColumn_value(currentDate.toString());
				criteria[1].setData_type(FwConstants.STRING);

				currentDate = fwDate.getDate();
				currentDate.setDate(1);
				currentDate.setMonth(currentDate.getMonth() + 1);
				criteria[2] = new FwDataCriteria();
				criteria[2].setColumn_value(currentDate.toString());
				criteria[2].setData_type(FwConstants.STRING);
				sqlMap.put(FwConstants.CRITERIA, criteria);
				final List res = executeSQL(sqlMap);
				if (null != res && !res.isEmpty()) {
					isPreviousMonthExis = true;
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"chkIsPreviousMonthExits", e);
		}
		log(ILog.INFO,
				"MyAccessBO.chkIsnextMonthExistForManualIssuance() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return isPreviousMonthExis;

	}

	/**
	 * This method returns Individual Eligibility collection.
	 *
	 * @param caseNum
	 *            case number
	 * @param elgInd
	 *            the elg ind
	 * @return the summary grouping for next month
	 */

	public CUST_INDV_ELG_Collection getSummaryGroupingForNextMonth(
			final String caseNum, final String elgInd) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getSummaryGroupingForNextMonth() - START");
		final Map sqlMap = new HashMap();
		final CUST_INDV_ELG_Collection custIndvElgCollNextMonth = new CUST_INDV_ELG_Collection();
		try {
			if ((elgInd != null) && (caseNum != null)) {
				sqlMap.put(FwConstants.SQL_IND, "sql-239");
				final FwDataCriteria[] criteria = new FwDataCriteria[4];
				criteria[0] = new FwDataCriteria();
				criteria[0].setColumn_value(caseNum);
				criteria[0].setData_type(FwConstants.LONG);
				criteria[1] = new FwDataCriteria();
				criteria[1].setColumn_value(elgInd);
				criteria[1].setData_type(FwConstants.STRING);

				Date currentDate = fwDate.getDate();
				currentDate.setDate(1);
				currentDate.setMonth(currentDate.getMonth() + 2);
				currentDate.setDate(currentDate.getDate() - 1);
				criteria[2] = new FwDataCriteria();
				criteria[2].setColumn_value(currentDate.toString());
				criteria[2].setData_type(FwConstants.STRING);

				currentDate = fwDate.getDate();
				currentDate.setDate(1);
				currentDate.setMonth(currentDate.getMonth() + 1);
				criteria[3] = new FwDataCriteria();
				criteria[3].setColumn_value(currentDate.toString());
				criteria[3].setData_type(FwConstants.STRING);
				sqlMap.put(FwConstants.CRITERIA, criteria);
				final List res = executeSQL(sqlMap);
				if (null != res && !res.isEmpty()) {
					final CUST_INDV_ELG_Cargo[] custIndvElgCargo = new CUST_INDV_ELG_Cargo[res
							.size()];

					for (int i = 0; i < res.size(); i++) {
						final Map cargo = (Map) res.get(i);
						custIndvElgCargo[i] = new CUST_INDV_ELG_Cargo();
						custIndvElgCargo[i].setMci_id((String) cargo
								.get("MCI_ID"));
						custIndvElgCargo[i].setBnft_pin_num((String) cargo
								.get("BNFT_PIN_NUM"));
						custIndvElgCargo[i].setBnft_case_num((String) cargo
								.get("BNFT_CASE_NUM"));
						custIndvElgCargo[i].setCat_cd((String) cargo
								.get("CAT_CD"));
						custIndvElgCargo[i].setScat_cd((String) cargo
								.get("SCAT_CD"));
						custIndvElgCargo[i].setScat_seq_num((String) cargo
								.get("SCAT_SEQ_NUM"));
						custIndvElgCargo[i].setCur_elg_ind((String) cargo
								.get("CUR_ELG_IND"));
						custIndvElgCargo[i].setBnft_stat_cd((String) cargo
								.get("BNFT_STAT_CD"));
						custIndvElgCargo[i].setCnfm_dt((String) cargo
								.get("CNFM_DT"));
						custIndvElgCargo[i].setElg_beg_dt((String) cargo
								.get("ELG_BEG_DT"));
						custIndvElgCargo[i].setElg_end_dt((String) cargo
								.get("ELG_END_DT"));
						custIndvElgCargo[i].setElg_ind((String) cargo
								.get("ELG_IND"));
						custIndvElgCargo[i].setMa_ddct_bal_amt((String) cargo
								.get("MA_DDCT_BAL_AMT"));
						custIndvElgCargo[i].setPymt_amt((String) cargo
								.get("PYMT_AMT"));
						custIndvElgCargo[i].setPymt_beg_dt((String) cargo
								.get("PYMT_BEG_DT"));
						custIndvElgCargo[i].setPymt_end_dt((String) cargo
								.get("PYMT_END_DT"));
						custIndvElgCargo[i].setPymt_typ((String) cargo
								.get("PYMT_TYP"));
						custIndvElgCargo[i].setSc_bnft_lvl_cd((String) cargo
								.get("SC_BNFT_LVL_CD"));
						custIndvElgCargo[i].setUpdt_dt((String) cargo
								.get("UPDT_DT"));
						custIndvElgCargo[i].setVfcn_due_dt((String) cargo
								.get("VFCN_DUE_DT"));
						custIndvElgCargo[i].setMsg_cd_txt((String) cargo
								.get("MSG_CD_TXT"));
						custIndvElgCargo[i].setFst_nam(cargo.get("FST_NAM")
								.toString().trim());
						custIndvElgCargo[i].setSex_ind((String) cargo
								.get("SEX_IND"));
						custIndvElgCargo[i].setPgm_rqst_sw((String) cargo
								.get("PGM_RQST_SW"));
						custIndvElgCargo[i].setOrg_elg_ind((String) cargo
								.get("ORIG_ELG_IND"));
						custIndvElgCargo[i].setNf_fail_rsn_1_cd((String) cargo
								.get("NF_FAIL_RSN_1_CD"));
						custIndvElgCargo[i].setPrev_sc_bnft_l_cd((String) cargo
								.get("PREV_SC_BNFT_L_CD"));
						custIndvElgCargo[i].setBrth_dt((String) cargo
								.get("BRTH_DT"));
						custIndvElgCargo[i].setEmpl_vfcn_due_dt((String) cargo
								.get("EMPL_VFCN_DUE_DT"));
						custIndvElgCargo[i].setIns_vfcn_due_dt((String) cargo
								.get("INS_VFCN_DUE_DT"));
						custIndvElgCargo[i].setSmirf_mo((String) cargo
								.get("SMIRF_MO"));
						custIndvElgCargo[i]
								.setSemi_annual_review_date((String) cargo
										.get("SEMI_ANNUAL_REVIEW_DT"));
						custIndvElgCargo[i].setReview_dt((String) cargo
								.get("REVIEW_DT"));
						custIndvElgCargo[i]
								.setMid_cert_review_date((String) cargo
										.get("MID_CERT_REVIEW_DT"));
					}
					custIndvElgCollNextMonth.setResults(custIndvElgCargo);
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getSummaryGroupingForNextMonth", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getSummaryGroupingForNextMonth() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return custIndvElgCollNextMonth;

	}

	/**
	 * Chk isnext month exist.
	 *
	 * @param caseNum
	 *            case number
	 * @param elgInd
	 *            the elg ind
	 * @return true, if successful
	 */

	public boolean chkIsnextMonthExist(final String caseNum, final String elgInd) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.chkIsnextMonthExist() - START");
		boolean isNextMonthExist = false;
		final Map sqlMap = new HashMap();
		try {
			if ((elgInd != null) && (caseNum != null)) {
				sqlMap.put(FwConstants.SQL_IND, "sql-248");
				final FwDataCriteria[] criteria = new FwDataCriteria[3];
				criteria[0] = new FwDataCriteria();
				criteria[0].setColumn_value(caseNum);
				criteria[0].setData_type(FwConstants.LONG);

				/*
				 * VG SONAR Cleanup - 08/25/2015 Deleted 3 lines Commented Code
				 * in this block
				 */

				Date currentDate = fwDate.getDate();
				currentDate.setDate(1);
				currentDate.setMonth(currentDate.getMonth() + 2);
				currentDate.setDate(currentDate.getDate() - 1);
				criteria[1] = new FwDataCriteria();
				criteria[1].setColumn_value(currentDate.toString());
				criteria[1].setData_type(FwConstants.STRING);

				currentDate = fwDate.getDate();
				currentDate.setDate(1);
				currentDate.setMonth(currentDate.getMonth() + 1);
				criteria[2] = new FwDataCriteria();
				criteria[2].setColumn_value(currentDate.toString());
				criteria[2].setData_type(FwConstants.STRING);
				sqlMap.put(FwConstants.CRITERIA, criteria);
				final List res = executeSQL(sqlMap);
				if (null != res && !res.isEmpty()) {
					isNextMonthExist = true;

				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"chkIsnextMonthExist", e);
		}
		log(ILog.INFO, "MyAccessBO.chkIsnextMonthExist() - END , Time Taken : "
				+ (System.currentTimeMillis() - startTime) + " milliseconds");
		return isNextMonthExist;

	}

	/**
	 * For helthcare we need to pass list.
	 *
	 * @param caseNum
	 *            case number
	 * @param categoryCd
	 *            the category cd
	 * @return the history month indicator
	 */

	public List getHistoryMonthIndicator(final String caseNum,
			final String categoryCd) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getHistoryMonthIndicator() - START");
		// this onw we need to pass through
		Date hist0Month = null;
		final Date hist3Month = null;

		List monthList = null;
		try {
			Date previousMonth = null;
			Date nextMonth = null;
			hist0Month = fwDate.getDate();
			if (chkIsPreviousMonthExits(caseNum, AppConstants.ELIGIBLE)) {
				final Date currentDate = fwDate.getDate();
				currentDate.setDate(1);
				currentDate.setMonth(currentDate.getMonth() - 1);
				previousMonth = currentDate;
			}
			if (chkIsPreviousMonthExitsForManualIssuance(caseNum,
					AppConstants.ELIGIBLE)) {
				final Date currentDate = fwDate.getDate();
				currentDate.setDate(1);
				currentDate.setMonth(currentDate.getMonth() - 1);
				previousMonth = currentDate;
			}
			if (chkIsnextMonthExist(caseNum, AppConstants.ELIGIBLE)) {
				final Date currentDate = fwDate.getDate();
				currentDate.setDate(1);
				currentDate.setMonth(currentDate.getMonth() + 1);
				nextMonth = currentDate;
			}

			if (chkIsnextMonthExistForManualIssuance(caseNum,
					AppConstants.ELIGIBLE)) {
				final Date currentDate = fwDate.getDate();
				currentDate.setDate(1);
				currentDate.setMonth(currentDate.getMonth() + 1);
				nextMonth = currentDate;
			}
			monthList = new ArrayList();
			monthList.add(0, hist0Month);
			monthList.add(1, previousMonth);
			monthList.add(2, nextMonth);
			monthList.add(3, hist3Month);
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getHistoryMonthIndicator", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getHistoryMonthIndicator() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return monthList;
	}

	/**
	 * This one will gets the history month count from the collection.
	 *
	 * @param histMthCountColl
	 *            the hist mth count coll
	 * @param categoryCd
	 *            the category cd
	 * @return the cat history months count
	 */
	public int getCatHistoryMonthsCount(
			final HIST_MTH_CUST_Collection histMthCountColl,
			final String categoryCd) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getCatHistoryMonthsCount() - START");
		int count = 0;
		final int collSize = histMthCountColl.size();
		HIST_MTH_CUST_Cargo histMthCargo = null;
		for (int i = 0; i < collSize; i++) {
			histMthCargo = histMthCountColl.getResult(i);
			if (histMthCargo.getCat_cd().trim().equals(categoryCd)) {
				count = Integer.parseInt(histMthCargo.getMth_count());
				break;
			}
		}
		log(ILog.INFO,
				"MyAccessBO.getCatHistoryMonthsCount() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return count;
	}

	/**
	 * This one gives the history month form the hist mth collection.
	 *
	 * @param histMthColl
	 *            the hist mth coll
	 * @param categoryCd
	 *            the category cd
	 * @return the cat history months
	 */

	public Date[] getCatHistoryMonths(
			final HIST_MTH_CUST_Collection histMthColl, final String categoryCd) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getCatHistoryMonths() - START");
		final Date[] pymtDate = new Date[2];
		final int collSize = histMthColl.size();
		HIST_MTH_CUST_Cargo histMthCargo = null;
		for (int i = 0; i < collSize; i++) {
			histMthCargo = histMthColl.getResult(i);
			if (histMthCargo.getCat_cd().trim().equals(categoryCd)) {
				pymtDate[0] = dateRoutine.getDateFromTimeStamp(histMthCargo
						.getPymt_beg_dt());
				pymtDate[1] = dateRoutine.getDateFromTimeStamp(histMthCargo
						.getPymt_end_dt());
				break;
			}
		}
		log(ILog.INFO, "MyAccessBO.getCatHistoryMonths() - END , Time Taken : "
				+ (System.currentTimeMillis() - startTime) + " milliseconds");
		return pymtDate;
	}

	/**
	 * Here we are setting the parameter names.
	 *
	 * @param historyMonthList
	 *            the history month list
	 * @param pageMode
	 *            the page mode
	 * @param language
	 *            the language
	 * @param globalMonth
	 *            the global month
	 * @return the list
	 */
	public List settingButtonNames(final List historyMonthList,
			final String pageMode, final String language, final Date globalMonth) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.settingButtonNames() - START");
		String firstHistMonthName = null;
		String secHistMonthName = null;
		String currentMonthName = null;
		String displayMonthName = null;
		// here they need to pass categoryCd and The List

		Date currentMonth = null;
		Date firstHistMonth = null;
		Date secHistMonth = null;
		Date thirdHistMonth = null;
		Date displayMonthYear = null;
		try {
			if (historyMonthList != null) {
				final String and = FwMessageFormatter.getCachedText(10065,
						language);

				if (historyMonthList.get(0) != null) {
					currentMonth = dateRoutine
							.getDateFromTimeStamp(historyMonthList.get(0)
									.toString());
				}
				if (historyMonthList.get(1) != null) {
					firstHistMonth = dateRoutine
							.getDateFromTimeStamp(historyMonthList.get(1)
									.toString());
				}
				if (historyMonthList.get(2) != null) {
					secHistMonth = dateRoutine
							.getDateFromTimeStamp(historyMonthList.get(2)
									.toString());
				}
				if (historyMonthList.get(3) != null) {
					thirdHistMonth = dateRoutine
							.getDateFromTimeStamp(historyMonthList.get(3)
									.toString());
				}

				if (pageMode != null) {
					if (AppConstants.CURRENT_MODE.equals(pageMode)) {
						if (firstHistMonth != null) {
							if (thirdHistMonth != null) {
								// here we are finding the mixed month or not
								firstHistMonthName = displayFormatter
										.getExpandedMonthYear(firstHistMonth,
												language)
										+ " "
										+ and
										+ " "
										+ displayFormatter.getMonthName(
												thirdHistMonth, language);
							} else {
								// this is normal month
								firstHistMonthName = displayFormatter
										.getExpandedMonthYear(firstHistMonth,
												language);
							}
						}
						if (secHistMonth != null) {
							secHistMonthName = displayFormatter
									.getExpandedMonthYear(secHistMonth,
											language);
						}
						if (currentMonth != null) {
							displayMonthName = displayFormatter
									.getExpandedMonthYear(currentMonth,
											language);
							displayMonthYear = currentMonth;
						}
					}
					if (AppConstants.HISTORY_MODE.equals(pageMode)
							&& (globalMonth != null)) {
						if ((firstHistMonth != null)
								&& (thirdHistMonth == null)
								&& (globalMonth.getMonth() != firstHistMonth
										.getMonth())) {
							firstHistMonthName = displayFormatter
									.getExpandedMonthYear(firstHistMonth,
											language);
						}
						if ((secHistMonth != null)
								&& (globalMonth.getMonth() != secHistMonth
										.getMonth())) {
							secHistMonthName = displayFormatter
									.getExpandedMonthYear(secHistMonth,
											language);
						}
						currentMonthName = displayFormatter
								.getExpandedMonthYear(currentMonth, language);
						if (thirdHistMonth != null) {
							displayMonthName = displayFormatter
									.getExpandedMonthYear(firstHistMonth,
											language)
									+ " "
									+ and
									+ " "
									+ displayFormatter.getMonthName(
											thirdHistMonth, language);
							displayMonthYear = firstHistMonth;
						} else {
							displayMonthName = displayFormatter
									.getExpandedMonthYear(globalMonth, language);
							displayMonthYear = globalMonth;
						}
					}
					historyMonthList.add(4, null);
					historyMonthList.add(5, null);
					historyMonthList.add(6, null);
					historyMonthList.add(7, null);
					historyMonthList.add(8, null);
					if (firstHistMonthName != null) {
						historyMonthList.add(4, firstHistMonthName);
					}
					if (secHistMonthName != null) {
						historyMonthList.add(5, secHistMonthName);
					}
					if (currentMonthName != null) {
						historyMonthList.add(6, currentMonthName);
					}
					if (displayMonthName != null) {
						historyMonthList.add(7, displayMonthName);
					}
					if (displayMonthYear != null) {
						historyMonthList.add(8, displayMonthYear);
					}
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"settingButtonNames", e);
		}
		log(ILog.INFO, "MyAccessBO.settingButtonNames() - END , Time Taken : "
				+ (System.currentTimeMillis() - startTime) + " milliseconds");
		return historyMonthList;
	}

	/* VG SONAR Cleanup - 08/25/2015 Changed Commented code block to javadoc */
	/**
	 * // //here we are sorting the histroy collection // // public
	 * CUST_INDV_ELG_Collection getHistoryCollection1(String caseNum, // String
	 * catCd,String elgInd, String pageMode,Map historyMonthMap,Date //
	 * globalDate){ // // CUST_INDV_ELG_Collection sortColl = new
	 * CUST_INDV_ELG_Collection(); // CUST_INDV_ELG_Cargo sortCargo = null; //
	 * try{ // Date currentDate = fwDate.getDate(); // Date endOfCurrentMonth =
	 * displayFormatter.getEndOfMonth(currentDate); // Date startCurrentMonth =
	 * displayFormatter.getEndOfMonth(currentDate); // // //using this one i
	 * will get all months information // CUST_INDV_ELG_Collection custIndvColl
	 * = this.getDetailGrouping(caseNum, // catCd
	 * ,elgInd,AppConstants.ELIGIBILITY_HISTORY); // int size =
	 * custIndvColl.size(); //
	 * if(!historyMonthMap.containsKey(AppConstants.PAYMENT_END_MONTH)){ // //if
	 * they hit history one //
	 * if(pageMode.equals(AppConstants.HISTORY_MODE_ONE)){ // for(int i =0; i <
	 * size;i++){ // sortCargo = custIndvColl.getResult(i); // //here i am doing
	 * payment begin date > end of current month and payment // end date > end
	 * of current month //
	 * if(dateRoutine.getDateFromTimeStamp(sortCargo.getPymt_beg_dt
	 * ()).after(endOfCurrentMonth) // && //
	 * dateRoutine.getDateFromTimeStamp(sortCargo
	 * .getPymt_end_dt()).after(endOfCurrentMonth)){ // sortColl.add(sortCargo);
	 * // } // } // } // else if
	 * (pageMode.equals(AppConstants.HISTORY_MODE_TWO)){ // for(int i =0; i <
	 * size;i++){ // sortCargo = custIndvColl.getResult(i); // //here i am doing
	 * payment begin date <= end of current month and payment // end date <= end
	 * of current month //
	 * if(!dateRoutine.getDateFromTimeStamp(sortCargo.getPymt_beg_dt
	 * ()).after(endOfCurrentMonth) // && //
	 * !dateRoutine.getDateFromTimeStamp(sortCargo
	 * .getPymt_end_dt()).after(endOfCurrentMonth)){ // sortColl.add(sortCargo);
	 * // } // } // } // } // else{ // Date paymentEndDate = //
	 * (Date)historyMonthMap.get(AppConstants.PAYMENT_END_MONTH); //
	 * if(!historyMonthMap.containsKey(AppConstants.SECOND_HIST_MONTH)){ //
	 * for(int i =0; i < size;i++){ // sortCargo = custIndvColl.getResult(i); //
	 * //here i am doing payment begin date <= end of current month and payment
	 * // end date <= end of current month //
	 * if(!dateRoutine.getDateFromTimeStamp
	 * (sortCargo.getPymt_beg_dt()).after(currentDate) // && //
	 * dateRoutine.getDateFromTimeStamp
	 * (sortCargo.getPymt_end_dt()).equals(paymentEndDate)){ //
	 * sortColl.add(sortCargo); // } // } // } // else{ // for(int i =0; i <
	 * size;i++){ // sortCargo = custIndvColl.getResult(i); // //here i am doing
	 * payment begin date <= end of current month and payment // end date <= end
	 * of current month //
	 * if(!dateRoutine.getDateFromTimeStamp(sortCargo.getPymt_beg_dt
	 * ()).after(currentDate) // && //
	 * dateRoutine.getDateFromTimeStamp(sortCargo
	 * .getPymt_end_dt()).equals(paymentEndDate)){ // sortColl.add(sortCargo);
	 * // } // } // } // } // } catch (FwException fe) { // throw fe; // } catch
	 * (Exception e) { // FwException fe = createFwException(
	 * this.getClass().getName(), // "getHistoryCollection", e); // throw fe; //
	 * } // return sortColl; // }
	 *
	 * @param caseNum
	 *            the case num
	 * @param catCd
	 *            the cat cd
	 * @param elgInd
	 *            the elg ind
	 * @param pageMode
	 *            the page mode
	 * @param globalDate
	 *            the global date
	 * @return the history collection
	 */

	/**
	 * This method returns Individual Eligibility collection.
	 *
	 * @param caseNum
	 * @param catCd
	 * @param elgInd
	 * @param pageMode
	 * @param globalDate
	 * @return
	 */

	public CUST_INDV_ELG_Collection getHistoryCollection(final String caseNum,
			final String catCd, final String elgInd, final String pageMode,
			final Date globalDate) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getHistoryCollection() - START");

		final CUST_INDV_ELG_Collection sortColl = new CUST_INDV_ELG_Collection();
		CUST_INDV_ELG_Cargo sortCargo = null;
		try {

			final Date pymtEndMth = dateRoutine.getEndOfMonth(globalDate);
			final Date currentDate = fwDate.getDate();
			CUST_INDV_ELG_Collection custIndvHistColl = null;
			if (pymtEndMth.compareTo(currentDate) > 0) {
				if (AppConstants.INELIGIBLE.equals(elgInd)) {

					custIndvHistColl = getSummaryIneligibleGroupingForNextMonth(
							caseNum, AppConstants.INELIGIBLE);
				} else if (AppConstants.INDVINELIGIBLE.equals(elgInd)) {

					custIndvHistColl = getSummaryIndivIneligibleGroupingForNextMonth(
							caseNum, AppConstants.INDVINELIGIBLE);

				} else {
					custIndvHistColl = getSummaryGroupingForNextMonth(caseNum,
							AppConstants.ELIGIBLE);
				}
			} else if (AppConstants.INELIGIBLE.equals(elgInd)) {

				custIndvHistColl = getSummaryIneligibleGroupingForPreviousMonth(
						caseNum, AppConstants.ELIGIBLE);
			} else if (AppConstants.INDVINELIGIBLE.equals(elgInd)) {

				custIndvHistColl = getSummaryIndivIneligibleGroupingForPreviousMonth(
						caseNum, AppConstants.INDVINELIGIBLE);

			} else {

				custIndvHistColl = getSummaryGroupingForPreviousMonth(caseNum,
						AppConstants.ELIGIBLE, catCd);

			}
			/*
			 * VG SONAR Cleanup - 08/25/2015 Changed Commented code block to
			 * javadoc
			 */
			/**
			 * // using this one i will get all months information //
			 * CUST_INDV_ELG_Collection custIndvHistColl = //
			 * this.getDetailGrouping(caseNum, catCd //
			 * ,elgInd,AppConstants.ELIGIBILITY_HISTORY); //
			 * CUST_INDV_ELG_Collection custIndvColl = //
			 * this.getDetailGrouping(caseNum, catCd //
			 * ,elgInd,AppConstants.ELIGIBILITY_CONFIRM); //
			 * CUST_INDV_ELG_Collection custIndvHistColl = //
			 * this.getSummaryGroupingForPreviousMonth(caseNum, //
			 * AppConstants.ELIGIBLE);
			 *
			 */
			final int histCollSize = custIndvHistColl.size();

			/*
			 * VG SONAR Cleanup - 08/25/2015 Deleted 1 lines Commented Code in
			 * this block
			 */

			if (AppConstants.HISTORY_MODE.equals(pageMode)) {
				for (int i = 0; i < histCollSize; i++) {
					sortCargo = custIndvHistColl.getResult(i);
					sortColl.add(sortCargo);
				}
				/*
				 * VG SONAR Cleanup - 08/25/2015 Changed Commented code block to
				 * javadoc
				 */
				/**
				 * for(int i =0; i < histCollSize;i++){ sortCargo =
				 * custIndvHistColl.getResult(i); //here i am doing payment
				 * begin date > end of current month and payment end date > end
				 * of current month
				 * if(dateRoutine.getDateFromTimeStamp(sortCargo
				 * .getPymt_end_dt()).compareTo(pymtEndMth) >=0 &&
				 * dateRoutine.getDateFromTimeStamp
				 * (sortCargo.getPymt_beg_dt()).compareTo(pymtEndMth)<=0){
				 * sortColl.add(sortCargo); } } for(int i =0; i < collSize;i++){
				 * sortCargo = custIndvColl.getResult(i); //here i am doing
				 * payment begin date > end of current month and payment end
				 * date > end of current month
				 * if(dateRoutine.getDateFromTimeStamp
				 * (sortCargo.getPymt_beg_dt()).compareTo(pymtEndMth)<=0){
				 * if(!checkRecords(sortColl,sortCargo)){
				 * sortColl.add(sortCargo); } } }
				 */
			}

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getHistoryCollection", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getHistoryCollection() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return sortColl;
	}

	/**
	 * This method returns Individual Eligibility collection.
	 *
	 * @param caseNum
	 *            the case num
	 * @param catCd
	 *            the cat cd
	 * @param elgInd
	 *            the elg ind
	 * @param pageMode
	 *            the page mode
	 * @param globalDate
	 *            the global date
	 * @return the history collection for manual issuance
	 */

	public CUST_INDV_ELG_Collection getHistoryCollectionForManualIssuance(
			final String caseNum, final String catCd, final String elgInd,
			final String pageMode, final Date globalDate) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"MyAccessBO.getHistoryCollectionForManualIssuance() - START");

		final CUST_INDV_ELG_Collection sortColl = new CUST_INDV_ELG_Collection();
		CUST_INDV_ELG_Cargo sortCargo = null;
		try {

			dateRoutine.getEndOfMonth(globalDate);
			fwDate.getDate();
			CUST_INDV_ELG_Collection custIndvHistColl = null;

			custIndvHistColl = getSummaryGroupingForPreviousMonthForManualIssuance(
					caseNum, AppConstants.ELIGIBLE, catCd);
			/*
			 * VG SONAR Cleanup - 08/25/2015 Changed Commented code block to
			 * javadoc
			 */
			/**
			 * // using this one i will get all months information //
			 * CUST_INDV_ELG_Collection custIndvHistColl = //
			 * this.getDetailGrouping(caseNum, catCd //
			 * ,elgInd,AppConstants.ELIGIBILITY_HISTORY); //
			 * CUST_INDV_ELG_Collection custIndvColl = //
			 * this.getDetailGrouping(caseNum, catCd //
			 * ,elgInd,AppConstants.ELIGIBILITY_CONFIRM); //
			 * CUST_INDV_ELG_Collection custIndvHistColl = //
			 * this.getSummaryGroupingForPreviousMonth(caseNum, //
			 * AppConstants.ELIGIBLE);
			 *
			 */
			final int histCollSize = custIndvHistColl.size();

			/*
			 * VG SONAR Cleanup - 08/25/2015 Deleted 1 lines Commented Code in
			 * this block
			 */

			if (AppConstants.HISTORY_MODE.equals(pageMode)) {
				for (int i = 0; i < histCollSize; i++) {
					sortCargo = custIndvHistColl.getResult(i);
					sortColl.add(sortCargo);
				}
				/*
				 * VG SONAR Cleanup - 08/25/2015 Changed Commented code block to
				 * javadoc
				 */
				/**
				 * for(int i =0; i < histCollSize;i++){ sortCargo =
				 * custIndvHistColl.getResult(i); //here i am doing payment
				 * begin date > end of current month and payment end date > end
				 * of current month
				 * if(dateRoutine.getDateFromTimeStamp(sortCargo
				 * .getPymt_end_dt()).compareTo(pymtEndMth) >=0 &&
				 * dateRoutine.getDateFromTimeStamp
				 * (sortCargo.getPymt_beg_dt()).compareTo(pymtEndMth)<=0){
				 * sortColl.add(sortCargo); } } for(int i =0; i < collSize;i++){
				 * sortCargo = custIndvColl.getResult(i); //here i am doing
				 * payment begin date > end of current month and payment end
				 * date > end of current month
				 * if(dateRoutine.getDateFromTimeStamp
				 * (sortCargo.getPymt_beg_dt()).compareTo(pymtEndMth)<=0){
				 * if(!checkRecords(sortColl,sortCargo)){
				 * sortColl.add(sortCargo); } } }
				 */
			}

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getHistoryCollection", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getHistoryCollectionForManualIssuance() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return sortColl;
	}

	/**
	 * check the history records.
	 *
	 * @param sortColl
	 *            the sort coll
	 * @param sortCargo
	 *            the sort cargo
	 * @return true, if successful
	 */

	public boolean checkRecords(final CUST_INDV_ELG_Collection sortColl,
			final CUST_INDV_ELG_Cargo sortCargo) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.checkRecords() - START");
		boolean flag = false;
		try {
			final int size = sortColl.size();
			CUST_INDV_ELG_Cargo chkCargo = null;
			for (int i = 0; i < size; i++) {
				chkCargo = sortColl.getResult(i);
				if (chkCargo.getCat_cd().equals(sortCargo.getCat_cd())
						&& chkCargo.getScat_seq_num().equals(
								chkCargo.getScat_seq_num())
						&& "9".equals(chkCargo.getCur_elg_ind())) {
					flag = true;
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"checkRecords", e);
		}
		log(ILog.INFO, "MyAccessBO.checkRecords() - END , Time Taken : "
				+ (System.currentTimeMillis() - startTime) + " milliseconds");
		return flag;
	}

	/**
	 * This method returns found message.
	 *
	 * @param message
	 *            the message
	 * @param msgCode
	 *            the msg code
	 * @return true, if successful
	 */

	public boolean findMessage(final String message, final String msgCode) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.findMessage() - START");
		final int msgLen = message.length();
		boolean foundFlag = false;
		String fullMessage = null;
		try {
			if (msgLen > 0) {
				int i = 5;
				while (msgLen >= i) {
					fullMessage = message.substring(i - 5, i);
					i = i + 5;
					if (fullMessage.equals(msgCode)) {
						foundFlag = true;
					}
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"findMessage", e);
		}
		log(ILog.INFO, "MyAccessBO.findMessage() - END , Time Taken : "
				+ (System.currentTimeMillis() - startTime) + " milliseconds");
		return foundFlag;
	}

	/**
	 * This method count tildas.
	 *
	 * @param message
	 *            the message
	 * @return the int
	 */

	public int countTildas(final String message) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.countTildas() - START");
		final int length = message.length();
		int count = 0;
		try {
			for (int i = 0; i < length; i++) {
				final String aa = message.substring(i, i + 1);
				// As the string comparision is expensive doing character
				// comparision
				if (aa.charAt(0) == '~') {
					count++;
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"countTildas", e);
		}
		log(ILog.INFO, "MyAccessBO.countTildas() - END , Time Taken : "
				+ (System.currentTimeMillis() - startTime) + " milliseconds");
		return count;
	}

	/**
	 * Split month string.
	 *
	 * @param monthString
	 *            the month string
	 * @return the list
	 */

	public List splitMonthString(String monthString) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.splitMonthString() - START");
		List historyMonthList = null;
		try {
			historyMonthList = new ArrayList();
			monthString = monthString.replace('[', ' ');
			monthString = monthString.replace(']', ' ');
			final String[] result = monthString.split(",");
			final int size = result.length;
			for (int i = 0; i < size; i++) {
				if ("null".equals(result[i].trim())) {
					historyMonthList.add(i, null);
				} else {
					historyMonthList.add(i, result[i].trim());
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"splitMonthString", e);
		}
		log(ILog.INFO, "MyAccessBO.splitMonthString() - END , Time Taken : "
				+ (System.currentTimeMillis() - startTime) + " milliseconds");
		return historyMonthList;
	}

	/**
	 * for helthcare we need to pass list.
	 *
	 * @param mciId
	 *            the mci id
	 * @param categoryCd
	 *            the category cd
	 * @return the other history month indicator
	 */

	public List getOtherHistoryMonthIndicator(final String mciId,
			final String categoryCd) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getOtherHistoryMonthIndicator() - START");
		// this onw we need to pass through

		Date hist0Month = null;
		Date hist1Month = null;
		Date hist2Month = null;
		Date hist3Month = null;
		Date[] paymentDates = null;

		List monthList = null;
		try {
			final Date currentDate = fwDate.getDate();
			if (categoryCd != null) {
				
				final int count = getOtherHistoryMonthsCount(mciId, categoryCd,
						currentDate);
				if (count > 0) {
					// if we have two history months
					if (count > 1) {
						// this is the current month name
						hist0Month = dateRoutine.addMonthToDate(currentDate, 2);
						// this one set the first history month
						hist1Month = currentDate;
						// this one sets the secound history month
						hist2Month = dateRoutine.addMonthToDate(currentDate, 1);
					// if we have one history month
					} else if (count == 1) {
						// here we are getting the history months using query
						paymentDates = getOtherHistoryMonths(mciId, categoryCd,
								currentDate);
						if (paymentDates != null) {
							// if payment end date == current date
							if (paymentDates[1].getMonth() == currentDate
									.getMonth()) {
								hist1Month = paymentDates[1];
								hist0Month = dateRoutine.addMonthToDate(
										paymentDates[1], 1);
							} else if (paymentDates[1].getMonth() > currentDate
									.getMonth()) {
								if (paymentDates[1].getMonth() != paymentDates[0]
										.getMonth()) {
									hist0Month = dateRoutine.addMonthToDate(
											currentDate, 2);
									hist1Month = currentDate;
									hist3Month = paymentDates[1];
								} else {
									hist0Month = dateRoutine.addMonthToDate(
											paymentDates[1], 1);
									hist1Month = paymentDates[1];
								}
							} else {
								hist0Month = dateRoutine.addMonthToDate(
										currentDate, 1);
								hist1Month = paymentDates[1];
							}
						}
					}
					monthList = new ArrayList();
					monthList.add(0, hist0Month);
					monthList.add(1, hist1Month);
					monthList.add(2, hist2Month);
					monthList.add(3, hist3Month);
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getOtherHistoryMonthIndicator", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getOtherHistoryMonthIndicator() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return monthList;
	}

	/**
	 * Gets the other history months.
	 *
	 * @param mciId
	 *            the mci id
	 * @param catCd
	 *            the cat cd
	 * @param currentDate
	 *            the current date
	 * @return the other history months
	 */

	// OTHER HEALTH CARE DETAILS END
	// this method for getting the history months
	public Date[] getOtherHistoryMonths(final String mciId, final String catCd,
			final Date currentDate) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getOtherHistoryMonths() - START");
		final Map sqlMap = new HashMap();
		final Date[] pymtDate = new Date[2];
		String catCdFull = null;
		if (AppConstants.HEALTH_CARE_M13.equals(catCd)) {
			catCdFull = AppConstants.HEALTH_CARE_M13/* +"%" */;
		} else if (AppConstants.HEALTH_CARE_M14.equals(catCd)) {
			catCdFull = AppConstants.HEALTH_CARE_M14/* +"%" */;
		}

		try {
			sqlMap.put(FwConstants.SQL_IND, "sql-IC105");
			final FwDataCriteria[] criteria = new FwDataCriteria[3];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_value(mciId);
			criteria[0].setData_type(FwConstants.LONG);
			criteria[1] = new FwDataCriteria();
			criteria[1].setColumn_value(catCdFull);
			criteria[1].setData_type(FwConstants.STRING);
			criteria[2] = new FwDataCriteria();
			criteria[2].setColumn_value(currentDate.toString());
			criteria[2].setData_type(FwConstants.DATE);
			sqlMap.put(FwConstants.CRITERIA, criteria);
			final List res = executeSQL(sqlMap);
			if (null != res && !res.isEmpty()) {
				final Map cargo = (Map) res.get(0);
				pymtDate[0] = dateRoutine.getDateFromTimeStamp((String) cargo
						.get("EFF_BEG_DT"));
				pymtDate[1] = dateRoutine.getDateFromTimeStamp((String) cargo
						.get("EFF_END_DT"));
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getOtherHistoryMonths", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getOtherHistoryMonths() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return pymtDate;
	}

	/**
	 * Gets the other history months count.
	 *
	 * @param mciId
	 *            the mci id
	 * @param catCd
	 *            the cat cd
	 * @param currentDate
	 *            the current date
	 * @return the other history months count
	 */

	// OTHER HEALTH CARE HIST START
	// this method for the pend records
	public int getOtherHistoryMonthsCount(final String mciId,
			final String catCd, final Date currentDate) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getOtherHistoryMonthsCount() - START");
		final Map sqlMap = new HashMap();
		int count = 0;
		String catCdFull = null;
		if (AppConstants.HEALTH_CARE_M13.equals(catCd)) {
			catCdFull = AppConstants.HEALTH_CARE_M13/* +"%" */;
		} else if (AppConstants.HEALTH_CARE_M14.equals(catCd)) {
			catCdFull = AppConstants.HEALTH_CARE_M14/* +"%" */;
		}

		try {
			sqlMap.put(FwConstants.SQL_IND, "sql-IC104");
			final FwDataCriteria[] criteria = new FwDataCriteria[3];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_value(mciId);
			criteria[0].setData_type(FwConstants.LONG);
			criteria[1] = new FwDataCriteria();
			criteria[1].setColumn_value(catCdFull);
			criteria[1].setData_type(FwConstants.STRING);
			criteria[2] = new FwDataCriteria();
			criteria[2].setColumn_value(currentDate.toString());
			criteria[2].setData_type(FwConstants.DATE);
			sqlMap.put(FwConstants.CRITERIA, criteria);
			final List res = executeSQL(sqlMap);
			if (null != res && !res.isEmpty()) {
				final Map cargo = (Map) res.get(0);
				count = Integer
						.parseInt((String) cargo.get("HIST_MONTH_COUNT"));
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getOtherHistoryMonthsCount", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getOtherHistoryMonthsCount() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return count;
	}

	/**
	 * Padding numbers.
	 *
	 * @param number
	 *            the number
	 * @param length
	 *            the length
	 * @return the string
	 */

	// Method prefixes '0' for a specified length
	public String paddingNumbers(String number, final int length) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.paddingNumbers() - START");
		try {
			final int caseLength = number.length();
			StringBuilder paddedCase = null;
			// Zero pading(Leading)
			if (caseLength < length) {
				paddedCase = new StringBuilder();
				for (int m = 0; m < (length - caseLength); m++) {
					paddedCase.append("0");
				}
				number = paddedCase.append(number).toString();
			}
			log(ILog.INFO, "MyAccessBO.paddingNumbers() - END , Time Taken : "
					+ (System.currentTimeMillis() - startTime)
					+ " milliseconds");
			return number;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"paddingNumbers", e);
		}
	}

	/**
	 * This method prepares string from a given list.
	 *
	 * @param aList
	 *            list
	 * @return converted list to string
	 */

	public String convertListToString(final List aList) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.convertListToString() - START");
		String str = null;
		try {
			final StringBuilder mciIdBuffer = new StringBuilder();
			if (null != aList && !aList.isEmpty()) {
				int k = 0;
				while (k < aList.size()) {
					mciIdBuffer.append(aList.get(k));
					mciIdBuffer.append(',');
					k++;
				}
			}
			final int len = mciIdBuffer.toString().length();
			// removing extra ,
			if (len > 0) {
				str = mciIdBuffer.substring(0, len - 1);
			}

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"convertListToString", e);
		}
		log(ILog.INFO, "MyAccessBO.convertListToString() - END , Time Taken : "
				+ (System.currentTimeMillis() - startTime) + " milliseconds");
		return str;
	}

	/**
	 * This methods returns true if the supplied category is in the below list.
	 *
	 * @param aCategory
	 *            category
	 * @return true if the supplied category
	 */

	public boolean isInICCategory(final String aCategory) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.isInICCategory() - START");
		boolean categoryExist = false;
		try {
			final List icCatList = new ArrayList();
			icCatList.add(AppConstants.HEALTH_CARE_M13);
			icCatList.add(AppConstants.HEALTH_CARE_M14);
			icCatList.add(AppConstants.HEALTH_CARE_M15);
			icCatList.add(AppConstants.HEALTH_CARE_M16);
			icCatList.add(AppConstants.HEALTH_CARE_M17);
			icCatList.add(AppConstants.HEALTH_CARE_M18);
			icCatList.add(AppConstants.HEALTH_CARE_M19);
			icCatList.add(AppConstants.HEALTH_CARE_M20);
			icCatList.add(AppConstants.HEALTH_CARE_M21);
			icCatList.add(AppConstants.HEALTH_CARE_M22);
			icCatList.add(AppConstants.HEALTH_CARE_M23);
			icCatList.add(AppConstants.HEALTH_CARE_M24);
			icCatList.add(AppConstants.HEALTH_CARE_M25);
			if ((aCategory != null) && icCatList.contains(aCategory)) {
				categoryExist = true;
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"isInICCategory", e);
		}
		log(ILog.INFO, "MyAccessBO.isInICCategory() - END , Time Taken : "
				+ (System.currentTimeMillis() - startTime) + " milliseconds");
		return categoryExist;
	}

	/**
	 * This method returns Individual Eligibility collection. This one for the
	 * summary page(Eligable, InEligable, IndividualInEligable)
	 *
	 * @param caseNum
	 *            case number
	 * @param elgInd
	 *            eligibility indicator
	 * @return Individual Eligibility collection
	 */

	public CUST_INDV_ELG_Collection getIVRSummaryElgColl(final String caseNum,
			final String elgInd) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getIVRSummaryElgColl() - START");
		final Map sqlMap = new HashMap();
		final CUST_INDV_ELG_Collection custIndvElgCollection = new CUST_INDV_ELG_Collection();
		try {
			if ((elgInd != null) && (caseNum != null)) {
				sqlMap.put(FwConstants.SQL_IND, "sql-247");
				final FwDataCriteria[] criteria = new FwDataCriteria[4];
				criteria[0] = new FwDataCriteria();
				criteria[0].setColumn_value(caseNum);
				criteria[0].setData_type(FwConstants.LONG);
				criteria[1] = new FwDataCriteria();
				criteria[1].setColumn_value(elgInd);
				criteria[1].setData_type(FwConstants.STRING);
				Date currentDate = fwDate.getDate();

				currentDate.setDate(1);
				currentDate.setMonth(currentDate.getMonth() + 1);
				currentDate.setDate(currentDate.getDate() - 1);
				// added for FAP amt
				criteria[2] = new FwDataCriteria();
				criteria[2].setColumn_value(currentDate.toString());
				criteria[2].setData_type(FwConstants.STRING);
				currentDate = fwDate.getDate();
				currentDate.setDate(1);
				// added for FAP amt
				criteria[3] = new FwDataCriteria();
				criteria[3].setColumn_value(currentDate.toString());
				criteria[3].setData_type(FwConstants.STRING);

				sqlMap.put(FwConstants.CRITERIA, criteria);
				final List res = executeSQL(sqlMap);
				if (null != res && !res.isEmpty()) {
					final CUST_INDV_ELG_Cargo[] custElgCargo = new CUST_INDV_ELG_Cargo[res
							.size()];

					for (int i = 0; i < res.size(); i++) {
						final Map cargo = (Map) res.get(i);
						custElgCargo[i] = new CUST_INDV_ELG_Cargo();
						custElgCargo[i].setMci_id((String) cargo.get("MCI_ID"));
						custElgCargo[i].setBnft_pin_num((String) cargo
								.get("BNFT_PIN_NUM"));
						custElgCargo[i].setBnft_case_num((String) cargo
								.get("BNFT_CASE_NUM"));
						custElgCargo[i].setCat_cd((String) cargo.get("CAT_CD"));
						custElgCargo[i].setScat_cd((String) cargo
								.get("SCAT_CD"));
						custElgCargo[i].setScat_seq_num((String) cargo
								.get("SCAT_SEQ_NUM"));
						custElgCargo[i].setCur_elg_ind((String) cargo
								.get("CUR_ELG_IND"));
						custElgCargo[i].setBnft_stat_cd((String) cargo
								.get("BNFT_STAT_CD"));
						custElgCargo[i].setCnfm_dt((String) cargo
								.get("CNFM_DT"));
						custElgCargo[i].setElg_beg_dt((String) cargo
								.get("ELG_BEG_DT"));
						custElgCargo[i].setElg_end_dt((String) cargo
								.get("ELG_END_DT"));
						custElgCargo[i].setElg_ind((String) cargo
								.get("ELG_IND"));
						custElgCargo[i].setMa_ddct_bal_amt((String) cargo
								.get("MA_DDCT_BAL_AMT"));
						custElgCargo[i].setPymt_amt((String) cargo
								.get("PYMT_AMT"));
						custElgCargo[i].setPymt_beg_dt((String) cargo
								.get("PYMT_BEG_DT"));
						custElgCargo[i].setPymt_end_dt((String) cargo
								.get("PYMT_END_DT"));
						custElgCargo[i].setPymt_typ((String) cargo
								.get("PYMT_TYP"));
						custElgCargo[i].setSc_bnft_lvl_cd((String) cargo
								.get("SC_BNFT_LVL_CD"));
						custElgCargo[i].setUpdt_dt((String) cargo
								.get("UPDT_DT"));
						custElgCargo[i].setVfcn_due_dt((String) cargo
								.get("VFCN_DUE_DT"));
						custElgCargo[i].setMsg_cd_txt((String) cargo
								.get("MSG_CD_TXT"));
						custElgCargo[i].setFst_nam(cargo.get("FST_NAM")
								.toString().trim());
						custElgCargo[i].setSex_ind((String) cargo
								.get("SEX_IND"));
						custElgCargo[i].setPgm_rqst_sw((String) cargo
								.get("PGM_RQST_SW"));
						custElgCargo[i].setOrg_elg_ind((String) cargo
								.get("ORIG_ELG_IND"));
						custElgCargo[i].setNf_fail_rsn_1_cd((String) cargo
								.get("NF_FAIL_RSN_1_CD"));
						custElgCargo[i].setPrev_sc_bnft_l_cd((String) cargo
								.get("PREV_SC_BNFT_L_CD"));
						custElgCargo[i].setBrth_dt((String) cargo
								.get("BRTH_DT"));
						custElgCargo[i].setEmpl_vfcn_due_dt((String) cargo
								.get("EMPL_VFCN_DUE_DT"));
						custElgCargo[i].setIns_vfcn_due_dt((String) cargo
								.get("INS_VFCN_DUE_DT"));
						custElgCargo[i].setSmirf_mo((String) cargo
								.get("SMIRF_MO"));
					}
					custIndvElgCollection.setResults(custElgCargo);
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getSummaryGrouping", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getIVRSummaryElgColl() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return custIndvElgCollection;
	}

	/**
	 * This method returns Individual Eligibility collection.
	 *
	 * @param caseNum
	 *            case number
	 * @param elgInd
	 *            eligibility indicator
	 * @return Individual Eligibility collection
	 */

	// this one for the summary page(Eligable, InEligable, IndividualInEligable)
	public CUST_INDV_ELG_Collection getSummaryElgColl(final String caseNum,
			final String elgInd) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getSummaryElgColl() - START");
		final Map sqlMap = new HashMap();
		final CUST_INDV_ELG_Collection custIndvElgCollection = new CUST_INDV_ELG_Collection();
		try {
			if ((elgInd != null) && (caseNum != null)) {
				sqlMap.put(FwConstants.SQL_IND, "sql-234");
				final FwDataCriteria[] criteria = new FwDataCriteria[2];
				criteria[0] = new FwDataCriteria();
				criteria[0].setColumn_value(caseNum);
				criteria[0].setData_type(FwConstants.LONG);
				criteria[1] = new FwDataCriteria();
				criteria[1].setColumn_value(elgInd);
				criteria[1].setData_type(FwConstants.STRING);
				sqlMap.put(FwConstants.CRITERIA, criteria);
				final List res = executeSQL(sqlMap);
				if (null != res && !res.isEmpty()) {
					final CUST_INDV_ELG_Cargo[] custElgCargo = new CUST_INDV_ELG_Cargo[res
							.size()];

					for (int i = 0; i < res.size(); i++) {
						final Map cargo = (Map) res.get(i);
						custElgCargo[i] = new CUST_INDV_ELG_Cargo();
						custElgCargo[i].setMci_id((String) cargo.get("MCI_ID"));
						custElgCargo[i].setBnft_pin_num((String) cargo
								.get("BNFT_PIN_NUM"));
						custElgCargo[i].setBnft_case_num((String) cargo
								.get("BNFT_CASE_NUM"));
						custElgCargo[i].setCat_cd((String) cargo.get("CAT_CD"));
						custElgCargo[i].setScat_cd((String) cargo
								.get("SCAT_CD"));
						custElgCargo[i].setScat_seq_num((String) cargo
								.get("SCAT_SEQ_NUM"));
						custElgCargo[i].setCur_elg_ind((String) cargo
								.get("CUR_ELG_IND"));
						custElgCargo[i].setBnft_stat_cd((String) cargo
								.get("BNFT_STAT_CD"));
						custElgCargo[i].setCnfm_dt((String) cargo
								.get("CNFM_DT"));
						custElgCargo[i].setElg_beg_dt((String) cargo
								.get("ELG_BEG_DT"));
						custElgCargo[i].setElg_end_dt((String) cargo
								.get("ELG_END_DT"));
						custElgCargo[i].setElg_ind((String) cargo
								.get("ELG_IND"));
						custElgCargo[i].setMa_ddct_bal_amt((String) cargo
								.get("MA_DDCT_BAL_AMT"));
						custElgCargo[i].setPymt_amt((String) cargo
								.get("PYMT_AMT"));
						custElgCargo[i].setPymt_beg_dt((String) cargo
								.get("PYMT_BEG_DT"));
						custElgCargo[i].setPymt_end_dt((String) cargo
								.get("PYMT_END_DT"));
						custElgCargo[i].setPymt_typ((String) cargo
								.get("PYMT_TYP"));
						custElgCargo[i].setSc_bnft_lvl_cd((String) cargo
								.get("SC_BNFT_LVL_CD"));
						custElgCargo[i].setUpdt_dt((String) cargo
								.get("UPDT_DT"));
						custElgCargo[i].setVfcn_due_dt((String) cargo
								.get("VFCN_DUE_DT"));
						custElgCargo[i].setMsg_cd_txt((String) cargo
								.get("MSG_CD_TXT"));
						custElgCargo[i].setFst_nam(cargo.get("FST_NAM")
								.toString().trim());
						custElgCargo[i].setSex_ind((String) cargo
								.get("SEX_IND"));
						custElgCargo[i].setPgm_rqst_sw((String) cargo
								.get("PGM_RQST_SW"));
						custElgCargo[i].setOrg_elg_ind((String) cargo
								.get("ORIG_ELG_IND"));
						custElgCargo[i].setNf_fail_rsn_1_cd((String) cargo
								.get("NF_FAIL_RSN_1_CD"));
						custElgCargo[i].setPrev_sc_bnft_l_cd((String) cargo
								.get("PREV_SC_BNFT_L_CD"));
						custElgCargo[i].setBrth_dt((String) cargo
								.get("BRTH_DT"));
						custElgCargo[i].setEmpl_vfcn_due_dt((String) cargo
								.get("EMPL_VFCN_DUE_DT"));
						custElgCargo[i].setIns_vfcn_due_dt((String) cargo
								.get("INS_VFCN_DUE_DT"));
						custElgCargo[i].setSmirf_mo((String) cargo
								.get("SMIRF_MO"));
						custElgCargo[i].setMid_cert_review_date((String) cargo
								.get("MID_CERT_REVIEW_DT"));
						custElgCargo[i]
								.setSemi_annual_review_date((String) cargo
										.get("SEMI_ANNUAL_REVIEW_DT"));
						custElgCargo[i].setReview_dt((String) cargo
								.get("REVIEW_DT"));
						if (cargo.get("SER_AUTH_DT") != null) {

							custElgCargo[i].setSer_auth_dt(cargo
									.get("SER_AUTH_DT").toString().trim());

						} else {

							custElgCargo[i].setSer_auth_dt(" ");
						}
					}
					custIndvElgCollection.setResults(custElgCargo);
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getSummaryGrouping", e);
		}
		log(ILog.INFO, "MyAccessBO.getSummaryElgColl() - END , Time Taken : "
				+ (System.currentTimeMillis() - startTime) + " milliseconds");
		return custIndvElgCollection;
	}

	/**
	 * This method returns FAP Payment Amount.
	 *
	 * @param caseNum
	 *            case number
	 * @param endOftheMonth
	 *            end of the month
	 * @param beginOftheMonth
	 *            begin of the month
	 * @return FAP amount
	 */

	public String getIVRFAPPaymentAmount(final String caseNum,
			final Date endOftheMonth, final Date beginOftheMonth) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getIVRFAPPaymentAmount() - START");

		// hit the fap amt table using the case num,catcd and dates.
		// get the values in a clolection.
		// cargo getpymtn amt
		// return payment amiunt
		final Map sqlMap = new HashMap();
		String fapAmntForCase = null;
		try {
			sqlMap.put(FwConstants.SQL_IND, "sql-ivr-240");
			final FwDataCriteria[] criteria = new FwDataCriteria[3];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_value(caseNum);
			criteria[0].setData_type(FwConstants.LONG);

			criteria[1] = new FwDataCriteria();
			criteria[1].setColumn_value(endOftheMonth.toString());
			criteria[1].setData_type(FwConstants.STRING);

			criteria[2] = new FwDataCriteria();
			criteria[2].setColumn_value(beginOftheMonth.toString());
			criteria[2].setData_type(FwConstants.STRING);

			sqlMap.put(FwConstants.CRITERIA, criteria);
			final List res = executeSQL(sqlMap);
			if (null != res && !res.isEmpty()) {
				for (int i = 0; i < res.size(); i++) {
					final Map cargo = (Map) res.get(i);
					fapAmntForCase = (String) cargo.get("TOTAL_AMT");
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getFAPPaymentAmount", e);
		}

		log(ILog.INFO,
				"MyAccessBO.getIVRFAPPaymentAmount() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return fapAmntForCase;
	}

	/**
	 * This method returns FAP Payment Amount.
	 *
	 * @param caseNum
	 *            case number
	 * @param endOftheMonth
	 *            end of the month
	 * @param beginOftheMonth
	 *            begin of the month
	 * @return FAP amount
	 */

	public String getFAPPaymentAmount(final String caseNum,
			final Date endOftheMonth, final Date beginOftheMonth) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getFAPPaymentAmount() - START");
		// hit the fap amt table using the case num,catcd and dates.
		// get the values in a clolection.
		// cargo getpymtn amt
		// return payment amiunt
		final Map sqlMap = new HashMap();
		String fapAmntForCase = null;
		try {
			sqlMap.put(FwConstants.SQL_IND, "sql-240");
			final FwDataCriteria[] criteria = new FwDataCriteria[3];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_value(caseNum);
			criteria[0].setData_type(FwConstants.LONG);

			criteria[1] = new FwDataCriteria();
			criteria[1].setColumn_value(endOftheMonth.toString());
			criteria[1].setData_type(FwConstants.STRING);

			criteria[2] = new FwDataCriteria();
			criteria[2].setColumn_value(beginOftheMonth.toString());
			criteria[2].setData_type(FwConstants.STRING);

			sqlMap.put(FwConstants.CRITERIA, criteria);
			final List res = executeSQL(sqlMap);
			if (null != res && !res.isEmpty()) {
				for (int i = 0; i < res.size(); i++) {
					final Map cargo = (Map) res.get(i);
					fapAmntForCase = (String) cargo.get("TOTAL_AMT");
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getFAPPaymentAmount", e);
		}

		log(ILog.INFO, "MyAccessBO.getFAPPaymentAmount() - END , Time Taken : "
				+ (System.currentTimeMillis() - startTime) + " milliseconds");
		return fapAmntForCase;
	}

	/**
	 * This method returns Individual Eligibility collection.
	 *
	 * @param caseNum
	 *            case number
	 * @return Individual Eligibility collection
	 */

	public CUST_INDV_ELG_Collection getManualIssuanceCollection(
			final String caseNum) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getManualIssuanceCollection() - START");
		final Map sqlMap = new HashMap();
		final CUST_INDV_ELG_Collection custIndvElgColl = new CUST_INDV_ELG_Collection();
		try {

			sqlMap.put(FwConstants.SQL_IND, "sql-249");
			final FwDataCriteria[] criteria = new FwDataCriteria[3];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_value(caseNum);
			criteria[0].setData_type(FwConstants.LONG);
			Date currentDate = fwDate.getDate();
			currentDate.setDate(1);
			currentDate.setMonth(currentDate.getMonth() + 1);
			currentDate.setDate(currentDate.getDate() - 1);

			// added for FAP amt
			criteria[1] = new FwDataCriteria();
			criteria[1].setColumn_value(currentDate.toString());
			criteria[1].setData_type(FwConstants.STRING);
			currentDate = fwDate.getDate();
			currentDate.setDate(1);
			// added for FAP amt
			criteria[2] = new FwDataCriteria();
			criteria[2].setColumn_value(currentDate.toString());
			criteria[2].setData_type(FwConstants.STRING);
			sqlMap.put(FwConstants.CRITERIA, criteria);
			final List res = executeSQL(sqlMap);

			if (null != res && !res.isEmpty()) {
				final CUST_INDV_ELG_Cargo[] custIndvElgCargo = new CUST_INDV_ELG_Cargo[res
						.size()];

				for (int i = 0; i < res.size(); i++) {
					final Map cargo = (Map) res.get(i);
					custIndvElgCargo[i] = new CUST_INDV_ELG_Cargo();
					custIndvElgCargo[i].setPymt_amt((String) cargo
							.get("TOTAL_AMT"));
					custIndvElgCargo[i].setCat_cd((String) cargo.get("CAT_CD"));
					custIndvElgCargo[i].setBnft_case_num((String) cargo
							.get("BNFT_CASE_NUM"));
					custIndvElgCargo[i].setFst_nam((String) cargo
							.get("FST_NAM"));
					custIndvElgCargo[i].setSex_ind((String) cargo
							.get("SEX_IND"));
					custIndvElgCargo[i].setBrth_dt((String) cargo
							.get("BRTH_DT"));

				}
				custIndvElgColl.setResults(custIndvElgCargo);
			}

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getManualIssuanceCollection", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getManualIssuanceCollection() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return custIndvElgColl;
	}

	/**
	 * This method returns Individual Eligibility collection.
	 *
	 * @param caseNum
	 *            case number
	 * @param serviceCd
	 *            service code
	 * @param sCatSeqNum
	 *            category sequence number
	 * @return Individual Eligibility collection
	 */

	public CUST_INDV_ELG_Collection getManualIssuanceForSerCollection(
			final String caseNum, final String serviceCd,
			final String sCatSeqNum) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getManualIssuanceForSerCollection() - START");
		final Map sqlMap = new HashMap();
		final CUST_INDV_ELG_Collection custIndvElgColl = new CUST_INDV_ELG_Collection();
		try {

			sqlMap.put(FwConstants.SQL_IND, "sql-266");
			final FwDataCriteria[] criteria = new FwDataCriteria[3];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_value(caseNum);
			criteria[0].setData_type(FwConstants.LONG);

			criteria[1] = new FwDataCriteria();
			criteria[1].setColumn_value(serviceCd);
			criteria[1].setData_type(FwConstants.STRING);

			criteria[2] = new FwDataCriteria();
			criteria[2].setColumn_value(sCatSeqNum);
			criteria[2].setData_type(FwConstants.STRING);

			sqlMap.put(FwConstants.CRITERIA, criteria);
			final List res = executeSQL(sqlMap);
	
			if (null != res && !res.isEmpty()) {
				final CUST_INDV_ELG_Cargo[] custIndvElgCargo = new CUST_INDV_ELG_Cargo[res
						.size()];

				for (int i = 0; i < res.size(); i++) {
					final Map cargo = (Map) res.get(i);
					custIndvElgCargo[i] = new CUST_INDV_ELG_Cargo();
					custIndvElgCargo[i].setRequested_date((String) cargo
							.get("REQUESTED_DATE"));
					custIndvElgCargo[i].setManual_issuance_amt((String) cargo
							.get("MANUAL_ISSUANCE_AMT"));
					custIndvElgCargo[i].setScat_cd((String) cargo
							.get("SERVICE_CD"));
					custIndvElgCargo[i].setProvider_id((String) cargo
							.get("PROVIDER_ID"));
					custIndvElgCargo[i].setBnft_case_num((String) cargo
							.get("BNFT_CASE_NUM"));
					custIndvElgCargo[i].setFst_nam((String) cargo
							.get("FST_NAM"));
					custIndvElgCargo[i].setSex_ind((String) cargo
							.get("SEX_IND"));
					custIndvElgCargo[i].setBrth_dt((String) cargo
							.get("BRTH_DT"));

				}
				custIndvElgColl.setResults(custIndvElgCargo);
			}

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getManualIssuanceCollection", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getManualIssuanceForSerCollection() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return custIndvElgColl;
	}

	/**
	 * This method returns display code.
	 *
	 * @param verCode
	 *            verification code
	 * @return display code
	 */

	public String getDisplayCode(final String verCode) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getDisplayCode() - START");
		final Map map = new HashMap();
		StringBuilder dplyCodeBuffer = null;
		try {
			map.put(FwConstants.SQL_IND, "sql-235");
			final FwDataCriteria[] criteria = new FwDataCriteria[1];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_value(verCode);
			criteria[0].setData_type(FwConstants.STRING);
			map.put(FwConstants.CRITERIA, criteria);
			final List res = executeSQL(map);
			dplyCodeBuffer = new StringBuilder();

			res.size();
			for (int i = 0; i < res.size(); i++) {
				final Map resMap = (Map) res.get(i);
				dplyCodeBuffer.append(resMap.get("TXT_ID").toString().trim())
						.append(" ");
			}

			log(ILog.INFO, "Display Code" + dplyCodeBuffer);

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getCaseDetails", e);
		}
		log(ILog.INFO, "MyAccessBO.getDisplayCode() - END , Time Taken : "
				+ (System.currentTimeMillis() - startTime) + " milliseconds");
		return dplyCodeBuffer.toString();
	}

	/**
	 * This method returns Individual Eligibility collection.
	 *
	 * @param caseNum
	 *            case number
	 * @param elgInd
	 *            eligibility indicator
	 * @return Individual Eligibility collection
	 */

	public CUST_INDV_ELG_Collection getSummaryIneligibleGroupingForPreviousMonth(
			final String caseNum, final String elgInd) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"MyAccessBO.getSummaryIneligibleGroupingForPreviousMonth() - START");
		final Map sqlMap = new HashMap();
		final CUST_INDV_ELG_Collection custIndvElgCollPreviousMonth = new CUST_INDV_ELG_Collection();
		try {
			if ((elgInd != null) && (caseNum != null)) {
				sqlMap.put(FwConstants.SQL_IND, "sql-242");
				final FwDataCriteria[] criteria = new FwDataCriteria[3];
				criteria[0] = new FwDataCriteria();
				criteria[0].setColumn_value(caseNum);
				criteria[0].setData_type(FwConstants.LONG);


				Date currentDate = fwDate.getDate();
				currentDate.setDate(1);
				currentDate.setDate(currentDate.getDate() - 1);
				final Date endOfMnth = currentDate;// added for FAP amt
				criteria[1] = new FwDataCriteria();
				criteria[1].setColumn_value(currentDate.toString());
				criteria[1].setData_type(FwConstants.STRING);

				currentDate = fwDate.getDate();
				currentDate.setDate(1);
				currentDate.setMonth(currentDate.getMonth() - 1);
				final Date beginOfMnth = currentDate;// added for FAP amt
				criteria[2] = new FwDataCriteria();
				criteria[2].setColumn_value(currentDate.toString());
				criteria[2].setData_type(FwConstants.STRING);
				sqlMap.put(FwConstants.CRITERIA, criteria);
				final String paymentAmount = getFAPPaymentAmount(caseNum,
						endOfMnth, beginOfMnth);// added
				// for
				// FAP
				// amt
				final List res = executeSQL(sqlMap);
				if (null != res && !res.isEmpty()) {
					final CUST_INDV_ELG_Cargo[] custIndvElgCargo = new CUST_INDV_ELG_Cargo[res
							.size()];

					for (int i = 0; i < res.size(); i++) {
						final Map cargo = (Map) res.get(i);
						custIndvElgCargo[i] = new CUST_INDV_ELG_Cargo();
						custIndvElgCargo[i].setMci_id((String) cargo
								.get("MCI_ID"));
						custIndvElgCargo[i].setBnft_pin_num((String) cargo
								.get("BNFT_PIN_NUM"));
						custIndvElgCargo[i].setBnft_case_num((String) cargo
								.get("BNFT_CASE_NUM"));
						custIndvElgCargo[i].setCat_cd((String) cargo
								.get("CAT_CD"));
						custIndvElgCargo[i].setScat_cd((String) cargo
								.get("SCAT_CD"));
						custIndvElgCargo[i].setScat_seq_num((String) cargo
								.get("SCAT_SEQ_NUM"));
						custIndvElgCargo[i].setCur_elg_ind((String) cargo
								.get("CUR_ELG_IND"));
						custIndvElgCargo[i].setBnft_stat_cd((String) cargo
								.get("BNFT_STAT_CD"));
						custIndvElgCargo[i].setCnfm_dt((String) cargo
								.get("CNFM_DT"));
						custIndvElgCargo[i].setElg_beg_dt((String) cargo
								.get("ELG_BEG_DT"));
						custIndvElgCargo[i].setElg_end_dt((String) cargo
								.get("ELG_END_DT"));
						custIndvElgCargo[i].setElg_ind((String) cargo
								.get("ELG_IND"));
						custIndvElgCargo[i].setMa_ddct_bal_amt((String) cargo
								.get("MA_DDCT_BAL_AMT"));
						if (paymentAmount != null) {
							custIndvElgCargo[i].setPymt_amt(paymentAmount);
						} else {
							custIndvElgCargo[i].setPymt_amt("0.00");
						}
						custIndvElgCargo[i].setPymt_beg_dt((String) cargo
								.get("PYMT_BEG_DT"));
						custIndvElgCargo[i].setPymt_end_dt((String) cargo
								.get("PYMT_END_DT"));
						custIndvElgCargo[i].setPymt_typ((String) cargo
								.get("PYMT_TYP"));
						custIndvElgCargo[i].setSc_bnft_lvl_cd((String) cargo
								.get("SC_BNFT_LVL_CD"));
						custIndvElgCargo[i].setUpdt_dt((String) cargo
								.get("UPDT_DT"));
						custIndvElgCargo[i].setVfcn_due_dt((String) cargo
								.get("VFCN_DUE_DT"));
						custIndvElgCargo[i].setMsg_cd_txt((String) cargo
								.get("MSG_CD_TXT"));
						custIndvElgCargo[i].setFst_nam(cargo.get("FST_NAM")
								.toString().trim());
						custIndvElgCargo[i].setSex_ind((String) cargo
								.get("SEX_IND"));
						custIndvElgCargo[i].setPgm_rqst_sw((String) cargo
								.get("PGM_RQST_SW"));
						custIndvElgCargo[i].setOrg_elg_ind((String) cargo
								.get("ORIG_ELG_IND"));
						custIndvElgCargo[i].setNf_fail_rsn_1_cd((String) cargo
								.get("NF_FAIL_RSN_1_CD"));
						custIndvElgCargo[i].setPrev_sc_bnft_l_cd((String) cargo
								.get("PREV_SC_BNFT_L_CD"));
						custIndvElgCargo[i].setBrth_dt((String) cargo
								.get("BRTH_DT"));
						custIndvElgCargo[i].setEmpl_vfcn_due_dt((String) cargo
								.get("EMPL_VFCN_DUE_DT"));
						custIndvElgCargo[i].setIns_vfcn_due_dt((String) cargo
								.get("INS_VFCN_DUE_DT"));
						custIndvElgCargo[i].setSmirf_mo((String) cargo
								.get("SMIRF_MO"));
						custIndvElgCargo[i]
								.setSemi_annual_review_date((String) cargo
										.get("SEMI_ANNUAL_REVIEW_DT"));
						custIndvElgCargo[i].setReview_dt((String) cargo
								.get("REVIEW_DT"));
						custIndvElgCargo[i]
								.setMid_cert_review_date((String) cargo
										.get("MID_CERT_REVIEW_DT"));
					}
					custIndvElgCollPreviousMonth.setResults(custIndvElgCargo);
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getSummaryGroupingForPreviousMonth", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getSummaryIneligibleGroupingForPreviousMonth() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return custIndvElgCollPreviousMonth;

	}

	/**
	 * This method returns Individual Eligibility collection .
	 *
	 * @param caseNum
	 *            case number
	 * @param elgInd
	 *            eligibility indicator
	 * @return Individual Eligibility collection
	 */

	public CUST_INDV_ELG_Collection getSummaryIndivIneligibleGroupingForPreviousMonth(
			final String caseNum, final String elgInd) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"MyAccessBO.getSummaryIndivIneligibleGroupingForPreviousMonth() - START");
		final Map sqlMap = new HashMap();
		final CUST_INDV_ELG_Collection custIndvElgCollPreviousMonth = new CUST_INDV_ELG_Collection();
		try {
			if ((elgInd != null) && (caseNum != null)) {
				sqlMap.put(FwConstants.SQL_IND, "sql-243");
				final FwDataCriteria[] criteria = new FwDataCriteria[3];
				criteria[0] = new FwDataCriteria();
				criteria[0].setColumn_value(caseNum);
				criteria[0].setData_type(FwConstants.LONG);
				Date currentDate = fwDate.getDate();
				currentDate.setDate(1);
				currentDate.setDate(currentDate.getDate() - 1);
				final Date endOfMnth = currentDate;// added for FAP amt
				criteria[1] = new FwDataCriteria();
				criteria[1].setColumn_value(currentDate.toString());
				criteria[1].setData_type(FwConstants.STRING);

				currentDate = fwDate.getDate();
				currentDate.setDate(1);
				currentDate.setMonth(currentDate.getMonth() - 1);
				final Date beginOfMnth = currentDate;// added for FAP amt
				criteria[2] = new FwDataCriteria();
				criteria[2].setColumn_value(currentDate.toString());
				criteria[2].setData_type(FwConstants.STRING);
				sqlMap.put(FwConstants.CRITERIA, criteria);
				final String paymentAmount = getFAPPaymentAmount(caseNum,
						endOfMnth, beginOfMnth);// added
				// for
				// FAP
				// amt
				final List res = executeSQL(sqlMap);
				if (null != res && !res.isEmpty()) {
					final CUST_INDV_ELG_Cargo[] custIndvElgCargo = new CUST_INDV_ELG_Cargo[res
							.size()];

					for (int i = 0; i < res.size(); i++) {
						final Map cargo = (Map) res.get(i);
						custIndvElgCargo[i] = new CUST_INDV_ELG_Cargo();
						custIndvElgCargo[i].setMci_id((String) cargo
								.get("MCI_ID"));
						custIndvElgCargo[i].setBnft_pin_num((String) cargo
								.get("BNFT_PIN_NUM"));
						custIndvElgCargo[i].setBnft_case_num((String) cargo
								.get("BNFT_CASE_NUM"));
						custIndvElgCargo[i].setCat_cd((String) cargo
								.get("CAT_CD"));
						custIndvElgCargo[i].setScat_cd((String) cargo
								.get("SCAT_CD"));
						custIndvElgCargo[i].setScat_seq_num((String) cargo
								.get("SCAT_SEQ_NUM"));
						custIndvElgCargo[i].setCur_elg_ind((String) cargo
								.get("CUR_ELG_IND"));
						custIndvElgCargo[i].setBnft_stat_cd((String) cargo
								.get("BNFT_STAT_CD"));
						custIndvElgCargo[i].setCnfm_dt((String) cargo
								.get("CNFM_DT"));
						custIndvElgCargo[i].setElg_beg_dt((String) cargo
								.get("ELG_BEG_DT"));
						custIndvElgCargo[i].setElg_end_dt((String) cargo
								.get("ELG_END_DT"));
						custIndvElgCargo[i].setElg_ind((String) cargo
								.get("ELG_IND"));
						custIndvElgCargo[i].setMa_ddct_bal_amt((String) cargo
								.get("MA_DDCT_BAL_AMT"));
						if (paymentAmount != null) {
							custIndvElgCargo[i].setPymt_amt(paymentAmount);
						} else {
							custIndvElgCargo[i].setPymt_amt("0.00");
						}
						custIndvElgCargo[i].setPymt_beg_dt((String) cargo
								.get("PYMT_BEG_DT"));
						custIndvElgCargo[i].setPymt_end_dt((String) cargo
								.get("PYMT_END_DT"));
						custIndvElgCargo[i].setPymt_typ((String) cargo
								.get("PYMT_TYP"));
						custIndvElgCargo[i].setSc_bnft_lvl_cd((String) cargo
								.get("SC_BNFT_LVL_CD"));
						custIndvElgCargo[i].setUpdt_dt((String) cargo
								.get("UPDT_DT"));
						custIndvElgCargo[i].setVfcn_due_dt((String) cargo
								.get("VFCN_DUE_DT"));
						custIndvElgCargo[i].setMsg_cd_txt((String) cargo
								.get("MSG_CD_TXT"));
						custIndvElgCargo[i].setFst_nam(cargo.get("FST_NAM")
								.toString().trim());
						custIndvElgCargo[i].setSex_ind((String) cargo
								.get("SEX_IND"));
						custIndvElgCargo[i].setPgm_rqst_sw((String) cargo
								.get("PGM_RQST_SW"));
						custIndvElgCargo[i].setOrg_elg_ind((String) cargo
								.get("ORIG_ELG_IND"));
						custIndvElgCargo[i].setNf_fail_rsn_1_cd((String) cargo
								.get("NF_FAIL_RSN_1_CD"));
						custIndvElgCargo[i].setPrev_sc_bnft_l_cd((String) cargo
								.get("PREV_SC_BNFT_L_CD"));
						custIndvElgCargo[i].setBrth_dt((String) cargo
								.get("BRTH_DT"));
						custIndvElgCargo[i].setEmpl_vfcn_due_dt((String) cargo
								.get("EMPL_VFCN_DUE_DT"));
						custIndvElgCargo[i].setIns_vfcn_due_dt((String) cargo
								.get("INS_VFCN_DUE_DT"));
						custIndvElgCargo[i].setSmirf_mo((String) cargo
								.get("SMIRF_MO"));
						custIndvElgCargo[i]
								.setSemi_annual_review_date((String) cargo
										.get("SEMI_ANNUAL_REVIEW_DT"));
						custIndvElgCargo[i].setReview_dt((String) cargo
								.get("REVIEW_DT"));
						custIndvElgCargo[i]
								.setMid_cert_review_date((String) cargo
										.get("MID_CERT_REVIEW_DT"));
					}
					custIndvElgCollPreviousMonth.setResults(custIndvElgCargo);
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getSummaryGroupingForPreviousMonth", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getSummaryIndivIneligibleGroupingForPreviousMonth() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return custIndvElgCollPreviousMonth;

	}

	/**
	 * This method returns Individual Eligibility collection .
	 *
	 * @param caseNum
	 *            case number
	 * @param elgInd
	 *            eligibility indicator
	 * @return Individual Eligibility collection
	 */

	public CUST_INDV_ELG_Collection getSummaryIndivIneligibleGroupingForNextMonth(
			final String caseNum, final String elgInd) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"MyAccessBO.getSummaryIndivIneligibleGroupingForNextMonth() - START");
		final Map sqlMap = new HashMap();
		final CUST_INDV_ELG_Collection custIndvElgCollNextMonth = new CUST_INDV_ELG_Collection();
		try {
			if ((elgInd != null) && (caseNum != null)) {
				sqlMap.put(FwConstants.SQL_IND, "sql-243");
				final FwDataCriteria[] criteria = new FwDataCriteria[3];
				criteria[0] = new FwDataCriteria();
				criteria[0].setColumn_value(caseNum);
				criteria[0].setData_type(FwConstants.LONG);

				/*
				 * VG SONAR Cleanup - 08/25/2015 Deleted 3 lines Commented Code
				 * in this block
				 */

				Date currentDate = fwDate.getDate();
				currentDate.setDate(1);
				currentDate.setMonth(currentDate.getMonth() + 2);
				currentDate.setDate(currentDate.getDate() - 1);
				criteria[1] = new FwDataCriteria();
				criteria[1].setColumn_value(currentDate.toString());
				criteria[1].setData_type(FwConstants.STRING);

				currentDate = fwDate.getDate();
				currentDate.setDate(1);
				currentDate.setMonth(currentDate.getMonth() + 1);
				criteria[2] = new FwDataCriteria();
				criteria[2].setColumn_value(currentDate.toString());
				criteria[2].setData_type(FwConstants.STRING);
				sqlMap.put(FwConstants.CRITERIA, criteria);
				final List res = executeSQL(sqlMap);
				if (null != res && !res.isEmpty()) {
					final CUST_INDV_ELG_Cargo[] custIndvElgCargo = new CUST_INDV_ELG_Cargo[res
							.size()];

					for (int i = 0; i < res.size(); i++) {
						final Map cargo = (Map) res.get(i);
						custIndvElgCargo[i] = new CUST_INDV_ELG_Cargo();
						custIndvElgCargo[i].setMci_id((String) cargo
								.get("MCI_ID"));
						custIndvElgCargo[i].setBnft_pin_num((String) cargo
								.get("BNFT_PIN_NUM"));
						custIndvElgCargo[i].setBnft_case_num((String) cargo
								.get("BNFT_CASE_NUM"));
						custIndvElgCargo[i].setCat_cd((String) cargo
								.get("CAT_CD"));
						custIndvElgCargo[i].setScat_cd((String) cargo
								.get("SCAT_CD"));
						custIndvElgCargo[i].setScat_seq_num((String) cargo
								.get("SCAT_SEQ_NUM"));
						custIndvElgCargo[i].setCur_elg_ind((String) cargo
								.get("CUR_ELG_IND"));
						custIndvElgCargo[i].setBnft_stat_cd((String) cargo
								.get("BNFT_STAT_CD"));
						custIndvElgCargo[i].setCnfm_dt((String) cargo
								.get("CNFM_DT"));
						custIndvElgCargo[i].setElg_beg_dt((String) cargo
								.get("ELG_BEG_DT"));
						custIndvElgCargo[i].setElg_end_dt((String) cargo
								.get("ELG_END_DT"));
						custIndvElgCargo[i].setElg_ind((String) cargo
								.get("ELG_IND"));
						custIndvElgCargo[i].setMa_ddct_bal_amt((String) cargo
								.get("MA_DDCT_BAL_AMT"));
						custIndvElgCargo[i].setPymt_amt((String) cargo
								.get("PYMT_AMT"));
						custIndvElgCargo[i].setPymt_beg_dt((String) cargo
								.get("PYMT_BEG_DT"));
						custIndvElgCargo[i].setPymt_end_dt((String) cargo
								.get("PYMT_END_DT"));
						custIndvElgCargo[i].setPymt_typ((String) cargo
								.get("PYMT_TYP"));
						custIndvElgCargo[i].setSc_bnft_lvl_cd((String) cargo
								.get("SC_BNFT_LVL_CD"));
						custIndvElgCargo[i].setUpdt_dt((String) cargo
								.get("UPDT_DT"));
						custIndvElgCargo[i].setVfcn_due_dt((String) cargo
								.get("VFCN_DUE_DT"));
						custIndvElgCargo[i].setMsg_cd_txt((String) cargo
								.get("MSG_CD_TXT"));
						custIndvElgCargo[i].setFst_nam(cargo.get("FST_NAM")
								.toString().trim());
						custIndvElgCargo[i].setSex_ind((String) cargo
								.get("SEX_IND"));
						custIndvElgCargo[i].setAg_stat_rsn_1_cd((String) cargo
								.get("AG_STAT_RSN_1_CD"));
						custIndvElgCargo[i].setAg_stat_rsn_2_cd((String) cargo
								.get("AG_STAT_RSN_2_CD"));
						custIndvElgCargo[i].setAg_stat_rsn_3_cd((String) cargo
								.get("AG_STAT_RSN_3_CD"));
						custIndvElgCargo[i].setNf_elg_rslt_cd((String) cargo
								.get("NF_ELG_RSLT_CD"));
						custIndvElgCargo[i].setNf_fail_rsn_1_cd((String) cargo
								.get("NF_FAIL_RSN_1_CD"));
						custIndvElgCargo[i].setNf_fail_rsn_2_cd((String) cargo
								.get("NF_FAIL_RSN_2_CD"));
						custIndvElgCargo[i].setNf_fail_rsn_3_cd((String) cargo
								.get("NF_FAIL_RSN_3_CD"));
						custIndvElgCargo[i].setOrg_elg_ind((String) cargo
								.get("ORIG_ELG_IND"));
						custIndvElgCargo[i].setPrev_pymt_amt((String) cargo
								.get("PREV_PYMT_AMT"));
						custIndvElgCargo[i].setFs_grp_typ((String) cargo
								.get("FS_GRP_TYP"));
						custIndvElgCargo[i].setFs_fpl_130pct_amt((String) cargo
								.get("FS_FPL_130PCT_AMT"));
						custIndvElgCargo[i].setPgm_rqst_sw((String) cargo
								.get("PGM_RQST_SW"));
						custIndvElgCargo[i].setPrev_sc_bnft_l_cd((String) cargo
								.get("PREV_SC_BNFT_L_CD"));
						custIndvElgCargo[i].setBrth_dt((String) cargo
								.get("BRTH_DT"));
						custIndvElgCargo[i].setEmpl_vfcn_due_dt((String) cargo
								.get("EMPL_VFCN_DUE_DT"));
						custIndvElgCargo[i].setIns_vfcn_due_dt((String) cargo
								.get("INS_VFCN_DUE_DT"));
						custIndvElgCargo[i].setSmirf_mo((String) cargo
								.get("SMIRF_MO"));
						custIndvElgCargo[i]
								.setSemi_annual_review_date((String) cargo
										.get("SEMI_ANNUAL_REVIEW_DT"));
						custIndvElgCargo[i].setReview_dt((String) cargo
								.get("REVIEW_DT"));
						custIndvElgCargo[i]
								.setMid_cert_review_date((String) cargo
										.get("MID_CERT_REVIEW_DT"));
					}
					custIndvElgCollNextMonth.setResults(custIndvElgCargo);
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getSummaryGroupingForNextMonth", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getSummaryIndivIneligibleGroupingForNextMonth() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return custIndvElgCollNextMonth;

	}

	/**
	 * This method returns Individual Eligibility collection .
	 *
	 * @param caseNum
	 *            case number
	 * @param elgInd
	 *            eligibility indicator
	 * @return Individual Eligibility collection
	 */

	public CUST_INDV_ELG_Collection getSummaryIneligibleGroupingForNextMonth(
			final String caseNum, final String elgInd) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"MyAccessBO.getSummaryIneligibleGroupingForNextMonth() - START");
		final Map sqlMap = new HashMap();
		final CUST_INDV_ELG_Collection custIndvElgCollNextMonth = new CUST_INDV_ELG_Collection();
		try {
			if ((elgInd != null) && (caseNum != null)) {
				sqlMap.put(FwConstants.SQL_IND, "sql-242");
				final FwDataCriteria[] criteria = new FwDataCriteria[3];
				criteria[0] = new FwDataCriteria();
				criteria[0].setColumn_value(caseNum);
				criteria[0].setData_type(FwConstants.LONG);
				Date currentDate = fwDate.getDate();
				currentDate.setDate(1);
				currentDate.setMonth(currentDate.getMonth() + 2);
				currentDate.setDate(currentDate.getDate() - 1);
				criteria[1] = new FwDataCriteria();
				criteria[1].setColumn_value(currentDate.toString());
				criteria[1].setData_type(FwConstants.STRING);

				currentDate = fwDate.getDate();
				currentDate.setDate(1);
				currentDate.setMonth(currentDate.getMonth() + 1);
				criteria[2] = new FwDataCriteria();
				criteria[2].setColumn_value(currentDate.toString());
				criteria[2].setData_type(FwConstants.STRING);
				sqlMap.put(FwConstants.CRITERIA, criteria);
				final List res = executeSQL(sqlMap);
				if (null != res && !res.isEmpty()) {
					final CUST_INDV_ELG_Cargo[] custIndvElgCargo = new CUST_INDV_ELG_Cargo[res
							.size()];

					for (int i = 0; i < res.size(); i++) {
						final Map cargo = (Map) res.get(i);
						custIndvElgCargo[i] = new CUST_INDV_ELG_Cargo();
						custIndvElgCargo[i].setMci_id((String) cargo
								.get("MCI_ID"));
						custIndvElgCargo[i].setBnft_pin_num((String) cargo
								.get("BNFT_PIN_NUM"));
						custIndvElgCargo[i].setBnft_case_num((String) cargo
								.get("BNFT_CASE_NUM"));
						custIndvElgCargo[i].setCat_cd((String) cargo
								.get("CAT_CD"));
						custIndvElgCargo[i].setScat_cd((String) cargo
								.get("SCAT_CD"));
						custIndvElgCargo[i].setScat_seq_num((String) cargo
								.get("SCAT_SEQ_NUM"));
						custIndvElgCargo[i].setCur_elg_ind((String) cargo
								.get("CUR_ELG_IND"));
						custIndvElgCargo[i].setBnft_stat_cd((String) cargo
								.get("BNFT_STAT_CD"));
						custIndvElgCargo[i].setCnfm_dt((String) cargo
								.get("CNFM_DT"));
						custIndvElgCargo[i].setElg_beg_dt((String) cargo
								.get("ELG_BEG_DT"));
						custIndvElgCargo[i].setElg_end_dt((String) cargo
								.get("ELG_END_DT"));
						custIndvElgCargo[i].setElg_ind((String) cargo
								.get("ELG_IND"));
						custIndvElgCargo[i].setMa_ddct_bal_amt((String) cargo
								.get("MA_DDCT_BAL_AMT"));
						custIndvElgCargo[i].setPymt_amt((String) cargo
								.get("PYMT_AMT"));
						custIndvElgCargo[i].setPymt_beg_dt((String) cargo
								.get("PYMT_BEG_DT"));
						custIndvElgCargo[i].setPymt_end_dt((String) cargo
								.get("PYMT_END_DT"));
						custIndvElgCargo[i].setPymt_typ((String) cargo
								.get("PYMT_TYP"));
						custIndvElgCargo[i].setSc_bnft_lvl_cd((String) cargo
								.get("SC_BNFT_LVL_CD"));
						custIndvElgCargo[i].setUpdt_dt((String) cargo
								.get("UPDT_DT"));
						custIndvElgCargo[i].setVfcn_due_dt((String) cargo
								.get("VFCN_DUE_DT"));
						custIndvElgCargo[i].setMsg_cd_txt((String) cargo
								.get("MSG_CD_TXT"));
						custIndvElgCargo[i].setFst_nam(cargo.get("FST_NAM")
								.toString().trim());
						custIndvElgCargo[i].setSex_ind((String) cargo
								.get("SEX_IND"));
						custIndvElgCargo[i].setAg_stat_rsn_1_cd((String) cargo
								.get("AG_STAT_RSN_1_CD"));
						custIndvElgCargo[i].setAg_stat_rsn_2_cd((String) cargo
								.get("AG_STAT_RSN_2_CD"));
						custIndvElgCargo[i].setAg_stat_rsn_3_cd((String) cargo
								.get("AG_STAT_RSN_3_CD"));
						custIndvElgCargo[i].setNf_elg_rslt_cd((String) cargo
								.get("NF_ELG_RSLT_CD"));
						custIndvElgCargo[i].setNf_fail_rsn_1_cd((String) cargo
								.get("NF_FAIL_RSN_1_CD"));
						custIndvElgCargo[i].setNf_fail_rsn_2_cd((String) cargo
								.get("NF_FAIL_RSN_2_CD"));
						custIndvElgCargo[i].setNf_fail_rsn_3_cd((String) cargo
								.get("NF_FAIL_RSN_3_CD"));
						custIndvElgCargo[i].setOrg_elg_ind((String) cargo
								.get("ORIG_ELG_IND"));
						custIndvElgCargo[i].setPrev_pymt_amt((String) cargo
								.get("PREV_PYMT_AMT"));
						custIndvElgCargo[i].setFs_grp_typ((String) cargo
								.get("FS_GRP_TYP"));
						custIndvElgCargo[i].setFs_fpl_130pct_amt((String) cargo
								.get("FS_FPL_130PCT_AMT"));
						custIndvElgCargo[i].setPgm_rqst_sw((String) cargo
								.get("PGM_RQST_SW"));
						custIndvElgCargo[i].setPrev_sc_bnft_l_cd((String) cargo
								.get("PREV_SC_BNFT_L_CD"));
						custIndvElgCargo[i].setBrth_dt((String) cargo
								.get("BRTH_DT"));
						custIndvElgCargo[i].setEmpl_vfcn_due_dt((String) cargo
								.get("EMPL_VFCN_DUE_DT"));
						custIndvElgCargo[i].setIns_vfcn_due_dt((String) cargo
								.get("INS_VFCN_DUE_DT"));
						custIndvElgCargo[i].setSmirf_mo((String) cargo
								.get("SMIRF_MO"));
						custIndvElgCargo[i]
								.setSemi_annual_review_date((String) cargo
										.get("SEMI_ANNUAL_REVIEW_DT"));
						custIndvElgCargo[i].setReview_dt((String) cargo
								.get("REVIEW_DT"));
						custIndvElgCargo[i]
								.setMid_cert_review_date((String) cargo
										.get("MID_CERT_REVIEW_DT"));
					}
					custIndvElgCollNextMonth.setResults(custIndvElgCargo);
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getSummaryGroupingForNextMonth", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getSummaryIneligibleGroupingForNextMonth() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return custIndvElgCollNextMonth;

	}

	/**
	 * This method return individual names for given case number.
	 *
	 * @param caseNum
	 *            case number
	 * @return array of individual names.
	 */

	public List getIndividualNames(final String caseNum) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getIndividualNames() - START");
		final Map sqlMap = new HashMap();
		final List nameList = new ArrayList();
		sqlMap.put(FwConstants.SQL_IND, "sql-250");
		final FwDataCriteria[] criteria = new FwDataCriteria[1];
		criteria[0] = new FwDataCriteria();
		criteria[0].setColumn_value(caseNum);
		criteria[0].setData_type(FwConstants.LONG);
		sqlMap.put(FwConstants.CRITERIA, criteria);
		final List res = executeSQL(sqlMap);
		if (null != res && !res.isEmpty()) {

			for (int i = 0; i < res.size(); i++) {
				final Map cargo = (Map) res.get(i);
				nameList.add(cargo.get("FST_NAM"));
			}

		}

		log(ILog.INFO, "MyAccessBO.getIndividualNames() - END , Time Taken : "
				+ (System.currentTimeMillis() - startTime) + " milliseconds");
		return nameList;

	}

	/**
	 * This method returns Indvidual Eligibility collection.
	 *
	 * @param caseNum
	 *            case number
	 * @param catCd
	 *            category code
	 * @param scatCd
	 *            scat code
	 * @param scatSeqNum
	 *            sequence number
	 * @return Indvidual Eligibility collection for the given input.
	 */

	public CUST_INDV_ELG_Collection getSerDetailIneligibleGrouping(
			final String caseNum, final String catCd, final String scatCd,
			final String scatSeqNum) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getSerDetailIneligibleGrouping() - START");
		final Map sqlMap = new HashMap();
		final CUST_INDV_ELG_Collection custIndvElgColl = new CUST_INDV_ELG_Collection();
		try {
			sqlMap.put(FwConstants.SQL_IND, "sql-260");
			final FwDataCriteria[] criteria = new FwDataCriteria[4];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_value(caseNum);
			criteria[0].setData_type(FwConstants.LONG);
			criteria[1] = new FwDataCriteria();
			criteria[1].setColumn_value(catCd);
			criteria[1].setData_type(FwConstants.STRING);

			criteria[2] = new FwDataCriteria();
			criteria[2].setColumn_value(scatCd);
			criteria[2].setData_type(FwConstants.STRING);

			criteria[3] = new FwDataCriteria();
			criteria[3].setColumn_value(scatSeqNum);
			criteria[3].setData_type(FwConstants.STRING);

			/*
			 * VG SONAR Cleanup - 08/25/2015 Deleted 6 lines Commented Code in
			 * this block
			 */

			sqlMap.put(FwConstants.CRITERIA, criteria);
			/*
			 * VG SONAR Cleanup - 08/25/2015 Changed Commented code block to
			 * javadoc
			 */
			/**
			 * Date currentDate = fwDate.getDate(); currentDate.setDate(1);
			 * currentDate.setMonth(currentDate.getMonth() + 1);
			 * currentDate.setDate(currentDate.getDate() - 1); Date
			 * endOfCurMnth=currentDate; criteria[2] = new FwDataCriteria();
			 * criteria[2].setColumn_value(currentDate.toString());
			 * criteria[2].setData_type(FwConstants.STRING);
			 *
			 * currentDate = fwDate.getDate(); currentDate.setDate(1); Date
			 * beginOfCurMnth=currentDate;//added for FAP amt criteria[3] = new
			 * FwDataCriteria();
			 * criteria[3].setColumn_value(currentDate.toString());
			 * criteria[3].setData_type(FwConstants.STRING);
			 * sqlMap.put(FwConstants.CRITERIA, criteria); String paymentAmount
			 * = getFAPPaymentAmount(caseNum,endOfCurMnth,beginOfCurMnth);//
			 * added for FAP amt
			 */

			final List res = executeSQL(sqlMap);
			if (null != res && !res.isEmpty()) {
				final CUST_INDV_ELG_Cargo[] custIndvElgCargo = new CUST_INDV_ELG_Cargo[res
						.size()];

				for (int i = 0; i < res.size(); i++) {
					final Map cargo = (Map) res.get(i);
					custIndvElgCargo[i] = new CUST_INDV_ELG_Cargo();
					custIndvElgCargo[i].setMci_id((String) cargo.get("MCI_ID"));
					custIndvElgCargo[i].setBnft_pin_num((String) cargo
							.get("BNFT_PIN_NUM"));
					custIndvElgCargo[i].setBnft_case_num((String) cargo
							.get("BNFT_CASE_NUM"));
					custIndvElgCargo[i].setCat_cd((String) cargo.get("CAT_CD"));
					custIndvElgCargo[i].setScat_cd((String) cargo
							.get("SCAT_CD"));
					custIndvElgCargo[i].setScat_seq_num((String) cargo
							.get("SCAT_SEQ_NUM"));
					custIndvElgCargo[i].setCur_elg_ind((String) cargo
							.get("CUR_ELG_IND"));
					custIndvElgCargo[i].setBnft_stat_cd((String) cargo
							.get("BNFT_STAT_CD"));
					custIndvElgCargo[i].setCnfm_dt((String) cargo
							.get("CNFM_DT"));
					custIndvElgCargo[i].setElg_beg_dt((String) cargo
							.get("ELG_BEG_DT"));
					custIndvElgCargo[i].setElg_end_dt((String) cargo
							.get("ELG_END_DT"));
					custIndvElgCargo[i].setElg_ind((String) cargo
							.get("ELG_IND"));
					custIndvElgCargo[i].setMa_ddct_bal_amt((String) cargo
							.get("MA_DDCT_BAL_AMT"));
					final String paymentAmount = (String) cargo.get("PYMT_AMT");
					/*
					 * VG SONAR Cleanup - 08/25/2015 Deleted 1,1 lines Commented
					 * Code in this block
					 */
					if (paymentAmount != null) {

						custIndvElgCargo[i].setPymt_amt(paymentAmount);

					} else {

						custIndvElgCargo[i].setPymt_amt("0.00");

					}

					custIndvElgCargo[i].setPymt_beg_dt((String) cargo
							.get("PYMT_BEG_DT"));
					custIndvElgCargo[i].setPymt_end_dt((String) cargo
							.get("PYMT_END_DT"));
					custIndvElgCargo[i].setPymt_typ((String) cargo
							.get("PYMT_TYP"));
					custIndvElgCargo[i].setSc_bnft_lvl_cd((String) cargo
							.get("SC_BNFT_LVL_CD"));
					custIndvElgCargo[i].setUpdt_dt((String) cargo
							.get("UPDT_DT"));
					custIndvElgCargo[i].setVfcn_due_dt((String) cargo
							.get("VFCN_DUE_DT"));
					custIndvElgCargo[i].setMsg_cd_txt((String) cargo
							.get("MSG_CD_TXT"));
					custIndvElgCargo[i].setFst_nam(cargo.get("FST_NAM")
							.toString().trim());
					custIndvElgCargo[i].setSex_ind((String) cargo
							.get("SEX_IND"));
					custIndvElgCargo[i].setAg_stat_rsn_1_cd((String) cargo
							.get("AG_STAT_RSN_1_CD"));
					custIndvElgCargo[i].setAg_stat_rsn_2_cd((String) cargo
							.get("AG_STAT_RSN_2_CD"));
					custIndvElgCargo[i].setAg_stat_rsn_3_cd((String) cargo
							.get("AG_STAT_RSN_3_CD"));
					custIndvElgCargo[i].setNf_elg_rslt_cd((String) cargo
							.get("NF_ELG_RSLT_CD"));
					custIndvElgCargo[i].setNf_fail_rsn_1_cd((String) cargo
							.get("NF_FAIL_RSN_1_CD"));
					custIndvElgCargo[i].setNf_fail_rsn_2_cd((String) cargo
							.get("NF_FAIL_RSN_2_CD"));
					custIndvElgCargo[i].setNf_fail_rsn_3_cd((String) cargo
							.get("NF_FAIL_RSN_3_CD"));
					custIndvElgCargo[i].setOrg_elg_ind((String) cargo
							.get("ORIG_ELG_IND"));
					custIndvElgCargo[i].setPrev_pymt_amt((String) cargo
							.get("PREV_PYMT_AMT"));
					custIndvElgCargo[i].setFs_grp_typ((String) cargo
							.get("FS_GRP_TYP"));
					custIndvElgCargo[i].setFs_fpl_130pct_amt((String) cargo
							.get("FS_FPL_130PCT_AMT"));
					custIndvElgCargo[i].setPgm_rqst_sw((String) cargo
							.get("PGM_RQST_SW"));
					custIndvElgCargo[i].setPrev_sc_bnft_l_cd((String) cargo
							.get("PREV_SC_BNFT_L_CD"));
					custIndvElgCargo[i].setBrth_dt((String) cargo
							.get("BRTH_DT"));
					custIndvElgCargo[i].setEmpl_vfcn_due_dt((String) cargo
							.get("EMPL_VFCN_DUE_DT"));
					custIndvElgCargo[i].setIns_vfcn_due_dt((String) cargo
							.get("INS_VFCN_DUE_DT"));
					custIndvElgCargo[i].setSmirf_mo((String) cargo
							.get("SMIRF_MO"));
					custIndvElgCargo[i]
							.setSemi_annual_review_date((String) cargo
									.get("SEMI_ANNUAL_REVIEW_DT"));
					custIndvElgCargo[i].setReview_dt((String) cargo
							.get("REVIEW_DT"));
					custIndvElgCargo[i].setMid_cert_review_date((String) cargo
							.get("MID_CERT_REVIEW_DT"));

					if (cargo.get("SER_AUTH_DT") != null) {

						custIndvElgCargo[i].setSer_auth_dt(cargo
								.get("SER_AUTH_DT").toString().trim());

					} else {

						custIndvElgCargo[i].setSer_auth_dt(" ");
					}

					/*
					 * VG SONAR Cleanup - 08/25/2015 Deleted 2 lines Commented
					 * Code in this block
					 */

					custIndvElgCargo[i].setRequested_date((String) cargo
							.get("REQUESTED_DATE"));
				}
				custIndvElgColl.setResults(custIndvElgCargo);
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getDetailGrouping", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getSerDetailIneligibleGrouping() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return custIndvElgColl;
	}

	/**
	 * Method Name : getSERDetailGrouping This method is used to get the SER
	 * eligiblity records. this is method for all detail pages(Eligable,
	 * InEligable, IndividualInEligable)
	 *
	 * @param caseNum
	 *            the case num
	 * @param catCd
	 *            the cat cd
	 * @param scatCd
	 *            the scat cd
	 * @param scatSeqNum
	 *            the scat seq num
	 * @param elgInd
	 *            the elg ind
	 * @param currentEligInd
	 *            the current elig ind
	 * @return the SER detail grouping
	 */

	//
	public CUST_INDV_ELG_Collection getSERDetailGrouping(final String caseNum,
			final String catCd, final String scatCd, final String scatSeqNum,
			final String elgInd, final String currentEligInd) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getSERDetailGrouping() - START");
		final Map sqlMap = new HashMap();
		final CUST_INDV_ELG_Collection custIndvElgColl = new CUST_INDV_ELG_Collection();
		try {
			sqlMap.put(FwConstants.SQL_IND, "sql-259");
			final FwDataCriteria[] criteria = new FwDataCriteria[5];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_value(caseNum);
			criteria[0].setData_type(FwConstants.LONG);
			criteria[1] = new FwDataCriteria();
			criteria[1].setColumn_value(catCd);
			criteria[1].setData_type(FwConstants.STRING);

			criteria[2] = new FwDataCriteria();
			criteria[2].setColumn_value(scatCd);
			criteria[2].setData_type(FwConstants.STRING);

			criteria[3] = new FwDataCriteria();
			criteria[3].setColumn_value(scatSeqNum);
			criteria[3].setData_type(FwConstants.STRING);

			criteria[4] = new FwDataCriteria();
			criteria[4].setColumn_value(elgInd);
			criteria[4].setData_type(FwConstants.STRING);

			/*
			 * VG SONAR Cleanup - 08/25/2015 Deleted 3 lines Commented Code in
			 * this block
			 */

			sqlMap.put(FwConstants.CRITERIA, criteria);
			/*
			 * VG SONAR Cleanup - 08/25/2015 Changed Commented code block to
			 * javadoc
			 */
			/**
			 * Date currentDate = fwDate.getDate(); currentDate.setDate(1);
			 * currentDate.setMonth(currentDate.getMonth() + 1);
			 * currentDate.setDate(currentDate.getDate() - 1); Date
			 * endOfCurMnth=currentDate;//added for FAP amt criteria[3] = new
			 * FwDataCriteria();
			 * criteria[3].setColumn_value(currentDate.toString());
			 * criteria[3].setData_type(FwConstants.STRING);
			 */

			/**
			 * currentDate = fwDate.getDate(); currentDate.setDate(1); Date
			 * beginOfCurMnth=currentDate;//added for FAP amt criteria[4] = new
			 * FwDataCriteria();
			 * criteria[4].setColumn_value(currentDate.toString());
			 * criteria[4].setData_type(FwConstants.STRING);
			 */

			sqlMap.put(FwConstants.CRITERIA, criteria);

			/*
			 * VG SONAR Cleanup - 08/25/2015 Deleted 1 lines Commented Code in
			 * this block
			 */

			// for SER amt
			String paymentAmount = "";
			final List res = executeSQL(sqlMap);
			if (null != res && !res.isEmpty()) {
				final CUST_INDV_ELG_Cargo[] custIndvElgCargo = new CUST_INDV_ELG_Cargo[res
						.size()];

				for (int i = 0; i < res.size(); i++) {
					final Map cargo = (Map) res.get(i);
					custIndvElgCargo[i] = new CUST_INDV_ELG_Cargo();
					custIndvElgCargo[i].setMci_id((String) cargo.get("MCI_ID"));
					custIndvElgCargo[i].setBnft_pin_num((String) cargo
							.get("BNFT_PIN_NUM"));
					custIndvElgCargo[i].setBnft_case_num((String) cargo
							.get("BNFT_CASE_NUM"));
					custIndvElgCargo[i].setCat_cd((String) cargo.get("CAT_CD"));
					custIndvElgCargo[i].setScat_cd((String) cargo
							.get("SCAT_CD"));
					custIndvElgCargo[i].setScat_seq_num((String) cargo
							.get("SCAT_SEQ_NUM"));
					custIndvElgCargo[i].setCur_elg_ind((String) cargo
							.get("CUR_ELG_IND"));
					custIndvElgCargo[i].setBnft_stat_cd((String) cargo
							.get("BNFT_STAT_CD"));
					custIndvElgCargo[i].setCnfm_dt((String) cargo
							.get("CNFM_DT"));
					custIndvElgCargo[i].setElg_beg_dt((String) cargo
							.get("ELG_BEG_DT"));
					custIndvElgCargo[i].setElg_end_dt((String) cargo
							.get("ELG_END_DT"));
					custIndvElgCargo[i].setElg_ind((String) cargo
							.get("ELG_IND"));
					custIndvElgCargo[i].setMa_ddct_bal_amt((String) cargo
							.get("MA_DDCT_BAL_AMT"));
					paymentAmount = (String) cargo.get("PYMT_AMT");
					if (paymentAmount != null) {
						custIndvElgCargo[i].setPymt_amt(paymentAmount);
					} else {
						custIndvElgCargo[i].setPymt_amt("0.00");
					}
					custIndvElgCargo[i].setPymt_beg_dt((String) cargo
							.get("PYMT_BEG_DT"));
					custIndvElgCargo[i].setPymt_end_dt((String) cargo
							.get("PYMT_END_DT"));
					custIndvElgCargo[i].setPymt_typ((String) cargo
							.get("PYMT_TYP"));
					custIndvElgCargo[i].setSc_bnft_lvl_cd((String) cargo
							.get("SC_BNFT_LVL_CD"));
					custIndvElgCargo[i].setUpdt_dt((String) cargo
							.get("UPDT_DT"));
					custIndvElgCargo[i].setVfcn_due_dt((String) cargo
							.get("VFCN_DUE_DT"));
					custIndvElgCargo[i].setMsg_cd_txt((String) cargo
							.get("MSG_CD_TXT"));
					custIndvElgCargo[i].setFst_nam(cargo.get("FST_NAM")
							.toString().trim());
					custIndvElgCargo[i].setSex_ind((String) cargo
							.get("SEX_IND"));
					custIndvElgCargo[i].setAg_stat_rsn_1_cd((String) cargo
							.get("AG_STAT_RSN_1_CD"));
					custIndvElgCargo[i].setAg_stat_rsn_2_cd((String) cargo
							.get("AG_STAT_RSN_2_CD"));
					custIndvElgCargo[i].setAg_stat_rsn_3_cd((String) cargo
							.get("AG_STAT_RSN_3_CD"));
					custIndvElgCargo[i].setNf_elg_rslt_cd((String) cargo
							.get("NF_ELG_RSLT_CD"));
					custIndvElgCargo[i].setNf_fail_rsn_1_cd((String) cargo
							.get("NF_FAIL_RSN_1_CD"));
					custIndvElgCargo[i].setNf_fail_rsn_2_cd((String) cargo
							.get("NF_FAIL_RSN_2_CD"));
					custIndvElgCargo[i].setNf_fail_rsn_3_cd((String) cargo
							.get("NF_FAIL_RSN_3_CD"));
					custIndvElgCargo[i].setOrg_elg_ind((String) cargo
							.get("ORIG_ELG_IND"));
					custIndvElgCargo[i].setPrev_pymt_amt((String) cargo
							.get("PREV_PYMT_AMT"));
					custIndvElgCargo[i].setFs_grp_typ((String) cargo
							.get("FS_GRP_TYP"));
					custIndvElgCargo[i].setFs_fpl_130pct_amt((String) cargo
							.get("FS_FPL_130PCT_AMT"));
					custIndvElgCargo[i].setPgm_rqst_sw((String) cargo
							.get("PGM_RQST_SW"));
					custIndvElgCargo[i].setPrev_sc_bnft_l_cd((String) cargo
							.get("PREV_SC_BNFT_L_CD"));
					custIndvElgCargo[i].setBrth_dt((String) cargo
							.get("BRTH_DT"));
					custIndvElgCargo[i].setEmpl_vfcn_due_dt((String) cargo
							.get("EMPL_VFCN_DUE_DT"));
					custIndvElgCargo[i].setIns_vfcn_due_dt((String) cargo
							.get("INS_VFCN_DUE_DT"));
					custIndvElgCargo[i].setSmirf_mo((String) cargo
							.get("SMIRF_MO"));
					custIndvElgCargo[i]
							.setSemi_annual_review_date((String) cargo
									.get("SEMI_ANNUAL_REVIEW_DT"));
					custIndvElgCargo[i].setReview_dt((String) cargo
							.get("REVIEW_DT"));
					custIndvElgCargo[i].setMid_cert_review_date((String) cargo
							.get("MID_CERT_REVIEW_DT"));
					custIndvElgCargo[i].setEstm_elg_end_dt((String) cargo
							.get("ESTM_ELG_END_DT"));

					if (cargo.get("SER_AUTH_DT") != null) {

						custIndvElgCargo[i].setSer_auth_dt(cargo
								.get("SER_AUTH_DT").toString().trim());

					} else {

						custIndvElgCargo[i].setSer_auth_dt(" ");
					}

					/*
					 * VG SONAR Cleanup - 08/25/2015 Deleted 2 lines Commented
					 * Code in this block
					 */

					custIndvElgCargo[i].setRequested_date((String) cargo
							.get("REQUESTED_DATE"));
					custIndvElgCargo[i].setClient_amt((String) cargo
							.get("CLIENT_AMT"));
					custIndvElgCargo[i].setProvider_id((String) cargo
							.get("PROVIDER_ID"));
				}
				custIndvElgColl.setResults(custIndvElgCargo);
			}

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getDetailGrouping", e);
		}
		log(ILog.INFO,
				"MyAccessBO.getSERDetailGrouping() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");
		return custIndvElgColl;
	}

	/**
	 * This method returns provider name for the given provider id.
	 *
	 * @param provideId
	 *            provider id
	 * @return provider name
	 */

	public String getSERProviderName(final String provideId) {

		// hit the fap amt table using the case num,catcd and dates.
		// get the values in a clolection.
		// cargo getpymtn amt
		// return payment amiunt
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "MyAccessBO.getSERProviderName() - START");
		final Map sqlMap = new HashMap();
		String provideName = null;
		try {
			if ((provideId != null) && (provideId.trim().length() > 0)
					&& !"0".equals(provideId)) {
				sqlMap.put(FwConstants.SQL_IND, "sql-261");
				final FwDataCriteria[] criteria = new FwDataCriteria[1];
				criteria[0] = new FwDataCriteria();
				criteria[0].setColumn_value(provideId);
				criteria[0].setData_type(FwConstants.STRING);

				sqlMap.put(FwConstants.CRITERIA, criteria);
				final List res = executeSQL(sqlMap);
				if (null != res && !res.isEmpty()) {
					for (int i = 0; i < res.size(); i++) {
						final Map cargo = (Map) res.get(i);
						provideName = (String) cargo.get("PROVIDER_NAME");
					}
				} else {
					provideName = " ";
				}
			} else {

				provideName = " ";
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(getClass().getName(),
					"getFAPPaymentAmount", e);
		}
		log(ILog.INFO, "MyAccessBO.getSERProviderName() - END , Time Taken : "
				+ (System.currentTimeMillis() - startTime) + " milliseconds");
		return provideName;
	}

}
