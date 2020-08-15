package gov.state.nextgen.access.business.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "APP_IN_RM_BRD_EXP")
public class AppInRmBrdExpCargo extends AbstractCargo implements Serializable{

	/**
	 *
	 */
	
	@EmbeddedId
	private AppInRmBrdExpPrimaryKey key;
	private static final long serialVersionUID = 1L;

	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.impl.APP_IN_RM_BRD_EXP";

	boolean isDirty = false;
	private String brd_exp_amt;
	private String brd_exp_ind;
	private String brder_sw;
	private String chg_eff_dt;
	private String p_to_indv_seq_num;
	private String room_exp_amt;
	private String room_exp_ind;
	private String room_meal_dy_qty;
	private String roomer_sw;

	

	/**
	 * returns the brd_exp_amt value.
	 */
	public String getBrd_exp_amt() {
		return displayFormatter.getNumberFormat(brd_exp_amt);
	}

	/**
	 * returns the brd_exp_ind value.
	 */
	public String getBrd_exp_ind() {
		return brd_exp_ind;
	}

	/**
	 * returns the brder_sw value.
	 */
	public String getBrder_sw() {
		return brder_sw;
	}

	/**
	 * returns the chg_eff_dt value.
	 */
	public String getChg_eff_dt() {
		return chg_eff_dt;
	}

	/**
	 * returns the p_to_indv_seq_num value.
	 */
	public String getP_to_indv_seq_num() {
		return p_to_indv_seq_num;
	}

	/**
	 * returns the room_exp_amt value.
	 */
	public String getRoom_exp_amt() {
		return displayFormatter.getNumberFormat(room_exp_amt);
	}

	/**
	 * returns the room_exp_ind value.
	 */
	public String getRoom_exp_ind() {
		return room_exp_ind;
	}

	/**
	 * returns the room_meal_dy_qty value.
	 */
	public String getRoom_meal_dy_qty() {
		return room_meal_dy_qty;
	}

	/**
	 * returns the roomer_sw value.
	 */
	public String getRoomer_sw() {
		return roomer_sw;
	}

	/**
	 * sets the brd_exp_amt value.
	 */
	public void setBrd_exp_amt(final String brd_exp_amt) {
		this.brd_exp_amt = brd_exp_amt;
	}

	/**
	 * sets the brd_exp_ind value.
	 */
	public void setBrd_exp_ind(final String brd_exp_ind) {
		this.brd_exp_ind = brd_exp_ind;
	}

	/**
	 * sets the brder_sw value.
	 */
	public void setBrder_sw(final String brder_sw) {
		this.brder_sw = brder_sw;
	}

	/**
	 * sets the chg_eff_dt value.
	 */
	public void setChg_eff_dt(final String chg_eff_dt) {
		this.chg_eff_dt = chg_eff_dt;
	}

	/**
	 * sets the p_to_indv_seq_num value.
	 */
	public void setP_to_indv_seq_num(final String p_to_indv_seq_num) {
		this.p_to_indv_seq_num = p_to_indv_seq_num;
	}

	/**
	 * sets the room_exp_amt value.
	 */
	public void setRoom_exp_amt(final String room_exp_amt) {
		this.room_exp_amt = room_exp_amt;
	}

	/**
	 * sets the room_exp_ind value.
	 */
	public void setRoom_exp_ind(final String room_exp_ind) {
		this.room_exp_ind = room_exp_ind;
	}

	/**
	 * sets the room_meal_dy_qty value.
	 */
	public void setRoom_meal_dy_qty(final String room_meal_dy_qty) {
		this.room_meal_dy_qty = room_meal_dy_qty;
	}

	/**
	 * sets the roomer_sw value.
	 */
	public void setRoomer_sw(final String roomer_sw) {
		this.roomer_sw = roomer_sw;
	}

	/**
	 * returns the PrimaryKey object.
	 */
	
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
	 * returns the string value of cargo.
	 */
	@Override
	public String inspectCargo() {
		return new StringBuilder().append("APP_IN_RM_BRD_EXP: ").append("payr_indv_seq_num=")
				.append("brd_exp_amt=")
				.append(brd_exp_amt).append("brd_exp_ind=").append(brd_exp_ind).append("brder_sw=").append(brder_sw).append("chg_eff_dt=")
				.append(chg_eff_dt).append("p_to_indv_seq_num=").append(p_to_indv_seq_num).append("room_exp_amt=").append(room_exp_amt)
				.append("room_exp_ind=").append(room_exp_ind).append("room_meal_dy_qty=").append(room_meal_dy_qty).append("roomer_sw=")
				.append(roomer_sw).toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((brd_exp_amt == null) ? 0 : brd_exp_amt.trim().hashCode());
		result = (prime * result) + ((brd_exp_ind == null) ? 0 : brd_exp_ind.trim().hashCode());
		result = (prime * result) + ((brder_sw == null) ? 0 : brder_sw.trim().hashCode());
		result = (prime * result) + ((chg_eff_dt == null) ? 0 : chg_eff_dt.trim().hashCode());
		result = (prime * result) + ((p_to_indv_seq_num == null) ? 0 : p_to_indv_seq_num.trim().hashCode());
		result = (prime * result) + ((room_exp_amt == null) ? 0 : room_exp_amt.trim().hashCode());
		result = (prime * result) + ((room_exp_ind == null) ? 0 : room_exp_ind.trim().hashCode());
		result = (prime * result) + ((room_meal_dy_qty == null) ? 0 : room_meal_dy_qty.trim().hashCode());
		result = (prime * result) + ((roomer_sw == null) ? 0 : roomer_sw.trim().hashCode());
		return result;
	}

	public Map compareAttributes(final AppInRmBrdExpCargo aCargo) {
		final Map changedAttributeValue = new HashMap();
		if (!((aCargo.getBrd_exp_amt() == null) && (brd_exp_amt == null))
				&& !((aCargo.getBrd_exp_amt() != null) && aCargo.getBrd_exp_amt().equals(getBrd_exp_amt()))) {
			changedAttributeValue.put("brd_exp_amt", aCargo.getBrd_exp_amt());
		}
		if (!((aCargo.getBrder_sw() == null) && (brder_sw == null))
				&& !((aCargo.getBrder_sw() != null) && aCargo.getBrder_sw().trim().equals(brder_sw.trim()))) {
			changedAttributeValue.put("brder_sw", aCargo.getBrder_sw());
		}
		if (!((aCargo.getRoomer_sw() == null) && (roomer_sw == null))
				&& !((aCargo.getRoomer_sw() != null) && aCargo.getRoomer_sw().trim().equals(roomer_sw.trim()))) {
			changedAttributeValue.put("roomer_sw", aCargo.getRoomer_sw());
		}
		if (!((aCargo.getRoom_exp_amt() == null) && (room_exp_amt == null))
				&& !((aCargo.getRoom_exp_amt() != null) && aCargo.getRoom_exp_amt().equals(getRoom_exp_amt()))) {
			changedAttributeValue.put("room_exp_amt", aCargo.getRoom_exp_amt());
		}
		if (!((aCargo.getRoom_meal_dy_qty() == null) && (room_meal_dy_qty == null))
				&& !((aCargo.getRoom_meal_dy_qty() != null) && aCargo.getRoom_meal_dy_qty().equals(room_meal_dy_qty))) {
			changedAttributeValue.put("room_meal_dy_qty", aCargo.getRoom_meal_dy_qty());
		}
		if (!((aCargo.getP_to_indv_seq_num() == null) && (p_to_indv_seq_num == null))
				&& !((aCargo.getP_to_indv_seq_num() != null) && aCargo.getP_to_indv_seq_num().trim().equals(p_to_indv_seq_num.trim()))) {
			changedAttributeValue.put("p_to_indv_seq_num", aCargo.getP_to_indv_seq_num());
		}
		if (!((aCargo.getChg_eff_dt() == null) && (chg_eff_dt == null))
				&& !((aCargo.getChg_eff_dt() != null) && aCargo.getChg_eff_dt().equals(chg_eff_dt))) {
			changedAttributeValue.put("chg_eff_dt", aCargo.getChg_eff_dt());
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
		final AppInRmBrdExpCargo other = (AppInRmBrdExpCargo) obj;
		
		if (brd_exp_amt == null) {
			if (other.brd_exp_amt != null) {
				return false;
			}
		} else if (!brd_exp_amt.equals(other.brd_exp_amt)) {
			return false;
		}
		if (brd_exp_ind == null) {
			if (other.brd_exp_ind != null) {
				return false;
			}
		} else if (!brd_exp_ind.equals(other.brd_exp_ind)) {
			return false;
		}
		if (brder_sw == null) {
			if (other.brder_sw != null) {
				return false;
			}
		} else if (!brder_sw.equals(other.brder_sw)) {
			return false;
		}
		if (chg_eff_dt == null) {
			if (other.chg_eff_dt != null) {
				return false;
			}
		} else if (!chg_eff_dt.equals(other.chg_eff_dt)) {
			return false;
		}
		if (p_to_indv_seq_num == null) {
			if (other.p_to_indv_seq_num != null) {
				return false;
			}
		} else if (!p_to_indv_seq_num.equals(other.p_to_indv_seq_num)) {
			return false;
		}
		
		if (room_exp_amt == null) {
			if (other.room_exp_amt != null) {
				return false;
			}
		} else if (!room_exp_amt.equals(other.room_exp_amt)) {
			return false;
		}
		if (room_exp_ind == null) {
			if (other.room_exp_ind != null) {
				return false;
			}
		} else if (!room_exp_ind.equals(other.room_exp_ind)) {
			return false;
		}
		if (room_meal_dy_qty == null) {
			if (other.room_meal_dy_qty != null) {
				return false;
			}
		} else if (!room_meal_dy_qty.equals(other.room_meal_dy_qty)) {
			return false;
		}
		if (roomer_sw == null) {
			if (other.roomer_sw != null) {
				return false;
			}
		} else if (!roomer_sw.equals(other.roomer_sw)) {
			return false;
		}
		
		return true;
	}
}
