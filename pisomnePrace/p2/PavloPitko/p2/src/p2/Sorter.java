package p2;


import java.util.Arrays;

public class Sorter {
	public static int[][] sort(int[][] x){
		int[][] result = new int[x.length][x[0].length];
		for (int i = 0; i < x.length; i++){
			int[] sorted = x[i];
			Arrays.sort(sorted);
			result[i] = sorted;
		}
		return result;
		
	}

}
