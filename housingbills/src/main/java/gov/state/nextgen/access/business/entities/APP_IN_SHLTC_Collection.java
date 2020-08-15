/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This class acts as a wrapper for one or many cargos of APP_IN_SHLTC
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date Jun 10 14:50:42 EDT 2009 Modified By: Modified on: PCR#
 */
public class APP_IN_SHLTC_Collection extends AbstractCollection {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.impl.APP_IN_SHLTC";

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
	public void addCargo(final APP_IN_SHLTC_Cargo aNewCargo) {
		add(aNewCargo);
	}

	/**
	 * Sets cargo array into collection.
	 */
	public void setResults(final APP_IN_SHLTC_Cargo[] cbArray) {
		clear();	
		for (int i = 0; i < cbArray.length; i++) {
			add(cbArray[i]);
		}
	}

	/**
	 * Sets cargo into collection at the given index.
	 */
	public void setCargo(final int idx, final APP_IN_SHLTC_Cargo aCargo) {
		set(idx, aCargo);
	}

	/**
	 * returns all the values in the Collection as Cargo Array.
	 */
	public APP_IN_SHLTC_Cargo[] getResults() {
		final APP_IN_SHLTC_Cargo[] cbArray = new APP_IN_SHLTC_Cargo[size()];
		toArray(cbArray);
		return cbArray;
	}

	/**
	 * returns a cargo from the Collection for the given index.
	 */
	public APP_IN_SHLTC_Cargo getCargo(final int idx) {
		return (APP_IN_SHLTC_Cargo) get(idx);
	}

	/**
	 * This one for clone Results.
	 */
	public APP_IN_SHLTC_Cargo[] cloneResults() {
		final APP_IN_SHLTC_Cargo[] rescargo = new APP_IN_SHLTC_Cargo[size()];
		for (int i = 0; i < size(); i++) {
			final APP_IN_SHLTC_Cargo cargo = getCargo(i);
			rescargo[i] = new APP_IN_SHLTC_Cargo();
			rescargo[i].setApp_num(cargo.getApp_num());
			rescargo[i].setIndv_seq_num(cargo.getIndv_seq_num());
			rescargo[i].setSeq_num(cargo.getSeq_num());
			rescargo[i].setSrc_app_ind(cargo.getSrc_app_ind());
			rescargo[i].setChg_eff_dt(cargo.getChg_eff_dt());
			rescargo[i].setRec_cplt_ind(cargo.getRec_cplt_ind());
			rescargo[i].setShlt_oblg_amt(cargo.getShlt_oblg_amt());
			rescargo[i].setShlt_oblg_ind(cargo.getShlt_oblg_ind());
			rescargo[i].setShlt_typ(cargo.getShlt_typ());
			rescargo[i].setPay_freq(cargo.getPay_freq());
			rescargo[i].setOther_Housing_paymts(cargo.getOther_Housing_paymts());
			// EDSP Starts
			rescargo[i].setSomeone_else_rent_pay_ind(cargo.getSomeone_else_rent_pay_ind());
			rescargo[i].setNot_living_reason_cd(cargo.getNot_living_reason_cd());
			rescargo[i].setIntend_to_return_ind(cargo.getIntend_to_return_ind());
			rescargo[i].setSomeone_else_living_ind(cargo.getSomeone_else_living_ind());
			rescargo[i].setHousing_bill_ind(cargo.getHousing_bill_ind());
			// EDSP Ends
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
		if (obj instanceof APP_IN_SHLTC_Cargo[]) {
			final APP_IN_SHLTC_Cargo[] cbArray = (APP_IN_SHLTC_Cargo[]) obj;
			setResults(cbArray);
		}
	}
}