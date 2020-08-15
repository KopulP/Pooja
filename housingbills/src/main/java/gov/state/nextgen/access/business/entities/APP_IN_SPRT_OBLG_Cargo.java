/*
 * 
 */
package gov.state.nextgen.access.business.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;



/**
 * This java bean contains the entities of OTHR_RSN
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date Aug 26 15:58:45 CDT 2009 Modified By: Modified on: PCR#
 */

@Entity
@Table(name = "APP_IN_SPRT_OBLG")
public class APP_IN_SPRT_OBLG_Cargo extends AbstractCargo implements Serializable {

	/**
	 *
	 */
	@EmbeddedId
	private APP_IN_SPRT_OBLG_PrimaryKey key ;
	
	private static final long serialVersionUID = 1L;

	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.impl.APP_IN_SPRT_OBLG";

	boolean isDirty = false;
	private String chg_eff_dt;
	private String crt_ord_sw;
	private String oblg_amt;
	private String oblg_ind;
	private String sprt_typ_cd;

		/**
	 * returns the chg_eff_dt value.
	 */
	public String getChg_eff_dt() {
		return chg_eff_dt;
	}

	/**
	 * returns the crt_ord_sw value.
	 */
	public String getCrt_ord_sw() {
		return crt_ord_sw;
	}

	/**
	 * returns the oblg_amt value.
	 */
	public String getOblg_amt() {
		return displayFormatter.getNumberFormat(oblg_amt);
	}

	/**
	 * returns the oblg_ind value.
	 */
	public String getOblg_ind() {
		return oblg_ind;
	}

	/**
	 * returns the sprt_typ_cd value.
	 */
	public String getSprt_typ_cd() {
		return sprt_typ_cd;
	}

	
	/**
	 * sets the chg_eff_dt value.
	 */
	public void setChg_eff_dt(final String chg_eff_dt) {
		this.chg_eff_dt = chg_eff_dt;
	}

	/**
	 * sets the crt_ord_sw value.
	 */
	public void setCrt_ord_sw(final String crt_ord_sw) {
		this.crt_ord_sw = crt_ord_sw;
	}

	/**
	 * sets the oblg_amt value.
	 */
	public void setOblg_amt(final String oblg_amt) {
		this.oblg_amt = oblg_amt;
	}

	/**
	 * sets the oblg_ind value.
	 */
	public void setOblg_ind(final String oblg_ind) {
		this.oblg_ind = oblg_ind;
	}

	/**
	 * sets the sprt_typ_cd value.
	 */
	public void setSprt_typ_cd(final String sprt_typ_cd) {
		this.sprt_typ_cd = sprt_typ_cd;
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
		return new StringBuilder().append("APP_IN_SPRT_OBLG: ")
				.append("chg_eff_dt=").append(chg_eff_dt)
				.append("crt_ord_sw=").append(crt_ord_sw).append("oblg_amt=").append(oblg_amt).append("oblg_ind=").append(oblg_ind)
				.append("sprt_typ_cd=").append(sprt_typ_cd).toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((chg_eff_dt == null) ? 0 : chg_eff_dt.trim().hashCode());
		result = (prime * result) + ((crt_ord_sw == null) ? 0 : crt_ord_sw.trim().hashCode());
		result = (prime * result) + ((oblg_amt == null) ? 0 : oblg_amt.trim().hashCode());
		result = (prime * result) + ((oblg_ind == null) ? 0 : oblg_ind.trim().hashCode());
		result = (prime * result) + ((sprt_typ_cd == null) ? 0 : sprt_typ_cd.trim().hashCode());
		return result;
	}

	public Map compareAttributes(final APP_IN_SPRT_OBLG_Cargo aCargo) {
		final Map changedAttributeValue = new HashMap();
		
		if (!((aCargo.getChg_eff_dt() == null) && (chg_eff_dt == null))
				&& !((aCargo.getChg_eff_dt() != null) && aCargo.getChg_eff_dt().equals(chg_eff_dt))) {
			changedAttributeValue.put("chg_eff_dt", aCargo.getChg_eff_dt());
		}
		if (!((aCargo.getCrt_ord_sw() == null) && (crt_ord_sw == null))
				&& !((aCargo.getCrt_ord_sw() != null) && aCargo.getCrt_ord_sw().equals(crt_ord_sw))) {
			changedAttributeValue.put("crt_ord_sw", aCargo.getCrt_ord_sw());
		}
		if (!((aCargo.getSprt_typ_cd() == null) && (sprt_typ_cd == null))
				&& !((aCargo.getSprt_typ_cd() != null) && aCargo.getSprt_typ_cd().equals(sprt_typ_cd))) {
			changedAttributeValue.put("sprt_typ_cd", aCargo.getSprt_typ_cd());
		}
		if (!((aCargo.getOblg_amt() == null) && (oblg_amt == null))
				&& !((aCargo.getOblg_amt() != null) && aCargo.getOblg_amt().equals(getOblg_amt()))) {
			changedAttributeValue.put("oblg_amt", aCargo.getOblg_amt());
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
		final APP_IN_SPRT_OBLG_Cargo other = (APP_IN_SPRT_OBLG_Cargo) obj;
		
		if (chg_eff_dt == null) {
			if (other.chg_eff_dt != null) {
				return false;
			}
		} else if (!chg_eff_dt.equals(other.chg_eff_dt)) {
			return false;
		}
		if (crt_ord_sw == null) {
			if (other.crt_ord_sw != null) {
				return false;
			}
		} else if (!crt_ord_sw.equals(other.crt_ord_sw)) {
			return false;
		}
		if (oblg_amt == null) {
			if (other.oblg_amt != null) {
				return false;
			}
		} else if (!oblg_amt.equals(other.oblg_amt)) {
			return false;
		}
		if (oblg_ind == null) {
			if (other.oblg_ind != null) {
				return false;
			}
		} else if (!oblg_ind.equals(other.oblg_ind)) {
			return false;
		}
		if (sprt_typ_cd == null) {
			if (other.sprt_typ_cd != null) {
				return false;
			}
		} else if (!sprt_typ_cd.equals(other.sprt_typ_cd)) {
			return false;
		}
		return true;
	}

}