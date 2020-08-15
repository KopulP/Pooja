/*
 * 
 */
package gov.state.nextgen.access.business.validations;

import java.util.ArrayList;
import java.util.HashMap;
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
 * @author marquju
 *
 */
public abstract class FwAbstractComponentManager implements IComponent {

	protected static Map pageComp = new HashMap(); // page comp cache

	protected static void cachePageComponents() {
		final IData data = (IData) FwServiceFactory.getInstance().create(IData.class);
		final FwDataCriteria[] criteria = new FwDataCriteria[0];

		try {
			// cache the PAGE_CPNT table
			final Map pageCompCriteria = new HashMap();
			pageCompCriteria.put(FwConstants.SQL_IND, "sql-Q1");
			pageCompCriteria.put(FwConstants.CRITERIA, criteria);
			final List pageCompList = data.execute(FwConstants.SQL, pageCompCriteria);
			String pageId = null;
			String nextPageId = null;
			String compId = null;
			List compList = new ArrayList();
			for (int i = 0; i < pageCompList.size(); i++) {
				final Map row = (Map) pageCompList.get(i);
				nextPageId = (String) row.get(PAGE_ID);
				compId = (String) row.get(CPNT_ID);
				if (pageId == null) {
					pageId = nextPageId;
				}
				if (!nextPageId.equals(pageId)) {
					pageComp.put(pageId, compList);
					compList = new ArrayList();
					pageId = nextPageId;
				}
				compList.add(compId);
			}
			pageComp.put(pageId, compList); // the last row added at the end

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(FwAbstractComponentManager.class.toString());
			fe.setMethodID("cacheComponents");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	protected List getComponentsforPageId(final String aPageID) {
		final List result = new ArrayList();
		try {
			if (pageComp.get(aPageID) != null) {
				result.addAll((List) pageComp.get(aPageID));
				return result;
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(FwAbstractComponentManager.class.toString());
			fe.setMethodID("getComponents");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
		return result;
	}

	protected static void runComponentRules(final List componentIds, final FwTransaction aTxnBean) {
		FwRulesManager.getInstance().runRulesForComponents(componentIds, aTxnBean);
	}

}
