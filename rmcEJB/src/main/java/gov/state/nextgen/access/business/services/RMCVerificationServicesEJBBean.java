/*
 *
 */
package gov.state.nextgen.access.business.services;

import gov.state.nextgen.access.business.rules.RMBReceiveWebServiceBO;
import gov.state.nextgen.access.management.constants.AppConstants;
import gov.state.nextgen.framework.business.entities.FwTransaction;
import gov.state.nextgen.framework.exceptions.FwException;
import gov.state.nextgen.framework.exceptions.FwWrappedException;
import gov.state.nextgen.framework.management.logging.ILog;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

/**
 * The Class RMCVerificationServicesEJBBean.
 */
@javax.ejb.Stateless
@javax.ejb.LocalBean
@javax.ejb.TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class RMCVerificationServicesEJBBean extends
BeanManagedTxnSessionBeanEjb3 {

	/** The my session ctx. */
	@Resource
	private javax.ejb.SessionContext mySessionCtx;

	/**
	 * Instantiates a new RMC verification services ejb bean.
	 */
	public RMCVerificationServicesEJBBean() {
	}
	
	/**
	 * Gets the my session ctx.
	 *
	 * @return the mySessionCtx
	 */
	public javax.ejb.SessionContext getMySessionCtx() {
		return mySessionCtx;
	}

	/**
	 * Sets the my session ctx.
	 *
	 * @param mySessionCtx            the mySessionCtx to set
	 */
	public void setMySessionCtx(final javax.ejb.SessionContext mySessionCtx) {
		this.mySessionCtx = mySessionCtx;
	}


	/**
	 * Load work number service.
	 *
	 * @param txnBean the txn bean
	 \* @throws javax.ejb.EJBException the EJB exception
	 */
	public void loadWorkNumberService(final FwTransaction txnBean)
			throws javax.ejb.EJBException {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO,
				"RMCVerificationServicesEJBBean.loadWorkNumberService() - START");

		String appNum = null;
		try {
			log(ILog.INFO,
					"RMCVerificationServicesEJBBean::loadWorkNumberService:Start");
			final Map session = txnBean.getSession();
			List ssnList = new ArrayList();
			List einList = new ArrayList();

			appNum = (String) session.get(AppConstants.APP_NUMBER);

			final RMBReceiveWebServiceBO webServiceBo = new RMBReceiveWebServiceBO();
			ssnList = webServiceBo.getSsnForIndivduals(appNum);

			final int size = ssnList.size();

			for (int i = 0; i < size; i++) {
				ssnList.get(i);

			}
			final Iterator<String> ssnIterator = ssnList.iterator();

			while (ssnIterator.hasNext()) {
				final String ssn = ssnIterator.next();
				webServiceBo.getFullEmployerHistory(txnBean,
						AppConstants.TRNUID, AppConstants.TRNPURPOSE, ssn);

				einList = webServiceBo.getEinForIndividuals(appNum, ssn);

				final Iterator<String> einIterator = einList.iterator();

				while (einIterator.hasNext()) {
					final String eiNum = einIterator.next();
					webServiceBo.getFullEmployerDetails(txnBean,
							AppConstants.TRNUID, AppConstants.TRNPURPOSE, ssn,
							eiNum);
				}
			}

			log(ILog.INFO,
					"RMCVerificationServicesEJBBean::loadWorkNumberService:End");
		} catch (final FwException fe) {
			javaTransactionFailure();
			final FwWrappedException we = new FwWrappedException(fe);
			we.setCallingClassID(this.getClass().getName());
			we.setCallingMethodID("loadWorkNumberService");
			we.setFwException(fe);
			throw exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (final Exception e) {
			javaTransactionFailure();
			final FwException fe = createFwException(this.getClass().getName(),
					"loadWorkNumberService", e);
			throw exceptionManagerLog(fe, getClass().getName(), Thread.currentThread().getStackTrace()[2].getMethodName());
		}

		log(ILog.INFO,
				"RMCVerificationServicesEJBBean.loadWorkNumberService() - END , Time Taken : "
						+ (System.currentTimeMillis() - startTime)
						+ " milliseconds");

	}
}
