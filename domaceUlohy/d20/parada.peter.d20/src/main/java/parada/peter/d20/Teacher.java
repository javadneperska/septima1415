package parada.peter.d20;

import java.util.ArrayList;

public class Teacher extends Person {
	public ArrayList<String> subjects;
	public double payPerHour;

	public Teacher(String name, String surname, int age, boolean sex, double payPerHour, ArrayList<String> subjects) {
		super(name, surname, age, sex);
		this.subjects = subjects;
		this.payPerHour = payPerHour;
	}

	public ArrayList<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(ArrayList<String> subjects) {
		this.subjects = subjects;
	}

	public double getPayPerHour() {
		return payPerHour;
	}

	public void setPayPerHour(double payPerHour) {
		this.payPerHour = payPerHour;
	}
}
