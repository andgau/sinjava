package es.sinjava.log4nerds.formatters;

import static es.sinjava.log4nerds.utils.Log4nColors.ANSI_RESET;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class ConfiguratedFormatter extends DefaultFormatter implements IFormatter {

	private Map<Level, String> configuration;

	public ConfiguratedFormatter(Map<Level, String> configurationInput, boolean local) {
		configuration = configurationInput;
	}

	@Override
	public String format(LogRecord record) {

		StringBuilder sb = new StringBuilder();

		String item = configuration.get(record.getLevel());

		sb.append(item);

		bodyLogRecord(record, sb);

		sb.append(ANSI_RESET).append(" \n");

		return sb.toString();
	}

}
