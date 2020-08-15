/*
 * 
 */
package gov.state.nextgen.access.business.entities;

import java.io.Serializable;

/**
 * This java bean contains the entities of BNFT_APPOINTMENTS
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date May 12 09:47:00 EDT 2009 Modified By: Modified on: PCR#
 */

public class BNFT_APPOINTMENTS_Cargo extends AbstractCargo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.impl.BNFT_APPOINTMENTS";

	boolean isDirty = false;
	private int appt_id;
	private int bnft_case_num;
	private String bnft_rfa_num;
	private String appt_beg_datetime;
	private String appt_end_datetime;
	private String appt_mode_cd;
	private String appt_type_cd;

	/**
	 * returns the appt_id value.
	 */
	public int getAppt_id() {
		return appt_id;
	}

	/**
	 * returns the bnft_case_num value.
	 */
	public int getBnft_case_num() {
		return bnft_case_num;
	}

	/**
	 * returns the bnft_rfa_num value.
	 */
	public String getBnft_rfa_num() {
		return bnft_rfa_num;
	}

	/**
	 * returns the appt_beg_datetime value.
	 */
	public String getAppt_beg_datetime() {
		return appt_beg_datetime;
	}

	/**
	 * returns the appt_end_datetime value.
	 */
	public String getAppt_end_datetime() {
		return appt_end_datetime;
	}

	/**
	 * returns the appt_mode_cd value.
	 */
	public String getAppt_mode_cd() {
		return appt_mode_cd;
	}

	/**
	 * returns the appt_type_cd value.
	 */
	public String getAppt_type_cd() {
		return appt_type_cd;
	}

	/**
	 * sets the appt_id value.
	 */
	public void setAppt_id(final int appt_id) {
		this.appt_id = appt_id;
	}

	/**
	 * sets the bnft_case_num value.
	 */
	public void setBnft_case_num(final int bnft_case_num) {
		this.bnft_case_num = bnft_case_num;
	}

	/**
	 * sets the bnft_rfa_num value.
	 */
	public void setBnft_rfa_num(final String bnft_rfa_num) {
		this.bnft_rfa_num = bnft_rfa_num;
	}

	/**
	 * sets the appt_beg_datetime value.
	 */
	public void setAppt_beg_datetime(final String appt_beg_datetime) {
		this.appt_beg_datetime = appt_beg_datetime;
	}

	/**
	 * sets the appt_end_datetime value.
	 */
	public void setAppt_end_datetime(final String appt_end_datetime) {
		this.appt_end_datetime = appt_end_datetime;
	}

	/**
	 * sets the appt_mode_cd value.
	 */
	public void setAppt_mode_cd(final String appt_mode_cd) {
		this.appt_mode_cd = appt_mode_cd;
	}

	/**
	 * sets the appt_type_cd value.
	 */
	public void setAppt_type_cd(final String appt_type_cd) {
		this.appt_type_cd = appt_type_cd;
	}

	/**
	 * returns the PrimaryKey object.
	 */
	@Override
	public IPrimaryKey getPrimaryKey() {
		final BNFT_APPOINTMENTS_PrimaryKey key = new BNFT_APPOINTMENTS_PrimaryKey();
		key.setAppt_id(getAppt_id());

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
		return new StringBuilder().append("BNFT_APPOINTMENTS: ").append("appt_id=").append(appt_id).append("bnft_case_num=").append(bnft_case_num)
				.append("bnft_rfa_num=").append(bnft_rfa_num).append("appt_beg_datetime=").append(appt_beg_datetime).append("appt_end_datetime=")
				.append(appt_end_datetime).append("appt_mode_cd=").append(appt_mode_cd).append("appt_type_cd=").append(appt_type_cd).toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((appt_beg_datetime == null) ? 0 : appt_beg_datetime.trim().hashCode());
		result = (prime * result) + ((appt_end_datetime == null) ? 0 : appt_end_datetime.trim().hashCode());
		result = (prime * result) + appt_id;
		result = (prime * result) + ((appt_mode_cd == null) ? 0 : appt_mode_cd.trim().hashCode());
		result = (prime * result) + ((appt_type_cd == null) ? 0 : appt_type_cd.trim().hashCode());
		result = (prime * result) + bnft_case_num;
		result = (prime * result) + ((bnft_rfa_num == null) ? 0 : bnft_rfa_num.trim().hashCode());
		return result;
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
		final BNFT_APPOINTMENTS_Cargo other = (BNFT_APPOINTMENTS_Cargo) obj;
		if (appt_beg_datetime == null) {
			if (other.appt_beg_datetime != null) {
				return false;
			}
		} else if (!appt_beg_datetime.equals(other.appt_beg_datetime)) {
			return false;
		}
		if (appt_end_datetime == null) {
			if (other.appt_end_datetime != null) {
				return false;
			}
		} else if (!appt_end_datetime.equals(other.appt_end_datetime)) {
			return false;
		}
		if (appt_id != other.appt_id) {
			return false;
		}
		if (appt_mode_cd == null) {
			if (other.appt_mode_cd != null) {
				return false;
			}
		} else if (!appt_mode_cd.equals(other.appt_mode_cd)) {
			return false;
		}
		if (appt_type_cd == null) {
			if (other.appt_type_cd != null) {
				return false;
			}
		} else if (!appt_type_cd.equals(other.appt_type_cd)) {
			return false;
		}
		if (bnft_case_num != other.bnft_case_num) {
			return false;
		}
		if (bnft_rfa_num == null) {
			if (other.bnft_rfa_num != null) {
				return false;
			}
		} else if (!bnft_rfa_num.equals(other.bnft_rfa_num)) {
			return false;
		}
		return true;
	}

}