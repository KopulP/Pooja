package gov.state.nextgen.access.business.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "APP_IN_SPRT_OBLG")
public class AppInSprtObblgCargo implements Serializable {

	@EmbeddedId
	private AppInSprtOblgPrimaryKey appInSprtOblgPrimaryKey;

	@Transient
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

}
