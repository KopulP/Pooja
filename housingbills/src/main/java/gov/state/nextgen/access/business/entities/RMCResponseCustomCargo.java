package gov.state.nextgen.access.business.entities;

import javax.persistence.Entity;


public class RMCResponseCustomCargo extends AbstractCargo implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private String indvSeqNum;
	private String seqNum;
	private String response;
	private String categoryType;
	private String changeSelectionCategoryCd;
	private String userEndSelectionInd;

	private static final String PACKAGE = "";
	
	/**
	 * Returns the package name.
	 */
	public String getPackage() {
		return PACKAGE;
	}

	/**
	 * Returns the primary key values of a cargo
	 */

	@Override
	public IPrimaryKey getPrimaryKey() {
		return null;
	}

	/**
	 * Inspects Cargo values for debug.
	 */
	@Override
	public String inspectCargo() {
		return "indvSeqNum=" + indvSeqNum + "," + "seqNum=" + seqNum + "," + "response=" + response + "," + "categoryType=" + categoryType + ","
				+ "changeSelectionCategoryCd=" + changeSelectionCategoryCd + "," + "userEndSelectionInd=" + userEndSelectionInd;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public String getIndvSeqNum() {
		return indvSeqNum;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public String getResponse() {
		return response;
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
	public void setIndvSeqNum(final String string) {
		indvSeqNum = string;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public void setResponse(final String string) {
		response = string;
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
	public String getCategoryType() {
		return categoryType;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public void setCategoryType(final String string) {
		categoryType = string;
	}

	/**
	 * @return Returns the changeSelectionCategoryCd.
	 */
	public String getChangeSelectionCategoryCd() {
		return changeSelectionCategoryCd;
	}

	/**
	 * @param changeSelectionCategoryCd
	 *            The changeSelectionCategoryCd to set.
	 */
	public void setChangeSelectionCategoryCd(final String changeSelectionCategoryCd) {
		this.changeSelectionCategoryCd = changeSelectionCategoryCd;
	}

	/**
	 * @return Returns the userEndSelectionInd.
	 */
	public String getUserEndSelectionInd() {
		return userEndSelectionInd;
	}

	/**
	 * @param userEndSelectionInd
	 *            The userEndSelectionInd to set.
	 */
	public void setUserEndSelectionInd(final String userEndSelectionInd) {
		this.userEndSelectionInd = userEndSelectionInd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((categoryType == null) ? 0 : categoryType.trim().hashCode());
		result = (prime * result) + ((changeSelectionCategoryCd == null) ? 0 : changeSelectionCategoryCd.trim().hashCode());
		result = (prime * result) + ((indvSeqNum == null) ? 0 : indvSeqNum.trim().hashCode());
		result = (prime * result) + ((response == null) ? 0 : response.trim().hashCode());
		result = (prime * result) + ((seqNum == null) ? 0 : seqNum.trim().hashCode());
		result = (prime * result) + ((userEndSelectionInd == null) ? 0 : userEndSelectionInd.trim().hashCode());
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
		final RMCResponseCustomCargo other = (RMCResponseCustomCargo) obj;
		if (categoryType == null) {
			if (other.categoryType != null) {
				return false;
			}
		} else if (!categoryType.equals(other.categoryType)) {
			return false;
		}
		if (changeSelectionCategoryCd == null) {
			if (other.changeSelectionCategoryCd != null) {
				return false;
			}
		} else if (!changeSelectionCategoryCd.equals(other.changeSelectionCategoryCd)) {
			return false;
		}
		if (indvSeqNum == null) {
			if (other.indvSeqNum != null) {
				return false;
			}
		} else if (!indvSeqNum.equals(other.indvSeqNum)) {
			return false;
		}
		if (response == null) {
			if (other.response != null) {
				return false;
			}
		} else if (!response.equals(other.response)) {
			return false;
		}
		if (seqNum == null) {
			if (other.seqNum != null) {
				return false;
			}
		} else if (!seqNum.equals(other.seqNum)) {
			return false;
		}
		if (userEndSelectionInd == null) {
			if (other.userEndSelectionInd != null) {
				return false;
			}
		} else if (!userEndSelectionInd.equals(other.userEndSelectionInd)) {
			return false;
		}
		return true;
	}
}
