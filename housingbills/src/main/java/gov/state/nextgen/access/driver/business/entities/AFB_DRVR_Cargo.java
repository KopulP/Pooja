/*
 * 
 */
package gov.state.nextgen.access.driver.business.entities;

import java.util.HashMap;
import java.util.Map;

import gov.state.nextgen.access.business.entities.AbstractCargo;
import gov.state.nextgen.access.business.entities.IPrimaryKey;
import gov.state.nextgen.access.management.util.FwDataCriteria;

/**
 * This java bean contains the entities of AFB_DRVR
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date Fri Feb 02 13:10:30 CST 2007 Modified By: Modified on: PCR#
 */
@SuppressWarnings("serial")
public class AFB_DRVR_Cargo extends AbstractCargo implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	boolean isDirty = false;
	private String app_num;
	private String abapd_stat_ind;
	private String abbnr_stat_ind;
	private String abdcd_stat_ind;
	private String abedt_stat_ind;
	private String abefd_stat_ind;
	private String abesm_stat_ind;
	private String abfas_stat_ind;
	private String abheq_stat_ind;
	private String abhes_stat_ind;
	private String abhhq_stat_ind;
	private String abhhr_stat_ind;
	private String abhis_stat_ind;
	private String abhmd_stat_ind;
	private String abshs_stat_ind;
	private String abspd_stat_ind;
	private String abhel_stat_ind;
	private String abhng_stat_ind;
	private String abedr_stat_ind;
	private String abhdr_stat_ind;
	private String abdfg_stat_ind;
	private String abfur_stat_ind;
	private String abpth_stat_ind;
	private String absss_stat_ind;
	private String abhms_stat_ind;
	private String abjiq_stat_ind;
	private String abjis_stat_ind;
	private String abmed_stat_ind;
	private String abnsd_stat_ind;
	private String abnso_stat_ind;
	private String aboeq_stat_ind;
	private String aboiq_stat_ind;
	private String abois_stat_ind;
	private String abpas_stat_ind;
	private String abpps_stat_ind;
	private String abprg_stat_ind;
	private String abpri_stat_ind;
	private String abpsq_stat_ind;
	private String abrgi_stat_ind;
	private String abrgs_stat_ind;
	private String abrlv_stat_ind;
	private String abscd_stat_ind;
	private String absct_stat_ind;
	private String absed_stat_ind;
	private String absen_stat_ind;
	private String abucd_stat_ind;
	private String abuct_stat_ind;
	private String abuid_stat_ind;
	private String abuit_stat_ind;
	private String abbad_stat_ind;
	private String abbat_stat_ind;
	private String abcon_stat_ind;
	private String abdis_stat_ind;
	private String abhca_stat_ind;
	private String abhcd_stat_ind;
	private String abhwa_stat_ind;
	private String abind_stat_ind;
	private String ablad_stat_ind;
	private String ablaq_stat_ind;
	private String ablas_stat_ind;
	private String ablat_stat_ind;
	private String ablid_stat_ind;
	private String ablit_stat_ind;
	private String aboaq_stat_ind;
	private String aboas_stat_ind;
	private String abppd_stat_ind;
	private String abrpd_stat_ind;
	private String abrpt_stat_ind;
	private String abvad_stat_ind;
	private String abvat_stat_ind;
	private String abmet_stat_ind;
	private String abmbd_stat_ind;
	private String abmah_stat_ind;
	private String abpng_stat_ind;
	private String abped_stat_ind;
	private String abphd_stat_ind;
	private String abstd_stat_ind;
	private String abuad_stat_ind;

	private String abdty_stat_ind;
	private String abddt_stat_ind;
	private String abdsm_stat_ind;
	// edsp cp - drug felony
	private String abdfe_stat_ind;
	private String abcpa_stat_ind;
	private String abcph_stat_ind;
	// edsp cp -drug felony
	// EDSP CP - cooling assistance,crisis assistance ,fuel assistance
	// indicators
	private String abcra_stat_ind;
	private String abeca_stat_ind;
	private String abefa_stat_ind;
	// EDSP CP - cooling assistance,crisis assistance ,fuel assistance
	// indicators
	// EDSP CP - sold & transferred assets
	private String absta_stat_ind;
	// EDSP CP - sold & transferred assets
	// EDSP CP - shelter expenses
	private String abshe_stat_ind;
	// EDSP CP - end
	// EDSP CP - snap actual/standard expense
	private String absae_stat_ind;
	// EDSP CP - end
	// EDSP CP start
	// GA- IES start
	private String abavd_stat_ind;
	private String abhdn_stat_ind;

	// GA- IES End
	private String abwre_stat_ind;
	private String abaur_stat_ind;
	private String abchs_stat_ind;
	private String abdoc_stat_ind;
	private String abobq_stat_ind;
	private String abhsc_stat_ind;
	private String abmdp_stat_ind;
	private String abhlt_stat_ind;
	private String abhsy_stat_ind;
	private String ablhi_stat_ind;
	private String abnhm_stat_ind;
	private String abobs_stat_ind;
	private String abipi_stat_ind;
	private String abipq_stat_ind;
	private String abcrc_stat_ind;
	private String abhip_stat_ind;
	private String abort_stat_ind;
	private String abord_stat_ind;
	private String abiki_stat_ind;
	private String abofs_stat_ind;
	private String abtax_stat_ind;
	//ACA Integration
	private String abtdp_stat_ind;
	// NextGen  NG-6481 Phase 3 updates to ACA Streamline changes � start
	private String abitd_stat_ind;
	private String abbtx_stat_ind;
	private String abbtd_stat_ind;
	// NextGen  NG-6481 Phase 3 updates to ACA Streamline changes � end
	private String abehi_stat_ind;
	private String abhin_stat_ind;
	private String abohi_stat_ind;
	private String abtxr_stat_ind;
	private String abtxi_stat_ind;
	private String abcfn_stat_ind;
	private String abbcn_stat_ind;
	FwDataCriteria[] dataCriteria;
	FwDataCriteria[] whereCriteria;
	private String abhbq_stat_ind;
	private String abhbd_stat_ind;

	
	
	public String getAbhbq_stat_ind() {
		return abhbq_stat_ind;
	}

	public void setAbhbq_stat_ind(String abhbq_stat_ind) {
		this.abhbq_stat_ind = abhbq_stat_ind;
	}

	public String getAbhbd_stat_ind() {
		return abhbd_stat_ind;
	}

	public void setAbhbd_stat_ind(String abhbd_stat_ind) {
		this.abhbd_stat_ind = abhbd_stat_ind;
	}

	/**
	 * @return the abcfn_stat_ind
	 */
	public String getAbcfn_stat_ind() {
		return abcfn_stat_ind;
	}

	/**
	 * @param abcfn_stat_ind the abcfn_stat_ind to set
	 */
	public void setAbcfn_stat_ind(final String abcfn_stat_ind) {
		this.abcfn_stat_ind = abcfn_stat_ind;
	}

	/**
	 * @return the abbcn_stat_ind
	 */
	public String getAbbcn_stat_ind() {
		return abbcn_stat_ind;
	}

	/**
	 * @param abbcn_stat_ind the abbcn_stat_ind to set
	 */
	public void setAbbcn_stat_ind(String abbcn_stat_ind) {
		this.abbcn_stat_ind = abbcn_stat_ind;
	}

	/**
	 * @return the abtxr_stat_ind
	 */
	public String getAbtxr_stat_ind() {
		return abtxr_stat_ind;
	}

	/**
	 * @param abtxr_stat_ind the abtxr_stat_ind to set
	 */
	public void setAbtxr_stat_ind(final String abtxr_stat_ind) {
		this.abtxr_stat_ind = abtxr_stat_ind;
	}

	/**
	 * @return the abhin_stat_ind
	 */
	public String getAbhin_stat_ind() {
		return abhin_stat_ind;
	}

	/**
	 * @param abhin_stat_ind the abhin_stat_ind to set
	 */
	public void setAbhin_stat_ind(final String abhin_stat_ind) {
		this.abhin_stat_ind = abhin_stat_ind;
	}

	/**
	 * @return the abohi_stat_ind
	 */
	public String getAbohi_stat_ind() {
		return abohi_stat_ind;
	}

	/**
	 * @param abohi_stat_ind the abohi_stat_ind to set
	 */
	public void setAbohi_stat_ind(final String abohi_stat_ind) {
		this.abohi_stat_ind = abohi_stat_ind;
	}

	/**
	 * @return the dataCriteria
	 */
	public FwDataCriteria[] getDataCriteria() {
		return dataCriteria;
	}

	/**
	 * @param dataCriteria the dataCriteria to set
	 */
	public void setDataCriteria(final FwDataCriteria[] dataCriteria) {
		this.dataCriteria = dataCriteria;
	}

	/**
	 * @return the whereCriteria
	 */
	public FwDataCriteria[] getWhereCriteria() {
		return whereCriteria;
	}

	/**
	 * @param whereCriteria the whereCriteria to set
	 */
	public void setWhereCriteria(final FwDataCriteria[] whereCriteria) {
		this.whereCriteria = whereCriteria;
	}

	/**
	 * @return the app_num
	 */
	public String getApp_num() {
		return app_num;
	}

	/**
	 * @param app_num the app_num to set
	 */
	public void setApp_num(final String app_num) {
		this.app_num = app_num;
	}

	/**
	 * @return the abapd_stat_ind
	 */
	public String getAbapd_stat_ind() {
		return abapd_stat_ind;
	}

	/**
	 * @param abapd_stat_ind the abapd_stat_ind to set
	 */
	public void setAbapd_stat_ind(final String abapd_stat_ind) {
		this.abapd_stat_ind = abapd_stat_ind;
	}

	/**
	 * @return the abbnr_stat_ind
	 */
	public String getAbbnr_stat_ind() {
		return abbnr_stat_ind;
	}

	/**
	 * @param abbnr_stat_ind the abbnr_stat_ind to set
	 */
	public void setAbbnr_stat_ind(final String abbnr_stat_ind) {
		this.abbnr_stat_ind = abbnr_stat_ind;
	}

	/**
	 * @return the abdcd_stat_ind
	 */
	public String getAbdcd_stat_ind() {
		return abdcd_stat_ind;
	}

	/**
	 * @param abdcd_stat_ind the abdcd_stat_ind to set
	 */
	public void setAbdcd_stat_ind(final String abdcd_stat_ind) {
		this.abdcd_stat_ind = abdcd_stat_ind;
	}

	/**
	 * @return the abedt_stat_ind
	 */
	public String getAbedt_stat_ind() {
		return abedt_stat_ind;
	}

	/**
	 * @param abedt_stat_ind the abedt_stat_ind to set
	 */
	public void setAbedt_stat_ind(final String abedt_stat_ind) {
		this.abedt_stat_ind = abedt_stat_ind;
	}

	/**
	 * @return the abefd_stat_ind
	 */
	public String getAbefd_stat_ind() {
		return abefd_stat_ind;
	}

	/**
	 * @param abefd_stat_ind the abefd_stat_ind to set
	 */
	public void setAbefd_stat_ind(final String abefd_stat_ind) {
		this.abefd_stat_ind = abefd_stat_ind;
	}

	/**
	 * @return the abesm_stat_ind
	 */
	public String getAbesm_stat_ind() {
		return abesm_stat_ind;
	}

	/**
	 * @param abesm_stat_ind the abesm_stat_ind to set
	 */
	public void setAbesm_stat_ind(final String abesm_stat_ind) {
		this.abesm_stat_ind = abesm_stat_ind;
	}

	/**
	 * @return the abfas_stat_ind
	 */
	public String getAbfas_stat_ind() {
		return abfas_stat_ind;
	}

	/**
	 * @param abfas_stat_ind the abfas_stat_ind to set
	 */
	public void setAbfas_stat_ind(final String abfas_stat_ind) {
		this.abfas_stat_ind = abfas_stat_ind;
	}

	/**
	 * @return the abheq_stat_ind
	 */
	public String getAbheq_stat_ind() {
		return abheq_stat_ind;
	}

	/**
	 * @param abheq_stat_ind the abheq_stat_ind to set
	 */
	public void setAbheq_stat_ind(final String abheq_stat_ind) {
		this.abheq_stat_ind = abheq_stat_ind;
	}

	/**
	 * @return the abhes_stat_ind
	 */
	public String getAbhes_stat_ind() {
		return abhes_stat_ind;
	}

	/**
	 * @param abhes_stat_ind the abhes_stat_ind to set
	 */
	public void setAbhes_stat_ind(final String abhes_stat_ind) {
		this.abhes_stat_ind = abhes_stat_ind;
	}

	/**
	 * @return the abhhq_stat_ind
	 */
	public String getAbhhq_stat_ind() {
		return abhhq_stat_ind;
	}

	/**
	 * @param abhhq_stat_ind the abhhq_stat_ind to set
	 */
	public void setAbhhq_stat_ind(final String abhhq_stat_ind) {
		this.abhhq_stat_ind = abhhq_stat_ind;
	}

	/**
	 * @return the abhhr_stat_ind
	 */
	public String getAbhhr_stat_ind() {
		return abhhr_stat_ind;
	}

	/**
	 * @param abhhr_stat_ind the abhhr_stat_ind to set
	 */
	public void setAbhhr_stat_ind(final String abhhr_stat_ind) {
		this.abhhr_stat_ind = abhhr_stat_ind;
	}

	/**
	 * @return the abhis_stat_ind
	 */
	public String getAbhis_stat_ind() {
		return abhis_stat_ind;
	}

	/**
	 * @param abhis_stat_ind the abhis_stat_ind to set
	 */
	public void setAbhis_stat_ind(final String abhis_stat_ind) {
		this.abhis_stat_ind = abhis_stat_ind;
	}

	/**
	 * @return the abhmd_stat_ind
	 */
	public String getAbhmd_stat_ind() {
		return abhmd_stat_ind;
	}

	/**
	 * @param abhmd_stat_ind the abhmd_stat_ind to set
	 */
	public void setAbhmd_stat_ind(final String abhmd_stat_ind) {
		this.abhmd_stat_ind = abhmd_stat_ind;
	}

	/**
	 * @return the abshs_stat_ind
	 */
	public String getAbshs_stat_ind() {
		return abshs_stat_ind;
	}

	/**
	 * @param abshs_stat_ind the abshs_stat_ind to set
	 */
	public void setAbshs_stat_ind(final String abshs_stat_ind) {
		this.abshs_stat_ind = abshs_stat_ind;
	}

	/**
	 * @return the abspd_stat_ind
	 */
	public String getAbspd_stat_ind() {
		return abspd_stat_ind;
	}

	/**
	 * @param abspd_stat_ind the abspd_stat_ind to set
	 */
	public void setAbspd_stat_ind(final String abspd_stat_ind) {
		this.abspd_stat_ind = abspd_stat_ind;
	}

	/**
	 * @return the abhel_stat_ind
	 */
	public String getAbhel_stat_ind() {
		return abhel_stat_ind;
	}

	/**
	 * @param abhel_stat_ind the abhel_stat_ind to set
	 */
	public void setAbhel_stat_ind(final String abhel_stat_ind) {
		this.abhel_stat_ind = abhel_stat_ind;
	}

	/**
	 * @return the abhng_stat_ind
	 */
	public String getAbhng_stat_ind() {
		return abhng_stat_ind;
	}

	/**
	 * @param abhng_stat_ind the abhng_stat_ind to set
	 */
	public void setAbhng_stat_ind(final String abhng_stat_ind) {
		this.abhng_stat_ind = abhng_stat_ind;
	}

	/**
	 * @return the abedr_stat_ind
	 */
	public String getAbedr_stat_ind() {
		return abedr_stat_ind;
	}

	/**
	 * @param abedr_stat_ind the abedr_stat_ind to set
	 */
	public void setAbedr_stat_ind(final String abedr_stat_ind) {
		this.abedr_stat_ind = abedr_stat_ind;
	}

	/**
	 * @return the abhdr_stat_ind
	 */
	public String getAbhdr_stat_ind() {
		return abhdr_stat_ind;
	}

	/**
	 * @param abhdr_stat_ind the abhdr_stat_ind to set
	 */
	public void setAbhdr_stat_ind(final String abhdr_stat_ind) {
		this.abhdr_stat_ind = abhdr_stat_ind;
	}

	/**
	 * @return the abdfg_stat_ind
	 */
	public String getAbdfg_stat_ind() {
		return abdfg_stat_ind;
	}

	/**
	 * @param abdfg_stat_ind the abdfg_stat_ind to set
	 */
	public void setAbdfg_stat_ind(final String abdfg_stat_ind) {
		this.abdfg_stat_ind = abdfg_stat_ind;
	}

	/**
	 * @return the abfur_stat_ind
	 */
	public String getAbfur_stat_ind() {
		return abfur_stat_ind;
	}

	/**
	 * @param abfur_stat_ind the abfur_stat_ind to set
	 */
	public void setAbfur_stat_ind(final String abfur_stat_ind) {
		this.abfur_stat_ind = abfur_stat_ind;
	}

	/**
	 * @return the abpth_stat_ind
	 */
	public String getAbpth_stat_ind() {
		return abpth_stat_ind;
	}

	/**
	 * @param abpth_stat_ind the abpth_stat_ind to set
	 */
	public void setAbpth_stat_ind(final String abpth_stat_ind) {
		this.abpth_stat_ind = abpth_stat_ind;
	}

	/**
	 * @return the absss_stat_ind
	 */
	public String getAbsss_stat_ind() {
		return absss_stat_ind;
	}

	/**
	 * @param absss_stat_ind the absss_stat_ind to set
	 */
	public void setAbsss_stat_ind(final String absss_stat_ind) {
		this.absss_stat_ind = absss_stat_ind;
	}

	/**
	 * @return the abhms_stat_ind
	 */
	public String getAbhms_stat_ind() {
		return abhms_stat_ind;
	}

	/**
	 * @param abhms_stat_ind the abhms_stat_ind to set
	 */
	public void setAbhms_stat_ind(final String abhms_stat_ind) {
		this.abhms_stat_ind = abhms_stat_ind;
	}

	/**
	 * @return the abjiq_stat_ind
	 */
	public String getAbjiq_stat_ind() {
		return abjiq_stat_ind;
	}

	/**
	 * @param abjiq_stat_ind the abjiq_stat_ind to set
	 */
	public void setAbjiq_stat_ind(final String abjiq_stat_ind) {
		this.abjiq_stat_ind = abjiq_stat_ind;
	}

	/**
	 * @return the abjis_stat_ind
	 */
	public String getAbjis_stat_ind() {
		return abjis_stat_ind;
	}

	/**
	 * @param abjis_stat_ind the abjis_stat_ind to set
	 */
	public void setAbjis_stat_ind(final String abjis_stat_ind) {
		this.abjis_stat_ind = abjis_stat_ind;
	}

	/**
	 * @return the abmed_stat_ind
	 */
	public String getAbmed_stat_ind() {
		return abmed_stat_ind;
	}

	/**
	 * @param abmed_stat_ind the abmed_stat_ind to set
	 */
	public void setAbmed_stat_ind(final String abmed_stat_ind) {
		this.abmed_stat_ind = abmed_stat_ind;
	}

	/**
	 * @return the abnsd_stat_ind
	 */
	public String getAbnsd_stat_ind() {
		return abnsd_stat_ind;
	}

	/**
	 * @param abnsd_stat_ind the abnsd_stat_ind to set
	 */
	public void setAbnsd_stat_ind(final String abnsd_stat_ind) {
		this.abnsd_stat_ind = abnsd_stat_ind;
	}

	/**
	 * @return the abnso_stat_ind
	 */
	public String getAbnso_stat_ind() {
		return abnso_stat_ind;
	}

	/**
	 * @param abnso_stat_ind the abnso_stat_ind to set
	 */
	public void setAbnso_stat_ind(final String abnso_stat_ind) {
		this.abnso_stat_ind = abnso_stat_ind;
	}

	/**
	 * @return the aboeq_stat_ind
	 */
	public String getAboeq_stat_ind() {
		return aboeq_stat_ind;
	}

	/**
	 * @param aboeq_stat_ind the aboeq_stat_ind to set
	 */
	public void setAboeq_stat_ind(final String aboeq_stat_ind) {
		this.aboeq_stat_ind = aboeq_stat_ind;
	}

	/**
	 * @return the aboiq_stat_ind
	 */
	public String getAboiq_stat_ind() {
		return aboiq_stat_ind;
	}

	/**
	 * @param aboiq_stat_ind the aboiq_stat_ind to set
	 */
	public void setAboiq_stat_ind(final String aboiq_stat_ind) {
		this.aboiq_stat_ind = aboiq_stat_ind;
	}

	/**
	 * @return the abois_stat_ind
	 */
	public String getAbois_stat_ind() {
		return abois_stat_ind;
	}

	/**
	 * @param abois_stat_ind the abois_stat_ind to set
	 */
	public void setAbois_stat_ind(final String abois_stat_ind) {
		this.abois_stat_ind = abois_stat_ind;
	}

	/**
	 * @return the abpas_stat_ind
	 */
	public String getAbpas_stat_ind() {
		return abpas_stat_ind;
	}

	/**
	 * @param abpas_stat_ind the abpas_stat_ind to set
	 */
	public void setAbpas_stat_ind(final String abpas_stat_ind) {
		this.abpas_stat_ind = abpas_stat_ind;
	}

	/**
	 * @return the abpps_stat_ind
	 */
	public String getAbpps_stat_ind() {
		return abpps_stat_ind;
	}

	/**
	 * @param abpps_stat_ind the abpps_stat_ind to set
	 */
	public void setAbpps_stat_ind(final String abpps_stat_ind) {
		this.abpps_stat_ind = abpps_stat_ind;
	}

	/**
	 * @return the abprg_stat_ind
	 */
	public String getAbprg_stat_ind() {
		return abprg_stat_ind;
	}

	/**
	 * @param abprg_stat_ind the abprg_stat_ind to set
	 */
	public void setAbprg_stat_ind(final String abprg_stat_ind) {
		this.abprg_stat_ind = abprg_stat_ind;
	}

	/**
	 * @return the abpri_stat_ind
	 */
	public String getAbpri_stat_ind() {
		return abpri_stat_ind;
	}

	/**
	 * @param abpri_stat_ind the abpri_stat_ind to set
	 */
	public void setAbpri_stat_ind(final String abpri_stat_ind) {
		this.abpri_stat_ind = abpri_stat_ind;
	}

	/**
	 * @return the abpsq_stat_ind
	 */
	public String getAbpsq_stat_ind() {
		return abpsq_stat_ind;
	}

	/**
	 * @param abpsq_stat_ind the abpsq_stat_ind to set
	 */
	public void setAbpsq_stat_ind(final String abpsq_stat_ind) {
		this.abpsq_stat_ind = abpsq_stat_ind;
	}

	/**
	 * @return the abrgi_stat_ind
	 */
	public String getAbrgi_stat_ind() {
		return abrgi_stat_ind;
	}

	/**
	 * @param abrgi_stat_ind the abrgi_stat_ind to set
	 */
	public void setAbrgi_stat_ind(final String abrgi_stat_ind) {
		this.abrgi_stat_ind = abrgi_stat_ind;
	}

	/**
	 * @return the abrgs_stat_ind
	 */
	public String getAbrgs_stat_ind() {
		return abrgs_stat_ind;
	}

	/**
	 * @param abrgs_stat_ind the abrgs_stat_ind to set
	 */
	public void setAbrgs_stat_ind(final String abrgs_stat_ind) {
		this.abrgs_stat_ind = abrgs_stat_ind;
	}

	/**
	 * @return the abrlv_stat_ind
	 */
	public String getAbrlv_stat_ind() {
		return abrlv_stat_ind;
	}

	/**
	 * @param abrlv_stat_ind the abrlv_stat_ind to set
	 */
	public void setAbrlv_stat_ind(final String abrlv_stat_ind) {
		this.abrlv_stat_ind = abrlv_stat_ind;
	}

	/**
	 * @return the abscd_stat_ind
	 */
	public String getAbscd_stat_ind() {
		return abscd_stat_ind;
	}

	/**
	 * @param abscd_stat_ind the abscd_stat_ind to set
	 */
	public void setAbscd_stat_ind(final String abscd_stat_ind) {
		this.abscd_stat_ind = abscd_stat_ind;
	}

	/**
	 * @return the absct_stat_ind
	 */
	public String getAbsct_stat_ind() {
		return absct_stat_ind;
	}

	/**
	 * @param absct_stat_ind the absct_stat_ind to set
	 */
	public void setAbsct_stat_ind(final String absct_stat_ind) {
		this.absct_stat_ind = absct_stat_ind;
	}

	/**
	 * @return the absed_stat_ind
	 */
	public String getAbsed_stat_ind() {
		return absed_stat_ind;
	}

	/**
	 * @param absed_stat_ind the absed_stat_ind to set
	 */
	public void setAbsed_stat_ind(final String absed_stat_ind) {
		this.absed_stat_ind = absed_stat_ind;
	}

	/**
	 * @return the absen_stat_ind
	 */
	public String getAbsen_stat_ind() {
		return absen_stat_ind;
	}

	/**
	 * @param absen_stat_ind the absen_stat_ind to set
	 */
	public void setAbsen_stat_ind(final String absen_stat_ind) {
		this.absen_stat_ind = absen_stat_ind;
	}

	/**
	 * @return the abucd_stat_ind
	 */
	public String getAbucd_stat_ind() {
		return abucd_stat_ind;
	}

	/**
	 * @param abucd_stat_ind the abucd_stat_ind to set
	 */
	public void setAbucd_stat_ind(final String abucd_stat_ind) {
		this.abucd_stat_ind = abucd_stat_ind;
	}

	/**
	 * @return the abuct_stat_ind
	 */
	public String getAbuct_stat_ind() {
		return abuct_stat_ind;
	}

	/**
	 * @param abuct_stat_ind the abuct_stat_ind to set
	 */
	public void setAbuct_stat_ind(final String abuct_stat_ind) {
		this.abuct_stat_ind = abuct_stat_ind;
	}

	/**
	 * @return the abuid_stat_ind
	 */
	public String getAbuid_stat_ind() {
		return abuid_stat_ind;
	}

	/**
	 * @param abuid_stat_ind the abuid_stat_ind to set
	 */
	public void setAbuid_stat_ind(final String abuid_stat_ind) {
		this.abuid_stat_ind = abuid_stat_ind;
	}

	/**
	 * @return the abuit_stat_ind
	 */
	public String getAbuit_stat_ind() {
		return abuit_stat_ind;
	}

	/**
	 * @param abuit_stat_ind the abuit_stat_ind to set
	 */
	public void setAbuit_stat_ind(final String abuit_stat_ind) {
		this.abuit_stat_ind = abuit_stat_ind;
	}

	/**
	 * @return the abbad_stat_ind
	 */
	public String getAbbad_stat_ind() {
		return abbad_stat_ind;
	}

	/**
	 * @param abbad_stat_ind the abbad_stat_ind to set
	 */
	public void setAbbad_stat_ind(final String abbad_stat_ind) {
		this.abbad_stat_ind = abbad_stat_ind;
	}

	/**
	 * @return the abbat_stat_ind
	 */
	public String getAbbat_stat_ind() {
		return abbat_stat_ind;
	}

	/**
	 * @param abbat_stat_ind the abbat_stat_ind to set
	 */
	public void setAbbat_stat_ind(final String abbat_stat_ind) {
		this.abbat_stat_ind = abbat_stat_ind;
	}

	/**
	 * @return the abcon_stat_ind
	 */
	public String getAbcon_stat_ind() {
		return abcon_stat_ind;
	}

	/**
	 * @param abcon_stat_ind the abcon_stat_ind to set
	 */
	public void setAbcon_stat_ind(final String abcon_stat_ind) {
		this.abcon_stat_ind = abcon_stat_ind;
	}

	/**
	 * @return the abdis_stat_ind
	 */
	public String getAbdis_stat_ind() {
		return abdis_stat_ind;
	}

	/**
	 * @param abdis_stat_ind the abdis_stat_ind to set
	 */
	public void setAbdis_stat_ind(final String abdis_stat_ind) {
		this.abdis_stat_ind = abdis_stat_ind;
	}

	/**
	 * @return the abhca_stat_ind
	 */
	public String getAbhca_stat_ind() {
		return abhca_stat_ind;
	}

	/**
	 * @param abhca_stat_ind the abhca_stat_ind to set
	 */
	public void setAbhca_stat_ind(final String abhca_stat_ind) {
		this.abhca_stat_ind = abhca_stat_ind;
	}

	/**
	 * @return the abhcd_stat_ind
	 */
	public String getAbhcd_stat_ind() {
		return abhcd_stat_ind;
	}

	/**
	 * @param abhcd_stat_ind the abhcd_stat_ind to set
	 */
	public void setAbhcd_stat_ind(final String abhcd_stat_ind) {
		this.abhcd_stat_ind = abhcd_stat_ind;
	}

	/**
	 * @return the abhwa_stat_ind
	 */
	public String getAbhwa_stat_ind() {
		return abhwa_stat_ind;
	}

	/**
	 * @param abhwa_stat_ind the abhwa_stat_ind to set
	 */
	public void setAbhwa_stat_ind(final String abhwa_stat_ind) {
		this.abhwa_stat_ind = abhwa_stat_ind;
	}

	/**
	 * @return the abind_stat_ind
	 */
	public String getAbind_stat_ind() {
		return abind_stat_ind;
	}

	/**
	 * @param abind_stat_ind the abind_stat_ind to set
	 */
	public void setAbind_stat_ind(final String abind_stat_ind) {
		this.abind_stat_ind = abind_stat_ind;
	}

	/**
	 * @return the ablad_stat_ind
	 */
	public String getAblad_stat_ind() {
		return ablad_stat_ind;
	}

	/**
	 * @param ablad_stat_ind the ablad_stat_ind to set
	 */
	public void setAblad_stat_ind(final String ablad_stat_ind) {
		this.ablad_stat_ind = ablad_stat_ind;
	}

	/**
	 * @return the ablaq_stat_ind
	 */
	public String getAblaq_stat_ind() {
		return ablaq_stat_ind;
	}

	/**
	 * @param ablaq_stat_ind the ablaq_stat_ind to set
	 */
	public void setAblaq_stat_ind(final String ablaq_stat_ind) {
		this.ablaq_stat_ind = ablaq_stat_ind;
	}

	/**
	 * @return the ablas_stat_ind
	 */
	public String getAblas_stat_ind() {
		return ablas_stat_ind;
	}

	/**
	 * @param ablas_stat_ind the ablas_stat_ind to set
	 */
	public void setAblas_stat_ind(final String ablas_stat_ind) {
		this.ablas_stat_ind = ablas_stat_ind;
	}

	/**
	 * @return the ablat_stat_ind
	 */
	public String getAblat_stat_ind() {
		return ablat_stat_ind;
	}

	/**
	 * @param ablat_stat_ind the ablat_stat_ind to set
	 */
	public void setAblat_stat_ind(final String ablat_stat_ind) {
		this.ablat_stat_ind = ablat_stat_ind;
	}

	/**
	 * @return the ablid_stat_ind
	 */
	public String getAblid_stat_ind() {
		return ablid_stat_ind;
	}

	/**
	 * @param ablid_stat_ind the ablid_stat_ind to set
	 */
	public void setAblid_stat_ind(final String ablid_stat_ind) {
		this.ablid_stat_ind = ablid_stat_ind;
	}

	/**
	 * @return the ablit_stat_ind
	 */
	public String getAblit_stat_ind() {
		return ablit_stat_ind;
	}

	/**
	 * @param ablit_stat_ind the ablit_stat_ind to set
	 */
	public void setAblit_stat_ind(final String ablit_stat_ind) {
		this.ablit_stat_ind = ablit_stat_ind;
	}

	/**
	 * @return the aboaq_stat_ind
	 */
	public String getAboaq_stat_ind() {
		return aboaq_stat_ind;
	}

	/**
	 * @param aboaq_stat_ind the aboaq_stat_ind to set
	 */
	public void setAboaq_stat_ind(final String aboaq_stat_ind) {
		this.aboaq_stat_ind = aboaq_stat_ind;
	}

	/**
	 * @return the aboas_stat_ind
	 */
	public String getAboas_stat_ind() {
		return aboas_stat_ind;
	}

	/**
	 * @param aboas_stat_ind the aboas_stat_ind to set
	 */
	public void setAboas_stat_ind(final String aboas_stat_ind) {
		this.aboas_stat_ind = aboas_stat_ind;
	}

	/**
	 * @return the abppd_stat_ind
	 */
	public String getAbppd_stat_ind() {
		return abppd_stat_ind;
	}

	/**
	 * @param abppd_stat_ind the abppd_stat_ind to set
	 */
	public void setAbppd_stat_ind(final String abppd_stat_ind) {
		this.abppd_stat_ind = abppd_stat_ind;
	}

	/**
	 * @return the abrpd_stat_ind
	 */
	public String getAbrpd_stat_ind() {
		return abrpd_stat_ind;
	}

	/**
	 * @param abrpd_stat_ind the abrpd_stat_ind to set
	 */
	public void setAbrpd_stat_ind(final String abrpd_stat_ind) {
		this.abrpd_stat_ind = abrpd_stat_ind;
	}

	/**
	 * @return the abrpt_stat_ind
	 */
	public String getAbrpt_stat_ind() {
		return abrpt_stat_ind;
	}

	/**
	 * @param abrpt_stat_ind the abrpt_stat_ind to set
	 */
	public void setAbrpt_stat_ind(final String abrpt_stat_ind) {
		this.abrpt_stat_ind = abrpt_stat_ind;
	}

	/**
	 * @return the abvad_stat_ind
	 */
	public String getAbvad_stat_ind() {
		return abvad_stat_ind;
	}

	/**
	 * @param abvad_stat_ind the abvad_stat_ind to set
	 */
	public void setAbvad_stat_ind(final String abvad_stat_ind) {
		this.abvad_stat_ind = abvad_stat_ind;
	}

	/**
	 * @return the abvat_stat_ind
	 */
	public String getAbvat_stat_ind() {
		return abvat_stat_ind;
	}

	/**
	 * @param abvat_stat_ind the abvat_stat_ind to set
	 */
	public void setAbvat_stat_ind(final String abvat_stat_ind) {
		this.abvat_stat_ind = abvat_stat_ind;
	}

	/**
	 * @return the abmet_stat_ind
	 */
	public String getAbmet_stat_ind() {
		return abmet_stat_ind;
	}

	/**
	 * @param abmet_stat_ind the abmet_stat_ind to set
	 */
	public void setAbmet_stat_ind(final String abmet_stat_ind) {
		this.abmet_stat_ind = abmet_stat_ind;
	}

	/**
	 * @return the abmbd_stat_ind
	 */
	public String getAbmbd_stat_ind() {
		return abmbd_stat_ind;
	}

	/**
	 * @param abmbd_stat_ind the abmbd_stat_ind to set
	 */
	public void setAbmbd_stat_ind(final String abmbd_stat_ind) {
		this.abmbd_stat_ind = abmbd_stat_ind;
	}

	/**
	 * @return the abmah_stat_ind
	 */
	public String getAbmah_stat_ind() {
		return abmah_stat_ind;
	}

	/**
	 * @param abmah_stat_ind the abmah_stat_ind to set
	 */
	public void setAbmah_stat_ind(final String abmah_stat_ind) {
		this.abmah_stat_ind = abmah_stat_ind;
	}

	/**
	 * @return the abpng_stat_ind
	 */
	public String getAbpng_stat_ind() {
		return abpng_stat_ind;
	}

	/**
	 * @param abpng_stat_ind the abpng_stat_ind to set
	 */
	public void setAbpng_stat_ind(final String abpng_stat_ind) {
		this.abpng_stat_ind = abpng_stat_ind;
	}

	/**
	 * @return the abped_stat_ind
	 */
	public String getAbped_stat_ind() {
		return abped_stat_ind;
	}

	/**
	 * @param abped_stat_ind the abped_stat_ind to set
	 */
	public void setAbped_stat_ind(final String abped_stat_ind) {
		this.abped_stat_ind = abped_stat_ind;
	}

	/**
	 * @return the abphd_stat_ind
	 */
	public String getAbphd_stat_ind() {
		return abphd_stat_ind;
	}

	/**
	 * @param abphd_stat_ind the abphd_stat_ind to set
	 */
	public void setAbphd_stat_ind(final String abphd_stat_ind) {
		this.abphd_stat_ind = abphd_stat_ind;
	}

	/**
	 * @return the abstd_stat_ind
	 */
	public String getAbstd_stat_ind() {
		return abstd_stat_ind;
	}

	/**
	 * @param abstd_stat_ind the abstd_stat_ind to set
	 */
	public void setAbstd_stat_ind(final String abstd_stat_ind) {
		this.abstd_stat_ind = abstd_stat_ind;
	}

	/**
	 * @return the abuad_stat_ind
	 */
	public String getAbuad_stat_ind() {
		return abuad_stat_ind;
	}

	/**
	 * @param abuad_stat_ind the abuad_stat_ind to set
	 */
	public void setAbuad_stat_ind(final String abuad_stat_ind) {
		this.abuad_stat_ind = abuad_stat_ind;
	}

	/**
	 * @return the abdty_stat_ind
	 */
	public String getAbdty_stat_ind() {
		return abdty_stat_ind;
	}

	/**
	 * @param abdty_stat_ind the abdty_stat_ind to set
	 */
	public void setAbdty_stat_ind(final String abdty_stat_ind) {
		this.abdty_stat_ind = abdty_stat_ind;
	}

	/**
	 * @return the abddt_stat_ind
	 */
	public String getAbddt_stat_ind() {
		return abddt_stat_ind;
	}

	/**
	 * @param abddt_stat_ind the abddt_stat_ind to set
	 */
	public void setAbddt_stat_ind(final String abddt_stat_ind) {
		this.abddt_stat_ind = abddt_stat_ind;
	}

	/**
	 * @return the abdsm_stat_ind
	 */
	public String getAbdsm_stat_ind() {
		return abdsm_stat_ind;
	}

	/**
	 * @param abdsm_stat_ind the abdsm_stat_ind to set
	 */
	public void setAbdsm_stat_ind(final String abdsm_stat_ind) {
		this.abdsm_stat_ind = abdsm_stat_ind;
	}

	/**
	 * @return the abdfe_stat_ind
	 */
	public String getAbdfe_stat_ind() {
		return abdfe_stat_ind;
	}

	/**
	 * @param abdfe_stat_ind the abdfe_stat_ind to set
	 */
	public void setAbdfe_stat_ind(final String abdfe_stat_ind) {
		this.abdfe_stat_ind = abdfe_stat_ind;
	}

	/**
	 * @return the abcpa_stat_ind
	 */
	public String getAbcpa_stat_ind() {
		return abcpa_stat_ind;
	}

	/**
	 * @param abcpa_stat_ind the abcpa_stat_ind to set
	 */
	public void setAbcpa_stat_ind(final String abcpa_stat_ind) {
		this.abcpa_stat_ind = abcpa_stat_ind;
	}

	/**
	 * @return the abcph_stat_ind
	 */
	public String getAbcph_stat_ind() {
		return abcph_stat_ind;
	}

	/**
	 * @param abcph_stat_ind the abcph_stat_ind to set
	 */
	public void setAbcph_stat_ind(final String abcph_stat_ind) {
		this.abcph_stat_ind = abcph_stat_ind;
	}

	/**
	 * @return the abcra_stat_ind
	 */
	public String getAbcra_stat_ind() {
		return abcra_stat_ind;
	}

	/**
	 * @param abcra_stat_ind the abcra_stat_ind to set
	 */
	public void setAbcra_stat_ind(final String abcra_stat_ind) {
		this.abcra_stat_ind = abcra_stat_ind;
	}

	/**
	 * @return the abeca_stat_ind
	 */
	public String getAbeca_stat_ind() {
		return abeca_stat_ind;
	}

	/**
	 * @param abeca_stat_ind the abeca_stat_ind to set
	 */
	public void setAbeca_stat_ind(final String abeca_stat_ind) {
		this.abeca_stat_ind = abeca_stat_ind;
	}

	/**
	 * @return the abefa_stat_ind
	 */
	public String getAbefa_stat_ind() {
		return abefa_stat_ind;
	}

	/**
	 * @param abefa_stat_ind the abefa_stat_ind to set
	 */
	public void setAbefa_stat_ind(final String abefa_stat_ind) {
		this.abefa_stat_ind = abefa_stat_ind;
	}

	/**
	 * @return the absta_stat_ind
	 */
	public String getAbsta_stat_ind() {
		return absta_stat_ind;
	}

	/**
	 * @param absta_stat_ind the absta_stat_ind to set
	 */
	public void setAbsta_stat_ind(final String absta_stat_ind) {
		this.absta_stat_ind = absta_stat_ind;
	}

	/**
	 * @return the abshe_stat_ind
	 */
	public String getAbshe_stat_ind() {
		return abshe_stat_ind;
	}

	/**
	 * @param abshe_stat_ind the abshe_stat_ind to set
	 */
	public void setAbshe_stat_ind(final String abshe_stat_ind) {
		this.abshe_stat_ind = abshe_stat_ind;
	}

	/**
	 * @return the absae_stat_ind
	 */
	public String getAbsae_stat_ind() {
		return absae_stat_ind;
	}

	/**
	 * @param absae_stat_ind the absae_stat_ind to set
	 */
	public void setAbsae_stat_ind(final String absae_stat_ind) {
		this.absae_stat_ind = absae_stat_ind;
	}

	/**
	 * @return the abavd_stat_ind
	 */
	public String getAbavd_stat_ind() {
		return abavd_stat_ind;
	}

	/**
	 * @param abavd_stat_ind the abavd_stat_ind to set
	 */
	public void setAbavd_stat_ind(final String abavd_stat_ind) {
		this.abavd_stat_ind = abavd_stat_ind;
	}

	/**
	 * @return the abhdn_stat_ind
	 */
	public String getAbhdn_stat_ind() {
		return abhdn_stat_ind;
	}

	/**
	 * @param abhdn_stat_ind the abhdn_stat_ind to set
	 */
	public void setAbhdn_stat_ind(final String abhdn_stat_ind) {
		this.abhdn_stat_ind = abhdn_stat_ind;
	}

	/**
	 * @return the abwre_stat_ind
	 */
	public String getAbwre_stat_ind() {
		return abwre_stat_ind;
	}

	/**
	 * @param abwre_stat_ind the abwre_stat_ind to set
	 */
	public void setAbwre_stat_ind(final String abwre_stat_ind) {
		this.abwre_stat_ind = abwre_stat_ind;
	}

	/**
	 * @return the abaur_stat_ind
	 */
	public String getAbaur_stat_ind() {
		return abaur_stat_ind;
	}

	/**
	 * @param abaur_stat_ind the abaur_stat_ind to set
	 */
	public void setAbaur_stat_ind(final String abaur_stat_ind) {
		this.abaur_stat_ind = abaur_stat_ind;
	}

	/**
	 * @return the abchs_stat_ind
	 */
	public String getAbchs_stat_ind() {
		return abchs_stat_ind;
	}

	/**
	 * @param abchs_stat_ind the abchs_stat_ind to set
	 */
	public void setAbchs_stat_ind(final String abchs_stat_ind) {
		this.abchs_stat_ind = abchs_stat_ind;
	}

	/**
	 * @return the abdoc_stat_ind
	 */
	public String getAbdoc_stat_ind() {
		return abdoc_stat_ind;
	}

	/**
	 * @param abdoc_stat_ind the abdoc_stat_ind to set
	 */
	public void setAbdoc_stat_ind(final String abdoc_stat_ind) {
		this.abdoc_stat_ind = abdoc_stat_ind;
	}

	/**
	 * @return the abobq_stat_ind
	 */
	public String getAbobq_stat_ind() {
		return abobq_stat_ind;
	}

	/**
	 * @param abobq_stat_ind the abobq_stat_ind to set
	 */
	public void setAbobq_stat_ind(final String abobq_stat_ind) {
		this.abobq_stat_ind = abobq_stat_ind;
	}

	/**
	 * @return the abhsc_stat_ind
	 */
	public String getAbhsc_stat_ind() {
		return abhsc_stat_ind;
	}

	/**
	 * @param abhsc_stat_ind the abhsc_stat_ind to set
	 */
	public void setAbhsc_stat_ind(final String abhsc_stat_ind) {
		this.abhsc_stat_ind = abhsc_stat_ind;
	}

	/**
	 * @return the abmdp_stat_ind
	 */
	public String getAbmdp_stat_ind() {
		return abmdp_stat_ind;
	}

	/**
	 * @param abmdp_stat_ind the abmdp_stat_ind to set
	 */
	public void setAbmdp_stat_ind(final String abmdp_stat_ind) {
		this.abmdp_stat_ind = abmdp_stat_ind;
	}

	/**
	 * @return the abhlt_stat_ind
	 */
	public String getAbhlt_stat_ind() {
		return abhlt_stat_ind;
	}

	/**
	 * @param abhlt_stat_ind the abhlt_stat_ind to set
	 */
	public void setAbhlt_stat_ind(final String abhlt_stat_ind) {
		this.abhlt_stat_ind = abhlt_stat_ind;
	}

	/**
	 * @return the abhsy_stat_ind
	 */
	public String getAbhsy_stat_ind() {
		return abhsy_stat_ind;
	}

	/**
	 * @param abhsy_stat_ind the abhsy_stat_ind to set
	 */
	public void setAbhsy_stat_ind(final String abhsy_stat_ind) {
		this.abhsy_stat_ind = abhsy_stat_ind;
	}

	/**
	 * @return the ablhi_stat_ind
	 */
	public String getAblhi_stat_ind() {
		return ablhi_stat_ind;
	}

	/**
	 * @param ablhi_stat_ind the ablhi_stat_ind to set
	 */
	public void setAblhi_stat_ind(final String ablhi_stat_ind) {
		this.ablhi_stat_ind = ablhi_stat_ind;
	}

	/**
	 * @return the abnhm_stat_ind
	 */
	public String getAbnhm_stat_ind() {
		return abnhm_stat_ind;
	}

	/**
	 * @param abnhm_stat_ind the abnhm_stat_ind to set
	 */
	public void setAbnhm_stat_ind(final String abnhm_stat_ind) {
		this.abnhm_stat_ind = abnhm_stat_ind;
	}

	/**
	 * @return the abobs_stat_ind
	 */
	public String getAbobs_stat_ind() {
		return abobs_stat_ind;
	}

	/**
	 * @param abobs_stat_ind the abobs_stat_ind to set
	 */
	public void setAbobs_stat_ind(final String abobs_stat_ind) {
		this.abobs_stat_ind = abobs_stat_ind;
	}

	/**
	 * @return the abipi_stat_ind
	 */
	public String getAbipi_stat_ind() {
		return abipi_stat_ind;
	}

	/**
	 * @param abipi_stat_ind the abipi_stat_ind to set
	 */
	public void setAbipi_stat_ind(final String abipi_stat_ind) {
		this.abipi_stat_ind = abipi_stat_ind;
	}

	/**
	 * @return the abipq_stat_ind
	 */
	public String getAbipq_stat_ind() {
		return abipq_stat_ind;
	}

	/**
	 * @param abipq_stat_ind the abipq_stat_ind to set
	 */
	public void setAbipq_stat_ind(final String abipq_stat_ind) {
		this.abipq_stat_ind = abipq_stat_ind;
	}

	/**
	 * @return the abcrc_stat_ind
	 */
	public String getAbcrc_stat_ind() {
		return abcrc_stat_ind;
	}

	/**
	 * @param abcrc_stat_ind the abcrc_stat_ind to set
	 */
	public void setAbcrc_stat_ind(final String abcrc_stat_ind) {
		this.abcrc_stat_ind = abcrc_stat_ind;
	}

	/**
	 * @return the abhip_stat_ind
	 */
	public String getAbhip_stat_ind() {
		return abhip_stat_ind;
	}

	/**
	 * @param abhip_stat_ind the abhip_stat_ind to set
	 */
	public void setAbhip_stat_ind(final String abhip_stat_ind) {
		this.abhip_stat_ind = abhip_stat_ind;
	}

	/**
	 * @return the abort_stat_ind
	 */
	public String getAbort_stat_ind() {
		return abort_stat_ind;
	}

	/**
	 * @param abort_stat_ind the abort_stat_ind to set
	 */
	public void setAbort_stat_ind(final String abort_stat_ind) {
		this.abort_stat_ind = abort_stat_ind;
	}

	/**
	 * @return the abord_stat_ind
	 */
	public String getAbord_stat_ind() {
		return abord_stat_ind;
	}

	/**
	 * @param abord_stat_ind the abord_stat_ind to set
	 */
	public void setAbord_stat_ind(final String abord_stat_ind) {
		this.abord_stat_ind = abord_stat_ind;
	}

	/**
	 * @return the abiki_stat_ind
	 */
	public String getAbiki_stat_ind() {
		return abiki_stat_ind;
	}

	/**
	 * @param abiki_stat_ind the abiki_stat_ind to set
	 */
	public void setAbiki_stat_ind(final String abiki_stat_ind) {
		this.abiki_stat_ind = abiki_stat_ind;
	}

	/**
	 * @return the abofs_stat_ind
	 */
	public String getAbofs_stat_ind() {
		return abofs_stat_ind;
	}

	/**
	 * @param abofs_stat_ind the abofs_stat_ind to set
	 */
	public void setAbofs_stat_ind(final String abofs_stat_ind) {
		this.abofs_stat_ind = abofs_stat_ind;
	}

	/**
	 * @return the abtax_stat_ind
	 */
	public String getAbtax_stat_ind() {
		return abtax_stat_ind;
	}

	/**
	 * @param abtax_stat_ind the abtax_stat_ind to set
	 */
	public void setAbtax_stat_ind(final String abtax_stat_ind) {
		this.abtax_stat_ind = abtax_stat_ind;
	}

	/**
	 * @return the abtdp_stat_ind
	 */
	public String getAbtdp_stat_ind() {
		return abtdp_stat_ind;
	}

	/**
	 * @param abtdp_stat_ind the abtdp_stat_ind to set
	 */
	public void setAbtdp_stat_ind(final String abtdp_stat_ind) {
		this.abtdp_stat_ind = abtdp_stat_ind;
	}

	/**
	 * @return the abitd_stat_ind
	 */
	public String getAbitd_stat_ind() {
		return abitd_stat_ind;
	}

	/**
	 * @param abitd_stat_ind the abitd_stat_ind to set
	 */
	public void setAbitd_stat_ind(final String abitd_stat_ind) {
		this.abitd_stat_ind = abitd_stat_ind;
	}

	/**
	 * @return the abbtx_stat_ind
	 */
	public String getAbbtx_stat_ind() {
		return abbtx_stat_ind;
	}

	/**
	 * @param abbtx_stat_ind the abbtx_stat_ind to set
	 */
	public void setAbbtx_stat_ind(final String abbtx_stat_ind) {
		this.abbtx_stat_ind = abbtx_stat_ind;
	}

	/**
	 * @return the abbtd_stat_ind
	 */
	public String getAbbtd_stat_ind() {
		return abbtd_stat_ind;
	}

	/**
	 * @param abbtd_stat_ind the abbtd_stat_ind to set
	 */
	public void setAbbtd_stat_ind(final String abbtd_stat_ind) {
		this.abbtd_stat_ind = abbtd_stat_ind;
	}

	/**
	 * @return the abehi_stat_ind
	 */
	public String getAbehi_stat_ind() {
		return abehi_stat_ind;
	}

	/**
	 * @param abehi_stat_ind the abehi_stat_ind to set
	 */
	public void setAbehi_stat_ind(final String abehi_stat_ind) {
		this.abehi_stat_ind = abehi_stat_ind;
	}

	/**
	 * returns the string value of cargo.
	 */
	@Override
	public String inspectCargo() {
		return new StringBuilder().append("AFB_DRVR: ").append("app_num=").append(app_num).append("abapd_stat_ind=").append(abapd_stat_ind)
				.append("abbnr_stat_ind=").append(abbnr_stat_ind).append("abdcd_stat_ind=").append(abdcd_stat_ind).append("abedt_stat_ind=")
				.append(abedt_stat_ind).append("abefd_stat_ind=").append(abefd_stat_ind).append("abesm_stat_ind=").append(abesm_stat_ind)
				.append("abfas_stat_ind=").append(abfas_stat_ind).append("abheq_stat_ind=").append(abheq_stat_ind).append("abhes_stat_ind=")
				.append(abhes_stat_ind).append("abhhq_stat_ind=").append(abhhq_stat_ind).append("abhhr_stat_ind=").append(abhhr_stat_ind)
				.append("abhis_stat_ind=").append(abhis_stat_ind).append("abhmd_stat_ind=").append(abhmd_stat_ind).append("abhms_stat_ind=")
				.append(abhms_stat_ind).append("abjiq_stat_ind=").append(abjiq_stat_ind).append("abjis_stat_ind=").append(abjis_stat_ind)
				.append("abmed_stat_ind=").append(abmed_stat_ind).append("abnsd_stat_ind=").append(abnsd_stat_ind).append("abnso_stat_ind=")
				.append(abnso_stat_ind).append("aboeq_stat_ind=").append(aboeq_stat_ind).append("aboiq_stat_ind=").append(aboiq_stat_ind)
				.append("abois_stat_ind=").append(abois_stat_ind).append("abpas_stat_ind=").append(abpas_stat_ind).append("abpps_stat_ind=")
				.append(abpps_stat_ind).append("abprg_stat_ind=").append(abprg_stat_ind).append("abpri_stat_ind=").append(abpri_stat_ind)
				.append("abpsq_stat_ind=").append(abpsq_stat_ind).append("abrgi_stat_ind=").append(abrgi_stat_ind).append("abrgs_stat_ind=")
				.append(abrgs_stat_ind).append("abrlv_stat_ind=").append(abrlv_stat_ind).append("abscd_stat_ind=").append(abscd_stat_ind)
				.append("absct_stat_ind=").append(absct_stat_ind).append("absed_stat_ind=").append(absed_stat_ind).append("absen_stat_ind=")
				.append(absen_stat_ind).append("abucd_stat_ind=").append(abucd_stat_ind).append("abuct_stat_ind=").append(abuct_stat_ind)
				.append("abuid_stat_ind=").append(abuid_stat_ind).append("abuit_stat_ind=").append(abuit_stat_ind).append("abbad_stat_ind=")
				.append(abbad_stat_ind).append("abbat_stat_ind=").append(abbat_stat_ind).append("abcon_stat_ind=").append(abcon_stat_ind)
				.append("abdis_stat_ind=").append(abdis_stat_ind).append("abhca_stat_ind=").append(abhca_stat_ind).append("abhcd_stat_ind=")
				.append(abhcd_stat_ind).append("abhwa_stat_ind=").append(abhwa_stat_ind).append("abind_stat_ind=").append(abind_stat_ind)
				.append("ablad_stat_ind=").append(ablad_stat_ind).append("ablaq_stat_ind=").append(ablaq_stat_ind).append("ablas_stat_ind=")
				.append(ablas_stat_ind).append("ablat_stat_ind=").append(ablat_stat_ind).append("ablid_stat_ind=").append(ablid_stat_ind)
				.append("ablit_stat_ind=").append(ablit_stat_ind).append("aboaq_stat_ind=").append(aboaq_stat_ind).append("aboas_stat_ind=")
				.append(aboas_stat_ind).append("abppd_stat_ind=").append(abppd_stat_ind).append("abrpd_stat_ind=").append(abrpd_stat_ind)
				.append("abrpt_stat_ind=").append(abrpt_stat_ind).append("abvad_stat_ind=").append(abvad_stat_ind).append("abvat_stat_ind=")
				.append(abvat_stat_ind).append("abshs_stat_ind=").append(abshs_stat_ind).append("abspd_stat_ind=").append(abspd_stat_ind)
				.append("abhel_stat_ind=").append(abhel_stat_ind).append("abhng_stat_ind=").append(abhng_stat_ind).append("abedr_stat_ind=")
				.append(abedr_stat_ind).append("abhdr_stat_ind=").append(abhdr_stat_ind).append("abdfg_stat_ind=").append(abdfg_stat_ind)
				.append("abfur_stat_ind=").append(abfur_stat_ind).append("abpth_stat_ind=").append(abpth_stat_ind).append("absss_stat_ind=")
				.append(absss_stat_ind).append("abpng_stat_ind=").append(abpng_stat_ind).append("abped_stat_ind=").append(abped_stat_ind)
				.append("abphd_stat_ind=").append(abphd_stat_ind).append("abstd_stat_ind=").append(abstd_stat_ind).append("abuad_stat_ind=")
				.append(abuad_stat_ind).append("abdty_stat_ind=").append(abdty_stat_ind).append("abddt_stat_ind=").append(abddt_stat_ind)
				.append("abdsm_stat_ind=").append(abdsm_stat_ind).append("abavd_stat_ind=").append(abavd_stat_ind).append("abhdn_stat_ind=")
				.append(abhdn_stat_ind).append("abdoc_stat_ind=").append(abdoc_stat_ind).append("abobq_stat_ind=").append(abobq_stat_ind)
				.append("abhsc_stat_ind=").append(abhsc_stat_ind).append("abmdp_stat_ind=").append(abmdp_stat_ind).append("abhlt_stat_ind=")
				.append(abhlt_stat_ind).append("abhsy_stat_ind=").append(abhsy_stat_ind).append("ablhi_stat_ind=").append(ablhi_stat_ind)
				.append("abnhm_stat_ind=").append(abnhm_stat_ind).append("abipi_stat_ind=").append(abipi_stat_ind).append("abipq_stat_ind=")
				.append(abipq_stat_ind).append("abcrc_stat_ind=").append(abcrc_stat_ind).append("abhip_stat_ind=").append(abhip_stat_ind)
				.append("abort_stat_ind=").append(abort_stat_ind).append("abord_stat_ind=").append(abord_stat_ind).append("abobs_stat_ind=")
				.append(abobs_stat_ind).append("abiki_stat_ind=").append(abiki_stat_ind).append("abofs_stat_ind=").append(abofs_stat_ind)
				.append("abtax_stat_ind=").append(abtax_stat_ind).append("abtdp_stat_ind=").append(abtdp_stat_ind).append("abcfn_stat_ind=")
				.append(abcfn_stat_ind).append("abitd_stat_ind=").append(abitd_stat_ind).append("abbtx_stat_ind=").append(abbtx_stat_ind)
				.append("abbtd_stat_ind=").append(abbtd_stat_ind).append("abehi_stat_ind=").append(abehi_stat_ind).append("abhin_stat_ind=")
				.append(abhin_stat_ind).append("abohi_stat_ind=").append(abohi_stat_ind).append("abtxr_stat_ind=").append(abtxr_stat_ind)
				.append("abtxi_stat_ind=").append(abtxi_stat_ind).append("abbcn_stat_ind=")
				.append("abhbq_stat_ind=").append(abhbq_stat_ind).append("abhbq_stat_ind=")
				.append("abhbd_stat_ind=").append(abhbd_stat_ind).append("abhbd_stat_ind=")
				.append(abbcn_stat_ind).toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((abapd_stat_ind == null) ? 0 : abapd_stat_ind.trim().hashCode());
		result = (prime * result) + ((abaur_stat_ind == null) ? 0 : abaur_stat_ind.trim().hashCode());
		result = (prime * result) + ((abavd_stat_ind == null) ? 0 : abavd_stat_ind.trim().hashCode());
		result = (prime * result) + ((abbad_stat_ind == null) ? 0 : abbad_stat_ind.trim().hashCode());
		result = (prime * result) + ((abbat_stat_ind == null) ? 0 : abbat_stat_ind.trim().hashCode());
		result = (prime * result) + ((abbnr_stat_ind == null) ? 0 : abbnr_stat_ind.trim().hashCode());
		result = (prime * result) + ((abchs_stat_ind == null) ? 0 : abchs_stat_ind.trim().hashCode());
		result = (prime * result) + ((abcon_stat_ind == null) ? 0 : abcon_stat_ind.trim().hashCode());
		result = (prime * result) + ((abcpa_stat_ind == null) ? 0 : abcpa_stat_ind.trim().hashCode());
		result = (prime * result) + ((abcph_stat_ind == null) ? 0 : abcph_stat_ind.trim().hashCode());
		result = (prime * result) + ((abcra_stat_ind == null) ? 0 : abcra_stat_ind.trim().hashCode());
		result = (prime * result) + ((abcrc_stat_ind == null) ? 0 : abcrc_stat_ind.trim().hashCode());
		result = (prime * result) + ((abdcd_stat_ind == null) ? 0 : abdcd_stat_ind.trim().hashCode());
		result = (prime * result) + ((abddt_stat_ind == null) ? 0 : abddt_stat_ind.trim().hashCode());
		result = (prime * result) + ((abdfe_stat_ind == null) ? 0 : abdfe_stat_ind.trim().hashCode());
		result = (prime * result) + ((abdfg_stat_ind == null) ? 0 : abdfg_stat_ind.trim().hashCode());
		result = (prime * result) + ((abdis_stat_ind == null) ? 0 : abdis_stat_ind.trim().hashCode());
		result = (prime * result) + ((abdoc_stat_ind == null) ? 0 : abdoc_stat_ind.trim().hashCode());
		result = (prime * result) + ((abdsm_stat_ind == null) ? 0 : abdsm_stat_ind.trim().hashCode());
		result = (prime * result) + ((abdty_stat_ind == null) ? 0 : abdty_stat_ind.trim().hashCode());
		result = (prime * result) + ((abeca_stat_ind == null) ? 0 : abeca_stat_ind.trim().hashCode());
		result = (prime * result) + ((abedr_stat_ind == null) ? 0 : abedr_stat_ind.trim().hashCode());
		result = (prime * result) + ((abedt_stat_ind == null) ? 0 : abedt_stat_ind.trim().hashCode());
		result = (prime * result) + ((abefa_stat_ind == null) ? 0 : abefa_stat_ind.trim().hashCode());
		result = (prime * result) + ((abefd_stat_ind == null) ? 0 : abefd_stat_ind.trim().hashCode());
		result = (prime * result) + ((abesm_stat_ind == null) ? 0 : abesm_stat_ind.trim().hashCode());
		result = (prime * result) + ((abfas_stat_ind == null) ? 0 : abfas_stat_ind.trim().hashCode());
		result = (prime * result) + ((abfur_stat_ind == null) ? 0 : abfur_stat_ind.trim().hashCode());
		result = (prime * result) + ((abhca_stat_ind == null) ? 0 : abhca_stat_ind.trim().hashCode());
		result = (prime * result) + ((abhcd_stat_ind == null) ? 0 : abhcd_stat_ind.trim().hashCode());
		result = (prime * result) + ((abhdn_stat_ind == null) ? 0 : abhdn_stat_ind.trim().hashCode());
		result = (prime * result) + ((abhdr_stat_ind == null) ? 0 : abhdr_stat_ind.trim().hashCode());
		result = (prime * result) + ((abhel_stat_ind == null) ? 0 : abhel_stat_ind.trim().hashCode());
		result = (prime * result) + ((abheq_stat_ind == null) ? 0 : abheq_stat_ind.trim().hashCode());
		result = (prime * result) + ((abhes_stat_ind == null) ? 0 : abhes_stat_ind.trim().hashCode());
		result = (prime * result) + ((abhhq_stat_ind == null) ? 0 : abhhq_stat_ind.trim().hashCode());
		result = (prime * result) + ((abhhr_stat_ind == null) ? 0 : abhhr_stat_ind.trim().hashCode());
		result = (prime * result) + ((abhip_stat_ind == null) ? 0 : abhip_stat_ind.trim().hashCode());
		result = (prime * result) + ((abhis_stat_ind == null) ? 0 : abhis_stat_ind.trim().hashCode());
		result = (prime * result) + ((abhlt_stat_ind == null) ? 0 : abhlt_stat_ind.trim().hashCode());
		result = (prime * result) + ((abhmd_stat_ind == null) ? 0 : abhmd_stat_ind.trim().hashCode());
		result = (prime * result) + ((abhms_stat_ind == null) ? 0 : abhms_stat_ind.trim().hashCode());
		result = (prime * result) + ((abhng_stat_ind == null) ? 0 : abhng_stat_ind.trim().hashCode());
		result = (prime * result) + ((abhsc_stat_ind == null) ? 0 : abhsc_stat_ind.trim().hashCode());
		result = (prime * result) + ((abhsy_stat_ind == null) ? 0 : abhsy_stat_ind.trim().hashCode());
		result = (prime * result) + ((abhwa_stat_ind == null) ? 0 : abhwa_stat_ind.trim().hashCode());
		result = (prime * result) + ((abind_stat_ind == null) ? 0 : abind_stat_ind.trim().hashCode());
		result = (prime * result) + ((abipi_stat_ind == null) ? 0 : abipi_stat_ind.trim().hashCode());
		result = (prime * result) + ((abipq_stat_ind == null) ? 0 : abipq_stat_ind.trim().hashCode());
		result = (prime * result) + ((abjiq_stat_ind == null) ? 0 : abjiq_stat_ind.trim().hashCode());
		result = (prime * result) + ((abjis_stat_ind == null) ? 0 : abjis_stat_ind.trim().hashCode());
		result = (prime * result) + ((ablad_stat_ind == null) ? 0 : ablad_stat_ind.trim().hashCode());
		result = (prime * result) + ((ablaq_stat_ind == null) ? 0 : ablaq_stat_ind.trim().hashCode());
		result = (prime * result) + ((ablas_stat_ind == null) ? 0 : ablas_stat_ind.trim().hashCode());
		result = (prime * result) + ((ablat_stat_ind == null) ? 0 : ablat_stat_ind.trim().hashCode());
		result = (prime * result) + ((ablhi_stat_ind == null) ? 0 : ablhi_stat_ind.trim().hashCode());
		result = (prime * result) + ((ablid_stat_ind == null) ? 0 : ablid_stat_ind.trim().hashCode());
		result = (prime * result) + ((ablit_stat_ind == null) ? 0 : ablit_stat_ind.trim().hashCode());
		result = (prime * result) + ((abmah_stat_ind == null) ? 0 : abmah_stat_ind.trim().hashCode());
		result = (prime * result) + ((abmbd_stat_ind == null) ? 0 : abmbd_stat_ind.trim().hashCode());
		result = (prime * result) + ((abmdp_stat_ind == null) ? 0 : abmdp_stat_ind.trim().hashCode());
		result = (prime * result) + ((abmed_stat_ind == null) ? 0 : abmed_stat_ind.trim().hashCode());
		result = (prime * result) + ((abmet_stat_ind == null) ? 0 : abmet_stat_ind.trim().hashCode());
		result = (prime * result) + ((abnhm_stat_ind == null) ? 0 : abnhm_stat_ind.trim().hashCode());
		result = (prime * result) + ((abnsd_stat_ind == null) ? 0 : abnsd_stat_ind.trim().hashCode());
		result = (prime * result) + ((abnso_stat_ind == null) ? 0 : abnso_stat_ind.trim().hashCode());
		result = (prime * result) + ((aboaq_stat_ind == null) ? 0 : aboaq_stat_ind.trim().hashCode());
		result = (prime * result) + ((aboas_stat_ind == null) ? 0 : aboas_stat_ind.trim().hashCode());
		result = (prime * result) + ((abobq_stat_ind == null) ? 0 : abobq_stat_ind.trim().hashCode());
		result = (prime * result) + ((abobs_stat_ind == null) ? 0 : abobs_stat_ind.trim().hashCode());
		result = (prime * result) + ((aboeq_stat_ind == null) ? 0 : aboeq_stat_ind.trim().hashCode());
		result = (prime * result) + ((aboiq_stat_ind == null) ? 0 : aboiq_stat_ind.trim().hashCode());
		result = (prime * result) + ((abois_stat_ind == null) ? 0 : abois_stat_ind.trim().hashCode());
		result = (prime * result) + ((abord_stat_ind == null) ? 0 : abord_stat_ind.trim().hashCode());
		result = (prime * result) + ((abort_stat_ind == null) ? 0 : abort_stat_ind.trim().hashCode());
		result = (prime * result) + ((abpas_stat_ind == null) ? 0 : abpas_stat_ind.trim().hashCode());
		result = (prime * result) + ((abped_stat_ind == null) ? 0 : abped_stat_ind.trim().hashCode());
		result = (prime * result) + ((abphd_stat_ind == null) ? 0 : abphd_stat_ind.trim().hashCode());
		result = (prime * result) + ((abpng_stat_ind == null) ? 0 : abpng_stat_ind.trim().hashCode());
		result = (prime * result) + ((abppd_stat_ind == null) ? 0 : abppd_stat_ind.trim().hashCode());
		result = (prime * result) + ((abpps_stat_ind == null) ? 0 : abpps_stat_ind.trim().hashCode());
		result = (prime * result) + ((abprg_stat_ind == null) ? 0 : abprg_stat_ind.trim().hashCode());
		result = (prime * result) + ((abpri_stat_ind == null) ? 0 : abpri_stat_ind.trim().hashCode());
		result = (prime * result) + ((abpsq_stat_ind == null) ? 0 : abpsq_stat_ind.trim().hashCode());
		result = (prime * result) + ((abpth_stat_ind == null) ? 0 : abpth_stat_ind.trim().hashCode());
		result = (prime * result) + ((abrgi_stat_ind == null) ? 0 : abrgi_stat_ind.trim().hashCode());
		result = (prime * result) + ((abrgs_stat_ind == null) ? 0 : abrgs_stat_ind.trim().hashCode());
		result = (prime * result) + ((abrlv_stat_ind == null) ? 0 : abrlv_stat_ind.trim().hashCode());
		result = (prime * result) + ((abrpd_stat_ind == null) ? 0 : abrpd_stat_ind.trim().hashCode());
		result = (prime * result) + ((abrpt_stat_ind == null) ? 0 : abrpt_stat_ind.trim().hashCode());
		result = (prime * result) + ((absae_stat_ind == null) ? 0 : absae_stat_ind.trim().hashCode());
		result = (prime * result) + ((abscd_stat_ind == null) ? 0 : abscd_stat_ind.trim().hashCode());
		result = (prime * result) + ((absct_stat_ind == null) ? 0 : absct_stat_ind.trim().hashCode());
		result = (prime * result) + ((absed_stat_ind == null) ? 0 : absed_stat_ind.trim().hashCode());
		result = (prime * result) + ((absen_stat_ind == null) ? 0 : absen_stat_ind.trim().hashCode());
		result = (prime * result) + ((abshe_stat_ind == null) ? 0 : abshe_stat_ind.trim().hashCode());
		result = (prime * result) + ((abshs_stat_ind == null) ? 0 : abshs_stat_ind.trim().hashCode());
		result = (prime * result) + ((abspd_stat_ind == null) ? 0 : abspd_stat_ind.trim().hashCode());
		result = (prime * result) + ((absss_stat_ind == null) ? 0 : absss_stat_ind.trim().hashCode());
		result = (prime * result) + ((absta_stat_ind == null) ? 0 : absta_stat_ind.trim().hashCode());
		result = (prime * result) + ((abstd_stat_ind == null) ? 0 : abstd_stat_ind.trim().hashCode());
		result = (prime * result) + ((abuad_stat_ind == null) ? 0 : abuad_stat_ind.trim().hashCode());
		result = (prime * result) + ((abucd_stat_ind == null) ? 0 : abucd_stat_ind.trim().hashCode());
		result = (prime * result) + ((abuct_stat_ind == null) ? 0 : abuct_stat_ind.trim().hashCode());
		result = (prime * result) + ((abuid_stat_ind == null) ? 0 : abuid_stat_ind.trim().hashCode());
		result = (prime * result) + ((abuit_stat_ind == null) ? 0 : abuit_stat_ind.trim().hashCode());
		result = (prime * result) + ((abvad_stat_ind == null) ? 0 : abvad_stat_ind.trim().hashCode());
		result = (prime * result) + ((abvat_stat_ind == null) ? 0 : abvat_stat_ind.trim().hashCode());
		result = (prime * result) + ((abwre_stat_ind == null) ? 0 : abwre_stat_ind.trim().hashCode());
		result = (prime * result) + ((abiki_stat_ind == null) ? 0 : abiki_stat_ind.trim().hashCode());
		result = (prime * result) + ((abofs_stat_ind == null) ? 0 : abofs_stat_ind.trim().hashCode());
		result = (prime * result) + ((abtax_stat_ind == null) ? 0 : abtax_stat_ind.trim().hashCode());
		result = (prime * result) + ((abtdp_stat_ind == null) ? 0 : abtdp_stat_ind.trim().hashCode());
		result = (prime * result) + ((abitd_stat_ind == null) ? 0 : abitd_stat_ind.trim().hashCode());
		result = (prime * result) + ((abbtx_stat_ind == null) ? 0 : abbtx_stat_ind.trim().hashCode());
		result = (prime * result) + ((abbtd_stat_ind == null) ? 0 : abbtd_stat_ind.trim().hashCode());
		result = (prime * result) + ((abehi_stat_ind == null) ? 0 : abehi_stat_ind.trim().hashCode());
		result = (prime * result) + ((abhin_stat_ind == null) ? 0 : abhin_stat_ind.trim().hashCode());
		result = (prime * result) + ((abohi_stat_ind == null) ? 0 : abohi_stat_ind.trim().hashCode());
		result = (prime * result) + ((abtxr_stat_ind == null) ? 0 : abtxr_stat_ind.trim().hashCode());
		result = (prime * result) + ((abtxi_stat_ind == null) ? 0 : abtxi_stat_ind.trim().hashCode());
		result = (prime * result) + ((abcfn_stat_ind == null) ? 0 : abcfn_stat_ind.trim().hashCode());
		result = (prime * result) + ((abbcn_stat_ind == null) ? 0 : abbcn_stat_ind.trim().hashCode());
		result = (prime * result) + ((abhbq_stat_ind == null) ? 0 : abhbq_stat_ind.trim().hashCode());
		result = (prime * result) + ((abhbd_stat_ind == null) ? 0 : abhbd_stat_ind.trim().hashCode());
		result = (prime * result) + ((app_num == null) ? 0 : app_num.trim().hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final AFB_DRVR_Cargo other = (AFB_DRVR_Cargo) obj;
		if (abapd_stat_ind == null) {
			if (other.abapd_stat_ind != null) {
				return false;
			}
		} else if (!abapd_stat_ind.equals(other.abapd_stat_ind)) {
			return false;
		}
		if (abaur_stat_ind == null) {
			if (other.abaur_stat_ind != null) {
				return false;
			}
		} else if (!abaur_stat_ind.equals(other.abaur_stat_ind)) {
			return false;
		}
		if (abavd_stat_ind == null) {
			if (other.abavd_stat_ind != null) {
				return false;
			}
		} else if (!abavd_stat_ind.equals(other.abavd_stat_ind)) {
			return false;
		}
		if (abbad_stat_ind == null) {
			if (other.abbad_stat_ind != null) {
				return false;
			}
		} else if (!abbad_stat_ind.equals(other.abbad_stat_ind)) {
			return false;
		}
		if (abbat_stat_ind == null) {
			if (other.abbat_stat_ind != null) {
				return false;
			}
		} else if (!abbat_stat_ind.equals(other.abbat_stat_ind)) {
			return false;
		}
		if (abbnr_stat_ind == null) {
			if (other.abbnr_stat_ind != null) {
				return false;
			}
		} else if (!abbnr_stat_ind.equals(other.abbnr_stat_ind)) {
			return false;
		}
		if (abchs_stat_ind == null) {
			if (other.abchs_stat_ind != null) {
				return false;
			}
		} else if (!abchs_stat_ind.equals(other.abchs_stat_ind)) {
			return false;
		}
		if (abcon_stat_ind == null) {
			if (other.abcon_stat_ind != null) {
				return false;
			}
		} else if (!abcon_stat_ind.equals(other.abcon_stat_ind)) {
			return false;
		}
		if (abcpa_stat_ind == null) {
			if (other.abcpa_stat_ind != null) {
				return false;
			}
		} else if (!abcpa_stat_ind.equals(other.abcpa_stat_ind)) {
			return false;
		}
		if (abcph_stat_ind == null) {
			if (other.abcph_stat_ind != null) {
				return false;
			}
		} else if (!abcph_stat_ind.equals(other.abcph_stat_ind)) {
			return false;
		}
		if (abcra_stat_ind == null) {
			if (other.abcra_stat_ind != null) {
				return false;
			}
		} else if (!abcra_stat_ind.equals(other.abcra_stat_ind)) {
			return false;
		}
		if (abcrc_stat_ind == null) {
			if (other.abcrc_stat_ind != null) {
				return false;
			}
		} else if (!abcrc_stat_ind.equals(other.abcrc_stat_ind)) {
			return false;
		}
		if (abdcd_stat_ind == null) {
			if (other.abdcd_stat_ind != null) {
				return false;
			}
		} else if (!abdcd_stat_ind.equals(other.abdcd_stat_ind)) {
			return false;
		}
		if (abddt_stat_ind == null) {
			if (other.abddt_stat_ind != null) {
				return false;
			}
		} else if (!abddt_stat_ind.equals(other.abddt_stat_ind)) {
			return false;
		}
		if (abdfe_stat_ind == null) {
			if (other.abdfe_stat_ind != null) {
				return false;
			}
		} else if (!abdfe_stat_ind.equals(other.abdfe_stat_ind)) {
			return false;
		}
		if (abdfg_stat_ind == null) {
			if (other.abdfg_stat_ind != null) {
				return false;
			}
		} else if (!abdfg_stat_ind.equals(other.abdfg_stat_ind)) {
			return false;
		}
		if (abdis_stat_ind == null) {
			if (other.abdis_stat_ind != null) {
				return false;
			}
		} else if (!abdis_stat_ind.equals(other.abdis_stat_ind)) {
			return false;
		}
		if (abdoc_stat_ind == null) {
			if (other.abdoc_stat_ind != null) {
				return false;
			}
		} else if (!abdoc_stat_ind.equals(other.abdoc_stat_ind)) {
			return false;
		}
		if (abdsm_stat_ind == null) {
			if (other.abdsm_stat_ind != null) {
				return false;
			}
		} else if (!abdsm_stat_ind.equals(other.abdsm_stat_ind)) {
			return false;
		}
		if (abdty_stat_ind == null) {
			if (other.abdty_stat_ind != null) {
				return false;
			}
		} else if (!abdty_stat_ind.equals(other.abdty_stat_ind)) {
			return false;
		}
		if (abeca_stat_ind == null) {
			if (other.abeca_stat_ind != null) {
				return false;
			}
		} else if (!abeca_stat_ind.equals(other.abeca_stat_ind)) {
			return false;
		}
		if (abedr_stat_ind == null) {
			if (other.abedr_stat_ind != null) {
				return false;
			}
		} else if (!abedr_stat_ind.equals(other.abedr_stat_ind)) {
			return false;
		}
		if (abedt_stat_ind == null) {
			if (other.abedt_stat_ind != null) {
				return false;
			}
		} else if (!abedt_stat_ind.equals(other.abedt_stat_ind)) {
			return false;
		}
		if (abefa_stat_ind == null) {
			if (other.abefa_stat_ind != null) {
				return false;
			}
		} else if (!abefa_stat_ind.equals(other.abefa_stat_ind)) {
			return false;
		}
		if (abefd_stat_ind == null) {
			if (other.abefd_stat_ind != null) {
				return false;
			}
		} else if (!abefd_stat_ind.equals(other.abefd_stat_ind)) {
			return false;
		}
		if (abesm_stat_ind == null) {
			if (other.abesm_stat_ind != null) {
				return false;
			}
		} else if (!abesm_stat_ind.equals(other.abesm_stat_ind)) {
			return false;
		}
		if (abfas_stat_ind == null) {
			if (other.abfas_stat_ind != null) {
				return false;
			}
		} else if (!abfas_stat_ind.equals(other.abfas_stat_ind)) {
			return false;
		}
		if (abfur_stat_ind == null) {
			if (other.abfur_stat_ind != null) {
				return false;
			}
		} else if (!abfur_stat_ind.equals(other.abfur_stat_ind)) {
			return false;
		}
		if (abhca_stat_ind == null) {
			if (other.abhca_stat_ind != null) {
				return false;
			}
		} else if (!abhca_stat_ind.equals(other.abhca_stat_ind)) {
			return false;
		}
		if (abhcd_stat_ind == null) {
			if (other.abhcd_stat_ind != null) {
				return false;
			}
		} else if (!abhcd_stat_ind.equals(other.abhcd_stat_ind)) {
			return false;
		}
		if (abhdn_stat_ind == null) {
			if (other.abhdn_stat_ind != null) {
				return false;
			}
		} else if (!abhdn_stat_ind.equals(other.abhdn_stat_ind)) {
			return false;
		}
		if (abhdr_stat_ind == null) {
			if (other.abhdr_stat_ind != null) {
				return false;
			}
		} else if (!abhdr_stat_ind.equals(other.abhdr_stat_ind)) {
			return false;
		}
		if (abhel_stat_ind == null) {
			if (other.abhel_stat_ind != null) {
				return false;
			}
		} else if (!abhel_stat_ind.equals(other.abhel_stat_ind)) {
			return false;
		}
		if (abheq_stat_ind == null) {
			if (other.abheq_stat_ind != null) {
				return false;
			}
		} else if (!abheq_stat_ind.equals(other.abheq_stat_ind)) {
			return false;
		}
		if (abhes_stat_ind == null) {
			if (other.abhes_stat_ind != null) {
				return false;
			}
		} else if (!abhes_stat_ind.equals(other.abhes_stat_ind)) {
			return false;
		}
		if (abhhq_stat_ind == null) {
			if (other.abhhq_stat_ind != null) {
				return false;
			}
		} else if (!abhhq_stat_ind.equals(other.abhhq_stat_ind)) {
			return false;
		}
		if (abhhr_stat_ind == null) {
			if (other.abhhr_stat_ind != null) {
				return false;
			}
		} else if (!abhhr_stat_ind.equals(other.abhhr_stat_ind)) {
			return false;
		}
		if (abhip_stat_ind == null) {
			if (other.abhip_stat_ind != null) {
				return false;
			}
		} else if (!abhip_stat_ind.equals(other.abhip_stat_ind)) {
			return false;
		}
		if (abhis_stat_ind == null) {
			if (other.abhis_stat_ind != null) {
				return false;
			}
		} else if (!abhis_stat_ind.equals(other.abhis_stat_ind)) {
			return false;
		}
		if (abhlt_stat_ind == null) {
			if (other.abhlt_stat_ind != null) {
				return false;
			}
		} else if (!abhlt_stat_ind.equals(other.abhlt_stat_ind)) {
			return false;
		}
		if (abhmd_stat_ind == null) {
			if (other.abhmd_stat_ind != null) {
				return false;
			}
		} else if (!abhmd_stat_ind.equals(other.abhmd_stat_ind)) {
			return false;
		}
		if (abhms_stat_ind == null) {
			if (other.abhms_stat_ind != null) {
				return false;
			}
		} else if (!abhms_stat_ind.equals(other.abhms_stat_ind)) {
			return false;
		}
		if (abhng_stat_ind == null) {
			if (other.abhng_stat_ind != null) {
				return false;
			}
		} else if (!abhng_stat_ind.equals(other.abhng_stat_ind)) {
			return false;
		}
		if (abhsc_stat_ind == null) {
			if (other.abhsc_stat_ind != null) {
				return false;
			}
		} else if (!abhsc_stat_ind.equals(other.abhsc_stat_ind)) {
			return false;
		}
		if (abhsy_stat_ind == null) {
			if (other.abhsy_stat_ind != null) {
				return false;
			}
		} else if (!abhsy_stat_ind.equals(other.abhsy_stat_ind)) {
			return false;
		}
		if (abhwa_stat_ind == null) {
			if (other.abhwa_stat_ind != null) {
				return false;
			}
		} else if (!abhwa_stat_ind.equals(other.abhwa_stat_ind)) {
			return false;
		}
		if (abind_stat_ind == null) {
			if (other.abind_stat_ind != null) {
				return false;
			}
		} else if (!abind_stat_ind.equals(other.abind_stat_ind)) {
			return false;
		}
		if (abipi_stat_ind == null) {
			if (other.abipi_stat_ind != null) {
				return false;
			}
		} else if (!abipi_stat_ind.equals(other.abipi_stat_ind)) {
			return false;
		}
		if (abipq_stat_ind == null) {
			if (other.abipq_stat_ind != null) {
				return false;
			}
		} else if (!abipq_stat_ind.equals(other.abipq_stat_ind)) {
			return false;
		}
		if (abjiq_stat_ind == null) {
			if (other.abjiq_stat_ind != null) {
				return false;
			}
		} else if (!abjiq_stat_ind.equals(other.abjiq_stat_ind)) {
			return false;
		}
		if (abjis_stat_ind == null) {
			if (other.abjis_stat_ind != null) {
				return false;
			}
		} else if (!abjis_stat_ind.equals(other.abjis_stat_ind)) {
			return false;
		}
		if (ablad_stat_ind == null) {
			if (other.ablad_stat_ind != null) {
				return false;
			}
		} else if (!ablad_stat_ind.equals(other.ablad_stat_ind)) {
			return false;
		}
		if (ablaq_stat_ind == null) {
			if (other.ablaq_stat_ind != null) {
				return false;
			}
		} else if (!ablaq_stat_ind.equals(other.ablaq_stat_ind)) {
			return false;
		}
		if (ablas_stat_ind == null) {
			if (other.ablas_stat_ind != null) {
				return false;
			}
		} else if (!ablas_stat_ind.equals(other.ablas_stat_ind)) {
			return false;
		}
		if (ablat_stat_ind == null) {
			if (other.ablat_stat_ind != null) {
				return false;
			}
		} else if (!ablat_stat_ind.equals(other.ablat_stat_ind)) {
			return false;
		}
		if (ablhi_stat_ind == null) {
			if (other.ablhi_stat_ind != null) {
				return false;
			}
		} else if (!ablhi_stat_ind.equals(other.ablhi_stat_ind)) {
			return false;
		}
		if (ablid_stat_ind == null) {
			if (other.ablid_stat_ind != null) {
				return false;
			}
		} else if (!ablid_stat_ind.equals(other.ablid_stat_ind)) {
			return false;
		}
		if (ablit_stat_ind == null) {
			if (other.ablit_stat_ind != null) {
				return false;
			}
		} else if (!ablit_stat_ind.equals(other.ablit_stat_ind)) {
			return false;
		}
		if (abmah_stat_ind == null) {
			if (other.abmah_stat_ind != null) {
				return false;
			}
		} else if (!abmah_stat_ind.equals(other.abmah_stat_ind)) {
			return false;
		}
		if (abmbd_stat_ind == null) {
			if (other.abmbd_stat_ind != null) {
				return false;
			}
		} else if (!abmbd_stat_ind.equals(other.abmbd_stat_ind)) {
			return false;
		}
		if (abmdp_stat_ind == null) {
			if (other.abmdp_stat_ind != null) {
				return false;
			}
		} else if (!abmdp_stat_ind.equals(other.abmdp_stat_ind)) {
			return false;
		}
		if (abmed_stat_ind == null) {
			if (other.abmed_stat_ind != null) {
				return false;
			}
		} else if (!abmed_stat_ind.equals(other.abmed_stat_ind)) {
			return false;
		}
		if (abmet_stat_ind == null) {
			if (other.abmet_stat_ind != null) {
				return false;
			}
		} else if (!abmet_stat_ind.equals(other.abmet_stat_ind)) {
			return false;
		}
		if (abnhm_stat_ind == null) {
			if (other.abnhm_stat_ind != null) {
				return false;
			}
		} else if (!abnhm_stat_ind.equals(other.abnhm_stat_ind)) {
			return false;
		}
		if (abnsd_stat_ind == null) {
			if (other.abnsd_stat_ind != null) {
				return false;
			}
		} else if (!abnsd_stat_ind.equals(other.abnsd_stat_ind)) {
			return false;
		}
		if (abnso_stat_ind == null) {
			if (other.abnso_stat_ind != null) {
				return false;
			}
		} else if (!abnso_stat_ind.equals(other.abnso_stat_ind)) {
			return false;
		}
		if (aboaq_stat_ind == null) {
			if (other.aboaq_stat_ind != null) {
				return false;
			}
		} else if (!aboaq_stat_ind.equals(other.aboaq_stat_ind)) {
			return false;
		}
		if (aboas_stat_ind == null) {
			if (other.aboas_stat_ind != null) {
				return false;
			}
		} else if (!aboas_stat_ind.equals(other.aboas_stat_ind)) {
			return false;
		}
		if (abobq_stat_ind == null) {
			if (other.abobq_stat_ind != null) {
				return false;
			}
		} else if (!abobq_stat_ind.equals(other.abobq_stat_ind)) {
			return false;
		}
		if (abobs_stat_ind == null) {
			if (other.abobs_stat_ind != null) {
				return false;
			}
		} else if (!abobs_stat_ind.equals(other.abobs_stat_ind)) {
			return false;
		}
		if (aboeq_stat_ind == null) {
			if (other.aboeq_stat_ind != null) {
				return false;
			}
		} else if (!aboeq_stat_ind.equals(other.aboeq_stat_ind)) {
			return false;
		}
		if (aboiq_stat_ind == null) {
			if (other.aboiq_stat_ind != null) {
				return false;
			}
		} else if (!aboiq_stat_ind.equals(other.aboiq_stat_ind)) {
			return false;
		}
		if (abois_stat_ind == null) {
			if (other.abois_stat_ind != null) {
				return false;
			}
		} else if (!abois_stat_ind.equals(other.abois_stat_ind)) {
			return false;
		}
		if (abord_stat_ind == null) {
			if (other.abord_stat_ind != null) {
				return false;
			}
		} else if (!abord_stat_ind.equals(other.abord_stat_ind)) {
			return false;
		}
		if (abort_stat_ind == null) {
			if (other.abort_stat_ind != null) {
				return false;
			}
		} else if (!abort_stat_ind.equals(other.abort_stat_ind)) {
			return false;
		}
		if (abpas_stat_ind == null) {
			if (other.abpas_stat_ind != null) {
				return false;
			}
		} else if (!abpas_stat_ind.equals(other.abpas_stat_ind)) {
			return false;
		}
		if (abped_stat_ind == null) {
			if (other.abped_stat_ind != null) {
				return false;
			}
		} else if (!abped_stat_ind.equals(other.abped_stat_ind)) {
			return false;
		}
		if (abphd_stat_ind == null) {
			if (other.abphd_stat_ind != null) {
				return false;
			}
		} else if (!abphd_stat_ind.equals(other.abphd_stat_ind)) {
			return false;
		}
		if (abpng_stat_ind == null) {
			if (other.abpng_stat_ind != null) {
				return false;
			}
		} else if (!abpng_stat_ind.equals(other.abpng_stat_ind)) {
			return false;
		}
		if (abppd_stat_ind == null) {
			if (other.abppd_stat_ind != null) {
				return false;
			}
		} else if (!abppd_stat_ind.equals(other.abppd_stat_ind)) {
			return false;
		}
		if (abpps_stat_ind == null) {
			if (other.abpps_stat_ind != null) {
				return false;
			}
		} else if (!abpps_stat_ind.equals(other.abpps_stat_ind)) {
			return false;
		}
		if (abprg_stat_ind == null) {
			if (other.abprg_stat_ind != null) {
				return false;
			}
		} else if (!abprg_stat_ind.equals(other.abprg_stat_ind)) {
			return false;
		}
		if (abpri_stat_ind == null) {
			if (other.abpri_stat_ind != null) {
				return false;
			}
		} else if (!abpri_stat_ind.equals(other.abpri_stat_ind)) {
			return false;
		}
		if (abpsq_stat_ind == null) {
			if (other.abpsq_stat_ind != null) {
				return false;
			}
		} else if (!abpsq_stat_ind.equals(other.abpsq_stat_ind)) {
			return false;
		}
		if (abpth_stat_ind == null) {
			if (other.abpth_stat_ind != null) {
				return false;
			}
		} else if (!abpth_stat_ind.equals(other.abpth_stat_ind)) {
			return false;
		}
		if (abrgi_stat_ind == null) {
			if (other.abrgi_stat_ind != null) {
				return false;
			}
		} else if (!abrgi_stat_ind.equals(other.abrgi_stat_ind)) {
			return false;
		}
		if (abrgs_stat_ind == null) {
			if (other.abrgs_stat_ind != null) {
				return false;
			}
		} else if (!abrgs_stat_ind.equals(other.abrgs_stat_ind)) {
			return false;
		}
		if (abrlv_stat_ind == null) {
			if (other.abrlv_stat_ind != null) {
				return false;
			}
		} else if (!abrlv_stat_ind.equals(other.abrlv_stat_ind)) {
			return false;
		}
		if (abrpd_stat_ind == null) {
			if (other.abrpd_stat_ind != null) {
				return false;
			}
		} else if (!abrpd_stat_ind.equals(other.abrpd_stat_ind)) {
			return false;
		}
		if (abrpt_stat_ind == null) {
			if (other.abrpt_stat_ind != null) {
				return false;
			}
		} else if (!abrpt_stat_ind.equals(other.abrpt_stat_ind)) {
			return false;
		}
		if (absae_stat_ind == null) {
			if (other.absae_stat_ind != null) {
				return false;
			}
		} else if (!absae_stat_ind.equals(other.absae_stat_ind)) {
			return false;
		}
		if (abscd_stat_ind == null) {
			if (other.abscd_stat_ind != null) {
				return false;
			}
		} else if (!abscd_stat_ind.equals(other.abscd_stat_ind)) {
			return false;
		}
		if (absct_stat_ind == null) {
			if (other.absct_stat_ind != null) {
				return false;
			}
		} else if (!absct_stat_ind.equals(other.absct_stat_ind)) {
			return false;
		}
		if (absed_stat_ind == null) {
			if (other.absed_stat_ind != null) {
				return false;
			}
		} else if (!absed_stat_ind.equals(other.absed_stat_ind)) {
			return false;
		}
		if (absen_stat_ind == null) {
			if (other.absen_stat_ind != null) {
				return false;
			}
		} else if (!absen_stat_ind.equals(other.absen_stat_ind)) {
			return false;
		}
		if (abshe_stat_ind == null) {
			if (other.abshe_stat_ind != null) {
				return false;
			}
		} else if (!abshe_stat_ind.equals(other.abshe_stat_ind)) {
			return false;
		}
		if (abshs_stat_ind == null) {
			if (other.abshs_stat_ind != null) {
				return false;
			}
		} else if (!abshs_stat_ind.equals(other.abshs_stat_ind)) {
			return false;
		}
		if (abspd_stat_ind == null) {
			if (other.abspd_stat_ind != null) {
				return false;
			}
		} else if (!abspd_stat_ind.equals(other.abspd_stat_ind)) {
			return false;
		}
		if (absss_stat_ind == null) {
			if (other.absss_stat_ind != null) {
				return false;
			}
		} else if (!absss_stat_ind.equals(other.absss_stat_ind)) {
			return false;
		}
		if (absta_stat_ind == null) {
			if (other.absta_stat_ind != null) {
				return false;
			}
		} else if (!absta_stat_ind.equals(other.absta_stat_ind)) {
			return false;
		}
		if (abstd_stat_ind == null) {
			if (other.abstd_stat_ind != null) {
				return false;
			}
		} else if (!abstd_stat_ind.equals(other.abstd_stat_ind)) {
			return false;
		}
		if (abuad_stat_ind == null) {
			if (other.abuad_stat_ind != null) {
				return false;
			}
		} else if (!abuad_stat_ind.equals(other.abuad_stat_ind)) {
			return false;
		}
		if (abucd_stat_ind == null) {
			if (other.abucd_stat_ind != null) {
				return false;
			}
		} else if (!abucd_stat_ind.equals(other.abucd_stat_ind)) {
			return false;
		}
		if (abuct_stat_ind == null) {
			if (other.abuct_stat_ind != null) {
				return false;
			}
		} else if (!abuct_stat_ind.equals(other.abuct_stat_ind)) {
			return false;
		}
		if (abuid_stat_ind == null) {
			if (other.abuid_stat_ind != null) {
				return false;
			}
		} else if (!abuid_stat_ind.equals(other.abuid_stat_ind)) {
			return false;
		}
		if (abuit_stat_ind == null) {
			if (other.abuit_stat_ind != null) {
				return false;
			}
		} else if (!abuit_stat_ind.equals(other.abuit_stat_ind)) {
			return false;
		}
		if (abvad_stat_ind == null) {
			if (other.abvad_stat_ind != null) {
				return false;
			}
		} else if (!abvad_stat_ind.equals(other.abvad_stat_ind)) {
			return false;
		}
		if (abvat_stat_ind == null) {
			if (other.abvat_stat_ind != null) {
				return false;
			}
		} else if (!abvat_stat_ind.equals(other.abvat_stat_ind)) {
			return false;
		}
		if (abwre_stat_ind == null) {
			if (other.abwre_stat_ind != null) {
				return false;
			}
		} else if (!abwre_stat_ind.equals(other.abwre_stat_ind)) {
			return false;
		}
		if (abiki_stat_ind == null) {
			if (other.abiki_stat_ind != null) {
				return false;
			}
		} else if (!abiki_stat_ind.equals(other.abiki_stat_ind)) {
			return false;
		}
		if (abofs_stat_ind == null) {
			if (other.abofs_stat_ind != null) {
				return false;
			}
		} else if (!abofs_stat_ind.equals(other.abofs_stat_ind)) {
			return false;
		}
		if (abtax_stat_ind == null) {
			if (other.abtax_stat_ind != null) {
				return false;
			}
		} else if (!abtax_stat_ind.equals(other.abtax_stat_ind)) {
			return false;
		}
		if (abtdp_stat_ind == null) {
			if (other.abtdp_stat_ind != null) {
				return false;
			}
		} else if (!abtdp_stat_ind.equals(other.abtdp_stat_ind)) {
			return false;
		}
		if (app_num == null) {
			if (other.app_num != null) {
				return false;
			}
		} else if (!app_num.equals(other.app_num)) {
			return false;
		}
		if (abitd_stat_ind == null) {
			if (other.abitd_stat_ind != null) {
				return false;
			}
		} else if (!abitd_stat_ind.equals(other.abitd_stat_ind)) {
			return false;
		}
		if (abbtx_stat_ind == null) {
			if (other.abbtx_stat_ind != null) {
				return false;
			}
		} else if (!abbtx_stat_ind.equals(other.abbtx_stat_ind)) {
			return false;
		}
		if (abbtd_stat_ind == null) {
			if (other.abbtd_stat_ind != null) {
				return false;
			}
		} else if (!abbtd_stat_ind.equals(other.abbtd_stat_ind)) {
			return false;
		}
		if (abehi_stat_ind == null) {
			if (other.abehi_stat_ind != null) {
				return false;
			}
		} else if (!abehi_stat_ind.equals(other.abehi_stat_ind)) {
			return false;
		}
		if (abhin_stat_ind == null) {
			if (other.abhin_stat_ind != null) {
				return false;
			}
		} else if (!abhin_stat_ind.equals(other.abhin_stat_ind)) {
			return false;
		}
		if (abohi_stat_ind == null) {
			if (other.abohi_stat_ind != null) {
				return false;
			}
		} else if (!abohi_stat_ind.equals(other.abohi_stat_ind)) {
			return false;
		}
		if (abtxr_stat_ind == null) {
			if (other.abtxr_stat_ind != null) {
				return false;
			}
		} else if (!abtxr_stat_ind.equals(other.abtxr_stat_ind)) {
			return false;
		}
		if (abtxi_stat_ind == null) {
			if (other.abtxi_stat_ind != null) {
				return false;
			}
		} else if (!abtxi_stat_ind.equals(other.abtxi_stat_ind)) {
			return false;
		}
		if (abcfn_stat_ind == null) {
			if (other.abcfn_stat_ind != null) {
				return false;
			}
		} else if (!abcfn_stat_ind.equals(other.abcfn_stat_ind)) {
			return false;
		}
		if (abbcn_stat_ind == null) {
			if (other.abbcn_stat_ind != null) {
				return false;
			}
		} else if (!abbcn_stat_ind.equals(other.abbcn_stat_ind)) {
			return false;
		}
		if (abhbq_stat_ind == null) {
			if (other.abhbq_stat_ind != null) {
				return false;
			}
		} else if (!abhbq_stat_ind.equals(other.abhbq_stat_ind)) {
			return false;
		}
		if (abhbd_stat_ind == null) {
			if (other.abhbd_stat_ind != null) {
				return false;
			}
		} else if (!abhbd_stat_ind.equals(other.abhbd_stat_ind)) {
			return false;
		}
		return true;
	}

	/**
	 * returns the PrimaryKey object.
	 */
	@Override
	public IPrimaryKey getPrimaryKey() {
		final AFB_DRVR_PrimaryKey key = new AFB_DRVR_PrimaryKey();
		key.setApp_num(getApp_num());
		return key;
	}

	/**
	 * compares the given cargo with this cargo and returns the changed
	 * attribute-value Map.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map compareAttributes(final AFB_DRVR_Cargo aCargo) {
		final Map changedAttributeValue = new HashMap();
		if (!((aCargo.getApp_num() == null) && (app_num == null)) && !((aCargo.getApp_num() != null) && aCargo.getApp_num().equals(app_num))) {
			changedAttributeValue.put("app_num", aCargo.getApp_num());
		}
		if (!((aCargo.getAbapd_stat_ind() == null) && (abapd_stat_ind == null))
				&& !((aCargo.getAbapd_stat_ind() != null) && aCargo.getAbapd_stat_ind().equals(abapd_stat_ind))) {
			changedAttributeValue.put("abapd_stat_ind", aCargo.getAbapd_stat_ind());
		}
		if (!((aCargo.getAbbnr_stat_ind() == null) && (abbnr_stat_ind == null))
				&& !((aCargo.getAbbnr_stat_ind() != null) && aCargo.getAbbnr_stat_ind().equals(abbnr_stat_ind))) {
			changedAttributeValue.put("abbnr_stat_ind", aCargo.getAbbnr_stat_ind());
		}
		if (!((aCargo.getAbdcd_stat_ind() == null) && (abdcd_stat_ind == null))
				&& !((aCargo.getAbdcd_stat_ind() != null) && aCargo.getAbdcd_stat_ind().equals(abdcd_stat_ind))) {
			changedAttributeValue.put("abdcd_stat_ind", aCargo.getAbdcd_stat_ind());
		}
		if (!((aCargo.getAbedt_stat_ind() == null) && (abedt_stat_ind == null))
				&& !((aCargo.getAbedt_stat_ind() != null) && aCargo.getAbedt_stat_ind().equals(abedt_stat_ind))) {
			changedAttributeValue.put("abedt_stat_ind", aCargo.getAbedt_stat_ind());
		}
		if (!((aCargo.getAbefd_stat_ind() == null) && (abefd_stat_ind == null))
				&& !((aCargo.getAbefd_stat_ind() != null) && aCargo.getAbefd_stat_ind().equals(abefd_stat_ind))) {
			changedAttributeValue.put("abefd_stat_ind", aCargo.getAbefd_stat_ind());
		}
		if (!((aCargo.getAbesm_stat_ind() == null) && (abesm_stat_ind == null))
				&& !((aCargo.getAbesm_stat_ind() != null) && aCargo.getAbesm_stat_ind().equals(abesm_stat_ind))) {
			changedAttributeValue.put("abesm_stat_ind", aCargo.getAbesm_stat_ind());
		}
		if (!((aCargo.getAbfas_stat_ind() == null) && (abfas_stat_ind == null))
				&& !((aCargo.getAbfas_stat_ind() != null) && aCargo.getAbfas_stat_ind().equals(abfas_stat_ind))) {
			changedAttributeValue.put("abfas_stat_ind", aCargo.getAbfas_stat_ind());
		}
		if (!((aCargo.getAbheq_stat_ind() == null) && (abheq_stat_ind == null))
				&& !((aCargo.getAbheq_stat_ind() != null) && aCargo.getAbheq_stat_ind().equals(abheq_stat_ind))) {
			changedAttributeValue.put("abheq_stat_ind", aCargo.getAbheq_stat_ind());
		}
		if (!((aCargo.getAbhes_stat_ind() == null) && (abhes_stat_ind == null))
				&& !((aCargo.getAbhes_stat_ind() != null) && aCargo.getAbhes_stat_ind().equals(abhes_stat_ind))) {
			changedAttributeValue.put("abhes_stat_ind", aCargo.getAbhes_stat_ind());
		}
		if (!((aCargo.getAbhhq_stat_ind() == null) && (abhhq_stat_ind == null))
				&& !((aCargo.getAbhhq_stat_ind() != null) && aCargo.getAbhhq_stat_ind().equals(abhhq_stat_ind))) {
			changedAttributeValue.put("abhhq_stat_ind", aCargo.getAbhhq_stat_ind());
		}
		if (!((aCargo.getAbhhr_stat_ind() == null) && (abhhr_stat_ind == null))
				&& !((aCargo.getAbhhr_stat_ind() != null) && aCargo.getAbhhr_stat_ind().equals(abhhr_stat_ind))) {
			changedAttributeValue.put("abhhr_stat_ind", aCargo.getAbhhr_stat_ind());
		}
		if (!((aCargo.getAbhis_stat_ind() == null) && (abhis_stat_ind == null))
				&& !((aCargo.getAbhis_stat_ind() != null) && aCargo.getAbhis_stat_ind().equals(abhis_stat_ind))) {
			changedAttributeValue.put("abhis_stat_ind", aCargo.getAbhis_stat_ind());
		}
		if (!((aCargo.getAbhmd_stat_ind() == null) && (abhmd_stat_ind == null))
				&& !((aCargo.getAbhmd_stat_ind() != null) && aCargo.getAbhmd_stat_ind().equals(abhmd_stat_ind))) {
			changedAttributeValue.put("abhmd_stat_ind", aCargo.getAbhmd_stat_ind());
		}
		if (!((aCargo.getAbhms_stat_ind() == null) && (abhms_stat_ind == null))
				&& !((aCargo.getAbhms_stat_ind() != null) && aCargo.getAbhms_stat_ind().equals(abhms_stat_ind))) {
			changedAttributeValue.put("abhms_stat_ind", aCargo.getAbhms_stat_ind());
		}
		if (!((aCargo.getAbjiq_stat_ind() == null) && (abjiq_stat_ind == null))
				&& !((aCargo.getAbjiq_stat_ind() != null) && aCargo.getAbjiq_stat_ind().equals(abjiq_stat_ind))) {
			changedAttributeValue.put("abjiq_stat_ind", aCargo.getAbjiq_stat_ind());
		}
		if (!((aCargo.getAbjis_stat_ind() == null) && (abjis_stat_ind == null))
				&& !((aCargo.getAbjis_stat_ind() != null) && aCargo.getAbjis_stat_ind().equals(abjis_stat_ind))) {
			changedAttributeValue.put("abjis_stat_ind", aCargo.getAbjis_stat_ind());
		}
		if (!((aCargo.getAbmed_stat_ind() == null) && (abmed_stat_ind == null))
				&& !((aCargo.getAbmed_stat_ind() != null) && aCargo.getAbmed_stat_ind().equals(abmed_stat_ind))) {
			changedAttributeValue.put("abmed_stat_ind", aCargo.getAbmed_stat_ind());
		}
		if (!((aCargo.getAbnsd_stat_ind() == null) && (abnsd_stat_ind == null))
				&& !((aCargo.getAbnsd_stat_ind() != null) && aCargo.getAbnsd_stat_ind().equals(abnsd_stat_ind))) {
			changedAttributeValue.put("abnsd_stat_ind", aCargo.getAbnsd_stat_ind());
		}
		if (!((aCargo.getAbnso_stat_ind() == null) && (abnso_stat_ind == null))
				&& !((aCargo.getAbnso_stat_ind() != null) && aCargo.getAbnso_stat_ind().equals(abnso_stat_ind))) {
			changedAttributeValue.put("abnso_stat_ind", aCargo.getAbnso_stat_ind());
		}
		if (!((aCargo.getAboeq_stat_ind() == null) && (aboeq_stat_ind == null))
				&& !((aCargo.getAboeq_stat_ind() != null) && aCargo.getAboeq_stat_ind().equals(aboeq_stat_ind))) {
			changedAttributeValue.put("aboeq_stat_ind", aCargo.getAboeq_stat_ind());
		}
		if (!((aCargo.getAboiq_stat_ind() == null) && (aboiq_stat_ind == null))
				&& !((aCargo.getAboiq_stat_ind() != null) && aCargo.getAboiq_stat_ind().equals(aboiq_stat_ind))) {
			changedAttributeValue.put("aboiq_stat_ind", aCargo.getAboiq_stat_ind());
		}
		if (!((aCargo.getAbois_stat_ind() == null) && (abois_stat_ind == null))
				&& !((aCargo.getAbois_stat_ind() != null) && aCargo.getAbois_stat_ind().equals(abois_stat_ind))) {
			changedAttributeValue.put("abois_stat_ind", aCargo.getAbois_stat_ind());
		}
		if (!((aCargo.getAbpas_stat_ind() == null) && (abpas_stat_ind == null))
				&& !((aCargo.getAbpas_stat_ind() != null) && aCargo.getAbpas_stat_ind().equals(abpas_stat_ind))) {
			changedAttributeValue.put("abpas_stat_ind", aCargo.getAbpas_stat_ind());
		}
		if (!((aCargo.getAbpps_stat_ind() == null) && (abpps_stat_ind == null))
				&& !((aCargo.getAbpps_stat_ind() != null) && aCargo.getAbpps_stat_ind().equals(abpps_stat_ind))) {
			changedAttributeValue.put("abpps_stat_ind", aCargo.getAbpps_stat_ind());
		}
		if (!((aCargo.getAbprg_stat_ind() == null) && (abprg_stat_ind == null))
				&& !((aCargo.getAbprg_stat_ind() != null) && aCargo.getAbprg_stat_ind().equals(abprg_stat_ind))) {
			changedAttributeValue.put("abprg_stat_ind", aCargo.getAbprg_stat_ind());
		}
		if (!((aCargo.getAbpri_stat_ind() == null) && (abpri_stat_ind == null))
				&& !((aCargo.getAbpri_stat_ind() != null) && aCargo.getAbpri_stat_ind().equals(abpri_stat_ind))) {
			changedAttributeValue.put("abpri_stat_ind", aCargo.getAbpri_stat_ind());
		}
		if (!((aCargo.getAbpsq_stat_ind() == null) && (abpsq_stat_ind == null))
				&& !((aCargo.getAbpsq_stat_ind() != null) && aCargo.getAbpsq_stat_ind().equals(abpsq_stat_ind))) {
			changedAttributeValue.put("abpsq_stat_ind", aCargo.getAbpsq_stat_ind());
		}
		if (!((aCargo.getAbrgi_stat_ind() == null) && (abrgi_stat_ind == null))
				&& !((aCargo.getAbrgi_stat_ind() != null) && aCargo.getAbrgi_stat_ind().equals(abrgi_stat_ind))) {
			changedAttributeValue.put("abrgi_stat_ind", aCargo.getAbrgi_stat_ind());
		}
		if (!((aCargo.getAbrgs_stat_ind() == null) && (abrgs_stat_ind == null))
				&& !((aCargo.getAbrgs_stat_ind() != null) && aCargo.getAbrgs_stat_ind().equals(abrgs_stat_ind))) {
			changedAttributeValue.put("abrgs_stat_ind", aCargo.getAbrgs_stat_ind());
		}
		if (!((aCargo.getAbrlv_stat_ind() == null) && (abrlv_stat_ind == null))
				&& !((aCargo.getAbrlv_stat_ind() != null) && aCargo.getAbrlv_stat_ind().equals(abrlv_stat_ind))) {
			changedAttributeValue.put("abrlv_stat_ind", aCargo.getAbrlv_stat_ind());
		}
		if (!((aCargo.getAbscd_stat_ind() == null) && (abscd_stat_ind == null))
				&& !((aCargo.getAbscd_stat_ind() != null) && aCargo.getAbscd_stat_ind().equals(abscd_stat_ind))) {
			changedAttributeValue.put("abscd_stat_ind", aCargo.getAbscd_stat_ind());
		}
		if (!((aCargo.getAbsct_stat_ind() == null) && (absct_stat_ind == null))
				&& !((aCargo.getAbsct_stat_ind() != null) && aCargo.getAbsct_stat_ind().equals(absct_stat_ind))) {
			changedAttributeValue.put("absct_stat_ind", aCargo.getAbsct_stat_ind());
		}
		if (!((aCargo.getAbsed_stat_ind() == null) && (absed_stat_ind == null))
				&& !((aCargo.getAbsed_stat_ind() != null) && aCargo.getAbsed_stat_ind().equals(absed_stat_ind))) {
			changedAttributeValue.put("absed_stat_ind", aCargo.getAbsed_stat_ind());
		}
		if (!((aCargo.getAbsen_stat_ind() == null) && (absen_stat_ind == null))
				&& !((aCargo.getAbsen_stat_ind() != null) && aCargo.getAbsen_stat_ind().equals(absen_stat_ind))) {
			changedAttributeValue.put("absen_stat_ind", aCargo.getAbsen_stat_ind());
		}
		if (!((aCargo.getAbucd_stat_ind() == null) && (abucd_stat_ind == null))
				&& !((aCargo.getAbucd_stat_ind() != null) && aCargo.getAbucd_stat_ind().equals(abucd_stat_ind))) {
			changedAttributeValue.put("abucd_stat_ind", aCargo.getAbucd_stat_ind());
		}
		if (!((aCargo.getAbuct_stat_ind() == null) && (abuct_stat_ind == null))
				&& !((aCargo.getAbuct_stat_ind() != null) && aCargo.getAbuct_stat_ind().equals(abuct_stat_ind))) {
			changedAttributeValue.put("abuct_stat_ind", aCargo.getAbuct_stat_ind());
		}
		if (!((aCargo.getAbuid_stat_ind() == null) && (abuid_stat_ind == null))
				&& !((aCargo.getAbuid_stat_ind() != null) && aCargo.getAbuid_stat_ind().equals(abuid_stat_ind))) {
			changedAttributeValue.put("abuid_stat_ind", aCargo.getAbuid_stat_ind());
		}
		if (!((aCargo.getAbuit_stat_ind() == null) && (abuit_stat_ind == null))
				&& !((aCargo.getAbuit_stat_ind() != null) && aCargo.getAbuit_stat_ind().equals(abuit_stat_ind))) {
			changedAttributeValue.put("abuit_stat_ind", aCargo.getAbuit_stat_ind());
		}
		if (!((aCargo.getAbbad_stat_ind() == null) && (abbad_stat_ind == null))
				&& !((aCargo.getAbbad_stat_ind() != null) && aCargo.getAbbad_stat_ind().equals(abbad_stat_ind))) {
			changedAttributeValue.put("abbad_stat_ind", aCargo.getAbbad_stat_ind());
		}
		if (!((aCargo.getAbbat_stat_ind() == null) && (abbat_stat_ind == null))
				&& !((aCargo.getAbbat_stat_ind() != null) && aCargo.getAbbat_stat_ind().equals(abbat_stat_ind))) {
			changedAttributeValue.put("abbat_stat_ind", aCargo.getAbbat_stat_ind());
		}
		if (!((aCargo.getAbcon_stat_ind() == null) && (abcon_stat_ind == null))
				&& !((aCargo.getAbcon_stat_ind() != null) && aCargo.getAbcon_stat_ind().equals(abcon_stat_ind))) {
			changedAttributeValue.put("abcon_stat_ind", aCargo.getAbcon_stat_ind());
		}
		if (!((aCargo.getAbdis_stat_ind() == null) && (abdis_stat_ind == null))
				&& !((aCargo.getAbdis_stat_ind() != null) && aCargo.getAbdis_stat_ind().equals(abdis_stat_ind))) {
			changedAttributeValue.put("abdis_stat_ind", aCargo.getAbdis_stat_ind());
		}
		if (!((aCargo.getAbhca_stat_ind() == null) && (abhca_stat_ind == null))
				&& !((aCargo.getAbhca_stat_ind() != null) && aCargo.getAbhca_stat_ind().equals(abhca_stat_ind))) {
			changedAttributeValue.put("abhca_stat_ind", aCargo.getAbhca_stat_ind());
		}
		if (!((aCargo.getAbhcd_stat_ind() == null) && (abhcd_stat_ind == null))
				&& !((aCargo.getAbhcd_stat_ind() != null) && aCargo.getAbhcd_stat_ind().equals(abhcd_stat_ind))) {
			changedAttributeValue.put("abhcd_stat_ind", aCargo.getAbhcd_stat_ind());
		}
		if (!((aCargo.getAbhwa_stat_ind() == null) && (abhwa_stat_ind == null))
				&& !((aCargo.getAbhwa_stat_ind() != null) && aCargo.getAbhwa_stat_ind().equals(abhwa_stat_ind))) {
			changedAttributeValue.put("abhwa_stat_ind", aCargo.getAbhwa_stat_ind());
		}
		if (!((aCargo.getAbind_stat_ind() == null) && (abind_stat_ind == null))
				&& !((aCargo.getAbind_stat_ind() != null) && aCargo.getAbind_stat_ind().equals(abind_stat_ind))) {
			changedAttributeValue.put("abind_stat_ind", aCargo.getAbind_stat_ind());
		}
		if (!((aCargo.getAblad_stat_ind() == null) && (ablad_stat_ind == null))
				&& !((aCargo.getAblad_stat_ind() != null) && aCargo.getAblad_stat_ind().equals(ablad_stat_ind))) {
			changedAttributeValue.put("ablad_stat_ind", aCargo.getAblad_stat_ind());
		}
		if (!((aCargo.getAblaq_stat_ind() == null) && (ablaq_stat_ind == null))
				&& !((aCargo.getAblaq_stat_ind() != null) && aCargo.getAblaq_stat_ind().equals(ablaq_stat_ind))) {
			changedAttributeValue.put("ablaq_stat_ind", aCargo.getAblaq_stat_ind());
		}
		if (!((aCargo.getAblas_stat_ind() == null) && (ablas_stat_ind == null))
				&& !((aCargo.getAblas_stat_ind() != null) && aCargo.getAblas_stat_ind().equals(ablas_stat_ind))) {
			changedAttributeValue.put("ablas_stat_ind", aCargo.getAblas_stat_ind());
		}
		if (!((aCargo.getAblat_stat_ind() == null) && (ablat_stat_ind == null))
				&& !((aCargo.getAblat_stat_ind() != null) && aCargo.getAblat_stat_ind().equals(ablat_stat_ind))) {
			changedAttributeValue.put("ablat_stat_ind", aCargo.getAblat_stat_ind());
		}
		if (!((aCargo.getAblid_stat_ind() == null) && (ablid_stat_ind == null))
				&& !((aCargo.getAblid_stat_ind() != null) && aCargo.getAblid_stat_ind().equals(ablid_stat_ind))) {
			changedAttributeValue.put("ablid_stat_ind", aCargo.getAblid_stat_ind());
		}
		if (!((aCargo.getAblit_stat_ind() == null) && (ablit_stat_ind == null))
				&& !((aCargo.getAblit_stat_ind() != null) && aCargo.getAblit_stat_ind().equals(ablit_stat_ind))) {
			changedAttributeValue.put("ablit_stat_ind", aCargo.getAblit_stat_ind());
		}
		if (!((aCargo.getAboaq_stat_ind() == null) && (aboaq_stat_ind == null))
				&& !((aCargo.getAboaq_stat_ind() != null) && aCargo.getAboaq_stat_ind().equals(aboaq_stat_ind))) {
			changedAttributeValue.put("aboaq_stat_ind", aCargo.getAboaq_stat_ind());
		}
		if (!((aCargo.getAboas_stat_ind() == null) && (aboas_stat_ind == null))
				&& !((aCargo.getAboas_stat_ind() != null) && aCargo.getAboas_stat_ind().equals(aboas_stat_ind))) {
			changedAttributeValue.put("aboas_stat_ind", aCargo.getAboas_stat_ind());
		}
		if (!((aCargo.getAbppd_stat_ind() == null) && (abppd_stat_ind == null))
				&& !((aCargo.getAbppd_stat_ind() != null) && aCargo.getAbppd_stat_ind().equals(abppd_stat_ind))) {
			changedAttributeValue.put("abppd_stat_ind", aCargo.getAbppd_stat_ind());
		}
		if (!((aCargo.getAbrpd_stat_ind() == null) && (abrpd_stat_ind == null))
				&& !((aCargo.getAbrpd_stat_ind() != null) && aCargo.getAbrpd_stat_ind().equals(abrpd_stat_ind))) {
			changedAttributeValue.put("abrpd_stat_ind", aCargo.getAbrpd_stat_ind());
		}
		if (!((aCargo.getAbrpt_stat_ind() == null) && (abrpt_stat_ind == null))
				&& !((aCargo.getAbrpt_stat_ind() != null) && aCargo.getAbrpt_stat_ind().equals(abrpt_stat_ind))) {
			changedAttributeValue.put("abrpt_stat_ind", aCargo.getAbrpt_stat_ind());
		}
		if (!((aCargo.getAbvad_stat_ind() == null) && (abvad_stat_ind == null))
				&& !((aCargo.getAbvad_stat_ind() != null) && aCargo.getAbvad_stat_ind().equals(abvad_stat_ind))) {
			changedAttributeValue.put("abvad_stat_ind", aCargo.getAbvad_stat_ind());
		}
		if (!((aCargo.getAbvat_stat_ind() == null) && (abvat_stat_ind == null))
				&& !((aCargo.getAbvat_stat_ind() != null) && aCargo.getAbvat_stat_ind().equals(abvat_stat_ind))) {
			changedAttributeValue.put("abvat_stat_ind", aCargo.getAbvat_stat_ind());
		}
		if (!((aCargo.getAbmet_stat_ind() == null) && (abmet_stat_ind == null))
				&& !((aCargo.getAbmet_stat_ind() != null) && aCargo.getAbmet_stat_ind().equals(abmet_stat_ind))) {
			changedAttributeValue.put("abmet_stat_ind", aCargo.getAbmet_stat_ind());
		}
		if (!((aCargo.getAbmbd_stat_ind() == null) && (abmbd_stat_ind == null))
				&& !((aCargo.getAbmbd_stat_ind() != null) && aCargo.getAbmbd_stat_ind().equals(abmbd_stat_ind))) {
			changedAttributeValue.put("abmbd_stat_ind", aCargo.getAbmbd_stat_ind());
		}
		if (!((aCargo.getAbmah_stat_ind() == null) && (abmah_stat_ind == null))
				&& !((aCargo.getAbmah_stat_ind() != null) && aCargo.getAbmah_stat_ind().equals(abmah_stat_ind))) {
			changedAttributeValue.put("abmah_stat_ind", aCargo.getAbmah_stat_ind());
		}
		if (!((aCargo.getAbshs_stat_ind() == null) && (abshs_stat_ind == null))
				&& !((aCargo.getAbshs_stat_ind() != null) && aCargo.getAbshs_stat_ind().equals(abshs_stat_ind))) {
			changedAttributeValue.put("abshs_stat_ind", aCargo.getAbshs_stat_ind());
		}
		if (!((aCargo.getAbspd_stat_ind() == null) && (abspd_stat_ind == null))
				&& !((aCargo.getAbspd_stat_ind() != null) && aCargo.getAbspd_stat_ind().equals(abspd_stat_ind))) {
			changedAttributeValue.put("abspd_stat_ind", aCargo.getAbspd_stat_ind());
		}
		if (!((aCargo.getAbhel_stat_ind() == null) && (abhel_stat_ind == null))
				&& !((aCargo.getAbhel_stat_ind() != null) && aCargo.getAbhel_stat_ind().equals(abhel_stat_ind))) {
			changedAttributeValue.put("abhel_stat_ind", aCargo.getAbhel_stat_ind());
		}
		if (!((aCargo.getAbhng_stat_ind() == null) && (abhng_stat_ind == null))
				&& !((aCargo.getAbhng_stat_ind() != null) && aCargo.getAbhng_stat_ind().equals(abhng_stat_ind))) {
			changedAttributeValue.put("abhng_stat_ind", aCargo.getAbhng_stat_ind());
		}
		if (!((aCargo.getAbedr_stat_ind() == null) && (abedr_stat_ind == null))
				&& !((aCargo.getAbedr_stat_ind() != null) && aCargo.getAbedr_stat_ind().equals(abedr_stat_ind))) {
			changedAttributeValue.put("abedr_stat_ind", aCargo.getAbedr_stat_ind());
		}
		if (!((aCargo.getAbhdr_stat_ind() == null) && (abhdr_stat_ind == null))
				&& !((aCargo.getAbhdr_stat_ind() != null) && aCargo.getAbhdr_stat_ind().equals(abhdr_stat_ind))) {
			changedAttributeValue.put("abhdr_stat_ind", aCargo.getAbhdr_stat_ind());
		}
		if (!((aCargo.getAbdfg_stat_ind() == null) && (abdfg_stat_ind == null))
				&& !((aCargo.getAbdfg_stat_ind() != null) && aCargo.getAbdfg_stat_ind().equals(abdfg_stat_ind))) {
			changedAttributeValue.put("abdfg_stat_ind", aCargo.getAbdfg_stat_ind());
		}
		if (!((aCargo.getAbfur_stat_ind() == null) && (abfur_stat_ind == null))
				&& !((aCargo.getAbfur_stat_ind() != null) && aCargo.getAbfur_stat_ind().equals(abfur_stat_ind))) {
			changedAttributeValue.put("abfur_stat_ind", aCargo.getAbfur_stat_ind());
		}
		if (!((aCargo.getAbpth_stat_ind() == null) && (abpth_stat_ind == null))
				&& !((aCargo.getAbpth_stat_ind() != null) && aCargo.getAbpth_stat_ind().equals(abpth_stat_ind))) {
			changedAttributeValue.put("abpth_stat_ind", aCargo.getAbpth_stat_ind());
		}
		if (!((aCargo.getAbsss_stat_ind() == null) && (absss_stat_ind == null))
				&& !((aCargo.getAbsss_stat_ind() != null) && aCargo.getAbsss_stat_ind().equals(absss_stat_ind))) {
			changedAttributeValue.put("absss_stat_ind", aCargo.getAbsss_stat_ind());
		}
		if (!((aCargo.getAbstd_stat_ind() == null) && (abstd_stat_ind == null))
				&& !((aCargo.getAbstd_stat_ind() != null) && aCargo.getAbstd_stat_ind().equals(abstd_stat_ind))) {
			changedAttributeValue.put("abstd_stat_ind", aCargo.getAbstd_stat_ind());
		}
		if (!((aCargo.getAbuad_stat_ind() == null) && (abuad_stat_ind == null))
				&& !((aCargo.getAbuad_stat_ind() != null) && aCargo.getAbuad_stat_ind().equals(abuad_stat_ind))) {
			changedAttributeValue.put("abuad_stat_ind", aCargo.getAbuad_stat_ind());
		}
		if (!((aCargo.getAbdty_stat_ind() == null) && (abdty_stat_ind == null))
				&& !((aCargo.getAbdty_stat_ind() != null) && aCargo.getAbdty_stat_ind().equals(abdty_stat_ind))) {
			changedAttributeValue.put("abdty_stat_ind", aCargo.getAbdty_stat_ind());
		}
		if (!((aCargo.getAbddt_stat_ind() == null) && (abddt_stat_ind == null))
				&& !((aCargo.getAbddt_stat_ind() != null) && aCargo.getAbddt_stat_ind().equals(abddt_stat_ind))) {
			changedAttributeValue.put("abddt_stat_ind", aCargo.getAbddt_stat_ind());
		}
		if (!((aCargo.getAbdsm_stat_ind() == null) && (abdsm_stat_ind == null))
				&& !((aCargo.getAbdsm_stat_ind() != null) && aCargo.getAbdsm_stat_ind().equals(abdsm_stat_ind))) {
			changedAttributeValue.put("abdsm_stat_ind", aCargo.getAbdsm_stat_ind());
		}
		if (!((aCargo.getAbdfe_stat_ind() == null) && (abdfe_stat_ind == null))
				&& !((aCargo.getAbdfe_stat_ind() != null) && aCargo.getAbdfe_stat_ind().equals(abdfe_stat_ind))) {
			changedAttributeValue.put("abdfe_stat_ind", aCargo.getAbdfe_stat_ind());
		}
		if (!((aCargo.getAbcpa_stat_ind() == null) && (abcpa_stat_ind == null))
				&& !((aCargo.getAbcpa_stat_ind() != null) && aCargo.getAbcpa_stat_ind().equals(abcpa_stat_ind))) {
			changedAttributeValue.put("abcpa_stat_ind", aCargo.getAbcpa_stat_ind());
		}
		if (!((aCargo.getAbcph_stat_ind() == null) && (abcph_stat_ind == null))
				&& !((aCargo.getAbcph_stat_ind() != null) && aCargo.getAbcph_stat_ind().equals(abcph_stat_ind))) {
			changedAttributeValue.put("abcph_stat_ind", aCargo.getAbcph_stat_ind());
		}
		if (!((aCargo.getAbcra_stat_ind() == null) && (abcra_stat_ind == null))
				&& !((aCargo.getAbcra_stat_ind() != null) && aCargo.getAbcra_stat_ind().equals(abcra_stat_ind))) {
			changedAttributeValue.put("abcra_stat_ind", aCargo.getAbcra_stat_ind());
		}
		if (!((aCargo.getAbeca_stat_ind() == null) && (abeca_stat_ind == null))
				&& !((aCargo.getAbeca_stat_ind() != null) && aCargo.getAbeca_stat_ind().equals(abeca_stat_ind))) {
			changedAttributeValue.put("abeca_stat_ind", aCargo.getAbeca_stat_ind());
		}
		if (!((aCargo.getAbefa_stat_ind() == null) && (abefa_stat_ind == null))
				&& !((aCargo.getAbefa_stat_ind() != null) && aCargo.getAbefa_stat_ind().equals(abefa_stat_ind))) {
			changedAttributeValue.put("abefa_stat_ind", aCargo.getAbcph_stat_ind());
		}
		if (!((aCargo.getAbsta_stat_ind() == null) && (absta_stat_ind == null))
				&& !((aCargo.getAbsta_stat_ind() != null) && aCargo.getAbsta_stat_ind().equals(absta_stat_ind))) {
			changedAttributeValue.put("absta_stat_ind", aCargo.getAbsta_stat_ind());
		}
		if (!((aCargo.getAbshe_stat_ind() == null) && (abshe_stat_ind == null))
				&& !((aCargo.getAbshe_stat_ind() != null) && aCargo.getAbshe_stat_ind().equals(abshe_stat_ind))) {
			changedAttributeValue.put("abshe_stat_ind", aCargo.getAbshe_stat_ind());
		}
		if (!((aCargo.getAbsae_stat_ind() == null) && (absae_stat_ind == null))
				&& !((aCargo.getAbsae_stat_ind() != null) && aCargo.getAbsae_stat_ind().equals(absae_stat_ind))) {
			changedAttributeValue.put("absae_stat_ind", aCargo.getAbsae_stat_ind());
		}
		if (!((aCargo.getAbwre_stat_ind() == null) && (abwre_stat_ind == null))
				&& !((aCargo.getAbwre_stat_ind() != null) && aCargo.getAbwre_stat_ind().equals(abwre_stat_ind))) {
			changedAttributeValue.put("abwre_stat_ind", aCargo.getAbwre_stat_ind());
		}
		if (!((aCargo.getAbaur_stat_ind() == null) && (abaur_stat_ind == null))
				&& !((aCargo.getAbaur_stat_ind() != null) && aCargo.getAbaur_stat_ind().equals(abaur_stat_ind))) {
			changedAttributeValue.put("abaur_stat_ind", aCargo.getAbaur_stat_ind());
		}
		if (!((aCargo.getAbchs_stat_ind() == null) && (abchs_stat_ind == null))
				&& !((aCargo.getAbchs_stat_ind() != null) && aCargo.getAbchs_stat_ind().equals(abchs_stat_ind))) {
			changedAttributeValue.put("abchs_stat_ind", aCargo.getAbchs_stat_ind());
		}
		if (!((aCargo.getAbavd_stat_ind() == null) && (abavd_stat_ind == null))
				&& !((aCargo.getAbavd_stat_ind() != null) && aCargo.getAbavd_stat_ind().equals(abavd_stat_ind))) {
			changedAttributeValue.put("abavd_stat_ind", aCargo.getAbavd_stat_ind());
		}
		if (!((aCargo.getAbhdn_stat_ind() == null) && (abhdn_stat_ind == null))
				&& !((aCargo.getAbhdn_stat_ind() != null) && aCargo.getAbhdn_stat_ind().equals(abhdn_stat_ind))) {
			changedAttributeValue.put("abhdn_stat_ind", aCargo.getAbhdn_stat_ind());
		}
		if (!((aCargo.getAbdoc_stat_ind() == null) && (abdoc_stat_ind == null))
				&& !((aCargo.getAbdoc_stat_ind() != null) && aCargo.getAbdoc_stat_ind().equals(abdoc_stat_ind))) {
			changedAttributeValue.put("abdoc_stat_ind", aCargo.getAbdoc_stat_ind());
		}
		if (!((aCargo.getAbobq_stat_ind() == null) && (abobq_stat_ind == null))
				&& !((aCargo.getAbobq_stat_ind() != null) && aCargo.getAbobq_stat_ind().equals(abobq_stat_ind))) {
			changedAttributeValue.put("abobq_stat_ind", aCargo.getAbobq_stat_ind());
		}
		if (!((aCargo.getAbmdp_stat_ind() == null) && (abmdp_stat_ind == null))
				&& !((aCargo.getAbmdp_stat_ind() != null) && aCargo.getAbmdp_stat_ind().equals(abmdp_stat_ind))) {
			changedAttributeValue.put("abmdp_stat_ind", aCargo.getAbmdp_stat_ind());
		}
		if (!((aCargo.getAbhlt_stat_ind() == null) && (abhlt_stat_ind == null))
				&& !((aCargo.getAbhlt_stat_ind() != null) && aCargo.getAbhlt_stat_ind().equals(abhlt_stat_ind))) {
			changedAttributeValue.put("abhlt_stat_ind", aCargo.getAbhlt_stat_ind());
		}
		if (!((aCargo.getAbhsy_stat_ind() == null) && (abhsy_stat_ind == null))
				&& !((aCargo.getAbhsy_stat_ind() != null) && aCargo.getAbhsy_stat_ind().equals(abhsy_stat_ind))) {
			changedAttributeValue.put("abhsy_stat_ind", aCargo.getAbhsy_stat_ind());
		}
		if (!((aCargo.getAblhi_stat_ind() == null) && (ablhi_stat_ind == null))
				&& !((aCargo.getAblhi_stat_ind() != null) && aCargo.getAblhi_stat_ind().equals(ablhi_stat_ind))) {
			changedAttributeValue.put("ablhi_stat_ind", aCargo.getAblhi_stat_ind());
		}
		if (!((aCargo.getAbhsc_stat_ind() == null) && (abhsc_stat_ind == null))
				&& !((aCargo.getAbhsc_stat_ind() != null) && aCargo.getAbhsc_stat_ind().equals(abhsc_stat_ind))) {
			changedAttributeValue.put("abhsc_stat_ind", aCargo.getAbhsc_stat_ind());
		}
		if (!((aCargo.getAbnhm_stat_ind() == null) && (abnhm_stat_ind == null))
				&& !((aCargo.getAbnhm_stat_ind() != null) && aCargo.getAbnhm_stat_ind().equals(abnhm_stat_ind))) {
			changedAttributeValue.put("abnhm_stat_ind", aCargo.getAbnhm_stat_ind());
		}
		if (!((aCargo.getAbobs_stat_ind() == null) && (abobs_stat_ind == null))
				&& !((aCargo.getAbobs_stat_ind() != null) && aCargo.getAbobs_stat_ind().equals(abobs_stat_ind))) {
			changedAttributeValue.put("abobs_stat_ind", aCargo.getAbobs_stat_ind());
		}
		if (!((aCargo.getAbipi_stat_ind() == null) && (abipi_stat_ind == null))
				&& !((aCargo.getAbipi_stat_ind() != null) && aCargo.getAbipi_stat_ind().equals(abipi_stat_ind))) {
			changedAttributeValue.put("abipi_stat_ind", aCargo.getAbipi_stat_ind());
		}
		if (!((aCargo.getAbipq_stat_ind() == null) && (abipq_stat_ind == null))
				&& !((aCargo.getAbipq_stat_ind() != null) && aCargo.getAbipq_stat_ind().equals(abipq_stat_ind))) {
			changedAttributeValue.put("abipq_stat_ind", aCargo.getAbipq_stat_ind());
		}
		if (!((aCargo.getAbcrc_stat_ind() == null) && (abcrc_stat_ind == null))
				&& !((aCargo.getAbcrc_stat_ind() != null) && aCargo.getAbcrc_stat_ind().equals(abcrc_stat_ind))) {
			changedAttributeValue.put("abcrc_stat_ind", aCargo.getAbcrc_stat_ind());
		}
		if (!((aCargo.getAbhip_stat_ind() == null) && (abhip_stat_ind == null))
				&& !((aCargo.getAbhip_stat_ind() != null) && aCargo.getAbhip_stat_ind().equals(abhip_stat_ind))) {
			changedAttributeValue.put("abhip_stat_ind", aCargo.getAbhip_stat_ind());
		}
		if (!((aCargo.getAbort_stat_ind() == null) && (abort_stat_ind == null))
				&& !((aCargo.getAbort_stat_ind() != null) && aCargo.getAbort_stat_ind().equals(abort_stat_ind))) {
			changedAttributeValue.put("abort_stat_ind", aCargo.getAbort_stat_ind());
		}
		if (!((aCargo.getAbord_stat_ind() == null) && (abord_stat_ind == null))
				&& !((aCargo.getAbord_stat_ind() != null) && aCargo.getAbord_stat_ind().equals(abord_stat_ind))) {
			changedAttributeValue.put("abord_stat_ind", aCargo.getAbord_stat_ind());
		}
		if (!((aCargo.getAbiki_stat_ind() == null) && (abiki_stat_ind == null))
				&& !((aCargo.getAbiki_stat_ind() != null) && aCargo.getAbiki_stat_ind().equals(abiki_stat_ind))) {
			changedAttributeValue.put("abiki_stat_ind", aCargo.getAbiki_stat_ind());
		}
		if (!((aCargo.getAbofs_stat_ind() == null) && (abofs_stat_ind == null))
				&& !((aCargo.getAbofs_stat_ind() != null) && aCargo.getAbofs_stat_ind().equals(abofs_stat_ind))) {
			changedAttributeValue.put("abofs_stat_ind", aCargo.getAbofs_stat_ind());
		}
		if (!((aCargo.getAbtax_stat_ind() == null) && (abtax_stat_ind == null))
				&& !((aCargo.getAbtax_stat_ind() != null) && aCargo.getAbtax_stat_ind().equals(abtax_stat_ind))) {
			changedAttributeValue.put("abtax_stat_ind", aCargo.getAbtax_stat_ind());
		}
		if (!((aCargo.getAbtdp_stat_ind() == null) && (abtdp_stat_ind == null))
				&& !((aCargo.getAbtdp_stat_ind() != null) && aCargo.getAbtdp_stat_ind().equals(abtdp_stat_ind))) {
			changedAttributeValue.put("abtdp_stat_ind", aCargo.getAbtdp_stat_ind());
		}
		if (!((aCargo.getAbitd_stat_ind() == null) && (abitd_stat_ind == null))
				&& !((aCargo.getAbitd_stat_ind() != null) && aCargo.getAbitd_stat_ind().equals(abitd_stat_ind))) {
			changedAttributeValue.put("abitd_stat_ind", aCargo.getAbitd_stat_ind());
		}
		if (!((aCargo.getAbbtx_stat_ind() == null) && (abbtx_stat_ind == null))
				&& !((aCargo.getAbbtx_stat_ind() != null) && aCargo.getAbbtx_stat_ind().equals(abbtx_stat_ind))) {
			changedAttributeValue.put("abbtx_stat_ind", aCargo.getAbbtx_stat_ind());
		}
		if (!((aCargo.getAbbtd_stat_ind() == null) && (abbtd_stat_ind == null))
				&& !((aCargo.getAbbtd_stat_ind() != null) && aCargo.getAbbtd_stat_ind().equals(abbtd_stat_ind))) {
			changedAttributeValue.put("abbtd_stat_ind", aCargo.getAbbtd_stat_ind());
		}
		if (!((aCargo.getAbehi_stat_ind() == null) && (abehi_stat_ind == null))
				&& !((aCargo.getAbehi_stat_ind() != null) && aCargo.getAbehi_stat_ind().equals(abehi_stat_ind))) {
			changedAttributeValue.put("abehi_stat_ind", aCargo.getAbehi_stat_ind());
		}
		if (!((aCargo.getAbhin_stat_ind() == null) && (abhin_stat_ind == null))
				&& !((aCargo.getAbhin_stat_ind() != null) && aCargo.getAbhin_stat_ind().equals(abhin_stat_ind))) {
			changedAttributeValue.put("abhin_stat_ind", aCargo.getAbhin_stat_ind());
		}
		if (!((aCargo.getAbohi_stat_ind() == null) && (abohi_stat_ind == null))
				&& !((aCargo.getAbohi_stat_ind() != null) && aCargo.getAbohi_stat_ind().equals(abohi_stat_ind))) {
			changedAttributeValue.put("abohi_stat_ind", aCargo.getAbohi_stat_ind());
		}
		if (!((aCargo.getAbtxr_stat_ind() == null) && (abtxr_stat_ind == null))
				&& !((aCargo.getAbtxr_stat_ind() != null) && aCargo.getAbtxr_stat_ind().equals(abtxr_stat_ind))) {
			changedAttributeValue.put("abtxr_stat_ind", aCargo.getAbtxr_stat_ind());
		}
		if (!((aCargo.getAbtxi_stat_ind() == null) && (abtxi_stat_ind == null))
				&& !((aCargo.getAbtxi_stat_ind() != null) && aCargo.getAbtxi_stat_ind().equals(abtxi_stat_ind))) {
			changedAttributeValue.put("abtxi_stat_ind", aCargo.getAbtxi_stat_ind());
		}
		if (!((aCargo.getAbcfn_stat_ind() == null) && (abcfn_stat_ind == null))
				&& !((aCargo.getAbcfn_stat_ind() != null) && aCargo.getAbcfn_stat_ind().equals(abcfn_stat_ind))) {
			changedAttributeValue.put("abcfn_stat_ind", aCargo.getAbcfn_stat_ind());
		}
		if (!((aCargo.getAbbcn_stat_ind() == null) && (abbcn_stat_ind == null))
				&& !((aCargo.getAbbcn_stat_ind() != null) && aCargo.getAbbcn_stat_ind().equals(abbcn_stat_ind))) {
			changedAttributeValue.put("abbcn_stat_ind", aCargo.getAbbcn_stat_ind());
		}
		if (!((aCargo.getAbhbq_stat_ind() == null) && (abhbq_stat_ind == null))
				&& !((aCargo.getAbhbq_stat_ind() != null) && aCargo.getAbhbq_stat_ind().equals(abhbq_stat_ind))) {
			changedAttributeValue.put("abhbq_stat_ind", aCargo.getAbhbq_stat_ind());
		}
		if (!((aCargo.getAbhbd_stat_ind() == null) && (abhbd_stat_ind == null))
				&& !((aCargo.getAbhbd_stat_ind() != null) && aCargo.getAbhbd_stat_ind().equals(abhbd_stat_ind))) {
			changedAttributeValue.put("abhbd_stat_ind", aCargo.getAbhbd_stat_ind());
		}
		return changedAttributeValue;
	}

	/**
	 * @return the abtxi_stat_ind
	 */
	public String getAbtxi_stat_ind() {
		return abtxi_stat_ind;
	}

	/**
	 * @param abtxi_stat_ind the abtxi_stat_ind to set
	 */
	public void setAbtxi_stat_ind(final String abtxi_stat_ind) {
		this.abtxi_stat_ind = abtxi_stat_ind;
	}

}