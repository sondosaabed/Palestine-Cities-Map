
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import control.AlertBoxCtrl;

/**
 * In this class I created a single class that reads the files into a map 
 */
public class ReadingFiles {
	static FileReader fileR;
	static BufferedReader buffer;
	/*
	 * This method is created to read the cities file which is a comma separated
	 * with the first line as a header id,city_name
	 */
	
	/**
	 * @param cities
	 * @param map
	 */
	public static void readCities(File cities, Map map) {

		try {
			fileR = new FileReader(cities);
			buffer = new BufferedReader(fileR);

			// Skip the first Line
			String line = buffer.readLine();
			
			// Read the list of cities
            while ((line = buffer.readLine()) != null) {				
            	String[] cityValues = line.trim().split(",");
				City city = new City(Integer.parseInt(cityValues[0].trim()), 
						cityValues[1].trim(), 
						Double.parseDouble(cityValues[2].trim()),
						Double.parseDouble(cityValues[3].trim()));
				map.getCities().add(city);
			}
			buffer.close();
		} // catch any type of exceptions and alert the user
		catch (Exception e) {
			AlertBoxCtrl a = new AlertBoxCtrl(e.getLocalizedMessage(), "Exception");
			a.show();
		}
	}

	/*
	 * This method is created to read the roads file which is a comma separated
	 * with the first line as a header id,city1_id, city2_id, distance
	 */
	public static void readRoads(File roads, Map map) {
		try {
			fileR = new FileReader(roads);
			buffer = new BufferedReader(fileR);

			// Skip the first Line
			String line = buffer.readLine();
			
			// Read the list of vertices
            while ((line = buffer.readLine()) != null) {				
            	String[] roadValues = line.trim().split(",");
				Road road = new Road(Integer.parseInt(roadValues[0].trim()), 
						roadValues[1].trim(),
						Integer.parseInt(roadValues[2].trim()), 
						Integer.parseInt(roadValues[3].trim()),
						Double.parseDouble(roadValues[4].trim())
						);
				map.getRoads().add(road);
			}
            readCityRoads(map);
			buffer.close();
		} // catch any type of exceptions and show alert to user
		catch (Exception e) {
			AlertBoxCtrl a = new AlertBoxCtrl(e.getLocalizedMessage(), "Exception");
			a.show();
		}
	}
	
	/*
	 * This method is created to read the roads file which is a comma separated
	 * with the first line as a header id,city1_id, city2_id, air_distance
	 */
	
	/**
	 * @param roads
	 */
	public  static void readAirDistances(File airDistances,Map map) {
		try {
			 fileR = new FileReader(airDistances);
			 buffer = new BufferedReader(fileR);

			// Skip the first Line
			String line = buffer.readLine();
			
			// Read the list of vertices
            while ((line = buffer.readLine()) != null) {				
            	String[] airDistanceValues = line.trim().split(",");
				AirDistance airDistance = new AirDistance(Integer.parseInt(airDistanceValues[0].trim()), 
						Integer.parseInt(airDistanceValues[1].trim()), 
						Integer.parseInt(airDistanceValues[2].trim()),
						Double.parseDouble(airDistanceValues[3].trim())
						);
				map.getAir_distances().add(airDistance);
			}
            readCityAirDistances(map);
			buffer.close();
		} // catch any type of exceptions
		catch (Exception e) {
			AlertBoxCtrl a = new AlertBoxCtrl(e.getLocalizedMessage(), "Exception");
			e.printStackTrace();
			a.show();
		}
	}
	
	/*
	 * this method takes the roads and adds them to each city
	 */
	/**
	 * @param map
	 */
	public static void readCityRoads(Map map) {
		for(Road road: map.getRoads()) {
			int city_id_1= road.getCity1();
			int city_id_2= road.getCity2();
			
			//If the two id's in the Road exists in the citis IDs
			City city1 = map.findCityById(city_id_1);
			City city2 = map.findCityById(city_id_2);
			
			if(!city1.equals(null)
					&&
					!city2.equals(null)){
				city1.addRoad(road);
				city2.addRoad(road);
				
	            // Create a new Road object with swapped city IDs
	            Road reverseRoad = new Road(city_id_2, city_id_1, road.getRoad_name(), road.getDistance());
	            city1.addRoad(reverseRoad);
	            city2.addRoad(reverseRoad);
			}
		}
	}
	
	/*
	 * this method takes the AirDistances and adds them to each city
	 */
	/**
	 * @param map
	 */
	public static void readCityAirDistances(Map map) {
		for(AirDistance airDistance: map.getAir_distances()) {
			int city_id_1= airDistance.getCity1();
			int city_id_2= airDistance.getCity2();
			
			//If the two id's in the Road exists in the citis IDs
			City city1 = map.findCityById(city_id_1);
			City city2 = map.findCityById(city_id_2);
			
			//then add them to each city
			if(!city1.equals(null)
					&&
					!city2.equals(null)){
				city1.addAirDistance(airDistance);
				city2.addAirDistance(airDistance);
				
		          // Create a new AirDistance object with swapped city IDs
	            AirDistance reverseAirDistance = new AirDistance(city_id_2, city_id_1, airDistance.getAir_distance());
	            city1.addAirDistance(reverseAirDistance);
	            city2.addAirDistance(reverseAirDistance);
			}
		}
	}
}