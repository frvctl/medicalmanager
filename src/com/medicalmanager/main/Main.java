package com.medicalmanager.main;

import com.medicalmanager.views.TheGUI;

import java.awt.EventQueue;


public class Main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TheGUI frame = new TheGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
