package com.medicalmanager.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import com.medicalmanager.models.Patient;

@SuppressWarnings("serial")
public class TheGUI extends JFrame {
	private ArrayList<Patient> patietRay = new ArrayList<Patient>();
	
	public static JPanel contentPane;
	public static JToolBar toolBar;
	
	private WelcomePane welcomePane;
	private PatientPane patientPane;
	
	private JMenuBar menuBar;
	
	private JMenu menuFileButton;
	private JMenu menuAboutButton;
	private JMenu menuHelpButton;
	
	private JMenuItem fileSubNewPatient;
	private JMenuItem fileSubSavePatient;
	private JMenuItem fileSubSearchPatient;
	private JMenuItem fileSubClose;
	private JMenuItem menuSubWhoIAm;
	private JMenuItem menuSubWelcome;
	
	private JButton toolBarNewUserButton;
	private JButton toolBarSaveUserButton;
	private JButton toolBarLoadUserButton;
	private JButton toolBarSearchButton;

	
	/**
	 * Create the frame.
	 */
	public TheGUI() {
		makeContentPane();
		placeMenu();
		placeToolBar();
		placeWelcomeMenu();
		//placePatientPane();
		actionTime();
		Patient rawr = new Patient()
							.addName("rawr")
							.addAge("18")
							.addDOB("9/5/94")
							.addHeight("6'2''")
							.addWeight("215")
							.addInsuranceCompany("AAA")
							.addCalculatedBMI("9001")
							.addMedicalConditions("FatAssery")
							.addCurrentMedications("Rawrpills")
							.addAddress("101 I'm Awesome Ln")
							.addPhoneNumber("124-555-3432")
							.addEmailAddress("vestawesome@awesome.com")
							.addAdditionalComments("BigDerp");
	}
	
	public void makeContentPane(){
		setTitle("Final Project");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1276, 783);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	}
	
	public void placeMenu(){
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuFileButton = new JMenu("File");
		menuAboutButton = new JMenu("About");
		menuHelpButton = new JMenu("Help");
		
		fileSubNewPatient = new JMenuItem("New Patient");
		fileSubClose = new JMenuItem("Close");
		fileSubSavePatient = new JMenuItem("Save Patient");
		fileSubSearchPatient = new JMenuItem("Search Patients");
		
		menuSubWhoIAm = new JMenuItem("Who I am");
		menuSubWelcome = new JMenuItem("Welcome");
		
		fileSubNewPatient.setActionCommand("New Patient");
		fileSubSavePatient.setActionCommand("Save Patient");
		fileSubSearchPatient.setActionCommand("Search Patients");
		
		menuFileButton.add(fileSubNewPatient);
		menuFileButton.add(fileSubSavePatient);
		menuFileButton.add(fileSubSearchPatient);
		menuFileButton.add(fileSubClose);
		menuAboutButton.add(menuSubWhoIAm);
		menuHelpButton.add(menuSubWelcome);		
		
		menuBar.add(menuFileButton);
		menuBar.add(menuAboutButton);
		menuBar.add(menuHelpButton);
	}
	
	public void placeToolBar(){
		toolBar = new JToolBar();
		
		toolBarNewUserButton = new JButton("New User");
		toolBarSaveUserButton = new JButton("Save");
		toolBarLoadUserButton = new JButton("Load user");
		toolBarSearchButton = new JButton("Search");
		
		toolBar.add(toolBarNewUserButton);
		toolBar.add(toolBarLoadUserButton);
		toolBar.add(toolBarSaveUserButton);
		toolBar.add(toolBarSearchButton);
	}
	
	
	public void placeWelcomeMenu(){
		welcomePane = new WelcomePane();
		contentPane.add(welcomePane);
	}
	
	public void placePatientPane(){
		patientPane = new PatientPane();
		contentPane.add(patientPane);
	}
	
	
	public void actionTime(){
		toolBarSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Search dialog = new Search();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		
		toolBarNewUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewPatient newUsar = new NewPatient();
				newUsar.setVisible(true);
			}
		});
		
		WelcomePane.engageTutorialButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
			}
		});
		
		WelcomePane.engageMainApplicationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//FIXME Uh, the welcome pain won't go away. Kill it with fire.
				
				placePatientPane();
			}
		});
		
		WelcomePane.engageInformationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
	}
}
