/*
 * Dies ist die "MyView"-Klasse, die eine GUI (grafische Benutzeroberfläche) für das Verwalten von Patientendaten erstellt.
 * Diese Klasse erbt von JFrame und implementiert das ICommonOperations-Interface.
 * Sie enthält verschiedene Methoden zum Hinzufügen, Entfernen und Bearbeiten von Patientendaten.
 * Die GUI zeigt eine Tabelle mit Patientendaten an und bietet Buttons für verschiedene Aktionen.
 */

package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.util.function.Consumer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalTime;

import user.*;

public class MyView extends JFrame implements ICommonOperations {
	private static final long serialVersionUID = 107214543984441388L;
	private DefaultTableModel tableModel;
	private JTable table;
	private JButton addButton;
	private JButton editButton;
	private JButton viewButton;
	private JButton actionButton;
	private JButton addToWaitListButton;

	public MyView() {
		// Fensterkonfiguration
		setTitle("Patienten");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 720);
		setLocationRelativeTo(null);
		setVisible(true);

		// Datenmodell für die Tabelle erstellen
		tableModel = new DefaultTableModel() {
			private static final long serialVersionUID = 7613152197870578936L;
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		// Spalten zur Tabelle hinzufügen
		tableModel.addColumn("Name");
		tableModel.addColumn("Alter");
		tableModel.addColumn("E-Mail");
		tableModel.addColumn("Versich. Nr.");
		tableModel.addColumn("Vorkrankheiten");
		tableModel.addColumn("Termin");

		// Tabelle mit dem Datenmodell erstellen
		table = new JTable(tableModel);
		JTableHeader tableHeader = table.getTableHeader();
		Font headerFont = new Font("Verdana", Font.BOLD, 25);
		tableHeader.setFont(headerFont);
		tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(), 50));
		table.setFont(new Font("Serif", Font.PLAIN, 20));
		table.setRowHeight(table.getRowHeight() + 10);
		JScrollPane scrollPane = new JScrollPane(table);

		// Buttons erstellen
		addButton = new JButton("Patient hinzufügen");
		editButton = new JButton("Patient bearbeiten");
		viewButton = new JButton("Details anzeigen");
		actionButton = new JButton("Behandlung abschließen");
		addToWaitListButton = new JButton("Zur Warteliste hinzufügen");

		// Panel für Buttons erstellen
		JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.add(addButton);
		buttonPanel.add(editButton);
		buttonPanel.add(viewButton);
		buttonPanel.add(actionButton);
		buttonPanel.add(addToWaitListButton);

		// Layout-Manager des Fensters auf BorderLayout setzen
		setLayout(new BorderLayout());
		// ScrollPane (mit der Tabelle) in den Center-Bereich des Fensters hinzufügen
		add(scrollPane, BorderLayout.CENTER);
		// Button-Panel in den South-Bereich des Fensters hinzufügen
		add(buttonPanel, BorderLayout.SOUTH);

		setVisible(true);
	}

	// Methode zum Hinzufügen eines Patienten zur Tabelle
	@Override
	public void addPatient(Person person) {
		if (person instanceof Patient) {
			Patient patient = (Patient) person;
			tableModel.addRow(new Object[] { patient.getName(), patient.getAge(), patient.getContactDetails(),
					patient.getInsuranceNo(), patient.getMedicalHistory(), patient.getAppointmentTime() });
		} else {
			// Hier können andere Unterklassen von Person behandelt werden, falls erforderlich.
		}
	}

	// Methode zum Entfernen eines Patienten aus der Tabelle
	@Override
	public void removePatient(Person person) {
		if (person instanceof Patient) {
			Patient patient = (Patient) person;
			int patientID = patient.getPatientId() - 1;
			tableModel.removeRow(patientID);
		} else {
			// Hier können andere Unterklassen von Person behandelt werden, falls erforderlich.
		}
	}

	// Methoden zum Hinzufügen von ActionListenern zu den Buttons
	public void addAddPatientListener(ActionListener listener) {
		addButton.addActionListener(listener);
	}

	public void addEditPatientListener(ActionListener listener) {
		editButton.addActionListener(listener);
	}

	public void addViewDetailsListener(ActionListener listener) {
		viewButton.addActionListener(listener);
	}

	public void addBehandlungListener(ActionListener listener) {
		actionButton.addActionListener(listener);
	}

	public void addToWaitListListener(ActionListener listener) {
		addToWaitListButton.addActionListener(listener);
	}

	// Methode zum Abrufen des ausgewählten Zeilenindexes in der Tabelle
	public int getSelectedRowIndex() {
		return table.getSelectedRow();
	}

	// Methode zum Hinzufügen eines neuen Patienten mit Eingabefeldern
	public Patient addPatientNew(int id, Consumer<Patient> callback) {
		// Aktuelle Uhrzeit abrufen
		String currentHour = String.format("%02d", LocalTime.now().getHour());
		String currentMinute = String.format("%02d", LocalTime.now().getMinute());
		String currentTimeText = currentHour + ":" + currentMinute;

		// Neue JFrame erstellen, um Patientendetails einzugeben
		JFrame patientInfoFrame = new JFrame("Neuanlage Patient");
		JPanel infoPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 10, 5, 10);

		// Textfelder für die Patientendetails erstellen
		JTextField patName = new JTextField();
		JTextField patAge = new JTextField();
		JTextField patContDeta = new JTextField();
		JTextField patAdress = new JTextField();
		JTextField patPLZ = new JTextField();
		JTextField patTelephone = new JTextField();
		JTextField patMedical = new JTextField();
		JTextField patInsuranceNo = new JTextField();
		JTextField patInsuranceInstitute = new JTextField();
		JTextField patTime = new JTextField(currentTimeText);
		JTextField patPatientId = new JTextField(Integer.toString(id));

		// Felder und Labels dem infoPanel hinzufügen
		addFormField(infoPanel, "Name:", patName);
		addFormField(infoPanel, "Alter:", patAge);
		addFormField(infoPanel, "Kontaktdetails:", patContDeta);
		addFormField(infoPanel, "Adresse:", patAdress);
		addFormField(infoPanel, "PLZ:", patPLZ);
		addFormField(infoPanel, "Telefon:", patTelephone);
		addFormField(infoPanel, "Vorkrankheiten:", patMedical);
		addFormField(infoPanel, "Versicherungsnummer:", patInsuranceNo);
		addFormField(infoPanel, "Versicherungsinstitut:", patInsuranceInstitute);
		addFormField(infoPanel, "Terminzeitpunkt:", patTime);
		addFormField(infoPanel, "Patienten-ID:", patPatientId);
		// Buttons "Speichern" und "Abbrechen" erstellen
		JButton saveButton = new JButton("Speichern");
		JButton cancelButton = new JButton("Abbrechen");

		// Panel für die Buttons erstellen
		JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.add(saveButton);
		buttonPanel.add(cancelButton);

		// Neues Patientenobjekt für die Eingaben erstellen
		Patient patientToAdd = new Patient();

		// ActionListener für den "Speichern"-Button hinzufügen
		saveButton.addActionListener(e -> {
			// Alter des Patienten aus dem Textfeld abrufen und zu einem Integer parsen, falls möglich
			int alterInt;
			String alterString = patAge.getText();
			if (!alterString.isEmpty()) {
				try {
					alterInt = Integer.parseInt(alterString);
				} catch (NumberFormatException f) {
					alterInt = 0;
				}
			} else {
				alterInt = 0;
			}

			// Die Eingaben in das Patientenobjekt übertragen
			patientToAdd.setName(patName.getText());
			patientToAdd.setAge(alterInt);
			patientToAdd.setContactDetails(patContDeta.getText());
			patientToAdd.setAdress(patAdress.getText());
			patientToAdd.setPlz(patPLZ.getText());
			patientToAdd.setTelephone(patTelephone.getText());
			patientToAdd.setMedicalHistory(patMedical.getText());
			patientToAdd.setInsuranceNo(patInsuranceNo.getText());
			patientToAdd.setInsuranceInstitute(patInsuranceInstitute.getText());
			patientToAdd.setAppointmentTime(patTime.getText());
			patientToAdd.setPatientId(id);

			// Das Dialogfenster nach dem Speichern schließen
			patientInfoFrame.dispose();

			// Das Callback ausführen und das erstellte Patientenobjekt übergeben
			callback.accept(patientToAdd);
		});

		// ActionListener für den "Abbrechen"-Button hinzufügen
		cancelButton.addActionListener(e -> {
			// Das Dialogfenster ohne Speichern schließen
			patientInfoFrame.dispose();

			// Das Callback ausführen und das leere Patientenobjekt übergeben
			callback.accept(patientToAdd);
		});

		// Panel für den Hauptinhalt und die Buttons erstellen
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(infoPanel, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);

		// Die bevorzugte Breite für die JFrame festlegen
		int preferredWidth = 600; // Hier je nach gewünschter Breite anpassen
		patientInfoFrame.setPreferredSize(new Dimension(preferredWidth, 460));

		// Den Hauptinhalt in das Dialogfenster "patientInfoFrame" laden
		patientInfoFrame.add(mainPanel);
		patientInfoFrame.pack();
		patientInfoFrame.setLocationRelativeTo(null);
		patientInfoFrame.setVisible(true);

		// Das bearbeitete Objekt im "Speichern"-ActionListener zurückgeben
		return patientToAdd;
	}

	// Methode zum Bearbeiten der Patienteninformationen
	public void editPatientInfo(Patient patient, Consumer<Patient> callback) {
		// Neues JFrame erstellen, um die Patientendetails zu bearbeiten
		JFrame patientInfoFrame = new JFrame("Patienteninformationen bearbeiten");
		JPanel infoPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 10, 5, 10);

		// Textfelder für die Patientendetails erstellen und mit den entsprechenden Informationen füllen
		JTextField patName = new JTextField(patient.getName());
		JTextField patAge = new JTextField(String.valueOf(patient.getAge()));
		JTextField patContDeta = new JTextField(patient.getContactDetails());
		JTextField patAdress = new JTextField(patient.getAdress());
		JTextField patPLZ = new JTextField(String.valueOf(patient.getPlz()));
		JTextField patTelephone = new JTextField(String.valueOf(patient.getTelephone()));
		JTextField patMedical = new JTextField(patient.getMedicalHistory());
		JTextField patInsuranceNo = new JTextField(patient.getInsuranceNo());
		JTextField patInsuranceInstitute = new JTextField(patient.getInsuranceInstitute());
		JTextField patTime = new JTextField(patient.getAppointmentTime());
		JTextField patPatientId = new JTextField(String.valueOf(patient.getPatientId()));

		// nur PatientenID nicht editierbar machen (nur Anzeige)
		patPatientId.setEditable(false);

		// Felder und Labels dem infoPanel hinzufügen
		addFormField(infoPanel, "Name:", patName);
		addFormField(infoPanel, "Alter:", patAge);
		addFormField(infoPanel, "E-Mail:", patContDeta);
		addFormField(infoPanel, "Adresse:", patAdress);
		addFormField(infoPanel, "PLZ:", patPLZ);
		addFormField(infoPanel, "Telefon:", patTelephone);
		addFormField(infoPanel, "Vorkrankheiten:", patMedical);
		addFormField(infoPanel, "Versich. Nr.:", patInsuranceNo);
		addFormField(infoPanel, "Versich. Insit.:", patInsuranceInstitute);
		addFormField(infoPanel, "Termin:", patTime);
		addFormField(infoPanel, "Patienten-ID:", patPatientId);

		// Buttons "Speichern" und "Abbrechen" erstellen
		JButton saveButton = new JButton("Speichern");
		JButton cancelButton = new JButton("Abbrechen");

		// Panel für die Buttons erstellen
		JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.add(saveButton);
		buttonPanel.add(cancelButton);

		// ActionListener für den "Speichern"-Button hinzufügen
		saveButton.addActionListener(e -> {
			// Alter des Patienten aus dem Textfeld abrufen und zu einem Integer parsen, falls möglich
			int alterInt;
			String alterString = patAge.getText();
			if (!alterString.isEmpty()) {
				try {
					alterInt = Integer.parseInt(alterString);
				} catch (NumberFormatException f) {
					alterInt = 0;
				}
			} else {
				alterInt = 0;
			}

			// Die Eingaben in das Patientenobjekt übertragen
			patient.setName(patName.getText());
			patient.setAge(alterInt);
			patient.setContactDetails(patContDeta.getText());
			patient.setAdress(patAdress.getText());
			patient.setPlz(patPLZ.getText());
			patient.setTelephone(patTelephone.getText());
			patient.setInsuranceNo(patInsuranceNo.getText());
			patient.setInsuranceInstitute(patInsuranceInstitute.getText());
			patient.setAppointmentTime(patTime.getText());
			// Das Dialogfenster nach dem Speichern schließen
			patientInfoFrame.dispose();

			// Das Callback ausführen und das bearbeitete Patientenobjekt übergeben
			callback.accept(patient);
		});

		// ActionListener für den "Abbrechen"-Button hinzufügen
		cancelButton.addActionListener(e -> {
			// Das Dialogfenster ohne Speichern schließen
			patientInfoFrame.dispose();

			// Das Callback ausführen und das ursprüngliche Patientenobjekt ohne Änderungen übergeben
			callback.accept(patient);
		});

		// Panel für den Hauptinhalt und die Buttons erstellen
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(infoPanel, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);

		// Die bevorzugte Breite für die JFrame festlegen
		int preferredWidth = 600; // Hier je nach gewünschter Breite anpassen
		patientInfoFrame.setPreferredSize(new Dimension(preferredWidth, 460));

		// Den Hauptinhalt in das Dialogfenster "patientInfoFrame" laden
		patientInfoFrame.add(mainPanel);
		patientInfoFrame.pack();
		patientInfoFrame.setLocationRelativeTo(null);
		patientInfoFrame.setVisible(true);
	}

	// Methode zum Aktualisieren des Patienten mit den bearbeiteten Änderungen
	public void updatePatient(int rowIndex, Patient updatedPatient) {
		// Anzahl der Spalten im Tabellenmodell abrufen
		int numColumns = tableModel.getColumnCount();

		// Schleife durch jede Spalte in der Zeile und die entsprechenden Daten aktualisieren
		for (int colIndex = 0; colIndex < numColumns; colIndex++) {
			// Wert aus dem aktualisierten Patientenobjekt basierend auf dem Spaltenindex abrufen
			Object value;
			switch (colIndex) {
			case 0:
				value = updatedPatient.getName();
				break;
			case 1:
				value = updatedPatient.getAge();
				break;
			case 2:
				value = updatedPatient.getContactDetails();
				break;
			case 3:
				value = updatedPatient.getInsuranceNo();
				break;
			case 4:
				value = updatedPatient.getMedicalHistory();
				break;
			case 5:
				value = updatedPatient.getAppointmentTime();
				break;
			default:
				value = null; // Bei Bedarf zusätzliche Spalten behandeln
			}

			// Wert im Tabellenmodell aktualisieren
			tableModel.setValueAt(value, rowIndex, colIndex);
		}
	}

	// Methode zum Anzeigen der Patienteninformationen
	public void showPatientInfo(Patient patient) {
		// Neues JFrame-Fenster mit dem Titel "Patienteninformation" erstellen
		JFrame patientInfoFrame = new JFrame("Patienteninformation");
		// Neues JPanel mit GridBagLayout erstellen. Dieses Panel enthält die Patienteninformationen.
		JPanel infoPanel = new JPanel(new GridBagLayout());
		// Neues GridBagConstraints-Objekt erstellen, das die Einschränkungen für Komponenten festlegt, die mit GridBagLayout angeordnet werden.
		GridBagConstraints gbc = new GridBagConstraints();
		// Das Ankerfeld für das GridBagConstraints-Objekt auf WEST setzen. Dies bedeutet, dass Komponenten am linken Rand ihres Anzeigebereichs verankert werden.
		gbc.anchor = GridBagConstraints.WEST;
		// Die externen Abstände der Komponenten festlegen.
		gbc.insets = new Insets(5, 10, 5, 10);

		// Textfelder für jedes Attribut des Patientenobjekts erstellen und mit den entsprechenden Patienteninformationen initialisieren.
		JTextField patName = new JTextField(patient.getName());
		JTextField patAge = new JTextField(String.valueOf(patient.getAge()));
		JTextField patContDeta = new JTextField(patient.getContactDetails());
		JTextField patAdress = new JTextField(patient.getAdress());
		JTextField patPLZ = new JTextField(String.valueOf(patient.getPlz()));
		JTextField patTelephone = new JTextField(String.valueOf(patient.getTelephone()));
		JTextField patMedical = new JTextField(patient.getMedicalHistory());
		JTextField patInsuranceNo = new JTextField(patient.getInsuranceNo());
		JTextField patInsuranceInstitute = new JTextField(patient.getInsuranceInstitute());
		JTextField patTime = new JTextField(patient.getAppointmentTime());
		JTextField patPatientId = new JTextField(String.valueOf(patient.getPatientId()));

		// Alle Textfelder nicht editierbar machen (nur Anzeige)
		patName.setEditable(false);
		patAge.setEditable(false);
		patContDeta.setEditable(false);
		patAdress.setEditable(false);
		patPLZ.setEditable(false);
		patTelephone.setEditable(false);
		patMedical.setEditable(false);
		patInsuranceNo.setEditable(false);
		patInsuranceInstitute.setEditable(false);
		patTime.setEditable(false);
		patPatientId.setEditable(false);

		// Felder und Labels dem infoPanel hinzufügen, indem die Hilfsmethode "addFormField" verwendet wird.
		addFormField(infoPanel, "Name:", patName);
		addFormField(infoPanel, "Alter:", patAge);
		addFormField(infoPanel, "E-Mail:", patContDeta);
		addFormField(infoPanel, "Adresse:", patAdress);
		addFormField(infoPanel, "PLZ:", patPLZ);
		addFormField(infoPanel, "Telefon:", patTelephone);
		addFormField(infoPanel, "Vorkrankheiten:", patMedical);
		addFormField(infoPanel, "Versich. Nr.:", patInsuranceNo);
		addFormField(infoPanel, "Versich. Insit.:", patInsuranceInstitute);
		addFormField(infoPanel, "Termin:", patTime);
		addFormField(infoPanel, "Patienten-ID:", patPatientId);


		// Panel für den Hauptinhalt und den "OK"-Button erstellen
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(infoPanel, BorderLayout.CENTER);

		// Die bevorzugte Breite für das JFrame festlegen
		int preferredWidth = 600; // Hier je nach gewünschter Breite anpassen
		patientInfoFrame.setPreferredSize(new Dimension(preferredWidth, 420));

		// Alle Inhalte im JFrame "patientInfoFrame" laden
		patientInfoFrame.add(mainPanel);
		patientInfoFrame.pack();
		patientInfoFrame.setLocationRelativeTo(null);
		patientInfoFrame.setVisible(true);
	}

	// Hilfsmethode, die ein Textfeld und das entsprechende Label zu einem Panel mit GridBagLayout hinzufügt.
	private void addFormField(JPanel panel, String label, JTextField textField) {
		// Ein neues GridBagConstraints-Objekt erstellen.
		GridBagConstraints gbc = new GridBagConstraints();
		// Das Ankerfeld für das GridBagConstraints-Objekt auf WEST setzen.
		gbc.anchor = GridBagConstraints.WEST;
		// Die externen Abstände der Komponenten festlegen.
		gbc.insets = new Insets(5, 10, 5, 10);
		// Das gridx- und gridy-Feld setzen. Diese Werte geben die Zelle im Layoutraster an, in der die linke obere Ecke der Komponente platziert wird.
		gbc.gridx = 0;
		gbc.gridy = panel.getComponentCount();
		// Das Label zum Panel hinzufügen.
		panel.add(new JLabel(label), gbc);
		// Zur nächsten Zelle im Layoutraster wechseln.
		gbc.gridx = 1;
		// Das fill-Feld auf HORIZONTAL setzen. Dadurch wird der Anzeigebereich der Komponente horizontal, aber nicht vertikal ausgefüllt.
		gbc.fill = GridBagConstraints.HORIZONTAL;
		// Das weightx-Feld auf 1.0 setzen. Dadurch wird festgelegt, wie viel zusätzlicher horizontaler Platz der Komponente zugewiesen wird.
		gbc.weightx = 1.0;
		// Das Textfeld zum Panel hinzufügen.
		panel.add(textField, gbc);
	}
}


