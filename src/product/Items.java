package product;

import java.util.List;

public abstract class Items extends Product {
	private String code;
	private String date, expireDate;
	private int unitOfStock;
	
	public Items() {

	}
	
	public Items(int id, String type, List<String> description, double costRate,
				 String code, String date, String expireDate, int unitOfStock) {
		super(id, type, description, costRate);
		this.code = code;
		this.date = date;
		this.expireDate = expireDate;
		this.unitOfStock = unitOfStock;
		setPrice(priceCalculation(unitOfStock, super.getCost()));
	}
	
	public Items(double costRate, int unitOfStock) {
		super(costRate);
		this.unitOfStock = unitOfStock;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	
	public int getUnitOfStock() {
		return unitOfStock;
	}

	public void setUnitOfStock(int unitOfStock) {
		this.unitOfStock = unitOfStock;
	}
	
	@Override
	public void costCalculation() {
		super.setCost((110 * super.getCostRate()) / 100.00);		 
	}
	
	@Override
	public double priceCalculation(int quantity, double cost) {
		double price = 0; 
		if (quantity <= 100) {
			price = (cost * 150) / 100;
		} else if (quantity > 100 && quantity <= 300) {
			price = (cost * 130) / 100;
		} else {
			price = (cost * 120) / 100;
		}
		return price;
	}
}