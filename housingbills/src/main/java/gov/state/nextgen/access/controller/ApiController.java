package gov.state.nextgen.access.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gov.state.nextgen.access.exceptions.BusinessWrappedNotInstantiatedException;
import gov.state.nextgen.access.factory.LogicWrapperBean;
import gov.state.nextgen.access.model.PageResponse;
import gov.state.nextgen.access.business.entities.FwTransaction;
import gov.state.nextgen.access.management.constants.FwConstants;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="/docker")
public class ApiController extends AbstractApiController {

	@Autowired
	private HttpSession httpSession;

	@Autowired
	LogicWrapperBean logicBean;

	@PostMapping("/housingbills/{currentPageId}/{pageAction}")
	public ResponseEntity<Object> apiRequest(@PathVariable("currentPageId") String currentPageId,
			@PathVariable("pageAction") String pageAction,
			@RequestBody FwTransaction txBean) throws BusinessWrappedNotInstantiatedException, Exception {
		Object obj = invokeServices(currentPageId, pageAction, txBean);
		return new ResponseEntity<Object>(obj, HttpStatus.OK);
	}

	/**
	 * Main point of input to EJB services from the controller.
	 * @param currentPageId
	 * @param pageAction
	 * @param payload
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	private Object invokeServices(String currentPageId, String pageAction,
			FwTransaction txBean) throws Exception {

		PageResponse pageResponse = null;
		// Start POC - Added Code
		final Map requestScope = new HashMap();
		requestScope.put(FwConstants.CURRENT_PAGE_ID, currentPageId);
		txBean.setRequest(requestScope);
		// End POC - Added Code
		pageResponse = logicBean.processLogic(txBean, null, httpSession);
		return pageResponse;
	}

}
