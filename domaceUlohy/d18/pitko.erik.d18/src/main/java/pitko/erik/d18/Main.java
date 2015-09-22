package pitko.erik.d18;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static ArrayList<Product> list = new ArrayList<Product>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String option;
		Types type;
		for (int i = 0; i < 15; i++) {
			Utils.addRandProduct();
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}

		while (true) {
			Product product = null;
			Utils.printProductTypes();
			System.out.println("Name of product(name) / print product types(p) / quit(q)");
			option = sc.nextLine();
			option = option.toUpperCase();
			if (!option.equals("P") && !option.equals("Q")) {
				// System.out.println(type.toString());
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).getType().toString().equals(option)) {
						product = list.get(i);
						break;
					}
				}
				if (product != null) {
					type = Types.valueOf(option.toUpperCase());
					int numofProd;
					boolean selected = true;
					while (selected) {
						Utils.printMenu();
						option = sc.nextLine();
						switch (option) {
						case "1":
							System.out.println(
									"Number of product type " + product.getType() + " : " + product.getNumOfProducts());
							break;
						case "2":
							System.out
									.println("Price of product type " + product.getType() + " : " + product.getPrice());
							break;
						case "3":
							System.out.println("Enter number of products that have been added to storage: ");
							numofProd = sc.nextInt();
							sc.nextLine();
							Utils.addProduct(type, numofProd);
							break;
						case "4":
							System.out.println("Enter number of products previously selected to delete from storage: ");
							numofProd = sc.nextInt();
							sc.nextLine();
							Utils.delProduct(type, numofProd);
							break;
						case "5":
							selected = false;
							break;
						default:
							System.out.println("You have selected wrong menu option, please try again.");

						}
					}
				} else {
					System.out.println("Product is not available in storage properties ...");
					// System.out.println("Enter number of products and their
					// price");

					// list.add(new Product(type, sc.nextInt(),
					// sc.nextDouble()));
					// sc.next();
				}
			}else if (option.equals("Q")){
				sc.close();
				System.exit(0);
			}

			/*
			 * if (option.equals("a")) { for (int i = 0; i < list.size(); i++) {
			 * Product product = list.get(i); System.out.println("Numb. of " +
			 * product.getType().toString().toLowerCase() + "s : " + product
			 * .getNumOfProducts()); } }
			 */
		}

	}

}
