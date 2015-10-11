package parada.peter.d20;

public class Person {
	public String name;
	public String surname;
	public boolean isMale;
	public int age;
	
	public Person(String name, String surname, int age, boolean isMale) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.isMale = isMale;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
