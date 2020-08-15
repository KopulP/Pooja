package gov.state.nextgen.access.business.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "APP_IN_MED_BILLS")
public class AppInMedBillsCargo  implements Serializable{

	@EmbeddedId
	private AppInMedBillsPrimaryKey appInMedBillsPrimaryKey;
	
	boolean isDirty = false;
	private String pymnt_amnt;
	private String pay_freq;
	private String rec_cplt_ind;
	private String src_app_ind;
	private String medical_bill_end_dt;
	public boolean isDirty() {
		return isDirty;
	}
	public void setDirty(boolean isDirty) {
		this.isDirty = isDirty;
	}
	public String getPymnt_amnt() {
		return pymnt_amnt;
	}
	public void setPymnt_amnt(String pymnt_amnt) {
		this.pymnt_amnt = pymnt_amnt;
	}
	public String getPay_freq() {
		return pay_freq;
	}
	public void setPay_freq(String pay_freq) {
		this.pay_freq = pay_freq;
	}
	public String getRec_cplt_ind() {
		return rec_cplt_ind;
	}
	public void setRec_cplt_ind(String rec_cplt_ind) {
		this.rec_cplt_ind = rec_cplt_ind;
	}
	public String getSrc_app_ind() {
		return src_app_ind;
	}
	public void setSrc_app_ind(String src_app_ind) {
		this.src_app_ind = src_app_ind;
	}
	public String getMedical_bill_end_dt() {
		return medical_bill_end_dt;
	}
	public void setMedical_bill_end_dt(String medical_bill_end_dt) {
		this.medical_bill_end_dt = medical_bill_end_dt;
	}
	
	
}
