package gov.state.nextgen.access.business.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CP_APP_IN_INCOME_TAX_DED")
public class CpAppInIncomeTaxDedCargo extends AbstractCargo implements Serializable,IHistoryType6{

	/**
	 *
	 */
	@EmbeddedId
	private CpAppInIncomeTaxDedPrimaryKey key ;
	
	private static final long serialVersionUID = 1L;

	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.CP_APP_IN_INCOME_TAX_DED";

	boolean isDirty = false;
	private String ecp_id;
	private String end_date;
	private String educator_exp;
	private String business_exp;
	private String health_saving_exp;
	private String moving_exp;
	private String deductible_self_exp;
	private String self_sep_exp;
	private String self_health_exp;
	private String penalty_exp;
	private String alimony_exp;
	private String ira_exp;
	private String student_loan_exp;
	private String tution_exp;
	private String domestic_exp;
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



	/**
	 *returns the ecp_id value.
	 */
	public String getEcp_id() {
		return ecp_id;
	}

	/**
	 *returns the end_date value.
	 */
	public String getEnd_date() {
		return end_date;
	}

	/**
	 *returns the educator_exp value.
	 */
	public String getEducator_exp() {
		return educator_exp;
	}

	/**
	 *returns the business_exp value.
	 */
	public String getBusiness_exp() {
		return business_exp;
	}

	/**
	 *returns the health_saving_exp value.
	 */
	public String getHealth_saving_exp() {
		return health_saving_exp;
	}

	/**
	 *returns the moving_exp value.
	 */
	public String getMoving_exp() {
		return moving_exp;
	}

	/**
	 *returns the deductible_self_exp value.
	 */
	public String getDeductible_self_exp() {
		return deductible_self_exp;
	}

	/**
	 *returns the self_sep_exp value.
	 */
	public String getSelf_sep_exp() {
		return self_sep_exp;
	}

	/**
	 *returns the self_health_exp value.
	 */
	public String getSelf_health_exp() {
		return self_health_exp;
	}

	/**
	 *returns the penalty_exp value.
	 */
	public String getPenalty_exp() {
		return penalty_exp;
	}

	/**
	 *returns the alimony_exp value.
	 */
	public String getAlimony_exp() {
		return alimony_exp;
	}

	/**
	 *returns the ira_exp value.
	 */
	public String getIra_exp() {
		return ira_exp;
	}

	/**
	 *returns the student_loan_exp value.
	 */
	public String getStudent_loan_exp() {
		return student_loan_exp;
	}

	/**
	 *returns the tution_exp value.
	 */
	public String getTution_exp() {
		return tution_exp;
	}

	/**
	 *returns the domestic_exp value.
	 */
	public String getDomestic_exp() {
		return domestic_exp;
	}

	
	/**
	 *sets the ecp_id value.
	 */
	public void setEcp_id(final String ecp_id) {
		this.ecp_id = ecp_id;
	}

	/**
	 *sets the end_date value.
	 */
	public void setEnd_date(final String end_date) {
		this.end_date = end_date;
	}

	/**
	 *sets the educator_exp value.
	 */
	public void setEducator_exp(final String educator_exp) {
		this.educator_exp = educator_exp;
	}

	/**
	 *sets the business_exp value.
	 */
	public void setBusiness_exp(final String business_exp) {
		this.business_exp = business_exp;
	}

	/**
	 *sets the health_saving_exp value.
	 */
	public void setHealth_saving_exp(final String health_saving_exp) {
		this.health_saving_exp = health_saving_exp;
	}

	/**
	 *sets the moving_exp value.
	 */
	public void setMoving_exp(final String moving_exp) {
		this.moving_exp = moving_exp;
	}

	/**
	 *sets the deductible_self_exp value.
	 */
	public void setDeductible_self_exp(final String deductible_self_exp) {
		this.deductible_self_exp = deductible_self_exp;
	}

	/**
	 *sets the self_sep_exp value.
	 */
	public void setSelf_sep_exp(final String self_sep_exp) {
		this.self_sep_exp = self_sep_exp;
	}

	/**
	 *sets the self_health_exp value.
	 */
	public void setSelf_health_exp(final String self_health_exp) {
		this.self_health_exp = self_health_exp;
	}

	/**
	 *sets the penalty_exp value.
	 */
	public void setPenalty_exp(final String penalty_exp) {
		this.penalty_exp = penalty_exp;
	}

	/**
	 *sets the alimony_exp value.
	 */
	public void setAlimony_exp(final String alimony_exp) {
		this.alimony_exp = alimony_exp;
	}

	/**
	 *sets the ira_exp value.
	 */
	public void setIra_exp(final String ira_exp) {
		this.ira_exp = ira_exp;
	}

	/**
	 *sets the student_loan_exp value.
	 */
	public void setStudent_loan_exp(final String student_loan_exp) {
		this.student_loan_exp = student_loan_exp;
	}

	/**
	 *sets the tution_exp value.
	 */
	public void setTution_exp(final String tution_exp) {
		this.tution_exp = tution_exp;
	}

	

	/**
	 *returns the PrimaryKey object.
	 */
	
	public IPrimaryKey getPrimaryKey() {
		
		return key;
	}

	/**
	 *returns the PACKAGE name.
	 */
	public String getPackage() {
		return PACKAGE;
	}

	// NextGen  NG-6481 Phase 3 updates to ACA Streamline changes � start
	public Map compareAttributes(final CpAppInIncomeTaxDedCargo aCargo) {
		final Map changedAttributeValue = new HashMap();
		if (!((aCargo.getEducator_exp() == null) && (educator_exp == null))
				&& !((aCargo.getEducator_exp() != null) && aCargo.getEducator_exp().equals(educator_exp))) {
			changedAttributeValue.put("educator_exp", aCargo.getEducator_exp());
		}

		if (!((aCargo.getBusiness_exp() == null) && (business_exp == null))
				&& !((aCargo.getBusiness_exp() != null) && aCargo.getBusiness_exp().equals(business_exp))) {
			changedAttributeValue.put("business_exp", aCargo.getBusiness_exp());
		}

		if (!((aCargo.getHealth_saving_exp() == null) && (health_saving_exp == null))
				&& !((aCargo.getHealth_saving_exp() != null) && aCargo.getHealth_saving_exp().equals(health_saving_exp))) {
			changedAttributeValue.put("health_saving_exp", aCargo.getHealth_saving_exp());
		}

		if (!((aCargo.getMoving_exp() == null) && (moving_exp == null))
				&& !((aCargo.getMoving_exp() != null) && aCargo.getMoving_exp().equals(moving_exp))) {
			changedAttributeValue.put("moving_exp", aCargo.getMoving_exp());
		}

		if (!((aCargo.getDeductible_self_exp() == null) && (deductible_self_exp == null))
				&& !((aCargo.getDeductible_self_exp() != null) && aCargo.getDeductible_self_exp().equals(deductible_self_exp))) {
			changedAttributeValue.put("deductible_self_exp", aCargo.getDeductible_self_exp());
		}

		if (!((aCargo.getSelf_sep_exp() == null) && (self_sep_exp == null))
				&& !((aCargo.getSelf_sep_exp() != null) && aCargo.getSelf_sep_exp().equals(self_sep_exp))) {
			changedAttributeValue.put("self_sep_exp", aCargo.getSelf_sep_exp());
		}

		if (!((aCargo.getSelf_health_exp() == null) && (self_health_exp == null))
				&& !((aCargo.getSelf_health_exp() != null) && aCargo.getSelf_health_exp().equals(self_health_exp))) {
			changedAttributeValue.put("self_health_exp", aCargo.getSelf_health_exp());
		}

		if (!((aCargo.getPenalty_exp() == null) && (penalty_exp == null))
				&& !((aCargo.getPenalty_exp() != null) && aCargo.getPenalty_exp().equals(penalty_exp))) {
			changedAttributeValue.put("penalty_exp", aCargo.getPenalty_exp());
		}

		if (!((aCargo.getAlimony_exp() == null) && (alimony_exp == null))
				&& !((aCargo.getAlimony_exp() != null) && aCargo.getAlimony_exp().equals(alimony_exp))) {
			changedAttributeValue.put("alimony_exp", aCargo.getAlimony_exp());
		}

		if (!((aCargo.getIra_exp() == null) && (ira_exp == null)) && !((aCargo.getIra_exp() != null) && aCargo.getIra_exp().equals(ira_exp))) {
			changedAttributeValue.put("ira_exp", aCargo.getIra_exp());
		}

		if (!((aCargo.getStudent_loan_exp() == null) && (student_loan_exp == null))
				&& !((aCargo.getStudent_loan_exp() != null) && aCargo.getStudent_loan_exp().equals(student_loan_exp))) {
			changedAttributeValue.put("student_loan_exp", aCargo.getStudent_loan_exp());
		}

		if (!((aCargo.getTution_exp() == null) && (tution_exp == null))
				&& !((aCargo.getTution_exp() != null) && aCargo.getTution_exp().equals(tution_exp))) {
			changedAttributeValue.put("tution_exp", aCargo.getTution_exp());
		}

		if (!((aCargo.getDomestic_exp() == null) && (domestic_exp == null))
				&& !((aCargo.getDomestic_exp() != null) && aCargo.getDomestic_exp().equals(domestic_exp))) {
			changedAttributeValue.put("domestic_exp", aCargo.getDomestic_exp());
		}

		if (!((aCargo.getEnd_date() == null) && (end_date == null)) && !((aCargo.getEnd_date() != null) && aCargo.getEnd_date().equals(end_date))) {
			changedAttributeValue.put("end_date", aCargo.getEnd_date());
		}
		
		return changedAttributeValue;
	}

	// NextGen  NG-6481 Phase 3 updates to ACA Streamline changes � END

	/**
	 *returns the string value of cargo.
	 */
	@Override
	public String inspectCargo() {
		return new StringBuilder().append("CP_APP_IN_INCOME_TAX_DED: ").append("indv_seq_num=")
				.append("ecp_id=").append(ecp_id).append("end_date=")
				.append(end_date).append("educator_exp=").append(educator_exp).append("business_exp=").append(business_exp)
				.append("health_saving_exp=").append(health_saving_exp).append("moving_exp=").append(moving_exp).append("deductible_self_exp=")
				.append(deductible_self_exp).append("self_sep_exp=").append(self_sep_exp).append("self_health_exp=").append(self_health_exp)
				.append("penalty_exp=").append(penalty_exp).append("alimony_exp=").append(alimony_exp).append("ira_exp=").append(ira_exp)
				.append("student_loan_exp=").append(student_loan_exp).append("tution_exp=").append(tution_exp).append("domestic_exp=")
				.append(domestic_exp).append(" chg_dt= ").append(chg_dt).toString();
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = (31 * hash) + (null == ecp_id ? 0 : ecp_id.trim().hashCode());
		hash = (31 * hash) + (null == end_date ? 0 : end_date.trim().hashCode());
		hash = (31 * hash) + (null == educator_exp ? 0 : educator_exp.trim().hashCode());
		hash = (31 * hash) + (null == business_exp ? 0 : business_exp.trim().hashCode());
		hash = (31 * hash) + (null == health_saving_exp ? 0 : health_saving_exp.trim().hashCode());
		hash = (31 * hash) + (null == moving_exp ? 0 : moving_exp.trim().hashCode());
		hash = (31 * hash) + (null == deductible_self_exp ? 0 : deductible_self_exp.trim().hashCode());
		hash = (31 * hash) + (null == self_sep_exp ? 0 : self_sep_exp.trim().hashCode());
		hash = (31 * hash) + (null == self_health_exp ? 0 : self_health_exp.trim().hashCode());
		hash = (31 * hash) + (null == penalty_exp ? 0 : penalty_exp.trim().hashCode());
		hash = (31 * hash) + (null == alimony_exp ? 0 : alimony_exp.trim().hashCode());
		hash = (31 * hash) + (null == ira_exp ? 0 : ira_exp.trim().hashCode());
		hash = (31 * hash) + (null == student_loan_exp ? 0 : student_loan_exp.trim().hashCode());
		hash = (31 * hash) + (null == tution_exp ? 0 : tution_exp.trim().hashCode());
		hash = (31 * hash) + (null == domestic_exp ? 0 : domestic_exp.trim().hashCode());
		hash = 31 * hash + (null == chg_dt ? 0 : chg_dt.trim().hashCode());

		return hash;
	}

	@Override
	public String getSeq_num() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSeq_num(String seq_num) {
		// TODO Auto-generated method stub
		
	}
}
