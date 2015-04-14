package pavol.molnar.d15;

public class Person {

	private String name;
	private String surname;
	private String birth;

	public Person(String name, String surname, String birth) {
		super();
		this.name = name;
		this.surname = surname;
		this.birth = birth;
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

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + ", birth="
				+ birth + "]";
	}

}
