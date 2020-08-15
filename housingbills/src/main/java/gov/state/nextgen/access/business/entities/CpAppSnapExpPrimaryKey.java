package gov.state.nextgen.access.business.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CpAppSnapExpPrimaryKey implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String app_num;

	/**
	 * @return the app_num
	 */
	public String getApp_num() {
		return app_num;
	}

	/**
	 * @param app_num
	 *            the app_num to set
	 */
	public void setApp_num(final String app_num) {
		this.app_num = app_num;
	}

	}
