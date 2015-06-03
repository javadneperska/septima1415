import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner sc = null, scInput = new Scanner(System.in);
		Random rand = new Random();
		ArrayList<Furniture> furnitures = new ArrayList<Furniture>();
		
		try {
			sc = new Scanner(new FileReader("furniture.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("Define initial cost:");
		double initCost = Double.parseDouble(scInput.nextLine());
		boolean costUsed = false;
		sc.nextLine();
		
		do {
			String rawFurniture = sc.nextLine();
			String[] itemsFurniture = rawFurniture.split(", ");
			
			final String type = itemsFurniture[0];
			final String color = itemsFurniture[1];
			final Material material = Material.valueOf(itemsFurniture[2]);
			final double height = Double.parseDouble(itemsFurniture[3]);
			final double width = Double.parseDouble(itemsFurniture[4]);
			final double cost;
			
			if (costUsed) {
				cost = 1.1 * initCost;
				initCost = cost;
			} else {
				cost = initCost;
				costUsed = true;
			}
			
			Furniture f = new Furniture(type, color, material, height, width, cost);
			furnitures.add(f);
			
		} while (sc.hasNextLine());
		
		ArrayList<ArrayList<Furniture>> variations = Utils.permute(furnitures);
		
		final int permutations = 10;
		final double width = 15, height = 3;
		
		for (int i = 0; i < permutations; i++) {
			ArrayList<Furniture> temp = new ArrayList<Furniture>();
			ArrayList<Furniture> copyFurn = new ArrayList<Furniture>(furnitures);
			for (int j = 0; j < 3; j++) {
				int index = rand.nextInt(copyFurn.size());
				temp.add(copyFurn.get(index));
				copyFurn.remove(index);
			}
			if (Utils.canBeCarried(temp, width, height)) {
				System.out.println(temp);
			}
		}
		
		sc.close();
}

}
