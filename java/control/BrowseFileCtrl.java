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
import visualization.BrowseFileScene;

/*
 * This class creates a controller for the browse file scene
 */
public class BrowseFileCtrl {
	// Fields
	private FileChooser fileChooser;
	private File citiesFile;
	
	private Map map;
	private MapCtrl mapCtrl;
	
	private BrowseFileScene BrowseScene;
	private BrowseRoadsFileCtrl browseRoadsFileCtrl;
	
	private GridPane pane;
	private Label label;
	private Button next;
	private Button browse;
	private Button cancel;

	// Constructor
	/**
	 * @param stage
	 */
	public BrowseFileCtrl(Stage stage) {
		initialize(stage);
	}

	// Initialize objects
	/**
	 * @param stage
	 */
	private void initialize(Stage stage) {
		BrowseScene = new BrowseFileScene(stage);
		setPane(BrowseScene.getPane());
		setLabel(BrowseScene.getLabel());
		next = BrowseScene.getNext();
		cancel = BrowseScene.getCancel();
		this.fileChooser = new FileChooser();
		//From the requirment is suppose to input a CSV file 
        fileChooser.getExtensionFilters().add(new ExtensionFilter("CSV Files", "*.csv"));
		browse = BrowseScene.getBrowse();
		handle_browse(browse, stage);
		handle_cancel(cancel);
		setMap(new Map());
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
		//Handle next butotn to proceedd to the next scene
		next2.setOnAction(e -> {
			setBrowseRoadsFileCtrl(new BrowseRoadsFileCtrl(stage, map));
		});
	}

	/**
	 * @param browse2
	 * @param stage
	 */
	private void handle_browse(Button browse2, Stage stage) {
		// Handle browsing button
		browse2.setOnAction(e -> {
			this.citiesFile = fileChooser.showOpenDialog(stage);
			if (citiesFile == (null)) {
				AlertBoxCtrl a = new AlertBoxCtrl("You haven't chose a file yet!", "No file");
				a.show();
			} else {
				GridPane.setHalignment(next, HPos.CENTER);
				ReadingFiles.readCities(citiesFile, getMap());
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
	 * @return the citiesFile
	 */
	public File getCitiesFile() {
		return citiesFile;
	}

	/**
	 * @param citiesFile the citiesFile to set
	 */
	public void setCitiesFile(File citiesFile) {
		this.citiesFile = citiesFile;
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

	/**
	 * @return the browseScene
	 */
	public BrowseFileScene getBrowseScene() {
		return BrowseScene;
	}

	/**
	 * @param browseScene the browseScene to set
	 */
	public void setBrowseScene(BrowseFileScene browseScene) {
		BrowseScene = browseScene;
	}

	/**
	 * @return the browseRoadsFileCtrl
	 */
	public BrowseRoadsFileCtrl getBrowseRoadsFileCtrl() {
		return browseRoadsFileCtrl;
	}

	/**
	 * @param browseRoadsFileCtrl the browseRoadsFileCtrl to set
	 */
	public void setBrowseRoadsFileCtrl(BrowseRoadsFileCtrl browseRoadsFileCtrl) {
		this.browseRoadsFileCtrl = browseRoadsFileCtrl;
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
}