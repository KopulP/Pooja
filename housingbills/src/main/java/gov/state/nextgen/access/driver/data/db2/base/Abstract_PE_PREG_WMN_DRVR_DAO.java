/*
 * 
 */
package gov.state.nextgen.access.driver.data.db2.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gov.state.nextgen.access.business.entities.ICargo;
import gov.state.nextgen.access.business.entities.IPrimaryKey;
import gov.state.nextgen.access.driver.business.entities.PE_PREG_WMN_DRVR_Cargo;
import gov.state.nextgen.access.driver.business.entities.PE_PREG_WMN_DRVR_PrimaryKey;
import gov.state.nextgen.access.exceptions.FwException;
import gov.state.nextgen.access.exceptions.FwExceptionManager;
import gov.state.nextgen.access.factories.FwServiceFactory;
import gov.state.nextgen.access.management.constants.FwConstants;
import gov.state.nextgen.access.management.logging.ILog;
import gov.state.nextgen.access.management.util.FwDataCriteria;
import gov.state.nextgen.access.management.util.FwDataSortOrder;
import gov.state.nextgen.access.persistence.database.dao.FwAbstractDAO;

/**
 * Abstract Data Access Object for PE_PREG_WMN_DRVR
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date Thu Jul 26 15:19:25 CDT 2007
 */
public class Abstract_PE_PREG_WMN_DRVR_DAO extends FwAbstractDAO {

	private static final short HISTORY_TYPE = 0;

	private static final String SELECT_SQL = "SELECT APP_NUM,APPWR_STAT_IND,APWCI_STAT_IND,APWCS_STAT_IND,APWID_STAT_IND,APWII_STAT_IND,APWPS_STAT_IND FROM "
			+ getDBSchema() + FwConstants.DOT + "PE_PREG_WMN_DRVR";
	private static final String INSERT_SQL = "INSERT INTO  "
			+ getDBSchema()
			+ FwConstants.DOT
			+ "PE_PREG_WMN_DRVR(APP_NUM,APPWR_STAT_IND,APWCI_STAT_IND,APWCS_STAT_IND,APWID_STAT_IND,APWII_STAT_IND,APWPS_STAT_IND) VALUES(?,?,?,?,?,?,?)";
	private static final String PK_SELECT_SQL = "SELECT 1 FROM " + getDBSchema() + FwConstants.DOT + "PE_PREG_WMN_DRVR WHERE APP_NUM=?";
	private static final String UPDATE_SQL = "UPDATE "
			+ getDBSchema()
			+ FwConstants.DOT
			+ "PE_PREG_WMN_DRVR SET APPWR_STAT_IND=?,APWCI_STAT_IND=?,APWCS_STAT_IND=?,APWID_STAT_IND=?,APWII_STAT_IND=?,APWPS_STAT_IND=? WHERE APP_NUM=?";
	private static final String DELETE_SQL = "DELETE FROM " + getDBSchema() + FwConstants.DOT + "PE_PREG_WMN_DRVR WHERE  APP_NUM=?";
	private ILog logger = null;

	protected void log(final int level, final String message) {
		if (logger == null) {
			logger = (ILog) FwServiceFactory.getInstance().create(ILog.class);
		}
		logger.log(this.getClass(), level, message);
	}

	/**
	 * Getting the row values from the Result Set
	 */
	private void getRowFromResultSet(final PE_PREG_WMN_DRVR_Cargo row, final ResultSet rs) {

		try {
			row.setApp_num(rs.getString("APP_NUM"));
			row.setAppwr_stat_ind(rs.getString("APPWR_STAT_IND"));
			row.setApwci_stat_ind(rs.getString("APWCI_STAT_IND"));
			row.setApwcs_stat_ind(rs.getString("APWCS_STAT_IND"));
			row.setApwid_stat_ind(rs.getString("APWID_STAT_IND"));
			row.setApwii_stat_ind(rs.getString("APWII_STAT_IND"));
			row.setApwps_stat_ind(rs.getString("APWPS_STAT_IND"));
		} catch (final SQLException sqle) {
			final FwException fe = new FwException(sqle);
			fe.setMethodID("getRowFromResultSet");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(sqle));
			fe.setExceptionText(String.valueOf(sqle));
			throw fe;
		}
	}

	/**
	 * select rows from database based on the given primarykey(s)
	 * @param aCriteria select criteria
	 * @param aSort sort criteria
	 * @param aConn jdbc database connection
	 * @return array of associated Cargo classes with query results.
	 */
	public ICargo[] select(final FwDataCriteria[] aCriteria, final FwDataSortOrder[] aSort, final Connection aConn) {
		final List values = new ArrayList();
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		PE_PREG_WMN_DRVR_Cargo[] rows = null;
		final StringBuilder whereClause = new StringBuilder();
		try {
			conn = aConn;
			if (aCriteria.length == 0) {
				log(ILog.INFO, "Abstract_PE_PREG_WMN_DRVR_DAO.select() - Raising FwException manually on a condition");
				final FwException fe = new FwException(NO_SEARCH_CRITERIA);
				fe.setMethodID("select");
				fe.setServiceMessage(NO_SEARCH_CRITERIA);
				throw fe;
			}
			whereClause.append(FwConstants.WHERE);
			boolean where = false;
			boolean and = false;
			for (int i = 0; i < aCriteria.length; i++) {
				if (aCriteria[i].getColumn_name().equals("APP_NUM")) {
					where = true;
					if (and) {
						whereClause.append(FwConstants.AND);
					}
					whereClause.append(" APP_NUM=?");
					and = true;
				}
			}
			if (!where) {
				log(ILog.INFO, "Abstract_PE_PREG_WMN_DRVR_DAO.select() - Raising FwException manually on a condition");
				final FwException fe = new FwException(NO_PK_SEARCH_CRITERIA);
				fe.setMethodID("select");
				fe.setServiceMessage(NO_PK_SEARCH_CRITERIA);
				throw fe;
			}
			if ((aSort != null) && (aSort.length > 0)) {
				whereClause.append(FwConstants.ORDER_BY);
				for (int i = 0; i < aSort.length; i++) {
					if (i > 0) {
						whereClause.append(FwConstants.COMMA);
					}
					whereClause.append(aSort[i].getColumnName());
					if (aSort[i].getSortOrder() == FwDataSortOrder.asc) {
						whereClause.append(" ASC");
					} else if (aSort[i].getSortOrder() == FwDataSortOrder.desc) {
						whereClause.append(" DESC");
					}
				}
			}
			statement = conn.prepareStatement(SELECT_SQL + whereClause);
			int pos = 0;
			for (int j = 0; j < aCriteria.length; j++) {
				if (aCriteria[j].getColumn_name().equals("APP_NUM")) {
					final String value = aCriteria[j].getColumn_value();
					statement.setLong(++pos, Long.parseLong(value));
				}
			}
			rs = statement.executeQuery();
			while (rs.next()) {
				final PE_PREG_WMN_DRVR_Cargo cargo = new PE_PREG_WMN_DRVR_Cargo();
				getRowFromResultSet(cargo, rs);
				values.add(cargo);
			}
			rows = new PE_PREG_WMN_DRVR_Cargo[values.size()];
			values.toArray(rows);
		} catch (final SQLException sqle) {
			final FwException fe = new FwException(sqle);
			FwExceptionManager.setSqlca(sqle, fe);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("select");
			fe.setExceptionType(FwConstants.EXP_TYP_DAO);
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(sqle));
			fe.setExceptionText(String.valueOf(sqle));
			fe.setServiceName(this.getClass().getName());
			fe.setServiceMethod("select");
			fe.setServiceDescription(SELECT_SQL + whereClause);
			throw fe;
		} catch (final FwException fe) {
			fe.setClassID(this.getClass().getName());
			fe.setExceptionType(FwConstants.EXP_TYP_DAO);
			fe.setServiceName(this.getClass().getName());
			fe.setServiceMethod("select");
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("select");
			fe.setExceptionType(FwConstants.EXP_TYP_DAO);
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setServiceName(this.getClass().getName());
			fe.setServiceMethod("select");
			throw fe;
		} finally {
			closeResultSetAndStatement(rs, statement);
		}
		return rows;
	}

	/**
	 *  returns a not null cargo if record exists
	 * @param aKey primary key object
	 * @param aConn jdbc database conection
	 * @return Cargo class associated
	 */
	public ICargo findByPrimaryKey(final IPrimaryKey aKey, final Connection aConn) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		PE_PREG_WMN_DRVR_Cargo rescargo = null;
		final PE_PREG_WMN_DRVR_PrimaryKey key = (PE_PREG_WMN_DRVR_PrimaryKey) aKey;
		try {
			int count = 1;
			conn = aConn;
			statement = conn.prepareStatement(PK_SELECT_SQL);
			statement.setLong(count++, Long.parseLong(key.getApp_num()));
			rs = statement.executeQuery();
			if (rs.next()) {
				rescargo = new PE_PREG_WMN_DRVR_Cargo();
			}
		} catch (final SQLException sqle) {
			final FwException fe = new FwException(sqle);
			FwExceptionManager.setSqlca(sqle, fe);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("findByPrimaryKey");
			fe.setExceptionType(FwConstants.EXP_TYP_DAO);
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(sqle));
			fe.setExceptionText(String.valueOf(sqle));
			fe.setServiceName(this.getClass().getName());
			fe.setServiceMethod("findByPrimaryKey");
			fe.setServiceDescription(PK_SELECT_SQL);
			throw fe;
		} catch (final FwException fe) {
			fe.setClassID(this.getClass().getName());
			fe.setExceptionType(FwConstants.EXP_TYP_DAO);
			fe.setServiceName(this.getClass().getName());
			fe.setServiceMethod("findByPrimaryKey");
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("findByPrimaryKey");
			fe.setExceptionType(FwConstants.EXP_TYP_DAO);
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setServiceName(this.getClass().getName());
			fe.setServiceMethod("findByPrimaryKey");
			throw fe;
		} finally {
			closeResultSetAndStatement(rs, statement);
		}
		return rescargo;
	}

	/**
	 * inserts a new row in the table
	 * @param aCargo associated Cargo class
	 * @param aConn jdbc database connection
	 * @return indicates if operation has been successful
	 */
	public boolean insert(final ICargo aCargo, final Connection aConn) {
		final PE_PREG_WMN_DRVR_Cargo cargo = (PE_PREG_WMN_DRVR_Cargo) aCargo;
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			int count = 1;
			conn = aConn;
			statement = conn.prepareStatement(INSERT_SQL);
			statement.setLong(count++, Long.parseLong(cargo.getApp_num()));
			statement.setShort(count++, Short.parseShort(cargo.getAppwr_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getApwci_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getApwcs_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getApwid_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getApwii_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getApwps_stat_ind()));
			final int res = statement.executeUpdate();
			if (res == 0) {
				log(ILog.INFO, "Abstract_PE_PREG_WMN_DRVR_DAO.insert() - Raising FwException manually on a condition");
				final FwException fe = new FwException(NO_REC_INSERTED);
				fe.setMethodID("insert");
				fe.setServiceMessage(NO_REC_INSERTED);
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

	/**
	 * updates row in the table
	 * @param aCargo associated Cargo class
	 * @param aConn jdbc database connection
	 * @return indicates if operation has been successful
	 */
	public boolean update(final ICargo aCargo, final Connection aConn) {
		final PE_PREG_WMN_DRVR_Cargo cargo = (PE_PREG_WMN_DRVR_Cargo) aCargo;
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			int count = 1;
			conn = aConn;
			statement = conn.prepareStatement(UPDATE_SQL);
			statement.setShort(count++, Short.parseShort(cargo.getAppwr_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getApwci_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getApwcs_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getApwid_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getApwii_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getApwps_stat_ind()));
			statement.setLong(count++, Long.parseLong(cargo.getApp_num()));
			final int res = statement.executeUpdate();
			if (res == 0) {
				log(ILog.INFO, "Abstract_PE_PREG_WMN_DRVR_DAO.update() - Raising FwException manually on a condition");
				final FwException fe = new FwException(NO_REC_UPDATED);
				fe.setMethodID("update");
				fe.setServiceMessage(NO_REC_UPDATED);
				throw fe;
			}
		} catch (final SQLException sqle) {
			final FwException fe = new FwException(sqle);
			FwExceptionManager.setSqlca(sqle, fe);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("update");
			fe.setExceptionType(FwConstants.EXP_TYP_DAO);
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(sqle));
			fe.setExceptionText(String.valueOf(sqle));
			fe.setServiceName(this.getClass().getName());
			fe.setServiceMethod("update");
			fe.setServiceDescription(UPDATE_SQL);
			throw fe;
		} catch (final FwException fe) {
			fe.setClassID(this.getClass().getName());
			fe.setExceptionType(FwConstants.EXP_TYP_DAO);
			fe.setServiceName(this.getClass().getName());
			fe.setServiceMethod("update");
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("update");
			fe.setExceptionType(FwConstants.EXP_TYP_DAO);
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setServiceName(this.getClass().getName());
			fe.setServiceMethod("update");
			throw fe;
		} finally {
			closeStatement(statement);
		}
		return true;
	}

	/**
	 * deletes row in the table
	 * @param aCargo cargo class associated
	 * @param aConn jdbc databse connection
	 * @return indicates if operation is been successful
	 */
	public boolean delete(final ICargo aCargo, final Connection aConn) {
		final PE_PREG_WMN_DRVR_Cargo cargo = (PE_PREG_WMN_DRVR_Cargo) aCargo;
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			int count = 1;
			conn = aConn;
			statement = conn.prepareStatement(DELETE_SQL);
			statement.setLong(count++, Long.parseLong(cargo.getApp_num()));
			final int res = statement.executeUpdate();
			if (res == 0) {
				log(ILog.INFO, "Abstract_PE_PREG_WMN_DRVR_DAO.delete() - Raising FwException manually on a condition");
				final FwException fe = new FwException(NO_REC_DELETED);
				fe.setMethodID("delete");
				fe.setServiceMessage(NO_REC_DELETED);
				throw fe;
			}
		} catch (final SQLException sqle) {
			final FwException fe = new FwException(sqle);
			FwExceptionManager.setSqlca(sqle, fe);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("delete");
			fe.setExceptionType(FwConstants.EXP_TYP_DAO);
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(sqle));
			fe.setExceptionText(String.valueOf(sqle));
			fe.setServiceName(this.getClass().getName());
			fe.setServiceMethod("delete");
			fe.setServiceDescription(DELETE_SQL);
			throw fe;
		} catch (final FwException fe) {
			fe.setClassID(this.getClass().getName());
			fe.setExceptionType(FwConstants.EXP_TYP_DAO);
			fe.setServiceName(this.getClass().getName());
			fe.setServiceMethod("delete");
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("delete");
			fe.setExceptionType(FwConstants.EXP_TYP_DAO);
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setServiceName(this.getClass().getName());
			fe.setServiceMethod("delete");
			throw fe;
		} finally {
			closeStatement(statement);
		}
		return true;
	}

	/**
	 * returns the History Type of the DAO
	 * @return history type.
	 */
	@Override
	public short getHistoryType() {
		return HISTORY_TYPE;
	}
}