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
package es.sinjava.log4nerds.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.LogRecord;

public class MatcherField {

	private static MatcherField matcherField;

	public static MatcherField getInstance(boolean locale, DateTimeFormatter dtf) {

		if (matcherField == null) {
			matcherField = new MatcherField(locale, dtf);
		}
		return matcherField;
	}

	private DateTimeFormatter dtf;

	private boolean localized;

	public MatcherField(boolean locale, DateTimeFormatter dtf2) {
		localized = locale;
		dtf = dtf2;
	}

	public String getValue(FieldEnum field, LogRecord record) {
		String value = "";
		if (field.equals(FieldEnum.FSEQ)) {
			value = Long.toString(record.getSequenceNumber());

		} else if (field.equals(FieldEnum.FLEVEL)) {
			String level = localized ? record.getLevel().getLocalizedName() : record.getLevel().getName();
			level = (level.length() < 8) ? level : level.substring(0, 7);
			value = String.format("%8s", level);

		} else if (field.equals(FieldEnum.FCLASS)) {
			value = record.getSourceClassName();

		} else if (field.equals(FieldEnum.FMETHOD)) {
			value = record.getSourceMethodName();

		} else if (field.equals(FieldEnum.FTIME)) {

			value = dtf.format(LocalDateTime.now());

		} else {
			value = record.getMessage();
		}
		return value;
	}

}
