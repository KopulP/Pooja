/*
 * 
 */
package gov.state.nextgen.access.driver.business.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import gov.state.nextgen.access.business.entities.AbstractCargo;
import gov.state.nextgen.access.business.entities.IPrimaryKey;
import gov.state.nextgen.access.management.util.FWUtils;
import gov.state.nextgen.access.management.util.FwDataCriteria;

/**
 * This java bean contains the entities of OTHR_RSN
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date Aug 11 16:15:25 CDT 2009 Modified By: Modified on: PCR#
 */

@SuppressWarnings("serial")
public class RMC_DRVR_Cargo extends AbstractCargo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	boolean isDirty = false;
	private String app_num;
	private String aracd_stat_ind;
	private String arcat_stat_ind;
	private String arhap_stat_ind;
	private String arhcs_stat_ind;
	private String arhdd_stat_ind;
	private String arhde_stat_ind;
	private String arhis_stat_ind;
	private String arhma_stat_ind;
	private String arhmd_stat_ind;
	private String arhmi_stat_ind;
	private String arhmo_stat_ind;
	private String arhpd_stat_ind;
	private String arhpg_stat_ind;
	private String arhrl_stat_ind;
	private String arhse_stat_ind;
	private String arjid_stat_ind;
	private String arehi_stat_ind;
	private String arjis_stat_ind;
	private String arjsd_stat_ind;
	private String arjse_stat_ind;
	private String arprs_stat_ind;
	private String artky_stat_ind;
	private String aruid_stat_ind;
	private String aruii_stat_ind;
	private String aruis_stat_ind;
	private String aruit_stat_ind;
	private String arxhd_stat_ind;
	private String arxhi_stat_ind;
	private String arxhs_stat_ind;
	private String arxhu_stat_ind;
	private String arxud_stat_ind;
	private String hscso_stat_ind;
	private String hsher_stat_ind;
	private String hshmo_stat_ind;
	private String aracs_stat_ind;
	private String aragq_stat_ind;
	private String araiq_stat_ind;
	private String arasm_stat_ind;
	private String arbad_stat_ind;
	private String arbat_stat_ind;
	private String ardcd_stat_ind;
	private String ardfd_stat_ind;
	private String arfas_stat_ind;
	private String arhcd_stat_ind;
	private String arhod_stat_ind;
	private String ariwe_stat_ind;
	private String arjgq_stat_ind;
	private String arlad_stat_ind;
	private String arlat_stat_ind;
	private String arlid_stat_ind;
	private String arlit_stat_ind;
	private String armap_stat_ind;
	private String armbd_stat_ind;
	private String arobc_stat_ind;
	private String arobi_stat_ind;
	private String arobq_stat_ind;
	private String arobs_stat_ind;
	private String aroiq_stat_ind;
	private String arpcs_stat_ind;
	private String arpgq_stat_ind;
	private String arpiq_stat_ind;
	private String arppd_stat_ind;
	private String arrbe_stat_ind;
	private String arrpd_stat_ind;
	private String arrpt_stat_ind;
	private String arsod_stat_ind;
	private String arvad_stat_ind;
	private String arvat_stat_ind;
	private String arxgq_stat_ind;
	private String arxiq_stat_ind;
	private String arrbi_stat_ind;
	private String arapa_stat_ind;
	private String arplr_stat_ind;
	private String arhca_stat_ind;
	private String arpcd_stat_ind;
	private String arper_stat_ind;
	private String arhoh_stat_ind;
	private String arxfr_stat_ind;
	private String aroaq_stat_ind;
	private String aroac_stat_ind;
	private String aroas_stat_ind;
	private String arcpa_stat_ind;
	private String arstd_stat_ind;
	private String aravd_stat_ind;
	private String ardgp_stat_ind;
	private String arlhi_stat_ind;
	private String arsum_stat_ind;
	private String arhmx_stat_ind;
	private String armed_stat_ind;
	private String arhps_stat_ind;
	private String arhos_stat_ind;
	private String arnur_stat_ind;
	private String arofs_stat_ind;
	private String arort_stat_ind;
	private String arord_stat_ind;
	private String ariki_stat_ind;
	private String arhbt_stat_ind;
	private String arbbq_stat_ind;
	private String arccc_stat_ind;
	private String arcsc_stat_ind;
	private String armbb_stat_ind;
	private String arbbs_stat_ind;
	private String arcta_stat_ind;
	private String arcon_stat_ind;
	private String arafp_stat_ind;
	private String armaa_stat_ind;
	private String aripi_stat_ind;
	private String ardoc_stat_ind;
	private String ararp_stat_ind;
	private String arfin_stat_ind;
	private String aridp_stat_ind;
	private String arbus_stat_ind;
	private String arhpa_stat_ind;
	private String armov_stat_ind;
	//NextGen  NG-6481 Phase 3 updates to ACA Streamline changes : Start
	private String aritd_stat_ind;
	private String arbtt_stat_ind;
	private String arbtd_stat_ind;
	//NextGen  NG-6481 Phase 3 updates to ACA Streamline changes : End
	FwDataCriteria[] dataCriteria;
	FwDataCriteria[] whereCriteria;
	private String arhin_stat_ind;
	private String arohi_stat_ind;
	private String artxi_stat_ind;
	private String artdp_stat_ind;
	// NextGen  NG-6481 Phase 1 updates to ACA Streamline changes � end
	//NextGen  NG-5805 ACA Streamline changes � start

	private String artax_stat_ind;
	private String arpre_stat_ind;
	private String arrld_stat_ind;
	private String arcfn_stat_ind;
	private String arbcn_stat_ind;

	/**
	 * @return the arcfn_stat_ind
	 */
	public String getArcfn_stat_ind() {
		return arcfn_stat_ind;
	}

	/**
	 * @return the arbcn_stat_ind
	 */
	public String getArbcn_stat_ind() {
		return arbcn_stat_ind;
	}

	/**
	 * @param arbcn_stat_ind the arbcn_stat_ind to set
	 */
	public void setArbcn_stat_ind(String arbcn_stat_ind) {
		this.arbcn_stat_ind = arbcn_stat_ind;
	}

	/**
	 * @param arcfn_stat_ind the arcfn_stat_ind to set
	 */
	public void setArcfn_stat_ind(final String arcfn_stat_ind) {
		this.arcfn_stat_ind = arcfn_stat_ind;
	}

	/**
	 * @return the arrld_stat_ind
	 */
	public String getArrld_stat_ind() {
		return arrld_stat_ind;
	}

	/**
	 * @return the artdp_stat_ind
	 */
	public String getArtdp_stat_ind() {
		return artdp_stat_ind;
	}

	/**
	 * @param artdp_stat_ind the artdp_stat_ind to set
	 */
	public void setArtdp_stat_ind(final String artdp_stat_ind) {
		this.artdp_stat_ind = artdp_stat_ind;
	}

	/**
	 * @return the arrld_stat_ind
	 */
	public String get() {
		return arrld_stat_ind;
	}

	/**
	 * @param arrld_stat_ind the arrld_stat_ind to set
	 */
	public void setArrld_stat_ind(final String arrld_stat_ind) {
		this.arrld_stat_ind = arrld_stat_ind;
	}

	/**
	 * @return the arpre_stat_ind
	 */
	public String getArpre_stat_ind() {
		return arpre_stat_ind;
	}

	/**
	 * @param arpre_stat_ind the arpre_stat_ind to set
	 */
	public void setArpre_stat_ind(final String arpre_stat_ind) {
		this.arpre_stat_ind = arpre_stat_ind;
	}

	/**
	 * @return the artax_stat_ind
	 */
	public String getArtax_stat_ind() {
		return artax_stat_ind;
	}

	/**
	 * @param artax_stat_ind the artax_stat_ind to set
	 */
	public void setArtax_stat_ind(final String artax_stat_ind) {
		this.artax_stat_ind = artax_stat_ind;
	}

	/**
	 * @return the arhin_stat_ind
	 */
	public String getArhin_stat_ind() {
		return arhin_stat_ind;
	}

	/**
	 * @param arhin_stat_ind the arhin_stat_ind to set
	 */
	public void setArhin_stat_ind(final String arhin_stat_ind) {
		this.arhin_stat_ind = arhin_stat_ind;
	}

	/**
	 * @return the arohi_stat_ind
	 */
	public String getArohi_stat_ind() {
		return arohi_stat_ind;
	}

	/**
	 * @param arohi_stat_ind the arohi_stat_ind to set
	 */
	public void setArohi_stat_ind(final String arohi_stat_ind) {
		this.arohi_stat_ind = arohi_stat_ind;
	}

	/**
	 * @return the arlhi_stat_ind
	 */
	public String getArlhi_stat_ind() {
		return arlhi_stat_ind;
	}

	/**
	 * @param arlhi_stat_ind the arlhi_stat_ind to set
	 */
	public void setArlhi_stat_ind(final String arlhi_stat_ind) {
		this.arlhi_stat_ind = arlhi_stat_ind;
	}

	/**
	 * @return the ardoc_stat_ind
	 */
	public String getArdoc_stat_ind() {
		return ardoc_stat_ind;
	}

	/**
	 * @param ardoc_stat_ind the ardoc_stat_ind to set
	 */
	public void setArdoc_stat_ind(final String ardoc_stat_ind) {
		this.ardoc_stat_ind = ardoc_stat_ind;
	}

	/**
	 * @return the ararp_stat_ind
	 */
	public String getArarp_stat_ind() {
		return ararp_stat_ind;
	}

	/**
	 * @param ararp_stat_ind the ararp_stat_ind to set
	 */
	public void setArarp_stat_ind(final String ararp_stat_ind) {
		this.ararp_stat_ind = ararp_stat_ind;
	}

	/**
	 * @return the arfin_stat_ind
	 */
	public String getArfin_stat_ind() {
		return arfin_stat_ind;
	}

	/**
	 * @param arfin_stat_ind the arfin_stat_ind to set
	 */
	public void setArfin_stat_ind(final String arfin_stat_ind) {
		this.arfin_stat_ind = arfin_stat_ind;
	}

	/**
	 * @return the aridp_stat_ind
	 */
	public String getAridp_stat_ind() {
		return aridp_stat_ind;
	}

	/**
	 * @param aridp_stat_ind the aridp_stat_ind to set
	 */
	public void setAridp_stat_ind(final String aridp_stat_ind) {
		this.aridp_stat_ind = aridp_stat_ind;
	}

	/**
	 * @return the arbus_stat_ind
	 */
	public String getArbus_stat_ind() {
		return arbus_stat_ind;
	}

	/**
	 * @param arbus_stat_ind the arbus_stat_ind to set
	 */
	public void setArbus_stat_ind(final String arbus_stat_ind) {
		this.arbus_stat_ind = arbus_stat_ind;
	}

	/**
	 * @return the arhpa_stat_ind
	 */
	public String getArhpa_stat_ind() {
		return arhpa_stat_ind;
	}

	/**
	 * @param arhpa_stat_ind the arhpa_stat_ind to set
	 */
	public void setArhpa_stat_ind(final String arhpa_stat_ind) {
		this.arhpa_stat_ind = arhpa_stat_ind;
	}

	/**
	 * @return the armov_stat_ind
	 */
	public String getArmov_stat_ind() {
		return armov_stat_ind;
	}

	/**
	 * @param armov_stat_ind the armov_stat_ind to set
	 */
	public void setArmov_stat_ind(final String armov_stat_ind) {
		this.armov_stat_ind = armov_stat_ind;
	}

	/**
	 * @return the arcta_stat_ind
	 */
	public String getArcta_stat_ind() {
		return arcta_stat_ind;
	}

	/**
	 * @param arcta_stat_ind the arcta_stat_ind to set
	 */
	public void setArcta_stat_ind(final String arcta_stat_ind) {
		this.arcta_stat_ind = arcta_stat_ind;
	}

	/**
	 * @return the arcon_stat_ind
	 */
	public String getArcon_stat_ind() {
		return arcon_stat_ind;
	}

	/**
	 * @param arcon_stat_ind the arcon_stat_ind to set
	 */
	public void setArcon_stat_ind(final String arcon_stat_ind) {
		this.arcon_stat_ind = arcon_stat_ind;
	}

	/**
	 * @return the arafp_stat_ind
	 */
	public String getArafp_stat_ind() {
		return arafp_stat_ind;
	}

	/**
	 * @param arafp_stat_ind the arafp_stat_ind to set
	 */
	public void setArafp_stat_ind(final String arafp_stat_ind) {
		this.arafp_stat_ind = arafp_stat_ind;
	}

	/**
	 * @return the armaa_stat_ind
	 */
	public String getArmaa_stat_ind() {
		return armaa_stat_ind;
	}

	/**
	 * @param armaa_stat_ind the armaa_stat_ind to set
	 */
	public void setArmaa_stat_ind(final String armaa_stat_ind) {
		this.armaa_stat_ind = armaa_stat_ind;
	}

	/**
	 * @return the arhbt_stat_ind
	 */
	public String getArhbt_stat_ind() {
		return arhbt_stat_ind;
	}

	/**
	 * @param arhbt_stat_ind the arhbt_stat_ind to set
	 */
	public void setArhbt_stat_ind(final String arhbt_stat_ind) {
		this.arhbt_stat_ind = arhbt_stat_ind;
	}

	/**
	 * @return the arbbq_stat_ind
	 */
	public String getArbbq_stat_ind() {
		return arbbq_stat_ind;
	}

	/**
	 * @param arbbq_stat_ind the arbbq_stat_ind to set
	 */
	public void setArbbq_stat_ind(final String arbbq_stat_ind) {
		this.arbbq_stat_ind = arbbq_stat_ind;
	}

	/**
	 * @return the arccc_stat_ind
	 */
	public String getArccc_stat_ind() {
		return arccc_stat_ind;
	}

	/**
	 * @param arccc_stat_ind the arccc_stat_ind to set
	 */
	public void setArccc_stat_ind(final String arccc_stat_ind) {
		this.arccc_stat_ind = arccc_stat_ind;
	}

	/**
	 * @return the arcsc_stat_ind
	 */
	public String getArcsc_stat_ind() {
		return arcsc_stat_ind;
	}

	/**
	 * @param arcsc_stat_ind the arcsc_stat_ind to set
	 */
	public void setArcsc_stat_ind(final String arcsc_stat_ind) {
		this.arcsc_stat_ind = arcsc_stat_ind;
	}

	/**
	 * @return the armbb_stat_ind
	 */
	public String getArmbb_stat_ind() {
		return armbb_stat_ind;
	}

	/**
	 * @return the aripi_stat_ind
	 */
	public String getAripi_stat_ind() {
		return aripi_stat_ind;
	}

	/**
	 * @param aripi_stat_ind the aripi_stat_ind to set
	 */
	public void setAripi_stat_ind(final String aripi_stat_ind) {
		this.aripi_stat_ind = aripi_stat_ind;
	}

	/**
	 * @param armbb_stat_ind the armbb_stat_ind to set
	 */
	public void setArmbb_stat_ind(final String armbb_stat_ind) {
		this.armbb_stat_ind = armbb_stat_ind;
	}

	/**
	 * @return the arbbs_stat_ind
	 */
	public String getArbbs_stat_ind() {
		return arbbs_stat_ind;
	}

	/**
	 * @param arbbs_stat_ind the arbbs_stat_ind to set
	 */
	public void setArbbs_stat_ind(final String arbbs_stat_ind) {
		this.arbbs_stat_ind = arbbs_stat_ind;
	}

	/**
	 * @return the arsum_stat_ind
	 */
	public String getArsum_stat_ind() {
		return arsum_stat_ind;
	}

	/**
	 * @param arsum_stat_ind the arsum_stat_ind to set
	 */
	public void setArsum_stat_ind(final String arsum_stat_ind) {
		this.arsum_stat_ind = arsum_stat_ind;
	}

	/**
	 * @return the arhmx_stat_ind
	 */
	public String getArhmx_stat_ind() {
		return arhmx_stat_ind;
	}

	/**
	 * @param arhmx_stat_ind the arhmx_stat_ind to set
	 */
	public void setArhmx_stat_ind(final String arhmx_stat_ind) {
		this.arhmx_stat_ind = arhmx_stat_ind;
	}

	/**
	 * @return the armed_stat_ind
	 */
	public String getArmed_stat_ind() {
		return armed_stat_ind;
	}

	/**
	 * @param armed_stat_ind the armed_stat_ind to set
	 */
	public void setArmed_stat_ind(final String armed_stat_ind) {
		this.armed_stat_ind = armed_stat_ind;
	}

	/**
	 * @return the arhps_stat_ind
	 */
	public String getArhps_stat_ind() {
		return arhps_stat_ind;
	}

	/**
	 * @param arhps_stat_ind the arhps_stat_ind to set
	 */
	public void setArhps_stat_ind(final String arhps_stat_ind) {
		this.arhps_stat_ind = arhps_stat_ind;
	}

	/**
	 * @return the arhos_stat_ind
	 */
	public String getArhos_stat_ind() {
		return arhos_stat_ind;
	}

	/**
	 * @param arhos_stat_ind the arhos_stat_ind to set
	 */
	public void setArhos_stat_ind(final String arhos_stat_ind) {
		this.arhos_stat_ind = arhos_stat_ind;
	}

	/**
	 * @return the arnur_stat_ind
	 */
	public String getArnur_stat_ind() {
		return arnur_stat_ind;
	}

	/**
	 * @param arnur_stat_ind the arnur_stat_ind to set
	 */
	public void setArnur_stat_ind(final String arnur_stat_ind) {
		this.arnur_stat_ind = arnur_stat_ind;
	}

	/**
	 * @return the arofs_stat_ind
	 */
	public String getArofs_stat_ind() {
		return arofs_stat_ind;
	}

	/**
	 * @param arofs_stat_ind the arofs_stat_ind to set
	 */
	public void setArofs_stat_ind(final String arofs_stat_ind) {
		this.arofs_stat_ind = arofs_stat_ind;
	}

	/**
	 * @return the arort_stat_ind
	 */
	public String getArort_stat_ind() {
		return arort_stat_ind;
	}

	/**
	 * @param arort_stat_ind the arort_stat_ind to set
	 */
	public void setArort_stat_ind(final String arort_stat_ind) {
		this.arort_stat_ind = arort_stat_ind;
	}

	/**
	 * @return the arord_stat_ind
	 */
	public String getArord_stat_ind() {
		return arord_stat_ind;
	}

	/**
	 * @param arord_stat_ind the arord_stat_ind to set
	 */
	public void setArord_stat_ind(final String arord_stat_ind) {
		this.arord_stat_ind = arord_stat_ind;
	}

	/**
	 * @return the ariki_stat_ind
	 */
	public String getAriki_stat_ind() {
		return ariki_stat_ind;
	}

	/**
	 * @param ariki_stat_ind the ariki_stat_ind to set
	 */
	public void setAriki_stat_ind(final String ariki_stat_ind) {
		this.ariki_stat_ind = ariki_stat_ind;
	}

	public String getArstd_stat_ind() {
		return arstd_stat_ind;
	}

	public void setArstd_stat_ind(final String arstd_stat_ind) {
		this.arstd_stat_ind = arstd_stat_ind;
	}

	/**
	 * @return the aravd_stat_ind
	 */
	public String getAravd_stat_ind() {
		return aravd_stat_ind;
	}

	/**
	 * @return the ardgp_stat_ind
	 */
	public String getArdgp_stat_ind() {
		return ardgp_stat_ind;
	}

	/**
	 * @param ardgp_stat_ind the ardgp_stat_ind to set
	 */
	public void setArdgp_stat_ind(final String ardgp_stat_ind) {
		this.ardgp_stat_ind = ardgp_stat_ind;
	}

	/**
	 * @param aravd_stat_ind the aravd_stat_ind to set
	 */
	public void setAravd_stat_ind(final String aravd_stat_ind) {
		this.aravd_stat_ind = aravd_stat_ind;
	}

	/**
	 * returns the app_num value.
	 */
	public String getApp_num() {
		return app_num;
	}

	public String getArcpa_stat_ind() {
		return arcpa_stat_ind;
	}

	public void setArcpa_stat_ind(final String arcpa_stat_ind) {
		this.arcpa_stat_ind = arcpa_stat_ind;
	}

	/**
	 * returns the aracd_stat_ind value.
	 */
	public String getAracd_stat_ind() {
		return aracd_stat_ind;
	}

	/**
	 * returns the arcat_stat_ind value.
	 */
	public String getArcat_stat_ind() {
		return arcat_stat_ind;
	}

	/**
	 * returns the arhap_stat_ind value.
	 */
	public String getArhap_stat_ind() {
		return arhap_stat_ind;
	}

	/**
	 * returns the arhcs_stat_ind value.
	 */
	public String getArhcs_stat_ind() {
		return arhcs_stat_ind;
	}

	/**
	 * returns the arhdd_stat_ind value.
	 */
	public String getArhdd_stat_ind() {
		return arhdd_stat_ind;
	}

	/**
	 * returns the arhde_stat_ind value.
	 */
	public String getArhde_stat_ind() {
		return arhde_stat_ind;
	}

	/**
	 * returns the arhis_stat_ind value.
	 */
	public String getArhis_stat_ind() {
		return arhis_stat_ind;
	}

	/**
	 * returns the arhma_stat_ind value.
	 */
	public String getArhma_stat_ind() {
		return arhma_stat_ind;
	}

	/**
	 * returns the arhmd_stat_ind value.
	 */
	public String getArhmd_stat_ind() {
		return arhmd_stat_ind;
	}

	/**
	 * returns the arhmi_stat_ind value.
	 */
	public String getArhmi_stat_ind() {
		return arhmi_stat_ind;
	}

	/**
	 * returns the arhmo_stat_ind value.
	 */
	public String getArhmo_stat_ind() {
		return arhmo_stat_ind;
	}

	/**
	 * returns the arhpd_stat_ind value.
	 */
	public String getArhpd_stat_ind() {
		return arhpd_stat_ind;
	}

	/**
	 * returns the arhpg_stat_ind value.
	 */
	public String getArhpg_stat_ind() {
		return arhpg_stat_ind;
	}

	/**
	 * returns the arhrl_stat_ind value.
	 */
	public String getArhrl_stat_ind() {
		return arhrl_stat_ind;
	}

	/**
	 * returns the arhse_stat_ind value.
	 */
	public String getArhse_stat_ind() {
		return arhse_stat_ind;
	}

	/**
	 * returns the arjid_stat_ind value.
	 */
	public String getArjid_stat_ind() {
		return arjid_stat_ind;
	}

	/**
	 * returns the arehi_stat_ind value.
	 */
	public String getArehi_stat_ind() {
		return arehi_stat_ind;
	}

	/**
	 * returns the arjis_stat_ind value.
	 */
	public String getArjis_stat_ind() {
		return arjis_stat_ind;
	}

	/**
	 * returns the arjsd_stat_ind value.
	 */
	public String getArjsd_stat_ind() {
		return arjsd_stat_ind;
	}

	/**
	 * returns the arjse_stat_ind value.
	 */
	public String getArjse_stat_ind() {
		return arjse_stat_ind;
	}

	/**
	 * returns the arprs_stat_ind value.
	 */
	public String getArprs_stat_ind() {
		return arprs_stat_ind;
	}

	/**
	 * returns the artky_stat_ind value.
	 */
	public String getArtky_stat_ind() {
		return artky_stat_ind;
	}

	/**
	 * returns the aruid_stat_ind value.
	 */
	public String getAruid_stat_ind() {
		return aruid_stat_ind;
	}

	/**
	 * returns the aruii_stat_ind value.
	 */
	public String getAruii_stat_ind() {
		return aruii_stat_ind;
	}

	/**
	 * returns the aruis_stat_ind value.
	 */
	public String getAruis_stat_ind() {
		return aruis_stat_ind;
	}

	/**
	 * returns the aruit_stat_ind value.
	 */
	public String getAruit_stat_ind() {
		return aruit_stat_ind;
	}

	/**
	 * returns the arxhd_stat_ind value.
	 */
	public String getArxhd_stat_ind() {
		return arxhd_stat_ind;
	}

	/**
	 * returns the arxhi_stat_ind value.
	 */
	public String getArxhi_stat_ind() {
		return arxhi_stat_ind;
	}

	/**
	 * returns the arxhs_stat_ind value.
	 */
	public String getArxhs_stat_ind() {
		return arxhs_stat_ind;
	}

	/**
	 * returns the arxhu_stat_ind value.
	 */
	public String getArxhu_stat_ind() {
		return arxhu_stat_ind;
	}

	/**
	 * returns the arxud_stat_ind value.
	 */
	public String getArxud_stat_ind() {
		return arxud_stat_ind;
	}

	/**
	 * returns the hscso_stat_ind value.
	 */
	public String getHscso_stat_ind() {
		return hscso_stat_ind;
	}

	/**
	 * returns the hsher_stat_ind value.
	 */
	public String getHsher_stat_ind() {
		return hsher_stat_ind;
	}

	/**
	 * returns the hshmo_stat_ind value.
	 */
	public String getHshmo_stat_ind() {
		return hshmo_stat_ind;
	}

	/**
	 * returns the aracs_stat_ind value.
	 */
	public String getAracs_stat_ind() {
		return aracs_stat_ind;
	}

	/**
	 * returns the aragq_stat_ind value.
	 */
	public String getAragq_stat_ind() {
		return aragq_stat_ind;
	}

	/**
	 * returns the araiq_stat_ind value.
	 */
	public String getAraiq_stat_ind() {
		return araiq_stat_ind;
	}

	/**
	 * returns the arasm_stat_ind value.
	 */
	public String getArasm_stat_ind() {
		return arasm_stat_ind;
	}

	/**
	 * returns the arbad_stat_ind value.
	 */
	public String getArbad_stat_ind() {
		return arbad_stat_ind;
	}

	/**
	 * returns the arbat_stat_ind value.
	 */
	public String getArbat_stat_ind() {
		return arbat_stat_ind;
	}

	/**
	 * returns the ardcd_stat_ind value.
	 */
	public String getArdcd_stat_ind() {
		return ardcd_stat_ind;
	}

	/**
	 * returns the ardfd_stat_ind value.
	 */
	public String getArdfd_stat_ind() {
		return ardfd_stat_ind;
	}

	/**
	 * returns the arfas_stat_ind value.
	 */
	public String getArfas_stat_ind() {
		return arfas_stat_ind;
	}

	/**
	 * returns the arhcd_stat_ind value.
	 */
	public String getArhcd_stat_ind() {
		return arhcd_stat_ind;
	}

	/**
	 * returns the arhod_stat_ind value.
	 */
	public String getArhod_stat_ind() {
		return arhod_stat_ind;
	}

	/**
	 * returns the ariwe_stat_ind value.
	 */
	public String getAriwe_stat_ind() {
		return ariwe_stat_ind;
	}

	/**
	 * returns the arjgq_stat_ind value.
	 */
	public String getArjgq_stat_ind() {
		return arjgq_stat_ind;
	}

	/**
	 * returns the arlad_stat_ind value.
	 */
	public String getArlad_stat_ind() {
		return arlad_stat_ind;
	}

	/**
	 * returns the arlat_stat_ind value.
	 */
	public String getArlat_stat_ind() {
		return arlat_stat_ind;
	}

	/**
	 * returns the arlid_stat_ind value.
	 */
	public String getArlid_stat_ind() {
		return arlid_stat_ind;
	}

	/**
	 * returns the arlit_stat_ind value.
	 */
	public String getArlit_stat_ind() {
		return arlit_stat_ind;
	}

	/**
	 * returns the armap_stat_ind value.
	 */
	public String getArmap_stat_ind() {
		return armap_stat_ind;
	}

	/**
	 * returns the armbd_stat_ind value.
	 */
	public String getArmbd_stat_ind() {
		return armbd_stat_ind;
	}

	/**
	 * returns the arobc_stat_ind value.
	 */
	public String getArobc_stat_ind() {
		return arobc_stat_ind;
	}

	/**
	 * returns the arobi_stat_ind value.
	 */
	public String getArobi_stat_ind() {
		return arobi_stat_ind;
	}

	/**
	 * returns the arobq_stat_ind value.
	 */
	public String getArobq_stat_ind() {
		return arobq_stat_ind;
	}

	/**
	 * returns the arobs_stat_ind value.
	 */
	public String getArobs_stat_ind() {
		return arobs_stat_ind;
	}

	/**
	 * returns the aroiq_stat_ind value.
	 */
	public String getAroiq_stat_ind() {
		return aroiq_stat_ind;
	}

	/**
	 * returns the arpcs_stat_ind value.
	 */
	public String getArpcs_stat_ind() {
		return arpcs_stat_ind;
	}

	/**
	 * returns the arpgq_stat_ind value.
	 */
	public String getArpgq_stat_ind() {
		return arpgq_stat_ind;
	}

	/**
	 * returns the arpiq_stat_ind value.
	 */
	public String getArpiq_stat_ind() {
		return arpiq_stat_ind;
	}

	/**
	 * returns the arppd_stat_ind value.
	 */
	public String getArppd_stat_ind() {
		return arppd_stat_ind;
	}

	/**
	 * returns the arrbe_stat_ind value.
	 */
	public String getArrbe_stat_ind() {
		return arrbe_stat_ind;
	}

	/**
	 * returns the arrpd_stat_ind value.
	 */
	public String getArrpd_stat_ind() {
		return arrpd_stat_ind;
	}

	/**
	 * returns the arrpt_stat_ind value.
	 */
	public String getArrpt_stat_ind() {
		return arrpt_stat_ind;
	}

	/**
	 * returns the arsod_stat_ind value.
	 */
	public String getArsod_stat_ind() {
		return arsod_stat_ind;
	}

	/**
	 * returns the arvad_stat_ind value.
	 */
	public String getArvad_stat_ind() {
		return arvad_stat_ind;
	}

	/**
	 * returns the arvat_stat_ind value.
	 */
	public String getArvat_stat_ind() {
		return arvat_stat_ind;
	}

	/**
	 * returns the arxgq_stat_ind value.
	 */
	public String getArxgq_stat_ind() {
		return arxgq_stat_ind;
	}

	/**
	 * returns the arxiq_stat_ind value.
	 */
	public String getArxiq_stat_ind() {
		return arxiq_stat_ind;
	}

	/**
	 * returns the arrbi_stat_ind value.
	 */
	public String getArrbi_stat_ind() {
		return arrbi_stat_ind;
	}

	/**
	 * returns the arapa_stat_ind value.
	 */
	public String getArapa_stat_ind() {
		return arapa_stat_ind;
	}

	/**
	 * returns the arplr_stat_ind value.
	 */
	public String getArplr_stat_ind() {
		return arplr_stat_ind;
	}

	/**
	 * sets the app_num value.
	 */
	public void setApp_num(final String app_num) {
		this.app_num = app_num;
	}

	/**
	 * sets the aracd_stat_ind value.
	 */
	public void setAracd_stat_ind(final String aracd_stat_ind) {
		this.aracd_stat_ind = aracd_stat_ind;
	}

	/**
	 * sets the arcat_stat_ind value.
	 */
	public void setArcat_stat_ind(final String arcat_stat_ind) {
		this.arcat_stat_ind = arcat_stat_ind;
	}

	/**
	 * sets the arhap_stat_ind value.
	 */
	public void setArhap_stat_ind(final String arhap_stat_ind) {
		this.arhap_stat_ind = arhap_stat_ind;
	}

	/**
	 * sets the arhcs_stat_ind value.
	 */
	public void setArhcs_stat_ind(final String arhcs_stat_ind) {
		this.arhcs_stat_ind = arhcs_stat_ind;
	}

	/**
	 * sets the arhdd_stat_ind value.
	 */
	public void setArhdd_stat_ind(final String arhdd_stat_ind) {
		this.arhdd_stat_ind = arhdd_stat_ind;
	}

	/**
	 * sets the arhde_stat_ind value.
	 */
	public void setArhde_stat_ind(final String arhde_stat_ind) {
		this.arhde_stat_ind = arhde_stat_ind;
	}

	/**
	 * sets the arhis_stat_ind value.
	 */
	public void setArhis_stat_ind(final String arhis_stat_ind) {
		this.arhis_stat_ind = arhis_stat_ind;
	}

	/**
	 * sets the arhma_stat_ind value.
	 */
	public void setArhma_stat_ind(final String arhma_stat_ind) {
		this.arhma_stat_ind = arhma_stat_ind;
	}

	/**
	 * sets the arhmd_stat_ind value.
	 */
	public void setArhmd_stat_ind(final String arhmd_stat_ind) {
		this.arhmd_stat_ind = arhmd_stat_ind;
	}

	/**
	 * sets the arhmi_stat_ind value.
	 */
	public void setArhmi_stat_ind(final String arhmi_stat_ind) {
		this.arhmi_stat_ind = arhmi_stat_ind;
	}

	/**
	 * sets the arhmo_stat_ind value.
	 */
	public void setArhmo_stat_ind(final String arhmo_stat_ind) {
		this.arhmo_stat_ind = arhmo_stat_ind;
	}

	/**
	 * sets the arhpd_stat_ind value.
	 */
	public void setArhpd_stat_ind(final String arhpd_stat_ind) {
		this.arhpd_stat_ind = arhpd_stat_ind;
	}

	/**
	 * sets the arhpg_stat_ind value.
	 */
	public void setArhpg_stat_ind(final String arhpg_stat_ind) {
		this.arhpg_stat_ind = arhpg_stat_ind;
	}

	/**
	 * sets the arhrl_stat_ind value.
	 */
	public void setArhrl_stat_ind(final String arhrl_stat_ind) {
		this.arhrl_stat_ind = arhrl_stat_ind;
	}

	/**
	 * sets the arhse_stat_ind value.
	 */
	public void setArhse_stat_ind(final String arhse_stat_ind) {
		this.arhse_stat_ind = arhse_stat_ind;
	}

	/**
	 * sets the arjid_stat_ind value.
	 */
	public void setArjid_stat_ind(final String arjid_stat_ind) {
		this.arjid_stat_ind = arjid_stat_ind;
	}

	/**
	 * sets the arehi_stat_ind value.
	 */
	public void setArehi_stat_ind(final String arjid_stat_ind) {
		arehi_stat_ind = arjid_stat_ind;
	}

	/**
	 * sets the arjis_stat_ind value.
	 */
	public void setArjis_stat_ind(final String arjis_stat_ind) {
		this.arjis_stat_ind = arjis_stat_ind;
	}

	/**
	 * sets the arjsd_stat_ind value.
	 */
	public void setArjsd_stat_ind(final String arjsd_stat_ind) {
		this.arjsd_stat_ind = arjsd_stat_ind;
	}

	/**
	 * sets the arjse_stat_ind value.
	 */
	public void setArjse_stat_ind(final String arjse_stat_ind) {
		this.arjse_stat_ind = arjse_stat_ind;
	}

	/**
	 * sets the arprs_stat_ind value.
	 */
	public void setArprs_stat_ind(final String arprs_stat_ind) {
		this.arprs_stat_ind = arprs_stat_ind;
	}

	/**
	 * sets the artky_stat_ind value.
	 */
	public void setArtky_stat_ind(final String artky_stat_ind) {
		this.artky_stat_ind = artky_stat_ind;
	}

	/**
	 * sets the aruid_stat_ind value.
	 */
	public void setAruid_stat_ind(final String aruid_stat_ind) {
		this.aruid_stat_ind = aruid_stat_ind;
	}

	/**
	 * sets the aruii_stat_ind value.
	 */
	public void setAruii_stat_ind(final String aruii_stat_ind) {
		this.aruii_stat_ind = aruii_stat_ind;
	}

	/**
	 * sets the aruis_stat_ind value.
	 */
	public void setAruis_stat_ind(final String aruis_stat_ind) {
		this.aruis_stat_ind = aruis_stat_ind;
	}

	/**
	 * sets the aruit_stat_ind value.
	 */
	public void setAruit_stat_ind(final String aruit_stat_ind) {
		this.aruit_stat_ind = aruit_stat_ind;
	}

	/**
	 * sets the arxhd_stat_ind value.
	 */
	public void setArxhd_stat_ind(final String arxhd_stat_ind) {
		this.arxhd_stat_ind = arxhd_stat_ind;
	}

	/**
	 * sets the arxhi_stat_ind value.
	 */
	public void setArxhi_stat_ind(final String arxhi_stat_ind) {
		this.arxhi_stat_ind = arxhi_stat_ind;
	}

	/**
	 * sets the arxhs_stat_ind value.
	 */
	public void setArxhs_stat_ind(final String arxhs_stat_ind) {
		this.arxhs_stat_ind = arxhs_stat_ind;
	}

	/**
	 * sets the arxhu_stat_ind value.
	 */
	public void setArxhu_stat_ind(final String arxhu_stat_ind) {
		this.arxhu_stat_ind = arxhu_stat_ind;
	}

	/**
	 * sets the arxud_stat_ind value.
	 */
	public void setArxud_stat_ind(final String arxud_stat_ind) {
		this.arxud_stat_ind = arxud_stat_ind;
	}

	/**
	 * sets the hscso_stat_ind value.
	 */
	public void setHscso_stat_ind(final String hscso_stat_ind) {
		this.hscso_stat_ind = hscso_stat_ind;
	}

	/**
	 * sets the hsher_stat_ind value.
	 */
	public void setHsher_stat_ind(final String hsher_stat_ind) {
		this.hsher_stat_ind = hsher_stat_ind;
	}

	/**
	 * sets the hshmo_stat_ind value.
	 */
	public void setHshmo_stat_ind(final String hshmo_stat_ind) {
		this.hshmo_stat_ind = hshmo_stat_ind;
	}

	/**
	 * sets the aracs_stat_ind value.
	 */
	public void setAracs_stat_ind(final String aracs_stat_ind) {
		this.aracs_stat_ind = aracs_stat_ind;
	}

	/**
	 * sets the aragq_stat_ind value.
	 */
	public void setAragq_stat_ind(final String aragq_stat_ind) {
		this.aragq_stat_ind = aragq_stat_ind;
	}

	/**
	 * sets the araiq_stat_ind value.
	 */
	public void setAraiq_stat_ind(final String araiq_stat_ind) {
		this.araiq_stat_ind = araiq_stat_ind;
	}

	/**
	 * sets the arasm_stat_ind value.
	 */
	public void setArasm_stat_ind(final String arasm_stat_ind) {
		this.arasm_stat_ind = arasm_stat_ind;
	}

	/**
	 * sets the arbad_stat_ind value.
	 */
	public void setArbad_stat_ind(final String arbad_stat_ind) {
		this.arbad_stat_ind = arbad_stat_ind;
	}

	/**
	 * sets the arbat_stat_ind value.
	 */
	public void setArbat_stat_ind(final String arbat_stat_ind) {
		this.arbat_stat_ind = arbat_stat_ind;
	}

	/**
	 * sets the ardcd_stat_ind value.
	 */
	public void setArdcd_stat_ind(final String ardcd_stat_ind) {
		this.ardcd_stat_ind = ardcd_stat_ind;
	}

	/**
	 * sets the ardfd_stat_ind value.
	 */
	public void setArdfd_stat_ind(final String ardfd_stat_ind) {
		this.ardfd_stat_ind = ardfd_stat_ind;
	}

	/**
	 * sets the arfas_stat_ind value.
	 */
	public void setArfas_stat_ind(final String arfas_stat_ind) {
		this.arfas_stat_ind = arfas_stat_ind;
	}

	/**
	 * sets the arhcd_stat_ind value.
	 */
	public void setArhcd_stat_ind(final String arhcd_stat_ind) {
		this.arhcd_stat_ind = arhcd_stat_ind;
	}

	/**
	 * sets the arhod_stat_ind value.
	 */
	public void setArhod_stat_ind(final String arhod_stat_ind) {
		this.arhod_stat_ind = arhod_stat_ind;
	}

	/**
	 * sets the ariwe_stat_ind value.
	 */
	public void setAriwe_stat_ind(final String ariwe_stat_ind) {
		this.ariwe_stat_ind = ariwe_stat_ind;
	}

	/**
	 * sets the arjgq_stat_ind value.
	 */
	public void setArjgq_stat_ind(final String arjgq_stat_ind) {
		this.arjgq_stat_ind = arjgq_stat_ind;
	}

	/**
	 * sets the arlad_stat_ind value.
	 */
	public void setArlad_stat_ind(final String arlad_stat_ind) {
		this.arlad_stat_ind = arlad_stat_ind;
	}

	/**
	 * sets the arlat_stat_ind value.
	 */
	public void setArlat_stat_ind(final String arlat_stat_ind) {
		this.arlat_stat_ind = arlat_stat_ind;
	}

	/**
	 * sets the arlid_stat_ind value.
	 */
	public void setArlid_stat_ind(final String arlid_stat_ind) {
		this.arlid_stat_ind = arlid_stat_ind;
	}

	/**
	 * sets the arlit_stat_ind value.
	 */
	public void setArlit_stat_ind(final String arlit_stat_ind) {
		this.arlit_stat_ind = arlit_stat_ind;
	}

	/**
	 * sets the armap_stat_ind value.
	 */
	public void setArmap_stat_ind(final String armap_stat_ind) {
		this.armap_stat_ind = armap_stat_ind;
	}

	/**
	 * sets the armbd_stat_ind value.
	 */
	public void setArmbd_stat_ind(final String armbd_stat_ind) {
		this.armbd_stat_ind = armbd_stat_ind;
	}

	/**
	 * sets the arobc_stat_ind value.
	 */
	public void setArobc_stat_ind(final String arobc_stat_ind) {
		this.arobc_stat_ind = arobc_stat_ind;
	}

	/**
	 * sets the arobi_stat_ind value.
	 */
	public void setArobi_stat_ind(final String arobi_stat_ind) {
		this.arobi_stat_ind = arobi_stat_ind;
	}

	/**
	 * sets the arobq_stat_ind value.
	 */
	public void setArobq_stat_ind(final String arobq_stat_ind) {
		this.arobq_stat_ind = arobq_stat_ind;
	}

	/**
	 * sets the arobs_stat_ind value.
	 */
	public void setArobs_stat_ind(final String arobs_stat_ind) {
		this.arobs_stat_ind = arobs_stat_ind;
	}

	/**
	 * sets the aroiq_stat_ind value.
	 */
	public void setAroiq_stat_ind(final String aroiq_stat_ind) {
		this.aroiq_stat_ind = aroiq_stat_ind;
	}

	/**
	 * sets the arpcs_stat_ind value.
	 */
	public void setArpcs_stat_ind(final String arpcs_stat_ind) {
		this.arpcs_stat_ind = arpcs_stat_ind;
	}

	/**
	 * sets the arpgq_stat_ind value.
	 */
	public void setArpgq_stat_ind(final String arpgq_stat_ind) {
		this.arpgq_stat_ind = arpgq_stat_ind;
	}

	/**
	 * sets the arpiq_stat_ind value.
	 */
	public void setArpiq_stat_ind(final String arpiq_stat_ind) {
		this.arpiq_stat_ind = arpiq_stat_ind;
	}

	/**
	 * sets the arppd_stat_ind value.
	 */
	public void setArppd_stat_ind(final String arppd_stat_ind) {
		this.arppd_stat_ind = arppd_stat_ind;
	}

	/**
	 * sets the arrbe_stat_ind value.
	 */
	public void setArrbe_stat_ind(final String arrbe_stat_ind) {
		this.arrbe_stat_ind = arrbe_stat_ind;
	}

	/**
	 * sets the arrpd_stat_ind value.
	 */
	public void setArrpd_stat_ind(final String arrpd_stat_ind) {
		this.arrpd_stat_ind = arrpd_stat_ind;
	}

	/**
	 * sets the arrpt_stat_ind value.
	 */
	public void setArrpt_stat_ind(final String arrpt_stat_ind) {
		this.arrpt_stat_ind = arrpt_stat_ind;
	}

	/**
	 * sets the arsod_stat_ind value.
	 */
	public void setArsod_stat_ind(final String arsod_stat_ind) {
		this.arsod_stat_ind = arsod_stat_ind;
	}

	/**
	 * sets the arvad_stat_ind value.
	 */
	public void setArvad_stat_ind(final String arvad_stat_ind) {
		this.arvad_stat_ind = arvad_stat_ind;
	}

	/**
	 * sets the arvat_stat_ind value.
	 */
	public void setArvat_stat_ind(final String arvat_stat_ind) {
		this.arvat_stat_ind = arvat_stat_ind;
	}

	/**
	 * sets the arxgq_stat_ind value.
	 */
	public void setArxgq_stat_ind(final String arxgq_stat_ind) {
		this.arxgq_stat_ind = arxgq_stat_ind;
	}

	/**
	 * sets the arxiq_stat_ind value.
	 */
	public void setArxiq_stat_ind(final String arxiq_stat_ind) {
		this.arxiq_stat_ind = arxiq_stat_ind;
	}

	/**
	 * sets the arrbi_stat_ind value.
	 */
	public void setArrbi_stat_ind(final String arrbi_stat_ind) {
		this.arrbi_stat_ind = arrbi_stat_ind;
	}

	/**
	 * sets the arapa_stat_ind value.
	 */
	public void setArapa_stat_ind(final String arapa_stat_ind) {
		this.arapa_stat_ind = arapa_stat_ind;
	}

	/**
	 * sets the arplr_stat_ind value.
	 */
	public void setArplr_stat_ind(final String arplr_stat_ind) {
		this.arplr_stat_ind = arplr_stat_ind;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public FwDataCriteria[] getDataCriteria() {
		return dataCriteria;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public FwDataCriteria[] getWhereCriteria() {
		return whereCriteria;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public void setDataCriteria(final FwDataCriteria[] criterias) {
		dataCriteria = FWUtils.arrayCopy(criterias);
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public void setWhereCriteria(final FwDataCriteria[] criterias) {
		whereCriteria = FWUtils.arrayCopy(criterias);
	}

	/**
	 * @return Returns the arhca_stat_ind.
	 */
	public String getArhca_stat_ind() {
		return arhca_stat_ind;
	}

	/**
	 * @param arhca_stat_ind
	 *            The arhca_stat_ind to set.
	 */
	public void setArhca_stat_ind(final String arhca_stat_ind) {
		this.arhca_stat_ind = arhca_stat_ind;
	}

	/**
	 * @return Returns the arpcd_stat_ind.
	 */
	public String getArpcd_stat_ind() {
		return arpcd_stat_ind;
	}

	/**
	 * @param arpcd_stat_ind
	 *            The arpcd_stat_ind to set.
	 */
	public void setArpcd_stat_ind(final String arpcd_stat_ind) {
		this.arpcd_stat_ind = arpcd_stat_ind;
	}

	/**
	 * @return Returns the arper_stat_ind.
	 */
	public String getArper_stat_ind() {
		return arper_stat_ind;
	}

	/**
	 * @param arper_stat_ind
	 *            The arper_stat_ind to set.
	 */
	public void setArper_stat_ind(final String arper_stat_ind) {
		this.arper_stat_ind = arper_stat_ind;
	}

	public void setArhoh_stat_ind(final String arhoh_stat_ind) {
		this.arhoh_stat_ind = arhoh_stat_ind;
	}

	public String getArhoh_stat_ind() {
		return arhoh_stat_ind;
	}

	public String getArxfr_stat_ind() {
		return arxfr_stat_ind;
	}

	public void setArxfr_stat_ind(final String arxfr_stat_ind) {
		this.arxfr_stat_ind = arxfr_stat_ind;
	}

	public String getAroaq_stat_ind() {
		return aroaq_stat_ind;
	}

	public void setAroaq_stat_ind(final String aroaq_stat_ind) {
		this.aroaq_stat_ind = aroaq_stat_ind;
	}

	public String getAroac_stat_ind() {
		return aroac_stat_ind;
	}

	public void setAroac_stat_ind(final String aroac_stat_ind) {
		this.aroac_stat_ind = aroac_stat_ind;
	}

	public String getAroas_stat_ind() {
		return aroas_stat_ind;
	}

	public void setAroas_stat_ind(final String aroas_stat_ind) {
		this.aroas_stat_ind = aroas_stat_ind;
	}

	/**
	 * @return the artxi_stat_ind
	 */
	public String getArtxi_stat_ind() {
		return artxi_stat_ind;
	}

	/**
	 * @param artxi_stat_ind the artxi_stat_ind to set
	 */
	public void setArtxi_stat_ind(final String artxi_stat_ind) {
		this.artxi_stat_ind = artxi_stat_ind;
	}

	/**
	 * @return the aritd_stat_ind
	 */
	public String getAritd_stat_ind() {
		return aritd_stat_ind;
	}

	/**
	 * @param aritd_stat_ind the aritd_stat_ind to set
	 */
	public void setAritd_stat_ind(final String aritd_stat_ind) {
		this.aritd_stat_ind = aritd_stat_ind;
	}

	/**
	 * @return the arbtt_stat_ind
	 */
	public String getArbtt_stat_ind() {
		return arbtt_stat_ind;
	}

	/**
	 * @param arbtt_stat_ind the arbtt_stat_ind to set
	 */
	public void setArbtt_stat_ind(final String arbtt_stat_ind) {
		this.arbtt_stat_ind = arbtt_stat_ind;
	}

	/**
	 * @return the arbtd_stat_ind
	 */
	public String getArbtd_stat_ind() {
		return arbtd_stat_ind;
	}

	/**
	 * @param arbtd_stat_ind the arbtd_stat_ind to set
	 */
	public void setArbtd_stat_ind(final String arbtd_stat_ind) {
		this.arbtd_stat_ind = arbtd_stat_ind;
	}

	/**
	 * returns the PrimaryKey object.
	 */
	@Override
	public IPrimaryKey getPrimaryKey() {
		final RMC_DRVR_PrimaryKey key = new RMC_DRVR_PrimaryKey();
		key.setApp_num(getApp_num());

		return key;
	}

	/**
	 * returns the string value of cargo.
	 */
	@Override
	public String inspectCargo() {
		return new StringBuilder().append("RMC_DRVR: ").append("app_num=").append(app_num).append("aracd_stat_ind=").append(aracd_stat_ind)
				.append("arcat_stat_ind=").append(arcat_stat_ind).append("arhap_stat_ind=").append(arhap_stat_ind).append("arhcs_stat_ind=")
				.append(arhcs_stat_ind).append("arhdd_stat_ind=").append(arhdd_stat_ind).append("arhde_stat_ind=").append(arhde_stat_ind)
				.append("arhis_stat_ind=").append(arhis_stat_ind).append("arhma_stat_ind=").append(arhma_stat_ind).append("arhmd_stat_ind=")
				.append(arhmd_stat_ind).append("arhmi_stat_ind=").append(arhmi_stat_ind).append("arhmo_stat_ind=").append(arhmo_stat_ind)
				.append("arhpd_stat_ind=").append(arhpd_stat_ind).append("arhpg_stat_ind=").append(arhpg_stat_ind).append("arhrl_stat_ind=")
				.append(arhrl_stat_ind).append("arhse_stat_ind=").append(arhse_stat_ind).append("arjid_stat_ind=").append(arjid_stat_ind)
				.append("arehi_stat_ind=").append(arehi_stat_ind).append("arcfn_stat_ind=").append(arcfn_stat_ind).append("arbcn_stat_ind=").append(arbcn_stat_ind).append("arjis_stat_ind=")
				.append(arjis_stat_ind).append("arjsd_stat_ind=").append(arjsd_stat_ind).append("arjse_stat_ind=").append(arjse_stat_ind)
				.append("arprs_stat_ind=").append(arprs_stat_ind).append("artky_stat_ind=").append(artky_stat_ind).append("aruid_stat_ind=")
				.append(aruid_stat_ind).append("aruii_stat_ind=").append(aruii_stat_ind).append("aruis_stat_ind=").append(aruis_stat_ind)
				.append("aruit_stat_ind=").append(aruit_stat_ind).append("arxhd_stat_ind=").append(arxhd_stat_ind).append("arxhi_stat_ind=")
				.append(arxhi_stat_ind).append("arxhs_stat_ind=").append(arxhs_stat_ind).append("arxhu_stat_ind=").append(arxhu_stat_ind)
				.append("arxud_stat_ind=").append(arxud_stat_ind).append("hscso_stat_ind=").append(hscso_stat_ind).append("hsher_stat_ind=")
				.append(hsher_stat_ind).append("hshmo_stat_ind=").append(hshmo_stat_ind).append("aracs_stat_ind=").append(aracs_stat_ind)
				.append("aragq_stat_ind=").append(aragq_stat_ind).append("araiq_stat_ind=").append(araiq_stat_ind).append("arasm_stat_ind=")
				.append(arasm_stat_ind).append("arbad_stat_ind=").append(arbad_stat_ind).append("arbat_stat_ind=").append(arbat_stat_ind)
				.append("ardcd_stat_ind=").append(ardcd_stat_ind).append("ardfd_stat_ind=").append(ardfd_stat_ind).append("arfas_stat_ind=")
				.append(arfas_stat_ind).append("arhcd_stat_ind=").append(arhcd_stat_ind).append("arhod_stat_ind=").append(arhod_stat_ind)
				.append("ariwe_stat_ind=").append(ariwe_stat_ind).append("arjgq_stat_ind=").append(arjgq_stat_ind).append("arlad_stat_ind=")
				.append(arlad_stat_ind).append("arlat_stat_ind=").append(arlat_stat_ind).append("arlid_stat_ind=").append(arlid_stat_ind)
				.append("arlit_stat_ind=").append(arlit_stat_ind).append("armap_stat_ind=").append(armap_stat_ind).append("armbd_stat_ind=")
				.append(armbd_stat_ind).append("arobc_stat_ind=").append(arobc_stat_ind).append("arobi_stat_ind=").append(arobi_stat_ind)
				.append("arobq_stat_ind=").append(arobq_stat_ind).append("arobs_stat_ind=").append(arobs_stat_ind).append("aroiq_stat_ind=")
				.append(aroiq_stat_ind).append("arpcs_stat_ind=").append(arpcs_stat_ind).append("arpgq_stat_ind=").append(arpgq_stat_ind)
				.append("arpiq_stat_ind=").append(arpiq_stat_ind).append("arppd_stat_ind=").append(arppd_stat_ind).append("arrbe_stat_ind=")
				.append(arrbe_stat_ind).append("arrpd_stat_ind=").append(arrpd_stat_ind).append("arrpt_stat_ind=").append(arrpt_stat_ind)
				.append("arsod_stat_ind=").append(arsod_stat_ind).append("arvad_stat_ind=").append(arvad_stat_ind).append("arvat_stat_ind=")
				.append(arvat_stat_ind).append("arxgq_stat_ind=").append(arxgq_stat_ind).append("arxiq_stat_ind=").append(arxiq_stat_ind)
				.append("arrbi_stat_ind=").append(arrbi_stat_ind).append("arapa_stat_ind=").append(arapa_stat_ind).append("arplr_stat_ind=")
				.append(arplr_stat_ind).append("arhca_stat_ind=").append(arhca_stat_ind).append("arpcd_stat_ind=").append(arpcd_stat_ind)
				.append("arper_stat_ind=").append(arper_stat_ind).append("aravd_stat_ind=").append(aravd_stat_ind).append("ardgp_stat_ind=")
				.append(ardgp_stat_ind).append("arsum_stat_ind=").append(arsum_stat_ind).append("arhmx_stat_ind=").append(arhmx_stat_ind)
				.append("armed_stat_ind=").append(armed_stat_ind).append("arhps_stat_ind=").append(arhps_stat_ind).append("arhos_stat_ind=")
				.append(arhos_stat_ind).append("arnur_stat_ind=").append(arnur_stat_ind).append("arofs_stat_ind=").append(arofs_stat_ind)
				.append("arort_stat_ind=").append(arort_stat_ind).append("arord_stat_ind=").append(arord_stat_ind).append("ariki_stat_ind=")
				.append(ariki_stat_ind).append("arhbt_stat_ind=").append(arhbt_stat_ind).append("arbbq_stat_ind=").append(arbbq_stat_ind)
				.append("arccc_stat_ind=").append(arccc_stat_ind).append("arcsc_stat_ind=").append(arcsc_stat_ind).append("armbb_stat_ind=")
				.append(armbb_stat_ind).append("arbbs_stat_ind=").append(arbbs_stat_ind).append("arcta_stat_ind=").append(arcta_stat_ind)
				.append("arcon_stat_ind=").append(arcon_stat_ind).append("arafp_stat_ind=").append(arafp_stat_ind).append("armaa_stat_ind=")
				.append(armaa_stat_ind).append("aripi_stat_ind=").append(aripi_stat_ind).append("armov_stat_ind=").append(armov_stat_ind)
				.append("ardoc_stat_ind=").append(ardoc_stat_ind).append("ararp_stat_ind=").append(ararp_stat_ind).append("arfin_stat_ind=")
				.append(arfin_stat_ind).append("aridp_stat_ind=").append(aridp_stat_ind).append("arbus_stat_ind=").append(arbus_stat_ind)
				.append("arhpa_stat_ind=").append(arhpa_stat_ind).append("arlhi_stat_ind=").append(arlhi_stat_ind).append("aritd_stat_ind=")
				.append(aritd_stat_ind).append("arbtt_stat_ind=").append(arbtt_stat_ind).append("arbtd_stat_ind=").append(arbtd_stat_ind)
				.append("arhin_stat_ind=").append(arhin_stat_ind).append("arohi_stat_ind=").append(arohi_stat_ind).append("artxi_stat_ind=")
				.append(artxi_stat_ind).append("artdp_stat_ind=").append(artdp_stat_ind).append("artax_stat_ind=").append(artax_stat_ind)
				.append("arpre_stat_ind=").append(arpre_stat_ind).append("arrld_stat_ind=").append(arrld_stat_ind).toString();
	}

	/**
	 * compares the given cargo with this cargo and returns the changed
	 * attribute-value Map.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map compareAttributes(final RMC_DRVR_Cargo aCargo) {
		final Map changedAttributeValue = new HashMap();
		if (!((aCargo.getApp_num() == null) && (app_num == null)) && !((aCargo.getApp_num() != null) && aCargo.getApp_num().equals(app_num))) {
			changedAttributeValue.put("app_num", aCargo.getApp_num());
		}
		if (!((aCargo.getAripi_stat_ind() == null) && (aripi_stat_ind == null))
				&& !((aCargo.getAripi_stat_ind() != null) && aCargo.getAripi_stat_ind().equals(aripi_stat_ind))) {
			changedAttributeValue.put("aripi_stat_ind", aCargo.getAripi_stat_ind());
		}
		if (!((aCargo.getAracd_stat_ind() == null) && (aracd_stat_ind == null))
				&& !((aCargo.getAracd_stat_ind() != null) && aCargo.getAracd_stat_ind().equals(aracd_stat_ind))) {
			changedAttributeValue.put("aracd_stat_ind", aCargo.getAracd_stat_ind());
		}
		if (!((aCargo.getArcat_stat_ind() == null) && (arcat_stat_ind == null))
				&& !((aCargo.getArcat_stat_ind() != null) && aCargo.getArcat_stat_ind().equals(arcat_stat_ind))) {
			changedAttributeValue.put("arcat_stat_ind", aCargo.getArcat_stat_ind());
		}
		if (!((aCargo.getArhap_stat_ind() == null) && (arhap_stat_ind == null))
				&& !((aCargo.getArhap_stat_ind() != null) && aCargo.getArhap_stat_ind().equals(arhap_stat_ind))) {
			changedAttributeValue.put("arhap_stat_ind", aCargo.getArhap_stat_ind());
		}
		if (!((aCargo.getArhcs_stat_ind() == null) && (arhcs_stat_ind == null))
				&& !((aCargo.getArhcs_stat_ind() != null) && aCargo.getArhcs_stat_ind().equals(arhcs_stat_ind))) {
			changedAttributeValue.put("arhcs_stat_ind", aCargo.getArhcs_stat_ind());
		}
		if (!((aCargo.getArhdd_stat_ind() == null) && (arhdd_stat_ind == null))
				&& !((aCargo.getArhdd_stat_ind() != null) && aCargo.getArhdd_stat_ind().equals(arhdd_stat_ind))) {
			changedAttributeValue.put("arhdd_stat_ind", aCargo.getArhdd_stat_ind());
		}
		if (!((aCargo.getArhde_stat_ind() == null) && (arhde_stat_ind == null))
				&& !((aCargo.getArhde_stat_ind() != null) && aCargo.getArhde_stat_ind().equals(arhde_stat_ind))) {
			changedAttributeValue.put("arhde_stat_ind", aCargo.getArhde_stat_ind());
		}
		if (!((aCargo.getArhis_stat_ind() == null) && (arhis_stat_ind == null))
				&& !((aCargo.getArhis_stat_ind() != null) && aCargo.getArhis_stat_ind().equals(arhis_stat_ind))) {
			changedAttributeValue.put("arhis_stat_ind", aCargo.getArhis_stat_ind());
		}
		if (!((aCargo.getArhma_stat_ind() == null) && (arhma_stat_ind == null))
				&& !((aCargo.getArhma_stat_ind() != null) && aCargo.getArhma_stat_ind().equals(arhma_stat_ind))) {
			changedAttributeValue.put("arhma_stat_ind", aCargo.getArhma_stat_ind());
		}
		if (!((aCargo.getArhmd_stat_ind() == null) && (arhmd_stat_ind == null))
				&& !((aCargo.getArhmd_stat_ind() != null) && aCargo.getArhmd_stat_ind().equals(arhmd_stat_ind))) {
			changedAttributeValue.put("arhmd_stat_ind", aCargo.getArhmd_stat_ind());
		}
		if (!((aCargo.getArhmi_stat_ind() == null) && (arhmi_stat_ind == null))
				&& !((aCargo.getArhmi_stat_ind() != null) && aCargo.getArhmi_stat_ind().equals(arhmi_stat_ind))) {
			changedAttributeValue.put("arhmi_stat_ind", aCargo.getArhmi_stat_ind());
		}
		if (!((aCargo.getArhmo_stat_ind() == null) && (arhmo_stat_ind == null))
				&& !((aCargo.getArhmo_stat_ind() != null) && aCargo.getArhmo_stat_ind().equals(arhmo_stat_ind))) {
			changedAttributeValue.put("arhmo_stat_ind", aCargo.getArhmo_stat_ind());
		}
		if (!((aCargo.getArhpd_stat_ind() == null) && (arhpd_stat_ind == null))
				&& !((aCargo.getArhpd_stat_ind() != null) && aCargo.getArhpd_stat_ind().equals(arhpd_stat_ind))) {
			changedAttributeValue.put("arhpd_stat_ind", aCargo.getArhpd_stat_ind());
		}
		if (!((aCargo.getArhpg_stat_ind() == null) && (arhpg_stat_ind == null))
				&& !((aCargo.getArhpg_stat_ind() != null) && aCargo.getArhpg_stat_ind().equals(arhpg_stat_ind))) {
			changedAttributeValue.put("arhpg_stat_ind", aCargo.getArhpg_stat_ind());
		}
		if (!((aCargo.getArhrl_stat_ind() == null) && (arhrl_stat_ind == null))
				&& !((aCargo.getArhrl_stat_ind() != null) && aCargo.getArhrl_stat_ind().equals(arhrl_stat_ind))) {
			changedAttributeValue.put("arhrl_stat_ind", aCargo.getArhrl_stat_ind());
		}
		if (!((aCargo.getArhse_stat_ind() == null) && (arhse_stat_ind == null))
				&& !((aCargo.getArhse_stat_ind() != null) && aCargo.getArhse_stat_ind().equals(arhse_stat_ind))) {
			changedAttributeValue.put("arhse_stat_ind", aCargo.getArhse_stat_ind());
		}
		if (!((aCargo.getArjid_stat_ind() == null) && (arjid_stat_ind == null))
				&& !((aCargo.getArjid_stat_ind() != null) && aCargo.getArjid_stat_ind().equals(arjid_stat_ind))) {
			changedAttributeValue.put("arjid_stat_ind", aCargo.getArjid_stat_ind());
		}
		if (!((aCargo.getArehi_stat_ind() == null) && (arehi_stat_ind == null))
				&& !((aCargo.getArehi_stat_ind() != null) && aCargo.getArehi_stat_ind().equals(arehi_stat_ind))) {
			changedAttributeValue.put("arehi_stat_ind", aCargo.getArehi_stat_ind());
		}
		if (!((aCargo.getArjis_stat_ind() == null) && (arjis_stat_ind == null))
				&& !((aCargo.getArjis_stat_ind() != null) && aCargo.getArjis_stat_ind().equals(arjis_stat_ind))) {
			changedAttributeValue.put("arjis_stat_ind", aCargo.getArjis_stat_ind());
		}
		if (!((aCargo.getArjsd_stat_ind() == null) && (arjsd_stat_ind == null))
				&& !((aCargo.getArjsd_stat_ind() != null) && aCargo.getArjsd_stat_ind().equals(arjsd_stat_ind))) {
			changedAttributeValue.put("arjsd_stat_ind", aCargo.getArjsd_stat_ind());
		}
		if (!((aCargo.getArjse_stat_ind() == null) && (arjse_stat_ind == null))
				&& !((aCargo.getArjse_stat_ind() != null) && aCargo.getArjse_stat_ind().equals(arjse_stat_ind))) {
			changedAttributeValue.put("arjse_stat_ind", aCargo.getArjse_stat_ind());
		}
		if (!((aCargo.getArprs_stat_ind() == null) && (arprs_stat_ind == null))
				&& !((aCargo.getArprs_stat_ind() != null) && aCargo.getArprs_stat_ind().equals(arprs_stat_ind))) {
			changedAttributeValue.put("arprs_stat_ind", aCargo.getArprs_stat_ind());
		}
		if (!((aCargo.getArtky_stat_ind() == null) && (artky_stat_ind == null))
				&& !((aCargo.getArtky_stat_ind() != null) && aCargo.getArtky_stat_ind().equals(artky_stat_ind))) {
			changedAttributeValue.put("artky_stat_ind", aCargo.getArtky_stat_ind());
		}
		if (!((aCargo.getAruid_stat_ind() == null) && (aruid_stat_ind == null))
				&& !((aCargo.getAruid_stat_ind() != null) && aCargo.getAruid_stat_ind().equals(aruid_stat_ind))) {
			changedAttributeValue.put("aruid_stat_ind", aCargo.getAruid_stat_ind());
		}
		if (!((aCargo.getAruii_stat_ind() == null) && (aruii_stat_ind == null))
				&& !((aCargo.getAruii_stat_ind() != null) && aCargo.getAruii_stat_ind().equals(aruii_stat_ind))) {
			changedAttributeValue.put("aruii_stat_ind", aCargo.getAruii_stat_ind());
		}
		if (!((aCargo.getAruis_stat_ind() == null) && (aruis_stat_ind == null))
				&& !((aCargo.getAruis_stat_ind() != null) && aCargo.getAruis_stat_ind().equals(aruis_stat_ind))) {
			changedAttributeValue.put("aruis_stat_ind", aCargo.getAruis_stat_ind());
		}
		if (!((aCargo.getAruit_stat_ind() == null) && (aruit_stat_ind == null))
				&& !((aCargo.getAruit_stat_ind() != null) && aCargo.getAruit_stat_ind().equals(aruit_stat_ind))) {
			changedAttributeValue.put("aruit_stat_ind", aCargo.getAruit_stat_ind());
		}
		if (!((aCargo.getArxhd_stat_ind() == null) && (arxhd_stat_ind == null))
				&& !((aCargo.getArxhd_stat_ind() != null) && aCargo.getArxhd_stat_ind().equals(arxhd_stat_ind))) {
			changedAttributeValue.put("arxhd_stat_ind", aCargo.getArxhd_stat_ind());
		}
		if (!((aCargo.getArxhi_stat_ind() == null) && (arxhi_stat_ind == null))
				&& !((aCargo.getArxhi_stat_ind() != null) && aCargo.getArxhi_stat_ind().equals(arxhi_stat_ind))) {
			changedAttributeValue.put("arxhi_stat_ind", aCargo.getArxhi_stat_ind());
		}
		if (!((aCargo.getArxhs_stat_ind() == null) && (arxhs_stat_ind == null))
				&& !((aCargo.getArxhs_stat_ind() != null) && aCargo.getArxhs_stat_ind().equals(arxhs_stat_ind))) {
			changedAttributeValue.put("arxhs_stat_ind", aCargo.getArxhs_stat_ind());
		}
		if (!((aCargo.getArxhu_stat_ind() == null) && (arxhu_stat_ind == null))
				&& !((aCargo.getArxhu_stat_ind() != null) && aCargo.getArxhu_stat_ind().equals(arxhu_stat_ind))) {
			changedAttributeValue.put("arxhu_stat_ind", aCargo.getArxhu_stat_ind());
		}
		if (!((aCargo.getArxud_stat_ind() == null) && (arxud_stat_ind == null))
				&& !((aCargo.getArxud_stat_ind() != null) && aCargo.getArxud_stat_ind().equals(arxud_stat_ind))) {
			changedAttributeValue.put("arxud_stat_ind", aCargo.getArxud_stat_ind());
		}
		if (!((aCargo.getHshmo_stat_ind() == null) && (hshmo_stat_ind == null))
				&& !((aCargo.getHshmo_stat_ind() != null) && aCargo.getHshmo_stat_ind().equals(hshmo_stat_ind))) {
			changedAttributeValue.put("hshmo_stat_ind", aCargo.getHshmo_stat_ind());
		}
		if (!((aCargo.getHscso_stat_ind() == null) && (hscso_stat_ind == null))
				&& !((aCargo.getHscso_stat_ind() != null) && aCargo.getHscso_stat_ind().equals(hscso_stat_ind))) {
			changedAttributeValue.put("hscso_stat_ind", aCargo.getHscso_stat_ind());
		}
		if (!((aCargo.getHsher_stat_ind() == null) && (hsher_stat_ind == null))
				&& !((aCargo.getHsher_stat_ind() != null) && aCargo.getHsher_stat_ind().equals(hsher_stat_ind))) {
			changedAttributeValue.put("hsher_stat_ind", aCargo.getHsher_stat_ind());
		}
		if (!((aCargo.getArplr_stat_ind() == null) && (arplr_stat_ind == null))
				&& !((aCargo.getArplr_stat_ind() != null) && aCargo.getArplr_stat_ind().equals(arplr_stat_ind))) {
			changedAttributeValue.put("arplr_stat_ind", aCargo.getArplr_stat_ind());
		}
		if (!((aCargo.getArapa_stat_ind() == null) && (arapa_stat_ind == null))
				&& !((aCargo.getArapa_stat_ind() != null) && aCargo.getArapa_stat_ind().equals(arapa_stat_ind))) {
			changedAttributeValue.put("arapa_stat_ind", aCargo.getArapa_stat_ind());
		}
		if (!((aCargo.getArhca_stat_ind() == null) && (arhca_stat_ind == null))
				&& !((aCargo.getArhca_stat_ind() != null) && aCargo.getArhca_stat_ind().equals(arhca_stat_ind))) {
			changedAttributeValue.put("arhca_stat_ind", aCargo.getArhca_stat_ind());
		}
		if (!((aCargo.getArpcd_stat_ind() == null) && (arpcd_stat_ind == null))
				&& !((aCargo.getArpcd_stat_ind() != null) && aCargo.getArpcd_stat_ind().equals(arpcd_stat_ind))) {
			changedAttributeValue.put("arpcd_stat_ind", aCargo.getArpcd_stat_ind());
		}
		if (!((aCargo.getArper_stat_ind() == null) && (arper_stat_ind == null))
				&& !((aCargo.getArper_stat_ind() != null) && aCargo.getArper_stat_ind().equals(arper_stat_ind))) {
			changedAttributeValue.put("arper_stat_ind", aCargo.getArper_stat_ind());
		}
		if (!((aCargo.getArhoh_stat_ind() == null) && (arhoh_stat_ind == null))
				&& !((aCargo.getArhoh_stat_ind() != null) && aCargo.getArhoh_stat_ind().equals(arhoh_stat_ind))) {
			changedAttributeValue.put("arhoh_stat_ind", aCargo.getArhoh_stat_ind());
		}
		if (!((aCargo.getAroaq_stat_ind() == null) && (aroaq_stat_ind == null))
				&& !((aCargo.getAroaq_stat_ind() != null) && aCargo.getAroaq_stat_ind().equals(aroaq_stat_ind))) {
			changedAttributeValue.put("aroaq_stat_ind", aCargo.getAroaq_stat_ind());
		}
		if (!((aCargo.getAroac_stat_ind() == null) && (aroac_stat_ind == null))
				&& !((aCargo.getAroac_stat_ind() != null) && aCargo.getAroac_stat_ind().equals(aroac_stat_ind))) {
			changedAttributeValue.put("aroac_stat_ind", aCargo.getAroac_stat_ind());
		}
		if (!((aCargo.getAroas_stat_ind() == null) && (aroas_stat_ind == null))
				&& !((aCargo.getAroas_stat_ind() != null) && aCargo.getAroas_stat_ind().equals(aroas_stat_ind))) {
			changedAttributeValue.put("aroas_stat_ind", aCargo.getAroas_stat_ind());
		}
		if (!((aCargo.getAravd_stat_ind() == null) && (aravd_stat_ind == null))
				&& !((aCargo.getAravd_stat_ind() != null) && aCargo.getAravd_stat_ind().equals(aravd_stat_ind))) {
			changedAttributeValue.put("aravd_stat_ind", aCargo.getAravd_stat_ind());
		}
		if (!((aCargo.getArdgp_stat_ind() == null) && (ardgp_stat_ind == null))
				&& !((aCargo.getArdgp_stat_ind() != null) && aCargo.getArdgp_stat_ind().equals(ardgp_stat_ind))) {
			changedAttributeValue.put("ardgp_stat_ind", aCargo.getArdgp_stat_ind());
		}
		if (!((aCargo.getArhbt_stat_ind() == null) && (arhbt_stat_ind == null))
				&& !((aCargo.getArhbt_stat_ind() != null) && aCargo.getArhbt_stat_ind().equals(arhbt_stat_ind))) {
			changedAttributeValue.put("arhbt_stat_ind", aCargo.getArhbt_stat_ind());
		}
		if (!((aCargo.getArbbq_stat_ind() == null) && (arbbq_stat_ind == null))
				&& !((aCargo.getArbbq_stat_ind() != null) && aCargo.getArbbq_stat_ind().equals(arbbq_stat_ind))) {
			changedAttributeValue.put("arbbq_stat_ind", aCargo.getArbbq_stat_ind());
		}
		if (!((aCargo.getArccc_stat_ind() == null) && (arccc_stat_ind == null))
				&& !((aCargo.getArccc_stat_ind() != null) && aCargo.getArccc_stat_ind().equals(arccc_stat_ind))) {
			changedAttributeValue.put("arccc_stat_ind", aCargo.getArccc_stat_ind());
		}
		if (!((aCargo.getArcsc_stat_ind() == null) && (arcsc_stat_ind == null))
				&& !((aCargo.getArcsc_stat_ind() != null) && aCargo.getArcsc_stat_ind().equals(arcsc_stat_ind))) {
			changedAttributeValue.put("arcsc_stat_ind", aCargo.getArcsc_stat_ind());
		}
		if (!((aCargo.getArmbb_stat_ind() == null) && (armbb_stat_ind == null))
				&& !((aCargo.getArmbb_stat_ind() != null) && aCargo.getArmbb_stat_ind().equals(armbb_stat_ind))) {
			changedAttributeValue.put("armbb_stat_ind", aCargo.getArmbb_stat_ind());
		}
		if (!((aCargo.getArbbs_stat_ind() == null) && (arbbs_stat_ind == null))
				&& !((aCargo.getArbbs_stat_ind() != null) && aCargo.getArbbs_stat_ind().equals(arbbs_stat_ind))) {
			changedAttributeValue.put("arbbs_stat_ind", aCargo.getArbbs_stat_ind());
		}
		if (!((aCargo.getArsum_stat_ind() == null) && (arsum_stat_ind == null))
				&& !((aCargo.getArsum_stat_ind() != null) && aCargo.getArsum_stat_ind().equals(arsum_stat_ind))) {
			changedAttributeValue.put("arsum_stat_ind", aCargo.getArsum_stat_ind());
		}
		if (!((aCargo.getArhmx_stat_ind() == null) && (arhmx_stat_ind == null))
				&& !((aCargo.getArhmx_stat_ind() != null) && aCargo.getArhmx_stat_ind().equals(arhmx_stat_ind))) {
			changedAttributeValue.put("arhmx_stat_ind", aCargo.getArhmx_stat_ind());
		}
		if (!((aCargo.getArmed_stat_ind() == null) && (armed_stat_ind == null))
				&& !((aCargo.getArmed_stat_ind() != null) && aCargo.getArmed_stat_ind().equals(armed_stat_ind))) {
			changedAttributeValue.put("armed_stat_ind", aCargo.getArmed_stat_ind());
		}
		if (!((aCargo.getArhps_stat_ind() == null) && (arhps_stat_ind == null))
				&& !((aCargo.getArhps_stat_ind() != null) && aCargo.getArhps_stat_ind().equals(arhps_stat_ind))) {
			changedAttributeValue.put("arhps_stat_ind", aCargo.getArhps_stat_ind());
		}
		if (!((aCargo.getArhos_stat_ind() == null) && (arhos_stat_ind == null))
				&& !((aCargo.getArhos_stat_ind() != null) && aCargo.getArhos_stat_ind().equals(arhos_stat_ind))) {
			changedAttributeValue.put("arhos_stat_ind", aCargo.getArhos_stat_ind());
		}
		if (!((aCargo.getArnur_stat_ind() == null) && (arnur_stat_ind == null))
				&& !((aCargo.getArnur_stat_ind() != null) && aCargo.getArnur_stat_ind().equals(arnur_stat_ind))) {
			changedAttributeValue.put("arnur_stat_ind", aCargo.getArnur_stat_ind());
		}
		if (!((aCargo.getArofs_stat_ind() == null) && (arofs_stat_ind == null))
				&& !((aCargo.getArofs_stat_ind() != null) && aCargo.getArofs_stat_ind().equals(arofs_stat_ind))) {
			changedAttributeValue.put("arofs_stat_ind", aCargo.getArofs_stat_ind());
		}
		if (!((aCargo.getArort_stat_ind() == null) && (arort_stat_ind == null))
				&& !((aCargo.getArort_stat_ind() != null) && aCargo.getArort_stat_ind().equals(arort_stat_ind))) {
			changedAttributeValue.put("arort_stat_ind", aCargo.getArort_stat_ind());
		}
		if (!((aCargo.getArord_stat_ind() == null) && (arord_stat_ind == null))
				&& !((aCargo.getArord_stat_ind() != null) && aCargo.getArord_stat_ind().equals(arord_stat_ind))) {
			changedAttributeValue.put("arord_stat_ind", aCargo.getArord_stat_ind());
		}
		if (!((aCargo.getAriki_stat_ind() == null) && (ariki_stat_ind == null))
				&& !((aCargo.getAriki_stat_ind() != null) && aCargo.getAriki_stat_ind().equals(ariki_stat_ind))) {
			changedAttributeValue.put("ariki_stat_ind", aCargo.getAriki_stat_ind());
		}
		if (!((aCargo.getArcta_stat_ind() == null) && (arcta_stat_ind == null))
				&& !((aCargo.getArcta_stat_ind() != null) && aCargo.getArcta_stat_ind().equals(arcta_stat_ind))) {
			changedAttributeValue.put("arcta_stat_ind", aCargo.getArcta_stat_ind());
		}
		if (!((aCargo.getArcon_stat_ind() == null) && (arcon_stat_ind == null))
				&& !((aCargo.getArcon_stat_ind() != null) && aCargo.getArcon_stat_ind().equals(arcon_stat_ind))) {
			changedAttributeValue.put("arcon_stat_ind", aCargo.getArcon_stat_ind());
		}
		if (!((aCargo.getArafp_stat_ind() == null) && (arafp_stat_ind == null))
				&& !((aCargo.getArafp_stat_ind() != null) && aCargo.getArafp_stat_ind().equals(arafp_stat_ind))) {
			changedAttributeValue.put("arafp_stat_ind", aCargo.getArafp_stat_ind());
		}
		if (!((aCargo.getArmaa_stat_ind() == null) && (armaa_stat_ind == null))
				&& !((aCargo.getArmaa_stat_ind() != null) && aCargo.getArmaa_stat_ind().equals(armaa_stat_ind))) {
			changedAttributeValue.put("armaa_stat_ind", aCargo.getArmaa_stat_ind());
		}
		if (!((aCargo.getArmov_stat_ind() == null) && (armov_stat_ind == null))
				&& !((aCargo.getArmov_stat_ind() != null) && aCargo.getArmov_stat_ind().equals(armov_stat_ind))) {
			changedAttributeValue.put("armov_stat_ind", aCargo.getArmov_stat_ind());
		}
		if (!((aCargo.getArdoc_stat_ind() == null) && (ardoc_stat_ind == null))
				&& !((aCargo.getArdoc_stat_ind() != null) && aCargo.getArdoc_stat_ind().equals(ardoc_stat_ind))) {
			changedAttributeValue.put("ardoc_stat_ind", aCargo.getArdoc_stat_ind());
		}
		if (!((aCargo.getArarp_stat_ind() == null) && (ararp_stat_ind == null))
				&& !((aCargo.getArarp_stat_ind() != null) && aCargo.getArarp_stat_ind().equals(ararp_stat_ind))) {
			changedAttributeValue.put("ararp_stat_ind", aCargo.getArarp_stat_ind());
		}
		if (!((aCargo.getArfin_stat_ind() == null) && (arfin_stat_ind == null))
				&& !((aCargo.getArfin_stat_ind() != null) && aCargo.getArfin_stat_ind().equals(arfin_stat_ind))) {
			changedAttributeValue.put("arfin_stat_ind", aCargo.getArfin_stat_ind());
		}
		if (!((aCargo.getAridp_stat_ind() == null) && (aridp_stat_ind == null))
				&& !((aCargo.getAridp_stat_ind() != null) && aCargo.getAridp_stat_ind().equals(aridp_stat_ind))) {
			changedAttributeValue.put("aridp_stat_ind", aCargo.getAridp_stat_ind());
		}
		if (!((aCargo.getArbus_stat_ind() == null) && (arbus_stat_ind == null))
				&& !((aCargo.getArbus_stat_ind() != null) && aCargo.getArbus_stat_ind().equals(arbus_stat_ind))) {
			changedAttributeValue.put("arbus_stat_ind", aCargo.getArbus_stat_ind());
		}
		if (!((aCargo.getArhpa_stat_ind() == null) && (arhpa_stat_ind == null))
				&& !((aCargo.getArhpa_stat_ind() != null) && aCargo.getArhpa_stat_ind().equals(arhpa_stat_ind))) {
			changedAttributeValue.put("arhpa_stat_ind", aCargo.getArhpa_stat_ind());
		}
		if (!((aCargo.getArlhi_stat_ind() == null) && (arlhi_stat_ind == null))
				&& !((aCargo.getArlhi_stat_ind() != null) && aCargo.getArlhi_stat_ind().equals(arlhi_stat_ind))) {
			changedAttributeValue.put("arlhi_stat_ind", aCargo.getArlhi_stat_ind());
		}
		if (!((aCargo.getAritd_stat_ind() == null) && (aritd_stat_ind == null))
				&& !((aCargo.getAritd_stat_ind() != null) && aCargo.getAritd_stat_ind().equals(aritd_stat_ind))) {
			changedAttributeValue.put("aritd_stat_ind", aCargo.getAritd_stat_ind());
		}
		if (!((aCargo.getArbtt_stat_ind() == null) && (arbtt_stat_ind == null))
				&& !((aCargo.getArbtt_stat_ind() != null) && aCargo.getArbtt_stat_ind().equals(arbtt_stat_ind))) {
			changedAttributeValue.put("arbtt_stat_ind", aCargo.getArbtt_stat_ind());
		}
		if (!((aCargo.getArbtd_stat_ind() == null) && (arbtd_stat_ind == null))
				&& !((aCargo.getArbtd_stat_ind() != null) && aCargo.getArbtd_stat_ind().equals(arbtd_stat_ind))) {
			changedAttributeValue.put("arbtd_stat_ind", aCargo.getArbtd_stat_ind());
		}
		if (!((aCargo.getArhin_stat_ind() == null) && (arhin_stat_ind == null))
				&& !((aCargo.getArhin_stat_ind() != null) && aCargo.getArhin_stat_ind().equals(arhin_stat_ind))) {
			changedAttributeValue.put("arhin_stat_ind", aCargo.getArhin_stat_ind());
		}

		if (!((aCargo.getArohi_stat_ind() == null) && (arohi_stat_ind == null))
				&& !((aCargo.getArohi_stat_ind() != null) && aCargo.getArohi_stat_ind().equals(arohi_stat_ind))) {
			changedAttributeValue.put("arohi_stat_ind", aCargo.getArohi_stat_ind());
		}
		if (!((aCargo.getArtxi_stat_ind() == null) && (artxi_stat_ind == null))
				&& !((aCargo.getArtxi_stat_ind() != null) && aCargo.getArtxi_stat_ind().equals(artxi_stat_ind))) {
			changedAttributeValue.put("artxi_stat_ind", aCargo.getArtxi_stat_ind());
		}
		if (!((aCargo.getArtdp_stat_ind() == null) && (artdp_stat_ind == null))
				&& !((aCargo.getArtdp_stat_ind() != null) && aCargo.getArtdp_stat_ind().equals(artdp_stat_ind))) {
			changedAttributeValue.put("artdp_stat_ind", aCargo.getArtdp_stat_ind());
		}
		if (!((aCargo.getArtax_stat_ind() == null) && (artax_stat_ind == null))
				&& !((aCargo.getArtax_stat_ind() != null) && aCargo.getArtax_stat_ind().equals(artax_stat_ind))) {
			changedAttributeValue.put("artax_stat_ind", aCargo.getArtax_stat_ind());
		}
		if (!((aCargo.getArpre_stat_ind() == null) && (arpre_stat_ind == null))
				&& !((aCargo.getArpre_stat_ind() != null) && aCargo.getArpre_stat_ind().equals(arpre_stat_ind))) {
			changedAttributeValue.put("arpre_stat_ind", aCargo.getArpre_stat_ind());
		}

		if (!((aCargo.getArrld_stat_ind() == null) && (arrld_stat_ind == null))
				&& !((aCargo.getArrld_stat_ind() != null) && aCargo.getArrld_stat_ind().equals(arrld_stat_ind))) {
			changedAttributeValue.put("arrld_stat_ind", aCargo.getArrld_stat_ind());
		}
		if (!((aCargo.getArcfn_stat_ind() == null) && (arcfn_stat_ind == null))
				&& !((aCargo.getArcfn_stat_ind() != null) && aCargo.getArcfn_stat_ind().equals(arcfn_stat_ind))) {
			changedAttributeValue.put("arcfn_stat_ind", aCargo.getArcfn_stat_ind());
		}
		if (!((aCargo.getArbcn_stat_ind() == null) && (arbcn_stat_ind == null))
				&& !((aCargo.getArbcn_stat_ind() != null) && aCargo.getArbcn_stat_ind().equals(arbcn_stat_ind))) {
			changedAttributeValue.put("arbcn_stat_ind", aCargo.getArbcn_stat_ind());
		}
		return changedAttributeValue;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((app_num == null) ? 0 : app_num.trim().hashCode());
		result = (prime * result) + ((aracd_stat_ind == null) ? 0 : aracd_stat_ind.trim().hashCode());
		result = (prime * result) + ((aracs_stat_ind == null) ? 0 : aracs_stat_ind.trim().hashCode());
		result = (prime * result) + ((arafp_stat_ind == null) ? 0 : arafp_stat_ind.trim().hashCode());
		result = (prime * result) + ((aragq_stat_ind == null) ? 0 : aragq_stat_ind.trim().hashCode());
		result = (prime * result) + ((araiq_stat_ind == null) ? 0 : araiq_stat_ind.trim().hashCode());
		result = (prime * result) + ((arapa_stat_ind == null) ? 0 : arapa_stat_ind.trim().hashCode());
		result = (prime * result) + ((ararp_stat_ind == null) ? 0 : ararp_stat_ind.trim().hashCode());
		result = (prime * result) + ((arasm_stat_ind == null) ? 0 : arasm_stat_ind.trim().hashCode());
		result = (prime * result) + ((aravd_stat_ind == null) ? 0 : aravd_stat_ind.trim().hashCode());
		result = (prime * result) + ((arbad_stat_ind == null) ? 0 : arbad_stat_ind.trim().hashCode());
		result = (prime * result) + ((arbat_stat_ind == null) ? 0 : arbat_stat_ind.trim().hashCode());
		result = (prime * result) + ((arbbq_stat_ind == null) ? 0 : arbbq_stat_ind.trim().hashCode());
		result = (prime * result) + ((arbbs_stat_ind == null) ? 0 : arbbs_stat_ind.trim().hashCode());
		result = (prime * result) + ((arbus_stat_ind == null) ? 0 : arbus_stat_ind.trim().hashCode());
		result = (prime * result) + ((arcat_stat_ind == null) ? 0 : arcat_stat_ind.trim().hashCode());
		result = (prime * result) + ((arccc_stat_ind == null) ? 0 : arccc_stat_ind.trim().hashCode());
		result = (prime * result) + ((arcon_stat_ind == null) ? 0 : arcon_stat_ind.trim().hashCode());
		result = (prime * result) + ((arcpa_stat_ind == null) ? 0 : arcpa_stat_ind.trim().hashCode());
		result = (prime * result) + ((arcsc_stat_ind == null) ? 0 : arcsc_stat_ind.trim().hashCode());
		result = (prime * result) + ((arcta_stat_ind == null) ? 0 : arcta_stat_ind.trim().hashCode());
		result = (prime * result) + ((ardcd_stat_ind == null) ? 0 : ardcd_stat_ind.trim().hashCode());
		result = (prime * result) + ((ardfd_stat_ind == null) ? 0 : ardfd_stat_ind.trim().hashCode());
		result = (prime * result) + ((ardgp_stat_ind == null) ? 0 : ardgp_stat_ind.trim().hashCode());
		result = (prime * result) + ((ardoc_stat_ind == null) ? 0 : ardoc_stat_ind.trim().hashCode());
		result = (prime * result) + ((arfas_stat_ind == null) ? 0 : arfas_stat_ind.trim().hashCode());
		result = (prime * result) + ((arfin_stat_ind == null) ? 0 : arfin_stat_ind.trim().hashCode());
		result = (prime * result) + ((arhap_stat_ind == null) ? 0 : arhap_stat_ind.trim().hashCode());
		result = (prime * result) + ((arhbt_stat_ind == null) ? 0 : arhbt_stat_ind.trim().hashCode());
		result = (prime * result) + ((arhca_stat_ind == null) ? 0 : arhca_stat_ind.trim().hashCode());
		result = (prime * result) + ((arhcd_stat_ind == null) ? 0 : arhcd_stat_ind.trim().hashCode());
		result = (prime * result) + ((arhcs_stat_ind == null) ? 0 : arhcs_stat_ind.trim().hashCode());
		result = (prime * result) + ((arhdd_stat_ind == null) ? 0 : arhdd_stat_ind.trim().hashCode());
		result = (prime * result) + ((arhde_stat_ind == null) ? 0 : arhde_stat_ind.trim().hashCode());
		result = (prime * result) + ((arhis_stat_ind == null) ? 0 : arhis_stat_ind.trim().hashCode());
		result = (prime * result) + ((arhma_stat_ind == null) ? 0 : arhma_stat_ind.trim().hashCode());
		result = (prime * result) + ((arhmd_stat_ind == null) ? 0 : arhmd_stat_ind.trim().hashCode());
		result = (prime * result) + ((arhmi_stat_ind == null) ? 0 : arhmi_stat_ind.trim().hashCode());
		result = (prime * result) + ((arhmo_stat_ind == null) ? 0 : arhmo_stat_ind.trim().hashCode());
		result = (prime * result) + ((arhmx_stat_ind == null) ? 0 : arhmx_stat_ind.trim().hashCode());
		result = (prime * result) + ((arhod_stat_ind == null) ? 0 : arhod_stat_ind.trim().hashCode());
		result = (prime * result) + ((arhoh_stat_ind == null) ? 0 : arhoh_stat_ind.trim().hashCode());
		result = (prime * result) + ((arhos_stat_ind == null) ? 0 : arhos_stat_ind.trim().hashCode());
		result = (prime * result) + ((arhpa_stat_ind == null) ? 0 : arhpa_stat_ind.trim().hashCode());
		result = (prime * result) + ((arhpd_stat_ind == null) ? 0 : arhpd_stat_ind.trim().hashCode());
		result = (prime * result) + ((arhpg_stat_ind == null) ? 0 : arhpg_stat_ind.trim().hashCode());
		result = (prime * result) + ((arhps_stat_ind == null) ? 0 : arhps_stat_ind.trim().hashCode());
		result = (prime * result) + ((arhrl_stat_ind == null) ? 0 : arhrl_stat_ind.trim().hashCode());
		result = (prime * result) + ((arhse_stat_ind == null) ? 0 : arhse_stat_ind.trim().hashCode());
		result = (prime * result) + ((aridp_stat_ind == null) ? 0 : aridp_stat_ind.trim().hashCode());
		result = (prime * result) + ((ariki_stat_ind == null) ? 0 : ariki_stat_ind.trim().hashCode());
		result = (prime * result) + ((aripi_stat_ind == null) ? 0 : aripi_stat_ind.trim().hashCode());
		result = (prime * result) + ((ariwe_stat_ind == null) ? 0 : ariwe_stat_ind.trim().hashCode());
		result = (prime * result) + ((arjgq_stat_ind == null) ? 0 : arjgq_stat_ind.trim().hashCode());
		result = (prime * result) + ((arjid_stat_ind == null) ? 0 : arjid_stat_ind.trim().hashCode());
		result = (prime * result) + ((arehi_stat_ind == null) ? 0 : arehi_stat_ind.trim().hashCode());
		result = (prime * result) + ((arjis_stat_ind == null) ? 0 : arjis_stat_ind.trim().hashCode());
		result = (prime * result) + ((arjsd_stat_ind == null) ? 0 : arjsd_stat_ind.trim().hashCode());
		result = (prime * result) + ((arjse_stat_ind == null) ? 0 : arjse_stat_ind.trim().hashCode());
		result = (prime * result) + ((arlad_stat_ind == null) ? 0 : arlad_stat_ind.trim().hashCode());
		result = (prime * result) + ((arlat_stat_ind == null) ? 0 : arlat_stat_ind.trim().hashCode());
		result = (prime * result) + ((arlid_stat_ind == null) ? 0 : arlid_stat_ind.trim().hashCode());
		result = (prime * result) + ((arlit_stat_ind == null) ? 0 : arlit_stat_ind.trim().hashCode());
		result = (prime * result) + ((armaa_stat_ind == null) ? 0 : armaa_stat_ind.trim().hashCode());
		result = (prime * result) + ((armap_stat_ind == null) ? 0 : armap_stat_ind.trim().hashCode());
		result = (prime * result) + ((armbb_stat_ind == null) ? 0 : armbb_stat_ind.trim().hashCode());
		result = (prime * result) + ((armbd_stat_ind == null) ? 0 : armbd_stat_ind.trim().hashCode());
		result = (prime * result) + ((armed_stat_ind == null) ? 0 : armed_stat_ind.trim().hashCode());
		result = (prime * result) + ((armov_stat_ind == null) ? 0 : armov_stat_ind.trim().hashCode());
		result = (prime * result) + ((arnur_stat_ind == null) ? 0 : arnur_stat_ind.trim().hashCode());
		result = (prime * result) + ((aroac_stat_ind == null) ? 0 : aroac_stat_ind.trim().hashCode());
		result = (prime * result) + ((aroaq_stat_ind == null) ? 0 : aroaq_stat_ind.trim().hashCode());
		result = (prime * result) + ((aroas_stat_ind == null) ? 0 : aroas_stat_ind.trim().hashCode());
		result = (prime * result) + ((arobc_stat_ind == null) ? 0 : arobc_stat_ind.trim().hashCode());
		result = (prime * result) + ((arobi_stat_ind == null) ? 0 : arobi_stat_ind.trim().hashCode());
		result = (prime * result) + ((arobq_stat_ind == null) ? 0 : arobq_stat_ind.trim().hashCode());
		result = (prime * result) + ((arobs_stat_ind == null) ? 0 : arobs_stat_ind.trim().hashCode());
		result = (prime * result) + ((arofs_stat_ind == null) ? 0 : arofs_stat_ind.trim().hashCode());
		result = (prime * result) + ((aroiq_stat_ind == null) ? 0 : aroiq_stat_ind.trim().hashCode());
		result = (prime * result) + ((arord_stat_ind == null) ? 0 : arord_stat_ind.trim().hashCode());
		result = (prime * result) + ((arort_stat_ind == null) ? 0 : arort_stat_ind.trim().hashCode());
		result = (prime * result) + ((arpcd_stat_ind == null) ? 0 : arpcd_stat_ind.trim().hashCode());
		result = (prime * result) + ((arpcs_stat_ind == null) ? 0 : arpcs_stat_ind.trim().hashCode());
		result = (prime * result) + ((arper_stat_ind == null) ? 0 : arper_stat_ind.trim().hashCode());
		result = (prime * result) + ((arpgq_stat_ind == null) ? 0 : arpgq_stat_ind.trim().hashCode());
		result = (prime * result) + ((arpiq_stat_ind == null) ? 0 : arpiq_stat_ind.trim().hashCode());
		result = (prime * result) + ((arplr_stat_ind == null) ? 0 : arplr_stat_ind.trim().hashCode());
		result = (prime * result) + ((arppd_stat_ind == null) ? 0 : arppd_stat_ind.trim().hashCode());
		result = (prime * result) + ((arprs_stat_ind == null) ? 0 : arprs_stat_ind.trim().hashCode());
		result = (prime * result) + ((arrbe_stat_ind == null) ? 0 : arrbe_stat_ind.trim().hashCode());
		result = (prime * result) + ((arrbi_stat_ind == null) ? 0 : arrbi_stat_ind.trim().hashCode());
		result = (prime * result) + ((arrpd_stat_ind == null) ? 0 : arrpd_stat_ind.trim().hashCode());
		result = (prime * result) + ((arrpt_stat_ind == null) ? 0 : arrpt_stat_ind.trim().hashCode());
		result = (prime * result) + ((arsod_stat_ind == null) ? 0 : arsod_stat_ind.trim().hashCode());
		result = (prime * result) + ((arstd_stat_ind == null) ? 0 : arstd_stat_ind.trim().hashCode());
		result = (prime * result) + ((arsum_stat_ind == null) ? 0 : arsum_stat_ind.trim().hashCode());
		result = (prime * result) + ((artky_stat_ind == null) ? 0 : artky_stat_ind.trim().hashCode());
		result = (prime * result) + ((aruid_stat_ind == null) ? 0 : aruid_stat_ind.trim().hashCode());
		result = (prime * result) + ((aruii_stat_ind == null) ? 0 : aruii_stat_ind.trim().hashCode());
		result = (prime * result) + ((aruis_stat_ind == null) ? 0 : aruis_stat_ind.trim().hashCode());
		result = (prime * result) + ((aruit_stat_ind == null) ? 0 : aruit_stat_ind.trim().hashCode());
		result = (prime * result) + ((arvad_stat_ind == null) ? 0 : arvad_stat_ind.trim().hashCode());
		result = (prime * result) + ((arvat_stat_ind == null) ? 0 : arvat_stat_ind.trim().hashCode());
		result = (prime * result) + ((arxfr_stat_ind == null) ? 0 : arxfr_stat_ind.trim().hashCode());
		result = (prime * result) + ((arxgq_stat_ind == null) ? 0 : arxgq_stat_ind.trim().hashCode());
		result = (prime * result) + ((arxhd_stat_ind == null) ? 0 : arxhd_stat_ind.trim().hashCode());
		result = (prime * result) + ((arxhi_stat_ind == null) ? 0 : arxhi_stat_ind.trim().hashCode());
		result = (prime * result) + ((arxhs_stat_ind == null) ? 0 : arxhs_stat_ind.trim().hashCode());
		result = (prime * result) + ((arxhu_stat_ind == null) ? 0 : arxhu_stat_ind.trim().hashCode());
		result = (prime * result) + ((arxiq_stat_ind == null) ? 0 : arxiq_stat_ind.trim().hashCode());
		result = (prime * result) + ((arxud_stat_ind == null) ? 0 : arxud_stat_ind.trim().hashCode());
		result = (prime * result) + ((hscso_stat_ind == null) ? 0 : hscso_stat_ind.trim().hashCode());
		result = (prime * result) + ((hsher_stat_ind == null) ? 0 : hsher_stat_ind.trim().hashCode());
		result = (prime * result) + ((hshmo_stat_ind == null) ? 0 : hshmo_stat_ind.trim().hashCode());
		result = (prime * result) + ((arlhi_stat_ind == null) ? 0 : arlhi_stat_ind.trim().hashCode());
		result = (prime * result) + ((aritd_stat_ind == null) ? 0 : aritd_stat_ind.trim().hashCode());
		result = (prime * result) + ((arbtt_stat_ind == null) ? 0 : arbtt_stat_ind.trim().hashCode());
		result = (prime * result) + ((arbtd_stat_ind == null) ? 0 : arbtd_stat_ind.trim().hashCode());
		result = (prime * result) + ((arhin_stat_ind == null) ? 0 : arhin_stat_ind.trim().hashCode());
		result = (prime * result) + ((arohi_stat_ind == null) ? 0 : arohi_stat_ind.trim().hashCode());

		result = (prime * result) + ((artxi_stat_ind == null) ? 0 : artxi_stat_ind.trim().hashCode());
		result = (prime * result) + ((artdp_stat_ind == null) ? 0 : artdp_stat_ind.trim().hashCode());
		result = (prime * result) + ((artax_stat_ind == null) ? 0 : artax_stat_ind.trim().hashCode());
		result = (prime * result) + ((arpre_stat_ind == null) ? 0 : arpre_stat_ind.trim().hashCode());
		result = (prime * result) + ((arrld_stat_ind == null) ? 0 : arrld_stat_ind.trim().hashCode());
		result = (prime * result) + ((arcfn_stat_ind == null) ? 0 : arcfn_stat_ind.trim().hashCode());
		result = (prime * result) + ((arbcn_stat_ind == null) ? 0 : arbcn_stat_ind.trim().hashCode());

		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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
		final RMC_DRVR_Cargo other = (RMC_DRVR_Cargo) obj;
		if (app_num == null) {
			if (other.app_num != null) {
				return false;
			}
		} else if (!app_num.equals(other.app_num)) {
			return false;
		}
		if (arhin_stat_ind == null) {
			if (other.arhin_stat_ind != null) {
				return false;
			}
		} else if (!arhin_stat_ind.equals(other.arhin_stat_ind)) {
			return false;
		}
		if (arohi_stat_ind == null) {
			if (other.arohi_stat_ind != null) {
				return false;
			}
		} else if (!arohi_stat_ind.equals(other.arohi_stat_ind)) {
			return false;
		}
		if (aracd_stat_ind == null) {
			if (other.aracd_stat_ind != null) {
				return false;
			}
		} else if (!aracd_stat_ind.equals(other.aracd_stat_ind)) {
			return false;
		}
		if (aracs_stat_ind == null) {
			if (other.aracs_stat_ind != null) {
				return false;
			}
		} else if (!aracs_stat_ind.equals(other.aracs_stat_ind)) {
			return false;
		}
		if (arafp_stat_ind == null) {
			if (other.arafp_stat_ind != null) {
				return false;
			}
		} else if (!arafp_stat_ind.equals(other.arafp_stat_ind)) {
			return false;
		}
		if (aragq_stat_ind == null) {
			if (other.aragq_stat_ind != null) {
				return false;
			}
		} else if (!aragq_stat_ind.equals(other.aragq_stat_ind)) {
			return false;
		}
		if (araiq_stat_ind == null) {
			if (other.araiq_stat_ind != null) {
				return false;
			}
		} else if (!araiq_stat_ind.equals(other.araiq_stat_ind)) {
			return false;
		}
		if (arapa_stat_ind == null) {
			if (other.arapa_stat_ind != null) {
				return false;
			}
		} else if (!arapa_stat_ind.equals(other.arapa_stat_ind)) {
			return false;
		}
		if (ararp_stat_ind == null) {
			if (other.ararp_stat_ind != null) {
				return false;
			}
		} else if (!ararp_stat_ind.equals(other.ararp_stat_ind)) {
			return false;
		}
		if (arasm_stat_ind == null) {
			if (other.arasm_stat_ind != null) {
				return false;
			}
		} else if (!arasm_stat_ind.equals(other.arasm_stat_ind)) {
			return false;
		}
		if (aravd_stat_ind == null) {
			if (other.aravd_stat_ind != null) {
				return false;
			}
		} else if (!aravd_stat_ind.equals(other.aravd_stat_ind)) {
			return false;
		}
		if (arbad_stat_ind == null) {
			if (other.arbad_stat_ind != null) {
				return false;
			}
		} else if (!arbad_stat_ind.equals(other.arbad_stat_ind)) {
			return false;
		}
		if (arbat_stat_ind == null) {
			if (other.arbat_stat_ind != null) {
				return false;
			}
		} else if (!arbat_stat_ind.equals(other.arbat_stat_ind)) {
			return false;
		}
		if (arbbq_stat_ind == null) {
			if (other.arbbq_stat_ind != null) {
				return false;
			}
		} else if (!arbbq_stat_ind.equals(other.arbbq_stat_ind)) {
			return false;
		}
		if (arbbs_stat_ind == null) {
			if (other.arbbs_stat_ind != null) {
				return false;
			}
		} else if (!arbbs_stat_ind.equals(other.arbbs_stat_ind)) {
			return false;
		}
		if (arbus_stat_ind == null) {
			if (other.arbus_stat_ind != null) {
				return false;
			}
		} else if (!arbus_stat_ind.equals(other.arbus_stat_ind)) {
			return false;
		}
		if (arcat_stat_ind == null) {
			if (other.arcat_stat_ind != null) {
				return false;
			}
		} else if (!arcat_stat_ind.equals(other.arcat_stat_ind)) {
			return false;
		}
		if (arccc_stat_ind == null) {
			if (other.arccc_stat_ind != null) {
				return false;
			}
		} else if (!arccc_stat_ind.equals(other.arccc_stat_ind)) {
			return false;
		}
		if (arcon_stat_ind == null) {
			if (other.arcon_stat_ind != null) {
				return false;
			}
		} else if (!arcon_stat_ind.equals(other.arcon_stat_ind)) {
			return false;
		}
		if (arcpa_stat_ind == null) {
			if (other.arcpa_stat_ind != null) {
				return false;
			}
		} else if (!arcpa_stat_ind.equals(other.arcpa_stat_ind)) {
			return false;
		}
		if (arcsc_stat_ind == null) {
			if (other.arcsc_stat_ind != null) {
				return false;
			}
		} else if (!arcsc_stat_ind.equals(other.arcsc_stat_ind)) {
			return false;
		}
		if (arcta_stat_ind == null) {
			if (other.arcta_stat_ind != null) {
				return false;
			}
		} else if (!arcta_stat_ind.equals(other.arcta_stat_ind)) {
			return false;
		}
		if (ardcd_stat_ind == null) {
			if (other.ardcd_stat_ind != null) {
				return false;
			}
		} else if (!ardcd_stat_ind.equals(other.ardcd_stat_ind)) {
			return false;
		}
		if (ardfd_stat_ind == null) {
			if (other.ardfd_stat_ind != null) {
				return false;
			}
		} else if (!ardfd_stat_ind.equals(other.ardfd_stat_ind)) {
			return false;
		}
		if (ardgp_stat_ind == null) {
			if (other.ardgp_stat_ind != null) {
				return false;
			}
		} else if (!ardgp_stat_ind.equals(other.ardgp_stat_ind)) {
			return false;
		}
		if (ardoc_stat_ind == null) {
			if (other.ardoc_stat_ind != null) {
				return false;
			}
		} else if (!ardoc_stat_ind.equals(other.ardoc_stat_ind)) {
			return false;
		}
		if (arfas_stat_ind == null) {
			if (other.arfas_stat_ind != null) {
				return false;
			}
		} else if (!arfas_stat_ind.equals(other.arfas_stat_ind)) {
			return false;
		}
		if (arfin_stat_ind == null) {
			if (other.arfin_stat_ind != null) {
				return false;
			}
		} else if (!arfin_stat_ind.equals(other.arfin_stat_ind)) {
			return false;
		}
		if (arhap_stat_ind == null) {
			if (other.arhap_stat_ind != null) {
				return false;
			}
		} else if (!arhap_stat_ind.equals(other.arhap_stat_ind)) {
			return false;
		}
		if (arhbt_stat_ind == null) {
			if (other.arhbt_stat_ind != null) {
				return false;
			}
		} else if (!arhbt_stat_ind.equals(other.arhbt_stat_ind)) {
			return false;
		}
		if (arhca_stat_ind == null) {
			if (other.arhca_stat_ind != null) {
				return false;
			}
		} else if (!arhca_stat_ind.equals(other.arhca_stat_ind)) {
			return false;
		}
		if (arhcd_stat_ind == null) {
			if (other.arhcd_stat_ind != null) {
				return false;
			}
		} else if (!arhcd_stat_ind.equals(other.arhcd_stat_ind)) {
			return false;
		}
		if (arhcs_stat_ind == null) {
			if (other.arhcs_stat_ind != null) {
				return false;
			}
		} else if (!arhcs_stat_ind.equals(other.arhcs_stat_ind)) {
			return false;
		}
		if (arhdd_stat_ind == null) {
			if (other.arhdd_stat_ind != null) {
				return false;
			}
		} else if (!arhdd_stat_ind.equals(other.arhdd_stat_ind)) {
			return false;
		}
		if (arhde_stat_ind == null) {
			if (other.arhde_stat_ind != null) {
				return false;
			}
		} else if (!arhde_stat_ind.equals(other.arhde_stat_ind)) {
			return false;
		}
		if (arhis_stat_ind == null) {
			if (other.arhis_stat_ind != null) {
				return false;
			}
		} else if (!arhis_stat_ind.equals(other.arhis_stat_ind)) {
			return false;
		}
		if (arhma_stat_ind == null) {
			if (other.arhma_stat_ind != null) {
				return false;
			}
		} else if (!arhma_stat_ind.equals(other.arhma_stat_ind)) {
			return false;
		}
		if (arhmd_stat_ind == null) {
			if (other.arhmd_stat_ind != null) {
				return false;
			}
		} else if (!arhmd_stat_ind.equals(other.arhmd_stat_ind)) {
			return false;
		}
		if (arhmi_stat_ind == null) {
			if (other.arhmi_stat_ind != null) {
				return false;
			}
		} else if (!arhmi_stat_ind.equals(other.arhmi_stat_ind)) {
			return false;
		}
		if (arhmo_stat_ind == null) {
			if (other.arhmo_stat_ind != null) {
				return false;
			}
		} else if (!arhmo_stat_ind.equals(other.arhmo_stat_ind)) {
			return false;
		}
		if (arhmx_stat_ind == null) {
			if (other.arhmx_stat_ind != null) {
				return false;
			}
		} else if (!arhmx_stat_ind.equals(other.arhmx_stat_ind)) {
			return false;
		}
		if (arhod_stat_ind == null) {
			if (other.arhod_stat_ind != null) {
				return false;
			}
		} else if (!arhod_stat_ind.equals(other.arhod_stat_ind)) {
			return false;
		}
		if (arhoh_stat_ind == null) {
			if (other.arhoh_stat_ind != null) {
				return false;
			}
		} else if (!arhoh_stat_ind.equals(other.arhoh_stat_ind)) {
			return false;
		}
		if (arhos_stat_ind == null) {
			if (other.arhos_stat_ind != null) {
				return false;
			}
		} else if (!arhos_stat_ind.equals(other.arhos_stat_ind)) {
			return false;
		}
		if (arhpa_stat_ind == null) {
			if (other.arhpa_stat_ind != null) {
				return false;
			}
		} else if (!arhpa_stat_ind.equals(other.arhpa_stat_ind)) {
			return false;
		}
		if (arhpd_stat_ind == null) {
			if (other.arhpd_stat_ind != null) {
				return false;
			}
		} else if (!arhpd_stat_ind.equals(other.arhpd_stat_ind)) {
			return false;
		}
		if (arhpg_stat_ind == null) {
			if (other.arhpg_stat_ind != null) {
				return false;
			}
		} else if (!arhpg_stat_ind.equals(other.arhpg_stat_ind)) {
			return false;
		}
		if (arhps_stat_ind == null) {
			if (other.arhps_stat_ind != null) {
				return false;
			}
		} else if (!arhps_stat_ind.equals(other.arhps_stat_ind)) {
			return false;
		}
		if (arhrl_stat_ind == null) {
			if (other.arhrl_stat_ind != null) {
				return false;
			}
		} else if (!arhrl_stat_ind.equals(other.arhrl_stat_ind)) {
			return false;
		}
		if (arhse_stat_ind == null) {
			if (other.arhse_stat_ind != null) {
				return false;
			}
		} else if (!arhse_stat_ind.equals(other.arhse_stat_ind)) {
			return false;
		}
		if (aridp_stat_ind == null) {
			if (other.aridp_stat_ind != null) {
				return false;
			}
		} else if (!aridp_stat_ind.equals(other.aridp_stat_ind)) {
			return false;
		}
		if (ariki_stat_ind == null) {
			if (other.ariki_stat_ind != null) {
				return false;
			}
		} else if (!ariki_stat_ind.equals(other.ariki_stat_ind)) {
			return false;
		}
		if (aripi_stat_ind == null) {
			if (other.aripi_stat_ind != null) {
				return false;
			}
		} else if (!aripi_stat_ind.equals(other.aripi_stat_ind)) {
			return false;
		}
		if (ariwe_stat_ind == null) {
			if (other.ariwe_stat_ind != null) {
				return false;
			}
		} else if (!ariwe_stat_ind.equals(other.ariwe_stat_ind)) {
			return false;
		}
		if (arjgq_stat_ind == null) {
			if (other.arjgq_stat_ind != null) {
				return false;
			}
		} else if (!arjgq_stat_ind.equals(other.arjgq_stat_ind)) {
			return false;
		}
		if (arjid_stat_ind == null) {
			if (other.arjid_stat_ind != null) {
				return false;
			}
		} else if (!arjid_stat_ind.equals(other.arjid_stat_ind)) {
			return false;
		}
		if (arehi_stat_ind == null) {
			if (other.arehi_stat_ind != null) {
				return false;
			}
		} else if (!arehi_stat_ind.equals(other.arehi_stat_ind)) {
			return false;
		}
		if (arjis_stat_ind == null) {
			if (other.arjis_stat_ind != null) {
				return false;
			}
		} else if (!arjis_stat_ind.equals(other.arjis_stat_ind)) {
			return false;
		}
		if (arjsd_stat_ind == null) {
			if (other.arjsd_stat_ind != null) {
				return false;
			}
		} else if (!arjsd_stat_ind.equals(other.arjsd_stat_ind)) {
			return false;
		}
		if (arjse_stat_ind == null) {
			if (other.arjse_stat_ind != null) {
				return false;
			}
		} else if (!arjse_stat_ind.equals(other.arjse_stat_ind)) {
			return false;
		}
		if (arlad_stat_ind == null) {
			if (other.arlad_stat_ind != null) {
				return false;
			}
		} else if (!arlad_stat_ind.equals(other.arlad_stat_ind)) {
			return false;
		}
		if (arlat_stat_ind == null) {
			if (other.arlat_stat_ind != null) {
				return false;
			}
		} else if (!arlat_stat_ind.equals(other.arlat_stat_ind)) {
			return false;
		}
		if (arlid_stat_ind == null) {
			if (other.arlid_stat_ind != null) {
				return false;
			}
		} else if (!arlid_stat_ind.equals(other.arlid_stat_ind)) {
			return false;
		}
		if (arlit_stat_ind == null) {
			if (other.arlit_stat_ind != null) {
				return false;
			}
		} else if (!arlit_stat_ind.equals(other.arlit_stat_ind)) {
			return false;
		}
		if (armaa_stat_ind == null) {
			if (other.armaa_stat_ind != null) {
				return false;
			}
		} else if (!armaa_stat_ind.equals(other.armaa_stat_ind)) {
			return false;
		}
		if (armap_stat_ind == null) {
			if (other.armap_stat_ind != null) {
				return false;
			}
		} else if (!armap_stat_ind.equals(other.armap_stat_ind)) {
			return false;
		}
		if (armbb_stat_ind == null) {
			if (other.armbb_stat_ind != null) {
				return false;
			}
		} else if (!armbb_stat_ind.equals(other.armbb_stat_ind)) {
			return false;
		}
		if (armbd_stat_ind == null) {
			if (other.armbd_stat_ind != null) {
				return false;
			}
		} else if (!armbd_stat_ind.equals(other.armbd_stat_ind)) {
			return false;
		}
		if (armed_stat_ind == null) {
			if (other.armed_stat_ind != null) {
				return false;
			}
		} else if (!armed_stat_ind.equals(other.armed_stat_ind)) {
			return false;
		}
		if (armov_stat_ind == null) {
			if (other.armov_stat_ind != null) {
				return false;
			}
		} else if (!armov_stat_ind.equals(other.armov_stat_ind)) {
			return false;
		}
		if (arnur_stat_ind == null) {
			if (other.arnur_stat_ind != null) {
				return false;
			}
		} else if (!arnur_stat_ind.equals(other.arnur_stat_ind)) {
			return false;
		}
		if (aroac_stat_ind == null) {
			if (other.aroac_stat_ind != null) {
				return false;
			}
		} else if (!aroac_stat_ind.equals(other.aroac_stat_ind)) {
			return false;
		}
		if (aroaq_stat_ind == null) {
			if (other.aroaq_stat_ind != null) {
				return false;
			}
		} else if (!aroaq_stat_ind.equals(other.aroaq_stat_ind)) {
			return false;
		}
		if (aroas_stat_ind == null) {
			if (other.aroas_stat_ind != null) {
				return false;
			}
		} else if (!aroas_stat_ind.equals(other.aroas_stat_ind)) {
			return false;
		}
		if (arobc_stat_ind == null) {
			if (other.arobc_stat_ind != null) {
				return false;
			}
		} else if (!arobc_stat_ind.equals(other.arobc_stat_ind)) {
			return false;
		}
		if (arobi_stat_ind == null) {
			if (other.arobi_stat_ind != null) {
				return false;
			}
		} else if (!arobi_stat_ind.equals(other.arobi_stat_ind)) {
			return false;
		}
		if (arobq_stat_ind == null) {
			if (other.arobq_stat_ind != null) {
				return false;
			}
		} else if (!arobq_stat_ind.equals(other.arobq_stat_ind)) {
			return false;
		}
		if (arobs_stat_ind == null) {
			if (other.arobs_stat_ind != null) {
				return false;
			}
		} else if (!arobs_stat_ind.equals(other.arobs_stat_ind)) {
			return false;
		}
		if (arofs_stat_ind == null) {
			if (other.arofs_stat_ind != null) {
				return false;
			}
		} else if (!arofs_stat_ind.equals(other.arofs_stat_ind)) {
			return false;
		}
		if (aroiq_stat_ind == null) {
			if (other.aroiq_stat_ind != null) {
				return false;
			}
		} else if (!aroiq_stat_ind.equals(other.aroiq_stat_ind)) {
			return false;
		}
		if (arord_stat_ind == null) {
			if (other.arord_stat_ind != null) {
				return false;
			}
		} else if (!arord_stat_ind.equals(other.arord_stat_ind)) {
			return false;
		}
		if (arort_stat_ind == null) {
			if (other.arort_stat_ind != null) {
				return false;
			}
		} else if (!arort_stat_ind.equals(other.arort_stat_ind)) {
			return false;
		}
		if (arpcd_stat_ind == null) {
			if (other.arpcd_stat_ind != null) {
				return false;
			}
		} else if (!arpcd_stat_ind.equals(other.arpcd_stat_ind)) {
			return false;
		}
		if (arpcs_stat_ind == null) {
			if (other.arpcs_stat_ind != null) {
				return false;
			}
		} else if (!arpcs_stat_ind.equals(other.arpcs_stat_ind)) {
			return false;
		}
		if (arper_stat_ind == null) {
			if (other.arper_stat_ind != null) {
				return false;
			}
		} else if (!arper_stat_ind.equals(other.arper_stat_ind)) {
			return false;
		}
		if (arpgq_stat_ind == null) {
			if (other.arpgq_stat_ind != null) {
				return false;
			}
		} else if (!arpgq_stat_ind.equals(other.arpgq_stat_ind)) {
			return false;
		}
		if (arpiq_stat_ind == null) {
			if (other.arpiq_stat_ind != null) {
				return false;
			}
		} else if (!arpiq_stat_ind.equals(other.arpiq_stat_ind)) {
			return false;
		}
		if (arplr_stat_ind == null) {
			if (other.arplr_stat_ind != null) {
				return false;
			}
		} else if (!arplr_stat_ind.equals(other.arplr_stat_ind)) {
			return false;
		}
		if (arppd_stat_ind == null) {
			if (other.arppd_stat_ind != null) {
				return false;
			}
		} else if (!arppd_stat_ind.equals(other.arppd_stat_ind)) {
			return false;
		}
		if (arprs_stat_ind == null) {
			if (other.arprs_stat_ind != null) {
				return false;
			}
		} else if (!arprs_stat_ind.equals(other.arprs_stat_ind)) {
			return false;
		}
		if (arrbe_stat_ind == null) {
			if (other.arrbe_stat_ind != null) {
				return false;
			}
		} else if (!arrbe_stat_ind.equals(other.arrbe_stat_ind)) {
			return false;
		}
		if (arrbi_stat_ind == null) {
			if (other.arrbi_stat_ind != null) {
				return false;
			}
		} else if (!arrbi_stat_ind.equals(other.arrbi_stat_ind)) {
			return false;
		}
		if (arrpd_stat_ind == null) {
			if (other.arrpd_stat_ind != null) {
				return false;
			}
		} else if (!arrpd_stat_ind.equals(other.arrpd_stat_ind)) {
			return false;
		}
		if (arrpt_stat_ind == null) {
			if (other.arrpt_stat_ind != null) {
				return false;
			}
		} else if (!arrpt_stat_ind.equals(other.arrpt_stat_ind)) {
			return false;
		}
		if (arsod_stat_ind == null) {
			if (other.arsod_stat_ind != null) {
				return false;
			}
		} else if (!arsod_stat_ind.equals(other.arsod_stat_ind)) {
			return false;
		}
		if (arstd_stat_ind == null) {
			if (other.arstd_stat_ind != null) {
				return false;
			}
		} else if (!arstd_stat_ind.equals(other.arstd_stat_ind)) {
			return false;
		}
		if (arsum_stat_ind == null) {
			if (other.arsum_stat_ind != null) {
				return false;
			}
		} else if (!arsum_stat_ind.equals(other.arsum_stat_ind)) {
			return false;
		}
		if (artky_stat_ind == null) {
			if (other.artky_stat_ind != null) {
				return false;
			}
		} else if (!artky_stat_ind.equals(other.artky_stat_ind)) {
			return false;
		}
		if (aruid_stat_ind == null) {
			if (other.aruid_stat_ind != null) {
				return false;
			}
		} else if (!aruid_stat_ind.equals(other.aruid_stat_ind)) {
			return false;
		}
		if (aruii_stat_ind == null) {
			if (other.aruii_stat_ind != null) {
				return false;
			}
		} else if (!aruii_stat_ind.equals(other.aruii_stat_ind)) {
			return false;
		}
		if (aruis_stat_ind == null) {
			if (other.aruis_stat_ind != null) {
				return false;
			}
		} else if (!aruis_stat_ind.equals(other.aruis_stat_ind)) {
			return false;
		}
		if (aruit_stat_ind == null) {
			if (other.aruit_stat_ind != null) {
				return false;
			}
		} else if (!aruit_stat_ind.equals(other.aruit_stat_ind)) {
			return false;
		}
		if (arvad_stat_ind == null) {
			if (other.arvad_stat_ind != null) {
				return false;
			}
		} else if (!arvad_stat_ind.equals(other.arvad_stat_ind)) {
			return false;
		}
		if (arvat_stat_ind == null) {
			if (other.arvat_stat_ind != null) {
				return false;
			}
		} else if (!arvat_stat_ind.equals(other.arvat_stat_ind)) {
			return false;
		}
		if (arxfr_stat_ind == null) {
			if (other.arxfr_stat_ind != null) {
				return false;
			}
		} else if (!arxfr_stat_ind.equals(other.arxfr_stat_ind)) {
			return false;
		}
		if (arxgq_stat_ind == null) {
			if (other.arxgq_stat_ind != null) {
				return false;
			}
		} else if (!arxgq_stat_ind.equals(other.arxgq_stat_ind)) {
			return false;
		}
		if (arxhd_stat_ind == null) {
			if (other.arxhd_stat_ind != null) {
				return false;
			}
		} else if (!arxhd_stat_ind.equals(other.arxhd_stat_ind)) {
			return false;
		}
		if (arxhi_stat_ind == null) {
			if (other.arxhi_stat_ind != null) {
				return false;
			}
		} else if (!arxhi_stat_ind.equals(other.arxhi_stat_ind)) {
			return false;
		}
		if (arxhs_stat_ind == null) {
			if (other.arxhs_stat_ind != null) {
				return false;
			}
		} else if (!arxhs_stat_ind.equals(other.arxhs_stat_ind)) {
			return false;
		}
		if (arxhu_stat_ind == null) {
			if (other.arxhu_stat_ind != null) {
				return false;
			}
		} else if (!arxhu_stat_ind.equals(other.arxhu_stat_ind)) {
			return false;
		}
		if (arxiq_stat_ind == null) {
			if (other.arxiq_stat_ind != null) {
				return false;
			}
		} else if (!arxiq_stat_ind.equals(other.arxiq_stat_ind)) {
			return false;
		}
		if (arxud_stat_ind == null) {
			if (other.arxud_stat_ind != null) {
				return false;
			}
		} else if (!arxud_stat_ind.equals(other.arxud_stat_ind)) {
			return false;
		}
		if (hscso_stat_ind == null) {
			if (other.hscso_stat_ind != null) {
				return false;
			}
		} else if (!hscso_stat_ind.equals(other.hscso_stat_ind)) {
			return false;
		}
		if (hsher_stat_ind == null) {
			if (other.hsher_stat_ind != null) {
				return false;
			}
		} else if (!hsher_stat_ind.equals(other.hsher_stat_ind)) {
			return false;
		}
		if (hshmo_stat_ind == null) {
			if (other.hshmo_stat_ind != null) {
				return false;
			}
		} else if (!hshmo_stat_ind.equals(other.hshmo_stat_ind)) {
			return false;
		}
		if (arlhi_stat_ind == null) {
			if (other.arlhi_stat_ind != null) {
				return false;
			}
		} else if (!arlhi_stat_ind.equals(other.arlhi_stat_ind)) {
			return false;
		}
		if (aritd_stat_ind == null) {
			if (other.aritd_stat_ind != null) {
				return false;
			}
		} else if (!aritd_stat_ind.equals(other.aritd_stat_ind)) {
			return false;
		}
		if (arbtt_stat_ind == null) {
			if (other.arbtt_stat_ind != null) {
				return false;
			}
		} else if (!arbtt_stat_ind.equals(other.arbtt_stat_ind)) {
			return false;
		}
		if (arbtd_stat_ind == null) {
			if (other.arbtd_stat_ind != null) {
				return false;
			}
		} else if (!arbtd_stat_ind.equals(other.arbtd_stat_ind)) {
			return false;
		}

		if (artxi_stat_ind == null) {
			if (other.artxi_stat_ind != null) {
				return false;
			}
		} else if (!artxi_stat_ind.equals(other.artxi_stat_ind)) {
			return false;
		}

		if (artdp_stat_ind == null) {
			if (other.artdp_stat_ind != null) {
				return false;
			}
		} else if (!artdp_stat_ind.equals(other.artdp_stat_ind)) {
			return false;
		}

		if (artax_stat_ind == null) {
			if (other.artax_stat_ind != null) {
				return false;
			}
		} else if (!artax_stat_ind.equals(other.artax_stat_ind)) {
			return false;
		}
		if (arpre_stat_ind == null) {
			if (other.arpre_stat_ind != null) {
				return false;
			}
		} else if (!arpre_stat_ind.equals(other.arpre_stat_ind)) {
			return false;
		}
		if (arrld_stat_ind == null) {
			if (other.arrld_stat_ind != null) {
				return false;
			}
		} else if (!arrld_stat_ind.equals(other.arrld_stat_ind)) {
			return false;
		}
		if (arcfn_stat_ind == null) {
			if (other.arcfn_stat_ind != null) {
				return false;
			}
		} else if (!arcfn_stat_ind.equals(other.arcfn_stat_ind)) {
			return false;
		}
		if (arbcn_stat_ind == null) {
			if (other.arbcn_stat_ind != null) {
				return false;
			}
		} else if (!arbcn_stat_ind.equals(other.arbcn_stat_ind)) {
			return false;
		}
		return true;
	}

}