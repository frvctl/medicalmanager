package com.medicalmanager.views;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.medicalmanager.helpers.DataHelper;
import com.medicalmanager.models.Patient;

public class PatientView extends JFrame {

	private CardLayout card = new CardLayout(0, 0);

	private JPanel contentPane;

	private JButton mainAppButton;
	private JButton aboutButton;
	private JButton newPatientButton;
	private JButton searchButton;
	private JButton sortPatientList;
	public static DefaultListModel listModel;
	public static ArrayList<Patient> sortedArray = new ArrayList<Patient>();
	public static ArrayList<Patient> patientArray = new ArrayList<Patient>();
	private JList patientList;
	private JMenuItem helpMenuPreferencesItem;
	private JMenuItem helpMenuTutorialItem;
	private JMenuItem helpMenuFAQItem;
	private JMenuItem fileMenuPrintItem;
	private JMenuItem fileMenuSaveAsItem;
	private JMenuItem fileMenuOpenItem;
	private JMenu fileMenu;
	private JMenu helpMenu;
	private JButton editPatientButton;
	private JButton adjustSeverityButton;
	private JButton prescribeMedicationButton;
	private JButton setDiagnosisButton;
	private JPanel panel;
	private JScrollPane infoScollPane;
	private JTextArea patientInfoArea;
	private JScrollPane editScrollPane;
	private JTable editPatientTable;

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public PatientView() throws IOException {
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
		DataHelper.prepareFile();
		DataHelper.readAllPatients();

	}

	public void placeMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		fileMenuSaveAsItem = new JMenuItem("Save As");
		fileMenu.add(fileMenuSaveAsItem);

		fileMenuOpenItem = new JMenuItem("Open File");
		fileMenu.add(fileMenuOpenItem);

		fileMenuPrintItem = new JMenuItem("Print");
		fileMenu.add(fileMenuPrintItem);

		helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);

		helpMenuTutorialItem = new JMenuItem("Tutorial");
		helpMenu.add(helpMenuTutorialItem);

		helpMenuFAQItem = new JMenuItem("FAQ");
		helpMenu.add(helpMenuFAQItem);

		helpMenuPreferencesItem = new JMenuItem("Preferences");
		helpMenu.add(helpMenuPreferencesItem);
	}

	public void makePatientPanel() throws IOException {
		JPanel patientPanel = new JPanel();
		contentPane.add(patientPanel, "patientPanel");

		JSplitPane splitPane = new JSplitPane();

		JToolBar patientToolBar = new JToolBar();
		GroupLayout patientLayout = new GroupLayout(patientPanel);
		patientLayout.setHorizontalGroup(patientLayout
				.createParallelGroup(Alignment.LEADING)
				.addComponent(splitPane, Alignment.TRAILING,
						GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
				.addComponent(patientToolBar, GroupLayout.DEFAULT_SIZE, 812,
						Short.MAX_VALUE));
		patientLayout.setVerticalGroup(patientLayout.createParallelGroup(
				Alignment.TRAILING).addGroup(
				Alignment.LEADING,
				patientLayout
						.createSequentialGroup()
						.addComponent(patientToolBar,
								GroupLayout.PREFERRED_SIZE, 21,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 513,
								Short.MAX_VALUE)));

		newPatientButton = new JButton("New Patient");
		searchButton = new JButton("Search");
		sortPatientList = new JButton("Sort List");

		patientToolBar.add(searchButton);
		patientToolBar.add(sortPatientList);
		patientToolBar.add(newPatientButton);
		
		editPatientButton = new JButton("Edit Patient");
		patientToolBar.add(editPatientButton);
		
		adjustSeverityButton = new JButton("Adjust Severity");
		patientToolBar.add(adjustSeverityButton);
		
		prescribeMedicationButton = new JButton("Prescribe Medication");
		patientToolBar.add(prescribeMedicationButton);
		
		setDiagnosisButton = new JButton("Set Diagnosis");
		patientToolBar.add(setDiagnosisButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setMinimumSize(new Dimension(100, 23));
		splitPane.setLeftComponent(scrollPane);

		listModel = new DefaultListModel<Object>();
		patientList = new JList(listModel);
		patientList.setSize(new Dimension(200, 0));
		patientList.setMinimumSize(new Dimension(200, 0));
		scrollPane.setViewportView(patientList);
		
		panel = new JPanel();
		splitPane.setRightComponent(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		infoScollPane = new JScrollPane();
		panel.add(infoScollPane, "infoPane");
		
		patientInfoArea = new JTextArea();
		infoScollPane.setViewportView(patientInfoArea);
		
		editScrollPane = new JScrollPane();
		panel.add(editScrollPane, "editPane");
		
		editPatientTable = new JTable();
		editPatientTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Field", "Value"
			}
		));
		editScrollPane.setViewportView(editPatientTable);
		patientPanel.setLayout(patientLayout);

		for (Patient p : patientArray) {
			listModel.addElement(p.getName());
		}
	}

	public static void updateList(Patient p) {
		int theSize = patientArray.size();
		patientArray.add(p);
		listModel.addElement(p.getName());
	}

	public void makeWelcomePanel() {
		JPanel welcomePanel = new JPanel();
		contentPane.add(welcomePanel, "welcomePanel");
		card.show(contentPane, "welcomePanel");

		JLabel welcomeLabel = new JLabel("Welcome to Medical Manager!");
		welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

		mainAppButton = new JButton("Manage Patients");

		aboutButton = new JButton("About Medical Manager");

		JLabel createdByLabel = new JLabel("Created By: Ben Vest");
		createdByLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout welcomeLayout = new GroupLayout(welcomePanel);
		welcomeLayout
				.setHorizontalGroup(welcomeLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								welcomeLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(createdByLabel,
												GroupLayout.DEFAULT_SIZE, 792,
												Short.MAX_VALUE)
										.addContainerGap())
						.addGroup(
								welcomeLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(welcomeLabel,
												GroupLayout.DEFAULT_SIZE, 792,
												Short.MAX_VALUE)
										.addContainerGap())
						.addGroup(
								Alignment.TRAILING,
								welcomeLayout
										.createSequentialGroup()
										.addGap(62)
										.addGroup(
												welcomeLayout
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																aboutButton,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																662,
																Short.MAX_VALUE)
														.addComponent(
																mainAppButton,
																Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE,
																662,
																Short.MAX_VALUE))
										.addGap(88)));
		welcomeLayout.setVerticalGroup(welcomeLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				welcomeLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(welcomeLabel, GroupLayout.PREFERRED_SIZE,
								53, GroupLayout.PREFERRED_SIZE)
						.addGap(40)
						.addComponent(mainAppButton,
								GroupLayout.PREFERRED_SIZE, 116,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(aboutButton, GroupLayout.PREFERRED_SIZE,
								119, GroupLayout.PREFERRED_SIZE)
						.addGap(146)
						.addComponent(createdByLabel,
								GroupLayout.PREFERRED_SIZE, 26,
								GroupLayout.PREFERRED_SIZE).addContainerGap()));
		welcomePanel.setLayout(welcomeLayout);
	}

	public void actionTime() {
		mainAppButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.next(contentPane);
			}
		});

		newPatientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PatientDialog newUsar = new PatientDialog();
				newUsar.setVisible(true);
			}
		});

		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchDialog dialog = new SearchDialog();
				dialog.setVisible(true);
			}
		});

		sortPatientList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataHelper.sortPatients(patientArray);
				listModel.clear();
				for (Patient p : patientArray) {
					listModel.addElement(p.getName());
				}
			}
		});
		
		fileMenuSaveAsItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SavePatientDialog dialog = new SavePatientDialog();
				dialog.setVisible(true);
			}
		});
		
		 fileMenuPrintItem.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			 // OutputController.displayAllPatients(patientArray);
			 }
		 });
		
		editPatientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		adjustSeverityButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		prescribeMedicationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		setDiagnosisButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		patientList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				System.out.println(patientList.getSelectedIndex());
				Patient rawr = patientArray.get(patientList.getSelectedIndex());
				patientInfoArea.setText("AGE: " + rawr.getAge() + "\n"
						+ "Name: " + rawr.getName() + "\n" + "HEIGHT: "
						+ rawr.getHeight() + "\n" + "DOB: " + rawr.getDOB()
						+ "\n" + "BMI: " + rawr.getCalculatedBMI());
			}
		});
	}
}