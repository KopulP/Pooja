package gov.state.nextgen.access.business.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AppInMedBillsPrimaryKey implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String app_num;
	private String indv_seq_num;
	private String medical_seq_num;
	private String med_bill_type;

	/**
	 * returns the app_num value.
	 */
	public String getApp_num() {
		return app_num;
	}

	/**
	 * returns the indv_seq_num value.
	 */
	public String getIndv_seq_num() {
		return indv_seq_num;
	}

	/**
	 * returns the medical_seq_num value.
	 */
	public String getMedical_seq_num() {
		return medical_seq_num;
	}

	/**
	 * returns the med_bill_type value.
	 */
	public String getMed_bill_type() {
		return med_bill_type;
	}

	/**
	 * sets the app_num value.
	 */
	public void setApp_num(final String app_num) {
		this.app_num = app_num;
	}

	/**
	 * sets the indv_seq_num value.
	 */
	public void setIndv_seq_num(final String indv_seq_num) {
		this.indv_seq_num = indv_seq_num;
	}

	/**
	 * sets the medical_seq_num value.
	 */
	public void setMedical_seq_num(final String medical_seq_num) {
		this.medical_seq_num = medical_seq_num;
	}

	/**
	 * sets the med_bill_type value.
	 */
	public void setMed_bill_type(final String med_bill_type) {
		this.med_bill_type = med_bill_type;
	}

	
	}
