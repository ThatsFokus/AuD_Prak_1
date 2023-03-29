package de.hsos.aud;

/**
 * Klasse implementiert SelectionSort Algorithmus.
 * 
 * @author heikerli
 */
public class SelectionSort extends Sequence {

	public SelectionSort(int size) {
		super(size);
	}

	public SelectionSort(String fName) {
		super(fName);
	}

	/**
	 * Die eigentliche Sortierfunktion.
	 */
	@Override
	public void sort() {
		for (int i = 1; i <= n - 1; i++) {
			int min_i = i;
			for (int j = i + 1; j <= n; j++) {
				if (a[j] < a[min_i]) {
					min_i = j;
				}
			}
			this.swap(min_i, i);
		}
	}

	/**
	 * Durchfuehrung eines Sortierdurchlaufs fuer eine Datei.
	 * 
	 * @param fName Datei mit zu sortierenden Daten.
	 */
	public static void run_test(String fName) {
		/* Einlesen der Datei -> nicht Zeit beruecksichtigen */
		SelectionSort ss = new SelectionSort(fName);
		/* Sortierfunktion aufrufen */
		ss.run_sort(fName);
		/* Backup aufrufen: wahlweise einkommentieren */
		// ss.backup(fName, "_sorted");
	}
}
