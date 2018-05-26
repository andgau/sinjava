package es.sinjava;

import static es.sinjava.log4nerds.utils.Log4nColorEnum.*;
import static java.util.logging.Level.*;

import java.util.logging.Logger;

import es.sinjava.log4nerds.factories.Log4nFactory;
import es.sinjava.log4nerds.utils.Log4nConfigurator;

public class App {

	private static Log4nConfigurator config = Log4nConfigurator.rainbow().setLocal(false).configure(INFO, BLUE).configure(SEVERE, CYAN);

	private static Logger logger = Log4nFactory.getInstance(config);
	// private static Logger logger =
	// Log4nFactory.getFileInstance(App.class.getName());

	public static void main(String[] args) {
		logger.fine("Mensaje Fine");
		logger.finest("Mensaje finest");
		logger.info("Hola Mundo");
		logger.severe("Mensaje de abuelo");
		logger.warning("Mensaje Warningn");
		logger.config("Mensaje de Configuración");
	}
}
