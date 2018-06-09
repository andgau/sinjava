package es.sinjava.log4nerds.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.LogRecord;

public class MatcherField {

	private static MatcherField matcherField;

	public static MatcherField getInstance(boolean locale, DateTimeFormatter dtf) {

		if (matcherField == null) {

			matcherField = new MatcherField(locale, dtf);

		}
		return matcherField;
	}

	private DateTimeFormatter dtf;

	private boolean localized;

	public MatcherField(boolean locale, DateTimeFormatter dtf2) {
		localized = locale;
		dtf = dtf2;
	}

	public String getValue(FieldEnum field, LogRecord record) {
		String value = "";
		if (field.equals(FieldEnum.FSEQ)) {
			value = Long.toString(record.getSequenceNumber());

		} else if (field.equals(FieldEnum.FLEVEL) && localized) {
			value = record.getLevel().getLocalizedName();

		} else if (field.equals(FieldEnum.FLEVEL) && !localized) {
			value = record.getLevel().getName();

		} else if (field.equals(FieldEnum.FCLASS)) {
			value = record.getSourceClassName();

		} else if (field.equals(FieldEnum.FMETHOD)) {
			value = record.getSourceMethodName();

		} else if (field.equals(FieldEnum.FTIME)) {
			value = dtf.format(LocalDateTime.now());
		}
		return value;
	}

}
