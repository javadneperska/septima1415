import java.util.Arrays;

public final class Operations {
	public final static int[][] addition(final int[][] a, final int[][] b) {
		int l = a.length;
		int[][] r = new int[l][l];
		
		for(int x = 0; x < l; x++)
			for(int y = 0; y < l; y++)
				r[x][y] = a[x][y] + b[x][y];

		return r;
	}

	public final static int[][] multiplication(final int[][] a, final int[][] b) {
		int l = a.length;
		int[][] r = new int[l][l];

		for(int x = 0; x < l; x++)
			for(int y = 0; y < l; y++)
				r[x][y] = a[x][y] * b[x][y];

		return r;
	}
	
	public final static int[][] exponentiation(final int[][] a, final int[][] b) {
		int l = a.length;
		int[][] r = new int[l][l];

		for(int x = 0; x < l; x++)
			for(int y = 0; y < l; y++)
				r[x][y] = (int)Math.pow(a[x][y], b[x][y]);

		return r;
	}
	
	public final static int compare(final int[][] a, final int[][] b) {
		int l = a.length;

		for(int x = 0; x < l; x++)
			for(int y = 0; y < l; y++)
				if(a[x][y] != b[x][y])
					return a[x][y] > b[x][y] ? 1 : -1;

		return 0;
	}
	
	public final static int[][] sort(final int[][] a) {
		int l = a.length;
		int[] t = new int[l * l];
		int[][] r = new int[l][l];
		
		for(int x = 0; x < l; x++)
			for(int y = 0; y < l; y++)
				t[x * l + y] = a[x][y];
				
		Arrays.sort(t);
		
		for(int x = 0; x < l; x++)
			for(int y = 0; y < l; y++)
				r[x][y] = t[x * l + y];
				
		return r;
	}
	
}