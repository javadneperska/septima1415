package parada.peter.d20;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Loader {
	public static Scanner sc;
	public static ArrayList<Teacher> teachers = new ArrayList<Teacher>();
	public static ArrayList<Student> students = new ArrayList<Student>();
	
	public static ArrayList<Teacher> loadTeachers(String fileName) {
		try {
			sc = new Scanner(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.nextLine();
		while (sc.hasNextLine()) {
			String[] lineSplit = sc.nextLine().split(", ");
			
			String name = lineSplit[0];
			String surname = lineSplit[1];
			int age = Integer.parseInt(lineSplit[2]);
			boolean sex = Boolean.parseBoolean(lineSplit[3]);
			double payPerHour = Double.parseDouble(lineSplit[4]);
			ArrayList<String> subjects =  new ArrayList<String>();
			String[] subjectsSplit = lineSplit[5].split("-");
			
			for (String subject : subjectsSplit) {
				subjects.add(subject);
			}
			
			Teacher teacher = new Teacher(name, surname, age, sex, payPerHour, subjects);
			teachers.add(teacher);
		}
		return teachers;
	}
	
	public static ArrayList<Student> loadStudents(String fileName) {
		try {
			sc = new Scanner(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.nextLine();
		while (sc.hasNextLine()) {
			String[] lineSplit = sc.nextLine().split(", ");
			
			String name = lineSplit[0];
			String surname = lineSplit[1];
			int age = Integer.parseInt(lineSplit[2]);
			boolean sex = Boolean.parseBoolean(lineSplit[3]);
			ArrayList<String> subjects =  new ArrayList<String>();
			String[] subjectsSplit = lineSplit[4].split("-");
			
			for (String subject : subjectsSplit) {
				subjects.add(subject);
			}
			Student student = new Student(name, surname, age, sex, subjects);
			students.add(student);
		}
		return students;
	}
}
