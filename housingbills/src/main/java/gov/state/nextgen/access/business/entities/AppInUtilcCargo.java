 package gov.state.nextgen.access.business.entities;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "APP_IN_UTILC")
 public class AppInUtilcCargo  extends AbstractCargo implements java.io.Serializable {

	/**
	 *
	 */
	@EmbeddedId
	private AppInUtilcPrimaryKey key ;
	
	private static final long serialVersionUID = 1L;

	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.impl.APP_IN_UTILC";
	public Formatter displayFormatter = Formatter.getInstance();
	boolean isDirty = false;
	private String bill_exp_resp;
	private String chg_eff_dt;
	private String heat_sw;
	private String mo_oblg_amt;
	private String mo_oblg_ind;
	private String rec_cplt_ind;
	private String util_typ;
	private String pay_freq;
	private String util_electric_resp;
	private String util_sewage_resp;
	private String util_garbage_resp;
	private String util_phone_resp;
	private String util_gas_resp;
	private String util_water_resp;
	private String util_fuel_resp;
	private String mo_hsld_pay_amt;
	private String util_total_amt;
	private String ecp_id;
	private String heat_cool_src;
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

	/**
	 * @return the util_total_amt
	 */
	public String getUtil_total_amt() {
		return util_total_amt;
	}

	/**
	 * @param util_total_amt the util_total_amt to set
	 */
	public void setUtil_total_amt(final String util_total_amt) {
		this.util_total_amt = util_total_amt;
	}

	/**
	 * @return the util_electric_resp
	 */
	public String getUtil_electric_resp() {
		return util_electric_resp;
	}

	/**
	 * @param util_electric_resp the util_electric_resp to set
	 */
	public void setUtil_electric_resp(final String util_electric_resp) {
		this.util_electric_resp = util_electric_resp;
	}

	/**
	 * @return the util_sewage_resp
	 */
	public String getUtil_sewage_resp() {
		return util_sewage_resp;
	}

	/**
	 * @param util_sewage_resp the util_sewage_resp to set
	 */
	public void setUtil_sewage_resp(final String util_sewage_resp) {
		this.util_sewage_resp = util_sewage_resp;
	}

	/**
	 * @return the util_garbage_resp
	 */
	public String getUtil_garbage_resp() {
		return util_garbage_resp;
	}

	/**
	 * @param util_garbage_resp the util_garbage_resp to set
	 */
	public void setUtil_garbage_resp(final String util_garbage_resp) {
		this.util_garbage_resp = util_garbage_resp;
	}

	/**
	 * @return the util_phone_resp
	 */
	public String getUtil_phone_resp() {
		return util_phone_resp;
	}

	/**
	 * @param util_phone_resp the util_phone_resp to set
	 */
	public void setUtil_phone_resp(final String util_phone_resp) {
		this.util_phone_resp = util_phone_resp;
	}

	/**
	 * @return the util_gas_resp
	 */
	public String getUtil_gas_resp() {
		return util_gas_resp;
	}

	/**
	 * @param util_gas_resp the util_gas_resp to set
	 */
	public void setUtil_gas_resp(final String util_gas_resp) {
		this.util_gas_resp = util_gas_resp;
	}

	/**
	 * @return the util_water_resp
	 */
	public String getUtil_water_resp() {
		return util_water_resp;
	}

	/**
	 * @param util_water_resp the util_water_resp to set
	 */
	public void setUtil_water_resp(final String util_water_resp) {
		this.util_water_resp = util_water_resp;
	}

	/**
	 * @return the util_fuel_resp
	 */
	public String getUtil_fuel_resp() {
		return util_fuel_resp;
	}

	/**
	 * @param util_fuel_resp the util_fuel_resp to set
	 */
	public void setUtil_fuel_resp(final String util_fuel_resp) {
		this.util_fuel_resp = util_fuel_resp;
	}

	/**
	 * @return the mo_hsld_pay_amt
	 */
	public String getMo_hsld_pay_amt() {
		return mo_hsld_pay_amt;
	}

	/**
	 * @param mo_hsld_pay_amt the mo_hsld_pay_amt to set
	 */
	public void setMo_hsld_pay_amt(final String mo_hsld_pay_amt) {
		this.mo_hsld_pay_amt = mo_hsld_pay_amt;
	}

	// VA EDSP CP additions
	private String someone_else_pay_ind;

	/**
	 * returns the bill_exp_resp value.
	 */
	public String getBill_exp_resp() {
		return bill_exp_resp;
	}

	/**
	 * returns the chg_eff_dt value.
	 */
	public String getChg_eff_dt() {
		return chg_eff_dt;
	}

	/**
	 * returns the heat_sw value.
	 */
	public String getHeat_sw() {
		return heat_sw;
	}

	/**
	 * returns the mo_oblg_amt value.
	 */
	public String getMo_oblg_amt() {
		return displayFormatter.getNumberFormat(mo_oblg_amt);
	}

	/**
	 * returns the mo_oblg_ind value.
	 */
	public String getMo_oblg_ind() {
		return mo_oblg_ind;
	}

	/**
	 * returns the rec_cplt_ind value.
	 */
	public String getRec_cplt_ind() {
		return rec_cplt_ind;
	}

	/**
	 * returns the util_typ value.
	 */
	public String getUtil_typ() {
		return util_typ;
	}

	/**
	 * returns the pay_freq value.
	 */
	public String getPay_freq() {
		return pay_freq;
	}



	/**
	 * sets the bill_exp_resp value.
	 */
	public void setBill_exp_resp(final String bill_exp_resp) {
		this.bill_exp_resp = bill_exp_resp;
	}

	/**
	 * sets the chg_eff_dt value.
	 */
	public void setChg_eff_dt(final String chg_eff_dt) {
		this.chg_eff_dt = chg_eff_dt;
	}

	/**
	 * sets the heat_sw value.
	 */
	public void setHeat_sw(final String heat_sw) {
		this.heat_sw = heat_sw;
	}

	/**
	 * sets the mo_oblg_amt value.
	 */
	public void setMo_oblg_amt(final String mo_oblg_amt) {
		this.mo_oblg_amt = mo_oblg_amt;
	}

	/**
	 * sets the mo_oblg_ind value.
	 */
	public void setMo_oblg_ind(final String mo_oblg_ind) {
		this.mo_oblg_ind = mo_oblg_ind;
	}

	/**
	 * sets the rec_cplt_ind value.
	 */
	public void setRec_cplt_ind(final String rec_cplt_ind) {
		this.rec_cplt_ind = rec_cplt_ind;
	}

	/**
	 * sets the util_typ value.
	 */
	public void setUtil_typ(final String util_typ) {
		this.util_typ = util_typ;
	}

	/**
	 * sets the pay_freq value.
	 */
	public void setPay_freq(final String pay_freq) {
		this.pay_freq = pay_freq;
	}

	/**
	 * @return the someone_else_pay_ind
	 */
	public String getSomeone_else_pay_ind() {
		return someone_else_pay_ind;
	}

	/**
	 * @param someone_else_pay_ind
	 *            the someone_else_pay_ind to set
	 */
	public void setSomeone_else_pay_ind(final String someone_else_pay_ind) {
		this.someone_else_pay_ind = someone_else_pay_ind;
	}
	
	

	/**
	 * @return the heat_cool_src
	 */
	public String getHeat_cool_src() {
		return heat_cool_src;
	}

	/**
	 * @param heat_cool_src the heat_cool_src to set
	 */
	public void setHeat_cool_src(String heat_cool_src) {
		this.heat_cool_src = heat_cool_src;
	}

	/**
	 * returns the PrimaryKey object.
	 */
	

	/**
	 * returns the PACKAGE name.
	 */
	public String getPackage() {
		return PACKAGE;
	}

	/**
	 * returns the string value of cargo.
	 */
	
	public String inspectCargo() {
		return new StringBuilder().append("APP_IN_UTILC: ")
				.append("bill_exp_resp=").append(bill_exp_resp)
				.append("chg_eff_dt=").append(chg_eff_dt).append("heat_sw=").append(heat_sw).append("mo_oblg_amt=").append(mo_oblg_amt)
				.append("mo_oblg_ind=").append(mo_oblg_ind).append("rec_cplt_ind=").append(rec_cplt_ind).append("util_typ=").append(util_typ)
				.append("pay_freq=").append(pay_freq).append("ecp_id=").append(ecp_id).append("heat_cool_src=").append(heat_cool_src).append(" chg_dt= ").append(chg_dt)
				.toString();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((bill_exp_resp == null) ? 0 : bill_exp_resp.trim().hashCode());
		result = (prime * result) + ((chg_eff_dt == null) ? 0 : chg_eff_dt.trim().hashCode());
		result = (prime * result) + ((heat_sw == null) ? 0 : heat_sw.trim().hashCode());
		result = (prime * result) + ((mo_oblg_amt == null) ? 0 : mo_oblg_amt.trim().hashCode());
		result = (prime * result) + ((mo_oblg_ind == null) ? 0 : mo_oblg_ind.trim().hashCode());
		result = (prime * result) + ((pay_freq == null) ? 0 : pay_freq.trim().hashCode());
		result = (prime * result) + ((rec_cplt_ind == null) ? 0 : rec_cplt_ind.trim().hashCode());
		result = (prime * result) + ((util_typ == null) ? 0 : util_typ.trim().hashCode());
		result = (prime * result) + ((ecp_id == null) ? 0 : ecp_id.trim().hashCode());
		result = (prime * result) + ((heat_cool_src == null) ? 0 : heat_cool_src.trim().hashCode());
		result = (prime * result) + ((chg_dt == null) ? 0 : chg_dt.trim().hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	
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
		final AppInUtilcCargo other = (AppInUtilcCargo) obj;
		
		if (bill_exp_resp == null) {
			if (other.bill_exp_resp != null) {
				return false;
			}
		} else if (!bill_exp_resp.equals(other.bill_exp_resp)) {
			return false;
		}
		if (chg_eff_dt == null) {
			if (other.chg_eff_dt != null) {
				return false;
			}
		} else if (!chg_eff_dt.equals(other.chg_eff_dt)) {
			return false;
		}
		if (heat_sw == null) {
			if (other.heat_sw != null) {
				return false;
			}
		} else if (!heat_sw.equals(other.heat_sw)) {
			return false;
		}
		
		if (mo_oblg_amt == null) {
			if (other.mo_oblg_amt != null) {
				return false;
			}
		} else if (!mo_oblg_amt.equals(other.mo_oblg_amt)) {
			return false;
		}
		if (mo_oblg_ind == null) {
			if (other.mo_oblg_ind != null) {
				return false;
			}
		} else if (!mo_oblg_ind.equals(other.mo_oblg_ind)) {
			return false;
		}
		if (pay_freq == null) {
			if (other.pay_freq != null) {
				return false;
			}
		} else if (!pay_freq.equals(other.pay_freq)) {
			return false;
		}
		if (rec_cplt_ind == null) {
			if (other.rec_cplt_ind != null) {
				return false;
			}
		} else if (!rec_cplt_ind.equals(other.rec_cplt_ind)) {
			return false;
		}
	
		
		if (util_typ == null) {
			if (other.util_typ != null) {
				return false;
			}
		} else if (!util_typ.equals(other.util_typ)) {
			return false;
		}
		if (ecp_id == null) {
			if (other.ecp_id != null) {
				return false;
			}
		} else if (!ecp_id.equals(other.ecp_id)) {
			return false;
		}
		if (heat_cool_src == null) {
			if (other.heat_cool_src != null) {
				return false;
			}
		} else if (!heat_cool_src.equals(other.heat_cool_src)) {
			return false;
		}
		return true;
	}

	/**
	 * compares the given cargo with this cargo and returns the changed
	 * attribute-value Map.
	 */
	public Map compareAttributes(final AppInUtilcCargo aCargo) {
		final Map changedAttributeValue = new HashMap();
		
		if (!((aCargo.getChg_eff_dt() == null) && (chg_eff_dt == null))
				&& !((aCargo.getChg_eff_dt() != null) && aCargo.getChg_eff_dt().equals(chg_eff_dt))) {
			changedAttributeValue.put("chg_eff_dt", aCargo.getChg_eff_dt());
		}
		if (!((aCargo.getRec_cplt_ind() == null) && (rec_cplt_ind == null))
				&& !((aCargo.getRec_cplt_ind() != null) && aCargo.getRec_cplt_ind().equals(rec_cplt_ind))) {
			changedAttributeValue.put("rec_cplt_ind", aCargo.getRec_cplt_ind());
		}
		if (!((aCargo.getMo_oblg_amt() == null) && (mo_oblg_amt == null))
				&& !((aCargo.getMo_oblg_amt() != null) && aCargo.getMo_oblg_amt().equals(getMo_oblg_amt()))) {
			changedAttributeValue.put("mo_oblg_amt", aCargo.getMo_oblg_amt());
		}
		if (!((aCargo.getMo_oblg_ind() == null) && (mo_oblg_ind == null))
				&& !((aCargo.getMo_oblg_ind() != null) && aCargo.getMo_oblg_ind().equals(mo_oblg_ind))) {
			changedAttributeValue.put("mo_oblg_ind", aCargo.getMo_oblg_ind());
		}
		if (!((aCargo.getUtil_typ() == null) && (util_typ == null)) && !((aCargo.getUtil_typ() != null) && aCargo.getUtil_typ().equals(util_typ))) {
			changedAttributeValue.put("util_electric_resp", aCargo.getUtil_typ());
		}
		if (!((aCargo.getUtil_electric_resp() == null) && (util_electric_resp == null))
				&& !((aCargo.getUtil_electric_resp() != null) && aCargo.getUtil_electric_resp().equals(util_electric_resp))) {
			changedAttributeValue.put("util_electric_resp", aCargo.getUtil_electric_resp());
		}

		if (!((aCargo.getUtil_garbage_resp() == null) && (util_garbage_resp == null))
				&& !((aCargo.getUtil_garbage_resp() != null) && aCargo.getUtil_garbage_resp().equals(util_garbage_resp))) {
			changedAttributeValue.put("util_garbage_resp", aCargo.getUtil_garbage_resp());
		}

		if (!((aCargo.getUtil_sewage_resp() == null) && (util_sewage_resp == null))
				&& !((aCargo.getUtil_sewage_resp() != null) && aCargo.getUtil_sewage_resp().equals(util_sewage_resp))) {
			changedAttributeValue.put("util_sewage_resp", aCargo.getUtil_sewage_resp());
		}
		if (!((aCargo.getUtil_phone_resp() == null) && (util_phone_resp == null))
				&& !((aCargo.getUtil_phone_resp() != null) && aCargo.getUtil_phone_resp().equals(util_phone_resp))) {
			changedAttributeValue.put("util_phone_resp", aCargo.getUtil_phone_resp());
		}
		if (!((aCargo.getUtil_gas_resp() == null) && (util_gas_resp == null))
				&& !((aCargo.getUtil_gas_resp() != null) && aCargo.getUtil_gas_resp().equals(util_gas_resp))) {
			changedAttributeValue.put("util_gas_resp", aCargo.getUtil_gas_resp());
		}
		if (!((aCargo.getUtil_water_resp() == null) && (util_water_resp == null))
				&& !((aCargo.getUtil_water_resp() != null) && aCargo.getUtil_water_resp().equals(util_water_resp))) {
			changedAttributeValue.put("util_water_resp", aCargo.getUtil_water_resp());
		}

		if (!((aCargo.getUtil_fuel_resp() == null) && (util_fuel_resp == null))
				&& !((aCargo.getUtil_fuel_resp() != null) && aCargo.getUtil_fuel_resp().equals(util_fuel_resp))) {
			changedAttributeValue.put("util_fuel_resp", aCargo.getUtil_fuel_resp());
		}
		if (!((aCargo.getMo_hsld_pay_amt() == null) && (mo_hsld_pay_amt == null))
				&& !((aCargo.getMo_hsld_pay_amt() != null) && aCargo.getMo_hsld_pay_amt().equals(mo_hsld_pay_amt))) {
			changedAttributeValue.put("mo_hsld_pay_amt", aCargo.getMo_hsld_pay_amt());
		}
		if (!((aCargo.getUtil_total_amt() == null) && (util_total_amt == null))
				&& !((aCargo.getUtil_total_amt() != null) && aCargo.getUtil_total_amt().equals(util_total_amt))) {
			changedAttributeValue.put("util_total_amt", aCargo.getUtil_total_amt());
		}
		if (!((aCargo.getHeat_cool_src() == null) && (heat_cool_src == null))
				&& !((aCargo.getHeat_cool_src() != null) && aCargo.getHeat_cool_src().equals(heat_cool_src))) {
			changedAttributeValue.put("heat_cool_src", aCargo.getHeat_cool_src());
		}
		if(!(aCargo.getChg_dt()==null && this.chg_dt==null) && !(aCargo.getChg_dt()!=null && aCargo.getChg_dt().equals(this.chg_dt))) changedAttributeValue.put("chg_dt",aCargo.getChg_dt());

		return changedAttributeValue;
	}

	@Override
	public IPrimaryKey getPrimaryKey() {
		// TODO Auto-generated method stub
		return key;
	}

}
