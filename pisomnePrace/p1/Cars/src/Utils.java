import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {
	public static Scanner sc = new Scanner(System.in);

	public static Trans getTransFromInput() {
		Types type;
		double km;
		int yom = 0;
		int aveLife;
		String vin;
		int wheels;
		boolean hitch = false;
		boolean people = false;
		boolean istrue = false;

		System.out.print("Enter vehicle type (personal / truck):");
		while ((type = Types.fromString(sc.next())) == null) {
			System.out.println("Enter personal or truck");
		}
		System.out.print("Enter number of km traveled:");
		while (true) {
			try {
				km = sc.nextDouble();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Enter a valid number!");
				sc.next();
			}
		}
		System.out.print("Enter year of manufacture:");
		while (true) {
			try {
				yom = sc.nextInt();
				if ((yom >= Calendar.getInstance().get(Calendar.YEAR)) || (yom < 0)) {
					System.out.println("Enter a valid year");
				} else {
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Enter a valid number!");
				sc.next();
			}
		}
		System.out.print("Enter average life:");
		while (true) {
			try {
				aveLife = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Enter a valid number!");
				sc.next();
			}
		}
		System.out.print("Enter VIN:");
		vin = sc.next().toUpperCase();
		System.out.print("Enter number of wheels:");
		while (true) {
			try {
				wheels = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Enter a valid number!");
				sc.next();
			}
		}
		System.out.print("Does the vehicle have hitch?(yes / no):");
		while (!istrue) {
			switch (sc.next()) {
			case "yes":
				hitch = true;
				istrue = true;
				break;
			case "no":
				istrue = true;
				break;
			default:
				System.out.println("Enter yes or no");
			}
		}
		System.out.print("Does the vehicle carry people?(yes / no):");
		istrue = false;
		while (!istrue) {
			switch (sc.next()) {
			case "yes":
				hitch = true;
				istrue = true;
				break;
			case "no":
				istrue = true;
				break;
			default:
				System.out.println("Enter yes or no");
			}
		}
		return new Trans(type, km, yom, aveLife, vin, wheels, hitch, people);
	}

	public static void printMenu() {
		System.out.println("add");
		System.out.println("delete");
		System.out.println("print");
		System.out.println("sort");
		System.out.println("exit");
	}

	public static void chooseMenu(String op) throws FileNotFoundException {
		switch (op) {
		case "add":
			addCar();
			break;
		case "delete":
			delCar();
			break;
		case "print":
			printCars();
			break;
		case "sort":
			sort();
			break;
		case "exit":
			System.exit(0);
		default:
			System.out.println("Please enter one of the menu options");
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
