package com.JayPi4c.CollatzConjecture;

public class Calculator extends Thread {
	// public final static String lineSeparator =
	// System.getProperty("line.separator");

	public static int eingabe;
	public static int x = 1;
	public static int maximum_steps_to_one = 0;
	public static int steps_to_one = 0;
	public static int i;
	public static int longest_steps_integer = 0;
	public static int average = 0;

	public static double progress;
	public static int progressTotal;
	public static double time;
	public static double timeRemaining;

	public static long timeStart;
	public static long timeEnd;
	public static int timeNeededS;
	public static int timeNeededMin;
	public static int timeNeededH;

	@Override
	public void run() {
		eingabe = MainCC.i;
		if (MainCC.NumberOfSteps) {
			x = 1;
			maximum_steps_to_one = 0;
			steps_to_one = 0;
			longest_steps_integer = 0;
			average = 0;
			i = eingabe;
			System.out.println("neue Zahl für i: " + i);
			timeStart = System.currentTimeMillis();
			while (i > 1) {
				i = calculation(i);
				time = (System.currentTimeMillis() - timeStart) / 1000;
				GuiManager.runtime();
			}
			timeEnd = System.currentTimeMillis();
			timeNeededS = (int) (timeEnd - timeStart) / 1000;
			GuiManager.result1();
			message();
		}
		if (MainCC.WhichInt) {
			x = 1;
			maximum_steps_to_one = 0;
			steps_to_one = 0;
			longest_steps_integer = 0;
			average = 0;

			MainCC.TimeRemaining.getParent().invalidate();
			MainCC.TimeRemaining.setText("Remaining: Yet impossible to calculate.");
			MainCC.TimeRemaining.getParent().validate();
			timeStart = System.currentTimeMillis();
			while (steps_to_one != eingabe) {
				i = x;
				System.out.println("neue Zahl für i: " + i);
				MainCC.Progress.getParent().invalidate();
				MainCC.Progress.setText("Progress: New Number to Check " + i);
				MainCC.Progress.getParent().validate();
				steps_to_one = 0;
				while (i > 1) {
					i = calculation(i);
					time = (System.currentTimeMillis() - timeStart) / 1000;
					GuiManager.runtime();
					if (steps_to_one > eingabe) {
						i = 1;
						System.out.println("Es werden definitiv zu viele Schritte benötigt! bei " + x);
						MainCC.Result.getParent().invalidate();
						MainCC.Result.setText("Es werden definitiv zu viele Schritte benötigt! bei " + x);
						MainCC.Result.getParent().validate();
					}
					if (steps_to_one > maximum_steps_to_one) {
						maximum_steps_to_one = steps_to_one;
						longest_steps_integer = x;
						GuiManager.result_by_calculating();
					}
				}
				System.out.println("Bei " + x + " werden " + steps_to_one + " Schritte benötigt!");
				System.out.println("Die bisher meisten Schritte (" + maximum_steps_to_one + ") wurden bei ZahlNr. "
						+ longest_steps_integer + " erreicht!");
				x++;
			}
			i = x - 1;

			timeEnd = System.currentTimeMillis();
			timeNeededS = (int) (timeEnd - timeStart) / 1000;
			GuiManager.result2();
			message();
		}

		if (MainCC.StepsInArray) {
			x = 1;
			maximum_steps_to_one = 0;
			steps_to_one = 0;
			longest_steps_integer = 0;
			average = 0;

			timeStart = System.currentTimeMillis();
			while (x <= eingabe) {
				i = x;
				System.out.println("New Number for i: " + i);
				while (i > 1) {
					i = calculation(i);
				}
				average = average + steps_to_one;
				if (steps_to_one > maximum_steps_to_one) {
					maximum_steps_to_one = steps_to_one;
					longest_steps_integer = x;
					System.out.println(
							"New longest Way with: " + maximum_steps_to_one + ", at: " + longest_steps_integer);
					GuiManager.result_by_calculating();
				}
				steps_to_one = 0;

				progressTotal = (int) (((double) x / eingabe) * 10000) * 100;
				progress = (double) progressTotal / 10000;
				time = (System.currentTimeMillis() - timeStart) / 1000;
				timeRemaining = ((time / progress) * 100) - time;
				GuiManager.runtime();
				GuiManager.progress();
				GuiManager.Remaining();

				x++;
			}
			average = average / x;
			timeEnd = System.currentTimeMillis();
			timeNeededS = (int) (timeEnd - timeStart) / 1000;

			GuiManager.result();
			message();
		}
	}

	/**
	 * @param i Derzeitige Zahl, die auf gerade und ungerade überprüft und nach
	 *          vohandener Situation Gerade -> i / 2 Ungearde -> i*3 +1 bearbeitet
	 *          wird
	 * @return Gibt bearbeitetes i zurück
	 */

	private static int calculation(int i) {
		if (i % 2 == 1) {
			System.out.println(i + ": odd; stepNr. " + steps_to_one);
			i = 3 * i + 1;
			steps_to_one++;
		}
		if (i % 2 == 0) {
			System.out.println(i + ": even; stepNr. " + steps_to_one);
			i = i / 2;
			steps_to_one++;
		}
		return i;
	}

	public static void message() {
		System.out.println("Set calculationbooleans to false!");
		MainCC.WhichInt = false;
		MainCC.StepsInArray = false;
		MainCC.NumberOfSteps = false;
	}

}