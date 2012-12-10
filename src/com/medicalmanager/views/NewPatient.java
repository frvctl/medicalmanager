package com.medicalmanager.views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.medicalmanager.models.Patient;

public class NewPatient extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField ageField;
	private JTextField heightField;
	private JTextField weightField;
	private JTextField medicationField;
	private JTextField firstNameField;
	private JTextField middleNameField;
	private JTextField lastNameField;
	private JTextField calculatedBMIField;
	private JTextField textField_8;
	private JTextField textField_9;
	CardLayout cl = new CardLayout(0, 0);
	private JPanel testDataPanel;
	private JButton nextButton;
	private JButton okButton;
	private JButton backButton;  
	private JPanel buttonPane;
	private JButton cancelButton;
	private JButton gotoTestData;
	private JButton gotoInsuranceInfo;
	private JButton gotoGeneralInfo;
	private JButton gotoBasicHealthInfo;
	private JFormattedTextField dobField;
	private JComboBox raceBox;
	private JComboBox genderBox;
	private JFormattedTextField homeAddressField;
	private JFormattedTextField emailAddressField;
	private JFormattedTextField homePhoneField;
	private JFormattedTextField cellPhoneField;

	/**
	 * Create the dialog.
	 */
	public NewPatient() {
		setBounds(100, 100, 545, 378);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		createWelcomePane();
		createHealthInfoPane();
		createPersonalInfoPane();
		createInsuranceInfoPane();
		createTestDataPane();
	}
	
	public void switchToOkay(){
		okButton = new JButton("OK");
		backButton = new JButton("BACK");
		buttonPane.remove(cancelButton);
		buttonPane.remove(nextButton);
		buttonPane.add(okButton);
		buttonPane.add(backButton);
		buttonPane.add(cancelButton);
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				Patient newPatient = new Patient()
					.addName(firstNameField.getText())
					.addAge(Integer.parseInt(ageField.getText()))
					.addDOB(dobField.getText())
					.addAddress(homeAddressField.getText())
					.addPhoneNumber(homePhoneField.getText())
					.addInsuranceCompany(null)
					.addMedicalConditions(null)
					.addCurrentMedications(medicationField.getText())
					.addAdditionalComments(null)
					.addID(4)
					.addHeight(Double.parseDouble(heightField.getText()))
					.addWeight(Double.parseDouble(weightField.getText()));
				

				MainView.updateList(newPatient);
				NewPatient.this.setVisible(false);
				System.out.println("worked");
				System.out.println(MainView.patientArray.size());
			}
		});
	}
	
	
	public void createWelcomePane(){
		contentPanel.setLayout(cl);
		{
			JPanel welcomePanel = new JPanel();
			contentPanel.add(welcomePanel, "welcome");
			
			JLabel infoLabel = new JLabel("This is used to add a new patient to the database");
			
			gotoGeneralInfo = new JButton("Click to Add General Info");
			gotoGeneralInfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cl.show(contentPanel, "personalInfo");
				}
			});
			
			gotoInsuranceInfo = new JButton("Insurance Information");
			gotoInsuranceInfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cl.show(contentPanel, "insuranceInfo");
				}
			});
			
			gotoBasicHealthInfo = new JButton("Basic Health Information");
			gotoBasicHealthInfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cl.show(contentPanel, "healthInfo");
				}
			});
			
			gotoTestData = new JButton("Test Data for Interpretation");
			GroupLayout gl_welcomePanel = new GroupLayout(welcomePanel);
			gl_welcomePanel.setHorizontalGroup(
				gl_welcomePanel.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_welcomePanel.createSequentialGroup()
						.addContainerGap(182, Short.MAX_VALUE)
						.addGroup(gl_welcomePanel.createParallelGroup(Alignment.LEADING)
							.addComponent(gotoTestData)
							.addComponent(gotoInsuranceInfo)
							.addComponent(gotoGeneralInfo)
							.addComponent(gotoBasicHealthInfo)
							.addComponent(infoLabel))
						.addGap(134))
			);
			gl_welcomePanel.setVerticalGroup(
				gl_welcomePanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_welcomePanel.createSequentialGroup()
						.addContainerGap()
						.addComponent(infoLabel)
						.addGap(18)
						.addComponent(gotoBasicHealthInfo)
						.addGap(11)
						.addComponent(gotoGeneralInfo)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(gotoInsuranceInfo)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(gotoTestData)
						.addContainerGap(113, Short.MAX_VALUE))
			);
			welcomePanel.setLayout(gl_welcomePanel);
		}
	}
	
	public void createHealthInfoPane(){
		JPanel healthInfoPanel = new JPanel();
		contentPanel.add(healthInfoPanel, "healthInfo");
		healthInfoPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel ageLabel = new JLabel("Age");
		healthInfoPanel.add(ageLabel, "2, 2, right, default");
		
		ageField = new JTextField();
		healthInfoPanel.add(ageField, "4, 2, fill, default");
		ageField.setColumns(10);
		
		JLabel heightLabel = new JLabel("Height");
		healthInfoPanel.add(heightLabel, "2, 4, right, default");
		
		heightField = new JTextField();
		healthInfoPanel.add(heightField, "4, 4, fill, default");
		heightField.setColumns(10);
		
		JLabel weightLabel = new JLabel("Weight");
		healthInfoPanel.add(weightLabel, "2, 6, right, default");
		
		weightField = new JTextField();
		healthInfoPanel.add(weightField, "4, 6, fill, default");
		weightField.setColumns(10);
		
		JLabel medicationLabel = new JLabel("Current Medications");
		healthInfoPanel.add(medicationLabel, "2, 8, right, default");
		
		medicationField = new JTextField();
		healthInfoPanel.add(medicationField, "4, 8, fill, default");
		medicationField.setColumns(10);
		
		JLabel tobaccoLabel = new JLabel("Tobacco Usage");
		healthInfoPanel.add(tobaccoLabel, "2, 10, right, default");
		
		JComboBox tobaccoBox = new JComboBox();
		tobaccoBox.setModel(new DefaultComboBoxModel(new String[] {"No - Never", "Yes - Previously, now does not", "Yes - Rarely", "Yes - Frequently", "Yes - Chain Smoker or heavy chewer"}));
		healthInfoPanel.add(tobaccoBox, "4, 10, fill, default");
		
		JLabel alcoholLabel = new JLabel("Alcohol Consumption");
		healthInfoPanel.add(alcoholLabel, "2, 12, right, default");
		
		JComboBox alcoholBox = new JComboBox();
		alcoholBox.setModel(new DefaultComboBoxModel(new String[] {"No - Never", "Yes - Now has quit", "Yes - Moderate amounts", "Yes - Heavy drinker", "Yes - Very heavy drinker ", "Yes - Alcoholic / Alcoholism"}));
		healthInfoPanel.add(alcoholBox, "4, 12, fill, default");
		
		JLabel sexLabel = new JLabel("Sexually Active");
		healthInfoPanel.add(sexLabel, "2, 14, right, default");
		
		JComboBox sexBox = new JComboBox();
		sexBox.setModel(new DefaultComboBoxModel(new String[] {"No", "Yes"}));
		healthInfoPanel.add(sexBox, "4, 14, fill, default");
		
		JLabel commentsLabel = new JLabel("Additional Comments");
		healthInfoPanel.add(commentsLabel, "2, 16");
		
		JTextArea commentsArea = new JTextArea();
		healthInfoPanel.add(commentsArea, "4, 16, fill, fill");
	}
	
	public void createInsuranceInfoPane(){
		JPanel insuranceInfoPanel = new JPanel();
		contentPanel.add(insuranceInfoPanel, "insuranceInfo");
		insuranceInfoPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblInsuranceCompany = new JLabel("Insurance Company");
		insuranceInfoPanel.add(lblInsuranceCompany, "2, 2");
	}
	
	public void createPersonalInfoPane(){
		JPanel personalInfoPanel = new JPanel();
		contentPanel.add(personalInfoPanel, "personalInfo");
		personalInfoPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel nameLabel = new JLabel("First Name");
		personalInfoPanel.add(nameLabel, "2, 2, right, default");
		
		firstNameField = new JTextField();
		personalInfoPanel.add(firstNameField, "4, 2, fill, default");
		firstNameField.setColumns(10);
		
		JLabel middleNameLabel = new JLabel("Middle Name");
		personalInfoPanel.add(middleNameLabel, "2, 4, right, default");
		
		middleNameField = new JTextField();
		personalInfoPanel.add(middleNameField, "4, 4, fill, default");
		middleNameField.setColumns(10);
		
		JLabel lastNameLabel = new JLabel("Last Name");
		personalInfoPanel.add(lastNameLabel, "2, 6, right, default");
		
		lastNameField = new JTextField();
		personalInfoPanel.add(lastNameField, "4, 6, fill, default");
		lastNameField.setColumns(10);
		
		JLabel dobLabel = new JLabel("Date of Birth");
		personalInfoPanel.add(dobLabel, "2, 8, right, default");
		
		dobField = new JFormattedTextField();
		personalInfoPanel.add(dobField, "4, 8, fill, default");
		
		JLabel raceLabel = new JLabel("Race");
		personalInfoPanel.add(raceLabel, "2, 10, right, default");
		
		raceBox = new JComboBox();
		raceBox.setModel(new DefaultComboBoxModel(new String[] {"Caucasian", "Black", "Asian", "Native American", "Latino", "Other"}));
		personalInfoPanel.add(raceBox, "4, 10, fill, default");
		
		JLabel genderLabel = new JLabel("Gender");
		personalInfoPanel.add(genderLabel, "2, 12, right, default");
		
		genderBox = new JComboBox();
		genderBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		personalInfoPanel.add(genderBox, "4, 12, fill, default");
		
		JLabel homeAddressLabel = new JLabel("Home Address");
		personalInfoPanel.add(homeAddressLabel, "2, 14, right, default");
		
		homeAddressField = new JFormattedTextField();
		personalInfoPanel.add(homeAddressField, "4, 14, fill, default");
		
		JLabel emailAddressLabel = new JLabel("Email Address");
		personalInfoPanel.add(emailAddressLabel, "2, 16, right, default");
		
		emailAddressField = new JFormattedTextField();
		personalInfoPanel.add(emailAddressField, "4, 16, fill, default");
		
		JLabel homePhoneLabel = new JLabel("Home Phone");
		personalInfoPanel.add(homePhoneLabel, "2, 18, right, default");
		
		homePhoneField = new JFormattedTextField();
		personalInfoPanel.add(homePhoneField, "4, 18, fill, default");
		
		JLabel callPhoneLabel = new JLabel("Cell Phone");
		personalInfoPanel.add(callPhoneLabel, "2, 20, right, default");
		
		cellPhoneField = new JFormattedTextField();
		personalInfoPanel.add(cellPhoneField, "4, 20, fill, default");
	}
	
	public void createTestDataPane(){	
		testDataPanel = new JPanel();
		contentPanel.add(testDataPanel, "testData");
		
		JLabel dataInfo = new JLabel("Based on data previously entered");
		
		JLabel calculatedBMILabel = new JLabel("This patients BMI is");
		
		calculatedBMIField = new JTextField();
		calculatedBMIField.setEditable(false);
		calculatedBMIField.setColumns(10);
		
		JLabel enterDataInfoLabel = new JLabel("In order to calculate this patients risk for liver problems enter the following values");
		
		JLabel lblBlah = new JLabel("Blah");
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
		JLabel lblYah = new JLabel("Yah");
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		GroupLayout gl_testDataPanel = new GroupLayout(testDataPanel);
		gl_testDataPanel.setHorizontalGroup(
			gl_testDataPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_testDataPanel.createSequentialGroup()
					.addGroup(gl_testDataPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_testDataPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(dataInfo))
						.addGroup(gl_testDataPanel.createSequentialGroup()
							.addGap(37)
							.addComponent(calculatedBMILabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(calculatedBMIField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_testDataPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(enterDataInfoLabel))
						.addGroup(gl_testDataPanel.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_testDataPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_testDataPanel.createSequentialGroup()
									.addComponent(lblYah)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_testDataPanel.createSequentialGroup()
									.addComponent(lblBlah)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(104, Short.MAX_VALUE))
		);
		gl_testDataPanel.setVerticalGroup(
			gl_testDataPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_testDataPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(dataInfo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_testDataPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(calculatedBMILabel)
						.addComponent(calculatedBMIField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addComponent(enterDataInfoLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_testDataPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBlah)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_testDataPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYah) 
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(132, Short.MAX_VALUE))
		);
		
		testDataPanel.setLayout(gl_testDataPanel);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
	
				nextButton = new JButton("NEXT");
				nextButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						cl.next(contentPanel);
						if(testDataPanel.isVisible()){
							switchToOkay();
						}
					}
				});
				nextButton.setActionCommand("NEXT");
				buttonPane.add(nextButton);
				getRootPane().setDefaultButton(nextButton);
			
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						NewPatient.this.setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}