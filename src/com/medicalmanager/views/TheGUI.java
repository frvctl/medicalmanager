package com.medicalmanager.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JList;
import java.awt.Dimension;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TheGUI extends JFrame {

	private CardLayout card = new CardLayout(0,0);
	private JPanel contentPane;
	private JButton mainAppButton;
	private JButton aboutButton;
	private JButton newPatientButton;
	private JButton searchButton;

	/**
	 * Create the frame.
	 */
	public TheGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 838, 609);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(card);
		
		setContentPane(contentPane);
		
		placeMenu();
		makeWelcomePanel();
		makePatientPanel();
		actionTime();
		
	}

	public void placeMenu(){
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("New menu");
		menuBar.add(fileMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		fileMenu.add(mntmNewMenuItem);
		
		JMenu helpMenu = new JMenu("New menu");
		menuBar.add(helpMenu);
		
		JMenuItem menuItem = new JMenuItem("New menu item");
		helpMenu.add(menuItem);
		
	}
	
	public void makePatientPanel(){
		JPanel patientPanel = new JPanel();
		contentPane.add(patientPanel, "patientPanel");

		JSplitPane splitPane = new JSplitPane();
		
		JToolBar patientToolBar = new JToolBar();
		GroupLayout patientLayout = new GroupLayout(patientPanel);
		patientLayout.setHorizontalGroup(
			patientLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(splitPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
				.addComponent(patientToolBar, GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
		);
		patientLayout.setVerticalGroup(
			patientLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, patientLayout.createSequentialGroup()
					.addComponent(patientToolBar, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE))
		);
		
		newPatientButton = new JButton("New Patient");

		patientToolBar.add(newPatientButton);
		
		searchButton = new JButton("Search");

		patientToolBar.add(searchButton);
		
		JList patientList = new JList();
		patientList.setMinimumSize(new Dimension(200, 0));
		splitPane.setLeftComponent(patientList);
		
		JTextArea patientInfoArea = new JTextArea();
		splitPane.setRightComponent(patientInfoArea);
		patientPanel.setLayout(patientLayout);
	}
	
	public void makeWelcomePanel(){
		JPanel welcomePanel = new JPanel();
		contentPane.add(welcomePanel, "welcomePanel");
		card.show(contentPane, "welcomePanel");
		
		JLabel welcomeLabel = new JLabel("Welcome to the application");
		
		mainAppButton = new JButton("Main App");

		
		aboutButton = new JButton("About");
		
		JLabel createdByLabel = new JLabel("Created By: Ben Vest");
		GroupLayout welcomeLayout = new GroupLayout(welcomePanel);
		welcomeLayout.setHorizontalGroup(
			welcomeLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(welcomeLayout.createSequentialGroup()
					.addGap(305)
					.addComponent(mainAppButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(aboutButton)
					.addContainerGap(363, Short.MAX_VALUE))
				.addGroup(welcomeLayout.createSequentialGroup()
					.addGap(313)
					.addComponent(welcomeLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(355))
				.addGroup(Alignment.TRAILING, welcomeLayout.createSequentialGroup()
					.addContainerGap(363, Short.MAX_VALUE)
					.addComponent(createdByLabel)
					.addGap(346))
		);
		welcomeLayout.setVerticalGroup(
			welcomeLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(welcomeLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(welcomeLabel)
					.addGap(30)
					.addGroup(welcomeLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(aboutButton)
						.addComponent(mainAppButton))
					.addPreferredGap(ComponentPlacement.RELATED, 437, Short.MAX_VALUE)
					.addComponent(createdByLabel)
					.addContainerGap())
		);
		welcomePanel.setLayout(welcomeLayout);
	}
	
	public void actionTime(){
		mainAppButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.next(contentPane);
			}
		});
		
		newPatientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewPatient newUsar = new NewPatient();
				newUsar.setVisible(true);
			}
		});
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search dialog = new Search();
				dialog.setVisible(true);
			}
		});
	}
}
