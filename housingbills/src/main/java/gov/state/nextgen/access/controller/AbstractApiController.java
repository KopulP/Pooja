package gov.state.nextgen.access.controller;


import gov.state.nextgen.access.exceptions.BusinessWrappedNotInstantiatedException;
import gov.state.nextgen.access.factory.LogicBeanFactory;
import gov.state.nextgen.access.factory.LogicWrapperBean;

/**
 * @author Francisco Javier de Ros
 * Deloitte Consulting LLP.
 * Last changed: Dec 12, 2018
 * @version $Id: AbstractApiController.java 337196 2018-12-04 15:35:43Z fderos $ @since
 */
public abstract class AbstractApiController {


	/**
	 * Encapsulates at controller level, check made on {@link gov.state.nextgen.cp.site.factory.LogicBeanFactory#checkExistBeanInstance(java.lang.String, java.lang.String)}.
	 * It also allows to work with Unit tests.
	 * @param currentPageId
	 * @param pageAction
	 * @return
	 */
	public boolean checkExistBeanInstance(String currentPageId, String pageAction) {
		return LogicBeanFactory.checkExistBeanInstance(currentPageId, pageAction);
	}
	
	/**
	 * Encapsulates at controller level, check made on {@link gov.state.nextgen.cp.site.factory.LogicBeanFactory#createBeanInstance(java.lang.String, java.lang.String)}.
	 * It also allows to work with Unit tests.
	 * @param currentPageId
	 * @param pageAction
	 * @return
	 * @throws BusinessWrappedNotInstantiatedException
	 */
	public LogicWrapperBean createBeanInstance(String currentPageId, String pageAction) 
			throws BusinessWrappedNotInstantiatedException {
		return LogicBeanFactory.createBeanInstance(currentPageId, pageAction);
	}
	
}
