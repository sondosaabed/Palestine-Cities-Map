package control;

import javafx.stage.Stage;

/**
 * This is the Main controller that starts the program
 */
public class MainController {
	// Fields
	Stage stage;
	BrowseFileCtrl scene;

	/*
	 * Construcctor
	 */
	/**
	 * @param stage2
	 */
	public MainController(Stage stage2) {
		showFirstScene(stage2);
	}

	/**
	 * @param stage
	 */
	private void showFirstScene(Stage stage) {
		// This method shows the first scene
		setScene(new BrowseFileCtrl(stage));
	}

	/**
	 * @param browseFileCtrl
	 */
	private void setScene(BrowseFileCtrl browseFileCtrl) {
		this.scene = browseFileCtrl;
	}

}