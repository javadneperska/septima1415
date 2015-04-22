import java.io.FileNotFoundException;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		int matrix[][] = new int[][] {};
		int result[][];
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to our matrix program");

		int n = 0;
		while (true) {
			printMenu();
			System.out.print("Enter option: ");
			int option = sc.nextInt();
			switch (option) {

			case 1:
				try {
					int temp[][];
					UtilsLoading loader = new UtilsLoading("matrix.txt");
					temp = loader.loadMatrix();
					System.out.print("Enter size of matrix n: ");
					n = sc.nextInt();
					matrix = new int[n][n];
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							matrix[i][j] = temp[i][j];
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
				result = Operations.fac(matrix);
				printMatrix(result);
				break;
			case 5:
				sc.close();
				return;
			default:
				System.out.println("Invalid input !");
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
	
	private static void printMenu(){
		System.out.println("Press #1 to load matrix from file");
		System.out.println("Press #2 to print matrix");
		System.out.println("Press #3 to multiplication");
		System.out.println("Press #4 to make factorial");
		System.out.println("Press #5 to exit program");
	}

}
