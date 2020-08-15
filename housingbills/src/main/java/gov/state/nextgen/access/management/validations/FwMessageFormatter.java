/*
 * 
 */
package gov.state.nextgen.access.management.validations;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

import gov.state.nextgen.access.driver.FwPageManager;
import gov.state.nextgen.access.driver.IPage;
import gov.state.nextgen.access.exceptions.FwException;

/**
 * @author addepup
 *
 *         To change the template for this generated type comment go to
 *         Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class FwMessageFormatter {

	private static final String PARSER = "~";

	/**
	 * Performs substitution of the given array of strings into a message string
	 * in place of "~".
	 *
	 * @param message
	 *            A String which needs to have substitution performed.
	 * @param substitute
	 *            A String[] of all the strings that need to be inserted in
	 *            place of PARSER
	 * @return A message with the substituted strings.
	 */
	public static String getFormattedMessage(String message, final String[] substitute) {

		for (int i = 0; i < substitute.length; i++) {
			if (substitute[i] != null) {
				message = message.replaceFirst(PARSER, substitute[i]);
			}
		}
		return message;
	}

	/**
	 * Performs substitution of the given array of substitute strings into a
	 * given message string in place of "~". <br>
	 * Prior to performing substitution, if there are '$' and '\' characters in
	 * a substitute, then escaped characters are prepended.
	 *
	 * @param message
	 *            A String which needs to have substitution performed.
	 * @param substitute
	 *            A String[] of all the strings that need to be inserted in
	 *            place of PARSER
	 * @return A message with the substituted strings.
	 */
	public static String getFormattedMessageWithSymbols(String message, final String[] substitute) {
		for (int i = 0; i < substitute.length; i++) {
			substitute[i] = createStringWithEscapeChars(substitute[i]);
			message = message.replaceFirst(PARSER, substitute[i]);
		}

		return message;
	}

	/*
	 * Identifies whether given string contains '$' or '\' characters. If it
	 * encounters these characters then they are escaped with "\\".
	 *
	 * @param message A string which contains special symbols
	 *
	 * @return A String with escaped characters
	 */
	private static String createStringWithEscapeChars(final String message) {
		final StringBuilder result = new StringBuilder();
		final StringCharacterIterator iterator = new StringCharacterIterator(message);

		char character = iterator.current();
		while (character != CharacterIterator.DONE) {
			if (character == '$') {
				result.append("\\$");
			} else if (character == '\\') {
				result.append("\\\\");
			} else {
				result.append(character);
			}

			character = iterator.next();
		}

		return result.toString();
	}

	/**
	 *
	 * @param textID
	 * @param language
	 * @return
	 */
	public static String getCachedText(final int textID, final String language) {
		String text = "";
		final IPage page = FwPageManager.createInstance();
		try {
			text = page.getDisplayText(textID, language);
		} catch (final FwException fe) {
			return text;
		}
		return text;
	}
	
	public static String getAnnouncements(final String language){
		final IPage page = FwPageManager.createInstance();
		return page.getAnnouncements(language);
	}
}
