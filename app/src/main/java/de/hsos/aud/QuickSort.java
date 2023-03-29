//TODO: Add comments for the presentation!!!
package de.hsos.aud;

/**
 * Implementation of quicksort algorithm
 * 
 * @author David Frewin, Joshua Ullrich
 */

public class QuickSort extends Sequence {

	public QuickSort(int size) {
		super(size);
	}

	public QuickSort(String fName) {
		super(fName);
	}

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

	private int partition_median(int l, int h) {
		Median m = new Median(this.a); // TODO - use median only on a[l:h]
		m.sort();

		int p_index = m.MedianIndex;
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

	private void run_qsort(int l, int h) {
		// simulate a stack
		int[] stack = new int[h - l + 1];
		int top = 0;

		// push lower and higher limit
		stack[++top] = l;
		stack[++top] = h;

		while (top != 0) { // run until stack is completely empty
			// pop lower and higher limit
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

	private void run_qsort_median(int l, int h) {
		// simulate a stack
		int[] stack = new int[h - l + 1];
		int top = 0;

		// push lower and higher limit
		stack[++top] = l;
		stack[++top] = h;

		while (top != 0) { // run until stack is completely empty
			// pop lower and higher limit
			h = stack[top--];
			l = stack[top--];

			int pivot = partition_median(l, h);
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

	public void sort() {
		try {
			// recursive_quicksort(1, a[0] - 1);
			// a = new int[] {234, 456, 234, 643, 21123, 65 };
			// System.out.println(java.util.Arrays.toString(a));
			run_qsort(1, a[0]);
			// System.out.println(java.util.Arrays.toString(a));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

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
		//qs.backup(fName, "_sorted");
		// ss.backup(fName, "_sorted");
	}
}
