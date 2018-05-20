package es.sinjava.log4nerds.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.sinjava.log4nerds.factories.Log4nFactory;

public class Log4nConfigurator {

	private static Logger logger = Log4nFactory.getInstance(Log4nConfigurator.rainbow());

	private Map<Level, String> configuration;

	public static Log4nConfigurator rainbow() {
		Log4nConfigurator configurator = new Log4nConfigurator();
		configurator.configuration = new HashMap<>();
		int indexColor = 0;
		for (Log4nLevelEnum item : Log4nLevelEnum.values()) {
			// para cada uno de los enumerados
			Level currentLevel = Level.parse(item.name());
			Log4nColorEnum[] colorValues = Log4nColorEnum.values();
			String value = colorValues[indexColor++].getCode();
			configurator.configuration.put(currentLevel, value);
		}

		return configurator;
	}

	public Map<Level, String> getConfiguration() {
		return configuration;
	}

}
