import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class FileOperations {

	private String file;

	public FileOperations(String file) {
		this.file = file;
	}

	public int[][] fileLoad() throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader(this.file));
		final int matrixSize = 5;
		int matrix[][] = new int[matrixSize][matrixSize];

		for (int k = 0; k < matrix.length; k++) {
			String[] rawRow = sc.nextLine().split(",");
			int[] row = new int[matrixSize];

			for (int i = 0; i < matrixSize; i++) {
				for (int j = 0; j < rawRow.length; j++) {
					row[j] = Integer.parseInt(rawRow[j]);
				}
			}
			matrix[k] = row;
		}
		sc.close();
		return matrix;
	}
public void printMatrix () throws FileNotFoundException {
	int[][] matrix = fileLoad();
	System.out.println(Arrays.toString(matrix));
}
}
