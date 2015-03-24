package pavlo.fuska.z1;

import java.util.Arrays;

public class ExtraInfo {
	final int pastJobs;
	final int yearsOfPractice;
	final Subject[] subjects;
	final int age;

	public ExtraInfo(Subject[] subjects, int pastJobs, int yearsOfPractice, int age) {
		this.subjects = subjects;
		this.pastJobs = pastJobs;
		this.yearsOfPractice = yearsOfPractice;
		this.age = age;
	}

	@Override public String toString() {
		return "ExtraInfo [Number of past jobs=" + pastJobs + ", Years of practice=" + yearsOfPractice + ", Subjects=" + Arrays.toString(subjects) + ", Age=" + age + "]";
	}

	public int getNumberOfPastJobs() {
		return pastJobs;
	}

	public int getYearsOfPractice() {
		return yearsOfPractice;
	}

	public Subject[] getSubjects() {
		return subjects;
	}

	public int getAge() {
		return age;
	}
}