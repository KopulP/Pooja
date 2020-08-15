/*
 * 
 */
package gov.state.nextgen.access.driver.business.entities;

import gov.state.nextgen.access.business.entities.AbstractCollection;

/**
 * This class acts as a wrapper for one or many cargos of AFB_DRVR
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date Fri Feb 02 13:10:30 CST 2007 Modified By: Modified on: PCR#
 */
public class AFB_DRVR_Collection extends AbstractCollection {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.framework.driver.business.entities.impl.AFB_DRVR";

	/**
	 * returns the PACKAGE name.
	 */
	@Override
	public String getPACKAGE() {
		return PACKAGE;
	}

	/**
	 * Adds the given cargo to the collection.
	 */
	public void addCargo(final AFB_DRVR_Cargo aNewCargo) {
		add(aNewCargo);
	}

	/**
	 * Sets cargo array into collection.
	 */
	public void setResults(final AFB_DRVR_Cargo[] cbArray) {
		clear();
		for (int i = 0; i < cbArray.length; i++) {
			add(cbArray[i]);
		}
	}

	/**
	 * Sets cargo into collection at the given index.
	 */
	public void setCargo(final int idx, final AFB_DRVR_Cargo aCargo) {
		set(idx, aCargo);
	}

	/**
	 * returns all the values in the Collection as Cargo Array.
	 */
	public AFB_DRVR_Cargo[] getResults() {
		final AFB_DRVR_Cargo[] cbArray = new AFB_DRVR_Cargo[size()];
		toArray(cbArray);
		return cbArray;
	}

	/**
	 * returns a cargo from the Collection for the given index.
	 */
	public AFB_DRVR_Cargo getCargo(final int idx) {
		return (AFB_DRVR_Cargo) get(idx);
	}

	/**
	 * This one for clone Results.
	 */
	public AFB_DRVR_Cargo[] cloneResults() {
		final AFB_DRVR_Cargo[] rescargo = new AFB_DRVR_Cargo[size()];
		for (int i = 0; i < size(); i++) {
			final AFB_DRVR_Cargo cargo = getCargo(i);
			rescargo[i] = new AFB_DRVR_Cargo();
			rescargo[i].setApp_num(cargo.getApp_num());
			rescargo[i].setAbapd_stat_ind(cargo.getAbapd_stat_ind());
			rescargo[i].setAbbnr_stat_ind(cargo.getAbbnr_stat_ind());
			rescargo[i].setAbdcd_stat_ind(cargo.getAbdcd_stat_ind());
			rescargo[i].setAbedt_stat_ind(cargo.getAbedt_stat_ind());
			rescargo[i].setAbefd_stat_ind(cargo.getAbefd_stat_ind());
			rescargo[i].setAbesm_stat_ind(cargo.getAbesm_stat_ind());
			rescargo[i].setAbfas_stat_ind(cargo.getAbfas_stat_ind());
			rescargo[i].setAbheq_stat_ind(cargo.getAbheq_stat_ind());
			rescargo[i].setAbhes_stat_ind(cargo.getAbhes_stat_ind());
			rescargo[i].setAbhhq_stat_ind(cargo.getAbhhq_stat_ind());
			rescargo[i].setAbhhr_stat_ind(cargo.getAbhhr_stat_ind());
			rescargo[i].setAbhis_stat_ind(cargo.getAbhis_stat_ind());
			rescargo[i].setAbhmd_stat_ind(cargo.getAbhmd_stat_ind());
			rescargo[i].setAbhms_stat_ind(cargo.getAbhms_stat_ind());
			rescargo[i].setAbjiq_stat_ind(cargo.getAbjiq_stat_ind());
			rescargo[i].setAbjis_stat_ind(cargo.getAbjis_stat_ind());
			rescargo[i].setAbmed_stat_ind(cargo.getAbmed_stat_ind());
			rescargo[i].setAbnsd_stat_ind(cargo.getAbnsd_stat_ind());
			rescargo[i].setAbnso_stat_ind(cargo.getAbnso_stat_ind());
			rescargo[i].setAboeq_stat_ind(cargo.getAboeq_stat_ind());
			rescargo[i].setAboiq_stat_ind(cargo.getAboiq_stat_ind());
			rescargo[i].setAbois_stat_ind(cargo.getAbois_stat_ind());
			rescargo[i].setAbpas_stat_ind(cargo.getAbpas_stat_ind());
			rescargo[i].setAbpps_stat_ind(cargo.getAbpps_stat_ind());
			rescargo[i].setAbprg_stat_ind(cargo.getAbprg_stat_ind());
			rescargo[i].setAbpri_stat_ind(cargo.getAbpri_stat_ind());
			rescargo[i].setAbpsq_stat_ind(cargo.getAbpsq_stat_ind());
			rescargo[i].setAbrgi_stat_ind(cargo.getAbrgi_stat_ind());
			rescargo[i].setAbrgs_stat_ind(cargo.getAbrgs_stat_ind());
			rescargo[i].setAbrlv_stat_ind(cargo.getAbrlv_stat_ind());
			rescargo[i].setAbscd_stat_ind(cargo.getAbscd_stat_ind());
			rescargo[i].setAbsct_stat_ind(cargo.getAbsct_stat_ind());
			rescargo[i].setAbsed_stat_ind(cargo.getAbsed_stat_ind());
			rescargo[i].setAbsen_stat_ind(cargo.getAbsen_stat_ind());
			rescargo[i].setAbucd_stat_ind(cargo.getAbucd_stat_ind());
			rescargo[i].setAbuct_stat_ind(cargo.getAbuct_stat_ind());
			rescargo[i].setAbuid_stat_ind(cargo.getAbuid_stat_ind());
			rescargo[i].setAbuit_stat_ind(cargo.getAbuit_stat_ind());
			rescargo[i].setAbbad_stat_ind(cargo.getAbbad_stat_ind());
			rescargo[i].setAbbat_stat_ind(cargo.getAbbat_stat_ind());
			rescargo[i].setAbcon_stat_ind(cargo.getAbcon_stat_ind());
			rescargo[i].setAbdis_stat_ind(cargo.getAbdis_stat_ind());
			rescargo[i].setAbhca_stat_ind(cargo.getAbhca_stat_ind());
			rescargo[i].setAbhcd_stat_ind(cargo.getAbhcd_stat_ind());
			rescargo[i].setAbhwa_stat_ind(cargo.getAbhwa_stat_ind());
			rescargo[i].setAbind_stat_ind(cargo.getAbind_stat_ind());
			rescargo[i].setAblad_stat_ind(cargo.getAblad_stat_ind());
			rescargo[i].setAblaq_stat_ind(cargo.getAblaq_stat_ind());
			rescargo[i].setAblas_stat_ind(cargo.getAblas_stat_ind());
			rescargo[i].setAblat_stat_ind(cargo.getAblat_stat_ind());
			rescargo[i].setAblid_stat_ind(cargo.getAblid_stat_ind());
			rescargo[i].setAblit_stat_ind(cargo.getAblit_stat_ind());
			rescargo[i].setAboaq_stat_ind(cargo.getAboaq_stat_ind());
			rescargo[i].setAboas_stat_ind(cargo.getAboas_stat_ind());
			rescargo[i].setAbppd_stat_ind(cargo.getAbppd_stat_ind());
			rescargo[i].setAbrpd_stat_ind(cargo.getAbrpd_stat_ind());
			rescargo[i].setAbrpt_stat_ind(cargo.getAbrpt_stat_ind());
			rescargo[i].setAbvad_stat_ind(cargo.getAbvad_stat_ind());
			rescargo[i].setAbvat_stat_ind(cargo.getAbvat_stat_ind());
			rescargo[i].setAbmet_stat_ind(cargo.getAbmet_stat_ind());
			rescargo[i].setAbmbd_stat_ind(cargo.getAbmbd_stat_ind());
			rescargo[i].setAbmah_stat_ind(cargo.getAbmah_stat_ind());
			rescargo[i].setAbdty_stat_ind(cargo.getAbdty_stat_ind());
			rescargo[i].setAbddt_stat_ind(cargo.getAbddt_stat_ind());
			rescargo[i].setAbdsm_stat_ind(cargo.getAbdsm_stat_ind());
			rescargo[i].setAbdfe_stat_ind(cargo.getAbdfe_stat_ind());
			rescargo[i].setAbcpa_stat_ind(cargo.getAbcpa_stat_ind());
			rescargo[i].setAbcph_stat_ind(cargo.getAbcph_stat_ind());
			rescargo[i].setAbcra_stat_ind(cargo.getAbcra_stat_ind());
			rescargo[i].setAbeca_stat_ind(cargo.getAbeca_stat_ind());
			rescargo[i].setAbefa_stat_ind(cargo.getAbefa_stat_ind());
			rescargo[i].setAbsta_stat_ind(cargo.getAbsta_stat_ind());
			rescargo[i].setAbshe_stat_ind(cargo.getAbshe_stat_ind());
			rescargo[i].setAbsae_stat_ind(cargo.getAbsae_stat_ind());
			rescargo[i].setAbwre_stat_ind(cargo.getAbwre_stat_ind());
			rescargo[i].setAbaur_stat_ind(cargo.getAbaur_stat_ind());
			rescargo[i].setAbchs_stat_ind(cargo.getAbchs_stat_ind());
			rescargo[i].setAbavd_stat_ind(cargo.getAbavd_stat_ind());
			rescargo[i].setAbhdn_stat_ind(cargo.getAbhdn_stat_ind());
			rescargo[i].setAbdoc_stat_ind(cargo.getAbdoc_stat_ind());
			rescargo[i].setAbobq_stat_ind(cargo.getAbobq_stat_ind());
			rescargo[i].setAbmdp_stat_ind(cargo.getAbmdp_stat_ind());
			rescargo[i].setAbhlt_stat_ind(cargo.getAbhlt_stat_ind());
			rescargo[i].setAbhsy_stat_ind(cargo.getAbhsy_stat_ind());
			rescargo[i].setAblhi_stat_ind(cargo.getAblhi_stat_ind());
			rescargo[i].setAbhsc_stat_ind(cargo.getAbhsc_stat_ind());
			rescargo[i].setAbnhm_stat_ind(cargo.getAbnhm_stat_ind());
			rescargo[i].setAbobs_stat_ind(cargo.getAbobs_stat_ind());
			rescargo[i].setAbipi_stat_ind(cargo.getAbipi_stat_ind());
			rescargo[i].setAbipq_stat_ind(cargo.getAbipq_stat_ind());
			rescargo[i].setAbcrc_stat_ind(cargo.getAbcrc_stat_ind());
			rescargo[i].setAbhip_stat_ind(cargo.getAbhip_stat_ind());
			// NextGen  NG-6481 Phase 3 updates to ACA Streamline changes � start
			rescargo[i].setAbitd_stat_ind(cargo.getAbitd_stat_ind());
			// NextGen  NG-6481 Phase 3 updates to ACA Streamline changes � end
			//  NextGen  NG-6481 Phase 3 ACA Streamline changes � start
			rescargo[i].setAbbtx_stat_ind(cargo.getAbbtx_stat_ind());
			rescargo[i].setAbbtd_stat_ind(cargo.getAbbtd_stat_ind());
			//  NextGen  NG-6481 Phase 3 ACA Streamline changes � end
			rescargo[i].setAbort_stat_ind(cargo.getAbort_stat_ind());
			rescargo[i].setAbord_stat_ind(cargo.getAbord_stat_ind());
			rescargo[i].setAbiki_stat_ind(cargo.getAbiki_stat_ind());
			rescargo[i].setAbofs_stat_ind(cargo.getAbofs_stat_ind());
			//ACA Integration
			rescargo[i].setAbofs_stat_ind(cargo.getAbtax_stat_ind());
			rescargo[i].setAbtdp_stat_ind(cargo.getAbtdp_stat_ind());
			rescargo[i].setAbehi_stat_ind(cargo.getAbehi_stat_ind());
			rescargo[i].setAbhin_stat_ind(cargo.getAbhin_stat_ind());
			rescargo[i].setAbohi_stat_ind(cargo.getAbohi_stat_ind());
			rescargo[i].setAbtxr_stat_ind(cargo.getAbtxr_stat_ind());
			rescargo[i].setAbtxi_stat_ind(cargo.getAbtxi_stat_ind());
			rescargo[i].setAbcfn_stat_ind(cargo.getAbcfn_stat_ind());
			rescargo[i].setAbbcn_stat_ind(cargo.getAbbcn_stat_ind());

			rescargo[i].setRowAction(cargo.getRowAction());
			rescargo[i].setUser(cargo.getUser());
			rescargo[i].setDirty(cargo.isDirty());
		}
		return rescargo;
	}

	/**
	 * Set the cargo array object to the collection.
	 */
	@Override
	public void setGenericResults(final Object obj) {
		if (obj instanceof AFB_DRVR_Cargo[]) {
			final AFB_DRVR_Cargo[] cbArray = (AFB_DRVR_Cargo[]) obj;
			setResults(cbArray);
		}
	}
}