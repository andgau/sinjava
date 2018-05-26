package es.sinjava.log4nerds.Configurators;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import es.sinjava.log4nerds.utils.Log4nColorEnum;
import es.sinjava.log4nerds.utils.Log4nLevelEnum;

public class ConsoleConfigurator {

	private Map<Level, String> configuration;
	private boolean localized;

	private ConsoleConfigurator() {

	}

	public static ConsoleConfigurator getInstance() {
		ConsoleConfigurator configurator = new ConsoleConfigurator();
		configurator.configuration = new HashMap<>();
		for (Log4nLevelEnum item : Log4nLevelEnum.values()) {
			// No introducirá nada
			configurator.configuration.put(Level.parse(item.name()), "");
		}
		return configurator;
	}

	public static ConsoleConfigurator black() {
		ConsoleConfigurator configurator = new ConsoleConfigurator();
		configurator.configuration = new HashMap<>();
		for (Log4nLevelEnum item : Log4nLevelEnum.values()) {
			configurator.configuration.put(Level.parse(item.name()), Log4nColorEnum.BLACK.getCode());
		}
		return configurator;
	}

	public static ConsoleConfigurator rainbow() {
		ConsoleConfigurator configurator = new ConsoleConfigurator();
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

	public ConsoleConfigurator configure(Level level, Log4nColorEnum color) {
		configuration.put(level, color.getCode());
		ConsoleConfigurator configurator = new ConsoleConfigurator();
		configurator.setConfiguration(configuration);
		configurator.localized = localized;

		return configurator;
	}

	public ConsoleConfigurator setLocal(boolean localized) {
		ConsoleConfigurator configurator = new ConsoleConfigurator();
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

	public void setLocalized(boolean localized) {
		this.localized = localized;
	}

	public boolean isLocalized() {
		return localized;
	}

}
