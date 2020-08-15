package gov.state.nextgen.access.business.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CP_APP_ESGIN")
public class CpAppEsginCargo  implements Serializable{

	@EmbeddedId
	private CpAppEsgginPrimaryKey cpAppEsgginPrimaryKey;

	@Transient
	boolean isDirty = false;
	
	private String appl_esign_ind;
	private String appl_fst_nam;
	private String appl_last_nam;
	private String appl_mid_init;
	private String appl_suffix_name;
	private String appl_esign_date;
	private String auth_rep_esign_ind;
	private String auth_rep_fst_nam;
	private String auth_rep_last_nam;
	private String auth_rep_mid_init;
	private String auth_rep_suffix_name;
	private String auth_rep_esign_date;
	private String appl_hipaa_esign_ind;
	private String appl_hipaa_fst_nam;
	private String appl_hipaa_last_nam;
	private String appl_hipaa_mid_init;
	private String appl_hipaa_suffix_name;
	private String appl_hipaa_esign_date;
	private String appl_citz_decl_esign_ind;
	private String appl_citz_decl_fst_nam;
	private String appl_citz_decl_last_nam;
	private String appl_citz_decl_mid_init;
	private String appl_citz_decl_suffix_name;
	private String appl_citz_decl_esign_date;
	private String appl_voter_reg_resp;

	
	public boolean isDirty() {
		return isDirty;
	}

	
	public void setDirty(final boolean isDirty) {
		this.isDirty = isDirty;
	}

	public String getAppl_esign_ind() {
		return appl_esign_ind;
	}

	public void setAppl_esign_ind(final String appl_esign_ind) {
		this.appl_esign_ind = appl_esign_ind;
	}

	public String getAppl_fst_nam() {
		return appl_fst_nam;
	}

	public void setAppl_fst_nam(final String appl_fst_nam) {
		this.appl_fst_nam = appl_fst_nam;
	}

	public String getAppl_last_nam() {
		return appl_last_nam;
	}

	public void setAppl_last_nam(final String appl_last_nam) {
		this.appl_last_nam = appl_last_nam;
	}

	public String getAppl_mid_init() {
		return appl_mid_init;
	}

	public void setAppl_mid_init(final String appl_mid_init) {
		this.appl_mid_init = appl_mid_init;
	}

	public String getAppl_suffix_name() {
		return appl_suffix_name;
	}

	public void setAppl_suffix_name(final String appl_suffix_name) {
		this.appl_suffix_name = appl_suffix_name;
	}

	public String getAppl_esign_date() {
		return appl_esign_date;
	}

	public void setAppl_esign_date(final String appl_esign_date) {
		this.appl_esign_date = appl_esign_date;
	}

	public String getAuth_rep_esign_ind() {
		return auth_rep_esign_ind;
	}

	public void setAuth_rep_esign_ind(final String auth_rep_esign_ind) {
		this.auth_rep_esign_ind = auth_rep_esign_ind;
	}

	public String getAuth_rep_fst_nam() {
		return auth_rep_fst_nam;
	}

	public void setAuth_rep_fst_nam(final String auth_rep_fst_nam) {
		this.auth_rep_fst_nam = auth_rep_fst_nam;
	}

	public String getAuth_rep_last_nam() {
		return auth_rep_last_nam;
	}

	public void setAuth_rep_last_nam(final String auth_rep_last_nam) {
		this.auth_rep_last_nam = auth_rep_last_nam;
	}

	public String getAuth_rep_mid_init() {
		return auth_rep_mid_init;
	}

	public void setAuth_rep_mid_init(final String auth_rep_mid_init) {
		this.auth_rep_mid_init = auth_rep_mid_init;
	}

	public String getAuth_rep_suffix_name() {
		return auth_rep_suffix_name;
	}

	public void setAuth_rep_suffix_name(final String auth_rep_suffix_name) {
		this.auth_rep_suffix_name = auth_rep_suffix_name;
	}

	public String getAuth_rep_esign_date() {
		return auth_rep_esign_date;
	}

	public void setAuth_rep_esign_date(final String auth_rep_esign_date) {
		this.auth_rep_esign_date = auth_rep_esign_date;
	}

	public String getAppl_hipaa_esign_ind() {
		return appl_hipaa_esign_ind;
	}

	public void setAppl_hipaa_esign_ind(final String appl_hipaa_esign_ind) {
		this.appl_hipaa_esign_ind = appl_hipaa_esign_ind;
	}

	public String getAppl_hipaa_fst_nam() {
		return appl_hipaa_fst_nam;
	}

	public void setAppl_hipaa_fst_nam(final String appl_hipaa_fst_nam) {
		this.appl_hipaa_fst_nam = appl_hipaa_fst_nam;
	}

	public String getAppl_hipaa_last_nam() {
		return appl_hipaa_last_nam;
	}

	public void setAppl_hipaa_last_nam(final String appl_hipaa_last_nam) {
		this.appl_hipaa_last_nam = appl_hipaa_last_nam;
	}

	public String getAppl_hipaa_mid_init() {
		return appl_hipaa_mid_init;
	}

	public void setAppl_hipaa_mid_init(final String appl_hipaa_mid_init) {
		this.appl_hipaa_mid_init = appl_hipaa_mid_init;
	}

	public String getAppl_hipaa_suffix_name() {
		return appl_hipaa_suffix_name;
	}

	public void setAppl_hipaa_suffix_name(final String appl_hipaa_suffix_name) {
		this.appl_hipaa_suffix_name = appl_hipaa_suffix_name;
	}

	public String getAppl_hipaa_esign_date() {
		return appl_hipaa_esign_date;
	}

	public void setAppl_hipaa_esign_date(final String appl_hipaa_esign_date) {
		this.appl_hipaa_esign_date = appl_hipaa_esign_date;
	}

	public String getAppl_citz_decl_esign_ind() {
		return appl_citz_decl_esign_ind;
	}

	public void setAppl_citz_decl_esign_ind(final String appl_citz_decl_esign_ind) {
		this.appl_citz_decl_esign_ind = appl_citz_decl_esign_ind;
	}

	public String getAppl_citz_decl_fst_nam() {
		return appl_citz_decl_fst_nam;
	}

	public void setAppl_citz_decl_fst_nam(final String appl_citz_decl_fst_nam) {
		this.appl_citz_decl_fst_nam = appl_citz_decl_fst_nam;
	}

	public String getAppl_citz_decl_last_nam() {
		return appl_citz_decl_last_nam;
	}

	public void setAppl_citz_decl_last_nam(final String appl_citz_decl_last_nam) {
		this.appl_citz_decl_last_nam = appl_citz_decl_last_nam;
	}

	public String getAppl_citz_decl_mid_init() {
		return appl_citz_decl_mid_init;
	}

	public void setAppl_citz_decl_mid_init(final String appl_citz_decl_mid_init) {
		this.appl_citz_decl_mid_init = appl_citz_decl_mid_init;
	}

	public String getAppl_citz_decl_suffix_name() {
		return appl_citz_decl_suffix_name;
	}

	public void setAppl_citz_decl_suffix_name(final String appl_citz_decl_suffix_name) {
		this.appl_citz_decl_suffix_name = appl_citz_decl_suffix_name;
	}

	public String getAppl_citz_decl_esign_date() {
		return appl_citz_decl_esign_date;
	}

	public void setAppl_citz_decl_esign_date(final String appl_citz_decl_esign_date) {
		this.appl_citz_decl_esign_date = appl_citz_decl_esign_date;
	}

	public String getAppl_voter_reg_resp() {
		return appl_voter_reg_resp;
	}

	public void setAppl_voter_reg_resp(final String appl_voter_reg_resp) {
		this.appl_voter_reg_resp = appl_voter_reg_resp;
	}

	
}
