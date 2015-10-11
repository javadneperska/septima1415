package stock.stock;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
    public static void main( String[] args ) throws FileNotFoundException
    {
    	ArrayList<StockItem> stockItems = new ArrayList<StockItem>();
    	final Scanner scFileInput = new Scanner(new FileReader("input.csv"));
    	final Scanner scSystemIn = new Scanner(System.in);
    	int stockIndex;
    	boolean exit = false;
    	scFileInput.nextLine();
    	
    	while(scFileInput.hasNextLine()) {
    		final String[] stockItemInfo = scFileInput.nextLine().split(", ");
    		
    		final String name = stockItemInfo[0];
    		final double price = Double.parseDouble(stockItemInfo[1]);
    		final int quantity = Integer.parseInt(stockItemInfo[2]);
    		
    		final StockItem stockItem = new StockItem(name, price, quantity);
    		
    		stockItems.add(stockItem);
    	}
    	
    	scFileInput.close();
    	
    	do {
    		System.out.println("Next action [S(show items), A(add items to stock), P(pick item from the stock), E(exit)]:");
			String choice = scSystemIn.next();
			
			switch (choice) {
			case "S":
				for (int i = 0; i < stockItems.size(); i++) {
					System.out.println(i+1 + "." + stockItems.get(i).getName());
				}
				System.out.println();
				System.out.println("Choose item: \n");
				
				stockIndex = scSystemIn.nextInt();
				System.out.println(stockItems.get(stockIndex - 1));
				break;
				
			case "A":
				System.out.println("Choose item: \n");
				for (int i = 0; i < stockItems.size(); i++) {
					System.out.println(i+1 + "." + stockItems.get(i).getName());
				}
				
				stockIndex = scSystemIn.nextInt();
				
				if (stockIndex > stockItems.size()) {
					System.out.println("\nIndex is out of range. \n");
					break;
				} else {
					System.out.println("Give me the quantity(current-" + stockItems.get(stockIndex -1).getQuantity() + "):");
					int quantity = scSystemIn.nextInt();
					stockItems.get(stockIndex - 1).setQuantity(stockItems.get(stockIndex - 1).getQuantity() + quantity);
					break;
				}
			
			case "P":
				System.out.println("Choose item: \n");
				for (int i = 0; i < stockItems.size(); i++) {
					System.out.println(i+1 + "." + stockItems.get(i).getName());
				}
				
				stockIndex = scSystemIn.nextInt();
				
				if (stockIndex > stockItems.size()) {
					System.out.println("\nIndex is out of range. \n");
					break;
				} else {
					System.out.println("Give me the quantity(current-" + stockItems.get(stockIndex -1).getQuantity() + "):");
					int quantity = scSystemIn.nextInt();
					if (quantity > stockItems.get(stockIndex -1).getQuantity()) {
						System.out.println("I don't have that much in stock.");
						break;
					} else if (stockItems.get(stockIndex -1).getQuantity() - quantity == 1) {
						System.out.println("Last item is remaining.");
					}
					stockItems.get(stockIndex - 1).setQuantity(stockItems.get(stockIndex - 1).getQuantity() - quantity);
					break;
				}
			
			case "E":
				exit = true;
				System.out.println("Program exited.");
				break;
			
			default:
				System.out.println("Wrong choice");
				break;
			}
		} while (!exit);
    }
}
