package com.medicalmanager.views;

import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class PatientPane extends JPanel {
	private JList<?> patientList;
	private JTextArea infoArea;

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
		
		patientList = new JList<Object>();
		patientList.setMinimumSize(new Dimension(200, 0));
		patientPane_1.setLeftComponent(patientList);
		TheGUI.contentPane.setLayout(gl_contentPane);

	}

}
