package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import repositories.SearchRepository;

public class SearchMenu {
	SearchRepository mainCall = new SearchRepository();
	List<SearchTable> listTables = new ArrayList<>();
	
	public SearchMenu() {
		
	}
	// Bikin Menu dengan switch-case dengan method yang ada di Search Repository
	public List<SearchTable> Menu(int choice) {
		Scanner keyboardSearch = new Scanner(System.in);
		boolean isNumber = false;
		int number = 0;
		String input = "", line = "+=======================================================================+";
			switch (choice) {
			case 1: // Menu Daftar Seluruh Product
				listTables = mainCall.printValueListProduct();
				//mainCall.printValueMapProduct();
				break;
			case 2: // Menu Cari Product Berdasarkan Tipe Product
				do {
					System.out.print("\nMasukkan Type Product : ");
					input = keyboardSearch.next();
					listTables = mainCall.searchValueListProduct(input);
				} while (listTables.isEmpty());
				/*do {
					System.out.print("\nMasukkan Type Product : ");
					input = keyboardSearch.next();
					listTables = mainCall.searchValueMapProduct(input);
				} while (listTables.size() <= 0);*/
				break;
			case 3: // Menu Cari Material Items Berdasarkan IsConsumable  
				do {
					System.out.print("\nMasukkan Material Items IsConsumable?\n\n0.False\n1.True\n> ");
					input = keyboardSearch.next();
					isNumber = validateNumber(input);
					if (isNumber) {
						number = Integer.parseInt(input);
						listTables = isConsumableFunction(number);
					}
				} while (!isNumber || number < 0 || number > 1);
				break;
			case 4: // Menu Cari Product Berdasarkan Deskripsi
				do {
					System.out.print("\nMasukkan Product Description : ");
					input = keyboardSearch.next();
					listTables = mainCall.searchProductDescription(input);
				} while (listTables.isEmpty());
				break;
			case 5: // Menu Cari Food And Beverage Items Berdasarkan Certification
				System.out.println("\nMasukkan Product Certification?\n\n1.Halal\n2.Tidak Halal");
				do {
					System.out.print("> ");
					input = keyboardSearch.next();
					isNumber = validateNumber(input);
					if (isNumber) {
						number = Integer.parseInt(input);
						listTables = isCertificationFunction(number);
					}
				} while (!isNumber || number < 1 || number > 2);
				break;
			case 6: // Menu Cari Garment Items Berdasarkan Size
				do {
					System.out.print("\nMasukkan Garment Size : ");
					input = keyboardSearch.next();
					listTables = mainCall.searchSizeGarments(input);
				} while (listTables.isEmpty());
				break;
			case 7: // Menu Cari Rata-rata seluruh Product
				double average = mainCall.averageProductionCost();
				System.out.println("\n" + line);
				System.out.printf("Average Production Cost Seluruh Product List = Rp.%,.2f\n", average);
				break;
			case 8: // Menu Cari Product yang dibawah rata-rata (7)
				listTables = mainCall.productionCostBelowAverage();
				break;
			case 9: // Menu Cari Transportation dan Telecommunication Services Berdasarkan Cost Calculation Type
			case 10:
				if (choice == 9) {
					System.out.println("\nMasukkan Cost Calculation Type Transportation?\n\n1.FixPerRoute\n2.PerMiles");
				}
				else if(choice == 10) {
					System.out.println("\nMasukkan Cost Calculation Type Telecommunication?\n\n1.CostPerSecond\n2.CostPerPacket");
				}
				do {
					System.out.print("> ");
					input = keyboardSearch.next();
					isNumber = validateNumber(input);
					if (isNumber) {
						number = Integer.parseInt(input);
						listTables = isServicesCostCalculationType(choice, number);
					}
				} while (!isNumber || number < 1 || number > 2);
				break;
			case 11: // Keluar
				break;
			}
			System.out.println(line + "\n");
			return listTables;
			
	}
	// Method untuk validasi angka
	public boolean validateNumber(String input) {
		boolean isNumber = false;
		if (input.matches("\\d*")) {
			isNumber = true;
		}
		else {
			System.out.println("Input yang dimasukkan bukan angka\nMasukkan pilihan anda lagi\n");
		}
		return isNumber;
	}
	// Method untuk validasi pilihan di menu (3) Cari Material Items Berdasarkan IsConsumable
	public List<SearchTable> isConsumableFunction(int number) {
		if (number == 1) {
			listTables = mainCall.searchMaterialConsumable(true);
		}
		else if (number == 0) {
			listTables = mainCall.searchMaterialConsumable(false);
		}
		else {
			System.out.println("Angka tidak ada di option\nMasukkan pilihan anda lagi\n");
		}
		return listTables;
	}
	// Method untuk validasi pilihan di menu (5) Cari Food And Beverage Items Berdasarkan Certificate
	public List<SearchTable> isCertificationFunction(int number) {
		if (number == 1) {
			listTables = mainCall.searchProductCertification("Halal");
		}
		else if (number == 2) {
			listTables = mainCall.searchProductCertification("Tidak Halal");
		}
		else {
			System.out.println("Angka tidak ada di option\nMasukkan pilihan anda lagi\n");
		}
		return listTables;
	}
	// Method untuk validasi pilihan di menu (9 dan 10) Cari Services Berdasarkan Cost Calculation Type
	public List<SearchTable> isServicesCostCalculationType(int choice, int number) {
		if (choice == 9 && number == 1) {
			listTables = mainCall.searchServicesCostCalculation(choice, "FixPerRoute");
		}
		else if (choice == 9 && number == 2) {
			listTables = mainCall.searchServicesCostCalculation(choice, "PerMiles");
		}
		else if (choice == 10 && number == 1) {
			listTables = mainCall.searchServicesCostCalculation(choice, "CostPerSecond");
		}
		else if (choice == 10 && number == 2) {
			listTables = mainCall.searchServicesCostCalculation(choice, "CostPerPacket");
		}
		else {
			System.out.println("Angka tidak ada di option\nMasukkan pilihan anda lagi\n");
		}
		return listTables;
	}
}