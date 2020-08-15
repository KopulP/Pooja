package gov.state.nextgen.access.business.entities;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CP_APP_IN_IRWE")
public class CpAppInIrweCargo  implements java.io.Serializable{

	
	@Transient
	boolean isDirty = false;
	
	@EmbeddedId
	private CpAppInIrwePrimaryKey cpAppInIrwePrimaryKey;
	
	private String expense_reason;
	private String mo_exp_amt;
	private String rec_cplt_ind;
	
	public boolean isDirty() {
		return isDirty;
	}

	public void setDirty(boolean isDirty) {
		this.isDirty = isDirty;
	}

	public String getRec_cplt_ind() {
		return rec_cplt_ind;
	}

	public void setRec_cplt_ind(String rec_cplt_ind) {
		this.rec_cplt_ind = rec_cplt_ind;
	}

	private String expense_end_dt;

	public String getExpense_end_dt() {
		return expense_end_dt;
	}

	public void setExpense_end_dt(final String expense_end_dt) {
		this.expense_end_dt = expense_end_dt;
	}


	public String getExpense_reason() {
		return expense_reason;
	}

	public void setExpense_reason(final String expense_reason) {
		this.expense_reason = expense_reason;
	}

	

	public void setMo_exp_amt(final String mo_exp_amt) {
		this.mo_exp_amt = mo_exp_amt;
	}

	}
