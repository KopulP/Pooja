package gov.state.nextgen.access.business.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RmbRqstPrimaryKey implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String app_num;

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

	}
