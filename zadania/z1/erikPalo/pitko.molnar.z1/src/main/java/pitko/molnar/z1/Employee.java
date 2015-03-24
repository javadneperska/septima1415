package pitko.molnar.z1;

import java.util.Arrays;

public class Employee {
	private String name;
	private String surname;
	private String birthNum;
	private boolean gender;
	private String expertise;
	private int lastJobs;
	private int expYears;
	private String[] teachingSubjects;
	private int age;
	private Type type;
	
	
	public Employee(String name, String surname, String birthNum,
			boolean gender, int lastJobs, int expYears,
			String[] teachingSubjects, int age, String city, String country, String district, int houseNum, String street, Type type) {
		super();
		this.name = name;
		this.surname = surname;
		this.birthNum = birthNum;
		this.gender = gender;
		this.type = type;
		this.lastJobs = lastJobs;
		this.expYears = expYears;
		this.teachingSubjects = teachingSubjects;
		this.age = age;
		Address.country = country;
		Address.city = city;
		Address.district = district;
		Address.houseNum = houseNum;
		Address.street = street;
	}


	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + ", birthNum=" + birthNum + ", gender=" + gender + ", expertise=" + expertise + ", lastJobs=" + lastJobs + ", expYears=" + expYears + ", teachingSubjects=" + Arrays
				.toString(teachingSubjects) + ", age=" + age + ", type=" + type + "]";
	}

	
}
