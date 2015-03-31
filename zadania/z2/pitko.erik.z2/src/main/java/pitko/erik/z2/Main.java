package pitko.erik.z2;

import java.util.ArrayList;

public class Main {

	private final static int MAX = 1000000;

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Integer[] x = new Integer[MAX];
		long start;

		System.out.format("%,d numbers%n", MAX);
		start = System.currentTimeMillis();
		for (int i = 0; i < x.length; i++) {
			x[i] = i;
		}
		Utils.sum(x);
		System.out.println("int[] without gc: " + (double) (System.currentTimeMillis() - start) / 1000);

		Integer[] y = new Integer[MAX];

		start = System.currentTimeMillis();
		for (int i = 0; i < y.length; i++) {
			y[i] = i;
		}
		Utils.sum(y);
		y = null;
		System.gc();
		System.out.println("int[] with gc: " + (double) (System.currentTimeMillis() - start) / 1000);

		start = System.currentTimeMillis();
		for (int i = 0; i < MAX; i++) {
			arr.add(i);
		}
		Utils.sum(arr);
		System.out.println("arraylist without gc: " + (double) (System.currentTimeMillis() - start) / 1000);
		arr.clear();

		start = System.currentTimeMillis();
		for (int i = 0; i < MAX; i++) {
			arr.add(i);
		}
		Utils.sum(arr);
		arr = null;
		System.gc();
		System.out.println("arraylist with gc: " + (double) (System.currentTimeMillis() - start) / 1000);

	}

}
