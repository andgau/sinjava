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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.LogRecord;

public interface IFormatter {

	// Constantes de uso común
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy hh:mm:ss");

	// Metodos por defecto
	default void bodyLogRecord(LogRecord record, StringBuilder sb) {
		String hora = dtf.format(LocalDateTime.now());

		String nivel = getLocalizedLevel(record);

		sb.append(record.getSequenceNumber()).append(" | ");

		sb.append(nivel).append(" | ").append(hora).append(" | ");

		sb.append(record.getSourceClassName()).append(" | ");

		sb.append(record.getSourceMethodName()).append(" | ");

		sb.append(record.getMessage());
	}

	// Interfaz comun
	String format(LogRecord record);

	default String getLocalizedLevel(LogRecord record) {
		return nivelFormater(record, isLocalized());
	}

	boolean isLocalized();

	default String nivelFormater(LogRecord record, boolean isLocalized) {
		String level = isLocalized ? record.getLevel().getLocalizedName() : record.getLevel().getName();
		level = (level.length() < 8) ? level : level.substring(0, 7);
		return String.format("%8s", level);
	}

	void setLocalized(boolean local);

}