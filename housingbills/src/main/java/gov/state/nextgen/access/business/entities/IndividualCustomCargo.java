package gov.state.nextgen.access.business.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import gov.state.nextgen.access.management.util.IndividualAge;


/* @Table(name = "HOUSING_EXPENSE_CUST") 
 * Ask Azhar for custome cargo*/
public class IndividualCustomCargo extends AbstractCargo{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private java.lang.String indv_seq_num;
	private java.lang.String indv_pin_num;
	private String mci_id;
	private java.lang.String brth_dt;
	private java.lang.String fst_nam;
	private java.lang.String last_nam;
	private java.lang.String mid_init;
	private java.lang.String rlvn_ind;
	private java.lang.String sex_ind;
	private java.lang.String rlt_cd;
	private IndividualAge indv_age;
	private java.lang.String live_arng_typ;
	private java.lang.String dabl_resp;
	private java.lang.String preg_resp;
	private java.lang.String relation_resp;
	private java.lang.String out_of_home_ind;
	private java.lang.String chld_trb_mbr_resp;
	private java.lang.String trb_mbr_resp;

	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.INDIVIDUAL_Custom_Cargo";

	// EDSP Starts
	private java.lang.String suffix_name;
	private java.lang.String res_va_sw;
	private java.lang.String Src_app_ind;
	private java.lang.String absence_reason_cd;
	private java.lang.String left_home_dt;

	private java.lang.String res_ga_ind;
	private java.lang.String living_arrangement_cd;

	// adding ssn field to cargo
	private java.lang.String ssn_num;
	private java.lang.String rec_cplt_ind;

	public java.lang.String getLiving_arrangement_cd() {
		return living_arrangement_cd;
	}

	public void setLiving_arrangement_cd(final java.lang.String living_arrangement_cd) {
		this.living_arrangement_cd = living_arrangement_cd;
	}

	public java.lang.String getRes_ga_ind() {
		return res_ga_ind;
	}

	public void setRes_ga_ind(final java.lang.String res_ga_ind) {
		this.res_ga_ind = res_ga_ind;
	}

	public java.lang.String getSrc_app_ind() {
		return Src_app_ind;
	}

	public void setSrc_app_ind(final java.lang.String src_app_ind) {
		Src_app_ind = src_app_ind;
	}

	public java.lang.String getAbsence_reason_cd() {
		return absence_reason_cd;
	}

	public void setAbsence_reason_cd(final java.lang.String aAbsence_reason_cd) {
		absence_reason_cd = aAbsence_reason_cd;
	}

	public java.lang.String getLeft_home_dt() {
		return left_home_dt;
	}

	public void setLeft_home_dt(final java.lang.String aLeft_home_dt) {
		left_home_dt = aLeft_home_dt;
	}

	/**
	 * @return the suffix_name
	 */
	public String getSuffix_name() {
		return suffix_name;
	}

	/**
	 * @param suffix_name
	 *            the suffix_name to set
	 */
	public void setSuffix_name(final String suffix_name) {
		this.suffix_name = suffix_name;
	}

	/**
	 * @return the res_va_sw
	 */
	public String getRes_va_sw() {
		return res_va_sw;
	}

	/**
	 * @param res_va_sw
	 *            the res_va_sw to set
	 */
	public void setRes_va_sw(final String res_va_sw) {
		this.res_va_sw = res_va_sw;
	}

	// EDSP Ends

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
	 * @return gov.state.nextgen.access.business.entities.APP_INDV_Cargo
	 */
	public String getPackage() {
		return PACKAGE;
	}

	/**
	 * Returns the primary key values of a cargo
	 *
	 * @return java.lang.String
	 */

	
	public IPrimaryKey getPrimaryKey() {
		return null;
	}

	/**
	 * Inspects Cargo values for debug.
	 *
	 * @return java.lang.String
	 */
	
	public String inspectCargo() {
		return "indv_seq_num=" + indv_seq_num + "," + "indv_pin_num=" + indv_pin_num + "," + "brth_dt=" + brth_dt + "," + "fst_nam=" + fst_nam + ","
				+ "last_nam=" + last_nam + "," + "mid_init=" + mid_init + "," + "rlvn_ind=" + rlvn_ind + "," + "sex_ind=" + sex_ind + "," + "rlt_cd="
				+ rlt_cd + "," + "indv_age=" + indv_age + "," + "live_arng_typ=" + live_arng_typ + "," + "dabl_resp=" + dabl_resp + ","
				+ "preg_resp=" + preg_resp + ",out_of_home_ind=" + out_of_home_ind + ",chld_trb_mbr_resp=" + chld_trb_mbr_resp + ",trb_mbr_resp"
				+ trb_mbr_resp + ",mci_id" + mci_id;

	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public static String getPACKAGE() {
		return PACKAGE;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public java.lang.String getFst_nam() {
		return fst_nam;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public java.lang.String getIndv_seq_num() {
		return indv_seq_num;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public java.lang.String getLast_nam() {
		return last_nam;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public java.lang.String getMid_init() {
		return mid_init;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public java.lang.String getRlvn_ind() {
		return rlvn_ind;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public java.lang.String getSex_ind() {
		return sex_ind;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public void setFst_nam(final java.lang.String string) {
		fst_nam = string;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public void setIndv_seq_num(final java.lang.String string) {
		indv_seq_num = string;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public void setLast_nam(final java.lang.String string) {
		last_nam = string;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public void setMid_init(final java.lang.String string) {
		mid_init = string;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public void setRlvn_ind(final java.lang.String string) {
		rlvn_ind = string;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public void setSex_ind(final java.lang.String string) {
		sex_ind = string;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public java.lang.String getRlt_cd() {
		return rlt_cd;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public void setRlt_cd(final java.lang.String string) {
		rlt_cd = string;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public java.lang.String getBrth_dt() {
		return brth_dt;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public void setBrth_dt(final java.lang.String string) {
		brth_dt = string;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public IndividualAge getIndv_age() {
		return indv_age;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public void setIndv_age(final IndividualAge age) {
		indv_age = age;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public java.lang.String getIndv_pin_num() {
		return indv_pin_num;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public void setIndv_pin_num(final java.lang.String string) {
		indv_pin_num = string;
	}

	/**
	 * @return Returns the live_arng_typ.
	 */
	public java.lang.String getLive_arng_typ() {
		return live_arng_typ;
	}

	/**
	 * @param live_arng_typ
	 *            The live_arng_typ to set.
	 */
	public void setLive_arng_typ(final java.lang.String live_arng_typ) {
		this.live_arng_typ = live_arng_typ;
	}

	/**
	 * @return Returns the dabl_resp.
	 */
	public java.lang.String getDabl_resp() {
		return dabl_resp;
	}

	/**
	 * @param dabl_resp
	 *            The dabl_resp to set.
	 */
	public void setDabl_resp(final java.lang.String dabl_resp) {
		this.dabl_resp = dabl_resp;
	}

	/**
	 * @return Returns the preg_resp.
	 */
	public java.lang.String getPreg_resp() {
		return preg_resp;
	}

	/**
	 * @param preg_resp
	 *            The preg_resp to set.
	 */
	public void setPreg_resp(final java.lang.String preg_resp) {
		this.preg_resp = preg_resp;
	}

	/**
	 * @return Returns the relation_resp.
	 */
	public java.lang.String getRelation_resp() {
		return relation_resp;
	}

	/**
	 * @param relation_resp
	 *            The relation_resp to set.
	 */
	public void setRelation_resp(final java.lang.String relation_resp) {
		this.relation_resp = relation_resp;
	}

	/**
	 * @return Returns the out_of_home_ind.
	 */
	public java.lang.String getOut_of_home_ind() {
		return out_of_home_ind;
	}

	/**
	 * @param out_of_home_ind
	 *            The out_of_home_ind to set.
	 */
	public void setOut_of_home_ind(final java.lang.String out_of_home_ind) {
		this.out_of_home_ind = out_of_home_ind;
	}

	/**
	 * @return Returns the chld_trb_mbr_resp.
	 */
	public java.lang.String getChld_trb_mbr_resp() {
		return chld_trb_mbr_resp;
	}

	/**
	 * @param chld_trb_mbr_resp
	 *            The chld_trb_mbr_resp to set.
	 */
	public void setChld_trb_mbr_resp(final java.lang.String chld_trb_mbr_resp) {
		this.chld_trb_mbr_resp = chld_trb_mbr_resp;
	}

	/**
	 * @return Returns the trb_mbr_resp.
	 */
	public java.lang.String getTrb_mbr_resp() {
		return trb_mbr_resp;
	}

	/**
	 * @param trb_mbr_resp
	 *            The trb_mbr_resp to set.
	 */
	public void setTrb_mbr_resp(final java.lang.String trb_mbr_resp) {
		this.trb_mbr_resp = trb_mbr_resp;
	}

	public java.lang.String getSsn_num() {
		return ssn_num;
	}

	public void setSsn_num(final java.lang.String ssn_num) {
		this.ssn_num = ssn_num;
	}

	public java.lang.String getRec_cplt_ind() {
		return rec_cplt_ind;
	}

	public void setRec_cplt_ind(final java.lang.String rec_cplt_ind) {
		this.rec_cplt_ind = rec_cplt_ind;
	}
}
