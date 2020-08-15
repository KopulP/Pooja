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
import gov.state.nextgen.access.driver.business.entities.RMC_DRVR_Cargo;
import gov.state.nextgen.access.driver.business.entities.RMC_DRVR_PrimaryKey;
import gov.state.nextgen.access.exceptions.FwException;
import gov.state.nextgen.access.exceptions.FwExceptionManager;
import gov.state.nextgen.access.factories.FwServiceFactory;
import gov.state.nextgen.access.management.constants.FwConstants;
import gov.state.nextgen.access.management.logging.ILog;
import gov.state.nextgen.access.management.util.FwDataCriteria;
import gov.state.nextgen.access.management.util.FwDataSortOrder;
import gov.state.nextgen.access.persistence.database.dao.FwAbstractDAO;

/**
 * Abstract Data Access Object for RMC_DRVR
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date Aug 11 16:15:25 CDT 2009 Modified By: Modified on: PCR#
 */

public class Abstract_RMC_DRVR_DAO extends FwAbstractDAO {

	private static final short HISTORY_TYPE = 0;

	private static final String SELECT_SQL = "SELECT APP_NUM,ARACD_STAT_IND,ARCAT_STAT_IND,ARHAP_STAT_IND,ARHCS_STAT_IND,ARHDD_STAT_IND,ARHDE_STAT_IND,ARHIS_STAT_IND,ARHMA_STAT_IND,ARHMD_STAT_IND,ARHMI_STAT_IND,ARHMO_STAT_IND,ARHPD_STAT_IND,ARHPG_STAT_IND,ARHRL_STAT_IND,ARHSE_STAT_IND,ARJID_STAT_IND,AREHI_STAT_IND,ARJIS_STAT_IND,ARJSD_STAT_IND,ARJSE_STAT_IND,ARPRS_STAT_IND,ARTKY_STAT_IND,ARUID_STAT_IND,ARUII_STAT_IND,ARUIS_STAT_IND,ARUIT_STAT_IND,ARXHD_STAT_IND,ARXHI_STAT_IND,ARXHS_STAT_IND,ARXHU_STAT_IND,ARXUD_STAT_IND,HSCSO_STAT_IND,HSHER_STAT_IND,HSHMO_STAT_IND,ARACS_STAT_IND,ARAGQ_STAT_IND,ARAIQ_STAT_IND,ARASM_STAT_IND,ARBAD_STAT_IND,ARBAT_STAT_IND,ARDCD_STAT_IND,ARDFD_STAT_IND,ARFAS_STAT_IND,ARHCD_STAT_IND,ARHOD_STAT_IND,ARIWE_STAT_IND,ARJGQ_STAT_IND,ARLAD_STAT_IND,ARLAT_STAT_IND,ARLID_STAT_IND,ARLIT_STAT_IND,ARMAP_STAT_IND,ARMBD_STAT_IND,AROBC_STAT_IND,AROBI_STAT_IND,AROBQ_STAT_IND,AROBS_STAT_IND,AROIQ_STAT_IND,ARPCS_STAT_IND,ARPGQ_STAT_IND,ARPIQ_STAT_IND,ARPPD_STAT_IND,ARRBE_STAT_IND,ARRPD_STAT_IND,ARRPT_STAT_IND,ARSOD_STAT_IND,ARVAD_STAT_IND,ARVAT_STAT_IND,ARXGQ_STAT_IND,ARXIQ_STAT_IND,ARRBI_STAT_IND,ARAPA_STAT_IND,ARPLR_STAT_IND,ARHOH_STAT_IND,ARCPA_STAT_IND,ARSTD_STAT_IND,ARAVD_STAT_IND,ARDGP_STAT_IND,ARSUM_STAT_IND,ARHMX_STAT_IND,ARMED_STAT_IND,ARHPS_STAT_IND,ARHOS_STAT_IND,ARNUR_STAT_IND,AROFS_STAT_IND,ARORT_STAT_IND,ARORD_STAT_IND,ARIKI_STAT_IND,ARHBT_STAT_IND,ARBBQ_STAT_IND,ARCCC_STAT_IND,ARCSC_STAT_IND,ARMBB_STAT_IND,ARBBS_STAT_IND,ARCTA_STAT_IND,ARCON_STAT_IND,ARAFP_STAT_IND,ARMAA_STAT_IND,ARIPI_STAT_IND,ARMOV_STAT_IND,ARDOC_STAT_IND,ARARP_STAT_IND,ARFIN_STAT_IND,ARIDP_STAT_IND,ARBUS_STAT_IND,ARHPA_STAT_IND,ARLHI_STAT_IND,ARBTT_STAT_IND,ARBTD_STAT_IND,ARITD_STAT_IND,ARHIN_STAT_IND,AROHI_STAT_IND,ARTXI_STAT_IND,ARTDP_STAT_IND,ARTAX_STAT_IND,ARPRE_STAT_IND,ARRLD_STAT_IND,ARCFN_STAT_IND,ARBCN_STAT_IND FROM "
			+ getDBSchema() + FwConstants.DOT + "CP_RMC_DRVR";
	private static final String INSERT_SQL = "INSERT INTO "
			+ getDBSchema()
			+ FwConstants.DOT
			+ "CP_RMC_DRVR(APP_NUM,ARACD_STAT_IND,ARCAT_STAT_IND,ARHAP_STAT_IND,ARHCS_STAT_IND,ARHDD_STAT_IND,ARHDE_STAT_IND,ARHIS_STAT_IND,ARHMA_STAT_IND,ARHMD_STAT_IND,ARHMI_STAT_IND,ARHMO_STAT_IND,ARHPD_STAT_IND,ARHPG_STAT_IND,ARHRL_STAT_IND,ARHSE_STAT_IND,ARJID_STAT_IND,AREHI_STAT_IND,ARJIS_STAT_IND,ARJSD_STAT_IND,ARJSE_STAT_IND,ARPRS_STAT_IND,ARTKY_STAT_IND,ARUID_STAT_IND,ARUII_STAT_IND,ARUIS_STAT_IND,ARUIT_STAT_IND,ARXHD_STAT_IND,ARXHI_STAT_IND,ARXHS_STAT_IND,ARXHU_STAT_IND,ARXUD_STAT_IND,HSCSO_STAT_IND,HSHER_STAT_IND,HSHMO_STAT_IND,ARACS_STAT_IND,ARAGQ_STAT_IND,ARAIQ_STAT_IND,ARASM_STAT_IND,ARBAD_STAT_IND,ARBAT_STAT_IND,ARDCD_STAT_IND,ARDFD_STAT_IND,ARFAS_STAT_IND,ARHCD_STAT_IND,ARHOD_STAT_IND,ARIWE_STAT_IND,ARJGQ_STAT_IND,ARLAD_STAT_IND,ARLAT_STAT_IND,ARLID_STAT_IND,ARLIT_STAT_IND,ARMAP_STAT_IND,ARMBD_STAT_IND,AROBC_STAT_IND,AROBI_STAT_IND,AROBQ_STAT_IND,AROBS_STAT_IND,AROIQ_STAT_IND,ARPCS_STAT_IND,ARPGQ_STAT_IND,ARPIQ_STAT_IND,ARPPD_STAT_IND,ARRBE_STAT_IND,ARRPD_STAT_IND,ARRPT_STAT_IND,ARSOD_STAT_IND,ARVAD_STAT_IND,ARVAT_STAT_IND,ARXGQ_STAT_IND,ARXIQ_STAT_IND,ARRBI_STAT_IND,ARAPA_STAT_IND,ARPLR_STAT_IND,ARHOH_STAT_IND,ARCPA_STAT_IND,ARSTD_STAT_IND,ARAVD_STAT_IND,ARDGP_STAT_IND,ARSUM_STAT_IND,ARHMX_STAT_IND,ARMED_STAT_IND,ARHPS_STAT_IND,ARHOS_STAT_IND,ARNUR_STAT_IND,AROFS_STAT_IND,ARORT_STAT_IND,ARORD_STAT_IND,ARIKI_STAT_IND,ARHBT_STAT_IND,ARBBQ_STAT_IND,ARCCC_STAT_IND,ARCSC_STAT_IND,ARMBB_STAT_IND,ARBBS_STAT_IND,ARCTA_STAT_IND,ARCON_STAT_IND,ARAFP_STAT_IND,ARMAA_STAT_IND,ARIPI_STAT_IND,ARMOV_STAT_IND,ARDOC_STAT_IND,ARARP_STAT_IND,ARFIN_STAT_IND,ARIDP_STAT_IND,ARBUS_STAT_IND,ARHPA_STAT_IND,ARLHI_STAT_IND,ARBTT_STAT_IND,ARBTD_STAT_IND,ARITD_STAT_IND,ARHIN_STAT_IND,AROHI_STAT_IND,ARTXI_STAT_IND,ARTDP_STAT_IND,ARTAX_STAT_IND,ARPRE_STAT_IND,ARRLD_STAT_IND,ARCFN_STAT_IND,ARBCN_STAT_IND) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String PK_SELECT_SQL = "SELECT 1 FROM " + getDBSchema() + FwConstants.DOT + "CP_RMC_DRVR WHERE APP_NUM=?";
	private static final String UPDATE_SQL = "UPDATE "
			+ getDBSchema()
			+ FwConstants.DOT
			+ "CP_RMC_DRVR SET ARACD_STAT_IND=?,ARCAT_STAT_IND=?,ARHAP_STAT_IND=?,ARHCS_STAT_IND=?,ARHDD_STAT_IND=?,ARHDE_STAT_IND=?,ARHIS_STAT_IND=?,ARHMA_STAT_IND=?,ARHMD_STAT_IND=?,ARHMI_STAT_IND=?,ARHMO_STAT_IND=?,ARHPD_STAT_IND=?,ARHPG_STAT_IND=?,ARHRL_STAT_IND=?,ARHSE_STAT_IND=?,ARJID_STAT_IND=?,AREHI_STAT_IND=?,ARJIS_STAT_IND=?,ARJSD_STAT_IND=?,ARJSE_STAT_IND=?,ARPRS_STAT_IND=?,ARTKY_STAT_IND=?,ARUID_STAT_IND=?,ARUII_STAT_IND=?,ARUIS_STAT_IND=?,ARUIT_STAT_IND=?,ARXHD_STAT_IND=?,ARXHI_STAT_IND=?,ARXHS_STAT_IND=?,ARXHU_STAT_IND=?,ARXUD_STAT_IND=?,HSCSO_STAT_IND=?,HSHER_STAT_IND=?,HSHMO_STAT_IND=?,ARACS_STAT_IND=?,ARAGQ_STAT_IND=?,ARAIQ_STAT_IND=?,ARASM_STAT_IND=?,ARBAD_STAT_IND=?,ARBAT_STAT_IND=?,ARDCD_STAT_IND=?,ARDFD_STAT_IND=?,ARFAS_STAT_IND=?,ARHCD_STAT_IND=?,ARHOD_STAT_IND=?,ARIWE_STAT_IND=?,ARJGQ_STAT_IND=?,ARLAD_STAT_IND=?,ARLAT_STAT_IND=?,ARLID_STAT_IND=?,ARLIT_STAT_IND=?,ARMAP_STAT_IND=?,ARMBD_STAT_IND=?,AROBC_STAT_IND=?,AROBI_STAT_IND=?,AROBQ_STAT_IND=?,AROBS_STAT_IND=?,AROIQ_STAT_IND=?,ARPCS_STAT_IND=?,ARPGQ_STAT_IND=?,ARPIQ_STAT_IND=?,ARPPD_STAT_IND=?,ARRBE_STAT_IND=?,ARRPD_STAT_IND=?,ARRPT_STAT_IND=?,ARSOD_STAT_IND=?,ARVAD_STAT_IND=?,ARVAT_STAT_IND=?,ARXGQ_STAT_IND=?,ARXIQ_STAT_IND=?,ARRBI_STAT_IND=?,ARAPA_STAT_IND=?,ARPLR_STAT_IND=? ,ARHOH_STAT_IND=?,ARCPA_STAT_IND=?,ARSTD_STAT_IND=?,ARAVD_STAT_IND=?,ARDGP_STAT_IND=?,ARSUM_STAT_IND=?,ARHMX_STAT_IND=?,ARMED_STAT_IND=?,ARHPS_STAT_IND=?,ARHOS_STAT_IND=?,ARNUR_STAT_IND=?,AROFS_STAT_IND,ARORT_STAT_IND=?,ARORD_STAT_IND=?,ARIKI_STAT_IND=?,ARHBT_STAT_IND=?,ARBBQ_STAT_IND=?,ARCCC_STAT_IND=?,ARCSC_STAT_IND=?,ARMBB_STAT_IND=?,ARBBS_STAT_IND=?,ARCTA_STAT_IND=?,ARCON_STAT_IND=?,ARAFP_STAT_IND=?,ARMAA_STAT_IND=?,ARIPI_STAT_IND=?,ARMOV_STAT_IND=?,ARDOC_STAT_IND=?,ARARP_STAT_IND=?,ARFIN_STAT_IND=?,ARIDP_STAT_IND=?,ARBUS_STAT_IND=?,ARHPA_STAT_IND=?,ARLHI_STAT_IND=?,ARBTT_STAT_IND=?,ARBTD_STAT_IND=?,ARITD_STAT_IND=?,ARHIN_STAT_IND=?,AROHI_STAT_IND=?,ARTXI_STAT_IND=?,ARTDP_STAT_IND=?,ARTAX_STAT_IND=?,ARPRE_STAT_IND=?,ARRLD_STAT_IND=?,ARCFN_STAT_IND=?,ARBCN_STAT_IND=? WHERE APP_NUM=?";
	private static final String DELETE_SQL = "DELETE FROM " + getDBSchema() + FwConstants.DOT + "CP_RMC_DRVR WHERE APP_NUM =? ";
	private ILog logger = null;

	protected void log(final int level, final String message) {
		if (logger == null) {
			logger = (ILog) FwServiceFactory.getInstance().create(ILog.class);
		}
		logger.log(this.getClass(), level, message);
	}

	/**
	 * Getting the row values from the Result Set
     *
	 * @param row cargo with required values
	 * @param rs jdbc resultSet
	 */
	public void getRowFromResultSet(final RMC_DRVR_Cargo row, final ResultSet rs) {
		try {
			row.setApp_num(rs.getString("APP_NUM"));
			row.setAracd_stat_ind(rs.getString("ARACD_STAT_IND"));
			row.setArcat_stat_ind(rs.getString("ARCAT_STAT_IND"));
			row.setArhap_stat_ind(rs.getString("ARHAP_STAT_IND"));
			row.setArhcs_stat_ind(rs.getString("ARHCS_STAT_IND"));
			row.setArhdd_stat_ind(rs.getString("ARHDD_STAT_IND"));
			row.setArhde_stat_ind(rs.getString("ARHDE_STAT_IND"));
			row.setArhis_stat_ind(rs.getString("ARHIS_STAT_IND"));
			row.setArhma_stat_ind(rs.getString("ARHMA_STAT_IND"));
			row.setArhmd_stat_ind(rs.getString("ARHMD_STAT_IND"));
			row.setArhmi_stat_ind(rs.getString("ARHMI_STAT_IND"));
			row.setArhmo_stat_ind(rs.getString("ARHMO_STAT_IND"));
			row.setArhpd_stat_ind(rs.getString("ARHPD_STAT_IND"));
			row.setArhpg_stat_ind(rs.getString("ARHPG_STAT_IND"));
			row.setArhrl_stat_ind(rs.getString("ARHRL_STAT_IND"));
			row.setArhse_stat_ind(rs.getString("ARHSE_STAT_IND"));
			row.setArjid_stat_ind(rs.getString("ARJID_STAT_IND"));
			row.setArehi_stat_ind(rs.getString("AREHI_STAT_IND"));
			row.setArjis_stat_ind(rs.getString("ARJIS_STAT_IND"));
			row.setArjsd_stat_ind(rs.getString("ARJSD_STAT_IND"));
			row.setArjse_stat_ind(rs.getString("ARJSE_STAT_IND"));
			row.setArprs_stat_ind(rs.getString("ARPRS_STAT_IND"));
			row.setArtky_stat_ind(rs.getString("ARTKY_STAT_IND"));
			row.setAruid_stat_ind(rs.getString("ARUID_STAT_IND"));
			row.setAruii_stat_ind(rs.getString("ARUII_STAT_IND"));
			row.setAruis_stat_ind(rs.getString("ARUIS_STAT_IND"));
			row.setAruit_stat_ind(rs.getString("ARUIT_STAT_IND"));
			row.setArxhd_stat_ind(rs.getString("ARXHD_STAT_IND"));
			row.setArxhi_stat_ind(rs.getString("ARXHI_STAT_IND"));
			row.setArxhs_stat_ind(rs.getString("ARXHS_STAT_IND"));
			row.setArxhu_stat_ind(rs.getString("ARXHU_STAT_IND"));
			row.setArxud_stat_ind(rs.getString("ARXUD_STAT_IND"));
			row.setHscso_stat_ind(rs.getString("HSCSO_STAT_IND"));
			row.setHsher_stat_ind(rs.getString("HSHER_STAT_IND"));
			row.setHshmo_stat_ind(rs.getString("HSHMO_STAT_IND"));
			row.setAracs_stat_ind(rs.getString("ARACS_STAT_IND"));
			row.setAragq_stat_ind(rs.getString("ARAGQ_STAT_IND"));
			row.setAraiq_stat_ind(rs.getString("ARAIQ_STAT_IND"));
			row.setArasm_stat_ind(rs.getString("ARASM_STAT_IND"));
			row.setArbad_stat_ind(rs.getString("ARBAD_STAT_IND"));
			row.setArbat_stat_ind(rs.getString("ARBAT_STAT_IND"));
			row.setArdcd_stat_ind(rs.getString("ARDCD_STAT_IND"));
			row.setArdfd_stat_ind(rs.getString("ARDFD_STAT_IND"));
			row.setArfas_stat_ind(rs.getString("ARFAS_STAT_IND"));
			row.setArhcd_stat_ind(rs.getString("ARHCD_STAT_IND"));
			row.setArhod_stat_ind(rs.getString("ARHOD_STAT_IND"));
			row.setAriwe_stat_ind(rs.getString("ARIWE_STAT_IND"));
			row.setArjgq_stat_ind(rs.getString("ARJGQ_STAT_IND"));
			row.setArlad_stat_ind(rs.getString("ARLAD_STAT_IND"));
			row.setArlat_stat_ind(rs.getString("ARLAT_STAT_IND"));
			row.setArlid_stat_ind(rs.getString("ARLID_STAT_IND"));
			row.setArlit_stat_ind(rs.getString("ARLIT_STAT_IND"));
			row.setArmap_stat_ind(rs.getString("ARMAP_STAT_IND"));
			row.setArmbd_stat_ind(rs.getString("ARMBD_STAT_IND"));
			row.setArobc_stat_ind(rs.getString("AROBC_STAT_IND"));
			row.setArobi_stat_ind(rs.getString("AROBI_STAT_IND"));
			row.setArobq_stat_ind(rs.getString("AROBQ_STAT_IND"));
			row.setArobs_stat_ind(rs.getString("AROBS_STAT_IND"));
			row.setAroiq_stat_ind(rs.getString("AROIQ_STAT_IND"));
			row.setArpcs_stat_ind(rs.getString("ARPCS_STAT_IND"));
			row.setArpgq_stat_ind(rs.getString("ARPGQ_STAT_IND"));
			row.setArpiq_stat_ind(rs.getString("ARPIQ_STAT_IND"));
			row.setArppd_stat_ind(rs.getString("ARPPD_STAT_IND"));
			row.setArrbe_stat_ind(rs.getString("ARRBE_STAT_IND"));
			row.setArrpd_stat_ind(rs.getString("ARRPD_STAT_IND"));
			row.setArrpt_stat_ind(rs.getString("ARRPT_STAT_IND"));
			row.setArsod_stat_ind(rs.getString("ARSOD_STAT_IND"));
			row.setArvad_stat_ind(rs.getString("ARVAD_STAT_IND"));
			row.setArvat_stat_ind(rs.getString("ARVAT_STAT_IND"));
			row.setArxgq_stat_ind(rs.getString("ARXGQ_STAT_IND"));
			row.setArxiq_stat_ind(rs.getString("ARXIQ_STAT_IND"));
			row.setArrbi_stat_ind(rs.getString("ARRBI_STAT_IND"));
			row.setArapa_stat_ind(rs.getString("ARAPA_STAT_IND"));
			row.setArplr_stat_ind(rs.getString("ARPLR_STAT_IND"));
			row.setArhoh_stat_ind(rs.getString("ARHOH_STAT_IND"));
			row.setArcpa_stat_ind(rs.getString("ARCPA_STAT_IND"));
			row.setArstd_stat_ind(rs.getString("ARSTD_STAT_IND"));
			row.setAravd_stat_ind(rs.getString("ARAVD_STAT_IND"));
			row.setArdgp_stat_ind(rs.getString("ARDGP_STAT_IND"));
			row.setArsum_stat_ind(rs.getString("ARSUM_STAT_IND"));
			row.setArhmx_stat_ind(rs.getString("ARHMX_STAT_IND"));
			row.setArmed_stat_ind(rs.getString("ARMED_STAT_IND"));
			row.setArhps_stat_ind(rs.getString("ARHPS_STAT_IND"));
			row.setArhos_stat_ind(rs.getString("ARHOS_STAT_IND"));
			row.setArnur_stat_ind(rs.getString("ARNUR_STAT_IND"));
			row.setArofs_stat_ind(rs.getString("AROFS_STAT_IND"));
			row.setArort_stat_ind(rs.getString("ARORT_STAT_IND"));
			row.setArord_stat_ind(rs.getString("ARORD_STAT_IND"));
			row.setAriki_stat_ind(rs.getString("ARIKI_STAT_IND"));
			row.setArhbt_stat_ind(rs.getString("ARHBT_STAT_IND"));
			row.setArbbq_stat_ind(rs.getString("ARBBQ_STAT_IND"));
			row.setArccc_stat_ind(rs.getString("ARCCC_STAT_IND"));
			row.setArcsc_stat_ind(rs.getString("ARCSC_STAT_IND"));
			row.setArmbb_stat_ind(rs.getString("ARMBB_STAT_IND"));
			row.setArbbs_stat_ind(rs.getString("ARBBS_STAT_IND"));
			row.setArcta_stat_ind(rs.getString("ARCTA_STAT_IND"));
			row.setArcon_stat_ind(rs.getString("ARCON_STAT_IND"));
			row.setArafp_stat_ind(rs.getString("ARAFP_STAT_IND"));
			row.setArmaa_stat_ind(rs.getString("ARMAA_STAT_IND"));
			row.setAripi_stat_ind(rs.getString("ARIPI_STAT_IND"));
			row.setArmov_stat_ind(rs.getString("ARMOV_STAT_IND"));
			row.setArdoc_stat_ind(rs.getString("ARDOC_STAT_IND"));
			row.setArarp_stat_ind(rs.getString("ARARP_STAT_IND"));
			row.setArfin_stat_ind(rs.getString("ARFIN_STAT_IND"));
			row.setAridp_stat_ind(rs.getString("ARIDP_STAT_IND"));
			row.setArbus_stat_ind(rs.getString("ARBUS_STAT_IND"));
			row.setArhpa_stat_ind(rs.getString("ARHPA_STAT_IND"));
			row.setArlhi_stat_ind(rs.getString("ARLHI_STAT_IND"));
			//NextGen  NG-6481 Phase 3 updates to ACA Streamline changes : Start
			row.setArbtt_stat_ind(rs.getString("ARBTT_STAT_IND"));
			row.setArbtd_stat_ind(rs.getString("ARBTD_STAT_IND"));
			row.setAritd_stat_ind(rs.getString("ARITD_STAT_IND"));
			// NextGen  NG-6481 Phase 3 updates to ACA Streamline changes � end
			row.setArhin_stat_ind(rs.getString("ARHIN_STAT_IND"));
			row.setArohi_stat_ind(rs.getString("AROHI_STAT_IND"));
			row.setArtxi_stat_ind(rs.getString("ARTXI_STAT_IND"));
			row.setArtdp_stat_ind(rs.getString("ARTDP_STAT_IND"));
			row.setArtax_stat_ind(rs.getString("ARTAX_STAT_IND"));
			row.setArpre_stat_ind(rs.getString("ARPRE_STAT_IND"));
			row.setArrld_stat_ind(rs.getString("ARRLD_STAT_IND"));
			row.setArcfn_stat_ind(rs.getString("ARCFN_STAT_IND"));
			row.setArbcn_stat_ind(rs.getString("ARBCN_STAT_IND"));

		} catch (final SQLException sqle) {
			final FwException fe = new FwException(sqle);
			fe.setMethodID("getRowFromResultSet");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(sqle));
			fe.setExceptionText(String.valueOf(sqle));
			throw fe;
		}
	}

	/**
	 * select rows from database based on the give primarykey(s)
	 * @param aCriteria query criteria
	 * @param aSort sort criteria
	 * @param aConn jdbc database connection
	 * @return associated Cargo class
	 */
	public ICargo[] select(final FwDataCriteria[] aCriteria, final FwDataSortOrder[] aSort, final Connection aConn) {
		final List values = new ArrayList();
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		RMC_DRVR_Cargo[] rows = null;
		final StringBuilder whereClause = new StringBuilder();
		try {
			conn = aConn;
			if (aCriteria.length == 0) {
				log(ILog.INFO, "Abstract_RMC_DRVR_DAO.select() - Raising FwException manually on a condition");
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
				log(ILog.INFO, "Abstract_RMC_DRVR_DAO.select() - Raising FwException manually on a condition");
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
				final RMC_DRVR_Cargo cargo = new RMC_DRVR_Cargo();
				getRowFromResultSet(cargo, rs);
				values.add(cargo);
			}
			rows = new RMC_DRVR_Cargo[values.size()];
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
	 * returns a not null cargo if record exists
	 * @param aKey primary key
	 * @param aConn jdbc database connection
	 * @return associated Cargo class
	 */
	public ICargo findByPrimaryKey(final IPrimaryKey aKey, final Connection aConn) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		RMC_DRVR_Cargo rescargo = null;
		final RMC_DRVR_PrimaryKey key = (RMC_DRVR_PrimaryKey) aKey;
		try {
			int count = 1;
			conn = aConn;
			statement = conn.prepareStatement(PK_SELECT_SQL);
			statement.setLong(count++, Long.parseLong(key.getApp_num()));

			rs = statement.executeQuery();
			if (rs.next()) {
				rescargo = new RMC_DRVR_Cargo();
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
	 * inserts a new row to the table
	 * @param aCargo associated cargo class
	 * @param aConn jdbc database connection
	 * @return indicates if operation has been successful
	 */
	public boolean insert(final ICargo aCargo, final Connection aConn) {
		final RMC_DRVR_Cargo cargo = (RMC_DRVR_Cargo) aCargo;
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			int count = 1;
			conn = aConn;
			statement = conn.prepareStatement(INSERT_SQL);
			statement.setLong(count++, Long.parseLong(cargo.getApp_num()));

			if (cargo.getAracd_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getAracd_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArcat_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArcat_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArhap_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArhap_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArhcs_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArhcs_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArhdd_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArhdd_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArhde_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArhde_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArhis_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArhis_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArhma_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArhma_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArhmd_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArhmd_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArhmi_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArhmi_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArhmo_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArhmo_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArhpd_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArhpd_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArhpg_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArhpg_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArhrl_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArhrl_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArhse_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArhse_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArjid_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArjid_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArehi_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArehi_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArjis_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArjis_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArjsd_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArjsd_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArjse_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArjse_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArprs_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArprs_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArtky_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArtky_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getAruid_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getAruid_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getAruii_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getAruii_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getAruis_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getAruis_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getAruit_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getAruit_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArxhd_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArxhd_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArxhi_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArxhi_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArxhs_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArxhs_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArxhu_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArxhu_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArxud_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArxud_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getHscso_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getHscso_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getHsher_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getHsher_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getHshmo_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getHshmo_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getAracs_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getAracs_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getAragq_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getAragq_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getAraiq_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getAraiq_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArasm_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArasm_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArbad_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArbad_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArbat_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArbat_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArdcd_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArdcd_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArdfd_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArdfd_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArfas_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArfas_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArhcd_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArhcd_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArhod_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArhod_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getAriwe_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getAriwe_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArjgq_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArjgq_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArlad_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArlad_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArlat_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArlat_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArlid_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArlid_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArlit_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArlit_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArmap_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArmap_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArmbd_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArmbd_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArobc_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArobc_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArobi_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArobi_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArobq_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArobq_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArobs_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArobs_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getAroiq_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getAroiq_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArpcs_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArpcs_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArpgq_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArpgq_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArpiq_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArpiq_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArppd_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArppd_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArrbe_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArrbe_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArrpd_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArrpd_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArrpt_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArrpt_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArsod_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArsod_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArvad_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArvad_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArvat_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArvat_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArxgq_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArxgq_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArxiq_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArxiq_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArrbi_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArrbi_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArapa_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArapa_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArplr_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArplr_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArhoh_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArhoh_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArcpa_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArcpa_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArstd_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArstd_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getAravd_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getAravd_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArdgp_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArdgp_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}

			if (cargo.getArsum_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArsum_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArhmx_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArhmx_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArmed_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArmed_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArhps_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArhps_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArhos_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArhos_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArnur_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArnur_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArofs_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArofs_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArort_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArort_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArord_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArord_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getAriki_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getAriki_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArhbt_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArhbt_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArbbq_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArbbq_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArccc_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArccc_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArcsc_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArcsc_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArmbb_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArmbb_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArbbs_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArbbs_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}

			if (cargo.getArcta_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArcta_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}

			if (cargo.getArcon_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArcon_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}

			if (cargo.getArafp_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArafp_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}

			if (cargo.getArmaa_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArmaa_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getAripi_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getAripi_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArmov_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArmov_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}

			if (cargo.getArdoc_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArdoc_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArarp_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArarp_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArfin_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArfin_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getAridp_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getAridp_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArbus_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArbus_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArhpa_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArhpa_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArlhi_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArlhi_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}

			//NextGen  NG-6481 Phase 3 updates to ACA Streamline changes : Start
			if (cargo.getArbtt_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArbtt_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}

			if (cargo.getArbtd_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArbtd_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}

			if (cargo.getAritd_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getAritd_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			//NextGen  NG-6481 Phase 3 updates to ACA Streamline changes : End
			if (cargo.getArhin_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArhin_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArohi_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArohi_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}

			if (cargo.getArtxi_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArtxi_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArtdp_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArtdp_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArtax_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArtax_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArpre_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArpre_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}

			if (cargo.getArrld_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArrld_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArcfn_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArcfn_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}
			if (cargo.getArbcn_stat_ind() != null) {
				statement.setShort(count++, Short.parseShort(cargo.getArbcn_stat_ind()));
			} else {
				statement.setShort(count++, Short.parseShort("0"));
			}

			final int res = statement.executeUpdate();
			if (res == 0) {
				log(ILog.INFO, "Abstract_RMC_DRVR_DAO.insert() - Raising FwException manually on a condition");
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
	 * updates row to the table
	 * @param aCargo associated cargo class.
	 * @param aConn jdbc database connection
	 * @return indicates if operation has been successful
	 */
	public boolean update(final ICargo aCargo, final Connection aConn) {
		final RMC_DRVR_Cargo cargo = (RMC_DRVR_Cargo) aCargo;
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			int count = 1;
			conn = aConn;
			statement = conn.prepareStatement(UPDATE_SQL);
			statement.setShort(count++, Short.parseShort(cargo.getAracd_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArcat_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArhap_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArhcs_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArhdd_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArhde_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArhis_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArhma_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArhmd_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArhmi_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArhmo_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArhpd_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArhpg_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArhrl_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArhse_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArjid_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArehi_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArjis_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArjsd_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArjse_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArprs_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArtky_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getAruid_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getAruii_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getAruis_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getAruit_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArxhd_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArxhi_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArxhs_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArxhu_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArxud_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getHscso_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getHsher_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getHshmo_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getAracs_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getAragq_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getAraiq_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArasm_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArbad_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArbat_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArdcd_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArdfd_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArfas_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArhcd_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArhod_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getAriwe_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArjgq_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArlad_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArlat_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArlid_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArlit_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArmap_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArmbd_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArobc_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArobi_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArobq_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArobs_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getAroiq_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArpcs_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArpgq_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArpiq_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArppd_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArrbe_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArrpd_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArrpt_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArsod_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArvad_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArvat_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArxgq_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArxiq_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArrbi_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArapa_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArplr_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArhoh_stat_ind()));
			statement.setShort(count++, Short.parseShort("0"));
			statement.setShort(count++, Short.parseShort(cargo.getArstd_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getAravd_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArdgp_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArsum_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArhmx_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArmed_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArhps_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArhos_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArnur_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArofs_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArort_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArord_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getAriki_stat_ind()));

			statement.setShort(count++, Short.parseShort(cargo.getArhbt_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArbbq_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArccc_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArcsc_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArmbb_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArbbs_stat_ind()));

			statement.setShort(count++, Short.parseShort(cargo.getArcta_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArcon_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArafp_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArmaa_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getAripi_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArmov_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArdoc_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArarp_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArfin_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getAridp_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArbus_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArhpa_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArlhi_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArbtt_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArbtd_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getAritd_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArhin_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArohi_stat_ind()));

			statement.setShort(count++, Short.parseShort(cargo.getArtxi_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArtdp_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArtax_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArpre_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArrld_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArcfn_stat_ind()));
			statement.setShort(count++, Short.parseShort(cargo.getArbcn_stat_ind()));

			statement.setLong(count++, Long.parseLong(cargo.getApp_num()));

			final int res = statement.executeUpdate();
			if (res == 0) {
				log(ILog.INFO, "Abstract_RMC_DRVR_DAO.update() - Raising FwException manually on a condition");
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
	 * deletes row to the table
	 * @param aCargo associated cargo
	 * @param aConn jdbc database connection
	 * @return indicate if operation has been successful
	 */
	public boolean delete(final ICargo aCargo, final Connection aConn) {
		final RMC_DRVR_Cargo cargo = (RMC_DRVR_Cargo) aCargo;
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			int count = 1;
			conn = aConn;
			statement = conn.prepareStatement(DELETE_SQL);
			statement.setLong(count++, Long.parseLong(cargo.getApp_num()));

			final int res = statement.executeUpdate();
			if (res == 0) {
				log(ILog.INFO, "Abstract_RMC_DRVR_DAO.delete() - Raising FwException manually on a condition");
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
	 */
	@Override
	public short getHistoryType() {
		return HISTORY_TYPE;
	}
}
