package product;

import java.util.List;

public class MaterialItems extends Items {
	private String materialType;
	private boolean isConsumable;
	
	public MaterialItems() {
		//System.out.println("Material Item Object Create");
	}
	
	public MaterialItems(int id, String type, List<String> description, double costRate,
						 String code, String date, String expireDate, int unitOfStock,
						 String materialType, boolean isConsumable) {
		super(id, type, description, costRate, code, date, expireDate, unitOfStock);
		this.materialType = materialType;
		this.isConsumable = isConsumable;
	}
	
	public MaterialItems(double costRate, int unitOfStock) {
		super(costRate, unitOfStock);
	}
	
	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public boolean getIsConsumable() {
		return isConsumable;
	}

	public void setConsumable(boolean isConsumable) {
		this.isConsumable = isConsumable;
	}
}