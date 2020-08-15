package gov.state.nextgen.access.business.entities;

/*
 * 
 */

import gov.state.nextgen.access.business.entities.IPrimaryKey;

/**
 * This java bean contains the primary keys for the table APP_SCREENER
 *
 * @author CodeGenerator - Architecture Team
 * Creation Date Date Sep 18 15:00:00 EDT 2014 Modified By: Modified on: PCR#
 */
public class CP_APP_SCREENER_PrimaryKey implements java.io.Serializable, IPrimaryKey {

	/**
	 *
	 */
	private static final long serialVersionUID = -6720677678234569464L;

	private String app_screener_num;

	/**
	 * returns the app_num value.
	 */
	public String getApp_screener_num() {
		return app_screener_num;
	}

	/**
	 * sets the app_num value.
	 */
	public void setApp_screener_num(final String app_num) {
		app_screener_num = app_num;
	}

	/**
	 * returns the string value of cargo.
	 */
	@Override
	public String inspectPrimaryKey() {
		return new StringBuilder().append("CP_APP_SCREENER: ").append("app_screener_num=").append(app_screener_num).toString();
	}

	/**
	 * returns the hashcode value of cargo.
	 */
	@Override
	public int hashCode() {
		int hash = 7;
		hash = (31 * hash) + (null == app_screener_num ? 0 : app_screener_num.trim().hashCode());
		return hash;
	}

	/**
	 * checks for the equality
	 */
	@Override
	public boolean equals(final Object obj) {
		if ((obj == null) || (getClass() != obj.getClass())) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		final CP_APP_SCREENER_PrimaryKey screenerKey = (CP_APP_SCREENER_PrimaryKey) obj;

		if (!screenerKey.getApp_screener_num().equals(getApp_screener_num())) {
			return false;
		} else {
			return true;
		}

	}

}
