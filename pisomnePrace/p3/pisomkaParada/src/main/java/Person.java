import java.util.ArrayList;


public class Person {
	String name, middlename, surname;
	int age, numberOfSiblings;
	ArrayList<String> visitedCities = new ArrayList<String>();
	
	public Person(String name, String middlename, String surname, int age,
			int numberOfSiblings) {
		this.name = name;
		this.middlename = middlename;
		this.surname = surname;
		this.age = age;
		this.numberOfSiblings = numberOfSiblings;
	}
	
	public void addVisitedCity(String city) {
		visitedCities.add(city);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNumberOfSiblings() {
		return numberOfSiblings;
	}

	public void setNumberOfSiblings(int numberOfSiblings) {
		this.numberOfSiblings = numberOfSiblings;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", middlename=" + middlename
				+ ", surname=" + surname + ", age=" + age
				+ ", numberOfSiblings=" + numberOfSiblings + ", visitedCities="
				+ visitedCities + "]";
	}
	
	
	
}
