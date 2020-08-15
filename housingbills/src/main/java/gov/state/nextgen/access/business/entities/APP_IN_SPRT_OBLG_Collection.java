/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This class acts as a wrapper for one or many cargos of APP_IN_SPRT_OBLG
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date Aug 26 15:58:45 CDT 2009 Modified By: Modified on: PCR#
 */
public class APP_IN_SPRT_OBLG_Collection extends AbstractCollection {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.impl.APP_IN_SPRT_OBLG";

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
	public void addCargo(final APP_IN_SPRT_OBLG_Cargo aNewCargo) {
		add(aNewCargo);
	}

	/**
	 * Sets cargo array into collection.
	 */
	public void setResults(final APP_IN_SPRT_OBLG_Cargo[] cbArray) {
		clear();
		for (int i = 0; i < cbArray.length; i++) {
			add(cbArray[i]);
		}
	}

	/**
	 * Sets cargo into collection at the given index.
	 */
	public void setCargo(final int idx, final APP_IN_SPRT_OBLG_Cargo aCargo) {
		set(idx, aCargo);
	}

	/**
	 * returns all the values in the Collection as Cargo Array.
	 */
	public APP_IN_SPRT_OBLG_Cargo[] getResults() {
		final APP_IN_SPRT_OBLG_Cargo[] cbArray = new APP_IN_SPRT_OBLG_Cargo[size()];
		toArray(cbArray);
		return cbArray;
	}

	/**
	 * returns a cargo from the Collection for the given index.
	 */
	public APP_IN_SPRT_OBLG_Cargo getCargo(final int idx) {
		return (APP_IN_SPRT_OBLG_Cargo) get(idx);
	}

	/**
	 * This one for clone Results.
	 */
	public APP_IN_SPRT_OBLG_Cargo[] cloneResults() {
		final APP_IN_SPRT_OBLG_Cargo[] rescargo = new APP_IN_SPRT_OBLG_Cargo[size()];
		for (int i = 0; i < size(); i++) {
			final APP_IN_SPRT_OBLG_Cargo cargo = getCargo(i);
			rescargo[i].setChg_eff_dt(cargo.getChg_eff_dt());
			rescargo[i].setCrt_ord_sw(cargo.getCrt_ord_sw());
			rescargo[i].setOblg_amt(cargo.getOblg_amt());
			rescargo[i].setOblg_ind(cargo.getOblg_ind());
			rescargo[i].setSprt_typ_cd(cargo.getSprt_typ_cd());

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
		if (obj instanceof APP_IN_SPRT_OBLG_Cargo[]) {
			final APP_IN_SPRT_OBLG_Cargo[] cbArray = (APP_IN_SPRT_OBLG_Cargo[]) obj;
			setResults(cbArray);
		}
	}
}