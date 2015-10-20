package pitko.erik.cv21;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtils {
	public static void readFromFile(String name){
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(name + ".txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found ! " + e);
		}
		
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
					ArrayList<Language> languages = new ArrayList<Language>();
					if (parts[4].contains("lang=")){
						for(String language:parts[4].substring(parts[4].indexOf("=") + 1).split(":")){
							String[] languagePart = language.split("-");
							switch(languagePart[1]){
								case "A2":
									languages.add(new Language(languagePart[0], UrovenCJ.A2));
									break;
								case "B1":
									languages.add(new Language(languagePart[0], UrovenCJ.B1));
									break;
								case "B2":
									languages.add(new Language(languagePart[0], UrovenCJ.B2));
									break;
								case "C1":
									languages.add(new Language(languagePart[0], UrovenCJ.C1));
									break;
								default:
									languages.add(new Language(languagePart[0], UrovenCJ.A1));
									break;
							}
						}
					}
					Main.missList.add(new Miss(parts[0], parts[1], Integer.parseInt(parts[2]), (parts[3].equals("SS") ? Vzdelanie.STREDOSKOLSKE:Vzdelanie.VYSOKOSKOLSKE), languages, parts[5]));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
