package stock.stock;

import java.util.ArrayList;

public class StockItem {
	public int quantity;
	public double price;
	public String name;
	
	public StockItem(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "StockItem [price=" + price + ", quantity=" + quantity + ", name=" + name + "]";
	}
}
