package es.sinjava;

import static es.sinjava.jokes.Joker.green;
import static es.sinjava.jokes.Joker.red;

import es.sinjava.jokes.WrapperGuay;

public class ElvisLive4 {

	public static void main(String... args) {

		WrapperGuay caso1 = new WrapperGuay();

		sanitize(caso1);

		checking(caso1.getStringGuay());

	}

	private static void sanitize(WrapperGuay caso1) {
		caso1.setStringGuay(caso1.getStringGuay() == null ? "" : caso1.getStringGuay());
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
