/**
 *
 */
package gov.state.nextgen.access.business.entities;

import gov.state.nextgen.access.business.entities.AbstractCollection;

import java.rmi.RemoteException;

/**
 * @author snarappanchavadi
 *
 */
public class AppInHouBillsCollection extends AbstractCollection {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.impl.APP_IN_HOU_BILLS";

	/**
	 *
	 */
	public AppInHouBillsCollection() {
	}

	@Override
	public void setGenericResults(final Object obj) throws RemoteException {
		if (obj instanceof AppInHouBillsCargo[]) {
			final AppInHouBillsCargo[] cbArray = (AppInHouBillsCargo[]) obj;
			setResults(cbArray);
		}

	}

	/**
	 * Sets cargo array into collection.
	 */
	public void setResults(final AppInHouBillsCargo[] cargos) {
		clear();
		for (int index = 0, length = cargos.length; index < length; index++) {
			add(cargos[index]);
		}
	}

	@Override
	public String getPACKAGE() {
		return PACKAGE;
	}

	public boolean addCargo(final AppInHouBillsCargo cargo) {
		return add(cargo);
	}

	public AppInHouBillsCargo getCargo(final int index) {
		return (AppInHouBillsCargo) get(index);
	}
}
