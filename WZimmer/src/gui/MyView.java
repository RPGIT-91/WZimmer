package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import user.*;

import java.awt.*;
import java.awt.event.ActionListener;

public class MyView extends JFrame {
    private static final long serialVersionUID = 107214543984441388L;
	private DefaultTableModel tableModel;
    private JTable table;
    private JButton addButton;
    private JButton editButton;
    private JButton viewButton;
    private JButton addToWaitListButton;

    public MyView() {
        // Set up the frame
        setTitle("Waiting Room");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);

        // Create the table model
        tableModel = new DefaultTableModel() {
            private static final long serialVersionUID = 7613152197870578936L;

			@Override
            public boolean isCellEditable(int row, int column) {
                // Disable cell editing
                return false;
            }
        };

        tableModel.addColumn("Name");
        tableModel.addColumn("Age");
        tableModel.addColumn("Appointment Time");


        // Create the table
        table = new JTable(tableModel);
        JTableHeader tableHeader = table.getTableHeader();
        Font headerFont = new Font("Verdana", Font.BOLD, 25);
        tableHeader.setFont(headerFont);
        tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(),50));

        table.setFont(new Font("Serif", Font.PLAIN, 20));
        table.setRowHeight(table.getRowHeight()+ 10);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        // Create the buttons
        addButton = new JButton("Add Patient");
        editButton = new JButton("Edit Patient");
        viewButton = new JButton("View Details");
        addToWaitListButton = new JButton("Add to Waitlist");

        // Create a panel for the buttons and set its layout to FlowLayout
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(addToWaitListButton);

        // Set the layout to BorderLayout
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void addPatient(Patient patient) {
        tableModel.addRow(new Object[]{patient.getName(), patient.getAge(), patient.getAppointmentTime()});
    }

    public void addAddPatientListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void addEditPatientListener(ActionListener listener) {
        editButton.addActionListener(listener);
    }

    public void addViewDetailsListener(ActionListener listener) {
        viewButton.addActionListener(listener);
    }

    //method to determine whether an entry has been selected
    public int getSelectedRowIndex() {
        return table.getSelectedRow();
    }

    //Other Boxes
    public void showPatientInfo(Patient patient) {
        JFrame patientInfoFrame = new JFrame("Patient Information");
        JPanel infoPanel = new JPanel(new GridLayout(5, 2));

        JTextField patName = new JTextField(patient.getName());
        JTextField patAge = new JTextField(String.valueOf(patient.getAge()));
        JTextField patContDeta = new JTextField(patient.getContactDetails());
        JTextField patMedical = new JTextField(patient.getMedicalHistory());
        JTextField patTime = new JTextField(patient.getAppointmentTime());

        infoPanel.add(new JLabel("Name: "));
        patName.setEditable(false);
        infoPanel.add(patName);

        infoPanel.add(new JLabel("Age: "));
        patAge.setEditable(false);
        infoPanel.add(patAge);

        infoPanel.add(new JLabel("Contact Information: "));
        patContDeta.setEditable(false);
        infoPanel.add(patContDeta);

        infoPanel.add(new JLabel("Medical History: "));
        patMedical.setEditable(false);
        infoPanel.add(patMedical);

        infoPanel.add(new JLabel("Appointment Time: "));
        patTime.setEditable(false);
        infoPanel.add(patTime);


        //set background colour to black
        patientInfoFrame.setBackground(Color.black);
        patientInfoFrame.add(infoPanel);
        patientInfoFrame.pack();
        patientInfoFrame.setLocationRelativeTo(null);
        //patientInfoFrame.setSize(640, 480);
        patientInfoFrame.setVisible(true);
    }
}