package com.medicalmanager.views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.medicalmanager.helpers.DataHelper;
import com.medicalmanager.helpers.DiagnosisHelper;
import com.medicalmanager.models.Patient;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class PatientDialog extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField ageField;
	private JTextField heightField;
	private JTextField weightField;
	private JTextField medicationField;
	private JTextField firstNameField;
	private JTextField middleNameField;
	private JTextField lastNameField;
	CardLayout cl = new CardLayout(0, 0);
	private JPanel testDataPanel;
	private JButton nextButton;
	private JButton okButton;
	private JButton backButton;  
	private JPanel buttonPane;
	private JButton cancelButton;
	private JButton gotoTestData;
	private JButton gotoGeneralInfo;
	private JButton gotoBasicHealthInfo;
	private JFormattedTextField dobField;
	private JComboBox raceBox;
	private JComboBox genderBox;
	private JFormattedTextField homeAddressField;
	private JFormattedTextField emailAddressField;
	private JFormattedTextField homePhoneField;
	private JFormattedTextField cellPhoneField;
	private JTextArea explanationBMIField;
	private JTextArea textArea;
	private JTextField meanArterialField;
	private JTextField systolicField;
	private JTextField diastolicField;
	private JTextField MAPLabel;
	private JTextField calculatedBMIField;
	private JTextArea bmiExplanationField;

	/**
	 * Create the dialog.
	 */
	public PatientDialog() {
		setBounds(100, 100, 742, 475);
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
				Patient newPatient;
				try {
					newPatient = new Patient()
						.addName(firstNameField.getText())
						.addAge(Integer.parseInt(ageField.getText()))
						.addDOB(dobField.getText())
						.addAddress(homeAddressField.getText())
						.addPhoneNumber(homePhoneField.getText())
						.addInsuranceCompany(null)
						.addMedicalConditions(null)
						.addCurrentMedications(medicationField.getText())
						.addAdditionalComments(null)
						.addID(DataHelper.count())
						.addHeight(Double.parseDouble(heightField.getText()))
						.addWeight(Double.parseDouble(weightField.getText()))
						.addBMI(Double.parseDouble(heightField.getText()), Double.parseDouble(weightField.getText()));
					
					DataHelper.writeToFile(Patient.stringify(newPatient), null);
					PatientView.updateList(newPatient);
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				PatientDialog.this.setVisible(false);
			}
		});
	}
	
	
	public void createWelcomePane(){
		contentPanel.setLayout(cl);
		{
			JPanel welcomePanel = new JPanel();
			contentPanel.add(welcomePanel, "welcome");
			
			JLabel infoLabel = new JLabel("This is used to add a new patient to the database");
			
			gotoGeneralInfo = new JButton("General Information");
			gotoGeneralInfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cl.show(contentPanel, "personalInfo");
				}
			});
			
			gotoBasicHealthInfo = new JButton("Basic Health Information");
			gotoBasicHealthInfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cl.show(contentPanel, "healthInfo");
				}
			});
			
			gotoTestData = new JButton("Test Data");
			GroupLayout gl_welcomePanel = new GroupLayout(welcomePanel);
			gl_welcomePanel.setHorizontalGroup(
				gl_welcomePanel.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_welcomePanel.createSequentialGroup()
						.addGroup(gl_welcomePanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_welcomePanel.createSequentialGroup()
								.addGap(230)
								.addComponent(infoLabel))
							.addGroup(gl_welcomePanel.createSequentialGroup()
								.addGap(184)
								.addGroup(gl_welcomePanel.createParallelGroup(Alignment.LEADING)
									.addComponent(gotoTestData, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
									.addComponent(gotoGeneralInfo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(gotoBasicHealthInfo, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE))))
						.addGap(195))
			);
			gl_welcomePanel.setVerticalGroup(
				gl_welcomePanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_welcomePanel.createSequentialGroup()
						.addContainerGap()
						.addComponent(infoLabel)
						.addGap(18)
						.addComponent(gotoBasicHealthInfo, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(gotoGeneralInfo, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(gotoTestData, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addGap(38))
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
		healthInfoPanel.add(ageLabel, "2, 4, right, default");
		
		ageField = new JTextField();
		healthInfoPanel.add(ageField, "4, 4, fill, default");
		ageField.setColumns(10);
		
		JLabel heightLabel = new JLabel("Height");
		healthInfoPanel.add(heightLabel, "2, 6, right, default");
		
		heightField = new JTextField();
		healthInfoPanel.add(heightField, "4, 6, fill, default");
		heightField.setColumns(10);
		
		JLabel weightLabel = new JLabel("Weight");
		healthInfoPanel.add(weightLabel, "2, 8, right, default");
		
		weightField = new JTextField();
		healthInfoPanel.add(weightField, "4, 8, fill, default");
		weightField.setColumns(10);
		
		JLabel medicationLabel = new JLabel("Current Medications");
		healthInfoPanel.add(medicationLabel, "2, 10, right, default");
		
		medicationField = new JTextField();
		healthInfoPanel.add(medicationField, "4, 10, fill, default");
		medicationField.setColumns(10);
		
		JLabel tobaccoLabel = new JLabel("Tobacco Usage");
		healthInfoPanel.add(tobaccoLabel, "2, 12, right, default");
		
		JComboBox tobaccoBox = new JComboBox();
		tobaccoBox.setModel(new DefaultComboBoxModel(new String[] {"No - Never", "Yes - Previously, now does not", "Yes - Rarely", "Yes - Frequently", "Yes - Chain Smoker or heavy chewer"}));
		healthInfoPanel.add(tobaccoBox, "4, 12, fill, default");
		
		JLabel alcoholLabel = new JLabel("Alcohol Consumption");
		healthInfoPanel.add(alcoholLabel, "2, 14, right, default");
		
		JLabel commentsLabel = new JLabel("Additional Comments");
		healthInfoPanel.add(commentsLabel, "2, 16");
		
		JComboBox alcoholBox = new JComboBox();
		alcoholBox.setModel(new DefaultComboBoxModel(new String[] {"No - Never", "Yes - Now has quit", "Yes - Moderate amounts", "Yes - Heavy drinker", "Yes - Very heavy drinker ", "Yes - Alcoholic / Alcoholism"}));
		healthInfoPanel.add(alcoholBox, "4, 14, fill, default");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		healthInfoPanel.add(scrollPane, "4, 16, fill, fill");
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		scrollPane.setViewportView(textArea_1);
	}
	
	public void createInsuranceInfoPane(){
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel nameLabel = new JLabel("First Name");
		personalInfoPanel.add(nameLabel, "2, 4, right, default");
		
		firstNameField = new JTextField();
		personalInfoPanel.add(firstNameField, "4, 4, fill, default");
		firstNameField.setColumns(10);
		
		JLabel middleNameLabel = new JLabel("Middle Name");
		personalInfoPanel.add(middleNameLabel, "2, 6, right, default");
		
		middleNameField = new JTextField();
		personalInfoPanel.add(middleNameField, "4, 6, fill, default");
		middleNameField.setColumns(10);
		
		JLabel lastNameLabel = new JLabel("Last Name");
		personalInfoPanel.add(lastNameLabel, "2, 8, right, default");
		
		lastNameField = new JTextField();
		personalInfoPanel.add(lastNameField, "4, 8, fill, default");
		lastNameField.setColumns(10);
		
		JLabel dobLabel = new JLabel("Date of Birth");
		personalInfoPanel.add(dobLabel, "2, 10, right, default");
		
		dobField = new JFormattedTextField();
		personalInfoPanel.add(dobField, "4, 10, fill, default");
		
		JLabel raceLabel = new JLabel("Race");
		personalInfoPanel.add(raceLabel, "2, 12, right, default");
		
		raceBox = new JComboBox();
		raceBox.setModel(new DefaultComboBoxModel(new String[] {"Caucasian", "Black", "Asian", "Native American", "Latino", "Other"}));
		personalInfoPanel.add(raceBox, "4, 12, fill, default");
		
		JLabel genderLabel = new JLabel("Gender");
		personalInfoPanel.add(genderLabel, "2, 14, right, default");
		
		genderBox = new JComboBox();
		genderBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		personalInfoPanel.add(genderBox, "4, 14, fill, default");
		
		JLabel homeAddressLabel = new JLabel("Home Address");
		personalInfoPanel.add(homeAddressLabel, "2, 16, right, default");
		
		homeAddressField = new JFormattedTextField();
		personalInfoPanel.add(homeAddressField, "4, 16, fill, default");
		
		JLabel emailAddressLabel = new JLabel("Email Address");
		personalInfoPanel.add(emailAddressLabel, "2, 18, right, default");
		
		emailAddressField = new JFormattedTextField();
		personalInfoPanel.add(emailAddressField, "4, 18, fill, default");
		
		JLabel homePhoneLabel = new JLabel("Home Phone");
		personalInfoPanel.add(homePhoneLabel, "2, 20, right, default");
		
		homePhoneField = new JFormattedTextField();
		personalInfoPanel.add(homePhoneField, "4, 20, fill, default");
		
		JLabel callPhoneLabel = new JLabel("Cell Phone");
		personalInfoPanel.add(callPhoneLabel, "2, 22, right, default");
		
		cellPhoneField = new JFormattedTextField();
		personalInfoPanel.add(cellPhoneField, "4, 22, fill, default");
		
		JLabel lblAdditionalInformation = new JLabel("Additional Information");
		personalInfoPanel.add(lblAdditionalInformation, "2, 24");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		personalInfoPanel.add(scrollPane, "4, 24, fill, fill");
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		scrollPane.setViewportView(textArea_1);
	}
	
	public void createTestDataPane(){	
		testDataPanel = new JPanel();
		contentPanel.add(testDataPanel, "testData");
		
		JLabel lblNewLabel = new JLabel("Based on data previously entered:");
		
		JLabel lblNewLabel_1 = new JLabel("This Patients BMI is:");
		
		calculatedBMIField = new JTextField();
		calculatedBMIField.setEditable(false);
		calculatedBMIField.setColumns(10);
		
		JLabel lblExplanation = new JLabel("Explanation:");
		
		JLabel lblBloodPressure = new JLabel("Blood Pressure:");
		
		JLabel lblSystolicBloodPressure = new JLabel("Systolic Blood Pressure:");
		
		JLabel lblNewLabel_2 = new JLabel("Diastolic Blood Pressure:");
		
		JLabel lblMeanArterialBlood = new JLabel("Mean Arterial Blood Pressure:");
		
		systolicField = new JTextField();
		systolicField.setColumns(10);
		
		diastolicField = new JTextField();
		diastolicField.setColumns(10);
		
		MAPLabel = new JTextField();
		MAPLabel.setEditable(false);
		MAPLabel.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JLabel lblPatientAnalysis = new JLabel("Patient Analysis:");
		
		JButton btnNewButton = new JButton("Final Calculations");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (diastolicField.getText().length() > 0 && systolicField.getText().length() > 0){
					MAPLabel.setText(String.valueOf(DiagnosisHelper.calculateMAP(Double.parseDouble(diastolicField.getText()), Double.parseDouble(systolicField.getText()))));
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_testDataPanel = new GroupLayout(testDataPanel);
		gl_testDataPanel.setHorizontalGroup(
			gl_testDataPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_testDataPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBloodPressure)
					.addContainerGap(631, Short.MAX_VALUE))
				.addGroup(gl_testDataPanel.createSequentialGroup()
					.addGroup(gl_testDataPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_testDataPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 618, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_testDataPanel.createSequentialGroup()
							.addGroup(gl_testDataPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_testDataPanel.createSequentialGroup()
									.addGap(40)
									.addGroup(gl_testDataPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_2)
										.addComponent(lblSystolicBloodPressure)
										.addComponent(lblMeanArterialBlood))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_testDataPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(MAPLabel, 267, 267, Short.MAX_VALUE)
										.addComponent(diastolicField, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
										.addComponent(systolicField, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)))
								.addGroup(gl_testDataPanel.createSequentialGroup()
									.addGap(42)
									.addGroup(gl_testDataPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblExplanation)
										.addGroup(gl_testDataPanel.createSequentialGroup()
											.addComponent(lblNewLabel_1)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(calculatedBMIField, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE))))
								.addGroup(gl_testDataPanel.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblPatientAnalysis)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton)))
					.addGap(58))
				.addGroup(gl_testDataPanel.createSequentialGroup()
					.addGap(66)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 582, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(68, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_testDataPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addContainerGap(540, Short.MAX_VALUE))
		);
		gl_testDataPanel.setVerticalGroup(
			gl_testDataPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_testDataPanel.createSequentialGroup()
					.addGap(31)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_testDataPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(calculatedBMIField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblExplanation)
					.addGap(8)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_testDataPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_testDataPanel.createSequentialGroup()
							.addComponent(lblBloodPressure)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_testDataPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(systolicField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSystolicBloodPressure))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_testDataPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(diastolicField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_testDataPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMeanArterialBlood)
								.addComponent(MAPLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
							.addComponent(lblPatientAnalysis))
						.addGroup(gl_testDataPanel.createSequentialGroup()
							.addGap(123)
							.addComponent(btnNewButton)))
					.addGap(11)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addGap(208))
		);
		
		bmiExplanationField = new JTextArea();
		bmiExplanationField.setLineWrap(true);
		scrollPane.setViewportView(bmiExplanationField);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		scrollPane_1.setViewportView(textArea_1);
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
						if(heightField.getText().length() > 0 && weightField.getText().length() > 0){
							calculatedBMIField.setText(String.valueOf(DiagnosisHelper.calculateBMI(Double.parseDouble(heightField.getText()), Double.parseDouble(weightField.getText()))));
							bmiExplanationField.setText(DiagnosisHelper.analyizeBMI(DiagnosisHelper.calculateBMI(Double.parseDouble(heightField.getText()), Double.parseDouble(weightField.getText())), Double.parseDouble(heightField.getText()), Double.parseDouble(weightField.getText())));
						}
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
						PatientDialog.this.setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}