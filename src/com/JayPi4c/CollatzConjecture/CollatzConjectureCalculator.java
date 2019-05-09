package com.JayPi4c.CollatzConjecture;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class CollatzConjectureCalculator extends Thread {

	public static enum MODE {
		BY_NUMBER, BY_STEPS, IN_ARRAY
	};

	private MODE mode;

	private int numberOfSteps;
	private int number;
	private int begin;
	private int end;

	private JProgressBar pBar;
	private JLabel out;
	private JPanel tPanel;

	public CollatzConjectureCalculator(MODE m, int i, JLabel output, JPanel timePanel) {
		mode = m;
		numberOfSteps = 0;
		number = i;
		out = output;
		tPanel = timePanel;
	}

	public CollatzConjectureCalculator(int begin, int end, JProgressBar progressBar, JLabel output, JPanel timePanel) {
		mode = MODE.IN_ARRAY;
		this.begin = begin;
		this.end = end;
		pBar = progressBar;
		pBar.setMinimum(begin);
		pBar.setMaximum(end);

		out = output;
		tPanel = timePanel;
	}

	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		if (mode == MODE.BY_NUMBER) {
			JLabel l = (JLabel) (tPanel.getComponent(1));
			l.setText("Remaining: unknown");
			l = (JLabel) (tPanel.getComponent(0));
			out.setText("calculating");
			int n = number;
			while (n > 1) {
				n = calculate(n);
				long t = System.currentTimeMillis();
				l.setText("Runtime: " + (t - startTime) / 1000.0 + "s");
			}
			out.setText(number + " needs " + numberOfSteps + " steps to come to 1.");
		} else if (mode == MODE.BY_STEPS) {
			JLabel l = (JLabel) (tPanel.getComponent(1));
			l.setText("Remaining: unknown");
			l = (JLabel) (tPanel.getComponent(0));
			out.setText("calculating");
			int n = 1;
			do {
				n++;
				numberOfSteps = 0;
				int n_ = n;
				while (n_ > 1) {
					n_ = calculate(n_);
					long t = System.currentTimeMillis();
					l.setText("Runtime: " + (t - startTime) / 1000.0 + "s");
				}

			} while (numberOfSteps != number);
			out.setText(n + " needs " + number + " steps to come to 1.");
		} else if (mode == MODE.IN_ARRAY) {
			JLabel runtime = (JLabel) (tPanel.getComponent(0));
			JLabel remaining = (JLabel) (tPanel.getComponent(1));
			int maxSteps = 0;
			int recordNumber = begin;
			for (int i = begin; i <= end; i++) {
				pBar.setValue(i);
				numberOfSteps = 0;
				int n = i;
				while (n > 1) {
					n = calculate(n);
					long t = System.currentTimeMillis();
					runtime.setText("Runtime: " + (t - startTime) / 1000.0 + "s");
					double r = (t - startTime) / 1000.0 / pBar.getPercentComplete() - (t - startTime) / 1000.0;
					remaining.setText("Remaining: " + r + "s");
				}

				if (numberOfSteps > maxSteps) {
					maxSteps = numberOfSteps;
					recordNumber = i;
				}
			}
			out.setText(recordNumber + " has the most steps with " + maxSteps + " steps.");
		}
	}

	private int calculate(int i) {
		numberOfSteps++;
		if (i % 2 == 0) {
			return i / 2;
		}

		return (i * 3 + 1);
	}

}
