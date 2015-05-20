package pitko.erik.d17;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class FileUtils {

	private String file;

	public FileUtils(String file) {
		this.file = file;
	}

	public String[] loadFile() throws FileNotFoundException {
		final Scanner sc = new Scanner(new FileReader(this.file));

		String[] rawRow = sc.nextLine().split(",");
		sc.close();
		return rawRow;

	}

	public void genFile() throws IOException {
		FileWriter out = new FileWriter(this.file);
		StringBuffer buff = new StringBuffer();
		Random rand = new Random();
		int size = rand.nextInt(50000);
		for (int i = 0; i < size; i++) {
			switch (rand.nextInt(3)) {
			case 0:
				buff.append(rand.nextInt());
				break;
			case 1:
				buff.append(rand.nextFloat());
				break;
			case 2:
				buff.append(rand.nextLong());
				break;
			}
			buff.append(",");
		}
		out.write(buff.toString());
		out.close();
	}
}