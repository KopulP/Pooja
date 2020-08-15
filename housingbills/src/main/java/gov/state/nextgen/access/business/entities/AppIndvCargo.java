package gov.state.nextgen.access.business.entities;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "APP_INDV")
public class AppIndvCargo extends AbstractCargo{

	/**
	 *
	 */
	@EmbeddedId
	private AppIndvPrimaryKey key ;
	
	private static final long serialVersionUID = 1L;

	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.impl.APP_INDV";

	boolean isDirty = false;
	private String ecp_id;
	private String aln_sponser_sw;
	private String brth_dt;
	private String fst_nam;
	private String intn_res_resp;
	private String lang_cd;
	private String last_nam;
	private String live_arng_typ;
	private String mid_init;
	private String mig_farm_wrkr_sw;
	private String mrtl_stat_cd;
	private String preg_resp;
	private String prim_prsn_sw;
	private String rec_cplt_ind;
	private String res_wi_sw;
	private String rlvn_ind;
	private String sex_ind;
	private String ss_num_app_dt;
	private String ssn_num;
	private String us_ctzn_sw;
	private String ai_ind;
	private String asia_ind;
	private String blk_ind;
	private String hspc_ind;
	private String pac_isl_ind;
	private String wht_ind;
	private String chld_out_home_resp;// temp away from home indicator
	private String chld_trb_mbr_resp;
	private String trb_mbr_resp;
	private String non_hspc_ind;
	private String dt_leave_facty;
	private String vet_resp;// veteran Info
	private String vet_act_duty_resp;
	private String sps_deceased_vet_resp;
	private String chld_deceased_vet_resp;
	private String disable_vet_resp;
	private String job_commitment_resp;
	private String confm_brth_dt;
	private String confm_ssn_num;
	private String qualified_alien_sw;
	private String unknown_ind;

	// EDSP CP starts: fields added
	private String suffix_name;
	private String place_of_birth_cd;
	private String res_va_sw;
	private String src_app_ind;
	private String tribe_cd;
	private String alien_num;
	private String alien_status_cd;
	private String dt_entry_into_us;
	private String left_home_dt;
	private String exp_back_at_home_dt;
	private String absence_reason_cd;
	private String people_in_home_ct;
	private String aln_immigr_stat_cd;
	private String aln_stat_grnted_dt;
	private String has_spon_resp;
	private String spon_typ;
	private String spon_indv_seq_num;
	private String org_nam;

	private String left_home_reason_cd;

	private String snap_ind;
	private String tanf_ind;
	private String ma_ind;
	private String inter_oth_dsc;
	// AFC Changes

	private String lang_oth_dsc;
	private String req_interp_ind;
	private String comm_asst_sl_interp_ind;
	private String comm_asst_fl_interp_ind;
	private String comm_asst_tty_ind;
	private String comm_asst_lg_print_ind;
	private String comm_asst_email_ind;
	private String comm_asst_baille_ind;
	private String comm_asst_vedrel_ind;
	private String comm_asst_none_ind;
	private String tax_joint_file_ind;
	private String tax_dp_outside_home_ind;
	private String live_at_same_addr_ind;
	private String alias_ind;
	private String alias_fst_nam;
	private String alias_mid_init;
	private String alias_last_nam;
	private String alias_suffix_name;
	private String ssn_info_ack_ind;
	private String hspc_dsc_cd;
	private String race_oth_asian_ind;
	private String race_samoan_ind;
	private String race_filipino_ind;
	private String race_chinese_ind;
	private String race_vie_ind;
	private String race_korean_ind;
	private String race_guam_ind;
	private String race_nhpi_ind;
	private String race_oth_ind;
	private String race_japanese_ind;
	private String race_memb_fed_rec_trb_ind;
	private String tribe_name;
	private String if_out_arrangement;
	private String dateOfDiagnosis;
	private String isBreastCancerDiagnosed;
	private String blnd_dabl_ind;
	private String cc_ind;
	private String wic_ind;

	//verification services indicator
	private String us_ctzn_fed_hub_ind;
	private String ssn_vrfn_fed_hub_ind;
	private String dob_fed_hub_ind;
	private String unearned_inc_fed_hub_ind;
	private String unearned_inc_dol_ind;
	private String earned_inc_dol_ind;
	private String earned_inc_wrk_num_ind;
	private String tax_filing_status;
	private String bst_cncr_ecp_id;
	private String race_persian_ind;
	private String race_eastasian_ind;
	private String race_unknown_ind;
	private String citizenVerifyInd="N";
	private String looping_ind;
	private String vld_immgrtn_sts;
	private String chg_dt;
	private String wic_clnc_cnty;
	private String wic_clnc_cd;
	private String tax_flr_otsd_ind;
	private String is_wic_clnc_info_new;
	
	
	public String getIs_wic_clnc_info_new() {
		return is_wic_clnc_info_new;
	}

	public void setIs_wic_clnc_info_new(String is_wic_clnc_info_new) {
		this.is_wic_clnc_info_new = is_wic_clnc_info_new;
	}

	public String getTax_flr_otsd_ind() {
		return tax_flr_otsd_ind;
	}

	public void setTax_flr_otsd_ind(String tax_flr_otsd_ind) {
		this.tax_flr_otsd_ind = tax_flr_otsd_ind;
	}

	public String getWic_clnc_cnty() {
		return wic_clnc_cnty;
	}

	public void setWic_clnc_cnty(String wic_clnc_cnty) {
		this.wic_clnc_cnty = wic_clnc_cnty;
	}

	public String getWic_clnc_cd() {
		return wic_clnc_cd;
	}

	public void setWic_clnc_cd(String wic_clnc_cd) {
		this.wic_clnc_cd = wic_clnc_cd;
	}

	/**
     * @return the chg_dt
     */
    public String getChg_dt() {
        return chg_dt;
    }

    /**
     * @param chg_dt the chg_dt to set
     */
    public void setChg_dt(String chg_dt) {
        this.chg_dt = chg_dt;
    }
	

	public String getRace_persian_ind() {
		return race_persian_ind;
	}

	public void setRace_persian_ind(String race_persian_ind) {
		this.race_persian_ind = race_persian_ind;
	}

	public String getRace_eastasian_ind() {
		return race_eastasian_ind;
	}

	public void setRace_eastasian_ind(String race_eastasian_ind) {
		this.race_eastasian_ind = race_eastasian_ind;
	}

	public String getRace_unknown_ind() {
		return race_unknown_ind;
	}

	public void setRace_unknown_ind(String race_unknown_ind) {
		this.race_unknown_ind = race_unknown_ind;
	}

	/**
	 * @return the ecp_id
	 */
	public String getEcp_id() {
		return ecp_id;
	}

	/**
	 * @param ecp_id the ecp_id to set
	 */
	public void setEcp_id(final String ecp_id) {
		this.ecp_id = ecp_id;
	}

	/**
	 * @return the us_ctzn_fed_hub_ind
	 */
	public String getUs_ctzn_fed_hub_ind() {
		return us_ctzn_fed_hub_ind;
	}

	/**
	 * @param us_ctzn_fed_hub_ind the us_ctzn_fed_hub_ind to set
	 */
	public void setUs_ctzn_fed_hub_ind(final String us_ctzn_fed_hub_ind) {
		this.us_ctzn_fed_hub_ind = us_ctzn_fed_hub_ind;
	}

	/**
	 * @return the ssn_vrfn_fed_hub_ind
	 */
	public String getSsn_vrfn_fed_hub_ind() {
		return ssn_vrfn_fed_hub_ind;
	}

	/**
	 * @param ssn_vrfn_fed_hub_ind the ssn_vrfn_fed_hub_ind to set
	 */
	public void setSsn_vrfn_fed_hub_ind(final String ssn_vrfn_fed_hub_ind) {
		this.ssn_vrfn_fed_hub_ind = ssn_vrfn_fed_hub_ind;
	}

	/**
	 * @return the cc_ind
	 */
	public String getCc_ind() {
		return cc_ind;
	}

	/**
	 * @param cc_ind the cc_ind to set
	 */
	public void setCc_ind(final String cc_ind) {
		this.cc_ind = cc_ind;
	}

	/**
	 * @return the wic_ind
	 */
	public String getWic_ind() {
		return wic_ind;
	}

	/**
	 * @param wic_ind the wic_ind to set
	 */
	public void setWic_ind(final String wic_ind) {
		this.wic_ind = wic_ind;
	}

	public String getDateOfDiagnosis() {
		return dateOfDiagnosis;
	}

	public void setDateOfDiagnosis(final String dateOfDiagnosis) {
		this.dateOfDiagnosis = dateOfDiagnosis;
	}

	public String getIsBreastCancerDiagnosed() {
		return isBreastCancerDiagnosed;
	}

	public void setIsBreastCancerDiagnosed(final String isBreastCancerDiagnosed) {
		this.isBreastCancerDiagnosed = isBreastCancerDiagnosed;
	}

	/**
	 * @return the comm_asst_baille_ind
	 */
	public String getComm_asst_baille_ind() {
		return comm_asst_baille_ind;
	}

	/**
	 * @param comm_asst_baille_ind
	 *            the comm_asst_baille_ind to set
	 */
	public void setComm_asst_baille_ind(final String comm_asst_baille_ind) {
		this.comm_asst_baille_ind = comm_asst_baille_ind;
	}

	/**
	 * @return the comm_asst_vedrel_ind
	 */
	public String getComm_asst_vedrel_ind() {
		return comm_asst_vedrel_ind;
	}

	/**
	 * @return the inter_oth_dsc
	 */
	public String getInter_oth_dsc() {
		return inter_oth_dsc;
	}

	/**
	 * @param inter_oth_dsc
	 *            the inter_oth_dsc to set
	 */
	public void setInter_oth_dsc(final String inter_oth_dsc) {
		this.inter_oth_dsc = inter_oth_dsc;
	}

	/**
	 * @param comm_asst_vedrel_ind
	 *            the comm_asst_vedrel_ind to set
	 */
	public void setComm_asst_vedrel_ind(final String comm_asst_vedrel_ind) {
		this.comm_asst_vedrel_ind = comm_asst_vedrel_ind;
	}

	public String getIf_out_arrangement() {
		return if_out_arrangement;
	}

	public void setIf_out_arrangement(final String if_out_arrangement) {
		this.if_out_arrangement = if_out_arrangement;
	}

	public String getRace_oth_asian_ind() {
		return race_oth_asian_ind;
	}

	public void setRace_oth_asian_ind(final String race_oth_asian_ind) {
		this.race_oth_asian_ind = race_oth_asian_ind;
	}

	public String getRace_samoan_ind() {
		return race_samoan_ind;
	}

	public void setRace_samoan_ind(final String race_samoan_ind) {
		this.race_samoan_ind = race_samoan_ind;
	}

	public String getRace_filipino_ind() {
		return race_filipino_ind;
	}

	public void setRace_filipino_ind(final String race_filipino_ind) {
		this.race_filipino_ind = race_filipino_ind;
	}

	public String getRace_chinese_ind() {
		return race_chinese_ind;
	}

	public void setRace_chinese_ind(final String race_chinese_ind) {
		this.race_chinese_ind = race_chinese_ind;
	}

	public String getRace_vie_ind() {
		return race_vie_ind;
	}

	public void setRace_vie_ind(final String race_vie_ind) {
		this.race_vie_ind = race_vie_ind;
	}

	public String getRace_korean_ind() {
		return race_korean_ind;
	}

	public void setRace_korean_ind(final String race_korean_ind) {
		this.race_korean_ind = race_korean_ind;
	}

	public String getRace_guam_ind() {
		return race_guam_ind;
	}

	public void setRace_guam_ind(final String race_guam_ind) {
		this.race_guam_ind = race_guam_ind;
	}

	public String getRace_nhpi_ind() {
		return race_nhpi_ind;
	}

	public void setRace_nhpi_ind(final String race_nhpi_ind) {
		this.race_nhpi_ind = race_nhpi_ind;
	}

	public String getRace_oth_ind() {
		return race_oth_ind;
	}

	public void setRace_oth_ind(final String race_oth_ind) {
		this.race_oth_ind = race_oth_ind;
	}

	public String getRace_japanese_ind() {
		return race_japanese_ind;
	}

	public void setRace_japanese_ind(final String race_japanese_ind) {
		this.race_japanese_ind = race_japanese_ind;
	}

	public String getRace_memb_fed_rec_trb_ind() {
		return race_memb_fed_rec_trb_ind;
	}

	public void setRace_memb_fed_rec_trb_ind(final String race_memb_fed_rec_trb_ind) {
		this.race_memb_fed_rec_trb_ind = race_memb_fed_rec_trb_ind;
	}

	public String getTribe_name() {
		return tribe_name;
	}

	public void setTribe_name(final String tribe_name) {
		this.tribe_name = tribe_name;
	}

	/* Fields added for People In your Home (Screen 2)- Start */
	private String res_ga_ind;

	public String getRes_ga_ind() {
		return res_ga_ind;
	}

	public String getHspc_dsc_cd() {
		return hspc_dsc_cd;
	}

	public void setHspc_dsc_cd(final String hspc_dsc_cd) {
		this.hspc_dsc_cd = hspc_dsc_cd;
	}

	public void setRes_ga_ind(final String res_ga_ind) {
		this.res_ga_ind = res_ga_ind;
	}

	public String getDisabled_resp() {
		return disabled_resp;
	}

	public String getAlias_ind() {
		return alias_ind;
	}

	public void setAlias_ind(final String alias_ind) {
		this.alias_ind = alias_ind;
	}

	public String getSsn_info_ack_ind() {
		return ssn_info_ack_ind;
	}

	public void setSsn_info_ack_ind(final String ssn_info_ack_ind) {
		this.ssn_info_ack_ind = ssn_info_ack_ind;
	}

	public String getAlias_fst_nam() {
		return alias_fst_nam;
	}

	public void setAlias_fst_nam(final String alias_fst_nam) {
		this.alias_fst_nam = alias_fst_nam;
	}

	public String getAlias_mid_init() {
		return alias_mid_init;
	}

	public void setAlias_mid_init(final String alias_mid_init) {
		this.alias_mid_init = alias_mid_init;
	}

	public String getAlias_last_nam() {
		return alias_last_nam;
	}

	public void setAlias_last_nam(final String alias_last_nam) {
		this.alias_last_nam = alias_last_nam;
	}

	public String getAlias_suffix_name() {
		return alias_suffix_name;
	}

	public void setAlias_suffix_name(final String alias_suffix_name) {
		this.alias_suffix_name = alias_suffix_name;
	}

	public void setDisabled_resp(final String disabled_resp) {
		this.disabled_resp = disabled_resp;
	}

	public String getAlien_doc_cd() {
		return alien_doc_cd;
	}

	public void setAlien_doc_cd(final String alien_doc_cd) {
		this.alien_doc_cd = alien_doc_cd;
	}

	public String getChld_pa_act_duty_resp() {
		return chld_pa_act_duty_resp;
	}

	public void setChld_pa_act_duty_resp(final String chld_pa_act_duty_resp) {
		this.chld_pa_act_duty_resp = chld_pa_act_duty_resp;
	}

	public String getLiving_arrangement_cd() {
		return living_arrangement_cd;
	}

	public void setLiving_arrangement_cd(final String living_arrangement_cd) {
		this.living_arrangement_cd = living_arrangement_cd;
	}

	private String disabled_resp;
	private String alien_doc_cd;
	private String chld_pa_act_duty_resp;
	private String living_arrangement_cd;

	public String getLang_oth_dsc() {
		return lang_oth_dsc;
	}

	public void setLang_oth_dsc(final String lang_oth_dsc) {
		this.lang_oth_dsc = lang_oth_dsc;
	}

	public String getReq_interp_ind() {
		return req_interp_ind;
	}

	public void setReq_interp_ind(final String req_interp_ind) {
		this.req_interp_ind = req_interp_ind;
	}

	public String getComm_asst_sl_interp_ind() {
		return comm_asst_sl_interp_ind;
	}

	public void setComm_asst_sl_interp_ind(final String comm_asst_sl_interp_ind) {
		this.comm_asst_sl_interp_ind = comm_asst_sl_interp_ind;
	}

	public String getComm_asst_fl_interp_ind() {
		return comm_asst_fl_interp_ind;
	}

	public void setComm_asst_fl_interp_ind(final String comm_asst_fl_interp_ind) {
		this.comm_asst_fl_interp_ind = comm_asst_fl_interp_ind;
	}

	public String getComm_asst_tty_ind() {
		return comm_asst_tty_ind;
	}

	public void setComm_asst_tty_ind(final String comm_asst_tty_ind) {
		this.comm_asst_tty_ind = comm_asst_tty_ind;
	}

	public String getComm_asst_lg_print_ind() {
		return comm_asst_lg_print_ind;
	}

	public void setComm_asst_lg_print_ind(final String comm_asst_lg_print_ind) {
		this.comm_asst_lg_print_ind = comm_asst_lg_print_ind;
	}

	public String getComm_asst_email_ind() {
		return comm_asst_email_ind;
	}

	public void setComm_asst_email_ind(final String comm_asst_email_ind) {
		this.comm_asst_email_ind = comm_asst_email_ind;
	}

	public String getComm_asst_none_ind() {
		return comm_asst_none_ind;
	}

	public void setComm_asst_none_ind(final String comm_asst_none_ind) {
		this.comm_asst_none_ind = comm_asst_none_ind;
	}

	public String getTax_joint_file_ind() {
		return tax_joint_file_ind;
	}

	public void setTax_joint_file_ind(final String tax_joint_file_ind) {
		this.tax_joint_file_ind = tax_joint_file_ind;
	}

	public String getTax_dp_outside_home_ind() {
		return tax_dp_outside_home_ind;
	}

	public void setTax_dp_outside_home_ind(final String tax_dp_outside_home_ind) {
		this.tax_dp_outside_home_ind = tax_dp_outside_home_ind;
	}

	public String getLive_at_same_addr_ind() {
		return live_at_same_addr_ind;
	}

	public void setLive_at_same_addr_ind(final String live_at_same_addr_ind) {
		this.live_at_same_addr_ind = live_at_same_addr_ind;
	}

	// AFC Changes End

	public String getSnap_ind() {
		return snap_ind;
	}

	public void setSnap_ind(final String snap_ind) {
		this.snap_ind = snap_ind;
	}

	public String getTanf_ind() {
		return tanf_ind;
	}

	public void setTanf_ind(final String tanf_ind) {
		this.tanf_ind = tanf_ind;
	}

	public String getMa_ind() {
		return ma_ind;
	}

	public void setMa_ind(final String ma_ind) {
		this.ma_ind = ma_ind;
	}

	public String getLeft_home_reason_cd() {
		return left_home_reason_cd;
	}

	public void setLeft_home_reason_cd(final String left_home_reason_cd) {
		this.left_home_reason_cd = left_home_reason_cd;
	}

	public String getHas_spon_resp() {
		return has_spon_resp;
	}

	public void setHas_spon_resp(final String has_spon_resp) {
		this.has_spon_resp = has_spon_resp;
	}

	public String getSpon_typ() {
		return spon_typ;
	}

	public void setSpon_typ(final String spon_typ) {
		this.spon_typ = spon_typ;
	}

	public String getSpon_indv_seq_num() {
		return spon_indv_seq_num;
	}

	public void setSpon_indv_seq_num(final String spon_indv_seq_num) {
		this.spon_indv_seq_num = spon_indv_seq_num;
	}

	public String getOrg_nam() {
		return org_nam;
	}

	public void setOrg_nam(final String org_nam) {
		this.org_nam = org_nam;
	}

	/**
	 * returns the aln_stat_grnted_dt value.
	 */
	public String getAln_stat_grnted_dt() {
		return aln_stat_grnted_dt;
	}

	/**
	 * returns the aln_immigr_stat_cd value.
	 */
	public String getAln_immigr_stat_cd() {
		return aln_immigr_stat_cd;
	}

	/**
	 * sets the aln_immigr_stat_cd value.
	 */
	public void setAln_immigr_stat_cd(final String aln_immigr_stat_cd) {
		this.aln_immigr_stat_cd = aln_immigr_stat_cd;
	}

	/**
	 * sets the aln_stat_grnted_dt value.
	 */
	public void setAln_stat_grnted_dt(final String aln_stat_grnted_dt) {
		this.aln_stat_grnted_dt = aln_stat_grnted_dt;
	}

	// EDSP CP ends: fields added

	

	/**
	 * returns the aln_sponser_sw value.
	 */
	public String getAln_sponser_sw() {
		return aln_sponser_sw;
	}

	/**
	 * returns the brth_dt value.
	 */
	public String getBrth_dt() {
		return brth_dt;
	}

	/**
	 * returns the fst_nam value.
	 */
	public String getFst_nam() {
		return fst_nam;
	}

	/**
	 * returns the intn_res_resp value.
	 */
	public String getIntn_res_resp() {
		return intn_res_resp;
	}

	/**
	 * returns the lang_cd value.
	 */
	public String getLang_cd() {
		return lang_cd;
	}

	/**
	 * returns the last_nam value.
	 */
	public String getLast_nam() {
		return last_nam;
	}

	/**
	 * returns the live_arng_typ value.
	 */
	public String getLive_arng_typ() {
		return live_arng_typ;
	}

	/**
	 * returns the mid_init value.
	 */
	public String getMid_init() {
		return mid_init;
	}

	/**
	 * returns the mig_farm_wrkr_sw value.
	 */
	public String getMig_farm_wrkr_sw() {
		return mig_farm_wrkr_sw;
	}

	/**
	 * returns the mrtl_stat_cd value.
	 */
	public String getMrtl_stat_cd() {
		return mrtl_stat_cd;
	}

	/**
	 * returns the preg_resp value.
	 */
	public String getPreg_resp() {
		return preg_resp;
	}

	/**
	 * returns the prim_prsn_sw value.
	 */
	public String getPrim_prsn_sw() {
		return prim_prsn_sw;
	}

	/**
	 * returns the rec_cplt_ind value.
	 */
	public String getRec_cplt_ind() {
		return rec_cplt_ind;
	}

	/**
	 * returns the res_wi_sw value.
	 */
	public String getRes_wi_sw() {
		return res_wi_sw;
	}

	/**
	 * returns the rlvn_ind value.
	 */
	public String getRlvn_ind() {
		return rlvn_ind;
	}

	/**
	 * returns the sex_ind value.
	 */
	public String getSex_ind() {
		return sex_ind;
	}

	/**
	 * returns the ss_num_app_dt value.
	 */
	public String getSs_num_app_dt() {
		return ss_num_app_dt;
	}

	/**
	 * returns the ssn_num value.
	 */
	public String getSsn_num() {
		return ssn_num;
	}

	/**
	 * returns the us_ctzn_sw value.
	 */
	public String getUs_ctzn_sw() {
		return us_ctzn_sw;
	}

	/**
	 * returns the ai_ind value.
	 */
	public String getAi_ind() {
		return ai_ind;
	}

	/**
	 * returns the asia_ind value.
	 */
	public String getAsia_ind() {
		return asia_ind;
	}

	/**
	 * returns the blk_ind value.
	 */
	public String getBlk_ind() {
		return blk_ind;
	}

	/**
	 * returns the hspc_ind value.
	 */
	public String getHspc_ind() {
		return hspc_ind;
	}

	/**
	 * returns the pac_isl_ind value.
	 */
	public String getPac_isl_ind() {
		return pac_isl_ind;
	}

	/**
	 * returns the wht_ind value.
	 */
	public String getWht_ind() {
		return wht_ind;
	}

	/**
	 * returns the chld_out_home_resp value.
	 */
	public String getChld_out_home_resp() {
		return chld_out_home_resp;
	}

	/**
	 * returns the chld_trb_mbr_resp value.
	 */
	public String getChld_trb_mbr_resp() {
		return chld_trb_mbr_resp;
	}

	/**
	 * returns the trb_mbr_resp value.
	 */
	public String getTrb_mbr_resp() {
		return trb_mbr_resp;
	}

	/**
	 * returns the non_hspc_ind value.
	 */
	public String getNon_hspc_ind() {
		return non_hspc_ind;
	}

	/**
	 * returns the dt_leave_facty value.
	 */
	public String getDt_leave_facty() {
		return dt_leave_facty;
	}

	/**
	 * returns the vet_resp value.
	 */
	public String getVet_resp() {
		return vet_resp;
	}

	/**
	 * returns the vet_act_duty_resp value.
	 */
	public String getVet_act_duty_resp() {
		return vet_act_duty_resp;
	}

	/**
	 * returns the sps_deceased_vet_resp value.
	 */
	public String getSps_deceased_vet_resp() {
		return sps_deceased_vet_resp;
	}

	/**
	 * returns the chld_deceased_vet_resp value.
	 */
	public String getChld_deceased_vet_resp() {
		return chld_deceased_vet_resp;
	}

	/**
	 * returns the disable_vet_resp value.
	 */
	public String getDisable_vet_resp() {
		return disable_vet_resp;
	}

	/**
	 * @return the job_commitment_resp
	 */
	public String getJob_commitment_resp() {
		return job_commitment_resp;
	}



	/**
	 * sets the aln_sponser_sw value.
	 */
	public void setAln_sponser_sw(final String aln_sponser_sw) {
		this.aln_sponser_sw = aln_sponser_sw;
	}

	/**
	 * sets the brth_dt value.
	 */
	public void setBrth_dt(final String brth_dt) {
		this.brth_dt = brth_dt;
	}

	/**
	 * sets the fst_nam value.
	 */
	public void setFst_nam(final String fst_nam) {
		this.fst_nam = fst_nam;
	}

	/**
	 * sets the intn_res_resp value.
	 */
	public void setIntn_res_resp(final String intn_res_resp) {
		this.intn_res_resp = intn_res_resp;
	}

	/**
	 * sets the lang_cd value.
	 */
	public void setLang_cd(final String lang_cd) {
		this.lang_cd = lang_cd;
	}

	/**
	 * sets the last_nam value.
	 */
	public void setLast_nam(final String last_nam) {
		this.last_nam = last_nam;
	}

	/**
	 * sets the live_arng_typ value.
	 */
	public void setLive_arng_typ(final String live_arng_typ) {
		this.live_arng_typ = live_arng_typ;
	}

	/**
	 * sets the mid_init value.
	 */
	public void setMid_init(final String mid_init) {
		this.mid_init = mid_init;
	}

	/**
	 * sets the mig_farm_wrkr_sw value.
	 */
	public void setMig_farm_wrkr_sw(final String mig_farm_wrkr_sw) {
		this.mig_farm_wrkr_sw = mig_farm_wrkr_sw;
	}

	/**
	 * sets the mrtl_stat_cd value.
	 */
	public void setMrtl_stat_cd(final String mrtl_stat_cd) {
		this.mrtl_stat_cd = mrtl_stat_cd;
	}

	/**
	 * sets the preg_resp value.
	 */
	public void setPreg_resp(final String preg_resp) {
		this.preg_resp = preg_resp;
	}

	/**
	 * sets the prim_prsn_sw value.
	 */
	public void setPrim_prsn_sw(final String prim_prsn_sw) {
		this.prim_prsn_sw = prim_prsn_sw;
	}

	/**
	 * sets the rec_cplt_ind value.
	 */
	public void setRec_cplt_ind(final String rec_cplt_ind) {
		this.rec_cplt_ind = rec_cplt_ind;
	}

	/**
	 * sets the res_wi_sw value.
	 */
	public void setRes_wi_sw(final String res_wi_sw) {
		this.res_wi_sw = res_wi_sw;
	}

	/**
	 * sets the rlvn_ind value.
	 */
	public void setRlvn_ind(final String rlvn_ind) {
		this.rlvn_ind = rlvn_ind;
	}

	/**
	 * sets the sex_ind value.
	 */
	public void setSex_ind(final String sex_ind) {
		this.sex_ind = sex_ind;
	}

	/**
	 * sets the ss_num_app_dt value.
	 */
	public void setSs_num_app_dt(final String ss_num_app_dt) {
		this.ss_num_app_dt = ss_num_app_dt;
	}

	/**
	 * sets the ssn_num value.
	 */
	public void setSsn_num(final String ssn_num) {
		this.ssn_num = ssn_num;
	}

	/**
	 * sets the us_ctzn_sw value.
	 */
	public void setUs_ctzn_sw(final String us_ctzn_sw) {
		this.us_ctzn_sw = us_ctzn_sw;
	}

	/**
	 * sets the ai_ind value.
	 */
	public void setAi_ind(final String ai_ind) {
		this.ai_ind = ai_ind;
	}

	/**
	 * sets the asia_ind value.
	 */
	public void setAsia_ind(final String asia_ind) {
		this.asia_ind = asia_ind;
	}

	/**
	 * sets the blk_ind value.
	 */
	public void setBlk_ind(final String blk_ind) {
		this.blk_ind = blk_ind;
	}

	/**
	 * sets the hspc_ind value.
	 */
	public void setHspc_ind(final String hspc_ind) {
		this.hspc_ind = hspc_ind;
	}

	/**
	 * sets the pac_isl_ind value.
	 */
	public void setPac_isl_ind(final String pac_isl_ind) {
		this.pac_isl_ind = pac_isl_ind;
	}

	/**
	 * sets the wht_ind value.
	 */
	public void setWht_ind(final String wht_ind) {
		this.wht_ind = wht_ind;
	}

	/**
	 * sets the chld_out_home_resp value.
	 */
	public void setChld_out_home_resp(final String chld_out_home_resp) {
		this.chld_out_home_resp = chld_out_home_resp;
	}

	/**
	 * sets the chld_trb_mbr_resp value.
	 */
	public void setChld_trb_mbr_resp(final String chld_trb_mbr_resp) {
		this.chld_trb_mbr_resp = chld_trb_mbr_resp;
	}

	/**
	 * sets the trb_mbr_resp value.
	 */
	public void setTrb_mbr_resp(final String trb_mbr_resp) {
		this.trb_mbr_resp = trb_mbr_resp;
	}

	/**
	 * sets the non_hspc_ind value.
	 */
	public void setNon_hspc_ind(final String non_hspc_ind) {
		this.non_hspc_ind = non_hspc_ind;
	}

	/**
	 * sets the dt_leave_facty value.
	 */
	public void setDt_leave_facty(final String dt_leave_facty) {
		this.dt_leave_facty = dt_leave_facty;
	}

	/**
	 * sets the vet_resp value.
	 */
	public void setVet_resp(final String vet_resp) {
		this.vet_resp = vet_resp;
	}

	/**
	 * sets the vet_act_duty_resp value.
	 */
	public void setVet_act_duty_resp(final String vet_act_duty_resp) {
		this.vet_act_duty_resp = vet_act_duty_resp;
	}

	/**
	 * sets the sps_deceased_vet_resp value.
	 */
	public void setSps_deceased_vet_resp(final String sps_deceased_vet_resp) {
		this.sps_deceased_vet_resp = sps_deceased_vet_resp;
	}

	/**
	 * sets the chld_deceased_vet_resp value.
	 */
	public void setChld_deceased_vet_resp(final String chld_deceased_vet_resp) {
		this.chld_deceased_vet_resp = chld_deceased_vet_resp;
	}

	/**
	 * sets the disable_vet_resp value.
	 */
	public void setDisable_vet_resp(final String disable_vet_resp) {
		this.disable_vet_resp = disable_vet_resp;
	}

	/**
	 * @param job_commitment_resp
	 *            the job_commitment_resp to set
	 */
	public void setJob_commitment_resp(final String job_commitment_resp) {
		this.job_commitment_resp = job_commitment_resp;
	}

	/**
	 * @return the confm_brth_dt
	 */
	public String getConfm_brth_dt() {
		return confm_brth_dt;
	}

	/**
	 * @param confm_brth_dt
	 *            the confm_brth_dt to set
	 */
	public void setConfm_brth_dt(final String confm_brth_dt) {
		this.confm_brth_dt = confm_brth_dt;
	}

	/**
	 * @return the confm_ssn_num
	 */
	public String getConfm_ssn_num() {
		return confm_ssn_num;
	}

	/**
	 * @param confm_ssn_num
	 *            the confm_ssn_num to set
	 */
	public void setConfm_ssn_num(final String confm_ssn_num) {
		this.confm_ssn_num = confm_ssn_num;
	}

	/**
	 * @return the qualified_alien_sw
	 */
	public String getQualified_alien_sw() {
		return qualified_alien_sw;
	}

	/**
	 * @param qualified_alien_sw
	 *            the qualified_alien_sw to set
	 */
	public void setQualified_alien_sw(final String qualified_alien_sw) {
		this.qualified_alien_sw = qualified_alien_sw;
	}

	/**
	 * @return the unknown_ind
	 */
	public String getUnknown_ind() {
		return unknown_ind;
	}

	/**
	 * @param unknown_ind
	 *            the unknown_ind to set
	 */
	public void setUnknown_ind(final String unknown_ind) {
		this.unknown_ind = unknown_ind;
	}

	// EDSP CP starts: methods added
	/**
	 * @return the place_of_birth_cd
	 */
	public String getPlace_of_birth_cd() {
		return place_of_birth_cd;
	}

	/**
	 * @param place_of_birth_cd
	 *            the place_of_birth_cd to set
	 */
	public void setPlace_of_birth_cd(final String place_of_birth_cd) {
		this.place_of_birth_cd = place_of_birth_cd;
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

	/**
	 * @return the src_app_ind
	 */
	public String getSrc_app_ind() {
		return src_app_ind;
	}

	/**
	 * @param src_app_ind
	 *            the src_app_ind to set
	 */
	public void setSrc_app_ind(final String src_app_ind) {
		this.src_app_ind = src_app_ind;
	}

	/**
	 * @return the tribe_cd
	 */
	public String getTribe_cd() {
		return tribe_cd;
	}

	/**
	 * @param tribe_cd
	 *            the tribe_cd to set
	 */
	public void setTribe_cd(final String tribe_cd) {
		this.tribe_cd = tribe_cd;
	}

	/**
	 * @return the alien_num
	 */
	public String getAlien_num() {
		return alien_num;
	}

	/**
	 * @param alien_num
	 *            the alien_num to set
	 */
	public void setAlien_num(final String alien_num) {
		this.alien_num = alien_num;
	}

	/**
	 * @return the alien_status_cd
	 */
	public String getAlien_status_cd() {
		return alien_status_cd;
	}

	/**
	 * @param alien_status_cd
	 *            the alien_status_cd to set
	 */
	public void setAlien_status_cd(final String alien_status_cd) {
		this.alien_status_cd = alien_status_cd;
	}

	/**
	 * @return the dt_entry_into_us
	 */
	public String getDt_entry_into_us() {
		return dt_entry_into_us;
	}

	/**
	 * @param dt_entry_into_us
	 *            the dt_entry_into_us to set
	 */
	public void setDt_entry_into_us(final String dt_entry_into_us) {
		this.dt_entry_into_us = dt_entry_into_us;
	}

	/**
	 * @return the left_home_dt
	 */
	public String getLeft_home_dt() {
		return left_home_dt;
	}

	/**
	 * @param left_home_dt
	 *            the left_home_dt to set
	 */
	public void setLeft_home_dt(final String left_home_dt) {
		this.left_home_dt = left_home_dt;
	}

	/**
	 * @return the exp_back_at_home_dt
	 */
	public String getExp_back_at_home_dt() {
		return exp_back_at_home_dt;
	}

	/**
	 * @param exp_back_at_home_dt
	 *            the exp_back_at_home_dt to set
	 */
	public void setExp_back_at_home_dt(final String exp_back_at_home_dt) {
		this.exp_back_at_home_dt = exp_back_at_home_dt;
	}

	/**
	 * @return the absence_reason_cd
	 */
	public String getAbsence_reason_cd() {
		return absence_reason_cd;
	}

	/**
	 * @param absence_reason_cd
	 *            the absence_reason_cd to set
	 */
	public void setAbsence_reason_cd(final String absence_reason_cd) {
		this.absence_reason_cd = absence_reason_cd;
	}

	/**
	 * @return the people_in_home_ct
	 */
	public String getPeople_in_home_ct() {
		return people_in_home_ct;
	}

	/**
	 * @param people_in_home_ct
	 *            the people_in_home_ct to set
	 */
	public void setPeople_in_home_ct(final String people_in_home_ct) {
		this.people_in_home_ct = people_in_home_ct;
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

	// EDSP CP ends: methods added

	/**
	 * returns the PrimaryKey object.
	 */
	@Override
	public IPrimaryKey getPrimaryKey() {
		
				return key;
	}

	/**
	 * returns the PACKAGE name.
	 */
	public String getPackage() {
		return PACKAGE;
	}

	/**
	 * @return the blnd_dabl_ind
	 */
	public String getBlnd_dabl_ind() {
		return blnd_dabl_ind;
	}

	/**
	 * @param blnd_dabl_ind the blnd_dabl_ind to set
	 */
	public void setBlnd_dabl_ind(final String blnd_dabl_ind) {
		this.blnd_dabl_ind = blnd_dabl_ind;
	}

	/**
	 * @return the dob_fed_hub_ind
	 */
	public String getDob_fed_hub_ind() {
		return dob_fed_hub_ind;
	}

	/**
	 * @param dob_fed_hub_ind the dob_fed_hub_ind to set
	 */
	public void setDob_fed_hub_ind(final String dob_fed_hub_ind) {
		this.dob_fed_hub_ind = dob_fed_hub_ind;
	}

	/**
	 * @return the unearned_inc_fed_hub_ind
	 */
	public String getUnearned_inc_fed_hub_ind() {
		return unearned_inc_fed_hub_ind;
	}

	/**
	 * @param unearned_inc_fed_hub_ind the unearned_inc_fed_hub_ind to set
	 */
	public void setUnearned_inc_fed_hub_ind(final String unearned_inc_fed_hub_ind) {
		this.unearned_inc_fed_hub_ind = unearned_inc_fed_hub_ind;
	}

	/**
	 * @return the unearned_inc_dol_ind
	 */
	public String getUnearned_inc_dol_ind() {
		return unearned_inc_dol_ind;
	}

	/**
	 * @param unearned_inc_dol_ind the unearned_inc_dol_ind to set
	 */
	public void setUnearned_inc_dol_ind(final String unearned_inc_dol_ind) {
		this.unearned_inc_dol_ind = unearned_inc_dol_ind;
	}

	/**
	 * @return the earned_inc_dol_ind
	 */
	public String getEarned_inc_dol_ind() {
		return earned_inc_dol_ind;
	}

	/**
	 * @param earned_inc_dol_ind the earned_inc_dol_ind to set
	 */
	public void setEarned_inc_dol_ind(final String earned_inc_dol_ind) {
		this.earned_inc_dol_ind = earned_inc_dol_ind;
	}

	/**
	 * @return the earned_inc_wrk_num_ind
	 */
	public String getEarned_inc_wrk_num_ind() {
		return earned_inc_wrk_num_ind;
	}

	/**
	 * @param earned_inc_wrk_num_ind the earned_inc_wrk_num_ind to set
	 */
	public void setEarned_inc_wrk_num_ind(final String earned_inc_wrk_num_ind) {
		this.earned_inc_wrk_num_ind = earned_inc_wrk_num_ind;
	}

	/**
	 * @return the tax_filing_status
	 */
	public String getTax_filing_status() {
		return tax_filing_status;
	}

	/**
	 * @param tax_filing_status the tax_filing_status to set
	 */
	public void setTax_filing_status(final String tax_filing_status) {
		this.tax_filing_status = tax_filing_status;
	}

	
	/**
	 * @return the citizenVerifyInd
	 */
	public String getCitizenVerifyInd() {
		return citizenVerifyInd;
	}

	/**
	 * @param citizenVerifyInd the citizenVerifyInd to set
	 */
	public void setCitizenVerifyInd(String citizenVerifyInd) {
		this.citizenVerifyInd = citizenVerifyInd;
	}
	
	
	
	/**
	 * @return the looping_ind
	 */
	public String getLooping_ind() {
		return looping_ind;
	}

	/**
	 * @param looping_ind the looping_ind to set
	 */
	public void setLooping_ind(String looping_ind) {
		this.looping_ind = looping_ind;
	}

	public String getVld_immgrtn_sts() {
		return vld_immgrtn_sts;
	}

	public void setVld_immgrtn_sts(String vld_immgrtn_sts) {
		this.vld_immgrtn_sts = vld_immgrtn_sts;
	}

	/**
	 * returns the string value of cargo.
	 */
	@Override
	public String inspectCargo() {
		return new StringBuilder().append("APP_INDV: ").append("ecp_id=").append(ecp_id)
				.append("aln_sponser_sw=").append(aln_sponser_sw).append("brth_dt=").append(brth_dt).append("fst_nam=")
				.append(fst_nam).append("intn_res_resp=").append(intn_res_resp).append("lang_cd=").append(lang_cd).append("last_nam=")
				.append(last_nam).append("live_arng_typ=").append(live_arng_typ).append("mid_init=").append(mid_init).append("mig_farm_wrkr_sw=")
				.append(mig_farm_wrkr_sw).append("mrtl_stat_cd=").append(mrtl_stat_cd).append("preg_resp=").append(preg_resp).append("prim_prsn_sw=")
				.append(prim_prsn_sw).append("rec_cplt_ind=").append(rec_cplt_ind).append("res_wi_sw=").append(res_wi_sw).append("rlvn_ind=")
				.append(rlvn_ind).append("sex_ind=").append(sex_ind).append("ss_num_app_dt=").append(ss_num_app_dt).append("ssn_num=")
				.append(ssn_num).append("us_ctzn_sw=").append(us_ctzn_sw).append("ai_ind=").append(ai_ind).append("asia_ind=").append(asia_ind)
				.append("blk_ind=").append(blk_ind).append("hspc_ind=").append(hspc_ind).append("pac_isl_ind=").append(pac_isl_ind)
				.append("wht_ind=").append(wht_ind).append("chld_out_home_resp=").append(chld_out_home_resp).append("chld_trb_mbr_resp=")
				.append(chld_trb_mbr_resp).append("trb_mbr_resp=").append(trb_mbr_resp).append("non_hspc_ind=").append(non_hspc_ind)
				.append("dt_leave_facty=").append(dt_leave_facty).append("vet_resp=").append(vet_resp).append("vet_act_duty_resp=")
				.append(vet_act_duty_resp).append("sps_deceased_vet_resp=").append(sps_deceased_vet_resp).append("chld_deceased_vet_resp=")
				.append(chld_deceased_vet_resp).append("disable_vet_resp=").append(disable_vet_resp).append("job_commitment_resp=")
				.append(job_commitment_resp).append("confm_brth_dt = ").append(confm_brth_dt).append("place_of_birth_cd=").append(place_of_birth_cd)
				.append("res_va_sw=").append("res_va_sw").append("tribe_cd=").append(tribe_cd).append("alien_num=").append(alien_num)
				.append("dt_entry_into_us=").append(dt_entry_into_us).append("left_home_dt=").append(left_home_dt).append("exp_back_at_home_dt=")
				.append(exp_back_at_home_dt).append("absence_reason_cd=").append(absence_reason_cd).append("place_of_birth_cd=")
				.append(place_of_birth_cd).append("res_va_sw=").append("res_va_sw").append("src_app_ind=").append(src_app_ind).append("tribe_cd=")
				.append(tribe_cd).append("alien_status_cd=").append(alien_status_cd).append("suffix_name = ").append(suffix_name)
				.append("people_in_home_ct = ").append(people_in_home_ct).append("confm_ssn_num = ").append(confm_ssn_num)
				.append("left_home_reason_cd=").append(left_home_reason_cd).append("lang_oth_dsc=").append(lang_oth_dsc).append("req_interp_ind=")
				.append(req_interp_ind).append("comm_asst_sl_interp_ind=").append(comm_asst_sl_interp_ind).append("comm_asst_tty_ind=")
				.append(comm_asst_tty_ind).append("comm_asst_lg_print_ind=").append(comm_asst_lg_print_ind).append("comm_asst_email_ind=")
				.append(comm_asst_email_ind).append("comm_asst_none_ind=").append(comm_asst_none_ind).append("tax_joint_file_ind=")
				.append(tax_joint_file_ind).append("tax_dp_outside_home_ind=").append(tax_dp_outside_home_ind).append("alias_ind=").append(alias_ind)
				.append("alias_fst_nam=").append(alias_fst_nam).append("alias_last_nam=").append(alias_last_nam).append("alias_mid_init=")
				.append(alias_mid_init).append("alias_suffix_name=").append(alias_suffix_name).append("ssn_info_ack_ind=").append(ssn_info_ack_ind)
				.append("hspc_dsc_cd=").append(hspc_dsc_cd).append("race_oth_asian_ind=").append(race_oth_asian_ind).append("race_samoan_ind=")
				.append(race_samoan_ind).append("race_filipino_ind=").append(race_filipino_ind).append("race_chinese_ind=").append(race_chinese_ind)
				.append("race_vie_ind=").append(race_vie_ind).append("race_korean_ind=").append(race_korean_ind).append("race_guam_ind=")
				.append(race_guam_ind).append("race_nhpi_ind=").append(race_nhpi_ind).append("race_oth_ind=").append(race_oth_ind)
				.append("race_japanese_ind=").append(race_japanese_ind).append("race_memb_fed_rec_trb_ind=").append(race_memb_fed_rec_trb_ind)
				.append("tribe_name=").append(tribe_name).append("if_out_arrangement=").append(if_out_arrangement).append("live_at_same_addr_ind=")
				.append(live_at_same_addr_ind).append("comm_asst_baille_ind=").append(comm_asst_baille_ind).append("comm_asst_vedrel_ind=")
				.append(comm_asst_vedrel_ind).append("inter_oth_dsc=").append(inter_oth_dsc).append("isBreastCancerDiagnosed")
				.append(isBreastCancerDiagnosed).append("dateOfDiagnosis").append(dateOfDiagnosis).append("cc_ind").append(cc_ind).append("wic_ind")
				.append(wic_ind).append("blnd_dabl_ind").append(blnd_dabl_ind).append("alien_doc_cd").append(alien_doc_cd)
				.append("comm_asst_fl_interp_ind=").append(comm_asst_fl_interp_ind).append("ssn_vrfn_fed_hub_ind=").append(ssn_vrfn_fed_hub_ind)
				.append("us_ctzn_fed_hub_ind=").append(us_ctzn_fed_hub_ind).append("dob_fed_hub_ind=").append(dob_fed_hub_ind)
				.append("unearned_inc_fed_hub_ind=").append(unearned_inc_fed_hub_ind).append("unearned_inc_dol_ind=").append(unearned_inc_dol_ind)
				.append("earned_inc_dol_ind=").append(earned_inc_dol_ind).append("earned_inc_wrk_num_ind=").append(earned_inc_wrk_num_ind)
				.append("res_ga_ind=").append(res_ga_ind).append("disabled_resp=").append(disabled_resp).append("chld_pa_act_duty_resp=")
				.append(chld_pa_act_duty_resp).append("tax_filing_status=").append(tax_filing_status).append("bst_cncr_ecp_id")
				.append(bst_cncr_ecp_id).append("race_persian_ind").append(race_persian_ind).append("race_eastasian_ind").append(race_eastasian_ind).append("race_unknown_ind").append(race_unknown_ind)
				.append("vld_immgrtn_sts").append(vld_immgrtn_sts).append(" chg_dt= ").append(chg_dt)
				.append(" wic_clnc_cnty= ").append(wic_clnc_cnty).append(" wic_clnc_cd= ").append(wic_clnc_cd)
				.append(" tax_flr_otsd_ind= ").append(tax_flr_otsd_ind).append(" is_wic_clnc_info_new= ").append(is_wic_clnc_info_new).toString();// //EDSP CP: code modified
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((absence_reason_cd == null) ? 0 : absence_reason_cd.trim().hashCode());
		result = (prime * result) + ((ai_ind == null) ? 0 : ai_ind.trim().hashCode());
		result = (prime * result) + ((alias_fst_nam == null) ? 0 : alias_fst_nam.trim().hashCode());
		result = (prime * result) + ((alias_ind == null) ? 0 : alias_ind.trim().hashCode());
		result = (prime * result) + ((alias_last_nam == null) ? 0 : alias_last_nam.trim().hashCode());
		result = (prime * result) + ((alias_mid_init == null) ? 0 : alias_mid_init.trim().hashCode());
		result = (prime * result) + ((alias_suffix_name == null) ? 0 : alias_suffix_name.trim().hashCode());
		result = (prime * result) + ((alien_doc_cd == null) ? 0 : alien_doc_cd.trim().hashCode());
		result = (prime * result) + ((alien_num == null) ? 0 : alien_num.trim().hashCode());
		result = (prime * result) + ((alien_status_cd == null) ? 0 : alien_status_cd.trim().hashCode());
		result = (prime * result) + ((aln_immigr_stat_cd == null) ? 0 : aln_immigr_stat_cd.trim().hashCode());
		result = (prime * result) + ((aln_sponser_sw == null) ? 0 : aln_sponser_sw.trim().hashCode());
		result = (prime * result) + ((aln_stat_grnted_dt == null) ? 0 : aln_stat_grnted_dt.trim().hashCode());
		result = (prime * result) + ((asia_ind == null) ? 0 : asia_ind.trim().hashCode());
		result = (prime * result) + ((blk_ind == null) ? 0 : blk_ind.trim().hashCode());
		result = (prime * result) + ((brth_dt == null) ? 0 : brth_dt.trim().hashCode());
		result = (prime * result) + ((cc_ind == null) ? 0 : cc_ind.trim().hashCode());
		result = (prime * result) + ((chld_deceased_vet_resp == null) ? 0 : chld_deceased_vet_resp.trim().hashCode());
		result = (prime * result) + ((chld_out_home_resp == null) ? 0 : chld_out_home_resp.trim().hashCode());
		result = (prime * result) + ((chld_pa_act_duty_resp == null) ? 0 : chld_pa_act_duty_resp.trim().hashCode());
		result = (prime * result) + ((chld_trb_mbr_resp == null) ? 0 : chld_trb_mbr_resp.trim().hashCode());
		result = (prime * result) + ((comm_asst_baille_ind == null) ? 0 : comm_asst_baille_ind.trim().hashCode());
		result = (prime * result) + ((comm_asst_email_ind == null) ? 0 : comm_asst_email_ind.trim().hashCode());
		result = (prime * result) + ((comm_asst_lg_print_ind == null) ? 0 : comm_asst_lg_print_ind.trim().hashCode());
		result = (prime * result) + ((comm_asst_none_ind == null) ? 0 : comm_asst_none_ind.trim().hashCode());
		result = (prime * result) + ((comm_asst_sl_interp_ind == null) ? 0 : comm_asst_sl_interp_ind.trim().hashCode());
		result = (prime * result) + ((comm_asst_fl_interp_ind == null) ? 0 : comm_asst_fl_interp_ind.trim().hashCode());
		result = (prime * result) + ((comm_asst_tty_ind == null) ? 0 : comm_asst_tty_ind.trim().hashCode());
		result = (prime * result) + ((comm_asst_vedrel_ind == null) ? 0 : comm_asst_vedrel_ind.trim().hashCode());
		result = (prime * result) + ((confm_brth_dt == null) ? 0 : confm_brth_dt.trim().hashCode());
		result = (prime * result) + ((confm_ssn_num == null) ? 0 : confm_ssn_num.trim().hashCode());
		result = (prime * result) + ((dateOfDiagnosis == null) ? 0 : dateOfDiagnosis.trim().hashCode());
		result = (prime * result) + ((disable_vet_resp == null) ? 0 : disable_vet_resp.trim().hashCode());
		result = (prime * result) + ((disabled_resp == null) ? 0 : disabled_resp.trim().hashCode());
		result = (prime * result) + ((dt_entry_into_us == null) ? 0 : dt_entry_into_us.trim().hashCode());
		result = (prime * result) + ((dt_leave_facty == null) ? 0 : dt_leave_facty.trim().hashCode());
		result = (prime * result) + ((exp_back_at_home_dt == null) ? 0 : exp_back_at_home_dt.trim().hashCode());
		result = (prime * result) + ((fst_nam == null) ? 0 : fst_nam.trim().hashCode());
		result = (prime * result) + ((has_spon_resp == null) ? 0 : has_spon_resp.trim().hashCode());
		result = (prime * result) + ((hspc_dsc_cd == null) ? 0 : hspc_dsc_cd.trim().hashCode());
		result = (prime * result) + ((hspc_ind == null) ? 0 : hspc_ind.trim().hashCode());
		result = (prime * result) + ((if_out_arrangement == null) ? 0 : if_out_arrangement.trim().hashCode());
		result = (prime * result) + ((inter_oth_dsc == null) ? 0 : inter_oth_dsc.trim().hashCode());
		result = (prime * result) + ((intn_res_resp == null) ? 0 : intn_res_resp.trim().hashCode());
		result = (prime * result) + ((isBreastCancerDiagnosed == null) ? 0 : isBreastCancerDiagnosed.trim().hashCode());
		result = (prime * result) + ((job_commitment_resp == null) ? 0 : job_commitment_resp.trim().hashCode());
		result = (prime * result) + ((lang_cd == null) ? 0 : lang_cd.trim().hashCode());
		result = (prime * result) + ((lang_oth_dsc == null) ? 0 : lang_oth_dsc.trim().hashCode());
		result = (prime * result) + ((last_nam == null) ? 0 : last_nam.trim().hashCode());
		result = (prime * result) + ((left_home_dt == null) ? 0 : left_home_dt.trim().hashCode());
		result = (prime * result) + ((left_home_reason_cd == null) ? 0 : left_home_reason_cd.trim().hashCode());
		result = (prime * result) + ((live_arng_typ == null) ? 0 : live_arng_typ.trim().hashCode());
		result = (prime * result) + ((live_at_same_addr_ind == null) ? 0 : live_at_same_addr_ind.trim().hashCode());
		result = (prime * result) + ((living_arrangement_cd == null) ? 0 : living_arrangement_cd.trim().hashCode());
		result = (prime * result) + ((ma_ind == null) ? 0 : ma_ind.trim().hashCode());
		result = (prime * result) + ((mid_init == null) ? 0 : mid_init.trim().hashCode());
		result = (prime * result) + ((mig_farm_wrkr_sw == null) ? 0 : mig_farm_wrkr_sw.trim().hashCode());
		result = (prime * result) + ((mrtl_stat_cd == null) ? 0 : mrtl_stat_cd.trim().hashCode());
		result = (prime * result) + ((non_hspc_ind == null) ? 0 : non_hspc_ind.trim().hashCode());
		result = (prime * result) + ((org_nam == null) ? 0 : org_nam.trim().hashCode());
		result = (prime * result) + ((pac_isl_ind == null) ? 0 : pac_isl_ind.trim().hashCode());
		result = (prime * result) + ((people_in_home_ct == null) ? 0 : people_in_home_ct.trim().hashCode());
		result = (prime * result) + ((place_of_birth_cd == null) ? 0 : place_of_birth_cd.trim().hashCode());
		result = (prime * result) + ((preg_resp == null) ? 0 : preg_resp.trim().hashCode());
		result = (prime * result) + ((prim_prsn_sw == null) ? 0 : prim_prsn_sw.trim().hashCode());
		result = (prime * result) + ((qualified_alien_sw == null) ? 0 : qualified_alien_sw.trim().hashCode());
		result = (prime * result) + ((race_chinese_ind == null) ? 0 : race_chinese_ind.trim().hashCode());
		result = (prime * result) + ((race_filipino_ind == null) ? 0 : race_filipino_ind.trim().hashCode());
		result = (prime * result) + ((race_guam_ind == null) ? 0 : race_guam_ind.trim().hashCode());
		result = (prime * result) + ((race_japanese_ind == null) ? 0 : race_japanese_ind.trim().hashCode());
		result = (prime * result) + ((race_korean_ind == null) ? 0 : race_korean_ind.trim().hashCode());
		result = (prime * result) + ((race_memb_fed_rec_trb_ind == null) ? 0 : race_memb_fed_rec_trb_ind.trim().hashCode());
		result = (prime * result) + ((race_nhpi_ind == null) ? 0 : race_nhpi_ind.trim().hashCode());
		result = (prime * result) + ((race_oth_asian_ind == null) ? 0 : race_oth_asian_ind.trim().hashCode());
		result = (prime * result) + ((race_oth_ind == null) ? 0 : race_oth_ind.trim().hashCode());
		result = (prime * result) + ((race_samoan_ind == null) ? 0 : race_samoan_ind.trim().hashCode());
		result = (prime * result) + ((race_vie_ind == null) ? 0 : race_vie_ind.trim().hashCode());
		result = (prime * result) + ((rec_cplt_ind == null) ? 0 : rec_cplt_ind.trim().hashCode());
		result = (prime * result) + ((req_interp_ind == null) ? 0 : req_interp_ind.trim().hashCode());
		result = (prime * result) + ((res_ga_ind == null) ? 0 : res_ga_ind.trim().hashCode());
		result = (prime * result) + ((res_va_sw == null) ? 0 : res_va_sw.trim().hashCode());
		result = (prime * result) + ((res_wi_sw == null) ? 0 : res_wi_sw.trim().hashCode());
		result = (prime * result) + ((rlvn_ind == null) ? 0 : rlvn_ind.trim().hashCode());
		result = (prime * result) + ((sex_ind == null) ? 0 : sex_ind.trim().hashCode());
		result = (prime * result) + ((snap_ind == null) ? 0 : snap_ind.trim().hashCode());
		result = (prime * result) + ((spon_indv_seq_num == null) ? 0 : spon_indv_seq_num.trim().hashCode());
		result = (prime * result) + ((spon_typ == null) ? 0 : spon_typ.trim().hashCode());
		result = (prime * result) + ((sps_deceased_vet_resp == null) ? 0 : sps_deceased_vet_resp.trim().hashCode());
		result = (prime * result) + ((src_app_ind == null) ? 0 : src_app_ind.trim().hashCode());
		result = (prime * result) + ((ss_num_app_dt == null) ? 0 : ss_num_app_dt.trim().hashCode());
		result = (prime * result) + ((ssn_info_ack_ind == null) ? 0 : ssn_info_ack_ind.trim().hashCode());
		result = (prime * result) + ((ssn_num == null) ? 0 : ssn_num.trim().hashCode());
		result = (prime * result) + ((suffix_name == null) ? 0 : suffix_name.trim().hashCode());
		result = (prime * result) + ((tanf_ind == null) ? 0 : tanf_ind.trim().hashCode());
		result = (prime * result) + ((tax_dp_outside_home_ind == null) ? 0 : tax_dp_outside_home_ind.trim().hashCode());
		result = (prime * result) + ((tax_joint_file_ind == null) ? 0 : tax_joint_file_ind.trim().hashCode());
		result = (prime * result) + ((trb_mbr_resp == null) ? 0 : trb_mbr_resp.trim().hashCode());
		result = (prime * result) + ((tribe_cd == null) ? 0 : tribe_cd.trim().hashCode());
		result = (prime * result) + ((tribe_name == null) ? 0 : tribe_name.trim().hashCode());
		result = (prime * result) + ((unknown_ind == null) ? 0 : unknown_ind.trim().hashCode());
		result = (prime * result) + ((us_ctzn_sw == null) ? 0 : us_ctzn_sw.trim().hashCode());
		result = (prime * result) + ((vet_act_duty_resp == null) ? 0 : vet_act_duty_resp.trim().hashCode());
		result = (prime * result) + ((vet_resp == null) ? 0 : vet_resp.trim().hashCode());
		result = (prime * result) + ((wht_ind == null) ? 0 : wht_ind.trim().hashCode());
		result = (prime * result) + ((wic_ind == null) ? 0 : wic_ind.trim().hashCode());
		result = (prime * result) + ((blnd_dabl_ind == null) ? 0 : blnd_dabl_ind.trim().hashCode());

		result = (prime * result) + ((ssn_vrfn_fed_hub_ind == null) ? 0 : ssn_vrfn_fed_hub_ind.trim().hashCode());
		result = (prime * result) + ((us_ctzn_fed_hub_ind == null) ? 0 : us_ctzn_fed_hub_ind.trim().hashCode());
		result = (prime * result) + ((dob_fed_hub_ind == null) ? 0 : dob_fed_hub_ind.trim().hashCode());
		result = (prime * result) + ((unearned_inc_fed_hub_ind == null) ? 0 : unearned_inc_fed_hub_ind.trim().hashCode());
		result = (prime * result) + ((unearned_inc_dol_ind == null) ? 0 : unearned_inc_dol_ind.trim().hashCode());
		result = (prime * result) + ((earned_inc_dol_ind == null) ? 0 : earned_inc_dol_ind.trim().hashCode());
		result = (prime * result) + ((earned_inc_wrk_num_ind == null) ? 0 : earned_inc_wrk_num_ind.trim().hashCode());
		result = (prime * result) + ((tax_filing_status == null) ? 0 : tax_filing_status.trim().hashCode());
		result = (prime * result) + ((bst_cncr_ecp_id == null) ? 0 : bst_cncr_ecp_id.trim().hashCode());
		result = (prime * result) + ((race_persian_ind == null) ? 0 : race_persian_ind.trim().hashCode());
		result = (prime * result) + ((race_eastasian_ind == null) ? 0 : race_eastasian_ind.trim().hashCode());
		result = (prime * result) + ((race_unknown_ind == null) ? 0 : race_unknown_ind.trim().hashCode());
		result = (prime * result) + ((vld_immgrtn_sts == null) ? 0 : vld_immgrtn_sts.trim().hashCode());
		result = (prime * result) + ((chg_dt == null) ? 0 : chg_dt.trim().hashCode());
		result = prime * result + (null == wic_clnc_cnty ? 0 : wic_clnc_cnty.trim().hashCode());
		result = prime * result + (null == wic_clnc_cd ? 0 : wic_clnc_cd.trim().hashCode());
		result = prime * result + (null == tax_flr_otsd_ind ? 0 : tax_flr_otsd_ind.trim().hashCode());
		result = prime * result + (null == is_wic_clnc_info_new ? 0 : is_wic_clnc_info_new.trim().hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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
		final AppIndvCargo other = (AppIndvCargo) obj;
		if (absence_reason_cd == null) {
			if (other.absence_reason_cd != null) {
				return false;
			}
		} else if (!absence_reason_cd.equals(other.absence_reason_cd)) {
			return false;
		}
		if (ai_ind == null) {
			if (other.ai_ind != null) {
				return false;
			}
		} else if (!ai_ind.equals(other.ai_ind)) {
			return false;
		}
		if (alias_fst_nam == null) {
			if (other.alias_fst_nam != null) {
				return false;
			}
		} else if (!alias_fst_nam.equals(other.alias_fst_nam)) {
			return false;
		}
		if (alias_ind == null) {
			if (other.alias_ind != null) {
				return false;
			}
		} else if (!alias_ind.equals(other.alias_ind)) {
			return false;
		}
		if (alias_last_nam == null) {
			if (other.alias_last_nam != null) {
				return false;
			}
		} else if (!alias_last_nam.equals(other.alias_last_nam)) {
			return false;
		}
		if (alias_mid_init == null) {
			if (other.alias_mid_init != null) {
				return false;
			}
		} else if (!alias_mid_init.equals(other.alias_mid_init)) {
			return false;
		}
		if (alias_suffix_name == null) {
			if (other.alias_suffix_name != null) {
				return false;
			}
		} else if (!alias_suffix_name.equals(other.alias_suffix_name)) {
			return false;
		}
		if (alien_doc_cd == null) {
			if (other.alien_doc_cd != null) {
				return false;
			}
		} else if (!alien_doc_cd.equals(other.alien_doc_cd)) {
			return false;
		}
		if (alien_num == null) {
			if (other.alien_num != null) {
				return false;
			}
		} else if (!alien_num.equals(other.alien_num)) {
			return false;
		}
		if (alien_status_cd == null) {
			if (other.alien_status_cd != null) {
				return false;
			}
		} else if (!alien_status_cd.equals(other.alien_status_cd)) {
			return false;
		}
		if (aln_immigr_stat_cd == null) {
			if (other.aln_immigr_stat_cd != null) {
				return false;
			}
		} else if (!aln_immigr_stat_cd.equals(other.aln_immigr_stat_cd)) {
			return false;
		}
		if (aln_sponser_sw == null) {
			if (other.aln_sponser_sw != null) {
				return false;
			}
		} else if (!aln_sponser_sw.equals(other.aln_sponser_sw)) {
			return false;
		}
		if (aln_stat_grnted_dt == null) {
			if (other.aln_stat_grnted_dt != null) {
				return false;
			}
		} else if (!aln_stat_grnted_dt.equals(other.aln_stat_grnted_dt)) {
			return false;
		}
		
		if (asia_ind == null) {
			if (other.asia_ind != null) {
				return false;
			}
		} else if (!asia_ind.equals(other.asia_ind)) {
			return false;
		}
		if (blk_ind == null) {
			if (other.blk_ind != null) {
				return false;
			}
		} else if (!blk_ind.equals(other.blk_ind)) {
			return false;
		}
		if (brth_dt == null) {
			if (other.brth_dt != null) {
				return false;
			}
		} else if (!brth_dt.equals(other.brth_dt)) {
			return false;
		}
		if (cc_ind == null) {
			if (other.cc_ind != null) {
				return false;
			}
		} else if (!cc_ind.equals(other.cc_ind)) {
			return false;
		}
		if (chld_deceased_vet_resp == null) {
			if (other.chld_deceased_vet_resp != null) {
				return false;
			}
		} else if (!chld_deceased_vet_resp.equals(other.chld_deceased_vet_resp)) {
			return false;
		}
		if (chld_out_home_resp == null) {
			if (other.chld_out_home_resp != null) {
				return false;
			}
		} else if (!chld_out_home_resp.equals(other.chld_out_home_resp)) {
			return false;
		}
		if (chld_pa_act_duty_resp == null) {
			if (other.chld_pa_act_duty_resp != null) {
				return false;
			}
		} else if (!chld_pa_act_duty_resp.equals(other.chld_pa_act_duty_resp)) {
			return false;
		}
		if (chld_trb_mbr_resp == null) {
			if (other.chld_trb_mbr_resp != null) {
				return false;
			}
		} else if (!chld_trb_mbr_resp.equals(other.chld_trb_mbr_resp)) {
			return false;
		}
		if (comm_asst_baille_ind == null) {
			if (other.comm_asst_baille_ind != null) {
				return false;
			}
		} else if (!comm_asst_baille_ind.equals(other.comm_asst_baille_ind)) {
			return false;
		}
		if (comm_asst_email_ind == null) {
			if (other.comm_asst_email_ind != null) {
				return false;
			}
		} else if (!comm_asst_email_ind.equals(other.comm_asst_email_ind)) {
			return false;
		}
		if (comm_asst_lg_print_ind == null) {
			if (other.comm_asst_lg_print_ind != null) {
				return false;
			}
		} else if (!comm_asst_lg_print_ind.equals(other.comm_asst_lg_print_ind)) {
			return false;
		}
		if (comm_asst_none_ind == null) {
			if (other.comm_asst_none_ind != null) {
				return false;
			}
		} else if (!comm_asst_none_ind.equals(other.comm_asst_none_ind)) {
			return false;
		}
		if (comm_asst_sl_interp_ind == null) {
			if (other.comm_asst_sl_interp_ind != null) {
				return false;
			}
		} else if (!comm_asst_sl_interp_ind.equals(other.comm_asst_sl_interp_ind)) {
			return false;
		}
		if (comm_asst_fl_interp_ind == null) {
			if (other.comm_asst_fl_interp_ind != null) {
				return false;
			}
		} else if (!comm_asst_fl_interp_ind.equals(other.comm_asst_fl_interp_ind)) {
			return false;
		}
		if (comm_asst_tty_ind == null) {
			if (other.comm_asst_tty_ind != null) {
				return false;
			}
		} else if (!comm_asst_tty_ind.equals(other.comm_asst_tty_ind)) {
			return false;
		}
		if (comm_asst_vedrel_ind == null) {
			if (other.comm_asst_vedrel_ind != null) {
				return false;
			}
		} else if (!comm_asst_vedrel_ind.equals(other.comm_asst_vedrel_ind)) {
			return false;
		}
		if (confm_brth_dt == null) {
			if (other.confm_brth_dt != null) {
				return false;
			}
		} else if (!confm_brth_dt.equals(other.confm_brth_dt)) {
			return false;
		}
		if (confm_ssn_num == null) {
			if (other.confm_ssn_num != null) {
				return false;
			}
		} else if (!confm_ssn_num.equals(other.confm_ssn_num)) {
			return false;
		}
		if (dateOfDiagnosis == null) {
			if (other.dateOfDiagnosis != null) {
				return false;
			}
		} else if (!dateOfDiagnosis.equals(other.dateOfDiagnosis)) {
			return false;
		}
		if (disable_vet_resp == null) {
			if (other.disable_vet_resp != null) {
				return false;
			}
		} else if (!disable_vet_resp.equals(other.disable_vet_resp)) {
			return false;
		}
		if (disabled_resp == null) {
			if (other.disabled_resp != null) {
				return false;
			}
		} else if (!disabled_resp.equals(other.disabled_resp)) {
			return false;
		}
		if (dt_entry_into_us == null) {
			if (other.dt_entry_into_us != null) {
				return false;
			}
		} else if (!dt_entry_into_us.equals(other.dt_entry_into_us)) {
			return false;
		}
		if (dt_leave_facty == null) {
			if (other.dt_leave_facty != null) {
				return false;
			}
		} else if (!dt_leave_facty.equals(other.dt_leave_facty)) {
			return false;
		}
		if (exp_back_at_home_dt == null) {
			if (other.exp_back_at_home_dt != null) {
				return false;
			}
		} else if (!exp_back_at_home_dt.equals(other.exp_back_at_home_dt)) {
			return false;
		}
		if (fst_nam == null) {
			if (other.fst_nam != null) {
				return false;
			}
		} else if (!fst_nam.equals(other.fst_nam)) {
			return false;
		}
		if (has_spon_resp == null) {
			if (other.has_spon_resp != null) {
				return false;
			}
		} else if (!has_spon_resp.equals(other.has_spon_resp)) {
			return false;
		}
		if (hspc_dsc_cd == null) {
			if (other.hspc_dsc_cd != null) {
				return false;
			}
		} else if (!hspc_dsc_cd.equals(other.hspc_dsc_cd)) {
			return false;
		}
		if (hspc_ind == null) {
			if (other.hspc_ind != null) {
				return false;
			}
		} else if (!hspc_ind.equals(other.hspc_ind)) {
			return false;
		}
		if (if_out_arrangement == null) {
			if (other.if_out_arrangement != null) {
				return false;
			}
		} else if (!if_out_arrangement.equals(other.if_out_arrangement)) {
			return false;
		}
		
		if (inter_oth_dsc == null) {
			if (other.inter_oth_dsc != null) {
				return false;
			}
		} else if (!inter_oth_dsc.equals(other.inter_oth_dsc)) {
			return false;
		}
		if (intn_res_resp == null) {
			if (other.intn_res_resp != null) {
				return false;
			}
		} else if (!intn_res_resp.equals(other.intn_res_resp)) {
			return false;
		}
		if (isBreastCancerDiagnosed == null) {
			if (other.isBreastCancerDiagnosed != null) {
				return false;
			}
		} else if (!isBreastCancerDiagnosed.equals(other.isBreastCancerDiagnosed)) {
			return false;
		}
		if (job_commitment_resp == null) {
			if (other.job_commitment_resp != null) {
				return false;
			}
		} else if (!job_commitment_resp.equals(other.job_commitment_resp)) {
			return false;
		}
		if (lang_cd == null) {
			if (other.lang_cd != null) {
				return false;
			}
		} else if (!lang_cd.equals(other.lang_cd)) {
			return false;
		}
		if (lang_oth_dsc == null) {
			if (other.lang_oth_dsc != null) {
				return false;
			}
		} else if (!lang_oth_dsc.equals(other.lang_oth_dsc)) {
			return false;
		}
		if (last_nam == null) {
			if (other.last_nam != null) {
				return false;
			}
		} else if (!last_nam.equals(other.last_nam)) {
			return false;
		}
		if (left_home_dt == null) {
			if (other.left_home_dt != null) {
				return false;
			}
		} else if (!left_home_dt.equals(other.left_home_dt)) {
			return false;
		}
		if (left_home_reason_cd == null) {
			if (other.left_home_reason_cd != null) {
				return false;
			}
		} else if (!left_home_reason_cd.equals(other.left_home_reason_cd)) {
			return false;
		}
		if (live_arng_typ == null) {
			if (other.live_arng_typ != null) {
				return false;
			}
		} else if (!live_arng_typ.equals(other.live_arng_typ)) {
			return false;
		}
		if (live_at_same_addr_ind == null) {
			if (other.live_at_same_addr_ind != null) {
				return false;
			}
		} else if (!live_at_same_addr_ind.equals(other.live_at_same_addr_ind)) {
			return false;
		}
		if (living_arrangement_cd == null) {
			if (other.living_arrangement_cd != null) {
				return false;
			}
		} else if (!living_arrangement_cd.equals(other.living_arrangement_cd)) {
			return false;
		}
		if (ma_ind == null) {
			if (other.ma_ind != null) {
				return false;
			}
		} else if (!ma_ind.equals(other.ma_ind)) {
			return false;
		}
		if (mid_init == null) {
			if (other.mid_init != null) {
				return false;
			}
		} else if (!mid_init.equals(other.mid_init)) {
			return false;
		}
		if (mig_farm_wrkr_sw == null) {
			if (other.mig_farm_wrkr_sw != null) {
				return false;
			}
		} else if (!mig_farm_wrkr_sw.equals(other.mig_farm_wrkr_sw)) {
			return false;
		}
		if (mrtl_stat_cd == null) {
			if (other.mrtl_stat_cd != null) {
				return false;
			}
		} else if (!mrtl_stat_cd.equals(other.mrtl_stat_cd)) {
			return false;
		}
		if (non_hspc_ind == null) {
			if (other.non_hspc_ind != null) {
				return false;
			}
		} else if (!non_hspc_ind.equals(other.non_hspc_ind)) {
			return false;
		}
		if (org_nam == null) {
			if (other.org_nam != null) {
				return false;
			}
		} else if (!org_nam.equals(other.org_nam)) {
			return false;
		}
		if (pac_isl_ind == null) {
			if (other.pac_isl_ind != null) {
				return false;
			}
		} else if (!pac_isl_ind.equals(other.pac_isl_ind)) {
			return false;
		}
		if (people_in_home_ct == null) {
			if (other.people_in_home_ct != null) {
				return false;
			}
		} else if (!people_in_home_ct.equals(other.people_in_home_ct)) {
			return false;
		}
		if (place_of_birth_cd == null) {
			if (other.place_of_birth_cd != null) {
				return false;
			}
		} else if (!place_of_birth_cd.equals(other.place_of_birth_cd)) {
			return false;
		}
		if (preg_resp == null) {
			if (other.preg_resp != null) {
				return false;
			}
		} else if (!preg_resp.equals(other.preg_resp)) {
			return false;
		}
		if (prim_prsn_sw == null) {
			if (other.prim_prsn_sw != null) {
				return false;
			}
		} else if (!prim_prsn_sw.equals(other.prim_prsn_sw)) {
			return false;
		}
		if (qualified_alien_sw == null) {
			if (other.qualified_alien_sw != null) {
				return false;
			}
		} else if (!qualified_alien_sw.equals(other.qualified_alien_sw)) {
			return false;
		}
		if (race_chinese_ind == null) {
			if (other.race_chinese_ind != null) {
				return false;
			}
		} else if (!race_chinese_ind.equals(other.race_chinese_ind)) {
			return false;
		}
		if (race_filipino_ind == null) {
			if (other.race_filipino_ind != null) {
				return false;
			}
		} else if (!race_filipino_ind.equals(other.race_filipino_ind)) {
			return false;
		}
		if (race_guam_ind == null) {
			if (other.race_guam_ind != null) {
				return false;
			}
		} else if (!race_guam_ind.equals(other.race_guam_ind)) {
			return false;
		}
		if (race_japanese_ind == null) {
			if (other.race_japanese_ind != null) {
				return false;
			}
		} else if (!race_japanese_ind.equals(other.race_japanese_ind)) {
			return false;
		}
		if (race_korean_ind == null) {
			if (other.race_korean_ind != null) {
				return false;
			}
		} else if (!race_korean_ind.equals(other.race_korean_ind)) {
			return false;
		}
		if (race_memb_fed_rec_trb_ind == null) {
			if (other.race_memb_fed_rec_trb_ind != null) {
				return false;
			}
		} else if (!race_memb_fed_rec_trb_ind.equals(other.race_memb_fed_rec_trb_ind)) {
			return false;
		}
		if (race_nhpi_ind == null) {
			if (other.race_nhpi_ind != null) {
				return false;
			}
		} else if (!race_nhpi_ind.equals(other.race_nhpi_ind)) {
			return false;
		}
		if (race_oth_asian_ind == null) {
			if (other.race_oth_asian_ind != null) {
				return false;
			}
		} else if (!race_oth_asian_ind.equals(other.race_oth_asian_ind)) {
			return false;
		}
		if (race_oth_ind == null) {
			if (other.race_oth_ind != null) {
				return false;
			}
		} else if (!race_oth_ind.equals(other.race_oth_ind)) {
			return false;
		}
		if (race_samoan_ind == null) {
			if (other.race_samoan_ind != null) {
				return false;
			}
		} else if (!race_samoan_ind.equals(other.race_samoan_ind)) {
			return false;
		}
		if (race_vie_ind == null) {
			if (other.race_vie_ind != null) {
				return false;
			}
		} else if (!race_vie_ind.equals(other.race_vie_ind)) {
			return false;
		}
		if (rec_cplt_ind == null) {
			if (other.rec_cplt_ind != null) {
				return false;
			}
		} else if (!rec_cplt_ind.equals(other.rec_cplt_ind)) {
			return false;
		}
		if (req_interp_ind == null) {
			if (other.req_interp_ind != null) {
				return false;
			}
		} else if (!req_interp_ind.equals(other.req_interp_ind)) {
			return false;
		}
		if (res_ga_ind == null) {
			if (other.res_ga_ind != null) {
				return false;
			}
		} else if (!res_ga_ind.equals(other.res_ga_ind)) {
			return false;
		}
		if (res_va_sw == null) {
			if (other.res_va_sw != null) {
				return false;
			}
		} else if (!res_va_sw.equals(other.res_va_sw)) {
			return false;
		}
		if (res_wi_sw == null) {
			if (other.res_wi_sw != null) {
				return false;
			}
		} else if (!res_wi_sw.equals(other.res_wi_sw)) {
			return false;
		}
		if (rlvn_ind == null) {
			if (other.rlvn_ind != null) {
				return false;
			}
		} else if (!rlvn_ind.equals(other.rlvn_ind)) {
			return false;
		}
		if (sex_ind == null) {
			if (other.sex_ind != null) {
				return false;
			}
		} else if (!sex_ind.equals(other.sex_ind)) {
			return false;
		}
		if (snap_ind == null) {
			if (other.snap_ind != null) {
				return false;
			}
		} else if (!snap_ind.equals(other.snap_ind)) {
			return false;
		}
		if (spon_indv_seq_num == null) {
			if (other.spon_indv_seq_num != null) {
				return false;
			}
		} else if (!spon_indv_seq_num.equals(other.spon_indv_seq_num)) {
			return false;
		}
		if (spon_typ == null) {
			if (other.spon_typ != null) {
				return false;
			}
		} else if (!spon_typ.equals(other.spon_typ)) {
			return false;
		}
		if (sps_deceased_vet_resp == null) {
			if (other.sps_deceased_vet_resp != null) {
				return false;
			}
		} else if (!sps_deceased_vet_resp.equals(other.sps_deceased_vet_resp)) {
			return false;
		}
		if (src_app_ind == null) {
			if (other.src_app_ind != null) {
				return false;
			}
		} else if (!src_app_ind.equals(other.src_app_ind)) {
			return false;
		}
		if (ss_num_app_dt == null) {
			if (other.ss_num_app_dt != null) {
				return false;
			}
		} else if (!ss_num_app_dt.equals(other.ss_num_app_dt)) {
			return false;
		}
		if (ssn_info_ack_ind == null) {
			if (other.ssn_info_ack_ind != null) {
				return false;
			}
		} else if (!ssn_info_ack_ind.equals(other.ssn_info_ack_ind)) {
			return false;
		}
		if (ssn_num == null) {
			if (other.ssn_num != null) {
				return false;
			}
		} else if (!ssn_num.equals(other.ssn_num)) {
			return false;
		}
		if (suffix_name == null) {
			if (other.suffix_name != null) {
				return false;
			}
		} else if (!suffix_name.equals(other.suffix_name)) {
			return false;
		}
		if (tanf_ind == null) {
			if (other.tanf_ind != null) {
				return false;
			}
		} else if (!tanf_ind.equals(other.tanf_ind)) {
			return false;
		}
		if (tax_dp_outside_home_ind == null) {
			if (other.tax_dp_outside_home_ind != null) {
				return false;
			}
		} else if (!tax_dp_outside_home_ind.equals(other.tax_dp_outside_home_ind)) {
			return false;
		}
		if (tax_joint_file_ind == null) {
			if (other.tax_joint_file_ind != null) {
				return false;
			}
		} else if (!tax_joint_file_ind.equals(other.tax_joint_file_ind)) {
			return false;
		}
		if (trb_mbr_resp == null) {
			if (other.trb_mbr_resp != null) {
				return false;
			}
		} else if (!trb_mbr_resp.equals(other.trb_mbr_resp)) {
			return false;
		}
		if (tribe_cd == null) {
			if (other.tribe_cd != null) {
				return false;
			}
		} else if (!tribe_cd.equals(other.tribe_cd)) {
			return false;
		}
		if (tribe_name == null) {
			if (other.tribe_name != null) {
				return false;
			}
		} else if (!tribe_name.equals(other.tribe_name)) {
			return false;
		}
		if (unknown_ind == null) {
			if (other.unknown_ind != null) {
				return false;
			}
		} else if (!unknown_ind.equals(other.unknown_ind)) {
			return false;
		}
		if (us_ctzn_sw == null) {
			if (other.us_ctzn_sw != null) {
				return false;
			}
		} else if (!us_ctzn_sw.equals(other.us_ctzn_sw)) {
			return false;
		}
		if (vet_act_duty_resp == null) {
			if (other.vet_act_duty_resp != null) {
				return false;
			}
		} else if (!vet_act_duty_resp.equals(other.vet_act_duty_resp)) {
			return false;
		}
		if (vet_resp == null) {
			if (other.vet_resp != null) {
				return false;
			}
		} else if (!vet_resp.equals(other.vet_resp)) {
			return false;
		}
		if (wht_ind == null) {
			if (other.wht_ind != null) {
				return false;
			}
		} else if (!wht_ind.equals(other.wht_ind)) {
			return false;
		}
		if (wic_ind == null) {
			if (other.wic_ind != null) {
				return false;
			}
		} else if (!wic_ind.equals(other.wic_ind)) {
			return false;
		}
		if (blnd_dabl_ind == null) {
			if (other.blnd_dabl_ind != null) {
				return false;
			}
		} else if (!blnd_dabl_ind.equals(other.blnd_dabl_ind)) {
			return false;
		}

		if (ssn_vrfn_fed_hub_ind == null) {
			if (other.ssn_vrfn_fed_hub_ind != null) {
				return false;
			}
		} else if (!ssn_vrfn_fed_hub_ind.equals(other.ssn_vrfn_fed_hub_ind)) {
			return false;
		}
		if (us_ctzn_fed_hub_ind == null) {
			if (other.us_ctzn_fed_hub_ind != null) {
				return false;
			}
		} else if (!us_ctzn_fed_hub_ind.equals(other.us_ctzn_fed_hub_ind)) {
			return false;
		}
		if (dob_fed_hub_ind == null) {
			if (other.dob_fed_hub_ind != null) {
				return false;
			}
		} else if (!dob_fed_hub_ind.equals(other.dob_fed_hub_ind)) {
			return false;
		}
		if (unearned_inc_fed_hub_ind == null) {
			if (other.unearned_inc_fed_hub_ind != null) {
				return false;
			}
		} else if (!unearned_inc_fed_hub_ind.equals(other.unearned_inc_fed_hub_ind)) {
			return false;
		}
		if (unearned_inc_dol_ind == null) {
			if (other.unearned_inc_dol_ind != null) {
				return false;
			}
		} else if (!unearned_inc_dol_ind.equals(other.unearned_inc_dol_ind)) {
			return false;
		}
		if (earned_inc_dol_ind == null) {
			if (other.earned_inc_dol_ind != null) {
				return false;
			}
		} else if (!earned_inc_dol_ind.equals(other.earned_inc_dol_ind)) {
			return false;
		}
		if (earned_inc_wrk_num_ind == null) {
			if (other.earned_inc_wrk_num_ind != null) {
				return false;
			}
		} else if (!earned_inc_wrk_num_ind.equals(other.earned_inc_wrk_num_ind)) {
			return false;
		}
		if (chld_pa_act_duty_resp == null) {
			if (other.chld_pa_act_duty_resp != null) {
				return false;
			}
		} else if (!chld_pa_act_duty_resp.equals(other.chld_pa_act_duty_resp)) {
			return false;
		}
		if (tax_filing_status == null) {
			if (other.tax_filing_status != null) {
				return false;
			}
		} else if (!tax_filing_status.equals(other.tax_filing_status)) {
			return false;
		}
		if (bst_cncr_ecp_id == null) {
			if (other.bst_cncr_ecp_id != null) {
				return false;
			}
		} else if (!bst_cncr_ecp_id.equals(other.bst_cncr_ecp_id)) {
			return false;
		}
		if (race_persian_ind == null) {
			if (other.race_persian_ind != null) {
				return false;
			}
		} else if (!race_persian_ind.equals(other.race_persian_ind)) {
			return false;
		}
		if (race_eastasian_ind == null) {
			if (other.race_eastasian_ind != null) {
				return false;
			}
		} else if (!race_eastasian_ind.equals(other.race_eastasian_ind)) {
			return false;
		}
		if (race_unknown_ind == null) {
			if (other.race_unknown_ind != null) {
				return false;
			}
		} else if (!race_unknown_ind.equals(other.race_unknown_ind)) {
			return false;
		}
		
		if (vld_immgrtn_sts == null) {
			if (other.vld_immgrtn_sts != null) {
				return false;
			}
		} else if (!vld_immgrtn_sts.equals(other.vld_immgrtn_sts)) {
			return false;
		}
		
		
		return true;
	}

	public Map compareAttributes(final AppIndvCargo aCargo) {
		final Map changedAttributeValue = new HashMap();
		if (!((aCargo.getFst_nam() == null) && (fst_nam == null)) && !((aCargo.getFst_nam() != null) && aCargo.getFst_nam().equals(fst_nam))) {
			changedAttributeValue.put("fst_nam", aCargo.getFst_nam());
		}
		if (!((aCargo.getLast_nam() == null) && (last_nam == null)) && !((aCargo.getLast_nam() != null) && aCargo.getLast_nam().equals(last_nam))) {
			changedAttributeValue.put("last_nam", aCargo.getLast_nam());
		}
		if (!((aCargo.getMid_init() == null) && (mid_init == null)) && !((aCargo.getMid_init() != null) && aCargo.getMid_init().equals(mid_init))) {
			changedAttributeValue.put("mid_init", aCargo.getMid_init());
		}
		if (!((aCargo.getSex_ind() == null) && (sex_ind == null)) && !((aCargo.getSex_ind() != null) && aCargo.getSex_ind().equals(sex_ind))) {
			changedAttributeValue.put("sex_ind", aCargo.getSex_ind());
		}
		if (!((aCargo.getBrth_dt() == null) && (brth_dt == null)) && !((aCargo.getBrth_dt() != null) && aCargo.getBrth_dt().equals(brth_dt))) {
			changedAttributeValue.put("brth_dt", aCargo.getBrth_dt());
		}
		if (!((aCargo.getSsn_num() == null) && (ssn_num == null)) && !((aCargo.getSsn_num() != null) && aCargo.getSsn_num().equals(ssn_num))) {
			changedAttributeValue.put("ssn_num", aCargo.getSsn_num());
		}
		if (!((aCargo.getMrtl_stat_cd() == null) && (mrtl_stat_cd == null))
				&& !((aCargo.getMrtl_stat_cd() != null) && aCargo.getMrtl_stat_cd().equals(mrtl_stat_cd))) {
			changedAttributeValue.put("mrtl_stat_cd", aCargo.getMrtl_stat_cd());
		}
		if (!((aCargo.getLang_cd() == null) && (lang_cd == null)) && !((aCargo.getLang_cd() != null) && aCargo.getLang_cd().equals(lang_cd))) {
			changedAttributeValue.put("lang_cd", aCargo.getLang_cd());
		}
		if (!((aCargo.getTrb_mbr_resp() == null) && (trb_mbr_resp == null))
				&& !((aCargo.getTrb_mbr_resp() != null) && aCargo.getTrb_mbr_resp().equals(trb_mbr_resp))) {
			changedAttributeValue.put("trb_mbr_resp", aCargo.getTrb_mbr_resp());
		}
		if (!((aCargo.getChld_trb_mbr_resp() == null) && (chld_trb_mbr_resp == null))
				&& !((aCargo.getChld_trb_mbr_resp() != null) && aCargo.getChld_trb_mbr_resp().equals(chld_trb_mbr_resp))) {
			changedAttributeValue.put("chld_trb_mbr_resp", aCargo.getChld_trb_mbr_resp());
		}
		if (!((aCargo.getUs_ctzn_sw() == null) && (us_ctzn_sw == null))
				&& !((aCargo.getUs_ctzn_sw() != null) && aCargo.getUs_ctzn_sw().equals(us_ctzn_sw))) {
			changedAttributeValue.put("us_ctzn_sw", aCargo.getUs_ctzn_sw());
		}
		if (!((aCargo.getAln_immigr_stat_cd() == null) && (aln_immigr_stat_cd == null))
				&& !((aCargo.getAln_immigr_stat_cd() != null) && aCargo.getAln_immigr_stat_cd().equals(aln_immigr_stat_cd))) {
			changedAttributeValue.put("aln_immigr_stat_cd", aCargo.getAln_immigr_stat_cd());
		}
		if (!((aCargo.getHas_spon_resp() == null) && (has_spon_resp == null))
				&& !((aCargo.getHas_spon_resp() != null) && aCargo.getHas_spon_resp().equals(has_spon_resp))) {
			changedAttributeValue.put("has_spon_resp", aCargo.getHas_spon_resp());
		}
		if (!((aCargo.getSpon_typ() == null) && (spon_typ == null)) && !((aCargo.getSpon_typ() != null) && aCargo.getSpon_typ().equals(spon_typ))) {
			changedAttributeValue.put("spon_typ", aCargo.getSpon_typ());
		}
		if (!((aCargo.getSpon_indv_seq_num() == null) && (spon_indv_seq_num == null))
				&& !((aCargo.getSpon_indv_seq_num() != null) && aCargo.getSpon_indv_seq_num().equals(spon_indv_seq_num))) {
			changedAttributeValue.put("spon_indv_seq_num", aCargo.getSpon_indv_seq_num());
		}
		if (!((aCargo.getOrg_nam() == null) && (org_nam == null)) && !((aCargo.getOrg_nam() != null) && aCargo.getOrg_nam().equals(org_nam))) {
			changedAttributeValue.put("org_nam", aCargo.getOrg_nam());
		}
		if (!((aCargo.getAln_sponser_sw() == null) && (aln_sponser_sw == null))
				&& !((aCargo.getAln_sponser_sw() != null) && aCargo.getAln_sponser_sw().equals(aln_sponser_sw))) {
			changedAttributeValue.put("aln_sponser_sw", aCargo.getAln_sponser_sw());
		}
		if (!((aCargo.getAi_ind() == null) && (ai_ind == null)) && !((aCargo.getAi_ind() != null) && aCargo.getAi_ind().equals(ai_ind))) {
			changedAttributeValue.put("ai_ind", aCargo.getAi_ind());
		}
		if (!((aCargo.getAsia_ind() == null) && (asia_ind == null)) && !((aCargo.getAsia_ind() != null) && aCargo.getAsia_ind().equals(asia_ind))) {
			changedAttributeValue.put("asia_ind", aCargo.getAsia_ind());
		}
		if (!((aCargo.getBlk_ind() == null) && (blk_ind == null)) && !((aCargo.getBlk_ind() != null) && aCargo.getBlk_ind().equals(blk_ind))) {
			changedAttributeValue.put("blk_ind", aCargo.getBlk_ind());
		}
		if (!((aCargo.getPac_isl_ind() == null) && (pac_isl_ind == null))
				&& !((aCargo.getPac_isl_ind() != null) && aCargo.getPac_isl_ind().equals(pac_isl_ind))) {
			changedAttributeValue.put("pac_isl_ind", aCargo.getPac_isl_ind());
		}
		if (!((aCargo.getPreg_resp() == null) && (preg_resp == null))
				&& !((aCargo.getPreg_resp() != null) && aCargo.getPreg_resp().equals(preg_resp))) {
			changedAttributeValue.put("preg_resp", aCargo.getPreg_resp());
		}
		if (!((aCargo.getRes_wi_sw() == null) && (res_wi_sw == null))
				&& !((aCargo.getRes_wi_sw() != null) && aCargo.getRes_wi_sw().equals(res_wi_sw))) {
			changedAttributeValue.put("res_wi_sw", aCargo.getRes_wi_sw());
		}
		if (!((aCargo.getHspc_ind() == null) && (hspc_ind == null)) && !((aCargo.getHspc_ind() != null) && aCargo.getHspc_ind().equals(hspc_ind))) {
			changedAttributeValue.put("hspc_ind", aCargo.getHspc_ind());
		}
		if (!((aCargo.getWht_ind() == null) && (wht_ind == null)) && !((aCargo.getWht_ind() != null) && aCargo.getWht_ind().equals(wht_ind))) {
			changedAttributeValue.put("wht_ind", aCargo.getWht_ind());
		}
		if (!((aCargo.getIntn_res_resp() == null) && (intn_res_resp == null))
				&& !((aCargo.getIntn_res_resp() != null) && aCargo.getIntn_res_resp().equals(intn_res_resp))) {
			changedAttributeValue.put("intn_res_resp", aCargo.getIntn_res_resp());
		}
		if (!((aCargo.getMig_farm_wrkr_sw() == null) && (mig_farm_wrkr_sw == null))
				&& !((aCargo.getMig_farm_wrkr_sw() != null) && aCargo.getMig_farm_wrkr_sw().equals(mig_farm_wrkr_sw))) {
			changedAttributeValue.put("mig_farm_wrkr_sw", aCargo.getMig_farm_wrkr_sw());
		}
		if (!((aCargo.getLeft_home_reason_cd() == null) && (left_home_reason_cd == null))
				&& !((aCargo.getLeft_home_reason_cd() != null) && aCargo.getLeft_home_reason_cd().equals(left_home_reason_cd))) {
			changedAttributeValue.put("left_home_reason_cd", aCargo.getLeft_home_reason_cd());
		}
		/*if (!((aCargo.getMa_ind() == null) && (ma_ind == null)) && !((aCargo.getMa_ind() != null) && aCargo.getMa_ind().equals(ma_ind))) {
			changedAttributeValue.put("ma_ind", aCargo.getMa_ind());
		}
		if (!((aCargo.getSnap_ind() == null) && (snap_ind == null)) && !((aCargo.getSnap_ind() != null) && aCargo.getSnap_ind().equals(snap_ind))) {
			changedAttributeValue.put("snap_ind", aCargo.getSnap_ind());
		}
		if (!((aCargo.getTanf_ind() == null) && (tanf_ind == null)) && !((aCargo.getTanf_ind() != null) && aCargo.getTanf_ind().equals(tanf_ind))) {
			changedAttributeValue.put("tanf_ind", aCargo.getTanf_ind());
		}*/
		if (!((aCargo.getLive_arng_typ() == null) && (live_arng_typ == null))
				&& !((aCargo.getLive_arng_typ() != null) && aCargo.getLive_arng_typ().equals(live_arng_typ))) {
			changedAttributeValue.put("live_arng_typ", aCargo.getLive_arng_typ());
		}
		if (!((aCargo.getNon_hspc_ind() == null) && (non_hspc_ind == null))
				&& !((aCargo.getNon_hspc_ind() != null) && aCargo.getNon_hspc_ind().equals(non_hspc_ind))) {
			changedAttributeValue.put("non_hspc_ind", aCargo.getNon_hspc_ind());
		}
		if (!((aCargo.getVet_resp() == null) && (vet_resp == null)) && !((aCargo.getVet_resp() != null) && aCargo.getVet_resp().equals(vet_resp))) {
			changedAttributeValue.put("vet_resp", aCargo.getVet_resp());
		}
		if (!((aCargo.getVet_act_duty_resp() == null) && (vet_act_duty_resp == null))
				&& !((aCargo.getVet_act_duty_resp() != null) && aCargo.getVet_act_duty_resp().equals(vet_act_duty_resp))) {
			changedAttributeValue.put("vet_act_duty_resp", aCargo.getVet_act_duty_resp());
		}
		if (!((aCargo.getSps_deceased_vet_resp() == null) && (sps_deceased_vet_resp == null))
				&& !((aCargo.getSps_deceased_vet_resp() != null) && aCargo.getSps_deceased_vet_resp().equals(sps_deceased_vet_resp))) {
			changedAttributeValue.put("sps_deceased_vet_resp", aCargo.getSps_deceased_vet_resp());
		}
		if (!((aCargo.getChld_deceased_vet_resp() == null) && (chld_deceased_vet_resp == null))
				&& !((aCargo.getChld_deceased_vet_resp() != null) && aCargo.getChld_deceased_vet_resp().equals(chld_deceased_vet_resp))) {
			changedAttributeValue.put("chld_deceased_vet_resp", aCargo.getChld_deceased_vet_resp());
		}
		if (!((aCargo.getDisable_vet_resp() == null) && (disable_vet_resp == null))
				&& !((aCargo.getDisable_vet_resp() != null) && aCargo.getDisable_vet_resp().equals(disable_vet_resp))) {
			changedAttributeValue.put("disable_vet_resp", aCargo.getDisable_vet_resp());
		}
		if (!((aCargo.getSuffix_name() == null) && (suffix_name == null))
				&& !((aCargo.getSuffix_name() != null) && aCargo.getSuffix_name().equals(suffix_name))) {
			changedAttributeValue.put("suffix_name", aCargo.getSuffix_name());
		}
		if (!((aCargo.getTribe_cd() == null) && (tribe_cd == null)) && !((aCargo.getTribe_cd() != null) && aCargo.getTribe_cd().equals(tribe_cd))) {
			changedAttributeValue.put("tribe_cd", aCargo.getTribe_cd());
		}
		if (!((aCargo.getRes_va_sw() == null) && (res_va_sw == null))
				&& !((aCargo.getRes_va_sw() != null) && aCargo.getRes_va_sw().equals(res_va_sw))) {
			changedAttributeValue.put("res_va_sw", aCargo.getRes_va_sw());
		}
		if (!((aCargo.getPlace_of_birth_cd() == null) && (place_of_birth_cd == null))
				&& !((aCargo.getPlace_of_birth_cd() != null) && aCargo.getPlace_of_birth_cd().equals(place_of_birth_cd))) {
			changedAttributeValue.put("place_of_birth_cd", aCargo.getPlace_of_birth_cd());
		}
		if (!((aCargo.getAlien_num() == null) && (alien_num == null))
				&& !((aCargo.getAlien_num() != null) && aCargo.getAlien_num().equals(alien_num))) {
			changedAttributeValue.put("alien_num", aCargo.getAlien_num());
		}
		if (!((aCargo.getDt_entry_into_us() == null) && (dt_entry_into_us == null))
				&& !((aCargo.getDt_entry_into_us() != null) && aCargo.getDt_entry_into_us().equals(dt_entry_into_us))) {
			changedAttributeValue.put("dt_entry_into_us", aCargo.getDt_entry_into_us());
		}
		if (!((aCargo.getAlien_status_cd() == null) && (alien_status_cd == null))
				&& !((aCargo.getAlien_status_cd() != null) && aCargo.getAlien_status_cd().equals(alien_status_cd))) {
			changedAttributeValue.put("alien_status_cd", aCargo.getAlien_status_cd());
		}
		if (!((aCargo.getExp_back_at_home_dt() == null) && (exp_back_at_home_dt == null))
				&& !((aCargo.getExp_back_at_home_dt() != null) && aCargo.getExp_back_at_home_dt().equals(exp_back_at_home_dt))) {
			changedAttributeValue.put("exp_back_at_home_dt", aCargo.getExp_back_at_home_dt());
		}
		if (!((aCargo.getAbsence_reason_cd() == null) && (absence_reason_cd == null))
				&& !((aCargo.getAbsence_reason_cd() != null) && aCargo.getAbsence_reason_cd().equals(absence_reason_cd))) {
			changedAttributeValue.put("absence_reason_cd", aCargo.getAbsence_reason_cd());
		}
		if (!((aCargo.getChld_out_home_resp() == null) && (chld_out_home_resp == null))
				&& !((aCargo.getChld_out_home_resp() != null) && aCargo.getChld_out_home_resp().equals(chld_out_home_resp))) {
			changedAttributeValue.put("chld_out_home_resp", aCargo.getChld_out_home_resp());
		}
		if (!((aCargo.getDt_leave_facty() == null) && (dt_leave_facty == null))
				&& !((aCargo.getDt_leave_facty() != null) && aCargo.getDt_leave_facty().equals(dt_leave_facty))) {
			changedAttributeValue.put("dt_leave_facty", aCargo.getDt_leave_facty());
		}
		if (!((aCargo.getLang_oth_dsc() == null) && (lang_oth_dsc == null))
				&& !((aCargo.getLang_oth_dsc() != null) && aCargo.getLang_oth_dsc().equals(lang_oth_dsc))) {
			changedAttributeValue.put("lang_oth_dsc", aCargo.getLang_oth_dsc());
		}
		if (!((aCargo.getReq_interp_ind() == null) && (req_interp_ind == null))
				&& !((aCargo.getReq_interp_ind() != null) && aCargo.getReq_interp_ind().equals(req_interp_ind))) {
			changedAttributeValue.put("req_interp_ind", aCargo.getReq_interp_ind());
		}
		if (!((aCargo.getComm_asst_sl_interp_ind() == null) && (comm_asst_sl_interp_ind == null))
				&& !((aCargo.getComm_asst_sl_interp_ind() != null) && aCargo.getComm_asst_sl_interp_ind().equals(comm_asst_sl_interp_ind))) {
			changedAttributeValue.put("comm_asst_sl_interp_ind", aCargo.getComm_asst_sl_interp_ind());
		}
		if (!((aCargo.getComm_asst_fl_interp_ind() == null) && (comm_asst_fl_interp_ind == null))
				&& !((aCargo.getComm_asst_fl_interp_ind() != null) && aCargo.getComm_asst_fl_interp_ind().equals(comm_asst_fl_interp_ind))) {
			changedAttributeValue.put("comm_asst_fl_interp_ind", aCargo.getComm_asst_fl_interp_ind());
		}
		if (!((aCargo.getComm_asst_tty_ind() == null) && (comm_asst_tty_ind == null))
				&& !((aCargo.getComm_asst_tty_ind() != null) && aCargo.getComm_asst_tty_ind().equals(comm_asst_tty_ind))) {
			changedAttributeValue.put("comm_asst_tty_ind", aCargo.getComm_asst_tty_ind());
		}
		if (!((aCargo.getComm_asst_lg_print_ind() == null) && (comm_asst_lg_print_ind == null))
				&& !((aCargo.getComm_asst_lg_print_ind() != null) && aCargo.getComm_asst_lg_print_ind().equals(comm_asst_lg_print_ind))) {
			changedAttributeValue.put("comm_asst_lg_print_ind", aCargo.getComm_asst_lg_print_ind());
		}
		if (!((aCargo.getComm_asst_email_ind() == null) && (comm_asst_email_ind == null))
				&& !((aCargo.getComm_asst_email_ind() != null) && aCargo.getComm_asst_email_ind().equals(comm_asst_email_ind))) {
			changedAttributeValue.put("comm_asst_email_ind", aCargo.getComm_asst_email_ind());
		}
		if (!((aCargo.getComm_asst_none_ind() == null) && (comm_asst_none_ind == null))
				&& !((aCargo.getComm_asst_none_ind() != null) && aCargo.getComm_asst_none_ind().equals(comm_asst_none_ind))) {
			changedAttributeValue.put("comm_asst_none_ind", aCargo.getComm_asst_none_ind());
		}
		if (!((aCargo.getTax_joint_file_ind() == null) && (tax_joint_file_ind == null))
				&& !((aCargo.getTax_joint_file_ind() != null) && aCargo.getTax_joint_file_ind().equals(tax_joint_file_ind))) {
			changedAttributeValue.put("tax_joint_file_ind", aCargo.getTax_joint_file_ind());
		}
		if (!((aCargo.getTax_dp_outside_home_ind() == null) && (tax_dp_outside_home_ind == null))
				&& !((aCargo.getTax_dp_outside_home_ind() != null) && aCargo.getTax_dp_outside_home_ind().equals(tax_dp_outside_home_ind))) {
			changedAttributeValue.put("tax_dp_outside_home_ind", aCargo.getTax_dp_outside_home_ind());
		}
		if (!((aCargo.getLive_at_same_addr_ind() == null) && (live_at_same_addr_ind == null))
				&& !((aCargo.getLive_at_same_addr_ind() != null) && aCargo.getLive_at_same_addr_ind().equals(live_at_same_addr_ind))) {
			changedAttributeValue.put("live_at_same_addr_ind", aCargo.getLive_at_same_addr_ind());
		}
		if (!((aCargo.getAlias_ind() == null) && (alias_ind == null))
				&& !((aCargo.getAlias_ind() != null) && aCargo.getAlias_ind().equals(alias_ind))) {
			changedAttributeValue.put("alias_ind", aCargo.getAlias_ind());
		}
		if (!((aCargo.getAlias_fst_nam() == null) && (alias_fst_nam == null))
				&& !((aCargo.getAlias_fst_nam() != null) && aCargo.getAlias_fst_nam().equals(alias_fst_nam))) {
			changedAttributeValue.put("alias_fst_nam", aCargo.getAlias_fst_nam());
		}
		if (!((aCargo.getAlias_last_nam() == null) && (alias_last_nam == null))
				&& !((aCargo.getAlias_last_nam() != null) && aCargo.getAlias_last_nam().equals(alias_last_nam))) {
			changedAttributeValue.put("alias_last_nam", aCargo.getAlias_last_nam());
		}
		if (!((aCargo.getAlias_mid_init() == null) && (alias_mid_init == null))
				&& !((aCargo.getAlias_mid_init() != null) && aCargo.getAlias_mid_init().equals(alias_mid_init))) {
			changedAttributeValue.put("alias_mid_init", aCargo.getAlias_mid_init());
		}
		if (!((aCargo.getAlias_suffix_name() == null) && (alias_suffix_name == null))
				&& !((aCargo.getAlias_suffix_name() != null) && aCargo.getAlias_suffix_name().equals(alias_suffix_name))) {
			changedAttributeValue.put("alias_suffix_name", aCargo.getAlias_suffix_name());
		}
		if (!((aCargo.getSsn_info_ack_ind() == null) && (ssn_info_ack_ind == null))
				&& !((aCargo.getSsn_info_ack_ind() != null) && aCargo.getSsn_info_ack_ind().equals(ssn_info_ack_ind))) {
			changedAttributeValue.put("ssn_info_ack_ind", aCargo.getSsn_info_ack_ind());
		}

		if (!((aCargo.getHspc_dsc_cd() == null) && (hspc_dsc_cd == null))
				&& !((aCargo.getHspc_dsc_cd() != null) && aCargo.getHspc_dsc_cd().equals(hspc_dsc_cd))) {
			changedAttributeValue.put("hspc_dsc_cd", aCargo.getHspc_dsc_cd());
		}

		if (!((aCargo.getRace_oth_asian_ind() == null) && (race_oth_asian_ind == null))
				&& !((aCargo.getRace_oth_asian_ind() != null) && aCargo.getRace_oth_asian_ind().equals(race_oth_asian_ind))) {
			changedAttributeValue.put("race_oth_asian_ind", aCargo.getRace_oth_asian_ind());
		}
		if (!((aCargo.getIf_out_arrangement() == null) && (if_out_arrangement == null))
				&& !((aCargo.getIf_out_arrangement() != null) && aCargo.getIf_out_arrangement().equals(if_out_arrangement))) {
			changedAttributeValue.put("if_out_arrangement", aCargo.getIf_out_arrangement());
		}

		if (!((aCargo.getRace_samoan_ind() == null) && (race_samoan_ind == null))
				&& !((aCargo.getRace_samoan_ind() != null) && aCargo.getRace_samoan_ind().equals(race_samoan_ind))) {
			changedAttributeValue.put("race_samoan_ind", aCargo.getRace_samoan_ind());
		}
		if (!((aCargo.getRace_filipino_ind() == null) && (race_filipino_ind == null))
				&& !((aCargo.getRace_filipino_ind() != null) && aCargo.getRace_filipino_ind().equals(race_filipino_ind))) {
			changedAttributeValue.put("race_filipino_ind", aCargo.getRace_filipino_ind());
		}
		if (!((aCargo.getRace_chinese_ind() == null) && (race_chinese_ind == null))
				&& !((aCargo.getRace_chinese_ind() != null) && aCargo.getRace_chinese_ind().equals(race_chinese_ind))) {
			changedAttributeValue.put("race_chinese_ind", aCargo.getRace_chinese_ind());
		}
		if (!((aCargo.getRace_vie_ind() == null) && (race_vie_ind == null))
				&& !((aCargo.getRace_vie_ind() != null) && aCargo.getRace_vie_ind().equals(race_vie_ind))) {
			changedAttributeValue.put("race_vie_ind", aCargo.getRace_vie_ind());
		}
		if (!((aCargo.getRace_korean_ind() == null) && (race_korean_ind == null))
				&& !((aCargo.getRace_korean_ind() != null) && aCargo.getRace_korean_ind().equals(race_korean_ind))) {
			changedAttributeValue.put("race_korean_ind", aCargo.getRace_korean_ind());
		}
		if (!((aCargo.getRace_guam_ind() == null) && (race_guam_ind == null))
				&& !((aCargo.getRace_guam_ind() != null) && aCargo.getRace_guam_ind().equals(race_guam_ind))) {
			changedAttributeValue.put("race_guam_ind", aCargo.getRace_guam_ind());
		}
		if (!((aCargo.getRace_oth_ind() == null) && (race_oth_ind == null))
				&& !((aCargo.getRace_oth_ind() != null) && aCargo.getRace_oth_ind().equals(race_oth_ind))) {
			changedAttributeValue.put("race_oth_ind", aCargo.getRace_oth_ind());
		}
		if (!((aCargo.getRace_japanese_ind() == null) && (race_japanese_ind == null))
				&& !((aCargo.getRace_japanese_ind() != null) && aCargo.getRace_japanese_ind().equals(race_japanese_ind))) {
			changedAttributeValue.put("race_japanese_ind", aCargo.getRace_japanese_ind());
		}
		if (!((aCargo.getRace_memb_fed_rec_trb_ind() == null) && (race_memb_fed_rec_trb_ind == null))
				&& !((aCargo.getRace_memb_fed_rec_trb_ind() != null) && aCargo.getRace_memb_fed_rec_trb_ind().equals(race_memb_fed_rec_trb_ind))) {
			changedAttributeValue.put("race_memb_fed_rec_trb_ind", aCargo.getRace_memb_fed_rec_trb_ind());
		}
		if (!((aCargo.getRace_nhpi_ind() == null) && (race_nhpi_ind == null))
				&& !((aCargo.getRace_nhpi_ind() != null) && aCargo.getRace_nhpi_ind().equals(race_nhpi_ind))) {
			changedAttributeValue.put("race_nhpi_ind", aCargo.getRace_nhpi_ind());
		}
		if (!((aCargo.getTribe_name() == null) && (tribe_name == null))
				&& !((aCargo.getTribe_name() != null) && aCargo.getTribe_name().equals(tribe_name))) {
			changedAttributeValue.put("tribe_name", aCargo.getTribe_name());
		}
		if (!((aCargo.getComm_asst_baille_ind() == null) && (comm_asst_baille_ind == null))
				&& !((aCargo.getComm_asst_baille_ind() != null) && aCargo.getComm_asst_baille_ind().equals(comm_asst_baille_ind))) {
			changedAttributeValue.put("comm_asst_baille_ind", aCargo.getComm_asst_baille_ind());
		}
		if (!((aCargo.getComm_asst_vedrel_ind() == null) && (comm_asst_vedrel_ind == null))
				&& !((aCargo.getComm_asst_vedrel_ind() != null) && aCargo.getComm_asst_vedrel_ind().equals(comm_asst_vedrel_ind))) {
			changedAttributeValue.put("comm_asst_vedrel_ind", aCargo.getComm_asst_vedrel_ind());
		}
		if (!((aCargo.getInter_oth_dsc() == null) && (inter_oth_dsc == null))
				&& !((aCargo.getInter_oth_dsc() != null) && aCargo.getInter_oth_dsc().equals(inter_oth_dsc))) {
			changedAttributeValue.put("inter_oth_dsc", aCargo.getInter_oth_dsc());
		}

		if (!((aCargo.getIsBreastCancerDiagnosed() == null) && (isBreastCancerDiagnosed == null))
				&& !((aCargo.getIsBreastCancerDiagnosed() != null) && aCargo.getIsBreastCancerDiagnosed().equals(isBreastCancerDiagnosed))) {
			changedAttributeValue.put("isBreastCancerDiagnosed", aCargo.getIsBreastCancerDiagnosed());
		}
		if (!((aCargo.getDateOfDiagnosis() == null) && (dateOfDiagnosis == null))
				&& !((aCargo.getDateOfDiagnosis() != null) && aCargo.getDateOfDiagnosis().equals(dateOfDiagnosis))) {
			changedAttributeValue.put("dateOfDiagnosis", aCargo.getDateOfDiagnosis());
		}
		/*if (!((aCargo.getCc_ind() == null) && (cc_ind == null)) && !((aCargo.getCc_ind() != null) && aCargo.getCc_ind().equals(cc_ind))) {
			changedAttributeValue.put("cc_ind", aCargo.getCc_ind());
		}
		if (!((aCargo.getWic_ind() == null) && (wic_ind == null)) && !((aCargo.getWic_ind() != null) && aCargo.getWic_ind().equals(wic_ind))) {
			changedAttributeValue.put("wic_ind", aCargo.getWic_ind());
		}*/
		if (!((aCargo.getBlnd_dabl_ind() == null) && (blnd_dabl_ind == null))
				&& !((aCargo.getBlnd_dabl_ind() != null) && aCargo.getBlnd_dabl_ind().equals(blnd_dabl_ind))) {
			changedAttributeValue.put("blnd_dabl_ind", aCargo.getBlnd_dabl_ind());
		}
		if (!((aCargo.getAlien_doc_cd() == null) && (alien_doc_cd == null))
				&& !((aCargo.getAlien_doc_cd() != null) && aCargo.getAlien_doc_cd().equals(alien_doc_cd))) {
			changedAttributeValue.put("alien_doc_cd", aCargo.getAlien_doc_cd());
		}
		if (!((aCargo.getRes_ga_ind() == null) && (res_ga_ind == null))
				&& !((aCargo.getRes_ga_ind() != null) && aCargo.getRes_ga_ind().equals(res_ga_ind))) {
			changedAttributeValue.put("res_ga_ind", aCargo.getRes_ga_ind());
		}
		if (!((aCargo.getDisabled_resp() == null) && (disabled_resp == null))
				&& !((aCargo.getDisabled_resp() != null) && aCargo.getDisabled_resp().equals(disabled_resp))) {
			changedAttributeValue.put("disabled_resp", aCargo.getDisabled_resp());
		}
		if (!((aCargo.getChld_pa_act_duty_resp() == null) && (chld_pa_act_duty_resp == null))
				&& !((aCargo.getChld_pa_act_duty_resp() != null) && aCargo.getChld_pa_act_duty_resp().equals(chld_pa_act_duty_resp))) {
			changedAttributeValue.put("chld_pa_act_duty_resp", aCargo.getChld_pa_act_duty_resp());
		}
		if (!((aCargo.getTax_filing_status() == null) && (tax_filing_status == null))
				&& !((aCargo.getTax_filing_status() != null) && aCargo.getTax_filing_status().equals(tax_filing_status))) {
			changedAttributeValue.put("tax_filing_status", aCargo.getTax_filing_status());
		}
		if (!((aCargo.getSs_num_app_dt() == null) && (ss_num_app_dt == null))
				&& !((aCargo.getSs_num_app_dt() != null) && aCargo.getSs_num_app_dt().equals(ss_num_app_dt))) {
			changedAttributeValue.put("ss_num_app_dt", aCargo.getSs_num_app_dt());
		}
		if (!((aCargo.getLiving_arrangement_cd() == null) && (living_arrangement_cd == null))
				&& !((aCargo.getLiving_arrangement_cd() != null) && aCargo.getLiving_arrangement_cd().equals(living_arrangement_cd))) {
			changedAttributeValue.put("living_arrangement_cd", aCargo.getLiving_arrangement_cd());
		}
		if (!((aCargo.getRace_persian_ind() == null) && (race_persian_ind == null))
				&& !((aCargo.getRace_persian_ind() != null) && aCargo.getRace_persian_ind().equals(race_persian_ind))) {
			changedAttributeValue.put("race_persian_ind", aCargo.getRace_persian_ind());
		}
		if (!((aCargo.getRace_eastasian_ind() == null) && (race_eastasian_ind == null))
				&& !((aCargo.getRace_eastasian_ind() != null) && aCargo.getRace_eastasian_ind().equals(race_eastasian_ind))) {
			changedAttributeValue.put("race_eastasian_ind", aCargo.getRace_eastasian_ind());
		}
		if (!((aCargo.getRace_unknown_ind() == null) && (race_unknown_ind == null))
				&& !((aCargo.getRace_unknown_ind() != null) && aCargo.getRace_unknown_ind().equals(race_unknown_ind))) {
			changedAttributeValue.put("race_unknown_ind", aCargo.getRace_unknown_ind());
		}
		if (!((aCargo.getVld_immgrtn_sts() == null) && (vld_immgrtn_sts == null))
				&& !((aCargo.getVld_immgrtn_sts() != null) && aCargo.getVld_immgrtn_sts().equals(vld_immgrtn_sts))) {
			changedAttributeValue.put("vld_immgrtn_sts", aCargo.getVld_immgrtn_sts());
		}
		if(!(aCargo.getChg_dt()==null && this.chg_dt==null) && !(aCargo.getChg_dt()!=null && aCargo.getChg_dt().equals(this.chg_dt))) changedAttributeValue.put("chg_dt",aCargo.getChg_dt());
		if (!(aCargo.getWic_clnc_cnty() == null && this.wic_clnc_cnty == null)
				&& !(aCargo.getWic_clnc_cnty() != null && aCargo
						.getWic_clnc_cnty().equals(this.wic_clnc_cnty)))
			changedAttributeValue.put("wic_clnc_cnty",
					aCargo.getWic_clnc_cnty());
		if (!(aCargo.getWic_clnc_cd() == null && this.wic_clnc_cd == null)
				&& !(aCargo.getWic_clnc_cd() != null && aCargo.getWic_clnc_cd()
						.equals(this.wic_clnc_cd)))
			changedAttributeValue.put("wic_clnc_cd", aCargo.getWic_clnc_cd());
		if(!(aCargo.getTax_flr_otsd_ind()==null && this.tax_flr_otsd_ind==null) && !(aCargo.getTax_flr_otsd_ind()!=null && aCargo.getTax_flr_otsd_ind().equals(this.tax_flr_otsd_ind))) changedAttributeValue.put("tax_flr_otsd_ind",aCargo.getTax_flr_otsd_ind());
		return changedAttributeValue;

	}

	public Map compareDiagnosisAttributes(final AppIndvCargo aCargo) {
		final Map changedAttributeValue = new HashMap();
		if (!((aCargo.getIsBreastCancerDiagnosed() == null) && (isBreastCancerDiagnosed == null))
				&& !((aCargo.getIsBreastCancerDiagnosed() != null) && aCargo.getIsBreastCancerDiagnosed().equals(isBreastCancerDiagnosed))) {
			changedAttributeValue.put("isBreastCancerDiagnosed", aCargo.getIsBreastCancerDiagnosed());
		}
		if (!((aCargo.getDateOfDiagnosis() == null) && (dateOfDiagnosis == null))
				&& !((aCargo.getDateOfDiagnosis() != null) && aCargo.getDateOfDiagnosis().equals(dateOfDiagnosis))) {
			changedAttributeValue.put("dateOfDiagnosis", aCargo.getDateOfDiagnosis());
		}

		return changedAttributeValue;
	}

	/**
	 * @return the bst_cncr_ecp_id
	 */
	public String getBst_cncr_ecp_id() {
		return bst_cncr_ecp_id;
	}

	/**
	 * @param bst_cncr_ecp_id the bst_cncr_ecp_id to set
	 */
	public void setBst_cncr_ecp_id(final String bst_cncr_ecp_id) {
		this.bst_cncr_ecp_id = bst_cncr_ecp_id;
	}

}
