/*
 * 
 */
package gov.state.nextgen.access.driver.business.entities;

import gov.state.nextgen.access.business.entities.AbstractCollection;

/**
 * This class acts as a wrapper for one or many cargos of PE_CHLD_DRVR
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date Thu Jul 26 15:18:54 CDT 2007 Modified By: Modified on: PCR#
 */
public class PE_CHLD_DRVR_Collection extends AbstractCollection {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.framework.driver.business.entities.impl.PE_CHLD_DRVR";

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
	public void addCargo(final PE_CHLD_DRVR_Cargo aNewCargo) {
		add(aNewCargo);
	}

	/**
	 * Sets cargo array into collection.
	 */
	public void setResults(final PE_CHLD_DRVR_Cargo[] cbArray) {
		clear();
		for (int i = 0; i < cbArray.length; i++) {
			add(cbArray[i]);
		}
	}

	/**
	 * Sets cargo into collection at the given index.
	 */
	public void setCargo(final int idx, final PE_CHLD_DRVR_Cargo aCargo) {
		set(idx, aCargo);
	}

	/**
	 * returns all the values in the Collection as Cargo Array.
	 */
	public PE_CHLD_DRVR_Cargo[] getResults() {
		final PE_CHLD_DRVR_Cargo[] cbArray = new PE_CHLD_DRVR_Cargo[size()];
		toArray(cbArray);
		return cbArray;
	}

	/**
	 * returns a cargo from the Collection for the given index.
	 */
	public PE_CHLD_DRVR_Cargo getCargo(final int idx) {
		return (PE_CHLD_DRVR_Cargo) get(idx);
	}

	/**
	 * This one for clone Results.
	 */
	public PE_CHLD_DRVR_Cargo[] cloneResults() {
		final PE_CHLD_DRVR_Cargo[] rescargo = new PE_CHLD_DRVR_Cargo[size()];
		for (int i = 0; i < size(); i++) {
			final PE_CHLD_DRVR_Cargo cargo = getCargo(i);
			rescargo[i] = new PE_CHLD_DRVR_Cargo();
			rescargo[i].setApp_num(cargo.getApp_num());
			rescargo[i].setApcci_stat_ind(cargo.getApcci_stat_ind());
			rescargo[i].setApccs_stat_ind(cargo.getApccs_stat_ind());
			rescargo[i].setApchr_stat_ind(cargo.getApchr_stat_ind());
			rescargo[i].setApcid_stat_ind(cargo.getApcid_stat_ind());
			rescargo[i].setApcii_stat_ind(cargo.getApcii_stat_ind());
			rescargo[i].setApcps_stat_ind(cargo.getApcps_stat_ind());
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
		if (obj instanceof PE_CHLD_DRVR_Cargo[]) {
			final PE_CHLD_DRVR_Cargo[] cbArray = (PE_CHLD_DRVR_Cargo[]) obj;
			setResults(cbArray);
		}
	}
}