package pitko.erik.p3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUtils {

	private String file;

	public FileUtils(String file) {
		this.file = file;
	}

	public String[] loadFile() throws FileNotFoundException {
		final Scanner sc = new Scanner(new FileReader(this.file));
		ArrayList<String> lines = new ArrayList<String>();
		while (sc.hasNextLine()){
			lines.add(sc.nextLine());
		}
		String[] rows = new String[lines.size()];
		for (int i = 0; i < lines.size(); i++){
			rows[i] = lines.get(i);			
		}
		sc.close();
		return rows;

	}

}