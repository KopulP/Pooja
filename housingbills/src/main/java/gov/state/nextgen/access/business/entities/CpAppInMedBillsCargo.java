package gov.state.nextgen.access.business.entities;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CP_APP_IN_MED_BILLS")
public class CpAppInMedBillsCargo  implements java.io.Serializable{

	
	private static final long serialVersionUID = 1L;

	@Transient
	boolean isDirty = false;

	@EmbeddedId
	private CpAppInMedBillsPrimaryKey cpAppInMedBillsPrimaryKey;
	
	private String med_bill_type;
	private String pymnt_amnt;
	private String pay_freq;
	private String rec_cplt_ind;
	private String medical_bill_end_dt;
	private String src_app_ind;
	private String adapt_record_id;

	private String loopingQuestion;

	private String Need_type_cd;
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

	
	public String getMed_bill_type() {
		return med_bill_type;
	}

	public void setMed_bill_type(final String med_bill_type) {
		this.med_bill_type = med_bill_type;
	}

	public String getPymnt_amnt() {
		return pymnt_amnt;
	}

	public void setPymnt_amnt(final String pymnt_amnt) {
		this.pymnt_amnt = pymnt_amnt;
	}

	public String getPay_freq() {
		return pay_freq;
	}

	public void setPay_freq(final String pay_freq) {
		this.pay_freq = pay_freq;
	}

	public String getRec_cplt_ind() {
		return rec_cplt_ind;
	}

	public void setRec_cplt_ind(final String rec_cplt_ind) {
		this.rec_cplt_ind = rec_cplt_ind;
	}

	public String getMedical_bill_end_dt() {
		return medical_bill_end_dt;
	}

	public void setMedical_bill_end_dt(final String medical_bill_end_dt) {
		this.medical_bill_end_dt = medical_bill_end_dt;
	}

	public String getSrc_app_ind() {
		return src_app_ind;
	}

	public void setSrc_app_ind(final String src_app_ind) {
		this.src_app_ind = src_app_ind;
	}

	public String getAdapt_record_id() {
		return adapt_record_id;
	}

	public void setAdapt_record_id(final String adapt_record_id) {
		this.adapt_record_id = adapt_record_id;
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

}
