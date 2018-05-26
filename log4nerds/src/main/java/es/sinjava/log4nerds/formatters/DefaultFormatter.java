package es.sinjava.log4nerds.formatters;

import static es.sinjava.log4nerds.utils.Log4nColors.ANSI_BLUE;
import static es.sinjava.log4nerds.utils.Log4nColors.ANSI_RED;
import static es.sinjava.log4nerds.utils.Log4nColors.ANSI_RESET;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class DefaultFormatter extends Formatter {

	protected DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy hh:mm:ss");

	// Por defecto no localizado
	protected boolean localized = false;

	@Override
	public String format(LogRecord record) {
		String hora = dtf.format(LocalDateTime.now());

		String nivel = nivelFormater(record, false);

		StringBuilder sb = new StringBuilder();

		// Barca flavour

		if (record.getLevel().equals(Level.SEVERE)) {
			sb.append(ANSI_RED);
		} else {
			sb.append(ANSI_BLUE);
		}

		sb.append(nivel).append(" | ").append(hora).append(" | ");

		sb.append(record.getSourceClassName()).append(" | ");

		sb.append(record.getSourceMethodName()).append(" | ");

		sb.append(record.getMessage()).append(ANSI_RESET).append(" \n");

		return sb.toString();
	}

	protected String nivelFormater(LogRecord record, boolean isLocalized) {
		String level = isLocalized ? record.getLevel().getLocalizedName() : record.getLevel().getName();

		level = (level.length() < 8) ? level : level.substring(0, 7);

		return String.format("%8s", level);
	}

	public boolean isLocalized() {
		return localized;
	}

	public void setLocalized(boolean localized) {
		this.localized = localized;
	}

}
