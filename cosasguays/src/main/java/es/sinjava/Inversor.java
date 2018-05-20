package es.sinjava;

public class Inversor {

	public static void main(String... arg) {

		System.out.println("Programa Inversor");

		String stringGuay = " Esta es la frase a invertir";

		String inverseStringGuay = "";

		/* Ofrece una oportunidad de mejora */

		for (char charGuay : stringGuay.toCharArray()) {
			inverseStringGuay = Character.toString(charGuay).concat(inverseStringGuay);
		}
		System.out.println(inverseStringGuay);

		// Ejemplo chungo

		int unInteger = 15;
		int otroInteger = 25;

		boolean compareValues = compareValues(unInteger, otroInteger);

		if (compareValues == true) {
			System.out.println("Son iguales");
		} else {
			System.out.println("No son iguales");

		}

	}

	private static boolean compareValues(int unInteger, int otroInteger) {

		if ((unInteger == otroInteger) != false) {
			return true;
		} else {
			return false;
		}

	}

}
