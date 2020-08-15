/*
 * 
 */
package gov.state.nextgen.access.business.rules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gov.state.nextgen.access.business.entities.BNFT_CASE_ADR_Cargo;
import gov.state.nextgen.access.business.entities.BNFT_CASE_ADR_Collection;
import gov.state.nextgen.access.business.entities.BNFT_INDV_CASE_Cargo;
import gov.state.nextgen.access.business.entities.BNFT_INDV_CASE_Collection;
import gov.state.nextgen.access.business.entities.BNFT_MSG_HIST_Cargo;
import gov.state.nextgen.access.business.entities.BNFT_MSG_HIST_Collection;
import gov.state.nextgen.access.business.entities.INDV_ELG_Cargo;
import gov.state.nextgen.access.business.entities.INDV_ELG_Collection;
import gov.state.nextgen.access.driver.FwPageManager;
import gov.state.nextgen.access.driver.IPage;
import gov.state.nextgen.access.exceptions.FwException;
import gov.state.nextgen.access.management.constants.AppConstants;
import gov.state.nextgen.access.management.constants.FwConstants;
import gov.state.nextgen.access.management.logging.ILog;
import gov.state.nextgen.access.management.util.FwDataCriteria;
import gov.state.nextgen.access.management.validations.FwMessageFormatter;

/**
 * @author mohanmu
 *
 */
public class BenefitCaseBO extends MyAccessBO {

	/**
	 *
	 */
	public BNFT_INDV_CASE_Collection getIndvCaseData(final String aCaseNum, final boolean aConnTypeBatch) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "BenefitCaseBO.getIndvCaseData() - START");
		log(ILog.INFO, "BenefitCaseBO::getIndvCaseData::Start");
		final BNFT_INDV_CASE_Collection bnftCaseColl = new BNFT_INDV_CASE_Collection();
		try {

			final Map sqlMap = new HashMap();
			final FwDataCriteria[] criteria = new FwDataCriteria[1];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_name("BNFT_CASE_NUM");
			criteria[0].setColumn_value(aCaseNum);
			sqlMap.put(FwConstants.CRITERIA, criteria);
			BNFT_INDV_CASE_Cargo[] accountHolderCaseData = null;
			// retrieve data from BNFT_INDV_CASE TABLE
			if (aConnTypeBatch) {
				accountHolderCaseData = (BNFT_INDV_CASE_Cargo[]) bnftCaseColl.selectBatch(FwConstants.DAO, sqlMap);
			} else {
				accountHolderCaseData = (BNFT_INDV_CASE_Cargo[]) bnftCaseColl.select(FwConstants.DAO, sqlMap);
			}
			bnftCaseColl.setResults(accountHolderCaseData);
			log(ILog.INFO, "BenefitCaseBO::getIndvCaseData::End");
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "getIndvCaseData", e);
		}
		log(ILog.INFO, "BenefitCaseBO.getIndvCaseData() - END , Time Taken : " + (System.currentTimeMillis() - startTime) + " milliseconds");
		return bnftCaseColl;
	}

	public void saveIndvCaseData(BNFT_INDV_CASE_Collection aUpdateColl, BNFT_INDV_CASE_Collection aInsertColl, BNFT_INDV_CASE_Collection aDeleteColl,
			final boolean aConnTypeBatch) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "BenefitCaseBO.saveIndvCaseData() - START");
		log(ILog.INFO, "BenefitCaseBO::saveIndvCaseData::Start");
		try {
			if (null != aDeleteColl && !aDeleteColl.isEmpty()) {
				if (aConnTypeBatch) {
					aDeleteColl = (BNFT_INDV_CASE_Collection) aDeleteColl.persistBatch(FwConstants.DAO);
				} else {
					aDeleteColl = (BNFT_INDV_CASE_Collection) aDeleteColl.persist(FwConstants.DAO);
				}
			}
			if (null != aUpdateColl && !aUpdateColl.isEmpty()) {
				if (aConnTypeBatch) {
					aUpdateColl = (BNFT_INDV_CASE_Collection) aUpdateColl.persistBatch(FwConstants.DAO);
				} else {
					aUpdateColl = (BNFT_INDV_CASE_Collection) aUpdateColl.persist(FwConstants.DAO);
				}
			}
			if (null != aInsertColl && !aInsertColl.isEmpty()) {
				if (aConnTypeBatch) {
					aInsertColl = (BNFT_INDV_CASE_Collection) aInsertColl.persistBatch(FwConstants.DAO);
				} else {
					aInsertColl = (BNFT_INDV_CASE_Collection) aInsertColl.persist(FwConstants.DAO);
				}
			}
			log(ILog.INFO, "BenefitCaseBO::saveIndvCaseData::End");
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "saveIndvCaseData", e);
		}
		log(ILog.INFO, "BenefitCaseBO.saveIndvCaseData() - END , Time Taken : " + (System.currentTimeMillis() - startTime) + " milliseconds");
	}

	/*
	 * Method for returning the data from the Access database for all the
	 * Address Types
	 */
	public BNFT_CASE_ADR_Collection getBenefitCaseAddressData(final String aCaseNum, final boolean aConnTypeBatch) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "BenefitCaseBO.getBenefitCaseAddressData() - START");
		log(ILog.INFO, "BenefitCaseBO::getBenefitCaseAddressData::Start");
		final Map map = new HashMap();
		final BNFT_CASE_ADR_Collection bnftCaseAdrAccessColl = new BNFT_CASE_ADR_Collection();
		try {
			final FwDataCriteria[] criteria = new FwDataCriteria[1];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_name("BNFT_CASE_NUM");
			criteria[0].setColumn_value(aCaseNum);
			map.put(FwConstants.CRITERIA, criteria);
			BNFT_CASE_ADR_Cargo[] bnftCareAdr = null;
			// call the persistence layer
			if (aConnTypeBatch) {
				bnftCareAdr = (BNFT_CASE_ADR_Cargo[]) bnftCaseAdrAccessColl.selectBatch(FwConstants.DAO, map);
			} else {
				bnftCareAdr = (BNFT_CASE_ADR_Cargo[]) bnftCaseAdrAccessColl.select(FwConstants.DAO, map);
			}
			bnftCaseAdrAccessColl.setResults(bnftCareAdr);
			log(ILog.INFO, "BenefitCaseBO::getBenefitCaseAddressData::End");
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "getBenefitCaseAddressData", e);
		}
		log(ILog.INFO, "BenefitCaseBO.getBenefitCaseAddressData() - END , Time Taken : " + (System.currentTimeMillis() - startTime) + " milliseconds");
		return bnftCaseAdrAccessColl;
	}

	public void saveCaseAdrData(final BNFT_CASE_ADR_Collection aUpdateColl, final BNFT_CASE_ADR_Collection aInsertColl,
			final BNFT_CASE_ADR_Collection aDeleteColl, final boolean aConnTypeBatch) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "BenefitCaseBO.saveCaseAdrData() - START");
		log(ILog.INFO, "BenefitCaseBO::saveCaseAdrData::Start");
		try {
			// Update
			if (null != aUpdateColl && !aUpdateColl.isEmpty()) {
				if (aConnTypeBatch) {
					aUpdateColl.persistBatch(FwConstants.DAO);
				} else {
					aUpdateColl.persist(FwConstants.DAO);
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
			// Persising the collections i.e Delete
			if (null != aDeleteColl && !aDeleteColl.isEmpty()) {
				if (aConnTypeBatch) {
					aDeleteColl.persistBatch(FwConstants.DAO);
				} else {
					aDeleteColl.persist(FwConstants.DAO);
				}
			}
			log(ILog.INFO, "BenefitCaseBO::saveCaseAdrData::End");
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "saveCaseAdrData", e);
		}
		log(ILog.INFO, "BenefitCaseBO.saveCaseAdrData() - END , Time Taken : " + (System.currentTimeMillis() - startTime) + " milliseconds");
	}

	public INDV_ELG_Collection getIndvElgData(final String aCaseNum, final boolean aConnTypeBatch) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "BenefitCaseBO.getIndvElgData() - START");
		log(ILog.INFO, "BenefitCaseBO::getIndvElgData::Start");
		final Map map = new HashMap();
		final INDV_ELG_Collection indvElgAccessColl = new INDV_ELG_Collection();
		try {
			final FwDataCriteria[] criteria = new FwDataCriteria[1];
			criteria[0] = new FwDataCriteria();
			criteria[0].setColumn_name("BNFT_CASE_NUM");
			criteria[0].setColumn_value(aCaseNum);
			map.put(FwConstants.CRITERIA, criteria);
			INDV_ELG_Cargo[] indvElgCargo = null;
			// call the persistence layer
			if (aConnTypeBatch) {
				indvElgCargo = (INDV_ELG_Cargo[]) indvElgAccessColl.selectBatch(FwConstants.DAO, map);
			} else {
				indvElgCargo = (INDV_ELG_Cargo[]) indvElgAccessColl.select(FwConstants.DAO, map);
			}
			indvElgAccessColl.setResults(indvElgCargo);
			log(ILog.INFO, "BenefitCaseBO::getIndvElgData::End");

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "getIndvElgData", e);
		}
		log(ILog.INFO, "BenefitCaseBO.getIndvElgData() - END , Time Taken : " + (System.currentTimeMillis() - startTime) + " milliseconds");
		return indvElgAccessColl;
	}

	public void saveIndvElgData(final INDV_ELG_Collection aUpdateColl, final INDV_ELG_Collection aInsertColl, final INDV_ELG_Collection aDeleteColl,
			final boolean aConnTypeBatch) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "BenefitCaseBO.saveIndvElgData() - START");
		log(ILog.INFO, "BenefitCaseBO::saveIndvElgData::Start");
		try {
			// Update
			if (null != aUpdateColl && !aUpdateColl.isEmpty()) {
				if (aConnTypeBatch) {
					aUpdateColl.persistBatch(FwConstants.DAO);
				} else {
					aUpdateColl.persist(FwConstants.DAO);
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
			// Persising the collections i.e Delete
			if (null != aDeleteColl && !aDeleteColl.isEmpty()) {
				if (aConnTypeBatch) {
					aDeleteColl.persistBatch(FwConstants.DAO);
				} else {
					aDeleteColl.persist(FwConstants.DAO);
				}
			}
			log(ILog.INFO, "BenefitCaseBO::saveIndvElgData::End");
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "saveIndvElgData", e);
		}
		log(ILog.INFO, "BenefitCaseBO.saveIndvElgData() - END , Time Taken : " + (System.currentTimeMillis() - startTime) + " milliseconds");
	}

	public void getBnftMsg(final INDV_ELG_Cargo indvElgCargo, final String language, final int type, final boolean aConnTypeBatch) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "BenefitCaseBO.getBnftMsg() - START");
		log(ILog.INFO, "BenefitCaseBO::getBnftMsg::Start");
		final BNFT_MSG_HIST_Collection bnftMsgColl = new BNFT_MSG_HIST_Collection();
		final BNFT_MSG_HIST_Collection bnftMsgHistColl = new BNFT_MSG_HIST_Collection();
		BNFT_MSG_HIST_Cargo bnftMsgHistCargo = null;
		final List messageArray = new ArrayList();
		final List inVldMsgCodes = new ArrayList();
		inVldMsgCodes.add("22073");
		inVldMsgCodes.add("22074");
		inVldMsgCodes.add("22075");
		inVldMsgCodes.add("22076");
		final List nfFailRsns = new ArrayList();
		String rsnCode = null;
		try {
			// Message Code Text
			if (type == 0) {
				// INDV_ELG.MSG_CD_TXT
				final String[] msgCodeAry = splitMessage(indvElgCargo.getMsg_cd_txt(), indvElgCargo.getCur_elg_ind());
				if ((msgCodeAry != null) && (msgCodeAry.length > 0)) {
					for (int i = 0; i < msgCodeAry.length; i++) {
						// BC+ Changes
						if ((msgCodeAry[i] != null) && !inVldMsgCodes.contains(msgCodeAry[i])) {
							messageArray.add(msgCodeAry[i]);
						}
					}
				}
			}
			final IPage iPage = FwPageManager.createInstance();
			// Failure reasons
			if (type == 1) {
				if (indvElgCargo.getAg_stat_rsn_1_cd().trim().length() > 0 
						&& "Y".equals(iPage.getMessageHistory(indvElgCargo.getAg_stat_rsn_1_cd(), AppConstants.REASON_CODE))) {
					messageArray.add(iPage.getMessageCode(indvElgCargo.getAg_stat_rsn_1_cd(), AppConstants.REASON_CODE));
				}
				if (indvElgCargo.getAg_stat_rsn_2_cd().trim().length() > 0 
						&& "Y".equals(iPage.getMessageHistory(indvElgCargo.getAg_stat_rsn_2_cd(), AppConstants.REASON_CODE))) {
					messageArray.add(iPage.getMessageCode(indvElgCargo.getAg_stat_rsn_2_cd(), AppConstants.REASON_CODE));
				}
				if (indvElgCargo.getAg_stat_rsn_3_cd().trim().length() > 0 
						&&"Y".equals(iPage.getMessageHistory(indvElgCargo.getAg_stat_rsn_3_cd(), AppConstants.REASON_CODE))) {
					messageArray.add(iPage.getMessageCode(indvElgCargo.getAg_stat_rsn_3_cd(), AppConstants.REASON_CODE));
				}
				if (indvElgCargo.getNf_fail_rsn_1_cd().trim().length() > 0 
						&& "Y".equals(iPage.getMessageHistory(indvElgCargo.getNf_fail_rsn_1_cd(), AppConstants.REASON_CODE))) {
					rsnCode = indvElgCargo.getNf_fail_rsn_1_cd();
					messageArray.add(iPage.getMessageCode(rsnCode, AppConstants.REASON_CODE));
					// Adding failure reason code to the list to use in the
					// following logic, PCR # 34546
					nfFailRsns.add(rsnCode);
				}
				if (indvElgCargo.getNf_fail_rsn_2_cd().trim().length() > 0 
						&& "Y".equals(iPage.getMessageHistory(indvElgCargo.getNf_fail_rsn_2_cd(), AppConstants.REASON_CODE))) {
					rsnCode = indvElgCargo.getNf_fail_rsn_2_cd();
					// Adding failure reason code to the list only if it is
					// not added already
					// i.e not to add multiple times the same failure reason
					// code, PCR # 34546
					if (!nfFailRsns.contains(rsnCode)) {
						messageArray.add(iPage.getMessageCode(rsnCode, AppConstants.REASON_CODE));
						// Adding failure reason code to the list to use in
						// the following logic, PCR # 34546
						nfFailRsns.add(rsnCode);
					}
				}
				if (indvElgCargo.getNf_fail_rsn_3_cd().trim().length() > 0 
						&& "Y".equals(iPage.getMessageHistory(indvElgCargo.getNf_fail_rsn_3_cd(), AppConstants.REASON_CODE))) {
					rsnCode = indvElgCargo.getNf_fail_rsn_3_cd();
					// Adding failure reason code to the list only if it is
					// not added already
					// i.e not to add multiple times the same failure reason
					// code, PCR # 34546
					if (!nfFailRsns.contains(rsnCode)) {
						messageArray.add(iPage.getMessageCode(rsnCode, AppConstants.REASON_CODE));
					}
				}
			}

			String messageTxt = null;
			for (int i = 0; i < messageArray.size(); i++) {
				messageTxt = (String) messageArray.get(i);
				bnftMsgHistCargo = new BNFT_MSG_HIST_Cargo();
				final String catCD = indvElgCargo.getCat_cd();
				bnftMsgHistCargo.setBnft_pin_num(indvElgCargo.getBnft_pin_num());
				bnftMsgHistCargo.setBnft_case_num(indvElgCargo.getBnft_case_num());
				bnftMsgHistCargo.setCat_cd(catCD);
				bnftMsgHistCargo.setScat_cd(indvElgCargo.getScat_cd());
				bnftMsgHistCargo.setMsg_dt(fwDate.getToday());
				bnftMsgHistCargo.setTxt_id(messageTxt);
				bnftMsgHistCargo.setMsg_seq_num(indvElgCargo.getScat_seq_num());
				// set msg_seq_num
				if ("M01".equals(catCD) || "M02".equals(catCD) || "M04".equals(catCD)) {
					bnftMsgHistCargo.setMsg_seq_num("1");
				}
				// Message History New Logic Start --- Start

				// Check individual is open for healthcare category and there is
				// a change in
				// premium/deductible/cost share/spend down/patient liability
				// amount
				final String catCode = indvElgCargo.getCat_cd();
				String[] sub = null;
				if ("22030".equals(messageTxt)
						&& ("M02".equals(catCode) || "M03".equals(catCode) || "M05".equals(catCode) || "M06".equals(catCode) || "M07".equals(catCode)
								|| "M08".equals(catCode) || "M10".equals(catCode))) {
					String pymtType = "";
					if ("P".equals(indvElgCargo.getPymt_typ())) {
						pymtType = "Premium";
					} else if ("C".equals(indvElgCargo.getPymt_typ())) {
						pymtType = "Cost Share";
					}
					if ("L".equals(indvElgCargo.getPymt_typ())) {
						pymtType = "Patient Liability";
					}
					if ("D".equals(indvElgCargo.getPymt_typ())) {
						pymtType = "Deductible";
					}
					sub = new String[4];
					sub[0] = displayFormatter.getExpandedMonthYear(fwDate.getDate(indvElgCargo.getPymt_beg_dt()), language);
					sub[1] = pymtType;
					sub[2] = displayFormatter.getCurrencyFormat(indvElgCargo.getPrev_pymt_amt());
					sub[3] = displayFormatter.getCurrencyFormat(indvElgCargo.getPymt_amt());
					bnftMsgHistCargo.setMsg_txt(FwMessageFormatter.getFormattedMessage(iPage.getDisplayText(Integer.parseInt(messageTxt), language),
							sub));
				} else if ("22027".equals(messageTxt) && "SC ".equals(catCode)) {
					sub = new String[3];
					sub[0] = displayFormatter.getExpandedMonthYear(fwDate.getDate(indvElgCargo.getPymt_beg_dt()), language);
					String scBnftLvlCD = indvElgCargo.getPrev_sc_bnft_lvl_cd();
					if ("C".equals(scBnftLvlCD)) {
						sub[1] = "1";
					} else if ("D".equals(scBnftLvlCD)) {
						sub[1] = "2a";
					} else if ("E".equals(scBnftLvlCD)) {
						sub[1] = "2b";
					} else if ("S".equals(scBnftLvlCD)) {
						sub[1] = "3";
					} else {
						sub[1] = "";
					}
					scBnftLvlCD = indvElgCargo.getSc_bnft_lvl_cd();
					if ("C".equals(scBnftLvlCD)) {
						sub[2] = "1";
					} else if ("D".equals(scBnftLvlCD)) {
						sub[2] = "2a";
					} else if ("E".equals(scBnftLvlCD)) {
						sub[2] = "2b";
					} else if ("S".equals(scBnftLvlCD)) {
						sub[2] = "3";
					} else {
						sub[2] = "";
					}
					bnftMsgHistCargo.setMsg_txt(FwMessageFormatter.getFormattedMessage(iPage.getDisplayText(Integer.parseInt(messageTxt), language),
							sub));
				} else if ("22028".equals(messageTxt) && ("FS ".equals(catCode) || "CTS".equals(catCode))) {
					if ("FS ".equals(catCode)) {
						sub = new String[4];
						sub[0] = displayFormatter.getExpandedMonthYear(fwDate.getDate(indvElgCargo.getPymt_beg_dt()), language);
						sub[1] = FwMessageFormatter.getCachedText(20047, language);
						sub[2] = displayFormatter.getCurrencyFormat(indvElgCargo.getPrev_pymt_amt());
						sub[3] = displayFormatter.getCurrencyFormat(indvElgCargo.getPymt_amt());
					} else if ("CTS".equals(catCode)) {
						sub = new String[4];
						sub[0] = displayFormatter.getExpandedMonthYear(fwDate.getDate(indvElgCargo.getPymt_beg_dt()), language);
						sub[1] = FwMessageFormatter.getCachedText(20060, language);
						sub[2] = displayFormatter.getCurrencyFormat(indvElgCargo.getPrev_pymt_amt());
						sub[3] = displayFormatter.getCurrencyFormat(indvElgCargo.getPymt_amt());
					}
					bnftMsgHistCargo.setMsg_txt(FwMessageFormatter.getFormattedMessage(iPage.getDisplayText(Integer.parseInt(messageTxt), language),
							sub));
					// Message History New Logic Start --- End
				} else if ("23028".equals(messageTxt) || "23046".equals(messageTxt) || "23141".equals(messageTxt) || "23281".equals(messageTxt)
						|| "23368".equals(messageTxt) || "23537".equals(messageTxt)) {
					final String[] sub1 = new String[2];
					sub1[0] = "AMHST";
					if ("23281".equals(messageTxt)) {
						sub1[1] = AppConstants.COMMON_QUESTIONS_FMA_LINK_HEADER;
					} else {
						sub1[1] = AppConstants.GENERAL_QUESTIONS_LINK_HEADER;
					}
					sub = new String[1];
					sub[0] = FwMessageFormatter.getFormattedMessage(FwMessageFormatter.getCachedText(20166, language), sub1);
					bnftMsgHistCargo.setMsg_txt(FwMessageFormatter.getFormattedMessage(iPage.getDisplayText(Integer.parseInt(messageTxt), language),
							sub));
				} else if ("23038".equals(messageTxt) || "23116".equals(messageTxt) || "23143".equals(messageTxt)) {
					final String[] sub1 = new String[2];
					sub1[0] = "AMHST";
					sub1[1] = AppConstants.GENERAL_QUESTIONS_LINK_HEADER;
					sub = new String[1];
					sub[0] = FwMessageFormatter.getFormattedMessage(FwMessageFormatter.getCachedText(20177, language), sub1);
					bnftMsgHistCargo.setMsg_txt(FwMessageFormatter.getFormattedMessage(iPage.getDisplayText(Integer.parseInt(messageTxt), language),
							sub));
				} else {
					bnftMsgHistCargo.setMsg_txt(iPage.getDisplayText(Integer.parseInt(messageTxt), language));
				}
				bnftMsgHistCargo.setRowAction(FwConstants.ROWACTION_INSERT);
				bnftMsgHistColl.add(bnftMsgHistCargo);
			}

			int bnftMsgHistCollSize = bnftMsgHistColl.size();
			final Map map = new HashMap();
			final FwDataCriteria[] criteria = new FwDataCriteria[7];
			for (int i = 0; i < bnftMsgHistCollSize; i++) {
				final BNFT_MSG_HIST_Cargo cargo = bnftMsgHistColl.getResult(i);
				criteria[0] = new FwDataCriteria();
				criteria[0].setColumn_name("BNFT_PIN_NUM");
				criteria[0].setColumn_value(cargo.getBnft_pin_num());
				criteria[1] = new FwDataCriteria();
				criteria[1].setColumn_name("BNFT_CASE_NUM");
				criteria[1].setColumn_value(cargo.getBnft_case_num());
				criteria[2] = new FwDataCriteria();
				criteria[2].setColumn_name("CAT_CD");
				criteria[2].setColumn_value(cargo.getCat_cd());
				criteria[3] = new FwDataCriteria();
				criteria[3].setColumn_name("SCAT_CD");
				criteria[3].setColumn_value(cargo.getScat_cd());
				criteria[4] = new FwDataCriteria();
				criteria[4].setColumn_name("MSG_DT");
				criteria[4].setColumn_value(cargo.getMsg_dt());
				criteria[5] = new FwDataCriteria();
				criteria[5].setColumn_name("TXT_ID");
				criteria[5].setColumn_value(cargo.getTxt_id());
				criteria[6] = new FwDataCriteria();
				criteria[6].setColumn_name("MSG_SEQ_NUM");
				criteria[6].setColumn_value(cargo.getMsg_seq_num());
				map.put(FwConstants.CRITERIA, criteria);
				BNFT_MSG_HIST_Cargo[] bnftMsgHist = null;
				if (aConnTypeBatch) {
					bnftMsgHist = (BNFT_MSG_HIST_Cargo[]) bnftMsgColl.selectBatch(FwConstants.DAO, map);
				} else {
					bnftMsgHist = (BNFT_MSG_HIST_Cargo[]) bnftMsgColl.select(FwConstants.DAO, map);
				}
				bnftMsgColl.setResults(bnftMsgHist);
				final int collSize = bnftMsgColl.size();
				if (collSize > 0) {
					bnftMsgHistColl.remove(i);
					bnftMsgHistCollSize--;
					i--;
				}
				// If Data is not found with the criteria then we will insert
			}
			if (null != bnftMsgHistColl && !bnftMsgHistColl.isEmpty()) {
				if (aConnTypeBatch) {
					bnftMsgHistColl.persistBatch(FwConstants.DAO);
				} else {
					bnftMsgHistColl.persist(FwConstants.DAO);
				}
			}
			log(ILog.INFO, "BenefitCaseBO::getBnftMsg::End");
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "getBnftMsg", e);
		}
		log(ILog.INFO, "BenefitCaseBO.getBnftMsg() - END , Time Taken : " + (System.currentTimeMillis() - startTime) + " milliseconds");
	}

	public void saveBnftInfoRefresh(final String aAccessPin, final boolean aConnTypeBatch) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "BenefitCaseBO.saveBnftInfoRefresh() - START");
		log(ILog.INFO, "BenefitCaseBO::saveBnftInfoRefresh::Start");
		final Map sqlMap = new HashMap();
		FwDataCriteria[] criteria = null;
		try {
			if (aAccessPin != null) {
				sqlMap.put(FwConstants.SQL_IND, "sql-BR3");
				criteria = new FwDataCriteria[1];
				criteria[0] = new FwDataCriteria();
				criteria[0].setColumn_value(aAccessPin);
				criteria[0].setData_type(FwConstants.LONG);
				sqlMap.put(FwConstants.CRITERIA, criteria);
				List res = null;
				if (aConnTypeBatch) {
					res = executeSQLBatch(sqlMap);
				} else {
					res = executeSQL(sqlMap);
				}
				if (null != res && !res.isEmpty()) {
					sqlMap.put(FwConstants.SQL_IND, "sql-BR4");
					sqlMap.put(FwConstants.CRITERIA, criteria);
					if (aConnTypeBatch) {
						executeSQLBatch(sqlMap);
					} else {
						executeSQL(sqlMap);
					}
				}
				sqlMap.put(FwConstants.SQL_IND, "sql-BR5");
				criteria = new FwDataCriteria[2];
				criteria[0] = new FwDataCriteria();
				criteria[0].setColumn_value(aAccessPin);
				criteria[0].setData_type(FwConstants.LONG);
				criteria[1] = new FwDataCriteria();
				criteria[1].setColumn_value(String.valueOf(fwDate.getTimestamp()));
				criteria[1].setData_type(FwConstants.TIMESTAMP);
				sqlMap.put(FwConstants.CRITERIA, criteria);
				if (aConnTypeBatch) {
					executeSQLBatch(sqlMap);
				} else {
					executeSQL(sqlMap);
				}
			}
			log(ILog.INFO, "BenefitCaseBO::saveBnftInfoRefresh::End");
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "saveBnftInfoRefresh", e);
		}
		log(ILog.INFO, "BenefitCaseBO.saveBnftInfoRefresh() - END , Time Taken : " + (System.currentTimeMillis() - startTime) + " milliseconds");
	}

	// Method returns the case from BNFT_INDV_CASE
	public String getCaseForPin(final String aAccessPin, final boolean aConnTypeBatch) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "BenefitCaseBO.getCaseForPin() - START");
		log(ILog.INFO, "BenefitCaseBO::getCaseForPin::Start");
		String caseNumStr = null;
		final Map sqlMap = new HashMap();
		FwDataCriteria[] criteria = null;
		try {

			if (aAccessPin != null) {
				sqlMap.put(FwConstants.SQL_IND, "sql-231");
				criteria = new FwDataCriteria[1];
				criteria[0] = new FwDataCriteria();
				criteria[0].setColumn_value(aAccessPin);
				criteria[0].setData_type(FwConstants.LONG);
				sqlMap.put(FwConstants.CRITERIA, criteria);
				List resultList = null;
				if (aConnTypeBatch) {
					resultList = executeSQLBatch(sqlMap);
				} else {
					resultList = executeSQL(sqlMap);
				}
				if (null != resultList && !resultList.isEmpty()) {
					caseNumStr = (String) ((Map) resultList.get(0)).get("BNFT_CASE_NUM");
				}
			}
			log(ILog.INFO, "BenefitCaseBO::getCaseForPin::End");
			log(ILog.INFO, "BenefitCaseBO.getCaseForPin() - END , Time Taken : " + (System.currentTimeMillis() - startTime) + " milliseconds");
			return caseNumStr;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "getCaseForPin", e);
		}
	}

	// Method returns the MCI_ID for a given PIN_NUM from BNFT_INDV
	public String getMciIdForPin(final String aAccessPin, final boolean aConnTypeBatch) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "BenefitCaseBO.getMciIdForPin() - START");
		log(ILog.INFO, "BenefitCaseBO::getMciIdForPin::Start");
		String mciIdStr = null;
		final Map sqlMap = new HashMap();
		FwDataCriteria[] criteria = null;
		try {

			if (aAccessPin != null) {
				sqlMap.put(FwConstants.SQL_IND, "sql-232");
				criteria = new FwDataCriteria[1];
				criteria[0] = new FwDataCriteria();
				criteria[0].setColumn_value(aAccessPin);
				criteria[0].setData_type(FwConstants.LONG);
				sqlMap.put(FwConstants.CRITERIA, criteria);
				List resultList = null;
				if (aConnTypeBatch) {
					resultList = executeSQLBatch(sqlMap);
				} else {
					resultList = executeSQL(sqlMap);
				}
				if (null != resultList && !resultList.isEmpty()) {
					mciIdStr = (String) ((Map) resultList.get(0)).get("MCI_ID");
				}
			}
			log(ILog.INFO, "BenefitCaseBO::getMciIdForPin::End");
			log(ILog.INFO, "BenefitCaseBO.getMciIdForPin() - END , Time Taken : " + (System.currentTimeMillis() - startTime) + " milliseconds");
			return mciIdStr;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "getMciIdForPin", e);
		}
	}

	// If MAID/MCI_ID is used when creating account and the same user is getting
	// from CARES
	// Updating the ACS_USER table with the PIN_NUM what we get from CARES
	// If that data is not there already

	public void checkAndUpdateAccessUser(final String aMciId, final String aPinNum, final boolean aConnTypeBatch) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "BenefitCaseBO.checkAndUpdateAccessUser() - START");
		log(ILog.INFO, "BenefitCaseBO::checkAndUpdateAccessUser::Start");
		final Map sqlMap = new HashMap();
		FwDataCriteria[] criteria = null;
		List resultList = null;
		try {
			// If PIN_NUM is 0
			if ((aMciId != null) && !"0".equals(aMciId)) {
				// Sql to check if the user exist
				sqlMap.put(FwConstants.SQL_IND, "sql-AS15");
				criteria = new FwDataCriteria[2];
				criteria[0] = new FwDataCriteria();
				criteria[0].setColumn_value(aMciId);
				criteria[0].setData_type(FwConstants.LONG);
				criteria[1] = new FwDataCriteria();
				criteria[1].setColumn_value("0");
				criteria[1].setData_type(FwConstants.LONG);
				sqlMap.put(FwConstants.CRITERIA, criteria);
				if (aConnTypeBatch) {
					resultList = executeSQLBatch(sqlMap);
				} else {
					resultList = executeSQL(sqlMap);
				}
				// If MCI_ID > 0 exist and PIN_NUM is 0 update with PIN_NUM we
				// get
				if (null != resultList && !resultList.isEmpty()) {
					// Update sql with the following criteria
					sqlMap.put(FwConstants.SQL_IND, "sql-AS16");
					criteria = new FwDataCriteria[2];
					criteria[0] = new FwDataCriteria();
					criteria[0].setColumn_value(aPinNum);
					criteria[0].setData_type(FwConstants.LONG);
					criteria[1] = new FwDataCriteria();
					criteria[1].setColumn_value(aMciId);
					criteria[1].setData_type(FwConstants.LONG);
					sqlMap.put(FwConstants.CRITERIA, criteria);
					if (aConnTypeBatch) {
						resultList = executeSQLBatch(sqlMap);
					} else {
						resultList = executeSQL(sqlMap);
					}
				}
				// If MCI_ID is 0 AND PIN_NUM > 0
				if ((resultList == null) || ((resultList != null) && (resultList.isEmpty()))) {
					// Sql to check if the user exist
					sqlMap.put(FwConstants.SQL_IND, "sql-AS15");
					criteria = new FwDataCriteria[2];
					criteria[0] = new FwDataCriteria();
					criteria[0].setColumn_value("0");
					criteria[0].setData_type(FwConstants.LONG);
					criteria[1] = new FwDataCriteria();
					criteria[1].setColumn_value(aPinNum);
					criteria[1].setData_type(FwConstants.LONG);
					sqlMap.put(FwConstants.CRITERIA, criteria);
					if (aConnTypeBatch) {
						resultList = executeSQLBatch(sqlMap);
					} else {
						resultList = executeSQL(sqlMap);
					}
					// If exist update MCI_ID for that CASE_NUM AND PIN_NUM
					if (null != resultList && !resultList.isEmpty()) {
						// Update sql with the following criteria
						sqlMap.put(FwConstants.SQL_IND, "sql-AS17");
						criteria = new FwDataCriteria[2];
						criteria[0] = new FwDataCriteria();
						criteria[0].setColumn_value(aMciId);
						criteria[0].setData_type(FwConstants.LONG);
						criteria[1] = new FwDataCriteria();
						criteria[1].setColumn_value(aPinNum);
						criteria[1].setData_type(FwConstants.LONG);
						sqlMap.put(FwConstants.CRITERIA, criteria);
						if (aConnTypeBatch) {
							resultList = executeSQLBatch(sqlMap);
						} else {
							resultList = executeSQL(sqlMap);
						}
					}
				}
			}
			log(ILog.INFO, "BenefitCaseBO::checkAndUpdateAccessUser::End");
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "checkAndUpdateAccessUser", e);
		}
		log(ILog.INFO, "BenefitCaseBO.checkAndUpdateAccessUser() - END , Time Taken : " + (System.currentTimeMillis() - startTime) + " milliseconds");
	}

}
