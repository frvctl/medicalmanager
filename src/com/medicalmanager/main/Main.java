package com.medicalmanager.main;

import com.medicalmanager.views.PatientView;

import java.awt.EventQueue;

/**
 * @school: Annandale High School
 * @IDE: Eclipse
 * @date: 3/6/2013
 * @author Ben Vest
 *
 */
public class Main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientView frame = new PatientView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
