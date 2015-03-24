package pavlo.fuska.z1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Emploee> emploees;
		File f = new File("text.txt");

		try {
			emploees = FileUtils.ParseFile(f);
		} catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

		if(emploees.size() == 0)
			System.out.println("Empty file");
		else
			for(Emploee em : emploees)
				System.out.println(em.toString());
	}
}