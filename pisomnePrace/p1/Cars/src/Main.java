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
		ARR = Loading.loadVehicles("vehicles.csv");
		Utils.printCars();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		

	}
	

}
