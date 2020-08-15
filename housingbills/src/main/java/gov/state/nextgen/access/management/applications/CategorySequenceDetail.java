/*
 * 
 */
package gov.state.nextgen.access.management.applications;

import java.io.Serializable;

/**
 * Class contains the category sequence details
 *
 * @author Anand Balasubramanian Creation Date June 20, 2006 Modified By:
 *         Modified on: PCR#
 */
public class CategorySequenceDetail implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private short individualSequence;
	private long categorySequence;
	private char status;
	private boolean newRecord;
	private String categoryType;
	private boolean currentRecord;
	private String rowAction;
	private String changeSelectionCategoryCd;
	private short userEndSelectionInd;

	/**
	 * default constructor
	 */
	public CategorySequenceDetail() {
	}

	/**
	 * overloaded constructor
	 */
	public CategorySequenceDetail(final String aIndividualSequence, final char aStatus) {
		individualSequence = Short.parseShort(aIndividualSequence);
		status = aStatus;
	}

	/**
	 * overloaded constructor
	 */
	public CategorySequenceDetail(final short aIndividualSequence, final char aStatus) {
		individualSequence = aIndividualSequence;
		status = aStatus;
	}

	/**
	 * overloaded constructor
	 */
	public CategorySequenceDetail(final short aIndividualSequence, final long aCategorySequence, final char aStatus) {
		individualSequence = aIndividualSequence;
		categorySequence = aCategorySequence;
		status = aStatus;
	}

	/**
	 * returns the categorySequence
	 */
	public long getCategorySequence() {
		return categorySequence;
	}

	/**
	 * returns the individualSequence
	 */
	public short getIndividualSequence() {
		return individualSequence;
	}

	/**
	 * returns the status
	 */
	public char getStatus() {
		return status;
	}

	/**
	 * sets the categorySequence (short value)
	 */
	void setCategorySequence(final long aCategorySequence) {
		categorySequence = aCategorySequence;
	}

	/**
	 * sets the individualSequence (short value)
	 */
	void setIndividualSequence(final short aIndividualSequence) {
		individualSequence = aIndividualSequence;
	}

	/**
	 * sets the categorySequence (String value)
	 */
	void setCategorySequence(final String aCategorySequence) {
		categorySequence = Long.parseLong(aCategorySequence);
	}

	/**
	 * sets the individualSequence (String value)
	 */
	void setIndividualSequence(final String aIndividualSequence) {
		individualSequence = Short.parseShort(aIndividualSequence);
	}

	/**
	 * sets the status
	 */
	public void setStatus(final char c) {
		status = c;
	}

	/**
	 * returns the categoryType
	 */
	public String getCategoryType() {
		return categoryType;
	}

	/**
	 * sets the categoryType
	 */
	void setCategoryType(final String aCategoryType) {
		categoryType = aCategoryType;
	}

	/**
	 * returns true if newrecord value is set
	 */
	public boolean isNewRecord() {
		return newRecord;
	}

	/**
	 * set the new record value
	 */
	void setNewRecord(final boolean b) {
		newRecord = b;
	}

	/**
	 * true if current record
	 */
	public boolean isCurrentRecord() {
		return currentRecord;
	}

	/**
	 * set current record
	 */
	void setCurrentRecord(final boolean b) {
		currentRecord = b;
	}

	/**
	 * @return Returns the rowAction.
	 */
	public String getRowAction() {
		return rowAction;
	}

	/**
	 * @param rowAction
	 *            The rowAction to set.
	 */
	public void setRowAction(final String rowAction) {
		this.rowAction = rowAction;
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
	public short getUserEndSelectionInd() {
		return userEndSelectionInd;
	}

	/**
	 * @param userEndSelectionInd
	 *            The userEndSelectionInd to set.
	 */
	public void setUserEndSelectionInd(final short userEndSelectionInd) {
		this.userEndSelectionInd = userEndSelectionInd;
	}
}