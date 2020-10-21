package repositories;

import java.util.ArrayList;
import java.util.List;
//import java.util.Map;

import menu.SearchTable;
import product.FoodAndBeverageItems;
import product.GarmentItems;
import product.Items;
import product.MaterialItems;
import product.Product;
import product.Services;
import product.TelecommunicationServices;
import product.TransportationServices;

public class SearchRepository {
	String line = "+=======================================================================+";
	SearchTable table = new SearchTable();
	//Map<String, Product> productMap = product.getValueMapProduct();
	List<Product> productList;
	
	public List<Product> getProductList() {
		return productList;
	}
	
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	public SearchRepository() {
		
	}
	// Cetak ArrayList productList 
	public List<SearchTable> printValueListProduct() {
		List<SearchTable> tableFormat = new ArrayList<>();
		System.out.println(line);
		for (Product list:getProductList()) {
			if (list instanceof Items) {
				tableFormat.add(new SearchTable(list.getId(), list.getDescription(), list.getType(), 
								((Items) list).getUnitOfStock(), list.getPrice(), list.getCost()));
			}
			else if (list instanceof Services) {
				tableFormat.add(new SearchTable(list.getId(), list.getDescription(), list.getType(), 
								((Services) list).getUserUsage(), list.getPrice(), list.getCost()));
			}
		}
		table.setTable(tableFormat);
		table.printTable(tableFormat);
		System.out.println(line);
		System.out.println("End List");
		return tableFormat;
	}
	// Cetak HashMap productMap
	/*public List<RowTable> printValueMapProduct() {
		List<RowTable> tableFormat = new ArrayList<>();
		System.out.println(line);
		for (Map.Entry<String, Product> entry : productMap.entrySet()) {
			Product p = entry.getValue();
			if (p instanceof Items) {
				tableFormat.add(new RowTable(p.getId(), p.getDescription(), p.getType(), 
							((Items) p).getUnitOfStock(), p.getPrice(). p.getCost());
			}
			else if (p instanceof Services) {
				tableFormat.add(new RowTable(p.getId(), p.getDescription(), p.getType(), 
							((Services) p).getUserUsage(), p.getPrice(), p.getCost()));
			}
		}
		table.setTable(tableFormat);
		table.printTable(tableFormat);
		System.out.println(line);
		System.out.println("End Map");
		return tableFormat;
	}*/
	// Cari Produk berdasarkan Tipe Product di ArrayList 
	public List<SearchTable> searchValueListProduct(String type) {
		List<SearchTable> tableFormat = new ArrayList<>();
		ArrayList<String> productName = new ArrayList<>();
		System.out.println(line);
		// Cek ArrayList jika Tipe Produk sama dengan inputan dan simpan Nama Produknya di ArrayList baru
		for (Product list:getProductList()) {
			if (list.getType().equalsIgnoreCase(type)) {
				if (list instanceof Items) {
					tableFormat.add(new SearchTable(list.getId(), list.getDescription(), list.getType(), 
									((Items) list).getUnitOfStock(), list.getPrice(), list.getCost()));
				}
				else if (list instanceof Services) {
					tableFormat.add(new SearchTable(list.getId(), list.getDescription(), list.getType(), 
									((Services) list).getUserUsage(), list.getPrice(), list.getCost()));
				}
			}
		}
		System.out.println("Search Product Dengan Product List\n" + line);
		// Jika Tipe Produk yang dicari ada
		if (!tableFormat.isEmpty()) {
			table.setTable(tableFormat);
			table.printTable(tableFormat);
		}
		else {
			// Kasih rekomendasi Tipe Produk sesuai inputan yang dimasukkan
			for(Product list:getProductList()) {
				int count = 0;
				if (list.getType().toLowerCase().contains(type.toLowerCase())) {
					// Cek ArrayList jika ada Tipe Produk yang sama sudah tersimpan
					for (String name:productName) {
						if (list.getType().equals(name)) {
							count++;
						}
					}
					if (count == 0) {
						productName.add(list.getType());
					}
				}
			}
			System.out.println("Product Type \"" + type + "\" yang anda cari tidak ditemukan.");
			System.out.print("Recommend Search dari yang diinputkan : ");
			printArrayList(productName);
			System.out.println("\nMasukkan pilihan anda lagi\n" + line);
		}
		return tableFormat;
	}
	// Cek Produk berdasarkan Tipe Produk di HashMap
	/*public List<RowTable> searchValueMapProduct(String type) {
		List<RowTable> tableFormat = new ArrayList<>();
		ArrayList<String> productName = new ArrayList<>();
		System.out.println(line);
		// Cek HashMap jika Tipe Produk sama dengan inputan dan simpan Nama Produknya di ArrayList baru
		for (Map.Entry<String, Product> entry : productMap.entrySet()) {
			Product p = entry.getValue();
			if (p.getType().equalsIgnoreCase(type)) {
				if (p instanceof Items) {
					tableFormat.add(new RowTable(p.getId(), p.getDescription(), p.getType(), 
								((Items) p).getUnitOfStock(), p.getPrice(), p.getCost());
				}
				else if (p instanceof Services) {
					tableFormat.add(new RowTable(p.getId(), p.getDescription(), p.getType(), 
								((Services) p).getUserUsage(), p.getPrice(), p.getCost()));
				}
			}
		}
		System.out.println("Search Product Dengan Product Map\n" + line);
		// Jika Tipe Produk yang dicari ada 
		if (tableFormat.size() > 0) {
			table.setTable(tableFormat);
			table.printTable(tableFormat);
		}
		else {
			// Kasih rekomendasi Tipe Produk sesuai inputan yang dimasukkan
			for (Map.Entry<String, Product> entry : productMap.entrySet()) {
				Product p = entry.getValue();
				int count = 0;
				if (p.getType().toLowerCase().contains(type.toLowerCase())) {
					// Cek ArrayList jika ada Tipe Produk yang sama sudah tersimpan
					for (String name:productName) {
						if (p.getType().equals(name)) {
							count++;
						}
					}
					// Jika belum ada masukkan ke ArrayList
					if (count == 0) {
						productName.add(p.getType());
					}
				}
			}
			System.out.println("Product Type \"" + type + "\" yang anda cari tidak ditemukan.");
			System.out.print("Recommend Search dari yang diinputkan : ");
			printArrayList(productName);
			System.out.println("\nMasukkan pilihan anda lagi\n" + line);
		}
		return tableFormat;
	}*/
	// Cari Material Items berdasarkan IsConsumable
	public List<SearchTable> searchMaterialConsumable(boolean consumable) {
		List<SearchTable> tableFormat = new ArrayList<>();
		String type = "Material";
		System.out.println(line);
		for(Product list:getProductList()) {
			// Cek MaterialItems sub class dari Product
			if (list instanceof MaterialItems) {
				// Cek ArrayList jika Material dan Cek IsConsumable sesuai inputan 
				// simpan Nama Produknya di ArrayList baru
				if (list.getType().equalsIgnoreCase(type)) {
					if (consumable == ((MaterialItems) list).getIsConsumable()) {
						tableFormat.add(new SearchTable(list.getId(), list.getDescription(), list.getType(), 
									((MaterialItems) list).getUnitOfStock(), list.getPrice(), list.getCost()));
					}	
				}
			}
		}
		System.out.println("Search Product Type \"" + type + "\" dan " + 
							((consumable == true) ? "Is Consumable" : "Is Not Consumable") + 
							" Dengan Product List\n" + line);
		// Jika Material Items ada
		if (!tableFormat.isEmpty()) {
			table.setTable(tableFormat);
			table.printTable(tableFormat);
		}
		else {
			System.out.println("Product \"" + type + "\" yang \"" + 
							((consumable == true) ? "Is Consumable" : "Is Not Consumable") + 
							"\" tidak ditemukan.");
		}
		return tableFormat;
	}
	// Cek Produk berdasarkan Deskripsi Produk
	public List<SearchTable> searchProductDescription(String description) {
		List<SearchTable> tableFormat = new ArrayList<>();
		ArrayList<String> productName = new ArrayList<>();
		System.out.println(line);
		// Cek productList dan cek Deskripsi Produk jika sesuai inputan 
		// simpan Nama Produknya di ArrayList baru
		for (Product list:getProductList()) {
			for (int i = 0; i < list.getDescription().size(); i++) {
				if (list.getDescription().get(i).equalsIgnoreCase(description)) {
					if (list instanceof Items) {
						tableFormat.add(new SearchTable(list.getId(), list.getDescription(), list.getType(), 
									((Items) list).getUnitOfStock(), list.getPrice(), list.getCost()));
					}
					else if (list instanceof Services) {
						tableFormat.add(new SearchTable(list.getId(), list.getDescription(), list.getType(), 
									((Services) list).getUserUsage(), list.getPrice(), list.getCost()));
					}
				}
			}
		}
		System.out.println("Search Product Description \"" + description + "\" Dengan Product List\n" + line);
		// Jika Deskripsi Produk ada
		if (!tableFormat.isEmpty()) {
			table.setTable(tableFormat);
			table.printTable(tableFormat);
		}
		else {
			// Kasih rekomendasi Deskripsi Produk sesuai inputan yang dimasukkan
			for(Product list:getProductList()) {
				int count = 0;
				for (int i = 0; i < list.getDescription().size(); i++) {
					if (list.getDescription().get(i).toLowerCase().contains(description.toLowerCase())) {
						// Cek ArrayList jika ada Deskripsi Produk yang sama sudah tersimpan
						for (String name:productName) {
							if (list.getDescription().get(i).equals(name)) {
								count++;
							}
						}
						// Jika belum ada masukkan ke ArrayList
						if (count == 0) {
							productName.add(list.getDescription().get(i));
						}
					}
				}
			}
			System.out.println("Product dengan description \"" + description + 
							"\" yang anda cari tidak ada.");
			System.out.print("Recommend Search dari yang diinputkan : ");
			printArrayList(productName);
			System.out.println("\nMasukkan pilihan anda lagi\n" + line);
		}
		return tableFormat;
	}
	// Cek Food And Beverage Items berdasarkan Certification
	public List<SearchTable> searchProductCertification(String certification) {
		List<SearchTable> tableFormat = new ArrayList<>();
		System.out.println(line);
		for (Product list:getProductList()) {
			// Cek FoodAndBeverageItems sub class dari Product
			if (list instanceof FoodAndBeverageItems) {
				// Cek ArrayList jika Certification sesuai inputan 
				// simpan Nama Produknya di ArrayList baru
				if (((FoodAndBeverageItems) list).getCertification().equalsIgnoreCase(certification)) {
					tableFormat.add(new SearchTable(list.getId(), list.getDescription(), list.getType(), 
								((FoodAndBeverageItems) list).getUnitOfStock(), list.getPrice(), list.getCost()));
				}
			}
		}
		System.out.println("Search Food And Beverage Product Certification \"" + certification + 
						"\" Dengan Product List\n" + line);
		// Jika Certification yang dicari ada
		if (!tableFormat.isEmpty()) {
			table.setTable(tableFormat);
			table.printTable(tableFormat);
		}
		else {
			System.out.println("Product dengan certification \"" + certification + 
							"\" yang anda cari tidak ada.");
		}
		return tableFormat;
	}
	// Cek Garments Items berdasarkan Size
	public List<SearchTable> searchSizeGarments(String size) {
		List<SearchTable> tableFormat = new ArrayList<>();
		ArrayList<String> sizeList = new ArrayList<>();
		System.out.println(line);
		for (Product list:getProductList()) {
			// Cek GarmentItems sub class dari Product
			if (list instanceof GarmentItems) {
				for (int i = 0; i < ((GarmentItems) list).getSize().size(); i++) {
					// Cek ArrayList jika Size sesuai inputan 
					// simpan Nama Produknya di ArrayList baru
					if (((GarmentItems) list).getSize().get(i).equalsIgnoreCase(size)) {
						tableFormat.add(new SearchTable(list.getId(), list.getDescription(), list.getType(), 
									((GarmentItems) list).getUnitOfStock(), list.getPrice(), list.getCost()));
					}
				}
			}
		}
		System.out.println("Search Garment Size \"" + size + "\" Dengan Product List\n" + line);
		// Jika Size yang dicari ada
		if (!tableFormat.isEmpty()) {
			table.setTable(tableFormat);
			table.printTable(tableFormat);
		}
		else {
			// Kasih rekomendasi sesuai inputan yang dimasukkan
			for(Product list:getProductList()) {
				// Cek GarmentItems sub class dari Product
				if (list instanceof GarmentItems) {
					for (int i = 0; i < ((GarmentItems) list).getSize().size(); i++) {
						int count = 0;
						if (((GarmentItems) list).getSize().get(i).toLowerCase().contains(size.toLowerCase())) {
							// Cek ArrayList jika ada Size yang sama sudah tersimpan
							for (String checkSize:sizeList) {
								if (((GarmentItems) list).getSize().get(i).equals(checkSize)) {
									count++;
								}
							}
							// Jika belum ada masukkan ke ArrayList
							if (count == 0) {
								sizeList.add(((GarmentItems) list).getSize().get(i));
							}
						}
					}
				}
			}
			System.out.println("Garment Items dengan size \"" + size + 
					"\" yang anda cari tidak ada.");
			System.out.print("Recommend Search dari yang diinputkan : ");
			printArrayList(sizeList);
			System.out.println("\nMasukkan pilihan anda lagi\n" + line);
		}
		return tableFormat;
	}
	// Cek Rata-rata Production Cost seluruh Product
	public double averageProductionCost() {
		double sumProductionCost = 0;
		for (Product list:getProductList()) {
			sumProductionCost += list.getCost();
		}
		return (sumProductionCost/getProductList().size());
	}
	// Cek Product yang Production Cost dibawah rata-rata Production Cost
	public List<SearchTable> productionCostBelowAverage() {
		List<SearchTable> tableFormat = new ArrayList<>();
		// Ambil nilai dari method cek rata-rata
		double averageProductionCost = averageProductionCost();
		System.out.println(line);
		for (Product list:getProductList()) {
			if (list.getCost() < averageProductionCost) {
				// Cek ArrayList jika Production Cost sebuah rata-rata 
				// simpan Nama Produknya di ArrayList baru
				if (list instanceof Items) {
					tableFormat.add(new SearchTable(list.getId(), list.getDescription(), list.getType(), 
								((Items) list).getUnitOfStock(), list.getPrice(), list.getCost()));
				}
				else if (list instanceof Services) {
					tableFormat.add(new SearchTable(list.getId(), list.getDescription(), list.getType(), 
								((Services) list).getUserUsage(), list.getPrice(), list.getCost()));
				}
			}
		}
		System.out.printf("Product dengan Production Cost dibawah Rata-rata Rp.%,.2f", averageProductionCost);
		System.out.println("\n" + line);
		table.setTable(tableFormat);
		table.printTable(tableFormat);
		
		return tableFormat;
	}
	// Cek Services berdasarkan Cost Calculation Type
	public List<SearchTable> searchServicesCostCalculation(int service, String typeCost) {
		List<SearchTable> tableFormat = new ArrayList<>();
		System.out.println(line);
		for (Product list:getProductList()) {
			if (service == 9) {
				if (list instanceof TransportationServices) {
					// Cek ArrayList jika service Transportation cocokkan dengan Cost Calculation Type nya
					// lalu simpan Nama Produknya di ArrayList baru
					if (((TransportationServices) list).getTypeCost().equalsIgnoreCase(typeCost)) {
							tableFormat.add(new SearchTable(list.getId(), list.getDescription(), list.getType(), 
								((TransportationServices) list).getUserUsage(), list.getPrice(), list.getCost()));
					}
				}
			}
			else if (service == 10) {
				if (list instanceof TelecommunicationServices) {
					// Cek ArrayList jika service Telecommunication cocokkan dengan Cost Calculation Type nya
					// lalu simpan Nama Produknya di ArrayList baru
					if (((TelecommunicationServices) list).getTypeCost().equalsIgnoreCase(typeCost)) {
						tableFormat.add(new SearchTable(list.getId(), list.getDescription(), list.getType(), 
								((TelecommunicationServices) list).getUserUsage(), list.getPrice(), list.getCost()));
					}
				}
			}
		}
		System.out.println("Search \"" + ((service == 9) ? "Transportation" : "") + 
						((service == 10) ? "Telecommunication" : "") + 
						"\" Services berdasarkan Cost Calculation Type \"" + typeCost + 
						"\" Dengan Product List\n" + line);
		// Jika Services yang dicari ada
		if (!tableFormat.isEmpty()) {
			table.setTable(tableFormat);
			table.printTable(tableFormat);
		}
		else {
			System.out.println("Product \"" + ((service == 9) ? "Transportation" : "") + 
							((service == 10) ? "Telecommunication" : "") + 
							"\" Services dengan Cost Calculation Type \"" + typeCost + 
							"\" yang anda cari tidak ada.");
		}
		return tableFormat;
	}
	// Method untuk memprint array list dalam satu baris dengan titik di akhir
	public void printArrayList(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size()-1) {
				System.out.print(list.get(i) + ".");
			}
			else {
				System.out.print(list.get(i) + ", ");
			}
		}
	}
}