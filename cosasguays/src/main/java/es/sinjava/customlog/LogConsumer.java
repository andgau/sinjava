package es.sinjava.customlog;

import java.util.logging.Level;
import java.util.logging.Logger;

import es.sinjava.customlog.logger.SinjavaLogger;

public class LogConsumer {

	private static Logger logger = SinjavaLogger.getInstance();
	// private static Logger logger = Logger.getAnonymousLogger();

	public static void main(String[] args) {
		logger.setLevel(Level.FINEST);

		logger.fine("Hola Mensajero");
		logger.severe("Mensaje Severo");
		logger.warning("Mensaje de Warning");
		logger.info("Información");

	}

}
