package Training.Program.models;

import static Training.Program.constants.Constants.devices_collection;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection=devices_collection)
public class Devices {
	
	private String batteryLevel;
	private String routeFrom;
	private String routeTo;
	private String deviceId;
	private String temperature;
	
	public Devices(String batteryLevel, String routeFrom, String routeTo, String deviceId, String temperature) {
		super();
		this.batteryLevel = batteryLevel;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.deviceId = deviceId;
		this.temperature = temperature;
	}

	public String getBatteryLevel() {
		return batteryLevel;
	}

	public void setBatteryLevel(String batteryLevel) {
		this.batteryLevel = batteryLevel;
	}

	public String getRouteFrom() {
		return routeFrom;
	}

	public void setRouteFrom(String routeFrom) {
		this.routeFrom = routeFrom;
	}

	public String getRouteTo() {
		return routeTo;
	}

	public void setRouteTo(String routeTo) {
		this.routeTo = routeTo;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	
	
	
}
