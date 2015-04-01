import java.util.Scanner;


public class Utils {
	private static Scanner sc = new Scanner(System.in);
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

}
