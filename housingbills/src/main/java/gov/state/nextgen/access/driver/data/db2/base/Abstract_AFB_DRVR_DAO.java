package gov.state.nextgen.access.driver.data.db2.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gov.state.nextgen.access.business.entities.ICargo;
import gov.state.nextgen.access.business.entities.IPrimaryKey;
import gov.state.nextgen.access.driver.business.entities.AFB_DRVR_Cargo;
import gov.state.nextgen.access.driver.business.entities.AFB_DRVR_PrimaryKey;
import gov.state.nextgen.access.exceptions.FwException;
import gov.state.nextgen.access.exceptions.FwExceptionManager;
import gov.state.nextgen.access.factories.FwServiceFactory;
import gov.state.nextgen.access.management.constants.FwConstants;
import gov.state.nextgen.access.management.logging.ILog;
import gov.state.nextgen.access.management.util.FwDataCriteria;
import gov.state.nextgen.access.management.util.FwDataSortOrder;
import gov.state.nextgen.access.persistence.database.dao.FwAbstractDAO;

/**
 * Abstract Data Access Object for AFB_DRVR
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date Fri Feb 02 13:10:30 CST 2007
 */
public class Abstract_AFB_DRVR_DAO extends FwAbstractDAO {

	private static final short HISTORY_TYPE = 0;

	private static final String SELECT_SQL = "SELECT APP_NUM,ABAPD_STAT_IND,ABBNR_STAT_IND,ABDCD_STAT_IND,ABEDT_STAT_IND,ABEFD_STAT_IND,ABESM_STAT_IND,ABFAS_STAT_IND,ABHEQ_STAT_IND,ABHES_STAT_IND,ABHHQ_STAT_IND,ABHHR_STAT_IND,ABHIS_STAT_IND,ABHMD_STAT_IND,ABHMS_STAT_IND,ABJIQ_STAT_IND,ABJIS_STAT_IND,ABMED_STAT_IND,ABNSD_STAT_IND,ABNSO_STAT_IND,ABOEQ_STAT_IND,ABOIQ_STAT_IND,ABOIS_STAT_IND,ABPAS_STAT_IND,ABPPS_STAT_IND,ABPRG_STAT_IND,ABPRI_STAT_IND,ABPSQ_STAT_IND,ABRGI_STAT_IND,ABRGS_STAT_IND,ABRLV_STAT_IND,ABSCD_STAT_IND,ABSCT_STAT_IND,ABSED_STAT_IND,ABSEN_STAT_IND,ABUCD_STAT_IND,ABUCT_STAT_IND,ABUID_STAT_IND,ABUIT_STAT_IND,ABBAD_STAT_IND,ABBAT_STAT_IND,ABCON_STAT_IND,ABDIS_STAT_IND,ABHCA_STAT_IND,ABHCD_STAT_IND,ABHWA_STAT_IND,ABIND_STAT_IND,ABLAD_STAT_IND,ABLAQ_STAT_IND,ABLAS_STAT_IND,ABLAT_STAT_IND,ABLID_STAT_IND,ABLIT_STAT_IND,ABOAQ_STAT_IND,ABOAS_STAT_IND,ABPPD_STAT_IND,ABRPD_STAT_IND,ABRPT_STAT_IND,ABVAD_STAT_IND,ABVAT_STAT_IND,ABMBD_STAT_IND,ABMET_STAT_IND,ABMAH_STAT_IND,ABSHS_STAT_IND,ABSPD_STAT_IND,ABHEL_STAT_IND,ABHNG_STAT_IND,ABEDR_STAT_IND,ABHDR_STAT_IND,ABDFG_STAT_IND,ABFUR_STAT_IND,ABPTH_STAT_IND,ABSSS_STAT_IND,ABPNG_STAT_IND,ABPHD_STAT_IND,ABPED_STAT_IND,ABSTD_STAT_IND,ABUAD_STAT_IND,ABDTY_STAT_IND,ABDDT_STAT_IND,ABDSM_STAT_IND,ABDFE_STAT_IND,ABCPA_STAT_IND,ABCPH_STAT_IND,ABCRA_STAT_IND,ABECA_STAT_IND,ABEFA_STAT_IND,ABSTA_STAT_IND,ABSHE_STAT_IND,ABSAE_STAT_IND,ABWRE_STAT_IND,ABAUR_STAT_IND,ABCHS_STAT_IND,ABAVD_STAT_IND,ABHDN_STAT_IND,ABDOC_STAT_IND,ABOBQ_STAT_IND,ABOBS_STAT_IND,ABHSC_STAT_IND,ABMDP_STAT_IND,ABHLT_STAT_IND,ABHSY_STAT_IND,ABLHI_STAT_IND,ABNHM_STAT_IND,ABIPI_STAT_IND,ABIPQ_STAT_IND,ABCRC_STAT_IND,ABHIP_STAT_IND,ABORT_STAT_IND,ABORD_STAT_IND,ABIKI_STAT_IND,ABOFS_STAT_IND,ABBTX_STAT_IND,ABBTD_STAT_IND,ABITD_STAT_IND,ABEHI_STAT_IND,ABHIN_STAT_IND,ABOHI_STAT_IND,ABTXR_STAT_IND,ABTXI_STAT_IND,ABTDP_STAT_IND,ABCFN_STAT_IND,ABBCN_STAT_IND FROM "
			+ getDBSchema() + FwConstants.DOT + "CP_AFB_DRVR";
	private static final String INSERT_SQL = "INSERT INTO  "
			+ getDBSchema()
			+ FwConstants.DOT
			+ "CP_AFB_DRVR(APP_NUM,ABAPD_STAT_IND,ABBNR_STAT_IND,ABDCD_STAT_IND,ABEDT_STAT_IND,ABEFD_STAT_IND,ABESM_STAT_IND,ABFAS_STAT_IND,ABHEQ_STAT_IND,ABHES_STAT_IND,ABHHQ_STAT_IND,ABHHR_STAT_IND,ABHIS_STAT_IND,ABHMD_STAT_IND,ABHMS_STAT_IND,ABJIQ_STAT_IND,ABJIS_STAT_IND,ABMED_STAT_IND,ABNSD_STAT_IND,ABNSO_STAT_IND,ABOEQ_STAT_IND,ABOIQ_STAT_IND,ABOIS_STAT_IND,ABPAS_STAT_IND,ABPPS_STAT_IND,ABPRG_STAT_IND,ABPRI_STAT_IND,ABPSQ_STAT_IND,ABRGI_STAT_IND,ABRGS_STAT_IND,ABRLV_STAT_IND,ABSCD_STAT_IND,ABSCT_STAT_IND,ABSED_STAT_IND,ABSEN_STAT_IND,ABUCD_STAT_IND,ABUCT_STAT_IND,ABUID_STAT_IND,ABUIT_STAT_IND,ABBAD_STAT_IND,ABBAT_STAT_IND,ABCON_STAT_IND,ABDIS_STAT_IND,ABHCA_STAT_IND,ABHCD_STAT_IND,ABHWA_STAT_IND,ABIND_STAT_IND,ABLAD_STAT_IND,ABLAQ_STAT_IND,ABLAS_STAT_IND,ABLAT_STAT_IND,ABLID_STAT_IND,ABLIT_STAT_IND,ABOAQ_STAT_IND,ABOAS_STAT_IND,ABPPD_STAT_IND,ABRPD_STAT_IND,ABRPT_STAT_IND,ABVAD_STAT_IND,ABVAT_STAT_IND, ABMBD_STAT_IND ,ABMET_STAT_IND,ABMAH_STAT_IND,ABSHS_STAT_IND,ABSPD_STAT_IND,ABHEL_STAT_IND,ABHNG_STAT_IND,ABEDR_STAT_IND,ABHDR_STAT_IND,ABDFG_STAT_IND,ABFUR_STAT_IND,ABPTH_STAT_IND,ABSSS_STAT_IND,ABPNG_STAT_IND,ABPHD_STAT_IND,ABPED_STAT_IND,ABSTD_STAT_IND,ABUAD_STAT_IND,ABDTY_STAT_IND,ABDDT_STAT_IND,ABDSM_STAT_IND,ABDFE_STAT_IND,ABCPA_STAT_IND,ABCPH_STAT_IND,ABCRA_STAT_IND,ABECA_STAT_IND,ABEFA_STAT_IND,ABSTA_STAT_IND,ABSHE_STAT_IND,ABSAE_STAT_IND,ABWRE_STAT_IND,ABAUR_STAT_IND,ABCHS_STAT_IND,ABAVD_STAT_IND,ABHDN_STAT_IND,ABDOC_STAT_IND,ABOBQ_STAT_IND,ABOBS_STAT_IND,ABHSC_STAT_IND,ABMDP_STAT_IND,ABHLT_STAT_IND,ABHSY_STAT_IND,ABLHI_STAT_IND,ABNHM_STAT_IND,ABIPI_STAT_IND,ABIPQ_STAT_IND,ABCRC_STAT_IND,ABHIP_STAT_IND,ABORT_STAT_IND,ABORD_STAT_IND,ABIKI_STAT_IND,ABOFS_STAT_IND,ABBTX_STAT_IND,ABBTD_STAT_IND,ABITD_STAT_IND,ABEHI_STAT_IND,ABHIN_STAT_IND,ABOHI_STAT_IND,ABTXR_STAT_IND,ABTXI_STAT_IND,ABTDP_STAT_IND,ABCFN_STAT_IND,ABBCN_STAT_IND ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String PK_SELECT_SQL = "SELECT 1 FROM " + getDBSchema() + FwConstants.DOT + "CP_AFB_DRVR WHERE APP_NUM=?";
	private static final String UPDATE_SQL = "UPDATE "
			+ getDBSchema()
			+ FwConstants.DOT
			+ "CP_AFB_DRVR SET ABAPD_STAT_IND=?,ABBNR_STAT_IND=?,ABDCD_STAT_IND=?,ABEDT_STAT_IND=?,ABEFD_STAT_IND=?,ABESM_STAT_IND=?,ABFAS_STAT_IND=?,ABHEQ_STAT_IND=?,ABHES_STAT_IND=?,ABHHQ_STAT_IND=?,ABHHR_STAT_IND=?,ABHIS_STAT_IND=?,ABHMD_STAT_IND=?,ABHMS_STAT_IND=?,ABJIQ_STAT_IND=?,ABJIS_STAT_IND=?,ABMED_STAT_IND=?,ABNSD_STAT_IND=?,ABNSO_STAT_IND=?,ABOEQ_STAT_IND=?,ABOIQ_STAT_IND=?,ABOIS_STAT_IND=?,ABPAS_STAT_IND=?,ABPPS_STAT_IND=?,ABPRG_STAT_IND=?,ABPRI_STAT_IND=?,ABPSQ_STAT_IND=?,ABRGI_STAT_IND=?,ABRGS_STAT_IND=?,ABRLV_STAT_IND=?,ABSCD_STAT_IND=?,ABSCT_STAT_IND=?,ABSED_STAT_IND=?,ABSEN_STAT_IND=?,ABUCD_STAT_IND=?,ABUCT_STAT_IND=?,ABUID_STAT_IND=?,ABUIT_STAT_IND=?,ABBAD_STAT_IND=?,ABBAT_STAT_IND=?,ABCON_STAT_IND=?,ABDIS_STAT_IND=?,ABHCA_STAT_IND=?,ABHCD_STAT_IND=?,ABHWA_STAT_IND=?,ABIND_STAT_IND=?,ABLAD_STAT_IND=?,ABLAQ_STAT_IND=?,ABLAS_STAT_IND=?,ABLAT_STAT_IND=?,ABLID_STAT_IND=?,ABLIT_STAT_IND=?,ABOAQ_STAT_IND=?,ABOAS_STAT_IND=?,ABPPD_STAT_IND=?,ABRPD_STAT_IND=?,ABRPT_STAT_IND=?,ABVAD_STAT_IND=?,ABVAT_STAT_IND=?,ABMBD_STAT_IND = ? ,ABMET_STAT_IND  = ?,ABMAH_STAT_IND=?,ABSHS_STAT_IND=?,ABSPD_STAT_IND=?,ABHEL_STAT_IND=?,ABHNG_STAT_IND=?,ABEDR_STAT_IND=?,ABHDR_STAT_IND=?,ABDFG_STAT_IND=?,ABFUR_STAT_IND=?,ABPTH_STAT_IND=?,ABSSS_STAT_IND=?,ABPNG_STAT_IND=?,ABPHD_STAT_IND=?,ABPED_STAT_IND=?,ABSTD_STAT_IND=?,ABUAD_STAT_IND=?,ABDTY_STAT_IND =?,ABDDT_STAT_IND =?,ABDSM_STAT_IND =?,ABDFE_STAT_IND=?,ABCPA_STAT_IND=?,ABCPH_STAT_IND=?,ABCRA_STAT_IND=?,ABECA_STAT_IND=?,ABEFA_STAT_IND=?, ABSTA_STAT_IND=?, ABSHE_STAT_IND=?, ABSAE_STAT_IND=?,ABWRE_STAT_IND=?,ABAUR_STAT_IND=?,ABCHS_STAT_IND=?,ABAVD_STAT_IND=?,ABHDN_STAT_IND=?,ABDOC_STAT_IND=?,ABOBQ_STAT_IND=?,ABOBS_STAT_IND=?,ABHSC_STAT_IND=?,ABMDP_STAT_IND=?,ABHLT_STAT_IND=?,ABHSY_STAT_IND=?,ABLHI_STAT_IND=?,ABNHM_STAT_IND=?,ABIPI_STAT_IND=?,ABIPQ_STAT_IND=?,ABCRC_STAT_IND=?,ABHIP_STAT_IND=?,ABORT_STAT_IND=?,ABORD_STAT_IND=?,ABIKI_STAT_IND=?,ABOFS_STAT_IND=?,ABBTX_STAT_IND=?,ABBTD_STAT_IND=?,ABITD_STAT_IND=?,ABEHI_STAT_IND=?,ABHIN_STAT_IND=?,ABOHI_STAT_IND=?,ABTXR_STAT_IND=?,ABTXI_STAT_IND=?,ABTDP_STAT_IND=?,ABCFN_STAT_IND=?,ABBCN_STAT_IND=? WHERE APP_NUM=?";
	private static final String DELETE_SQL = "DELETE FROM " + getDBSchema() + FwConstants.DOT + "CP_AFB_DRVR WHERE  APP_NUM=?";

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
	private void getRowFromResultSet(final AFB_DRVR_Cargo row, final ResultSet rs) {

		try {
			row.setApp_num(rs.getString("APP_NUM"));
			row.setAbapd_stat_ind(rs.getString("ABAPD_STAT_IND"));
			row.setAbbnr_stat_ind(rs.getString("ABBNR_STAT_IND"));
			row.setAbdcd_stat_ind(rs.getString("ABDCD_STAT_IND"));
			row.setAbedt_stat_ind(rs.getString("ABEDT_STAT_IND"));
			row.setAbefd_stat_ind(rs.getString("ABEFD_STAT_IND"));
			row.setAbesm_stat_ind(rs.getString("ABESM_STAT_IND"));
			row.setAbfas_stat_ind(rs.getString("ABFAS_STAT_IND"));
			row.setAbheq_stat_ind(rs.getString("ABHEQ_STAT_IND"));
			row.setAbhes_stat_ind(rs.getString("ABHES_STAT_IND"));
			row.setAbhhq_stat_ind(rs.getString("ABHHQ_STAT_IND"));
			row.setAbhhr_stat_ind(rs.getString("ABHHR_STAT_IND"));
			row.setAbhis_stat_ind(rs.getString("ABHIS_STAT_IND"));
			row.setAbhmd_stat_ind(rs.getString("ABHMD_STAT_IND"));
			row.setAbhms_stat_ind(rs.getString("ABHMS_STAT_IND"));
			row.setAbjiq_stat_ind(rs.getString("ABJIQ_STAT_IND"));
			row.setAbjis_stat_ind(rs.getString("ABJIS_STAT_IND"));
			row.setAbmed_stat_ind(rs.getString("ABMED_STAT_IND"));
			row.setAbnsd_stat_ind(rs.getString("ABNSD_STAT_IND"));
			row.setAbnso_stat_ind(rs.getString("ABNSO_STAT_IND"));
			row.setAboeq_stat_ind(rs.getString("ABOEQ_STAT_IND"));
			row.setAboiq_stat_ind(rs.getString("ABOIQ_STAT_IND"));
			row.setAbois_stat_ind(rs.getString("ABOIS_STAT_IND"));
			row.setAbpas_stat_ind(rs.getString("ABPAS_STAT_IND"));
			row.setAbpps_stat_ind(rs.getString("ABPPS_STAT_IND"));
			row.setAbprg_stat_ind(rs.getString("ABPRG_STAT_IND"));
			row.setAbpri_stat_ind(rs.getString("ABPRI_STAT_IND"));
			row.setAbpsq_stat_ind(rs.getString("ABPSQ_STAT_IND"));
			row.setAbrgi_stat_ind(rs.getString("ABRGI_STAT_IND"));
			row.setAbrgs_stat_ind(rs.getString("ABRGS_STAT_IND"));
			row.setAbrlv_stat_ind(rs.getString("ABRLV_STAT_IND"));
			row.setAbscd_stat_ind(rs.getString("ABSCD_STAT_IND"));
			row.setAbsct_stat_ind(rs.getString("ABSCT_STAT_IND"));
			row.setAbsed_stat_ind(rs.getString("ABSED_STAT_IND"));
			row.setAbsen_stat_ind(rs.getString("ABSEN_STAT_IND"));
			row.setAbucd_stat_ind(rs.getString("ABUCD_STAT_IND"));
			row.setAbuct_stat_ind(rs.getString("ABUCT_STAT_IND"));
			row.setAbuid_stat_ind(rs.getString("ABUID_STAT_IND"));
			row.setAbuit_stat_ind(rs.getString("ABUIT_STAT_IND"));
			row.setAbbad_stat_ind(rs.getString("ABBAD_STAT_IND"));
			row.setAbbat_stat_ind(rs.getString("ABBAT_STAT_IND"));
			row.setAbcon_stat_ind(rs.getString("ABCON_STAT_IND"));
			row.setAbdis_stat_ind(rs.getString("ABDIS_STAT_IND"));
			row.setAbhca_stat_ind(rs.getString("ABHCA_STAT_IND"));
			row.setAbhcd_stat_ind(rs.getString("ABHCD_STAT_IND"));
			row.setAbhwa_stat_ind(rs.getString("ABHWA_STAT_IND"));
			row.setAbind_stat_ind(rs.getString("ABIND_STAT_IND"));
			row.setAblad_stat_ind(rs.getString("ABLAD_STAT_IND"));
			row.setAblaq_stat_ind(rs.getString("ABLAQ_STAT_IND"));
			row.setAblas_stat_ind(rs.getString("ABLAS_STAT_IND"));
			row.setAblat_stat_ind(rs.getString("ABLAT_STAT_IND"));
			row.setAblid_stat_ind(rs.getString("ABLID_STAT_IND"));
			row.setAblit_stat_ind(rs.getString("ABLIT_STAT_IND"));
			row.setAboaq_stat_ind(rs.getString("ABOAQ_STAT_IND"));
			row.setAboas_stat_ind(rs.getString("ABOAS_STAT_IND"));
			row.setAbppd_stat_ind(rs.getString("ABPPD_STAT_IND"));
			row.setAbrpd_stat_ind(rs.getString("ABRPD_STAT_IND"));
			row.setAbrpt_stat_ind(rs.getString("ABRPT_STAT_IND"));
			row.setAbvad_stat_ind(rs.getString("ABVAD_STAT_IND"));
			row.setAbvat_stat_ind(rs.getString("ABVAT_STAT_IND"));
			row.setAbmet_stat_ind(rs.getString("ABMET_STAT_IND"));
			row.setAbmbd_stat_ind(rs.getString("ABMBD_STAT_IND"));
			row.setAbmah_stat_ind(rs.getString("ABMAH_STAT_IND"));
			row.setAbshs_stat_ind(rs.getString("ABSHS_STAT_IND"));
			row.setAbspd_stat_ind(rs.getString("ABSPD_STAT_IND"));
			row.setAbhel_stat_ind(rs.getString("ABHEL_STAT_IND"));
			row.setAbhng_stat_ind(rs.getString("ABHNG_STAT_IND"));
			row.setAbedr_stat_ind(rs.getString("ABEDR_STAT_IND"));
			row.setAbhdr_stat_ind(rs.getString("ABHDR_STAT_IND"));
			row.setAbdfg_stat_ind(rs.getString("ABDFG_STAT_IND"));
			row.setAbfur_stat_ind(rs.getString("ABFUR_STAT_IND"));
			row.setAbpth_stat_ind(rs.getString("ABPTH_STAT_IND"));
			row.setAbsss_stat_ind(rs.getString("ABSSS_STAT_IND"));
			row.setAbpng_stat_ind(rs.getString("ABPNG_STAT_IND"));
			row.setAbphd_stat_ind(rs.getString("ABPHD_STAT_IND"));
			row.setAbped_stat_ind(rs.getString("ABPED_STAT_IND"));
			row.setAbstd_stat_ind(rs.getString("ABSTD_STAT_IND"));
			row.setAbstd_stat_ind(rs.getString("ABUAD_STAT_IND"));
			row.setAbdty_stat_ind(rs.getString("ABDTY_STAT_IND"));
			row.setAbddt_stat_ind(rs.getString("ABDDT_STAT_IND"));
			row.setAbdsm_stat_ind(rs.getString("ABDSM_STAT_IND"));
			row.setAbdfe_stat_ind(rs.getString("ABDFE_STAT_IND"));
			row.setAbcpa_stat_ind(rs.getString("ABCPA_STAT_IND"));
			row.setAbcph_stat_ind(rs.getString("ABCPH_STAT_IND"));
			row.setAbcra_stat_ind(rs.getString("ABCRA_STAT_IND"));
			row.setAbeca_stat_ind(rs.getString("ABECA_STAT_IND"));
			row.setAbefa_stat_ind(rs.getString("ABEFA_STAT_IND"));
			row.setAbsta_stat_ind(rs.getString("ABSTA_STAT_IND"));
			row.setAbshe_stat_ind(rs.getString("ABSHE_STAT_IND"));
			row.setAbwre_stat_ind(rs.getString("ABWRE_STAT_IND"));
			row.setAbaur_stat_ind(rs.getString("ABAUR_STAT_IND"));
			row.setAbaur_stat_ind(rs.getString("ABCHS_STAT_IND"));
			row.setAbaur_stat_ind(rs.getString("ABAVD_STAT_IND"));
			row.setAbhdn_stat_ind(rs.getString("ABHDN_STAT_IND"));
			row.setAbdoc_stat_ind(rs.getString("ABDOC_STAT_IND"));
			row.setAbobq_stat_ind(rs.getString("ABOBQ_STAT_IND"));
			row.setAbobs_stat_ind(rs.getString("ABOBS_STAT_IND"));
			row.setAbhsc_stat_ind(rs.getString("ABHSC_STAT_IND"));
			row.setAbmdp_stat_ind(rs.getString("ABMDP_STAT_IND"));
			row.setAbhlt_stat_ind(rs.getString("ABHLT_STAT_IND"));
			row.setAbhsy_stat_ind(rs.getString("ABHSY_STAT_IND"));
			row.setAblhi_stat_ind(rs.getString("ABLHI_STAT_IND"));
			row.setAbnhm_stat_ind(rs.getString("ABNHM_STAT_IND"));
			row.setAbipi_stat_ind(rs.getString("ABIPI_STAT_IND"));
			row.setAbipq_stat_ind(rs.getString("ABIPQ_STAT_IND"));
			row.setAbcrc_stat_ind(rs.getString("ABCRC_STAT_IND"));
			row.setAbhip_stat_ind(rs.getString("ABHIP_STAT_IND"));
			row.setAbort_stat_ind(rs.getString("ABORT_STAT_IND"));
			row.setAbord_stat_ind(rs.getString("ABORD_STAT_IND"));
			row.setAbiki_stat_ind(rs.getString("ABIKI_STAT_IND"));
			row.setAbofs_stat_ind(rs.getString("ABOFS_STAT_IND"));
			row.setAbbtx_stat_ind(rs.getString("ABBTX_STAT_IND"));
			row.setAbbtd_stat_ind(rs.getString("ABBTD_STAT_IND"));
			row.setAbitd_stat_ind(rs.getString("ABITD_STAT_IND"));
			row.setAbehi_stat_ind(rs.getString("ABEHI_STAT_IND"));
			row.setAbhin_stat_ind(rs.getString("ABHIN_STAT_IND"));
			row.setAbohi_stat_ind(rs.getString("ABOHI_STAT_IND"));
			row.setAbtxr_stat_ind(rs.getString("ABTXR_STAT_IND"));
			row.setAbtxi_stat_ind(rs.getString("ABTXI_STAT_IND"));
			row.setAbtdp_stat_ind(rs.getString("ABTDP_STAT_IND"));
			row.setAbcfn_stat_ind(rs.getString("ABCFN_STAT_IND"));
			row.setAbbcn_stat_ind(rs.getString("ABBCN_STAT_IND"));
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
	 * 
	 * @param aCriteria select criteria.
	 * @param aSort sort criteria.
	 * @param aConn jdbc database connection.
	 * @return resolved cargo
	 */
	public ICargo[] select(final FwDataCriteria[] aCriteria, final FwDataSortOrder[] aSort, final Connection aConn) {
		final List values = new ArrayList();
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		AFB_DRVR_Cargo[] rows = null;
		final StringBuilder whereClause = new StringBuilder();
		try {
			conn = aConn;
			if (aCriteria.length == 0) {
				log(ILog.INFO, "Abstract_AFB_DRVR_DAO.select() - Raising FwException manually on a condition");
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
				log(ILog.INFO, "Abstract_AFB_DRVR_DAO.select() - Raising FwException manually on a condition");
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
				final AFB_DRVR_Cargo cargo = new AFB_DRVR_Cargo();
				getRowFromResultSet(cargo, rs);
				values.add(cargo);
			}
			rows = new AFB_DRVR_Cargo[values.size()];
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
	 * @return associated cargo with record information
	 */
	public ICargo findByPrimaryKey(final IPrimaryKey aKey, final Connection aConn) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		AFB_DRVR_Cargo rescargo = null;
		final AFB_DRVR_PrimaryKey key = (AFB_DRVR_PrimaryKey) aKey;
		try {
			int count = 1;
			conn = aConn;
			statement = conn.prepareStatement(PK_SELECT_SQL);
			statement.setLong(count++, Long.parseLong(key.getApp_num()));
			rs = statement.executeQuery();
			if (rs.next()) {
				rescargo = new AFB_DRVR_Cargo();
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
	 * @param aCargo data record abstraction
	 * @param aConn jdbc database connection
	 * @return operation success
	 */
	public boolean insert(final ICargo aCargo, final Connection aConn) {
		final AFB_DRVR_Cargo cargo = (AFB_DRVR_Cargo) aCargo;
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			int count = 1;
			conn = aConn;
			statement = conn.prepareStatement(INSERT_SQL);
			statement.setLong(count++, Long.parseLong(cargo.getApp_num()));
			statement.setShort(count++, Short.parseShort(cargo.getAbapd_stat_ind() != null ? cargo.getAbapd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbbnr_stat_ind() != null ? cargo.getAbbnr_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbdcd_stat_ind() != null ? cargo.getAbdcd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbedt_stat_ind() != null ? cargo.getAbedt_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbefd_stat_ind() != null ? cargo.getAbefd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbesm_stat_ind() != null ? cargo.getAbesm_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbfas_stat_ind() != null ? cargo.getAbfas_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbheq_stat_ind() != null ? cargo.getAbheq_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhes_stat_ind() != null ? cargo.getAbhes_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhhq_stat_ind() != null ? cargo.getAbhhq_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhhr_stat_ind() != null ? cargo.getAbhhr_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhis_stat_ind() != null ? cargo.getAbhis_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhmd_stat_ind() != null ? cargo.getAbhmd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhms_stat_ind() != null ? cargo.getAbhms_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbjiq_stat_ind() != null ? cargo.getAbjiq_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbjis_stat_ind() != null ? cargo.getAbjis_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbmed_stat_ind() != null ? cargo.getAbmed_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbnsd_stat_ind() != null ? cargo.getAbnsd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbnso_stat_ind() != null ? cargo.getAbnso_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAboeq_stat_ind() != null ? cargo.getAboeq_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAboiq_stat_ind() != null ? cargo.getAboiq_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbois_stat_ind() != null ? cargo.getAbois_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbpas_stat_ind() != null ? cargo.getAbpas_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbpps_stat_ind() != null ? cargo.getAbpps_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbprg_stat_ind() != null ? cargo.getAbprg_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbpri_stat_ind() != null ? cargo.getAbpri_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbpsq_stat_ind() != null ? cargo.getAbpsq_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbrgi_stat_ind() != null ? cargo.getAbrgi_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbrgs_stat_ind() != null ? cargo.getAbrgs_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbrlv_stat_ind() != null ? cargo.getAbrlv_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbscd_stat_ind() != null ? cargo.getAbscd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbsct_stat_ind() != null ? cargo.getAbsct_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbsed_stat_ind() != null ? cargo.getAbsed_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbsen_stat_ind() != null ? cargo.getAbsen_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbucd_stat_ind() != null ? cargo.getAbucd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbuct_stat_ind() != null ? cargo.getAbuct_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbuid_stat_ind() != null ? cargo.getAbuid_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbuit_stat_ind() != null ? cargo.getAbuit_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbbad_stat_ind() != null ? cargo.getAbbad_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbbat_stat_ind() != null ? cargo.getAbbat_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbcon_stat_ind() != null ? cargo.getAbcon_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbdis_stat_ind() != null ? cargo.getAbdis_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhca_stat_ind() != null ? cargo.getAbhca_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhcd_stat_ind() != null ? cargo.getAbhcd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhwa_stat_ind() != null ? cargo.getAbhwa_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbind_stat_ind() != null ? cargo.getAbind_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAblad_stat_ind() != null ? cargo.getAblad_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAblaq_stat_ind() != null ? cargo.getAblaq_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAblas_stat_ind() != null ? cargo.getAblas_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAblat_stat_ind() != null ? cargo.getAblat_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAblid_stat_ind() != null ? cargo.getAblid_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAblit_stat_ind() != null ? cargo.getAblit_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAboaq_stat_ind() != null ? cargo.getAboaq_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAboas_stat_ind() != null ? cargo.getAboas_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbppd_stat_ind() != null ? cargo.getAbppd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbrpd_stat_ind() != null ? cargo.getAbrpd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbrpt_stat_ind() != null ? cargo.getAbrpt_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbvad_stat_ind() != null ? cargo.getAbvad_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbvat_stat_ind() != null ? cargo.getAbvat_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbmet_stat_ind() != null ? cargo.getAbmet_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbmbd_stat_ind() != null ? cargo.getAbmbd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbmah_stat_ind() != null ? cargo.getAbmah_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbshs_stat_ind() != null ? cargo.getAbshs_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbspd_stat_ind() != null ? cargo.getAbspd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhel_stat_ind() != null ? cargo.getAbhel_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhng_stat_ind() != null ? cargo.getAbhng_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbedr_stat_ind() != null ? cargo.getAbedr_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhdr_stat_ind() != null ? cargo.getAbhdr_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbdfg_stat_ind() != null ? cargo.getAbdfg_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbfur_stat_ind() != null ? cargo.getAbfur_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbpth_stat_ind() != null ? cargo.getAbpth_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbsss_stat_ind() != null ? cargo.getAbsss_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbpng_stat_ind() != null ? cargo.getAbpng_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbphd_stat_ind() != null ? cargo.getAbphd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbped_stat_ind() != null ? cargo.getAbped_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbstd_stat_ind() != null ? cargo.getAbstd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbuad_stat_ind() != null ? cargo.getAbuad_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbdty_stat_ind() != null ? cargo.getAbdty_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbddt_stat_ind() != null ? cargo.getAbddt_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbdsm_stat_ind() != null ? cargo.getAbdsm_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbdfe_stat_ind() != null ? cargo.getAbdfe_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbcpa_stat_ind() != null ? cargo.getAbcpa_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbcph_stat_ind() != null ? cargo.getAbcph_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbcra_stat_ind() != null ? cargo.getAbcra_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbeca_stat_ind() != null ? cargo.getAbeca_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbefa_stat_ind() != null ? cargo.getAbefa_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbsta_stat_ind() != null ? cargo.getAbsta_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbshe_stat_ind() != null ? cargo.getAbshe_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbsae_stat_ind() != null ? cargo.getAbsae_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbwre_stat_ind() != null ? cargo.getAbwre_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbaur_stat_ind() != null ? cargo.getAbaur_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbchs_stat_ind() != null ? cargo.getAbchs_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbavd_stat_ind() != null ? cargo.getAbavd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhdn_stat_ind() != null ? cargo.getAbhdn_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbdoc_stat_ind() != null ? cargo.getAbdoc_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbobq_stat_ind() != null ? cargo.getAbobq_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbobs_stat_ind() != null ? cargo.getAbobs_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhsc_stat_ind() != null ? cargo.getAbhsc_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbmdp_stat_ind() != null ? cargo.getAbmdp_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhlt_stat_ind() != null ? cargo.getAbhlt_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhsy_stat_ind() != null ? cargo.getAbhsy_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAblhi_stat_ind() != null ? cargo.getAblhi_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbnhm_stat_ind() != null ? cargo.getAbnhm_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbipi_stat_ind() != null ? cargo.getAbipi_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbipq_stat_ind() != null ? cargo.getAbipq_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbcrc_stat_ind() != null ? cargo.getAbcrc_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhip_stat_ind() != null ? cargo.getAbhip_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbort_stat_ind() != null ? cargo.getAbort_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbord_stat_ind() != null ? cargo.getAbord_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbiki_stat_ind() != null ? cargo.getAbiki_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbofs_stat_ind() != null ? cargo.getAbofs_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbbtx_stat_ind() != null ? cargo.getAbbtx_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbbtd_stat_ind() != null ? cargo.getAbbtd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbitd_stat_ind() != null ? cargo.getAbitd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbehi_stat_ind() != null ? cargo.getAbehi_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhin_stat_ind() != null ? cargo.getAbhin_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbohi_stat_ind() != null ? cargo.getAbohi_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbtxr_stat_ind() != null ? cargo.getAbtxr_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbtxi_stat_ind() != null ? cargo.getAbtxi_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbtdp_stat_ind() != null ? cargo.getAbtdp_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbcfn_stat_ind() != null ? cargo.getAbcfn_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbbcn_stat_ind() != null ? cargo.getAbbcn_stat_ind() : "0"));
			final int res = statement.executeUpdate();
			if (res == 0) {
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
	 *  updates row in the table
	 * @param aCargo data record abstraction
	 * @param aConn jdbc database connection
	 * @return operation success
	 */
	public boolean update(final ICargo aCargo, final Connection aConn) {
		final AFB_DRVR_Cargo cargo = (AFB_DRVR_Cargo) aCargo;
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			int count = 1;
			conn = aConn;
			statement = conn.prepareStatement(UPDATE_SQL);
			statement.setShort(count++, Short.parseShort(cargo.getAbapd_stat_ind() != null ? cargo.getAbapd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbbnr_stat_ind() != null ? cargo.getAbbnr_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbdcd_stat_ind() != null ? cargo.getAbdcd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbedt_stat_ind() != null ? cargo.getAbedt_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbefd_stat_ind() != null ? cargo.getAbefd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbesm_stat_ind() != null ? cargo.getAbesm_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbfas_stat_ind() != null ? cargo.getAbfas_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbheq_stat_ind() != null ? cargo.getAbheq_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhes_stat_ind() != null ? cargo.getAbhes_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhhq_stat_ind() != null ? cargo.getAbhhq_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhhr_stat_ind() != null ? cargo.getAbhhr_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhis_stat_ind() != null ? cargo.getAbhis_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhmd_stat_ind() != null ? cargo.getAbhmd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhms_stat_ind() != null ? cargo.getAbhms_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbjiq_stat_ind() != null ? cargo.getAbjiq_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbjis_stat_ind() != null ? cargo.getAbjis_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbmed_stat_ind() != null ? cargo.getAbmed_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbnsd_stat_ind() != null ? cargo.getAbnsd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbnso_stat_ind() != null ? cargo.getAbnso_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAboeq_stat_ind() != null ? cargo.getAboeq_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAboiq_stat_ind() != null ? cargo.getAboiq_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbois_stat_ind() != null ? cargo.getAbois_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbpas_stat_ind() != null ? cargo.getAbpas_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbpps_stat_ind() != null ? cargo.getAbpps_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbprg_stat_ind() != null ? cargo.getAbprg_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbpri_stat_ind() != null ? cargo.getAbpri_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbpsq_stat_ind() != null ? cargo.getAbpsq_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbrgi_stat_ind() != null ? cargo.getAbrgi_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbrgs_stat_ind() != null ? cargo.getAbrgs_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbrlv_stat_ind() != null ? cargo.getAbrlv_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbscd_stat_ind() != null ? cargo.getAbscd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbsct_stat_ind() != null ? cargo.getAbsct_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbsed_stat_ind() != null ? cargo.getAbsed_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbsen_stat_ind() != null ? cargo.getAbsen_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbucd_stat_ind() != null ? cargo.getAbucd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbuct_stat_ind() != null ? cargo.getAbuct_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbuid_stat_ind() != null ? cargo.getAbuid_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbuit_stat_ind() != null ? cargo.getAbuit_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbbad_stat_ind() != null ? cargo.getAbbad_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbbat_stat_ind() != null ? cargo.getAbbat_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbcon_stat_ind() != null ? cargo.getAbcon_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbdis_stat_ind() != null ? cargo.getAbdis_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhca_stat_ind() != null ? cargo.getAbhca_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhcd_stat_ind() != null ? cargo.getAbhcd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhwa_stat_ind() != null ? cargo.getAbhwa_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbind_stat_ind() != null ? cargo.getAbind_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAblad_stat_ind() != null ? cargo.getAblad_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAblaq_stat_ind() != null ? cargo.getAblaq_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAblas_stat_ind() != null ? cargo.getAblas_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAblat_stat_ind() != null ? cargo.getAblat_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAblid_stat_ind() != null ? cargo.getAblid_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAblit_stat_ind() != null ? cargo.getAblit_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAboaq_stat_ind() != null ? cargo.getAboaq_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAboas_stat_ind() != null ? cargo.getAboas_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbppd_stat_ind() != null ? cargo.getAbppd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbrpd_stat_ind() != null ? cargo.getAbrpd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbrpt_stat_ind() != null ? cargo.getAbrpt_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbvad_stat_ind() != null ? cargo.getAbvad_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbvat_stat_ind() != null ? cargo.getAbvat_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbmet_stat_ind() != null ? cargo.getAbmet_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbmbd_stat_ind() != null ? cargo.getAbmbd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbmah_stat_ind() != null ? cargo.getAbmah_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbshs_stat_ind() != null ? cargo.getAbshs_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbspd_stat_ind() != null ? cargo.getAbspd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhel_stat_ind() != null ? cargo.getAbhel_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhng_stat_ind() != null ? cargo.getAbhng_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbedr_stat_ind() != null ? cargo.getAbedr_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhdr_stat_ind() != null ? cargo.getAbhdr_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbdfg_stat_ind() != null ? cargo.getAbdfg_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbfur_stat_ind() != null ? cargo.getAbfur_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbpth_stat_ind() != null ? cargo.getAbpth_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbsss_stat_ind() != null ? cargo.getAbsss_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbpng_stat_ind() != null ? cargo.getAbpng_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbphd_stat_ind() != null ? cargo.getAbphd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbped_stat_ind() != null ? cargo.getAbped_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbstd_stat_ind() != null ? cargo.getAbstd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbuad_stat_ind() != null ? cargo.getAbuad_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbdty_stat_ind() != null ? cargo.getAbdty_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbddt_stat_ind() != null ? cargo.getAbddt_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbdsm_stat_ind() != null ? cargo.getAbdsm_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbdfe_stat_ind() != null ? cargo.getAbdfe_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbcpa_stat_ind() != null ? cargo.getAbcpa_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbcph_stat_ind() != null ? cargo.getAbcph_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbcra_stat_ind() != null ? cargo.getAbcra_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbeca_stat_ind() != null ? cargo.getAbeca_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbefa_stat_ind() != null ? cargo.getAbefa_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbsta_stat_ind() != null ? cargo.getAbsta_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbshe_stat_ind() != null ? cargo.getAbshe_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbsae_stat_ind() != null ? cargo.getAbsae_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbwre_stat_ind() != null ? cargo.getAbwre_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbaur_stat_ind() != null ? cargo.getAbaur_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbchs_stat_ind() != null ? cargo.getAbchs_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbavd_stat_ind() != null ? cargo.getAbavd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhdn_stat_ind() != null ? cargo.getAbhdn_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbdoc_stat_ind() != null ? cargo.getAbdoc_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbobq_stat_ind() != null ? cargo.getAbobq_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbobs_stat_ind() != null ? cargo.getAbobs_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhsc_stat_ind() != null ? cargo.getAbhsc_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhsc_stat_ind() != null ? cargo.getAbhsc_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbmdp_stat_ind() != null ? cargo.getAbmdp_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhlt_stat_ind() != null ? cargo.getAbhlt_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhsy_stat_ind() != null ? cargo.getAbhsy_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAblhi_stat_ind() != null ? cargo.getAblhi_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbnhm_stat_ind() != null ? cargo.getAbnhm_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbipi_stat_ind() != null ? cargo.getAbipi_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbipq_stat_ind() != null ? cargo.getAbipq_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbcrc_stat_ind() != null ? cargo.getAbcrc_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhip_stat_ind() != null ? cargo.getAbhip_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbort_stat_ind() != null ? cargo.getAbort_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbord_stat_ind() != null ? cargo.getAbord_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbiki_stat_ind() != null ? cargo.getAbiki_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbofs_stat_ind() != null ? cargo.getAbofs_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbbtx_stat_ind() != null ? cargo.getAbbtx_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbbtd_stat_ind() != null ? cargo.getAbbtd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbitd_stat_ind() != null ? cargo.getAbitd_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbehi_stat_ind() != null ? cargo.getAbehi_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbhin_stat_ind() != null ? cargo.getAbhin_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbohi_stat_ind() != null ? cargo.getAbohi_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbtxr_stat_ind() != null ? cargo.getAbtxr_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbtxi_stat_ind() != null ? cargo.getAbtxi_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbtdp_stat_ind() != null ? cargo.getAbtdp_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbcfn_stat_ind() != null ? cargo.getAbcfn_stat_ind() : "0"));
			statement.setShort(count++, Short.parseShort(cargo.getAbbcn_stat_ind() != null ? cargo.getAbbcn_stat_ind() : "0"));
			statement.setLong(count++, Long.parseLong(cargo.getApp_num()));
			final int res = statement.executeUpdate();
			if (res == 0) {

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
	 * @param aCargo data record abstraction
	 * @param aConn jdbc database connection
	 * @return operation success
	 */
	public boolean delete(final ICargo aCargo, final Connection aConn) {
		final AFB_DRVR_Cargo cargo = (AFB_DRVR_Cargo) aCargo;
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			int count = 1;
			conn = aConn;
			statement = conn.prepareStatement(DELETE_SQL);
			statement.setLong(count++, Long.parseLong(cargo.getApp_num()));
			final int res = statement.executeUpdate();
			if (res == 0) {

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
