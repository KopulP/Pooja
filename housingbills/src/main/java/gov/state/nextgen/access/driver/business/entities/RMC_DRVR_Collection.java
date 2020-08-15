/*
 * 
 */
package gov.state.nextgen.access.driver.business.entities;

import gov.state.nextgen.access.business.entities.AbstractCollection;

/**
 * This class acts as a wrapper for one or many cargos of RMC_DRVR
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date Aug 11 16:15:25 CDT 2009 Modified By: Modified on: PCR#
 */
public class RMC_DRVR_Collection extends AbstractCollection {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.framework.driver.business.entities.impl.RMC_DRVR";

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
	public void addCargo(final RMC_DRVR_Cargo aNewCargo) {
		add(aNewCargo);
	}

	/**
	 * Sets cargo array into collection.
	 */
	public void setResults(final RMC_DRVR_Cargo[] cbArray) {
		clear();
		for (int i = 0; i < cbArray.length; i++) {
			add(cbArray[i]);
		}
	}

	/**
	 * Sets cargo into collection at the given index.
	 */
	public void setCargo(final int idx, final RMC_DRVR_Cargo aCargo) {
		set(idx, aCargo);
	}

	/**
	 * returns all the values in the Collection as Cargo Array.
	 */
	public RMC_DRVR_Cargo[] getResults() {
		final RMC_DRVR_Cargo[] cbArray = new RMC_DRVR_Cargo[size()];
		toArray(cbArray);
		return cbArray;
	}

	/**
	 * returns a cargo from the Collection for the given index.
	 */
	public RMC_DRVR_Cargo getCargo(final int idx) {
		return (RMC_DRVR_Cargo) get(idx);
	}

	/**
	 * This one for clone Results.
	 */
	public RMC_DRVR_Cargo[] cloneResults() {
		final RMC_DRVR_Cargo[] rescargo = new RMC_DRVR_Cargo[size()];
		for (int i = 0; i < size(); i++) {
			final RMC_DRVR_Cargo cargo = getCargo(i);
			rescargo[i] = new RMC_DRVR_Cargo();
			rescargo[i].setApp_num(cargo.getApp_num());
			rescargo[i].setAracd_stat_ind(cargo.getAracd_stat_ind());
			rescargo[i].setArcat_stat_ind(cargo.getArcat_stat_ind());
			rescargo[i].setArhap_stat_ind(cargo.getArhap_stat_ind());
			rescargo[i].setArhcs_stat_ind(cargo.getArhcs_stat_ind());
			rescargo[i].setArhdd_stat_ind(cargo.getArhdd_stat_ind());
			rescargo[i].setArhde_stat_ind(cargo.getArhde_stat_ind());
			rescargo[i].setArhis_stat_ind(cargo.getArhis_stat_ind());
			rescargo[i].setArhma_stat_ind(cargo.getArhma_stat_ind());
			rescargo[i].setArhmd_stat_ind(cargo.getArhmd_stat_ind());
			rescargo[i].setArhmi_stat_ind(cargo.getArhmi_stat_ind());
			rescargo[i].setArhmo_stat_ind(cargo.getArhmo_stat_ind());
			rescargo[i].setArhpd_stat_ind(cargo.getArhpd_stat_ind());
			rescargo[i].setArhpg_stat_ind(cargo.getArhpg_stat_ind());
			rescargo[i].setArhrl_stat_ind(cargo.getArhrl_stat_ind());
			rescargo[i].setArhse_stat_ind(cargo.getArhse_stat_ind());
			rescargo[i].setArjid_stat_ind(cargo.getArjid_stat_ind());
			rescargo[i].setArehi_stat_ind(cargo.getArehi_stat_ind());
			rescargo[i].setArjis_stat_ind(cargo.getArjis_stat_ind());
			rescargo[i].setArjsd_stat_ind(cargo.getArjsd_stat_ind());
			rescargo[i].setArjse_stat_ind(cargo.getArjse_stat_ind());
			rescargo[i].setArprs_stat_ind(cargo.getArprs_stat_ind());
			rescargo[i].setArtky_stat_ind(cargo.getArtky_stat_ind());
			rescargo[i].setAruid_stat_ind(cargo.getAruid_stat_ind());
			rescargo[i].setAruii_stat_ind(cargo.getAruii_stat_ind());
			rescargo[i].setAruis_stat_ind(cargo.getAruis_stat_ind());
			rescargo[i].setAruit_stat_ind(cargo.getAruit_stat_ind());
			rescargo[i].setArxhd_stat_ind(cargo.getArxhd_stat_ind());
			rescargo[i].setArxhi_stat_ind(cargo.getArxhi_stat_ind());
			rescargo[i].setArxhs_stat_ind(cargo.getArxhs_stat_ind());
			rescargo[i].setArxhu_stat_ind(cargo.getArxhu_stat_ind());
			rescargo[i].setArxud_stat_ind(cargo.getArxud_stat_ind());
			rescargo[i].setHscso_stat_ind(cargo.getHscso_stat_ind());
			rescargo[i].setHsher_stat_ind(cargo.getHsher_stat_ind());
			rescargo[i].setHshmo_stat_ind(cargo.getHshmo_stat_ind());
			rescargo[i].setAracs_stat_ind(cargo.getAracs_stat_ind());
			rescargo[i].setAragq_stat_ind(cargo.getAragq_stat_ind());
			rescargo[i].setAraiq_stat_ind(cargo.getAraiq_stat_ind());
			rescargo[i].setArasm_stat_ind(cargo.getArasm_stat_ind());
			rescargo[i].setArbad_stat_ind(cargo.getArbad_stat_ind());
			rescargo[i].setArbat_stat_ind(cargo.getArbat_stat_ind());
			rescargo[i].setArdcd_stat_ind(cargo.getArdcd_stat_ind());
			rescargo[i].setArdfd_stat_ind(cargo.getArdfd_stat_ind());
			rescargo[i].setArfas_stat_ind(cargo.getArfas_stat_ind());
			rescargo[i].setArhcd_stat_ind(cargo.getArhcd_stat_ind());
			rescargo[i].setArhod_stat_ind(cargo.getArhod_stat_ind());
			rescargo[i].setAriwe_stat_ind(cargo.getAriwe_stat_ind());
			rescargo[i].setArjgq_stat_ind(cargo.getArjgq_stat_ind());
			rescargo[i].setArlad_stat_ind(cargo.getArlad_stat_ind());
			rescargo[i].setArlat_stat_ind(cargo.getArlat_stat_ind());
			rescargo[i].setArlid_stat_ind(cargo.getArlid_stat_ind());
			rescargo[i].setArlit_stat_ind(cargo.getArlit_stat_ind());
			rescargo[i].setArmap_stat_ind(cargo.getArmap_stat_ind());
			rescargo[i].setArmbd_stat_ind(cargo.getArmbd_stat_ind());
			rescargo[i].setArobc_stat_ind(cargo.getArobc_stat_ind());
			rescargo[i].setArobi_stat_ind(cargo.getArobi_stat_ind());
			rescargo[i].setArobq_stat_ind(cargo.getArobq_stat_ind());
			rescargo[i].setArobs_stat_ind(cargo.getArobs_stat_ind());
			rescargo[i].setAroiq_stat_ind(cargo.getAroiq_stat_ind());
			rescargo[i].setArpcs_stat_ind(cargo.getArpcs_stat_ind());
			rescargo[i].setArpgq_stat_ind(cargo.getArpgq_stat_ind());
			rescargo[i].setArpiq_stat_ind(cargo.getArpiq_stat_ind());
			rescargo[i].setArppd_stat_ind(cargo.getArppd_stat_ind());
			rescargo[i].setArrbe_stat_ind(cargo.getArrbe_stat_ind());
			rescargo[i].setArrpd_stat_ind(cargo.getArrpd_stat_ind());
			rescargo[i].setArrpt_stat_ind(cargo.getArrpt_stat_ind());
			rescargo[i].setArsod_stat_ind(cargo.getArsod_stat_ind());
			rescargo[i].setArvad_stat_ind(cargo.getArvad_stat_ind());
			rescargo[i].setArvat_stat_ind(cargo.getArvat_stat_ind());
			rescargo[i].setArxgq_stat_ind(cargo.getArxgq_stat_ind());
			rescargo[i].setArxiq_stat_ind(cargo.getArxiq_stat_ind());
			rescargo[i].setArrbi_stat_ind(cargo.getArrbi_stat_ind());
			rescargo[i].setArapa_stat_ind(cargo.getArapa_stat_ind());
			rescargo[i].setArplr_stat_ind(cargo.getArplr_stat_ind());
			rescargo[i].setArhca_stat_ind(cargo.getArhca_stat_ind());
			rescargo[i].setArpcd_stat_ind(cargo.getArpcd_stat_ind());
			rescargo[i].setArper_stat_ind(cargo.getArper_stat_ind());
			rescargo[i].setArhoh_stat_ind(cargo.getArhoh_stat_ind());
			rescargo[i].setArxfr_stat_ind(cargo.getArxfr_stat_ind());
			rescargo[i].setAroaq_stat_ind(cargo.getAroaq_stat_ind());
			rescargo[i].setAroac_stat_ind(cargo.getAroac_stat_ind());
			rescargo[i].setAroas_stat_ind(cargo.getAroas_stat_ind());
			rescargo[i].setArcpa_stat_ind(cargo.getArcpa_stat_ind());
			rescargo[i].setArstd_stat_ind(cargo.getArstd_stat_ind());
			rescargo[i].setAravd_stat_ind(cargo.getAravd_stat_ind());
			rescargo[i].setArdgp_stat_ind(cargo.getArdgp_stat_ind());
			rescargo[i].setArsum_stat_ind(cargo.getArsum_stat_ind());
			rescargo[i].setArhmx_stat_ind(cargo.getArhmx_stat_ind());
			rescargo[i].setArmed_stat_ind(cargo.getArmed_stat_ind());
			rescargo[i].setArhps_stat_ind(cargo.getArhps_stat_ind());
			rescargo[i].setArhos_stat_ind(cargo.getArhos_stat_ind());
			rescargo[i].setArnur_stat_ind(cargo.getArnur_stat_ind());
			rescargo[i].setArofs_stat_ind(cargo.getArofs_stat_ind());
			rescargo[i].setArort_stat_ind(cargo.getArort_stat_ind());
			rescargo[i].setArord_stat_ind(cargo.getArord_stat_ind());
			rescargo[i].setAriki_stat_ind(cargo.getAriki_stat_ind());
			//NextGen  NG-6481 Phase 3 updates to ACA Streamline changes : Start
			rescargo[i].setArbtt_stat_ind(cargo.getArbtt_stat_ind());
			rescargo[i].setArbtd_stat_ind(cargo.getArbtd_stat_ind());
			rescargo[i].setAritd_stat_ind(cargo.getAritd_stat_ind());
			//NextGen  NG-6481 Phase 3 updates to ACA Streamline changes : End
			rescargo[i].setArhbt_stat_ind(cargo.getArhbt_stat_ind());
			rescargo[i].setArbbq_stat_ind(cargo.getArbbq_stat_ind());
			rescargo[i].setArccc_stat_ind(cargo.getArccc_stat_ind());
			rescargo[i].setArcsc_stat_ind(cargo.getArcsc_stat_ind());
			rescargo[i].setArmbb_stat_ind(cargo.getArmbb_stat_ind());
			rescargo[i].setArbbs_stat_ind(cargo.getArbbs_stat_ind());
			rescargo[i].setArcta_stat_ind(cargo.getArcta_stat_ind());
			rescargo[i].setArcon_stat_ind(cargo.getArcon_stat_ind());
			rescargo[i].setArafp_stat_ind(cargo.getArafp_stat_ind());
			rescargo[i].setArmaa_stat_ind(cargo.getArmaa_stat_ind());
			rescargo[i].setAripi_stat_ind(cargo.getAripi_stat_ind());
			rescargo[i].setArmov_stat_ind(cargo.getArmov_stat_ind());
			rescargo[i].setArdoc_stat_ind(cargo.getArdoc_stat_ind());
			rescargo[i].setArarp_stat_ind(cargo.getArarp_stat_ind());
			rescargo[i].setArfin_stat_ind(cargo.getArfin_stat_ind());
			rescargo[i].setAridp_stat_ind(cargo.getAridp_stat_ind());
			rescargo[i].setArbus_stat_ind(cargo.getArbus_stat_ind());
			rescargo[i].setArhpa_stat_ind(cargo.getArhpa_stat_ind());
			rescargo[i].setArlhi_stat_ind(cargo.getArlhi_stat_ind());
			rescargo[i].setArhin_stat_ind(cargo.getArhin_stat_ind());
			rescargo[i].setArohi_stat_ind(cargo.getArohi_stat_ind());
			rescargo[i].setArtxi_stat_ind(cargo.getArtxi_stat_ind());
			rescargo[i].setArtdp_stat_ind(cargo.getArtdp_stat_ind());
			rescargo[i].setArtax_stat_ind(cargo.getArtax_stat_ind());
			rescargo[i].setArpre_stat_ind(cargo.getArpre_stat_ind());
			rescargo[i].setArrld_stat_ind(cargo.getArrld_stat_ind());
			rescargo[i].setArcfn_stat_ind(cargo.getArcfn_stat_ind());
			rescargo[i].setArbcn_stat_ind(cargo.getArbcn_stat_ind());

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
		if (obj instanceof RMC_DRVR_Cargo[]) {
			final RMC_DRVR_Cargo[] cbArray = (RMC_DRVR_Cargo[]) obj;
			setResults(cbArray);
		}
	}
}