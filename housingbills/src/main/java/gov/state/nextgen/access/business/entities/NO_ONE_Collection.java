/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This class acts as a wrapper for one or many cargos
 *
 * @author Architecture Team
 * Creation Date Thu Jun 24 19:05:40 CDT 2004 Modified By: Modified on: PCR#
 */
public class NO_ONE_Collection extends AbstractCollection {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.NO_ONE";

	public NO_ONE_Collection() {
	}

	public void addCargo(final NO_ONE_Cargo newCargo) {
		add(newCargo);
	}

	/**
	 * Returns the package name.
	 *
	 * Creation Date Thu Jun 24 19:05:40 CDT 2004
	 * @return gov.state.nextgen.access.business.entities.NO_ONE_Collection
	 */
	@Override
	public String getPACKAGE() {
		return PACKAGE;
	}

	/**
	 * Returns cargo.
	 *
	 * Creation Date Thu Jun 24 19:05:40 CDT 2004
	 * @return java.lang.String
	 */
	public NO_ONE_Cargo getCargo() {
		if (size() == 0) {
			add(new NO_ONE_Cargo());
		}
		return (NO_ONE_Cargo) get(0);
	}

	/**
	 * Sets cargo values.
	 *
	 * Creation Date Thu Jun 24 19:05:40 CDT 2004
	 * @param newCargo
	 *            The newCargo to set
	 */

	public void setCargo(final NO_ONE_Cargo newCargo) {
		if (size() == 0) {
			add(newCargo);
		} else {
			set(0, newCargo);
		}
	}

	/**
	 * Returns an abstract cargo.
	 *
	 * Creation Date Thu Jun 24 19:05:40 CDT 2004
	 * @return gov.state.nextgen.access.business.entities.AbstractCargo
	 */
	public AbstractCargo getAbstractCargo() {
		return getCargo();
	}

	/**
	 * Sets abstract cargo.
	 *
	 * Creation Date Thu Jun 24 19:05:40 CDT 2004
	 * @param cargo
	 *            The Cargo to set
	 */

	public void setAbstractCargo(final AbstractCargo cargo) {
		setCargo((NO_ONE_Cargo) cargo);
	}

	/**
	 * Sets cargo array into collection.
	 *
	 * Creation Date Thu Jun 24 19:05:40 CDT 2004
	 * @param cbArray
	 *            The cbArray to set
	 */

	public void setResults(final NO_ONE_Cargo[] cbArray) {
		clear();
		for (int i = 0; i < cbArray.length; i++) {
			add(cbArray[i]);
		}
	}

	/**
	 * Sets a cargo into particular index of the collection
	 *
	 * Creation Date Thu Jun 24 19:05:40 CDT 2004
	 * @param cb
	 *            The cbarray to set
	 * @param idx
	 *            The idx to set
	 */

	public void setResults(final int idx, final NO_ONE_Cargo cb) {
		set(idx, cb);
	}

	/**
	 * Sets a cargo into particular index of the collection
	 *
	 * Creation Date Thu Jun 24 19:05:40 CDT 2004
	 * @param obj
	 *            The cbarray to set
	 */

	@Override
	public void setGenericResults(final Object obj) {
		if (obj instanceof NO_ONE_Cargo[]) {
			final NO_ONE_Cargo[] cbArray = (NO_ONE_Cargo[]) obj;
			for (int i = 0; i < cbArray.length; i++) {
				add(cbArray[i]);
			}
		}
	}

	/**
	 * Returns cargo array.
	 *
	 * Creation Date Thu Jun 24 19:05:40 CDT 2004
	 * @return gov.state.nextgen.access.business.entities.NO_ONE_Collection[]
	 */
	public NO_ONE_Cargo[] getResults() {
		final NO_ONE_Cargo[] cbArray = new NO_ONE_Cargo[size()];
		toArray(cbArray);
		return cbArray;
	}

	/**
	 * Returns a particular cargo.
	 *
	 * Creation Date Thu Jun 24 19:05:40 CDT 2004
	 * @return gov.state.nextgen.access.business.entities.NO_ONE_Collection
	 */
	public NO_ONE_Cargo getResult(final int idx) {
		return (NO_ONE_Cargo) get(idx);
	}

	/**
	 * Returns size of a collection.
	 *
	 * Creation Date Thu Jun 24 19:05:40 CDT 2004
	 * @return int
	 */
	public int getResultsSize() {
		return size();
	}
}