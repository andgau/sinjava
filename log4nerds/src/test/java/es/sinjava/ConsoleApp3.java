
package es.sinjava;

import static es.sinjava.log4nerds.utils.ColorEnum.BLUE;
import static es.sinjava.log4nerds.utils.ColorEnum.CYAN;
import static es.sinjava.log4nerds.utils.FieldEnum.FCLASS;
import static es.sinjava.log4nerds.utils.FieldEnum.FLEVEL;
import static es.sinjava.log4nerds.utils.FieldEnum.FMETHOD;
import static es.sinjava.log4nerds.utils.FieldEnum.FSEQ;
import static es.sinjava.log4nerds.utils.FieldEnum.FTIME;
import static java.util.logging.Level.INFO;
import static java.util.logging.Level.SEVERE;

import java.util.logging.Logger;

import es.sinjava.log4nerds.Configurators.ConsoleConfigurator;
import es.sinjava.log4nerds.factories.Log4nFactory;

public class ConsoleApp3 {

	private static ConsoleConfigurator config = ConsoleConfigurator.getInstance().configure(INFO, BLUE)
			.configure(SEVERE, CYAN).setLocal(true).setFormat(FSEQ, FLEVEL, FTIME, FCLASS, FMETHOD);

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
