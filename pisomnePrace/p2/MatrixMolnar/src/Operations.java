import java.util.Arrays;

public class Operations {
	
	
	public static int[][] sum(final int x[][], final int y[][]) {
		
		int[][] result = new int[x.length][x[0].length];

		for (int c = 0; c < 5; c++) {
			for (int d = 0; d < 5; d++) {
				result[c][d] = x[c][d] + y[c][d];
			}
			
		}return result;

	}

	public static int[][] multi(final int x[][], final int y[][]) {
		
		int[][] result = new int[x.length][x[0].length];

		for (int c = 0; c < 5; c++) {
			for (int d = 0; d < 5; d++) {
				result[c][d] = x[c][d] * y[c][d];
			}
		}
		return result;

	}

	public static int[][] expon(final int x[][], final int y[][]
			) {
		
		int[][] result = new int[x.length][x[0].length];
		int[][] tem = new int[x.length][x[0].length];
		for (int c = 0; c < 5; c++) {
			for (int d = 0; d < 5; d++) {
				tem[c][d] = (int) Math.pow(x[c][d], y[c][d]);
				result[c][d] = tem[c][d];
			}
		}
		return result;
}
	public static int[][] sort(final int x[][]
			) {
		
		int[][] result = new int[x.length][x[0].length];
		
		
		for (int i = 0; i < x.length; i++) {
	        int[] temp = new int[x.length];

	        for (int j = 0; j < x.length; j++) {

	            temp[j] = x[i][j];
	        }
	        Arrays.sort(temp);
	        for (int j = 0; j < temp.length; j++) {
	            result[i][j] = temp[j];
	        }
	    }
		return result;
}
      
} 