package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import javax.swing.*;

//Neuanlage von Patienten
//Anlagebox und

//nicht mehr benutzt
public class DEL_PatientAdden extends JFrame {
	String vornameGlobal;
	String nachnameGlobal;
	String adresseGlobal;
	int alterGlobal;
	String telefonGlobal;
	String versicherungGlobal;
	String kontaktGlobal;
	String zeitGlobal;
	
	//ActionListener speichernAction;
	public DEL_PatientAdden() {
        setTitle("Neuanlage Patient");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);

        // Erzeugt einen Pannel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Vorname eingabe
        JLabel vorname = new JLabel("Vorname:");
        JTextField vornametext = new JTextField();
        mainPanel.add(vorname);
        mainPanel.add(vornametext);

        // Nachname eingabe
        JLabel nachname = new JLabel("Nachname:");
        JTextField nachnametext = new JTextField();
        mainPanel.add(nachname);
        mainPanel.add(nachnametext);

        // Adresse eingabe
        JLabel adresse = new JLabel("Adresse:");
        JTextField adressetext = new JTextField();
        mainPanel.add(adresse);
        mainPanel.add(adressetext);

        // Alter eingabe
        JLabel alter = new JLabel("Alter:");
        JTextField altertext = new JTextField();
        mainPanel.add(alter);
        mainPanel.add(altertext);

        // Versicherung eingabe
        JLabel versicherung = new JLabel("Versicherung");
        JTextField versicherungtext = new JTextField();
        mainPanel.add(versicherung);
        mainPanel.add(versicherungtext);

        // Telefonnummer eingabe
        JLabel telefonnummer = new JLabel("Telefonnummer:");
        JTextField telefontext = new JTextField();
        mainPanel.add(telefonnummer);
        mainPanel.add(telefontext);

        // Kontaktinformationen eingabe
        JLabel kontaktinformation = new JLabel("E-Mail:");
        JTextField kontakttext = new JTextField();
        mainPanel.add(kontaktinformation);
        mainPanel.add(kontakttext);

        // Uhrzeit wird automatisch vom Computer gezogen werden. 
        JLabel uhrzeit = new JLabel("Uhrzeit");
        
        //Aktuelle Uhrzeit
        LocalTime currentTime = LocalTime.now();
        String currentHour = String.format("%02d", currentTime.getHour());
        String currentMinute = String.format("%02d", currentTime.getMinute());
        String currentTimeText = currentHour + ":" + currentMinute;
        
        JTextField uhrzeittext = new JTextField(currentTimeText);
        mainPanel.add(uhrzeit);
        mainPanel.add(uhrzeittext);
        
        
        //ActionListener zum Speichern der Daten
        JButton speichern = new JButton("Speichern");
        speichern.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		
        		 String vornameString = vornametext.getText();
        		 vornameGlobal = vornameString;
        		 System.out.println(vornameString);
        		
        		 
        		 String nachnameString = nachnametext.getText();
        		 nachnameGlobal = nachnameString;
        		 System.out.println(nachnameString);
        		 
        		 String adresseString = adressetext.getText();
        		 adresseGlobal = adresseString;
        		 System.out.println(adresseString);
        		 
        		 //Es gibt leere Strings, aber keine leeren Integer.
        		 String alterInt = altertext.getText();
        		 if (!alterInt.isEmpty()) {
        		     int alterInt1 = Integer.parseInt(alterInt);
        		     alterGlobal = alterInt1;
        		     System.out.println(alterInt1);
        		 } else {
        		     int alterInt1 = 0;
        		     alterGlobal = alterInt1;
        		     System.out.println(alterInt1);
        		 }
        		 
        		 String versicherungString = versicherungtext.getText();
        		 versicherungGlobal = versicherungString;
        		 System.out.println(versicherungString);
        		 
        		 String telefonString = telefontext.getText();
        		 telefonGlobal = telefonString;
        		 System.out.println(telefonString);
        		 
        		 String kontaktString = kontakttext.getText();
        		 kontaktGlobal = kontaktString;
        		 System.out.println(kontaktString);
        		 
        		 String uhrzeitString = uhrzeittext.getText();
        		 zeitGlobal = uhrzeitString;
        		 System.out.println(uhrzeitString);		
        	}
        });
        
        	
        //Löschknopf mit seiner Funktion
        JButton löschen = new JButton("Löschen");
        
        löschen.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		
        		vornametext.setText("");
        		nachnametext.setText("");
        		adressetext.setText("");
        		altertext.setText("");
        		versicherungtext.setText("");
        		telefontext.setText("");
        		kontakttext.setText("");
        	}
        });
        
        
        //Speichern und Löschen werden auf das Panel eingefügt. 
        mainPanel.add(speichern);
        mainPanel.add(löschen);

        //Setzt das Fenster in die Mitte
        setLocationRelativeTo(null);
        
        //Hinzufügen des Panels und sichbarkeit aktiviert
        add(mainPanel);
        setVisible(true);
    }
	        
	        
	
		

}
	
	
	
	
	
	
	
	

