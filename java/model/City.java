package model;

import java.util.ArrayList;

/*
 * This class creates a city object that has the info about the city
 */
public class City {
	// Fields
	/*
	 * Read from file
	 */
	private int id;
	private String city_name;
	private double longitude;
	private double latitude;

	/*
	 * Read from the other files In the graph this is the set of adjacent
	 */
	private ArrayList<Road> roads;
	private ArrayList<AirDistance> airDistances;

	/*
	 * treating this class as the Node class of the graph so it will have a Previous
	 * city
	 */
	private City previousCity;
	private double distanceFromSource;

	// Scaled on the map
	private double x;
	private double y;
	private double heuristicFromSource;

	// Constructors
	/**
	 * @param name
	 */
	public City(String name) {
		this.city_name = name;
	}

	/**
	 * @param id
	 * @param city_name
	 * @param longitude
	 * @param latitude
	 */
	public City(int id, String city_name, double longitude, double latitude) {
		this.id = id;
		this.city_name = city_name;
		this.longitude = longitude;
		this.latitude = latitude;
		setXandY();
		setRoads(new ArrayList<Road>());
		setAirDistances(new ArrayList<AirDistance>());
	}

	private void setXandY() {

		if (getCity_name().equals("Jerusalem")) {
			x = 230;
			y = 327;
		} else if (getCity_name().equals("Al-Bireh")) {
			x = 253;
			y = 306;
		} else if (getCity_name().equals("Al-Khalil")) {
			x = 232;
			y = 386;
		} else if (getCity_name().equals("Gaza")) {
			x = 131;
			y = 381;
		} else if (getCity_name().equals("Nablus")) {
			x = 289;
			y = 240;
		} else if (getCity_name().equals("Beir Al-Sabi")) {
			x = 174;
			y = 461;
		} else if (getCity_name().equals("Yaffa")) {
			x = 189;
			y = 277;
		} else if (getCity_name().equals("Bethlehem")) {
			x = 258;
			y = 346;
		} else if (getCity_name().equals("Jenin")) {
			x = 285;
			y = 179;
		} else if (getCity_name().equals("Haifa")) {
			x = 219;
			y = 131;
		} else if (getCity_name().equals("Tulkarm")) {
			x = 245;
			y = 205;
		} else if (getCity_name().equals("Akka")) {
			x = 237;
			y = 104;
		} else if (getCity_name().equals("Jericho")) {
			x = 299;
			y = 313;
		} else if (getCity_name().equals("Nasreh")) {
			x = 279;
			y = 142;
		} else if (getCity_name().equals("Arad")) {
			x = 256;
			y = 424;
		}
	}

	// Method to add a road to the city
	/**
	 * @param road
	 */
	public void addRoad(Road road) {
		getRoads().add(road);
	}

	// Method to add an Air distance to the City
	/**
	 * @param airDistance
	 */
	public void addAirDistance(AirDistance airDistance) {
		getAirDistances().add(airDistance);
	}

	// This method finds a city by the ID of it's road
	/**
	 * @param id
	 * @return
	 */
	public Road findRoadByCityID(int id) {
		for (Road road : getRoads()) {
			if (road.getCity1() == id || road.getCity2() == id) {
				return road;
			}
		}
		return null;
	}
	
	public AirDistance findAirDistanceByCityID(int cityID) {
        for (AirDistance airDistance : airDistances) {
            if (airDistance.getCity1() == cityID || airDistance.getCity2() == cityID) {
                return airDistance;
            }
        }
        return null;
    }

	@Override
	public String toString() {
		return "City [id=" + id + ", city_name=" + city_name + ", longitude=" + longitude + ", latitude=" + latitude
				+ "\n roads=" + roads + "\n airDistances=" + airDistances + "\n x=" + x + ", y=" + y + "]";
	}

	/*
	 * Getters and Setters
	 */
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the city_name
	 */
	public String getCity_name() {
		return city_name;
	}

	/**
	 * @param city_name the city_name to set
	 */
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
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
	 * @return the airDistances
	 */
	public ArrayList<AirDistance> getAirDistances() {
		return airDistances;
	}

	/**
	 * @param airDistances the airDistances to set
	 */
	public void setAirDistances(ArrayList<AirDistance> airDistances) {
		this.airDistances = airDistances;
	}

	/**
	 * @return the previousCity
	 */
	public City getPreviousCity() {
		return previousCity;
	}

	/**
	 * @param previousCity the previousCity to set
	 */
	public void setPreviousCity(City previousCity) {
		this.previousCity = previousCity;
	}

	/**
	 * @return the distanceFromSource
	 */
	public double getDistanceFromSource() {
		return distanceFromSource;
	}

	/**
	 * @param distanceFromSource the distanceFromSource to set
	 */
	public void setDistanceFromSource(double distanceFromSource) {
		this.distanceFromSource = distanceFromSource;
	}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * @return the heuristicFromSource
	 */
	public double getHeuristicFromSource() {
		return heuristicFromSource;
	}

	/**
	 * @param heuristicFromSource the heuristicFromSource to set
	 */
	public void setHeuristicFromSource(double heuristicFromSource) {
		this.heuristicFromSource = heuristicFromSource;
	}
}