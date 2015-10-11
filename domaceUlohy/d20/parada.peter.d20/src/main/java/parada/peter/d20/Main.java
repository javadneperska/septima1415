package parada.peter.d20;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static ArrayList<Teacher> teachers = Loader.loadTeachers("teachers.txt");
    public static ArrayList<Student> students = Loader.loadStudents("students.txt");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int teacherInput, hours;

        while (true) {
        	System.out.println("Teachers: \n");
            for (int i = 0; i < teachers.size(); i++) {
                System.out.println(i + 1 + "." + teachers.get(i).name + " " + teachers.get(i).surname);
            }
            
            System.out.println("\nEnter num of teacher: ");
            teacherInput = sc.nextInt() - 1;
            if (teacherInput < 0 || teacherInput >= teachers.size()){
                System.out.println("Invalid input.");
            	break;
            }
            
            System.out.println("Enter number of hours: ");
            hours = sc.nextInt();

            System.out.println("Teacher earned: " + (hours * numOfStudentsByTeacher(teacherInput)) * teachers.get(teacherInput).payPerHour);
            sc.nextLine();
            System.out.println();
        }
        sc.close();
    }

	private static int numOfStudentsByTeacher(int teacherInput) {
		int numStudents = 0;
		ArrayList<String> teacherSubjects = teachers.get(teacherInput).getSubjects();
		for (Student student : students) {
			ArrayList<String> studentSubjects = student.getSubjects();
			
			for (String studentSubject : studentSubjects) {
				if (teacherSubjects.contains(studentSubject)) {
					numStudents++;
				}
			}
		}
		return numStudents;
	}
}
