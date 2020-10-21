package repositories;

import java.util.*;

import product.FoodAndBeverageItems;
import product.GarmentItems;
import product.MaterialItems;
import product.Product;
import product.TelecommunicationServices;
import product.TransportationServices;

public class ProductRepository {
	private List<Product> productList;
	private Map<String, Product> mapList;
	
	Product bengbeng = new FoodAndBeverageItems(1001, "food", 
			Arrays.asList("Beng beng", "chocolate", "caramel", "crispy", "wafer"), 
			1300, "F001S", "13/07/2020", "13/07/2025", 1000, 
			"sugar, palm oil, wheat flour, glucose, cocoa liquor, milk powder", "halal");
	Product kentuckyfriedchicken = new FoodAndBeverageItems(1002, "food", 
			Arrays.asList("Ayam KFC", "crispy", "tasteful", "juicy"), 
			6100, "F002FF", "13/07/2020", "20/07/2020", 300, 
			"chicken, paprika, white pepper, garlic salt", "halal");
	Product bigmac = new FoodAndBeverageItems(1003, "food", 
			Arrays.asList("Bigmac", "big", "juicy", "creamy"), 
			22000, "F003FF", "13/07/2020", "20/07/2020", 100, 
			"beef, bread, lettuce, pickles, onions, creamy sauce", "halal");
	Product aqua = new FoodAndBeverageItems(1004, "beverage", 
			Arrays.asList("Aqua", "fresh", "purest", "nature", "clear"), 
			3700, "F004D", "13/07/2020", "13/07/2025", 550, 
			"water, calsium, magnesium, natrium", "halal");
	Product ichitanmilktea = new FoodAndBeverageItems(1005, "beverage", 
			Arrays.asList("Ichitan Milk Tea", "sweet", "fresh"), 
			4600, "F005D", "13/07/2020", "20/07/2020", 330, 
			"water, sugar, salt, milk powder, vegetable creamer, tea extract", "halal");
	
	Product citybasetee = new GarmentItems(2001, "garment", Arrays.asList("City Base Tee", "man"), 
			243000, "G001C","13/07/2020", "13/07/2025", 500, "clothes", "recycled polyeste", 
			"white, multicolor", Arrays.asList("s", "m", "l", "xl"), 4);
	Product flanelshirt = new GarmentItems(2002, "garment", Arrays.asList("Flanel", "man"), 
			152000, "G002SH", "13/07/2020", "13/07/2025", 300, "shirt", "cotton flanel", 
			"yellow, blue, red, white, grey, black", Arrays.asList("s", "m", "l", "xl", "xxl"), 4);
	Product leecooperbaby = new GarmentItems(2003, "garment", Arrays.asList("Lee Cooper", "baby"), 
			98000, "G003B", "13/07/2020", "13/07/2025", 50, "blouse", "cotton", "white", 
			Arrays.asList("s", "m", "l", "xl"), 1);
	Product cargojoggers = new GarmentItems(2004, "garment", Arrays.asList("Cargo Joggers", "man"), 
			122000, "G004C", "13/07/2020", "13/07/2025", 200, "pants", "cotton", "black, beige, green", 
			Arrays.asList("s", "m", "l", "xl"), 4);
	Product jiripleated = new GarmentItems(2005, "garment", Arrays.asList("Jiri Pleated", "woman"), 
			140000, "G005SK", "13/07/2020", "13/07/2025", 250, "skirt", "corduroy", "brown", 
			Arrays.asList("s", "m", "l", "xl"), 4);
	
	Product batubata = new MaterialItems(3001, "material", 
			Arrays.asList("Batu Bata", "tanah liat", "per lusin"), 
			5500, "M001B", "13/07/2020", "13/07/2025", 2000, "bangunan", false);
	Product semen = new MaterialItems(3002, "material", 
			Arrays.asList("Semen", "kapur", "per karung"), 
			42500, "M002B", "13/07/2020", "13/07/2025", 100, "bangunan", false);
	Product pasir = new MaterialItems(3003, "material", 
			Arrays.asList("Pasir", "butiran", "per box"), 
			122000, "M003B", "13/07/2020", "13/07/2025", 10, "bangunan", false);
	Product kusen = new MaterialItems(3004, "material", 
			Arrays.asList("Kusen", "kayu"), 
			534000, "M004B", "13/07/2020", "13/07/2025", 15, "bangunan", false);
	Product atap = new MaterialItems(3005, "material", 
			Arrays.asList("Atap", "spandek"), 
			30400, "M005B", "13/07/2020", "13/07/2025", 100, "bangunan", false);

	Product angkutanbiru = new TransportationServices(4001, "transport", 
			Arrays.asList("Angkutan Biru", "biru", "massal"), 3500, 
			"FixPerRoute", 100, "sedan", "jati-pasar", 4);
	Product angkutanmerah = new TransportationServices(4002, "transport", 
			Arrays.asList("Angkutan Merah", "putih", "massal"), 5000, 
			"FixPerRoute", 50, "sedan", "belimbing-pasar", 10);
	Product gojek = new TransportationServices(4003, "transport", 
			Arrays.asList("Gojek", "hijau"), 11800, 
			"PerMiles", 250, "motor", "padang", 1);
	Product gocar = new TransportationServices(4004, "transport", 
			Arrays.asList("Gocar", "hijau"), 15000, 
			"PerMiles", 150, "mpv", "padang", 1);
	Product angkutanbus = new TransportationServices(4005, "transport", 
			Arrays.asList("Angkutan Bus", "utama", "massal"), 3500, 
			"FixPerRoute", 150, "bus", "pasar-tabing", 5);
	
	Product telkomsel = new TelecommunicationServices(5001, "telecommunication", 
			Arrays.asList("Telkomsel", "mobile"), 2800, "CostPerSecond", 250, "", 30, 30);
	Product three = new TelecommunicationServices(5002, "telecommunication", 
			Arrays.asList("Three", "mobile"), 2400, "CostPerPacket", 200, "Data", 30, 30);
	Product xl = new TelecommunicationServices(5003, "telecommunication", 
			Arrays.asList("XL", "mobile"), 2400, "CostPerPacket", 150, "Data", 30, 30);
	Product biznet = new TelecommunicationServices(5004, "telecommunication", 
			Arrays.asList("Biznet", "home", "office"), 8400, "CostPerSecond", 220, "", 30, 30);
	Product indihome = new TelecommunicationServices(5005, "telecommunication", 
			Arrays.asList("Indihome", "home", "office"), 13900, "CostPerPacket", 500, "Default", 30, 30);
	
	public ProductRepository() {
		
	}
	
	public List<Product> getValueListProduct() {
		productList = new ArrayList<Product>();
		
		productList.add(bengbeng);
		productList.add(kentuckyfriedchicken);
		productList.add(bigmac);
		productList.add(aqua);
		productList.add(ichitanmilktea);
		
		productList.add(citybasetee);
		productList.add(flanelshirt);
		productList.add(leecooperbaby);
		productList.add(cargojoggers);
		productList.add(jiripleated);
		
		productList.add(batubata);
		productList.add(pasir);
		productList.add(semen);
		productList.add(kusen);
		productList.add(atap);
		
		productList.add(angkutanbiru);
		productList.add(angkutanmerah);
		productList.add(gojek);
		productList.add(gocar);
		productList.add(angkutanbus);
		
		productList.add(telkomsel);
		productList.add(three);
		productList.add(xl);
		productList.add(biznet);
		productList.add(indihome);
		
		return productList;
	}

	public Map<String, Product> getValueMapProduct( ) {
		mapList = new HashMap<String, Product>();
		
		mapList.put(bengbeng.getDescription().get(0), bengbeng);
		mapList.put(kentuckyfriedchicken.getDescription().get(0), kentuckyfriedchicken);
		mapList.put(bigmac.getDescription().get(0), bigmac);
		mapList.put(aqua.getDescription().get(0), aqua);
		mapList.put(ichitanmilktea.getDescription().get(0), ichitanmilktea);
		
		mapList.put(citybasetee.getDescription().get(0), citybasetee);
		mapList.put(flanelshirt.getDescription().get(0), flanelshirt);
		mapList.put(leecooperbaby.getDescription().get(0), leecooperbaby);
		mapList.put(cargojoggers.getDescription().get(0), cargojoggers);
		mapList.put(jiripleated.getDescription().get(0), jiripleated);
		
		mapList.put(batubata.getDescription().get(0), batubata);
		mapList.put(pasir.getDescription().get(0), pasir);
		mapList.put(semen.getDescription().get(0), semen);
		mapList.put(kusen.getDescription().get(0), kusen);
		mapList.put(atap.getDescription().get(0), atap);
		
		mapList.put(angkutanbiru.getDescription().get(0), angkutanbiru);
		mapList.put(angkutanmerah.getDescription().get(0), angkutanmerah);
		mapList.put(gojek.getDescription().get(0), gojek);
		mapList.put(gocar.getDescription().get(0), gocar);
		mapList.put(angkutanbus.getDescription().get(0), angkutanbus);
		
		mapList.put(telkomsel.getDescription().get(0), telkomsel);
		mapList.put(three.getDescription().get(0), three);
		mapList.put(xl.getDescription().get(0), xl);
		mapList.put(biznet.getDescription().get(0), biznet);
		mapList.put(indihome.getDescription().get(0), indihome);
		
		return mapList;
	}
}