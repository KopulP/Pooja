/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This class acts as a wrapper for one or many cargos
 *
 * @author Architecture Team
 * Creation Date Thu Jul 07 14:01:55 CDT 2005 Modified By: Modified on: PCR#
 */
public class BNFT_MSG_HIST_Collection extends AbstractCollection {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.BNFT_MSG_HIST";

	public BNFT_MSG_HIST_Collection() {
	}

	public void addCargo(final BNFT_MSG_HIST_Cargo newCargo) {
		add(newCargo);
	}

	/**
	 * Returns the package name.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @return
	 *         gov.state.nextgen.access.business.entities.BNFT_MSG_HIST_Collection
	 */
	@Override
	public String getPACKAGE() {
		return PACKAGE;
	}

	/**
	 * Returns cargo.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @return java.lang.String
	 */
	public BNFT_MSG_HIST_Cargo getCargo() {
		if (size() == 0) {
			add(new BNFT_MSG_HIST_Cargo());
		}
		return (BNFT_MSG_HIST_Cargo) get(0);
	}

	/**
	 * Sets cargo values.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @param newCargo
	 *            The newCargo to set
	 */

	public void setCargo(final BNFT_MSG_HIST_Cargo newCargo) {
		if (size() == 0) {
			add(newCargo);
		} else {
			set(0, newCargo);
		}
	}

	/**
	 * Returns an abstract cargo.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @return gov.state.nextgen.access.business.entities.AbstractCargo
	 */
	public AbstractCargo getAbstractCargo() {
		return getCargo();
	}

	/**
	 * Sets abstract cargo.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @param cargo
	 *            The Cargo to set
	 */

	public void setAbstractCargo(final AbstractCargo cargo) {
		setCargo((BNFT_MSG_HIST_Cargo) cargo);
	}

	/**
	 * Sets cargo array into collection.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @param cbArray
	 *            The cbArray to set
	 */

	public void setResults(final BNFT_MSG_HIST_Cargo[] cbArray) {
		clear();
		for (int i = 0; i < cbArray.length; i++) {
			add(cbArray[i]);
		}
	}

	/**
	 * Sets a cargo into particular index of the collection
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @param cb
	 *            The cbarray to set
	 * @param idx
	 *            The idx to set
	 */

	public void setResults(final int idx, final BNFT_MSG_HIST_Cargo cb) {
		set(idx, cb);
	}

	/**
	 * Sets a cargo into particular index of the collection
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @param obj
	 *            The cbarray to set
	 */

	@Override
	public void setGenericResults(final Object obj) {
		if (obj instanceof BNFT_MSG_HIST_Cargo[]) {
			final BNFT_MSG_HIST_Cargo[] cbArray = (BNFT_MSG_HIST_Cargo[]) obj;
			for (int i = 0; i < cbArray.length; i++) {
				add(cbArray[i]);
			}
		}
	}

	/**
	 * Returns cargo array.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @return
	 *         gov.state.nextgen.access.business.entities.BNFT_MSG_HIST_Collection
	 *         []
	 */
	public BNFT_MSG_HIST_Cargo[] getResults() {
		final BNFT_MSG_HIST_Cargo[] cbArray = new BNFT_MSG_HIST_Cargo[size()];
		toArray(cbArray);
		return cbArray;
	}

	/**
	 * Returns a particular cargo.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @return
	 *         gov.state.nextgen.access.business.entities.BNFT_MSG_HIST_Collection
	 */
	public BNFT_MSG_HIST_Cargo getResult(final int idx) {
		return (BNFT_MSG_HIST_Cargo) get(idx);
	}

	/**
	 * Returns size of a collection.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @return int
	 */
	public int getResultsSize() {
		return size();
	}

	/** This one for clone Results */
	public BNFT_MSG_HIST_Cargo[] cloneResults() {
		final BNFT_MSG_HIST_Cargo[] rescargo = new BNFT_MSG_HIST_Cargo[size()];
		for (int i = 0; i < size(); i++) {
			final BNFT_MSG_HIST_Cargo cargo = getResult(i);
			rescargo[i] = new BNFT_MSG_HIST_Cargo();
			rescargo[i].setBnft_pin_num(cargo.getBnft_pin_num());
			rescargo[i].setBnft_case_num(cargo.getBnft_case_num());
			rescargo[i].setCat_cd(cargo.getCat_cd());
			rescargo[i].setScat_cd(cargo.getScat_cd());
			rescargo[i].setMsg_dt(cargo.getMsg_dt());
			rescargo[i].setMsg_seq_num(cargo.getMsg_seq_num());
			rescargo[i].setTxt_id(cargo.getTxt_id());
			rescargo[i].setMsg_txt(cargo.getMsg_txt());
			rescargo[i].setRowAction(cargo.getRowAction());
			rescargo[i].setUser(cargo.getUser());
			rescargo[i].setDirty(cargo.isDirty());
		}
		return rescargo;
	}

}
