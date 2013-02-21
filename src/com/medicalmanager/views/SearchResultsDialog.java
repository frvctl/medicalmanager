package com.medicalmanager.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.medicalmanager.models.Patient;

public class SearchResultsDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	//private JTable resultsTable;

	/**
	 * Create the dialog.
	 */
	public SearchResultsDialog(Patient[] pRay) {
		setBounds(100, 100, 565, 378);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
		);
		
		DefaultTableModel model = new DefaultTableModel();
		JTable resultsTable = new JTable(model);
		
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Severity");
		model.addColumn("Age");
		model.addColumn("Height");
		
		System.out.println(PatientView.patientArray);
		for(Patient p: PatientView.patientArray){
			model.addRow(new Object[]{p.getID(), p.getName(), "severe", p.getAge(), p.getHeight()});
			System.out.println("ADDINGROW");
		}
		
		model.addRow(new Object[]{"v1", "v2", "v3", "v4", "v5"});
		
		scrollPane.setViewportView(resultsTable);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
