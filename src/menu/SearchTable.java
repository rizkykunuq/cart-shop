package menu;

import java.util.List;

public class SearchTable {
	private String productName, productType;
	private int productId, idTable, quantity;
	private double price, cost;
	private List<SearchTable> table;
	private List<String> productDescription;
	
	public SearchTable() {
		
	}
	
	public SearchTable(int productId, List<String> productDescription, String productType,
					int quantity, double price, double cost) {
		this.productId = productId;
		this.productDescription = productDescription;
		this.productType = productType;
		this.quantity = quantity;
		this.price = price;
		this.cost = cost;
		setProductName(getProductDescription().get(0));
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getIdTable() {
		return idTable;
	}

	public void setIdTable(int idTable) {
		this.idTable = idTable;
	}

	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductType() {
		return productType;
	}
	
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	public List<String> getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(List<String> productDescription) {
		this.productDescription = productDescription;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public List<SearchTable> getTable() {
		return table;
	}

	public void setTable(List<SearchTable> table) {
		this.table = table;
	}
	// Method untuk menampilkan method-method pencarian dalam bentuk tabel
	public void printTable(List<SearchTable> table) {
		String line = "+---+-------------------------+--------------------+--------+------------------+",
				lineHeader = "+===+=========================+====================+========+==================+";
		int index = 1;
		System.out.println(lineHeader);
		System.out.printf("|%3s|%25s|%20s|%8s|%18s|", "No.", "Nama Product", "Tipe Product", "Quantity", "Price");
		System.out.println("\n" + lineHeader);
		for (SearchTable list:table) {
			list.setIdTable(index++);
			System.out.format("|%3d|%25s|%20s|%8d|Rp.%,15.2f|", 
					list.getIdTable(), list.getProductName(), list.getProductType(), list.getQuantity(), list.getPrice());
			System.out.println("\n" + line);
		}
	}
}