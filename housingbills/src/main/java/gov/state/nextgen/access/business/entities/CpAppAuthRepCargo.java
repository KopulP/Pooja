package gov.state.nextgen.access.business.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CP_APP_AUTH_REP")
public class CpAppAuthRepCargo  implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.CP_APP_AUTH_REP";

	@Transient
	boolean isDirty = false;
	
	@EmbeddedId
	private CpAppAuthRepPrimaryKey cpAppAuthRepPrimaryKey;
	
	private String auth_rep_nam;
	private String auth_rep_fst_nam;
	private String auth_rep_mid_nam;
	private String auth_rep_last_nam;
	private String auth_rep_suffix;
	private String auth_rep_org_nam;
	private String auth_rep_id_num;
	private String auth_rep_l1_adr;
	private String auth_rep_l2_adr;
	private String auth_rep_city_adr;
	private String auth_rep_sta_adr;
	private String auth_rep_zip_adr;
	private String auth_rep_phn_num;
	private String rel_to_auth_rep_typ_cd;
	private String auth_rep_duty_afb_ind;
	private String auth_rep_duty_benefits_ind;
	private String auth_rep_duty_receive_ind;
	private String auth_rep_duty_request_ind;
	private String auth_rep_duty_other_ind;
	private String auth_rep_info_share_ind;
	private String snap_auth_rep_ind;
	private String tanf_auth_rep_ind;
	private String auth_rep_medical_assist_ind;
	private String rec_cplt_ind;
	private String app_start_dt;

	private String auth_rep_fst_nme;
	private transient String moduleType = "AFB";
	private String addrZip4;

	public String getModuleType() {
		return moduleType;
	}

	public void setModuleType(final String moduleType) {
		this.moduleType = moduleType;
	}

	/**
	 * @return the auth_rep_fst_nme
	 */
	public String getAuth_rep_fst_nme() {
		return auth_rep_fst_nme;
	}

	/**
	 * @param auth_rep_fst_nme the auth_rep_fst_nme to set
	 */
	public void setAuth_rep_fst_nme(final String auth_rep_fst_nme) {
		this.auth_rep_fst_nme = auth_rep_fst_nme;
	}


	/**
	 *
	 * @return
	 */
	public String getAuth_rep_nam() {
		return auth_rep_nam;
	}

	/**
	 *
	 * @param auth_rep_nam
	 */

	public void setAuth_rep_nam(final String auth_rep_nam) {
		this.auth_rep_nam = auth_rep_nam;
	}

	/**
	 * @return the auth_rep_l1_adr
	 */
	public String getAuth_rep_l1_adr() {
		return auth_rep_l1_adr;
	}

	/**
	 * @param auth_rep_l1_adr
	 *            the auth_rep_l1_adr to set
	 */
	public void setAuth_rep_l1_adr(final String auth_rep_l1_adr) {
		this.auth_rep_l1_adr = auth_rep_l1_adr;
	}

	/**
	 * @return the auth_rep_l2_adr
	 */
	public String getAuth_rep_l2_adr() {
		return auth_rep_l2_adr;
	}

	/**
	 * @param auth_rep_l2_adr
	 *            the auth_rep_l2_adr to set
	 */
	public void setAuth_rep_l2_adr(final String auth_rep_l2_adr) {
		this.auth_rep_l2_adr = auth_rep_l2_adr;
	}

	/**
	 * @return the auth_rep_org_nme
	 */
	public String getAuth_rep_org_nam() {
		return auth_rep_org_nam;
	}

	/**
	 * @param auth_rep_org_nam
	 *            the auth_rep_org_nam to set
	 */
	public void setAuth_rep_org_nam(final String auth_rep_org_nam) {
		this.auth_rep_org_nam = auth_rep_org_nam;
	}

	/**
	 * @return the auth_rep_id_nbr
	 */
	public String getAuth_rep_id_num() {
		return auth_rep_id_num;
	}

	/**
	 * @param auth_rep_id_num
	 *            the auth_rep_id_num to set
	 */
	public void setAuth_rep_id_num(final String auth_rep_id_num) {
		this.auth_rep_id_num = auth_rep_id_num;
	}

	/**
	 * @return the auth_rep_city_adr
	 */
	public String getAuth_rep_city_adr() {
		return auth_rep_city_adr;
	}

	/**
	 * @param auth_rep_city_adr
	 *            the auth_rep_city_adr to set
	 */
	public void setAuth_rep_city_adr(final String auth_rep_city_adr) {
		this.auth_rep_city_adr = auth_rep_city_adr;
	}

	/**
	 * @return the auth_rep_sta_adr
	 */
	public String getAuth_rep_sta_adr() {
		return auth_rep_sta_adr;
	}

	/**
	 * @return the auth_rep_mid_nam
	 */
	public String getAuth_rep_mid_nam() {
		return auth_rep_mid_nam;
	}

	/**
	 * @param auth_rep_mid_nam
	 *            the auth_rep_mid_nam to set
	 */
	public void setAuth_rep_mid_nam(final String auth_rep_mid_nam) {
		this.auth_rep_mid_nam = auth_rep_mid_nam;
	}

	/**
	 * @param auth_rep_sta_adr
	 *            the auth_rep_sta_adr to set
	 */
	public void setAuth_rep_sta_adr(final String auth_rep_sta_adr) {
		this.auth_rep_sta_adr = auth_rep_sta_adr;
	}

	/**
	 * @return the auth_rep_zip_adr
	 */
	public String getAuth_rep_zip_adr() {
		return auth_rep_zip_adr;
	}

	/**
	 * @param auth_rep_zip_adr
	 *            the auth_rep_zip_adr to set
	 */
	public void setAuth_rep_zip_adr(final String auth_rep_zip_adr) {
		this.auth_rep_zip_adr = auth_rep_zip_adr;
	}

	/**
	 * @return the auth_rep_phn_num
	 */
	public String getAuth_rep_phn_num() {
		return auth_rep_phn_num;
	}

	/**
	 * @param auth_rep_phn_num
	 *            the auth_rep_phn_num to set
	 */
	public void setAuth_rep_phn_num(final String auth_rep_phn_num) {
		this.auth_rep_phn_num = auth_rep_phn_num;
	}

	/**
	 * @return the rel_to_auth_rep
	 */
	public String getRel_to_auth_rep_typ_cd() {
		return rel_to_auth_rep_typ_cd;
	}

	/**
	 * @param rel_to_auth_rep_typ_cd
	 *            the rel_to_auth_rep_typ_cd to set
	 */
	public void setRel_to_auth_rep_typ_cd(final String rel_to_auth_rep_typ_cd) {
		this.rel_to_auth_rep_typ_cd = rel_to_auth_rep_typ_cd;
	}

	/**
	 * @return the app_start_dt
	 */
	public String getApp_start_dt() {
		return app_start_dt;
	}

	/**
	 * @return the auth_rep_last_nam
	 */
	public String getAuth_rep_last_nam() {
		return auth_rep_last_nam;
	}

	/**
	 * @param auth_rep_last_nam
	 *            the auth_rep_last_nam to set
	 */
	public void setAuth_rep_last_nam(final String auth_rep_last_nam) {
		this.auth_rep_last_nam = auth_rep_last_nam;
	}

	/**
	 * @param app_start_dt
	 *            the app_start_dt to set
	 */
	public void setApp_start_dt(final String app_start_dt) {
		this.app_start_dt = app_start_dt;
	}

	/**
	 * @return the suffix
	 */
	public String getAuth_rep_suffix() {
		return auth_rep_suffix;
	}

	/**
	 * @param auth_rep_suffix
	 *            the suffix to set
	 */
	public void setAuth_rep_suffix(final String auth_rep_suffix) {
		this.auth_rep_suffix = auth_rep_suffix;
	}

	/**
	 * @return the auth_rep_fst_nam
	 */
	public String getAuth_rep_fst_nam() {
		return auth_rep_fst_nam;
	}

	/**
	 * @param auth_rep_fst_nam
	 *            the auth_rep_fst_nam to set
	 */
	public void setAuth_rep_fst_nam(final String auth_rep_fst_nam) {
		this.auth_rep_fst_nam = auth_rep_fst_nam;
	}

	/**
	 * @return the auth_rep_duty_afb_ind
	 */
	public String getAuth_rep_duty_afb_ind() {
		return auth_rep_duty_afb_ind;
	}

	/**
	 * @param auth_rep_duty_afb_ind
	 *            the auth_rep_duty_afb_ind to set
	 */
	public void setAuth_rep_duty_afb_ind(final String auth_rep_duty_afb_ind) {
		this.auth_rep_duty_afb_ind = auth_rep_duty_afb_ind;
	}

	/**
	 * @return the auth_rep_duty_receive_ind
	 */
	public String getAuth_rep_duty_receive_ind() {
		return auth_rep_duty_receive_ind;
	}

	/**
	 * @param auth_rep_duty_receive_ind
	 *            the auth_rep_duty_receive_ind to set
	 */
	public void setAuth_rep_duty_receive_ind(final String auth_rep_duty_receive_ind) {
		this.auth_rep_duty_receive_ind = auth_rep_duty_receive_ind;
	}

	/**
	 * @return the auth_rep_duty_request_ind
	 */
	public String getAuth_rep_duty_request_ind() {
		return auth_rep_duty_request_ind;
	}

	/**
	 * @param auth_rep_duty_request_ind
	 *            the auth_rep_duty_request_ind to set
	 */
	public void setAuth_rep_duty_request_ind(final String auth_rep_duty_request_ind) {
		this.auth_rep_duty_request_ind = auth_rep_duty_request_ind;
	}

	/**
	 * @return the auth_rep_duty_other_ind
	 */
	public String getAuth_rep_duty_other_ind() {
		return auth_rep_duty_other_ind;
	}

	/**
	 * @param auth_rep_duty_other_ind
	 *            the auth_rep_duty_other_ind to set
	 */
	public void setAuth_rep_duty_other_ind(final String auth_rep_duty_other_ind) {
		this.auth_rep_duty_other_ind = auth_rep_duty_other_ind;
	}

	/**
	 * @return the auth_rep_info_share_ind
	 */
	public String getAuth_rep_info_share_ind() {
		return auth_rep_info_share_ind;
	}

	/**
	 * @param auth_rep_info_share_ind
	 *            the auth_rep_info_share_ind to set
	 */
	public void setAuth_rep_info_share_ind(final String auth_rep_info_share_ind) {
		this.auth_rep_info_share_ind = auth_rep_info_share_ind;
	}

	/**
	 * @return the snap_auth_rep_ind
	 */
	public String getSnap_auth_rep_ind() {
		return snap_auth_rep_ind;
	}

	/**
	 * @param snap_auth_rep_ind
	 *            the snap_auth_rep_ind to set
	 */
	public void setSnap_auth_rep_ind(final String snap_auth_rep_ind) {
		this.snap_auth_rep_ind = snap_auth_rep_ind;
	}

	/**
	 * @return the tanf_auth_rep_ind
	 */
	public String getTanf_auth_rep_ind() {
		return tanf_auth_rep_ind;
	}

	/**
	 * @param tanf_auth_rep_ind
	 *            the tanf_auth_rep_ind to set
	 */
	public void setTanf_auth_rep_ind(final String tanf_auth_rep_ind) {
		this.tanf_auth_rep_ind = tanf_auth_rep_ind;
	}

	/**
	 * @return the auth_rep_medical_assist_ind
	 */
	public String getAuth_rep_medical_assist_ind() {
		return auth_rep_medical_assist_ind;
	}

	/**
	 * @param auth_rep_medical_assist_ind
	 *            the auth_rep_medical_assist_ind to set
	 */
	public void setAuth_rep_medical_assist_ind(final String auth_rep_medical_assist_ind) {
		this.auth_rep_medical_assist_ind = auth_rep_medical_assist_ind;
	}

	/**
	 * @return the auth_rep_duty_benefits_ind
	 */
	public String getAuth_rep_duty_benefits_ind() {
		return auth_rep_duty_benefits_ind;
	}

	/**
	 * @param auth_rep_duty_benefits_ind
	 *            the auth_rep_duty_benefits_ind to set
	 */
	public void setAuth_rep_duty_benefits_ind(final String auth_rep_duty_benefits_ind) {
		this.auth_rep_duty_benefits_ind = auth_rep_duty_benefits_ind;
	}

	

	/**
	 * @return the rec_cplt_ind
	 */
	public String getRec_cplt_ind() {
		return rec_cplt_ind;
	}

	/**
	 * @param rec_cplt_ind
	 *            the rec_cplt_ind to set
	 */
	public void setRec_cplt_ind(final String rec_cplt_ind) {
		this.rec_cplt_ind = rec_cplt_ind;
	}

		
}
