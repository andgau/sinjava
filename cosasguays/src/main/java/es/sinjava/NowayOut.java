package es.sinjava;

import static es.sinjava.jokes.Joker.blue;
import static es.sinjava.jokes.Joker.chungoWorld;
import static es.sinjava.jokes.Joker.red;
import static es.sinjava.jokes.Joker.yellow;

public class NowayOut {

	public static void main(String[] args) {
		yellow(" No se asume que se sepa todo,  ni siquiera mucho, se asume que se prueba el código");

		yellow("¿Tengo una chuckNorrisException?");

		try {
			// el método chungoWorld intenta hacer lo más chungo posible para saltar el
			// máximo posible de catch

			chungoWorld();

			blue("No ha pasado algo chungo");
		} catch (RuntimeException ex) {
			red("Ha pasado algo chunguito");
		} catch (Exception ex) {
			red("Ha pasado algo chungo");
		} catch (Error ex) {
			red("Ha pasado algo super chungo");
		} catch (Throwable ex) {
			red("Ha pasado lo peor del mundo");
		} finally {
			blue("He acabado");
		}

	}
}