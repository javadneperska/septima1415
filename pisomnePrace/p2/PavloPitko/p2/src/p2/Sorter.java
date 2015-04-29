package p2;


import java.util.Arrays;

public class Sorter {
	public static int[][] sort(final int[][] x){
		int[][] result = new int[x.length][x[0].length];
		for (int i = 0; i < x.length; i++){
			Arrays.sort(x[i]);
			result[i] = x[i];
		}
		return result;
		
	}

}
