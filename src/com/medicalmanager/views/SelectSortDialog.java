package com.medicalmanager.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import com.medicalmanager.controllers.Database;

/**
 * @school: Annandale High School
 * @IDE: Eclipse
 * @date: 3/6/2013
 * @author Ben Vest
 *
 */
public class SelectSortDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton sortByLastName;
	private JButton sortByHeight;

	/**
	 * Create the dialog.
	 */
	public SelectSortDialog() {
		setTitle("Sort Patients");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JButton sortByFirstName = new JButton("Sort by First Name");
		sortByFirstName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientView.sortList(Database.sortPatients(PatientView.getPatientArray(), "FIRST_COMP", true, false));
				SelectSortDialog.this.setVisible(false);
			}
		});
		{
			sortByLastName = new JButton("Sort by Last Name");
			sortByLastName.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PatientView.sortList(Database.sortPatients(PatientView.getPatientArray(), "LAST_COMP", true, false));
					SelectSortDialog.this.setVisible(false);
				}
			});
		}
		{
			sortByHeight = new JButton("Sort by Height");
			sortByHeight.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PatientView.sortList(Database.sortPatients(PatientView.getPatientArray(), "HEIGHT_COMP", true, true));
					SelectSortDialog.this.setVisible(false);
				}
			});
		}
		
		JRadioButton acsendingRadio = new JRadioButton("Acsending (0-10 or A-B)");
		acsendingRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		acsendingRadio.setSelected(true);
		
		JRadioButton descendingRadio = new JRadioButton("Descending (10-0 or B-A)");
		descendingRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton sortByWeight = new JButton("Sort By Weight");
		sortByWeight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PatientView.sortList(Database.sortPatients(PatientView.getPatientArray(), "WEIGHT_COMP", true, true));
				SelectSortDialog.this.setVisible(false);
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(61)
					.addComponent(sortByFirstName, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(61)
					.addComponent(sortByLastName, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(62)
					.addComponent(acsendingRadio)
					.addGap(6)
					.addComponent(descendingRadio, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(61)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(sortByWeight, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(sortByHeight, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(15)
					.addComponent(sortByFirstName, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(sortByLastName, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(sortByHeight, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(sortByWeight, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(acsendingRadio)
						.addComponent(descendingRadio)))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						SelectSortDialog.this.setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
