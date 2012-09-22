package com.medicalmanager.main;

import java.awt.EventQueue;

import com.medicalmanager.views.TheGUI;

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
