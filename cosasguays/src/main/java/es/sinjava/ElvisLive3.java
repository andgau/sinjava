package es.sinjava;

import static es.sinjava.jokes.Joker.green;
import static es.sinjava.jokes.Joker.red;

public class ElvisLive3 {

	public static void main(String... args) {

		String caso1 = null;

		sanitize(caso1);

		checking(caso1);

	}

	private static void sanitize(String caso1) {
		caso1 = caso1 == null ? "" : caso1;
	}

	private static void checking(String caso1) {

		if (caso1 != null && isLowerCase(caso1)) {
			green("Es minusculas checking" + caso1);
		} else {
			red("Es mix checking" + caso1);
		}

		if (caso1 != null & isLowerCase(caso1)) {
			green("Es minusculas checking " + caso1);
		} else {
			red("Es mix checking" + caso1);
		}
	}

	private static boolean isLowerCase(String caso1) {

		return caso1.toLowerCase().equals(caso1.toLowerCase());
	}

}
