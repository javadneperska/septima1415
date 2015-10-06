package pitko.erik.d20;

import java.util.ArrayList;

public class Teacher extends Person{
	public ArrayList<String> subjects;
	public double payPerHour;

	public Teacher(String name, String surname, int age, boolean sex, double payPerHour, ArrayList<String> subjects) {
		super(name, surname, age, sex);
		this.subjects = subjects;
		this.payPerHour = payPerHour;
	}

	@Override
	public String toString() {
		return "Teacher [subjects=" + subjects + ", payPerHour=" + payPerHour + ", name=" + name + ", surname=" + surname + ", sex=" + sex + ", age=" + age + "]";
	}
	
	
}
