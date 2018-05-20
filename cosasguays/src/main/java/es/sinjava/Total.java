package es.sinjava;

public class Total {

	public static void main(String... args) {

		Integer integerOne = Integer.valueOf(1);
		Integer integerTwo = Integer.valueOf(1);

		if (integerOne == integerTwo) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}

		Integer hellOne = Integer.valueOf(666);
		Integer hellTwo = Integer.valueOf(666);

		if (hellOne == hellTwo) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}

	}

}
