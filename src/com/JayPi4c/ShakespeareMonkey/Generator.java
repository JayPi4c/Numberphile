package com.JayPi4c.ShakespeareMonkey;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Generator {

	private static char alphabet[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
			'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'ä', 'ü', 'ö', 'ß' };
	private static Random random = new Random();

	public static final String n = System.getProperty("line.separator");
	public static long startmillis;
	public static long endmillis;

	public static void main(String[] args) throws IOException {
		File dataDir = new File(getExecutionPath() + "/data");
		if (!dataDir.exists()) {
			dataDir.mkdir();
		}
		System.out.println("data-Datei wurde erstellt");

		File file = new File(getExecutionPath() + "/data/randomShakespeare.rs");
		if (!file.exists()) {
			file.createNewFile();
		}

		System.out.println("randomShakespeare.rs wurde erstellt");

		BufferedWriter BW = new BufferedWriter(new FileWriter(file));

		startmillis = System.currentTimeMillis();
		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			System.out.println("Buchtabe NR " + i + " wurde generiert");

			int ran = random.nextInt(alphabet.length - 1);

			char ch = alphabet[ran];
			BW.write(ch);
			if (i % (Integer.MAX_VALUE / 100) == 0) {
				BW.write(n);
				System.out.println("neue Zeile");
			}
		}
		endmillis = System.currentTimeMillis();

		BW.close();

		System.out.println("successfully: Buchstaben wurden erstellt");
		System.out.println("Time used: " + (endmillis - startmillis) / 1000 + "sec");

		BufferedReader BR = new BufferedReader(new FileReader(file));

		for (int i = 0; i < 100; i++) {
			// lineContent[i] = BR.readLine();
			System.out.println("Zeile " + i + " der Ori-datei wird eingelesen");
			String content = BR.readLine();

			File file1 = new File(getExecutionPath() + "/data/randomShakespearePart" + i + ".rs");
			if (!file1.exists()) {
				file1.createNewFile();
			}
			BufferedWriter BW1 = new BufferedWriter(new FileWriter(file1));
			for (int j = 0; j < content.length(); j++) {
				BW1.write(content.charAt(j));
				System.out.println("schreibe Buchstabe: " + content.charAt(j));
				if (j % 100 == 0) {
					System.out.println("neue Zeile");
					BW1.write(n);
				}

			}

			BW1.close();

		}

		BR.close();

		System.out.println("Fertig");

	}

	private static String getExecutionPath() {
		String absolutePath = new File(".").getAbsolutePath();
		File file = new File(absolutePath);
		absolutePath = file.getParentFile().toString();
		return absolutePath;
	}
}