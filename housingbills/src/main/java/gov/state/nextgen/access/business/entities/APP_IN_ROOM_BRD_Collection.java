/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This class acts as a wrapper for one or many cargos of APP_IN_ROOM_BRD
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date Aug 12 10:56:21 CDT 2009 Modified By: Modified on: PCR#
 */
public class APP_IN_ROOM_BRD_Collection extends AbstractCollection {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.impl.APP_IN_ROOM_BRD";

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
	public void addCargo(final AppInRoomBrdCargo aNewCargo) {
		add(aNewCargo);
	}

	/**
	 * Sets cargo array into collection.
	 */
	public void setResults(final AppInRoomBrdCargo[] cbArray) {
		clear();
		for (int i = 0; i < cbArray.length; i++) {
			add(cbArray[i]);
		}
	}

	/**
	 * Sets cargo into collection at the given index.
	 */
	public void setCargo(final int idx, final AppInRoomBrdCargo aCargo) {
		set(idx, aCargo);
	}

	/**
	 * returns all the values in the Collection as Cargo Array.
	 */
	public AppInRoomBrdCargo[] getResults() {
		final AppInRoomBrdCargo[] cbArray = new AppInRoomBrdCargo[size()];
		toArray(cbArray);
		return cbArray;
	}

	/**
	 * returns a cargo from the Collection for the given index.
	 */
	public AppInRoomBrdCargo getCargo(final int idx) {
		return (AppInRoomBrdCargo) get(idx);
	}

	/**
	 * This one for clone Results.
	 */
	public AppInRoomBrdCargo[] cloneResults() {
		final AppInRoomBrdCargo[] rescargo = new AppInRoomBrdCargo[size()];
		for (int i = 0; i < size(); i++) {
			final AppInRoomBrdCargo cargo = getCargo(i);
			rescargo[i] = new AppInRoomBrdCargo();

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
		if (obj instanceof AppInRoomBrdCargo[]) {
			final AppInRoomBrdCargo[] cbArray = (AppInRoomBrdCargo[]) obj;
			setResults(cbArray);
		}
	}
}