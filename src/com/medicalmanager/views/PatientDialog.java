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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.medicalmanager.controllers.Database;
import com.medicalmanager.controllers.Diagnosis;
import com.medicalmanager.models.Patient;

public class PatientDialog extends JDialog {
	private JPanel testDataPanel;
	private JPanel buttonPane;
	private final JPanel contentPanel = new JPanel();
	
	private CardLayout cl = new CardLayout(0, 0);

	private JButton nextButton;
	private JButton okButton;
	private JButton backButton;  
	private JButton cancelButton;

	private JComboBox<String> raceBox;
	private JComboBox<String> genderBox;
	private JComboBox<String> tobaccoBox;
	private JComboBox<String> alcoholBox;
	
	private JFormattedTextField dobField;
	private JFormattedTextField homeAddressField;
	private JFormattedTextField emailAddressField;
	private JFormattedTextField homePhoneField;
	private JFormattedTextField cellPhoneField;

	private JTextArea explanationBMIField;
	private JTextArea textArea;
	private JTextArea bmiExplanationField;
	
	private JTextField ageField;
	private JTextField heightField;
	private JTextField weightField;
	private JTextField medicationField;
	private JTextField firstNameField;
	private JTextField middleNameField;
	private JTextField lastNameField;
	private JTextField meanArterialField;
	private JTextField systolicField;
	private JTextField diastolicField;
	private JTextField MAPLabel;
	private JTextField calculatedBMIField;
	private JScrollPane scrollPane_2;
	private JTextField medicalConditionsField;
	private JTextArea additionalMedicalInfoArea;
	private JTextArea additionalPatientInfoArea;
	private JTextArea patientAnalysisArea;

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
						.setID(Database.countLines())
						.setFirstName(firstNameField.getText())
						.setMiddleName(middleNameField.getText())
						.setLastName(lastNameField.getText())
						.setAge(Integer.parseInt(ageField.getText()))
						.setDOB(dobField.getText())
						.setAddress(homeAddressField.getText())
						.setEmailAddress(emailAddressField.getText())
						.setHomePhone(homePhoneField.getText())
						.setCellPhone(cellPhoneField.getText())
						.setMedicalConditions(medicalConditionsField.getText())
						.setCurrentMedications(medicationField.getText())
						.setAdditionalMedicalInformation(additionalMedicalInfoArea.getText())
						.setAdditionalPatientInformation(additionalPatientInfoArea.getText())
						.setPatientAnalysis(patientAnalysisArea.getText())
						.setHeight(Double.parseDouble(heightField.getText()))
						.setWeight(Double.parseDouble(weightField.getText()))
						.setTobaccoUsage(tobaccoBox.getSelectedItem().toString())
						.setAlcoholConsumption(alcoholBox.getSelectedItem().toString())
						.setRace(raceBox.getSelectedItem().toString())
						.setGender(genderBox.getSelectedItem().toString())
						.setCalculatedBMI()
						.setCalculatedMAP();
					
					Database.writeToFile(Patient.stringify(newPatient), true);
					PatientView.updateList(newPatient);
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				PatientDialog.this.setVisible(false);
			}
		});
	}
	
	
	public void createWelcomePane(){
		contentPanel.setLayout(cl);
	}
	
	public void createHealthInfoPane(){
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
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		personalInfoPanel.add(scrollPane_1, "4, 24, fill, fill");
		
		additionalPatientInfoArea = new JTextArea();
		additionalPatientInfoArea.setLineWrap(true);
		scrollPane_1.setViewportView(additionalPatientInfoArea);
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel hiddenInfoLabel = new JLabel("");
		healthInfoPanel.add(hiddenInfoLabel, "4, 2");
		
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
		
		JLabel medicalConditionsLabel = new JLabel("Current Medical Conditions");
		healthInfoPanel.add(medicalConditionsLabel, "2, 12, right, default");
		
		medicalConditionsField = new JTextField();
		healthInfoPanel.add(medicalConditionsField, "4, 12, fill, default");
		medicalConditionsField.setColumns(10);
		
		JLabel tobaccoLabel = new JLabel("Tobacco Usage");
		healthInfoPanel.add(tobaccoLabel, "2, 14, right, default");
		
		tobaccoBox = new JComboBox();
		tobaccoBox.setModel(new DefaultComboBoxModel(new String[] {"No - Never", "Yes - Previously but quit", "Yes - Rarely", "Yes - Frequently", "Yes - Several Packs a day"}));
		healthInfoPanel.add(tobaccoBox, "4, 14, fill, default");
		
		JLabel alcoholLabel = new JLabel("Alcohol Consumption");
		healthInfoPanel.add(alcoholLabel, "2, 16, right, default");
		
		JLabel commentsLabel = new JLabel("Additional Medical Info");
		healthInfoPanel.add(commentsLabel, "2, 18");
		
		alcoholBox = new JComboBox();
		alcoholBox.setModel(new DefaultComboBoxModel(new String[] {"No - Never", "Yes - Now has quit", "Yes - Moderate amounts", "Yes - Heavy drinker", "Yes - Very heavy drinker ", "Yes - Alcoholic / Alcoholism"}));
		healthInfoPanel.add(alcoholBox, "4, 16, fill, default");
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		healthInfoPanel.add(scrollPane_2, "4, 18, fill, fill");
		
		additionalMedicalInfoArea = new JTextArea();
		additionalMedicalInfoArea.setLineWrap(true);
		scrollPane_2.setViewportView(additionalMedicalInfoArea);
	}
	
	
	public void createPersonalInfoPane(){
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
					MAPLabel.setText(String.valueOf(Diagnosis.calculateMAP(Double.parseDouble(diastolicField.getText()), Double.parseDouble(systolicField.getText()))));
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
		
		patientAnalysisArea = new JTextArea();
		patientAnalysisArea.setLineWrap(true);
		scrollPane_1.setViewportView(patientAnalysisArea);
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
							calculatedBMIField.setText(String.valueOf(Diagnosis.calculateBMI(Double.parseDouble(heightField.getText()), Double.parseDouble(weightField.getText()))));
							bmiExplanationField.setText(Diagnosis.analyizeBMI(Diagnosis.calculateBMI(Double.parseDouble(heightField.getText()), Double.parseDouble(weightField.getText())), Double.parseDouble(heightField.getText()), Double.parseDouble(weightField.getText())));
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