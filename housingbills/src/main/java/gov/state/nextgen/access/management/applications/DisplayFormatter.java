/*
 * 
 */
package gov.state.nextgen.access.management.applications;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import gov.state.nextgen.access.business.entities.APP_HSHL_RLT_Cargo;
import gov.state.nextgen.access.business.entities.APP_HSHL_RLT_Collection;
import gov.state.nextgen.access.business.entities.BNFT_CASE_ADR_Cargo;
import gov.state.nextgen.access.driver.FwPageManager;
import gov.state.nextgen.access.driver.IPage;
import gov.state.nextgen.access.management.constants.AppConstants;
import gov.state.nextgen.access.management.constants.FwConstants;
import gov.state.nextgen.access.management.util.Formatter;
//import gov.state.nextgen.framework.management.util.FwMessageFormatter;
import gov.state.nextgen.access.management.validations.FwMessageFormatter;

/**
 * Management Date Utility.
 *
 * @author: Architecture Team Creation date: 03/28/2006 Modified by: Modified
 *          on: PCR# :
 */

public class DisplayFormatter extends Formatter {

	private static final DisplayFormatter displayFormatter = new DisplayFormatter();

	private DisplayFormatter() {
		super();
	}

	public static DisplayFormatter getInstance() {
		// METHOD DOES NOT NEED TO BE SYNCHRONIZED AS INSTANCE IS OBTAINED
		// STATICALLY IN CLASS DECLARATION
		// DO NOT MODIFY CODE TO MAKE METHOD SYNCHRONIZED OR USE DOUBLE-LOCKING
		// AS DOUBLE-LOCKING IS NOT THREAD-SAFE CURRENTLY
		return displayFormatter;
	}

	/**
	 * Outputs the given String date in the format Thursday July 7, 2005
	 */
	@Override
	public String getExpandedDate(final String date, final String languageIndicator) {
		return getExpandedDate(Date.valueOf(date), languageIndicator);
	}

	/**
	 * Outputs the given sql date in the format July 7, 2005
	 */
	@Override
	public String getExpandDate(final Date date, final String languageIndicator) {
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

		month = page.getDisplayText(textID, languageIndicator);
		result = new StringBuilder/* (day).append(" ").append */(month).append(" ").append(dt).append(",").append(" ").append(yr).toString();
		return result;
	}

	/**
	 * Outputs the given sql date in the format Thursday July 7, 2005
	 */
	@Override
	public String getExpandedDate(final Date date, final String languageIndicator) {
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

		day = page.getDisplayText(textID, languageIndicator);

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

		month = page.getDisplayText(textID, languageIndicator);
		result = new StringBuilder(day).append(" ").append(month).append(" ").append(dt).append(",").append(" ").append(yr).toString();
		return result;
	}

	/**
	 * Outputs the given sql date in the format yyyy-mm-dd
	 */
	@Override
	public String getYYYYMMDDDate(final Date date) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}

	/**
	 * Outputs the given sql date in the format mm/dd/yyyy
	 */
	@Override
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
	@Override
	public String getMMDDYYYYDate(String yyyyMmDd) {

		String result = "";
		// Get the values for the date, month and year from the given sql date
		yyyyMmDd = yyyyMmDd.substring(0, 10);
		final String yyyy = yyyyMmDd.substring(0, 4);
		final String mm = yyyyMmDd.substring(5, 7);
		final String dd = yyyyMmDd.substring(8, 10);

		result = new StringBuilder(mm).append("/").append(dd).append("/").append(yyyy).toString();
		return result;
	}

	/**
	 * Outputs the given String date "yyyy-mm" in the format mm/yyyy
	 */
	@Override
	public String getMMYYYYDate(String yyyyMm) {

		String result = "";
		// Get the values for the date, month and year from the given sql date
		yyyyMm = yyyyMm.substring(0, 7);
		final String yyyy = yyyyMm.substring(0, 4);
		final String mm = yyyyMm.substring(5, 7);

		result = new StringBuilder(mm).append("/").append(yyyy).toString();
		return result;
	}

	/**
	 * Outputs the given String date mm/dd/yyyy in the format "yyyy-mm-dd"
	 */
	@Override
	public String getYYYYMMDDDate(final String mmDdYyyy) {

		String result = "";
		// Get the values for the date, month and year from the given sql date
		if ((mmDdYyyy.length() == 10) && (mmDdYyyy.charAt(2) == '/')) {
			final String yyyy = mmDdYyyy.substring(6, 10);
			final String mm = mmDdYyyy.substring(0, 2);
			final String dd = mmDdYyyy.substring(3, 5);
			result = new StringBuilder(yyyy).append("-").append(mm).append("-").append(dd).toString();
			return result;
		} else {
			return mmDdYyyy;
		}

	}

	/**
	 * returns the month of a given date
	 */
	@Override
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
	@Override
	public String getExpandedMonthYear(final Date date, final String languageIndicator) {
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

		month = page.getDisplayText(textID, languageIndicator);
		result = new StringBuilder(month).append(" ").append(yr).toString();
		return result;
	}

	// this method weill give the formated phone number
	@Override
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
			} else if ("0000000000".equals(phNum)) {
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
	@Override
	public String getCurrencyFormat(final String amount) {

		return java.text.NumberFormat.getCurrencyInstance().format(Double.parseDouble(amount)).substring(1);

	}

	/**
	 * returns the input String to Curreny format (eg: 40000.00)
	 */
	@Override
	public String getNumberFormat(final String amount) {
		try {
			if ((amount != null) && !amount.trim().isEmpty() && !AppConstants.ON_FILE.equals(amount)) {
				final DecimalFormat dec = new DecimalFormat("0.00");
				return dec.format(Double.parseDouble(amount));
			} else {
				return amount;
			}
		} catch (final NumberFormatException e) {
			return amount;
		}
	}

	/**
	 * Retrieves just an address information from addressCargo and formats it.
	 *
	 * @param addressCargo
	 *            An Address Cargo that stores address information
	 * @return A String representing a formatted address
	 * @see gov.state.nextgen.access.business.entities.BNFT_CASE_ADR_Cargo
	 */
	public String getAddress(final BNFT_CASE_ADR_Cargo addressCargo) {
		final StringBuilder sb = new StringBuilder();
		buildAddress(addressCargo, sb);
		return sb.toString();
	}

	/**
	 * Builds an address with Contact Name, Phone and Fax Numbers
	 *
	 * @param addressCargo
	 *            A BNFT_CASE_ADR_Cargo with address information
	 * @param language
	 *            A String representing a language indicator (EN or ES)
	 * @return A String representing a formatted address
	 * @see gov.state.nextgen.access.business.entities.BNFT_CASE_ADR_Cargo
	 */
	public String getAddressWithNamePhoneAndFax(final BNFT_CASE_ADR_Cargo addressCargo, final String language) {
		final StringBuilder sb = new StringBuilder();
		buildName(addressCargo, sb);
		buildAddress(addressCargo, sb);
		sb.append("<BR>");
		buildPhoneAndFax(addressCargo, language, sb);
		return sb.toString();
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
	@Override
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

	// Helper method that extract contact address information from addressCargo
	// and appends
	// it to a given StringBuilder.
	private void buildAddress(final BNFT_CASE_ADR_Cargo addressCargo, final StringBuilder sb) {
		boolean nextLine = false;

		final String streetNumber = addressCargo.getSt_num_adr().trim();
		if (streetNumber.length() > 0) {
			sb.append(streetNumber).append(" ");
			nextLine = true;
		}

		final String unit = addressCargo.getUnit_adr().trim();
		if (unit.length() > 0) {
			sb.append(unit).append(" ");
			nextLine = true;
		}

		final String dir = addressCargo.getDir_adr().trim();
		if (dir.length() > 0) {
			sb.append(dir).append(" ");
			nextLine = true;
		}
		final String street = addressCargo.getSt_rurl_adr().trim();
		if (street.length() > 0) {
			sb.append(street).append(" ");
			nextLine = true;
		}

		final String suffix = addressCargo.getSfx_adr().trim();
		if (suffix.length() > 0) {
			sb.append(suffix).append(" ");
			nextLine = true;
		}

		final String quadrant = addressCargo.getQdrt_adr().trim();
		if (quadrant.length() > 0) {
			sb.append(quadrant).append(" ");
			nextLine = true;
		}

		final String apartmentNumber = addressCargo.getApt_adr().trim();
		if (apartmentNumber.length() > 0) {
			sb.append(apartmentNumber).append(" ");
			nextLine = true;
		}

		if (nextLine) {
			sb.append("<BR>");
			nextLine = false;
		}

		final String addressLine2 = addressCargo.getL2_adr().trim();
		if (addressLine2.length() > 0) {
			sb.append(addressLine2).append("<BR>");
		}

		final String city = addressCargo.getCity_adr().trim();
		if (city.length() > 0) {
			sb.append(city).append(" ");
		}

		final String state = addressCargo.getSt_adr().trim();
		if (state.length() > 0) {
			sb.append(state).append(" ");
		}

		final String zip = addressCargo.getZip_adr().trim();
		if (zip.length() > 0) {
			if (zip.length() > 5) {
				sb.append(zip.substring(0, 5));
				sb.append("-");
				sb.append(zip.substring(5));
			} else {
				sb.append(zip);
			}
		}

	}

	// Helper method that extract contact name information from addressCargo and
	// appends
	// it to a given StringBuilder.
	private void buildName(final BNFT_CASE_ADR_Cargo addressCargo, final StringBuilder sb) {
		boolean nextLine = false;
		final String firstName = addressCargo.getCntc_fst_nam().trim();
		if (firstName.length() > 0) {
			sb.append(firstName).append(" ");
			nextLine = true;
		}

		final String middleInitial = addressCargo.getCntc_mid_init().trim();
		if (middleInitial.length() > 0) {
			sb.append(middleInitial).append(" ");
			nextLine = true;
		}

		final String lastName = addressCargo.getCntc_last_nam().trim();
		if (lastName.length() > 0) {
			sb.append(lastName);
			nextLine = true;
		}

		if (nextLine) {
			sb.append("<BR>");
		}

	}

	// Helper method that extract contact phone and fax information from
	// addressCargo and appends
	// it to a given StringBuilder.
	private void buildPhoneAndFax(final BNFT_CASE_ADR_Cargo addressCargo, final String language, final StringBuilder sb) {
		final String contactPhone = addressCargo.getCntc_phn_num().trim();
		if ((contactPhone.length() > 0) && (contactPhone.indexOf("X") == -1)) {
			final String phone = FwMessageFormatter.getCachedText(20081, language);
			sb.append(phone).append(" ");
			sb.append(DisplayFormatter.getInstance().getFormatedPhNumber(contactPhone));
			sb.append("<BR>");
		}

		final String contactFax = addressCargo.getCntc_fax_num().trim();
		if ((contactFax.length() > 0) && (contactFax.trim().indexOf("X") == -1)) {
			final String fax = FwMessageFormatter.getCachedText(20082, language);
			sb.append(fax).append(" ");
			sb.append(DisplayFormatter.getInstance().getFormatedPhNumber(fax));
			sb.append("<BR>");
		}
	}

	// Returns a formatted and legible timestamp which looks like- Month, Date
	// Year Hours:Minutes:Seconds A.M./P.M.
	// e.g, July 31, 2006 08:30:22 A.M.
	@Override
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
		finalDateStamp.append(AppConstants.AT).append(FwConstants.SPACE);

		String strHour = null;
		String strAMPM = AppConstants.ANTE_MERIDIAN;
		final String min = String.valueOf(ts.getMinutes());

		if (hours >= 12) {
			strHour = (hours == 12) ? "12" : String.valueOf(hours - 12);
			strAMPM = AppConstants.POST_MERIDIAN;
		} else {
			strHour = (hours == 0) ? "12" : String.valueOf(hours);
		}

		if (strHour.length() == 1) {
			finalDateStamp.append(AppConstants.ZERO);
		}
		finalDateStamp.append(strHour).append(":");
		if (min.length() == 1) {
			finalDateStamp.append(AppConstants.ZERO);
		}
		finalDateStamp.append(min);

		finalDateStamp.append(FwConstants.SPACE).append(strAMPM);

		return finalDateStamp.toString();
	}

	@Override
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

	// this method we are using for filtering the droupdown
	// AFB HouseHoldRelationShipPage
	public List filteredList(final APP_HSHL_RLT_Collection rltColl, final String srcSeqNumber, final String refSeqNumber) {
		final int resSize = rltColl.size();
		APP_HSHL_RLT_Cargo rltCargo = null;
		String srcNumber = null;
		String refNumber = null;
		String rltCd = null;
		int parentSize =0;
		final List filterValues = new ArrayList();
		for (int i = 0; i < resSize; i++) {
			rltCargo = rltColl.getCargo(i);
			srcNumber = rltCargo.getSrc_indv_seq_num();
			refNumber = rltCargo.getRef_indv_seq_num();
			rltCd = rltCargo.getRlt_cd();
			if (refNumber.equals(srcSeqNumber)) {
				if ("FTR".equals(rltCd)) {
					filterValues.add("SON");
				} else if ("MTR".equals(rltCd)) {
					filterValues.add("DAU");
				} else if ("WIF".equals(rltCd)) {
					filterValues.add("HUS");
				} else if ("HUS".equals(rltCd)) {
					filterValues.add("WIF");
				}
			}
			
			if (refNumber.equals(refSeqNumber) && !srcSeqNumber.equals(srcNumber)) {
				if("FTR".equals(rltCd) || "MTR".equals(rltCd)){
					parentSize=parentSize+1;
				}
				if(parentSize>=2){					
					filterValues.add("FTR");					
					filterValues.add("MTR");
					}
				}
				/*if ("FTR".equals(rltCd)) {
					filterValues.add("FTR");
				} else if ("MTR".equals(rltCd)) {
					filterValues.add("MTR");
				}*/
		}
		return filterValues;
	}

	// This method we are using for filtering the dropdown
	// RMC HouseHoldRelationShipPage
	// we are in need of different methods for AFB and RMC because here we have
	// existing
	// and new individuals
	public List filteredListRMC(final APP_HSHL_RLT_Collection rltColl, final String srcSeqNumber, final String refSeqNumber) {
		final int resSize = rltColl.size();
		APP_HSHL_RLT_Cargo rltCargo = null;
		String srcNumber = null;
		String refNumber = null;
		String rltCd = null;
		int parentSize=0;
		final List filterValues = new ArrayList();
		for (int i = 0; i < resSize; i++) {
			rltCargo = rltColl.getCargo(i);
			srcNumber = rltCargo.getSrc_indv_seq_num();
			refNumber = rltCargo.getRef_indv_seq_num();
			rltCd = rltCargo.getRlt_cd();
			if (refNumber.equals(srcSeqNumber)) {
				if ("FTR".equals(rltCd) && !isRefSeqNumberRelatedToOther(refNumber, rltCd, rltColl)) {
					filterValues.add("SON");
				} else if ("MTR".equals(rltCd) && !isRefSeqNumberRelatedToOther(refNumber, rltCd, rltColl)) {
					filterValues.add("DAU");
				} else if ("WIF".equals(rltCd) && !isRefSeqNumberRelatedToOther(refNumber, rltCd, rltColl)) {
					filterValues.add("HUS");
				} else if ("HUS".equals(rltCd) && !isRefSeqNumberRelatedToOther(refNumber, rltCd, rltColl)) {
					filterValues.add("WIF");
				}
			}
			
			/*if (refNumber.equals(refSeqNumber) && !srcSeqNumber.equals(srcNumber)) {
				if ("FTR".equals(rltCd) && !isRefSeqNumberRelatedToOther(refNumber, rltCd, rltColl)) {
					filterValues.add("FTR");
				} else if ("MTR".equals(rltCd) && !isRefSeqNumberRelatedToOther(refNumber, rltCd, rltColl)) {
					filterValues.add("MTR");
				}
			}*/
			
			if (refNumber.equals(refSeqNumber) && !srcSeqNumber.equals(srcNumber)) {
				if("FTR".equals(rltCd) || "MTR".equals(rltCd)){
					parentSize=parentSize+1;
				}
				if(parentSize>=2){					
					filterValues.add("FTR");					
					filterValues.add("MTR");
					}
				}
		}
		return filterValues;
	}

	/*
	 * This method returns flag if the existing individual has already a
	 * relation associated
	 */
	private boolean isRefSeqNumberRelatedToOther(final String aRefSeqNumber, final String aRltCd, final APP_HSHL_RLT_Collection rltColl) {
		boolean flag = false;
		int rltCollSize = 0;
		if (rltColl != null) {
			rltCollSize = rltColl.size();
		}
		APP_HSHL_RLT_Cargo rltCargo = null;
		String rltCode = null;
		String refIndvSeqNumber = null;
		if(rltColl !=null && !rltColl.isEmpty() && rltColl.size()>0){
		for (int i = 0; i < rltCollSize; i++) {
			rltCargo = rltColl.getCargo(i);
			rltCode = rltCargo.getRlt_cd();
			refIndvSeqNumber = rltCargo.getRef_indv_seq_num();
			if (aRefSeqNumber.equals(refIndvSeqNumber) && aRltCd.equals(rltCode)) {
				flag = true;
				break;
			}

		}
		}
		return flag;
	}

	/**
	 * This method return's the String of MMDDYY format
	 */
	@Override
	public String getMMDDYYDate(final String aInputDate) {
		final StringBuilder outputDateBuffer = new StringBuilder(6);
		// Get the value for the year,month and day from the given string date
		final String yearOfDate = aInputDate.substring(2, 4);
		final String monthOfDate = aInputDate.substring(5, 7);
		final String dayOfDate = aInputDate.substring(8, 10);
		outputDateBuffer.append(monthOfDate).append(dayOfDate).append(yearOfDate);
		return outputDateBuffer.toString();
	}

	/**
	 * This method return's String of MMDDYYYY format
	 */
	@Override
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
	@Override
	public String getStringWithPaddedSpaces(final String inputValue, final int numberOfChars) {
		final StringBuilder outputStrVal = new StringBuilder(numberOfChars);
		if ((inputValue == null) || "".equals(inputValue)) {
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
	@Override
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