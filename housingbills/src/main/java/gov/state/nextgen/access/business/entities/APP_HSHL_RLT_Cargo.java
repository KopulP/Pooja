/*
 * 
 */
package gov.state.nextgen.access.business.entities;

import java.util.HashMap;
import java.util.Map;
	
/**
 * This java bean contains the entities of APP_HSHL_RLT
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date Mon Mar 05 13:56:39 CST 2007 Modified By: Modified on: PCR#
 */
public class APP_HSHL_RLT_Cargo extends AbstractCargo implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	boolean isDirty = false;
	private String app_num;
	private String ref_indv_seq_num;
	private String src_indv_seq_num;
	private String src_app_ind;
	private String care_resp;
	private String chg_eff_dt;
	private String pnp_tghr_sw;
	private String rec_cplt_ind;
	private String rlt_cd;
	private String phy_boe_sep_sw;
	private String tax_dpnd_resp;
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

	public String getTax_dpnd_resp() {
		return tax_dpnd_resp;
	}

	public void setTax_dpnd_resp(final String tax_dpnd_resp) {
		this.tax_dpnd_resp = tax_dpnd_resp;
	}

	/**
	 * returns the app_num value.
	 */
	public String getApp_num() {
		return app_num;
	}

	/**
	 * sets the app_num value.
	 */
	public void setApp_num(final String app_num) {
		this.app_num = app_num;
	}

	/**
	 * returns the ref_indv_seq_num value.
	 */
	public String getRef_indv_seq_num() {
		return ref_indv_seq_num;
	}

	/**
	 * sets the ref_indv_seq_num value.
	 */
	public void setRef_indv_seq_num(final String ref_indv_seq_num) {
		this.ref_indv_seq_num = ref_indv_seq_num;
	}

	/**
	 * returns the src_indv_seq_num value.
	 */
	public String getSrc_indv_seq_num() {
		return src_indv_seq_num;
	}

	/**
	 * sets the src_indv_seq_num value.
	 */
	public void setSrc_indv_seq_num(final String src_indv_seq_num) {
		this.src_indv_seq_num = src_indv_seq_num;
	}

	/**
	 * returns the src_app_ind value.
	 */
	public String getSrc_app_ind() {
		return src_app_ind;
	}

	/**
	 * sets the src_app_ind value.
	 */
	public void setSrc_app_ind(final String src_app_ind) {
		this.src_app_ind = src_app_ind;
	}

	/**
	 * returns the care_resp value.
	 */
	public String getCare_resp() {
		return care_resp;
	}

	/**
	 * sets the care_resp value.
	 */
	public void setCare_resp(final String care_resp) {
		this.care_resp = care_resp;
	}

	/**
	 * returns the chg_eff_dt value.
	 */
	public String getChg_eff_dt() {
		return chg_eff_dt;
	}

	/**
	 * sets the chg_eff_dt value.
	 */
	public void setChg_eff_dt(final String chg_eff_dt) {
		this.chg_eff_dt = chg_eff_dt;
	}

	/**
	 * returns the pnp_tghr_sw value.
	 */
	public String getPnp_tghr_sw() {
		return pnp_tghr_sw;
	}

	/**
	 * sets the pnp_tghr_sw value.
	 */
	public void setPnp_tghr_sw(final String pnp_tghr_sw) {
		this.pnp_tghr_sw = pnp_tghr_sw;
	}

	/**
	 * returns the rec_cplt_ind value.
	 */
	public String getRec_cplt_ind() {
		return rec_cplt_ind;
	}

	/**
	 * sets the rec_cplt_ind value.
	 */
	public void setRec_cplt_ind(final String rec_cplt_ind) {
		this.rec_cplt_ind = rec_cplt_ind;
	}

	/**
	 * returns the rlt_cd value.
	 */
	public String getRlt_cd() {
		return rlt_cd;
	}

	/**
	 * sets the rlt_cd value.
	 */
	public void setRlt_cd(final String rlt_cd) {
		this.rlt_cd = rlt_cd;
	}

	/**
	 * returns the phy_boe_sep_sw value.
	 */
	public String getPhy_boe_sep_sw() {
		return phy_boe_sep_sw;
	}

	/**
	 * sets the phy_boe_sep_sw value.
	 */
	public void setPhy_boe_sep_sw(final String phy_boe_sep_sw) {
		this.phy_boe_sep_sw = phy_boe_sep_sw;
	}

	/**
	 * returns the string value of cargo.
	 */
	@Override
	public String inspectCargo() {
		return new StringBuilder().append("APP_HSHL_RLT: ").append("app_num=").append(app_num).append("ref_indv_seq_num=").append(ref_indv_seq_num)
				.append("src_indv_seq_num=").append(src_indv_seq_num).append("src_app_ind=").append(src_app_ind).append("care_resp=")
				.append(care_resp).append("chg_eff_dt=").append(chg_eff_dt).append("pnp_tghr_sw=").append(pnp_tghr_sw).append("rec_cplt_ind=")
				.append(rec_cplt_ind).append("rlt_cd=").append(rlt_cd).append("phy_boe_sep_sw=").append(phy_boe_sep_sw).append(" chg_dt= ").append(chg_dt).toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((app_num == null) ? 0 : app_num.trim().hashCode());
		result = (prime * result) + ((care_resp == null) ? 0 : care_resp.trim().hashCode());
		result = (prime * result) + ((chg_eff_dt == null) ? 0 : chg_eff_dt.trim().hashCode());
		result = (prime * result) + ((phy_boe_sep_sw == null) ? 0 : phy_boe_sep_sw.trim().hashCode());
		result = (prime * result) + ((pnp_tghr_sw == null) ? 0 : pnp_tghr_sw.trim().hashCode());
		result = (prime * result) + ((rec_cplt_ind == null) ? 0 : rec_cplt_ind.trim().hashCode());
		result = (prime * result) + ((ref_indv_seq_num == null) ? 0 : ref_indv_seq_num.trim().hashCode());
		result = (prime * result) + ((rlt_cd == null) ? 0 : rlt_cd.trim().hashCode());
		result = (prime * result) + ((src_app_ind == null) ? 0 : src_app_ind.trim().hashCode());
		result = (prime * result) + ((src_indv_seq_num == null) ? 0 : src_indv_seq_num.trim().hashCode());
		result = (prime * result) + ((tax_dpnd_resp == null) ? 0 : tax_dpnd_resp.trim().hashCode());
		result = (prime * result) + ((chg_dt == null) ? 0 : chg_dt.trim().hashCode());
		return result;
	}

	/**
	 * returns the PrimaryKey object.
	 */
	@Override
	public IPrimaryKey getPrimaryKey() {
		final APP_HSHL_RLT_PrimaryKey key = new APP_HSHL_RLT_PrimaryKey();
		key.setApp_num(getApp_num());
		key.setRef_indv_seq_num(getRef_indv_seq_num());
		key.setSrc_indv_seq_num(getSrc_indv_seq_num());
		key.setSrc_app_ind(getSrc_app_ind());
		return key;
	}

	/**
	 * compares the given cargo with this cargo and returns the changed
	 * attribute-value Map.
	 */
	public Map compareAttributes(final APP_HSHL_RLT_Cargo aCargo) {
		final Map changedAttributeValue = new HashMap();
		if (!((aCargo.getApp_num() == null) && (app_num == null)) && !((aCargo.getApp_num() != null) && aCargo.getApp_num().equals(app_num))) {
			changedAttributeValue.put("app_num", aCargo.getApp_num());
		}
		if (!((aCargo.getRef_indv_seq_num() == null) && (ref_indv_seq_num == null))
				&& !((aCargo.getRef_indv_seq_num() != null) && aCargo.getRef_indv_seq_num().equals(ref_indv_seq_num))) {
			changedAttributeValue.put("ref_indv_seq_num", aCargo.getRef_indv_seq_num());
		}
		if (!((aCargo.getSrc_indv_seq_num() == null) && (src_indv_seq_num == null))
				&& !((aCargo.getSrc_indv_seq_num() != null) && aCargo.getSrc_indv_seq_num().equals(src_indv_seq_num))) {
			changedAttributeValue.put("src_indv_seq_num", aCargo.getSrc_indv_seq_num());
		}
		if (!((aCargo.getSrc_app_ind() == null) && (src_app_ind == null))
				&& !((aCargo.getSrc_app_ind() != null) && aCargo.getSrc_app_ind().equals(src_app_ind))) {
			changedAttributeValue.put("src_app_ind", aCargo.getSrc_app_ind());
		}
		if (!((aCargo.getCare_resp() == null) && (care_resp == null))
				&& !((aCargo.getCare_resp() != null) && aCargo.getCare_resp().equals(care_resp))) {
			changedAttributeValue.put("care_resp", aCargo.getCare_resp());
		}
		if (!((aCargo.getChg_eff_dt() == null) && (chg_eff_dt == null))
				&& !((aCargo.getChg_eff_dt() != null) && aCargo.getChg_eff_dt().equals(chg_eff_dt))) {
			changedAttributeValue.put("chg_eff_dt", aCargo.getChg_eff_dt());
		}
//		if (!((aCargo.getPnp_tghr_sw() == null) && (pnp_tghr_sw == null))
//				&& !((aCargo.getPnp_tghr_sw() != null) && aCargo.getPnp_tghr_sw().equals(pnp_tghr_sw))) {
//			changedAttributeValue.put("pnp_tghr_sw", aCargo.getPnp_tghr_sw());
//		}
		if (!((aCargo.getRec_cplt_ind() == null) && (rec_cplt_ind == null))
				&& !((aCargo.getRec_cplt_ind() != null) && aCargo.getRec_cplt_ind().equals(rec_cplt_ind))) {
			changedAttributeValue.put("rec_cplt_ind", aCargo.getRec_cplt_ind());
		}
		if (!((aCargo.getRlt_cd() == null) && (rlt_cd == null)) && !((aCargo.getRlt_cd() != null) && aCargo.getRlt_cd().equals(rlt_cd))) {
			changedAttributeValue.put("rlt_cd", aCargo.getRlt_cd());
		}
		if (!((aCargo.getPhy_boe_sep_sw() == null) && (phy_boe_sep_sw == null))
				&& !((aCargo.getPhy_boe_sep_sw() != null) && aCargo.getPhy_boe_sep_sw().equals(phy_boe_sep_sw))) {
			changedAttributeValue.put("phy_boe_sep_sw", aCargo.getPhy_boe_sep_sw());
		}
		if (!((aCargo.getTax_dpnd_resp() == null) && (tax_dpnd_resp == null))
				&& !((aCargo.getTax_dpnd_resp() != null) && aCargo.getTax_dpnd_resp().equals(tax_dpnd_resp))) {
			changedAttributeValue.put("tax_dpnd_resp", aCargo.getTax_dpnd_resp());
		}
		if(!(aCargo.getChg_dt()==null && this.chg_dt==null) && !(aCargo.getChg_dt()!=null && aCargo.getChg_dt().equals(this.chg_dt))) changedAttributeValue.put("chg_dt",aCargo.getChg_dt());

		return changedAttributeValue;
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
		final APP_HSHL_RLT_Cargo other = (APP_HSHL_RLT_Cargo) obj;
		if (app_num == null) {
			if (other.app_num != null) {
				return false;
			}
		} else if (!app_num.equals(other.app_num)) {
			return false;
		}
		if (care_resp == null) {
			if (other.care_resp != null) {
				return false;
			}
		} else if (!care_resp.equals(other.care_resp)) {
			return false;
		}
		if (chg_eff_dt == null) {
			if (other.chg_eff_dt != null) {
				return false;
			}
		} else if (!chg_eff_dt.equals(other.chg_eff_dt)) {
			return false;
		}
		if (phy_boe_sep_sw == null) {
			if (other.phy_boe_sep_sw != null) {
				return false;
			}
		} else if (!phy_boe_sep_sw.equals(other.phy_boe_sep_sw)) {
			return false;
		}
//		if (pnp_tghr_sw == null) {
//			if (other.pnp_tghr_sw != null) {
//				return false;
//			}
//		} else if (!pnp_tghr_sw.equals(other.pnp_tghr_sw)) {
//			return false;
//		}
		if (rec_cplt_ind == null) {
			if (other.rec_cplt_ind != null) {
				return false;
			}
		} else if (!rec_cplt_ind.equals(other.rec_cplt_ind)) {
			return false;
		}
		if (ref_indv_seq_num == null) {
			if (other.ref_indv_seq_num != null) {
				return false;
			}
		} else if (!ref_indv_seq_num.equals(other.ref_indv_seq_num)) {
			return false;
		}
		if (rlt_cd == null) {
			if (other.rlt_cd != null) {
				return false;
			}
		} else if (!rlt_cd.equals(other.rlt_cd)) {
			return false;
		}
		if (src_app_ind == null) {
			if (other.src_app_ind != null) {
				return false;
			}
		} else if (!src_app_ind.equals(other.src_app_ind)) {
			return false;
		}
		if (src_indv_seq_num == null) {
			if (other.src_indv_seq_num != null) {
				return false;
			}
		} else if (!src_indv_seq_num.equals(other.src_indv_seq_num)) {
			return false;
		}
		if (tax_dpnd_resp == null) {
			if (other.tax_dpnd_resp != null) {
				return false;
			}
		} else if (!tax_dpnd_resp.equals(other.tax_dpnd_resp)) {
			return false;
		}
		return true;
	}

}
