package pitko.erik.p4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

	private String file;

	public FileUtils(String file) {
		this.file = file;
	}

	public StringBuffer loadFile() throws IOException {
		String line;
		StringBuffer buff = new StringBuffer();
		BufferedReader reader = new BufferedReader(new FileReader(this.file));
		while ((line = reader.readLine()) != null) {
			buff.append(line);
		}
		reader.close();
		return buff;
	}

	public void genFile(int size) throws IOException {
		FileWriter out = new FileWriter(this.file);
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < size; i++) {

			switch (Main.rand.nextInt(5)) {
			case 0:
				buff.append("chair"); // random num 0 - 10
				break;
			case 1:
				buff.append("wardrobe"); // random num 0 - 10
				break;
			case 2:
				buff.append("bed"); // random num 0 - 10
				break;
			case 3:
				buff.append("shelf"); // random num 0 - 10
				break;
			case 4:
				buff.append("rack"); // random num 0 - 10
				break;
			}

			buff.append(",");

			switch (Main.rand.nextInt(3)) {
			case 0:
				buff.append(Material.WOOD.toString());
				break;
			case 1:
				buff.append(Material.PARTICLEBOARD.toString());
				break;
			case 2:
				buff.append(Material.OTHER.toString());
				break;
			}

			buff.append(",");
			buff.append(40 + Main.rand.nextInt(60));
			buff.append(",");
			buff.append(40 + Main.rand.nextInt(60));
			buff.append(",");
			buff.append(80 + Main.rand.nextInt(60));
			buff.append("|");
			buff.append(System.lineSeparator());
		}
		out.write(buff.toString());
		out.close();
	}
}