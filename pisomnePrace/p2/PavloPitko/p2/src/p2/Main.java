package p2;

import java.io.IOException;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		int x[][] = new int[][] {};
		int y[][] = new int[][] {};
		int result[][];
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome dear user !");

		FileUtils file1 = new FileUtils("x.txt");
		FileUtils file2 = new FileUtils("y.txt");
		System.out.println("How large should your matrixes be ?: ");
		int size = sc.nextInt();
		try {
			file1.genFile(size);
			x = file1.loadFile();
			
			file2.genFile(size);
			y = file2.loadFile();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		while (true) {
			printMenu();
			System.out.print("Enter option: ");
			int option = sc.nextInt();
			switch (option) {

			case 1:
				printMatrix(x, y);
				break;
			case 2:
				result = Operations.add(x, y);
				printResult(result);
				break;
			case 3:
				result = Operations.mul(x, y);
				printResult(result);
				break;
			case 4:
				result = Operations.exp(x, y);
				printResult(result);
				break;
			case 5:
				result = Sorter.sort(x);
				printResult(result);
				System.out.println();
				
				result = Sorter.sort(y);
				printResult(result);
				break;
			case 6:
				sc.close();
				System.exit(0);
			default:
				System.out.println("Invalid input !");
			}
			System.out.println();
		}

	}

	private static void printMatrix(int[][] x, int[][] y) {
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				System.out.printf("%6d ", x[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		for (int i = 0; i < y.length; i++) {
			for (int j = 0; j < y[i].length; j++) {
				System.out.printf("%6d ", y[i][j]);
			}
			System.out.println();
		}
	}
	
	private static void printResult(int[][] x) {
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				System.out.printf("%6d ", x[i][j]);
			}
			System.out.println();
		}
	}
	
	
	private static void printMenu(){
		System.out.println("Press #1 to print both matrixes");
		System.out.println("Press #2 to see add result");
		System.out.println("Press #3 to see mult result");
		System.out.println("Press #4 to see exp result");
		System.out.println("Press #5 to sort matrix");
		System.out.println("Press #6 to exit program");
	}

		
		
	}

