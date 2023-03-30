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

	private void run_qsort(int l, int h) {
		// Simuliere einen Stack
		int[] stack = new int[h - l + 1];
		int top = 0;

		// schiebe unteres und oberes Limit
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

	int medianOfThree(int l, int m, int h) {
        if ((a[l] > a[h]) ^ (a[l] > a[m])) 
            return l;
        else if ((a[h] < a[l]) ^ (a[h] < a[m])) 
            return h;
        else
            return m;
    }

	/**
	 * Anwenden des median of three Algorithmusses auf den bestehenden Array
	 * @param l minimum index aus dem Substack
	 * @param h Maximum index aus dem Substack
	 * @return index des pivot elementes
	 */
    protected int partition_median(int l, int h) {
        int p_index = medianOfThree(l, (h - l) / 2 + l, h);

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
	int medianOfThree(int l, int h) {
		int m = (int)((h - l) / 2 + l);
		if ((this.a[l] > this.a[h]) ^ (this.a[l] > this.a[m])) 
			return l;
		else if ((this.a[h] < this.a[l]) ^ (this.a[h] < this.a[m])) 
			return h;
		else
			return m;
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
		qs.backup(fName, "_sorted");
		// ss.backup(fName, "_sorted");
	}
}
