/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This class acts as a wrapper for one or many cargos
 *
 * @author Architecture Team
 * Creation Date WED Nov 30 Modified By: Modified on: PCR#
 */
public class RMC_RESPONSE_Custom_Collection extends AbstractCollection {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.APP_INDV";

	public RMC_RESPONSE_Custom_Collection() {
	}

	public void addCargo(final RMC_RESPONSE_Custom_Cargo newCargo) {
		add(newCargo);
	}

	/**
	 * Returns the package name.
	 *
	 * @return gov.state.nextgen.access.business.customEntities.
	 *         INDIVIDUAL_Custom_Collection
	 */
	@Override
	public String getPACKAGE() {
		return PACKAGE;
	}

	/**
	 * Returns cargo.
	 *
	 * @return java.lang.String
	 */
	public RMC_RESPONSE_Custom_Cargo getCargo(final int idx) {
		return (RMC_RESPONSE_Custom_Cargo) get(idx);
	}

	/**
	 * Sets cargo values.
	 *
	 * @param newCargo
	 *            The newCargo to set
	 */

	public void setCargo(final RMC_RESPONSE_Custom_Cargo newCargo) {
		if (size() == 0) {
			add(newCargo);
		} else {
			set(0, newCargo);
		}
	}

	/**
	 * Sets cargo array into collection.
	 *
	 * @param cbArray
	 *            The cbArray to set
	 */

	public void setResults(final RMC_RESPONSE_Custom_Cargo[] cbArray) {
		clear();
		for (int i = 0; i < cbArray.length; i++) {
			add(cbArray[i]);
		}
	}

	/**
	 * Sets a cargo into particular index of the collection
	 *
	 * @param cb
	 *            The cbarray to set
	 * @param idx
	 *            The idx to set
	 */

	public void setResult(final int idx, final RMC_RESPONSE_Custom_Cargo cb) {
		set(idx, cb);
	}

	/**
	 * Sets a cargo into particular index of the collection
	 *
	 * @param obj
	 *            The cbarray to set
	 */

	@Override
	public void setGenericResults(final Object obj) {
		if (obj instanceof RMC_RESPONSE_Custom_Cargo[]) {
			final RMC_RESPONSE_Custom_Cargo[] cbArray = (RMC_RESPONSE_Custom_Cargo[]) obj;
			for (int i = 0; i < cbArray.length; i++) {
				add(cbArray[i]);
			}
		}
	}

	/**
	 * Returns cargo array.
	 *
	 * @return gov.state.nextgen.access.business.entities.APP_INDV_Collection[]
	 */
	public RMC_RESPONSE_Custom_Cargo[] getResults() {
		final RMC_RESPONSE_Custom_Cargo[] cbArray = new RMC_RESPONSE_Custom_Cargo[size()];
		toArray(cbArray);
		return cbArray;
	}

	/**
	 * Returns a particular cargo.
	 *
	 * @return gov.state.nextgen.access.business.entities.APP_INDV_Collection
	 */
	public RMC_RESPONSE_Custom_Cargo getResult(final int idx) {
		return (RMC_RESPONSE_Custom_Cargo) get(idx);
	}

	/**
	 * Returns size of a collection.
	 *
	 * @return int
	 */
	public int getResultsSize() {
		return size();
	}

	/** This one for clone Results */
	public RMC_RESPONSE_Custom_Cargo[] cloneResults() {
		final RMC_RESPONSE_Custom_Cargo[] rescargo = new RMC_RESPONSE_Custom_Cargo[size()];
		for (int i = 0; i < size(); i++) {
			final RMC_RESPONSE_Custom_Cargo cargo = getResult(i);
			rescargo[i] = new RMC_RESPONSE_Custom_Cargo();
			rescargo[i].setIndvSeqNum(cargo.getIndvSeqNum());
			rescargo[i].setSeqNum(cargo.getSeqNum());
			rescargo[i].setResponse(cargo.getResponse());
			rescargo[i].setCategoryType(cargo.getCategoryType());
			rescargo[i].setChangeSelectionCategoryCd(cargo.getChangeSelectionCategoryCd());
			rescargo[i].setUserEndSelectionInd(cargo.getUserEndSelectionInd());
		}
		return rescargo;
	}

}
