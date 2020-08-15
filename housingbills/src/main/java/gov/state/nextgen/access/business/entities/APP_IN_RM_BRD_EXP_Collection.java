/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This class acts as a wrapper for one or many cargos of APP_IN_RM_BRD_EXP
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date Aug 26 15:38:04 CDT 2009 Modified By: Modified on: PCR#
 */
public class APP_IN_RM_BRD_EXP_Collection extends AbstractCollection {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.impl.APP_IN_RM_BRD_EXP";

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
	public void addCargo(final AppInRmBrdExpCargo aNewCargo) {
		add(aNewCargo);
	}

	/**
	 * Sets cargo array into collection.
	 */
	public void setResults(final AppInRmBrdExpCargo[] cbArray) {
		clear();
		for (int i = 0; i < cbArray.length; i++) {
			add(cbArray[i]);
		}
	}

	/**
	 * Sets cargo into collection at the given index.
	 */
	public void setCargo(final int idx, final AppInRmBrdExpCargo aCargo) {
		set(idx, aCargo);
	}

	/**
	 * returns all the values in the Collection as Cargo Array.
	 */
	public AppInRmBrdExpCargo[] getResults() {
		final AppInRmBrdExpCargo[] cbArray = new AppInRmBrdExpCargo[size()];
		toArray(cbArray);
		return cbArray;
	}

	/**
	 * returns a cargo from the Collection for the given index.
	 */
	public AppInRmBrdExpCargo getCargo(final int idx) {
		return (AppInRmBrdExpCargo) get(idx);
	}

	/**
	 * This one for clone Results.
	 */
	public AppInRmBrdExpCargo[] cloneResults() {
		final AppInRmBrdExpCargo[] rescargo = new AppInRmBrdExpCargo[size()];
		for (int i = 0; i < size(); i++) {
			final AppInRmBrdExpCargo cargo = getCargo(i);
			rescargo[i] = new AppInRmBrdExpCargo();
			rescargo[i].setBrd_exp_amt(cargo.getBrd_exp_amt());
			rescargo[i].setBrd_exp_ind(cargo.getBrd_exp_ind());
			rescargo[i].setBrder_sw(cargo.getBrder_sw());
			rescargo[i].setChg_eff_dt(cargo.getChg_eff_dt());
			rescargo[i].setP_to_indv_seq_num(cargo.getP_to_indv_seq_num());
			rescargo[i].setRoom_exp_amt(cargo.getRoom_exp_amt());
			rescargo[i].setRoom_exp_ind(cargo.getRoom_exp_ind());
			rescargo[i].setRoom_meal_dy_qty(cargo.getRoom_meal_dy_qty());
			rescargo[i].setRoomer_sw(cargo.getRoomer_sw());

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
		if (obj instanceof AppInRmBrdExpCargo[]) {
			final AppInRmBrdExpCargo[] cbArray = (AppInRmBrdExpCargo[]) obj;
			setResults(cbArray);
		}
	}
}