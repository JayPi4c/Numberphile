package com.JayPi4c;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.JayPi4c.CollatzConjecture.CollatzConjectureFrame;

public class Main extends JFrame {

	private static final long serialVersionUID = -777704115043183929L;

	private JButton CollatzConjecture;
	private JButton Project1, Project2;

	public static void main(String args[]) {
		new Main();
	}

	public Main() {
		super("Numberphile");

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));

		CollatzConjecture = new JButton("Collatz Conjecture");
		CollatzConjecture.setAlignmentX(Component.CENTER_ALIGNMENT);
		CollatzConjecture.addActionListener(e -> {
			new CollatzConjectureFrame(this);
			setVisible(false);
		});
		buttonPanel.add(CollatzConjecture);

		Project1 = new JButton("Project1");
		Project1.setAlignmentX(Component.CENTER_ALIGNMENT);
		Project1.addActionListener(e -> {
			System.out.println("Hello World 1");
		});
		buttonPanel.add(Project1);

		Project2 = new JButton("Project2");
		Project2.setAlignmentX(Component.CENTER_ALIGNMENT);
		Project2.addActionListener(e -> {
			System.out.println("Hello World 2");
		});
		buttonPanel.add(Project2);

		add(buttonPanel);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

}