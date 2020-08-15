/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This class acts as a wrapper for one or many cargos
 *
 * @author Architecture Team
 * Creation Date Mon Jan 23 13:28:44 CST 2006 Modified By: Modified on: PCR#
 */
public class APP_IN_DC_E_Collection extends AbstractCollection {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.APP_IN_DC_E";

	public APP_IN_DC_E_Collection() {
	}

	public void addCargo(final AppInDcECargo newCargo) {
		add(newCargo);
	}

	/**
	 * Returns the package name.
	 *
	 * Creation Date Mon Jan 23 13:28:44 CST 2006
	 * @return gov.state.nextgen.access.business.entities.APP_IN_DC_E_Collection
	 */
	@Override
	public String getPACKAGE() {
		return PACKAGE;
	}

	/**
	 * Returns cargo.
	 *
	 * Creation Date Mon Jan 23 13:28:44 CST 2006
	 * @return java.lang.String
	 */
	public AppInDcECargo getCargo() {
		if (size() == 0) {
			add(new AppInDcECargo());
		}
		return (AppInDcECargo) get(0);
	}

	// EDSP CP starts
	/**
	 * returns a cargo from the Collection for the given index.
	 */
	public AppInDcECargo getCargo(final int idx) {
		return (AppInDcECargo) get(idx);
	}

	/**
	 * Sets cargo into collection at the given index.
	 */
	public void setCargo(final int idx, final AppInDcECargo aCargo) {
		set(idx, aCargo);
	}

	// EDSP CP Ends

	/**
	 * Sets cargo values.
	 *
	 * Creation Date Mon Jan 23 13:28:44 CST 2006
	 * @param newCargo
	 *            The newCargo to set
	 */

	public void setCargo(final AppInDcECargo newCargo) {
		if (size() == 0) {
			add(newCargo);
		} else {
			set(0, newCargo);
		}
	}

	/**
	 * Returns an abstract cargo.
	 *
	 * Creation Date Mon Jan 23 13:28:44 CST 2006
	 * @return gov.state.nextgen.access.business.entities.AbstractCargo
	 */
	public AbstractCargo getAbstractCargo() {
		return getCargo();
	}

	/**
	 * Sets abstract cargo.
	 *
	 * Creation Date Mon Jan 23 13:28:44 CST 2006
	 * @param cargo
	 *            The Cargo to set
	 */

	public void setAbstractCargo(final AbstractCargo cargo) {
		setCargo((AppInDcECargo) cargo);
	}

	/**
	 * Sets cargo array into collection.
	 *
	 * Creation Date Mon Jan 23 13:28:44 CST 2006
	 * @param cbArray
	 *            The cbArray to set
	 */

	public void setResults(final AppInDcECargo[] cbArray) {
		clear();
		for (int i = 0; i < cbArray.length; i++) {
			add(cbArray[i]);
		}
	}

	/**
	 * Sets a cargo into particular index of the collection
	 *
	 * Creation Date Mon Jan 23 13:28:44 CST 2006
	 * @param cb
	 *            The cbarray to set
	 * @param idx
	 *            The idx to set
	 */

	public void setResults(final int idx, final AppInDcECargo cb) {
		set(idx, cb);
	}

	/**
	 * Sets a cargo into particular index of the collection
	 *
	 * Creation Date Mon Jan 23 13:28:44 CST 2006
	 * @param obj
	 *            The cbarray to set
	 */

	@Override
	public void setGenericResults(final Object obj) {
		if (obj instanceof AppInDcECargo[]) {
			final AppInDcECargo[] cbArray = (AppInDcECargo[]) obj;
			for (int i = 0; i < cbArray.length; i++) {
				add(cbArray[i]);
			}
		}
	}

	/**
	 * Returns cargo array.
	 *
	 * Creation Date Mon Jan 23 13:28:44 CST 2006
	 * @return
	 *         gov.state.nextgen.access.business.entities.APP_IN_DC_E_Collection[
	 *         ]
	 */
	public AppInDcECargo[] getResults() {
		final AppInDcECargo[] cbArray = new AppInDcECargo[size()];
		toArray(cbArray);
		return cbArray;
	}

	/**
	 * Returns a particular cargo.
	 *
	 * Creation Date Mon Jan 23 13:28:44 CST 2006
	 * @return gov.state.nextgen.access.business.entities.APP_IN_DC_E_Collection
	 */
	public AppInDcECargo getResult(final int idx) {
		return (AppInDcECargo) get(idx);
	}

	/**
	 * Returns size of a collection.
	 *
	 * Creation Date Mon Jan 23 13:28:44 CST 2006
	 * @return int
	 */
	public int getResultsSize() {
		return size();
	}

	/** This one for clone Results */
	public AppInDcECargo[] cloneResults() {
		final AppInDcECargo[] rescargo = new AppInDcECargo[size()];
		for (int i = 0; i < size(); i++) {
			final AppInDcECargo cargo = getResult(i);
			rescargo[i] = new AppInDcECargo();
			rescargo[i].setEcp_id(cargo.getEcp_id());
			rescargo[i].setSeq_num(cargo.getSeq_num());
			rescargo[i].setDpnd_care_exp_amt(cargo.getDpnd_care_exp_amt());
			rescargo[i].setDpnd_care_exp_ind(cargo.getDpnd_care_exp_ind());
			rescargo[i].setDpnd_exp_paid_amt(cargo.getDpnd_exp_paid_amt());
			rescargo[i].setDpnd_exp_paid_ind(cargo.getDpnd_exp_paid_ind());
			rescargo[i].setPaid_in_seq_num(cargo.getPaid_in_seq_num());
			rescargo[i].setPrvd_fst_nam(cargo.getPrvd_fst_nam());
			rescargo[i].setPrvd_in_seq_num(cargo.getPrvd_in_seq_num());
			rescargo[i].setPrvd_last_nam(cargo.getPrvd_last_nam());
			rescargo[i].setPrvd_org_nam(cargo.getPrvd_org_nam());
			rescargo[i].setPrvd_typ(cargo.getPrvd_typ());
			rescargo[i].setRec_cplt_ind(cargo.getRec_cplt_ind());
			rescargo[i].setPrvd_nam_org_ind(cargo.getPrvd_nam_org_ind());
			rescargo[i].setPrvd_nam_ind(cargo.getPrvd_nam_ind());
			rescargo[i].setPay_freq(cargo.getPay_freq());
			rescargo[i].setChg_dt(cargo.getChg_dt());
			rescargo[i].setRowAction(cargo.getRowAction());
			rescargo[i].setUser(cargo.getUser());
			rescargo[i].setDirty(cargo.isDirty());
		}
		return rescargo;
	}

}
