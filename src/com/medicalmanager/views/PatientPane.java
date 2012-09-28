package com.medicalmanager.views;

import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.medicalmanager.models.Patient;

@SuppressWarnings("serial")
public class PatientPane extends JPanel {
	private JList patientList;
	private JTextArea infoArea;
	public static DefaultListModel listModel;

	/**
	 * Create the panel.
	 */
	public PatientPane() {
		
		
		JSplitPane patientPane_1 = new JSplitPane();
		GroupLayout gl_contentPane = new GroupLayout(TheGUI.contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(TheGUI.toolBar, GroupLayout.PREFERRED_SIZE, 1250, GroupLayout.PREFERRED_SIZE)
				.addComponent(patientPane_1, GroupLayout.DEFAULT_SIZE, 1250, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(TheGUI.toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(patientPane_1, GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE))
		);
		
		infoArea = new JTextArea();
		patientPane_1.setRightComponent(infoArea);
		listModel = new DefaultListModel<Object>();
		patientList = new JList(listModel);
		
		int theSize = TheGUI.patientRay.size();
		
		for(int i = 0; i < theSize; i++){
			listModel.addElement(TheGUI.patientRay.get(i).getName());
		}
		
		patientList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				Patient rawr = TheGUI.patientRay.get(patientList.getSelectedIndex());
				infoArea.setText("AGE: " + rawr.getAge() + "\n" 
										 + "Name: " + rawr.getName() + "\n"  
										 + "HEIGHT: " + rawr.getHeight() + "\n" 
										 + "DOB: " + rawr.getDOB());
			}
		});
		
		patientList.setMinimumSize(new Dimension(200, 0));
		patientPane_1.setLeftComponent(patientList);
		TheGUI.contentPane.setLayout(gl_contentPane);

	}

}
