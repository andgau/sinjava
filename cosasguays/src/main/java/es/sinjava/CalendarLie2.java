package es.sinjava;

import static es.sinjava.jokes.Joker.blue;
import static es.sinjava.jokes.Joker.red;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarLie2 {

	public static void main(String[] args) {
		Date today = new Date();
		// long dayLap = 1000 * 60 * 60 * 24; // Un dia en milisegundos
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yy");

		blue("EL dia de hoy " + sdf.format(today));

		Date yesterday = new Date(today.getTime() - 1000 * 60 * 60 * 24);

		blue("EL dia de ayer " + sdf.format(yesterday));

		Date hellDay = new Date(today.getTime() - (1000 * 60 * 60 * 24 * 666));

		red("EL dia infierno " + sdf.format(hellDay));

	}

}
