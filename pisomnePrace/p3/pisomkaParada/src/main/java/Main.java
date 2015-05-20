import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		ArrayList<Person> people = new ArrayList<Person>();
		ArrayList<String> cities = new ArrayList<String>();
		Random randGen = new Random();
		
		Scanner scPeople = null, scCities = null;
		
		try {
			scPeople = new Scanner(new FileReader("people.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			scCities = new Scanner(new FileReader("cities.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		scPeople.nextLine();
		
		while(scPeople.hasNextLine()) {
			final String[] personInfo = scPeople.nextLine().split(", ");
			
			final String name = personInfo[0];
			final String middlename = personInfo[1];
			final String surname = personInfo[2];
			final int age = Integer.parseInt(personInfo[3]);
			final int numberOfSiblings = Integer.parseInt(personInfo[4]);
			
			Person p = new Person(name, middlename, surname, age, numberOfSiblings);
			
			people.add(p);
		}
		
		while(scCities.hasNextLine()) {
			String city = scCities.nextLine();
			cities.add(city);
		}
		
		for (Person p : people) {
			ArrayList<String> tempCities = new ArrayList<String>(cities);
			for (int i = 0; i < 3; i++) {
				int randInt = randGen.nextInt(cities.size()-2);
				String city = tempCities.get(randInt);
				tempCities.remove(randInt);
				p.addVisitedCity(city);
			}
		}
		
		for (Person p : people) {
			System.out.println(p);
		}
	}
}
