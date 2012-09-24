package com.medicalmanager.views;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class WelcomePane extends JPanel {

	/**
	 * Create the panel.
	 */
	public WelcomePane() {
		
		JTextArea textArea = new JTextArea();
		GroupLayout groupLayout = new GroupLayout(TheGUI.contentPane);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(4)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
		);
		TheGUI.contentPane.setLayout(groupLayout);

	}
}
