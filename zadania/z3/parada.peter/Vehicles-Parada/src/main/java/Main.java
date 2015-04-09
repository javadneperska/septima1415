import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		final UtilsVehicles utilVehicles = new UtilsVehicles("vehicles.csv");
		boolean exit = false;

//		MENU
		do {
			System.out.println("Vehicles menu - What do you want next?");
			System.out.println("A(add), D(delete), L(list), R(reload), S(sort), E(exit)");
			String choice = sc.next();
			
			switch (choice) {
			case "A":
			case "a":
//				ADD VEHICLE
				System.out.printf("Add vehicle:");
				
//				A: TYPE
				System.out.printf("\nType(*PERSONAL*,TRUCK): ");
				Type type = Type.PERSONAL;
				sc.nextLine();
				String typeChoice = sc.nextLine();
				switch (typeChoice.toUpperCase()) {
				case "TRUCK":
					type = Type.TRUCK;
				}
				System.out.printf("Type=" + type);
				
//				A: MILEAGE
				System.out.printf("\nMileage(0): ");
				double mileage = 0.0;
				String mileageChoice = sc.nextLine();
				switch (mileageChoice) {
				case "":
					break;
				default:
					mileage = Double.parseDouble(mileageChoice);
					break;
				}
				System.out.printf("Mileage=" + mileage);
				
//				A: YEAR OF RELEASE
				System.out.printf("\nYear of release(2015): ");
				int yearOfRelease = 2015;
				String yearOfReleaseChoice = sc.nextLine();
				switch (yearOfReleaseChoice) {
				case "":
					break;
				default:
					yearOfRelease = (int) Double.parseDouble(yearOfReleaseChoice);
					break;
				}
				System.out.printf("Year_of_release=" + yearOfRelease);
				
//				A: LIFESPAN
				System.out.printf("\nLifespan(10): ");
				int lifespan = 10;
				String lifespanChoice = sc.nextLine();
				switch (lifespanChoice) {
				case "":
					break;
				default:
					lifespan = (int) Double.parseDouble(lifespanChoice);
					break;
				}
				System.out.printf("Lifespan=" + lifespan);
				
//				A: VIN
				System.out.printf("\nVIN(AAAAAAAAAA): ");
				String VIN = "AAAAAAAAAA";
				String VINChoice = sc.nextLine();
				switch (VINChoice) {
				case "":
					break;
				default:
					VIN = VINChoice.toUpperCase();
					break;
				}
				System.out.printf("VIN=" + VIN);
				
//				A: NUM OF WHEELS
				System.out.printf("\nNum of wheels(4): ");
				int numOfWheels = 4;
				String numOfWheelsChoice = sc.nextLine();
				switch (numOfWheelsChoice) {
				case "":
					break;
				default:
					numOfWheels = (int) Double.parseDouble(numOfWheelsChoice);
					break;
				}
				System.out.printf("Num_of_wheels=" + numOfWheels);
				
//				A: CAN MONTAGE
				System.out.printf("\nCan montage(true): ");
				boolean canMontage = true;
				String canMontageChoice = sc.nextLine();
				switch (canMontageChoice.toLowerCase()) {
				case "false":
					canMontage = false;
					break;
				}
				System.out.printf("Can_montage=" + canMontage);
				
//				A: CAN TRANSPORT PEOPLE
				System.out.printf("\nCan transport people(true): ");
				boolean canTransportPeople = true;
				String canTransportPeopleChoice = sc.nextLine();
				switch (canTransportPeopleChoice.toLowerCase()) {
				case "false":
					canTransportPeople = false;
					break;
				}
				System.out.printf("Can_transport_people=" + canTransportPeople + "\n\n");
				
				Vehicle vehicle = new Vehicle(type, mileage, yearOfRelease, lifespan, VIN, numOfWheels, canMontage, canTransportPeople);
				utilVehicles.addVehicle(vehicle);
				break;
				
			
			case "D":
			case "d":
//				DELETE VEHICLE
				System.out.println("Choose index(1," + utilVehicles.getSize() + ")");
				int indexChoice = (int) sc.nextDouble();
				if (indexChoice >= 1 && indexChoice <= utilVehicles.getSize()) {
					System.out.println("Deleted " + indexChoice + ". vehicle");
					utilVehicles.removeVehicle(indexChoice);
				} else {
					System.out.println("\nErr: Wrong number.\n\n");
				}
				break;
			
			case "L":
			case "l":
//				LIST OF VEHICLES
				utilVehicles.printVehicles();
				break;
			
			case "R":
			case "r":
//				RELOAD MENU
				break;
				
			case "S":
			case "s":
//				SORT VEHICLES
				System.out.printf("Sort by type(*MILEAGE*, LIFESPAN, NUM_OF_WHEELS):");
				SortType sortType = SortType.MILEAGE;
				sc.nextLine();
				String sortChoice = sc.nextLine();
				switch (sortChoice.toUpperCase()) {
				case "LIFESPAN":
					sortType = SortType.LIFESPAN;
					System.out.printf("Sorted by lifespan.\n\n");
					break;
				case "NUM_OF_WHEELS":
					sortType = SortType.NUM_OF_WHEELS;
					System.out.printf("Sorted by number of wheels.\n\n");
					break;
				default:
					System.out.printf("Sorted by mileage.\n\n");
					break;
				}
				utilVehicles.sortBy(sortType);
				break;
				
			case "E":
			case "e":
//				EXIT MENU
				exit = true;
				System.out.printf("\nInfo: Exited");
				break;
				
			default:
				System.out.printf("\nErr: Can't recognize input.\n\n");
				break;
			}
		} while (!exit);
		sc.close();
	}

}
