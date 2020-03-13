package home;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.*;
public class Flight {
	String passengerID, flightID, fromAirport, toAirport, departureTime;
	int totalFlightTime;
	Flight()
	{
		totalFlightTime= 0;
	}
	public Flight(String passenger_ID, String flight_ID, String from_airport, String to_airport, String departure_time, String total_flight_time)
	{
		passengerID=passenger_ID;
		flightID=flight_ID;
		fromAirport=from_airport;
		toAirport= to_airport;
		departureTime=epochTimeToNormal(departure_time);
	//	System.out.print(" departure time: " + departureTime);
		totalFlightTime= Integer.parseInt(total_flight_time);
		
	}
	
	public void setFlightData(String passenger_ID, String flight_ID, String from_airport, String to_airport, String departure_time, String total_flight_time)
	{

		passengerID=passenger_ID;
		flightID=flight_ID;
		fromAirport=from_airport;
		toAirport= to_airport;
		departureTime=epochTimeToNormal(departure_time);
		//System.out.print(" departure time: " + departureTime);
		totalFlightTime= Integer.parseInt(total_flight_time);	
		
	}
	
	public String epochTimeToNormal(String departure_time)
	{
		
		  long unix_seconds = (Long.parseLong(departure_time));
		   Date date = new Date(unix_seconds*1000L); 
		   // format of the date
		   SimpleDateFormat jdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
		   jdf.setTimeZone(TimeZone.getTimeZone("GMT-4"));
		   String java_date = jdf.format(date);
		   System.out.println("\n"+java_date+"\n");
		   
		return java_date;
		
	}
	public String getTo()
	{
		
		return toAirport;
	}
	
	public String getFrom()
	{
		
		return fromAirport;
	}
	
	public String getPassengerID()
	{
		return passengerID;
	}
	
	
	
	public String getFlightID()
	{
	return flightID;
}
	
	
	
}