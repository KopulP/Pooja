/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This class acts as a wrapper for one or many cargos
 *
 * @author Architecture Team
 * Creation Date Wed Aug 31 19:08:06 CDT 2005 Modified By: Modified on: PCR#
 */
public class HIST_MTH_CUST_Collection extends AbstractCollection {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.HIST_MTH_CUST";

	public HIST_MTH_CUST_Collection() {
	}

	public void addCargo(final HIST_MTH_CUST_Cargo newCargo) {
		add(newCargo);
	}

	/**
	 * Returns the package name.
	 *
	 * Creation Date Wed Aug 31 19:08:06 CDT 2005
	 * @return
	 *         gov.state.nextgen.access.business.entities.HIST_MTH_CUST_Collection
	 */
	@Override
	public String getPACKAGE() {
		return PACKAGE;
	}

	/**
	 * Returns cargo.
	 *
	 * Creation Date Wed Aug 31 19:08:06 CDT 2005
	 * @return java.lang.String
	 */
	public HIST_MTH_CUST_Cargo getCargo() {
		if (size() == 0) {
			add(new HIST_MTH_CUST_Cargo());
		}
		return (HIST_MTH_CUST_Cargo) get(0);
	}

	/**
	 * Sets cargo values.
	 *
	 * Creation Date Wed Aug 31 19:08:06 CDT 2005
	 * @param newCargo
	 *            The newCargo to set
	 */

	public void setCargo(final HIST_MTH_CUST_Cargo newCargo) {
		if (size() == 0) {
			add(newCargo);
		} else {
			set(0, newCargo);
		}
	}

	/**
	 * Returns an abstract cargo.
	 *
	 * Creation Date Wed Aug 31 19:08:06 CDT 2005
	 * @return gov.state.nextgen.access.business.entities.AbstractCargo
	 */
	public AbstractCargo getAbstractCargo() {
		return getCargo();
	}

	/**
	 * Sets abstract cargo.
	 *
	 * Creation Date Wed Aug 31 19:08:06 CDT 2005
	 * @param cargo
	 *            The Cargo to set
	 */

	public void setAbstractCargo(final AbstractCargo cargo) {
		setCargo((HIST_MTH_CUST_Cargo) cargo);
	}

	/**
	 * Sets cargo array into collection.
	 *
	 * Creation Date Wed Aug 31 19:08:06 CDT 2005
	 * @param cbArray
	 *            The cbArray to set
	 */

	public void setResults(final HIST_MTH_CUST_Cargo[] cbArray) {
		clear();
		for (int i = 0; i < cbArray.length; i++) {
			add(cbArray[i]);
		}
	}

	/**
	 * Sets a cargo into particular index of the collection
	 *
	 * Creation Date Wed Aug 31 19:08:06 CDT 2005
	 * @param cb
	 *            The cbarray to set
	 * @param idx
	 *            The idx to set
	 */

	public void setResults(final int idx, final HIST_MTH_CUST_Cargo cb) {
		set(idx, cb);
	}

	/**
	 * Sets a cargo into particular index of the collection
	 *
	 * Creation Date Wed Aug 31 19:08:06 CDT 2005
	 * @param obj
	 *            The cbarray to set
	 */

	@Override
	public void setGenericResults(final Object obj) {
		if (obj instanceof HIST_MTH_CUST_Cargo[]) {
			final HIST_MTH_CUST_Cargo[] cbArray = (HIST_MTH_CUST_Cargo[]) obj;
			for (int i = 0; i < cbArray.length; i++) {
				add(cbArray[i]);
			}
		}
	}

	/**
	 * Returns cargo array.
	 *
	 * Creation Date Wed Aug 31 19:08:06 CDT 2005
	 * @return
	 *         gov.state.nextgen.access.business.entities.HIST_MTH_CUST_Collection
	 *         []
	 */
	public HIST_MTH_CUST_Cargo[] getResults() {
		final HIST_MTH_CUST_Cargo[] cbArray = new HIST_MTH_CUST_Cargo[size()];
		toArray(cbArray);
		return cbArray;
	}

	/**
	 * Returns a particular cargo.
	 *
	 * Creation Date Wed Aug 31 19:08:06 CDT 2005
	 * @return
	 *         gov.state.nextgen.access.business.entities.HIST_MTH_CUST_Collection
	 */
	public HIST_MTH_CUST_Cargo getResult(final int idx) {
		return (HIST_MTH_CUST_Cargo) get(idx);
	}

	/**
	 * Returns size of a collection.
	 *
	 * Creation Date Wed Aug 31 19:08:06 CDT 2005
	 * @return int
	 */
	public int getResultsSize() {
		return size();
	}

	/** This one for clone Results */
	public HIST_MTH_CUST_Cargo[] cloneResults() {
		final HIST_MTH_CUST_Cargo[] rescargo = new HIST_MTH_CUST_Cargo[size()];
		for (int i = 0; i < size(); i++) {
			final HIST_MTH_CUST_Cargo cargo = getResult(i);
			rescargo[i] = new HIST_MTH_CUST_Cargo();
			rescargo[i].setCat_cd(cargo.getCat_cd());
			rescargo[i].setScat_seq_num(cargo.getScat_seq_num());
			rescargo[i].setMth_count(cargo.getMth_count());
			rescargo[i].setPymt_beg_dt(cargo.getPymt_beg_dt());
			rescargo[i].setPymt_end_dt(cargo.getPymt_end_dt());
			rescargo[i].setRowAction(cargo.getRowAction());
			rescargo[i].setUser(cargo.getUser());
			rescargo[i].setDirty(cargo.isDirty());
		}
		return rescargo;
	}

}
