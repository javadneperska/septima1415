package fuska.radovan.g1;

import java.util.ArrayList;

//import java.util.Random;

public class Main {
	static final int COUNT = 1000000;

	//static final int AVERAGE = 10;

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(COUNT);
		int[] array = new int[COUNT];
		//Random rnd = new Random();

		System.out.format("Array size: %d\r\n", COUNT);

		//int r;
		for(int i = 0; i < COUNT; i++) {
			//r = rnd.nextInt();
			list.add(i, i);
			array[i] = i;
		}

		System.gc();

		int x = 0;
		long start = System.nanoTime();
		//for(int a = 0; a < AVERAGE; a++) {
		for(int i = 0; i < COUNT; i++)
			x += array[i];
		//}
		long end = System.nanoTime();
		System.out.format("int[]:                   %fs\r\n", (float)(end - start) / 1000000f);

		x = 0;
		start = System.nanoTime();
		//for(int a = 0; a < AVERAGE; a++) {
		for(int i = 0; i < COUNT; i++)
			x += array[i];
		array = null;
		System.gc();
		//}
		end = System.nanoTime();
		System.out.format("int[] + GC:              %fs\r\n", (float)(end - start) / 1000000f);

		x = 0;
		start = System.nanoTime();
		//for(int a = 0; a < AVERAGE; a++) {
		for(int i = 0; i < COUNT; i++)
			x += list.get(i);
		//}
		end = System.nanoTime();
		System.out.format("ArrayList<Integer>:      %fs\r\n", (float)(end - start) / 1000000f);

		x = 0;
		start = System.nanoTime();
		//for(int a = 0; a < AVERAGE; a++) {
		for(int i = 0; i < COUNT; i++)
			x += list.get(i);
		list = null;
		System.gc();
		//}
		end = System.nanoTime();
		System.out.format("ArrayList<Integer> + GC: %fs\r\n", (float)(end - start) / 1000000f);

		//System.out.format("sum: %d", x);
	}

}
