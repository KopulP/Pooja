/*
 * 
 */
package gov.state.nextgen.access.individuals;

import gov.state.nextgen.access.business.services.INDIVIDUAL_Custom_Cargo;

/**
 * Enter the description of the class
 *
 * @author manivma Creation Date Jan 19, 2006 Modified By: Modified on: PCR#
 */
public class SortIndividualByAge implements Comparable {

	private INDIVIDUAL_Custom_Cargo individualCustomCargo = null;
	private int individualAge = -1;
	private int indvSeqNum = -1;

	public SortIndividualByAge() {
	}

	@Override
	public int compareTo(final Object obj) {
		final SortIndividualByAge ind = (SortIndividualByAge) obj;
		final int individualAge2 = ind.getIndividualCustomCargo().getIndv_age().getYears();
		final int indvSeqNum2 = Integer.parseInt(ind.getIndividualCustomCargo().getIndv_seq_num());

		if (individualAge < individualAge2) {
			return -1;
		} else if (individualAge > individualAge2) {
			return 1;
		} else {
			if (indvSeqNum < indvSeqNum2) {
				return 1;
			} else if (indvSeqNum > indvSeqNum2) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public INDIVIDUAL_Custom_Cargo getIndividualCustomCargo() {
		return individualCustomCargo;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public void setIndividualCustomCargo(final INDIVIDUAL_Custom_Cargo cargo) {
		individualCustomCargo = cargo;
		individualAge = cargo.getIndv_age().getYears();
		indvSeqNum = Integer.parseInt(cargo.getIndv_seq_num());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + individualAge;
		result = (prime * result) + ((individualCustomCargo == null) ? 0 : individualCustomCargo.hashCode());
		result = (prime * result) + indvSeqNum;
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
		final SortIndividualByAge other = (SortIndividualByAge) obj;
		if (individualAge != other.individualAge) {
			return false;
		}
		if (individualCustomCargo == null) {
			if (other.individualCustomCargo != null) {
				return false;
			}
		} else if (!individualCustomCargo.equals(other.individualCustomCargo)) {
			return false;
		}
		if (indvSeqNum != other.indvSeqNum) {
			return false;
		}
		return true;
	}
}
