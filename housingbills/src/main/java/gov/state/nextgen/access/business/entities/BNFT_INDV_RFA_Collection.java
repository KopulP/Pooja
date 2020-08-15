/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This class acts as a wrapper for one or many cargos
 *
 * @author Architecture Team
 * Creation Date Wed Aug 10 08:55:17 CDT 2005 Modified By: Modified on: PCR#
 */
public class BNFT_INDV_RFA_Collection extends AbstractCollection {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.BNFT_INDV_RFA";

	public BNFT_INDV_RFA_Collection() {
	}

	public void addCargo(final BNFT_INDV_RFA_Cargo newCargo) {
		add(newCargo);
	}

	/**
	 * Returns the package name.
	 *
	 * Creation Date Wed Aug 10 08:55:17 CDT 2005
	 * @return
	 *         gov.state.nextgen.access.business.entities.BNFT_INDV_RFA_Collection
	 */
	@Override
	public String getPACKAGE() {
		return PACKAGE;
	}

	/**
	 * Returns cargo.
	 *
	 * Creation Date Wed Aug 10 08:55:17 CDT 2005
	 * @return java.lang.String
	 */
	public BNFT_INDV_RFA_Cargo getCargo() {
		if (size() == 0) {
			add(new BNFT_INDV_RFA_Cargo());
		}
		return (BNFT_INDV_RFA_Cargo) get(0);
	}

	/**
	 * Sets cargo values.
	 *
	 * Creation Date Wed Aug 10 08:55:17 CDT 2005
	 * @param newCargo
	 *            The newCargo to set
	 */

	public void setCargo(final BNFT_INDV_RFA_Cargo newCargo) {
		if (size() == 0) {
			add(newCargo);
		} else {
			set(0, newCargo);
		}
	}

	/**
	 * Returns an abstract cargo.
	 *
	 * Creation Date Wed Aug 10 08:55:17 CDT 2005
	 * @return gov.state.nextgen.access.business.entities.AbstractCargo
	 */
	public AbstractCargo getAbstractCargo() {
		return getCargo();
	}

	/**
	 * Sets abstract cargo.
	 *
	 * Creation Date Wed Aug 10 08:55:17 CDT 2005
	 * @param cargo
	 *            The Cargo to set
	 */

	public void setAbstractCargo(final AbstractCargo cargo) {
		setCargo((BNFT_INDV_RFA_Cargo) cargo);
	}

	/**
	 * Sets cargo array into collection.
	 *
	 * Creation Date Wed Aug 10 08:55:17 CDT 2005
	 * @param cbArray
	 *            The cbArray to set
	 */

	public void setResults(final BNFT_INDV_RFA_Cargo[] cbArray) {
		clear();
		for (int i = 0; i < cbArray.length; i++) {
			add(cbArray[i]);
		}
	}

	/**
	 * Sets a cargo into particular index of the collection
	 *
	 * Creation Date Wed Aug 10 08:55:17 CDT 2005
	 * @param cb
	 *            The cbarray to set
	 * @param idx
	 *            The idx to set
	 */

	public void setResults(final int idx, final BNFT_INDV_RFA_Cargo cb) {
		set(idx, cb);
	}

	/**
	 * Sets a cargo into particular index of the collection
	 *
	 * Creation Date Wed Aug 10 08:55:17 CDT 2005
	 * @param obj
	 *            The cbarray to set
	 */

	@Override
	public void setGenericResults(final Object obj) {
		if (obj instanceof BNFT_INDV_RFA_Cargo[]) {
			final BNFT_INDV_RFA_Cargo[] cbArray = (BNFT_INDV_RFA_Cargo[]) obj;
			for (int i = 0; i < cbArray.length; i++) {
				add(cbArray[i]);
			}
		}
	}

	/**
	 * Returns cargo array.
	 *
	 * Creation Date Wed Aug 10 08:55:17 CDT 2005
	 * @return
	 *         gov.state.nextgen.access.business.entities.BNFT_INDV_RFA_Collection
	 *         []
	 */
	public BNFT_INDV_RFA_Cargo[] getResults() {
		final BNFT_INDV_RFA_Cargo[] cbArray = new BNFT_INDV_RFA_Cargo[size()];
		toArray(cbArray);
		return cbArray;
	}

	/**
	 * Returns a particular cargo.
	 *
	 * Creation Date Wed Aug 10 08:55:17 CDT 2005
	 * @return
	 *         gov.state.nextgen.access.business.entities.BNFT_INDV_RFA_Collection
	 */
	public BNFT_INDV_RFA_Cargo getResult(final int idx) {
		return (BNFT_INDV_RFA_Cargo) get(idx);
	}

	/**
	 * Returns size of a collection.
	 *
	 * Creation Date Wed Aug 10 08:55:17 CDT 2005
	 * @return int
	 */
	public int getResultsSize() {
		return size();
	}

	/** This one for clone Results */
	public BNFT_INDV_RFA_Cargo[] cloneResults() {
		final BNFT_INDV_RFA_Cargo[] rescargo = new BNFT_INDV_RFA_Cargo[size()];
		for (int i = 0; i < size(); i++) {
			final BNFT_INDV_RFA_Cargo cargo = getResult(i);
			rescargo[i] = new BNFT_INDV_RFA_Cargo();
			rescargo[i].setBnft_pin_num(cargo.getBnft_pin_num());
			rescargo[i].setBnft_rfa_num(cargo.getBnft_rfa_num());
			rescargo[i].setApp_stat_ind(cargo.getApp_stat_ind());
			rescargo[i].setCnty_num(cargo.getCnty_num());
			rescargo[i].setFst_nam(cargo.getFst_nam());
			rescargo[i].setLast_nam(cargo.getLast_nam());
			rescargo[i].setMid_init(cargo.getMid_init());
			rescargo[i].setRfa_dt(cargo.getRfa_dt());
			rescargo[i].setRfa_file_dt(cargo.getRfa_file_dt());
			rescargo[i].setSfx_nam(cargo.getSfx_nam());
			rescargo[i].setUpdt_dt(cargo.getUpdt_dt());
			rescargo[i].setRowAction(cargo.getRowAction());
			rescargo[i].setUser(cargo.getUser());
			rescargo[i].setDirty(cargo.isDirty());
		}
		return rescargo;
	}

}
