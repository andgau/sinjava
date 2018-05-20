package es.sinjava;

import es.sinjava.jokes.WrapperGuay;

public class ElvisLive5 {

	public static void main(String... args) {

		WrapperGuay caso1 = new WrapperGuay();

		sanitize(caso1);

		checking(caso1.getStringGuay());

	}

	private static void sanitize(final WrapperGuay caso1) {
		// ESto es de las cosas que me encanta que pase...
		// típico en los logs
		System.out.println("Recibo en String  " + caso1.getStringGuay());
		System.out.println("Recibo un String de tamaño " + caso1.getStringGuay().length());

		caso1.setStringGuay(caso1.getStringGuay() == null ? "" : caso1.getStringGuay());
	}

	private static void checking(String caso1) {

		if (caso1 != null && isLowerCase(caso1)) {
			System.out.println("Es minusculas checking" + caso1);
		} else {
			System.out.println("Es mix checking" + caso1);
		}

		if (caso1 != null & isLowerCase(caso1)) {
			System.out.println("Es minusculas checking " + caso1);
		} else {
			System.out.println("Es mix checking" + caso1);
		}
	}

	private static boolean isLowerCase(String caso1) {

		return caso1.toLowerCase().equals(caso1.toLowerCase());
	}

}
