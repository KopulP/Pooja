/*
 * 
 */
package gov.state.nextgen.access.business.validations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gov.state.nextgen.access.business.entities.FwTransaction;
import gov.state.nextgen.access.exceptions.FwException;
import gov.state.nextgen.access.exceptions.FwExceptionManager;
import gov.state.nextgen.access.factories.FwServiceFactory;
import gov.state.nextgen.access.management.constants.FwConstants;
import gov.state.nextgen.access.management.util.FwDataCriteria;
import gov.state.nextgen.access.persistence.management.IData;

/**
 * Singleton class manages Rules
 *
 * @author Architecture Team Creation Date Oct 26, 2005 Modified By: Modified
 *         on: PCR#
 */
public class FwRulesManager implements IRules {

	private static final IRules rulesManager = new FwRulesManager();
	private static Map rules = new HashMap(); // Rules cache
	private static Map compRule = new HashMap(); // comp rule cache
	private static Map compChild = new HashMap(); // comp children cache

	private static Map ruleClasses = new Hashtable();
	private static Map ruleMethods = new Hashtable();

	/**
	 * returns IRules
	 */
	public static IRules getInstance() {
		// METHOD DOES NOT NEED TO BE SYNCHRONIZED AS INSTANCE IS OBTAINED
		// STATICALLY IN CLASS DECLARATION
		// DO NOT MODIFY CODE TO MAKE METHOD SYNCHRONIZED OR USE DOUBLE-LOCKING
		// AS DOUBLE-LOCKING IS NOT THREAD-SAFE CURRENTLY
		return rulesManager;
	}

	/**
	 * @see gov.state.nextgen.framework.management.questions.IRules#cacheRules()
	 */
	public static void cacheRules() {

		final IData data = (IData) FwServiceFactory.getInstance().create(IData.class);
		final FwDataCriteria[] criteria = new FwDataCriteria[0];

		try {

			// cache the CPNT_RULE table
			final Map compRuleCriteria = new HashMap();
			compRuleCriteria.put(FwConstants.SQL_IND, "sql-Q3");
			compRuleCriteria.put(FwConstants.CRITERIA, criteria);
			final List compRuleList = data.execute(FwConstants.SQL, compRuleCriteria);
			String compId = null;
			String nextCompId = null;
			String ruleId = null;
			List ruleList = new ArrayList();
			for (int i = 0,size=compRuleList.size(); i < size; i++) {
				final Map row = (Map) compRuleList.get(i);
				nextCompId = (String) row.get(CPNT_ID);
				ruleId = (String) row.get(RULE_ID);
				if (compId == null) {
					compId = nextCompId;
				}
				if (!nextCompId.equals(compId)) {
					compRule.put(compId, ruleList);
					ruleList = new ArrayList();
					compId = nextCompId;
				}
				ruleList.add(ruleId);
			}
			compRule.put(compId, ruleList); // the last row added at the end

			// cache the APP_RULE table
			final Map ruleCriteria = new HashMap();
			ruleCriteria.put(FwConstants.SQL_IND, "sql-Q4");
			ruleCriteria.put(FwConstants.CRITERIA, criteria);
			final List rulesList = data.execute(FwConstants.SQL, ruleCriteria);
			String rule = null;
			for (int i = 0,size=rulesList.size(); i < size; i++) {
				final Map row = (Map) rulesList.get(i);
				rule = (String) row.get(RULE_ID);
				final String[] ruleAccessInfo = new String[2];
				ruleAccessInfo[0] = ((String) row.get(CLS_NAM));
				ruleAccessInfo[1] = ((String) row.get(MTHD_NAM));
				rules.put(rule, ruleAccessInfo);
			}

			// cache the CPNT_CHILD table
			final Map compChildCriteria = new HashMap();
			compChildCriteria.put(FwConstants.SQL_IND, "sql-Q5");
			compChildCriteria.put(FwConstants.CRITERIA, criteria);
			final List compChildCompList = data.execute(FwConstants.SQL, compChildCriteria);
			String cpntId = null;
			String nextCpntId = null;
			String childCpntId = null;
			String conditionalInd = null;
			Map childCompMap = new HashMap();
			for (int i = 0,size=compChildCompList.size(); i < size; i++) {
				final Map row = (Map) compChildCompList.get(i);
				nextCpntId = (String) row.get(CPNT_ID);
				childCpntId = (String) row.get(SUB_CPNT_ID);
				conditionalInd = (String) row.get(COND_IND);
				if (cpntId == null) {
					cpntId = nextCpntId;
				}
				if (!nextCpntId.equals(cpntId)) {
					compChild.put(cpntId, childCompMap);
					childCompMap = new HashMap();
					cpntId = nextCpntId;
				}
				childCompMap.put(childCpntId, conditionalInd);
			}
			compChild.put(cpntId, childCompMap); // the last row added at the
			// end

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(FwComponentManager.class.toString());
			fe.setMethodID("cacheRules");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	/**
	 * @see gov.state.nextgen.framework.management.questions.IRules#filterComponents(java.util.List,
	 *      gov.state.nextgen.framework.business.entities.FwTransaction)
	 */
	@Override
	public void runRulesForComponents(final List aComponentIDs, final FwTransaction aTxnBean) {

		final List compIds = new ArrayList();

		try {

			compIds.addAll(aComponentIDs);
			nextComp: for (int i = 0; i < compIds.size(); i++) {
				final String compID = (String) compIds.get(i);
				final List rulesList = getRulesForCompId(compID);
				aTxnBean.getRequest().put(CPNT_ID, compID); // put the comp_id
				// to the request
				// for
				// PeopleRulesManager
				for (int j = 0; j < rulesList.size(); j++) {
					if (!runRule((String) rulesList.get(j), aTxnBean)) {
						aComponentIDs.remove(compID);
						continue nextComp;
					}
				}

				// check for child components and rules
				final Map compChild = getChildComponentsForCompId(compID);
				final Iterator iter = compChild.keySet().iterator();
				while (iter.hasNext()) {
					final String childCompId = (String) iter.next();
					final String conditionalInd = (String) compChild.get(childCompId);
					final List compChildRules = getRulesForCompId(childCompId);
					aTxnBean.getRequest().put(CPNT_ID, compID); // put the
					// comp_id to
					// the request
					// for
					// PeopleRulesManager
					aTxnBean.getRequest().put(COND_IND, conditionalInd); // put
					// the
					// conditional
					// indicator
					// to
					// the
					// request
					// for
					// PeopleRulesManager
					for (int p = 0; p < compChildRules.size(); p++) {
						runRule((String) compChildRules.get(p), aTxnBean);
						final Map pageCollection = aTxnBean.getPageCollection();
						if ((pageCollection.get(FwConstants.REMOVE_COMPID_IND) != null)
								&& pageCollection.get(FwConstants.REMOVE_COMPID_IND).equals(FwConstants.REMOVE_COMPID_IND_YES)) {
							aComponentIDs.remove(compID);
							pageCollection.remove(FwConstants.REMOVE_COMPID_IND);
							continue nextComp;
						}
					}
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(FwComponentManager.class.toString());
			fe.setMethodID("runRulesForComponents");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	/**
	 * returns a list of rules for the given componentID
	 */
	private List getRulesForCompId(final String aCompId) {
		final List compRules = new ArrayList();

		try {

			if (compRule.get(aCompId) != null) {
				compRules.addAll((List) compRule.get(aCompId));
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(FwComponentManager.class.toString());
			fe.setMethodID("getRulesForCompId");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
		return compRules;
	}

	/**
	 * returns a list of child components for the given componentID
	 */
	private Map getChildComponentsForCompId(final String aCompId) {
		final Map compIds = new HashMap();
		try {

			if (compChild.get(aCompId) != null) {
				compIds.putAll((Map) compChild.get(aCompId));
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(FwComponentManager.class.toString());
			fe.setMethodID("getChildComponentsForCompId");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
		return compIds;
	}

	/**
	 * returns boolean after calling a rule
	 */
	private boolean runRule(final String ruleId, final FwTransaction aTxnBean) {

		try {
			final String[] ruleSource = (String[]) rules.get(ruleId);
			final Object result = invokeRule(ruleSource[0], ruleSource[1], aTxnBean);
			if (result instanceof Boolean) {
				return ((Boolean) result).booleanValue();
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(FwComponentManager.class.toString());
			fe.setMethodID("runRule");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
		return true;
	}

	/**
	 * calls the given calss and method to run a rule
	 */
	private Object invokeRule(final String aClassName, final String aMethodName, final FwTransaction aInput) {

		try {
			final Class clazz = getClass(aClassName);
			final Method method = getMethod(aClassName, aMethodName);
			final Object[] values = { aInput };
			return method.invoke(clazz.newInstance(), values);
		} catch (final InvocationTargetException ite) {
			if (ite.getCause() instanceof FwException) {
				final FwException fe = (FwException) ite.getCause();
				throw fe;
			} else if (ite.getTargetException().getCause() instanceof FwException) {
				final FwException fe = (FwException) ite.getTargetException().getCause();
				throw fe;
			} else if (ite.getTargetException() instanceof FwException) {
				final FwException fe = (FwException) ite.getTargetException();
				throw fe;
			}
			final FwException fe = new FwException(ite);
			fe.setClassID(FwRulesManager.class.getName());
			fe.setMethodID("invokeRule");

			if (ite.getCause() != null) {
				fe.setExceptionText(ite.getCause().toString());
				fe.setStackTraceValue(FwExceptionManager.getStackTraceValue((Exception) ite.getCause()));
			} else {
				fe.setExceptionText(String.valueOf(ite));
				fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(ite));
			}
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			fe.setServiceName(aClassName);
			fe.setServiceMethod(aMethodName);
			throw fe;
		} catch (final IllegalAccessException iae) {
			final FwException fe = new FwException(iae);
			fe.setClassID(FwRulesManager.class.getName());
			fe.setMethodID("invokeRule");
			fe.setExceptionText(String.valueOf(iae));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			fe.setServiceName(aClassName);
			fe.setServiceMethod(aMethodName);
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(iae));
			throw fe;
		} catch (final InstantiationException ie) {
			final FwException fe = new FwException(ie);
			fe.setClassID(FwRulesManager.class.getName());
			fe.setMethodID("invokeRule");
			fe.setExceptionText(String.valueOf(ie));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			fe.setServiceName(aClassName);
			fe.setServiceMethod(aMethodName);
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(ie));
			throw fe;
		}
	}

	/**
	 * returns Class object from the cache or ir it creates put's into cache
	 */
	private Class getClass(final String aClassName) {

		try {
			Class clazz = null;
			synchronized (ruleClasses) {
				final Object obj = ruleClasses.get(aClassName);
				if (obj == null) {
					clazz = Class.forName(aClassName);
					ruleClasses.put(aClassName, clazz = Class.forName(aClassName));
				} else {
					clazz = (Class) obj;
				}
			}
			return clazz;
		} catch (final ClassNotFoundException cnfe) {
			final FwException fe = new FwException(cnfe);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("getClass");
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			fe.setExceptionText(String.valueOf(cnfe));
			throw fe;
		}
	}

	/**
	 * returns Method object from the cache or ir it creates put's into cache
	 */
	private Method getMethod(final String aClassName, final String aMethodName) {

		try {
			final Class[] parms = { gov.state.nextgen.access.business.entities.FwTransaction.class };
			Method method = null;

			synchronized (ruleMethods) {
				final Object obj = ruleMethods.get(aClassName);
				if ((obj == null) || (((Map) obj).get(aMethodName) == null)) {
					final Class clazz = (Class) ruleClasses.get(aClassName);
					method = clazz.getMethod(aMethodName, parms);

					if (ruleMethods.get(aClassName) == null) {
						ruleMethods.put(aClassName, new HashMap());
					}
					((Map) ruleMethods.get(aClassName)).put(aMethodName, method);
				} else {
					method = (Method) ((Map) obj).get(aMethodName);
				}
			}
			return method;
		} catch (final NoSuchMethodException nsme) {
			final FwException fe = new FwException(nsme);
			fe.setClassID(FwRulesManager.class.getName());
			fe.setMethodID("getMethod");
			fe.setExceptionText(String.valueOf(nsme));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(nsme));
			throw fe;
		}
	}

	public static boolean areRulesCached() {
		if(rules == null) {
			return false;
		} else if (rules.isEmpty()) {
			return false;
		}
		
		return true;
	}
}