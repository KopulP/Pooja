/*
 * 
 */
package gov.state.nextgen.access.business.entities;

import java.io.Serializable;

/**
 * This java bean contains the primary keys for the table BNFT_APPOINTMENTS
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date May 12 09:47:00 EDT 2009 Modified By: Modified on: PCR#
 */
public class BNFT_APPOINTMENTS_PrimaryKey implements Serializable, IPrimaryKey {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private int appt_id;

	/**
	 * returns the appt_id value.
	 */
	public int getAppt_id() {
		return appt_id;
	}

	/**
	 * sets the appt_id value.
	 */
	public void setAppt_id(final int appt_id) {
		this.appt_id = appt_id;
	}

	/**
	 * returns the string value of cargo.
	 */
	@Override
	public String inspectPrimaryKey() {
		return new StringBuilder().append("BNFT_APPOINTMENTS: ").append("appt_id=").append(appt_id).toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + appt_id;
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
		final BNFT_APPOINTMENTS_PrimaryKey other = (BNFT_APPOINTMENTS_PrimaryKey) obj;
		if (appt_id != other.appt_id) {
			return false;
		}
		return true;
	}
}
