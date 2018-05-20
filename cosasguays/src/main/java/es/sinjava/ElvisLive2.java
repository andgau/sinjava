package es.sinjava;

import static es.sinjava.jokes.Joker.green;
import static es.sinjava.jokes.Joker.red;

public class ElvisLive2 {

	public static void main(String... args) {

		String caso1 = null;

		checking(caso1);

	}

	private static void checking(String caso1) {

		if (caso1 != null && isLowerCase(caso1)) {
			green("Es minusculas checking" + caso1);
		} else {
			green("Es mix checking" + caso1);
		}

		if (caso1 != null & isLowerCase(caso1)) {
			red("Es minusculas checking " + caso1);
		} else {
			red("Es mix checking" + caso1);
		}
	}

	private static boolean isLowerCase(String caso1) {

		return caso1.toLowerCase().equals(caso1.toLowerCase());
	}

}
