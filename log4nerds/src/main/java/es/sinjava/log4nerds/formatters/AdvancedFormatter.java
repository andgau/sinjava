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

package es.sinjava.log4nerds.formatters;

import static es.sinjava.log4nerds.utils.Color.ANSI_RESET;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import es.sinjava.log4nerds.Configurators.ConsoleConfigurator;
import es.sinjava.log4nerds.utils.FieldEnum;
import es.sinjava.log4nerds.utils.MatcherField;

public class AdvancedFormatter extends DefaultFormatter implements IFormatter {

	private Map<Level, String> configuration;
	private List<FieldEnum> fieldList;

	private String separator = " | ";

	public AdvancedFormatter(ConsoleConfigurator config) {
		setLocalized(config.isLocalized());
		configuration = config.getConfiguration();
		if (config.getFieldList() != null && !config.getFieldList().isEmpty()) {
			fieldList = new ArrayList<>();
			fieldList.addAll(config.getFieldList());
			fieldList.add(FieldEnum.MESS);
		}
		separator = (config.getSeparator() != null) ? config.getSeparator() : separator;
	}

	private StringBuilder ansiBodyRecord(LogRecord record) {
		StringBuilder sb = new StringBuilder(configuration.get(record.getLevel()));
		MatcherField matcher = MatcherField.getInstance(isLocalized(), dtf);
		for (FieldEnum field : fieldList) {
			sb.append(matcher.getValue(field, record)).append(separator);
		}
		return sb.delete(sb.lastIndexOf(separator), sb.length()).append(ANSI_RESET);
	}

	private StringBuilder bodyRecord(LogRecord record) {
		StringBuilder sb = new StringBuilder();
		MatcherField matcher = MatcherField.getInstance(isLocalized(), dtf);
		for (FieldEnum field : fieldList) {
			sb.append(matcher.getValue(field, record)).append(separator);
		}
		return sb.delete(sb.lastIndexOf(separator), sb.length());
	}

	@Override
	public String format(LogRecord record) {
		String traza = "";
		if (configuration == null) {
			StringBuilder sb = bodyRecord(record).append("\n");
			traza = sb.toString();
		} else {
			StringBuilder sb = ansiBodyRecord(record).append("\n");
			traza = sb.toString();
		}
		return traza;
	}

}
