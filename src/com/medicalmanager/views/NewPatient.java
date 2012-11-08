package com.medicalmanager.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;

public class NewPatient extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NewPatient dialog = new NewPatient();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NewPatient() {
		setBounds(100, 100, 531, 357);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new CardLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		contentPanel.add(panel_3, "name_213855493630117");
		
		JPanel panel_2 = new JPanel();
		contentPanel.add(panel_2, "name_213505969736000");
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
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
		
		JLabel lblName = new JLabel("First Name");
		panel_2.add(lblName, "2, 2, right, default");
		
		textField_4 = new JTextField();
		panel_2.add(textField_4, "4, 2, fill, default");
		textField_4.setColumns(10);
		
		JLabel lblMiddleName = new JLabel("Middle Name");
		panel_2.add(lblMiddleName, "2, 4, right, default");
		
		textField_5 = new JTextField();
		panel_2.add(textField_5, "4, 4, fill, default");
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Last Name");
		panel_2.add(lblNewLabel_5, "2, 6, right, default");
		
		textField_6 = new JTextField();
		panel_2.add(textField_6, "4, 6, fill, default");
		textField_6.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		panel_2.add(lblDateOfBirth, "2, 8, right, default");
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		panel_2.add(formattedTextField, "4, 8, fill, default");
		
		JLabel lblRace = new JLabel("Race");
		panel_2.add(lblRace, "2, 10, right, default");
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Caucasian", "Black", "Asian", "Native American", "Latino", "Other"}));
		panel_2.add(comboBox_3, "4, 10, fill, default");
		
		JLabel lblGender = new JLabel("Gender");
		panel_2.add(lblGender, "2, 12, right, default");
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		panel_2.add(comboBox_4, "4, 12, fill, default");
		
		JLabel lblHomeAddress = new JLabel("Home Address");
		panel_2.add(lblHomeAddress, "2, 14, right, default");
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		panel_2.add(formattedTextField_1, "4, 14, fill, default");
		
		JLabel lblEmailAddress = new JLabel("Email Address");
		panel_2.add(lblEmailAddress, "2, 16, right, default");
		
		JFormattedTextField formattedTextField_4 = new JFormattedTextField();
		panel_2.add(formattedTextField_4, "4, 16, fill, default");
		
		JLabel lblHomePhone = new JLabel("Home Phone");
		panel_2.add(lblHomePhone, "2, 18, right, default");
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		panel_2.add(formattedTextField_2, "4, 18, fill, default");
		
		JLabel lblCellPhone = new JLabel("Cell Phone");
		panel_2.add(lblCellPhone, "2, 20, right, default");
		
		JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		panel_2.add(formattedTextField_3, "4, 20, fill, default");
		
		JPanel panel_1 = new JPanel();
		contentPanel.add(panel_1, "name_212546842882753");
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
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
		
		JLabel lblNewLabel = new JLabel("Age");
		panel_1.add(lblNewLabel, "2, 2, right, default");
		
		textField = new JTextField();
		panel_1.add(textField, "4, 2, fill, default");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Height");
		panel_1.add(lblNewLabel_1, "2, 4, right, default");
		
		textField_1 = new JTextField();
		panel_1.add(textField_1, "4, 4, fill, default");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Weight");
		panel_1.add(lblNewLabel_2, "2, 6, right, default");
		
		textField_2 = new JTextField();
		panel_1.add(textField_2, "4, 6, fill, default");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Current Medications");
		panel_1.add(lblNewLabel_3, "2, 8, right, default");
		
		textField_3 = new JTextField();
		panel_1.add(textField_3, "4, 8, fill, default");
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Tobacco Usage");
		panel_1.add(lblNewLabel_4, "2, 10, right, default");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"No - Never", "Yes - Previously, now does not", "Yes - Rarely", "Yes - Frequently", "Yes - Chain Smoker or heavy chewer"}));
		panel_1.add(comboBox, "4, 10, fill, default");
		
		JLabel lblAlcohol = new JLabel("Alcohol Consumption");
		panel_1.add(lblAlcohol, "2, 12, right, default");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"No - Never", "Yes - Now has quit", "Yes - Moderate amounts", "Yes - Heavy drinker", "Yes - Very heavy drinker ", "Yes - Alcoholic / Alcoholism"}));
		panel_1.add(comboBox_1, "4, 12, fill, default");
		
		JLabel lblSexuallyActive = new JLabel("Sexually Active");
		panel_1.add(lblSexuallyActive, "2, 14, right, default");
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"No", "Yes"}));
		panel_1.add(comboBox_2, "4, 14, fill, default");
		
		JLabel lblAdditionalComments = new JLabel("Additional Comments");
		panel_1.add(lblAdditionalComments, "2, 16");
		
		JTextArea textArea = new JTextArea();
		panel_1.add(textArea, "4, 16, fill, fill");
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, "name_212470646027739");
			
			JLabel infoLabel = new JLabel("This is used to add a new patient to the database");
			
			JButton gotoGeneralInfo = new JButton("Click to Add General Info");
			gotoGeneralInfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			
			JButton gotoInsuranceInfo = new JButton("Insurance Information");
			
			JButton gotoBasicHealthInfo = new JButton("Basic Health Information");
			
			JButton gotoTestData = new JButton("Test Data for Interpretation");
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap(101, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(infoLabel)
								.addGap(85))
							.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
								.addGap(16)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(gotoInsuranceInfo)
									.addComponent(gotoGeneralInfo)
									.addComponent(gotoTestData)
									.addComponent(gotoBasicHealthInfo))
								.addGap(134))))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(infoLabel)
						.addGap(18)
						.addComponent(gotoBasicHealthInfo)
						.addGap(11)
						.addComponent(gotoGeneralInfo)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(gotoInsuranceInfo)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(gotoTestData)
						.addContainerGap(51, Short.MAX_VALUE))
			);
			panel.setLayout(gl_panel);
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
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
