/*
 * 
 */
package gov.state.nextgen.access.business.entities;

import gov.state.nextgen.access.business.services.INDIVIDUAL_Custom_Cargo;

/**
 * This class acts as a wrapper for one or many cargos
 *
 * @author Architecture Team
 * Creation Date WED Nov 30 Modified By: Modified on: PCR#
 */
public class INDIVIDUAL_Custom_Collection extends AbstractCollection {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.APP_INDV";

	public INDIVIDUAL_Custom_Collection() {
	}

	public void addCargo(final INDIVIDUAL_Custom_Cargo indivCustomCargo) {
		add(indivCustomCargo);
	}

	/**
	 * Returns the package name.
	 *
	 * @return gov.state.nextgen.access.business.customEntities.
	 *         INDIVIDUAL_Custom_Collection
	 */
	@Override
	public String getPACKAGE() {
		return PACKAGE;
	}

	/**
	 * Returns cargo.
	 *
	 * @return java.lang.String
	 */
	public IndividualCustomCargo getCargo() {
		if (size() == 0) {
			add(new IndividualCustomCargo());
		}
		return (IndividualCustomCargo) get(0);
	}

	/**
	 * Sets cargo values.
	 *
	 * @param newCargo
	 *            The newCargo to set
	 */

	public void setCargo(final IndividualCustomCargo newCargo) {
		if (size() == 0) {
			add(newCargo);
		} else {
			set(0, newCargo);
		}
	}

	/**
	 * Returns an abstract cargo.
	 *
	 * @return gov.state.nextgen.access.business.entities.AbstractCargo
	 */
	public AbstractCargo getAbstractCargo() {
		return getCargo();
	}

	/**
	 * Sets abstract cargo.
	 *
	 * @param cargo
	 *            The Cargo to set
	 */

	public void setAbstractCargo(final AbstractCargo cargo) {
		setCargo((IndividualCustomCargo) cargo);
	}

	/**
	 * Sets cargo array into collection.
	 *
	 * @param individualCustomCargoArray
	 *            The cbArray to set
	 */

	public void setResults(final INDIVIDUAL_Custom_Cargo[] individualCustomCargoArray) {
		clear();
		for (int i = 0; i < individualCustomCargoArray.length; i++) {
			add(individualCustomCargoArray[i]);
		}
	}

	/**
	 * Sets a cargo into particular index of the collection
	 *
	 * @param cb
	 *            The cbarray to set
	 * @param idx
	 *            The idx to set
	 */

	public void setResults(final int idx, final IndividualCustomCargo cb) {
		set(idx, cb);
	}

	/**
	 * Sets a cargo into particular index of the collection
	 *
	 * @param obj
	 *            The cbarray to set
	 */

	@Override
	public void setGenericResults(final Object obj) {
		if (obj instanceof IndividualCustomCargo[]) {
			final IndividualCustomCargo[] cbArray = (IndividualCustomCargo[]) obj;
			for (int i = 0; i < cbArray.length; i++) {
				add(cbArray[i]);
			}
		}
	}

	/**
	 * Returns cargo array.
	 *
	 * @return gov.state.nextgen.access.business.entities.APP_INDV_Collection[]
	 */
	public IndividualCustomCargo[] getResults() {
		final IndividualCustomCargo[] cbArray = new IndividualCustomCargo[size()];
		toArray(cbArray);
		return cbArray;
	}

	/**
	 * Returns a particular cargo.
	 *
	 * @return gov.state.nextgen.access.business.entities.APP_INDV_Collection
	 */
	public IndividualCustomCargo getResult(final int idx) {
		return (IndividualCustomCargo) get(idx);
	}

	/**
	 * Returns size of a collection.
	 *
	 * @return int
	 */
	public int getResultsSize() {
		return size();
	}

	/** This one for clone Results */
	public IndividualCustomCargo[] cloneResults() {
		final IndividualCustomCargo[] rescargo = new IndividualCustomCargo[size()];
		for (int i = 0; i < size(); i++) {
			final IndividualCustomCargo cargo = getResult(i);
			rescargo[i] = new IndividualCustomCargo();
			rescargo[i].setMci_id(cargo.getMci_id());
			rescargo[i].setIndv_seq_num(cargo.getIndv_seq_num());
			rescargo[i].setIndv_pin_num(cargo.getIndv_pin_num());
			rescargo[i].setBrth_dt(cargo.getBrth_dt());
			rescargo[i].setFst_nam(cargo.getFst_nam());
			rescargo[i].setLast_nam(cargo.getLast_nam());
			rescargo[i].setMid_init(cargo.getMid_init());
			rescargo[i].setRlvn_ind(cargo.getRlvn_ind());
			rescargo[i].setSex_ind(cargo.getSex_ind());
			rescargo[i].setIndv_age(cargo.getIndv_age());
			rescargo[i].setRlt_cd(cargo.getRlt_cd());
			rescargo[i].setSsn_num(cargo.getSsn_num());
			rescargo[i].setRec_cplt_ind(cargo.getRec_cplt_ind());
			rescargo[i].setDabl_resp(cargo.getDabl_resp());
		}
		return rescargo;
	}

}
