
public class Furniture {
	String type, color;
	Material material;
	double height, width, cost;
	
	public Furniture(String type, String color, Material material, double height, double width, double cost) {
		this.type = type;
		this.color = color;
		this.material = material;
		this.height = height;
		this.width = width;
		this.cost = cost;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Furniture [type=" + type + ", color=" + color + ", material="
				+ material + ", height=" + height + ", width=" + width
				+ ", cost=" + cost + "]";
	}
}
