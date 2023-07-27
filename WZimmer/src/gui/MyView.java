package gui;

//Class to configure the start screen "Patients"

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.util.function.Consumer;
import user.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalTime;

//This class extends JFrame, which means it represents a window that can be opened on the desktop.
public class MyView extends JFrame {
 // These are the class's fields. Each instance of MyView will have its own copy of these.
 private static final long serialVersionUID = 107214543984441388L;
	private DefaultTableModel tableModel;
 private JTable table;
 private JButton addButton;
 private JButton editButton;
 private JButton viewButton;
 private JButton actionButton;
 private JButton addToWaitListButton;
 private JButton openWaitListButton; //juju


 public MyView() {
     // Set the title of the window to "Patients"
     setTitle("Patients");
     // Set the default close operation. In this case, the application will exit when the window is closed.
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     // Set the size of the window to 1280x720 pixels.
     setSize(1280, 720);

     // The following code centers the window
     setLocationRelativeTo(null);

     // Make the window visible.
     this.setVisible(true);
 

     // Create a new DefaultTableModel, which is the data model for a JTable.
     tableModel = new DefaultTableModel() {
         private static final long serialVersionUID = 7613152197870578936L;

			@Override
         public boolean isCellEditable(int row, int column) {
             // This method overrides the default isCellEditable method to prevent cells from being edited.
             return false;
         }
     };

     // Add columns to the table model with the following names.
     tableModel.addColumn("Name");
     tableModel.addColumn("Age");
     tableModel.addColumn("Appointment Time");

     // Create a new JTable using the previously created table model.
     table = new JTable(tableModel);

     // Set the font and size of the table header.
     JTableHeader tableHeader = table.getTableHeader();
     Font headerFont = new Font("Verdana", Font.BOLD, 25);
     tableHeader.setFont(headerFont);
     tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(),50));

     // Set the font and size of the table rows.
     table.setFont(new Font("Serif", Font.PLAIN, 20));
     table.setRowHeight(table.getRowHeight()+ 10);

     // Create a JScrollPane containing the table. This allows the table to be scrolled.
     JScrollPane scrollPane = new JScrollPane(table);

     // Create buttons with the following labels.
     addButton = new JButton("Add Patient");
     editButton = new JButton("Edit Patient");
     viewButton = new JButton("View Details");
     actionButton = new JButton("Behandlung Abschliessen");
     addToWaitListButton = new JButton("Add to Waitlist");
     openWaitListButton = new JButton("Open Waitlist"); //juju


     // Create a JPanel to hold the buttons. This panel uses a FlowLayout, which arranges components in a directional flow.
     JPanel buttonPanel = new JPanel(new FlowLayout());
     // Add the buttons to the panel.
     buttonPanel.add(addButton);
     buttonPanel.add(editButton);
     buttonPanel.add(viewButton);
     buttonPanel.add(actionButton);
     buttonPanel.add(addToWaitListButton);
     buttonPanel.add(openWaitListButton); //juju


     // Set the layout manager of the window to BorderLayout, which arranges components to fit in five regions: north, south, east, west, and center.
     setLayout(new BorderLayout());
     // Add the scroll pane (containing the table) to the center region of the window.
     add(scrollPane, BorderLayout.CENTER);
     // Add the button panel to the south region of the window.
     add(buttonPanel, BorderLayout.SOUTH);
     
     // Make the window visible.
     this.setVisible(true);
 }



    
//Method to add a Patient object to the table model.
public void addPatient(Patient patient) {
  // Add a row to the table model using the patient's name, age, and appointment time.
  tableModel.addRow(new Object[]{patient.getName(), patient.getAge(), patient.getAppointmentTime()});
}

//Method to remove a Patient object from the table model.
public void removePatient(int patientID) {
  // Remove a row from the table model using the patient's ID.
  tableModel.removeRow(patientID);
}

//Methods to add action listeners to the buttons.
//An action listener performs an action when the corresponding button is clicked.
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

public void addOpenWaitListListener(ActionListener listener) {
	  openWaitListButton.addActionListener(listener);
	} // juju

  
//Helper method to get the index of the currently selected row in the table.
public int getSelectedRowIndex() {
  return table.getSelectedRow();
}

//Method to add a new patient to the system, this opens a new JFrame where user can input patient details
public Patient addPatientNew(int id, Consumer<Patient> callback) {
  // Fetch the current time.
  String currentHour = String.format("%02d", LocalTime.now().getHour());
  String currentMinute = String.format("%02d", LocalTime.now().getMinute());
  String currentTimeText = currentHour + ":" + currentMinute;
  
  // Create a new JFrame to collect patient details.
  JFrame patientInfoFrame = new JFrame("Neuanlage Patient");
  JPanel infoPanel = new JPanel(new GridBagLayout());

  // Setup constraints for the layout.
  GridBagConstraints gbc = new GridBagConstraints();
  gbc.anchor = GridBagConstraints.WEST;
  gbc.insets = new Insets(5, 10, 5, 10);

  // Initialize the text fields.
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
  
  // Add these fields to the info panel.
  addFormField(infoPanel, "Name:", patName);
  addFormField(infoPanel, "Age:", patAge);
  addFormField(infoPanel, "Contact Information:", patContDeta);
  addFormField(infoPanel, "Adress:", patAdress);
  addFormField(infoPanel, "PLZ:", patPLZ);
  addFormField(infoPanel, "Telephone:", patTelephone);
  addFormField(infoPanel, "Medical History:", patMedical);
  addFormField(infoPanel, "Insurance No:", patInsuranceNo);
  addFormField(infoPanel, "Insurance Institute:", patInsuranceInstitute);
  addFormField(infoPanel, "Appointment Time:", patTime);
  addFormField(infoPanel, "Patient ID:", patPatientId);
  
  // Create the buttons.
  JButton saveButton = new JButton("Save");
  JButton cancelButton = new JButton("Cancel");

  // Panel to hold the buttons.
  JPanel buttonPanel = new JPanel(new FlowLayout());
  buttonPanel.add(saveButton);
  buttonPanel.add(cancelButton);
  
  Patient patientToAdd = new Patient();

  // Listener for the Save button.
  saveButton.addActionListener(e -> {
      // Check if the Age field is not empty and parse it to an integer, if it fails, default to 0.
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
      };
      
      // Set patientToAdd fields with the information from the text fields.
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

      // Close the dialog after saving the data.
      patientInfoFrame.dispose();

      // Call the callback function with the patientToAdd object.
      callback.accept(patientToAdd);
  });

  // Listener for the Cancel button.
  cancelButton.addActionListener(e -> {
      // Close the dialog without saving any data.
      patientInfoFrame.dispose();

      // Call the callback function with the patientToAdd object.
      callback.accept(patientToAdd);
  });
  

  // Panel to hold the main content and the buttons.
  JPanel mainPanel = new JPanel(new BorderLayout());
  mainPanel.add(infoPanel, BorderLayout.CENTER);
  mainPanel.add(buttonPanel, BorderLayout.SOUTH);
  
  // Set the preferred width for the JFrame.
  int preferredWidth = 600; // Adjust this value to your desired width.
  patientInfoFrame.setPreferredSize(new Dimension(preferredWidth, 460));

  // Load all of the mainPanel information into the patientInfoFrame.
  patientInfoFrame.add(mainPanel);
  patientInfoFrame.pack();
  patientInfoFrame.setLocationRelativeTo(null);
  patientInfoFrame.setVisible(true);
 
  // Return the edited object within the save action listener.
  return patientToAdd;
  }









public void editPatientInfo(Patient patient, Consumer<Patient> callback) {

    // Create a new JFrame to collect patient details.
    JFrame patientInfoFrame = new JFrame("Edit Patient Information");
    JPanel infoPanel = new JPanel(new GridBagLayout());

    // Setup constraints for the layout.
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.anchor = GridBagConstraints.WEST;
    gbc.insets = new Insets(5, 10, 5, 10);

    // Define text fields for each attribute of the Patient object. The text fields are initialized with the corresponding patient information.
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

    // Add these fields to the info panel.
    addFormField(infoPanel, "Name:", patName);
    addFormField(infoPanel, "Age:", patAge);
    addFormField(infoPanel, "Contact Information:", patContDeta);
    addFormField(infoPanel, "Adress:", patAdress);
    addFormField(infoPanel, "PLZ:", patPLZ);
    addFormField(infoPanel, "Telephone:", patTelephone);
    addFormField(infoPanel, "Medical History:", patMedical);
    addFormField(infoPanel, "Insurance No:", patInsuranceNo);
    addFormField(infoPanel, "Insurance Institute:", patInsuranceInstitute);
    addFormField(infoPanel, "Appointment Time:", patTime);
    addFormField(infoPanel, "Patient ID:", patPatientId);

    // Create the Save and Cancel buttons.
    JButton saveButton = new JButton("Save");
    JButton cancelButton = new JButton("Cancel");

    // Panel to hold the buttons.
    JPanel buttonPanel = new JPanel(new FlowLayout());
    buttonPanel.add(saveButton);
    buttonPanel.add(cancelButton);

    // Listener for the Save button.
    saveButton.addActionListener(e -> {
        // Check if the Age field is not empty and parse it to an integer, if it fails, default to 0.
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

        // Update the fields of the existing patient object with the information from the text fields.
        patient.setName(patName.getText());
        patient.setAge(alterInt);
        patient.setContactDetails(patContDeta.getText());
        patient.setAdress(patAdress.getText());
        patient.setPlz(patPLZ.getText());
        patient.setTelephone(patTelephone.getText());
        patient.setMedicalHistory(patMedical.getText());
        patient.setInsuranceNo(patInsuranceNo.getText());
        patient.setInsuranceInstitute(patInsuranceInstitute.getText());
        patient.setAppointmentTime(patTime.getText());

        // Close the dialog after saving the data.
        patientInfoFrame.dispose();

        // Call the callback function with the modified patient object.
        callback.accept(patient);
    });

    // Listener for the Cancel button.
    cancelButton.addActionListener(e -> {
        // Close the dialog without saving any data.
        patientInfoFrame.dispose();

        // Call the callback function with the original patient object without any changes.
        callback.accept(patient);
    });

    // Panel to hold the main content (infoPanel) and the buttons.
    JPanel mainPanel = new JPanel(new BorderLayout());
    mainPanel.add(infoPanel, BorderLayout.CENTER);
    mainPanel.add(buttonPanel, BorderLayout.SOUTH);

    // Set the preferred width for the JFrame.
    int preferredWidth = 600; // Adjust this value to your desired width.
    patientInfoFrame.setPreferredSize(new Dimension(preferredWidth, 460));

    // Load all of the mainPanel information into the patientInfoFrame.
    patientInfoFrame.add(mainPanel);
    patientInfoFrame.pack();
    patientInfoFrame.setLocationRelativeTo(null);
    patientInfoFrame.setVisible(true);
}

//Method to update the patient, with the edited changes. 
public void updatePatient(int rowIndex, Patient updatedPatient) {
    // Get the number of columns in the table model.
    int numColumns = tableModel.getColumnCount();

    // Loop through each column in the row and update the corresponding data.
    for (int colIndex = 0; colIndex < numColumns; colIndex++) {
        // Get the value from the updatedPatient object based on the column index.
        Object value;
        switch (colIndex) {
            case 0:
                value = updatedPatient.getName();
                break;
            case 1:
                value = updatedPatient.getAge();
                break;
            case 2:
                value = updatedPatient.getAppointmentTime();
                break;
            default:
                value = null; // Handle additional columns if necessary.
        }

        // Update the value in the table model.
        tableModel.setValueAt(value, rowIndex, colIndex);
    }
}











//Here we define a method called "showPatientInfo". The method receives a Patient object as an argument.
public void showPatientInfo(Patient patient) {
 // Create a new JFrame window with the title "Patient Information"
 JFrame patientInfoFrame = new JFrame("Patient Information");
 // Create a new JPanel with a GridBagLayout. This panel will contain the patient information.
 JPanel infoPanel = new JPanel(new GridBagLayout());
 // Create a GridBagConstraints object which defines constraints for components that are laid out using the GridBagLayout.
 GridBagConstraints gbc = new GridBagConstraints();
 // Set the anchor for the GridBagConstraints object to WEST. This means components will be anchored to the left side of their display area.
 gbc.anchor = GridBagConstraints.WEST;
 // Define the external padding of the components. The Insets specify the space that a component must leave at each of its edges. The space is measured in pixels.
 gbc.insets = new Insets(5, 10, 5, 10);

 // Define text fields for each attribute of the Patient object. The text fields are initialized with the corresponding patient information.
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

 // Make all the text fields non-editable. This is typically done for display-only fields.
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

 // Add the fields and labels to the infoPanel using the helper method "addFormField"
 addFormField(infoPanel, "Name:", patName);
 addFormField(infoPanel, "Age:", patAge);
 addFormField(infoPanel, "Contact Information:", patContDeta);
 addFormField(infoPanel, "Adress:", patAdress);
 addFormField(infoPanel, "PLZ:", patPLZ);
 addFormField(infoPanel, "Telephone:", patTelephone);
 addFormField(infoPanel, "Medical History:", patMedical);
 addFormField(infoPanel, "Insurance No:", patInsuranceNo);
 addFormField(infoPanel, "Insurance Institute:", patInsuranceInstitute);
 addFormField(infoPanel, "Appointment Time:", patTime);
 addFormField(infoPanel, "Patient ID:", patPatientId);

 // Set the preferred width for the JFrame
 int preferredWidth = 600; // Adjust this value to your desired width
 patientInfoFrame.setPreferredSize(new Dimension(preferredWidth, 420));

 // Add the infoPanel to the patientInfoFrame. This includes all of the labels and text fields.
 patientInfoFrame.add(infoPanel);
 // Pack the components within the JFrame. This means sizes will be calculated to display the components as neatly as possible.
 patientInfoFrame.pack();
 // Set the location of the JFrame to the center of the screen.
 patientInfoFrame.setLocationRelativeTo(null);
 // Make the JFrame visible.
 patientInfoFrame.setVisible(true);
}

//Define a helper method that adds a text field and its corresponding label to a panel with GridBagLayout.
private void addFormField(JPanel panel, String label, JTextField textField) {
 // Create a GridBagConstraints object.
 GridBagConstraints gbc = new GridBagConstraints();
 // Set the anchor for the GridBagConstraints object to WEST.
 gbc.anchor = GridBagConstraints.WEST;
 // Define the external padding of the components.
 gbc.insets = new Insets(5, 10, 5, 10);
 // Set the gridx and gridy fields. These specify the cell in the layout grid where the top-left corner of the component is to be placed.
 gbc.gridx = 0;
 gbc.gridy = panel.getComponentCount();
 // Add the label to the panel.
 panel.add(new JLabel(label), gbc);

 // Move to the next cell in the layout grid.
 gbc.gridx = 1;
 // Set the fill field to HORIZONTAL. This means that the component's display area will be made wide enough to fill its display area horizontally, but not vertically.
 gbc.fill = GridBagConstraints.HORIZONTAL;
 // Set the weightx field to 1.0. This determines how much extra horizontal space is allocated to the component.
 gbc.weightx = 1.0;
 // Add the text field to the panel.
 panel.add(textField, gbc);
	}
}