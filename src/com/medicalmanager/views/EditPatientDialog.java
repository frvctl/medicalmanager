package com.medicalmanager.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import com.medicalmanager.controllers.Database;

public class EditPatientDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel tableModel = new DefaultTableModel();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EditPatientDialog dialog = new EditPatientDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EditPatientDialog() {
		setBounds(100, 100, 531, 543);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(2)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE))
		);
		
		table = new JTable(tableModel);
		
		if(tableModel.getRowCount() > 0){
			updateTable();
		}else{
			instantiateTable();
		}
		
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Database.updatePatient(PatientView.getSelected(), compileEditedData(), PatientView.patientArray);
					}
				});
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
	
	public void updateTable(){
		tableModel.setValueAt(PatientView.getSelected().getName(), 0, 1);
		tableModel.setValueAt(PatientView.getSelected().getAge(), 1, 1);
		tableModel.setValueAt(PatientView.getSelected().getHeight(), 2, 1);
		tableModel.setValueAt(PatientView.getSelected().getWeight(), 3, 1);
		tableModel.setValueAt(PatientView.getSelected().getCalculatedBMI(), 4, 1);
	}
	
	public void instantiateTable(){
		tableModel.addColumn("Key");
		tableModel.addColumn("Value");
		
		if (PatientView.getSelected() != null){
			tableModel.addRow(new Object[]{"Name", PatientView.getSelected().getName()});
			tableModel.addRow(new Object[]{"Age", PatientView.getSelected().getAge()});
			tableModel.addRow(new Object[]{"Height", PatientView.getSelected().getHeight()});
			tableModel.addRow(new Object[]{"Weight", PatientView.getSelected().getWeight()});
			tableModel.addRow(new Object[]{"BMI", PatientView.getSelected().getCalculatedBMI()});
		}
		
		// Allows you to get updated values without changing the focus of the cell via button event
		table.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
	}
	
	public String[] compileEditedData(){
		String arr[] = new String[tableModel.getRowCount()];
		for(int x = 0; x < tableModel.getRowCount(); x++){
			arr[x] = tableModel.getValueAt(x, 1).toString();
		}
		
		return arr;
	}
}
