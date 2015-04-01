import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Loading {
	
	public static ArrayList<Trans> loadVehicles(String file) throws FileNotFoundException {
		
		ArrayList<Trans> vehicles = new ArrayList<Trans>();
		final Scanner sc = new Scanner(new FileReader(file));
		sc.nextLine();
		
		while(sc.hasNextLine()) {
			final String[] vehiclesInfo = sc.nextLine().split(", ");
			
			final Types type = Types.valueOf(vehiclesInfo[0]);
			final double km = Double.parseDouble(vehiclesInfo[1]);
			final int yom = Integer.parseInt(vehiclesInfo[2]);
			final int aveLife = Integer.parseInt(vehiclesInfo[3]);
			final String vin = vehiclesInfo[4];
			final int wheels = Integer.parseInt(vehiclesInfo[5]);
			final boolean hitch = Boolean.parseBoolean(vehiclesInfo[6]);
			final boolean people = Boolean.parseBoolean(vehiclesInfo[7]);
			
			final Trans vehicle = new Trans(type, km, yom, aveLife, vin, wheels, hitch, people);
			vehicles.add(vehicle);
		}
		
		
		sc.close();
		return vehicles;
	}
}
