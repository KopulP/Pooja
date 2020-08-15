package gov.state.nextgen.access.business.entities;

import gov.state.nextgen.access.business.entities.AbstractCargo;
import gov.state.nextgen.access.business.entities.IPrimaryKey;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CP_APP_PRGM_INDV")
public class APP_PRGM_INDV_Cargo {
	
	private static final long serialVersionUID = 1L;
	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.APP_PRGM_INDV";
	
		
	@EmbeddedId
	private AppPrgmIndvIdentity identity;
	
	/*
	 * private String app_num; private String indv_seq_num; private String
	 * src_app_ind;
	 */
	private String cc_ind;
	private String ma_ind;
	private String fs_ind;
	private String ta_ind;
	private String wc_ind;
	
	
	
	/**
	 * @return the package
	 */
	public static String getPackage() {
		return PACKAGE;
	}
	/**
	 * @return the cc_ind
	 */
	public String getCc_ind() {
		return cc_ind;
	}
	/**
	 * @param cc_ind the cc_ind to set
	 */
	public void setCc_ind(String cc_ind) {
		this.cc_ind = cc_ind;
	}
	/**
	 * @return the ma_ind
	 */
	public String getMa_ind() {
		return ma_ind;
	}
	/**
	 * @param ma_ind the ma_ind to set
	 */
	public void setMa_ind(String ma_ind) {
		this.ma_ind = ma_ind;
	}
	/**
	 * @return the fs_ind
	 */
	public String getFs_ind() {
		return fs_ind;
	}
	/**
	 * @param fs_ind the fs_ind to set
	 */
	public void setFs_ind(String fs_ind) {
		this.fs_ind = fs_ind;
	}
	/**
	 * @return the ta_ind
	 */
	public String getTa_ind() {
		return ta_ind;
	}
	/**
	 * @param ta_ind the ta_ind to set
	 */
	public void setTa_ind(String ta_ind) {
		this.ta_ind = ta_ind;
	}
	/**
	 * @return the wc_ind
	 */
	public String getWc_ind() {
		return wc_ind;
	}
	/**
	 * @param wc_ind the wc_ind to set
	 */
	public void setWc_ind(String wc_ind) {
		this.wc_ind = wc_ind;
	}
	
	/*
	 * @Override public String inspectCargo() { return new
	 * StringBuilder().append("APP_PRGM_INDV: ").append("app_num=").append(app_num).
	 * append("indv_seq_num=").append(indv_seq_num)
	 * .append("src_app_ind=").append(src_app_ind).append("cc_ind=").append(cc_ind).
	 * append("ma_ind=").append(ma_ind).append("fs_ind=")
	 * .append(fs_ind).append("ta_ind=").append(ta_ind).append("wc_ind=").append(
	 * wc_ind).toString(); }
	 */

	/*
	 * @Override public IPrimaryKey getPrimaryKey() { final APP_PRGM_INDV_PrimaryKey
	 * key = new APP_PRGM_INDV_PrimaryKey(); key.setApp_num(getApp_num());
	 * key.setIndv_seq_num(getIndv_seq_num()); key.setSrc_app_ind(getSrc_app_ind());
	 * 
	 * return key; }
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */

	
}
