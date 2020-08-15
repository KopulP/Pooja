package gov.state.nextgen.access.business.factory;

import gov.state.nextgen.access.business.entities.FwTransaction;

public interface EligibiltyScreenerInterface {
	
	public void saveEligibiltyQuestions(FwTransaction txnBean) throws Exception;

}
