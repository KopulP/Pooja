/*
 * Created on Feb 9, 2007
 *
 */
package gov.state.nextgen.access.business.validations;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import gov.state.nextgen.access.business.entities.APP_IN_SHLTC_Cargo;
import gov.state.nextgen.access.business.entities.AppInHouBillsCargo;
import gov.state.nextgen.access.business.rules.AbstractBO;
import gov.state.nextgen.access.exceptions.FwException;
/*import gov.state.nextgen.access.individuals.PeopleHandler;*/
import gov.state.nextgen.access.management.applications.DisplayFormatter;
import gov.state.nextgen.access.management.constants.AppConstants;
import gov.state.nextgen.access.management.constants.FwConstants;
import gov.state.nextgen.access.management.logging.ILog;
import gov.state.nextgen.access.management.messages.FwMessageList;
import gov.state.nextgen.access.management.references.IReferenceTableManager;
import gov.state.nextgen.access.management.references.ReferenceTableManager;
import gov.state.nextgen.access.management.util.DateRoutine;

/**
 * @author Ram Reddy
 *
 */
public class ARXHDValidator extends AbstractBO {

	public void validateHousePageContents(
			final AppInHouBillsCargo rmcInothrIncCargo,
			final short userEndInd, final String pageMode, final Map request,
			final Map beforePageColl, final String langCD, final Map session, final String indvSeqNum, final String type) {
		try {
		//	PeopleHandler peopleHandler = (PeopleHandler) session.get(AppConstants.INDIV_MASTER_HANDLER);
			final String name = "";//peopleHandler.getFirstName(indvSeqNum) ;
			DateRoutine.getInstance();
			final Object[] error1 = new String[] { name,type };
			final String howMuch = rmcInothrIncCargo.getPymt_amt();
			final String howMuchPaid = rmcInothrIncCargo.getPaid_amt();
			final String frequency = rmcInothrIncCargo.getPymt_freq();
			final IReferenceTableManager iref = ReferenceTableManager
					.getInstance();
			final String asetTypeDesc = iref.getColumnValue("THBT", 59,
					rmcInothrIncCargo.getBill_type(), langCD);
			final char[] specialChars = { '-', '\'', '.', ' ','&' };
			if (null!=rmcInothrIncCargo.getBill_type() 
					&& (!"OT".equals(rmcInothrIncCargo.getBill_type()))) {
				if (!AppConstants.REPORT_END_MODE.equalsIgnoreCase(pageMode)) {
					
					// How often does ~ pay for Rent?
					if (frequency == null
							|| FwConstants.DEFAULT_DROPDOWN_SEL
							.equalsIgnoreCase(frequency)
							|| FwConstants.EMPTY_STRING.equals(frequency.trim())
							|| FwConstants.HYPHEN_HYPHEN.equals(frequency.trim())) {
						addMessageCode("00153");
					}

					// How much is the Rent?
					if (null!=rmcInothrIncCargo.getBill_type() 
							&& (!"HI".equals(rmcInothrIncCargo.getBill_type()))) {
						if (!appMgr.isFieldEmpty(howMuch)) {
							if (!appMgr.isCurrency(howMuch)) {
								addMessageCode("99343");
							} else if (!appMgr.isValidAmountLimit(howMuch)) {
								addMessageCode("10034");
							}
						} else {
							addMessageCode("99339");
						}

					}
				}
				
				//How much does ~ pay for Rent?
				if (!appMgr.isFieldEmpty(howMuchPaid)) {
					if (!appMgr.isCurrency(howMuchPaid)) {
						this.addMessageWithFieldValues("00152", error1);
					} else if (!appMgr.isValidAmountLimit(howMuchPaid)) {
						addMessageCode("10034");
					}
				} else {
					this.addMessageWithFieldValues("99340", error1);
				}
				
				
				//Landlord/Property Name
				if (!appMgr.isFieldEmpty(rmcInothrIncCargo.getProperty_name())) {
					if (!appMgr.isSpecialAlphaNumeric(rmcInothrIncCargo.getProperty_name(),specialChars)) {
						addMessageCode("99272");
					}
					if (rmcInothrIncCargo.getProperty_name().startsWith("0")) {
						addMessageCode("99345");
					}
				}
				
				if (rmcInothrIncCargo.getBill_type() != null
						&& "RM".equals(rmcInothrIncCargo.getBill_type())) {
					final String addl1 = rmcInothrIncCargo.getProp_addr_l1();
					final String addl2 = rmcInothrIncCargo.getProp_addr_l2();
					final String addCity = rmcInothrIncCargo
							.getProp_addr_city();
					final String addState = rmcInothrIncCargo
							.getProp_addr_state_cd();
					final String addZip = rmcInothrIncCargo.getProp_addr_zip();

					if (!appMgr.isFieldEmpty(addl1)
							&& !appMgr.isSpecialAlphaNumeric(addl1,
							        AppConstants.specialCharsForAddress)) {
						addMessageCode("00017");
					} else if (!appMgr.isFieldEmpty(addl2)
							&& !appMgr.isSpecialAlphaNumeric(addl2,
							        AppConstants.specialCharsForAddress)) {
						addMessageCode("00017");
					}
					if (!appMgr.isFieldEmpty(addCity)) {
						if (!appMgr.isAlphaWithSpace(addCity)) {
							final Object[] error = new Object[] { asetTypeDesc };
							this.addMessageWithFieldValues("00018", error);
						}
					}
					if (addState != null
							&& (!appMgr.isFieldEmpty(addZip)
									|| !appMgr.isFieldEmpty(addCity)
									|| !appMgr.isFieldEmpty(addl1) || !appMgr
									.isFieldEmpty(addl2))) {
						if (FwConstants.DEFAULT_DROPDOWN_SEL.equals(addState)) {
							addMessageCode("00028");
						}
					}

					if (StringUtils.isNotBlank(rmcInothrIncCargo
							.getProp_addr_zip())) {
						if (!appMgr.isInteger(rmcInothrIncCargo
								.getProp_addr_zip())) {
							addMessageCode("00019");
						} else if (!appMgr.isZero(rmcInothrIncCargo
								.getProp_addr_zip())) {
							addMessageCode("00022");
						} else if (!(rmcInothrIncCargo.getProp_addr_zip()
								.length() == 5 || rmcInothrIncCargo
								.getProp_addr_zip().length() == 9)) {
							addMessageCode("90748");
						}
					}
					if (!getMessageList().containsMessage("00019")
							&& rmcInothrIncCargo.getPropAddrZip4() != null
							&& !"".equals(rmcInothrIncCargo.getPropAddrZip4().trim())
							&& !rmcInothrIncCargo.getPropAddrZip4().matches("\\d+")) {
						addMessageCode("00019");

					}

				}
				if (!AppConstants.REPORT_CHANGE_MODE.equalsIgnoreCase(pageMode)) {
					if (request.containsKey("showLoopingQuestion")
							|| beforePageColl
							.containsKey("showLoopingQuestion")
							&& FwConstants.YES.equals(beforePageColl
									.get("showLoopingQuestion"))) {
						if (null != request.get("loopingQuestion")
								&& FwConstants.EMPTY_STRING
										.equals(((String) request
												.get("loopingQuestion")).trim())
										|| null == request.get("loopingQuestion")) {
							addMessageCode("00156");
						}
					}
				}
				//change date
				if(rmcInothrIncCargo.getChg_dt() != null){
					if(appMgr.isFieldEmpty(rmcInothrIncCargo.getChg_dt())){
						addMessageCode("99368");
					}
					if(!appMgr.isFieldEmpty(rmcInothrIncCargo.getChg_dt()) && !appMgr.validateDate(rmcInothrIncCargo.getChg_dt())){
						addMessageCode("99365");
					}
					if(appMgr.isDateBeforeDate(rmcInothrIncCargo.getChg_dt(), "01/01/1880")){
						addMessageCode("99366");
					}
					java.util.Date nxtMnthLastDt = getNxtMnthlastDt();

					if(appMgr.isDateAfterDate(rmcInothrIncCargo.getChg_dt(), nxtMnthLastDt)){
						addMessageCode("99367");
					}
				}
			}

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = createFwException(this.getClass().getName(),
					"validateHousePageContents", e);
			throw fe;
		}
	}
	
	public void validateEndScreen(final AppInHouBillsCargo rmcInothrIncCargo) {
		try {
			final DateRoutine dateRoutine = DateRoutine.getInstance();
			dateRoutine.addDaysToDate(fwDate.getDate(), 30);

			if (rmcInothrIncCargo.getEnd_dt() != null) {
				if (appMgr.validateDate(rmcInothrIncCargo.getEnd_dt())) {
					final String day = displayFormatter
							.getYYYYMMDDDate(rmcInothrIncCargo.getEnd_dt());
					final String[] inputDateArray = day.split("-");
					final Calendar inputDate = new GregorianCalendar();
					inputDate.set(Integer.valueOf(inputDateArray[0]),
							Integer.valueOf(inputDateArray[1]) - 1,
							Integer.valueOf(inputDateArray[2]));
					final Calendar nextMonthDate = new GregorianCalendar();
					nextMonthDate.add(Calendar.MONTH, 1);
					nextMonthDate.set(Calendar.DAY_OF_MONTH, nextMonthDate
							.getActualMaximum(Calendar.DAY_OF_MONTH));
					if (inputDate.after(nextMonthDate)) {
						addMessageCode("00843");
					}
				} else if (FwConstants.EMPTY_STRING
						.equals(rmcInothrIncCargo.getEnd_dt().trim())) {
					addMessageCode("00844");
				} else {
					addMessageCode("00845");
				}
			} else if (appMgr.isFieldEmpty(rmcInothrIncCargo.getEnd_dt())) {
				addMessageCode("00844");
			}

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = createFwException(this.getClass().getName(),
					"validatePageContents", e);
			throw fe;
		}
	}

	public void validateHouseEffectiveDate(
			final APP_IN_SHLTC_Cargo appInHouseCargo) {
		try {
			addMessageCode("30012");
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = createFwException(this.getClass().getName(),
					"validateHouseEffectiveDate", e);
			throw fe;
		}
	}

	public void validateChangeEffectiveDate(String date, final String pageMode) {

		try {

			final DateRoutine dateRoutine = DateRoutine.getInstance();
			final Date validDate = dateRoutine.addDaysToDate(fwDate.getDate(),
					30);

			if (date != null && date.length() != 0
					&& !AppConstants.HIGH_DATE.equals(date)) {

				displayFormatter = DisplayFormatter.getInstance();
				if (date.length() == 10 && date.charAt(4) == '-') {
					date = displayFormatter.getMMDDYYYYDate(date);
				}

				if (!appMgr.validateDate(date)) {
					addMessageCode("30022");
				} else if (appMgr.isDateBeforeDate(date,
						Date.valueOf("1900-01-01"))) {
					final Object[] error = new Object[] { "Housing Bill date" };
					this.addMessageWithFieldValues("20011", error);
				} else if (appMgr.isDateAfterDate(date, validDate)) {
					final Object[] error = new Object[] { "Housing Bill",
					"Housing Bill" };
					if (FwConstants.NO.equals(pageMode)) {
						this.addMessageWithFieldValues("30116", error);
					} else {
						this.addMessageWithFieldValues("30114", error);
					}

				}
			} else {
				addMessageCode("30012");
			}

		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = createFwException(this.getClass().getName(),
					"validateChangeEffectiveDate", e);
			throw fe;
		}

	}
	
	public FwMessageList validateAdd(final String name, final String type) {
		try {
			log(ILog.INFO, "ARXHDValidator::validateAdd:Start");

			if ((AppConstants.SELECT_DEFAULT_OPTION).equals(name)
					&& (AppConstants.SELECT_DEFAULT_OPTION).equals(type)) {
				addMessageCode("90712");

			} else if (!(AppConstants.SELECT_DEFAULT_OPTION).equals(name)
					&& (AppConstants.SELECT_DEFAULT_OPTION).equals(type)) {
				addMessageCode("90712");

			} else if ((AppConstants.SELECT_DEFAULT_OPTION).equals(name)
					&& !(AppConstants.SELECT_DEFAULT_OPTION).equals(type)) {
				addMessageCode("90712");

			}
			return getMessageList();
		} catch (final FwException fe) {
			throw fe;
		} catch (final Exception e) {
			final FwException fe = createFwException(this.getClass().getName(),
					"validateAdd", e);
			throw fe;
		}

	}
}
