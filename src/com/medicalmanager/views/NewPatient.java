package com.medicalmanager.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.medicalmanager.models.Patient;

@SuppressWarnings("serial")
public class NewPatient extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nameField;
	private JTextField ageField;
	private JTextField weightField;
	private JTextField ICField;
	private JTextField textField_4;

	/**
	 * Create the dialog.
	 */
	public NewPatient() {
		setBackground(UIManager.getColor("CheckBox.light"));
		setTitle("Create a New Patient");
		setBounds(100, 100, 457, 313);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
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
				RowSpec.decode("default:grow"),}));
		{
			JLabel lblNewLabel = new JLabel("Name:");
			contentPanel.add(lblNewLabel, "2, 2, right, default");
		}
		{
			nameField = new JTextField();
			contentPanel.add(nameField, "4, 2, fill, default");
			nameField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Age:");
			contentPanel.add(lblNewLabel_1, "2, 4, right, default");
		}
		{
			ageField = new JTextField();
			contentPanel.add(ageField, "4, 4, fill, default");
			ageField.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Weight");
			contentPanel.add(lblNewLabel_2, "2, 6, right, default");
		}
		{
			weightField = new JTextField();
			contentPanel.add(weightField, "4, 6, fill, default");
			weightField.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Insurance Company:");
			contentPanel.add(lblNewLabel_3, "2, 8, right, default");
		}
		{
			ICField = new JTextField();
			contentPanel.add(ICField, "4, 8, fill, default");
			ICField.setColumns(10);
		}
		{
			JLabel lblDateOfBirth = new JLabel("Date of Birth:");
			contentPanel.add(lblDateOfBirth, "2, 10, right, default");
		}
		{
			JFormattedTextField formattedTextField = new JFormattedTextField();
			contentPanel.add(formattedTextField, "4, 10, fill, default");
		}
		{
			JLabel lblHeight = new JLabel("Height:");
			contentPanel.add(lblHeight, "2, 12, right, default");
		}
		{
			textField_4 = new JTextField();
			contentPanel.add(textField_4, "4, 12, fill, default");
			textField_4.setColumns(10);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Additional Comments");
			contentPanel.add(lblNewLabel_4, "2, 14");
		}
		{
			JTextArea textArea = new JTextArea();
			contentPanel.add(textArea, "4, 14, fill, fill");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");				
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				
				okButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						Patient p = new Patient();
						p	
						   .addAge(Integer.parseInt(ageField.getText()))
						   .addName(nameField.getText())
						   .addWeight(Double.parseDouble(weightField.getText()))
						   .addHeight(Double.parseDouble(ICField.getText()))
						   .addBMI(Double.parseDouble(weightField.getText()), Double.parseDouble(ICField.getText()));
						
//						// Basic Patient Information
//						private String name;
//						private String DOB;
//						private String address;
//						private String phoneNumber;
//						private String emailAddress;
//						
//						// Medical Information
//						private String insuranceCompany;
//						private String medicalConditions;
//						private String currentMedications;
//						private String additionalComments;
//						
//						// Numerical Values
//						private int ID;
//						private int age;
//						private double height;
//						private double weight;
//						
//						// Calculated
//						private double BMI;
//						private double averageSystolicBP;
						
						TheGUI.patientArray.add(p);
						TheGUI.listModel.addElement(p.getName());
					}
				});
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}