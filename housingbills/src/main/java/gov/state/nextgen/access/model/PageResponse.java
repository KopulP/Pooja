package gov.state.nextgen.access.model;

import java.io.Serializable;
import java.util.List;

import gov.state.nextgen.access.management.messages.FwMessage;

public class PageResponse implements Serializable {

	private static final long serialVersionUID = 160289513113160691L;

	private String currentPageID;
	private String currentPageAction;
	private String nextPageID;
	private String nextPageAction;
	private String previousPageID;
	private List<FwMessage> validationMessages;

	public String getCurrentPageID() {
		return currentPageID;
	}

	public void setCurrentPageID(String currentPageID) {
		this.currentPageID = currentPageID;
	}

	public String getCurrentPageAction() {
		return currentPageAction;
	}

	public void setCurrentPageAction(String currentPageAction) {
		this.currentPageAction = currentPageAction;
	}

	public String getNextPageID() {
		return nextPageID;
	}

	public void setNextPageID(String nextPageID) {
		this.nextPageID = nextPageID;
	}

	public String getNextPageAction() {
		return nextPageAction;
	}

	public void setNextPageAction(String nextPageAction) {
		this.nextPageAction = nextPageAction;
	}

	public List<FwMessage> getValidationMessages() {
		return validationMessages;
	}

	public void setValidationMessages(List<FwMessage> validationMessages) {
		this.validationMessages = validationMessages;
	}

	public String getPreviousPageID() {
		return previousPageID;
	}

	public void setPreviousPageID(String previousPageID) {
		this.previousPageID = previousPageID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentPageAction == null) ? 0 : currentPageAction.hashCode());
		result = prime * result + ((currentPageID == null) ? 0 : currentPageID.hashCode());
		result = prime * result + ((nextPageAction == null) ? 0 : nextPageAction.hashCode());
		result = prime * result + ((nextPageID == null) ? 0 : nextPageID.hashCode());
		result = prime * result + ((validationMessages == null) ? 0 : validationMessages.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PageResponse other = (PageResponse) obj;
		if (currentPageAction == null) {
			if (other.currentPageAction != null)
				return false;
		} else if (!currentPageAction.equals(other.currentPageAction))
			return false;
		if (currentPageID == null) {
			if (other.currentPageID != null)
				return false;
		} else if (!currentPageID.equals(other.currentPageID))
			return false;
		if (nextPageAction == null) {
			if (other.nextPageAction != null)
				return false;
		} else if (!nextPageAction.equals(other.nextPageAction))
			return false;
		if (nextPageID == null) {
			if (other.nextPageID != null)
				return false;
		} else if (!nextPageID.equals(other.nextPageID))
			return false;
		if (validationMessages == null) {
			if (other.validationMessages != null)
				return false;
		} else if (!validationMessages.equals(other.validationMessages))
			return false;
		return true;
	}

}
