package es.sinjava;

import java.util.logging.Logger;

import es.sinjava.log4nerds.factories.Log4nFactory;
import es.sinjava.log4nerds.utils.Log4nConfigurator;

public class App {
//	private static Logger logger = Log4nFactory.getInstance();
	
	private static Logger logger = Log4nFactory.getInstance(Log4nConfigurator.rainbow());

	public static void main(String[] args) {
		logger.info("Hola Mundo");
		logger.severe("Mensaje de abuelo");
		logger.fine("Mensaje Fine");
		logger.finest("Mensaje finest");
		logger.warning("Mensaje Warningn");

	}
}
