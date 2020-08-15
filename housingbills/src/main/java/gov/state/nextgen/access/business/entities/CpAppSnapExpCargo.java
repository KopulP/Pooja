package gov.state.nextgen.access.business.entities;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CP_APP_SNAP_EXP")
public class CpAppSnapExpCargo  implements java.io.Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	@Transient
	boolean isDirty = false;
	
	@EmbeddedId
	private CpAppSnapExpPrimaryKey cpAppSnapExpPrimaryKey;
	
	private String src_app_ind;
	private String heating_cooling_expense_fa_ind;
	private String actual_utility_exp_ind;
	private String other_snap_apply_pay_ind;
	private String move_into_shelter_dt;
	private String actual_shelter_expense_ind;
	private String expense_seq_num;
	private String rec_cplt_ind;

	/**
	 * @return the expense_seq_num
	 */
	public String getExpense_seq_num() {
		return expense_seq_num;
	}

	/**
	 * @param expense_seq_num
	 *            the expense_seq_num to set
	 */
	public void setExpense_seq_num(final String expense_seq_num) {
		this.expense_seq_num = expense_seq_num;
	}

	
	/**
	 * @return the src_app_ind
	 */
	public String getSrc_app_ind() {
		return src_app_ind;
	}

	/**
	 * @param src_app_ind
	 *            the src_app_ind to set
	 */
	public void setSrc_app_ind(final String src_app_ind) {
		this.src_app_ind = src_app_ind;
	}

	/**
	 * @return the heating_cooling_expense_fa_ind
	 */
	public String getHeating_cooling_expense_fa_ind() {
		return heating_cooling_expense_fa_ind;
	}

	/**
	 * @param heating_cooling_expense_fa_ind
	 *            the heating_cooling_expense_fa_ind to set
	 */
	public void setHeating_cooling_expense_fa_ind(final String heating_cooling_expense_fa_ind) {
		this.heating_cooling_expense_fa_ind = heating_cooling_expense_fa_ind;
	}

	/**
	 * @return the actual_utility_exp_ind
	 */
	public String getActual_utility_exp_ind() {
		return actual_utility_exp_ind;
	}

	/**
	 * @param actual_utility_exp_ind
	 *            the actual_utility_exp_ind to set
	 */
	public void setActual_utility_exp_ind(final String actual_utility_exp_ind) {
		this.actual_utility_exp_ind = actual_utility_exp_ind;
	}

	/**
	 * @return the other_snap_apply_pay_ind
	 */
	public String getOther_snap_apply_pay_ind() {
		return other_snap_apply_pay_ind;
	}

	/**
	 * @param other_snap_apply_pay_ind
	 *            the other_snap_apply_pay_ind to set
	 */
	public void setOther_snap_apply_pay_ind(final String other_snap_apply_pay_ind) {
		this.other_snap_apply_pay_ind = other_snap_apply_pay_ind;
	}

	/**
	 * @return the move_into_shelter_dt
	 */
	public String getMove_into_shelter_dt() {
		return move_into_shelter_dt;
	}

	/**
	 * @param move_into_shelter_dt
	 *            the move_into_shelter_dt to set
	 */
	public void setMove_into_shelter_dt(final String move_into_shelter_dt) {
		this.move_into_shelter_dt = move_into_shelter_dt;
	}

	/**
	 * @return the actual_shelter_expense_ind
	 */
	public String getActual_shelter_expense_ind() {
		return actual_shelter_expense_ind;
	}

	/**
	 * @param actual_shelter_expense_ind
	 *            the actual_shelter_expense_ind to set
	 */
	public void setActual_shelter_expense_ind(final String actual_shelter_expense_ind) {
		this.actual_shelter_expense_ind = actual_shelter_expense_ind;
	}

	/**
	 * @return the rec_cplt_ind
	 */
	public String getRec_cplt_ind() {
		return rec_cplt_ind;
	}

	/**
	 * @param rec_cplt_ind
	 *            the rec_cplt_ind to set
	 */
	public void setRec_cplt_ind(final String rec_cplt_ind) {
		this.rec_cplt_ind = rec_cplt_ind;
	}

	/**
	 * returns the PrimaryKey object.
	 */
	}
