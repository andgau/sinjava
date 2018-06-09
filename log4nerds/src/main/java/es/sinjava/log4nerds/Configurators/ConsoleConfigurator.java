
package es.sinjava.log4nerds.Configurators;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import es.sinjava.log4nerds.utils.ColorEnum;
import es.sinjava.log4nerds.utils.LevelEnum;

public class ConsoleConfigurator {

	public static ConsoleConfigurator black() {
		ConsoleConfigurator configurator = new ConsoleConfigurator();
		configurator.configuration = new HashMap<>();
		for (LevelEnum item : LevelEnum.values()) {
			configurator.configuration.put(Level.parse(item.name()), ColorEnum.BLACK.getCode());
		}
		return configurator;
	}

	public static ConsoleConfigurator getInstance() {
		ConsoleConfigurator configurator = new ConsoleConfigurator();
		configurator.configuration = new HashMap<>();
		for (LevelEnum item : LevelEnum.values()) {
			// No introducirá nada
			configurator.configuration.put(Level.parse(item.name()), "");
		}
		return configurator;
	}

	public static ConsoleConfigurator rainbow() {
		ConsoleConfigurator configurator = new ConsoleConfigurator();
		configurator.configuration = new HashMap<>();
		int indexColor = 0;
		for (LevelEnum item : LevelEnum.values()) {
			// para cada uno de los enumerados
			Level currentLevel = Level.parse(item.name());
			ColorEnum[] colorValues = ColorEnum.values();
			String value = colorValues[indexColor++].getCode();
			configurator.configuration.put(currentLevel, value);
		}
		return configurator;
	}

	private Map<Level, String> configuration;

	private boolean localized;

	private ConsoleConfigurator() {

	}

	public ConsoleConfigurator configure(Level level, ColorEnum color) {
		configuration.put(level, color.getCode());
		ConsoleConfigurator configurator = new ConsoleConfigurator();
		configurator.setConfiguration(configuration);
		configurator.localized = localized;

		return configurator;
	}

	public Map<Level, String> getConfiguration() {
		return configuration;
	}

	public boolean isLocalized() {
		return localized;
	}

	public void setConfiguration(Map<Level, String> configuration) {
		this.configuration = configuration;
	}

	public ConsoleConfigurator setLocal(boolean localized) {
		ConsoleConfigurator configurator = new ConsoleConfigurator();
		configurator.setConfiguration(configuration);
		configurator.localized = localized;

		return configurator;
	}

	public void setLocalized(boolean localized) {
		this.localized = localized;
	}

}
