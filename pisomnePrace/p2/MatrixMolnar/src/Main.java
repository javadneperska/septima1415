import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int matrix[][] = new int[][] {};
		int matrix2[][] = new int[][] {};
		int result[][];

		Random generator = new Random();
		String content = "";
		int a = 0;
		// Matrix generator file 1
		FileWriter fw = null;
		try {
			fw = new FileWriter("matrix1.txt");

			BufferedWriter bw = new BufferedWriter(fw);

			for (int d = 0; d < 5; d++) {
				for (int i = 0; i < 4; i++) {
					a = generator.nextInt(10);
					String s = a + ",";
					content = content + s;
				}
				content = content + a + System.lineSeparator();
			}

			bw.write(content);
			bw.close();

		} catch (IOException e1) {

			e1.printStackTrace();
		}
		// Matrix Generator file 2
		content = "";
		try {
			fw = new FileWriter("matrix2.txt");

			BufferedWriter bw = new BufferedWriter(fw);

			for (int d = 0; d < 5; d++) {
				for (int i = 0; i < 4; i++) {
					a = generator.nextInt(10);
					String s = a + ",";
					content = content + s;
				}
				content = content + a + System.lineSeparator();
			}

			bw.write(content);
			bw.close();

		} catch (IOException e1) {

			e1.printStackTrace();
		}
		while (true) {
			printMenu();
			System.out.print("\nPlease enter option: ");
			int option = sc.nextInt();
			switch (option) {

			case 1:
				try {
					int temp[][];
					FileOperations loader = new FileOperations("matrix1.txt");
					temp = loader.fileLoad();

					matrix = new int[5][5];
					for (int i = 0; i < 5; i++) {
						for (int j = 0; j < 5; j++) {
							matrix[i][j] = temp[i][j];
						}
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

				FileOperations loader = new FileOperations("matrix2.txt");
				int temp2[][] = null;

				temp2 = loader.fileLoad();
				matrix2 = new int[5][5];
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						matrix2[i][j] = temp2[i][j];
					}
				}
				break;
			case 2:
				printMatrix(matrix);
				System.out.println("\n");
				printMatrix(matrix2);
				break;

			case 3:
				result = Operations.multi(matrix, matrix2);
				printMatrix(result);
				break;
			case 4:
				result = Operations.sum(matrix, matrix2);
				printMatrix(result);
				break;
			case 5:
				result = Operations.expon(matrix, matrix2);
				printMatrix(result);
				break;
			case 6:
				System.out.println("Matrix 1 sorted: \n");
				result = Operations.sort(matrix);
				
				
				printMatrix(result);

				System.out.println("Matrix 2 sorted: \n");
				result = Operations.sort(matrix2);
				printMatrix(result);
				break;
			case 7:
				System.out.println("Exiting program");
				sc.close();
				return;
			default:
				System.out.println("Invalid input !");
			}

			System.out.println();
		}

	}

	private static void printMenu() {
		System.out.println("Press #1 to load matrixes from file");
		System.out.println("Press #2 to print matrixes");
		System.out.println("Press #3 to multiplication");
		System.out.println("Press #4 to addition");
		System.out.println("Press #5 to exponentiate matrix (matrix1^matrix2)");
		System.out.println("Press #6 to sort matrixes");
		System.out.println("Press #7 to exit program");
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
