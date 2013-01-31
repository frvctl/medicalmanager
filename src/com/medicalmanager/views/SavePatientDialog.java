package com.medicalmanager.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.DefaultComboBoxModel;

public class SavePatientDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SavePatientDialog dialog = new SavePatientDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SavePatientDialog() {
		setBounds(100, 100, 581, 347);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new CardLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPanel.add(panel_1, "name_3283134617744");
		
		JLabel lblSavePatient = new JLabel("Filter and Save Patients");
		lblSavePatient.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JLabel lblAgeRange = new JLabel("Age Range:");
		
		JLabel lblThrough = new JLabel("through");
		
		JLabel lblAges = new JLabel("Ages");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Both", "Male", "Female"}));
		
		JLabel lblGender = new JLabel("Gender:");
		
		JLabel lblWeightRange = new JLabel("BMI Classification");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"All", "Severely Underweight", "Underweight", "Normal", "Overweight", "Obese", "Morbidly Obese"}));
		
		JButton btnNewButton = new JButton("Save to File");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(137)
							.addComponent(lblSavePatient))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAgeRange))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(33)
							.addComponent(lblAges)
							.addGap(18)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(lblThrough)
							.addGap(18)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblGender))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addContainerGap(34, Short.MAX_VALUE)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 511, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addContainerGap(274, Short.MAX_VALUE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblWeightRange))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addGap(36)
							.addComponent(comboBox_1, 0, 509, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSavePatient)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblAgeRange)
							.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
							.addComponent(lblGender))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(42)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAges)
								.addComponent(lblThrough)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblWeightRange)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		contentPanel.add(panel_2, "name_3289717583433");
		
		JLabel lblNewLabel_3 = new JLabel("Advanced Search and Save");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JLabel lblSearch = new JLabel("Search:");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("View Results");
		
		JLabel lblFilter = new JLabel("Filter:");
		
		JLabel lblAge = new JLabel("Age");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblThrough_1 = new JLabel("through");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblGender_1 = new JLabel("Gender:");
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Both", "Male", "Female"}));
		
		JLabel lblBmiClassification = new JLabel("BMI Classification:");
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Any", "Severely Underweight", "Underweight", "Normal", "Overweight", "Obese", "Morbidly Obese"}));
		
		JButton btnNewButton_2 = new JButton("Save To File");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_2.createSequentialGroup()
								.addGap(123)
								.addComponent(lblNewLabel_3))
							.addGroup(gl_panel_2.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblSearch)
								.addGap(18)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
									.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)))
							.addGroup(gl_panel_2.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblFilter))
							.addGroup(gl_panel_2.createSequentialGroup()
								.addGap(32)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
									.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
										.addComponent(lblGender_1)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel_2.createSequentialGroup()
										.addComponent(lblAge)
										.addGap(12)
										.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
										.addGap(18)
										.addComponent(lblThrough_1)
										.addGap(23)
										.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel_2.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblBmiClassification)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(comboBox_3, 0, 416, Short.MAX_VALUE))))))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSearch)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblFilter)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAge)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblThrough_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblGender_1)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBmiClassification))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnNewButton_2)
					.addGap(8))
		);
		panel_2.setLayout(gl_panel_2);
		
		
		
		JPanel panel = new JPanel();
		contentPanel.add(panel, "name_3276893543254");
		
		JButton pickLocationButton = new JButton("Pick File Location");
		
		JLabel lblNewLabel = new JLabel("All Patients:");
		
		JButton saveToFileButton = new JButton("Save to File");
		
		JLabel lblNewLabel_1 = new JLabel("Filter and Save:");
		
		JButton filterButton = new JButton("Filter");
		
		JLabel lblNewLabel_2 = new JLabel("Advanced Search and Save:");
		
		JButton advancedSearchButton = new JButton("Advanced Search");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(pickLocationButton, GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
								.addComponent(lblNewLabel))
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addContainerGap(469, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGap(23)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(advancedSearchButton, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
								.addComponent(filterButton, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
								.addComponent(saveToFileButton, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE))
							.addGap(209))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addContainerGap(499, Short.MAX_VALUE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(pickLocationButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(saveToFileButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(filterButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(advancedSearchButton, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
