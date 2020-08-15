/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * Copy the file to the path : commonApp/gov/state/nextgen/access/business/entities in the codebase.
 * This class acts as a wrapper for one or many cargos of CP_APP_IN_INCOME_TAX_DED
 * @author CodeGenerator - Architecture Team
 * Creation Date Mar 27 20:12:17 IST 2015
 * Modified By:
 * Modified on:
 * PCR#
 */
public class CP_APP_IN_INCOME_TAX_DED_Collection extends AbstractCollection {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.impl.CP_APP_IN_INCOME_TAX_DED";

	/**
	 *returns the PACKAGE name.
	 */
	@Override
	public String getPACKAGE() {
		return PACKAGE;
	}

	/**
	 *Adds the given cargo to the collection.
	 */
	public void addCargo(final CpAppInIncomeTaxDedCargo aNewCargo) {
		add(aNewCargo);
	}

	/**
	 *Sets cargo array into collection.
	 */
	public void setResults(final CpAppInIncomeTaxDedCargo[] cbArray) {
		clear();
		for (int i = 0; i < cbArray.length; i++) {
			add(cbArray[i]);
		}
	}

	/**
	 *Sets cargo into collection at the given index.
	 */
	public void setCargo(final int idx, final CpAppInIncomeTaxDedCargo aCargo) {
		set(idx, aCargo);
	}

	/**
	 *returns all the values in the Collection as Cargo Array.
	 */
	public CpAppInIncomeTaxDedCargo[] getResults() {
		final CpAppInIncomeTaxDedCargo[] cbArray = new CpAppInIncomeTaxDedCargo[size()];
		toArray(cbArray);
		return cbArray;
	}

	//NextGen  NG-6481 Phase 3 updates to ACA Streamline changes � start (H)

	public CpAppInIncomeTaxDedCargo getResult(final int idx) {
		return (CpAppInIncomeTaxDedCargo) get(idx);
	}

	//NextGen  NG-6481 Phase 3 updates to ACA Streamline changes � end (H)

	/**
	 *returns a cargo from the Collection for the given index.
	 */
	public CpAppInIncomeTaxDedCargo getCargo(final int idx) {
		return (CpAppInIncomeTaxDedCargo) get(idx);
	}

	/**
	 * This one for clone Results.
	 */
	public CpAppInIncomeTaxDedCargo[] cloneResults() {
		final CpAppInIncomeTaxDedCargo[] rescargo = new CpAppInIncomeTaxDedCargo[size()];
		for (int i = 0; i < size(); i++) {
			final CpAppInIncomeTaxDedCargo cargo = getCargo(i);
			rescargo[i] = new CpAppInIncomeTaxDedCargo();
			rescargo[i].setEcp_id(cargo.getEcp_id());
			rescargo[i].setEnd_date(cargo.getEnd_date());
			rescargo[i].setEducator_exp(cargo.getEducator_exp());
			rescargo[i].setBusiness_exp(cargo.getBusiness_exp());
			rescargo[i].setHealth_saving_exp(cargo.getHealth_saving_exp());
			rescargo[i].setMoving_exp(cargo.getMoving_exp());
			rescargo[i].setDeductible_self_exp(cargo.getDeductible_self_exp());
			rescargo[i].setSelf_sep_exp(cargo.getSelf_sep_exp());
			rescargo[i].setSelf_health_exp(cargo.getSelf_health_exp());
			rescargo[i].setPenalty_exp(cargo.getPenalty_exp());
			rescargo[i].setAlimony_exp(cargo.getAlimony_exp());
			rescargo[i].setIra_exp(cargo.getIra_exp());
			rescargo[i].setStudent_loan_exp(cargo.getStudent_loan_exp());
			rescargo[i].setTution_exp(cargo.getTution_exp());
			rescargo[i].setRowAction(cargo.getRowAction());
			rescargo[i].setUser(cargo.getUser());
			rescargo[i].setDirty(cargo.isDirty());
			rescargo[i].setChg_dt(cargo.getChg_dt());
			rescargo[i].setSeq_num(cargo.getSeq_num());
		}
		return rescargo;
	}

	/**
	 * Set the cargo array object to the collection.
	 */
	@Override
	public void setGenericResults(final Object obj) {
		if (obj instanceof CpAppInIncomeTaxDedCargo[]) {
			final CpAppInIncomeTaxDedCargo[] cbArray = (CpAppInIncomeTaxDedCargo[]) obj;
			setResults(cbArray);
		}
	}
}