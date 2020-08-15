/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This class acts as a wrapper for one or many cargos of APP_IN_IRWE
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date Aug 26 15:31:21 CDT 2009 Modified By: Modified on: PCR#
 */
public class APP_IN_IRWE_Collection extends AbstractCollection {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.impl.APP_IN_IRWE";

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
	public void addCargo(final AppInIrweCargo aNewCargo) {
		add(aNewCargo);
	}

	/**
	 * Sets cargo array into collection.
	 */
	public void setResults(final AppInIrweCargo[] cbArray) {
		clear();
		for (int i = 0; i < cbArray.length; i++) {
			add(cbArray[i]);
		}
	}

	/**
	 * Sets cargo into collection at the given index.
	 */
	public void setCargo(final int idx, final AppInIrweCargo aCargo) {
		set(idx, aCargo);
	}

	/**
	 * returns all the values in the Collection as Cargo Array.
	 */
	public AppInIrweCargo[] getResults() {
		final AppInIrweCargo[] cbArray = new AppInIrweCargo[size()];
		toArray(cbArray);
		return cbArray;
	}

	/**
	 * returns a cargo from the Collection for the given index.
	 */
	public AppInIrweCargo getCargo(final int idx) {
		return (AppInIrweCargo) get(idx);
	}

	/**
	 * This one for clone Results.
	 */
	public AppInIrweCargo[] cloneResults() {
		final AppInIrweCargo[] rescargo = new AppInIrweCargo[size()];
		for (int i = 0; i < size(); i++) {
			final AppInIrweCargo cargo = getCargo(i);
			rescargo[i] = new AppInIrweCargo();
			rescargo[i].setChg_eff_dt(cargo.getChg_eff_dt());
			rescargo[i].setExp_typ_cd(cargo.getExp_typ_cd());
			rescargo[i].setMo_exp_amt(cargo.getMo_exp_amt());
			rescargo[i].setMo_exp_ind(cargo.getMo_exp_ind());

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
		if (obj instanceof AppInIrweCargo[]) {
			final AppInIrweCargo[] cbArray = (AppInIrweCargo[]) obj;
			setResults(cbArray);
		}
	}
}