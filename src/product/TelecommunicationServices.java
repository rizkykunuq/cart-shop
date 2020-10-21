package product;

import java.util.List;

public class TelecommunicationServices extends Services {
	private String packetType;
	private int packetLimit, duration;
	
	public TelecommunicationServices() {
		//System.out.println("Telecommunication Service Object Create");
	}
	
	public TelecommunicationServices(int id, String type, List<String> description, double costRate, 
									 String typeCost, int userUsage,
									 String packetType, int packetLimit, int duration) {
		super(id, type, description, costRate, typeCost, userUsage);
		this.packetType = packetType;
		this.packetLimit = packetLimit;
		this.duration = duration;
		setPrice(priceCalculation(userUsage, super.getCost()));
	}
	
	public TelecommunicationServices(double costRate, int userUsage, int duration) {
		super(costRate, userUsage);
		this.duration = duration;
	}
	
	public String getPacketType() {
		return packetType;
	}
	
	public void setPacketType(String packetType) {
		this.packetType = packetType;
	}

	public int getPacketLimit() {
		return packetLimit;
	}

	public void setPacketLimit(int packetLimit) {
		this.packetLimit = packetLimit;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	@Override
	public void costCalculation() {
		if (getTypeCost().equalsIgnoreCase("costpersecond")) {
			setCost(getCostRate() * duration);
		}
		else if (getTypeCost().equalsIgnoreCase("costperpacket")) {
			if (getPacketType().equalsIgnoreCase("default")) {
				setCost((getCostRate() * duration * 90) / 100);
			}
			else if (getPacketType().equalsIgnoreCase("data")){
				setCost((getCostRate() * duration * 70) / 100);
			}
		}
	}
}