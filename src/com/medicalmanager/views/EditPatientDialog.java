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
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

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

		tableModel.addColumn("Key");
		tableModel.addColumn("Value");
		
		if (PatientView.getSelected() != null){
			tableModel.addRow(new Object[]{"Name", PatientView.getSelected().getName()});
			tableModel.addRow(new Object[]{"Age", PatientView.getSelected().getAge()});
			tableModel.addRow(new Object[]{"Height", PatientView.getSelected().getHeight()});
			tableModel.addRow(new Object[]{"Weight", PatientView.getSelected().getWeight()});
			tableModel.addRow(new Object[]{"BMI", PatientView.getSelected().getCalculatedBMI()});
		
		}
		table.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
		tableModel.addTableModelListener(new TableModelListener(){
			@Override
			public void tableChanged(TableModelEvent arg0) {
				int row = arg0.getFirstRow();
				int column = arg0.getColumn();
				Object data = tableModel.getValueAt(0, 1);
				System.out.println(data);
			}
		});
	
//		  table.setCellSelectionEnabled(true);
//		  ListSelectionModel cellSelectionModel = table.getSelectionModel();
//		  cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//			
//		  cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
//			  public void valueChanged(ListSelectionEvent e) {
//				  tableModel.fireTableDataChanged();
//				  String selectedData = null;
//			
//				  int[] selectedRow = table.getSelectedRows();
//				  int[] selectedColumns = table.getSelectedColumns();
//			
//				  for (int i = 0; i < selectedRow.length; i++) {
//					  for (int j = 0; j < selectedColumns.length; j++) {
//						  selectedData = (String) table.getValueAt(selectedRow[i], selectedColumns[j]);
//					  }
//				  }
//				  System.out.println("Selected: " + selectedData);
//			  }
//			});
				
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
						Vector data = tableModel.getDataVector();
						System.out.println(table.getValueAt(0, 1));
						System.out.println(data);
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
}
