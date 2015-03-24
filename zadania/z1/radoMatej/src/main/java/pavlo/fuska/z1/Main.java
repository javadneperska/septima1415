package pavlo.fuska.z1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream("text.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));

		String line = null;
		while((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
	}

}