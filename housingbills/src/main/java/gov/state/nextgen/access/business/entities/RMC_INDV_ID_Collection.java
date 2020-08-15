/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This class acts as a wrapper for one or many cargos of RMC_INDV_ID
 *
 * @author Architecture Team
 * Creation Date Tue Jun 06 22:08:16 CDT 2006 Modified By: Modified on: PCR#
 */
public class RMC_INDV_ID_Collection extends AbstractCollection {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.impl.RMC_INDV_ID";

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
	public void addCargo(final RMC_INDV_ID_Cargo aNewCargo) {
		add(aNewCargo);
	}

	/**
	 * Returns an abstract cargo.
	 */
	public AbstractCargo getAbstractCargo() {
		return (AbstractCargo) get(0);
	}

	/**
	 * Sets cargo array into collection.
	 */
	public void setResults(final RMC_INDV_ID_Cargo[] cbArray) {
		clear();
		for (int i = 0; i < cbArray.length; i++) {
			add(cbArray[i]);
		}
	}

	/**
	 * Sets cargo into collection at the given index.
	 */
	public void setCargo(final int idx, final RMC_INDV_ID_Cargo aCargo) {
		set(idx, aCargo);
	}

	/**
	 * returns all the values in the Collection as Cargo Array.
	 */
	public RMC_INDV_ID_Cargo[] getResults() {
		final RMC_INDV_ID_Cargo[] cbArray = new RMC_INDV_ID_Cargo[size()];
		toArray(cbArray);
		return cbArray;
	}

	/**
	 * returns a cargo from the Collection for the given index.
	 */
	public RMC_INDV_ID_Cargo getCargo(final int idx) {
		return (RMC_INDV_ID_Cargo) get(idx);
	}

	/**
	 * This one for clone Results.
	 */
	public RMC_INDV_ID_Cargo[] cloneResults() {
		final RMC_INDV_ID_Cargo[] rescargo = new RMC_INDV_ID_Cargo[size()];
		for (int i = 0; i < size(); i++) {
			final RMC_INDV_ID_Cargo cargo = getCargo(i);
			rescargo[i] = new RMC_INDV_ID_Cargo();
			rescargo[i].setApp_num(cargo.getApp_num());
			rescargo[i].setIndv_seq_num(cargo.getIndv_seq_num());
			rescargo[i].setPin_num(cargo.getPin_num());
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
		if (obj instanceof RMC_INDV_ID_Cargo[]) {
			final RMC_INDV_ID_Cargo[] cbArray = (RMC_INDV_ID_Cargo[]) obj;
			setResults(cbArray);
		}
	}

	/**
	 * Sets the cargo object to the collection.
	 */
	public void setAbstractCargo(final AbstractCargo aCargo) {
		if (size() == 0) {
			add(aCargo);
		} else {
			set(0, aCargo);
		}
	}
}