package product;

import java.util.List;

public class TransportationServices extends Services {
	private String vehicleType, routePath;
	private int routeMileage;
	
	public TransportationServices() {
		//System.out.println("Transportation Service Object Create");
	}
	
	public TransportationServices(int id, String type, List<String> description, double costRate, 
								  String typeCost, int userUsage,
								  String vehicleType, String routePath, int routeMileage) {
		super(id, type, description, costRate, typeCost, userUsage);
		this.vehicleType = vehicleType;
		this.routePath = routePath;
		this.routeMileage = routeMileage;
		setPrice(priceCalculation(userUsage, super.getCost()));
	}
	
	public TransportationServices(double costRate, int userUsage, int routeMilleage) {
		super(costRate, userUsage);
		this.routeMileage = routeMilleage;
	}
	
	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getRoutePath() {
		return routePath;
	}

	public void setRoutePath(String routePath) {
		this.routePath = routePath;
	}

	public int getRouteMileage() {
		return routeMileage;
	}

	public void setRouteMileage(int routeMileage) {
		this.routeMileage = routeMileage;
	}

	@Override
	public void costCalculation() {
		double cost;
		if (getTypeCost().equalsIgnoreCase("fixperroute")) {
			cost = getCostRate() * 1;
			setCost(cost);
		}
		else if (getTypeCost().equalsIgnoreCase("permiles")) {
			cost = (getCostRate() / 2) * routeMileage;
			setCost(cost);
		}
	}
}