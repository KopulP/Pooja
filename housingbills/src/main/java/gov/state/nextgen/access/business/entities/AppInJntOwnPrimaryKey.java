package gov.state.nextgen.access.business.entities;

import javax.persistence.Embeddable;

@Embeddable
public class AppInJntOwnPrimaryKey implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private String app_num;
	private String indv_seq_num;
	private String seq_num;
	private String aset_typ;
	private String jnt_own_seq_num;

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
	 * returns the indv_seq_num value.
	 */
	public String getIndv_seq_num() {
		return indv_seq_num;
	}

	/**
	 * sets the indv_seq_num value.
	 */
	public void setIndv_seq_num(final String indv_seq_num) {
		this.indv_seq_num = indv_seq_num;
	}

	/**
	 * returns the seq_num value.
	 */
	public String getSeq_num() {
		return seq_num;
	}

	/**
	 * sets the seq_num value.
	 */
	public void setSeq_num(final String seq_num) {
		this.seq_num = seq_num;
	}

	/**
	 * returns the aset_typ value.
	 */
	public String getAset_typ() {
		return aset_typ;
	}

	/**
	 * sets the aset_typ value.
	 */
	public void setAset_typ(final String aset_typ) {
		this.aset_typ = aset_typ;
	}

	/**
	 * returns the jnt_own_seq_num value.
	 */
	public String getJnt_own_seq_num() {
		return jnt_own_seq_num;
	}

	/**
	 * sets the jnt_own_seq_num value.
	 */
	public void setJnt_own_seq_num(final String jnt_own_seq_num) {
		this.jnt_own_seq_num = jnt_own_seq_num;
	}

	
	}
