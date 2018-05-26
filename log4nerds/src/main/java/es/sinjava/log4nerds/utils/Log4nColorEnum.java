package es.sinjava.log4nerds.utils;

import static es.sinjava.log4nerds.utils.Log4nColors.ANSI_BLACK;
import static es.sinjava.log4nerds.utils.Log4nColors.ANSI_BLUE;
import static es.sinjava.log4nerds.utils.Log4nColors.ANSI_CYAN;
import static es.sinjava.log4nerds.utils.Log4nColors.ANSI_GREEN;
import static es.sinjava.log4nerds.utils.Log4nColors.ANSI_PURPLE;
import static es.sinjava.log4nerds.utils.Log4nColors.ANSI_RED;
import static es.sinjava.log4nerds.utils.Log4nColors.ANSI_RESET;
import static es.sinjava.log4nerds.utils.Log4nColors.ANSI_WHITE;
import static es.sinjava.log4nerds.utils.Log4nColors.ANSI_YELLOW;

public enum Log4nColorEnum {

	RESET(ANSI_RESET), BLACK(ANSI_BLACK), GREEN(ANSI_GREEN), YELLOW(ANSI_YELLOW), BLUE(ANSI_BLUE), PURPLE(
			ANSI_PURPLE), RED(ANSI_RED), CYAN(ANSI_CYAN), WHITE(ANSI_WHITE);

	private String code;

	Log4nColorEnum(String codeIn) {
		code = codeIn;
	}

	public String getCode() {
		return code;
	}

}