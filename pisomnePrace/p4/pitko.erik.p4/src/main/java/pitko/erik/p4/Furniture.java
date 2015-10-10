package pitko.erik.p4;


import java.util.Arrays;
import java.util.Comparator;

public class Furniture {
	private static double previous;
	
	private String type;
	private Material material;
	private Color color;
	private int[] size = new int[3];
	private double price;
	private static boolean firstP = true;
	private static long fullPrice = 0;

	public static long getFullPrice() {
		return fullPrice;
	}

	public Furniture(String type, String material, int[] size) {
		super();
		material = material.toUpperCase();

		switch (Main.rand.nextInt(4)) {
		case 0:
			color = Color.RED;
			break;
		case 1:
			color = Color.GREEN;
			break;
		case 2:
			color = Color.BLUE;
			break;
		default:
			color = Color.BLACK;
		}

		switch (material) {
		case "WOOD":
			this.material = Material.WOOD;
			break;
		case "PARTICLEBOARD":
			this.material = Material.PARTICLEBOARD;
			break;
		default:
			this.material = Material.OTHER;
		}

		if (firstP){
			this.price = Main.price;		
			Furniture.previous = price;
			firstP = false;
		}else{
			this.price = previous;
		}
		previous += (previous*(10/100.0f));
		
		this.type = type;
		this.size = size;
		Furniture.fullPrice += this.price;
	}
	
	public int getWidth(){
		return this.size[0];
	}
	
	public int getLength(){
		return this.size[1];
	}
	
	@Override
	public String toString() {
		String out = String.format("Furniture [type= %s, material= %s, color= %s, size=" + Arrays
				.toString(size) + ", price= %.02f]", type, material, color, price);
		return out;
	}
	
	public final static class SortbyLength implements Comparator<Furniture> {
		
		@Override
		public int compare(Furniture o1, Furniture o2) {
			return o1.getLength() - o2.getLength();
		}
		
	}
}
