package pitko.erik.d18;

import java.util.Random;
import java.util.Scanner;

public class Utils {
	private static Random rand = new Random();

	public static void printProductTypes() {
		StringBuffer buff = new StringBuffer();
		buff.append("Product types: ");
		for (Types values : Types.values()) {
			buff.append(values.toString());
			buff.append(", ");
		}
		System.out.println(buff.toString());
	}

	public static void printMenu() {
		System.out.println("1 = Print num of prod.");
		System.out.println("2 = Print price of a product");
		System.out.println("3 = Add product to storage");
		System.out.println("4 = Delete product from storage");
		System.out.println("5 = Go back to previous menu");
	}

	public static void addProduct(Types type, int numOfProducts) {
		boolean exists = false;
		Product product = null;
		for (int i = 0; i < Main.list.size(); i++) {
			product = Main.list.get(i);
			if (type.equals(product.getType())) {
				exists = true;
				break;
			}
		}
		if (exists) {
			product.setNumOfProducts(product.getNumOfProducts() + numOfProducts);
		} else {
			System.out.println("Enter price of new product: ");
			Scanner sc = new Scanner(System.in);
			double price = sc.nextDouble();
			sc.close();
			Main.list.add(new Product(type, numOfProducts, price));
		}
	}

	public static void delProduct(Types type, int numOfProducts) {
		boolean exists = false;
		Product product = null;
		for (int i = 0; i < Main.list.size(); i++) {
			product = Main.list.get(i);
			if (type.equals(product.getType())) {
				exists = true;
				break;
			}
		}
		if (exists) {
			int actualNumofProd = product.getNumOfProducts();
			if (actualNumofProd >= numOfProducts){
				if (actualNumofProd == numOfProducts){
					System.out.println("Warning ! No more products left in storage !");
				}else{
					System.out.println(actualNumofProd - numOfProducts + " product/s left in storage");
				}
				product.setNumOfProducts(product.getNumOfProducts() - numOfProducts);
			}else{
				System.out.println("Not enough products left in storage !");
			}
		}
	}

	public static void addRandProduct() {
		boolean exists = false;
		Product product = null;
		int index = 0;
		Types type;
		switch (rand.nextInt(6)) {
		case 0:
			type = Types.CHAIR;
			break;
		case 1:
			type = Types.DESK;
			break;
		case 2:
			type = Types.LAMP;
			break;
		case 3:
			type = Types.NOTEBOOK;
			break;
		case 4:
			type = Types.PERSONAL_COMPUTER;
			break;
		default:
			type = Types.PRINTER;
			break;
		}
		for (int i = 0; i < Main.list.size(); i++) {
			product = Main.list.get(i);
			if (type.equals(product.getType())) {
				exists = true;
				index = i;
				break;
			}
		}
		if (exists) {
			Main.list.get(index).setNumOfProducts(product.getNumOfProducts() + rand.nextInt(5));
		} else {
			Main.list.add(new Product(type));
		}
	}

}
