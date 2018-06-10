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

package es.sinjava.log4nerds.Configurators;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import es.sinjava.log4nerds.utils.ColorEnum;
import es.sinjava.log4nerds.utils.FieldEnum;
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

	private List<FieldEnum> fieldList; // = Arrays.asList(FieldEnum.FSEQ, FieldEnum.FLEVEL, FieldEnum.FTIME,
	// FieldEnum.FCLASS, FieldEnum.FMETHOD);

	private boolean localized;

	public String separator;

	private ConsoleConfigurator() {

	}

	public ConsoleConfigurator configure(Level level, ColorEnum color) {
		configuration.put(level, color.getCode());
		ConsoleConfigurator configurator = new ConsoleConfigurator();
		configurator.setConfiguration(configuration);
		configurator.localized = localized;
		configurator.setFieldList(getFieldList());
		configurator.setSeparator(getSeparator());
		return configurator;
	}

	public Map<Level, String> getConfiguration() {
		return configuration;
	}

	public List<FieldEnum> getFieldList() {
		return fieldList;
	}

	public String getSeparator() {
		return separator;
	}

	public boolean isLocalized() {
		return localized;
	}

	public void setConfiguration(Map<Level, String> configuration) {
		this.configuration = configuration;
	}

	public void setFieldList(List<FieldEnum> fieldList) {
		this.fieldList = fieldList;
	}

	public ConsoleConfigurator setFormat(String separatorIn, FieldEnum... fieldEnums) {
		ConsoleConfigurator configurator = new ConsoleConfigurator();
		configurator.setConfiguration(configuration);
		configurator.localized = localized;
		configurator.separator = (separatorIn != null) ? separatorIn : " | ";
		configurator.setFieldList(Arrays.asList(fieldEnums));
		return configurator;
	}

	public ConsoleConfigurator setLocal(boolean localized) {
		ConsoleConfigurator configurator = new ConsoleConfigurator();
		configurator.setConfiguration(configuration);
		configurator.localized = localized;
		configurator.setFieldList(getFieldList());
		configurator.setSeparator(getSeparator());
		return configurator;
	}

	public void setLocalized(boolean localized) {
		this.localized = localized;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

}
