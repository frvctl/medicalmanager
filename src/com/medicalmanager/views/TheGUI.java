package com.medicalmanager.views;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import com.medicalmanager.models.Patient;

@SuppressWarnings("serial")
public class TheGUI extends JFrame {
	private ArrayList<Patient> patieRay = new ArrayList<Patient>();
	
	private JPanel contentPane;
	
	private JDesktopPane desktopPane;
	
	private JToolBar toolBar;
	
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
	
	private JSplitPane patientPane_1;
	
	private JTextArea infoArea;
	
	private JList<Object> patientList;
	
	/**
	 * Create the frame.
	 */
	public TheGUI() {
		makeContentPane();
		placeMenu();
		placeToolBar();
		makeDesktopPane();
		placePatientInfoArea();
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
		
		
		patieRay.add(rawr);
		infoArea.append(patientDisplay(rawr));
		
	}
	
	public String patientDisplay(Patient patient){
		String dataToDisplay = null;
	    dataToDisplay += patient.getName() + "\n";
	    dataToDisplay += patient.getName() + "\n";
		dataToDisplay += patient.getName() + "\n";
		dataToDisplay += patient.getName() + "\n";
		dataToDisplay += patient.getName() + "\n";
		dataToDisplay += patient.getName() + "\n";
		dataToDisplay += patient.getName() + "\n";
		dataToDisplay += patient.getName() + "\n";
		dataToDisplay += patient.getName() + "\n";
		dataToDisplay += patient.getName() + "\n";
		dataToDisplay += patient.getName() + "\n";
		dataToDisplay += patient.getName() + "\n";
		dataToDisplay += patient.getName() + "\n";
			
		return dataToDisplay;
	}
	
	public void makeContentPane(){
		setTitle("Final Project");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	}
	
	public void makeDesktopPane(){
		desktopPane = new JDesktopPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
				.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE))
		);
		
		contentPane.setLayout(gl_contentPane);
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
	
	public void placePatientInfoArea(){
		patientPane_1 = new JSplitPane();
		patientPane_1.setBounds(0, 0, 934, 631);
		desktopPane.add(patientPane_1);
		
		infoArea = new JTextArea();
		patientPane_1.setRightComponent(infoArea);
		
		patientList = new JList<Object>();
		patientList.setMinimumSize(new Dimension(200, 0));
		patientPane_1.setLeftComponent(patientList);
	}
	
	public void placeWelcomeMenu(){
		JSplitPane patientPane = new JSplitPane();
		patientPane.setBounds(0, 0, 934, 631);
		desktopPane.add(patientPane);
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
		
	}
}
