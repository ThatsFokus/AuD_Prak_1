package de.hsos.aud;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Random;

/**
 * Basisklasse zur Verwaltung eines Feldes von zu sortierenden Objekten.
 * 
 * @author heikerli
 */

public class Sequence implements SortIf {
	public int n = 16;
	public int a[];

	public Sequence(int size) {
		n = size;
		a = new int[n + 1];
		a[0] = n; /* speichert Laenge */
		for (int i = 1; i <= n; i++) {
			a[i] = i;
		}
	}

	/**
	 * Ctor. Generiert Sequence aus dem Inhalt einer Datei.
	 * 
	 * @param fileName Datei mit zu sortierenden Daten.
	 */
	public Sequence(String fileName) {
		/* Sequenz für Datei 'fileName' anlegen */
		BufferedReader in = null;
		FileReader fr = null;
		try {
			fr = new FileReader(fileName);
			in = new BufferedReader(fr);
			String line;
			/* Anzahl Elemente einlesen */
			if ((line = in.readLine()) == null) {
				System.err.println("Datei '" + fileName + "' falsch formatiert.");
			}
			if ((n = Integer.parseInt(line)) <= 1) {
				System.err.println("Datei '" + fileName + "' falsch formatiert.");
			}
			/* Feld erzeugen */
			a = new int[n + 1];
			a[0] = n;
			/* Feld fuellen: es werden nur n Zeilen gelesen */
			for (int i = 1; i <= n; i++) {
				line = in.readLine();
				int val = Integer.parseInt(line);
				a[i] = val;
			}
		} catch (FileNotFoundException ex) {
			System.err.println("Datei '" + fileName + "' nicht gefunden.");
		} catch (IOException ex) {
			System.err.println("Fehler beim Lesen von '" + fileName + "'.");
		} finally {
			try {
				in.close();
				if (fr != null) {
					fr.close();
				}
			} catch (Exception ex) {
			}
		}
	}

	/**
	 * Aufruf der Sortierfunktion. Laufzeiten werden ermittelt und ausgegeben.
	 * Ausserdem wird die Sortierung ueberprueft.
	 * 
	 * @param fName
	 */
	public void run_sort(String fName) {
		/* Einlesen der Datei -> nicht Zeit beruecksichtigen */

		ThreadMXBean thb = ManagementFactory.getThreadMXBean();
		long start_usr = System.currentTimeMillis();
		long start_cpu = thb.getCurrentThreadCpuTime();

		this.sort();

		long end_usr = System.currentTimeMillis();
		long end_cpu = thb.getCurrentThreadCpuTime();

		long time_usr = end_usr - start_usr;
		long time_cpu = end_cpu - start_cpu;

		if (!this.check_sorted()) {
			System.err.println("Datei ist nicht sortiert.");
		}

		//System.out.println("'" + fName + "', n = " + n + " (" + "user time = " + time_usr + " ms, cpu time = " + time_cpu / 1000000 + " ms)");
		System.out.println("'" + fName + "', n = " + n + " ( time = " + time_cpu / 1000000 + " ms)"); //simplified version of output
	}

	/**
	 * Sollte niemals aufgerufen werden, sondern immer nur von der abgeleiteten
	 * Klasse, die das Interface SortIf implementiert.
	 */
	public void sort() {
	}

	/**
	 * Test, ob Sequenz sortiert ist.
	 * 
	 * @return true falls Sortierung vorliegt.
	 */
	public boolean check_sorted() {
		for (int i = 1; i <= n; i++) {
			if ((i > 1) && (a[i] < a[i - 1]))
				return false;
		}
		return true;
	}

	public void swap(int i, int j) {
		int h = a[i];
		a[i] = a[j];
		a[j] = h;
	}

	/**
	 * Speichern der Sequenz in einer Datei.
	 * 
	 * @param fname   Name der Datei
	 * @param postfix Wird in Dateinamen vor der Dateiendung eingefuegt
	 */
	public void backup(String fname, String postfix) {
		int ext_idx = fname.lastIndexOf(".");

		String newFName = fname.substring(0, ext_idx);
		newFName = newFName.concat(postfix);
		newFName = newFName.concat(fname.substring(ext_idx, fname.length()));

		PrintWriter out = null;
		try {
			out = new PrintWriter(newFName);
			out.println(n);
			for (int i = 1; i <= n; i++) {
				out.println(a[i]);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}
		System.out.println("Sequenz unter: " + newFName + " gespeichert.");
	}

	private void print() {
		/* toString() ist Java-spezifisch */
		for (int i = 1; i <= n; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.print("\n");
	}

	/**
	 * Permutierung einer Sequenz.
	 * 
	 * @param rounds Anzahl der Runden zur Permutierung
	 */
	public void permute(int rounds) {
		Random rand = new Random();
		for (int r = 0; r < rounds; r++) {
			int i = 0, j = 0;
			/* Felder beginnen bei 1 und enden bei n, deshalb ... */
			while (i == 0)
				i = Math.abs(rand.nextInt()) % (n + 1);
			while (j == 0)
				j = Math.abs(rand.nextInt()) % (n + 1);
			this.swap(i, j);
		}
	}
}
