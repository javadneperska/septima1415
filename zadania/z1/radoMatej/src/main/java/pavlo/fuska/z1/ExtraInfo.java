package pavlo.fuska.z1;

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

	public int getPastJobs() {
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