import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int matrix[][] = new int[][] {};
		int result[][];
		Scanner sc = new Scanner(System.in);

		int n = 0;
		while (true) {
			System.out.println("1.Load matrix");
			System.out.println("2.Print matrix");
			System.out.println("3.Calc multiplication");
			System.out.println("4.Calc factorial");
			System.out.println("5.Exit program");

			int option = sc.nextInt();
			switch (option) {

			case 1:
				try {
					int matrixLoader[][];
					UtilsLoading loader = new UtilsLoading("matrix.txt");
					matrixLoader = loader.loadMatrix();
					System.out.print("Enter size of matrix n*n: ");
					n = sc.nextInt();
					matrix = new int[n][n];
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							matrix[i][j] = matrixLoader[i][j];
						}
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				printMatrix(matrix);
				break;

			case 3:
				result = Operations.mul(matrix);
				printMatrix(result);
				break;
			case 4:
				result = Operations.calcFactorialDimensional(matrix);
				printMatrix(result);
				break;
			case 5:
				sc.close();
				return;
			default:
				System.out.println("Input doesn't exist.");
			}
			System.out.println();
		}

	}

	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.printf("%3d ", matrix[i][j]);
			}
			System.out.println();
		}
	}
}
