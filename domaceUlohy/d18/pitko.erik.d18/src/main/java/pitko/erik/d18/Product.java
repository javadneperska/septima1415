package pitko.erik.d18;

import java.util.Random;

public class Product {
	private Types type;
	private int numOfProducts;
	private double price;
	private Random rand = new Random();
	
	public Product(Types type, int numOfProducts, double price) {
		super();
		this.type = type;
		this.numOfProducts = numOfProducts;
		this.price = price;
	}

	public Product(Types type) {
		super();
		this.type = type;
		this.numOfProducts = rand.nextInt(19) + 1;
		this.price = Math.round(rand.nextDouble()*10000.0);
		this.price = this.price/100.0;
	}


	public int getNumOfProducts() {
		return numOfProducts;
	}

	public void setNumOfProducts(int numOfProducts) {
		this.numOfProducts = numOfProducts;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Types getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return "Product [type=" + type + ", numOfProducts=" + numOfProducts + ", price=" + price + "]";
	}

}
