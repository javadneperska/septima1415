package pitko.erik.d20;

import java.util.ArrayList;

public class Student extends Person {
	public ArrayList<String> subjects;
	
	public Student(String name, String surname, int age, boolean sex, ArrayList<String> subjects) {
		super(name, surname, age, sex);
		this.subjects = subjects;
	}

}
