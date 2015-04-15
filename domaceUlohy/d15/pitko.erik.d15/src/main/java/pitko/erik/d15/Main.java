package pitko.erik.d15;

import java.util.ArrayList;
import java.util.UUID;

public class Main {
	private final static int USERS = 1000000;

	public static void main(String[] args) {
		ArrayList<Person> person = new ArrayList<Person>();
		StringBuffer buff = new StringBuffer();
		UUID name, surname, numOfBirth;
		long start;

		String names = "";
		
		for (int i = 0; i < USERS; i++) {
			name = UUID.randomUUID();
			surname = UUID.randomUUID();
			numOfBirth = UUID.randomUUID();
			person.add(new Person(name.toString(), surname.toString(), numOfBirth.toString()));
		}
		
		start = System.currentTimeMillis();
		for (int i = 0; i < USERS; i++) {
			names.concat(person.get(i).getName() + " ");
			names.concat(person.get(i).getSurname() + " ");
			names.concat("\n");
		}
		System.out.println("time with concat: " + (double) (System.currentTimeMillis() - start)/1000);
		names = null;
		System.gc();
		
		start = System.currentTimeMillis();
		for (int i = 0; i < USERS; i++) {
			buff.append(person.get(i).getName());
			buff.append(person.get(i).getSurname());
			buff.append("\n");
		}
		System.out.println("time with stringbuffer: " + (double) (System.currentTimeMillis() - start)/1000);
		buff = null;
		System.gc();
		

	}

}
