/*
 * Copyright 2018-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * @ Author: Andres Gaudioso Simon mailto:andgau@gmail.com
 */

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
			.configure(SEVERE, CYAN).setLocal(false).setFormat(" | ", FSEQ, FLEVEL, FTIME, FCLASS, FMETHOD);

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
