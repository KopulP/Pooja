/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This class acts as a wrapper for one or many cargos
 *
 * @author Architecture Team
 * Creation Date Thu Nov 17 13:12:25 CST 2005 Modified By: Modified on: PCR#
 */
public class RMC_IN_PRFL_CUST_Collection extends AbstractCollection {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.impl.RMC_IN_PRFL";

	public RMC_IN_PRFL_CUST_Collection() {
	}

	public void addCargo(final RMC_IN_PRFL_CUST_Cargo newCargo) {
		add(newCargo);
	}

	/**
	 * Returns the package name.
	 *
	 * Creation Date Thu Nov 17 13:12:25 CST 2005
	 * @return gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Collection
	 */
	@Override
	public String getPACKAGE() {
		return PACKAGE;
	}

	/**
	 * Returns cargo.
	 *
	 * Creation Date Thu Nov 17 13:12:25 CST 2005
	 * @return java.lang.String
	 */
	public RMC_IN_PRFL_CUST_Cargo getCargo() {
		if (size() == 0) {
			add(new RMC_IN_PRFL_CUST_Cargo());
		}
		return (RMC_IN_PRFL_CUST_Cargo) get(0);
	}

	/**
	 * Sets cargo values.
	 *
	 * Creation Date Thu Nov 17 13:12:25 CST 2005
	 * @param newCargo
	 *            The newCargo to set
	 */

	public void setCargo(final RMC_IN_PRFL_CUST_Cargo newCargo) {
		if (size() == 0) {
			add(newCargo);
		} else {
			set(0, newCargo);
		}
	}

	/**
	 * Returns an abstract cargo.
	 *
	 * Creation Date Thu Nov 17 13:12:25 CST 2005
	 * @return gov.state.nextgen.access.business.entities.AbstractCargo
	 */
	public AbstractCargo getAbstractCargo() {
		return getCargo();
	}

	/**
	 * Sets abstract cargo.
	 *
	 * Creation Date Thu Nov 17 13:12:25 CST 2005
	 * @param cargo
	 *            The Cargo to set
	 */

	public void setAbstractCargo(final AbstractCargo cargo) {
		setCargo((RMC_IN_PRFL_CUST_Cargo) cargo);
	}

	/**
	 * Sets cargo array into collection.
	 *
	 * Creation Date Thu Nov 17 13:12:25 CST 2005
	 * @param cbArray
	 *            The cbArray to set
	 */

	public void setResults(final RMC_IN_PRFL_CUST_Cargo[] cbArray) {
		clear();
		for (int i = 0; i < cbArray.length; i++) {
			add(cbArray[i]);
		}
	}

	/**
	 * Sets a cargo into particular index of the collection
	 *
	 * Creation Date Thu Nov 17 13:12:25 CST 2005
	 * @param cb
	 *            The cbarray to set
	 * @param idx
	 *            The idx to set
	 */

	public void setResults(final int idx, final RMC_IN_PRFL_CUST_Cargo cb) {
		set(idx, cb);
	}

	/**
	 * Sets a cargo into particular index of the collection
	 *
	 * Creation Date Thu Nov 17 13:12:25 CST 2005
	 * @param obj
	 *            The cbarray to set
	 */

	@Override
	public void setGenericResults(final Object obj) {
		if (obj instanceof RMC_IN_PRFL_CUST_Cargo[]) {
			final RMC_IN_PRFL_CUST_Cargo[] cbArray = (RMC_IN_PRFL_CUST_Cargo[]) obj;
			for (int i = 0; i < cbArray.length; i++) {
				add(cbArray[i]);
			}
		}
	}

	/**
	 * Returns cargo array.
	 *
	 * Creation Date Thu Nov 17 13:12:25 CST 2005
	 * @return
	 *         gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Collection[
	 *         ]
	 */
	public RMC_IN_PRFL_CUST_Cargo[] getResults() {
		final RMC_IN_PRFL_CUST_Cargo[] cbArray = new RMC_IN_PRFL_CUST_Cargo[size()];
		toArray(cbArray);
		return cbArray;
	}

	/**
	 * Returns a particular cargo.
	 *
	 * Creation Date Thu Nov 17 13:12:25 CST 2005
	 * @return gov.state.nextgen.access.business.entities.RMC_IN_PRFL_Collection
	 */
	public RMC_IN_PRFL_CUST_Cargo getResult(final int idx) {
		return (RMC_IN_PRFL_CUST_Cargo) get(idx);
	}

	/**
	 * Returns size of a collection.
	 *
	 * Creation Date Thu Nov 17 13:12:25 CST 2005
	 * @return int
	 */
	public int getResultsSize() {
		return size();
	}
}
