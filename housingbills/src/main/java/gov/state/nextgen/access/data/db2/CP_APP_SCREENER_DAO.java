package gov.state.nextgen.access.data.db2;

import gov.state.nextgen.access.business.entities.CP_APP_SCREENER_Cargo;
import gov.state.nextgen.access.business.entities.ICargo;
import gov.state.nextgen.access.exceptions.FwException;
import gov.state.nextgen.access.exceptions.FwExceptionManager;
import gov.state.nextgen.access.management.constants.FwConstants;
import gov.state.nextgen.access.persistence.database.dao.FwAbstractDAO;
import gov.state.nextgen.access.persistence.database.dao.IDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CP_APP_SCREENER_DAO extends FwAbstractDAO {
	private static final short HISTORY_TYPE = 0;

	private static final String INSERT_SQL = "INSERT INTO "
			+ getDBSchema()
			+ FwConstants.DOT
			+ "CP_APP_SCREENER(APP_SCREENER_NUM,RES_GA_RESP,CNTY_NAME_CD,NUM_CHLD_UNDER_13,NUM_CHLD_UNDER_19,NUM_ADULTS_AGE_GRP_1,NUM_ADULTS_AGE_GRP_2,NUM_ADULTS_AGE_GRP_3,PREG_RESP,BREAST_FEED_RESP,END_PREG_NO_BREAST_FEED_RESP,MEDICARE_ELIGIB_RESP,GUARD_OTH_CHLD_RESP,WK_SCH_TRAIN_ACT_RESP,DABL_BLND_AND_SSA_RESP,LIVE_IN_NURS_HOME_RESP,CHLD_HLTH_INS_RESP,CHLD_HLTH_INS_LST_2MTH_RESP,CARETAKER_OF_MINOR_RESP,CARETAKER_60YRS_OLD_RESP,CARETAKER_STUDENT_RESP,NUM_HSLD_EMPLOYED,HSLD_BT_EARNED_INCOME,SS_INCOME,SSI_INCOME,UNEMPLOYMENT_INCOME,CASH_GIFTS_INCOME,ALIMONY_INCOME,RENTAL_INCOME,OTHER_INCOME,CREATE_DT,DABL_CARE_CHLD_LT_5YRS_RESP,CHLD_13_18_SPCL_NEED_RESP,WRK_AND_CARE_CHLD_RESP,HSHL_RENT_MTG_MTH_PYMT,HSHL_PAY_HEAT_COOL_EXP_RESP,RCV_SNAP_TANF_MEDICAID_RESP,SCR_ELG_RSLT_MA,SCR_ELG_RSLT_CC,SCR_ELG_RSLT_SNAP,SCR_ELG_RSLT_WIC,SCR_ELG_RSLT_TANF,SCR_ELG_RSLT_LIHEAP,CREATE_USER_NO,CREATE_USER_ID) "
			+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public boolean insert(final ICargo aCargo, final Connection aConn) {
		final CP_APP_SCREENER_Cargo cargo = (CP_APP_SCREENER_Cargo) aCargo;
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			int count = 1;
			conn = aConn;
			final java.sql.Date create_Dt = new java.sql.Date(
					(new java.util.Date().getTime()));

			statement = conn.prepareStatement(INSERT_SQL);

			statement.setInt(count++,
					Integer.parseInt(cargo.getApp_screener_num()));
			statement.setString(count++, cargo.getRes_ga_resp());
			statement.setString(count++, cargo.getCnty_name_cd());
			if (!(FwConstants.EMPTY_STRING)
					.equals(cargo.getNum_chld_under_13())) {
				statement.setInt(count++,
						Integer.parseInt(cargo.getNum_chld_under_13()));
			} else {
				statement.setInt(count++, Integer.parseInt("0"));
			}
			if (!(FwConstants.EMPTY_STRING)
					.equals(cargo.getNum_chld_under_19())) {
				statement.setInt(count++,
						Integer.parseInt(cargo.getNum_chld_under_19()));
			} else {
				statement.setInt(count++, Integer.parseInt("0"));
			}

			if (!(FwConstants.EMPTY_STRING).equals(cargo
					.getNum_adults_age_grp_1())) {
				statement.setInt(count++,
						Integer.parseInt(cargo.getNum_adults_age_grp_1()));
			} else {
				statement.setInt(count++, Integer.parseInt("0"));
			}

			if (!(FwConstants.EMPTY_STRING).equals(cargo
					.getNum_adults_age_grp_2())) {
				statement.setInt(count++,
						Integer.parseInt(cargo.getNum_adults_age_grp_2()));
			} else {
				statement.setInt(count++, Integer.parseInt("0"));
			}

			if (!(FwConstants.EMPTY_STRING).equals(cargo
					.getNum_adults_age_grp_3())) {
				statement.setInt(count++,
						Integer.parseInt(cargo.getNum_adults_age_grp_3()));
			} else {
				statement.setInt(count++, Integer.parseInt("0"));
			}

			statement.setString(count++, cargo.getPreg_resp());
			statement.setString(count++, cargo.getBreast_feed_resp());
			statement.setString(count++,
					cargo.getEnd_preg_no_breast_feed_resp());
			statement.setString(count++, cargo.getMedicare_eligib_resp());
			statement.setString(count++, cargo.getGuard_oth_chld_resp());
			statement.setString(count++, cargo.getWk_sch_train_act_resp());
			statement.setString(count++, cargo.getDabl_blnd_and_ssa_resp());
			statement.setString(count++, cargo.getLive_in_nurs_home_resp());
			statement.setString(count++, cargo.getChld_hlth_ins_resp());
			statement
					.setString(count++, cargo.getChld_hlth_ins_lst_2mth_resp());
			statement.setString(count++, cargo.getCaretaker_of_minor_resp());
			statement.setString(count++, cargo.getCaretaker_60yrs_old_resp());
			statement.setString(count++, cargo.getCaretaker_student_resp());

			if (!(FwConstants.EMPTY_STRING)
					.equals(cargo.getNum_hsld_employed())) {
				statement.setDouble(count++,
						Double.parseDouble(cargo.getNum_hsld_employed()));
			} else {
				statement.setDouble(count++, Double.parseDouble("0"));
			}
			if (!(FwConstants.EMPTY_STRING).equals(cargo
					.getHsld_bt_earned_income())) {
				statement.setDouble(count++,
						Double.parseDouble(cargo.getHsld_bt_earned_income()));
			} else {
				statement.setDouble(count++, Double.parseDouble("0"));
			}
			if (!(FwConstants.EMPTY_STRING).equals(cargo.getSs_income())) {
				statement.setDouble(count++,
						Double.parseDouble(cargo.getSs_income()));
			} else {
				statement.setDouble(count++, Double.parseDouble("0"));
			}
			if (!(FwConstants.EMPTY_STRING).equals(cargo.getSsi_income())) {
				statement.setDouble(count++,
						Double.parseDouble(cargo.getSsi_income()));
			} else {
				statement.setDouble(count++, Double.parseDouble("0"));
			}
			if (!(FwConstants.EMPTY_STRING).equals(cargo
					.getUnemployment_income())) {
				statement.setDouble(count++,
						Double.parseDouble(cargo.getUnemployment_income()));
			} else {
				statement.setDouble(count++, Double.parseDouble("0"));
			}
			if (!(FwConstants.EMPTY_STRING)
					.equals(cargo.getCash_gifts_income())) {
				statement.setDouble(count++,
						Double.parseDouble(cargo.getCash_gifts_income()));
			} else {
				statement.setDouble(count++, Double.parseDouble("0"));
			}
			if (!(FwConstants.EMPTY_STRING).equals(cargo.getAlimony_income())) {
				statement.setDouble(count++,
						Double.parseDouble(cargo.getAlimony_income()));
			} else {
				statement.setDouble(count++, Double.parseDouble("0"));
			}
			if (!(FwConstants.EMPTY_STRING).equals(cargo.getRental_income())) {
				statement.setDouble(count++,
						Double.parseDouble(cargo.getRental_income()));
			} else {
				statement.setDouble(count++, Double.parseDouble("0"));
			}
			if (!(FwConstants.EMPTY_STRING).equals(cargo.getOther_income())) {
				statement.setDouble(count++,
						Double.parseDouble(cargo.getOther_income()));
			} else {
				statement.setDouble(count++, Double.parseDouble("0"));
			}
			statement.setDate(count++, create_Dt);

			statement
					.setString(count++, cargo.getDabl_care_chld_lt_5yrs_resp());
			statement.setString(count++, cargo.getChld_13_18_spcl_need_resp());
			statement.setString(count++, cargo.getWrk_and_care_chld_resp());
			if ((cargo.getHshl_rent_mtg_mth_pymt() != null)
					&& !(FwConstants.EMPTY_STRING).equals(cargo
							.getHshl_rent_mtg_mth_pymt())) {
				statement.setDouble(count++,
						Double.parseDouble(cargo.getHshl_rent_mtg_mth_pymt()));
			} else {
				statement.setDouble(count++, Double.parseDouble("0"));
			}

			statement
					.setString(count++, cargo.getHshl_pay_heat_cool_exp_resp());
			statement
					.setString(count++, cargo.getRcv_snap_tanf_medicaid_resp());
			statement.setString(count++, cargo.getScr_elg_rslt_ma());
			statement.setString(count++, cargo.getScr_elg_rslt_cc());
			statement.setString(count++, cargo.getScr_elg_rslt_snap());
			statement.setString(count++, cargo.getScr_elg_rslt_wic());
			statement.setString(count++, cargo.getScr_elg_rslt_tanf());
			statement.setString(count++, cargo.getScr_elg_rslt_liheap());
			statement.setString(count++, cargo.getCreate_user_no());
			statement.setString(count++, cargo.getCreate_user_id());

			final int res = statement.executeUpdate();
			if (res == 0) {
				final FwException fe = new FwException(IDAO.NO_REC_INSERTED);
				fe.setMethodID("insert");
				fe.setServiceMessage(IDAO.NO_REC_INSERTED);
				throw fe;
			}
		} catch (final SQLException sqle) {
			final FwException fe = new FwException(sqle);
			FwExceptionManager.setSqlca(sqle, fe);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("insert");
			fe.setExceptionType(FwConstants.EXP_TYP_DAO);
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(sqle));
			fe.setExceptionText(String.valueOf(sqle));
			fe.setServiceName(this.getClass().getName());
			fe.setServiceMethod("insert");
			fe.setServiceDescription(INSERT_SQL);
			throw fe;
		} catch (final FwException fe) {
			fe.setClassID(this.getClass().getName());
			fe.setExceptionType(FwConstants.EXP_TYP_DAO);
			fe.setServiceName(this.getClass().getName());
			fe.setServiceMethod("insert");
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("insert");
			fe.setExceptionType(FwConstants.EXP_TYP_DAO);
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setServiceName(this.getClass().getName());
			fe.setServiceMethod("insert");
			throw fe;
		} finally {
			closeStatement(statement);
		}
		return true;
	}

	@Override
	public short getHistoryType() {
		return HISTORY_TYPE;
	}
}