package com.JayPi4c;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main extends JFrame implements ActionListener {

	public static Thread RunnableCC;
	public static Main Frame;

	private static final long serialVersionUID = 1L;

	public static JButton CollatzConjecture;
	public static JButton Something;

	public static void main(String[] args) {
		Frame = new Main("Numberphile");
		Frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Frame.setSize(600, 600);
		Frame.setLocationRelativeTo(null);
		Frame.setLayout(null);
		// Frame.setIconImage(new
		// ImageIcon(getClass().getResource("Icon.png")).getImage());
		Frame.setVisible(true);

	}

	public Main(String name) {
		super(name);

		CollatzConjecture = new JButton("Collatz Conjecture");
		CollatzConjecture.setBounds(300, 100, 150, 30);
		CollatzConjecture.addActionListener(this);
		add(CollatzConjecture);
		CollatzConjecture.setVisible(true);

		Something = new JButton("Something");
		Something.setBounds(300, 140, 150, 30);
		Something.addActionListener(this);
		add(Something);
		Something.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == CollatzConjecture) {
			Frame.setVisible(false);
			RunnableCC = new Thread(new com.JayPi4c.CollatzConjecture.MainCC(""));
			RunnableCC.start();
		}
	}

}