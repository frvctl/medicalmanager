package com.medicalmanager.views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class SavePatientDialog extends JDialog {
	private CardLayout card = new CardLayout(0,0);
	private final JPanel contentPanel = new JPanel();
	private JTextField maxRangeField;
	private JTextField searchField;
	private JTextField ageAdvancedField;
	private JTextField advancedMaxRangeField;
	private JTextField minRangeField;
	private JButton saveFilteredToFile;
	private JButton advancedSearchButton;
	private JButton filterButton;
	private JButton saveToFileButton;
	private JButton saveAdvancedSearchToFile;
	private JButton viewSearchResultsLabel;
	private JComboBox<String> genderPicker;
	private JComboBox<String> bmiPicker;
	private JComboBox<String> genderAdvancedPicker;
	private JComboBox<String> advancedbmiPicker;
	private JPanel saveMenuPane;
	private JPanel filterSavePane;
	private JPanel searchSavePane;


	/**
	 * Create the dialog.
	 */
	public SavePatientDialog() {
		setModal(true);
		setBounds(100, 100, 584, 355);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(card);
		
		saveMenuPane = new JPanel();
		contentPanel.add(saveMenuPane, "menu");
		
		JLabel allPatientLabel = new JLabel("All Patients:");
		
		saveToFileButton = new JButton("Save to File");
		saveToFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showSaveDialog(contentPanel);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					//DataHelper.saveToFile(file, options);
				}
			}
		});
		
		JLabel filterSaveLabel = new JLabel("Filter and Save:");
		
		filterButton = new JButton("Filter");
		filterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(contentPanel, "filterSave");
			}
		});
		
		JLabel searchSaveLabel = new JLabel("Advanced Search and Save:");
		
		advancedSearchButton = new JButton("Advanced Search");
		advancedSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(contentPanel, "searchSave");
			}
		});
		GroupLayout gl_saveMenuPane = new GroupLayout(saveMenuPane);
		gl_saveMenuPane.setHorizontalGroup(
			gl_saveMenuPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_saveMenuPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_saveMenuPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_saveMenuPane.createSequentialGroup()
							.addGap(23)
							.addGroup(gl_saveMenuPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(saveToFileButton, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
								.addComponent(filterButton, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
								.addComponent(advancedSearchButton, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE))
							.addGap(209))
						.addGroup(Alignment.TRAILING, gl_saveMenuPane.createSequentialGroup()
							.addComponent(allPatientLabel)
							.addContainerGap(491, Short.MAX_VALUE))
						.addGroup(gl_saveMenuPane.createSequentialGroup()
							.addComponent(filterSaveLabel)
							.addContainerGap(472, Short.MAX_VALUE))
						.addGroup(gl_saveMenuPane.createSequentialGroup()
							.addComponent(searchSaveLabel)
							.addContainerGap(412, Short.MAX_VALUE))))
		);
		gl_saveMenuPane.setVerticalGroup(
			gl_saveMenuPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_saveMenuPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(allPatientLabel)
					.addGap(11)
					.addComponent(saveToFileButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(filterSaveLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(filterButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(searchSaveLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(advancedSearchButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(61, Short.MAX_VALUE))
		);
		saveMenuPane.setLayout(gl_saveMenuPane);
		
		filterSavePane = new JPanel();
		contentPanel.add(filterSavePane, "filterSave");
		
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
		
		genderPicker = new JComboBox<String>();
		genderPicker.setModel(new DefaultComboBoxModel<String>(new String[] {"Both", "Male", "Female"}));
		
		JLabel genderLabel = new JLabel("Gender:");
		
		JLabel bmiClassificationLabel = new JLabel("BMI Classification");
		
		bmiPicker = new JComboBox<String>();
		bmiPicker.setModel(new DefaultComboBoxModel<String>(new String[] {"All", "Severely Underweight", "Underweight", "Normal", "Overweight", "Obese", "Morbidly Obese"}));
		
		saveFilteredToFile = new JButton("Save to File");
		saveFilteredToFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showSaveDialog(contentPanel);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					//DataHelper.saveToFile(file, searchandfilteroptions);
				}
			}
		});
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
		
		searchSavePane = new JPanel();
		contentPanel.add(searchSavePane, "searchSave");
		
		JLabel searchAndSaveLabel = new JLabel("Advanced Search and Save");
		searchAndSaveLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JLabel searchLabel = new JLabel("Search:");
		
		searchField = new JTextField();
		searchField.setColumns(10);
		
		viewSearchResultsLabel = new JButton("View Results");
		viewSearchResultsLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchResultsDialog dialog = new SearchResultsDialog();
				dialog.setVisible(true); 
			}
		});
		
		JLabel filterAdvancedLabel = new JLabel("Filter:");
		
		JLabel ageAdvancedLabel = new JLabel("Age");
		
		ageAdvancedField = new JTextField();
		ageAdvancedField.setColumns(10);
		
		JLabel advancedThroughLabel = new JLabel("through");
		
		advancedMaxRangeField = new JTextField();
		advancedMaxRangeField.setColumns(10);
		
		JLabel genderAdvancedLabel = new JLabel("Gender:");
		
		genderAdvancedPicker = new JComboBox<String>();
		genderAdvancedPicker.setModel(new DefaultComboBoxModel<String>(new String[] {"Both", "Male", "Female"}));
		
		JLabel advancedbmiLabel = new JLabel("BMI Classification:");
		
		advancedbmiPicker = new JComboBox<String>();
		advancedbmiPicker.setModel(new DefaultComboBoxModel<String>(new String[] {"Any", "Severely Underweight", "Underweight", "Normal", "Overweight", "Obese", "Morbidly Obese"}));
		
		saveAdvancedSearchToFile = new JButton("Save To File");
		saveAdvancedSearchToFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showSaveDialog(contentPanel);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					//DataHelper.saveToFile(file, options);
				}
			}
		});
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
