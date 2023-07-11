package model;
/*
 * This class creates a Road object that has the info about the road
 */
public class Road {
	//Fields
	private int id;
	private String road_name;
	private int city1;
	private int city2;
	private double distance;
	
	//Constructor
	/**
	 * @param id
	 * @param road_name
	 * @param city1
	 * @param city2
	 * @param distance
	 */
	public Road(int id, String road_name,int city1, int city2, double distance) {
		this.id = id;
		this.city1 = city1;
		this.city2 = city2;
		this.distance = distance;
		this.road_name= road_name;
	}
	
	public Road(int city_id_2, int city_id_1, String road_name2, double distance2) {
		this.city1 = city_id_2;
		this.city2 = city_id_1;
		this.distance = distance2;
		this.road_name= road_name2;	}

	//To string
	@Override
	public String toString() {
		return "Road [id=" + id + ", city1=" + city1 + ", city2=" + city2 + ", distance=" + distance + "]\n";
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
	 * @return the road_name
	 */
	public String getRoad_name() {
		return road_name;
	}

	/**
	 * @param road_name the road_name to set
	 */
	public void setRoad_name(String road_name) {
		this.road_name = road_name;
	}

	/**
	 * @return the city1
	 */
	public int getCity1() {
		return city1;
	}

	/**
	 * @param city1 the city1 to set
	 */
	public void setCity1(int city1) {
		this.city1 = city1;
	}

	/**
	 * @return the city2
	 */
	public int getCity2() {
		return city2;
	}

	/**
	 * @param city2 the city2 to set
	 */
	public void setCity2(int city2) {
		this.city2 = city2;
	}

	/**
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}	
}