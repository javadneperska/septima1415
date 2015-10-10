package pitko.erik.d20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtils {
	public static void readFromFile(FileNames name){
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(name.toString().toLowerCase() + ".txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found ! " + e);
		}
		
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (name.equals((FileNames.STUDENTS))){
					ArrayList<String> subjects = new ArrayList<String>();
					if (parts[4].contains("subjects:")){
						for(String subject:parts[4].substring(parts[4].indexOf(":") + 1).split("-")){
							subjects.add(subject);
						}
					}
					Main.studentList.add(new Student(parts[0], parts[1], Integer.parseInt(parts[2]), (parts[3] == "m") ? true:false, subjects));
				} else if (name.equals(FileNames.TEACHERS)){
					ArrayList<String> subjects = new ArrayList<String>();
					if (parts[5].contains("subjects:")){
						for(String subject:parts[5].substring(parts[5].indexOf(":") + 1).split("-")){
							subjects.add(subject);
						}
					}
					Main.teacherList.add(new Teacher(parts[0], parts[1], Integer.parseInt(parts[2]), (parts[3] == "m") ? true:false, Double.parseDouble(parts[4]), subjects));
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
