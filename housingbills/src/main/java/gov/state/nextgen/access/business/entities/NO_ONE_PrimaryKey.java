/*
 * 
 */
package gov.state.nextgen.access.business.entities;

/**
 * This java bean contains the primary keys for the given table
 *
 * @author Architecture Team
 * Creation Date Thu Jun 24 19:05:40 CDT 2004 Modified By: Modified on: PCR#
 */
public class NO_ONE_PrimaryKey implements java.io.Serializable, IPrimaryKey {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public NO_ONE_PrimaryKey() {
	}

	private java.lang.String no_one_name;

	/**
	 * Inspects primary key values for debug.
	 *
	 * Creation Date Thu Jun 24 19:05:40 CDT 2004
	 * @return java.lang.String
	 */
	@Override
	public String inspectPrimaryKey() {
		return "NO_ONE: " + "no_one_name=" + no_one_name;
	}

	/**
	 * Returns the no_one_name.
	 *
	 * Creation Date Thu Jun 24 19:05:40 CDT 2004
	 * @return java.lang.String
	 */

	public java.lang.String getNo_one_name() {
		return no_one_name;
	}

	/**
	 * Sets the no_one_name.
	 *
	 * Creation Date Thu Jun 24 19:05:40 CDT 2004
	 * @param no_one_name
	 *            The no_one_name to set
	 */

	public void setNo_one_name(final java.lang.String no_one_name) {
		this.no_one_name = no_one_name;
	}

}