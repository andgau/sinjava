package es.sinjava;

import static es.sinjava.log4nerds.utils.Log4nColorEnum.BLUE;
import static es.sinjava.log4nerds.utils.Log4nColorEnum.CYAN;
import static java.util.logging.Level.INFO;
import static java.util.logging.Level.SEVERE;

import java.util.logging.Logger;

import es.sinjava.log4nerds.Configurators.ConsoleConfigurator;
import es.sinjava.log4nerds.factories.Log4nFactory;

public class ConsoleApp3 {

	private static ConsoleConfigurator config = ConsoleConfigurator.getInstance().setLocal(false).configure(INFO, BLUE)
			.configure(SEVERE, CYAN);

	private static Logger logger = Log4nFactory.getInstance(config);

	public static void main(String[] args) {

		logger.fine("Mensaje Fine");
		logger.finest("Mensaje finest");
		logger.info("Hola Mundo");
		logger.severe("Mensaje de abuelo");
		logger.warning("Mensaje Warningn");
		logger.config("Mensaje de Configuración");
	}
}
