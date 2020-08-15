package gov.state.nextgen.access.factory;

import gov.state.nextgen.access.model.PageResponse;
import gov.state.nextgen.access.business.entities.FwTransaction;

public interface LogicResponseBean {

	/**
	 * Method to construct PageResponse object. This method parses the FwTransaction
	 * object and construct PageResponse with details needed on the page.
	 * 
	 * @param txBean
	 * @return
	 */

	public PageResponse constructPageResponse(FwTransaction txBean);

}
