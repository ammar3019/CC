package home;

public class Airports_for_Travel {
	String keycode;
	double latitude, longitude;
	
	Airports_for_Travel(String keycode, String latitude, String longitude){
		this.keycode = keycode;
		this.latitude = Double.parseDouble(latitude);
		this.longitude = Double.parseDouble(longitude);
		
	}
	public String toString(){
		return keycode + ":" + this.latitude + " " + this.longitude;
	}
	
	
	public double getLatitude(){
		return this.latitude;
	}
	
	public double getLongitude(){
		return this.longitude;
	}
	
	public String getkeycode(){
		return keycode;
	}
	
}
