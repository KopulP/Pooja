/*
 * 
 */
package gov.state.nextgen.access.management.applications;

import java.io.Serializable;

/**
 * Enter the description of the class
 *
 * @author nathsu Creation Date Jan 17, 2006 Modified By: Modified on: PCR#
 */
public class IndivTypeSeqBean implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String indivSeqNum;
	private String type;
	private String seqNum;
	private String userEndInd;

	public IndivTypeSeqBean() {
	}

	public IndivTypeSeqBean(final String aIndivSeqNum, final String aType, final String aSeqNum) {
		indivSeqNum = aIndivSeqNum;
		type = aType;
		seqNum = aSeqNum;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public String getIndivSeqNum() {
		return indivSeqNum;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public String getSeqNum() {
		return seqNum;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public String getType() {
		return type;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public void setIndivSeqNum(final String string) {
		indivSeqNum = string;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public void setSeqNum(final String string) {
		seqNum = string;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public void setType(final String string) {
		type = string;
	}

	/**
	 * @return Returns the userEndInd.
	 */
	public String getUserEndInd() {
		return userEndInd;
	}

	/**
	 * @param userEndInd
	 *            The userEndInd to set.
	 */
	public void setUserEndInd(final String userEndInd) {
		this.userEndInd = userEndInd;
	}
}
