
package es.sinjava.log4nerds.formatters;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.LogRecord;

public interface IFormatter {

	// Constantes de uso común
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy hh:mm:ss");

	// Metodos por defecto
	default void bodyLogRecord(LogRecord record, StringBuilder sb) {
		String hora = dtf.format(LocalDateTime.now());

		String nivel = getLocalizedLevel(record);

		sb.append(record.getSequenceNumber()).append(" | ");

		sb.append(nivel).append(" | ").append(hora).append(" | ");

		sb.append(record.getSourceClassName()).append(" | ");

		sb.append(record.getSourceMethodName()).append(" | ");

		sb.append(record.getMessage());
	}

	// Interfaz comun
	String format(LogRecord record);

	default String getLocalizedLevel(LogRecord record) {
		return nivelFormater(record, isLocalized());
	}

	boolean isLocalized();

	default String nivelFormater(LogRecord record, boolean isLocalized) {
		String level = isLocalized ? record.getLevel().getLocalizedName() : record.getLevel().getName();
		level = (level.length() < 8) ? level : level.substring(0, 7);
		return String.format("%8s", level);
	}

	void setLocalized(boolean local);

}