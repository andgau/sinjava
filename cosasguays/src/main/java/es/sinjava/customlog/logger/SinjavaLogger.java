package es.sinjava.customlog.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class SinjavaLogger {

	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_BLACK = "\u001B[30m";
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_YELLOW = "\u001B[33m";
	private static final String ANSI_BLUE = "\u001B[34m";
	private static final String ANSI_PURPLE = "\u001B[35m";
	private static final String ANSI_CYAN = "\u001B[36m";
	private static final String ANSI_WHITE = "\u001B[37m";

	private static Logger log;

	private static void createCustomLog() {

		log = Logger.getAnonymousLogger();
		log.setUseParentHandlers(false);

		ConsoleHandler ch = new ConsoleHandler();
		ch.setLevel(Level.FINEST);

		Formatter newFormatter = new Formatter() {

			@Override
			public String format(LogRecord record) {

				LocalDateTime localeDate = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy hh:mm:ss");
				int currentLevel = record.getLevel().intValue();

				String headColor = ANSI_WHITE;

				if (currentLevel == Level.INFO.intValue()) {
					headColor = ANSI_YELLOW;
				} else if (currentLevel == Level.WARNING.intValue()) {
					headColor = ANSI_RED;
				} else if (currentLevel == Level.FINE.intValue()) {
					headColor = ANSI_GREEN;
				} else {
					headColor = ANSI_PURPLE;
				}

				String level8 = String.format("%1$8s", record.getLevel().getName());

				StringBuilder stringBuilder = new StringBuilder(headColor);
				stringBuilder.append(level8).append(" | ");

				stringBuilder.append(localeDate.format(formatter)).append(" | ");
				stringBuilder.append(record.getMessage() + ANSI_RESET + "\n");

				return stringBuilder.toString();
			}

		};

		ch.setFormatter(newFormatter);

		log.addHandler(ch);

	}

	public static Logger getInstance() {
		if (log == null) {
			createCustomLog();
		}
		return log;
	}

}
