/* Start des Programms, ruft eine Instanz der View Anzeige und des Controllers auf.
 * weitere Anzeigen werden im Anschluss über die View Anzeige aufgreufen.
 */

package main;

import gui.*;

public class Main {
	public static void main(String[] args) {
		MyView view = new MyView();
		Controller controller = new Controller(view);

	}
}