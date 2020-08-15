/*
 * 
 */
package gov.state.nextgen.access.driver;

/**
 * Enter the description of the class
 *
 * @author patelsn Creation Date Mar 23, 2005 Modified By: Modified on: PCR#
 */
public class FwDriverMapIndex {
	private int index;

	public FwDriverMapIndex() {
		index = 0;
	}

	public FwDriverMapIndex(final int index) {
		this.index = index;
	}

	/**
	 * Retrieve the index value Creation Date: March 23, 2005
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Set the index value Creation Date: March 23, 2005
	 */
	public void setIndex(final int i) {
		index = i;
	}

	/**
	 * Displays the value of index Creation Date: March 23, 2005
	 */
	@Override
	public String toString() {
		return String.valueOf(index);
	}
}
