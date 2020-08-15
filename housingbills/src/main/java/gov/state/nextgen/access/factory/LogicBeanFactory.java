package gov.state.nextgen.access.factory;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import gov.state.nextgen.access.exceptions.BusinessWrappedNotInstantiatedException;

/**
 * @author Francisco Javier de Ros Deloitte Consulting LLP.
 */
@Component
@Scope("singleton")
public class LogicBeanFactory {

	private static final Logger log = LoggerFactory.getLogger(LogicBeanFactory.class);

	private static final String UNDERSCORE = "_";

	/**
	 * 
	 * @param currentPageId
	 * @param pageAction
	 * @param otherValues
	 * @return
	 * @throws BusinessWrappedNotInstantiatedException
	 * @deprecated
	 */
	public static LogicWrapperBean createBeanInstance(String currentPageId, String pageAction, List<String> otherValues)
			throws BusinessWrappedNotInstantiatedException {

		// Read properties based on input parameters. Every value is separated by
		// underscore value.
		String beanAlias = processReference(currentPageId, pageAction);
		// We get from memory the loaded alies beans.
		try (AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(
				LogicWrapperBeanConfig.class);) {
			LogicWrapperBean bean = (LogicWrapperBean) springContext.getBean(beanAlias);
			return bean;
		} catch (BeansException be) {
			StringBuilder message = new StringBuilder();
			message.append("Object Bean associated to Page Id: ");
			message.append(currentPageId);
			message.append(" and action: ");
			message.append(pageAction);
			message.append("could not be created");
			log.error(message.toString(), be);
		}

		StringBuilder message = new StringBuilder();
		message.append("Object Bean associated to Page Id: ");
		message.append(currentPageId);
		message.append(" and action: ");
		message.append(pageAction);
		message.append("could not be created");

		throw new BusinessWrappedNotInstantiatedException(message.toString());
	}

	public static LogicWrapperBean createBeanInstance(String currentPageId, String pageAction)
			throws BusinessWrappedNotInstantiatedException {

		// Read properties based on input parameters. Every value is separated by
		// underscore value.
		String beanAlias = processReference(currentPageId, pageAction);
		// We get from memory the loaded alies beans.
		try (AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(
				LogicWrapperBeanConfig.class);) {
			LogicWrapperBean bean = (LogicWrapperBean) springContext.getBean(beanAlias);
			return bean;
		} catch (BeansException be) {
			StringBuilder message = new StringBuilder();
			message.append("Object Bean associated to Page Id: ");
			message.append(currentPageId);
			message.append(" and action: ");
			message.append(pageAction);
			message.append("could not be created");
			log.error(message.toString(), be);
		}

		StringBuilder message = new StringBuilder();
		message.append("Object Bean associated to Page Id: ");
		message.append(currentPageId);
		message.append(" and action: ");
		message.append(pageAction);
		message.append("could not be created");

		throw new BusinessWrappedNotInstantiatedException(message.toString());
	}

	/**
	 * 
	 * @param currentPageId
	 * @param pageAction
	 * @param otherValues
	 * @return
	 * @deprecated
	 */
	public static boolean checkExistBeanInstance(String currentPageId, String pageAction, List<String> otherValues) {
		String beanAlias = processReference(currentPageId, pageAction, otherValues);
		// We get from memory the loaded alies beans.
		// We get from memory the loaded alias beans.
		try (AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(
				LogicWrapperBeanConfig.class);) {

			return springContext.containsBean(beanAlias);
		} catch (BeansException be) {
			StringBuilder message = new StringBuilder();
			message.append("Object Bean associated to Page Id: ");
			message.append(currentPageId);
			message.append(" and action: ");
			message.append(pageAction);
			message.append("could not be created");
			log.error(message.toString(), be);
		}
		return false;
	}

	/**
	 * 
	 * @param currentPageId
	 * @param pageAction
	 * @return
	 */
	public static boolean checkExistBeanInstance(String currentPageId, String pageAction) {
		String beanAlias = processReference(currentPageId, pageAction);
		// We get from memory the loaded alias beans.
		try (AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(
				LogicWrapperBeanConfig.class);) {

			return springContext.containsBean(beanAlias);
		} catch (BeansException be) {
			StringBuilder message = new StringBuilder();
			message.append("Object Bean associated to Page Id: ");
			message.append(currentPageId);
			message.append(" and action: ");
			message.append(pageAction);
			message.append("could not be created");
			log.error(message.toString(), be);
		}
		return false;
	}

	/**
	 * @param currentPageId
	 * @param pageAction
	 * @param otherValues
	 * @deprecated
	 */
	private static String processReference(String currentPageId, String pageAction, List<String> otherValues) {
		StringBuilder referenceBuilder = new StringBuilder();
		if (StringUtils.isNotEmpty(currentPageId)) {
			referenceBuilder.append(currentPageId);
			referenceBuilder.append(UNDERSCORE);
		}

		if (StringUtils.isNotEmpty(pageAction)) {
			referenceBuilder.append(pageAction);
			referenceBuilder.append(UNDERSCORE);
		}

		for (String otherValue : otherValues) {
			if (StringUtils.isNotEmpty(otherValue)) {
				referenceBuilder.append(otherValue);
				referenceBuilder.append(UNDERSCORE);
			}
		}

		return referenceBuilder.substring(0, referenceBuilder.length() - 1);
	}

	/**
	 * 
	 * @param currentPageId
	 * @param pageAction
	 * @return
	 */
	private static String processReference(String currentPageId, String pageAction) {
		StringBuilder referenceBuilder = new StringBuilder();
		if (StringUtils.isNotEmpty(currentPageId)) {
			referenceBuilder.append(currentPageId);
			referenceBuilder.append(UNDERSCORE);
		}

		if (StringUtils.isNotEmpty(pageAction)) {
			referenceBuilder.append(pageAction);
			referenceBuilder.append(UNDERSCORE);
		}

		return referenceBuilder.substring(0, referenceBuilder.length() - 1);
	}

	/**
	 * This method returns the instance of ResponseBean bean associated for the
	 * pageId passed.
	 * 
	 * @param pageId
	 * @return
	 */
	public static LogicResponseBean createPageResponseBean(String pageId)
			throws BusinessWrappedNotInstantiatedException {

		try (AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(
				LogicWrapperBeanConfig.class);) {

			LogicResponseBean responseBean = (LogicResponseBean) springContext.getBean(pageId);

			return responseBean;

		} catch (BeansException be) {

			StringBuilder message = new StringBuilder();

			message.append("Response Bean associated to Page Id: ");
			message.append(pageId);
			message.append("could not be created");
			log.error(message.toString(), be);
			throw new BusinessWrappedNotInstantiatedException(message.toString());
		}
	}
}
