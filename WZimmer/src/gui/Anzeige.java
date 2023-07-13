//Anzeige Wartezimmer

package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import user.*;

import java.awt.*;
import java.awt.event.ActionListener;

public class Anzeige extends JFrame{
	//Wartezimmer Anzeige
	
	
    // Set up the frame
    private static final long serialVersionUID = 1L;
	private DefaultTableModel tableModel;
	private JTable table;
    
    public Anzeige() {
	setTitle("Waiting Room");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);

        // Create the table model
        tableModel = new DefaultTableModel() {
            private static final long serialVersionUID = 7613152197870578937L;

			@Override
            public boolean isCellEditable(int row, int column) {
                // Disable cell editing
                return false;
            }
        };
        tableModel.addColumn("Name");
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
        JScrollPane scrollPane2 = new JScrollPane(table);
        
        JPanel waitPanel = new JPanel(new GridLayout(1,2));
        
        waitPanel.add(new JLabel("Currently Waiting: "));
        waitPanel.add(table);
        // Create a panel for the buttons and set its layout to FlowLayout

        // Set the layout to BorderLayout
        setLayout(new BorderLayout());
        add(scrollPane2, BorderLayout.CENTER);
        add(waitPanel, BorderLayout.SOUTH);
        
        this.setVisible(true);
    }
}
