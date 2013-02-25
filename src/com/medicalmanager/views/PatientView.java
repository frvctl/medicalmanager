package com.medicalmanager.views;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.util.ArrayList;

import javax.print.PrintService;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.medicalmanager.controllers.Database;
import com.medicalmanager.models.Patient;

public class PatientView extends JFrame {

	private CardLayout card = new CardLayout(0, 0);

	private JPanel contentPane;
	private JPanel patientInfoEditPanel;
	
	private JMenu fileMenu;
	private JMenu helpMenu;
	
	private JMenuItem helpMenuPreferencesItem;
	private JMenuItem helpMenuTutorialItem;
	private JMenuItem helpMenuFAQItem;
	private JMenuItem fileMenuPrintItem;
	private JMenuItem fileMenuSaveAsItem;
	private JMenuItem fileMenuOpenItem;
	
	private JButton mainAppButton;
	private JButton aboutButton;
	private JButton newPatientButton;
	private JButton searchButton;
	private JButton sortPatientList;
	private JButton editPatientButton;
	private JButton adjustSeverityButton;
	private JButton prescribeMedicationButton;
	private JButton setDiagnosisButton;

	private static JList patientList;
	public static DefaultListModel<String> listModel;
	private JScrollPane infoScollPane;
	
	private JTextArea patientInfoArea;
	
	private static Patient selected;
	
	private static boolean isSelected = false;

	public static ArrayList<Patient> sortedArray = new ArrayList<Patient>();
	public static ArrayList<Patient> patientArray = new ArrayList<Patient>();
	private JPanel aboutPanel;


	/**
	 * Bootstrap the entire GUI
	 * 
	 * @throws IOException
	 */
	public PatientView() throws IOException {
		// Ensures the panel closes when you press the close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Opening size
		setBounds(100, 100, 838, 609);
		
		// Base panel of the application
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(card); // Card layout to access the other components such as Patient or About

		setContentPane(contentPane);
		
		// Place the menu on the content pane
		placeMenu();
		
		// Instantiate the welcome panel
		makeWelcomePanel();
		
		// Instantiate the patient panel
		makePatientPanel();
		
		// Bootstrap the event handlers
		actionTime();
		
		// Set the standard write directory - possibly add settings to change where this is
		Database.setWriteDirectory(System.getProperty("user.home") + "\\My Documents\\Medical Manager\\");
		
		// Set the standard file that is written to
		Database.setFile("patients.txt");
		
		// Create the directory and file if it isn't already there
		Database.prepareFile();
		
		// Read all the patients from the file dumping them into an array list for use later
		Database.readAllPatientsFromFile();
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

		listModel = new DefaultListModel<String>();
		patientList = new JList<String>(listModel);
		patientList.setSize(new Dimension(200, 0));
		patientList.setMinimumSize(new Dimension(200, 0));
		scrollPane.setViewportView(patientList);
		
		patientInfoEditPanel = new JPanel();
		splitPane.setRightComponent(patientInfoEditPanel);
		patientInfoEditPanel.setLayout(new CardLayout());
		
		infoScollPane = new JScrollPane();
		patientInfoEditPanel.add(infoScollPane, "infoPane");
		
		patientInfoArea = new JTextArea();
		patientInfoArea.setFont(new Font("Monospaced", patientInfoArea.getFont().getStyle(), patientInfoArea.getFont().getSize()));
		patientInfoArea.setLineWrap(true);
		patientInfoArea.setWrapStyleWord(true);
		infoScollPane.setViewportView(patientInfoArea);
		
		patientPanel.setLayout(patientLayout);
		
		aboutPanel = new JPanel();
		contentPane.add(aboutPanel, "name_6720415608134");

		for (Patient p : patientArray) {
			listModel.addElement(p.getFirstName());
		}
	}
	
	/*
	 * Update's the PatientList by adding the patient to the listModel
	 */
	public static void updateList(Patient p) {
		patientArray.add(p);
		listModel.addElement(p.getFirstName());
	}
	
	public static void toTop(Patient[] pRay){
		try{
			int index = 0;
			for(Patient p: pRay){
				System.out.println(p.getFirstName());
				
				int remIndex = patientArray.indexOf(p);
				listModel.remove(remIndex);
				listModel.add(index, p.getFirstName());
				index++;
			}
		}catch(NullPointerException e){
			System.out.println(e);
		}
	}
	
	public static void updateListAfterPatientEdit(int index, Patient p){
		patientArray.remove(p);
		patientArray.add(index, p);
		
		patientList.clearSelection();
		patientList.setSelectedIndex(index);
		
		listModel.remove(index);
		listModel.add(index, p.getFirstName());
	}
	
	public static void changePriority(Patient p, int prior){
		patientArray.remove(p);
		listModel.add(prior, p.getFirstName());
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
				Database.sortPatients(patientArray, "ID");
				listModel.clear();
				for (Patient p : patientArray) {
					listModel.addElement(p.getFirstName());
				}
			}
		});
		
		fileMenuSaveAsItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SavePatientDialog dialog = new SavePatientDialog();
				dialog.setVisible(true);
			}
		});
		
		class MyPrintable implements Printable {
			  public int print(Graphics g, PageFormat pf, int pageIndex) {
			    if (pageIndex != 0)
			      return NO_SUCH_PAGE;
			    Graphics2D g2 = (Graphics2D) g;
			    g2.setFont(new Font("Serif", Font.PLAIN, 36));
			    g2.setPaint(Color.black);
			    g2.drawString("Medical Manager Patient Printout", 50, 100);
			    int x = 150;
			    int y = 200;
			    g2.setFont(new Font("Serif", Font.PLAIN, 20));
			    for(Patient p: patientArray){
			    	g2.drawString(p.getFullName(), x, y);
			    	y += 100;
			    }
			    Rectangle2D outline = new Rectangle2D.Double(pf.getImageableX(), pf.getImageableY(), pf
			        .getImageableWidth(), pf.getImageableHeight());
			    g2.draw(outline);
			    return PAGE_EXISTS;
			  }
			}
		
		 fileMenuPrintItem.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 boolean isTrue = true;
				 if(isTrue) {
				        // Get a printing object
				        PrinterJob printJob = PrinterJob.getPrinterJob(); 
				        PrintService printer = printJob.getPrintService();
				        PageFormat pf = printJob.defaultPage();
				        Paper paper = new Paper();
				        double margin = 36; // half inch
				        paper.setImageableArea(margin, margin, paper.getWidth() - margin * 2, paper.getHeight()
				            - margin * 2);
				        pf.setPaper(paper);

				        if(printer == null) {
				          JOptionPane.showMessageDialog(contentPane, 
				                                        "No default printer available.",
				                                        "Printer Error",
				                                        JOptionPane.ERROR_MESSAGE);
				          return;
				        }
				        // The view is the page source

				        printJob.setPrintable(new MyPrintable(), pf);


				        if(printJob.printDialog()) {              // Display print dialog
				                                                  // If true is returned...
				          try {
				            printJob.print();                            // then print
				          } catch(PrinterException pe) {
				            System.out.println(pe);
				            JOptionPane.showMessageDialog(contentPane,
				                                          "Error printing a sketch.",
				                                          "Printer Error",
				                                          JOptionPane.ERROR_MESSAGE);
				          }
				        }
				      }
			 }
		 });
		
		editPatientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PatientView.isSelected){
					EditPatientDialog dialog = new EditPatientDialog();
					dialog.setVisible(true);	
				}
			}
		});
		
		adjustSeverityButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ops[] = new String[1];
				ops[0] = "Ben";
				SearchResultsDialog sD = new SearchResultsDialog(Database.advancedPatientSearch(ops));
				sD.setVisible(true); 
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
				PatientView.isSelected = true;
				if(!patientList.isSelectionEmpty()){
					Patient rawr = patientArray.get(patientList.getSelectedIndex());
					patientInfoArea.getWidth();
					PatientView.setSelected(rawr);
					String newLine = "\n";
					String space = "    ";
					patientInfoArea.setText(
							space+ "----------------------------------- Patient Info ---------------------------------------\n"
							+ space + "** Information regarding " + rawr.getFullName() + " is listed below.  \n"
							+ space + "** This Patient is under the care of Doctor Blah \n"
							+ space + "** Remember to leave detailed remarks on any edits to the patients file \n"
							+ space + "** If you encounter any difficulty consult the Help Menu \n"
							+ space + "** If immediate attention by others is required raise the patients severity level \n"
							+ newLine
							+ formatField("Age", rawr.getAge())
							+ newLine
							+ formatField("Name", rawr.getFirstName())
							+ newLine
							+ formatField("Height", rawr.getHeight())
							+ newLine
							+ formatField("Weight", rawr.getWeight())
							+ newLine
							+ formatField("Date of Birth", rawr.getDOB())
							+ newLine
							+ formatField("Body Mass Index", rawr.getBMI())
							+ newLine
							+ formatField("Address", rawr.getAddress())
							+ newLine
							+ formatField("Home Phone", rawr.getHomePhoneNumber())
							+ newLine
							+ formatField("Cell Phone", rawr.getCellPhoneNumber())
							+ newLine
							+ formatField("Current Medications", rawr.getCurrentMedications())
							+ newLine
							+ formatField("Additional Medical Information", rawr.getAdditionalMedicalInformation()));
				}
			}
				
		});
	}

	public static String formatField(String attr, Comparable val){
		return String.format("    %30s: => %-4s", attr, val) + "\n";

	}
	
	public static Patient getSelected() {
		return selected;
	}

	public static void setSelected(Patient selected) {
		PatientView.selected = selected;
	}
}