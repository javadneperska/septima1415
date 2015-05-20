package pitko.erik.p3;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/*
 * program, nacita 2 externe subory
 * 1 subor obsahuje zoznam ludi(5 hodnot) 
 * 2 subor obsahuje zoznam navstivenych miest
 * nahodne priraduje minimalne 3 navstivene miesta pre kazdeho cloveka
 * min 10 ludi
*/
public class Main {

	public static void main(String[] args) {
		ArrayList<Person> LPeople = new ArrayList<Person>();
		FileUtils fileNames = new FileUtils("names.txt");
		FileUtils filePlaces = new FileUtils("places.txt");
		
		try {
			String people[] = fileNames.loadFile();
			String placesL[] = filePlaces.loadFile();
			String places[] = placesL[0].split(",");
			
			for (int i = 0; i < people.length; i++){
				String[] data = people[i].split(",");
				LPeople.add(new Person(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), places));
				System.out.println(LPeople.get(i).toString());
			}			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
