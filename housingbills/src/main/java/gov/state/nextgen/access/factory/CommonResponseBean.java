package gov.state.nextgen.access.factory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import gov.state.nextgen.access.exceptions.FwException;
import gov.state.nextgen.access.management.constants.FwConstants;

public abstract class CommonResponseBean implements LogicResponseBean {

	/**
	 * This method converts the format of the Date MM/dd/yyyy received from ejb
	 * layer to UI Accepted date format yyyy-MM-dd.
	 * 
	 * @param dateRecieved
	 * @return
	 */
	protected String convertDateToUIAcceptedFormat(String dateRecieved) {

		Date date = null;
		DateFormat dateFormatRecieved = null;
		DateFormat dateFormatReturned = null;

		// contains timestamp
		if (dateRecieved!= null && dateRecieved.length() > 10) {

			dateFormatRecieved = new SimpleDateFormat(FwConstants.UI_DATE_FORMAT_WITH_TIMESTAMP);
			dateFormatReturned = new SimpleDateFormat(FwConstants.UI_DATE_FORMAT_WITHOUT_TIMESTAMP);

			try {

				date = dateFormatRecieved.parse(dateRecieved);

			} catch (ParseException e) {

				FwException fwException = new FwException(e);
				throw fwException;
			}

			dateRecieved = dateFormatReturned.format(date);
		}

		return dateRecieved;

	}

}
