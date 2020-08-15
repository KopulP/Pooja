package gov.state.nextgen.access.driver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import gov.state.nextgen.access.business.entities.FwTransaction;
import gov.state.nextgen.access.exceptions.FwException;
import gov.state.nextgen.access.exceptions.FwExceptionManager;
import gov.state.nextgen.access.exceptions.FwWrappedException;
import gov.state.nextgen.access.factories.FwServiceFactory;
import gov.state.nextgen.access.locator.ILocator;
import gov.state.nextgen.access.management.configuration.FwPageActionDetails;
import gov.state.nextgen.access.management.constants.FwConstants;
import gov.state.nextgen.access.management.logging.ILog;

/**
 * Enter the description of the class
 *
 * @author addepup
 * Creation Date Jun 14, 2004 Modified By: Modified on: PCR#
 */
public class FwNavigation implements INavigation {
	private static FwNavigation fwNavigation = new FwNavigation();
	private static ILocator locator;
	private static IFwDriver driver;

	/**
	 * Default Constructor for FwNavigation.
	 */
	private FwNavigation() {
		// Get the Instance of ILocator.
		locator = (ILocator) FwServiceFactory.getInstance().create(ILocator.class);
		driver = (IFwDriver) FwServiceFactory.getInstance().create(IFwDriver.class);
	}

	private ILog logger = null;

	protected void log(final int level, final String message) {
		if (logger == null) {
			logger = (ILog) FwServiceFactory.getInstance().create(ILog.class);
		}
		logger.log(this.getClass(), level, message);
	}

	/**
	 * Singleton method create Instance for FwNavigation class. Creation date:
	 * (04/29/2004 11:15:00 AM)
	 */
	public static INavigation getInstance() {
		// METHOD DOES NOT NEED TO BE SYNCHRONIZED AS INSTANCE IS OBTAINED
		// STATICALLY IN CLASS DECLARATION
		// DO NOT MODIFY CODE TO MAKE METHOD SYNCHRONIZED OR USE DOUBLE-LOCKING
		// AS DOUBLE-LOCKING IS NOT THREAD-SAFE CURRENTLY
		return fwNavigation;
	}

	/**
	 * Main Method which decides the Controll for the Web-Navigation.
	 *
	 * @return Map (Return's Null if any condition not Met correctly. Check for
	 *         null in the calling method.
	 */
	public void navigate(final FwTransaction txnBean) throws FwException {

		final Map requestScope = txnBean.getRequest();
		final Map sessionScope = txnBean.getSession();
		final FwPageActionDetails pageActionDetails = txnBean.getPageActionDetails();
		final String currentPageId = (String) requestScope.get(FwConstants.CURRENT_PAGE_ID);

		// want to get the successType here
		// successType is loaded at preLoad
		// logic for each type
		// 1) pageid
		// 2) pageaction
		// 3) driver
		// 4) class and method

		// if the transaction is a part of the driver, then determine response
		final String driverKey = pageActionDetails.getSuccessDriver();
		if (driverKey != null) {
			final int[] driverArray = (int[]) sessionScope.get(driverKey);
			determineResponse(currentPageId, driverArray, txnBean);
		} else // if not a part of the driver, then determine response through
			// pageactions.xml
		{
			// response could the be the next page id
			final String _pageId = pageActionDetails.getSuccessPageID();
			if (_pageId != null) {
				requestScope.put(FwConstants.NEXT_PAGE_ID, _pageId);
			}
			// response could be the next page action
			final String _pageAction = pageActionDetails.getSuccessPageAction();
			if (_pageAction != null) {
				requestScope.put(FwConstants.NEXT_PAGE_ACTION, _pageAction);
				// also need to get the success of the next page action
				// need to get the success Map and then get the next page ID
				// we assume that the next page action will always have a next
				// page id
				// next page action is known so load the new page action details
				// into the txnBean
				locator.loadPageActionDetails(_pageAction, txnBean);
				final String _pageIdOfNextPageAction = pageActionDetails.getSuccessPageID();
				if (_pageIdOfNextPageAction != null) {
					requestScope.put(FwConstants.NEXT_PAGE_ID, _pageIdOfNextPageAction);
				}
			}

			// response could be a class and method which will return
			// either a next page id or next page action
			final String _class = pageActionDetails.getSuccessClass();
			final String _method = pageActionDetails.getSuccessMethod();
			if ((_class != null) && (_method != null)) {

				invokeClass(_class, _method, txnBean);
			}
		}
	}

	/**
	 *
	 */
	public void determineResponse(final String currentPageId, final int[] driverArray, final FwTransaction txnBean) throws FwException {

		final FwPageActionDetails pageActionDetails = txnBean.getPageActionDetails();

		try {

			final String driverKey = pageActionDetails.getSuccessDriver();
			final String direction = pageActionDetails.getSuccessDirection();
			final String classString = pageActionDetails.getSuccessClass();
			final String classMethod = pageActionDetails.getSuccessMethod();

			if ((direction != null) && (driverKey != null)) {
				if (direction.equalsIgnoreCase("NEXT")) {
					determineNextResponse(driverKey, currentPageId, driverArray, txnBean);
				} else if (direction.equalsIgnoreCase("PREVIOUS")) {
					determinePreviousResponse(driverKey, currentPageId, driverArray, txnBean);
				} else {
					log(ILog.INFO, "FwNavigation.determineResponse() - Raising FwException manually on a condition");

					final FwException fe = new FwException("Message code : FW034");
					fe.setClassID(this.getClass().getName());
					fe.setMethodID("invokeClass");
					fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
					fe.setMessageCode("FW034");
					throw fe;
				}
			} else if ((classString != null) && (classMethod != null)) {
				try {
					// fix this reflection code
					// how to call a BO using reflection
					final Class theClass = Class.forName(classString);
					final Class[] classes = new Class[1];
					classes[0] = FwTransaction.class;

					final Object[] objects = new Object[1];
					objects[0] = txnBean;
					final ILog logger = (ILog) FwServiceFactory.getInstance().create(ILog.class);
					final Method method = theClass.getMethod(classMethod, classes);
					final Map sessionObj = txnBean.getSession();
					if ((sessionObj != null) && (sessionObj.get(FwConstants.HTTP_SESSION) != null)) {
						logger.log(getClass(), ILog.WARN, "Session Map available");
						final Map httpSessionMap = (Map) sessionObj.get(FwConstants.HTTP_SESSION);
						Map securedSessMap = (Map) httpSessionMap.get(FwConstants.SECURED_SESSION);
						if ((securedSessMap == null) && (sessionObj.get(FwConstants.SECURED_LDAP_WID) != null)
								&& (sessionObj.get(FwConstants.SECURED_USER_FULL_NAME) != null)) {
							logger.log(getClass(), ILog.WARN, "Secured Session Map unavailable");
							securedSessMap = new HashMap();
							securedSessMap.put(FwConstants.LDAP_WID, sessionObj.get(FwConstants.SECURED_LDAP_WID));
							securedSessMap.put(FwConstants.USER_FULL_NAME, sessionObj.get(FwConstants.SECURED_USER_FULL_NAME));
							httpSessionMap.put(FwConstants.SECURED_SESSION, securedSessMap);
							sessionObj.put(FwConstants.HTTP_SESSION, httpSessionMap);
							txnBean.setSession(sessionObj);
						} else {
							logger.log(getClass(), ILog.WARN, "Secured Session Map available");
						}
					}
					method.invoke(theClass.newInstance(), objects);
				} catch (final ClassNotFoundException cnf) {
					final FwException fe = new FwException(cnf);
					fe.setClassID(this.getClass().getName());
					fe.setMethodID("determineResponse-ClassNotFound");
					fe.setExceptionText(String.valueOf(cnf));
					fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
					fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(cnf));
					throw fe;
				} catch (final InstantiationException ie) {
					final FwException fe = new FwException(ie);
					fe.setClassID(this.getClass().getName());
					fe.setMethodID("determineResponse-Instantiation");
					fe.setExceptionText(String.valueOf(ie));
					fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
					fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(ie));
					throw fe;
				} catch (final NoSuchMethodException nsme) {
					final FwException fe = new FwException(nsme);
					fe.setClassID(this.getClass().getName());
					fe.setMethodID("determineResponse-NoSuchMethod");
					fe.setExceptionText(String.valueOf(nsme));
					fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
					fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(nsme));
					throw fe;
				} catch (final IllegalAccessException iae) {
					final FwException fe = new FwException(iae);
					fe.setClassID(this.getClass().getName());
					fe.setMethodID("determineResponse-IllegalAccess");
					fe.setExceptionText(String.valueOf(iae));
					fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
					fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(iae));
					throw fe;
				} catch (final InvocationTargetException ite) {
					final FwException fe = new FwException(ite);
					fe.setClassID(this.getClass().getName());
					fe.setMethodID("determineResponse-IllegalAccess");
					fe.setExceptionText(String.valueOf(ite));
					fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
					fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(ite));
					throw fe;
				}
				// At the End, Check if Direction is available.
				if (direction != null) {
					if (direction.equalsIgnoreCase("NEXT")) {
						determineNextResponse(driverKey, currentPageId, driverArray, txnBean);
					} else if (direction.equalsIgnoreCase("PREVIOUS")) {
						determinePreviousResponse(driverKey, currentPageId, driverArray, txnBean);
					} else {
						log(ILog.INFO, "FwNavigation.determineResponse() - Raising FwException manually on a condition");
						final FwException fe = new FwException(" Message Code : FW034");
						fe.setClassID(this.getClass().getName());
						fe.setMethodID("invokeClass");
						fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
						fe.setMessageCode("FW034");
						throw fe;
					}
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("determineResponse");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	/**
	 *
	 */
	private void determineNextResponse(final String driverKey, final String currentPageId, final int[] driverArray, final FwTransaction txnBean) {

		try {

			int nextIndex = 0;

			if (driverKey.equals(FwConstants.AFB_DRIVER) || driverKey.equals(FwConstants.RMC_DRIVER) || driverKey.equals(FwConstants.APW_DRIVER)
					|| driverKey.equals(FwConstants.APC_DRIVER) || driverKey.equals(FwConstants.AHN_DRIVER)) {
				nextIndex = determineAFBNextResponse(driverKey, currentPageId, driverArray);
			} else if (driverKey.equals(FwConstants.ACCESS_DRIVER)) {
				nextIndex = determineScreenerNextResponse(driverKey, currentPageId, driverArray);
			}

			// Find the next page id and next page action based on nextIndex
			// found above
			final String pageId = driver.getPageId(driverKey, nextIndex);
			final String pageAction = driver.getPageAction(driverKey, pageId);
			txnBean.getRequest().put(FwConstants.NEXT_PAGE_ID, pageId);
			txnBean.getRequest().put(FwConstants.NEXT_PAGE_ACTION, pageAction);

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("determineNextResponse");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	private int determineAFBNextResponse(final String driverKey, final String currentPageId, final int[] driverArray) {
		int nextIndex = 0;
		try {

			boolean RorVfound = false;

			// Start at the beginning of the driver array
			// Find the first required or visit again page
			// If there are no required or visit again pages, then go to the
			// next completed page
			// from the current array index (the current page).
			// Numeric equivalents are 1 for required
			// 2 for visit again
			// 4 for complete
			// 5 for add new
			final int lengthOfArray = driverArray.length;
			for (int i = 0; i < lengthOfArray; i++) {
				// Look for the Occurence of 1, 2, 5.
				final int tempVal = driverArray[i];
				if ((tempVal == 1) || (tempVal == 2) || (tempVal == 5)) {
					nextIndex = i;
					// R or V or A is found
					RorVfound = true;
					break;
				}
			}
			// if a required or visit again page is not found
			// get the current array index and go to the next completed page
			if (!RorVfound) {
				final int startIndex = driver.getIndexForPageId(driverKey, currentPageId);
				for (int i = startIndex + 1; i < lengthOfArray; i++) {
					// Look for the Occurence of 4.
					final int tempVal = driverArray[i];
					if (tempVal == 4) {
						nextIndex = i;
						break;
					}
				}
			}

			return nextIndex;

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("determineAFBNextResponse");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	private int determineScreenerNextResponse(final String driverKey, final String currentPageId, final int[] driverArray) {
		int nextIndex = 0;
		try {

			final int index = driver.getIndexForPageId(driverKey, currentPageId);

			// Start at array index of the current page
			// Go to the next array index and check the status
			// If the status is required or complete, then go to that page
			// If the status is not required, then go to the next array index
			// Numeric equivalents are 1 for required
			// 0 for not required
			// 4 for complete
			final int lengthOfArray = driverArray.length;
			for (int i = index + 1; i < lengthOfArray; i++) {
				// Look for the Occurence of 1 or 2.
				final int tempVal = driverArray[i];
				if (tempVal != 0) {
					nextIndex = i;
					break;
				}
			}
			return nextIndex;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("determineScreenerNextResponse");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	/**
	 *
	 */
	private void determinePreviousResponse(final String driverKey, final String currentPageId, final int[] driverArray, final FwTransaction txnBean) {

		try {

			int prevIndex = 0;

			if (driverKey.equals(FwConstants.AFB_DRIVER) || driverKey.equals(FwConstants.RMC_DRIVER) || driverKey.equals(FwConstants.APW_DRIVER)
					|| driverKey.equals(FwConstants.APC_DRIVER) || driverKey.equals(FwConstants.AHN_DRIVER)) {
				prevIndex = determineAFBPreviousResponse(driverKey, currentPageId, driverArray);
			} else if (driverKey.equals(FwConstants.ACCESS_DRIVER)) {
				prevIndex = determineScreenerPreviousResponse(driverKey, currentPageId, driverArray);
			}

			// Find the next page id and next page action based on prevIndex
			// found above
			final String pageId = driver.getPageId(driverKey, prevIndex);
			final String pageAction = driver.getPageAction(driverKey, pageId);
			txnBean.getRequest().put(FwConstants.NEXT_PAGE_ID, pageId);
			txnBean.getRequest().put(FwConstants.NEXT_PAGE_ACTION, pageAction);

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("determinePreviousResponse");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}

	}

	private int determineScreenerPreviousResponse(final String driverKey, final String currentPageId, final int[] driverArray) {
		int prevIndex = 0;
		try {

			final int index = driver.getIndexForPageId(driverKey, currentPageId);
			// Start at the current page's array index
			// Find the previous index in the array where
			// the page status is not not required.
			// Numeric equivalents are 0 for not required
			for (int i = index - 1; i > 0; --i) {
				final int tempVal = driverArray[i];
				if (tempVal != 0) {
					prevIndex = i;
					break;
				}
			}
			return prevIndex;

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("determineScreenerPreviousResponse");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}

	}

	private int determineAFBPreviousResponse(final String driverKey, final String currentPageId, final int[] driverArray) {

		try {
			final int index = driver.getIndexForPageId(driverKey, currentPageId);
			int prevIndex = 0;

			boolean RorVfound = false;

			// Start at the beginning of the driver array
			// Find the first required or visit again page
			// up until the current index (current page)
			// If there are no required or visit again pages,
			// then go to the previous completed page closest to the current
			// index
			// Numeric equivalents are 0 for not required
			// 1 for required
			// 2 for visit again
			// 3 for protected
			// 4 for complete
			// 5 for add new
			for (int i = 0; i < index; i++) {
				// Look for the Occurence of 1, 2, 6 or 7.
				final int tempVal = driverArray[i];
				if ((tempVal == 1) || (tempVal == 2) || (tempVal == 5)) {
					prevIndex = i;
					// R or V or A is found
					RorVfound = true;
					break;
				}
			}
			// if a required or visit again page is not found
			// get the current array index and go to the previous completed page
			// closest to the current index (current page)
			if (!RorVfound) {
				final int startIndex = driver.getIndexForPageId(driverKey, currentPageId);
				for (int i = startIndex - 1; i >= 0; i--) {
					// Look for the Occurence of 4.
					final int tempVal = driverArray[i];
					if (tempVal == 4) {
						prevIndex = i;
						break;
					}
				}
			}
			// if no required or completed or visit again page is found, then
			// by default it will go back to the first position in the driver
			// this should be the case summary page in access program
			// information page
			return prevIndex;

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("determineAFBPreviousResponse");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	@Override
	public void invokeClass(final String className, final String methodName, final FwTransaction txnBean) {
		try {
			// fix this reflection code
			// how to call a BO using reflection
			final Class theClass = Class.forName(className);
			final Class[] classes = new Class[1];
			classes[0] = FwTransaction.class;

			final Object[] objects = new Object[1];
			objects[0] = txnBean;

			final Method method = theClass.getMethod(methodName, classes);
			final ILog logger = (ILog) FwServiceFactory.getInstance().create(ILog.class);
			final Map sessionObj = txnBean.getSession();
			if ((sessionObj != null) && (sessionObj.get(FwConstants.HTTP_SESSION) != null)) {
				logger.log(getClass(), ILog.WARN, "Session Map available");
				final Map httpSessionMap = (Map) sessionObj.get(FwConstants.HTTP_SESSION);
				Map securedSessMap = (Map) httpSessionMap.get(FwConstants.SECURED_SESSION);
				if ((securedSessMap == null) && (sessionObj.get(FwConstants.SECURED_LDAP_WID) != null)
						&& (sessionObj.get(FwConstants.SECURED_USER_FULL_NAME) != null)) {
					logger.log(getClass(), ILog.WARN, "Secured Session Map unavailable");
					securedSessMap = new HashMap();
					securedSessMap.put(FwConstants.LDAP_WID, sessionObj.get(FwConstants.SECURED_LDAP_WID));
					securedSessMap.put(FwConstants.USER_FULL_NAME, sessionObj.get(FwConstants.SECURED_USER_FULL_NAME));
					httpSessionMap.put(FwConstants.SECURED_SESSION, securedSessMap);
					sessionObj.put(FwConstants.HTTP_SESSION, httpSessionMap);
					txnBean.setSession(sessionObj);
				} else {
					logger.log(getClass(), ILog.WARN, "Secured Session Map available");
				}
			}
			method.invoke(theClass.newInstance(), objects);
		} catch (final InvocationTargetException ite) {
			if (ite.getTargetException().getCause() instanceof FwException) {
				final FwException fe = (FwException) ite.getTargetException().getCause();
				throw fe;
			} else if (ite.getTargetException().getCause() instanceof FwWrappedException) {
				final FwWrappedException we = (FwWrappedException) ite.getTargetException().getCause();
				throw we;
			} else if (ite.getTargetException() instanceof FwException) {
				final FwException fe = (FwException) ite.getTargetException();
				throw fe;
			} else if (ite.getTargetException() instanceof FwWrappedException) {
				final FwWrappedException we = (FwWrappedException) ite.getTargetException();
				throw we;
			}
			log(ILog.INFO, "FwNavigation.invokeClass() - Raising FwException manually on a condition");
			final FwException fe = new FwException(ite);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("invokeClass-InvocationTarget");
			fe.setExceptionText(String.valueOf(ite));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(ite));
			throw fe;
		} catch (final ClassNotFoundException cnf) {
			final FwException fe = new FwException(cnf);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("invokeClass-ClassNotFound");
			fe.setExceptionText(String.valueOf(cnf));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(cnf));
			throw fe;
		} catch (final NoSuchMethodException nsme) {
			final FwException fe = new FwException(nsme);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("invokeClass-NoSuchMethod");
			fe.setExceptionText(String.valueOf(nsme));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(nsme));
			throw fe;
		} catch (final InstantiationException ie) {
			final FwException fe = new FwException(ie);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("invokeClass-Instantiation");
			fe.setExceptionText(String.valueOf(ie));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(ie));
			throw fe;
		} catch (final IllegalArgumentException iarge) {
			final FwException fe = new FwException(iarge);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("invokeClass-IllegalArgument");
			fe.setExceptionText(String.valueOf(iarge));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(iarge));
			throw fe;
		} catch (final IllegalAccessException iae) {
			final FwException fe = new FwException(iae);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("invokeClass-IllegalAccess");
			fe.setExceptionText(String.valueOf(iae));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(iae));
			throw fe;
		}

	}

	

}
