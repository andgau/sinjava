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

import static es.sinjava.log4nerds.utils.Color.ANSI_BLUE;
import static es.sinjava.log4nerds.utils.Color.ANSI_RED;
import static es.sinjava.log4nerds.utils.Color.ANSI_RESET;

import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class DefaultFormatter extends Formatter implements IFormatter {

	private boolean localized = false;

	@Override
	public String format(LogRecord record) {

		StringBuilder sb = new StringBuilder();

		// Barca flavour

		if (record.getLevel().equals(Level.SEVERE)) {
			sb.append(ANSI_RED);
		} else {
			sb.append(ANSI_BLUE);
		}
		bodyLogRecord(record, sb);
		sb.append(record.getMessage()).append(ANSI_RESET).append(" \n");

		return sb.toString();
	}

	@Override
	public boolean isLocalized() {
		return localized;
	}

	@Override
	public void setLocalized(boolean local) {
		localized = local;

	}

}
