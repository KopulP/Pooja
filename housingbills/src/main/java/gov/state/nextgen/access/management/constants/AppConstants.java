/*
 * 
 */
package gov.state.nextgen.access.management.constants;

import gov.state.nextgen.access.management.constants.FwConstants;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Constants for the application
 *
 * @author Deloitte Consulting.
 */
public class AppConstants {
    
    public static final String HIGH_MONTH = "999912";
    public static final String HIGH_YEAR = "9999";
    public static final String HIGH_CASE_NUM = "9999999999";

    // Constants related to page actions
    public static final String PAGE = "PAGE_ID";
    public static final String FULL_MEDICAID = "Full_Medicaid";
    public static final String PAGE_ID = "PAGE_ID";
    public static final String NEXT_PAGE = "NEXT_PAGE";
    public static final String REQUESTED_PAGE = "REQUESTED_PAGE";
    public static final String NEXT_PAGE_ID = "NEXT_PAGE_ID";
    public static final String ACTION_FIELD = "ACTION";
    public static final String REQUESTED_PAGE_ID = "REQUESTED_PAGE_ID";
    public static final String PARENT_PAGE_ID = "PARENT_PAGE_ID";
    public static final String PAGE_TITLE = "COMPLETE_PAGE_TITLE";
    public static final String HIGH_DATE = "9999-12-31";
    public static final String HIGH_DATE_SLASH = "12/31/9999";
    public static final Date HIGH_DATE_OBJ = Date.valueOf(AppConstants.HIGH_DATE);
    public static final String LOW_DATE = "0001-01-01";
    public static final String HIGH_PIN = "9999999999";
    public static final String ZERO = "0";
    // Start of VaCMS - Login Image
    public static final String LOGIN_IMG = "/homepagebox.gif";
    // End of VaCMS - Login Image
    // For home page changes.
    // Start of VaCMS - CP Logo
    public static final String VACMS_LOGO_IMG = "/cp_logo.jpg";
    // End of VaCMS - CP Logo
    public static final String MI_HELP_IMG = "/btn_help.gif";
    // High Timestamp
    public static final String HIGH_TIMESTAMP = "9999-12-31 00:00:00.0";

    // Constants related to Individual dropdown component
    public static final int HIGH_NO_OF_INDV = 25;
    public static final String PRIMARY_PERSON = "Y";
    public static final String AFB_CASE = "Case";
    // Constants related to user authentication
    public static final String USER_ID = "USERID";
    public static final String BNFT_RGST_IND = "BNFT_RGST_IND";

    // Constant related to the Applications First Page.
    public static final String APPLICATION_FIRST_PAGE = "AGHME";

    // Constants related to FORM URL
    public static final String ACCESS_FORM_ACTION = "/access/accessController";

    public static final int APP_SEARCH_DATE_RANGE = 90;

    public static final String SESSION_IDENTIFIER = "SESSIONID";
    public static final String WORKSTATION_IDENTIFIER = "WORKSTATIONID";
    public static final String REMOTE_IP_ADDRESS = "REMOTEADDR";

    // Constants related to database
    public static final String DB_USERID = "USER";
    public static final String DB_PASSWORD = "PASSWORD";
    public static final String DB_URL = "URL";
    public static final String DB_DATASOURCE = "DATASOURCE";
    public static final String DB_DRIVER = "DRIVER";

    // Constants related to page security
    public static final int READ_ONLY_PAGE = 1;
    public static final int READ_WRITE_PAGE = 2;
    public static final int NO_ACCESS = 0;

    // Constants related to properties file
    public static final String PROPERTIES_FILE_NAME = "PROPERTIES_FILE_NAME";
    public static final String PROPERTIES_FILE_PATH = "PROPERTIES_FILE_PATH";

    // Constants related to web resources
    public static final String RELATIVE_PATH_PREFIX = "WEBRELPATH";

    // Constants related to Business Field Validation
    public static final String CR_VALIDATION_MANAGER = "CrValidationManager";
    public static final String AE_VALIDATION_MANAGER = "AeValidationManager";
    public static final String RT_VALIDATION_MANAGER = "RtValidationManager";
    public static final String SE_VALIDATION_MANAGER = "SeValidationManager";

    // Constants related to CR Module
    public static final String PRIORITY_SERVICE_DETERMINATION_CARGO = "psdCargo";
    public static final String PRIORITY_SERVICE_DETERMINATION_CARGO_COLLECTION = "psdColleciton";

    // Constant related to Self Help.
    public static final String LANGUAGE = "LANGUAGE";
    // images base folder
    public static final String FOLDER_IMAGES = "/access/images";

    // css base folder
    public static final String FOLDER_CSS = "/access/css";

    // css styles
    // Start of VaCMS - New Graphic
    public static final String CSS_ALL = "/cp_styles.css";
    public static final String CSS_RMC = "/cp_styles.css";
    public static final String CSS_AFB = "/cp_styles.css";
    public static final String CSS_DEFAULT = "/cp_styles.css";
    // End of VaCMS - New Graphic
    public static final String CSS_DEFAULT_RMC = "/";

    // image extensions
    public static final String IMAGE_EXTENSION_JPEG = ".jpg";
    public static final String IMAGE_EXTENSION_GIF = ".gif";

    // Constants related to ERROR, WARNING, INFOMATIONAL-MESSAGE.
    public static final String ERROR = "1";
    public static final String ERROR_TEXT_ID = "293";
    public static final String WARNING = "2";
    public static final String MESSAGE = "3";
    public static final String MESSAGE_HEADER = "225";

    // Language Specific Button Names.
    public static final String BUTTON_APPLICATION = "BUTTON_APPLICATION";
    public static final String BUTTON_APPLY = "BUTTON_APPLY";
    public static final String BUTTON_APPROVED_ACTIVITY = "BUTTON_APPROVED_ACTIVITY";
    public static final String BUTTON_BEGIN_ACCESS_EN = "BUTTON_BEGIN_ACCESS_EN";
    public static final String BUTTON_BEGIN_ACCESS_ES = "BUTTON_BEGIN_ACCESS_ES";
    public static final String BUTTON_BENEFITCHECK = "BUTTON_BENEFITCHECK";
    public static final String BUTTON_BQ_COMMENTS = "BUTTON_BQ_COMMENTS";
    public static final String BUTTON_CALCULATE = "BUTTON_CALCULATE";
    public static final String BUTTON_CALCULATOR = "BUTTON_CALCULATOR";
    public static final String BUTTON_CHANGES = "BUTTON_CHANGES";
    public static final String BUTTON_CHILD_EXPENSES = "BUTTON_CHILD_EXPENSES";
    public static final String BUTTON_COMMENTS = "BUTTON_COMMENTS";
    public static final String BUTTON_CONTACT = "BUTTON_CONTACT";
    public static final String BUTTON_DETAIL = "BUTTON_DETAIL";
    public static final String BUTTON_CREATE = "BUTTON_CREATE";
    public static final String BUTTON_DELETE_RED = "BUTTON_DELETE_RED";
    public static final String BUTTON_DETAILS_QUESTIONS = "BUTTON_DETAILS_QUESTIONS";
    public static final String BUTTON_DISABILITY = "BUTTON_DISABILITY";
    public static final String BUTTON_HEALTH_NEEDS = "BUTTON_HEALTH_NEEDS";
    public static final String BUTTON_HELP = "BUTTON_HELP";
    public static final String BUTTON_HISTORY = "BUTTON_HISTORY";
    public static final String BUTTON_MYACCESS_FOLDER = "BUTTON_MYACCESS_FOLDER";
    public static final String GREEN_CIRCLE_ICON = "GREEN_CIRCLE_ICON";
    public static final String BUTTON_HOUSING_EXPENSES = "BUTTON_HOUSING_EXPENSES";
    public static final String BUTTON_INCOME = "BUTTON_INCOME";
    public static final String BUTTON_LEARN_MORE = "BUTTON_LEARN_MORE";
    public static final String BUTTON_MARRIAGES = "BUTTON_MARRIAGES";
    // Start of VaCMS - Addition of new buttons
    public static final String BUTTON_ACTIVITY = "BUTTON_ACTIVITY";
    public static final String BUTTON_PARENT_OR_CHILD_INFORMATION = "BUTTON_PARENT_OR_CHILD_INFORMATION";
    // End of VaCMS - Addition of new buttons
    public static final String BUTTON_MEDICAL_EXPENSES = "BUTTON_MEDICAL_EXPENSES";
    public static final String BUTTON_NURSING_CARE = "BUTTON_NURSING_CARE";
    public static final String BUTTON_MEDICARE = "BUTTON_MEDICARE";
    public static final String BUTTON_PRINT_MY_INFORMATION = "BUTTON_PRINT_MY_INFORMATION";
    public static final String BUTTON_MYACCESS_WELCOME = "BUTTON_MYACCESS_WELCOME";
    public static final String BUTTON_NAME_AGE_GENDER = "BUTTON_NAME_AGE_GENDER";
    public static final String BUTTON_NEW_HELP = "BUTTON_NEW_HELP";
    public static final String BUTTON_NEXT = "BUTTON_NEXT";
    public static final String BUTTON_ONE_PAGE_FORM = "BUTTON_ONE_PAGE_FORM";
    // Start of VaCMS - Addition of new buttons
    public static final String BUTTON_PARENTS_OR_CHILD_INFORMATION = "BUTTON_PARENTS_OR_CHILD_INFORMATION";
    // Start of VaCMS - Addition of new buttons
    public static final String BUTTON_PREGNANCY = "BUTTON_PREGNANCY";
    public static final String BUTTON_HEALTH_INSURANCE = "BUTTON_HEALTH_INSURANCE";
    public static final String BUTTON_PREVIOUS = "BUTTON_PREVIOUS";
    public static final String BUTTON_PRINT = "BUTTON_PRINT";
    public static final String BUTTON_PRINT_INFORMATION = "BUTTON_PRINT_INFORMATION";
    public static final String BUTTON_QUESTIONS = "BUTTON_QUESTIONS";
    public static final String BUTTON_RESOURCES = "BUTTON_RESOURCES";
    public static final String BUTTON_SCREENER = "BUTTON_SCREENER";
    public static final String BUTTON_RMC = "BUTTON_RMC";
    public static final String BUTTON_START = "BUTTON_START";
    public static final String BUTTON_STOP = "BUTTON_STOP";
    public static final String BUTTON_SUBMIT = "BUTTON_SUBMIT";
    public static final String BUTTON_TOP = "BUTTON_TOP";
    public static final String BUTTON_WHAT_BRING = "BUTTON_WHAT_BRING";
    public static final String BUTTON_CREATE_ACCOUNT = "BUTTON_CREATE_ACCOUNT";
    public static final String BUTTON_BACK_TO_MYACCESS = "BUTTON_BACK_TO_MYACCESS";
    public static final String BUTTON_CLICK_HERE = "BUTTON_CLICK_HERE";
    public static final String BUTTON_LOGIN = "BUTTON_LOGIN";
    public static final String BUTTON_LOGIN2 = "BUTTON_LOGIN2";
    public static final String BUTTON_UPDATE_ACCOUNT = "BUTTON_UPDATE_ACCOUNT";
    public static final String BUTTON_RECOVERY_ACCOUNT = "BUTTON_RECOVERY_ACCOUNT";
    public static final String BUTTON_CONTINUE = "BUTTON_CONTINUE";
    public static final String BUTTON_CANCEL = "BUTTON_CANCEL";
    public static final String BUTTON_LOGOUT = "BUTTON_LOGOUT";

    // edsp cp - added for client warning screen
    public static final String BUTTON_ACCEPT = "BUTTON_ACCEPT";
    public static final String BUTTON_DO_NOT_ACCEPT = "BUTTON_DO_NOT_ACCEPT";
    // edsp cp - added for client warning screen
    public static final String BUTTON_RESET_PASSWORD = "BUTTON_RESET_PASSWORD";
    public static final String BUTTON_UPDATE_QUESTIONS = "BUTTON_UPDATE_QUESTIONS";
    public static final String BUTTON_UPDATE_INFO = "BUTTON_UPDATE_INFO";

    public static final String BUTTON_GOTO_NEW_SESSION = "BUTTON_GOTO_NEW_SESSION";
    public static final String BUTTON_TAKE_ME_BACK_TO_MY_SESSION = "BUTTON_TAKE_ME_BACK_TO_MY_SESSION";

    public static final String BUTTON_BACK = "BUTTON_BACK";
    public static final String BUTTON_WORKER_LOGIN = "BUTTON_WORKER_LOGIN";
    public static final String BUTTON_NEXT1 = "BUTTON_NEXT1";
    public static final String BUTTON_END_CASE = "BUTTON_END_CASE";
    public static final String BUTTON_BACK1 = "BUTTON_BACK1";
    public static final String BUTTON_SUBMIT1 = "BUTTON_SUBMIT1";
    public static final String BUTTON_APPLY_ONLINE = "BUTTON_APPLY_ONLINE";
    public static final String BUTTON_GO = "BUTTON_GO";
    public static final String BUTTON_GO_ORANGE = "BUTTON_GO_ORANGE";
    public static final String BUTTON_RETURN_TO_ACCESS_HOME = "BUTTON_RETURN_TO_ACCESS_HOME";
    public static final String BUTTON_LOOKUP = "BUTTON_LOOKUP";
    // Language Specific Button Names for AFB
    public static final String BUTTON_START_NEW_APPLICATION = "BUTTON_START_NEW_APPLICATION";
    public static final String BUTTON_KEEP_WORKING = "BUTTON_KEEP_WORKING";
    public static final String BUTTON_APPLICATION_STATUS = "BUTTON_APPLICATION_STATUS";

    public static final String BUTTON_BLUE_RESET_PASSWORD = "BUTTON_BLUE_RESET_PASSWORD";
    public static final String BUTTON_START_AFB = "BUTTON_START_AFB";
    public static final String BUTTON_START_AFB_GRAY = "BUTTON_START_AFB_GRAY";
    public static final String BUTTON_START_AFB_NEW = "BUTTON_START_AFB_NEW";
    public static final String BUTTON_PEOPLE = "BUTTON_PEOPLE";
    public static final String BUTTON_PEOPLE_GRAY = "BUTTON_PEOPLE_GRAY";
    public static final String BUTTON_PEOPLE_NEW = "BUTTON_PEOPLE_NEW";
    public static final String BUTTON_JOBINCOME = "BUTTON_JOBINCOME";
    public static final String BUTTON_JOBINCOME_GRAY = "BUTTON_JOBINCOME_GRAY";
    public static final String BUTTON_JOBINCOME_NEW = "BUTTON_JOBINCOME_NEW";
    public static final String BUTTON_OTHERINCOME = "BUTTON_OTHERINCOME";
    public static final String BUTTON_OTHERINCOME_GRAY = "BUTTON_OTHERINCOME_GRAY";
    public static final String BUTTON_OTHERINCOME_NEW = "BUTTON_OTHERINCOME_NEW";
    public static final String BUTTON_HOUSING_BILLS = "BUTTON_HOUSING_BILLS";
    public static final String BUTTON_HOUSING_BILLS_GRAY = "BUTTON_HOUSING_BILLS_GRAY";
    public static final String BUTTON_HOUSING_BILLS_NEW = "BUTTON_HOUSING_BILLS_NEW";
    public static final String BUTTON_OTHERBILLS = "BUTTON_OTHERBILLS";
    public static final String BUTTON_OTHERBILLS_GRAY = "BUTTON_OTHERBILLS_GRAY";
    public static final String BUTTON_OTHERBILLS_NEW = "BUTTON_OTHERBILLS_NEW";
    public static final String BUTTON_FINISH = "BUTTON_FINISH";
    public static final String BUTTON_FINISH_GRAY = "BUTTON_FINISH_GRAY";
    public static final String BUTTON_FINISH_NEW = "BUTTON_FINISH_NEW";
    public static final String BUTTON_SUBMIT_AFB = "BUTTON_SUBMIT_AFB";
    public static final String BUTTON_SUBMIT_GRAY = "BUTTON_SUBMIT_GRAY";
    public static final String BUTTON_SUBMIT_NEW = "BUTTON_SUBMIT_NEW";
    public static final String BUTTON_PRINT_MY_APPLICATION = "BUTTON_PRINT_MY_APPLICATION";
    public static final String BUTTON_PRINT_NOTICE = "BUTTON_PRINT_NOTICE";
    public static final String BUTTON_PRINT_APPLICATION_SUMMARY = "BUTTON_PRINT_APPLICATION_SUMMARY";
    public static final String BUTTON_PARTNERS_PROVIDERS = "BUTTON_PARTNERS_PROVIDERS";
    public static final String BUTTON_EMPLOYERS = "BUTTON_EMPLOYERS";

    public static final String BUTTON_ARROW_BACK = "BUTTON_ARROW_BACK";
    public static final String BUTTON_ARROW_NEXT = "BUTTON_ARROW_NEXT";
    public static final String BUTTON_SAVE_AND_EXIT = "BUTTON_SAVE_AND_EXIT";
    public static final String BUTTON_SAVE = "BUTTON_SAVE";
    public static final String BUTTON_ADD = "BUTTON_ADD";
    public static final String BUTTON_TYPES_OF_PROOF = "BUTTON_TYPES_OF_PROOF";
    public static final String BUTTON_VIEW = "BUTTON_VIEW";

    public static final String BUTTON_HEALTH_SURVEY = "BUTTON_HEALTH_SURVEY";
    public static final String BUTTON_CLAIMS_INFO = "BUTTON_CLAIMS_INFO";
    public static final String BUTTON_REQUEST_ID_CARDS = "BUTTON_REQUEST_ID_CARDS";
    public static final String BUTTON_CLAIMS_INFO_TAB = "BUTTON_CLAIMS_INFO_TAB";
    public static final String BUTTON_REQUEST_ID_CARDS_TAB = "BUTTON_REQUEST_ID_CARDS_TAB";

    // To Add the Types of Proof for FAP and SER-Energy - Start
    public static final String BUTTON_TYPE_OF_PROOF_FAP = "BUTTON_TYPE_OF_PROOF_FAP";
    public static final String BUTTON_TYPE_OF_PROOF_SER = "BUTTON_TYPE_OF_PROOF_SER";

    // Language Specific Button Names for Types of Proof for FAP and SER
    public static final String BUTTON_TYPE_OF_PROOF_FAP_SELECTED_IMG = "/typeofproof_fap_selected.jpg";
    public static final String BUTTON_TYPE_OF_PROOF_FAP_UNSELECTED_IMG = "/typeofproof_fap_deselected.jpg";
    public static final String BUTTON_TYPE_OF_PROOF_FAP_SELECTED_ALT = "111094";
    public static final String BUTTON_TYPE_OF_PROOF_FAP_UNSELECTED_ALT = "111094";

    public static final String BUTTON_TYPE_OF_PROOF_SER_SELECTED_IMG = "/typeofproof_ser_selected.jpg";
    public static final String BUTTON_TYPE_OF_PROOF_SER_UNSELECTED_IMG = "/typeofproof_ser_deselected.jpg";
    public static final String BUTTON_TYPE_OF_PROOF_SER_SELECTED_ALT = "111095";
    public static final String BUTTON_TYPE_OF_PROOF_SER_UNSELECTED_ALT = "111095";
    // To Add the Types of Proof for FAP and SER-Energy - End

    // To add a new Change button for the ABChangeHeatingSource.jsp - Start
    public static final String BUTTON_CHANGE = "BUTTON_CHANGE";
    public static final String BUTTON_CHANGE_IMG = "/button_change.jpg";
    public static final String BUTTON_CHANGE_ALT = "30513";
    // To add a new Change button for the ABChangeHeatingSource.jsp - End

    // Language Specific Button Names for RMC
    public static final String BUTTON_RMCTAB_SELECTED_IMG = "/report_mychanges_selected.jpg";
    public static final String BUTTON_RMCTAB_UNSELECTED_IMG = "/report_mychanges_deselected.jpg";
    public static final String BUTTON_RMCTAB = "BUTTON_RMCTAB";
    public static final String BUTTON_RMCTAB_SELECTED_ALT = "40171";
    public static final String BUTTON_RMCTAB_UNSELECTED_ALT = "40171";
    public static final String BUTTON_REPORTMYCHANGES = "BUTTON_REPORTMYCHANGES";

    // IN-PreWork EDM Changes
    public static final String BUTTON_VIEW_AND_SUBMIT_PROOFS = "BUTTON_VIEW_AND_SUBMIT_PROOFS";
    public static final String BUTTON_VIEW_AND_SUBMIT_PROOFS_IMG = "/button_view_and_submit_proofs.jpg";
    public static final String BUTTON_VIEW_AND_SUBMIT_PROOFS_ALT = "46000";
    public static final String BUTTON_UPLOAD = "BUTTON_UPLOAD";
    public static final String BUTTON_UPLOAD_IMG = "/button_upload.jpg";
    public static final String BUTTON_UPLOAD_ALT = "70036";
    
    // Change Email Notification changes
    public static final String BUTTON_EMAIL_RESEND = "BUTTON_EMAIL_RESEND";
    public static final String BUTTON_EMAIL_VERIFY = "BUTTON_EMAIL_VERIFY";
    
    public static final String BUTTON_EMAIL_RESEND_IMG = "/button_email_resend.png";
    public static final String BUTTON_EMAIL_VERIFY_IMG = "/button_email_verify.png";
    
    public static final String BUTTON_EMAIL_RESEND_ALT = "810100559";
    public static final String BUTTON_EMAIL_VERIFY_ALT = "810100558";
    
    public static final String BUTTON_ADD_PERSON = "BUTTON_ADD_PERSON";
    public static final String BUTTON_ADD_PERSON_IMG = "/button_add_person.png";
    public static final String BUTTON_ADD_PERSON_ALT = "800110065";
    
    public static final String BUTTON_SUBMIT_CC_SCREENER = "BUTTON_SUBMIT_CC_SCREENER";
    public static final String BUTTON_SUBMIT_CC_SCREENER_IMG = "/button_submit_cc_screener.png";
    public static final String BUTTON_SUBMIT_CC_SCREENER_ALT = "3011126";

    public static final String CANCEL_CHANGES_LINK_IMG = "/cancel_changes_hyperlink.gif";
    public static final String CANCEL_CHANGES_LINK = "CANCEL_CHANGES_LINK";
    public static final String CANCEL_CHANGES_LINK_ALT = "40172";

    public static final String EDIT_LINK_IMG = "/edit_hyperlink.gif";
    public static final String EDIT_LINK = "EDIT_LINK";
    public static final String EDIT_LINK_ALT = "40173";

    public static final String ERASE_CHANGES_LINK_IMG = "/erase_changes_hyperlink.gif";
    public static final String ERASE_CHANGES_LINK = "ERASE_CHANGES_LINK";
    public static final String ERASE_CHANGES_LINK_ALT = "800006";

    // "Undo Change"

    public static final String ERASE_JOB_LINK_IMG = "/erase_job_hyperlink.gif";
    public static final String ERASE_JOB_LINK = "ERASE_JOB_LINK";
    public static final String ERASE_JOB_LINK_ALT = "40175";

    public static final String BUTTON_PRINT_CHANGE_REPORT_IMG = "/button_print_changereport.jpg";
    public static final String BUTTON_PRINT_CHANGE_REPORT = "BUTTON_PRINT_CHANGE_REPORT";
    public static final String BUTTON_PRINT_CHANGE_REPORT_ALT = "40176";

    public static final String BUTTON_DELETE_IMG = "/button_delete.gif";
    public static final String BUTTON_DELETE = "BUTTON_DELETE";
    public static final String BUTTON_DELETE_ALT = "40177";

    // Common Images Button Names for AFB
    public static final String ICON_EMPTY_CHECKBOX = "ICON_EMPTY_CHECKBOX";

    // Common Images Button Names
    public static final String BLUE_ARCH = "BLUE_ARCH";
    public static final String FEMALE_LARGE = "FEMALE_LARGE";
    public static final String GETACROBATREADER = "GETACROBATREADER";
    public static final String HEADING_ACCESS = "HEADING_ACCESS";
    public static final String ICON_CHECK = "ICON_CHECK";
    public static final String ICON_ERROR = "ICON_ERROR";
    public static final String ICON_WARNING = "ICON_WARNING";
    public static final String ICON_MESSAGE = "ICON_MESSAGE";
    public static final String KEYBOARD = "KEYBOARD";
    public static final String LOGO = "LOGO";
    public static final String MOUSE = "MOUSE";
    public static final String DEMOGRAPHICS = "DEMOGRAPHICS";
    public static final String PERSON_LARGE = "PERSON_LARGE";
    public static final String PERSON_SMALL = "PERSON_SMALL";
    public static final String PERSON_WOMAN_SMALL = "PERSON_WOMAN_SMALL";
    public static final String PROGRESS_BAR = "PROGRESS_BAR";
    public static final String PROGRESS_BAR_DARK = "PROGRESS_BAR_DARK";
    public static final String PROGRESS_BAR_LEFT = "PROGRESS_BAR_LEFT";
    public static final String PROGRESS_BAR_LIGHT = "PROGRESS_BAR_LIGHT";
    public static final String PROGRESS_BAR_LINE = "PROGRESS_BAR_LINE";
    public static final String PROGRESS_BAR_RIGHT = "PROGRESS_BAR_RIGHT";
    public static final String PROGRESS_BAR_RIGHT_100 = "PROGRESS_BAR_RIGHT_100";
    public static final String RULER = "RULER";
    public static final String SPACER = "SPACER";
    public static final String STATEOFWI = "STATEOFWI";
    public static final String PROCESSING_ANIMATED = "PROCESSING_ANIMATED";

    // Common Images Button Names for AFB
    public static final String ICON_EMPTY_CHECKBOX_IMG = "/empty_check_box.jpg";

    // Start of VaCMS - Addition of new images
    public static final String BUTTON_ACTIVITY_IMG = "/button_activity.jpg";
    public static final String BUTTON_PARENT_OR_CHILD_INFORMATION_IMG = "/button_parent_or_child_information.jpg";
    // Start of VaCMS - Addition of new images

    // Language Specific Images.
    public static final String BUTTON_APPLICATION_IMG = "/button_application.gif";
    public static final String BUTTON_APPLY_IMG = "/button_apply.jpeg";
    public static final String BUTTON_APPROVED_ACTIVITY_IMG = "/button_approved_activity.png";
    public static final String BUTTON_BEGIN_ACCESS_EN_IMG = "/button_begin_access_en.gif";
    public static final String BUTTON_BEGIN_ACCESS_ES_IMG = "/button_begin_access_es.gif";
    public static final String BUTTON_BENEFITCHECK_IMG = "/button_benefitcheck.jpeg";
    public static final String BUTTON_CALCULATE_IMG = "/button_calculate.gif";
    public static final String BUTTON_BQ_COMMENTS_IMG = "/button_bq_comments.gif";
    public static final String BUTTON_CALCULATOR_IMG = "/button_calculator.gif";
    public static final String BUTTON_CHILD_EXPENSES_IMG = "/button_child_expenses.gif";
    public static final String BUTTON_COMMENTS_IMG = "/button_comments.gif";
    public static final String BUTTON_CONTACT_SELECTED_IMG = "/button_contact_selected.jpeg";
    public static final String BUTTON_CONTACT_UNSELECTED_IMG = "/button_contact_unselected.jpeg";
    public static final String BUTTON_DETAIL_IMG = "/button_details.jpg";
    public static final String BUTTON_DETAILS_QUESTIONS_SELECTED_IMG = "/button_details_questions_selected.jpeg";
    public static final String BUTTON_DETAILS_QUESTIONS_UNSELECTED_IMG = "/button_details_questions_unselected.jpeg";
    public static final String BUTTON_DISABILITY_IMG = "/button_disability.gif";
    public static final String BUTTON_HEALTH_NEEDS_IMG = "/button_health_needs.gif";
    public static final String BUTTON_HELP_IMG = "/button_help.gif";
    public static final String BUTTON_HISTORY_SELECTED_IMG = "/button_history_selected.jpeg";
    public static final String BUTTON_HISTORY_UNSELECTED_IMG = "/button_history_unselected.jpeg";
    public static final String BUTTON_MYACCESS_FOLDER_SELECTED_IMG = "/button_filesHistory_selected.jpg";
    public static final String BUTTON_MYACCESS_FOLDER_UNSELECTED_IMG = "/button_filesHistory_unselected.jpg";
    public static final String BUTTON_HOUSING_EXPENSES_IMG = "/button_housing_expenses.gif";
    public static final String BUTTON_INCOME_IMG = "/button_income.gif";
    public static final String BUTTON_LEARN_MORE_IMG = "/button_learn_more.gif";
    public static final String BUTTON_MARRIAGES_IMG = "/button_marriages.gif";
    public static final String BUTTON_PRINT_MY_INFORMATION_IMG = "/button_print_my_information.png";
    public static final String BUTTON_MEDICAL_EXPENSES_IMG = "/button_medical_expenses.gif";
    public static final String BUTTON_NURSING_CARE_IMG = "/button_nursing_care.png";
    public static final String BUTTON_MEDICARE_IMG = "/button_medicare.gif";
    public static final String BUTTON_MYACCESS_WELCOME_SELECTED_IMG = "/button_myaccess_selected.jpeg";
    public static final String BUTTON_MYACCESS_WELCOME_UNSELECTED_IMG = "/button_myaccess_unselected.jpeg";
    public static final String BUTTON_NAME_AGE_GENDER_IMG = "/button_name_age_gender.gif";
    public static final String BUTTON_NEW_HELP_IMG = "/button_new_help.jpg";
    public static final String BUTTON_NEXT_IMG = "/button_next.gif";
    public static final String BUTTON_ONE_PAGE_FORM_IMG = "/button_one_page_form.gif";
    public static final String BUTTON_PARENTS_OR_CHILDREN_IMG = "/button_parents_or_children.gif";
    public static final String BUTTON_PREGNANCY_IMG = "/button_pregnancy.gif";
    public static final String BUTTON_HEALTH_INSURANCE_IMG = "/button_health_insurance.gif";
    public static final String BUTTON_HEALTH_INSURANCE_ALT = "3018250";
    public static final String BUTTON_PREVIOUS_IMG = "/button_previous.gif";
    public static final String BUTTON_PRINT_IMG = "/button_print.jpg";
    public static final String BUTTON_PRINT_INFORMATION_IMG = "/button_print_information.gif";
    public static final String BUTTON_QUESTIONS_IMG = "/button_questions.jpeg";
    public static final String BUTTON_RMC_IMG = "/button_rmc.jpg";
    public static final String BUTTON_RESOURCES_IMG = "/button_resources.gif";
    public static final String BUTTON_SCREENER_IMG = "/button_screener.jpeg";
    public static final String BUTTON_START_IMG = "/button_start.gif";
    public static final String BUTTON_STOP_IMG = "/button_stop.gif";
    public static final String BUTTON_SUBMIT_IMG = "/button_submit.gif";
    public static final String BUTTON_TOP_IMG = "/button_top.gif";
    public static final String BUTTON_WHAT_BRING_IMG = "/button_what_bring.gif";

    public static final String BUTTON_CREATE_ACCOUNT_IMG = "/button_create_account.jpeg";
    public static final String BUTTON_BACK_TO_MYACCESS_IMG = "/button_cancel_my_changes.png"; 
    public static final String BUTTON_CLICK_HERE_IMG = "/button_click_here.gif";

    public static final String BUTTON_LOGIN_IMG = "/login.png";
    public static final String BUTTON_LOGIN2_IMG = "/login_button.png";
    public static final String BUTTON_UPDATE_ACCOUNT_IMG = "/button_update_account.gif";
    public static final String BUTTON_RECOVERY_ACCOUNT_IMG = "/button_recovery_account.gif";
    public static final String BUTTON_CONTINUE_IMG = "/button_continue.png";
    public static final String BUTTON_CANCEL_IMG = "/button_cancel.gif";
    public static final String BUTTON_LOGOUT_IMG = "/button_logout.gif";

    public static final String BUTTON_BACK_IMG = "/button_back.gif";
    public static final String BUTTON_WORKER_LOGIN_IMG = "/button_worker_login.jpg";
    public static final String BUTTON_NEXT1_IMG = "/button_next1.jpg";
    public static final String BUTTON_GO_ORANGE_IMG = "/button_go_orange.png";
    public static final String BUTTON_CREATE_IMG = "/button_create.png";
    public static final String BUTTON_DELETE_RED_IMG = "/delete.png";
    public static final String BUTTON_END_CASE_IMG = "/button_end_case.gif";
    public static final String BUTTON_BACK1_IMG = "/button_back1.jpg";
    public static final String BUTTON_SUBMIT1_IMG = "/button_submit1.jpg";
    public static final String BUTTON_APPLY_ONLINE_IMG = "/button_applyonline.jpg";
    public static final String BUTTON_GO_IMG = "/button_sub_go.gif";
    public static final String BUTTON_RETURN_TO_ACCESS_HOME_IMG = "/button_return_to_access_home.gif";
    public static final String BUTTON_REPORTMYCHANGES_IMG = "/button_reportmychanges.jpg";
    public static final String BUTTON_LOOKUP_IMG = "/button_lookup.png";
    // Language Specific Images for AFB
    public static final String BUTTON_START_NEW_APPLICATION_IMG = "/startnew_button.jpg";
    public static final String BUTTON_KEEP_WORKING_IMG = "/keepwork_button.jpg";
    public static final String BUTTON_APPLICATION_STATUS_IMG = "/appstatus_button.jpg";
    public static final String BUTTON_VIEW_IMG = "/button_view.gif";

    public static final String BUTTON_START_AFB_IMG = "/start_001.jpg";
    public static final String BUTTON_START_GRAY_IMG = "/start_002.jpg";
    public static final String BUTTON_START_AFB_NEW_IMG = "/start_003.jpg";
    public static final String BUTTON_PEOPLE_IMG = "/people_001.jpg";
    public static final String BUTTON_PEOPLE_GRAY_IMG = "/people_002.jpg";
    public static final String BUTTON_PEOPLE_NEW_IMG = "/people_003.jpg";
    public static final String BUTTON_JOBINCOME_IMG = "/jobincome_001.jpg";
    public static final String BUTTON_JOBINCOME_GRAY_IMG = "/jobincome_002.jpg";
    public static final String BUTTON_JOBINCOME_NEW_IMG = "/jobincome_003.jpg";
    public static final String BUTTON_OTHERINCOME_IMG = "/otherincome_001.jpg";
    public static final String BUTTON_OTHERINCOME_GRAY_IMG = "/otherincome_002.jpg";
    public static final String BUTTON_OTHERINCOME_NEW_IMG = "/otherincome_003.jpg";
    public static final String BUTTON_HOUSING_BILLS_IMG = "/housingbills_001.jpg";
    public static final String BUTTON_HOUSING_BILLS_GRAY_IMG = "/housingbills_002.jpg";
    public static final String BUTTON_HOUSING_BILLS_NEW_IMG = "/housingbills_003.jpg";
    public static final String BUTTON_OTHERBILLS_IMG = "/otherbills_001.jpg";
    public static final String BUTTON_OTHERBILLS_GRAY_IMG = "/otherbills_002.jpg";
    public static final String BUTTON_OTHERBILLS_NEW_IMG = "/otherbills_003.jpg";
    public static final String BUTTON_FINISH_IMG = "/finish_001.jpg";
    public static final String BUTTON_FINISH_GRAY_IMG = "/finish_002.jpg";
    public static final String BUTTON_FINISH_NEW_IMG = "/finish_003.jpg";
    public static final String BUTTON_SUBMIT_AFB_IMG = "/submit_001.jpg";
    public static final String BUTTON_SUBMIT_GRAY_IMG = "/submit_002.jpg";
    public static final String BUTTON_SUBMIT_NEW_IMG = "/submit_003.jpg";
    public static final String BUTTON_PRINT_MY_APPLICATION_IMG = "/printapp_button.jpg";
    public static final String BUTTON_PRINT_NOTICE_IMG = "/printnotice_button.gif";
    public static final String BUTTON_PRINT_APPLICATION_SUMMARY_IMG = "/printapplicationsummary_button.gif";
    public static final String BUTTON_PARTNERS_PROVIDERS_IMG = "/Partners_Button.jpg";
    public static final String BUTTON_EMPLOYERS_IMG = "/Employers_ Button.jpg";

    public static final String BUTTON_ARROW_BACK_IMG = "/arrow_back_button.jpg";
    public static final String BUTTON_SAVE_AND_EXIT_IMG = "/save_exit_button.jpg";
    public static final String BUTTON_SAVE_IMG = "/button_save.jpg";
    public static final String BUTTON_ARROW_NEXT_IMG = "/arrow_next_button.jpg";
    public static final String BUTTON_ADD_IMG = "/button_add_orange.png";
    public static final String BUTTON_TYPES_OF_PROOF_IMG = "/proof_types_button.jpg";

    // Client security
    public static final String BUTTON_TAKE_ME_BACK_TO_MY_SESSION_IMG = "/button_session_back.gif";

    public static final String BUTTON_HEALTH_SURVEY_IMG = "/health_survey_button.jpg";
    public static final String BUTTON_CLAIMS_INFO_TAB_SELECTED_IMG = "/button_claims_info_selected.gif";
    public static final String BUTTON_CLAIMS_INFO_TAB_UNSELECTED_IMG = "/button_claims_info_unselected.gif";
    public static final String BUTTON_REQUEST_ID_CARDS_TAB_SELECTED_IMG = "/button_request_id_selected.gif";
    public static final String BUTTON_REQUEST_ID_CARDS_TAB_UNSELECTED_IMG = "/button_request_id_unselected.gif";
    public static final String BUTTON_CLAIMS_INFO_IMG = "/button_claims_info.gif";
    public static final String BUTTON_REQUEST_ID_CARDS_IMG = "/button_request_id.gif";
    // edsp cp - added for client warning screen
    public static final String BUTTON_ACCEPT_IMG = "/button_accept.gif";
    public static final String BUTTON_DO_NOT_ACCEPT_IMG = "/button_do_not_accept.gif";
    // edsp cp - added for client warning screen
    public static final String BUTTON_UPDATE_QUESTIONS_IMG = "/button_update_questions.jpg";
    public static final String BUTTON_UPDATE_INFO_IMG = "/button_update_info.jpg";
    public static final String BUTTON_RESET_PASSWORD_IMG = "/button_reset.jpg";
    public static final String BUTTON_BLUE_RESET_PASSWORD_IMG = "/button_reset_password3.png";

    // Language Specific - Images - Alternate Text.
    public static final String BUTTON_APPLICATION_ALT = "282";
    public static final String BUTTON_APPLY_ALT = "15079";
    public static final String BUTTON_APPROVED_ACTIVITY_ALT = "30200114";
    public static final String BUTTON_BEGIN_ACCESS_EN_ALT = "174";
    public static final String BUTTON_BEGIN_ACCESS_ES_ALT = "360";
    public static final String BUTTON_BENEFITCHECK_ALT = "15078";
    public static final String BUTTON_BQ_COMMENTS_ALT = "15066";
    public static final String BUTTON_CALCULATE_ALT = "10086";
    public static final String BUTTON_CALCULATOR_ALT = "10086";
    public static final String BUTTON_CHILD_EXPENSES_ALT = "275";
    public static final String BUTTON_COMMENTS_ALT = "10043";
    public static final String BUTTON_CONTACT_SELECTED_ALT = "15075";
    public static final String BUTTON_CONTACT_UNSELECTED_ALT = "15075";
    public static final String BUTTON_DETAIL_ALT = "278";
    public static final String BUTTON_DETAILS_QUESTIONS_SELECTED_ALT = "15074";
    public static final String BUTTON_DETAILS_QUESTIONS_UNSELECTED_ALT = "15074";
    public static final String BUTTON_DISABILITY_ALT = "273";
    public static final String BUTTON_HEALTH_NEEDS_ALT = "357";
    public static final String BUTTON_HELP_ALT = "10047";
    public static final String BUTTON_HISTORY_SELECTED_ALT = "15076";
    public static final String BUTTON_HISTORY_UNSELECTED_ALT = "15076";
    public static final String BUTTON_MYACCESS_FOLDER_SELECTED_ALT = "15094";
    public static final String GREEN_CIRCLE_ICON_ALT = "16000";
    public static final String BUTTON_MYACCESS_FOLDER_UNSELECTED_ALT = "15094";
    public static final String BUTTON_HOUSING_EXPENSES_ALT = "276";
    public static final String BUTTON_INCOME_ALT = "274";
    public static final String BUTTON_LEARN_MORE_ALT = "281";
    public static final String BUTTON_MARRIAGES_ALT = "271";
    public static final String BUTTON_ACTIVITY_ALT = "998";
    public static final String BUTTON_PARENT_OR_CHILD_INFORMATION_ALT = "999";
    public static final String BUTTON_PRINT_MY_INFORMATION_ALT = "30200102";
    public static final String BUTTON_MEDICAL_EXPENSES_ALT = "277";
    public static final String BUTTON_NURSING_CARE_ALT = "30200101";
    public static final String BUTTON_MEDICARE_ALT = "358";
    public static final String BUTTON_MYACCESS_WELCOME_SELECTED_ALT = "15071";
    public static final String BUTTON_MYACCESS_WELCOME_UNSELECTED_ALT = "15071";
    public static final String BUTTON_NAME_AGE_GENDER_ALT = "269";
    public static final String BUTTON_NEW_HELP_ALT = "10047";
    public static final String BUTTON_NEXT_ALT = "10046";
    public static final String BUTTON_ONE_PAGE_FORM_ALT = "280";
    public static final String BUTTON_PARENTS_OR_CHILD_INFORMATION_ALT = "270";
    public static final String BUTTON_PREGNANCY_ALT = "272";
    public static final String BUTTON_PREVIOUS_ALT = "10044";
    public static final String BUTTON_PRINT_ALT = "15067";
    public static final String BUTTON_PRINT_INFORMATION_ALT = "283";
    public static final String BUTTON_QUESTIONS_ALT = "15080";
    public static final String BUTTON_RMC_ALT = "15098";
    public static final String BUTTON_RESOURCES_ALT = "359";
    public static final String BUTTON_SCREENER_ALT = "15077";
    public static final String BUTTON_START_ALT = "174";
    public static final String BUTTON_STOP_ALT = "10045";
    public static final String BUTTON_SUBMIT_ALT = "10039";
    public static final String BUTTON_TOP_ALT = "10048";
    public static final String BUTTON_WHAT_BRING_ALT = "279";
    public static final String BUTTON_CREATE_ACCOUNT_ALT = "11040";
    public static final String BUTTON_BACK_TO_MYACCESS_ALT = "15073";
    public static final String BUTTON_CLICK_HERE_ALT = "20163";
    public static final String BUTTON_LOGIN_ALT = "15068";
    public static final String BUTTON_LOGIN2_ALT = "15168";
    public static final String BUTTON_UPDATE_ACCOUNT_ALT = "15085";
    public static final String BUTTON_RECOVERY_ACCOUNT_ALT = "15087";
    public static final String BUTTON_CONTINUE_ALT = "15081";
    public static final String BUTTON_CANCEL_ALT = "10224";
    public static final String BUTTON_LOGOUT_ALT = "10225";
    public static final String BUTTON_BACK_ALT = "500005001";
    public static final String BUTTON_WORKER_LOGIN_ALT = "15070";
    public static final String BUTTON_NEXT1_ALT = "15084";
    public static final String BUTTON_GO_ORANGE_ALT = "15084";
    public static final String BUTTON_CREATE_ALT = "11039";
    public static final String BUTTON_DELETE_RED_ALT = "40117";
    public static final String BUTTON_END_CASE_ALT = "15083";
    public static final String BUTTON_BACK1_ALT = "15086";
    public static final String BUTTON_SUBMIT1_ALT = "10039";
    public static final String BUTTON_APPLY_ONLINE_ALT = "10094";
    public static final String BUTTON_VIEW_ALT = "15095";
    public static final String BUTTON_GO_ALT = "15093";
    public static final String BUTTON_RETURN_TO_ACCESS_HOME_ALT = "32306";
    public static final String BUTTON_REPORTMYCHANGES_ALT = "15098";
    public static final String BUTTON_GOTO_NEW_SESSION_ALT = "10226";
    public static final String BUTTON_TAKE_ME_BACK_TO_MY_SESSION_ALT = "10225";
    public static final String BUTTON_BLUE_RESET_PASSWORD_ALT = "30200242";
    public static final String BUTTON_LOOKUP_ALT = "800100541";
    // edsp cp - Alt text added for client warning screen
    public static final String BUTTON_ACCEPT_ALT = "3018244";
    public static final String BUTTON_DO_NOT_ACCEPT_ALT = "3018245";
    // edsp cp - added for client warning screen
    public static final String BUTTON_UPDATE_QUESTIONS_ALT = "30189011";
    public static final String BUTTON_UPDATE_INFO_ALT = "30189025";
    public static final String BUTTON_RESET_PASSWORD_ALT = "30189012";
    // Language Specific - Images - Alternate Text for AFB.
    public static final String BUTTON_START_NEW_APPLICATION_ALT = "30400";
    public static final String BUTTON_KEEP_WORKING_ALT = "30401";
    public static final String BUTTON_APPLICATION_STATUS_ALT = "30402";

    public static final String BUTTON_START_AFB_ALT = "30403";
    public static final String BUTTON_START_AFB_NEW_ALT = "30403";
    public static final String BUTTON_PEOPLE_ALT = "30404";
    public static final String BUTTON_PEOPLE_NEW_ALT = "30404";
    public static final String BUTTON_JOBINCOME_ALT = "30405";
    public static final String BUTTON_JOBINCOME_NEW_ALT = "30405";
    public static final String BUTTON_OTHERINCOME_ALT = "30406";
    public static final String BUTTON_OTHERINCOME_NEW_ALT = "30406";
    public static final String BUTTON_HOUSING_BILLS_ALT = "30407";
    public static final String BUTTON_HOUSING_BILLS_NEW_ALT = "30407";
    public static final String BUTTON_OTHERBILLS_ALT = "30408";
    public static final String BUTTON_OTHERBILLS_NEW_ALT = "30408";
    public static final String BUTTON_FINISH_ALT = "30409";
    public static final String BUTTON_FINISH_NEW_ALT = "30409";
    public static final String BUTTON_SUBMIT_AFB_ALT = "30410";
    public static final String BUTTON_SUBMIT_NEW_ALT = "30410";
    public static final String BUTTON_PRINT_MY_APPLICATION_ALT = "30415";
    public static final String BUTTON_PRINT_NOTICE_ALT = "50246";
    public static final String BUTTON_PRINT_APPLICATION_SUMMARY_ALT = "50247";
    public static final String BUTTON_PARTNERS_PROVIDERS_ALT = "50290";
    public static final String BUTTON_EMPLOYERS_ALT = "50291";

    public static final String BUTTON_ARROW_BACK_ALT = "30411";
    public static final String BUTTON_SAVE_AND_EXIT_ALT = "30412";
    public static final String BUTTON_SAVE_ALT = "30412";
    public static final String BUTTON_ARROW_NEXT_ALT = "30413";
    public static final String BUTTON_ADD_ALT = "30414";

    public static final String BUTTON_TYPES_OF_PROOF_ALT = "30536";
    public static final String OTHER_RESOURCE_TYPE = "ORTY";
    public static final String BUTTON_HEALTH_SURVEY_ALT = "28760";
    public static final String BUTTON_CLAIMS_INFO_TAB_SELECTED_ALT = "20240";
    public static final String BUTTON_CLAIMS_INFO_TAB_UNSELECTED_ALT = "20240";
    public static final String BUTTON_REQUEST_ID_CARDS_TAB_SELECTED_ALT = "20239";
    public static final String BUTTON_REQUEST_ID_CARDS_TAB_UNSELECTED_ALT = "20239";
    public static final String BUTTON_CLAIMS_INFO_ALT = "20242";
    public static final String BUTTON_REQUEST_ID_CARDS_ALT = "20241";

    // Common Images.
    public static final String ACCESS_LOGO_IMG = "/cp_logo.jpg";
    public static final String ICON_CHECK_PDF_IMG = "/icon_check.gif";
    public static final String BOTTOM_LEFT_CORNER = "/bottom_left_corner.jpg";
    public static final String BOTTOM_RIGHT_CORNER = "/bottom_right_corner.jpg";
    public static final String BLUE_ARCH_IMG = "/blue_arch.gif";
    public static final String FEMALE_ADULT_GREY_IMG = "/female_adult_grey.gif";
    public static final String FEMALE_CHILD_GREY_IMG = "/female_child_grey.gif";
    public static final String FEMALE_LARGE_IMG = "/female_large.gif";
    public static final String GETACROBATREADER_IMG = "/getacrobatreader.gif";
    public static final String HEADING_ACCESS_IMG = "/heading_access.gif";
    public static final String ICON_CHECK_IMG = "/icon_check.gif";
    public static final String ICON_ERROR_IMG = "/icon_error.gif";
    public static final String ICON_MESSAGE_IMG = "/icon_message.gif";
    public static final String ICON_WARNING_IMG = "/icon_warning.gif";
    public static final String KEYBOARD_IMG = "/keyboard.gif";
    public static final String LOGO_IMG = "/logo.gif";
    public static final String MALE_ADULT_GREY_IMG = "/male_adult_grey.gif";
    public static final String MALE_CHILD_GREY_IMG = "/male_child_grey.gif";
    public static final String MOUSE_IMG = "/mouse.gif";
    public static final String DEMOGRAPHICS_IMG = "/demographics.png";
    public static final String PERSON_LARGE_IMG = "/person_large.gif";
    public static final String PERSON_SMALL_IMG = "/person_small.gif";
    public static final String PERSON_WOMAN_SMALL_IMG = "/person_woman_small.gif";
    public static final String PROGRESS_BAR_IMG = "/progress_bar.gif";
    public static final String PROGRESS_BAR_DARK_IMG = "/progress_bar_dark.gif";
    public static final String PROGRESS_BAR_LEFT_IMG = "/progress_bar_left.gif";
    public static final String PROGRESS_BAR_LIGHT_IMG = "/progress_bar_light.gif";
    public static final String PROGRESS_BAR_LINE_IMG = "/progress_bar_line.gif";
    public static final String PROGRESS_BAR_RIGHT_IMG = "/progress_bar_right.gif";
    public static final String PROGRESS_BAR_RIGHT_100_IMG = "/progress_bar_right_100.gif";
    public static final String RULER_IMG = "/ruler.gif";
    public static final String SPACER_IMG = "/spacer.gif";
    public static final String ENV_DEV_IMG = "/envir_development.gif";
    public static final String ENV_SYS_IMG = "/envir_systems.gif";
    public static final String ENV_UAT_IMG = "/envir_acceptance.gif";
    public static final String ENV_TRN_IMG = "/envir_training.gif";
    public static final String ENV_DEV_BG_IMG = "/bg_watermk_development.gif";
    public static final String ENV_SYS_BG_IMG = "/bg_watermk_systems.gif";
    public static final String ENV_UAT_BG_IMG = "/bg_watermk_acceptance.gif";
    public static final String ENV_TRN_BG_IMG = "/bg_watermk_training.gif";
    public static final String STATEOFWI_IMG = "/stateofwi.gif";
    public static final String TOP_LEFT_CORNER = "/top_left_corner.jpg";
    public static final String TOP_RIGHT_CORNER = "/top_right_corner.jpg";
    public static final String PROCESSING_ANIMATED_IMG_EN = "/processing_animated_mibridges_en.gif";

    // Added to show the Spanish processing image
    public static final String PROCESSING_ANIMATED_IMG_ES = "/processing_animated_mibridges_sp.gif";

    // Common Images ALT text for AFB
    public static final String ICON_EMPTY_CHECKBOX_ALT = "10089";

    // Common Images. Alternate text
    public static final String BLUE_ARCH_ALT = "";
    public static final String FEMALE_LARGE_ALT = "10056";
    public static final String GETACROBATREADER_ALT = "250";
    public static final String HEADING_ACCESS_ALT = "10058";
    public static final String ICON_CHECK_ALT = "10059";
    public static final String ICON_ERROR_ALT = "144";
    public static final String ICON_WARNING_ALT = "145";
    public static final String ICON_MESSAGE_ALT = "146";
    public static final String KEYBOARD_ALT = "255";
    public static final String LOGO_ALT = "10060";
    public static final String MOUSE_ALT = "254";
    public static final String DEMOGRAPHICS_ALT = "10054";
    public static final String PERSON_LARGE_ALT = "10054";
    public static final String PERSON_SMALL_ALT = "10055";
    public static final String PERSON_WOMAN_SMALL_ALT = "10057";
    public static final String PROGRESS_BAR_ALT = "29";
    public static final String PROGRESS_BAR_DARK_ALT = "";
    public static final String PROGRESS_BAR_LEFT_ALT = "29";
    public static final String PROGRESS_BAR_LIGHT_ALT = "";
    public static final String PROGRESS_BAR_LINE_ALT = "";
    public static final String PROGRESS_BAR_RIGHT_ALT = "";
    public static final String PROGRESS_BAR_RIGHT_100_ALT = "";
    public static final String RULER_ALT = "10061";
    public static final String SPACER_ALT = "";
    public static final String ENV_DEV_ALT = "10090";
    public static final String ENV_SYS_ALT = "10091";
    public static final String ENV_UAT_ALT = "10092";
    public static final String ENV_TRN_ALT = "10093";
    public static final String STATEOFWI_ALT = "10062";
    public static final String SKIP_PAGE_ALT = "10064";
    public static final String PROCESSING_ANIMATED_ALT = "";

    // Url
    public static final String FS_WHAT_TO_BRING = "FSW";
    public static final String WHEAP_WHAT_TO_BRING = "WHW";
    public static final String FS_ONE_PAGE_FORM = "FSA";
    public static final String FS_LEARN_MORE = "FSL";
    public static final String WHEAP_LEARN_MORE = "WHL";
    public static final String LTC_LEARN_MORE = "LTL";
    public static final String FMA_APPLICATION = "FMA";
    public static final String FAM_LEARN_MORE = "FML";
    public static final String BC_LEARN_MORE = "BCL";
    public static final String SC_APPLICATION = "SCA";
    public static final String SC_LEARN_MORE = "SCL";
    public static final String MPD_LEARN_MORE = "MPD";
    public static final String MPD_APPLICATION = "MPA";
    public static final String GET_ACROBAT_READER = "ACR";
    public static final String TAX_LEARN_MORE = "TXL";
    public static final String EBD_APPLICATION = "EBA";
    public static final String EBD_LEARN_MORE = "EBL";
    public static final String AUT_APPLICATION = "AUT";
    public static final String TEF_LEARN_MORE = "TFL";
    public static final String SBL_LEARN_MORE = "SML";
    public static final String SFS_LEARN_MORE = "SFL";
    public static final String WIC_LEARN_MORE = "WCL";
    public static final String EBS_LEARN_MORE = "EBS";
    public static final String MEDICAID_ADDENDUM = "MAA";
    public static final String DIS_RES_CENTER = "DRC";
    public static final String COM_OPT_COORDINATOR = "COM";

    public static final String AFTER_HEADER_OTHER = "after_header_other";
    public static final String HEADER = "header";
    public static final String FOOTER = "footer";
    public static final String AFTER_HEADER = "after_header";
    public static final String BEFORE_FOOTER_OTHER = "before_footer_other";
    public static final String CUSTOM_AFTER_HEADER = "custom_after_header";

    // Menu Items
    public static final int MENU_ITEM_ENABLED = 1;
    public static final int MENU_ITEM_DISABLED = 2;
    public static final int MENU_ITEM_SELECTED = 3;
    public static final int MENU_ITEM_CURRENT = 4;
    public static final String MENU_ITEM_FINISH_ENABLED = "menu_item_finish_enabled";

    // Justin added new menu items
    public static final String MENU_ITEM_ASSETS = "assets";
    public static final String MENU_ITEM_ASSETS_ALT = "3011113"; // new language
    // =
    // "Resources"
    public static final String MENU_ITEM_OTHER_BENEFITS = "other_benefits";
    public static final String MENU_ITEM_OTHER_BENEFITS_ALT = "48003";

    public static final String MENU_ITEM_START = "start";
    public static final String MENU_ITEM_START_ALT = "3011116";
    public static final String MENU_ITEM_PEOPLE = "people";
    public static final String MENU_ITEM_PEOPLE_ALT = "3011117";
    public static final String MENU_ITEM_LIQUID_ASSETS = "liquid_assets";
    public static final String MENU_ITEM_LIQUID_ASSETS_ALT = "32368"; // new
    // language
    // =
    // "Liquid Resources"
    public static final String MENU_ITEM_OTHER_ASSETS = "other_assets";
    public static final String MENU_ITEM_OTHER_ASSETS_ALT = "3011119"; // new
    // language
    // =
    // "Other Resources"
    public static final String MENU_ITEM_JOB_INCOME = "job_income";
    public static final String MENU_ITEM_JOB_INCOME_ALT = "3011120";
    public static final String MENU_ITEM_OTHER_INCOME = "other_income";
    public static final String MENU_ITEM_OTHER_INCOME_ALT = "3011121";
    public static final String MENU_ITEM_HOUSING_BILLS = "housing_bills";
    public static final String MENU_ITEM_HOUSING_BILLS_ALT = "3011122";
    public static final String MENU_ITEM_OTHER_BILLS = "other_bills";
    public static final String MENU_ITEM_OTHER_BILLS_ALT = "3011123";
    public static final String MENU_ITEM_FINISH = "finish";
    public static final String MENU_ITEM_FINISH_ALT = "3011125";
    public static final String MENU_ITEM_SUBMIT = "submit";
    public static final String MENU_ITEM_SUBMIT_ALT = "3011126";
    public static final String MENU_ITEM_DEDUCTION = "deduction";
    public static final String MENU_ITEM_DEDUCTION_ALT = "3011124";
    // APP Menu Constants
    public static final String MENU_ITEM_INDIVIDUAL_INFORMATION = "individual_information";
    public static final String MENU_ITEM_INDIVIDUAL_INFORMATION_ALT = "50195";
    public static final String MENU_ITEM_CONTACT_INFORMATION = "contact_information";
    public static final String MENU_ITEM_CONTACT_INFORMATION_ALT = "50199";
    public static final String MENU_ITEM_INCOME_DETAILS = "income_details";
    public static final String MENU_ITEM_INCOME_DETAILS_ALT = "50252";
    public static final String MENU_ITEM_PROVIDER_SIGNATURE = "provider_signature";
    public static final String MENU_ITEM_PROVIDER_SIGNATURE_ALT = "50201";
    public static final String MENU_ITEM_CLIENT_SIGNATURE = "client_signature";
    public static final String MENU_ITEM_CLIENT_SIGNATURE_ALT = "50202";
    public static final String MENU_ITEM_RESULTS = "results";
    public static final String MENU_ITEM_RESULTS_ALT = "50203";
    public static final String MENU_ITEM_GETSTARTED = "GetStarted";
    public static final String MENU_ITEM_GETSTARTED_ALT = "3011111";
    public static final String MENU_ITEM_RESOURCES = "Resources";
    public static final String MENU_ITEM_RESOURCES_ALT = "3011113";
    public static final String MENU_ITEM_BILLS = "Bills";
    public static final String MENU_ITEM_INCOME = "Income";
    public static final String MENU_ITEM_FINISHSUBMIT = "FinishSubmit";
    public static final String MENU_ITEM_BILLS_ALT = "3011115";
    public static final String MENU_ITEM_INCOME_ALT = "3011114";
    public static final String MENU_ITEM_FINISHSUBMIT_ALT = "3011112";
    public static final String MENU_ITEM_OTHERINCOME = "OtherIncome";
    public static final String MENU_ITEM_OTHERINCOME_ALT = "3011121";
    public static final String MENU_ITEM_EMPLOYMENTINCOME = "EmploymentIncome";
    public static final String MENU_ITEM_EMPLOYMENTINCOME_ALT = "3011120";
    public static final String MENU_ITEM_HOUSINGBILLS_ALT = "3011122";
    public static final String MENU_ITEM_OTHERBILLS_ALT = "3011123";

    // APP USER ACCESS DETAILS PAGE CONSTANTS
    public static final String PE_PREGNANT_WOMEN = "Express Enrollment for Pregnant Women:";
    public static final String PE_CHILDREN = "Express Enrollment for Children:";
    public static final String APP_PRFL_UPDATE = "U";
    public static final String APP_PRFL_QUERY = "Q";
    public static final String APP_PRFL_NOACCESS = "N";
    public static final String PW_UPDATE = "1";
    public static final String PW_QUERY = "2";
    public static final String CH_UPDATE = "3";
    public static final String CH_QUERY = "4";
    public static final String ADMIN_PVLG = "5";
    public static final String SUP_ADMIN_PVLG = "6";
    public static final String PE_NOACCESS = "";
    public static final String USER_SEC_AUD_TRL_ACTION = "US";

    // APP SEND NEW PIN BATCH CONSTANTS
    public static final String APP_BATCH_LOCATION = "batchFileLocation";
    public static final String PIN_FOLDER = "pin";
    public static final String TXT_EXTN = ".txt";
    public static final String PIPE = "|";
    public static final String RECEIVE_MMIS_FILE_NAME = "receiveMMISFileName";
    public static final char GET_ACTION = '0';
    public static final char SEND_ACTION = '1';
    public static final char DELETE_ACTION = '2';
    public static final char CHECKFILEEXIST_ACTION = '3';

    // List View Image names
    public static final String ICON_PAGE_BACK_ALT = "15092";
    public static final String ICON_PAGE_BACK = "ICON_PAGE_BACK";
    public static final String ICON_RESULTSET_GO_ALT = "15093";
    public static final String ICON_RESULTSET_GO = "ICON_RESULTSET_GO";
    public static final String ICON_PAGE_NEXT_ALT = "15091";
    public static final String ICON_PAGE_NEXT = "ICON_PAGE_NEXT";

    public static final String LIST_VIEW_NAME = "LIST_VIEW_NAME";
    public static final String PAGING_COMMAND_NEXT = "1";
    public static final String PAGING_COMMAND_BACK = "2";

    // List View Images
    public static final String ICON_RESULTSET_GO_IMG = "/icon_resultset_go.gif";
    public static final String ICON_PAGE_BACK_IMG = "/pagingBack.jpg";
    public static final String ICON_PAGE_NEXT_IMG = "/pagingNext.jpg";
    public static final String ICON_PAGE_BACK_DISABLED_IMG = "/back-disabled.jpg";
    public static final String ICON_PAGE_NEXT_DISABLED_IMG = "/next-disabled.jpg";

    // Access Display Message names
    public static final String MESSAGE_TYPE_YELLOW = "Y";
    public static final String MESSAGE_TYPE_RED = "R";
    public static final String MESSAGE_TYPE_GREEN = "G";

    // Access 3.0
    public static final String FULLVIEW = "20";
    public static final String TARGETVIEW = "10";
    public static final String NOVIEW = "0";
    public static final String ELIGIBLE = "E%";
    public static final String INELIGIBLE = "I%";
    public static final String INDVINELIGIBLE = "X%";
    public static final String ACCESS_LEVEL_COLL = "ACCESS_LEVEL_COLL";
    public static final String TYPEOFVIEW = "TYPEOFVIEW";

    public static final String FOOD_SHARE = "FS";
    public static final String SER_SRV = "SE";
    public static final String SER_SRV_26 = "26";
    public static final String SER_SRV_27 = "27";
    public static final String SER_SRV_33 = "33";
    public static final String SER_SRV_63 = "63";
    public static final String SER_SRV_63A = "63A";
    public static final String SER_SRV_64 = "64";
    public static final String SER_SRV_65 = "65";
    public static final String SER_SRV_HEAT = "Heat";
    public static final String SER_SRV_ELEC = "Electric";
    public static final String SER_SRV_FUR = "Furnace Repair";
    // SER Energy Services Assistance
    public static final String SER_ELECTRICITYBILL = "EB";
    public static final String SER_SERHEAT = "HE";
    public static final String SER_ELECTRICDEPOSITORRECONNECTFEE = "ED";
    public static final String SER_DEPOSITHEATORRECONNECTFEE = "HD";
    public static final String SER_FURNACEREPAIR = "FR";
    // SER Energy Service sources
    public static final String SER_HEAT_ELECTRIC = "EL";
    public static final String SER_NATURAL_GAS = "NG";
    public static final String SER_DELIVERABLE_LPGAS = "LP";
    public static final String SER_FUELOIL = "FO";
    public static final String SER_WOOD = "WD";
    public static final String SER_COAL = "CL";
    public static final String SER_OTHER = "OT";
    public static final String SER_PYMT_SEQ_MONTH1 = "1";
    public static final String SER_PYMT_SEQ_MONTH2 = "2";
    public static final String SER_PYMT_SEQ_MONTH3 = "3";
    public static final String SER_PYMT_SEQ_MONTH4 = "4";
    public static final String SER_PYMT_SEQ_MONTH5 = "5";
    public static final String SER_PYMT_SEQ_MONTH6 = "6";
    public static final String PYMT_SEQ_MONTH1 = "MONTH1";
    public static final String PYMT_SEQ_MONTH2 = "MONTH2";
    public static final String PYMT_SEQ_MONTH3 = "MONTH3";
    public static final String PYMT_SEQ_MONTH4 = "MONTH4";
    public static final String PYMT_SEQ_MONTH5 = "MONTH5";
    public static final String PYMT_SEQ_MONTH6 = "MONTH6";
    public static final String HEALTH_CARE_M01 = "M01";
    public static final String HEALTH_CARE_M02 = "M02";
    public static final String HEALTH_CARE_M03 = "M03";
    public static final String HEALTH_CARE_M04 = "M04";
    public static final String HEALTH_CARE_M05 = "M05";
    public static final String HEALTH_CARE_M06 = "M06";
    public static final String HEALTH_CARE_M07 = "M07";
    public static final String HEALTH_CARE_M08 = "M08";
    public static final String HEALTH_CARE_M09 = "M09";
    public static final String HEALTH_CARE_M10 = "M10";
    public static final String HEALTH_CARE_M11 = "M11";
    public static final String HEALTH_CARE_M12 = "M12";
    public static final String HEALTH_CARE_M13 = "M13";
    public static final String HEALTH_CARE_M14 = "M14";
    public static final String HEALTH_CARE_M15 = "M15";
    public static final String HEALTH_CARE_M16 = "M16";
    public static final String HEALTH_CARE_M17 = "M17";
    public static final String HEALTH_CARE_M18 = "M18";
    public static final String HEALTH_CARE_M19 = "M19";
    public static final String HEALTH_CARE_M20 = "M20";
    public static final String HEALTH_CARE_M21 = "M21";
    public static final String HEALTH_CARE_M22 = "M22";
    public static final String HEALTH_CARE_M23 = "M23";
    public static final String HEALTH_CARE_M24 = "M24";
    public static final String HEALTH_CARE_M25 = "M25";

    public static final String CARETAKER_SUPPLEMENT = "CTS";
    public static final String SENIOR_CARE = "SC";
    public static final String USER_PIN_NUM = "USER_PIN_NUM";
    public static final String CAT_CD = "CAT_CD";
    public static final String SCAT_CD = "SCAT_CD";
    public static final String SCAT_SEQ_NUM = "SCAT_SEQ_NUM";
    public static final String GENERAL_QUESTIONS_LINK_HEADER = "GQ";
    public static final String COMMON_QUESTIONS_FMA_LINK_HEADER = "CQFMA";
    public static final String COMMON_QUESTIONS_FS_LINK_HEADER = "CQFS";
    public static final String COMMON_QUESTIONS_SC_LINK_HEADER = "CQSC";
    public static final String COMMON_QUESTIONS_CTS_LINK_HEADER = "CQCTS";

    // Case # and primary house hold
    public static final String USER_CASE_NUM = "userCaseNum";
    public static final String PRIMARY_PERSON_NAME = "primaryPersonName";
    // General Messages Constants
    public static final String CATEGORY_NAME = "CATEGORY_NAME";
    public static final String ELIG_BEGIN_DATE = "ELIG_BEGIN_DATE";
    public static final String PAYMENT_AMOUNT = "PAYMENT_AMOUNT";
    public static final String ELIG_END_DATE_MONTH_NAME = "ELIG_END_DATE_MONTH_NAME";
    public static final String ELIG_END_DATE = "ELIG_END_DATE";
    public static final String PIN_NAME = "PIN_NAME";
    public static final String COMPUTED_DATE = "COMPUTED_DATE";
    public static final String PAYMENT_TYPE = "PAYMENT_TYPE";
    public static final String MA_DDCT_BAL_AMT = "MA_DDCT_BAL_AMT";
    public static final String SC_BNFT_LVL_CD = "SC_BNFT_LVL_CD";
    public static final String PREV_SC_BNFT_L_CD = "PREV_SC_BNFT_L_CD";
    public static final String PREV_PAYMENT_AMOUNT = "PREV_PAYMENT_AMOUNT";
    public static final String FST_NAM = "FST_NAM";
    public static final String VFCN_DUE_DT = "VFCN_DUE_DT";
    public static final String EMPL_VFCN_DUE_DT = "EMPL_VFCN_DUE_DT";
    public static final String INS_VFCN_DUE_DT = "INS_VFCN_DUE_DT";

    public static final String ELIGIBILITY_CONFIRM = "A";
    public static final String ELIGIBILITY_UN_CONFIRM = "P";
    public static final String ELIGIBILITY_PSEUDO_CONFIRM = "Q";
    public static final String ELIGIBILITY_HISTORY = "9";

    // My Access Generate Message Constants.
    public static final String MESSAGE_SQL_G1 = "SQL_G1";
    public static final String MESSAGE_SQL_G2 = "SQL_G2";
    public static final String MESSAGE_SQL_G3 = "SQL_G3";
    public static final String MESSAGE_PEND_REVIEW = "PEND_REVIEW";
    public static final String MESSAGE_PEND_VERIFICATION = "PEND_VERIFICATION";
    public static final String MESSAGE_FOUND = "FOUND";
    public static final String MESSAGE_INDV_FAILURE = "INDV_FAILURE";
    public static final String MESSAGE_GROUP_FAILURE = "GROUP_FAILURE";
    public static final String MESSAGE_BEN_OPEN = "AP";
    public static final String MESSAGE_BEN_PEND = "PE";
    public static final String MESSAGE_MED_BEN_OPEN = "M";
    public static final String MESSAGE_BEN_CLOSED = "TN";
    public static final String MESSAGE_BEN_DENIED = "DN";
    // My Access Generate Message Constants. Case_Mode
    public static final String CASE_MODE_REVIEW = "R";
    public static final String BENEFIT_STATUS_LISTVIEW = "BENEFIT_STATUS_LISTVIEW";

    // Access Message Constants.
    public static final String VERIFICATION_FAILURE_RSN = "R";

    // Constants used in JSP.
    public static final String MESSAGE_SC_FLAG = "IC_INDV_SC_ELG";
    public static final String MESSAGE_HC_FLAG = "HC_FLAG";
    public static final String MESSAGE_DSP_HMO = "MSG_HMO";
    public static final String MESSAGE_DSP_INFO = "MSG_INFO";
    public static final String MESSAGE_DSP_FOUND = "MSG_FOUND";
    public static final String MESSAGE_DSP_PEND = "MSG_PEND";
    public static final String MESSAGE_DSP_GRP_FAIL = "MSG_GRP_FAIL";
    public static final String MESSAGE_DSP_IND_FAIL = "MSG_IND_FAIL";
    public static final String MESSAGE_DSP_COLLECTION = "MSG_COLLECTION";
    public static final String VERIFICATION_CODE = "V";
    public static final String REASON_CODE = "R";
    // Constants for history months
    public static final String FIRST_HIST_MONTH = "FIRST_HIST_MONTH";
    public static final String SECOND_HIST_MONTH = "SECOND_HIST_MONTH";
    public static final String PAYMENT_END_MONTH = "PAYMENT_END_MONTH";
    public static final String HIST_MONTH_LIST = "HIST_MONTH_LIST";
    public static final String PAGE_MODE = "PAGE_MODE";
    public static final String FIRST_HIST_MONTH_NAME = "FIRST_HIST_MONTH_NAME";
    public static final String SECOND_HIST_MONTH_NAME = "SECOND_HIST_MONTH_NAME";
    public static final String CURRENT_MONTH_FLAG = "CURRENT_MONTH_FLAG";
    public static final String CURRENT_MODE = "CURRENT_MODE";
    public static final String HISTORY_MODE = "HISTORY_MODE";
    public static final String ADULT = "A";
    public static final String CHILD = "C";
    public static final int CTS_MAX_SEQ = 2;
    public static final int M01_MAX_SEQ = 1;
    public static final int M02_MAX_SEQ = 1;
    public static final int M03_MAX_SEQ = 15;
    public static final int M04_MAX_SEQ = 1;
    public static final int M05_MAX_SEQ = 2;
    public static final int M06_MAX_SEQ = 5;
    public static final int M07_MAX_SEQ = 2;
    public static final int M08_MAX_SEQ = 2;
    public static final int M09_MAX_SEQ = 2;
    public static final int M10_MAX_SEQ = 2;
    public static final int M11_MAX_SEQ = 1;
    public static final int M12_MAX_SEQ = 15;
    public static final int FS_MAX_SEQ = 1;
    public static final int SC_MAX_SEQ = 2;

    public static final String CTS_PAGE_ID = "AMCSD";
    public static final String HC_PAGE_ID = "AMHCD";
    public static final String SC_PAGE_ID = "AMSCD";
    public static final String FS_PAGE_ID = "AMFSD";

    // MyAccess Details page ICONS
    public static final String YELLOW_CIRCLE_ICON = "/yellow_circle_icon.gif";
    public static final String RED_CIRCLE_ICON = "/red_circle_icon.gif";
    public static final String GREEN_CIRCLE_ICON_IMG = "/green_circle_icon.gif";

    // AFB Constants
    public static final String INDIVIDUAL_CUSTOM_COLL = "INDIVIDUAL_CUSTOM_COLL";
    public static final String INDV_MASTER_DROPDOWN_LIST = "INDV_MASTER_DROPDOWN_LIST";
    public static final String INDV_SEQUENCE_NUMBERS = "INDV_SEQUENCE_NUMBERS";
    public static final String INDV_DESCRIPTIONS = "INDV_DESCRIPTIONS";
    public static final String APP_NUMBER = "APP_NUMBER";
    public static final String APP_IN_PRFL_MASTER = "APP_IN_PRFL_MASTER";
    public static final String NO_ONE_FLAG = "NO_ONE_FLAG";
    public static final String FIRST_NAME = "FIRST_NAME";
    public static final String INDIV_MASTER_HANDLER = "INDIV_MASTER_HANDLER";
    public static final String SEX_IND_MALE = "M";
    public static final String SEX_IND_FEMALE = "F";
    public static final String SEX_IND_UNKNOWN = "U";
    public static final String PEOPLE = "PEOPLE_";
    public static final String NO_ONE_CHECKED_MAP = "NO_ONE_CHECKED_MAP";
    public static final String NO_ONE_CHECKED = "NO_ONE_CHECKED_";
    public static final String RESP_MAP = "RESP_MAP_";
    public static final String CURRENT_INDIV_SEQ_NUM = "CURRENT_INDIV_SEQ_NUM";
    public static final String ABSENT_PARENT_COLLECTION = "ABSENT_PARENT_COLLECTION";
    public static final String APP_PREG_COLLECTION = "APP_PREG_COLLECTION";
    public static final String BLIND_DISABLE_COLLECTION = "BLIND_DISABLE_COLLECTION";
    public static final String INSTITUTION_COLLECTION = "INSTITUTION_COLLECTION";
    public static final String POLICY_HOLDER_STATUS = "POLICY_HOLDER_STATUS";

    // For Employment
    public static final String EMPL_BOTH_REG_INKD = "X";
    public static final String EMPL_REGULAR = "R";
    public static final String PAST_JOB = "P";
    public static final String EMPL_STRIKE = "S";
    public static final String EMPL_INKIND = "I";
    public static final String HEALTH_INS = "HL";
    public static final String EMPL_SELF = "S";
    public static final String MED = "M";
    public static final String RMC_ADD_NEW_IND = "A";
    public static final String WAGE_TYPE_REGULAR = "REG";
    public static final String WAGE_TYPE_SALARY = "SAL";
    public static final String WAGE_TYPE_HOURLY = "HU";
    public static final String WAGE_TYPE_WEEKEND = "WKD";
    public static final String WAGE_TYPE_HOLIDAY = "HOL";

    // edsp rmb
    public static final String WAGE_TYPE_OVERTIME = "OVR";
    public static final String WAGE_TYPE_SHITDIFF = "OSP";
    public static final String WAGE_TYPE_TIPS = "TIP";
    public static final String WAGE_TYPE_BONUS = "COM";

    public static final String WAGE_TYPE_OTHER = "OTH";
    public static final String WAGE_TYPE_INKIND = "I";
    public static final String WAGE_TYPE_JOB = "JOB";
    public static final String WAGE_TYPE_ADDITIONAL = "ADD";

    // Employment descriptions
    public static final String REGULAR = "Regular";
    public static final String SALARY = "Salary";
    public static final String HOURLY = "Hourly";
    public static final String WEEKEND = "Weekend";
    public static final String HOLIDAY = "Holiday";
    public static final String OVERTIME = "Overtime";
    public static final String SHIFTDIFF = "Shift Differential";
    public static final String TIPS = "Tips";
    public static final String BONUS = "Bonus or Commission";
    public static final String INKIND = "In-Kind";

    public static final String CURRENT_EMPL_TYPE = "CURRENT_EMPL_TYPE";
    public static final String INKIND_EMPL_TYPE = "INKIND_EMPL_TYPE";
    public static final String WAGE_SEQ_INKIND = "0";
    public static final String WAGE_SEQ_HOURLY = "1";
    public static final String WAGE_SEQ_SALARY = "2";
    public static final String WAGE_SEQ_ADTL1 = "3";
    public static final String WAGE_SEQ_ADTL2 = "4";
    public static final String WAGE_SEQ_ADTL3 = "5";
    public static final String WAGE_SEQ_ADTL4 = "6";
    public static final String WAGE_SEQ_OTH1 = "7";
    public static final String WAGE_SEQ_OTH2 = "8";
    public static final String WAGE_SEQ_OTH3 = "9";
    public static final String WAGE_SEQ_JOB = "10";
    public static final String WAGE_SEQ_ADDITIONAL_PAY = "11";

    // For Household Information summary listviews
    public static final String MEDICARE_PART_A = "Part A";
    public static final String MEDICARE_PART_B = "Part B";
    public static final String MEDICARE_PART_C = "Part C";
    public static final String MEDICARE_PART_D = "Part D";

    // Miscellaneous information
    public static final String SESN_APP_DATE = "SESN_APP_DATE";

    // for house hold member detail page
    public static final String PEOPLE_COUNT = "PEOPLE_COUNT";
    public static final String CHILD_COUNT = "CHILD_COUNT";
    public static final String INFORMATIONAL_MESSAGE = "INFORMATIONAL_MESSAGE";

    // for summary page list view
    public static final String CHANGE_LINK = "Change";
    public static final String ERASE_LINK = "Erase";

    // for detail pages
    public static final String INDV_TYPE_SEQ_BEAN = "INDV_TYPE_SEQ_BEAN";

    // Program keys
    public static final String PROGRAM_SELECTED = "1";
    public static final String PROGRAM_NOT_SELECTED = "0";
    public static final String PGM_KEY = "PGM_KEY";
    public static final String TFS_FLG = "TFS_FLG"; // Transitional FoodShare
    // VACMS start - converting FS to CC
    public static final String TCC_FLG = "TCC_FLG";
    // VACMS end - converting FS to CC
    public static final String BENEFIT_ARRAY = "BENEFIT_ARRAY";

    // for abs indicator
    public static final String ABS_FATHER = "AFTR";
    public static final String ABS_MOTHER = "AMTR";
    public static final String PREG_MOTHER = "PMTR";
    public static final String ABS_UNKNOWN = "UNKN";

    // for select tag option <click here to choose> constant
    public static final String SELECT_DEFAULT_OPTION = FwConstants.DEFAULT_DROPDOWN_SEL;

    // for AFB application status
    public static final String AFB_SUBMISSION_PENDING = "PE";
    public static final String AFB_SUBMISSION_READY = "RE";
    public static final String AFB_SUBMISSION_PROCESSED = "PR";
    public static final String AFB_SUBMISSION_EXCEPTION = "EX";
    public static final String AFB_MANUALLY_PROCESSED = "MP";
    public static final String AFB_APPLICATION_CLEARED = "CL";
    public static final String AFB_APPLICATION_MERGED = "ME";
    public static final String RMC_APPLICATION_INPROGRESS = "IP";
    public static final String RMC_APPLICATION_COMPLETE = "CP";
    public static final String DOCUMENT_SUBMISSION_PROCESSED = "PR";
    public static final String DOCUMENT_SUBMISSION_EXCEPTION = "EX";
    public static final String BATCH_PROCESS = "BATCH_PROCESS";

    // for AFB -- Associate wid with App_num
    public static final String ASSOCIATED_WITH_WID = "ASSOCIATED_WITH_WID";

    // constants related AFB Application process
    public static final String APPLICATION = "APPLICATION";
    public static final String INDIVIDUAL_PROFILE = "INDIVIDUAL_PROFILE";
    public static final String INDIVIDUALS = "INDIVIDUALS";
    public static final String ABSENT_PARENTS = "ABSENT_PARENTS";
    public static final String PREGNANCY = "PREGNANCY";
    public static final String RELATIONSHIPS = "RELATIONSHIPS";
    public static final String RELATIONSHIP = "RELATIONSHIP_";
    public static final String NEWBORN = "NEWBORN";
    public static final String EMPLOYMENTS = "EMPLOYMENTS";
    public static final String EMPLOYMENT = "EMPLOYMENT_";
    public static final String SELF_EMPLOYMENTS = "SELF_EMPLOYMENTS";
    public static final String SELF_EMPLOYMENT = "SELF_EMPLOYMENT_";
    public static final String UNEARNED_INCOMES = "UNEARNED_INCOMES";
    public static final String UNEARNED_INCOME = "UNEARNED_INCOME_";
    public static final String DEPENDENT_CARES = "DEPENDENT_CARES";
    public static final String DEPENDENT_CARE = "DEPENDENT_CARE_";
    public static final String CHILD_SUPPORTS = "CHILD_SUPPORTS";
    public static final String CHILD_SUPPORT = "CHILD_SUPPORT_";
    public static final String MEDICARES = "MEDICARES";
    public static final String MEDICARE = "MEDICARE_";
    public static final String SHELTER_COSTS = "SHELTER_COSTS";
    public static final String SHELTER_COST = "SHELTER_COST_";
    public static final String UTILITY_COSTS = "UTILITY_COSTS";
    public static final String UTILITY_COST = "UTILITY_COST_";
    public static final String PAY_HOUS_BILL = "HE";
    public static final String UTILITY_BILL = "UTILITY_BILL_RESP";
    public static final String UTIL_EXP_RESP = "UE";
    public static final String RMC_CAT_UT_EXP_PRFL = "UE";
    // medical bill

    public static final String RMC_CAT_MEDICAL_EXP_PRFL = "ME";
    public static final String FUEL_ASSISTANCE = "FU";

    public static final String MEDICAL_COVERAGE = "MEDICAL_COVERAGE_";
    public static final String MEDICAL_COVERAGES = "MEDICAL_COVERAGES";
    public static final String INDIVIDUAL = "INDIVIDUAL_";
    public static final String ABSENT_PARENT_CHILDREN = "ABSENT_PARENT_CHILDREN";
    public static final String ABSENT_PARENT_CHILD = "ABSENT_PARENT_CHILD_";
    public static final String ABSENT_PARENT = "ABSENT_PARENT_";
    public static final String ELEMENT_INDIVIDUAL = "INDIVIDUAL";
    public static final String ELEMENT_LOSS_OF_EMPLOYMENT = "LOSS_OF_EMPLOYMENT";
    public static final String ELEMENT_CHILD_SUPPORT = "CHILD_SUPPORT";
    public static final String ELEMENT_MEDICARE = "MEDICARE";
    public static final String ELEMENT_RELATIONSHIP = "RELATIONSHIP";
    public static final String ELEMENT_EMPLOYMENT = "EMPLOYMENT";
    public static final String ELEMENT_SELF_EMPLOYMENT = "SELF_EMPLOYMENT";
    public static final String ELEMENT_WAGE = "WAGE";
    public static final String ELEMENT_UNEARNED_INCOME = "UNEARNED_INCOME";
    public static final String ELEMENT_DEPENDENT_CARE = "DEPENDENT_CARE";
    public static final String ELEMENT_SHELTER_COST = "SHELTER_COST";
    public static final String ELEMENT_UTILITY_COST = "UTILITY_COST";
    public static final String ELEMENT_ABSENT_PARENT = "ABSENT_PARENT";
    public static final String ELEMENT_ABSENT_PARENT_CHILD = "ABSENT_PARENT_CHILD";
    public static final String WAGES = "WAGES";
    public static final String WAGE = "WAGE_";
    public static final String DATA_EXIST = "DATA_EXIST";
    public static final String INSTITUTIONS = "INSTITUTIONS";
    public static final String COMMUNITY_SPOUSE = "COMMUNITY_SPOUSE";
    public static final String LIQUID_ASSETS = "LIQUID_ASSETS";
    public static final String LIQUID_ASSET = "LIQUID_ASSET_";
    public static final String ELEMENT_LIQUID_ASSET = "LIQUID_ASSET";
    public static final String JOINT_OWNERS = "JOINT_OWNERS";
    public static final String JOINT_OWNER = "JOINT_OWNER_";
    public static final String ELEMENT_JOINT_OWNER = "JOINT_OWNER";
    public static final String VEHICLE_ASSETS = "VEHICLE_ASSETS";
    public static final String VEHICLE_ASSET = "VEHICLE_ASSET_";
    public static final String ELEMENT_VEHICLE_ASSET = "VEHICLE_ASSET";
    public static final String REAL_PROPERTY_ASSETS = "REAL_PROPERTY_ASSETS";
    public static final String REAL_PROPERTY_ASSET = "REAL_PROPERTY_ASSET_";
    public static final String ELEMENT_REAL_PROPERTY_ASSET = "REAL_PROPERTY_ASSET";
    public static final String PERSONAL_PROPERTY_ASSETS = "PERSONAL_PROPERTY_ASSETS";
    public static final String PERSONAL_PROPERTY_ASSET = "PERSONAL_PROPERTY_ASSET_";
    public static final String ELEMENT_PERSONAL_PROPERTY_ASSET = "PERSONAL_PROPERTY_ASSET";
    public static final String BURIAL_ASSETS = "BURIAL_ASSETS";
    public static final String BURIAL_ASSET = "BURIAL_ASSET_";
    public static final String ELEMENT_BURIAL_ASSET = "BURIAL_ASSET";
    public static final String LIFE_INSURANCE_DETAILS = "LIFE_INSURANCE_DETAILS";
    public static final String LIFE_INSURANCE = "LIFE_INSURANCE_";
    public static final String ELEMENT_LIFE_INSURANCE = "LIFE_INSURANCE";
    public static final String DISABILITY = "DISABILITY";
    public static final String ELEMENT_MEDICAL_COVERAGE_CHILD = "MEDICAL_COVERAGE_CHILD";
    public static final String MEDICAL_COVERAGE_INDIVIDUAL = "MEDICAL_COVERAGE_INDIVIDUAL_";
    public static final String MEDICAL_COVERAGE_CHILDREN = "MEDICAL_COVERAGE_CHILDREN";
    public static final String MEDICAL_COVERAGE_CHILD = "MEDICAL_COVERAGE_CHILD_";
    public static final String ELEMENT_IRWE = "IRWE";
    public static final String IRWES = "IRWES";
    public static final String ELEMENT_EDUCATIONAL_AID = "ELEMENT_EDUCATIONAL_AID";
    public static final String EDUCATIONAL_AID_DETAILS = "EDUCATIONAL_AID_DETAILS";
    public static final String ELEMENT_TRANSFER_ASSET = "TRANSFER_ASSET";
    public static final String TRANSFER_ASSETS = "TRANSFER_ASSETS";
    public static final String INST_TYP = "INST_TYP";
    public static final String HELP_INDICATOR = "HELP_INDICATOR";
    public static final String APP_SUBMISSION = "APP_SUBMISSION";
    public static final String E_SIGN_IND = "E_SIGN_IND";
    public static final String SPS_E_SIGN_IND = "SPS_E_SIGN_IND";
    public static final String EMER_MA_RESP = "EMER_MA_RESP";
    public static final String TB_RESP = "TB_RESP";
    public static final String HSHL_ADDR_CHANGED = "HSHL_ADDR_CHANGED";
    public static final String ALT_ADDR_CHANGED = "ALT_ADDR_CHANGED";
    public static final String HSHL_ADDR_DETAILS = "HSHL_ADDR_DETAILS";
    public static final String ALT_ADDR_DETAILS = "ALT_ADDR_DETAILS";
    public static final String AUTHORIZED_REPRESENTATIVE = "AR";
    public static final String FILING_REPRESENTATIVE = "FR";
    public static final String FILING_REPRESENTATIVE_NM = "FILING_REPRESENTATIVE";
    public static final String LEGAL_GAURDIAN = "LG";
    public static final String POWER_OF_ATTORNEY = "PA";
    public static final String YES = "Y";
    public static final String NO = "N";
    public static final String WAITING_FOR_DECISION = "W";
    public static final String AGCY_NUM = "AGCY_NUM";
    public static final String DATA_EXIST_VALUE = "N";
    public static final String ACCESSAPPLICATIONSUBMIT_QUEUE = "accessApplicationSubmit_queue";
    public static final String ACCESSAPPLICATIONSUBMIT_QCF = "accessApplicationSubmit_qcf";

    // constants related to webservice
    public static final String WS_INPUT = "WebServiceInput";
    public static final String WS_OUTPUT = "WebServiceOutput";

    // constants related to Access2CWW RealTime Process
    public static final String ACCESS2CWWREALTIME_QUEUE = "accessToCwwRealTime_queue";
    public static final String ACCESS2CWWREALTIME_QCF = "accessToCwwRealTime_qcf";
    public static final char SUCCESS = 'S';
    public static final char EXCEPTION = 'E';
    public static final char DO_NOT_REFRESH = 'N';
    public static final String CWW_RECORD_IND = "CW";
    public static final String RMC_NEW_RECORD_IND = "RN";
    public static final String RMC_MODIFIED_RECORD_IND = "RM";
    public static final String RMC_END_RECORD_IND = "RE";
    public static final String RMC_RQST = "RMC_RQST";
    public static final String CASE_NUMBER = "CASE_NUMBER";
    public static final String WORKER_ADDRESS_TYPE = "W";
    public static final String CASE_ADDRESS_TYPE = "C";
    public static final String RMC_RQST_COLLECTION = "RMC_RQST_COLLECTION";
    public static final String FPL_NO = "FPL_NO";
    public static final String AGENCY_CONTACT_NO = "AGENCY_CONTACT_NO";
    public static final String AFB = "AFB";
    public static final String RMC = "RMC";
    public static final int MAX_WAGE_SEQ_NUM = 10000;

    // Constants for PDF and Display Formatter
    public static final String HYPHEN = "-";
    public static final String EMPTY_STRING = "";
    public static final String NULL_STRING = "null";
    public static final String NEWLINE = "\n";
    public static final String COLON = ":";
    public static final String AT = "at";
    public static final String POST_MERIDIAN = "P.M.";
    public static final String ANTE_MERIDIAN = "A.M.";
    public static final String PRIMARY_INDV_SEQ = "1";
    public static final String HTML_LINE_BREAK = "<br />";

    // for ECF application status
    public static final String PDF_STORING_PENDING = "PE";

    // establishment filing date
    public static final String SET_FILING_DATE = "SET_FILING_DATE";

    // CONSTATS FOR PERSONAL PROPERTY TYPE
    public static final String PERSONAL_PROPERTY = "PP";
    // THESE CONSTANTS FOR JOINT OWNER
    public static final String JOINT_OWNER_TYPE_PERSONAL_PROPERTY = "PP";
    public static final String JOINT_OWNER_TYPE_REAL_PROPERTY = "RP";
    public static final String JOINT_OWNER_TYPE_LIQUID_ASSET = "LA";
    public static final String JOINT_OWNER_TYPE_VEHICLE_ASSET = "VA";
    public static final String JOINT_OWNER_TYPE_BURIAL_ASSET = "BA";
    public static final String JOINT_OWNER_TYPE_INSURANCE_ASSET = "IN";
    public static final String JOINT_OWNER_TYPE_LIFE_INSURANCE = "IN";
    public static final String JOINT_OWNER_HOUSING_UTILITY = "HU";
    public static final String JOINT_OWNER_UTILITY_BILLS = "UB";
    public static final String JOINT_OWNER_OTHER_RESOURCES = "OR";

    // extraction flags index
    public static final int RMC_EXT_EMP_INDEX = 0;
    public static final int RMC_EXT_HO_INDEX = 1;
    public static final int RMC_EXT_OI_INDEX = 2;
    public static final int RMC_EXT_HE_INDEX = 3;
    public static final int RMC_EXT_MARRIAGE_INDEX = 4;
    public static final int RMC_EXT_DIVORCE_INDEX = 5;
    public static final int RMC_EXT_PREGNANCY_INDEX = 6;
    public static final int RMC_EXT_PREGNANCY_ENDED_INDEX = 7;
    public static final int RMC_EXT_DISABILITY_INDEX = 8;
    public static final int RMC_EXT_RELATIONS_INDEX = 9;
    public static final int RMC_EXT_CONTACT_INFO_INDEX = 10;

    // Extraction Constants
    public static final String RMC_EXT_MARRIAGE = "MA";
    public static final String RMC_EXT_DIVORCE = "DI";
    public static final String RMC_EXT_PREGNANCY = "PN";
    public static final String RMC_EXT_PREGNANCY_ENDED = "PE";
    public static final String RMC_EXT_DISABILITY = "DA";
    public static final String RMC_EXT_RELATIONS = "RT";
    public static final String RMC_EXT_CONTACT_INFO = "CI";

    public static final String RMC_EXTRACTION_FLAGS = "RMC_EXTRACTION_FLAGS";
    public static final String RMC_CATEGORY_PAGE_PRFL = "RMC_CATEGORY_PAGE_PRFL";
    public static final short RMC_CHG_SEL_IND = 0;
    public static final short RMC_END_SEL_IND = 1;

    // constants for Bullet points for Category selection page
    public static final String RMC_IN_PRFL_MASTER = "RMC_IN_PRFL_MASTER";
    public static final String CATEGORY_SEL_PROFILE = "CATEGORY_SEL_PROFILE";
    public static final String CATEGORY_SEL_RESPONSE = "CATEGORY_SEL_RESPONSE";
    public static final String RMC_CATEGORY_PROFILE_MASTER = "RMC_CATEGORY_PROFILE_MASTER";
    public static final String RMC_CAT_EMP_PRFL = "EI";
    public static final String RMC_CAT_DABL_PRFL = "DI";
    public static final String RMC_CAT_MED_PRFL = "MD";
    public static final String RMC_CAT_HO_COMP_PRFL = "HC";
    public static final String RMC_CAT_HO_EXP_PRFL = "HE";
    public static final String RMC_CAT_OT_INC_PRFL = "OI";
    public static final String CS_MUST_ARRAY = "CS_MUST_ARRAY";
    public static final String CS_MAY_ARRAY = "CS_MAY_ARRAY";
    public static final String CS_MUST_ARRAY_SECOND = "CS_MUST_ARRAY_SECOND";
    public static final String CS_MAY_ARRAY_SECOND = "CS_MAY_ARRAY_SECOND";
    public static final String CS_MUST_ARRAY_SUFFIX = "CS_MUST_ARRAY_SUFFIX";
    public static final String CS_MAY_ARRAY_SUFFIX = "CS_MAY_ARRAY_SUFFIX";

    // Category types for RMC HouseHold Comp Indiv Selection page
    public static final String LEFT_THE_HOME = "LH";
    public static final String GOT_MARRIED = "GM";
    public static final String GOT_DIVORCED = "GD";
    public static final String BECAME_PREGNANT = "BP";
    public static final String PREGNANCY_ENDED = "PE";
    public static final String SIGNLANGUAGEINTERPRETER = "Sign Language Interpreter";
    public static final String FOREIGNLANGUAGEINTERPRETER = "Foreign Language Interpreter";
    public static final String TTY = "TTY";
    public static final String INTEMAIL = "Email";
    public static final String PRINT = "Large Print";
    public static final String INTOTHER = "Other";
    public static final String VIDEO = "Video Relay";
    public static final String NONE = "None";
    public static final String BRAILLE = "Braille";
    public static final short PROGRAM_KEY_CHILD = 8;
    public static final short PROGRAM_KEY_WIC = 14;
    public static final String DISABLED_BLIND = "DB";
    public static final String SOMEONE_DIED = "SD";
    public static final String DRUG_FELONY = "DR";
    public static final String PROBATION_PAROL = "PR";
    public static final String ROOMER_BOARDER = "RO";
    public static final String ABLE_TO_CONCEIVE = "AC";
    public static final String UNDERWEIGHT_BIRTH = "UB";
    public static final String RLT_CHG_STAT_SW = "601";
    public static final String RLT_CHG = "RL";

    // category types for RMC HouseHold Comp Summary page
    public static final String MOVED_IN_HOME = "MI";
    public static final String IMMIGRATION = "IM";
    // AFB Source App Indicator
    public static final String SRC_APP_IND_AFB = "AB";

    public static final String DEATH_INDICATOR = "SD";
    public static final String MARRIAGE_INDICATOR = "MA";
    public static final String DIVORCE_INDICATOR = "DV";

    // constant for moved out page
    public static final String INDV_LIVE_CHG = "INDV_LIVE_CHG";
    public static final String BACK_TO_MY_ACCESS_BUTTON = "BackToMyAccess.x";

    public static final String IVR_SELFSERVICE = "IVR_SELFSERVICE";
    public static final String IVR_ACCOUNT = "ACCOUNT";
    public static final String IVR_ACCT_PIN = "IVR_ACCT_PIN";
    public static final String IVR_PIN = "PIN";
    public static final String INDIVIDUAL_DEMOGRAPHICS = "INDIVIDUAL_DEMOGRAPHICS";
    public static final String INDIVIDUAL_DEMOGRAPHIC = "INDIVIDUAL_DEMOGRAPHIC";
    public static final String IVR_ACKNOWLEDGE = "IVR_ACKNOWLEDGE";
    public static final String IVR_QUEST_CARD_NUM = "QUEST_CARD_NUM";
    public static final String IVR_SUCCESS_FLG = "SUCCESS_FLG";
    public static final String IVR_ERROR = "ERROR";
    public static final String IVR_CASE = "CASE";
    public static final String IVR_CASE_NUM = "CASE_NUM";
    public static final String IVR_CASE_CLOSURE_DT = "CASE_CLOSURE_DT";
    public static final String IVR_INDIVIDUALS = "INDIVIDUALS";
    public static final String ADDRESSES = "ADDRESSES";
    public static final String IVR_ELIGIBILITY = "ELIGIBILITY";
    public static final String IVR_CATEGORY = "CATEGORY";
    public static final String IVR_CAT_CD = "CAT_CD";
    public static final String INDV_ELIG_DETAILS = "INDV_ELIG_DETAILS";
    public static final String INDV_ELIG_DETAIL = "INDV_ELIG_DETAIL";
    public static final String IVR_FIRST_MONTH = "FIRST_MONTH";
    public static final String IVR_SECOND_MONTH = "SECOND_MONTH";
    public static final String IVR_THIRD_MONTH = "THIRD_MONTH";
    public static final String IVR_ELIG_PINS = "ELIG_PINS";
    public static final String IVR_BNFT_PEND = "BNFT_PEND";
    public static final String IVR_BNFT_PEND_PINS = "BNFT_PEND_PINS";
    public static final String IVR_BNFT_PEND_DTLS = "BNFT_PEND_DTLS";
    public static final String IVR_BNFT_PEND_DTL = "BNFT_PEND_DTL";
    public static final String IVR_BNFT_INFO = "BNFT_INFO";
    public static final String IVR_PIN_INFO = "PIN_INFO";
    public static final String IVR_PYMT_BEG_DT = "PYMT_BEG_DT";
    public static final String IVR_PYMT_END_DT = "PYMT_END_DT";
    public static final String IVR_BNFT_PIN_NUM = "BNFT_PIN_NUM";
    public static final String IVR_CAT_CD_CTS = "CTS";
    public static final String IVR_CAT_CD_FS = "FS ";
    public static final String IVR_CAT_CD_HC = "HC";
    public static final char IVR_ELIG_IND_ELIGIBLE = 'E';
    public static final char IVR_BNFT_STS_OPEN = 'O';
    public static final char IVR_BNFT_STS_MEDICAID = 'M';
    public static final char IVR_BNFT_STS_PENDING = 'P';
    public static final char IVR_BNFT_STS_CLOSED = 'C';
    public static final char IVR_BNFT_STS_DENIED = 'D';
    public static final char IVR_PEND_IND_NOCONFIRMED = 'A';
    public static final char IVR_PEND_IND_UNCONFIRMED_NONPEND_ONLY = 'B';
    public static final char IVR_PEND_IND_UNCONFIRMED_PEND_ONLY = 'C';
    public static final char IVR_PEND_IND_CONFIRMED_ONLY = 'D';
    public static final char IVR_PEND_IND_CONFIRMED_INELIG = 'E';
    public static final char IVR_PEND_IND_CONFIRMED_ONGOING = 'F';
    public static final String IVR_DATA_EXTRACT = "IVR_DATA";
    public static final String IVR_ACCT_ACKLG = "ACCT_ACKLG";
    public static final String IVR_PIN_LIST = "PIN_LIST";
    public static final String IVR_ACCT_TYPE_LIST = "ACCT_TYPE_LIST";
    public static final String REFRESH_BNFT_QUERY_EJB = "ejb/gov/state/nextgen/access/business/services/RefreshBenefitQueryEJBLocalHome";
    public static final String IVR_MESSAGE_DELIMITER = "$";
    public static final char IVR_ONLY_ACCT = 'I';
    public static final char IVR_CMB_ACCT = 'B';
    public static final String ACCESS_PIN_RFA_FLAG = "ACCESS_PIN";
    public static final String EXTRACTED_CWW_DATA = "CWW_DATA";
    public static final String ACCESS_CMB_REFRESH_FLAG = "accessCMBRfrshFlg";
    public static final String CMB_REFRESH_SUCCESS = "S";
    public static final String XML_ENCODING = "<?xml version='1.0' encoding='UTF-8'?>";
    public static final String IVR_ROOT_ELE_START_TAG = "<IVR_SELFSERVICE>";
    public static final String IVR_ROOT_ELE_END_TAG = "</IVR_SELFSERVICE>";
    public static final String FILE_FORMAT_ZIP = ".zip";
    // Genesys IVR Specific Application Properties

    public static final String IVR_ROOT_XML_TAG = "<?xml version=\"1.0\"?>";
    public static final String IVR_ROOT_VXML_START_TAG = "<vxml version=\"2.1\"  xml:lang=\"en-US\"  "
            + " xmlns=\"http://www.w3.org/2001/vxml\" xmlns:telera=\"http://www.telera.com/vxml/2.0/ext/20020430\" xmlns:genesys=\"http://www.genesyslab.com/vxml/2.0/ext/20020430\"> ";
    public static final String IVR_ROOT_DTMF_PROPERTY = "<property name=\"com.telera.speechenabled\" value=\"false\"/>";
    public static final String IVR_ROOT_TERM_CHAR_PROPERTY = "<property name=\"termchar\" value=\"D\" />";
    public static final String IVR_ROOT_VXML_END_TAG = "</vxml>";
    public static final String IVR_BLOCK_START_TAG = "<block>";
    public static final String IVR_BLOCK_END_TAG = "</block>";
    public static final String IVR_FORM_START_TAG = "<form>";
    public static final String IVR_FORM_END_TAG = "</form>";
    public static final String IVR_PROMPT_START_TAG = "<prompt>";
    public static final String IVR_PROMPT_END_TAG = "</prompt>";
    public static final String IVR_ENGLISH_LANG = "en/US";
    public static final String IVR_SPANISH_LANG = "es/US";
    public static final String IVR_EXP_ERROR_MSG = "System is Currently Experiencing Problems. Please Contact Customer Care or Report to DHS Call Center. Problem is ";
    public static final String IVR_RETURN_CD = "ReturnResultCd";
    public static final String IVR_RETURN_DESC = "ReturnResultDesc";    
    public static final String CENTER_START_TAG = "<center>";
    public static final String CENTER_END_TAG = "</center>";

    public static final String SPACE = " ";
    public static final String INDV_ID = "INDV_ID";
    public static final String DOB = "DOB";
    public static final String SSN = "SSN";

    public static final int RMC_MARRIAGE_INDEX = 0;
    public static final int RMC_DIVORCE_INDEX = 1;
    public static final int RMC_DIED_INDEX = 2;
    public static final int RMC_MOVEDOUT_INDEX = 3;

    public static final int RMC_PREG_ADD_INDEX = 0;
    public static final int RMC_PREG_END_INDEX = 1;
    // Constants related to DynaSection
    public static final java.lang.String DYNA_SECTION_COLLECTION_NAME = "DYNA_SECTION_COLLECTION_NAME";
    public static final java.lang.String DYNA_SECTION_DELETE = "DYNA_SECTION_DELETE";
    public static final String BUTTON_SUB_ADD = "BUTTON_SUB_ADD";
    public static final String BUTTON_SUB_ADD_IMG = "/add_button.gif";
    public static final String BUTTON_SUB_ADD_DISABLED_IMG = "/button_add_gray.gif";
    public static final String BUTTON_SUB_ADD_ALT = "30414";
    public static final String BUTTON_SUB_DELETE = "BUTTON_SUB_DELETE";
    public static final String BUTTON_SUB_DELETE_IMG = "/delete_button.jpg";
    public static final String BUTTON_SUB_DELETE_DISABLED_IMG = "/button_sub_delete_gray.gif";
    public static final String BUTTON_SUB_DELETE_ALT = "40177";
    public static final String PREGNANT_WOMEN = "PW";
    public static final String CHILDREN = "CH";
    public static final String APP_USER_ID = "APP_USER_ID";
    public static final String APP_USER_TYP = "APP_USER_TYP";
    public static final String APP_LOC_NUM = "APP_LOC_NUM";
    public static final String APP_PRVD_ID = "APP_PRVD_ID";
    public static final String APP_PRVD_LOC_PVLG = "APP_PRVD_LOC_PVLG";
    // APP Application status
    public static final String APP_SUBMISSION_PENDING = "PE";
    public static final String APP_SUBMISSION_READY = "RE";
    public static final String APP_SUBMISSION_PROCESSED = "PR";
    public static final String APP_SUBMISSION_EXCEPTION = "EX";
    public static final String APP_APPLICATION_INPROGRESS = "IP";
    public static final String APP_APPLICATION_COMPLETE = "CP";
    public static final String APP_APPLICATION_EXPIRED = "EP";
    public static final String APP_APPLICATION_SUBMITTED = "SB";
    public static final String APPLICANT_NAME = "APPLICANT_NAME";
    public static final String UPDATED_ON = "UPDATED_ON";
    public static final String UPDATED_BY = "UPDATED_BY";
    public static final String APP_APPLICATION_TYPE = "APP_APPLICATION_TYPE";
    public static final String APP_PE_TYPETEXT = "EE for Pregnant Women";
    public static final String APP_CH_TYPETEXT = "EE for Children";
    public static final String APP_STS_CD = "APP_STS_CD";
    public static final String APP_PROCESSED_EXCEPTION = "PE";
    // APP USER STATUS
    public static final String NEW = "N";
    public static final String EXISTING = "E";

    // APP PIN Email Status
    public static final String APP_NEW_PIN_EMAIL_PENDING = "PN";
    public static final String APP_FORGOT_PIN_EMAIL_PENDING = "PF";
    public static final String APP_PIN_EMAIL_SENT = "SE";

    // BADGERCARE PLUS CONSTANTS
    public static final String BADGERCARE_PLUS = "BCP";
    public static final int INDIVIDUAL_AGE_EIGHTEEN = 18;
    public static final String PERSON_ADD = "PERSON ADD";

    // APP Application- Process Design Details
    public static final String I = " i";
    public static final int DECEMBER = 12;
    public static final int JANUARY = 1;
    public static final String FEMALE = "F";
    public static final String STATUS_CODE_PROCESSED = "PR";
    public static final String STATUS_CODE_ERROR_IDENTIFIED = "EX";
    public static final String DATE_FORMAT_MMDDYYYY = "MMddyyyy";
    public static final String TR = "TR";

    // Constants used for Reading XML File
    public static final String PEPROVIDER = "PEPROVIDER";
    public static final String PROVIDER = "PROVIDER";
    public static final String LOCATION_TYPE = "LOCATION_TYPE";
    public static final String BASE_PROVIDER_ID = "BASE_PROVIDER_ID";
    public static final String PREVIOUS_PROVIDER_ID = "PREVIOUS_PROVIDER_ID";
    public static final String SITE_LOCATION_INDICATOR = "SITE_LOCATION_INDICATOR";
    public static final String NAME_OF_ORGANIZATION = "NAME_OF_ORGANIZATION";
    public static final String CONTACT_FIRST_NAME = "CONTACT_FIRST_NAME";
    public static final String CONTACT_LAST_NAME = "CONTACT_LAST_NAME";
    public static final String CONTACT_MIDDLE_INITIAL = "CONTACT_MIDDLE_INITIAL";
    public static final String ADDRESS_LINE_1 = "ADDRESS_LINE_1";
    public static final String ADDRESS_LINE_2 = "ADDRESS_LINE_2";
    public static final String CITY = "CITY";
    public static final String STATE = "STATE";
    public static final String ZIP = "ZIP_CODE";
    public static final String PHONE_NUMBER = "PHONE_NUMBER";
    public static final String CERTIFICATION_TYPE_1 = "CERTIFICATION_TYPE_1";
    public static final String AUTHORIZATION_BEGIN_DATE_1 = "AUTHORIZATION_BEGIN_DATE_1";
    public static final String AUTHORIZATION_END_DATE_1 = "AUTHORIZATION_END_DATE_1";
    public static final String CERTIFICATION_TYPE_2 = "CERTIFICATION_TYPE_2";
    public static final String AUTHORIZATION_BEGIN_DATE_2 = "AUTHORIZATION_BEGIN_DATE_2";
    public static final String AUTHORIZATION_END_DATE_2 = "AUTHORIZATION_END_DATE_2";
    public static final String EMAIL_ADDRESS = "EMAIL_ADDRESS";
    public static final String PARENT = "P";
    public static final String SATILITE = "S";
    public static final String SITECODE = "00";

    public static final String PRFL_ID = "6";
    public static final String UPDT_USER_ID = "0";

    public static final String MMIS_SERVER = "mmisFTPServer";
    public static final String MMIS_USERNAME = "mmisUsername";
    public static final String MMIS_PASSWORD = "mmisPassword";
    public static final String MMIS_PATH = "mmisPath";
    public static final String APP_BATCH_FILE_LOCATION = "batchFileLocation";
    public static final String APP_ELIGIBILITY_FILE_NAME = "appEligibilityFileName";
    // NEHNA CONSTANTS
    public static final String NEHNA_APP_IN_PRFL_MASTER = "NEHNA_APP_IN_PRFL_MASTER";
    public static final String NEHNA_APP_PRFL_MASTER = "NEHNA_APP_PRFL_MASTER";

    // CMB-iC Constants
    public static final String SERVICE_SPECIFIC = "S";
    public static final String SERVICE_RANGE = "R";
    public static final String PAGE_TAB = "PAGE_TAB";
    public static final String PRESUBMIT_MESSAGES = "PRESUBMIT_MESSAGES";
    public static final String SUBMIT_MESSAGES = "SUBMIT_MESSAGES";
    public static final String CLICK_HERE = FwConstants.DEFAULT_DROPDOWN_SEL;
    public static final String CARD_TYPE = "CARD_TYPE";
    public static final String FORWARD_CARD = "F";
    public static final String SENIORCARE_CARD = "S";
    public static final String STATUS_MESSAGE = "MESSAGE";
    public static final String STATUS_COLOR = "STATUS_COLOR";

    public static final String BELOW_THE_FIELD = "B";
    public static final String FROM_DATE = "start";
    public static final String TO_DATE = "end";
    public static final String WHY_IS_IT_NEEDED = "Why is it needed?";
    public static final String EOMB = "B";
    public static final int STATUS_FAILURE = 0;
    public static final int STATUS_SUCCESS = 1;

    public static final String IC_INDV_HISTORY_DATE = "IC_INDV_HISTORY_DATE";
    public static final String IC_IND_MCO_MSG_LIST_COLLECTION = "IC_IND_MCO_MSG_LIST_COLLECTION";
    public static final String IC_IND_MCO_MSG_ARRAY_LIST = "IC_IND_MCO_MSG_ARRAY_LIST";
    public static final String IC_INDV_HISTORY_MONTH_NAME_MAP = "IC_INDV_HISTORY_MONTH_NAME_MAP";
    public static final String IC_INDV_HISTORY_MAP = "IC_INDV_HISTORY_MAP";
    public static final String HMO_MSG_ARRAY_LIST = "HMO_MSG_ARRAY_LIST";

    public static final String NAVIGATE_TAB = "NAVIGATE_TAB";
    public static final String CATEGORY = "CATEGORY";
    public static final String TAB_NO = "TAB_NO";
    public static final String PAGE_HEADING = "PAGE_HEADING";

    // CMB - IC Constants
    public static final String IC_SERVER = "icFTPServer";
    public static final String IC_USERNAME = "icUsername";
    public static final String IC_PASSWORD = "icPassword";
    public static final String IC_PATH = "icPath";
    public static final String IC_BATCH_FILE_LOCATION = "cmbICBatchFileLocation";
    public static final String IC_ELIGIBILITY_FILE_NAME = "receiveICFileName";
    public static final String HISTORY_TAB = "HISTORY_TAB";
    public static final String IC_DATA_MAP_FILE = "icEligibilityFileDataMapping";

    public static final String APPLICATION_PENDING = "PE";
    public static final String APPLICATION_APPROVED = "AP";
    public static final String APPLICATION_DENIED = "DN";
    public static final String APPLICATION_TERMINATED = "TN";
    public static final String PROGRAM_FOODSTAMPS = "FAP and/or SER-Energy Service";
    // Added to get URL from DATABASE for Am I Eligible
    public static final String GET_SCREENING_PAGE = "SCR";
    public static final String PROGRAM_DENIED = "DN";

    // For home page changes.
    public static final String BUTTON_AM_I_ELIGIBLE_IMG = "/am_i_eligible.jpg";
    // Start of VaCMS - Apply for Assistance instead of Apply for Benefits

    public static final String BUTTON_APPLY_FOR_BENEFITS_IMG = "/apply_for_assistance.jpg";
    // End of VaCMS - Apply for Assistance instead of Apply for Benefits
    public static final String BUTTON_LOGIN_TO_ACCOUNT_IMG = "/login_to_account.jpg";
    // Start of VaCMS - Check My Status instead of View My Case

    public static final String BUTTON_CREATE_AN_ACCOUNT_IMG = "/check_my_status.jpg";
    // End of VaCMS - Check My Status instead of View My Case
    public static final String BUTTON_COMMUNITY_PARTNER_IMG = "/community_partners_login.gif";
    public static final String BUTTON_BACKGROUND_IMG = "/background_pic.jpg";
    public static final String BUTTON_TITLE_LOGIN_IMG = "/title_login.gif";

    public static final String BUTTON_AM_I_ELIGIBLE = "BUTTON_AM_I_ELIGIBLE";
    public static final String BUTTON_APPLY_FOR_BENEFITS = "BUTTON_APPLY_FOR_BENEFITS";
    public static final String BUTTON_LOGIN_TO_ACCOUNT = "BUTTON_LOGIN_TO_ACCOUNT";
    public static final String BUTTON_CREATE_AN_ACCOUNT = "BUTTON_CREATE_AN_ACCOUNT";
    public static final String BUTTON_COMMUNITY_PARTNER = "BUTTON_COMMUNITY_PARTNER";
    public static final String BUTTON_TITLE_LOGIN = "BUTTON_TITLE_LOGIN";
    public static final String BUTTON_BACKGROUND = "BUTTON_BACKGROUND";

    public static final String BUTTON_AM_I_ELIGIBLE_ALT = "15077";
    public static final String BUTTON_APPLY_FOR_BENEFITS_ALT = "15079";
    public static final String BUTTON_LOGIN_TO_ACCOUNT_ALT = "15068";
    public static final String BUTTON_CREATE_AN_ACCOUNT_ALT = "15069";
    public static final String BUTTON_COMMUNITY_PARTNER_ALT = "15100";
    public static final String BUTTON_BACKGROUND_ALT = "15078";
    public static final String BUTTON_TITLE_LOGIN_ALT = "90144";

    public static final String APPLICATION_STATUS_JOB_ID = "SS-APPST-DLY";
    public static final String APPOINTMENTS_JOB_ID = "SS-APPOI-DLY";
    public static final String BENFT_JOB_ID = "SS-BENFT-DLY";
    public static final String CONTACT_JOB_ID = "SS-CONTC-DLY";
    public static final String REFRESH_DT = "REFRESH-DT";
    public static final String BENEFIT_MONTH = "BENEFIT_MONTH";
    public static final String PAYMENT_DT = "PAYMENT_DT";
    public static final String IVR_ACCESS_LVL_CD = "20";
    public static final String APPOINTMENT_COUNT = "APPOINTMENT_COUNT";
    public static final String APPOINTMENT = "APPOINTMENT";
    public static final String APP_DT = "APPT-DT";
    public static final String APP_END_TM = "APPT-END-TIME";
    public static final String APP_START_TM = "APPT-START-TIME";

    public static final String APP_TYPE = "APP_TYPE";
    public static final String APP_MODE = "APP_MODE";
    public static final String IVR_LANG = "APP_LANG";
    public static final String VCL_CHECKLISTS = "VCL-CHECKLISTS";
    public static final String VCL = "VCL";
    public static final String VCL_TYPE = "VCL-TYPE";
    public static final String BNFT_PIN_NUM = "BNFT-PIN-NUM";
    public static final String BNFT_INDV_NAME = "BNFT-INDV-NAME";
    public static final String VCL_DUE_DT = "VCL-DUE-DT";

    public static final String AFB_BRIDGES_WEBSERVICE_URL = "AFBBridgesWebService";
    public static final String PDF_WEBSERVICE_URL = "PDFWebService";
    public static final String RTE_WEBSERVICE_URL = "RTEWebservice";
    public static final String BENIFIT_RENEW = "BenifitRenew";
    public static final String AUTOMAGIC_FC_URL = "autoMagicFCURL";
    public static final String APP_PDF_XML_UPLOAD="appPDFXMLUpload";

    public static final String AFB_APP_CONV_ST_FREE = "F";
    public static final String AFB_APP_CONV_ST_PROCESSING = "P";
    public static final String AFB_APP_CONV_ST_SUCCESS = "S";
    public static final String AFB_APP_CONV_ST_ERROR = "E";
    public static final String AFB_APP_CONV_ST_INCOMPLETE = "I";
    public static final String AFB_BRIDGES_APP_NUM = "BRIDGES_APP_NUM";
    public static final String WEBSERVICE_SUCCESS = "SUCCESS";
    public static final String WEBSERVICE_FAILURE = "FAILURE";
    public static final String WEBSERVICE_SKIP = "SKIP";

    public static final String APP_NUM_THRESHOLD = "APP_NUM_THRESHOLD";
    public static final String APP_NUM_FETCH_SIZE = "APP_NUM_FETCH_SIZE";

    public static final String CONVERSION_STATUS_FREE = "F";
    public static final String AFB_OFFICE_NUM = "AFB_OFFICE_NUM";

    // Added for Utility Types to generate PDF
    public static final String HT = "Heat";
    public static final String NE = "Non-Heat Electric";
    public static final String WS = "Water/Sewer";
    public static final String TP = "Telephone";
    public static final String CF = "Cooking Fuel";
    public static final String GR = "Garbage Removal";
    public static final String HIGH_TIMESTAMP1 = "2999-12-31 00:00:00.0";

    // Start of VaCMS - VaCMS Logo
    public static final String VACMS_LOGO_ALT = "36500";
    // End of VaCMS - VaCMS Logo

    public static final String USER_ID_TITLE_EN = "User ID";
    public static final String PWD_TITLE_EN = "Password";
    public static final String USER_ID_TITLE_ES = "Identificaci�n de Usuario";
    public static final String PWD_TITLE_ES = "Contrase�a";

    // Constants added for provider interface for SER
    public static final String PROVIDER_INTERFACE_SW = "PROVIDER_INTERFACE_SW";
    public static final String DTE_PROVIDER_WEBSERVICE_URL = "DTEProviderWebService";
    public static final String CE_PROVIDER_WEBSERVICE_URL = "CEProviderWebService";
    public static final String SE_PROVIDER_WEBSERVICE_URL = "SEProviderWebService";
    public static final String DTE_PROVIDER_USERNAME = "DTEUserName";
    public static final String DTE_PROVIDER_PASSWORD = "DTEPassword";
    public static final String CE_PROVIDER_USERNAME = "CEUserName";
    public static final String CE_PROVIDER_PASSWORD = "CEPassword";
    public static final String SE_PROVIDER_USERNAME = "SEUserName";
    public static final String SE_PROVIDER_PASSWORD = "SEPassword";
    public static final String MISMATCH_ERROR_MSG = "Account Details Provided does not Match";

    public static final String WS_AXIS_RTO_FAULT_STRING = "java.net.SocketTimeoutException: Read timed out";
    public static final String WS_AXIS_CTO_FAULT_STRING = "java.net.ConnectException: Connection timed out";
    public static final String WS_AXIS_OTO_FAULT_STRING = "java.net.SocketException: Operation timed out: connect:could be due to invalid address";

    public static final String CUSTOM_CURRENCY_PATTERN = "###.##";

    // Constants added for reason codes
    public static final String SER_REASON_CODE = "REASON_CODE";
    public static final String INITIAL_CYCLE = "I";
    public static final String VACMS_APP_NUM = "T";
    public static final String END_OF_BILLING = "E";
    public static final String END_OF_MONTH = "M";
    public static final String SHUT_OFF_HOLD = "H";
    public static final String WS_CALL_COUNT = "countRef";
    // Constants for SER Details Page
    public static final String SER_ENERGY = "SE";
    public static final String CATEGORY_CD = "CAT_CD";
    public static final String CLIENT_VRF_CD = "CS";
    public static final String PROVIDER_VRF_CD = "EF";
    public static final String BUTTON_APPLY_FOR_BENEFITS_FS_IMG = "/apply_for_benefits_fs.jpg";
    public static final String BUTTON_APPLY_FOR_BENEFITS_FS_ALT = "15079";
    public static final String BUTTON_APPLY_FOR_BENEFITS_FS = "BUTTON_APPLY_FOR_BENEFITS_FS";

    public static final String PDF_NO = "No";
    public static final String PDF_YES = "Yes";

    // Constants for programs
    public static final String FS = "FS";
    public static final String TF = "TF";
    public static final String MA = "MA";
    // VACMS start - converting FS to CC
    public static final String CC = "CC";
    // VACMS end - converting FS to CC
    public static final String SER = "SER";

    // Constants added for Shut-Off Hold
    public static final String HEAT = "H";
    public static final String ELECTRIC = "E";
    public static final String SS_APP_NUMBER = "SS_APP_NUMBER";
    public static final String ACC_NO_CNT = "ACC_NO_CNT";
    public static final String BILLING_END_DT = "BILLING_END_DT";

    public static final String END_OF_BILLING_HE = "BILLING_END_HE";
    public static final String END_OF_BILLING_HD = "BILLING_END_HD";
    public static final String END_OF_BILLING_EL = "BILLING_END_EL";
    public static final String END_OF_BILLING_ED = "BILLING_END_ED";

    public static final String COMPLETE = "C";
    public static final String VISIT_AGAIN = "V";

    public static final String WEB_SERVICE_COUNT = "2";
    public static final String IS_PAYMENT_RECORD_EXIST = "IS_PAYMENT_RECORD_EXIST";
    public static final String NON_WS_PROVIDER = "NON_WS_PROVIDER";
    public static final String IS_HEAT_ONLY = "IS_HEAT_ONLY";

    // added for routing deliverable fuel apps to local county office.
    public static final String FUEL_TYPE_CD_COAL = "CL";
    public static final String FUEL_TYPE_CD_FUEL_OIL = "FO";
    public static final String FUEL_TYPE_CD_LP_GAS = "LP";
    public static final String FUEL_TYPE_CD_WOOD = "WD";

    // Start of VaCMS - Addition of Caretaker or Non-Parent and Activity Screens
    // Child Care - Am I Eligible
    public static final String ADULTS_HSHL_INDV_COLLECTION = "ADULTS_HSHL_INDV_Collection";
    public static final String CHILDREN_HSHL_INDV_COLLECTION = "CHILDREN_HSHL_INDV_Collection";
    public static final String NOT_RELATED = "NR";
    public static final String RELATED_IN_ANOTHER_WAY = "OTH";
    public static final String APPROVED_ACTIVITY_SEL_GROUP = "APPROVED_ACTIVITY_SEL_GROUP";
    public static final String PARENTAL_ROLE_SEL_GROUP = "PARENTAL_ROLE_SEL_GROUP";
    public static final String PARENTAL = "PARENTAL";
    public static final String APRV = "APRV";
    // End of VaCMS - Addition of Caretaker or Non-Parent and Activity Screens

    // VACMS start - constants to calculate monthly income
    public static final BigDecimal WEEKS_IN_MONTH = new BigDecimal("4.3");
    public static final BigDecimal BI_WEEKS_IN_MONTH = new BigDecimal("2.15");
    public static final BigDecimal SEMI_MONTHS_IN_MONTH = new BigDecimal("2");
    public static final BigDecimal MONTHS_IN_YEAR = new BigDecimal("0.083333");
    // VACMS end - constants to calculate monthly income

    // EDSP Starts - CPH
    public static final String CPHI = "CPHI";
    // EDSP Ends

    // Transformation changes
    public static final String CMPN_CASE_IND = "CMPN_CASE_IND";
    public static final String RPT_PIN_NUM = "RPT_PIN_NUM";
    public static final String RPT_STAT_CD = "RPT_STAT_CD";
    public static final String SRC_RMC_APP_NUM = "SRC_RMC_APP_NUM";
    public static final String SRC_SBMT_TMS = "SRC_SBMT_TMS";
    public static final String UPDT_DT = "UPDT_DT";
    public static final String UPDATED_DT = "UPDATED_DT";
    public static final String DUE_DT = "DUE_DT";
    public static final String HMO_CHG_STAT_SW = "HMO_CHG_STAT_SW";
    public static final String NO_ACTN_RSN_CD = "NO_ACTN_RSN_CD";
    public static final String RCNT_ACDT_STAT_IND = "RCNT_ACDT_STAT_IND";
    public static final String DSGT_PAYE_SW = "DSGT_PAYE_SW";
    public static final String KC_FC_ST_GARD_SW = "KC_FC_ST_GARD_SW";
    public static final String NOTE_ADD_SW = "NOTE_ADD_SW";
    public static final String PRVD_CHG_SW = "PRVD_CHG_SW";

    public static final String CC_PGM_SW = "CC_PGM_SW";
    public static final String CTS_PGM_SW = "CTS_PGM_SW";
    public static final String FPW_PGM_SW = "FPW_PGM_SW";
    public static final String FS_PGM_SW = "FS_PGM_SW";
    public static final String FAM_MA_PGM_SW = "FAM_MA_PGM_SW";
    public static final String MPA_PGM_SW = "MPA_PGM_SW";

    public static final String EXT_APP_TYPE = "EXT_APP_TYPE";
    public static final String APP_COMMENTS = "APP_COMMENTS";
    public static final String ELEMENT_ROOMBOARD_INCOME = "ROOM_AND_BOARD_EARNING";
    public static final String ROOMBOARD_INCOMES = "ROOM_AND_BOARD_EARNINGS";
    public static final String ROOMBOARD_INCOME = "ROOM_AND_BOARD_EARNING_";
    public static final String DRUG_FELON = "DRUG_FELON_";
    public static final String DRUG_FELONS = "DRUG_FELONS";
    public static final String MAPP_DATA = "MAPP";
    public static final String MAPP_DATAS = "MAPPS";
    public static final String WLST_SEQ_NUM = "WLST_SEQ_NUM";

    public static final String ROOM_BOARD_INDVS = "ROOM_BOARD_INDVS";
    public static final String ROOM_BOARD_INDV = "ROOM_BOARD_INDV_";
    public static final String ELEMENT_ROOM_BOARD_INDV = "ROOM_BOARD_INDV";

    public static final String ROOM_BOARD_EXPENSES = "ROOM_AND_BOARD_PAIDS";
    public static final String ROOM_BOARD_EXPENSE = "ROOM_AND_BOARD_PAID_";
    public static final String ELEMENT_ROOM_BOARD_EXPENSE = "ROOM_AND_BOARD_PAID";
    public static final String ELEMENT_MEDICAL_COVERAGE = "MEDICAL_COVERAGE";
    public static final String MEDICAL_EXPENSE = "MEDICAL_EXPENSE_";
    public static final String COVERAGE_DATA = "COVERAGE_DATA_";
    public static final String COVERAGE_DATAS = "COVERAGE_DATAS";

    public static final String ELEMENT_DURG_FELON = "DRUG_FELON";
    public static final String ELEMENT_MAPP = "MAPP";
    public static final String ELEMENT_BURIAL = "BURIAL_ASSET";
    public static final String ELEMENT_LIFE_INSURANCE_ASSET = "LIFE_INSURANCE_ASSET";
    public static final String ELEMENT_SUPPORT_PAYMENT = "SUPPORT_PAYMENT";
    public static final String MEDICAL_EXPENSES = "MEDICAL_EXPENSES";
    public static final String ELEMENT_MEDICAL_EXPENSE = "MEDICAL_EXPENSE";
    public static final String LIFE_INSURANCE_ASSETS = "LIFE_INSURANCE_ASSETS";
    public static final String LIFE_INSURANCE_ASSET = "LIFE_INSURANCE_ASSET_";
    public static final String SUPPORT_PAYMENTS = "SUPPORT_PAYMENTS";
    public static final String SUPPORT_PAYMENT = "SUPPORT_PAYMENT_";
    public static final String IRWE = "IRWE_";
    public static final String HSHL_ADDR_COUNTY_CHANGED = "HSHL_ADDR_COUNTY_CHANGED";
    public static final String HMO_CHANGED = "HMO_CHANGED";
    public static final String INST_MA_RQST_SW = "INST_MA_RQST_SW";
    // constants related to ecf Status Update process
    public static final String ACCESSTOCWWECFSTATUS_QUEUE = "accessToCwwECFStatus_queue";
    public static final String ACCESSTOCWWECFSTATUS_QCF = "accessToCwwECFStatus_qcf";
    // RMB-Transformation CLA Constants
    public static final String CLA_CHG_STAT_IND = "CLA_CHG_STAT_IND";
    public static final String CLA_PGM_SW = "CLA_PGM_SW";
    public static final String RQST_IND = "RQST_IND";
    public static final String CLA_INDV_SEQ_NUM = "CLA_INDV_SEQ_NUM";
    public static final String PREV_CERT_END_DT = "PREV_CERT_END_DT";
    public static final String BCP_CLA_RQST_SW = "BCP_CLA_RQST_SW";

    public static final String RMB_RQST = "RMB_RQST";
    public static final String HCE = "HCE";
    public static final String RMB = "RMB";
    public static final String SMF = "SMF";
    public static final String RMB_RQST_COLLECTION = "RMB_RQST_COLLECTION";
    public static final String QUESTION_EXTRACTION_HANDLER = "QUESTION_EXTRACTION_HANDLER";

    public static final String RMC_CHG_SEL_PRFL = "RMC_CHG_SEL_PRFL";
    public static final short RMB_NO_CHANGE_SEL_IND = 2;

    public static final String HE_EXT_SHELTER = "SH";
    public static final String HE_EXT_UTILITY = "UT";
    public static final String HE_EXT_ROOM_AND_BOARD = "RB";
    public static final String HE_EXT_DEPENDENT_CARE = "DC";
    public static final String HE_EXT_PAYMENT_AND_OBLIGATIONS = "PO";
    public static final String HE_EXT_IRWE = "IR";

    // Assets Extraction Constants
    public static final String ASSETS_EXT_LIQUID = "AL";
    public static final String ASSETS_EXT_VEHICLE = "AV";
    public static final String ASSETS_EXT_REAL_PROPERTY = "RP";
    public static final String ASSETS_EXT_PERSONAL_PROPERTY = "PP";
    public static final String ASSETS_EXT_BURIAL = "AB";
    public static final String ASSETS_EXT_LIFE_INSURANCE = "LI";

    // Other Benefits Extraction Constants
    public static final String OB_EXT_SCHOOL_ENRL = "SE";
    public static final String OB_EXT_MAPP = "MP";
    public static final String OB_EXT_OTHER_DTLS = "OD";

    // Other Income Extraction Constants
    public static final String OI_EXT_ROOM_AND_BOARD_EARNINGS = "RB";
    public static final String OI_EXT = "OI";

    // Job Income Extraction Cosntants
    public static final String JI_EXT = "JI";

    // Wage Delete
    public static final String DELETED_WAGE = "DELETED_WAGE";

    public static final String IS_VALID = "IS_VALID";

    // ADDED FOR RMB CHANGES - PCR3 40362
    public static final String RMC_CAT_OTHER_BENEFITS_PRFL = "OB";
    public static final String RMC_CAT_LIQUID_ASSET_PRFL = "LA";
    public static final String RMC_CAT_CASH_LIQUID_ASSET_PRFL = "CAS";
    public static final String RMC_CAT_BANK_LIQUID_ASSET_PRFL = "FA";
    public static final String RMC_CAT_OTHER_LIQUID_ASSET_PRFL = "OT";
    public static final String RMC_CAT_XFER_LIQUID_ASSET_PRFL = "XR";
    // adding othr liquid categories
    public static final String RMC_CAT_LIQUID_ASSET_ANNUITY_PRFL = "MQ";// liquid_aset_disable_blind_resp
    public static final String RMC_CAT_LIQUID_ASSET_IRA_PRFL = "IR";// liquid_asset_ira_resp
    public static final String RMC_CAT_LIQUID_ASSET_IRS_RET_PRFL = "RA"; // liquid_asset_irs_retirmnt_resp
    public static final String RMC_CAT_LIQUID_ASSET_SAVINGS_ACC_PRFL = "SP";// liquid_asset_savings_acc_resp
    public static final String RMC_CAT_LIQUID_ASSET_PENSION_PLAN_PRFL = "PP";// liquid_asset_pension_plan_resp
    public static final String RMC_CAT_LIQUID_ASSET_PROMISSORY_PRFL = "DT";// liquid_asset_promissory_resp
    public static final String RMC_CAT_LIQUID_ASSET_RETIREMENT_PRFL = "RE";// liquid_asset_retirement_resp
    public static final String RMC_CAT_LIQUID_ASSET_STOCK_BONDS_PRFL = "ST";// liquid_asset_stocks_bonds_resp
    public static final String RMC_CAT_LIQUID_ASSET_TRUST_FUND_PRFL = "TR";// liquid_asset_trust_fund_resp

    public static final String RMC_CAT_BURIAL_ASSET_PRFL = "BA";
    public static final String RMC_CAT_VEHICLE_ASSET_PRFL = "VA";
    public static final String RMC_CAT_REAL_ASSET_PRFL = "RA";
    public static final String RMC_CAT_PERSONAL_ASSET_PRFL = "PA";
    public static final String RMC_CAT_LIFE_INS_ASSET_PRFL = "LI";
    public static final String RMC_CAT_OTHER_BILL_PRFL = "OBP";

    public static final String APPROVED_ACTIVITY = "AA";
    public static final String PREGNANCY_CHANGE = "PC";
    public static final String CHANGE_DRUG_FELONY = "CD";
    public static final String BECAME_DRUG_FELONY = "BD";
    public static final String INDV_DMGRPH_CHANGE = "DC";

    // category types for RMB/RMC Other Benefits
    public static final String SCHOOL_ENROLLEMENT_CHANGE = "SC";
    public static final String MAPP_CHANGE = "MC";
    public static final String REQUEST_MAPP = "RM";
    public static final String ADD_SCHOOL_ENROLLMENT = "AS";
    public static final String ADD_MEDICARE = "AM";
    public static final String ADD_NURSING = "AU";
    public static final String ADD_OUTOFSTATE = "AO";
    public static final String ADD_HOSPICE = "AP";
    public static final String CURRENT_MAPP_TYPE = "CURRENT_MAPP_TYPE";
    public static final String ADD_HOSPITAL = "AH";

    // category types for RMB/RMC Expenses
    public static final String ROOM_BOARD_CHANGE = "RB";

    public static final String NEVER_MARRIED = "SI";

    public static final String ICON_DELETE_RECORD = "ICON_DELETE_RECORD";
    public static final String ICON_DELETE_RECORD_IMG = "/icon_delete_record.gif";
    public static final String ICON_DELETE_RECORD_ALT = "64056";
    public static final String ICON_DELETE_RECORD_DISABLED_IMG = "/icon_delete_record.gif";
    public static final String APP_SUBMIT_PVLG = "APP_SUBMIT_PVLG";
    public static final String APP_PW_SUBMIT_PVLG = "APP_PW_SUBMIT_PVLG";
    public static final String APP_CH_SUBMIT_PVLG = "APP_CH_SUBMIT_PVLG";
    // APP Application status
    public static final String APPLICATION_UNSUBMITTED_REQUEST = "UR"; // Un
    // submitted
    // request
    public static final String APPLICATION_DEADSTOP = "DS"; // Dead Stop
    public static final String APPLICATION_ABANDONED = "AB"; // Abandoned

    // HC ENROLL STATUS CODES
    public static final String HCE_STATUS_INPROGRESS = "IP";
    public static final String HCE_STATUS_COMPLETE = "CP";
    public static final String HCE_STATUS_EXPIRED = "EX";

    // HNA Constants
    public static final String HNA_INDV_HLTH_PRFL_MASTER = "HNA_INDV_HLTH_PRFL_MASTER";
    public static final String HNA_NUMBER = "HNA_NUMBER";
    public static final String HNA_APPLICATION_COMPLETE = "CP";
    public static final String HNA_APPLICATION_NOT_STARTED = "NS";

    public static final String DATA_FOUND = "0000";
    public static final String DATA_NOT_FOUND = "0001";

    // added for hmo exmp
    public static final String HMO_EMEMP_INDICATOR = "D";
    public static final String HMO_EXMP_IC_ELIGIBILITY_FILE_NAME = "receiveHmoExmpICFileName";
    public static final String HMO_EXMP_OUTPUT_FILE_NAME_FOR_CARES = "hmoExmpOutputFileName";
    public static final String ERROR_HMO_EXMP_OUTPUT_FILE_NAME_FOR_CARES = "errorHmoExmpFileName";
    public static final String EMPTY_EXEMP_RSN_CD_TO_CARES_OUTPUT_FILE = "   ";
    // end

    public static final String WORKER_MODE = "WORKER_MODE";

    // HMO_SELECTION Constants

    public static final String BUTTON_SELECT_AN_HMO = "BUTTON_SELECT_AN_HMO";
    public static final String BUTTON_SELECT_AN_HMO_SELECTED_IMG = "/button_select_an_hmo_selected.gif";
    public static final String BUTTON_SELECT_AN_HMO_UNSELECTED_IMG = "/button_select_an_hmo_unselected.gif";
    public static final String BUTTON_SELECT_AN_HMO_SELECTED_ALT = "63000";
    public static final String BUTTON_SELECT_AN_HMO_UNSELECTED_ALT = "63000";

    public static final String BUTTON_HMO_REPORT_CARD = "BUTTON_HMO_REPORT_CARD";
    public static final String BUTTON_HMO_REPORT_CARD_SELECTED_IMG = "/button_reportcard_selected.gif";
    public static final String BUTTON_HMO_REPORT_CARD_UNSELECTED_IMG = "/button_reportcard_unselected.gif";
    public static final String BUTTON_HMO_REPORT_CARD_SELECTED_ALT = "63001";
    public static final String BUTTON_HMO_REPORT_CARD_UNSELECTED_ALT = "63001";

    public static final String BUTTON_PROVIDER_SEARCH = "BUTTON_PROVIDER_SEARCH";
    public static final String BUTTON_PROVIDER_SEARCH_SELECTED_IMG = "/button_provider_search_selected.gif";
    public static final String BUTTON_PROVIDER_SEARCH_UNSELECTED_IMG = "/button_provider_search_unselected.gif";
    public static final String BUTTON_PROVIDER_SEARCH_SELECTED_ALT = "63006";
    public static final String BUTTON_PROVIDER_SEARCH_UNSELECTED_ALT = "63006";

    public static final String BUTTON_PROVIDER_SEARCH_TAB = "BUTTON_PROVIDER_SEARCH_TAB";
    public static final String BUTTON_PROVIDER_SEARCH_TAB_SELECTED_IMG = "/doctor_search_left_tab_active.gif";
    public static final String BUTTON_PROVIDER_SEARCH_TAB_UNSELECTED_IMG = "/doctor_search_left_tab_inactive.gif";
    public static final String BUTTON_PROVIDER_SEARCH_TAB_SELECTED_ALT = "63006";
    public static final String BUTTON_PROVIDER_SEARCH_TAB_UNSELECTED_ALT = "63006";

    // added for HMO selection PCR :43585
    public static final String HMO_NAME_OVERRIDE_DETAILS_PAGE = "HMO_NAME_OVERRIDE_DETAILS_PAGE";
    public static final String HSCMD_COMMENTS_SUMMARY_LISTVIEW = "HSCMDCommentsSummaryListView";
    public static final String COMMENTS_DISPLAY_MODE = "COMMENTS_DISPLAY_MODE";
    public static final String NORMAL_COMMENTS = "NORMAL_COMMENTS";
    public static final String CASE_CMT_COLLECTION = "CASE_CMT_Collection";
    public static final String VIEW_COMMENTS = "VIEW_COMMENTS";
    public static final String VIEW_CASE_CMT_CARGO = "VIEW_CASE_CMT_Cargo";
    public static final String CASE_NUMBER_COMMENTS = "CASE_NUMBER_COMMENTS";
    public static final String SEQ_NUMBER_COMMENTS = "SEQ_NUMBER_COMMENTS";
    public static final String BUTTON_HOSPITAL_SEARCH = "BUTTON_HOSPITAL_SEARCH";
    public static final String BUTTON_HOSPITAL_SEARCH_SELECTED_IMG = "/hospital_search_selected.gif";
    public static final String BUTTON_HOSPITAL_SEARCH_UNSELECTED_IMG = "/hospital_search_unselected.gif";
    public static final String BUTTON_HOSPITAL_SEARCH_SELECTED_ALT = "63005";
    public static final String BUTTON_HOSPITAL_SEARCH_UNSELECTED_ALT = "63005";
    // end
    public static final String BUTTON_CLINIC_OR_HOSPITAL_SEARCH = "BUTTON_CLINIC_OR_HOSPITAL_SEARCH";
    public static final String BUTTON_CLINIC_OR_HOSPITAL_SEARCH_SELECTED_IMG = "/button_clinicorhospital_search_selected.gif";
    public static final String BUTTON_CLINIC_OR_HOSPITAL_SEARCH_UNSELECTED_IMG = "/button_clinicorhospital_search_unselected.gif";
    public static final String BUTTON_CLINIC_OR_HOSPITAL_SEARCH_SELECTED_ALT = "63005";
    public static final String BUTTON_CLINIC_OR_HOSPITAL_SEARCH_UNSELECTED_ALT = "63005";

    public static final String BUTTON_BCSC_HMO_SEARCH = "BUTTON_BCSC_HMO_SEARCH";
    public static final String BUTTON_BCSC_HMO_SEARCH_SELECTED_IMG = "/button_bcsc_search_selected.gif";
    public static final String BUTTON_BCSC_HMO_SEARCH_UNSELECTED_IMG = "/button_bcsc_search_unselected.gif";
    public static final String BUTTON_BCSC_HMO_SEARCH_SELECTED_ALT = "63004";
    public static final String BUTTON_BCSC_HMO_SEARCH_UNSELECTED_ALT = "63004";

    public static final String BUTTON_WHY_ONE = "BUTTON_WHY_ONE";
    public static final String BUTTON_WHY_ONE_IMG = "/button_why_one.gif";
    public static final String BUTTON_WHY_ONE_ALT = "63009";

    public static final String BUTTON_SELECT_THIS_HMO_CHECK = "BUTTON_SELECT_THIS_HMO_CHECK";
    public static final String BUTTON_SELECT_THIS_HMO_CHECK_IMG = "/button_select_this_hmo_white.gif";
    public static final String BUTTON_SELECT_THIS_HMO_CHECK_ALT = "63010";

    public static final String BUTTON_FEE_FOR_SERVICE = "BUTTON_FEE_FOR_SERVICE";
    public static final String BUTTON_FEE_FOR_SERVICE_IMG = "/button_fee_for_service.jpg";
    public static final String BUTTON_FEE_FOR_SERVICE_ALT = "63012";

    public static final String STAR_FILLED = "STAR_FILLED";
    public static final String STAR_FILLED_IMG = "/star_filled.gif";
    public static final String STAR_FILLED_ALT = "";

    public static final String STAR_EMPTY = "STAR_EMPTY";
    public static final String STAR_EMPTY_IMG = "/star_empty.gif";
    public static final String STAR_EMPTY_ALT = "";

    public static final String MAX_COUNT = "MAX_COUNT";
    // Facility Types
    public static final String FACILITY_ALL = "A";
    public static final String FACILITY_CLINICS = "C";
    public static final String FACILITY_HOSPITALS = "H";

    public static final String DOCTORS = "doctors";
    public static final String DOCTORS_CAPS = "Doctors";
    public static final String DOCTOR = "doctor";
    public static final String DOCTOR_YOU_KNOW = "doctor you know";
    public static final String HIS_OR_HER = "his or her";
    public static final String OR_LOCATION = "and or location.";

    public static final String CLINICS_OR_HOSPITALS = "hospitals";
    public static final String CLINIC_OR_HOSPITAL = "clinic or hospital";
    public static final String CERTAIN_CLINIC_OR_HOSPITAL = "certain clinic or hospital";
    public static final String THE = "the";
    public static final String DOCTOR_GENDER_LOCATION = "of doctor, gender, language, or location";

    public static final String SEARCH_WARNING_CODE = "SEARCH_WARNING_CODE";
    public static final String SEARCH_WARNING_VALUES = "SEARCH_WARNING_VALUES";

    public static final String BUTTON_HEADER_HELP_IMG = "/access/images/button_header_help.gif";
    public static final String HMO_ENROLLMENT_DATE = "HMO_ENROLLMENT_DATE";
    public static final String BUTTON_SEARCH = "BUTTON_SEARCH";
    public static final String BUTTON_SEARCH_IMG = "/button_search.gif";
    public static final String BUTTON_SEARCH_ALT = "63007";
    public static final String HAVE_DIABETES = "HDB";
    public static final String NO_DIABETES = "NDB";
    public static final String HAVE_ASTHMA = "HAS";
    public static final String NO_ASTHMA = "NAS";
    public static final String NO_TOBACCO = "NTB";
    public static final String HAVE_TOBACCO = "HTB";
    public static final String CUST_STSF_SCORE = "CS";
    public static final String PREFERRED_PROVIDERS = "PP";
    public static final String PREFERRED_CLINICS = "PRC";

    // PCR# 35979 - AFB - CLA - Program Code for CWW Eligibility WebService
    public static final String CWW_CLA_PGM_TYPE = "MED";
    public static final String HOUSE_HOLD_ADDRESS = "HC_ENRL_Collection";
    public static final String HC_ENRL_COLLECTION = "HC_ENRL_Collection";

    // Constants for AIM CLA changes
    public static final String CURRENT_PAST_COVERAGE = "CURRENT_PAST_COVERAGE";
    public static final String CURRENT_COVERAGE = "CURRENT_COVERAGE";
    public static final String PAST_COVERAGE = "PAST_COVERAGE";
    public static final String CURR = "CURR";
    public static final String PAST = "PAST";
    public static final String CURR_PAST_CVG_SEL_GROUP = "CURR_PAST_CVG_SEL_GROUP";
    public static final String CHILDLESS_ADULT = "CLA";
    public static final String VERSION_LOCAL = "VERSION_LOCAL";
    public static final String VERSION_ESC = "VERSION_ESC";
    public static final String DISCLAIMER_CLA = "DISCLAIMER_CLA";
    public static final String DISCLAIMER_EBD = "DISCLAIMER_EBD";
    public static final String DISCLAIMER_FPW = "DISCLAIMER_FPW";

    // Constant for HC Enrolemnt Number
    public static final String HC_ENRL_NUM = "HC_ENRL_NUM";
    public static final String USER_SELECTED = "US";
    public static final String USER_SELECTED_USING_IVR = "UI";
    public static final String CHOICE_FORM = "CF";
    public static final String AUTO_SELECTED = "AS";
    public static final String AUTO_EXEMPTION = "AE";
    public static final String WORKER_SELECTED = "WS";
    public static final String WORKER_EXEMPTION = "WE";
    public static final String BATCH_AUTO_SELECTED = "BA";
    public static final String FULL_CAPACITY = "Z04";
    public static final String ENROLLMENT_PERIOD_ENDED = "ED";
    public static final String OUT_OF_SRVC_AREA = "Z03";
    public static final String OVERRIDES_REASON = "OR";
    public static final String JUST_CAUSE = "E03";
    public static final String FEE_FOR_SERVICE = "FS";
    public static final String HC_ENROLMENT_INPROGRESS = "IP";
    public static final String HC_ENROLMENT_NOT_STARTED = "NS";
    public static final String OUT_OF_SRVC = "O";
    public static final String USER_MODE = "USER_MODE";
    public static final String USER_TYPE = "USER_TYPE";
    public static final String HMO_USER_TYPE = "HMO_USER_TYPE";

    public static final String HMO_APPLICATION_NOT_STARTED = "NS";
    public static final String HMO_APPLICATION_IN_PROGRESS = "IP";
    public static final String HMO_APPLICATION_COMPLETE = "CP";

    public static final String ICON_LEFT_ARROW = "ICON_LEFT_ARROW";
    public static final String ICON_LEFT_ARROW_DOUBLE = "ICON_LEFT_ARROW_DOUBLE";
    public static final String ICON_RIGHT_ARROW = "ICON_RIGHT_ARROW";
    public static final String ICON_RIGHT_ARROW_DOUBLE = "ICON_RIGHT_ARROW_DOUBLE";
    public static final String ICON_SORT_DOWN_IMG = "/cares/images/icon_sort_down.gif";
    public static final String ICON_SORT_UP_IMG = "/cares/images/icon_sort_up.gif";

    public static final String HC_ENRL_DUE_DATE = "HC_ENRL_DUE_DATE";

    public static final String HMO_SELECTION_APPLICATION_TYPE = "HMO_SELECTION_APPLICATION_TYPE";
    public static final String HMO_SELECTION_MODE = "HMO_SELECTION_MODE";
    public static final String CMB = "CMB";
    public static final String IVR = "IVR";
    public static final String ELIG_CLA_PINS = "ELIG_CLA_PINS";
    public static final String ELIG_FAMILY_PINS = "ELIG_FAMILY_PINS";
    public static final String ELIG_FMA_PINS = "FMAELIGPINS";
    public static final String HMO_ENROLLMENTS = "HMO_ENROLLMENTS";
    public static final String HMO_CLA_CASE_NUM = "HMO_CLA_CASE_NUM";
    public static final String HMO_FAMILY_CASE_NUM = "HMO_FAMILY_CASE_NUM";
    public static final String KEEP_HMO_STATUS = "KEEP_HMO_STATUS";
    public static final String NEED_NEW_HMO = "NEED_NEW_HMO";
    public static final String CURRENT_HMO_ENROLLMENTS = "CURRENT_HMO_ENROLLMENTS";
    public static final String CURRENT_HMO_ENROLLMENTS_OVRDS = "CURRENT_HMO_ENROLLMENTS_OVRDS";
    public static final String HMO_SESSION_KEYS = "HMO_SESSION_KEYS";
    public static final String RMC_HMO_UPDATE = "RMC_HMO_UPDATE";
    public static final String ORIGINAL_SESSION_VALUES = "ORIGINAL_SESSION_VALUES";
    public static final String RMC_HMO_EDIT_PAGEACTION = "RMC_HMO_EDIT_PAGEACTION";
    public static final String RMC_HMO_PAGE = "RMC_HMO_PAGE";
    public static final String HMO_PEOPLE_HANDLER = "HMO_PEOPLE_HANDLER";
    public static final String HMO_CHANGE_NUMBER = "HMO_CHANGE_NUMBER";

    // Constants for Payment module
    public static final char ONLINE_PAYMENT = 'O';
    public static final char PHONE_PAYMENT = 'P';
    public static final char MAIL_PAYMENT = 'M';
    public static final String BUTTON_PAYMENT_SLIP_IMG = "/button_payment_slip.gif";
    public static final String BUTTON_PAYMENT_SLIP = "BUTTON_PAYMENT_SLIP";
    public static final String BUTTON_PAYMENT_SLIP_ALT = "64054";
    public static final String FEE_PAYMENT_NOT_STARTED = "NS";
    public static final String FEE_PAYMENT_WAIVED = "W";
    public static final String FEE_PAYMENT_IN_PROGRESS = "IP";
    public static final String FEE_PAYMENT_COMPLETED = "CP";
    public static final String FEE_PAYMENT_FAILED = "F";
    public static final String FEE_PAYMENT_PARTIAL = "PP";
    public static final String FEE_PAYMENT_SUBMITTED_ONLINE = "SO";
    public static final String FEE_PAYMENT_SUBMITTED_MAIL = "SM";
    public static final String FEE_PAYMENT_EXCESS_PAYMENT = "EX";
    public static final String FEE_PAYMENT_STARTED_NOT_SUBMITTED = "SNS";
    public static final int FEE_PAYMENT_AMOUNT_SIXTY = 60;
    public static final String CLA_FEE_REQ_NO_TO_WAIVED = "NW";
    public static final int FEE_PAYMENT_AMOUNT_HUNDRED = 100;

    public static final String TRAN_METHOD_CREDIT_CARD = "CC";
    public static final String TRAN_METHOD_ECHECK = "ACH";
    public static final String TRAN_METHOD_PERSONAL_CHECK = "PC";
    public static final String TRAN_METHOD_CASH = "CS";
    public static final String TRAN_METHOD_OTHER = "OT";

    public static final String TRAN_MODE_WEB = "W";
    public static final String TRAN_MODE_IVR = "I";
    public static final String TRAN_MODE_ADMIN = "A";
    public static final String TRAN_MODE_MANUAL = "M";

    public static final String TRAN_STAT_SUBMITTED = "SU";
    public static final String TRAN_STAT_IN_PROGRESS = "IP";
    public static final String TRAN_STAT_COMPLETED = "CP";
    public static final String TRAN_STAT_FAILED = "F";
    public static final String TRAN_STAT_EXCEPTION = "EX";
    public static final String TRAN_TYPE_MAKE_PAYMENT = "MP";
    public static final String TRAN_TYPE_REFUND_PAYMENT = "RP";

    public static final String USER_TYPE_CUSTOMER = "C";
    public static final String USER_TYPE_WORKER = "W";
    public static final String USER_TYPE_IVR = "I";
    public static final String USER_TYPE_CHOICE_FORM = "F";
    public static final String USER_TYPE_WORKER_WITH_CASE = "WC";
    public static final String NATIVE_AMERICAN = "E74";
    public static final String MIGRANT_WORKER = "E75";
    public static final String ENGLISH = "E";
    public static final String SPANISH = "S";
    public static final String AFB_APPLICATION = "A";
    public static final String PAGEONE_APPLICATION = "P";
    public static final String NON_CONTEXT = "NC";

    public static final String PROVIDER_TABLE = "P";
    public static final String FACILITY_TABLE = "F";

    public static final String BUTTON_MYACCESS = "BUTTON_MYACCESS";
    public static final String BUTTON_MYACCESS_IMG = "/MyACCESS_Button.jpg";
    public static final String BUTTON_MYACCESS_ALT = "15071";

    public static final String DE_REQUEST_CD = "DR";
    public static final String OPEN_REQUEST_CD = "OP";
    public static final String DENIED_REQUEST_CD = "DE";
    public static final String EXPIRED_REQUEST_CD = "EP";
    public static final String RE_REQUEST_CD = "RR";
    public static final String COMPLETE_REQUEST_CD = "CP";
    public static final String CONFIRMED_REQUEST_CD = "CN";
    public static final String UN_REQUEST_CD = "UN";

    public static final String HMO = "HMO";
    public static final String HMO_DATE = "DATE";
    public static final String HMO_RECORDS_COUNT = "RECORDS";
    public static final String HMO_IC_MCO_ID = "IC_MCO_ID";
    public static final String HMO_MC_PROGRAM = "MC_PROGRAM";
    public static final String HMO_NAME = "HMO_NAME";
    public static final String HMO_LINE_1_ADDRESS = "LINE_1_ADDRESS";
    public static final String HMO_LINE_2_ADDRESS = "LINE_2_ADDRESS";
    public static final String HMO_CITY = "CITY";
    public static final String HMO_STATE = "STATE";
    public static final String HMO_ZIP_CODE = "ZIP_CODE";
    public static final String HMO_PHONE = "PHONE_NUMBER";
    public static final String HMO_DUAL_SERVICES_INDICATOR = "DUAL_SERVICES_INDICATOR";
    public static final String HMO_REASSIGN_90_DAYS_INDICATOR = "REASSIGN_90_DAYS_INDICATOR";
    public static final String HMO_REASSIGN_6_MONTHS_INDICATOR = "REASSIGN_6_MONTHS_INDICATOR";
    public static final String HMO_RECIPENT_CHOICE_INDICATOR = "RECIPENT_CHOICE_INDICATOR";
    public static final String HMO_AUTO_ASSIGNED_ALLOWED = "AUTO_ASSIGNED_ALLOWED";
    public static final String HMO_NEW_ENROLLMENT_INDICATOR = "NEW_ENROLLMENT_INDICATOR";
    public static final String HMO_AGE_RESTRICTION_CODE = "AGE_RESTRICTION_CODE";
    public static final String HMO_COUNTY_NUM = "COUNTY_NUM";
    public static final String HMO_EFFECTIVE_BEGIN_DATE = "EFFECTIVE_BEGIN_DATE";
    public static final String HMO_EFFECTIVE_END_DATE = "EFFECTIVE_END_DATE";
    public static final String HMO_PRIMARY_SERVICE_AREA_INDICATOR = "PRIMARY_SERVICE_AREA_INDICATOR";
    public static final String HMO_DECERTIFICATION_REASON_CD = "DECERTIFICATION_REASON_CD";
    public static final String HMO_DECERTIFICATION_DATE = "DECERTIFICATION_DATE";
    public static final String HMO_CURRENT_ENROLLEES = "CURRENT_ENROLLEES";
    public static final String HMO_MAXIMUM_ENROLLEES = "MAXIMUM_ENROLLEES";
    public static final String HMO_FUTURE_ENROLLEES = "FUTURE_ENROLLEES";
    public static final String HMO_SERVICE_AREA = "SERVICE_AREA";
    public static final String HMO_ENROLLEE_COUNT = "ENROLLEE_COUNT";
    public static final String HMO_RURAL_INDICATOR = "RURAL_INDICATOR";

    // Constant for save n exit session attribute
    public static final String SAVE_EXIT = "SAVE_EXIT";

    // AccessBatch Constants
    public static final String HMO_GENERAL_INFORMATION = "HMO_GENERAL_INFORMATION";
    public static final String MCO_ID_LIST = "MCO_ID_LIST";
    public static final String MCO_ID = "MCO_ID";
    public static final String HMO_WEBSITE_ADDRESS = "HMO_WEBSITE_ADDRESS";
    public static final String HMO_SPECIAL_SERVICES = "HMO_SPECIAL_SERVICES";
    public static final String CODE = "CODE";
    public static final String HMO_DAILY_CONTACT_EMAIL_ADDRESS = "HMO_DAILY_CONTACT_EMAIL_ADDRESS";
    public static final String HMO_MONTHLY_CONTACT_EMAIL_ADDRESS = "HMO_MONTHLY_CONTACT_EMAIL_ADDRESS";
    public static final String PROVIDERS = "PROVIDERS";
    public static final String NPI = "NPI";
    public static final String LAST_NAME = "LAST_NAME";
    public static final String MIDDLE_INTIAL = "MIDDLE_INITIAL";
    public static final String GENDER = "GENDER";
    public static final String LINE_1_ADDRESS = "LINE_1_ADDRESS";
    public static final String LINE_2_ADDRESS = "LINE_2_ADDRESS";
    public static final String HMO_ZIP = "ZIP";
    public static final String COUNTY = "COUNTY";
    public static final String CLINIC_NAME = "CLINIC_NAME";
    public static final String CLINIC_NPI = "CLINIC_NPI";
    public static final String PROVIDER_OFFICE_HOURS_TENTHS = "PROVIDER_OFFICE_HOURS_TENTHS";
    public static final String MAXIMUM_PATIENTS = "MAXIMUM_PATIENTS";
    public static final String ACCEPT_NEW_PATIENT = "ACCEPT_NEW_PATIENT";
    public static final String PRIMARY_CARE_INDICATOR = "PRIMARY_CARE_INDICATOR";
    public static final String FOREIGN_LANGUAGES = "FOREIGN_LANGUAGES";
    public static final String SPECIALTIES = "SPECIALTIES";
    public static final String FACILITES = "FACILITIES";
    public static final String FACILITY_NUM = "FACILITY_NUM";
    public static final String CRE_IND = "CRE_IND";

    public static final String SPECIAL_SERVICES = "SS";
    public static final String FOREIGN_LANGUAGE = "LN";
    public static final String SPECIALTY = "DT";

    public static final String HMO_IDS = "HMO_IDS";
    // cntl num
    public static final String PROVIDER_CNTL_NUM_ID = "PR";
    public static final String HMO_CNTL_NUM_ID = "HM";
    public static final String HCE_CNTL_NUM_ID = "HC";

    public static final String WS_PENDING = "PE";
    public static final String WS_EXCEPTION = "EX";
    public static final String WS_READY = "RE";
    public static final String WS_PROCESSED = "PR";

    // Constants used for Indiv Case Profile, Audit Trial and Alert ACTION
    // INDICATORS
    public static final String ADD_ACTION_IND = "A";
    public static final String DELETE_ACTION_IND = "D";
    public static final String CHANGE_ACTION_IND = "C";
    public static final String ERROR_ACTION_IND = "E";
    public static final String ACTN_KEY_CD_APP = "AN";
    public static final String ACTN_KEY_CD_CASE = "CN";

    public static final String FEE_REMITTANCE_FILE_NAME = "RFName";
    public static final String FEE_REMITTANCE_FILE_LOCATION = "RFLoc";
    public static final String TRANSACTION_CONFIRMATION_ID = "TransationConfirmationId";
    public static final String BILLER_PRODUCT_CODE = "BillerProductCode";
    public static final String AMOUNT_DUE = "AmountDue";
    public static final String PAYMENT_AMOUNT1 = "PaymentAmount";
    public static final String TOTAL_AMOUNT = "TotalAmount";
    public static final String PAYMENT_EFFECTIVE_DATE = "PaymentEffectiveDate";
    public static final String INITIATION_DATE = "InitiationDate";
    public static final String PAYMENT_TYPE1 = "PaymentType";
    public static final String PAYMENT_AUTHORIZATION = "PaymentAuthorization";
    public static final String PAYMENT_STATUS = "PaymentStatus";
    public static final String ACH_RETURN_CODE = "ACHReturnCode";
    public static final String REASON_DESCRIPTION = "ReasonDescription";
    public static final String RETURN_DATE = "ReturnDate";
    public static final String ACCESS_METHOD = "AccessMethod";
    public static final String FEE_NUMER = "FeeNumber";
    public static final String TRAN_MODE = "WEB";
    public static final String EMAIL = "Email";
    public static final String USER_TYPE1 = "Usertype";

    public static final String APP_STAT_CD_CONFIRM_HCE = "CN";

    public static final String CASENUM = "CASENUM";
    public static final String HLESS_RSN_CD = "HO";

    public static final String RECEIVED = "Received";
    public static final String REFUND_REQUIRED = "Refund Required";
    public static final String COMPLETED = "Completed";
    public static final String FEE_STATUS_COMPLETED = "CO";
    public static final String RURAL_EXEMPTION = "Z02";

    public static final String FEE_SERVER = "feeFTPServer";
    public static final String FEE_USERNAME = "feeUsername";
    public static final String FEE_PASSWORD = "feePassword";
    public static final String FEE_PATH = "feePath";
    public static final String FEE_BATCH_FILE_LOCATION = "feeBatchFileLocation";
    public static final String FEE_BATCH_FILE_NAME = "feeFileName";
    public static final String FEE_FAILED_CLEARANCE = "FC";
    public static final String SEND_REMITTANCE_EMAIL = "SEND_REMITTANCE_EMAIL";
    public static final String SEND_REMITTANCE_FAILURE_EMAIL = "SEND_REMITTANCE_FAILURE_EMAIL";
    public static final String FEE_FAILED_FLAG = "F";
    public static final String FEE_EMAIL_FLAG = "E";

    public static final String HMO_STATE_EMAIL_DAILY_DISTRIBUTION_ID = "HMO_STATE_EMAIL_DAILY_DISTRIBUTION_ID";
    public static final String HMO_STATE_EMAIL_MONTHLY_DISTRIBUTION_ID = "HMO_STATE_EMAIL_MONTHLY_DISTRIBUTION_ID";
    public static final String HMO_TEST_EMAIL_DISTRIBUTION_ID = "HMO_TEST_EMAIL_DISTRIBUTION_ID";

    public static final String PRIMARY_PERSON_PIN_KEY = "PP_PIN";
    public static final String PRIMARY_PERSON_SPOUSEPIN_KEY = "PPS_PIN";
    public static final String SPOUSE_PIN_KEY = "SPOUSE_PIN";

    public static final String HMO_BATCH_FILE_LOCATION = "hmoBatchFileLocation";

    // HNA Batch Related Constatns
    public static final String HNA_INFORMATION = "HNA_INFORMATION";
    public static final String RECORD_COUNT = "RECORD_COUNT";
    public static final String INTERCHANGE_MANAGED_CARE_ORGANIZATION_NUMBER = "INTERCHANGE_MANAGED_CARE_ORGANIZATION_NUMBER";
    public static final String FILE_CREATION_DATE = "FILE_CREATION_DATE";

    public static final String HNA = "HNA";

    public static final String DATA_ROOT = "dataroot";
    public static final String MAXOCCURS = "MAXOCCURS";
    public static final String UNBOUNDED = "UNBOUNDED";
    public static final String MINOCCURS = "MINOCCURS";
    public static final String MASTER_CUSTOMER_INDEX = "MASTER_CUSTOMER_INDEX";
    public static final String ATTR_TYPE = "TYPE";

    public static final String COMMA = ",";

    // HNA CSV file header names

    public static final String MCI_ID = "MCI_ID";
    public static final String HNA_SUBMISSION_DATE = "HNA_SUBMISSION_DATE";
    public static final String HIGH_RISK_INDICATOR = "HIGH_RISK_INDICATOR";
    public static final String HIGH_RISK_SWITCH = "HighRiskSwitch";
    public static final String MEDICAL_CONDITIONS = "MEDICAL_CONDITIONS";
    public static final String MEDICAL_CONDITION = "MEDICAL_CONDITION";
    public static final String CONDITION_DETAILS = "CONDITION_DETAILS";
    public static final String EMERGENCY_ROOM = "EMERGENCY_ROOM";
    public static final String HOSPITALIZATION = "HOSPITALIZATION";

    public static final String DRUG_ALCOHOL_ABUSE_RESPONSE = "DRUG_ALCOHOL_ABUSE_RESPONSE";
    public static final String MORE_THAN_5_PRESCRIPTION_MEDICINES_RESPONSE = "MORE_THAN_5_PRESCRIPTION_MEDICINES_RESPONSE";
    public static final String MENTAL_HEALTH_PROBLEMS_RESPONSE = "MENTAL_HEALTH_PROBLEMS_RESPONSE";
    public static final String SMOKING_RESPONSE = "SMOKING_RESPONSE";
    public static final String REGULAR_DOCTOR_RESPONSE = "REGULAR_DOCTOR_RESPONSE";
    public static final String PREFFERED_FACILITY_RESPONSE = "PREFFERED_FACILITY_RESPONSE";
    public static final String REGULAR_DOCTORS = "REGULAR_DOCTORS";

    public static final String PREFERRED_FACILITIES = "PREFERRED_FACILITIES";

    public static final String ASTHMA = "Asthma";
    public static final String ASTHMA_EMERGENCY_ROOM = "AsthmanEmergencyRoom";
    public static final String ASTHMA_HOSPITOL = "AsthmaHospital";
    public static final String COPD = "COPD";
    public static final String COPD_EMERGENCY_ROOM = "COPDEmergencyRoom";
    public static final String COPD_HOSPITOL = "COPDHospital";
    public static final String DEPRESSION = "Depression";
    public static final String DEPRESSION_EMERGENCY_ROOM = "DepressionEmergencyRoom";
    public static final String DEPRESSION_HOSPITOL = "DepressionHospital";
    public static final String DIABETES = "Diabetes";
    public static final String DIABETES_EMERGENCY_ROOM = "DiabetesEmergencyRoom";
    public static final String DIABETES_HOSPITOL = "DiabetesHospital";
    public static final String EMPHYSEMA = "Emphysema";
    public static final String EMPHYSEMA_EMERGENCY_ROOM = "EmphysemaEmergencyRoom";
    public static final String EMPHYSEMA_HOSPITOL = "EmphysemaHospital";
    public static final String HEART_PROBLEM = "HeartProblem";
    public static final String HEART_PROBLEM_EMERGENCY_ROOM = "HeartProblemsEmergencyRoom";
    public static final String HEART_PROBLEM_HOSPITOL = "HeartProblemsHospital";
    public static final String HIGH_BP = "HighBloodPressure";
    public static final String STROKE = "Stroke";
    public static final String BREAST_CANCER = "BreastCancer";
    public static final String CERVICAL_CANCER = "CervicalCancer";
    public static final String COLON_CANCER = "ColonCancer";
    public static final String LUNG_CANCER = "LungCancer";
    public static final String OVARIAN_CANCER = "OvarianCancer";
    public static final String PROSTATE_CANCER = "ProstateCancer";
    public static final String TESTICULAR_CANCER = "TesticularCancer";
    public static final String OTHER_CANCER = "OtherCancer";
    public static final String DRUG_ALC_ABUSE = "DrugAlcoholAbuse";
    public static final String MORE_THAN_5_PRESC_DRGS = "MoreThanFivePrescriptionDrugs";
    public static final String MENTAL_HLTH_PROBLEMS = "MentalHealthProblems";
    public static final String REG_DOC = "RegularDoctor";
    public static final String SMOKING = "Smoking";
    public static final String PREF_FCLY = "PrefferedFacility";
    public static final String NPI_1 = "Provider1NPI";
    public static final String NPI_2 = "Provider2NPI";
    public static final String NPI_3 = "Provider3NPI";
    public static final String NPI_4 = "Provider4NPI";
    public static final String NPI_5 = "Provider5NPI";
    public static final String FCLY_NUM_1 = "FacilityNumber1";
    public static final String FCLY_NUM_2 = "FacilityNumber2";
    public static final String FCLY_NUM_3 = "FacilityNumber3";
    public static final String FCLY_NUM_4 = "FacilityNumber4";
    public static final String FCLY_NUM_5 = "FacilityNumber5";
    public static final String NAME = "NAME";

    public static final String SCHEMA_INSTANCE = "xmlns:xsi";
    public static final String SCHEMA_INSTANCE_VALUE = "httP://www.w3.org/2001/XMLSchema-instance";
    public static final String SCHEMA_LOCATION = "xsi:noNamespaceSchemaLocation";

    public static final String HNA_FOLDER_LOC = "hnaFolderName";
    public static final String ENROLLMENT_FILE_LOC = "enrollmentFileLoc";
    public static final String HNA_FILE_NAME_PREFIX = "hnaFileNamePredecessor";
    public static final String HNA_XML_EXTN = "hnaXMLFileNameExtension";
    public static final String HNA_CSV_EXTN = "hnaCSVFileNameExtension";
    public static final String HNA_XML_SCHEMA_LOC = "enrollInfoSchemaLoc";

    public static final String HMO_INFORMATION_BATCH_FILE_NAME = "hmoInformationBatchFileName";
    public static final String HMO_NETWORK_BATCH_FILE_NAME = "hmoNetworkBatchFileName";
    public static final String HMO_IC_EXEMPTION_BACTH_FILE_NAME = "hmoICExemptionBatchFileName";
    public static final String HMO_SELECTION_BACTH_FILE_NAME = "hmoSelectionBatchFileName";
    public static final String HMO_CARES_SEL_RETURN_BACTH_FILE_NAME = "hmoCaresSelReturnBatchFileName";
    public static final String HMO_CARES_EXMP_RETURN_BACTH_FILE_NAME = "hmoCaresExmpReturnBatchFileName";
    public static final String HMO_ACCESS_IC_EXEMPTION_BACTH_FILE_NAME = "hmoAccessToICExemptionMonthlyBatchFileName";
    public static final String HMO_EXEMPTION_IC_FILE_NAME = "hmoExempICFileName";
    public static final String HMO_MONTHLY_EXEMPTION_IC_FILE_NAME = "hmoMonthlyExempICFileName";

    public static final String HMO_SERVER = "hmoFTPServer";
    public static final String HMO_USERNAME = "hmoUsername";
    public static final String HMO_PASSWORD = "hmoPassword";
    public static final String HMO_PATH = "hmoPath";

    public static final String HNA_SERVER = "hnaFTPServer";
    public static final String HNA_USERNAME = "hnaUsername";
    public static final String HNA_PASSWORD = "hnaPassword";
    public static final String HNA_PATH = "hnaPath";

    public static final String HMO_NETWORK_SCHEMA_NAME = "hmoNetworkInfo.xsd";
    public static final String HMO_SELECTION_SCHEMA_NAME = "hmoEnrollmentInfo.xsd";

    public static final String REMITTANCE_SCHEMA_NAME = "RemittanceSchemaV4_0.xsd";

    // HMO Performance Scores constants
    public static final String HMO_NORMALIZED_PERF_SCORES = "HMO_NORMALIZED_PERF_SCORES";
    public static final int HMO_PERF_SCORE_ASTHMA = 0;
    public static final int HMO_PERF_SCORE_DIABETES = 1;
    public static final int HMO_PERF_SCORE_TOBACCO = 2;
    public static final int HMO_PERF_SCORE_CUSTOMER_SERV = 3;
    public static final int HMO_PERF_SCORE_GETTING_NEEDED_CARE = 4;
    public static final int HMO_PERF_SCORE_HEALTH_PLAN = 5;
    public static final int HMO_PERF_SCORE_HEALTH_CARE = 6;

    public static final String HMO_NETWORK_FTP_BATCH_DAILY = "HP1010A";
    public static final String HMO_NETWORK_FTP_BATCH_MONTHLY = "HP2010A";
    public static final String HMO_NETWORK_BATCH_DAILY = "HP1020A";
    public static final String HMO_NETWORK_BATCH_MONTHLY = "HP2020A";
    public static final String DAILY = "DAILY";
    public static final String MONTHLY = "MONTHLY";

    public static final String BUTTON_ACCESS_LOGO = "BUTTON_ACCESS_LOGO";// access_logo
    public static final String BUTTON_BACKGROUND_PIC = "BUTTON_BACKGROUND_PIC";// background_pic
    public static final String BUTTON_COMMUNITY_PARTNERS = "BUTTON_COMMUNITY_PARTNERS";// community_partners
    public static final String BUTTON_FORWARD_HEALTH = "BUTTON_FORWARD_HEALTH";// forward_health
    public static final String BUTTON_LOGIN_COMMUNITY_PARTNERS = "BUTTON_LOGIN_COMMUNITY_PARTNERS";// login_community_partners
    public static final String BUTTON_LOGIN_EMPLOYERS = "BUTTON_LOGIN_EMPLOYERS";// login_employers
    public static final String BUTTON_LOGIN_PROVIDERS = "BUTTON_LOGIN_PROVIDERS";// login_providers
    public static final String BUTTON_PROVIDERS = "BUTTON_PROVIDERS";// providers
    public static final String BUTTON_SWOOSH = "BUTTON_SWOOSH";// swoosh
    public static final String BUTTON_WISCONSIN_GOV_LOGO = "BUTTON_WISCONSIN_GOV_LOGO";// wisconsin_gov_logo
    public static final String BUTTON_COMMUNITY_PARTNERS_LEARN_MORE_NEW = "BUTTON_COMMUNITY_PARTNERS_LEARN_MORE_NEW";// learn_more
    public static final String BUTTON_EMPLOYERS_LEARN_MORE_NEW = "BUTTON_EMPLOYERS_LEARN_MORE_NEW";
    public static final String BUTTON_PROVIDERS_LEARN_MORE_NEW = "BUTTON_PROVIDERS_LEARN_MORE_NEW";
    public static final String BUTTON_AM_I_ELIGIBLE_Y = "BUTTON_AM_I_ELIGIBLE_Y";// am_i_eligible_y
    public static final String BUTTON_APPLY_FOR_BENEFITS_Y = "BUTTON_APPLY_FOR_BENEFITS_Y";// apply_for_benefits_y
    public static final String BUTTON_CREATE_AN_ACCOUNT_Y = "BUTTON_CREATE_AN_ACCOUNT_Y";// create_an_account_y
    public static final String BUTTON_LOGIN_TO_ACCOUNT_Y = "BUTTON_LOGIN_TO_ACCOUNT_Y";// login_to_account_y
    public static final String ONE = "1";

    public static final String BUTTON_ACCESS_LOGO_IMG = "/access_logo.gif";
    public static final String BUTTON_BACKGROUND_PIC_IMG = "/background_pic.jpg";
    public static final String BUTTON_COMMUNITY_PARTNERS_IMG = "/community_partners.gif";
    public static final String BUTTON_FORWARD_HEALTH_IMG = "/forward_health.jpg";
    public static final String BUTTON_LOGIN_COMMUNITY_PARTNERS_IMG = "/login_community_partners.gif";
    public static final String BUTTON_LOGIN_EMPLOYERS_IMG = "/login_employers.gif";
    public static final String BUTTON_LOGIN_PROVIDERS_IMG = "/login_providers.gif";
    public static final String BUTTON_PROVIDERS_IMG = "/providers.gif";
    public static final String BUTTON_SWOOSH_IMG = "/swoosh.gif";
    public static final String BUTTON_WISCONSIN_GOV_LOGO_IMG = "/wisconsin_gov_logo.gif";
    public static final String BUTTON_COMMUNITY_PARTNERS_LEARN_MORE_NEW_IMG = "/learn_more.gif";
    public static final String BUTTON_EMPLOYERS_LEARN_MORE_NEW_IMG = "/learn_more.gif";
    public static final String BUTTON_PROVIDERS_LEARN_MORE_NEW_IMG = "/learn_more.gif";
    public static final String BUTTON_AM_I_ELIGIBLE_Y_IMG = "/am_i_eligible_y.jpg";// am_i_eligible_y
    public static final String BUTTON_APPLY_FOR_BENEFITS_Y_IMG = "/apply_for_benefits_y.jpg";// apply_for_benefits_y
    public static final String BUTTON_CREATE_AN_ACCOUNT_Y_IMG = "/create_an_account_y.jpg";// create_an_account_y
    public static final String BUTTON_LOGIN_TO_ACCOUNT_Y_IMG = "/login_to_account_y.jpg";// login_to_account_y

    public static final String BUTTON_FORWARD_HEALTH_ALT = "13005";
    public static final String BUTTON_LOGIN_COMMUNITY_PARTNERS_ALT = "13006";
    public static final String BUTTON_LOGIN_PROVIDERS_ALT = "13007";
    public static final String BUTTON_LOGIN_EMPLOYERS_ALT = "13008";
    public static final String BUTTON_COMMUNITY_PARTNERS_LEARN_MORE_NEW_ALT = "13009";
    public static final String BUTTON_PROVIDERS_LEARN_MORE_NEW_ALT = "13010";
    public static final String BUTTON_EMPLOYERS_LEARN_MORE_NEW_ALT = "13011";
    public static final String BUTTON_AM_I_ELIGIBLE_Y_ALT = "13001";// am_i_eligible_y
    public static final String BUTTON_APPLY_FOR_BENEFITS_Y_ALT = "13002";// apply_for_benefits_y
    public static final String BUTTON_CREATE_AN_ACCOUNT_Y_ALT = "13004";// create_an_account_y
    public static final String BUTTON_LOGIN_TO_ACCOUNT_Y_ALT = "13003";// login_to_account_y

    public static final String BUTTON_BACKGROUND_PIC_ALT = "";
    public static final String BUTTON_SWOOSH_ALT = "";
    public static final String BUTTON_WISCONSIN_GOV_LOGO_ALT = "";
    public static final String BUTTON_ACCESS_LOGO_ALT = "";
    public static final String BUTTON_COMMUNITY_PARTNERS_ALT = "";
    public static final String BUTTON_PROVIDERS_ALT = "";

    public static final String CHUNK_SIZE = "chunkSize";
    public static final String SYSTEMS = "SYSTEMS";
    public static final String ACCEPTANCE = "ACCEPTANCE";
    public static final String PRODUCTION = "PRODUCTION";
    public static final String PROCESSED_HMO_FILE_NAMES = "processedHmoFileNames";

    // AST - Signature Buttons. START
    public static final String BUTTON_BEGIN_RECORDING = "BUTTON_BEGIN_RECORDING";
    public static final String BUTTON_BEGIN_RECORDING_DISABLED = "BUTTON_BEGIN_RECORDING_DISABLED";
    public static final String BUTTON_END_RECORDING = "BUTTON_END_RECORDING";
    public static final String BUTTON_END_RECORDING_DISABLED = "BUTTON_END_RECORDING_DISABLED";
    public static final String BUTTON_VIEW_SUMMARY = "BUTTON_VIEW_SUMMARY";

    public static final String BUTTON_BEGIN_RECORDING_IMG = "/button_begin_recording.gif";
    public static final String BUTTON_BEGIN_RECORDING_DISABLED_IMG = "/button_begin_recording_disabled.gif";
    public static final String BUTTON_END_RECORDING_IMG = "/button_end_recording.gif";
    public static final String BUTTON_END_RECORDING_DISABLED_IMG = "/button_end_recording_disabled.gif";
    public static final String BUTTON_VIEW_SUMMARY_IMG = "/button_view_summary.gif";

    public static final String BUTTON_BEGIN_RECORDING_ALT = "28816";
    public static final String BUTTON_BEGIN_RECORDING_DISABLED_ALT = "28816";
    public static final String BUTTON_END_RECORDING_ALT = "28817";
    public static final String BUTTON_END_RECORDING_DISABLED_ALT = "28817";
    public static final String BUTTON_VIEW_SUMMARY_ALT = "28818";
    
    // Splash Screen Buttons - Medical Assistance
    public static final String BUTTON_MEDICAL_ASSISTANCE        = "BUTTON_MEDICAL_ASSISTANCE";
    public static final String BUTTON_MEDICAL_ASSISTANCE_ALT    = "28818";
    public static final String BUTTON_MEDICAL_ASSISTANCE_IMG    = "/medical_assistance.png";
    
    // Splash Screen Buttons - Food Stamps
    public static final String BUTTON_FOOD_STAMPS               = "BUTTON_FOOD_STAMPS";
    public static final String BUTTON_FOOD_STAMPS_ALT           = "28818";
    public static final String BUTTON_FOOD_STAMPS_IMG           = "/food_stamps.png";
    
    // Splash Screen Buttons - TANF
    public static final String BUTTON_TANF                      = "BUTTON_TANF";
    public static final String BUTTON_TANF_ALT                  = "28818";
    public static final String BUTTON_TANF_IMG                  = "/cash_assitance.png";
    
    // Splash Screen Buttons - Child Care
    public static final String BUTTON_CHILD_CARE                = "BUTTON_CHILD_CARE";
    public static final String BUTTON_CHILD_CARE_ALT            = "28818";
    public static final String BUTTON_CHILD_CARE_IMG            = "/child_care.png";
    
    // Splash Screen Buttons - WIC
    public static final String BUTTON_WIC                       = "BUTTON_WIC";
    public static final String BUTTON_WIC_ALT                   = "28818";
    public static final String BUTTON_WIC_IMG                   = "/wic.png";
    
    // Splash Screen Buttons - Plan for Healthy Babies
    public static final String BUTTON_PLAN_BABIES               = "BUTTON_PLAN_BABIES";
    public static final String BUTTON_PLAN_BABIES_ALT           = "28818";
    public static final String BUTTON_PLAN_BABIES_IMG           = "/plan_babies.png";
    
    // Splash Screen Buttons - PeachCase for Kids
    public static final String BUTTON_PEACH_CARE                = "BUTTON_PEACH_CARE";
    public static final String BUTTON_PEACH_CARE_ALT            = "28818";
    public static final String BUTTON_PEACH_CARE_IMG            = "/peach_care.png";

    // AST - Signature Buttons. END

    // RMB Constants - start
    public static final String REVIEW_CASE_NUM = "reviewCaseNum";
    public static final String VALID_AG_STAT_RSN_CD = "077";

    // RMB Gate Post Page IDs
    public static final String RMB_PEOPLE_GATE_POST_PAGE = "ARPGQ";
    public static final String RMB_OTHER_BENEFITS_GATE_POST_PAGE = "AROBQ";
    public static final String RMB_ASSET_GATE_POST_PAGE = "ARAGQ";
    public static final String RMB_OTHER_ASSET_GATE_POST_PAGE = "AROAQ";
    public static final String RMB_JOB_INCOME_GATE_POST_PAGE = "ARJGQ";
    public static final String RMB_OTHER_INCOME_GATE_POST_PAGE = "AROIQ";
    public static final String RMB_EXPENSES_GATE_POST_PAGE = "ARXGQ";

    // RMB GATE POST QUESTIONS
    public static final String ADDRESS_CHG_QUESTION = "ADR_CHG_STAT_IND";
    public static final String PERSON_MOVED_QUESTION = "PRSN_MOVE_STAT_IND";
    public static final String PERSON_DEMO_CHG_QUESTION = "HSHL_CHG_STAT_IND";
    public static final String PREGNANCY_CHG_QUESTION = "PREG_CHG_STAT_IND";
    public static final String DISABILITY_ADD_QUESTION = "DABL_STAT_IND";
    public static final String DRUG_FELONY_CHG_QUESTION = "DRUG_FELN_STAT_IND";
    public static final String ACCIDENT_QUESTION = "RCNT_ACDT_STAT_IND";
    public static final String OB_SCHL_ENRL_CHG_QUESTION = "SCHL_ENRL_STAT_IND";
    public static final String OB_HEALTH_INS_QUESTION = "MED_CVRG_STAT_IND";
    public static final String OB_PAST_HEALTH_INS_QUESTION = "PAST_CVRG_STAT_IND";
    public static final String OB_MAPP_CHG_QUESTION = "MAPP_STAT_IND";
    public static final String OB_TRBL_CMDY_QUESTION = "TRB_CMDY_STAT_IND";
    public static final String LIQUID_AST_CHG_QUESTION = "LIQ_ASET_STAT_IND";
    // Adding rmb liquid resources gatepost questions
    public static final String LIQUID_CASH_AST_CHG_QUESTION = "LIQ_CASH_ASET_STAT_IND";
    public static final String LIQUID_FA_AST_CHG_QUESTION = "LIQ_FA_ASET_STAT_IND";
    public static final String LIQUID_OTHER_AST_CHG_QUESTION = "LIQ_OTHER_ASET_STAT_IND";

    public static final String VEHICLE_AST_CHG_QUESTION = "VEH_ASET_STAT_IND";
    public static final String REAL_PROP_CHG_QUESTION = "REAL_ASET_STAT_IND";
    public static final String PRSN_PROP_CHG_QUESTION = "PRSN_PROP_STAT_IND";
    public static final String BURIAL_AST_CHG_QUESTION = "BURY_ASET_STAT_IND";
    public static final String LIFE_INS_CHG_QUESTION = "LI_ASET_STAT_IND";
    public static final String ASSET_TRFR_CHG_QUESTION = "ASET_XFER_STAT_IND";
    public static final String JOB_INCM_CHG_QUESTION = "EMPL_STAT_IND";
    public static final String IN_KIND_INCM_CHG_QUESTION = "IKND_INCM_STAT_IND";
    public static final String SELF_EMPL_CHG_QUESTION = "SELF_EMPL_STAT_IND";
    public static final String OTHER_INCM_CHG_QUESTION = "OTHR_INCM_STAT_IND";
    public static final String HOUS_BILL_CHG_QUESTION = "HOUS_BILL_STAT_IND";
    public static final String UTIL_BILL_CHG_QUESTION = "UTIL_BILL_STAT_IND";
    public static final String ROOM_BRD_CHG_QUESTION = "ROOM_BRD_STAT_IND";

    // ARXGQ
    public static final String MEDICARE_ASSIST_CHG_QUESTION = "MEDICARE_ASSIST_REQ_STAT_IND";
    public static final String STANDARD_EXPENSE_CHG_QUESTION = "SNAP_SHELTER_STANDARD_EXP_IND";
    // ARXGQ END

    public static final String DPND_CARE_CHG_QUESTION = "DPND_CARE_STAT_IND";
    public static final String SUP_OBLG_CHG_QUESTION = "SPRT_OBLG_STAT_IND";
    public static final String IRWE_CHG_QUESTION = "IRWE_STAT_IND";
    public static final String MED_BILLS_CHG_QUESTION = "MED_BILLS_STAT_IND";
    public static final String ROOM_AND_BOARD = "RB";
    public static final String IMPAIRMENT_RELATED_WORK_EXPENSES = "IR";
    public static final String DEPENDENT_CARE_EXPENSES = "DC";
    public static final String PAYMENTS_AND_OBLIGATIONS = "SP";
    public static final String HEALTHCARE_COVERAGE = "HI";
    public static final String MAPP = "MP";
    public static final String SCHOOL_ENROLLMENT = "SE";
    public static final String TRIBAL_COMMODITIES = "TC";
    public static final String STANDARD_UTILITY_EXPENSES = "SU";

    public static final String INSTITUTIONAL_CASE = "INST_CASE";
    public static final String FSEBD_CASE = "FSEBD_CASE";
    // EDSP CP ADDED
    public static final String PAROLE_VIOLATION_CHG_QUESTION = "PAROLE_VIOLATION_STAT_IND";
    public static final String HEAD_HOUSEHOLD_CHG_QUESTION = "HEAD_OF_HOUSEHOLD_STAT_IND";
    public static final String HEAD_HOUSEHOLD_CHG_IND = "HH";
    // RMB Constants - end

    // Child Care - Apply For Benefits
    public static final String PRNTROLE = "PRNTROLE";

    public static final String KINSHIP_CARE_PARENT = "KCP";
    public static final String FOSTER_CARE_PARENT = "FCP";
    public static final String SUBSIDIZED_GUARDIAN_PARENT = "SGS";
    public static final String ACTING_AS_PARENT = "AAP";
    // Child Care

    /** State Life Insurance Fund Program **/
    public static final String STATE_LIFE_INSURANCE_FUND = "SLIF";

    // WAITLIST
    public static final String ON_WAITLIST = "OW";
    public static final String INVITED_TO_WALITLIST = "IA";
    public static final String WAITLIST_SECURITY_CODE_USED = "SU";
    public static final String REMOVED_FROM_WAITLIST_SC_EXPIRED = "RE";
    public static final String REMOVED_FROM_WAITLIST_PR_NOT_MET = "RP";
    public static final String DEFAULT_WAITLIST = "NA";
    public static final String WAITLIST = "WL";

    // APP INTERACTION
    public static final String APP_INTERACTION_DETAILS = "APP_INTERACTION_DETAILS";

    public static final String HMO_PGM = "HMO";
    public static final String CORE_PGM = "CORE";
    public static final String SSI_PGM = "SSI";
    public static final String HMO_PGM_LIST = "HMO_PGM_LIST";
    public static final String CORE_PGM_LIST = "CORE_PGM_LIST";
    public static final String SSI_PGM_LIST = "SSI_PGM_LIST";

    public static final String BUTTON_TOGGLE_HMO = "BUTTON_TOGGLE_HMO";
    public static final String BUTTON_TOGGLE_HMO_IMG = "/button_toggle_hmo.gif";
    public static final String BUTTON_TOGGLE_HMO_ALT = "63013";
    public static final String BUTTON_TOGGLE_CORE = "BUTTON_TOGGLE_CORE";
    public static final String BUTTON_TOGGLE_CORE_IMG = "/button_toggle_core.gif";
    public static final String BUTTON_TOGGLE_CORE_ALT = "63014";
    public static final String BUTTON_TOGGLE_SSI = "BUTTON_TOGGLE_SSI";
    public static final String BUTTON_TOGGLE_SSI_IMG = "/button_toggle_ssi.gif";
    public static final String BUTTON_TOGGLE_SSI_ALT = "63015";

    public static final String NOT_SIGNED_UP = "NS";
    public static final String SIGN_UP_COMPLETE = "SC";
    public static final String CLOSED_RRP = "CR";
    public static final String CLOSED_RRP_OPT_OUT = "CO";
    public static final String CLOSED_NON_RRP = "CN";
    public static final String ALREADY_ENROLLED = "AE";
    public static final short CURRENT_HISTORY_CODE = 0;
    public static final int BCPB_ENROLLMENT_DAY = 15;
    public static final int BCPB_PREMIUM_DUE_DAY = 5;
    public static final String BADGERCAREPLUS_BASIC_PLAN = "BCB";
    public static final String DOCUMENT_FORMAT_PDF = "PDF";
    public static final String NOT_APPLICABLE = "N/A";

    // W-2 Program
    public static final String WISCONSIN_WORKS = "WW";
    public static final String SOCIAL_SECURITY_DISABILITY_INSURANCE = "SSD";
    public static final String STEP_PARENT = "SPR";
    public static final String STEP_CHILD = "SCH";
    public static final String FAIL_REASON_SSI_SSDI = "FAIL_SSI_SSDI";
    public static final String FAIL_REASON_TOOMUCH_INCOME = "FAIL_INCOME";
    public static final String FAIL_REASON_TOOMANY_ASSETS = "FAIL_ASSETS";
    public static final String FAIL_REASON_NO_CHILD_OR_PARENT_OF_A_MINOR = "FAIL_PARENT";

    // added for HMO selection
    public static final String BNFT_PLAN_CORE = "CORE";
    public static final String BNFT_PLAN_FAMILY = "HMO";
    public static final String RFP_COUNTY_ENRL_DATE = "RFP_COUNTY_ENRL_DATE";
    public static final String OPEN_ENROLLMENT_BEGIN_DATE = "OPEN_ENROLLMENT_BEGIN_DATE";
    public static final String LOCKIN_BEGIN_DATE = "LOCKIN_BEGIN_DATE";
    public static final String ADD_EXMP = "ADD_EXMP";
    public static final String CHANGE = "CHANGE";
    public static final String VIEW = "VIEW";
    public static final String PAGE_TYPE = "PAGE_TYPE";
    public static final String INDVSEQNUM = "INDVSEQNUM";
    public static final String INDVNAME = "INDVNAME";
    public static final String INDV_EXMP_COLLECTION = "INDV_EXMP_Collection";
    public static final String PAGE_MODE_FOR_EXEMPTION_DETAILS = "PAGE_MODE_FOR_EXEMPTION_DETAILS";
    public static final String EMERGENCY_OVERRIDE = "EMERGENCY_OVERRIDE";
    public static final String NORMAL_OVERRIDE = "NORMAL_OVERRIDE";
    public static final String EMERGENCY_OVERRIDE_VALUE = "E";
    public static final String NORMAL_OVERRIDE_VALUE = "N";
    public static final String SELECT_AN_HMO = "SELECT_AN_HMO";
    public static final String MANAGE_FEE_FOR_SERVICE = "MANAGE_FEE_FOR_SERVICE";
    public static final String OVERRIDES_TYPE = "OVERRIDES_TYPE";
    // end
    public static final String OVERRIDE_SUMMERY_HMO_ENROLLMENTS = "OVERRIDE_SUMMERY_HMO_ENROLLMENTS";
    public static final String ADD_GENERAL_COMMENTS = "ADD_GENERAL_COMMENTS";
    public static final String ENROLLED = "E";
    public static final String SELECTED = "S";
    public static final String ENROLLED_FEATURE = "EF";
    public static final String ENROLLEMENT_CHANGED = "EC";
    public static final String FEATURE_ENROLLEMENT_CHANGED = "FC";
    public static final String DISPLAY_HMO_SECTION = "DISPLAY_HMO_SECTION";
    public static final String HCE_TYPE = "HCE_TYPE";
    public static final String DISPLAY_WORKER_FUNCTIONS_BUTTON = "DISPLAY_WORKER_FUNCTIONS_BUTTON";
    public static final String DISPLAY_CHANGE_HMO_BUTTON = "DISPLAY_CHANGE_HMO_BUTTON";

    public static final String SECURITY_IMG = "/Security.gif";
    public static final String SECURITY_ALT = "40172";

    public static final char YES_CHAR = 'Y';
    public static final char NO_CHAR = 'N';

    public static final String HMO_SELECTION = "HMO_SELECTION";
    public static final String BENEFIT_PLAN = "BENEFIT_PLAN";
    public static final String PLAN_NAME = "PLAN_NAME";
    public static final String HMO_ENROLLED_COUNT = "HMO_ENROLLED_COUNT";
    public static final String HMO_DATA = "HMO_DATA";
    public static final String HMO_NUM = "HMO_NUM";
    public static final String HMO_COUNT = "HMO_COUNT";
    public static final String CASE = "CASE";
    public static final String CASE_NUM = "CASE_NUM";
    public static final String RFP_IND = "RFP_IND";
    public static final String PRIORITY = "PRIORITY";
    public static final String RE_ASSIGNED_IND = "RE_ASSIGNED_IND";
    public static final String INDV_DETAILS = "INDV_DETAILS";
    public static final String PIN_NUM = "PIN_NUM";
    public static final String SEQ_NUM = "SEQ_NUM";
    public static final String TRIBAL_IND = "TRIBAL_IND";
    public static final String MIGRANT_IND = "MIGRANT_IND";
    public static final String ELIG_BEG_DT = "ELIG_BEG_DT";
    public static final String ELIG_END_DT = "ELIG_END_DT";
    public static final String PAYMENT_BEGIN_DT = "PAYMENT_BEGIN_DT";
    public static final String PRIM_PER_IND = "PRIM_PER_IND";
    public static final String DOB_DT = "DOB_DT";

    public static final String PRIORITY1 = "PRIORITY1";
    public static final String PRIORITY2 = "PRIORITY2";
    public static final String BASE_RATIO_MAP = "BASE_RATIO_MAP";
    public static final String BASE_COUNT_MAP = "BASE_COUNT_MAP";
    public static final String HMO_LIST = "HMO_LIST";
    public static final String MONTH_DATA = "MONTH_DATA";
    public static final String MONTH_VALUE = "MONTH_VALUE";
    public static final String FIRST_RATIO_MAP = "FIRST_RATIO_MAP";
    public static final String SECOND_RATIO_MAP = "SECOND_RATIO_MAP";
    public static final String STANDARD_RATIO = "standardRatio";
    public static final String HMO_ASSIGNMENT_PROCESS = "HMO_ASSIGNMENT_PROCESS";
    public static final String INDV_NON_EXMP_LIST = "INDV_NON_EXMP_LIST";
    public static final String FAMILY_CARES_RETURN_INFO_LIST = "FAMILY_CARES_RETURN_INFO_LIST";
    public static final String HMO_ASSIGNED = "HMO_ASSIGNED";
    public static final String NEW_PIN_LIST = "NEW_PIN_LIST";
    public static final String OLD_PIN_LIST = "OLD_PIN_LIST";
    public static final String STAGE_ONE_RATIO = "1";
    public static final String MAX_INDV_SEQ_NUM = "MAX_INDV_SEQ_NUM";
    public static final String MONTH_KEY = "MONTH_KEY";

    public static final String CWW_AFB_ATYPE = "A";
    public static final String CWW_RMB_ATYPE = "R";
    public static final String GLUE_PAGE_ATYPE = "GLUE_PAGE_ATYPE";

    public static final String CLINIC_TYP = "CLINIC_TYP";
    public static final String FILTER = "FILTER";

    public static final int CWW_RESPONSE_FILE_RECORD_LENGTH = 10521;
    public static final int CWW_HMO_EXMP_RESPONSE_FILE_RECORD_LENGTH = 55;
    public static final String HMO_SELECTION_CHUNK_SIZE = "hmoSelectionChunkSize";
    public static final String AUTO_ASSIGNMENT_FILE_DISK_SPACE = "CYL PRI=500 SEC=50";

    // BADGER CARE PLUS BASIC CHANGES
    public static final String TRAN_TYP_PMT = "PMT";
    public static final String TRAN_TYP_RFD = "RFD";
    public static final String TRAN_TYP_RET = "RET";
    public static final String TRAN_TYP_NSF = "NSF";
    public static final String TRAN_TYP_RDI = "RDI";

    // Verification Check List
    public static final String NOTICE_FOR_YOUR_INFORMATION = "F";
    public static final String NOTICE_OF_ACTION_NEEDED = "A";
    public static final String NOTICE_OF_PROOF_NEEDED = "P";
    public static final String NOTICE_OF_INFORMATION_NEEDED = "I";
    public static final String PEND_ACTION = "PEND_ACTION";

    // DSM Constants (ECF Phase - 2)
    public static final String UNDERSCORE = "_";
    public static final String DSM_SELECTION_PROFILE_MASTER = "DSM_SELECTION_PROFILE_MASTER";
    public static final String BATCH_INDIV_MASTER = "BATCH_INDIV_MASTER";
    public static final String DOC_BAT_MASTER = "DOC_BAT_MASTER";
    public static final String INTIAL_DOC_SEQ_NUMBER = "1";
    public static final String BAT_NUMBER = "BAT_NUMBER";
    public static final String SRC_ACCESS_APPLICATION_TYPE = "SRC_ACCESS_APPLICATION_TYPE";
    public static final String DOCUMET_FILENAME = "DOCUMET_FILENAME";
    public static final String ACCESS_DOC_SCAN = "A";
    public static final String ACCESS_DOC_MAIL = "M";
    public static final String ACCESS_DOC_FAX = "F";
    public static final String ACCESS_DOC_WALK_IN = "W";
    public static final String ACCESS_DOC_SKIP = "S";
    public static final String SORTED_SET = "SORTED_SET";
    public static final String OTHER_PROOF_TYPE = "OT";
    public static final String OTHER_PROOF_SUBTYPE = "OS";
    public static final String NOT_APPLICABLE_NA = "NA";// changed
    public static final String BAT_INDV_DOC_COLLECTION = "BAT_INDV_DOC_COLLECTION";
    public static final String DSM_STATUS_RECEIVED = "RE";
    public static final String DSM_STATUS_EXCEPTION = "EX";
    public static final String BATCH_PROCESSED = "BP";
    public static final String DSM_STATUS_PURGED = "PU";
    public static final String DSM_STATUS_PENDING = "PE";
    public static final String DSM_STATUS_PROCESSED = "PR";
    public static final String DSM_STATUS_INPROGRESS = "IP";
    public static final String DSM_STATUS_SKIPPED = "SK";
    public static final String SELECTED_CHANNEL = "SELECTED_CHANNEL";
    public static final String IS_TRK_SHT_SW_SET = "IS_TRK_SHT_SW_SET";
    public static final String BATCH_INDIV_MASTER_MAP = "BATCH_INDIV_MASTER_MAP";
    public static final String SUBMISSION_MODE = "SUBMISSION_MODE";
    public static final String SCANNER_INDEX = "SCANNER_INDEX";
    public static final String SUBMIT_BUTTON_FLAG = "SUBMIT_BUTTON_FLG";
    public static final String DSM_PAGE_PRFL = "DSM_PAGE_PRFL";
    public static final String PAGE_PROOF_TYPE = "PAGE_PROOF_TYPE";
    public static final String PAGE_PEND_DESCRIPTION = "PAGE_PEND_DESCRIPTION";
    public static final String DSM_CURRENT_SELECTION = "DSM_CURRENT_SELECTION";
    public static final String DSM_CURRENT_INDIVIDUAL = "DSM_CURRENT_INDIVIDUAL";
    public static final String DSM_STATUS_NOT_SENT = "NS";
    public static final String DSM_SKIP_STATUS = "S";
    public static final String DSM_STATUS_DELETED = "D";
    public static final String NOT_SENT = "NS";
    public static final String SCAN_OR_UPLOAD_STR = "Scan or Upload";
    public static final String MAIL_STR = "Mail";
    public static final String FAX_STR = "Fax";
    public static final String SUBMIT_STR = "Submit";
    public static final String IN_PERSON_STR = " In Person";
    public static final String CHANNEL_STR = "CHANNEL_STR";
    public static final String CHECKED_STR = " CHECKED ";
    public static final String CHECKED_AND_DISABLED_STR = " CHECKED DISABLED ";
    public static final String DOCSELECTION_STR = "DOCSELECTION";
    public static final String DOCUMENT_SUBMITTED_FLAG = "DOCUMENT_SUBMITTED_FLAG";
    public static final String OTHER_STR = "Other";
    public static final String DSM_SELECTION_WARNING = "dsmSelectionWarning";
    public static final String DSM_STATUS_ABANDONED = "AB";
    public static final String DSM_STATUS_CLEANED_UP = "PX";
    public static final String ESC_APP_TYPE = "CLA";
    public static final String ADD_DROP_DOWN_MAP_EN = "ADD_DROP_DOWN_MAP_EN";
    public static final String ADD_DROP_DOWN_MAP_ES = "ADD_DROP_DOWN_MAP_ES";
    public static final String DSM_PROOF_SEQ = "DSM_PROOF_SEQ";
    public static final String DSM_PROOF_DESC = "DSM_PROOF_DESC";
    public static final String CWW_SUCCESS_ERROR_CODE = "0000";
    public static final String AGENCY_ADDRESS = "AGENCY_ADDRESS";
    public static final String FAX_NUMBER = "FAX_NUMBER";
    public static final String ONE_TIME_DOCUMENTS = "ONE_TIME_DOCUMENTS";
    public static final String OTHER_INCOME = "UI";
    public static final String SHELTER_COST_ABR = "SC";// changed
    public static final String DISABILITY_ABR = "DI";
    public static final String BURIAL_ASSESTS = "AB";
    public static final String BURIAL_RESOURCE = "BR";
    public static final String LIFE_INSURANCE_ASSESTS = "AI";
    public static final String VEHICLE_ASSESTS = "AV";
    public static final String REAL_PROPERTY_ASSESTS = "AR";
    public static final String LIQUID_ASSESTS = "AL";
    public static final String PERSONAL_PROPERTY_ASSESTS = "AP";
    public static final String PREGNANCY_INFORMATION = "PI";
    public static final String CURRENT_DEMOGRAPHICS = "CD";
    public static final String PERMANENT_DEMOGRAPHICS = "PD";
    public static final String GENERAL_CASE_INFORMATION = "CH";
    public static final String HOUSEHOLD_MEMBER = "HM";
    public static final String HOUSEHOLD_RELATIONSHIPS = "HR";
    public static final String ALIEN_INFORMATION = "RA";
    public static final String DRUG_FELON_ABR = "DF";// changed
    public static final String SCHOOL_ENROLLMENT_ABR = "SN";// changed
    public static final String MAPP_ABR = "MR";
    public static final String ROOM_AND_BOARD_INCOME = "RB";
    public static final String ROOM_AND_BOARD_PAY = "RP";
    public static final String MEDICARE_INFORMATION = "MC";
    public static final String HEALTHINS_INFORMATION = "HN";
    public static final String OTHR_HLTH_INS_INFORMATION = "OH";
    public static final String OTHR_HEALTH_INS_INFORMATION = "OHI";
    public static final String HOSPICE_INFORMATION = "HP";
    public static final String NURSING_INFORMATION = "NH";
    public static final String OUTOFSTATE_INFORMATION = "OF";
    public static final String MEDICAL_COVERAGE_INFORMATION = "MC";
    public static final String MEDICAL_EXPENSE_ABR = "ME";
    public static final String IRWE_ABR = "IR";
    public static final String SUPPORT_OBLIGATION_PAYMENT = "SP";
    public static final String UTILITY_COSTS_ABR = "UC";
    public static final String REAL_ASSESTS = "AR";
    public static final String OTHER_DOCUMENT_CODE = "ZZ";
    public static final String EDUCATIONAL_AID = "EA";
    public static final String PRINT_THIS_LIST_NOTE = "PRINT_THIS_LIST_NOTE";

    public static final String IN_KIND = "IN";
    public static final String EMPLOYMENT_REGULAR = "R";
    public static final String EMPLOYMENT_STRIKE = "ST";
    public static final String EMPLOYMENT_SELF = "SE";
    public static final String EMPLOYMENT_TERMINATED = "TM";
    public static final String OTHER_INCOME_SSI = "SI";
    public static final String IDENTITY_VERIFICATION = "IV";
    public static final String MARITAL_STATUS = "MS";
    public static final String LIVING_ARRANGEMENT = "LA";
    public static final String MIGRANT_WORKER_ABR = "MF";// changed
    public static final String TRIBE_MEMBER = "TR";
    public static final String CHILD_TRIBE_MEMBER = "TC";
    public static final String US_CITIZENSHIP = "UC";
    public static final String ALIEN_SPONSORED_ORG = "SO";
    public static final String ALIEN_SPONSORED_PERSON = "SP";
    public static final String SSN_APPLICATION_DATE_PERSON = "SS";
    public static final int PEND_CODE_PARTITION_SIZE = 3;
    public static final int DOC_CODE_PARTITION_SIZE = 2;
    public static final String ONE_TIME_FLAG = "ONE_TIME_FLAG";
    public static final String SPACE_HYPHEN_SPACE = " - ";
    public static final String ASTERISK = "*";
    public static final String PAGE_DOC_LIST = "PAGE_DOC_LIST";
    public static final String PAGE_DOC_MAP = "PAGE_DOC_MAP";
    public static final String IS_OS_SUPPORTED = "IS_OS_SUPPORTED";
    public static final String IS_BROWSER_SUPPORTED = "IS_BROWSER_SUPPORTED";
    public static final String SUBMISSION_DATE_TIME_STR = "Submission Date/Time:";
    public static final String DSM_NOT_APPLICABLE = "NA";
    public static final String DSM_PEND_TYPE_GROUPED = "G";
    public static final String DSM_COVER_SHEET_DOC_ID = "ACCESS_CoverSheet";
    public static final String SEMI_COLON = ";";
    public static final String OR = "or";
    public static final String CUURENT_PAGE_STATUS = "CUURENT_PAGE_STATUS";
    public static final String NOTICE_PROOF_NEEDED = "P";
    public static final String CMB_PRINT_TEXT = "CMB_PRINT_TEXT";
    public static final String UNDOCUMENTED_ALIEN = "UA";

    // DSM Image Constants
    public static final String BUTTON_DOCUMENT_SCAN_DETAIL = "BUTTON_DOCUMENT_SCAN_DETAIL";
    public static final String BUTTON_DOCUMENT_SCAN_DETAIL_IMG = "/scan_page.gif";
    public static final String BUTTON_DOCUMENT_SCAN_DETAIL_ALT = "70035";

    public static final String BUTTON_DOCUMENT_UPLOAD_DETAIL = "BUTTON_DOCUMENT_UPLOAD_DETAIL";
    public static final String BUTTON_DOCUMENT_UPLOAD_DETAIL_IMG = "/button_upload_disabled.gif";
    public static final String BUTTON_DOCUMENT_UPLOAD_DETAIL_ALT = "70036";

    public static final String BUTTON_DOCUMENT_SKIP_DETAIL = "BUTTON_DOCUMENT_SKIP_DETAIL";
    public static final String BUTTON_DOCUMENT_SKIP_DETAIL_IMG = "/skip_this_document_button.gif";
    public static final String BUTTON_DOCUMENT_SKIP_DETAIL_ALT = "70037";

    public static final String BUTTON_DOCUMENT_PAGE_LEFT = "BUTTON_DOCUMENT_PAGE_LEFT";
    public static final String BUTTON_DOCUMENT_PAGE_LEFT_IMG = "/tb_paginate_previous.jpg";
    public static final String BUTTON_DOCUMENT_PAGE_LEFT_ALT = "70038";

    public static final String BUTTON_DOCUMENT_PAGE_RIGHT = "BUTTON_DOCUMENT_PAGE_RIGHT";
    public static final String BUTTON_DOCUMENT_PAGE_RIGHT_IMG = "/tb_paginate_next.jpg";
    public static final String BUTTON_DOCUMENT_PAGE_RIGHT_ALT = "70039";

    public static final String BUTTON_DOCUMENT_PAGE_ROTATE_RIGHT = "BUTTON_DOCUMENT_PAGE_ROTATE_RIGHT";
    public static final String BUTTON_DOCUMENT_PAGE_ROTATE_RIGHT_IMG = "/tb_rotate_right.jpg";
    public static final String BUTTON_DOCUMENT_PAGE_ROTATE_RIGHT_ALT = "70040";

    public static final String BUTTON_DOCUMENT_PAGE_ROTATE_LEFT = "BUTTON_DOCUMENT_PAGE_ROTATE_LEFT";
    public static final String BUTTON_DOCUMENT_PAGE_ROTATE_LEFT_IMG = "/tb_rotate_left.jpg";
    public static final String BUTTON_DOCUMENT_PAGE_ROTATE_LEFT_ALT = "70041";

    public static final String BUTTON_DOCUMENT_PAGE_DELETE = "BUTTON_DOCUMENT_PAGE_DELETE";
    public static final String BUTTON_DOCUMENT_PAGE_DELETE_IMG = "/tb_trash.jpg";
    public static final String BUTTON_DOCUMENT_PAGE_DELETE_ALT = "70042";

    public static final String BUTTON_DOCUMENT_ZOOM_IN = "BUTTON_DOCUMENT_ZOOM_IN";
    public static final String BUTTON_DOCUMENT_ZOOM_IN_IMG = "/zoomIn.gif";
    public static final String BUTTON_DOCUMENT_ZOOM_IN_ALT = "70038";

    public static final String BUTTON_DOCUMENT_ZOOM_OUT = "BUTTON_DOCUMENT_ZOOM_OUT";
    public static final String BUTTON_DOCUMENT_ZOOM_OUT_IMG = "/zoomOut.gif";
    public static final String BUTTON_DOCUMENT_ZOOM_OUT_ALT = "70038";

    public static final String MULTIFUNCTION_DEVICE = "MULTIFUNCTION_DEVICE";
    public static final String ACTIVE_X_CONTROL_PROMPT = "ACTIVE_X_CONTROL_PROMPT";
    public static final String DROPOFF = "DROPOFF";
    public static final String FAX_MACHINE = "FAX_MACHINE";
    public static final String INSTALL_CONTROL_PROMPT = "INSTALL_CONTROL_PROMPT";
    public static final String MAIL = "MAIL";
    public static final String PRINT_SMALL = "PRINT_SMALL";
    public static final String SCAN_PAGE = "SCAN_PAGE";
    public static final String SCAN_PAGE_DISABLED = "SCAN_PAGE_DISABLED";
    public static final String SCANNER = "SCANNER";
    public static final String SKIP_THIS_DOCUMENT_BUTTON = "SKIP_THIS_DOCUMENT_BUTTON";
    public static final String UPLOAD_ARROW = "UPLOAD_ARROW";
    public static final String DSM_WARNING = "DSM_WARNING";
    public static final String GECKO_SOFTWARE_INSTALL = "GECKO_SOFTWARE_INSTALL";
    public static final String GECKO_ADD_ONS = "GECKO_ADD_ONS";
    public static final String GECKO_INFO_BAR = "GECKO_INFO_BAR";
    public static final String GECKO_PLUGIN_FINDER_SERVICE = "GECKO_PLUGIN_FINDER_SERVICE";
    public static final String DOCUMENT_TRACKING_SHEET = "DOCUMENT_TRACKING_SHEET";

    public static final String MULTIFUNCTION_DEVICE_IMG = "/multifunction_device.jpg";
    public static final String ACTIVE_X_CONTROL_PROMPT_IMG = "/active_x_control_prompt.jpg";
    public static final String DROPOFF_IMG = "/dropoff.jpg";
    public static final String FAX_MACHINE_IMG = "/fax_machine.jpg";
    public static final String INSTALL_CONTROL_PROMPT_IMG = "/install_control_prompt.jpg";
    public static final String MAIL_IMG = "/mail.jpg";
    public static final String PRINT_SMALL_IMG = "/print_small.jpg";
    public static final String SCAN_PAGE_DISABLED_IMG = "/scan_page_disabled.jpg";
    public static final String SCANNER_IMG = "/scanner.jpg";
    public static final String UPLOAD_ARROW_IMG = "/upload_arrow.jpg";
    public static final String DSM_WARNING_IMG = "/warning.jpg";
    public static final String GECKO_SOFTWARE_INSTALL_IMG = "/geckoSoftwareInstallation.gif";
    public static final String GECKO_ADD_ONS_IMG = "/geckoAddOns.gif";
    public static final String GECKO_INFO_BAR_IMG = "/geckoInformationBar.gif";
    public static final String GECKO_PLUGIN_FINDER_SERVICE_IMG = "/geckoPluginFinderService.gif";
    public static final String BUTTON_NEXT1_DISABLED_IMG = "/button_next_disabled.gif";
    public static final String BUTTON_SUBMIT1_DISABLED_IMG = "/button_submit_disabled.gif";
    public static final String DOCUMENT_TRACKING_SHEET_IMG = "/documentTrackingSheet.gif";

    public static final String MULTIFUNCTION_DEVICE_ALT = "";
    public static final String ACTIVE_X_CONTROL_PROMPT_ALT = "";
    public static final String DROPOFF_ALT = "70113";
    public static final String FAX_MACHINE_ALT = "70110";
    public static final String INSTALL_CONTROL_PROMPT_ALT = "";
    public static final String MAIL_ALT = "70112";
    public static final String PRINT_SMALL_ALT = "70114";
    public static final String SCAN_PAGE_ALT = "";
    public static final String SCAN_PAGE_DISABLED_ALT = "";
    public static final String SCANNER_ALT = "70111";
    public static final String SKIP_THIS_DOCUMENT_BUTTON_ALT = "";
    public static final String UPLOAD_ARROW_ALT = "";
    public static final String DSM_WARNING_ALT = "";
    public static final String GECKO_SOFTWARE_INSTALL_ALT = "";
    public static final String GECKO_ADD_ONS_ALT = "";
    public static final String GECKO_INFO_BAR_ALT = "";
    public static final String GECKO_PLUGIN_FINDER_SERVICE_ALT = "";
    public static final String DOCUMENT_TRACKING_SHEET_ALT = "70119";
    // Constants For Lock Box
    public static final String BUTTON_SUB_SEARCH_CRITERIA_RESTORE = "BUTTON_SUB_SEARCH_CRITERIA_RESTORE";
    public static final String BUTTON_SUB_SEARCH_CRITERIA_RESTORE_IMG = "/button_sub_search_criteria_restore.gif";
    public static final String BUTTON_SUB_SEARCH_CRITERIA_RESTORE_ALT = "64104";
    public static final String BUTTON_SUB_SEARCH_CRITERIA_SAVE = "BUTTON_SUB_SEARCH_CRITERIA_SAVE";
    public static final String BUTTON_SUB_SEARCH_CRITERIA_SAVE_IMG = "/button_sub_search_criteria_save.gif";
    public static final String BUTTON_SUB_SEARCH_CRITERIA_SAVE_ALT = "64105";
    public static final String DEPOSIT_DATE_PERIOD_RB = "depositDate_RB1";
    public static final String DEPOSIT_DATE_WRT_RB = "depositDate_RB2";
    public static final String DEPOSIT_DATE_WRT_TB = "depositDate_DD";
    public static final String DEPOSIT_DATE_RB = "depositDate_RB3";
    public static final String DEPOSIT_DATE_PERIOD_ST = "depositDate_ST1";
    public static final String DEPOSIT_DATE_WRT_ST = "depositDate_ST2";
    public static final String DEPOSIT_DATE_AFTER = "depositDate_DD_AFTER";
    public static final String DEPOSIT_DATE_BEFORE = "depositDate_DD_BEFORE";
    public static final String PAYMENT_DATE_PERIOD_RB = "paymentDate_RB1";
    public static final String PAYMENT_DATE_WRT_RB = "paymentDate_RB2";
    public static final String PAYMENT_DATE_TB = "paymentDate_PD";
    public static final String PAYMENT_DATE_AFTER = "paymentDate_PD_AFTER";
    public static final String PAYMENT_DATE_BEFORE = "paymentDate_PD_BEFORE";
    public static final String PAYMENT_DATE_PERIOD_ST = "paymentDate_ST1";
    public static final String PAYMENT_DATE_WRT_ST = "paymentDate_ST2";
    public static final String PAYMENT_DATE_RANGE_RB = "paymentDate_RB3";
    public static final String LBOX_FIRST_NAME = "firstName";
    public static final String LBOX_LAST_NAME = "lastName";
    public static final String ZIPCODE = "zipCode";
    public static final String LBOX_PAYMENT_STATUS = "paymentStatus";
    public static final String PAYMENT_METHOD = "paymentMethod";
    public static final String BATCH_NUMBER = "batchNumber";
    public static final String TRACKING_NUMBER = "trackingNumber_NO";
    public static final String LBOX_PHONE_NUMBER = "phoneNumber";
    public static final String LBOX_PHONE1_NUMBER = "phone1phoneNumber";
    public static final String LBOX_PHONE2_NUMBER = "phone2phoneNumber";
    public static final String LBOX_PHONE3_NUMBER = "phone3phoneNumber";
    public static final String TRACKING_NUMBER_TYPE = "trackingNumber_TY";
    public static final String CHECK_NUMBER = "checkNumber";
    public static final String WORKER_ID = "workerID";
    public static final String LBOX_IBOX_COOKIE_KEY = "LBOX_IBOX_COOKIE_KEY";
    public static final String LBOX_IBOX_SEARCH_PAGE_DATA = "LBOX_IBOX_SEARCH_PAGE_DATA";
    public static final String WHAT_WOULD_YOU_LIKE_TO_DO = "WHAT_WOULD_YOU_LIKE_TO_DO";
    public static final String FMATCH = "FMATCH";
    public static final String LMATCH = "LMATCH";
    public static final String CMATCH = "CMATCH";
    public static final String COMMENTS = "COMMENTS";
    public static final String LBOX_SEARCH_LIST_RESULT = "LBOX_SEARCH_LIST_RESULT";
    public static final String IGNORE_POTENTIAL_MATCHES = "Ignore_Pot_Matches";
    public static final String LBOX_IBOX_COLLECTION = "LBOX_IBOX_Collection";
    public static final String CUST_LBOX_IBOX_COLLECTION = "CUST_LBOX_IBOX_Collection";
    public static final String ECF_UNKNOWN_DOCUMENT_CODE = "UN";
    public static final String HIST_CD = "histCode";
    public static final String VCLTXT = "VCLTXT";
    public static final String DSMZEROS = "0000000000";

    public static final String EXCEPTION_REASON = "exceptionReason";
    public static final String BUTTON_BACK1_DISABLED_IMG = "/button_back_disabled.jpg";

    // EDSP moveout
    public static final String BIRTH_DATE = "BRTH_DT";
    public static final String SEX_IND = "SEX_IND";
    public static final String APP_INDV = "APP_INDV";

    // DSM COVER SHEET XML CONSTANT
    public static final String COVERSHEET_XML_TEMPLATE = new StringBuilder().append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
            .append("<dataroot xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ")
            .append("xsi:noNamespaceSchemaLocation=\"/san/CaresApp/Schema/DHS_ACCESS_CoverSheet.xsd\"> ").append("<CORRESPONDENCE_DATA>")
            .append("<CORR_ID_NUM>{0}</CORR_ID_NUM>").append("<CORR_ID_TYP>{1}</CORR_ID_TYP>").append("<CORR_LANGUAGE_IND>{2}</CORR_LANGUAGE_IND>")
            .append("<DTS_UNIQUE_ID>{3}</DTS_UNIQUE_ID>").append("<ONLINE_SWITCH>{4}</ONLINE_SWITCH>").append("<CORR_HEADER>")
            .append("<PRIMARY_PERSON_NAME>{5}</PRIMARY_PERSON_NAME>").append("<IM_AGENCY_CONTACT_LINE_1>{6}</IM_AGENCY_CONTACT_LINE_1>")
            .append("<W2_AGENCY_CONTACT_LINE_1>{7}</W2_AGENCY_CONTACT_LINE_1>").append("<CC_AGENCY_CONTACT_LINE_1>{8}</CC_AGENCY_CONTACT_LINE_1>")
            .append("<COMMUNITY_PARTNER_NAME>{9}</COMMUNITY_PARTNER_NAME>").append("<FAX_LINE1_NAME>{10}</FAX_LINE1_NAME>")
            .append("<FAX_LINE1>{11}</FAX_LINE1>").append("<FAX_LINE2_NAME>{12}</FAX_LINE2_NAME>").append("<FAX_LINE2>{13}</FAX_LINE2>")
            .append("<MAIL_ADDRESS1_NAME>{14}</MAIL_ADDRESS1_NAME>").append("<MAIL_ADDRESS1_STREET>{15}</MAIL_ADDRESS1_STREET>")
            .append("<MAIL_ADDRESS1_CITY>{16}</MAIL_ADDRESS1_CITY>").append("<MAIL_ADDRESS1_ST>{17}</MAIL_ADDRESS1_ST>")
            .append("<MAIL_ADDRESS1_ZIP_CD>{18}</MAIL_ADDRESS1_ZIP_CD>").append("<MAIL_ADDRESS2_NAME>{19}</MAIL_ADDRESS2_NAME>")
            .append("<MAIL_ADDRESS2_STREET>{20}</MAIL_ADDRESS2_STREET>").append("<MAIL_ADDRESS2_CITY>{21}</MAIL_ADDRESS2_CITY>")
            .append("<MAIL_ADDRESS2_ST>{22}</MAIL_ADDRESS2_ST>").append("<MAIL_ADDRESS2_ZIP_CD>{23}</MAIL_ADDRESS2_ZIP_CD>")
            .append("<IN_PERSON_ADDRESS1_NAME>{24}</IN_PERSON_ADDRESS1_NAME>").append("<IN_PERSON_ADDRESS1_STREET>{25}</IN_PERSON_ADDRESS1_STREET>")
            .append("<IN_PERSON_ADDRESS1_CITY>{26}</IN_PERSON_ADDRESS1_CITY>").append("<IN_PERSON_ADDRESS1_ST>{27}</IN_PERSON_ADDRESS1_ST>")
            .append("<IN_PERSON_ADDRESS1_ZIP_CD>{28}</IN_PERSON_ADDRESS1_ZIP_CD>").append("<IN_PERSON_ADDRESS2_NAME>{29}</IN_PERSON_ADDRESS2_NAME>")
            .append("<IN_PERSON_ADDRESS2_STREET>{30}</IN_PERSON_ADDRESS2_STREET>").append("<IN_PERSON_ADDRESS2_CITY>{31}</IN_PERSON_ADDRESS2_CITY>")
            .append("<IN_PERSON_ADDRESS2_ST>{32}</IN_PERSON_ADDRESS2_ST>").append("<IN_PERSON_ADDRESS2_ZIP_CD>{33}</IN_PERSON_ADDRESS2_ZIP_CD>")
            .append("</CORR_HEADER>").append("</CORRESPONDENCE_DATA>").append("</dataroot>").toString();

    // LOCKBOX XML CONSTANTS
    public static final String FILE_INDICATOR = "FileIndicator";
    public static final String PROCESS_DATE = "ProcessDate";
    public static final String TOTAL_TRANSACTION_COUNT = "TotalTransactionCount";
    public static final String TOTAL_PAYMENT_AMOUNT = "TotalPaymentAmount";
    public static final String BATCH = "Batch";
    public static final String DETAIL_RECORD = "DetailRecord";
    public static final String TRANSACTION_SEQUENCE_NUMBER = "TransactionSequenceNumber";
    public static final String LBOX_PAYMENT_AMOUNT = "PaymentAmount";
    public static final String LBOX_INITIATION_DATE = "InitiationDate";
    public static final String LBOX_CHECK_NUMBER = "CheckNumber";
    public static final String DEPOSIT_DATE = "DepositDate";
    public static final String LBOX_PAYMENT_TYPE = "PaymentType";
    public static final String UNKNOWN_TRACKING_NUMBER = "UnknownTrackingNumber";
    public static final String APPLICATION_NUMBER = "ApplicationNumber";
    public static final String LBOX_CASE_NUMBER = "CaseNumber";
    public static final String NO_CORE_PLAN_REQUEST = "NC";
    public static final String INVALID_TRACKING_NUMBER = "IT";
    public static final String NO_TRACKING_NUMBER = "NT";
    public static final String FEE_REQUIREMENT_MET = "FM";
    public static final String FEE_WAIVED = "FW";
    public static final String SEND_LOCKBOX_FAILURE_EMAIL = "SEND_LOCKBOX_FAILURE_EMAIL";
    public static final String LOCKBOX_TEST_EMAIL_DISTRIBUTION_ID = "LOCKBOX_TEST_EMAIL_DISTRIBUTION_ID";
    public static final String LOCKBOX_FILE_EXTESNION = "1640";
    public static final String LOCKBOX_SCHEMA_NAME = "Lockbox.xsd";
    public static final String MILWAUKEE_TRUST_FUND = "MCF";
    public static final String MILWAUKEE_TRUST_FUND_EXCEPTION = "MK";
    public static final String LOCKBOX_EXCESS_PAYMENT = "EX";
    public static final String PAYMENT_RECEIVED_BEFORE_EXPIRATION = "PB";
    public static final String P4HB_INFORMATION = "HB";
    

    // PCR# Next Steps Constants
    // NEXT STEPS PROFILE CONSTANTS
    public static final String NXT_STPS_CURR_MODULE = "NXTCURMODULE";
    public static final String NXT_HNA_MODULE = "HNA";
    public static final String NXT_FEE_MODULE = "FEE";
    public static final String NXT_HMO_MODULE = "HMO";
    public static final String NXT_NEHNA_MODULE = "NEHNA";
    public static final String NXT_BCB_INDV_1_MODULE = "BCB1";
    public static final String NXT_BCB_INDV_2_MODULE = "BCB2";
    public static final String NXT_DSM_MODULE = "DSM";

    // NEXT STEPS SESSION CONSTATNS
    public static final String NXT_FLOW_TYP = "NXTFLOWTYP";
    public static final String NXT_DRVR_TYPE = "1";
    public static final String NXT_NON_DRVR_TYPE = "2";

    public static final String NXT_PREV_MODULE = "NXTPREVMOD";
    public static final String NXT_PREV_CMB = "CMB";
    public static final String NXT_PREV_SUB = "SUB";

    public static final String NXT_NOT_STARTED = "NS";
    public static final String NXT_NOT_REQ = "NR";
    public static final String NXT_COMPLETE = "CP";

    public static final String NEXT_STEPS_TRK_NUM = "NEXT_STEPS_TRK_NUM";

    // Waitlist Phase III
    public static final String CP_CWW_WAITLIST_COUNT = "WAITLISTCOUNT";
    public static final String CP_CWW_WS_CLA = "CLA";
    public static final String WAITLIST_ADDED_TO_WAITLIST = "OW";
    public static final String WAITLIST_INVITED_TO_APPLY = "IT";
    public static final String WAITLIST_REMOVED_FROM_WAITLIST_DUPLICATE_REQUEST = "DP";
    public static final String WAITLIST_REMOVED_FROM_WAITLIST_PROGRAM_RULES_NOT_MET = "RP";
    public static final String WAITLIST_REMOVED_FROM_WAITLIST_WAITLIST_SECURITY_CODE_EXPIRED = "SE";
    public static final String WAITLIST_REMOVED_FROM_WAITLIST_WAITLIST_SECURITY_CODE_USED = "SU";

    public static final String CHILD_CARE = "CC";

    public static final String HEALTH_CARE_M26 = "M26";
    public static final String HEALTH_CARE_M50 = "M50";
    public static final String HEALTH_CARE_MAJ_CAT = "HC";

    // For Job Income wages
    public static final int WEEKLY_TO_MONTHLY_HC_INCOME = 4;
    public static final int BI_WEEKLY_TO_MONTHLY_HC_INCOME = 2;

    // EDSP Starts - People Gate Post
    public static final String HH_EXT_HELP_FROM_OTHERS = "HO";
    public static final String HH_EXT_INDV_DEMO_INFO = "ID";
    public static final String HH_EXT_DRUG_FELONY = "DF";

    // EDSP Ends

    public static final String WORK_RELATED_EXPENSE = "WE";

    // Adding CONSTANTS for Buttons
    public static final String UPDATE_SECRET_KEY = "UPDATE_SECRET_KEY";
    public static final String UPDATE_SECRET_KEY_IMG = "/button_update_questions.jpg";
    public static final String UPDATE_SECRET_KEY_ALT = "30200302";
    public static final String LINK_CASE = "LINK_CASE";
    public static final String LINK_CASE_IMG = "/LinkCaseButton.png";
    public static final String LINK_CASE_ALT = "30200300";
    public static final String SECRET_KEY = "secretKey";
    public static final String UPDATE_METHOD_SECRET_KEY = "updateSecretKey";
    public static final String LOAD_CLIENT_CASE_ASSOC = "loadClientCaseAssocLinkCase";
    public static final String LOAD_CASE_ASSOC = "loadCaseAssocLinkCase";
    public static final String SECRET_KEY_FLAG = "secretKeyFlag";
    public static final String ERR_MSG1_SECRET_KEY = "90917";
    public static final String ERR_MSG2_SECRET_KEY = "90928";
    public static final String ERR_MSG3_SECRET_KEY = "90919";
    public static final String ERR_MSG4_SECRET_KEY = "97028";
    public static final String SUCCESS_MSG_SECRET_KEY = "90918";
    public static final String SECURITY_WS_HOST = "SecurityWSHost";
    public static final String CASE_ASSOC_INDICATOR = "caseAssocInd";
    public static final String ERR_MSG_LINK_CASE = "90930";
    public static final String CASE_ASSOC_FLAG = "caseAssocFlag";
    public static final String CASE_RITEM_FLAG = "readitems";
    public static final String SUCCESS_MSG_CASE_ASSOC = "90932";
    public static final String ERR_MSG1_CASE_ASSOC = "90931";
    public static final String ERR_MSG2_CASE_ASSOC = "90745";
    public static final String ERR_MSG3_CASE_ASSOC = "90933";
    public static final String ERR_MSG4_CASE_ASSOC = "90934";
    public static final String ERR_MSG5_CASE_ASSOC = "90935";
    public static final String ERR_MSG6_CASE_ASSOC = "90936";
    public static final String ERR_MSG7_CASE_ASSOC = "90937";
    public static final String ERR_MSG8_CASE_ASSOC = "90938";
    public static final String ERR_MSG9_CASE_ASSOC = "90939";
    public static final String ERR_MSG10_CASE_ASSOC = "90940";
    public static final String ERR_MSG10_CASE_ASSOC_CLIENT = "99080";
    public static final String ERR_MSG11_CASE_ASSOC = "90941";
    public static final String CASE_ASSOC_FIRST_NAME = "firstName";
    public static final String CASE_ASSOC_LAST_NAME = "lastName";
    public static final String CASE_ASSOC_AR_FIRST_NAME = "arFirstName";
    public static final String CASE_ASSOC_AR_LAST_NAME = "arLastName";
    public static final String CASE_ASSOC_HOME_ADDRESS = "homeAddress";
    public static final String CASE_ASSOC_DATE_OF_BIRTH = "dateOfBirth";
    public static final String CASE_ASSOC_SSN = "socialSecurity";
    public static final String CASE_CLIENT_ID = "clientId";
    public static final String CASE_ASSOC_SOC_SER_CASE = "socialServiceCase";
    public static final String CASE_ASSOC_CASE_NUM = "caseNumber";
    public static final String PCK_CASE_NUM = "pckCaseNum";
    public static final String MORE_CASE_ASSOC = "moreSocSerAssocCase";
    public static final String MORE_CLIENT_CASE_ASSOC = "moreSocSerClientAssocCase";
    public static final String NAME_REGEX = "^[a-zA-Z.'-]{1,30}$";
    public static final String ADDRESS_REGEX = "^[a-zA-Z0-9#/ .,'-]+$";
    public static final String DOB_REGEX = "^(0[1-9]|1[012])[/](0[1-9]|[12][0-9]|3[01])[/](19|20)\\d\\d$";
    public static final String SSN_REGEX = "^((?!000)(?!666)\\d{3})((?!00)\\d{2})((?!0000)\\d{4})$";
    public static final String SSCN_REGEX = "^[0-9]{7,12}$";
    public static final String MIS_MATCH = "MISMATCH";
    public static final String ADD_VERIFICATION_CASES = "addVerficationRequiredCases";
    public static final String CHECK_AUTH_FOR_CASES = "checkAuthorizationForCases";
    public static final String ADD_VER_CASE_NO = "caseNumber";
    public static final String ADD_VER_CLIENT_ID = "clientIdentifier";
    public static final String ADD_VER_CLIENT_ID_TYPE = "clientIdentifierType";
    public static final String RENEW_CHANGE = "renewChange";
    public static final String DATE_REGEX = "^(0[1-9]|1[012])[/](0[1-9]|[12][0-9]|3[01])[/]\\d\\d\\d\\d$";
    //Splash Page 
    public static final String SPLASH_PAGE_APPLYING_NEW_BENEFITS = "applyNewBenefits";
    public static final String SPLASH_PAGE_APPLYING_BENEFITS = "applyBenefits";
    public static final String SPLASH_PAGE_RECEIVING_BENEFITS = "receiveBenefits";
    public static final String SPLASH_PAGE_WHAT_COUNTY = "whatCounty";
    public static final String SPLASH_PAGE_LOG_IN_AS_PROVIDER = "splashPageLogInAsProvider";
    public static final String SPLASH_PAGE_PCK_CASE_NUM = "pckCaseNumber";
    
    // EDSP Ends
    public static final String APP_IN_MEDCR_COLLECTION = "APP_IN_MEDCR_Collection";
    public static final String SEC_MEDCR = "SEC_MEDCR";
    public static final String FST_MEDCR = "FST_MEDCR";
    public static final String FST_HOSC = "FST_HOSC";
    public static final String SEC_HOSC = "SEC_HOSC ";
    public static final String FST_NURS = "FST_NURS";
    public static final String SEC_NURS = "SEC_NURS ";
    public static final String FST_OUTS = "FST_OUTS";
    public static final String SEC_OUTS = "SEC_OUTS ";
    public static final String RMC_329 = "sql-RM329";
    public static final String RMC_389 = "sql-RM389";
    public static final String RMC_400 = "sql-RM400";
    public static final String RMC_401 = "sql-RM401";
    public static final String APP_NUM = "APP_NUM";
    public static final String INDV_SEQ_NUM = "INDV_SEQ_NUM";
    public static final String BFR_TAX_CHG_IND = "BFR_TAX_CHG_IND";
    public static final String INC_TAX_CHG_IND = "INC_TAX_CHG_IND";
    public static final String UTIL_BILL_CHG_IND = "UTIL_BILL_CHG_IND";
    public static final String HOUS_BILL_CHG_IND = "HOUS_BILL_CHG_IND";
    public static final String SNAP_SHELTER_STANDARD_EXP_IND = "SNAP_SHELTER_STANDARD_EXP_IND";
    public static final String INDV_PRGM_CHG_IND = "INDV_PRGM_CHG_IND";
    public static final String MAX_SEQ_NUM = "MAX_SEQ_NUM";
    public static final String MAX_HLT_INS_SEQ_NUM = "MAX_HLT_INS_SEQ_NUM";
    public static final String ENDED = "E";

    // Interface
    // -- Program Types
    public static final String PROGRAM_TYPE = "TPGM";
    public static final String PROG_CD_TANF = "TF";
    public static final String PROG_CD_SNAP = "FS";
    public static final String PROG_CD_WIC = "WC";
    public static final String PROG_CD_MED = "ME";
    public static final String PROG_CD_CHLD = "CC";
    public static final String PROG_CD_PEACH = "PC";
    public static final String PROG_CD_FUEL = "LI";

    public static final String PGM_FUEL_ASSI = "FU";
    public static final String PGM_COOL_ASSI = "CO";
    public static final String PGM_CRI_ASSI = "CR";
    // -- Program Types End
    // WORKER PORTEL CODES
    public static final String PROG_CD_MED_WP = "MC";
    public static final String PROG_CD_SNAP_WP = "SN";
    // -- Utility Types
    public static final String UTIL_HT_IND = "HT";
    public static final String UTIL_EL_IND = "EL";
    public static final String UTIL_TN_IND = "TN";
    public static final String UTIL_AC_IND = "AC";
    public static final String UTIL_WA_IND = "WA";
    public static final String UTIL_SW_IND = "SW";
    public static final String UTIL_GB_IND = "GB";
    public static final String UTIL_OT_IND = "OT";
    // -- Utility Types End

    // -- Utility Bill Types
    public static final String UTIL_BILL_TYPES = "TUTL";
    public static final String UTIL_BILL_TYPE_O1 = "O1";
    public static final String UTIL_BILL_TYPE_O2 = "O2";
    public static final String UTIL_BILL_TYPE_O3 = "O3";
    public static final String UTIL_BILL_TYPE_OT = "OT";
    // -- Utility Bill Types End

    // -- Authorized Representative Program
    public static final String AUT_REP_PGM_SN = "SN";
    public static final String AUT_REP_PGM_TA = "TA";
    public static final String AUT_REP_PGM_MC = "MC";
    // -- Authorized Representative Program End

    // -- Authorized Representative Duty
    public static final String AUT_REP_DUT_AFB = "AA";
    public static final String AUT_REP_DUT_BEF = "RB";
    public static final String AUT_REP_DUT_REC = "RR";
    public static final String AUT_REP_DUT_REQ = "RL";
    public static final String AUT_REP_DUT_OTH = "OT";
    // -- Authorized Representative Duty End

    // -- Race
    public static final String RACE_CODE = "TRAC";
    public static final String RACE_AM_IN = "I";
    public static final String RACE_ASIAN = "A";
    public static final String RACE_BLACK = "B";
    public static final String RACE_PAC_IS = "P";
    public static final String RACE_WHITE = "W";
    // -- Race End

    // -- Disability Status
    public static final String DABL_BLI = "BLI";
    public static final String DABL_DIS = "DIS";
    public static final String DABL_CFD = "CFD";
    // Changes made by Rashmi for IN-Pre Work---->start
    public static final String DABL_BL = "BL";
    public static final String DABL_ME = "ME";
    public static final String DABL_DE = "DE";
    public static final String DABL_PY = "PY";
    public static final String DABL_MP = "MP";
    // -------------------->end
    public static final List<String> DABL_TYPES = new ArrayList<String>(Arrays.asList(DABL_BLI, DABL_DIS, DABL_CFD, DABL_BL, DABL_ME, DABL_DE,
            DABL_PY, DABL_MP));

    // -- Disability Status End

    // -- Income Types
    public static final String INC_CHIL_SUPP = "DS";
    public static final String INC_SSI_SUPP = "SI";
    public static final String INC_SSN_SUPP = "SA";
    public static final String INC_SFA_SUPP = "SF";
    public static final String INC_MOTH_SUPP = "MO";
    public static final String INC_OTH_SUPP = "OT";
    /*public static final String INC_OTH_DCSS = "DS";*/
    public static final String INC_OTH_DCSS = "CSCO";
    public static final String INC_DIR_CHIL = "DC";
    public static final String INC_OTH_RSDI = "SS";
    public static final String INC_OTH_VET = "VA";
    public static final String INC_OTH_CONT = "CT";
    public static final String INC_OTH_INC = "OI";
    public static final String INC_OTH_VET_BNFT = "VE";
    public static final String INC_OTH_TRBL_ASST = "AA";
    public static final String INC_OTH_OTH_INC = "OO";
    public static final String OTH_IND_GAMBL_PMNTS = "IGP";
    public static final String INC_CHIL_SUPP_HDR = "DCSS Support Income";   
    public static final String INC_CHIL_SUPP_DESC = "DCSS Child Support Income";
    public static final String INC_CHIL_SUPP_SUB_HDR =
    "Division of Child Support Services (DCSS) Child Support Income";
    // -- Income Types End

    public static final String CURRENT_JOB_IND = "R";

    public static final String HEAD_OF_HOUSE_HOLD_R = "R";

    public static final String MM_DD_YY_FORMAT = "MM/dd/yyyy HH:mm:ss";
    
    /*2015-03-01 00:00:00*/
    public static final String LIST_VIEW_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    // added by Rashmi for IN-Pre Work
    public static final String MM_DD_YY_ONLY = "MM/dd/yyyy";
    public static final String YYYY_MM_DD_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String YYYY_MM_DD_ONLY = "yyyy-MM-dd";
    public static final SimpleDateFormat DATEFORMAT_MMDDYYYY = new SimpleDateFormat(MM_DD_YY_ONLY);
    public static final SimpleDateFormat DATEFORMAT_YYYYMMDD = new SimpleDateFormat(YYYY_MM_DD_ONLY);

    public static final String APP_REQUEST_TYPE = "AB";
    public static final String RMB_REQUEST_TYPE = "RN";
    public static final String RMC_REQUEST_TYPE = "CH";
    public static final String RMC_PDF_REQUEST_TYPE = "RMCPDF";

    public static final String ALL_STATES_TSTA = "TSTA";
    public static final String CONT_MTHD = "CNMD";
    public static final String DEAF_CONT_MTHD = "HEIM";
    public static final String PAST_ADDRESS = "TYAN";
    public static final String CONT_TIME = "CTTM";
    public static final String LANGUAGE_CODE = "TLAG";
    public static final String GENDER_CODE = "TGEN";
    public static final String TRIBE_CODE = "TRBN";
    public static final String MARITAL_STATUS_CODE = "TMAR";
    public static final String ALIEN_STATUS_CODE = "TALS";
    public static final String ABSENCE_RESN_CODE = "TRAB";
    public static final String TYPE_OF_EMPLOYMENT = "TEIF";
    public static final String TYPE_OF_SELF_EMPLOYMENT = "TSET";
    public static final String TYPE_OF_SELF_EMPL_EXPENSE = "TETY";
    public static final String INCOME_FREQUENCY_CODE = "TINF";
    public static final String DAY_OF_WEEK = "TDOW";
    public static final String LIVING_ARRANGMENT_CODE = "TLAR";
    public static final String HOUSING_BILL_TYPE = "THBT";
    public static final String SUFFIX_CODE = "TSFX";
    public static final String BONUS_TYPE_CODE = "TBCP";
    public static final String JOB_END_REASON_CODE = "TRJE";
    public static final String OTHR_INCOME_TYPE_CODE = "OITY";
    public static final String PLACE_OF_BIRTH_OUTOF_COUNTRY = "OT";
    public static final String MEDICAL_BILL_TYPE = "MDTY";
    public static final String MEDICARE_PYMT_METHOD = "TMPM";
    public static final String LIQUID_ASSET_TYPE = "TLAS";
    public static final String ACC_MNT_RES_CODE = "TRMA";
    public static final String VEHICAL_ASSET_TYPE = "TVAS";
    public static final String REAL_ESTATE_TYPE = "TROP";
    public static final String PERSONAL_PROPERTIES = "TPPR";
    public static final String BURRIAL_ASSET_TYPE_CODE = "TBAS";
    public static final String LIFE_INSURENCE_TYPE_CODE = "TLIN";
    public static final String ENROLLMENT_STATUS = "TSAC";
    public static final String SCHOOL_GRADE = "TSEN";
    public static final String COUNTY_CODE = "COUN";
    public static final String SEC_QUES = "TSEQ";
    public static final String BANK_ACCOUNT_TYPE = "TFAC";
    //public static final String OTHER_LIQUID_ASSET_TYPE = "TLAO";
    public static final String OTHER_LIQUID_ASSET_TYPE = "TFAD";

    public static final String WSDL_URL = "/FullCaseDetailsInquiry_MMWeb/sca/FullCaseDetailsInquiry_IExport/WEB-INF/wsdl/FullCaseDetailsInquiry_MM_FullCaseDetailsInquiry_IExport.wsdl";
    public static final String QNAME = "http://FullCaseDetailsInquiry_MM/FullCaseDetailsInquiry_I/Binding";
    public static final String SERVICE = "FullCaseDetailsInquiry_IExport_FullCaseDetailsInquiry_IHttpService";

    public static final String JOINT_OWNER_UTILITY_BILL = "UB";
    public static final String CW_INSERT = "cwInsert";
    // Adding CONSTANTS for Buttons
    public static final String CP_APP_IN_IRWE_COLLECTION = "CP_APP_IN_IRWE_Collection";
    public static final Object SEC_WRE = "SEC_WRE";
    public static final Object FST_WRE = "FST_WRE";
    public static final String RMC_330 = "sql-RM331";

    public static final String MEDICARE_PARTC = "Part C";
    // RMC Submit
    public static final String SELF_FIRST_NAME = "firstName_self";
    public static final String AR_FIRST_NAME = "firstName_authRep";
    public static final String SELF_LAST_NAME = "lastName_self";
    public static final String AR_LAST_NAME = "lastName_authRep";
    public static final String SELF_MIDDLE_INITIAL = "middleInitial_self";
    public static final String AR_MIDDLE_INITIAL = "middleInitial_authRep";
    public static final String SELF_SUFFIX = "suffix_self";
    public static final String AR_SUFFIX = "suffix_authRep";
    public static final String AR_ELEC_SIGN = "clientCaseAssocInd";
    public static final String SELF_ELEC_SIGN = "caseAssocInd";
    public static final String PHY_MEN_CHALLENGED = "appPhyMenChalngd";
    public static final String VOTER_REG = "registrationInd";
    public static final String ADDTN_INFO = "addtnInfo";
    public static final String EMPLOYMENT_PAST = "P";
    public static final String ON_FILE = "On-File";
    // program keys
    public static final short PROGRAM_KEY_MA = 0;
    public static final short PROGRAM_KEY_SNAP = 2;
    public static final short PROGRAM_KEY_TANF = 9;

    //
    public static final String RMB_WAGE_TYPE_BONUS = "BON";
    public static final String RMB_WAGE_TYPE_COMMISSION = "COM";
    public static final String RMB_WAGE_TYPE_OVERTIME = "OVR";

    public static final String CUSTOM_ERROR_CODE = "700";
    public static final String SELF_EMPL_EXP_TYPE_1 = "1";
    public static final String SELF_EMPL_EXP_TYPE_2 = "2";
    public static final String SELF_EMPL_EXP_TYPE_3 = "3";
    public static final String SELF_EMPL_EXP_TYPE_4 = "4";
    public static final String SELF_EMPL_EXP_TYPE_5 = "5";
    public static final String SELF_EMPL_EXP_TYPE_6 = "6";
    public static final String SELF_EMPL_EXP_TYPE_7 = "7";
    public static final String SELF_EMPL_EXP_TYPE_8 = "8";
    public static final String SELF_EMPL_EXP_TYPE_9 = "9";
    public static final String SELF_EMPL_EXP_TYPE_10 = "10";
    public static final String SELF_EMPL_EXP_TYPE_11 = "11";
    public static final String SELF_EMPL_EXP_TYPE_12 = "12";
    public static final String SELF_EMPL_EXP_TYPE_13 = "13";
    public static final String SELF_EMPL_EXP_TYPE_14 = "14";
    public static final String SELF_EMPL_EXP_TYPE_15 = "15";
    public static final String SELF_EMPL_EXP_TYPE_16 = "16";

    public static final String TYPE_OF_SELF_EMPL_EXPENSE_COLUMN = "2201";

    public static final String AR_FLAG = "AuthorizedRepCaseNumbers";

    public static final String MODIFIED_FIELDS = "ModifiedFields";

    public static final String SELF_SERVICE_INTEGRATION_WEBSERVICE_URL = "SelfServiceIntegrationWebService";
    public static final String SSA_COMPOSITE_WEBSERVICE_URL = "SSACOMPOSITEWebService";
    public static final String DOL_WEBSERVICE_URL = "DOLWebService";
    public static final String DOL_WEBSERVICE_WP_URL = "DOLWebWPService";
    public static final String CMB_CASE_NUM = "CMB_CASE_NUM";
    public static final String TASK_MANAGEMENT_WEBSERVICE_URL = "TaskManagementWebService";

    public static final String HOUSEHOLD_NAME = "houseHoldName";
    public static final String AMDOC_CASENUM = "caseNum";
    public static final String NOTICE_MAILED = "USMAIL";
    public static final String NOTICE_MAILED_FLG = "N";
    public static final String NOTICE_EMAILED = "EMAIL";
    public static final String NOTICE_EMAILED_FLG = "Y";
    public static final String NOTICE_MAILED_AND_EMAILED = "BOTH";
    public static final int NOTICE_MONTH_RANGE = 12;
    public static final String ELIGIBILITY_DOCUMENTATION_DOC_ID = "FGG225";

    //OTHER BILL GATEPOST

    public static final String CHILD_CARE_BILL = "CCB";
    public static final String CHILD_CARE_OBLIGATION = "CT";
    public static final String MEDICAL_BILLS = "MB";
    public static final String UNPAID_MEDBILL = "UM";

    public static final String ADD_CHILD_CARE = "ACC";
    public static final String ADD_CHILD_OBLIG = "ACO";

    public static final String CHILD_CARE_STATUS = "CHILD_CARE_STATUS";
    public static final String CHILD_OBLG_STATUS = "CHILD_OBLG_STATUS";

    public static final String BUTTON_ADD_PLAIN = "BUTTON_ADD_PLAIN";
    public static final String BUTTON_ADD_PLAIN_ALT = "30414";
    public static final String BUTTON_ADD_PLAIN_IMG = "/button_add_plain_orange.png";

    public static final String BUTTON_EDIT = "BUTTON_EDIT";
    public static final String BUTTON_EDIT_ALT = "800000383";
    public static final String BUTTON_EDIT_IMG = "/button_edit_orange.png";

    public static final String REQUIRED = "R";
    public static final String HOSPITAL_STAY = "HS";

    public static final String BUTTON_RESET_CPP_USER_SRCH = "BUTTON_RESET_CPP_USER_SRCH";
    public static final String BUTTON_RESET_CPP_USER_SRCH_IMG = "/button_reset.jpg";
    public static final String BUTTON_RESET_CPP_USER_SRCH_ALT = "500002832";

    public static final String BUTTON_SRCH_CPP_USER_SRCH = "BUTTON_SRCH_CPP_USER_SRCH";
    public static final String BUTTON_SRCH_CPP_USER_SRCH_IMG = "/button_search.png";
    public static final String BUTTON_SRCH_CPP_USER_SRCH_ALT = "500002831";

    public static final String REPORT_CHANGE_MODE = "C";
    public static final String REPORT_NEW_MODE = "N";
    public static final String REPORT_END_MODE = "E";

    public static final String INDV_COLL = "INDV_COLL";
    public static final String ARJGQ = "ARJGQ";
    public static final String MILLISECONDS = "milliseconds";
    public static final String ARIKI = "ARIKI";
    public static final String ARJIS = "ARJIS";
    public static final String ARUIS = "ARUIS";
    public static final String AREHI = "AREHI";
    public static final String ARCFN = "ARCFN";
    public static final String ARBCN = "ARBCN";
    public static final String LOOPING_QUESTION = "loopingQuestion";
    public static final String SHOW_LOOPING_QUESTION = "showLoopingQuestion";

    //other income types
    public static final String OTH_ADOPTION_ASSISTANCE = "AS";
    public static final String OTH_ADOPTION_PAYMENTS = "AP";
    public static final String OTH_AGENT_ORNG_PYMT = "AO";
    public static final String OTH_ALIMONY = "AL";
    public static final String OTH_CAPITAL_GAINS = "CG";
    public static final String OTH_DEATH_BNFT = "DB";
    public static final String OTH_DABL_INCM = "DM";
    public static final String OTH_DR_RELIEF = "DR";
    public static final String OTH_EDU_ASSIST = "ED";
    public static final String OTH_ENERGY_ASSIST = "EA";
    public static final String OTH_FRM_ALOT = "FA";
    public static final String OTH_FOSTER_CARE_PYMT = "FP";
    public static final String OTH_GEN_ASSIST = "GA";
    public static final String OTH_INT_DIV_PYMT = "IP";
    public static final String OTH_IRA_DIST = "IRA";
    public static final String OTH_LOTTERY_WIN = "LW";
    public static final String OTH_LUMP_SUM = "LS";
    public static final String OTH_MIL_ALOT = "MI";
    public static final String OTH_MON_FRO_OTH = "MF";
    public static final String OTH_NET_RENT_ROYALTY = "NR";
    public static final String OTH_OTH = "OO";
    public static final String OTH_ANNY_PYMT = "PF";
    public static final String OTH_PYMT_BO = "PB";
    public static final String OTH_PENSION = "PN";
    public static final String OTH_RR_RETIRE = "RT";
    public static final String OTH_REFUGEE_CASH = "RC";
    public static final String OTH_REL_CARE = "RS";
    public static final String OTH_RENTAL_INCM = "RI";
    public static final String OTH_TANF_PYMT = "TN";
    public static final String OTH_UNEMPL = "UC";
    public static final String OTH_WORKER_STUDY = "WS";
    public static final String OTH_WORKER_COMP = "WO";
    public static final String RMB_APPLICATION = "A";

    public static final String RMC_CAT_HH_SUMMARY_PRFL = "HS";
    //category types for RMB- HouseHoldSummary
    public static final String PERSONAL_INFO = "PI";
    public static final String CITIZEN_INFO = "CI";
    public static final String IMMIGRATION_INFO = "II";
    public static final String RELATIONSHIP_DETAILS = "RD";
    public static final String PREGNANCY_DETAILS = "PD";
    public static final String DISABILITY_DETAILS = "DB";
    public static final String NON_PARENT = "NP";
    public static final String ABS_PARENT = "AB";
    public static final String CP_APP_IN_LST_HLTH_INS_COLLECTION = "CP_APP_IN_LST_HLTH_INS_Collection";
    public static final String LOST_HEALTH_INS = "LH";
    public static final String LOST_HEALTH_INSURANCE = "LH";
    public static final String CP_APP_IN_TAX_INFORMATION_COLLECTION = "CP_APP_IN_TAX_INFORMATION_Collection";
    public static final String NOTIFICATIONMETHOD = "NOTIF_METHOD_TYPE";
    public static final String USMAIL = "USM";
    public static final String EMAIL_NOTIFICATION = "EML";
    public static final String USMAIL_EMAIL = "UME";
    public static final String NOTIFICATION_UPDATE_RESULT = "SUCCESS";
    public static final String SSASUCCESS = "HS000000";
    public static final String TAX_CLAIM_DEPENDENT = "TC";

    public static final String WORK_NUMBER_HISTORY_WEBSERVICE_URL = "WorkNumberHistoryWebservice";
    public static final String TRNUID = "1234567890";
    public static final String TRNPURPOSE = "PPGOVRNM";
    // NextGen  NG-6481 Phase 3 updates to ACA Streamline changes � start
    public static final String INCOME_TAX_DEDUCTION_CHANGE = "JC";
    public static final String ADD_INCOME_TAX_DEDUCTION = "JA";
    public static final String CP_APP_IN_INCOME_TAX_DED_COLLECTION = "CP_APP_IN_INCOME_TAX_DED_Collection";
    public static final String INCOME_TAX_DEDUCTION_CHANGE_RMB = "XH";
    public static final String ADD_INCOME_TAX_DEDUCTION_RMB = "AT";

    // NextGen  NG-6481 Phase 3 updates to ACA Streamline changes � end

    //NextGen  NG-6481 Phase 3 updates to ACA Streamline changes - start
    public static final String INCOME_TAX_DEDUCTION_CHG_QUESTION = "TAX_DEDUCT_STAT_IND";
    //NextGen  NG-6481 Phase 3 updates to ACA Streamline changes - start
    // ARXGQ END

    // NextGen  NG-6481 Phase 3 updates to ACA Streamline changes - start
    public static final String INCOME_TAX_DEDUCTION = "XH";
    // NextGen  NG-6481 Phase 3 updates to ACA Streamline changes - END
    // NextGen  NG-6481 Phase 3 updates to ACA Streamline changes - start
    public static final String INCOME_TAX_DEDUCT = "XH";

    // NextGen  NG-6481 Phase 3 updates to ACA Streamline changes - END

    //NextGen  NG-6481 Phase 3 updates to ACA Streamline changes : Start
    public static final String BEFORE_TAX_DEDUCTIONS = "BT";
    public static final String SRC_APP_IND = "SRC_APP_IND";
    public static final String BTD_TYPE = "BTD_TYPE";
    public static final String BEFORE_TAX_DEDUCTION = "BEFORE_TAX_DEDUCTION";
    public static final String INCOME_TAX = "INCOME_TAX_DEDUCTION";
    public static final String RMB_BEFORE_TAX_DEDUCTIONS_LISTVIEW = "RMB_BEFORE_TAX_DEDUCTIONS_LISTVIEW";
    public static final String RMB_BEFORE_TAX_DEDUCTION_LISTVIEW = "RMB_BEFORE_TAX_DEDUCTION_LISTVIEW";
    public static final String RMB_INCOME_TAX_DEDUCTION_LISTVIEW = "RMB_INCOME_TAX_DEDUCTION_LISTVIEW";
    public static final String BEFORE_TAX_DEDU = "BEFORE_TAX_DEDU";
    public static final String INCOME_TAX_DEDU = "INCOME_TAX_DEDU";
    public static final String RMB_INCOMETAX_DEDUCT_INDVSELECTION_LISTVIEW = "RMB_INCOMETAX_DEDUCT_INDVSELECTION_LISTVIEW";
    public static final String CP_APP_IN_BEF_TAX_DED_COLLECTION = "CP_APP_IN_BEF_TAX_DED_Collection";
    public static final String ARBTD = "ARBTD";
    public static final String ARITD = "ARITD";
    public static final String ARBBQ = "ARBBQ";
    public static final String ARBBS = "ARBBS";
    public static final String BEFTAXDEDUCTION_INDSEQBEAN = "BefTaxDeduction_IndSeqBean";
    public static final String INCTAXDEDUCTION_INDSEQBEAN = "IncTaxDeduction_IndSeqBean";
    public static final String BEFORE_TAX_DEDUCTION_CHANGE = "BEFORE_TAX_DEDUCTION_CHANGE";
    public static final String BEFORE_TAX_DEDUCTION_NEW = "BEFORE_TAX_DEDUCTION_NEW";
    public static final String INC_TAX_DEDUCTION_CHANGE = "INC_TAX_DEDUCTION_CHANGE";
    public static final String INCOME_TAX_DEDUCTION_NEW = "INCOME_TAX_DEDUCTION_NEW";
    public static final String MSG_MEDICAL = "99247";
    public static final String MSG_DENTAL = "99248";
    public static final String MSG_VISION = "99249";
    public static final String MSG_FLEXIBLE = "99250";
    public static final String MSG_DEFERRED = "99251";
    public static final String MSG_PRE_TAX = "99252";
    public static final String MSG_OTHER = "99253";
    public static final String NEW_OR_MOD_BEF_TAX_DED_EXISTS = "NEW_OR_MOD_BEF_TAX_DED_EXISTS";
    public static final String NEW_OR_MOD_INCOME_TAX_DED_EXISTS = "NEW_OR_MOD_INCOME_TAX_DED_EXISTS";
    public static final String PEOPLE_9000 = "PEOPLE_9000";
    public static final String PEOPLE_9001 = "PEOPLE_9001";
    //NextGen  NG-6481 Phase 3 updates to ACA Streamline changes : End
    public static final String EMAIL_4_NOTIFICATION = "EMAIL_4_NOTIFICATION";

    public static final String SAVE_VERIFICATION_WEBSERVICE_URL = "SaveVerificationWebService";

    //relationship table values
    public static final String RT_RELATIONSHIP_TYPE_HUSBND = "HUS";
    public static final String RT_RELATIONSHIP_TYPE_WIFE = "WIF";
    public static final String RT_RELATIONSHIP_TYPE_SON = "SON";
    public static final String RT_RELATIONSHIP_TYPE_DTR = "DAU";
    public static final String RT_RELATIONSHIP_TYPE_MTR = "MTR";
    public static final String RT_RELATIONSHIP_TYPE_FTR = "FTR";
    public static final String RT_RELATIONSHIP_TYPE_STF = "STF";
    public static final String RT_RELATIONSHIP_TYPE_STM = "STM";
    public static final String RT_RELATIONSHIP_TYPE_AUN = "AUN";
    public static final String RT_RELATIONSHIP_TYPE_BIL = "BIL";
    public static final String RT_RELATIONSHIP_TYPE_DIL = "DIL";
    public static final String RT_RELATIONSHIP_TYPE_FCO = "FCO";
    public static final String RT_RELATIONSHIP_TYPE_FIL = "FIL";
    public static final String RT_RELATIONSHIP_TYPE_GGD = "GGD";
    public static final String RT_RELATIONSHIP_TYPE_BTR = "BTR";
    public static final String RT_RELATIONSHIP_TYPE_GRM = "GRM";
    public static final String RT_RELATIONSHIP_TYPE_GGM = "GGM";
    public static final String RT_RELATIONSHIP_TYPE_GRD = "GRD";
    public static final String RT_RELATIONSHIP_TYPE_GGF = "GGF";
    public static final String RT_RELATIONSHIP_TYPE_GGS = "GGS";
    public static final String RT_RELATIONSHIP_TYPE_HBR = "HBR";
    public static final String RT_RELATIONSHIP_TYPE_HSR = "HSR";
    public static final String RT_RELATIONSHIP_TYPE_NEP = "NEP";
    public static final String RT_RELATIONSHIP_TYPE_NIE = "NIE";
    public static final String RT_RELATIONSHIP_TYPE_NOT = "NOT";
    public static final String RT_RELATIONSHIP_TYPE_STR = "STR";
    public static final String RT_RELATIONSHIP_TYPE_SSR = "SSR";
    public static final String RT_RELATIONSHIP_TYPE_STS = "STS";
    public static final String RT_RELATIONSHIP_TYPE_UNC = "UNC";
    public static final String RT_RELATIONSHIP_TYPE_RT = "RT";
    public static final String RT_RELATIONSHIP_TYPE_LG = "LG";
    public static final String RT_RELATIONSHIP_TYPE_CMNB = "CMNB";
    public static final String RT_RELATIONSHIP_TYPE_GRF = "GRF";
    public static final String RT_RELATIONSHIP_TYPE_GSO = "GSO";
    public static final String RT_RELATIONSHIP_TYPE_STD = "STD";
    public static final String RT_RELATIONSHIP_TYPE_STB = "STB";
    public static final String RT_RELATIONSHIP_TYPE_MIL = "MIL";
    public static final String RT_RELATIONSHIP_TYPE_SIL = "SIL";
    public static final String RT_RELATIONSHIP_TYPE_NIW = "NIW";
    public static final String RT_RELATIONSHIP_TYPE_OQR = "OQR";
    public static final String RT_RELATIONSHIP_TYPE_SOL = "SOL";
    public static final String RT_RELATIONSHIP_TYPE_SBR = "SBR";

    public static final String RT_PAYFREQUENCY_WK = "WK";
    public static final String RT_PAYFREQUENCY_BI = "BI";
    public static final String RT_PAYFREQUENCY_SM = "SM";
    public static final String RT_PAYFREQUENCY_MO = "MO";
    public static final String RT_PAYFREQUENCY_DA = "DA";
    public static final String RT_PAYFREQUENCY_IR = "IR";
    public static final String RT_PAYFREQUENCY_QU = "QU";
    public static final String RT_PAYFREQUENCY_SA = "SA";
    public static final String RT_PAYFREQUENCY_AN = "AN";
    public static final String RT_PAYFREQUENCY_OT = "OT";

    public static final double DAILY_CONVERSION = 30.4166;
    public static final double WEEKLY_CONVERSION = 4.3333;
    public static final double BIWEEKLY_CONVERSION = 2.1666;
    public static final double SE_MNTHLY_CONVERSION = 2.0000;
    public static final double QUARTERLY_CONVERSION = 0.3333;
    public static final double SE_ANNUAL_CONVERSION = 0.1666;
    public static final double ANNUAL_CONVERSION = 0.0833;

    public static final String CPP_JASPER_FILE_NAME = "jasperFileName";
    public static final String CPP_DEST_FILE_NAME = "destinationFileName";
    public static final String BUTTON_EXPORT = "BUTTON_EXPORT";
    public static final String BUTTON_EXPORT_IMG = "/BUTTON_EXPORT_IMG.png";
    public static final String BUTTON_EXPORT_ALT = "15099";
    public static final String INQUIRY_PDF = "InquiryPDF.xml";
    public static final String INQUIRY_XML_SEQUENCE = "Inquiry_XML_Sequence";
    public static final String INQUIRY_NOTICE_REST_URL = "http://10.118.23.133:9080/rest/services/GA_IES_Print/processes/OnlineCorrespondencePreview";
    public static final String URL_START = "http://";
    public static final String URL_END = "</docPDF>";
    public static final String CHARACTER_ENCODING = "UTF-8";

    // Metadata elements for pdf generation
    public static final String INQUIRY_SEQUENCE = "Inquiry_Sequence";
    public static final String PDF_URL = "PDF_URL";
    public static final String INQUIRY_PDF_TEMPLATE_ID = "Inquiry";
    public static final String INQUIRY_PDF_RECIPIENT_ID = "280608";
    public static final String INQUIRY_PDF_RECIPIENT_ADD = "Atlanta, Georgia 30303";
    public static final String INQUIRY_PDF_JOB_NAME = "CO-N002-MLY";
    public static final String INQUIRY_PDF_MAIL_DATE = "2012-01-10";
    public static final String INQUIRY_PDF_CORR_NUM = "321880";
    public static final String INQUIRY_PDF_FORM_NO = "NCH002";
    public static final String INQUIRY_PDF_FROM_VERSION = "1";
    public static final String INQUIRY_PDF_FROM_TITLE = "Application Withdrawal";
    public static final String INQUIRY_PDF_ENVELOPE_ID = "";
    public static final String INQUIRY_PDF_CASE_NUM = "T11074350";

    public static final String CPP_OUTCOME_REPORT_FILE_NAME = "outcomeFileName";
    public static final String CPP_OUTCOME_DEST_FILE_NAME = "outcomedestFileName";
    public static final String DOC_UPLOAD_TRACK_NUM_KEY = "DOC_UPLOAD_TRACK_NUM";
    public static final String UPLOAD_FILE_UR_LOCATOR = "DIS_CHECKIN_UNIVERSAL";
    public static final String DIS_GETFILE_BYID = "DIS_GETFILE_BYID";
    public static final String ADD_HEALTHNIS = "AH";
    public static final String ADD_OTHR_HEALTH_INS = "AO";
    public static final String TANF_UPLOAD_FLDR_LOC = "TANF_UPLOAD_FLDR_LOC";
    public static final String TEMP_FILE_PATH_SHARED = "TEMP_FILE_PATH_SHARED";
    public static final String AIE_PDF_CARGO = "AIE_PDF_Cargo";
    public static final String AIE_PDF_TEMPLATE_ID = "CP0001";
    public static final String APP_PDF_XML_SEQUENCE = "App_PDF_XML_Sequence";
    public static final String APP_XML_PDF_TEMPLATE_ID = "FGGA0052";
    public static final String INQUIRY_NAME = "Inquiry_Name";
    public static final String RETRIEVE_NOTICES_URL = "RETRIEVE_NOTICES_URL";
    public static final String PENDING_VCL = "PENDING_VCL";
    public static final String TEMP_FILE_LOC_FOLDER = "CMB_DOC_UPLOAD_TEMP_PATH";
    public static final String CP_APP_IN_TAXDEPENDENTS_OH_COLLECTION = "CP_APP_IN_TAXDEPENDENTS_OH_Collection";
    public static final String CP_APP_IN_TAX_RETURN_COLLECTION = "CP_APP_IN_TAX_RETURN_Collection";
    public static final String CP_APP_IN_TAX_DEPENDENTS_COLLECTION = "CP_APP_IN_TAX_DEPENDENTS_Collection";
    public static final String SPOUSE_SEQ_NUM = "SPOUSE_SEQ_NUM";
    public static final String CREATE = "C";
    public static final String CREATEANDCHANGE = "YC";
    public static final String PRE_SEL_CASE_NUM = "PreSelctedCasNum";
    public static final String TAX_RETURN_CHANGE = "TR";
    public static final String TAX_RETURN_INFO = "TR";
    public static final String ADD_TAX_RETURN = "AT";
    public static final String TAX_DEPENDENT_CHANGE = "TD";
    public static final String TAX_DEPENDENT_INFO = "TD";
    public static final String ADD_TAX_DEPENDENT = "AD";
    public static final String AGE_16 = "AGE_16";

    public static final String[] TOA_ABD = new String[] { "A01", "A02", "L01", "L02", "PRTC", "Q01", "Q03", "Q05", "QI1", "S02", "S03", "S04", "S05",
            "S06", "SSI", "W01", "W02", "W03", "W04", "W05", "W06", "W07", "A03", "S95", "S99", "PRT"};
    public static final String[] TOA_CC = new String[] { "CC" };
    public static final String[] TOA_FM = new String[] { "180", "181", "182", "183", "D02", "EMA", "F11", "F12", "F13", "F15", "F40", "F41", "F42",
            "F99", "P06", "P10", "P14", "P15", "P99" };
    public static final String[] TOA_FS = new String[] { "DSAS", "EXFS", "SSNP", "TP09", "TRFS" };
    public static final String[] TOA_LI = new String[] { "LI" };
    public static final String[] TOA_MAGI = new String[] { "F01", "F07", "F09", "F22", "P01", "P11", "P12", "P13", "P02" };
    public static final String[] TOA_TANF = new String[] { "RCA", "TP01" };
    public static final String[] TOA_RMA = new String[] { "R01", "R02", "R03" };
    public static final String[] TOA_WIC = new String[] { "WBW", "WCH", "WIN", "WPN", "WPW","WIC" };
    public static final String[] BENEFIT_PL = new String[] { "L01", "W01" };
    public static final String[] BENEFIT_CS = new String[] { "W03", "W05", "W07", "W04" };
    public static final String[] BENEFIT_SD = new String[] { "S99", "F99", "P99"};
    public static final String SPOUSE_INDV_IDS = "SPOUSE_INDV_IDS";
    public static final String CP_APP_IN_TAX_RETURN_CARGO = "CP_APP_IN_TAX_RETURN_Cargo";

    //RTE codes
    public static final String FDSH_APPROVED = "FD";
    public static final String DOL_APPROVED = "DL";
    public static final String SUCCESS_MSG_CASE_ACC = "SUCCESS";
    public static final String FAILURE_MSG_CASE_ACC = "FAILURE";
    public static final String BREAKING_MSG_CASE_ACC = "BREAKING";

    //Notices Program Code
    public static final String NOTICES_BENEFIT_MA = "MA";
    public static final String NOTICES_BENEFIT_CC = "CC";
    public static final String NOTICES_BENEFIT_FS = "FS";
    public static final String NOTICES_BENEFIT_TF = "TF";
    public static final String NOTICES_BENEFIT_WC = "WC";
    public static final String NOTICES_BENEFIT_PC = "PC";
    public static final String NOTICES_BENEFIT_LI = "LI";
    public static final int ELIG_NOTICES_DIS_RANGE = 12;

    public static final String CONVICTION = "CV";
    public static final String AGENCY_ID = "AGENCY_ID";
    public static final String AROBS = "AROBS";

    // Pesron's Gender for PDF
    public static final String PERSON_GENDER_MALE = "Male";
    public static final String PERSON_GENDER_FEMALE = "Female";

    // Person's Race for PDF
    public static final String PERSON_RACE_WHITE = "White";
    public static final String PERSON_RACE_AI = "American Indian / Alaskan Native";
    public static final String PERSON_RACE_FILIPINO = "Filipino";
    public static final String PERSON_RACE_VIETNAMESE = "Vietnam";
    public static final String PERSON_RACE_GUAMANIAN = "Guamanian / Chamorro";
    public static final String PERSON_RACE_BLACK = "Black / African American";
    public static final String PERSON_RACE_ASIANINDIAN = "Asian Indian";
    public static final String PERSON_RACE_JAPANESE = "Japanese";
    public static final String PERSON_RACE_OTHERASIAN = "Other Asian";
    public static final String PERSON_RACE_SAMOAN = "Samoan";
    public static final String PERSON_RACE_CHINESE = "Chinese";
    public static final String PERSON_RACE_KOREAN = "Korean";
    public static final String PERSON_RACE_NATIVEHAWAIIAN = "Native Hawaiian";
    public static final String PERSON_RACE_PACIFICISLANDER = "Other Pacific Islander";
    public static final String PERSON_RACE_OTHER = "Other";

    // Disability Status for PDF
    public static final String DISABILITY_STATUS_BLIND = "Blind";
    public static final String DISABILITY_STATUS_MENTAL = "Mental";
    public static final String DISABILITY_STATUS_PHYSICAL = "Physical";

    public static final String AFB_SRC_APP_IND = "AB";

    // Resources Detail page PDF
    public static final String SOMEONE_OUTSIDE = "Someone outside of the home";

    // Applying on your behalf for PDF
    public static final String SELF = "Self";
    public static final String FRIEND = "Friend";
    public static final String FAMILY_MEMBER = "Family Member";
    public static final String STAFF_PERSON = "Staff Person or Agency Volunteer";
    public static final String AUTHORIZED_REP = "Authorized Representative";
    public static final String LEGAL_GUARDIAN = "Legal Guardian";
    public static final String POWER_ATTORNEY = "Power of Attorney";
    public static final String LONG_TERM_CARE_REP = "Long Term Care/ CCSP Representative";

    public static final String HOSPICE_CARE = "HC";
    public static final String NURSING_HOME = "NR";

    public static final String CASH_LIQUID_ASSET_TYPE = "CAS";
    public static final String FINANCIAL_LIQUID_ASSET_TYPE = "FA";

    //DEFECT 18942
    public static final String ANNUITY_LIQUID_ASSET_TYPE = "MQ";
    public static final String BONDS_LIQUID_ASSET_TYPE = "BD";
    public static final String CERTIFICATE_DEPOSIT_LIQUID_ASSET_TYPE = "PN";
    public static final String DIVIDEND_LIQUID_ASSET_TYPE = "DIV";
    public static final String PATIENTFUND_LIQUID_ASSET_TYPE = "PTF";
    public static final String PENSIONFUND_LIQUID_ASSET_TYPE = "PP";
    public static final String QUALIFIED_TUITION_LIQUID_ASSET_TYPE = "SP";
    public static final String STOCKS_LIQUID_ASSET_TYPE = "ST";
    public static final String TRUSTFUND_LIQUID_ASSET_TYPE = "TR";
    public static final String UNIFORM_GIFTS_LIQUID_ASSET_TYPE = "UNG";
    
    public static final String TRUE = "true";
    public static final String FALSE = "false";
    public static final String HOME_PLACE = "HP";
    public static final String CASE_FORGOT_SSN = "forgotSSN";
    public static final String CASE_FORGOT_CLIENTID = "forgotClientId";
    public static final String DEFAULT_SUFFIX_VALUE = "--";
    public static final List<String> VE_TYPE=new ArrayList<String>(Arrays.asList("VAAB","VAAP","VAC","VADL","VAEG","VAO","VAP","VAS","VAD1"));
    public static final List<String> UEI_TYPE1_INCOME=new ArrayList<String>(Arrays.asList("AS","AO","PF","BLB","CG","CSEB","DIV","ED","FP","3TGA","HAS","IGPI","MI","PN","RT","RS","SS","SSR","SI","3TMA","V1","V2","V3","VAAB","VAAP","VAC","VADL","VAEG","VAO","VAP","VAS","VAD1"));
    /*Id Proofing**/
    public static final String CHALLENGE_QUESTION_LIST = "challengeQuestionList";
    public static final String IDP_REQ = "IDP_REQ";
    
    public static final int BUFFER_SIZE = 4096;
    
    // Added for Utility Types to generate PDF
    public static final String ELECTRICITY = "Electricity";
    public static final String GARBAGE_TRASH = "Garbage/Trash";
    public static final String GAS = "Gas";
    public static final String OTHER_FUEL = "Other Fuel";
    public static final String SEWAGE = "Sewage";
    public static final String TELEPHONE = "Telephone";
    public static final String WATER = "Water";
    
    // Renewal of coverage for PDF
    public static final String ZERO_ONE = "01";
    public static final String ZERO_TWO = "02";
    public static final String ZERO_THREE = "03";
    public static final String ZERO_FOUR = "04";
    public static final String ZERO_FIVE = "05";
    public static final String REN_OF_COV = "RE";
    public static final String FIVE_YEARS = "5 years";
    public static final String FOUR_YEARS = "4 years";
    public static final String THREE_YEARS = "3 years";
    public static final String TWO_YEARS = "2 years";
    public static final String ONE_YEAR = "1 year";
    public static final String REN_OF_COV_RE = "Don�t use information from tax returns to renew my coverage.";
    
    public static final String IDP_RESP = "IDP_RESP";
    public static final String IDENTITY_PROOFING = "IDENTITY_PROOFING";
    public static final String ENABLE_IDPROOFING= "ENABLE_IDPROOFING";
    public static final String ENABLE_SSA_DOL= "ENABLE_SSA_DOL";
    
    /*doc upload*/
    public static final String WC_WORC_PART_HRS_RESP_COLLECTION = "WC_Worc_Part_Hrs_RespCollection";
    
    public static final String UPLOAD_COMPLETE = "Upload Complete";
    public static final String UPLOAD_PENDING = "Upload Pending";
    /*************************/
    public static final String WOMEN_INFANTS_CHILDREN = "Women, Infants and Children (WIC)";
    public static final String TEMPORARY_ASSISTANCE = "Temporary Assistance For Needy Families (TANF)";
    public static final String FOOD_STAMPS_SUPPLEMENTAL = "Food Stamps/Supplemental Nutrition Assistance Program (SNAP)";
    public static final String MEDICAL_ASSISTANCE = "Medical Assistance";
    public static final String CHILD_CARE_AND_PARENT_SERVICES = "Child Care and Parent Services (CAPS)";
    public static final String PROGRAM_FS = "FS";
    public static final String PROGRAM_FMA = "FMA";
    public static final String PROGRAM_TANF = "TANF";
    public static final String PROGRAM_CC = "CC";
    public static final String PROGRAM_WIC = "WIC";
    public static final String NUM_1 = "1";
    public static final String NUM_2 = "2";
    public static final String NUM_3 = "3";
    public static final String NUM_4 = "4";
    public static final String NUM_5 = "5";
    public static final String NUM_6 = "6";
    public static final String NUM_7 = "7";
    public static final String NUM_8 = "8";
    
    public static final String LKUP_GRP_FLD_ID_70 = "70";
    public static final String LKUP_GRP_FLD_ID_71 = "71";
    public static final String LKUP_GRP_FLD_ID_72 = "72";
    public static final String LKUP_GRP_FLD_ID_75 = "75";
    public static final String LKUP_GRP_FLD_ID_76 = "76";
    public static final String LKUP_GRP_FLD_ID_1250 = "1250";
    public static final String LKUP_GRP_FLD_ID_9917 = "9917";
    public static final String LKUP_GRP_FLD_ID_9930 = "9930";
    public static final String LKUP_GRP_FLD_ID_9900 = "9900";
    public static final String LKUP_GRP_FLD_ID_88 = "88";
    public static final String LKUP_GRP_FLD_ID_86 = "86";
    public static final String LKUP_GRP_FLD_ID_285 = "285";
    public static final String LKUP_GRP_FLD_ID_9927 = "9927";
    public static final String LKUP_GRP_FLD_ID_1252 = "1252";
    public static final String LKUP_GRP_FLD_ID_9935 = "9935";
    public static final String LKUP_GRP_FLD_ID_9928 = "9928";
    public static final String LKUP_GRP_FLD_ID_90 = "90";
    public static final String LKUP_GRP_FLD_ID_9934 = "9934";
    public static final String LKUP_GRP_FLD_ID_9931 = "9931";
    public static final String LKUP_GRP_FLD_ID_220 = "220";
    public static final String LKUP_GRP_FLD_ID_219 = "219";
    public static final String LKUP_GRP_FLD_ID_218 = "218";
    public static final String LKUP_GRP_FLD_ID_217 = "217";
    public static final String LKUP_GRP_FLD_ID_9901 = "9901";
    public static final String LKUP_GRP_FLD_ID_9925 = "9925";
    public static final String LKUP_GRP_FLD_ID_9926 = "9926";
    public static final String LKUP_GRP_FLD_ID_8903 = "8903";
    public static final String LKUP_GRP_FLD_ID_9957 = "9957";
    public static final String LKUP_GRP_FLD_ID_9914 = "9914";
    public static final String LKUP_GRP_FLD_ID_9915 = "9915";
    public static final String LKUP_GRP_FLD_ID_9902 = "9902";
    public static final String LKUP_GRP_FLD_ID_9912 = "9912";
    public static final String LKUP_GRP_FLD_ID_9959 = "9959";
    public static final String LKUP_GRP_FLD_ID_10218 = "10218";
    
    public static final String PROP_BOUNCED_EMAIL_LIST_URL="BouncedEmailList";
    public static final String PROP_OPT_IN_EMAIL_URL="OptInEmailConfirmation";
    /*Notices*/
    public static final String NOTICES_LIST = "noticesList";
    public static final String MAIL_NOTICES_LIST = "mailNoticesList";
    public static final String EMAIL_NOTICES_LIST = "emailNoticesList";
    
    public static final String CMB_FETCH_DIS_ID = "CMB_FETCH_DIS_ID";
    public static final List<Long> CHECK_DAY_VALUES=new ArrayList<Long>(Arrays.asList(Long.valueOf(1),Long.valueOf(2),Long.valueOf(3),Long.valueOf(4),Long.valueOf(5),Long.valueOf(10)));
    
    public static final String SEL = "SEL";
    public static final String AC = "AC";
    
    public static final String FS_TEXT = "Food Stamp (SNAP)";
    public static final String MA_TEXT = "Medical Assistance";
    public static final String TF_TEXT = "TANF";
    
    public static final String EMPI_WEBSERVICE_URL_KEY = "EMPIWebService";
    public static final String SOURCE_SYSTEM = "IES";
    public static final String CMB_BRIDGE_URL_KEY ="CMBBridgesWebService";
    
    public static final String EMPL_HLTH_INS = "EHI";
    public static final String CONVERSION_DATE = "CONVERSION_DATE";
    public static final String SNAP_ELIG_PERIOD="SNAP_ELIG_PERIOD";
    public static final String TANF_ELIG_PERIOD="TANF_ELIG_PERIOD";
    public static final String MEDICAID_ELIG_PERIOD="MEDICAID_ELIG_PERIOD";
    public static final String CHILDCARE_ELIG_PERIOD="CHILDCARE_ELIG_PERIOD";
    public static final String WIC_ELIG_PERIOD="WIC_ELIG_PERIOD";
    
    public static final String DOC_SEQ = "DOC_SEQ";
    public static final String TASK_GEN_SERVICE = "TASK_GEN_SERVICE";
    public static final String IESUC = "IESUC";
    
    /*RTE TEST*/
    public static final String RTE_TEST_FLAG = "RTE_TEST_FLAG";
    public static final String IDPROOFING_TEST_SSN = "IDPROOFING_TEST_SSN";
    public static final String SSA_TEST_SSN = "SSA_TEST_SSN";
    public static final String DOL_TEST_SSN = "DOL_TEST_SSN";
    public static final String DOL_USERID = "DOL_USERID";
    public static final String DOL_AGENCYCODE = "DOL_AGENCYCODE";
    public static final String DOL_NUMBER_OF_QUARTERS = "DOL_NUMBER_OF_QUARTERS";
    public static final String IDPROOFING_EAI="IDPROOFING_EAI";
    public static final String IDPROOFING_VENDOR_NUMBER="IDPROOFING_VENDOR_NUMBER";
    public static final String OPA_SERVICE_TEST_FLAG = "OPA_SERVICE_TEST_FLAG";
    public static final String DRUG_FELN_RESP = "DRUG_FELN_RESP";
    
    public static final String CPP_FLOW = "CPP_FLOW";
    public static final String action = "action";
    public static final String PRINTNOTICE = "PRINTNOTICE";
    
    public static final String CPP_RES = "CPP_RES";
    public static final String CPP_DOCUPLD_FLOW = "CPP_DOCUPLD_FLOW";
    public static final String CPP_DOCUPLD_SEARCH_ACTION = "CPP_DOCUPLD_SEARCH_ACTION";
    public static final String CPP_DOCUPLD_APPNUM = "CPP_DOCUPLD_APPNUM";
    
    
    
	public static final String EMPL_SEQ_NUM = "EMPL_SEQ_NUM";
	public static final String SHLT_TYP = "SHLT_TYP";
	public static final String PLCY_SEQ_NUM = "PLCY_SEQ_NUM";
	public static final String POLICY_SEQ_NUM = "POLICY_SEQ_NUM";
	public static final String AP_SEQ_NUM ="AP_SEQ_NUM";
	public static final String ASSET_SEQ_NUM ="ASSET_SEQ_NUM";
	public static final String MEDICAL_SEQ_NUM = "MEDICAL_SEQ_NUM";
	public static final String EXPENSE_SEQ_NUM = "EXPENSE_SEQ_NUM";
	public static final String CPP_YES = "Yes";
	
	public static final char[] specialCharsForAddress = { '-', '\'', '.', '#', '/', ',' , '&', ' '};
	
	
	public static final String CNVCT_TSB = "TSB";
	public static final String CNVCT_FRI = "FRI";
	public static final String CNVCT_TRA = "TRA";
	public static final String CNVCT_PDS = "PDS";
	public static final String CNVCT_SFE = "SFE";
	public static final String CNVCT_UBU = "UBU";
	public static final String CNVCT_VQJ = "VQJ";
	public static final String CNVCT_DFT = "DFT";
	
	public static final String EN = "EN";
	public static final String ES = "ES";
	public static final String en = "en";
	public static final String es = "es";
	public static final String WIC_CLINIC_INFO = "WIC_CLINIC_INFO";
	public static final String WIC_CLNC_NAME = "WIC_CLNC_NAME"; 
	public static final String PGM_DPLY_MAP = "PGM_DPLY_MAP";
	public static final String SSNAPINTAKE_CONDTION ="SI,SSD,RR,PEN,SSR,VAP,DIN, VAAB,VAAP,VAC,VAD1,VADL,VAEG,VAO,VAP,VAS";
	
	public static final String PENDING_VERIFICATION_RESPONSE_EN = "PENDING_VERIFICATION_RESPONSE_EN";
	public static final String PENDING_VERIFICATION_RESPONSE_ES = "PENDING_VERIFICATION_RESPONSE_ES";

	public static final String ABS_PAR_NOT_REQUIRED_INDICATOR="0";
	public static final String ABS_PAR_REQUIRED_INDICATOR="2";
	
	// Email Verification Constants
	public static final String EML_VERIF_CAMPAIGNID = "EML_VERIF_CAMPAIGNID";
	public static final String EML_VERIF_CAMPAIGNID_SPANISH = "EML_VERIF_CAMPAIGNID_SPANISH";
	public static final String EML_VERIF_BODYTYPE = "HTML";
	public static final String EMAIL_VERIF_PERSONALIZATION_TAGNAME = "VERIFICATION_CODE";
	
	// Case link limit flag
	public static final String ENBL_CASE_LINK_LIMIT = "ENBL_CASE_LINK_LIMIT";
	
	// Nursing Home End Reason Code
	public static final String NURSING_HOME_DECEASED = "DE";
	public static final String ASCII = "[^\\p{ASCII}]";
	//GA state code
		public static final String GA_STATE_CODE = "GA";
	public static final String PCK_PREMIUM_WS = "PCK_PREMIUM_WS";
	public static final String TPL_INSCARD_SEARCH_WS = "TPL_INSCARD_SEARCH_WS";
	public static final String ABOVR_ICON_CHECK = "ABOVR_ICON_CHECK";
	public static final String ABOVR_ICON_CHECK_IMG = "/icon_check.gif";	 
	public static final String ABOVR_ICON_CHECK_ALT = "";
	
	public static final String SNAP_PROCESS_FLOW = "SNAP_PROCESS_FLOW";
	public static final String SNAP_PROCESS_FLOW_IMG = "/gateway/SNAP.jpg";	 
	public static final String SNAP_PROCESS_FLOW_ALT = "820101014";
	
	public static final String SNAP_PROCESS_FLOW_ES = "SNAP_PROCESS_FLOW";
	public static final String SNAP_PROCESS_FLOW_ES_IMG = "/gateway/SNAP_ES.jpg";	 
	public static final String SNAP_PROCESS_FLOW_ES_ALT = "820101014";
	
	public static final String ABPPS_ICON_CHECK = "ABPPS_ICON_CHECK";
	public static final String ABPPS_ICON_CHECK_IMG = "/icon_check.gif";	 
	public static final String ABPPS_ICON_CHECK_ALT = "";
	
	public static final String PRINTTPLUPLOADDOC ="PRINTTPLUPLOADDOC";
	public static final String NOT_AVAIL_RESPONSE_CODE="010";
	public static final String WIC_CLNC_INFO_CHG = "WIC_CLNC_INFO_CHG";
	public static final String CC_PRESCREEN_MAP = "CC_PRESCREEN_MAP";
	public static final String CC_PRESCREEN_RESULTS = "CC_PRESCREEN_RESULTS";
	public static final String PASS = "PASS";
	public static final String FAIL = "FAIL";
	
	public static final String FULL_MEDICAID_CPP = "FULL_MEDICAID";
	public static final String CC_CANCEL_INDV = "cancelIndv";
	public static final String CP_ONLINE = "CP_ONLINE";
	public static final String CP_BATCH = "CP_BATCH";
	public static final String APPLICATION_ONE = "APP1";
	public static final String APPLICATION_TWO = "APP2";
	public static final String APPLICATION_THREE = "APP3";
	public static final String WIC_DSCLR_SW = "WIC_DSCLR_SW";
    public static final String DOL_OFC_CD = "DOL_OFC_CD";
	public static final String DEFAULT_ENGLISH_VALIDATION_MESSAGE = "A validation error has prevented the data from being processed.";
    public static final String DEFAULT_SPANISH_VALIDATION_MESSAGE = "Un error de validaci�n ha impedido que los datos se procesen.";
	 
    
	private AppConstants() {        
    }
}