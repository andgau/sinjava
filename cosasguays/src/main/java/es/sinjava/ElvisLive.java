package es.sinjava;

import static es.sinjava.jokes.Joker.blue;
import static es.sinjava.jokes.Joker.green;

public class ElvisLive {

	public static void main(String... args) {

		// Cualquier cambio puede tener consecuencias

		String caso1 = "Hola Caracola";

		// desde aquí me lo llevo a un método
		if (caso1 != null && isLowerCase(caso1)) {
			blue("Es minusculas " + caso1);
		} else {
			green("Es mix " + caso1);
		}

		if (caso1 != null & isLowerCase(caso1)) {
			green("Es minusculas " + caso1);
		} else {
			green("Es mix " + caso1);
		}

	}

	private static boolean isLowerCase(String caso1) {

		return caso1.toLowerCase().equals(caso1);
	}

}
