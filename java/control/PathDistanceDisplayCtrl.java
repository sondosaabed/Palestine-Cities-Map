package control;

import model.City;
import model.HeuristicSearch;
import model.Map;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import visualization.PathDistanceDisplayScene;

/*
 *  Create controller for the scene that shows the shortest path
 */
public class PathDistanceDisplayCtrl {
	// Fields
	private PathDistanceDisplayScene PathDistanceDisplayScene;
	private MapCtrl mapCtrl;
	private HeuristicSearch solution;
	private TextField dist;
	private TextArea path;
	private Button cancel;
	private Stage stage;
	private TextField ef1;

	// Constructor
	public PathDistanceDisplayCtrl(City source, City distanation, Stage stage, Map map, String algorithm,
			GraphicsContext gc) {
		initialize(source, distanation, stage, map, algorithm, gc);
	}

	// Initialize Objects
	/**
	 * @param source
	 * @param distantion
	 * @param stage
	 * @param map
	 * @param algorithm
	 * @param gc
	 */
	private void initialize(City source, City distantion, Stage stage, Map map, String algorithm, GraphicsContext gc) {
		setPathDistanceDisplayScene(new PathDistanceDisplayScene(source, distantion));
		setDist(getPathDistanceDisplayScene().getDistance());
		setPath(getPathDistanceDisplayScene().getPath());
		setCancel(getPathDistanceDisplayScene().getCancel());
		setStage(getPathDistanceDisplayScene().getStage());
		setEf1(getPathDistanceDisplayScene().getEf1());

		/*
		 * Create the heuristic solution
		 */
		solution = new HeuristicSearch(map);

		if (algorithm.trim() == "Through A*") {
			/*
			 * use the A* method to find the shortest Path
			 */
			solution.astarSerach(source, distantion);
			getDist().setText(solution.getDistance() + " KM");
			getPath().setText(print_shortest_path(solution));
			getEf1().setText(System.currentTimeMillis() + "");
		} else if (algorithm.trim() == "Through Greedy") {
			/*
			 * use the greedy method to find the shortest Path
			 */
			// solution.greedyBFS(source, distantion);
			getDist().setText(solution.getDistance() + " KM");
			getPath().setText(print_shortest_path(solution));
			getEf1().setText(System.currentTimeMillis() + "");
		}

		/*
		 * Draw the line with the roads names between the cities of the path
		 * 
		 */
		/*
		 * So that the user can only view the path on the map I will clear the gc and
		 * only draw the cities
		 */
		gc.clearRect(0, 0, 540, 800);
		Image mapimage = new Image("images/palestine.png");
		gc.drawImage(mapimage, 0, 0);
		gc.setFont(Font.font("Lucida Sans Unicode", FontWeight.LIGHT, FontPosture.REGULAR, 14));

		ArrayList<City> path = solution.getPath();
		if(path.size()== 0) {
			getPath().setText("You can't go from " + source.getCity_name() + " to " + distantion.getCity_name() + " :)");
		} else {
			for (int i = 0; i < path.size(); i++) {
				City startCity = path.get(i);
				gc.setFill(Color.LIGHTGREEN);
				gc.fillOval(startCity.getX(), startCity.getY(), 12, 12);
				gc.strokeText(startCity.getCity_name(), startCity.getX(), startCity.getY());
			}

			for (int i = 0; i < path.size() - 1; i++) {
				City startCity = path.get(i);
				City endCity = path.get(i + 1);
				String roadName = startCity.findRoadByCityID(endCity.getId()).getRoad_name();

				double startX = startCity.getX();
				double startY = startCity.getY();
				double endX = endCity.getX();
				double endY = endCity.getY();
				gc.setStroke(Color.DARKRED);

				gc.setLineWidth(4.0);
				gc.strokeLine(startX, startY, endX, endY);

				double labelX = (startX + endX) / 2;
				double labelY = (startY + endY) / 2;
				gc.setFill(Color.BLACK);
				gc.fillText(roadName, labelX, labelY);
			}
		}
		handle_okay(getCancel(), stage, map);

	}

	/**
	 * @param solution
	 * @return
	 */
	private String print_shortest_path(HeuristicSearch solution) {
		// returns the path as a string
		String path = "";
		for (int i = 0; i < solution.getPath().size(); i++) {
			path = path + (solution.getPath().get(i).getCity_name()) + "\n";
		}
		return path;
	}

	/*
	 * Handlers
	 */
	/**
	 * @param okay
	 * @param stage
	 * @param map
	 */
	private void handle_okay(Button okay, Stage stage, Map map) {
		okay.setOnAction(e -> {
			setMapCtrl(new MapCtrl(stage, map));
			getStage().close();
		});
	}
	/*
	 * Getters and Setters
	 */

	/**
	 * @return the pathDistanceDisplayScene
	 */
	public PathDistanceDisplayScene getPathDistanceDisplayScene() {
		return PathDistanceDisplayScene;
	}

	/**
	 * @param pathDistanceDisplayScene the pathDistanceDisplayScene to set
	 */
	public void setPathDistanceDisplayScene(PathDistanceDisplayScene pathDistanceDisplayScene) {
		PathDistanceDisplayScene = pathDistanceDisplayScene;
	}

	/**
	 * @return the mapCtrl
	 */
	public MapCtrl getMapCtrl() {
		return mapCtrl;
	}

	/**
	 * @param mapCtrl the mapCtrl to set
	 */
	public void setMapCtrl(MapCtrl mapCtrl) {
		this.mapCtrl = mapCtrl;
	}

	/**
	 * @return the solution
	 */
	public HeuristicSearch getSolution() {
		return solution;
	}

	/**
	 * @param solution the solution to set
	 */
	public void setSolution(HeuristicSearch solution) {
		this.solution = solution;
	}

	/**
	 * @return the dist
	 */
	public TextField getDist() {
		return dist;
	}

	/**
	 * @param dist the dist to set
	 */
	public void setDist(TextField dist) {
		this.dist = dist;
	}

	/**
	 * @return the path
	 */
	public TextArea getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(TextArea path) {
		this.path = path;
	}

	/**
	 * @return the cancel
	 */
	public Button getCancel() {
		return cancel;
	}

	/**
	 * @param cancel the cancel to set
	 */
	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}

	/**
	 * @return the stage
	 */
	public Stage getStage() {
		return stage;
	}

	/**
	 * @param stage the stage to set
	 */
	public void setStage(Stage stage) {
		this.stage = stage;
	}

	/**
	 * @return the ef1
	 */
	public TextField getEf1() {
		return ef1;
	}

	/**
	 * @param ef1 the ef1 to set
	 */
	public void setEf1(TextField ef1) {
		this.ef1 = ef1;
	}
}