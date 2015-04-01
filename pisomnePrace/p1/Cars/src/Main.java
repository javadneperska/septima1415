import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

	/**
	 * @param args
	 */
	public static ArrayList<Trans> ARR = new ArrayList<Trans>();
	public static int CARN;

	public static void main(String[] args) {

		try {
			int input = 0;
			ARR = Loading.loadVehicles("vehicles.csv");
			while(input != 5){
				Utils.chooseMenu(input);
				Utils.printMenu();
				input = Utils.sc.nextInt();
			}
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
