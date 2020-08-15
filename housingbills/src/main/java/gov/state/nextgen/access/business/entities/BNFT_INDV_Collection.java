/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This class acts as a wrapper for one or many cargos of BNFT_INDV
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date Fri Jun 27 08:08:46 CDT 2008 Modified By: Modified on: PCR#
 */
public class BNFT_INDV_Collection extends AbstractCollection {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.impl.BNFT_INDV";

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
	public void addCargo(final BNFT_INDV_Cargo aNewCargo) {
		add(aNewCargo);
	}

	/**
	 * Sets cargo array into collection.
	 */
	public void setResults(final BNFT_INDV_Cargo[] cbArray) {
		clear();
		for (int i = 0; i < cbArray.length; i++) {
			add(cbArray[i]);
		}
	}

	/**
	 * Sets cargo into collection at the given index.
	 */
	public void setCargo(final int idx, final BNFT_INDV_Cargo aCargo) {
		set(idx, aCargo);
	}

	/**
	 * returns all the values in the Collection as Cargo Array.
	 */
	public BNFT_INDV_Cargo[] getResults() {
		final BNFT_INDV_Cargo[] cbArray = new BNFT_INDV_Cargo[size()];
		toArray(cbArray);
		return cbArray;
	}

	/**
	 * returns a cargo from the Collection for the given index.
	 */
	public BNFT_INDV_Cargo getCargo(final int idx) {
		return (BNFT_INDV_Cargo) get(idx);
	}

	/**
	 * This one for clone Results.
	 */
	public BNFT_INDV_Cargo[] cloneResults() {
		final BNFT_INDV_Cargo[] rescargo = new BNFT_INDV_Cargo[size()];
		for (int i = 0; i < size(); i++) {
			final BNFT_INDV_Cargo cargo = getCargo(i);
			rescargo[i] = new BNFT_INDV_Cargo();
			rescargo[i].setBnft_pin_num(cargo.getBnft_pin_num());
			rescargo[i].setBrth_dt(cargo.getBrth_dt());
			rescargo[i].setDth_dt(cargo.getDth_dt());
			rescargo[i].setFst_nam(cargo.getFst_nam());
			rescargo[i].setLast_nam(cargo.getLast_nam());
			rescargo[i].setMid_init(cargo.getMid_init());
			rescargo[i].setSex_ind(cargo.getSex_ind());
			rescargo[i].setSfx_nam(cargo.getSfx_nam());
			rescargo[i].setUpdt_dt(cargo.getUpdt_dt());
			rescargo[i].setMci_id(cargo.getMci_id());
			rescargo[i].setIc_flg(cargo.getIc_flg());
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
		if (obj instanceof BNFT_INDV_Cargo[]) {
			final BNFT_INDV_Cargo[] cbArray = (BNFT_INDV_Cargo[]) obj;
			setResults(cbArray);
		}
	}
}