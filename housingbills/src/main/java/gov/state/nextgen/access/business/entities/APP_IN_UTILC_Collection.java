/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This class acts as a wrapper for one or many cargos of APP_IN_UTILC
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date May 29 16:11:28 EDT 2009 Modified By: Modified on: PCR#
 */
public class APP_IN_UTILC_Collection extends AbstractCollection {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.impl.APP_IN_UTILC";

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
	public void addCargo(final AppInUtilcCargo aNewCargo) {
		add(aNewCargo);
	}

	/**
	 * Sets cargo array into collection.
	 */
	public void setResults(final AppInUtilcCargo[] cbArray) {
		clear();
		for (int i = 0; i < cbArray.length; i++) {
			add(cbArray[i]);
		}
	}

	/**
	 * Sets cargo into collection at the given index.
	 */
	public void setCargo(final int idx, final AppInUtilcCargo aCargo) {
		set(idx, aCargo);
	}

	/**
	 * returns all the values in the Collection as Cargo Array.
	 */
	public AppInUtilcCargo[] getResults() {
		final AppInUtilcCargo[] cbArray = new AppInUtilcCargo[size()];
		toArray(cbArray);
		return cbArray;
	}

	/**
	 * returns a cargo from the Collection for the given index.
	 */
	public AppInUtilcCargo getCargo(final int idx) {
		return (AppInUtilcCargo) get(idx);
	}

	/**
	 * This one for clone Results.
	 */
	public AppInUtilcCargo[] cloneResults() {
		final AppInUtilcCargo[] rescargo = new AppInUtilcCargo[size()];
		for (int i = 0; i < size(); i++) {
			final AppInUtilcCargo cargo = getCargo(i);
			rescargo[i] = new AppInUtilcCargo();
			rescargo[i].setBill_exp_resp(cargo.getBill_exp_resp());
			rescargo[i].setChg_eff_dt(cargo.getChg_eff_dt());
			rescargo[i].setHeat_sw(cargo.getHeat_sw());
			rescargo[i].setMo_oblg_amt(cargo.getMo_oblg_amt());
			rescargo[i].setMo_oblg_ind(cargo.getMo_oblg_ind());
			rescargo[i].setRec_cplt_ind(cargo.getRec_cplt_ind());
			rescargo[i].setUtil_typ(cargo.getUtil_typ());
			rescargo[i].setPay_freq(cargo.getPay_freq());
			//SY ADDED
			rescargo[i].setUtil_electric_resp(cargo.getUtil_electric_resp());
			rescargo[i].setUtil_sewage_resp(cargo.getUtil_sewage_resp());
			rescargo[i].setUtil_garbage_resp(cargo.getUtil_garbage_resp());
			rescargo[i].setUtil_phone_resp(cargo.getUtil_phone_resp());
			rescargo[i].setUtil_gas_resp(cargo.getUtil_gas_resp());
			rescargo[i].setUtil_water_resp(cargo.getUtil_water_resp());
			rescargo[i].setUtil_fuel_resp(cargo.getUtil_fuel_resp());
			rescargo[i].setMo_hsld_pay_amt(cargo.getMo_hsld_pay_amt());
			rescargo[i].setUtil_total_amt(cargo.getUtil_total_amt());
			rescargo[i].setEcp_id(cargo.getEcp_id());
			rescargo[i].setHeat_cool_src(cargo.getHeat_cool_src());

			rescargo[i].setRowAction(cargo.getRowAction());
			rescargo[i].setUser(cargo.getUser());
			rescargo[i].setChg_dt(cargo.getChg_dt());
			rescargo[i].setDirty(cargo.isDirty());
		}
		return rescargo;
	}

	/**
	 * Set the cargo array object to the collection.
	 */
	@Override
	public void setGenericResults(final Object obj) {
		if (obj instanceof AppInUtilcCargo[]) {
			final AppInUtilcCargo[] cbArray = (AppInUtilcCargo[]) obj;
			setResults(cbArray);
		}
	}
}