package com.medicalmanager.views;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class WelcomePane extends JPanel {

	public static JButton engageTutorialButton;
	public static JButton engageInformationButton;
	public static JButton engageMainApplicationButton;

	/**
	 * Create the panel.
	 */
	public WelcomePane() {
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Medical Manager Application");
		JLabel lblCreatedByBen = new JLabel("Created by Ben Vest");
		
		engageTutorialButton = new JButton("Tutorial");
		engageInformationButton = new JButton("Information");
		engageMainApplicationButton = new JButton("Continue to Main Applicatino");
	
		GroupLayout groupLayout = new GroupLayout(TheGUI.contentPane);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(157)
							.addComponent(lblCreatedByBen))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(105)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(engageTutorialButton)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(engageInformationButton))
								.addComponent(lblWelcomeToThe)
								.addComponent(engageMainApplicationButton))))
					.addContainerGap(132, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWelcomeToThe)
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(engageTutorialButton)
						.addComponent(engageInformationButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(engageMainApplicationButton)
					.addPreferredGap(ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
					.addComponent(lblCreatedByBen)
					.addContainerGap())
		);
		TheGUI.contentPane.setLayout(groupLayout);

	}
}
