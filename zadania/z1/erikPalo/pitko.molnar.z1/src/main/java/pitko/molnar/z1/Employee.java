package pitko.molnar.z1;

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
	private Address address;
	private Type type;
	
	
	public Employee(String name, String surname, String birthNum,
			boolean gender, String expertise, int lastJobs, int expYears,
			String[] teachingSubjects, int age, String city, String country, String district, int houseNum, String street, Type type) {
		super();
		this.name = name;
		this.surname = surname;
		this.birthNum = birthNum;
		this.gender = gender;
		this.expertise = expertise;
		this.lastJobs = lastJobs;
		this.expYears = expYears;
		this.teachingSubjects = teachingSubjects;
		this.age = age;
		this.address.setCity(city);
		this.address.setCountry(country);
		this.address.setDistrict(district);
		this.address.setHouseNum(houseNum);
		this.address.setStreet(street);
		this.type = type;
	}

	
}
