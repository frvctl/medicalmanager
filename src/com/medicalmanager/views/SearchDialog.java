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

@SuppressWarnings("serial")
public class SearchDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

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
		
		textField = new JTextField();
		contentPanel.add(textField, "4, 6, 5, 1, fill, default");
		textField.setColumns(10);
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
			textField_1 = new JTextField();
			contentPanel.add(textField_1, "4, 12, fill, default");
			textField_1.setColumns(10);
		}
		{
			JLabel lblThrough = new JLabel("through");
			contentPanel.add(lblThrough, "6, 12, right, default");
		}
		{
			textField_2 = new JTextField();
			contentPanel.add(textField_2, "8, 12, fill, default");
			textField_2.setColumns(10);
		}
		{
			JLabel lblHeight = new JLabel("Height");
			contentPanel.add(lblHeight, "2, 14, right, default");
		}
		{
			textField_3 = new JTextField();
			textField_3.setToolTipText("In Inches\r\n");
			contentPanel.add(textField_3, "4, 14, fill, default");
			textField_3.setColumns(10);
		}
		{
			JLabel lblThrough_1 = new JLabel("through");
			contentPanel.add(lblThrough_1, "6, 14, right, default");
		}
		{
			textField_4 = new JTextField();
			textField_4.setToolTipText("In Inches\r\n");
			contentPanel.add(textField_4, "8, 14, fill, default");
			textField_4.setColumns(10);
		}
		{
			JLabel lblWeight = new JLabel("Weight");
			contentPanel.add(lblWeight, "2, 16, right, default");
		}
		{
			textField_5 = new JTextField();
			textField_5.setToolTipText("In Pounds\r\n");
			contentPanel.add(textField_5, "4, 16, fill, default");
			textField_5.setColumns(10);
		}
		{
			JLabel lblThrough_2 = new JLabel("through");
			contentPanel.add(lblThrough_2, "6, 16, right, default");
		}
		{
			textField_6 = new JTextField();
			textField_6.setToolTipText("In Pounds\r\n");
			contentPanel.add(textField_6, "8, 16, fill, default");
			textField_6.setColumns(10);
		}
		{
			JLabel lblGender = new JLabel("Gender");
			contentPanel.add(lblGender, "2, 18, right, default");
		}
		{
			JComboBox comboBox = new JComboBox();
			contentPanel.add(comboBox, "4, 18, 5, 1, fill, default");
		}
		{
			JLabel lblBmiClassification = new JLabel("BMI Classification");
			contentPanel.add(lblBmiClassification, "2, 20, right, default");
		}
		{
			JComboBox comboBox = new JComboBox();
			contentPanel.add(comboBox, "4, 20, 5, 1, fill, default");
		}
		{
			JButton btnNewButton = new JButton("Search!");
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
