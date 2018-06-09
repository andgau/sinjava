
package es.sinjava;

import java.util.logging.Logger;

import es.sinjava.log4nerds.Configurators.FileConfigurator;
import es.sinjava.log4nerds.factories.Log4nFactory;

public class FileApp {

	private static FileConfigurator config = FileConfigurator.getInstance("Hola.log", true, false);

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
