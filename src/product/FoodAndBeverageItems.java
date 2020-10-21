package product;

import java.util.List;

public class FoodAndBeverageItems extends Items {
	private String ingredients, certification;
	
	public FoodAndBeverageItems() {
		//System.out.println("Food and Beverage Item Object Create");
	}
	
	public FoodAndBeverageItems(int id, String type, List<String> description, float costRate,
								String code, String date, String expireDate, int unitOfStock,
								String ingredients, String certification) {
		super(id, type, description, costRate, code, date, expireDate, unitOfStock);
		this.ingredients = ingredients;
		this.certification = certification;
	}
	
	public FoodAndBeverageItems(double costRate, int unitOfStock) {
		super(costRate, unitOfStock);
	}
	
	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}
}