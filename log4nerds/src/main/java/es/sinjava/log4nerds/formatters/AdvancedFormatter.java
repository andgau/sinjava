
package es.sinjava.log4nerds.formatters;

import java.time.LocalDateTime;
import java.util.logging.LogRecord;

public class AdvancedFormatter extends DefaultFormatter implements IFormatter {

	public AdvancedFormatter(boolean local) {
		setLocalized(local);
	}

	private void bodyRecord(LogRecord record, StringBuilder sb) {

		String hora = dtf.format(LocalDateTime.now());

		String nivel = getLocalizedLevel(record);

		sb.append(record.getSequenceNumber()).append(" | ");

		sb.append(nivel).append(" | ").append(hora).append(" | ");

		sb.append(record.getSourceClassName()).append(" | ");

		sb.append(record.getSourceMethodName()).append(" | ");

		sb.append(record.getMessage());
	}

	@Override
	public String format(LogRecord record) {

		StringBuilder sb = new StringBuilder();

		bodyRecord(record, sb);

		sb.append(record.getMessage()).append("\n");

		return sb.toString();
	}

}
