package de.hsos.aud;

public class QuickSortMedian extends QuickSort {
	public QuickSortMedian(String name){
		super(name);
	}


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

			int pivot = find_kth(l, h);
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

	@Override
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
	@Override
	public int find_kth(int l, int r) {
		int k = (r + l) / 2; // Pivot-Element festlegen
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

	public static void run_test(String fName) {
		/* Einlesen der Datei -> nicht Zeit beruecksichtigen */
		QuickSortMedian qs = new QuickSortMedian(fName);
		/* Sortierfunktion aufrufen */
		qs.run_sort(fName);
		qs.backup(fName, "_sorted");
		// ss.backup(fName, "_sorted");
	}
}
