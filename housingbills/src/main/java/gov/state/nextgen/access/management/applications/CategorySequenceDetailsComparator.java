/*
 * 
 */
package gov.state.nextgen.access.management.applications;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import gov.state.nextgen.access.management.constants.FwConstants;
import gov.state.nextgen.access.management.references.IReferenceTableData;
import gov.state.nextgen.access.management.references.IReferenceTableManager;
import gov.state.nextgen.access.management.references.ReferenceTableManager;

/**
 * CategorySequenceDetailsComparator.java
 *
 * @author Anand Balasubramanian Creation Date Jun 20, 2006 Modified By:Surendra
 *         Nath Modified on: Feb 27, 2007 PCR#
 */
public class CategorySequenceDetailsComparator implements Comparator, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	static final int ZERO = 0; // both object are equal
	static final int ONE = 1; // first object is greater than second
	static final int NEGATIVE_ONE = -1; // first object is less than second
	static final Map typesMap = new HashMap();

	/**
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(final Object o1, final Object o2) {

		final CategorySequenceDetail obj1 = (CategorySequenceDetail) o1;
		final CategorySequenceDetail obj2 = (CategorySequenceDetail) o2;
		int compareValue = compareObjects(obj1.getIndividualSequence(), obj2.getIndividualSequence());
		if (compareValue == ZERO) {
			compareValue = compareObjects(obj1.getCategorySequence(), obj2.getCategorySequence());
			if (compareValue == ZERO) {
				// If the Category Type exists in typesMap return the value else
				// lookup
				// into the reference table and populate into the typesMap
				compareValue = compareObjects(retrieveTypeSequence(obj1.getCategoryType()), retrieveTypeSequence(obj2.getCategoryType()));
				// if compare value is zero then we are comparing with user end
				// selection indicator
				if (compareValue == ZERO) {
					compareValue = compareObjects(obj1.getUserEndSelectionInd(), obj2.getUserEndSelectionInd());
				}
			}
		}
		return compareValue;
	}

	/*
	 * Fetches Category Sequence
	 */
	private short retrieveTypeSequence(final String categoryType) {
		String seqNum = null;
		// If the typesMap is empty populate from the reference table
		synchronized (typesMap) {
			if (typesMap.isEmpty()) {
				// Category Reference table
				final IReferenceTableManager iref = ReferenceTableManager.getInstance();
				final IReferenceTableData refData = iref.getReferenceTableData("TRCC", FwConstants.ENGLISH);
				final String[] code = refData.getCodeValues();
				// Codes Length
				final int codeLen = code.length;
				// Loop through the reference table and populate the category in
				// the typesMap
				for (int i = 0; i < codeLen; i++) {
					typesMap.put(code[i], String.valueOf(i + 1));
				}
			}
			seqNum = (String) typesMap.get(categoryType);
		}

		if (seqNum != null) {
			return Short.parseShort(seqNum);
		}

		return ZERO;
	}

	/**
	 * compares two Short object and returns the value 0 if this aValue1 is
	 * equal to aValue2; a value less than 0 if this aValue1 is numerically less
	 * than aValue2 and a value greater than 0 if this aValue1 is numerically
	 * greater than aValue2
	 */
	private int compareObjects(final long aValue1, final long aValue2) {

		if ((aValue1 == 0) && (aValue2 != 0)) {
			return ONE;
		}
		if ((aValue1 != 0) && (aValue2 == 0)) {
			return NEGATIVE_ONE;
		}
		if ((aValue1 != 0) && (aValue2 != 0)) {
			if (aValue1 < aValue2) {
				return NEGATIVE_ONE;
			} else if (aValue1 > aValue2) {
				return ONE;
			}
		}
		return ZERO;
	}

}