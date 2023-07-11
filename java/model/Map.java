package model;

import java.util.ArrayList;

/**
 * This class contains the map information including cities, roads and air distances
 * 
 * A map is a group of cities and roads and airdiatnces
 */
public class Map {
	//Fields 
	ArrayList<City> cities = new ArrayList<City>(); // An ArrayList that contains Cities
	ArrayList<Road> roads = new ArrayList<Road>(); // An ArrayList that contains Roads
	ArrayList<AirDistance> air_distances = new ArrayList<AirDistance>(); // An ArrayList that contains Air Distances
	
	//Constructors
	public Map() {
		
	}
	
	/**
	 * @param cities
	 * @param roads
	 * @param air_distances
	 */
	public Map(ArrayList<City> cities, ArrayList<Road> roads, ArrayList<AirDistance> air_distances) {
		super();
		this.cities = cities;
		this.roads = roads;
		this.air_distances = air_distances;
	}
	
	//This method returns a city by it's name 
	/**
	 * @param name
	 * @return
	 */
	public City findCityByName(String name) {
		for (City city: cities){
			if(city.getCity_name().equals(name.trim())) {
				return city;
			}
		}
		return null;
	}
	
	//This method returns a city by it's ID 
    /**
     * @param cityId
     * @return
     */
    public City findCityById(int cityId) {
        for (City city : getCities()) {
            if (city.getId() == cityId) {
                return city;
            }
        }
        return null; // City with the given ID not found
    }
	/*
	 * Getter and Setters
	 */

	/**
	 * @return the cities
	 */
	public ArrayList<City> getCities() {
		return cities;
	}

	/**
	 * @param cities the cities to set
	 */
	public void setCities(ArrayList<City> cities) {
		this.cities = cities;
	}

	/**
	 * @return the roads
	 */
	public ArrayList<Road> getRoads() {
		return roads;
	}

	/**
	 * @param roads the roads to set
	 */
	public void setRoads(ArrayList<Road> roads) {
		this.roads = roads;
	}

	/**
	 * @return the air_distances
	 */
	public ArrayList<AirDistance> getAir_distances() {
		return air_distances;
	}

	/**
	 * @param air_distances the air_distances to set
	 */
	public void setAir_distances(ArrayList<AirDistance> air_distances) {
		this.air_distances = air_distances;
	}
}