package model;
/*
 * This class creates an AirDistance object that has the info about the AirDistance
 */
public class AirDistance {
	//Fields
	private int id;
	private int city1;
	private int city2;
	private double air_distance;
	
	//Constructor 
	/**
	 * @param id
	 * @param city1
	 * @param city2
	 * @param air_distance
	 */
	public AirDistance(int id, int city1, int city2, double air_distance) {
		this.id = id;
		this.city1 = city1;
		this.city2 = city2;
		this.air_distance = air_distance;
	}
	
	public AirDistance(int city_id_2, int city_id_1, double air_distance2) {
		this.city1 = city_id_2;
		this.city2 = city_id_1;
		this.air_distance = air_distance2;	}

	@Override
	public String toString() {
		return "AirDistance [id=" + id + ", city1=" + city1 + ", city2=" + city2 + ", air_distance=" + air_distance
				+ "] \n";
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
	 * @return the air_distance
	 */
	public double getAir_distance() {
		return air_distance;
	}

	/**
	 * @param air_distance the air_distance to set
	 */
	public void setAir_distance(double air_distance) {
		this.air_distance = air_distance;
	}

}