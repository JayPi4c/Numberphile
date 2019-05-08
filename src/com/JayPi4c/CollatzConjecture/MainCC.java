package com.JayPi4c.CollatzConjecture;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JTextField;

import com.JayPi4c.Main;

public class MainCC extends JFrame implements ActionListener, Runnable {

	private static final long serialVersionUID = 1L;

	public static JLabel inputText;
	public static JButton confirm;
	public static JTextField inputTextField;
	public static JButton calculate;
	public static JButton credits;
	public static JRadioButton WhichIntRB;
	public static JRadioButton StepsInArrayRB;
	public static JRadioButton NumberOfStepsRB;
	public static JLabel Error;
	public static JLabel TimeRemaining;
	public static JLabel RunTime;
	public static JLabel Progress;
	public static JProgressBar ProgressBar;
	public static JLabel Result;
	public static JLabel Result1;
	public static JLabel TimeResult;
	public static JCheckBox Delay;
	public static JLabel FreeSpace;
	public static JLabel Error1;
	public static JButton Exit;
	public static MainCC frame;

	public static boolean WhichInt = false;
	public static boolean StepsInArray = false;
	public static boolean NumberOfSteps = false;

	static Calculator thread = new Calculator();
	public static int i = 42;

	/*
	 * public void run(String args[]) throws IOException{ MainCC frame = new
	 * MainCC("Collatz Conjecture"); frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	 * frame.setResizable(false); frame.setSize(600 ,600);
	 * frame.setLocationRelativeTo(null); frame.setLayout(null);
	 * frame.setVisible(true); groupButton(); }
	 */

	private static void groupButton() {
		ButtonGroup bgrb = new ButtonGroup();
		bgrb.add(NumberOfStepsRB);
		bgrb.add(StepsInArrayRB);
		bgrb.add(WhichIntRB);
	}

	public MainCC(String title) {
		super(title);
		confirm = new JButton("Confirm");
		confirm.addActionListener(this);
		confirm.setBounds(355, 490, 100, 30);
		add(confirm);
		confirm.setVisible(true);

		inputText = new JLabel("Number: 42");
		inputText.setBounds(180, 455, 400, 30);
		add(inputText);
		inputText.setVisible(true);

		inputTextField = new JTextField("42", 15);
		inputTextField.setBounds(250, 490, 100, 30);
		add(inputTextField);
		inputTextField.setVisible(true);

		calculate = new JButton("Start calculation");
		calculate.addActionListener(this);
		calculate.setBounds(200, 530, 200, 30);
		add(calculate);
		this.getRootPane().setDefaultButton(calculate);
		calculate.setVisible(true);

		credits = new JButton("Credits");
		credits.addActionListener(this);
		credits.setBounds(10, 530, 100, 30);
		add(credits);
		credits.setVisible(true);

		WhichIntRB = new JRadioButton("Calculate Integer by Number of Steps", false);
		WhichIntRB.setBounds(10, 300, 300, 20);
		add(WhichIntRB);
		WhichIntRB.setVisible(true);

		NumberOfStepsRB = new JRadioButton("Calculate number of steps by Integer", false);
		NumberOfStepsRB.setBounds(10, 325, 300, 20);
		add(NumberOfStepsRB);
		NumberOfStepsRB.setVisible(true);

		StepsInArrayRB = new JRadioButton("Calculate the steps in an array of Integer", true);
		StepsInArrayRB.setBounds(10, 350, 320, 20);
		add(StepsInArrayRB);
		StepsInArrayRB.setVisible(true);

		Error = new JLabel("Error, please check just one of the three operators.");
		Error.setBounds(50, 275, 400, 20);
		Error.setForeground(Color.ORANGE);
		add(Error);
		Error.setVisible(false);

		Error1 = new JLabel("Please choose any number but 1 or 0.");
		Error1.setBounds(50, 275, 400, 20);
		Error1.setForeground(Color.ORANGE);
		add(Error1);
		Error1.setVisible(false);

		TimeRemaining = new JLabel("Remaining: 0");
		TimeRemaining.setBounds(10, 225, 300, 20);
		add(TimeRemaining);
		TimeRemaining.setVisible(true);

		RunTime = new JLabel("Runtime: 0");
		RunTime.setBounds(10, 200, 300, 20);
		add(RunTime);
		RunTime.setVisible(true);

		/*
		 * Progress = new JLabel("progress: 0%"); Progress.setBounds(10, 250, 350, 20);
		 * add(Progress); Progress.setVisible(true);
		 */

		ProgressBar = new JProgressBar(0, 10000);
		ProgressBar.setBackground(Color.WHITE);
		ProgressBar.setForeground(Color.GREEN);
		ProgressBar.setBounds(10, 250, 350, 20);
		ProgressBar.setValue(0);
		ProgressBar.setStringPainted(true);
		ProgressBar.setString("progress: " + ProgressBar.getValue());
		add(ProgressBar);
		ProgressBar.setVisible(true);

		Result = new JLabel("Results");
		Result.setBounds(10, 390, 580, 20);
		add(Result);
		Result.setVisible(true);

		Result1 = new JLabel("");
		Result1.setBounds(10, 410, 580, 20);
		add(Result1);
		Result1.setVisible(true);

		TimeResult = new JLabel("Needed Time");
		TimeResult.setBounds(10, 435, 580, 20);
		add(TimeResult);
		TimeResult.setVisible(true);

		Delay = new JCheckBox("Delay to disp new longest setps", false);
		Delay.setBounds(330, 550, 300, 20);
		add(Delay);
		Delay.setVisible(false);

		FreeSpace = new JLabel("This is free space to add further options");
		FreeSpace.setBounds(0, 0, 600, 200);
		FreeSpace.setBackground(Color.YELLOW);
		FreeSpace.setForeground(Color.BLACK);
		add(FreeSpace);
		FreeSpace.setVisible(true);

		Exit = new JButton("Exit");
		Exit.addActionListener(this);
		Exit.setBounds(510, 530, 80, 20);
		add(Exit);
		Exit.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == confirm) {
			i = Integer.parseInt(inputTextField.getText());
			System.out.println(/* GuiManager.Kommasetzung( */i + " wurde eingegeben!");
			inputText.getParent().invalidate();
			inputText.setText("Number: " + /* GuiManager.Kommasetzung( */i);
			inputText.getParent().validate();
			Error1.setVisible(false);
			if (i == 1 || i == 0) {
				Error1.setVisible(true);
				i = 42;
			}
		}

		if (e.getSource() == calculate) {
			if (WhichIntRB.isSelected())
				WhichInt = true;
			if (StepsInArrayRB.isSelected())
				StepsInArray = true;
			if (NumberOfStepsRB.isSelected())
				NumberOfSteps = true;

			i = Integer.parseInt(inputTextField.getText());
			System.out.println(/* GuiManager.Kommasetzung( */i + " wurde eingegeben!");
			inputText.getParent().invalidate();
			inputText.setText("Number: " + /* GuiManager.Kommasetzung( */i);
			inputText.getParent().validate();

			thread = new Calculator();
			thread.start();
		}
		if (e.getSource() == credits) {
			Object[] options = { "OK" };
			JOptionPane.showOptionDialog(null,
					"This quellcode is influenced by the video:" + "\n" + "https://www.youtube.com/watch?v=5mFpVDpKX70"
							+ "\n" + "If you want to know, why this code was made, please watch this video!" + "\n"
							+ "Made by PohlProductions4c, developed by JayPi4c" + "\n" + "Official Version: 1.0.1"
							+ "\n" + "last Update: 27.10.2016",
					"Credits", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		}
		if (e.getSource() == Exit) {
			frame.setVisible(false);
			Main.Frame.setVisible(true);
			Thread.interrupted();
		}
	}

	@Override
	public void run() {
		frame = new MainCC("Collatz Conjecture");
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		// frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setVisible(true);
		groupButton();
	}

}