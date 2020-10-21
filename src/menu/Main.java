package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import product.Items;
import product.Product;
import product.Services;
import repositories.ProductRepository;

public class Main {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		SearchMenu search = new SearchMenu();
		CartShop cart = new CartShop();
		ProductRepository product = new ProductRepository();
		List<Product> productRepo = product.getValueListProduct();
		List<SearchTable> listTables = new ArrayList<>();
		List<SearchTable> listCart = new ArrayList<>();
		boolean isNumber = false, isCartYesOrNo = false, hasVerification = false,
				hasEnoughQuantity = false, isFoundProduct = false, isNumberProduct = false, 
				isNumberQuantity = false, isNotOverQuantity = true;
		int inputNumber = 0, subNumber = 0, numberProduct = 0, quantity = 0;
		double money = 0;
		String choice = "", choiceFillCart = "Y", input, choiceMoney = "",  
				line = "+=======================================================================+";
		// Set database duplikasi sesuai Repository
		search.mainCall.setProductList(productRepo);
		do {
			// Menu Utama
			System.out.println(line);
			System.out.println("|\t\t\tMenu Utama Toko Serba Murah\t\t\t|");
			System.out.println(line);
			System.out.println("| 1. Cari Product\t\t\t\t\t\t\t|");
			System.out.println("| 2. Keranjang Belanja\t\t\t\t\t\t\t|");
			System.out.println("| 3. Keluar\t\t\t\t\t\t\t\t|");
			System.out.println(line);
			do {
				System.out.print("> ");
				input = keyboard.next();
				// Validasi angka
				isNumber = search.validateNumber(input);
				if (isNumber) {
					inputNumber = Integer.parseInt(input);
					if (inputNumber < 1 || inputNumber > 3) {
						System.out.println("Angka tidak ada di option\nMasukkan pilihan anda lagi\n");
					}
				}
				// Ulang terus jika tidak angka atau angka bukan 1-3
			} while (!isNumber || inputNumber < 1 || inputNumber > 3);
			if (inputNumber == 1) {
				System.out.println();
				do {
					// Sub Menu Cari Product
					System.out.println(line);
					System.out.println("|\t\t\tMenu Cari Toko Serba Murah\t\t\t|");
					System.out.println(line);
					System.out.println("| 1.  Daftar Product\t\t\t\t\t\t\t|");
					System.out.println("| 2.  Cari Product Berdasarkan Tipe Product\t\t\t\t|");
					System.out.println("| 3.  Cari Material Items Berdasarkan IsConsumable\t\t\t|");
					System.out.println("| 4.  Cari Product Berdasarkan Description\t\t\t\t|");
					System.out.println("| 5.  Cari Food And Beverage Items Berdasarkan Certification\t\t|");
					System.out.println("| 6.  Cari Garment Items Berdasarkan Size\t\t\t\t|");
					System.out.println("| 7.  Cari Rata-rata Production Cost Semua Product Terdaftar\t\t|");
					System.out.println("| 8.  Cari Product yang dibawah rata-rata Production Cost\t\t|");
					System.out.println("| 9.  Cari Transportation Services Berdasarkan Cost Calculation Type\t|");
					System.out.println("| 10. Cari Telecommunication Services Berdasarkan Cost Calculation Type |");
					System.out.println("| 11. Keluar\t\t\t\t\t\t\t\t|");
					System.out.println(line);
					do {
						System.out.print("> ");
						input = keyboard.next();
						// Validasi angka
						isNumber = search.validateNumber(input);
						if (isNumber) {
							subNumber = Integer.parseInt(input);
							if (subNumber < 1 || subNumber > 11) {
								System.out.println("Angka tidak ada di option\nMasukkan pilihan anda lagi\n");
							}
						}
						// Ulangi terus jika bukan angka atau angka bukan 1-11
					} while (!isNumber || subNumber < 1 || subNumber > 11 );
					// Bersihkan array list agar saat search tidak ditemukan (array list kosong)
					// isi array list sebelumnya (ketika do-while masih berlanjut) tidak terbaca
					listTables.clear();
					// Pangiil method Menu pada SeacrhMenu
					listTables = search.Menu(subNumber);
					// Jika array list tidak kosong
					if (!listTables.isEmpty()) {
						do {
							// Menu isi keranjang pada pencarian product
							System.out.print("Isi keranjang belanja anda? (y/n)\t\t\t\t: ");
							choiceFillCart = keyboard.next();
							// Validasi huruf y atau n
							isCartYesOrNo = validateYesOrNo(choiceFillCart);
							// Jika opsi "Y" pada isi keranjang belanja anda, input nomor urut Product
							if (choiceFillCart.equalsIgnoreCase("Y")) {
								do { 
									System.out.print("Pilih sesuai nomor product pada tabel diatas\t\t\t: ");
									choice = keyboard.next();
									// Validasi angka
									isNumberProduct = search.validateNumber(choice);
									if (isNumberProduct) {
										numberProduct = Integer.parseInt(choice);
										isFoundProduct = cart.checkIdDisplay(listTables, numberProduct);
										// Jika inputan sesuai dengan nomor urut yang ada pada tabel
										if (isFoundProduct) {
											do {
												System.out.print("Masukkan jumlah product yang ingin dibeli\t\t\t: ");
												choice = keyboard.next();
												// Validasi angka
												isNumberQuantity = search.validateNumber(choice);
												if (isNumberQuantity) {
													quantity = Integer.parseInt(choice);
													hasEnoughQuantity= cart.checkEnoughQuantity(listTables, numberProduct, quantity);
													// Jika inputan tidak melebihi jumlah quantity Product pada tabel
													if (hasEnoughQuantity) {
														do {
															// Verifikasi untuk memasukkan Product ke Keranjang Belanja
															System.out.print("Anda yakin ingin memasukkan ke keranjang belanja anda? (y/n)\t: ");
															choice = keyboard.next();
															// Validasi huruf y atau n
															hasVerification = validateYesOrNo(choice);
															// Jika opsi "Y" pada isi keranjang belanja anda, cek jumlah product yang sama pada Keranjang Belanja
															if (choice.equalsIgnoreCase("Y")) {
																isNotOverQuantity = cart.checkNotOverQuantity(listTables, numberProduct, quantity);
																// Jika inputan ditambah quantity di keranjang belanja tidak melebihi jumlah quantity Product pada tabel
																if (isNotOverQuantity) {
																	// Masukkan product yang dipilih ke Keranjang Belanja
																	listCart = cart.menuCartShop(listTables, numberProduct, quantity);
																}
																// Jika inputan ditambah quantity di keranjang belanja melebihi jumlah quantity Product pada tabel
																else {
																	System.out.println("+=======================================+\n| Product ini telah melebihi quantity.\t|\n| Cek keranjang belanja anda.\t\t|\n+=======================================+");
																}
															}
															// Ulangi terus jika bukan huruf y atau n
														} while (!hasVerification);
													}
													// Jika inputan melebihi jumlah quantity Product pada tabel
													else {
														System.out.println("Jumlah product melebihi quantity yang ada.\nCek quantity pada tabel.\n");
													}
												} 
												// Ulangi terus jika bukan angka atau inputan melebihi quantiy Product 
											} while (!isNumberQuantity || !hasEnoughQuantity);
										}
										else {
											// Jika inputan tidak sesuai dengan nomor urut yang ada pada tabel
											System.out.println("Nomor product yang anda masukkan tidak ada pada tabel.\nMasukkan pilihan yang tersedia.\n");
										}
									}
									// Ulangi terus jika bukan angka atau inputan tidak sesuai dengan nomor urut pada tabel
								} while (!isNumberProduct || !isFoundProduct);
							}
							// Ulangi terus jika bukan huruf y atau n
						} while (!isCartYesOrNo);
						System.out.println("\n" + line + "\n");
					}
					// Ulangi terus jika bukan angka 11/Keluar
				} while (subNumber != 11);
			}
			else if (inputNumber == 2){
				// Menu Keranjang Belanja
				System.out.println();
				int numberSubCart = 0;
				do {
					// Jika Keranjang Belanja kosong
					if (listCart.isEmpty()) {
						System.out.println("+=======================================+\n|\t\t\t\t\t|\n| Keranjang Belanja anda kosong.\t|\n| Silahkan belanja di menu Cari Product.|\n|\t\t\t\t\t|\n+=======================================+\n");
						// Agar keluar dari do-while
						numberSubCart = 3;
					}
					else {
						System.out.println("\t\t\tKeranjang Belanja saat ini\n" + line);
						// Tampilkan Keranjang Belanja
						cart.printCart(listCart);
						System.out.println(line);
						// Sub Menu Keranjang Belanja 
						do {
							System.out.println("1. Check Out");
							System.out.println("2. Delete");
							System.out.println("3. Back");
							System.out.print("> ");
							choice = keyboard.next();
							// Validasi angka
							isNumber = search.validateNumber(choice);
							if (isNumber) {
								numberSubCart = Integer.parseInt(choice);
								if (numberSubCart < 1 || numberSubCart > 3) {
									System.out.println("Angka tidak ada di option\nMasukkan pilihan anda lagi\n");
								}
							}
							System.out.println(line);
							if (numberSubCart == 1) {
								// Sub Menu Check Out
								do {
									System.out.print("Anda ingin melanjutkan ke proses check out? (y/n)\t: ");
									choice = keyboard.next();
									// Validasi huruf y atau n
									hasVerification = validateYesOrNo(choice);
								// Ulangi terus jika bukan huruf y atau n
								} while (!hasVerification);
								if (choice.equalsIgnoreCase("Y")) {
									do {
										// Jika lanjut proses check out, input jumlah uang
										System.out.print("Masukkan jumlah uang anda\t\t\t\t: Rp.");
										choiceMoney = keyboard.next();
										// Validasi angka
										isNumber = search.validateNumber(choiceMoney);
										// Ulangi terus jika bukan angka
									} while (!isNumber);
									if (isNumber) {
										money = Integer.parseInt(choiceMoney);
										// Jika jumlah uang tidak kurang dari jumlah harga
										if (money >= cart.getTotalPrice()) {
											// Hitung uang kembalian
											money -= cart.getTotalPrice();
											System.out.printf("Uang kembalian anda\t\t\t\t\t: Rp.%,.2f", money);
											System.out.println();
											// Panggil method processCheckOut
											processCheckOut(listCart, search.mainCall.getProductList());
											// Hapus array list pada Main, CartShop dan SeacrhMenu
											cart.setTotalPrice(0);
											listCart.clear();
											listTables.clear();
											cart.cart.clear();
											search.listTables.clear();
										}
										// Jika jumlah uang kurang dari jumlah harga
										else {
											System.out.println("Uang anda tidak cukup untuk membayar total keranjang ini.");
										}
									}
								}
							}
							else if (numberSubCart == 2) {
								do {
									// Sub Menu Delete
									System.out.print("Pilih sesuai nomor product pada tabel diatas\t\t\t: ");
									choice = keyboard.next();
									// Validasi angka
									isNumberProduct = search.validateNumber(choice);
									if (isNumberProduct) {
										numberProduct = Integer.parseInt(choice);
										isFoundProduct = cart.checkIdDisplay(listCart, numberProduct);
										// Jika inputan sesuai dengan nomor urut Product pada tabel
										if (isFoundProduct) {
											do {
												System.out.print("Anda yakin ingin menghapus dari keranjang belanja anda? (y/n)\t: ");
												choice = keyboard.next();
												// Validasi huruf y atau n
												hasVerification = validateYesOrNo(choice);
												// Jika opsi "Y" panggil method deleteProductInCart pada CartShop
												// dan terima array list yang sudah update
												if (choice.equalsIgnoreCase("Y")) {
													listCart = cart.deleteProductInCart(listCart, numberProduct);
												}
											// Ulangi terus jika bukan huruf y atau n
											} while (!hasVerification);
										}
										// Jika inputan tidak sesuai dengan nomor urut Product pada tabel
										else {
											System.out.println("Nomor product yang anda masukkan tidak ada pada tabel.\nMasukkan pilihan yang tersedia.\n");
										}
									} 
								// Ulangi terus jika bukan angka atau inputan tidak sesuai dengan nomor urut Product pada tabel
								} while (!isNumberProduct || !isFoundProduct);
							}
							
						// Ulangi terus jika bukan angka atau bukan angka 1-3 
						} while (!isNumber || numberSubCart < 1 || numberSubCart > 3);
						System.out.println(line + "\n");
					}
				// Ulangi terus jika bukan angka 3 pada Menu Sub Keranjang Belanja
				} while (numberSubCart != 3);
			}
		// Ualngi terus jika bukan angka pada Menu Utama
		} while(inputNumber != 3);
		// Tutup Scanner
		keyboard.close();
	}
	// Method validasi huruf y atau n
	public static boolean validateYesOrNo(String choice) {
		boolean isYesOrNo = false;
		if (choice.equalsIgnoreCase("N") || choice.equalsIgnoreCase("Y")) {
			isYesOrNo = true;
		}
		else {
			System.out.println("Masukkan pilihan yang tersedia.\n");
		}
		return isYesOrNo;
	}
	// Method untuk check out pada Keranjang Belanja
	public static void processCheckOut(List<SearchTable> cart, List<Product> product) {
		List<Product> productList = product;
		int quantityUpdate = 0;
		double priceUpdate = 0;
		for (SearchTable list:cart) {
			for (Product listProduct:productList) {
				// Jika ID Product pada cart sama dengan duplikasi Repo di SearchRepository
				if (list.getProductId() == listProduct.getId()) {
					// Jika memiliki sub class Items update quantity/unit of stock dan price
					if (listProduct instanceof Items) {
						quantityUpdate = ((Items) listProduct).getUnitOfStock();
						quantityUpdate -= list.getQuantity();
						((Items) listProduct).setUnitOfStock(quantityUpdate);
						priceUpdate = listProduct.priceCalculation(((Items) listProduct).getUnitOfStock(), 
								listProduct.getCost());
						listProduct.setPrice(priceUpdate);
					}
					// Jika memiliki sub class Services update quantity/user usage dan price
					else if (listProduct instanceof Services) {
						quantityUpdate = ((Services) listProduct).getUserUsage();
						quantityUpdate -= list.getQuantity();
						((Services) listProduct).setUserUsage(quantityUpdate);
						priceUpdate = listProduct.priceCalculation(((Services) listProduct).getUserUsage(), 
								listProduct.getCost());
						listProduct.setPrice(priceUpdate);
					}
				}
			}
		}
	}
}