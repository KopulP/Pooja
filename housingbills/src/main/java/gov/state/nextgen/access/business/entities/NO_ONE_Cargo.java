/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This java bean contains the entities for the given table
 *
 * @author Architecture Team
 * Creation Date Thu Jun 24 19:05:32 CDT 2004 Modified By: Modified on: PCR#
 */
public class NO_ONE_Cargo extends AbstractCargo implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static final String PACKAGE = "gov.state.nextgen.access.business.entities.NO_ONE";

	boolean isDirty = false;
	private java.lang.String no_one_name;
	private java.lang.String no_one_value;

	/**
	 * Returns the package name.
	 *
	 * Creation Date Thu Jun 24 19:05:32 CDT 2004
	 * @return gov.state.nextgen.access.business.entities.NO_ONE_Cargo
	 */
	public String getPackage() {
		return PACKAGE;
	}

	/**
	 * Returns the primary key values of a cargo
	 *
	 * Creation Date Thu Jun 24 19:05:32 CDT 2004
	 * @return java.lang.String
	 */

	@Override
	public IPrimaryKey getPrimaryKey() {
		final NO_ONE_PrimaryKey key = new NO_ONE_PrimaryKey();
		key.setNo_one_name(getNo_one_name());
		return key;
	}

	/**
	 * Inspects Cargo values for debug.
	 *
	 * Creation Date Thu Jun 24 19:05:32 CDT 2004
	 * @return java.lang.String
	 */
	@Override
	public String inspectCargo() {
		return "NO_ONE: " + "no_one_name=" + no_one_name + "," + "no_one_value=" + no_one_value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((no_one_name == null) ? 0 : no_one_name.trim().hashCode());
		result = (prime * result) + ((no_one_value == null) ? 0 : no_one_value.trim().hashCode());
		return result;
	}

	/**
	 * Returns the no_one_name.
	 *
	 * Creation Date Thu Jun 24 19:05:32 CDT 2004
	 * @return java.lang.String
	 */

	public java.lang.String getNo_one_name() {
		return no_one_name;
	}

	/**
	 * Sets the no_one_name.
	 *
	 * Creation Date Thu Jun 24 19:05:32 CDT 2004
	 * @param no_one_name
	 *            The no_one_name to set
	 */

	public void setNo_one_name(final java.lang.String no_one_name) {
		this.no_one_name = no_one_name;
	}

	/**
	 * Returns the no_one_value.
	 *
	 * Creation Date Thu Jun 24 19:05:32 CDT 2004
	 * @return char
	 */

	public java.lang.String getNo_one_value() {
		return no_one_value;
	}

	/**
	 * Sets the no_one_value.
	 *
	 * Creation Date Thu Jun 24 19:05:32 CDT 2004
	 * @param no_one_value
	 *            The no_one_value to set
	 */

	public void setNo_one_value(final java.lang.String no_one_value) {
		this.no_one_value = no_one_value;
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
		final NO_ONE_Cargo other = (NO_ONE_Cargo) obj;
		if (no_one_name == null) {
			if (other.no_one_name != null) {
				return false;
			}
		} else if (!no_one_name.equals(other.no_one_name)) {
			return false;
		}
		if (no_one_value == null) {
			if (other.no_one_value != null) {
				return false;
			}
		} else if (!no_one_value.equals(other.no_one_value)) {
			return false;
		}
		return true;
	}

}