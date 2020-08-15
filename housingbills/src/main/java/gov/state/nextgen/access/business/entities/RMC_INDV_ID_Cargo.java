/*
 * 
 */
package gov.state.nextgen.access.business.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * This java bean contains the entities of RMC_INDV_ID
 *
 * @author Architecture Team
 * Creation Date Tue Jun 06 22:08:16 CDT 2006 Modified By: Modified on: PCR#
 */
public class RMC_INDV_ID_Cargo extends AbstractCargo implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.impl.RMC_INDV_ID";

	boolean isDirty = false;
	private String app_num;
	private String indv_seq_num;
	private String pin_num;

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
	 * returns the pin_num value.
	 */
	public String getPin_num() {
		return pin_num;
	}

	/**
	 * sets the pin_num value.
	 */
	public void setPin_num(final String pin_num) {
		this.pin_num = pin_num;
	}

	/**
	 * returns the string value of cargo.
	 */
	@Override
	public String inspectCargo() {
		return new StringBuilder().append("RMC_INDV_ID: ").append("app_num=").append(app_num).append("indv_seq_num=").append(indv_seq_num)
				.append("pin_num=").append(pin_num).toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((app_num == null) ? 0 : app_num.trim().hashCode());
		result = (prime * result) + ((indv_seq_num == null) ? 0 : indv_seq_num.trim().hashCode());
		result = (prime * result) + ((pin_num == null) ? 0 : pin_num.trim().hashCode());
		return result;
	}

	/**
	 * returns the PrimaryKey object.
	 */
	@Override
	public IPrimaryKey getPrimaryKey() {
		final RMC_INDV_ID_PrimaryKey key = new RMC_INDV_ID_PrimaryKey();
		key.setApp_num(getApp_num());
		key.setIndv_seq_num(getIndv_seq_num());
		key.setPin_num(getPin_num());
		return key;
	}

	/**
	 * compares the given cargo with this cargo and returns the changed
	 * attributes as a list.
	 */
	public List compareAttributes(final RMC_INDV_ID_Cargo aCargo) {
		final List changedAttributes = new ArrayList();
		if (!((aCargo.getApp_num() == null) && (app_num == null)) && !((aCargo.getApp_num() != null) && aCargo.getApp_num().equals(app_num))) {
			changedAttributes.add("app_num");
		}
		if (!((aCargo.getIndv_seq_num() == null) && (indv_seq_num == null))
				&& !((aCargo.getIndv_seq_num() != null) && aCargo.getIndv_seq_num().equals(indv_seq_num))) {
			changedAttributes.add("indv_seq_num");
		}
		if (!((aCargo.getPin_num() == null) && (pin_num == null)) && !((aCargo.getPin_num() != null) && aCargo.getPin_num().equals(pin_num))) {
			changedAttributes.add("pin_num");
		}
		return changedAttributes;
	}

	/**
	 * returns the PACKAGE name.
	 */
	public String getPackage() {
		return PACKAGE;
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
		final RMC_INDV_ID_Cargo other = (RMC_INDV_ID_Cargo) obj;
		if (app_num == null) {
			if (other.app_num != null) {
				return false;
			}
		} else if (!app_num.equals(other.app_num)) {
			return false;
		}
		if (indv_seq_num == null) {
			if (other.indv_seq_num != null) {
				return false;
			}
		} else if (!indv_seq_num.equals(other.indv_seq_num)) {
			return false;
		}
		if (pin_num == null) {
			if (other.pin_num != null) {
				return false;
			}
		} else if (!pin_num.equals(other.pin_num)) {
			return false;
		}
		return true;
	}

}