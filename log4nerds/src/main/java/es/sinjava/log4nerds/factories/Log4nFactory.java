package es.sinjava.log4nerds.factories;

import static es.sinjava.log4nerds.utils.Log4nColors.ANSI_BLUE;
import static es.sinjava.log4nerds.utils.Log4nColors.ANSI_GREEN;
import static es.sinjava.log4nerds.utils.Log4nColors.ANSI_PURPLE;
import static es.sinjava.log4nerds.utils.Log4nColors.ANSI_RED;
import static es.sinjava.log4nerds.utils.Log4nColors.ANSI_YELLOW;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import es.sinjava.log4nerds.utils.Log4nConfigurator;

public class Log4nFactory {

	private static Logger logger;

	public static Logger getInstance(Log4nConfigurator log4nConfigurator) {
		if (logger == null) {
			logger = Logger.getAnonymousLogger();
			ConsoleHandler ch = new ConsoleHandler();
			ch.setLevel(Level.ALL);
			Formatter newFormatter;
			if (log4nConfigurator != null) {
				newFormatter = formaterFromConfigurator(log4nConfigurator);
			} else {
				newFormatter = defaultFormater();
			}
			ch.setFormatter(newFormatter);
			logger.addHandler(ch);
			logger.setUseParentHandlers(false);
			logger.setLevel(Level.ALL);
		}
		return logger;
	}

	private static Formatter formaterFromConfigurator(Log4nConfigurator log4nConfigurator) {
		Formatter newFormatter = new Formatter() {

			@Override
			public String format(LogRecord record) {

				String mensaje = record.getMessage();

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy hh:mm:ss");

				String hora = dtf.format(LocalDateTime.now());

				String nivel = String.format("%8s", record.getLevel().getName());

				StringBuilder sb = new StringBuilder();

				// ahora queremos añadir algo de color :-)

				// for (Entry<Level, String>
				// item:log4nConfigurator.getConfiguration().entrySet()) {
				//
				// }
				Map<Level, String> mapping = log4nConfigurator.getConfiguration();

				String item = mapping.get(record.getLevel());

				sb.append(item);

				// fin de la inserción de color
				sb.append(nivel).append(" | ");

				sb.append(hora).append(" | ");

				// la añadimos la clase
				sb.append(record.getSourceClassName()).append(" | ");

				// la añadimos el método
				sb.append(record.getSourceMethodName()).append(" | ");

				// añado un salto de linea al final
				sb.append(mensaje).append("\n");

				return sb.toString();
			}
		};
		// Ahora hay que meterle un formatter al ch
		return newFormatter;
	}

	private static Formatter defaultFormater() {
		Formatter newFormatter = new Formatter() {

			@Override
			public String format(LogRecord record) {

				String mensaje = record.getMessage();

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy hh:mm:ss");

				String hora = dtf.format(LocalDateTime.now());

				String nivel = String.format("%8s", record.getLevel().getName());

				StringBuilder sb = new StringBuilder();

				// ahora queremos añadir algo de color :-)

				if (record.getLevel().equals(Level.FINE)) {
					sb.append(ANSI_BLUE);
				} else if (record.getLevel().equals(Level.INFO)) {
					sb.append(ANSI_PURPLE);
				} else if (record.getLevel().equals(Level.SEVERE)) {
					sb.append(ANSI_RED);
				} else if (record.getLevel().equals(Level.CONFIG)) {
					sb.append(ANSI_GREEN);
				} else {
					sb.append(ANSI_YELLOW);
				}
				// fin de la inserción de color
				sb.append(nivel).append(" | ");

				sb.append(hora).append(" | ");

				// la añadimos la clase
				sb.append(record.getSourceClassName()).append(" | ");

				// la añadimos el método
				sb.append(record.getSourceMethodName()).append(" | ");

				// añado un salto de linea al final
				sb.append(mensaje).append("\n");

				return sb.toString();
			}
		};
		// Ahora hay que meterle un formatter al ch
		return newFormatter;
	}

	public static Logger getInstance(Map<Level, String> rainbow) {
		// TODO Auto-generated method stub
		return null;
	}

}
