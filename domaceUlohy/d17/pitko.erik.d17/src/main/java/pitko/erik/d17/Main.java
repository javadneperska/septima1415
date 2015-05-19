package pitko.erik.d17;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		FileUtils file = new FileUtils("numbers.txt");

		try {
			file.genFile();
			String[] row = file.loadFile();
			IntFloatLong[] ff = new IntFloatLong[row.length];

			for (int i = 0; i < row.length; i++) {
				ff[i] = new IntFloatLong();
				ff[i].setNum(row[i]);
			}

			for (int i = 0; i < ff.length; i++) {
				System.out.println(ff[i].getNum());
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
