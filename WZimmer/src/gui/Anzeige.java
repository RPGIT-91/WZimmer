/* Die Klasse "Anzeige" zeigt das Wartezimmer an und ermöglicht es, Patienten hinzuzufügen oder zu entfernen. 
 * Sie implementiert das Interface "IAnzeigeOperations". Die Methode addPatient fügt einen Patienten zum Wartezimmer hinzu und 
 * zeigt seine aktuelle Wartezeit an. Die Methode removePatient entfernt den nächsten Patienten aus dem Wartezimmer. Die Methode 
 * getWaitPanel gibt das JPanel zurück, das Informationen zum aktuellen Wartezimmerstatus enthält. Die Methode getRows gibt die Anzahl 
 * der Patienten im Wartezimmer zurück.
 */

package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.time.LocalTime;
import interfaces.IAnzeigeOperations;
import user.*;

// Die Klasse "Anzeige" zeigt das Wartezimmer an und implementiert das Interface "IAnzeigeOperations".
class Anzeige extends JFrame implements IAnzeigeOperations {
	// Wartezimmer Anzeige

	// Set up the frame
	private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;
	private JTable table;
	private JPanel waitPanel;

	// Konstruktor der Klasse "Anzeige"
	public Anzeige() {
		setTitle("Wartezimmer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Schließt das gesamte Programm, wenn das Fenster geschlossen
														// wird.
		// setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // juju (Alternative zur
		// obigen Zeile)
		setSize(1280, 720);

		// Erstelle das Tabellenmodell
		tableModel = new DefaultTableModel() {
			private static final long serialVersionUID = 7613152197870578937L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// Deaktiviere die Bearbeitung der Zellen
				return false;
			}
		};
		tableModel.addColumn("Name");
		tableModel.addColumn("Am Warten seit");

		// Erstelle die Tabelle
		table = new JTable(tableModel);
		JTableHeader tableHeader = table.getTableHeader();
		Font headerFont = new Font("Verdana", Font.BOLD, 25);
		tableHeader.setFont(headerFont);
		tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(), 50));

		table.setFont(new Font("Serif", Font.PLAIN, 20));
		table.setRowHeight(table.getRowHeight() + 10);

		// Füge die Tabelle einem Scrollpane hinzu
		JScrollPane scrollPane2 = new JScrollPane(table);

		waitPanel = new JPanel(new GridLayout(1, 2));

		waitPanel.add(new JLabel("Personen am Warten: " + table.getRowCount()));

		// Setze das Layout auf BorderLayout
		setLayout(new BorderLayout());
		add(scrollPane2, BorderLayout.CENTER);
		add(waitPanel, BorderLayout.SOUTH);

		// Setzt das Wartezimmer-Fenster in die Mitte
		setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void addPatient(Person patient) {
		// Aktuelle Zeit, wird angegeben
		LocalTime currentTime = LocalTime.now();
		String currentHour = String.format("%02d", currentTime.getHour());
		String currentMinute = String.format("%02d", currentTime.getMinute());
		String currentTimeText = currentHour + ":" + currentMinute;
		tableModel.addRow(new Object[] { patient.getName(), currentTimeText });
		// .getAppointmentTime()
	}

	@Override
	public void removePatient(Person patient) {
		tableModel.removeRow(0);
	}

	public JPanel getWaitPanel() {
		return waitPanel;
	}

	@Override
	public int getRows() {
		return table.getRowCount();
	}
	
	@Override
	public void refreshDisplay() {
		JLabel waitingLabel = (JLabel) waitPanel.getComponent(0);
		
		waitingLabel.setText("Personen am Warten: " + table.getRowCount());
	}

}
