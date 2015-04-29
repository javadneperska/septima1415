package p2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class FileUtils {

	private String file;
	public static int size = 0;

	public FileUtils(String file) {
		this.file = file;
	}

	public int[][] loadFile() throws FileNotFoundException {
		final Scanner sc = new Scanner(new FileReader(this.file));
		final int matrixSize = FileUtils.size;
		int[][] matrix = new int[matrixSize][matrixSize];

		for (int k = 0; k < matrix.length; k++) {
			String[] rawRow = sc.nextLine().split(",");
			int[] row = new int[matrixSize];

			for (int i = 0; i < rawRow.length; i++) {
				row[i] = Integer.parseInt(rawRow[i]);
			}
			matrix[k] = row;
		}
		sc.close();
		return matrix;
	}

	public void genFile(int size) throws IOException {
		FileUtils.size = size;
		FileWriter out = new FileWriter(this.file);
		StringBuffer buff = new StringBuffer();
		Random rand = new Random();
		for (int i = 0; i < FileUtils.size; i++) {
			for (int n = 0; n < FileUtils.size; n++) {
				buff.append(rand.nextInt(10));
				buff.append(",");
			}
			buff.append(System.lineSeparator());
		}
		out.write(buff.toString());
		out.close();
	}
}