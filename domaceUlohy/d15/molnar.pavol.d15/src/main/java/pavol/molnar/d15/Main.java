package pavol.molnar.d15;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		int count = 1000000;
		ArrayList<Person> person = new ArrayList<Person>();
		StringBuffer buffer = new StringBuffer();
		String pers="";
		UUID name, surname, birth;
		for (int i = 0; i < count; i++) {
			name = UUID.randomUUID();
			surname = UUID.randomUUID();
			birth = UUID.randomUUID();
			person.add(new Person(name.toString(),surname.toString(),birth.toString()));

		}
		long start = System.currentTimeMillis();
		for (int i = 0; i< count; i++) {
			pers.concat(person.get(i).getName());
			pers.concat(person.get(i).getSurname());
			pers.concat(person.get(i).getBirth()); }
		pers= null;	
		long timeInmiliSec= (System.currentTimeMillis()- start);	
		System.out.println("Time in miliseconds withouth string buffer: " + timeInmiliSec);
		
		start = System.currentTimeMillis();
		
		for (int a = 0; a<count; a++) {
			
			buffer.append(person.get(a).getName());
			buffer.append(person.get(a).getSurname());
			buffer.append(person.get(a).getBirth());
			
		}
		
		timeInmiliSec= ( System.currentTimeMillis()-start);
		System.out.println("Time in seconds with buffer: " + timeInmiliSec);
	
	}
	}
