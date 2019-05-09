package com.JayPi4c.CollatzConjecture;

import java.awt.Color;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.text.NumberFormatter;

import com.JayPi4c.utils.TopicFrame;

public class CollatzConjectureFrame extends TopicFrame {

	private static final long serialVersionUID = 1852271395968902522L;

	private ButtonGroup bg;
	private JRadioButton calcBySteps;
	private JRadioButton calcByNumber;
	private JRadioButton calcInArray;

	private JButton start;
	private JFormattedTextField startValue, endValue;
	private JProgressBar progressBar;
	private JLabel output, runtime, remaining;
	private JPanel timePanel;

	public CollatzConjectureFrame(JFrame parent) {
		super("Collatz Conjecture", parent);
	}

	@Override
	public void createGUI() {
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

		timePanel = new JPanel();
		timePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.DARK_GRAY), "Time"));
		timePanel.setLayout(new BoxLayout(timePanel, BoxLayout.Y_AXIS));
		runtime = new JLabel("Runtime:");
		remaining = new JLabel("Remaining:     ");
		timePanel.add(runtime);
		timePanel.add(remaining);
		contentPanel.add(timePanel);

		calcByNumber = new JRadioButton("Calculate number of steps by integer", true);
		calcByNumber.addActionListener(e -> startValue.setEditable(false));
		calcBySteps = new JRadioButton("Calculate integer by number of steps", false);
		calcBySteps.addActionListener(e -> startValue.setEditable(false));
		calcInArray = new JRadioButton("Calculate the maximum number of steps in an array of integers", false);
		calcInArray.addActionListener(e -> startValue.setEditable(true));

		bg = new ButtonGroup();
		bg.add(calcByNumber);
		bg.add(calcBySteps);
		bg.add(calcInArray);
		contentPanel.add(calcByNumber);
		contentPanel.add(calcBySteps);
		contentPanel.add(calcInArray);

		progressBar = new JProgressBar(0, 42);
		progressBar.setStringPainted(true);
		contentPanel.add(progressBar);
		output = new JLabel("hier stehen informationen");
		contentPanel.add(output);
		NumberFormat format = NumberFormat.getInstance();
		format.setGroupingUsed(false);
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(0);
		formatter.setMaximum(Integer.MAX_VALUE);
		formatter.setAllowsInvalid(false);
		formatter.setCommitsOnValidEdit(false);
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
		inputPanel.add(startValue = new JFormattedTextField(format));
		startValue.setText("2");
		startValue.setEditable(false);
		inputPanel.add(endValue = new JFormattedTextField(format));
		endValue.setText("42");
		start = new JButton("start");
		start.addActionListener(e -> {
			if (calcInArray.isSelected()) {
				int begin = Integer.parseInt(startValue.getText());
				int end = Integer.parseInt(endValue.getText());
				new CollatzConjectureCalculator(begin, end, progressBar, output, timePanel).start();
			} else {
				int i = Integer.parseInt(endValue.getText());
				new CollatzConjectureCalculator(calcByNumber.isSelected() ? CollatzConjectureCalculator.MODE.BY_NUMBER
						: CollatzConjectureCalculator.MODE.BY_STEPS, i, output, timePanel).start();
			}
		});
		inputPanel.add(start);
		contentPanel.add(inputPanel);

	}

}
