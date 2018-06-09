
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