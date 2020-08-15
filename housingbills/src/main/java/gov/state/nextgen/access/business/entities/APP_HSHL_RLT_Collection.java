/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This class acts as a wrapper for one or many cargos of APP_HSHL_RLT
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date Jun 3 17:14:45 EDT 2009 Modified By: Modified on: PCR#
 */
public class APP_HSHL_RLT_Collection extends AbstractCollection {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.impl.APP_HSHL_RLT";

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
	public void addCargo(final APP_HSHL_RLT_Cargo aNewCargo) {
		add(aNewCargo);
	}

	/**
	 * Sets cargo array into collection.
	 */
	public void setResults(final APP_HSHL_RLT_Cargo[] cbArray) {
		clear();
		for (int i = 0; i < cbArray.length; i++) {
			add(cbArray[i]);
		}
	}

	/**
	 * Sets cargo into collection at the given index.
	 */
	public void setCargo(final int idx, final APP_HSHL_RLT_Cargo aCargo) {
		set(idx, aCargo);
	}

	/**
	 * returns all the values in the Collection as Cargo Array.
	 */
	public APP_HSHL_RLT_Cargo[] getResults() {
		final APP_HSHL_RLT_Cargo[] cbArray = new APP_HSHL_RLT_Cargo[size()];
		toArray(cbArray);
		return cbArray;
	}

	/**
	 * returns a cargo from the Collection for the given index.
	 */
	public APP_HSHL_RLT_Cargo getCargo(final int idx) {
		return (APP_HSHL_RLT_Cargo) get(idx);
	}

	/**
	 * This one for clone Results.
	 */
	public APP_HSHL_RLT_Cargo[] cloneResults() {
		final APP_HSHL_RLT_Cargo[] rescargo = new APP_HSHL_RLT_Cargo[size()];
		for (int i = 0; i < size(); i++) {
			final APP_HSHL_RLT_Cargo cargo = getCargo(i);
			rescargo[i] = new APP_HSHL_RLT_Cargo();
			rescargo[i].setApp_num(cargo.getApp_num());
			rescargo[i].setRef_indv_seq_num(cargo.getRef_indv_seq_num());
			rescargo[i].setSrc_indv_seq_num(cargo.getSrc_indv_seq_num());
			rescargo[i].setSrc_app_ind(cargo.getSrc_app_ind());
			rescargo[i].setCare_resp(cargo.getCare_resp());
			rescargo[i].setChg_eff_dt(cargo.getChg_eff_dt());
//			rescargo[i].setPnp_tghr_sw(cargo.getPnp_tghr_sw());
			rescargo[i].setRec_cplt_ind(cargo.getRec_cplt_ind());
			rescargo[i].setRlt_cd(cargo.getRlt_cd());
			rescargo[i].setPhy_boe_sep_sw(cargo.getPhy_boe_sep_sw());
			rescargo[i].setTax_dpnd_resp(cargo.getTax_dpnd_resp());
			rescargo[i].setChg_dt(cargo.getChg_dt());

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
		if (obj instanceof APP_HSHL_RLT_Cargo[]) {
			final APP_HSHL_RLT_Cargo[] cbArray = (APP_HSHL_RLT_Cargo[]) obj;
			setResults(cbArray);
		}
	}
}