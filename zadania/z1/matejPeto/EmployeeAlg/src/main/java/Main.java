import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		ArrayList<Employee> employees = new ArrayList<Employee>();
		final Scanner sc = new Scanner(new FileReader("employees.csv"));
		sc.nextLine();
		
		while(sc.hasNextLine()) {
			final String[] employerInfo = sc.nextLine().split(", ");
			
			final String name = employerInfo[0];
			final String surname = employerInfo[1];
			final String idNumber = employerInfo[2];
			final Gender gender = Gender.valueOf(employerInfo[3]);
			final int age = Integer.parseInt(employerInfo[4]);
			final WorkType type = WorkType.valueOf(employerInfo[5]);
			final int numOfEmployers = Integer.parseInt(employerInfo[6]);
			final int yearsOfExperience = Integer.parseInt(employerInfo[7]);
			final ArrayList<String> subjects = new ArrayList<String>();
			for (String subject : employerInfo[8].split(" ")) {
				subjects.add(subject);
			}
			final String street = employerInfo[9];
			final int houseNumber = Integer.parseInt(employerInfo[10]);
			final String city = employerInfo[11];
			final String district = employerInfo[12];
			final String country = employerInfo[13];
			
			final Address address = new Address(street, city, district, country, houseNumber);
			final Employee employee = new Employee(name, surname, idNumber, age, numOfEmployers, yearsOfExperience, gender, type, address, subjects);
			
			employees.add(employee);
		}
		
		System.out.println("Employees:\n");
		for (Employee employee: employees) {
			System.out.println(employee);
		}
		
		System.out.println("\nMost popular subjects by type:\n");
		
		for (WorkType type: WorkType.values()) {
			System.out.println(type + "=" + Arrays.toString(Employee.getPopularSubjects(type)));
		}
		
		sc.close();
	}
}
