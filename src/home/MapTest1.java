package home;

import java.util.List;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.io.FileNotFoundException;

import java.io.IOException;
public class MapTest1 {

	
	
		 //------------------Task A------------------------------------- 
			// Determine the number of flights from each airport
			//include a list of any	airports not used.
			
			static FileWriter fw;
			static String passengerData = "AComp_Passenger_data.csv";
			
			public static void partA() {
		TreeMap<String,Integer> airportMap = new TreeMap<String,Integer>();
		try {
				//FileWriter fw = new FileWriter("output.txt");
				ArrayList<String> airportsNotUsed = new ArrayList<String>();
				BufferedReader airportReader = new BufferedReader(new FileReader(passengerData));
				String dataRow;
				while((dataRow = airportReader.readLine()) != null )
				{
					String[] splitRow = dataRow.split(",");
					if(regularExpression(splitRow, 1))
					{
							if(airportMap.containsKey(splitRow[2]))
							{
								airportMap.put(splitRow[2], airportMap.get(splitRow[2]) + 1);
							}
							else
							{
								airportMap.put(splitRow[2], 1);
							}
					} 
					else
					{
						airportsNotUsed.add(splitRow[2]);
					}
				}
				Set<Entry<String, Integer>> entries = airportMap.entrySet();
				//using for loop
				fw.write("-----------------------> Part A <------------------------------\n\n");
				for(Entry<String, Integer> entry : entries){
					fw.write(entry.getValue() + " number of flights were departed from Airport => " + entry.getKey() + "\n");
				}
				fw.write("\n\nAirports that were not used : " + airportsNotUsed);
				airportReader.close();
				//fw.close();
				
		} catch (Exception e) {
			System.out.println("error reading file");
			// TODO: handle exception
		}		
	}
	
			//--------------------Task B--------------------------------
			//static TreeMap<String, List> flights = new TreeMap<String, List>();
			static TreeMap<String, List<Flight>> flightData = new TreeMap<String,List<Flight>>();
			public static void partB(int flag) {
	
	try {
		BufferedReader airportReader = new BufferedReader(new FileReader(passengerData));
		String dataRow;
		
		while((dataRow = airportReader.readLine()) != null)
		{
			String[] splitRow= dataRow.split(",");
			if(regularExpression(splitRow, 2))
			{
				try {
					if (flightData.get(splitRow[1]) == null) {
						flightData.put(splitRow[1], new ArrayList<Flight>());
					}
				//	System.out.println(splitRow[1]);
				
					
					flightData.get(splitRow[1]).add
							(new Flight(splitRow[0], splitRow[1], splitRow[2], splitRow[3], splitRow[4], splitRow[5]));
					
					//System.out.println( flightData.get(splitRow[1]).get(u).departureTime);
					
				} catch (Exception e) {
				//	System.out.print(e.toString());
					
				}
						
			}
			else
			{
				//System.out.print(dataRow+'\n');
			}
	//		u++;
		}
		airportReader.close();
		String x;
		if(flag==1)
		{
			fw.write("\n\n-----------------------> Part B <------------------------------\n\n");
			for(Map.Entry<String, List<Flight>> flight: flightData.entrySet())
			{
				fw.write("\nFlight ID: "+flight.getKey()+"\n");
				
				
				for(Flight flightDetail: flight.getValue()) {
				fw.write("Passenger ID: " + flightDetail.passengerID+". IATA/FAA: "+flightDetail.fromAirport+"/"+flightDetail.toAirport+", Departure Time: "+flightDetail.departureTime+
						", Total time Flight: "+flightDetail.totalFlightTime+"\n");
				}
				
			}
	
			fw.write("\n\n-----------------------> Part B End <------------------------------");
		}
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
			
}		
		
			//--------------------Task C--------------------------------
			//static TreeMap<String, List> flights = new TreeMap<String, List>();
			public static void partC() {
				
				TreeMap<String, Integer> passengers = new TreeMap<String, Integer>();

			try {
				
				BufferedReader airportReader = new BufferedReader(new FileReader(passengerData));
				String dataRow;
				while((dataRow = airportReader.readLine()) != null)
				{
					String[] splitRow= dataRow.split(",");
					if(regularExpression(splitRow, 3))
					{
						try {
							if (passengers.get(splitRow[1]) == null) {
								passengers.put(splitRow[1], 1);
							} else {
								passengers.put(splitRow[1], passengers.get(splitRow[1]) + 1);
							}
							
						}
						catch (Exception e) {
							
						}
					}
						
				}
				
				airportReader.close();
				fw.write("\n\n-----------------------> Part C <------------------------------\n\n");
				for (Map.Entry<String, Integer> entry : passengers.entrySet()) {
					fw.write("Flight ID:" + entry.getKey() + " had " + entry.getValue() + " number of Passengers.\n");
				}
				fw.write("\n\n-----------------------> Part C End <------------------------------\n\n");
				
			} catch (Exception e) {
				// TODO: handle exception
			}
					
		}
			private static boolean codesplit(String[] split) {
				
				if (split.length < 4)
					return false;
				else	
				{
					return split[1].matches("[A-Z]{3}") & split[2].matches("[+-]?\\d*\\.?\\d*")
						& split[3].matches("[+-]?\\d*\\.?\\d*");
				}
				
			
			}
			
			//--------------------Part D---------------------------------
			public static void partD() {
				
				 String passengerData1 = "Top30_airports_LatLong.csv";
					try {
						TreeMap<String, Airports_for_Travel> airports = new TreeMap<String, Airports_for_Travel>();
						BufferedReader br = new BufferedReader(new FileReader(passengerData1));
						
						
						String dataRow;
						while((dataRow = br.readLine()) != null)
						{
							String[] splitRow= dataRow.split(",");
							if(regularExpression(splitRow, 4) )
								//ye wohi step lia ha 4 colunns thay tou copy kia ha string ko
							{
								try {
								
									if (airports.get(splitRow[1]) == null) {
										try
										{
										airports.put(splitRow[1],new Airports_for_Travel(splitRow[1].toString(), splitRow[2].toString(), splitRow[3].toString()));
									//ab map ma value dal di ha	
										}
										catch(Exception e)
										{
											//System.out.print(e.toString());
											
										}
									}
								
								}	
									
									catch (Exception e) {
										System.out.println("Failed to add <" + splitRow[0] + "> to map.");
									//value ni girti tou fial hota ha
										}
								
							}
							
						}
						
						
						
						int count = 0;
						partB(0);
						
						for (Map.Entry<String, Airports_for_Travel> entry : airports.entrySet()) {
						//	System.out.println(entry.getKey() + "[:] " + entry.getValue());
							//System.out.print(entry.getKey()+"\n");	
							count++;
							
						}
						
						TreeMap<String, Double> distances = new TreeMap<String, Double>();
						
						for (Map.Entry<String, List<Flight>> jin : flightData.entrySet()) {
							for (Flight aFlight : jin.getValue()) {
										//System.out.println((Airports_for_Travel) airports.get(aFlight.getFrom())).getLatitude()));
							try
							{
								double x1 = ((Airports_for_Travel) airports.get(aFlight.getFrom())).getLatitude();
								double y1 = ((Airports_for_Travel) airports.get(aFlight.getFrom())).getLongitude();
								double x2 = ((Airports_for_Travel) airports.get(aFlight.getTo())).getLatitude();
								double y2 = ((Airports_for_Travel) airports.get(aFlight.getTo())).getLongitude();

								double d = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
								 // Save each distance in a map
								distances.put(jin.getKey(), d);
								

								//double x1 = ((Airports_for_Travel) airports.get(aFlight.getFrom())).getLatitude();
								//System.out.print(airports.get(aFlight.getFrom()).getLatitude());
								
							}
							catch(Exception e)
							{
								//System.out.print(e.toString());
								
							}
							}
						}
						
						Map<String, Double> reducer = new TreeMap<String, Double>();
						for (Map.Entry<String, Double> entry : distances.entrySet()) {
							reducer.put(entry.getKey(), entry.getValue());
						}
						
						for (Map.Entry<String, Double> entry : reducer.entrySet()) {
							System.out.println(entry.getKey() + " -> " + entry.getValue() + " nautical miles.");
						
						}
						
						TreeMap<String, Double> passengerDistance = new TreeMap<String, Double>();
						for (Map.Entry<String, List<Flight>> aFlight : flightData.entrySet()) {
								for(Flight passenger : aFlight.getValue()){
									if (passengerDistance.get(passenger.getPassengerID()) == null) {
										passengerDistance.put(passenger.getPassengerID(), distances.get(passenger.getFlightID()));
									} else {
										double distance = passengerDistance.get(passenger.getPassengerID());
										passengerDistance.put(passenger.getPassengerID(), distance + distances.get(passenger.getFlightID()));
									}
								}
						}
						
					    String maxDistancePassengerId = passengerDistance.firstKey();
						double maxDistance= 0;
						fw.write("--------------------------------> PART D Start <------------------------------");
						for (Map.Entry<String, Double> entry : passengerDistance.entrySet()) {
							
							fw.write("\n\nPassenger " + entry.getKey() + " travelled " + entry.getValue() + " nautical miles.\n");
							
							if (maxDistance < entry.getValue())
							{
								maxDistance = entry.getValue();
								maxDistancePassengerId=entry.getKey();
							}
						}
						fw.write("\n\nMaximum Miles Travelled by a passenger:\n\nPassenger : " + maxDistancePassengerId + " travelled Maximum distance of: " + maxDistance +"\n\n");
						fw.write("--------------------------------> PART D End <------------------------------");
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			
			private static boolean regularExpression(String[] splitRow, int part)
			{
				switch(part)
				{
				//for Part A
					case 1:
					
						if(splitRow.length < 3 )
						{
							return false;
						}
						
						return	splitRow[2].matches("[A-Z]{3}");
						
					case 2:
					
						if(splitRow.length < 6)
							{
							return false;
							}
						return (splitRow[0].matches("[A-Z]{3}[0-9]{4}[A-Z]{2}[0-9]{1}") & 
								splitRow[1].matches("[A-Z]{3}[0-9]{4}[A-Z]{1}") & splitRow[2].matches("[A-Z]{3}")
								& splitRow[3].matches("[A-Z]{3}") & splitRow[4].matches("\\d{10}"));
					
					case 3:
					
						if(splitRow.length < 2) 
							{
								return false;
							}
						return splitRow[1].matches("[A-Z]{3}[0-9]{4}[A-Z]{1}");
						
					case 4:
					
						if(splitRow.length<4)
							{
								return false;
							}
						return (splitRow[1].matches("[A-Z]{3}") & splitRow[2].matches("[+-]?\\d*\\.?\\d*") 
								& splitRow[3].matches("[+-]?\\d*\\.?\\d*"));
					default:
						return false;
				}
			}
		//main function
	public static void main(String[] args) {
		try {
			fw = new FileWriter("output.txt");
			
			partA();
			partB(1);
			partC();
			partD();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
