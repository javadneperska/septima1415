package pitko.erik.d20;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
	public static ArrayList<Student> studentList = new ArrayList<Student>();

	public static void main(String[] args) {
		FileUtils.readFromFile(FileNames.STUDENTS);
		FileUtils.readFromFile(FileNames.TEACHERS);
		Scanner sc = new Scanner(System.in);
		int option;
		int hours;

		while (true) {
			for (int i = 0; i < teacherList.size(); i++) {
				System.out.println(i + 1 + " " + teacherList.get(i).name + " " + teacherList.get(i).surname);
			}
			System.out.println("Enter invalid num of teacher for exit");
			System.out.println("Enter num of Teacher: ");
			option = sc.nextInt() - 1;
			if (option <= 0 || option >= teacherList.size()){
				break;
			}
			do{
			System.out.println("Enter number of hours: ");
			hours = sc.nextInt();
			}while(hours < 0);
			System.out.println("Teacher earned: " + (hours * calcNumOfStudents(option)) * teacherList.get(option).payPerHour);
			System.out.println();
		}
		sc.close();

	}
	
	private static int calcNumOfStudents(int option){
		int students = 0;
		ArrayList<String> subjects = teacherList.get(option).subjects;
		for (int i = 0; i < subjects.size(); i++){
			for (int n = 0; n < studentList.size(); n++){
				ArrayList<String> studentSubjects = studentList.get(n).subjects;
				for (int o = 0; o < studentSubjects.size(); o++){
					if (studentSubjects.get(o).equals(subjects.get(i))){
						students++;
						System.out.println("student: " + studentList.get(n).name + "subject: " + studentSubjects.get(o));
						break;
					}
				}
			}
		}
		return students;
	}

}
