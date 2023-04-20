//TODO: Add comments for the presentation!!!
package de.hsos.aud;

/**
 * Implementation of quicksort algorithm
 * 
 * @author Fabian Arens, Yannic Brylankowski
 */

public class QuickSort extends Sequence {

	public QuickSort(int size) {
		super(size);
	}

	public QuickSort(String fName) {
		super(fName);
	}

	/**
	 * 
	 * @param l unteres limit
	 * @param h oberes limit
	 * @return index des pivot elementes
	 */
	private int partition(int l, int h) {
		int p_index = h;
		int pivot = a[p_index];

		int p = l;
		for (int i = l; i < h; i++) {
			if (a[i] <= pivot) {
				swap(i, p);
				p++;
			}
		}
		swap(p, p_index);
		return p;
	}

	/**
	 * 
	 * @param l oberes limit
	 * @param h unteres limit
	 */
	private void run_qsort(int l, int h) {
		// Simuliere einen Stack
		int[] stack = new int[h - l + 1];
		int top = 0;

		// schiebe unteres und oberes Limit
		stack[++top] = l;
		stack[++top] = h;

		while (top != 0) { // Laufen lassen bis Stapel leer ist
			// pop aus unterem und oberem limit
			h = stack[top--];
			l = stack[top--];

			int pivot = partition(l, h);
			if (pivot - 1 > l) {
				stack[++top] = l;
				stack[++top] = pivot - 1;
			}

			if (pivot + 1 < h) {
				stack[++top] = pivot + 1;
				stack[++top] = h;
			}
		}
	}

	/**
	 * 
	 * @param l unteres limit
	 * @param m mittlerer mittelwert
	 * @param h oberes limit
	 * @return index des Median aus Drei
	 */
	int medianOfThree(int l, int m, int h) {
        if ((a[l] > a[h]) ^ (a[l] > a[m])) 
            return l;
        else if ((a[h] < a[l]) ^ (a[h] < a[m])) 
            return h;
        else
            return m;
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

	public int find_kth(int l, int r) {
		int n = r-l; // Länge/Größe des Felds
		int k = (r-l) / 2; // Pivot-Element festlegen
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

	/**
	 * Anwenden des median of three Algorithmusses auf den bestehenden Array
	 * @param l minimum index aus dem Substack
	 * @param h Maximum index aus dem Substack
	 * @return index des pivot elementes
	 */
    protected int partition_median(int l, int h) {
        int p_index = find_kth(l, h);

        swap(p_index, l);
        p_index = l;

        for (int i = l + 1; i <= h; i++) {
            if (a[i] <= a[p_index]) {
                swap(i, p_index + 1);
                swap(p_index, p_index + 1);
                p_index++;
            }
        }

        return p_index;
    }

	/**
	 * Ueberschreiben von  sort
	 */
	public void sort() {
		try {
			// recursive_quicksort(1, a[0] - 1);
			// a = new int[] {234, 456, 234, 643, 21123, 65 };
			// System.out.println(java.util.Arrays.toString(a));
			run_qsort(1, this.n);
			// System.out.println(java.util.Arrays.toString(a));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * Anwenden des median of three Algorithmusses auf den bestehenden Array
	 * @param l minimum index aus dem 
	 * @param h max index in substack
	 * @return index des Medians aus drei
	 */

	/**
	 * Durchfuehrung eines Sortierdurchlaufs fuer eine Datei.
	 * 
	 * @param fName Datei mit zu sortierenden Daten.
	 */
	public static void run_test(String fName) {
		/* Einlesen der Datei -> nicht Zeit beruecksichtigen */
		QuickSort qs = new QuickSort(fName);
		/* Sortierfunktion aufrufen */
		qs.run_sort(fName);
		qs.backup(fName, "_sorted");
		// ss.backup(fName, "_sorted");
	}
}
