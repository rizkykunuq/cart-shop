package menu;

import java.util.ArrayList;
import java.util.List;

import product.FoodAndBeverageItems;
import product.GarmentItems;
import product.MaterialItems;
import product.Product;
import product.TelecommunicationServices;
import product.TransportationServices;

public class CartShop {
	List<SearchTable> cart = new ArrayList<>();
	private double totalPrice;
	
	public CartShop() {
		
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	// Method untuk cek nomor urutan di tampilan ada sesuai inputan user
	public boolean checkIdDisplay(List<SearchTable> listTables, int numberProduct) {
		boolean isFound = false;
		for (SearchTable list:listTables) {
			if (list.getIdTable() == numberProduct) {
				isFound = true;
			}
		}
		return isFound;
	}
	// Method untuk cek inputan quantity oleh user tidak melebihi quantity product yang dipilih
	public boolean checkEnoughQuantity(List<SearchTable> listTables, int numberProduct, int quantity) {
		boolean isCheck = false;
		for (SearchTable list:listTables) {
			if (list.getIdTable() == numberProduct) {
				if (quantity <= list.getQuantity()) {
					isCheck = true;
				}
			}
		}
		return isCheck;
	}
	// Method untuk cek inputan quantity oleh user ditambah quantity pada keranjang 
	// tidak melebihi quantity product yang dipilih
	public boolean checkNotOverQuantity(List<SearchTable> listTables, int numberProduct, int quantity) {
		int productId = 0;
		boolean isCheck = false;
		for (SearchTable table:listTables) {
			if (table.getIdTable() == numberProduct) {
				productId = table.getProductId();
				if (!cart.isEmpty()) {
					for (SearchTable list:cart) {
						if (list.getProductId() == productId) {
							quantity += list.getQuantity();
							isCheck = checkEnoughQuantity(listTables, numberProduct, quantity);
						}
						else {
							isCheck = true;
						}
					}
				}
				else {
					isCheck = cart.isEmpty();
				}
			}
		}
		return isCheck;
	}
	// Method untuk menambahkan Product yang dipilih user berdasarkan nomor urutan display 
	// ke dalam array list keranjang
	public List<SearchTable> menuCartShop(List<SearchTable> listTables, int numberProduct, int quantity) {
		double priceProduct = 0, subTotal = 0;
		for (SearchTable list:listTables) {
			if (list.getIdTable() == numberProduct) {
				// Panggil PriceCalculation berdasarkan Tipe Product yang dipilih
				// dengan buat object terlebih dahulu sesuai Tipe Product
				if (list.getProductType().equalsIgnoreCase("food") || 
						list.getProductType().equalsIgnoreCase("beverage")) {
					Product product = new FoodAndBeverageItems();
					priceProduct = product.priceCalculation(quantity, list.getCost());
				}
				else if (list.getProductType().equalsIgnoreCase("material")) {
					Product product = new MaterialItems();
					priceProduct = product.priceCalculation(quantity, list.getCost());
				}
				else if (list.getProductType().equalsIgnoreCase("garment")) {
					Product product = new GarmentItems();
					priceProduct = product.priceCalculation(quantity, list.getCost());
				}
				else if (list.getProductType().equalsIgnoreCase("transport")) { 
					Product product = new TransportationServices();
					priceProduct = product.priceCalculation(quantity, list.getCost());
				}
				else if (list.getProductType().equalsIgnoreCase("telecommunication")) {
					Product product = new TelecommunicationServices();
					priceProduct = product.priceCalculation(quantity, list.getCost());
				}
				cart.add(new SearchTable(list.getProductId(), list.getProductDescription(), 
						list.getProductType(), quantity, priceProduct, list.getCost()));
				// Hitung harga * jumlah lalu masukkan ke attribute jumlah harga
				subTotal = priceProduct * quantity;
				totalPrice += subTotal;
			}
		}
		return cart;
	}
	// Method untuk delete product pada menu Keranjang Belanja sesuai nomor urutan display
	public List<SearchTable> deleteProductInCart(List<SearchTable> listCart, int numberProduct) {
		int  i = 0;
		for (SearchTable list:listCart) {
			if (list.getIdTable() == numberProduct) {
				// Kurangi jumlah harga dengan sub total harga baris Keranjang Belanja yang dipilih
				totalPrice -= list.getPrice() * list.getQuantity();
				// Hapus array yang dipilih
				listCart.remove(i);
				// Break jika sudah ketemu
				break;
			}
			// Increment untuk mendapatkan index sesuai nomor urutan display yang dipilih
			i++;
		}
		return listCart;
	}
	// Method untuk menampilkan Keranjang Belanja dalam bentuk tabel
	public void printCart(List<SearchTable> cart) {
		String line = "+---+-------------------------+--------------------+--------+------------------+------------------+",
			   lineHeader = "+===+=========================+====================+========+==================+==================+",
			   lineBottom = "+------------------------------------------------------------------------------+------------------+";
		int index = 1;
		System.out.println(lineHeader);
		System.out.printf("|%3s|%25s|%20s|%8s|%18s|%18s|", 
					"No.", "Nama Product", "Tipe Product", "Quantity", "Price", "Subtotal Price");
		System.out.println("\n" + lineHeader);
		for (SearchTable list:cart) {
			list.setIdTable(index++);
			System.out.format("|%3d|%25s|%20s|%8d|Rp.%,15.2f|Rp.%,15.2f|", 
					list.getIdTable(), list.getProductName(), list.getProductType(), list.getQuantity(), 
					list.getPrice(), (list.getQuantity()*list.getPrice()));
			System.out.println("\n" + line);
		}
		System.out.format("|%78s|Rp.%,15.2f|", "Total Price", totalPrice);
		System.out.println("\n" + lineBottom + "\n");
	}
}