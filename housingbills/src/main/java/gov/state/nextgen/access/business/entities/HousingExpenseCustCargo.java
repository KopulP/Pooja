package gov.state.nextgen.access.business.entities;

import org.springframework.stereotype.Component;

import gov.state.nextgen.access.management.util.FWUtils;

@Component
public class HousingExpenseCustCargo extends FwAbstractWebServiceCargo{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static final String PACKAGE = "local:ejb/ejb/gov.state.nextgen/access/business/services/cares/CwwHousingExpensesEJBLocalHome";

	private long[] pins;
	private String[] types;
	private long[] seqs;
	private String caseNumber;

	private APP_IN_SHLTC_Collection appInShltcColl;
	private APP_IN_UTILC_Collection appInUtlcColl;
	private APP_IN_IRWE_Collection appInIRWEColl;
	private APP_IN_SPRT_OBLG_Collection appInSprtOblgColl;
	private APP_IN_DC_E_Collection appInDcEColl;
	private APP_IN_RM_BRD_EXP_Collection appInRmBrdExpColl;
	private APP_IN_ROOM_BRD_Collection appInRoomBrdColl;
	private CP_APP_IN_INCOME_TAX_DED_Collection cpAppInTaxDeductColl;

	/**
	 * @return Returns the pACKAGE.
	 */
	@Override
	public String getPackage() {
		return PACKAGE;
	}

	/**
	 * returns the string value of cargo.
	 */
	@Override
	public String inspectCargo() {
		return new StringBuilder().append("HOUSING_EXPENSE_CUST_Cargo: ").append("PINS=").append(pins).toString();
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public long[] getPins() {
		return pins;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public void setPins(final long[] ls) {
		pins = FWUtils.arrayCopy(ls);
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public String[] getTypes() {
		return types;
	}

	/**
	 * Enter the description of the method Creation Date:
	 */
	public void setTypes(final String[] ls) {
		types = FWUtils.arrayCopy(ls);
	}

	public long[] getSeqs() {
		return seqs;
	}

	public void setSeqs(final long[] ls) {
		seqs = FWUtils.arrayCopy(ls);
	}

	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(final String caseNum) {
		caseNumber = caseNum;
	}

	/**
	 * @return Returns the appInShltcColl.
	 */
	public APP_IN_SHLTC_Collection getAppInShltcColl() {
		return appInShltcColl;
	}

	/**
	 * @param appInShltcColl
	 *            The appInShltcColl to set.
	 */
	public void setAppInShltcColl(final APP_IN_SHLTC_Collection appInShltcColl) {
		this.appInShltcColl = appInShltcColl;
	}

	/**
	 * @return Returns the appInUtlcColl.
	 */
	public APP_IN_UTILC_Collection getAppInUtlcColl() {
		return appInUtlcColl;
	}

	/**
	 * @param appInUtlcColl
	 *            The appInUtlcColl to set.
	 */
	public void setAppInUtlcColl(final APP_IN_UTILC_Collection appInUtlcColl) {
		this.appInUtlcColl = appInUtlcColl;
	}

	/**
	 * @return Returns the appInIRWEColl.
	 */
	public APP_IN_IRWE_Collection getAppInIRWEColl() {
		return appInIRWEColl;
	}

	/**
	 * @param appInIRWEColl
	 *            The appInIRWEColl to set.
	 */
	public void setAppInIRWEColl(final APP_IN_IRWE_Collection appInIRWEColl) {
		this.appInIRWEColl = appInIRWEColl;
	}

	/**
	 * @return Returns the appInSprtOblgColl.
	 */
	public APP_IN_SPRT_OBLG_Collection getAppInSprtOblgColl() {
		return appInSprtOblgColl;
	}

	/**
	 * @param appInSprtOblgColl
	 *            The appInSprtOblgColl to set.
	 */
	public void setAppInSprtOblgColl(final APP_IN_SPRT_OBLG_Collection appInSprtOblgColl) {
		this.appInSprtOblgColl = appInSprtOblgColl;
	}

	/**
	 * @return Returns the appInSprtOblgColl.
	 */

	/**
	 * @return Returns the cpAppInTaxDeductColl.
	 */
	public CP_APP_IN_INCOME_TAX_DED_Collection getCpAppInTaxDeductColl() {
		return cpAppInTaxDeductColl;
	}

	/**
	 * @param cpAppInTaxDeductColl The cpAppInTaxDeductColl to set.
	 */
	public void setCpAppInTaxDeductColl(final CP_APP_IN_INCOME_TAX_DED_Collection cpAppInTaxDeductColl) {
		this.cpAppInTaxDeductColl = cpAppInTaxDeductColl;
	}

	public APP_IN_DC_E_Collection getAppInDcEColl() {
		return appInDcEColl;
	}

	/**
	 * @param appInDcEColl
	 *            The appInDcEColl to set.
	 */
	public void setAppInDcEColl(final APP_IN_DC_E_Collection appInDcEColl) {
		this.appInDcEColl = appInDcEColl;
	}

	/**
	 * @return Returns the appInRmBrdExpColl.
	 */
	public APP_IN_RM_BRD_EXP_Collection getAppInRmBrdExpColl() {
		return appInRmBrdExpColl;
	}

	/**
	 * @param appInRmBrdExpColl
	 *            The appInRmBrdExpColl to set.
	 */
	public void setAppInRmBrdExpColl(final APP_IN_RM_BRD_EXP_Collection appInRmBrdExpColl) {
		this.appInRmBrdExpColl = appInRmBrdExpColl;
	}

	/**
	 * @return Returns the appInRmBrdExpColl.
	 */
	public APP_IN_ROOM_BRD_Collection getAppInRoomBrdColl() {
		return appInRoomBrdColl;
	}

	/**
	 * @param appInRoomBrdColl
	 *            The appInRoomBrdColl to set.
	 */
	public void setAppInRoomBrdColl(final APP_IN_ROOM_BRD_Collection appInRoomBrdColl) {
		this.appInRoomBrdColl = appInRoomBrdColl;
	}
}
