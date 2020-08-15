/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This class acts as a wrapper for one or many cargos
 *
 * @author Architecture Team
 * Creation Date Tue Jul 26 14:13:48 CDT 2005 Modified By: Modified on: PCR#
 */
public class CUST_INDV_ELG_Collection extends AbstractCollection {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.CUST_INDV_ELG";

	public CUST_INDV_ELG_Collection() {
	}

	public void addCargo(final CUST_INDV_ELG_Cargo newCargo) {
		add(newCargo);
	}

	/**
	 * Returns the package name.
	 *
	 * Creation Date Tue Jul 26 14:13:48 CDT 2005
	 * @return
	 *         gov.state.nextgen.access.business.entities.CUST_INDV_ELG_Collection
	 */
	@Override
	public String getPACKAGE() {
		return PACKAGE;
	}

	/**
	 * Returns cargo.
	 *
	 * Creation Date Tue Jul 26 14:13:48 CDT 2005
	 * @return java.lang.String
	 */
	public CUST_INDV_ELG_Cargo getCargo() {
		if (size() == 0) {
			add(new CUST_INDV_ELG_Cargo());
		}
		return (CUST_INDV_ELG_Cargo) get(0);
	}

	/**
	 * Sets cargo values.
	 *
	 * Creation Date Tue Jul 26 14:13:48 CDT 2005
	 * @param newCargo
	 *            The newCargo to set
	 */

	public void setCargo(final CUST_INDV_ELG_Cargo newCargo) {
		if (size() == 0) {
			add(newCargo);
		} else {
			set(0, newCargo);
		}
	}

	/**
	 * Returns an abstract cargo.
	 *
	 * Creation Date Tue Jul 26 14:13:48 CDT 2005
	 * @return gov.state.nextgen.access.business.entities.AbstractCargo
	 */
	public AbstractCargo getAbstractCargo() {
		return getCargo();
	}

	/**
	 * Sets abstract cargo.
	 *
	 * Creation Date Tue Jul 26 14:13:48 CDT 2005
	 * @param cargo
	 *            The Cargo to set
	 */

	public void setAbstractCargo(final AbstractCargo cargo) {
		setCargo((CUST_INDV_ELG_Cargo) cargo);
	}

	/**
	 * Sets cargo array into collection.
	 *
	 * Creation Date Tue Jul 26 14:13:48 CDT 2005
	 * @param cbArray
	 *            The cbArray to set
	 */

	public void setResults(final CUST_INDV_ELG_Cargo[] cbArray) {
		clear();
		for (int i = 0; i < cbArray.length; i++) {
			add(cbArray[i]);
		}
	}

	/**
	 * Sets a cargo into particular index of the collection
	 *
	 * Creation Date Tue Jul 26 14:13:48 CDT 2005
	 * @param cb
	 *            The cbarray to set
	 * @param idx
	 *            The idx to set
	 */

	public void setResults(final int idx, final CUST_INDV_ELG_Cargo cb) {
		set(idx, cb);
	}

	/**
	 * Sets a cargo into particular index of the collection
	 *
	 * Creation Date Tue Jul 26 14:13:48 CDT 2005
	 * @param obj
	 *            The cbarray to set
	 */

	@Override
	public void setGenericResults(final Object obj) {
		if (obj instanceof CUST_INDV_ELG_Cargo[]) {
			final CUST_INDV_ELG_Cargo[] cbArray = (CUST_INDV_ELG_Cargo[]) obj;
			for (int i = 0; i < cbArray.length; i++) {
				add(cbArray[i]);
			}
		}
	}

	/**
	 * Returns cargo array.
	 *
	 * Creation Date Tue Jul 26 14:13:48 CDT 2005
	 * @return
	 *         gov.state.nextgen.access.business.entities.CUST_INDV_ELG_Collection
	 *         []
	 */
	public CUST_INDV_ELG_Cargo[] getResults() {
		final CUST_INDV_ELG_Cargo[] cbArray = new CUST_INDV_ELG_Cargo[size()];
		toArray(cbArray);
		return cbArray;
	}

	/**
	 * Returns a particular cargo.
	 *
	 * Creation Date Tue Jul 26 14:13:48 CDT 2005
	 * @return
	 *         gov.state.nextgen.access.business.entities.CUST_INDV_ELG_Collection
	 */
	public CUST_INDV_ELG_Cargo getResult(final int idx) {
		return (CUST_INDV_ELG_Cargo) get(idx);
	}

	/**
	 * Returns size of a collection.
	 *
	 * Creation Date Tue Jul 26 14:13:48 CDT 2005
	 * @return int
	 */
	public int getResultsSize() {
		return size();
	}

	/** This one for clone Results */
	public CUST_INDV_ELG_Cargo[] cloneResults() {
		final CUST_INDV_ELG_Cargo[] rescargo = new CUST_INDV_ELG_Cargo[size()];
		for (int i = 0; i < size(); i++) {
			final CUST_INDV_ELG_Cargo cargo = getResult(i);
			rescargo[i] = new CUST_INDV_ELG_Cargo();
			rescargo[i].setMci_id(cargo.getMci_id());
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
			rescargo[i].setFst_nam(cargo.getFst_nam());
			rescargo[i].setFs_fpl_130pct_amt(cargo.getFs_fpl_130pct_amt());
			rescargo[i].setFs_grp_typ(cargo.getFs_grp_typ());
			rescargo[i].setPgm_rqst_sw(cargo.getPgm_rqst_sw());
			rescargo[i].setSex_ind(cargo.getSex_ind());
			rescargo[i].setBrth_dt(cargo.getBrth_dt());
			rescargo[i].setPrev_sc_bnft_l_cd(cargo.getPrev_sc_bnft_l_cd());
			rescargo[i].setRowAction(cargo.getRowAction());
			rescargo[i].setUser(cargo.getUser());
			rescargo[i].setEmpl_vfcn_due_dt(cargo.getEmpl_vfcn_due_dt());
			rescargo[i].setIns_vfcn_due_dt(cargo.getIns_vfcn_due_dt());
			rescargo[i].setSmirf_mo(cargo.getSmirf_mo());
			rescargo[i].setDirty(cargo.isDirty());
			rescargo[i].setMid_cert_review_date(cargo.getMid_cert_review_date());
			rescargo[i].setSemi_annual_review_date(cargo.getSemi_annual_review_date());
			rescargo[i].setReview_dt(cargo.getReview_dt());
			rescargo[i].setMid_name(cargo.getMid_name());
			rescargo[i].setLast_name(cargo.getLast_name());
			rescargo[i].setEstm_elg_end_dt(cargo.getEstm_elg_end_dt());

		}
		return rescargo;
	}

}
