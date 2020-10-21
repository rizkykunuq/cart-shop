package product;

import java.util.List;

public abstract class Services extends Product {
	private String typeCost;
	private int userUsage;
	
	public Services() {
	
	}
	
	public Services(int id, String type, List<String> description, double costRate, 
					String typeCost, int userUsage) {
		super(id, type, description, costRate);
		this.typeCost = typeCost;
		this.userUsage = userUsage;
	}
	
	public Services(double costRate, int userUsage) {
		super(costRate);
		this.userUsage = userUsage;
	}

	public String getTypeCost() {
		return typeCost;
	}
	
	public void setTypeCost(String typeCost) {
		this.typeCost = typeCost;
	}
	
	public int getUserUsage() {
		return userUsage;
	}

	public void setUserUsage(int userUsage) {
		this.userUsage = userUsage;
	}

	@Override
	public abstract void costCalculation();
	
	@Override
	public double priceCalculation(int quantity, double cost) {
		double price = 0;
		if (quantity <= 200) {
			price = (cost * 120) / 100;
		} else if (quantity > 200 && quantity <= 500) {
			price = (cost * 130) / 100;
		} else {
			price = (cost * 150) / 100;
		}
		return price;
	}
}