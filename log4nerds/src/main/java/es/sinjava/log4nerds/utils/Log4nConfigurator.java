package es.sinjava.log4nerds.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.sinjava.log4nerds.factories.Log4nFactory;

public class Log4nConfigurator {

	private Map<Level, String> configuration;
	private boolean localized;

	private Log4nConfigurator() {

	}

	public boolean isLocalized() {
		return localized;
	}

	public static Log4nConfigurator black() {
		Log4nConfigurator configurator = new Log4nConfigurator();
		configurator.configuration = new HashMap<>();
		for (Log4nLevelEnum item : Log4nLevelEnum.values()) {
			configurator.configuration.put(Level.parse(item.name()), Log4nColorEnum.BLACK.getCode());
		}
		return configurator;
	}

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

	public Log4nConfigurator configure(Level level, Log4nColorEnum color) {
		configuration.put(level, color.getCode());
		Log4nConfigurator configurator = new Log4nConfigurator();
		configurator.setConfiguration(configuration);
		configurator.localized = localized;
		return configurator;
	}

	public Log4nConfigurator setLocal(boolean localized) {
		Log4nConfigurator configurator = new Log4nConfigurator();
		configurator.setConfiguration(configuration);
		configurator.localized = localized;
		return configurator;
	}

	public void setConfiguration(Map<Level, String> configuration) {
		this.configuration = configuration;
	}

	public Map<Level, String> getConfiguration() {
		return configuration;
	}

}
