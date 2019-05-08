package com.JayPi4c.CollatzConjecture;

import javax.swing.JOptionPane;;

public class GuiManager {

	public static void result() {
		System.out
				.println("Bei einem Zahlenraum zwischen 1 und " + Calculator.eingabe + " ist der längste Weg zu 1 bei "
						+ Calculator.longest_steps_integer + " mit " + Calculator.maximum_steps_to_one + " Schritten!");
		System.out.println("Die durchschnittliche Anzahl an Schritten betraegt: " + Calculator.average + " Schritte!");
		System.out.println("Die Rechenzeit betrug: " + Calculator.timeNeededS + " Sekunden!");
		MainCC.Result.getParent().invalidate();
		MainCC.Result
				.setText("In einem Zahlenraum zwischen 1 und " + Calculator.eingabe + " ist der längste Weg zu 1 bei");
		MainCC.Result.getParent().validate();
		MainCC.Result1.getParent().invalidate();
		MainCC.Result1
				.setText(Calculator.longest_steps_integer + " mit " + Calculator.maximum_steps_to_one + " Schritten!");
		MainCC.Result1.getParent().validate();
		MainCC.Result1.setVisible(true);

		MainCC.TimeResult.getParent().invalidate();
		MainCC.TimeResult.setText("Die Rechenzeit betrug: " + Time((int) Calculator.time));
		MainCC.TimeResult.getParent().validate();

		Object[] options = { "OK" };
		JOptionPane.showOptionDialog(null,
				"In einem Zahlenraum zwischen 1 und " + Calculator.eingabe + " ist der längste Weg zu 1 bei" + "\n"
						+ Calculator.longest_steps_integer + " mit " + Calculator.maximum_steps_to_one + " Schritten!"
						+ "\n" + "Die Rechenzeit betrug: " + Time((int) Calculator.time) + "\n",
				"Result", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	}

	public static void result1() {
		System.out.println(
				"Die Zahl: " + Calculator.eingabe + " erreicht in " + Calculator.steps_to_one + " Schritten 1!");
		System.out.println("Die Rechenzeit betrug: " + Calculator.timeNeededS + " Sekunden!");
		System.out.println((Calculator.timeEnd - Calculator.timeStart) + " Millisekunden");
		MainCC.Result.getParent().invalidate();
		MainCC.Result.setText(
				"Die Zahl: " + Calculator.eingabe + " erreicht in " + Calculator.steps_to_one + " Schritten 1!");
		MainCC.Result.getParent().validate();
		MainCC.Result.setVisible(true);
		MainCC.Result1.setVisible(false);
		MainCC.TimeResult.getParent().invalidate();
		MainCC.TimeResult.setText("Die Rechenzeit betrug: " + Calculator.timeNeededS + " Sekunden; "
				+ (Calculator.timeEnd - Calculator.timeStart) + " Millisekunden");
		MainCC.TimeResult.getParent().validate();
		MainCC.TimeResult.setVisible(true);

		Object[] options = { "OK" };
		JOptionPane.showOptionDialog(null,
				"Die Zahl: " + Calculator.eingabe + " erreicht in " + Calculator.steps_to_one + " Schritten 1!" + "\n"
						+ "Die Rechenzeit betrug: " + Calculator.timeNeededS + " Sekunden; "
						+ (Calculator.timeEnd - Calculator.timeStart) + " Millisekunden",
				"Result", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	}

	public static void result2() {
		System.out.println("Die Zahl: " + Calculator.i + " erreicht in " + Calculator.eingabe + " Schritten 1!");
		System.out.println("Die Rechenzeit betrug: " + Calculator.timeNeededS + " Sekunden!");
		System.out.println((Calculator.timeEnd - Calculator.timeStart) + " Millisekunden");

		MainCC.Result.getParent().invalidate();
		MainCC.Result.setText("Die Zahl: " + Calculator.i + " erreicht in " + Calculator.eingabe + " Schritten 1!");
		MainCC.Result.getParent().validate();
		MainCC.Result.setVisible(true);
		MainCC.Result1.getParent().invalidate();
		MainCC.Result1.setText("Die Rechenzeit betrug: " + Calculator.timeNeededS + " Sekunden!");
		MainCC.Result1.getParent().validate();
		MainCC.Result1.setVisible(false);
		MainCC.TimeResult.getParent().invalidate();
		MainCC.TimeResult.setText("Time needed: " + Time(Calculator.timeNeededS));
		MainCC.TimeResult.getParent().validate();

		Object[] options = { "OK" };
		JOptionPane.showOptionDialog(null,
				"Die Zahl: " + Calculator.i + " erreicht in " + Calculator.eingabe + " Schritten 1!" + "\n"
						+ "Time needed: " + Time(Calculator.timeNeededS),
				"Result", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	}

	public static void result_by_calculating() {
		if (MainCC.Result.isVisible() == true) {
			System.out.println("neuer längster Weg mit: " + Calculator.maximum_steps_to_one + ", bei: "
					+ Calculator.longest_steps_integer);
			MainCC.Result1.getParent().invalidate();
			MainCC.Result1.setText("neuer längster Weg mit: " + Calculator.maximum_steps_to_one + ", bei: "
					+ Calculator.longest_steps_integer);
			MainCC.Result1.getParent().validate();
		} else {
			System.out.println("neuer längster Weg mit: " + Calculator.maximum_steps_to_one + ", bei: "
					+ Calculator.longest_steps_integer);
			MainCC.Result.getParent().invalidate();
			MainCC.Result.setText("neuer längster Weg mit: " + Calculator.maximum_steps_to_one + ", bei: "
					+ Calculator.longest_steps_integer);
			MainCC.Result.getParent().validate();
		}
	}

	public static void errorLog() {
		MainCC.Error.setVisible(true);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		MainCC.Error.setVisible(false);
	}

	public static void runtime() {
		System.out.println("Runtime: " + Time((int) Calculator.time));
		MainCC.RunTime.getParent().invalidate();
		MainCC.RunTime.setText("Runtime: " + Time((int) Calculator.time));
		MainCC.RunTime.getParent().validate();
	}

	public static void progress() {
		System.out
				.println((Calculator.eingabe - Calculator.x) + " number(s) to go (" + Calculator.progress + "% done)"); // (double)x
																														// castet
																														// den
																														// x
																														// Wert
																														// von
																														// Integer
																														// nach
																														// double
																														// für
																														// die
																														// Berechnung.
		/*
		 * MainCC.Progress.getParent().invalidate();
		 * MainCC.Progress.setText("Progress: "+(Calculator.eingabe-Calculator.x) +
		 * " number(s) to go (" +Calculator.progress + "% done)");
		 * MainCC.Progress.getParent().invalidate();
		 */
		MainCC.ProgressBar.setValue((int) (Calculator.progress) * 100);
		MainCC.ProgressBar.setString("Progress: " + (Calculator.eingabe - Calculator.x) + " number(s) to go ("
				+ Calculator.progress + "% done)");
	}

	public static void Remaining() {

		System.out.println(Time((int) Calculator.timeRemaining)/*
																 * "Remaining: " + Calculator.timeRemaining +
																 * " Sec; "+(Calculator.timeRemaining / 60)+"  Min; "
																 * +((Calculator.timeRemaining/60)/60)+" h"
																 */);
		MainCC.TimeRemaining.getParent().invalidate();
		MainCC.TimeRemaining.setText("Remaining: "
				+ Time((int) Calculator.timeRemaining)/*
														 * "Remaining: " + Calculator.timeRemaining +
														 * " Sec; "+(Calculator.timeRemaining / 60)+"  Min; "
														 * +((Calculator.timeRemaining/60)/60)+" h"
														 */);
		MainCC.TimeRemaining.getParent().validate();
	}

	/**
	 * 
	 * @param timeS Eingabe der Vergangenen Zeit in Sekunden.
	 * @return Gibt String mit Umrechnung in Stunden, Minuten und Sekunden aus.
	 * @author JayPi4c
	 * @Version 1.0
	 */
	private static String Time(int timeS) {
		int TimeSeconds = timeS;
		int TimeMinutes;
		int TimeHours;
		TimeMinutes = TimeSeconds / 60;
		TimeSeconds -= TimeMinutes * 60;
		TimeHours = TimeMinutes / 60;
		TimeMinutes -= TimeHours * 60; // TimeMinutes = TimeMinutes - TimeHours*60;
		return (TimeHours + " h " + TimeMinutes + " min " + TimeSeconds + " sec");
	}

	/*
	 * public static String Kommasetzung(int input){ String output; //String
	 * bla=String.valueOf(input); int Stellen = String.valueOf(input).length();
	 * for(Stellen > 0; Stellen--;){
	 * 
	 * }
	 * 
	 * return output;
	 * 
	 * }
	 */

}