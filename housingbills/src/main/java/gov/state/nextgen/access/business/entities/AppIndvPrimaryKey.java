package gov.state.nextgen.access.business.entities;

import javax.persistence.Embeddable;

@Embeddable
public class AppIndvPrimaryKey implements java.io.Serializable,IPrimaryKey{

	private String app_num;
	private String indv_seq_num;

	/**
	 * returns the app_num value.
	 */
	public String getApp_num() {
		return app_num;
	}

	/**
	 * returns the indv_seq_num value.
	 */
	public String getIndv_seq_num() {
		return indv_seq_num;
	}

	/**
	 * sets the app_num value.
	 */
	public void setApp_num(final String app_num) {
		this.app_num = app_num;
	}

	/**
	 * sets the indv_seq_num value.
	 */
	public void setIndv_seq_num(final String indv_seq_num) {
		this.indv_seq_num = indv_seq_num;
	}

	@Override
	public String inspectPrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}

}
