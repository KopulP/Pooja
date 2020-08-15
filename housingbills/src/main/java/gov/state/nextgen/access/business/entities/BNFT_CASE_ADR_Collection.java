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
public class BNFT_CASE_ADR_Collection extends AbstractCollection {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.BNFT_CASE_ADR";

	public BNFT_CASE_ADR_Collection() {
	}

	public void addCargo(final BNFT_CASE_ADR_Cargo newCargo) {
		add(newCargo);
	}

	/**
	 * Returns the package name.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @return
	 *         gov.state.nextgen.access.business.entities.BNFT_CASE_ADR_Collection
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
	public BNFT_CASE_ADR_Cargo getCargo() {
		if (size() == 0) {
			add(new BNFT_CASE_ADR_Cargo());
		}
		return (BNFT_CASE_ADR_Cargo) get(0);
	}

	/**
	 * Sets cargo values.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @param newCargo
	 *            The newCargo to set
	 */

	public void setCargo(final BNFT_CASE_ADR_Cargo newCargo) {
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
		setCargo((BNFT_CASE_ADR_Cargo) cargo);
	}

	/**
	 * Sets cargo array into collection.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @param cbArray
	 *            The cbArray to set
	 */

	public void setResults(final BNFT_CASE_ADR_Cargo[] cbArray) {
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

	public void setResults(final int idx, final BNFT_CASE_ADR_Cargo cb) {
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
		if (obj instanceof BNFT_CASE_ADR_Cargo[]) {
			final BNFT_CASE_ADR_Cargo[] cbArray = (BNFT_CASE_ADR_Cargo[]) obj;
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
	 *         gov.state.nextgen.access.business.entities.BNFT_CASE_ADR_Collection
	 *         []
	 */
	public BNFT_CASE_ADR_Cargo[] getResults() {
		final BNFT_CASE_ADR_Cargo[] cbArray = new BNFT_CASE_ADR_Cargo[size()];
		toArray(cbArray);
		return cbArray;
	}

	/**
	 * Returns a particular cargo.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @return
	 *         gov.state.nextgen.access.business.entities.BNFT_CASE_ADR_Collection
	 */
	public BNFT_CASE_ADR_Cargo getResult(final int idx) {
		return (BNFT_CASE_ADR_Cargo) get(idx);
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
	public BNFT_CASE_ADR_Cargo[] cloneResults() {
		final BNFT_CASE_ADR_Cargo[] rescargo = new BNFT_CASE_ADR_Cargo[size()];
		for (int i = 0; i < size(); i++) {
			final BNFT_CASE_ADR_Cargo cargo = getResult(i);
			rescargo[i] = new BNFT_CASE_ADR_Cargo();
			rescargo[i].setBnft_case_num(cargo.getBnft_case_num());
			rescargo[i].setAdr_typ(cargo.getAdr_typ());
			rescargo[i].setApt_adr(cargo.getApt_adr());
			rescargo[i].setCity_adr(cargo.getCity_adr());
			rescargo[i].setCntc_fst_nam(cargo.getCntc_fst_nam());
			rescargo[i].setCntc_last_nam(cargo.getCntc_last_nam());
			rescargo[i].setCntc_mid_init(cargo.getCntc_mid_init());
			rescargo[i].setDir_adr(cargo.getDir_adr());
			rescargo[i].setL2_adr(cargo.getL2_adr());
			rescargo[i].setCntc_phn_num(cargo.getCntc_phn_num());
			rescargo[i].setCntc_fax_num(cargo.getCntc_fax_num());
			rescargo[i].setQdrt_adr(cargo.getQdrt_adr());
			rescargo[i].setSt_num_adr(cargo.getSt_num_adr());
			rescargo[i].setSt_rurl_adr(cargo.getSt_rurl_adr());
			rescargo[i].setSt_adr(cargo.getSt_adr());
			rescargo[i].setSfx_adr(cargo.getSfx_adr());
			rescargo[i].setUnit_adr(cargo.getUnit_adr());
			rescargo[i].setUpdt_dt(cargo.getUpdt_dt());
			rescargo[i].setZip_adr(cargo.getZip_adr());
			rescargo[i].setCnty_num(cargo.getCnty_num());
			rescargo[i].setEmail(cargo.getEmail());
			rescargo[i].setAddr_dwelling_type_cd(cargo.getAddr_dwelling_type_cd());
			rescargo[i].setAddr_st_num_frac(cargo.getAddr_st_num_frac());
			rescargo[i].setAddr_care_of_line(cargo.getAddr_care_of_line());
			rescargo[i].setOffice_num(cargo.getOffice_num());
			rescargo[i].setOffice_name(cargo.getOffice_name());
			rescargo[i].setEmp_id(cargo.getEmp_id());
			rescargo[i].setOrg_name(cargo.getOrg_name());
			rescargo[i].setRowAction(cargo.getRowAction());
			rescargo[i].setUser(cargo.getUser());
			rescargo[i].setDirty(cargo.isDirty());
		}
		return rescargo;
	}

}
