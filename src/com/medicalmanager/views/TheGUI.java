package com.medicalmanager.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JList;
import java.awt.Dimension;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TheGUI extends JFrame {

	private JPanel contentPane;

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

	/**
	 * Create the frame.
	 */
	public TheGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 609);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("New menu");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem menuItem = new JMenuItem("New menu item");
		mnNewMenu_1.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		final CardLayout bob = new CardLayout(0,0);
		contentPane.setLayout(bob);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "name_0");

		JSplitPane splitPane = new JSplitPane();
		
		JToolBar toolBar = new JToolBar();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(splitPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE))
		);
		
		JButton btnNewPatient = new JButton("New Patient");
		toolBar.add(btnNewPatient);
		
		JButton btnSearch = new JButton("Search");
		toolBar.add(btnSearch);
		
		JList list = new JList();
		list.setMinimumSize(new Dimension(200, 0));
		splitPane.setLeftComponent(list);
		
		JTextArea textArea = new JTextArea();
		splitPane.setRightComponent(textArea);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "name_1");
		bob.show(contentPane, "name_1");
		
		JLabel lblStuff = new JLabel("Stuff");
		panel.add(lblStuff);
		
		JButton btnClickToContinue = new JButton("Click to continue to good stuff");
		btnClickToContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bob.next(contentPane);
			}
		});
		panel.add(btnClickToContinue);
	}
}
