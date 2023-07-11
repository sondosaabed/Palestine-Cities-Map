package model;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.List;

/*
 * This class implements a Heuristic Based search using two algorithms:
 * 		1- A* algorithm
 * 		2- Greedy Best-First Search
 */

public class HeuristicSearch {
	// Fields
	private ArrayList<City> path;
	private double distance;
	private Map map;
	HashSet<City> explored = new HashSet<City>();
	PriorityQueue<City> frontier = new PriorityQueue<City>();

	/**
	 * @param map
	 */
	public HeuristicSearch(Map map) {
		this.path = new ArrayList<>();
		this.distance = 0.0;
		this.map = map;
		this.frontier = new PriorityQueue<City>((city1, city2) -> {
			double value1 = city1.getDistanceFromSource() + city1.getHeuristicFromSource();
			double value2 = city2.getDistanceFromSource() + city2.getHeuristicFromSource();

			if (value1 < value2) {
				return -1;
			} else if (value1 > value2) {
				return 1;
			} else {
				return 0;
			}
		});
	}

	// Implement the A* algorithm to find the shortest path
	/**
	 * @param source
	 * @param destintaion
	 */
	public void astarSerach(City source, City destination) {
		distance = 0.0;

		City sourceCity = map.findCityByName(source.getCity_name());
		City destinationCity = map.findCityByName(destination.getCity_name());

		Road road = sourceCity.findRoadByCityID(destinationCity.getId());

		if (sourceCity.getCity_name().equals(destinationCity.getCity_name())) {
			this.path.add(sourceCity);
		} else if (road != null) {
			this.distance = road.getDistance();
			this.path.add(sourceCity);
			this.path.add(destinationCity);
		} else {
			source.setDistanceFromSource(0);
			AirDistance airDistance = sourceCity.findAirDistanceByCityID(destinationCity.getId());
			if (airDistance != null) {
				source.setHeuristicFromSource(airDistance.getAir_distance());
			}
			frontier.add(source);

			while (!frontier.isEmpty()) {
				City currentCity = frontier.poll();
				explored.add(currentCity);

				if (currentCity.getCity_name().equals(destination.getCity_name())) {
					distance = currentCity.getDistanceFromSource();
					buildPath(destination);
					return;
				}

				for (Road road1 : currentCity.getRoads()) {
					City neighborCity = map.findCityById(road1.getCity2());
					double roadDistance = road1.getDistance();

					if (!explored.contains(neighborCity)) {
						double newDistance = currentCity.getDistanceFromSource() + roadDistance;

						if (newDistance < neighborCity.getDistanceFromSource() || !frontier.contains(neighborCity)) {
							neighborCity.setDistanceFromSource(newDistance);
							AirDistance neighborAirDistance = neighborCity
									.findAirDistanceByCityID(destinationCity.getId());
							if (neighborAirDistance != null) {
								neighborCity.setHeuristicFromSource(neighborAirDistance.getAir_distance());
							}
							neighborCity.setPreviousCity(currentCity);

							if (!frontier.contains(neighborCity)) {
								frontier.add(neighborCity);
							}
						}
					}
				}
			}
		}
	}

	// Implement the greedy best first search to find the shortest path
	/**
	 * @param source
	 * @param destintaion
	 */

	public void greedyBFS(City source, City destintaion) {
		distance = 0.0;

		City sourceCity = map.findCityByName(source.getCity_name());
		City destinationCity = map.findCityByName(destintaion.getCity_name());

		Road road = sourceCity.findRoadByCityID(destinationCity.getId());

		if (sourceCity.getCity_name().equals(destinationCity.getCity_name())) {
			this.path.add(sourceCity);
		} else {
			source.setHeuristicFromSource(source.findAirDistanceByCityID(destintaion.getId()).getAir_distance());
			frontier.add(source);

			while (!frontier.isEmpty()) {
				City currentCity = frontier.poll();
				explored.add(currentCity);

				if (currentCity.equals(destintaion)) {
					// Destination city reached
					distance = currentCity.getDistanceFromSource();
					buildPath(destintaion);
					return;
				}

				for (Road road1 : currentCity.getRoads()) {
					City neighborCity = getMap().findCityById(road1.getCity2());

					if (!explored.contains(neighborCity) && !frontier.contains(neighborCity)) {
						neighborCity.setHeuristicFromSource(
								neighborCity.findAirDistanceByCityID(destintaion.getId()).getAir_distance());
						frontier.add(neighborCity);
					} else if (frontier.contains(neighborCity)) {
						List<City> citiesToUpdate = new ArrayList<>();
						while (!frontier.isEmpty()) {
							City city = frontier.poll();
							if (city.equals(neighborCity)) {
								citiesToUpdate.add(neighborCity);
							}
						}
						frontier.addAll(citiesToUpdate);
					}
				}
			}
		}
	}
	/*
	 * Add the cities path to the array list
	 */
	/**
	 * @param destination
	 */
	private void buildPath(City destination) {
		path.clear();
		City currentCity = destination;

		while (currentCity != null) {
			path.add(0, currentCity);
			currentCity = currentCity.getPreviousCity();
		}
	}
	/*
	 * Getters and Setters
	 * 
	 */

	/**
	 * @return the path
	 */
	public ArrayList<City> getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(ArrayList<City> path) {
		this.path = path;
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

	/**
	 * @return the map
	 */
	public Map getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(Map map) {
		this.map = map;
	}
}