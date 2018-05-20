package es.sinjava;

import static es.sinjava.jokes.Joker.blue;
import static es.sinjava.jokes.Joker.red;
import static es.sinjava.jokes.Joker.yellow;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarLie {

	public static void main(String[] args) {
		Date today = new Date();
		long dayLap = 1000 * 60 * 60 * 24; // Un dia en milisegundos

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yy");

		blue("EL dia de hoy " + sdf.format(today));

		Date yesterday = new Date(today.getTime() - dayLap);

		yellow("EL dia de ayer " + sdf.format(yesterday));

		Date hellDay = new Date(today.getTime() - (dayLap * 666));

		red("EL dia infierno " + sdf.format(hellDay));

	}

}
