package product;

import java.util.List;

public abstract class Product implements ProductCalculation {
	private int id;
	private String type;
	private double costRate, cost, price;
	private List<String> description;
	
	public Product() {
		
	}
	
	public Product(int id, String type, List<String> description, double costRate) {
		this.id = id;
		this.type = type;
		this.description = description;
		this.costRate = costRate;
	}
	
	public Product(double costRate) {
		this.costRate = costRate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getDescription() {
		return description;
	}

	public void setDescription(List<String> description) {
		this.description = description;
	}

	public double getCostRate() {
		return costRate;
	}

	public void setCostRate(double costRate) {
		this.costRate = costRate;
	}

	public double getCost() {
		costCalculation();
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public abstract void costCalculation();
	
	public abstract double priceCalculation(int quantity, double cost);
}