/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This class acts as a wrapper for one or many cargos of BNFT_APPOINTMENTS
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date May 12 09:47:00 EDT 2009 Modified By: Modified on: PCR#
 */
public class BNFT_APPOINTMENTS_Collection extends AbstractCollection {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.BNFT_APPOINTMENTS";

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
	public void addCargo(final BNFT_APPOINTMENTS_Cargo aNewCargo) {
		add(aNewCargo);
	}

	/**
	 * Sets cargo array into collection.
	 */
	public void setResults(final BNFT_APPOINTMENTS_Cargo[] cbArray) {
		clear();
		for (int i = 0; i < cbArray.length; i++) {
			add(cbArray[i]);
		}
	}

	/**
	 * Sets cargo into collection at the given index.
	 */
	public void setCargo(final int idx, final BNFT_APPOINTMENTS_Cargo aCargo) {
		set(idx, aCargo);
	}

	/**
	 * Returns a particular cargo.
	 *
	 * Creation Date Tue Jul 26 14:13:48 CDT 2005
	 * @return
	 *         gov.state.nextgen.access.business.entities.CUST_INDV_ELG_Collection
	 */
	public BNFT_APPOINTMENTS_Cargo getResult(final int idx) {
		return (BNFT_APPOINTMENTS_Cargo) get(idx);
	}

	/**
	 * returns all the values in the Collection as Cargo Array.
	 */
	public BNFT_APPOINTMENTS_Cargo[] getResults() {
		final BNFT_APPOINTMENTS_Cargo[] cbArray = new BNFT_APPOINTMENTS_Cargo[size()];
		toArray(cbArray);
		return cbArray;
	}

	/**
	 * returns a cargo from the Collection for the given index.
	 */
	public BNFT_APPOINTMENTS_Cargo getCargo(final int idx) {
		return (BNFT_APPOINTMENTS_Cargo) get(idx);
	}

	/**
	 * This one for clone Results.
	 */
	public BNFT_APPOINTMENTS_Cargo[] cloneResults() {
		final BNFT_APPOINTMENTS_Cargo[] rescargo = new BNFT_APPOINTMENTS_Cargo[size()];
		for (int i = 0; i < size(); i++) {
			final BNFT_APPOINTMENTS_Cargo cargo = getCargo(i);
			rescargo[i] = new BNFT_APPOINTMENTS_Cargo();
			rescargo[i].setAppt_id(cargo.getAppt_id());
			rescargo[i].setBnft_case_num(cargo.getBnft_case_num());
			rescargo[i].setBnft_rfa_num(cargo.getBnft_rfa_num());
			rescargo[i].setAppt_beg_datetime(cargo.getAppt_beg_datetime());
			rescargo[i].setAppt_end_datetime(cargo.getAppt_end_datetime());
			rescargo[i].setAppt_mode_cd(cargo.getAppt_mode_cd());
			rescargo[i].setAppt_type_cd(cargo.getAppt_type_cd());

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
		if (obj instanceof BNFT_APPOINTMENTS_Cargo[]) {
			final BNFT_APPOINTMENTS_Cargo[] cbArray = (BNFT_APPOINTMENTS_Cargo[]) obj;
			setResults(cbArray);
		}
	}
}