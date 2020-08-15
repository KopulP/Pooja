/*
 * 
 */
package gov.state.nextgen.access.business.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * This java bean contains the entities of BNFT_INDV
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date Fri Jun 27 08:08:46 CDT 2008 Modified By: Modified on: PCR#
 */
public class BNFT_INDV_Cargo extends AbstractCargo implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	boolean isDirty = false;
	private String bnft_pin_num;
	private String brth_dt;
	private String dth_dt;
	private String fst_nam;
	private String last_nam;
	private String mid_init;
	private String sex_ind;
	private String sfx_nam;
	private String updt_dt;
	private String mci_id;
	private String ic_flg;

	/**
	 * returns the bnft_pin_num value.
	 */
	public String getBnft_pin_num() {
		return bnft_pin_num;
	}

	/**
	 * sets the bnft_pin_num value.
	 */
	public void setBnft_pin_num(final String bnft_pin_num) {
		this.bnft_pin_num = bnft_pin_num;
	}

	/**
	 * returns the brth_dt value.
	 */
	public String getBrth_dt() {
		return brth_dt;
	}

	/**
	 * sets the brth_dt value.
	 */
	public void setBrth_dt(final String brth_dt) {
		this.brth_dt = brth_dt;
	}

	/**
	 * returns the dth_dt value.
	 */
	public String getDth_dt() {
		return dth_dt;
	}

	/**
	 * sets the dth_dt value.
	 */
	public void setDth_dt(final String dth_dt) {
		this.dth_dt = dth_dt;
	}

	/**
	 * returns the fst_nam value.
	 */
	public String getFst_nam() {
		return fst_nam;
	}

	/**
	 * sets the fst_nam value.
	 */
	public void setFst_nam(final String fst_nam) {
		this.fst_nam = fst_nam;
	}

	/**
	 * returns the last_nam value.
	 */
	public String getLast_nam() {
		return last_nam;
	}

	/**
	 * sets the last_nam value.
	 */
	public void setLast_nam(final String last_nam) {
		this.last_nam = last_nam;
	}

	/**
	 * returns the mid_init value.
	 */
	public String getMid_init() {
		return mid_init;
	}

	/**
	 * sets the mid_init value.
	 */
	public void setMid_init(final String mid_init) {
		this.mid_init = mid_init;
	}

	/**
	 * returns the sex_ind value.
	 */
	public String getSex_ind() {
		return sex_ind;
	}

	/**
	 * sets the sex_ind value.
	 */
	public void setSex_ind(final String sex_ind) {
		this.sex_ind = sex_ind;
	}

	/**
	 * returns the sfx_nam value.
	 */
	public String getSfx_nam() {
		return sfx_nam;
	}

	/**
	 * sets the sfx_nam value.
	 */
	public void setSfx_nam(final String sfx_nam) {
		this.sfx_nam = sfx_nam;
	}

	/**
	 * returns the updt_dt value.
	 */
	public String getUpdt_dt() {
		return updt_dt;
	}

	/**
	 * sets the updt_dt value.
	 */
	public void setUpdt_dt(final String updt_dt) {
		this.updt_dt = updt_dt;
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
	 * returns the ic_flg value.
	 */
	public String getIc_flg() {
		return ic_flg;
	}

	/**
	 * sets the ic_flg value.
	 */
	public void setIc_flg(final String ic_flg) {
		this.ic_flg = ic_flg;
	}

	/**
	 * returns the string value of cargo.
	 */
	@Override
	public String inspectCargo() {
		return new StringBuilder().append("BNFT_INDV: ").append("bnft_pin_num=").append(bnft_pin_num).append("brth_dt=").append(brth_dt)
				.append("dth_dt=").append(dth_dt).append("fst_nam=").append(fst_nam).append("last_nam=").append(last_nam).append("mid_init=")
				.append(mid_init).append("sex_ind=").append(sex_ind).append("sfx_nam=").append(sfx_nam).append("updt_dt=").append(updt_dt)
				.append("mci_id=").append(mci_id).append("ic_flg=").append(ic_flg).toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((bnft_pin_num == null) ? 0 : bnft_pin_num.trim().hashCode());
		result = (prime * result) + ((brth_dt == null) ? 0 : brth_dt.trim().hashCode());
		result = (prime * result) + ((dth_dt == null) ? 0 : dth_dt.trim().hashCode());
		result = (prime * result) + ((fst_nam == null) ? 0 : fst_nam.trim().hashCode());
		result = (prime * result) + ((ic_flg == null) ? 0 : ic_flg.trim().hashCode());
		result = (prime * result) + ((last_nam == null) ? 0 : last_nam.trim().hashCode());
		result = (prime * result) + ((mci_id == null) ? 0 : mci_id.trim().hashCode());
		result = (prime * result) + ((mid_init == null) ? 0 : mid_init.trim().hashCode());
		result = (prime * result) + ((sex_ind == null) ? 0 : sex_ind.trim().hashCode());
		result = (prime * result) + ((sfx_nam == null) ? 0 : sfx_nam.trim().hashCode());
		result = (prime * result) + ((updt_dt == null) ? 0 : updt_dt.trim().hashCode());
		return result;
	}

	/**
	 * returns the PrimaryKey object.
	 */
	@Override
	public IPrimaryKey getPrimaryKey() {
		final BNFT_INDV_PrimaryKey key = new BNFT_INDV_PrimaryKey();
		key.setBnft_pin_num(getBnft_pin_num());
		return key;
	}

	/**
	 * compares the given cargo with this cargo and returns the changed
	 * attribute-value Map.
	 */
	public Map compareAttributes(final BNFT_INDV_Cargo aCargo) {
		final Map changedAttributeValue = new HashMap();
		if (!((aCargo.getBnft_pin_num() == null) && (bnft_pin_num == null))
				&& !((aCargo.getBnft_pin_num() != null) && aCargo.getBnft_pin_num().equals(bnft_pin_num))) {
			changedAttributeValue.put("bnft_pin_num", aCargo.getBnft_pin_num());
		}
		if (!((aCargo.getBrth_dt() == null) && (brth_dt == null)) && !((aCargo.getBrth_dt() != null) && aCargo.getBrth_dt().equals(brth_dt))) {
			changedAttributeValue.put("brth_dt", aCargo.getBrth_dt());
		}
		if (!((aCargo.getDth_dt() == null) && (dth_dt == null)) && !((aCargo.getDth_dt() != null) && aCargo.getDth_dt().equals(dth_dt))) {
			changedAttributeValue.put("dth_dt", aCargo.getDth_dt());
		}
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
		if (!((aCargo.getSfx_nam() == null) && (sfx_nam == null)) && !((aCargo.getSfx_nam() != null) && aCargo.getSfx_nam().equals(sfx_nam))) {
			changedAttributeValue.put("sfx_nam", aCargo.getSfx_nam());
		}
		if (!((aCargo.getUpdt_dt() == null) && (updt_dt == null)) && !((aCargo.getUpdt_dt() != null) && aCargo.getUpdt_dt().equals(updt_dt))) {
			changedAttributeValue.put("updt_dt", aCargo.getUpdt_dt());
		}
		if (!((aCargo.getMci_id() == null) && (mci_id == null)) && !((aCargo.getMci_id() != null) && aCargo.getMci_id().equals(mci_id))) {
			changedAttributeValue.put("mci_id", aCargo.getMci_id());
		}
		if (!((aCargo.getIc_flg() == null) && (ic_flg == null)) && !((aCargo.getIc_flg() != null) && aCargo.getIc_flg().equals(ic_flg))) {
			changedAttributeValue.put("ic_flg", aCargo.getIc_flg());
		}
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
		final BNFT_INDV_Cargo other = (BNFT_INDV_Cargo) obj;
		if (bnft_pin_num == null) {
			if (other.bnft_pin_num != null) {
				return false;
			}
		} else if (!bnft_pin_num.equals(other.bnft_pin_num)) {
			return false;
		}
		if (brth_dt == null) {
			if (other.brth_dt != null) {
				return false;
			}
		} else if (!brth_dt.equals(other.brth_dt)) {
			return false;
		}
		if (dth_dt == null) {
			if (other.dth_dt != null) {
				return false;
			}
		} else if (!dth_dt.equals(other.dth_dt)) {
			return false;
		}
		if (fst_nam == null) {
			if (other.fst_nam != null) {
				return false;
			}
		} else if (!fst_nam.equals(other.fst_nam)) {
			return false;
		}
		if (ic_flg == null) {
			if (other.ic_flg != null) {
				return false;
			}
		} else if (!ic_flg.equals(other.ic_flg)) {
			return false;
		}
		if (last_nam == null) {
			if (other.last_nam != null) {
				return false;
			}
		} else if (!last_nam.equals(other.last_nam)) {
			return false;
		}
		if (mci_id == null) {
			if (other.mci_id != null) {
				return false;
			}
		} else if (!mci_id.equals(other.mci_id)) {
			return false;
		}
		if (mid_init == null) {
			if (other.mid_init != null) {
				return false;
			}
		} else if (!mid_init.equals(other.mid_init)) {
			return false;
		}
		if (sex_ind == null) {
			if (other.sex_ind != null) {
				return false;
			}
		} else if (!sex_ind.equals(other.sex_ind)) {
			return false;
		}
		if (sfx_nam == null) {
			if (other.sfx_nam != null) {
				return false;
			}
		} else if (!sfx_nam.equals(other.sfx_nam)) {
			return false;
		}
		if (updt_dt == null) {
			if (other.updt_dt != null) {
				return false;
			}
		} else if (!updt_dt.equals(other.updt_dt)) {
			return false;
		}
		return true;
	}

}