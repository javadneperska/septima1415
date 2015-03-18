import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;


public class Employee {
	String name, surname, idNumber;
	int age, numOfEmployers, yearsOfExperience;
	Gender gender;
	WorkType type;
	Address address;
	ArrayList<String> subjects;
	static HashMap<WorkType, HashMap<String, Integer>> mapSubjects = new HashMap<WorkType, HashMap<String, Integer>>();
	
	public Employee(String name, String surname, String idNumber, int age, int numOfEmployers, int yearsOfExperience, Gender gender,
			WorkType type, Address address, ArrayList<String> subjects) {
		this.name = name;
		this.surname = surname;
		this.idNumber = idNumber;
		this.age = age;
		this.numOfEmployers = numOfEmployers;
		this.yearsOfExperience = yearsOfExperience;
		this.gender = gender;
		this.type = type;
		this.address = address;
		this.subjects = subjects;
		populateMapSubjects();
	}
	
	private void populateMapSubjects() {
		if (mapSubjects.get(type) != null) {
			for (String subject: subjects) {
				if (mapSubjects.get(type).get(subject) != null) {
					int count = mapSubjects.get(type).get(subject);
					mapSubjects.get(type).put(subject, ++count);
				} else {
					mapSubjects.get(type).put(subject, 1);
				}
			}
		} else {
			mapSubjects.put(type, new HashMap<String, Integer>());
			for (String subject: subjects) {
				mapSubjects.get(type).put(subject, 1);
			}
		}
	}
	
	private static TreeMap<String, Integer> sortSubjects(HashMap<String, Integer> map) {
		ValueComparator vc =  new ValueComparator(map);
		TreeMap<String,Integer> sortedMap = new TreeMap<String,Integer>(vc);
		sortedMap.putAll(map);
		return sortedMap;
	}
	
	public static String[] getPopularSubjects(WorkType t) {
		TreeMap<String, Integer> allSubjectsByType = sortSubjects(mapSubjects.get(t));
		Set<String> orderedSubjectsKeysSet = allSubjectsByType.keySet();
		ArrayList<String> orderedSubjectsKeysList = new ArrayList<String>(orderedSubjectsKeysSet);
		int sizeArr = orderedSubjectsKeysList.size() >= 3 ? 3 : orderedSubjectsKeysList.size();
		String[] popularSubjects = new String[sizeArr];
		
		for (int i = 0; i < sizeArr; i++) {
			popularSubjects[i] = orderedSubjectsKeysList.get(i);
		}
		return popularSubjects;
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

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNumOfEmployers() {
		return numOfEmployers;
	}

	public void setNumOfEmployers(int numOfEmployers) {
		this.numOfEmployers = numOfEmployers;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public WorkType getType() {
		return type;
	}

	public void setType(WorkType type) {
		this.type = type;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ArrayList<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(ArrayList<String>subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname
				+ ", idNumber=" + idNumber + ", age=" + age
				+ ", numOfEmployers=" + numOfEmployers + ", yearsOfExperience="
				+ yearsOfExperience + ", gender=" + gender + ", type=" + type
				+ ", address=" + address + ", subjects=" + subjects + "]";
	}
}
