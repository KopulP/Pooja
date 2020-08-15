package gov.state.nextgen.access.business.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "APP_IN_IRWE")
public class AppInIrweCargo extends AbstractCargo implements Serializable{

	/**
	 *
	 */
	
	@EmbeddedId
	private AppInIrwePrimaryKey key ;
	
	private static final long serialVersionUID = 1L;

	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.impl.APP_IN_IRWE";

	@Transient
	boolean isDirty = false;
	
	private String chg_eff_dt;
	private String exp_typ_cd;
	private String mo_exp_amt;
	private String mo_exp_ind;






	/**
	 * returns the chg_eff_dt value.
	 */
	public String getChg_eff_dt() {
		return chg_eff_dt;
	}

	/**
	 * returns the exp_typ_cd value.
	 */
	public String getExp_typ_cd() {
		return exp_typ_cd;
	}

	/**
	 * returns the mo_exp_amt value.
	 */
	public String getMo_exp_amt() {
		return displayFormatter.getNumberFormat(mo_exp_amt);
	}

	/**
	 * returns the mo_exp_ind value.
	 */
	public String getMo_exp_ind() {
		return mo_exp_ind;
	}



	/**
	 * sets the chg_eff_dt value.
	 */
	public void setChg_eff_dt(final String chg_eff_dt) {
		this.chg_eff_dt = chg_eff_dt;
	}

	/**
	 * sets the exp_typ_cd value.
	 */
	public void setExp_typ_cd(final String exp_typ_cd) {
		this.exp_typ_cd = exp_typ_cd;
	}

	/**
	 * sets the mo_exp_amt value.
	 */
	public void setMo_exp_amt(final String mo_exp_amt) {
		this.mo_exp_amt = mo_exp_amt;
	}

	/**
	 * sets the mo_exp_ind value.
	 */
	public void setMo_exp_ind(final String mo_exp_ind) {
		this.mo_exp_ind = mo_exp_ind;
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
		return new StringBuilder().append("APP_IN_IRWE: ")
			.append("chg_eff_dt=").append(chg_eff_dt)
				.append("exp_typ_cd=").append(exp_typ_cd).append("mo_exp_amt=").append(mo_exp_amt).append("mo_exp_ind=").append(mo_exp_ind)
				.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((chg_eff_dt == null) ? 0 : chg_eff_dt.trim().hashCode());
		result = (prime * result) + ((exp_typ_cd == null) ? 0 : exp_typ_cd.trim().hashCode());
		result = (prime * result) + ((mo_exp_amt == null) ? 0 : mo_exp_amt.trim().hashCode());
		result = (prime * result) + ((mo_exp_ind == null) ? 0 : mo_exp_ind.trim().hashCode());
		return result;
	}

	public Map compareAttributes(final AppInIrweCargo aCargo) {
		final Map changedAttributeValue = new HashMap();
		
		if (!((aCargo.getChg_eff_dt() == null) && (chg_eff_dt == null))
				&& !((aCargo.getChg_eff_dt() != null) && aCargo.getChg_eff_dt().equals(chg_eff_dt))) {
			changedAttributeValue.put("chg_eff_dt", aCargo.getChg_eff_dt());
		}
		if (!((aCargo.getExp_typ_cd() == null) && (exp_typ_cd == null))
				&& !((aCargo.getExp_typ_cd() != null) && aCargo.getExp_typ_cd().equals(exp_typ_cd))) {
			changedAttributeValue.put("exp_typ_cd", aCargo.getExp_typ_cd());
		}
		if (!((aCargo.getMo_exp_amt() == null) && (mo_exp_amt == null))
				&& !((aCargo.getMo_exp_amt() != null) && aCargo.getMo_exp_amt().equals(getMo_exp_amt()))) {
			changedAttributeValue.put("mo_exp_amt", aCargo.getMo_exp_amt());
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
		final AppInIrweCargo other = (AppInIrweCargo) obj;
		
		if (chg_eff_dt == null) {
			if (other.chg_eff_dt != null) {
				return false;
			}
		} else if (!chg_eff_dt.equals(other.chg_eff_dt)) {
			return false;
		}
		if (exp_typ_cd == null) {
			if (other.exp_typ_cd != null) {
				return false;
			}
		} else if (!exp_typ_cd.equals(other.exp_typ_cd)) {
			return false;
		}
		
		if (mo_exp_amt == null) {
			if (other.mo_exp_amt != null) {
				return false;
			}
		} else if (!mo_exp_amt.equals(other.mo_exp_amt)) {
			return false;
		}
		if (mo_exp_ind == null) {
			if (other.mo_exp_ind != null) {
				return false;
			}
		} else if (!mo_exp_ind.equals(other.mo_exp_ind)) {
			return false;
		}
		
		
		return true;
	}
}