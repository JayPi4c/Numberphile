package com.JayPi4c.utils;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class TopicFrame extends JFrame {

	private static final long serialVersionUID = -1266777167700516346L;

	private JButton exit;

	private JPanel rootPanel;

	public JPanel contentPanel;

	public TopicFrame(String title, JFrame parent) {
		super(title);
		rootPanel = new JPanel();

		rootPanel.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0;
		c.ipady = 0;
		c.weighty = 0;
		c.anchor = GridBagConstraints.PAGE_END;
		c.gridx = 4;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;

		exit = new JButton("Exit");
		exit.addActionListener(e -> {
			parent.setVisible(true);
			dispose();
		});
		rootPanel.add(exit, c);

		contentPanel = new JPanel();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.gridheight = 4;

		rootPanel.add(contentPanel, c);

		// rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.Y_AXIS));
		// rootPanel.add(exit);
		add(rootPanel);
		createGUI();
		pack();
		setLocationRelativeTo(parent);
		addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {

			}

			@Override
			public void windowIconified(WindowEvent e) {

			}

			@Override
			public void windowDeiconified(WindowEvent e) {

			}

			@Override
			public void windowDeactivated(WindowEvent e) {

			}

			@Override
			public void windowClosing(WindowEvent e) {

			}

			@Override
			public void windowClosed(WindowEvent e) {
				parent.setVisible(true);
				dispose();
			}

			@Override
			public void windowActivated(WindowEvent e) {

			}
		});
		setVisible(true);
	}

	abstract public void createGUI();

}
