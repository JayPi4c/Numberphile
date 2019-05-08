package com.JayPi4c.CollatzConjecture;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

import com.JayPi4c.utils.TopicFrame;

public class CollatzConjectureFrame extends TopicFrame {

	private static final long serialVersionUID = 1852271395968902522L;

	public CollatzConjectureFrame(JFrame parent) {
		super("Collatz Conjecture", parent);

	}

	@Override
	public void createGUI() {
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		contentPanel.add(new JRadioButton("Das ist ein etwas längerer Text"));
		contentPanel.add(new JRadioButton("hallo"));
	}

}
