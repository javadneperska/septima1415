import java.io.FileNotFoundException;
import java.util.Scanner;

public class Utils {
	public static Scanner sc = new Scanner(System.in);

	public static Trans getTransFromInput() {
		Types type;
		double km;
		int yom;
		int aveLife;
		String vin;
		int wheels;
		boolean hitch;
		boolean people;

		System.out.print("Enter vehicle type:");
		type = Types.fromString(sc.next());
		System.out.print("Enter number of km traveled:");
		km = sc.nextDouble();
		System.out.print("Enter year of manufacture:");
		yom = sc.nextInt();
		System.out.print("Enter average life:");
		aveLife = sc.nextInt();
		System.out.print("Enter VIN:");
		vin = sc.next();
		System.out.print("Enter number of wheels:");
		wheels = sc.nextInt();
		System.out.print("Does the vehicle have hitch?:");
		hitch = sc.next().startsWith("y");
		System.out.print("Does the vehicle carry people?:");
		people = sc.next().startsWith("y");

		return new Trans(type, km, yom, aveLife, vin, wheels, hitch, people);
	}

	public static void printMenu(){
		System.out.println("1. add ");
		System.out.println("2. delete ");
		System.out.println("3. print ");
		System.out.println("4. sort ");		
	}
	public static void chooseMenu(int op) throws FileNotFoundException {
		switch (op) {
		case 1:
			addCar();
			break;
		case 2:
			delCar();
			break;
		case 3:
			printCars();
			break;
		case 4:
			sort();
			break;
		}
	}

	public static void printCars() {
		Main.CARN = 1;
		for (int n = 0; n < Main.ARR.size(); n++) {
			System.out.format("%2d. " + Main.ARR.get(n).toString(), Main.CARN);
			System.out.println();
			Main.CARN++;
		}
	}

	public static void addCar() {
		try {
			Main.ARR.add(getTransFromInput());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void delCar() {
		System.out.println("Enter index of car to delete");
		Main.ARR.remove(sc.nextInt() - 1);
	}

	public static void sort() {
		System.out.println("Enter parameter to sort by(type, wheels, km)");
		switch (sc.next().toLowerCase()) {
		case "type":
			Main.ARR.sort(new Trans.SorterbyType());
			break;
		case "wheels":
			Main.ARR.sort(new Trans.SorterbyWheels());
			break;
		case "km":
			Main.ARR.sort(new Trans.SorterbyKm());
			break;

		}
	}

}
