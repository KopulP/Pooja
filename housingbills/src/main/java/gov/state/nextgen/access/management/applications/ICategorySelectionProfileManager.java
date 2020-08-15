/*
 * 
 */
package gov.state.nextgen.access.management.applications;

import java.util.List;
import java.util.Map;
import java.util.SortedSet;

import gov.state.nextgen.access.business.entities.RMC_RESPONSE_Custom_Collection;

/**
 * This interface resposible for managing category sequences and details. Also
 * used to get the next sequence to be loaded on detail page
 *
 * @author Anand Balasubramanian Creation Date Jun 16, 2006 Modified By:
 *         Modified on: PCR#
 */
public interface ICategorySelectionProfileManager {

	char STATUS_NOT_REQUIRED = 'N';
	char STATUS_REQUIRED = 'R';
	char STATUS_COMPLETE = 'C';
	char STATUS_VISIT_AGAIN = 'V';
	char STATUS_ADD_NEW = 'A';

	/**
	 * constructs the SortedSet which will represent the selectionProfile for a
	 * given collection of cargos
	 */
	SortedSet buildSelectionProfile(RMC_RESPONSE_Custom_Collection aRmcResponseCustomColl, String aAppNum, String aChangeSelCatCd);

	/**
	 * constructs the SortedSet which will represent the selectionProfile for a
	 * given collection of cargos
	 */
	SortedSet buildSelectionProfileAfterValidation(SortedSet aSelectionProfile, RMC_RESPONSE_Custom_Collection aRmcResponseCustomColl);

	SortedSet buildSelectionOthIncProfileAfterValidation(SortedSet aSelectionProfile, RMC_RESPONSE_Custom_Collection aRmcResponseCustomColl);

	/**
	 * updates existing(given) SelectionProfile with the provided new Collection
	 */
	void rebuildSelectionProfile(SortedSet aSelectionProfile, RMC_RESPONSE_Custom_Collection aRmcResponseCustomColl, String aAppNum,
			String aChangeSelCatCd);

	/**
	 * inserts a new CategorySequenceDetailBean will 0 CategorySequence
	 */
	void insertSequenceDetail(SortedSet aSelectionProfile, String aAppNum, String aChangeSelCatCd, short aIndvSeqNum, String aCategoryType);

	/**
	 * inserts a existing category seq detail information
	 */

	void insertExistingSequenceDetail(SortedSet aSelectionProfile, String aAppNum, String aChangeSelCatCd, short aIndvSeqNum, long catSeqNum,
			String aCategoryType);

	/**
	 * inserts a existing category seq detail information
	 */

	void insertExistingSequenceDetail(SortedSet aSelectionProfile, String aAppNum, String aChangeSelCatCd, short aIndvSeqNum, long catSeqNum,
			String aCategoryType, short userEndInd);

	/**
	 * removes a CategorySequenceDetailBean with a given aIndvSeqNum and
	 * CategorySeqNum
	 */
	void removeSequenceDetail(SortedSet aSelectionProfile, String aAppNum, short aIndvSeqNum, long aCatSeqNum, String aCategoryType);

	/**
	 * removes a CategorySequenceDetailBean with a given aIndvSeqNum and
	 * CategorySeqNum
	 */
	void removeSequenceDetail(SortedSet aSelectionProfile, String aAppNum, short aIndvSeqNum, long aCatSeqNum, String aCategoryType,
			String aCategorySubType);

	// EDSP CP Starts
	/**
	 * retrives status of a CategorySequenceDetailBean for the given IndvSeqNum,
	 * CategorySeqNum and CategoryType, otherwise return ' '
	 */
	char getSequenceDetailStatusView(SortedSet aSelectionProfile, short aIndvSeqNum, short aCatSeqNum, String aCategoryType);

	/**
	 * retrives status of a CategorySequenceDetailBean for the given IndvSeqNum,
	 * CategorySeqNum and CategoryType, otherwise return ' '
	 */
	char getSequenceDetailStatusView(SortedSet aSelectionProfile, short aIndvSeqNum, short aCatSeqNum, String aCategoryType, short aSelectionInd);

	/**
	 * updates existing(given) SelectionProfile with the provided new Collection
	 */
	void rebuildSelectionProfile(SortedSet aSelectionProfile, RMC_RESPONSE_Custom_Collection aRmcResponseCustomColl, String aAppNum,
			String aChangeSelCatCd, List aCateType);

	// EDSP CP Ends
	/**
	 * retrieves a first occurance of CategorySequenceDetailBean for with status
	 * "C"
	 */
	CategorySequenceDetail getNextSequenceDetail(SortedSet aSelectionProfile);

	/**
	 * retrieves a first occurance of CategorySequenceDetailBean for with status
	 * "C" for the given category types
	 */
	CategorySequenceDetail getNextSequenceDetail(SortedSet aSelectionProfile, Map aCatType);

	/**
	 * retrieves a last occurance of CategorySequenceDetailBean for with status
	 * "C"
	 */
	CategorySequenceDetail getLastCompletedSequenceDetail(SortedSet aSelectionProfile);

	/**
	 * retrieves a last occurance of CategorySequenceDetailBean for with status
	 * "C" of the given category types
	 */
	CategorySequenceDetail getLastCompletedSequenceDetail(SortedSet aSelectionProfile, Map aCatTyp);

	/**
	 * updates the CategorySequenceDetailBean for the given IndvSeqNum and
	 * CategorySeqNum N to R, C to V
	 */
	void makeSequenceDetailRequired(SortedSet aSelectionProfile, String aAppNum, short aIndvSeqNum, long aCatSeqNum, String aCategoryType);

	/**
	 * updates the CategorySequenceDetailBean status to C for the given
	 * IndvSeqNum and CategorySeqNum
	 */
	void makeSequenceDetailComplete(SortedSet aSelectionProfile, String aAppNum, short aIndvSeqNum, long aCatSeqNum, String aCategoryType);

	/**
	 * retrives status of a CategorySequenceDetailBean for the given IndvSeqNum,
	 * CategorySeqNum and CategoryType, otherwise return 'N'
	 */
	char getSequenceDetailStatus(SortedSet aSelectionProfile, short aIndvSeqNum, long aCatSeqNum, String aCategoryType, short aSelectionInd);

	/**
	 * retrives status of a CategorySequenceDetailBean for the given IndvSeqNum,
	 * CategorySeqNum and CategoryType, otherwise return 'N'
	 */
	char getSequenceDetailStatus(SortedSet aSelectionProfile, short aIndvSeqNum, long aCatSeqNum, String aCategoryType);

	/**
	 * retrives status of a CategorySequenceDetailBean for the given IndvSeqNum,
	 * CategorySeqNum and CategoryType, otherwise return 'N'
	 */
	CategorySequenceDetail getCategorySequenceDetail(SortedSet aSelectionProfile, short aIndvSeqNum, long aCatSeqNum, String aCategoryType);

	/**
	 * returns true if all the category sequecne statuses are set to complete,
	 * otherwise returns false
	 */
	boolean areAllSequencesComplete(SortedSet aSelectionProfile);

	/**
	 * returns true if given category type statuses are set to complete,
	 * otherwise returns false
	 */
	boolean areAllSequencesComplete(SortedSet aSelectionProfile, Map aCatTyp);

	/**
	 * returns true if at least one sequence is complete or visit again,
	 * otherwise returns false
	 */
	boolean isAtLeastOneSequenceComplete(SortedSet aSelectionProfile, Map aCatTyp);

	/**
	 * finds the CategorySelectionProfile for the IndvSeq, and CategoryType and
	 * updates it with the newSeq only of the existing CateSeq is 0
	 */
	void updateSequence(SortedSet aSelectionProfile, String aAppNum, short aIndvSequence, long aNewSequence, String aCategoryType);

	/**
	 * finds the CategorySelectionProfile for the IndvSeq, and CategoryType and
	 * remove and insert the record for the newSeq only of the existing CateSeq is 0
	 */
	void persistSequence(String aAppNum, String aChangeSelCatCd, String aIndvSeqNum, String aNewSequence,String aCategoryType,String aOldSequence);

	
	/**
	 * Responsible for determining a current category sequence in the
	 * selectionProfile that the information is currently being loaded for.
	 */
	CategorySequenceDetail getCurrentSequenceDetail(SortedSet aSelectionProfile);

	/**
	 * sets the appropriate new status to the CategorySequenceDetail reference
	 */
	void makeSequenceDetailRequired(CategorySequenceDetail aCategorySeqDetail, String aAppNum);

	/**
	 * sets the appropriate new status to the CategorySequenceDetail reference
	 */
	void makeSequenceDetailComplete(CategorySequenceDetail aCategorySeqDetail, String aAppNum);

	/**
	 * resets the current record indicator to false
	 */
	void resetCurrentSeqeunceDetail(SortedSet aSelectionProfile);

	/**
	 * sets the current record indicator first profile
	 */
	void setCurrentRecordIndToFirst(SortedSet aSelectionProfile);

	/**
	 * sets the current record indicator end of the profile
	 */
	void setCurrentRecordIndToLast(SortedSet aSelectionProfile);

	/**
	 * returns true if Set contains no CategorySequenceBean's
	 */
	boolean isEmpty(SortedSet aSelectionProfile);

	/**
	 * returns true if Set contains no CategorySequenceBean's of the give
	 * category types
	 */
	boolean isEmpty(SortedSet aSelectionProfile, Map catType);

	boolean isRemoved(SortedSet aSelectionProfile, Map aCatTyp);

	/**
	 * loads the category selection profile from the data base for give app
	 * number and category selection cd
	 */
	SortedSet loadCategoryChangeSelectionProfile(String aAppNum, String changeCategorySelectionCd, String categoryType);
	
	/**
	 * loads the category selection profile from the data base for give app
	 * number and category selection cd
	 */
	SortedSet loadCategoryChangeSelectionProfile(String aAppNum, String changeCategorySelectionCd);

	/**
	 * loads the category selection profile from the data base for give app
	 * number
	 */
	SortedSet loadCategoryChangeSelectionProfile(String aAppNum);

	/**
	 * finds the CategorySelectionProfile for the IndvSeq, and CategoryType and
	 * updates it with the newUserEndInd
	 */
	void updateUserEndSelInd(SortedSet aSelectionProfile, String aAppNum, short aIndvSequence, long aSequence, String aCategoryType,
			short aNewUserEndInd);

	/**
	 * insert method to add a new record to the category selection profile for
	 * edit/end from summary
	 */
	void insertSequenceDetail(SortedSet aSelectionProfile, String aAppNum, String aChangeSelCatCd, short aIndvSeqNum, long catSeqNum,
			String aCategoryType, short userEndInd);

	/**
	 * returns true if at least one sequence is complete or visit again,
	 * otherwise returns false New method added for category code.
	 */
	boolean isAtLeastOneSequenceComplete(SortedSet aSelectionProfile, Map aCatTyp, String catCd);

	/**
	 * removeSequenceDetail(java.util.SortedSet, java.lang.String) Method takes
	 * a SortedSet to be deleted from the database . All rows in the table will
	 * be deleted for the set .
	 */
	void removeSequenceDetail(SortedSet aSelectionProfile, String aAppNum);

	/**
	 * returns true if Set contains no CategorySequenceBean's of the give
	 * category types
	 */

	boolean checkEmpty(SortedSet aSelectionProfile, Map catType);

	/**
	 * finds the CategorySelectionProfile for the IndvSeq, and CategoryType and
	 * updates it with the newUserEndInd
	 */
	void updateUserEndSelInd(SortedSet aSelectionProfile, String aAppNum, short aIndvSequence, short aSequence, String aCategoryType,
			short aNewUserEndInd);

	/**
	 * insert method to add a new record to the category selection profile for
	 * edit/end from summary
	 */
	void insertSequenceDetail(SortedSet aSelectionProfile, String aAppNum, String aChangeSelCatCd, short aIndvSeqNum, short catSeqNum,
			String aCategoryType, short userEndInd);

	/**
	 * insert method to add a new record to the category selection profile for
	 * edit/end/Change from summary and inserts the status
	 */
	void insertSequenceDetail(SortedSet aSelectionProfile, String aAppNum, String aChangeSelCatCd, short aIndvSeqNum, short catSeqNum,
			String aCategoryType, short userEndInd, char aStatus);

	/**
	 * constructs the SortedSet which will represent the selectionProfile for a
	 * given collection of cargos
	 */
	SortedSet buildSelectionProfile(RMC_RESPONSE_Custom_Collection aRmcResponseCustomColl, String aAppNum);

	/**
	 * loads the category selection profile from the data base for give app
	 * number and category selection codes
	 */
	SortedSet loadCategoryChangeSelectionProfileByCategoryCds(String aAppNum, String changeCategorySelectionCds);

	/**
	 * updates existing(given) SelectionProfile with the provided new Collection
	 * by category cds
	 */
	void rebuildSelectionProfileByCds(SortedSet aSelectionProfile, RMC_RESPONSE_Custom_Collection aRmcResponseCustomColl, String aAppNum,
			String aChangeSelCatCd);

	CategorySequenceDetail removeSubTypeSequence(SortedSet rmcSelPrfl, String appNum, String indvSeqNumber, String seqNum, String gatePostType,
			String detailType);

	CategorySequenceDetail getSubTypeSequence(SortedSet rmcSelPrfl, String appNum, String indvSeqNumber, String seqNum, String gatePostType,
			String detailType);

	boolean updateSubTypeSequence(SortedSet rmcSelPrfl, CategorySequenceDetail catSequenceDtl);

	void updateSequenceStatus(SortedSet rmcSelPrfl, String appNum, String indvSeqNum, String seqNum, String subType, String gatePostType,
			char status);

	SortedSet buildSelectionProfileBatch(RMC_RESPONSE_Custom_Collection aRmcResponseCustomColl,String aAppNum, String aChangeSelCatCd,int driverStatus);

	void rebuildSelectionProfileBatch(SortedSet aSelectionProfile,RMC_RESPONSE_Custom_Collection aRmcResponseCustomColl,String aAppNum, String aChangeSelCatCd,int driverStatus);
}
