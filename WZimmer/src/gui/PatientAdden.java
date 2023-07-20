package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;



//Adden von Patienten 
public class PatientAdden extends JFrame {

	//String vornameGlobal;
	//String nachnameGlobal;
	//String adresseGlobal;
	//String alterGlobal;
	//String versicherungGlobal;
	//String telefonnummerGlobal;
	
	//ActionListener speichernAction;
	
	
	
	
	public PatientAdden() {
        setTitle("Hinzufügen von Patient");
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
       // this.nachnameGlobal = nachnametext;
        

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

        // Uhrzeit eingabe
        JLabel uhrzeit = new JLabel("Uhrzeit");
        
        //Aktuelle Uhrzeit
        LocalTime currentTime = LocalTime.now();
        String currentHour = String.format("%02d", currentTime.getHour());
        String currentMinute = String.format("%02d", currentTime.getMinute());
        String currentTimeText = currentHour + ":" + currentMinute;
        
        
        JTextField uhrzeittext = new JTextField(currentTimeText);
        mainPanel.add(uhrzeit);
        mainPanel.add(uhrzeittext);
        
        
        JButton speichern = new JButton("Speichern");
        //ActionListener zum Speichern der Daten
        speichern.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		
        		 String vornameString = vornametext.getText();
        		 System.out.println(vornameString);
        		
        		 
        		 String nachnameString = nachnametext.getText();
        		 System.out.println(nachnameString);
        		 
        		 String adresseString = adressetext.getText();
        		 System.out.println(adresseString);
        		 
        		 String alterInt = altertext.getText();
        		 System.out.println(alterInt);
        		 
        		 String versicherungString = versicherungtext.getText();
        		 System.out.println(versicherungString);
        		 
        		 String telefonString = telefontext.getText();
        		 System.out.println(telefonString);
        		 
        		 String kontaktString = kontakttext.getText();
        		 System.out.println(kontaktString);
        		 
        		 String uhrzeitString = uhrzeittext.getText();
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
        
        
        mainPanel.add(speichern);
        mainPanel.add(löschen);

        //Setzt das Fenster in die Mitte
        setLocationRelativeTo(null);
        
        //Hinzufügen des Panels und sichbarkeit aktiviert
        add(mainPanel);
        setVisible(true);
    }
	        
	        
	
	
	
	
			

}
	
	
	
	
	
	
	
	

