package gov.state.nextgen.access.model;

import java.io.Serializable;

public class AmIEligibleResults extends BaseDomainObject implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String isEligibleForMedicaid;
	private String isEligibleForSNAP;
	private String isEligibleForTANF;
	private String isEligibleForChildCare;
	private String isEligibleForWIC;
	
	
	public String getIsEligibleForMedicaid() {
		return isEligibleForMedicaid;
	}
	public void setIsEligibleForMedicaid(String isEligibleForMedicaid) {
		this.isEligibleForMedicaid = isEligibleForMedicaid;
	}
	public String getIsEligibleForSNAP() {
		return isEligibleForSNAP;
	}
	public void setIsEligibleForSNAP(String isEligibleForSNAP) {
		this.isEligibleForSNAP = isEligibleForSNAP;
	}
	public String getIsEligibleForTANF() {
		return isEligibleForTANF;
	}
	public void setIsEligibleForTANF(String isEligibleForTANF) {
		this.isEligibleForTANF = isEligibleForTANF;
	}
	public String getIsEligibleForChildCare() {
		return isEligibleForChildCare;
	}
	public void setIsEligibleForChildCare(String isEligibleForChildCare) {
		this.isEligibleForChildCare = isEligibleForChildCare;
	}
	public String getIsEligibleForWIC() {
		return isEligibleForWIC;
	}
	public void setIsEligibleForWIC(String isEligibleForWIC) {
		this.isEligibleForWIC = isEligibleForWIC;
	}
}
