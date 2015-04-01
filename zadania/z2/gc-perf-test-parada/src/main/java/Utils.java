import java.util.ArrayList;


public class Utils {
	public static long calcSumArray(int[] array) {
		long sum = 0;
		for( int num : array) {
	          sum = sum + num;
	      }
		return sum;
	}

	public static long calcSumArray(ArrayList<Integer> array) {
		long sum = 0;
		for( int num : array) {
	          sum = sum + num;
	      }
		return sum;
	}
	
}
