package product;

import java.util.List;

public class GarmentItems extends Items {
	private String garmentType, fabrics, color;
	private int ageGroup;
	private List<String> size;
	
	public GarmentItems() {
		//System.out.println("Garment Item Object Create");
	}
	
	public GarmentItems(int id, String type, List<String> description, double costRate,
						String code, String date, String expireDate, int unitOfStock,
						String garmentType, String fabrics, String color, List<String> size, int ageGroup) {
		super(id, type, description, costRate, code, date, expireDate, unitOfStock);
		this.garmentType = garmentType;
		this.fabrics = fabrics;
		this.color = color;
		this.size = size;
		this.ageGroup = ageGroup;
	}
	
	public GarmentItems(double costRate, int unitOfStock) {
		super(costRate, unitOfStock);
	}
	
	public String getGarmentType() {
		return garmentType;
	}

	public void setGarmentType(String garmentType) {
		this.garmentType = garmentType;
	}

	public String getFabrics() {
		return fabrics;
	}

	public void setFabrics(String fabrics) {
		this.fabrics = fabrics;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<String> getSize() {
		return size;
	}

	public void setSize(List<String> size) {
		this.size = size;
	}

	public int getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(int ageGroup) {
		this.ageGroup = ageGroup;
	}
}