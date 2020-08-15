package gov.state.nextgen.access.business.rules;

/*
 * 
 */

import gov.state.nextgen.access.management.util.AppValidationManager;
import gov.state.nextgen.access.management.util.DateRoutine;
import gov.state.nextgen.access.management.util.Formatter;
import gov.state.nextgen.access.management.util.IValidation;
import gov.state.nextgen.access.business.entities.AbstractCargo;
import gov.state.nextgen.access.business.entities.AbstractCollection;
import gov.state.nextgen.access.business.entities.ICargo;
import gov.state.nextgen.access.business.entities.IPrimaryKey;
import gov.state.nextgen.access.exceptions.FwException;
import gov.state.nextgen.access.exceptions.FwExceptionManager;
import gov.state.nextgen.access.exceptions.FwWrappedException;
import gov.state.nextgen.access.exceptions.IException;
import gov.state.nextgen.access.factories.FwServiceFactory;
import gov.state.nextgen.access.management.configuration.IConfiguration;
import gov.state.nextgen.access.management.constants.FwConstants;
import gov.state.nextgen.access.management.logging.ILog;
import gov.state.nextgen.access.management.messages.FwMessage;
import gov.state.nextgen.access.management.messages.FwMessageList;
import gov.state.nextgen.access.management.util.FwDate;
import gov.state.nextgen.access.persistence.management.IData;
import gov.state.nextgen.access.persistence.management.IDataBatch;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Enter the description of the class
 *
 * @author Architecture Team
 * Creation Date Apr 1, 2004 Modified By: Modified on: PCR#
 */
@Service
public abstract class AbstractBO {

	private FwMessageList messageList = new FwMessageList();
	protected IValidation appMgr = null;
	private ILog logger = null;
	protected Formatter displayFormatter = null;
	protected DateRoutine dateRoutine = null;
	protected FwDate fwDate = null;
	private String batchID = null;
	
	@Autowired
	FwMessage message;

	/**
	 * Default Constructor, Create the AppValidationManager
	 *
	 * @see java.lang.Object#Object()
	 */
	public AbstractBO() {
		appMgr = (AppValidationManager) FwServiceFactory.getInstance().create(IValidation.class);
		displayFormatter = Formatter.getInstance();
		dateRoutine = DateRoutine.getInstance();
		fwDate = FwDate.getInstance();
	}

	/**
	 * Creates error messageslist instance
	 *
	 * Creation Date Apr 1, 2004
	 *
	 */
	private void createMessageList() {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "AbstractBO.createMessageList() - START");
		if (messageList == null) {
			messageList = new FwMessageList();
		}
		log(ILog.INFO, "AbstractBO.createMessageList() - END , Time Taken : " + (System.currentTimeMillis() - startTime) + " milliseconds");
	}

	/**
	 * Populates error messages
	 *
	 * @param messageCode code
	 * @param elementId id
	 * @param messageFieldValue field value
	 *
	 * Creation Date Apr 1, 2004
	 */
	public void addMessage(final String messageCode, final String[] elementId, final Object[] messageFieldValue) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "AbstractBO.addMessage() - START");
		createMessageList();
		final FwMessage message = new FwMessage();
		message.addMsgCdElemIdMsgFieldVal(messageCode, elementId, messageFieldValue);
		messageList.addMessageToList(message);
		log(ILog.INFO, "AbstractBO.addMessage() - END , Time Taken : " + (System.currentTimeMillis() - startTime) + " milliseconds");
	}

	/**
	 * Populates error messages
	 *
	 * 
	 * @param messageCode code
	 * @param elementId id
	 * 
	 * Creation Date Apr 1, 2004
	 */
	public void addMessageWithElementIds(final String messageCode, final String[] elementId) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "AbstractBO.addMessageWithElementIds() - START");
		createMessageList();
		final FwMessage message = new FwMessage();
		message.addMessageWithElementIds(messageCode, elementId);
		messageList.addMessageToList(message);
		log(ILog.INFO, "AbstractBO.addMessageWithElementIds() - END , Time Taken : " + (System.currentTimeMillis() - startTime) + " milliseconds");
	}

	/**
	 * Populates error messages
	 * 
	 * @param messageCode code
	 * @param messageFieldValue field value
	 * 
	 *  Creation Date Apr 1, 2004
	 */
	public void addMessageWithFieldValues(final String messageCode, final Object[] messageFieldValue) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "AbstractBO.addMessageWithFieldValues() - START");
		createMessageList();
		final FwMessage message = new FwMessage();
		message.addMessageWithFieldValues(messageCode, messageFieldValue);
		messageList.addMessageToList(message);
		log(ILog.INFO, "AbstractBO.addMessageWithElementIds() - END , Time Taken : " + (System.currentTimeMillis() - startTime) + " milliseconds");
	}

	/**
	 * Populates error messages
	 *
	 * @param message
	 * 
	 * Creation Date Apr 1, 2004
	 */
	public void addMessage(final String message) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "AbstractBO.addMessage() - START");
		createMessageList();
		final FwMessage msg = new FwMessage();
		msg.addMessage(message);
		messageList.addMessageToList(msg);
		log(ILog.INFO, "AbstractBO.addMessage() - END , Time Taken : " + (System.currentTimeMillis() - startTime) + " milliseconds");
	}

	/**
	 * Populates error messages
	 *
	 * @param messageCode
	 * Creation Date Apr 1, 2004
	 */
	public void addMessageCode(final String messageCode) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "AbstractBO.addMessageCode() - START");
		createMessageList();
		//final FwMessage message = new FwMessage();
		message.addMessageCode(messageCode);
		messageList.addMessageToList(message);
		log(ILog.INFO, "AbstractBO.addMessageCode() - END , Time Taken : " + (System.currentTimeMillis() - startTime) + " milliseconds");
	}
	
	/**
	 * Populates error messages
	 * 
	 * @param validationResult result 
	 * @param messageCode code
	 * @param elementId element identifier
	 * @param messageFieldValue arrays of message value
	 *
	 * Creation Date Apr 1, 2004
	 */
	public void addMessage(final boolean validationResult, final String messageCode, final String[] elementId, final Object[] messageFieldValue) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "AbstractBO.addMessage() - START");
		if (!validationResult) {
			addMessage(messageCode, elementId, messageFieldValue);
		}

		log(ILog.INFO, "AbstractBO.addMessage() - END , Time Taken : " + (System.currentTimeMillis() - startTime) + " milliseconds");
	}

	/**
	 * Populates error messages
	 * 
	 * @param validationResult result
	 * @param messageCode code
	 * @param messageFieldValue array of message values
	 * 
	 * Creation Date Apr 1, 2004
	 */
	public void addMessageWithFieldValues(final boolean validationResult, final String messageCode, final Object[] messageFieldValue) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "AbstractBO.addMessageWithFieldValues() - START");
		if (!validationResult) {
			addMessageWithFieldValues(messageCode, messageFieldValue);
		}
		log(ILog.INFO, "AbstractBO.addMessageWithFieldValues() - END , Time Taken : " + (System.currentTimeMillis() - startTime) + " milliseconds");
	}

	/**
	 * Populates error messages
	 * 
	 * @param validationResult result of validation
	 * @param messageCode message code
	 * @param elementId array of elements identifiers.
	 * 
	 * Creation Date Apr 1, 2004
	 */
	public void addMessageWithElementIds(final boolean validationResult, final String messageCode, final String[] elementId) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "AbstractBO.addMessageWithElementIds() - START");
		if (!validationResult) {
			addMessageWithElementIds(messageCode, elementId);
		}
		log(ILog.INFO, "AbstractBO.addMessageWithElementIds() - END , Time Taken : " + (System.currentTimeMillis() - startTime) + " milliseconds");
	}

	/**
	 * Populates error messages
	 *
	 * Creation Date Apr 1, 2004
	 * @param validationResult result of validation
	 * @param messageCode code
	 */
	public void addMessage(final boolean validationResult, final String messageCode) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "AbstractBO.addMessage() - START");
		if (!validationResult) {
			addMessage(messageCode);
		}
		log(ILog.INFO, "AbstractBO.addMessage() - END , Time Taken : " + (System.currentTimeMillis() - startTime) + " milliseconds");
	}

	/**
	 * Gets error messages
	 * @return List of error messages.
	 * Creation Date Apr 1, 2004
	 */
	public FwMessageList getMessageList() {

		return messageList;
	}

	/**
	 * Checks for error messages
	 * @return indicates if list has messages.
	 * Creation Date Apr 1, 2004
	 */
	public boolean hasMessages() {

		if (messageList == null) {
			return false;
		} else {
			return messageList.hasMessages();
		}
	}

	/**
	 * executes the given sql and returns the result as a list
	 * @param aData query criteria
	 * @return query result 
	 * @throws FwException framework exception
	 */
	public List executeSQL(final Map aData) throws FwException {

		// get the IData using service factory
		final IData data = (IData) FwServiceFactory.getInstance().create(IData.class);
		return data.execute(FwConstants.SQL, aData);
	}

	/**
	 * executes the given sql and returns the result as a list
	 * @param aData query criteria
	 * @return query result 
	 * @throws FwException framework exception
	 */
	public List executeSQLBatch(final Map aData) throws FwException {

		// get the IDataBatch using service factory
		final IDataBatch datamanager = (IDataBatch) FwServiceFactory.getInstance().create(IDataBatch.class);
		return datamanager.execute(FwConstants.SQL, aData);
	}

	/**
	 * returns AfterCargo and dirty is true if cargo's are different. Creation
	 * date: (06/03/2004 12:00:00 AM)
	 *
	 * @param aBeforeCargo
	 *            ICargo
	 * @param aAfterCargo
	 *            ICargo
	 * @return ICargo
	 */
	protected ICargo isChanged(final ICargo aBeforeCargo, final ICargo aAfterCargo) throws FwException {

		if (aBeforeCargo == aAfterCargo) {
			aAfterCargo.setDirty(false);
		} else {
			/*aAfterCargo.setDirty((aBeforeCargo == null) ? ((aAfterCargo == null) ? false : true) : (aAfterCargo == null) ? true : (aBeforeCargo
					.hashCode() != aAfterCargo.hashCode()));*/
			if(null != aAfterCargo){
				if((aBeforeCargo==null) || (aBeforeCargo.hashCode() != aAfterCargo.hashCode())){
					aAfterCargo.setDirty(true);
				}					
				else aAfterCargo.setDirty(false);	
			}
		}
		return aAfterCargo;
	}

	/**
	 * returns AfterCargo and dirty is true if cargo's are different. Creation
	 * date: (06/03/2004 12:00:00 AM)
     *
	 * @param aBeforeCollection input collection
	 * @param aAfterCollection input collection
	 * @return Collection final collection
	 */
	protected Collection isChanged(final Collection aBeforeCollection, final Collection aAfterCollection) {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "AbstractBO.isChanged() - START");

		final AbstractCollection aBeforeColl = (AbstractCollection) aBeforeCollection;
		final AbstractCollection aAfterColl = (AbstractCollection) aAfterCollection;
		if (aAfterColl != null) {
			final ICargo[] afterArray = new AbstractCargo[aAfterColl.size()];
			aAfterColl.toArray(afterArray);
			if (aBeforeColl != null) {
				final ICargo[] beforeArray = new AbstractCargo[aBeforeColl.size()];
				aBeforeColl.toArray(beforeArray);
				outer: for (int i = 0; i < afterArray.length; i++) {
					final IPrimaryKey key = afterArray[i].getPrimaryKey();
					for (int j = 0; j < beforeArray.length; j++) {
						final IPrimaryKey beforeKey = beforeArray[j].getPrimaryKey();
						if (key.hashCode() == beforeKey.hashCode()) {
							afterArray[i] = isChanged(beforeArray[j], afterArray[i]);
							continue outer;
						}
					}
					afterArray[i].setDirty(true);
				}
			} else {
				for (int k = 0; k < afterArray.length; k++) {
					afterArray[k].setDirty(true);
				}
			}
			aAfterColl.clear();
			for (int p = 0; p < afterArray.length; p++) {
				aAfterColl.add(afterArray[p]);
			}
		}

		log(ILog.INFO, "AbstractBO.isChanged() - END , Time Taken : " + (System.currentTimeMillis() - startTime) + " milliseconds");
		return aAfterColl;
	}

	protected void log(final int level, final String message) {
		if (logger == null) {
			logger = (ILog) FwServiceFactory.getInstance().create(ILog.class);
		}
		logger.log(this.getClass(), level, message);
	}
	protected void log(final int level,final Throwable e) {
		if (logger == null) {
			logger = (ILog) FwServiceFactory.getInstance().create(ILog.class);
		}
		logger.log(this.getClass(), level, e);
	}

	/**
	 * creates a new FwException with the given class name, method name and
	 * exception 
	 * 
	 * @param className class name
	 * @param methodName method name
	 * @param e exception
	 * @return Framework exception
	 * 
	 * Creation Date: 02/28/2005
	 */
	public static FwException createFwException(final String className, final String methodName, final Exception e) {
		final FwException fe = FwExceptionManager.createFwException(className, methodName, e);
		return fe;
	}

	/**
	 * This method transforms the given xml string using xslt and returns an
	 * output xml string 
	 * @param aInputXMLStr input XML.
	 * @param aXSLTFileName XSLT file name
	 * @return transformed XML
	 * Creation date: Jan 14, 2006
	 */
	protected String performXSLTTransformation(final String aInputXMLStr, final String aXSLTFileName) {
		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "AbstractBO.performXSLTTransformation() - START");
		try {
			final IConfiguration configuration = (IConfiguration) FwServiceFactory.getInstance().create(IConfiguration.class);
			final String folderLoc = configuration.getEnvironmentProperty(FwConstants.XSLT_FOLDER);
			final TransformerFactory tf = TransformerFactory.newInstance();
			final Transformer trfmr = tf.newTransformer(new StreamSource(folderLoc + aXSLTFileName));
			final StringWriter strW = new StringWriter();
			final byte[] bArray = aInputXMLStr.getBytes();
			final InputStream is = new ByteArrayInputStream(bArray);
			final Source src = new StreamSource(is);
			trfmr.transform(src, new StreamResult(strW));

			log(ILog.INFO, "AbstractBO.performXSLTTransformation() - END , Time Taken : " + (System.currentTimeMillis() - startTime)
					+ " milliseconds");
			return strW.toString();
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), "performXSLTTransformation", e);
		}
	}

	/**
	 * Compute Check Digit 
	 * @param sNum number to check
	 * @return digit
	 * Creation Date:Date Jun 18, 2004
	 */
	public long computeCheckDigit(final String sNum) {

		final long startTime = System.currentTimeMillis();
		log(ILog.INFO, "AbstractBO.computeCheckDigit() - START");
		log(ILog.INFO, "computeCheckDigit::Start");
		final String method = "computeCheckDigit";
		long aNum1 = 1;
		int qty = 0;
		int qty1 = 0;
		int rem = 0;
		String lastDigit;
		final int size = sNum.length();
		final int j = size + 1;

		try {

			for (int i = 0; i < size; i++) {
				qty = qty + (Short.parseShort(sNum.substring(i, i + 1)) * (j - i));
			}

			rem = qty % 11;
			qty1 = 11 - rem;

			// Remove the first digit
			if (qty1 == 10) {
				qty1 = 0;
			} else if (qty1 == 11) {
				qty1 = 1;
			}
			lastDigit = String.valueOf(qty1);
			if (lastDigit.length() > 9) {
				log(ILog.INFO, "AbstractBO.computeCheckDigit() - Raising FwException manually on a condition");
				final FwException fe = new FwException("Message Code : FW047");
				fe.setClassID(this.getClass().getName());
				fe.setMethodID(method);
				fe.setMessageCode("FW047");
				fe.setServiceDescription("Last Digit is: " + lastDigit);
				fe.setExceptionType(FwConstants.EXP_TYP_APPLICATION);
				throw fe;
			}
			aNum1 = Long.parseLong(sNum + lastDigit);
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			throw createFwException(this.getClass().getName(), method, e);
		}
		log(ILog.INFO, "computeCheckDigit::End");

		log(ILog.INFO, "AbstractBO.computeCheckDigit() - END , Time Taken : " + (System.currentTimeMillis() - startTime) + " milliseconds");
		return aNum1;
	}

	/**
	 * @return Returns the batchID.
	 */
	public String getBatchID() {
		return batchID;
	}

	/**
	 * @param batchID
	 *            The batchID to set.
	 */
	public void setBatchID(final String batchID) {
		this.batchID = batchID;
	}
	public FwException exceptionManagerLog(Exception e, String className,
			String methodName) {
		FwException fe = null;
		if (!(e instanceof FwException)) {
			fe = FwExceptionManager.createFwException(className, methodName, e);
		} else {
			fe = (FwException) e;
		}
		final FwWrappedException we = new FwWrappedException(fe);
		we.setCallingClassID(Thread.currentThread().getClass().getName());
		we.setCallingMethodID(methodName);
		we.setFwException(fe);
		final FwExceptionManager exceptionMagr = (FwExceptionManager) FwServiceFactory
				.getInstance().create(IException.class);
		exceptionMagr.log(we);
		return fe;
	}
	
	/**
	 * Returns the last day of next month.
	 * @return last day of next month.
	 */
	public Date getNxtMnthlastDt(){
		Calendar calendar = Calendar.getInstance();         
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return calendar.getTime();
	}
}

