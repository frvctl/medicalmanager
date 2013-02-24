package com.medicalmanager.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.medicalmanager.controllers.Database;
import com.medicalmanager.models.Patient;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class SearchDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField searchField;
	private JTextField minAgeField;
	private JTextField maxAgeField;
	private JTextField minHeightField;
	private JTextField maxHeightField;
	private JTextField minWeightField;
	private JTextField maxWeightField;

	/**
	 * Create the dialog.
	 */
	public SearchDialog() {
		setBounds(100, 100, 564, 368);
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
				FormFactory.DEFAULT_ROWSPEC,}));
		{
			JLabel lblNewLabel = new JLabel("Search By Name or PatientID - Leave Blank to Filter Only");
			contentPanel.add(lblNewLabel, "4, 4, 5, 1, center, default");
		}
		
		JLabel lblSearchString = new JLabel("Search String");
		contentPanel.add(lblSearchString, "2, 6, right, default");
		
		searchField = new JTextField();
		contentPanel.add(searchField, "4, 6, 5, 1, fill, default");
		searchField.setColumns(10);
		{
			JLabel lblFilter = new JLabel("Filter - Leave Blank to Not Filter by that Field");
			lblFilter.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblFilter, "4, 10, 5, 1, center, default");
		}
		{
			JLabel lblAge = new JLabel("Age");
			contentPanel.add(lblAge, "2, 12, right, default");
		}
		{
			minAgeField = new JTextField();
			contentPanel.add(minAgeField, "4, 12, fill, default");
			minAgeField.setColumns(10);
		}
		{
			JLabel lblThrough = new JLabel("through");
			contentPanel.add(lblThrough, "6, 12, right, default");
		}
		{
			maxAgeField = new JTextField();
			contentPanel.add(maxAgeField, "8, 12, fill, default");
			maxAgeField.setColumns(10);
		}
		{
			JLabel lblHeight = new JLabel("Height");
			contentPanel.add(lblHeight, "2, 14, right, default");
		}
		{
			minHeightField = new JTextField();
			minHeightField.setToolTipText("In Inches\r\n");
			contentPanel.add(minHeightField, "4, 14, fill, default");
			minHeightField.setColumns(10);
		}
		{
			JLabel lblThrough_1 = new JLabel("through");
			contentPanel.add(lblThrough_1, "6, 14, right, default");
		}
		{
			maxHeightField = new JTextField();
			maxHeightField.setToolTipText("In Inches\r\n");
			contentPanel.add(maxHeightField, "8, 14, fill, default");
			maxHeightField.setColumns(10);
		}
		{
			JLabel lblWeight = new JLabel("Weight");
			contentPanel.add(lblWeight, "2, 16, right, default");
		}
		{
			minWeightField = new JTextField();
			minWeightField.setToolTipText("In Pounds\r\n");
			contentPanel.add(minWeightField, "4, 16, fill, default");
			minWeightField.setColumns(10);
		}
		{
			JLabel lblThrough_2 = new JLabel("through");
			contentPanel.add(lblThrough_2, "6, 16, right, default");
		}
		{
			maxWeightField = new JTextField();
			maxWeightField.setToolTipText("In Pounds\r\n");
			contentPanel.add(maxWeightField, "8, 16, fill, default");
			maxWeightField.setColumns(10);
		}
		{
			JLabel lblGender = new JLabel("Gender");
			contentPanel.add(lblGender, "2, 18, right, default");
		}
		{
			JComboBox genderBox = new JComboBox();
			genderBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
			contentPanel.add(genderBox, "4, 18, 5, 1, fill, default");
		}
		{
			JLabel lblBmiClassification = new JLabel("BMI Classification");
			contentPanel.add(lblBmiClassification, "2, 20, right, default");
		}
		{
			JComboBox bmiBox = new JComboBox();
			bmiBox.setModel(new DefaultComboBoxModel(new String[] {"Under Weight", "Normal", "Over Weight"}));
			contentPanel.add(bmiBox, "4, 20, 5, 1, fill, default");
		}
		{
			JButton btnNewButton = new JButton("Search!");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("DERP");
					String ops[] = new String[1];
					ops[0] = searchField.getText();
					Patient results[] = Database.advancedPatientSearch(ops);
					PatientView.toTop(results);
					SearchResultsDialog dialog = new SearchResultsDialog(results);
					dialog.setVisible(true);
				}
			});
			contentPanel.add(btnNewButton, "2, 22, 7, 1");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						SearchDialog.this.setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
