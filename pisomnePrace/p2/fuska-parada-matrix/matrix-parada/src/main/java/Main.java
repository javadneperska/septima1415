import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int a[][] = null;
		int b[][] = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			a = UtilsLoading.load("matrix1.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			b = UtilsLoading.load("matrix2.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(true) {
			printMenu();

			System.out.print("Choose an option:");
			switch(sc.nextInt()) {
				case 1:
					printMatrix(Operations.addition(a, b));
					break;
				case 2:
					printMatrix(Operations.multiplication(a, b));
					break;
				case 3:
					printMatrix(Operations.exponentiation(a, b));
					break;
				case 4:
					printMatrix(a);
					System.out.println();
					printMatrix(b);
					break;
				case 5:
					int r = Operations.compare(a, b);
					if(r == 0) System.out.println("Matrixes are equal");
					else if(r > 0) System.out.println("Matrix a is bigger");
					else System.out.println("Matrix b is bigger");
					break;
				case 6:
					printMatrix(Operations.sort(a));
					System.out.println();
					printMatrix(Operations.sort(b));
					break;
				case 7:
					sc.close();
					return;
				default:
					System.out.println("Unknown option");
			}
			System.out.println();
		}

	}

	private final static void printMatrix(final int[][] m) {
		int l = m.length;
		for(int x = 0; x < l; x++) {
			for(int y = 0; y < l; y++)
				System.out.format("%3d ", m[x][y]);
			System.out.println();
		}
	}

	private final static void printMenu() {
		System.out.println("1: Provide addition");
		System.out.println("2: Provide multiplication");
		System.out.println("3: Provide exponentiation");
		System.out.println("4: Print matrix");
		System.out.println("5: Compare matrices");
		System.out.println("6: Sort matrices");
		System.out.println("7: Exit");
	}
}