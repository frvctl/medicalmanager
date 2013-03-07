package com.medicalmanager.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.medicalmanager.models.Patient;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Displays the results of a search in a JTable.
 * 
 * @school: Annandale High School
 * @IDE: Eclipse
 * @date: 3/6/2013
 * @author Ben Vest
 *
 */
public class SearchResultsDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	//private JTable resultsTable;

	/**
	 * Create the dialog.
	 */
	public SearchResultsDialog(Patient[] pRay) {
		setTitle("Search Results");
		setBounds(100, 100, 565, 378);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JScrollPane resultsScrollPane = new JScrollPane();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(resultsScrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(resultsScrollPane, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
		);
		
		DefaultTableModel model = new DefaultTableModel();
		JTable resultsTable = new JTable(model);
		
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Severity");
		model.addColumn("Age");
		model.addColumn("Height");
			
		try{
			for(Patient p: pRay){
				model.addRow(new Object[]{p.getID(), p.getFullName(), "severe", p.getAge(), p.getHeight()});
			}
		}catch(NullPointerException e){
			System.out.println(e);
		}
		
		resultsScrollPane.setViewportView(resultsTable);
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
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						SearchResultsDialog.this.setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
