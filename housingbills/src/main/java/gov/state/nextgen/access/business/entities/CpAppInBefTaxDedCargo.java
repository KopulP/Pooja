package gov.state.nextgen.access.business.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CP_APP_IN_BEF_TAX_DED")
public class CpAppInBefTaxDedCargo  implements Serializable{

	@EmbeddedId
	private CpAppInBefTaxDedPrimaryKey cpAppInBefTaxDedPrimaryKey;
	
	@Transient
	boolean isDirty = false;
	
	private String src_app_ind;
	private String ecp_id;
	private String btd_end_dt;
	private String medical_ins;
	private String dental_ins;
	private String vision_ins;
	private String flexi_spend_account;
	private String deferred_comp;
	private String pre_tax_life_ins;
	private String other_exp;
	private String chg_dt;
	
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



	/**
	 *returns the src_app_ind value.
	 */
	public String getSrc_app_ind() {
		return src_app_ind;
	}

	/**
	 *returns the ecp_id value.
	 */
	public String getEcp_id() {
		return ecp_id;
	}

	/**
	 *returns the btd_end_dt value.
	 */
	public String getBtd_end_dt() {
		return btd_end_dt;
	}


	/**
	 *sets the src_app_ind value.
	 */
	public void setSrc_app_ind(final String src_app_ind) {
		this.src_app_ind = src_app_ind;
	}

	/**
	 *sets the ecp_id value.
	 */
	public void setEcp_id(final String ecp_id) {
		this.ecp_id = ecp_id;
	}

	/**
	 *sets the btd_end_dt value.
	 */
	public void setBtd_end_dt(final String btd_end_dt) {
		this.btd_end_dt = btd_end_dt;
	}

	public String getMedical_ins() {
		return medical_ins;
	}

	public String getDental_ins() {
		return dental_ins;
	}

	public String getVision_ins() {
		return vision_ins;
	}

	public String getFlexi_spend_account() {
		return flexi_spend_account;
	}

	public String getDeferred_comp() {
		return deferred_comp;
	}

	public String getPre_tax_life_ins() {
		return pre_tax_life_ins;
	}

	public String getOther_exp() {
		return other_exp;
	}

	public void setMedical_ins(final String medical_ins) {
		this.medical_ins = medical_ins;
	}

	public void setDental_ins(final String dental_ins) {
		this.dental_ins = dental_ins;
	}

	public void setVision_ins(final String vision_ins) {
		this.vision_ins = vision_ins;
	}

	public void setFlexi_spend_account(final String flexi_spend_account) {
		this.flexi_spend_account = flexi_spend_account;
	}

	public void setDeferred_comp(final String deferred_comp) {
		this.deferred_comp = deferred_comp;
	}

	public void setPre_tax_life_ins(final String pre_tax_life_ins) {
		this.pre_tax_life_ins = pre_tax_life_ins;
	}

	public void setOther_exp(final String other_exp) {
		this.other_exp = other_exp;
	}

	}
