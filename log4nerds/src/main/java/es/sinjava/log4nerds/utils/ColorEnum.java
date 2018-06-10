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

import static es.sinjava.log4nerds.utils.Color.ANSI_BLACK;
import static es.sinjava.log4nerds.utils.Color.ANSI_BLUE;
import static es.sinjava.log4nerds.utils.Color.ANSI_CYAN;
import static es.sinjava.log4nerds.utils.Color.ANSI_GREEN;
import static es.sinjava.log4nerds.utils.Color.ANSI_PURPLE;
import static es.sinjava.log4nerds.utils.Color.ANSI_RED;
import static es.sinjava.log4nerds.utils.Color.ANSI_RESET;
import static es.sinjava.log4nerds.utils.Color.ANSI_WHITE;
import static es.sinjava.log4nerds.utils.Color.ANSI_YELLOW;

public enum ColorEnum {

	BLACK(ANSI_BLACK), BLUE(ANSI_BLUE), CYAN(ANSI_CYAN), GREEN(ANSI_GREEN), PURPLE(ANSI_PURPLE), RED(ANSI_RED), RESET(
			ANSI_RESET), WHITE(ANSI_WHITE), YELLOW(ANSI_YELLOW);

	private String code;

	ColorEnum(String codeIn) {
		code = codeIn;
	}

	public String getCode() {
		return code;
	}

}