package model;

import control.MainController;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/*
 * 
 * 		   Sondos Ahmad Aabed
 * 		   1190652
 * 		   Section Number 1
 * 
 * 		In this project a map is implemented using A* algorithm besides the Greedy best first search to reach 
 * 		the best path. Find in the submission files the report that elaborates on the process of 
 * 		developing this map
 *
 * 
 */

public class Main extends Application {
/*
 * This is the Main class in which the project is launched
 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 *@param stgae
	 */
	@Override
	public void start(Stage stage) throws Exception {
		@SuppressWarnings("unused")
		MainController mainctrl = new MainController(stage);
		stage.getIcons().add(new Image("images/logo.png"));
	}
}