package es.sinjava.log4nerds.factories;

import static es.sinjava.log4nerds.utils.Log4nColors.ANSI_BLUE;
import static es.sinjava.log4nerds.utils.Log4nColors.ANSI_GREEN;
import static es.sinjava.log4nerds.utils.Log4nColors.ANSI_PURPLE;
import static es.sinjava.log4nerds.utils.Log4nColors.ANSI_RED;
import static es.sinjava.log4nerds.utils.Log4nColors.ANSI_YELLOW;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import es.sinjava.log4nerds.utils.Log4nConfigurator;

public class Log4nFactory {

	private static Logger logger;

	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy hh:mm:ss");

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

	public static Logger getFileInstance(String filename) {
		if (logger == null) {
			logger = Logger.getAnonymousLogger();
			try {
				FileHandler fileHandler = new FileHandler(filename, true);
				fileHandler.setLevel(Level.ALL);
				Formatter newFormatter = simpleFormater();
				fileHandler.setFormatter(newFormatter);
				logger.addHandler(fileHandler);
			} catch (SecurityException | IOException e) {
				logger.severe(e.getMessage());
			}

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

				String hora = dtf.format(LocalDateTime.now());

				String nivel = getLocalizedLevel(log4nConfigurator, record);

				StringBuilder sb = new StringBuilder();

				// ahora queremos añadir algo de color :-)

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

				String hora = dtf.format(LocalDateTime.now());

				String nivel =nivelFormater(record,false);

				StringBuilder sb = new StringBuilder();

				if (record.getLevel().equals(Level.SEVERE)) {
					sb.append(ANSI_RED);
				} else {
					sb.append(ANSI_BLUE);
				}

				sb.append(nivel).append(" | ").append(hora).append(" | ");

				sb.append(record.getSourceClassName()).append(" | ");

				sb.append(record.getSourceMethodName()).append(" | ");

				sb.append(mensaje).append("\n");

				return sb.toString();
			}
		};
		// Ahora hay que meterle un formatter al ch
		return newFormatter;
	}

	private static Formatter simpleFormater() {
		Formatter newFormatter = new Formatter() {

			@Override
			public String format(LogRecord record) {

				String hora = dtf.format(LocalDateTime.now());

				String nivel = nivelFormater(record, false);

				StringBuilder sb = new StringBuilder();
			
				sb.append(nivel).append(" | ").append(hora).append(" | ");
				
				sb.append(record.getSourceClassName()).append(" | ");

				sb.append(record.getSourceMethodName()).append(" | ");

				sb.append(record.getMessage()).append("\n");

				return sb.toString();
			}

		};
		
		return newFormatter;
	}

	private static String getLocalizedLevel(Log4nConfigurator log4nConfigurator, LogRecord record) {
		return nivelFormater(record, log4nConfigurator.isLocalized());
	}

	private static String nivelFormater(LogRecord record, boolean isLocalized) {
		String level = isLocalized ? record.getLevel().getLocalizedName() : record.getLevel().getName();

		level = (level.length() < 8) ? level : level.substring(0, 7);

		return String.format("%8s", level);
	}

}
