/*
 * 
 */
package gov.state.nextgen.access.driver.business.entities;


import java.util.ArrayList;
import java.util.List;

/**
 * This class <code>MessageRecord</code> is populated and used in Presentation
 * layer to display confirmation and information messages Creation date:
 * (5/25/2001 2:43:53 PM)
 *
 * @author: Gajendra Prasad
 * @version %Revision%
 * @author Deloitte
 */
public class MessageRecord implements java.io.Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Field codes.
	 */
	protected List codes = new ArrayList();
	/**
	 * Field messages.
	 */
	protected List messages = new ArrayList();

	/**
	 * constructor comment.
	 */
	public MessageRecord() {
		super();
	}

	/**
	 * This method returns the first message code.
	 *
	 * @return String
	 */
	public String getCode() {
		if ((codes != null) && (codes.size() > 0)) {
			return ((String) codes.get(0));
		} else {
			return "Code Not Populated";
		}
	}

	/**
	 * This method returns the message code requested by index.
	 *
	 * @param ind
	 *            int
	 * @return String
	 */
	public String getCode(final int ind) {
		if ((codes != null) && (codes.size() > 0) && (ind >= 0) && (ind < codes.size())) {
			final String val = (String) codes.get(ind);

			return val;
		} else {
			return "Code Not Populated";
		}
	}

	/**
	 * This method gets the first message out of list of messages.
	 *
	 * @return String
	 */
	public String getMessage() {
		if ((messages != null) && (messages.size() > 0)) {
			return ((String) messages.get(0));
		} else {
			return "Message Not Populated";
		}
	}

	/**
	 * This message returns the messages requested by index.
	 *
	 * @param ind
	 *            int
	 * @return String
	 */
	public String getMessage(final int ind) {
		if ((messages != null) && (messages.size() > 0) && (ind >= 0) && (ind < messages.size())) {
			return ((String) messages.get(ind));
		} else {
			return "Message Not Populated";
		}
	}

	/**
	 * This method returns all the message codes
	 *
	 * @return ArrayList
	 */
	public List getCodes() {
		return codes;
	}

	/**
	 * This method returns all the messages
	 *
	 * @return ArrayList
	 */
	public List getMessages() {
		return messages;
	}

	/**
	 * This method returns the count of messages
	 *
	 * @return int
	 */
	public int getCount() {
		int result = 0;
		final List _codes = getCodes();
		if ((_codes != null) && (_codes.size() > 0)) {
			result = _codes.size();
		}
		return result;
	}

	/**
	 * This method sets the messagecode at the index specified
	 *
	 * @param ind
	 *            int
	 * @param code
	 *            String
	 */
	public void setCode(final int ind, final String code) {
		codes.add(ind, code);
	}

	/**
	 * This method sets the message code at the start of message list
	 *
	 * @param code
	 *            String
	 */
	public void setCode(final String code) {
		codes.add(0, code);
	}

	/**
	 * This message sets the message at the position of the message specified
	 *
	 * @param ind
	 *            int
	 * @param mess
	 *            String
	 */
	public void setMessage(final int ind, final String mess) {
		messages.add(ind, mess);
	}

	/**
	 * This method sets the message at the start of message list.
	 *
	 * @param mess
	 *            String
	 */
	public void setMessage(final String mess) {
		messages.add(0, mess);
	}

	/**
	 * This method sets the message codes.
	 *
	 * @param aCodes
	 *            ArrayList
	 */
	public void setCodes(final List aCodes) {
		codes = aCodes;
	}

	/**
	 * This method sets the messages.
	 *
	 * @param aMessages
	 *            ArrayList
	 */
	public void setMessages(final List aMessages) {
		messages = aMessages;
	}
}