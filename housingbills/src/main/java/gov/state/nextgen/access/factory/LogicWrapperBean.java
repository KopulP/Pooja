package gov.state.nextgen.access.factory;

import java.util.Map;

import javax.servlet.http.HttpSession;

import gov.state.nextgen.access.model.PageResponse;
import gov.state.nextgen.access.business.entities.FwTransaction;

/**
 * @author Francisco Javier de Ros
 * 
 *  Deloitte Consulting LLP.
 *  
 * @version 0.0.1-SNAPSHOT $Id: LogicWrapperBean.java 336288 2018-12-12 09:27:00Z
 *          fderos $ @since 0.0.1-SNAPSHOT
 */
public interface LogicWrapperBean {
	
	public PageResponse processLogic(FwTransaction txBean, Map<String, Object> payload, HttpSession httpSession) throws Exception;

	//public String getPageId();
}
