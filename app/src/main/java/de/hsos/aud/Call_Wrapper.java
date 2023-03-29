package de.hsos.aud;

import javax.print.attribute.standard.Media;

/**
 *
 * Konfiguration aus Ausfuehrung von Laufzeittest. Aufruf der Klassen erfolgt
 * ueber statische Methoden.
 * 
 * @author heikerli
 */
public class Call_Wrapper {

	public static void run_selection_sort() {
		SelectionSort.run_test("data/TestSuite1/sample1_no_dups.txt");
		SelectionSort.run_test("data/TestSuite1/sample2_no_dups.txt");
		SelectionSort.run_test("data/TestSuite1/sample3_no_dups.txt");
		SelectionSort.run_test("data/TestSuite1/sample4_no_dups.txt");
		SelectionSort.run_test("data/TestSuite1/sample5_no_dups.txt");
		SelectionSort.run_test("data/TestSuite1/sample6_no_dups.txt");
		SelectionSort.run_test("data/TestSuite1/sample7_no_dups.txt");
		SelectionSort.run_test("data/TestSuite1/sample8_no_dups.txt");
		SelectionSort.run_test("data/TestSuite1/sample9_no_dups.txt");
		SelectionSort.run_test("data/TestSuite1/sample10_no_dups.txt");
	}

	public static void run_median() {
		Median.run_test("data/TestSuite1/sample1_no_dups.txt");
		Median.run_test("data/TestSuite1/sample2_no_dups.txt");
		Median.run_test("data/TestSuite1/sample3_no_dups.txt");
		Median.run_test("data/TestSuite1/sample4_no_dups.txt");
		Median.run_test("data/TestSuite1/sample5_no_dups.txt");
		Median.run_test("data/TestSuite1/sample6_no_dups.txt");
		Median.run_test("data/TestSuite1/sample7_no_dups.txt");
		Median.run_test("data/TestSuite1/sample8_no_dups.txt");
		Median.run_test("data/TestSuite1/sample9_no_dups.txt");
		Median.run_test("data/TestSuite1/sample10_no_dups.txt");
	}

	public static void run_small() {
		QuickSort.run_test("data/TestSuiteSmall/sample1.txt");
		QuickSort.run_test("data/TestSuiteSmall/sample2.txt");
		QuickSort.run_test("data/TestSuiteSmall/sample3.txt");
		QuickSort.run_test("data/TestSuiteSmall/sample4.txt");
		QuickSort.run_test("data/TestSuiteSmall/sample5.txt");
	}

	public static void run_quick_sort() {
		QuickSort.run_test("data/TestSuite1/sample1_no_dups.txt");
		QuickSort.run_test("data/TestSuite1/sample2_no_dups.txt");
		QuickSort.run_test("data/TestSuite1/sample3_no_dups.txt");
		QuickSort.run_test("data/TestSuite1/sample4_no_dups.txt");
		QuickSort.run_test("data/TestSuite1/sample5_no_dups.txt");
		QuickSort.run_test("data/TestSuite1/sample6_no_dups.txt");
		QuickSort.run_test("data/TestSuite1/sample7_no_dups.txt");
		QuickSort.run_test("data/TestSuite1/sample8_no_dups.txt");
		QuickSort.run_test("data/TestSuite1/sample9_no_dups.txt");
		QuickSort.run_test("data/TestSuite1/sample10_no_dups.txt");
	}

	public static void run_quick_sort_ts2(){
		QuickSort.run_test("data/TestSuite2/sample1_wc.txt");
		QuickSort.run_test("data/TestSuite2/sample2_wc.txt");
		QuickSort.run_test("data/TestSuite2/sample3_wc.txt");
		QuickSort.run_test("data/TestSuite2/sample4_wc.txt");
		QuickSort.run_test("data/TestSuite2/sample5_wc.txt");
		QuickSort.run_test("data/TestSuite2/sample6_wc.txt");
		QuickSort.run_test("data/TestSuite2/sample7_wc.txt");
		QuickSort.run_test("data/TestSuite2/sample8_wc.txt");
		QuickSort.run_test("data/TestSuite2/sample9_wc.txt");
		QuickSort.run_test("data/TestSuite2/sample10_wc.txt");
	}

	public static void run_quick_sort_extended() {
		QuickSort.run_test("data/TestSuite1/sample1_no_dups.txt");
		QuickSort.run_test("data/TestSuite1/sample2_no_dups.txt");
		QuickSort.run_test("data/TestSuite1/sample3_no_dups.txt");
		QuickSort.run_test("data/TestSuite1/sample4_no_dups.txt");
		QuickSort.run_test("data/TestSuite1/sample5_no_dups.txt");
		QuickSort.run_test("data/TestSuite1/sample6_no_dups.txt");
		QuickSort.run_test("data/TestSuite1/sample7_no_dups.txt");
		QuickSort.run_test("data/TestSuite1/sample8_no_dups.txt");
		QuickSort.run_test("data/TestSuite1/sample9_no_dups.txt");
		QuickSort.run_test("data/TestSuite1/sample10_no_dups.txt");

		QuickSort.run_test("data/TestSuite2/sample1_wc.txt");
		QuickSort.run_test("data/TestSuite2/sample2_wc.txt");
		QuickSort.run_test("data/TestSuite2/sample3_wc.txt");
		QuickSort.run_test("data/TestSuite2/sample4_wc.txt");
		QuickSort.run_test("data/TestSuite2/sample5_wc.txt");
		QuickSort.run_test("data/TestSuite2/sample6_wc.txt");
		QuickSort.run_test("data/TestSuite2/sample7_wc.txt");
		QuickSort.run_test("data/TestSuite2/sample8_wc.txt");
		QuickSort.run_test("data/TestSuite2/sample9_wc.txt");
		QuickSort.run_test("data/TestSuite2/sample10_wc.txt");

		QuickSort.run_test("data/TestSuite3/sample1_random.txt");
		QuickSort.run_test("data/TestSuite3/sample2_random.txt");
		QuickSort.run_test("data/TestSuite3/sample3_random.txt");
		QuickSort.run_test("data/TestSuite3/sample4_random.txt");
		QuickSort.run_test("data/TestSuite3/sample5_random.txt");
		QuickSort.run_test("data/TestSuite3/sample6_random.txt"); //expect long runtimes for this one
		QuickSort.run_test("data/TestSuite3/sample7_random.txt");
		QuickSort.run_test("data/TestSuite3/sample8_random.txt");
		QuickSort.run_test("data/TestSuite3/sample9_random.txt");
		QuickSort.run_test("data/TestSuite3/sample10_random.txt");
	}

	public static void run_quick_sort_on_sorted(){
		QuickSort.run_test("data/TestSuite1/sample1_no_dups_sorted.txt");
		QuickSort.run_test("data/TestSuite1/sample2_no_dups_sorted.txt");
		QuickSort.run_test("data/TestSuite1/sample3_no_dups_sorted.txt");
		QuickSort.run_test("data/TestSuite1/sample4_no_dups_sorted.txt");
		QuickSort.run_test("data/TestSuite1/sample5_no_dups_sorted.txt");
		QuickSort.run_test("data/TestSuite1/sample6_no_dups_sorted.txt");
		QuickSort.run_test("data/TestSuite1/sample7_no_dups_sorted.txt");
		QuickSort.run_test("data/TestSuite1/sample8_no_dups_sorted.txt");
		QuickSort.run_test("data/TestSuite1/sample9_no_dups_sorted.txt");
		QuickSort.run_test("data/TestSuite1/sample10_no_dups_sorted.txt");
	
		QuickSort.run_test("data/TestSuite2/sample1_wc_sorted.txt");
		QuickSort.run_test("data/TestSuite2/sample2_wc_sorted.txt");
		QuickSort.run_test("data/TestSuite2/sample3_wc_sorted.txt");
		QuickSort.run_test("data/TestSuite2/sample4_wc_sorted.txt");
		QuickSort.run_test("data/TestSuite2/sample5_wc_sorted.txt");
		QuickSort.run_test("data/TestSuite2/sample6_wc_sorted.txt");
		QuickSort.run_test("data/TestSuite2/sample7_wc_sorted.txt");
		QuickSort.run_test("data/TestSuite2/sample8_wc_sorted.txt");
		QuickSort.run_test("data/TestSuite2/sample9_wc_sorted.txt");
		QuickSort.run_test("data/TestSuite2/sample10_wc_sorted.txt");

		QuickSort.run_test("data/TestSuite3/sample1_random_sorted.txt");
		QuickSort.run_test("data/TestSuite3/sample2_random_sorted.txt");
		QuickSort.run_test("data/TestSuite3/sample3_random_sorted.txt");
		QuickSort.run_test("data/TestSuite3/sample4_random_sorted.txt");
		QuickSort.run_test("data/TestSuite3/sample5_random_sorted.txt");
		// QuickSort.run_test("data/TestSuite3/sample6_random_sorted.txt"); //no data to proccess
		QuickSort.run_test("data/TestSuite3/sample7_random_sorted.txt");
		QuickSort.run_test("data/TestSuite3/sample8_random_sorted.txt");
		QuickSort.run_test("data/TestSuite3/sample9_random_sorted.txt");
		QuickSort.run_test("data/TestSuite3/sample10_random_sorted.txt");
	}

	private static void run_quick_sort_dups(){
		QuickSort.run_test("data/TestSuiteDups/sample1_dups.txt");
		QuickSort.run_test("data/TestSuiteDups/sample2_dups.txt");
		QuickSort.run_test("data/TestSuiteDups/sample3_dups.txt");
		QuickSort.run_test("data/TestSuiteDups/sample4_dups.txt");
		QuickSort.run_test("data/TestSuiteDups/sample5_dups.txt");
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		//run_small();

		// run_selection_sort();
		// run_median();
		// run_quick_sort();
		run_quick_sort_extended();
		// run_quick_sort_dups();
		
		// FOR SAFETY REASONS: LEAVE COMMENTED OUT!!!
		//run_quick_sort_on_sorted();
	}
}
