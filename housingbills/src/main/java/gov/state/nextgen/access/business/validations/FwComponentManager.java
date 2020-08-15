/*
 * 
 */
package gov.state.nextgen.access.business.validations;

import java.util.ArrayList;
import java.util.HashMap;
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
 * Singleton class manages Components
 *
 * @author Architecture Team Creation Date Oct 26, 2005 Modified By: Modified
 *         on: PCR#
 */
public class FwComponentManager extends FwAbstractComponentManager {

	private static final IComponent componentManager = new FwComponentManager();
	private static Map<String, int[]> components = new HashMap<>(); // components cache

	/**
	 * returns IComponent
	 */
	public static IComponent getInstance() {
		// METHOD DOES NOT NEED TO BE SYNCHRONIZED AS INSTANCE IS OBTAINED
		// STATICALLY IN CLASS DECLARATION
		// DO NOT MODIFY CODE TO MAKE METHOD SYNCHRONIZED OR USE DOUBLE-LOCKING
		// AS DOUBLE-LOCKING IS NOT THREAD-SAFE CURRENTLY
		return componentManager;
	}

	/**
	 * @see gov.state.nextgen.framework.management.questions.IComponent#cacheComponents()
	 */
	public static void cacheComponents() {

		if ((pageComp == null) || pageComp.isEmpty()) {
			cachePageComponents();
		}

		final IData data = (IData) FwServiceFactory.getInstance().create(IData.class);
		final FwDataCriteria[] criteria = new FwDataCriteria[0];

		try {
			// cache the CPNT_DTL table
			final Map compCriteria = new HashMap();
			compCriteria.put(FwConstants.SQL_IND, "sql-Q2");
			compCriteria.put(FwConstants.CRITERIA, criteria);
			final List compIdList = data.execute(FwConstants.SQL, compCriteria);
			String cpntId = null;
			for (int i = 0, size=compIdList.size(); i < size; i++) {
				final Map row = (Map) compIdList.get(i);
				cpntId = (String) row.get(CPNT_ID);

				// EDSP Start - adding more programs to programkey array
				final int[] prgramDispKey = new int[18];

				// EDSP End - adding more programs to programkey array

				prgramDispKey[0] = Integer.parseInt((String) row.get(MA_IND));
				prgramDispKey[1] = Integer.parseInt((String) row.get(FPW_IND));
				prgramDispKey[2] = Integer.parseInt((String) row.get(FS_IND));
				prgramDispKey[3] = Integer.parseInt((String) row.get(FS_RR_IND));
				prgramDispKey[4] = Integer.parseInt((String) row.get(MA_EBD_IND));
				prgramDispKey[5] = Integer.parseInt((String) row.get(SER_IND));
				prgramDispKey[6] = Integer.parseInt((String) row.get(CTS_IND));
				prgramDispKey[7] = Integer.parseInt((String) row.get(SC_IND));
				// VACMS start - converting FS to CC
				prgramDispKey[8] = Integer.parseInt((String) row.get(CC_IND));
				// VACMS end - converting FS to CC
				// EDSP start - adding TANF,EA programs
				prgramDispKey[9] = Integer.parseInt((String) row.get(TANF_IND));
				prgramDispKey[10] = Integer.parseInt((String) row.get(FUEL_ASSISTANCE_IND));
				prgramDispKey[11] = Integer.parseInt((String) row.get(CRISIS_ASSISTANCE_IND));
				prgramDispKey[12] = Integer.parseInt((String) row.get(COOLING_ASSISTANCE_IND));
				prgramDispKey[13] = Integer.parseInt((String) row.get(NO_SNAP_IND));
				prgramDispKey[14] = Integer.parseInt((String) row.get(WIC_RQST_IND));
				prgramDispKey[15] = Integer.parseInt((String) row.get(LIHEAP_RQST_IND));
				prgramDispKey[16] = Integer.parseInt((String) row.get(MAGI_RQST_IND));
				prgramDispKey[17] = Integer.parseInt((String) row.get(PEACH_RQST_IND));
				// EDSP end - adding TANF,EA programs

				components.put(cpntId, prgramDispKey);
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(FwComponentManager.class.toString());
			fe.setMethodID("cacheComponents");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	/**
	 * @see gov.state.nextgen.framework.management.questions.IComponent#getComponents(java.lang.String,
	 *      gov.state.nextgen.framework.business.entities.FwTransaction)
	 * @param aPageID
	 * @param aTxnBean
	 */
	@Override
	public void getComponents(final String aPageID, final FwTransaction aTxnBean) {

		try {
			final List componentIDs = getComponentsforPageId(aPageID);
			if (components != null) {
				runProgramKeyFilter(componentIDs, aPageID, aTxnBean);
				runComponentRules(componentIDs, aTxnBean);
				aTxnBean.getPageCollection().put(FwConstants.PAGE_COMPONENT_LIST, componentIDs);
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(FwComponentManager.class.toString());
			fe.setMethodID("getComponents");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}
	
	/**
	 * @see gov.state.nextgen.framework.management.questions.IComponent#getComponents(java.lang.String,
	 *      gov.state.nextgen.framework.business.entities.FwTransaction)
	 * @param aPageID
	 * @param aTxnBean
	 */
	@Override
	public List getComponentsList(final String aPageID, final FwTransaction aTxnBean) {

		try {
			final List componentIDs = getComponentsforPageId(aPageID);
			if (components != null) {
				runProgramKeyFilter(componentIDs, aPageID, aTxnBean);
				runComponentRules(componentIDs, aTxnBean);
			}
			
			return componentIDs;
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(FwComponentManager.class.toString());
			fe.setMethodID("getComponents");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}


	/**
	 *
	 * @param compList
	 * @param aPageID
	 * @param aTxnBean
	 */
	protected void runProgramKeyFilter(final List compList, final String aPageID, final FwTransaction aTxnBean) {
		short[] programKey = null;

		try {
			if ((aPageID.charAt(0) == 'A') && (aPageID.charAt(1) == 'B')) {
				programKey = (short[]) aTxnBean.getSession().get(FwConstants.AFB_PROGRAM_KEY);
			} else if ((aPageID.charAt(0) == 'A') && (aPageID.charAt(1) == 'R')) {
				programKey = (short[]) aTxnBean.getSession().get(FwConstants.RMC_PROGRAM_KEY);
			}

			if ((programKey != null) && (programKey.length > 0)) {
				final List compIds = new ArrayList(); // creating a copy to loop
				// through
				compIds.addAll(compList);
				boolean removeComponent;
				final Iterator iter = compIds.iterator();
				String compId = null;
				while (iter.hasNext()) {
					removeComponent = true;
					compId = (String) iter.next();
					final int[] pgmDispKey = getProgramDisplayKey(compId);
					if (pgmDispKey != null) {
						for (int i = 0; i < programKey.length; i++) {
							if ((programKey[i] != 0) && (pgmDispKey[i] == 1)) {
								removeComponent = false;
								break;
							}
						}
					} else {
						// Do not remove a component from the list if there was
						// no program key specified for this
						// component.
						removeComponent = false;
					}
					if (removeComponent) {
						compList.remove(compId);
					}
				}
			}
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(FwComponentManager.class.toString());
			fe.setMethodID("runProgramKeyFilter");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}
	}

	/**
	 * returns the programDisplayKey for a given componentId
	 *
	 * @param cpntId
	 * @return int[]
	 */
	private int[] getProgramDisplayKey(final String cpntId) {
		return components.get(cpntId) != null ? (int[]) components.get(cpntId) : null;
	}

	public static boolean areComponentsCached() {
		if (components == null) {
			return false;
		} else if (components.isEmpty()) {
			return false;
		}
		return true;
	}
}
