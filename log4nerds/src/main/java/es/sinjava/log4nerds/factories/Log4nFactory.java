package es.sinjava.log4nerds.factories;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.sinjava.log4nerds.Configurators.ConsoleConfigurator;
import es.sinjava.log4nerds.Configurators.FileConfigurator;
import es.sinjava.log4nerds.formatters.ConfiguratedFormatter;
import es.sinjava.log4nerds.formatters.DefaultFormatter;
import es.sinjava.log4nerds.formatters.SimpleFormatter;

public class Log4nFactory {

	private static Logger logger;

	public static Logger getInstance(ConsoleConfigurator config) {
		if (logger == null) {
			logger = Logger.getAnonymousLogger();
			// log a archivo
			Handler ch = new ConsoleHandler();
			ch.setLevel(Level.ALL);
			Formatter newFormatter;
			if (config != null) {
				newFormatter = new ConfiguratedFormatter(config.getConfiguration(), config.isLocalized());
			} else {
				newFormatter = new DefaultFormatter();
			}
			ch.setFormatter(newFormatter);
			logger.addHandler(ch);
			logger.setUseParentHandlers(false);
			logger.setLevel(Level.ALL);
		}
		return logger;
	}

	public static Logger getInstance(FileConfigurator fileConfigurator) {

		if (logger == null) {
			logger = Logger.getAnonymousLogger();

			Handler fileHandler;
			try {
				fileHandler = new FileHandler(fileConfigurator.getFileName(), true);
				fileHandler.setLevel(Level.ALL);
				Formatter newFormatter = new SimpleFormatter(fileConfigurator.isLocalized());
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
	//
	// private static Formatter defaultFormater() {
	// Formatter newFormatter = new Formatter() {
	//
	// @Override
	// public String format(LogRecord record) {
	//
	// String hora = dtf.format(LocalDateTime.now());
	//
	// String nivel = nivelFormater(record, false);
	//
	// StringBuilder sb = new StringBuilder();
	//
	// if (record.getLevel().equals(Level.SEVERE)) {
	// sb.append(ANSI_RED);
	// } else {
	// sb.append(ANSI_BLUE);
	// }
	//
	// sb.append(nivel).append(" | ").append(hora).append(" | ");
	//
	// sb.append(record.getSourceClassName()).append(" | ");
	//
	// sb.append(record.getSourceMethodName()).append(" | ");
	//
	// sb.append(record.getMessage()).append(ANSI_RESET).append(" \n");
	//
	// return sb.toString();
	// }
	// };
	// // Ahora hay que meterle un formatter al ch
	// return newFormatter;
	// }

}
