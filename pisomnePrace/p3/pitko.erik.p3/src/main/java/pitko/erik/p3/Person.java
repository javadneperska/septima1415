package pitko.erik.p3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.UUID;

public class Person {
	private UUID uuid;
	private String name;
	private String surname;
	private int age;
	private int DoB;
	private ArrayList<String> places = new ArrayList<String>();
	
	public Person(String name, String surname, int age, int doB, String[] places) {
		super();
		Random rand = new Random();
		this.uuid = UUID.randomUUID();
		this.name = name;
		this.surname = surname;
		this.age = age;
		DoB = doB;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=1; i<places.length; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        for (int i=0; i<3+rand.nextInt(places.length - 3); i++) {
            this.places.add(places[list.get(i)]);            
        }
	}

	@Override
	public String toString() {
		return "Person [uuid=" + uuid + ", name=" + name + ", surname=" + surname + ", age=" + age + ", DoB=" + DoB + ", places=" + places + "]";
	}

}
