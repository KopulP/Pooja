/*
 * 
 */
package gov.state.nextgen.access.driver.data.db2.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import gov.state.nextgen.access.business.entities.ICargo;
import gov.state.nextgen.access.driver.business.entities.PE_PREG_WMN_DRVR_Cargo;
import gov.state.nextgen.access.driver.data.db2.base.Abstract_PE_PREG_WMN_DRVR_DAO;
import gov.state.nextgen.access.exceptions.FwException;
import gov.state.nextgen.access.exceptions.FwExceptionManager;
import gov.state.nextgen.access.management.constants.FwConstants;
import gov.state.nextgen.access.management.util.FwDataCriteria;

/**
 * Data Access Object for PE_PREG_WMN_DRVR
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date Thu Jul 26 15:19:25 CDT 2007
 */
public class PE_PREG_WMN_DRVR_DAO extends Abstract_PE_PREG_WMN_DRVR_DAO {
	// Driver Table Update
	public boolean updateAPWDriverTable(final ICargo aCargo, final Connection aConn) {
		final PE_PREG_WMN_DRVR_Cargo cargo = (PE_PREG_WMN_DRVR_Cargo) aCargo;
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = aConn;
			final StringBuilder sbf = new StringBuilder();
			sbf.append("UPDATE " + getDBSchema() + ".PE_PREG_WMN_DRVR SET ");

			final FwDataCriteria[] datacriteria = cargo.getDataCriteria();
			for (int i = 0; i < (datacriteria.length - 1); i++) {
				final FwDataCriteria criteria = datacriteria[i];
				sbf.append(criteria.getColumn_name());
				sbf.append("=");
				sbf.append(criteria.getColumn_value());
				sbf.append(", ");
			}
			final FwDataCriteria criteria = datacriteria[datacriteria.length - 1];
			sbf.append(criteria.getColumn_name());
			sbf.append("=");
			sbf.append(criteria.getColumn_value());
			sbf.append(" WHERE ");
			final FwDataCriteria[] wherecriteria = cargo.getWhereCriteria();
			sbf.append(wherecriteria[0].getColumn_name());
			sbf.append("=");
			sbf.append(Long.parseLong(wherecriteria[0].getColumn_value()));
			statement = conn.prepareStatement(sbf.toString());
			statement.executeUpdate();
		} catch (final SQLException sqle) {
			final FwException fe = new FwException(sqle);
			FwExceptionManager.setSqlca(sqle, fe);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("updateAPWDriverTable");
			fe.setExceptionType(FwConstants.EXP_TYP_DAO);
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(sqle));
			fe.setExceptionText(String.valueOf(sqle));
			fe.setServiceName(this.getClass().getName());
			fe.setServiceMethod("updateAPWDriverTable");
			throw fe;
		} catch (final FwException fe) {
			fe.setClassID(this.getClass().getName());
			fe.setExceptionType(FwConstants.EXP_TYP_DAO);
			fe.setServiceName(this.getClass().getName());
			fe.setServiceMethod("updateAPWDriverTable");
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("updateAPWDriverTable");
			fe.setExceptionType(FwConstants.EXP_TYP_DAO);
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setServiceName(this.getClass().getName());
			fe.setServiceMethod("updateAPWDriverTable");
			throw fe;
		} finally {
			closeStatement(statement);
		}
		return true;
	}
}
