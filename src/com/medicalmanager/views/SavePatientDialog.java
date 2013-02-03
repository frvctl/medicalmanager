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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.DefaultComboBoxModel;

public class SavePatientDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField maxRangeField;
	private JTextField searchField;
	private JTextField ageAdvancedField;
	private JTextField advancedMaxRangeField;
	private JButton pickLocationButton;
	private JButton advancedSearchButton;
	private JButton filterButton;
	private JButton saveToFileButton;
	private JTextField minRangeField;
	private JComboBox genderPicker;
	private JButton saveFilteredToFile;
	private JComboBox bmiPicker;
	private JButton saveAdvancedSearchToFile;
	private JButton viewSearchResultsLabel;
	private JComboBox genderAdvancedPicker;
	private JComboBox advancedbmiPicker;

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
		setModal(true);
		setBounds(100, 100, 584, 355);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new CardLayout(0, 0));
		
		
		
		JPanel saveMenuPane = new JPanel();
		contentPanel.add(saveMenuPane, "name_1114084869189");
		
		pickLocationButton = new JButton("Pick File Location");
		
		JLabel allPatientLabel = new JLabel("All Patients:");
		
		saveToFileButton = new JButton("Save to File");
		
		JLabel filterSaveLabel = new JLabel("Filter and Save:");
		
		filterButton = new JButton("Filter");
		
		JLabel searchSaveLabel = new JLabel("Advanced Search and Save:");
		
		advancedSearchButton = new JButton("Advanced Search");
		GroupLayout gl_saveMenuPane = new GroupLayout(saveMenuPane);
		gl_saveMenuPane.setHorizontalGroup(
			gl_saveMenuPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_saveMenuPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_saveMenuPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_saveMenuPane.createSequentialGroup()
							.addGroup(gl_saveMenuPane.createParallelGroup(Alignment.LEADING)
								.addComponent(pickLocationButton, GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
								.addComponent(allPatientLabel))
							.addContainerGap())
						.addGroup(gl_saveMenuPane.createSequentialGroup()
							.addComponent(filterSaveLabel)
							.addContainerGap(469, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_saveMenuPane.createSequentialGroup()
							.addGap(23)
							.addGroup(gl_saveMenuPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(advancedSearchButton, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
								.addComponent(filterButton, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
								.addComponent(saveToFileButton, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE))
							.addGap(209))
						.addGroup(gl_saveMenuPane.createSequentialGroup()
							.addComponent(searchSaveLabel)
							.addContainerGap(499, Short.MAX_VALUE))))
		);
		gl_saveMenuPane.setVerticalGroup(
			gl_saveMenuPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_saveMenuPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(pickLocationButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(allPatientLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(saveToFileButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(filterSaveLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(filterButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(searchSaveLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(advancedSearchButton, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
					.addContainerGap())
		);
		saveMenuPane.setLayout(gl_saveMenuPane);
		
		JPanel filterSavePane = new JPanel();
		contentPanel.add(filterSavePane, "name_3283134617744");
		
		JLabel savePatientLabel = new JLabel("Filter and Save Patients");
		savePatientLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JLabel ageRangeLabel = new JLabel("Age Range:");
		
		JLabel throughLabel = new JLabel("through");
		
		JLabel ageLabel = new JLabel("Ages");
		
		minRangeField = new JTextField();
		minRangeField.setText("0");
		minRangeField.setColumns(10);
		
		maxRangeField = new JTextField();
		maxRangeField.setText("100");
		maxRangeField.setColumns(10);
		
		genderPicker = new JComboBox();
		genderPicker.setModel(new DefaultComboBoxModel(new String[] {"Both", "Male", "Female"}));
		
		JLabel genderLabel = new JLabel("Gender:");
		
		JLabel bmiClassificationLabel = new JLabel("BMI Classification");
		
		bmiPicker = new JComboBox();
		bmiPicker.setModel(new DefaultComboBoxModel(new String[] {"All", "Severely Underweight", "Underweight", "Normal", "Overweight", "Obese", "Morbidly Obese"}));
		
		saveFilteredToFile = new JButton("Save to File");
		GroupLayout gl_filterSavePane = new GroupLayout(filterSavePane);
		gl_filterSavePane.setHorizontalGroup(
			gl_filterSavePane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_filterSavePane.createSequentialGroup()
					.addGroup(gl_filterSavePane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_filterSavePane.createSequentialGroup()
							.addGap(137)
							.addComponent(savePatientLabel))
						.addGroup(gl_filterSavePane.createSequentialGroup()
							.addContainerGap()
							.addComponent(ageRangeLabel))
						.addGroup(gl_filterSavePane.createSequentialGroup()
							.addGap(33)
							.addComponent(ageLabel)
							.addGap(18)
							.addComponent(minRangeField, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(throughLabel)
							.addGap(18)
							.addComponent(maxRangeField, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_filterSavePane.createSequentialGroup()
							.addContainerGap()
							.addComponent(genderLabel))
						.addGroup(Alignment.TRAILING, gl_filterSavePane.createSequentialGroup()
							.addContainerGap(34, Short.MAX_VALUE)
							.addComponent(genderPicker, GroupLayout.PREFERRED_SIZE, 511, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_filterSavePane.createSequentialGroup()
							.addContainerGap(274, Short.MAX_VALUE)
							.addComponent(saveFilteredToFile, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_filterSavePane.createSequentialGroup()
							.addContainerGap()
							.addComponent(bmiClassificationLabel))
						.addGroup(Alignment.TRAILING, gl_filterSavePane.createSequentialGroup()
							.addGap(36)
							.addComponent(bmiPicker, 0, 509, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_filterSavePane.setVerticalGroup(
			gl_filterSavePane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_filterSavePane.createSequentialGroup()
					.addContainerGap()
					.addComponent(savePatientLabel)
					.addGroup(gl_filterSavePane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_filterSavePane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(ageRangeLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
							.addComponent(genderLabel))
						.addGroup(gl_filterSavePane.createSequentialGroup()
							.addGap(42)
							.addGroup(gl_filterSavePane.createParallelGroup(Alignment.BASELINE)
								.addComponent(minRangeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(ageLabel)
								.addComponent(throughLabel)
								.addComponent(maxRangeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(genderPicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(bmiClassificationLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(bmiPicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(saveFilteredToFile, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		filterSavePane.setLayout(gl_filterSavePane);
		
		JPanel searchSavePane = new JPanel();
		contentPanel.add(searchSavePane, "name_3289717583433");
		
		JLabel searchAndSaveLabel = new JLabel("Advanced Search and Save");
		searchAndSaveLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JLabel searchLabel = new JLabel("Search:");
		
		searchField = new JTextField();
		searchField.setColumns(10);
		
		viewSearchResultsLabel = new JButton("View Results");
		
		JLabel filterAdvancedLabel = new JLabel("Filter:");
		
		JLabel ageAdvancedLabel = new JLabel("Age");
		
		ageAdvancedField = new JTextField();
		ageAdvancedField.setColumns(10);
		
		JLabel advancedThroughLabel = new JLabel("through");
		
		advancedMaxRangeField = new JTextField();
		advancedMaxRangeField.setColumns(10);
		
		JLabel genderAdvancedLabel = new JLabel("Gender:");
		
		genderAdvancedPicker = new JComboBox();
		genderAdvancedPicker.setModel(new DefaultComboBoxModel(new String[] {"Both", "Male", "Female"}));
		
		JLabel advancedbmiLabel = new JLabel("BMI Classification:");
		
		advancedbmiPicker = new JComboBox();
		advancedbmiPicker.setModel(new DefaultComboBoxModel(new String[] {"Any", "Severely Underweight", "Underweight", "Normal", "Overweight", "Obese", "Morbidly Obese"}));
		
		saveAdvancedSearchToFile = new JButton("Save To File");
		GroupLayout gl_searchSavePane = new GroupLayout(searchSavePane);
		gl_searchSavePane.setHorizontalGroup(
			gl_searchSavePane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_searchSavePane.createSequentialGroup()
					.addGroup(gl_searchSavePane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_searchSavePane.createSequentialGroup()
							.addContainerGap()
							.addComponent(saveAdvancedSearchToFile, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_searchSavePane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_searchSavePane.createSequentialGroup()
								.addGap(123)
								.addComponent(searchAndSaveLabel))
							.addGroup(gl_searchSavePane.createSequentialGroup()
								.addContainerGap()
								.addComponent(searchLabel)
								.addGap(18)
								.addGroup(gl_searchSavePane.createParallelGroup(Alignment.LEADING)
									.addComponent(viewSearchResultsLabel, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
									.addComponent(searchField, GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)))
							.addGroup(gl_searchSavePane.createSequentialGroup()
								.addContainerGap()
								.addComponent(filterAdvancedLabel))
							.addGroup(gl_searchSavePane.createSequentialGroup()
								.addGap(32)
								.addGroup(gl_searchSavePane.createParallelGroup(Alignment.LEADING)
									.addGroup(Alignment.TRAILING, gl_searchSavePane.createSequentialGroup()
										.addComponent(genderAdvancedLabel)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(genderAdvancedPicker, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_searchSavePane.createSequentialGroup()
										.addComponent(ageAdvancedLabel)
										.addGap(12)
										.addComponent(ageAdvancedField, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
										.addGap(18)
										.addComponent(advancedThroughLabel)
										.addGap(23)
										.addComponent(advancedMaxRangeField, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_searchSavePane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(advancedbmiLabel)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(advancedbmiPicker, 0, 416, Short.MAX_VALUE))))))
					.addContainerGap())
		);
		gl_searchSavePane.setVerticalGroup(
			gl_searchSavePane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_searchSavePane.createSequentialGroup()
					.addContainerGap()
					.addComponent(searchAndSaveLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_searchSavePane.createParallelGroup(Alignment.BASELINE)
						.addComponent(searchLabel)
						.addComponent(searchField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(viewSearchResultsLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(filterAdvancedLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_searchSavePane.createParallelGroup(Alignment.BASELINE)
						.addComponent(ageAdvancedLabel)
						.addComponent(advancedMaxRangeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ageAdvancedField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(advancedThroughLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_searchSavePane.createParallelGroup(Alignment.LEADING)
						.addComponent(genderAdvancedLabel)
						.addComponent(genderAdvancedPicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addGroup(gl_searchSavePane.createParallelGroup(Alignment.BASELINE)
						.addComponent(advancedbmiPicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(advancedbmiLabel))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(saveAdvancedSearchToFile)
					.addGap(8))
		);
		searchSavePane.setLayout(gl_searchSavePane);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						SavePatientDialog.this.setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
