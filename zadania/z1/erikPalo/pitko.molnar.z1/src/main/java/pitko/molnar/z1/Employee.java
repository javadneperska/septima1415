package pitko.molnar.z1;

import java.util.Arrays;

public class Employee {
	public static int max = 0;
	private String name;
	private String surname;
	private String birthNum;
	private boolean gender;
	private Type expertise;
	private int lastJobs;
	private int expYears;
	private String[] teachingSubjects;
	private int age;
	
	
	public Employee(String name, String surname, String birthNum,
			boolean gender, int lastJobs, int expYears,
			String[] teachingSubjects, int age, String city, String country, String district, int houseNum, String street, Type type) {
		super();
		this.name = name;
		this.surname = surname;
		this.birthNum = birthNum;
		this.gender = gender;
		this.expertise = type;
		this.lastJobs = lastJobs;
		this.expYears = expYears;
		this.teachingSubjects = teachingSubjects;
		this.age = age;
		Address.country = country;
		Address.city = city;
		Address.district = district;
		Address.houseNum = houseNum;
		Address.street = street;
		for (String k : teachingSubjects){
			max++;
		}
	}

	public Type getExpertise(){
		return expertise;
	}
	
	public String[] getSubjects(){
		return teachingSubjects;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + ", birthNum=" + birthNum + ", gender=" + gender + ", expertise=" + expertise + ", lastJobs=" + lastJobs + ", expYears=" + expYears + ", teachingSubjects=" + Arrays
				.toString(teachingSubjects) + ", age=" + age + "]";
	}

	
}
