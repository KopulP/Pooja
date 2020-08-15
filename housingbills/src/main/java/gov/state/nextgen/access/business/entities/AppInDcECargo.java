package gov.state.nextgen.access.business.entities;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "APP_IN_DC_E")
public class AppInDcECargo extends AbstractCargo implements java.io.Serializable, IHistoryType6{

	/**
	 *
	 */
	
	@EmbeddedId
	private AppInDcEPrimaryKey key;
	private static final long serialVersionUID = 1L;

	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.APP_IN_DC_E";

	boolean isDirty = false;
	private String ecp_id;
	private java.lang.String dpnd_care_exp_amt;
	private java.lang.String dpnd_care_exp_ind;
	private java.lang.String dpnd_exp_paid_amt;
	private java.lang.String dpnd_exp_paid_ind;
	private java.lang.String paid_in_seq_num;
	private java.lang.String prvd_fst_nam;
	private java.lang.String prvd_in_seq_num;
	private java.lang.String prvd_last_nam;
	private java.lang.String prvd_org_nam;
	private java.lang.String prvd_typ;
	private java.lang.String rec_cplt_ind;
	private java.lang.String prvd_nam_org_ind;
	private java.lang.String prvd_nam_ind;
	private String pay_freq;// added by ggr
	private String src_app_ind;// EDSP CP added
	private String chg_eff_dt;
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

	public String getChg_eff_dt() {
		return chg_eff_dt;
	}

	public void setChg_eff_dt(final String chg_eff_dt) {
		this.chg_eff_dt = chg_eff_dt;
	}

	/**
	 *
	 * Returns the package name.
	 *
	 * Creation Date Mon Jan 23 13:28:43 CST 2006
	 * @return gov.state.nextgen.access.business.entities.AppInDcECargo
	 */
	public String getPackage() {
		return PACKAGE;
	}

	/**
	 * Returns the primary key values of a cargo
	 *
	 * Creation Date Mon Jan 23 13:28:43 CST 2006
	 * @return java.lang.String
	 */

	
	public IPrimaryKey getPrimaryKey() {
		
		return key;
	}

	/**
	 * Inspects Cargo values for debug.
	 *
	 * Creation Date Mon Jan 23 13:28:43 CST 2006
	 * @return java.lang.String
	 */
	@Override
	public String inspectCargo() {
		return "APP_IN_DC_E: " + " ecp_id = " + ecp_id + ", " + "dpnd_care_exp_amt=" + dpnd_care_exp_amt + "," + "dpnd_care_exp_ind=" + dpnd_care_exp_ind + ","
				+ "dpnd_exp_paid_amt=" + dpnd_exp_paid_amt + "," + "dpnd_exp_paid_ind=" + dpnd_exp_paid_ind + "," + "paid_in_seq_num="
				+ paid_in_seq_num + "," + "prvd_fst_nam=" + prvd_fst_nam + "," + "prvd_in_seq_num=" + prvd_in_seq_num + "," + "prvd_last_nam="
				+ prvd_last_nam + "," + "prvd_org_nam=" + prvd_org_nam + "," + "prvd_typ=" + prvd_typ + "," + "rec_cplt_ind=" + rec_cplt_ind + ","
				+ "prvd_nam_org_ind=" + prvd_nam_org_ind + "," + "prvd_nam_ind=" + prvd_nam_ind + "," + "pay_freq=" + pay_freq +" chg_dt= "+chg_dt;
	}

	public Map compareAttributes(final AppInDcECargo aCargo) {
		final Map changedAttributeValue = new HashMap();
		
		if (!((aCargo.getSrc_app_ind() == null) && (src_app_ind == null))
				&& !((aCargo.getSrc_app_ind() != null) && aCargo.getSrc_app_ind().equals(src_app_ind))) {
			changedAttributeValue.put("src_app_ind", aCargo.getSrc_app_ind());
		}
		if (!((aCargo.getChg_eff_dt() == null) && (chg_eff_dt == null))
				&& !((aCargo.getChg_eff_dt() != null) && aCargo.getChg_eff_dt().equals(chg_eff_dt))) {
			changedAttributeValue.put("chg_eff_dt", aCargo.getChg_eff_dt());
		}
		if (!((aCargo.getDpnd_care_exp_amt() == null) && (dpnd_care_exp_amt == null))
				&& !((aCargo.getDpnd_care_exp_amt() != null) && aCargo.getDpnd_care_exp_amt().equals(getDpnd_care_exp_amt()))) {
			changedAttributeValue.put("dpnd_care_exp_amt", aCargo.getDpnd_care_exp_amt());
		}
		if (!((aCargo.getDpnd_exp_paid_amt() == null) && (dpnd_exp_paid_amt == null))
				&& !((aCargo.getDpnd_exp_paid_amt() != null) && aCargo.getDpnd_exp_paid_amt().equals(getDpnd_exp_paid_amt()))) {
			changedAttributeValue.put("dpnd_exp_paid_amt", aCargo.getDpnd_exp_paid_amt());
		}
		if (!((aCargo.getPrvd_typ() == null) && (prvd_typ == null))
				&& !((aCargo.getPrvd_typ() != null) && (prvd_typ != null) && aCargo.getPrvd_typ().trim().equals(prvd_typ.trim()))) {
			changedAttributeValue.put("prvd_typ", aCargo.getPrvd_typ());
		}
		if (!((aCargo.getPrvd_fst_nam() == null) && (prvd_fst_nam == null))
				&& !((aCargo.getPrvd_fst_nam() != null) && (prvd_fst_nam != null) && aCargo.getPrvd_fst_nam().trim().equals(prvd_fst_nam.trim()))) {
			changedAttributeValue.put("prvd_frst_nam", aCargo.getPrvd_fst_nam());
		}
		if (!((aCargo.getPrvd_last_nam() == null) && (prvd_last_nam == null))
				&& !((aCargo.getPrvd_last_nam() != null) && (prvd_last_nam != null) && aCargo.getPrvd_last_nam().trim().equals(prvd_last_nam.trim()))) {
			changedAttributeValue.put("prvd_last_nam", aCargo.getPrvd_last_nam());
		}
		if (!((aCargo.getPay_freq() == null) && (pay_freq == null))
				&& !((aCargo.getPay_freq() != null) && (pay_freq != null) && aCargo.getPay_freq().trim().equals(pay_freq))) {
			changedAttributeValue.put("pay_freq", aCargo.getPay_freq());
		}
		if(!(aCargo.getChg_dt()==null && this.chg_dt==null) && !(aCargo.getChg_dt()!=null && aCargo.getChg_dt().equals(this.chg_dt))) changedAttributeValue.put("chg_dt",aCargo.getChg_dt());
		return changedAttributeValue;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((chg_eff_dt == null) ? 0 : chg_eff_dt.trim().hashCode());
		result = (prime * result) + ((dpnd_care_exp_amt == null) ? 0 : dpnd_care_exp_amt.trim().hashCode());
		result = (prime * result) + ((dpnd_care_exp_ind == null) ? 0 : dpnd_care_exp_ind.trim().hashCode());
		result = (prime * result) + ((dpnd_exp_paid_amt == null) ? 0 : dpnd_exp_paid_amt.trim().hashCode());
		result = (prime * result) + ((dpnd_exp_paid_ind == null) ? 0 : dpnd_exp_paid_ind.trim().hashCode());
		result = (prime * result) + ((paid_in_seq_num == null) ? 0 : paid_in_seq_num.trim().hashCode());
		result = (prime * result) + ((pay_freq == null) ? 0 : pay_freq.trim().hashCode());
		result = (prime * result) + ((prvd_fst_nam == null) ? 0 : prvd_fst_nam.trim().hashCode());
		result = (prime * result) + ((prvd_in_seq_num == null) ? 0 : prvd_in_seq_num.trim().hashCode());
		result = (prime * result) + ((prvd_last_nam == null) ? 0 : prvd_last_nam.trim().hashCode());
		result = (prime * result) + ((prvd_nam_ind == null) ? 0 : prvd_nam_ind.trim().hashCode());
		result = (prime * result) + ((prvd_nam_org_ind == null) ? 0 : prvd_nam_org_ind.trim().hashCode());
		result = (prime * result) + ((prvd_org_nam == null) ? 0 : prvd_org_nam.trim().hashCode());
		result = (prime * result) + ((prvd_typ == null) ? 0 : prvd_typ.trim().hashCode());
		result = (prime * result) + ((rec_cplt_ind == null) ? 0 : rec_cplt_ind.trim().hashCode());
		result = (prime * result) + ((chg_dt == null) ? 0 : chg_dt.trim().hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
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
		final AppInDcECargo other = (AppInDcECargo) obj;
		
		if (chg_eff_dt == null) {
			if (other.chg_eff_dt != null) {
				return false;
			}
		} else if (!chg_eff_dt.equals(other.chg_eff_dt)) {
			return false;
		}
		if (dpnd_care_exp_amt == null) {
			if (other.dpnd_care_exp_amt != null) {
				return false;
			}
		} else if (!dpnd_care_exp_amt.equals(other.dpnd_care_exp_amt)) {
			return false;
		}
		if (dpnd_care_exp_ind == null) {
			if (other.dpnd_care_exp_ind != null) {
				return false;
			}
		} else if (!dpnd_care_exp_ind.equals(other.dpnd_care_exp_ind)) {
			return false;
		}
		if (dpnd_exp_paid_amt == null) {
			if (other.dpnd_exp_paid_amt != null) {
				return false;
			}
		} else if (!dpnd_exp_paid_amt.equals(other.dpnd_exp_paid_amt)) {
			return false;
		}
		if (dpnd_exp_paid_ind == null) {
			if (other.dpnd_exp_paid_ind != null) {
				return false;
			}
		} else if (!dpnd_exp_paid_ind.equals(other.dpnd_exp_paid_ind)) {
			return false;
		}
		
		if (paid_in_seq_num == null) {
			if (other.paid_in_seq_num != null) {
				return false;
			}
		} else if (!paid_in_seq_num.equals(other.paid_in_seq_num)) {
			return false;
		}
		if (pay_freq == null) {
			if (other.pay_freq != null) {
				return false;
			}
		} else if (!pay_freq.equals(other.pay_freq)) {
			return false;
		}
		if (prvd_fst_nam == null) {
			if (other.prvd_fst_nam != null) {
				return false;
			}
		} else if (!prvd_fst_nam.equals(other.prvd_fst_nam)) {
			return false;
		}
		if (prvd_in_seq_num == null) {
			if (other.prvd_in_seq_num != null) {
				return false;
			}
		} else if (!prvd_in_seq_num.equals(other.prvd_in_seq_num)) {
			return false;
		}
		if (prvd_last_nam == null) {
			if (other.prvd_last_nam != null) {
				return false;
			}
		} else if (!prvd_last_nam.equals(other.prvd_last_nam)) {
			return false;
		}
		if (prvd_nam_ind == null) {
			if (other.prvd_nam_ind != null) {
				return false;
			}
		} else if (!prvd_nam_ind.equals(other.prvd_nam_ind)) {
			return false;
		}
		if (prvd_nam_org_ind == null) {
			if (other.prvd_nam_org_ind != null) {
				return false;
			}
		} else if (!prvd_nam_org_ind.equals(other.prvd_nam_org_ind)) {
			return false;
		}
		if (prvd_org_nam == null) {
			if (other.prvd_org_nam != null) {
				return false;
			}
		} else if (!prvd_org_nam.equals(other.prvd_org_nam)) {
			return false;
		}
		if (prvd_typ == null) {
			if (other.prvd_typ != null) {
				return false;
			}
		} else if (!prvd_typ.equals(other.prvd_typ)) {
			return false;
		}
		if (rec_cplt_ind == null) {
			if (other.rec_cplt_ind != null) {
				return false;
			}
		} else if (!rec_cplt_ind.equals(other.rec_cplt_ind)) {
			return false;
		}
		
		return true;
	}

	/**
	 * returns the pay_freq value.
	 */
	public String getPay_freq() {
		return pay_freq;
	}

	/**
	 * sets the pay_freq value.
	 */
	public void setPay_freq(final String pay_freq) {
		this.pay_freq = pay_freq;
	}



	/**
	 * Returns the dpnd_care_exp_amt.
	 *
	 * Creation Date Mon Jan 23 13:28:43 CST 2006
	 * @return java.lang.String
	 */

	public java.lang.String getDpnd_care_exp_amt() {
		return displayFormatter.getNumberFormat(dpnd_care_exp_amt);
	}

	/**
	 * Sets the dpnd_care_exp_amt.
	 *
	 * Creation Date Mon Jan 23 13:28:43 CST 2006
	 * @param dpnd_care_exp_amt
	 *            The dpnd_care_exp_amt to set
	 */

	public void setDpnd_care_exp_amt(final java.lang.String dpnd_care_exp_amt) {
		this.dpnd_care_exp_amt = dpnd_care_exp_amt;
	}

	/**
	 * Returns the dpnd_care_exp_ind.
	 *
	 * Creation Date Mon Jan 23 13:28:43 CST 2006
	 * @return java.lang.String
	 */

	public java.lang.String getDpnd_care_exp_ind() {
		return dpnd_care_exp_ind;
	}

	/**
	 * Sets the dpnd_care_exp_ind.
	 *
	 * Creation Date Mon Jan 23 13:28:43 CST 2006
	 * @param dpnd_care_exp_ind
	 *            The dpnd_care_exp_ind to set
	 */

	public void setDpnd_care_exp_ind(final java.lang.String dpnd_care_exp_ind) {
		this.dpnd_care_exp_ind = dpnd_care_exp_ind;
	}

	/**
	 * Returns the dpnd_exp_paid_amt.
	 *
	 * Creation Date Mon Jan 23 13:28:43 CST 2006
	 * @return java.lang.String
	 */

	public java.lang.String getDpnd_exp_paid_amt() {
		return displayFormatter.getNumberFormat(dpnd_exp_paid_amt);
	}

	/**
	 * Sets the dpnd_exp_paid_amt.
	 *
	 * Creation Date Mon Jan 23 13:28:43 CST 2006
	 * @param dpnd_exp_paid_amt
	 *            The dpnd_exp_paid_amt to set
	 */

	public void setDpnd_exp_paid_amt(final java.lang.String dpnd_exp_paid_amt) {
		this.dpnd_exp_paid_amt = dpnd_exp_paid_amt;
	}

	/**
	 * Returns the dpnd_exp_paid_ind.
	 *
	 * Creation Date Mon Jan 23 13:28:43 CST 2006
	 * @return java.lang.String
	 */

	public java.lang.String getDpnd_exp_paid_ind() {
		return dpnd_exp_paid_ind;
	}

	/**
	 * Sets the dpnd_exp_paid_ind.
	 *
	 * Creation Date Mon Jan 23 13:28:43 CST 2006
	 * @param dpnd_exp_paid_ind
	 *            The dpnd_exp_paid_ind to set
	 */

	public void setDpnd_exp_paid_ind(final java.lang.String dpnd_exp_paid_ind) {
		this.dpnd_exp_paid_ind = dpnd_exp_paid_ind;
	}

	/**
	 * Returns the paid_in_seq_num.
	 *
	 * Creation Date Mon Jan 23 13:28:43 CST 2006
	 * @return java.lang.String
	 */

	public java.lang.String getPaid_in_seq_num() {
		return paid_in_seq_num;
	}

	/**
	 * Sets the paid_in_seq_num.
	 *
	 * Creation Date Mon Jan 23 13:28:43 CST 2006
	 * @param paid_in_seq_num
	 *            The paid_in_seq_num to set
	 */

	public void setPaid_in_seq_num(final java.lang.String paid_in_seq_num) {
		this.paid_in_seq_num = paid_in_seq_num;
	}

	/**
	 * Returns the prvd_fst_nam.
	 *
	 * Creation Date Mon Jan 23 13:28:43 CST 2006
	 * @return java.lang.String
	 */

	public java.lang.String getPrvd_fst_nam() {
		return prvd_fst_nam;
	}

	/**
	 * Sets the prvd_fst_nam.
	 *
	 * Creation Date Mon Jan 23 13:28:43 CST 2006
	 * @param prvd_fst_nam
	 *            The prvd_fst_nam to set
	 */

	public void setPrvd_fst_nam(final java.lang.String prvd_fst_nam) {
		this.prvd_fst_nam = prvd_fst_nam;
	}

	/**
	 * Returns the prvd_in_seq_num.
	 *
	 * Creation Date Mon Jan 23 13:28:43 CST 2006
	 * @return java.lang.String
	 */

	public java.lang.String getPrvd_in_seq_num() {
		return prvd_in_seq_num;
	}

	/**
	 * Sets the prvd_in_seq_num.
	 *
	 * Creation Date Mon Jan 23 13:28:43 CST 2006
	 * @param prvd_in_seq_num
	 *            The prvd_in_seq_num to set
	 */

	public void setPrvd_in_seq_num(final java.lang.String prvd_in_seq_num) {
		this.prvd_in_seq_num = prvd_in_seq_num;
	}

	/**
	 * Returns the prvd_last_nam.
	 *
	 * Creation Date Mon Jan 23 13:28:43 CST 2006
	 * @return java.lang.String
	 */

	public java.lang.String getPrvd_last_nam() {
		return prvd_last_nam;
	}

	/**
	 * Sets the prvd_last_nam.
	 *
	 * Creation Date Mon Jan 23 13:28:43 CST 2006
	 * @param prvd_last_nam
	 *            The prvd_last_nam to set
	 */

	public void setPrvd_last_nam(final java.lang.String prvd_last_nam) {
		this.prvd_last_nam = prvd_last_nam;
	}

	/**
	 * Returns the prvd_org_nam.
	 *
	 * Creation Date Mon Jan 23 13:28:43 CST 2006
	 * @return java.lang.String
	 */

	public java.lang.String getPrvd_org_nam() {
		return prvd_org_nam;
	}

	/**
	 * Sets the prvd_org_nam.
	 *
	 * Creation Date Mon Jan 23 13:28:43 CST 2006
	 * @param prvd_org_nam
	 *            The prvd_org_nam to set
	 */

	public void setPrvd_org_nam(final java.lang.String prvd_org_nam) {
		this.prvd_org_nam = prvd_org_nam;
	}

	/**
	 * Returns the prvd_typ.
	 *
	 * Creation Date Mon Jan 23 13:28:43 CST 2006
	 * @return java.lang.String
	 */

	public java.lang.String getPrvd_typ() {
		return prvd_typ;
	}

	/**
	 * Sets the prvd_typ.
	 *
	 * Creation Date Mon Jan 23 13:28:43 CST 2006
	 * @param prvd_typ
	 *            The prvd_typ to set
	 */

	public void setPrvd_typ(final java.lang.String prvd_typ) {
		this.prvd_typ = prvd_typ;
	}

	/**
	 * Returns the rec_cplt_ind.
	 *
	 * Creation Date Mon Jan 23 13:28:43 CST 2006
	 * @return java.lang.String
	 */

	public java.lang.String getRec_cplt_ind() {
		return rec_cplt_ind;
	}

	/**
	 * Sets the rec_cplt_ind.
	 *
	 * Creation Date Mon Jan 23 13:28:43 CST 2006
	 * @param rec_cplt_ind
	 *            The rec_cplt_ind to set
	 */

	public void setRec_cplt_ind(final java.lang.String rec_cplt_ind) {
		this.rec_cplt_ind = rec_cplt_ind;
	}

	/**
	 * Returns the prvd_nam_org_ind.
	 *
	 * Creation Date Mon Jan 23 13:28:43 CST 2006
	 * @return java.lang.String
	 */

	public java.lang.String getPrvd_nam_org_ind() {
		return prvd_nam_org_ind;
	}

	/**
	 * Sets the prvd_nam_org_ind.
	 *
	 * Creation Date Mon Jan 23 13:28:43 CST 2006
	 * @param prvd_nam_org_ind
	 *            The prvd_nam_org_ind to set
	 */

	public void setPrvd_nam_org_ind(final java.lang.String prvd_nam_org_ind) {
		this.prvd_nam_org_ind = prvd_nam_org_ind;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public java.lang.String getPrvd_nam_ind() {
		return prvd_nam_ind;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public void setPrvd_nam_ind(final java.lang.String string) {
		prvd_nam_ind = string;
	}

	// EDSP CP starts: new field added
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
	// EDSP CP ends: new field added

	@Override
	public String getSeq_num() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSeq_num(String seq_num) {
		// TODO Auto-generated method stub
		
	}
}
