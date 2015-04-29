package zadanie6;

public class Operations {
	
	public static int[][] add(final int[][] x, final int y[][]){
		int[][] z = new int[x.length][x[0].length];
		for (int i = 0; i < x.length; i++) {
			for (int n = 0; n < x[i].length; n++) {
				z[i][n] = x[i][n] + y[i][n];
			}
		}
		return z;
	}

	public static int[][] mul(final int[][] x, final int y[][]) {
		int[][] z = new int[x.length][x[0].length];
		for (int i = 0; i < x.length; i++) {
			for (int n = 0; n < x[i].length; n++) {
				z[i][n] = x[i][n] * y[i][n];
			}
		}
		return z;
	}
	
	public static int[][] exp(final int[][] x, final int y[][]) {
		int[][] z = new int[x.length][x[0].length];
		for (int i = 0; i < x.length; i++) {
			for (int n = 0; n < x[i].length; n++) {
				z[i][n] = (int)Math.pow((double)x[i][n], (double)y[i][n]);
			}
		}
		return z;
	}

}
