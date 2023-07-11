package control;

import java.io.File;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import model.Map;
import model.ReadingFiles;
import visualization.BrowseRoadsFileScene;

/*
 * This class creates a controller for the browse file scene
 */
public class BrowseRoadsFileCtrl {
	// Fields
	private FileChooser fileChooser;
	private File roadsFile;
	private BrowseRoadsFileScene scene;
	private BrowseAirDistanceFileCtrl nextScene;
	private GridPane pane;
	private Label label;
	private Button next;
	private Button browse;
	private Button cancel;
	private Map map;
	private MapCtrl mapCtrl;

	// Constructor
	/**
	 * @param stage
	 * @param map
	 */
	public BrowseRoadsFileCtrl(Stage stage, Map map) {
		initialize(stage, map);
	}

	// Initialize objects
	/**
	 * @param stage
	 * @param map
	 */
	private void initialize(Stage stage, Map map) {
		scene = new BrowseRoadsFileScene(stage);
		setPane(scene.getPane());
		setLabel(scene.getLabel());
		next = scene.getNext();
		cancel = scene.getCancel();
		this.fileChooser = new FileChooser();
		//From the requirment is suppose to input a CSV file 
        fileChooser.getExtensionFilters().add(new ExtensionFilter("CSV Files", "*.csv"));
        browse = scene.getBrowse();
		handle_browse(browse, stage);
		handle_cancel(cancel);
		setMap(map);
	}

	/*
	 * Handlers
	 */
	/**
	 * @param cancel2
	 */
	private void handle_cancel(Button cancel2) {
		// Handle the button cancel
		cancel2.setOnAction(e -> {
			Platform.exit();
		});
	}
	/**
	 * @param next2
	 * @param stage
	 */
	private void handle_next(Button next2, Stage stage) {
		//Show the next scene to handle the next button
		next2.setOnAction(e -> {
			setNextScene(new BrowseAirDistanceFileCtrl(stage,map));
		});
	}

	/**
	 * @param browse2
	 * @param stage
	 */
	private void handle_browse(Button browse2, Stage stage) {
		// Handle browsing button
		browse2.setOnAction(e -> {
			this.roadsFile = fileChooser.showOpenDialog(stage);
			if (roadsFile == (null)) {
				AlertBoxCtrl a = new AlertBoxCtrl("You haven't chose a file yet!", "No file");
				a.show();
			} else {
				GridPane.setHalignment(next, HPos.CENTER);
				ReadingFiles.readRoads(roadsFile, getMap());
				pane.add(next, 3, 1);
				handle_next(next, stage);
				label.setText("            Click next to proceed...");
			}
		});
	}

	/*
	 * Getters and Setters
	 */
	/**
	 * @return the fileChooser
	 */
	public FileChooser getFileChooser() {
		return fileChooser;
	}

	/**
	 * @param fileChooser the fileChooser to set
	 */
	public void setFileChooser(FileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}

	/**
	 * @return the roadsFile
	 */
	public File getRoadsFile() {
		return roadsFile;
	}

	/**
	 * @param roadsFile the roadsFile to set
	 */
	public void setRoadsFile(File roadsFile) {
		this.roadsFile = roadsFile;
	}

	/**
	 * @return the scene
	 */
	public BrowseRoadsFileScene getScene() {
		return scene;
	}

	/**
	 * @param scene the scene to set
	 */
	public void setScene(BrowseRoadsFileScene scene) {
		this.scene = scene;
	}

	/**
	 * @return the nextScene
	 */
	public BrowseAirDistanceFileCtrl getNextScene() {
		return nextScene;
	}

	/**
	 * @param nextScene the nextScene to set
	 */
	public void setNextScene(BrowseAirDistanceFileCtrl nextScene) {
		this.nextScene = nextScene;
	}

	/**
	 * @return the pane
	 */
	public GridPane getPane() {
		return pane;
	}

	/**
	 * @param pane the pane to set
	 */
	public void setPane(GridPane pane) {
		this.pane = pane;
	}

	/**
	 * @return the label
	 */
	public Label getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(Label label) {
		this.label = label;
	}

	/**
	 * @return the next
	 */
	public Button getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Button next) {
		this.next = next;
	}

	/**
	 * @return the browse
	 */
	public Button getBrowse() {
		return browse;
	}

	/**
	 * @param browse the browse to set
	 */
	public void setBrowse(Button browse) {
		this.browse = browse;
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

}