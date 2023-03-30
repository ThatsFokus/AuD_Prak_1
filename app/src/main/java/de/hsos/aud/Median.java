package de.hsos.aud;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * Implementaion of quickselect algorithm w/o sorting the whole array
 * 
 * @author Fabian Arens, Yannic Brylankowski
 */

public class Median extends Sequence {

	int MedianOut = -1;
	int MedianIndex = -1;

	public Median(String fname) {
		super(fname);
	}

	public Median(int[] new_arr) {
		super(10);
		this.a = new_arr;
	}

	private int split(int l, int r) {
		/* l, r sind die Bereichsgrenzen. */
		int p = (l + r) / 2; /* mittleren Index nehmen oder ... würfeln */
		/* a[p] ist Pivot */
		/* Ziel: alle groesseren Elemente sind oberhalb von a[p] */
		this.swap(p, l); /* Teilungselement an Anfang tauschen */ // uncommented a from parameters
		p = l;
		for (int i = l + 1; i <= r; i++) {
			if (a[i] <= a[p]) {
				/* Element nach vorne schieben */
				swap(i, p + 1);
				swap(p, p + 1); // uncommented 'a' from parameters
				p = p + 1;
			}
		}
		return p;
	}

	public int find_kth() {
		int n = a.length - 1; // Länge/Größe des Felds
		int k = (a.length) / 2; // Pivot-Element festlegen
		int l = 1; // linke Bereichsgrenze
		int r = n; // rechte Bereichsgrenze = n
		while (true) {
			int p = split(l, r);
			if (p < k) { // k-tes im oberen Teilbereich suchen
				l = p + 1; // linke Suchbereichsgrenze anpassen
			} else if (p == k) { // jetzt Volltreffer, d.h. p == k:
				return (p);
			} else { // k < p => im unteren Bereich suchen
				r = p - 1; // rechte Suchbereichsgrenze anpassen
			}
		}
	}

	public void sort() {
		this.MedianIndex = this.find_kth();
		this.MedianOut = a[this.MedianIndex];
	}

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

		System.out.println("'" + fName + "', n = " + n + " (" + "user time = " + time_usr + " ms, cpu time = "
				+ time_cpu / 1000000 + " ms)" + " Median = " + MedianOut);
	}

	public static void run_test(String fName) {
		/* Einlesen der Datei -> nicht Zeit beruecksichtigen */
		Median qse = new Median(fName);
		/* Sortierfunktion aufrufen */
		qse.run_sort(fName);
		/* Backup aufrufen: wahlweise einkommentieren */
		// ss.backup(fName, "_sorted");
	}
}
