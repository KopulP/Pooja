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
public class INDV_ELG_Collection extends AbstractCollection {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.INDV_ELG";

	public INDV_ELG_Collection() {
	}

	public void addCargo(final INDV_ELG_Cargo newCargo) {
		add(newCargo);
	}

	/**
	 * Returns the package name.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @return gov.state.nextgen.access.business.entities.INDV_ELG_Collection
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
	public INDV_ELG_Cargo getCargo() {
		if (size() == 0) {
			add(new INDV_ELG_Cargo());
		}
		return (INDV_ELG_Cargo) get(0);
	}

	/**
	 * Sets cargo values.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @param newCargo
	 *            The newCargo to set
	 */

	public void setCargo(final INDV_ELG_Cargo newCargo) {
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
		setCargo((INDV_ELG_Cargo) cargo);
	}

	/**
	 * Sets cargo array into collection.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @param cbArray
	 *            The cbArray to set
	 */

	public void setResults(final INDV_ELG_Cargo[] cbArray) {
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

	public void setResults(final int idx, final INDV_ELG_Cargo cb) {
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
		if (obj instanceof INDV_ELG_Cargo[]) {
			final INDV_ELG_Cargo[] cbArray = (INDV_ELG_Cargo[]) obj;
			for (int i = 0; i < cbArray.length; i++) {
				add(cbArray[i]);
			}
		}
	}

	/**
	 * Returns cargo array.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @return gov.state.nextgen.access.business.entities.INDV_ELG_Collection[]
	 */
	public INDV_ELG_Cargo[] getResults() {
		final INDV_ELG_Cargo[] cbArray = new INDV_ELG_Cargo[size()];
		toArray(cbArray);
		return cbArray;
	}

	/**
	 * Returns a particular cargo.
	 *
	 * Creation Date Thu Jul 07 14:01:55 CDT 2005
	 * @return gov.state.nextgen.access.business.entities.INDV_ELG_Collection
	 */
	public INDV_ELG_Cargo getResult(final int idx) {
		return (INDV_ELG_Cargo) get(idx);
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
	public INDV_ELG_Cargo[] cloneResults() {
		final INDV_ELG_Cargo[] rescargo = new INDV_ELG_Cargo[size()];
		for (int i = 0; i < size(); i++) {
			final INDV_ELG_Cargo cargo = getResult(i);
			rescargo[i] = new INDV_ELG_Cargo();
			rescargo[i].setBnft_pin_num(cargo.getBnft_pin_num());
			rescargo[i].setBnft_case_num(cargo.getBnft_case_num());
			rescargo[i].setCat_cd(cargo.getCat_cd());
			rescargo[i].setScat_cd(cargo.getScat_cd());
			rescargo[i].setScat_seq_num(cargo.getScat_seq_num());
			rescargo[i].setCur_elg_ind(cargo.getCur_elg_ind());
			rescargo[i].setBnft_stat_cd(cargo.getBnft_stat_cd());
			rescargo[i].setCnfm_dt(cargo.getCnfm_dt());
			rescargo[i].setElg_beg_dt(cargo.getElg_beg_dt());
			rescargo[i].setElg_end_dt(cargo.getElg_end_dt());
			rescargo[i].setElg_ind(cargo.getElg_ind());
			rescargo[i].setMa_ddct_bal_amt(cargo.getMa_ddct_bal_amt());
			rescargo[i].setPymt_amt(cargo.getPymt_amt());
			rescargo[i].setPymt_beg_dt(cargo.getPymt_beg_dt());
			rescargo[i].setPymt_end_dt(cargo.getPymt_end_dt());
			rescargo[i].setPymt_typ(cargo.getPymt_typ());
			rescargo[i].setSc_bnft_lvl_cd(cargo.getSc_bnft_lvl_cd());
			rescargo[i].setUpdt_dt(cargo.getUpdt_dt());
			rescargo[i].setVfcn_due_dt(cargo.getVfcn_due_dt());
			rescargo[i].setMsg_cd_txt(cargo.getMsg_cd_txt());
			rescargo[i].setAg_stat_rsn_1_cd(cargo.getAg_stat_rsn_1_cd());
			rescargo[i].setAg_stat_rsn_2_cd(cargo.getAg_stat_rsn_2_cd());
			rescargo[i].setAg_stat_rsn_3_cd(cargo.getAg_stat_rsn_3_cd());
			rescargo[i].setNf_elg_rslt_cd(cargo.getNf_elg_rslt_cd());
			rescargo[i].setNf_fail_rsn_1_cd(cargo.getNf_fail_rsn_1_cd());
			rescargo[i].setNf_fail_rsn_2_cd(cargo.getNf_fail_rsn_2_cd());
			rescargo[i].setNf_fail_rsn_3_cd(cargo.getNf_fail_rsn_3_cd());
			rescargo[i].setOrg_elg_ind(cargo.getOrg_elg_ind());
			rescargo[i].setPrev_pymt_amt(cargo.getPrev_pymt_amt());
			rescargo[i].setEmpl_vfcn_due_dt(cargo.getEmpl_vfcn_due_dt());
			rescargo[i].setIns_vfcn_due_dt(cargo.getIns_vfcn_due_dt());
			rescargo[i].setSmirf_mo(cargo.getSmirf_mo());
			rescargo[i].setPrev_sc_bnft_lvl_cd(cargo.getPrev_sc_bnft_lvl_cd());
			rescargo[i].setPgm_rqst_sw(cargo.getPgm_rqst_sw());
			rescargo[i].setFs_grp_typ(cargo.getFs_grp_typ());
			rescargo[i].setFs_fpl_130pct_amt(cargo.getFs_fpl_130pct_amt());
			rescargo[i].setReview_dt(cargo.getReview_dt());
			rescargo[i].setMid_cert_review_date(cargo.getMid_cert_review_date());
			rescargo[i].setSemi_annual_review_date(cargo.getSemi_annual_review_date());
			rescargo[i].setEstm_elg_end_dt(cargo.getEstm_elg_end_dt());
			rescargo[i].setRowAction(cargo.getRowAction());
			rescargo[i].setUser(cargo.getUser());
			rescargo[i].setDirty(cargo.isDirty());
		}
		return rescargo;
	}

}
