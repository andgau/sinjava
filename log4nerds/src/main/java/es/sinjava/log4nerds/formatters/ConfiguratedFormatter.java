package es.sinjava.log4nerds.formatters;

import static es.sinjava.log4nerds.utils.Log4nColors.ANSI_RESET;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class ConfiguratedFormatter extends DefaultFormatter {

	private Map<Level, String> configuration;

	private boolean isLocalized = false;

	public ConfiguratedFormatter(Map<Level, String> configurationInput, boolean local) {
		configuration = configurationInput;
		isLocalized = local;
	}

	@Override
	public String format(LogRecord record) {
		String hora = dtf.format(LocalDateTime.now());

		String nivel = getLocalizedLevel(record);

		StringBuilder sb = new StringBuilder();

		String item = configuration.get(record.getLevel());

		sb.append(item);

		// traza
		sb.append(nivel).append(" | ").append(hora).append(" | ");

		sb.append(record.getSourceClassName()).append(" | ");

		sb.append(record.getSourceMethodName()).append(" | ");

		sb.append(record.getMessage()).append(ANSI_RESET).append(" \n");

		return sb.toString();
	}

	private String getLocalizedLevel(LogRecord record) {
		return nivelFormater(record, isLocalized);
	}

}
