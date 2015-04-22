public class Operations {

	public static int fac(final int x) {
		if (x < 2) {
			return 1;
		}
		return fac(x - 1) * x;
	}
	
	public static int[][] fac(final int[][] x){
		int[][] y = new int[x.length][x[0].length];
		for (int i = 0; i < x.length; i++) {
			for (int n = 0; n < x[i].length; n++) {
				y[i][n] = fac(x[i][n]);
			}
		}
		return y;
	}

	public static int[][] mul(final int[][] x) {
		int[][] y = new int[x.length][x[0].length];
		for (int i = 0; i < x.length; i++) {
			for (int n = 0; n < x[i].length; n++) {
				y[i][n] = x[i][n] * x[i][n];
			}
		}
		return y;
	}

}
