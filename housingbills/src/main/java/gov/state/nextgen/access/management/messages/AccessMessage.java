/*
 * 
 */
package gov.state.nextgen.access.management.messages;

import gov.state.nextgen.access.management.util.FWUtils;

import java.io.Serializable;

/**
 * Enter the description of the class
 *
 * @author Architecture Team
 * Creation Date Apr 7, 2004 Modified By: Modified on: PCR#
 */
public class AccessMessage implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String msgCode = null;
	private String[] msgSubstitution = null;
	private String refTableVale = null;

	/**
	 * Constructor for AccessMessage.
	 */
	public AccessMessage() {
	}

	/**
	 * Populates error messages
	 *
	 * Creation Date Apr 7, 2004
	 * @param message
	 *            java.lang.String
	 */
	public AccessMessage(final String aMsgCode, final String[] aMsgSubst) {
		msgCode = aMsgCode;
		msgSubstitution = FWUtils.arrayCopy(aMsgSubst);
	}

	/**
	 * @return
	 */
	public String getMsgCode() {
		return msgCode;
	}

	/**
	 * @return
	 */
	public String[] getMsgSubstitution() {
		return msgSubstitution;
	}

	/**
	 * @param string
	 */
	public void setMsgCode(final String string) {
		msgCode = string;
	}

	/**
	 * @param strings
	 */
	public void setMsgSubstitution(final String[] strings) {
		msgSubstitution = FWUtils.arrayCopy(strings);
	}

	/**
	 * @return
	 */
	public String getRefTableVale() {
		return refTableVale;
	}

	/**
	 * @param string
	 */
	public void setRefTableVale(final String string) {
		refTableVale = string;
	}

}
