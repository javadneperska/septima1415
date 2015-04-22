import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;


public class UtilsLoading {
	
	private String file;

	public UtilsLoading(String file) {
		this.file = file;
	}
	
	public int[][] loadMatrix() throws FileNotFoundException {
		final Scanner sc = new Scanner(new FileReader(this.file));
		final int MATRIX_SIZE = 10;
		int[][] matrix = new int[MATRIX_SIZE][MATRIX_SIZE];
		
		for (int k = 0; k < matrix.length; k++) {
			String[] rawRow = sc.nextLine().split(", ");
			int[] row = new int[MATRIX_SIZE];
			
			for (int i = 0; i < MATRIX_SIZE; i++) {
				for (int j = 0; j < rawRow.length; j++) {
					row[j] = Integer.parseInt(rawRow[j]);
				}
			}
			matrix[k] = row;
		}
		sc.close();
		return matrix;
	}
	
	public void printMatrix() throws FileNotFoundException {
		int[][] matrix = loadMatrix();
		System.out.println(Arrays.deepToString(matrix));
	}
}