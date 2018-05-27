package es.sinjava.log4nerds.formatters;

import java.util.logging.LogRecord;

public class SimpleFormatter extends DefaultFormatter implements IFormatter {

	public SimpleFormatter(boolean local) {
		setLocalized(local);
	}

	@Override
	public String format(LogRecord record) {

		StringBuilder sb = new StringBuilder();

		bodyLogRecord(record, sb);

		sb.append(record.getMessage()).append("\n");

		return sb.toString();
	}

}
