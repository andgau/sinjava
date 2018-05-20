package es.sinjava.jokes;

public class Joker {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static void chungoWorld() {
		System.exit(0);
	}

	public static void red(String input) {
		System.out.println(ANSI_RED + input + ANSI_RESET);
	}

	public static void yellow(String input) {
		System.out.println(ANSI_YELLOW + input + ANSI_RESET);
	}

	public static void black(String input) {
		System.out.println(ANSI_BLACK + input + ANSI_RESET);
	}

	public static void green(String input) {
		System.out.println(ANSI_GREEN + input + ANSI_RESET);
	}

	public static void blue(String input) {
		System.out.println(ANSI_BLUE + input + ANSI_RESET);
	}

}
