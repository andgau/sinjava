package es.sinjava.log4nerds.formatters;

import static es.sinjava.log4nerds.utils.Log4nColors.ANSI_BLUE;
import static es.sinjava.log4nerds.utils.Log4nColors.ANSI_RED;
import static es.sinjava.log4nerds.utils.Log4nColors.ANSI_RESET;

import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class DefaultFormatter extends Formatter implements IFormatter {

	private boolean localized = false;

	@Override
	public String format(LogRecord record) {

		StringBuilder sb = new StringBuilder();

		// Barca flavour

		if (record.getLevel().equals(Level.SEVERE)) {
			sb.append(ANSI_RED);
		} else {
			sb.append(ANSI_BLUE);
		}

		bodyLogRecord(record, sb);

		sb.append(record.getMessage()).append(ANSI_RESET).append(" \n");

		return sb.toString();
	}

	@Override
	public boolean isLocalized() {
		return localized;
	}

	@Override
	public void setLocalized(boolean local) {
		localized = local;

	}

}
