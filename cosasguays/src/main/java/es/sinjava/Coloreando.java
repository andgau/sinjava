package es.sinjava;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Coloreando {

	private static final Logger LOG = Logger.getAnonymousLogger();
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static void main(String[] args) {

		LOG.setUseParentHandlers(false);

		ConsoleHandler ch = new ConsoleHandler();
		ch.setLevel(Level.FINE);

		Formatter newFormatter = new Formatter() {

			@Override
			public String format(LogRecord record) {

				// Es un appender de consola
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

				// System.out.println(ANSI_YELLOW + record.getMessage() + ANSI_RESET);

				return stringBuilder.toString();
			}

		};

		ch.setFormatter(newFormatter);
		LOG.setLevel(Level.FINE);

		LOG.addHandler(ch);

		LOG.fine("mensaje Fino");

		LOG.info("Hola Caracola");

		LOG.warning("No way Out");

	}

}
