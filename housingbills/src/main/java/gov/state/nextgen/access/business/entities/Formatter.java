package gov.state.nextgen.access.business.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import gov.state.nextgen.access.driver.FwPageManager;
import gov.state.nextgen.access.driver.IPage;
import gov.state.nextgen.access.management.constants.FwConstants;

/**
 * Management Date Utility.
 *
 * @author: Architecture Team Creation date: 03/28/2006 Modified by: Modified
 *          on: PCR# :
 */

public class Formatter implements Serializable {

	private static final Formatter displayFormatter = new Formatter();

	protected Formatter() {
	}

	public static Formatter getInstance() {
		// METHOD DOES NOT NEED TO BE SYNCHRONIZED AS INSTANCE IS OBTAINED
		// STATICALLY IN CLASS DECLARATION
		// DO NOT MODIFY CODE TO MAKE METHOD SYNCHRONIZED OR USE DOUBLE-LOCKING
		// AS DOUBLE-LOCKING IS NOT THREAD-SAFE CURRENTLY
		return displayFormatter;
	}

	/**
	 * Outputs the given String date in the format Thursday July 7, 2005
	 */
	public String getExpandedDate(final String date, final String language_indicator) {
		return (getExpandedDate(Date.valueOf(date), language_indicator));
	}

	/**
	 * Outputs the given sql date in the format July 7, 2005
	 */
	public String getExpandDate(final Date date, final String language_indicator) {
		String result = "";
		int textID = 0;
		String month = "";
		final IPage page = FwPageManager.createInstance();

		// Get the values for the date, month and year from the given sql date
		final int dt = date.getDate();
		final int mn = date.getMonth();
		int yr = date.getYear();
		yr = 1900 + yr;

		// Get the constant values for the months of the year.
		final Calendar cal1 = new GregorianCalendar(yr, mn, dt);
		final int m = cal1.get(Calendar.MONTH);
		final int jan = Calendar.JANUARY;
		final int feb = Calendar.FEBRUARY;
		final int mar = Calendar.MARCH;
		final int apr = Calendar.APRIL;
		final int may = Calendar.MAY;
		final int jun = Calendar.JUNE;
		final int jul = Calendar.JULY;
		final int aug = Calendar.AUGUST;
		final int sep = Calendar.SEPTEMBER;
		final int oct = Calendar.OCTOBER;
		final int nov = Calendar.NOVEMBER;
		final int dec = Calendar.DECEMBER;

		if (m == jan) {
			textID = 15034;
		} else if (m == feb) {
			textID = 15035;
		} else if (m == mar) {
			textID = 15036;
		} else if (m == apr) {
			textID = 15037;
		} else if (m == may) {
			textID = 15038;
		} else if (m == jun) {
			textID = 15039;
		} else if (m == jul) {
			textID = 15040;
		} else if (m == aug) {
			textID = 15041;
		} else if (m == sep) {
			textID = 15042;
		} else if (m == oct) {
			textID = 15043;
		} else if (m == nov) {
			textID = 15044;
		} else if (m == dec) {
			textID = 15045;
		}

		month = page.getDisplayText(textID, language_indicator);
		result = new StringBuilder/* (day).append(" ").append */(month).append(" ").append(dt).append(",").append(" ").append(yr).toString();
		return result;
	}

	/**
	 * Outputs the given sql date in the format Thursday July 7, 2005
	 */
	public String getExpandedDate(final Date date, final String language_indicator) {
		String result = "";
		int textID = 0;
		String day = "";
		String month = "";
		final IPage page = FwPageManager.createInstance();

		// Get the values for the date, month and year from the given sql date
		final int dt = date.getDate();
		final int mn = date.getMonth();
		int yr = date.getYear();
		yr = 1900 + yr;

		// Get the constant values for the days of the week.
		final Calendar cal = new GregorianCalendar(yr, mn, dt);
		final int d = cal.get(Calendar.DAY_OF_WEEK);
		final int sun = Calendar.SUNDAY;
		final int mon = Calendar.MONDAY;
		final int tue = Calendar.TUESDAY;
		final int wed = Calendar.WEDNESDAY;
		final int thu = Calendar.THURSDAY;
		final int fri = Calendar.FRIDAY;
		final int sat = Calendar.SATURDAY;

		if (d == sun) {
			textID = 15027;
		} else if (d == mon) {
			textID = 15028;
		} else if (d == tue) {
			textID = 15029;
		} else if (d == wed) {
			textID = 15030;
		} else if (d == thu) {
			textID = 15031;
		} else if (d == fri) {
			textID = 15032;
		} else if (d == sat) {
			textID = 15033;
		}

		day = page.getDisplayText(textID, language_indicator);

		// Get the constant values for the months of the year.
		final Calendar cal1 = new GregorianCalendar(yr, mn, dt);
		final int m = cal1.get(Calendar.MONTH);
		final int jan = Calendar.JANUARY;
		final int feb = Calendar.FEBRUARY;
		final int mar = Calendar.MARCH;
		final int apr = Calendar.APRIL;
		final int may = Calendar.MAY;
		final int jun = Calendar.JUNE;
		final int jul = Calendar.JULY;
		final int aug = Calendar.AUGUST;
		final int sep = Calendar.SEPTEMBER;
		final int oct = Calendar.OCTOBER;
		final int nov = Calendar.NOVEMBER;
		final int dec = Calendar.DECEMBER;

		if (m == jan) {
			textID = 15034;
		} else if (m == feb) {
			textID = 15035;
		} else if (m == mar) {
			textID = 15036;
		} else if (m == apr) {
			textID = 15037;
		} else if (m == may) {
			textID = 15038;
		} else if (m == jun) {
			textID = 15039;
		} else if (m == jul) {
			textID = 15040;
		} else if (m == aug) {
			textID = 15041;
		} else if (m == sep) {
			textID = 15042;
		} else if (m == oct) {
			textID = 15043;
		} else if (m == nov) {
			textID = 15044;
		} else if (m == dec) {
			textID = 15045;
		}

		month = page.getDisplayText(textID, language_indicator);
		result = new StringBuilder(day).append(" ").append(month).append(" ").append(dt).append(",").append(" ").append(yr).toString();
		return result;
	}

	/**
	 * Outputs the given sql date in the format yyyy-mm-dd
	 */
	public String getYYYYMMDDDate(final Date date) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}

	/**
	 * Outputs the given sql date in the format mm/dd/yyyy
	 */
	public String getMMDDYYYYDate(final Date date) {

		String result = "";
		// Get the values for the date, month and year from the given sql date
		final int dt = date.getDate();
		final int mn = date.getMonth();
		int yr = date.getYear();
		yr = 1900 + yr;

		result = new StringBuilder().append(mn + 1).append("/").append(dt).append("/").append(yr).toString();
		return result;
	}

	/**
	 * Outputs the given String date "yyyy-mm-dd" in the format mm/dd/yyyy
	 */
	public String getMMDDYYYYDate(String yyyy_mm_dd) {

		String result = "";
		// Get the values for the date, month and year from the given sql date
		yyyy_mm_dd = yyyy_mm_dd.substring(0, 10);
		final String yyyy = yyyy_mm_dd.substring(0, 4);
		final String mm = yyyy_mm_dd.substring(5, 7);
		final String dd = yyyy_mm_dd.substring(8, 10);

		result = new StringBuilder(mm).append("/").append(dd).append("/").append(yyyy).toString();
		return result;
	}

	/**
	 * Outputs the given String date "yyyy-mm" in the format mm/yyyy
	 */
	public String getMMYYYYDate(String yyyy_mm) {

		String result = "";
		// Get the values for the date, month and year from the given sql date
		yyyy_mm = yyyy_mm.substring(0, 7);
		final String yyyy = yyyy_mm.substring(0, 4);
		final String mm = yyyy_mm.substring(5, 7);

		result = new StringBuilder(mm).append("/").append(yyyy).toString();
		return result;
	}

	/**
	 * Outputs the given String date mm/dd/yyyy in the format "yyyy-mm-dd"
	 */
	public String getYYYYMMDDDate(final String mm_dd_yyyy) {

		String result = "";
		// Get the values for the date, month and year from the given sql date
		if ((mm_dd_yyyy.length() == 10) && (mm_dd_yyyy.charAt(2) == '/')) {
			final String yyyy = mm_dd_yyyy.substring(6, 10);
			final String mm = mm_dd_yyyy.substring(0, 2);
			final String dd = mm_dd_yyyy.substring(3, 5);
			result = new StringBuilder(yyyy).append("-").append(mm).append("-").append(dd).toString();
			return result;
		} else {
			return mm_dd_yyyy;
		}

	}

	/**
	 * returns the month of a given date
	 */
	public String getMonthName(final Date date, final String language) {

		// Get the values for the date, month and year from the given sql date
		final int dt = date.getDate();
		final int mn = date.getMonth();
		int yr = date.getYear();
		yr = 1900 + yr;
		int textID = 0;
		final IPage page = FwPageManager.createInstance();
		String month = "";

		// Get the constant values for the months of the year.
		final Calendar cal1 = new GregorianCalendar(yr, mn, dt);
		final int m = cal1.get(Calendar.MONTH);
		final int jan = Calendar.JANUARY;
		final int feb = Calendar.FEBRUARY;
		final int mar = Calendar.MARCH;
		final int apr = Calendar.APRIL;
		final int may = Calendar.MAY;
		final int jun = Calendar.JUNE;
		final int jul = Calendar.JULY;
		final int aug = Calendar.AUGUST;
		final int sep = Calendar.SEPTEMBER;
		final int oct = Calendar.OCTOBER;
		final int nov = Calendar.NOVEMBER;
		final int dec = Calendar.DECEMBER;
		if (m == jan) {
			textID = 15034;
		} else if (m == feb) {
			textID = 15035;
		} else if (m == mar) {
			textID = 15036;
		} else if (m == apr) {
			textID = 15037;
		} else if (m == may) {
			textID = 15038;
		} else if (m == jun) {
			textID = 15039;
		} else if (m == jul) {
			textID = 15040;
		} else if (m == aug) {
			textID = 15041;
		} else if (m == sep) {
			textID = 15042;
		} else if (m == oct) {
			textID = 15043;
		} else if (m == nov) {
			textID = 15044;
		} else if (m == dec) {
			textID = 15045;
		}
		month = page.getDisplayText(textID, language);
		return month;
	}

	/**
	 * Outputs the given sql date in the format Thursday July 7, 2005
	 */
	public String getExpandedMonthYear(final Date date, final String language_indicator) {
		String result = "";
		int textID = 0;
		String month = "";
		final IPage page = FwPageManager.createInstance();

		// Get the values for the date, month and year from the given sql date
		final int dt = date.getDate();
		final int mn = date.getMonth();
		int yr = date.getYear();
		yr = 1900 + yr;

		// Get the constant values for the months of the year.
		final Calendar cal1 = new GregorianCalendar(yr, mn, dt);
		final int m = cal1.get(Calendar.MONTH);
		final int jan = Calendar.JANUARY;
		final int feb = Calendar.FEBRUARY;
		final int mar = Calendar.MARCH;
		final int apr = Calendar.APRIL;
		final int may = Calendar.MAY;
		final int jun = Calendar.JUNE;
		final int jul = Calendar.JULY;
		final int aug = Calendar.AUGUST;
		final int sep = Calendar.SEPTEMBER;
		final int oct = Calendar.OCTOBER;
		final int nov = Calendar.NOVEMBER;
		final int dec = Calendar.DECEMBER;

		if (m == jan) {
			textID = 15034;
		} else if (m == feb) {
			textID = 15035;
		} else if (m == mar) {
			textID = 15036;
		} else if (m == apr) {
			textID = 15037;
		} else if (m == may) {
			textID = 15038;
		} else if (m == jun) {
			textID = 15039;
		} else if (m == jul) {
			textID = 15040;
		} else if (m == aug) {
			textID = 15041;
		} else if (m == sep) {
			textID = 15042;
		} else if (m == oct) {
			textID = 15043;
		} else if (m == nov) {
			textID = 15044;
		} else if (m == dec) {
			textID = 15045;
		}

		month = page.getDisplayText(textID, language_indicator);
		result = new StringBuilder(month).append(" ").append(yr).toString();
		return result;
	}

	// this method weill give the formated phone number
	public String getFormatedPhNumber(final String phoneNumber) {
		final StringBuilder pNumber = new StringBuilder();
		if ((phoneNumber != null) && (phoneNumber.trim().length() == 10)) {
			final String phNum = phoneNumber.trim();
			if (phNum.startsWith("800") || phNum.startsWith("866") || phNum.startsWith("877") || phNum.startsWith("888")) {
				pNumber.append("1-");
				pNumber.append(phNum.substring(0, 3));
				pNumber.append("-");
				pNumber.append(phNum.substring(3, 6));
				pNumber.append("-");
				pNumber.append(phNum.substring(6));
			} else if (phNum.equals("0000000000")) {
				return " ";
			} else {
				pNumber.append("(");
				pNumber.append(phNum.substring(0, 3));
				pNumber.append(") ");
				pNumber.append(phNum.substring(3, 6));
				pNumber.append("-");
				pNumber.append(phNum.substring(6));
			}
		} else if ((phoneNumber != null) && (phoneNumber.trim().length() == 7)) {
			final String phNum = phoneNumber.trim();
			pNumber.append(phNum.substring(0, 3));
			pNumber.append("-");
			pNumber.append(phNum.substring(3));
		}
		return pNumber.toString();
	}

	/**
	 * returns the input String to Curreny format (eg: 40000.00)
	 */
	public String getCurrencyFormat(final String amount) {

		return (java.text.NumberFormat.getCurrencyInstance().format(Double.parseDouble(amount)).substring(1));

	}

	/**
	 * returns the input String to Curreny format (eg: 40000.00)
	 */
	public String getNumberFormat(final String amount) {
		try {
			if ((amount != null) && !amount.trim().isEmpty() && !amount.equals(FwConstants.ON_FILE)) {
				final DecimalFormat dec = new DecimalFormat("0.00");
				return (dec.format(Double.parseDouble(amount)));
			} else {
				return amount;
			}
		} catch (final NumberFormatException e) {
			return amount;
		}
	}

	/**
	 * Given a number, this will build a new String with length maxLength and if
	 * the maxLength is greater than the length of the given string then 0's
	 * will be prepended.
	 *
	 * @param number
	 *            A String which represents an original number
	 * @param maxLength
	 *            A length of the new String
	 * @return A new String with padded 0's
	 */
	public String getStringWithPaddedZeros(String number, final int maxLength) {
		final int numberLength = number.length();
		StringBuilder paddedCase = null;
		if (numberLength < maxLength) {
			paddedCase = new StringBuilder();
			final int counter = maxLength - numberLength;
			for (int m = 0; m < counter; m++) {
				paddedCase.append("0");
			}
			number = paddedCase.append(number).toString();
		}
		return number;
	}

	// Returns a formatted and legible timestamp which looks like- Month, Date
	// Year Hours:Minutes:Seconds A.M./P.M.
	// e.g, July 31, 2006 08:30:22 A.M.
	public String getFormattedTimeStamp(final String timeStamp, final String langInd) {
		final Timestamp ts = Timestamp.valueOf(timeStamp);
		final StringBuilder finalDateStamp = new StringBuilder();
		final int aDate = ts.getDate();
		final int year = ts.getYear() + 1900;
		final int hours = ts.getHours();

		final Date date = new Date(ts.getTime());
		finalDateStamp.append(getMonthName(date, langInd)).append(FwConstants.SPACE).append(aDate).append(FwConstants.COMMA)
		.append(FwConstants.SPACE).append(year).append(FwConstants.SPACE);

		// adding - at
		finalDateStamp.append(FwConstants.AT).append(FwConstants.SPACE);

		String strHour = null;
		String strAMPM = FwConstants.ANTE_MERIDIAN;
		final String min = String.valueOf(ts.getMinutes());

		if (hours >= 12) {
			strHour = (hours == 12) ? "12" : String.valueOf(hours - 12);
			strAMPM = FwConstants.POST_MERIDIAN;
		} else {
			strHour = (hours == 0) ? "12" : String.valueOf(hours);
		}

		if (strHour.length() == 1) {
			finalDateStamp.append(FwConstants.ZERO);
		}
		finalDateStamp.append(strHour).append(":");
		if (min.length() == 1) {
			finalDateStamp.append(FwConstants.ZERO);
		}
		finalDateStamp.append(min);

		finalDateStamp.append(FwConstants.SPACE).append(strAMPM);

		return finalDateStamp.toString();
	}
	
	public String getFormattedTimeStamp(final String timeStamp) {
		final Timestamp ts = Timestamp.valueOf(timeStamp);
		final StringBuilder finalDateStamp = new StringBuilder();
		final int aDate = ts.getDate();
		final int year = ts.getYear() + 1900;
		final int hours = ts.getHours();

		final Date date = new Date(ts.getTime());
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(date);
		 int month = cal.get(Calendar.MONTH);
		finalDateStamp.append(month).append("/").append(aDate).append("/").append(year).append(" ");
		String strHour = null;
		String strAMPM = FwConstants.ANTE_MERIDIAN;
		final String min = String.valueOf(ts.getMinutes());

		if (hours >= 12) {
			strHour = (hours == 12) ? "12" : String.valueOf(hours - 12);
			strAMPM = FwConstants.POST_MERIDIAN;
		} else {
			strHour = (hours == 0) ? "12" : String.valueOf(hours);
		}

		if (strHour.length() == 1) {
			finalDateStamp.append(FwConstants.ZERO);
		}
		finalDateStamp.append(strHour).append(":");
		if (min.length() == 1) {
			finalDateStamp.append(FwConstants.ZERO);
		}
		finalDateStamp.append(min);

		finalDateStamp.append(FwConstants.SPACE).append(strAMPM);

		return finalDateStamp.toString();
	}

	public StringBuilder convertListToStringbuffer(final List list, final String and) {
		final StringBuilder aa = new StringBuilder();
		final int listSize = list.size();
		for (int i = 0; i < listSize; i++) {
			if ((list.size() > 2) && (i == (list.size() - 1))) {
				aa.append(" ");
				aa.append(and);
				aa.append(" ");
			} else if ((i != 0) && (list.size() > 2)) {
				aa.append(", ");
			} else if ((list.size() == 2) && (i != 0)) {
				aa.append(" ");
				aa.append(and);
				aa.append(" ");
			}
			aa.append(list.get(i));
		}
		return aa;
	}

	/**
	 * This method return's the String of MMDDYY format
	 */
	public String getMMDDYYDate(final String aInputDate) {
		final StringBuilder outputDateBuffer = new StringBuilder(6);
		// Get the value for the year,month and day from the given string date
		final String year_of_date = aInputDate.substring(2, 4);
		final String month_of_date = aInputDate.substring(5, 7);
		final String day_of_date = aInputDate.substring(8, 10);
		outputDateBuffer.append(month_of_date).append(day_of_date).append(year_of_date);
		return outputDateBuffer.toString();
	}

	/**
	 * This method return's String of MMDDYYYY format
	 */
	public String getMMDDYYYY(final String aInputDate) {
		final StringBuilder outputDateBuffer = new StringBuilder(8);
		// Get the values for the year, month and day from the given string date
		final String year = aInputDate.substring(0, 4);
		final String month = aInputDate.substring(5, 7);
		final String day = aInputDate.substring(8);
		outputDateBuffer.append(month).append(day).append(year);
		return outputDateBuffer.toString();
	}

	/**
	 * This method return's the String, it contains the inputValue string and
	 * number of characters as the space after the inputValue string
	 */
	public String getStringWithPaddedSpaces(final String inputValue, final int numberOfChars) {
		final StringBuilder outputStrVal = new StringBuilder(numberOfChars);
		if ((inputValue == null) || inputValue.equals("")) {
			for (int i = 0; i < numberOfChars; i++) {
				outputStrVal.append(FwConstants.SPACE);
			}
		} else if (inputValue != null) {
			final int inputValLenght = inputValue.length();
			outputStrVal.append(inputValue);
			for (int i = inputValLenght; i < numberOfChars; i++) {
				outputStrVal.append(FwConstants.SPACE);
			}
		}
		return outputStrVal.toString();
	}

	/**
	 * Converts a string to a string that displays all X's except for the last 4
	 * digits.
	 *
	 * @param input
	 *            string to convert string
	 * @return string value with all but the last four characters X's
	 */
	public String convertToHiddenAccountNum(final String input) {

		if (input == null) {
			return "";
		}

		final int inputSize = input.trim().length();

		// Size is less than 4 so we should display all the digits
		if (inputSize <= 4) {
			return input;
		}

		// Find how many characters will need to be X's
		final int protectedLength = inputSize - 4;

		StringBuilder newString = new StringBuilder();

		// Fill in X's for all characters but the last four
		for (int i = 0; i < protectedLength; i++) {
			newString = newString.append("X");
		}

		newString = newString.append(input.substring(protectedLength));
		return newString.toString();
	}
}
