package gov.state.nextgen.access.business.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import gov.state.nextgen.access.management.constants.FwConstants;

@Entity
@Table(name = "APP_IN_HOU_BILLS")
public class AppInHouBillsCargo extends AbstractCargo implements Serializable{

	/**
	 *
	 */
	@EmbeddedId
	AppInHouBillsPrimaryKey appInHouBillsPrimaryKey = new AppInHouBillsPrimaryKey();
	
	
	private static final long serialVersionUID = 1L;
	private String property_name = FwConstants.EMPTY_STRING;
	private String prop_addr_l1 = FwConstants.EMPTY_STRING;
	private String prop_addr_l2 = FwConstants.EMPTY_STRING;
	private String prop_addr_city = FwConstants.EMPTY_STRING;
	private String prop_addr_state_cd = FwConstants.EMPTY_STRING;
	private String prop_addr_zip = FwConstants.EMPTY_STRING;
	private String prop_phone_num = FwConstants.EMPTY_STRING;
	private String pymt_amt = FwConstants.EMPTY_STRING;
	private String pymt_freq = FwConstants.EMPTY_STRING;
	private String jnt_pay_resp = FwConstants.EMPTY_STRING;
	private String loopingQuestion = FwConstants.EMPTY_STRING;
	private String rec_cplt_ind = null;
	private String paid_amt = FwConstants.EMPTY_STRING;
	private String end_dt = null;
	private String ecp_id = null;
	private String propAddrZip4=null;
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

	public String getEnd_dt() {
		return end_dt;
	}

	public void setEnd_dt(final String end_dt) {
		this.end_dt = end_dt;
	}

	/**
	 *
	 */
	public AppInHouBillsCargo() {
	}

	
	/**
	 * @return the property_name
	 */
	public String getProperty_name() {
		return property_name;
	}

	/**
	 * @param property_name
	 *            the property_name to set
	 */
	public void setProperty_name(final String property_name) {
		this.property_name = property_name;
	}

	/**
	 * @return the prop_addr_l1
	 */
	public String getProp_addr_l1() {
		return prop_addr_l1;
	}

	/**
	 * @param prop_addr_l1
	 *            the prop_addr_l1 to set
	 */
	public void setProp_addr_l1(final String prop_addr_l1) {
		this.prop_addr_l1 = prop_addr_l1;
	}

	/**
	 * @return the prop_addr_l2
	 */
	public String getProp_addr_l2() {
		return prop_addr_l2;
	}

	/**
	 * @param prop_addr_l2
	 *            the prop_addr_l2 to set
	 */
	public void setProp_addr_l2(final String prop_addr_l2) {
		this.prop_addr_l2 = prop_addr_l2;
	}

	/**
	 * @return the prop_addr_city
	 */
	public String getProp_addr_city() {
		return prop_addr_city;
	}

	/**
	 * @param prop_addr_city
	 *            the prop_addr_city to set
	 */
	public void setProp_addr_city(final String prop_addr_city) {
		this.prop_addr_city = prop_addr_city;
	}

	/**
	 * @return the prop_addr_state_cd
	 */
	public String getProp_addr_state_cd() {
		return prop_addr_state_cd;
	}

	/**
	 * @param prop_addr_state_cd
	 *            the prop_addr_state_cd to set
	 */
	public void setProp_addr_state_cd(final String prop_addr_state_cd) {
		this.prop_addr_state_cd = prop_addr_state_cd;
	}

	/**
	 * @return the prop_addr_zip
	 */
	public String getProp_addr_zip() {
		return prop_addr_zip;
	}

	/**
	 * @param prop_addr_zip
	 *            the prop_addr_zip to set
	 */
	public void setProp_addr_zip(final String prop_addr_zip) {
		this.prop_addr_zip = prop_addr_zip;
	}

	/**
	 * @return the prop_phone_num
	 */
	public String getProp_phone_num() {
		return prop_phone_num;
	}

	/**
	 * @param prop_phone_num
	 *            the prop_phone_num to set
	 */
	public void setProp_phone_num(final String prop_phone_num) {
		this.prop_phone_num = prop_phone_num;
	}

		/**
	 * @return the pymt_amt
	 */
	public String getPymt_amt() {
		return pymt_amt;
	}

	/**
	 * @param pymt_amt
	 *            the pymt_amt to set
	 */
	public void setPymt_amt(final String pymt_amt) {
		this.pymt_amt = pymt_amt;
	}

	/**
	 * @return the paid_amt
	 */
	public String getPaid_amt() {
		return paid_amt;
	}

	/**
	 * @param paid_amt the paid_amt to set
	 */
	public void setPaid_amt(final String paid_amt) {
		this.paid_amt = paid_amt;
	}

	/**
	 * @return the pymt_freq
	 */
	public String getPymt_freq() {
		return pymt_freq;
	}

	/**
	 * @param pymt_freq
	 *            the pymt_freq to set
	 */
	public void setPymt_freq(final String pymt_freq) {
		this.pymt_freq = pymt_freq;
	}

	/**
	 * @return the jnt_pay_resp
	 */
	public String getJnt_pay_resp() {
		return jnt_pay_resp;
	}

	/**
	 * @param jnt_pay_resp
	 *            the jnt_pay_resp to set
	 */
	public void setJnt_pay_resp(final String jnt_pay_resp) {
		this.jnt_pay_resp = jnt_pay_resp;
	}

	/**
	 * @return the loopingQuestion
	 */
	public String getLoopingQuestion() {
		return loopingQuestion;
	}

	/**
	 * @param loopingQuestion
	 *            the loopingQuestion to set
	 */
	public void setLoopingQuestion(final String loopingQuestion) {
		this.loopingQuestion = loopingQuestion;
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

	/**
	 * @return the propAddrZip4
	 */
	public String getPropAddrZip4() {
		return propAddrZip4;
	}

	/**
	 * @param propAddrZip4 the propAddrZip4 to set
	 */
	public void setPropAddrZip4(String propAddrZip4) {
		this.propAddrZip4 = propAddrZip4;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see gov.state.nextgen.framework.business.entities.ICargo#getPrimaryKey()
	 */
	public IPrimaryKey getPrimaryKey() {
		
		return appInHouBillsPrimaryKey;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see gov.state.nextgen.framework.business.entities.ICargo#inspectCargo()
	 */
	public String inspectCargo() {
		final StringBuilder builder = new StringBuilder();
		builder.append("APP_IN_HOU_BILLS: ");
		builder.append("property_name=");
		builder.append(property_name);
		builder.append("prop_addr_l1=");
		builder.append(prop_addr_l1);
		builder.append("prop_addr_l2=");
		builder.append(prop_addr_l2);
		builder.append("prop_addr_city=");
		builder.append(prop_addr_city);
		builder.append("prop_addr_state_cd=");
		builder.append(prop_addr_state_cd);
		builder.append("prop_addr_zip=");
		builder.append(prop_addr_zip);
		builder.append("prop_phone_num=");
		builder.append(prop_phone_num);
		builder.append("bill_type=");
		builder.append("pymt_amt=");
		builder.append(pymt_amt);
		builder.append("pymt_freq=");
		builder.append(pymt_freq);
		builder.append("jnt_pay_resp=");
		builder.append(jnt_pay_resp);
		builder.append("rec_cplt_ind=");
		builder.append(rec_cplt_ind);
		builder.append("paid_amt=");
		builder.append(paid_amt);
		builder.append("end_dt=");
		builder.append(end_dt);
		builder.append("ecp_id=");
		builder.append(ecp_id);
		builder.append(" chg_dt= ").append(chg_dt);
		return builder.toString();
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
		result = (prime * result) + ((jnt_pay_resp == null) ? 0 : jnt_pay_resp.hashCode());
		result = (prime * result) + ((prop_addr_city == null) ? 0 : prop_addr_city.hashCode());
		result = (prime * result) + ((prop_addr_l1 == null) ? 0 : prop_addr_l1.hashCode());
		result = (prime * result) + ((prop_addr_l2 == null) ? 0 : prop_addr_l2.hashCode());
		result = (prime * result) + ((prop_addr_state_cd == null) ? 0 : prop_addr_state_cd.hashCode());
		result = (prime * result) + ((prop_addr_zip == null) ? 0 : prop_addr_zip.hashCode());
		result = (prime * result) + ((prop_phone_num == null) ? 0 : prop_phone_num.hashCode());
		result = (prime * result) + ((property_name == null) ? 0 : property_name.hashCode());
		result = (prime * result) + ((pymt_amt == null) ? 0 : pymt_amt.hashCode());
		result = (prime * result) + ((rec_cplt_ind == null) ? 0 : rec_cplt_ind.hashCode());
		result = (prime * result) + ((paid_amt == null) ? 0 : paid_amt.hashCode());
		result = (prime * result) + ((end_dt == null) ? 0 : end_dt.hashCode());
		result = (prime * result) + ((ecp_id == null) ? 0 : ecp_id.hashCode());
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
		if (!(obj instanceof AppInHouBillsCargo)) {
			return false;
		}
		final AppInHouBillsCargo other = (AppInHouBillsCargo) obj;
		if (jnt_pay_resp == null) {
			if (other.jnt_pay_resp != null) {
				return false;
			}
		} else if (!jnt_pay_resp.equals(other.jnt_pay_resp)) {
			return false;
		}
		if (prop_addr_city == null) {
			if (other.prop_addr_city != null) {
				return false;
			}
		} else if (!prop_addr_city.equals(other.prop_addr_city)) {
			return false;
		}
		if (prop_addr_l1 == null) {
			if (other.prop_addr_l1 != null) {
				return false;
			}
		} else if (!prop_addr_l1.equals(other.prop_addr_l1)) {
			return false;
		}
		if (prop_addr_l2 == null) {
			if (other.prop_addr_l2 != null) {
				return false;
			}
		} else if (!prop_addr_l2.equals(other.prop_addr_l2)) {
			return false;
		}
		if (prop_addr_state_cd == null) {
			if (other.prop_addr_state_cd != null) {
				return false;
			}
		} else if (!prop_addr_state_cd.equals(other.prop_addr_state_cd)) {
			return false;
		}
		if (prop_addr_zip == null) {
			if (other.prop_addr_zip != null) {
				return false;
			}
		} else if (!prop_addr_zip.equals(other.prop_addr_zip)) {
			return false;
		}
		if (prop_phone_num == null) {
			if (other.prop_phone_num != null) {
				return false;
			}
		} else if (!prop_phone_num.equals(other.prop_phone_num)) {
			return false;
		}
		if (property_name == null) {
			if (other.property_name != null) {
				return false;
			}
		} else if (!property_name.equals(other.property_name)) {
			return false;
		}
		if (pymt_amt == null) {
			if (other.pymt_amt != null) {
				return false;
			}
		} else if (!pymt_amt.equals(other.pymt_amt)) {
			return false;
		}

		if (pymt_freq == null) {
			if (other.pymt_freq != null) {
				return false;
			}
		} else if (!pymt_freq.equals(other.pymt_freq)) {
			return false;
		}
		
		if (rec_cplt_ind == null) {
			if (other.rec_cplt_ind != null) {
				return false;
			}
		} else if (!rec_cplt_ind.equals(other.rec_cplt_ind)) {
			return false;
		}
		if (paid_amt == null) {
			if (other.paid_amt != null) {
				return false;
			}
		} else if (!paid_amt.equals(other.paid_amt)) {
			return false;
		}
		if (end_dt == null) {
			if (other.end_dt != null) {
				return false;
			}
		} else if (!end_dt.equals(other.end_dt)) {
			return false;
		}
		if (ecp_id == null) {
			if (other.ecp_id != null) {
				return false;
			}
		} else if (!ecp_id.equals(other.ecp_id)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("APP_IN_HOU_BILLS [");
		builder.append("property_name=");
		builder.append(property_name);
		builder.append(", prop_addr_l1=");
		builder.append(prop_addr_l1);
		builder.append(", prop_addr_l2=");
		builder.append(prop_addr_l2);
		builder.append(", prop_addr_city=");
		builder.append(prop_addr_city);
		builder.append(", prop_addr_state_cd=");
		builder.append(prop_addr_state_cd);
		builder.append(", prop_addr_zip=");
		builder.append(prop_addr_zip);
		builder.append(", prop_phone_num=");
		builder.append(prop_phone_num);
		builder.append(", pymt_amt=");
		builder.append(pymt_amt);
		builder.append(", pymt_freq=");
		builder.append(pymt_freq);
		builder.append(", jnt_pay_resp=");
		builder.append(jnt_pay_resp);
		builder.append(", rec_cplt_ind=");
		builder.append(rec_cplt_ind);
		builder.append(", paid_amt=");
		builder.append(paid_amt);
		builder.append(", end_dt=");
		builder.append(end_dt);
		builder.append(", ecp_id=");
		builder.append(ecp_id);
		builder.append("]");
		return builder.toString();
	}

	public Map compareAttributes(final AppInHouBillsCargo aCargo) {
		final Map changedAttributeValue = new HashMap();
		if (!((aCargo.getProperty_name() == null) && (property_name == null))
				&& !((aCargo.getProperty_name() != null) && aCargo.getProperty_name().equals(property_name))) {
			changedAttributeValue.put("property_name", aCargo.getProperty_name());
		}

		if (!((aCargo.getEnd_dt() == null) && (end_dt == null)) && !((aCargo.getEnd_dt() != null) && aCargo.getEnd_dt().equals(end_dt))) {
			changedAttributeValue.put("end_dt", aCargo.getEnd_dt());
		}

		if (!((aCargo.getPaid_amt() == null) && (paid_amt == null)) && !((aCargo.getPaid_amt() != null) && aCargo.getPaid_amt().equals(paid_amt))) {
			changedAttributeValue.put("paid_amt", aCargo.getPaid_amt());
		}

		if (!((aCargo.getJnt_pay_resp() == null) && (jnt_pay_resp == null))
				&& !((aCargo.getJnt_pay_resp() != null) && aCargo.getJnt_pay_resp().equals(jnt_pay_resp))) {
			changedAttributeValue.put("jnt_pay_resp", aCargo.getJnt_pay_resp());
		}

		if (!((aCargo.getPymt_freq() == null) && (pymt_freq == null))
				&& !((aCargo.getPymt_freq() != null) && aCargo.getPymt_freq().equals(pymt_freq))) {
			changedAttributeValue.put("pymt_freq", aCargo.getPymt_freq());
		}

		if (!((aCargo.getPymt_amt() == null) && (pymt_amt == null)) && !((aCargo.getPymt_amt() != null) && aCargo.getPymt_amt().equals(pymt_amt))) {
			changedAttributeValue.put("pymt_amt", aCargo.getPymt_amt());
		}

		if (!((aCargo.getProp_addr_l1() == null) && (prop_addr_l1 == null))
				&& !((aCargo.getProp_addr_l1() != null) && aCargo.getProp_addr_l1().equals(prop_addr_l1))) {
			changedAttributeValue.put("prop_addr_l1", aCargo.getProp_addr_l1());
		}

		if (!((aCargo.getProp_addr_l2() == null) && (prop_addr_l2 == null))
				&& !((aCargo.getProp_addr_l2() != null) && aCargo.getProp_addr_l2().equals(prop_addr_l2))) {
			changedAttributeValue.put("prop_addr_l2", aCargo.getProp_addr_l2());
		}

		

		if (!((aCargo.getProp_addr_city() == null) && (prop_addr_city == null))
				&& !((aCargo.getProp_addr_city() != null) && aCargo.getProp_addr_city().equals(prop_addr_city))) {
			changedAttributeValue.put("prop_addr_city", aCargo.getProp_addr_city());
		}

		if (!((aCargo.getProp_addr_state_cd() == null) && (prop_addr_state_cd == null))
				&& !((aCargo.getProp_addr_state_cd() != null) && aCargo.getProp_addr_state_cd().equals(prop_addr_state_cd))) {
			changedAttributeValue.put("prop_addr_state_cd", aCargo.getProp_addr_state_cd());
		}

		if (!((aCargo.getProp_addr_zip() == null) && (prop_addr_zip == null))
				&& !((aCargo.getProp_addr_zip() != null) && aCargo.getProp_addr_zip().equals(prop_addr_zip))) {
			changedAttributeValue.put("prop_addr_zip", aCargo.getProp_addr_state_cd());
		}

		if (!((aCargo.getProp_phone_num() == null) && (prop_phone_num == null))
				&& !((aCargo.getProp_phone_num() != null) && aCargo.getProp_phone_num().equals(prop_phone_num))) {
			changedAttributeValue.put("prop_phone_num", aCargo.getProp_phone_num());
		}
		if(!(aCargo.getChg_dt()==null && this.chg_dt==null) && !(aCargo.getChg_dt()!=null && aCargo.getChg_dt().equals(this.chg_dt))) changedAttributeValue.put("chg_dt",aCargo.getChg_dt());

		return changedAttributeValue;
	}

}
