package gov.state.nextgen.access.factory;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.state.nextgen.access.business.entities.FwTransaction;
import gov.state.nextgen.access.business.factory.EligibiltyScreenerInterface;
import gov.state.nextgen.access.business.factory.HousingBillsInterface;
import gov.state.nextgen.access.business.rules.MessageTableService;
import gov.state.nextgen.access.exceptions.BusinessWrappedNotInstantiatedException;
import gov.state.nextgen.access.exceptions.FwException;
import gov.state.nextgen.access.exceptions.FwWrappedException;
import gov.state.nextgen.access.management.constants.FwConstants;
import gov.state.nextgen.access.management.messages.FwMessage;
import gov.state.nextgen.access.management.messages.FwMessageList;
import gov.state.nextgen.access.model.PageResponse;

@Component
public class CommonLogicBean implements LogicWrapperBean {

	private static final Logger log = LoggerFactory.getLogger(CommonLogicBean.class);

	@Autowired 
	EligibiltyScreenerInterface eligibiltyScreener;
	
	@Autowired
	HousingBillsInterface housingBillsInterface;

	@Autowired
	MessageTableService messageService;

	@SuppressWarnings("unchecked")
	public PageResponse processLogic(FwTransaction txBean, Map<String, Object> payLoad, HttpSession httpSession) throws Exception {

		PageResponse pageResponse = null;
		String currentPageId = (String) txBean.getRequest().get(FwConstants.CURRENT_PAGE_ID);
		String nextPageId = null;
		if(txBean.getPageActionDetails() != null)
			nextPageId =  txBean.getPageActionDetails().getSuccessPageID();
		try {
			eligibiltyScreener.saveEligibiltyQuestions(txBean);
			if (txBean.getRequest()!= null && txBean.getRequest().get(FwConstants.MESSAGE_LIST) != null) {
				txBean.getRequest().put(FwConstants.NEXT_PAGE_ID, currentPageId);
				nextPageId = (String) txBean.getRequest().get(FwConstants.CURRENT_PAGE_ID);
			} else {
				txBean.getRequest().put(FwConstants.NEXT_PAGE_ID, nextPageId);
			}
			if (nextPageId != null) {
				pageResponse = getResponseBeanInstance(nextPageId).constructPageResponse(txBean);
			}
			populateValidationMessages(txBean, pageResponse);
			populateHttpSession(httpSession,txBean.getSession());

		} catch (FwException | FwWrappedException | BusinessWrappedNotInstantiatedException e) {
			log.error("Error processing page-action request.", e);
		} catch (Exception e) {
			throw e;
		}

		return pageResponse;
	}

	/**
	 * This method populates the validation text messages in the FwTransaction for
	 * the message codes returned from the BO layer.
	 * 
	 * @param txBean
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private void populateValidationMessages(FwTransaction txBean, PageResponse pageResponse) {

		FwMessageList fwMessageList = null;
		List<FwMessage> fwMessages = null;

		// logic for extracting and setting the messages
		if (hasValidationErrors(txBean)) {

			fwMessageList = (FwMessageList) txBean.getRequest().get(FwConstants.MESSAGE_LIST);
			fwMessages = fwMessageList.getMessageList();

			fwMessages.forEach(fwMessage -> {

				fwMessage.setEnglishMessage(
						this.getMessageDescription(fwMessage.getMessageCode(), FwConstants.ENGLISH)[1]);

				fwMessage.setSpanishMessage(
						this.getMessageDescription(fwMessage.getMessageCode(), FwConstants.SPANISH)[1]);

			});

			pageResponse.setValidationMessages(fwMessages);

		}

	}

	/**
	 * The method returns the message description by looking up the PageMap
	 * (Messages) which is cached on server startup using message code and language.
	 * 
	 * @param messageCode
	 * @param language
	 * @return
	 */
	private String[] getMessageDescription(String messageCode, String language) {

		String message[] = new String[2];
		message = messageService.getMessageByCode(messageCode, FwConstants.ENGLISH);
		//message = FwMessageManager.getRefTableMessage(messageCode, language);

		// if there is no message found for the code and language provided
		// return default validation message based on language code.
		if (message.length == 0) {
			// TODO: log exception with the Error code and language code.
			if (FwConstants.ENGLISH.equals(language)) {

				message[0] = FwConstants.ONE;
				message[1] = FwConstants.DEFAULT_ENGLISH_VALIDATION_MESSAGE;

			} else if (FwConstants.SPANISH.equals(language)) {

				message[0] = FwConstants.ONE;
				message[1] = FwConstants.DEFAULT_SPANISH_VALIDATION_MESSAGE;
			}

		}

		return message;
	}

	protected boolean hasValidationErrors(FwTransaction txBean) {

		boolean hasValidationErrors = false;

		if (txBean.getRequest().get(FwConstants.MESSAGE_LIST) != null) {

			hasValidationErrors = true;
		}
		return hasValidationErrors;

	}
	
	private LogicResponseBean getResponseBeanInstance(String pageId) throws BusinessWrappedNotInstantiatedException {
		return LogicBeanFactory.createPageResponseBean(pageId);
	}

	/**
	 * Clears and populates HttpSession object from session map
	 * @param httpSession
	 * @param sessionScope
	 */
	protected void populateHttpSession(HttpSession httpSession, Map sessionScope) {
		if (sessionScope != null) {

			final Enumeration enumtype = httpSession.getAttributeNames();
			while (enumtype.hasMoreElements()) {
				httpSession.removeAttribute((String) enumtype.nextElement());
			}
			sessionScope.forEach((k,v)->httpSession.setAttribute((String) k, v));
		}
	}

}
