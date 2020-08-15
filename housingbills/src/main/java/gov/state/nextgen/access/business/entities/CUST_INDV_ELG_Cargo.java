/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This java bean contains the entities for the given table
 *
 * @author Architecture Team
 * Creation Date Tue Jul 26 14:13:47 CDT 2005 Modified By: Modified on: PCR#
 */
public class CUST_INDV_ELG_Cargo extends AbstractCargo implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.CUST_INDV_ELG";

	boolean isDirty = false;
	private String mci_id;
	private java.lang.String bnft_pin_num;
	private java.lang.String bnft_case_num;
	private java.lang.String cat_cd;
	private java.lang.String scat_cd;
	private java.lang.String scat_seq_num;
	private java.lang.String cur_elg_ind;
	private java.lang.String bnft_stat_cd;
	private java.lang.String cnfm_dt;
	private java.lang.String elg_beg_dt;
	private java.lang.String elg_end_dt;
	private java.lang.String elg_ind;
	private java.lang.String ma_ddct_bal_amt;
	private java.lang.String pymt_amt;
	private java.lang.String pymt_beg_dt;
	private java.lang.String pymt_end_dt;
	private java.lang.String pymt_typ;
	private java.lang.String sc_bnft_lvl_cd;
	private java.lang.String updt_dt;
	private java.lang.String vfcn_due_dt;
	private java.lang.String msg_cd_txt;
	private java.lang.String ag_stat_rsn_1_cd;
	private java.lang.String ag_stat_rsn_2_cd;
	private java.lang.String ag_stat_rsn_3_cd;
	private java.lang.String nf_elg_rslt_cd;
	private java.lang.String nf_fail_rsn_1_cd;
	private java.lang.String nf_fail_rsn_2_cd;
	private java.lang.String nf_fail_rsn_3_cd;
	private java.lang.String org_elg_ind;
	private java.lang.String prev_pymt_amt;
	private java.lang.String fst_nam;
	private java.lang.String fs_fpl_130pct_amt;
	private java.lang.String fs_grp_typ;
	private java.lang.String pgm_rqst_sw;
	private java.lang.String sex_ind;
	private java.lang.String brth_dt;
	private java.lang.String prev_sc_bnft_l_cd;
	private java.lang.String empl_vfcn_due_dt;
	private java.lang.String ins_vfcn_due_dt;
	private java.lang.String smirf_mo;
	private boolean fapAmountExists = false;
	// added by sudharsan for changes in review dates
	private java.lang.String mid_cert_review_date;
	private java.lang.String semi_annual_review_date;
	private java.lang.String review_dt;
	private java.lang.String app_num;
	private java.lang.String mid_name;
	private java.lang.String last_name;
	private java.lang.String estm_elg_end_dt;
	private java.lang.String ser_auth_dt;
	private java.lang.String requested_date;
	private java.lang.String client_amt;
	private java.lang.String provider_id;
	private java.lang.String manual_issuance_amt;
	private java.lang.String smirf_actn_cd;

	public java.lang.String getSmirf_actn_cd() {
		return smirf_actn_cd;
	}

	public void setSmirf_actn_cd(final java.lang.String smirf_actn_cd) {
		this.smirf_actn_cd = smirf_actn_cd;
	}

	public java.lang.String getManual_issuance_amt() {
		return manual_issuance_amt;
	}

	public void setManual_issuance_amt(final java.lang.String manual_issuance_amt) {
		this.manual_issuance_amt = manual_issuance_amt;
	}

	public java.lang.String getMid_cert_review_date() {
		return mid_cert_review_date;
	}

	public void setMid_cert_review_date(final java.lang.String mid_cert_review_date) {
		this.mid_cert_review_date = mid_cert_review_date;
	}

	public java.lang.String getReview_dt() {
		return review_dt;
	}

	public void setReview_dt(final java.lang.String review_dt) {
		this.review_dt = review_dt;
	}

	public java.lang.String getSemi_annual_review_date() {
		return semi_annual_review_date;
	}

	public void setSemi_annual_review_date(final java.lang.String semi_annual_review_date) {
		this.semi_annual_review_date = semi_annual_review_date;
	}

	public boolean getFapAmountExists() {
		return fapAmountExists;
	}

	public void setFapAmountExists(final boolean fapAmountExists) {
		this.fapAmountExists = fapAmountExists;
	}

	/**
	 * returns the mci_id value.
	 */
	public String getMci_id() {
		return mci_id;
	}

	/**
	 * sets the mci_id value.
	 */
	public void setMci_id(final String mci_id) {
		this.mci_id = mci_id;
	}

	/**
	 * Returns the package name.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return gov.state.nextgen.access.business.entities.CUST_INDV_ELG_Cargo
	 */
	public String getPackage() {
		return PACKAGE;
	}

	/**
	 * Returns the primary key values of a cargo
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	@Override
	public IPrimaryKey getPrimaryKey() {
		final CUST_INDV_ELG_PrimaryKey key = new CUST_INDV_ELG_PrimaryKey();
		key.setBnft_pin_num(getBnft_pin_num());
		return key;
	}

	/**
	 * Inspects Cargo values for debug.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */
	@Override
	public String inspectCargo() {
		return "CUST_INDV_ELG: " + "mci_id" + mci_id + ",bnft_pin_num=" + bnft_pin_num + "," + "bnft_case_num=" + bnft_case_num + "," + "cat_cd="
				+ cat_cd + "," + "scat_cd=" + scat_cd + "," + "scat_seq_num=" + scat_seq_num + "," + "cur_elg_ind=" + cur_elg_ind + ","
				+ "bnft_stat_cd=" + bnft_stat_cd + "," + "cnfm_dt=" + cnfm_dt + "," + "elg_beg_dt=" + elg_beg_dt + "," + "elg_end_dt=" + elg_end_dt
				+ "," + "elg_ind=" + elg_ind + "," + "ma_ddct_bal_amt=" + ma_ddct_bal_amt + "," + "pymt_amt=" + pymt_amt + "," + "pymt_beg_dt="
				+ pymt_beg_dt + "," + "pymt_end_dt=" + pymt_end_dt + "," + "pymt_typ=" + pymt_typ + "," + "sc_bnft_lvl_cd=" + sc_bnft_lvl_cd + ","
				+ "updt_dt=" + updt_dt + "," + "vfcn_due_dt=" + vfcn_due_dt + "," + "msg_cd_txt=" + msg_cd_txt + "," + "ag_stat_rsn_1_cd="
				+ ag_stat_rsn_1_cd + "," + "ag_stat_rsn_2_cd=" + ag_stat_rsn_2_cd + "," + "ag_stat_rsn_3_cd=" + ag_stat_rsn_3_cd + ","
				+ "nf_elg_rslt_cd=" + nf_elg_rslt_cd + "," + "nf_fail_rsn_1_cd=" + nf_fail_rsn_1_cd + "," + "nf_fail_rsn_2_cd=" + nf_fail_rsn_2_cd
				+ "," + "nf_fail_rsn_3_cd=" + nf_fail_rsn_3_cd + "," + "org_elg_ind=" + org_elg_ind + "," + "prev_pymt_amt=" + prev_pymt_amt + ","
				+ "fst_nam=" + fst_nam + "," + "fs_fpl_130pct_amt=" + fs_fpl_130pct_amt + "," + "fs_grp_typ=" + fs_grp_typ + "," + "pgm_rqst_sw="
				+ pgm_rqst_sw + "," + "sex_ind=" + sex_ind + "," + "brth_dt=" + brth_dt + "," + "prev_sc_bnft_l_cd=" + prev_sc_bnft_l_cd + ","
				+ "empl_vfcn_due_dt=" + empl_vfcn_due_dt + "," + "ins_vfcn_due_dt=" + ins_vfcn_due_dt + "," + "smirf_mo=" + smirf_mo + ","
				+ "app_num=" + app_num + "," + "mid_name=" + mid_name + "," + "last_name=" + last_name + ",ser_auth_dt=" + ser_auth_dt
				+ ",requested_date=" + requested_date + ",client_amt=" + client_amt + ",provider_id=" + provider_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((ag_stat_rsn_1_cd == null) ? 0 : ag_stat_rsn_1_cd.trim().hashCode());
		result = (prime * result) + ((ag_stat_rsn_2_cd == null) ? 0 : ag_stat_rsn_2_cd.trim().hashCode());
		result = (prime * result) + ((ag_stat_rsn_3_cd == null) ? 0 : ag_stat_rsn_3_cd.trim().hashCode());
		result = (prime * result) + ((app_num == null) ? 0 : app_num.trim().hashCode());
		result = (prime * result) + ((bnft_case_num == null) ? 0 : bnft_case_num.trim().hashCode());
		result = (prime * result) + ((bnft_pin_num == null) ? 0 : bnft_pin_num.trim().hashCode());
		result = (prime * result) + ((bnft_stat_cd == null) ? 0 : bnft_stat_cd.trim().hashCode());
		result = (prime * result) + ((brth_dt == null) ? 0 : brth_dt.trim().hashCode());
		result = (prime * result) + ((cat_cd == null) ? 0 : cat_cd.trim().hashCode());
		result = (prime * result) + ((client_amt == null) ? 0 : client_amt.trim().hashCode());
		result = (prime * result) + ((cnfm_dt == null) ? 0 : cnfm_dt.trim().hashCode());
		result = (prime * result) + ((cur_elg_ind == null) ? 0 : cur_elg_ind.trim().hashCode());
		result = (prime * result) + ((elg_beg_dt == null) ? 0 : elg_beg_dt.trim().hashCode());
		result = (prime * result) + ((elg_end_dt == null) ? 0 : elg_end_dt.trim().hashCode());
		result = (prime * result) + ((elg_ind == null) ? 0 : elg_ind.trim().hashCode());
		result = (prime * result) + ((empl_vfcn_due_dt == null) ? 0 : empl_vfcn_due_dt.trim().hashCode());
		result = (prime * result) + ((estm_elg_end_dt == null) ? 0 : estm_elg_end_dt.trim().hashCode());
		result = (prime * result) + (fapAmountExists ? 1231 : 1237);
		result = (prime * result) + ((fs_fpl_130pct_amt == null) ? 0 : fs_fpl_130pct_amt.trim().hashCode());
		result = (prime * result) + ((fs_grp_typ == null) ? 0 : fs_grp_typ.trim().hashCode());
		result = (prime * result) + ((fst_nam == null) ? 0 : fst_nam.trim().hashCode());
		result = (prime * result) + ((ins_vfcn_due_dt == null) ? 0 : ins_vfcn_due_dt.trim().hashCode());
		result = (prime * result) + ((last_name == null) ? 0 : last_name.trim().hashCode());
		result = (prime * result) + ((ma_ddct_bal_amt == null) ? 0 : ma_ddct_bal_amt.trim().hashCode());
		result = (prime * result) + ((manual_issuance_amt == null) ? 0 : manual_issuance_amt.trim().hashCode());
		result = (prime * result) + ((mci_id == null) ? 0 : mci_id.trim().hashCode());
		result = (prime * result) + ((mid_cert_review_date == null) ? 0 : mid_cert_review_date.trim().hashCode());
		result = (prime * result) + ((mid_name == null) ? 0 : mid_name.trim().hashCode());
		result = (prime * result) + ((msg_cd_txt == null) ? 0 : msg_cd_txt.trim().hashCode());
		result = (prime * result) + ((nf_elg_rslt_cd == null) ? 0 : nf_elg_rslt_cd.trim().hashCode());
		result = (prime * result) + ((nf_fail_rsn_1_cd == null) ? 0 : nf_fail_rsn_1_cd.trim().hashCode());
		result = (prime * result) + ((nf_fail_rsn_2_cd == null) ? 0 : nf_fail_rsn_2_cd.trim().hashCode());
		result = (prime * result) + ((nf_fail_rsn_3_cd == null) ? 0 : nf_fail_rsn_3_cd.trim().hashCode());
		result = (prime * result) + ((org_elg_ind == null) ? 0 : org_elg_ind.trim().hashCode());
		result = (prime * result) + ((pgm_rqst_sw == null) ? 0 : pgm_rqst_sw.trim().hashCode());
		result = (prime * result) + ((prev_pymt_amt == null) ? 0 : prev_pymt_amt.trim().hashCode());
		result = (prime * result) + ((prev_sc_bnft_l_cd == null) ? 0 : prev_sc_bnft_l_cd.trim().hashCode());
		result = (prime * result) + ((provider_id == null) ? 0 : provider_id.trim().hashCode());
		result = (prime * result) + ((pymt_amt == null) ? 0 : pymt_amt.trim().hashCode());
		result = (prime * result) + ((pymt_beg_dt == null) ? 0 : pymt_beg_dt.trim().hashCode());
		result = (prime * result) + ((pymt_end_dt == null) ? 0 : pymt_end_dt.trim().hashCode());
		result = (prime * result) + ((pymt_typ == null) ? 0 : pymt_typ.trim().hashCode());
		result = (prime * result) + ((requested_date == null) ? 0 : requested_date.trim().hashCode());
		result = (prime * result) + ((review_dt == null) ? 0 : review_dt.trim().hashCode());
		result = (prime * result) + ((sc_bnft_lvl_cd == null) ? 0 : sc_bnft_lvl_cd.trim().hashCode());
		result = (prime * result) + ((scat_cd == null) ? 0 : scat_cd.trim().hashCode());
		result = (prime * result) + ((scat_seq_num == null) ? 0 : scat_seq_num.trim().hashCode());
		result = (prime * result) + ((semi_annual_review_date == null) ? 0 : semi_annual_review_date.trim().hashCode());
		result = (prime * result) + ((ser_auth_dt == null) ? 0 : ser_auth_dt.trim().hashCode());
		result = (prime * result) + ((sex_ind == null) ? 0 : sex_ind.trim().hashCode());
		result = (prime * result) + ((smirf_actn_cd == null) ? 0 : smirf_actn_cd.trim().hashCode());
		result = (prime * result) + ((smirf_mo == null) ? 0 : smirf_mo.trim().hashCode());
		result = (prime * result) + ((updt_dt == null) ? 0 : updt_dt.trim().hashCode());
		result = (prime * result) + ((vfcn_due_dt == null) ? 0 : vfcn_due_dt.trim().hashCode());
		return result;
	}

	/**
	 * Returns the bnft_pin_num.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getBnft_pin_num() {
		return bnft_pin_num;
	}

	/**
	 * Sets the bnft_pin_num.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param bnft_pin_num
	 *            The bnft_pin_num to set
	 */

	public void setBnft_pin_num(final java.lang.String bnft_pin_num) {
		this.bnft_pin_num = bnft_pin_num;
	}

	/**
	 * Returns the bnft_case_num.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getBnft_case_num() {
		return bnft_case_num;
	}

	/**
	 * Sets the bnft_case_num.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param bnft_case_num
	 *            The bnft_case_num to set
	 */

	public void setBnft_case_num(final java.lang.String bnft_case_num) {
		this.bnft_case_num = bnft_case_num;
	}

	/**
	 * Returns the cat_cd.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getCat_cd() {
		return cat_cd;
	}

	/**
	 * Sets the cat_cd.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param cat_cd
	 *            The cat_cd to set
	 */

	public void setCat_cd(final java.lang.String cat_cd) {
		this.cat_cd = cat_cd;
	}

	/**
	 * Returns the scat_cd.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getScat_cd() {
		return scat_cd;
	}

	/**
	 * Sets the scat_cd.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param scat_cd
	 *            The scat_cd to set
	 */

	public void setScat_cd(final java.lang.String scat_cd) {
		this.scat_cd = scat_cd;
	}

	/**
	 * Returns the scat_seq_num.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getScat_seq_num() {
		return scat_seq_num;
	}

	/**
	 * Sets the scat_seq_num.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param scat_seq_num
	 *            The scat_seq_num to set
	 */

	public void setScat_seq_num(final java.lang.String scat_seq_num) {
		this.scat_seq_num = scat_seq_num;
	}

	/**
	 * Returns the cur_elg_ind.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getCur_elg_ind() {
		return cur_elg_ind;
	}

	/**
	 * Sets the cur_elg_ind.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param cur_elg_ind
	 *            The cur_elg_ind to set
	 */

	public void setCur_elg_ind(final java.lang.String cur_elg_ind) {
		this.cur_elg_ind = cur_elg_ind;
	}

	/**
	 * Returns the bnft_stat_cd.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getBnft_stat_cd() {
		return bnft_stat_cd;
	}

	/**
	 * Sets the bnft_stat_cd.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param bnft_stat_cd
	 *            The bnft_stat_cd to set
	 */

	public void setBnft_stat_cd(final java.lang.String bnft_stat_cd) {
		this.bnft_stat_cd = bnft_stat_cd;
	}

	/**
	 * Returns the cnfm_dt.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getCnfm_dt() {
		return cnfm_dt;
	}

	/**
	 * Sets the cnfm_dt.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param cnfm_dt
	 *            The cnfm_dt to set
	 */

	public void setCnfm_dt(final java.lang.String cnfm_dt) {
		this.cnfm_dt = cnfm_dt;
	}

	/**
	 * Returns the elg_beg_dt.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getElg_beg_dt() {
		return elg_beg_dt;
	}

	/**
	 * Sets the elg_beg_dt.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param elg_beg_dt
	 *            The elg_beg_dt to set
	 */

	public void setElg_beg_dt(final java.lang.String elg_beg_dt) {
		this.elg_beg_dt = elg_beg_dt;
	}

	/**
	 * Returns the elg_end_dt.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getElg_end_dt() {
		return elg_end_dt;
	}

	/**
	 * Sets the elg_end_dt.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param elg_end_dt
	 *            The elg_end_dt to set
	 */

	public void setElg_end_dt(final java.lang.String elg_end_dt) {
		this.elg_end_dt = elg_end_dt;
	}

	/**
	 * Returns the elg_ind.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getElg_ind() {
		return elg_ind;
	}

	/**
	 * Sets the elg_ind.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param elg_ind
	 *            The elg_ind to set
	 */

	public void setElg_ind(final java.lang.String elg_ind) {
		this.elg_ind = elg_ind;
	}

	/**
	 * Returns the ma_ddct_bal_amt.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getMa_ddct_bal_amt() {
		return ma_ddct_bal_amt;
	}

	/**
	 * Sets the ma_ddct_bal_amt.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param ma_ddct_bal_amt
	 *            The ma_ddct_bal_amt to set
	 */

	public void setMa_ddct_bal_amt(final java.lang.String ma_ddct_bal_amt) {
		this.ma_ddct_bal_amt = ma_ddct_bal_amt;
	}

	/**
	 * Returns the pymt_amt.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getPymt_amt() {
		return pymt_amt;
	}

	/**
	 * Sets the pymt_amt.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param pymt_amt
	 *            The pymt_amt to set
	 */

	public void setPymt_amt(final java.lang.String pymt_amt) {
		this.pymt_amt = pymt_amt;
	}

	/**
	 * Returns the pymt_beg_dt.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getPymt_beg_dt() {
		return pymt_beg_dt;
	}

	/**
	 * Sets the pymt_beg_dt.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param pymt_beg_dt
	 *            The pymt_beg_dt to set
	 */

	public void setPymt_beg_dt(final java.lang.String pymt_beg_dt) {
		this.pymt_beg_dt = pymt_beg_dt;
	}

	/**
	 * Returns the pymt_end_dt.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getPymt_end_dt() {
		return pymt_end_dt;
	}

	/**
	 * Sets the pymt_end_dt.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param pymt_end_dt
	 *            The pymt_end_dt to set
	 */

	public void setPymt_end_dt(final java.lang.String pymt_end_dt) {
		this.pymt_end_dt = pymt_end_dt;
	}

	/**
	 * Returns the pymt_typ.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getPymt_typ() {
		return pymt_typ;
	}

	/**
	 * Sets the pymt_typ.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param pymt_typ
	 *            The pymt_typ to set
	 */

	public void setPymt_typ(final java.lang.String pymt_typ) {
		this.pymt_typ = pymt_typ;
	}

	/**
	 * Returns the sc_bnft_lvl_cd.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getSc_bnft_lvl_cd() {
		return sc_bnft_lvl_cd;
	}

	/**
	 * Sets the sc_bnft_lvl_cd.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param sc_bnft_lvl_cd
	 *            The sc_bnft_lvl_cd to set
	 */

	public void setSc_bnft_lvl_cd(final java.lang.String sc_bnft_lvl_cd) {
		this.sc_bnft_lvl_cd = sc_bnft_lvl_cd;
	}

	/**
	 * Returns the updt_dt.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getUpdt_dt() {
		return updt_dt;
	}

	/**
	 * Sets the updt_dt.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param updt_dt
	 *            The updt_dt to set
	 */

	public void setUpdt_dt(final java.lang.String updt_dt) {
		this.updt_dt = updt_dt;
	}

	/**
	 * Returns the vfcn_due_dt.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getVfcn_due_dt() {
		return vfcn_due_dt;
	}

	/**
	 * Sets the vfcn_due_dt.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param vfcn_due_dt
	 *            The vfcn_due_dt to set
	 */

	public void setVfcn_due_dt(final java.lang.String vfcn_due_dt) {
		this.vfcn_due_dt = vfcn_due_dt;
	}

	/**
	 * Returns the msg_cd_txt.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getMsg_cd_txt() {
		return msg_cd_txt;
	}

	/**
	 * Sets the msg_cd_txt.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param msg_cd_txt
	 *            The msg_cd_txt to set
	 */

	public void setMsg_cd_txt(final java.lang.String msg_cd_txt) {
		this.msg_cd_txt = msg_cd_txt;
	}

	/**
	 * Returns the ag_stat_rsn_1_cd.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getAg_stat_rsn_1_cd() {
		return ag_stat_rsn_1_cd;
	}

	/**
	 * Sets the ag_stat_rsn_1_cd.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param ag_stat_rsn_1_cd
	 *            The ag_stat_rsn_1_cd to set
	 */

	public void setAg_stat_rsn_1_cd(final java.lang.String ag_stat_rsn_1_cd) {
		this.ag_stat_rsn_1_cd = ag_stat_rsn_1_cd;
	}

	/**
	 * Returns the ag_stat_rsn_2_cd.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getAg_stat_rsn_2_cd() {
		return ag_stat_rsn_2_cd;
	}

	/**
	 * Sets the ag_stat_rsn_2_cd.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param ag_stat_rsn_2_cd
	 *            The ag_stat_rsn_2_cd to set
	 */

	public void setAg_stat_rsn_2_cd(final java.lang.String ag_stat_rsn_2_cd) {
		this.ag_stat_rsn_2_cd = ag_stat_rsn_2_cd;
	}

	/**
	 * Returns the ag_stat_rsn_3_cd.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getAg_stat_rsn_3_cd() {
		return ag_stat_rsn_3_cd;
	}

	/**
	 * Sets the ag_stat_rsn_3_cd.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param ag_stat_rsn_3_cd
	 *            The ag_stat_rsn_3_cd to set
	 */

	public void setAg_stat_rsn_3_cd(final java.lang.String ag_stat_rsn_3_cd) {
		this.ag_stat_rsn_3_cd = ag_stat_rsn_3_cd;
	}

	/**
	 * Returns the nf_elg_rslt_cd.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getNf_elg_rslt_cd() {
		return nf_elg_rslt_cd;
	}

	/**
	 * Sets the nf_elg_rslt_cd.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param nf_elg_rslt_cd
	 *            The nf_elg_rslt_cd to set
	 */

	public void setNf_elg_rslt_cd(final java.lang.String nf_elg_rslt_cd) {
		this.nf_elg_rslt_cd = nf_elg_rslt_cd;
	}

	/**
	 * Returns the nf_fail_rsn_1_cd.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getNf_fail_rsn_1_cd() {
		return nf_fail_rsn_1_cd;
	}

	/**
	 * Sets the nf_fail_rsn_1_cd.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param nf_fail_rsn_1_cd
	 *            The nf_fail_rsn_1_cd to set
	 */

	public void setNf_fail_rsn_1_cd(final java.lang.String nf_fail_rsn_1_cd) {
		this.nf_fail_rsn_1_cd = nf_fail_rsn_1_cd;
	}

	/**
	 * Returns the nf_fail_rsn_2_cd.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getNf_fail_rsn_2_cd() {
		return nf_fail_rsn_2_cd;
	}

	/**
	 * Sets the nf_fail_rsn_2_cd.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param nf_fail_rsn_2_cd
	 *            The nf_fail_rsn_2_cd to set
	 */

	public void setNf_fail_rsn_2_cd(final java.lang.String nf_fail_rsn_2_cd) {
		this.nf_fail_rsn_2_cd = nf_fail_rsn_2_cd;
	}

	/**
	 * Returns the nf_fail_rsn_3_cd.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getNf_fail_rsn_3_cd() {
		return nf_fail_rsn_3_cd;
	}

	/**
	 * Sets the nf_fail_rsn_3_cd.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param nf_fail_rsn_3_cd
	 *            The nf_fail_rsn_3_cd to set
	 */

	public void setNf_fail_rsn_3_cd(final java.lang.String nf_fail_rsn_3_cd) {
		this.nf_fail_rsn_3_cd = nf_fail_rsn_3_cd;
	}

	/**
	 * Returns the org_elg_ind.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getOrg_elg_ind() {
		return org_elg_ind;
	}

	/**
	 * Sets the org_elg_ind.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param org_elg_ind
	 *            The org_elg_ind to set
	 */

	public void setOrg_elg_ind(final java.lang.String org_elg_ind) {
		this.org_elg_ind = org_elg_ind;
	}

	/**
	 * Returns the prev_pymt_amt.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getPrev_pymt_amt() {
		return prev_pymt_amt;
	}

	/**
	 * Sets the prev_pymt_amt.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param prev_pymt_amt
	 *            The prev_pymt_amt to set
	 */

	public void setPrev_pymt_amt(final java.lang.String prev_pymt_amt) {
		this.prev_pymt_amt = prev_pymt_amt;
	}

	/**
	 * Returns the fst_nam.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getFst_nam() {
		return fst_nam;
	}

	/**
	 * Sets the fst_nam.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param fst_nam
	 *            The fst_nam to set
	 */

	public void setFst_nam(final java.lang.String fst_nam) {
		this.fst_nam = fst_nam;
	}

	/**
	 * Returns the fs_fpl_130pct_amt.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getFs_fpl_130pct_amt() {
		return fs_fpl_130pct_amt;
	}

	/**
	 * Sets the fs_fpl_130pct_amt.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param fs_fpl_130pct_amt
	 *            The fs_fpl_130pct_amt to set
	 */

	public void setFs_fpl_130pct_amt(final java.lang.String fs_fpl_130pct_amt) {
		this.fs_fpl_130pct_amt = fs_fpl_130pct_amt;
	}

	/**
	 * Returns the fs_grp_typ.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getFs_grp_typ() {
		return fs_grp_typ;
	}

	/**
	 * Sets the fs_grp_typ.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param fs_grp_typ
	 *            The fs_grp_typ to set
	 */

	public void setFs_grp_typ(final java.lang.String fs_grp_typ) {
		this.fs_grp_typ = fs_grp_typ;
	}

	/**
	 * Returns the pgm_rqst_sw.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getPgm_rqst_sw() {
		return pgm_rqst_sw;
	}

	/**
	 * Sets the pgm_rqst_sw.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param pgm_rqst_sw
	 *            The pgm_rqst_sw to set
	 */

	public void setPgm_rqst_sw(final java.lang.String pgm_rqst_sw) {
		this.pgm_rqst_sw = pgm_rqst_sw;
	}

	/**
	 * Returns the sex_ind.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @return java.lang.String
	 */

	public java.lang.String getSex_ind() {
		return sex_ind;
	}

	/**
	 * Sets the sex_ind.
	 *
	 * Creation Date Tue Jul 26 14:13:47 CDT 2005
	 * @param sex_ind
	 *            The sex_ind to set
	 */

	public void setSex_ind(final java.lang.String sex_ind) {
		this.sex_ind = sex_ind;
	}

	/**
	 * @return
	 */
	public java.lang.String getBrth_dt() {
		return brth_dt;
	}

	/**
	 * @param string
	 */
	public void setBrth_dt(final java.lang.String string) {
		brth_dt = string;
	}

	/**
	 * @return
	 */
	public java.lang.String getPrev_sc_bnft_l_cd() {
		return prev_sc_bnft_l_cd;
	}

	/**
	 * @param string
	 */
	public void setPrev_sc_bnft_l_cd(final java.lang.String string) {
		prev_sc_bnft_l_cd = string;
	}

	/**
	 * @return
	 */
	public java.lang.String getEmpl_vfcn_due_dt() {
		return empl_vfcn_due_dt;
	}

	/**
	 * @return
	 */
	public java.lang.String getIns_vfcn_due_dt() {
		return ins_vfcn_due_dt;
	}

	/**
	 * @param string
	 */
	public void setEmpl_vfcn_due_dt(final java.lang.String string) {
		empl_vfcn_due_dt = string;
	}

	/**
	 * @param string
	 */
	public void setIns_vfcn_due_dt(final java.lang.String string) {
		ins_vfcn_due_dt = string;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public java.lang.String getSmirf_mo() {
		return smirf_mo;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public void setSmirf_mo(final java.lang.String string) {
		smirf_mo = string;
	}

	public java.lang.String getApp_num() {
		return app_num;
	}

	public void setApp_num(final java.lang.String app_num) {
		this.app_num = app_num;
	}

	public java.lang.String getMid_name() {
		return mid_name;
	}

	public void setMid_name(final java.lang.String mid_name) {
		this.mid_name = mid_name;
	}

	public java.lang.String getLast_name() {
		return last_name;
	}

	public void setLast_name(final java.lang.String last_name) {
		this.last_name = last_name;
	}

	public java.lang.String getEstm_elg_end_dt() {
		return estm_elg_end_dt;
	}

	public void setEstm_elg_end_dt(final java.lang.String estm_elg_end_dt) {
		this.estm_elg_end_dt = estm_elg_end_dt;
	}

	/**
	 * @return the ser_auth_dt
	 */
	public java.lang.String getSer_auth_dt() {
		return ser_auth_dt;
	}

	/**
	 * @param ser_auth_dt
	 *            the ser_auth_dt to set
	 */
	public void setSer_auth_dt(final java.lang.String ser_auth_dt) {
		this.ser_auth_dt = ser_auth_dt;
	}

	/**
	 * @return the requested_date
	 */
	public java.lang.String getRequested_date() {
		return requested_date;
	}

	/**
	 * @param requested_date
	 *            the requested_date to set
	 */
	public void setRequested_date(final java.lang.String requested_date) {
		this.requested_date = requested_date;
	}

	/**
	 * @return the client_amt
	 */
	public java.lang.String getClient_amt() {
		return client_amt;
	}

	/**
	 * @param client_amt
	 *            the client_amt to set
	 */
	public void setClient_amt(final java.lang.String client_amt) {
		this.client_amt = client_amt;
	}

	/**
	 * @return the provider_id
	 */
	public java.lang.String getProvider_id() {
		return provider_id;
	}

	/**
	 * @param provider_id
	 *            the provider_id to set
	 */
	public void setProvider_id(final java.lang.String provider_id) {
		this.provider_id = provider_id;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final CUST_INDV_ELG_Cargo other = (CUST_INDV_ELG_Cargo) obj;
		if (ag_stat_rsn_1_cd == null) {
			if (other.ag_stat_rsn_1_cd != null) {
				return false;
			}
		} else if (!ag_stat_rsn_1_cd.equals(other.ag_stat_rsn_1_cd)) {
			return false;
		}
		if (ag_stat_rsn_2_cd == null) {
			if (other.ag_stat_rsn_2_cd != null) {
				return false;
			}
		} else if (!ag_stat_rsn_2_cd.equals(other.ag_stat_rsn_2_cd)) {
			return false;
		}
		if (ag_stat_rsn_3_cd == null) {
			if (other.ag_stat_rsn_3_cd != null) {
				return false;
			}
		} else if (!ag_stat_rsn_3_cd.equals(other.ag_stat_rsn_3_cd)) {
			return false;
		}
		if (app_num == null) {
			if (other.app_num != null) {
				return false;
			}
		} else if (!app_num.equals(other.app_num)) {
			return false;
		}
		if (bnft_case_num == null) {
			if (other.bnft_case_num != null) {
				return false;
			}
		} else if (!bnft_case_num.equals(other.bnft_case_num)) {
			return false;
		}
		if (bnft_pin_num == null) {
			if (other.bnft_pin_num != null) {
				return false;
			}
		} else if (!bnft_pin_num.equals(other.bnft_pin_num)) {
			return false;
		}
		if (bnft_stat_cd == null) {
			if (other.bnft_stat_cd != null) {
				return false;
			}
		} else if (!bnft_stat_cd.equals(other.bnft_stat_cd)) {
			return false;
		}
		if (brth_dt == null) {
			if (other.brth_dt != null) {
				return false;
			}
		} else if (!brth_dt.equals(other.brth_dt)) {
			return false;
		}
		if (cat_cd == null) {
			if (other.cat_cd != null) {
				return false;
			}
		} else if (!cat_cd.equals(other.cat_cd)) {
			return false;
		}
		if (client_amt == null) {
			if (other.client_amt != null) {
				return false;
			}
		} else if (!client_amt.equals(other.client_amt)) {
			return false;
		}
		if (cnfm_dt == null) {
			if (other.cnfm_dt != null) {
				return false;
			}
		} else if (!cnfm_dt.equals(other.cnfm_dt)) {
			return false;
		}
		if (cur_elg_ind == null) {
			if (other.cur_elg_ind != null) {
				return false;
			}
		} else if (!cur_elg_ind.equals(other.cur_elg_ind)) {
			return false;
		}
		if (elg_beg_dt == null) {
			if (other.elg_beg_dt != null) {
				return false;
			}
		} else if (!elg_beg_dt.equals(other.elg_beg_dt)) {
			return false;
		}
		if (elg_end_dt == null) {
			if (other.elg_end_dt != null) {
				return false;
			}
		} else if (!elg_end_dt.equals(other.elg_end_dt)) {
			return false;
		}
		if (elg_ind == null) {
			if (other.elg_ind != null) {
				return false;
			}
		} else if (!elg_ind.equals(other.elg_ind)) {
			return false;
		}
		if (empl_vfcn_due_dt == null) {
			if (other.empl_vfcn_due_dt != null) {
				return false;
			}
		} else if (!empl_vfcn_due_dt.equals(other.empl_vfcn_due_dt)) {
			return false;
		}
		if (estm_elg_end_dt == null) {
			if (other.estm_elg_end_dt != null) {
				return false;
			}
		} else if (!estm_elg_end_dt.equals(other.estm_elg_end_dt)) {
			return false;
		}
		if (fapAmountExists != other.fapAmountExists) {
			return false;
		}
		if (fs_fpl_130pct_amt == null) {
			if (other.fs_fpl_130pct_amt != null) {
				return false;
			}
		} else if (!fs_fpl_130pct_amt.equals(other.fs_fpl_130pct_amt)) {
			return false;
		}
		if (fs_grp_typ == null) {
			if (other.fs_grp_typ != null) {
				return false;
			}
		} else if (!fs_grp_typ.equals(other.fs_grp_typ)) {
			return false;
		}
		if (fst_nam == null) {
			if (other.fst_nam != null) {
				return false;
			}
		} else if (!fst_nam.equals(other.fst_nam)) {
			return false;
		}
		if (ins_vfcn_due_dt == null) {
			if (other.ins_vfcn_due_dt != null) {
				return false;
			}
		} else if (!ins_vfcn_due_dt.equals(other.ins_vfcn_due_dt)) {
			return false;
		}
		if (last_name == null) {
			if (other.last_name != null) {
				return false;
			}
		} else if (!last_name.equals(other.last_name)) {
			return false;
		}
		if (ma_ddct_bal_amt == null) {
			if (other.ma_ddct_bal_amt != null) {
				return false;
			}
		} else if (!ma_ddct_bal_amt.equals(other.ma_ddct_bal_amt)) {
			return false;
		}
		if (manual_issuance_amt == null) {
			if (other.manual_issuance_amt != null) {
				return false;
			}
		} else if (!manual_issuance_amt.equals(other.manual_issuance_amt)) {
			return false;
		}
		if (mci_id == null) {
			if (other.mci_id != null) {
				return false;
			}
		} else if (!mci_id.equals(other.mci_id)) {
			return false;
		}
		if (mid_cert_review_date == null) {
			if (other.mid_cert_review_date != null) {
				return false;
			}
		} else if (!mid_cert_review_date.equals(other.mid_cert_review_date)) {
			return false;
		}
		if (mid_name == null) {
			if (other.mid_name != null) {
				return false;
			}
		} else if (!mid_name.equals(other.mid_name)) {
			return false;
		}
		if (msg_cd_txt == null) {
			if (other.msg_cd_txt != null) {
				return false;
			}
		} else if (!msg_cd_txt.equals(other.msg_cd_txt)) {
			return false;
		}
		if (nf_elg_rslt_cd == null) {
			if (other.nf_elg_rslt_cd != null) {
				return false;
			}
		} else if (!nf_elg_rslt_cd.equals(other.nf_elg_rslt_cd)) {
			return false;
		}
		if (nf_fail_rsn_1_cd == null) {
			if (other.nf_fail_rsn_1_cd != null) {
				return false;
			}
		} else if (!nf_fail_rsn_1_cd.equals(other.nf_fail_rsn_1_cd)) {
			return false;
		}
		if (nf_fail_rsn_2_cd == null) {
			if (other.nf_fail_rsn_2_cd != null) {
				return false;
			}
		} else if (!nf_fail_rsn_2_cd.equals(other.nf_fail_rsn_2_cd)) {
			return false;
		}
		if (nf_fail_rsn_3_cd == null) {
			if (other.nf_fail_rsn_3_cd != null) {
				return false;
			}
		} else if (!nf_fail_rsn_3_cd.equals(other.nf_fail_rsn_3_cd)) {
			return false;
		}
		if (org_elg_ind == null) {
			if (other.org_elg_ind != null) {
				return false;
			}
		} else if (!org_elg_ind.equals(other.org_elg_ind)) {
			return false;
		}
		if (pgm_rqst_sw == null) {
			if (other.pgm_rqst_sw != null) {
				return false;
			}
		} else if (!pgm_rqst_sw.equals(other.pgm_rqst_sw)) {
			return false;
		}
		if (prev_pymt_amt == null) {
			if (other.prev_pymt_amt != null) {
				return false;
			}
		} else if (!prev_pymt_amt.equals(other.prev_pymt_amt)) {
			return false;
		}
		if (prev_sc_bnft_l_cd == null) {
			if (other.prev_sc_bnft_l_cd != null) {
				return false;
			}
		} else if (!prev_sc_bnft_l_cd.equals(other.prev_sc_bnft_l_cd)) {
			return false;
		}
		if (provider_id == null) {
			if (other.provider_id != null) {
				return false;
			}
		} else if (!provider_id.equals(other.provider_id)) {
			return false;
		}
		if (pymt_amt == null) {
			if (other.pymt_amt != null) {
				return false;
			}
		} else if (!pymt_amt.equals(other.pymt_amt)) {
			return false;
		}
		if (pymt_beg_dt == null) {
			if (other.pymt_beg_dt != null) {
				return false;
			}
		} else if (!pymt_beg_dt.equals(other.pymt_beg_dt)) {
			return false;
		}
		if (pymt_end_dt == null) {
			if (other.pymt_end_dt != null) {
				return false;
			}
		} else if (!pymt_end_dt.equals(other.pymt_end_dt)) {
			return false;
		}
		if (pymt_typ == null) {
			if (other.pymt_typ != null) {
				return false;
			}
		} else if (!pymt_typ.equals(other.pymt_typ)) {
			return false;
		}
		if (requested_date == null) {
			if (other.requested_date != null) {
				return false;
			}
		} else if (!requested_date.equals(other.requested_date)) {
			return false;
		}
		if (review_dt == null) {
			if (other.review_dt != null) {
				return false;
			}
		} else if (!review_dt.equals(other.review_dt)) {
			return false;
		}
		if (sc_bnft_lvl_cd == null) {
			if (other.sc_bnft_lvl_cd != null) {
				return false;
			}
		} else if (!sc_bnft_lvl_cd.equals(other.sc_bnft_lvl_cd)) {
			return false;
		}
		if (scat_cd == null) {
			if (other.scat_cd != null) {
				return false;
			}
		} else if (!scat_cd.equals(other.scat_cd)) {
			return false;
		}
		if (scat_seq_num == null) {
			if (other.scat_seq_num != null) {
				return false;
			}
		} else if (!scat_seq_num.equals(other.scat_seq_num)) {
			return false;
		}
		if (semi_annual_review_date == null) {
			if (other.semi_annual_review_date != null) {
				return false;
			}
		} else if (!semi_annual_review_date.equals(other.semi_annual_review_date)) {
			return false;
		}
		if (ser_auth_dt == null) {
			if (other.ser_auth_dt != null) {
				return false;
			}
		} else if (!ser_auth_dt.equals(other.ser_auth_dt)) {
			return false;
		}
		if (sex_ind == null) {
			if (other.sex_ind != null) {
				return false;
			}
		} else if (!sex_ind.equals(other.sex_ind)) {
			return false;
		}
		if (smirf_actn_cd == null) {
			if (other.smirf_actn_cd != null) {
				return false;
			}
		} else if (!smirf_actn_cd.equals(other.smirf_actn_cd)) {
			return false;
		}
		if (smirf_mo == null) {
			if (other.smirf_mo != null) {
				return false;
			}
		} else if (!smirf_mo.equals(other.smirf_mo)) {
			return false;
		}
		if (updt_dt == null) {
			if (other.updt_dt != null) {
				return false;
			}
		} else if (!updt_dt.equals(other.updt_dt)) {
			return false;
		}
		if (vfcn_due_dt == null) {
			if (other.vfcn_due_dt != null) {
				return false;
			}
		} else if (!vfcn_due_dt.equals(other.vfcn_due_dt)) {
			return false;
		}
		return true;
	}

}