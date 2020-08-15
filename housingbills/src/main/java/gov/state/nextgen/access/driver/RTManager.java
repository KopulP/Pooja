/**
 *
 */
package gov.state.nextgen.access.driver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gov.state.nextgen.access.business.entities.AbstractCargo;
import gov.state.nextgen.access.exceptions.FwException;
import gov.state.nextgen.access.exceptions.FwExceptionManager;
import gov.state.nextgen.access.factories.FwServiceFactory;
import gov.state.nextgen.access.management.configuration.IConfiguration;
import gov.state.nextgen.access.management.constants.FwConstants;
import gov.state.nextgen.access.management.logging.ILog;
import gov.state.nextgen.access.persistence.management.IData;

/**
 * @author sanem
 *
 */
public final class RTManager implements Cloneable {

	IConfiguration configuration = (IConfiguration) FwServiceFactory.getInstance().create(IConfiguration.class);
	private IData dataManager = null;
	private Map<String, String> cpReturnMap = null;
	private Map<String, String> wpReturnMap = null;
	private static RTManager rtManager = null;

	/**
	 * Constructor for RTManager.
	 */
	private RTManager() {
		dataManager = (IData) FwServiceFactory.getInstance().create(IData.class);
		loadRTMapping();
	}

	private final ILog logger = (ILog) FwServiceFactory.getInstance().create(ILog.class);

	public static RTManager getInstance() {

		if (rtManager == null) {
			rtManager = new RTManager();
		}
		return rtManager;
	}

	/**
	 * @param args
	 */
	private void loadRTMapping() {

		logger.log(this.getClass(), ILog.DEBUG, "loadRTMapping - START");

		try {
			cpReturnMap = new HashMap<>();
			wpReturnMap = new HashMap<>();
			final Map criteria = new HashMap();
			criteria.put(FwConstants.SQL_IND, "framework-06");
			final List result = dataManager.execute(FwConstants.SQL, criteria);

			for (int i = 0; i < result.size(); i++) {

				final Map row = (Map) result.get(i);
				final String cargoName = (String) row.get("CARGO_NAME");
				final String cpRTValue = (String) row.get("CP_RT_VALUE");
				final String wpRTValue = (String) row.get("EXT_RT_VALUE");
				cpReturnMap.put(cargoName.trim() + "_" + cpRTValue, wpRTValue);
				wpReturnMap.put(cargoName.trim() + "_" + wpRTValue, cpRTValue);
			}

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = new FwException(e);
			fe.setClassID(this.getClass().getName());
			fe.setMethodID("loadRTMapping");
			fe.setStackTraceValue(FwExceptionManager.getStackTraceValue(e));
			fe.setExceptionText(String.valueOf(e));
			fe.setExceptionType(FwConstants.EXP_TYP_FRAMEWORK);
			throw fe;
		}

		logger.log(this.getClass(), ILog.DEBUG, "loadRTMapping - END");
	}

	private String getRTValue(final Class<? extends AbstractCargo> cargoClass, final String keyRTValue, final boolean cpflag) {
		String value = null;
		if ((cpReturnMap == null) || (wpReturnMap == null)) {
			loadRTMapping();
		} else {
			final String className = cargoClass.getSimpleName();
			final String key = className + "_" + keyRTValue;
			if (cpflag) {
				//to get Customer Portal values use wpReturnMap
				value = wpReturnMap.get(key);
			} else {
				//to get Worker Portal values use cpReturnMap
				value = cpReturnMap.get(key);
			}
			logger.log(this.getClass(), ILog.INFO, "MAPPING KEY : " + key + " value:" + value);
		}
		if (null == value) {
			logger.log(this.getClass(), ILog.INFO, "NO MAPPING FOUND FOR - key : " + keyRTValue + " value:" + value + ": returning key as value..");
			value = keyRTValue;
		}

		return value;
	}

	/**
	 * 
	 * @param cargoClass
	 * @param extRTValue
	 * @return
	 */
	public String getCPRTValue(final Class<? extends AbstractCargo> cargoClass, final String extRTValue) {
		return getRTValue(cargoClass, extRTValue, true);
	}

	/**
	 * 
	 * @param cargoClass
	 * @param cpRTValue
	 * @return
	 */
	public String getEXTRTValue(final Class<? extends AbstractCargo> cargoClass, final String cpRTValue) {
		return getRTValue(cargoClass, cpRTValue, false);
	}

	public void refresh() {
		loadRTMapping();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected RTManager clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}
