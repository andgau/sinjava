package es.sinjava.log4nerds.formatters;

import java.time.LocalDateTime;
import java.util.logging.LogRecord;

public class SimpleFormatter extends DefaultFormatter {

	public SimpleFormatter(boolean local) {
		this.setLocalized(local);
	}

	@Override
	public String format(LogRecord record) {
		String hora = dtf.format(LocalDateTime.now());

		String nivel = nivelFormater(record, this.isLocalized());

		StringBuilder sb = new StringBuilder();

		sb.append(nivel).append(" | ").append(hora).append(" | ");

		sb.append(record.getSourceClassName()).append(" | ");

		sb.append(record.getSourceMethodName()).append(" | ");

		sb.append(record.getMessage()).append("\n");

		return sb.toString();
	}

}
