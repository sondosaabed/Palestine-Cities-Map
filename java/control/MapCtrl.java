package control;

import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import model.City;
import model.Map;
import visualization.MapScene;

/*
 * This class creates a Map controller that controls the Map scene
 */
public class MapCtrl {
	// Fields
	private MapScene scene;
	private Button cancel;
	private Button run;
	private ComboBox<String> target;
	private ComboBox<String> algorithm;
	private ComboBox<String> source;
	private GraphicsContext gc;

	//Constructor
	/**
	 * @param stage
	 * @param map
	 */
	public MapCtrl(Stage stage, Map map) {
		initialize(stage, map);
	}

	//Initialize objects
	/**
	 * @param stage
	 * @param map
	 */
	private void initialize(Stage stage, Map map) {
		setScene(new MapScene(stage, map));

		setCancel(getScene().getCancel());
		setRun(getScene().getRun());
		setTarget(getScene().getTarget());
		setAlgorithm(getScene().getAlgorithm());
		setSource(getScene().getSource());
		setGc(getScene().getGc());
		
		handle_cancel(getCancel());
		handle_run(getRun(), stage, map);
	}

	/*
	 * Buttons Handlers
	 */
	/**
	 * @param run
	 * @param stage
	 * @param map
	 * @param graphicsContext 
	 */
	private void handle_run(Button run, Stage stage, Map map) {
		//Handle the Run button to show the answer
		//Take the inputs of the user and pass them to the new stage

		run.setOnAction(e->{
			String algorithm1 =  algorithm.getSelectionModel().getSelectedItem();
			
			City city1 = map.findCityByName(getScene().getSource().getSelectionModel().getSelectedItem().trim());
			City city2 = map.findCityByName(getScene().getTarget().getSelectionModel().getSelectedItem().trim());

			@SuppressWarnings("unused")
			PathDistanceDisplayCtrl scene1=new PathDistanceDisplayCtrl(city1, city2, stage, map, algorithm1, getGc());
		});
	}
	
	/**
	 * @param cancel
	 */
	private void handle_cancel(Button cancel) {
		//Handle the cancel and exit platform
		cancel.setOnAction(e -> {
			Platform.exit();
		});
	}
	/*
	 * Getters & setters 
	 */

	/**
	 * @return the scene
	 */
	public MapScene getScene() {
		return scene;
	}

	/**
	 * @param scene the scene to set
	 */
	public void setScene(MapScene scene) {
		this.scene = scene;
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
	 * @return the run
	 */
	public Button getRun() {
		return run;
	}

	/**
	 * @param run the run to set
	 */
	public void setRun(Button run) {
		this.run = run;
	}

	/**
	 * @return the target
	 */
	public ComboBox<String> getTarget() {
		return target;
	}

	/**
	 * @param target the target to set
	 */
	public void setTarget(ComboBox<String> target) {
		this.target = target;
	}

	/**
	 * @return the algorithm
	 */
	public ComboBox<String> getAlgorithm() {
		return algorithm;
	}

	/**
	 * @param algorithm the algorithm to set
	 */
	public void setAlgorithm(ComboBox<String> algorithm) {
		this.algorithm = algorithm;
	}

	/**
	 * @return the source
	 */
	public ComboBox<String> getSource() {
		return source;
	}

	/**
	 * @return the gc
	 */
	public GraphicsContext getGc() {
		return gc;
	}

	/**
	 * @param gc the gc to set
	 */
	public void setGc(GraphicsContext gc) {
		this.gc = gc;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(ComboBox<String> source) {
		this.source = source;
	}
}